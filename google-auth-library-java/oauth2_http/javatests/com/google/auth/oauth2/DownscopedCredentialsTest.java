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
import static com.google.auth.oauth2.OAuth2Utils.TOKEN_EXCHANGE_URL_FORMAT;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertThrows;

import com.google.api.client.http.HttpTransport;
import com.google.auth.TestUtils;
import com.google.auth.http.HttpTransportFactory;
import java.io.IOException;
import java.util.Date;
import java.util.Map;
import org.junit.jupiter.api.Test;

/** Tests for {@link DownscopedCredentials}. */
class DownscopedCredentialsTest {

  private static final String SA_PRIVATE_KEY_PKCS8 =
      "-----BEGIN PRIVATE KEY-----\n"
          + "MIICdgIBADANBgkqhkiG9w0BAQEFAASCAmAwggJcAgEAAoGBALX0PQoe1igW12i"
          + "kv1bN/r9lN749y2ijmbc/mFHPyS3hNTyOCjDvBbXYbDhQJzWVUikh4mvGBA07qTj79Xc3yBDfKP2IeyYQIFe0t0"
          + "zkd7R9Zdn98Y2rIQC47aAbDfubtkU1U72t4zL11kHvoa0/RuFZjncvlr42X7be7lYh4p3NAgMBAAECgYASk5wDw"
          + "4Az2ZkmeuN6Fk/y9H+Lcb2pskJIXjrL533vrDWGOC48LrsThMQPv8cxBky8HFSEklPpkfTF95tpD43iVwJRB/Gr"
          + "CtGTw65IfJ4/tI09h6zGc4yqvIo1cHX/LQ+SxKLGyir/dQM925rGt/VojxY5ryJR7GLbCzxPnJm/oQJBANwOCO6"
          + "D2hy1LQYJhXh7O+RLtA/tSnT1xyMQsGT+uUCMiKS2bSKx2wxo9k7h3OegNJIu1q6nZ6AbxDK8H3+d0dUCQQDTrP"
          + "SXagBxzp8PecbaCHjzNRSQE2in81qYnrAFNB4o3DpHyMMY6s5ALLeHKscEWnqP8Ur6X4PvzZecCWU9BKAZAkAut"
          + "LPknAuxSCsUOvUfS1i87ex77Ot+w6POp34pEX+UWb+u5iFn2cQacDTHLV1LtE80L8jVLSbrbrlH43H0DjU5AkEA"
          + "gidhycxS86dxpEljnOMCw8CKoUBd5I880IUahEiUltk7OLJYS/Ts1wbn3kPOVX3wyJs8WBDtBkFrDHW2ezth2QJ"
          + "ADj3e1YhMVdjJW5jqwlD/VNddGjgzyunmiZg0uOXsHXbytYmsA545S8KRQFaJKFXYYFo2kOjqOiC1T2cAzMDjCQ"
          + "==\n-----END PRIVATE KEY-----\n";

  private static final CredentialAccessBoundary CREDENTIAL_ACCESS_BOUNDARY =
      CredentialAccessBoundary.newBuilder()
          .addRule(
              CredentialAccessBoundary.AccessBoundaryRule.newBuilder()
                  .setAvailableResource("//storage.googleapis.com/projects/_/buckets/bucket")
                  .addAvailablePermission("inRole:roles/storage.objectViewer")
                  .build())
          .build();

  static class MockStsTransportFactory implements HttpTransportFactory {

    MockStsTransport transport = new MockStsTransport();

    @Override
    public HttpTransport create() {
      return transport;
    }
  }

  @Test
  void refreshAccessToken() throws IOException {
    MockStsTransportFactory transportFactory = new MockStsTransportFactory();

    GoogleCredentials sourceCredentials =
        getServiceAccountSourceCredentials(/* canRefresh= */ true);

    DownscopedCredentials downscopedCredentials =
        DownscopedCredentials.newBuilder()
            .setSourceCredential(sourceCredentials)
            .setCredentialAccessBoundary(CREDENTIAL_ACCESS_BOUNDARY)
            .setHttpTransportFactory(transportFactory)
            .build();

    AccessToken accessToken = downscopedCredentials.refreshAccessToken();

    assertEquals(transportFactory.transport.getAccessToken(), accessToken.getTokenValue());

    // Validate CAB specific params.
    Map<String, String> query =
        TestUtils.parseQuery(transportFactory.transport.getRequest().getContentAsString());
    assertNotNull(query.get("options"));
    assertEquals(CREDENTIAL_ACCESS_BOUNDARY.toJson(), query.get("options"));
    assertEquals(
        "urn:ietf:params:oauth:token-type:access_token", query.get("requested_token_type"));

    // Verify domain.
    String url = transportFactory.transport.getRequest().getUrl();
    assertEquals(url, String.format(TOKEN_EXCHANGE_URL_FORMAT, GOOGLE_DEFAULT_UNIVERSE));
  }

