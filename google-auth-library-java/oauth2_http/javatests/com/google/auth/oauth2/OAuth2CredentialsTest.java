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

import static java.util.concurrent.TimeUnit.HOURS;
import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNotEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;

import com.google.api.client.util.Clock;
import com.google.auth.TestClock;
import com.google.auth.TestUtils;
import com.google.auth.http.AuthHttpConstants;
import com.google.auth.oauth2.OAuth2Credentials.OAuthValue;
import com.google.auth.oauth2.OAuth2Credentials.RefreshTask;
import com.google.common.collect.ImmutableList;
import com.google.common.collect.ImmutableMap;
import com.google.common.util.concurrent.ListenableFutureTask;
import com.google.common.util.concurrent.SettableFuture;
import java.io.IOException;
import java.net.URI;
import java.time.Duration;
import java.time.Instant;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.FutureTask;
import java.util.concurrent.TimeoutException;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicReference;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;

/** Test case for {@link OAuth2Credentials}. */
class OAuth2CredentialsTest extends BaseSerializationTest {

  private static final String CLIENT_SECRET = "jakuaL9YyieakhECKL2SwZcu";
  private static final String CLIENT_ID = "ya29.1.AADtN_UtlxN3PuGAxrN2XQnZTVRvDyVWnYq4I6dws";
  private static final String REFRESH_TOKEN = "1/Tl6awhpFjkMkSJoj1xsli0H2eL5YsMgU_NKPY2TyGWY";
  private static final String ACCESS_TOKEN = "aashpFjkMkSJoj1xsli0H2eL5YsMgU_NKPY2TyGWY";
  private static final URI CALL_URI = URI.create("http://googleapis.com/testapi/v1/foo");

  private ExecutorService realExecutor;

  @BeforeEach
  void setUp() {
    realExecutor = Executors.newCachedThreadPool();
  }

  @AfterEach
  void tearDown() {
    realExecutor.shutdown();
  }

  @Test
  void constructor_storesAccessToken() {
    OAuth2Credentials credentials =
        OAuth2Credentials.newBuilder().setAccessToken(new AccessToken(ACCESS_TOKEN, null)).build();
    assertEquals(ACCESS_TOKEN, credentials.getAccessToken().getTokenValue());
  }

  @Test
  void constructor_overrideMargin() throws Throwable {
    Duration staleMargin = Duration.ofMinutes(3);
    Duration expirationMargin = Duration.ofMinutes(2);

    Instant actualExpiration = Instant.now();
    Instant clientStale = actualExpiration.minus(staleMargin);
    Instant clientExpired = actualExpiration.minus(expirationMargin);

    AccessToken initialToken = new AccessToken(ACCESS_TOKEN, Date.from(actualExpiration));
    AtomicInteger refreshCount = new AtomicInteger();
    AtomicReference<AccessToken> currentToken = new AtomicReference<>(initialToken);

    OAuth2Credentials credentials =
        new OAuth2Credentials(
            currentToken.get(),
            /* refreshMargin= */ Duration.ofMinutes(3),
            /* expirationMargin= */ Duration.ofMinutes(2)) {
          @Override
          public AccessToken refreshAccessToken() throws IOException {
            refreshCount.incrementAndGet();
            // Inject delay to model network latency
            // This is needed to make to deflake the stale tests:
            // if the refresh is super quick, then a stale refresh will return the new token
            try {
              Thread.sleep(100);
            } catch (InterruptedException e) {
              throw new IOException(e);
            }

            return currentToken.get();
          }
        };

    TestClock clock = new TestClock();
    credentials.clock = clock;

    // Rewind time to when the token is fresh
    clock.setCurrentTime(clientStale.toEpochMilli() - 1);
    MockRequestMetadataCallback callback = new MockRequestMetadataCallback();
    credentials.getRequestMetadata(CALL_URI, realExecutor, callback);
    synchronized (credentials.lock) {
      assertNull(credentials.refreshTask);
    }
    assertEquals(0, refreshCount.get());
    Map<String, List<String>> lastMetadata = credentials.getRequestMetadata(CALL_URI);

    // Fast forward to when the token just turned STALE
    clock.setCurrentTime(clientStale.toEpochMilli());
    currentToken.set(new AccessToken(ACCESS_TOKEN + "-1", Date.from(actualExpiration)));
    callback.reset();
    credentials.getRequestMetadata(CALL_URI, realExecutor, callback);
    assertEquals(lastMetadata, callback.awaitResult());
    waitForRefreshTaskCompletion(credentials);
    assertEquals(1, refreshCount.get());
    lastMetadata = credentials.getRequestMetadata(CALL_URI);
    refreshCount.set(0);

    // Fast forward to when the token turned STALE just before expiration
    clock.setCurrentTime(clientExpired.toEpochMilli() - 1);
    currentToken.set(new AccessToken(ACCESS_TOKEN + "-2", Date.from(actualExpiration)));
    callback.reset();
    credentials.getRequestMetadata(CALL_URI, realExecutor, callback);
    assertEquals(lastMetadata, callback.awaitResult());
    waitForRefreshTaskCompletion(credentials);
    assertEquals(1, refreshCount.get());
    credentials.getRequestMetadata();
    refreshCount.set(0);

    // Fast forward to expired
    clock.setCurrentTime(clientExpired.toEpochMilli());
    AccessToken newToken = new AccessToken(ACCESS_TOKEN + "-3", Date.from(actualExpiration));
    currentToken.set(newToken);
    callback.reset();
    credentials.getRequestMetadata(CALL_URI, realExecutor, callback);
    TestUtils.assertContainsBearerToken(callback.awaitResult(), newToken.getTokenValue());
    assertEquals(1, refreshCount.get());
    waitForRefreshTaskCompletion(credentials);
    credentials.getRequestMetadata();
  }

