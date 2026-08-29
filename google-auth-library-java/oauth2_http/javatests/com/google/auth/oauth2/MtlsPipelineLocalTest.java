/*
 * Copyright 2026 Google LLC
 *
 * Redistribution and use in source and binary forms, with or without
 * modification, are permitted provided that the following conditions are
 * met:
 *
 *    * Redistributions of source code must retain the above copyright
 * notice, this list of conditions and the following disclaimer.
 *    * Redistributions in binary form must reproduce the above
 * copyright notice, this list of conditions and the following disclaimer
 * in the documentation and/or other materials provided with the
 * distribution.
 *    * Neither the name of Google LLC nor the names of its
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
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertTrue;

import com.google.api.client.json.GenericJson;
import com.google.api.client.util.SecurityUtils;
import com.google.auth.http.HttpTransportFactory;
import com.google.auth.mtls.MtlsHttpTransportFactory;
import com.google.auth.oauth2.ExternalAccountCredentials.SubjectTokenTypes;
import com.sun.net.httpserver.HttpExchange;
import com.sun.net.httpserver.HttpHandler;
import com.sun.net.httpserver.HttpsConfigurator;
import com.sun.net.httpserver.HttpsExchange;
import com.sun.net.httpserver.HttpsParameters;
import com.sun.net.httpserver.HttpsServer;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.SequenceInputStream;
import java.net.InetSocketAddress;
import java.net.URLDecoder;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.security.KeyStore;
import java.security.SecureRandom;
import java.security.cert.Certificate;
import java.security.cert.CertificateFactory;
import java.security.cert.X509Certificate;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.Callable;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicReference;
import javax.net.ssl.HostnameVerifier;
import javax.net.ssl.HttpsURLConnection;
import javax.net.ssl.KeyManagerFactory;
import javax.net.ssl.SSLContext;
import javax.net.ssl.SSLEngine;
import javax.net.ssl.SSLParameters;
import javax.net.ssl.SSLSession;
import javax.net.ssl.TrustManagerFactory;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.io.TempDir;

/**
 * Hermetic in-process socket test suite for the mTLS OAuth token exchange pipeline.
 *
 * <p>Spins up an in-process JDK {@link HttpsServer} on {@code localhost} requiring client
 * authentication ({@code setNeedClientAuth(true)}), validating peer certificates and request
 * payloads across mTLS token exchanges, 401 retry with cert reloading, concurrent refreshes, and
 * atomic token reads.
 */
class MtlsPipelineLocalTest {

  private static final String TEST_CERT_PATH = "testresources/mtls/test_cert.pem";
  private static final String TEST_KEY_PATH = "testresources/mtls/test_key.pem";
  private static final String AUDIENCE =
      "//iam.googleapis.com/projects/123/locations/global/workloadIdentityPools/pool/providers/provider";
  private static final String ACCESS_TOKEN_TYPE = "urn:ietf:params:oauth:token-type:access_token";

  private static File tempTrustStoreFile;
  private static HostnameVerifier originalHostnameVerifier;
  private static String originalTrustStore;
  private static String originalTrustStorePassword;
  private static String originalTrustStoreType;

  private HttpsServer server;
  private int serverPort;
  private ExecutorService serverExecutor;

  @BeforeAll
  static void beforeAll() throws Exception {
    originalHostnameVerifier = HttpsURLConnection.getDefaultHostnameVerifier();
    HttpsURLConnection.setDefaultHostnameVerifier((hostname, session) -> true);

    originalTrustStore = System.getProperty("javax.net.ssl.trustStore");
    originalTrustStorePassword = System.getProperty("javax.net.ssl.trustStorePassword");
    originalTrustStoreType = System.getProperty("javax.net.ssl.trustStoreType");

    // Create a truststore containing test_cert.pem so client NetHttpTransport trusts the server
    KeyStore trustStore = KeyStore.getInstance(KeyStore.getDefaultType());
    trustStore.load(null, null);
    CertificateFactory cf = CertificateFactory.getInstance("X.509");
    try (FileInputStream fis = new FileInputStream(new File(TEST_CERT_PATH))) {
      Certificate cert = cf.generateCertificate(fis);
      trustStore.setCertificateEntry("server-cert", cert);
    }

    tempTrustStoreFile = File.createTempFile("mtls_test_truststore", ".jks");
    tempTrustStoreFile.deleteOnExit();
    try (FileOutputStream fos = new FileOutputStream(tempTrustStoreFile)) {
      trustStore.store(fos, "changeit".toCharArray());
    }

    System.setProperty("javax.net.ssl.trustStore", tempTrustStoreFile.getAbsolutePath());
    System.setProperty("javax.net.ssl.trustStorePassword", "changeit");
    System.setProperty("javax.net.ssl.trustStoreType", KeyStore.getDefaultType());
  }

  @AfterAll
  static void afterAll() {
    if (originalHostnameVerifier != null) {
      HttpsURLConnection.setDefaultHostnameVerifier(originalHostnameVerifier);
    }
    if (originalTrustStore != null) {
      System.setProperty("javax.net.ssl.trustStore", originalTrustStore);
    } else {
      System.clearProperty("javax.net.ssl.trustStore");
    }
    if (originalTrustStorePassword != null) {
      System.setProperty("javax.net.ssl.trustStorePassword", originalTrustStorePassword);
    } else {
      System.clearProperty("javax.net.ssl.trustStorePassword");
    }
    if (originalTrustStoreType != null) {
      System.setProperty("javax.net.ssl.trustStoreType", originalTrustStoreType);
    } else {
      System.clearProperty("javax.net.ssl.trustStoreType");
    }
    if (tempTrustStoreFile != null && tempTrustStoreFile.exists()) {
      tempTrustStoreFile.delete();
    }
  }

