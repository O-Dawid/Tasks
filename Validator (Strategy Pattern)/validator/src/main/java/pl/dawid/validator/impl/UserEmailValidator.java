package pl.dawid.validator.impl;

import org.apache.commons.validator.routines.EmailValidator;
import org.springframework.stereotype.Component;

import lombok.extern.slf4j.Slf4j;
import pl.dawid.domain.User;
import pl.dawid.domain.UserType;
import pl.dawid.exception.UserValidationException;
import pl.dawid.validator.Validator;

@Component
@Slf4j
public class UserEmailValidator implements Validator {
    final String RESULT_INFO = "%s has wrong email format";

    @Override
    public boolean isValid(User user) {
        if (!emailIsValid(user))
            throw new UserValidationException(String.format(RESULT_INFO, user.getName()));
        log.info(user.getUserType() + " " + user.getEmail() + " is Valid");
        return true;

    }

    @Override
    public UserType getType() {
        return UserType.USER;
    }

    private boolean emailIsValid(User user) {
        return EmailValidator.getInstance().isValid(user.getEmail());
    }
}