  @Test
  void getAuthenticationType_returnsOAuth2() {
    OAuth2Credentials credentials =
        UserCredentials.newBuilder()
            .setClientId(CLIENT_ID)
            .setClientSecret(CLIENT_SECRET)
            .setRefreshToken(REFRESH_TOKEN)
            .build();
    assertEquals("OAuth2", credentials.getAuthenticationType());
  }

  @Test
  void hasRequestMetadata_returnsTrue() {
    OAuth2Credentials credentials =
        UserCredentials.newBuilder()
            .setClientId(CLIENT_ID)
            .setClientSecret(CLIENT_SECRET)
            .setRefreshToken(REFRESH_TOKEN)
            .build();
    assertTrue(credentials.hasRequestMetadata());
  }

  @Test
  void hasRequestMetadataOnly_returnsTrue() {
    OAuth2Credentials credentials =
        UserCredentials.newBuilder()
            .setClientId(CLIENT_ID)
            .setClientSecret(CLIENT_SECRET)
            .setRefreshToken(REFRESH_TOKEN)
            .build();
    assertTrue(credentials.hasRequestMetadataOnly());
  }

  @Test
  void addChangeListener_notifiesOnRefresh() throws IOException {
    final String accessToken1 = "1/MkSJoj1xsli0AccessToken_NKPY2";
    final String accessToken2 = "2/MkSJoj1xsli0AccessToken_NKPY2";
    MockTokenServerTransportFactory transportFactory = new MockTokenServerTransportFactory();
    transportFactory.transport.addClient(CLIENT_ID, CLIENT_SECRET);
    transportFactory.transport.addRefreshToken(REFRESH_TOKEN, accessToken1);
    OAuth2Credentials userCredentials =
        UserCredentials.newBuilder()
            .setClientId(CLIENT_ID)
            .setClientSecret(CLIENT_SECRET)
            .setRefreshToken(REFRESH_TOKEN)
            .setHttpTransportFactory(transportFactory)
            .build();
    // Use a fixed clock so tokens don't expire
    userCredentials.clock = new TestClock();
    TestChangeListener listener = new TestChangeListener();
    userCredentials.addChangeListener(listener);
    Map<String, List<String>> metadata;
    assertEquals(0, listener.callCount);

    // Get a first token
    metadata = userCredentials.getRequestMetadata(CALL_URI);
    TestUtils.assertContainsBearerToken(metadata, accessToken1);
    assertEquals(accessToken1, listener.accessToken.getTokenValue());
    assertEquals(1, listener.callCount);

    // Change server to a different token and refresh
    transportFactory.transport.addRefreshToken(REFRESH_TOKEN, accessToken2);
    // Refresh to force getting next token
    userCredentials.refresh();

    metadata = userCredentials.getRequestMetadata(CALL_URI);
    TestUtils.assertContainsBearerToken(metadata, accessToken2);
    assertEquals(accessToken2, listener.accessToken.getTokenValue());
    assertEquals(2, listener.callCount);
  }

