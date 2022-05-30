package com.microservices.tech.vt.user_services.user_services.DTO;

import com.microservices.tech.vt.user_services.user_services.entity.User;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ResponseTemplate {
    private User user;
    private Department department;
}
