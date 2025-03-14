package com.example.TodoList.Services;

import com.example.TodoList.Models.Task;

import java.util.List;
import java.util.Optional;

public interface TaskServices {
    List<Task>GetTaskAll();

    Optional<Task> GetTaskById(Long id);

    List<Task> PostTask(Task task);

    List<Task> DeleteTask(Long id);

    List<Task> PutTask(Task task , Long id);

    Optional<Task> PutTaskCompleted(Boolean completed, Long id);

}
