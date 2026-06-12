/*
 * Copyright 2026 Google LLC
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

package com.google.cloud.bigquery.jdbc.it;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import com.google.cloud.bigquery.jdbc.utils.URIBuilder;
import com.google.common.io.CharStreams;
import com.sun.net.httpserver.HttpsConfigurator;
import com.sun.net.httpserver.HttpsParameters;
import com.sun.net.httpserver.HttpsServer;
import java.io.File;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.InetSocketAddress;
import java.nio.charset.StandardCharsets;
import java.security.KeyStore;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import javax.net.ssl.KeyManagerFactory;
import javax.net.ssl.SSLContext;
import javax.net.ssl.SSLParameters;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

public class ITLocalSslValidationTest {
  private static final String HOST = "localhost";
  private static final String PASSWORD = "changeit";
  private static final String KEYSTORE_RESOURCE = "/localhost-keystore.jks";
  private static final String TRUSTSTORE_PATH = "src/test/resources/localhost-truststore.jks";
  private static final String SUCCESS_MARKER = "SUBPROCESS_RESULT: SUCCESS";
  private static final String FAILURE_MARKER_PREFIX = "SUBPROCESS_RESULT: FAILURE - ";
  private static final String PKIX_ERROR_MSG = "PKIX path building failed";

  private static MockHttpsServer mockServer;
  private static int port;

  public static class MockHttpsServer {
    private final HttpsServer server;

    public MockHttpsServer(int port) throws Exception {
      server = HttpsServer.create(new InetSocketAddress(HOST, port), 0);
      SSLContext sslContext = SSLContext.getInstance("TLS");

      KeyStore ks = KeyStore.getInstance("JKS");
      try (InputStream stream = getClass().getResourceAsStream(KEYSTORE_RESOURCE)) {
        if (stream == null) {
          throw new IllegalStateException(
              "Keystore resource " + KEYSTORE_RESOURCE + " not found on classpath!");
        }
        ks.load(stream, PASSWORD.toCharArray());
      }

      KeyManagerFactory kmf =
          KeyManagerFactory.getInstance(KeyManagerFactory.getDefaultAlgorithm());
      kmf.init(ks, PASSWORD.toCharArray());

      sslContext.init(kmf.getKeyManagers(), null, null);

      server.setHttpsConfigurator(
          new HttpsConfigurator(sslContext) {
            @Override
            public void configure(HttpsParameters params) {
              try {
                SSLContext context = getSSLContext();
                SSLParameters sslParams = context.getDefaultSSLParameters();
                params.setSSLParameters(sslParams);
              } catch (Exception ex) {
                ex.printStackTrace();
              }
            }
          });

      server.createContext(
          "/",
          exchange -> {
            String path = exchange.getRequestURI().getPath();
            String response;
            if (path.contains("/queries")) {
              response =
                  "{\n"
                      + "  \"kind\": \"bigquery#queryResponse\",\n"
                      + "  \"jobComplete\": true,\n"
                      + "  \"rows\": [],\n"
                      + "  \"totalRows\": \"0\",\n"
                      + "  \"schema\": {\n"
                      + "    \"fields\": []\n"
                      + "  }\n"
                      + "}";
            } else {
              response =
                  "{\n"
                      + "  \"kind\": \"bigquery#job\",\n"
                      + "  \"status\": {\n"
                      + "    \"state\": \"DONE\"\n"
                      + "  },\n"
                      + "  \"jobReference\": {\n"
                      + "    \"projectId\": \"dummy\",\n"
                      + "    \"jobId\": \"dummy-job\"\n"
                      + "  },\n"
                      + "  \"configuration\": {\n"
                      + "    \"query\": {\n"
                      + "      \"query\": \"SELECT 1\"\n"
                      + "    }\n"
                      + "  },\n"
                      + "  \"statistics\": {\n"
                      + "    \"query\": {\n"
                      + "      \"statementType\": \"SELECT\"\n"
                      + "    }\n"
                      + "  }\n"
                      + "}";
            }
            exchange.getResponseHeaders().set("Content-Type", "application/json");
            exchange.sendResponseHeaders(200, response.length());
            try (OutputStream os = exchange.getResponseBody()) {
              os.write(response.getBytes());
            }
          });
    }

    public void start() {
      server.start();
    }

    public void stop() {
      server.stop(0);
    }

    public int getPort() {
      return server.getAddress().getPort();
    }
  }

  private static class ProcessResult {
    final int exitCode;
    final String stdout;

    ProcessResult(int exitCode, String stdout) {
      this.exitCode = exitCode;
      this.stdout = stdout;
    }
  }

  @BeforeAll
  public static void setUp() throws Exception {
    mockServer = new MockHttpsServer(0);
    mockServer.start();
    port = mockServer.getPort();
  }

  @AfterAll
  public static void tearDown() {
    if (mockServer == null) {
      return;
    }
    mockServer.stop();
  }

  private ProcessResult runSubprocess(String trustStore, String password) throws Exception {
    String javaHome = System.getProperty("java.home");
    String javaBin = javaHome + File.separator + "bin" + File.separator + "java";
    String classpath = System.getProperty("java.class.path");
    String className = ITLocalSslValidationTest.class.getCanonicalName();

    List<String> command = new ArrayList<>();
    command.add(javaBin);
    if (trustStore != null) {
      command.add("-Djavax.net.ssl.trustStore=" + trustStore);
    }
    if (password != null) {
      command.add("-Djavax.net.ssl.trustStorePassword=" + password);
    }
    command.add("-cp");
    command.add(classpath);
    command.add(className);
    command.add(String.valueOf(port));

    ProcessBuilder builder = new ProcessBuilder(command);
    builder.redirectErrorStream(true);
    Process process = builder.start();

    String output;
    try (InputStreamReader reader =
        new InputStreamReader(process.getInputStream(), StandardCharsets.UTF_8)) {
      output = CharStreams.toString(reader);
    }

    int exitCode = process.waitFor();
    return new ProcessResult(exitCode, output);
  }

  @Test
  public void testDefaultSslFailsForSelfSigned() throws Exception {
    ProcessResult result = runSubprocess(null, null);
    assertEquals(1, result.exitCode, "Subprocess should fail. Output:\n" + result.stdout);
    assertTrue(result.stdout.contains(PKIX_ERROR_MSG));
  }

  @Test
  public void testCustomTrustStoreSucceeds() throws Exception {
    String trustStorePath = new File(TRUSTSTORE_PATH).getAbsolutePath();
    ProcessResult result = runSubprocess(trustStorePath, PASSWORD);

    assertEquals(0, result.exitCode, "Subprocess failed. Output:\n" + result.stdout);
    assertTrue(result.stdout.contains(SUCCESS_MARKER));
    assertFalse(
        result.stdout.contains(PKIX_ERROR_MSG),
        "Handshake failed with SSL error: " + result.stdout);
  }

  public static void main(String[] args) {
    int port = Integer.parseInt(args[0]);
    String baseUri = "jdbc:bigquery://https://" + HOST + ":" + port + ";";
    String url =
        new URIBuilder(baseUri)
            .append("EndpointOverrides", "BIGQUERY=https://" + HOST + ":" + port)
            .append("ProjectId", "dummy")
            .append("OAuthType", 2)
            .append("OAuthAccessToken", "dummy-token")
            .toString();
    try (Connection connection = DriverManager.getConnection(url);
        Statement statement = connection.createStatement()) {
      statement.execute("SELECT 1");
      System.out.println(SUCCESS_MARKER);
      System.exit(0);
    } catch (Throwable e) {
      System.out.println(FAILURE_MARKER_PREFIX + e.getMessage());
      e.printStackTrace();
      System.exit(1);
    }
  }
}
