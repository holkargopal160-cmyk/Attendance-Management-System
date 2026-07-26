package com.attendance.controller;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.attendance.model.Teacher;
import com.attendance.repository.TeacherRepository;
@Controller
public class AttendanceController {
@Autowired
private TeacherRepository teacherRepository;
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
Optional<Teacher> teacherOpt = teacherRepository.findByUsername(username);
if (teacherOpt.isPresent()) {
Teacher teacher = teacherOpt.get();
if (teacher.getPassword().equals(password)) {
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
newTeacher.setName(name);
newTeacher.setUsername(username);
newTeacher.setPassword(password);
teacherRepository.save(newTeacher);
System.out.println("Naya user register ho gaya: " + username);
return "redirect:/login";
}
// 4. TEACHER / DASHBOARD PAGE KE LIYE
@GetMapping("/teacher")
public String showTeacherPage() {
return "teacher";
}
@GetMapping("/dashboard")
public String showDashboardPage() {
return "teacher";
}
// 5. STUDENT PAGE KE LIYE
@GetMapping("/student")
public String showStudentPage() {
return "student";
}
// 6. BATCH PAGE KE LIYE
@GetMapping("/batch")
public String showBatchPage() {
return "batch";
}
// 7. REPORT PAGE KE LIYE
@GetMapping("/report")
public String showReportPage() {
return "report";
}
// 8. ViewAll Button Ke Liye
@GetMapping("/viewall")
public String ViewAllPage() {
    return "viewall"; 
}
@GetMapping("/allTeachers")
public String showAllTeacherPage() {
    return "allTeachers";
}
}