  @Test
  void removeChangeListener_unregisters_observer() throws IOException {
    final String accessToken1 = "1/MkSJoj1xsli0AccessToken_NKPY2";
    final String accessToken2 = "2/MkSJoj1xsli0AccessToken_NKPY2";
    MockTokenServerTransportFactory transportFactory = new MockTokenServerTransportFactory();
    transportFactory.transport.addClient(CLIENT_ID, CLIENT_SECRET);
    transportFactory.transport.addRefreshToken(REFRESH_TOKEN, accessToken1);
    OAuth2Credentials userCredentials =
        UserCredentials.newBuilder()
            .setClientId(CLIENT_ID)
            .setClientSecret(CLIENT_SECRET)
            .setRefreshToken(REFRESH_TOKEN)
            .setHttpTransportFactory(transportFactory)
            .build();
    // Use a fixed clock so tokens don't expire
    userCredentials.clock = new TestClock();
    TestChangeListener listener = new TestChangeListener();
    userCredentials.addChangeListener(listener);
    assertEquals(0, listener.callCount);

    // Get a first token
    userCredentials.getRequestMetadata(CALL_URI);
    assertEquals(1, listener.callCount);

    // Change server to a different token and refresh
    transportFactory.transport.addRefreshToken(REFRESH_TOKEN, accessToken2);
    // Refresh to force getting next token
    userCredentials.refresh();
    assertEquals(2, listener.callCount);

    // Remove the listener and refresh the credential again
    userCredentials.removeChangeListener(listener);
    transportFactory.transport.addRefreshToken(REFRESH_TOKEN, accessToken2);
    userCredentials.refresh();
    assertEquals(2, listener.callCount);
  }

  @Test
  void getRequestMetadata_blocking_cachesExpiringToken() throws IOException {
    final String accessToken1 = "1/MkSJoj1xsli0AccessToken_NKPY2";
    final String accessToken2 = "2/MkSJoj1xsli0AccessToken_NKPY2";
    MockTokenServerTransportFactory transportFactory = new MockTokenServerTransportFactory();
    transportFactory.transport.addClient(CLIENT_ID, CLIENT_SECRET);
    transportFactory.transport.addRefreshToken(REFRESH_TOKEN, accessToken1);
    TestClock clock = new TestClock();
    OAuth2Credentials credentials =
        UserCredentials.newBuilder()
            .setClientId(CLIENT_ID)
            .setClientSecret(CLIENT_SECRET)
            .setRefreshToken(REFRESH_TOKEN)
            .setHttpTransportFactory(transportFactory)
            .build();
    credentials.clock = clock;

    // Verify getting the first token
    assertEquals(0, transportFactory.transport.buildRequestCount);
    Map<String, List<String>> metadata = credentials.getRequestMetadata(CALL_URI);
    TestUtils.assertContainsBearerToken(metadata, accessToken1);
    assertEquals(1, transportFactory.transport.buildRequestCount--);

    // Change server to a different token
    transportFactory.transport.addRefreshToken(REFRESH_TOKEN, accessToken2);

    // Make transport fail when used next time.
    IOException error = new IOException("error");
    transportFactory.transport.setError(error);

    // Advance 5 minutes and verify original token
    clock.addToCurrentTime(5 * 60 * 1000);
    metadata = credentials.getRequestMetadata(CALL_URI);
    TestUtils.assertContainsBearerToken(metadata, accessToken1);

    // Advance 60 minutes and verify revised token
    clock.addToCurrentTime(60 * 60 * 1000);
    assertEquals(0, transportFactory.transport.buildRequestCount);

    IOException e = assertThrows(IOException.class, () -> credentials.getRequestMetadata(CALL_URI));
    assertSame(error, e.getCause());
    assertEquals(1, transportFactory.transport.buildRequestCount--);

    // Reset the error and try again
    transportFactory.transport.setError(null);
    metadata = credentials.getRequestMetadata(CALL_URI);
    TestUtils.assertContainsBearerToken(metadata, accessToken2);
    assertEquals(1, transportFactory.transport.buildRequestCount--);
  }

