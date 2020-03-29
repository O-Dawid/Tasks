package pl.dawid.validator.impl;

import org.apache.commons.validator.routines.EmailValidator;
import org.springframework.stereotype.Component;

import pl.dawid.domain.User;
import pl.dawid.domain.UserType;
import pl.dawid.exception.UserValidationException;
import pl.dawid.validator.Validator;

@Component
public class UserEmailValidator implements Validator {
    final String RESULT_INFO = "%s has wrong email format";

    @Override
    public void validate(User user) {
        if (!emailIsValid(user))
            throw new UserValidationException(String.format(RESULT_INFO, user.getName()));
    }

    private boolean emailIsValid(User user) {
        return EmailValidator.getInstance().isValid(user.getEmail());
    }

    @Override
    public UserType getType() {
        return UserType.USER;
    }
}