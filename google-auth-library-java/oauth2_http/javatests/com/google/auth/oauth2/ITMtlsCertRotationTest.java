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
 * A PURPOSE ARE DISCLAIMED. IN NO EVENT SHALL THE COPYRIGHT
 * OWNER OR CONTRIBUTORS BE LIABLE FOR ANY DIRECT, INDIRECT, INCIDENTAL,
 * SPECIAL, EXEMPLARY, OR CONSEQUENTIAL DAMAGES (INCLUDING, BUT NOT
 * LIMITED TO, PROCUREMENT OF SUBSTITUTE GOODS OR SERVICES; LOSS OF USE,
 * DATA, OR PROFITS; OR BUSINESS INTERRUPTION) HOWEVER CAUSED AND ON ANY
 * THEORY OF LIABILITY, WHETHER IN CONTRACT, STRICT LIABILITY, OR TORT
 * (INCLUDING NEGLIGENCE OR OTHERWISE) ARISING IN ANY WAY OUT OF THE USE
 * OF THIS SOFTWARE, EVEN IF ADVISED OF THE POSSIBILITY OF SUCH DAMAGE.
 */

package com.google.auth.oauth2;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertTrue;

import com.google.api.client.json.GenericJson;
import com.google.auth.mtls.MtlsHttpTransportFactory;
import com.google.auth.mtls.X509Provider;
import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.InetSocketAddress;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;
import java.security.KeyFactory;
import java.security.KeyStore;
import java.security.PrivateKey;
import java.security.cert.Certificate;
import java.security.cert.CertificateFactory;
import java.security.cert.X509Certificate;
import java.security.spec.PKCS8EncodedKeySpec;
import java.util.ArrayList;
import java.util.Base64;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;
import javax.net.ssl.KeyManagerFactory;
import javax.net.ssl.SSLContext;
import javax.net.ssl.SSLServerSocket;
import javax.net.ssl.SSLSocket;
import javax.net.ssl.TrustManagerFactory;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.io.TempDir;

/**
 * End-to-end integration test verifying: 1) mTLS Dynamic Certificate Rotation
 * (MtlsHttpTransportFactory + X509Provider) 2) STS 401 Unauthorized Retry Interception over real
 * local HTTPS sockets requiring mTLS
 *
 * <p>Uses raw SSLServerSocket and static pre-generated test resource fixtures in
 * testresources/mtls/ for zero host process / OpenSSL dependencies and zero JDK module
 * instrumentation warnings.
 */
public class ITMtlsCertRotationTest {

  private static final String TESTRESOURCES_DIR = "testresources/mtls/";

  @TempDir Path tempDir;

  private SSLServerSocket serverSocket;
  private Thread serverThread;
  private volatile boolean running = true;
  private int serverPort;
  private final List<String> peerCertificatesReceived =
      Collections.synchronizedList(new ArrayList<>());
  private final AtomicInteger requestCounter = new AtomicInteger(0);
  private final CountDownLatch serverReadyLatch = new CountDownLatch(1);

  private Path certConfigPath;
  private Path activeCertPath;
  private Path activeKeyPath;
  private Path cert1Path;
  private Path key1Path;
  private Path cert2Path;
  private Path key2Path;
  private Path serverCertPath;
  private Path serverKeyPath;
  private String oldTrustStore;
  private String oldTrustStorePassword;

  @BeforeEach
  void setUp() throws Exception {
    cert1Path = Paths.get(TESTRESOURCES_DIR, "client_v1.crt");
    key1Path = Paths.get(TESTRESOURCES_DIR, "client_v1.pem.key");
    cert2Path = Paths.get(TESTRESOURCES_DIR, "client_v2.crt");
    key2Path = Paths.get(TESTRESOURCES_DIR, "client_v2.pem.key");
    serverCertPath = Paths.get(TESTRESOURCES_DIR, "server.crt");
    serverKeyPath = Paths.get(TESTRESOURCES_DIR, "server.pem.key");

    activeCertPath = tempDir.resolve("active_client.crt");
    activeKeyPath = tempDir.resolve("active_client.pem.key");
    Files.copy(cert1Path, activeCertPath, StandardCopyOption.REPLACE_EXISTING);
    Files.copy(key1Path, activeKeyPath, StandardCopyOption.REPLACE_EXISTING);

    certConfigPath = tempDir.resolve("certificate_config.json");
    String configJson =
        "{\n"
            + "  \"cert_configs\": {\n"
            + "    \"workload\": {\n"
            + "      \"cert_path\": \""
            + activeCertPath.toString().replace("\\", "/")
            + "\",\n"
            + "      \"key_path\": \""
            + activeKeyPath.toString().replace("\\", "/")
            + "\"\n"
            + "    }\n"
            + "  }\n"
            + "}\n";
    Files.write(certConfigPath, configJson.getBytes(StandardCharsets.UTF_8));

    oldTrustStore = System.getProperty("javax.net.ssl.trustStore");
    oldTrustStorePassword = System.getProperty("javax.net.ssl.trustStorePassword");

    Path clientTrustStorePath = tempDir.resolve("client_truststore.p12");
    KeyStore clientTrustStore = KeyStore.getInstance("PKCS12");
    clientTrustStore.load(null, null);
    addCertToTrustStore(clientTrustStore, serverCertPath, "server");
    try (FileOutputStream fos = new FileOutputStream(clientTrustStorePath.toFile())) {
      clientTrustStore.store(fos, "password".toCharArray());
    }

    System.setProperty("javax.net.ssl.trustStore", clientTrustStorePath.toString());
    System.setProperty("javax.net.ssl.trustStorePassword", "password");

    startLocalMtlsServerSocket();
  }

