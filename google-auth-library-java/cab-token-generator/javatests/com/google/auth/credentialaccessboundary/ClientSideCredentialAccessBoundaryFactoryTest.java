/*
 * Copyright 2025, Google LLC
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

package com.google.auth.credentialaccessboundary;

import static com.google.auth.oauth2.OAuth2Utils.TOKEN_EXCHANGE_URL_FORMAT;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

import com.google.api.client.http.HttpTransport;
import com.google.api.client.util.Clock;
import com.google.auth.Credentials;
import com.google.auth.TestUtils;
import com.google.auth.credentialaccessboundary.ClientSideCredentialAccessBoundaryFactory.IntermediateCredentials;
import com.google.auth.credentialaccessboundary.ClientSideCredentialAccessBoundaryFactory.RefreshType;
import com.google.auth.credentialaccessboundary.protobuf.ClientSideAccessBoundary;
import com.google.auth.credentialaccessboundary.protobuf.ClientSideAccessBoundaryRule;
import com.google.auth.http.HttpTransportFactory;
import com.google.auth.oauth2.AccessToken;
import com.google.auth.oauth2.CredentialAccessBoundary;
import com.google.auth.oauth2.GoogleCredentials;
import com.google.auth.oauth2.MockStsTransport;
import com.google.auth.oauth2.MockTokenServerTransportFactory;
import com.google.auth.oauth2.OAuth2Utils;
import com.google.auth.oauth2.ServiceAccountCredentials;
import com.google.common.collect.ImmutableList;
import com.google.crypto.tink.Aead;
import com.google.crypto.tink.InsecureSecretKeyAccess;
import com.google.crypto.tink.KeysetHandle;
import com.google.crypto.tink.RegistryConfiguration;
import com.google.crypto.tink.TinkProtoKeysetFormat;
import dev.cel.common.CelValidationException;
import dev.cel.expr.Expr;
import java.io.IOException;
import java.security.GeneralSecurityException;
import java.time.Duration;
import java.util.Base64;
import java.util.Map;
import java.util.concurrent.CountDownLatch;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

/**
 * Tests for {@link
 * com.google.auth.credentialaccessboundary.ClientSideCredentialAccessBoundaryFactory}.
 */
class ClientSideCredentialAccessBoundaryFactoryTest {
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

  private MockStsTransportFactory mockStsTransportFactory;
  private static MockTokenServerTransportFactory mockTokenServerTransportFactory;

  static class MockStsTransportFactory implements HttpTransportFactory {
    MockStsTransport transport = new MockStsTransport();

    @Override
    public HttpTransport create() {
      return transport;
    }
  }

  @BeforeEach
  void setUp() {
    mockStsTransportFactory = new MockStsTransportFactory();
    mockStsTransportFactory.transport.setReturnAccessBoundarySessionKey(true);

    mockTokenServerTransportFactory = new MockTokenServerTransportFactory();
    mockTokenServerTransportFactory.transport.addServiceAccount(
        "service-account@google.com", "accessToken");
  }

  @Test
  void fetchIntermediateCredentials() throws Exception {
    GoogleCredentials sourceCredentials =
        getServiceAccountSourceCredentials(mockTokenServerTransportFactory);

    ClientSideCredentialAccessBoundaryFactory factory =
        ClientSideCredentialAccessBoundaryFactory.newBuilder()
            .setSourceCredential(sourceCredentials)
            .setHttpTransportFactory(mockStsTransportFactory)
            .build();

    IntermediateCredentials intermediateCredentials = factory.fetchIntermediateCredentials();

    // Verify requested token type.
    Map<String, String> query =
        TestUtils.parseQuery(mockStsTransportFactory.transport.getRequest().getContentAsString());
    assertEquals(
        OAuth2Utils.TOKEN_TYPE_ACCESS_BOUNDARY_INTERMEDIARY_TOKEN,
        query.get("requested_token_type"));

    // Verify intermediate token and session key.
    assertEquals(
        mockStsTransportFactory.transport.getAccessBoundarySessionKey(),
        intermediateCredentials.getAccessBoundarySessionKey());
    assertEquals(
        mockStsTransportFactory.transport.getAccessToken(),
        intermediateCredentials.getIntermediateAccessToken().getTokenValue());
  }

  @Test
  void fetchIntermediateCredentials_withCustomUniverseDomain() throws IOException {
    String universeDomain = "foobar";
    GoogleCredentials sourceCredentials =
        getServiceAccountSourceCredentials(mockTokenServerTransportFactory).toBuilder()
            .setUniverseDomain(universeDomain)
            .build();

    ClientSideCredentialAccessBoundaryFactory factory =
        ClientSideCredentialAccessBoundaryFactory.newBuilder()
            .setUniverseDomain(universeDomain)
            .setSourceCredential(sourceCredentials)
            .setHttpTransportFactory(mockStsTransportFactory)
            .build();

    factory.fetchIntermediateCredentials();

    // Verify domain.
    String url = mockStsTransportFactory.transport.getRequest().getUrl();
    assertEquals(url, String.format(TOKEN_EXCHANGE_URL_FORMAT, universeDomain));
  }