  @BeforeEach
  void setUp() throws Exception {
    SSLContext sslContext = createServerSSLContext();
    server = HttpsServer.create(new InetSocketAddress("localhost", 0), 0);
    server.setHttpsConfigurator(
        new HttpsConfigurator(sslContext) {
          @Override
          public void configure(HttpsParameters params) {
            try {
              SSLContext context = getSSLContext();
              SSLEngine engine = context.createSSLEngine();
              SSLParameters sslParams = context.getDefaultSSLParameters();
              sslParams.setNeedClientAuth(true);
              sslParams.setCipherSuites(engine.getEnabledCipherSuites());
              sslParams.setProtocols(engine.getEnabledProtocols());
              params.setSSLParameters(sslParams);
            } catch (Exception e) {
              throw new RuntimeException("Failed to configure HttpsServer mTLS", e);
            }
          }
        });

    serverExecutor = Executors.newCachedThreadPool();
    server.setExecutor(serverExecutor);
  }

  @AfterEach
  void tearDown() {
    if (server != null) {
      server.stop(0);
    }
    if (serverExecutor != null) {
      serverExecutor.shutdownNow();
    }
  }

  private static SSLContext createServerSSLContext() throws Exception {
    KeyStore serverKeyStore;
    try (InputStream certStream = new FileInputStream(new File(TEST_CERT_PATH));
        InputStream keyStream = new FileInputStream(new File(TEST_KEY_PATH));
        InputStream combined = new SequenceInputStream(certStream, keyStream)) {
      serverKeyStore = SecurityUtils.createMtlsKeyStore(combined);
    }

    KeyManagerFactory kmf = KeyManagerFactory.getInstance(KeyManagerFactory.getDefaultAlgorithm());
    kmf.init(serverKeyStore, "".toCharArray());

    KeyStore trustStore = KeyStore.getInstance(KeyStore.getDefaultType());
    trustStore.load(null, null);
    CertificateFactory cf = CertificateFactory.getInstance("X.509");
    try (FileInputStream fis = new FileInputStream(new File(TEST_CERT_PATH))) {
      Certificate cert = cf.generateCertificate(fis);
      trustStore.setCertificateEntry("client-cert", cert);
    }

    TrustManagerFactory tmf =
        TrustManagerFactory.getInstance(TrustManagerFactory.getDefaultAlgorithm());
    tmf.init(trustStore);

    SSLContext sslContext = SSLContext.getInstance("TLS");
    sslContext.init(kmf.getKeyManagers(), tmf.getTrustManagers(), new SecureRandom());
    return sslContext;
  }

  private static KeyStore createClientKeyStore() throws Exception {
    try (InputStream certStream = new FileInputStream(new File(TEST_CERT_PATH));
        InputStream keyStream = new FileInputStream(new File(TEST_KEY_PATH));
        InputStream combined = new SequenceInputStream(certStream, keyStream)) {
      return SecurityUtils.createMtlsKeyStore(combined);
    }
  }

  private static Map<String, String> parseFormData(String body) throws Exception {
    Map<String, String> params = new HashMap<>();
    for (String pair : body.split("&")) {
      int idx = pair.indexOf("=");
      if (idx > 0) {
        String key = URLDecoder.decode(pair.substring(0, idx), "UTF-8");
        String value = URLDecoder.decode(pair.substring(idx + 1), "UTF-8");
        params.put(key, value);
      }
    }
    return params;
  }

  private static String readRequestBody(HttpExchange exchange) throws IOException {
    try (InputStream is = exchange.getRequestBody();
        ByteArrayOutputStream baos = new ByteArrayOutputStream()) {
      byte[] buf = new byte[1024];
      int read;
      while ((read = is.read(buf)) != -1) {
        baos.write(buf, 0, read);
      }
      return baos.toString(StandardCharsets.UTF_8.name());
    }
  }

  private static void sendJsonResponse(HttpExchange exchange, int statusCode, String json)
      throws IOException {
    byte[] bytes = json.getBytes(StandardCharsets.UTF_8);
    exchange.getResponseHeaders().set("Content-Type", "application/json; charset=utf-8");
    if (statusCode == 401) {
      exchange.getResponseHeaders().set("WWW-Authenticate", "Bearer realm=\"oauth\"");
    }
    exchange.sendResponseHeaders(statusCode, bytes.length);
    try (OutputStream os = exchange.getResponseBody()) {
      os.write(bytes);
      os.flush();
    }
  }

