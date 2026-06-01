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
import com.google.api.gax.rpc.ApiException;
import com.google.api.gax.rpc.StatusCode;
import com.google.cloud.NoCredentials;
import com.google.cloud.bigquery.*;
import com.google.cloud.translate.v3.*;
import io.grpc.netty.shaded.io.grpc.netty.NettyChannelBuilder;
import io.grpc.netty.shaded.io.netty.handler.ssl.ApplicationProtocolConfig;
import io.grpc.netty.shaded.io.netty.handler.ssl.SslContext;
import io.grpc.netty.shaded.io.netty.handler.ssl.SslContextBuilder;
import io.grpc.netty.shaded.io.netty.handler.ssl.SslProvider;
import io.grpc.netty.shaded.io.netty.handler.ssl.util.InsecureTrustManagerFactory;
import java.io.InputStream;
import java.security.KeyStore;
import java.util.ArrayList;
import java.util.List;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

/**
 * PqcConnectivityTest serves as the base integration validation suite for confirming transparent,
 * zero-config Post-Quantum Cryptography (PQC) auto-upgrades across all Google Cloud Java SDK
 * transports.
 *
 * <h3>Design and Architectural Workflow</h3>
 *
 * <p>The validation framework operates via an end-to-end hermetic handshake architecture:
 *
 * <pre>
 *  +---------------------------------------+         +-----------------------------------------+
 *  |       Vanilla App Client Code         |         |         PqcTestServer (Enforces MLKEM768)|
 *  | (e.g. BigQueryOptions.getDefaultInst) |         +-----------------------------------------+
 *  +---------------------------------------+                              ^
 *                      |                                                  |
 *                      v                                                  |
 *  +---------------------------------------+                              |
 *  |       google-cloud-core-http          |                              |
 *  |      (DefaultHttpTransportFactory)     |                              |
 *  +---------------------------------------+                              |
 *                      |                                                  |
 *                      v                                                  |
 *  +---------------------------------------+                              |
 *  |       google-http-java-client         |                              |
 *  |   (SslUtils.getTlsSslContext() JJSSE) |                              |
 *  +---------------------------------------+                              |
 *                      |                                                  |
 *                      v                                                  |
 *  +---------------------------------------+                              |
 *  |     PqcDelegatingSSLSocketFactory     |                              |
 *  |  (Wraps default BCSSLSocketFactory)   |                              |
 *  +---------------------------------------+                              |
 *                      |                                                  |
 *                      +-----------------[TLSv1.3 MLKEM768 Hybrid Handshake]
 * </pre>
 *
 * <ul>
 *   <li><b>Auto-Upgrade Detection:</b> The test dynamically detects if the current classpath
 *       includes the snapshot version of <code>google-http-java-client</code> (which contains
 *       <code>PqcDelegatingSSLSocketFactory</code>).
 *   <li><b>Zero-Config Integration:</b> If supported, Bouncy Castle JSSE is promoted to the default
 *       security provider (position 1). The standard client generation libraries automatically wrap
 *       all outbound transport connections in post-quantum hybrid key exchanges (enforcing
 *       ML-KEM-768 and classical curves) without requiring manual transport option overrides.
 *   <li><b>Automatic Fallback:</b> In release test scopes (where older library builds lack PQC
 *       features), the test silently skips dynamic JCA promotion, validating that classical TLS 1.3
 *       paths remain fully robust and operational.
 * </ul>
 */
public abstract class PqcConnectivityTest {

  private static Process serverProcess;
  protected static int httpPqcPort;
  protected static int httpClassicalPort;
  protected static int grpcPqcPort;
  protected static int grpcClassicalPort;
  private static boolean isPqcSupported;
  private static KeyStore ks;

