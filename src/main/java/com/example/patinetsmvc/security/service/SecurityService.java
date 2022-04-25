package com.example.patinetsmvc.security.service;

import com.example.patinetsmvc.security.entities.AppRole;
import com.example.patinetsmvc.security.entities.AppUser;

public interface SecurityService  {
    AppUser saveUser(String username, String password,String rePassword);
    AppRole saveNewRole(String roleName,String description);
    void addRoleToUser(String username , String roleName);
    void removeRoleFromUser(String username , String roleName);
    AppUser loadUserByUserName(String username);
}
