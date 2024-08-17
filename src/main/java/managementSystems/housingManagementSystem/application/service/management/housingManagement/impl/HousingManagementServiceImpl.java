package managementSystems.housingManagementSystem.application.service.management.housingManagement.impl;

import lombok.RequiredArgsConstructor;
import managementSystems.housingManagementSystem.application.core.oauth.dto.SessionDTO;
import managementSystems.housingManagementSystem.application.core.oauth.service.SessionService;
import managementSystems.housingManagementSystem.application.dto.management.housingManagement.HousingInformationBlocksDTO;
import managementSystems.housingManagementSystem.application.entity.residential.Blocks;
import managementSystems.housingManagementSystem.application.mapper.residential.BlocksMapper;
import managementSystems.housingManagementSystem.application.repository.residential.BlockRepository;
import managementSystems.housingManagementSystem.application.service.management.housingManagement.HousingManagementService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;
@RequiredArgsConstructor
@Service
public class HousingManagementServiceImpl implements HousingManagementService {

    private final BlockRepository blockRepository;

    private final BlocksMapper blocksMapper;

    private final SessionService sessionService;


    @Override
    public List<HousingInformationBlocksDTO> getAllBlockNameList() {
        SessionDTO sessionDTO = sessionService.getSession();
        Long residentialInfoId = sessionDTO.getResidentialInfoId();
        List<Blocks> blocksList = blockRepository.findByResidentialInformation_Id(residentialInfoId);
        return blocksList.stream()
                .map(blocksMapper::toDto)
                .collect(Collectors.toList());
    }
}
