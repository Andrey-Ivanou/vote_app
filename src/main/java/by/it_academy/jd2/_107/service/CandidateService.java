package by.it_academy.jd2._107.service;

import by.it_academy.jd2._107.service.api.ICandidateService;
import by.it_academy.jd2._107.storage.db.CandidateStorageDBBigSerialPrepare;
import by.it_academy.jd2._107.storage.db.factory.CandidateStorageDBBigSerialPrepareFactory;
import by.it_academy.jd2._107.storage.memory.CandidateStorage;
import by.it_academy.jd2._107.storage.api.ICandidateStorage;
import by.it_academy.jd2._107.storage.memory.factory.CandidateStorageFactory;

import java.util.Map;

public class CandidateService implements ICandidateService {


    private final ICandidateStorage candidateStorageDB = CandidateStorageDBBigSerialPrepareFactory.getInstance();

    /*private final ICandidateStorage storage = CandidateStorageFactory.getInstance();*/


    public CandidateService() {
    }

    @Override
    public Long create(String name) {
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



}
