package site.leui.todoserver.dto;

import jakarta.validation.constraints.Future;
import jakarta.validation.constraints.FutureOrPresent;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;

@Getter @Setter
@NoArgsConstructor
public class TodoForEdit {
    @NotNull
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
    private LocalDateTime modifiedTime;
}
