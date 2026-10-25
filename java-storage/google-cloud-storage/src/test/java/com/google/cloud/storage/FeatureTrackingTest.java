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

package com.google.cloud.storage;

import static com.google.cloud.storage.TestUtils.assertAll;
import static com.google.common.truth.Truth.assertThat;
import static org.junit.Assert.assertThrows;

import com.google.cloud.storage.Storage.BlobSourceOption;
import com.google.common.collect.ImmutableList;
import com.google.common.collect.ImmutableMap;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.TimeUnit;
import org.junit.Test;

public final class FeatureTrackingTest {

  private static final int MULTISTREAM_BIT = TrackedFeatures.MULTISTREAM_IN_MRD.bitMask();

  @Test
  public void encode_knownVectors() throws Exception {
    assertAll(
        // the service tolerates an all-zero value, even though the client never sends it
        () -> assertThat(FeatureTracking.encode(0)).isEqualTo("AAAAAA=="),
        () -> assertThat(FeatureTracking.encode(1)).isEqualTo("AAAAAQ=="),
        () -> assertThat(FeatureTracking.encode(2)).isEqualTo("AAAAAg=="),
        () -> assertThat(FeatureTracking.encode(3)).isEqualTo("AAAAAw=="),
        () -> assertThat(FeatureTracking.encode(4)).isEqualTo("AAAABA=="),
        // 0xF8 and 0xFC produce the 62nd and 63rd base64 alphabet characters, which must be the
        // URL-safe '-' and '_' rather than the standard '+' and '/'
        () -> assertThat(FeatureTracking.encode(0xF8)).isEqualTo("AAAA-A=="),
        () -> assertThat(FeatureTracking.encode(0xFC)).isEqualTo("AAAA_A=="),
        // high bit set; verify unsigned, big-endian interpretation
        () -> assertThat(FeatureTracking.encode(0x80000000)).isEqualTo("gAAAAA=="),
        () -> assertThat(FeatureTracking.encode(0xFFFFFFFF)).isEqualTo("_____w=="));
  }

  @Test
  public void encode_everySingleBit_isUrlSafeWithPadding() {
    for (int shift = 0; shift < 32; shift++) {
      String encoded = FeatureTracking.encode(1 << shift);
      assertThat(encoded).hasLength(8);
      assertThat(encoded).doesNotContain("+");
      assertThat(encoded).doesNotContain("/");
      assertThat(encoded).endsWith("==");
    }
  }

  @Test
  public void mask_headers_emptyWhenNoFeatureSet() {
    FeatureTracking.Mask mask = new FeatureTracking.Mask();

    assertThat(mask.get()).isEqualTo(0);
    assertThat(mask.headers()).isEmpty();
  }

  @Test
  public void mask_headers_usesWireHeaderNameAndEncodedValue() {
    FeatureTracking.Mask mask = new FeatureTracking.Mask();

    mask.set(TrackedFeatures.MULTISTREAM_IN_MRD);

    assertThat(mask.headers())
        .containsExactly("x-goog-storage-java-features", ImmutableList.of("AAAAAQ=="));
  }

  @Test
  public void mask_set_isIdempotentAndMonotonic() {
    FeatureTracking.Mask mask = new FeatureTracking.Mask();

    mask.set(TrackedFeatures.MULTISTREAM_IN_MRD);
    mask.set(TrackedFeatures.MULTISTREAM_IN_MRD);

    assertThat(mask.get()).isEqualTo(MULTISTREAM_BIT);
    assertThat(mask.headers())
        .containsExactly(
            FeatureTracking.HEADER, ImmutableList.of(FeatureTracking.encode(MULTISTREAM_BIT)));
  }

  /**
   * Several threads concurrently set features on a single shared mask; the result must be the OR of
   * every feature set, with no lost updates.
   */
  @Test
  public void mask_set_isSafeUnderConcurrentUpdates() throws Exception {
    int threadCount = 8;
    int iterationsPerThread = 1_000;
    FeatureTracking.Mask mask = new FeatureTracking.Mask();
    CountDownLatch start = new CountDownLatch(1);
    ExecutorService executor = Executors.newFixedThreadPool(threadCount);
    try {
      List<Future<?>> futures = new ArrayList<>();
      for (int i = 0; i < threadCount; i++) {
        futures.add(
            executor.submit(
                () -> {
                  start.await();
                  for (int j = 0; j < iterationsPerThread; j++) {
                    mask.set(TrackedFeatures.MULTISTREAM_IN_MRD);
                  }
                  return null;
                }));
      }
      start.countDown();
      for (Future<?> f : futures) {
        f.get(30, TimeUnit.SECONDS);
      }
    } finally {
      executor.shutdownNow();
    }

    int expected = 0;
    for (TrackedFeatures feature : TrackedFeatures.values()) {
      expected |= feature.bitMask();
    }
    assertThat(mask.get()).isEqualTo(expected);
  }

  @Test
  public void trackedFeatures_bitPositionsAreUniqueAndInRange() {
    Set<Integer> seen = new HashSet<>();
    for (TrackedFeatures feature : TrackedFeatures.values()) {
      assertThat(feature.getBitPosition()).isAtLeast(0);
      assertThat(feature.getBitPosition()).isLessThan(32);
      assertThat(feature.bitMask()).isEqualTo(1 << feature.getBitPosition());
      seen.add(feature.getBitPosition());
    }
    assertThat(seen).hasSize(TrackedFeatures.values().length);
  }

  /** The wire value of each bit position is a cross-SDK contract; pin it. */
  @Test
  public void trackedFeatures_multistreamInMrd_isBitZero() {
    assertThat(TrackedFeatures.MULTISTREAM_IN_MRD.getBitPosition()).isEqualTo(0);
  }

  @Test
  public void extraHeaders_featureTrackingHeader_throws() {
    ImmutableMap<String, String> headers = ImmutableMap.of(FeatureTracking.HEADER, "AAAAAQ==");

    IllegalArgumentException thrown =
        assertThrows(IllegalArgumentException.class, () -> UnifiedOpts.extraHeaders(headers));

    assertThat(thrown).hasMessageThat().contains("Disallowed headers");
    assertThat(thrown).hasMessageThat().contains("x-goog-storage-java-features");
  }

  @Test
  public void extraHeaders_featureTrackingHeaderMixedCase_throws() {
    ImmutableMap<String, String> headers = ImmutableMap.of("X-Goog-Storage-Java-Features", "a");

    IllegalArgumentException thrown =
        assertThrows(IllegalArgumentException.class, () -> UnifiedOpts.extraHeaders(headers));

    assertThat(thrown).hasMessageThat().contains("x-goog-storage-java-features");
  }

  /**
   * The public option factories are transport agnostic and validate eagerly, so a blocked header is
   * rejected before it can reach either the gRPC or the HTTP/JSON transport.
   */
  @Test
  public void blobSourceOption_extraHeaders_featureTrackingHeader_throws() {
    ImmutableMap<String, String> headers = ImmutableMap.of(FeatureTracking.HEADER, "AAAAAQ==");

    IllegalArgumentException thrown =
        assertThrows(IllegalArgumentException.class, () -> BlobSourceOption.extraHeaders(headers));

    assertThat(thrown).hasMessageThat().contains("x-goog-storage-java-features");
  }
}
