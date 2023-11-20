package com.prasad.springweb.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.prasad.springweb.entity.Student;

public interface StudentRepository extends JpaRepository<Student, Integer> {

}
