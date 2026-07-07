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
import com.google.api.client.util.SslUtils;
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
import java.util.concurrent.atomic.AtomicReference;
import javax.net.ssl.SSLContext;
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

    // Ensure Conscrypt is registered locally for our tracing context lookup
    if (Security.getProvider("Conscrypt") == null) {
      Security.addProvider(Conscrypt.newProvider());
    }

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

    // 1. Build custom HttpTransportFactory with Tracing SSLSocketFactory to capture the handshake
    // curve
    HttpTransportFactory transportFactory = new TracingHttpTransportFactory();
    HttpTransportOptions transportOptions =
        HttpTransportOptions.newBuilder().setHttpTransportFactory(transportFactory).build();

    System.out.println("Initializing default BigQuery client for project: " + projectId);
    BigQuery bigquery =
        BigQueryOptions.newBuilder()
            .setProjectId(projectId)
            .setTransportOptions(transportOptions)
            .build()
            .getService();

    System.out.println("Listing datasets using default BigQuery Client...");
    try {
      for (Dataset dataset : bigquery.listDatasets().iterateAll()) {
        System.out.println("- " + dataset.getDatasetId().getDataset());
      }
      System.out.println("Success! BigQuery datasets retrieved successfully.");
    } catch (Exception e) {
      System.err.println("API call failed: " + e.getMessage());
      e.printStackTrace();
    }

    // 2. Perform Programmatic Assertion on the Negotiated Curve
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

    if (EXPECTED_PQC_CURVE.equalsIgnoreCase(curve)) {
      System.out.println("VERIFICATION SUCCESS: PQC Hybrid key exchange negotiated successfully!");
    } else {
      System.err.println(
          "VERIFICATION FAILED: Expected PQC Key Exchange "
              + EXPECTED_PQC_CURVE
              + " but negotiated: "
              + curve);
      System.exit(1);
    }
  }

  private static class TracingHttpTransportFactory implements HttpTransportFactory {
    @Override
    public HttpTransport create() {
      try {
        // Obtain the default TLS SSLContext (which handles Conscrypt and TrustManager resolution by
        // default)
        SSLContext sslContext = SslUtils.getDefaultTlsSslContext();
        SSLSocketFactory conscryptFactory = sslContext.getSocketFactory();

        // Wrap the socket factory to intercept handshakes
        SSLSocketFactory tracingFactory = new TracingSSLSocketFactory(conscryptFactory);

        // NetHttpTransport automatically wraps our tracing factory to enforce PQC named groups
        return new NetHttpTransport.Builder().setSslSocketFactory(tracingFactory).build();
      } catch (Exception e) {
        throw new RuntimeException("Failed to create Conscrypt-enforced tracing transport", e);
      }
    }
  }

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
                negotiatedCipherSuite.set(event.getCipherSuite());
                negotiatedProtocol.set(event.getSession().getProtocol());
                Socket rawSocket = event.getSocket();

                if (rawSocket instanceof OpenSSLSocketImpl) {
                  negotiatedCurve.set(((OpenSSLSocketImpl) rawSocket).getCurveNameForTesting());
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
}
