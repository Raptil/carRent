package net.carProject.validator;


import net.carProject.domain.User;
import net.carProject.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

@Controller
public class UserValidator implements Validator {

    @Autowired
    @Qualifier(value = "UserService")
    private UserService userService;


    @Override
    public boolean supports(Class<?> clazz) {
        return User.class.equals(clazz);
    }

    @Override
    public void validate(Object target, Errors errors) {

        User user = (User) target;
        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "name", "Required");
        if (user.getName().length() > 8 || user.getName().length() < 50) {
            errors.rejectValue("name", "Size.userForm.username");
        }


    }
}
