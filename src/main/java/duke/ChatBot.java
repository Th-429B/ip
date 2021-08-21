package duke;

import duke.tasks.Task;
import duke.tasks.Deadline;
import duke.tasks.Event;
import duke.tasks.Todo;

import java.time.LocalDateTime;
import java.util.ArrayList;

public class ChatBot {

    public static String line = "___________________________________________________\n";
    private ArrayList<Task> tasks = new ArrayList<>();

    public String getStartMessage() {
        return line + "Hello! I'm Duke\n" + "What can I do for you?\n" + line;
    }

    public String getExitMessage() {
        return line + "bye! for now...\n" + line;
    }

    public String addTodo(String input) {
        Task t = new Todo(input);
        tasks.add(t);
        return line + "I've added this task:\n" + t +"\n" + "You have " + tasks.size() + " tasks left!\n" + line;
    }

    public String getListMessage() {
        String listMessage = "Here are your tasks... if you choose to do it...\n";

        for (int i = 0; i < tasks.size(); i++) {
            listMessage = listMessage + (i + 1) + "." + tasks.get(i).toString() + "\n";
        }
        return line + listMessage + line;
    }

    public String completeTask(int index) {
        Task complete = tasks.get(index - 1);
        complete.completeTask();

        return line + "Well done! You finally completed " + complete.getName() + "!\n" + line;
    }

    public String addDeadline(String name, LocalDateTime deadline) {
        Task t = new Deadline(name, deadline);
        tasks.add(t);
        return line + "I've added this task:\n" + t +"\n" + "You have " + tasks.size() + " tasks left!\n" + line;
    }

    public String addEvent(String name, LocalDateTime time) {
        Task t = new Event(name, time);
        tasks.add(t);
        return line + "I've added this task:\n" + t +"\n" + "You have " + tasks.size() + " tasks left!\n" + line;
    }

    public String getCommand() {
        return line + "Unknown Command!\n" + line;
    }

    public int getTotalTasks() {
        return tasks.size();
    }

    public String deleteTask(int index) {
        Task delete = tasks.get(index - 1);
        tasks.remove(index - 1);
        return line + "The task has been removed:\n" + delete +
                "\n" + "You have " + tasks.size() + " tasks left!\n" + line;
    }

}
