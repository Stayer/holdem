package ru.innopolis.university.summerbootcamp.java.project.model;


public class Settings {

    private String personalName;
    private String password;
    private int cash;
    private int playerCount;
    private int difficulty;
    private int bat;

    public Settings() {
    }

    public Settings(String personalName, String password, int cash, int playerCount, int difficulty, int bat) {
        this.personalName = personalName;
        this.password = password;
        this.cash = cash;
        this.playerCount = playerCount;
        this.difficulty = difficulty;
        this.bat = bat;
    }

    public String getPersonalName() {
        return personalName;
    }

    public void setPersonalName(String personalName) {
        this.personalName = personalName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public int getCash() {
        return cash;
    }

    public void setCash(int cash) {
        this.cash = cash;
    }

    public int getDifficulty() {
        return difficulty;
    }

    public void setDifficulty(int difficulty) {
        this.difficulty = difficulty;
    }

    public int getBat() {
        return bat;
    }

    public void setBat(int bat) {
        this.bat = bat;
    }

    public int getPlayerCount() {
        return playerCount;
    }

    public void setPlayerCount(int playerCount) {
        this.playerCount = playerCount;
    }
}
