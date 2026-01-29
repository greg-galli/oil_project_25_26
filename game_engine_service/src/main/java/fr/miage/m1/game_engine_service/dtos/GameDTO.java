package fr.miage.m1.game_engine_service.dtos;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class GameDTO {
    PlayerDTO player;
    List<QuestionDTO> questions;
}