  /**
   * Scenario A: testMtlsPipeline_verifiesPeerCertAndPayload
   *
   * <p>Verify server receives client certificate via SSLSession.getPeerCertificates(), checks token
   * exchange request body (grant_type, subject_token, actor_token, actor_token_type), and returns
   * access token.
   */
  @Test
  void testMtlsPipeline_verifiesPeerCertAndPayload(@TempDir Path tempDir) throws Exception {
    AtomicReference<Certificate[]> capturedCerts = new AtomicReference<>();
    AtomicReference<Map<String, String>> capturedParams = new AtomicReference<>();

    server.createContext(
        "/v1/token",
        new HttpHandler() {
          @Override
          public void handle(HttpExchange exchange) throws IOException {
            try {
              HttpsExchange httpsExchange = (HttpsExchange) exchange;
              SSLSession session = httpsExchange.getSSLSession();
              capturedCerts.set(session.getPeerCertificates());

              String body = readRequestBody(exchange);
              capturedParams.set(parseFormData(body));

              GenericJson response = new GenericJson();
              response.setFactory(OAuth2Utils.JSON_FACTORY);
              response.put("access_token", "test_access_token_payload_verified");
              response.put("token_type", "Bearer");
              response.put("expires_in", 3600);
              response.put("issued_token_type", ACCESS_TOKEN_TYPE);
              sendJsonResponse(exchange, 200, response.toPrettyString());
            } catch (Exception e) {
              sendJsonResponse(exchange, 500, "{\"error\": \"" + e.getMessage() + "\"}");
            }
          }
        });
    server.start();
    serverPort = server.getAddress().getPort();

    Path tokenFile = tempDir.resolve("credential.json");
    GenericJson tokenJson = new GenericJson();
    tokenJson.setFactory(OAuth2Utils.JSON_FACTORY);
    tokenJson.put("subject_token", "testSubjectTokenPayload123");
    tokenJson.put("actor_token", "testActorTokenPayload456");
    OAuth2Utils.writeInputStreamToFile(
        new ByteArrayInputStream(tokenJson.toPrettyString().getBytes(StandardCharsets.UTF_8)),
        tokenFile.toString());

    String configJson =
        "{\n"
            + "  \"type\": \"external_account\",\n"
            + "  \"audience\": \""
            + AUDIENCE
            + "\",\n"
            + "  \"subject_token_type\": \"urn:ietf:params:oauth:token-type:jwt\",\n"
            + "  \"actor_token_type\": \"urn:ietf:params:oauth:token-type:jwt\",\n"
            + "  \"token_url\": \"https://localhost:"
            + serverPort
            + "/v1/token\",\n"
            + "  \"credential_source\": {\n"
            + "    \"file\": \""
            + tokenFile.toString()
            + "\",\n"
            + "    \"format\": {\n"
            + "      \"type\": \"json\",\n"
            + "      \"subject_token_field_name\": \"subject_token\",\n"
            + "      \"actor_token_field_name\": \"actor_token\"\n"
            + "    },\n"
            + "    \"certificate\": {\n"
            + "      \"certificate_config_location\": \"testresources/mtls/certificate_config.json\"\n"
            + "    }\n"
            + "  }\n"
            + "}";

    IdentityPoolCredentials credentials =
        (IdentityPoolCredentials)
            ExternalAccountCredentials.fromStream(
                new ByteArrayInputStream(configJson.getBytes(StandardCharsets.UTF_8)));

    AccessToken accessToken = credentials.refreshAccessToken();
    assertEquals("test_access_token_payload_verified", accessToken.getTokenValue());

    // Verify peer certificates captured on server
    Certificate[] peerCerts = capturedCerts.get();
    assertNotNull(peerCerts);
    assertTrue(peerCerts.length > 0);
    assertTrue(peerCerts[0] instanceof X509Certificate);
    X509Certificate clientCert = (X509Certificate) peerCerts[0];
    assertTrue(
        clientCert
            .getSubjectX500Principal()
            .getName()
            .contains("1009120726878.apps.googleusercontent.com"));

    // Verify request payload form parameters
    Map<String, String> params = capturedParams.get();
    assertNotNull(params);
    assertEquals("urn:ietf:params:oauth:grant-type:token-exchange", params.get("grant_type"));
    assertEquals(AUDIENCE, params.get("audience"));
    assertEquals("testSubjectTokenPayload123", params.get("subject_token"));
    assertEquals("urn:ietf:params:oauth:token-type:jwt", params.get("subject_token_type"));
    assertEquals("testActorTokenPayload456", params.get("actor_token"));
    assertEquals("urn:ietf:params:oauth:token-type:jwt", params.get("actor_token_type"));
    assertEquals(
        "urn:ietf:params:oauth:token-type:access_token", params.get("requested_token_type"));
  }

