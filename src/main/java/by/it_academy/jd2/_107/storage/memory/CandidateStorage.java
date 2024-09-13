package by.it_academy.jd2._107.storage.memory;

import by.it_academy.jd2._107.storage.api.ICandidateStorage;

import java.util.HashMap;
import java.util.Map;

public class CandidateStorage implements ICandidateStorage {

    private Map<Long, String> artist = new HashMap<>();

    private CandidateStorage(Map<Long, String> data) {
        this.artist = artist;
    }

    public CandidateStorage() {
        artist.put(1L, "Сергей Жуков");
        artist.put(2L, "Юрий Антонов");
        artist.put(3L, "Игорь Кфрнилюк");
        artist.put(4L, "Олег Газманов");
    }

    @Override
    public Long create(String name) {
        long id = artist.size() + 1;
        artist.put(id, name);
        return id;
    }

    @Override
    public String get(Long id) {
        return this.artist.get(id);
    }

    @Override
    public Map<Long, String> get() {
        return this.artist;
    }
}
