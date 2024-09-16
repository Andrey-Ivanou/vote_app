package by.it_academy.jd2._107.service.api;

import by.it_academy.jd2._107.exceptions.DuplicateEntityException;

import java.util.Map;

public interface ICandidateService {

    Long create(String name) throws DuplicateEntityException;

    String get(Long id);

    Map<Long, String> get();

    void remove(String name);
}
