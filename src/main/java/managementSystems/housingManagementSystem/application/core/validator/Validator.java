package managementSystems.housingManagementSystem.application.core.validator;

import java.time.LocalDate;

public class Validator {
    private StringBuilder errorMessage = new StringBuilder();

    public void validateNotNullOrEmpty(String value, String fieldName) {
        if (isNullOrEmpty(value)) {
            appendErrorMessage(fieldName + " alanı boş bırakılamaz.");
        }
    }

    public void validateNotNull(Object value, String fieldName) {
        if (value == null) {
            appendErrorMessage(fieldName + " alanı boş bırakılamaz.");
        }
    }

    public void validateDateOfBirthNotUnderAge(LocalDate dateOfBirth, int minimumAge, String fieldName) {
        if (dateOfBirth == null) {
            return;
        }
        LocalDate currentDate = LocalDate.now();
        LocalDate minimumBirthDate = currentDate.minusYears(minimumAge);
        if (dateOfBirth.isAfter(minimumBirthDate)) {
            appendErrorMessage(fieldName + " alanı 18'den küçük olamaz.");
        }
    }

    public boolean isValid() {
        return errorMessage.length() == 0;
    }

    public String getErrorMessage() {
        return errorMessage.toString();
    }

    private boolean isNullOrEmpty(String value) {
        return value == null || value.trim().isEmpty();
    }

    private void appendErrorMessage(String message) {
        if (errorMessage.length() > 0) {
            errorMessage.append("\n");
        }
        errorMessage.append(message);
    }
}
