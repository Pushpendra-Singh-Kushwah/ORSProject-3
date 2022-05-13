package com.rays.project3.model;

import java.util.List;

import com.rays.project3.dto.RoleDTO;
import com.rays.project3.exception.ApplicationException;
import com.rays.project3.exception.DuplicateRecordException;

/**
 * Interface of Role model
 * @author Pushpendra Singh Kushwah
 *
 */
public interface RoleModelInt {
	
	public long add(RoleDTO dto)throws ApplicationException,DuplicateRecordException;
	public void delete(RoleDTO dto)throws ApplicationException;
	public void update(RoleDTO dto)throws ApplicationException,DuplicateRecordException;
	public List list()throws ApplicationException;
	public List list(int pageNo,int pageSize)throws ApplicationException;
	public List search(RoleDTO dto)throws ApplicationException;
	public List search(RoleDTO dto,int pageNo,int pageSize)throws ApplicationException;
	public RoleDTO findByPK(long pk)throws ApplicationException;
	public RoleDTO findByName(String name)throws ApplicationException;
}
