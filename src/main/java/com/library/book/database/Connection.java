package com.library.book.database;

import ch.vorburger.exec.ManagedProcessException;
import ch.vorburger.mariadb4j.springframework.MariaDB4jSpringService;

public class Connection {

    private static MariaDB4jSpringService DB ;

    public static void buildDBConfiguration() throws ManagedProcessException {
        DB = new MariaDB4jSpringService();
        DB.setDefaultPort(6869);
        DB.start();
        DB.getDB().createDB("lib");
        DB.getDB().source("schema.sql");
    }
}

