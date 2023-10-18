package com.revin.portfolio.controller;

import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.InputStreamResource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.io.IOException;

@Controller
public class PortfolioController {

    @GetMapping("/")
    public String index(Model model) {
        // Who am I section data
        model.addAttribute("name", "Revin Sasanka");
        model.addAttribute("introduction", "Ensuring top-notch software quality is my passion, and my projects are a testament to that dedication. " +
                "I've crafted this portfolio website using Java and Spring Boot, optimized with Docker for peak performance. " +
                "I'm all about growth, so I'll soon integrate a contact page for easy interactions. Dive in, explore my tech world, and see my commitment to excellence in action.");

        // Current Projects section data
        // List<Project> currentProjects = projectService.getCurrentProjects();
        // model.addAttribute("currentProjects", currentProjects);

        // All Projects section data
        // List<Project> projects = projectService.getAllProjects();
        // model.addAttribute("projects", projects);

        // Experience section data
        // List<Experience> experiences = experienceService.getAllExperiences();
        // model.addAttribute("experiences", experiences);

        // Skills section data
        // List<Skill> skills = skillService.getAllSkills();
        // model.addAttribute("skills", skills);

        // Education section data
        // List<Education> educations = educationService.getAllEducation();
        // model.addAttribute("educations", educations);

        // Social Links section data
        model.addAttribute("linkedinURL", "https://www.linkedin.com/in/revin-sasanka");
        model.addAttribute("githubURL", "https://github.com/Sasanka1994");

        // Resume section


        return "index";  // This refers to the single combined template (index.html)
    }

    @GetMapping("/downloadResume")
    public ResponseEntity<InputStreamResource> downloadResume() throws IOException {
        // Define the file's path inside the resources folder
        String filename = "files/Revin Sasanka - CV (4) (1).pdf";

        ClassPathResource pdfFile = new ClassPathResource(filename);
        HttpHeaders headers = new HttpHeaders();
        headers.add("Content-Disposition", "inline; filename=resume.pdf");

        return ResponseEntity
                .ok()
                .headers(headers)
                .contentType(MediaType.APPLICATION_PDF)
                .body(new InputStreamResource(pdfFile.getInputStream()));
    }
}