  @Test
  void fetchIntermediateCredentials_sourceCredentialCannotRefresh_throwsIOException()
      throws Exception {
    // Simulate error when refreshing the source credential.
    mockTokenServerTransportFactory.transport.setError(new IOException());

    GoogleCredentials sourceCredentials =
        getServiceAccountSourceCredentials(mockTokenServerTransportFactory);

    ClientSideCredentialAccessBoundaryFactory factory =
        ClientSideCredentialAccessBoundaryFactory.newBuilder()
            .setSourceCredential(sourceCredentials)
            .setHttpTransportFactory(mockStsTransportFactory)
            .build();

    IOException thrown = assertThrows(IOException.class, factory::fetchIntermediateCredentials);
    assertEquals("Unable to refresh the provided source credential.", thrown.getMessage());
  }

  @Test
  void fetchIntermediateCredentials_noExpiresInReturned_copiesSourceExpiration() throws Exception {
    // Simulate STS not returning expires_in.
    mockStsTransportFactory.transport.setReturnExpiresIn(false);

    GoogleCredentials sourceCredentials =
        getServiceAccountSourceCredentials(mockTokenServerTransportFactory);

    ClientSideCredentialAccessBoundaryFactory factory =
        ClientSideCredentialAccessBoundaryFactory.newBuilder()
            .setSourceCredential(sourceCredentials)
            .setHttpTransportFactory(mockStsTransportFactory)
            .build();

    IntermediateCredentials intermediateCredentials = factory.fetchIntermediateCredentials();
    AccessToken intermediateAccessToken = intermediateCredentials.getIntermediateAccessToken();

    assertEquals(
        mockStsTransportFactory.transport.getAccessToken(),
        intermediateAccessToken.getTokenValue());

    // Validate that the expires_in has been copied from the source credential.
    AccessToken sourceAccessToken = sourceCredentials.getAccessToken();
    assertNotNull(sourceAccessToken);
    assertEquals(
        sourceAccessToken.getExpirationTime(), intermediateAccessToken.getExpirationTime());
  }

  @Test
  void refreshCredentialsIfRequired_firstCallWillFetchIntermediateCredentials() throws IOException {
    GoogleCredentials sourceCredentials =
        getServiceAccountSourceCredentials(mockTokenServerTransportFactory);

    ClientSideCredentialAccessBoundaryFactory factory =
        ClientSideCredentialAccessBoundaryFactory.newBuilder()
            .setSourceCredential(sourceCredentials)
            .setHttpTransportFactory(mockStsTransportFactory)
            .build();

    // Verify that the first call to refreshCredentialsIfRequired() triggers a fetch of intermediate
    // credentials, resulting in one request to the STS endpoint. This happens because the
    // intermediate credentials are initially null.
    assertEquals(0, mockStsTransportFactory.transport.getRequestCount());
    factory.refreshCredentialsIfRequired();
    assertEquals(1, mockStsTransportFactory.transport.getRequestCount());
  }

  @Test
  void refreshCredentialsIfRequired_noRefreshNeeded() throws IOException {
    final ClientSideCredentialAccessBoundaryFactory factory =
        getClientSideCredentialAccessBoundaryFactory(RefreshType.NONE);

    // Call refreshCredentialsIfRequired() once to initialize the intermediate credentials. This
    // should make one request to the STS endpoint.
    factory.refreshCredentialsIfRequired();

    // Verify that a subsequent call to refreshCredentialsIfRequired() does NOT trigger another
    // refresh, as the token is still valid. The request count should remain the same.
    assertEquals(1, mockStsTransportFactory.transport.getRequestCount());
    factory.refreshCredentialsIfRequired();
    assertEquals(1, mockStsTransportFactory.transport.getRequestCount());
  }

  @Test
  void refreshCredentialsIfRequired_blockingSingleThread() throws IOException {
    final ClientSideCredentialAccessBoundaryFactory factory =
        getClientSideCredentialAccessBoundaryFactory(RefreshType.BLOCKING);

    // Call refreshCredentialsIfRequired() once to initialize the intermediate credentials. This
    // should make one request to the STS endpoint.
    factory.refreshCredentialsIfRequired();
    assertEquals(1, mockStsTransportFactory.transport.getRequestCount());

    // Simulate multiple calls to refreshCredentialsIfRequired. In blocking mode, each call should
    // trigger a new request to the STS endpoint.
    int numRefresh = 3;
    for (int i = 0; i < numRefresh; i++) {
      factory.refreshCredentialsIfRequired();
    }

    // Verify that the total number of requests to the STS endpoint is the initial request plus the
    // number of subsequent refresh calls.
    assertEquals(1 + numRefresh, mockStsTransportFactory.transport.getRequestCount());
  }

