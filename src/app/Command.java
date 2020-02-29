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

}