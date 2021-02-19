package ru.bspb.clients;

import java.util.Objects;

public class Client {
    private String name;
    private int age;
    private char gender;

    public Client(String name, int age, char gender){
        this.name = name;//setName(name);
        setAge(age);
        setGender(gender);
    }


    public void setName(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setAge(int age) {
        this.age = age;

    }

    public int getAge() {
        return age;
    }

    public void setGender(char gender) {
        this.gender = gender;
    }

    public char getGender() {
        return gender;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Client client = (Client) o;
        return age == client.age && gender == client.gender && Objects.equals(name, client.name);
    }

}
