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
import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;

import com.google.api.client.json.GenericJson;
import com.google.api.client.json.JsonParser;
import com.google.api.client.testing.http.MockLowLevelHttpRequest;
import com.google.api.client.util.Clock;
import com.google.auth.TestUtils;
import com.google.auth.oauth2.ExternalAccountCredentialsTest.MockExternalAccountCredentialsTransportFactory;
import com.google.auth.oauth2.GoogleCredentials.GoogleCredentialsInfo;
import java.io.IOException;
import java.io.InputStream;
import java.net.URI;
import java.net.URLDecoder;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.junit.jupiter.api.Test;

/** Tests for {@link AwsCredentials}. */
class AwsCredentialsTest extends BaseSerializationTest {

  private static final String STS_URL = "https://sts.googleapis.com/v1/token";
  private static final String AWS_CREDENTIALS_URL = "https://169.254.169.254";
  private static final String AWS_CREDENTIALS_URL_WITH_ROLE = "https://169.254.169.254/roleName";
  private static final String AWS_REGION_URL = "https://169.254.169.254/region";
  private static final String AWS_IMDSV2_SESSION_TOKEN_URL = "https://169.254.169.254/imdsv2";
  private static final String AWS_IMDSV2_SESSION_TOKEN = "sessiontoken";
  private static final String DEFAULT_REGIONAL_CREDENTIAL_VERIFICATION_URL =
      "https://sts.{region}.amazonaws.com?Action=GetCallerIdentity&Version=2011-06-15";

  private static final String GET_CALLER_IDENTITY_URL =
      "https://sts.amazonaws.com?Action=GetCallerIdentity&Version=2011-06-15";

  private static final String SERVICE_ACCOUNT_IMPERSONATION_URL =
      "https://iamcredentials.googleapis.com/v1/projects/-/serviceAccounts/testn@test.iam.gserviceaccount.com:generateAccessToken";

  private static final Map<String, Object> AWS_CREDENTIAL_SOURCE_MAP =
      new HashMap<String, Object>() {
        {
          put("environment_id", "aws1");
          put("region_url", AWS_REGION_URL);
          put("url", AWS_CREDENTIALS_URL);
          put("regional_cred_verification_url", "regionalCredVerificationUrl");
        }
      };

  private static final Map<String, String> EMPTY_STRING_HEADERS = Collections.emptyMap();

  private static final AwsCredentialSource AWS_CREDENTIAL_SOURCE =
      new AwsCredentialSource(AWS_CREDENTIAL_SOURCE_MAP);

  private static final AwsCredentials AWS_CREDENTIAL =
      AwsCredentials.newBuilder()
          .setHttpTransportFactory(OAuth2Utils.HTTP_TRANSPORT_FACTORY)
          .setAudience("audience")
          .setSubjectTokenType("subjectTokenType")
          .setTokenUrl(STS_URL)
          .setTokenInfoUrl("tokenInfoUrl")
          .setCredentialSource(AWS_CREDENTIAL_SOURCE)
          .build();

  private static final AwsSecurityCredentials programmaticAwsCreds =
      new AwsSecurityCredentials("testAccessKey", "testSecretAccessKey", null);

  private static final ExternalAccountSupplierContext emptyContext =
      ExternalAccountSupplierContext.newBuilder().setAudience("").setSubjectTokenType("").build();

  @Test
  void test_awsCredentialSource() {
    String[] keys = {"region_url", "url", "imdsv2_session_token_url"};
    for (String key : keys) {
      Map<String, Object> credentialSourceWithInvalidUrl = buildAwsIpv6CredentialSourceMap();
      credentialSourceWithInvalidUrl.put(key, "https://badhost.com/fake");

      // Should succeed as no validation is done.
      assertDoesNotThrow(() -> new AwsCredentialSource(credentialSourceWithInvalidUrl));
    }
  }

  @Test
  void refreshAccessToken_withoutServiceAccountImpersonation() throws IOException {
    MockExternalAccountCredentialsTransportFactory transportFactory =
        new MockExternalAccountCredentialsTransportFactory();

    AwsCredentials awsCredential =
        AwsCredentials.newBuilder(AWS_CREDENTIAL)
            .setTokenUrl(transportFactory.transport.getStsUrl())
            .setHttpTransportFactory(transportFactory)
            .setCredentialSource(buildAwsCredentialSource(transportFactory))
            .build();

    AccessToken accessToken = awsCredential.refreshAccessToken();

    assertEquals(transportFactory.transport.getAccessToken(), accessToken.getTokenValue());

    // Validate metrics header is set correctly on the sts request.
    Map<String, List<String>> headers =
        transportFactory.transport.getRequests().get(3).getHeaders();
    ExternalAccountCredentialsTest.validateMetricsHeader(headers, "aws", false, false);
  }

  @Test
  void refreshAccessToken_withServiceAccountImpersonation() throws IOException {
    MockExternalAccountCredentialsTransportFactory transportFactory =
        new MockExternalAccountCredentialsTransportFactory();

    transportFactory.transport.setExpireTime(TestUtils.getDefaultExpireTime());

    AwsCredentials awsCredential =
        AwsCredentials.newBuilder()
            .setHttpTransportFactory(transportFactory)
            .setAudience("audience")
            .setSubjectTokenType("subjectTokenType")
            .setTokenUrl(transportFactory.transport.getStsUrl())
            .setTokenInfoUrl("tokenInfoUrl")
            .setCredentialSource(buildAwsCredentialSource(transportFactory))
            .setServiceAccountImpersonationUrl(
                transportFactory.transport.getServiceAccountImpersonationUrl())
            .build();

    AccessToken accessToken = awsCredential.refreshAccessToken();

    assertEquals(
        transportFactory.transport.getServiceAccountAccessToken(), accessToken.getTokenValue());

    // Validate metrics header is set correctly on the sts request.
    Map<String, List<String>> headers =
        transportFactory.transport.getRequests().get(6).getHeaders();
    ExternalAccountCredentialsTest.validateMetricsHeader(headers, "aws", true, false);
  }

  @Test
  void refreshAccessToken_withServiceAccountImpersonationOptions() throws IOException {
    MockExternalAccountCredentialsTransportFactory transportFactory =
        new MockExternalAccountCredentialsTransportFactory();

    transportFactory.transport.setExpireTime(TestUtils.getDefaultExpireTime());

    AwsCredentials awsCredential =
        AwsCredentials.newBuilder()
            .setHttpTransportFactory(transportFactory)
            .setAudience("audience")
            .setSubjectTokenType("subjectTokenType")
            .setTokenUrl(transportFactory.transport.getStsUrl())
            .setTokenInfoUrl("tokenInfoUrl")
            .setCredentialSource(buildAwsCredentialSource(transportFactory))
            .setServiceAccountImpersonationUrl(
                transportFactory.transport.getServiceAccountImpersonationUrl())
            .setServiceAccountImpersonationOptions(
                ExternalAccountCredentialsTest.buildServiceAccountImpersonationOptions())
            .build();

    AccessToken accessToken = awsCredential.refreshAccessToken();

    assertEquals(
        transportFactory.transport.getServiceAccountAccessToken(), accessToken.getTokenValue());

    // Validate that default lifetime was set correctly on the request.
    try (JsonParser jsonParser =
        OAuth2Utils.JSON_FACTORY.createJsonParser(
            transportFactory.transport.getLastRequest().getContentAsString())) {
      GenericJson query = jsonParser.parseAndClose(GenericJson.class);
      assertEquals("2800s", query.get("lifetime"));

      // Validate metrics header is set correctly on the sts request.
      Map<String, List<String>> headers =
          transportFactory.transport.getRequests().get(6).getHeaders();
      ExternalAccountCredentialsTest.validateMetricsHeader(headers, "aws", true, true);
    }
  }

