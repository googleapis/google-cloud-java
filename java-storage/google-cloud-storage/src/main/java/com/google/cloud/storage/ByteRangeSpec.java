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

import static com.google.api.client.util.Preconditions.checkNotNull;
import static com.google.common.base.Preconditions.checkArgument;

import com.google.api.core.InternalApi;
import com.google.common.base.MoreObjects;
import com.google.common.base.MoreObjects.ToStringHelper;
import com.google.storage.v2.ReadObjectRequest;
import java.io.Serializable;
import java.util.Locale;
import java.util.Objects;
import java.util.function.BiFunction;
import javax.annotation.concurrent.Immutable;
import javax.annotation.concurrent.ThreadSafe;
import org.checkerframework.checker.nullness.qual.NonNull;
import org.checkerframework.checker.nullness.qual.Nullable;

/**
 * Typeful sealed class hierarchy for representing an <a target="_blank"
 * href="https://developer.mozilla.org/en-US/docs/Web/HTTP/Range_requests#requesting_a_specific_range_from_a_server">HTTP
 * Range Header</a> There are certain subtleties when building these header values depending on
 * whether explicit boundaries or relative lengths are used. This class encapsulates the edge cases
 * as well as the concept of an effective infinity value for end of range.
 *
 * <p>This class does not currently support negative offsets, i.e. start from end of content.
 */
@InternalApi
@ThreadSafe
abstract class ByteRangeSpec implements Serializable {

  public static final long EFFECTIVE_INFINITY = Long.MAX_VALUE;

  @Nullable private volatile String httpRangeHeader;

  private ByteRangeSpec() {}

  abstract long beginOffset();

  abstract long endOffset() throws ArithmeticException;

  abstract long endOffsetInclusive() throws ArithmeticException;

  abstract long length() throws ArithmeticException;

  // TODO: add validation to this if it ever becomes public
  abstract ByteRangeSpec withNewBeginOffset(long beginOffset);

  abstract ByteRangeSpec withShiftBeginOffset(long beginOffsetIncrement) throws ArithmeticException;

  abstract ByteRangeSpec withNewEndOffset(long endOffsetExclusive);

  abstract ByteRangeSpec withNewEndOffsetClosed(long endOffsetInclusive);

  abstract ByteRangeSpec withNewRelativeLength(long relativeLength);

  /**
   * If a range has no effectively declared beginning and end the string returned here will be null.
   */
  @Nullable
  final String getHttpRangeHeader() throws ArithmeticException {
    if (httpRangeHeader == null) {
      synchronized (this) {
        if (httpRangeHeader == null) {
          httpRangeHeader = fmtAsHttpRangeHeader();
        }
      }
    }
    return httpRangeHeader;
  }

  abstract ReadObjectRequest.Builder seekReadObjectRequest(ReadObjectRequest.Builder b);

  @Nullable
  protected abstract String fmtAsHttpRangeHeader() throws ArithmeticException;

  @Override
  public int hashCode() {
    return Objects.hash(getHttpRangeHeader());
  }

  @Override
  public boolean equals(Object o) {
    if (o instanceof ByteRangeSpec) {
      ByteRangeSpec that = (ByteRangeSpec) o;
      return Objects.equals(this.getHttpRangeHeader(), that.getHttpRangeHeader());
    }
    return false;
  }

  @Override
  public String toString() {
    return append(MoreObjects.toStringHelper("ByteRangeSpec")).toString();
  }

  protected abstract MoreObjects.ToStringHelper append(MoreObjects.ToStringHelper tsh);

  static ByteRangeSpec nullRange() {
    return NullByteRangeSpec.INSTANCE;
  }

  static ByteRangeSpec relativeLength(@Nullable Long beginOffset, @Nullable Long length) {
    return create(beginOffset, length, RelativeByteRangeSpec::new);
  }

  static ByteRangeSpec explicit(@Nullable Long beginOffset, @Nullable Long endOffsetExclusive) {
    return create(beginOffset, endOffsetExclusive, LeftClosedRightOpenByteRangeSpec::new);
  }

  static ByteRangeSpec explicitClosed(
      @Nullable Long beginOffset, @Nullable Long endOffsetInclusive) {
    return create(beginOffset, endOffsetInclusive, LeftClosedRightClosedByteRangeSpec::new);
  }

  static ByteRangeSpec parse(String string) {
    checkNotNull(string, "Range header is null");
    checkArgument(string.startsWith("bytes="), "malformed Range header value: %s", string);

    int i = string.indexOf('-');
    String minS = string.substring(6, i);
    String maxS = string.substring(i + 1);

    long min = Long.parseLong(minS);
    long max = Long.parseLong(maxS);

    return explicitClosed(min, max);
  }

