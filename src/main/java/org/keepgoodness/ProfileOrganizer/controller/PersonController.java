package org.keepgoodness.ProfileOrganizer.controller;

import jakarta.validation.Valid;
import org.keepgoodness.ProfileOrganizer.model.dto.PersonDto;
import org.keepgoodness.ProfileOrganizer.service.PersonService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/people")
public class PersonController {
    private final PersonService personService;

    public PersonController(PersonService personService) {
        this.personService = personService;
    }

    @GetMapping("/search")
    public List<PersonDto> searchPeople(@RequestParam("name") String name) {
        return personService.searchPeopleByName(name);
    }

    @PostMapping
    public ResponseEntity<String> createPerson(@RequestBody @Valid PersonDto personDTO) {
        personService.createPerson(personDTO);
        return ResponseEntity.ok("Записът е създаден успешно!");
    }

    @PutMapping("/{id}")
    public ResponseEntity<String> updatePerson(@PathVariable Long id,
                                               @RequestBody @Valid PersonDto personDTO) {
        personService.updatePerson(id, personDTO);
        return ResponseEntity.ok("Лицето е актуализирано успешно!");
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> deletePerson(@PathVariable Long id) {
        personService.deletePerson(id);
        return ResponseEntity.ok("Лицето е изтрито успешно!");
    }
}
