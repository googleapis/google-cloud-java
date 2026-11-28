/*
 * Copyright 2026 Google LLC
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *       http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package com.google.cloud.spanner;

import static com.google.common.truth.Truth.assertThat;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertThrows;
import static org.junit.Assert.assertTrue;

import com.google.api.gax.grpc.GrpcStatusCode;
import com.google.api.gax.retrying.RetrySettings;
import com.google.api.gax.rpc.ApiException;
import com.google.api.gax.rpc.ApiExceptionFactory;
import com.google.api.gax.rpc.ErrorDetails;
import com.google.protobuf.Any;
import com.google.protobuf.ByteString;
import com.google.protobuf.util.Durations;
import com.google.rpc.RetryInfo;
import io.grpc.Metadata;
import io.grpc.Status;
import io.grpc.StatusRuntimeException;
import io.grpc.protobuf.ProtoUtils;
import java.time.Duration;
import java.util.Collections;
import java.util.concurrent.TimeUnit;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;

/** Unit tests for {@link StreamingRetryHelper}. */
@RunWith(JUnit4.class)
public class StreamingRetryHelperTest {

  private static final Metadata.Key<RetryInfo> KEY_RETRY_INFO =
      ProtoUtils.keyForProto(RetryInfo.getDefaultInstance());
  private static final Metadata.Key<byte[]> KEY_RETRY_INFO_RAW =
      Metadata.Key.of("google.rpc.retryinfo-bin", Metadata.BINARY_BYTE_MARSHALLER);
  private static final Metadata.Key<byte[]> KEY_ERROR_DETAILS =
      Metadata.Key.of("grpc-status-details-bin", Metadata.BINARY_BYTE_MARSHALLER);
  private static final Duration ONE_MILLI = Duration.ofMillis(1L);

  private static StatusRuntimeException statusWithRetryInfo(long seconds, int nanos) {
    Metadata trailers = new Metadata();
    RetryInfo retryInfo =
        RetryInfo.newBuilder()
            .setRetryDelay(
                com.google.protobuf.Duration.newBuilder().setSeconds(seconds).setNanos(nanos))
            .build();
    trailers.put(KEY_RETRY_INFO, retryInfo);
    return Status.UNAVAILABLE.withDescription("transient").asRuntimeException(trailers);
  }

  private static Any corruptRetryInfoAny() {
    return Any.newBuilder()
        .setTypeUrl("type.googleapis.com/google.rpc.RetryInfo")
        .setValue(ByteString.copyFrom(new byte[] {(byte) 0xFF, (byte) 0xFF, (byte) 0xFF}))
        .build();
  }

  @Test
  public void isMaxAttemptsExhaustedCoversUnlimitedDisabledAndBounded() {
    RetrySettings unlimited = RetrySettings.newBuilder().setMaxAttempts(0).build();
    assertFalse(StreamingRetryHelper.isMaxAttemptsExhausted(unlimited, 0));
    assertFalse(StreamingRetryHelper.isMaxAttemptsExhausted(unlimited, 100));

    RetrySettings disabled = RetrySettings.newBuilder().setMaxAttempts(1).build();
    assertFalse(StreamingRetryHelper.isMaxAttemptsExhausted(disabled, 0));
    assertTrue(StreamingRetryHelper.isMaxAttemptsExhausted(disabled, 1));

    RetrySettings bounded = RetrySettings.newBuilder().setMaxAttempts(3).build();
    assertFalse(StreamingRetryHelper.isMaxAttemptsExhausted(bounded, 2));
    assertTrue(StreamingRetryHelper.isMaxAttemptsExhausted(bounded, 3));
    assertTrue(StreamingRetryHelper.isMaxAttemptsExhausted(bounded, 4));

    assertThrows(
        NullPointerException.class, () -> StreamingRetryHelper.isMaxAttemptsExhausted(null, 1));
  }

