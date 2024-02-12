package managementSystems.housingManagementSystem.application.service.reference.impl;

import lombok.RequiredArgsConstructor;
import managementSystems.housingManagementSystem.application.dto.reference.ReferenceGenderDTO;
import managementSystems.housingManagementSystem.application.mapper.reference.ReferenceGenderMapper;
import managementSystems.housingManagementSystem.application.repository.reference.ReferenceGenderRepository;
import managementSystems.housingManagementSystem.application.service.reference.ReferenceGenderService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@RequiredArgsConstructor
@Service
public class ReferenceGenderServiceImpl implements ReferenceGenderService {
    private final ReferenceGenderRepository referenceGenderRepository;

    private final ReferenceGenderMapper referenceGenderMapper;

    @Override
    public List<ReferenceGenderDTO> getAllGenderList() {
        return referenceGenderRepository.getAllGenderList().stream().map(referenceGenderMapper::toDto).collect(Collectors.toList());
    }
}
