package com.example.auth2.registration;


import com.example.auth2.user.AppUser;
import com.example.auth2.user.AppUserRole;
import com.example.auth2.user.AppUserService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class RegistrationService {

    private final AppUserService appUserService;
    private final EmailValidator emailValidator;
    public String register(RegistrationRequest request) {
        boolean isEmailValid = emailValidator.test(request.getEmail());

        if(!isEmailValid) {
            throw new IllegalArgumentException("email not valid !");
        }
        return appUserService.singUpUser(
                new AppUser(
                        request.getFirstName(),
                        request.getLastName(),
                        request.getEmail(),
                        request.getUsername(),
                        request.getPassword(),
                        AppUserRole.USER)
        );
    }
}
