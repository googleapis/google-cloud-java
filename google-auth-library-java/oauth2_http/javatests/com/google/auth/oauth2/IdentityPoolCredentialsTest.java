/*
 * Copyright 2021 Google LLC
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
 *
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

import static com.google.auth.Credentials.GOOGLE_DEFAULT_UNIVERSE;
import static com.google.auth.oauth2.MockExternalAccountCredentialsTransport.SERVICE_ACCOUNT_IMPERSONATION_URL;
import static com.google.auth.oauth2.OAuth2Utils.JSON_FACTORY;
import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertNotSame;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;

import com.google.api.client.http.HttpTransport;
import com.google.api.client.http.LowLevelHttpRequest;
import com.google.api.client.http.LowLevelHttpResponse;
import com.google.api.client.json.GenericJson;
import com.google.api.client.json.Json;
import com.google.api.client.json.JsonParser;
import com.google.api.client.testing.http.MockHttpTransport;
import com.google.api.client.testing.http.MockLowLevelHttpRequest;
import com.google.api.client.testing.http.MockLowLevelHttpResponse;
import com.google.api.client.util.Clock;
import com.google.api.client.util.SecurityUtils;
import com.google.auth.TestClock;
import com.google.auth.TestUtils;
import com.google.auth.http.HttpTransportFactory;
import com.google.auth.mtls.MtlsHttpTransportFactory;
import com.google.auth.mtls.X509Provider;
import com.google.auth.oauth2.GoogleCredentials.GoogleCredentialsInfo;
import com.google.common.primitives.Bytes;
import java.io.ByteArrayInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.ObjectInputStream;
import java.io.ObjectStreamClass;
import java.io.SequenceInputStream;
import java.io.Serializable;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;
import java.security.KeyStore;
import java.security.KeyStoreException;
import java.security.NoSuchAlgorithmException;
import java.security.cert.CertificateException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Base64;
import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.CyclicBarrier;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicReference;
import javax.net.ssl.SSLHandshakeException;
import org.jspecify.annotations.Nullable;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.junit.jupiter.api.io.TempDir;
import org.mockito.junit.jupiter.MockitoExtension;

/** Tests for {@link IdentityPoolCredentials}. */
@ExtendWith(MockitoExtension.class)
class IdentityPoolCredentialsTest extends BaseSerializationTest {

  private static final String STS_URL = "https://sts.googleapis.com/v1/token";

  private static final IdentityPoolSubjectTokenSupplier testProvider =
      (ExternalAccountSupplierContext context) -> "testSubjectToken";

  private static final IdentityPoolActorTokenSupplier testActorSupplier =
      (ExternalAccountSupplierContext context) -> "testActorToken";

  static KeyStore createPopulatedKeyStore() {
    try (InputStream certStream =
            new FileInputStream(new File("testresources/mtls/test_cert.pem"));
        InputStream keyStream = new FileInputStream(new File("testresources/mtls/test_key.pem"));
        InputStream combined = new SequenceInputStream(certStream, keyStream)) {
      return SecurityUtils.createMtlsKeyStore(combined);
    } catch (Exception e) {
      throw new RuntimeException("Failed to create test KeyStore", e);
    }
  }

  static KeyStore createRotatedPopulatedKeyStore() {
    try (InputStream certStream =
            new FileInputStream(new File("testresources/mtls/test_cert_2.pem"));
        InputStream keyStream = new FileInputStream(new File("testresources/mtls/test_key_2.pem"));
        InputStream combined = new SequenceInputStream(certStream, keyStream)) {
      return SecurityUtils.createMtlsKeyStore(combined);
    } catch (Exception e) {
      throw new RuntimeException("Failed to create rotated test KeyStore", e);
    }
  }

  @Test
  void createdScoped_clonedCredentialWithAddedScopes() {
    IdentityPoolCredentials credentials =
        IdentityPoolCredentials.newBuilder(createBaseFileSourcedCredentials())
            .setServiceAccountImpersonationUrl(SERVICE_ACCOUNT_IMPERSONATION_URL)
            .setQuotaProjectId("quotaProjectId")
            .setClientId("clientId")
            .setClientSecret("clientSecret")
            .setUniverseDomain("universeDomain")
            .build();

    List<String> newScopes = Arrays.asList("scope1", "scope2");

    IdentityPoolCredentials newCredentials = credentials.createScoped(newScopes);

    assertEquals(credentials.getAudience(), newCredentials.getAudience());
    assertEquals(credentials.getSubjectTokenType(), newCredentials.getSubjectTokenType());
    assertEquals(credentials.getTokenUrl(), newCredentials.getTokenUrl());
    assertEquals(credentials.getTokenInfoUrl(), newCredentials.getTokenInfoUrl());
    assertEquals(
        credentials.getServiceAccountImpersonationUrl(),
        newCredentials.getServiceAccountImpersonationUrl());
    assertEquals(credentials.getCredentialSource(), newCredentials.getCredentialSource());
    assertEquals(newScopes, newCredentials.getScopes());
    assertEquals(credentials.getQuotaProjectId(), newCredentials.getQuotaProjectId());
    assertEquals(credentials.getClientId(), newCredentials.getClientId());
    assertEquals(credentials.getClientSecret(), newCredentials.getClientSecret());
    assertEquals(credentials.getUniverseDomain(), newCredentials.getUniverseDomain());
    assertEquals("universeDomain", newCredentials.getUniverseDomain());
  }

  @Test
  void retrieveSubjectToken_fileSourced() throws IOException {
    File file =
        File.createTempFile("RETRIEVE_SUBJECT_TOKEN", /* suffix= */ null, /* directory= */ null);
    file.deleteOnExit();

    String credential = "credential";
    OAuth2Utils.writeInputStreamToFile(
        new ByteArrayInputStream(credential.getBytes(StandardCharsets.UTF_8)),
        file.getAbsolutePath());

    Map<String, Object> credentialSourceMap = new HashMap<>();
    credentialSourceMap.put("file", file.getAbsolutePath());
    IdentityPoolCredentialSource credentialSource =
        new IdentityPoolCredentialSource(credentialSourceMap);

    IdentityPoolCredentials credentials =
        IdentityPoolCredentials.newBuilder(createBaseFileSourcedCredentials())
            .setCredentialSource(credentialSource)
            .build();

    String subjectToken = credentials.retrieveSubjectToken();

    assertEquals(credential, subjectToken);
  }

  @Test
  void retrieveSubjectToken_fileSourcedWithJsonFormat() throws IOException {
    File file =
        File.createTempFile("RETRIEVE_SUBJECT_TOKEN", /* suffix= */ null, /* directory= */ null);
    file.deleteOnExit();

    MockExternalAccountCredentialsTransportFactory transportFactory =
        new MockExternalAccountCredentialsTransportFactory();

    transportFactory.transport.setMetadataServerContentType("json");

    Map<String, Object> credentialSourceMap = new HashMap<>();
    Map<String, String> formatMap = new HashMap<>();
    formatMap.put("type", "json");
    formatMap.put("subject_token_field_name", "subjectToken");

    credentialSourceMap.put("file", file.getAbsolutePath());
    credentialSourceMap.put("format", formatMap);

    IdentityPoolCredentialSource credentialSource =
        new IdentityPoolCredentialSource(credentialSourceMap);

    GenericJson response = new GenericJson();
    response.setFactory(JSON_FACTORY);
    response.put("subjectToken", "subjectToken");

    OAuth2Utils.writeInputStreamToFile(
        new ByteArrayInputStream(response.toString().getBytes(StandardCharsets.UTF_8)),
        file.getAbsolutePath());

    IdentityPoolCredentials credential =
        IdentityPoolCredentials.newBuilder(createBaseFileSourcedCredentials())
            .setHttpTransportFactory(transportFactory)
            .setCredentialSource(credentialSource)
            .build();

    String subjectToken = credential.retrieveSubjectToken();

    assertEquals("subjectToken", subjectToken);
  }

  @Test
  void retrieveSubjectToken_fileSourcedWithNullFormat_throws() throws IOException {
    File file =
        File.createTempFile("RETRIEVE_SUBJECT_TOKEN", /* suffix= */ null, /* directory= */ null);
    file.deleteOnExit();

    Map<String, Object> credentialSourceMap = new HashMap<>();
    Map<String, String> formatMap = new HashMap<>();
    formatMap.put("type", null);

    credentialSourceMap.put("file", file.getAbsolutePath());
    credentialSourceMap.put("format", formatMap);

    IllegalArgumentException e =
        assertThrows(
            IllegalArgumentException.class,
            () -> new IdentityPoolCredentialSource(credentialSourceMap));
    assertEquals("Invalid credential source format type: null.", e.getMessage());
  }

  @Test
  void retrieveSubjectToken_noFile_throws() {
    Map<String, Object> credentialSourceMap = new HashMap<>();
    String path = "badPath";
    credentialSourceMap.put("file", path);
    IdentityPoolCredentialSource credentialSource =
        new IdentityPoolCredentialSource(credentialSourceMap);

    IdentityPoolCredentials credentials =
        IdentityPoolCredentials.newBuilder(createBaseFileSourcedCredentials())
            .setCredentialSource(credentialSource)
            .build();

    IOException e = assertThrows(IOException.class, credentials::retrieveSubjectToken);
    assertEquals(
        String.format("Invalid credential location. The file at %s does not exist.", path),
        e.getMessage());
  }

  @Test
  void retrieveSubjectToken_urlSourced() throws IOException {
    MockExternalAccountCredentialsTransportFactory transportFactory =
        new MockExternalAccountCredentialsTransportFactory();

    IdentityPoolCredentials credential =
        IdentityPoolCredentials.newBuilder(createBaseFileSourcedCredentials())
            .setHttpTransportFactory(transportFactory)
            .setCredentialSource(
                buildUrlBasedCredentialSource(transportFactory.transport.getMetadataUrl()))
            .build();

    String subjectToken = credential.retrieveSubjectToken();

    assertEquals(transportFactory.transport.getSubjectToken(), subjectToken);
  }

  @Test
  void retrieveSubjectToken_urlSourcedWithJsonFormat() throws IOException {
    MockExternalAccountCredentialsTransportFactory transportFactory =
        new MockExternalAccountCredentialsTransportFactory();

    transportFactory.transport.setMetadataServerContentType("json");

    Map<String, String> formatMap = new HashMap<>();
    formatMap.put("type", "json");
    formatMap.put("subject_token_field_name", "subjectToken");

    IdentityPoolCredentialSource credentialSource =
        buildUrlBasedCredentialSource(transportFactory.transport.getMetadataUrl(), formatMap);

    IdentityPoolCredentials credential =
        IdentityPoolCredentials.newBuilder(createBaseFileSourcedCredentials())
            .setHttpTransportFactory(transportFactory)
            .setCredentialSource(credentialSource)
            .build();

    String subjectToken = credential.retrieveSubjectToken();

    assertEquals(transportFactory.transport.getSubjectToken(), subjectToken);
  }

  @Test
  void retrieveSubjectToken_urlSourcedWithJsonFormat_withActorTokenField() throws IOException {
    MockExternalAccountCredentialsTransportFactory transportFactory =
        new MockExternalAccountCredentialsTransportFactory();

    transportFactory.transport.setMetadataServerContentType("json");

    Map<String, String> formatMap = new HashMap<>();
    formatMap.put("type", "json");
    formatMap.put("subject_token_field_name", "subjectToken");
    formatMap.put("actor_token_field_name", "actorToken");

    IdentityPoolCredentialSource credentialSource =
        buildUrlBasedCredentialSource(transportFactory.transport.getMetadataUrl(), formatMap);

    UrlIdentityPoolSubjectTokenSupplier supplier =
        new UrlIdentityPoolSubjectTokenSupplier(credentialSource, transportFactory);

    ExternalAccountSupplierContext dummyContext =
        ExternalAccountSupplierContext.newBuilder()
            .setAudience("aud")
            .setSubjectTokenType("urn")
            .build();

    String subjectToken = supplier.getSubjectToken(dummyContext);

    assertEquals(transportFactory.transport.getSubjectToken(), subjectToken);
  }

  @Test
  void retrieveSubjectToken_urlSourcedCredential_throws() {
    MockExternalAccountCredentialsTransportFactory transportFactory =
        new MockExternalAccountCredentialsTransportFactory();

    IOException response = new IOException();
    transportFactory.transport.addResponseErrorSequence(response);

    IdentityPoolCredentials credential =
        IdentityPoolCredentials.newBuilder(createBaseFileSourcedCredentials())
            .setHttpTransportFactory(transportFactory)
            .setCredentialSource(
                buildUrlBasedCredentialSource(transportFactory.transport.getMetadataUrl()))
            .build();

    IOException e = assertThrows(IOException.class, credential::retrieveSubjectToken);
    assertEquals(
        String.format(
            "Error getting subject token from metadata server: %s", response.getMessage()),
        e.getMessage());
  }

  @Test
  void retrieveSubjectToken_provider() throws IOException {
    ExternalAccountSupplierContext emptyContext =
        ExternalAccountSupplierContext.newBuilder().setAudience("").setSubjectTokenType("").build();
    IdentityPoolCredentials credentials =
        IdentityPoolCredentials.newBuilder(createBaseFileSourcedCredentials())
            .setCredentialSource(null)
            .setSubjectTokenSupplier(testProvider)
            .build();

    String subjectToken = credentials.retrieveSubjectToken();

    assertEquals(testProvider.getSubjectToken(emptyContext), subjectToken);
  }

  @Test
  void retrieveSubjectToken_providerThrowsError() {
    IOException testException = new IOException("test");

    IdentityPoolSubjectTokenSupplier errorProvider =
        (ExternalAccountSupplierContext context) -> {
          throw testException;
        };
    IdentityPoolCredentials credentials =
        IdentityPoolCredentials.newBuilder(createBaseFileSourcedCredentials())
            .setCredentialSource(null)
            .setSubjectTokenSupplier(errorProvider)
            .build();

    IOException e = assertThrows(IOException.class, credentials::retrieveSubjectToken);
    assertEquals("test", e.getMessage());
  }

  @Test
  void retrieveSubjectToken_supplierPassesContext() throws IOException {
    ExternalAccountSupplierContext expectedContext =
        ExternalAccountSupplierContext.newBuilder()
            .setAudience(createBaseFileSourcedCredentials().getAudience())
            .setSubjectTokenType(createBaseFileSourcedCredentials().getSubjectTokenType())
            .build();

    IdentityPoolSubjectTokenSupplier testSupplier =
        (ExternalAccountSupplierContext context) -> {
          assertEquals(expectedContext.getAudience(), context.getAudience());
          assertEquals(expectedContext.getSubjectTokenType(), context.getSubjectTokenType());
          return "token";
        };
    IdentityPoolCredentials credentials =
        IdentityPoolCredentials.newBuilder(createBaseFileSourcedCredentials())
            .setCredentialSource(null)
            .setSubjectTokenSupplier(testSupplier)
            .build();

    credentials.retrieveSubjectToken();
  }

  @Test
  void refreshAccessToken_withoutServiceAccountImpersonation() throws IOException {
    MockExternalAccountCredentialsTransportFactory transportFactory =
        new MockExternalAccountCredentialsTransportFactory();

    IdentityPoolCredentials credential =
        IdentityPoolCredentials.newBuilder()
            .setAudience(
                "//iam.googleapis.com/projects/123/locations/global/workloadIdentityPools/pool/providers/provider")
            .setSubjectTokenType("subjectTokenType")
            .setTokenInfoUrl("tokenInfoUrl")
            .setCredentialSource(createFileCredentialSource())
            .setTokenUrl(transportFactory.transport.getStsUrl())
            .setHttpTransportFactory(transportFactory)
            .setCredentialSource(
                buildUrlBasedCredentialSource(transportFactory.transport.getMetadataUrl()))
            .build();

    AccessToken accessToken = credential.refreshAccessToken();

    assertEquals(transportFactory.transport.getAccessToken(), accessToken.getTokenValue());

    // Validate metrics header is set correctly on the sts request.
    Map<String, List<String>> headers =
        transportFactory.transport.getRequests().get(1).getHeaders();
    ExternalAccountCredentialsTest.validateMetricsHeader(headers, "url", false, false);
  }

  @Test
  void refreshAccessToken_internalOptionsSet() throws IOException {
    MockExternalAccountCredentialsTransportFactory transportFactory =
        new MockExternalAccountCredentialsTransportFactory();

    IdentityPoolCredentials credential =
        IdentityPoolCredentials.newBuilder(createBaseFileSourcedCredentials())
            .setWorkforcePoolUserProject("userProject")
            .setAudience(
                "//iam.googleapis.com/locations/global/workforcePools/pool/providers/provider")
            .setTokenUrl(transportFactory.transport.getStsUrl())
            .setHttpTransportFactory(transportFactory)
            .setCredentialSource(
                buildUrlBasedCredentialSource(transportFactory.transport.getMetadataUrl()))
            .build();

    AccessToken accessToken = credential.refreshAccessToken();

    assertEquals(transportFactory.transport.getAccessToken(), accessToken.getTokenValue());

    // If the IdentityPoolCredential is initialized with a userProject, it must be passed
    // to STS via internal options.
    Map<String, String> query =
        TestUtils.parseQuery(transportFactory.transport.getLastRequest().getContentAsString());
    assertNotNull(query.get("options"));

    GenericJson expectedInternalOptions = new GenericJson();
    expectedInternalOptions.setFactory(OAuth2Utils.JSON_FACTORY);
    expectedInternalOptions.put("userProject", "userProject");

    assertEquals(expectedInternalOptions.toString(), query.get("options"));
  }

  @Test
  void refreshAccessToken_withServiceAccountImpersonation() throws IOException {
    MockExternalAccountCredentialsTransportFactory transportFactory =
        new MockExternalAccountCredentialsTransportFactory();

    transportFactory.transport.setExpireTime(TestUtils.getDefaultExpireTime());
    IdentityPoolCredentials credential =
        IdentityPoolCredentials.newBuilder()
            .setAudience(
                "//iam.googleapis.com/projects/123/locations/global/workloadIdentityPools/pool/providers/provider")
            .setSubjectTokenType("subjectTokenType")
            .setTokenInfoUrl("tokenInfoUrl")
            .setServiceAccountImpersonationUrl(
                transportFactory.transport.getServiceAccountImpersonationUrl())
            .setTokenUrl(transportFactory.transport.getStsUrl())
            .setHttpTransportFactory(transportFactory)
            .setCredentialSource(
                buildUrlBasedCredentialSource(transportFactory.transport.getMetadataUrl()))
            .build();

    AccessToken accessToken = credential.refreshAccessToken();

    assertEquals(
        transportFactory.transport.getServiceAccountAccessToken(), accessToken.getTokenValue());

    // Validate metrics header is set correctly on the sts request.
    Map<String, List<String>> headers =
        transportFactory.transport.getRequests().get(1).getHeaders();
    ExternalAccountCredentialsTest.validateMetricsHeader(headers, "url", true, false);
  }

  @Test
  void refreshAccessToken_withServiceAccountImpersonationOptions() throws IOException {
    MockExternalAccountCredentialsTransportFactory transportFactory =
        new MockExternalAccountCredentialsTransportFactory();

    transportFactory.transport.setExpireTime(TestUtils.getDefaultExpireTime());
    IdentityPoolCredentials credential =
        IdentityPoolCredentials.newBuilder()
            .setAudience(
                "//iam.googleapis.com/projects/123/locations/global/workloadIdentityPools/pool/providers/provider")
            .setSubjectTokenType("subjectTokenType")
            .setTokenInfoUrl("tokenInfoUrl")
            .setTokenUrl(transportFactory.transport.getStsUrl())
            .setHttpTransportFactory(transportFactory)
            .setServiceAccountImpersonationUrl(
                transportFactory.transport.getServiceAccountImpersonationUrl())
            .setCredentialSource(
                buildUrlBasedCredentialSource(transportFactory.transport.getMetadataUrl()))
            .setServiceAccountImpersonationOptions(
                ExternalAccountCredentialsTest.buildServiceAccountImpersonationOptions())
            .build();

    AccessToken accessToken = credential.refreshAccessToken();

    assertEquals(
        transportFactory.transport.getServiceAccountAccessToken(), accessToken.getTokenValue());

    // Validate that default lifetime was set correctly on the request.
    GenericJson query =
        OAuth2Utils.JSON_FACTORY
            .createJsonParser(transportFactory.transport.getLastRequest().getContentAsString())
            .parseAndClose(GenericJson.class);

    assertEquals("2800s", query.get("lifetime"));

    // Validate metrics header is set correctly on the sts request.
    Map<String, List<String>> headers =
        transportFactory.transport.getRequests().get(1).getHeaders();
    ExternalAccountCredentialsTest.validateMetricsHeader(headers, "url", true, true);
  }

  @Test
  void refreshAccessToken_Provider() throws IOException {
    MockExternalAccountCredentialsTransportFactory transportFactory =
        new MockExternalAccountCredentialsTransportFactory();

    transportFactory.transport.setExpireTime(TestUtils.getDefaultExpireTime());
    IdentityPoolCredentials credential =
        IdentityPoolCredentials.newBuilder()
            .setSubjectTokenSupplier(testProvider)
            .setAudience(
                "//iam.googleapis.com/projects/123/locations/global/workloadIdentityPools/pool/providers/provider")
            .setSubjectTokenType("subjectTokenType")
            .setTokenInfoUrl("tokenInfoUrl")
            .setTokenUrl(transportFactory.transport.getStsUrl())
            .setHttpTransportFactory(transportFactory)
            .build();

    AccessToken accessToken = credential.refreshAccessToken();

    assertEquals(transportFactory.transport.getAccessToken(), accessToken.getTokenValue());

    // Validate metrics header is set correctly on the sts request.
    Map<String, List<String>> headers =
        transportFactory.transport.getRequests().get(0).getHeaders();
    ExternalAccountCredentialsTest.validateMetricsHeader(headers, "programmatic", false, false);
  }

  @Test
  void refreshAccessToken_providerWithServiceAccountImpersonation() throws IOException {
    MockExternalAccountCredentialsTransportFactory transportFactory =
        new MockExternalAccountCredentialsTransportFactory();

    transportFactory.transport.setExpireTime(TestUtils.getDefaultExpireTime());
    IdentityPoolCredentials credential =
        IdentityPoolCredentials.newBuilder()
            .setSubjectTokenSupplier(testProvider)
            .setAudience(
                "//iam.googleapis.com/projects/123/locations/global/workloadIdentityPools/pool/providers/provider")
            .setSubjectTokenType("subjectTokenType")
            .setTokenInfoUrl("tokenInfoUrl")
            .setServiceAccountImpersonationUrl(
                transportFactory.transport.getServiceAccountImpersonationUrl())
            .setTokenUrl(transportFactory.transport.getStsUrl())
            .setHttpTransportFactory(transportFactory)
            .build();

    AccessToken accessToken = credential.refreshAccessToken();

    assertEquals(
        transportFactory.transport.getServiceAccountAccessToken(), accessToken.getTokenValue());

    // Validate metrics header is set correctly on the sts request.
    Map<String, List<String>> headers =
        transportFactory.transport.getRequests().get(0).getHeaders();
    ExternalAccountCredentialsTest.validateMetricsHeader(headers, "programmatic", true, false);
  }

  @Test
  void refreshAccessToken_workforceWithServiceAccountImpersonation() throws IOException {
    MockExternalAccountCredentialsTransportFactory transportFactory =
        new MockExternalAccountCredentialsTransportFactory();

    transportFactory.transport.setExpireTime(TestUtils.getDefaultExpireTime());
    IdentityPoolCredentials credential =
        IdentityPoolCredentials.newBuilder(createBaseFileSourcedCredentials())
            .setAudience(
                "//iam.googleapis.com/locations/global/workforcePools/pool/providers/provider")
            .setTokenUrl(transportFactory.transport.getStsUrl())
            .setServiceAccountImpersonationUrl(
                transportFactory.transport.getServiceAccountImpersonationUrl())
            .setHttpTransportFactory(transportFactory)
            .setCredentialSource(
                buildUrlBasedCredentialSource(transportFactory.transport.getMetadataUrl()))
            .setWorkforcePoolUserProject("userProject")
            .build();

    AccessToken accessToken = credential.refreshAccessToken();

    assertEquals(
        transportFactory.transport.getServiceAccountAccessToken(), accessToken.getTokenValue());

    // Validate internal options set.
    Map<String, String> query = TestUtils.parseQuery(transportFactory.transport.getStsContent());

    GenericJson expectedInternalOptions = new GenericJson();
    expectedInternalOptions.setFactory(OAuth2Utils.JSON_FACTORY);
    expectedInternalOptions.put("userProject", "userProject");

    assertNotNull(query.get("options"));
    assertEquals(expectedInternalOptions.toString(), query.get("options"));
  }

  @Test
  void refreshAccessToken_workforceWithServiceAccountImpersonationOptions() throws IOException {
    MockExternalAccountCredentialsTransportFactory transportFactory =
        new MockExternalAccountCredentialsTransportFactory();

    transportFactory.transport.setExpireTime(TestUtils.getDefaultExpireTime());
    IdentityPoolCredentials credential =
        IdentityPoolCredentials.newBuilder(createBaseFileSourcedCredentials())
            .setAudience(
                "//iam.googleapis.com/locations/global/workforcePools/pool/providers/provider")
            .setTokenUrl(transportFactory.transport.getStsUrl())
            .setServiceAccountImpersonationUrl(
                transportFactory.transport.getServiceAccountImpersonationUrl())
            .setHttpTransportFactory(transportFactory)
            .setCredentialSource(
                buildUrlBasedCredentialSource(transportFactory.transport.getMetadataUrl()))
            .setWorkforcePoolUserProject("userProject")
            .setServiceAccountImpersonationOptions(
                ExternalAccountCredentialsTest.buildServiceAccountImpersonationOptions())
            .build();

    AccessToken accessToken = credential.refreshAccessToken();

    // Validate that default lifetime was set correctly on the request.
    assertEquals(
        transportFactory.transport.getServiceAccountAccessToken(), accessToken.getTokenValue());

    GenericJson query =
        OAuth2Utils.JSON_FACTORY
            .createJsonParser(transportFactory.transport.getLastRequest().getContentAsString())
            .parseAndClose(GenericJson.class);

    assertEquals("2800s", query.get("lifetime"));
  }

  @Test
  void identityPoolCredentialSource_validFormats() {
    Map<String, Object> credentialSourceMapWithFileTextSource = new HashMap<>();
    Map<String, Object> credentialSourceMapWithFileJsonTextSource = new HashMap<>();
    Map<String, Object> credentialSourceMapWithUrlTextSource = new HashMap<>();
    Map<String, Object> credentialSourceMapWithUrlJsonTextSource = new HashMap<>();

    credentialSourceMapWithFileTextSource.put("file", "/path/to/file");
    credentialSourceMapWithFileJsonTextSource.put("file", "/path/to/file");

    credentialSourceMapWithUrlTextSource.put("url", "https://google.com");
    credentialSourceMapWithUrlJsonTextSource.put("url", "https://google.com");
    Map<String, String> headersMap = new HashMap<>();
    headersMap.put("header1", "value1");
    headersMap.put("header2", "value2");
    credentialSourceMapWithUrlTextSource.put("headers", headersMap);
    credentialSourceMapWithUrlJsonTextSource.put("headers", headersMap);

    Map<String, String> textFormat = new HashMap<>();
    textFormat.put("type", "text");

    Map<String, String> jsonTextFormat = new HashMap<>();
    jsonTextFormat.put("type", "json");
    jsonTextFormat.put("subject_token_field_name", "access_token");

    credentialSourceMapWithFileTextSource.put("format", textFormat);
    credentialSourceMapWithFileJsonTextSource.put("format", jsonTextFormat);

    credentialSourceMapWithUrlTextSource.put("format", textFormat);
    credentialSourceMapWithUrlJsonTextSource.put("format", jsonTextFormat);

    List<Map<String, Object>> sources =
        Arrays.asList(
            credentialSourceMapWithFileTextSource,
            credentialSourceMapWithFileJsonTextSource,
            credentialSourceMapWithUrlTextSource,
            credentialSourceMapWithUrlJsonTextSource);
    for (Map<String, Object> source : sources) {
      // Should not throw.
      assertDoesNotThrow(() -> new IdentityPoolCredentialSource(source));
    }
  }

  @Test
  void identityPoolCredentialSource_caseInsensitive() {
    Map<String, Object> credentialSourceMapWithFileTextSource = new HashMap<>();
    Map<String, Object> credentialSourceMapWithFileJsonTextSource = new HashMap<>();
    Map<String, Object> credentialSourceMapWithUrlTextSource = new HashMap<>();
    Map<String, Object> credentialSourceMapWithUrlJsonTextSource = new HashMap<>();

    credentialSourceMapWithFileTextSource.put("file", "/path/to/file");
    credentialSourceMapWithFileJsonTextSource.put("file", "/path/to/file");

    credentialSourceMapWithUrlTextSource.put("url", "https://google.com");
    credentialSourceMapWithUrlJsonTextSource.put("url", "https://google.com");
    Map<String, String> headersMap = new HashMap<>();
    headersMap.put("HeaDer1", "Value1");
    headersMap.put("HeaDer2", "Value2");
    credentialSourceMapWithUrlTextSource.put("headers", headersMap);
    credentialSourceMapWithUrlJsonTextSource.put("headers", headersMap);

    Map<String, String> textFormat = new HashMap<>();
    textFormat.put("type", "TEXT");

    Map<String, String> jsonTextFormat = new HashMap<>();
    jsonTextFormat.put("type", "JSON");
    jsonTextFormat.put("subject_token_field_name", "access_token");

    credentialSourceMapWithFileTextSource.put("format", textFormat);
    credentialSourceMapWithFileJsonTextSource.put("format", jsonTextFormat);

    credentialSourceMapWithUrlTextSource.put("format", textFormat);
    credentialSourceMapWithUrlJsonTextSource.put("format", jsonTextFormat);

    List<Map<String, Object>> sources =
        Arrays.asList(
            credentialSourceMapWithFileTextSource,
            credentialSourceMapWithFileJsonTextSource,
            credentialSourceMapWithUrlTextSource,
            credentialSourceMapWithUrlJsonTextSource);
    for (Map<String, Object> source : sources) {
      // Should not throw.
      assertDoesNotThrow(() -> new IdentityPoolCredentialSource(source));
    }
  }

  @Test
  void identityPoolCredentialSource_invalidSourceType() {
    HashMap<String, Object> credentialSourceMap = new HashMap<>();
    IllegalArgumentException e =
        assertThrows(
            IllegalArgumentException.class,
            () -> new IdentityPoolCredentialSource(credentialSourceMap));
    assertEquals(
        "Missing credential source file location, URL, or certificate. At least one must be"
            + " specified.",
        e.getMessage());
  }

  @Test
  void identityPoolCredentialSource_invalidFormatType() {
    Map<String, Object> credentialSourceMap = new HashMap<>();
    credentialSourceMap.put("url", "url");

    Map<String, String> format = new HashMap<>();
    format.put("type", "unsupportedType");
    credentialSourceMap.put("format", format);

    IllegalArgumentException e =
        assertThrows(
            IllegalArgumentException.class,
            () -> new IdentityPoolCredentialSource(credentialSourceMap));
    assertEquals("Invalid credential source format type: unsupportedType.", e.getMessage());
  }

  @Test
  void identityPoolCredentialSource_nullFormatType() {
    Map<String, Object> credentialSourceMap = new HashMap<>();
    credentialSourceMap.put("url", "url");

    Map<String, String> format = new HashMap<>();
    format.put("type", null);
    credentialSourceMap.put("format", format);

    IllegalArgumentException e =
        assertThrows(
            IllegalArgumentException.class,
            () -> new IdentityPoolCredentialSource(credentialSourceMap));
    assertEquals("Invalid credential source format type: null.", e.getMessage());
  }

  @Test
  void identityPoolCredentialSource_subjectTokenFieldNameUnset() {
    Map<String, Object> credentialSourceMap = new HashMap<>();
    credentialSourceMap.put("url", "url");

    Map<String, String> format = new HashMap<>();
    format.put("type", "json");
    credentialSourceMap.put("format", format);

    IllegalArgumentException e =
        assertThrows(
            IllegalArgumentException.class,
            () -> new IdentityPoolCredentialSource(credentialSourceMap));
    assertEquals(
        "When specifying a JSON credential type, the subject_token_field_name must be set.",
        e.getMessage());
  }

