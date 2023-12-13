package site.leui.todoserver.repository;

import org.apache.ibatis.annotations.Mapper;
import site.leui.todoserver.domain.Todo;
import site.leui.todoserver.dto.TodoForEdit;
import site.leui.todoserver.dto.TodoForSave;
import site.leui.todoserver.dto.TodoStatusForUpdate;

import java.util.List;

@Mapper
public interface TodoMapper {
    List<Todo> findAll();

    void update(TodoForEdit todo);

    void delete(Long id);

    void insert(TodoForSave todo);

    void updateTodoStatus(TodoStatusForUpdate request);

    Todo findOne(Long id);
}