  @Test
  void refreshCredentialsIfRequired_asyncSingleThread() throws IOException {
    final ClientSideCredentialAccessBoundaryFactory factory =
        getClientSideCredentialAccessBoundaryFactory(RefreshType.ASYNC);

    // Call refreshCredentialsIfRequired() once to initialize the intermediate credentials. This
    // should make one request to the STS endpoint.
    factory.refreshCredentialsIfRequired();
    assertEquals(1, mockStsTransportFactory.transport.getRequestCount());

    // Subsequent calls to refreshCredentialsIfRequired() in an async mode should NOT
    // immediately call the STS endpoint. They should schedule an asynchronous refresh.
    int numRefresh = 3;
    for (int i = 0; i < numRefresh; i++) {
      factory.refreshCredentialsIfRequired();
    }

    // Verify that only the initial call resulted in an immediate STS request. The async refresh
    // is still pending.
    assertEquals(1, mockStsTransportFactory.transport.getRequestCount());

    // Introduce a small delay to allow the asynchronous refresh task to complete.  This is
    // necessary because the async task runs on a separate thread.
    try {
      Thread.sleep(1000);
    } catch (InterruptedException e) {
      throw new IOException(e);
    }

    // After the delay, the request count should be 2 (initial fetch + one async refresh).
    // Subsequent calls to refreshCredentialsIfRequired() in ASYNC mode re-use the in-progress
    // refresh task, so they don't trigger additional STS requests.
    assertEquals(2, mockStsTransportFactory.transport.getRequestCount());
  }

  @Test
  void refreshCredentialsIfRequired_blockingMultiThread() throws IOException, InterruptedException {
    final ClientSideCredentialAccessBoundaryFactory factory =
        getClientSideCredentialAccessBoundaryFactory(RefreshType.BLOCKING);

    // Call refreshCredentialsIfRequired() once to initialize the intermediate credentials. This
    // should make one request to the STS endpoint.
    factory.refreshCredentialsIfRequired();
    assertEquals(1, mockStsTransportFactory.transport.getRequestCount());

    // Simulate multiple threads concurrently calling refreshCredentialsIfRequired(). In blocking
    // mode, only one of these calls should trigger a new request to the STS endpoint. The others
    // should block until the first refresh completes and then use the newly acquired credentials.
    triggerConcurrentRefresh(factory, 3);

    // After all threads complete, the request count should be 2 (the initial fetch plus one
    // blocking refresh).
    assertEquals(2, mockStsTransportFactory.transport.getRequestCount());
  }

  @Test
  void refreshCredentialsIfRequired_asyncMultiThread() throws IOException, InterruptedException {
    final ClientSideCredentialAccessBoundaryFactory factory =
        getClientSideCredentialAccessBoundaryFactory(RefreshType.ASYNC);

    // Call refreshCredentialsIfRequired() once to initialize the intermediate credentials. This
    // should make one request to the STS endpoint.
    factory.refreshCredentialsIfRequired();
    assertEquals(1, mockStsTransportFactory.transport.getRequestCount());

    // Simulate multiple threads concurrently calling refreshCredentialsIfRequired(). In async
    // mode, the first call should trigger a background refresh. Subsequent calls should NOT
    // trigger additional refreshes while the background refresh is still pending.
    triggerConcurrentRefresh(factory, 5);

    // Introduce a small delay to allow the asynchronous refresh task to complete.
    try {
      Thread.sleep(100);
    } catch (InterruptedException e) {
      throw new IOException(e);
    }

    // After the delay, the request count should be 2, indicating that the initial fetch and a
    // single async refresh occurred (not one per thread).
    assertEquals(2, mockStsTransportFactory.transport.getRequestCount());
  }

  @Test
  void refreshCredentialsIfRequired_sourceCredentialCannotRefresh_throwsIOException()
      throws Exception {
    // Simulate error when refreshing the source credential.
    mockTokenServerTransportFactory.transport.setError(new IOException());

    GoogleCredentials sourceCredentials =
        getServiceAccountSourceCredentials(mockTokenServerTransportFactory);

    ClientSideCredentialAccessBoundaryFactory factory =
        ClientSideCredentialAccessBoundaryFactory.newBuilder()
            .setSourceCredential(sourceCredentials)
            .setHttpTransportFactory(mockStsTransportFactory)
            .build();

    IOException exception = assertThrows(IOException.class, factory::refreshCredentialsIfRequired);
    assertEquals("Unable to refresh the provided source credential.", exception.getMessage());
  }

  // Tests related to the builder methods.
  @Test
  void builder_noSourceCredential_throws() {
    NullPointerException exception =
        assertThrows(
            NullPointerException.class,
            () ->
                ClientSideCredentialAccessBoundaryFactory.newBuilder()
                    .setHttpTransportFactory(OAuth2Utils.HTTP_TRANSPORT_FACTORY)
                    .build());
    assertEquals("Source credential must not be null.", exception.getMessage());
  }

