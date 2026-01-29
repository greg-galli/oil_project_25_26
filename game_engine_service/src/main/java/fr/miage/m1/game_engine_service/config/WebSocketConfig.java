package fr.miage.m1.game_engine_service.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.messaging.simp.config.MessageBrokerRegistry;
import org.springframework.web.socket.config.annotation.EnableWebSocketMessageBroker;
import org.springframework.web.socket.config.annotation.StompEndpointRegistry;
import org.springframework.web.socket.config.annotation.WebSocketMessageBrokerConfigurer;

@Configuration
@EnableWebSocketMessageBroker
public class WebSocketConfig implements WebSocketMessageBrokerConfigurer {

    @Override
    public void configureMessageBroker(MessageBrokerRegistry registry) {
        // Préfixe pour les messages envoyés du serveur vers le client
        registry.enableSimpleBroker("/topic");
        // Préfixe pour les messages envoyés du client vers le serveur (pas utilisé ici, car implémentation unidirectionnelle)
        registry.setApplicationDestinationPrefixes("/app");
    }

    @Override
    public void registerStompEndpoints(StompEndpointRegistry registry) {
        // Point d'entrée pour la connexion WebSocket
        // setAllowedOriginPatterns("*") est nécessaire si le front n'est pas sur le même port
        registry.addEndpoint("/ws-game").setAllowedOriginPatterns("*").withSockJS();
    }

}
