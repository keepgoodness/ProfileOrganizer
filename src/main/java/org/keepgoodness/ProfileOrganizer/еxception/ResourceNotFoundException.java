package org.keepgoodness.ProfileOrganizer.еxception;

public class ResourceNotFoundException extends RuntimeException {
    public ResourceNotFoundException(String personNotFound) {
        super(personNotFound);
    }
}
