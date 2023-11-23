package services.userServices.manager.function;

import entities.Rule;
import entities.movie.Genre;
import entities.movie.Movie;
import entities.movie.Ticket;
import entities.user.UserStaff;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Map;

import static ultis.Parameter.*;

public class ManagerMovieServices {
    public void addMovie(int idManager){
        System.out.println("Nhập tên phim");
        String name = scanner.nextLine();
        System.out.println("Nhập miêu tả nội dung của phim");
        String description = scanner.nextLine();
        System.out.println("Nhập ngày công chiếu (dd/MM/yyyy)");
        String lcd = scanner.nextLine();
        LocalDate releaseDate = LocalDate.parse(lcd, DateTimeFormatter.ofPattern("dd/MM/yyyy"));
        System.out.println("Nhập giá vé");
        double price = ultis.inputDouble();
        Genre genre = ultis.selectGenre();
        Ticket[][] ticket = ultis.createTicket();
        Movie movie = new Movie(name, description, releaseDate, genre, price, ticket, Rule.TRUE);
        movieMap.put(movie.getId(), movie);
        System.out.println("Thêm phim thành công");
        ultis.pressEnter();
        stateManager.stateManagerMovie(idManager);
    }

    public void removeMovie(int idManager){
        System.out.println("Nhập id phim cần gỡ chiếu");
        int id = ultis.inputInt();
        if (!movieMap.containsKey(id)){
            System.out.println("Id phim không tồn tại trong hệ thống vui lòng kiểm tra lại");
            System.out.println("1. Nhập lại id");
            System.out.println("0. Quay Lại");
            select = ultis.inputInt();
            switch (select) {
                case 1 -> removeMovie(idManager);
                default -> stateManager.stateManagerMovie(idManager);
            }
        }
        Movie movie = movieMap.get(id);
        movie.setRule(Rule.FALSE);
        System.out.println("Phim đã được gỡ bỏ. Thông tin phim bị gỡ chiếu: \n"+movie);
        ultis.pressEnter();
        stateManager.stateManagerMovie(idManager);
    }

    public void searchIdMovie(int idManager){
        System.out.println("Nhập id phim cần tìm kiếm");
        int id = ultis.inputInt();
        if (!movieMap.containsKey(id)){
            System.out.println("Id phim không tồn tại trong hệ thống vui lòng kiểm tra lại");
            System.out.println("1. Nhập lại id");
            System.out.println("0. Quay Lại");
            select = ultis.inputInt();
            switch (select) {
                case 1 -> searchIdMovie(idManager);
                default -> stateManager.stateManagerMovie(idManager);
            }
        }
        System.out.println(movieMap.get(id));
        ultis.pressEnter();
        stateManager.stateManagerMovie(idManager);
    }

    public void printMovieMenu(int idManager){
        System.out.println("1. In danh sách phim đang được chiếu");
        System.out.println("2. In danh sách phim đã dừng chiếu");
        System.out.println("3. In danh sách phim chưa chiếu");
        System.out.println("4. In toàn bộ danh sách");
        System.out.println("0. Quay lại");
        select = ultis.inputInt();
        switch (select) {
            case 1 -> printInfoMovieTrue(idManager); //True
            case 2 -> printInfoMovieFalse(idManager); //False
            case 3 -> printInfoMovieNull(idManager); //Null
            case 4 -> printInfoMovie(idManager);
            default -> stateManager.stateManagerMovie(idManager);
        }
    }
    public void printInfoMovieTrue(int idManager) {
        System.out.println("Danh sách phim đang được chiếu");
        for (Map.Entry<Integer, Movie> movieEntry : movieMap.entrySet()) {
            if (movieEntry.getValue().getRule().equals(Rule.TRUE)){
                System.out.println("id: " + movieEntry.getKey()+" : "+ movieEntry.getValue().getName());
            }
        }
        ultis.pressEnter();
        stateManager.stateManagerStaff(idManager);
    }
    public void printInfoMovieFalse(int idManager) {
        System.out.println("Danh sách phim đã dừng chiếu");
        for (Map.Entry<Integer, Movie> movieEntry : movieMap.entrySet()) {
            if (movieEntry.getValue().getRule().equals(Rule.FALSE)){
                System.out.println("id: " + movieEntry.getKey()+" : "+ movieEntry.getValue().getName());
            }
        }
        ultis.pressEnter();
        stateManager.stateManagerMovie(idManager);
    }
    public void printInfoMovieNull(int idManager) {
        System.out.println("Danh sách phim chưa chiếu");
        for (Map.Entry<Integer, Movie> movieEntry : movieMap.entrySet()) {
            if (movieEntry.getValue().getRule().equals(Rule.NULL)){
                System.out.println("id: " + movieEntry.getKey()+" : "+ movieEntry.getValue().getName());
            }
        }
        ultis.pressEnter();
        stateManager.stateManagerMovie(idManager);
    }
    public void printInfoMovie(int idManager) {
        System.out.println("Danh sách tất cả phim");
        for (Map.Entry<Integer, Movie> movieEntry : movieMap.entrySet()) {
            System.out.println("id: " + movieEntry.getKey()+" : "+ movieEntry.getValue().getName());
        }
        ultis.pressEnter();
        stateManager.stateManagerMovie(idManager);
    }
}
