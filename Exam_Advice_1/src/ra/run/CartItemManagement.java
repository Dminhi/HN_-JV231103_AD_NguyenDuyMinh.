package ra.run;

import ra.model.CartItem;
import ra.model.Catalog;
import ra.model.Product;
import ra.service.*;
import util.InputMethods;

import java.util.List;

public class CartItemManagement {
    public static ICartService cartService = new CartService();

    public static void cartItemController() {
        ProductService productService = new ProductService();
        while (true) {
            System.out.println("1: hiển thị danh sách tất cả sản phẩm đang được bán của cửa hàng");
            System.out.println("2: thêm mới 1 sản phẩm vào giỏ hàng dựa theo mã sản phẩm mà người dùng" +
                    "nhập vào");
            System.out.println("3: hiển thị danh sách giỏ hàng");
            System.out.println("4: cập nhật số lượng sản phẩm muốn mua theo trường cartItemId");
            System.out.println("5: xóa 1 sản phẩm ra khỏi giỏ hàng theo cartItemId");
            System.out.println("Chọn 6: xóa toàn bộ sản phẩm trong trong giỏ hàng. ");
            System.out.println("Chọn 7: Quay lại");
            byte choice = InputMethods.getByte();
            switch (choice) {
                case 1:
                    productService.getAll().forEach(Product::displayData);
                    break;
                case 2:
                    addNewCartItems();
                    break;
                case 3:
                    displayCartItem();
                    break;
                case 4:
                    updateCartItem();
                    break;
                case 5:
                    deleteCartItem();
                    break;
                case 6:
                    CartService.cartItemList.clear();
                    break;
                case 7:
                    return;
            }
        }
    }
    public static void addNewCartItems() {
        System.out.println("Số lượng giỏ hàng cần thêm");
        byte quantity = InputMethods.getByte();
        for (int i = 1; i <= quantity; i++) {
            System.out.println("Nhập thông tin giỏ hàng thứ " + i);
            CartItem newCartItem = new CartItem();
            newCartItem.inputData(true);
            cartService.save(newCartItem);
            System.out.println();
        }
        System.out.println("Đã thêm mới " + quantity + "giỏ hàng");
    }
    public static void deleteCartItem(){
        System.out.println("Nhập id CartItem cần xoá");
        int idCart = InputMethods.getInteger();
        CartItem deleteCartItem = cartService.findById(idCart);
        if (deleteCartItem==null){
            System.out.println("Không tồn tại id");
            return;
        }
        cartService.delete(idCart);
        System.out.println("Xoá thành công");
    }
    public static void updateCartItem() {
        System.out.println("Nhập id giỏ hàng cần sửa");
        int idCartItem = InputMethods.getInteger();
        CartItem editCartItem = cartService.findById(idCartItem);
        if (editCartItem == null) {
            System.err.println("Không tồn tại id");
            return;
        }
        System.out.println("Thông tin danh sách cũ");
        System.out.println(editCartItem);
        System.out.println("Nhập thông tin mới");
        editCartItem.inputData(false);
        cartService.save(editCartItem);
        System.out.println("Cập nhật thành công");
    }
    public static void displayCartItem(){
        if (cartService.getAll().isEmpty()){
            System.err.println("Danh sách rỗng");
            return;
        }
        List<CartItem> cartItemList = CartService.cartItemList;
        for (CartItem cartItem : cartItemList) {
            System.out.println(cartItem);
        }
    }
}
