package ru.bspb.clients;

public class ObjectsMain {
    public static void main(String[] args) {
        String[] name = new String[10];
        name[0] = "Воробьев Иван Иванович";
        name[1] = "Воронов Семен Семенович";
        name[2] = "Воронов Семен Семенович";
        name[3] = "Ромашкина Анна Владимировна";
        name[4] = "Чижиков Владимир Владимирович";
        name[5] = "Сидоров Стас Сергеевич";
        name[6] = "Петров Артур Иванович";
        name[7] = "Петров Артур Иванович";
        name[8] = "Носова Любовь Викторовна";
        name[9] = "Смирнова Надежда Вячеславовна";

        int[] age = new int[10];
        age[0] = 16;
        age[1] = 52;
        age[2] = 52;
        age[3] = 74;
        age[4] = 88;
        age[5] = 28;
        age[6] = 36;
        age[7] = 36;
        age[8] = 45;
        age[9] = 44;

        char[] gender = new char[10];
        gender[0] = 'm';
        gender[1] = 'm';
        gender[2] = 'm';
        gender[3] = 'f';
        gender[4] = 'm';
        gender[5] = 'm';
        gender[6] = 'm';
        gender[7] = 'm';
        gender[8] = 'f';
        gender[9] = 'f';

        Client[] clients = new Client[10];
        for (int i = 0; i < 10; i++) {
            clients[i] = new Client(name[i], age[i], gender[i]);
            //         clients[i].setName(name[i]);
            //         clients[i].setAge(age[i]);
            //         clients[i].setGender(gender[i]);
        }

        for (int i = 0; i < clients.length; i++) {
            for (int j = i + 1; j < clients.length; j++) {
                if (clients[j].getAge() < clients[i].getAge()) {
                    Client tmp = clients[j];
                    clients[j] = clients[i];
                    clients[i] = tmp;
                }
            }
        }
        Client[] out = new Client[10];
        int indexOut = 0;
        for (int i = 0; i < clients.length; i++) {
            if (clients[i].getGender() == 'm') {
                boolean unique = true;
                for (int j = 0; j <= indexOut; j++) {
                    if (clients[i].equals(out[j])) {
                        unique = false;
                        break;
                    }
                }
                if (unique) {
                    System.out.println(clients[i].getName() + " " + clients[i].getAge() + " " + "Мужской");
                    out[indexOut] = clients[i];
                    indexOut = indexOut + 1;
                }
            }
        }
    }
}
