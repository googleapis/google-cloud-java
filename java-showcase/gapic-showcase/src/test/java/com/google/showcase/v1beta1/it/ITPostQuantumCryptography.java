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
import com.google.api.gax.httpjson.HttpJsonConscryptUtils;
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
import java.security.cert.Certificate;
import java.security.cert.CertificateFactory;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
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
 *   <li>{@code testHttpJsonPqc_withExplicitNonPqcGroup}: Verifies that explicitly configuring
 *       classical non-PQC key exchange groups (e.g. {@code X25519}) forces classical key exchange.
 *       Explicitly setting the group ensures test compatibility across all JDK versions, including
 *       future JDK releases (such as JDK 27+) where PQC will be enabled by default.
 * </ol>
 */
class ITPostQuantumCryptography {

  // TLS response header names from Showcase server
  private static final String TLS_GROUP_HEADER = "x-showcase-tls-group";
  private static final String TLS_SUPPORTED_GROUPS_HEADER =
      "x-showcase-tls-client-supported-groups";

  // Expected TLS parameters
  private static final String EXPECTED_PQC_GROUP = "X25519MLKEM768";
  private static final String CLASSICAL_X25519_GROUP = "X25519";
  private static final String[] EXPLICIT_NON_PQC_GROUPS = new String[] {CLASSICAL_X25519_GROUP};

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
  static void setUp() throws Exception {
    File certFile = new File(DEFAULT_CA_CERT_PATH);
    assertWithMessage("CA certificate file not found at " + DEFAULT_CA_CERT_PATH)
        .that(certFile.isFile())
        .isTrue();
  }

  @Test
  void testHttpJsonPqc() throws Exception {
    HttpJsonCapturingClientInterceptor interceptor = new HttpJsonCapturingClientInterceptor();

    // Construct a dedicated NetHttpTransport configured with Conscrypt security provider
    // and explicitly trusted Showcase CA certificate. This avoids modifying the global JVM
    // SSLContext (via SSLContext.setDefault) and ensures Conscrypt's TLS engine is used.
    NetHttpTransport transport =
        HttpJsonConscryptUtils.configureConscryptSecurityProvider(new NetHttpTransport.Builder())
            .trustCertificates(loadCaCert(DEFAULT_CA_CERT_PATH))
            .build();

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

      // Assert that supported groups offered by Conscrypt include the primary PQC group and
      // classical fallback group. We use containsAtLeast instead of exact list equality because
      // Go's crypto/tls library only recognizes standard Curve IDs (e.g. X25519MLKEM768 and
      // X25519), which is not a 1:1 mapping with the full list of named groups that Conscrypt
      // supports (see
      // https://github.com/google/conscrypt/blob/2.6.0/CAPABILITIES.md#supported-named-groups).
      // Draft/standalone groups like X25519Kyber768Draft00 and MLKEM1024 are formatted as
      // "Unknown-Curve-25497" and "Unknown-Curve-514" by the Showcase server.
      List<String> supportedGroups =
          getHeaderStringList(capturedHeaders, TLS_SUPPORTED_GROUPS_HEADER);
      assertThat(supportedGroups).containsAtLeast(EXPECTED_PQC_GROUP, CLASSICAL_X25519_GROUP);
    }
  }

  @Test
  void testHttpJsonPqc_withExplicitNonPqcGroup() throws Exception {
    HttpJsonCapturingClientInterceptor interceptor = new HttpJsonCapturingClientInterceptor();

    // Explicitly configure Conscrypt socket with classical X25519 group. This verifies that
    // custom socket configurators can override default PQC groups with non-PQC groups.
    // Explicitly passing a non-PQC curve ensures that the test deterministically verifies
    // classical key exchange fallback across all JDK versions, including future JDK 27+ releases
    // where PQC algorithms will be enabled by default in standard JDK security providers.
    NetHttpTransport transport =
        HttpJsonConscryptUtils.configureConscryptSecurityProvider(new NetHttpTransport.Builder())
            .setSslSocketConfigurator(
                socket -> {
                  if (Conscrypt.isConscrypt(socket)) {
                    try {
                      Conscrypt.setNamedGroups(socket, EXPLICIT_NON_PQC_GROUPS);
                    } catch (Exception ignored) {
                    }
                  }
                })
            .trustCertificates(loadCaCert(DEFAULT_CA_CERT_PATH))
            .build();

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
          client.echo(EchoRequest.newBuilder().setContent("pqc-httpjson-jsse-test").build());
      assertThat(response.getContent()).isEqualTo("pqc-httpjson-jsse-test");

      HttpJsonMetadata capturedHeaders = interceptor.metadata;
      assertThat(capturedHeaders).isNotNull();

      String negotiatedGroup = getSingleHeaderString(capturedHeaders, TLS_GROUP_HEADER);
      assertThat(negotiatedGroup).isEqualTo(CLASSICAL_X25519_GROUP);

      List<String> supportedGroups =
          getHeaderStringList(capturedHeaders, TLS_SUPPORTED_GROUPS_HEADER);
      assertThat(supportedGroups).containsExactlyElementsIn(Arrays.asList(EXPLICIT_NON_PQC_GROUPS));
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
   * Extracts a list of string values from a comma-separated HTTP response header.
   *
   * @param metadata the HTTP metadata containing response headers
   * @param name the case-insensitive header key name
   * @return list of header string tokens, or empty list if not found
   */
  private static List<String> getHeaderStringList(HttpJsonMetadata metadata, String name) {
    String value = getSingleHeaderString(metadata, name);
    if (value == null || value.trim().isEmpty()) {
      return Collections.emptyList();
    }
    return Arrays.asList(value.split(","));
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