  @Test
  void builder_minimumTokenLifetime_negative_throws() throws IOException {
    GoogleCredentials sourceCredentials =
        getServiceAccountSourceCredentials(mockTokenServerTransportFactory);
    IllegalArgumentException exception =
        assertThrows(
            IllegalArgumentException.class,
            () ->
                ClientSideCredentialAccessBoundaryFactory.newBuilder()
                    .setSourceCredential(sourceCredentials)
                    .setMinimumTokenLifetime(Duration.ofMinutes(-1)));

    assertEquals("Minimum token lifetime must be greater than zero.", exception.getMessage());
  }

  @Test
  void builder_minimumTokenLifetime_zero_throws() throws IOException {
    GoogleCredentials sourceCredentials =
        getServiceAccountSourceCredentials(mockTokenServerTransportFactory);
    IllegalArgumentException exception =
        assertThrows(
            IllegalArgumentException.class,
            () ->
                ClientSideCredentialAccessBoundaryFactory.newBuilder()
                    .setSourceCredential(sourceCredentials)
                    .setMinimumTokenLifetime(Duration.ZERO));

    assertEquals("Minimum token lifetime must be greater than zero.", exception.getMessage());
  }

  @Test
  void builder_refreshMargin_negative_throws() throws IOException {
    GoogleCredentials sourceCredentials =
        getServiceAccountSourceCredentials(mockTokenServerTransportFactory);
    IllegalArgumentException exception =
        assertThrows(
            IllegalArgumentException.class,
            () ->
                ClientSideCredentialAccessBoundaryFactory.newBuilder()
                    .setSourceCredential(sourceCredentials)
                    .setRefreshMargin(Duration.ofMinutes(-1)));

    assertEquals("Refresh margin must be greater than zero.", exception.getMessage());
  }

  @Test
  void builder_refreshMargin_zero_throws() throws IOException {
    GoogleCredentials sourceCredentials =
        getServiceAccountSourceCredentials(mockTokenServerTransportFactory);
    IllegalArgumentException exception =
        assertThrows(
            IllegalArgumentException.class,
            () ->
                ClientSideCredentialAccessBoundaryFactory.newBuilder()
                    .setSourceCredential(sourceCredentials)
                    .setRefreshMargin(Duration.ZERO));

    assertEquals("Refresh margin must be greater than zero.", exception.getMessage());
  }

  @Test
  void builder_setsCorrectDefaultValues() throws IOException {
    GoogleCredentials sourceCredentials =
        getServiceAccountSourceCredentials(mockTokenServerTransportFactory);
    ClientSideCredentialAccessBoundaryFactory factory =
        ClientSideCredentialAccessBoundaryFactory.newBuilder()
            .setSourceCredential(sourceCredentials)
            .build();

    assertEquals(OAuth2Utils.HTTP_TRANSPORT_FACTORY, factory.getTransportFactory());
    assertEquals(
        String.format(OAuth2Utils.TOKEN_EXCHANGE_URL_FORMAT, Credentials.GOOGLE_DEFAULT_UNIVERSE),
        factory.getTokenExchangeEndpoint());
  }

  @Test
  void builder_universeDomainMismatch_throws() throws IOException {
    GoogleCredentials sourceCredentials =
        getServiceAccountSourceCredentials(mockTokenServerTransportFactory);

    IllegalArgumentException exception =
        assertThrows(
            IllegalArgumentException.class,
            () ->
                ClientSideCredentialAccessBoundaryFactory.newBuilder()
                    .setSourceCredential(sourceCredentials)
                    .setUniverseDomain("differentUniverseDomain")
                    .build());
    assertEquals(
        "The client side access boundary credential's universe domain must be the same as the source credential.",
        exception.getMessage());
  }

  @Test
  void builder_invalidRefreshMarginAndMinimumTokenLifetime_throws() throws IOException {
    GoogleCredentials sourceCredentials =
        getServiceAccountSourceCredentials(mockTokenServerTransportFactory);

    IllegalArgumentException exception =
        assertThrows(
            IllegalArgumentException.class,
            () ->
                ClientSideCredentialAccessBoundaryFactory.newBuilder()
                    .setSourceCredential(sourceCredentials)
                    .setRefreshMargin(Duration.ofMinutes(50))
                    .setMinimumTokenLifetime(Duration.ofMinutes(50))
                    .build());

    assertEquals(
        "Refresh margin must be at least one minute longer than the minimum token lifetime.",
        exception.getMessage());
  }

  @Test
  void builder_invalidRefreshMargin_throws() throws IOException {
    GoogleCredentials sourceCredentials =
        getServiceAccountSourceCredentials(mockTokenServerTransportFactory);

    IllegalArgumentException exception =
        assertThrows(
            IllegalArgumentException.class,
            () ->
                ClientSideCredentialAccessBoundaryFactory.newBuilder()
                    .setSourceCredential(sourceCredentials)
                    .setRefreshMargin(Duration.ofMinutes(25))
                    .build());

    assertEquals(
        "Refresh margin must be at least one minute longer than the minimum token lifetime.",
        exception.getMessage());
  }

