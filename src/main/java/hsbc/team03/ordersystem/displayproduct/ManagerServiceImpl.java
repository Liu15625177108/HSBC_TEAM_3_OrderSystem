package hsbc.team03.ordersystem.displayproduct;

import hsbc.team03.ordersystem.displayproduct.common.CommonTool;
import hsbc.team03.ordersystem.displayproduct.common.DataCheckTool;
import hsbc.team03.ordersystem.displayproduct.common.DataUtils;
import hsbc.team03.ordersystem.displayproduct.common.UUIDUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import javax.persistence.criteria.*;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 * @Author:Evan
 * @Date:2018/8/2 14:49
 * @Describe：
 * @Return:
 * @Param:
 */
@Service
public class ManagerServiceImpl implements ManagerService {
    private final ProductTypeRepository productTypeRepository;
    private final SystemLogRepository systemLogRepository;
    private final ManagerRepository managerRepository;
    private final DataCheckTool dataCheckTool;
    CommonTool commonTool = new CommonTool();

    /**
     * the ManagerServiceImpl constructor  is to init managerRepository
     */
    @Autowired
    public ManagerServiceImpl(ProductTypeRepository productTypeRepository, ManagerRepository managerRepository, SystemLogRepository systemLogRepository, DataCheckTool dataCheckTool) {
        this.productTypeRepository = productTypeRepository;
        this.managerRepository = managerRepository;
        this.systemLogRepository = systemLogRepository;
        this.dataCheckTool = dataCheckTool;
    }

    /**
     * @Description: get products
     * @Author: @Evan
     * @CreateDate: 2018/8/5 22:08
     * @UpdateDate: 2018/8/5 22:08
     * @Version: 1.0
     */
    @Override
    public Page<Product> getProductListByPage(int page, String productType, int count, Sort sort) {
        Specification<Product> specification = new Specification<Product>() {
            @Override
            public Predicate toPredicate(Root<Product> root, CriteriaQuery<?> query, CriteriaBuilder criteriaBuilder) {
                List<Predicate> predicates = new ArrayList<Predicate>();
                Path<Long> status = root.get("status");
                Predicate predicate = criteriaBuilder.equal(status, 1);
                predicates.add(predicate);
                Path<Long> path = root.get("productType");
                Predicate predicate1 = criteriaBuilder.equal(path, productType);
                predicates.add(predicate1);
                return criteriaBuilder.and(predicates
                        .toArray(new Predicate[] {}));
            }
        };

        Pageable pageable = PageRequest.of(page, count, sort);
        return managerRepository.findAll(specification, pageable);
    }

    /**
     * @Description: add products
     * @Author: @Evan
     * @CreateDate: 2018/8/5 22:08
     * @UpdateDate: 2018/8/5 22:08
     * @Version: 1.0
     */
    @Override
    public boolean addProduct(Product product, MultipartFile file) throws IOException {
        System.out.println("产品"+product.getId()+"=id");
        boolean tag = false;
        String flage = "0";
        /*it use to judge modify product or add product*/
        String judgeProductId="";
        /*check the data whether in a rule*/
        /*如果是修改产品信息，产品的id一定不为空*/
        if(!judgeProductId.equals(product.getId())){
            modifyProduct(product,file);
        } else {
            /*set the product's id*/
            boolean checkDataBoolean = commonTool.checkData(product, file);
            if (checkDataBoolean) {
                /*check the Icon's format of .jpeg .png .gif and upload icon*/
                String uploadFileName = dataCheckTool.checkIconAndUploadIcon(file);
                if (!flage.equals(uploadFileName)) {
                    /*check the productCode of unique*/
                    List<Product> products = managerRepository.findByStatus(1);
                    tag = commonTool.checkUniqueOfProduct(product, products);
                    /*if the productCode is unique,allow add product*/
                    if (tag) {
                        /*save the production to database*/
                        product.setId(UUIDUtils.getUUID());
                        product.setStatus(1);
                        product.setIcon(uploadFileName);
                        managerRepository.save(product);
                    }
                }

            }
        }

        return tag;
    }

    @Override
    public int deleteProductByProductCode(Product product) {
        int n = 0;
        String msg = "delete product's of code =" + product.getProductCode();
        /*judge the of current time and product's dueDate,if current'time not in the rang of dueDate ,can't not delete product*/
        DataUtils dataUtils = new DataUtils();
        boolean tag = dataUtils.compareCurrentTimeAndDueDate(product);
        if (tag) {
            product.setStatus(0);
            managerRepository.save(product);
            /*if manager modify the production information,it should be recording*/
            SystemLog systemLog = new SystemLog();
            commonTool.setLog(systemLog);
            systemLog.setOperation(msg);
            systemLogRepository.save(systemLog);
            n = 1;
        }
        return n;
    }

    @Override
    public boolean modifyProduct(Product product, MultipartFile file) throws IOException {
        boolean tag = false;
        String msg = "";
        /**check the productCode unique*/
        Product compareProduct = managerRepository.findByid(product.getId());
        CommonTool commonTool = new CommonTool();
        boolean checkDataBoolean = commonTool.checkData(product, file);
        if (checkDataBoolean) {
            List<Product> products = managerRepository.findByStatus(1);
            msg = commonTool.getMessage(product, compareProduct);
            tag = commonTool.checkUniqueOfProduct(product, products);
            if (tag) {
                managerRepository.saveAndFlush(product);
                SystemLog systemLog = new SystemLog();
                commonTool.setLog(systemLog);
                systemLog.setOperation(msg);
                systemLogRepository.save(systemLog);
            }
        }
        return tag;
    }

    @Override
    public List<ProductType> getProductType() {
        return productTypeRepository.findAll();
    }

}
