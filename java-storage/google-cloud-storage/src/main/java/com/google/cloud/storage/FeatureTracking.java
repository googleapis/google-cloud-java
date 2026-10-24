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

import com.google.common.collect.ImmutableList;
import com.google.common.collect.ImmutableMap;
import java.nio.ByteBuffer;
import java.util.Base64;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;

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

  static int bit(TrackedFeatures feature) {
    return 1 << feature.getBitPosition();
  }

  /** Encode {@code mask} as a 4 byte big-endian uint32, URL-safe base64 with padding. */
  static String encode(int mask) {
    ByteBuffer buf = ByteBuffer.allocate(4);
    buf.putInt(mask); // ByteBuffer default byte order is BIG_ENDIAN
    return ENCODER.encodeToString(buf.array());
  }

  /**
   * Produce the header map to merge into a request's extra headers.
   *
   * @return an empty map when {@code mask == 0}, otherwise a single entry map for {@link #HEADER}
   */
  static ImmutableMap<String, List<String>> headers(int mask) {
    if (mask == 0) {
      return ImmutableMap.of();
    }
    return ImmutableMap.of(HEADER, ImmutableList.of(encode(mask)));
  }

  /** Thread-safe, monotonically growing feature bitmask. */
  static final class Mask {
    private final AtomicInteger bits = new AtomicInteger();

    Mask() {}

    void set(TrackedFeatures feature) {
      bits.updateAndGet(current -> current | bit(feature));
    }

    boolean isSet(TrackedFeatures feature) {
      return (bits.get() & bit(feature)) != 0;
    }

    int get() {
      return bits.get();
    }

    ImmutableMap<String, List<String>> headers() {
      return FeatureTracking.headers(get());
    }
  }
}