  /**
   * Scenario B: testMtlsPipeline_401Retry_reReadsCertFromDisk
   *
   * <p>Verify that when server responds with 401 Unauthorized on initial exchange,
   * IdentityPoolCredentials catches it, re-reads fresh KeyStore from X509Provider, and retries the
   * exchange successfully.
   */
  @Test
  void testMtlsPipeline_401Retry_reReadsCertFromDisk(@TempDir Path tempDir) throws Exception {
    AtomicInteger requestCount = new AtomicInteger(0);
    List<Certificate[]> certsPerRequest = new ArrayList<>();

    server.createContext(
        "/v1/token",
        new HttpHandler() {
          @Override
          public void handle(HttpExchange exchange) throws IOException {
            try {
              HttpsExchange httpsExchange = (HttpsExchange) exchange;
              SSLSession session = httpsExchange.getSSLSession();
              synchronized (certsPerRequest) {
                certsPerRequest.add(session.getPeerCertificates());
              }

              // Always read and drain the request body
              String body = readRequestBody(exchange);

              int count = requestCount.incrementAndGet();
              if (count == 1) {
                // Initial exchange responds with 401 Unauthorized
                GenericJson error = new GenericJson();
                error.setFactory(OAuth2Utils.JSON_FACTORY);
                error.put("error", "invalid_client");
                error.put("error_description", "Certificate rotation required");
                sendJsonResponse(exchange, 401, error.toPrettyString());
              } else {
                // Second exchange succeeds with 200 OK
                GenericJson response = new GenericJson();
                response.setFactory(OAuth2Utils.JSON_FACTORY);
                response.put("access_token", "retry_success_token_401_handled");
                response.put("token_type", "Bearer");
                response.put("expires_in", 3600);
                response.put("issued_token_type", ACCESS_TOKEN_TYPE);
                sendJsonResponse(exchange, 200, response.toPrettyString());
              }
            } catch (Exception e) {
              sendJsonResponse(exchange, 500, "{\"error\": \"" + e.getMessage() + "\"}");
            }
          }
        });
    server.start();
    serverPort = server.getAddress().getPort();

    Path tokenFile = tempDir.resolve("credential.json");
    GenericJson tokenJson = new GenericJson();
    tokenJson.setFactory(OAuth2Utils.JSON_FACTORY);
    tokenJson.put("subject_token", "testSubjectToken401");
    tokenJson.put("actor_token", "testActorToken401");
    OAuth2Utils.writeInputStreamToFile(
        new ByteArrayInputStream(tokenJson.toPrettyString().getBytes(StandardCharsets.UTF_8)),
        tokenFile.toString());

    String configJson =
        "{\n"
            + "  \"type\": \"external_account\",\n"
            + "  \"audience\": \""
            + AUDIENCE
            + "\",\n"
            + "  \"subject_token_type\": \"urn:ietf:params:oauth:token-type:jwt\",\n"
            + "  \"actor_token_type\": \"urn:ietf:params:oauth:token-type:jwt\",\n"
            + "  \"token_url\": \"https://localhost:"
            + serverPort
            + "/v1/token\",\n"
            + "  \"credential_source\": {\n"
            + "    \"file\": \""
            + tokenFile.toString()
            + "\",\n"
            + "    \"format\": {\n"
            + "      \"type\": \"json\",\n"
            + "      \"subject_token_field_name\": \"subject_token\",\n"
            + "      \"actor_token_field_name\": \"actor_token\"\n"
            + "    },\n"
            + "    \"certificate\": {\n"
            + "      \"certificate_config_location\": \"testresources/mtls/certificate_config.json\"\n"
            + "    }\n"
            + "  }\n"
            + "}";

    IdentityPoolCredentials credentials =
        (IdentityPoolCredentials)
            ExternalAccountCredentials.fromStream(
                new ByteArrayInputStream(configJson.getBytes(StandardCharsets.UTF_8)));

    AccessToken accessToken = credentials.refreshAccessToken();
    assertEquals("retry_success_token_401_handled", accessToken.getTokenValue());
    assertEquals(2, requestCount.get());
    assertEquals(2, certsPerRequest.size());
    assertNotNull(certsPerRequest.get(0));
    assertNotNull(certsPerRequest.get(1));
    assertTrue(certsPerRequest.get(0).length > 0);
    assertTrue(certsPerRequest.get(1).length > 0);
    assertTrue(certsPerRequest.get(0)[0] instanceof X509Certificate);
    assertTrue(certsPerRequest.get(1)[0] instanceof X509Certificate);
    assertEquals(
        ((X509Certificate) certsPerRequest.get(0)[0]).getSubjectX500Principal(),
        ((X509Certificate) certsPerRequest.get(1)[0]).getSubjectX500Principal());
  }

