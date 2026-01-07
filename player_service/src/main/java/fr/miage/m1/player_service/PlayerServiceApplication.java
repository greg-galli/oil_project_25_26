package fr.miage.m1.player_service;

import fr.miage.m1.player_service.entities.Player;
import fr.miage.m1.player_service.repositories.PlayerRepository;
import fr.miage.m1.player_service.services.PlayerService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.util.ArrayList;
import java.util.List;

@SpringBootApplication
public class PlayerServiceApplication {

    public static void main(String[] args) {
        SpringApplication.run(PlayerServiceApplication.class, args);
    }

    @Bean
    CommandLineRunner init(PlayerRepository playerRepository) {
        return args -> {
            List<Player> playerList = new ArrayList<>();
            playerList.add(Player.builder().pseudo("Alice").score(500).build());
            playerList.add(Player.builder().pseudo("Bob").score(750).build());
            playerList.add(Player.builder().pseudo("Charly").score(1000).build());
            playerRepository.saveAll(playerList);
        };
    }
}
