import java.util.Scanner;

public class AplikasiTodolist {

    public static String[] model = new String[15];

    public static java.util.Scanner scanner = new java.util.Scanner(System.in);

    public static void main(String[] args) {
      viewShowTodolist();

    }

    /**
     * menampilkan todo list
     */

    public static void showTodolist (){
        System.out.println("Todo List");
      for (var i = 0; i < model.length; i++){
          var todo = model[i];
          var no = i + 1;

          if (todo != null ){
              System.out.println(no + ". " + todo);
          }
      }

    }

    public static void testShowTodolist(){
        model[0] = "Belajar Java Dasar";
        model[1] = "Java Dasa";
        model[2] = "Stadi Kasus Java Dasar";

        showTodolist();
    }

    /**
     * menambhakan todo ke list
     */

    public static void addTodolist (String todo){
        // cek apakah model penuh?
        var isFull = true;
        for (int i = 0; i < model.length; i++) {
            if (model [i] == null){
                // model masih ada yang kosong
                isFull = false;
                break;
            }
        }

        // jika penuh, kita resize ukuran aray 2x lipat
        if (isFull){
            var temp = model;
            model = new String[model.length * 2];

            for (int i =0; i < temp.length; i++){
                model[i] = temp[i];
            }
        }


        // tambahkan ke posisi yang data array nya NULL

        for (var  i = 0; i < model.length; i++){
            if (model [i] == null){
                model[i] = todo;
                break;
            }
        }

    }

    public static void testAddTodoList (){
        for (int i = 0; i < 25; i++){
            addTodolist("contoh todo list ke. " + i);
        }

        showTodolist();
    }

    /**
     * mengahapus todo dari list
     */

    public static boolean removeTodolist (Integer number){
        if ((number - 1) >= model.length){
            return false;
        } else if (model[number - 1] == null){
            return false;
        } else {
            for (int i = (number - 1); i < model.length; i++){
                if (i == (model.length - 1)){
                    model[i] = null;
                } else {
                    model[i] = model[i + 1];
                }
            }
            return true;
        }
    }

    public static void testRemoveTodoList(){

        addTodolist("Satu");
        addTodolist("Dua");
        addTodolist("Tiga");
        addTodolist("Empat");
        addTodolist("Lima");

        var result =removeTodolist(20);
        System.out.println(result);

        result =removeTodolist(8);
        System.out.println(result);

        result =removeTodolist(2);
        System.out.println(result);

        showTodolist();
    }

    public static String input(String info){
        System.out.print(info + " : ");
       String data = scanner.nextLine();
       return data;
    }

    public static void testInput(){
        var name = input("Nama");
        System.out.println("Hi " + name);

        var channel = input("Channel");
        System.out.println(channel);
    }

    /**
     * menampilkan  view todo list
     */

    public static void viewShowTodolist() {
        while (true) {
            showTodolist();

            System.out.println("MENU : ");
            System.out.println("1. Tambah");
            System.out.println("2. Hapus");
            System.out.println("X. Keluar");

            var input = input("Pilih");
            if (input.equals("1")) {
                viewAddTodolist();
            } else if (input.equals("2")) {
                viewRemoveTodolist();
            } else if (input.equals("x")) {
                break;
            } else {
                System.out.println("Pilihan tidak dimengerti");
            }
        }
    }

    public static void testViewShowTodoList() {
        addTodolist("Satu");
        addTodolist("Dua");
        addTodolist("Tiga");
        addTodolist("Empat");
        addTodolist("Lima1");

        viewShowTodolist();
    }

    /**
     * menampilkan view menambahkan todo list
     */

    public static void viewAddTodolist (){
        System.out.println("MENAMBAH TODOLIST");

        var todo = input("todo (x jika batal)") ;
        if (todo.equals("x")) {
            // batal
        } else {
            addTodolist(todo);
        }
    }

    public static void testViewAddTodoList() {
       addTodolist("satu");
       addTodolist("dua");

        viewShowTodolist();

        showTodolist();
    }

    /**
     * menampilkan view menghapus todo list
     */

    public static void viewRemoveTodolist(){
        System.out.println("MENGHAPUS TODOLIST");
        var number = input("Nomor yang Dihapus (x jika batal)") ;
        if (number.equals("x")){
            // batal
        } else {
           boolean success = removeTodolist(Integer.valueOf(number));
           if (!success) {
               System.out.println("Gagal Menghapus todolist : " + number);
           }
        }
    }

    public static void testViewRemoveTodolist() {
        addTodolist("satu");
        addTodolist("dua");
        addTodolist("tiga");

        showTodolist();

        viewRemoveTodolist();

        viewShowTodolist();
    }
}


