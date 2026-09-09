package com.brainycode.mustache_demo2.controllers;

import com.brainycode.mustache_demo2.model.Candidate;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;


@Controller
public class CandidateController {
    @GetMapping("/candidates")
    public String getCandidates(final Model model) {
        List<Candidate> candidateList = IntStream.range(0,7)
                .mapToObj(this::getCandidate)
                .collect(Collectors.toList());
        model.addAttribute("title", "Mustache Demo 2");
        model.addAttribute("candidateList", candidateList);
        return "candidate";
    }

    private Candidate getCandidate(int i) {
        return new Candidate("Candidate Name " + i,
                20 + i,
                "Phone Number" + i,
                "EmailId" + i + "@example.com");
    }
}
