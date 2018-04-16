package com.lakshmi.DAO;

import java.util.List;

import com.lakshmi.domain.Supplier;

public interface SupplierDAO {

	void addSupplier(Supplier supplier);

	List<Supplier> SupplierList();

	void updateSupplier(Supplier supplier);

	void deleteSupplier(Integer supplierId);

	Supplier getSupplier(Integer supplierId);
}
