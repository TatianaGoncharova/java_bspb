package ru.bspb.lesson4;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;
import java.util.TreeSet;

public class ObjectMain1 {
    public static void main(String[] args) {

        int n_clients = 10;
        String[] name = new String[n_clients];
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
        age = new int[n_clients];
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

        char[] gender = new char[n_clients];
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


//        PhysicClient[] clients = new PhysicClient[10];
//        for (int i = 0; i < 10; i++) {
//            clients[i] = new PhysicClient(name[i], age[i], gender[i]);
//            //           clients[i].setName(name[i]);
//            //           clients[i].setAge(age[i]);
////            clients[i].setGender(gender[i]);
//        }
//        Utils.sortByAges(clients);
//        clients = Utils.filterByGender(clients, 'm');
//        AbstractClient[] withoutDuplicate = Utils.deleteDuplicate(clients);
//
//        Utils.print(withoutDuplicate);


        ArrayList<PhysicClient> clients = new ArrayList<>();

        for (int i = 0; i < n_clients; i++) {
            clients.add(new PhysicClient(name[i], age[i], gender[i]));
        }

//        clients.sort(new ComparatorByAges()); //не нужен, потому что используем в TreeSet
//        clients.removeIf(new PredicateByGender());

//        System.out.println(clients);

        Set<PhysicClient> setClients = new TreeSet<>(new ComparatorByAges());
        setClients.addAll(clients);
        setClients.removeIf(new PredicateByGender());

        System.out.println(setClients);
    }

    IPClient[] ipClient = new IPClient[]{
            new IPClient("ИП Винни-Пух Иван Георгиевич", 35, 123456789012345L),
            new IPClient("ИП Пятачек Семен Аркадиевич", 23, 123456789054321L),
            new IPClient("ИП Осликович Армен Зуевич", 59, 123456789045612L),
            new IPClient("ИП Сова Клавдия Петровна", 78, 123456789059578L),
            new IPClient("ИП Тигра Лариса Викторовна", 31, 123456789025896L),
            new IPClient("ИП Карлсон Юрий Валентинович", 45, 123456789023145L),
            new IPClient("ИП Фрекен-Бок Мария Игоревна", 68, 123456789036974L),
            new IPClient("ИП Малыш Дмиртий Алексеевич", 18, 123456789025698L),
            new IPClient("ИП Буратино Карл Феликсович", 27, 123456789014385L),
            new IPClient("ИП Мальвина Инесса Аркадиевна", 25, 123456789014587L),
    };
}


