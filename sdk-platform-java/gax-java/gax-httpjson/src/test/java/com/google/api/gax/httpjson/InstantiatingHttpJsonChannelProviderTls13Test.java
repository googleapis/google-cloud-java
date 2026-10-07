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

import static com.google.common.truth.Truth.assertThat;

import com.google.api.client.http.GenericUrl;
import com.google.api.client.http.HttpResponse;
import com.google.api.client.http.HttpTransport;
import com.google.api.client.util.SecurityUtils;
import com.google.api.gax.rpc.mtls.CertificateBasedAccess;
import com.google.api.gax.rpc.testing.FakeMtlsProvider;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.InetAddress;
import java.nio.charset.StandardCharsets;
import java.security.KeyStore;
import java.security.cert.CertificateFactory;
import java.security.cert.X509Certificate;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.TimeUnit;
import javax.net.ssl.KeyManagerFactory;
import javax.net.ssl.SSLContext;
import javax.net.ssl.SSLServerSocket;
import javax.net.ssl.SSLSocket;
import javax.net.ssl.TrustManager;
import javax.net.ssl.X509TrustManager;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.condition.EnabledIf;
import org.junit.jupiter.api.io.TempDir;
import org.mockito.Mockito;

/**
 * Handshake test for the Conscrypt-backed mTLS {@link HttpTransport} built by {@link
 * InstantiatingHttpJsonChannelProvider}.
 *
 * <p>Regression test for "Unknown authType: GENERIC": on TLS 1.3, Conscrypt passes the authType
 * {@code "GENERIC"} to its trust manager. If the trust manager comes from the JDK (SunJSSE) rather
 * than Conscrypt, it rejects server certificates that are issued by a trusted CA and carry a
 * KeyUsage extension (as Google front ends' certificates do), and every mTLS HTTP/JSON handshake
 * fails. A self-signed server certificate that is itself the trust anchor does not reproduce the
 * issue, so the server here presents a CA-issued leaf with KeyUsage.
 *
 * <p>The transport always uses the default trust store, so this test points {@code
 * javax.net.ssl.trustStore} at a temporary store containing only the test CA, and restores the
 * previous value afterwards.
 */
@EnabledIf(
    value = "isConscryptAndTls13Available",
    disabledReason = "Conscrypt native library or TLS 1.3 is unavailable on this platform")
class InstantiatingHttpJsonChannelProviderTls13Test {

  private static final String RESOURCE_DIR = "com/google/api/gax/httpjson/";
  private static final String TRUST_STORE_PROPERTY = "javax.net.ssl.trustStore";
  private static final String TRUST_STORE_PASSWORD_PROPERTY = "javax.net.ssl.trustStorePassword";
  private static final String TRUST_STORE_PASSWORD = "changeit";

  @TempDir File tempDir;

  private String previousTrustStore;
  private String previousTrustStorePassword;
  private ExecutorService serverExecutor;

  /** Condition for {@link EnabledIf}; must be static because it is used at class level. */
  static boolean isConscryptAndTls13Available() {
    return HttpJsonConscryptUtils.getConscryptProvider() != null && isTls13Supported();
  }

  @BeforeEach
  void setUp() throws Exception {
    previousTrustStore = System.getProperty(TRUST_STORE_PROPERTY);
    previousTrustStorePassword = System.getProperty(TRUST_STORE_PASSWORD_PROPERTY);
    File trustStoreFile = writeTrustStoreWithTestCa();
    System.setProperty(TRUST_STORE_PROPERTY, trustStoreFile.getAbsolutePath());
    System.setProperty(TRUST_STORE_PASSWORD_PROPERTY, TRUST_STORE_PASSWORD);

    serverExecutor = Executors.newSingleThreadExecutor();
  }

  @AfterEach
  void tearDown() {
    restoreProperty(TRUST_STORE_PROPERTY, previousTrustStore);
    restoreProperty(TRUST_STORE_PASSWORD_PROPERTY, previousTrustStorePassword);
    if (serverExecutor != null) {
      serverExecutor.shutdownNow();
    }
  }

  @Test
  void createHttpTransport_withMtlsAndConscrypt_completesTls13HandshakeWithCaIssuedServerCert()
      throws Exception {
    CertificateBasedAccess certificateBasedAccess = Mockito.mock(CertificateBasedAccess.class);
    Mockito.when(certificateBasedAccess.useMtlsClientCertificate()).thenReturn(true);
    InstantiatingHttpJsonChannelProvider channelProvider =
        InstantiatingHttpJsonChannelProvider.newBuilder()
            .setEndpoint("localhost:443")
            .setMtlsProvider(
                new FakeMtlsProvider(FakeMtlsProvider.createTestMtlsKeyStore(), "", false))
            .setCertificateBasedAccess(certificateBasedAccess)
            .build();
    HttpTransport transport = channelProvider.createHttpTransport();
    assertThat(transport).isNotNull();

    final SSLServerSocket serverSocket = createTls13ServerSocket();
    try {
      Future<Boolean> clientCertificatePresented =
          serverExecutor.submit(() -> serveSingleRequest(serverSocket));

      HttpResponse response =
          transport
              .createRequestFactory()
              .buildGetRequest(
                  new GenericUrl("https://localhost:" + serverSocket.getLocalPort() + "/"))
              .execute();
      try {
        assertThat(response.getStatusCode()).isEqualTo(200);
        assertThat(response.parseAsString()).isEqualTo("ok");
      } finally {
        response.disconnect();
      }
      // execute() is synchronous so the server task is already done; timeout guards against hangs.
      assertThat(clientCertificatePresented.get(10, TimeUnit.SECONDS)).isTrue();
    } finally {
      serverSocket.close();
    }
  }

