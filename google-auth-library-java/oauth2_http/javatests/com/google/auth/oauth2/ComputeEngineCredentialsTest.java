/*
 * Copyright 2015, Google Inc. All rights reserved.
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
 *    * Neither the name of Google Inc. nor the names of its
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

import static com.google.auth.oauth2.ComputeEngineCredentials.METADATA_RESPONSE_EMPTY_CONTENT_ERROR_MESSAGE;
import static com.google.auth.oauth2.ImpersonatedCredentialsTest.SA_CLIENT_EMAIL;
import static org.junit.jupiter.api.Assertions.assertArrayEquals;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.junit.jupiter.api.Assertions.fail;

import com.google.api.client.http.HttpStatusCodes;
import com.google.api.client.http.HttpTransport;
import com.google.api.client.http.LowLevelHttpRequest;
import com.google.api.client.http.LowLevelHttpResponse;
import com.google.api.client.json.webtoken.JsonWebToken.Payload;
import com.google.api.client.testing.http.MockLowLevelHttpRequest;
import com.google.api.client.testing.http.MockLowLevelHttpResponse;
import com.google.api.client.util.ArrayMap;
import com.google.api.client.util.Clock;
import com.google.auth.Credentials;
import com.google.auth.ServiceAccountSigner.SigningException;
import com.google.auth.TestUtils;
import com.google.auth.http.HttpTransportFactory;
import com.google.auth.oauth2.DefaultCredentialsProviderTest.MockRequestCountingTransportFactory;
import java.io.IOException;
import java.net.URI;
import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.Queue;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;
import org.junit.jupiter.api.Test;

/** Test case for {@link ComputeEngineCredentials}. */
class ComputeEngineCredentialsTest extends BaseSerializationTest {

  private static final URI CALL_URI = URI.create("http://googleapis.com/testapi/v1/foo");

  private static final String TOKEN_URL =
      "http://metadata.google.internal/computeMetadata/v1/instance/service-accounts/default/token";

  // Id Token which includes basic default claims
  public static final String STANDARD_ID_TOKEN =
      "eyJhbGciOiJSUzI1NiIsImtpZCI6ImRmMzc1ODkwOGI3OTIyO"
          + "TNhZDk3N2EwYjk5MWQ5OGE3N2Y0ZWVlY2QiLCJ0eXAiOiJKV1QifQ.eyJhdWQiOiJodHRwczovL2Zvby5iYXIiL"
          + "CJhenAiOiIxMDIxMDE1NTA4MzQyMDA3MDg1NjgiLCJleHAiOjE1NjQ0NzUwNTEsImlhdCI6MTU2NDQ3MTQ1MSwi"
          + "aXNzIjoiaHR0cHM6Ly9hY2NvdW50cy5nb29nbGUuY29tIiwic3ViIjoiMTAyMTAxNTUwODM0MjAwNzA4NTY4In0"
          + ".redacted";

  // Id Token which includes GCE extended claims
  public static final String FULL_ID_TOKEN =
      "eyJhbGciOiJSUzI1NiIsImtpZCI6ImRmMzc1ODkwOGI3OTIyOTNh"
          + "ZDk3N2EwYjk5MWQ5OGE3N2Y0ZWVlY2QiLCJ0eXAiOiJKV1QifQ.eyJhdWQiOiJodHRwczovL2Zvby5iYXIiLCJhe"
          + "nAiOiIxMTIxNzkwNjI3MjAzOTEzMDU4ODUiLCJlbWFpbCI6IjEwNzEyODQxODQ0MzYtY29tcHV0ZUBkZXZlbG9wZ"
          + "XIuZ3NlcnZpY2VhY2NvdW50LmNvbSIsImVtYWlsX3ZlcmlmaWVkIjp0cnVlLCJleHAiOjE1NjQ1MTk0OTYsImdvb"
          + "2dsZSI6eyJjb21wdXRlX2VuZ2luZSI6eyJpbnN0YW5jZV9jcmVhdGlvbl90aW1lc3RhbXAiOjE1NjMyMzA5MDcsI"
          + "mluc3RhbmNlX2lkIjoiMzQ5Nzk3NDM5MzQ0MTE3OTI0MyIsImluc3RhbmNlX25hbWUiOiJpYW0iLCJwcm9qZWN0X"
          + "2lkIjoibWluZXJhbC1taW51dGlhLTgyMCIsInByb2plY3RfbnVtYmVyIjoxMDcxMjg0MTg0NDM2LCJ6b25lIjoid"
          + "XMtY2VudHJhbDEtYSJ9fSwiaWF0IjoxNTY0NTE1ODk2LCJpc3MiOiJodHRwczovL2FjY291bnRzLmdvb2dsZS5jb"
          + "20iLCJzdWIiOiIxMTIxNzkwNjI3MjAzOTEzMDU4ODUifQ.redacted";

  // Id Token which includes GCE extended claims and any VM License data (if applicable)
  public static final String FULL_ID_TOKEN_WITH_LICENSES =
      "eyJhbGciOiJSUzI1NiIsImtpZCI6ImRmMzc1ODkwOG"
          + "I3OTIyOTNhZDk3N2EwYjk5MWQ5OGE3N2Y0ZWVlY2QiLCJ0eXAiOiJKV1QifQ.ew0KICAiYXVkIjogImh0dHBzOi8"
          + "vZm9vLmJhciIsDQogICJhenAiOiAiMTEyMTc5MDYyNzIwMzkxMzA1ODg1IiwNCiAgImVtYWlsIjogIjEyMzQ1Ni1"
          + "jb21wdXRlQGRldmVsb3Blci5nc2VydmljZWFjY291bnQuY29tIiwNCiAgImVtYWlsX3ZlcmlmaWVkIjogdHJ1ZSw"
          + "NCiAgImV4cCI6IDE1NjQ1MTk0OTYsDQogICJnb29nbGUiOiB7DQogICAgImNvbXB1dGVfZW5naW5lIjogew0KICA"
          + "gICAgImluc3RhbmNlX2NyZWF0aW9uX3RpbWVzdGFtcCI6IDE1NjMyMzA5MDcsDQogICAgICAiaW5zdGFuY2VfaWQ"
          + "iOiAiMzQ5Nzk3NDM5MzQ0MTE3OTI0MyIsDQogICAgICAiaW5zdGFuY2VfbmFtZSI6ICJpYW0iLA0KICAgICAgImx"
          + "pY2Vuc2VfaWQiOiBbDQogICAgICAgICIxMDAxMDAwIiwNCiAgICAgICAgIjEwMDEwMDEiLA0KICAgICAgICAiMTA"
          + "wMTAwOCINCiAgICAgIF0sDQogICAgICAicHJvamVjdF9pZCI6ICJmb28tYmFyLTgyMCIsDQogICAgICAicHJvamV"
          + "jdF9udW1iZXIiOiAxMDcxMjg0MTg0NDM2LA0KICAgICAgInpvbmUiOiAidXMtY2VudHJhbDEtYSINCiAgICB9DQo"
          + "gIH0sDQogICJpYXQiOiAxNTY0NTE1ODk2LA0KICAiaXNzIjogImh0dHBzOi8vYWNjb3VudHMuZ29vZ2xlLmNvbSI"
          + "sDQogICJzdWIiOiAiMTEyMTc5MDYyNzIwMzkxMzA1ODg1Ig0KfQ.redacted";
  private static final String ACCESS_TOKEN = "1/MkSJoj1xsli0AccessToken_NKPY2";
  private static final List<String> SCOPES = Arrays.asList("foo", "bar");
  private static final String ACCESS_TOKEN_WITH_SCOPES = "1/MkSJoj1xsli0AccessTokenScoped_NKPY2";
  private static final Map<String, String> SCOPE_TO_ACCESS_TOKEN_MAP =
      Stream.of(
              new String[][] {
                {"default", ACCESS_TOKEN},
                {SCOPES.toString().replaceAll("\\s", ""), ACCESS_TOKEN_WITH_SCOPES},
              })
          .collect(Collectors.toMap(data -> data[0], data -> data[1]));

