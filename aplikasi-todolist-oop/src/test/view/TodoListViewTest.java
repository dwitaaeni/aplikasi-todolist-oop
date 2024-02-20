package test.view;

import repository.TodoListRepository;
import repository.TodoListRepositoryImpl;
import service.TodoListService;
import service.TodoListServiceImpl;
import view.TodoListView;

public class TodoListViewTest {

    public static void main(String[] args) {
        testRemoveTodoList();
    }

    public static void testShowTodoList (){
        TodoListRepository todoListRepository = new TodoListRepositoryImpl();
        TodoListService todoListService = new TodoListServiceImpl(todoListRepository);
        TodoListView todoListView = new TodoListView(todoListService);

        todoListService.addTodolist("Belajar Java Dasar");
        todoListService.addTodolist("Belajar Java OOP");
        todoListService.addTodolist("Belajar Java Database");

        todoListView.showTodolist();

    }

    public static void testAddTodoList (){
        TodoListRepository todoListRepository = new TodoListRepositoryImpl();
        TodoListService todoListService = new TodoListServiceImpl(todoListRepository);
        TodoListView todoListView = new TodoListView(todoListService);

        todoListView.addTodolist();

        todoListService.showTodolist();

        todoListView.addTodolist();

        todoListService.showTodolist();

    }

    public static void testRemoveTodoList (){
        TodoListRepository todoListRepository = new TodoListRepositoryImpl();
        TodoListService todoListService = new TodoListServiceImpl(todoListRepository);
        TodoListView todoListView = new TodoListView(todoListService);

        todoListService.addTodolist("Belajar Java Dasar");
        todoListService.addTodolist("Belajar Java OOP");
        todoListService.addTodolist("Belajar Java Database");

        todoListService.showTodolist();

        todoListView.removeTodolist();

        todoListService.showTodolist();

    }
}
