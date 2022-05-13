package com.rays.project3.model;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.criterion.Restrictions;

import com.rays.project3.dto.CollegeDTO;
import com.rays.project3.dto.CourseDTO;
import com.rays.project3.dto.FacultyDTO;
import com.rays.project3.dto.SubjectDTO;
import com.rays.project3.exception.ApplicationException;
import com.rays.project3.exception.DuplicateRecordException;
import com.rays.project3.util.HibDataSource;

/**
 * Hibernate implements of Faculty model
 * @author Pushpendra Singh Kushwah
 *
 */
public class FacultyModelHibImp implements FacultyModelInt{

	public long add(FacultyDTO dto) throws ApplicationException, DuplicateRecordException {
		// TODO Auto-generated method stub
		Session session = null;
		Transaction tx = null;
		long pk = 0;
		CollegeModelInt model = ModelFactory.getInstance().getCollegeModel();
		CollegeDTO dto1 = model.findByPk(dto.getCollegeId());
		System.out.println("colleges Name"+dto1);
		String CollegeName = dto1.getName();
        dto.setCollegeName(CollegeName);
        
		CourseModelInt model1 = ModelFactory.getInstance().getCourseModel();
		CourseDTO dto2 = model1.findByPK(dto.getCourseId());
		System.out.println("llllll"+dto2+"....."+dto.getCourseId());
		String CourseName = dto2.getCourseName();
		dto.setCourseName(CourseName);
		
		SubjectModelInt model2 = ModelFactory.getInstance().getSubjectModel();
		SubjectDTO dto3 = model2.findByPK(dto.getSubjectId());
		System.out.println("oooooooooo"+dto3);
		String SubjectName = dto3.getSubjectName();
		dto.setSubjectName(SubjectName);

		FacultyDTO duplicataRole = findByEmailId(dto.getEmailId());
		System.out.println("fkkkkkkkkkkkk"+duplicataRole+"...."+dto.getEmailId());
		// Check if create Faculty already exist
		if (duplicataRole != null) {
			throw new DuplicateRecordException("Faculty already exists");
		}
		
		try {
			session = HibDataSource.getSession();
			tx = session.beginTransaction();
			session.save(dto);
			pk = dto.getId();
			tx.commit();
		} catch (HibernateException e) {
			e.printStackTrace();
			// TODO: handle exception
			if (tx != null) {
				tx.rollback();

			}
			throw new ApplicationException("Exception in faculty Add " + e.getMessage());
		} finally {
			session.close();
		}
		return pk;
	}

	public void delete(FacultyDTO dto) throws ApplicationException {
		// TODO Auto-generated method stub
		Session session = null;
		Transaction tx = null;
		try {
			session = HibDataSource.getSession();
			tx = session.beginTransaction();
			session.delete(dto);
			tx.commit();
		} catch (HibernateException e) {
			e.printStackTrace();
			// TODO: handle exception
			if (tx != null) {
				tx.rollback();

			}
			throw new ApplicationException("Exception in faculty delete " + e.getMessage());
		} finally {
			session.close();
		}
	}

	public void update(FacultyDTO dto) throws ApplicationException, DuplicateRecordException {
		// TODO Auto-generated method stub
		Session session = null;
		Transaction tx = null;

		CollegeModelInt model = ModelFactory.getInstance().getCollegeModel();
		CollegeDTO dto1 = model.findByPk(dto.getCollegeId());
		System.out.println("colleges Name"+dto1);
		String CollegeName = dto1.getName();
        dto.setCollegeName(CollegeName);
        
		CourseModelInt model1 = ModelFactory.getInstance().getCourseModel();
		CourseDTO dto2 = model1.findByPK(dto.getCourseId());
		System.out.println("llllll"+dto2+"....."+dto.getCourseId());
		String CourseName = dto2.getCourseName();
		dto.setCourseName(CourseName);
		
		SubjectModelInt model2 = ModelFactory.getInstance().getSubjectModel();
		SubjectDTO dto3 = model2.findByPK(dto.getSubjectId());
		System.out.println("oooooooooo"+dto3);
		String SubjectName = dto3.getSubjectName();
		dto.setSubjectName(SubjectName);

		/*
		 * FacultyDTO duplicataRole = findByEmailId(dto.getEmailId());
		 * System.out.println("fkkkkkkkkkkkk"+duplicataRole+"...."+dto.getEmailId()); //
		 * Check if create Faculty already exist if (duplicataRole != null) { throw new
		 * DuplicateRecordException("Faculty already exists"); }
		 */		

		
		try {
			session = HibDataSource.getSession();
			tx = session.beginTransaction();
			session.update(dto);
			tx.commit();

		} catch (HibernateException e) {
			e.printStackTrace();
			// TODO: handle exception
			if (tx != null) {
				tx.rollback();

			}
			throw new ApplicationException("Exception in faculty update " + e.getMessage());
		} finally {
			session.close();
		}
	}

