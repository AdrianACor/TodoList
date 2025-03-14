import { Component } from '@angular/core';
import { CommonModule } from '@angular/common';
import { RouterOutlet } from '@angular/router';
import { ServicesTasksService } from './Services/services-tasks.service';
import { HttpClientModule } from '@angular/common/http';
import { FormsModule } from '@angular/forms';
import Task from './Interfaces/Task';

@Component({
  selector: 'app-root',
  standalone: true,
  imports: [RouterOutlet, CommonModule, HttpClientModule, FormsModule],
  templateUrl: './app.component.html',
  styleUrl: './app.component.css',
})
export class AppComponent {
  title = 'TodoListAngular';
  constructor(private TaskService: ServicesTasksService) {}

  TaskList: Task[] = [];

  Task: string = '';
  taskEditing: boolean = true;
  taskCompleted: boolean = false;

  ngOnInit(): void {
    this.fetchData();
  }

  fetchData() {
    this.TaskService.getTaskAll().subscribe((data) => (this.TaskList = data));
  }

  postTask() {
    if (this.Task != '') {
      this.TaskService.postTask(this.Task).subscribe(
        (data) => (this.TaskList = data)
      );
      this.Task = '';
    }
  }

  deleteTask(id: number) {
    this.TaskService.deleteTask(id).subscribe((data) => (this.TaskList = data));
  }

  putTask(task: Task, id: number) {
    // console.log(task);
    this.TaskService.putTask(task, id).subscribe(
      (data) => (this.TaskList = data)
    );
    this.toggleEditTask();
  }

  toggleEditTask() {
    this.taskEditing = !this.taskEditing;
  }

  updateCompleted(event: Event, id: number) {
    let isChecked = event.target as HTMLInputElement;
    let isCompleted = isChecked.checked;

    this.TaskService.putTaskCompleted(isCompleted, id).subscribe();
    // console.log('completed: ', isCompleted);
  }
}
