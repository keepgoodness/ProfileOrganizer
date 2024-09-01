import { Component } from '@angular/core';
import { PersonService } from '../../services/person.service';

@Component({
  selector: 'app-create-person',
  templateUrl: './create-person.component.html',
  styleUrl: './create-person.component.css'
})
export class CreatePersonComponent {
  fullName = '';
  pin = '';

  constructor(private personService: PersonService) {}

  savePerson() {
    const person = { fullName: this.fullName, pin: this.pin };
    this.personService.createPerson(person).subscribe(() => {
      alert('Person created successfully!');
    });
  }
}
