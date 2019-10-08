/*
 * Copyright 2019 Google LLC
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

package com.google.cloud.benchwrapper;

import java.util.Properties;
import io.grpc.Server;
import io.grpc.netty.NettyServerBuilder;

class Main {
  public static void main(String[] args) throws Exception {
    Properties properties = new Properties(System.getProperties());
    String port = properties.getProperty("port");
    if (port == null || port.equals("")) {
      System.err.println("Usage: mvn clean install exec:java -DskipTests=true -Dport=8081");
      System.exit(1);
    }

    String pubsubEmulatorHost = System.getenv("PUBSUB_EMULATOR_HOST");
    if (pubsubEmulatorHost == null || pubsubEmulatorHost.equals("")) {
      // We could use system properties here too, but every other language uses
      // an environment variable called PUBSUB_EMULATOR_HOST, so the
      // consistency is nice to maintain.
      System.err.println("Please set PUBSUB_EMULATOR_HOST=localhost:8080");
      System.exit(1);
    }

    System.out.println("Server starting up...");

    int portInt = Integer.parseInt(port);
    final Server server = NettyServerBuilder
      .forPort(portInt)
      .addService(new PubsubBenchWrapperImpl(pubsubEmulatorHost))
      .build()
      .start();

    System.out.println("Server starting up... done. Listening on " + port);
    Runtime.getRuntime().addShutdownHook(new Thread() {
      @Override
      public void run() {
        // Use stderr here since the logger may have been reset by its JVM shutdown hook.
        System.err.println("Shutting down gRPC server since JVM is shutting down");
        server.shutdown();
      }
    });

    server.awaitTermination();
  }
}

