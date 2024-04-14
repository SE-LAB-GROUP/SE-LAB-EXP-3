package edu.sharif.selab.services;

import edu.sharif.selab.models.Message;

import java.util.regex.Pattern;

public class EmailMessageService implements MessageService {

    @Override
    public void sendMessage(Message message) {
        if (validateSourceTarget(message.getSource()) && validateSourceTarget(message.getTarget())) {
            System.out.println("Sending a Email from " + message.getSource() + " to " + message.getTarget() + " with content : " + message.getContent());
        } else {
            throw new IllegalArgumentException("Email Address is Not Correct!");
        }
    }


    public boolean validateSourceTarget(String value) {
        // Regular expression pattern for validating email addresses
        String regex = "^[a-zA-Z0-9_.+-]+@[a-zA-Z0-9-]+\\.[a-zA-Z0-9-.]+$";

        // Compile the pattern into a regex Pattern object
        Pattern pattern = Pattern.compile(regex);

        // Check if the email string matches the regex pattern
        return pattern.matcher(value).matches();
    }
}
