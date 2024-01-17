package com.ra.model.dto.request;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.validator.constraints.Length;

@NoArgsConstructor
@AllArgsConstructor
@Data
@Builder
public class UserLogin {
    @NotEmpty(message = "not Empty")
    private String username;
    @NotEmpty(message = "not Empty")
    @Length(min = 6, max = 256, message = "Password phải có ít nhất 6 ký tự, và không quá 256 ký tự.")
    private String password;
}