  @Test
  void getRequestMetadata_async() {
    final String accessToken1 = "1/MkSJoj1xsli0AccessToken_NKPY2";
    final String accessToken2 = "2/MkSJoj1xsli0AccessToken_NKPY2";
    MockTokenServerTransportFactory transportFactory = new MockTokenServerTransportFactory();
    transportFactory.transport.addClient(CLIENT_ID, CLIENT_SECRET);
    transportFactory.transport.addRefreshToken(REFRESH_TOKEN, accessToken1);
    TestClock clock = new TestClock();
    OAuth2Credentials credentials =
        UserCredentials.newBuilder()
            .setClientId(CLIENT_ID)
            .setClientSecret(CLIENT_SECRET)
            .setRefreshToken(REFRESH_TOKEN)
            .setHttpTransportFactory(transportFactory)
            .build();
    credentials.clock = clock;

    MockExecutor executor = new MockExecutor();
    MockRequestMetadataCallback callback = new MockRequestMetadataCallback();
    // Verify getting the first token, which uses the transport and calls the callback in the
    // executor.
    credentials.getRequestMetadata(CALL_URI, executor, callback);
    assertEquals(0, transportFactory.transport.buildRequestCount);
    assertNull(callback.metadata);

    assertEquals(1, executor.runTasksExhaustively());
    assertNotNull(callback.metadata);
    TestUtils.assertContainsBearerToken(callback.metadata, accessToken1);
    assertEquals(1, transportFactory.transport.buildRequestCount--);

    // Change server to a different token
    transportFactory.transport.addRefreshToken(REFRESH_TOKEN, accessToken2);

    // Make transport fail when used next time.
    IOException error = new IOException("error");
    transportFactory.transport.setError(error);

    // Advance 5 minutes and verify original token. Callback is called inline.
    callback.reset();
    clock.addToCurrentTime(5 * 60 * 1000);
    assertNull(callback.metadata);
    credentials.getRequestMetadata(CALL_URI, executor, callback);
    assertNotNull(callback.metadata);
    assertEquals(0, executor.numTasks());
    TestUtils.assertContainsBearerToken(callback.metadata, accessToken1);

    // Advance 60 minutes and verify revised token, which uses the executor.
    callback.reset();
    clock.addToCurrentTime(60 * 60 * 1000);
    credentials.getRequestMetadata(CALL_URI, executor, callback);
    assertEquals(0, transportFactory.transport.buildRequestCount);
    assertNull(callback.exception);

    assertEquals(1, executor.runTasksExhaustively());
    assertSame(error, callback.exception.getCause());
    assertEquals(1, transportFactory.transport.buildRequestCount--);

    // Reset the error and try again
    transportFactory.transport.setError(null);
    callback.reset();
    credentials.getRequestMetadata(CALL_URI, executor, callback);
    assertEquals(0, transportFactory.transport.buildRequestCount);
    assertNull(callback.metadata);

    assertEquals(1, executor.runTasksExhaustively());
    assertNotNull(callback.metadata);
    TestUtils.assertContainsBearerToken(callback.metadata, accessToken2);
    assertEquals(1, transportFactory.transport.buildRequestCount--);
  }

  @Test
  void getRequestMetadata_async_refreshRace() throws ExecutionException, InterruptedException {
    final String accessToken1 = "1/MkSJoj1xsli0AccessToken_NKPY2";
    MockTokenServerTransportFactory transportFactory = new MockTokenServerTransportFactory();
    transportFactory.transport.addClient(CLIENT_ID, CLIENT_SECRET);
    transportFactory.transport.addRefreshToken(REFRESH_TOKEN, accessToken1);
    TestClock clock = new TestClock();
    final OAuth2Credentials credentials =
        UserCredentials.newBuilder()
            .setClientId(CLIENT_ID)
            .setClientSecret(CLIENT_SECRET)
            .setRefreshToken(REFRESH_TOKEN)
            .setHttpTransportFactory(transportFactory)
            .build();
    credentials.clock = clock;

    MockExecutor executor = new MockExecutor();
    MockRequestMetadataCallback callback = new MockRequestMetadataCallback();
    // Getting the first token, which uses the transport and calls the callback in the executor.
    credentials.getRequestMetadata(CALL_URI, executor, callback);
    assertEquals(0, transportFactory.transport.buildRequestCount);
    assertNull(callback.metadata);

    // Asynchronous task is scheduled, and a blocking call follows it
    assertEquals(1, executor.numTasks());

    ExecutorService testExecutor = Executors.newFixedThreadPool(1);

    FutureTask<Map<String, List<String>>> blockingTask =
        new FutureTask<>(
            new Callable<Map<String, List<String>>>() {
              @Override
              public Map<String, List<String>> call() throws Exception {
                return credentials.getRequestMetadata(CALL_URI);
              }
            });

    @SuppressWarnings("FutureReturnValueIgnored")
    Future<?> ignored = testExecutor.submit(blockingTask);
    testExecutor.shutdown();

    // give the blockingTask a chance to run
    for (int i = 0; i < 10; i++) {
      Thread.yield();
    }

    // blocking task is waiting on the async task to finish
    assertFalse(blockingTask.isDone());
    assertEquals(0, transportFactory.transport.buildRequestCount);

    // When the task is run, the result is shared
    assertEquals(1, executor.runTasksExhaustively());
    assertEquals(1, transportFactory.transport.buildRequestCount--);
    Map<String, List<String>> metadata = blockingTask.get();
    assertEquals(0, transportFactory.transport.buildRequestCount);
    assertEquals(metadata, callback.metadata);
  }

  @Test
  void getRequestMetadata_temporaryToken_hasToken() throws IOException {
    OAuth2Credentials credentials =
        OAuth2Credentials.newBuilder().setAccessToken(new AccessToken(ACCESS_TOKEN, null)).build();

    // Verify getting the first token
    Map<String, List<String>> metadata = credentials.getRequestMetadata(CALL_URI);
    TestUtils.assertContainsBearerToken(metadata, ACCESS_TOKEN);
  }