  @Test
  void refreshAccessTokenProgrammaticRefresh_withoutServiceAccountImpersonation()
      throws IOException {
    MockExternalAccountCredentialsTransportFactory transportFactory =
        new MockExternalAccountCredentialsTransportFactory();

    AwsSecurityCredentialsSupplier supplier =
        new TestAwsSecurityCredentialsSupplier("test", programmaticAwsCreds, null, null);

    AwsCredentials awsCredential =
        AwsCredentials.newBuilder()
            .setAwsSecurityCredentialsSupplier(supplier)
            .setHttpTransportFactory(transportFactory)
            .setAudience("audience")
            .setTokenUrl(STS_URL)
            .setSubjectTokenType("subjectTokenType")
            .build();

    AccessToken accessToken = awsCredential.refreshAccessToken();

    assertEquals(transportFactory.transport.getAccessToken(), accessToken.getTokenValue());

    // Validate metrics header is set correctly on the sts request.
    Map<String, List<String>> headers =
        transportFactory.transport.getRequests().get(0).getHeaders();
    ExternalAccountCredentialsTest.validateMetricsHeader(headers, "programmatic", false, false);
  }

  @Test
  void refreshAccessTokenProgrammaticRefresh_withServiceAccountImpersonation() throws IOException {
    MockExternalAccountCredentialsTransportFactory transportFactory =
        new MockExternalAccountCredentialsTransportFactory();

    transportFactory.transport.setExpireTime(TestUtils.getDefaultExpireTime());

    AwsSecurityCredentialsSupplier supplier =
        new TestAwsSecurityCredentialsSupplier("test", programmaticAwsCreds, null, null);

    AwsCredentials awsCredential =
        AwsCredentials.newBuilder()
            .setAwsSecurityCredentialsSupplier(supplier)
            .setHttpTransportFactory(transportFactory)
            .setAudience("audience")
            .setTokenUrl(STS_URL)
            .setSubjectTokenType("subjectTokenType")
            .setServiceAccountImpersonationUrl(
                transportFactory.transport.getServiceAccountImpersonationUrl())
            .build();

    AccessToken accessToken = awsCredential.refreshAccessToken();

    assertEquals(
        transportFactory.transport.getServiceAccountAccessToken(), accessToken.getTokenValue());

    // Validate metrics header is set correctly on the sts request.
    Map<String, List<String>> headers =
        transportFactory.transport.getRequests().get(0).getHeaders();
    ExternalAccountCredentialsTest.validateMetricsHeader(headers, "programmatic", true, false);
  }

  @Test
  @SuppressWarnings("unchecked")
  void retrieveSubjectToken() throws IOException {
    MockExternalAccountCredentialsTransportFactory transportFactory =
        new MockExternalAccountCredentialsTransportFactory();

    AwsCredentials awsCredential =
        AwsCredentials.newBuilder(AWS_CREDENTIAL)
            .setHttpTransportFactory(transportFactory)
            .setCredentialSource(buildAwsCredentialSource(transportFactory))
            .build();

    String subjectToken = URLDecoder.decode(awsCredential.retrieveSubjectToken(), "UTF-8");

    JsonParser parser = OAuth2Utils.JSON_FACTORY.createJsonParser(subjectToken);
    GenericJson json = parser.parseAndClose(GenericJson.class);

    List<Map<String, String>> headersList = (List<Map<String, String>>) json.get("headers");
    Map<String, String> headers = new HashMap<>();
    for (Map<String, String> header : headersList) {
      headers.put(header.get("key"), header.get("value"));
    }

    assertEquals("POST", json.get("method"));
    assertEquals(GET_CALLER_IDENTITY_URL, json.get("url"));
    assertEquals(URI.create(GET_CALLER_IDENTITY_URL).getHost(), headers.get("host"));
    assertEquals("token", headers.get("x-amz-security-token"));
    assertEquals(awsCredential.getAudience(), headers.get("x-goog-cloud-target-resource"));
    assertTrue(headers.containsKey("x-amz-date"));
    assertNotNull(headers.get("Authorization"));

    List<MockLowLevelHttpRequest> requests = transportFactory.transport.getRequests();
    assertEquals(3, requests.size());

    // Validate region request.
    ValidateRequest(requests.get(0), AWS_REGION_URL, EMPTY_STRING_HEADERS);

    // Validate role request.
    ValidateRequest(requests.get(1), AWS_CREDENTIALS_URL, EMPTY_STRING_HEADERS);

    // Validate security credentials request.
    ValidateRequest(requests.get(2), AWS_CREDENTIALS_URL_WITH_ROLE, EMPTY_STRING_HEADERS);
  }

  @Test
  @SuppressWarnings("unchecked")
  void retrieveSubjectTokenWithSessionTokenUrl() throws IOException {
    MockExternalAccountCredentialsTransportFactory transportFactory =
        new MockExternalAccountCredentialsTransportFactory();

    AwsCredentials awsCredential =
        AwsCredentials.newBuilder(AWS_CREDENTIAL)
            .setHttpTransportFactory(transportFactory)
            .setCredentialSource(buildAwsImdsv2CredentialSource(transportFactory))
            .build();

    String subjectToken = URLDecoder.decode(awsCredential.retrieveSubjectToken(), "UTF-8");

    JsonParser parser = OAuth2Utils.JSON_FACTORY.createJsonParser(subjectToken);
    GenericJson json = parser.parseAndClose(GenericJson.class);

    List<Map<String, String>> headersList = (List<Map<String, String>>) json.get("headers");
    Map<String, String> headers = new HashMap<>();
    for (Map<String, String> header : headersList) {
      headers.put(header.get("key"), header.get("value"));
    }

    assertEquals("POST", json.get("method"));
    assertEquals(GET_CALLER_IDENTITY_URL, json.get("url"));
    assertEquals(URI.create(GET_CALLER_IDENTITY_URL).getHost(), headers.get("host"));
    assertEquals("token", headers.get("x-amz-security-token"));
    assertEquals(awsCredential.getAudience(), headers.get("x-goog-cloud-target-resource"));
    assertTrue(headers.containsKey("x-amz-date"));
    assertNotNull(headers.get("Authorization"));

    List<MockLowLevelHttpRequest> requests = transportFactory.transport.getRequests();
    assertEquals(5, requests.size());

    // Validate the session token request
    ValidateRequest(
        requests.get(0),
        AWS_IMDSV2_SESSION_TOKEN_URL,
        new HashMap<String, String>() {
          {
            put(
                InternalAwsSecurityCredentialsSupplier.AWS_IMDSV2_SESSION_TOKEN_TTL_HEADER,
                InternalAwsSecurityCredentialsSupplier.AWS_IMDSV2_SESSION_TOKEN_TTL);
          }
        });

    Map<String, String> sessionTokenHeader =
        new HashMap<String, String>() {
          {
            put(
                InternalAwsSecurityCredentialsSupplier.AWS_IMDSV2_SESSION_TOKEN_HEADER,
                AWS_IMDSV2_SESSION_TOKEN);
          }
        };

    // Validate region request.
    ValidateRequest(requests.get(1), AWS_REGION_URL, sessionTokenHeader);

    // Validate role request.
    ValidateRequest(requests.get(3), AWS_CREDENTIALS_URL, sessionTokenHeader);

    // Validate security credentials request.
    ValidateRequest(requests.get(4), AWS_CREDENTIALS_URL_WITH_ROLE, sessionTokenHeader);
  }

