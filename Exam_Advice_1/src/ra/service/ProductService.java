package ra.service;

import ra.model.Product;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class ProductService implements IProductService {
    public static List<Product> productList = new ArrayList<>();

    @Override
    public List<Product> getAll() {
        return productList;
    }

    @Override
    public Product findById(String s) {
        return productList.stream().filter(e -> e.getProductId().equals(s)).findFirst().orElse(null);
    }

    @Override
    public void save(Product product) {
        if (findById(product.getProductId()) == null) {
            // Thêm mới
            productList.add(product);
        } else {
            // Cập nhât
            productList.set(productList.indexOf(findById(product.getProductId())), product);
        }
    }

    @Override
    public void delete(String s) {
        productList.remove(findById(s));
    }
    public static void sortProduct(){
        productList.sort((p1, p2) -> Double.compare(p2.getProductPrice(), p1.getProductPrice()));
    }
}

