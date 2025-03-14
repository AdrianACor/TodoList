import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import Task from '../Interfaces/Task';
import { Observable } from 'rxjs';

@Injectable({
  providedIn: 'root',
})
export class ServicesTasksService {
  constructor(private http: HttpClient) {}

  getTaskAll(): Observable<Task[]> {
    return this.http.get<Task[]>(`http://localhost:8080/Tasks`);
  }

  postTask(task: string): Observable<Task[]> {
    return this.http.post<Task[]>(`http://localhost:8080/Tasks`, {
      nombre: task,
    });
  }

  deleteTask(id: number): Observable<Task[]> {
    return this.http.delete<Task[]>(`http://localhost:8080/Tasks/${id}`);
  }

  putTask(task: Task, id: number): Observable<Task[]> {
    return this.http.put<Task[]>(`http://localhost:8080/Tasks/${id}`, task);
  }

  putTaskCompleted(completed: boolean, id: number): Observable<Task[]> {
    return this.http.put<Task[]>(
      `http://localhost:8080/Tasks/${id}/${completed}`,
      {}
    );
  }
}
