package ultis;

import entities.Notification;
import entities.managerPlan.Target;
import entities.managerPlan.Training;
import entities.managerPlan.WorkSchedule;
import entities.movie.Bill;
import entities.movie.Movie;
import entities.user.UserCustomer;
import entities.user.UserStaff;
import entities.voucher.Voucher;
import menu.CustomerMenu;
import menu.ManagerMenu;
import menu.MenuMain;
import services.userServices.customer.AccountServices;
import services.userServices.customer.CustomerServices;
import services.entitieServices.MovieServices;
import services.userServices.AccountStaffServices;
import services.userServices.manager.function.ManagerMovieServices;
import services.userServices.manager.function.StaffServices;
import services.userServices.manager.plan.TargetServices;
import services.userServices.manager.plan.TrainingServices;
import services.userServices.manager.plan.WorkScheduleServices;
import states.StateCustomer;
import states.StateManager;
import states.States;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public abstract class Parameter {
    // Khởi tạo các đối tượng có thể tái sử dụng
    public static final Scanner scanner = new Scanner(System.in);
    public static final Ultis ultis = new Ultis();
    public static int select = 0;

    // ACCOUNT
    public static final AccountServices accountService = new AccountServices();


    // CUSTOMER
    public static final Map<Integer, UserCustomer> customerMap = new HashMap<>();
    public static UserCustomer customer;
    public static final CustomerServices customerSevice = new CustomerServices();
    public static final CustomerMenu customerMenu = new CustomerMenu();


    // MANAGER
    public static UserStaff staff;
    public static final Map<Integer, UserStaff> staffMap = new HashMap<>();
    public static final ManagerMenu managerMenu = new ManagerMenu();
    public static final AccountStaffServices accountStaffService = new AccountStaffServices();


    // MANAGER FUNCTION
    public static final StaffServices staffService = new StaffServices();
    public static final ManagerMovieServices managerMovieServices = new ManagerMovieServices();


    // PLANE
    public static final ArrayList<WorkSchedule> workSchedules = new ArrayList<>();
    public static final WorkScheduleServices workScheduleServices = new WorkScheduleServices();
    public static final TargetServices targetServices = new TargetServices();
    public static final TrainingServices trainingServices = new TrainingServices();



    // STATE
    public static final States state = new States();
    public static final StateCustomer stateCustomer = new StateCustomer();
    public static final StateManager stateManager = new StateManager();


    // MENU
    public static final MenuMain menuMain = new MenuMain();


    // MOVIE
    public static final Movie movie = new Movie();
    public static final MovieServices movieService = new MovieServices();
    public static final Map<Integer, Movie> movieMap = new HashMap<>();


    // VOUCHER
    public static final ArrayList<Voucher> vouchers = new ArrayList<>();


    // BILL
    public static final ArrayList<Bill> bills = new ArrayList<>();


    // NOTIFICATION
    public static final ArrayList<Notification> notifications = new ArrayList<>();

    // TARGET
    public static final Map<Integer, Target> targetMap = new HashMap<>();
    // TRAINING
    public static final Map<Integer, Training> trainingMap = new HashMap<>();

}
