package com.cholecystectomy.domain.dto.auth;

import com.cholecystectomy.domain.model.Sex;
import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.*;
import lombok.Data;

@Data
@Schema(description = "Запрос на регистрацию")
public class SignUpRequest {

    @Schema(description = "ФИО", example = "Иванов Иван Иванович")
    @Size(min = 5, max = 50, message = "Имя пользователя должно содержать от 5 до 50 символов")
    @NotBlank(message = "Имя пользователя не может быть пустыми")
    @Pattern(
            regexp = "^[a-zA-Zа-яёА-ЯЁ]{2,}\\s[a-zA-Zа-яёА-ЯЁ]{2,}\\s[a-zA-Zа-яёА-ЯЁ]{2,}",
            message = "Имя должно быть в формате: Иванов Иван Иванович"
    )
    private String name;

    @Schema(description = "Адрес электронной почты", example = "jondoe@gmail.com")
    @Size(min = 5, max = 255, message = "Адрес электронной почты должен содержать от 5 до 255 символов")
    @NotBlank(message = "Адрес электронной почты не может быть пустыми")
    @Email(message = "Email адрес должен быть в формате user@example.com")
    private String email;

    @Schema(description = "Пол")
    private Sex sex;

    @Schema(description = "Пароль", example = "my_1secret1_password")
    @Size(min = 8, message = "Длина пароля должна быть не менее 8 символов")
    @Size(max = 255, message = "Длина пароля должна быть не более 255 символов")
    private String password;

}
