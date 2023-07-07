package com.david.springbootgpt;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import reactor.core.publisher.Mono;

@RestController
public class StudyNotesController {

    @Autowired
    private StudyNotesService studyNotesService;

    @PostMapping("study-notes")
    public Mono<String> createStudyNotes(@RequestBody String topic) {
        return studyNotesService.createStudyNotes(topic).map(
                response -> response.choices().get(0).text());
    }
}
