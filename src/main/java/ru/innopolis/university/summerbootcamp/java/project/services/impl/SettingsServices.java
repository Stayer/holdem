package ru.innopolis.university.summerbootcamp.java.project.services.impl;

import ru.innopolis.university.summerbootcamp.java.project.model.Settings;
import ru.innopolis.university.summerbootcamp.java.project.repository.impl.SettingsRepository;
import ru.innopolis.university.summerbootcamp.java.project.services.Service;

import java.util.List;

/**
 * Created by dalv6_000 on 15.07.2016.
 */
public class SettingsServices implements Service<Settings> {

    private static SettingsRepository settingsRepository = SettingsRepository.getInstance();
    private static SettingsServices settingsServices;

    public static SettingsServices getInstance() {
        if (settingsServices == null) {
            settingsServices = new SettingsServices();
        }
        return settingsServices;
    }

    private SettingsServices() {}

    public Settings save(Settings object) {
        settingsRepository.create(object);
        return object;
    }

    @Override
    public Settings findOne(String name) {
        Settings settings = new Settings();
        settings.setUserName(name);
        Settings read = settingsRepository.read(settings);
        if (read == null) {
            read = new Settings();
            read.setBet(10);
            read.setCash(1000);
            read.setDifficulty(1);
            read.setMusic(true);
            read.setUserName(name);
            read.setPlayerCount(4);
        }
        return read;
    }

    public List<Settings> findAll() {
        return settingsRepository.getAll();
    }

    public Settings update(Settings object) {
        return null;
    }

    public void delete(Long objectId) {

    }
}
