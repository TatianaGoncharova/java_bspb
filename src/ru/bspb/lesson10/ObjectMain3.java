package ru.bspb.lesson10;

import com.fasterxml.jackson.databind.ObjectMapper;
import ru.bspb.lesson10.pojo.DataItem;
import ru.bspb.lesson10.pojo.GetUsersResponse;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.util.List;
import java.util.function.Predicate;

public class ObjectMain3 {

    private static String url = "https://reqres.in/api/users";

    public static void main(String[] args) throws IOException, InterruptedException {

//        getAll();
//
//        delete(2);
//
//        getAll();

//        usersToDelete("George");
        usersToDelete(user -> user.getId() == 2);
    }


    public static void delete(int id)  {
        HttpClient httpClient = HttpClient.newHttpClient();
        HttpRequest request = HttpRequest.newBuilder()
                .DELETE()
                .header("Content-type", "application/json")
                .uri(URI.create(url + "/" + id))
//                .uri(URI.create(url + "?id=" + id))
                .build();

        try {
            HttpResponse<String> response = httpClient.send(request, HttpResponse.BodyHandlers.ofString());
            System.out.println(response.statusCode());


        } catch (IOException | InterruptedException e) {
            e.printStackTrace();
        }
    }

    public static List<DataItem> getAll() throws IOException, InterruptedException {
        HttpClient httpClient = HttpClient.newHttpClient();

        HttpRequest request = HttpRequest.newBuilder()
                .GET()
                .header("accept", "application/json")
                .uri(URI.create(url))
                .build();
        HttpResponse<String> response = httpClient.send(request, HttpResponse.BodyHandlers.ofString());

        ObjectMapper objectMapper = new ObjectMapper();
        GetUsersResponse getUsersResponse = objectMapper.readValue(response.body(), GetUsersResponse.class);

//        System.out.println(getUsersResponse);

        List<DataItem> data = getUsersResponse.getData();

//        for (DataItem datum : data) {
//            System.out.println(datum);
//        }
        return data;
    }


    public static void usersToDelete (String name) throws IOException, InterruptedException {
        System.out.println("-----------------------------------Удаление пользователей-----------------------------------");

        List<DataItem> users = getAll();
//        for (int i = 0; i < users.size(); i++) {
//            DataItem dataItem = users.get(i);
//            if(dataItem.getFirstName().equals(name)){
//                delete(dataItem.getId());
//                System.out.println("удалили пользователя " + dataItem);
//            }
//        }


//        users.stream()
//                .filter(user -> user.getFirstName().equals(name))
//                .forEach(user -> delete(user.getId()));
//

        usersToDelete(user -> user.getFirstName().equals(name));
    }

    public static void usersToDelete (Predicate<DataItem> predicate) throws IOException, InterruptedException {
        System.out.println("-----------------------------------Удаление пользователей-----------------------------------");

        List<DataItem> users = getAll();
//        for (int i = 0; i < users.size(); i++) {
//            DataItem dataItem = users.get(i);
//            if(dataItem.getFirstName().equals(name)){
//                delete(dataItem.getId());
//                System.out.println("удалили пользователя " + dataItem);
//            }
//        }
        users.stream()
                .filter(predicate)
                .forEach(user -> delete(user.getId()));
    }
}