  @Test
  void builder_allFields() {
    List<String> scopes = Arrays.asList("scope1", "scope2");
    IdentityPoolCredentialSource credentialSource = createFileCredentialSource();

    IdentityPoolCredentials credentials =
        IdentityPoolCredentials.newBuilder()
            .setHttpTransportFactory(OAuth2Utils.HTTP_TRANSPORT_FACTORY)
            .setAudience("audience")
            .setSubjectTokenType("subjectTokenType")
            .setTokenUrl(STS_URL)
            .setTokenInfoUrl("tokenInfoUrl")
            .setCredentialSource(credentialSource)
            .setServiceAccountImpersonationUrl(SERVICE_ACCOUNT_IMPERSONATION_URL)
            .setQuotaProjectId("quotaProjectId")
            .setClientId("clientId")
            .setClientSecret("clientSecret")
            .setScopes(scopes)
            .setUniverseDomain("universeDomain")
            .build();

    assertEquals("audience", credentials.getAudience());
    assertEquals("subjectTokenType", credentials.getSubjectTokenType());
    assertEquals(STS_URL, credentials.getTokenUrl());
    assertEquals("tokenInfoUrl", credentials.getTokenInfoUrl());
    assertEquals(
        SERVICE_ACCOUNT_IMPERSONATION_URL, credentials.getServiceAccountImpersonationUrl());
    assertEquals(credentialSource, credentials.getCredentialSource());
    assertEquals("quotaProjectId", credentials.getQuotaProjectId());
    assertEquals("clientId", credentials.getClientId());
    assertEquals("clientSecret", credentials.getClientSecret());
    assertEquals(scopes, credentials.getScopes());
    assertEquals(SystemEnvironmentProvider.getInstance(), credentials.getEnvironmentProvider());
    assertEquals("universeDomain", credentials.getUniverseDomain());
  }

  @Test
  void builder_subjectTokenSupplier() {
    List<String> scopes = Arrays.asList("scope1", "scope2");

    IdentityPoolCredentials credentials =
        IdentityPoolCredentials.newBuilder()
            .setSubjectTokenSupplier(testProvider)
            .setHttpTransportFactory(OAuth2Utils.HTTP_TRANSPORT_FACTORY)
            .setAudience("audience")
            .setSubjectTokenType("subjectTokenType")
            .setTokenUrl(STS_URL)
            .setTokenInfoUrl("tokenInfoUrl")
            .setServiceAccountImpersonationUrl(SERVICE_ACCOUNT_IMPERSONATION_URL)
            .setQuotaProjectId("quotaProjectId")
            .setClientId("clientId")
            .setClientSecret("clientSecret")
            .setScopes(scopes)
            .build();

    assertEquals(testProvider, credentials.getIdentityPoolSubjectTokenSupplier());
  }

  @Test
  void builder_invalidWorkforceAudiences_throws() {
    List<String> invalidAudiences =
        Arrays.asList(
            "",
            "//iam.googleapis.com/projects/x23/locations/global/workloadIdentityPools/pool/providers/provider",
            "//iam.googleapis.com/locations/global/workforcepools/pool/providers/provider",
            "//iam.googleapis.com/locations/global/workforcePools/providers/provider",
            "//iam.googleapis.com/locations/global/workforcePools/providers",
            "//iam.googleapis.com/locations/global/workforcePools/",
            "//iam.googleapis.com/locations//workforcePools/providers",
            "//iam.googleapis.com/notlocations/global/workforcePools/providers",
            "//iam.googleapis.com/locations/global/workforce/providers");

    for (String audience : invalidAudiences) {
      IdentityPoolCredentials.Builder builder =
          IdentityPoolCredentials.newBuilder()
              .setWorkforcePoolUserProject("workforcePoolUserProject")
              .setHttpTransportFactory(OAuth2Utils.HTTP_TRANSPORT_FACTORY)
              .setAudience(audience)
              .setSubjectTokenType("subjectTokenType")
              .setTokenUrl(STS_URL)
              .setTokenInfoUrl("tokenInfoUrl")
              .setCredentialSource(createFileCredentialSource())
              .setQuotaProjectId("quotaProjectId");
      IllegalArgumentException e = assertThrows(IllegalArgumentException.class, builder::build);
      assertEquals(
          "The workforce_pool_user_project parameter should only be provided for a Workforce Pool"
              + " configuration.",
          e.getMessage());
    }
  }

  @Test
  void builder_emptyWorkforceUserProjectWithWorkforceAudience() {
    // No exception should be thrown.
    IdentityPoolCredentials credentials =
        IdentityPoolCredentials.newBuilder()
            .setWorkforcePoolUserProject("")
            .setHttpTransportFactory(OAuth2Utils.HTTP_TRANSPORT_FACTORY)
            .setAudience(
                "//iam.googleapis.com/locations/global/workforcePools/pool/providers/provider")
            .setSubjectTokenType("subjectTokenType")
            .setTokenUrl(STS_URL)
            .setTokenInfoUrl("tokenInfoUrl")
            .setCredentialSource(createFileCredentialSource())
            .setQuotaProjectId("quotaProjectId")
            .build();

    assertTrue(credentials.isWorkforcePoolConfiguration());
  }

  @Test
  void builder_supplierAndCredSourceThrows() {
    IdentityPoolCredentials.Builder builder =
        IdentityPoolCredentials.newBuilder()
            .setSubjectTokenSupplier(testProvider)
            .setHttpTransportFactory(OAuth2Utils.HTTP_TRANSPORT_FACTORY)
            .setAudience("audience")
            .setSubjectTokenType("subjectTokenType")
            .setTokenUrl(STS_URL)
            .setCredentialSource(createFileCredentialSource());
    IllegalArgumentException exception =
        assertThrows(IllegalArgumentException.class, builder::build);
    assertEquals(
        "IdentityPoolCredentials cannot have both a subjectTokenSupplier and a credentialSource.",
        exception.getMessage());
  }

  @Test
  void builder_noSupplierOrCredSourceThrows() {
    IdentityPoolCredentials.Builder builder =
        IdentityPoolCredentials.newBuilder()
            .setHttpTransportFactory(OAuth2Utils.HTTP_TRANSPORT_FACTORY)
            .setAudience("audience")
            .setSubjectTokenType("subjectTokenType")
            .setTokenUrl(STS_URL);
    IllegalArgumentException exception =
        assertThrows(IllegalArgumentException.class, builder::build);
    assertEquals(
        "A subjectTokenSupplier or a credentialSource must be provided.", exception.getMessage());
  }

  @Test
  void builder_missingUniverseDomain_defaults() {
    List<String> scopes = Arrays.asList("scope1", "scope2");
    IdentityPoolCredentialSource credentialSource = createFileCredentialSource();

    IdentityPoolCredentials credentials =
        IdentityPoolCredentials.newBuilder()
            .setHttpTransportFactory(OAuth2Utils.HTTP_TRANSPORT_FACTORY)
            .setAudience("audience")
            .setSubjectTokenType("subjectTokenType")
            .setTokenUrl(STS_URL)
            .setTokenInfoUrl("tokenInfoUrl")
            .setCredentialSource(credentialSource)
            .setServiceAccountImpersonationUrl(SERVICE_ACCOUNT_IMPERSONATION_URL)
            .setQuotaProjectId("quotaProjectId")
            .setClientId("clientId")
            .setClientSecret("clientSecret")
            .setScopes(scopes)
            .build();

    assertEquals("audience", credentials.getAudience());
    assertEquals("subjectTokenType", credentials.getSubjectTokenType());
    assertEquals(STS_URL, credentials.getTokenUrl());
    assertEquals("tokenInfoUrl", credentials.getTokenInfoUrl());
    assertEquals(
        SERVICE_ACCOUNT_IMPERSONATION_URL, credentials.getServiceAccountImpersonationUrl());
    assertEquals(credentialSource, credentials.getCredentialSource());
    assertEquals("quotaProjectId", credentials.getQuotaProjectId());
    assertEquals("clientId", credentials.getClientId());
    assertEquals("clientSecret", credentials.getClientSecret());
    assertEquals(scopes, credentials.getScopes());
    assertEquals(SystemEnvironmentProvider.getInstance(), credentials.getEnvironmentProvider());
    assertEquals(GOOGLE_DEFAULT_UNIVERSE, credentials.getUniverseDomain());
  }

  @Test
  void newBuilder_allFields() {
    List<String> scopes = Arrays.asList("scope1", "scope2");

    IdentityPoolCredentials credentials =
        IdentityPoolCredentials.newBuilder()
            .setHttpTransportFactory(OAuth2Utils.HTTP_TRANSPORT_FACTORY)
            .setAudience(
                "//iam.googleapis.com/locations/global/workforcePools/pool/providers/provider")
            .setSubjectTokenType("subjectTokenType")
            .setTokenUrl(STS_URL)
            .setTokenInfoUrl("tokenInfoUrl")
            .setCredentialSource(createFileCredentialSource())
            .setServiceAccountImpersonationUrl(SERVICE_ACCOUNT_IMPERSONATION_URL)
            .setQuotaProjectId("quotaProjectId")
            .setClientId("clientId")
            .setClientSecret("clientSecret")
            .setScopes(scopes)
            .setWorkforcePoolUserProject("workforcePoolUserProject")
            .setUniverseDomain("universeDomain")
            .build();

    IdentityPoolCredentials newBuilderCreds =
        IdentityPoolCredentials.newBuilder(credentials).build();
    assertEquals(credentials.getAudience(), newBuilderCreds.getAudience());
    assertEquals(credentials.getSubjectTokenType(), newBuilderCreds.getSubjectTokenType());
    assertEquals(credentials.getTokenUrl(), newBuilderCreds.getTokenUrl());
    assertEquals(credentials.getTokenInfoUrl(), newBuilderCreds.getTokenInfoUrl());
    assertEquals(
        credentials.getServiceAccountImpersonationUrl(),
        newBuilderCreds.getServiceAccountImpersonationUrl());
    assertEquals(credentials.getCredentialSource(), newBuilderCreds.getCredentialSource());
    assertEquals(credentials.getQuotaProjectId(), newBuilderCreds.getQuotaProjectId());
    assertEquals(credentials.getClientId(), newBuilderCreds.getClientId());
    assertEquals(credentials.getClientSecret(), newBuilderCreds.getClientSecret());
    assertEquals(credentials.getScopes(), newBuilderCreds.getScopes());
    assertEquals(credentials.getEnvironmentProvider(), newBuilderCreds.getEnvironmentProvider());
    assertEquals(
        credentials.getWorkforcePoolUserProject(), newBuilderCreds.getWorkforcePoolUserProject());
    assertEquals(credentials.getUniverseDomain(), newBuilderCreds.getUniverseDomain());
  }

  @Test
  void newBuilder_noUniverseDomain_defaults() {
    List<String> scopes = Arrays.asList("scope1", "scope2");

    IdentityPoolCredentials credentials =
        IdentityPoolCredentials.newBuilder()
            .setHttpTransportFactory(OAuth2Utils.HTTP_TRANSPORT_FACTORY)
            .setAudience(
                "//iam.googleapis.com/locations/global/workforcePools/pool/providers/provider")
            .setSubjectTokenType("subjectTokenType")
            .setTokenUrl(STS_URL)
            .setTokenInfoUrl("tokenInfoUrl")
            .setCredentialSource(createFileCredentialSource())
            .setServiceAccountImpersonationUrl(SERVICE_ACCOUNT_IMPERSONATION_URL)
            .setQuotaProjectId("quotaProjectId")
            .setClientId("clientId")
            .setClientSecret("clientSecret")
            .setScopes(scopes)
            .setWorkforcePoolUserProject("workforcePoolUserProject")
            .build();

    IdentityPoolCredentials newBuilderCreds =
        IdentityPoolCredentials.newBuilder(credentials).build();
    assertEquals(credentials.getAudience(), newBuilderCreds.getAudience());
    assertEquals(credentials.getSubjectTokenType(), newBuilderCreds.getSubjectTokenType());
    assertEquals(credentials.getTokenUrl(), newBuilderCreds.getTokenUrl());
    assertEquals(credentials.getTokenInfoUrl(), newBuilderCreds.getTokenInfoUrl());
    assertEquals(
        credentials.getServiceAccountImpersonationUrl(),
        newBuilderCreds.getServiceAccountImpersonationUrl());
    assertEquals(credentials.getCredentialSource(), newBuilderCreds.getCredentialSource());
    assertEquals(credentials.getQuotaProjectId(), newBuilderCreds.getQuotaProjectId());
    assertEquals(credentials.getClientId(), newBuilderCreds.getClientId());
    assertEquals(credentials.getClientSecret(), newBuilderCreds.getClientSecret());
    assertEquals(credentials.getScopes(), newBuilderCreds.getScopes());
    assertEquals(credentials.getEnvironmentProvider(), newBuilderCreds.getEnvironmentProvider());
    assertEquals(
        credentials.getWorkforcePoolUserProject(), newBuilderCreds.getWorkforcePoolUserProject());
    assertEquals(GOOGLE_DEFAULT_UNIVERSE, newBuilderCreds.getUniverseDomain());
  }

  @Test
  void serialize() throws IOException, ClassNotFoundException {
    IdentityPoolCredentials testCredentials =
        IdentityPoolCredentials.newBuilder(createBaseFileSourcedCredentials())
            .setServiceAccountImpersonationUrl(SERVICE_ACCOUNT_IMPERSONATION_URL)
            .setQuotaProjectId("quotaProjectId")
            .setClientId("clientId")
            .setClientSecret("clientSecret")
            .setUniverseDomain("universeDomain")
            .build();

    IdentityPoolCredentials deserializedCredentials = serializeAndDeserialize(testCredentials);
    assertEquals(testCredentials, deserializedCredentials);
    assertEquals(testCredentials.hashCode(), deserializedCredentials.hashCode());
    assertEquals(testCredentials.toString(), deserializedCredentials.toString());
    assertSame(Clock.SYSTEM, deserializedCredentials.clock);
  }

  @Test
  void build_withCertificateSource_succeeds() throws Exception {
    // Set up credential source for certificate type.
    Map<String, Object> certificateMap = new HashMap<>();
    certificateMap.put("use_default_certificate_config", false);
    certificateMap.put("certificate_config_location", "testresources/mtls/certificate_config.json");
    Map<String, Object> credentialSourceMap = new HashMap<>();
    credentialSourceMap.put("certificate", certificateMap);
    IdentityPoolCredentialSource credentialSource =
        new IdentityPoolCredentialSource(credentialSourceMap);
    MockExternalAccountCredentialsTransportFactory mockTransportFactory =
        new MockExternalAccountCredentialsTransportFactory();

    // Build credentials.
    IdentityPoolCredentials credentials =
        IdentityPoolCredentials.newBuilder()
            .setHttpTransportFactory(mockTransportFactory)
            .setAudience("test-audience")
            .setSubjectTokenType("test-token-type")
            .setCredentialSource(credentialSource)
            .build();

    // Verify successful creation and correct internal setup.
    assertNotNull(credentials, "Credentials should be successfully created");
    assertTrue(
        credentials.getIdentityPoolSubjectTokenSupplier()
            instanceof CertificateIdentityPoolSubjectTokenSupplier,
        "Subject token supplier should be for certificates");
    assertEquals(
        IdentityPoolCredentials.CERTIFICATE_METRICS_HEADER_VALUE,
        credentials.getCredentialSourceType(),
        "Metrics header should indicate certificate source");
  }

  @Test
  void build_withDefaultCertificateConfig_success()
      throws IOException, KeyStoreException, CertificateException, NoSuchAlgorithmException {
    // Set up credential source for certificate type.
    Map<String, Object> certificateMap = new HashMap<>();
    certificateMap.put("use_default_certificate_config", true);
    Map<String, Object> credentialSourceMap = new HashMap<>();
    credentialSourceMap.put("certificate", certificateMap);
    IdentityPoolCredentialSource credentialSource =
        new IdentityPoolCredentialSource(credentialSourceMap);
    MockExternalAccountCredentialsTransportFactory mockTransportFactory =
        new MockExternalAccountCredentialsTransportFactory();

    // Use the pre-existing test configuration file to bypass well-known path resolution.
    EnvironmentProvider mockEnvProvider =
        name ->
            "GOOGLE_API_CERTIFICATE_CONFIG".equals(name)
                ? new File("testresources/mtls/certificate_config.json").getAbsolutePath()
                : null;

    // Build credentials using the default provider (no setX509Provider).
    IdentityPoolCredentials credentials =
        IdentityPoolCredentials.newBuilder()
            .setHttpTransportFactory(mockTransportFactory)
            .setEnvironmentProvider(mockEnvProvider)
            .setAudience("test-audience")
            .setSubjectTokenType("test-token-type")
            .setCredentialSource(credentialSource)
            .build();

    // Verify successful creation and correct internal setup.
    assertNotNull(credentials, "Credentials should be successfully created");
    assertTrue(
        credentials.getIdentityPoolSubjectTokenSupplier()
            instanceof CertificateIdentityPoolSubjectTokenSupplier,
        "Subject token supplier should be for certificates");
    assertEquals(
        IdentityPoolCredentials.CERTIFICATE_METRICS_HEADER_VALUE,
        credentials.getCredentialSourceType(),
        "Metrics header should indicate certificate source");
  }

  @Test
  void build_withDefaultCertificate_throwsOnTransportInitFailure() {
    // Setup credential source to use default certificate config.
    Map<String, Object> certificateMap = new HashMap<>();
    certificateMap.put("use_default_certificate_config", false);
    certificateMap.put("certificate_config_location", "/non/existing/path/to/certificate.json");
    Map<String, Object> credentialSourceMap = new HashMap<>();
    credentialSourceMap.put("certificate", certificateMap);
    IdentityPoolCredentialSource credentialSource =
        new IdentityPoolCredentialSource(credentialSourceMap);

    // Expect RuntimeException during build due to mTLS setup failure because the certificate file
    // doesn't exist.
    IdentityPoolCredentials.Builder builder =
        IdentityPoolCredentials.newBuilder()
            .setHttpTransportFactory(new MockExternalAccountCredentialsTransportFactory())
            .setAudience("test-audience")
            .setSubjectTokenType("test-token-type")
            .setCredentialSource(credentialSource);
    RuntimeException exception = assertThrows(RuntimeException.class, builder::build);

    assertEquals(
        "Failed to initialize IdentityPoolCredentials from certificate source due to an I/O error.",
        exception.getMessage());
  }

  @Test
  void build_withCustomProvider_throwsOnGetKeyStore()
      throws IOException, KeyStoreException, CertificateException, NoSuchAlgorithmException {
    // Simulate a scenario where the X509Provider fails to load the KeyStore, typically due to an
    // IOException when reading the certificate or private key files.
    KeyStore keyStore = KeyStore.getInstance("JKS");
    keyStore.load(null, null);
    TestX509Provider x509Provider = new TestX509Provider(keyStore, "/path/to/certificate.json");
    x509Provider.setShouldThrowOnGetKeyStore(true); // Configure to throw

    Map<String, Object> certificateMap = new HashMap<>();
    certificateMap.put("certificate_config_location", "/path/to/certificate.json");

    // Expect RuntimeException because the constructor wraps the IOException.
    RuntimeException exception =
        assertThrows(
            RuntimeException.class,
            () -> createCredentialsWithCertificate(x509Provider, certificateMap));

    // Verify the cause is the expected IOException from the mock.
    assertNotNull(exception.getCause());
    assertTrue(exception.getCause() instanceof IOException);
    assertEquals("Simulated IOException on get keystore", exception.getCause().getMessage());

    // Verify the wrapper exception message
    assertEquals(
        "Failed to initialize IdentityPoolCredentials from certificate source due to an I/O error.",
        exception.getMessage());
  }

  @Test
  void build_withCustomProvider_throwsOnGetCertificatePath()
      throws IOException, KeyStoreException, CertificateException, NoSuchAlgorithmException {
    // Simulate a scenario where path resolution fails during build with a custom
    // provider.
    // We achieve this by passing a non-existent configuration path which causes
    // MtlsUtils to throw
    // IOException.
    KeyStore keyStore = KeyStore.getInstance("JKS");
    keyStore.load(null, null);
    TestX509Provider x509Provider = new TestX509Provider(keyStore, "/path/to/certificate.json");

    Map<String, Object> certificateMap = new HashMap<>();
    certificateMap.put("certificate_config_location", "/non/existent/path.json");

    // Expect RuntimeException because the constructor wraps the IOException.
    RuntimeException exception =
        assertThrows(
            RuntimeException.class,
            () -> createCredentialsWithCertificate(x509Provider, certificateMap));

    // Verify the cause is the expected IOException (or subclass) from MtlsUtils.
    assertNotNull(exception.getCause());
    assertTrue(exception.getCause() instanceof IOException);

    // Verify the wrapper exception message
    assertEquals(
        "Failed to initialize IdentityPoolCredentials from certificate source due to an I/O error.",
        exception.getMessage());
  }

  private void createCredentialsWithCertificate(
      X509Provider x509Provider, Map<String, Object> certificateMap) {
    Map<String, Object> credentialSourceMap = new HashMap<>();
    credentialSourceMap.put("certificate", certificateMap);
    IdentityPoolCredentialSource credentialSource =
        new IdentityPoolCredentialSource(credentialSourceMap);

    IdentityPoolCredentials.newBuilder()
        .setX509Provider(x509Provider)
        .setHttpTransportFactory(new MockExternalAccountCredentialsTransportFactory())
        .setAudience("")
        .setSubjectTokenType("")
        .setCredentialSource(credentialSource)
        .build();
  }

  static InputStream writeIdentityPoolCredentialsStream(
      String tokenUrl,
      String url,
      @Nullable String serviceAccountImpersonationUrl,
      @Nullable Map<String, Object> serviceAccountImpersonationOptionsMap)
      throws IOException {
    GenericJson json = new GenericJson();
    json.put("audience", "audience");
    json.put("subject_token_type", "subjectTokenType");
    json.put("token_url", tokenUrl);
    json.put("token_info_url", "tokenInfoUrl");
    json.put("type", GoogleCredentialsInfo.EXTERNAL_ACCOUNT_CREDENTIALS.getFileType());

    if (serviceAccountImpersonationUrl != null) {
      json.put("service_account_impersonation_url", serviceAccountImpersonationUrl);
    }

    if (serviceAccountImpersonationOptionsMap != null) {
      json.put("service_account_impersonation", serviceAccountImpersonationOptionsMap);
    }

    GenericJson credentialSource = new GenericJson();
    GenericJson headers = new GenericJson();
    headers.put("Metadata-Flavor", "Google");
    credentialSource.put("url", url);
    credentialSource.put("headers", headers);

    json.put("credential_source", credentialSource);
    return TestUtils.jsonToInputStream(json);
  }

  private static IdentityPoolCredentialSource buildUrlBasedCredentialSource(String url) {
    return buildUrlBasedCredentialSource(url, /* formatMap= */ null);
  }

  private static IdentityPoolCredentialSource buildUrlBasedCredentialSource(
      String url, Map<String, String> formatMap) {
    Map<String, Object> credentialSourceMap = new HashMap<>();
    Map<String, String> headers = new HashMap<>();
    headers.put("Metadata-Flavor", "Google");
    credentialSourceMap.put("url", url);
    credentialSourceMap.put("headers", headers);
    credentialSourceMap.put("format", formatMap);

    return new IdentityPoolCredentialSource(credentialSourceMap);
  }

  private IdentityPoolCredentials createBaseFileSourcedCredentials() {
    Map<String, Object> fileCredentialSourceMap = new HashMap<>();
    fileCredentialSourceMap.put("file", "file"); // Consider using a real temp file setup if needed
    IdentityPoolCredentialSource identityPoolCredentialSource =
        new IdentityPoolCredentialSource(fileCredentialSourceMap);

    return IdentityPoolCredentials.newBuilder()
        .setHttpTransportFactory(OAuth2Utils.HTTP_TRANSPORT_FACTORY)
        .setAudience(
            "//iam.googleapis.com/projects/123/locations/global/workloadIdentityPools/pool/providers/provider")
        .setSubjectTokenType("subjectTokenType")
        .setTokenUrl(STS_URL)
        .setTokenInfoUrl("tokenInfoUrl")
        .setCredentialSource(identityPoolCredentialSource)
        .build();
  }

  private IdentityPoolCredentialSource createFileCredentialSource() {
    Map<String, Object> fileCredentialSourceMap = new HashMap<>();
    fileCredentialSourceMap.put("file", "file");
    return new IdentityPoolCredentialSource(fileCredentialSourceMap);
  }

  private IdentityPoolCredentialSource createFileCredentialSource(
      String filePath, Map<String, String> formatMap) {
    Map<String, Object> fileCredentialSourceMap = new HashMap<>();
    fileCredentialSourceMap.put("file", filePath);
    fileCredentialSourceMap.put("format", formatMap);
    return new IdentityPoolCredentialSource(fileCredentialSourceMap);
  }

  static class MockExternalAccountCredentialsTransportFactory implements HttpTransportFactory {

    MockExternalAccountCredentialsTransport transport =
        new MockExternalAccountCredentialsTransport();

    @Override
    public HttpTransport create() {
      return transport;
    }
  }

  private static class TestX509Provider extends X509Provider {
    private final KeyStore keyStore;
    private final String certificatePath;
    private boolean shouldThrowOnGetKeyStore = false;

    TestX509Provider(KeyStore keyStore, String certificatePath) {
      super();
      this.keyStore = keyStore;
      this.certificatePath = certificatePath;
    }

    @Override
    public KeyStore getKeyStore() throws IOException {
      if (shouldThrowOnGetKeyStore) {
        throw new IOException("Simulated IOException on get keystore");
      }
      return keyStore;
    }

    void setShouldThrowOnGetKeyStore(boolean shouldThrow) {
      this.shouldThrowOnGetKeyStore = shouldThrow;
    }
  }

  @Test
  void builder_actorTokenWithNonMtlsTransportFactory_throws() {
    IdentityPoolCredentialSource credentialSource = createFileCredentialSource();

    IllegalArgumentException e =
        assertThrows(
            IllegalArgumentException.class,
            () ->
                IdentityPoolCredentials.newBuilder()
                    .setHttpTransportFactory(OAuth2Utils.HTTP_TRANSPORT_FACTORY)
                    .setAudience("audience")
                    .setSubjectTokenType("subjectTokenType")
                    .setTokenUrl("https://invalid.googleapis.com/")
                    .setCredentialSource(credentialSource)
                    .setActorTokenType("actorTokenType")
                    .setActorTokenSupplier(
                        new IdentityPoolActorTokenSupplier() {
                          @Override
                          public String getActorToken(ExternalAccountSupplierContext context) {
                            return "token";
                          }
                        })
                    .build());

    assertEquals(
        "Actor tokens are only supported for mTLS token exchanges. Please configure a certificate"
            + " configuration in the credential source or provide an MtlsHttpTransportFactory"
            + " constructed with a KeyStore.",
        e.getMessage());
  }

  @Test
  void builder_actorTokenWithMissingTokenType_throws() {
    IdentityPoolCredentialSource credentialSource = createFileCredentialSource();

    IllegalArgumentException e =
        assertThrows(
            IllegalArgumentException.class,
            () ->
                IdentityPoolCredentials.newBuilder()
                    .setHttpTransportFactory(OAuth2Utils.HTTP_TRANSPORT_FACTORY)
                    .setAudience("audience")
                    .setSubjectTokenType("subjectTokenType")
                    .setTokenUrl("https://sts.mtls.googleapis.com/")
                    .setCredentialSource(credentialSource)
                    .setActorTokenSupplier(
                        new IdentityPoolActorTokenSupplier() {
                          @Override
                          public String getActorToken(ExternalAccountSupplierContext context) {
                            return "token";
                          }
                        })
                    .build());

    assertEquals(
        "An actorTokenType must be specified when an actorTokenSupplier is configured.",
        e.getMessage());
  }

  @Test
  void builder_actorTokenWithInvalidCredentialSource_throws() {
    MockExternalAccountCredentialsTransportFactory transportFactory =
        new MockExternalAccountCredentialsTransportFactory();

    Map<String, String> formatMap = new HashMap<>();
    formatMap.put("type", "json");
    formatMap.put("subject_token_field_name", "subject_token");
    formatMap.put("actor_token_field_name", "actor_token");

    // Not a file credential source
    IdentityPoolCredentialSource credentialSource =
        buildUrlBasedCredentialSource(transportFactory.transport.getMetadataUrl(), formatMap);

    IllegalArgumentException e =
        assertThrows(
            IllegalArgumentException.class,
            () ->
                IdentityPoolCredentials.newBuilder()
                    .setHttpTransportFactory(OAuth2Utils.HTTP_TRANSPORT_FACTORY)
                    .setAudience("audience")
                    .setSubjectTokenType("subjectTokenType")
                    .setTokenUrl("https://sts.mtls.googleapis.com/") // Valid URL
                    .setCredentialSource(credentialSource) // Invalid source for actor tokens
                    .build());

    assertEquals(
        "Actor tokens are currently only supported for file-based credential sources.",
        e.getMessage());
  }

  @Test
  void builder_supplierSourcedActorToken() throws Exception {
    KeyStore ks = createPopulatedKeyStore();
    MtlsHttpTransportFactory mtlsTransport = new MtlsHttpTransportFactory(ks);

    IdentityPoolCredentials credentials =
        IdentityPoolCredentials.newBuilder()
            .setSubjectTokenSupplier(testProvider)
            .setActorTokenSupplier(testActorSupplier)
            .setActorTokenType("urn:ietf:params:oauth:token-type:jwt")
            .setHttpTransportFactory(mtlsTransport)
            .setAudience("audience")
            .setSubjectTokenType("subjectTokenType")
            .setTokenUrl("https://sts.mtls.googleapis.com/v1/token")
            .build();

    assertNotNull(credentials);
    assertEquals("urn:ietf:params:oauth:token-type:jwt", credentials.getActorTokenType());
  }

  @Test
  void createScoped_supplierSourcedWithActorToken_preservesCustomSuppliers() throws Exception {
    KeyStore ks = createPopulatedKeyStore();
    MtlsHttpTransportFactory mtlsTransport = new MtlsHttpTransportFactory(ks);

    IdentityPoolCredentials credentials =
        IdentityPoolCredentials.newBuilder()
            .setHttpTransportFactory(mtlsTransport)
            .setSubjectTokenSupplier(testProvider)
            .setActorTokenSupplier(testActorSupplier)
            .setActorTokenType("urn:ietf:params:oauth:token-type:jwt")
            .setAudience("audience")
            .setSubjectTokenType("subjectTokenType")
            .setTokenUrl("https://sts.mtls.googleapis.com/v1/token")
            .build();

    List<String> newScopes = Arrays.asList("https://www.googleapis.com/auth/cloud-platform");
    IdentityPoolCredentials scoped = credentials.createScoped(newScopes);

    assertNotNull(scoped);
    assertEquals(credentials.getActorTokenType(), scoped.getActorTokenType());
    assertEquals(newScopes, scoped.getScopes());
    assertSame(testProvider, scoped.getIdentityPoolSubjectTokenSupplier());
    assertSame(testActorSupplier, scoped.getIdentityPoolActorTokenSupplier());
  }

  @Test
  void createScoped_fileSourcedWithActorToken_preservesSharedSupplierInstance() throws Exception {
    Map<String, String> formatMap = new HashMap<>();
    formatMap.put("type", "json");
    formatMap.put("subject_token_field_name", "subject_token");
    formatMap.put("actor_token_field_name", "actor_token");

    IdentityPoolCredentialSource credentialSource =
        createFileCredentialSource("credential.json", formatMap);

    KeyStore ks = createPopulatedKeyStore();
    MtlsHttpTransportFactory mtlsTransport = new MtlsHttpTransportFactory(ks);

    IdentityPoolCredentials credentials =
        IdentityPoolCredentials.newBuilder()
            .setHttpTransportFactory(mtlsTransport)
            .setCredentialSource(credentialSource)
            .setActorTokenType("urn:ietf:params:oauth:token-type:jwt")
            .setAudience("audience")
            .setSubjectTokenType("subjectTokenType")
            .setTokenUrl("https://sts.mtls.googleapis.com/v1/token")
            .build();

    // Verify initial instance shares the single supplier instance
    assertSame(
        credentials.getIdentityPoolSubjectTokenSupplier(),
        credentials.getIdentityPoolActorTokenSupplier());

    // Clone with new scopes
    List<String> newScopes = Arrays.asList("https://www.googleapis.com/auth/cloud-platform");
    IdentityPoolCredentials scoped = credentials.createScoped(newScopes);

    assertNotNull(scoped);
    assertEquals(credentials.getActorTokenType(), scoped.getActorTokenType());
    assertEquals(newScopes, scoped.getScopes());
    // Verify scoped clone maintains a single shared supplier instance for its own cache
    assertSame(
        scoped.getIdentityPoolSubjectTokenSupplier(), scoped.getIdentityPoolActorTokenSupplier());
  }

