package ru.innopolis.university.summerbootcamp.java.project.ui;

import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;
import ru.innopolis.university.summerbootcamp.java.project.model.Settings;

import java.io.*;

/**
 * Created by NIKMC-I on 20.07.2016.
 */
public class CoreConfig{

    BufferedReader bufferedReader = null;
    BufferedWriter bufferedWriter = null;
    FileWriter file = null;
    public void saveSettings(Settings settings){

        JSONObject obj = new JSONObject();
        obj.put("Name", settings.getUserName());
        obj.put("Password", settings.getPassword());
        obj.put("Cash", settings.getCash());
        obj.put("PlayerCount", settings.getPlayerCount());
        obj.put("Difficulty", settings.getDifficulty());
        obj.put("Bat", settings.getBat());

        try {
            file = new FileWriter("Settings.txt");
            file.write(obj.toJSONString());

        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (file != null) try {
                file.flush();
                file.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    public Settings getSettings(){
        Settings settings = new Settings();
        JSONParser parser = new JSONParser();
        try {




            JSONObject jsonObject = (JSONObject) parser.parse(new FileReader("Settings.txt"));

            settings.setUserName((String) jsonObject.get("Name"));
            settings.setPassword((String) jsonObject.get("Password"));
            settings.setBat((int)(long) jsonObject.get("Bat"));
            settings.setCash((int)(long) jsonObject.get("Cash"));
            settings.setDifficulty((int)(long) jsonObject.get("Difficulty"));
            settings.setPlayerCount((int)(long) jsonObject.get("PlayerCount"));


        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ParseException e) {
            e.printStackTrace();
        } finally {
        }
        return settings;
    }

    private void getSettingsBat(){
        try {
            bufferedReader = new BufferedReader(new FileReader(""));


        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } finally {
            if (bufferedReader != null) try {
                bufferedReader.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    private void getSettingsPlayerCount(){
        try {
            bufferedReader = new BufferedReader(new FileReader(""));


        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } finally {
            if (bufferedReader != null) try {
                bufferedReader.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
    private void getSettingsDifficulty(){
        try {
            bufferedReader = new BufferedReader(new FileReader(""));


        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } finally {
            if (bufferedReader != null) try {
                bufferedReader.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }


    private void saveSettingsBat(){
        try {
            File file = new File("");
            bufferedWriter = new BufferedWriter(new FileWriter(file.getAbsoluteFile()));
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (bufferedWriter != null) try {
                bufferedWriter.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    private void saveSettingsPlayerCount(){
        try {
            File file = new File("");
            bufferedWriter = new BufferedWriter(new FileWriter(file.getAbsoluteFile()));
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (bufferedWriter != null) try {
                bufferedWriter.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    private void saveSettingsDifficulty(){
        try {
            File file = new File("");
            bufferedWriter = new BufferedWriter(new FileWriter(file.getAbsoluteFile()));
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (bufferedWriter != null) try {
                bufferedWriter.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

}