  @AfterEach
  void tearDown() {
    running = false;
    if (serverSocket != null && !serverSocket.isClosed()) {
      try {
        serverSocket.close();
      } catch (Exception ignored) {
      }
    }
    if (oldTrustStore != null) {
      System.setProperty("javax.net.ssl.trustStore", oldTrustStore);
    } else {
      System.clearProperty("javax.net.ssl.trustStore");
    }
    if (oldTrustStorePassword != null) {
      System.setProperty("javax.net.ssl.trustStorePassword", oldTrustStorePassword);
    } else {
      System.clearProperty("javax.net.ssl.trustStorePassword");
    }
  }

  @Test
  void endToEndMtlsCertRotation_on401Retry_reloadsRotatedCertAndSucceeds() throws Exception {
    assertTrue(
        serverReadyLatch.await(5, TimeUnit.SECONDS), "Server socket failed to start in time");

    X509Provider x509Provider = new X509Provider(certConfigPath.toString());
    MtlsHttpTransportFactory transportFactory = new MtlsHttpTransportFactory(x509Provider);

    GenericJson json = new GenericJson();
    json.put("type", "external_account");
    json.put(
        "audience",
        "//iam.googleapis.com/projects/123/locations/global/workloadIdentityPools/pool/providers/provider");
    json.put("subject_token_type", "urn:ietf:params:oauth:token-type:id_token");
    json.put("token_url", "https://127.0.0.1:" + serverPort + "/sts/token");

    Map<String, String> credentialSource = new HashMap<>();
    credentialSource.put("file", activeCertPath.toString());
    json.put("credential_source", credentialSource);

    ExternalAccountCredentials credential =
        ExternalAccountCredentials.fromJson(json, transportFactory);

    StsTokenExchangeRequest stsRequest =
        StsTokenExchangeRequest.newBuilder(
                "subject_token_payload", "urn:ietf:params:oauth:token-type:id_token")
            .setAudience(
                "//iam.googleapis.com/projects/123/locations/global/workloadIdentityPools/pool/providers/provider")
            .build();

    AccessToken accessToken = credential.exchangeExternalCredentialForAccessToken(stsRequest);

    assertNotNull(accessToken);
    assertEquals("access_token_via_rotated_mtls_cert_v2", accessToken.getTokenValue());
    assertEquals(2, requestCounter.get());
    assertEquals(2, peerCertificatesReceived.size());

    assertTrue(peerCertificatesReceived.get(0).contains("CN=client-v1"));
    assertTrue(peerCertificatesReceived.get(1).contains("CN=client-v2"));
  }

