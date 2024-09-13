package by.it_academy.jd2._107.dto;

import java.time.LocalDateTime;
import java.util.Objects;

public class SaveVoteDTO {
    private LocalDateTime createAt;

    private VoteDTO voteDTO;

    public SaveVoteDTO(LocalDateTime createAt, VoteDTO voteDTO) {
        this.createAt = createAt;
        this.voteDTO = voteDTO;
    }

    public LocalDateTime getCreateAt() {
        return createAt;
    }

    public void setCreateAt(LocalDateTime createAt) {
        this.createAt = createAt;
    }

    public long getCandidate() {
        return voteDTO.getCandidate();
    }

    public String[] getGenres() {
        return voteDTO.getGenres();
    }

    public String getComment() {
        return voteDTO.getComment();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        SaveVoteDTO that = (SaveVoteDTO) o;
        return Objects.equals(createAt, that.createAt) && Objects.equals(voteDTO, that.voteDTO);
    }

    @Override
    public int hashCode() {
        return Objects.hash(createAt, voteDTO);
    }

    @Override
    public String toString() {
        return "SaveVoteDTO{" +
                "createAt=" + createAt +
                ", voteDTO=" + voteDTO +
                '}';
    }
}
