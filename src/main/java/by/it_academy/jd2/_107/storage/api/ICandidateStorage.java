package by.it_academy.jd2._107.storage.api;

import java.util.Map;

public interface ICandidateStorage {

    Long create(String name);

    String get(Long id);

    Map<Long, String> get();
}
