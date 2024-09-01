import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { SearchPeopleComponent } from './components/search-people/search-people.component';
import { CreatePersonComponent } from './components/create-person/create-person.component';
import { DeletePersonComponent } from './components/delete-person/delete-person.component';

const routes: Routes = [
  {path: 'search', component: SearchPeopleComponent },
  { path: 'create', component: CreatePersonComponent },
  { path: 'delete/:id', component: DeletePersonComponent},
  { path: '', redirectTo: '/search', pathMatch: 'full' },
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
