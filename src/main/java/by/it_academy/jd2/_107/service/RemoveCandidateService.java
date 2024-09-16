package by.it_academy.jd2._107.service;

import by.it_academy.jd2._107.exceptions.DuplicateEntityException;
import by.it_academy.jd2._107.service.api.ICandidateService;
import by.it_academy.jd2._107.storage.api.ICandidateStorage;
import by.it_academy.jd2._107.storage.db.factory.CandidateStorageDBBigSerialPrepareFactory;

import java.util.Map;

public class RemoveCandidateService implements ICandidateService {


    private final ICandidateStorage candidateStorageDB = CandidateStorageDBBigSerialPrepareFactory.getInstance();

    /*private final ICandidateStorage storage = CandidateStorageFactory.getInstance();*/


    public RemoveCandidateService() {
    }

    @Override
    public Long create(String name) throws DuplicateEntityException {
        return candidateStorageDB.create(name);
    }

    @Override
    public String get(Long id) {
        return candidateStorageDB.get(id);
    }

    @Override
    public Map<Long, String> get() {
        return candidateStorageDB.get();
    }

    @Override
    public void remove(String name) {
        if(name.equals(candidateStorageDB.get().containsValue(candidateStorageDB))) {
            throw new IllegalArgumentException("<fieldset><p><span style= 'color: red;'>Warning: Такого артиста не существует!</span></p></fieldset>");
        }
        candidateStorageDB.remove(name);
    }
}

