package test.service;

import entity.Todolist;
import repository.TodoListRepository;
import repository.TodoListRepositoryImpl;
import service.TodoListService;
import service.TodoListServiceImpl;

public class TodoListServiceTest {

    public static void main(String[] args) {
        testRemoveTodoList();

    }

    public static void testShowTodoList(){
        TodoListRepositoryImpl todoListRepository = new TodoListRepositoryImpl();
        todoListRepository.data[0] = new Todolist("Belajar Java Dasar");
        todoListRepository.data[1] = new Todolist("belajar Java OOP");
        todoListRepository.data[2] = new Todolist("Belajar Java Database");
        TodoListService todoListService = new TodoListServiceImpl(todoListRepository);

        todoListService.showTodolist();
    }
    public static void testAddTodoList(){
        TodoListRepository todoListRepository = new TodoListRepositoryImpl();
        TodoListService todoListService = new TodoListServiceImpl(todoListRepository);

        todoListService.addTodolist("Belajar Java Dasar");
        todoListService.addTodolist("Belajar Java OOP");
        todoListService.addTodolist("Belajar Java Database");

        todoListService.showTodolist();

    }

    public static void testRemoveTodoList(){
        TodoListRepository todoListRepository = new TodoListRepositoryImpl();
        TodoListService todoListService = new TodoListServiceImpl(todoListRepository);

        todoListService.addTodolist("Belajar Java Dasar");
        todoListService.addTodolist("Belajar Java OOP");
        todoListService.addTodolist("Belajar Java Database");

        todoListService.showTodolist();

        todoListService.removeTodolist(5);
        todoListService.removeTodolist(2);
        todoListService.showTodolist();
        todoListService.removeTodolist(2);
        todoListService.showTodolist();
        todoListService.removeTodolist(2);
        todoListService.showTodolist();
        todoListService.removeTodolist(1);
        todoListService.showTodolist();

    }
}
