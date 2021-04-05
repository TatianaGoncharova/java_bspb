package ru.bspb.lesson8;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.util.ArrayList;
import java.util.List;
import java.util.function.Predicate;
import java.util.stream.Collectors;

public class ObjectMain2 {


    public static void main(String[] args) {
        String path = "C:\\java-lessons";
        File file = new File(path);
        File[] files = file.listFiles();

//        String s = "2015-07-29 19:23:06,729 - WARN  [RecvWorker:188978561024:QuorumCnxManager$RecvWorker@765] - Interrupting SendWorker";
//        System.out.println(mapToEntry(s));

//        List<LogEntry> logs = getLogs(files);

//        System.out.println(logs);

//        Predicate<LogEntry> predicate = new Predicate<LogEntry>() {
//            @Override
//            public boolean test(LogEntry logEntry) {
//                return logEntry.getLevel().equals("WARN");
//            }
//        };


//        Predicate<LogEntry> predicate = logEntry -> logEntry.getLevel().equals("WARN");
//
//        List<LogEntry> filterByInfo = filterByPredicate(logs, predicate);
//
//        System.out.println(filterByInfo);
//


//        List<LogEntry> filterByInfo = filterByLevel(logs, "WARN");
//        System.out.println(filterByInfo);

        String message = "[SendWorker:188978561024:QuorumCnxManager$SendWorker@688] - Send worker leaving thread";
        printOccurrenceMessage(files, message);

    }

    public static List<LogEntry> filterByLevel(List<LogEntry> logEntries, String level) {
        return filterByPredicate(logEntries, logEntry -> logEntry.getLevel().equals(level));
    }


    public static List<LogEntry> filterByPredicate(List<LogEntry> logEntries, Predicate<LogEntry> predicate) {
//        List<LogEntry> entries = logEntries.stream().filter(predicate).collect(Collectors.toList());

        List<LogEntry> entries = new ArrayList<>();

        for (int i = 0; i < logEntries.size(); i++) {
            LogEntry log = logEntries.get(i);
            if (predicate.test(log)) {
                entries.add(log);
            }
        }

        return entries;
    }

    public static List<LogEntry> getLogs(File[] files) {
        List<LogEntry> logEntries = new ArrayList<>();//лист, в который мы будем собирать все записи из каждого файла
        for (int i = 0; i < files.length; i++) {
//            if (files[i].isDirectory()) continue;//начинаем следующую итерацию, если этот файл - директория.
//
//            try {
//                List<String> lines = Files.readAllLines(files[i].toPath());//readAllLines - позволяет считать все строки из текстового файла
//                //проходимся по каждой строке кажого файла, чтобы превратить её в объект LogEntry. Получаем из файла лист таких объектов
//                List<LogEntry> logEntryList = lines.stream().map(s -> mapToLogEntry(s)).collect(Collectors.toList());
//                logEntries.addAll(logEntryList);
//            } catch (IOException e) {
//                System.out.println("ошибка");
//            }
            logEntries.addAll(getLogs(files[i]));
        }
        return logEntries;
    }


    public static List<LogEntry> getLogs(File file) {
        List<LogEntry> logEntries = new ArrayList<>();//лист, в который мы будем собирать все записи из этого файла
        if (file.isDirectory())
            return logEntries;//если этот файл директория, возвращаем пустой лист.

        try {
            List<String> lines = Files.readAllLines(file.toPath());//readAllLines - позволяет считать все строки из текстового файла
            //проходимся по каждой строке кажого файла, чтобы превратить её в объект LogEntry. Получаем из файла лист таких объектов
            List<LogEntry> logEntryList = lines.stream().map(s -> mapToLogEntry(s)).collect(Collectors.toList());
            logEntries.addAll(logEntryList);
        } catch (IOException e) {
            System.out.println("ошибка");
        }
        return logEntries;
    }


    public static void printOccurrenceMessage(File[] files, String message) {
        for (int i = 0; i < files.length; i++) {
            List<LogEntry> logEntryList = getLogs(files[i]);
            for (int j = 0; j < logEntryList.size(); j++) {
                if (logEntryList.get(j).getMessage().equals(message)) {
                    System.out.println(files[i].getName() + " " + (j + 1));
                }
            }
        }
    }

    private static LogEntry mapToLogEntry(String s) {
        String time = s.substring(0, 24);
        int i = s.indexOf(' ', 27);
        String level = s.substring(26, i);
        String message = s.substring(i).trim();

        return new LogEntry(time, level, message);
    }
}
