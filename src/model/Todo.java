package model;

public class Todo {
    int count;
    String todo;

    public Todo() {

    }

    @Override
    public String toString() {
        return "Todo{" +
                "count=" + count +
                ", todo='" + todo + '\'' +
                '}';
    }

    public Todo(int count, String todo) {
        this.count = count;
        this.todo = todo;
    }

    public int getId() {
        return count;
    }
    public void setId(int id)  {
        this.count = id;
    }
    public String getTask() {
        return todo;
    }
    public void setTask(String task)  {
        this.todo = task;
    }
}