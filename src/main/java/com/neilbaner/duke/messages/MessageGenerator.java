package com.neilbaner.duke.messages;

import java.io.*;
import java.util.Scanner;

public class MessageGenerator {
    public static String generateConfirmationMessage() {
        ClassLoader classLoader = MessageGenerator.class.getClassLoader();
        InputStream confirmationsInputStream = classLoader.getResourceAsStream("txt/confirmationmessages");
        InputStream namessInputStream = classLoader.getResourceAsStream("txt/names");
        String finalMessage = "";
        try {

            BufferedReader confirmationsReader = new BufferedReader(new InputStreamReader(confirmationsInputStream));
            BufferedReader namesReader = new BufferedReader(new InputStreamReader(namessInputStream));

            int numberOfMessages = Integer.parseInt(confirmationsReader.readLine());
            int numberOfNames = Integer.parseInt(namesReader.readLine());

            int messageToDisplay = (int) (Math.random() * (numberOfMessages - 1));
            int nameToDisplay = (int) (Math.random() * (numberOfNames - 1));

            String chosenMessage = confirmationsReader.readLine();
            String chosenName = namesReader.readLine();

            for (int i = 0; i < messageToDisplay; i++) {
                chosenMessage = confirmationsReader.readLine();
            }
            for (int i = 0; i < nameToDisplay; i++) {
                chosenName = namesReader.readLine();
            }

            finalMessage = chosenMessage + ", " + chosenName + ". ";
        } catch (FileNotFoundException e) {
            finalMessage = "Done. ";
        } finally {
            return finalMessage;
        }
    }
}
