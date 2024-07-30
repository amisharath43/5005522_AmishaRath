class Task {
    int taskId;
    String taskName;
    String status;

    public Task(int taskId, String taskName, String status) {
        this.taskId = taskId;
        this.taskName = taskName;
        this.status = status;
    }
}

class Node {
    Task task;
    Node next;

    public Node(Task task) {
        this.task = task;
        this.next = null;
    }
}

public class SinglyLinkedList { 
    private Node head;

    public void addTask(Task task) {
        Node newNode = new Node(task);
        newNode.next = head;
        head = newNode;
    }

    public Task searchTask(int taskId) {
        Node current = head;
        while (current != null) {
            if (current.task.taskId == taskId) {
                return current.task;
            }
            current = current.next;
        }
        return null;
    }

    public void traverseTasks() {
        Node current = head;
        while (current != null) {
            System.out.println(current.task.taskName);
            current = current.next;
        }
    }

    public void deleteTask(int taskId) {
        Node current = head;
        Node prev = null;
        while (current != null) {
            if (current.task.taskId == taskId) {
                if (prev != null) {
                    prev.next = current.next;
                } else {
                    head = current.next;
                }
                return;
            }
            prev = current;
            current = current.next;
        }
    }

    public static void main(String[] args) {
        SinglyLinkedList taskList = new SinglyLinkedList();
        Task task1 = new Task(1, "Task 1", "Pending");
        Task task2 = new Task(2, "Task 2", "Completed");

        taskList.addTask(task1);
        taskList.addTask(task2);
        taskList.traverseTasks();
        taskList.deleteTask(1);
    }
}
