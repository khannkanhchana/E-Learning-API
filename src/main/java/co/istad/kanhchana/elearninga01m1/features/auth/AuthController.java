//package co.istad.kanhchana.elearninga01m1.features.auth;
//
//
//import co.istad.kanhchana.elearninga01m1.features.auth.dto.RegisterRequest;
//import co.istad.kanhchana.elearninga01m1.features.auth.dto.RegisterResponse;
//import jakarta.validation.Valid;
//import lombok.RequiredArgsConstructor;
//import org.springframework.web.bind.annotation.PostMapping;
//import org.springframework.web.bind.annotation.RequestBody;
//import org.springframework.web.bind.annotation.RequestMapping;
//import org.springframework.web.bind.annotation.RestController;
//
//@RestController
//@RequestMapping("/api/v1/auth")
//@RequiredArgsConstructor
//public class AuthController {
//    private final AuthService authService;
//
//    @PostMapping("/register")
//    public RegisterResponse register(@Valid @RequestBody RegisterRequest registerRequest){
//        return  authService.register(registerRequest);
//
//
//    }
//}

package co.istad.kanhchana.elearninga01m1.features.auth;

import co.istad.kanhchana.elearninga01m1.features.auth.dto.RegisterRequest;
import co.istad.kanhchana.elearninga01m1.features.auth.dto.RegisterResponse;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/auth")
@RequiredArgsConstructor
public class AuthController {

    private final AuthService authService;

    @PostMapping("/register")
    public ResponseEntity<RegisterResponse> register(
            @Valid @RequestBody RegisterRequest registerRequest) {

        RegisterResponse response = authService.register(registerRequest);

        return ResponseEntity
                .status(HttpStatus.CREATED)
                .body(response);
    }
}