  @Test
  void refreshAccessToken_withActorToken_injectsActingPartyIntoStsRequest() throws Exception {
    MockExternalAccountCredentialsTransportFactory mockTransportFactory =
        new MockExternalAccountCredentialsTransportFactory();
    KeyStore ks = createPopulatedKeyStore();
    MtlsHttpTransportFactory mtlsTransport = new MtlsHttpTransportFactory(ks);

    IdentityPoolCredentials credential =
        new IdentityPoolCredentials(
            IdentityPoolCredentials.newBuilder()
                .setSubjectTokenSupplier(testProvider)
                .setActorTokenSupplier(testActorSupplier)
                .setActorTokenType("urn:ietf:params:oauth:token-type:jwt")
                .setAudience(
                    "//iam.googleapis.com/projects/123/locations/global/workloadIdentityPools/pool/providers/provider")
                .setSubjectTokenType("urn:ietf:params:oauth:token-type:id_token")
                .setTokenUrl(mockTransportFactory.transport.getStsMtlsUrl())
                .setHttpTransportFactory(mtlsTransport)) {
          @Override
          protected AccessToken exchangeExternalCredentialForAccessToken(
              StsTokenExchangeRequest stsTokenExchangeRequest,
              HttpTransportFactory cycleTransportFactory)
              throws IOException {
            return super.exchangeExternalCredentialForAccessToken(
                stsTokenExchangeRequest, mockTransportFactory);
          }
        };

    AccessToken token = credential.refreshAccessToken();
    assertEquals(mockTransportFactory.transport.getAccessToken(), token.getTokenValue());

    Map<String, String> query =
        TestUtils.parseQuery(mockTransportFactory.transport.getLastRequest().getContentAsString());
    assertEquals("testActorToken", query.get("actor_token"));
    assertEquals("urn:ietf:params:oauth:token-type:jwt", query.get("actor_token_type"));
  }

  @Test
  void serialization_withX509Provider_succeeds() throws Exception {
    KeyStore ks = createPopulatedKeyStore();
    MtlsHttpTransportFactory mtlsTransport = new MtlsHttpTransportFactory(ks);
    X509Provider x509Provider = new TestX509Provider(ks, "certificate_config_location");

    IdentityPoolCredentials credentials =
        IdentityPoolCredentials.newBuilder()
            .setHttpTransportFactory(mtlsTransport)
            .setSubjectTokenSupplier(testProvider)
            .setX509Provider(x509Provider)
            .setAudience("audience")
            .setSubjectTokenType("subjectTokenType")
            .setTokenUrl("https://sts.mtls.googleapis.com/v1/token")
            .build();

    serializeAndDeserialize(credentials);
  }

  @Test
  void builder_actorTokenTypeWithoutSupplier_throws() {
    IdentityPoolCredentialSource credentialSource = createFileCredentialSource();
    IllegalArgumentException exception =
        assertThrows(
            IllegalArgumentException.class,
            () ->
                IdentityPoolCredentials.newBuilder()
                    .setCredentialSource(credentialSource)
                    .setAudience("audience")
                    .setSubjectTokenType("subjectTokenType")
                    .setTokenUrl("https://sts.googleapis.com/v1/token")
                    .setActorTokenType("urn:ietf:params:oauth:token-type:jwt")
                    .build());
    assertEquals(
        "An actorTokenSupplier must be specified when an actorTokenType is configured.",
        exception.getMessage());
  }

  @Test
  void builder_fileWithCertificateConfig_initializesMtlsTransport() throws Exception {
    Map<String, Object> certMap = new HashMap<>();
    certMap.put("use_default_certificate_config", true);

    Map<String, Object> sourceMap = new HashMap<>();
    sourceMap.put("file", "credential.json");
    sourceMap.put("certificate", certMap);

    IdentityPoolCredentialSource credentialSource = new IdentityPoolCredentialSource(sourceMap);

    KeyStore ks = createPopulatedKeyStore();
    X509Provider x509Provider = new TestX509Provider(ks, "certificate_config_location");

    IdentityPoolCredentials credentials =
        IdentityPoolCredentials.newBuilder()
            .setCredentialSource(credentialSource)
            .setX509Provider(x509Provider)
            .setAudience("audience")
            .setSubjectTokenType("subjectTokenType")
            .setTokenUrl("https://sts.mtls.googleapis.com/v1/token")
            .build();

    assertNotNull(credentials);
    assertNotNull(credentials.getTransportFactory());
    assertTrue(credentials.getTransportFactory() instanceof MtlsHttpTransportFactory);
  }

  @Test
  void toBuilder_preservesConfiguration() throws Exception {
    KeyStore ks = createPopulatedKeyStore();
    MtlsHttpTransportFactory mtlsTransport = new MtlsHttpTransportFactory(ks);

    IdentityPoolCredentials credentials =
        IdentityPoolCredentials.newBuilder()
            .setHttpTransportFactory(mtlsTransport)
            .setSubjectTokenSupplier(testProvider)
            .setActorTokenSupplier(testActorSupplier)
            .setActorTokenType("urn:ietf:params:oauth:token-type:jwt")
            .setAudience("audience")
            .setSubjectTokenType("subjectTokenType")
            .setTokenUrl("https://sts.mtls.googleapis.com/v1/token")
            .build();

    IdentityPoolCredentials rebuilt = credentials.toBuilder().build();

    assertNotNull(rebuilt);
    assertEquals(credentials.getActorTokenType(), rebuilt.getActorTokenType());
    assertSame(testProvider, rebuilt.getIdentityPoolSubjectTokenSupplier());
    assertSame(testActorSupplier, rebuilt.getIdentityPoolActorTokenSupplier());
  }

  @Test
  void builder_actorTokenWithX509Provider_succeeds() throws Exception {
    KeyStore ks = createPopulatedKeyStore();
    X509Provider x509Provider = new TestX509Provider(ks, "certificate_config_location");
    MtlsHttpTransportFactory mtlsTransport = new MtlsHttpTransportFactory(ks);

    IdentityPoolCredentials credentials =
        IdentityPoolCredentials.newBuilder()
            .setSubjectTokenSupplier(testProvider)
            .setActorTokenSupplier(testActorSupplier)
            .setActorTokenType("urn:ietf:params:oauth:token-type:jwt")
            .setHttpTransportFactory(mtlsTransport)
            .setX509Provider(x509Provider)
            .setAudience("audience")
            .setSubjectTokenType("subjectTokenType")
            .setTokenUrl("https://sts.mtls.googleapis.com/v1/token")
            .build();

    assertNotNull(credentials);
    assertEquals("urn:ietf:params:oauth:token-type:jwt", credentials.getActorTokenType());
  }

  @Test
  void toBuilder_preservesActorTokenType() throws Exception {
    KeyStore ks = createPopulatedKeyStore();
    MtlsHttpTransportFactory mtlsTransport = new MtlsHttpTransportFactory(ks);

    IdentityPoolCredentials credentials =
        IdentityPoolCredentials.newBuilder()
            .setHttpTransportFactory(mtlsTransport)
            .setSubjectTokenSupplier(testProvider)
            .setActorTokenSupplier(testActorSupplier)
            .setActorTokenType("urn:ietf:params:oauth:token-type:jwt")
            .setAudience("audience")
            .setSubjectTokenType("subjectTokenType")
            .setTokenUrl("https://sts.mtls.googleapis.com/v1/token")
            .build();

    IdentityPoolCredentials rebuilt = credentials.toBuilder().build();

    assertNotNull(rebuilt);
    assertEquals("urn:ietf:params:oauth:token-type:jwt", rebuilt.getActorTokenType());
    assertSame(testProvider, rebuilt.getIdentityPoolSubjectTokenSupplier());
    assertSame(testActorSupplier, rebuilt.getIdentityPoolActorTokenSupplier());
  }

  @Test
  void builder_actorTokenWithoutMtls_throws() {
    IllegalArgumentException e =
        assertThrows(
            IllegalArgumentException.class,
            () ->
                IdentityPoolCredentials.newBuilder()
                    .setSubjectTokenSupplier(testProvider)
                    .setActorTokenSupplier(testActorSupplier)
                    .setActorTokenType("urn:ietf:params:oauth:token-type:jwt")
                    .setHttpTransportFactory(OAuth2Utils.HTTP_TRANSPORT_FACTORY)
                    .setAudience("audience")
                    .setSubjectTokenType("subjectTokenType")
                    .setTokenUrl("https://sts.googleapis.com/v1/token")
                    .build());
    assertTrue(
        e.getMessage().contains("Actor tokens are only supported for mTLS token exchanges."));
  }

  @Test
  void builder_actorTokenWithNoArgMtlsFactory_throws() throws Exception {
    // A no-arg MtlsHttpTransportFactory (e.g. from deserialization) has no KeyStore,
    // so isMtlsConfigured() should return false and building should fail.
    MtlsHttpTransportFactory noArgFactory = new MtlsHttpTransportFactory();
    assertFalse(noArgFactory.hasKeyStore());

    IllegalArgumentException e =
        assertThrows(
            IllegalArgumentException.class,
            () ->
                IdentityPoolCredentials.newBuilder()
                    .setSubjectTokenSupplier(testProvider)
                    .setActorTokenSupplier(testActorSupplier)
                    .setActorTokenType("urn:ietf:params:oauth:token-type:jwt")
                    .setHttpTransportFactory(noArgFactory)
                    .setAudience("audience")
                    .setSubjectTokenType("subjectTokenType")
                    .setTokenUrl("https://sts.mtls.googleapis.com/v1/token")
                    .build());
    assertTrue(
        e.getMessage().contains("Actor tokens are only supported for mTLS token exchanges."));
  }

  @Test
  void builder_actorTokenWithEmptyMtlsFactory_throws() throws Exception {
    KeyStore emptyKeyStore = KeyStore.getInstance(KeyStore.getDefaultType());
    emptyKeyStore.load(null, null);
    MtlsHttpTransportFactory emptyFactory = new MtlsHttpTransportFactory(emptyKeyStore);
    assertFalse(emptyFactory.hasKeyStore());

    IllegalArgumentException e =
        assertThrows(
            IllegalArgumentException.class,
            () ->
                IdentityPoolCredentials.newBuilder()
                    .setSubjectTokenSupplier(testProvider)
                    .setActorTokenSupplier(testActorSupplier)
                    .setActorTokenType("urn:ietf:params:oauth:token-type:jwt")
                    .setHttpTransportFactory(emptyFactory)
                    .setAudience("audience")
                    .setSubjectTokenType("subjectTokenType")
                    .setTokenUrl("https://sts.mtls.googleapis.com/v1/token")
                    .build());
    assertTrue(
        e.getMessage().contains("Actor tokens are only supported for mTLS token exchanges."));
  }

  @Test
  void mtlsHttpTransportFactory_hasKeyStore_withPopulatedKeyStore_returnsTrue() throws Exception {
    KeyStore ks = createPopulatedKeyStore();
    MtlsHttpTransportFactory factory = new MtlsHttpTransportFactory(ks);
    assertTrue(factory.hasKeyStore());
  }

  @Test
  void mtlsHttpTransportFactory_hasKeyStore_withEmptyKeyStore_returnsFalse() throws Exception {
    KeyStore emptyKeyStore = KeyStore.getInstance(KeyStore.getDefaultType());
    emptyKeyStore.load(null, null);
    MtlsHttpTransportFactory factory = new MtlsHttpTransportFactory(emptyKeyStore);
    assertFalse(factory.hasKeyStore());
  }

  @Test
  void mtlsHttpTransportFactory_hasKeyStore_noArg_returnsFalse() {
    MtlsHttpTransportFactory factory = new MtlsHttpTransportFactory();
    assertFalse(factory.hasKeyStore());
  }

  // ==================================================================================
  // Section A: Cert Pinning & Transport Factory Tests
  // ==================================================================================

  @Test
  void refreshAccessToken_pinsTransportForStsExchange() throws Exception {
    // Verify that the STS exchange uses the pinned transport factory from the KeyStore snapshot
    // within one refresh cycle. Threading the pinned transport to IAM impersonation is deferred
    // to a follow-up PR.
    KeyStore ks = createPopulatedKeyStore();

    AtomicInteger getKeyStoreCallCount = new AtomicInteger(0);
    X509Provider x509Provider =
        new X509Provider() {
          @Override
          public KeyStore getKeyStore() {
            getKeyStoreCallCount.incrementAndGet();
            return ks;
          }
        };

    MockExternalAccountCredentialsTransportFactory transportFactory =
        new MockExternalAccountCredentialsTransportFactory();

    MtlsHttpTransportFactory mtlsTransport = new MtlsHttpTransportFactory(ks);

    // Use TransportCapturingCredentials so we can capture the factory passed to exchange.
    TransportCapturingCredentials credential =
        new TransportCapturingCredentials(
            IdentityPoolCredentials.newBuilder()
                .setSubjectTokenSupplier(testProvider)
                .setX509Provider(x509Provider)
                .setAudience(
                    "//iam.googleapis.com/projects/123/locations/global/workloadIdentityPools/pool/providers/provider")
                .setSubjectTokenType("urn:ietf:params:oauth:token-type:id_token")
                .setTokenUrl(transportFactory.transport.getStsUrl())
                .setHttpTransportFactory(mtlsTransport));

    AccessToken token = credential.refreshAccessToken();
    assertNotNull(token);

    // getKeyStore() should be called exactly once per refresh cycle for the snapshot.
    assertEquals(1, getKeyStoreCallCount.get());
    // The exchange should have been called once, and a single transport factory was used.
    assertEquals(1, credential.getCapturedFactories().size());
    assertTrue(
        credential.getCapturedFactories().get(0) instanceof MtlsHttpTransportFactory,
        "Exchange should use MtlsHttpTransportFactory from the cert snapshot");
  }

  @Test
  void refreshAccessToken_certRotationBetweenCycles_usesNewCert() throws Exception {
    // First refresh uses cert A, rotate the provider, second refresh uses cert B.
    KeyStore ksA = createPopulatedKeyStore();
    KeyStore ksB = createRotatedPopulatedKeyStore();

    AtomicInteger callCount = new AtomicInteger(0);
    X509Provider rotatingProvider =
        new X509Provider() {
          @Override
          public KeyStore getKeyStore() {
            return callCount.getAndIncrement() == 0 ? ksA : ksB;
          }
        };

    MockExternalAccountCredentialsTransportFactory transportFactory =
        new MockExternalAccountCredentialsTransportFactory();

    MtlsHttpTransportFactory mtlsTransport = new MtlsHttpTransportFactory(ksA);

    TransportCapturingCredentials credential =
        new TransportCapturingCredentials(
            IdentityPoolCredentials.newBuilder()
                .setSubjectTokenSupplier(testProvider)
                .setX509Provider(rotatingProvider)
                .setAudience(
                    "//iam.googleapis.com/projects/123/locations/global/workloadIdentityPools/pool/providers/provider")
                .setSubjectTokenType("urn:ietf:params:oauth:token-type:id_token")
                .setTokenUrl(transportFactory.transport.getStsUrl())
                .setHttpTransportFactory(mtlsTransport));

    // First refresh — uses ksA
    AccessToken token1 = credential.refreshAccessToken();
    assertNotNull(token1);
    assertEquals(1, callCount.get());

    // Second refresh — uses ksB (rotated)
    AccessToken token2 = credential.refreshAccessToken();
    assertNotNull(token2);
    assertEquals(2, callCount.get());

    // Each cycle should have created a distinct MtlsHttpTransportFactory
    assertEquals(2, credential.getCapturedFactories().size());
    assertNotSame(
        credential.getCapturedFactories().get(0),
        credential.getCapturedFactories().get(1),
        "Each cycle should use a distinct transport factory");
  }

  @Test
  void refreshAccessToken_401Retry_reReadsFromDisk() throws Exception {
    // On 401, the code should re-read from X509Provider to get fresh certs and retry.
    KeyStore ksA = createPopulatedKeyStore();
    KeyStore ksB = createRotatedPopulatedKeyStore();

    AtomicInteger callCount = new AtomicInteger(0);
    X509Provider rotatingProvider =
        new X509Provider() {
          @Override
          public KeyStore getKeyStore() {
            // First call: ksA (for initial snapshot)
            // Second call: ksB (for retry after 401)
            return callCount.getAndIncrement() == 0 ? ksA : ksB;
          }
        };

    MockExternalAccountCredentialsTransportFactory transportFactory =
        new MockExternalAccountCredentialsTransportFactory();

    MtlsHttpTransportFactory mtlsTransport = new MtlsHttpTransportFactory(ksA);

    // Testable credential: throws 401 on first exchange, succeeds on retry.
    TestableIdentityPoolCredentials credential =
        new TestableIdentityPoolCredentials(
            IdentityPoolCredentials.newBuilder()
                .setSubjectTokenSupplier(testProvider)
                .setX509Provider(rotatingProvider)
                .setAudience(
                    "//iam.googleapis.com/projects/123/locations/global/workloadIdentityPools/pool/providers/provider")
                .setSubjectTokenType("urn:ietf:params:oauth:token-type:id_token")
                .setTokenUrl(transportFactory.transport.getStsUrl())
                .setHttpTransportFactory(mtlsTransport),
            /* failOnFirstExchange= */ true);

    AccessToken token = credential.refreshAccessToken();
    assertNotNull(token);
    // Verify the provider was called twice: once for initial snapshot, once for retry
    assertEquals(2, callCount.get());
    assertEquals(2, credential.getExchangeCallCount());
  }

  @Test
  void refreshAccessToken_401Retry_viaHttpTransport_retriesAndSucceeds() throws Exception {
    KeyStore ksA = createPopulatedKeyStore();
    KeyStore ksB = createRotatedPopulatedKeyStore();

    AtomicInteger callCount = new AtomicInteger(0);
    X509Provider rotatingProvider =
        new X509Provider() {
          @Override
          public KeyStore getKeyStore() {
            return callCount.getAndIncrement() == 0 ? ksA : ksB;
          }
        };

    MockExternalAccountCredentialsTransport transportA =
        new MockExternalAccountCredentialsTransport();
    transportA.addStsStatusCodeSequence(401);

    MockExternalAccountCredentialsTransport transportB =
        new MockExternalAccountCredentialsTransport();
    transportB.addStsStatusCodeSequence(200);

    List<KeyStore> usedKeyStores = new ArrayList<>();
    IdentityPoolCredentials credential =
        new IdentityPoolCredentials(
            IdentityPoolCredentials.newBuilder()
                .setSubjectTokenSupplier(testProvider)
                .setX509Provider(rotatingProvider)
                .setAudience(
                    "//iam.googleapis.com/projects/123/locations/global/workloadIdentityPools/pool/providers/provider")
                .setSubjectTokenType("urn:ietf:params:oauth:token-type:id_token")
                .setTokenUrl(transportA.getStsUrl())) {
          @Override
          HttpTransportFactory createMtlsTransportFactory(KeyStore keyStore) {
            usedKeyStores.add(keyStore);
            return () -> keyStore == ksA ? transportA : transportB;
          }
        };

    AccessToken token = credential.refreshAccessToken();
    assertNotNull(token);
    assertEquals("accessToken", token.getTokenValue());

    // Verify 2 calls to X509Provider: 1st for initial snapshot, 2nd on 401 reload
    assertEquals(2, callCount.get());

    // Verify 1st STS request executed over transportA (ksA) and 2nd over transportB (ksB)
    assertEquals(1, transportA.getRequests().size());
    assertEquals(1, transportB.getRequests().size());

    // Verify initial cycle used ksA, and retry used ksB
    assertEquals(Arrays.asList(ksA, ksB), usedKeyStores);
  }

  @Test
  void refreshAccessToken_401Retry_nonMtls_bubblesUp() throws Exception {
    // When x509Provider is null (non-mTLS), a 401 should bubble up, not retry.
    MockExternalAccountCredentialsTransportFactory transportFactory =
        new MockExternalAccountCredentialsTransportFactory();

    TestableIdentityPoolCredentials credential =
        new TestableIdentityPoolCredentials(
            IdentityPoolCredentials.newBuilder()
                .setSubjectTokenSupplier(testProvider)
                .setAudience(
                    "//iam.googleapis.com/projects/123/locations/global/workloadIdentityPools/pool/providers/provider")
                .setSubjectTokenType("urn:ietf:params:oauth:token-type:id_token")
                .setTokenUrl(transportFactory.transport.getStsUrl())
                .setHttpTransportFactory(transportFactory),
            /* failOnFirstExchange= */ true);

    // Should throw the 401 error without retry since there's no x509Provider.
    OAuthException e = assertThrows(OAuthException.class, credential::refreshAccessToken);
    assertEquals(401, e.getHttpStatusCode());
    assertEquals(1, credential.getExchangeCallCount());
  }

  @Test
  void refreshAccessToken_401Retry_secondAttemptFails_throws() throws Exception {
    // 401 → retry with rotated cert → retry also fails → exception propagates.
    KeyStore ksA = createPopulatedKeyStore();
    KeyStore ksB = createRotatedPopulatedKeyStore();
    AtomicInteger callCount = new AtomicInteger(0);

    X509Provider provider =
        new X509Provider() {
          @Override
          public KeyStore getKeyStore() {
            return callCount.getAndIncrement() == 0 ? ksA : ksB;
          }
        };

    MockExternalAccountCredentialsTransportFactory transportFactory =
        new MockExternalAccountCredentialsTransportFactory();

    MtlsHttpTransportFactory mtlsTransport = new MtlsHttpTransportFactory(ksA);

    // Testable credential that always throws 401 (both first and retry).
    TestableIdentityPoolCredentials credential =
        new TestableIdentityPoolCredentials(
            IdentityPoolCredentials.newBuilder()
                .setSubjectTokenSupplier(testProvider)
                .setX509Provider(provider)
                .setAudience(
                    "//iam.googleapis.com/projects/123/locations/global/workloadIdentityPools/pool/providers/provider")
                .setSubjectTokenType("urn:ietf:params:oauth:token-type:id_token")
                .setTokenUrl(transportFactory.transport.getStsUrl())
                .setHttpTransportFactory(mtlsTransport),
            /* failOnFirstExchange= */ true,
            /* failOnAllExchanges= */ true);

    OAuthException e = assertThrows(OAuthException.class, credential::refreshAccessToken);
    assertEquals(401, e.getHttpStatusCode());
    // First attempt + one retry = 2
    assertEquals(2, credential.getExchangeCallCount());
  }

  @Test
  void refreshAccessToken_401Retry_unchangedCert_doesNotRetry() throws Exception {
    // When X509Provider returns a KeyStore containing the exact same certificate on 401,
    // refreshWithRetry should NOT retry.
    KeyStore ks1 = createPopulatedKeyStore();
    KeyStore ks2SameCert = createPopulatedKeyStore();
    AtomicInteger callCount = new AtomicInteger(0);

    X509Provider provider =
        new X509Provider() {
          @Override
          public KeyStore getKeyStore() {
            return callCount.getAndIncrement() == 0 ? ks1 : ks2SameCert;
          }
        };

    MockExternalAccountCredentialsTransportFactory transportFactory =
        new MockExternalAccountCredentialsTransportFactory();
    MtlsHttpTransportFactory mtlsTransport = new MtlsHttpTransportFactory(ks1);

    TestableIdentityPoolCredentials credential =
        new TestableIdentityPoolCredentials(
            IdentityPoolCredentials.newBuilder()
                .setSubjectTokenSupplier(testProvider)
                .setX509Provider(provider)
                .setAudience(
                    "//iam.googleapis.com/projects/123/locations/global/workloadIdentityPools/pool/providers/provider")
                .setSubjectTokenType("urn:ietf:params:oauth:token-type:id_token")
                .setTokenUrl(transportFactory.transport.getStsUrl())
                .setHttpTransportFactory(mtlsTransport),
            /* failOnFirstExchange= */ true);

    OAuthException e = assertThrows(OAuthException.class, credential::refreshAccessToken);
    assertEquals(401, e.getHttpStatusCode());
    assertEquals(2, callCount.get());
    // Because the certificate in ks2SameCert did not change, no retry exchange was performed!
    assertEquals(1, credential.getExchangeCallCount());
  }

  @Test
  void refreshAccessToken_401Retry_certLoadFailure_preservesOriginalError() throws Exception {
    // When a 401 triggers retry but X509Provider.getKeyStore() throws on the retry,
    // the IOException from cert loading should be thrown with the original OAuthException
    // as a suppressed exception.
    KeyStore ks = createPopulatedKeyStore();

    AtomicInteger providerCallCount = new AtomicInteger(0);
    X509Provider failingOnRetryProvider =
        new X509Provider() {
          @Override
          public KeyStore getKeyStore() throws IOException {
            int call = providerCallCount.getAndIncrement();
            if (call == 0) {
              // First call: return valid KeyStore for initial snapshot
              return ks;
            }
            // Second call: fail during retry (simulates cert file rotation/corruption)
            throw new IOException("Certificate file not found during retry");
          }
        };

    MockExternalAccountCredentialsTransportFactory transportFactory =
        new MockExternalAccountCredentialsTransportFactory();

    MtlsHttpTransportFactory mtlsTransport = new MtlsHttpTransportFactory(ks);

    // Testable credential: throws 401 on first exchange to trigger retry path.
    TestableIdentityPoolCredentials credential =
        new TestableIdentityPoolCredentials(
            IdentityPoolCredentials.newBuilder()
                .setSubjectTokenSupplier(testProvider)
                .setX509Provider(failingOnRetryProvider)
                .setAudience(
                    "//iam.googleapis.com/projects/123/locations/global/workloadIdentityPools/pool/providers/provider")
                .setSubjectTokenType("urn:ietf:params:oauth:token-type:id_token")
                .setTokenUrl(transportFactory.transport.getStsUrl())
                .setHttpTransportFactory(mtlsTransport),
            /* failOnFirstExchange= */ true);

    IOException thrown = assertThrows(IOException.class, credential::refreshAccessToken);
    assertEquals("Certificate file not found during retry", thrown.getMessage());

    // Verify the original OAuthException is preserved as a suppressed exception
    Throwable[] suppressed = thrown.getSuppressed();
    assertTrue(suppressed.length > 0, "Should have suppressed exceptions");
    assertTrue(suppressed[0] instanceof OAuthException);
    assertEquals(401, ((OAuthException) suppressed[0]).getHttpStatusCode());
  }

  @Test
  void refreshAccessToken_subjectAndActorFromSameFileParse() throws Exception {
    // Verify when both subject and actor tokens come from the same file supplier,
    // readTokens() is called (single file read) rather than separate getSubjectToken()
    // + getActorToken() calls.
    File file = File.createTempFile("ATOMIC_READ_TOKEN", /* suffix= */ null, /* directory= */ null);
    file.deleteOnExit();

    GenericJson tokenJson = new GenericJson();
    tokenJson.setFactory(JSON_FACTORY);
    tokenJson.put("subject_token", "mySubjectToken");
    tokenJson.put("actor_token", "myActorToken");
    OAuth2Utils.writeInputStreamToFile(
        new ByteArrayInputStream(tokenJson.toPrettyString().getBytes(StandardCharsets.UTF_8)),
        file.getAbsolutePath());

    Map<String, String> formatMap = new HashMap<>();
    formatMap.put("type", "json");
    formatMap.put("subject_token_field_name", "subject_token");
    formatMap.put("actor_token_field_name", "actor_token");
    IdentityPoolCredentialSource credentialSource =
        createFileCredentialSource(file.getAbsolutePath(), formatMap);

    MockExternalAccountCredentialsTransportFactory mockTransportFactory =
        new MockExternalAccountCredentialsTransportFactory();

    KeyStore ks = createPopulatedKeyStore();
    MtlsHttpTransportFactory mtlsTransport = new MtlsHttpTransportFactory(ks);

    IdentityPoolCredentials credential =
        new IdentityPoolCredentials(
            IdentityPoolCredentials.newBuilder()
                .setCredentialSource(credentialSource)
                .setActorTokenType("urn:ietf:params:oauth:token-type:jwt")
                .setAudience(
                    "//iam.googleapis.com/projects/123/locations/global/workloadIdentityPools/pool/providers/provider")
                .setSubjectTokenType("urn:ietf:params:oauth:token-type:id_token")
                .setTokenUrl(mockTransportFactory.transport.getStsMtlsUrl())
                .setHttpTransportFactory(mtlsTransport)) {
          @Override
          protected AccessToken exchangeExternalCredentialForAccessToken(
              StsTokenExchangeRequest stsTokenExchangeRequest,
              HttpTransportFactory cycleTransportFactory)
              throws IOException {
            return super.exchangeExternalCredentialForAccessToken(
                stsTokenExchangeRequest, mockTransportFactory);
          }
        };

    // The subject and actor suppliers should be the same instance (both FileIdentityPool...)
    assertSame(
        credential.getIdentityPoolSubjectTokenSupplier(),
        credential.getIdentityPoolActorTokenSupplier(),
        "Subject and actor suppliers should be the same instance for file-based sources");

    // Refresh should succeed, reading both tokens from the single file
    AccessToken token = credential.refreshAccessToken();
    assertNotNull(token);

    // Verify the STS request included the actor token from the file
    Map<String, String> query =
        TestUtils.parseQuery(mockTransportFactory.transport.getLastRequest().getContentAsString());
    assertEquals("myActorToken", query.get("actor_token"));
    assertEquals("urn:ietf:params:oauth:token-type:jwt", query.get("actor_token_type"));
  }

  // ==================================================================================
  // Section B: Concurrency Tests
  // ==================================================================================

  @Test
  void refreshAccessToken_concurrent_eachGetOwnSnapshot() throws Exception {
    // Two threads refresh simultaneously. Each should get their own KeyStore snapshot.
    AtomicInteger getKeyStoreCount = new AtomicInteger(0);
    KeyStore ks1 = createPopulatedKeyStore();
    KeyStore ks2 = createRotatedPopulatedKeyStore();

    X509Provider countingProvider =
        new X509Provider() {
          @Override
          public KeyStore getKeyStore() {
            int count = getKeyStoreCount.incrementAndGet();
            return count <= 1 ? ks1 : ks2;
          }
        };

    MockExternalAccountCredentialsTransportFactory transportFactory =
        new MockExternalAccountCredentialsTransportFactory();

    MtlsHttpTransportFactory mtlsTransport = new MtlsHttpTransportFactory(ks1);

    TransportCapturingCredentials credential =
        new TransportCapturingCredentials(
            IdentityPoolCredentials.newBuilder()
                .setSubjectTokenSupplier(testProvider)
                .setX509Provider(countingProvider)
                .setAudience(
                    "//iam.googleapis.com/projects/123/locations/global/workloadIdentityPools/pool/providers/provider")
                .setSubjectTokenType("urn:ietf:params:oauth:token-type:id_token")
                .setTokenUrl(transportFactory.transport.getStsUrl())
                .setHttpTransportFactory(mtlsTransport));

    CyclicBarrier barrier = new CyclicBarrier(2);
    ExecutorService executor = Executors.newFixedThreadPool(2);
    try {
      Future<AccessToken> future1 =
          executor.submit(
              () -> {
                barrier.await(5, TimeUnit.SECONDS);
                return credential.refreshAccessToken();
              });
      Future<AccessToken> future2 =
          executor.submit(
              () -> {
                barrier.await(5, TimeUnit.SECONDS);
                return credential.refreshAccessToken();
              });

      AccessToken token1 = future1.get(10, TimeUnit.SECONDS);
      AccessToken token2 = future2.get(10, TimeUnit.SECONDS);

      assertNotNull(token1);
      assertNotNull(token2);
      // Each thread should have called getKeyStore(), so we expect at least 2 calls.
      assertTrue(
          getKeyStoreCount.get() >= 2,
          "Expected at least 2 getKeyStore calls, got " + getKeyStoreCount.get());
      // Each thread should get its own factory instance
      assertEquals(2, credential.getCapturedFactories().size());
    } finally {
      executor.shutdownNow();
    }
  }

