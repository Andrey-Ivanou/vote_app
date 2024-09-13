package by.it_academy.jd2._107.service.api;

import java.util.Map;

public interface ICandidateService {

    Long create(String name);

    String get(Long id);

    Map<Long, String> get();
}
