import org.telegram.telegrambots.meta.TelegramBotsApi;
import org.telegram.telegrambots.meta.exceptions.TelegramApiException;
import org.telegram.telegrambots.updatesreceivers.DefaultBotSession;
import java.util.ArrayList;
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
            ArrayList<String> actions = new ArrayList<>();
            actions.add("Choose: reg");
            actions.add("or");
            actions.add("Choose: auth");
            for(String s : actions){
                System.out.println(s);
            }
            do { input = sc.nextLine(); }
            while (!input.equals("reg") && !input.equals("auth"));
            if (input.equals("reg")) {
                actions.add("Enter login: ");
                actions.add("Enter IIN: ");
                actions.add("Enter Password: ");
                actions.add("Congratz! You complete registration!");
                actions.add("Remember: IIN:12 digits");
                actions.add("Password with uppercase, number and from 6 to 12 symbols");
                actions.add("Login from 6 to 20 symbols, with uppercase and number");
                System.out.print(actions.get(3));
                reg.setLogin(sc.nextLine());
                System.out.print(actions.get(4));
                reg.setIIN(sc.nextLine());
                System.out.print(actions.get(5));
                reg.setPassword(sc.nextLine());
                if(reg.regUser()){
                    System.out.println(actions.get(6));
                }else{
                    System.out.println(actions.get(7));
                    System.out.println(actions.get(8));
                    System.out.println(actions.get(9));
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
                    }
            }
            CodeGen code = new CodeGen();
            //SendMail mail = new SendMail("Your verification code for authorization: " + code.getCode());
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