  @Test
  void builder_invalidMinimumTokenLifetime_throws() throws IOException {
    GoogleCredentials sourceCredentials =
        getServiceAccountSourceCredentials(mockTokenServerTransportFactory);

    IllegalArgumentException exception =
        assertThrows(
            IllegalArgumentException.class,
            () ->
                ClientSideCredentialAccessBoundaryFactory.newBuilder()
                    .setSourceCredential(sourceCredentials)
                    .setMinimumTokenLifetime(Duration.ofMinutes(50))
                    .build());

    assertEquals(
        "Refresh margin must be at least one minute longer than the minimum token lifetime.",
        exception.getMessage());
  }

  @Test
  void builder_minimumTokenLifetimeNotSet_usesDefault() throws IOException {
    GoogleCredentials sourceCredentials =
        getServiceAccountSourceCredentials(mockTokenServerTransportFactory);

    ClientSideCredentialAccessBoundaryFactory factory =
        ClientSideCredentialAccessBoundaryFactory.newBuilder()
            .setSourceCredential(sourceCredentials)
            .setRefreshMargin(Duration.ofMinutes(50))
            .build();

    assertEquals(
        ClientSideCredentialAccessBoundaryFactory.DEFAULT_MINIMUM_TOKEN_LIFETIME,
        factory.getMinimumTokenLifetime());
  }

  @Test
  void builder_refreshMarginNotSet_usesDefault() throws IOException {
    GoogleCredentials sourceCredentials =
        getServiceAccountSourceCredentials(mockTokenServerTransportFactory);

    ClientSideCredentialAccessBoundaryFactory factory =
        ClientSideCredentialAccessBoundaryFactory.newBuilder()
            .setSourceCredential(sourceCredentials)
            .setMinimumTokenLifetime(Duration.ofMinutes(20))
            .build();

    assertEquals(
        ClientSideCredentialAccessBoundaryFactory.DEFAULT_REFRESH_MARGIN,
        factory.getRefreshMargin());
  }

  private static GoogleCredentials getServiceAccountSourceCredentials(
      MockTokenServerTransportFactory transportFactory) throws IOException {
    String email = "service-account@google.com";

    ServiceAccountCredentials sourceCredentials =
        ServiceAccountCredentials.newBuilder()
            .setClientEmail(email)
            .setPrivateKey(OAuth2Utils.privateKeyFromPkcs8(SA_PRIVATE_KEY_PKCS8))
            .setPrivateKeyId("privateKeyId")
            .setProjectId("projectId")
            .setHttpTransportFactory(transportFactory)
            .build();

    return sourceCredentials.createScoped("https://www.googleapis.com/auth/cloud-platform");
  }

  private ClientSideCredentialAccessBoundaryFactory getClientSideCredentialAccessBoundaryFactory(
      RefreshType refreshType) throws IOException {
    GoogleCredentials sourceCredentials =
        getServiceAccountSourceCredentials(mockTokenServerTransportFactory);

    return ClientSideCredentialAccessBoundaryFactory.newBuilder()
        .setSourceCredential(sourceCredentials)
        .setHttpTransportFactory(mockStsTransportFactory)
        .setClock(createMockClock(refreshType, sourceCredentials))
        .build();
  }

  private Clock createMockClock(RefreshType refreshType, GoogleCredentials sourceCredentials) {
    Clock mockClock = mock(Clock.class);
    long currentTimeInMillis = Clock.SYSTEM.currentTimeMillis();
    long mockedTimeInMillis;
    final long refreshMarginInMillis =
        ClientSideCredentialAccessBoundaryFactory.DEFAULT_REFRESH_MARGIN.toMillis();
    final long minimumTokenLifetimeMillis =
        ClientSideCredentialAccessBoundaryFactory.DEFAULT_MINIMUM_TOKEN_LIFETIME.toMillis();

    // If the source credential doesn't have an access token, set the expiration time to 1 hour from
    // the current time.
    long expirationTimeInMillis =
        sourceCredentials.getAccessToken() != null
            ? sourceCredentials.getAccessToken().getExpirationTime().getTime()
            : currentTimeInMillis + 3600000;

    switch (refreshType) {
      case NONE:
        // Set mocked time so that the token is fresh and no refresh is needed (before the refresh
        // margin).
        mockedTimeInMillis = expirationTimeInMillis - refreshMarginInMillis - 60000;
        break;
      case ASYNC:
        // Set mocked time so that the token is nearing expiry and an async refresh is triggered
        // (within the refresh margin).
        mockedTimeInMillis = expirationTimeInMillis - refreshMarginInMillis + 60000;
        break;
      case BLOCKING:
        // Set mocked time so that the token requires immediate refresh (just after the minimum
        // token lifetime).
        mockedTimeInMillis = expirationTimeInMillis - minimumTokenLifetimeMillis + 60000;
        break;
      default:
        throw new IllegalArgumentException("Unexpected RefreshType: " + refreshType);
    }

    when(mockClock.currentTimeMillis()).thenReturn(mockedTimeInMillis);
    return mockClock;
  }