  @Test
  void buildTokenUrlWithScopes_null_scopes() {
    ComputeEngineCredentials credentials =
        ComputeEngineCredentials.newBuilder().setScopes(null).build();
    Collection<String> scopes = credentials.getScopes();
    String tokenUrlWithScopes = credentials.createTokenUrlWithScopes();

    assertEquals(TOKEN_URL, tokenUrlWithScopes);
    assertTrue(scopes.isEmpty());
  }

  @Test
  void buildTokenUrlWithScopes_empty_scopes() {
    ComputeEngineCredentials.Builder builder =
        ComputeEngineCredentials.newBuilder().setScopes(Collections.<String>emptyList());
    ComputeEngineCredentials credentials = builder.build();
    Collection<String> scopes = credentials.getScopes();
    String tokenUrlWithScopes = credentials.createTokenUrlWithScopes();

    assertEquals(TOKEN_URL, tokenUrlWithScopes);
    assertTrue(scopes.isEmpty());
    assertTrue(builder.getScopes().isEmpty());
  }

  @Test
  void buildTokenUrlWithScopes_single_scope() {
    ComputeEngineCredentials credentials =
        ComputeEngineCredentials.newBuilder().setScopes(Arrays.asList("foo")).build();
    String tokenUrlWithScopes = credentials.createTokenUrlWithScopes();
    Collection<String> scopes = credentials.getScopes();

    assertEquals(TOKEN_URL + "?scopes=foo", tokenUrlWithScopes);
    assertEquals(1, scopes.size());
    assertEquals("foo", scopes.toArray()[0]);
  }

  @Test
  void buildTokenUrlWithScopes_multiple_scopes() {
    ComputeEngineCredentials credentials =
        ComputeEngineCredentials.newBuilder()
            .setScopes(Arrays.asList(null, "foo", "", "bar"))
            .build();
    Collection<String> scopes = credentials.getScopes();
    String tokenUrlWithScopes = credentials.createTokenUrlWithScopes();

    assertEquals(TOKEN_URL + "?scopes=foo,bar", tokenUrlWithScopes);
    assertEquals(2, scopes.size());
    assertEquals("foo", scopes.toArray()[0]);
    assertEquals("bar", scopes.toArray()[1]);
  }

  @Test
  void buildTokenUrlWithScopes_defaultScopes() {
    ComputeEngineCredentials credentials = ComputeEngineCredentials.newBuilder().build();
    credentials =
        (ComputeEngineCredentials)
            credentials.createScoped(null, Arrays.asList(null, "foo", "", "bar"));
    Collection<String> scopes = credentials.getScopes();
    String tokenUrlWithScopes = credentials.createTokenUrlWithScopes();

    assertEquals(TOKEN_URL + "?scopes=foo,bar", tokenUrlWithScopes);
    assertEquals(2, scopes.size());
    assertEquals("foo", scopes.toArray()[0]);
    assertEquals("bar", scopes.toArray()[1]);
  }

  @Test
  void buildTokenUrl_nullTransport() {
    ComputeEngineCredentials credentials =
        ComputeEngineCredentials.newBuilder()
            .setGoogleAuthTransport(null)
            .setBindingEnforcement(ComputeEngineCredentials.BindingEnforcement.ON)
            .build();
    String tokenUrl = credentials.createTokenUrlWithScopes();

    assertEquals(TOKEN_URL + "?binding-enforcement=on", tokenUrl);
  }

  @Test
  void buildTokenUrl_nullBindingEnforcement() {
    ComputeEngineCredentials credentials =
        ComputeEngineCredentials.newBuilder()
            .setGoogleAuthTransport(ComputeEngineCredentials.GoogleAuthTransport.MTLS)
            .setBindingEnforcement(null)
            .build();
    String tokenUrl = credentials.createTokenUrlWithScopes();

    assertEquals(TOKEN_URL + "?transport=mtls", tokenUrl);
  }

  @Test
  void buildTokenUrl_nullTransport_nullBindingEnforcement() {
    ComputeEngineCredentials credentials =
        ComputeEngineCredentials.newBuilder()
            .setGoogleAuthTransport(null)
            .setBindingEnforcement(null)
            .build();
    String softBoundTokenUrl = credentials.createTokenUrlWithScopes();

    assertEquals(TOKEN_URL, softBoundTokenUrl);
  }

  @Test
  void buildTokenUrl_mtls_transport() {
    ComputeEngineCredentials credentials =
        ComputeEngineCredentials.newBuilder()
            .setGoogleAuthTransport(ComputeEngineCredentials.GoogleAuthTransport.MTLS)
            .build();
    String tokenUrl = credentials.createTokenUrlWithScopes();

    assertEquals(TOKEN_URL + "?transport=mtls", tokenUrl);
  }

