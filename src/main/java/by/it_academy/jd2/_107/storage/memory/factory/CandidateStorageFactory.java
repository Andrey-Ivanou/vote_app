package by.it_academy.jd2._107.storage.memory.factory;

import by.it_academy.jd2._107.storage.memory.CandidateStorage;

public class CandidateStorageFactory {

    private static final CandidateStorage instance = new CandidateStorage();

    public static CandidateStorage getInstance() {
        return instance;
    }
}
