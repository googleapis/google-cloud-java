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

package com.google.auth.oauth2;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertTrue;

import com.google.api.client.json.GenericJson;
import com.google.auth.mtls.MtlsHttpTransportFactory;
import com.google.auth.mtls.X509Provider;
import com.sun.net.httpserver.HttpExchange;
import com.sun.net.httpserver.HttpHandler;
import com.sun.net.httpserver.HttpsConfigurator;
import com.sun.net.httpserver.HttpsExchange;
import com.sun.net.httpserver.HttpsParameters;
import com.sun.net.httpserver.HttpsServer;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.InetSocketAddress;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
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
import java.util.concurrent.atomic.AtomicInteger;
import javax.net.ssl.KeyManagerFactory;
import javax.net.ssl.SSLContext;
import javax.net.ssl.SSLEngine;
import javax.net.ssl.SSLParameters;
import javax.net.ssl.TrustManagerFactory;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.io.TempDir;

/**
 * End-to-end integration and manual verification test infrastructure for:
 * 1) mTLS Dynamic Certificate Rotation (MtlsHttpTransportFactory + X509Provider)
 * 2) STS 401 Unauthorized Retry Loop over real local HTTPS sockets requiring mTLS
 */
public class MtlsCertRotationIntegrationTest {

  @TempDir Path tempDir;

  private HttpsServer server;
  private int serverPort;
  private final List<String> peerCertificatesReceived = Collections.synchronizedList(new ArrayList<>());
  private final AtomicInteger requestCounter = new AtomicInteger(0);

  private Path certConfigPath;
  private Path activeCertPath;
  private Path activeKeyPath;
  private Path cert1Path;
  private Path key1Path;
  private Path cert2Path;
  private Path key2Path;
  private String oldTrustStore;
  private String oldTrustStorePassword;

  @BeforeEach
  void setUp() throws Exception {
    generateCertificates();

    activeCertPath = tempDir.resolve("active_client.crt");
    activeKeyPath = tempDir.resolve("active_client.pem.key");
    Files.copy(cert1Path, activeCertPath, StandardCopyOption.REPLACE_EXISTING);
    Files.copy(key1Path, activeKeyPath, StandardCopyOption.REPLACE_EXISTING);

    certConfigPath = tempDir.resolve("certificate_config.json");
    String configJson =
        "{\n"
            + "  \"cert_configs\": {\n"
            + "    \"workload\": {\n"
            + "      \"cert_path\": \"" + activeCertPath.toString().replace("\\", "/") + "\",\n"
            + "      \"key_path\": \"" + activeKeyPath.toString().replace("\\", "/") + "\"\n"
            + "    }\n"
            + "  }\n"
            + "}\n";
    Files.write(certConfigPath, configJson.getBytes(StandardCharsets.UTF_8));

    // Save previous truststore properties and set to our temporary client truststore
    oldTrustStore = System.getProperty("javax.net.ssl.trustStore");
    oldTrustStorePassword = System.getProperty("javax.net.ssl.trustStorePassword");

    Path clientTrustStorePath = tempDir.resolve("client_truststore.p12");
    KeyStore clientTrustStore = KeyStore.getInstance("PKCS12");
    clientTrustStore.load(null, null);
    addCertToTrustStore(clientTrustStore, tempDir.resolve("server.crt"), "server");
    try (FileOutputStream fos = new FileOutputStream(clientTrustStorePath.toFile())) {
      clientTrustStore.store(fos, "password".toCharArray());
    }

    System.setProperty("javax.net.ssl.trustStore", clientTrustStorePath.toString());
    System.setProperty("javax.net.ssl.trustStorePassword", "password");

    startLocalMtlsServer();
  }

