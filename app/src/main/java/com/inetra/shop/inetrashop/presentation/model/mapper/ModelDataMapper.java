package com.inetra.shop.inetrashop.presentation.model.mapper;

import com.inetra.shop.inetrashop.domain.di.PerActivity;
import com.inetra.shop.inetrashop.domain.model.BookOnCooking;
import com.inetra.shop.inetrashop.domain.model.BookOnEsoteric;
import com.inetra.shop.inetrashop.domain.model.BookOnProgramming;
import com.inetra.shop.inetrashop.domain.model.CompactDisk;
import com.inetra.shop.inetrashop.domain.model.Product;
import com.inetra.shop.inetrashop.presentation.model.BookOnCookingModel;
import com.inetra.shop.inetrashop.presentation.model.BookOnEsotericModel;
import com.inetra.shop.inetrashop.presentation.model.BookOnProgrammingModel;
import com.inetra.shop.inetrashop.presentation.model.BookSubCategory;
import com.inetra.shop.inetrashop.presentation.model.Category;
import com.inetra.shop.inetrashop.presentation.model.CompactDiskModel;
import com.inetra.shop.inetrashop.presentation.model.ProductListModel;
import com.inetra.shop.inetrashop.presentation.model.ProductModel;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import javax.inject.Inject;

@PerActivity
public class ModelDataMapper {
    @Inject
    ModelDataMapper() {
    }

    private ProductListModel transform(BookOnCooking bookOnCooking) {
        ProductListModel productListModel = null;
        if (bookOnCooking != null) {
            productListModel = new ProductListModel(
                    bookOnCooking.getName(),
                    bookOnCooking.getPrice(),
                    bookOnCooking.getBarcode(),
                    Category.Books.toString(),
                    BookSubCategory.Cooking.toString());
        }
        return productListModel;
    }

    private ProductListModel transform(BookOnEsoteric bookOnEsoteric) {
        ProductListModel productListModel = null;
        if (bookOnEsoteric != null) {
            productListModel = new ProductListModel(
                    bookOnEsoteric.getName(),
                    bookOnEsoteric.getPrice(),
                    bookOnEsoteric.getBarcode(),
                    Category.Books.toString(),
                    BookSubCategory.Esoteric.toString());
        }
        return productListModel;
    }

    private ProductListModel transform(BookOnProgramming bookOnProgramming) {
        ProductListModel productListModel = null;
        if (bookOnProgramming != null) {
            productListModel = new ProductListModel(
                    bookOnProgramming.getName(),
                    bookOnProgramming.getPrice(),
                    bookOnProgramming.getBarcode(),
                    Category.Books.toString(),
                    BookSubCategory.Programming.toString());
        }
        return productListModel;
    }

    private ProductListModel transform(CompactDisk compactDisk) {
        ProductListModel productListModel = null;
        if (compactDisk != null) {
            productListModel = new ProductListModel(
                    compactDisk.getName(),
                    compactDisk.getPrice(),
                    compactDisk.getBarcode(),
                    Category.Disks.toString(),
                    compactDisk.getDiskContent().toString());
        }
        return productListModel;
    }

    public List<ProductListModel> transformProducts(Map<String, List<? extends Product>> products) {
        List<ProductListModel> productListModels = new ArrayList<>();

        for (String s : products.keySet()) {
            if (s.equals("BookOnCooking")) {
                for (Product product : products.get(s)) {
                    productListModels.add(transform((BookOnCooking) product));
                }
            }
            if (s.equals("BookOnEsoteric")) {
                for (Product product : products.get(s)) {
                    productListModels.add(transform((BookOnEsoteric) product));
                }
            }
            if (s.equals("BookOnProgramming")) {
                for (Product product : products.get(s)) {
                    productListModels.add(transform((BookOnProgramming) product));
                }
            }
            if (s.equals("CompactDisk")) {
                for (Product product : products.get(s)) {
                    productListModels.add(transform((CompactDisk) product));
                }
            }
        }
        return productListModels;
    }

    public ProductModel transformProduct(Product product) {
        if (product != null) {
            String c = product.getClass().getSimpleName();
            switch (c) {
                case "BookOnCooking":
                    return new BookOnCookingModel(product.getName(), product.getPrice(), product.getBarcode(), ((BookOnCooking) product).getPagesNumber(), ((BookOnCooking) product).getMajorIngredient());
                case "BookOnEsoteric":
                    return new BookOnEsotericModel(product.getName(), product.getPrice(), product.getBarcode(), ((BookOnEsoteric) product).getPagesNumber(), ((BookOnEsoteric) product).getReaderAge());
                case "BookOnProgramming":
                    return new BookOnProgrammingModel(product.getName(), product.getPrice(), product.getBarcode(), ((BookOnProgramming) product).getPagesNumber(), ((BookOnProgramming) product).getProgrammingLanguage());
                case "CompactDisk":
                    return new CompactDiskModel(product.getName(), product.getPrice(), product.getBarcode(), ((CompactDisk) product).getDiskType(), ((CompactDisk) product).getDiskContent());
                default:
                    return new CompactDiskModel(product.getName(), product.getPrice(), product.getBarcode(), ((CompactDisk) product).getDiskType(), ((CompactDisk) product).getDiskContent());
            }
        } else {
            return null;
        }
    }
}
