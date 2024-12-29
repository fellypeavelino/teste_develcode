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
            String os = System.getProperty("os.name").toLowerCase();
            if (os.contains("win")) {
                ProcessBuilder processBuilder = new ProcessBuilder("start-node.bat");
                processBuilder.start();
            } else {
                ProcessBuilder processBuilder = new ProcessBuilder("./start-node.sh");
                processBuilder.start();
            }
            
            System.out.println("Node server started successfully!");
        } catch (IOException e) {
            e.printStackTrace();
            System.err.println("Failed to start Node server");
        }
    }
}
