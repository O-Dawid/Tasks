package pl.dawid.validator.impl;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.springframework.stereotype.Component;

import pl.dawid.domain.User;
import pl.dawid.domain.UserType;
import pl.dawid.exception.UserValidationException;
import pl.dawid.validator.Validator;

@Component
public class ManagerValidator implements Validator {
    final String RESULT_INFO = "%s is not manager";
    final Pattern VALID_EMAIL_ADDRESS_REGEX = Pattern.compile("^[\\w-_\\.+]*[\\w-_\\.]\\@manager.com$",
            Pattern.CASE_INSENSITIVE);

    @Override
    public void validate(User user) {
        if (!isManager(user))
            throw new UserValidationException(String.format(RESULT_INFO, user.getName()));
    }

    @Override
    public UserType getType() {
        return UserType.MANAGER;
    }

    boolean isManager(User user) {
        Matcher matcher = VALID_EMAIL_ADDRESS_REGEX.matcher(user.getEmail());
        return matcher.find();
    }
}