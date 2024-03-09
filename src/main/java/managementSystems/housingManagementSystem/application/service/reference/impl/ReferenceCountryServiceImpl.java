package managementSystems.housingManagementSystem.application.service.reference.impl;

import lombok.RequiredArgsConstructor;
import managementSystems.housingManagementSystem.application.dto.reference.ReferenceCountryDTO;
import managementSystems.housingManagementSystem.application.mapper.reference.ReferenceCountryMapper;
import managementSystems.housingManagementSystem.application.repository.reference.ReferenceCountryRepository;
import managementSystems.housingManagementSystem.application.service.reference.ReferenceCountryService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@RequiredArgsConstructor
@Service
public class ReferenceCountryServiceImpl implements ReferenceCountryService {

    private final ReferenceCountryRepository referenceCountryRepository;

    private final ReferenceCountryMapper referenceCountryMapper;

    @Override
    public List<ReferenceCountryDTO> getAllCountryList() {
        return referenceCountryRepository.getAllCountryList().stream().map(referenceCountryMapper::toDto).collect(Collectors.toList());
    }
}
