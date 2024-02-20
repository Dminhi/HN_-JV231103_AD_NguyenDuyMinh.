package ra.model;

import ra.service.CatalogService;
import util.InputMethods;
import util.Validation;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Product {
    private String productId, productName, description;
    private double productPrice;
    private int stock;
    private Catalog catalog;


    public String getProductId() {
        return productId;
    }

    public void setProductId(String productId) {
        this.productId = productId;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public double getProductPrice() {
        return productPrice;
    }

    public void setProductPrice(double productPrice) {
        this.productPrice = productPrice;
    }

    public int getStock() {
        return stock;
    }

    public void setStock(int stock) {
        this.stock = stock;
    }


    public boolean isStatus() {
        return status;
    }

    public void setStatus(boolean status) {
        this.status = status;
    }

    private boolean status;

    public Product() {
    }

    public Product(String productId, String productName, String description, double productPrice, int stock, Catalog catalog, boolean status) {
        this.productId = productId;
        this.productName = productName;
        this.description = description;
        this.productPrice = productPrice;
        this.stock = stock;
        this.status = true;
    }

    public Catalog getCatalog() {
        return catalog;
    }

    public void inputData(boolean isAdd) {
        if (isAdd) {
            while (true) {
                System.out.println("Nhập id sản phẩm");
                this.productId = InputMethods.getString();
                if (Validation.isValidString(productId)) {
                    break;
                } else {
                    System.out.println("Nhập không đúng mới nhập lại");

                }
            }
        }
        while (true) {
            System.out.println("Nhập tên sản phẩm");
            this.productName = InputMethods.getString();
            if (Validation.isValidInput(productName)) {
                break;
            } else {
                System.out.println("Nhập không đúng mới nhập lại");

            }
        }
        System.out.println("Nhập chi tiết sản phẩm");
        this.description = InputMethods.getString();
        while (true) {
            System.out.println("Nhập giá sản phẩm");
            this.productPrice = InputMethods.getDouble();
            if (Validation.isValidInterger(productPrice)) {
                break;
            } else {
                System.out.println("Nhập không đúng mới nhập lại");

            }
        }

        System.out.println("Danh sách danh mục ");
        CatalogService catalogList = new CatalogService();
        catalogList.getAll().forEach(Catalog::displayData);
        System.out.println("Nhập id danh muc sách");
        int idCatalog = InputMethods.getInteger();
        for (Catalog c : catalogList.getAll()) {
            if (c.getCatalogId() == idCatalog) {
                this.catalog = c;
            }
        }

        while (true) {

            System.out.println("Nhập số lượng sản phẩm");
            this.stock = InputMethods.getInteger();
            if (Validation.isValidNumber(stock)) {
                break;
            } else {
                System.out.println("Nhập không đúng mới nhập lại");
            }
        }
    }

    public void displayData() {
        System.out.println("----------------------------------------------------------------------------------------");
        System.out.printf("| %4s | %10s | %10s | %10s | %10s | %15s | %4s | \n", productId, productName, catalog.getCatalogName(), productPrice, stock, description, status);
    }

}

