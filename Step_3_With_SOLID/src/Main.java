import edu.sharif.selab.models.Message;
import edu.sharif.selab.models.MessageType;
import edu.sharif.selab.services.MessageService;
import edu.sharif.selab.services.SmsMessageService;
import edu.sharif.selab.services.EmailMessageService;
import edu.sharif.selab.services.TelegramMessageService;

import java.util.Scanner;

public class Main {
    public static final Scanner scanner = new Scanner(System.in);
    public static void main(String[] args) {
        System.out.println("Hello and Welcome to SE Lab Messenger.");
        do {
            System.out.println("In order to send Sms message enter 1");
            System.out.println("In order to send Email message enter 2");
            System.out.println("In order to send Telegram message enter 3");
            System.out.println("In order to Exit, Enter 0");

            int userAnswer = scanner.nextInt();
            if (userAnswer < 0 || userAnswer > 4) {
                System.out.println("Invalid input.");
                continue;
            }
            MessageType messageType = MessageType.values()[userAnswer];
            if (messageType == MessageType.NONE) {
                break;
            }

            // Get source, target and content of the message and get MessageService
            String source;
            String target;
            String content;
            Message message = new Message();
            MessageService messageService = null;
            switch (messageType) {
                case SMS:
                    System.out.print("Enter source phone : ");
                    source = scanner.next();
                    message.setSource(source);
                    System.out.print("Enter target phone : ");
                    target = scanner.next();
                    message.setTarget(target);
                    System.out.println("Write Your Message : ");
                    content = scanner.next(".*$");
                    message.setContent(content);

                    messageService = new SmsMessageService();
                    break;
                case EMAIL:
                    System.out.print("Enter source email : ");
                    source = scanner.next();
                    message.setSource(source);
                    System.out.print("Enter target email : ");
                    target = scanner.next();
                    message.setTarget(target);
                    System.out.println("Write Your Message : ");
                    content = scanner.next();
                    message.setContent(content);
                    
                    messageService = new EmailMessageService();
                    break;
                case TELEGRAM:
                    System.out.print("Enter source id : ");
                    source = scanner.next();
                    message.setSource(source);
                    System.out.print("Enter target id : ");
                    target = scanner.next();
                    message.setTarget(target);
                    System.out.println("Write Your Message : ");
                    content = scanner.next();
                    message.setContent(content);
                    
                    messageService = new TelegramMessageService();
                    break;
            }

            // Send the message
            if (messageService != null) {
                messageService.sendMessage(message);
            }

        } while (true);
    }
}
