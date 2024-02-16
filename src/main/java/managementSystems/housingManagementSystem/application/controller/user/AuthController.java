package managementSystems.housingManagementSystem.application.controller.user;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import managementSystems.housingManagementSystem.application.core.dto.GeneralMessageDTO;
import managementSystems.housingManagementSystem.application.core.oauth.jwt.JwtUtils;
import managementSystems.housingManagementSystem.application.core.oauth.response.JwtResponse;
import managementSystems.housingManagementSystem.application.core.oauth.service.UserDetailsImpl;
import managementSystems.housingManagementSystem.application.dto.user.ActivationDTO;
import managementSystems.housingManagementSystem.application.dto.user.LoginDTO;
import managementSystems.housingManagementSystem.application.dto.user.ResetPasswordDTO;
import managementSystems.housingManagementSystem.application.dto.user.SignUpDTO;
import managementSystems.housingManagementSystem.application.service.UserService;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping(value = "/api/auth", produces = MediaType.APPLICATION_JSON_VALUE)
@RequiredArgsConstructor
public class AuthController {

    private final AuthenticationManager authenticationManager;
    private final UserService userService;
    private final JwtUtils jwtUtils;

    @PostMapping("/sign-up")
    ResponseEntity<GeneralMessageDTO> signUp(@Valid @RequestBody SignUpDTO signUpDTO) {
        return new ResponseEntity<>(userService.signUp(signUpDTO), HttpStatus.OK);
    }

    @PostMapping("/activation")
    ResponseEntity<GeneralMessageDTO> activation(@Valid @RequestBody ActivationDTO activationDTO) {
        return new ResponseEntity<>(userService.activation(activationDTO), HttpStatus.OK);
    }

    @PostMapping("/login")
    ResponseEntity<JwtResponse> login(@Valid @RequestBody LoginDTO loginDTO) {
        Authentication authentication = authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(loginDTO.getIdentityNumber(),loginDTO.getPassword()));
        SecurityContextHolder.getContext().setAuthentication(authentication);
        String jwt = jwtUtils.generateJwtToken(authentication);
        UserDetailsImpl userDetails = (UserDetailsImpl) authentication.getPrincipal();
        List<String> roles = userDetails.getAuthorities().stream()
                .map(item -> item.getAuthority())
                .collect(Collectors.toList());
        return ResponseEntity.ok(new JwtResponse(jwt,
                userDetails.getId(),
                userDetails.getUsername(),
                userDetails.getIdentityNumber(),
                roles));
    }

    @PostMapping("/reset-password")
    ResponseEntity<GeneralMessageDTO> resetPassword(@Valid @RequestBody ResetPasswordDTO resetPasswordDTO) {
        return new ResponseEntity<>(userService.resetPassword(resetPasswordDTO), HttpStatus.OK);
    }
}
