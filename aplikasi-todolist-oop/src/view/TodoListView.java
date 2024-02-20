package view;

import service.TodoListService;
import util.InputUtil;

public class TodoListView {

    private TodoListService todoListService;

    public TodoListView(TodoListService todoListService) {
        this.todoListService = todoListService;
    }

    public void showTodolist(){
        while (true) {
            todoListService.showTodolist();

            System.out.println("MENU : ");
            System.out.println("1. Tambah");
            System.out.println("2. Hapus");
            System.out.println("X. Keluar");

            var input = InputUtil.input("Pilih");
            if (input.equals("1")) {
                addTodolist();
            } else if (input.equals("2")) {
                removeTodolist();
            } else if (input.equals("x")) {
                break;
            } else {
                System.out.println("Pilihan tidak dimengerti");
            }
        }
    }

    public void addTodolist(){
        System.out.println("MENAMBAH TODOLIST");

        var todo = InputUtil.input("todo (x jika batal)") ;
        if (todo.equals("x")) {
            // batal
        } else {
            todoListService.addTodolist(todo);
        }
    }

    public void removeTodolist(){
        System.out.println("MENGHAPUS TODOLIST");
        var number = InputUtil.input("Nomor yang Dihapus (x jika batal)") ;
        if (number.equals("x")){
            // batal
        } else {
            todoListService.removeTodolist(Integer.valueOf(number));
        }
    }

}
