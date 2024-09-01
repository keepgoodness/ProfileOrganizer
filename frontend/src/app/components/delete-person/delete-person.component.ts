import { Component } from '@angular/core';
import { ActivatedRoute } from '@angular/router';
import { PersonService } from '../../services/person.service';

@Component({
  selector: 'app-delete-person',
  templateUrl: './delete-person.component.html',
  styleUrl: './delete-person.component.css'
})
export class DeletePersonComponent {
  id: number;

  constructor(
    private route: ActivatedRoute,
    private personService: PersonService
  ) {
    this.id = this.route.snapshot.params['id'];
  }

  deletePerson() {
    if (confirm('Are you sure you want to delete this person?')) {
      this.personService.deletePerson(this.id).subscribe(() => {
        alert('Person deleted successfully!');
      });
    }
  }
}