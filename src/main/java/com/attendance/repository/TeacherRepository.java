package com.attendance.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.attendance.model.Teacher;

public interface TeacherRepository extends JpaRepository<Teacher, Long> {
Optional<Teacher> findByUsername(String username);
}