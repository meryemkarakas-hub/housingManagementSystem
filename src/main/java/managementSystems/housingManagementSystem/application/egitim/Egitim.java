package managementSystems.housingManagementSystem.application.egitim;

import managementSystems.housingManagementSystem.application.dto.management.ManagementSelectResponseDTO;

import java.util.ArrayList;
import java.util.List;

public class Egitim {

    public static void main(String[] args) {
        List<ManagementSelectResponseDTO> dtoList = new ArrayList<>();
        ManagementSelectResponseDTO managementSelectResponseDTO=new ManagementSelectResponseDTO();
        managementSelectResponseDTO.setId(1L);
        managementSelectResponseDTO.setInformationManagementSelect("Meryem");
        dtoList.add(managementSelectResponseDTO);
        ManagementSelectResponseDTO managementSelectResponseDTO1=new ManagementSelectResponseDTO();
        managementSelectResponseDTO1.setId(2L);
        managementSelectResponseDTO1.setInformationManagementSelect("Eren");
        dtoList.add(managementSelectResponseDTO1);
        System.out.println("Bitti");
    }
}
