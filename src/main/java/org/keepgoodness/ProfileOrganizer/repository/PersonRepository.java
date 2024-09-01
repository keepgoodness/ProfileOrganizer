package org.keepgoodness.ProfileOrganizer.repository;

import org.keepgoodness.ProfileOrganizer.model.entity.Person;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface PersonRepository extends JpaRepository<Person, Long> {
    List<Person> findByFullNameIgnoreCaseContaining(String name);
}