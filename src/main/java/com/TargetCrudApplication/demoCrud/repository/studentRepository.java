package com.TargetCrudApplication.demoCrud.repository;

import com.TargetCrudApplication.demoCrud.entity.studentModel;
import org.springframework.data.jpa.repository.JpaRepository;

public interface studentRepository extends JpaRepository<studentModel, Integer>
{

}
