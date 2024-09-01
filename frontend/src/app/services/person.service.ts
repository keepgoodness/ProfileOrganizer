import { Injectable } from '@angular/core';
import { HttpClient, HttpErrorResponse } from '@angular/common/http';
import { Observable, throwError } from 'rxjs';
import { Person} from '../models/person.model';

@Injectable({
  providedIn: 'root',
})

export class PersonService {
  private baseUrl = 'http://localhost:8088/people';
  constructor(private http: HttpClient) {}

  searchPeople(name: string): Observable<Person[]> {    
    return this.http.get<Person[]>(`${this.baseUrl}/search`, {params: { name }});
  }

  createPerson(person: Person): Observable<any> {
    return this.http.post(`${this.baseUrl}`, person);
  }

  deletePerson(id: number): Observable<any> {
    return this.http.delete(`${this.baseUrl}/${id}`);
  }
}