  @Test
  void refreshAccessToken_concurrent_401OnOneThread_doesNotAffectOther() throws Exception {
    // Thread A refreshes normally (succeeds on first exchange).
    // Thread B gets a 401, causing a retry with a fresh cert from X509Provider.
    // Verify that Thread B's retry (re-read from X509Provider) does not affect Thread A's
    // transport — each thread has its own local cycleTransportFactory.
    KeyStore ksInitial = createPopulatedKeyStore();
    KeyStore ksRetry = createRotatedPopulatedKeyStore();

    AtomicInteger getKeyStoreCount = new AtomicInteger(0);
    CyclicBarrier barrier = new CyclicBarrier(2);
    X509Provider provider =
        new X509Provider() {
          @Override
          public KeyStore getKeyStore() throws IOException {
            int count = getKeyStoreCount.incrementAndGet();
            if (count <= 2) {
              try {
                barrier.await(5, TimeUnit.SECONDS);
              } catch (Exception e) {
                throw new IOException(e);
              }
              return ksInitial;
            }
            // Third call is for Thread B's retry after 401.
            return ksRetry;
          }
        };

    MockExternalAccountCredentialsTransportFactory transportFactory =
        new MockExternalAccountCredentialsTransportFactory();

    MtlsHttpTransportFactory mtlsTransport = new MtlsHttpTransportFactory(ksInitial);

    // Use a credential where one thread gets a 401 (first exchange fails) and the other
    // succeeds. The AtomicInteger tracks per-thread exchange behavior.
    AtomicInteger exchangeCallCount = new AtomicInteger(0);

    // Subclass that alternates: first exchange call throws 401, all others succeed.
    IdentityPoolCredentials credential =
        new IdentityPoolCredentials(
            IdentityPoolCredentials.newBuilder()
                .setSubjectTokenSupplier(testProvider)
                .setX509Provider(provider)
                .setAudience(
                    "//iam.googleapis.com/projects/123/locations/global/workloadIdentityPools/pool/providers/provider")
                .setSubjectTokenType("urn:ietf:params:oauth:token-type:id_token")
                .setTokenUrl(transportFactory.transport.getStsUrl())
                .setHttpTransportFactory(mtlsTransport)) {
          @Override
          protected AccessToken exchangeExternalCredentialForAccessToken(
              StsTokenExchangeRequest stsTokenExchangeRequest,
              HttpTransportFactory cycleTransportFactory)
              throws IOException {
            int count = exchangeCallCount.incrementAndGet();
            if (count == 1) {
              // First exchange call (Thread B): throw 401 to trigger retry
              throw new OAuthException("invalid_client", "Unauthorized", null, 401);
            }
            // All other calls succeed
            return new AccessToken("token_" + count, null);
          }
        };

    ExecutorService executor = Executors.newFixedThreadPool(2);
    try {
      Future<AccessToken> futureA = executor.submit(() -> credential.refreshAccessToken());
      Future<AccessToken> futureB = executor.submit(() -> credential.refreshAccessToken());

      AccessToken tokenA = futureA.get(10, TimeUnit.SECONDS);
      AccessToken tokenB = futureB.get(10, TimeUnit.SECONDS);

      assertNotNull(tokenA);
      assertNotNull(tokenB);

      // Both threads did initial snapshots (2 calls), plus Thread B's retry (1 more)
      assertEquals(3, getKeyStoreCount.get());
      // 3 exchange calls total: one 401 + one retry success + one normal success
      assertEquals(3, exchangeCallCount.get());
      assertSame(mtlsTransport, credential.getTransportFactory());
    } finally {
      executor.shutdownNow();
    }
  }

  @Test
  void refreshAccessToken_certRotationDuringRefresh_pinnedCertUsed() throws Exception {
    // Cert rotates mid-refresh (during the exchange call).
    // Verify the transport factory used in exchange is the one pinned at snapshot time,
    // not the rotated cert.
    KeyStore ksOriginal = createPopulatedKeyStore();
    KeyStore ksRotated = createRotatedPopulatedKeyStore();

    AtomicReference<KeyStore> currentKeyStore = new AtomicReference<>(ksOriginal);
    AtomicInteger snapshotCount = new AtomicInteger(0);

    X509Provider provider =
        new X509Provider() {
          @Override
          public KeyStore getKeyStore() {
            snapshotCount.incrementAndGet();
            return currentKeyStore.get();
          }
        };

    MockExternalAccountCredentialsTransportFactory transportFactory =
        new MockExternalAccountCredentialsTransportFactory();

    MtlsHttpTransportFactory mtlsTransport = new MtlsHttpTransportFactory(ksOriginal);

    // A credential that rotates the cert DURING the exchange call, then captures
    // the transport factory to verify it's still the original pinned one.
    AtomicReference<HttpTransportFactory> capturedFactory = new AtomicReference<>();
    AtomicInteger exchangeCallCount = new AtomicInteger(0);
    IdentityPoolCredentials credential =
        new IdentityPoolCredentials(
            IdentityPoolCredentials.newBuilder()
                .setSubjectTokenSupplier(testProvider)
                .setX509Provider(provider)
                .setAudience(
                    "//iam.googleapis.com/projects/123/locations/global/workloadIdentityPools/pool/providers/provider")
                .setSubjectTokenType("urn:ietf:params:oauth:token-type:id_token")
                .setTokenUrl(transportFactory.transport.getStsUrl())
                .setHttpTransportFactory(mtlsTransport)) {
          @Override
          protected AccessToken exchangeExternalCredentialForAccessToken(
              StsTokenExchangeRequest stsTokenExchangeRequest,
              HttpTransportFactory cycleTransportFactory)
              throws IOException {
            int call = exchangeCallCount.incrementAndGet();
            if (call == 1) {
              // Rotate the cert on the provider DURING the exchange.
              // This simulates a cert rotation happening while STS/IAM is in-flight.
              currentKeyStore.set(ksRotated);
            }
            capturedFactory.set(cycleTransportFactory);
            return new AccessToken("token-" + call, null);
          }
        };

    // Call refresh — this will snapshot ksOriginal, then during exchange, rotate to ksRotated.
    AccessToken token = credential.refreshAccessToken();
    assertNotNull(token);
    assertEquals("token-1", token.getTokenValue());
    // Snapshot was taken exactly once (at the start of the cycle)
    assertEquals(1, snapshotCount.get());

    // The transport factory used in exchange should be an MtlsHttpTransportFactory
    // built from the ORIGINAL snapshot, not the rotated cert.
    HttpTransportFactory firstCycleFactory = capturedFactory.get();
    assertNotNull(firstCycleFactory);
    assertTrue(
        firstCycleFactory instanceof MtlsHttpTransportFactory,
        "Exchange should use MtlsHttpTransportFactory pinned to original cert");

    // Verify that a SECOND refresh on the SAME instance picks up the rotated cert (ksRotated).
    AccessToken token2 = credential.refreshAccessToken();
    assertNotNull(token2);
    assertEquals("token-2", token2.getTokenValue());
    // Second refresh should have taken a new snapshot
    assertEquals(2, snapshotCount.get());

    HttpTransportFactory secondCycleFactory = capturedFactory.get();
    assertNotNull(secondCycleFactory);
    assertTrue(
        secondCycleFactory instanceof MtlsHttpTransportFactory,
        "Second exchange should use MtlsHttpTransportFactory pinned to rotated cert");

    // The two factories should be different instances (different cert snapshots)
    assertNotSame(
        firstCycleFactory,
        secondCycleFactory,
        "Each refresh cycle should create a distinct transport factory from its cert snapshot");
    // A new factory is created every cycle, so also check each one holds the expected KeyStore.
    assertSame(ksOriginal, ((MtlsHttpTransportFactory) firstCycleFactory).getKeyStore());
    assertSame(ksRotated, ((MtlsHttpTransportFactory) secondCycleFactory).getKeyStore());
  }

  // ==================================================================================
  // Section D: Serialization Tests
  // ==================================================================================

  @Test
  void serialize_deserialize_withActorTokenConfig_roundTrips() throws Exception {
    KeyStore ks = createPopulatedKeyStore();
    MtlsHttpTransportFactory mtlsTransport = new MtlsHttpTransportFactory(ks);

    IdentityPoolCredentials credentials =
        IdentityPoolCredentials.newBuilder()
            .setHttpTransportFactory(mtlsTransport)
            .setSubjectTokenSupplier(testProvider)
            .setActorTokenSupplier(testActorSupplier)
            .setActorTokenType("urn:ietf:params:oauth:token-type:jwt")
            .setAudience("audience")
            .setSubjectTokenType("subjectTokenType")
            .setTokenUrl("https://sts.mtls.googleapis.com/v1/token")
            .setQuotaProjectId("quotaProjectId")
            .setClientId("clientId")
            .setClientSecret("clientSecret")
            .build();

    IdentityPoolCredentials deserialized = serializeAndDeserialize(credentials);
    assertEquals(credentials.getAudience(), deserialized.getAudience());
    assertEquals(credentials.getSubjectTokenType(), deserialized.getSubjectTokenType());
    assertEquals(credentials.getTokenUrl(), deserialized.getTokenUrl());
    assertEquals(credentials.getQuotaProjectId(), deserialized.getQuotaProjectId());
    assertEquals(credentials.getClientId(), deserialized.getClientId());
    assertEquals(credentials.getClientSecret(), deserialized.getClientSecret());
    assertEquals(credentials.getActorTokenType(), deserialized.getActorTokenType());
  }

  @Test
  void serialize_deserialize_withCustomTransportFactory_preservesCustomTransport()
      throws Exception {
    Map<String, Object> certificateMap = new HashMap<>();
    certificateMap.put("use_default_certificate_config", false);
    certificateMap.put("certificate_config_location", "testresources/mtls/certificate_config.json");
    Map<String, Object> credentialSourceMap = new HashMap<>();
    credentialSourceMap.put("file", "testresources/mtls/certificate_config.json");
    credentialSourceMap.put("certificate", certificateMap);
    IdentityPoolCredentialSource credentialSource =
        new IdentityPoolCredentialSource(credentialSourceMap);

    IdentityPoolCredentials credentials =
        IdentityPoolCredentials.newBuilder()
            .setHttpTransportFactory(new MockHttpTransportFactory())
            .setCredentialSource(credentialSource)
            .setAudience("audience")
            .setSubjectTokenType("subjectTokenType")
            .setTokenUrl("https://sts.mtls.googleapis.com/v1/token")
            .build();

    IdentityPoolCredentials deserialized = serializeAndDeserialize(credentials);
    assertTrue(
        deserialized.getTransportFactory() instanceof MockHttpTransportFactory,
        "Custom transport factory should be preserved across serialization");
  }

  private static final String PRE_PR_SERIALIZED_BYTES_BASE64 =
      "rO0ABXNyAC5jb20uZ29vZ2xlLmF1dGgub2F1dGgyLklkZW50aXR5UG9vbENyZWRlbnRpYWxzIkrrZ4jpHOkCAANMABJtZXRy"
          + "aWNzSGVhZGVyVmFsdWV0ABJMamF2YS9sYW5nL1N0cmluZztMABRzdWJqZWN0VG9rZW5TdXBwbGllcnQAOUxjb20vZ29vZ2xl"
          + "L2F1dGgvb2F1dGgyL0lkZW50aXR5UG9vbFN1YmplY3RUb2tlblN1cHBsaWVyO0wAD3N1cHBsaWVyQ29udGV4dHQAN0xjb20v"
          + "Z29vZ2xlL2F1dGgvb2F1dGgyL0V4dGVybmFsQWNjb3VudFN1cHBsaWVyQ29udGV4dDt4cgAxY29tLmdvb2dsZS5hdXRoLm9h"
          + "dXRoMi5FeHRlcm5hbEFjY291bnRDcmVkZW50aWFsc2+0PaCkD5P/AgAQTAAIYXVkaWVuY2VxAH4AAUwACGNsaWVudElkcQB+"
          + "AAFMAAxjbGllbnRTZWNyZXRxAH4AAUwAEGNyZWRlbnRpYWxTb3VyY2V0AERMY29tL2dvb2dsZS9hdXRoL29hdXRoMi9FeHRl"
          + "cm5hbEFjY291bnRDcmVkZW50aWFscyRDcmVkZW50aWFsU291cmNlO0wAE2Vudmlyb25tZW50UHJvdmlkZXJ0ACxMY29tL2dv"
          + "b2dsZS9hdXRoL29hdXRoMi9FbnZpcm9ubWVudFByb3ZpZGVyO0wAF2ltcGVyc29uYXRlZENyZWRlbnRpYWxzdAAwTGNvbS9n"
          + "b29nbGUvYXV0aC9vYXV0aDIvSW1wZXJzb25hdGVkQ3JlZGVudGlhbHM7TAAObWV0cmljc0hhbmRsZXJ0ADZMY29tL2dvb2ds"
          + "ZS9hdXRoL29hdXRoMi9FeHRlcm5hbEFjY291bnRNZXRyaWNzSGFuZGxlcjtMABBwcm9wZXJ0eVByb3ZpZGVydAApTGNvbS9n"
          + "b29nbGUvYXV0aC9vYXV0aDIvUHJvcGVydHlQcm92aWRlcjtMAAZzY29wZXN0ABZMamF2YS91dGlsL0NvbGxlY3Rpb247TAAi"
          + "c2VydmljZUFjY291bnRJbXBlcnNvbmF0aW9uT3B0aW9uc3QAVkxjb20vZ29vZ2xlL2F1dGgvb2F1dGgyL0V4dGVybmFsQWNj"
          + "b3VudENyZWRlbnRpYWxzJFNlcnZpY2VBY2NvdW50SW1wZXJzb25hdGlvbk9wdGlvbnM7TAAec2VydmljZUFjY291bnRJbXBl"
          + "cnNvbmF0aW9uVXJscQB+AAFMABBzdWJqZWN0VG9rZW5UeXBlcQB+AAFMAAx0b2tlbkluZm9VcmxxAH4AAUwACHRva2VuVXJs"
          + "cQB+AAFMABl0cmFuc3BvcnRGYWN0b3J5Q2xhc3NOYW1lcQB+AAFMABh3b3JrZm9yY2VQb29sVXNlclByb2plY3RxAH4AAXhy"
          + "AChjb20uZ29vZ2xlLmF1dGgub2F1dGgyLkdvb2dsZUNyZWRlbnRpYWxz6t29xaLhXyUCAAVaABhpc0V4cGxpY2l0VW5pdmVy"
          + "c2VEb21haW5MAARuYW1lcQB+AAFMAA5xdW90YVByb2plY3RJZHEAfgABTAAGc291cmNlcQB+AAFMAA51bml2ZXJzZURvbWFp"
          + "bnEAfgABeHIAKGNvbS5nb29nbGUuYXV0aC5vYXV0aDIuT0F1dGgyQ3JlZGVudGlhbHM/PX166aVRVwIABEwAEGV4cGlyYXRp"
          + "b25NYXJnaW50ABRMamF2YS90aW1lL0R1cmF0aW9uO0wABGxvY2t0ABJMamF2YS9sYW5nL09iamVjdDtMAA1yZWZyZXNoTWFy"
          + "Z2lucQB+AA5MAAV2YWx1ZXQANUxjb20vZ29vZ2xlL2F1dGgvb2F1dGgyL09BdXRoMkNyZWRlbnRpYWxzJE9BdXRoVmFsdWU7"
          + "eHIAG2NvbS5nb29nbGUuYXV0aC5DcmVkZW50aWFscws4oteMPZCBAgAAeHBzcgANamF2YS50aW1lLlNlcpVdhLobIkiyDAAA"
          + "eHB3DQEAAAAAAAAAtAAAAAB4dXIAAltCrPMX+AYIVOACAAB4cAAAAABzcQB+ABN3DQEAAAAAAAAA4QAAAAB4cAB0ABxFeHRl"
          + "cm5hbCBBY2NvdW50IENyZWRlbnRpYWxzdAAOcXVvdGFQcm9qZWN0SWRwdAAOZ29vZ2xlYXBpcy5jb210AGAvL2lhbS5nb29n"
          + "bGVhcGlzLmNvbS9wcm9qZWN0cy8xMjMvbG9jYXRpb25zL2dsb2JhbC93b3JrbG9hZElkZW50aXR5UG9vbHMvcG9vbC9wcm92"
          + "aWRlcnMvcHJvdmlkZXJ0AAhjbGllbnRJZHQADGNsaWVudFNlY3JldHNyADNjb20uZ29vZ2xlLmF1dGgub2F1dGgyLklkZW50"
          + "aXR5UG9vbENyZWRlbnRpYWxTb3VyY2X1pjCawbfqwgIAB0wAE2FjdG9yVG9rZW5GaWVsZE5hbWVxAH4AAUwAEWNlcnRpZmlj"
          + "YXRlQ29uZmlndABHTGNvbS9nb29nbGUvYXV0aC9vYXV0aDIvSWRlbnRpdHlQb29sQ3JlZGVudGlhbFNvdXJjZSRDZXJ0aWZp"
          + "Y2F0ZUNvbmZpZztMABRjcmVkZW50aWFsRm9ybWF0VHlwZXQASkxjb20vZ29vZ2xlL2F1dGgvb2F1dGgyL0lkZW50aXR5UG9v"
          + "bENyZWRlbnRpYWxTb3VyY2UkQ3JlZGVudGlhbEZvcm1hdFR5cGU7TAASY3JlZGVudGlhbExvY2F0aW9ucQB+AAFMABRjcmVk"
          + "ZW50aWFsU291cmNlVHlwZXQAVkxjb20vZ29vZ2xlL2F1dGgvb2F1dGgyL0lkZW50aXR5UG9vbENyZWRlbnRpYWxTb3VyY2Uk"
          + "SWRlbnRpdHlQb29sQ3JlZGVudGlhbFNvdXJjZVR5cGU7TAAHaGVhZGVyc3QAD0xqYXZhL3V0aWwvTWFwO0wAFXN1YmplY3RU"
          + "b2tlbkZpZWxkTmFtZXEAfgABeHIAQmNvbS5nb29nbGUuYXV0aC5vYXV0aDIuRXh0ZXJuYWxBY2NvdW50Q3JlZGVudGlhbHMk"
          + "Q3JlZGVudGlhbFNvdXJjZXHczM85z4jIAgAAeHBwcH5yAEhjb20uZ29vZ2xlLmF1dGgub2F1dGgyLklkZW50aXR5UG9vbENy"
          + "ZWRlbnRpYWxTb3VyY2UkQ3JlZGVudGlhbEZvcm1hdFR5cGUAAAAAAAAAABIAAHhyAA5qYXZhLmxhbmcuRW51bQAAAAAAAAAA"
          + "EgAAeHB0AARURVhUdAAEZmlsZX5yAFRjb20uZ29vZ2xlLmF1dGgub2F1dGgyLklkZW50aXR5UG9vbENyZWRlbnRpYWxTb3Vy"
          + "Y2UkSWRlbnRpdHlQb29sQ3JlZGVudGlhbFNvdXJjZVR5cGUAAAAAAAAAABIAAHhxAH4AJnQABEZJTEVwcHNyADBjb20uZ29v"
          + "Z2xlLmF1dGgub2F1dGgyLlN5c3RlbUVudmlyb25tZW50UHJvdmlkZXK+zMPWWDs8NAIAAHhwcHNyADRjb20uZ29vZ2xlLmF1"
          + "dGgub2F1dGgyLkV4dGVybmFsQWNjb3VudE1ldHJpY3NIYW5kbGVyC4Qcubsxch4CAANaAA5jb25maWdMaWZldGltZVoAD3Nh"
          + "SW1wZXJzb25hdGlvbkwAC2NyZWRlbnRpYWxzdAAzTGNvbS9nb29nbGUvYXV0aC9vYXV0aDIvRXh0ZXJuYWxBY2NvdW50Q3Jl"
          + "ZGVudGlhbHM7eHAAAXEAfgASc3IALWNvbS5nb29nbGUuYXV0aC5vYXV0aDIuU3lzdGVtUHJvcGVydHlQcm92aWRlcgAAAAAA"
          + "AAABAgAAeHBzcgAjamF2YS51dGlsLkNvbGxlY3Rpb25zJFNpbmdsZXRvbkxpc3Qq7ykQPKeblwIAAUwAB2VsZW1lbnRxAH4A"
          + "D3hwdAAuaHR0cHM6Ly93d3cuZ29vZ2xlYXBpcy5jb20vYXV0aC9jbG91ZC1wbGF0Zm9ybXNyAFRjb20uZ29vZ2xlLmF1dGgu"
          + "b2F1dGgyLkV4dGVybmFsQWNjb3VudENyZWRlbnRpYWxzJFNlcnZpY2VBY2NvdW50SW1wZXJzb25hdGlvbk9wdGlvbnM6/caK"
          + "mTx8+QIAAloAHGN1c3RvbVRva2VuTGlmZXRpbWVSZXF1ZXN0ZWRJAAhsaWZldGltZXhwAAAADhB0AHpodHRwczovL2lhbWNy"
          + "ZWRlbnRpYWxzLmdvb2dsZWFwaXMuY29tL3YxL3Byb2plY3RzLy0vc2VydmljZUFjY291bnRzL3Rlc3RuQHRlc3QuaWFtLmdz"
          + "ZXJ2aWNlYWNjb3VudC5jb206Z2VuZXJhdGVBY2Nlc3NUb2tlbnQAEHN1YmplY3RUb2tlblR5cGV0AAx0b2tlbkluZm9Vcmx0"
          + "ACNodHRwczovL3N0cy5nb29nbGVhcGlzLmNvbS92MS90b2tlbnQAPmNvbS5nb29nbGUuYXV0aC5vYXV0aDIuT0F1dGgyVXRp"
          + "bHMkRGVmYXVsdEh0dHBUcmFuc3BvcnRGYWN0b3J5cHEAfgApc3IAO2NvbS5nb29nbGUuYXV0aC5vYXV0aDIuRmlsZUlkZW50"
          + "aXR5UG9vbFN1YmplY3RUb2tlblN1cHBsaWVyY0G/6P4+lLYCAAFMABBjcmVkZW50aWFsU291cmNldAA1TGNvbS9nb29nbGUv"
          + "YXV0aC9vYXV0aDIvSWRlbnRpdHlQb29sQ3JlZGVudGlhbFNvdXJjZTt4cHEAfgAkc3IANWNvbS5nb29nbGUuYXV0aC5vYXV0"
          + "aDIuRXh0ZXJuYWxBY2NvdW50U3VwcGxpZXJDb250ZXh0kwegl1C5weoCAAJMAAhhdWRpZW5jZXEAfgABTAAQc3ViamVjdFRv"
          + "a2VuVHlwZXEAfgABeHBxAH4AG3EAfgA6";

  @Test
  void serialize_deserialize_backwardCompatible() throws Exception {
    byte[] fixtureBytes = Base64.getDecoder().decode(PRE_PR_SERIALIZED_BYTES_BASE64);
    IdentityPoolCredentials deserialized;
    try (ObjectInputStream input =
        new ObjectInputStream(new ByteArrayInputStream(fixtureBytes)) {
          @Override
          protected ObjectStreamClass readClassDescriptor()
              throws IOException, ClassNotFoundException {
            ObjectStreamClass desc = super.readClassDescriptor();
            if ("com.google.auth.oauth2.ExternalAccountMetricsHandler".equals(desc.getName())) {
              return ObjectStreamClass.lookup(ExternalAccountMetricsHandler.class);
            }
            return desc;
          }
        }) {
      deserialized = (IdentityPoolCredentials) input.readObject();
    }

    assertNotNull(deserialized);
    assertEquals(
        "//iam.googleapis.com/projects/123/locations/global/workloadIdentityPools/pool/providers/provider",
        deserialized.getAudience());
    assertEquals("subjectTokenType", deserialized.getSubjectTokenType());
    assertEquals("https://sts.googleapis.com/v1/token", deserialized.getTokenUrl());
    assertEquals("quotaProjectId", deserialized.getQuotaProjectId());
    assertEquals("clientId", deserialized.getClientId());
    assertEquals("clientSecret", deserialized.getClientSecret());
    assertEquals(
        SERVICE_ACCOUNT_IMPERSONATION_URL, deserialized.getServiceAccountImpersonationUrl());
    assertEquals(null, deserialized.getIdentityPoolActorTokenSupplier());
    assertEquals(null, deserialized.getActorTokenType());
  }

  @Test
  void
      serialize_deserialize_fileCredentialSource_withCertificateConfig_restoresX509ProviderAndTransport(
          @TempDir Path tempDir) throws Exception {
    Path tokenFile = tempDir.resolve("credential.txt");
    Files.write(tokenFile, "token_from_file".getBytes(StandardCharsets.UTF_8));

    Map<String, Object> certMap = new HashMap<>();
    certMap.put("certificate_config_location", "testresources/mtls/certificate_config.json");

    Map<String, Object> sourceMap = new HashMap<>();
    sourceMap.put("file", tokenFile.toString());
    sourceMap.put("certificate", certMap);

    IdentityPoolCredentialSource credentialSource = new IdentityPoolCredentialSource(sourceMap);

    IdentityPoolCredentials credentials =
        IdentityPoolCredentials.newBuilder()
            .setCredentialSource(credentialSource)
            .setAudience("audience")
            .setSubjectTokenType("subjectTokenType")
            .setTokenUrl("https://sts.mtls.googleapis.com/v1/token")
            .build();

    assertNotNull(credentials.getX509Provider());
    assertTrue(credentials.getTransportFactory() instanceof MtlsHttpTransportFactory);
    assertTrue(((MtlsHttpTransportFactory) credentials.getTransportFactory()).hasKeyStore());

    IdentityPoolCredentials deserialized = serializeAndDeserialize(credentials);
    assertNotNull(deserialized);
    assertNotNull(deserialized.getX509Provider());
    assertTrue(deserialized.getTransportFactory() instanceof MtlsHttpTransportFactory);
    assertTrue(((MtlsHttpTransportFactory) deserialized.getTransportFactory()).hasKeyStore());

    // createScoped() should succeed without throwing
    IdentityPoolCredentials scoped =
        deserialized.createScoped(
            Collections.singletonList("https://www.googleapis.com/auth/cloud-platform"));
    assertNotNull(scoped);
    assertNotNull(scoped.getX509Provider());
    assertTrue(scoped.getTransportFactory() instanceof MtlsHttpTransportFactory);
    assertTrue(((MtlsHttpTransportFactory) scoped.getTransportFactory()).hasKeyStore());

    // refreshAccessToken() on deserialized credentials creates MtlsHttpTransportFactory from
    // restored X509Provider
    AtomicReference<HttpTransportFactory> capturedFactory = new AtomicReference<>();
    IdentityPoolCredentials testable =
        new IdentityPoolCredentials(deserialized.toBuilder()) {
          @Override
          protected AccessToken exchangeExternalCredentialForAccessToken(
              StsTokenExchangeRequest stsTokenExchangeRequest,
              HttpTransportFactory cycleTransportFactory) {
            capturedFactory.set(cycleTransportFactory);
            return new AccessToken("deserializedToken", null);
          }
        };
    AccessToken token = testable.refreshAccessToken();
    assertEquals("deserializedToken", token.getTokenValue());
    assertNotNull(capturedFactory.get());
    assertTrue(capturedFactory.get() instanceof MtlsHttpTransportFactory);
    assertTrue(((MtlsHttpTransportFactory) capturedFactory.get()).hasKeyStore());
  }

  @Test
  void serialize_deserialize_certificateCredentialSource_restoresX509ProviderAndTransport()
      throws Exception {
    Map<String, Object> certMap = new HashMap<>();
    certMap.put("certificate_config_location", "testresources/mtls/certificate_config.json");

    Map<String, Object> sourceMap = new HashMap<>();
    sourceMap.put("certificate", certMap);

    IdentityPoolCredentialSource credentialSource = new IdentityPoolCredentialSource(sourceMap);

    IdentityPoolCredentials credentials =
        IdentityPoolCredentials.newBuilder()
            .setCredentialSource(credentialSource)
            .setAudience("audience")
            .setSubjectTokenType("subjectTokenType")
            .setTokenUrl("https://sts.mtls.googleapis.com/v1/token")
            .build();

    assertNotNull(credentials.getX509Provider());
    assertTrue(credentials.getTransportFactory() instanceof MtlsHttpTransportFactory);
    assertTrue(((MtlsHttpTransportFactory) credentials.getTransportFactory()).hasKeyStore());

    IdentityPoolCredentials deserialized = serializeAndDeserialize(credentials);
    assertNotNull(deserialized);
    assertNotNull(deserialized.getX509Provider());
    assertTrue(deserialized.getTransportFactory() instanceof MtlsHttpTransportFactory);
    assertTrue(((MtlsHttpTransportFactory) deserialized.getTransportFactory()).hasKeyStore());

    // createScoped() should succeed without throwing
    IdentityPoolCredentials scoped =
        deserialized.createScoped(
            Collections.singletonList("https://www.googleapis.com/auth/cloud-platform"));
    assertNotNull(scoped);
    assertNotNull(scoped.getX509Provider());
    assertTrue(scoped.getTransportFactory() instanceof MtlsHttpTransportFactory);
    assertTrue(((MtlsHttpTransportFactory) scoped.getTransportFactory()).hasKeyStore());

    // refreshAccessToken() on deserialized credentials creates MtlsHttpTransportFactory from
    // restored X509Provider
    AtomicReference<HttpTransportFactory> capturedFactory = new AtomicReference<>();
    IdentityPoolCredentials testable =
        new IdentityPoolCredentials(deserialized.toBuilder()) {
          @Override
          protected AccessToken exchangeExternalCredentialForAccessToken(
              StsTokenExchangeRequest stsTokenExchangeRequest,
              HttpTransportFactory cycleTransportFactory) {
            capturedFactory.set(cycleTransportFactory);
            return new AccessToken("deserializedCertToken", null);
          }
        };
    AccessToken token = testable.refreshAccessToken();
    assertEquals("deserializedCertToken", token.getTokenValue());
    assertNotNull(capturedFactory.get());
    assertTrue(capturedFactory.get() instanceof MtlsHttpTransportFactory);
  }

  @Test
  void serialize_deserialize_programmaticFlow_andRefresh_succeeds() throws Exception {
    IdentityPoolCredentials credentials =
        IdentityPoolCredentials.newBuilder()
            .setSubjectTokenSupplier(testProvider)
            .setAudience(
                "//iam.googleapis.com/projects/123/locations/global/workloadIdentityPools/pool/providers/provider")
            .setSubjectTokenType("urn:ietf:params:oauth:token-type:jwt")
            .setTokenUrl("https://sts.googleapis.com/v1/token")
            .build();

    IdentityPoolCredentials deserialized = serializeAndDeserialize(credentials);
    assertNotNull(deserialized);
    assertNotNull(deserialized.getTransportFactory());
    assertNull(deserialized.getX509Provider());
    assertNotNull(deserialized.getIdentityPoolSubjectTokenSupplier());
    assertNull(deserialized.getIdentityPoolActorTokenSupplier());
    assertNull(deserialized.getActorTokenType());

    AtomicReference<StsTokenExchangeRequest> capturedRequest = new AtomicReference<>();
    IdentityPoolCredentials testable =
        new IdentityPoolCredentials(deserialized.toBuilder()) {
          @Override
          protected AccessToken exchangeExternalCredentialForAccessToken(
              StsTokenExchangeRequest stsTokenExchangeRequest,
              HttpTransportFactory cycleTransportFactory) {
            capturedRequest.set(stsTokenExchangeRequest);
            return new AccessToken("programmaticAccessToken", null);
          }
        };

    AccessToken token = testable.refreshAccessToken();
    assertEquals("programmaticAccessToken", token.getTokenValue());
    assertNotNull(capturedRequest.get());
    assertEquals("testSubjectToken", capturedRequest.get().getSubjectToken());
    assertEquals(
        "urn:ietf:params:oauth:token-type:jwt", capturedRequest.get().getSubjectTokenType());
    assertNull(capturedRequest.get().getActingParty());
  }

