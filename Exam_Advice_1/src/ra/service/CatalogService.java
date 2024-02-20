package ra.service;

import ra.model.Catalog;
import ra.model.Product;

import java.util.ArrayList;
import java.util.List;

public class CatalogService implements ICatalogService{
    static  List<Catalog> catalogList = new ArrayList<>();

    public CatalogService() {
    }

    @Override
    public List<Catalog> getAll() {

        return catalogList;
    }

    @Override
    public Catalog findById(Integer integer) {
        return catalogList.stream().filter(e->e.getCatalogId()==integer).findFirst().orElse(null);
    }

    @Override
    public void save(Catalog catalog) {
        if(findById(catalog.getCatalogId())==null){
            // Thêm mới
            catalogList.add(catalog);
        }
        else {
            // Cập nhât
            catalogList.set(catalogList.indexOf(findById(catalog.getCatalogId())),catalog);
        }

    }

    @Override
    public void delete(Integer integer) {
        catalogList.remove(findById(integer));
    }
}
