package ru.innopolis.university.summerbootcamp.java.project;

import ru.innopolis.university.summerbootcamp.java.project.config.CoreConfig;
import ru.innopolis.university.summerbootcamp.java.project.model.Settings;

/**
 * Runnable
 */
public class Application {
    public static void main(String[] args) {
        Settings settings = new Settings("NIKMC","qwerty",100,4,1,10);
        CoreConfig coreConfig = new CoreConfig();
        coreConfig.saveSettings(settings);
        Settings settings2 = coreConfig.getSettings();
        System.out.println("write");
        System.out.println(settings2.getBat());
        System.out.println(settings2.getCash());
        System.out.println(settings2.getDifficulty());
        System.out.println(settings2.getPassword());
        System.out.println(settings2.getUserName());
        System.out.println(settings2.getPlayerCount());


    }
}
