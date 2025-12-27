package com.notification.ons.service;

import com.notification.ons.domain.User;
import com.notification.ons.dto.user.CreateUserRequest;
import com.notification.ons.repository.UserRepository;
import org.springframework.stereotype.Service;

@Service
public class UserService {

    private UserRepository userRepository;

    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    //create user
    public User createUser(CreateUserRequest createUserRequest){
        try {
           /* User user = User.builder().
                    userId(createUserRequest.userId());*/

        }catch (Exception exception){

        }
        return null;
    }

}
