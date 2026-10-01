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
import static org.junit.jupiter.api.Assertions.assertNotSame;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertTrue;

import com.google.api.client.http.HttpTransport;
import com.google.api.client.testing.http.MockHttpTransport;
import com.google.api.gax.httpjson.testing.MockHttpService;
import com.google.protobuf.Field;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Queue;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.function.Function;
import java.util.function.Supplier;
import javax.annotation.Nullable;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class RefreshingHttpJsonChannelTest {
  private static final ApiMethodDescriptor<Field, Field> FAKE_METHOD_DESCRIPTOR =
      ApiMethodDescriptor.<Field, Field>newBuilder()
          .setFullMethodName("google.cloud.v1.Fake/FakeMethod")
          .setHttpMethod("POST")
          .setRequestFormatter(
              ProtoMessageRequestFormatter.<Field>newBuilder()
                  .setPath(
                      "/fake/v1/name/{name}",
                      request -> {
                        Map<String, String> fields = new HashMap<>();
                        ProtoRestSerializer<Field> serializer = ProtoRestSerializer.create();
                        serializer.putPathParam(fields, "name", request.getName());
                        return fields;
                      })
                  .setQueryParamsExtractor(request -> new HashMap<>())
                  .setRequestBodyExtractor(
                      request ->
                          ProtoRestSerializer.create()
                              .toBody("*", request.toBuilder().clearName().build(), false))
                  .build())
          .setResponseParser(
              ProtoMessageResponseParser.<Field>newBuilder()
                  .setDefaultInstance(Field.getDefaultInstance())
                  .build())
          .build();

  private static class FakeHttpJsonClientCall<RequestT, ResponseT>
      extends HttpJsonClientCall<RequestT, ResponseT> {
    @Override
    public void start(Listener<ResponseT> responseListener, HttpJsonMetadata requestHeaders) {}

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

  private AtomicInteger transportFactoryCount;
  private HttpTransport lastCreatedTransport;
  private FakeManagedHttpJsonChannel lastCreatedChannel;
  private String testCertPath;
  private String testFingerprint;
  private boolean shouldThrowOnFactory;
  private List<RefreshingHttpJsonChannel> createdChannels;

  private Supplier<HttpTransport> transportFactory =
      () -> {
        if (shouldThrowOnFactory) {
          throw new RuntimeException("Simulated factory failure");
        }
        transportFactoryCount.incrementAndGet();
        lastCreatedTransport = new MockHttpTransport();
        return lastCreatedTransport;
      };

  private Function<HttpTransport, ManagedHttpJsonChannel> channelFactory =
      transport -> {
        lastCreatedChannel = new FakeManagedHttpJsonChannel();
        lastCreatedChannel.setHttpTransport(transport);
        return lastCreatedChannel;
      };

  @BeforeEach
  void setUp() {
    transportFactoryCount = new AtomicInteger(0);
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
        new RefreshingHttpJsonChannel(
            () -> transportFactory.get(),
            transport -> channelFactory.apply(transport),
            "fake/cert/path.json") {
          @Override
          String getWorkloadCertPath() {
            return testCertPath;
          }

          @Override
          String getCertificateFingerprint(String certPath) {
            return testFingerprint;
          }
        };
    createdChannels.add(ch);
    return ch;
  }

  private void rotateCertificate(RefreshingHttpJsonChannel channel) {
    channel.invalidateDiskFingerprintCache();
    testFingerprint = "fingerprint2";
  }

  @Test
  void testShouldRefreshNullCertPath() {
    testCertPath = null;
    RefreshingHttpJsonChannel channel = createTestChannel();
    assertFalse(channel.shouldRefresh());
  }

  @Test
  void testShouldRefreshFalseWhenUnchanged() {
    RefreshingHttpJsonChannel channel = createTestChannel();

    channel.invalidateDiskFingerprintCache(); // Invalidate 1-second cache
    assertFalse(channel.shouldRefresh());
  }

  @Test
  void testShouldRefreshTrueWhenChanged() {
    RefreshingHttpJsonChannel channel = createTestChannel();

    rotateCertificate(channel);

    assertTrue(channel.shouldRefresh());
  }

  @Test
  void shouldRefresh_doesNotCacheNegativeResultAndDetectsSubsequentRotationImmediately() {
    RefreshingHttpJsonChannel channel = createTestChannel();

    // First check returns false (unchanged fingerprint)
    assertFalse(channel.shouldRefresh());

    // Immediately change fingerprint WITHOUT invalidating cache
    testFingerprint = "fingerprint2";

    // Must immediately detect rotation because negative/unchanged checks are not cached for 1s
    assertTrue(channel.shouldRefresh());

    // Refresh updates activeCertFingerprint and clears cache
    channel.refresh();
    assertFalse(channel.shouldRefresh());
  }

  @Test
  void rotationDuringInitialTransportCreation_isDetectedAndRefreshed() {
    transportFactory =
        () -> {
          if (transportFactoryCount.incrementAndGet() == 1) {
            // Simulate the certificate rotating on disk while the initial transport loads it.
            testFingerprint = "fingerprint2";
          }
          lastCreatedTransport = new MockHttpTransport();
          return lastCreatedTransport;
        };

    RefreshingHttpJsonChannel channel = createTestChannel();

    // The baseline was recorded before the initial transport was created, so the rotation is seen.
    assertTrue(channel.shouldRefresh());

    channel.refresh();
    assertEquals(2, transportFactoryCount.get());
    assertEquals(1, channel.getGeneration());
    assertFalse(channel.shouldRefresh());
  }

  @Test
  void refresh_swapsTransportAndKeepsChannel() {
    RefreshingHttpJsonChannel channel = createTestChannel();
    FakeManagedHttpJsonChannel underlyingChannel = lastCreatedChannel;
    HttpTransport initialTransport = channel.getHttpTransport();
    assertSame(lastCreatedTransport, initialTransport);

    rotateCertificate(channel);
    channel.refresh();

    assertEquals(2, transportFactoryCount.get());
    assertNotSame(initialTransport, channel.getHttpTransport());
    assertSame(lastCreatedTransport, channel.getHttpTransport());
    // The underlying channel (and its executors) is reused rather than replaced or shut down.
    assertSame(underlyingChannel, lastCreatedChannel);
    assertFalse(underlyingChannel.isShutdown());
    assertEquals(1, channel.getGeneration());
    assertFalse(channel.shouldRefresh());
  }

  @Test
  void callCreatedBeforeRefresh_usesOriginalTransport() throws Exception {
    MockHttpService originalService =
        new MockHttpService(Collections.singletonList(FAKE_METHOD_DESCRIPTOR), "google.com:443");
    MockHttpService rotatedService =
        new MockHttpService(Collections.singletonList(FAKE_METHOD_DESCRIPTOR), "google.com:443");
    Field message = Field.newBuilder().setName("bob").setNumber(1).build();
    originalService.addResponse(message);
    rotatedService.addResponse(message);
    Queue<HttpTransport> transports =
        new ArrayDeque<>(Arrays.asList(originalService, rotatedService));
    transportFactory = transports::remove;
    channelFactory =
        transport ->
            ManagedHttpJsonChannel.newBuilder()
                .setEndpoint("google.com:443")
                .setHttpTransport(transport)
                .build();
    RefreshingHttpJsonChannel channel = createTestChannel();
    HttpJsonCallOptions callOptions = HttpJsonCallOptions.newBuilder().build();
    HttpJsonCallContext callContext = HttpJsonCallContext.createDefault();

    HttpJsonClientCall<Field, Field> callBeforeRefresh =
        channel.newCall(FAKE_METHOD_DESCRIPTOR, callOptions);

    rotateCertificate(channel);
    channel.refresh();
    assertEquals(1, channel.getGeneration());

    assertEquals(
        message,
        HttpJsonClientCalls.futureUnaryCall(callBeforeRefresh, message, callContext)
            .get(10, TimeUnit.SECONDS));
    assertEquals(1, originalService.getRequestPaths().size());
    assertEquals(0, rotatedService.getRequestPaths().size());

    HttpJsonClientCall<Field, Field> callAfterRefresh =
        channel.newCall(FAKE_METHOD_DESCRIPTOR, callOptions);
    assertEquals(
        message,
        HttpJsonClientCalls.futureUnaryCall(callAfterRefresh, message, callContext)
            .get(10, TimeUnit.SECONDS));
    assertEquals(1, originalService.getRequestPaths().size());
    assertEquals(1, rotatedService.getRequestPaths().size());
  }

  @Test
  void testRefreshDoesNotCreateTransportWhenShutdown() {
    RefreshingHttpJsonChannel channel = createTestChannel();
    assertEquals(1, transportFactoryCount.get());

    channel.shutdown();
    rotateCertificate(channel);
    channel.refresh();

    assertEquals(1, transportFactoryCount.get());
    assertEquals(0, channel.getGeneration());
  }

  @Test
  void shutdown_waitsForInProgressRefresh() throws Exception {
    CountDownLatch refreshStarted = new CountDownLatch(1);
    CountDownLatch releaseRefresh = new CountDownLatch(1);
    transportFactory =
        () -> {
          if (transportFactoryCount.incrementAndGet() > 1) {
            refreshStarted.countDown();
            try {
              releaseRefresh.await();
            } catch (InterruptedException e) {
              Thread.currentThread().interrupt();
            }
          }
          return new MockHttpTransport();
        };
    RefreshingHttpJsonChannel channel = createTestChannel();
    FakeManagedHttpJsonChannel underlyingChannel = lastCreatedChannel;
    rotateCertificate(channel);

    Thread refreshThread = new Thread(channel::refresh);
    Thread shutdownThread = new Thread(channel::shutdown);
    try {
      refreshThread.start();
      assertTrue(refreshStarted.await(5, TimeUnit.SECONDS));
      shutdownThread.start();

      shutdownThread.join(200);
      assertTrue(shutdownThread.isAlive());
      assertFalse(underlyingChannel.isShutdown());
    } finally {
      releaseRefresh.countDown();
    }
    refreshThread.join(5000);
    shutdownThread.join(5000);
    assertFalse(refreshThread.isAlive());
    assertFalse(shutdownThread.isAlive());
    assertEquals(1, channel.getGeneration());
    assertTrue(underlyingChannel.isShutdown());
  }

  @Test
  void testRefreshFactoryExceptionDoesNotWedgeFingerprint() {
    RefreshingHttpJsonChannel channel = createTestChannel();
    HttpTransport initialTransport = channel.getHttpTransport();
    assertEquals(1, transportFactoryCount.get());

    shouldThrowOnFactory = true;
    rotateCertificate(channel);

    // Factory failure is logged and the existing transport is kept
    channel.refresh();
    assertEquals(1, transportFactoryCount.get());
    assertEquals(0, channel.getGeneration());
    assertSame(initialTransport, channel.getHttpTransport());

    // Because the factory threw, the new fingerprint is not recorded as active, so the channel
    // still reports that it should be refreshed.
    assertTrue(channel.shouldRefresh());

    shouldThrowOnFactory = false;
    channel.refresh();
    assertEquals(2, transportFactoryCount.get());
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
    lastCreatedChannel.isTerminated = true;

    channel.shutdown();
    assertTrue(channel.awaitTermination(0, TimeUnit.MILLISECONDS));
  }

  @Test
  void testChannelDelegationMethods() {
    RefreshingHttpJsonChannel channel = createTestChannel();
    FakeManagedHttpJsonChannel underlyingChannel = lastCreatedChannel;
    FakeHttpJsonClientCall<Object, Object> fakeCall = new FakeHttpJsonClientCall<>();
    underlyingChannel.nextCall = fakeCall;

    assertEquals(underlyingChannel.getEndpoint(), channel.getEndpoint());
    assertEquals(underlyingChannel.getHttpTransport(), channel.getHttpTransport());
    assertEquals(underlyingChannel.getExecutor(), channel.getExecutor());
    assertSame(fakeCall, channel.newCall(null, null));
  }

  @Test
  void close_shutsDownUnderlyingChannel() {
    RefreshingHttpJsonChannel channel = createTestChannel();

    channel.close();

    assertTrue(lastCreatedChannel.isShutdown());
    assertTrue(channel.isShutdown());
  }

  @Test
  void testConcurrentNewCallDuringRefresh() throws InterruptedException {
    RefreshingHttpJsonChannel channel = createTestChannel();
    int threadCount = 10;
    java.util.concurrent.ExecutorService executorService =
        java.util.concurrent.Executors.newFixedThreadPool(threadCount);
    java.util.concurrent.CountDownLatch latch =
        new java.util.concurrent.CountDownLatch(threadCount);
    AtomicInteger successCount = new AtomicInteger(0);

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

    rotateCertificate(channel);
    channel.refresh();

    latch.await(5, TimeUnit.SECONDS);
    executorService.shutdown();

    assertEquals(threadCount, successCount.get());
  }

  @Test
  void testGenerationIncrementAndLifecycleOnDelegatingWrapper() throws Exception {
    RefreshingHttpJsonChannel channel = createTestChannel();
    assertEquals(0, channel.getGeneration());

    rotateCertificate(channel);
    channel.refresh();

    assertEquals(1, channel.getGeneration());

    // Verify lifecycle methods on delegating wrapper do not throw NullPointerException
    assertFalse(channel.isShutdown());
    assertFalse(channel.isTerminated());
    channel.shutdown();
    assertTrue(channel.isShutdown());
    channel.shutdownNow();
    assertTrue(channel.isTerminated());
    assertTrue(channel.awaitTermination(1, TimeUnit.SECONDS));
  }
}