  @Test
  void buildTokenUrl_iam_enforcement() {
    ComputeEngineCredentials credentials =
        ComputeEngineCredentials.newBuilder()
            .setBindingEnforcement(ComputeEngineCredentials.BindingEnforcement.IAM_POLICY)
            .build();
    String tokenUrl = credentials.createTokenUrlWithScopes();

    assertEquals(TOKEN_URL + "?binding-enforcement=iam-policy", tokenUrl);
  }

  @Test
  void buildTokenUrlSoftMtlsBound_mtls_transport_iam_enforcement() {
    ComputeEngineCredentials credentials =
        ComputeEngineCredentials.newBuilder()
            .setGoogleAuthTransport(ComputeEngineCredentials.GoogleAuthTransport.MTLS)
            .setBindingEnforcement(ComputeEngineCredentials.BindingEnforcement.IAM_POLICY)
            .build();
    String softBoundTokenUrl = credentials.createTokenUrlWithScopes();

    assertEquals(TOKEN_URL + "?transport=mtls&binding-enforcement=iam-policy", softBoundTokenUrl);
  }

  @Test
  void buildTokenUrl_always_enforced() {
    ComputeEngineCredentials credentials =
        ComputeEngineCredentials.newBuilder()
            .setBindingEnforcement(ComputeEngineCredentials.BindingEnforcement.ON)
            .build();
    String tokenUrl = credentials.createTokenUrlWithScopes();

    assertEquals(TOKEN_URL + "?binding-enforcement=on", tokenUrl);
  }

  @Test
  void buildTokenUrlHardMtlsBound_mtls_transport_always_enforced() {
    ComputeEngineCredentials credentials =
        ComputeEngineCredentials.newBuilder()
            .setGoogleAuthTransport(ComputeEngineCredentials.GoogleAuthTransport.MTLS)
            .setBindingEnforcement(ComputeEngineCredentials.BindingEnforcement.ON)
            .build();
    String hardBoundTokenUrl = credentials.createTokenUrlWithScopes();

    assertEquals(TOKEN_URL + "?transport=mtls&binding-enforcement=on", hardBoundTokenUrl);
  }

  @Test
  void buildTokenUrlHardDirectPathBound_alts_transport() {
    ComputeEngineCredentials credentials =
        ComputeEngineCredentials.newBuilder()
            .setGoogleAuthTransport(ComputeEngineCredentials.GoogleAuthTransport.ALTS)
            .build();
    String hardBoundTokenUrl = credentials.createTokenUrlWithScopes();

    assertEquals(TOKEN_URL + "?transport=alts", hardBoundTokenUrl);
  }

  @Test
  void buildScoped_scopesPresent() throws IOException {
    ComputeEngineCredentials credentials =
        ComputeEngineCredentials.newBuilder().setScopes(null).build();
    ComputeEngineCredentials scopedCredentials =
        (ComputeEngineCredentials) credentials.createScoped(Arrays.asList("foo"));
    Collection<String> scopes = scopedCredentials.getScopes();

    assertEquals(1, scopes.size());
    assertEquals("foo", scopes.toArray()[0]);
  }

  @Test
  void buildScoped_correctMargins() throws IOException {
    ComputeEngineCredentials credentials =
        ComputeEngineCredentials.newBuilder().setScopes(null).build();
    ComputeEngineCredentials scopedCredentials =
        (ComputeEngineCredentials) credentials.createScoped(Arrays.asList("foo"));

    assertEquals(
        ComputeEngineCredentials.COMPUTE_EXPIRATION_MARGIN,
        scopedCredentials.getExpirationMargin());
    assertEquals(
        ComputeEngineCredentials.COMPUTE_REFRESH_MARGIN, scopedCredentials.getRefreshMargin());
  }

  @Test
  void buildScoped_explicitUniverse() throws IOException {
    ComputeEngineCredentials credentials =
        ComputeEngineCredentials.newBuilder()
            .setScopes(null)
            .setUniverseDomain("some-universe")
            .build();
    ComputeEngineCredentials scopedCredentials =
        (ComputeEngineCredentials) credentials.createScoped(Arrays.asList("foo"));

    assertEquals("some-universe", scopedCredentials.getUniverseDomain());
    assertTrue(scopedCredentials.isExplicitUniverseDomain());
  }

  @Test
  void createScoped_defaultScopes() {
    GoogleCredentials credentials =
        ComputeEngineCredentials.create().createScoped(null, Arrays.asList("foo"));
    Collection<String> scopes = ((ComputeEngineCredentials) credentials).getScopes();

    assertEquals(1, scopes.size());
    assertEquals("foo", scopes.toArray()[0]);
  }

  @Test
  void buildScoped_quotaProjectId() throws IOException {
    ComputeEngineCredentials credentials =
        ComputeEngineCredentials.newBuilder()
            .setScopes(null)
            .setQuotaProjectId("some-project-id")
            .build();
    ComputeEngineCredentials scopedCredentials =
        (ComputeEngineCredentials) credentials.createScoped(Arrays.asList("foo"));

    assertEquals("some-project-id", scopedCredentials.getQuotaProjectId());
  }

  @Test
  void buildDefaultScoped_explicitUniverse() throws IOException {
    ComputeEngineCredentials credentials =
        ComputeEngineCredentials.newBuilder()
            .setScopes(null)
            .setUniverseDomain("some-universe")
            .build();
    ComputeEngineCredentials scopedCredentials =
        (ComputeEngineCredentials) credentials.createScoped(null, Arrays.asList("foo"));

    assertEquals("some-universe", scopedCredentials.getUniverseDomain());
    assertTrue(scopedCredentials.isExplicitUniverseDomain());
  }

  @Test
  void create_scoped_correctMargins() {
    GoogleCredentials credentials =
        ComputeEngineCredentials.create().createScoped(null, Arrays.asList("foo"));

    assertEquals(
        ComputeEngineCredentials.COMPUTE_EXPIRATION_MARGIN, credentials.getExpirationMargin());
    assertEquals(ComputeEngineCredentials.COMPUTE_REFRESH_MARGIN, credentials.getRefreshMargin());
  }

  @Test
  void getRequestMetadata_hasAccessToken() throws IOException {
    MockMetadataServerTransportFactory transportFactory = new MockMetadataServerTransportFactory();
    transportFactory.transport.setServiceAccountEmail(SA_CLIENT_EMAIL);
    ComputeEngineCredentials credentials =
        ComputeEngineCredentials.newBuilder().setHttpTransportFactory(transportFactory).build();
    Map<String, List<String>> metadata = credentials.getRequestMetadata(CALL_URI);

    TestUtils.assertContainsBearerToken(metadata, ACCESS_TOKEN);
    // verify metrics header added and other header intact
    Map<String, List<String>> requestHeaders = transportFactory.transport.getRequest().getHeaders();
    com.google.auth.oauth2.TestUtils.validateMetricsHeader(requestHeaders, "at", "mds");
    assertTrue(requestHeaders.containsKey("metadata-flavor"));
    assertTrue(requestHeaders.get("metadata-flavor").contains("Google"));
  }

