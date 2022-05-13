package com.rays.project3.model;

import java.util.List;

import com.rays.project3.dto.SubjectDTO;
import com.rays.project3.exception.ApplicationException;
import com.rays.project3.exception.DuplicateRecordException;

/**
 * Interface of Subject model
 * 
 * @author Pushpendra Singh Kushwah
 *
 */
public interface SubjectModelInt {
	public long add(SubjectDTO dto) throws ApplicationException, DuplicateRecordException;

	public void delete(SubjectDTO dto) throws ApplicationException;

	public void update(SubjectDTO dto) throws ApplicationException, DuplicateRecordException;

	public List list() throws ApplicationException;

	public List list(int pageNo, int pageSize) throws ApplicationException;

	public List search(SubjectDTO dto) throws ApplicationException;

	public List search(SubjectDTO dto, int pageNo, int pageSize) throws ApplicationException;

	public SubjectDTO findByPK(long pk) throws ApplicationException;

	public SubjectDTO findByName(String name) throws ApplicationException;
}
