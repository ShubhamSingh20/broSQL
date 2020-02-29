package app;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;
import java.util.List;


class Command {
    final String UNRECOGNIZED = "X";
    final String META_STATEMENT = "META";
    final String PREPARED_STATEMENT = "PREP";
    
    final List<String> metaCommandList = Arrays.asList(
        ".q"
    );

    final List<String> preparedStatementList = Arrays.asList(
        "set", "get"
    );

    final Set<String> metaCommandHashSet = new HashSet<>(metaCommandList);
    final Set<String> preparedStatementHashSet = new HashSet<>(preparedStatementList);
    
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
}