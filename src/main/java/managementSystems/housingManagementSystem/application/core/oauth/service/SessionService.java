package managementSystems.housingManagementSystem.application.core.oauth.service;

import managementSystems.housingManagementSystem.application.core.oauth.dto.SessionDTO;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;

@Service
public class SessionService {

    public SessionDTO getSession(){
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        SessionDTO sessionDTO = new SessionDTO(auth.getName());
        return sessionDTO;
    }

}