  @Test
  void refreshAccessToken_withCustomUniverseDomain() throws IOException {
    MockStsTransportFactory transportFactory = new MockStsTransportFactory();
    String universeDomain = "foobar";
    GoogleCredentials sourceCredentials =
        getServiceAccountSourceCredentials(/* canRefresh= */ true).toBuilder()
            .setUniverseDomain(universeDomain)
            .build();

    DownscopedCredentials downscopedCredentials =
        DownscopedCredentials.newBuilder()
            .setSourceCredential(sourceCredentials)
            .setCredentialAccessBoundary(CREDENTIAL_ACCESS_BOUNDARY)
            .setHttpTransportFactory(transportFactory)
            .setUniverseDomain(universeDomain)
            .build();

    AccessToken accessToken = downscopedCredentials.refreshAccessToken();

    assertEquals(transportFactory.transport.getAccessToken(), accessToken.getTokenValue());

    // Validate CAB specific params.
    Map<String, String> query =
        TestUtils.parseQuery(transportFactory.transport.getRequest().getContentAsString());
    assertNotNull(query.get("options"));
    assertEquals(CREDENTIAL_ACCESS_BOUNDARY.toJson(), query.get("options"));
    assertEquals(
        "urn:ietf:params:oauth:token-type:access_token", query.get("requested_token_type"));

    // Verify domain.
    String url = transportFactory.transport.getRequest().getUrl();
    assertEquals(url, String.format(TOKEN_EXCHANGE_URL_FORMAT, universeDomain));
  }

  @Test
  void refreshAccessToken_userCredentials_expectExpiresInCopied() throws IOException {
    // STS only returns expires_in if the source access token belongs to a service account.
    // For other source credential types, we can copy the source credentials expiration as
    // the generated downscoped token will always have the same expiration time as the source
    // credentials.

    MockStsTransportFactory transportFactory = new MockStsTransportFactory();
    transportFactory.transport.setReturnExpiresIn(false);

    GoogleCredentials sourceCredentials = getUserSourceCredentials();

    DownscopedCredentials downscopedCredentials =
        DownscopedCredentials.newBuilder()
            .setSourceCredential(sourceCredentials)
            .setCredentialAccessBoundary(CREDENTIAL_ACCESS_BOUNDARY)
            .setHttpTransportFactory(transportFactory)
            .build();

    AccessToken accessToken = downscopedCredentials.refreshAccessToken();

    assertEquals(transportFactory.transport.getAccessToken(), accessToken.getTokenValue());

    // Validate that the expires_in has been copied from the source credential.
    assertEquals(
        sourceCredentials.getAccessToken().getExpirationTime(), accessToken.getExpirationTime());
  }

  @Test
  void refreshAccessToken_cantRefreshSourceCredentials_throws() throws IOException {
    MockStsTransportFactory transportFactory = new MockStsTransportFactory();

    GoogleCredentials sourceCredentials =
        getServiceAccountSourceCredentials(/* canRefresh= */ false);

    DownscopedCredentials downscopedCredentials =
        DownscopedCredentials.newBuilder()
            .setSourceCredential(sourceCredentials)
            .setCredentialAccessBoundary(CREDENTIAL_ACCESS_BOUNDARY)
            .setHttpTransportFactory(transportFactory)
            .build();

    IOException e = assertThrows(IOException.class, downscopedCredentials::refreshAccessToken);
    assertEquals("Unable to refresh the provided source credential.", e.getMessage());
  }

  @Test
  void builder_noSourceCredential_throws() {
    DownscopedCredentials.Builder builder =
        DownscopedCredentials.newBuilder()
            .setHttpTransportFactory(OAuth2Utils.HTTP_TRANSPORT_FACTORY);
    assertThrows(NullPointerException.class, builder::build);
  }

  @Test
  void builder_noCredentialAccessBoundary_throws() throws IOException {
    DownscopedCredentials.Builder builder =
        DownscopedCredentials.newBuilder()
            .setHttpTransportFactory(OAuth2Utils.HTTP_TRANSPORT_FACTORY)
            .setSourceCredential(getServiceAccountSourceCredentials(/* canRefresh= */ true));
    assertThrows(NullPointerException.class, builder::build);
  }

  @Test
  void builder_noTransport_defaults() throws IOException {
    GoogleCredentials sourceCredentials =
        getServiceAccountSourceCredentials(/* canRefresh= */ true);
    DownscopedCredentials credentials =
        DownscopedCredentials.newBuilder()
            .setSourceCredential(sourceCredentials)
            .setCredentialAccessBoundary(CREDENTIAL_ACCESS_BOUNDARY)
            .build();

    GoogleCredentials scopedSourceCredentials =
        sourceCredentials.createScoped(OAuth2Utils.CLOUD_PLATFORM_SCOPE);
    assertEquals(scopedSourceCredentials, credentials.getSourceCredentials());
    assertEquals(CREDENTIAL_ACCESS_BOUNDARY, credentials.getCredentialAccessBoundary());
    assertEquals(OAuth2Utils.HTTP_TRANSPORT_FACTORY, credentials.getTransportFactory());
  }

