/**
 * @author: Mario Flores
 */

package com.demo.hospital.controller;



import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.context.annotation.RequestScope;

import com.demo.hospital.dao.DoctorCommand;
import com.demo.hospital.model.Doctor;
import com.demo.hospital.repository.DoctorRepository;
import com.demo.hospital.service.DoctorCreateService;
import com.demo.hospital.service.DoctorUpdateService;

@RequestMapping(value = "/doctors")
@RestController
@RequestScope
public class DoctorController {

    @Autowired
    private DoctorCreateService doctorCreateService;
    
    @Autowired
    private DoctorUpdateService doctorUpdateService;
    
	@Autowired
	private DoctorRepository doctorRepository;
    
    
	 @RequestMapping(
			 	value = "/hello",
	            method = RequestMethod.GET
    )
	public String responseHello() {
		 return "hello world";
	}
	 
	 @RequestMapping(method = RequestMethod.POST)
    public Doctor createDoctor(@RequestBody DoctorCommand doctorCommand) {
        doctorCreateService.setInput(doctorCommand);
        doctorCreateService.execute();

        return doctorCreateService.getDoctor();
    }
	 
    @RequestMapping(method = RequestMethod.GET)
    public List<DoctorCommand> getDoctors() {
    	List<DoctorCommand> doctorList = new ArrayList<DoctorCommand>();
        doctorCreateService.getDoctorRepository().findAll().forEach(doctor -> {
            doctorList.add(new DoctorCommand(doctor));
        });
        
        return doctorList;
    }
	    

    @RequestMapping(
            value = "/{doctorId}",
            method = RequestMethod.PUT)
    public Doctor updateDoctor(@PathVariable("doctorId") Long doctorId,
        @RequestBody DoctorCommand doctorCommand) {
		doctorUpdateService.setDoctorId(doctorId);
		doctorUpdateService.setDoctorCommand(doctorCommand);
		doctorUpdateService.execute();
		
		return doctorUpdateService.getDoctor();
	}
    
    @RequestMapping(
            value = "/{doctorId}",
            method = RequestMethod.DELETE)
    public String deleteDoctor(@PathVariable(value = "doctorId") Long doctorId) {

        try {
        	doctorRepository.deleteById(doctorId);
        	return "Deleted Doctor " + doctorId;
        }catch(Exception e) {
        	System.out.println(e);
        	return "Error deleting Doctor";
        }
    }
	

	/*
    public EmployeeController(EmployeeService service) {
        this.service = service;
    }

    @GET
    public Response getEmployees() {
        List<EmployeeCommand> employeeList = new ArrayList<>();
        service.findAll().forEach(employee -> {
            employeeList.add(new EmployeeCommand(employee));
        });
        return Response.ok(employeeList).build();
    }

    @GET
    @Path("/{id}")
    public Response getEmployeeById(@PathParam("id") long id) {
        Employee employee = service.findById(id);
        return Response.ok(new EmployeeCommand(employee)).build();
    }

    @OPTIONS
    public Response prefligth() {
        return Response.ok().build();
    }

    @POST
    public EmployeeCommand addEmployee(EmployeeCommand employeeCommand) {
        Employee employee = service.save(employeeCommand.toEmployee());
        return new EmployeeCommand(employee);
    }

    @PUT
    public EmployeeCommand updateEmployee(EmployeeCommand employeeCommand) {
        Employee e = service.findById(employeeCommand.getId());
        e.setFirstName(employeeCommand.getFirstName());
        e.setLastName(employeeCommand.getLastName());
        service.save(e);
        return new EmployeeCommand(e);
//        Employee employee = service.save(employeeCommand.toEmployee());
//        return new EmployeeCommand(employee);
    }

    @DELETE
    @Path("/{id}")
    public void deleteEmployee(@PathParam("id") long id) {
        service.deleteById(id);
    }

    @Path("/{id}/image")
    @POST
    @Consumes(MediaType.MULTIPART_FORM_DATA)
    @Produces(MediaType.APPLICATION_JSON)
    public Response uploadFile(@PathParam("id") String id,
                               @FormDataParam("file") InputStream file,
                               @FormDataParam("file") FormDataContentDisposition fileDisposition) {
        service.saveImage(Long.valueOf(id), file);
        return Response.ok("Data uploaded successfully !!").build();
    }

    /*
    https://www.getpostman.com/collections/cb9764af6c5d5bcaa0c9
    */
}
