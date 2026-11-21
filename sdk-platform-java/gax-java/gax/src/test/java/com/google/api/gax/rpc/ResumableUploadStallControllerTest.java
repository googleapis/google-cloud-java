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

import com.google.api.gax.core.FakeApiClock;
import com.google.api.gax.retrying.RetrySettings;
import com.google.api.gax.rpc.StatusCode.Code;
import java.net.SocketTimeoutException;
import java.time.Duration;
import java.util.concurrent.TimeUnit;
import org.jspecify.annotations.Nullable;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class ResumableUploadStallControllerTest {

  private static final long MIB = 1024L * 1024L;
  private static final long CHUNK_160_MIB = 160L * MIB;
  private static final RetrySettings BASE_RETRY_SETTINGS =
      RetrySettings.newBuilder()
          .setMaxAttempts(5)
          .setTotalTimeoutDuration(Duration.ofMinutes(2))
          .build();

  private FakeApiClock clock;

  @BeforeEach
  void setUp() {
    clock = new FakeApiClock(0L);
  }

  @Test
  void testChunkProgress_tracksLagAndResetsStallWindowWhenCaughtUp() {
    // 160 MiB chunks at 10 MiB/s -> expected = 16s, 2x expected = 32s, stallTimeout = 60s.
    ResumableUploadStallController controller = newController(10.0, 60, null);
    RetrySettings chunk1 = controller.onStartChunk(CHUNK_160_MIB);
    assertThat(chunk1.getMaxAttempts()).isEqualTo(0);
    assertThat(chunk1.getTotalTimeoutDuration()).isEqualTo(Duration.ofSeconds(76));
    assertThat(chunk1.getInitialRpcTimeoutDuration()).isEqualTo(Duration.ofSeconds(32));
    assertThat(chunk1.getMaxRpcTimeoutDuration()).isEqualTo(Duration.ofSeconds(32));
    assertThat(chunk1.getRpcTimeoutMultiplier()).isEqualTo(1.0);

    // 1. Ahead of schedule (8s vs 16s expected) -> lag clamped to 0s, next deadline stays 76s.
    advanceSeconds(8);
    controller.onChunkSuccess(CHUNK_160_MIB);
    assertThat(controller.onStartChunk(CHUNK_160_MIB).getTotalTimeoutDuration())
        .isEqualTo(Duration.ofSeconds(76));

    // 2. Behind schedule (26s vs 16s expected) -> lag = 10s, next chunk deadline reduced to 66s.
    advanceSeconds(26);
    controller.onChunkSuccess(CHUNK_160_MIB);
    assertThat(controller.onStartChunk(CHUNK_160_MIB).getTotalTimeoutDuration())
        .isEqualTo(Duration.ofSeconds(66));

    // 3. Catching back up (6s vs 16s expected) -> lag drops to 0s, restoring 76s and resetting the
    // stall clock.
    advanceSeconds(6);
    controller.onChunkSuccess(CHUNK_160_MIB);
    assertThat(controller.onStartChunk(CHUNK_160_MIB).getTotalTimeoutDuration())
        .isEqualTo(Duration.ofSeconds(76));

    // 4. Subsequent slow chunk (55s) starts a fresh 60s stall window instead of compounding with
    // step 2; onChunkSuccess not throwing confirms the stall window was reset in step 3.
    advanceSeconds(55);
    controller.onChunkSuccess(CHUNK_160_MIB);
  }

  @Test
  void testOnChunkSuccess_throwsWhenLagPersistsBeyondStallTimeout() {
    ResumableUploadStallController controller = newController(10.0, 60, null);

    // Chunk 1 falls 4s behind schedule (20s vs 16s expected), starting the stall clock at t=20s.
    controller.onStartChunk(CHUNK_160_MIB);
    advanceSeconds(20);
    controller.onChunkSuccess(CHUNK_160_MIB);

    // Next 3 chunks run at exact minimum rate (16s each -> lag stays 4s for 48s).
    for (int i = 0; i < 3; i++) {
      controller.onStartChunk(CHUNK_160_MIB);
      advanceSeconds(16);
      controller.onChunkSuccess(CHUNK_160_MIB);
    }

    // 5th chunk at 16s -> lag has persisted for 64s (> 60s stallTimeout).
    controller.onStartChunk(CHUNK_160_MIB);
    advanceSeconds(16);
    DeadlineExceededException thrown =
        assertThrows(
            DeadlineExceededException.class, () -> controller.onChunkSuccess(CHUNK_160_MIB));
    assertThat(thrown.getStatusCode().getCode()).isEqualTo(Code.DEADLINE_EXCEEDED);
    assertThat(thrown.getMessage()).isEqualTo("Resumable upload stalled");
  }

  @Test
  void testTimeoutFloorsAndSubMiBFractionalRate() {
    ResumableUploadStallController controller = newController(0.5, 10, null);

    // 1 MiB at 0.5 MiB/s -> expected = 2s, 2x expected = 4s -> floored to 5s attempt timeout.
    RetrySettings oneMiB = controller.onStartChunk(MIB);
    assertThat(oneMiB.getTotalTimeoutDuration()).isEqualTo(Duration.ofSeconds(12));
    assertThat(oneMiB.getInitialRpcTimeoutDuration()).isEqualTo(Duration.ofSeconds(5));
    advanceMillis(11_500); // lag = 9.5s (0.5s grace left)
    controller.onChunkSuccess(MIB);

    // 0-byte final chunk with 0.5s raw local timeout -> floored to 1s local (capping attempt to
    // 1s).
    RetrySettings emptyFinal = controller.onStartChunk(0L);
    assertThat(emptyFinal.getTotalTimeoutDuration()).isEqualTo(Duration.ofSeconds(1));
    assertThat(emptyFinal.getInitialRpcTimeoutDuration()).isEqualTo(Duration.ofSeconds(1));
  }

  @Test
  void testOnStartQuery_resumeUsesStallTimeoutAndRecoverySharesChunkDeadline() {
    // Initial resume() query (no active chunk): local = 90s, attempt capped at 60s.
    RetrySettings initialQuery = newController(10.0, 90, null).onStartQuery(Duration.ZERO);
    assertThat(initialQuery.getTotalTimeoutDuration()).isEqualTo(Duration.ofSeconds(90));
    assertThat(initialQuery.getInitialRpcTimeoutDuration()).isEqualTo(Duration.ofMinutes(1));

    // Mid-upload recovery query shares currentChunkDeadline (76s from t=0) minus backoff.
    ResumableUploadStallController controller = newController(10.0, 60, null);
    controller.onStartChunk(CHUNK_160_MIB);
    advanceSeconds(20); // 56s remaining
    assertThat(controller.onStartQuery(Duration.ofSeconds(2)).getTotalTimeoutDuration())
        .isEqualTo(Duration.ofSeconds(54));

    // Throws immediately if remaining chunk deadline <= recoveryBackoffDelay.
    advanceSeconds(55); // 1s remaining
    assertThrows(
        DeadlineExceededException.class, () -> controller.onStartQuery(Duration.ofSeconds(1)));
  }

  @Test
  void testOnRecoveryOffsetReceived_handlesResumeZeroProgressAndPartialCommit() {
    ResumableUploadStallController controller = newController(10.0, 60, null);

    // 1. Initial resume() (no active chunk) ignores pre-existing offset (even > 2 GiB).
    advanceSeconds(100);
    controller.onStartQuery(Duration.ZERO);
    controller.onRecoveryOffsetReceived(3L * 1024L * MIB);
    assertThat(controller.onStartChunk(CHUNK_160_MIB).getTotalTimeoutDuration())
        .isEqualTo(Duration.ofSeconds(76));

    // 2. Zero-progress recovery reuses remaining currentChunkDeadline (76s - 21s = 55s).
    advanceSeconds(20);
    controller.onStartQuery(Duration.ofSeconds(1));
    advanceSeconds(1);
    controller.onRecoveryOffsetReceived(0L);
    assertThat(controller.onStartChunk(CHUNK_160_MIB).getTotalTimeoutDuration())
        .isEqualTo(Duration.ofSeconds(55));

    // 3. Partial commit (80 MiB after 38s elapsed -> lag 30s) credits bytes and starts a fresh
    // deadline (16s - 30s + 60s = 46s) for the next chunk.
    advanceSeconds(17);
    controller.onStartQuery(Duration.ofSeconds(1));
    controller.onRecoveryOffsetReceived(80L * MIB);
    assertThat(controller.onStartChunk(CHUNK_160_MIB).getTotalTimeoutDuration())
        .isEqualTo(Duration.ofSeconds(46));
  }

  @Test
  void testTranslateException_relabelsTransientAndPreservesFatal() {
    ResumableUploadStallController controller = newController(10.0, 60, null);
    controller.onStartChunk(CHUNK_160_MIB);
    advanceSeconds(30); // Early backoff give-up before currentChunkDeadline (76s)

    ApiException unavailable503 = createHttpException(503, Code.UNAVAILABLE);
    Throwable translated503 =
        controller.translateException(unavailable503, ResumableUploadCommand.UPLOAD);
    assertThat(translated503).isInstanceOf(DeadlineExceededException.class);
    assertThat(translated503.getMessage()).isEqualTo("Resumable upload stalled");
    assertThat(translated503.getCause()).isSameInstanceAs(unavailable503);

    ApiException socketTimeout =
        ApiExceptionFactory.createException(
            "Read timed out", new SocketTimeoutException("Read timed out"), Code.UNKNOWN, false);
    assertThat(controller.translateException(socketTimeout, ResumableUploadCommand.UPLOAD))
        .isInstanceOf(DeadlineExceededException.class);

    advanceSeconds(100);
    ApiException forbidden403 = createHttpException(403, Code.PERMISSION_DENIED);
    assertThat(controller.translateException(forbidden403, ResumableUploadCommand.UPLOAD))
        .isSameInstanceAs(forbidden403);
  }

  @Test
  void testGlobalDeadline_trimsLocalTimeoutAndReportsTimedOut() {
    ResumableUploadStallController controller = newController(10.0, 60, Duration.ofSeconds(40));

    RetrySettings chunkSettings = controller.onStartChunk(CHUNK_160_MIB);
    assertThat(chunkSettings.getTotalTimeoutDuration()).isEqualTo(Duration.ofSeconds(40));
    assertThat(chunkSettings.getInitialRpcTimeoutDuration()).isEqualTo(Duration.ofSeconds(32));

    advanceSeconds(25);
    ApiException unavailable503 = createHttpException(503, Code.UNAVAILABLE);
    Throwable translated =
        controller.translateException(unavailable503, ResumableUploadCommand.UPLOAD);
    assertThat(translated).isInstanceOf(DeadlineExceededException.class);
    assertThat(translated.getMessage()).isEqualTo("Resumable upload timed out");
  }

  private ResumableUploadStallController newController(
      double minRateMiB, long stallTimeoutSec, @Nullable Duration globalDeadline) {
    return new ResumableUploadStallController(
        clock,
        minRateMiB,
        Duration.ofSeconds(stallTimeoutSec),
        globalDeadline,
        BASE_RETRY_SETTINGS);
  }

  private void advanceSeconds(long seconds) {
    clock.incrementNanoTime(TimeUnit.SECONDS.toNanos(seconds));
  }

  private void advanceMillis(long millis) {
    clock.incrementNanoTime(TimeUnit.MILLISECONDS.toNanos(millis));
  }

  private static ApiException createHttpException(final int httpStatus, final Code code) {
    StatusCode statusCode =
        new StatusCode() {
          @Override
          public Code getCode() {
            return code;
          }

          @Override
          public Integer getTransportCode() {
            return httpStatus;
          }
        };
    return ApiExceptionFactory.createException("HTTP " + httpStatus, null, statusCode, false);
  }
}