  @Test
  void serialize_deserialize_programmaticFlow_withMtlsTransport_restoresFactoryWithoutKeyStore()
      throws Exception {
    KeyStore keyStore = createPopulatedKeyStore();
    HttpTransportFactory transportFactory = new MtlsHttpTransportFactory(keyStore);

    IdentityPoolCredentials credentials =
        IdentityPoolCredentials.newBuilder()
            .setSubjectTokenSupplier(context -> "testSubjectToken")
            .setActorTokenSupplier(context -> "testActorToken")
            .setActorTokenType("urn:ietf:params:oauth:token-type:jwt")
            .setAudience(
                "//iam.googleapis.com/projects/123/locations/global/workloadIdentityPools/pool/providers/provider")
            .setSubjectTokenType("urn:ietf:params:oauth:token-type:jwt")
            .setTokenUrl(MockExternalAccountCredentialsTransport.STS_MTLS_URL)
            .setHttpTransportFactory(transportFactory)
            .build();

    IdentityPoolCredentials deserialized = serializeAndDeserialize(credentials);
    assertNotNull(deserialized);
    // Programmatic flows restore default-constructed transportFactory from class name
    assertNotNull(deserialized.getTransportFactory());
    assertTrue(deserialized.getTransportFactory() instanceof MtlsHttpTransportFactory);
    assertFalse(((MtlsHttpTransportFactory) deserialized.getTransportFactory()).hasKeyStore());
    assertNull(deserialized.getX509Provider());
    assertNotNull(deserialized.getIdentityPoolSubjectTokenSupplier());
    assertNotNull(deserialized.getIdentityPoolActorTokenSupplier());
  }

  @Test
  void builder_actorTokenWithPlainPublicTokenUrl_throwsIllegalArgumentException() throws Exception {
    KeyStore keyStore = createPopulatedKeyStore();
    HttpTransportFactory transportFactory = new MtlsHttpTransportFactory(keyStore);

    IllegalArgumentException e =
        assertThrows(
            IllegalArgumentException.class,
            () ->
                IdentityPoolCredentials.newBuilder()
                    .setSubjectTokenSupplier(context -> "testSubjectToken")
                    .setActorTokenSupplier(context -> "testActorToken")
                    .setActorTokenType("urn:ietf:params:oauth:token-type:jwt")
                    .setAudience(
                        "//iam.googleapis.com/projects/123/locations/global/workloadIdentityPools/pool/providers/provider")
                    .setSubjectTokenType("urn:ietf:params:oauth:token-type:jwt")
                    .setTokenUrl("https://sts.googleapis.com/v1/token")
                    .setHttpTransportFactory(transportFactory)
                    .build());
    assertTrue(e.getMessage().contains("tokenUrl"));
    assertTrue(e.getMessage().contains("plain public Google API endpoint"));
  }

  @Test
  void builder_actorTokenWithPlainPublicImpersonationUrl_throwsIllegalArgumentException()
      throws Exception {
    KeyStore keyStore = createPopulatedKeyStore();
    HttpTransportFactory transportFactory = new MtlsHttpTransportFactory(keyStore);

    IllegalArgumentException e =
        assertThrows(
            IllegalArgumentException.class,
            () ->
                IdentityPoolCredentials.newBuilder()
                    .setSubjectTokenSupplier(context -> "testSubjectToken")
                    .setActorTokenSupplier(context -> "testActorToken")
                    .setActorTokenType("urn:ietf:params:oauth:token-type:jwt")
                    .setAudience(
                        "//iam.googleapis.com/projects/123/locations/global/workloadIdentityPools/pool/providers/provider")
                    .setSubjectTokenType("urn:ietf:params:oauth:token-type:jwt")
                    .setTokenUrl(MockExternalAccountCredentialsTransport.STS_MTLS_URL)
                    .setServiceAccountImpersonationUrl(
                        "https://iamcredentials.googleapis.com/v1/projects/-/serviceAccounts/test@project.iam.gserviceaccount.com:generateAccessToken")
                    .setHttpTransportFactory(transportFactory)
                    .build());
    assertTrue(e.getMessage().contains("serviceAccountImpersonationUrl"));
    assertTrue(e.getMessage().contains("plain public Google API endpoint"));
  }

  @Test
  void builder_actorTokenWithMtlsTokenUrl_succeeds() throws Exception {
    KeyStore keyStore = createPopulatedKeyStore();
    HttpTransportFactory transportFactory = new MtlsHttpTransportFactory(keyStore);

    IdentityPoolCredentials cred =
        IdentityPoolCredentials.newBuilder()
            .setSubjectTokenSupplier(context -> "testSubjectToken")
            .setActorTokenSupplier(context -> "testActorToken")
            .setActorTokenType("urn:ietf:params:oauth:token-type:jwt")
            .setAudience(
                "//iam.googleapis.com/projects/123/locations/global/workloadIdentityPools/pool/providers/provider")
            .setSubjectTokenType("urn:ietf:params:oauth:token-type:jwt")
            .setTokenUrl(MockExternalAccountCredentialsTransport.STS_MTLS_URL)
            .setServiceAccountImpersonationUrl(
                "https://iamcredentials.mtls.googleapis.com/v1/projects/-/serviceAccounts/test@project.iam.gserviceaccount.com:generateAccessToken")
            .setHttpTransportFactory(transportFactory)
            .build();
    assertNotNull(cred);
  }

  @Test
  void builder_actorTokenWithPscUrls_succeeds() throws Exception {
    KeyStore keyStore = createPopulatedKeyStore();
    HttpTransportFactory transportFactory = new MtlsHttpTransportFactory(keyStore);

    IdentityPoolCredentials cred =
        IdentityPoolCredentials.newBuilder()
            .setSubjectTokenSupplier(context -> "testSubjectToken")
            .setActorTokenSupplier(context -> "testActorToken")
            .setActorTokenType("urn:ietf:params:oauth:token-type:jwt")
            .setAudience(
                "//iam.googleapis.com/projects/123/locations/global/workloadIdentityPools/pool/providers/provider")
            .setSubjectTokenType("urn:ietf:params:oauth:token-type:jwt")
            .setTokenUrl("https://sts.p.googleapis.com/v1/token")
            .setServiceAccountImpersonationUrl(
                "https://iamcredentials.p.googleapis.com/v1/projects/-/serviceAccounts/test@project.iam.gserviceaccount.com:generateAccessToken")
            .setHttpTransportFactory(transportFactory)
            .build();
    assertNotNull(cred);
  }

  @Test
  void builder_actorTokenWithCustomDomainUrls_succeeds() throws Exception {
    KeyStore keyStore = createPopulatedKeyStore();
    HttpTransportFactory transportFactory = new MtlsHttpTransportFactory(keyStore);

    IdentityPoolCredentials cred =
        IdentityPoolCredentials.newBuilder()
            .setSubjectTokenSupplier(context -> "testSubjectToken")
            .setActorTokenSupplier(context -> "testActorToken")
            .setActorTokenType("urn:ietf:params:oauth:token-type:jwt")
            .setAudience("//custom.domain.com/pool")
            .setSubjectTokenType("urn:ietf:params:oauth:token-type:jwt")
            .setTokenUrl("https://auth.custom-domain.com/v1/token")
            .setServiceAccountImpersonationUrl("https://iam.custom-domain.com/v1/generate")
            .setHttpTransportFactory(transportFactory)
            .build();
    assertNotNull(cred);
  }

  @Test
  void fromBuilder_withCustomTransportFactoryAndCertificateConfig_preservesCustomTransportFactory(
      @TempDir Path tempDir) throws Exception {
    Path tokenFile = tempDir.resolve("credential.txt");
    Files.write(tokenFile, "token_from_file".getBytes(StandardCharsets.UTF_8));

    Map<String, Object> certMap = new HashMap<>();
    certMap.put("certificate_config_location", "testresources/mtls/certificate_config.json");

    Map<String, Object> sourceMap = new HashMap<>();
    sourceMap.put("file", tokenFile.toString());
    sourceMap.put("certificate", certMap);

    IdentityPoolCredentialSource source = new IdentityPoolCredentialSource(sourceMap);
    HttpTransportFactory customTransportFactory =
        () -> new MockExternalAccountCredentialsTransport();

    IdentityPoolCredentials credentials =
        IdentityPoolCredentials.newBuilder()
            .setAudience(
                "//iam.googleapis.com/projects/123/locations/global/workloadIdentityPools/pool/providers/provider")
            .setSubjectTokenType("urn:ietf:params:oauth:token-type:jwt")
            .setTokenUrl("https://sts.googleapis.com/v1/token")
            .setCredentialSource(source)
            .setHttpTransportFactory(customTransportFactory)
            .build();

    assertSame(customTransportFactory, credentials.getTransportFactory());
  }

  // ==================================================================================
  // Section E: Production Path (fromStream) Tests
  // ==================================================================================

  @Test
  void fromStream_fileCredentialSource_withCertificateConfig_andActorToken_refreshesSuccessfully(
      @TempDir Path tempDir) throws Exception {
    Path tokenFile = tempDir.resolve("credential.json");
    GenericJson tokenJson = new GenericJson();
    tokenJson.setFactory(JSON_FACTORY);
    tokenJson.put("subject_token", "testSubjectTokenFromStream");
    tokenJson.put("actor_token", "testActorTokenFromStream");
    OAuth2Utils.writeInputStreamToFile(
        new ByteArrayInputStream(tokenJson.toPrettyString().getBytes(StandardCharsets.UTF_8)),
        tokenFile.toString());

    String configJson =
        "{\n"
            + "  \"type\": \"external_account\",\n"
            + "  \"audience\":"
            + " \"//iam.googleapis.com/projects/123/locations/global/workloadIdentityPools/pool/providers/provider\",\n"
            + "  \"subject_token_type\": \"urn:ietf:params:oauth:token-type:jwt\",\n"
            + "  \"actor_token_type\": \"urn:ietf:params:oauth:token-type:jwt\",\n"
            + "  \"token_url\": \"https://sts.mtls.googleapis.com/v1/token\",\n"
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
            + "      \"certificate_config_location\":"
            + " \"testresources/mtls/certificate_config.json\"\n"
            + "    }\n"
            + "  }\n"
            + "}";

    ExternalAccountCredentials credentials =
        ExternalAccountCredentials.fromStream(
            new ByteArrayInputStream(configJson.getBytes(StandardCharsets.UTF_8)));

    assertTrue(credentials instanceof IdentityPoolCredentials);
    IdentityPoolCredentials idp = (IdentityPoolCredentials) credentials;
    assertNotNull(idp.getX509Provider());
    assertEquals("urn:ietf:params:oauth:token-type:jwt", idp.getActorTokenType());
    assertTrue(idp.getTransportFactory() instanceof MtlsHttpTransportFactory);
    assertTrue(((MtlsHttpTransportFactory) idp.getTransportFactory()).hasKeyStore());
    assertSame(idp.getIdentityPoolSubjectTokenSupplier(), idp.getIdentityPoolActorTokenSupplier());

    // Execute refreshAccessToken() on testable credentials constructed from idp.toBuilder()
    AtomicReference<StsTokenExchangeRequest> capturedRequest = new AtomicReference<>();
    AtomicReference<HttpTransportFactory> capturedFactory = new AtomicReference<>();
    IdentityPoolCredentials testable =
        new IdentityPoolCredentials(idp.toBuilder()) {
          @Override
          protected AccessToken exchangeExternalCredentialForAccessToken(
              StsTokenExchangeRequest stsTokenExchangeRequest,
              HttpTransportFactory cycleTransportFactory) {
            capturedRequest.set(stsTokenExchangeRequest);
            capturedFactory.set(cycleTransportFactory);
            return new AccessToken("prodAccessToken", null);
          }
        };

    AccessToken token = testable.refreshAccessToken();
    assertEquals("prodAccessToken", token.getTokenValue());
    assertNotNull(capturedRequest.get());
    assertEquals("testSubjectTokenFromStream", capturedRequest.get().getSubjectToken());
    assertEquals(
        "urn:ietf:params:oauth:token-type:jwt", capturedRequest.get().getSubjectTokenType());
    assertNotNull(capturedRequest.get().getActingParty());
    assertEquals(
        "testActorTokenFromStream", capturedRequest.get().getActingParty().getActorToken());
    assertEquals(
        "urn:ietf:params:oauth:token-type:jwt",
        capturedRequest.get().getActingParty().getActorTokenType());
    assertNotNull(capturedFactory.get());
    assertTrue(capturedFactory.get() instanceof MtlsHttpTransportFactory);
    assertTrue(((MtlsHttpTransportFactory) capturedFactory.get()).hasKeyStore());
  }

  @Test
  void fromStream_fileCredentialSource_certRotation_401Retry_succeeds(@TempDir Path tempDir)
      throws Exception {
    Path tokenFile = tempDir.resolve("credential.json");
    GenericJson tokenJson = new GenericJson();
    tokenJson.setFactory(JSON_FACTORY);
    tokenJson.put("subject_token", "testSubjectToken401");
    OAuth2Utils.writeInputStreamToFile(
        new ByteArrayInputStream(tokenJson.toPrettyString().getBytes(StandardCharsets.UTF_8)),
        tokenFile.toString());

    Path certFile = tempDir.resolve("cert.pem");
    Path keyFile = tempDir.resolve("key.pem");
    Files.copy(new File("testresources/mtls/test_cert.pem").toPath(), certFile);
    Files.copy(new File("testresources/mtls/test_key.pem").toPath(), keyFile);

    Path certConfigFile = tempDir.resolve("certificate_config.json");
    String certConfigJson =
        "{\n"
            + "  \"cert_configs\": {\n"
            + "    \"workload\": {\n"
            + "      \"cert_path\": \""
            + certFile.toString().replace("\\", "\\\\")
            + "\",\n"
            + "      \"key_path\": \""
            + keyFile.toString().replace("\\", "\\\\")
            + "\"\n"
            + "    }\n"
            + "  }\n"
            + "}";
    Files.write(certConfigFile, certConfigJson.getBytes(StandardCharsets.UTF_8));

    String configJson =
        "{\n"
            + "  \"type\": \"external_account\",\n"
            + "  \"audience\":"
            + " \"//iam.googleapis.com/projects/123/locations/global/workloadIdentityPools/pool/providers/provider\",\n"
            + "  \"subject_token_type\": \"urn:ietf:params:oauth:token-type:jwt\",\n"
            + "  \"token_url\": \"https://sts.googleapis.com/v1/token\",\n"
            + "  \"credential_source\": {\n"
            + "    \"file\": \""
            + tokenFile.toString().replace("\\", "\\\\")
            + "\",\n"
            + "    \"format\": {\n"
            + "      \"type\": \"json\",\n"
            + "      \"subject_token_field_name\": \"subject_token\"\n"
            + "    },\n"
            + "    \"certificate\": {\n"
            + "      \"certificate_config_location\": \""
            + certConfigFile.toString().replace("\\", "\\\\")
            + "\"\n"
            + "    }\n"
            + "  }\n"
            + "}";

    ExternalAccountCredentials credentials =
        ExternalAccountCredentials.fromStream(
            new ByteArrayInputStream(configJson.getBytes(StandardCharsets.UTF_8)));

    assertTrue(credentials instanceof IdentityPoolCredentials);
    IdentityPoolCredentials idp = (IdentityPoolCredentials) credentials;
    assertNotNull(idp.getX509Provider());

    AtomicInteger exchangeCount = new AtomicInteger(0);
    IdentityPoolCredentials testable =
        new IdentityPoolCredentials(idp.toBuilder()) {
          @Override
          protected AccessToken exchangeExternalCredentialForAccessToken(
              StsTokenExchangeRequest stsTokenExchangeRequest,
              HttpTransportFactory cycleTransportFactory)
              throws IOException {
            if (exchangeCount.incrementAndGet() == 1) {
              Files.write(
                  certFile, Files.readAllBytes(Paths.get("testresources/mtls/test_cert_2.pem")));
              Files.write(
                  keyFile, Files.readAllBytes(Paths.get("testresources/mtls/test_key_2.pem")));
              throw new OAuthException("invalid_client", "Unauthorized", null, 401);
            }
            return new AccessToken("rotatedRetryToken", null);
          }
        };

    AccessToken token = testable.refreshAccessToken();
    assertEquals("rotatedRetryToken", token.getTokenValue());
    assertEquals(2, exchangeCount.get());
  }

  @Test
  void
      refreshAccessToken_customTransportFactoryWithCertificateConfig_preservesCustomTransportFactory(
          @TempDir Path tempDir) throws Exception {
    Path tokenFile = tempDir.resolve("credential.json");
    GenericJson tokenJson = new GenericJson();
    tokenJson.setFactory(JSON_FACTORY);
    tokenJson.put("subject_token", "testSubjectToken");
    OAuth2Utils.writeInputStreamToFile(
        new ByteArrayInputStream(tokenJson.toPrettyString().getBytes(StandardCharsets.UTF_8)),
        tokenFile.toString());

    Map<String, Object> certificateMap = new HashMap<>();
    certificateMap.put("use_default_certificate_config", false);
    certificateMap.put("certificate_config_location", "testresources/mtls/certificate_config.json");
    Map<String, Object> formatMap = new HashMap<>();
    formatMap.put("type", "json");
    formatMap.put("subject_token_field_name", "subject_token");
    Map<String, Object> credentialSourceMap = new HashMap<>();
    credentialSourceMap.put("file", tokenFile.toString());
    credentialSourceMap.put("format", formatMap);
    credentialSourceMap.put("certificate", certificateMap);

    IdentityPoolCredentialSource credentialSource =
        new IdentityPoolCredentialSource(credentialSourceMap);
    MockExternalAccountCredentialsTransportFactory customTransportFactory =
        new MockExternalAccountCredentialsTransportFactory();

    TransportCapturingCredentials credential =
        new TransportCapturingCredentials(
            IdentityPoolCredentials.newBuilder()
                .setCredentialSource(credentialSource)
                .setHttpTransportFactory(customTransportFactory)
                .setAudience("audience")
                .setSubjectTokenType("subjectTokenType")
                .setTokenUrl("https://sts.mtls.googleapis.com/v1/token"));

    assertSame(customTransportFactory, credential.getTransportFactory());
    IdentityPoolCredentials scopedCustom =
        credential.createScoped(
            Collections.singletonList("https://www.googleapis.com/auth/cloud-platform"));
    assertSame(customTransportFactory, scopedCustom.getTransportFactory());

    AccessToken token = credential.refreshAccessToken();
    assertNotNull(token);
    assertEquals(1, credential.getCapturedFactories().size());
    assertSame(customTransportFactory, credential.getCapturedFactories().get(0));
  }

  @Test
  void createScoped_withCertificateConfig_preservesMtlsTransportSnapshot(@TempDir Path tempDir)
      throws Exception {
    Path tokenFile = tempDir.resolve("credential.json");
    GenericJson tokenJson = new GenericJson();
    tokenJson.setFactory(JSON_FACTORY);
    tokenJson.put("subject_token", "testSubjectToken");
    OAuth2Utils.writeInputStreamToFile(
        new ByteArrayInputStream(tokenJson.toPrettyString().getBytes(StandardCharsets.UTF_8)),
        tokenFile.toString());

    Map<String, Object> certificateMap = new HashMap<>();
    certificateMap.put("use_default_certificate_config", false);
    certificateMap.put("certificate_config_location", "testresources/mtls/certificate_config.json");
    Map<String, Object> formatMap = new HashMap<>();
    formatMap.put("type", "json");
    formatMap.put("subject_token_field_name", "subject_token");
    Map<String, Object> credentialSourceMap = new HashMap<>();
    credentialSourceMap.put("file", tokenFile.toString());
    credentialSourceMap.put("format", formatMap);
    credentialSourceMap.put("certificate", certificateMap);

    IdentityPoolCredentialSource credentialSource =
        new IdentityPoolCredentialSource(credentialSourceMap);

    KeyStore ks = createPopulatedKeyStore();
    AtomicInteger getKeyStoreCount = new AtomicInteger(0);
    X509Provider trackingProvider =
        new X509Provider() {
          @Override
          public KeyStore getKeyStore() {
            getKeyStoreCount.incrementAndGet();
            return ks;
          }
        };

    IdentityPoolCredentials credential =
        IdentityPoolCredentials.newBuilder()
            .setCredentialSource(credentialSource)
            .setX509Provider(trackingProvider)
            .setAudience("audience")
            .setSubjectTokenType("subjectTokenType")
            .setTokenUrl("https://sts.mtls.googleapis.com/v1/token")
            .build();

    assertEquals(1, getKeyStoreCount.get());
    assertTrue(credential.getTransportFactory() instanceof MtlsHttpTransportFactory);
    HttpTransportFactory originalTransportFactory = credential.getTransportFactory();

    IdentityPoolCredentials scoped =
        credential.createScoped(
            Collections.singletonList("https://www.googleapis.com/auth/cloud-platform"));

    assertEquals(1, getKeyStoreCount.get());
    assertTrue(scoped.getTransportFactory() instanceof MtlsHttpTransportFactory);
    assertSame(originalTransportFactory, scoped.getTransportFactory());

    IdentityPoolCredentials rebuiltWithProvider =
        credential.toBuilder().setX509Provider(trackingProvider).build();
    assertEquals(2, getKeyStoreCount.get());
    assertNotSame(originalTransportFactory, rebuiltWithProvider.getTransportFactory());
  }

  // ==================================================================================
  // Helper: TestableIdentityPoolCredentials — overrides exchange for 401 testing
  // ==================================================================================

  /**
   * A test subclass that overrides exchangeExternalCredentialForAccessToken to throw
   * OAuthException(401) on configurable calls, simulating the cert rotation retry path. This is
   * necessary because the real STS handler wraps HttpResponseException into OAuthException, which
   * is what the catch(OAuthException) in refreshAccessToken expects via normal STS flow.
   */
  private static class TestableIdentityPoolCredentials extends IdentityPoolCredentials {
    private final AtomicInteger exchangeCallCount = new AtomicInteger(0);
    private final boolean failOnFirstExchange;
    private final boolean failOnAllExchanges;

    TestableIdentityPoolCredentials(
        IdentityPoolCredentials.Builder builder, boolean failOnFirstExchange) {
      this(builder, failOnFirstExchange, false);
    }

    TestableIdentityPoolCredentials(
        IdentityPoolCredentials.Builder builder,
        boolean failOnFirstExchange,
        boolean failOnAllExchanges) {
      super(builder);
      this.failOnFirstExchange = failOnFirstExchange;
      this.failOnAllExchanges = failOnAllExchanges;
    }

    @Override
    protected AccessToken exchangeExternalCredentialForAccessToken(
        StsTokenExchangeRequest stsTokenExchangeRequest, HttpTransportFactory cycleTransportFactory)
        throws IOException {
      int count = exchangeCallCount.incrementAndGet();
      if (failOnAllExchanges || (failOnFirstExchange && count == 1)) {
        throw new OAuthException("invalid_client", "Unauthorized", null, 401);
      }
      // Return a dummy access token for the retry path
      return new AccessToken("retryAccessToken", null);
    }

    int getExchangeCallCount() {
      return exchangeCallCount.get();
    }
  }

  // ==================================================================================
  // Helper: TransportCapturingCredentials — captures transport factory for cert tests
  // ==================================================================================

  /**
   * A test subclass that captures the HttpTransportFactory passed to
   * exchangeExternalCredentialForAccessToken, allowing tests to verify cert pinning behavior
   * without making real HTTP calls.
   */
  private static class TransportCapturingCredentials extends IdentityPoolCredentials {
    private final List<HttpTransportFactory> capturedFactories =
        Collections.synchronizedList(new ArrayList<>());

    TransportCapturingCredentials(IdentityPoolCredentials.Builder builder) {
      super(builder);
    }

    @Override
    protected AccessToken exchangeExternalCredentialForAccessToken(
        StsTokenExchangeRequest stsTokenExchangeRequest, HttpTransportFactory cycleTransportFactory)
        throws IOException {
      capturedFactories.add(cycleTransportFactory);
      // Return a dummy access token
      return new AccessToken("capturedAccessToken", null);
    }

    List<HttpTransportFactory> getCapturedFactories() {
      return capturedFactories;
    }
  }

  // ==================================================================================
  // Section: IAM Impersonation mTLS Transport Pinning & Retry Tests
  // ==================================================================================

  @Test
  void refreshAccessToken_impersonation_pinsTransportForBothStsAndIam() throws Exception {
    KeyStore ks = createPopulatedKeyStore();
    AtomicInteger getKeyStoreCallCount = new AtomicInteger(0);
    X509Provider x509Provider =
        new X509Provider() {
          @Override
          public KeyStore getKeyStore() {
            getKeyStoreCallCount.incrementAndGet();
            return ks;
          }
        };

    AtomicInteger stsCallCount = new AtomicInteger(0);
    AtomicInteger iamCallCount = new AtomicInteger(0);
    List<String> iamAuthHeaders = Collections.synchronizedList(new ArrayList<>());

    MockHttpTransport mockTransport =
        new MockHttpTransport() {
          @Override
          public LowLevelHttpRequest buildRequest(String method, String url) {
            return new MockLowLevelHttpRequest(url) {
              @Override
              public LowLevelHttpResponse execute() {
                if (url.contains("/v1/token")) {
                  int count = stsCallCount.incrementAndGet();
                  GenericJson response = new GenericJson();
                  response.setFactory(OAuth2Utils.JSON_FACTORY);
                  response.put("access_token", "intermediate-sts-token-" + count);
                  response.put("token_type", "Bearer");
                  response.put("expires_in", 3600);
                  response.put(
                      "issued_token_type", "urn:ietf:params:oauth:token-type:access_token");
                  return new MockLowLevelHttpResponse()
                      .setContentType(Json.MEDIA_TYPE)
                      .setContent(response.toString());
                } else if (url.contains(":generateAccessToken")) {
                  int count = iamCallCount.incrementAndGet();
                  iamAuthHeaders.add(getFirstHeaderValue("Authorization"));
                  GenericJson response = new GenericJson();
                  response.setFactory(OAuth2Utils.JSON_FACTORY);
                  response.put("accessToken", "final-iam-token-" + count);
                  response.put("expireTime", "2030-01-01T00:00:00Z");
                  return new MockLowLevelHttpResponse()
                      .setContentType(Json.MEDIA_TYPE)
                      .setContent(response.toString());
                }
                return new MockLowLevelHttpResponse().setStatusCode(404);
              }
            };
          }
        };

    List<KeyStore> usedKeyStores = new ArrayList<>();
    List<KeyStore> requestKeyStores = Collections.synchronizedList(new ArrayList<>());
    IdentityPoolCredentials credential =
        new IdentityPoolCredentials(
            IdentityPoolCredentials.newBuilder()
                .setSubjectTokenSupplier(testProvider)
                .setX509Provider(x509Provider)
                .setAudience(
                    "//iam.googleapis.com/projects/123/locations/global/workloadIdentityPools/pool/providers/provider")
                .setSubjectTokenType("urn:ietf:params:oauth:token-type:id_token")
                .setTokenUrl("https://sts.mtls.googleapis.com/v1/token")
                .setServiceAccountImpersonationUrl(
                    "https://iamcredentials.googleapis.com/v1/projects/-/serviceAccounts/test@project.iam.gserviceaccount.com:generateAccessToken")) {
          @Override
          HttpTransportFactory createMtlsTransportFactory(KeyStore keyStore) {
            usedKeyStores.add(keyStore);
            return () ->
                new MockHttpTransport() {
                  @Override
                  public LowLevelHttpRequest buildRequest(String method, String url)
                      throws IOException {
                    requestKeyStores.add(keyStore);
                    return mockTransport.buildRequest(method, url);
                  }
                };
          }
        };

    AccessToken token = credential.refreshAccessToken();
    assertNotNull(token);
    assertEquals("final-iam-token-1", token.getTokenValue());

    // Verify MtlsHttpTransportFactory was constructed with the pinned KeyStore.
    assertEquals(Collections.singletonList(ks), usedKeyStores);
    assertEquals(Arrays.asList(ks, ks), requestKeyStores);

    // getKeyStore() should be called exactly once per refresh cycle.
    assertEquals(1, getKeyStoreCallCount.get());

    // Both STS and IAM should have been called once on the transport.
    assertEquals(1, stsCallCount.get());
    assertEquals(1, iamCallCount.get());

    // Verify the IAM request received Authorization: Bearer <intermediate-token>.
    assertEquals(1, iamAuthHeaders.size());
    assertEquals("Bearer intermediate-sts-token-1", iamAuthHeaders.get(0));
  }

  @Test
  void refreshAccessToken_impersonation_401OnIam_retriesBothStsAndIamWithFreshCert()
      throws Exception {
    KeyStore ks1 = createPopulatedKeyStore();
    KeyStore ks2 = createRotatedPopulatedKeyStore();
    AtomicInteger getKeyStoreCallCount = new AtomicInteger(0);
    X509Provider x509Provider =
        new X509Provider() {
          @Override
          public KeyStore getKeyStore() {
            int count = getKeyStoreCallCount.incrementAndGet();
            return count == 1 ? ks1 : ks2;
          }
        };

    AtomicInteger stsCallCount = new AtomicInteger(0);
    AtomicInteger iamCallCount = new AtomicInteger(0);
    List<String> iamAuthHeaders = Collections.synchronizedList(new ArrayList<>());

    MockHttpTransport mockTransport =
        new MockHttpTransport() {
          @Override
          public LowLevelHttpRequest buildRequest(String method, String url) {
            return new MockLowLevelHttpRequest(url) {
              @Override
              public LowLevelHttpResponse execute() {
                if (url.contains("/v1/token")) {
                  int count = stsCallCount.incrementAndGet();
                  GenericJson response = new GenericJson();
                  response.setFactory(OAuth2Utils.JSON_FACTORY);
                  response.put("access_token", "intermediate-sts-token-" + count);
                  response.put("token_type", "Bearer");
                  response.put("expires_in", 3600);
                  response.put(
                      "issued_token_type", "urn:ietf:params:oauth:token-type:access_token");
                  return new MockLowLevelHttpResponse()
                      .setContentType(Json.MEDIA_TYPE)
                      .setContent(response.toString());
                } else if (url.contains(":generateAccessToken")) {
                  int count = iamCallCount.incrementAndGet();
                  iamAuthHeaders.add(getFirstHeaderValue("Authorization"));
                  if (count == 1) {
                    return new MockLowLevelHttpResponse()
                        .setStatusCode(401)
                        .setContentType(Json.MEDIA_TYPE)
                        .setContent("{\"error\": {\"code\": 401, \"message\": \"Unauthorized\"}}");
                  }
                  GenericJson response = new GenericJson();
                  response.setFactory(OAuth2Utils.JSON_FACTORY);
                  response.put("accessToken", "final-iam-token-" + count);
                  response.put("expireTime", "2030-01-01T00:00:00Z");
                  return new MockLowLevelHttpResponse()
                      .setContentType(Json.MEDIA_TYPE)
                      .setContent(response.toString());
                }
                return new MockLowLevelHttpResponse().setStatusCode(404);
              }
            };
          }
        };

    List<KeyStore> usedKeyStores = new ArrayList<>();
    List<KeyStore> requestKeyStores = Collections.synchronizedList(new ArrayList<>());
    IdentityPoolCredentials credential =
        new IdentityPoolCredentials(
            IdentityPoolCredentials.newBuilder()
                .setSubjectTokenSupplier(testProvider)
                .setX509Provider(x509Provider)
                .setAudience(
                    "//iam.googleapis.com/projects/123/locations/global/workloadIdentityPools/pool/providers/provider")
                .setSubjectTokenType("urn:ietf:params:oauth:token-type:id_token")
                .setTokenUrl("https://sts.mtls.googleapis.com/v1/token")
                .setServiceAccountImpersonationUrl(
                    "https://iamcredentials.googleapis.com/v1/projects/-/serviceAccounts/test@project.iam.gserviceaccount.com:generateAccessToken")) {
          @Override
          HttpTransportFactory createMtlsTransportFactory(KeyStore keyStore) {
            usedKeyStores.add(keyStore);
            return () ->
                new MockHttpTransport() {
                  @Override
                  public LowLevelHttpRequest buildRequest(String method, String url)
                      throws IOException {
                    requestKeyStores.add(keyStore);
                    return mockTransport.buildRequest(method, url);
                  }
                };
          }
        };

    AccessToken token = credential.refreshAccessToken();
    assertNotNull(token);
    assertEquals("final-iam-token-2", token.getTokenValue());

    // Verify initial cycle used ks1, and 401 retry used ks2 (fresh cert).
    assertEquals(Arrays.asList(ks1, ks2), usedKeyStores);
    assertEquals(Arrays.asList(ks1, ks1, ks2, ks2), requestKeyStores);

    // 1st call for initial cycle + 2nd call on 401 retry.
    assertEquals(2, getKeyStoreCallCount.get());

    // STS called twice (once on original cycle, once on retry with fresh cert).
    assertEquals(2, stsCallCount.get());

    // IAM called twice (once failed with 401, once succeeded on retry).
    assertEquals(2, iamCallCount.get());

    // IAM retry should have used the new intermediate STS token.
    assertEquals(2, iamAuthHeaders.size());
    assertEquals("Bearer intermediate-sts-token-1", iamAuthHeaders.get(0));
    assertEquals("Bearer intermediate-sts-token-2", iamAuthHeaders.get(1));
  }

