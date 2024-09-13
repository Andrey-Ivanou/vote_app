package by.it_academy.jd2._107.service;

import by.it_academy.jd2._107.service.api.ICandidateService;
import by.it_academy.jd2._107.storage.api.ICandidateStorage;
import by.it_academy.jd2._107.storage.db.factory.CandidateStorageDBBigSerialPrepareFactory;
import by.it_academy.jd2._107.storage.db.factory.GenreStorageDBBigSerialPrepareFactory;

import java.util.Map;

public class GenreService implements ICandidateService {


    private final ICandidateStorage genreStorageDB = GenreStorageDBBigSerialPrepareFactory.getInstance();

    /*private final ICandidateStorage storage = CandidateStorageFactory.getInstance();*/


    public GenreService() {
    }

    @Override
    public Long create(String name) {
        return genreStorageDB.create(name);
    }

    @Override
    public String get(Long id) {
        return genreStorageDB.get(id);
    }

    @Override
    public Map<Long, String> get() {
        return genreStorageDB.get();
    }



}
