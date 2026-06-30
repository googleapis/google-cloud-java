/*
 * Copyright 2023 Google LLC
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

import static com.google.common.base.Preconditions.checkArgument;

import com.google.common.base.MoreObjects;
import java.util.Locale;
import java.util.Objects;
import java.util.function.UnaryOperator;

abstract class HttpContentRange {

  private final boolean finalizing;

  private HttpContentRange(boolean finalizing) {
    this.finalizing = finalizing;
  }

  public abstract String getHeaderValue();

  public abstract boolean endOffsetEquals(long e);

  public boolean isFinalizing() {
    return finalizing;
  }

  static Total of(ByteRangeSpec spec, long size) {
    checkArgument(size >= 0, "size must be >= 0");
    checkArgument(size >= spec.endOffsetInclusive(), "size must be >= end");
    return new Total(spec, size);
  }

  static Incomplete of(ByteRangeSpec spec) {
    return new Incomplete(spec);
  }

  static Size of(long size) {
    checkArgument(size >= 0, "size must be >= 0");
    return new Size(size);
  }

  static Query query() {
    return Query.INSTANCE;
  }

  static HttpContentRange parse(String string) {
    if ("bytes */*".equals(string)) {
      return HttpContentRange.query();
    } else if (string.startsWith("bytes */")) {
      return HttpContentRange.of(Long.parseLong(string.substring(8)));
    } else {
      int idxDash = string.indexOf('-');
      int idxSlash = string.indexOf('/');

      String beginS = string.substring(6, idxDash);
      String endS = string.substring(idxDash + 1, idxSlash);
      long begin = Long.parseLong(beginS);
      long end = Long.parseLong(endS);
      if (string.endsWith("/*")) {
        return HttpContentRange.of(ByteRangeSpec.explicitClosed(begin, end));
      } else {
        String sizeS = string.substring(idxSlash + 1);
        long size = Long.parseLong(sizeS);
        return HttpContentRange.of(ByteRangeSpec.explicitClosed(begin, end), size);
      }
    }
  }

  static final class Incomplete extends HttpContentRange implements HasRange<Incomplete> {

    private final ByteRangeSpec spec;

    private Incomplete(ByteRangeSpec spec) {
      super(false);
      this.spec = spec;
    }

    @Override
    public String getHeaderValue() {
      return String.format(
          Locale.US, "bytes %d-%d/*", spec.beginOffset(), spec.endOffsetInclusive());
    }

    @Override
    public boolean endOffsetEquals(long e) {
      return e == spec.endOffset();
    }

    @Override
    public ByteRangeSpec range() {
      return spec;
    }

    @Override
    public Incomplete map(UnaryOperator<ByteRangeSpec> f) {
      return new Incomplete(f.apply(spec));
    }

    @Override
    public boolean equals(Object o) {
      if (this == o) {
        return true;
      }
      if (!(o instanceof Incomplete)) {
        return false;
      }
      Incomplete that = (Incomplete) o;
      return Objects.equals(spec, that.spec);
    }

    @Override
    public int hashCode() {
      return Objects.hash(spec);
    }

    @Override
    public String toString() {
      return MoreObjects.toStringHelper(this).add("spec", spec).toString();
    }
  }

  static final class Total extends HttpContentRange implements HasRange<Total>, HasSize {

    private final ByteRangeSpec spec;
    private final long size;

    private Total(ByteRangeSpec spec, long size) {
      super(true);
      this.spec = spec;
      this.size = size;
    }

    @Override
    public String getHeaderValue() {
      return String.format(
          Locale.US, "bytes %d-%d/%d", spec.beginOffset(), spec.endOffsetInclusive(), size);
    }

    @Override
    public boolean endOffsetEquals(long e) {
      return e == spec.endOffset();
    }

    @Override
    public long getSize() {
      return size;
    }

    @Override
    public ByteRangeSpec range() {
      return spec;
    }

    @Override
    public Total map(UnaryOperator<ByteRangeSpec> f) {
      return new Total(f.apply(spec), size);
    }

    @Override
    public boolean equals(Object o) {
      if (this == o) {
        return true;
      }
      if (!(o instanceof Total)) {
        return false;
      }
      Total total = (Total) o;
      return size == total.size && Objects.equals(spec, total.spec);
    }

    @Override
    public int hashCode() {
      return Objects.hash(spec, size);
    }

    @Override
    public String toString() {
      return MoreObjects.toStringHelper(this).add("spec", spec).add("size", size).toString();
    }
  }

  static final class Size extends HttpContentRange implements HasSize {

    private final long size;

    private Size(long size) {
      super(true);
      this.size = size;
    }

    @Override
    public String getHeaderValue() {
      return String.format(Locale.US, "bytes */%d", size);
    }

    @Override
    public boolean endOffsetEquals(long e) {
      return e == Math.max(0, size - 1);
    }

    @Override
    public long getSize() {
      return size;
    }

    @Override
    public boolean equals(Object o) {
      if (this == o) {
        return true;
      }
      if (!(o instanceof Size)) {
        return false;
      }
      Size size1 = (Size) o;
      return size == size1.size;
    }

    @Override
    public int hashCode() {
      return Objects.hash(size);
    }

    @Override
    public String toString() {
      return MoreObjects.toStringHelper(this).add("size", size).toString();
    }
  }

  static final class Query extends HttpContentRange {

    private static final Query INSTANCE = new Query();

    private Query() {
      super(false);
    }

    @Override
    public boolean endOffsetEquals(long e) {
      return false;
    }

    @Override
    public String getHeaderValue() {
      return "bytes */*";
    }
  }

  interface HasRange<T extends HttpContentRange> {

    ByteRangeSpec range();

    T map(UnaryOperator<ByteRangeSpec> f);
  }

  interface HasSize {

    long getSize();
  }
}