  @Test
  void refreshAccessToken_impersonation_401OnIam_certLoadFailure_preservesOriginalError()
      throws Exception {
    KeyStore ks = createPopulatedKeyStore();
    AtomicInteger getKeyStoreCallCount = new AtomicInteger(0);
    X509Provider x509Provider =
        new X509Provider() {
          @Override
          public KeyStore getKeyStore() throws IOException {
            int count = getKeyStoreCallCount.incrementAndGet();
            if (count == 1) {
              return ks;
            }
            throw new IOException("Cert rotation reload disk error");
          }
        };

    List<KeyStore> requestKeyStores = new ArrayList<>();
    IdentityPoolCredentials credential =
        new IdentityPoolCredentials(
            IdentityPoolCredentials.newBuilder()
                .setSubjectTokenSupplier(testProvider)
                .setX509Provider(x509Provider)
                .setAudience(
                    "//iam.googleapis.com/projects/123/locations/global/workloadIdentityPools/pool/providers/provider")
                .setSubjectTokenType("urn:ietf:params:oauth:token-type:id_token")
                .setTokenUrl("https://sts.mtls.googleapis.com/v1/token")
                .setServiceAccountImpersonationUrl(
                    "https://iamcredentials.googleapis.com/v1/projects/-/serviceAccounts/test@project.iam.gserviceaccount.com:generateAccessToken")) {
          @Override
          HttpTransportFactory createMtlsTransportFactory(KeyStore keyStore) {
            return () ->
                new MockHttpTransport() {
                  @Override
                  public LowLevelHttpRequest buildRequest(String method, String url) {
                    requestKeyStores.add(keyStore);
                    return new MockLowLevelHttpRequest(url) {
                      @Override
                      public LowLevelHttpResponse execute() {
                        if (url.contains("/v1/token")) {
                          GenericJson response = new GenericJson();
                          response.setFactory(OAuth2Utils.JSON_FACTORY);
                          response.put("access_token", "intermediate-sts-token-1");
                          response.put("token_type", "Bearer");
                          response.put("expires_in", 3600);
                          response.put(
                              "issued_token_type", "urn:ietf:params:oauth:token-type:access_token");
                          return new MockLowLevelHttpResponse()
                              .setContentType(Json.MEDIA_TYPE)
                              .setContent(response.toString());
                        } else if (url.contains(":generateAccessToken")) {
                          return new MockLowLevelHttpResponse()
                              .setStatusCode(401)
                              .setContentType(Json.MEDIA_TYPE)
                              .setContent(
                                  "{\"error\": {\"code\": 401, \"message\": \"Unauthorized\"}}");
                        }
                        return new MockLowLevelHttpResponse().setStatusCode(404);
                      }
                    };
                  }
                };
          }
        };

    IOException thrown = assertThrows(IOException.class, credential::refreshAccessToken);
    assertEquals("Cert rotation reload disk error", thrown.getMessage());
    assertEquals(2, getKeyStoreCallCount.get());
    assertEquals(Arrays.asList(ks, ks), requestKeyStores);

    Throwable[] suppressed = thrown.getSuppressed();
    assertTrue(suppressed.length > 0);
    assertTrue(OAuth2Utils.isUnauthorizedException(suppressed[0]));
  }

  @Test
  void refreshAccessToken_impersonation_certRotationBetweenCycles_usesNewCert() throws Exception {
    KeyStore ksA = createPopulatedKeyStore();
    KeyStore ksB = createRotatedPopulatedKeyStore();
    AtomicInteger getKeyStoreCallCount = new AtomicInteger(0);
    X509Provider x509Provider =
        new X509Provider() {
          @Override
          public KeyStore getKeyStore() {
            int count = getKeyStoreCallCount.incrementAndGet();
            return count == 1 ? ksA : ksB;
          }
        };

    AtomicInteger stsCallCount = new AtomicInteger(0);
    AtomicInteger iamCallCount = new AtomicInteger(0);
    List<String> iamAuthHeaders = Collections.synchronizedList(new ArrayList<>());

    MockHttpTransport mockTransport =
        new MockHttpTransport() {
          @Override
          public LowLevelHttpRequest buildRequest(String method, String url) {
            return new MockLowLevelHttpRequest(url) {
              @Override
              public LowLevelHttpResponse execute() {
                if (url.contains("/v1/token")) {
                  int count = stsCallCount.incrementAndGet();
                  GenericJson response = new GenericJson();
                  response.setFactory(OAuth2Utils.JSON_FACTORY);
                  response.put("access_token", "intermediate-sts-token-" + count);
                  response.put("token_type", "Bearer");
                  response.put("expires_in", 3600);
                  response.put(
                      "issued_token_type", "urn:ietf:params:oauth:token-type:access_token");
                  return new MockLowLevelHttpResponse()
                      .setContentType(Json.MEDIA_TYPE)
                      .setContent(response.toString());
                } else if (url.contains(":generateAccessToken")) {
                  int count = iamCallCount.incrementAndGet();
                  iamAuthHeaders.add(getFirstHeaderValue("Authorization"));
                  GenericJson response = new GenericJson();
                  response.setFactory(OAuth2Utils.JSON_FACTORY);
                  response.put("accessToken", "final-iam-token-" + count);
                  response.put("expireTime", "2030-01-01T00:00:00Z");
                  return new MockLowLevelHttpResponse()
                      .setContentType(Json.MEDIA_TYPE)
                      .setContent(response.toString());
                }
                return new MockLowLevelHttpResponse().setStatusCode(404);
              }
            };
          }
        };

    List<KeyStore> usedKeyStores = new ArrayList<>();
    List<KeyStore> requestKeyStores = Collections.synchronizedList(new ArrayList<>());
    IdentityPoolCredentials credential =
        new IdentityPoolCredentials(
            IdentityPoolCredentials.newBuilder()
                .setSubjectTokenSupplier(testProvider)
                .setX509Provider(x509Provider)
                .setAudience(
                    "//iam.googleapis.com/projects/123/locations/global/workloadIdentityPools/pool/providers/provider")
                .setSubjectTokenType("urn:ietf:params:oauth:token-type:id_token")
                .setTokenUrl("https://sts.mtls.googleapis.com/v1/token")
                .setServiceAccountImpersonationUrl(
                    "https://iamcredentials.googleapis.com/v1/projects/-/serviceAccounts/test@project.iam.gserviceaccount.com:generateAccessToken")) {
          @Override
          HttpTransportFactory createMtlsTransportFactory(KeyStore keyStore) {
            usedKeyStores.add(keyStore);
            return () ->
                new MockHttpTransport() {
                  @Override
                  public LowLevelHttpRequest buildRequest(String method, String url)
                      throws IOException {
                    requestKeyStores.add(keyStore);
                    return mockTransport.buildRequest(method, url);
                  }
                };
          }
        };

    // Refresh cycle 1
    AccessToken token1 = credential.refreshAccessToken();
    assertNotNull(token1);
    assertEquals("final-iam-token-1", token1.getTokenValue());
    assertEquals(1, getKeyStoreCallCount.get());
    assertEquals(1, stsCallCount.get());
    assertEquals(1, iamCallCount.get());
    assertEquals("Bearer intermediate-sts-token-1", iamAuthHeaders.get(0));

    // Refresh cycle 2
    AccessToken token2 = credential.refreshAccessToken();
    assertNotNull(token2);
    assertEquals("final-iam-token-2", token2.getTokenValue());
    assertEquals(2, getKeyStoreCallCount.get());
    assertEquals(2, stsCallCount.get());
    assertEquals(2, iamCallCount.get());
    assertEquals("Bearer intermediate-sts-token-2", iamAuthHeaders.get(1));
    assertEquals(Arrays.asList(ksA, ksB), usedKeyStores);
    assertEquals(Arrays.asList(ksA, ksA, ksB, ksB), requestKeyStores);
  }

  @Test
  void refreshAccessToken_impersonation_persistent401OnIam_throwsWithSuppressed() throws Exception {
    KeyStore ks1 = createPopulatedKeyStore();
    KeyStore ks2 = createRotatedPopulatedKeyStore();
    AtomicInteger getKeyStoreCallCount = new AtomicInteger(0);
    X509Provider x509Provider =
        new X509Provider() {
          @Override
          public KeyStore getKeyStore() {
            int count = getKeyStoreCallCount.incrementAndGet();
            return count == 1 ? ks1 : ks2;
          }
        };

    AtomicInteger stsCallCount = new AtomicInteger(0);
    AtomicInteger iamCallCount = new AtomicInteger(0);

    MockHttpTransport mockTransport =
        new MockHttpTransport() {
          @Override
          public LowLevelHttpRequest buildRequest(String method, String url) {
            return new MockLowLevelHttpRequest(url) {
              @Override
              public LowLevelHttpResponse execute() {
                if (url.contains("/v1/token")) {
                  int count = stsCallCount.incrementAndGet();
                  GenericJson response = new GenericJson();
                  response.setFactory(OAuth2Utils.JSON_FACTORY);
                  response.put("access_token", "intermediate-sts-token-" + count);
                  response.put("token_type", "Bearer");
                  response.put("expires_in", 3600);
                  response.put(
                      "issued_token_type", "urn:ietf:params:oauth:token-type:access_token");
                  return new MockLowLevelHttpResponse()
                      .setContentType(Json.MEDIA_TYPE)
                      .setContent(response.toString());
                } else if (url.contains(":generateAccessToken")) {
                  iamCallCount.incrementAndGet();
                  return new MockLowLevelHttpResponse()
                      .setStatusCode(401)
                      .setContentType(Json.MEDIA_TYPE)
                      .setContent("{\"error\": {\"code\": 401, \"message\": \"Unauthorized\"}}");
                }
                return new MockLowLevelHttpResponse().setStatusCode(404);
              }
            };
          }
        };

    List<KeyStore> requestKeyStores = Collections.synchronizedList(new ArrayList<>());
    IdentityPoolCredentials credential =
        new IdentityPoolCredentials(
            IdentityPoolCredentials.newBuilder()
                .setSubjectTokenSupplier(testProvider)
                .setX509Provider(x509Provider)
                .setAudience(
                    "//iam.googleapis.com/projects/123/locations/global/workloadIdentityPools/pool/providers/provider")
                .setSubjectTokenType("urn:ietf:params:oauth:token-type:id_token")
                .setTokenUrl("https://sts.mtls.googleapis.com/v1/token")
                .setServiceAccountImpersonationUrl(
                    "https://iamcredentials.googleapis.com/v1/projects/-/serviceAccounts/test@project.iam.gserviceaccount.com:generateAccessToken")) {
          @Override
          HttpTransportFactory createMtlsTransportFactory(KeyStore keyStore) {
            return () ->
                new MockHttpTransport() {
                  @Override
                  public LowLevelHttpRequest buildRequest(String method, String url)
                      throws IOException {
                    requestKeyStores.add(keyStore);
                    return mockTransport.buildRequest(method, url);
                  }
                };
          }
        };

    IOException thrown = assertThrows(IOException.class, credential::refreshAccessToken);
    assertTrue(OAuth2Utils.isUnauthorizedException(thrown));
    assertEquals(1, thrown.getSuppressed().length);
    assertTrue(OAuth2Utils.isUnauthorizedException(thrown.getSuppressed()[0]));
    assertEquals(2, getKeyStoreCallCount.get());
    assertEquals(2, stsCallCount.get());
    assertEquals(2, iamCallCount.get());
    assertEquals(Arrays.asList(ks1, ks1, ks2, ks2), requestKeyStores);
  }

  @Test
  void refreshAccessToken_impersonation_non401OnIam_doesNotRetry() throws Exception {
    KeyStore ks1 = createPopulatedKeyStore();
    AtomicInteger getKeyStoreCallCount = new AtomicInteger(0);
    X509Provider x509Provider =
        new X509Provider() {
          @Override
          public KeyStore getKeyStore() {
            getKeyStoreCallCount.incrementAndGet();
            return ks1;
          }
        };

    AtomicInteger stsCallCount = new AtomicInteger(0);
    AtomicInteger iamCallCount = new AtomicInteger(0);

    MockHttpTransport mockTransport =
        new MockHttpTransport() {
          @Override
          public LowLevelHttpRequest buildRequest(String method, String url) {
            return new MockLowLevelHttpRequest(url) {
              @Override
              public LowLevelHttpResponse execute() {
                if (url.contains("/v1/token")) {
                  int count = stsCallCount.incrementAndGet();
                  GenericJson response = new GenericJson();
                  response.setFactory(OAuth2Utils.JSON_FACTORY);
                  response.put("access_token", "intermediate-sts-token-" + count);
                  response.put("token_type", "Bearer");
                  response.put("expires_in", 3600);
                  response.put(
                      "issued_token_type", "urn:ietf:params:oauth:token-type:access_token");
                  return new MockLowLevelHttpResponse()
                      .setContentType(Json.MEDIA_TYPE)
                      .setContent(response.toString());
                } else if (url.contains(":generateAccessToken")) {
                  iamCallCount.incrementAndGet();
                  return new MockLowLevelHttpResponse()
                      .setStatusCode(500)
                      .setContentType(Json.MEDIA_TYPE)
                      .setContent(
                          "{\"error\": {\"code\": 500, \"message\": \"Internal Server Error\"}}");
                }
                return new MockLowLevelHttpResponse().setStatusCode(404);
              }
            };
          }
        };

    List<KeyStore> requestKeyStores = Collections.synchronizedList(new ArrayList<>());
    IdentityPoolCredentials credential =
        new IdentityPoolCredentials(
            IdentityPoolCredentials.newBuilder()
                .setSubjectTokenSupplier(testProvider)
                .setX509Provider(x509Provider)
                .setAudience(
                    "//iam.googleapis.com/projects/123/locations/global/workloadIdentityPools/pool/providers/provider")
                .setSubjectTokenType("urn:ietf:params:oauth:token-type:id_token")
                .setTokenUrl("https://sts.mtls.googleapis.com/v1/token")
                .setServiceAccountImpersonationUrl(
                    "https://iamcredentials.googleapis.com/v1/projects/-/serviceAccounts/test@project.iam.gserviceaccount.com:generateAccessToken")) {
          @Override
          HttpTransportFactory createMtlsTransportFactory(KeyStore keyStore) {
            return () ->
                new MockHttpTransport() {
                  @Override
                  public LowLevelHttpRequest buildRequest(String method, String url)
                      throws IOException {
                    requestKeyStores.add(keyStore);
                    return mockTransport.buildRequest(method, url);
                  }
                };
          }
        };

    IOException thrown = assertThrows(IOException.class, credential::refreshAccessToken);
    assertFalse(OAuth2Utils.isUnauthorizedException(thrown));
    assertEquals(0, thrown.getSuppressed().length);
    assertEquals(1, getKeyStoreCallCount.get());
    assertEquals(1, stsCallCount.get());
    assertEquals(1, iamCallCount.get());
    assertEquals(Arrays.asList(ks1, ks1), requestKeyStores);
  }

  @Test
  void
      refreshAccessToken_impersonation_createScoped_passesCloudPlatformScopeToStsAndTargetScopeToIam()
          throws Exception {
    MockExternalAccountCredentialsTransport transport =
        new MockExternalAccountCredentialsTransport();
    transport.setExpireTime(TestUtils.getDefaultExpireTime());

    IdentityPoolCredentials baseCredential =
        IdentityPoolCredentials.newBuilder()
            .setSubjectTokenSupplier(testProvider)
            .setAudience(
                "//iam.googleapis.com/projects/123/locations/global/workloadIdentityPools/pool/providers/provider")
            .setSubjectTokenType("urn:ietf:params:oauth:token-type:id_token")
            .setTokenUrl(transport.getStsUrl())
            .setServiceAccountImpersonationUrl(transport.getServiceAccountImpersonationUrl())
            .setHttpTransportFactory(() -> transport)
            .build();

    List<String> targetScopes =
        Collections.singletonList("https://www.googleapis.com/auth/devstorage.read_only");
    transport.setExpectedIamScope("https://www.googleapis.com/auth/devstorage.read_only");
    IdentityPoolCredentials scopedCredential = baseCredential.createScoped(targetScopes);

    AccessToken token = scopedCredential.refreshAccessToken();
    assertNotNull(token);
    assertEquals(transport.getServiceAccountAccessToken(), token.getTokenValue());

    // Request 0 is STS token exchange from sourceCredentials; verify it requested cloud-platform
    // scope
    String stsRequestContent = transport.getRequests().get(0).getContentAsString();
    Map<String, String> stsParams = TestUtils.parseQuery(stsRequestContent);
    assertEquals(OAuth2Utils.CLOUD_PLATFORM_SCOPE, stsParams.get("scope"));

    // Request 1 is IAM generateAccessToken; verify it requested the downstream target scope
    String iamRequestContent = transport.getRequests().get(1).getContentAsString();
    try (JsonParser parser = OAuth2Utils.JSON_FACTORY.createJsonParser(iamRequestContent)) {
      GenericJson iamBody = parser.parseAndClose(GenericJson.class);
      assertEquals(targetScopes, iamBody.get("scope"));
    }
  }

  @Test
  void createScoped_withCredentialSourceAndCustomActorTokenSupplier_preservesActorTokenSupplier()
      throws Exception {
    IdentityPoolCredentialSource credentialSource =
        (IdentityPoolCredentialSource) createBaseFileSourcedCredentials().getCredentialSource();

    IdentityPoolActorTokenSupplier customActorSupplier = ctx -> "custom-actor-token";
    KeyStore ks = KeyStore.getInstance(KeyStore.getDefaultType());
    ks.load(null, null);

    IdentityPoolCredentials credentials =
        IdentityPoolCredentials.newBuilder()
            .setCredentialSource(credentialSource)
            .setActorTokenSupplier(customActorSupplier)
            .setActorTokenType("urn:ietf:params:oauth:token-type:access_token")
            .setX509Provider(
                new X509Provider(null) {
                  @Override
                  public KeyStore getKeyStore() {
                    return ks;
                  }
                })
            .setAudience(
                "//iam.googleapis.com/projects/123/locations/global/workloadIdentityPools/pool/providers/provider")
            .setSubjectTokenType("urn:ietf:params:oauth:token-type:id_token")
            .setTokenUrl("https://sts.mtls.googleapis.com/v1/token")
            .build();

    IdentityPoolCredentials scoped =
        credentials.createScoped(
            Collections.singletonList("https://www.googleapis.com/auth/cloud-platform"));
    assertEquals(customActorSupplier, scoped.getIdentityPoolActorTokenSupplier());
    assertEquals("urn:ietf:params:oauth:token-type:access_token", scoped.getActorTokenType());
  }

  @Test
  void refreshAccessToken_401RetryFailureOnSecondAttempt_attachesInitial401AsSuppressed()
      throws Exception {
    KeyStore ksA = createPopulatedKeyStore();
    KeyStore ksB = createRotatedPopulatedKeyStore();
    AtomicInteger callCount = new AtomicInteger(0);
    X509Provider rotatingProvider =
        new X509Provider(null) {
          @Override
          public KeyStore getKeyStore() {
            return callCount.getAndIncrement() == 0 ? ksA : ksB;
          }
        };

    TestableIdentityPoolCredentials credential =
        new TestableIdentityPoolCredentials(
            IdentityPoolCredentials.newBuilder()
                .setSubjectTokenSupplier(testProvider)
                .setX509Provider(rotatingProvider)
                .setAudience(
                    "//iam.googleapis.com/projects/123/locations/global/workloadIdentityPools/pool/providers/provider")
                .setSubjectTokenType("urn:ietf:params:oauth:token-type:id_token")
                .setTokenUrl("https://sts.mtls.googleapis.com/v1/token"),
            /* failOnFirstExchange= */ true,
            /* failOnAllExchanges= */ true);

    OAuthException thrown =
        assertThrows(OAuthException.class, () -> credential.refreshAccessToken());
    assertEquals(1, thrown.getSuppressed().length);
    assertTrue(thrown.getSuppressed()[0] instanceof OAuthException);
  }

  public static class CustomMtlsHttpTransportFactory extends MtlsHttpTransportFactory {
    public CustomMtlsHttpTransportFactory() {
      super();
    }

    public CustomMtlsHttpTransportFactory(KeyStore keyStore) {
      super(keyStore);
    }
  }

  @Test
  void
      customMtlsHttpTransportFactorySubclass_preservedInConstructorAndRefresh_rebuiltOnDeserialization()
          throws Exception {
    Map<String, Object> certificateMap = new HashMap<>();
    certificateMap.put("use_default_certificate_config", false);
    certificateMap.put("certificate_config_location", "testresources/mtls/certificate_config.json");
    Map<String, Object> credentialSourceMap = new HashMap<>();
    credentialSourceMap.put("file", "testresources/mtls/certificate_config.json");
    credentialSourceMap.put("certificate", certificateMap);
    IdentityPoolCredentialSource credentialSource =
        new IdentityPoolCredentialSource(credentialSourceMap);

    KeyStore ks = createPopulatedKeyStore();
    CustomMtlsHttpTransportFactory customFactory = new CustomMtlsHttpTransportFactory(ks);
    X509Provider x509Provider = new TestX509Provider(ks, "certificate_config_location");

    List<HttpTransportFactory> capturedCycleFactories = new ArrayList<>();
    IdentityPoolCredentials credentials =
        new IdentityPoolCredentials(
            IdentityPoolCredentials.newBuilder()
                .setHttpTransportFactory(customFactory)
                .setCredentialSource(credentialSource)
                .setX509Provider(x509Provider)
                .setAudience("audience")
                .setSubjectTokenType("subjectTokenType")
                .setTokenUrl("https://sts.mtls.googleapis.com/v1/token")) {
          @Override
          protected AccessToken exchangeExternalCredentialForAccessToken(
              StsTokenExchangeRequest stsTokenExchangeRequest,
              HttpTransportFactory cycleTransportFactory) {
            capturedCycleFactories.add(cycleTransportFactory);
            return new AccessToken("token", null);
          }
        };

    assertSame(
        customFactory,
        credentials.getTransportFactory(),
        "Constructor must preserve custom subclass of MtlsHttpTransportFactory");

    credentials.refreshAccessToken();
    assertEquals(1, capturedCycleFactories.size());
    assertSame(
        customFactory,
        capturedCycleFactories.get(0),
        "refreshAccessToken must use custom MtlsHttpTransportFactory subclass without overwriting");

    IdentityPoolCredentials regularCredentials =
        IdentityPoolCredentials.newBuilder()
            .setHttpTransportFactory(customFactory)
            .setCredentialSource(credentialSource)
            .setAudience("audience")
            .setSubjectTokenType("subjectTokenType")
            .setTokenUrl("https://sts.mtls.googleapis.com/v1/token")
            .build();
    IdentityPoolCredentials deserialized = serializeAndDeserialize(regularCredentials);
    assertEquals(
        MtlsHttpTransportFactory.class,
        deserialized.getTransportFactory().getClass(),
        "readObject must rebuild a base MtlsHttpTransportFactory when transient KeyStore is lost");
    assertTrue(
        ((MtlsHttpTransportFactory) deserialized.getTransportFactory()).hasKeyStore(),
        "readObject must restore a KeyStore-backed MtlsHttpTransportFactory");
  }

  @Test
  void fileCredentialSourceWithCertConfig_overriddenCreateMtlsTransportFactory_rotatesPerCycle(
      @TempDir Path tempDir) throws Exception {
    File tokenFile = tempDir.resolve("subject_token.txt").toFile();
    Files.write(tokenFile.toPath(), "test-subject-token".getBytes(StandardCharsets.UTF_8));

    Map<String, Object> certificateMap = new HashMap<>();
    certificateMap.put("use_default_certificate_config", false);
    certificateMap.put("certificate_config_location", "testresources/mtls/certificate_config.json");
    Map<String, Object> credentialSourceMap = new HashMap<>();
    credentialSourceMap.put("file", tokenFile.getAbsolutePath());
    credentialSourceMap.put("certificate", certificateMap);
    IdentityPoolCredentialSource credentialSource =
        new IdentityPoolCredentialSource(credentialSourceMap);

    KeyStore ksA = createPopulatedKeyStore();
    KeyStore ksB = createRotatedPopulatedKeyStore();
    AtomicInteger getKeyStoreCount = new AtomicInteger(0);
    X509Provider rotatingProvider =
        new X509Provider() {
          @Override
          public KeyStore getKeyStore() {
            // Call 1: constructor; Call 2: initial refresh attempt; Call 3: 401 retry
            int count = getKeyStoreCount.incrementAndGet();
            return count <= 2 ? ksA : ksB;
          }
        };

    List<KeyStore> requestKeyStores = new ArrayList<>();
    IdentityPoolCredentials credential =
        new IdentityPoolCredentials(
            IdentityPoolCredentials.newBuilder()
                .setCredentialSource(credentialSource)
                .setX509Provider(rotatingProvider)
                .setAudience(
                    "//iam.googleapis.com/projects/123/locations/global/workloadIdentityPools/pool/providers/provider")
                .setSubjectTokenType("urn:ietf:params:oauth:token-type:id_token")
                .setTokenUrl("https://sts.mtls.googleapis.com/v1/token")) {
          @Override
          HttpTransportFactory createMtlsTransportFactory(KeyStore keyStore) {
            return () ->
                new MockHttpTransport() {
                  @Override
                  public LowLevelHttpRequest buildRequest(String method, String url) {
                    requestKeyStores.add(keyStore);
                    return new MockLowLevelHttpRequest(url) {
                      @Override
                      public LowLevelHttpResponse execute() {
                        if (keyStore == ksA) {
                          return new MockLowLevelHttpResponse()
                              .setStatusCode(401)
                              .setContentType(Json.MEDIA_TYPE)
                              .setContent(
                                  "{\"error\": \"invalid_client\", \"error_description\":"
                                      + " \"Unauthorized\"}");
                        }
                        GenericJson response = new GenericJson();
                        response.setFactory(OAuth2Utils.JSON_FACTORY);
                        response.put("access_token", "rotated-sts-token");
                        response.put("token_type", "Bearer");
                        response.put("expires_in", 3600);
                        response.put(
                            "issued_token_type", "urn:ietf:params:oauth:token-type:access_token");
                        return new MockLowLevelHttpResponse()
                            .setContentType(Json.MEDIA_TYPE)
                            .setContent(response.toString());
                      }
                    };
                  }
                };
          }
        };

    AccessToken token = credential.refreshAccessToken();
    assertEquals("rotated-sts-token", token.getTokenValue());
    assertEquals(Arrays.asList(ksA, ksB), requestKeyStores);
  }

  @Test
  void
      refreshAccessToken_whenKeyStoreReloadThrowsRuntimeException_wrapsInIOExceptionAndSuppresses401()
          throws Exception {
    KeyStore ks1 = createPopulatedKeyStore();
    AtomicInteger getKeyStoreCount = new AtomicInteger(0);
    X509Provider x509Provider =
        new X509Provider(null) {
          @Override
          public KeyStore getKeyStore() {
            if (getKeyStoreCount.incrementAndGet() == 1) {
              return ks1;
            }
            throw new IllegalStateException("Unexpected keystore provider failure");
          }
        };

    IdentityPoolCredentials credential =
        new IdentityPoolCredentials(
            IdentityPoolCredentials.newBuilder()
                .setSubjectTokenSupplier(testProvider)
                .setX509Provider(x509Provider)
                .setAudience("audience")
                .setSubjectTokenType("subjectTokenType")
                .setTokenUrl("https://sts.mtls.googleapis.com/v1/token")) {
          @Override
          protected AccessToken exchangeExternalCredentialForAccessToken(
              StsTokenExchangeRequest stsTokenExchangeRequest,
              HttpTransportFactory cycleTransportFactory)
              throws IOException {
            throw new OAuthException("invalid_client", "Unauthorized", null, 401);
          }
        };

    IOException thrown = assertThrows(IOException.class, credential::refreshAccessToken);
    assertEquals("Failed to reload certificate on retry", thrown.getMessage());
    assertTrue(thrown.getCause() instanceof IllegalStateException);
    assertEquals("Unexpected keystore provider failure", thrown.getCause().getMessage());
    assertEquals(1, thrown.getSuppressed().length);
    assertTrue(thrown.getSuppressed()[0] instanceof OAuthException);
  }

  @Test
  void refreshAccessToken_impersonation_stsReturns401_retriesOnceViaOuterCycle() throws Exception {
    KeyStore ks1 = createPopulatedKeyStore();
    KeyStore ks2 = createRotatedPopulatedKeyStore();
    AtomicInteger getKeyStoreCallCount = new AtomicInteger(0);
    X509Provider x509Provider =
        new X509Provider(null) {
          @Override
          public KeyStore getKeyStore() {
            return getKeyStoreCallCount.incrementAndGet() == 1 ? ks1 : ks2;
          }
        };

    AtomicInteger stsCallCount = new AtomicInteger(0);
    AtomicInteger iamCallCount = new AtomicInteger(0);
    List<KeyStore> capturedKeyStores = new ArrayList<>();
    List<KeyStore> requestKeyStores = new ArrayList<>();

    IdentityPoolCredentials credential =
        new IdentityPoolCredentials(
            IdentityPoolCredentials.newBuilder()
                .setSubjectTokenSupplier(testProvider)
                .setX509Provider(x509Provider)
                .setAudience(
                    "//iam.googleapis.com/projects/123/locations/global/workloadIdentityPools/pool/providers/provider")
                .setSubjectTokenType("urn:ietf:params:oauth:token-type:id_token")
                .setTokenUrl("https://sts.mtls.googleapis.com/v1/token")
                .setServiceAccountImpersonationUrl(
                    "https://iamcredentials.googleapis.com/v1/projects/-/serviceAccounts/test@project.iam.gserviceaccount.com:generateAccessToken")) {
          @Override
          HttpTransportFactory createMtlsTransportFactory(KeyStore keyStore) {
            capturedKeyStores.add(keyStore);
            return () ->
                new MockHttpTransport() {
                  @Override
                  public LowLevelHttpRequest buildRequest(String method, String url) {
                    requestKeyStores.add(keyStore);
                    return new MockLowLevelHttpRequest(url) {
                      @Override
                      public LowLevelHttpResponse execute() {
                        if (url.contains("/v1/token")) {
                          int count = stsCallCount.incrementAndGet();
                          if (keyStore == ks1) {
                            return new MockLowLevelHttpResponse()
                                .setStatusCode(401)
                                .setContentType(Json.MEDIA_TYPE)
                                .setContent(
                                    "{\"error\":\"invalid_client\",\"error_description\":\"Cert"
                                        + " mismatch\"}");
                          }
                          GenericJson response = new GenericJson();
                          response.setFactory(OAuth2Utils.JSON_FACTORY);
                          response.put("access_token", "intermediate-sts-token-" + count);
                          response.put("token_type", "Bearer");
                          response.put("expires_in", 3600);
                          response.put(
                              "issued_token_type", "urn:ietf:params:oauth:token-type:access_token");
                          return new MockLowLevelHttpResponse()
                              .setContentType(Json.MEDIA_TYPE)
                              .setContent(response.toString());
                        } else if (url.contains(":generateAccessToken")) {
                          int count = iamCallCount.incrementAndGet();
                          GenericJson response = new GenericJson();
                          response.setFactory(OAuth2Utils.JSON_FACTORY);
                          response.put("accessToken", "final-iam-token-" + count);
                          response.put("expireTime", "2030-01-01T00:00:00Z");
                          return new MockLowLevelHttpResponse()
                              .setContentType(Json.MEDIA_TYPE)
                              .setContent(response.toString());
                        }
                        return new MockLowLevelHttpResponse().setStatusCode(404);
                      }
                    };
                  }
                };
          }
        };

    AccessToken token = credential.refreshAccessToken();
    assertEquals("final-iam-token-1", token.getTokenValue());
    // STS must be called only twice (initial attempt with ks1 + 1 outer retry with ks2).
    assertEquals(2, stsCallCount.get());
    assertEquals(1, iamCallCount.get());
    assertEquals(2, getKeyStoreCallCount.get());
    assertEquals(Arrays.asList(ks1, ks2), capturedKeyStores);
    assertEquals(Arrays.asList(ks1, ks2, ks2), requestKeyStores);
  }

