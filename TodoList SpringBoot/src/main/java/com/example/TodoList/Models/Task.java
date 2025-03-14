package com.example.TodoList.Models;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.*;

@Entity
@Table(name="task")
public class Task {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    public Task() {
    }

    private String nombre;

    private boolean completed;

    public long getId() {
        return id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public void setId(long id) {
        this.id = id;
    }

    public void setCompleted(Boolean completed){
        this.completed = completed;
    }

    public boolean getCompleted() {
        return completed;
    }

    public Task(long id, String nombre) {
        this.id = id;
        this.nombre = nombre;
    }
}
