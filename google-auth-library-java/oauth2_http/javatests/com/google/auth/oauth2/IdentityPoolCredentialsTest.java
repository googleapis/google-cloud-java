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
import static org.mockito.Mockito.spy;
import static org.mockito.Mockito.verify;

import com.google.api.client.http.HttpTransport;
import com.google.api.client.json.GenericJson;
import com.google.api.client.util.Clock;
import com.google.auth.TestUtils;
import com.google.auth.http.HttpTransportFactory;
import com.google.auth.mtls.X509Provider;
import com.google.auth.oauth2.GoogleCredentials.GoogleCredentialsInfo;
import java.io.ByteArrayInputStream;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.nio.charset.StandardCharsets;
import java.security.KeyStore;
import java.security.KeyStoreException;
import java.security.NoSuchAlgorithmException;
import java.security.cert.CertificateException;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import javax.annotation.Nullable;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;

/** Tests for {@link IdentityPoolCredentials}. */
@ExtendWith(MockitoExtension.class)
class IdentityPoolCredentialsTest extends BaseSerializationTest {

  private static final String STS_URL = "https://sts.googleapis.com/v1/token";

  private static final IdentityPoolSubjectTokenSupplier testProvider =
      (ExternalAccountSupplierContext context) -> "testSubjectToken";

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
  void build_withCertificateSourceAndCustomX509Provider_success()
      throws IOException, KeyStoreException, CertificateException, NoSuchAlgorithmException {
    // Create an empty KeyStore and a spy on a custom X509Provider.
    KeyStore keyStore = KeyStore.getInstance("JKS");
    keyStore.load(null, null);
    TestX509Provider x509Provider =
        spy(new TestX509Provider(keyStore, "/path/to/certificate.json"));

    // Set up credential source for certificate type.
    Map<String, Object> certificateMap = new HashMap<>();
    certificateMap.put("use_default_certificate_config", true);
    Map<String, Object> credentialSourceMap = new HashMap<>();
    credentialSourceMap.put("certificate", certificateMap);
    IdentityPoolCredentialSource credentialSource =
        new IdentityPoolCredentialSource(credentialSourceMap);
    MockExternalAccountCredentialsTransportFactory mockTransportFactory =
        new MockExternalAccountCredentialsTransportFactory();

    // Build credentials with the custom provider.
    IdentityPoolCredentials credentials =
        IdentityPoolCredentials.newBuilder()
            .setX509Provider(x509Provider)
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

    // Verify the custom provider methods were called during build.
    verify(x509Provider).getKeyStore();
    verify(x509Provider).getCertificatePath();
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
    // Simulate a scenario where the X509Provider cannot access or read the certificate
    // configuration file needed to determine the certificate path, resulting in an IOException.
    KeyStore keyStore = KeyStore.getInstance("JKS");
    keyStore.load(null, null);
    TestX509Provider x509Provider = new TestX509Provider(keyStore, "/path/to/certificate.json");
    x509Provider.setShouldThrowOnGetCertificatePath(true); // Configure to throw

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
    assertEquals("Simulated IOException on certificate path", exception.getCause().getMessage());

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
    private boolean shouldThrowOnGetCertificatePath = false;

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

    @Override
    public String getCertificatePath() throws IOException {
      if (shouldThrowOnGetCertificatePath) {
        throw new IOException("Simulated IOException on certificate path");
      }
      return certificatePath;
    }

    void setShouldThrowOnGetKeyStore(boolean shouldThrow) {
      this.shouldThrowOnGetKeyStore = shouldThrow;
    }

    void setShouldThrowOnGetCertificatePath(boolean shouldThrow) {
      this.shouldThrowOnGetCertificatePath = shouldThrow;
    }
  }
}
