package app;

public class App {
    public static void main(String[] args) throws Exception {
       // Main loop
       InputBufferHandler inputBufferHandler = new InputBufferHandler();

       while (true) {
           inputBufferHandler.createNewInputBuffer();
           System.out.print("db > ");
           inputBufferHandler.consoleInput();

           if (inputBufferHandler.isQuitCommand()) {
               inputBufferHandler.closeInputBuffer();
               return;
           }else{
               inputBufferHandler.consoleOutput();   
           }

       }
    }
}