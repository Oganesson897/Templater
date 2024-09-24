package com.example.example_mod;

import generator.annotations.MetaItem;
import gregtech.api.items.metaitem.StandardMetaItem;

@MetaItem
public class TestMetaItem extends StandardMetaItem {

    public TestMetaItem() {
        setRegistryName("test");
    }

    public void registerSubItems() {
        this.addItem(0, "test_item");
    }

}