  @Test
  void builder_noUniverseDomain_defaults() throws IOException {
    GoogleCredentials sourceCredentials =
        getServiceAccountSourceCredentials(/* canRefresh= */ true);
    DownscopedCredentials credentials =
        DownscopedCredentials.newBuilder()
            .setHttpTransportFactory(OAuth2Utils.HTTP_TRANSPORT_FACTORY)
            .setSourceCredential(sourceCredentials)
            .setCredentialAccessBoundary(CREDENTIAL_ACCESS_BOUNDARY)
            .build();

    GoogleCredentials scopedSourceCredentials =
        sourceCredentials.createScoped(OAuth2Utils.CLOUD_PLATFORM_SCOPE);
    assertEquals(OAuth2Utils.HTTP_TRANSPORT_FACTORY, credentials.getTransportFactory());
    assertEquals(scopedSourceCredentials, credentials.getSourceCredentials());
    assertEquals(CREDENTIAL_ACCESS_BOUNDARY, credentials.getCredentialAccessBoundary());
    assertEquals(GOOGLE_DEFAULT_UNIVERSE, credentials.getUniverseDomain());
  }

  @Test
  void builder_universeDomainMismatch_throws() throws IOException {
    GoogleCredentials sourceCredentials =
        getServiceAccountSourceCredentials(/* canRefresh= */ true);

    DownscopedCredentials.Builder builder =
        DownscopedCredentials.newBuilder()
            .setHttpTransportFactory(OAuth2Utils.HTTP_TRANSPORT_FACTORY)
            .setSourceCredential(sourceCredentials)
            .setCredentialAccessBoundary(CREDENTIAL_ACCESS_BOUNDARY)
            .setUniverseDomain("differentUniverseDomain");
    IllegalArgumentException e = assertThrows(IllegalArgumentException.class, builder::build);
    assertEquals(
        "The downscoped credential's universe domain must be the same as the source credential.",
        e.getMessage());
  }

  @Test
  void builder_sourceUniverseDomainUnavailable_throws() {
    GoogleCredentials sourceCredentials = new MockSourceCredentialWithoutUniverseDomain();

    DownscopedCredentials.Builder builder =
        DownscopedCredentials.newBuilder()
            .setHttpTransportFactory(OAuth2Utils.HTTP_TRANSPORT_FACTORY)
            .setSourceCredential(sourceCredentials)
            .setCredentialAccessBoundary(CREDENTIAL_ACCESS_BOUNDARY);
    IllegalStateException e = assertThrows(IllegalStateException.class, builder::build);
    assertEquals(
        "Error occurred when attempting to retrieve source credential universe domain.",
        e.getMessage());
  }

  private static GoogleCredentials getServiceAccountSourceCredentials(boolean canRefresh)
      throws IOException {
    MockTokenServerTransportFactory transportFactory = new MockTokenServerTransportFactory();

    String email = "service-account@google.com";

    ServiceAccountCredentials sourceCredentials =
        ServiceAccountCredentials.newBuilder()
            .setClientEmail(email)
            .setPrivateKey(OAuth2Utils.privateKeyFromPkcs8(SA_PRIVATE_KEY_PKCS8))
            .setPrivateKeyId("privateKeyId")
            .setProjectId("projectId")
            .setHttpTransportFactory(transportFactory)
            .build();

    transportFactory.transport.addServiceAccount(email, "accessToken");

    if (!canRefresh) {
      transportFactory.transport.setError(new IOException());
    }

    return sourceCredentials.createScoped(OAuth2Utils.CLOUD_PLATFORM_SCOPE);
  }

  private static GoogleCredentials getUserSourceCredentials() {
    MockTokenServerTransportFactory transportFactory = new MockTokenServerTransportFactory();
    transportFactory.transport.addClient("clientId", "clientSecret");
    transportFactory.transport.addRefreshToken("refreshToken", "accessToken");
    AccessToken accessToken = new AccessToken("accessToken", new Date());
    return UserCredentials.newBuilder()
        .setClientId("clientId")
        .setClientSecret("clientSecret")
        .setRefreshToken("refreshToken")
        .setAccessToken(accessToken)
        .setHttpTransportFactory(transportFactory)
        .build();
  }

  static class MockSourceCredentialWithoutUniverseDomain extends GoogleCredentials {
    @Override
    public String getUniverseDomain() throws IOException {
      throw new IOException();
    }
  }
}