  /**
   * Scenario C: testMtlsPipeline_concurrentRefreshes
   *
   * <p>Multi-threaded refresh verifying independent transport snapshots per thread without
   * socket/cert race conditions.
   */
  @Test
  void testMtlsPipeline_concurrentRefreshes(@TempDir Path tempDir) throws Exception {
    AtomicInteger requestCounter = new AtomicInteger(0);

    server.createContext(
        "/v1/token",
        new HttpHandler() {
          @Override
          public void handle(HttpExchange exchange) throws IOException {
            try {
              HttpsExchange httpsExchange = (HttpsExchange) exchange;
              SSLSession session = httpsExchange.getSSLSession();
              Certificate[] certs = session.getPeerCertificates();
              if (certs == null || certs.length == 0) {
                sendJsonResponse(exchange, 403, "{\"error\": \"missing_peer_cert\"}");
                return;
              }

              // Always read and drain the request body
              String body = readRequestBody(exchange);

              int count = requestCounter.incrementAndGet();
              GenericJson response = new GenericJson();
              response.setFactory(OAuth2Utils.JSON_FACTORY);
              response.put("access_token", "concurrent_token_" + count);
              response.put("token_type", "Bearer");
              response.put("expires_in", 3600);
              response.put("issued_token_type", ACCESS_TOKEN_TYPE);
              sendJsonResponse(exchange, 200, response.toPrettyString());
            } catch (Exception e) {
              sendJsonResponse(exchange, 500, "{\"error\": \"" + e.getMessage() + "\"}");
            }
          }
        });
    server.start();
    serverPort = server.getAddress().getPort();

    Path tokenFile = tempDir.resolve("credential.json");
    GenericJson tokenJson = new GenericJson();
    tokenJson.setFactory(OAuth2Utils.JSON_FACTORY);
    tokenJson.put("subject_token", "concurrentSubjectToken");
    tokenJson.put("actor_token", "concurrentActorToken");
    OAuth2Utils.writeInputStreamToFile(
        new ByteArrayInputStream(tokenJson.toPrettyString().getBytes(StandardCharsets.UTF_8)),
        tokenFile.toString());

    String configJson =
        "{\n"
            + "  \"type\": \"external_account\",\n"
            + "  \"audience\": \""
            + AUDIENCE
            + "\",\n"
            + "  \"subject_token_type\": \"urn:ietf:params:oauth:token-type:jwt\",\n"
            + "  \"actor_token_type\": \"urn:ietf:params:oauth:token-type:jwt\",\n"
            + "  \"token_url\": \"https://localhost:"
            + serverPort
            + "/v1/token\",\n"
            + "  \"credential_source\": {\n"
            + "    \"file\": \""
            + tokenFile.toString()
            + "\",\n"
            + "    \"format\": {\n"
            + "      \"type\": \"json\",\n"
            + "      \"subject_token_field_name\": \"subject_token\",\n"
            + "      \"actor_token_field_name\": \"actor_token\"\n"
            + "    },\n"
            + "    \"certificate\": {\n"
            + "      \"certificate_config_location\": \"testresources/mtls/certificate_config.json\"\n"
            + "    }\n"
            + "  }\n"
            + "}";

    IdentityPoolCredentials credentials =
        (IdentityPoolCredentials)
            ExternalAccountCredentials.fromStream(
                new ByteArrayInputStream(configJson.getBytes(StandardCharsets.UTF_8)));

    int concurrency = 8;
    ExecutorService clientExecutor = Executors.newFixedThreadPool(concurrency);
    CountDownLatch startLatch = new CountDownLatch(1);
    List<Future<AccessToken>> futures = new ArrayList<>();

    for (int i = 0; i < concurrency; i++) {
      futures.add(
          clientExecutor.submit(
              new Callable<AccessToken>() {
                @Override
                public AccessToken call() throws Exception {
                  startLatch.await();
                  return credentials.refreshAccessToken();
                }
              }));
    }

    // Release all client threads concurrently
    startLatch.countDown();

    for (Future<AccessToken> future : futures) {
      AccessToken token = future.get(10, TimeUnit.SECONDS);
      assertNotNull(token);
      assertTrue(token.getTokenValue().startsWith("concurrent_token_"));
    }

    clientExecutor.shutdown();
    assertTrue(clientExecutor.awaitTermination(5, TimeUnit.SECONDS));
    assertEquals(concurrency, requestCounter.get());
  }

  /**
   * Scenario D: testMtlsPipeline_atomicTokenRead
   *
   * <p>Verify single-pass file read of subject + actor tokens from the same JSON file.
   */
  @Test
  void testMtlsPipeline_atomicTokenRead(@TempDir Path tempDir) throws Exception {
    AtomicReference<Map<String, String>> capturedParams = new AtomicReference<>();

    server.createContext(
        "/v1/token",
        new HttpHandler() {
          @Override
          public void handle(HttpExchange exchange) throws IOException {
            try {
              String body = readRequestBody(exchange);
              capturedParams.set(parseFormData(body));

              GenericJson response = new GenericJson();
              response.setFactory(OAuth2Utils.JSON_FACTORY);
              response.put("access_token", "atomic_token_verified");
              response.put("token_type", "Bearer");
              response.put("expires_in", 3600);
              response.put("issued_token_type", ACCESS_TOKEN_TYPE);
              sendJsonResponse(exchange, 200, response.toPrettyString());
            } catch (Exception e) {
              sendJsonResponse(exchange, 500, "{\"error\": \"" + e.getMessage() + "\"}");
            }
          }
        });
    server.start();
    serverPort = server.getAddress().getPort();

    Path tokenFile = tempDir.resolve("credential.json");
    GenericJson tokenJson = new GenericJson();
    tokenJson.setFactory(OAuth2Utils.JSON_FACTORY);
    tokenJson.put("subject_token", "atomicSubjectToken_ABC_123");
    tokenJson.put("actor_token", "atomicActorToken_XYZ_789");
    OAuth2Utils.writeInputStreamToFile(
        new ByteArrayInputStream(tokenJson.toPrettyString().getBytes(StandardCharsets.UTF_8)),
        tokenFile.toString());

    Map<String, Object> certMap = new HashMap<>();
    certMap.put("certificate_config_location", "testresources/mtls/certificate_config.json");

    Map<String, Object> formatMap = new HashMap<>();
    formatMap.put("type", "json");
    formatMap.put("subject_token_field_name", "subject_token");
    formatMap.put("actor_token_field_name", "actor_token");

    Map<String, Object> sourceMap = new HashMap<>();
    sourceMap.put("file", tokenFile.toString());
    sourceMap.put("format", formatMap);
    sourceMap.put("certificate", certMap);

    IdentityPoolCredentialSource source = new IdentityPoolCredentialSource(sourceMap);
    KeyStore clientKeyStore = createClientKeyStore();
    HttpTransportFactory transportFactory = new MtlsHttpTransportFactory(clientKeyStore);

    IdentityPoolCredentials credentials =
        IdentityPoolCredentials.newBuilder()
            .setAudience(AUDIENCE)
            .setSubjectTokenType(SubjectTokenTypes.JWT)
            .setActorTokenType(SubjectTokenTypes.JWT.value)
            .setTokenUrl("https://localhost:" + serverPort + "/v1/token")
            .setCredentialSource(source)
            .setHttpTransportFactory(transportFactory)
            .build();

    // Verify both subject and actor supplier point to the same instance
    // (FileIdentityPoolSubjectTokenSupplier)
    assertSame(
        credentials.getIdentityPoolSubjectTokenSupplier(),
        credentials.getIdentityPoolActorTokenSupplier());

    AccessToken token = credentials.refreshAccessToken();
    assertEquals("atomic_token_verified", token.getTokenValue());

    Map<String, String> params = capturedParams.get();
    assertNotNull(params);
    assertEquals("atomicSubjectToken_ABC_123", params.get("subject_token"));
    assertEquals("atomicActorToken_XYZ_789", params.get("actor_token"));
    assertEquals("urn:ietf:params:oauth:token-type:jwt", params.get("subject_token_type"));
    assertEquals("urn:ietf:params:oauth:token-type:jwt", params.get("actor_token_type"));
  }

