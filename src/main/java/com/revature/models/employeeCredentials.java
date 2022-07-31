package com.revature.models;

import com.sun.istack.NotNull;

import javax.persistence.*;


@Entity
@Table(name = "employee_creds")
public class employeeCredentials {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "employee_id")
    private int app_id;

    @NotNull
    @Column(name = "first_name")
    private String fname;

    @NotNull
    @Column(name = "last_name")
    private String lname;

    @NotNull
    @Column(name = "username")
    private String uname;

    @NotNull
    @Column(name = "email")
    private String email;

    @NotNull
    @Column(name = "password")
    private String password;
}
