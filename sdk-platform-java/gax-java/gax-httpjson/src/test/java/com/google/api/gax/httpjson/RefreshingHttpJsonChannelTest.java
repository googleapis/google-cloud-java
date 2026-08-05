/*
 * Copyright 2026 Google LLC
 *
 * Redistribution and use in source and binary forms, with or without
 * modification, are permitted provided that the following conditions are
 * met:
 *
 *     * Redistributions of source code must retain the above copyright
 * notice, this list of conditions and the following disclaimer.
 *     * Redistributions in binary form must reproduce the above
 * copyright notice, this list of conditions and the following disclaimer
 * in the documentation and/or other materials provided with the
 * distribution.
 *     * Neither the name of Google LLC nor the names of its
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
package com.google.api.gax.httpjson;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.function.Supplier;
import javax.annotation.Nullable;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class RefreshingHttpJsonChannelTest {
  private static class FakeHttpJsonClientCall<RequestT, ResponseT>
      extends HttpJsonClientCall<RequestT, ResponseT> {
    private Listener<ResponseT> listener;

    @Override
    public void start(Listener<ResponseT> responseListener, HttpJsonMetadata requestHeaders) {
      this.listener = responseListener;
    }

    @Override
    public void request(int numMessages) {}

    @Override
    public void cancel(@Nullable String message, @Nullable Throwable cause) {}

    @Override
    public void sendMessage(RequestT message) {}

    @Override
    public void halfClose() {}
  }

  private static class FakeManagedHttpJsonChannel extends ManagedHttpJsonChannel {
    private volatile boolean isShutdown = false;
    private volatile boolean isTerminated = false;
    private HttpJsonClientCall<?, ?> nextCall = null;

    @Override
    String getEndpoint() {
      return "https://fake.endpoint:443";
    }

    @Override
    public void shutdown() {
      isShutdown = true;
    }

    @Override
    public void shutdownNow() {
      isShutdown = true;
      isTerminated = true;
    }

    @Override
    public boolean isShutdown() {
      return isShutdown;
    }

    @Override
    public boolean isTerminated() {
      return isTerminated;
    }

    @Override
    public boolean awaitTermination(long duration, TimeUnit unit) {
      return isTerminated;
    }

    @Override
    @SuppressWarnings("unchecked")
    public <RequestT, ResponseT> HttpJsonClientCall<RequestT, ResponseT> newCall(
        ApiMethodDescriptor<RequestT, ResponseT> methodDescriptor,
        HttpJsonCallOptions callOptions) {
      if (nextCall != null) {
        return (HttpJsonClientCall<RequestT, ResponseT>) nextCall;
      }
      return new FakeHttpJsonClientCall<>();
    }
  }

  private AtomicInteger channelFactoryCount;
  private FakeManagedHttpJsonChannel lastCreatedChannel;
  private String testCertPath = "/fake/path";
  private String testFingerprint = "fingerprint1";
  private boolean shouldThrowOnFactory = false;
  private List<RefreshingHttpJsonChannel> createdChannels;

  private Supplier<ManagedHttpJsonChannel> channelFactory =
      () -> {
        if (shouldThrowOnFactory) {
          throw new RuntimeException("Simulated factory failure");
        }
        channelFactoryCount.incrementAndGet();
        lastCreatedChannel = new FakeManagedHttpJsonChannel();
        return lastCreatedChannel;
      };

  @BeforeEach
  void setUp() {
    channelFactoryCount = new AtomicInteger(0);
    testCertPath = "/fake/path";
    testFingerprint = "fingerprint1";
    shouldThrowOnFactory = false;
    createdChannels = new ArrayList<>();
  }

  @AfterEach
  void tearDown() {
    for (RefreshingHttpJsonChannel channel : createdChannels) {
      channel.shutdownNow();
    }
  }

  private RefreshingHttpJsonChannel createTestChannel() {
    RefreshingHttpJsonChannel ch =
        new RefreshingHttpJsonChannel(channelFactory, "fake/cert/path.json") {
          @Override
          protected String getWorkloadCertPath() {
            return testCertPath;
          }

          @Override
          protected String getCertificateFingerprint(String certPath) {
            return testFingerprint;
          }
        };
    createdChannels.add(ch);
    return ch;
  }

  @Test
  void testShouldRefreshNullCertPath() {
    testCertPath = null;
    RefreshingHttpJsonChannel channel = createTestChannel();
    assertFalse(channel.shouldRefresh());
  }

  @Test
  void testShouldRefreshFalseWhenUnchanged() throws InterruptedException {
    RefreshingHttpJsonChannel channel = createTestChannel();

    channel.invalidateDiskFingerprintCache(); // Invalidate 1-second cache
    assertFalse(channel.shouldRefresh());
  }

  @Test
  void testShouldRefreshTrueWhenChanged() throws InterruptedException {
    RefreshingHttpJsonChannel channel = createTestChannel();

    channel.invalidateDiskFingerprintCache(); // Invalidate 1-second cache

    // Simulate disk fingerprint changing
    testFingerprint = "fingerprint2";

    assertTrue(channel.shouldRefresh());
  }

  @Test
  void testRefreshSwapsChannel() throws InterruptedException {
    RefreshingHttpJsonChannel channel = createTestChannel();
    FakeManagedHttpJsonChannel firstChannel = lastCreatedChannel;
    assertEquals(1, channelFactoryCount.get());

    channel.invalidateDiskFingerprintCache(); // Invalidate 1-second cache

    // Change fingerprint
    testFingerprint = "fingerprint2";

    // Act
    channel.refresh();

    // Verify a new channel was created and the old one retired
    assertEquals(2, channelFactoryCount.get());
    FakeManagedHttpJsonChannel secondChannel = lastCreatedChannel;

    // The old channel should receive a shutdown request immediately since there are no active calls
    assertTrue(firstChannel.isShutdown());
    assertFalse(secondChannel.isShutdown());
  }

  @Test
  void testRefreshKeepsInFlightChannelsAlive() throws InterruptedException {
    RefreshingHttpJsonChannel channel = createTestChannel();
    FakeManagedHttpJsonChannel firstChannel = lastCreatedChannel;

    // Simulate an in-flight API call
    FakeHttpJsonClientCall<Object, Object> fakeCall = new FakeHttpJsonClientCall<>();
    firstChannel.nextCall = fakeCall;

    HttpJsonClientCall<Object, Object> activeCall = channel.newCall(null, null);

    channel.invalidateDiskFingerprintCache(); // Invalidate 1-second cache

    // Change fingerprint & refresh
    testFingerprint = "fingerprint2";

    channel.refresh();

    // Verify a new channel was created
    assertEquals(2, channelFactoryCount.get());

    // IMPORTANT: The first channel should NOT be shut down yet because of the active call!
    assertFalse(firstChannel.isShutdown());

    // Now start the call
    activeCall.start(new HttpJsonClientCall.Listener<Object>() {}, null);

    assertNotNull(fakeCall.listener);

    // Fire onClose
    fakeCall.listener.onClose(0, null);

    // FIRST CHANNEL SHOULD BE SHUT DOWN NOW!
    assertTrue(firstChannel.isShutdown());
  }

  @Test
  void testCancelBeforeStartReleasesChannelEntry() {
    RefreshingHttpJsonChannel channel = createTestChannel();
    FakeManagedHttpJsonChannel firstChannel = lastCreatedChannel;

    HttpJsonClientCall<Object, Object> activeCall = channel.newCall(null, null);

    channel.invalidateDiskFingerprintCache();
    testFingerprint = "fingerprint2";
    channel.refresh();

    // Because activeCall was created, the old channel should NOT be shut down yet
    assertFalse(firstChannel.isShutdown());

    // Cancel before start() is called
    activeCall.cancel("Cancelled early", null);

    // Because cancel() safely released the entry, the old channel should now be shut down!
    assertTrue(firstChannel.isShutdown());
  }

  @Test
  void testRefreshDoesNotSpawnChannelWhenShutdown() throws InterruptedException {
    RefreshingHttpJsonChannel channel = createTestChannel();
    FakeManagedHttpJsonChannel firstChannel = lastCreatedChannel;
    assertEquals(1, channelFactoryCount.get());

    // Simulate that the channel pool is shut down.
    channel.shutdown();
    firstChannel.shutdown();

    channel.invalidateDiskFingerprintCache(); // Invalidate 1-second cache

    // Change fingerprint
    testFingerprint = "fingerprint2";

    // Act
    channel.refresh();

    // Verify no new channel was spawned
    assertEquals(1, channelFactoryCount.get());
  }

  @Test
  void testRefreshFactoryExceptionDoesNotWedgeFingerprint() throws InterruptedException {
    RefreshingHttpJsonChannel channel = createTestChannel();
    assertEquals(1, channelFactoryCount.get());

    shouldThrowOnFactory = true;
    channel.invalidateDiskFingerprintCache(); // Invalidate 1-second cache
    testFingerprint = "fingerprint2";

    assertThrows(RuntimeException.class, channel::refresh);

    // Because factory threw, activeCertFingerprint should NOT be updated to fingerprint2
    // Therefore shouldRefresh() should still return true
    assertTrue(channel.shouldRefresh());

    shouldThrowOnFactory = false;
    channel.refresh();
    assertEquals(2, channelFactoryCount.get());
    assertFalse(channel.shouldRefresh());
  }

  @Test
  void testShutdownNowSetsIsShutdown() {
    RefreshingHttpJsonChannel channel = createTestChannel();
    assertFalse(channel.isShutdown());

    channel.shutdownNow();

    assertTrue(channel.isShutdown());
  }

  @Test
  void testAwaitTerminationZeroTimeoutOnTerminatedChannelReturnsTrue() throws InterruptedException {
    RefreshingHttpJsonChannel channel = createTestChannel();
    FakeManagedHttpJsonChannel firstChannel = lastCreatedChannel;
    firstChannel.isTerminated = true;

    channel.shutdown();
    assertTrue(channel.awaitTermination(0, TimeUnit.MILLISECONDS));
  }

  @Test
  void testChannelDelegationMethods() {
    RefreshingHttpJsonChannel channel = createTestChannel();
    FakeManagedHttpJsonChannel firstChannel = lastCreatedChannel;

    assertEquals(firstChannel.getEndpoint(), channel.getEndpoint());
    assertEquals(firstChannel.getHttpTransport(), channel.getHttpTransport());
    assertEquals(firstChannel.getExecutor(), channel.getExecutor());
  }

  @Test
  void testNewCallAfterShutdownNowThrowsIllegalStateException() {
    RefreshingHttpJsonChannel channel = createTestChannel();
    channel.shutdownNow();

    assertThrows(
        IllegalStateException.class,
        () -> channel.newCall(null, null),
        "Channel has been shut down");
  }

  @Test
  void testConcurrentNewCallDuringRefresh() throws InterruptedException {
    RefreshingHttpJsonChannel channel = createTestChannel();
    int threadCount = 10;
    java.util.concurrent.ExecutorService executorService =
        java.util.concurrent.Executors.newFixedThreadPool(threadCount);
    java.util.concurrent.CountDownLatch latch =
        new java.util.concurrent.CountDownLatch(threadCount);
    java.util.concurrent.atomic.AtomicInteger successCount =
        new java.util.concurrent.atomic.AtomicInteger(0);

    for (int i = 0; i < threadCount; i++) {
      executorService.submit(
          () -> {
            try {
              channel.newCall(null, null);
              successCount.incrementAndGet();
            } finally {
              latch.countDown();
            }
          });
    }

    channel.invalidateDiskFingerprintCache();
    testFingerprint = "fingerprint2";
    channel.refresh();

    latch.await(5, TimeUnit.SECONDS);
    executorService.shutdown();

    assertEquals(threadCount, successCount.get());
  }
}
