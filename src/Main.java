import org.telegram.telegrambots.meta.TelegramBotsApi;
import org.telegram.telegrambots.meta.exceptions.TelegramApiException;
import org.telegram.telegrambots.updatesreceivers.DefaultBotSession;

import java.util.Scanner;
public class Main{
    public static void main(String[] args){
        String input;
        Scanner sc = new Scanner(System.in);
        Registration reg = new Registration();
        Authorization auth = new Authorization();

        try {
            TelegramBotsApi botsApi = new TelegramBotsApi(DefaultBotSession.class);
            botsApi.registerBot(new TelegramNotification());
        } catch (TelegramApiException e) {
            e.printStackTrace();
        }
        TelegramNotification notification = new TelegramNotification();

        while(true){
            System.out.println("Choose: reg or auth");
            do { input = sc.nextLine(); }
            while (!input.equals("reg") && !input.equals("auth"));
            if (input.equals("reg")) {
                System.out.print("Enter login: ");
                reg.setLogin(sc.nextLine());
                System.out.print("Enter IIN: ");
                reg.setIIN(sc.nextLine());
                System.out.print("Enter Password: ");
                reg.setPassword(sc.nextLine());
                if(reg.regUser()){
                    System.out.println("Congratz! You complete registration!");
                }else{
                    System.out.println("Remember: IIN:12 digits");
                    System.out.println("Password with uppercase, number and from 6 to 12 symbols");
                    System.out.println("Login from 6 to 20 symbols, with uppercase and number");
                }
                continue;
            } else if (input.equals("auth")) {
                    System.out.print("Enter login or IIN: ");
                    auth.setLoginOrIin(sc.nextLine());
                    System.out.print("Enter password: ");
                    auth.setPassword(sc.nextLine());
                    if (reg.checkPassword(auth.getPassword())) {
                        if (auth.Author()) {
                            System.out.println("Authorization completed successfully!");
                        } else {
                            System.out.println("Try again!");
                        }
                    } else {
                        System.out.println("    The password must be longer than 7 letters, " +
                                "contain a capital letter, and a digit");
                        System.out.println("    Try again");
                    }
            }
            CodeGen code = new CodeGen();
            SendMail mail = new SendMail("Your verification code for authorization: " + code.getCode());
            notification.setAnswer("Someone requested verification code. Code is " + code.getCode());
            System.out.print("Enter verification code from your email: ");
            while (!code.checkCode(sc.nextLine())) {
                System.out.print("Wrong code! Try again: ");
            }
            notification.setAnswer("Someone logged into the app now");
            System.out.println("Success!");
            break;
        }
    }
}