  @Test
  void
      refreshAccessToken_certSubjectTokenSupplier_extractsLeafCertFromPinnedKeyStoreEvenWhenDiskRotates(
          @TempDir Path tempDir) throws Exception {
    Path certFile1 = tempDir.resolve("cert1.pem");
    Path keyFile1 = tempDir.resolve("key1.pem");
    Path certFile2 = tempDir.resolve("cert2.pem");
    Path keyFile2 = tempDir.resolve("key2.pem");
    Files.copy(Paths.get("testresources/mtls/test_cert.pem"), certFile1);
    Files.copy(Paths.get("testresources/mtls/test_key.pem"), keyFile1);
    Files.copy(Paths.get("testresources/mtls/test_cert_2.pem"), certFile2);
    Files.copy(Paths.get("testresources/mtls/test_key_2.pem"), keyFile2);

    Path certConfigFile = tempDir.resolve("certificate_config.json");
    String certConfigJson1 =
        "{\n"
            + "  \"cert_configs\": {\n"
            + "    \"workload\": {\n"
            + "      \"cert_path\": \""
            + certFile1.toString().replace("\\", "\\\\")
            + "\",\n"
            + "      \"key_path\": \""
            + keyFile1.toString().replace("\\", "\\\\")
            + "\"\n"
            + "    }\n"
            + "  }\n"
            + "}";
    Files.write(certConfigFile, certConfigJson1.getBytes(StandardCharsets.UTF_8));

    Map<String, Object> certificateMap = new HashMap<>();
    certificateMap.put("certificate_config_location", certConfigFile.toString());
    Map<String, Object> credentialSourceMap = new HashMap<>();
    credentialSourceMap.put("certificate", certificateMap);
    IdentityPoolCredentialSource credentialSource =
        new IdentityPoolCredentialSource(credentialSourceMap);

    KeyStore ks1 = createPopulatedKeyStore();
    KeyStore ks2 = createRotatedPopulatedKeyStore();
    AtomicInteger getKeyStoreCount = new AtomicInteger(0);
    X509Provider x509Provider =
        new X509Provider(null) {
          @Override
          public KeyStore getKeyStore() throws IOException {
            int call = getKeyStoreCount.incrementAndGet();
            if (call <= 2) {
              // On call 2 (the start of refreshAccessToken), overwrite cert1.pem on disk with
              // cert2.pem AND update certificate_config.json to point to cert2.pem/key2.pem AFTER
              // ks1 is loaded. This simulates a mid-cycle cert rotation between getKeyStore() and
              // getSubjectToken().
              if (call == 2) {
                Files.copy(certFile2, certFile1, StandardCopyOption.REPLACE_EXISTING);
                String certConfigJson2 =
                    "{\n"
                        + "  \"cert_configs\": {\n"
                        + "    \"workload\": {\n"
                        + "      \"cert_path\": \""
                        + certFile2.toString().replace("\\", "\\\\")
                        + "\",\n"
                        + "      \"key_path\": \""
                        + keyFile2.toString().replace("\\", "\\\\")
                        + "\"\n"
                        + "    }\n"
                        + "  }\n"
                        + "}";
                Files.write(certConfigFile, certConfigJson2.getBytes(StandardCharsets.UTF_8));
              }
              return ks1;
            }
            return ks2;
          }
        };

    List<String> capturedSubjectTokens = new ArrayList<>();
    IdentityPoolCredentials credential =
        new IdentityPoolCredentials(
            IdentityPoolCredentials.newBuilder()
                .setCredentialSource(credentialSource)
                .setX509Provider(x509Provider)
                .setAudience("audience")
                .setSubjectTokenType("urn:ietf:params:oauth:token-type:mtls")
                .setTokenUrl("https://sts.mtls.googleapis.com/v1/token")) {
          @Override
          protected AccessToken exchangeExternalCredentialForAccessToken(
              StsTokenExchangeRequest stsTokenExchangeRequest,
              HttpTransportFactory cycleTransportFactory) {
            capturedSubjectTokens.add(stsTokenExchangeRequest.getSubjectToken());
            return new AccessToken("mtls-bound-token", null);
          }
        };

    // Cycle 1: Even though cert1.pem on disk was overwritten with cert2.pem right after ks1 was
    // snapshotted, subject_token MUST match ks1 (not cert2.pem on disk).
    credential.refreshAccessToken();
    // Cycle 2: Now getKeyStore() returns ks2, so subject_token MUST match ks2.
    credential.refreshAccessToken();

    String expectedCert1Base64 =
        Base64.getEncoder()
            .encodeToString(
                CertificateIdentityPoolSubjectTokenSupplier.parseCertificate(
                        Files.readAllBytes(Paths.get("testresources/mtls/test_cert.pem")))
                    .getEncoded());
    String expectedCert2Base64 =
        Base64.getEncoder()
            .encodeToString(
                CertificateIdentityPoolSubjectTokenSupplier.parseCertificate(
                        Files.readAllBytes(Paths.get("testresources/mtls/test_cert_2.pem")))
                    .getEncoded());

    assertEquals(2, capturedSubjectTokens.size());
    assertTrue(capturedSubjectTokens.get(0).contains(expectedCert1Base64));
    assertFalse(capturedSubjectTokens.get(0).contains(expectedCert2Base64));
    assertTrue(capturedSubjectTokens.get(1).contains(expectedCert2Base64));
  }

  @Test
  void
      refreshAccessToken_impersonation_cachesOneHourStsTokenWhileKeyStoreUnchangedAndInvalidatesOnRotation()
          throws Exception {
    KeyStore ks1 = createPopulatedKeyStore();
    KeyStore ks2 = createRotatedPopulatedKeyStore();
    AtomicInteger getKeyStoreCallCount = new AtomicInteger(0);
    X509Provider x509Provider =
        new X509Provider(null) {
          @Override
          public KeyStore getKeyStore() {
            // Calls 1 & 2 return ks1 (unchanged cert); Call 3 returns ks2 (rotated cert).
            return getKeyStoreCallCount.incrementAndGet() <= 2 ? ks1 : ks2;
          }
        };

    AtomicInteger stsCallCount = new AtomicInteger(0);
    AtomicInteger iamCallCount = new AtomicInteger(0);
    List<String> iamBearerHeaders = new ArrayList<>();

    IdentityPoolCredentials credential =
        new IdentityPoolCredentials(
            IdentityPoolCredentials.newBuilder()
                .setSubjectTokenSupplier(testProvider)
                .setX509Provider(x509Provider)
                .setAudience(
                    "//iam.googleapis.com/projects/123/locations/global/workloadIdentityPools/pool/providers/provider")
                .setSubjectTokenType("urn:ietf:params:oauth:token-type:id_token")
                .setTokenUrl("https://sts.mtls.googleapis.com/v1/token")
                .setServiceAccountImpersonationUrl(
                    "https://iamcredentials.googleapis.com/v1/projects/-/serviceAccounts/test@project.iam.gserviceaccount.com:generateAccessToken")) {
          @Override
          HttpTransportFactory createMtlsTransportFactory(KeyStore keyStore) {
            return () ->
                new MockHttpTransport() {
                  @Override
                  public LowLevelHttpRequest buildRequest(String method, String url) {
                    return new MockLowLevelHttpRequest(url) {
                      @Override
                      public LowLevelHttpResponse execute() {
                        if (url.contains("/v1/token")) {
                          int count = stsCallCount.incrementAndGet();
                          GenericJson response = new GenericJson();
                          response.setFactory(OAuth2Utils.JSON_FACTORY);
                          response.put("access_token", "cached-sts-token-" + count);
                          response.put("token_type", "Bearer");
                          response.put("expires_in", 3600);
                          response.put(
                              "issued_token_type", "urn:ietf:params:oauth:token-type:access_token");
                          return new MockLowLevelHttpResponse()
                              .setContentType(Json.MEDIA_TYPE)
                              .setContent(response.toString());
                        } else if (url.contains(":generateAccessToken")) {
                          int count = iamCallCount.incrementAndGet();
                          iamBearerHeaders.add(getFirstHeaderValue("Authorization"));
                          GenericJson response = new GenericJson();
                          response.setFactory(OAuth2Utils.JSON_FACTORY);
                          response.put("accessToken", "final-iam-token-" + count);
                          response.put("expireTime", "2030-01-01T00:00:00Z");
                          return new MockLowLevelHttpResponse()
                              .setContentType(Json.MEDIA_TYPE)
                              .setContent(response.toString());
                        }
                        return new MockLowLevelHttpResponse().setStatusCode(404);
                      }
                    };
                  }
                };
          }
        };

    // Refresh 1 (ks1): mints STS token 1 and IAM token 1.
    AccessToken token1 = credential.refreshAccessToken();
    assertEquals("final-iam-token-1", token1.getTokenValue());
    assertEquals(1, stsCallCount.get());
    assertEquals(1, iamCallCount.get());

    // Refresh 2 (still ks1, STS token 1 still valid): MUST reuse cached STS token 1 without calling
    // STS again.
    AccessToken token2 = credential.refreshAccessToken();
    assertEquals("final-iam-token-2", token2.getTokenValue());
    assertEquals(1, stsCallCount.get());
    assertEquals(2, iamCallCount.get());
    assertEquals("Bearer cached-sts-token-1", iamBearerHeaders.get(0));
    assertEquals("Bearer cached-sts-token-1", iamBearerHeaders.get(1));

    // Refresh 3 (ks2 rotated): MUST invalidate cached STS token 1 and mint STS token 2.
    AccessToken token3 = credential.refreshAccessToken();
    assertEquals("final-iam-token-3", token3.getTokenValue());
    assertEquals(2, stsCallCount.get());
    assertEquals(3, iamCallCount.get());
    assertEquals("Bearer cached-sts-token-2", iamBearerHeaders.get(2));
  }

  @Test
  void refreshAccessToken_sslHandshakeExceptionFromTornRotation_retriesWhenKeyStoreChanges()
      throws Exception {
    // Torn KeyStore: cert2 + key1; Completed rotation KeyStore: cert2 + key2.
    byte[] cert2Bytes = Files.readAllBytes(Paths.get("testresources/mtls/test_cert_2.pem"));
    byte[] key1Bytes = Files.readAllBytes(Paths.get("testresources/mtls/test_key.pem"));
    byte[] key2Bytes = Files.readAllBytes(Paths.get("testresources/mtls/test_key_2.pem"));
    byte[] newline = "\n".getBytes(StandardCharsets.UTF_8);

    KeyStore tornKeyStore =
        SecurityUtils.createMtlsKeyStore(
            new ByteArrayInputStream(Bytes.concat(cert2Bytes, newline, key1Bytes)));
    KeyStore validRotatedKeyStore =
        SecurityUtils.createMtlsKeyStore(
            new ByteArrayInputStream(Bytes.concat(cert2Bytes, newline, key2Bytes)));

    AtomicInteger getKeyStoreCount = new AtomicInteger(0);
    X509Provider x509Provider =
        new X509Provider(null) {
          @Override
          public KeyStore getKeyStore() {
            return getKeyStoreCount.incrementAndGet() == 1 ? tornKeyStore : validRotatedKeyStore;
          }
        };

    AtomicInteger exchangeCount = new AtomicInteger(0);
    IdentityPoolCredentials credential =
        new IdentityPoolCredentials(
            IdentityPoolCredentials.newBuilder()
                .setSubjectTokenSupplier(testProvider)
                .setX509Provider(x509Provider)
                .setAudience("audience")
                .setSubjectTokenType("urn:ietf:params:oauth:token-type:id_token")
                .setTokenUrl("https://sts.mtls.googleapis.com/v1/token")) {
          @Override
          protected AccessToken exchangeExternalCredentialForAccessToken(
              StsTokenExchangeRequest stsTokenExchangeRequest,
              HttpTransportFactory cycleTransportFactory)
              throws IOException {
            if (exchangeCount.incrementAndGet() == 1) {
              throw new IOException(
                  "Error writing request body to server",
                  new SSLHandshakeException("Received fatal alert: decrypt_error"));
            }
            return new AccessToken("recovered-after-ssl-handshake-retry", null);
          }
        };

    AccessToken token = credential.refreshAccessToken();
    assertEquals("recovered-after-ssl-handshake-retry", token.getTokenValue());
    assertEquals(2, getKeyStoreCount.get());
    assertEquals(2, exchangeCount.get());
  }

  @Test
  void refreshAccessToken_initialKeyStoreLoadIOException_retriesOnceAndSucceeds() throws Exception {
    KeyStore validKeyStore = createPopulatedKeyStore();
    AtomicInteger getKeyStoreCount = new AtomicInteger(0);
    X509Provider x509Provider =
        new X509Provider(null) {
          @Override
          public KeyStore getKeyStore() throws IOException {
            if (getKeyStoreCount.incrementAndGet() == 1) {
              throw new IOException("X509Provider: Unexpected IOException: mid-write PEM");
            }
            return validKeyStore;
          }
        };

    IdentityPoolCredentials credential =
        new IdentityPoolCredentials(
            IdentityPoolCredentials.newBuilder()
                .setSubjectTokenSupplier(testProvider)
                .setX509Provider(x509Provider)
                .setAudience("audience")
                .setSubjectTokenType("urn:ietf:params:oauth:token-type:id_token")
                .setTokenUrl("https://sts.mtls.googleapis.com/v1/token")) {
          @Override
          protected AccessToken exchangeExternalCredentialForAccessToken(
              StsTokenExchangeRequest stsTokenExchangeRequest,
              HttpTransportFactory cycleTransportFactory) {
            return new AccessToken("recovered-after-initial-keystore-ioe", null);
          }
        };

    AccessToken token = credential.refreshAccessToken();
    assertEquals("recovered-after-initial-keystore-ioe", token.getTokenValue());
    assertEquals(2, getKeyStoreCount.get());
  }

  public static class SerializableCustomTransportFactory
      implements HttpTransportFactory, Serializable {
    private static final long serialVersionUID = 1L;

    public SerializableCustomTransportFactory() {}

    @Override
    public HttpTransport create() {
      return new MockHttpTransport();
    }
  }

  @Test
  void deserialization_respectsUseMtlsTransportFactoryFlag() throws Exception {
    Map<String, Object> certMap = new HashMap<>();
    certMap.put("certificate_config_location", "testresources/mtls/certificate_config.json");
    Map<String, Object> sourceMap = new HashMap<>();
    sourceMap.put("file", "credential.json");
    sourceMap.put("certificate", certMap);
    IdentityPoolCredentialSource credentialSource = new IdentityPoolCredentialSource(sourceMap);

    // Case 1: No custom HttpTransportFactory set -> useMtlsTransportFactory is true.
    // Build initializes MtlsHttpTransportFactory, and deserialization restores
    // MtlsHttpTransportFactory in readObject().
    IdentityPoolCredentials defaultMtlsCreds =
        IdentityPoolCredentials.newBuilder()
            .setCredentialSource(credentialSource)
            .setX509Provider(new TestX509Provider(createPopulatedKeyStore(), "test"))
            .setAudience("audience")
            .setSubjectTokenType("urn:ietf:params:oauth:token-type:id_token")
            .setTokenUrl("https://sts.mtls.googleapis.com/v1/token")
            .build();
    assertTrue(defaultMtlsCreds.shouldUseMtlsTransportFactory());
    assertTrue(defaultMtlsCreds.toBuilder().build().shouldUseMtlsTransportFactory());

    IdentityPoolCredentials deserializedDefault = serializeAndDeserialize(defaultMtlsCreds);
    assertTrue(deserializedDefault.shouldUseMtlsTransportFactory());
    assertTrue(deserializedDefault.getTransportFactory() instanceof MtlsHttpTransportFactory);
    assertTrue(
        ((MtlsHttpTransportFactory) deserializedDefault.getTransportFactory()).hasKeyStore());

    // Case 2: Custom HttpTransportFactory explicitly set -> useMtlsTransportFactory is false.
    // Deserialization must preserve SerializableCustomTransportFactory and NOT overwrite it with
    // MtlsHttpTransportFactory.
    IdentityPoolCredentials customTransportCreds =
        IdentityPoolCredentials.newBuilder()
            .setCredentialSource(credentialSource)
            .setX509Provider(new TestX509Provider(createPopulatedKeyStore(), "test"))
            .setHttpTransportFactory(new SerializableCustomTransportFactory())
            .setAudience("audience")
            .setSubjectTokenType("urn:ietf:params:oauth:token-type:id_token")
            .setTokenUrl("https://sts.mtls.googleapis.com/v1/token")
            .build();
    assertFalse(customTransportCreds.shouldUseMtlsTransportFactory());
    assertFalse(customTransportCreds.toBuilder().build().shouldUseMtlsTransportFactory());

    IdentityPoolCredentials deserializedCustom = serializeAndDeserialize(customTransportCreds);
    assertFalse(deserializedCustom.shouldUseMtlsTransportFactory());
    assertTrue(
        deserializedCustom.getTransportFactory() instanceof SerializableCustomTransportFactory);
  }

  @Test
  void refreshAccessToken_bareIoExceptionFromSplitWrite_retriesWhenKeyStoreChanges()
      throws Exception {
    // Against live sts.mtls.googleapis.com, a split write (cert2 + key1) fails during the TLS
    // handshake with a bare `new IOException("Error writing request body to server")` and an
    // empty cause chain (getCause() == null).
    byte[] cert2Bytes = Files.readAllBytes(Paths.get("testresources/mtls/test_cert_2.pem"));
    byte[] key1Bytes = Files.readAllBytes(Paths.get("testresources/mtls/test_key.pem"));
    byte[] key2Bytes = Files.readAllBytes(Paths.get("testresources/mtls/test_key_2.pem"));
    byte[] newline = "\n".getBytes(StandardCharsets.UTF_8);

    KeyStore splitWriteKeyStore =
        SecurityUtils.createMtlsKeyStore(
            new ByteArrayInputStream(Bytes.concat(cert2Bytes, newline, key1Bytes)));
    KeyStore completedRotationKeyStore =
        SecurityUtils.createMtlsKeyStore(
            new ByteArrayInputStream(Bytes.concat(cert2Bytes, newline, key2Bytes)));

    AtomicInteger getKeyStoreCount = new AtomicInteger(0);
    X509Provider x509Provider =
        new X509Provider(null) {
          @Override
          public KeyStore getKeyStore() {
            return getKeyStoreCount.incrementAndGet() == 1
                ? splitWriteKeyStore
                : completedRotationKeyStore;
          }
        };

    AtomicInteger exchangeCount = new AtomicInteger(0);
    IdentityPoolCredentials credential =
        new IdentityPoolCredentials(
            IdentityPoolCredentials.newBuilder()
                .setSubjectTokenSupplier(testProvider)
                .setX509Provider(x509Provider)
                .setAudience("audience")
                .setSubjectTokenType("urn:ietf:params:oauth:token-type:id_token")
                .setTokenUrl("https://sts.mtls.googleapis.com/v1/token")) {
          @Override
          protected AccessToken exchangeExternalCredentialForAccessToken(
              StsTokenExchangeRequest stsTokenExchangeRequest,
              HttpTransportFactory cycleTransportFactory)
              throws IOException {
            if (exchangeCount.incrementAndGet() == 1) {
              // Bare IOException with getCause() == null, matching HttpURLConnection behavior
              throw new IOException("Error writing request body to server");
            }
            return new AccessToken("recovered-after-bare-io-exception", null);
          }
        };

    AccessToken token = credential.refreshAccessToken();
    assertEquals("recovered-after-bare-io-exception", token.getTokenValue());
    assertEquals(2, getKeyStoreCount.get());
    assertEquals(2, exchangeCount.get());
  }

  @Test
  void
      standaloneImpersonatedCredentials_wrappingMtlsIdentityPoolCredentials_usesMtlsAndRetriesOnRotation()
          throws Exception {
    KeyStore ks1 = createPopulatedKeyStore();
    KeyStore ks2 = createRotatedPopulatedKeyStore();

    AtomicInteger getKeyStoreCount = new AtomicInteger(0);
    X509Provider rotatingProvider =
        new X509Provider(null) {
          @Override
          public KeyStore getKeyStore() {
            int count = getKeyStoreCount.incrementAndGet();
            return count == 1 ? ks1 : ks2;
          }
        };

    AtomicInteger stsCallCount = new AtomicInteger(0);
    AtomicInteger iamCallCount = new AtomicInteger(0);
    List<KeyStore> capturedKeyStores = new ArrayList<>();

    IdentityPoolCredentials sourceCredentials =
        new IdentityPoolCredentials(
            IdentityPoolCredentials.newBuilder()
                .setSubjectTokenSupplier(testProvider)
                .setX509Provider(rotatingProvider)
                .setScopes(Collections.singletonList(OAuth2Utils.CLOUD_PLATFORM_SCOPE))
                .setAudience("audience")
                .setSubjectTokenType("urn:ietf:params:oauth:token-type:id_token")
                .setTokenUrl("https://sts.mtls.googleapis.com/v1/token")) {
          @Override
          HttpTransportFactory createMtlsTransportFactory(KeyStore keyStore) {
            capturedKeyStores.add(keyStore);
            return () ->
                new MockHttpTransport() {
                  @Override
                  public LowLevelHttpRequest buildRequest(String method, String url) {
                    return new MockLowLevelHttpRequest(url) {
                      @Override
                      public LowLevelHttpResponse execute() throws IOException {
                        if (url.contains("sts.mtls.googleapis.com")) {
                          int count = stsCallCount.incrementAndGet();
                          if (keyStore == ks1) {
                            // Simulate split write bare IOException on ks1
                            throw new IOException("Error writing request body to server");
                          }
                          GenericJson response = new GenericJson();
                          response.setFactory(OAuth2Utils.JSON_FACTORY);
                          response.put("access_token", "standalone-sts-token-" + count);
                          response.put(
                              "issued_token_type", "urn:ietf:params:oauth:token-type:access_token");
                          response.put("token_type", "Bearer");
                          response.put("expires_in", 3600);
                          return new MockLowLevelHttpResponse()
                              .setContentType(Json.MEDIA_TYPE)
                              .setContent(response.toString());
                        } else if (url.contains("iamcredentials")) {
                          int count = iamCallCount.incrementAndGet();
                          GenericJson response = new GenericJson();
                          response.setFactory(OAuth2Utils.JSON_FACTORY);
                          response.put("accessToken", "standalone-iam-token-" + count);
                          response.put("expireTime", "2030-01-01T00:00:00Z");
                          return new MockLowLevelHttpResponse()
                              .setContentType(Json.MEDIA_TYPE)
                              .setContent(response.toString());
                        }
                        return new MockLowLevelHttpResponse().setStatusCode(404);
                      }
                    };
                  }
                };
          }
        };

    // Build standalone ImpersonatedCredentials directly without setting HttpTransportFactory.
    ImpersonatedCredentials standaloneImpersonated =
        ImpersonatedCredentials.newBuilder()
            .setSourceCredentials(sourceCredentials)
            .setTargetPrincipal("sa@project.iam.gserviceaccount.com")
            .setScopes(Collections.singletonList(OAuth2Utils.CLOUD_PLATFORM_SCOPE))
            .build();

    // Refresh 1: ks1 throws bare IOException -> retries once with ks2 -> both STS and IAM succeed
    // over the pinned mTLS transport.
    AccessToken token1 = standaloneImpersonated.refreshAccessToken();
    assertEquals("standalone-iam-token-1", token1.getTokenValue());
    assertEquals(2, stsCallCount.get());
    assertEquals(1, iamCallCount.get());
    assertEquals(Arrays.asList(ks1, ks2), capturedKeyStores);

    // Refresh 2 (still ks2): reuses the cached 1-hour STS token without calling STS again!
    AccessToken token2 = standaloneImpersonated.refreshAccessToken();
    assertEquals("standalone-iam-token-2", token2.getTokenValue());
    assertEquals(2, stsCallCount.get());
    assertEquals(2, iamCallCount.get());
  }

  @Test
  void refreshAccessToken_bareIoException_doesNotRetryWhenKeyStoreUnchanged() throws Exception {
    KeyStore ks1 = createPopulatedKeyStore();
    KeyStore ks1Same = createPopulatedKeyStore();
    AtomicInteger getKeyStoreCount = new AtomicInteger(0);
    X509Provider provider =
        new X509Provider(null) {
          @Override
          public KeyStore getKeyStore() {
            return getKeyStoreCount.incrementAndGet() == 1 ? ks1 : ks1Same;
          }
        };

    AtomicInteger exchangeCount = new AtomicInteger(0);
    IdentityPoolCredentials credential =
        new IdentityPoolCredentials(
            IdentityPoolCredentials.newBuilder()
                .setSubjectTokenSupplier(testProvider)
                .setX509Provider(provider)
                .setAudience("audience")
                .setSubjectTokenType("urn:ietf:params:oauth:token-type:id_token")
                .setTokenUrl("https://sts.mtls.googleapis.com/v1/token")) {
          @Override
          protected AccessToken exchangeExternalCredentialForAccessToken(
              StsTokenExchangeRequest stsTokenExchangeRequest,
              HttpTransportFactory cycleTransportFactory)
              throws IOException {
            exchangeCount.incrementAndGet();
            throw new IOException("Error writing request body to server");
          }
        };

    IOException thrown = assertThrows(IOException.class, credential::refreshAccessToken);
    assertEquals("Error writing request body to server", thrown.getMessage());
    assertEquals(2, getKeyStoreCount.get());
    assertEquals(1, exchangeCount.get());
  }

  @Test
  void refreshAccessToken_non401OAuthException_doesNotRetryEvenWhenKeyStoreChanges()
      throws Exception {
    KeyStore ks1 = createPopulatedKeyStore();
    KeyStore ks2 = createRotatedPopulatedKeyStore();
    AtomicInteger getKeyStoreCount = new AtomicInteger(0);
    X509Provider rotatingProvider =
        new X509Provider(null) {
          @Override
          public KeyStore getKeyStore() {
            return getKeyStoreCount.incrementAndGet() == 1 ? ks1 : ks2;
          }
        };

    AtomicInteger exchangeCount = new AtomicInteger(0);
    IdentityPoolCredentials credential =
        new IdentityPoolCredentials(
            IdentityPoolCredentials.newBuilder()
                .setSubjectTokenSupplier(testProvider)
                .setX509Provider(rotatingProvider)
                .setAudience("audience")
                .setSubjectTokenType("urn:ietf:params:oauth:token-type:id_token")
                .setTokenUrl("https://sts.mtls.googleapis.com/v1/token")) {
          @Override
          protected AccessToken exchangeExternalCredentialForAccessToken(
              StsTokenExchangeRequest stsTokenExchangeRequest,
              HttpTransportFactory cycleTransportFactory)
              throws IOException {
            exchangeCount.incrementAndGet();
            throw new OAuthException("invalid_request", "Bad Request", null, 400);
          }
        };

    OAuthException thrown = assertThrows(OAuthException.class, credential::refreshAccessToken);
    assertEquals(400, thrown.getHttpStatusCode());
    assertEquals(1, getKeyStoreCount.get());
    assertEquals(1, exchangeCount.get());
  }

  @Test
  void
      standaloneImpersonatedCredentials_withFileCertConfig_survivesDeserializationAndAddsCloudPlatformScope()
          throws Exception {
    Map<String, Object> certMap = new HashMap<>();
    certMap.put("certificate_config_location", "testresources/mtls/certificate_config.json");
    Map<String, Object> sourceMap = new HashMap<>();
    sourceMap.put("file", "credential.json");
    sourceMap.put("certificate", certMap);
    IdentityPoolCredentialSource credentialSource = new IdentityPoolCredentialSource(sourceMap);

    // Build IdentityPoolCredentials with a custom scope (missing cloud-platform) and file cert
    // config.
    IdentityPoolCredentials sourceCredentials =
        IdentityPoolCredentials.newBuilder()
            .setCredentialSource(credentialSource)
            .setScopes(Collections.singletonList("https://www.googleapis.com/auth/CustomScope"))
            .setAudience("audience")
            .setSubjectTokenType("urn:ietf:params:oauth:token-type:id_token")
            .setTokenUrl("https://sts.mtls.googleapis.com/v1/token")
            .build();
    assertTrue(sourceCredentials.getTransportFactory() instanceof MtlsHttpTransportFactory);
    assertTrue(((MtlsHttpTransportFactory) sourceCredentials.getTransportFactory()).hasKeyStore());

    // Build standalone ImpersonatedCredentials without setting HttpTransportFactory.
    ImpersonatedCredentials standaloneImpersonated =
        ImpersonatedCredentials.newBuilder()
            .setSourceCredentials(sourceCredentials)
            .setTargetPrincipal("sa@project.iam.gserviceaccount.com")
            .setScopes(Collections.singletonList(OAuth2Utils.CLOUD_PLATFORM_SCOPE))
            .build();

    // Verify standaloneImpersonated inherited the populated MtlsHttpTransportFactory at build time
    assertTrue(
        standaloneImpersonated.toBuilder().getHttpTransportFactory()
            instanceof MtlsHttpTransportFactory);
    assertTrue(
        ((MtlsHttpTransportFactory) standaloneImpersonated.toBuilder().getHttpTransportFactory())
            .hasKeyStore());

    // Serialize and deserialize standaloneImpersonated and verify readObject() restores the
    // populated MtlsHttpTransportFactory from sourceCredentials.
    ImpersonatedCredentials deserializedImpersonated =
        serializeAndDeserialize(standaloneImpersonated);
    assertTrue(
        deserializedImpersonated.toBuilder().getHttpTransportFactory()
            instanceof MtlsHttpTransportFactory);
    assertTrue(
        ((MtlsHttpTransportFactory) deserializedImpersonated.toBuilder().getHttpTransportFactory())
            .hasKeyStore());

    // refreshAccessToken() adds cloud-platform to the source scopes before refreshing. The
    // refresh itself then fails because the subject token file does not exist.
    assertThrows(IOException.class, deserializedImpersonated::refreshAccessToken);
    Collection<String> sourceScopes =
        ((IdentityPoolCredentials) deserializedImpersonated.getSourceCredentials()).getScopes();
    assertTrue(sourceScopes.contains(OAuth2Utils.CLOUD_PLATFORM_SCOPE));
    assertTrue(sourceScopes.contains("https://www.googleapis.com/auth/CustomScope"));
  }

  @Test
  void
      refreshAccessToken_invalidGrantFromTrustChainRotatedAheadOfLeafCert_retriesWhenKeyStoreChanges()
          throws Exception {
    byte[] cert1Bytes = Files.readAllBytes(Paths.get("testresources/mtls/test_cert.pem"));
    byte[] cert2Bytes = Files.readAllBytes(Paths.get("testresources/mtls/test_cert_2.pem"));
    byte[] key1Bytes = Files.readAllBytes(Paths.get("testresources/mtls/test_key.pem"));
    byte[] key2Bytes = Files.readAllBytes(Paths.get("testresources/mtls/test_key_2.pem"));
    byte[] newline = "\n".getBytes(StandardCharsets.UTF_8);

    // trust_chain_path has already rotated, but cert_path and key_path still hold the old leaf
    // (cert1 + key1). The TLS handshake succeeds, but STS rejects the old leaf with invalid_grant
    // because it no longer chains to the rotated trust chain.
    KeyStore oldLeafKeyStore =
        SecurityUtils.createMtlsKeyStore(
            new ByteArrayInputStream(Bytes.concat(cert1Bytes, newline, key1Bytes)));
    // cert_path and key_path have caught up to the new leaf (cert2 + key2).
    KeyStore newLeafKeyStore =
        SecurityUtils.createMtlsKeyStore(
            new ByteArrayInputStream(Bytes.concat(cert2Bytes, newline, key2Bytes)));

    AtomicInteger getKeyStoreCount = new AtomicInteger(0);
    X509Provider rotatingProvider =
        new X509Provider(null) {
          @Override
          public KeyStore getKeyStore() {
            return getKeyStoreCount.incrementAndGet() == 1 ? oldLeafKeyStore : newLeafKeyStore;
          }
        };

    AtomicInteger exchangeCount = new AtomicInteger(0);
    IdentityPoolCredentials credential =
        new IdentityPoolCredentials(
            IdentityPoolCredentials.newBuilder()
                .setSubjectTokenSupplier(testProvider)
                .setX509Provider(rotatingProvider)
                .setAudience("audience")
                .setSubjectTokenType("urn:ietf:params:oauth:token-type:mtls")
                .setTokenUrl("https://sts.mtls.googleapis.com/v1/token")) {
          @Override
          protected AccessToken exchangeExternalCredentialForAccessToken(
              StsTokenExchangeRequest stsTokenExchangeRequest,
              HttpTransportFactory cycleTransportFactory)
              throws IOException {
            if (exchangeCount.incrementAndGet() == 1) {
              throw new OAuthException(
                  "invalid_grant",
                  "The client certificate does not chain to the configured trust chain.",
                  null,
                  400);
            }
            return new AccessToken("recovered-after-invalid-grant-retry", null);
          }
        };

    AccessToken token = credential.refreshAccessToken();
    assertEquals("recovered-after-invalid-grant-retry", token.getTokenValue());
    assertEquals(2, getKeyStoreCount.get());
    assertEquals(2, exchangeCount.get());
  }

