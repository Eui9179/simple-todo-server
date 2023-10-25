package site.leui.todoserver.domain;

import lombok.*;

import java.time.LocalDateTime;

@Getter @Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Todo {
    private Long id;
    private String title;
    private String status;
    private LocalDateTime dueDate;
    private LocalDateTime createdTime;
    private LocalDateTime modifiedTime;
}
