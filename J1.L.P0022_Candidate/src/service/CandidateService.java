package service;

import java.util.List;
import exception.DuplicateCandidateException;
import model.Candidate;

public interface CandidateService {

    void addCandidate(Candidate candidate) throws DuplicateCandidateException;

    List<Candidate> searchByName(String name, int candidateType);

    void printCandidatesByType();

    boolean candidateExists(String id);
}
