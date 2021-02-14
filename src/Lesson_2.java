public class Lesson_2 {
    public static void main(String[] args) {
        String[] client = new String[10];
        client[0] = "Воробьев Иван Иванович";
        client[1] = "Воронов Семен Семенович";
        client[2] = "Ромашкина Анна Владимировна";
        client[3] = "Лютикова Роза Викторовна";
        client[4] = "Чижиков Владимир Владимирович";
        client[5] = "Сидоров Стас Сергеевич";
        client[6] = "Петров Артур Иванович";
        client[7] = "Краснова Вера Петровна";
        client[8] = "Носова Любовь Викторовна";
        client[9] = "Смирнова Надежда Вячеславовна";

        int[] age = new int[10];
        age[0] = 16;
        age[1] = 52;
        age[2] = 74;
        age[3] = 66;
        age[4] = 88;
        age[5] = 28;
        age[6] = 36;
        age[7] = 58;
        age[8] = 45;
        age[9] = 44;

        char[] gender = new char[10];
        gender[0] = 'm';
        gender[1] = 'm';
        gender[2] = 'f';
        gender[3] = 'f';
        gender[4] = 'm';
        gender[5] = 'm';
        gender[6] = 'm';
        gender[7] = 'm';
        gender[8] = 'f';
        gender[9] = 'f';

        for (int i = 0; i < age.length; i++) {
            for (int j = i + 1; j < age.length; j++) {
                if (age[j] < age[i]) {
                    int agetmp = age[i];
                    String clienttmp = client[i];
                    char gendertmp = gender[i];

                    age[i] = age[j];
                    client[i] = client[j];
                    gender[i] = gender[j];

                    age[j] = agetmp;
                    client[j] = clienttmp;
                    gender[j] = gendertmp;
                }
                ;
            }
            if (gender[i] == 'm') {
                System.out.println(client[i] + " " + age[i] + " " + "Мужской");
            }
        }
    }
}