  @Test
  void getRequestMetadata_staleTemporaryToken() throws IOException, InterruptedException {
    Instant actualExpiration = Instant.now();
    Instant clientStale = actualExpiration.minus(OAuth2Credentials.DEFAULT_REFRESH_MARGIN);

    TestClock testClock = new TestClock();
    testClock.setCurrentTime(clientStale.toEpochMilli());

    // Initialize credentials which are initially stale and set to refresh
    final SettableFuture<AccessToken> refreshedTokenFuture = SettableFuture.create();
    OAuth2Credentials creds =
        new OAuth2Credentials(new AccessToken(ACCESS_TOKEN, Date.from(actualExpiration))) {
          @Override
          public AccessToken refreshAccessToken() {

            try {
              return refreshedTokenFuture.get();
            } catch (Exception e) {
              throw new RuntimeException(e);
            }
          }
        };
    creds.clock = testClock;
    synchronized (creds.lock) {
      assertNull(creds.refreshTask);
    }

    // Calls should return immediately with stale token
    MockRequestMetadataCallback callback = new MockRequestMetadataCallback();
    creds.getRequestMetadata(CALL_URI, realExecutor, callback);
    TestUtils.assertContainsBearerToken(callback.metadata, ACCESS_TOKEN);
    TestUtils.assertContainsBearerToken(creds.getRequestMetadata(CALL_URI), ACCESS_TOKEN);

    // But a refresh task should be scheduled
    synchronized (creds.lock) {
      assertNotNull(creds.refreshTask);
    }

    // Resolve the outstanding refresh
    AccessToken refreshedToken =
        new AccessToken(
            "2/MkSJoj1xsli0AccessToken_NKPY2",
            new Date(testClock.currentTimeMillis() + HOURS.toMillis(1)));
    refreshedTokenFuture.set(refreshedToken);

    // The access token should available once the refresh thread completes
    // However it will be populated asynchronously, so we need to wait until it propagates
    // Wait at most 1 minute are 100ms intervals. It should never come close to this.
    for (int i = 0; i < 600; i++) {
      Map<String, List<String>> requestMetadata = creds.getRequestMetadata(CALL_URI);
      String s = requestMetadata.get(AuthHttpConstants.AUTHORIZATION).get(0);
      if (s.contains(refreshedToken.getTokenValue())) {
        break;
      }
      Thread.sleep(100);
    }

    // Everything should return the new token
    callback = new MockRequestMetadataCallback();
    creds.getRequestMetadata(CALL_URI, realExecutor, callback);
    TestUtils.assertContainsBearerToken(callback.metadata, refreshedToken.getTokenValue());
    TestUtils.assertContainsBearerToken(
        creds.getRequestMetadata(CALL_URI), refreshedToken.getTokenValue());

    // And the task slot is reset
    synchronized (creds.lock) {
      assertNull(creds.refreshTask);
    }
  }

  @Test
  void getRequestMetadata_staleTemporaryToken_expirationWaits() throws Throwable {
    Instant actualExpiration = Instant.now();
    Instant clientStale = actualExpiration.minus(OAuth2Credentials.DEFAULT_REFRESH_MARGIN);
    Instant clientExpired = actualExpiration.minus(OAuth2Credentials.DEFAULT_EXPIRATION_MARGIN);

    TestClock testClock = new TestClock();

    // Initialize credentials which are initially stale and set to refresh
    final SettableFuture<AccessToken> refreshedTokenFuture = SettableFuture.create();
    OAuth2Credentials creds =
        new OAuth2Credentials(new AccessToken(ACCESS_TOKEN, Date.from(actualExpiration))) {
          @Override
          public AccessToken refreshAccessToken() {

            try {
              return refreshedTokenFuture.get();
            } catch (Exception e) {
              throw new RuntimeException(e);
            }
          }
        };
    creds.clock = testClock;
    synchronized (creds.lock) {
      assertNull(creds.refreshTask);
    }

    // Calls should return immediately with stale token, but a refresh is scheduled
    testClock.setCurrentTime(clientStale.toEpochMilli());
    MockRequestMetadataCallback callback = new MockRequestMetadataCallback();
    creds.getRequestMetadata(CALL_URI, realExecutor, callback);
    TestUtils.assertContainsBearerToken(callback.metadata, ACCESS_TOKEN);
    assertNotNull(creds.refreshTask);
    RefreshTask refreshTask = creds.refreshTask;

    // Fast forward to expiration, which will hang cause the callback to hang
    testClock.setCurrentTime(clientExpired.toEpochMilli());
    // Make sure that the callback is hung (while giving it a chance to run)
    for (int i = 0; i < 10; i++) {
      Thread.sleep(10);
      callback = new MockRequestMetadataCallback();
      creds.getRequestMetadata(CALL_URI, realExecutor, callback);
      assertNull(callback.metadata);
    }
    // The original refresh task should still be active
    synchronized (creds.lock) {
      assertSame(refreshTask, creds.refreshTask);
    }

    // Resolve the outstanding refresh
    AccessToken refreshedToken =
        new AccessToken(
            "2/MkSJoj1xsli0AccessToken_NKPY2",
            new Date(testClock.currentTimeMillis() + HOURS.toMillis(1)));
    refreshedTokenFuture.set(refreshedToken);

    // The access token should available once the refresh thread completes
    TestUtils.assertContainsBearerToken(
        creds.getRequestMetadata(CALL_URI), refreshedToken.getTokenValue());
    callback = new MockRequestMetadataCallback();
    creds.getRequestMetadata(CALL_URI, realExecutor, callback);
    TestUtils.assertContainsBearerToken(callback.awaitResult(), refreshedToken.getTokenValue());

    // The refresh slot should be cleared
    synchronized (creds.lock) {
      assertNull(creds.refreshTask);
    }
  }

