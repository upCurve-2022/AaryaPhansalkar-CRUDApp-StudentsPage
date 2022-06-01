package com.TargetCrudApplication.demoCrud.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "table_student")

public class studentModel
{
    @Id
    @GeneratedValue

    private int studentId;
    private String studentName;
    private String studentBranch;
    private String college;
    private String interest;
}

