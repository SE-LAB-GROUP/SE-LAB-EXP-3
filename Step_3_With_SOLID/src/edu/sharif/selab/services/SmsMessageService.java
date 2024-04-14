package edu.sharif.selab.services;

import edu.sharif.selab.models.Message;

public class SmsMessageService implements MessageService{
    @Override
    public void sendMessage(Message message) {
        if (validateSourceTarget(message.getSource()) && validateSourceTarget(message.getTarget())) {
            System.out.println("Sending a SMS from " + message.getSource() + " to " + message.getTarget() + " with content : " + message.getContent());
        } else {
            throw new IllegalArgumentException("Phone Number is Not Correct!");
        }
    }

    public boolean validateSourceTarget(String value) {
        // Check if the phone number is exactly 11 characters long
        if (value.length() != 11) {
            return false; // Phone number length is not valid
        }

        // Check if the phone number contains only numeric digits
        for (char digit : value.toCharArray()) {
            if (!Character.isDigit(digit)) {
                return false; // Phone number contains non-numeric characters
            }
        }

        // If all checks pass, return true (valid phone number)
        return true;
    }
}
