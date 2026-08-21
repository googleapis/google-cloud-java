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
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;

import com.google.api.client.http.HttpTransport;
import com.google.api.client.json.GenericJson;
import com.google.api.client.util.Clock;
import com.google.auth.TestUtils;
import com.google.auth.http.HttpTransportFactory;
import com.google.auth.mtls.MtlsHttpTransportFactory;
import com.google.auth.mtls.X509Provider;
import com.google.auth.oauth2.GoogleCredentials.GoogleCredentialsInfo;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.nio.charset.StandardCharsets;
import java.security.KeyStore;
import java.security.KeyStoreException;
import java.security.NoSuchAlgorithmException;
import java.security.cert.CertificateException;
import java.util.Arrays;
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
import org.jspecify.annotations.Nullable;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNotSame;
import static org.junit.jupiter.api.Assertions.fail;

/** Tests for {@link IdentityPoolCredentials}. */
@ExtendWith(MockitoExtension.class)
class IdentityPoolCredentialsTest extends BaseSerializationTest {

  private static final String STS_URL = "https://sts.googleapis.com/v1/token";

  private static final IdentityPoolSubjectTokenSupplier testProvider =
      (ExternalAccountSupplierContext context) -> "testSubjectToken";

  private static final IdentityPoolActorTokenSupplier testActorSupplier =
      (ExternalAccountSupplierContext context) -> "testActorToken";

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
        transportFactory.transport.getRequests().get(2).getHeaders();
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
        transportFactory.transport.getRequests().get(2).getHeaders();
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
        "Missing credential source file location, URL, or certificate. At least one must be specified.",
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
          "The workforce_pool_user_project parameter should only be provided for a Workforce Pool configuration.",
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
        "Actor tokens are only supported for mTLS token exchanges. Please configure a certificate source or MtlsHttpTransportFactory.",
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
    KeyStore ks = KeyStore.getInstance(KeyStore.getDefaultType());
    ks.load(null, null);
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
    KeyStore ks = KeyStore.getInstance(KeyStore.getDefaultType());
    ks.load(null, null);
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

