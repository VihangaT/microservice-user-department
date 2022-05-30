package com.microservices.tech.vt.user_services.user_services.service;

import com.microservices.tech.vt.user_services.user_services.DTO.Department;
import com.microservices.tech.vt.user_services.user_services.DTO.ResponseTemplate;
import com.microservices.tech.vt.user_services.user_services.entity.User;
import com.microservices.tech.vt.user_services.user_services.repository.UserRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Slf4j
@Service
public class UserService {

    private UserRepository userRepository;
    private RestTemplate restTemplate;

    @Autowired
    public UserService(UserRepository userRepository, RestTemplate restTemplate) {
        this.userRepository = userRepository;
        this.restTemplate = restTemplate;
    }


    public User saveUser(User user) {
        log.info("In saveUser in service");
        return userRepository.save(user);
    }

    public ResponseTemplate getUserWithDepartment(Long userId) {
        log.info("In getUserWithDepartment in service");
        ResponseTemplate vo = new ResponseTemplate();
        User user = userRepository.findByUserId(userId);
        Department department = restTemplate.getForObject("http://DEPARTMENT-SERVICE/departments/" + user.getDepartmentId(), Department.class);
        vo.setDepartment(department);
        vo.setUser(user);
        return vo;
    }
}
