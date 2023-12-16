package site.leui.todoserver.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter @Setter
@NoArgsConstructor
public class TodoStatusForUpdate {
    @NotNull
    private Long id;

    @NotNull
    @NotBlank
    private String status;
}
