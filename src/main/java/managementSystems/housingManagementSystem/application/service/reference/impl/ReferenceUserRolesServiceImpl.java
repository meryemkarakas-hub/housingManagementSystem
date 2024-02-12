package managementSystems.housingManagementSystem.application.service.reference.impl;

import lombok.RequiredArgsConstructor;
import managementSystems.housingManagementSystem.application.dto.reference.ReferenceUserRolesDTO;
import managementSystems.housingManagementSystem.application.mapper.reference.ReferenceUserRolesMapper;
import managementSystems.housingManagementSystem.application.repository.reference.ReferenceUserRolesRepository;
import managementSystems.housingManagementSystem.application.service.reference.ReferenceUserRolesService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@RequiredArgsConstructor
@Service
public class ReferenceUserRolesServiceImpl implements ReferenceUserRolesService {

    private final ReferenceUserRolesRepository referenceUserRolesRepository;

    private final ReferenceUserRolesMapper referenceUserRolesMapper;

    @Override
    public List<ReferenceUserRolesDTO> getAllUserRolesList() {
        return referenceUserRolesRepository.getAllCitiesList().stream().map(referenceUserRolesMapper::toDto).collect(Collectors.toList());
    }
}
