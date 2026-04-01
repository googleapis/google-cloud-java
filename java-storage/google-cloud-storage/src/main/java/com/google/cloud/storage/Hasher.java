/*
 * Copyright 2022 Google LLC
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
import com.google.api.gax.rpc.DataLossException;
import com.google.cloud.storage.Crc32cValue.Crc32cLengthKnown;
import com.google.common.hash.Hashing;
import com.google.protobuf.ByteString;
import io.grpc.Status.Code;
import java.io.IOException;
import java.nio.ByteBuffer;
import java.util.List;
import java.util.Locale;
import java.util.function.Supplier;
import java.util.logging.Logger;
import javax.annotation.ParametersAreNonnullByDefault;
import javax.annotation.concurrent.Immutable;
import org.checkerframework.checker.nullness.qual.NonNull;
import org.checkerframework.checker.nullness.qual.Nullable;

@SuppressWarnings("ClassEscapesDefinedScope")
@ParametersAreNonnullByDefault
interface Hasher {
  final class DefaultInstanceHolder {
    private static final Logger LOGGER = Logger.getLogger(Hasher.class.getName());
    private static final String PROPERTY_NAME = "com.google.cloud.storage.Hasher.default";
    private static final String PROPERTY_VALUE = System.getProperty(PROPERTY_NAME, "enabled");
    static final Hasher DEFAULT_HASHER;

    static {
      LOGGER.fine(String.format(Locale.US, "-D%s=%s", PROPERTY_NAME, PROPERTY_VALUE));
      if ("disabled".equalsIgnoreCase(PROPERTY_VALUE)) {
        DEFAULT_HASHER = noop();
      } else {
        try {
          Class.forName("java.util.zip.CRC32C");
        } catch (ClassNotFoundException e) {
          LOGGER.fine("Fast CRC32C implementation (Java 9+) is not available.");
        }
        DEFAULT_HASHER = enabled();
      }
    }
  }

  @Nullable
  default Crc32cLengthKnown hash(Supplier<ByteBuffer> b) {
    return hash(b.get());
  }

  @Nullable Crc32cLengthKnown hash(ByteBuffer b);

  @Nullable Crc32cLengthKnown hash(ByteString byteString);

  void validate(Crc32cValue<?> expected, Supplier<ByteBuffer> b) throws ChecksumMismatchException;

  void validate(Crc32cValue<?> expected, ByteString byteString) throws ChecksumMismatchException;

  void validateUnchecked(Crc32cValue<?> expected, ByteString byteString)
      throws UncheckedChecksumMismatchException;

  @Nullable <C extends Crc32cValue<?>> C nullSafeConcat(
      @Nullable C r1, @Nullable Crc32cLengthKnown r2);

  /**
   * The initial value to use for this hasher.
   *
   * <p>Not ideal, really we should always start with {@link Crc32cValue#zero()} but this saves us
   * from having to plumb the initial value along with the actual hasher to the constructor of the
   * WriteCtx when hashing is disabled because of user provided crc32c/md5 preconditions.
   */
  @Nullable Crc32cLengthKnown initialValue();

  static NoOpHasher noop() {
    return NoOpHasher.INSTANCE;
  }

  static GuavaHasher enabled() {
    return GuavaHasher.INSTANCE;
  }

  static Hasher defaultHasher() {
    return DefaultInstanceHolder.DEFAULT_HASHER;
  }

  @Immutable
  class NoOpHasher implements Hasher {
    private static final NoOpHasher INSTANCE = new NoOpHasher();

    private NoOpHasher() {}

    @Override
    public Crc32cLengthKnown hash(ByteBuffer b) {
      return null;
    }

    @Override
    public @Nullable Crc32cLengthKnown hash(ByteString byteString) {
      return null;
    }

    @Override
    public void validate(Crc32cValue<?> expected, Supplier<ByteBuffer> b) {}

    @Override
    public void validate(Crc32cValue<?> expected, ByteString b) {}

    @Override
    public void validateUnchecked(Crc32cValue<?> expected, ByteString byteString) {}

    @Override
    public <C extends Crc32cValue<?>> @Nullable C nullSafeConcat(
        @Nullable C r1, @Nullable Crc32cLengthKnown r2) {
      return null;
    }

    @Override
    public @Nullable Crc32cLengthKnown initialValue() {
      return null;
    }
  }

  @Immutable
  class GuavaHasher implements Hasher {
    private static final GuavaHasher INSTANCE = new GuavaHasher();

    private GuavaHasher() {}

    @Override
    public @NonNull Crc32cLengthKnown hash(Supplier<ByteBuffer> b) {
      return hash(b.get());
    }

    @Override
    public @NonNull Crc32cLengthKnown hash(ByteBuffer b) {
      int remaining = b.remaining();
      return Crc32cValue.of(Hashing.crc32c().hashBytes(b).asInt(), remaining);
    }

    @SuppressWarnings({"UnstableApiUsage"})
    @Override
    public @NonNull Crc32cLengthKnown hash(ByteString byteString) {
      List<ByteBuffer> buffers = byteString.asReadOnlyByteBufferList();
      com.google.common.hash.Hasher crc32c = Hashing.crc32c().newHasher();
      for (ByteBuffer b : buffers) {
        crc32c.putBytes(b);
      }
      return Crc32cValue.of(crc32c.hash().asInt(), byteString.size());
    }

    @Override
    public void validate(Crc32cValue<?> expected, ByteString byteString)
        throws ChecksumMismatchException {
      Crc32cLengthKnown actual = hash(byteString);
      if (!actual.eqValue(expected)) {
        throw new ChecksumMismatchException(expected, actual);
      }
    }

    @Override
    public void validate(Crc32cValue<?> expected, Supplier<ByteBuffer> b)
        throws ChecksumMismatchException {
      @NonNull Crc32cLengthKnown actual = hash(b);
      if (!actual.eqValue(expected)) {
        throw new ChecksumMismatchException(expected, actual);
      }
    }

    @Override
    public void validateUnchecked(Crc32cValue<?> expected, ByteString byteString)
        throws UncheckedChecksumMismatchException {
      Crc32cLengthKnown actual = hash(byteString);
      if (!actual.eqValue(expected)) {
        throw new UncheckedChecksumMismatchException(expected, actual);
      }
    }

    @SuppressWarnings("unchecked")
    @Override
    public <C extends Crc32cValue<?>> @Nullable C nullSafeConcat(
        @Nullable C r1, @Nullable Crc32cLengthKnown r2) {
      if (r1 == null) {
        return null;
      } else if (r2 == null) {
        return r1;
      } else {
        return (C) r1.concat(r2);
      }
    }

    @Override
    public @NonNull Crc32cLengthKnown initialValue() {
      return Crc32cValue.zero();
    }
  }

  final class ChecksumMismatchException extends IOException {
    private final Crc32cValue<?> expected;
    private final Crc32cLengthKnown actual;

    private ChecksumMismatchException(Crc32cValue<?> expected, Crc32cLengthKnown actual) {
      super(
          String.format(
              Locale.US,
              "Mismatch checksum value. Expected %s actual %s",
              expected.debugString(),
              actual.debugString()));
      this.expected = expected;
      this.actual = actual;
    }

    Crc32cValue<?> getExpected() {
      return expected;
    }

    Crc32cValue<?> getActual() {
      return actual;
    }
  }

  final class UncheckedChecksumMismatchException extends DataLossException {
    private static final GrpcStatusCode STATUS_CODE = GrpcStatusCode.of(Code.DATA_LOSS);
    private final Crc32cValue<?> expected;
    private final Crc32cLengthKnown actual;

    private UncheckedChecksumMismatchException(Crc32cValue<?> expected, Crc32cLengthKnown actual) {
      super(
          String.format(
              "Mismatch checksum value. Expected %s actual %s",
              expected.debugString(), actual.debugString()),
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
}
