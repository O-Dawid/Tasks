package pl.dawid.service.impl;

import org.springframework.stereotype.Service;

import lombok.extern.slf4j.Slf4j;
import pl.dawid.domain.User;
import pl.dawid.service.UserService;
import pl.dawid.service.ValidatorService;

@Service
@Slf4j
public class UserServiceImp implements UserService {

    ValidatorService validatorService;

    public UserServiceImp(ValidatorService validatorService) {
        this.validatorService = validatorService;
    }

    @Override
    public void createUser(User user) {
        validatorService.validate(user);
        log.info(user.getUserType() + " " + user.getEmail() + " was created");
    }

}