  @Test
  public void isTotalTimeoutExceededHandlesUnsetSubMsNegativeElapsedAndOverflow() {
    RetrySettings unset = RetrySettings.newBuilder().build();
    assertFalse(StreamingRetryHelper.isTotalTimeoutExceeded(unset, 1_000_000L, Duration.ofDays(1)));

    RetrySettings subMs =
        RetrySettings.newBuilder().setTotalTimeoutDuration(Duration.ofNanos(500_000L)).build();
    assertFalse(StreamingRetryHelper.isTotalTimeoutExceeded(subMs, 0L, Duration.ofNanos(100_000L)));
    assertTrue(StreamingRetryHelper.isTotalTimeoutExceeded(subMs, 0L, Duration.ofNanos(500_000L)));
    assertTrue(StreamingRetryHelper.isTotalTimeoutExceeded(subMs, 500_000L, Duration.ZERO));

    RetrySettings oneSecond =
        RetrySettings.newBuilder().setTotalTimeoutDuration(Duration.ofSeconds(1L)).build();
    assertFalse(
        StreamingRetryHelper.isTotalTimeoutExceeded(
            oneSecond, -TimeUnit.SECONDS.toNanos(60L), null));
    assertFalse(
        StreamingRetryHelper.isTotalTimeoutExceeded(
            oneSecond, -TimeUnit.SECONDS.toNanos(60L), Duration.ofMillis(-5L)));
    assertTrue(
        StreamingRetryHelper.isTotalTimeoutExceeded(
            oneSecond, -TimeUnit.SECONDS.toNanos(60L), Duration.ofSeconds(1L)));
    assertTrue(
        StreamingRetryHelper.isTotalTimeoutExceeded(
            oneSecond, TimeUnit.SECONDS.toNanos(60L), Duration.ofMillis(-5L)));
    assertTrue(
        StreamingRetryHelper.isTotalTimeoutExceeded(
            oneSecond, TimeUnit.MILLISECONDS.toNanos(100L), Duration.ofMillis(Long.MAX_VALUE)));

    RetrySettings hugeTimeout =
        RetrySettings.newBuilder()
            .setTotalTimeoutDuration(Duration.ofMillis(Long.MAX_VALUE))
            .build();
    assertFalse(StreamingRetryHelper.isTotalTimeoutExceeded(hugeTimeout, 0L, Duration.ofDays(1)));
    assertTrue(
        StreamingRetryHelper.isTotalTimeoutExceeded(
            hugeTimeout, 0L, Duration.ofSeconds(Long.MAX_VALUE)));
  }

