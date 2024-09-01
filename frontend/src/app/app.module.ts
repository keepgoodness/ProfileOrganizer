import { NgModule } from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';
import { FormsModule } from '@angular/forms'; 
import { HttpClientModule } from '@angular/common/http';

import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { SearchPeopleComponent } from './components/search-people/search-people.component';
import { CreatePersonComponent } from './components/create-person/create-person.component';
import { DeletePersonComponent } from './components/delete-person/delete-person.component';

@NgModule({
  declarations: [
    AppComponent,
    SearchPeopleComponent,
    CreatePersonComponent,
    DeletePersonComponent
  ],
  imports: [
    BrowserModule,
    FormsModule,
    HttpClientModule,
    AppRoutingModule
  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { }
