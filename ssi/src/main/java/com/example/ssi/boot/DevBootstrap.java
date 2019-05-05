package com.example.ssi.boot;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.stereotype.Component;

import com.example.ssi.model.Profile;
import com.example.ssi.model.User;
import com.example.ssi.model.manytomany.Clas;
import com.example.ssi.model.manytomany.Teacher;
import com.example.ssi.model.manytoone.Client;
import com.example.ssi.model.manytoone.PcInternet;
import com.example.ssi.model.onetomany.Employee;
import com.example.ssi.model.onetomany.Factory;
import com.example.ssi.repository.ClasRepository;
import com.example.ssi.repository.ClientRepository;
import com.example.ssi.repository.EmployeeRepository;
import com.example.ssi.repository.FactoryRepository;
import com.example.ssi.repository.PcInternetRepository;
import com.example.ssi.repository.ProfileRepository;
import com.example.ssi.repository.TeacherRepository;
import com.example.ssi.repository.UserRepository;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Component
public class DevBootstrap implements ApplicationListener<ContextRefreshedEvent> {

	@Autowired
	private ClasRepository clasRepository;
	@Autowired
	private TeacherRepository teacherRepository;
	
	@Autowired
	private ClientRepository clientRepository;
	
	@Autowired
	private PcInternetRepository pcInternetRepository;
	
	@Autowired
	private EmployeeRepository employeRepository;
	
	@Autowired
	private FactoryRepository factoryRepository;
	
	@Autowired
	private UserRepository userRepository;
	
	@Autowired 
	private ProfileRepository profileRepository;


    @Override
    public void onApplicationEvent(ContextRefreshedEvent contextRefreshedEvent) {
        initData();
    }

    private void initData() {
    	oneToOne();
    	oneToMany();
    	manyToMany();
    	manyToOne();
    }
    
    public void oneToOne() {
    	
    	User user = new User();
    	user.setName("Mario Flores");
    	user.setPassword("password");
    	
    	
    	Profile userProfile = new Profile();
    	userProfile.setAddress("User direction");
    	userProfile.setJob("Seller");
    	userProfile.setPhone("324234234");
    	//profileRepository.save(userProfile);
    	userProfile.setUser(user);
    	
    	userRepository.save(user);
    	profileRepository.save(userProfile);
    	
    }
    
    public void oneToMany() {
    	
    	Employee mario = new Employee( "mario flores", 2000d, "President" );
    	Employee sandra = new Employee( "sandra rengel", 1000d, "Secretary" );
    	Employee pedro = new Employee( "pedro poveda", 800d, "Security" );
    	
    	
    	
    	employeRepository.save(mario);
    	employeRepository.save(sandra);
    	employeRepository.save(pedro);
    	
	   //Create Employeelist
	   List<Employee> employeeList = new ArrayList<Employee>();
	   employeeList.add(mario);
	   employeeList.add(sandra);
	   employeeList.add(pedro);

	   Factory factory = new Factory(1L, "CYBERTECK", "CYBER", "Enterprise Software Developer", employeeList);
	   factoryRepository.save(factory);
    }
    
    public void manyToOne() {
    	PcInternet pc = new PcInternet("pc-01", "Pc para juegos ultima generacion");
    	
    	Client pedro = new Client("pedro", "poveda", pc);
    	Client sandra = new Client("sandra", "rengel", pc);
    	Client homero = new Client("homero", "simpson", pc);
    	
    	pcInternetRepository.save(pc);
    	clientRepository.save(pedro);
    	clientRepository.save(sandra);
    	clientRepository.save(homero);
    	
    }
    
    public void manyToMany() {
    	//Create Clas Entity
 	   Clas clas1 = new Clas(0, "1st", null);
 	   Clas clas2 = new Clas(0, "2nd", null);
 	   Clas clas3 = new Clas(0, "3rd", null);

 	   //Store Clas
 	   clasRepository.save(clas1);
 	   clasRepository.save(clas2);
 	   clasRepository.save(clas3);
 	   
 	   //Create Clas Set1
 	   Set<Clas> classSet1 = new HashSet();
 	   classSet1.add(clas1);
 	   classSet1.add(clas2);
 	   classSet1.add(clas3);

 	   //Create Clas Set2
 	   Set<Clas> classSet2 = new HashSet();
 	   classSet2.add(clas3);
 	   classSet2.add(clas1);
 	   classSet2.add(clas2);

 	   //Create Clas Set3
 	   Set<Clas> classSet3 = new HashSet();
 	   classSet3.add(clas2);
 	   classSet3.add(clas3);
 	   classSet3.add(clas1);

 	   //Create Teacher Entity
 	   Teacher teacher1 = new Teacher(0, "Satish","Java",classSet1);
 	   Teacher teacher2 = new Teacher(0, "Krishna","Adv Java",classSet2);
 	   Teacher teacher3 = new Teacher(0, "Masthanvali","DB2",classSet3);



 	   
 	   //Store
 	   teacherRepository.save(teacher1);
 	   teacherRepository.save(teacher2);
 	   teacherRepository.save(teacher3);
 	   
 	   
 	   //adding teacher set to a class
 	   Set<Teacher> teacherSet = new HashSet();
 	   teacherSet.add(teacher1);
 	   teacherSet.add(teacher2);
 	   teacherSet.add(teacher3);
 	   
 	   clas1.setTeacherSet(teacherSet);
 	   clasRepository.save(clas1);
    }
    
    

}