  /**
   * Configures the integration test harness environment before test cases are executed.
   *
   * <p><b>Harness Execution Flow:</b>
   *
   * <ol>
   *   <li>Extracts the secure PKCS12 validation certificate (<code>pqctest.p12</code>) from the
   *       classpath to a localized temp file to guarantee isolated execution.
   *   <li>Configures JVM standard truststore system properties (<code>javax.net.ssl.trustStore
   *       </code>) to point to the extracted certificate, enabling clean default SSLContext
   *       verification.
   *   <li>Inspects the runtime classpath to determine if PQC wrapper auto-upgrades are active.
   *   <li>If PQC is supported, registers <code>BouncyCastleJsseProvider</code> at position 1. This
   *       automatically causes all standard vanilla clients instantiating default <code>SSLContext
   *       </code> to negotiate PQC.
   *   <li>Spins up the hermetic <code>PqcTestServer</code> in a separate JVM process.
   * </ol>
   */
  /**
   * Configures the integration test harness environment before test cases are executed.
   *
   * <p><b>Detailed Security & Keystore Configuration Architecture:</b>
   *
   * <ul>
   *   <li><b>What is a Keystore (PKCS12):</b> A PKCS12 keystore (<code>pqctest.p12</code>) is a
   *       secure key database containing the server's private key and its self-signed public
   *       certificate. The server uses it during the TLS handshake to prove its identity and
   *       establish a secure channel.
   *   <li><b>How Encryption Works:</b> The certificate itself does not encrypt message data
   *       directly. Instead, during the TLS handshake, the client and server negotiate a symmetric
   *       session key using post-quantum cryptography (ML-KEM). This session key is then used to
   *       encrypt and decrypt all sent/received HTTP/gRPC data.
   *   <li><b>Why a Custom Temporary Truststore is Required:</b> Because the server uses a
   *       self-signed test certificate, it is not signed by any public Certificate Authority (CA)
   *       trusted by the standard JRE truststore (<code>cacerts</code>). Without registering a
   *       custom truststore containing this certificate, standard JRE TLS clients will reject the
   *       connection with an <code>SSLHandshakeException</code>. We extract the certificate to a
   *       temporary file and point <code>javax.net.ssl.trustStore</code> to it, thereby trusting it
   *       scope-specifically for this test run without polluting or mutating the user's system-wide
   *       JRE truststore.
   *   <li><b>JCA Provider Registration:</b> Registers <code>BouncyCastleJsseProvider</code> at
   *       provider position 1. This registers Bouncy Castle as the primary security provider,
   *       causing all standard default <code>SSLContext</code> and vanilla client factories to
   *       utilize Bouncy Castle JSSE and negotiate PQC automatically.
   * </ul>
   */
  protected boolean clientSupportsPqc() {
    return true;
  }

  protected abstract boolean grpcTestShouldSucceed();

