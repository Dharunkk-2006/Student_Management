package com.Example.StudentManagement1.Repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.Example.StudentManagement1.Entity.Students;

public interface StudentRepository extends JpaRepository<Students,Long> {

}

