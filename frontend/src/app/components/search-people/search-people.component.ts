import { Component } from '@angular/core';
import { PersonService } from '../../services/person.service';
import { Person} from '../../models/person.model';

@Component({
  selector: 'app-search-people',
  templateUrl: './search-people.component.html',
  styleUrl: './search-people.component.css'
})
export class SearchPeopleComponent {
  searchName: string = '';
  people: Person[] = [];
  
  constructor(private personService: PersonService) {}

  getPeople(): void {
    if (this.searchName.trim()) {
      this.personService.searchPeople(this.searchName.trim()).subscribe(
        data => {this.people = data;});
    }
  }
}
