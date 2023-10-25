package site.leui.todoserver.dto;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter @Setter
@NoArgsConstructor
public class TodoStatusForUpdate {
    private Long id;
    private String status;
}
