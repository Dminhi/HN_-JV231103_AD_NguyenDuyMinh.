package ra.service;

import ra.model.CartItem;
import ra.model.Catalog;

import java.util.ArrayList;
import java.util.List;

public class CartService implements ICartService {
    public static List<CartItem> cartItemList = new ArrayList<>();

    @Override
    public List<CartItem> getAll() {
        return cartItemList;
    }

    @Override
    public CartItem findById(Integer s) {
        return cartItemList.stream().filter(e->e.getCartItemId()==s).findFirst().orElse(null);

    }

    @Override
    public void save(CartItem cartItem) {
        if (findById(cartItem.getCartItemId()) == null) {
            // Thêm mới
            cartItemList.add(cartItem);
        } else {
            // Cập nhât
            cartItemList.set(cartItemList.indexOf(findById(cartItem.getCartItemId())), cartItem);
        }
    }

    @Override
    public void delete(Integer s)  {
        cartItemList.remove(findById(s));
    }

}
