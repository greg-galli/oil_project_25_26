package fr.miage.m1.player_service.repositories;

import fr.miage.m1.player_service.entities.Player;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface PlayerRepository extends JpaRepository<Player, Long> {
    Optional<Player> findByPseudo(String pseudo);
}
