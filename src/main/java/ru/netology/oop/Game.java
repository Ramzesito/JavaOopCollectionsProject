package ru.netology.oop;

import java.util.ArrayList;

public class Game {

    private ArrayList<Player> registeredPlayers;

    public Game() {
        this.registeredPlayers = new ArrayList<>();
    }

    public ArrayList<Player> getRegisteredPlayers() {
        return registeredPlayers;
    }

    public void register(Player player) {
        registeredPlayers.add(player);
    }

    public Player findByName(String name) {
        for (Player player : registeredPlayers) {
            if (player.getName().equals(name)) {
                return player;
            }
        }
        return null;
    }

    public int round(String playerName1, String playerName2) {
        Player activePlayer1 = findByName(playerName1);
        Player activePlayer2 = findByName(playerName2);
        if (activePlayer1 == null) {
            throw new NotRegisteredException("Player named " + playerName1 + " is not registered!");
        } else if (activePlayer2 == null) {
            throw new NotRegisteredException("Player named " + playerName2 + " is not registered!");
        } else {
            // start game
            if (activePlayer1.getStrength() > activePlayer2.getStrength()) {
                return 1;
            } else if (activePlayer2.getStrength() > activePlayer1.getStrength()) {
                return 2;
            } else return 0;
        }

    }
}
