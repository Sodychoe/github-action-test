package com.example.demo;

import java.util.Random;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/")
@RequiredArgsConstructor
public class MainController {
    private final DocumentRepository documentRepository;

    @GetMapping
    public String showRandomComment() {
        return showRandomCommentService();
    }

    private String showRandomCommentService() {
        Random random = new Random();
        long id = random.nextInt(10) + 1;
        var entity = documentRepository.findById(id)
                .orElseThrow(RuntimeException::new);

        return entity.getContent();
    }
}
