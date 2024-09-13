package by.it_academy.jd2._107.storage.memory;

import by.it_academy.jd2._107.dto.SaveVoteDTO;
import by.it_academy.jd2._107.storage.api.IVoteStorage;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class VoteStorage implements IVoteStorage {

    private Long voteId = null;

    private Map<Long, Integer> candidate = new HashMap<>();

    private Map<String, Integer> genres = new HashMap<>();

    private List<String> comment = new ArrayList<>();


    public VoteStorage() {
    }

    @Override
    public Long create(SaveVoteDTO voteDTO) {

        candidate.compute(voteDTO.getCandidate(), (k, v) -> {
            if (v == null) {
                return 1;
            }
            return v + 1;
        });

        for (String genre : voteDTO.getGenres()) {
            genres.compute(genre, (k, v) -> {
                if (v == null) {
                    return 1;
                }
                return v + 1;
            });
        }
        comment.add(voteDTO.getComment());
        return voteId;
    }


    public Map<Long, Integer> getCandidate() {
        return candidate;
    }

    public Map<String, Integer> getGenres() {
        return genres;
    }

    public List<String> getComment() {
        return comment;
    }
}
