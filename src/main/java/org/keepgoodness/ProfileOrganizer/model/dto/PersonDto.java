package org.keepgoodness.ProfileOrganizer.model.dto;

import jakarta.validation.Valid;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;

import java.util.List;

public class PersonDto {

    private Long id;
    @NotNull(message = "Трябва да бъде въведено")
    @Pattern(regexp = "^[a-zA-Zа-яА-Я -]+$", message = "Може да съдържа букви само на латиница или кирилица, интервал и тире.")
    private String fullName;
    @Pattern(regexp = "^\\d{10}$", message = "Може да съдържа само и точно 10 цифри, като е допустима водеща нула.")
    private String pin;

    @Valid
    private List<EmailDto> mails;

    public PersonDto() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public String getPin() {
        return pin;
    }

    public void setPin(String pin) {
        this.pin = pin;
    }

    public List<EmailDto> getMails() {
        return mails;
    }

    public void setMails(List<EmailDto> mails) {
        this.mails = mails;
    }
}
