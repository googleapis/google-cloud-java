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
import com.google.auth.http.HttpTransportFactory;
import com.google.cloud.bigquery.BigQuery;
import com.google.cloud.bigquery.BigQueryOptions;
import com.google.cloud.bigquery.Dataset;
import com.google.cloud.http.HttpTransportOptions;
import java.io.IOException;
import java.net.InetAddress;
import java.net.Socket;
import java.net.UnknownHostException;
import java.security.Security;
import javax.net.ssl.SSLContext;
import javax.net.ssl.SSLSocket;
import javax.net.ssl.SSLSocketFactory;
import org.conscrypt.Conscrypt;
import org.conscrypt.OpenSSLSocketImpl;

/**
 * A reproduction sample to trace TLS handshake details (protocol, cipher suite, and negotiated
 * curve) for Google Cloud BigQuery client calls, verifying that PQC (X25519MLKEM768) is negotiated.
 *
 * <p>This code requires Conscrypt on the classpath to enable and detect PQC algorithms.
 */
public class BqPqcTest {

  public static void main(String[] args) throws Exception {
    System.out.println("[DEBUG] Java Version: " + System.getProperty("java.version"));
    System.out.println("[DEBUG] Java Runtime: " + System.getProperty("java.runtime.version"));
    System.out.println(
        "[DEBUG] Java VM     : "
            + System.getProperty("java.vm.name")
            + " ("
            + System.getProperty("java.vm.version")
            + ")");
    try {
      System.out.println("[DEBUG] Conscrypt Version: " + Conscrypt.version());
      Security.addProvider(Conscrypt.newProvider());
      System.out.println("Registered Conscrypt provider.");
    } catch (Throwable t) {
      System.out.println("[DEBUG] Failed to register or get Conscrypt version: " + t.getMessage());
    }

    // 1. Build custom HttpTransportFactory with Tracing SSLSocketFactory
    HttpTransportFactory transportFactory = new TracingHttpTransportFactory();

    HttpTransportOptions transportOptions =
        HttpTransportOptions.newBuilder().setHttpTransportFactory(transportFactory).build();

    // 3. Initialize BigQuery client
    String projectId = System.getProperty("project.id", "lawrence-test-project-2");
    System.out.println("Initializing BigQuery client for project: " + projectId);

    BigQuery bigquery =
        BigQueryOptions.newBuilder()
            .setProjectId(projectId)
            .setTransportOptions(transportOptions)
            .build()
            .getService();

    // 4. Trigger a call to list datasets
    System.out.println("Listing datasets using BigQuery Client with TLS tracing...");
    try {
      for (Dataset dataset : bigquery.listDatasets().iterateAll()) {
        System.out.println("- " + dataset.getDatasetId().getDataset());
      }
    } catch (Exception e) {
      System.err.println("API call failed: " + e.getMessage());
      e.printStackTrace();
    }
  }

  private static void logHandshakeDetails(
      String protocol,
      String cipherSuite,
      String curve,
      String methodUsed,
      String socketClassName) {
    System.out.println("[TLS TRACE] Handshake Completed");
    System.out.println("  Protocol   : " + protocol);
    System.out.println("  CipherSuite: " + cipherSuite);
    if (curve != null) {
      System.out.println("  Curve Name : " + curve + " (via Conscrypt " + methodUsed + ")");
      boolean isPqc =
          curve.equalsIgnoreCase("X25519MLKEM768")
              || curve.toLowerCase().contains("mlkem")
              || curve.toLowerCase().contains("kyber");
      System.out.println(
          "  Is PQC?    : " + (isPqc ? "YES (Hybrid Post-Quantum)" : "NO (Classical)"));
    } else {
      System.out.println("  Curve Name : Unknown");
      System.out.println("  Socket Class: " + socketClassName);
      System.out.println("  Is PQC?    : UNKNOWN (Use Conscrypt to detect)");
    }
  }

  private static class TracingHttpTransportFactory implements HttpTransportFactory {
    @Override
    public HttpTransport create() {
      try {
        // Build a standard Conscrypt-backed TLS context
        SSLContext sslContext = SSLContext.getInstance("TLS", "Conscrypt");
        sslContext.init(null, null, null);
        SSLSocketFactory conscryptFactory = sslContext.getSocketFactory();

        // Wrap it in the tracing factory so we can log handshake outcomes
        SSLSocketFactory tracingFactory = new TracingSSLSocketFactory(conscryptFactory);

        // NetHttpTransport automatically wraps our tracing factory to enforce PQC named groups
        return new NetHttpTransport.Builder().setSslSocketFactory(tracingFactory).build();
      } catch (Exception e) {
        throw new RuntimeException("Failed to create Conscrypt-enforced tracing transport", e);
      }
    }
  }

  /**
   * A wrapper SSLSocketFactory that registers a handshake completion listener to intercept and
   * print TLS metadata (protocol, cipher suite, and negotiated group/curve) for developer
   * visibility and testing.
   */
  private static class TracingSSLSocketFactory extends SSLSocketFactory {
    private final SSLSocketFactory delegate;

    public TracingSSLSocketFactory(SSLSocketFactory delegate) {
      this.delegate = delegate;
    }

    private Socket wrap(Socket socket) {
      if (socket instanceof SSLSocket) {
        SSLSocket sslSocket = (SSLSocket) socket;
        sslSocket.addHandshakeCompletedListener(
            event -> {
              try {
                String cipherSuite = event.getCipherSuite();
                String protocol = event.getSession().getProtocol();
                Socket rawSocket = event.getSocket();

                String curve = null;
                String methodUsed = "";

                if (rawSocket instanceof OpenSSLSocketImpl) {
                  curve = ((OpenSSLSocketImpl) rawSocket).getCurveNameForTesting();
                  methodUsed = "OpenSSLSocketImpl.getCurveNameForTesting";
                }

                logHandshakeDetails(
                    protocol, cipherSuite, curve, methodUsed, rawSocket.getClass().getName());
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
}