  @AfterEach
  void tearDown() {
    if (server != null) {
      server.stop(0);
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
    System.out.println("=== Starting End-to-End mTLS Certificate Rotation Integration Test ===");

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
        StsTokenExchangeRequest.newBuilder("subject_token_payload", "urn:ietf:params:oauth:token-type:id_token")
            .setAudience("//iam.googleapis.com/projects/123/locations/global/workloadIdentityPools/pool/providers/provider")
            .build();

    AccessToken accessToken = credential.exchangeExternalCredentialForAccessToken(stsRequest);

    assertNotNull(accessToken);
    assertEquals("access_token_via_rotated_mtls_cert_v2", accessToken.getTokenValue());
    assertEquals(2, requestCounter.get());
    assertEquals(2, peerCertificatesReceived.size());

    assertTrue(peerCertificatesReceived.get(0).contains("CN=client-v1"));
    assertTrue(peerCertificatesReceived.get(1).contains("CN=client-v2"));

    System.out.println("=== Verified: Cert V1 -> 401 -> Cert Rotation -> Cert V2 -> 200 OK Token Received! ===");
  }

  private void generateCertificates() throws Exception {
    cert1Path = tempDir.resolve("cert1.crt");
    key1Path = tempDir.resolve("cert1.pem.key");
    cert2Path = tempDir.resolve("cert2.crt");
    key2Path = tempDir.resolve("cert2.pem.key");
    Path serverCertPath = tempDir.resolve("server.crt");
    Path serverKeyPath = tempDir.resolve("server.pem.key");

    runOpenSslCommandWithSan(serverKeyPath, serverCertPath, "/CN=127.0.0.1", "subjectAltName=IP:127.0.0.1,DNS:localhost");
    runOpenSslCommand(key1Path, cert1Path, "/CN=client-v1");
    runOpenSslCommand(key2Path, cert2Path, "/CN=client-v2");
  }

  private void runOpenSslCommand(Path keyOut, Path certOut, String subj) throws Exception {
    runOpenSslCommandWithSan(keyOut, certOut, subj, null);
  }

  private void runOpenSslCommandWithSan(Path keyOut, Path certOut, String subj, String sanExt) throws Exception {
    List<String> cmd = new ArrayList<>();
    cmd.add("openssl");
    cmd.add("req");
    cmd.add("-x509");
    cmd.add("-newkey");
    cmd.add("rsa:2048");
    cmd.add("-keyout");
    cmd.add(keyOut.toString());
    cmd.add("-out");
    cmd.add(certOut.toString());
    cmd.add("-days");
    cmd.add("1");
    cmd.add("-nodes");
    cmd.add("-subj");
    cmd.add(subj);
    if (sanExt != null) {
      cmd.add("-addext");
      cmd.add(sanExt);
    }
    ProcessBuilder pb = new ProcessBuilder(cmd);
    int exitCode = pb.start().waitFor();
    if (exitCode != 0) {
      throw new RuntimeException("OpenSSL cert generation failed for " + subj);
    }
  }

  private void startLocalMtlsServer() throws Exception {
    server = HttpsServer.create(new InetSocketAddress("127.0.0.1", 0), 0);
    serverPort = server.getAddress().getPort();

    SSLContext serverSslContext = createServerSslContext();
    server.setHttpsConfigurator(
        new HttpsConfigurator(serverSslContext) {
          @Override
          public void configure(HttpsParameters params) {
            SSLEngine engine = serverSslContext.createSSLEngine();
            SSLParameters sslParams = serverSslContext.getDefaultSSLParameters();
            sslParams.setNeedClientAuth(true);
            params.setSSLParameters(sslParams);
          }
        });

    server.createContext(
        "/sts/token",
        new HttpHandler() {
          @Override
          public void handle(HttpExchange exchange) throws IOException {
            int count = requestCounter.incrementAndGet();
            String peerPrincipalName = "UNKNOWN";
            try {
              if (exchange instanceof HttpsExchange) {
                Certificate[] certs = ((HttpsExchange) exchange).getSSLSession().getPeerCertificates();
                if (certs != null && certs.length > 0 && certs[0] instanceof X509Certificate) {
                  peerPrincipalName = ((X509Certificate) certs[0]).getSubjectX500Principal().getName();
                  peerCertificatesReceived.add(peerPrincipalName);
                }
              }
            } catch (Exception e) {
              e.printStackTrace();
            }

            System.out.printf(
                "| Server Handler | Request #%d received peer certificate: %s%n",
                count, peerPrincipalName);

            if (peerPrincipalName.contains("client-v1")) {
              try {
                Files.copy(cert2Path, activeCertPath, StandardCopyOption.REPLACE_EXISTING);
                Files.copy(key2Path, activeKeyPath, StandardCopyOption.REPLACE_EXISTING);
                System.out.println(
                    "| Server Handler | Simulating cert rotation on disk: active cert is now Client Cert V2");
              } catch (Exception e) {
                e.printStackTrace();
              }

              String errorResponse =
                  "{\"error\": \"invalid_grant\", \"error_description\": \"mTLS Certificate Expired\"}";
              byte[] bytes = errorResponse.getBytes(StandardCharsets.UTF_8);
              exchange.getResponseHeaders().set("Content-Type", "application/json");
              exchange.sendResponseHeaders(401, bytes.length);
              try (OutputStream os = exchange.getResponseBody()) {
                os.write(bytes);
              }
            } else {
              String tokenResponse =
                  "{\"access_token\": \"access_token_via_rotated_mtls_cert_v2\","
                      + " \"issued_token_type\": \"urn:ietf:params:oauth:token-type:access_token\","
                      + " \"token_type\": \"Bearer\", \"expires_in\": 3600}";
              byte[] bytes = tokenResponse.getBytes(StandardCharsets.UTF_8);
              exchange.getResponseHeaders().set("Content-Type", "application/json");
              exchange.sendResponseHeaders(200, bytes.length);
              try (OutputStream os = exchange.getResponseBody()) {
                os.write(bytes);
              }
            }
          }
        });

    server.start();
  }

  private SSLContext createServerSslContext() throws Exception {
    Path serverCertPath = tempDir.resolve("server.crt");
    Path serverKeyPath = tempDir.resolve("server.pem.key");

    KeyStore keyStore = createKeyStoreFromPem(serverCertPath, serverKeyPath, "server");
    KeyManagerFactory kmf = KeyManagerFactory.getInstance(KeyManagerFactory.getDefaultAlgorithm());
    kmf.init(keyStore, "password".toCharArray());

    KeyStore trustStore = KeyStore.getInstance(KeyStore.getDefaultType());
    trustStore.load(null, null);
    addCertToTrustStore(trustStore, cert1Path, "client-v1");
    addCertToTrustStore(trustStore, cert2Path, "client-v2");

    TrustManagerFactory tmf = TrustManagerFactory.getInstance(TrustManagerFactory.getDefaultAlgorithm());
    tmf.init(trustStore);

    SSLContext sslContext = SSLContext.getInstance("TLS");
    sslContext.init(kmf.getKeyManagers(), tmf.getTrustManagers(), null);
    return sslContext;
  }

  private void addCertToTrustStore(KeyStore trustStore, Path certPath, String alias) throws Exception {
    try (InputStream in = new FileInputStream(certPath.toFile())) {
      CertificateFactory cf = CertificateFactory.getInstance("X.509");
      X509Certificate cert = (X509Certificate) cf.generateCertificate(in);
      trustStore.setCertificateEntry(alias, cert);
    }
  }

  private KeyStore createKeyStoreFromPem(Path certPath, Path keyPath, String alias) throws Exception {
    CertificateFactory cf = CertificateFactory.getInstance("X.509");
    X509Certificate cert;
    try (InputStream certIn = new FileInputStream(certPath.toFile())) {
      cert = (X509Certificate) cf.generateCertificate(certIn);
    }

    String pemKey = new String(Files.readAllBytes(keyPath), StandardCharsets.UTF_8)
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