  private static void triggerConcurrentRefresh(
      ClientSideCredentialAccessBoundaryFactory factory, int numThreads)
      throws InterruptedException {
    Thread[] threads = new Thread[numThreads];
    CountDownLatch latch = new CountDownLatch(numThreads);
    long timeoutMillis = 5000; // 5 seconds

    // Create and start threads to concurrently call refreshCredentialsIfRequired().
    for (int i = 0; i < numThreads; i++) {
      threads[i] =
          new Thread(
              () -> {
                try {
                  latch.countDown();
                  latch.await();
                  factory.refreshCredentialsIfRequired();
                } catch (InterruptedException e) {
                  Thread.currentThread().interrupt();
                } catch (IOException e) {
                  throw new RuntimeException(e);
                }
              });
      threads[i].start();
    }

    // Wait for each thread to complete, with a timeout.
    for (Thread thread : threads) {
      thread.join(timeoutMillis);
      if (thread.isAlive()) {
        thread.interrupt();
        throw new AssertionError(
            "Thread running refreshCredentialsIfRequired timed out after "
                + timeoutMillis
                + " milliseconds.");
      }
    }
  }

  private static class CabToken {
    String intermediateToken;
    String encryptedRestriction;

    CabToken(String intermediateToken, String encryptedRestriction) {
      this.intermediateToken = intermediateToken;
      this.encryptedRestriction = encryptedRestriction;
    }
  }

  private static CabToken parseCabToken(AccessToken token) {
    String[] parts = token.getTokenValue().split("\\.");
    assertEquals(2, parts.length);

    return new CabToken(parts[0], parts[1]);
  }

  private static ClientSideAccessBoundary decryptRestriction(String restriction, String sessionKey)
      throws Exception {
    byte[] rawKey = Base64.getDecoder().decode(sessionKey);

    KeysetHandle keysetHandle =
        TinkProtoKeysetFormat.parseKeyset(rawKey, InsecureSecretKeyAccess.get());

    Aead aead = keysetHandle.getPrimitive(RegistryConfiguration.get(), Aead.class);
    byte[] rawRestrictions =
        aead.decrypt(Base64.getUrlDecoder().decode(restriction), /* associatedData= */ new byte[0]);

    return ClientSideAccessBoundary.parseFrom(rawRestrictions);
  }

  @Test
  void generateToken_withAvailablityCondition_success() throws Exception {
    MockStsTransportFactory transportFactory = new MockStsTransportFactory();
    transportFactory.transport.setReturnAccessBoundarySessionKey(true);

    ClientSideCredentialAccessBoundaryFactory.Builder builder =
        ClientSideCredentialAccessBoundaryFactory.newBuilder();

    ClientSideCredentialAccessBoundaryFactory factory =
        builder
            .setSourceCredential(
                getServiceAccountSourceCredentials(mockTokenServerTransportFactory))
            .setHttpTransportFactory(transportFactory)
            .build();

    CredentialAccessBoundary.Builder cabBuilder = CredentialAccessBoundary.newBuilder();
    CredentialAccessBoundary accessBoundary =
        cabBuilder
            .addRule(
                CredentialAccessBoundary.AccessBoundaryRule.newBuilder()
                    .setAvailableResource("resource")
                    .setAvailablePermissions(ImmutableList.of("role1", "role2"))
                    .setAvailabilityCondition(
                        CredentialAccessBoundary.AccessBoundaryRule.AvailabilityCondition
                            .newBuilder()
                            .setExpression("a == b")
                            .build())
                    .build())
            .build();

    AccessToken token = factory.generateToken(accessBoundary);

    CabToken cabToken = parseCabToken(token);
    assertEquals("accessToken", cabToken.intermediateToken);

    // Base64 encoding output by default has `=` padding at the end if the input length
    // is not a multiple of 3. Here we verify the use of `withoutPadding` that removes
    // this padding.
    assertFalse(cabToken.encryptedRestriction.contains(String.valueOf("=")));

    // Checks the encrypted restriction is the correct proto format of the CredentialAccessBoundary.
    ClientSideAccessBoundary clientSideAccessBoundary =
        decryptRestriction(
            cabToken.encryptedRestriction,
            transportFactory.transport.getAccessBoundarySessionKey());
    assertEquals(1, clientSideAccessBoundary.getAccessBoundaryRulesCount());

    ClientSideAccessBoundaryRule rule = clientSideAccessBoundary.getAccessBoundaryRules(0);

    // Available resource and available permission should be the exact same as in original format.
    assertEquals("resource", rule.getAvailableResource());
    assertEquals(ImmutableList.of("role1", "role2"), rule.getAvailablePermissionsList());

    // Availability condition should be in the correct compiled proto format.
    Expr expr = rule.getCompiledAvailabilityCondition();
    assertEquals("_==_", expr.getCallExpr().getFunction());
    assertEquals("a", expr.getCallExpr().getArgs(0).getIdentExpr().getName());
    assertEquals("b", expr.getCallExpr().getArgs(1).getIdentExpr().getName());
  }

