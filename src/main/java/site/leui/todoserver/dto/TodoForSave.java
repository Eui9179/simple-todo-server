package site.leui.todoserver.dto;

import lombok.*;

import java.time.LocalDateTime;

@Getter @Setter
@NoArgsConstructor
public class TodoForSave {
    private Long id;
    private String title;
    private String status;
    private LocalDateTime dueDate;
    private LocalDateTime createdTime;
}
