package org.keepgoodness.ProfileOrganizer.model.dto;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.Size;

public class EmailDto {

    private Long id;
    @Size(max = 5)
    private String emailType;
    @Email(regexp = "^(?!\\.)[A-Za-z0-9._%+-]+(?<!\\.)@[A-Za-z0-9.-]+\\.[A-Za-z]{2,}$", message = "Неправилен формат на имейл адрес")
    private String email;

    public EmailDto() {
    }

    public EmailDto(String emailType, String email) {
        this.emailType = emailType;
        this.email = email;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getEmailType() {
        return emailType;
    }

    public void setEmailType(String emailType) {
        this.emailType = emailType;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}
