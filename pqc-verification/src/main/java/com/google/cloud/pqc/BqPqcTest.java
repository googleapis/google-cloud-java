/*
 * Copyright 2026 Google LLC
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      https://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package com.google.cloud.pqc;

import com.google.api.client.http.HttpTransport;
import com.google.api.client.http.javanet.NetHttpTransport;
import com.google.cloud.bigquery.BigQuery;
import com.google.cloud.bigquery.BigQueryOptions;
import com.google.cloud.http.HttpTransportOptions;
import java.io.IOException;
import java.net.InetAddress;
import java.net.Socket;
import java.net.UnknownHostException;
import java.util.concurrent.atomic.AtomicReference;
import javax.net.ssl.SSLSocket;
import javax.net.ssl.SSLSocketFactory;
import org.conscrypt.Conscrypt;
import org.conscrypt.OpenSSLSocketImpl;

/**
 * A verification sample to programmatically trace and assert TLS handshake details (protocol,
 * cipher suite, and negotiated curve) for Google Cloud BigQuery client calls, verifying that PQC
 * (X25519MLKEM768) is negotiated.
 */
public class BqPqcTest {

  private static final String EXPECTED_PQC_CURVE = "X25519MLKEM768";
  private static final AtomicReference<String> negotiatedCurve = new AtomicReference<>();
  private static final AtomicReference<String> negotiatedProtocol = new AtomicReference<>();
  private static final AtomicReference<String> negotiatedCipherSuite = new AtomicReference<>();

  public static void main(String[] args) throws Exception {
    System.out.println("[DEBUG] Java Version: " + System.getProperty("java.version"));
    System.out.println("[DEBUG] Java Runtime: " + System.getProperty("java.runtime.version"));
    System.out.println(
        "[DEBUG] Java VM     : "
            + System.getProperty("java.vm.name")
            + " ("
            + System.getProperty("java.vm.version")
            + ")");

    String projectId = System.getProperty("project.id");
    if (projectId == null || projectId.isEmpty()) {
      projectId = System.getenv("GOOGLE_CLOUD_PROJECT");
    }
    if (projectId == null || projectId.isEmpty()) {
      try {
        projectId = BigQueryOptions.getDefaultInstance().getProjectId();
      } catch (Exception e) {
        // Ignore if defaults are not configured
      }
    }
    if (projectId == null || projectId.isEmpty()) {
      System.err.println("Error: Google Cloud Project ID could not be resolved automatically.");
      System.err.println(
          "Please set the GOOGLE_CLOUD_PROJECT environment variable, or configure Application"
              + " Default Credentials.");
      System.exit(1);
    }

    boolean usePqc = isConscryptFunctional();
    HttpTransportOptions transportOptions;

    if (usePqc) {
      System.out.println("Conscrypt is functional. Configuring TLS hybrid PQC tracing...");
      // 1. Get the default HttpTransport from standard HttpTransportOptions
      HttpTransportOptions defaultOptions = HttpTransportOptions.newBuilder().build();
      HttpTransport defaultTransport = defaultOptions.getHttpTransportFactory().create();

      // 2. Reflectively extract the SSLSocketFactory configured by gax/core-http
      SSLSocketFactory defaultFactory =
          (SSLSocketFactory) getPrivateField(defaultTransport, "sslSocketFactory");
      if (defaultFactory == null) {
        defaultFactory = (SSLSocketFactory) SSLSocketFactory.getDefault();
      }

      // 3. Wrap it in our tracing socket factory
      SSLSocketFactory tracingFactory = new TracingSSLSocketFactory(defaultFactory);

      // 4. Build a tracing transport using this factory and GAX PQC configuration
      NetHttpTransport.Builder tracingBuilder = new NetHttpTransport.Builder();
      tracingBuilder.setSecurityProvider(Conscrypt.newProvider());
      tracingBuilder.setSslSocketConfigurator(
          socket -> {
            if (Conscrypt.isConscrypt(socket)) {
              Conscrypt.setNamedGroups(
                  socket,
                  com.google.api.gax.httpjson.InstantiatingHttpJsonChannelProvider
                      .DEFAULT_PQC_GROUPS);
            }
          });
      tracingBuilder.setSslSocketFactory(tracingFactory);
      HttpTransport tracingTransport = tracingBuilder.build();

      // 5. Configure BigQuery client to use this tracing transport
      transportOptions =
          HttpTransportOptions.newBuilder().setHttpTransportFactory(() -> tracingTransport).build();
    } else {
      System.out.println(
          "Conscrypt is not functional. Using default transport options (clean fallback check)...");
      transportOptions = HttpTransportOptions.newBuilder().build();
    }

    System.out.println("Initializing default BigQuery client for project: " + projectId);
    BigQuery bigquery =
        BigQueryOptions.newBuilder()
            .setProjectId(projectId)
            .setTransportOptions(transportOptions)
            .setCredentials(com.google.cloud.NoCredentials.getInstance())
            .build()
            .getService();

    System.out.println("Executing API call to trigger TLS handshake...");
    try {
      bigquery.listDatasets();
    } catch (com.google.cloud.bigquery.BigQueryException e) {
      if (e.getCode() == 401
          || e.getMessage().contains("missing required authentication credential")) {
        System.out.println("TLS connection established. Proceeding with verification...");
      } else {
        System.err.println("API call failed with unexpected error code.");
        e.printStackTrace();
        System.exit(1);
      }
    } catch (Exception e) {
      System.err.println("Unexpected exception during connection.");
      e.printStackTrace();
      System.exit(1);
    }

    if (usePqc) {
      // Wait a brief moment for asynchronous JSSE listener thread to execute
      Thread.sleep(300);

      // Perform Programmatic Assertion on the Negotiated Curve
      String curve = negotiatedCurve.get();
      String protocol = negotiatedProtocol.get();
      String cipherSuite = negotiatedCipherSuite.get();

      System.out.println("\n==================================================");
      System.out.println("TLS Handshake Verification Results:");
      System.out.println("  Protocol      : " + protocol);
      System.out.println("  Cipher Suite  : " + cipherSuite);
      System.out.println("  Negotiated KEX: " + curve);
      System.out.println("==================================================");

      if (curve == null) {
        System.err.println("ERROR: No TLS handshake was intercepted!");
        System.exit(1);
      }

      String expectedCurve = "X25519MLKEM768";
      if (expectedCurve.equalsIgnoreCase(curve)) {
        System.out.println(
            "VERIFICATION SUCCESS: Key exchange (" + expectedCurve + ") negotiated successfully!");
      } else {
        System.err.println(
            "VERIFICATION FAILED: Expected Key Exchange "
                + expectedCurve
                + " but negotiated: "
                + curve);
        System.exit(1);
      }
    } else {
      System.out.println("\n==================================================");
      System.out.println(
          "VERIFICATION SUCCESS: Clean fallback to default JSSE provider verified successfully!");
      System.out.println("==================================================");
    }
  }

