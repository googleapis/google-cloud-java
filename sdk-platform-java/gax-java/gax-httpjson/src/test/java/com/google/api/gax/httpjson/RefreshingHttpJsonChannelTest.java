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
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.never;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.util.concurrent.atomic.AtomicInteger;
import java.util.function.Supplier;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.ArgumentCaptor;

class RefreshingHttpJsonChannelTest {
  private AtomicInteger channelFactoryCount;
  private ManagedHttpJsonChannel lastCreatedChannel;
  private String testCertPath = "/fake/path";
  private String testFingerprint = "fingerprint1";

  private Supplier<ManagedHttpJsonChannel> channelFactory =
      () -> {
        channelFactoryCount.incrementAndGet();
        lastCreatedChannel = mock(ManagedHttpJsonChannel.class);
        return lastCreatedChannel;
      };

  @BeforeEach
  void setUp() {
    channelFactoryCount = new AtomicInteger(0);
    testCertPath = "/fake/path";
    testFingerprint = "fingerprint1";
  }

  private RefreshingHttpJsonChannel createTestChannel() {
    return new RefreshingHttpJsonChannel(channelFactory) {
      @Override
      protected String getWorkloadCertPath() {
        return testCertPath;
      }

      @Override
      protected String getCertificateFingerprint(String certPath) {
        return testFingerprint;
      }
    };
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
    
    Thread.sleep(1001); // Invalidate 1-second cache
    assertFalse(channel.shouldRefresh());
  }

  @Test
  void testShouldRefreshTrueWhenChanged() throws InterruptedException {
    RefreshingHttpJsonChannel channel = createTestChannel();

    Thread.sleep(1001); // Invalidate 1-second cache

    // Simulate disk fingerprint changing
    testFingerprint = "fingerprint2";

    assertTrue(channel.shouldRefresh());
  }

  @Test
  void testRefreshSwapsChannel() throws InterruptedException {
    RefreshingHttpJsonChannel channel = createTestChannel();
    ManagedHttpJsonChannel firstChannel = lastCreatedChannel;
    assertEquals(1, channelFactoryCount.get());

    Thread.sleep(1001); // Invalidate 1-second cache

    // Change fingerprint
    testFingerprint = "fingerprint2";
    
    // Act
    channel.refresh();

    // Verify a new channel was created and the old one retired
    assertEquals(2, channelFactoryCount.get());
    ManagedHttpJsonChannel secondChannel = lastCreatedChannel;
    
    // The old channel should receive a shutdown request immediately since there are no active calls
    verify(firstChannel).shutdown();
    verify(secondChannel, never()).shutdown();
  }

  @Test
  void testRefreshKeepsInFlightChannelsAlive() throws InterruptedException {
    RefreshingHttpJsonChannel channel = createTestChannel();
    ManagedHttpJsonChannel firstChannel = lastCreatedChannel;

    // Simulate an in-flight API call
    @SuppressWarnings("unchecked")
    HttpJsonClientCall<Object, Object> mockCall = mock(HttpJsonClientCall.class);
    when(firstChannel.newCall(any(), any())).thenReturn(mockCall);

    HttpJsonClientCall<Object, Object> activeCall = channel.newCall(null, null);

    Thread.sleep(1001); // Invalidate 1-second cache

    // Change fingerprint & refresh
    testFingerprint = "fingerprint2";
    
    channel.refresh();

    // Verify a new channel was created
    assertEquals(2, channelFactoryCount.get());

    // IMPORTANT: The first channel should NOT be shut down yet because of the active call!
    verify(firstChannel, never()).shutdown();

    // Now complete the call successfully
    @SuppressWarnings("unchecked")
    ArgumentCaptor<HttpJsonClientCall.Listener<Object>> listenerCaptor =
        ArgumentCaptor.forClass(HttpJsonClientCall.Listener.class);
    
    @SuppressWarnings("unchecked")
    HttpJsonClientCall.Listener<Object> mockListener = mock(HttpJsonClientCall.Listener.class);
    
    activeCall.start(mockListener, null);
    
    verify(mockCall).start(listenerCaptor.capture(), any());
    
    // Fire onClose
    listenerCaptor.getValue().onClose(0, null);

    // FIRST CHANNEL SHOULD BE SHUT DOWN NOW!
    verify(firstChannel).shutdown();
  }

  @Test
  void testRefreshDoesNotSpawnChannelWhenShutdown() throws InterruptedException {
    RefreshingHttpJsonChannel channel = createTestChannel();
    ManagedHttpJsonChannel firstChannel = lastCreatedChannel;
    assertEquals(1, channelFactoryCount.get());

    // By default, Mockito returns false for boolean.
    // Let's simulate that the channel pool is shut down.
    when(firstChannel.isShutdown()).thenReturn(true);

    Thread.sleep(1001); // Invalidate 1-second cache

    // Change fingerprint
    testFingerprint = "fingerprint2";
    
    // Act
    channel.refresh();

    // Verify no new channel was spawned
    assertEquals(1, channelFactoryCount.get());
  }
}
