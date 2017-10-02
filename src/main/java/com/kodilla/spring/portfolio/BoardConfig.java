package com.kodilla.spring.portfolio;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class BoardConfig {

    @Bean
    public TaskList createToDoList() {
        return new TaskList();
    }

    @Bean
    public TaskList createInProgressList() {
        return new TaskList();
    }

    @Bean
    public TaskList createDoneList() {
        return new TaskList();
    }

    @Bean
    public Board createBoard() {
        ApplicationContext context =
                new AnnotationConfigApplicationContext("com.kodilla.spring");

        TaskList toDoList = (TaskList) context.getBean("createToDoList");
        TaskList inProgressList = (TaskList) context.getBean("createInProgressList");
        TaskList doneList = (TaskList) context.getBean("createDoneList");

        return new Board(toDoList, inProgressList, doneList);
    }

}
