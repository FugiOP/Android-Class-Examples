package com.sargent.mark.todolist.data;

/**
 * Created by mark on 7/4/17.
 */

public class ToDoItem {
    private String description;
    private String dueDate;
    private String status;
    private String category;

    public ToDoItem(String description, String dueDate, String status, String category) {
        this.description = description;
        this.dueDate = dueDate;
        this.status = status;
        this.category = category;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getDueDate() {
        return dueDate;
    }

    public void setDueDate(String dueDate) {
        this.dueDate = dueDate;
    }

    public String getStatus(){return status;}

    public void setStatus(String status){this.status = status;}

    public String getCategory(){return category;}

    public void setCategory(String category){this.category = category;}
}