  /**
   * Scenario E: testMtlsPipeline_withImpersonation_usesSameCertForStsAndIam
   *
   * <p>Sets up in-process HttpsServer handlers for both STS (/v1/token) and IAM
   * (/v1/projects/-/serviceAccounts/test@project.iam.gserviceaccount.com:generateAccessToken), both
   * requiring client certificates. Executes refreshAccessToken() on IdentityPoolCredentials
   * configured with serviceAccountImpersonationUrl, asserting that both STS and IAM receive the
   * client X509Certificate from SSLSession, IAM receives the Authorization header from STS, and the
   * final target access token is returned.
   */
  @Test
  void testMtlsPipeline_withImpersonation_usesSameCertForStsAndIam(@TempDir Path tempDir)
      throws Exception {
    AtomicInteger stsCallCount = new AtomicInteger(0);
    AtomicReference<Certificate[]> capturedStsCerts = new AtomicReference<>();
    AtomicReference<Map<String, String>> capturedStsParams = new AtomicReference<>();

    server.createContext(
        "/v1/token",
        new HttpHandler() {
          @Override
          public void handle(HttpExchange exchange) throws IOException {
            try {
              HttpsExchange httpsExchange = (HttpsExchange) exchange;
              SSLSession session = httpsExchange.getSSLSession();
              capturedStsCerts.set(session.getPeerCertificates());

              String body = readRequestBody(exchange);
              capturedStsParams.set(parseFormData(body));

              stsCallCount.incrementAndGet();
              GenericJson response = new GenericJson();
              response.setFactory(OAuth2Utils.JSON_FACTORY);
              response.put("access_token", "intermediate_sts_token_123");
              response.put("token_type", "Bearer");
              response.put("expires_in", 3600);
              response.put("issued_token_type", ACCESS_TOKEN_TYPE);
              sendJsonResponse(exchange, 200, response.toPrettyString());
            } catch (Exception e) {
              sendJsonResponse(exchange, 500, "{\"error\": \"" + e.getMessage() + "\"}");
            }
          }
        });

    AtomicInteger iamCallCount = new AtomicInteger(0);
    AtomicReference<Certificate[]> capturedIamCerts = new AtomicReference<>();
    AtomicReference<String> capturedIamAuthHeader = new AtomicReference<>();

    server.createContext(
        "/v1/projects/-/serviceAccounts/test@project.iam.gserviceaccount.com:generateAccessToken",
        new HttpHandler() {
          @Override
          public void handle(HttpExchange exchange) throws IOException {
            try {
              HttpsExchange httpsExchange = (HttpsExchange) exchange;
              SSLSession session = httpsExchange.getSSLSession();
              capturedIamCerts.set(session.getPeerCertificates());

              capturedIamAuthHeader.set(exchange.getRequestHeaders().getFirst("Authorization"));
              readRequestBody(exchange);

              iamCallCount.incrementAndGet();
              GenericJson response = new GenericJson();
              response.setFactory(OAuth2Utils.JSON_FACTORY);
              response.put("accessToken", "final_target_sa_access_token_456");
              response.put("expireTime", "2030-01-01T00:00:00Z");
              sendJsonResponse(exchange, 200, response.toPrettyString());
            } catch (Exception e) {
              sendJsonResponse(exchange, 500, "{\"error\": \"" + e.getMessage() + "\"}");
            }
          }
        });

    server.start();
    serverPort = server.getAddress().getPort();

    Path tokenFile = tempDir.resolve("credential.json");
    GenericJson tokenJson = new GenericJson();
    tokenJson.setFactory(OAuth2Utils.JSON_FACTORY);
    tokenJson.put("subject_token", "testSubjectTokenImpersonation");
    tokenJson.put("actor_token", "testActorTokenImpersonation");
    OAuth2Utils.writeInputStreamToFile(
        new ByteArrayInputStream(tokenJson.toPrettyString().getBytes(StandardCharsets.UTF_8)),
        tokenFile.toString());

    String iamUrl =
        "https://localhost:"
            + serverPort
            + "/v1/projects/-/serviceAccounts/test@project.iam.gserviceaccount.com:generateAccessToken";

    String configJson =
        "{\n"
            + "  \"type\": \"external_account\",\n"
            + "  \"audience\": \""
            + AUDIENCE
            + "\",\n"
            + "  \"subject_token_type\": \"urn:ietf:params:oauth:token-type:jwt\",\n"
            + "  \"actor_token_type\": \"urn:ietf:params:oauth:token-type:jwt\",\n"
            + "  \"token_url\": \"https://localhost:"
            + serverPort
            + "/v1/token\",\n"
            + "  \"service_account_impersonation_url\": \""
            + iamUrl
            + "\",\n"
            + "  \"credential_source\": {\n"
            + "    \"file\": \""
            + tokenFile.toString()
            + "\",\n"
            + "    \"format\": {\n"
            + "      \"type\": \"json\",\n"
            + "      \"subject_token_field_name\": \"subject_token\",\n"
            + "      \"actor_token_field_name\": \"actor_token\"\n"
            + "    },\n"
            + "    \"certificate\": {\n"
            + "      \"certificate_config_location\": \"testresources/mtls/certificate_config.json\"\n"
            + "    }\n"
            + "  }\n"
            + "}";

    IdentityPoolCredentials credentials =
        (IdentityPoolCredentials)
            ExternalAccountCredentials.fromStream(
                new ByteArrayInputStream(configJson.getBytes(StandardCharsets.UTF_8)));

    AccessToken accessToken = credentials.refreshAccessToken();
    assertEquals("final_target_sa_access_token_456", accessToken.getTokenValue());
    assertEquals(1, stsCallCount.get());
    assertEquals(1, iamCallCount.get());

    // Asserts both STS and IAM handlers receive the client's X509Certificate from SSLSession
    Certificate[] stsCerts = capturedStsCerts.get();
    assertNotNull(stsCerts);
    assertTrue(stsCerts.length > 0);
    assertTrue(stsCerts[0] instanceof X509Certificate);

    Certificate[] iamCerts = capturedIamCerts.get();
    assertNotNull(iamCerts);
    assertTrue(iamCerts.length > 0);
    assertTrue(iamCerts[0] instanceof X509Certificate);

    // Verify both handlers received the exact same client certificate principal
    assertEquals(
        ((X509Certificate) stsCerts[0]).getSubjectX500Principal(),
        ((X509Certificate) iamCerts[0]).getSubjectX500Principal());

    // Asserts IAM handler receives Authorization: Bearer <intermediate_token>
    assertEquals("Bearer intermediate_sts_token_123", capturedIamAuthHeader.get());

    // Asserts STS received proper token exchange parameters
    Map<String, String> stsParams = capturedStsParams.get();
    assertNotNull(stsParams);
    assertEquals("testSubjectTokenImpersonation", stsParams.get("subject_token"));
    assertEquals("testActorTokenImpersonation", stsParams.get("actor_token"));
  }

