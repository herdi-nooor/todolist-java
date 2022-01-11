

public class Apktodolist {
    public static String[] model = new String[10];
    public static java.util.Scanner scan = new java.util.Scanner(System.in);

    public static void main(String[] args) {
        viewShowTodoList();
//        testviewTodoList();
//        testAddTodoList();
//        testRemoveTodoList();
//        testInput();
    }

//    menanpilkan todo list
    public static void showTodoList() {
        for (var i = 0; i < model.length; i++){
            var todo = model[i];
            var no = i + 1;
            if (todo != null){
                System.out.println(no + ". " + todo );
            }
        }
    }
    public static void testShowTodoList(){
        model[0]= "belajar a12";
        model[1] = "belajar b13";
        model[2] = "belajar bc14";
        model[3] = "belajar b315";
        showTodoList();
    }

//    menambah todo list
    public static void addTodoList(String todo){
//        cek penuh atau tidak
        var penuh = true;
        for (int i = 0; i < model.length; i++){
            if (model[i] == null){
                penuh = false;
                break;
            }
        }
//        jika data penuh
        if(penuh){
            var temp = model;
//            melipat gandakan ukuran array dan memindahkan data
            model = new String[model.length + 10];
            for (int i = 0; i < temp.length; i++){
                model[i] = temp[i];
            }
        }
//        tambahkan ke posisi yang data array nya null
        for (var i = 0; i < model.length; i++){
            if (model[i] == null){
                model[i] = todo;
                break;
            }
        }
    }
    public static void testAddTodoList(){
        for (int i = 0; i < 32; i++){
            if (i < 9 ){
                addTodoList("\t\tini yang ke " + (i + 1 ) );
            }else {
                addTodoList("\tini yang ke " + (i + 1 ) );
            }
        }
        showTodoList();
    }

//    menghapus todo list
    public static boolean removeTodoList(Integer number){
        number--;
        if (number>= model.length){
            System.out.println("\t----------------------------------------\n\t| index yang diberikan melebihi jumlah | \n\t| penampungan data yang ada \t\t   |\n\t----------------------------------------\n");
            return false;
        }else if (model[number] == null){
            System.out.println("\t----------------------------\n\t|tidak ada data di index " + (number+1) + " |\n\t----------------------------\n");
            return false;
        }else{
         for (int i = number; i < model.length; i++){
             if (i == (model.length -1)){
                 model[i] = null;
             }else {
                 model[i] = model[i + 1];
             }
         }
         return true;
        }
    }

    public static void testRemoveTodoList(){
        for (int i = 0; i < 8; i++){
            addTodoList("ini yang ke " + (i + 1));
        }
        var result = removeTodoList(12);
        System.out.println(result);
        result = removeTodoList(10);
        System.out.println(result);
        result = removeTodoList(4);
        System.out.println(result);

        showTodoList();
    }

//    view todo list

//    method input data
    public static String input(String info){
        System.out.print(info + " : ");
        String data = scan.nextLine();
        return data;
    }

    public static void testInput(){
        String nama = input("Nama");
        String hari = input("sekarang hari apa");

        System.out.println(nama);
        System.out.println("sekarang hari " + hari);
    }
//    menampilkan view todo list
    public static void viewShowTodoList(){
        label:
        while (true) {
            System.out.println("TODO LIST");
            showTodoList();
            System.out.println("Menu : ");
            System.out.println("\t( 1 )-> tambah");
            System.out.println("\t( 2 )-> hapus");
            System.out.println("\t( x )-> keluar");
            var input = input("Pilih");
            switch (input) {
                case "1":
                    viewAddTodoList();
                    break;
                case "2":
                    viewRemovedTodolist();
                    break;
                case "x":
                    break label;
                default:
                    System.out.println(" pilihan tidak di mengwerti ");
                    break;
            }
        }
    }

    public static void testviewTodoList(){
        for (int i = 0; i < 8; i++){
            addTodoList("ini yang ke " + (i + 1));
        }
        viewShowTodoList();
    }

//    menampilkan view menambah todo list
    public static void viewAddTodoList(){
        System.out.println("MENAMBAH DATA");
        var todo = input("ketikan ( x ) untuk batal");
        if (todo.equals("x")){
            System.out.println("anda membatalkanya");
            input("enter untuk lanjut");
        }else{
            addTodoList(todo);
        }
    }

//    menampilkan view menghapus todo list
    public static void viewRemovedTodolist(){
        System.out.println("MENGHAPUS DATA");
        var index = input("masukan index data yang akan di hapus \n" +
                "ketikan ( x ) untuk batal \n\t");
        if (index.equals("x")) {
        } else {
            boolean succes = removeTodoList(Integer.valueOf(index));
            if (!succes){
                System.out.println("gagal menghapus data index ke : " + index );
                input("enter untuk lanjut");
            }
        }

    }
}
