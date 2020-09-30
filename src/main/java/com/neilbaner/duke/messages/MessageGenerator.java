package com.neilbaner.duke.messages;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class MessageGenerator {
    public static String generateConfirmationMessage() {
        File confirmationMessagesFile = new File("src/main/java/com/neilbaner/duke/messages/confirmationmessages");
        File namesFile = new File("src/main/java/com/neilbaner/duke/messages/names");
        String finalMessage = "";
        try {
            Scanner messageScanner = new Scanner(confirmationMessagesFile);
            Scanner nameScanner = new Scanner(namesFile);

            int numberOfMessages = Integer.parseInt(messageScanner.nextLine());
            int numberOfNames = Integer.parseInt(nameScanner.nextLine());

            int messageToDisplay = (int) (Math.random() * (numberOfMessages - 1));
            int nameToDisplay = (int) (Math.random() * (numberOfNames - 1));

            String chosenMessage = messageScanner.nextLine();
            String chosenName = nameScanner.nextLine();

            for (int i = 0; i < messageToDisplay; i++) {
                chosenMessage = messageScanner.nextLine();
            }
            for (int i = 0; i < nameToDisplay; i++) {
                chosenName = nameScanner.nextLine();
            }

            finalMessage = chosenMessage + ", " + chosenName + ". ";
        } catch (FileNotFoundException e) {
            finalMessage = "Done. ";
        } finally {
            return finalMessage;
        }
    }
}
