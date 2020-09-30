package com.neilbaner.duke.files;

import com.neilbaner.duke.exceptions.DeserializerException;
import com.neilbaner.duke.exceptions.FileSavingException;
import com.neilbaner.duke.exceptions.NoSaveFileException;
import com.neilbaner.duke.serialize.Serializer;
import com.neilbaner.duke.task.Task;
import com.neilbaner.duke.task.TaskList;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

/**
 * This class is used for file storage operations to save and load Duke's state to and from a text file stored on the
 * disk.
 */
public class Storage {
    private final String filePath;

    /**
     * Load the state of Duke that was previously saved onto a file on the disk.
     * @param list the <code>TaskList</code> to which to copy the tasks read from the file.
     * @throws NoSaveFileException if the save file could not be found on the disk.
     * @throws DeserializerException if there is some error deserializing the text file, should only occur if the
     * save is corrupted or tampered with in some way.
     */
    public void loadState(TaskList list) throws NoSaveFileException, DeserializerException {
        File saveFile = new File(filePath);
        try {
            Scanner fs = new Scanner(saveFile);
            while (fs.hasNext()) {
                String currentLine = fs.nextLine();
                Task currentTask = Serializer.deserializeTask(currentLine);
                list.addTask(currentTask);
            }
            fs.close();
        } catch (FileNotFoundException e) {
            throw new NoSaveFileException();
        }
    }

    /**
     * Save the state of Duke to a file on the disk.
     * @param list the <code>TaskList</code> from which to read the tasks to write to the file on the disk.
     * @throws FileSavingException if there is some error writing the file to the disk.
     */
    public void saveState(TaskList list) throws FileSavingException{
        try {
            FileWriter fw = new FileWriter(filePath, false);
            fw.write(Serializer.serializeTaskList(list));
            fw.close();
        } catch (IOException e) {
            System.out.println(Serializer.serializeTaskList(list));
            throw new FileSavingException();
        }
    }

    public Storage(String filePath) {
        this.filePath = filePath;
    }
}
