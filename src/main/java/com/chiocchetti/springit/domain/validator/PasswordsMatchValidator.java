package com.chiocchetti.springit.domain.validator;

import com.chiocchetti.springit.domain.User;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

public class PasswordsMatchValidator implements ConstraintValidator<PasswordsMatch,User> {

    @Override
    public boolean isValid(User user, ConstraintValidatorContext context) {
        return user.getPassword().equals(user.getConfirmPassword());
    }

    @Override
    public void initialize(PasswordsMatch constraintAnnotation) {

    }
}
