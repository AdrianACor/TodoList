package com.example.TodoList.Repository;

import com.example.TodoList.Models.Task;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface TaskRepository extends JpaRepository<Task , Long> {

}