  @Test
  void generateToken_withoutAvailabilityCondition_success() throws Exception {
    MockStsTransportFactory transportFactory = new MockStsTransportFactory();
    transportFactory.transport.setReturnAccessBoundarySessionKey(true);

    ClientSideCredentialAccessBoundaryFactory.Builder builder =
        ClientSideCredentialAccessBoundaryFactory.newBuilder();

    ClientSideCredentialAccessBoundaryFactory factory =
        builder
            .setSourceCredential(
                getServiceAccountSourceCredentials(mockTokenServerTransportFactory))
            .setHttpTransportFactory(transportFactory)
            .build();

    CredentialAccessBoundary.Builder cabBuilder = CredentialAccessBoundary.newBuilder();
    CredentialAccessBoundary accessBoundary =
        cabBuilder
            .addRule(
                CredentialAccessBoundary.AccessBoundaryRule.newBuilder()
                    .setAvailableResource("resource")
                    .setAvailablePermissions(ImmutableList.of("role"))
                    .build())
            .build();

    AccessToken token = factory.generateToken(accessBoundary);

    CabToken cabToken = parseCabToken(token);
    assertEquals("accessToken", cabToken.intermediateToken);

    // Base64 encoding output by default has `=` padding at the end if the input length
    // is not a multiple of 3. Here we verify the use of `withoutPadding` that removes
    // this padding.
    assertFalse(cabToken.encryptedRestriction.contains(String.valueOf("=")));

    // Checks the encrypted restriction is the correct proto format of the CredentialAccessBoundary.
    ClientSideAccessBoundary clientSideAccessBoundary =
        decryptRestriction(
            cabToken.encryptedRestriction,
            transportFactory.transport.getAccessBoundarySessionKey());
    assertEquals(1, clientSideAccessBoundary.getAccessBoundaryRulesCount());

    ClientSideAccessBoundaryRule rule = clientSideAccessBoundary.getAccessBoundaryRules(0);

    // Available resource and available permission should be the exact same as in original format.
    assertEquals("resource", rule.getAvailableResource());
    assertEquals(ImmutableList.of("role"), rule.getAvailablePermissionsList());

    // Availability condition should be empty since it's not provided.
    assertFalse(rule.hasCompiledAvailabilityCondition());
  }

  @Test
  void generateToken_withMultipleRules_success() throws Exception {
    MockStsTransportFactory transportFactory = new MockStsTransportFactory();
    transportFactory.transport.setReturnAccessBoundarySessionKey(true);

    ClientSideCredentialAccessBoundaryFactory.Builder builder =
        ClientSideCredentialAccessBoundaryFactory.newBuilder();

    ClientSideCredentialAccessBoundaryFactory factory =
        builder
            .setSourceCredential(
                getServiceAccountSourceCredentials(mockTokenServerTransportFactory))
            .setHttpTransportFactory(transportFactory)
            .build();

    CredentialAccessBoundary.Builder cabBuilder = CredentialAccessBoundary.newBuilder();
    CredentialAccessBoundary accessBoundary =
        cabBuilder
            .addRule(
                CredentialAccessBoundary.AccessBoundaryRule.newBuilder()
                    .setAvailableResource("resource1")
                    .setAvailablePermissions(ImmutableList.of("role1-1", "role1-2"))
                    .setAvailabilityCondition(
                        CredentialAccessBoundary.AccessBoundaryRule.AvailabilityCondition
                            .newBuilder()
                            .setExpression("a == b")
                            .build())
                    .build())
            .addRule(
                CredentialAccessBoundary.AccessBoundaryRule.newBuilder()
                    .setAvailableResource("resource")
                    .setAvailablePermissions(ImmutableList.of("role2"))
                    .build())
            .build();

    AccessToken token = factory.generateToken(accessBoundary);

    CabToken cabToken = parseCabToken(token);
    assertEquals("accessToken", cabToken.intermediateToken);

    // Checks the encrypted restriction is the correct proto format of the CredentialAccessBoundary.
    ClientSideAccessBoundary clientSideAccessBoundary =
        decryptRestriction(
            cabToken.encryptedRestriction,
            transportFactory.transport.getAccessBoundarySessionKey());
    assertEquals(2, clientSideAccessBoundary.getAccessBoundaryRulesCount());

    // Checks the first rule.
    ClientSideAccessBoundaryRule rule1 = clientSideAccessBoundary.getAccessBoundaryRules(0);
    assertEquals("resource1", rule1.getAvailableResource());
    assertEquals(ImmutableList.of("role1-1", "role1-2"), rule1.getAvailablePermissionsList());

    Expr expr = rule1.getCompiledAvailabilityCondition();
    assertEquals("_==_", expr.getCallExpr().getFunction());
    assertEquals("a", expr.getCallExpr().getArgs(0).getIdentExpr().getName());
    assertEquals("b", expr.getCallExpr().getArgs(1).getIdentExpr().getName());

    // Checks the second rule.
    ClientSideAccessBoundaryRule rule2 = clientSideAccessBoundary.getAccessBoundaryRules(1);
    assertEquals("resource", rule2.getAvailableResource());
    assertEquals(ImmutableList.of("role2"), rule2.getAvailablePermissionsList());
    assertFalse(rule2.hasCompiledAvailabilityCondition());
  }