  @Test
  void getRequestMetadata_singleFlightErrorSharing() {
    Instant actualExpiration = Instant.now();
    Instant clientStale = actualExpiration.minus(OAuth2Credentials.DEFAULT_REFRESH_MARGIN);
    Instant clientExpired = actualExpiration.minus(OAuth2Credentials.DEFAULT_EXPIRATION_MARGIN);

    TestClock testClock = new TestClock();
    testClock.setCurrentTime(clientStale.toEpochMilli());

    // Initialize credentials which are initially expired
    final SettableFuture<RuntimeException> refreshErrorFuture = SettableFuture.create();
    final OAuth2Credentials creds =
        new OAuth2Credentials(new AccessToken(ACCESS_TOKEN, Date.from(clientExpired))) {
          @Override
          public AccessToken refreshAccessToken() {
            RuntimeException injectedError;

            try {
              injectedError = refreshErrorFuture.get();
            } catch (Exception e) {
              throw new IllegalStateException("Unexpected error fetching injected error");
            }
            throw injectedError;
          }
        };
    creds.clock = testClock;

    // Calls will hang waiting for the refresh
    final MockRequestMetadataCallback callback1 = new MockRequestMetadataCallback();
    creds.getRequestMetadata(CALL_URI, realExecutor, callback1);

    final Future<Map<String, List<String>>> blockingCall =
        realExecutor.submit(
            new Callable<Map<String, List<String>>>() {
              @Override
              public Map<String, List<String>> call() throws Exception {
                return creds.getRequestMetadata(CALL_URI);
              }
            });

    RuntimeException error = new RuntimeException("fake error");
    refreshErrorFuture.set(error);

    // Get the error that getRequestMetadata(uri) created
    Throwable actualBlockingError =
        assertThrows(ExecutionException.class, blockingCall::get).getCause();

    assertEquals(error, actualBlockingError);

    RuntimeException actualAsyncError =
        assertThrows(RuntimeException.class, callback1::awaitResult);
    assertEquals(error, actualAsyncError);
  }

  @Test
  void getRequestMetadata_syncErrorsIncludeCallingStackframe() {
    final OAuth2Credentials creds =
        new OAuth2Credentials() {
          @Override
          public AccessToken refreshAccessToken() {
            throw new RuntimeException("fake error");
          }
        };

    List<StackTraceElement> expectedStacktrace =
        new ArrayList<>(Arrays.asList(new Exception().getStackTrace()));
    expectedStacktrace = expectedStacktrace.subList(1, expectedStacktrace.size());

    AtomicReference<Exception> actualError = new AtomicReference<>();
    Exception refreshError =
        assertThrows(RuntimeException.class, () -> creds.getRequestMetadata(CALL_URI));
    actualError.set(refreshError);

    List<StackTraceElement> actualStacktrace = Arrays.asList(actualError.get().getStackTrace());
    actualStacktrace =
        actualStacktrace.subList(
            actualStacktrace.size() - expectedStacktrace.size(), actualStacktrace.size());

    // ensure the remaining frames are identical
    assertEquals(expectedStacktrace, actualStacktrace);
  }

