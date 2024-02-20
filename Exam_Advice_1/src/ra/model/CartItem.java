package ra.model;

import ra.service.CatalogService;
import ra.service.ProductService;
import util.InputMethods;

import java.util.ArrayList;
import java.util.List;

public class CartItem {
    private double price;
    private int quantity;
    private int cartItemId;
    private Product product;
    public CartItem() {
    }

    public CartItem(double price, int quantity, int cartItemId, Product product) {
        this.price = price;
        this.quantity = quantity;
        this.cartItemId = cartItemId;
        this.product = product;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public int getCartItemId() {
        return cartItemId;
    }

    public void setCartItemId(int cartItemId) {
        this.cartItemId = cartItemId;
    }

    public Product getProduct() {
        return product;
    }

    public void setProduct(Product product) {
        this.product = product;
    }

    @Override
    public String toString() {
        return "CartItem[" +
                "price : " + this.product.getProductPrice() +
                ", quantity : " + quantity +
                ", cartItemId : " + cartItemId +
                ", product : " + product.getProductName() +
                ']';
    }
    public void inputData(boolean isAdd){
        System.out.println("Nhập id giỏ hàng");
        this.cartItemId = InputMethods.getInteger();
        System.out.println("Danh sách sản phẩm ");
        ProductService productService = new ProductService();
        productService.getAll().forEach(Product::displayData);
        System.out.println("Nhập id danh muc sách");
        String idProduct = InputMethods.getString();
        for (Product c : productService.getAll()) {
            if (c.getProductId().equals(idProduct)) {
                this.product=c;
            }
        }

        System.out.println("Nhập số lượng sản phẩm");

        int quantity = InputMethods.getInteger();
        if(quantity>this.product.getStock()){
            System.out.println("Không đủ sản phẩm trong kho");
        }
        else {
            List<Product> list = ProductService.productList;
            for (Product product : list) {
                if(product.equals(this.product)){
                    product.setStock(product.getStock()-quantity);
                }
            }
            ProductService.productList = list;
        }
    }
}
