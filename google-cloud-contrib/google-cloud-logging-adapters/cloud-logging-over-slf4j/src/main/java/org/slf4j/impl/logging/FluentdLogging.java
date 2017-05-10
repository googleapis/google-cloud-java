/*
 * Copyright 2017 Google Inc. All Rights Reserved.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *       http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package org.slf4j.impl.logging;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.google.cloud.logging.LogEntry;
import java.io.IOException;
import java.net.Socket;
import java.util.List;

public class FluentdLogging implements ILogging {

  private static final String DEFAULT_HOST_NAME = "localhost";
  private static int DEFAULT_PORT = 24224;
  private final String hostName;
  private final int port;
  private Socket socket;
  private ObjectMapper objectMapper;

  public FluentdLogging() {
    this.hostName = DEFAULT_HOST_NAME;
    this.port = DEFAULT_PORT;
  }

  public void init() {
    try {
      socket = new Socket(hostName, port);
    } catch (IOException e) {
      System.err.println("Error opening port : " + e.getMessage());
    }
    Runtime.getRuntime().addShutdownHook(new ShutdownService(socket));
  }

  public void write(List<LogEntry> logEntries) {
    try {
      String log = objectMapper.writeValueAsString(logEntries);
      socket.getOutputStream().write(log.getBytes());
    } catch (JsonProcessingException e) {
      System.err.println("Error processing json :  " + e.getMessage());
    } catch (IOException e) {
      System.err.println("Error connecting to socket :  " + e.getMessage());
      System.out.println("Reconnecting...");
      init();
    }
  }

  class ShutdownService extends Thread {

    Socket socket;

    ShutdownService(Socket socket) {
      this.socket = socket;
    }

    @Override
    public void run() {
      try {
        socket.close();
      } catch (Exception e) {
        System.err.println("Error closing cloud logger : " + e.getMessage());
      }
    }
  }
}
