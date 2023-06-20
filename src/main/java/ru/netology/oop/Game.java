package ru.netology.oop;

import java.util.ArrayList;
import java.util.HashMap;

public class Game {

    private ArrayList<Player> registeredPlayers;
    private HashMap<String, Integer> registeredPlayersMap = new HashMap<>();

    public Game() {
        this.registeredPlayers = new ArrayList<>();
    }

    public ArrayList<Player> getRegisteredPlayers() {
        return registeredPlayers;
    }

    public HashMap<String, Integer> getRegisteredPlayersMap() {
        return registeredPlayersMap;
    }

    public void register(Player player) {
        registeredPlayers.add(player);
        registeredPlayersMap.put(player.getName(), player.getStrength());
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
        Integer activePlayer1Strength = registeredPlayersMap.get(playerName1);
        Integer activePlayer2Strength = registeredPlayersMap.get(playerName2);
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
