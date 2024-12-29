/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.develcode.develcode;

/**
 *
 * @author felly
 */

import java.io.IOException;

public class NodeStarter {

    public void startNodeServer() {
        try {
            String currentDirectory = System.getProperty("user.dir");
            System.out.println("teste "+currentDirectory);
            // Executa o script start-node.sh
            ProcessBuilder processBuilder = new ProcessBuilder(currentDirectory+"/start-node.bat");
            processBuilder.start();
            System.out.println("Node server started successfully!");
        } catch (IOException e) {
            e.printStackTrace();
            System.err.println("Failed to start Node server");
        }
    }
}
