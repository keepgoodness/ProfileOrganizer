package org.keepgoodness.ProfileOrganizer.service;

import org.keepgoodness.ProfileOrganizer.model.dto.EmailDto;
import org.keepgoodness.ProfileOrganizer.model.dto.PersonDto;
import org.keepgoodness.ProfileOrganizer.model.entity.Email;
import org.keepgoodness.ProfileOrganizer.model.entity.Person;
import org.keepgoodness.ProfileOrganizer.repository.EmailRepository;
import org.keepgoodness.ProfileOrganizer.repository.PersonRepository;
import org.keepgoodness.ProfileOrganizer.еxception.ResourceNotFoundException;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

@Service
public class PersonService {
    private final PersonRepository personRepository;
    private final EmailRepository emailRepository;
    private final ModelMapper mapper;

    public PersonService(PersonRepository personRepository, EmailRepository emailRepository, ModelMapper mapper) {
        this.personRepository = personRepository;
        this.emailRepository = emailRepository;
        this.mapper = mapper;
    }

    public List<PersonDto> searchPeopleByName(String name) {
        List<Person> people = personRepository.findByFullNameIgnoreCaseContaining(name);
        return people.stream().map( p -> convertEntityToDto(p, PersonDto.class)).collect(Collectors.toList());
    }

    public void createPerson(PersonDto personDTO) {
        Person person = convertDtoToEntity(personDTO, Person.class);
        personRepository.save(person);
    }

    public void updatePerson(Long id, PersonDto personDTO) {
        Person person = personRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException(String.format("Лице с id:%s не е намерено", id)));
        person.setFullName(personDTO.getFullName());
        person.setPin(personDTO.getPin());
        updateEmails(person, personDTO.getMails());
        personRepository.save(person);
    }

    private void updateEmails(Person person, List<EmailDto> emailDtos) {
        Set<Long> existingMailsIds = person.getMails().stream()
                .map(Email::getId)
                .collect(Collectors.toSet());
        if (null != emailDtos) {
            for (EmailDto emailDto : emailDtos) {
                if (emailDto.getId() == null) {
                    // New Email, create and add to person
                    Email newEmail = new Email();
                    newEmail.setEmail(emailDto.getEmail());
                    newEmail.setEmailType(emailDto.getEmailType());
                    newEmail.setPerson(person);
                    person.getMails().add(newEmail);
                } else {
                    // Existing Email update
                    existingMailsIds.remove(emailDto.getId());
                    Email existingChild = person.getMails().stream()
                            .filter(c -> c.getId().equals(emailDto.getId()))
                            .findFirst()
                            .orElseThrow(() -> new RuntimeException("Email not found"));
                    existingChild.setEmail(emailDto.getEmail());
                    existingChild.setEmailType(emailDto.getEmailType());
                }
            }
        }
        person.getMails().removeIf(email -> existingMailsIds.contains(email.getId()));
    }

    public void deletePerson(Long id) {
        personRepository.deleteById(id);
    }

    public <D, E> E convertDtoToEntity(D dto, Class<E> entityClass) {
        return mapper.map(dto, entityClass);
    }

    public <D, E> E convertEntityToDto(D dto, Class<E> entityClass) {
        return mapper.map(dto, entityClass);
    }
}