  @Test
  void retrieveSubjectToken_imdsv1EnvVariablesSet_metadataServerNotCalled() throws IOException {
    MockExternalAccountCredentialsTransportFactory transportFactory =
        new MockExternalAccountCredentialsTransportFactory();

    // Provide AWS credentials through environment vars.
    TestEnvironmentProvider environmentProvider = new TestEnvironmentProvider();
    environmentProvider
        .setEnv("AWS_REGION", "awsRegion")
        .setEnv("AWS_ACCESS_KEY_ID", "awsAccessKeyId")
        .setEnv("AWS_SECRET_ACCESS_KEY", "awsSecretAccessKey")
        .setEnv("AWS_SESSION_TOKEN", "awsToken");

    AwsCredentials awsCredential =
        AwsCredentials.newBuilder(AWS_CREDENTIAL)
            .setHttpTransportFactory(transportFactory)
            .setCredentialSource(buildAwsCredentialSource(transportFactory))
            .setEnvironmentProvider(environmentProvider)
            .build();

    String subjectToken = URLDecoder.decode(awsCredential.retrieveSubjectToken(), "UTF-8");

    JsonParser parser = OAuth2Utils.JSON_FACTORY.createJsonParser(subjectToken);
    GenericJson json = parser.parseAndClose(GenericJson.class);

    List<Map<String, String>> headersList = (List<Map<String, String>>) json.get("headers");
    Map<String, String> headers = new HashMap<>();
    for (Map<String, String> header : headersList) {
      headers.put(header.get("key"), header.get("value"));
    }

    assertEquals("POST", json.get("method"));
    assertEquals(GET_CALLER_IDENTITY_URL, json.get("url"));
    assertEquals(URI.create(GET_CALLER_IDENTITY_URL).getHost(), headers.get("host"));
    assertEquals("awsToken", headers.get("x-amz-security-token"));
    assertEquals(awsCredential.getAudience(), headers.get("x-goog-cloud-target-resource"));
    assertTrue(headers.containsKey("x-amz-date"));
    assertNotNull(headers.get("Authorization"));

    // No requests should have been made since AWS credentials and region is passed through
    // environment variables.
    List<MockLowLevelHttpRequest> requests = transportFactory.transport.getRequests();
    assertEquals(0, requests.size());
  }

  @Test
  void retrieveSubjectToken_imdsv2EnvVariablesSet_metadataServerNotCalled() throws IOException {
    MockExternalAccountCredentialsTransportFactory transportFactory =
        new MockExternalAccountCredentialsTransportFactory();

    // Provide AWS credentials through environment vars.
    TestEnvironmentProvider environmentProvider = new TestEnvironmentProvider();
    environmentProvider
        .setEnv("AWS_REGION", "awsRegion")
        .setEnv("AWS_ACCESS_KEY_ID", "awsAccessKeyId")
        .setEnv("AWS_SECRET_ACCESS_KEY", "awsSecretAccessKey")
        .setEnv("AWS_SESSION_TOKEN", "awsToken");

    AwsCredentials awsCredential =
        AwsCredentials.newBuilder(AWS_CREDENTIAL)
            .setHttpTransportFactory(transportFactory)
            .setCredentialSource(buildAwsImdsv2CredentialSource(transportFactory))
            .setEnvironmentProvider(environmentProvider)
            .build();

    String subjectToken = URLDecoder.decode(awsCredential.retrieveSubjectToken(), "UTF-8");

    JsonParser parser = OAuth2Utils.JSON_FACTORY.createJsonParser(subjectToken);
    GenericJson json = parser.parseAndClose(GenericJson.class);

    List<Map<String, String>> headersList = (List<Map<String, String>>) json.get("headers");
    Map<String, String> headers = new HashMap<>();
    for (Map<String, String> header : headersList) {
      headers.put(header.get("key"), header.get("value"));
    }

    assertEquals("POST", json.get("method"));
    assertEquals(GET_CALLER_IDENTITY_URL, json.get("url"));
    assertEquals(URI.create(GET_CALLER_IDENTITY_URL).getHost(), headers.get("host"));
    assertEquals("awsToken", headers.get("x-amz-security-token"));
    assertEquals(awsCredential.getAudience(), headers.get("x-goog-cloud-target-resource"));
    assertTrue(headers.containsKey("x-amz-date"));
    assertNotNull(headers.get("Authorization"));

    // No requests should have been made since AWS credentials and region is passed through
    // environment variables.
    List<MockLowLevelHttpRequest> requests = transportFactory.transport.getRequests();
    assertEquals(0, requests.size());
  }

  @Test
  void retrieveSubjectToken_noRegion_expectThrows() {
    MockExternalAccountCredentialsTransportFactory transportFactory =
        new MockExternalAccountCredentialsTransportFactory();

    IOException response = new IOException();
    transportFactory.transport.addResponseErrorSequence(response);

    AwsCredentials awsCredential =
        AwsCredentials.newBuilder(AWS_CREDENTIAL)
            .setHttpTransportFactory(transportFactory)
            .setCredentialSource(buildAwsCredentialSource(transportFactory))
            .build();

    IOException exception = assertThrows(IOException.class, awsCredential::retrieveSubjectToken);
    assertEquals("Failed to retrieve AWS region.", exception.getMessage());

    List<MockLowLevelHttpRequest> requests = transportFactory.transport.getRequests();
    assertEquals(1, requests.size());

    // Validate region request.
    ValidateRequest(requests.get(0), AWS_REGION_URL, EMPTY_STRING_HEADERS);
  }

