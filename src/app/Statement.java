package app;

class Statement extends Command{

    public void handleMetaStatements(String statement) {
        switch (statement) {
            case ".q":
                System.exit(0);
                break;
            default:
                break;
        }
    }

    public void executeStatement(InputBuffer inputBuffer){
        switch (inputBuffer.STATEMENT_TYPE) {
            case PREPARED_STATEMENT:
                System.out.println("prepared statement");
                break;
            
            case META_STATEMENT:
                this.handleMetaStatements(inputBuffer.firstCommand());
                break;
        
            default:
                System.out.println("unknown");
                break;
        }
    }

}