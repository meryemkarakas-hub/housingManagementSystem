package managementSystems.housingManagementSystem.application.service.reference.impl;

import lombok.RequiredArgsConstructor;
import managementSystems.housingManagementSystem.application.dto.reference.ReferenceCityDTO;
import managementSystems.housingManagementSystem.application.mapper.reference.ReferenceCityMapper;
import managementSystems.housingManagementSystem.application.repository.reference.ReferenceCityRepository;
import managementSystems.housingManagementSystem.application.service.reference.ReferenceCityService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@RequiredArgsConstructor
@Service
public class ReferenceCityServiceImpl implements ReferenceCityService {

    private final ReferenceCityRepository referenceCityRepository;

    private final ReferenceCityMapper referenceCityMapper;
    @Override
    public List<ReferenceCityDTO> getAllCityList() {
        return referenceCityRepository.getAllCityList().stream().map(referenceCityMapper::toDto).collect(Collectors.toList());
    }
}
