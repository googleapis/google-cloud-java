/*
 * Copyright 2026, Google LLC
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

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import com.google.api.client.testing.http.MockHttpTransport;
import com.google.api.client.testing.http.MockLowLevelHttpResponse;
import com.google.api.client.util.Clock;
import com.google.auth.http.HttpTransportFactory;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.Collections;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.atomic.AtomicLong;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class RegionalAccessBoundaryTest {

  private static final long TTL = RegionalAccessBoundary.TTL_MILLIS;
  private static final long REFRESH_THRESHOLD = RegionalAccessBoundary.REFRESH_THRESHOLD_MILLIS;

  private TestClock testClock;

  @BeforeEach
  public void setUp() {
    testClock = new TestClock();
  }

  @AfterEach
  public void tearDown() {}

  @Test
  public void testIsExpired() {
    long now = testClock.currentTimeMillis();
    RegionalAccessBoundary rab =
        new RegionalAccessBoundary("encoded", Collections.singletonList("loc"), now, testClock);

    assertFalse(rab.isExpired());

    testClock.set(now + TTL - 1);
    assertFalse(rab.isExpired());

    testClock.set(now + TTL + 1);
    assertTrue(rab.isExpired());
  }

  @Test
  public void testShouldRefresh() {
    long now = testClock.currentTimeMillis();
    RegionalAccessBoundary rab =
        new RegionalAccessBoundary("encoded", Collections.singletonList("loc"), now, testClock);

    // Initial state: fresh
    assertFalse(rab.shouldRefresh());

    // Just before threshold
    testClock.set(now + TTL - REFRESH_THRESHOLD - 1);
    assertFalse(rab.shouldRefresh());

    // At threshold
    testClock.set(now + TTL - REFRESH_THRESHOLD + 1);
    assertTrue(rab.shouldRefresh());

    // Still not expired
    assertFalse(rab.isExpired());
  }

  @Test
  public void testSerialization() throws Exception {
    long now = testClock.currentTimeMillis();
    RegionalAccessBoundary rab =
        new RegionalAccessBoundary("encoded", Collections.singletonList("loc"), now, testClock);

    ByteArrayOutputStream baos = new ByteArrayOutputStream();
    ObjectOutputStream oos = new ObjectOutputStream(baos);
    oos.writeObject(rab);
    oos.close();

    ByteArrayInputStream bais = new ByteArrayInputStream(baos.toByteArray());
    ObjectInputStream ois = new ObjectInputStream(bais);
    RegionalAccessBoundary deserializedRab = (RegionalAccessBoundary) ois.readObject();
    ois.close();

    assertEquals("encoded", deserializedRab.getEncodedLocations());
    assertEquals(1, deserializedRab.getLocations().size());
    assertEquals("loc", deserializedRab.getLocations().get(0));
    // The transient clock field should be restored to Clock.SYSTEM upon deserialization,
    // thereby avoiding a NullPointerException when checking expiration.
    assertFalse(deserializedRab.isExpired());
  }

  @Test
  public void testRefreshClosesResponse() throws Exception {
    final String url = "https://example.com/rab";
    final AccessToken token =
        new AccessToken("token", new java.util.Date(System.currentTimeMillis() + 3600000L));

    TrackingMockLowLevelHttpResponse mockResponse = new TrackingMockLowLevelHttpResponse();
    mockResponse.setContentType("application/json");
    mockResponse.setContent("{\"encodedLocations\": \"encoded\", \"locations\": [\"loc\"]}");

    MockHttpTransport transport =
        new MockHttpTransport.Builder().setLowLevelHttpResponse(mockResponse).build();
    HttpTransportFactory transportFactory = () -> transport;

    RegionalAccessBoundary rab =
        RegionalAccessBoundary.refresh(transportFactory, url, token, testClock, 1000);

    assertEquals("encoded", rab.getEncodedLocations());
    assertTrue(mockResponse.isDisconnected(), "Response should have been disconnected");
  }

  @Test
  public void testManagerTriggersRefreshInGracePeriod() throws InterruptedException {
    final String url =
        "https://iamcredentials.googleapis.com/v1/projects/-/serviceAccounts/default:allowedLocations";
    final AccessToken token =
        new AccessToken(
            "token", new java.util.Date(System.currentTimeMillis() + 10 * 3600000L)); //

    // Mock transport to return a new RAB
    final String newEncoded = "new-encoded";
    MockHttpTransport transport =
        new MockHttpTransport.Builder()
            .setLowLevelHttpResponse(
                new MockLowLevelHttpResponse()
                    .setContentType("application/json")
                    .setContent(
                        "{\"encodedLocations\": \""
                            + newEncoded
                            + "\", \"locations\": [\"new-loc\"]}"))
            .build();
    HttpTransportFactory transportFactory = () -> transport;
    RegionalAccessBoundaryProvider provider = () -> url;

    RegionalAccessBoundaryManager manager = new RegionalAccessBoundaryManager(testClock);

    // 1. Let's first get a RAB into the cache
    manager.triggerAsyncRefresh(transportFactory, provider, token);

    // Wait for it to be cached
    int retries = 0;
    while (manager.getCachedRAB() == null && retries < 50) {
      Thread.sleep(50);
      retries++;
    }
    assertEquals(newEncoded, manager.getCachedRAB().getEncodedLocations());

    // 2. Advance clock to grace period
    testClock.set(testClock.currentTimeMillis() + TTL - REFRESH_THRESHOLD + 1000);

    assertTrue(manager.getCachedRAB().shouldRefresh());
    assertFalse(manager.getCachedRAB().isExpired());

    // 3. Prepare mock for SECOND refresh
    final String newerEncoded = "newer-encoded";
    MockHttpTransport transport2 =
        new MockHttpTransport.Builder()
            .setLowLevelHttpResponse(
                new MockLowLevelHttpResponse()
                    .setContentType("application/json")
                    .setContent(
                        "{\"encodedLocations\": \""
                            + newerEncoded
                            + "\", \"locations\": [\"newer-loc\"]}"))
            .build();
    HttpTransportFactory transportFactory2 = () -> transport2;

    // 4. Trigger refresh - should start because we are in grace period
    manager.triggerAsyncRefresh(transportFactory2, provider, token);

    // 5. Wait for background refresh to complete
    // We expect the cached RAB to eventually change to newerEncoded
    retries = 0;
    RegionalAccessBoundary resultRab = null;
    while (retries < 100) {
      resultRab = manager.getCachedRAB();
      if (resultRab != null && newerEncoded.equals(resultRab.getEncodedLocations())) {
        break;
      }
      Thread.sleep(50);
      retries++;
    }

    assertTrue(
        resultRab != null && newerEncoded.equals(resultRab.getEncodedLocations()),
        "Refresh should have completed and updated the cache within 5 seconds");
    assertEquals(newerEncoded, resultRab.getEncodedLocations());
  }

  @Test
  public void testExecutorQueueCapacityLimit() throws Exception {
    final String url = "https://example.com/rab";
    final AccessToken token =
        new AccessToken("token", new java.util.Date(System.currentTimeMillis() + 3600000L));
    RegionalAccessBoundaryProvider provider = () -> url;

    int poolSize = 5;
    int queueCapacity = 100;
    int totalCapacity = poolSize + queueCapacity;

    java.util.concurrent.ThreadPoolExecutor testExecutor =
        new java.util.concurrent.ThreadPoolExecutor(
            poolSize,
            poolSize,
            1,
            java.util.concurrent.TimeUnit.HOURS,
            new java.util.concurrent.LinkedBlockingQueue<>(queueCapacity),
            r -> {
              Thread t = new Thread(r, "test-RAB-refresh");
              t.setDaemon(true);
              return t;
            });

    CountDownLatch latch = new CountDownLatch(1);

    java.io.InputStream blockingStream =
        new java.io.InputStream() {
          private final java.io.InputStream delegate =
              new ByteArrayInputStream(
                  "{\"encodedLocations\": \"encoded\", \"locations\": [\"loc\"]}".getBytes());
          private boolean blocked = false;

          @Override
          public int read() throws java.io.IOException {
            if (!blocked) {
              try {
                latch.await();
              } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
              }
              blocked = true;
            }
            return delegate.read();
          }
        };

    MockHttpTransport transport =
        new MockHttpTransport.Builder()
            .setLowLevelHttpResponse(
                new MockLowLevelHttpResponse()
                    .setContent(blockingStream)
                    .setContentType("application/json"))
            .build();
    HttpTransportFactory transportFactory = () -> transport;

    RegionalAccessBoundaryManager[] managers = new RegionalAccessBoundaryManager[totalCapacity];
    for (int i = 0; i < totalCapacity; i++) {
      managers[i] =
          new RegionalAccessBoundaryManager(
              testClock,
              RegionalAccessBoundaryManager.DEFAULT_MAX_RETRY_ELAPSED_TIME_MILLIS,
              testExecutor);
      managers[i].triggerAsyncRefresh(transportFactory, provider, token);
    }

    RegionalAccessBoundaryManager extraManager =
        new RegionalAccessBoundaryManager(
            testClock,
            RegionalAccessBoundaryManager.DEFAULT_MAX_RETRY_ELAPSED_TIME_MILLIS,
            testExecutor);
    assertFalse(extraManager.isCooldownActive());

    extraManager.triggerAsyncRefresh(transportFactory, provider, token);

    assertFalse(
        extraManager.isCooldownActive(),
        "106th task should NOT have entered cooldown on scheduling failure");

    latch.countDown();
    testExecutor.shutdownNow();
  }

  private static class TestClock implements Clock {
    private final AtomicLong currentTime = new AtomicLong(System.currentTimeMillis());

    @Override
    public long currentTimeMillis() {
      return currentTime.get();
    }

    public void set(long millis) {
      currentTime.set(millis);
    }
  }

  private static class TrackingMockLowLevelHttpResponse extends MockLowLevelHttpResponse {
    private boolean disconnected = false;

    @Override
    public void disconnect() throws IOException {
      super.disconnect();
      disconnected = true;
    }

    public boolean isDisconnected() {
      return disconnected;
    }
  }
}