  @Test
  void refresh_refreshesToken() throws IOException {
    final String accessToken1 = "1/MkSJoj1xsli0AccessToken_NKPY2";
    final String accessToken2 = "2/MkSJoj1xsli0AccessToken_NKPY2";
    MockTokenServerTransportFactory transportFactory = new MockTokenServerTransportFactory();
    transportFactory.transport.addClient(CLIENT_ID, CLIENT_SECRET);
    transportFactory.transport.addRefreshToken(REFRESH_TOKEN, accessToken1);
    OAuth2Credentials userCredentials =
        UserCredentials.newBuilder()
            .setClientId(CLIENT_ID)
            .setClientSecret(CLIENT_SECRET)
            .setRefreshToken(REFRESH_TOKEN)
            .setHttpTransportFactory(transportFactory)
            .build();
    // Use a fixed clock so tokens don't expire
    userCredentials.clock = new TestClock();

    // Get a first token
    Map<String, List<String>> metadata = userCredentials.getRequestMetadata(CALL_URI);
    TestUtils.assertContainsBearerToken(metadata, accessToken1);
    assertEquals(1, transportFactory.transport.buildRequestCount--);

    // Change server to a different token
    transportFactory.transport.addRefreshToken(REFRESH_TOKEN, accessToken2);

    // Confirm token being cached
    TestUtils.assertContainsBearerToken(metadata, accessToken1);
    assertEquals(0, transportFactory.transport.buildRequestCount);

    // Refresh to force getting next token
    userCredentials.refresh();
    metadata = userCredentials.getRequestMetadata(CALL_URI);
    TestUtils.assertContainsBearerToken(metadata, accessToken2);
    assertEquals(1, transportFactory.transport.buildRequestCount--);
  }

  @Test
  void refreshIfExpired_refreshesToken() throws IOException {
    final String accessToken1 = "1/MkSJoj1xsli0AccessToken_NKPY2";
    final String accessToken2 = "2/MkSJoj1xsli0AccessToken_NKPY2";
    MockTokenServerTransportFactory transportFactory = new MockTokenServerTransportFactory();
    transportFactory.transport.addClient(CLIENT_ID, CLIENT_SECRET);
    transportFactory.transport.addRefreshToken(REFRESH_TOKEN, accessToken1);
    OAuth2Credentials userCredentials =
        UserCredentials.newBuilder()
            .setClientId(CLIENT_ID)
            .setClientSecret(CLIENT_SECRET)
            .setRefreshToken(REFRESH_TOKEN)
            .setHttpTransportFactory(transportFactory)
            .build();
    // Use a fixed clock so tokens don't expire
    TestClock mockClock = new TestClock();
    userCredentials.clock = mockClock;

    // Get a first token
    Map<String, List<String>> metadata = userCredentials.getRequestMetadata(CALL_URI);
    TestUtils.assertContainsBearerToken(metadata, accessToken1);
    assertEquals(1, transportFactory.transport.buildRequestCount--);

    // Change server to a different token
    transportFactory.transport.addRefreshToken(REFRESH_TOKEN, accessToken2);

    // Confirm token being cached
    TestUtils.assertContainsBearerToken(metadata, accessToken1);
    assertEquals(0, transportFactory.transport.buildRequestCount);

    // Should not refresh yet
    userCredentials.refreshIfExpired();
    metadata = userCredentials.getRequestMetadata(CALL_URI);
    TestUtils.assertNotContainsBearerToken(metadata, accessToken2);

    // Jump ahead to expire the token
    mockClock.addToCurrentTime(3600000);
    userCredentials.refreshIfExpired();
    metadata = userCredentials.getRequestMetadata(CALL_URI);
    TestUtils.assertContainsBearerToken(metadata, accessToken2);

    assertEquals(1, transportFactory.transport.buildRequestCount--);
  }

  @Test
  void refresh_temporaryToken_throws() {
    OAuth2Credentials credentials =
        OAuth2Credentials.newBuilder().setAccessToken(new AccessToken(ACCESS_TOKEN, null)).build();
    assertThrows(IllegalStateException.class, credentials::refresh);
  }

  @Test
  void equals_true() {
    final String accessToken1 = "1/MkSJoj1xsli0AccessToken_NKPY2";
    OAuth2Credentials credentials =
        OAuth2Credentials.newBuilder().setAccessToken(new AccessToken(accessToken1, null)).build();
    OAuth2Credentials otherCredentials =
        OAuth2Credentials.newBuilder().setAccessToken(new AccessToken(accessToken1, null)).build();
    assertEquals(credentials, otherCredentials);
    assertEquals(otherCredentials, credentials);
  }

  @Test
  void equals_false_accessToken() {
    final String accessToken1 = "1/MkSJoj1xsli0AccessToken_NKPY2";
    final String accessToken2 = "2/MkSJoj1xsli0AccessToken_NKPY2";
    OAuth2Credentials credentials =
        OAuth2Credentials.newBuilder().setAccessToken(new AccessToken(accessToken1, null)).build();
    OAuth2Credentials otherCredentials =
        OAuth2Credentials.newBuilder().setAccessToken(new AccessToken(accessToken2, null)).build();
    assertNotEquals(credentials, otherCredentials);
    assertNotEquals(otherCredentials, credentials);
  }