    KeyStore ks = KeyStore.getInstance(KeyStore.getDefaultType());
    ks.load(null, null);
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
        scoped.getIdentityPoolSubjectTokenSupplier(),
        scoped.getIdentityPoolActorTokenSupplier());
  }

  @Test
  void refreshAccessToken_withActorToken_injectsActingPartyIntoStsRequest() throws Exception {
    MockExternalAccountCredentialsTransportFactory transportFactory =
        new MockExternalAccountCredentialsTransportFactory();
    KeyStore ks = KeyStore.getInstance(KeyStore.getDefaultType());
    ks.load(null, null);
    MtlsHttpTransportFactory mtlsTransport =
        new MtlsHttpTransportFactory(ks) {
          @Override
          public com.google.api.client.http.HttpTransport create() {
            return transportFactory.create();
          }
        };

    IdentityPoolCredentials credential =
        IdentityPoolCredentials.newBuilder()
            .setSubjectTokenSupplier(testProvider)
            .setActorTokenSupplier(testActorSupplier)
            .setActorTokenType("urn:ietf:params:oauth:token-type:jwt")
            .setAudience(
                "//iam.googleapis.com/projects/123/locations/global/workloadIdentityPools/pool/providers/provider")
            .setSubjectTokenType("urn:ietf:params:oauth:token-type:id_token")
            .setTokenUrl(transportFactory.transport.getStsUrl())
            .setHttpTransportFactory(mtlsTransport)
            .build();

    AccessToken token = credential.refreshAccessToken();
    assertEquals(transportFactory.transport.getAccessToken(), token.getTokenValue());

    Map<String, String> query =
        TestUtils.parseQuery(transportFactory.transport.getLastRequest().getContentAsString());
    assertEquals("testActorToken", query.get("actor_token"));
    assertEquals("urn:ietf:params:oauth:token-type:jwt", query.get("actor_token_type"));
  }

  @Test
  void serialization_withX509Provider_succeeds() throws Exception {
    KeyStore ks = KeyStore.getInstance(KeyStore.getDefaultType());
    ks.load(null, null);
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

    KeyStore ks = KeyStore.getInstance(KeyStore.getDefaultType());
    ks.load(null, null);
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
    KeyStore ks = KeyStore.getInstance(KeyStore.getDefaultType());
    ks.load(null, null);
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
    KeyStore ks = KeyStore.getInstance(KeyStore.getDefaultType());
    ks.load(null, null);
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
    KeyStore ks = KeyStore.getInstance(KeyStore.getDefaultType());
    ks.load(null, null);
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
        e.getMessage()
            .contains(
                "Actor tokens are only supported for mTLS token exchanges."));
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
        e.getMessage()
            .contains(
                "Actor tokens are only supported for mTLS token exchanges."));
  }

  @Test
  void mtlsHttpTransportFactory_hasKeyStore_withKeyStore_returnsTrue() throws Exception {
    KeyStore ks = KeyStore.getInstance(KeyStore.getDefaultType());
    ks.load(null, null);
    MtlsHttpTransportFactory factory = new MtlsHttpTransportFactory(ks);
    assertTrue(factory.hasKeyStore());
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
  void refreshAccessToken_useSameCertForStsAndIam() throws Exception {
    // Verify that both STS and IAM use the same transport factory (from the same KeyStore
    // snapshot) within one refresh cycle.
    KeyStore ks = KeyStore.getInstance(KeyStore.getDefaultType());
    ks.load(null, null);

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

    MtlsHttpTransportFactory mtlsTransport =
        new MtlsHttpTransportFactory(ks) {
          @Override
          public HttpTransport create() {
            return transportFactory.create();
          }
        };

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
    KeyStore ksA = KeyStore.getInstance(KeyStore.getDefaultType());
    ksA.load(null, null);
    KeyStore ksB = KeyStore.getInstance(KeyStore.getDefaultType());
    ksB.load(null, null);

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

    MtlsHttpTransportFactory mtlsTransport =
        new MtlsHttpTransportFactory(ksA) {
          @Override
          public HttpTransport create() {
            return transportFactory.create();
          }
        };

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
    KeyStore ksA = KeyStore.getInstance(KeyStore.getDefaultType());
    ksA.load(null, null);
    KeyStore ksB = KeyStore.getInstance(KeyStore.getDefaultType());
    ksB.load(null, null);

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

    MtlsHttpTransportFactory mtlsTransport =
        new MtlsHttpTransportFactory(ksA) {
          @Override
          public HttpTransport create() {
            return transportFactory.create();
          }
        };

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
    OAuthException e =
        assertThrows(OAuthException.class, credential::refreshAccessToken);
    assertEquals(401, e.getHttpStatusCode());
    assertEquals(1, credential.getExchangeCallCount());
  }

  @Test
  void refreshAccessToken_401Retry_secondAttemptFails_throws() throws Exception {
    // 401 → retry → retry also fails → exception propagates.
    KeyStore ks = KeyStore.getInstance(KeyStore.getDefaultType());
    ks.load(null, null);

    X509Provider provider =
        new X509Provider() {
          @Override
          public KeyStore getKeyStore() {
            return ks;
          }
        };

    MockExternalAccountCredentialsTransportFactory transportFactory =
        new MockExternalAccountCredentialsTransportFactory();

    MtlsHttpTransportFactory mtlsTransport =
        new MtlsHttpTransportFactory(ks) {
          @Override
          public HttpTransport create() {
            return transportFactory.create();
          }
        };

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

    OAuthException e =
        assertThrows(OAuthException.class, credential::refreshAccessToken);
    assertEquals(401, e.getHttpStatusCode());
    // First attempt + one retry = 2
    assertEquals(2, credential.getExchangeCallCount());
  }

  @Test
  void refreshAccessToken_401Retry_certLoadFailure_preservesOriginalError() throws Exception {
    // When a 401 triggers retry but X509Provider.getKeyStore() throws on the retry,
    // the IOException from cert loading should be thrown with the original OAuthException
    // as a suppressed exception.
    KeyStore ks = KeyStore.getInstance(KeyStore.getDefaultType());
    ks.load(null, null);

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

    MtlsHttpTransportFactory mtlsTransport =
        new MtlsHttpTransportFactory(ks) {
          @Override
          public HttpTransport create() {
            return transportFactory.create();
          }
        };

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
    File file =
        File.createTempFile("ATOMIC_READ_TOKEN", /* suffix= */ null, /* directory= */ null);
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

    MockExternalAccountCredentialsTransportFactory transportFactory =
        new MockExternalAccountCredentialsTransportFactory();

    KeyStore ks = KeyStore.getInstance(KeyStore.getDefaultType());
    ks.load(null, null);
    MtlsHttpTransportFactory mtlsTransport =
        new MtlsHttpTransportFactory(ks) {
          @Override
          public HttpTransport create() {
            return transportFactory.create();
          }
        };

    IdentityPoolCredentials credential =
        IdentityPoolCredentials.newBuilder()
            .setCredentialSource(credentialSource)
            .setActorTokenType("urn:ietf:params:oauth:token-type:jwt")
            .setAudience(
                "//iam.googleapis.com/projects/123/locations/global/workloadIdentityPools/pool/providers/provider")
            .setSubjectTokenType("urn:ietf:params:oauth:token-type:id_token")
            .setTokenUrl(transportFactory.transport.getStsUrl())
            .setHttpTransportFactory(mtlsTransport)
            .build();

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
        TestUtils.parseQuery(transportFactory.transport.getLastRequest().getContentAsString());
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
    KeyStore ks1 = KeyStore.getInstance(KeyStore.getDefaultType());
    ks1.load(null, null);
    KeyStore ks2 = KeyStore.getInstance(KeyStore.getDefaultType());
    ks2.load(null, null);

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

    MtlsHttpTransportFactory mtlsTransport =
        new MtlsHttpTransportFactory(ks1) {
          @Override
          public HttpTransport create() {
            return transportFactory.create();
          }
        };

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
    KeyStore ksInitial = KeyStore.getInstance(KeyStore.getDefaultType());
    ksInitial.load(null, null);
    KeyStore ksRetry = KeyStore.getInstance(KeyStore.getDefaultType());
    ksRetry.load(null, null);

    AtomicInteger getKeyStoreCount = new AtomicInteger(0);
    X509Provider provider =
        new X509Provider() {
          @Override
          public KeyStore getKeyStore() {
            int count = getKeyStoreCount.incrementAndGet();
            // First two calls are for the two threads' initial snapshots,
            // third call is for Thread B's retry after 401.
            return count <= 2 ? ksInitial : ksRetry;
          }
        };

    MockExternalAccountCredentialsTransportFactory transportFactory =
        new MockExternalAccountCredentialsTransportFactory();

    MtlsHttpTransportFactory mtlsTransport =
        new MtlsHttpTransportFactory(ksInitial) {
          @Override
          public HttpTransport create() {
            return transportFactory.create();
          }
        };

    // Use a credential where one thread gets a 401 (first exchange fails) and the other
    // succeeds. The AtomicInteger tracks per-thread exchange behavior.
    AtomicInteger exchangeCallCount = new AtomicInteger(0);
    CyclicBarrier barrier = new CyclicBarrier(2);

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
      Future<AccessToken> futureA =
          executor.submit(
              () -> {
                barrier.await(5, TimeUnit.SECONDS);
                return credential.refreshAccessToken();
              });

      Future<AccessToken> futureB =
          executor.submit(
              () -> {
                barrier.await(5, TimeUnit.SECONDS);
                return credential.refreshAccessToken();
              });

      AccessToken tokenA = futureA.get(10, TimeUnit.SECONDS);
      AccessToken tokenB = futureB.get(10, TimeUnit.SECONDS);

      assertNotNull(tokenA);
      assertNotNull(tokenB);

      // Both threads did initial snapshots (2 calls), plus Thread B's retry (1 more)
      assertTrue(
          getKeyStoreCount.get() >= 3,
          "Expected at least 3 getKeyStore calls (2 initial + 1 retry), got "
              + getKeyStoreCount.get());
      // 3 exchange calls total: one 401 + one retry success + one normal success
      assertEquals(3, exchangeCallCount.get());
    } finally {
      executor.shutdownNow();
    }
  }

  @Test
  void refreshAccessToken_certRotationDuringRefresh_pinnedCertUsed() throws Exception {
    // Cert rotates mid-refresh (during the exchange call).
    // Verify the transport factory used in exchange is the one pinned at snapshot time,
    // not the rotated cert.
    KeyStore ksOriginal = KeyStore.getInstance(KeyStore.getDefaultType());
    ksOriginal.load(null, null);
    KeyStore ksRotated = KeyStore.getInstance(KeyStore.getDefaultType());
    ksRotated.load(null, null);

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

    MtlsHttpTransportFactory mtlsTransport =
        new MtlsHttpTransportFactory(ksOriginal) {
          @Override
          public HttpTransport create() {
            return transportFactory.create();
          }
        };

    // A credential that rotates the cert DURING the exchange call, then captures
    // the transport factory to verify it's still the original pinned one.
    AtomicReference<HttpTransportFactory> capturedFactory = new AtomicReference<>();
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
            // Rotate the cert on the provider DURING the exchange.
            // This simulates a cert rotation happening while STS/IAM is in-flight.
            currentKeyStore.set(ksRotated);
            // Capture the factory that was passed — it should be the original pinned one.
            capturedFactory.set(cycleTransportFactory);
            return new AccessToken("pinnedCertToken", null);
          }
        };

    // Call refresh — this will snapshot ksOriginal, then during exchange, rotate to ksRotated.
    AccessToken token = credential.refreshAccessToken();
    assertNotNull(token);
    // Snapshot was taken exactly once (at the start of the cycle)
    assertEquals(1, snapshotCount.get());

    // The transport factory used in exchange should be an MtlsHttpTransportFactory
    // built from the ORIGINAL snapshot, not the rotated cert.
    assertNotNull(capturedFactory.get());
    assertTrue(
        capturedFactory.get() instanceof MtlsHttpTransportFactory,
        "Exchange should use MtlsHttpTransportFactory pinned to original cert");

    // Verify that a SECOND refresh picks up the rotated cert (ksRotated).
    AtomicReference<HttpTransportFactory> secondCapturedFactory = new AtomicReference<>();
    IdentityPoolCredentials credential2 =
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
            secondCapturedFactory.set(cycleTransportFactory);
            return new AccessToken("rotatedCertToken", null);
          }
        };

    AccessToken token2 = credential2.refreshAccessToken();
    assertNotNull(token2);
    // Second refresh should have taken a new snapshot
    assertEquals(2, snapshotCount.get());

    // The two factories should be different instances (different cert snapshots)
    assertNotSame(
        capturedFactory.get(),
        secondCapturedFactory.get(),
        "Each refresh cycle should create a distinct transport factory from its cert snapshot");
  }

  // ==================================================================================
  // Section D: Serialization Tests
  // ==================================================================================

  @Test
  void serialize_deserialize_withActorTokenConfig_roundTrips() throws Exception {
    KeyStore ks = KeyStore.getInstance(KeyStore.getDefaultType());
    ks.load(null, null);
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
  void serialize_deserialize_backwardCompatible() throws Exception {
    // Verify that credentials serialized WITHOUT actor token config
    // can still be deserialized. This simulates loading pre-actor-token bytes.
    IdentityPoolCredentials original =
        IdentityPoolCredentials.newBuilder(createBaseFileSourcedCredentials())
            .setServiceAccountImpersonationUrl(SERVICE_ACCOUNT_IMPERSONATION_URL)
            .setQuotaProjectId("quotaProjectId")
            .setClientId("clientId")
            .setClientSecret("clientSecret")
            .build();

    // Serialize (simulates old format without actor token fields)
    ByteArrayOutputStream bytes = new ByteArrayOutputStream();
    try (ObjectOutputStream output = new ObjectOutputStream(bytes)) {
      output.writeObject(original);
    }

    // Deserialize the bytes — should succeed even if internal layout changes
    IdentityPoolCredentials deserialized;
    try (ObjectInputStream input =
        new ObjectInputStream(new ByteArrayInputStream(bytes.toByteArray()))) {
      deserialized = (IdentityPoolCredentials) input.readObject();
    }

    // Core fields should survive serialization round-trip
    assertEquals(original.getAudience(), deserialized.getAudience());
    assertEquals(original.getSubjectTokenType(), deserialized.getSubjectTokenType());
    assertEquals(original.getTokenUrl(), deserialized.getTokenUrl());
    assertEquals(original.getQuotaProjectId(), deserialized.getQuotaProjectId());
    assertEquals(original.getClientId(), deserialized.getClientId());
    assertEquals(original.getClientSecret(), deserialized.getClientSecret());
    assertEquals(
        original.getServiceAccountImpersonationUrl(),
        deserialized.getServiceAccountImpersonationUrl());
    // Actor token fields should be null in pre-actor-token credentials
    assertEquals(null, deserialized.getActorTokenType());
  }

  // ==================================================================================
  // Helper: TestableIdentityPoolCredentials — overrides exchange for 401 testing
  // ==================================================================================

  /**
   * A test subclass that overrides exchangeExternalCredentialForAccessToken to throw
   * OAuthException(401) on configurable calls, simulating the cert rotation retry path.
   * This is necessary because the real STS handler wraps HttpResponseException into
   * OAuthException, which is what the catch(OAuthException) in refreshAccessToken expects
   * via normal STS flow.
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
   * exchangeExternalCredentialForAccessToken, allowing tests to verify cert pinning
   * behavior without making real HTTP calls.
   */
  private static class TransportCapturingCredentials extends IdentityPoolCredentials {
    private final java.util.List<HttpTransportFactory> capturedFactories =
        java.util.Collections.synchronizedList(new java.util.ArrayList<>());

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

    java.util.List<HttpTransportFactory> getCapturedFactories() {
      return capturedFactories;
    }
  }
}

