package ru.innopolis.university.summerbootcamp.java.project.services;

import org.junit.Assert;
import org.junit.Test;
import ru.innopolis.university.summerbootcamp.java.project.model.Settings;
import ru.innopolis.university.summerbootcamp.java.project.services.impl.SettingsServices;

import java.util.List;
import java.util.Objects;

/**
 * Created by iskandar on 21/07/16.
 */
public class SettingsServicesTest {
    @Test
    public void writeTest() {
        SettingsServices settingsServices = SettingsServices.getInstance();

        String[] names = {"Joe Pasquale", "John Doe", "Alec Baldwin"};

        for (String name: names) {
            Settings setting = new Settings();
            setting.setUserName(name);
            setting.setBat((int)(Math.random() * 100));
            setting.setCash((int)(Math.random() * 1000));
            setting.setPassword(name + "_password");
            settingsServices.save(setting);

        }

        for (String name: names) {
            Settings setting = settingsServices.findOne(name);

            Assert.assertTrue(
                    "Cannot read setting for user " + name,
                    Objects.equals(setting.getUserName(), name)
            );
        }

    }
}