  /** Accepts one connection, answers one HTTP request, and reports if a client cert was sent. */
  private static boolean serveSingleRequest(SSLServerSocket serverSocket) throws Exception {
    SSLSocket socket = (SSLSocket) serverSocket.accept();
    try {
      socket.startHandshake();
      boolean clientCertificatePresented = socket.getSession().getPeerCertificates().length > 0;
      BufferedReader reader =
          new BufferedReader(
              new InputStreamReader(socket.getInputStream(), StandardCharsets.US_ASCII));
      String line;
      while ((line = reader.readLine()) != null && !line.isEmpty()) {
        // Drain request headers.
      }
      OutputStream out = socket.getOutputStream();
      out.write(
          ("HTTP/1.1 200 OK\r\nContent-Length: 2\r\nConnection: close\r\n\r\nok")
              .getBytes(StandardCharsets.US_ASCII));
      out.flush();
      return clientCertificatePresented;
    } finally {
      socket.close();
    }
  }

  /**
   * Creates a JDK TLS 1.3 server that presents a CA-issued leaf certificate with KeyUsage and
   * requires (but does not validate) a client certificate.
   */
  private static SSLServerSocket createTls13ServerSocket() throws Exception {
    KeyStore serverKeyStore;
    InputStream certAndKey = openResource("tls13TestServerCertAndKey.pem");
    try {
      serverKeyStore = SecurityUtils.createMtlsKeyStore(certAndKey);
    } finally {
      certAndKey.close();
    }
    KeyManagerFactory keyManagerFactory =
        KeyManagerFactory.getInstance(KeyManagerFactory.getDefaultAlgorithm());
    keyManagerFactory.init(serverKeyStore, new char[0]);

    SSLContext serverContext = SSLContext.getInstance("TLSv1.3");
    serverContext.init(
        keyManagerFactory.getKeyManagers(), new TrustManager[] {new AcceptAllTrustManager()}, null);
    SSLServerSocket serverSocket =
        (SSLServerSocket)
            serverContext
                .getServerSocketFactory()
                .createServerSocket(0, 1, InetAddress.getLoopbackAddress());
    serverSocket.setEnabledProtocols(new String[] {"TLSv1.3"});
    serverSocket.setNeedClientAuth(true);
    return serverSocket;
  }

  private File writeTrustStoreWithTestCa() throws Exception {
    X509Certificate caCertificate;
    InputStream caPem = openResource("tls13TestCa.pem");
    try {
      caCertificate =
          (X509Certificate) CertificateFactory.getInstance("X.509").generateCertificate(caPem);
    } finally {
      caPem.close();
    }
    KeyStore trustStore = KeyStore.getInstance(KeyStore.getDefaultType());
    trustStore.load(null, null);
    trustStore.setCertificateEntry("gax-test-ca", caCertificate);
    File trustStoreFile = new File(tempDir, "truststore");
    OutputStream out = new FileOutputStream(trustStoreFile);
    try {
      trustStore.store(out, TRUST_STORE_PASSWORD.toCharArray());
    } finally {
      out.close();
    }
    return trustStoreFile;
  }

  private static InputStream openResource(String name) {
    InputStream stream =
        InstantiatingHttpJsonChannelProviderTls13Test.class
            .getClassLoader()
            .getResourceAsStream(RESOURCE_DIR + name);
    if (stream == null) {
      throw new IllegalStateException("Missing test resource: " + RESOURCE_DIR + name);
    }
    return stream;
  }

  private static boolean isTls13Supported() {
    try {
      SSLContext.getInstance("TLSv1.3");
      return true;
    } catch (Exception e) {
      return false;
    }
  }

  private static void restoreProperty(String key, String value) {
    if (value == null) {
      System.clearProperty(key);
    } else {
      System.setProperty(key, value);
    }
  }

  /** Server-side trust manager: the test only checks that a client certificate is presented. */
  private static final class AcceptAllTrustManager implements X509TrustManager {
    @Override
    public void checkClientTrusted(X509Certificate[] chain, String authType) {}

    @Override
    public void checkServerTrusted(X509Certificate[] chain, String authType) {}

    @Override
    public X509Certificate[] getAcceptedIssuers() {
      return new X509Certificate[0];
    }
  }
}
