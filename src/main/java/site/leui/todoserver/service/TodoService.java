package site.leui.todoserver.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import site.leui.todoserver.dto.TodoForEdit;
import site.leui.todoserver.domain.Todo;
import site.leui.todoserver.dto.TodoForSave;
import site.leui.todoserver.dto.TodoStatusForUpdate;
import site.leui.todoserver.repository.TodoMapper;

import java.util.List;

@RequiredArgsConstructor
@Service
public class TodoService {

    private final TodoMapper todoMapper;

    public List<Todo> getAll() {
        return todoMapper.findAll();
    }

    public Todo get(Long id) {
        return todoMapper.findOne(id);
    }

    public Long save(TodoForSave todo) {
        todoMapper.insert(todo);
        return todo.getId();
    }

    public void edit(TodoForEdit todo) {
        todoMapper.update(todo);
    }

    public void delete(Long id) {
        todoMapper.delete(id);
    }

    public void updateTodoStatus(TodoStatusForUpdate request) {
        todoMapper.updateTodoStatus(request);
    }
}
