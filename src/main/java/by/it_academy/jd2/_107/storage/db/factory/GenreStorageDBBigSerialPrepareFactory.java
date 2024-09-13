package by.it_academy.jd2._107.storage.db.factory;

import by.it_academy.jd2._107.service.api.ICandidateService;
import by.it_academy.jd2._107.storage.api.ICandidateStorage;
import by.it_academy.jd2._107.storage.db.GenreStorageDBBigSerialPrepare;

public class GenreStorageDBBigSerialPrepareFactory {

    private static ICandidateStorage instance;

    static {
         instance = new GenreStorageDBBigSerialPrepare();
    }

    public static ICandidateStorage getInstance() {
        return instance;
    }
}
