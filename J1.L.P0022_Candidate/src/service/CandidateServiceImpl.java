package service;

import java.util.ArrayList;
import java.util.List;
import constants.Messages;
import exception.DuplicateCandidateException;
import model.Candidate;
import model.Experience;
import model.Fresher;
import model.Internship;

public class CandidateServiceImpl implements CandidateService {

    private ArrayList<Candidate> candidates;

    public CandidateServiceImpl() {
        this.candidates = new ArrayList<>();
    }

    @Override
    public void addCandidate(Candidate candidate) throws DuplicateCandidateException {
        if (candidateExists(candidate.getId())) {
            throw new DuplicateCandidateException(candidate.getId());
        }
        candidates.add(candidate);
    }

    @Override
    public List<Candidate> searchByName(String name, int candidateType) {
        List<Candidate> result = new ArrayList<>();
        for (Candidate candidate : candidates) {
            if (candidate.getCandidateType() == candidateType) {
                if (candidate.getFirstName().toLowerCase().contains(name.toLowerCase()) ||
                        candidate.getLastName().toLowerCase().contains(name.toLowerCase())) {
                    result.add(candidate);
                }
            }
        }
        return result;
    }

    @Override
    public void printCandidatesByType() {
        System.out.println("\n" + Messages.TITLE_EXPERIENCE_LIST);
        for (Candidate candidate : candidates) {
            if (candidate instanceof Experience) {
                System.out.println("  " + candidate.getFullName());
            }
        }

        System.out.println("\n" + Messages.TITLE_FRESHER_LIST);
        for (Candidate candidate : candidates) {
            if (candidate instanceof Fresher) {
                System.out.println("  " + candidate.getFullName());
            }
        }

        System.out.println("\n" + Messages.TITLE_INTERNSHIP_LIST);
        for (Candidate candidate : candidates) {
            if (candidate instanceof Internship) {
                System.out.println("  " + candidate.getFullName());
            }
        }
    }

    @Override
    public boolean candidateExists(String id) {
        for (Candidate candidate : candidates) {
            if (candidate.getId().equalsIgnoreCase(id)) {
                return true;
            }
        }
        return false;
    }
}
