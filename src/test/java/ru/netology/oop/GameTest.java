package ru.netology.oop;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.HashMap;

public class GameTest {

    Player player1 = new Player(1, 15, "Sub-Zero");
    Player player2 = new Player(2, 30, "Liu Kang");
    Player player3 = new Player(3, 50, "Raiden");
    Player player4 = new Player(4, 20, "Goro");
    Player player5 = new Player(5, 25, "Johny Cage");
    Player player6 = new Player(6, 15, "Scorpion");
    Player player7 = new Player(7, 25, "Sonya Blade");

    @Test
    public void testRegistrationOne() {
        Game testGame = new Game();
        testGame.register(player3);

        ArrayList<Player> expected = new ArrayList<>();
        expected.add(player3);
        ArrayList<Player> actual = testGame.getRegisteredPlayers();

        Assertions.assertArrayEquals(expected.toArray(), actual.toArray());
    }

    @Test
    public void testRegistrationMany() {
        Game testGame = new Game();
        testGame.register(player3);
        testGame.register(player5);
        testGame.register(player7);

        ArrayList<Player> expected = new ArrayList<>();
        expected.add(player3);
        expected.add(player5);
        expected.add(player7);
        ArrayList<Player> actual = testGame.getRegisteredPlayers();

        Assertions.assertArrayEquals(expected.toArray(), actual.toArray());
    }

    @Test
    public void testRegistrationNone() {
        Game testGame = new Game();
        ArrayList<Player> expected = new ArrayList<>();
        ArrayList<Player> actual = testGame.getRegisteredPlayers();

        Assertions.assertArrayEquals(expected.toArray(), actual.toArray());
    }

    @Test
    public void shouldFindByName() {
        Game testGame = new Game();
        testGame.register(player4);
        Player expected = player4;
        Player actual = testGame.findByName("Goro");

        Assertions.assertEquals(expected, actual);
    }

    @Test
    public void shouldNotFindByName() {
        Game testGame = new Game();
        testGame.register(player4);
        Player expected = null;
        Player actual = testGame.findByName("Unknown");

        Assertions.assertEquals(expected, actual);
    }

    @Test
    public void shouldWinFirstPlayer() {
        Game testGame = new Game();
        testGame.register(player1);
        testGame.register(player2);
        int expected = 1;
        int actual = testGame.round("Liu Kang", "Sub-Zero");

        Assertions.assertEquals(expected, actual);
    }

    @Test
    public void shouldWinSecondPlayer() {
        Game testGame = new Game();
        testGame.register(player4);
        testGame.register(player5);
        int expected = 2;
        int actual = testGame.round("Goro", "Johny Cage");

        Assertions.assertEquals(expected, actual);
    }

    @Test
    public void shouldWinNobody() {
        Game testGame = new Game();
        testGame.register(player7);
        testGame.register(player5);
        int expected = 0;
        int actual = testGame.round("Sonya Blade", "Johny Cage");

        Assertions.assertEquals(expected, actual);
    }

    @Test
    public void shouldThrowNotRegisteredExceptionForFirstPlayer() {
        Game testGame = new Game();
        testGame.register(player1);
        testGame.register(player2);
        testGame.register(player7);
        testGame.register(player5);

        Assertions.assertThrows(NotRegisteredException.class, () -> {
            testGame.round("Raiden", "Johny Cage");
        });
    }

    @Test
    public void shouldThrowNotRegisteredExceptionForSecondPlayer() {
        Game testGame = new Game();
        testGame.register(player1);
        testGame.register(player2);
        testGame.register(player7);
        testGame.register(player5);
        testGame.register(player6);

        Assertions.assertThrows(NotRegisteredException.class, () -> {
            testGame.round("Johny Cage", "Raiden");
        });
    }
}
