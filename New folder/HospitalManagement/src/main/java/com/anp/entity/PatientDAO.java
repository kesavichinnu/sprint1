package com.anp.entity;

import java.util.List;
import java.util.Optional;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityTransaction;

public class PatientDAO {
	private EntityManager em;

	public PatientDAO(final EntityManager em) {

		this.em = em;
}

	public void save(final PatientEntity p1) {
		EntityTransaction tx = null;
		try {
			tx = em.getTransaction(); 

			if (!tx.isActive()) 
			{
				tx.begin();
			}
	        PatientEntity mergedPatient = em.merge(p1);
          //em.persist(p1);

			tx.commit();
		} catch (Exception e) {
			e.printStackTrace();
		}

	}
	public Optional<PatientEntity> findById(int id) {

		PatientEntity P1 = em.find(PatientEntity.class, id);

		if (P1 != null) {
			return Optional.of(P1);
		} else {
			return Optional.empty();
		}

	}

	public List<PatientEntity> findAll() {

		List<PatientEntity> t1 = em.createQuery("from PatientEntity", PatientEntity.class).getResultList();

		return t1;

	}
	public void updatePatient( int id, String newFirstName, String newLastName, String newGender,String newbloodgroup, String newappointmentdate) {
		EntityTransaction tx = null; 
		try {
			tx = em.getTransaction(); 

			if (!tx.isActive()) 
			{
				tx.begin();
			}
			PatientEntity P1 = em.find(PatientEntity.class, id) ;
			if(P1!=null) {
				P1.setPatientFirstName(newFirstName);
				P1.setPatientLastName(newLastName);
				P1.setGender(newGender);
				P1.setBloodGroup(newbloodgroup);

				P1.setAppointmentDate(newappointmentdate);

				em.merge(P1); 
				tx.commit(); 
			}	

		} catch (Exception e) {
			 e.printStackTrace();
		}

	}


	public void remove(int id) {  
		EntityTransaction tx = null; 

		PatientEntity P1 = em.find(PatientEntity.class, id);  

		try {
			tx = em.getTransaction(); 

			if (!tx.isActive()) 
			{
				tx.begin();
			}
			em.remove(P1);
			tx.commit();
		}
		catch (Exception e) {
			 e.printStackTrace();
		  }
	     }
       }