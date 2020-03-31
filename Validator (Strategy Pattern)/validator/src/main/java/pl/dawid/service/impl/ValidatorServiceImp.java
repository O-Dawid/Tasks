package pl.dawid.service.impl;

import java.util.EnumMap;
import java.util.List;
import java.util.function.Function;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;

import pl.dawid.domain.User;
import pl.dawid.domain.UserType;
import pl.dawid.service.ValidatorService;
import pl.dawid.validator.Validator;

@Service
public class ValidatorServiceImp implements ValidatorService {
    EnumMap<UserType, Validator> validators;

    public ValidatorServiceImp(List<Validator> validatorList) {
        validators = validatorList.stream()
                .collect(Collectors.toMap(Validator::getType, Function.identity(), (l, r) -> {
                    throw new IllegalArgumentException("Duplicate keys " + l + "and " + r + ".");
                }, () -> new EnumMap<>(UserType.class)));
    }

    @Override
    public void validate(User user) {
        getValidator(user.getUserType()).isValid(user);
    }

    private Validator getValidator(UserType userType) {
        return validators.get(userType);
    }

}