  @Test
  void getRequestMetadata_shouldInvalidateAccessTokenWhenScoped_newAccessTokenFromRefresh()
      throws IOException {
    MockMetadataServerTransportFactory transportFactory = new MockMetadataServerTransportFactory();
    transportFactory.transport.setServiceAccountEmail("SA_CLIENT_EMAIL");
    ComputeEngineCredentials credentials =
        ComputeEngineCredentials.newBuilder().setHttpTransportFactory(transportFactory).build();
    Map<String, List<String>> metadata = credentials.getRequestMetadata(CALL_URI);

    TestUtils.assertContainsBearerToken(metadata, ACCESS_TOKEN);

    assertNotNull(credentials.getAccessToken());
    ComputeEngineCredentials scopedCredentialCopy =
        (ComputeEngineCredentials) credentials.createScoped(SCOPES);
    assertNull(scopedCredentialCopy.getAccessToken());
    Map<String, List<String>> metadataForCopiedCredentials =
        scopedCredentialCopy.getRequestMetadata(CALL_URI);
    TestUtils.assertContainsBearerToken(metadataForCopiedCredentials, ACCESS_TOKEN_WITH_SCOPES);
    TestUtils.assertNotContainsBearerToken(metadataForCopiedCredentials, ACCESS_TOKEN);
  }

  @Test
  void getRequestMetadata_missingServiceAccount_throws() {
    MockMetadataServerTransportFactory transportFactory = new MockMetadataServerTransportFactory();
    transportFactory.transport.setStatusCode(HttpStatusCodes.STATUS_CODE_NOT_FOUND);
    transportFactory.transport.setServiceAccountEmail("SA_CLIENT_EMAIL");
    ComputeEngineCredentials credentials =
        ComputeEngineCredentials.newBuilder().setHttpTransportFactory(transportFactory).build();
    try {
      credentials.getRequestMetadata(CALL_URI);
      fail("Expected error refreshing token.");
    } catch (IOException expected) {
      String message = expected.getMessage();
      assertTrue(message.contains(Integer.toString(HttpStatusCodes.STATUS_CODE_NOT_FOUND)));
      // Message should mention scopes are missing on the VM.
      assertTrue(message.contains("scope"));
    }
  }

  @Test
  void getRequestMetadata_serverError_throws() {
    MockMetadataServerTransportFactory transportFactory = new MockMetadataServerTransportFactory();
    transportFactory.transport.setStatusCode(HttpStatusCodes.STATUS_CODE_SERVER_ERROR);
    transportFactory.transport.setServiceAccountEmail("SA_CLIENT_EMAIL");
    ComputeEngineCredentials credentials =
        ComputeEngineCredentials.newBuilder().setHttpTransportFactory(transportFactory).build();
    try {
      credentials.getRequestMetadata(CALL_URI);
      fail("Expected error refreshing token.");
    } catch (IOException expected) {
      String message = expected.getMessage();
      assertTrue(message.contains(Integer.toString(HttpStatusCodes.STATUS_CODE_SERVER_ERROR)));
      assertTrue(message.contains("Unexpected"));
    }
  }

  @Test
  void equals_true() throws IOException {
    MockMetadataServerTransportFactory transportFactory = new MockMetadataServerTransportFactory();
    ComputeEngineCredentials explicitUniverseCredentials =
        ComputeEngineCredentials.newBuilder()
            .setUniverseDomain(Credentials.GOOGLE_DEFAULT_UNIVERSE)
            .setHttpTransportFactory(transportFactory)
            .build();
    ComputeEngineCredentials otherCredentials =
        ComputeEngineCredentials.newBuilder().setHttpTransportFactory(transportFactory).build();
    assertEquals(Credentials.GOOGLE_DEFAULT_UNIVERSE, otherCredentials.getUniverseDomain());
    assertFalse(explicitUniverseCredentials.equals(otherCredentials));
    assertFalse(otherCredentials.equals(explicitUniverseCredentials));
    ComputeEngineCredentials otherExplicitUniverseCredentials =
        ComputeEngineCredentials.newBuilder()
            .setUniverseDomain(Credentials.GOOGLE_DEFAULT_UNIVERSE)
            .setHttpTransportFactory(transportFactory)
            .build();
    assertTrue(explicitUniverseCredentials.equals(otherExplicitUniverseCredentials));
    assertTrue(otherExplicitUniverseCredentials.equals(explicitUniverseCredentials));
  }

  @Test
  void equals_false_transportFactory() throws IOException {
    MockHttpTransportFactory httpTransportFactory = new MockHttpTransportFactory();
    MockMetadataServerTransportFactory serverTransportFactory =
        new MockMetadataServerTransportFactory();
    ComputeEngineCredentials credentials =
        ComputeEngineCredentials.newBuilder()
            .setHttpTransportFactory(serverTransportFactory)
            .build();
    ComputeEngineCredentials otherCredentials =
        ComputeEngineCredentials.newBuilder().setHttpTransportFactory(httpTransportFactory).build();
    assertFalse(credentials.equals(otherCredentials));
    assertFalse(otherCredentials.equals(credentials));
  }

  @Test
  void toString_explicit_containsFields() throws IOException {
    MockMetadataServerTransportFactory serverTransportFactory =
        new MockMetadataServerTransportFactory();
    String expectedToString =
        String.format(
            "ComputeEngineCredentials{quotaProjectId=%s, universeDomain=%s, isExplicitUniverseDomain=%s, transportFactoryClassName=%s, scopes=%s}",
            "some-project",
            "some-domain",
            true,
            MockMetadataServerTransportFactory.class.getName(),
            "[some scope]");
    GoogleCredentials credentials =
        ComputeEngineCredentials.newBuilder()
            .setHttpTransportFactory(serverTransportFactory)
            .setQuotaProjectId("some-project")
            .setUniverseDomain("some-domain")
            .build();
    credentials = credentials.createScoped("some scope");
    assertEquals(expectedToString, credentials.toString());
  }

