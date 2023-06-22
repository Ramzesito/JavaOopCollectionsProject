package ru.netology.oop;

import java.util.HashMap;

public class Game {

    private HashMap<String, Integer> registeredPlayers;

    public Game() {
        this.registeredPlayers = new HashMap<>();
    }

    public HashMap<String, Integer> getRegisteredPlayers() {
        return registeredPlayers;
    }

    public void register(Player player) {
        registeredPlayers.put(player.getName(), player.getStrength());
    }

    public int round(String playerName1, String playerName2) {
        Integer activePlayer1Strength = registeredPlayers.get(playerName1);
        Integer activePlayer2Strength = registeredPlayers.get(playerName2);
        if (activePlayer1Strength == null) {
            throw new NotRegisteredException("Player named " + playerName1 + " is not registered!");
        } else if (activePlayer2Strength == null) {
            throw new NotRegisteredException("Player named " + playerName2 + " is not registered!");
        } else {
            // start game
            if (activePlayer1Strength > activePlayer2Strength) {
                return 1;
            } else if (activePlayer2Strength > activePlayer1Strength) {
                return 2;
            } else return 0;
        }

    }
}
