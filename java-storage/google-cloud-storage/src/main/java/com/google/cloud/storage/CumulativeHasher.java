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

import com.google.api.gax.grpc.GrpcStatusCode;
import com.google.cloud.storage.Crc32cValue.Crc32cLengthKnown;
import com.google.protobuf.ByteString;
import com.google.storage.v2.Object;
import io.grpc.Status.Code;
import java.nio.ByteBuffer;
import java.util.Locale;
import java.util.OptionalLong;
import java.util.function.Supplier;

/**
 * A wrapper around hasher that accumulates checksums and validates them at the end of the read if
 * it was a full object read.
 */
final class CumulativeHasher implements Hasher {
  private final Hasher delegate;
  private final long startOffset;
  private final OptionalLong limit;
  private Crc32cLengthKnown cumulativeHash;

  CumulativeHasher(Hasher delegate, long startOffset, OptionalLong limit) {
    this.delegate = delegate;
    this.startOffset = startOffset;
    this.limit = limit;
    this.cumulativeHash = delegate.initialValue();
  }

  @Override
  public Crc32cLengthKnown hash(ByteBuffer b) {
    return delegate.hash(b);
  }

  @Override
  public Crc32cLengthKnown hash(ByteString byteString) {
    return delegate.hash(byteString);
  }

  @Override
  public void validate(Crc32cValue<?> expected, Supplier<ByteBuffer> b)
      throws ChecksumMismatchException {
    ByteBuffer byteBuffer = b.get();
    Crc32cLengthKnown actual = delegate.hash(byteBuffer);
    if (actual != null) {
      if (expected != null && !actual.eqValue(expected)) {
        throw new ChecksumMismatchException(expected, actual);
      }
      accumulate(actual);
    }
  }

  @Override
  public void validate(Crc32cValue<?> expected, ByteString byteString)
      throws ChecksumMismatchException {
    Crc32cLengthKnown actual = delegate.hash(byteString);
    if (actual != null) {
      if (expected != null && !actual.eqValue(expected)) {
        throw new ChecksumMismatchException(expected, actual);
      }
      accumulate(actual);
    }
  }

  @Override
  public void validateUnchecked(Crc32cValue<?> expected, ByteString byteString)
      throws UncheckedChecksumMismatchException {
    Crc32cLengthKnown actual = delegate.hash(byteString);
    if (actual != null) {
      if (expected != null && !actual.eqValue(expected)) {
        throw new UncheckedChecksumMismatchException(expected, actual);
      }
      accumulate(actual);
    }
  }

  @Override
  public void validate(Crc32cValue<?> expected, Crc32cLengthKnown actual)
      throws ChecksumMismatchException {
    if (actual != null) {
      if (expected != null && !actual.eqValue(expected)) {
        throw new ChecksumMismatchException(expected, actual);
      }
      accumulate(actual);
    }
  }

  @Override
  public <C extends Crc32cValue<?>> C nullSafeConcat(C r1, Crc32cLengthKnown r2) {
    return delegate.nullSafeConcat(r1, r2);
  }

  @Override
  public Crc32cLengthKnown initialValue() {
    return delegate.initialValue();
  }

  // Checks if it was a full object read.
  boolean qualifiesForVerification(Object metadata) {
    return startOffset == 0
        && metadata != null
        && metadata.hasChecksums()
        && metadata.getChecksums().hasCrc32C()
        && (!limit.isPresent() || limit.getAsLong() >= metadata.getSize());
  }

  void validateCumulativeChecksum(Object metadata)
      throws UncheckedCumulativeChecksumMismatchException {
    if (qualifiesForVerification(metadata)) {
      Crc32cLengthKnown actual = getCumulativeHash();
      if (actual == null) {
        return;
      }
      Crc32cValue<?> expected = Crc32cValue.of(metadata.getChecksums().getCrc32C());
      if (!actual.eqValue(expected)) {
        throw new UncheckedCumulativeChecksumMismatchException(expected, actual);
      }
    }
  }

  private void accumulate(Crc32cLengthKnown actual) {
    cumulativeHash = nullSafeConcat(cumulativeHash, actual);
  }

  Crc32cLengthKnown getCumulativeHash() {
    return cumulativeHash;
  }
}

final class UncheckedCumulativeChecksumMismatchException
    extends com.google.api.gax.rpc.DataLossException {
  private static final GrpcStatusCode STATUS_CODE = GrpcStatusCode.of(Code.DATA_LOSS);
  private final Crc32cValue<?> expected;
  private final Crc32cLengthKnown actual;

  UncheckedCumulativeChecksumMismatchException(Crc32cValue<?> expected, Crc32cLengthKnown actual) {
    super(
        String.format(
            Locale.US,
            "Mismatch cumulative checksum value. Expected %s actual %s",
            expected.debugString(),
            actual.debugString()),
        /* cause= */ null,
        STATUS_CODE,
        /* retryable= */ false);
    this.expected = expected;
    this.actual = actual;
  }

  Crc32cValue<?> getExpected() {
    return expected;
  }

  Crc32cLengthKnown getActual() {
    return actual;
  }
}
