package ru.innopolis.university.summerbootcamp.java.project.model;


public class Settings {

    private String userName;
    private String password;
    private int cash;
    private int playerCount;
    private int difficulty;
    private int bet;
    private boolean music;

    public Settings() {
    }

    public Settings(String personalName, String password, int cash, int playerCount, int difficulty, int bet) {
        this.userName = personalName;
        this.password = password;
        this.cash = cash;
        this.playerCount = playerCount;
        this.difficulty = difficulty;
        this.bet = bet;
    }
    public Settings(Settings settings) {
        this.userName = settings.getUserName();
        this.password = settings.getPassword();
        this.cash = settings.getCash();
        this.playerCount = settings.getPlayerCount();
        this.difficulty = settings.getDifficulty();
        this.bet = settings.getBet();
    }

    public Settings(String userName, int cash, int playerCount, int difficulty, int bet, boolean music) {
        this.userName = userName;
        this.cash = cash;
        this.playerCount = playerCount;
        this.difficulty = difficulty;
        this.bet = bet;
        this.music = music;
    }

    public Settings(int playerCount, int difficulty, int bet, boolean music) {
        this.playerCount = playerCount;
        this.difficulty = difficulty;
        this.bet = bet;
        this.music = music;
    }

    public boolean isMusic() {
        return music;
    }

    public void setMusic(boolean music) {
        this.music = music;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
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

    /**
     *
     * @param difficulty 1- normal; 2 - hardcore
     */
    public void setDifficulty(int difficulty) {
        this.difficulty = difficulty;
    }

    public int getBet() {
        return bet;
    }

    public void setBet(int bet) {
        this.bet = bet;
    }

    public int getPlayerCount() {
        return playerCount;
    }

    public void setPlayerCount(int playerCount) {
        this.playerCount = playerCount;
    }
}
