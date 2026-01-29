package fr.miage.m1.game_engine_service.dtos;

import java.util.List;

public class QuestionDTO {
    private Long id;
    private String text;
    private String response;
    private List<String> propositions;
    private String category;
}