  @Test
  void refreshAccessToken_invalidGrant_doesNotRetryWhenKeyStoreUnchanged() throws Exception {
    KeyStore ks1 = createPopulatedKeyStore();
    KeyStore ks1Same = createPopulatedKeyStore();
    AtomicInteger getKeyStoreCount = new AtomicInteger(0);
    X509Provider unchangedProvider =
        new X509Provider(null) {
          @Override
          public KeyStore getKeyStore() {
            return getKeyStoreCount.incrementAndGet() == 1 ? ks1 : ks1Same;
          }
        };

    AtomicInteger exchangeCount = new AtomicInteger(0);
    IdentityPoolCredentials credential =
        new IdentityPoolCredentials(
            IdentityPoolCredentials.newBuilder()
                .setSubjectTokenSupplier(testProvider)
                .setX509Provider(unchangedProvider)
                .setAudience("audience")
                .setSubjectTokenType("urn:ietf:params:oauth:token-type:mtls")
                .setTokenUrl("https://sts.mtls.googleapis.com/v1/token")) {
          @Override
          protected AccessToken exchangeExternalCredentialForAccessToken(
              StsTokenExchangeRequest stsTokenExchangeRequest,
              HttpTransportFactory cycleTransportFactory)
              throws IOException {
            exchangeCount.incrementAndGet();
            throw new OAuthException("invalid_grant", "Invalid subject token", null, 400);
          }
        };

    OAuthException thrown = assertThrows(OAuthException.class, credential::refreshAccessToken);
    assertEquals("invalid_grant", thrown.getErrorCode());
    assertEquals(2, getKeyStoreCount.get());
    assertEquals(1, exchangeCount.get());
  }

  @Test
  void
      refreshAccessToken_impersonation_401OnIamWithCachedStsToken_retriesAndMintsFreshStsTokenEvenWhenCertUnchanged()
          throws Exception {
    KeyStore ks1 = createPopulatedKeyStore();
    AtomicInteger getKeyStoreCallCount = new AtomicInteger(0);
    X509Provider unchangedProvider =
        new X509Provider(null) {
          @Override
          public KeyStore getKeyStore() {
            getKeyStoreCallCount.incrementAndGet();
            return ks1;
          }
        };

    AtomicInteger stsCallCount = new AtomicInteger(0);
    AtomicInteger iamCallCount = new AtomicInteger(0);
    List<String> iamBearerHeaders = new ArrayList<>();

    IdentityPoolCredentials credential =
        new IdentityPoolCredentials(
            IdentityPoolCredentials.newBuilder()
                .setSubjectTokenSupplier(testProvider)
                .setX509Provider(unchangedProvider)
                .setAudience(
                    "//iam.googleapis.com/projects/123/locations/global/workloadIdentityPools/pool/providers/provider")
                .setSubjectTokenType("urn:ietf:params:oauth:token-type:id_token")
                .setTokenUrl("https://sts.mtls.googleapis.com/v1/token")
                .setServiceAccountImpersonationUrl(
                    "https://iamcredentials.googleapis.com/v1/projects/-/serviceAccounts/test@project.iam.gserviceaccount.com:generateAccessToken")) {
          @Override
          HttpTransportFactory createMtlsTransportFactory(KeyStore keyStore) {
            return () ->
                new MockHttpTransport() {
                  @Override
                  public LowLevelHttpRequest buildRequest(String method, String url) {
                    return new MockLowLevelHttpRequest(url) {
                      @Override
                      public LowLevelHttpResponse execute() {
                        if (url.contains("/v1/token")) {
                          int count = stsCallCount.incrementAndGet();
                          GenericJson response = new GenericJson();
                          response.setFactory(OAuth2Utils.JSON_FACTORY);
                          response.put("access_token", "cached-sts-token-" + count);
                          response.put("token_type", "Bearer");
                          response.put("expires_in", 3600);
                          response.put(
                              "issued_token_type", "urn:ietf:params:oauth:token-type:access_token");
                          return new MockLowLevelHttpResponse()
                              .setContentType(Json.MEDIA_TYPE)
                              .setContent(response.toString());
                        } else if (url.contains(":generateAccessToken")) {
                          int count = iamCallCount.incrementAndGet();
                          iamBearerHeaders.add(getFirstHeaderValue("Authorization"));
                          if (count == 2) {
                            // On the 2nd IAM call (which reuses cached-sts-token-1), IAM returns
                            // 401 Unauthorized even though the cert on disk has NOT changed.
                            return new MockLowLevelHttpResponse()
                                .setStatusCode(401)
                                .setContentType(Json.MEDIA_TYPE)
                                .setContent(
                                    "{\"error\":{\"code\":401,\"status\":\"UNAUTHENTICATED\"}}");
                          }
                          GenericJson response = new GenericJson();
                          response.setFactory(OAuth2Utils.JSON_FACTORY);
                          response.put("accessToken", "final-iam-token-" + count);
                          response.put("expireTime", "2030-01-01T00:00:00Z");
                          return new MockLowLevelHttpResponse()
                              .setContentType(Json.MEDIA_TYPE)
                              .setContent(response.toString());
                        }
                        return new MockLowLevelHttpResponse().setStatusCode(404);
                      }
                    };
                  }
                };
          }
        };

    // Refresh 1: mints cached-sts-token-1 and final-iam-token-1.
    AccessToken token1 = credential.refreshAccessToken();
    assertEquals("final-iam-token-1", token1.getTokenValue());
    assertEquals(1, stsCallCount.get());
    assertEquals(1, iamCallCount.get());
    assertEquals(1, getKeyStoreCallCount.get());

    // Refresh 2: reuses cached-sts-token-1 -> IAM returns 401 -> clears cachedStsAccessToken and
    // retries once even though ks1 is unchanged -> mints cached-sts-token-2 -> IAM succeeds!
    AccessToken token2 = credential.refreshAccessToken();
    assertEquals("final-iam-token-3", token2.getTokenValue());
    assertEquals(2, stsCallCount.get());
    assertEquals(3, iamCallCount.get());
    // Cumulative: refresh 2 adds one KeyStore pin for the initial attempt and one reload for the
    // retry.
    assertEquals(3, getKeyStoreCallCount.get());
    assertEquals(
        Arrays.asList(
            "Bearer cached-sts-token-1", "Bearer cached-sts-token-1", "Bearer cached-sts-token-2"),
        iamBearerHeaders);
  }

  @Test
  void refreshAccessToken_firstImpersonatedRefresh_readsKeyStoreOnlyOncePerRefreshCycle()
      throws Exception {
    Map<String, Object> certificateMap = new HashMap<>();
    certificateMap.put("use_default_certificate_config", false);
    certificateMap.put("certificate_config_location", "testresources/mtls/certificate_config.json");
    Map<String, Object> credentialSourceMap = new HashMap<>();
    credentialSourceMap.put("certificate", certificateMap);
    IdentityPoolCredentialSource credentialSource =
        new IdentityPoolCredentialSource(credentialSourceMap);

    KeyStore ks1 = createPopulatedKeyStore();
    AtomicInteger getKeyStoreCallCount = new AtomicInteger(0);
    X509Provider singleReadPerRefreshProvider =
        new X509Provider(null) {
          @Override
          public KeyStore getKeyStore() throws IOException {
            int call = getKeyStoreCallCount.incrementAndGet();
            if (call > 1) {
              throw new IOException(
                  "Unexpected extra getKeyStore() call #" + call + " during first refresh");
            }
            return ks1;
          }
        };

    AtomicInteger createMtlsTransportFactoryCount = new AtomicInteger(0);
    IdentityPoolCredentials credential =
        new IdentityPoolCredentials(
            IdentityPoolCredentials.newBuilder()
                .setCredentialSource(credentialSource)
                .setX509Provider(singleReadPerRefreshProvider)
                .setAudience("audience")
                .setSubjectTokenType("urn:ietf:params:oauth:token-type:mtls")
                .setTokenUrl("https://sts.mtls.googleapis.com/v1/token")
                .setServiceAccountImpersonationUrl(
                    "https://iamcredentials.googleapis.com/v1/projects/-/serviceAccounts/test@project.iam.gserviceaccount.com:generateAccessToken")) {
          @Override
          HttpTransportFactory createMtlsTransportFactory(KeyStore keyStore) {
            if (createMtlsTransportFactoryCount.incrementAndGet() == 1) {
              // Build time: store a KeyStore-backed MtlsHttpTransportFactory.
              return super.createMtlsTransportFactory(keyStore);
            }
            return () ->
                new MockHttpTransport() {
                  @Override
                  public LowLevelHttpRequest buildRequest(String method, String url) {
                    return new MockLowLevelHttpRequest(url) {
                      @Override
                      public LowLevelHttpResponse execute() {
                        if (url.contains("/v1/token")) {
                          GenericJson response = new GenericJson();
                          response.setFactory(OAuth2Utils.JSON_FACTORY);
                          response.put("access_token", "sts-token-1");
                          response.put("token_type", "Bearer");
                          response.put("expires_in", 3600);
                          response.put(
                              "issued_token_type", "urn:ietf:params:oauth:token-type:access_token");
                          return new MockLowLevelHttpResponse()
                              .setContentType(Json.MEDIA_TYPE)
                              .setContent(response.toString());
                        } else if (url.contains(":generateAccessToken")) {
                          GenericJson response = new GenericJson();
                          response.setFactory(OAuth2Utils.JSON_FACTORY);
                          response.put("accessToken", "iam-token-1");
                          response.put("expireTime", "2030-01-01T00:00:00Z");
                          return new MockLowLevelHttpResponse()
                              .setContentType(Json.MEDIA_TYPE)
                              .setContent(response.toString());
                        }
                        return new MockLowLevelHttpResponse().setStatusCode(404);
                      }
                    };
                  }
                };
          }
        };

    assertTrue(credential.getTransportFactory() instanceof MtlsHttpTransportFactory);
    assertTrue(((MtlsHttpTransportFactory) credential.getTransportFactory()).hasKeyStore());
    // Only count KeyStore reads made during the refresh cycle.
    getKeyStoreCallCount.set(0);

    // The first impersonated refresh calls getImpersonatedCredentials() ->
    // buildImpersonatedCredentials(), which copies the source via
    // IdentityPoolCredentials.newBuilder(this) and sets the cloud-platform scope directly.
    // This must not call getKeyStore() a second time.
    AccessToken token = credential.refreshAccessToken();
    assertEquals("iam-token-1", token.getTokenValue());
    assertEquals(1, getKeyStoreCallCount.get());
  }

  @Test
  void standaloneImpersonatedCredentials_401OnIamWithCachedStsToken_retriesAndMintsFreshStsToken()
      throws Exception {
    AtomicInteger stsCallCount = new AtomicInteger(0);
    AtomicInteger iamCallCount = new AtomicInteger(0);
    List<String> iamBearerHeaders = Collections.synchronizedList(new ArrayList<>());
    // Only the 2nd IAM call (which reuses cached sts-token-1) returns 401.
    HttpTransportFactory transportFactory =
        createStsAndIamTransportFactory(
            stsCallCount, iamCallCount, iamBearerHeaders, iamCall -> iamCall == 2);
    ImpersonatedCredentials impersonated =
        createStandaloneImpersonatedCredentials(transportFactory);

    AccessToken token1 = impersonated.refreshAccessToken();
    assertEquals("iam-token-1", token1.getTokenValue());

    AccessToken token2 = impersonated.refreshAccessToken();
    assertEquals("iam-token-3", token2.getTokenValue());
    assertEquals(2, stsCallCount.get());
    assertEquals(3, iamCallCount.get());
    assertEquals(
        Arrays.asList("Bearer sts-token-1", "Bearer sts-token-1", "Bearer sts-token-2"),
        iamBearerHeaders);
  }

  @Test
  void
      standaloneImpersonatedCredentials_second401OnRetryAfterCachedStsTokenRejected_throwsWithSuppressed()
          throws Exception {
    AtomicInteger stsCallCount = new AtomicInteger(0);
    AtomicInteger iamCallCount = new AtomicInteger(0);
    List<String> iamBearerHeaders = Collections.synchronizedList(new ArrayList<>());
    // Every IAM call after the first returns 401, including the retry with a fresh STS token.
    HttpTransportFactory transportFactory =
        createStsAndIamTransportFactory(
            stsCallCount, iamCallCount, iamBearerHeaders, iamCall -> iamCall >= 2);
    ImpersonatedCredentials impersonated =
        createStandaloneImpersonatedCredentials(transportFactory);

    impersonated.refreshAccessToken();

    IOException thrown = assertThrows(IOException.class, impersonated::refreshAccessToken);
    assertFalse(thrown instanceof ImpersonatedCredentials.CachedStsTokenRejectedException);
    assertTrue(OAuth2Utils.isUnauthorizedException(thrown));
    assertEquals(1, thrown.getSuppressed().length);
    assertTrue(
        thrown.getSuppressed()[0]
            instanceof ImpersonatedCredentials.CachedStsTokenRejectedException);
    // Exactly one retry: the rejected cached token is not reused and no further retry happens.
    assertEquals(2, stsCallCount.get());
    assertEquals(3, iamCallCount.get());
    assertEquals(
        Arrays.asList("Bearer sts-token-1", "Bearer sts-token-1", "Bearer sts-token-2"),
        iamBearerHeaders);
  }

  @Test
  void standaloneImpersonatedCredentials_cachedStsTokenWithinExpirationMargin_mintsFreshStsToken()
      throws Exception {
    AtomicInteger stsCallCount = new AtomicInteger(0);
    AtomicInteger iamCallCount = new AtomicInteger(0);
    List<String> iamBearerHeaders = new ArrayList<>();
    HttpTransportFactory mockTransportFactory =
        createStsAndIamTransportFactory(
            stsCallCount, iamCallCount, iamBearerHeaders, iamCall -> false);
    ImpersonatedCredentials impersonated =
        createStandaloneImpersonatedCredentials(mockTransportFactory);
    IdentityPoolCredentials source = (IdentityPoolCredentials) impersonated.getSourceCredentials();

    // The first refresh mints and caches sts-token-1, which expires in 3600 seconds. The second
    // refresh reuses it because it is still outside the expiration margin.
    assertEquals("iam-token-1", impersonated.refreshAccessToken().getTokenValue());
    assertEquals("iam-token-2", impersonated.refreshAccessToken().getTokenValue());
    assertEquals(1, stsCallCount.get());

    // Move the source's clock to 60 seconds before sts-token-1 expires, inside the default
    // 3-minute expiration margin.
    TestClock clock = new TestClock();
    clock.setCurrentTime(System.currentTimeMillis() + TimeUnit.SECONDS.toMillis(3600 - 60));
    source.clock = clock;

    // The expiring cached token is not reused, so this refresh mints sts-token-2.
    assertEquals("iam-token-3", impersonated.refreshAccessToken().getTokenValue());
    assertEquals(2, stsCallCount.get());
    assertEquals(
        Arrays.asList("Bearer sts-token-1", "Bearer sts-token-1", "Bearer sts-token-2"),
        iamBearerHeaders);
  }

  @Test
  void refreshAccessToken_concurrentRefreshReusingRejectedCachedStsToken_doesNotRecacheIt()
      throws Exception {
    AtomicInteger stsCallCount = new AtomicInteger(0);
    AtomicInteger iamCallCount = new AtomicInteger(0);
    List<String> iamBearerHeaders = Collections.synchronizedList(new ArrayList<>());
    AtomicReference<IdentityPoolCredentials> credentialRef = new AtomicReference<>();
    ExecutorService executor = Executors.newSingleThreadExecutor();
    try {
      HttpTransportFactory mockTransportFactory =
          createStsAndIamTransportFactory(
              stsCallCount,
              iamCallCount,
              iamBearerHeaders,
              iamCall -> {
                if (iamCall == 2) {
                  // Refresh A is using cached sts-token-1. Before its IAM call completes, refresh B
                  // on another thread also reuses sts-token-1, gets a 401 that clears the cache,
                  // and fails its retry with another 401.
                  Future<?> refreshB =
                      executor.submit(
                          () ->
                              assertThrows(
                                  IOException.class,
                                  () -> credentialRef.get().refreshAccessToken()));
                  refreshB.get(10, TimeUnit.SECONDS);
                  return false;
                }
                return iamCall == 3 || iamCall == 4;
              });
      IdentityPoolCredentials credential =
          new IdentityPoolCredentials(
              IdentityPoolCredentials.newBuilder()
                  .setSubjectTokenSupplier(testProvider)
                  .setX509Provider(new TestX509Provider(createPopulatedKeyStore(), "test"))
                  .setAudience(
                      "//iam.googleapis.com/projects/123/locations/global/workloadIdentityPools/pool/providers/provider")
                  .setSubjectTokenType("urn:ietf:params:oauth:token-type:id_token")
                  .setTokenUrl("https://sts.mtls.googleapis.com/v1/token")
                  .setServiceAccountImpersonationUrl(
                      "https://iamcredentials.googleapis.com/v1/projects/-/serviceAccounts/test@project.iam.gserviceaccount.com:generateAccessToken")) {
            @Override
            HttpTransportFactory createMtlsTransportFactory(KeyStore keyStore) {
              return mockTransportFactory;
            }
          };
      credentialRef.set(credential);

      // Initial refresh mints and caches sts-token-1.
      assertEquals("iam-token-1", credential.refreshAccessToken().getTokenValue());

      // Refresh A reuses sts-token-1 and succeeds after refresh B has rejected it.
      assertEquals("iam-token-2", credential.refreshAccessToken().getTokenValue());
      assertEquals(2, stsCallCount.get());
      assertEquals(4, iamCallCount.get());

      // Refresh A must not have re-cached the rejected sts-token-1, so this refresh mints a new
      // STS token.
      assertEquals("iam-token-5", credential.refreshAccessToken().getTokenValue());
      assertEquals(3, stsCallCount.get());
      assertEquals(
          Arrays.asList(
              "Bearer sts-token-1",
              "Bearer sts-token-1",
              "Bearer sts-token-1",
              "Bearer sts-token-2",
              "Bearer sts-token-3"),
          iamBearerHeaders);
    } finally {
      executor.shutdownNow();
    }
  }

  @Test
  void refreshAccessToken_iamFailureWithFreshStsToken_doesNotClearConcurrentlyCachedStsToken()
      throws Exception {
    AtomicInteger stsCallCount = new AtomicInteger(0);
    AtomicInteger iamCallCount = new AtomicInteger(0);
    List<String> iamBearerHeaders = Collections.synchronizedList(new ArrayList<>());
    AtomicReference<IdentityPoolCredentials> credentialRef = new AtomicReference<>();
    ExecutorService executor = Executors.newSingleThreadExecutor();
    try {
      HttpTransportFactory mockTransportFactory =
          createStsAndIamTransportFactory(
              stsCallCount,
              iamCallCount,
              iamBearerHeaders,
              iamCall -> {
                if (iamCall == 1) {
                  // Refresh A has freshly minted sts-token-1. Before its IAM call completes,
                  // refresh B on another thread mints sts-token-2, succeeds, and caches it.
                  Future<AccessToken> refreshB =
                      executor.submit(() -> credentialRef.get().refreshAccessToken());
                  assertEquals("iam-token-2", refreshB.get(10, TimeUnit.SECONDS).getTokenValue());
                  // Refresh A's IAM call then fails with a non-401 error.
                  throw new IOException("IAM unavailable");
                }
                return false;
              });
      IdentityPoolCredentials credential =
          new IdentityPoolCredentials(
              IdentityPoolCredentials.newBuilder()
                  .setSubjectTokenSupplier(testProvider)
                  .setX509Provider(new TestX509Provider(createPopulatedKeyStore(), "test"))
                  .setAudience(
                      "//iam.googleapis.com/projects/123/locations/global/workloadIdentityPools/pool/providers/provider")
                  .setSubjectTokenType("urn:ietf:params:oauth:token-type:id_token")
                  .setTokenUrl("https://sts.mtls.googleapis.com/v1/token")
                  .setServiceAccountImpersonationUrl(
                      "https://iamcredentials.googleapis.com/v1/projects/-/serviceAccounts/test@project.iam.gserviceaccount.com:generateAccessToken")) {
            @Override
            HttpTransportFactory createMtlsTransportFactory(KeyStore keyStore) {
              return mockTransportFactory;
            }
          };
      credentialRef.set(credential);

      // Refresh A fails on IAM after refresh B has cached sts-token-2.
      assertThrows(IOException.class, credential::refreshAccessToken);
      assertEquals(2, stsCallCount.get());

      // Refresh A must not have cleared sts-token-2, so this refresh reuses it without minting.
      assertEquals("iam-token-3", credential.refreshAccessToken().getTokenValue());
      assertEquals(2, stsCallCount.get());
      assertEquals(
          Arrays.asList("Bearer sts-token-1", "Bearer sts-token-2", "Bearer sts-token-2"),
          iamBearerHeaders);
    } finally {
      executor.shutdownNow();
    }
  }

  @Test
  void refreshAccessToken_withCycleTransportFactory_upgradesKeylessMtlsTransportFactory()
      throws Exception {
    AtomicInteger stsCallCount = new AtomicInteger(0);
    AtomicInteger iamCallCount = new AtomicInteger(0);
    HttpTransportFactory cycleTransportFactory =
        createStsAndIamTransportFactory(
            stsCallCount, iamCallCount, new ArrayList<>(), iamCall -> false);
    IdentityPoolCredentials sourceCredentials =
        IdentityPoolCredentials.newBuilder()
            .setSubjectTokenSupplier(testProvider)
            .setX509Provider(new TestX509Provider(createPopulatedKeyStore(), "test"))
            .setAudience(
                "//iam.googleapis.com/projects/123/locations/global/workloadIdentityPools/pool/providers/provider")
            .setSubjectTokenType("urn:ietf:params:oauth:token-type:id_token")
            .setTokenUrl("https://sts.mtls.googleapis.com/v1/token")
            .build();
    // A keyless MtlsHttpTransportFactory is the state readObject() leaves behind when it defers
    // the certificate load.
    ImpersonatedCredentials impersonated =
        ImpersonatedCredentials.newBuilder()
            .setSourceCredentials(sourceCredentials)
            .setHttpTransportFactory(new MtlsHttpTransportFactory())
            .setTargetPrincipal("test@project.iam.gserviceaccount.com")
            .setScopes(Collections.singletonList(OAuth2Utils.CLOUD_PLATFORM_SCOPE))
            .build();

    impersonated.refreshAccessToken(cycleTransportFactory, createPopulatedKeyStore());

    // The pinned factory replaces the keyless one so sign() and idTokenWithAudience() use mTLS.
    assertSame(cycleTransportFactory, impersonated.toBuilder().getHttpTransportFactory());
  }

  @Test
  void refreshAccessToken_sourceWithUnscopedAccessToken_mintsCloudPlatformScopedStsToken()
      throws Exception {
    AtomicInteger stsCallCount = new AtomicInteger(0);
    AtomicInteger iamCallCount = new AtomicInteger(0);
    List<String> iamBearerHeaders = Collections.synchronizedList(new ArrayList<>());
    HttpTransportFactory mockTransportFactory =
        createStsAndIamTransportFactory(
            stsCallCount, iamCallCount, iamBearerHeaders, iamCall -> false);
    IdentityPoolCredentials.Builder sourceBuilder =
        IdentityPoolCredentials.newBuilder()
            .setSubjectTokenSupplier(testProvider)
            .setHttpTransportFactory(mockTransportFactory)
            .setAudience(
                "//iam.googleapis.com/projects/123/locations/global/workloadIdentityPools/pool/providers/provider")
            .setSubjectTokenType("urn:ietf:params:oauth:token-type:id_token")
            .setTokenUrl(STS_URL)
            .setScopes(Collections.singletonList("https://www.googleapis.com/auth/CustomScope"));
    // A non-expiring token minted earlier without cloud-platform.
    sourceBuilder.setAccessToken(new AccessToken("unscoped-token", null));
    IdentityPoolCredentials sourceCredentials = sourceBuilder.build();
    assertEquals("unscoped-token", sourceCredentials.getAccessToken().getTokenValue());
    ImpersonatedCredentials impersonated =
        ImpersonatedCredentials.newBuilder()
            .setSourceCredentials(sourceCredentials)
            .setHttpTransportFactory(mockTransportFactory)
            .setTargetPrincipal("test@project.iam.gserviceaccount.com")
            .setScopes(Collections.singletonList(OAuth2Utils.CLOUD_PLATFORM_SCOPE))
            .build();

    assertEquals("iam-token-1", impersonated.refreshAccessToken().getTokenValue());

    // The unscoped token copied by createScoped() is dropped, so IAM is called with a newly
    // minted STS token instead.
    assertEquals(1, stsCallCount.get());
    assertEquals(Collections.singletonList("Bearer sts-token-1"), iamBearerHeaders);
  }

  @Test
  void standaloneImpersonatedCredentials_unscopedMtlsSource_pinnedRefreshRunsOnScopedSource()
      throws Exception {
    List<IdentityPoolCredentials> pinningInstances =
        Collections.synchronizedList(new ArrayList<>());
    HttpTransportFactory mockTransportFactory =
        createStsAndIamTransportFactory(
            new AtomicInteger(0), new AtomicInteger(0), new ArrayList<>(), iamCall -> false);
    IdentityPoolCredentials sourceCredentials =
        new PinningInstanceRecordingCredentials(
            IdentityPoolCredentials.newBuilder()
                .setSubjectTokenSupplier(testProvider)
                .setX509Provider(new TestX509Provider(createPopulatedKeyStore(), "test"))
                .setAudience(
                    "//iam.googleapis.com/projects/123/locations/global/workloadIdentityPools/pool/providers/provider")
                .setSubjectTokenType("urn:ietf:params:oauth:token-type:id_token")
                .setTokenUrl("https://sts.mtls.googleapis.com/v1/token")
                .setScopes(
                    Collections.singletonList("https://www.googleapis.com/auth/CustomScope")),
            mockTransportFactory,
            pinningInstances);
    ImpersonatedCredentials impersonated =
        ImpersonatedCredentials.newBuilder()
            .setSourceCredentials(sourceCredentials)
            .setTargetPrincipal("test@project.iam.gserviceaccount.com")
            .setScopes(Collections.singletonList(OAuth2Utils.CLOUD_PLATFORM_SCOPE))
            .build();

    assertEquals("iam-token-1", impersonated.refreshAccessToken().getTokenValue());

    // The source is scoped before the pinned refresh starts, so the KeyStore is pinned on the
    // scoped source that ImpersonatedCredentials keeps, not on the discarded unscoped one.
    GoogleCredentials scopedSource = impersonated.getSourceCredentials();
    assertNotSame(sourceCredentials, scopedSource);
    assertTrue(
        ((IdentityPoolCredentials) scopedSource)
            .getScopes()
            .contains(OAuth2Utils.CLOUD_PLATFORM_SCOPE));
    assertEquals(1, pinningInstances.size());
    assertSame(scopedSource, pinningInstances.get(0));
  }

  /**
   * Records which instance creates the pinned mTLS transport factory, and keeps doing so on copies
   * made by {@link #createScoped(Collection)}.
   */
  private static class PinningInstanceRecordingCredentials extends IdentityPoolCredentials {
    private final HttpTransportFactory mockTransportFactory;
    private final List<IdentityPoolCredentials> pinningInstances;

    PinningInstanceRecordingCredentials(
        IdentityPoolCredentials.Builder builder,
        HttpTransportFactory mockTransportFactory,
        List<IdentityPoolCredentials> pinningInstances) {
      super(builder);
      this.mockTransportFactory = mockTransportFactory;
      this.pinningInstances = pinningInstances;
    }

    @Override
    HttpTransportFactory createMtlsTransportFactory(KeyStore keyStore) {
      pinningInstances.add(this);
      return mockTransportFactory;
    }

    @Override
    public IdentityPoolCredentials createScoped(Collection<String> newScopes) {
      return new PinningInstanceRecordingCredentials(
          IdentityPoolCredentials.newBuilder(this).setScopes(newScopes),
          mockTransportFactory,
          pinningInstances);
    }
  }

  /** Decides, for the Nth IAM call, whether the mock IAM endpoint returns 401. */
  interface IamUnauthorizedDecider {
    boolean returnsUnauthorized(int iamCall) throws Exception;
  }

  /**
   * Returns a transport factory whose STS endpoint mints {@code sts-token-N} on the Nth call and
   * whose IAM endpoint returns either 401 or {@code iam-token-N} on the Nth call.
   */
  static HttpTransportFactory createStsAndIamTransportFactory(
      AtomicInteger stsCallCount,
      AtomicInteger iamCallCount,
      List<String> iamBearerHeaders,
      IamUnauthorizedDecider iamUnauthorizedDecider) {
    return () ->
        new MockHttpTransport() {
          @Override
          public LowLevelHttpRequest buildRequest(String method, String url) {
            return new MockLowLevelHttpRequest(url) {
              @Override
              public LowLevelHttpResponse execute() throws IOException {
                if (url.contains("/v1/token")) {
                  int count = stsCallCount.incrementAndGet();
                  GenericJson response = new GenericJson();
                  response.setFactory(OAuth2Utils.JSON_FACTORY);
                  response.put("access_token", "sts-token-" + count);
                  response.put("token_type", "Bearer");
                  response.put("expires_in", 3600);
                  response.put(
                      "issued_token_type", "urn:ietf:params:oauth:token-type:access_token");
                  return new MockLowLevelHttpResponse()
                      .setContentType(Json.MEDIA_TYPE)
                      .setContent(response.toString());
                } else if (url.contains(":generateAccessToken")) {
                  int count = iamCallCount.incrementAndGet();
                  iamBearerHeaders.add(getFirstHeaderValue("Authorization"));
                  boolean unauthorized;
                  try {
                    unauthorized = iamUnauthorizedDecider.returnsUnauthorized(count);
                  } catch (Exception e) {
                    throw new IOException(e);
                  }
                  if (unauthorized) {
                    return new MockLowLevelHttpResponse()
                        .setStatusCode(401)
                        .setContentType(Json.MEDIA_TYPE)
                        .setContent("{\"error\":{\"code\":401,\"status\":\"UNAUTHENTICATED\"}}");
                  }
                  GenericJson response = new GenericJson();
                  response.setFactory(OAuth2Utils.JSON_FACTORY);
                  response.put("accessToken", "iam-token-" + count);
                  response.put("expireTime", "2030-01-01T00:00:00Z");
                  return new MockLowLevelHttpResponse()
                      .setContentType(Json.MEDIA_TYPE)
                      .setContent(response.toString());
                }
                return new MockLowLevelHttpResponse().setStatusCode(404);
              }
            };
          }
        };
  }

  private static ImpersonatedCredentials createStandaloneImpersonatedCredentials(
      HttpTransportFactory mockTransportFactory) throws IOException {
    IdentityPoolCredentials sourceCredentials =
        new IdentityPoolCredentials(
            IdentityPoolCredentials.newBuilder()
                .setSubjectTokenSupplier(testProvider)
                .setX509Provider(new TestX509Provider(createPopulatedKeyStore(), "test"))
                .setAudience(
                    "//iam.googleapis.com/projects/123/locations/global/workloadIdentityPools/pool/providers/provider")
                .setSubjectTokenType("urn:ietf:params:oauth:token-type:id_token")
                .setTokenUrl("https://sts.mtls.googleapis.com/v1/token")
                // Already includes cloud-platform, so ImpersonatedCredentials does not replace
                // this source (and its createMtlsTransportFactory override) via createScoped().
                .setScopes(Collections.singletonList(OAuth2Utils.CLOUD_PLATFORM_SCOPE))) {
          @Override
          HttpTransportFactory createMtlsTransportFactory(KeyStore keyStore) {
            return mockTransportFactory;
          }
        };
    return ImpersonatedCredentials.newBuilder()
        .setSourceCredentials(sourceCredentials)
        .setTargetPrincipal("test@project.iam.gserviceaccount.com")
        .setScopes(Collections.singletonList(OAuth2Utils.CLOUD_PLATFORM_SCOPE))
        .build();
  }
}
