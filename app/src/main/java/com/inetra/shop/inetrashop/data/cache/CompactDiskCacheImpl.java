package com.inetra.shop.inetrashop.data.cache;

import android.content.Context;

import java.util.ArrayList;
import java.util.List;

import rx.Observable;
import com.inetra.shop.inetrashop.data.entity.CompactDiskEntity;
import com.inetra.shop.inetrashop.data.entity.DiskContent;
import com.inetra.shop.inetrashop.data.entity.DiskType;

import javax.inject.Inject;
import javax.inject.Singleton;

@Singleton
public class CompactDiskCacheImpl implements CompactDiskCache {
    private final Context context;
    private static List<CompactDiskEntity> compactDisks = new ArrayList<>();

    static {
        compactDisks.add(new CompactDiskEntity("Java", 20.15, "123654987", DiskType.CD, DiskContent.Soft));
        compactDisks.add(new CompactDiskEntity("C", 45.23, "249166158", DiskType.DVD, DiskContent.Soft));
        compactDisks.add(new CompactDiskEntity("Stairway To Heaven", 12.25, "54151686", DiskType.CD, DiskContent.Music));
        compactDisks.add(new CompactDiskEntity("Abbey Road", 15.26, "5684268", DiskType.DVD, DiskContent.Music));
        compactDisks.add(new CompactDiskEntity("Hitch", 42.26, "12981255168", DiskType.CD, DiskContent.Video));
        compactDisks.add(new CompactDiskEntity("Back To The Future", 14.32, "187454575", DiskType.DVD, DiskContent.Video));
    }

    @Inject
    public CompactDiskCacheImpl(Context context) {
        this.context = context;
    }

    @Override
    public Observable<List<CompactDiskEntity>> getProducts() {
        return Observable.just(compactDisks);
    }

    @Override
    public Observable<CompactDiskEntity> getProductByBarCode(String barCode) {
        for (CompactDiskEntity compactDisk : compactDisks) {
            if (compactDisk.getBarcode().equals(barCode)) return Observable.just(compactDisk);
        }
        return null;
    }
}
