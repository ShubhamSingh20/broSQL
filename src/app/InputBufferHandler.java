package app;

import java.util.Scanner;

class InputBuffer {
    public StringBuilder buffer;

    InputBuffer() {
        this.buffer = new StringBuilder();
    }

    public void add(String str) {
        this.buffer.append(str);
    }

    public void delete() {
        this.buffer.setLength(0);
    }

    public String getString() {
        return this.buffer.toString();
    }
    
    public boolean compareCommand(String command) {
        return this.getString().equals(command);
    }

}

class InputBufferHandler {
    private InputBuffer inputBuffer;
    private Scanner scanner;

    InputBufferHandler() {
        this.scanner = new Scanner(System.in);
    }

    // This must be called first
    public void createNewInputBuffer() {
        this.inputBuffer = new InputBuffer();
    }

    public boolean isQuitCommand() {
        return this.inputBuffer.compareCommand(".q");
    }

    public void closeInputBuffer() {
        this.inputBuffer.delete();
        this.inputBuffer = null;
    }

    public void consoleOutput() {
        System.out.println(this.inputBuffer.getString());
    }

    public void consoleInput() {
        String consoleInput = scanner.nextLine();
        this.inputBuffer.buffer.append(consoleInput);
    }

}