  /**
   * Scenario F: testMtlsPipeline_withImpersonation_401OnIam_retriesWithFreshCert
   *
   * <p>Sets up STS and IAM handlers. On attempt 1, STS succeeds (returning intermediate token 1)
   * and IAM returns HTTP 401 Unauthorized. On 401, test updates the cert file on disk (Cert A ->
   * Cert B). Verifies IdentityPoolCredentials catches IAM 401, reloads the fresh cert, re-exchanges
   * at STS for intermediate token 2 (bound to Cert B), and calls IAM with intermediate token 2 +
   * Cert B, succeeding with HTTP 200.
   */
  @Test
  void testMtlsPipeline_withImpersonation_401OnIam_retriesWithFreshCert(@TempDir Path tempDir)
      throws Exception {
    Path dynamicCertFile = tempDir.resolve("dynamic_cert.pem");
    Path dynamicKeyFile = tempDir.resolve("dynamic_key.pem");
    Path certConfigFile = tempDir.resolve("dynamic_cert_config.json");

    // Write initial cert and key (Cert A) to disk
    Files.copy(Paths.get(TEST_CERT_PATH), dynamicCertFile);
    Files.copy(Paths.get(TEST_KEY_PATH), dynamicKeyFile);

    String certConfigContent =
        "{\n"
            + "  \"cert_configs\": {\n"
            + "    \"workload\": {\n"
            + "      \"cert_path\": \""
            + dynamicCertFile.toString()
            + "\",\n"
            + "      \"key_path\": \""
            + dynamicKeyFile.toString()
            + "\"\n"
            + "    }\n"
            + "  }\n"
            + "}";
    Files.write(certConfigFile, certConfigContent.getBytes(StandardCharsets.UTF_8));

    AtomicInteger stsRequestCount = new AtomicInteger(0);
    List<Certificate[]> stsCertsList = Collections.synchronizedList(new ArrayList<>());

    server.createContext(
        "/v1/token",
        new HttpHandler() {
          @Override
          public void handle(HttpExchange exchange) throws IOException {
            try {
              HttpsExchange httpsExchange = (HttpsExchange) exchange;
              SSLSession session = httpsExchange.getSSLSession();
              stsCertsList.add(session.getPeerCertificates());

              readRequestBody(exchange);

              int count = stsRequestCount.incrementAndGet();
              GenericJson response = new GenericJson();
              response.setFactory(OAuth2Utils.JSON_FACTORY);
              response.put("access_token", "intermediate_sts_token_" + count);
              response.put("token_type", "Bearer");
              response.put("expires_in", 3600);
              response.put("issued_token_type", ACCESS_TOKEN_TYPE);
              sendJsonResponse(exchange, 200, response.toPrettyString());
            } catch (Exception e) {
              sendJsonResponse(exchange, 500, "{\"error\": \"" + e.getMessage() + "\"}");
            }
          }
        });

    AtomicInteger iamRequestCount = new AtomicInteger(0);
    List<Certificate[]> iamCertsList = Collections.synchronizedList(new ArrayList<>());
    List<String> iamAuthHeaders = Collections.synchronizedList(new ArrayList<>());

    server.createContext(
        "/v1/projects/-/serviceAccounts/test@project.iam.gserviceaccount.com:generateAccessToken",
        new HttpHandler() {
          @Override
          public void handle(HttpExchange exchange) throws IOException {
            try {
              HttpsExchange httpsExchange = (HttpsExchange) exchange;
              SSLSession session = httpsExchange.getSSLSession();
              iamCertsList.add(session.getPeerCertificates());

              iamAuthHeaders.add(exchange.getRequestHeaders().getFirst("Authorization"));
              readRequestBody(exchange);

              int count = iamRequestCount.incrementAndGet();
              if (count == 1) {
                // Update the cert files on disk on 401 (Cert A -> Cert B)
                Files.write(dynamicCertFile, Files.readAllBytes(Paths.get(TEST_CERT_PATH)));
                Files.write(dynamicKeyFile, Files.readAllBytes(Paths.get(TEST_KEY_PATH)));

                GenericJson error = new GenericJson();
                error.setFactory(OAuth2Utils.JSON_FACTORY);
                error.put("error", "invalid_client");
                error.put("error_description", "Certificate rotation required");
                sendJsonResponse(exchange, 401, error.toPrettyString());
              } else {
                GenericJson response = new GenericJson();
                response.setFactory(OAuth2Utils.JSON_FACTORY);
                response.put("accessToken", "retry_final_target_sa_token_success");
                response.put("expireTime", "2030-01-01T00:00:00Z");
                sendJsonResponse(exchange, 200, response.toPrettyString());
              }
            } catch (Exception e) {
              sendJsonResponse(exchange, 500, "{\"error\": \"" + e.getMessage() + "\"}");
            }
          }
        });

    server.start();
    serverPort = server.getAddress().getPort();

    Path tokenFile = tempDir.resolve("credential.json");
    GenericJson tokenJson = new GenericJson();
    tokenJson.setFactory(OAuth2Utils.JSON_FACTORY);
    tokenJson.put("subject_token", "testSubjectToken401Iam");
    tokenJson.put("actor_token", "testActorToken401Iam");
    OAuth2Utils.writeInputStreamToFile(
        new ByteArrayInputStream(tokenJson.toPrettyString().getBytes(StandardCharsets.UTF_8)),
        tokenFile.toString());

    String iamUrl =
        "https://localhost:"
            + serverPort
            + "/v1/projects/-/serviceAccounts/test@project.iam.gserviceaccount.com:generateAccessToken";

    String configJson =
        "{\n"
            + "  \"type\": \"external_account\",\n"
            + "  \"audience\": \""
            + AUDIENCE
            + "\",\n"
            + "  \"subject_token_type\": \"urn:ietf:params:oauth:token-type:jwt\",\n"
            + "  \"actor_token_type\": \"urn:ietf:params:oauth:token-type:jwt\",\n"
            + "  \"token_url\": \"https://localhost:"
            + serverPort
            + "/v1/token\",\n"
            + "  \"service_account_impersonation_url\": \""
            + iamUrl
            + "\",\n"
            + "  \"credential_source\": {\n"
            + "    \"file\": \""
            + tokenFile.toString()
            + "\",\n"
            + "    \"format\": {\n"
            + "      \"type\": \"json\",\n"
            + "      \"subject_token_field_name\": \"subject_token\",\n"
            + "      \"actor_token_field_name\": \"actor_token\"\n"
            + "    },\n"
            + "    \"certificate\": {\n"
            + "      \"certificate_config_location\": \""
            + certConfigFile.toString()
            + "\"\n"
            + "    }\n"
            + "  }\n"
            + "}";

    IdentityPoolCredentials credentials =
        (IdentityPoolCredentials)
            ExternalAccountCredentials.fromStream(
                new ByteArrayInputStream(configJson.getBytes(StandardCharsets.UTF_8)));

    AccessToken accessToken = credentials.refreshAccessToken();
    assertEquals("retry_final_target_sa_token_success", accessToken.getTokenValue());

    // Verify 2 STS exchanges and 2 IAM calls occurred
    assertEquals(2, stsRequestCount.get());
    assertEquals(2, iamRequestCount.get());

    // Verify certs captured for both attempts
    assertEquals(2, stsCertsList.size());
    assertEquals(2, iamCertsList.size());
    assertNotNull(stsCertsList.get(0));
    assertNotNull(stsCertsList.get(1));
    assertNotNull(iamCertsList.get(0));
    assertNotNull(iamCertsList.get(1));
    assertTrue(stsCertsList.get(0)[0] instanceof X509Certificate);
    assertTrue(stsCertsList.get(1)[0] instanceof X509Certificate);
    assertTrue(iamCertsList.get(0)[0] instanceof X509Certificate);
    assertTrue(iamCertsList.get(1)[0] instanceof X509Certificate);

    // Verify in each attempt, STS and IAM received the same peer certificate
    assertEquals(
        ((X509Certificate) stsCertsList.get(0)[0]).getSubjectX500Principal(),
        ((X509Certificate) iamCertsList.get(0)[0]).getSubjectX500Principal());
    assertEquals(
        ((X509Certificate) stsCertsList.get(1)[0]).getSubjectX500Principal(),
        ((X509Certificate) iamCertsList.get(1)[0]).getSubjectX500Principal());

    // Verify IAM received intermediate tokens 1 and 2 respectively
    assertEquals(2, iamAuthHeaders.size());
    assertEquals("Bearer intermediate_sts_token_1", iamAuthHeaders.get(0));
    assertEquals("Bearer intermediate_sts_token_2", iamAuthHeaders.get(1));
  }
}