  @Test
  void toString_containsFields() {
    AccessToken accessToken = new AccessToken("1/MkSJoj1xsli0AccessToken_NKPY2", null);
    OAuth2Credentials credentials =
        OAuth2Credentials.newBuilder().setAccessToken(accessToken).build();
    String expectedToString =
        String.format(
            "OAuth2Credentials{requestMetadata=%s, temporaryAccess=%s}",
            ImmutableMap.of(
                AuthHttpConstants.AUTHORIZATION,
                ImmutableList.of(OAuth2Utils.BEARER_PREFIX + accessToken.getTokenValue())),
            accessToken);
    assertEquals(expectedToString, credentials.toString());
  }

  @Test
  void hashCode_equals() {
    final String accessToken = "1/MkSJoj1xsli0AccessToken_NKPY2";
    OAuth2Credentials credentials =
        OAuth2Credentials.newBuilder().setAccessToken(new AccessToken(accessToken, null)).build();
    OAuth2Credentials otherCredentials =
        OAuth2Credentials.create(new AccessToken(accessToken, null));
    assertEquals(credentials.hashCode(), otherCredentials.hashCode());
  }

  @Test
  void serialize() throws IOException, ClassNotFoundException {
    final String accessToken = "1/MkSJoj1xsli0AccessToken_NKPY2";
    OAuth2Credentials credentials =
        OAuth2Credentials.newBuilder().setAccessToken(new AccessToken(accessToken, null)).build();
    OAuth2Credentials deserializedCredentials = serializeAndDeserialize(credentials);
    assertEquals(credentials, deserializedCredentials);
    assertEquals(credentials.hashCode(), deserializedCredentials.hashCode());
    assertEquals(credentials.toString(), deserializedCredentials.toString());
    assertSame(Clock.SYSTEM, deserializedCredentials.clock);
  }

  @Test
  @Disabled
  void updateTokenValueBeforeWake() throws IOException, InterruptedException {
    final SettableFuture<AccessToken> refreshedTokenFuture = SettableFuture.create();
    AccessToken refreshedToken = new AccessToken("2/MkSJoj1xsli0AccessToken_NKPY2", null);
    refreshedTokenFuture.set(refreshedToken);

    OAuth2Credentials creds = getOAuth2Credentials(refreshedToken, refreshedTokenFuture);

    Thread t =
        new Thread(
            () ->
                assertDoesNotThrow(
                    () -> {
                      creds.refresh();
                      assertNotNull(creds.getAccessToken());
                    }));
    t.start();

    synchronized (creds) {
      // Grab a lock on creds object. This thread (the main thread) will wait here until the child
      // thread (t) calls `notify` on the creds object.
      creds.wait();
    }

    AccessToken token = creds.getAccessToken();
    assertNull(token);

    creds.refresh();
    token = creds.getAccessToken();
    // Token should never be NULL after a refresh that succeeded.
    // Previously the token could be NULL due to an internal race condition between the future
    // completing and the task listener updating the value of the access token.
    assertNotNull(token);
    t.join();
  }

  private OAuth2Credentials getOAuth2Credentials(
      AccessToken refreshedToken, SettableFuture<AccessToken> refreshedTokenFuture) {
    final ListenableFutureTask<OAuthValue> task =
        ListenableFutureTask.create(() -> OAuthValue.create(refreshedToken, new HashMap<>()));

    return new OAuth2Credentials() {
      @Override
      public AccessToken refreshAccessToken() {
        synchronized (this) {
          // Wake up the main thread. This is done now because the child thread (t) is known to
          // have the refresh task. Now we want the main thread to wake up and create a future
          // in order to wait for the refresh to complete.
          this.notify();
        }
        RefreshTaskListener listener =
            new RefreshTaskListener(task) {
              @Override
              public void run() {
                assertDoesNotThrow(
                    () -> {
                      // Sleep before setting accessToken to new accessToken. Refresh should not
                      // complete before this, and the accessToken is `null` until it is.
                      Thread.sleep(300);
                      super.run();
                    });
              }
            };

        this.refreshTask = new RefreshTask(task, listener);

        try {
          // Sleep for 100 milliseconds to give parent thread time to create a refresh future.
          Thread.sleep(100);
          return refreshedTokenFuture.get();
        } catch (Exception e) {
          throw new RuntimeException(e);
        }
      }
    };
  }

  private void waitForRefreshTaskCompletion(OAuth2Credentials credentials)
      throws TimeoutException, InterruptedException {
    for (int i = 0; i < 100; i++) {
      synchronized (credentials.lock) {
        if (credentials.refreshTask == null) {
          return;
        }
      }
      Thread.sleep(100);
    }
    throw new TimeoutException("timed out waiting for refresh task to finish");
  }

  private static class TestChangeListener implements OAuth2Credentials.CredentialsChangedListener {

    public AccessToken accessToken = null;
    public int callCount = 0;

    @Override
    public void onChanged(OAuth2Credentials credentials) throws IOException {
      accessToken = credentials.getAccessToken();
      callCount++;
    }
  }
}
