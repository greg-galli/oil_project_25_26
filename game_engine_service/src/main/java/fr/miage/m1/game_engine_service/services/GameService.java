package fr.miage.m1.game_engine_service.services;

import fr.miage.m1.game_engine_service.model.GameEvent;
import fr.miage.m1.game_engine_service.dtos.GameDTO;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.messaging.simp.SimpMessagingTemplate;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

@Service
@RequiredArgsConstructor
@Slf4j
public class GameService {

    private final SimpMessagingTemplate messagingTemplate;

    public GameDTO startNewGame(Long playerId, int nbQuestions) {

        GameEvent event = new GameEvent(
                "GAME_START",
                playerId,
                "Le joueur " + playerId + " commence une partie !",
                LocalDateTime.now().toString()
        );

        try
        {
            this.messagingTemplate.convertAndSend("/topic/events", event);
        }
        catch (Exception e)  {
            log.error("Error while sending game start event for player {}", playerId, e);
        }

        return new GameDTO();
    }

    public void endGame(Long playerId, int score) {

        GameEvent event = new GameEvent(
                "GAME_END",
                playerId,
                "Le joueur " + playerId + " a terminé avec un score de " + score,
                LocalDateTime.now().toString()
        );

        try {
            this.messagingTemplate.convertAndSend("/topic/events", event);
        } catch (Exception e) {
            log.error("Error while sending game end event for player {}", playerId, e);
        }
    }

}
