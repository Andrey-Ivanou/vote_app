package by.it_academy.jd2._107.service;

import by.it_academy.jd2._107.exceptions.DuplicateEntityException;
import by.it_academy.jd2._107.service.api.ICandidateService;
import by.it_academy.jd2._107.storage.api.ICandidateStorage;
import by.it_academy.jd2._107.storage.db.factory.CandidateStorageDBBigSerialPrepareFactory;
import by.it_academy.jd2._107.storage.db.factory.GenreStorageDBBigSerialPrepareFactory;

import java.util.Map;

public class RemoveGenreService implements ICandidateService {


    private final ICandidateStorage genreStorageDB = GenreStorageDBBigSerialPrepareFactory.getInstance();

    /*private final ICandidateStorage storage = CandidateStorageFactory.getInstance();*/


    public RemoveGenreService() {
    }

    @Override
    public Long create(String name) throws DuplicateEntityException {
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

    @Override
    public void remove(String name) {
        if(name.equals(genreStorageDB.get().containsValue(genreStorageDB))) {
            throw new IllegalArgumentException("<fieldset><p><span style= 'color: red;'>Warning: Такого жанра не существует!</span></p></fieldset>");
        }
        genreStorageDB.remove(name);
    }
}

