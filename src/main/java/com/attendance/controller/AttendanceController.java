package com.attendance.controller;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.attendance.model.Batch;
import com.attendance.model.Student;
import com.attendance.model.Teacher;
import com.attendance.repository.BatchRepository;
import com.attendance.repository.StudentRepository;
import com.attendance.repository.TeacherRepository;

@Controller
public class AttendanceController {

    @Autowired
    private TeacherRepository teacherRepository;

    @Autowired
    private StudentRepository studentRepository;

    @Autowired
    private BatchRepository batchRepository;

    // 1. LOGIN PAGE OPEN KARNE KE LIYE
    @GetMapping("/login")
    public String showLoginPage() {
        return "login";
    }

    // 2. LOGIN DATA CHECK KARNE KE LIYE (DATABASE SE)
    @PostMapping("/login")
    public String processLogin(@RequestParam String username, @RequestParam String password, Model model) {
        System.out.println("--- CHALU HUA LOGIN TEST ---");
        System.out.println("Username: " + username);
        Optional<Teacher> teacherOpt = teacherRepository.findByUserName(username);
        if (teacherOpt.isPresent()) {
            Teacher teacher = teacherOpt.get();
            if (teacher.getTeacherPassword().equals(password)) {
                System.out.println("Login Successful!");
                return "redirect:/dashboard";
            }
        }
        System.out.println("Database mein user mila?: None");
        model.addAttribute("error", "Invalid Username or Password!");
        return "login";
    }

    // 3. SIGN UP DATA DATABASE MEIN SAVE KARNE KE LIYE
    @PostMapping("/register")
    public String processRegister(@RequestParam String name,
                                  @RequestParam String username,
                                  @RequestParam String password) {
        System.out.println("--- CHALU HUA SIGN UP TEST ---");
        Teacher newTeacher = new Teacher();
        newTeacher.setTeacherName(name);
        newTeacher.setUserName(username);
        newTeacher.setTeacherPassword(password);
        teacherRepository.save(newTeacher);
        System.out.println("Naya user register ho gaya: " + username);
        return "redirect:/login";
    }

    // 4. TEACHER / DASHBOARD PAGE KE LIYE
    @GetMapping("/teacher")
public String showTeacherPage(Model model) {
    model.addAttribute("teacher", new Teacher()); // Yeh line zaroori hai!
    model.addAttribute("teachers", teacherRepository.findAll());
    return "teacher";
}

    @PostMapping("/saveTeacher")
    public String saveTeacher(@ModelAttribute Teacher teacher) {
        teacherRepository.save(teacher);
        return "redirect:/teacher";
    }

    @GetMapping("/dashboard")
    public String showDashboardPage(Model model) {
        model.addAttribute("teacher", new Teacher()); // ✅ Yeh line add karni hai
        model.addAttribute("teachers", teacherRepository.findAll());
        return "teacher";
    }

    // 5. STUDENT PAGE KE LIYE
    @GetMapping("/student")
    public String showStudentPage(Model model) {
        model.addAttribute("student", new Student()); // Form binding ke liye zaroori hai
        model.addAttribute("students", studentRepository.findAll());
        return "student";
    }

    @PostMapping("/saveStudent")
    public String saveStudent(@ModelAttribute Student student) {
        studentRepository.save(student);
        return "redirect:/student";
    }

    // 6. BATCH PAGE KE LIYE
    @GetMapping("/batch")
    public String showBatchPage(Model model) {
        model.addAttribute("batch", new Batch()); // Form binding ke liye zaroori hai
        model.addAttribute("batches", batchRepository.findAll());
        return "batch";
    }

    @PostMapping("/saveBatch")
    public String saveBatch(@ModelAttribute Batch batch) {
        batchRepository.save(batch);
        return "redirect:/batch";
    }

    // 7. REPORT PAGE KE LIYE
    @GetMapping("/report")
    public String showReportPage(Model model) {
        model.addAttribute("teachers", teacherRepository.findAll());
        model.addAttribute("students", studentRepository.findAll());
        model.addAttribute("batches", batchRepository.findAll());
        return "report";
    }

    // 8. ViewAll Button Ke Liye
    @GetMapping("/viewall")
    public String ViewAllPage() {
        return "viewall"; 
    }

    @GetMapping("/allTeachers")
    public String showAllTeacherPage(Model model) {
        model.addAttribute("teachers", teacherRepository.findAll());
        return "allTeachers";
    }
}