  private static Object getPrivateField(Object obj, String fieldName) throws Exception {
    Class<?> clazz = obj.getClass();
    while (clazz != null) {
      try {
        java.lang.reflect.Field field = clazz.getDeclaredField(fieldName);
        field.setAccessible(true);
        return field.get(obj);
      } catch (NoSuchFieldException e) {
        clazz = clazz.getSuperclass();
      }
    }
    throw new NoSuchFieldException(
        "Field " + fieldName + " not found in class hierarchy of " + obj.getClass());
  }

  private static class TracingSSLSocketFactory extends SSLSocketFactory {
    private final SSLSocketFactory delegate;

    public TracingSSLSocketFactory(SSLSocketFactory delegate) {
      this.delegate = delegate;
    }

    private Socket wrap(Socket socket) {
      System.out.println(
          "[DEBUG] TracingSSLSocketFactory wrapped socket: "
              + (socket == null ? "null" : socket.getClass().getName()));
      if (socket instanceof SSLSocket) {
        SSLSocket sslSocket = (SSLSocket) socket;
        sslSocket.addHandshakeCompletedListener(
            event -> {
              try {
                System.out.println("[DEBUG] HandshakeCompletedListener triggered asynchronously!");
                negotiatedCipherSuite.set(event.getCipherSuite());
                negotiatedProtocol.set(event.getSession().getProtocol());
                Socket rawSocket = event.getSocket();

                String curve = null;
                // Direct Conscrypt check since it is a direct dependency
                if (rawSocket instanceof OpenSSLSocketImpl) {
                  curve = ((OpenSSLSocketImpl) rawSocket).getCurveNameForTesting();
                }

                if (curve != null) {
                  negotiatedCurve.set(curve);
                }
              } catch (Exception e) {
                System.err.println("Failed to log TLS handshake: " + e.getMessage());
              }
            });
      }
      return socket;
    }

    @Override
    public String[] getDefaultCipherSuites() {
      return delegate.getDefaultCipherSuites();
    }

    @Override
    public String[] getSupportedCipherSuites() {
      return delegate.getSupportedCipherSuites();
    }

    @Override
    public Socket createSocket(Socket s, String host, int port, boolean autoClose)
        throws IOException {
      return wrap(delegate.createSocket(s, host, port, autoClose));
    }

    @Override
    public Socket createSocket() throws IOException {
      return wrap(delegate.createSocket());
    }

    @Override
    public Socket createSocket(String host, int port) throws IOException, UnknownHostException {
      return wrap(delegate.createSocket(host, port));
    }

    @Override
    public Socket createSocket(String host, int port, InetAddress localHost, int localPort)
        throws IOException, UnknownHostException {
      return wrap(delegate.createSocket(host, port, localHost, localPort));
    }

    @Override
    public Socket createSocket(InetAddress host, int port) throws IOException {
      return wrap(delegate.createSocket(host, port));
    }

    @Override
    public Socket createSocket(
        InetAddress address, int port, InetAddress localAddress, int localPort) throws IOException {
      return wrap(delegate.createSocket(address, port, localAddress, localPort));
    }
  }

  private static boolean isConscryptFunctional() {
    try {
      org.conscrypt.Conscrypt.newProvider();
      return true;
    } catch (Throwable t) {
      return false;
    }
  }
}
