package com.inetra.shop.inetrashop.data.entity.mapper;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import com.inetra.shop.inetrashop.data.entity.ProductEntity;
import com.inetra.shop.inetrashop.domain.model.BookOnCooking;
import com.inetra.shop.inetrashop.domain.model.CompactDisk;
import com.inetra.shop.inetrashop.data.entity.BookOnCookingEntity;
import com.inetra.shop.inetrashop.data.entity.BookOnEsotericEntity;
import com.inetra.shop.inetrashop.data.entity.BookOnProgrammingEntity;
import com.inetra.shop.inetrashop.data.entity.CompactDiskEntity;
import com.inetra.shop.inetrashop.domain.model.BookOnEsoteric;
import com.inetra.shop.inetrashop.domain.model.BookOnProgramming;
import com.inetra.shop.inetrashop.domain.model.Product;

import javax.inject.Inject;
import javax.inject.Singleton;

@Singleton
public class EntityDataMapper {
    @Inject
    public EntityDataMapper() {
    }

    public BookOnCooking transform(BookOnCookingEntity bookOnCookingEntity) {
        BookOnCooking bookOnCooking = null;
        if (bookOnCookingEntity != null) {
            bookOnCooking = new BookOnCooking(bookOnCookingEntity.getName(), bookOnCookingEntity.getPrice(), bookOnCookingEntity.getBarcode(),
                    bookOnCookingEntity.getPagesNumber(), bookOnCookingEntity.getMajorIngredient());
        }
        return bookOnCooking;
    }

    public BookOnEsoteric transform(BookOnEsotericEntity bookOnEsotericEntity) {
        BookOnEsoteric bookOnEsoteric = null;
        if (bookOnEsotericEntity != null) {
            bookOnEsoteric = new BookOnEsoteric(bookOnEsotericEntity.getName(), bookOnEsotericEntity.getPrice(), bookOnEsotericEntity.getBarcode(),
                    bookOnEsotericEntity.getPagesNumber(), bookOnEsotericEntity.getReaderAge());
        }
        return bookOnEsoteric;
    }

    public BookOnProgramming transform(BookOnProgrammingEntity bookOnProgrammingEntity) {
        BookOnProgramming bookOnProgramming = null;
        if (bookOnProgrammingEntity != null) {
            bookOnProgramming = new BookOnProgramming(bookOnProgrammingEntity.getName(), bookOnProgrammingEntity.getPrice(), bookOnProgrammingEntity.getBarcode(),
                    bookOnProgrammingEntity.getPagesNumber(), bookOnProgrammingEntity.getProgrammingLanguage());
        }
        return bookOnProgramming;
    }

    public CompactDisk transform(CompactDiskEntity compactDiskEntity) {
        CompactDisk compactDisk = null;
        if (compactDiskEntity != null) {
            compactDisk = new CompactDisk(compactDiskEntity.getName(), compactDiskEntity.getPrice(), compactDiskEntity.getBarcode(),
                    compactDiskEntity.getDiskType(), compactDiskEntity.getDiskContent());
        }
        return compactDisk;
    }


    public List<BookOnCooking> transformBookOnCookingEntities(Collection<BookOnCookingEntity> bookOnCookingEntities) {
        List<BookOnCooking> bookOnCookingList = new ArrayList<>();
        BookOnCooking bookOnCooking;
        for (BookOnCookingEntity bookOnCookingEntity : bookOnCookingEntities) {
            bookOnCooking = transform(bookOnCookingEntity);
            if (bookOnCooking != null) {
                bookOnCookingList.add(bookOnCooking);
            }
        }
        return bookOnCookingList;
    }

    public List<BookOnEsoteric> transformBookOnEsotericEntities(Collection<BookOnEsotericEntity> bookOnEsotericEntities) {
        List<BookOnEsoteric> bookOnEsotericList = new ArrayList<>();
        BookOnEsoteric bookOnEsoteric;
        for (BookOnEsotericEntity bookOnEsotericEntity : bookOnEsotericEntities) {
            bookOnEsoteric = transform(bookOnEsotericEntity);
            if (bookOnEsoteric != null) {
                bookOnEsotericList.add(bookOnEsoteric);
            }
        }
        return bookOnEsotericList;
    }

    public List<BookOnProgramming> transformBookOnProgrammingEntities(Collection<BookOnProgrammingEntity> bookOnProgrammingEntities) {
        List<BookOnProgramming> bookOnProgrammingList = new ArrayList<>();
        BookOnProgramming bookOnCooking;
        for (BookOnProgrammingEntity bookOnProgrammingEntity : bookOnProgrammingEntities) {
            bookOnCooking = transform(bookOnProgrammingEntity);
            if (bookOnCooking != null) {
                bookOnProgrammingList.add(bookOnCooking);
            }
        }
        return bookOnProgrammingList;
    }

    public List<CompactDisk> transformCompactDiskEntities(Collection<CompactDiskEntity> compactDiskEntities) {
        List<CompactDisk> compactDiskList = new ArrayList<>();
        CompactDisk compactDisk;
        for (CompactDiskEntity bookOnCookingEntity : compactDiskEntities) {
            compactDisk = transform(bookOnCookingEntity);
            if (compactDisk != null) {
                compactDiskList.add(compactDisk);
            }
        }
        return compactDiskList;
    }
}
