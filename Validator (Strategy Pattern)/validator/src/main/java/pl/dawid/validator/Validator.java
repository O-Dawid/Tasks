package pl.dawid.validator;

import pl.dawid.domain.User;
import pl.dawid.domain.UserType;

public interface Validator {
    boolean isValid(User user);

    UserType getType();
}