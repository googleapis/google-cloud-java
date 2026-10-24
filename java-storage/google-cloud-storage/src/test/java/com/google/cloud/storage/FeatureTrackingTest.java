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

import static com.google.common.truth.Truth.assertThat;
import static org.junit.Assert.assertThrows;

import com.google.cloud.storage.UnifiedOpts.Opts;
import com.google.common.collect.ImmutableList;
import com.google.common.collect.ImmutableMap;
import java.util.HashSet;
import java.util.Set;
import org.junit.Test;

public final class FeatureTrackingTest {

  @Test
  public void headerName() {
    assertThat(FeatureTracking.HEADER).isEqualTo("x-goog-storage-java-features");
  }

  @Test
  public void encode_knownVectors() {
    assertThat(FeatureTracking.encode(0)).isEqualTo("AAAAAA==");
    assertThat(FeatureTracking.encode(1)).isEqualTo("AAAAAQ==");
    assertThat(FeatureTracking.encode(4)).isEqualTo("AAAABA==");
    assertThat(FeatureTracking.encode(0xF8)).isEqualTo("AAAA-A==");
  }

  @Test
  public void encode_isUrlSafeWithPadding() {
    for (int shift = 0; shift < 32; shift++) {
      int mask = 1 << shift;
      String encoded = FeatureTracking.encode(mask);
      assertThat(encoded).hasLength(8);
      assertThat(encoded).doesNotContain("+");
      assertThat(encoded).doesNotContain("/");
      assertThat(encoded).endsWith("==");
    }
    // high bit set; verify unsigned/big-endian interpretation
    assertThat(FeatureTracking.encode(0xFFFFFFFF)).isEqualTo("_____w==");
    assertThat(FeatureTracking.encode(0x80000000)).isEqualTo("gAAAAA==");
  }

  @Test
  public void headers_omittedWhenMaskIsZero() {
    assertThat(FeatureTracking.headers(0)).isEmpty();
    assertThat(new FeatureTracking.Mask().headers()).isEmpty();
  }

  @Test
  public void headers_presentWhenMaskIsNonZero() {
    assertThat(FeatureTracking.headers(1))
        .containsExactly(FeatureTracking.HEADER, ImmutableList.of("AAAAAQ=="));
  }

  @Test
  public void mask_setIsIdempotentAndMonotonic() {
    FeatureTracking.Mask mask = new FeatureTracking.Mask();
    assertThat(mask.isSet(TrackedFeatures.MULTISTREAM_IN_MRD)).isFalse();
    mask.set(TrackedFeatures.MULTISTREAM_IN_MRD);
    mask.set(TrackedFeatures.MULTISTREAM_IN_MRD);
    assertThat(mask.isSet(TrackedFeatures.MULTISTREAM_IN_MRD)).isTrue();
    assertThat(mask.get()).isEqualTo(1);
    assertThat(mask.headers())
        .containsExactly(FeatureTracking.HEADER, ImmutableList.of("AAAAAQ=="));
  }

  @Test
  public void trackedFeatures_bitPositionsAreUniqueAndInRange() {
    Set<Integer> seen = new HashSet<>();
    for (TrackedFeatures f : TrackedFeatures.values()) {
      assertThat(f.getBitPosition()).isAtLeast(0);
      assertThat(f.getBitPosition()).isLessThan(32);
      assertThat(seen.add(f.getBitPosition())).isTrue();
    }
    assertThat(TrackedFeatures.MULTISTREAM_IN_MRD.getBitPosition()).isEqualTo(0);
  }

  @Test
  public void extraHeaders_rejectsFeatureTrackingHeader() {
    IllegalArgumentException e =
        assertThrows(
            IllegalArgumentException.class,
            () ->
                Opts.from(
                    UnifiedOpts.extraHeaders(ImmutableMap.of(FeatureTracking.HEADER, "AAAAAQ=="))));
    assertThat(e).hasMessageThat().contains(FeatureTracking.HEADER);

    // case-insensitive
    assertThrows(
        IllegalArgumentException.class,
        () ->
            Opts.from(
                UnifiedOpts.extraHeaders(
                    ImmutableMap.of("X-Goog-Storage-Java-Features", "AAAAAQ=="))));
  }
}
