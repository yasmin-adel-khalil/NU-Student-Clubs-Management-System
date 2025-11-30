package com.NUClubs.login.signup.Services;

import com.NUClubs.login.signup.Models.Highlight;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class MemberService {
    private final List<Highlight> highlights = new ArrayList<>();

    public MemberService() {
        highlights.add(new Highlight(1L, "Ali C.", "Electrical Engineer", "Top contributor", ""));
        highlights.add(new Highlight(2L, "Sara S.", "Computer Science", "Active organizer", ""));
        highlights.add(new Highlight(3L, "Lina M.", "Marketing major", "Marketing lead", ""));
    }

    public List<Highlight> getHighlights() {
        return new ArrayList<>(highlights);
    }
}
