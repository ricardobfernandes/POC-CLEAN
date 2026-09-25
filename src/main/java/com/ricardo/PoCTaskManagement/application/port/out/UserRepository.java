package com.ricardo.PoCTaskManagement.application.port.out;

import com.ricardo.PoCTaskManagement.domain.model.User;

public interface UserRepository {

    User save(User user);

    boolean existsById(Long id);
}