  @Test
  void retrieveSubjectToken_noRole_expectThrows() {
    MockExternalAccountCredentialsTransportFactory transportFactory =
        new MockExternalAccountCredentialsTransportFactory();

    IOException response = new IOException();
    transportFactory.transport.addResponseErrorSequence(response);
    transportFactory.transport.addResponseSequence(true, false);

    AwsCredentials awsCredential =
        AwsCredentials.newBuilder(AWS_CREDENTIAL)
            .setHttpTransportFactory(transportFactory)
            .setCredentialSource(buildAwsCredentialSource(transportFactory))
            .build();

    IOException exception = assertThrows(IOException.class, awsCredential::retrieveSubjectToken);
    assertEquals("Failed to retrieve AWS IAM role.", exception.getMessage());

    List<MockLowLevelHttpRequest> requests = transportFactory.transport.getRequests();
    assertEquals(2, requests.size());

    // Validate region request.
    ValidateRequest(requests.get(0), AWS_REGION_URL, EMPTY_STRING_HEADERS);

    // Validate role request.
    ValidateRequest(requests.get(1), AWS_CREDENTIALS_URL, EMPTY_STRING_HEADERS);
  }

  @Test
  void retrieveSubjectToken_noCredentials_expectThrows() {
    MockExternalAccountCredentialsTransportFactory transportFactory =
        new MockExternalAccountCredentialsTransportFactory();

    IOException response = new IOException();
    transportFactory.transport.addResponseErrorSequence(response);
    transportFactory.transport.addResponseSequence(true, true, false);

    AwsCredentials awsCredential =
        AwsCredentials.newBuilder(AWS_CREDENTIAL)
            .setHttpTransportFactory(transportFactory)
            .setCredentialSource(buildAwsCredentialSource(transportFactory))
            .build();

    IOException exception = assertThrows(IOException.class, awsCredential::retrieveSubjectToken);
    assertEquals("Failed to retrieve AWS credentials.", exception.getMessage());

    List<MockLowLevelHttpRequest> requests = transportFactory.transport.getRequests();
    assertEquals(3, requests.size());

    // Validate region request.
    ValidateRequest(requests.get(0), AWS_REGION_URL, EMPTY_STRING_HEADERS);

    // Validate role request.
    ValidateRequest(requests.get(1), AWS_CREDENTIALS_URL, EMPTY_STRING_HEADERS);

    // Validate security credentials request.
    ValidateRequest(requests.get(2), AWS_CREDENTIALS_URL_WITH_ROLE, EMPTY_STRING_HEADERS);
  }

  @Test
  void retrieveSubjectToken_noRegionUrlProvided() {
    MockExternalAccountCredentialsTransportFactory transportFactory =
        new MockExternalAccountCredentialsTransportFactory();

    Map<String, Object> credentialSource = new HashMap<>();
    credentialSource.put("environment_id", "aws1");
    credentialSource.put("regional_cred_verification_url", GET_CALLER_IDENTITY_URL);

    AwsCredentials awsCredential =
        AwsCredentials.newBuilder(AWS_CREDENTIAL)
            .setHttpTransportFactory(transportFactory)
            .setCredentialSource(new AwsCredentialSource(credentialSource))
            .build();

    IOException exception = assertThrows(IOException.class, awsCredential::retrieveSubjectToken);
    assertEquals(
        "Unable to determine the AWS region. The credential source does not "
            + "contain the region URL.",
        exception.getMessage());

    // No requests because the credential source does not contain region URL.
    List<MockLowLevelHttpRequest> requests = transportFactory.transport.getRequests();
    assertTrue(requests.isEmpty());
  }

  @Test
  void retrieveSubjectToken_withProgrammaticRefresh() throws IOException {
    MockExternalAccountCredentialsTransportFactory transportFactory =
        new MockExternalAccountCredentialsTransportFactory();

    AwsSecurityCredentialsSupplier supplier =
        new TestAwsSecurityCredentialsSupplier("test", programmaticAwsCreds, null, null);

    AwsCredentials awsCredential =
        AwsCredentials.newBuilder()
            .setAwsSecurityCredentialsSupplier(supplier)
            .setHttpTransportFactory(transportFactory)
            .setAudience("audience")
            .setTokenUrl(STS_URL)
            .setSubjectTokenType("subjectTokenType")
            .build();

    String subjectToken = URLDecoder.decode(awsCredential.retrieveSubjectToken(), "UTF-8");

    JsonParser parser = OAuth2Utils.JSON_FACTORY.createJsonParser(subjectToken);
    GenericJson json = parser.parseAndClose(GenericJson.class);

    List<Map<String, String>> headersList = (List<Map<String, String>>) json.get("headers");
    Map<String, String> headers = new HashMap<>();
    for (Map<String, String> header : headersList) {
      headers.put(header.get("key"), header.get("value"));
    }

    String expectedCredentialVerificationUrl =
        DEFAULT_REGIONAL_CREDENTIAL_VERIFICATION_URL.replace("{region}", "test");

    assertEquals("POST", json.get("method"));
    assertEquals(expectedCredentialVerificationUrl, json.get("url"));
    assertEquals(URI.create(expectedCredentialVerificationUrl).getHost(), headers.get("host"));
    assertEquals(awsCredential.getAudience(), headers.get("x-goog-cloud-target-resource"));
    assertTrue(headers.containsKey("x-amz-date"));
    assertNotNull(headers.get("Authorization"));
  }

  @Test
  void retrieveSubjectToken_withProgrammaticRefreshSessionToken() throws IOException {
    MockExternalAccountCredentialsTransportFactory transportFactory =
        new MockExternalAccountCredentialsTransportFactory();

    AwsSecurityCredentials securityCredentialsWithToken =
        new AwsSecurityCredentials("accessToken", "secretAccessKey", "token");

    AwsSecurityCredentialsSupplier supplier =
        new TestAwsSecurityCredentialsSupplier("test", securityCredentialsWithToken, null, null);

    AwsCredentials awsCredential =
        AwsCredentials.newBuilder()
            .setAwsSecurityCredentialsSupplier(supplier)
            .setHttpTransportFactory(transportFactory)
            .setAudience("audience")
            .setTokenUrl(STS_URL)
            .setSubjectTokenType("subjectTokenType")
            .build();

    String subjectToken = URLDecoder.decode(awsCredential.retrieveSubjectToken(), "UTF-8");

    JsonParser parser = OAuth2Utils.JSON_FACTORY.createJsonParser(subjectToken);
    GenericJson json = parser.parseAndClose(GenericJson.class);

    List<Map<String, String>> headersList = (List<Map<String, String>>) json.get("headers");
    Map<String, String> headers = new HashMap<>();
    for (Map<String, String> header : headersList) {
      headers.put(header.get("key"), header.get("value"));
    }

    String expectedCredentialVerificationUrl =
        DEFAULT_REGIONAL_CREDENTIAL_VERIFICATION_URL.replace("{region}", "test");

    assertEquals("POST", json.get("method"));
    assertEquals(expectedCredentialVerificationUrl, json.get("url"));
    assertEquals(URI.create(expectedCredentialVerificationUrl).getHost(), headers.get("host"));
    assertEquals("token", headers.get("x-amz-security-token"));
    assertEquals(awsCredential.getAudience(), headers.get("x-goog-cloud-target-resource"));
    assertTrue(headers.containsKey("x-amz-date"));
    assertNotNull(headers.get("Authorization"));
  }

