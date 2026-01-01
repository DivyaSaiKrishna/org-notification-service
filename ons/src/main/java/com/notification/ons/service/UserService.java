package com.notification.ons.service;

import com.notification.ons.domain.User;
import com.notification.ons.dto.user.CreateUserRequest;
import com.notification.ons.dto.user.UpdateUserRequest;
import com.notification.ons.repository.UserRepository;
import org.springframework.stereotype.Service;

import java.time.Instant;
import java.util.List;
import java.util.Optional;
import java.util.Set;
import java.util.stream.Collectors;

@Service
public class UserService {

    private String className = "UserService";

    private UserRepository userRepository;

    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    private ErrorLogService errorLogService;

    //create user
    public User createUser(CreateUserRequest createUserRequest){
        User user = null;
        try {
            user  = User.builder().
                       userId(createUserRequest.userId()).
                       email(createUserRequest.email()).
                       phoneNumber(createUserRequest.phoneNumber()).
                       preferredChannels(createUserRequest.preferredChannels()).
                       active(Boolean.TRUE).
                        appToken(createUserRequest.appToken()).
                        timezone(createUserRequest.timezone()).
                        createdAt(Instant.now()).
                        updatedAt(Instant.now())
                   .build();

        }catch (Exception exception){
            errorLogService.logException(className, createUserRequest.userId(), exception);
        }
        return user;
    }

    //get users info
    public List<User> getUsersInfo(Set<String> userIds){
        return userIds.stream().
                map(userRepository::findById)
                .filter(Optional::isPresent)
                .map(Optional::get)
                .collect(Collectors.toList());

    }

    //get user info
    public User getUserInfo(String userId){
        return userRepository.findById(userId)
                .orElseThrow(() -> new RuntimeException("User not found"));
    }

    //update user
    public User updateUser( UpdateUserRequest updateUserRequest){
        boolean updateUser = Boolean.FALSE;
        User user = null;

        try{
            user = getUserInfo(updateUserRequest.userId());
            if (updateUserRequest.email() != null && !updateUserRequest.email().equals(user.getEmail())) {
                user.setEmail(updateUserRequest.email());
                updateUser = Boolean.TRUE;
            }
            if (updateUserRequest.phoneNumber() != null && !updateUserRequest.phoneNumber().equals(user.getPhoneNumber())){
                user.setPhoneNumber(updateUserRequest.phoneNumber());
                updateUser = Boolean.TRUE;
            }
            if (updateUserRequest.appToken() != null && !updateUserRequest.appToken().equals(user.getAppToken())){
                user.setAppToken(updateUserRequest.appToken());
                updateUser = Boolean.TRUE;
            }
            if (updateUserRequest.preferredChannels() != null && !updateUserRequest.preferredChannels().equals(user.getPreferredChannels())){
                user.setPreferredChannels(updateUserRequest.preferredChannels());
                updateUser = Boolean.TRUE;
            }

            if(updateUser){
                user.setUpdatedAt(Instant.now());
                userRepository.save(user);
            }

        }catch (Exception exception){
            errorLogService.logException(className, updateUserRequest.userId(), exception);
        }
        return user;
    }

    //de-activate user
    public void deactivateUser(String userId){
        Set<String> usersIds = Set.of(userId);

        User user = getUserInfo(userId);
        user.setActive(Boolean.FALSE);
        userRepository.save(user);

    }

}
