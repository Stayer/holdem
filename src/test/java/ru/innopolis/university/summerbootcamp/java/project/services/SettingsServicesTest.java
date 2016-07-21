package ru.innopolis.university.summerbootcamp.java.project.services;

import org.junit.Test;
import ru.innopolis.university.summerbootcamp.java.project.model.Settings;
import ru.innopolis.university.summerbootcamp.java.project.services.impl.SettingsServices;

import java.util.List;

/**
 * Created by iskandar on 21/07/16.
 */
public class SettingsServicesTest {
    @Test
    public void writeTest() {
        SettingsServices settingsServices = SettingsServices.getInstance();

        Settings settings = new Settings();
        settings.setUserName("dalv");
        settings.setBat(100);
        settings.setCash(123);
        settings.setPassword("ddas");
        settingsServices.save(settings);

        Settings settings2 = new Settings();
        settings2.setUserName("Joe Pasquale");
        settings2.setBat(200);
        settings2.setCash(1500);
        settings2.setPassword("aasdasdasd");
        settingsServices.save(settings2);

        List<Settings> set = settingsServices.findAll();
    }


}
