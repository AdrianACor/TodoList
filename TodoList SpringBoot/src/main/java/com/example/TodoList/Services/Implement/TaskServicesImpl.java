package com.example.TodoList.Services.Implement;

import com.example.TodoList.Models.Task;
import com.example.TodoList.Repository.TaskRepository;
import com.example.TodoList.Services.TaskServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class TaskServicesImpl implements TaskServices {

    @Autowired
    public TaskRepository taskRepository;

    @Override
    public List<Task> GetTaskAll() {
        return taskRepository.findAll();
    }

    @Override
    public Optional<Task> GetTaskById(Long id) {
        return taskRepository.findById(id);
    }

    @Override
    public List<Task> PostTask(Task task) {
        taskRepository.save(task);
        return taskRepository.findAll();
    }

    @Override
    public List<Task> DeleteTask(Long id) {
        taskRepository.deleteById(id);
        return taskRepository.findAll();
    }

    @Override
    public Optional<Task> PutTaskCompleted(Boolean completed, Long id) {
        Task taskPut = taskRepository.findById(id).get();

        if(Long.valueOf(taskPut.getId()) != null){
            taskPut.setCompleted(completed);
            taskRepository.save(taskPut);
        }

        return taskRepository.findById(id);
    }

    @Override
    public List<Task> PutTask(Task task, Long id) {
        Task taskPut = taskRepository.findById(id).get();

        if(Long.valueOf(taskPut.getId()) != null){
            taskPut.setNombre(task.getNombre());
            taskPut.setCompleted(task.getCompleted());
            taskRepository.save(taskPut);
        }

        return taskRepository.findAll();
    }
}
