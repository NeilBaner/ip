package com.neilbaner.duke.serialize;

import com.neilbaner.duke.exceptions.DeserializerException;
import com.neilbaner.duke.task.Deadline;
import com.neilbaner.duke.task.Event;
import com.neilbaner.duke.task.Task;
import com.neilbaner.duke.task.ToDo;

import java.lang.reflect.Type;

public class Serializer {

    public static String serializeTask(Task t) {
        Type taskType = t.getClass();
        String serialized = "";
        if (taskType == ToDo.class) {
            serialized += "T|";
        } else if (taskType == Event.class) {
            serialized += "E|";
            serialized += ((Event) t).getEventTime() + "|";
        } else if (taskType == Deadline.class) {
            serialized += "D|";
            serialized += ((Deadline) t).getDueDate() + "|";
        }
        serialized += t.getTitle() + "|";
        serialized += (t.getDone()) ? "Y" : "N";
        return serialized;
    }

    public static Task deserializeTask(String s) throws DeserializerException {
        String parts[];
        Task deserialized;
        parts = s.split("|");
        if (parts[0].equals("T")) {
            deserialized = new ToDo(parts[1]);
            if (parts[2].equals("Y")) {
                deserialized.setDone();
            }
        } else if (parts[0].equals("E")) {
            deserialized = new Event(parts[2], parts[1]);
            if (parts[3].equals("Y")) {
                deserialized.setDone();
            }
        } else if (parts[0].equals("D")) {
            deserialized = new Deadline(parts[2], parts[1]);
            if (parts[3].equals("Y")) {
                deserialized.setDone();
            }
        } else {
            throw new DeserializerException();
        }
        return deserialized;
    }
}
