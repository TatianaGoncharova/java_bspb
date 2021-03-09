package ru.bspb.lesson4;

public enum GenderTypes {

    MEN("Мужской"),
    WOMEN("Женский");

    private String polClient;


    GenderTypes(String polClient) {
        this.polClient = polClient;
    }

    public String getPolClient() {
        return polClient;
    }
}