package ultis;

import entities.Notification;
import entities.Rule;
import entities.movie.Genre;
import entities.movie.Movie;
import entities.movie.Ticket;
import entities.movie.TicketStatus;
import entities.user.Staff;
import entities.user.UserCustomer;
import entities.user.UserStaff;

import java.time.LocalDate;

public class Data {
    private Ticket[][] ticket = new Ticket[5][6];

    public Data() {
        for (int i = 0; i < 5; i++) {
            for (int j = 0; j < 6; j++) {
                ticket[i][j] = new Ticket(TicketStatus.UNSOLD);
            }
        }
    }
    public void addUser() {
        Parameter.customerMap.put(1, new UserCustomer("tan", "1", "Tân Tân", "tantan@gmail.com", "0333333333", LocalDate.now()));
        Parameter.customerMap.put(2, new UserCustomer("viet", "1", "Việt Vip", "vietpro@gmail.com", "0388888888", LocalDate.now()));
    }

    public void addManager() {
        Parameter.staffMap.put(1, new UserStaff("viet", "Viet1.", "Mr. Việt", "admin@gmail.com", "0334868868", LocalDate.now(), Staff.MANAGER, Rule.TRUE));
        Parameter.staffMap.put(2, new UserStaff("dat", "1", "Đạt Super Prime", "datso1@gmail.com", "0334444444", LocalDate.now(), Staff.USHER, Rule.FALSE));
        Parameter.staffMap.put(3, new UserStaff("tuan", "1", "Tuấn Béo", "tuan@gmail.com", "0334444444", LocalDate.now(), Staff.PROJECTIONIST, Rule.TRUE));
        Parameter.staffMap.put(4, new UserStaff("Trang", "1", "Trang", "trang@gmail.com", "0334444444", LocalDate.now(), Staff.TICKET_SALESPERSON, Rule.TRUE));
    }

    public void addMovie() {
        Parameter.movieMap.put(1, new Movie("Oppenheimer", "Oppenheimer (2023)\n\t với nhân vật trung tâm là J. Robert Oppenheimer,\n\t nhà vật lý lý thuyết người đứng đầu phòng thí nghiệm Los Alamos,\n\t thời kỳ Thế chiến II. Ông đóng vai trò quan trọng trong Dự án Manhattan,\n\t tiên phong trong nhiệm vụ phát triển vũ khí hạt nhân, và được coi là một trong những\n\t “cha đẻ của bom nguyên tử", LocalDate.of(2023,11,9), Genre.ACTION, 50000, Rule.TRUE, ticket, 500));
        Parameter.movieMap.put(2, new Movie("The Nun 2", "Ác Quỷ Ma Sơ 2 – The Nun 2\n\t là bộ phim kinh dị siêu nhiên gothic của Hoa Kỳ\n\t được đạo diễn bởi Michael Chaves với kịch bản do Akela Cooper,\n\t Ian B. Goldberg và Richard Naing chấp bút dựa trên cốt truyện của Cooper và James Wan.\n\t Đây sẽ là phần hậu truyện của Ác quỷ ma sơ và đồng thời là phần phim\n\t thứ chín thuộc Vũ trụ The Conjuring.",  LocalDate.of(2023, 10, 3), Genre.HORROR, 50000, Rule.TRUE, ticket, 450));
        Parameter.movieMap.put(3, new Movie("John Wick: Chapter 4", "John Wick: Phần 4 – John Wick: Chapter 4\n\t là câu chuyện của John Wick (Keanu Reeves) đã khám phá ra con đường để đánh bại High Table.\n\t Nhưng trước khi có thể kiếm được tự do,\n\t Wick phải đối đầu với kẻ thù mới với những liên minh hùng mạnh trên\n\t toàn cầu và những lực lượng biến những người bạn cũ thành kẻ thù.", LocalDate.of(2023, 5, 29), Genre.ACTION, 50000, Rule.TRUE, ticket, 700));
        Parameter.movieMap.put(4, new Movie("Fingernails (2023)", "Móng Tay Duyên Phận Fingernails 2023 Anna (Jessie Buckley) và Ryan (Jeremy Allen White)\n\t đã tìm thấy tình yêu đích thực. Điều này đã được chứng minh bằng một công nghệ mới gây tranh cãi.\n\t Chỉ có một vấn đề duy nhất: Anna vẫn chưa chắc chắn.\n\t Sau đó cô nhận một vị trí tại viện kiểm tra tình yêu\n\t và gặp gỡ Amir (Riz Ahmed). ",LocalDate.of(2023, 5, 29), Genre.ACTION, 50000, Rule.TRUE, ticket, 300));
        Parameter.movieMap.put(5, new Movie("The Marvels", "The Marvels Biệt đội Marvel 2023 Carol Danvers hay còn gọi là Captain Marvel\n\t đã giành lại danh tính của mình từ Kree độc tài và trả thù Trí tuệ tối cao . Nhưng những hậu quả ngoài\n\t ý muốn khiến Carol phải gánh vác gánh nặng của một vũ trụ bất ổn. Khi nhiệm vụ của cô ấy đưa cô ấy\n\t đến một hố sâu dị thường có liên quan đến một nhà cách mạng Kree,\n\t sức mạnh của cô ấy bị vướng vào sức mạnh của Kamala Khan , một người hâm mộ cuồng nhiệt của Thành phố Jersey ,\n\t hay còn gọi là Ms. Marvel, và cháu gái bị ghẻ lạnh của Carol, giờ là SABRE\n\t . Cùng với nhau, bộ ba không tưởng này phải hợp tác và \n\thọc cách phối hợp với nhau để cứu vũ trụ với tên gọi The Marvels ", LocalDate.of(2023, 5, 29), Genre.ACTION, 50000, Rule.FALSE, ticket, 1000));
    }

    public void addNotification(){
        Parameter.notifications.add(new Notification("Chào Mừng Bạn Mới", "Chúng tôi xin gửi tặng bạn voucher giảm giá 50.000đ tới bạn, chúc bạn có những phút giây xem phim vui vẻ"));
    }
}
