package com.mongeat.launch;

import io.quarkus.runtime.Quarkus;
import io.quarkus.runtime.annotations.QuarkusMain;

/**
 * Main
 */
@QuarkusMain
public class Main {

    /**
     * Main method
     * @param args Arguments
     */
    public static void main(String args[]) {
        Quarkus.run(args);
    }
}
