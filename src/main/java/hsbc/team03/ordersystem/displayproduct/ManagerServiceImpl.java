package hsbc.team03.ordersystem.displayproduct;

import hsbc.team03.ordersystem.displayproduct.common.*;
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
        PageableTool pageableTool=new PageableTool();
        Specification<Product> specification=pageableTool.specifucation(productType);
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

        boolean tag = false;
        String flage = "0";
        String checkProductId="";
        String uploadFileName = "img/logo-symbol.png";
        /*check the data whether in a rule*/
            boolean checkDataBoolean = commonTool.checkData(product);
            if (checkDataBoolean) {
                /*check the Icon's format of .jpeg .png .gif and upload icon*/
                if (file!=null){
                    uploadFileName = dataCheckTool.checkIconAndUploadIcon(file);
                }
                if (!flage.equals(uploadFileName)) {
                    /*check the productCode of unique*/
                    List<Product> products = managerRepository.findByStatus(1);
                    tag = commonTool.checkUniqueOfProduct(product, products);
                    /*if the productCode is unique,allow add product*/
                    if (tag) {
                        /*save the production to database*/
                        if(checkProductId.equals(product.getId())){
                            product.setId(UUIDUtils.getUUID());
                        }
                        product.setIcon(uploadFileName);
                        managerRepository.save(product);
                    }
                }
        }

        return tag;
    }

    @Override
    public int deleteProductByProductId(Product product) {
        int n = 0;
        String msg = "delete product's of code = " + product.getProductCode()+"and product's id= "+product.getId();
        /*judge the of current time and product's dueDate,if current'time not in the rang of dueDate ,can't not delete product*/
        DataUtils dataUtils = new DataUtils();
        boolean tag = dataUtils.compareCurrentTimeAndDueDate(product);
        if (tag) {
            Product pro=managerRepository.findByid(product.getId());
            pro.setStatus(0);
            managerRepository.save(pro);
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
        boolean checkDataBoolean = commonTool.checkData(product);
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

    @Override
    public List<Product> findByProductCodeOrProductName(String productCode,String productName) {
        return managerRepository.findByProductCodeOrProductName(productCode,productName);
    }

}