  @Test
  public void extractServerRetryDelayCoversTrailersErrorDetailsCorruptAndBoundaries() {
    assertNull(StreamingRetryHelper.extractServerRetryDelay(null));
    assertNull(StreamingRetryHelper.extractRawServerRetryDelay(null, null));

    // Zero, sub-millisecond, and negative delays return null for streaming retries while
    // extractRawServerRetryDelay preserves valid protobuf durations.
    StatusRuntimeException zero = statusWithRetryInfo(0L, 0);
    assertNull(StreamingRetryHelper.extractServerRetryDelay(zero));
    assertEquals(
        com.google.protobuf.Duration.getDefaultInstance(),
        StreamingRetryHelper.extractRawServerRetryDelay(zero, null));

    StatusRuntimeException subMs = statusWithRetryInfo(0L, 999_999);
    assertNull(StreamingRetryHelper.extractServerRetryDelay(subMs));
    assertEquals(
        com.google.protobuf.Duration.newBuilder().setNanos(999_999).build(),
        StreamingRetryHelper.extractRawServerRetryDelay(subMs, null));

    StatusRuntimeException negative = statusWithRetryInfo(-1L, 0);
    assertNull(StreamingRetryHelper.extractServerRetryDelay(negative));
    assertEquals(
        com.google.protobuf.Duration.newBuilder().setSeconds(-1L).build(),
        StreamingRetryHelper.extractRawServerRetryDelay(negative, null));

    // Exact 1ms boundary and multi-second values succeed.
    assertEquals(
        Duration.ofMillis(1L),
        StreamingRetryHelper.extractServerRetryDelay(statusWithRetryInfo(0L, 1_000_000)));
    assertEquals(
        Duration.ofSeconds(2L, 500_000L),
        StreamingRetryHelper.extractServerRetryDelay(statusWithRetryInfo(2L, 500_000)));

    // RetryInfo without retry_delay set returns null.
    Metadata emptyRetryInfoTrailers = new Metadata();
    emptyRetryInfoTrailers.put(KEY_RETRY_INFO, RetryInfo.getDefaultInstance());
    assertNull(
        StreamingRetryHelper.extractServerRetryDelay(
            Status.UNAVAILABLE.asRuntimeException(emptyRetryInfoTrailers)));

    // Invalid protobuf Duration (out of range seconds or mismatched sign) returns null.
    StatusRuntimeException invalidDuration = statusWithRetryInfo(400_000_000_000L, 0);
    assertNull(StreamingRetryHelper.extractServerRetryDelay(invalidDuration));
    assertNull(StreamingRetryHelper.extractRawServerRetryDelay(invalidDuration, null));

    // Corrupt google.rpc.retryinfo-bin trailer returns null instead of throwing.
    Metadata corruptTrailer = new Metadata();
    corruptTrailer.put(KEY_RETRY_INFO_RAW, new byte[] {(byte) 0xFF, (byte) 0xFF, (byte) 0xFF});
    assertNull(
        StreamingRetryHelper.extractServerRetryDelay(
            Status.UNAVAILABLE.asRuntimeException(corruptTrailer)));

    // Corrupt Any RetryInfo inside grpc-status-details-bin returns null instead of throwing.
    com.google.rpc.Status corruptRpcStatus =
        com.google.rpc.Status.newBuilder()
            .setCode(com.google.rpc.Code.UNAVAILABLE_VALUE)
            .addDetails(corruptRetryInfoAny())
            .build();
    Metadata corruptDetailsTrailers = new Metadata();
    corruptDetailsTrailers.put(KEY_ERROR_DETAILS, corruptRpcStatus.toByteArray());
    assertNull(
        StreamingRetryHelper.extractServerRetryDelay(
            Status.UNAVAILABLE.asRuntimeException(corruptDetailsTrailers)));

    // Corrupt ErrorDetails falls through independently to a valid google.rpc.retryinfo-bin trailer.
    Metadata mixedTrailers = new Metadata();
    mixedTrailers.put(KEY_ERROR_DETAILS, corruptRpcStatus.toByteArray());
    mixedTrailers.put(
        KEY_RETRY_INFO, RetryInfo.newBuilder().setRetryDelay(Durations.fromMillis(450L)).build());
    assertEquals(
        Duration.ofMillis(450L),
        StreamingRetryHelper.extractServerRetryDelay(
            Status.UNAVAILABLE.asRuntimeException(mixedTrailers)));

    // ApiException with corrupt ErrorDetails falls through to cause's valid retryinfo-bin trailer.
    ApiException corruptApiException =
        ApiExceptionFactory.createException(
            "corrupt error details",
            statusWithRetryInfo(0L, (int) TimeUnit.MILLISECONDS.toNanos(450L)),
            GrpcStatusCode.of(Status.Code.UNAVAILABLE),
            /* retryable= */ true,
            ErrorDetails.builder()
                .setRawErrorMessages(Collections.singletonList(corruptRetryInfoAny()))
                .build());
    assertEquals(
        Duration.ofMillis(450L), StreamingRetryHelper.extractServerRetryDelay(corruptApiException));

    // ApiException with valid ErrorDetails extracted via apiException parameter when error is null.
    ApiException validApiException =
        ApiExceptionFactory.createException(
            "valid error details",
            null,
            GrpcStatusCode.of(Status.Code.UNAVAILABLE),
            /* retryable= */ true,
            ErrorDetails.builder()
                .setRawErrorMessages(
                    Collections.singletonList(
                        Any.pack(
                            RetryInfo.newBuilder()
                                .setRetryDelay(Durations.fromMillis(678L))
                                .build())))
                .build());
    assertEquals(
        Durations.fromMillis(678L),
        StreamingRetryHelper.extractRawServerRetryDelay(null, validApiException));

    // Valid grpc-status-details-bin on wrapped cause chain is discovered.
    com.google.rpc.Status validRpcStatus =
        com.google.rpc.Status.newBuilder()
            .setCode(com.google.rpc.Code.UNAVAILABLE_VALUE)
            .addDetails(
                Any.pack(RetryInfo.newBuilder().setRetryDelay(Durations.fromMillis(321L)).build()))
            .build();
    Metadata detailsTrailers = new Metadata();
    detailsTrailers.put(KEY_ERROR_DETAILS, validRpcStatus.toByteArray());
    Throwable wrapped =
        new RuntimeException("wrapper", Status.UNAVAILABLE.asRuntimeException(detailsTrailers));
    assertEquals(Duration.ofMillis(321L), StreamingRetryHelper.extractServerRetryDelay(wrapped));

    // ErrorDetails containing RetryInfo without retry_delay falls through to trailer.
    ApiException emptyDetailsWithTrailer =
        ApiExceptionFactory.createException(
            "empty retry info",
            statusWithRetryInfo(0L, (int) TimeUnit.MILLISECONDS.toNanos(222L)),
            GrpcStatusCode.of(Status.Code.UNAVAILABLE),
            /* retryable= */ true,
            ErrorDetails.builder()
                .setRawErrorMessages(
                    Collections.singletonList(Any.pack(RetryInfo.getDefaultInstance())))
                .build());
    assertEquals(
        Duration.ofMillis(222L),
        StreamingRetryHelper.extractServerRetryDelay(emptyDetailsWithTrailer));
  }

