package hsbc.team03.ordersystem.displayproduct;

import hsbc.team03.ordersystem.displayproduct.common.DataUtils;
import hsbc.team03.ordersystem.displayproduct.common.UUIDUtils;
import hsbc.team03.ordersystem.displayproduct.Log;
import hsbc.team03.ordersystem.displayproduct.Product;
import hsbc.team03.ordersystem.displayproduct.ManagerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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
    @Override
    public List<Product> productList() {
        Product product1 = new Product("ewfsdgsrhdfgxvadfgsfnxzdz1", "200701", "中非让", 20.8, "稳", "这是一个", "http://8080", "2018-7-1", "2018-8-10", "2018-7-3", 1);
        Product product2 = new Product("ewfsdgsrhdfgxvadfgsfnxzdz2", "200701", "中非让", 20.8, "稳", "这是一个", "http://8080", "2018-7-1", "2018-8-10", "2018-7-3", 1);
        Product product3 = new Product("ewfsdgsrhdfgxvadfgsfnxzdz3", "200701", "中非让", 20.8, "稳", "这是一个", "http://8080", "2018-7-1", "2018-8-10", "2018-7-3", 1);
        List<Product> list=new ArrayList<>();
        list.add(product1);
        list.add(product2);
        list.add(product3);
        return list;
    }

    @Override
    public boolean addProduct(Product product) {
        return false;
    }

    @Override
    public int deleteProductByProductCode(Product product) {
        return 0;
    }

    @Override
    public boolean modifyProduct(Product product) {
        return false;
    }






    /*   private final LogRepository logRepository;
    private final ManagerRepository managerRepository;

    *//**
     * the ManagerServiceImpl constructor  is to init managerRepository
     *//*
    @Autowired
    public ManagerServiceImpl(ManagerRepository managerRepository, LogRepository logRepository) {
        this.managerRepository = managerRepository;
        this.logRepository = logRepository;
    }

    *//**
     * @Description: get products
     * @Author: @Evan
     * @CreateDate: 2018/8/5 22:08
     * @UpdateDate: 2018/8/5 22:08
     * @Version: 1.0
     *//*
    @Override
    public List<Product> productList() {
        *//*get products from database  managerRepository.fillAll()*//*
        return managerRepository.findAll();
    }

    *//**
     * @Description: add products
     * @Author: @Evan
     * @CreateDate: 2018/8/5 22:08
     * @UpdateDate: 2018/8/5 22:08
     * @Version: 1.0
     *//*
    @Override
    public boolean addProduct(Product product) {

        boolean tag;
        *//*check the product's code unique*//*
        tag = checkUniqueOfProduct(product);
        *//*if the productCode is unique,allow add product*//*
        if (tag) {
            *//*save the production to database*//*
            product = managerRepository.save(product);
            *//*if save fail,then managerRepository operation database return null,so it will return false*//*
            if (product == null) {
                tag = false;
                return tag;
            }
        }
        return tag;
    }

    @Override
    public int deleteProductByProductCode(Product product) {
        int n = 0;
        String msg = "delete product's of code =" + product.getProductCode();
        *//*judge the of current time and product's dueDate,if current'time not in the rang of dueDate ,can't not delete product*//*


        DataUtils dataUtils = new DataUtils();
        boolean tag = dataUtils.compareTime(product);
        if (tag) {
            product.setStatus(0);
            managerRepository.save(product);
            *//*if manager modify the production information,it should be recording*//*
            Log log = new Log();
            setLog(log, product);
            log.setOperation(msg);
            logRepository.save(log);
            n = 1;
        }
        return n;
    }

    @Override
    public boolean modifyProduct(Product product) {
        boolean tag;
        String msg = "";
        *//**check the productCode unique*//*
        Product compareProduct = managerRepository.findByid(product.getId());
        if (!(compareProduct.getProductCode().equals(product.getProductCode()))) {
            msg = "Changed the original product code ="+compareProduct.getProductCode()+" to " +product.getProductCode();
        }
        if (!(compareProduct.getName().equals(product.getName()))) {
            msg = "Changed the original product name ="+compareProduct.getName()+" to "+product.getName();
        }
        if (compareProduct.getPrice() != product.getPrice()) {
            msg = "Changed the original product price ="+compareProduct.getPrice();
        }
        if (compareProduct.getPrice() != product.getPrice() && !(compareProduct.getName().equals(product.getName()))) {
            msg = "Changed the original product price and name="+compareProduct.getPrice()+" "+compareProduct.getName()+"to"+product.getName()+" "+product.getPrice()+" where origin'produceCode is"+compareProduct.getProductCode();
        }
        if (compareProduct.getPrice() != product.getPrice() && !(compareProduct.getProductCode().equals(product.getProductCode()))) {
            msg = "Changed the original product price and produceCode="+compareProduct.getPrice()+" "+compareProduct.getProductCode()+"to"+product.getProductCode()+" "+product.getPrice();
        }
        if (!(compareProduct.getName().equals(product.getName())) && !(compareProduct.getProductCode().equals(product.getProductCode()))) {
            msg = "Changed the original product name and productCode ="+compareProduct.getName()+" "+compareProduct.getProductCode()+"to "+product.getName()+" "+product.getProductCode();
        }
        if (!(compareProduct.getName().equals(product.getName())) && !(compareProduct.getProductCode().equals(product.getProductCode())) && compareProduct.getPrice() != product.getPrice()) {
            msg = "modify product's name、code and price of product' code ="+compareProduct.getName()+"、"+compareProduct.getProductCode()+"、"+compareProduct.getPrice()+" of origin information is "+product.getName()+"、"+ product.getProductCode()+"、"+product.getPrice();
        }
        tag = checkUniqueOfProduct(product);
        if (tag) {
            managerRepository.saveAndFlush(product);
            Log log = new Log();
            setLog(log, product);
            log.setOperation(msg);
            logRepository.save(log);

        }
        return tag;
    }

    *//**
     * @Description: the method check productCode whether exist,if it exist,return true,else return false
     * @Author: @Evan
     * @CreateDate: 2018/8/5 22:10
     * @UpdateDate: 2018/8/5 22:10
     * @Version: 1.0
     *//*
    public boolean checkUniqueOfProduct(Product product) {
        *//*先得到所有产品的唯一属性：产品代码：productCode、产品名：name*//*
        boolean tag = true;
        List<Product> products = managerRepository.findByStatus(1);
        if (products != null) {
            for (int i = 0; i < products.size(); i++) {
                if (product.getProductCode().equals(products.get(i).getProductCode())&&product.getName().equals(products.get(i).getName())) {
                    tag = false;
                    return tag;
                }
                if(!(product.getName().equals(products.get(i).getName()))&&product.getProductCode().equals(products.get(i).getProductCode())){
                    tag = true;
                    return tag;
                }
            }
        }
        return tag;
    }

    public void setLog(Log log, Product product) {
        DataUtils dataUtils = new DataUtils();
        log.setTime(dataUtils.getCurrentTime());
        log.setName("admin");
        log.setId(UUIDUtils.getUUID());
       }
*/
}
