package site.leui.todoserver.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import site.leui.todoserver.dto.TodoForEdit;
import site.leui.todoserver.domain.Todo;
import site.leui.todoserver.dto.TodoForSave;
import site.leui.todoserver.dto.TodoStatusForUpdate;
import site.leui.todoserver.service.TodoService;

import java.util.List;

@RequiredArgsConstructor
@RestController
@RequestMapping("/api")
public class TodoController {

    final TodoService todoService;

    @GetMapping("/todos")
    public List<Todo> getAll() {
        return todoService.getAll();
    }

    @PostMapping("/todo")
    public Long createTodo(@RequestBody TodoForSave saveTodo) {
        return todoService.save(saveTodo);
    }

    @PutMapping("/todo")
    public void editTodo(@RequestBody TodoForEdit editTodo) {
        todoService.edit(editTodo);
    }

    @PutMapping("/todo-status")
    public void updateTodoStatus(@RequestBody TodoStatusForUpdate request) {
        todoService.updateTodoStatus(request);
    }

    @DeleteMapping("/todo/{id}")
    public void deleteTodo(@PathVariable Long id) {
        todoService.delete(id);
    }
}