  private static ByteRangeSpec create(
      @Nullable Long beginOffset,
      @Nullable Long length,
      BiFunction<@NonNull Long, @NonNull Long, ByteRangeSpec> f) {
    if (beginOffset == null && length == null) {
      return nullRange();
    } else if (beginOffset != null && length != null) {
      if (beginOffset == 0 && length == EFFECTIVE_INFINITY) {
        return nullRange();
      } else if (length == EFFECTIVE_INFINITY) {
        return new LeftClosedByteRangeSpec(beginOffset);
      }
      return f.apply(beginOffset, length);
    } else if (beginOffset == null /* && length != null*/) {
      if (length == EFFECTIVE_INFINITY) {
        return nullRange();
      }
      return f.apply(0L, length);
    } else {
      return new LeftClosedByteRangeSpec(beginOffset);
    }
  }

  @Immutable
  private static final class RelativeByteRangeSpec extends ByteRangeSpec {
    private static final long serialVersionUID = -3910856417374881377L;
    private final long beginOffset;
    private final long length;

    private RelativeByteRangeSpec(long beginOffset, long length) {
      this.beginOffset = beginOffset;
      this.length = length;
    }

    @Override
    long beginOffset() {
      return beginOffset;
    }

    @Override
    long endOffset() throws ArithmeticException {
      return Math.addExact(beginOffset, length);
    }

    @Override
    long endOffsetInclusive() throws ArithmeticException {
      return Math.addExact(beginOffset, length) - 1;
    }

    @Override
    long length() throws ArithmeticException {
      return length;
    }

    @Override
    ByteRangeSpec withNewBeginOffset(long beginOffset) {
      if (beginOffset != this.beginOffset) {
        return new RelativeByteRangeSpec(beginOffset, length);
      } else {
        return this;
      }
    }

    @Override
    ByteRangeSpec withShiftBeginOffset(long beginOffsetIncrement) throws ArithmeticException {
      if (beginOffsetIncrement != 0) {
        return new RelativeByteRangeSpec(Math.addExact(beginOffset, beginOffsetIncrement), length);
      } else {
        return this;
      }
    }

    @Override
    ByteRangeSpec withNewEndOffset(long endOffsetExclusive) {
      return new LeftClosedRightOpenByteRangeSpec(beginOffset, endOffsetExclusive);
    }

    @Override
    ByteRangeSpec withNewEndOffsetClosed(long endOffsetInclusive) {
      return new LeftClosedRightClosedByteRangeSpec(beginOffset, endOffsetInclusive);
    }

    @Override
    ByteRangeSpec withNewRelativeLength(long relativeLength) {
      if (relativeLength != this.length) {
        return new RelativeByteRangeSpec(beginOffset, relativeLength);
      } else {
        return this;
      }
    }

    @Override
    public ReadObjectRequest.Builder seekReadObjectRequest(ReadObjectRequest.Builder b) {
      return b.setReadOffset(beginOffset()).setReadLimit(length());
    }

    @Override
    protected String fmtAsHttpRangeHeader() throws ArithmeticException {
      return String.format(Locale.US, "bytes=%d-%d", beginOffset, endOffsetInclusive());
    }

    @Override
    protected ToStringHelper append(ToStringHelper tsh) {
      return tsh.addValue(String.format(Locale.US, "%d + %d", beginOffset, length));
    }
  }

  @Immutable
  private static final class LeftClosedRightOpenByteRangeSpec extends ByteRangeSpec {
    private static final long serialVersionUID = -2706235472358072141L;
    private final long beginOffset;
    private final long endOffsetExclusive;

    private LeftClosedRightOpenByteRangeSpec(long beginOffset, long endOffsetExclusive) {
      this.beginOffset = beginOffset;
      this.endOffsetExclusive = endOffsetExclusive;
    }

    @Override
    long beginOffset() {
      return beginOffset;
    }

    @Override
    long endOffset() throws ArithmeticException {
      return endOffsetExclusive;
    }

    @Override
    long endOffsetInclusive() throws ArithmeticException {
      return Math.subtractExact(endOffsetExclusive, 1);
    }

    @Override
    long length() throws ArithmeticException {
      return Math.subtractExact(endOffsetExclusive, beginOffset);
    }

    @Override
    ByteRangeSpec withNewBeginOffset(long beginOffset) {
      if (beginOffset != this.beginOffset) {
        return new LeftClosedRightOpenByteRangeSpec(beginOffset, endOffsetExclusive);
      } else {
        return this;
      }
    }