  private void startLocalMtlsServerSocket() throws Exception {
    SSLContext serverSslContext = createServerSslContext();
    serverSocket = (SSLServerSocket) serverSslContext.getServerSocketFactory().createServerSocket();
    serverSocket.bind(new InetSocketAddress("127.0.0.1", 0));
    serverSocket.setNeedClientAuth(true);
    serverPort = serverSocket.getLocalPort();

    serverThread =
        new Thread(
            () -> {
              serverReadyLatch.countDown();
              while (running) {
                try (SSLSocket clientSocket = (SSLSocket) serverSocket.accept()) {
                  clientSocket.startHandshake();
                  int count = requestCounter.incrementAndGet();
                  String peerPrincipalName = "UNKNOWN";
                  Certificate[] certs = clientSocket.getSession().getPeerCertificates();
                  if (certs != null && certs.length > 0 && certs[0] instanceof X509Certificate) {
                    peerPrincipalName =
                        ((X509Certificate) certs[0]).getSubjectX500Principal().getName();
                    peerCertificatesReceived.add(peerPrincipalName);
                  }

                  BufferedReader reader =
                      new BufferedReader(
                          new InputStreamReader(
                              clientSocket.getInputStream(), StandardCharsets.UTF_8));
                  String line;
                  int contentLength = 0;
                  while ((line = reader.readLine()) != null && !line.isEmpty()) {
                    if (line.toLowerCase().startsWith("content-length:")) {
                      contentLength = Integer.parseInt(line.split(":")[1].trim());
                    }
                  }
                  if (contentLength > 0) {
                    char[] body = new char[contentLength];
                    reader.read(body, 0, contentLength);
                  }

                  OutputStream os = clientSocket.getOutputStream();
                  if (peerPrincipalName.contains("client-v1")) {
                    Path tmpCert = tempDir.resolve("tmp_active_cert.crt");
                    Path tmpKey = tempDir.resolve("tmp_active_key.pem.key");
                    Files.copy(cert2Path, tmpCert, StandardCopyOption.REPLACE_EXISTING);
                    Files.copy(key2Path, tmpKey, StandardCopyOption.REPLACE_EXISTING);
                    Files.move(tmpCert, activeCertPath, StandardCopyOption.ATOMIC_MOVE);
                    Files.move(tmpKey, activeKeyPath, StandardCopyOption.ATOMIC_MOVE);

                    String jsonError =
                        "{\"error\": \"invalid_grant\", \"error_description\": \"mTLS Certificate Expired\"}";
                    byte[] payload = jsonError.getBytes(StandardCharsets.UTF_8);
                    String response =
                        "HTTP/1.1 401 Unauthorized\r\n"
                            + "Content-Type: application/json\r\n"
                            + "Content-Length: "
                            + payload.length
                            + "\r\n"
                            + "Connection: close\r\n\r\n";
                    os.write(response.getBytes(StandardCharsets.UTF_8));
                    os.write(payload);
                    os.flush();
                  } else {
                    String jsonOk =
                        "{\"access_token\": \"access_token_via_rotated_mtls_cert_v2\","
                            + " \"issued_token_type\": \"urn:ietf:params:oauth:token-type:access_token\","
                            + " \"token_type\": \"Bearer\", \"expires_in\": 3600}";
                    byte[] payload = jsonOk.getBytes(StandardCharsets.UTF_8);
                    String response =
                        "HTTP/1.1 200 OK\r\n"
                            + "Content-Type: application/json\r\n"
                            + "Content-Length: "
                            + payload.length
                            + "\r\n"
                            + "Connection: close\r\n\r\n";
                    os.write(response.getBytes(StandardCharsets.UTF_8));
                    os.write(payload);
                    os.flush();
                  }
                } catch (Exception e) {
                  if (running) {
                    e.printStackTrace();
                  }
                }
              }
            });
    serverThread.setDaemon(true);
    serverThread.start();
  }

  private SSLContext createServerSslContext() throws Exception {
    KeyStore keyStore = createKeyStoreFromPem(serverCertPath, serverKeyPath, "server");
    KeyManagerFactory kmf = KeyManagerFactory.getInstance(KeyManagerFactory.getDefaultAlgorithm());
    kmf.init(keyStore, "password".toCharArray());

    KeyStore trustStore = KeyStore.getInstance(KeyStore.getDefaultType());
    trustStore.load(null, null);
    addCertToTrustStore(trustStore, cert1Path, "client-v1");
    addCertToTrustStore(trustStore, cert2Path, "client-v2");

    TrustManagerFactory tmf =
        TrustManagerFactory.getInstance(TrustManagerFactory.getDefaultAlgorithm());
    tmf.init(trustStore);

    SSLContext sslContext = SSLContext.getInstance("TLS");
    sslContext.init(kmf.getKeyManagers(), tmf.getTrustManagers(), null);
    return sslContext;
  }

  private void addCertToTrustStore(KeyStore trustStore, Path certPath, String alias)
      throws Exception {
    try (InputStream in = new FileInputStream(certPath.toFile())) {
      CertificateFactory cf = CertificateFactory.getInstance("X.509");
      X509Certificate cert = (X509Certificate) cf.generateCertificate(in);
      trustStore.setCertificateEntry(alias, cert);
    }
  }

  private KeyStore createKeyStoreFromPem(Path certPath, Path keyPath, String alias)
      throws Exception {
    CertificateFactory cf = CertificateFactory.getInstance("X.509");
    X509Certificate cert;
    try (InputStream certIn = new FileInputStream(certPath.toFile())) {
      cert = (X509Certificate) cf.generateCertificate(certIn);
    }

    String pemKey =
        new String(Files.readAllBytes(keyPath), StandardCharsets.UTF_8)
            .replace("-----BEGIN PRIVATE KEY-----", "")
            .replace("-----END PRIVATE KEY-----", "")
            .replaceAll("\\s", "");
    byte[] keyBytes = Base64.getDecoder().decode(pemKey);
    PKCS8EncodedKeySpec spec = new PKCS8EncodedKeySpec(keyBytes);
    KeyFactory kf = KeyFactory.getInstance("RSA");
    PrivateKey privateKey = kf.generatePrivate(spec);

    KeyStore ks = KeyStore.getInstance("PKCS12");
    ks.load(null, null);
    ks.setKeyEntry(alias, privateKey, "password".toCharArray(), new Certificate[] {cert});
    return ks;
  }
}
