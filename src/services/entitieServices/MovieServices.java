package services.entitieServices;

import entities.movie.Bill;
import entities.movie.Movie;
import entities.movie.Ticket;
import entities.movie.TicketStatus;
import entities.voucher.Voucher;
import ultis.Parameter;

import java.util.*;

import static ultis.Parameter.*;

public class MovieServices {
    public void movieInfo(int idUser) {
        for (int i = 0; i < movieMap.size(); i++) {
            Movie movie = movieMap.get((i+1));
            System.out.println("id: " + movie.getId() +" : "+ movie.getName());
        }
        System.out.println("\nNhập id phim để xem thông tin chi tiết");
        int idMovie = ultis.inputInt();
        System.out.println(movieMap.get(idMovie));
        System.out.println("1. Mua vé");
        System.out.println("0. Exit");
        select = Parameter.ultis.inputInt();
        switch (select) {
            case 1:
                stateCustomer.buyTicketState(idMovie, idUser);
                break;
            default:
                stateCustomer.customerMenuState(idUser);
                break;
        }
    }

    public void buyTicket(int idMovie, int idUser) {
        double cost = 0;
        Movie movie = movieMap.get(idMovie);
        customer = customerMap.get(idUser);
        // in hàng ghế
        Ticket[][] array = movie.getTicket();
        for (int i = 0; i < array.length; i++) {
            for (int j = 0; j < array[i].length; j++) {
                System.out.print("|" + i + j + ": " + array[i][j] + "| ");
            }
            System.out.println();
        }
        System.out.println("Nhập số hàng và cột của ghế mà bạn muốn mua:");
        System.out.print("Hàng: ");
        int rowIndex = ultis.inputInt();
        System.out.print("Cột: ");
        int columnIndex = ultis.inputInt();
        if (rowIndex >= 0 && rowIndex < array.length && columnIndex >= 0 && columnIndex < array[rowIndex].length) {
            Ticket ticket = array[rowIndex][columnIndex];
            if (ticket.getStatus().equals(TicketStatus.HOLD)) {
                System.out.println("Ghế ngồi đang được giữ bởi người dùng khác, vui lòng chọn ghế khác hoặc thử lại sau");
                buyTicket(idMovie, idUser);
            }
            if (ticket.getStatus().equals(TicketStatus.SOLD)) {
                System.out.println("Ghế ngồi đã được bán vui lòng chọn lại ghế trống khác!\n");
                buyTicket(idMovie, idUser);
            }
            ticket.setStatus(TicketStatus.HOLD); // tạm giữ ghế cho khách hàng này
            ArrayList<Voucher> voucher = customer.getVoucher();
            while (true) {
                if (voucher.size() >= 1) {
                    System.out.println("bạn đang có " + voucher.size() + " voucher:");
                    for (int i = 0; i < voucher.size(); i++) {
                        System.out.println((i + 1) + "-\t" + voucher);
                    }
                    System.out.println("bạn muốn sử dụng voucher nào không?");
                    System.out.println("1. Có");
                    System.out.println("2. không");
                    select = ultis.inputInt();
                    switch (select) {
                        case 1:
                            System.out.println("mời bạn nhập stt của voucher mà bạn muốn sử dụng");
                            int input = ultis.inputInt();
                            Voucher voucherInput = voucher.get(input - 1);
                            boolean checkVoucher = ultis.checkVoucher(voucherInput);
                            if (checkVoucher == false) {
                                continue;
                            } else {
                                cost = voucher.get(input - 1).getCost();
                                voucher.remove(input - 1);
                            }
                        case 2:
                            break;
                    }
                }

                // in hóa đơn
                double ticketPrice = movie.getPrice() - cost;
                String number = "[" + rowIndex + columnIndex + "]";

                Bill bill = new Bill(idUser ,movie.getId(), movie.getName(), number, ticketPrice);
                System.out.println(bill);
                System.out.println("bạn có đồng ý mua vé không?");
                System.out.println("1. Có");
                System.out.println("2. không");
                select = ultis.inputInt();
                switch (select) {
                    case 1:
                        // set giá trị cho mảng sau khi bán thành công
                        ticket.setStatus(TicketStatus.SOLD);
                        break;
                    case 2:
                        System.out.println("bạn có muốn mua lại vé khác? (1.Có / 2.Không)");
                        select = ultis.inputInt();
                        System.out.println("1. Có");
                        System.out.println("2. không");
                        select = ultis.inputInt();
                        switch (select) {
                            case 1:
                                buyTicket(idMovie, idUser);
                            case 2:
                                ticket.setStatus(TicketStatus.UNSOLD); // khách không mua set lại giá trị cho ghế ngồi
                                stateCustomer.customerMenuState(idUser);
                        }
                        break;
                }
                bills.add(bill);
                System.out.println("Bạn đã mua vé thành công: " + bill);
                // +1 cho tổng vé bán
                movie.setTotalSold(movie.getTotalSold() + 1);
                // thêm vé lưu vào cho người dùng
                ArrayList<Bill> billUser = new ArrayList<>();
                billUser.add(bill);
                customer.setBill(billUser);
                customer.setBalance(customer.getBalance() - movie.getPrice());
                break;
            }
        }else {
            System.out.println("Hàng hoặc cột không hợp lệ.");
            buyTicket(idMovie, idUser);
        }
        stateCustomer.customerMenuState(idUser);
    }

    // in ra tổng số phim và sắp xếp theo thứ tự từ cao đến thấp của vé bán
    public void movieTotalSale(int idManager) {
        // Chuyển đổi Map sang ArrayList để sắp xếp
        List<Map.Entry<Integer, Movie>> entryList = new ArrayList<>(movieMap.entrySet());

        // Sắp xếp danh sách các Map.Entry dựa trên giá trị
        entryList.sort(Comparator.comparing(entry -> entry.getValue().getTotalSold(), Comparator.reverseOrder()));

        // In ra các phần tử đã được sắp xếp theo giá trị
        for (Map.Entry<Integer, Movie> entry : entryList) {
            System.out.println("id: " + entry.getKey() +" : "+ entry.getValue().getName() + "\n- Tổng số vé đã bán : " + entry.getValue().getTotalSold());
        }
        ultis.pressEnter();
        stateManager.stateMenuManager(idManager);
    }
}
