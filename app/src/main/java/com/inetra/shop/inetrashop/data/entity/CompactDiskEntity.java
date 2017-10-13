package com.inetra.shop.inetrashop.data.entity;

public class CompactDiskEntity extends ProductEntity {
    private DiskType diskType;
    private DiskContent diskContent;

    public CompactDiskEntity(String name, double price, String barcode, DiskType diskType, DiskContent diskContent) {
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