  @Test
  void hashCode_equals() throws IOException {
    MockMetadataServerTransportFactory serverTransportFactory =
        new MockMetadataServerTransportFactory();
    ComputeEngineCredentials credentials =
        ComputeEngineCredentials.newBuilder()
            .setHttpTransportFactory(serverTransportFactory)
            .build();
    ComputeEngineCredentials otherCredentials =
        ComputeEngineCredentials.newBuilder()
            .setHttpTransportFactory(serverTransportFactory)
            .build();
    assertEquals(credentials.hashCode(), otherCredentials.hashCode());
  }

  @Test
  void toBuilder() {
    ComputeEngineCredentials credentials =
        ComputeEngineCredentials.newBuilder()
            .setHttpTransportFactory(new MockMetadataServerTransportFactory())
            .setQuotaProjectId("quota-project")
            .build();

    ComputeEngineCredentials secondCredentials = credentials.toBuilder().build();

    assertEquals(credentials, secondCredentials);
  }

  @Test
  void serialize() throws IOException, ClassNotFoundException {
    MockMetadataServerTransportFactory serverTransportFactory =
        new MockMetadataServerTransportFactory();
    ComputeEngineCredentials credentials =
        ComputeEngineCredentials.newBuilder()
            .setHttpTransportFactory(serverTransportFactory)
            .build();
    GoogleCredentials deserializedCredentials = serializeAndDeserialize(credentials);
    assertEquals(credentials, deserializedCredentials);
    assertEquals(credentials.hashCode(), deserializedCredentials.hashCode());
    assertEquals(credentials.toString(), deserializedCredentials.toString());
    assertSame(deserializedCredentials.clock, Clock.SYSTEM);
    credentials = ComputeEngineCredentials.newBuilder().build();
    deserializedCredentials = serializeAndDeserialize(credentials);
    assertEquals(credentials, deserializedCredentials);
    assertEquals(credentials.hashCode(), deserializedCredentials.hashCode());
    assertEquals(credentials.toString(), deserializedCredentials.toString());
    assertSame(deserializedCredentials.clock, Clock.SYSTEM);
  }

  @Test
  void getAccount_sameAs() throws IOException {
    MockMetadataServerTransportFactory transportFactory = new MockMetadataServerTransportFactory();
    String defaultAccountEmail = "mail@mail.com";

    transportFactory.transport.setServiceAccountEmail(defaultAccountEmail);
    ComputeEngineCredentials credentials =
        ComputeEngineCredentials.newBuilder().setHttpTransportFactory(transportFactory).build();

    assertEquals(defaultAccountEmail, credentials.getAccount());

    // metric headers are not supported for getAccount()
    Map<String, List<String>> headers = transportFactory.transport.getRequest().getHeaders();
    assertFalse(headers.containsKey(MetricsUtils.API_CLIENT_HEADER));
  }

  @Test
  void getAccount_missing_throws() {
    MockMetadataServerTransportFactory transportFactory = new MockMetadataServerTransportFactory();
    String defaultAccountEmail = "mail@mail.com";

    transportFactory.transport =
        new MockMetadataServerTransport() {
          @Override
          public LowLevelHttpRequest buildRequest(String method, String url) throws IOException {
            if (isGetDefaultServiceAccountsUrl(url)) {
              return new MockLowLevelHttpRequest(url) {
                @Override
                public LowLevelHttpResponse execute() throws IOException {
                  return new MockLowLevelHttpResponse()
                      .setStatusCode(HttpStatusCodes.STATUS_CODE_NOT_FOUND)
                      .setContent("");
                }
              };
            }
            return super.buildRequest(method, url);
          }
        };
    transportFactory.transport.setServiceAccountEmail(defaultAccountEmail);
    ComputeEngineCredentials credentials =
        ComputeEngineCredentials.newBuilder().setHttpTransportFactory(transportFactory).build();

    try {
      credentials.getAccount();
      fail("Fetching default service account should have failed");
    } catch (RuntimeException e) {
      assertEquals("Failed to get service account", e.getMessage());
      assertNotNull(e.getCause());
      assertTrue(e.getCause().getMessage().contains("404"));
    }
  }

  @Test
  void getAccount_emptyContent_throws() {
    MockMetadataServerTransportFactory transportFactory = new MockMetadataServerTransportFactory();
    String defaultAccountEmail = "mail@mail.com";

    transportFactory.transport =
        new MockMetadataServerTransport() {
          @Override
          public LowLevelHttpRequest buildRequest(String method, String url) throws IOException {
            if (isGetDefaultServiceAccountsUrl(url)) {
              return new MockLowLevelHttpRequest(url) {
                @Override
                public LowLevelHttpResponse execute() throws IOException {
                  return new MockLowLevelHttpResponse()
                      .setStatusCode(HttpStatusCodes.STATUS_CODE_OK);
                }
              };
            }
            return super.buildRequest(method, url);
          }
        };
    transportFactory.transport.setServiceAccountEmail(defaultAccountEmail);
    ComputeEngineCredentials credentials =
        ComputeEngineCredentials.newBuilder().setHttpTransportFactory(transportFactory).build();

    try {
      credentials.getAccount();
      fail("Fetching default service account should have failed");
    } catch (RuntimeException e) {
      assertEquals("Failed to get service account", e.getMessage());
      assertNotNull(e.getCause());
      assertTrue(e.getCause().getMessage().contains("Empty content"));
    }
  }

  @Test
  void sign_sameAs() {
    MockMetadataServerTransportFactory transportFactory = new MockMetadataServerTransportFactory();
    String defaultAccountEmail = "mail@mail.com";
    byte[] expectedSignature = {0xD, 0xE, 0xA, 0xD};

    transportFactory.transport.setServiceAccountEmail(defaultAccountEmail);
    transportFactory.transport.setSignature(expectedSignature);
    ComputeEngineCredentials credentials =
        ComputeEngineCredentials.newBuilder().setHttpTransportFactory(transportFactory).build();

    assertArrayEquals(expectedSignature, credentials.sign(expectedSignature));
  }

  @Test
  void sign_getUniverseException() {
    MockMetadataServerTransportFactory transportFactory = new MockMetadataServerTransportFactory();

    String defaultAccountEmail = "mail@mail.com";
    transportFactory.transport.setServiceAccountEmail(defaultAccountEmail);
    ComputeEngineCredentials credentials =
        ComputeEngineCredentials.newBuilder().setHttpTransportFactory(transportFactory).build();

    transportFactory.transport.setStatusCode(501);
    assertThrows(IOException.class, credentials::getUniverseDomain);

    byte[] expectedSignature = {0xD, 0xE, 0xA, 0xD};
    SigningException signingException =
        assertThrows(SigningException.class, () -> credentials.sign(expectedSignature));
    assertEquals("Failed to sign: Error obtaining universe domain", signingException.getMessage());
  }

