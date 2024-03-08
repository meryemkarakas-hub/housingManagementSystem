package managementSystems.housingManagementSystem.application.core.oauth.service;

import jakarta.servlet.http.HttpSession;
import lombok.AllArgsConstructor;
import lombok.RequiredArgsConstructor;
import managementSystems.housingManagementSystem.application.core.oauth.dto.SessionDTO;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class SessionService {

    private final HttpSession httpSession;

    public SessionDTO getSession(){
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        SessionDTO sessionDTO = new SessionDTO();
        sessionDTO.setIdentityNumber(auth.getName());
        String userRole = (String) httpSession.getAttribute("userRole");
        Long residentialInfoId = (Long) httpSession.getAttribute("residentialInfoId");
        sessionDTO.setResidentialInfoId(residentialInfoId);
        sessionDTO.setUserRole(userRole);
        return sessionDTO;
    }

}
