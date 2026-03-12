import java.util.ArrayList;
import java.util.Scanner;

public class SmartDailyPlanner {

    static class Task {
        String date;
        String time;
        String description;
        boolean done;

        Task(String date, String time, String description) {
            this.date = date;
            this.time = time;
            this.description = description;
            this.done = false;
        }
    }

    static ArrayList<Task> tasks = new ArrayList<>();
    static Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {

        while (true) {

            System.out.println("\n===== SMART DAILY PLANNER =====");
            System.out.println("1. Add Task");
            System.out.println("2. View Tasks");
            System.out.println("3. Mark Task Completed");
            System.out.println("4. Delete Task");
            System.out.println("5. Clear All Tasks");
            System.out.println("6. Show Statistics");
            System.out.println("7. Exit");
            System.out.print("Choose option: ");

            int choice = sc.nextInt();
            sc.nextLine();

            switch (choice) {

                case 1:
                    addTask();
                    break;

                case 2:
                    showTasks();
                    break;

                case 3:
                    markCompleted();
                    break;

                case 4:
                    deleteTask();
                    break;

                case 5:
                    clearTasks();
                    break;

                case 6:
                    showStats();
                    break;

                case 7:
                    System.out.println("Exiting Planner...");
                    return;

                default:
                    System.out.println("Invalid option!");
            }
        }
    }

    static void addTask() {

        System.out.print("Enter Date (YYYY-MM-DD): ");
        String date = sc.nextLine();

        System.out.print("Enter Time (HH:MM): ");
        String time = sc.nextLine();

        System.out.print("Enter Task: ");
        String desc = sc.nextLine();

        tasks.add(new Task(date, time, desc));

        System.out.println("Task added successfully!");
    }

    static void showTasks() {

        if (tasks.isEmpty()) {
            System.out.println("No tasks available.");
            return;
        }

        System.out.println("\n----- TASK LIST -----");

        for (int i = 0; i < tasks.size(); i++) {

            Task t = tasks.get(i);

            System.out.println((i + 1) + ". "
                    + t.date + " " + t.time + " - "
                    + t.description
                    + (t.done ? " [Completed]" : ""));
        }
    }

    static void markCompleted() {

        showTasks();

        if (tasks.isEmpty()) return;

        System.out.print("Enter task number to mark completed: ");
        int num = sc.nextInt();

        if (num > 0 && num <= tasks.size()) {

            tasks.get(num - 1).done = true;

            System.out.println("Task marked as completed.");

        } else {
            System.out.println("Invalid task number.");
        }
    }

    static void deleteTask() {

        showTasks();

        if (tasks.isEmpty()) return;

        System.out.print("Enter task number to delete: ");
        int num = sc.nextInt();

        if (num > 0 && num <= tasks.size()) {

            tasks.remove(num - 1);

            System.out.println("Task deleted.");

        } else {
            System.out.println("Invalid task number.");
        }
    }

    static void clearTasks() {

        System.out.print("Delete all tasks? (yes/no): ");
        sc.nextLine();
        String confirm = sc.nextLine();

        if (confirm.equalsIgnoreCase("yes")) {

            tasks.clear();

            System.out.println("All tasks deleted.");

        } else {

            System.out.println("Cancelled.");
        }
    }

    static void showStats() {

        int completed = 0;

        for (Task t : tasks) {
            if (t.done) completed++;
        }

        System.out.println("\n----- STATISTICS -----");
        System.out.println("Total Tasks: " + tasks.size());
        System.out.println("Completed Tasks: " + completed);
    }
}