  @Test
  void sign_getAccountFails() {
    MockMetadataServerTransportFactory transportFactory = new MockMetadataServerTransportFactory();
    byte[] expectedSignature = {0xD, 0xE, 0xA, 0xD};

    transportFactory.transport.setSignature(expectedSignature);
    ComputeEngineCredentials credentials =
        ComputeEngineCredentials.newBuilder().setHttpTransportFactory(transportFactory).build();

    SigningException exception =
        assertThrows(SigningException.class, () -> credentials.sign(expectedSignature));
    assertNotNull(exception.getMessage());
    assertNotNull(exception.getCause());
  }

  @Test
  void sign_accessDenied_throws() {
    MockMetadataServerTransportFactory transportFactory = new MockMetadataServerTransportFactory();
    String defaultAccountEmail = "mail@mail.com";

    transportFactory.transport =
        new MockMetadataServerTransport() {
          @Override
          public LowLevelHttpRequest buildRequest(String method, String url) throws IOException {
            if (isSignRequestUrl(url)) {
              return new MockLowLevelHttpRequest(url) {
                @Override
                public LowLevelHttpResponse execute() throws IOException {
                  return new MockLowLevelHttpResponse()
                      .setStatusCode(HttpStatusCodes.STATUS_CODE_FORBIDDEN)
                      .setContent(TestUtils.errorJson("Sign Error"));
                }
              };
            }
            return super.buildRequest(method, url);
          }
        };

    transportFactory.transport.setAccessToken(ACCESS_TOKEN);
    transportFactory.transport.setServiceAccountEmail(defaultAccountEmail);

    ComputeEngineCredentials credentials =
        ComputeEngineCredentials.newBuilder().setHttpTransportFactory(transportFactory).build();

    byte[] bytes = {0xD, 0xE, 0xA, 0xD};

    SigningException exception =
        assertThrows(SigningException.class, () -> credentials.sign(bytes));
    assertEquals("Failed to sign the provided bytes", exception.getMessage());
    assertNotNull(exception.getCause());
    assertTrue(exception.getCause().getMessage().contains("403"));
  }

  @Test
  void sign_serverError_throws() {
    MockMetadataServerTransportFactory transportFactory = new MockMetadataServerTransportFactory();
    String defaultAccountEmail = "mail@mail.com";

    transportFactory.transport =
        new MockMetadataServerTransport() {
          @Override
          public LowLevelHttpRequest buildRequest(String method, String url) throws IOException {
            if (isSignRequestUrl(url)) {
              return new MockLowLevelHttpRequest(url) {
                @Override
                public LowLevelHttpResponse execute() throws IOException {
                  return new MockLowLevelHttpResponse()
                      .setStatusCode(HttpStatusCodes.STATUS_CODE_SERVER_ERROR)
                      .setContent(TestUtils.errorJson("Sign Error"));
                }
              };
            }
            return super.buildRequest(method, url);
          }
        };

    transportFactory.transport.setAccessToken(ACCESS_TOKEN);
    transportFactory.transport.setServiceAccountEmail(defaultAccountEmail);

    ComputeEngineCredentials credentials =
        ComputeEngineCredentials.newBuilder().setHttpTransportFactory(transportFactory).build();

    byte[] bytes = {0xD, 0xE, 0xA, 0xD};

    SigningException exception =
        assertThrows(SigningException.class, () -> credentials.sign(bytes));
    assertEquals("Failed to sign the provided bytes", exception.getMessage());
    assertNotNull(exception.getCause());
    assertTrue(exception.getCause().getMessage().contains("500"));
  }

  @Test
  void refresh_503_retryable_throws() {
    MockMetadataServerTransportFactory transportFactory = new MockMetadataServerTransportFactory();

    transportFactory.transport =
        new MockMetadataServerTransport() {
          @Override
          public LowLevelHttpRequest buildRequest(String method, String url) throws IOException {
            return new MockLowLevelHttpRequest(url) {
              @Override
              public LowLevelHttpResponse execute() throws IOException {
                return new MockLowLevelHttpResponse()
                    .setStatusCode(HttpStatusCodes.STATUS_CODE_SERVICE_UNAVAILABLE)
                    .setContent(TestUtils.errorJson("Some error"));
              }
            };
          }
        };

    ComputeEngineCredentials credentials =
        ComputeEngineCredentials.newBuilder().setHttpTransportFactory(transportFactory).build();

    IOException exception = assertThrows(IOException.class, () -> credentials.refreshAccessToken());
    assertTrue(exception.getCause().getMessage().contains("503"));
    assertTrue(exception instanceof GoogleAuthException);
    assertTrue(((GoogleAuthException) exception).isRetryable());
  }

  @Test
  void refresh_non503_ioexception_throws() {
    MockMetadataServerTransportFactory transportFactory = new MockMetadataServerTransportFactory();
    final Queue<Integer> responseSequence = new ArrayDeque<>();
    IntStream.rangeClosed(400, 600).forEach(i -> responseSequence.add(i));

    while (!responseSequence.isEmpty()) {
      if (responseSequence.peek() == 503) {
        responseSequence.poll();
        continue;
      }

      transportFactory.transport =
          new MockMetadataServerTransport() {
            @Override
            public LowLevelHttpRequest buildRequest(String method, String url) throws IOException {
              return new MockLowLevelHttpRequest(url) {
                @Override
                public LowLevelHttpResponse execute() throws IOException {
                  return new MockLowLevelHttpResponse()
                      .setStatusCode(responseSequence.poll())
                      .setContent(TestUtils.errorJson("Some error"));
                }
              };
            }
          };

      ComputeEngineCredentials credentials =
          ComputeEngineCredentials.newBuilder().setHttpTransportFactory(transportFactory).build();

      IOException exception =
          assertThrows(IOException.class, () -> credentials.refreshAccessToken());
      assertFalse(exception instanceof GoogleAuthException);
    }
  }