  @Test
  void retrieveSubjectToken_passesContext() {
    MockExternalAccountCredentialsTransportFactory transportFactory =
        new MockExternalAccountCredentialsTransportFactory();

    AwsSecurityCredentials securityCredentialsWithToken =
        new AwsSecurityCredentials("accessToken", "secretAccessKey", "token");

    ExternalAccountSupplierContext expectedContext =
        ExternalAccountSupplierContext.newBuilder()
            .setAudience("audience")
            .setSubjectTokenType("subjectTokenType")
            .build();

    AwsSecurityCredentialsSupplier supplier =
        new TestAwsSecurityCredentialsSupplier(
            "test", securityCredentialsWithToken, null, expectedContext);

    AwsCredentials awsCredential =
        AwsCredentials.newBuilder()
            .setAwsSecurityCredentialsSupplier(supplier)
            .setHttpTransportFactory(transportFactory)
            .setAudience("audience")
            .setTokenUrl(STS_URL)
            .setSubjectTokenType("subjectTokenType")
            .build();

    assertDoesNotThrow(awsCredential::retrieveSubjectToken);
  }

  @Test
  void retrieveSubjectToken_withProgrammaticRefreshThrowsError() {
    MockExternalAccountCredentialsTransportFactory transportFactory =
        new MockExternalAccountCredentialsTransportFactory();

    IOException testException = new IOException("test");

    AwsSecurityCredentialsSupplier supplier =
        new TestAwsSecurityCredentialsSupplier("test", null, testException, null);

    AwsCredentials awsCredential =
        AwsCredentials.newBuilder()
            .setAwsSecurityCredentialsSupplier(supplier)
            .setHttpTransportFactory(transportFactory)
            .setAudience("audience")
            .setTokenUrl(STS_URL)
            .setSubjectTokenType("subjectTokenType")
            .build();

    IOException exception = assertThrows(IOException.class, awsCredential::retrieveSubjectToken);
    assertEquals("test", exception.getMessage());
  }

  @Test
  void getAwsSecurityCredentials_fromEnvironmentVariablesNoToken() throws IOException {
    TestEnvironmentProvider environmentProvider = new TestEnvironmentProvider();
    environmentProvider
        .setEnv("AWS_ACCESS_KEY_ID", "awsAccessKeyId")
        .setEnv("AWS_SECRET_ACCESS_KEY", "awsSecretAccessKey");

    AwsCredentials testAwsCredentials =
        AwsCredentials.newBuilder(AWS_CREDENTIAL)
            .setEnvironmentProvider(environmentProvider)
            .build();

    AwsSecurityCredentials credentials =
        testAwsCredentials.getAwsSecurityCredentialsSupplier().getCredentials(emptyContext);

    assertEquals("awsAccessKeyId", credentials.getAccessKeyId());
    assertEquals("awsSecretAccessKey", credentials.getSecretAccessKey());
    assertNull(credentials.getSessionToken());
  }

  @Test
  void getAwsSecurityCredentials_fromEnvironmentVariablesWithToken() throws IOException {
    TestEnvironmentProvider environmentProvider = new TestEnvironmentProvider();
    environmentProvider
        .setEnv("AWS_ACCESS_KEY_ID", "awsAccessKeyId")
        .setEnv("AWS_SECRET_ACCESS_KEY", "awsSecretAccessKey")
        .setEnv("AWS_SESSION_TOKEN", "awsSessionToken");

    AwsCredentialSource credSource =
        new AwsCredentialSource(
            new HashMap<String, Object>() {
              {
                put("environment_id", "aws1");
                put("region_url", "");
                put("url", "");
                put("regional_cred_verification_url", "regionalCredVerificationUrl");
              }
            });

    AwsCredentials testAwsCredentials =
        AwsCredentials.newBuilder(AWS_CREDENTIAL)
            .setEnvironmentProvider(environmentProvider)
            .setCredentialSource(credSource)
            .build();

    AwsSecurityCredentials credentials =
        testAwsCredentials.getAwsSecurityCredentialsSupplier().getCredentials(emptyContext);

    assertEquals("awsAccessKeyId", credentials.getAccessKeyId());
    assertEquals("awsSecretAccessKey", credentials.getSecretAccessKey());
    assertEquals("awsSessionToken", credentials.getSessionToken());
  }

  @Test
  void getAwsSecurityCredentials_fromEnvironmentVariables_noMetadataServerCall()
      throws IOException {
    TestEnvironmentProvider environmentProvider = new TestEnvironmentProvider();
    environmentProvider
        .setEnv("AWS_ACCESS_KEY_ID", "awsAccessKeyId")
        .setEnv("AWS_SECRET_ACCESS_KEY", "awsSecretAccessKey")
        .setEnv("AWS_SESSION_TOKEN", "awsSessionToken");

    AwsCredentials testAwsCredentials =
        AwsCredentials.newBuilder(AWS_CREDENTIAL)
            .setEnvironmentProvider(environmentProvider)
            .build();

    AwsSecurityCredentials credentials =
        testAwsCredentials.getAwsSecurityCredentialsSupplier().getCredentials(emptyContext);

    assertEquals("awsAccessKeyId", credentials.getAccessKeyId());
    assertEquals("awsSecretAccessKey", credentials.getSecretAccessKey());
    assertEquals("awsSessionToken", credentials.getSessionToken());
  }

  @Test
  void getAwsSecurityCredentials_fromMetadataServer() throws IOException {
    MockExternalAccountCredentialsTransportFactory transportFactory =
        new MockExternalAccountCredentialsTransportFactory();

    AwsCredentials awsCredential =
        AwsCredentials.newBuilder(AWS_CREDENTIAL)
            .setHttpTransportFactory(transportFactory)
            .setCredentialSource(buildAwsCredentialSource(transportFactory))
            .build();

    AwsSecurityCredentials credentials =
        awsCredential.getAwsSecurityCredentialsSupplier().getCredentials(emptyContext);

    assertEquals("accessKeyId", credentials.getAccessKeyId());
    assertEquals("secretAccessKey", credentials.getSecretAccessKey());
    assertEquals("token", credentials.getSessionToken());

    List<MockLowLevelHttpRequest> requests = transportFactory.transport.getRequests();
    assertEquals(2, requests.size());

    // Validate role request.
    ValidateRequest(requests.get(0), AWS_CREDENTIALS_URL, EMPTY_STRING_HEADERS);

    // Validate security credentials request.
    ValidateRequest(requests.get(1), AWS_CREDENTIALS_URL_WITH_ROLE, EMPTY_STRING_HEADERS);
  }

  @Test
  void getAwsSecurityCredentials_fromMetadataServer_noUrlProvided() {
    MockExternalAccountCredentialsTransportFactory transportFactory =
        new MockExternalAccountCredentialsTransportFactory();

    Map<String, Object> credentialSource = new HashMap<>();
    credentialSource.put("environment_id", "aws1");
    credentialSource.put("regional_cred_verification_url", GET_CALLER_IDENTITY_URL);

    AwsCredentials awsCredential =
        AwsCredentials.newBuilder(AWS_CREDENTIAL)
            .setHttpTransportFactory(transportFactory)
            .setCredentialSource(new AwsCredentialSource(credentialSource))
            .build();

    IOException exception =
        assertThrows(
            IOException.class,
            () -> awsCredential.getAwsSecurityCredentialsSupplier().getCredentials(emptyContext));
    assertEquals(
        "Unable to determine the AWS IAM role name. The credential source does not contain the url field.",
        exception.getMessage());

    // No requests because url field is not present in credential source.
    List<MockLowLevelHttpRequest> requests = transportFactory.transport.getRequests();
    assertTrue(requests.isEmpty());
  }

