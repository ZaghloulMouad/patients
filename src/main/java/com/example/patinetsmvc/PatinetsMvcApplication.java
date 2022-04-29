package com.example.patinetsmvc;

import com.example.patinetsmvc.entities.Patient;
import com.example.patinetsmvc.reposotiries.PatientRepository;
import com.example.patinetsmvc.security.service.SecurityService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

import java.util.Date;

@SpringBootApplication
public class PatinetsMvcApplication  {

    public static void main(String[] args) {
        SpringApplication.run(PatinetsMvcApplication.class, args);
    }
    @Bean
    PasswordEncoder passwordEncoder(){
        return new BCryptPasswordEncoder();
    }
//    @Bean
   CommandLineRunner commandLineRunner(PatientRepository patientRepository){
        return args -> {
            patientRepository.save(new Patient(null,"yassine",new Date(),false,100));
            patientRepository.save(new Patient(null,"mouad",new Date(),true,176));
            patientRepository.save(new Patient(null,"omar",new Date(),true,200));

         patientRepository.findAll().forEach(p ->{
             System.out.println(p.getNom());
         });
        };
    }
    //@Bean
   CommandLineRunner saveUsers(SecurityService securityService){
        return args -> {
         securityService.saveUser("Yassine","1234","1234");
            securityService.saveUser("mouad","1234","1234");
            securityService.saveUser("hamza","1234","1234");

            securityService.saveNewRole("USER","");
            securityService.saveNewRole("ADMIN","");

            securityService.addRoleToUser("Yassine","USER");
            securityService.addRoleToUser("Yassine","ADMIN");
            securityService.addRoleToUser("mouad","Admin");
            securityService.addRoleToUser("hamza","USER");





        };
    }


}
