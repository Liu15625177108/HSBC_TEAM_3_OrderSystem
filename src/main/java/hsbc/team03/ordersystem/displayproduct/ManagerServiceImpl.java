package hsbc.team03.ordersystem.displayproduct;

import hsbc.team03.ordersystem.displayproduct.common.CommonTool;
import hsbc.team03.ordersystem.displayproduct.common.DataCheckTool;
import hsbc.team03.ordersystem.displayproduct.common.DataUtils;
import hsbc.team03.ordersystem.displayproduct.common.UUIDUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
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
    public List<Product> productList() {
        /*get products from database  managerRepository.fillAll()*/
        return managerRepository.findAll();
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
        /*check the data whether in a rule*/
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
                    /* *//*if save fail,then managerRepository operation database return null,so it will return false*//*
                if (product == null) {
                    tag = false;
                    return tag;
                }*/
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
