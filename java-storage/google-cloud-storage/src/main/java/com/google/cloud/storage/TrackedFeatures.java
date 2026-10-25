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

/**
 * A client feature whose usage is reported to the service via the {@link FeatureTracking#HEADER
 * x-goog-storage-java-features} request header.
 *
 * <p>Each feature is assigned a stable bit position in a 32-bit mask. Bit positions are specific to
 * the Java SDK but MUST NOT be renumbered or reused once released. This enum is the single source
 * of truth and is parsed by external tooling; keep the {@code NAME(bit)} shape intact.
 */
enum TrackedFeatures {
  /**
   * A {@link BlobReadSession} opened more than one BidiReadObject stream to serve concurrent reads
   * which could not share a single stream.
   */
  MULTISTREAM_IN_MRD(0);

  private final int bitPosition;

  TrackedFeatures(int bitPosition) {
    this.bitPosition = bitPosition;
  }

  int getBitPosition() {
    return bitPosition;
  }

  /** Returns the 32-bit mask with only this feature's bit set. */
  int bitMask() {
    return 1 << bitPosition;
  }
}
