/*
 * Copyright 2026 Google LLC
 *
 * Redistribution and use in source and binary forms, with or without
 * modification, are permitted provided that the following conditions are
 * met:
 *
 *     * Redistributions of source code must retain the above copyright
 * notice, this list of conditions and the following disclaimer.
 *     * Redistributions in binary form must reproduce the above
 * copyright notice, this list of conditions and the following disclaimer
 * in the documentation and/or other materials provided with the
 * distribution.
 *     * Neither the name of Google LLC nor the names of its
 * contributors may be used to endorse or promote products derived from
 * this software without specific prior written permission.
 *
 * THIS SOFTWARE IS PROVIDED BY THE COPYRIGHT HOLDERS AND CONTRIBUTORS
 * "AS IS" AND ANY EXPRESS OR IMPLIED WARRANTIES, INCLUDING, BUT NOT
 * LIMITED TO, THE IMPLIED WARRANTIES OF MERCHANTABILITY AND FITNESS FOR
 * A PARTICULAR PURPOSE ARE DISCLAIMED. IN NO EVENT SHALL THE COPYRIGHT
 * OWNER OR CONTRIBUTORS BE LIABLE FOR ANY DIRECT, INDIRECT, INCIDENTAL,
 * SPECIAL, EXEMPLARY, OR CONSEQUENTIAL DAMAGES (INCLUDING, BUT NOT
 * LIMITED TO, PROCUREMENT OF SUBSTITUTE GOODS OR SERVICES; LOSS OF USE,
 * DATA, OR PROFITS; OR BUSINESS INTERRUPTION) HOWEVER CAUSED AND ON ANY
 * THEORY OF LIABILITY, WHETHER IN CONTRACT, STRICT LIABILITY, OR TORT
 * (INCLUDING NEGLIGENCE OR OTHERWISE) ARISING IN ANY WAY OUT OF THE USE
 * OF THIS SOFTWARE, EVEN IF ADVISED OF THE POSSIBILITY OF SUCH DAMAGE.
 */

package com.google.api.gax.httpjson;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.fail;

import com.google.api.gax.core.NoCredentialsProvider;
import com.google.cloud.translate.v3.LocationName;
import com.google.cloud.translate.v3.TranslationServiceClient;
import com.google.cloud.translate.v3.TranslationServiceSettings;
import java.io.InputStream;
import java.security.Provider;
import java.security.Security;
import java.util.Collections;
import java.util.TreeSet;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

public abstract class PqcConnectivityTest {

  private static Process serverProcess;
  protected static int grpcPqcPort;
  protected static int grpcClassicalPort;

  protected boolean clientSupportsPqc() {
    return true;
  }

  protected abstract boolean grpcTestShouldSucceed();

  @BeforeAll
  public static void setup() throws Exception {

    // 6. Spawn PqcTestServer in a separate background process to ensure physical
    // JVM runtime isolation!
    ProcessBuilder pb =
        new ProcessBuilder(
            "java",
            "-cp",
            System.getProperty("java.class.path"),
            "com.google.api.gax.pqc.PqcTestServer");

    // Force merging of error stream to ease debugging in test output
    pb.redirectErrorStream(true);
    serverProcess = pb.start();

    // Read server's stdout to dynamically capture the allocated ephemeral ports
    java.io.BufferedReader reader =
        new java.io.BufferedReader(
            new java.io.InputStreamReader(
                serverProcess.getInputStream(), java.nio.charset.StandardCharsets.UTF_8));

    String line;
    boolean grpcPqcFound = false;
    boolean grpcClassicalFound = false;

    // Wait for the server process to output its HTTP and gRPC ports
    long startTime = System.currentTimeMillis();
    while ((line = reader.readLine()) != null) {
      System.out.println("[SERVER-OUT] " + line);
      if (line.startsWith("GRPC_PQC_PORT: ")) {
        grpcPqcPort = Integer.parseInt(line.substring(15).trim());
        grpcPqcFound = true;
      } else if (line.startsWith("GRPC_CLASSICAL_PORT: ")) {
        grpcClassicalPort = Integer.parseInt(line.substring(21).trim());
        grpcClassicalFound = true;
      }

      if (grpcPqcFound && grpcClassicalFound) {
        break;
      }

      // Ephemeral port detection timeout (10 seconds) to fail-fast on server startup
      // errors
      if (System.currentTimeMillis() - startTime > 10000) {
        throw new RuntimeException(
            "Timeout waiting for PqcTestServer ephemeral ports to be printed!");
      }
    }

    if (!grpcPqcFound || !grpcClassicalFound) {
      throw new RuntimeException("PqcTestServer failed to initialize ephemeral ports!");
    }

    // Start a background thread to continuously drain the server's stdout
    Thread drainThread =
        new Thread(
            () -> {
              try {
                String l;
                while ((l = reader.readLine()) != null) {
                  System.out.println("[SERVER-OUT] " + l);
                }
              } catch (java.io.IOException e) {
                // Ignore stream closed
              }
            });
    drainThread.setDaemon(true);
    drainThread.start();
  }

  @AfterAll
  public static void teardown() {
    if (serverProcess != null) {
      // Forcibly destroy the background process and close standard streams to allow
      // clean exit
      serverProcess.destroyForcibly();
    }
  }

  private void runGrpcTest(int port, boolean shouldSucceed) throws Exception {
    TranslationServiceSettings settings =
        TranslationServiceSettings.newBuilder()
            .setEndpoint("localhost:" + port)
            .setCredentialsProvider(NoCredentialsProvider.create())
            .build();

    try (TranslationServiceClient client = TranslationServiceClient.create(settings)) {
      LocationName parent = LocationName.of("test-project", "global");
      client.translateText(parent, "es", Collections.singletonList("hello"));
      if (!shouldSucceed) {
        fail("Expected gRPC call to fail!");
      }
    } catch (Exception e) {
      if (shouldSucceed) {
        fail("Expected gRPC call to succeed, but failed: " + e.getMessage(), e);
      }
    }
  }



  @Test
  public void testGrpcPqcServerEnforced() throws Exception {
    runGrpcTest(grpcPqcPort, grpcTestShouldSucceed());
  }

  @Test
  public void testGrpcClassicalServer() throws Exception {
    runGrpcTest(grpcClassicalPort, true);
  }
}
