package com.anp.entity;
import java.util.List;
import java.util.Optional;
import org.hibernate.HibernateException;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;

public class PatientAPP {

	public static void main(String[] args) {

		EntityManagerFactory factory = null;


		try { 

			factory  = Persistence.createEntityManagerFactory("ak");

			EntityManager em = factory.createEntityManager();

		System.out.println("------WELCOME TO PatientManagementSystem------");

PatientEntity P1 = new PatientEntity (1, "Sanvi", "shree", "Female","B-Positive",  "06-12-2023");
PatientEntity P2 = new PatientEntity(2, "Akshay", "kumar", "Male","O-Positive",  "12-12-2023");
PatientEntity P3 = new PatientEntity(3, "Sindhu", "sing", "Female","A-Negative", "20-12-2023");
//PatientEntity P4 = new PatientEntity(4, "Vamshi", "krishna", "Male","A-Negative", "30-12-2023");			
					PatientDAO tDAO = new PatientDAO(em);
					tDAO.save(P1);
					tDAO.save(P2);
					tDAO.save(P3);
	//				tDAO.save(P4);
					System.out.println("Data added successfully");

					System.out.println("--------------------------");

					System.out.println(" Patient  details based on the id :");
					Optional<PatientEntity> PatientById = tDAO.findById(1);
					System.out.println(PatientById);


					System.out.println("--------------------------");

					System.out.println(" All Details of Patient ");	 
					List<PatientEntity> alltr = tDAO.findAll();
					System.out.println(alltr);



					System.out.println("------------------");


					int  newid = 3;
					String newFirstName ="Sindhu" ;
					String newLastName = "sing" ;
					String newgender = "Female"  ;
					String newbloodGroup = "A-Negative";
					String newAppointmentdate  ="20-12-2023";

tDAO.updatePatient(newid, newFirstName, newLastName,newgender, newbloodGroup, newAppointmentdate);

					System.out.println("Data updated sucessfully");


					System.out.println("------------------"); 

					System.out.println("Removeing based on the id :");

					//tDAO.remove(1);

					System.out.println("2nd record is removed");


				}
				catch (HibernateException e) {
					 e.printStackTrace();
				}
				catch (Exception e) {
				 e.printStackTrace();
				}
	           }
              }
