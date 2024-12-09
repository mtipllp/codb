package com.mtipservice.APIService.service;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.mtipservice.APIService.entity.CreateSupplierRequest;
import com.mtipservice.APIService.entity.Errors;
import com.mtipservice.APIService.entity.Response;
import com.mtipservice.APIService.model.Supplier;
import com.mtipservice.APIService.repository.SupplierRepository;

@Service
public class SupplierService {
	@Autowired
	SupplierRepository supplierRepository;

	private static final Logger LOGGER = LoggerFactory.getLogger(SupplierService.class);
	
	public ResponseEntity<Response> getSupplier(int supplierDocId, Response res) {
		try {
			Supplier supp = supplierRepository.getSupplier(supplierDocId);
			res.setResponse(supp);
			return ResponseEntity.status(HttpStatus.OK).body(res);
		}catch (Exception e) {
			LOGGER.error("Searching for Supplier has errored OUT with error-:" + e.getMessage());
			Errors err = new Errors();
			err.setCode("ERR001");
			err.setMessage("Searching for Supplier has errored OUT with error-:" + e.getMessage());
			err.setSource(this.getClass().getName());
			res.setErr(err);
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(res);

		}
	}
	
	public ResponseEntity<Response> getAllSuppliers(Response res) {
		try {
			List<Supplier> suppliers = supplierRepository.findAll();
			res.setResponse(suppliers);
			return ResponseEntity.status(HttpStatus.OK).body(res);
		}catch (Exception e) {
			LOGGER.error("Searching for Suppliers has errored OUT with error-:" + e.getMessage());
			Errors err = new Errors();
			err.setCode("ERR001");
			err.setMessage("Searching for Supplier has errored OUT with error-:" + e.getMessage());
			err.setSource(this.getClass().getName());
			res.setErr(err);
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(res);

		}
	}

	public ResponseEntity<Response> createSupplier(CreateSupplierRequest request, Response res) {
		try {
			Supplier supplier = new Supplier();
			BeanUtils.copyProperties(request, supplier);
			supplierRepository.save(supplier);
			String resp = "Create Supplier ended successfully";
			res.setResponse(resp);
			return ResponseEntity.status(HttpStatus.OK).body(res);
		}catch (Exception e) {
			LOGGER.error("Create Supplier has errored OUT with error-:" + e.getMessage());
			Errors err = new Errors();
			err.setCode("ERR001");
			err.setMessage("Create Supplier has errored OUT with error-:" + e.getMessage());
			err.setSource(this.getClass().getName());
			res.setErr(err);
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(res);

		}
	}


	public ResponseEntity<Response> updateSupplier(int supplierId, CreateSupplierRequest request, Response res) {
		try {
			Supplier supplier = supplierRepository.getSupplier(supplierId);
			BeanUtils.copyProperties(request, supplier);
			supplierRepository.save(supplier);
			String resp = "Update Supplier ended successfully";
			res.setResponse(resp);
			return ResponseEntity.status(HttpStatus.OK).body(res);
		}catch (Exception e) {
			LOGGER.error("Update Supplier has errored OUT with error-:" + e.getMessage());
			Errors err = new Errors();
			err.setCode("ERR001");
			err.setMessage("Update Supplier has errored OUT with error-:" + e.getMessage());
			err.setSource(this.getClass().getName());
			res.setErr(err);
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(res);

		}
	}
	
	public ResponseEntity<Response> deleteSupplier(int supplierId, Response res) {
		try {
			supplierRepository.deleteSupplier(supplierId);
			String resp = "Delete supplier ended successfully";
			res.setResponse(resp);
			return ResponseEntity.status(HttpStatus.OK).body(res);
		}catch (Exception e) {
			LOGGER.error("Delete supplier has errored OUT with error-:" + e.getMessage());
			Errors err = new Errors();
			err.setCode("ERR001");
			err.setMessage("Delete supplier has errored OUT with error-:" + e.getMessage());
			err.setSource(this.getClass().getName());
			res.setErr(err);
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(res);

		}
	}

}
