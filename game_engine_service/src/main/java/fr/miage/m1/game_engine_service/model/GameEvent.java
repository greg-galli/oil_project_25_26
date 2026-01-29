package fr.miage.m1.game_engine_service.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

@Data
@AllArgsConstructor @Builder
public class GameEvent {
    String type;
    Long playerId;
    String message;
    String timestamp;
}
