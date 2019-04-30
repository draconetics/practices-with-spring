/**
 * @author: Mario Flores
 */

package com.demo.hospital.boot;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.stereotype.Component;

import com.demo.hospital.model.Doctor;
import com.demo.hospital.repository.DoctorRepository;
import com.demo.hospital.service.DoctorCreateService;
import com.demo.hospital.service.DoctorUpdateService;

import java.util.Date;

@Component
public class DevBootstrap implements ApplicationListener<ContextRefreshedEvent> {

	@Autowired
	private DoctorRepository doctorRepository;
	


    @Override
    public void onApplicationEvent(ContextRefreshedEvent contextRefreshedEvent) {
        initData();
    }

    private void initData() {
    	Doctor dMario = new Doctor();
    	dMario.setFirstName("Mario");
    	dMario.setLastName("Flores");
    	dMario.setCreatedOn(new Date());

    	doctorRepository.save(dMario);
    	
    	Doctor dPedro = new Doctor();
    	dPedro.setFirstName("Pedro");
    	dPedro.setLastName("Poveda");
    	dPedro.setCreatedOn(new Date());
    	
    	doctorRepository.save(dPedro);
    	
    	Doctor dJuan = new Doctor();
    	dJuan.setCreatedOn(new Date());
    	dJuan.setFirstName("Juan");
    	dJuan.setLastName("Huanca");
    	
    	doctorRepository.save(dJuan);

    }

}
