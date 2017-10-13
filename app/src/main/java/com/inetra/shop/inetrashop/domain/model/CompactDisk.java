package com.inetra.shop.inetrashop.domain.model;

import com.inetra.shop.inetrashop.data.entity.DiskContent;
import com.inetra.shop.inetrashop.data.entity.DiskType;
import com.inetra.shop.inetrashop.data.entity.ProductEntity;

public class CompactDisk extends Product {
    private DiskType diskType;
    private DiskContent diskContent;

    public CompactDisk(String name, double price, String barcode, DiskType diskType, DiskContent diskContent) {
        super(name, price, barcode);
        this.diskType = diskType;
        this.diskContent = diskContent;
    }

    public DiskType getDiskType() {
        return diskType;
    }

    public void setDiskType(DiskType diskType) {
        this.diskType = diskType;
    }

    public DiskContent getDiskContent() {
        return diskContent;
    }

    public void setDiskContent(DiskContent diskContent) {
        this.diskContent = diskContent;
    }
}
