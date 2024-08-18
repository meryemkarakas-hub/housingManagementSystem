package managementSystems.housingManagementSystem.application.service.management.housingManagement.impl;

import lombok.RequiredArgsConstructor;
import managementSystems.housingManagementSystem.application.core.oauth.dto.SessionDTO;
import managementSystems.housingManagementSystem.application.core.oauth.service.SessionService;
import managementSystems.housingManagementSystem.application.dto.management.housingManagement.HousingInformationBlocksDTO;
import managementSystems.housingManagementSystem.application.entity.residential.Blocks;
import managementSystems.housingManagementSystem.application.mapper.residential.BlocksMapper;
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
import java.util.*;
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
        residentialInfoId=14L;
        List<Blocks> blocksList = blockRepository.findByResidentialInformation_Id(residentialInfoId);
        return blocksList.stream()
                .map(blocksMapper::toDto)
                .collect(Collectors.toList());
    }

    @Override
    public List<Map<String, String>> parseExcelFile(MultipartFile file) {
        List<Map<String, String>> data = new ArrayList<>();

        try (InputStream is = file.getInputStream();
             Workbook workbook = new XSSFWorkbook(is)) {

            Sheet sheet = workbook.getSheetAt(0);
            Iterator<Row> rows = sheet.iterator();

            while (rows.hasNext()) {
                Row row = rows.next();
                Iterator<Cell> cells = row.iterator();
                Map<String, String> rowData = new HashMap<>();

                while (cells.hasNext()) {
                    Cell cell = cells.next();
                    String cellValue = getCellValue(cell);
                    rowData.put("column" + cell.getColumnIndex(), cellValue);
                }

                data.add(rowData);
            }
        } catch (IOException e) {
            throw new RuntimeException("Error processing Excel file", e);
        }

        return data;
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
}
