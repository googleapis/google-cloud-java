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

package com.google.showcase.v1beta1.it;

import static com.google.common.truth.Truth.assertThat;
import static com.google.common.truth.Truth.assertWithMessage;

import com.google.api.client.http.javanet.NetHttpTransport;
import com.google.api.gax.core.NoCredentialsProvider;
import com.google.api.gax.httpjson.HttpJsonMetadata;
import com.google.api.gax.httpjson.InstantiatingHttpJsonChannelProvider;
import com.google.showcase.v1beta1.EchoClient;
import com.google.showcase.v1beta1.EchoRequest;
import com.google.showcase.v1beta1.EchoResponse;
import com.google.showcase.v1beta1.EchoSettings;
import com.google.showcase.v1beta1.it.util.HttpJsonCapturingClientInterceptor;
import java.io.File;
import java.io.InputStream;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.security.KeyStore;
import java.security.Provider;
import java.security.Security;
import java.security.cert.Certificate;
import java.security.cert.CertificateFactory;
import java.util.Collections;
import java.util.List;
import javax.net.ssl.SSLContext;
import javax.net.ssl.SSLParameters;
import javax.net.ssl.TrustManagerFactory;
import org.conscrypt.Conscrypt;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

/**
 * Integration tests to verify Post-Quantum Cryptography (PQC) TLS negotiation for HTTP/JSON (REST)
 * clients.
 *
 * <p>These tests execute calls against a local secure (TLS-enabled) Showcase server. During the TLS
 * handshake, the client and server negotiate cipher suites and key exchange groups. Showcase
 * injects information about the negotiated TLS connection parameters into custom headers:
 *
 * <ul>
 *   <li>{@code x-showcase-tls-group}: The negotiated key exchange named group (e.g.
 *       X25519MLKEM768).
 *   <li>{@code x-showcase-tls-version}: The TLS version negotiated (e.g. TLS 1.3).
 *   <li>{@code x-showcase-tls-cipher}: The negotiated cipher suite (e.g. TLS_AES_128_GCM_SHA256).
 *   <li>{@code x-showcase-tls-client-supported-groups}: The list of groups offered by the client.
 * </ul>
 *
 * <p>Verification cases:
 *
 * <ol>
 *   <li>{@code testHttpJsonPqc}: Verifies that HTTP/JSON transport defaults to Conscrypt and
 *       negotiates the hybrid post-quantum group {@code X25519MLKEM768}.
 *   <li>{@code testHttpJsonPqc_withExplicitSecurityProvider}: Verifies that overriding the
 *       transport's SSLSocketFactory to explicitly use standard JDK JSSE provider (SunJSSE) falls
 *       back gracefully to classical key exchange ({@code X25519}) instead of crashing.
 * </ol>
 */
public class ITPqc {

  // TLS response header names from Showcase server
  private static final String TLS_GROUP_HEADER = "x-showcase-tls-group";
  private static final String TLS_SUPPORTED_GROUPS_HEADER =
      "x-showcase-tls-client-supported-groups";

  // Expected TLS parameters
  private static final String EXPECTED_PQC_GROUP = "X25519MLKEM768";

  private static final String DEFAULT_CA_CERT_PATH = getCaCertPath();

  /**
   * Resolves the absolute path to the Showcase server's CA certificate PEM file.
   *
   * @return absolute path to the CA certificate file
   */
  private static String getCaCertPath() {
    String prop = System.getProperty("showcase.ca.cert.path");
    if (prop != null) {
      return prop;
    }
    if (new File("/tmp/showcase-ca.pem").isFile()) {
      return "/tmp/showcase-ca.pem";
    }
    return "target/showcase-ca.pem";
  }

  private static final String SECURE_ENDPOINT =
      System.getProperty("showcase.secure.endpoint", "localhost:7470");

  @BeforeAll
  static void setUp() {
    File certFile = new File(DEFAULT_CA_CERT_PATH);
    assertWithMessage("CA certificate file not found at " + DEFAULT_CA_CERT_PATH)
        .that(certFile.isFile())
        .isTrue();
  }

  @Test
  void testHttpJsonPqc() throws Exception {

    NetHttpTransport transport =
        new NetHttpTransport.Builder()
            .setSecurityProvider(Conscrypt.newProvider())
            .setSslSocketConfigurator(
                socket -> {
                  if (Conscrypt.isConscrypt(socket)) {
                    Conscrypt.setNamedGroups(
                        socket, InstantiatingHttpJsonChannelProvider.DEFAULT_PQC_GROUPS);
                  }
                })
            .trustCertificates(null, loadCaCert(DEFAULT_CA_CERT_PATH), "")
            .build();

    HttpJsonCapturingClientInterceptor interceptor = new HttpJsonCapturingClientInterceptor();

    InstantiatingHttpJsonChannelProvider transportChannelProvider =
        EchoSettings.defaultHttpJsonTransportProviderBuilder()
            .setHttpTransport(transport)
            .setEndpoint("https://" + SECURE_ENDPOINT)
            .setInterceptorProvider(() -> Collections.singletonList(interceptor))
            .build();

    EchoSettings settings =
        EchoSettings.newHttpJsonBuilder()
            .setCredentialsProvider(NoCredentialsProvider.create())
            .setTransportChannelProvider(transportChannelProvider)
            .build();

    try (EchoClient client = EchoClient.create(settings)) {
      EchoResponse response =
          client.echo(EchoRequest.newBuilder().setContent("pqc-httpjson-test").build());
      assertThat(response.getContent()).isEqualTo("pqc-httpjson-test");

      HttpJsonMetadata capturedHeaders = interceptor.metadata;
      assertThat(capturedHeaders).isNotNull();

      String negotiatedGroup = getSingleHeaderString(capturedHeaders, TLS_GROUP_HEADER);
      assertThat(negotiatedGroup).isEqualTo(EXPECTED_PQC_GROUP);

      String supportedGroups = getSingleHeaderString(capturedHeaders, TLS_SUPPORTED_GROUPS_HEADER);
      assertThat(supportedGroups).isNotNull();
    }
  }