  @Test
  void getAwsRegion_awsRegionEnvironmentVariable() throws IOException {
    TestEnvironmentProvider environmentProvider = new TestEnvironmentProvider();
    environmentProvider.setEnv("AWS_REGION", "region");
    environmentProvider.setEnv("AWS_DEFAULT_REGION", "defaultRegion");

    MockExternalAccountCredentialsTransportFactory transportFactory =
        new MockExternalAccountCredentialsTransportFactory();
    AwsCredentials awsCredentials =
        AwsCredentials.newBuilder(AWS_CREDENTIAL)
            .setHttpTransportFactory(transportFactory)
            .setCredentialSource(buildAwsCredentialSource(transportFactory))
            .setEnvironmentProvider(environmentProvider)
            .build();

    String region = awsCredentials.getAwsSecurityCredentialsSupplier().getRegion(emptyContext);

    // Should attempt to retrieve the region from AWS_REGION env var first.
    // Metadata server would return us-east-1b.
    assertEquals("region", region);

    // No requests because region is obtained from environment variables.
    List<MockLowLevelHttpRequest> requests = transportFactory.transport.getRequests();
    assertTrue(requests.isEmpty());
  }

  @Test
  void getAwsRegion_awsDefaultRegionEnvironmentVariable() throws IOException {
    TestEnvironmentProvider environmentProvider = new TestEnvironmentProvider();
    environmentProvider.setEnv("AWS_DEFAULT_REGION", "defaultRegion");

    MockExternalAccountCredentialsTransportFactory transportFactory =
        new MockExternalAccountCredentialsTransportFactory();
    AwsCredentials awsCredentials =
        AwsCredentials.newBuilder(AWS_CREDENTIAL)
            .setHttpTransportFactory(transportFactory)
            .setCredentialSource(buildAwsCredentialSource(transportFactory))
            .setEnvironmentProvider(environmentProvider)
            .build();

    String region = awsCredentials.getAwsSecurityCredentialsSupplier().getRegion(emptyContext);

    // Should attempt to retrieve the region from DEFAULT_AWS_REGION before calling the metadata
    // server. Metadata server would return us-east-1b.
    assertEquals("defaultRegion", region);

    // No requests because region is obtained from environment variables.
    List<MockLowLevelHttpRequest> requests = transportFactory.transport.getRequests();
    assertTrue(requests.isEmpty());
  }

  @Test
  void getAwsRegion_metadataServer() throws IOException {
    MockExternalAccountCredentialsTransportFactory transportFactory =
        new MockExternalAccountCredentialsTransportFactory();
    AwsCredentials awsCredentials =
        AwsCredentials.newBuilder(AWS_CREDENTIAL)
            .setHttpTransportFactory(transportFactory)
            .setCredentialSource(buildAwsCredentialSource(transportFactory))
            .build();

    String region = awsCredentials.getAwsSecurityCredentialsSupplier().getRegion(emptyContext);

    // Should retrieve the region from the Metadata server.
    String expectedRegion =
        transportFactory
            .transport
            .getAwsRegion()
            .substring(0, transportFactory.transport.getAwsRegion().length() - 1);
    assertEquals(expectedRegion, region);

    List<MockLowLevelHttpRequest> requests = transportFactory.transport.getRequests();
    assertEquals(1, requests.size());

    // Validate region request.
    ValidateRequest(requests.get(0), AWS_REGION_URL, EMPTY_STRING_HEADERS);
  }

  @Test
  void createdScoped_clonedCredentialWithAddedScopes() {
    AwsCredentials credentials =
        AwsCredentials.newBuilder(AWS_CREDENTIAL)
            .setServiceAccountImpersonationUrl(SERVICE_ACCOUNT_IMPERSONATION_URL)
            .setQuotaProjectId("quotaProjectId")
            .setClientId("clientId")
            .setClientSecret("clientSecret")
            .setUniverseDomain("universeDomain")
            .build();

    List<String> newScopes = Arrays.asList("scope1", "scope2");

    AwsCredentials newCredentials = (AwsCredentials) credentials.createScoped(newScopes);

    assertEquals(credentials.getAudience(), newCredentials.getAudience());
    assertEquals(credentials.getSubjectTokenType(), newCredentials.getSubjectTokenType());
    assertEquals(credentials.getTokenUrl(), newCredentials.getTokenUrl());
    assertEquals(credentials.getTokenInfoUrl(), newCredentials.getTokenInfoUrl());
    assertEquals(
        credentials.getServiceAccountImpersonationUrl(),
        newCredentials.getServiceAccountImpersonationUrl());
    assertEquals(credentials.getCredentialSource(), newCredentials.getCredentialSource());
    assertEquals(credentials.getQuotaProjectId(), newCredentials.getQuotaProjectId());
    assertEquals(credentials.getClientId(), newCredentials.getClientId());
    assertEquals(credentials.getClientSecret(), newCredentials.getClientSecret());
    assertEquals(newScopes, newCredentials.getScopes());
    assertEquals(credentials.getUniverseDomain(), newCredentials.getUniverseDomain());
    assertEquals("universeDomain", newCredentials.getUniverseDomain());
  }

  @Test
  void credentialSource_invalidAwsEnvironmentId() {
    Map<String, Object> credentialSource = new HashMap<>();
    credentialSource.put("regional_cred_verification_url", GET_CALLER_IDENTITY_URL);
    credentialSource.put("environment_id", "azure1");

    IllegalArgumentException exception =
        assertThrows(
            IllegalArgumentException.class, () -> new AwsCredentialSource(credentialSource));
    assertEquals("Invalid AWS environment ID.", exception.getMessage());
  }

  @Test
  void credentialSource_invalidAwsEnvironmentVersion() {
    Map<String, Object> credentialSource = new HashMap<>();
    int environmentVersion = 2;
    credentialSource.put("regional_cred_verification_url", GET_CALLER_IDENTITY_URL);
    credentialSource.put("environment_id", "aws" + environmentVersion);

    IllegalArgumentException exception =
        assertThrows(
            IllegalArgumentException.class, () -> new AwsCredentialSource(credentialSource));
    assertEquals(
        String.format("AWS version %s is not supported in the current build.", environmentVersion),
        exception.getMessage());
  }

  @Test
  void credentialSource_missingRegionalCredVerificationUrl() {
    HashMap<String, Object> credentialSourceMap = new HashMap<>();
    IllegalArgumentException exception =
        assertThrows(
            IllegalArgumentException.class, () -> new AwsCredentialSource(credentialSourceMap));
    assertEquals(
        "A regional_cred_verification_url representing the GetCallerIdentity action URL must be specified.",
        exception.getMessage());
  }