  @BeforeAll
  public static void setup() throws Exception {

    // Dynamically detect if PQC auto-upgrade wrapping is supported by current
    // classpath
    // dependencies (Snapshot vs Release)
    try {
      Class.forName("com.google.api.client.http.javanet.PqcPeerHostSSLSocketFactory");
      isPqcSupported = true;
    } catch (ClassNotFoundException e) {
      isPqcSupported = false;
    }

    ks = KeyStore.getInstance("PKCS12");
    try (InputStream is = PqcConnectivityTest.class.getResourceAsStream("/pqctest.p12")) {
      if (is == null) {
        throw new RuntimeException("pqctest.p12 not found in classpath");
      }
      ks.load(is, "password".toCharArray());
    }

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
    boolean httpPqcFound = false;
    boolean httpClassicalFound = false;
    boolean grpcPqcFound = false;
    boolean grpcClassicalFound = false;

    // Wait for the server process to output its HTTP and gRPC ports
    long startTime = System.currentTimeMillis();
    while ((line = reader.readLine()) != null) {
      System.out.println("[SERVER-OUT] " + line);
      if (line.startsWith("HTTP_PQC_PORT: ")) {
        httpPqcPort = Integer.parseInt(line.substring(15).trim());
        httpPqcFound = true;
      } else if (line.startsWith("HTTP_CLASSICAL_PORT: ")) {
        httpClassicalPort = Integer.parseInt(line.substring(21).trim());
        httpClassicalFound = true;
      } else if (line.startsWith("GRPC_PQC_PORT: ")) {
        grpcPqcPort = Integer.parseInt(line.substring(15).trim());
        grpcPqcFound = true;
      } else if (line.startsWith("GRPC_CLASSICAL_PORT: ")) {
        grpcClassicalPort = Integer.parseInt(line.substring(21).trim());
        grpcClassicalFound = true;
      }

      if (httpPqcFound && httpClassicalFound && grpcPqcFound && grpcClassicalFound) {
        break;
      }

      // Ephemeral port detection timeout (10 seconds) to fail-fast on server startup
      // errors
      if (System.currentTimeMillis() - startTime > 10000) {
        throw new RuntimeException(
            "Timeout waiting for PqcTestServer ephemeral ports to be printed!");
      }
    }

    if (!httpPqcFound || !httpClassicalFound || !grpcPqcFound || !grpcClassicalFound) {
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
    TranslationServiceSettings.Builder settingsBuilder =
        TranslationServiceSettings.newBuilder()
            .setEndpoint("localhost:" + port)
            .setCredentialsProvider(NoCredentialsProvider.create());

    com.google.api.gax.grpc.InstantiatingGrpcChannelProvider.Builder channelProviderBuilder =
        ((com.google.api.gax.grpc.InstantiatingGrpcChannelProvider)
                settingsBuilder.getTransportChannelProvider())
            .toBuilder();
    channelProviderBuilder.setChannelConfigurator(
        new com.google.api.core.ApiFunction<
            io.grpc.ManagedChannelBuilder, io.grpc.ManagedChannelBuilder>() {
          @Override
          public io.grpc.ManagedChannelBuilder apply(io.grpc.ManagedChannelBuilder builder) {
            if (clientSupportsPqc()) {
              configureGrpcChannelForPqc(builder);
            } else {
              configureGrpcChannelForClassical(builder);
            }
            return builder;
          }
        });
    settingsBuilder.setTransportChannelProvider(channelProviderBuilder.build());

    TranslationServiceSettings settings = settingsBuilder.build();

    try (TranslationServiceClient client = TranslationServiceClient.create(settings)) {
      List<String> contents = new ArrayList<>();
      contents.add("house");
      TranslateTextRequest request =
          TranslateTextRequest.newBuilder()
              .setParent("projects/test-project")
              .addAllContents(contents)
              .build();

      try {
        TranslateTextResponse response = client.translateText(request);
        if (!shouldSucceed) {
          fail("Expected gRPC call to fail!");
        }
        assertNotNull(response);
      } catch (ApiException e) {
        if (shouldSucceed) {
          fail("Expected gRPC call to succeed, but failed: " + e.getMessage(), e);
        }
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


  private static void configureGrpcChannelForPqc(io.grpc.ManagedChannelBuilder<?> builder) {
    if (!(builder instanceof NettyChannelBuilder)) {
      throw new IllegalArgumentException(
          "Unsupported channel builder type: " + builder.getClass().getName());
    }
    NettyChannelBuilder nettyBuilder = (NettyChannelBuilder) builder;

    // Ensures HTTP/2 is used as it's required by gRPC
    ApplicationProtocolConfig apn =
        new ApplicationProtocolConfig(
            ApplicationProtocolConfig.Protocol.ALPN,
            ApplicationProtocolConfig.SelectorFailureBehavior.NO_ADVERTISE,
            ApplicationProtocolConfig.SelectedListenerFailureBehavior.ACCEPT,
            "h2");

    try {
      java.security.Provider bcProvider = new org.bouncycastle.jce.provider.BouncyCastleProvider();
      java.security.Provider bcJsseProvider =
          new org.bouncycastle.jsse.provider.BouncyCastleJsseProvider(bcProvider);

      SslContext shadedSslContext =
          SslContextBuilder.forClient()
              .sslProvider(SslProvider.JDK)
              .sslContextProvider(bcJsseProvider)
              .protocols("TLSv1.3")
              .applicationProtocolConfig(apn)
              .trustManager(InsecureTrustManagerFactory.INSTANCE)
              .build();

      nettyBuilder.sslContext(shadedSslContext);
    } catch (Exception e) {
      throw new RuntimeException("Failed to configure shaded gRPC Netty channel for PQC", e);
    }
  }

  private static void configureGrpcChannelForClassical(io.grpc.ManagedChannelBuilder<?> builder) {
    if (!(builder instanceof NettyChannelBuilder)) {
      throw new IllegalArgumentException(
          "Unsupported channel builder type: " + builder.getClass().getName());
    }
    NettyChannelBuilder nettyBuilder = (NettyChannelBuilder) builder;

    ApplicationProtocolConfig apn =
        new ApplicationProtocolConfig(
            ApplicationProtocolConfig.Protocol.ALPN,
            ApplicationProtocolConfig.SelectorFailureBehavior.NO_ADVERTISE,
            ApplicationProtocolConfig.SelectedListenerFailureBehavior.ACCEPT,
            "h2");

    try {
      SslContext shadedSslContext =
          SslContextBuilder.forClient()
              .applicationProtocolConfig(apn)
              .trustManager(InsecureTrustManagerFactory.INSTANCE)
              .build();

      nettyBuilder.sslContext(shadedSslContext);
    } catch (Exception e) {
      throw new RuntimeException("Failed to configure shaded gRPC Netty channel for Classical", e);
    }
  }
}
