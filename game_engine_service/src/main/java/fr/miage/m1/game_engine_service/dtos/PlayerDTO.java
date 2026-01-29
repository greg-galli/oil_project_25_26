package fr.miage.m1.game_engine_service.dtos;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

@Data
@AllArgsConstructor
@Builder
public class PlayerDTO {
    private Long id;
    private int score = 0;
}
