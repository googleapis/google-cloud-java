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

import com.google.common.annotations.VisibleForTesting;
import com.google.common.collect.ImmutableList;
import com.google.common.collect.ImmutableMap;
import com.google.common.primitives.Ints;
import java.util.Base64;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;
import javax.annotation.concurrent.ThreadSafe;

/**
 * Utilities for reporting {@link TrackedFeatures client feature usage} to the service.
 *
 * <p>Encoding contract (shared across GCS SDKs):
 *
 * <ul>
 *   <li>The set of used features is a 32-bit mask where bit {@code n} corresponds to the feature
 *       with {@link TrackedFeatures#getBitPosition()} {@code == n}.
 *   <li>The mask is serialized as 4 bytes big-endian, then encoded with URL-safe base64 (RFC 4648
 *       §5) <em>with</em> padding. The service rejects {@code +} and {@code /}.
 *   <li>When the mask is {@code 0} the header is omitted entirely.
 * </ul>
 */
final class FeatureTracking {

  /** Name of the request header / gRPC metadata key carrying the encoded feature mask. */
  static final String HEADER = "x-goog-storage-java-features";

  private static final Base64.Encoder ENCODER = Base64.getUrlEncoder();

  private FeatureTracking() {}

  /** Encodes {@code mask} as a 4 byte big-endian uint32, URL-safe base64 with padding. */
  @VisibleForTesting
  static String encode(int mask) {
    return ENCODER.encodeToString(Ints.toByteArray(mask));
  }

  /**
   * Returns the header map to merge into a request's extra headers: an empty map when {@code mask
   * == 0}, otherwise a single entry map for {@link #HEADER}.
   */
  private static ImmutableMap<String, List<String>> headers(int mask) {
    if (mask == 0) {
      return ImmutableMap.of();
    }
    return ImmutableMap.of(HEADER, ImmutableList.of(encode(mask)));
  }

  /** Monotonically growing feature bitmask. Bits can be set but never cleared. */
  @ThreadSafe
  static final class Mask {
    private final AtomicInteger bits = new AtomicInteger();

    void set(TrackedFeatures feature) {
      bits.updateAndGet(current -> current | feature.bitMask());
    }

    @VisibleForTesting
    int get() {
      return bits.get();
    }

    /** Returns the headers to attach to a request, see {@link FeatureTracking#headers(int)}. */
    ImmutableMap<String, List<String>> headers() {
      return FeatureTracking.headers(bits.get());
    }
  }
}
