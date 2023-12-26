package servlet_crud.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.persistence.Query;

import dto.SampleDto;

public class SampleDao {

	EntityManagerFactory emf=Persistence.createEntityManagerFactory("dev");
	EntityManager em=emf.createEntityManager();
	EntityTransaction et=em.getTransaction();
	
	public String insert(SampleDto dto) {
		
		et.begin();
		em.persist(dto);
		et.commit();
		return "values inserted";
	}
	
	
	public String delete(int no) {
		
		SampleDto s = em.find(SampleDto.class, no);
		if(s!=null) {
		et.begin();
		em.remove(s);
		et.commit();
		return "done";
		}
		else {
			return "false";
		}
	}
	
	public String deleteall() {
		Query q = em.createQuery("select data from SampleDto data");
		List<SampleDto> list=q.getResultList();
		if(list.isEmpty()) {
			return "no data found";
		} else {
			for(SampleDto uv : list) {
				et.begin();
				em.remove(uv);
				et.commit();
				
			}
			
			return "data is delted";
		}
	}
	
	public Object fetchbyid(int id) {
		SampleDto dto = em.find(SampleDto.class, id);
		if(dto!=null) {
			return dto;
		} else {
			return "no data found";
		}
	}
	
	public Object fetchall() {
	Query s = em.createQuery("select data from SampleDto data");
	List<SampleDto> list=s.getResultList();
	if(list.isEmpty()) {
		return null;
	} else {
		return list;
	}
	
	
	}
	
}
