package app;

class Statement extends Command{
    public boolean isMetaStatement(String command) {
        return metaCommandHashSet.contains(command);
    }

    public boolean isPreparedStatement(String command) {
        return preparedStatementHashSet.contains(command);
    }

    public String getStatementType(String command) {
        if (this.isMetaStatement(command)) {
            return this.META_STATEMENT;
        }

        if (this.isPreparedStatement(command)) {
            return this.PREPARED_STATEMENT;
        }
        return this.UNRECOGNIZED;
    }

    public void executeStatement(String statement, String STATEMENT_TYPE){
        switch (STATEMENT_TYPE) {
            case PREPARED_STATEMENT:
                System.out.println("prepared statement");
                break;
            
            case META_STATEMENT:
                System.out.println("meta statement");
                break;
        
            default:
                System.out.println("unknown");
                break;
        }
    }

}