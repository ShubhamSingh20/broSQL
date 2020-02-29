package app;

import java.util.Scanner;
import java.util.List;
import java.util.Arrays;

class InputBuffer {
    public StringBuilder buffer;
    public List<String> bufferFragment;
    public String STATEMENT_TYPE;

    InputBuffer() {
        this.buffer = new StringBuilder();
    }

    public void setBufferFragment() {
        this.bufferFragment = Arrays.asList(
            this.buffer.toString().trim().split(" ")
        );
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

    public String firstCommand() {
        return this.bufferFragment.get(0);
    }

}

class InputBufferHandler {
    private InputBuffer inputBuffer;
    private Scanner scanner;
    private Statement statement;

    InputBufferHandler() {
        this.scanner = new Scanner(System.in);
        this.statement = new Statement();
    }

    // This must be called first
    public void createNewInputBuffer() {
        this.inputBuffer = new InputBuffer();
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
        this.inputBuffer.setBufferFragment();
    }

    private void setStatementType() {
        String firstCommand = this.inputBuffer.firstCommand();
        this.inputBuffer.STATEMENT_TYPE = statement.getStatementType(firstCommand);
    }

    public void parseStatement(){
        this.setStatementType();
        this.statement.executeStatement(
            this.inputBuffer.getString(), this.inputBuffer.STATEMENT_TYPE
        );
    }

}