  @Test
  public void effectiveMaxRetryDelayCoversDefaultConfiguredSubMsAndValidation() {
    RetrySettings unset = RetrySettings.newBuilder().build();
    assertEquals(
        StreamingRetryHelper.DEFAULT_MAX_RETRY_DELAY,
        StreamingRetryHelper.effectiveMaxRetryDelay(unset, Duration.ZERO));
    assertEquals(
        StreamingRetryHelper.DEFAULT_MAX_RETRY_DELAY,
        StreamingRetryHelper.effectiveMaxRetryDelay(unset, ONE_MILLI));

    RetrySettings subMs =
        RetrySettings.newBuilder().setMaxRetryDelayDuration(Duration.ofNanos(500_000L)).build();
    assertEquals(
        Duration.ofNanos(500_000L),
        StreamingRetryHelper.effectiveMaxRetryDelay(subMs, Duration.ZERO));
    assertEquals(ONE_MILLI, StreamingRetryHelper.effectiveMaxRetryDelay(subMs, ONE_MILLI));

    assertThrows(
        IllegalArgumentException.class,
        () -> StreamingRetryHelper.effectiveMaxRetryDelay(unset, Duration.ofMillis(-1L)));
  }

  @Test
  public void computeRetryDelayClampsServerDelayAndAppliesUnifiedJitterAndEdgeCases() {
    RetrySettings settings =
        RetrySettings.newBuilder()
            .setInitialRetryDelayDuration(Duration.ofMillis(100L))
            .setRetryDelayMultiplier(2.0)
            .setMaxRetryDelayDuration(Duration.ofSeconds(10L))
            .build();

    // Server delay within cap honored verbatim; above cap clamped to maxRetryDelay.
    assertEquals(
        Duration.ofMillis(345L),
        StreamingRetryHelper.computeRetryDelay(
            settings, statusWithRetryInfo(0L, 345_000_000), 1, () -> 0.0, ONE_MILLI));
    assertEquals(
        Duration.ofSeconds(10L),
        StreamingRetryHelper.computeRetryDelay(
            settings,
            statusWithRetryInfo(TimeUnit.HOURS.toSeconds(3L), 0),
            1,
            () -> 0.0,
            ONE_MILLI));

    // Unset initialRetryDelay: Duration.ZERO with minDelay=0, 1ms with minDelay=1ms.
    RetrySettings unset = RetrySettings.newBuilder().setRetryDelayMultiplier(10.0).build();
    assertEquals(
        Duration.ZERO,
        StreamingRetryHelper.computeRetryDelay(unset, null, 1, () -> 1.0, Duration.ZERO));
    assertEquals(
        ONE_MILLI, StreamingRetryHelper.computeRetryDelay(unset, null, 1, () -> 0.0, ONE_MILLI));
    assertEquals(
        Duration.ofSeconds(32L),
        StreamingRetryHelper.computeRetryDelay(unset, null, 6, () -> 1.0, ONE_MILLI));

    // Sub-millisecond initialDelay: preserved with minDelay=0, floored to 1ms with minDelay=1ms.
    RetrySettings subMs =
        RetrySettings.newBuilder()
            .setInitialRetryDelayDuration(Duration.ofNanos(500_000L))
            .setMaxRetryDelayDuration(Duration.ofNanos(500_000L))
            .build();
    assertEquals(
        Duration.ofNanos(500_000L),
        StreamingRetryHelper.computeRetryDelay(subMs, null, 1, () -> 1.0, Duration.ZERO));
    assertEquals(
        ONE_MILLI, StreamingRetryHelper.computeRetryDelay(subMs, null, 1, () -> 0.0, ONE_MILLI));

    // Huge maxRetryDelay: server delay of 120s is honored unclamped and backoff gives 100ms.
    RetrySettings hugeMax =
        RetrySettings.newBuilder()
            .setInitialRetryDelayDuration(Duration.ofMillis(100L))
            .setMaxRetryDelayDuration(Duration.ofSeconds(Long.MAX_VALUE))
            .build();
    assertEquals(
        Duration.ofSeconds(120L),
        StreamingRetryHelper.computeRetryDelay(
            hugeMax, statusWithRetryInfo(120L, 0), 1, () -> 1.0, Duration.ZERO));
    assertEquals(
        Duration.ofMillis(100L),
        StreamingRetryHelper.computeRetryDelay(hugeMax, null, 1, () -> 1.0, Duration.ZERO));

    // Jitter random out-of-range (< 0, > 1, NaN, Infinity) and extreme attempt count (<= 0, 1000).
    assertEquals(
        Duration.ofMillis(50L),
        StreamingRetryHelper.computeRetryDelay(settings, null, 0, () -> -5.0, Duration.ZERO));
    assertEquals(
        Duration.ofMillis(100L),
        StreamingRetryHelper.computeRetryDelay(settings, null, 1, () -> 5.0, Duration.ZERO));
    assertEquals(
        Duration.ofMillis(100L),
        StreamingRetryHelper.computeRetryDelay(settings, null, 1, () -> Double.NaN, Duration.ZERO));
    assertEquals(
        Duration.ofMillis(100L),
        StreamingRetryHelper.computeRetryDelay(
            settings, null, 1, () -> Double.POSITIVE_INFINITY, Duration.ZERO));
    assertEquals(
        Duration.ofSeconds(10L),
        StreamingRetryHelper.computeRetryDelay(settings, null, 1000, () -> 1.0, Duration.ZERO));

    // Overflowing initialRetryDelay and maxRetryDelay saturate cleanly without throwing.
    RetrySettings overflowing =
        RetrySettings.newBuilder()
            .setInitialRetryDelayDuration(Duration.ofMillis(Long.MAX_VALUE))
            .setMaxRetryDelayDuration(Duration.ofSeconds(Long.MAX_VALUE))
            .build();
    assertEquals(
        Duration.ofNanos(Long.MAX_VALUE),
        StreamingRetryHelper.computeRetryDelay(overflowing, null, 1, () -> 1.0, Duration.ZERO));

    // Sub-nanosecond jitter result rounds down to ZERO with minDelay=0, floored to 1ms with 1ms.
    RetrySettings oneNano =
        RetrySettings.newBuilder()
            .setInitialRetryDelayDuration(Duration.ofNanos(1L))
            .setMaxRetryDelayDuration(Duration.ofNanos(1L))
            .build();
    assertEquals(
        Duration.ZERO,
        StreamingRetryHelper.computeRetryDelay(oneNano, null, 1, () -> 0.0, Duration.ZERO));
    assertEquals(
        Duration.ofNanos(1L),
        StreamingRetryHelper.computeRetryDelay(oneNano, null, 1, () -> 1.0, Duration.ZERO));
  }