	public List list() throws ApplicationException {
		// TODO Auto-generated method stub
		return list(0,0);
	}

	public List list(int pageNo, int pageSize) throws ApplicationException {
		// TODO Auto-generated method stub
		Session session = null;
		List list = null;
		try {
			session = HibDataSource.getSession();
			Criteria criteria = session.createCriteria(FacultyDTO.class);
			if (pageSize > 0) {
				pageNo = ((pageNo - 1) * pageSize) + 1;
				criteria.setFirstResult(pageNo);
				criteria.setMaxResults(pageSize);
			}
			list = criteria.list();
		} catch (HibernateException e) {

			throw new ApplicationException("Exception : Exception in  faculty list");
		} finally {
			session.close();
		}
		return list;
	}

	public List search(FacultyDTO dto) throws ApplicationException {
		// TODO Auto-generated method stub
		return search(dto,0,0);
	}

	public List search(FacultyDTO dto, int pageNo, int pageSize) throws ApplicationException {
		// TODO Auto-generated method stub
		Session session = null;
        List list = null;
        try {
            session = HibDataSource.getSession();
            Criteria criteria = session.createCriteria(FacultyDTO.class);
          if(dto!=null){
            if (dto.getId() !=null) {
                criteria.add(Restrictions.eq("id", dto.getId()));
            }
            if (dto.getFirstName() != null && dto.getFirstName().length() > 0) {
                criteria.add(Restrictions.like("firstName", dto.getFirstName() + "%"));
            }
            if (dto.getEmailId() != null && dto.getEmailId().length() > 0) {
                criteria.add(Restrictions.like("emailId", dto.getEmailId()
                        + "%"));
            }
            if (dto.getLastName() != null && dto.getLastName().length() > 0) {
                criteria.add(Restrictions.like("lastName", dto.getLastName() + "%"));
            }
            if (dto.getCollegeId() > 0) {
                criteria.add(Restrictions.eq("collegeId", dto.getCollegeId()));
            }
            if (dto.getCourseId() > 0) {
                criteria.add(Restrictions.eq("courseId", dto.getCourseId()));
            }
            if (dto.getSubjectId() > 0) {
                criteria.add(Restrictions.eq("subjectId", dto.getSubjectId()));
            }}

            // if page size is greater than zero the apply pagination
            if (pageSize > 0) {
                criteria.setFirstResult(((pageNo - 1) * pageSize));
                criteria.setMaxResults(pageSize);
            }

            list = criteria.list();
        } catch (HibernateException e) {
            
            throw new ApplicationException("Exception in course search");
        } finally {
            session.close();
        }

       
        return list;
	}

	public FacultyDTO findByPK(long pk) throws ApplicationException {
		// TODO Auto-generated method stub
		Session session = null;
		FacultyDTO dto = null;
		try {
			session = HibDataSource.getSession();

			dto = (FacultyDTO) session.get(FacultyDTO.class, pk);
		} catch (HibernateException e) {

			throw new ApplicationException("Exception : Exception in getting faculty by pk");
		} finally {
			session.close();
		}
		return dto;
	}

	public FacultyDTO findByEmailId(String emailId) throws ApplicationException {
		// TODO Auto-generated method stub
		Session session = null;
		FacultyDTO dto = null;
		try {
			session = HibDataSource.getSession();
			Criteria criteria = session.createCriteria(FacultyDTO.class);
			criteria.add(Restrictions.eq("emailId", emailId));
			List list = criteria.list();
			if (list.size() > 0) {
				dto = (FacultyDTO) list.get(0);
			}
		} catch (HibernateException e) {

			throw new ApplicationException("Exception in getting faculty by Login " + e.getMessage());

		} finally {
			session.close();
		}
		return dto;
	}

}
