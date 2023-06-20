package ru.netology.oop;

public class Player {

    private int id, strength;
    private String name;

    public Player(int id, int strength, String name) {
        this.id = id;
        this.strength = strength;
        this.name = name;
    }

    public int getStrength() {
        return strength;
    }

    public String getName() {
        return name;
    }
}
