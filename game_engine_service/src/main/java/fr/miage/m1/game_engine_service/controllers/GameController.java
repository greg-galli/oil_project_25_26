package fr.miage.m1.game_engine_service.controllers;

import fr.miage.m1.game_engine_service.dtos.GameDTO;
import fr.miage.m1.game_engine_service.services.GameService;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
public class GameController {

    private final GameService gameService;

    public GameController(GameService gameService) {
        this.gameService = gameService;
    }

    @PostMapping("/start/{playerId}")
    @ResponseStatus(HttpStatus.CREATED)
    public GameDTO startNewGame(@PathVariable Long playerId, @RequestParam(defaultValue = "3") int nbQuestions) {
        return gameService.startNewGame(playerId, nbQuestions);
    }


    @PostMapping("/end/{playerId}/{score}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void endGame(@PathVariable Long playerId, @PathVariable int score) {
        gameService.endGame(playerId, score);
    }

}
