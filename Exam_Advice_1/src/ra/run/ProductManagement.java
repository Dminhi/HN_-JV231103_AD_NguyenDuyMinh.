package ra.run;

import ra.model.Catalog;
import ra.model.Product;
import ra.service.IProductService;
import ra.service.ProductService;
import util.InputMethods;

import java.util.Collections;
import java.util.List;

public class ProductManagement {
    public static ProductService productService = new ProductService();
    public static void productController() {
        while (true) {
            System.out.println("********************PRODUCT-MANAGEMENT********************");
            System.out.println("1. Nhập số sản sản phẩm và nhập thông tin sản phẩm");
            System.out.println("2. Hiển thị thông tin các sản phẩm");
            System.out.println("3. Sắp xếp sản phẩm theo giá giảm dần");
            System.out.println("4. Xóa sản phẩm theo mã");
            System.out.println("5. Tìm kiếm sách theo tên sách");
            System.out.println("6. Thay đổi thông tin của sách theo mã sách");
            System.out.println("7. Quay lai");
            byte choice = InputMethods.getByte();
            switch (choice) {
                case 1:
                    addNewProducts();
                    break;
                case 2:
                    displayProduct();
                    break;
                case 3:
                    sort();
                    break;
                case 4:
                    deleteProduct();
                    break;
                case 5:
                    findProduct();
                    break;
                case 6:
                    updateProduct();
                    break;
                case 7:
                    System.out.println("Quay lai");
                    return;
                default:
                    System.out.println("Mời nhập lại");
            }
        }
    }
    public static void addNewProducts() {
        System.out.println("Số lượng sản phẩm cần thêm");
        byte quantity = InputMethods.getByte();
        for (int i = 1; i <= quantity; i++) {
            System.out.println("Nhập thông tin sản phẩm thứ " + i);
            Product newProduct = new Product();
            newProduct.inputData(true);
            productService.save(newProduct);
            System.out.println();
        }
        System.out.println("Đã thêm mới " + quantity + " danh mục");
    }
    public static void displayProduct(){
        if (productService.getAll().isEmpty()){
            System.err.println("Danh sách rỗng");
            return;
        }
        productService.getAll().forEach(Product::displayData);
    }
    public static void updateProduct(){
        System.out.println("Nhập id danh muc cần sửa");
        String idProduct = InputMethods.getString();
        Product editProduct = productService.findById(idProduct);
        if (editProduct == null){
            System.err.println("Không tồn tại id");
            return;
        }
        System.out.println("Thông tin danh sách cũ");
        editProduct.displayData();
        System.out.println("Nhập thông tin mới");
        editProduct.inputData(false);
        productService.save(editProduct);
        System.out.println("Cập nhật thành công");
    }
    public static void deleteProduct(){
        System.out.println("Nhập id danh muc cần xoá");
        String idProduct = InputMethods.getString();
        Product deleteCatalog = productService.findById(idProduct);
        if (deleteCatalog==null){
            System.out.println("Không tồn tại id");
            return;
        }
        productService.delete(idProduct);
        System.out.println("Xoá thành công");

    }
    public static void findProduct(){
        System.out.println("Nhập id sản phẩm cần tìm");
        String idProduct = InputMethods.getString();
        Product findProduct = productService.findById(idProduct);
        if (findProduct == null){
            System.err.println("Không tồn tại id");
            return;
        }
        findProduct.displayData();
    }
    public static void sort(){
        ProductService.sortProduct();
        productService.getAll().forEach(Product::displayData);
    }
}