  @Test
  void getUniverseDomain_fromMetadata() throws IOException {
    MockMetadataServerTransportFactory transportFactory = new MockMetadataServerTransportFactory();

    transportFactory.transport =
        new MockMetadataServerTransport() {
          @Override
          public LowLevelHttpRequest buildRequest(String method, String url) throws IOException {
            return new MockLowLevelHttpRequest(url) {
              @Override
              public LowLevelHttpResponse execute() throws IOException {
                return new MockLowLevelHttpResponse()
                    .setStatusCode(HttpStatusCodes.STATUS_CODE_OK)
                    .setContent("some-universe.xyz");
              }
            };
          }
        };

    ComputeEngineCredentials credentials =
        ComputeEngineCredentials.newBuilder().setHttpTransportFactory(transportFactory).build();

    String universeDomain = credentials.getUniverseDomain();
    assertEquals("some-universe.xyz", universeDomain);
    assertEquals(false, credentials.isExplicitUniverseDomain());
  }

  @Test
  void getUniverseDomain_fromMetadata_emptyBecomesDefault() throws IOException {
    MockMetadataServerTransportFactory transportFactory = new MockMetadataServerTransportFactory();

    transportFactory.transport =
        new MockMetadataServerTransport() {
          @Override
          public LowLevelHttpRequest buildRequest(String method, String url) throws IOException {
            return new MockLowLevelHttpRequest(url) {
              @Override
              public LowLevelHttpResponse execute() throws IOException {
                return new MockLowLevelHttpResponse()
                    .setStatusCode(HttpStatusCodes.STATUS_CODE_OK)
                    .setContent("");
              }
            };
          }
        };

    ComputeEngineCredentials credentials =
        ComputeEngineCredentials.newBuilder().setHttpTransportFactory(transportFactory).build();

    String universeDomain = credentials.getUniverseDomain();
    assertEquals(Credentials.GOOGLE_DEFAULT_UNIVERSE, universeDomain);
    assertEquals(false, credentials.isExplicitUniverseDomain());
  }

  @Test
  void getUniverseDomain_fromMetadata_404_default() throws IOException {
    MockMetadataServerTransportFactory transportFactory = new MockMetadataServerTransportFactory();

    transportFactory.transport =
        new MockMetadataServerTransport() {
          @Override
          public LowLevelHttpRequest buildRequest(String method, String url) throws IOException {
            return new MockLowLevelHttpRequest(url) {
              @Override
              public LowLevelHttpResponse execute() throws IOException {
                return new MockLowLevelHttpResponse()
                    .setStatusCode(HttpStatusCodes.STATUS_CODE_NOT_FOUND)
                    .setContent("some content");
              }
            };
          }
        };

    ComputeEngineCredentials credentials =
        ComputeEngineCredentials.newBuilder().setHttpTransportFactory(transportFactory).build();

    String universeDomain = credentials.getUniverseDomain();
    assertEquals(Credentials.GOOGLE_DEFAULT_UNIVERSE, universeDomain);
    assertEquals(false, credentials.isExplicitUniverseDomain());
  }

  @Test
  void getUniverseDomain_explicitSet_NoMdsCall() throws IOException {
    MockRequestCountingTransportFactory transportFactory =
        new MockRequestCountingTransportFactory();

    ComputeEngineCredentials credentials =
        ComputeEngineCredentials.newBuilder()
            .setHttpTransportFactory(transportFactory)
            .setUniverseDomain("explicit.universe")
            .build();

    String universeDomain = credentials.getUniverseDomain();
    assertEquals("explicit.universe", universeDomain);
    assertEquals(true, credentials.isExplicitUniverseDomain());
    assertEquals(0, transportFactory.transport.getRequestCount());
  }

  @Test
  void getUniverseDomain_explicitGduSet_NoMdsCall() throws IOException {
    MockRequestCountingTransportFactory transportFactory =
        new MockRequestCountingTransportFactory();

    ComputeEngineCredentials credentials =
        ComputeEngineCredentials.newBuilder()
            .setHttpTransportFactory(transportFactory)
            .setUniverseDomain(Credentials.GOOGLE_DEFAULT_UNIVERSE)
            .build();

    String universeDomain = credentials.getUniverseDomain();
    assertEquals(Credentials.GOOGLE_DEFAULT_UNIVERSE, universeDomain);
    assertEquals(true, credentials.isExplicitUniverseDomain());
    assertEquals(0, transportFactory.transport.getRequestCount());
  }

  @Test
  void getUniverseDomain_fromMetadata_non404error_throws() throws IOException {
    MockMetadataServerTransportFactory transportFactory = new MockMetadataServerTransportFactory();
    MockMetadataServerTransport transport = transportFactory.transport;

    ComputeEngineCredentials credentials =
        ComputeEngineCredentials.newBuilder().setHttpTransportFactory(transportFactory).build();

    for (int status = 400; status < 600; status++) {
      // 404 should not throw and tested separately
      if (status == 404) {
        continue;
      }
      try {
        transportFactory.transport.setStatusCode(status);
        credentials.getUniverseDomain();
        fail("Should not be able to use credential without exception.");
      } catch (GoogleAuthException ex) {
        assertTrue(ex.isRetryable());
      }
    }
  }

  @Test
  void sign_emptyContent_throws() {
    MockMetadataServerTransportFactory transportFactory = new MockMetadataServerTransportFactory();
    String defaultAccountEmail = "mail@mail.com";

    transportFactory.transport =
        new MockMetadataServerTransport() {
          @Override
          public LowLevelHttpRequest buildRequest(String method, String url) throws IOException {
            if (isSignRequestUrl(url)) {
              return new MockLowLevelHttpRequest(url) {
                @Override
                public LowLevelHttpResponse execute() throws IOException {
                  return new MockLowLevelHttpResponse()
                      .setStatusCode(HttpStatusCodes.STATUS_CODE_OK);
                }
              };
            }
            return super.buildRequest(method, url);
          }
        };

    transportFactory.transport.setAccessToken(ACCESS_TOKEN);
    transportFactory.transport.setServiceAccountEmail(defaultAccountEmail);

    ComputeEngineCredentials credentials =
        ComputeEngineCredentials.newBuilder().setHttpTransportFactory(transportFactory).build();

    byte[] bytes = {0xD, 0xE, 0xA, 0xD};

    SigningException exception =
        assertThrows(SigningException.class, () -> credentials.sign(bytes));
    assertEquals("Failed to sign the provided bytes", exception.getMessage());
    assertNotNull(exception.getCause());
    assertTrue(exception.getCause().getMessage().contains("Empty content"));
  }

