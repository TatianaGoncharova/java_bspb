package ru.bspb.lesson4;

import java.util.Arrays;

public class Utils {

    public static void sortByAges(AbstractClient[] clients){
        Arrays.sort(clients, new ComparatorByAges());
    }

    public static PhysicClient[] filterByGender(PhysicClient[] clients, char gender){
        int count = 0;
        for (int i = 0; i < clients.length; i++) {
            if(clients[i].getGender()==gender){
                count++;
            }
        }

        PhysicClient[] out = new PhysicClient[count];
        int index = 0;

        for (int i = 0; i < clients.length; i++) {
            if(clients[i].getGender()==gender){
                out[index] = clients[i];
                index++;
            }
        }
        return out;
    }

    public static AbstractClient[] deleteDuplicate(AbstractClient[] clients){
        AbstractClient[] tmpOut = new AbstractClient[clients.length];
        int indexOut = 0;
        for (int i = 0; i < clients.length; i++) {
            boolean unique = true;
            for (int j = 0; j <= indexOut; j++) {
                if (clients[i].equals(tmpOut[j])) {
                    unique = false;
                    break;
                }
            }
            if(unique) {
                tmpOut[indexOut] = clients[i];
                indexOut = indexOut + 1;
            }
        }

        AbstractClient[] out = new AbstractClient[indexOut];

        for (int i = 0; i < out.length; i++) {
            out[i] = tmpOut[i];
        }
        return out;
    }

    public static void print(AbstractClient[] clients) {
        for (int i = 0; i < clients.length; i++) {
            System.out.println(clients[i].toString());
        }
    }
}
