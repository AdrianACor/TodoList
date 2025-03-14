package com.example.TodoList.Controllers;

import com.example.TodoList.Models.Task;
import com.example.TodoList.Services.TaskServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@Controller
@RequestMapping("/Tasks")
public class TaskController {

    @Autowired
    public TaskServices taskServices;

    @GetMapping
    public ResponseEntity<List<Task>> GetTaskAll(){
        return ResponseEntity.ok(taskServices.GetTaskAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Optional<Task>> GetTaskById(@PathVariable Long id){
        return ResponseEntity.ok(taskServices.GetTaskById(id));
    }

    @PostMapping
    public ResponseEntity<List<Task>> PostTask(@RequestBody Task task){
        return ResponseEntity.ok(taskServices.PostTask(task));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<List<Task>> DeleteTask(@PathVariable Long id){
        return ResponseEntity.ok(taskServices.DeleteTask(id));
    }

    @PutMapping("/{id}")
    public ResponseEntity<List<Task>> PutTask(@RequestBody Task task, @PathVariable Long id){
        return ResponseEntity.ok(taskServices.PutTask(task,id));
    }

    @PutMapping("/{id}/{completed}")
    public ResponseEntity<Optional<Task>> PutTaskCompleted(@PathVariable Boolean completed, @PathVariable Long id){
        return ResponseEntity.ok(taskServices.PutTaskCompleted(completed,id));
    }
}
