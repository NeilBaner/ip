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

public class Storage {
    private String filePath;

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
