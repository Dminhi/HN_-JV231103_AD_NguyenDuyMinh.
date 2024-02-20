package ra.model;

import util.InputMethods;

public class Catalog {
    private int catalogId;
    private String catalogName, descriptions;

    public Catalog() {
    }

    public Catalog(int catalogId, String catalogName, String descriptions) {
        this.catalogId = catalogId;
        this.catalogName = catalogName;
        this.descriptions = descriptions;
    }

    public int getCatalogId() {
        return catalogId;
    }

    public void setCatalogId(int catalogId) {
        this.catalogId = catalogId;
    }

    public String getCatalogName() {
        return catalogName;
    }

    public void setCatalogName(String catalogName) {
        this.catalogName = catalogName;
    }

    public String getDescriptions() {
        return descriptions;
    }

    public void setDescriptions(String descriptions) {
        this.descriptions = descriptions;
    }

    @Override
    public String toString() {
        return "Catalog[" +
                "catalogId : " + catalogId +
                ", catalogName : '" + catalogName + '\'' +
                ", descriptions :'" + descriptions + '\'' +
                ']';
    }
    public void displayData() {
        System.out.println("----------------------------------------------------------------------------------------");
        System.out.printf("| %4s | %10s | %15s | \n", catalogId, catalogName, descriptions);
    }

    public void inputData(boolean isAdd) {
        if(isAdd){
        System.out.println("Nhập Id sản phẩm");
        this.catalogId = InputMethods.getInteger();}
        System.out.println("Nhập tên danh muc");
        this.catalogName = InputMethods.getString();
        System.out.println("Nhập chi tiết danh muc");
        this.descriptions = InputMethods.getString();
    }
}
