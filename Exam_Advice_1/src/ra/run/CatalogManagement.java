package ra.run;

import ra.model.Catalog;
import ra.service.CatalogService;
import ra.service.ICatalogService;
import util.InputMethods;

public class CatalogManagement {
    public static ICatalogService catalogService = new CatalogService();

    public static void catalogController() {
        while (true) {
            System.out.println("********************CATALOG-MANAGEMENT********************");
            System.out.println("1. Nhập số danh mục thêm mới và nhập thông tin cho từng danh mục");
            System.out.println("2. Hiển thị thông tin tất cả các danh mục");
            System.out.println("3. Sửa tên danh mục theo mã danh mục");
            System.out.println("4. Xóa danh muc theo mã danh mục (lưu ý ko xóa khi có sản phẩm)");
            System.out.println("5. Quay lại");
            byte choice = InputMethods.getByte();
            switch (choice) {
                case 1:
                    addNewCatalogs();
                    break;
                case 2:
                    displayCatalog();
                    break;
                case 3:
                    updateCatalog();
                    break;
                case 4:
                    deleteCatalog();
                    break;
                case 5:
                    System.out.println("Thoát chương trình");
                    return;
                default:
                    System.out.println("Mời nhập lại");
            }
        }

    }

    public static void addNewCatalogs() {
        System.out.println("Số lượng danh mục cần thêm");
        byte quantity = InputMethods.getByte();
        for (int i = 1; i <= quantity; i++) {
            System.out.println("Nhập thông tin danh mục thứ " + i);
            Catalog newCatalog = new Catalog();
            newCatalog.inputData(true);
            catalogService.save(newCatalog);
            System.out.println();
        }
        System.out.println("Đã thêm mới " + quantity + " danh mục");
    }

    public static void displayCatalog() {
        if (catalogService.getAll().isEmpty()) {
            System.err.println("Danh sách rỗng");
            return;
        }
        catalogService.getAll().forEach(Catalog::displayData);
    }

    public static void updateCatalog() {
        System.out.println("Nhập id danh muc cần sửa");
        int idCatalog = InputMethods.getInteger();
        Catalog editCatalog = catalogService.findById(idCatalog);
        if (editCatalog == null) {
            System.err.println("Không tồn tại id");
            return;
        }
        System.out.println("Thông tin danh sách cũ");
        editCatalog.displayData();
        System.out.println("Nhập thông tin mới");
        editCatalog.inputData(false);
        catalogService.save(editCatalog);
        System.out.println("Cập nhật thành công");
    }

    public static void deleteCatalog() {
        System.out.println("Nhập id danh muc cần xoá");
        int idCatalog = InputMethods.getInteger();
        Catalog deleteCatalog = catalogService.findById(idCatalog);
        if (deleteCatalog == null) {
            System.out.println("Không tồn tại id");
            return;
        }
        catalogService.delete(idCatalog);
        System.out.println("Xoá thành công");

    }
}
