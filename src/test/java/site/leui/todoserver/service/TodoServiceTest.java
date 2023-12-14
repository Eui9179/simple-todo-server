package site.leui.todoserver.service;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.context.annotation.Import;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import site.leui.todoserver.domain.Todo;
import site.leui.todoserver.dto.TodoForSave;
import site.leui.todoserver.repository.TodoMapper;

import java.time.LocalDateTime;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;

@ExtendWith(SpringExtension.class)
@Import({TodoService.class})
public class TodoServiceTest {

    @MockBean
    private TodoMapper todoRepository;

    @Autowired
    private TodoService todoService;

    @Test
    void getTodoTest() {
        //given
        Long id = 0L;
        Todo givenTodo = new Todo(
                id,
                "title1",
                "ready",
                LocalDateTime.now().plusDays(3),
                LocalDateTime.now(),
                null
        );

        //when
        Mockito.when(todoRepository.findOne(id))
                .thenReturn(givenTodo);

        Todo todo = todoService.get(id);

        //then
        assertEquals(todo.getId(), givenTodo.getId());
        assertEquals(todo.getTitle(), givenTodo.getTitle());
        assertEquals(todo.getStatus(), givenTodo.getStatus());
        assertEquals(todo.getCreatedTime(), givenTodo.getCreatedTime());

        Mockito.verify(todoRepository).findOne(id);
    }

    @Test
    void saveTodoTest() {
        //given
        Mockito.doNothing()
                .when(todoRepository)
                .insert(any(TodoForSave.class));

        // when
        TodoForSave savedTodo = new TodoForSave();
        savedTodo.setId(0L);
        Long id = todoService.save(savedTodo);

        //then
        assertEquals(savedTodo.getId(), id);

        Mockito.verify(todoRepository).insert(any());
    }
}
