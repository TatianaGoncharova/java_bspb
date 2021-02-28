package ru.bspb.lesson4;

public class ObjectMain1 {
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

        int[] age;
        age = new int[10];
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


        PhysicClient[] clients = new PhysicClient[10];
        for (int i = 0; i < 10; i++) {
            clients[i] = new PhysicClient(name[i], age[i], gender[i]);
 //           clients[i].setName(name[i]);
 //           clients[i].setAge(age[i]);
//            clients[i].setGender(gender[i]);
        }
        Utils.sortByAges(clients);
        clients = Utils.filterByGender(clients, 'm');
        AbstractClient[] withoutDuplicate = Utils.deleteDuplicate(clients);

        Utils.print(withoutDuplicate);
    }
}

