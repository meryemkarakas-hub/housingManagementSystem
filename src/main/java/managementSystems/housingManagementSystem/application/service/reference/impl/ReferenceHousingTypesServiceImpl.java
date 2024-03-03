package managementSystems.housingManagementSystem.application.service.reference.impl;

import lombok.RequiredArgsConstructor;
import managementSystems.housingManagementSystem.application.dto.reference.ReferenceHousingTypesDTO;
import managementSystems.housingManagementSystem.application.mapper.reference.ReferenceHousingTypesMapper;
import managementSystems.housingManagementSystem.application.repository.reference.ReferenceHousingTypesRepository;
import managementSystems.housingManagementSystem.application.service.reference.ReferenceHousingTypesService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@RequiredArgsConstructor
@Service
public class ReferenceHousingTypesServiceImpl implements ReferenceHousingTypesService {
    private final ReferenceHousingTypesRepository referenceHousingTypesRepository;

    private final ReferenceHousingTypesMapper referenceHousingTypesMapper;

    @Override
    public List<ReferenceHousingTypesDTO> getAllHousingTypesList() {
        return referenceHousingTypesRepository.getAllHousingTypesList().stream().map(referenceHousingTypesMapper::toDto).collect(Collectors.toList());
    }
}
