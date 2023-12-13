package site.leui.todoserver.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import site.leui.todoserver.domain.Todo;
import site.leui.todoserver.dto.TodoForSave;
import site.leui.todoserver.service.TodoService;

import java.time.LocalDateTime;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.BDDMockito.given;
import static org.mockito.BDDMockito.verify;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@WebMvcTest(TodoController.class)
public class TodoControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @Autowired
    private ObjectMapper objectMapper;

    @MockBean
    TodoService todoService;

    @Test
    @DisplayName("MockMvc를 통한 Todo 데이터 가져오기 테스트")
    void getTodoTest() throws Exception {
        //given
        Long id = 1L;
        Todo willReturnTodo = new Todo(
                id,
                "test",
                "ready",
                LocalDateTime.now().plusDays(3),
                LocalDateTime.now(),
                null
        );

        given(todoService.get(id)).willReturn(willReturnTodo);

        //when-then
        mockMvc.perform(get("/api/todo/" + id))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.id").exists())
                .andExpect(jsonPath("$.title").exists())
                .andExpect(jsonPath("$.dueDate").exists())
                .andExpect(jsonPath("$.createdTime").exists())
                .andExpect(jsonPath("$.modifiedTime").doesNotExist())
                .andDo(print());

        verify(todoService).get(id);
    }

    @Test
    @DisplayName("Todo 데이터 생성 테스트")
    void createTodoTest() throws Exception {
        //given
        Long id = 0L;

        TodoForSave savedTodo = new TodoForSave();
        savedTodo.setTitle("test");
        savedTodo.setStatus("ready");
        savedTodo.setDueDate(LocalDateTime.now().plusDays(3));
        savedTodo.setCreatedTime(LocalDateTime.now());

        given(todoService.save(savedTodo))
                .willReturn(id);

        String jsonString = objectMapper.writeValueAsString(savedTodo);

        //when-then
        mockMvc.perform(
                post("/api/todo")
                        .content(jsonString)
                        .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(content().string(id + ""))
                .andDo(print());

        verify(todoService).save(any(TodoForSave.class));
    }
}