  @Test
  void testHttpJsonPqc_withExplicitSecurityProviderNoPqcGroups() throws Exception {
    // Explicitly use SunJSSE (JDK default) instead of Conscrypt
    Provider sunJsseProvider = Security.getProvider("SunJSSE");
    assertThat(sunJsseProvider).isNotNull();

    // Initialize SSLContext and TrustManagerFactory explicitly with SunJSSE provider to trust the
    // CA
    SSLContext sslContext = SSLContext.getInstance("TLS", sunJsseProvider);
    TrustManagerFactory tmf =
        TrustManagerFactory.getInstance(TrustManagerFactory.getDefaultAlgorithm(), sunJsseProvider);
    tmf.init(loadCaCert(DEFAULT_CA_CERT_PATH));
    sslContext.init(null, tmf.getTrustManagers(), null);

    // This test verifies client transport behavior when PQC algorithms are not offered.
    // Future Java versions (e.g. JDK 27+) will enable PQC (ML-KEM) by default in standard JDK JSSE.
    // Explicitly setting named groups to classical algorithms ensures that this test reliably
    // tests the non-PQC classical TLS connection path regardless of underlying JDK defaults.
    NetHttpTransport transport =
        new NetHttpTransport.Builder()
            .setSslSocketFactory(sslContext.getSocketFactory())
            .setSslSocketConfigurator(
                socket -> {
                  try {
                    SSLParameters params = socket.getSSLParameters();
                    params.setNamedGroups(new String[] {"X25519", "SecP256r1"});
                    socket.setSSLParameters(params);
                  } catch (Exception e) {
                    // For JDK 8-19, SSLParameters.setNamedGroups() is unsupported, and JSSE
                    // naturally
                    // defaults to classical algorithms. Setting classical named groups is primarily
                    // for
                    // JDK 20+ when PQC becomes the default in standard JSSE.
                  }
                })
            .build();

    HttpJsonCapturingClientInterceptor interceptor = new HttpJsonCapturingClientInterceptor();

    InstantiatingHttpJsonChannelProvider transportChannelProvider =
        EchoSettings.defaultHttpJsonTransportProviderBuilder()
            .setHttpTransport(transport)
            .setEndpoint("https://" + SECURE_ENDPOINT)
            .setInterceptorProvider(() -> Collections.singletonList(interceptor))
            .build();

    EchoSettings settings =
        EchoSettings.newHttpJsonBuilder()
            .setCredentialsProvider(NoCredentialsProvider.create())
            .setTransportChannelProvider(transportChannelProvider)
            .build();

    try (EchoClient client = EchoClient.create(settings)) {
      EchoResponse response =
          client.echo(
              EchoRequest.newBuilder().setContent("pqc-httpjson-explicit-provider-test").build());
      assertThat(response.getContent()).isEqualTo("pqc-httpjson-explicit-provider-test");

      HttpJsonMetadata capturedHeaders = interceptor.metadata;
      assertThat(capturedHeaders).isNotNull();

      String negotiatedGroup = getSingleHeaderString(capturedHeaders, TLS_GROUP_HEADER);
      // Under classical non-PQC configuration, negotiated group is a classical curve
      assertThat(negotiatedGroup).isAnyOf("X25519", "SecP256r1", "CurveP256");
      assertThat(negotiatedGroup).isNotEqualTo(EXPECTED_PQC_GROUP);
    }
  }

  /**
   * Extracts the first string value of a specified HTTP response header from metadata.
   *
   * @param metadata the HTTP metadata containing response headers
   * @param name the case-insensitive header key name
   * @return header value string, or {@code null} if not found
   */
  private static String getSingleHeaderString(HttpJsonMetadata metadata, String name) {
    Object valueObj = metadata.getHeaders().get(name);
    if (valueObj instanceof List) {
      List<?> list = (List<?>) valueObj;
      if (!list.isEmpty()) {
        return String.valueOf(list.get(0));
      }
    } else if (valueObj != null) {
      return String.valueOf(valueObj);
    }
    return null;
  }

  /**
   * Loads an X.509 CA certificate file from disk into a new KeyStore instance.
   *
   * @param certPath path to the X.509 certificate file
   * @return initialized KeyStore containing the certificate entry
   * @throws Exception if reading or parsing the certificate fails
   */
  private static KeyStore loadCaCert(String certPath) throws Exception {
    KeyStore trustStore = KeyStore.getInstance(KeyStore.getDefaultType());
    trustStore.load(null, null);
    CertificateFactory cf = CertificateFactory.getInstance("X.509");
    try (InputStream is = Files.newInputStream(Paths.get(certPath))) {
      Certificate cert = cf.generateCertificate(is);
      trustStore.setCertificateEntry("showcase-ca", cert);
    }
    return trustStore;
  }
}
