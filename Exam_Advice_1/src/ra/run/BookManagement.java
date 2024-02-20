package ra.run;

import util.InputMethods;

public class BookManagement {
    public static void main(String[] args) {
        while (true) {
            System.out.println("---------Menu-----------");
            System.out.println("0. Thoát");
            System.out.println("1. Quản lý danh mục");
            System.out.println("2. Quản lý sản phẩm");
            System.out.println("3. Người dùng");
            System.out.println("Nhập chức năng");
            byte choice = InputMethods.getByte();
            switch (choice) {
                case 0:
                    System.out.println("Thoát chương trình");
                    return;
                case 1:
                    CatalogManagement.catalogController();
                    break;
                case 2:
                    ProductManagement.productController();
                    break;
                case 3:
                    CartItemManagement.cartItemController();
                default:
                    System.out.println("Mời nhập lại");
            }
        }
    }
}