    @Override
    ByteRangeSpec withShiftBeginOffset(long beginOffsetIncrement) throws ArithmeticException {
      if (beginOffsetIncrement != 0) {
        return new LeftClosedRightOpenByteRangeSpec(
            Math.addExact(beginOffset, beginOffsetIncrement), endOffsetExclusive);
      } else {
        return this;
      }
    }

    @Override
    ByteRangeSpec withNewEndOffset(long endOffsetExclusive) {
      if (endOffsetExclusive != this.endOffsetExclusive) {
        return new LeftClosedRightOpenByteRangeSpec(beginOffset, endOffsetExclusive);
      } else {
        return this;
      }
    }

    @Override
    ByteRangeSpec withNewEndOffsetClosed(long endOffsetInclusive) {
      return new LeftClosedRightClosedByteRangeSpec(beginOffset, endOffsetInclusive);
    }

    @Override
    ByteRangeSpec withNewRelativeLength(long relativeLength) {
      return new RelativeByteRangeSpec(beginOffset, relativeLength);
    }

    @Override
    public ReadObjectRequest.Builder seekReadObjectRequest(ReadObjectRequest.Builder b) {
      return b.setReadOffset(beginOffset()).setReadLimit(length());
    }

    @Override
    protected String fmtAsHttpRangeHeader() throws ArithmeticException {
      return String.format(Locale.US, "bytes=%d-%d", beginOffset, endOffsetInclusive());
    }

    @Override
    protected ToStringHelper append(ToStringHelper tsh) {
      return tsh.addValue(String.format(Locale.US, "[%d, %d)", beginOffset, endOffsetExclusive));
    }
  }

  @Immutable
  private static final class LeftClosedRightClosedByteRangeSpec extends ByteRangeSpec {
    private static final long serialVersionUID = -2706235472358072141L;
    private final long beginOffset;
    private final long endOffsetInclusive;

    private LeftClosedRightClosedByteRangeSpec(long beginOffset, long endOffsetInclusive) {
      this.beginOffset = beginOffset;
      this.endOffsetInclusive = endOffsetInclusive;
    }

    @Override
    long beginOffset() {
      return beginOffset;
    }

    @Override
    long endOffset() throws ArithmeticException {
      return Math.addExact(endOffsetInclusive, 1L);
    }

    @Override
    long endOffsetInclusive() throws ArithmeticException {
      return endOffsetInclusive;
    }

    @Override
    long length() throws ArithmeticException {
      return Math.addExact(Math.subtractExact(endOffsetInclusive, beginOffset), 1);
    }

    @Override
    ByteRangeSpec withNewBeginOffset(long beginOffset) {
      if (beginOffset != this.beginOffset) {
        return new LeftClosedRightClosedByteRangeSpec(beginOffset, endOffsetInclusive);
      } else {
        return this;
      }
    }

    @Override
    ByteRangeSpec withShiftBeginOffset(long beginOffsetIncrement) throws ArithmeticException {
      if (beginOffsetIncrement != 0) {
        return new LeftClosedRightClosedByteRangeSpec(
            Math.addExact(beginOffset, beginOffsetIncrement), endOffsetInclusive);
      } else {
        return this;
      }
    }

    @Override
    ByteRangeSpec withNewEndOffset(long endOffsetExclusive) {
      return new LeftClosedRightOpenByteRangeSpec(beginOffset, endOffsetExclusive);
    }

    @Override
    ByteRangeSpec withNewEndOffsetClosed(long endOffsetInclusive) {
      if (endOffsetInclusive != this.endOffsetInclusive) {
        return new LeftClosedRightClosedByteRangeSpec(beginOffset, endOffsetInclusive);
      } else {
        return this;
      }
    }

    @Override
    ByteRangeSpec withNewRelativeLength(long relativeLength) {
      return new RelativeByteRangeSpec(beginOffset, relativeLength);
    }

    @Override
    public ReadObjectRequest.Builder seekReadObjectRequest(ReadObjectRequest.Builder b) {
      return b.setReadOffset(beginOffset()).setReadLimit(length());
    }

    @Override
    protected String fmtAsHttpRangeHeader() throws ArithmeticException {
      return String.format(Locale.US, "bytes=%d-%d", beginOffset, endOffsetInclusive);
    }

    @Override
    protected ToStringHelper append(ToStringHelper tsh) {
      return tsh.addValue(String.format(Locale.US, "[%d, %d]", beginOffset, endOffsetInclusive));
    }
  }

  @Immutable
  private static final class LeftClosedByteRangeSpec extends ByteRangeSpec {
    private static final long serialVersionUID = 4732278479149027012L;
    private final long beginOffset;

    private LeftClosedByteRangeSpec(long beginOffset) {
      this.beginOffset = beginOffset;
    }

    @Override
    long beginOffset() {
      return beginOffset;
    }

