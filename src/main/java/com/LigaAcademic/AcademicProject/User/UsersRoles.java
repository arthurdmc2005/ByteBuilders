package com.LigaAcademic.AcademicProject.User;

import jakarta.persistence.Enumerated;


public enum UsersRoles {

    ADMIN("ADMIN"),

    USER("USER");

    private String role;

   UsersRoles(String role){
        this.role = role;
    }

    public String getRole(){
       return role;
    }
}