  @Test
  void builder_allFields() {
    List<String> scopes = Arrays.asList("scope1", "scope2");

    AwsCredentials credentials =
        AwsCredentials.newBuilder()
            .setHttpTransportFactory(OAuth2Utils.HTTP_TRANSPORT_FACTORY)
            .setAudience("audience")
            .setSubjectTokenType("subjectTokenType")
            .setTokenUrl(STS_URL)
            .setTokenInfoUrl("tokenInfoUrl")
            .setCredentialSource(AWS_CREDENTIAL_SOURCE)
            .setTokenInfoUrl("tokenInfoUrl")
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
    assertEquals(AWS_CREDENTIAL_SOURCE, credentials.getCredentialSource());
    assertEquals("quotaProjectId", credentials.getQuotaProjectId());
    assertEquals("clientId", credentials.getClientId());
    assertEquals("clientSecret", credentials.getClientSecret());
    assertEquals(scopes, credentials.getScopes());
    assertEquals(SystemEnvironmentProvider.getInstance(), credentials.getEnvironmentProvider());
    assertEquals("universeDomain", credentials.getUniverseDomain());
  }

  @Test
  void builder_missingUniverseDomain_defaults() {
    List<String> scopes = Arrays.asList("scope1", "scope2");

    AwsCredentials credentials =
        AwsCredentials.newBuilder()
            .setRegionalCredentialVerificationUrlOverride("https://test.com")
            .setHttpTransportFactory(OAuth2Utils.HTTP_TRANSPORT_FACTORY)
            .setAudience("audience")
            .setSubjectTokenType("subjectTokenType")
            .setTokenUrl(STS_URL)
            .setTokenInfoUrl("tokenInfoUrl")
            .setCredentialSource(AWS_CREDENTIAL_SOURCE)
            .setTokenInfoUrl("tokenInfoUrl")
            .setServiceAccountImpersonationUrl(SERVICE_ACCOUNT_IMPERSONATION_URL)
            .setQuotaProjectId("quotaProjectId")
            .setClientId("clientId")
            .setClientSecret("clientSecret")
            .setScopes(scopes)
            .build();

    assertEquals("https://test.com", credentials.getRegionalCredentialVerificationUrlOverride());
    assertEquals("audience", credentials.getAudience());
    assertEquals("subjectTokenType", credentials.getSubjectTokenType());
    assertEquals(STS_URL, credentials.getTokenUrl());
    assertEquals("tokenInfoUrl", credentials.getTokenInfoUrl());
    assertEquals(
        SERVICE_ACCOUNT_IMPERSONATION_URL, credentials.getServiceAccountImpersonationUrl());
    assertEquals(AWS_CREDENTIAL_SOURCE, credentials.getCredentialSource());
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

    AwsCredentials credentials =
        AwsCredentials.newBuilder()
            .setHttpTransportFactory(OAuth2Utils.HTTP_TRANSPORT_FACTORY)
            .setAudience("audience")
            .setSubjectTokenType("subjectTokenType")
            .setTokenUrl(STS_URL)
            .setTokenInfoUrl("tokenInfoUrl")
            .setCredentialSource(AWS_CREDENTIAL_SOURCE)
            .setTokenInfoUrl("tokenInfoUrl")
            .setServiceAccountImpersonationUrl(SERVICE_ACCOUNT_IMPERSONATION_URL)
            .setQuotaProjectId("quotaProjectId")
            .setClientId("clientId")
            .setClientSecret("clientSecret")
            .setScopes(scopes)
            .setUniverseDomain("universeDomain")
            .build();

    AwsCredentials newBuilderCreds = AwsCredentials.newBuilder(credentials).build();
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
    assertEquals(credentials.getUniverseDomain(), newBuilderCreds.getUniverseDomain());
  }

  @Test
  void newBuilder_noUniverseDomain_defaults() {
    List<String> scopes = Arrays.asList("scope1", "scope2");

    AwsCredentials credentials =
        AwsCredentials.newBuilder()
            .setHttpTransportFactory(OAuth2Utils.HTTP_TRANSPORT_FACTORY)
            .setAudience("audience")
            .setSubjectTokenType("subjectTokenType")
            .setTokenUrl(STS_URL)
            .setTokenInfoUrl("tokenInfoUrl")
            .setCredentialSource(AWS_CREDENTIAL_SOURCE)
            .setTokenInfoUrl("tokenInfoUrl")
            .setServiceAccountImpersonationUrl(SERVICE_ACCOUNT_IMPERSONATION_URL)
            .setQuotaProjectId("quotaProjectId")
            .setClientId("clientId")
            .setClientSecret("clientSecret")
            .setScopes(scopes)
            .build();

    AwsCredentials newBuilderCreds = AwsCredentials.newBuilder(credentials).build();
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
    assertEquals(GOOGLE_DEFAULT_UNIVERSE, newBuilderCreds.getUniverseDomain());
  }

  @Test
  void builder_defaultRegionalCredentialVerificationUrlOverride() {
    List<String> scopes = Arrays.asList("scope1", "scope2");

    AwsSecurityCredentialsSupplier supplier =
        new TestAwsSecurityCredentialsSupplier("region", null, null, null);

    AwsCredentials credentials =
        AwsCredentials.newBuilder()
            .setAwsSecurityCredentialsSupplier(supplier)
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

    assertNull(credentials.getRegionalCredentialVerificationUrlOverride());
    assertEquals(
        DEFAULT_REGIONAL_CREDENTIAL_VERIFICATION_URL,
        credentials.getRegionalCredentialVerificationUrl());
  }

  @Test
  void builder_supplierAndCredSourceThrows() {
    List<String> scopes = Arrays.asList("scope1", "scope2");

    AwsSecurityCredentialsSupplier supplier =
        new TestAwsSecurityCredentialsSupplier("region", null, null, null);

    AwsCredentials.Builder builder =
        AwsCredentials.newBuilder()
            .setAwsSecurityCredentialsSupplier(supplier)
            .setHttpTransportFactory(OAuth2Utils.HTTP_TRANSPORT_FACTORY)
            .setAudience("audience")
            .setSubjectTokenType("subjectTokenType")
            .setTokenUrl(STS_URL)
            .setTokenInfoUrl("tokenInfoUrl")
            .setCredentialSource(AWS_CREDENTIAL_SOURCE)
            .setServiceAccountImpersonationUrl(SERVICE_ACCOUNT_IMPERSONATION_URL)
            .setQuotaProjectId("quotaProjectId")
            .setClientId("clientId")
            .setClientSecret("clientSecret")
            .setScopes(scopes);
    IllegalArgumentException exception =
        assertThrows(IllegalArgumentException.class, builder::build);
    assertEquals(
        "AwsCredentials cannot have both an awsSecurityCredentialsSupplier and a credentialSource.",
        exception.getMessage());
  }