  @Test
  void idTokenWithAudience_sameAs() throws IOException {
    MockMetadataServerTransportFactory transportFactory = new MockMetadataServerTransportFactory();
    transportFactory.transport.setIdToken(STANDARD_ID_TOKEN);
    ComputeEngineCredentials credentials =
        ComputeEngineCredentials.newBuilder().setHttpTransportFactory(transportFactory).build();

    String targetAudience = "https://foo.bar";
    IdTokenCredentials tokenCredential =
        IdTokenCredentials.newBuilder()
            .setIdTokenProvider(credentials)
            .setTargetAudience(targetAudience)
            .build();
    tokenCredential.refresh();
    assertEquals(STANDARD_ID_TOKEN, tokenCredential.getAccessToken().getTokenValue());
    assertEquals(STANDARD_ID_TOKEN, tokenCredential.getIdToken().getTokenValue());
    assertEquals(
        targetAudience,
        (String) tokenCredential.getIdToken().getJsonWebSignature().getPayload().getAudience());
  }

  @Test
  void idTokenWithAudience_standard() throws IOException {
    MockMetadataServerTransportFactory transportFactory = new MockMetadataServerTransportFactory();
    ComputeEngineCredentials credentials =
        ComputeEngineCredentials.newBuilder().setHttpTransportFactory(transportFactory).build();

    String targetAudience = "https://foo.bar";
    IdTokenCredentials tokenCredential =
        IdTokenCredentials.newBuilder()
            .setIdTokenProvider(credentials)
            .setTargetAudience(targetAudience)
            .build();
    tokenCredential.refresh();
    assertEquals(STANDARD_ID_TOKEN, tokenCredential.getAccessToken().getTokenValue());
    assertEquals(STANDARD_ID_TOKEN, tokenCredential.getIdToken().getTokenValue());
    assertNull(tokenCredential.getIdToken().getJsonWebSignature().getPayload().get("google"));
  }

  @Test
  @SuppressWarnings("unchecked")
  void idTokenWithAudience_full() throws IOException {
    MockMetadataServerTransportFactory transportFactory = new MockMetadataServerTransportFactory();
    ComputeEngineCredentials credentials =
        ComputeEngineCredentials.newBuilder().setHttpTransportFactory(transportFactory).build();

    String targetAudience = "https://foo.bar";
    IdTokenCredentials tokenCredential =
        IdTokenCredentials.newBuilder()
            .setIdTokenProvider(credentials)
            .setTargetAudience(targetAudience)
            .setOptions(Arrays.asList(IdTokenProvider.Option.FORMAT_FULL))
            .build();
    tokenCredential.refresh();
    Payload p = tokenCredential.getIdToken().getJsonWebSignature().getPayload();
    assertTrue(p.containsKey("google"), "Full ID Token format not provided");
    ArrayMap<String, ArrayMap<String, ?>> googleClaim =
        (ArrayMap<String, ArrayMap<String, ?>>) p.get("google");
    assertTrue(googleClaim.containsKey("compute_engine"));

    // verify metrics header
    Map<String, List<String>> requestHeaders = transportFactory.transport.getRequest().getHeaders();
    com.google.auth.oauth2.TestUtils.validateMetricsHeader(requestHeaders, "it", "mds");
  }

  @Test
  @SuppressWarnings("unchecked")
  void idTokenWithAudience_licenses() throws IOException {
    MockMetadataServerTransportFactory transportFactory = new MockMetadataServerTransportFactory();
    ComputeEngineCredentials credentials =
        ComputeEngineCredentials.newBuilder().setHttpTransportFactory(transportFactory).build();

    String targetAudience = "https://foo.bar";
    IdTokenCredentials tokenCredential =
        IdTokenCredentials.newBuilder()
            .setIdTokenProvider(credentials)
            .setTargetAudience(targetAudience)
            .setOptions(
                Arrays.asList(
                    IdTokenProvider.Option.FORMAT_FULL, IdTokenProvider.Option.LICENSES_TRUE))
            .build();
    tokenCredential.refresh();
    Payload p = tokenCredential.getIdToken().getJsonWebSignature().getPayload();
    assertTrue(p.containsKey("google"), "Full ID Token format not provided");
    ArrayMap<String, ArrayMap<String, ?>> googleClaim =
        (ArrayMap<String, ArrayMap<String, ?>>) p.get("google");
    assertTrue(googleClaim.containsKey("compute_engine"));
    ArrayMap<String, ?> computeEngineClaim =
        (ArrayMap<String, ?>) googleClaim.get("compute_engine");
    assertTrue(computeEngineClaim.containsKey("license_id"));
  }

  @Test
  void idTokenWithAudience_404StatusCode() {
    int statusCode = HttpStatusCodes.STATUS_CODE_NOT_FOUND;
    MockMetadataServerTransportFactory transportFactory = new MockMetadataServerTransportFactory();
    transportFactory.transport.setStatusCode(HttpStatusCodes.STATUS_CODE_NOT_FOUND);
    ComputeEngineCredentials credentials =
        ComputeEngineCredentials.newBuilder().setHttpTransportFactory(transportFactory).build();
    IOException exception =
        assertThrows(IOException.class, () -> credentials.idTokenWithAudience("Audience", null));
    assertEquals(
        String.format(
            "Error code %s trying to get identity token from"
                + " Compute Engine metadata. This may be because the virtual machine instance"
                + " does not have permission scopes specified.",
            statusCode),
        exception.getMessage());
  }

  @Test
  void idTokenWithAudience_emptyContent() {
    MockMetadataServerTransportFactory transportFactory = new MockMetadataServerTransportFactory();
    transportFactory.transport.setEmptyContent(true);
    ComputeEngineCredentials credentials =
        ComputeEngineCredentials.newBuilder().setHttpTransportFactory(transportFactory).build();
    IOException exception =
        assertThrows(IOException.class, () -> credentials.idTokenWithAudience("Audience", null));
    assertEquals(METADATA_RESPONSE_EMPTY_CONTENT_ERROR_MESSAGE, exception.getMessage());
  }

  @Test
  void idTokenWithAudience_503StatusCode() {
    MockMetadataServerTransportFactory transportFactory = new MockMetadataServerTransportFactory();
    transportFactory.transport.setStatusCode(HttpStatusCodes.STATUS_CODE_SERVICE_UNAVAILABLE);
    ComputeEngineCredentials credentials =
        ComputeEngineCredentials.newBuilder().setHttpTransportFactory(transportFactory).build();
    assertThrows(
        GoogleAuthException.class, () -> credentials.idTokenWithAudience("Audience", null));
  }

  static class MockMetadataServerTransportFactory implements HttpTransportFactory {

    MockMetadataServerTransport transport =
        new MockMetadataServerTransport(SCOPE_TO_ACCESS_TOKEN_MAP);

    @Override
    public HttpTransport create() {
      return transport;
    }
  }
}
