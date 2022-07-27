package com.example.registring;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class UserService {
    @Autowired
    public UserRepository repo;

    @Autowired
    RoleRepository roleRepository;

    public void saveDefaultUser(User user)
    {
        BCryptPasswordEncoder bCryptPasswordEncoder = new BCryptPasswordEncoder();
        String encodedpassword = bCryptPasswordEncoder.encode(user.getPassword());
        user.setPassword(encodedpassword);

        Role role = roleRepository.findbyName("User");
        user.addRole(role);
        repo.save(user);



    }

}
