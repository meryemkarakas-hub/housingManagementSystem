package managementSystems.housingManagementSystem.application.service.management.housingManagement.impl;

import lombok.RequiredArgsConstructor;
import managementSystems.housingManagementSystem.application.core.dto.GeneralMessageDTO;
import managementSystems.housingManagementSystem.application.core.oauth.dto.SessionDTO;
import managementSystems.housingManagementSystem.application.core.oauth.service.SessionService;
import managementSystems.housingManagementSystem.application.dto.management.housingManagement.HousingInformationBlocksDTO;
import managementSystems.housingManagementSystem.application.entity.residential.Blocks;
import managementSystems.housingManagementSystem.application.entity.residential.HousingInformation;
import managementSystems.housingManagementSystem.application.mapper.residential.BlocksMapper;
import managementSystems.housingManagementSystem.application.repository.management.HousingInformationRepository;
import managementSystems.housingManagementSystem.application.repository.residential.BlockRepository;
import managementSystems.housingManagementSystem.application.service.management.housingManagement.HousingManagementService;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.io.InputStream;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@RequiredArgsConstructor
@Service
public class HousingManagementServiceImpl implements HousingManagementService {

    private final BlockRepository blockRepository;

    private final BlocksMapper blocksMapper;

    private final SessionService sessionService;

    private final HousingInformationRepository housingInformationRepository;

    private static final Map<String, String> COLUMN_NAME_MAP = Map.ofEntries(
            Map.entry("Konut Cephesi", "aspect"),
            Map.entry("Elektrik Abonelik Numarası", "electricity_subscription_number"),
            Map.entry("Kat Numarası", "flat_number"),
            Map.entry("Daire Numarası", "home_number"),
            Map.entry("Konutun Metrekaresi", "home_square_meters"),
            Map.entry("Ev Sahibi E-posta Adresi", "home_owner_email_address"),
            Map.entry("Ev Sahibi TC Kimlik Numarası", "home_owner_identity_number"),
            Map.entry("Ev Sahibi Adı", "home_owner_name"),
            Map.entry("Ev Sahibi Soyadı", "home_owner_surname"),
            Map.entry("Kiracı E-posta Adresi", "leaseholder_email_address"),
            Map.entry("Kiracı TC Kimlik Numarası", "leaseholder_identity_number"),
            Map.entry("Kiracı Adı", "leaseholder_name"),
            Map.entry("Kiracı Soyadı", "leaseholder_surname"),
            Map.entry("Doğal Gaz Abonelik Numarası", "natural_gas_subscription_number"),
            Map.entry("Balkon Sayısı", "number_of_balconies"),
            Map.entry("Banyo Sayısı", "number_of_bathrooms"),
            Map.entry("Oda Sayısı", "number_of_rooms"),
            Map.entry("Su Abonelik Numarası", "water_subscription_number"),
            Map.entry("Blok Adı", "blocks_id")
    );

    @Override
    public List<HousingInformationBlocksDTO> getAllBlockNameList() {
        SessionDTO sessionDTO = sessionService.getSession();
        Long residentialInfoId = sessionDTO.getResidentialInfoId();
        residentialInfoId = 14L;
        List<Blocks> blocksList = blockRepository.findByResidentialInformation_Id(residentialInfoId);
        return blocksList.stream()
                .map(blocksMapper::toDto)
                .collect(Collectors.toList());
    }


    private String getCellValue(Cell cell) {
        switch (cell.getCellType()) {
            case STRING:
                return cell.getStringCellValue();
            case NUMERIC:
                return String.valueOf(cell.getNumericCellValue());
            case BOOLEAN:
                return String.valueOf(cell.getBooleanCellValue());
            case FORMULA:
                return cell.getCellFormula();
            default:
                return "";
        }
    }

    @Override
    public GeneralMessageDTO parseExcelFile(String blockName, MultipartFile file) {
        try (InputStream is = file.getInputStream();
             Workbook workbook = new XSSFWorkbook(is)) {

            Sheet sheet = workbook.getSheetAt(0);
            Iterator<Row> rows = sheet.iterator();

            // Başlık satırını al
            Row headerRow = sheet.getRow(0);
            Map<Integer, String> headerMap = new HashMap<>();
            for (Cell cell : headerRow) {
                String columnHeader = cell.getStringCellValue();
                headerMap.put(cell.getColumnIndex(), COLUMN_NAME_MAP.getOrDefault(columnHeader, ""));
            }

            // Başlık satırını geç
            rows.next();

            // Verileri okuma ve kaydetme
            while (rows.hasNext()) {
                Row row = rows.next();
                Iterator<Cell> cells = row.iterator();
                HousingInformation housingInformation = new HousingInformation();

                while (cells.hasNext()) {
                    Cell cell = cells.next();
                    String cellValue = getCellValue(cell);
                    String columnName = headerMap.get(cell.getColumnIndex());

                    switch (columnName) {
                        case "aspect":
                            housingInformation.setAspect(cellValue);
                            break;
                        case "electricity_subscription_number":
                            housingInformation.setElectricitySubscriptionNumber(cellValue);
                            break;
                        case "flat_number":
                            housingInformation.setFlatNumber(cellValue);
                            break;
                        case "home_number":
                            housingInformation.setHomeNumber(cellValue);
                            break;
                        case "home_square_meters":
                            housingInformation.setHomeSquareMeters(Float.valueOf(cellValue));
                            break;
                        case "home_owner_email_address":
                            housingInformation.setHomeOwnerEmailAddress(cellValue);
                            break;
                        case "home_owner_identity_number":
                            housingInformation.setHomeOwnerIdentityNumber(cellValue);
                            break;
                        case "home_owner_name":
                            housingInformation.setHomeOwnerName(cellValue);
                            break;
                        case "home_owner_surname":
                            housingInformation.setHomeOwnerSurname(cellValue);
                            break;
                        case "leaseholder_email_address":
                            housingInformation.setLeaseholderEmailAddress(cellValue);
                            break;
                        case "leaseholder_identity_number":
                            housingInformation.setLeaseholderIdentityNumber(cellValue);
                            break;
                        case "leaseholder_name":
                            housingInformation.setLeaseholderName(cellValue);
                            break;
                        case "leaseholder_surname":
                            housingInformation.setLeaseholderSurname(cellValue);
                            break;
                        case "natural_gas_subscription_number":
                            housingInformation.setNaturalGasSubscriptionNumber(cellValue);
                            break;
                        case "number_of_balconies":
                            housingInformation.setNumberOfBalconies(cellValue);
                            break;
                        case "number_of_bathrooms":
                            housingInformation.setNumberOfBathrooms(cellValue);
                            break;
                        case "number_of_rooms":
                            housingInformation.setNumberOfRooms(cellValue);
                            break;
                        case "water_subscription_number":
                            housingInformation.setWaterSubscriptionNumber(cellValue);
                            break;
                        case "blocks_id":
                            housingInformation.getBlocks().setBlockName(blockName);
                            break;
                    }
                }

                housingInformationRepository.save(housingInformation);
            }
        } catch (IOException e) {
            throw new RuntimeException("Excel dosyasını işleme hatası", e);
        }
        return new GeneralMessageDTO(1, "Konut bilgisi ekleme işleminiz başarıyla gerçekleştirildi.");
    }
}
