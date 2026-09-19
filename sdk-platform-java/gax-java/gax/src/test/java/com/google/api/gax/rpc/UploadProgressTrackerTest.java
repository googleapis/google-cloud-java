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
package com.google.api.gax.rpc;

import static com.google.common.truth.Truth.assertThat;
import static org.junit.jupiter.api.Assertions.assertThrows;

import com.google.common.util.concurrent.MoreExecutors;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicInteger;
import org.junit.jupiter.api.Test;

class UploadProgressTrackerTest {

  @Test
  void testInitialSnapshotOnSubscribe() {
    UploadProgressTracker tracker = new UploadProgressTracker();
    List<ResumableUploadStatus> statuses = new ArrayList<>();
    tracker.addListener(statuses::add, MoreExecutors.directExecutor());

    assertThat(statuses).hasSize(1);
    ResumableUploadStatus initial = statuses.get(0);
    assertThat(initial.getState()).isEqualTo(ResumableUploadStatus.State.STARTING);
    assertThat(initial.getBytesUploaded()).isEqualTo(0L);
    assertThat(initial.getUploadUrl()).isNull();
  }

  @Test
  void testMonotonicProgressEnforcement() {
    UploadProgressTracker tracker = new UploadProgressTracker();
    tracker.onStarted("https://upload.url/test");

    List<Long> byteUpdates = new ArrayList<>();
    tracker.addListener(
        status -> byteUpdates.add(status.getBytesUploaded()), MoreExecutors.directExecutor());

    // Advance to 100 bytes
    tracker.onChunkUploaded(100L);
    assertThat(byteUpdates).containsExactly(0L, 100L).inOrder();

    // Out-of-order / smaller offset should not reduce reported bytes
    tracker.onChunkUploaded(50L);
    assertThat(byteUpdates).containsExactly(0L, 100L, 100L).inOrder();

    // Larger offset advances
    tracker.onChunkUploaded(200L);
    assertThat(byteUpdates).containsExactly(0L, 100L, 100L, 200L).inOrder();
  }

  @Test
  void testListenerExceptionSafety_doesNotDisruptSubsequentUpdates() {
    UploadProgressTracker tracker = new UploadProgressTracker();
    tracker.onStarted("https://upload.url/test");

    AtomicInteger errorCount = new AtomicInteger(0);
    List<ResumableUploadStatus.State> safeReceived = new ArrayList<>();

    // Listener 1 throws on every call
    tracker.addListener(
        status -> {
          errorCount.incrementAndGet();
          throw new RuntimeException("boom from listener 1");
        },
        MoreExecutors.directExecutor());

    // Listener 2 functions normally
    tracker.addListener(
        status -> safeReceived.add(status.getState()), MoreExecutors.directExecutor());

    tracker.onChunkUploaded(50L);
    tracker.onFinalized(50L);

    assertThat(errorCount.get()).isEqualTo(3);
    assertThat(safeReceived)
        .containsExactly(
            ResumableUploadStatus.State.STARTED,
            ResumableUploadStatus.State.UPLOADING,
            ResumableUploadStatus.State.FINALIZED)
        .inOrder();
  }

  @Test
  void testTerminalState_noNotificationsAfterFinalized() {
    UploadProgressTracker tracker = new UploadProgressTracker();
    tracker.onStarted("https://upload.url/test");

    List<ResumableUploadStatus.State> received = new ArrayList<>();
    tracker.addListener(status -> received.add(status.getState()), MoreExecutors.directExecutor());

    tracker.onChunkUploaded(100L);
    tracker.onFinalized(100L);

    // Updates after finalized must be discarded
    tracker.onChunkUploaded(150L);
    tracker.onRecovering(new RuntimeException("should not appear"));

    assertThat(received)
        .containsExactly(
            ResumableUploadStatus.State.STARTED,
            ResumableUploadStatus.State.UPLOADING,
            ResumableUploadStatus.State.FINALIZED)
        .inOrder();
  }

  @Test
  void testTerminalState_noNotificationsAfterFailed() {
    UploadProgressTracker tracker = new UploadProgressTracker();
    tracker.onStarted("https://upload.url/test");

    List<ResumableUploadStatus.State> received = new ArrayList<>();
    tracker.addListener(status -> received.add(status.getState()), MoreExecutors.directExecutor());

    tracker.onChunkUploaded(50L);
    tracker.onFailed(new RuntimeException("failed"), "https://upload.url/test");

    // Updates after failed must be discarded
    tracker.onChunkUploaded(100L);
    tracker.onFinalized(100L);

    assertThat(received)
        .containsExactly(
            ResumableUploadStatus.State.STARTED,
            ResumableUploadStatus.State.UPLOADING,
            ResumableUploadStatus.State.FAILED)
        .inOrder();
  }

  @Test
  void testCustomExecutorDispatch() throws Exception {
    UploadProgressTracker tracker = new UploadProgressTracker();
    ExecutorService executor = Executors.newSingleThreadExecutor();
    try {
      CountDownLatch latch = new CountDownLatch(2);
      List<ResumableUploadStatus.State> states = new ArrayList<>();

      tracker.addListener(
          status -> {
            synchronized (states) {
              states.add(status.getState());
            }
            latch.countDown();
          },
          executor);

      tracker.onStarted("https://upload.url/custom-executor");
      assertThat(latch.await(5, TimeUnit.SECONDS)).isTrue();

      synchronized (states) {
        assertThat(states)
            .containsExactly(
                ResumableUploadStatus.State.STARTING, ResumableUploadStatus.State.STARTED)
            .inOrder();
      }
    } finally {
      executor.shutdownNow();
    }
  }

  @Test
  void testNoLockHeldDuringCallbackDispatch() throws Exception {
    UploadProgressTracker tracker = new UploadProgressTracker();
    tracker.onStarted("https://upload.url/no-lock");

    CountDownLatch listenerEntered = new CountDownLatch(1);
    CountDownLatch probeCompleted = new CountDownLatch(1);
    AtomicBoolean acquiredLockWhileInListener = new AtomicBoolean(false);

    tracker.addListener(
        status -> {
          if (status.getState() == ResumableUploadStatus.State.UPLOADING) {
            listenerEntered.countDown();
            try {
              if (probeCompleted.await(5, TimeUnit.SECONDS)) {
                acquiredLockWhileInListener.set(true);
              }
            } catch (InterruptedException e) {
              Thread.currentThread().interrupt();
            }
          }
        },
        MoreExecutors.directExecutor());

    ExecutorService probeExecutor = Executors.newSingleThreadExecutor();
    try {
      probeExecutor.submit(
          () -> {
            try {
              if (listenerEntered.await(5, TimeUnit.SECONDS)) {
                tracker.onChunkUploaded(200L);
                probeCompleted.countDown();
              }
            } catch (InterruptedException e) {
              Thread.currentThread().interrupt();
            }
          });

      tracker.onChunkUploaded(100L);

      assertThat(probeCompleted.await(5, TimeUnit.SECONDS)).isTrue();
      assertThat(acquiredLockWhileInListener.get()).isTrue();
    } finally {
      probeExecutor.shutdownNow();
    }
  }

  @Test
  void testNullListenerThrowsNpe() {
    UploadProgressTracker tracker = new UploadProgressTracker();
    assertThrows(
        NullPointerException.class,
        () -> tracker.addListener(null, MoreExecutors.directExecutor()));
  }
}
