package com.ritanath.library.dto;

import com.fasterxml.jackson.annotation.JsonInclude;
import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Schema(name = "Student", description = "Student Model")
@JsonInclude(JsonInclude.Include.NON_NULL) // Ignore null values during serialization
public class UserDto {

    private Long id;

    @NotBlank(message = "Name is Required And Not Null")
    private String name;

    @NotBlank(message = "Email is Required And Not Null")
    @Email(message = "Email Must Be Valid")
    @Schema(example = "ritanath.test@gmail.com")
    private String email;

    @NotBlank(message = "Phone is Required And Not Null")
    @Schema(example = "123 456 7890")
    private String phone;

    @NotBlank(message = "Address is Required And Not Null")
    private String address;
}
