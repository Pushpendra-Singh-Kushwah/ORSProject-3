package com.rays.project3.test;

import java.sql.Timestamp;
import java.util.Date;

import com.rays.project3.dto.CollegeDTO;
import com.rays.project3.exception.ApplicationException;
import com.rays.project3.exception.DuplicateRecordException;
import com.rays.project3.model.CollegeModelHibImpl;
import com.rays.project3.model.CollegeModelInt;

public class CollegeModelTest {
	public static CollegeModelInt model = new CollegeModelHibImpl();

	// public static CollegeModelInt model=new CollegeModelJDBCImpl();
	public static void main(String[] args) throws Exception {
//		 addTest(); 
//		 deleteTest();
//		 updateTest();
//		findByPKTest();
		 findByNameTest();

	}

	public static void findByNameTest() throws ApplicationException {
		// TODO Auto-generated method stub
		CollegeDTO dto = model.findByName("malwa");
		System.out.println(dto.getId());
		System.out.println(dto.getName());
		System.out.println(dto.getAddress());
		System.out.println(dto.getState());
		System.out.println(dto.getCity());
		System.out.println(dto.getPhoneNo());
		System.out.println(dto.getCreatedBy());
		System.out.println(dto.getCreatedDatetime());
		System.out.println(dto.getModifiedBy());
		System.out.println(dto.getModifiedDatetime());
	}

	public static void findByPKTest() throws ApplicationException {
		// TODO Auto-generated method stub
		CollegeDTO dto = model.findByPk(3L);
		System.out.println(dto.getId());
		System.out.println(dto.getName());
		System.out.println(dto.getAddress());
		System.out.println(dto.getState());
		System.out.println(dto.getCity());
		System.out.println(dto.getPhoneNo());
		System.out.println(dto.getCreatedBy());
		System.out.println(dto.getCreatedDatetime());
		System.out.println(dto.getModifiedBy());
		System.out.println(dto.getModifiedDatetime());
	}

	public static void updateTest() throws ApplicationException, DuplicateRecordException {
		// TODO Auto-generated method stub
		CollegeDTO dto = new CollegeDTO();
		dto.setId(2L);
		dto.setName("mjjjit");
		dto.setAddress("borawan");
		dto.setState("mp");
		dto.setCity("indore");
		dto.setPhoneNo("073124244");
		dto.setCreatedBy("Admin");
		dto.setModifiedBy("Admin");
		dto.setCreatedDatetime(new Timestamp(new Date().getTime()));
		dto.setModifiedDatetime(new Timestamp(new Date().getTime()));
		model.update(dto);
		System.out.println("updated" + dto.getId());
	}

	public static void deleteTest() throws ApplicationException {
		// TODO Auto-generated method stub
		CollegeDTO dto = new CollegeDTO();
		dto.setId(1L);
		model.delete(dto);
	}

	public static void addTest() throws ApplicationException, DuplicateRecordException {
		// TODO Auto-generated method stub
		CollegeDTO dto = new CollegeDTO();
		dto.setId(19L);
		dto.setName("malwa");
		dto.setAddress("rau road");
		dto.setState("up");
		dto.setCity("indore");
		dto.setPhoneNo("2532095");
		dto.setCreatedBy("Admin");
		dto.setModifiedBy("Admin");
		dto.setCreatedDatetime(new Timestamp(new Date().getTime()));
		dto.setModifiedDatetime(new Timestamp(new Date().getTime()));
		long pk = model.add(dto);
		System.out.println(pk);
	}
}
