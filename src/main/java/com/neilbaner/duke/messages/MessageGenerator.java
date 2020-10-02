package com.neilbaner.duke.messages;

import java.io.*;
import java.util.Scanner;

/**
 * @author Neil Banerjee
 * @version 1.0
 * A collection of methods to randomly generate messages for the Duke UI.
 */
public class MessageGenerator {
    /**
     * Generates a random confirmation message, comprised of one randomly chosen affirmative phrase followed by
     * another randomly chosen name to address the user as.
     * @return the generated message.
     */
    public static String generateConfirmationMessage() {
        ClassLoader classLoader = MessageGenerator.class.getClassLoader();
        // Create two InputStreams for the two parts of the message, from the resources in /src/main/resources
        InputStream confirmationsInputStream = classLoader.getResourceAsStream("txt/confirmationmessages");
        InputStream namesInputStream = classLoader.getResourceAsStream("txt/names");
        String finalMessage = "";
        try {

            BufferedReader confirmationsReader = new BufferedReader(new InputStreamReader(confirmationsInputStream));
            BufferedReader namesReader = new BufferedReader(new InputStreamReader(namesInputStream));

            int numberOfMessages = Integer.parseInt(confirmationsReader.readLine());
            int numberOfNames = Integer.parseInt(namesReader.readLine());

            int messageToDisplay = (int) (Math.random() * (numberOfMessages - 1));
            int nameToDisplay = (int) (Math.random() * (numberOfNames - 1));

            String chosenMessage = confirmationsReader.readLine();
            String chosenName = namesReader.readLine();

            // iterate a random number of times to get to a random line in the file.
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