  @Test
  void builder_noSupplieOrCredSourceThrows() {
    List<String> scopes = Arrays.asList("scope1", "scope2");

    AwsCredentials.Builder builder =
        AwsCredentials.newBuilder()
            .setHttpTransportFactory(OAuth2Utils.HTTP_TRANSPORT_FACTORY)
            .setAudience("audience")
            .setSubjectTokenType("subjectTokenType")
            .setTokenUrl(STS_URL)
            .setTokenInfoUrl("tokenInfoUrl")
            .setTokenInfoUrl("tokenInfoUrl")
            .setServiceAccountImpersonationUrl(SERVICE_ACCOUNT_IMPERSONATION_URL)
            .setQuotaProjectId("quotaProjectId")
            .setClientId("clientId")
            .setClientSecret("clientSecret")
            .setScopes(scopes);
    IllegalArgumentException exception =
        assertThrows(IllegalArgumentException.class, builder::build);
    assertEquals(
        "An awsSecurityCredentialsSupplier or a credentialSource must be provided.",
        exception.getMessage());
  }

  @Test
  void serialize() throws IOException, ClassNotFoundException {
    List<String> scopes = Arrays.asList("scope1", "scope2");

    AwsCredentials testCredentials =
        AwsCredentials.newBuilder()
            .setHttpTransportFactory(OAuth2Utils.HTTP_TRANSPORT_FACTORY)
            .setAudience("audience")
            .setSubjectTokenType("subjectTokenType")
            .setTokenUrl(STS_URL)
            .setTokenInfoUrl("tokenInfoUrl")
            .setCredentialSource(AWS_CREDENTIAL_SOURCE)
            .setTokenInfoUrl("tokenInfoUrl")
            .setServiceAccountImpersonationUrl(SERVICE_ACCOUNT_IMPERSONATION_URL)
            .setQuotaProjectId("quotaProjectId")
            .setClientId("clientId")
            .setClientSecret("clientSecret")
            .setUniverseDomain("universeDomain")
            .setScopes(scopes)
            .build();

    AwsCredentials deserializedCredentials = serializeAndDeserialize(testCredentials);
    assertEquals(testCredentials, deserializedCredentials);
    assertEquals(testCredentials.hashCode(), deserializedCredentials.hashCode());
    assertEquals(testCredentials.toString(), deserializedCredentials.toString());
    assertSame(Clock.SYSTEM, deserializedCredentials.clock);
  }

  private static void ValidateRequest(
      MockLowLevelHttpRequest request, String expectedUrl, Map<String, String> expectedHeaders) {
    assertEquals(expectedUrl, request.getUrl());
    Map<String, List<String>> actualHeaders = request.getHeaders();

    for (Map.Entry<String, String> expectedHeader : expectedHeaders.entrySet()) {
      assertTrue(actualHeaders.containsKey(expectedHeader.getKey()));
      List<String> actualValues = actualHeaders.get(expectedHeader.getKey());
      assertEquals(1, actualValues.size());
      assertEquals(expectedHeader.getValue(), actualValues.get(0));
    }
  }

  private static Map<String, Object> buildAwsCredentialSourceMap(
      MockExternalAccountCredentialsTransportFactory transportFactory) {
    Map<String, Object> credentialSourceMap = new HashMap<>();
    credentialSourceMap.put("environment_id", "aws1");
    credentialSourceMap.put("region_url", transportFactory.transport.getAwsRegionUrl());
    credentialSourceMap.put("url", transportFactory.transport.getAwsCredentialsUrl());
    credentialSourceMap.put("regional_cred_verification_url", GET_CALLER_IDENTITY_URL);
    return credentialSourceMap;
  }

  private static AwsCredentialSource buildAwsCredentialSource(
      MockExternalAccountCredentialsTransportFactory transportFactory) {
    return new AwsCredentialSource(buildAwsCredentialSourceMap(transportFactory));
  }

  static AwsCredentialSource buildAwsImdsv2CredentialSource(
      MockExternalAccountCredentialsTransportFactory transportFactory) {
    Map<String, Object> credentialSourceMap = buildAwsCredentialSourceMap(transportFactory);
    credentialSourceMap.put(
        "imdsv2_session_token_url", transportFactory.transport.getAwsImdsv2SessionTokenUrl());
    return new AwsCredentialSource(credentialSourceMap);
  }

  private static Map<String, Object> buildAwsIpv6CredentialSourceMap() {
    String regionUrl = "http://[fd00:ec2::254]/region";
    String url = "http://[fd00:ec2::254]";
    String imdsv2SessionTokenUrl = "http://[fd00:ec2::254]/imdsv2";
    Map<String, Object> credentialSourceMap = new HashMap<>();
    credentialSourceMap.put("environment_id", "aws1");
    credentialSourceMap.put("region_url", regionUrl);
    credentialSourceMap.put("url", url);
    credentialSourceMap.put("imdsv2_session_token_url", imdsv2SessionTokenUrl);
    credentialSourceMap.put("regional_cred_verification_url", GET_CALLER_IDENTITY_URL);

    return credentialSourceMap;
  }

  static InputStream writeAwsCredentialsStream(String stsUrl, String regionUrl, String metadataUrl)
      throws IOException {
    GenericJson json = new GenericJson();
    json.put("audience", "audience");
    json.put("subject_token_type", "subjectTokenType");
    json.put("token_url", stsUrl);
    json.put("token_info_url", "tokenInfoUrl");
    json.put("type", GoogleCredentialsInfo.EXTERNAL_ACCOUNT_CREDENTIALS.getFileType());

    GenericJson credentialSource = new GenericJson();
    credentialSource.put("environment_id", "aws1");
    credentialSource.put("region_url", regionUrl);
    credentialSource.put("url", metadataUrl);
    credentialSource.put("regional_cred_verification_url", GET_CALLER_IDENTITY_URL);
    json.put("credential_source", credentialSource);

    return TestUtils.jsonToInputStream(json);
  }

  static class TestAwsSecurityCredentialsSupplier implements AwsSecurityCredentialsSupplier {

    private final String region;
    private final AwsSecurityCredentials credentials;
    private final IOException credentialException;
    private final ExternalAccountSupplierContext expectedContext;

    TestAwsSecurityCredentialsSupplier(
        String region,
        AwsSecurityCredentials credentials,
        IOException credentialException,
        ExternalAccountSupplierContext expectedContext) {
      this.region = region;
      this.credentials = credentials;
      this.credentialException = credentialException;
      this.expectedContext = expectedContext;
    }

    @Override
    public String getRegion(ExternalAccountSupplierContext context) throws IOException {
      if (expectedContext != null) {
        assertEquals(expectedContext.getAudience(), context.getAudience());
        assertEquals(expectedContext.getSubjectTokenType(), context.getSubjectTokenType());
      }
      return region;
    }

    @Override
    public AwsSecurityCredentials getCredentials(ExternalAccountSupplierContext context)
        throws IOException {
      if (credentialException != null) {
        throw credentialException;
      }
      if (expectedContext != null) {
        assertEquals(expectedContext.getAudience(), context.getAudience());
        assertEquals(expectedContext.getSubjectTokenType(), context.getSubjectTokenType());
      }
      return credentials;
    }
  }
}