  @Test
  void generateToken_withInvalidAvailabilityCondition_failure() throws Exception {
    MockStsTransportFactory transportFactory = new MockStsTransportFactory();
    transportFactory.transport.setReturnAccessBoundarySessionKey(true);

    ClientSideCredentialAccessBoundaryFactory.Builder builder =
        ClientSideCredentialAccessBoundaryFactory.newBuilder();

    ClientSideCredentialAccessBoundaryFactory factory =
        builder
            .setSourceCredential(
                getServiceAccountSourceCredentials(mockTokenServerTransportFactory))
            .setHttpTransportFactory(transportFactory)
            .build();

    CredentialAccessBoundary.Builder cabBuilder = CredentialAccessBoundary.newBuilder();
    CredentialAccessBoundary accessBoundary =
        cabBuilder
            .addRule(
                CredentialAccessBoundary.AccessBoundaryRule.newBuilder()
                    .setAvailableResource(
                        "//storage.googleapis.com/projects/" + "_/buckets/example-bucket")
                    .setAvailablePermissions(ImmutableList.of("inRole:roles/storage.objectViewer"))
                    .setAvailabilityCondition(
                        CredentialAccessBoundary.AccessBoundaryRule.AvailabilityCondition
                            .newBuilder()
                            .setExpression(
                                "resource.name.startsWith('projects/_/"
                                    + "buckets/example-bucket/objects/"
                                    + "customer-a'") // No closing bracket
                            .build())
                    .build())
            .build();

    assertThrows(CelValidationException.class, () -> factory.generateToken(accessBoundary));
  }

  @Test
  void generateToken_withSessionKeyNotBase64Encoded_failure() throws Exception {
    MockStsTransportFactory transportFactory = new MockStsTransportFactory();
    transportFactory.transport.setReturnAccessBoundarySessionKey(true);
    transportFactory.transport.setAccessBoundarySessionKey("invalid_key");

    ClientSideCredentialAccessBoundaryFactory.Builder builder =
        ClientSideCredentialAccessBoundaryFactory.newBuilder();

    ClientSideCredentialAccessBoundaryFactory factory =
        builder
            .setSourceCredential(
                getServiceAccountSourceCredentials(mockTokenServerTransportFactory))
            .setHttpTransportFactory(transportFactory)
            .build();

    CredentialAccessBoundary.Builder cabBuilder = CredentialAccessBoundary.newBuilder();
    CredentialAccessBoundary accessBoundary =
        cabBuilder
            .addRule(
                CredentialAccessBoundary.AccessBoundaryRule.newBuilder()
                    .setAvailableResource(
                        "//storage.googleapis.com/projects/" + "_/buckets/example-bucket")
                    .setAvailablePermissions(ImmutableList.of("inRole:roles/storage.objectViewer"))
                    .setAvailabilityCondition(
                        CredentialAccessBoundary.AccessBoundaryRule.AvailabilityCondition
                            .newBuilder()
                            .setExpression(
                                "resource.name.startsWith('projects/_/"
                                    + "buckets/example-bucket/objects/customer-a')")
                            .build())
                    .build())
            .build();

    assertThrows(IllegalStateException.class, () -> factory.generateToken(accessBoundary));
  }

  @Test
  void generateToken_withMalformSessionKey_failure() throws Exception {
    MockStsTransportFactory transportFactory = new MockStsTransportFactory();
    transportFactory.transport.setReturnAccessBoundarySessionKey(true);
    transportFactory.transport.setAccessBoundarySessionKey("aW52YWxpZF9rZXk=");

    ClientSideCredentialAccessBoundaryFactory.Builder builder =
        ClientSideCredentialAccessBoundaryFactory.newBuilder();

    ClientSideCredentialAccessBoundaryFactory factory =
        builder
            .setSourceCredential(
                getServiceAccountSourceCredentials(mockTokenServerTransportFactory))
            .setHttpTransportFactory(transportFactory)
            .build();

    CredentialAccessBoundary.Builder cabBuilder = CredentialAccessBoundary.newBuilder();
    CredentialAccessBoundary accessBoundary =
        cabBuilder
            .addRule(
                CredentialAccessBoundary.AccessBoundaryRule.newBuilder()
                    .setAvailableResource(
                        "//storage.googleapis.com/projects/" + "_/buckets/example-bucket")
                    .setAvailablePermissions(ImmutableList.of("inRole:roles/storage.objectViewer"))
                    .setAvailabilityCondition(
                        CredentialAccessBoundary.AccessBoundaryRule.AvailabilityCondition
                            .newBuilder()
                            .setExpression(
                                "resource.name.startsWith('projects/_/"
                                    + "buckets/example-bucket/objects/customer-a')")
                            .build())
                    .build())
            .build();

    assertThrows(GeneralSecurityException.class, () -> factory.generateToken(accessBoundary));
  }
}