    @Override
    long endOffset() throws ArithmeticException {
      return EFFECTIVE_INFINITY;
    }

    @Override
    long endOffsetInclusive() throws ArithmeticException {
      return EFFECTIVE_INFINITY;
    }

    @Override
    long length() throws ArithmeticException {
      return EFFECTIVE_INFINITY;
    }

    @Override
    ByteRangeSpec withNewBeginOffset(long beginOffset) {
      if (beginOffset != this.beginOffset) {
        return new LeftClosedByteRangeSpec(beginOffset);
      } else {
        return this;
      }
    }

    @Override
    ByteRangeSpec withShiftBeginOffset(long beginOffsetIncrement) throws ArithmeticException {
      if (beginOffsetIncrement != 0) {
        return new LeftClosedByteRangeSpec(Math.addExact(beginOffset, beginOffsetIncrement));
      } else {
        return this;
      }
    }

    @Override
    ByteRangeSpec withNewEndOffset(long endOffsetExclusive) {
      return new LeftClosedRightOpenByteRangeSpec(beginOffset, endOffsetExclusive);
    }

    @Override
    ByteRangeSpec withNewEndOffsetClosed(long endOffsetInclusive) {
      return new LeftClosedRightClosedByteRangeSpec(beginOffset, endOffsetInclusive);
    }

    @Override
    ByteRangeSpec withNewRelativeLength(long relativeLength) {
      return new RelativeByteRangeSpec(beginOffset, relativeLength);
    }

    @Override
    public ReadObjectRequest.Builder seekReadObjectRequest(ReadObjectRequest.Builder b) {
      return b.setReadOffset(beginOffset());
    }

    @Override
    protected String fmtAsHttpRangeHeader() throws ArithmeticException {
      if (beginOffset > 0) {
        return String.format(Locale.US, "bytes=%d-", beginOffset);
      } else if (beginOffset < 0) {
        return String.format(Locale.US, "bytes=%d", beginOffset);
      } else {
        return null;
      }
    }

    @Override
    protected ToStringHelper append(ToStringHelper tsh) {
      return tsh.addValue(String.format(Locale.US, "[%d, +INF)", beginOffset));
    }
  }

  @Immutable
  private static final class NullByteRangeSpec extends ByteRangeSpec {
    private static final NullByteRangeSpec INSTANCE = new NullByteRangeSpec();
    private static final long serialVersionUID = 9110512497431639881L;

    @Override
    long beginOffset() {
      return 0;
    }

    @Override
    long endOffset() throws ArithmeticException {
      return EFFECTIVE_INFINITY;
    }

    @Override
    long endOffsetInclusive() throws ArithmeticException {
      return EFFECTIVE_INFINITY;
    }

    @Override
    long length() throws ArithmeticException {
      return EFFECTIVE_INFINITY;
    }

    @Override
    ByteRangeSpec withNewBeginOffset(long beginOffset) {
      if (beginOffset != 0) {
        return new LeftClosedByteRangeSpec(beginOffset);
      } else {
        return this;
      }
    }

    @Override
    ByteRangeSpec withShiftBeginOffset(long beginOffsetIncrement) throws ArithmeticException {
      if (beginOffsetIncrement != 0) {
        return new LeftClosedByteRangeSpec(beginOffsetIncrement);
      } else {
        return this;
      }
    }

    @Override
    ByteRangeSpec withNewEndOffset(long endOffsetExclusive) {
      if (endOffsetExclusive != EFFECTIVE_INFINITY) {
        return new LeftClosedRightOpenByteRangeSpec(0, endOffsetExclusive);
      } else {
        return this;
      }
    }

    @Override
    ByteRangeSpec withNewEndOffsetClosed(long endOffsetInclusive) {
      if (endOffsetInclusive != EFFECTIVE_INFINITY) {
        return new LeftClosedRightClosedByteRangeSpec(0, endOffsetInclusive);
      } else {
        return this;
      }
    }

    @Override
    ByteRangeSpec withNewRelativeLength(long relativeLength) {
      if (relativeLength != EFFECTIVE_INFINITY) {
        return new RelativeByteRangeSpec(0, relativeLength);
      } else {
        return this;
      }
    }

    @Override
    public ReadObjectRequest.Builder seekReadObjectRequest(ReadObjectRequest.Builder b) {
      return b;
    }

    @Override
    protected String fmtAsHttpRangeHeader() throws ArithmeticException {
      return null;
    }

    @Override
    protected ToStringHelper append(ToStringHelper tsh) {
      return tsh.addValue("[0, INF]");
    }

    /** prevent java serialization from using a new instance */
    private Object readResolve() {
      return INSTANCE;
    }
  }
}
