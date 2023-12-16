package site.leui.todoserver.dto;

import jakarta.validation.constraints.*;
import lombok.*;

import java.time.LocalDateTime;

@Getter @Setter
@NoArgsConstructor
public class TodoForSave {
    @Null
    private Long id;

    @NotNull
    @NotBlank
    private String title;

    @NotNull
    @NotBlank
    private String status;

    @NotNull
    @Future
    private LocalDateTime dueDate;

    @NotNull
    @FutureOrPresent
    private LocalDateTime createdTime;
}