  @Test
  public void saturatedDurationMillisAndToSaturatedNanosHandleBoundariesAndOverflow() {
    assertEquals(42L, StreamingRetryHelper.saturatedDurationMillis(null, 42L, 100L));
    assertEquals(42L, StreamingRetryHelper.saturatedDurationMillis(Duration.ZERO, 42L, 100L));
    assertEquals(
        42L, StreamingRetryHelper.saturatedDurationMillis(Duration.ofMillis(-5L), 42L, 100L));
    assertEquals(1L, StreamingRetryHelper.saturatedDurationMillis(Duration.ofNanos(1L), 42L, 100L));
    assertEquals(
        50L, StreamingRetryHelper.saturatedDurationMillis(Duration.ofMillis(50L), 42L, 100L));
    assertEquals(
        100L, StreamingRetryHelper.saturatedDurationMillis(Duration.ofMillis(500L), 42L, 100L));
    assertEquals(
        100L,
        StreamingRetryHelper.saturatedDurationMillis(
            Duration.ofSeconds(Long.MAX_VALUE), 42L, 100L));

    assertEquals(0L, StreamingRetryHelper.toSaturatedNanos(Duration.ZERO));
    assertEquals(1_000_000L, StreamingRetryHelper.toSaturatedNanos(Duration.ofMillis(1L)));
    assertEquals(
        Long.MAX_VALUE, StreamingRetryHelper.toSaturatedNanos(Duration.ofSeconds(Long.MAX_VALUE)));
    assertEquals(
        Long.MIN_VALUE, StreamingRetryHelper.toSaturatedNanos(Duration.ofSeconds(Long.MIN_VALUE)));
    assertThat(StreamingRetryHelper.DEFAULT_MAX_RETRY_DELAY).isEqualTo(Duration.ofSeconds(32L));
  }
}
