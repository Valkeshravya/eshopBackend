package com.shravya.eshopbackend.dao;

import java.util.List;

import com.shravya.eshopbackend.model.Supplier;


public interface SupplierDao
{
    boolean saveSupplier(Supplier supplier);
    
    boolean deleteSupplier(Supplier supplier);
    
    Supplier getSupplier(int supplierId);
    
   List<Supplier>    getSupplierList();
}