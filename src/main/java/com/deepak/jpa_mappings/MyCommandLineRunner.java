package com.deepak.jpa_mappings;

import com.deepak.jpa_mappings.entities.*;
import com.deepak.jpa_mappings.repository.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class MyCommandLineRunner implements CommandLineRunner {

    @Autowired
    EmployeeRepository employeeRepository;

    @Autowired
    AddressRepository addressRepository;

    @Autowired
    UniversityRepository universityRepository;
    @Autowired
    UniversityStudentRepository universityStudentRepository;

    @Autowired
    ResearchProjectRepository researchProjectRepository;

    @Autowired
    ProfessorRepository professorRepository;

    @Override
    public void run(String... args) throws Exception {
        System.out.println("This is from command line runner");

        /** ONE TO ONE MAPPING **/

        Address address1 = new Address(1L, "Galli no.1", "Dunkirk", "ERE2");
        Address address2 = new Address(2L, "Galli no.2", "Openhiemr", "ZOLER4");
        Address address3 = new Address(3L, "lane no.3", "Read Rars", "098SS");
        Address address4 = new Address(4L, "lane no.4", "Murphy Kha", "48484");
        Address address5 = new Address(5L, "lane no.5", "Cear.sr", "ASDF");

        addressRepository.saveAll(List.of(address1, address2, address3, address4, address5));

        Employee employee = new Employee(1L, address1, "Deepak Mishra");
        Employee employee2 = new Employee(2L, address2, "Divit Mishra");
        Employee employee3 = new Employee(3L, address3, "Vijaya Mishra");
        Employee employee4 = new Employee(4L, address4, "Jitendra Mishra");

        employeeRepository.saveAll(List.of(employee, employee2, employee3, employee4));

        employeeRepository.findAll().forEach(System.out::println);

        University cambridgeUniversity = new University("Cambridge University");
        universityRepository.save(cambridgeUniversity);


        /** ONE TO MANY MAPPING **/
        UniversityStudent s1 = new UniversityStudent();
        s1.setFName("Deepak");
        s1.setLName("Mishra");
        s1.setUniversity(cambridgeUniversity);

        UniversityStudent s2 = new UniversityStudent();
        s2.setFName("Vijaya");
        s2.setLName("Mishra");
        s2.setUniversity(cambridgeUniversity);

        universityStudentRepository.save(s1);
        universityStudentRepository.save(s2);


        /** MANY TO MANY MAPPING **/
        /**
         * By default, if we only provide the @ManyToMany annotations in
         * both the classes, 2 mapping tables are created from both the sides
         *
         * QUERY:
         * SELECT PROFESSOR.NAME as professor_name, RESEARCH_PROJECT.title AS project_title
         * FROM research_project
         * JOIN PROJECT_PROFESSOR_ID ON RESEARCH_PROJECT.ID = PROJECT_PROFESSOR_ID.PROJECT_ID
         * JOIN PROFESSOR ON PROFESSOR.ID = PROJECT_PROFESSOR_ID.PROFESSOR_ID
         *
         * RESULT:
         * PROFESSOR_NAME  	PROJECT_TITLE
         * Albert Einstein	Laws of Physics
         * Isaac Newton	    Quantum Physics
         * Nicola Tesla	    Laws of Physics
         *
         */

        Professor p1 = new Professor();
        p1.setName("Albert Einstein");
        p1.setYrsOfExperience(40);


        Professor p2 = new Professor();
        p2.setName("Isaac Newton");
        p2.setYrsOfExperience(50);

        Professor p3 = new Professor();
        p3.setName("Nicola Tesla");
        p3.setYrsOfExperience(60);

        ResearchProject rp1 = new ResearchProject();
        rp1.setTitle("Quantum Physics");

        ResearchProject rp2 = new ResearchProject();
        rp2.setTitle("Laws of Physics");

        p1.addProject(rp2);
        rp2.addProfessor(p1);

        p2.addProject(rp1);
        rp1.addProfessor(p2);

        p3.addProject(rp2);
        rp2.addProfessor(p3);


        professorRepository.saveAll(List.of(p1, p2, p3));
        researchProjectRepository.saveAll(List.of(rp1, rp2));

    }
}
