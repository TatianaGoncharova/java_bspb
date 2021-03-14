package ru.bspb.lesson4;

import java.util.Objects;

public class PhysicClient extends AbstractClient {
    private char gender;

    public PhysicClient(String name, int age, char gender) {
        super(name, age);
        setGender(gender);
    }

    public void setGender(char gender) {
        this.gender = gender;
    }

    public char getGender() {
        return gender;
    }

    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        PhysicClient client = (PhysicClient) o;
        return age == client.age && gender == client.gender && Objects.equals(name, client.name);
    }

    @Override
    public String toString() {
        GenderTypes genderType;

        if (gender == 'm') {
            genderType = GenderTypes.MEN;
        }
        else {
            genderType = GenderTypes.WOMEN;
        }

        return name + " " + age + " " + genderType.getPolClient() + "\n";
    }

    @Override
    public int hashCode() {
        int code = 100;
        for (int i = 0; i < getName().length(); i++) {
            code += code * getName().length() * getName().charAt(i);
        }
        code *= age;

        code += gender;


        return code;
    }
}





