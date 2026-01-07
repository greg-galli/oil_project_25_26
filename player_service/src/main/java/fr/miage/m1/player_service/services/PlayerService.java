package fr.miage.m1.player_service.services;

import fr.miage.m1.player_service.entities.Player;
import fr.miage.m1.player_service.repositories.PlayerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PlayerService {

    private final PlayerRepository playerRepository;

    @Autowired
    public PlayerService(PlayerRepository playerRepository) {
        this.playerRepository = playerRepository;
    }

    public List<Player> findAllPlayers()
    {
        return playerRepository.findAll();
    }

    public Optional<Player> findById(Long id)
    {
        return playerRepository.findById(id);
    }

    public Optional<Player> findByPseudo(String pseudo)
    {
        return playerRepository.findByPseudo(pseudo);
    }

    public Player createPlayer(Player player)
    {
        return playerRepository.save(player);
    }

    public void deletePlayerById(Long id)
    {
        playerRepository.deleteById(id);
    }

    public Player updatePlayer(Player player)
    {
        return playerRepository.save(player);
    }
}
