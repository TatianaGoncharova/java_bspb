package ru.bspb.lesson8;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class ObjectMain2 {


    public static void main(String[] args) {
        String path = "C:\\java-lessons";
        File file = new File(path);
        File[] files = file.listFiles();

//        String s = "2015-07-29 19:23:06,729 - WARN  [RecvWorker:188978561024:QuorumCnxManager$RecvWorker@765] - Interrupting SendWorker";
//        System.out.println(mapToEntry(s));

        List<LogEntry> logs = getLogs(files);

        System.out.println(logs);


    }

    public static List<LogEntry> getLogs(File[] files){
        List<LogEntry> logEntries = new ArrayList<>();
        for (int i = 0; i < files.length; i++) {
            if (files[i].isDirectory()) continue;//начинаем следующую итерацию, если этот файл - директория.

            try {
                List<String> lines = Files.readAllLines(files[i].toPath());//readAllLines - позволяет считать все строки из текстового файла
                List<LogEntry> logEntryList = lines.stream().map(s -> mapToEntry(s)).collect(Collectors.toList());
                logEntries.addAll(logEntryList);


            } catch (IOException e) {
                System.out.println("ошибка");
            }
        }
        return logEntries;
    }

    private static LogEntry mapToEntry(String s){
        String time = s.substring(0, 24);
        int i = s.indexOf(' ', 27);
        String level = s.substring(26, i);
        String message = s.substring(i).trim();


        return new LogEntry(time, level, message);
    }
}
