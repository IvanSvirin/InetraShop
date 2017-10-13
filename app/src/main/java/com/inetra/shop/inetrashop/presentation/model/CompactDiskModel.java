package com.inetra.shop.inetrashop.presentation.model;

import com.inetra.shop.inetrashop.data.entity.DiskContent;
import com.inetra.shop.inetrashop.data.entity.DiskType;

public class CompactDiskModel extends ProductModel {
    private DiskType diskType;
    private DiskContent diskContent;

    public CompactDiskModel(String name, double price, String barcode, DiskType diskType, DiskContent diskContent) {
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

    @Override
    public String toString() {
        return super.toString() +
                "Disk type: " + diskType.toString() + "\n" +
                "Disk content: " + diskContent.toString() + "\n";
    }
}
