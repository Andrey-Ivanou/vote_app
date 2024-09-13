package by.it_academy.jd2._107.storage.db.factory;

import by.it_academy.jd2._107.service.VoteService;
import by.it_academy.jd2._107.storage.api.ICandidateStorage;
import by.it_academy.jd2._107.storage.db.CandidateStorageDBBigSerialPrepare;

public class CandidateStorageDBBigSerialPrepareFactory {

    private static ICandidateStorage instance;

    static {
         instance = new CandidateStorageDBBigSerialPrepare();
    }

    public static ICandidateStorage getInstance() {
        return instance;
    }
}
