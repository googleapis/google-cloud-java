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

import java.nio.ByteBuffer;
import java.util.Locale;
import java.util.Objects;

abstract class Crc32cValue<Res extends Crc32cValue<Res>> {

  private Crc32cValue() {}

  public abstract int getValue();

  /**
   * Concatenate {@code other} to {@code this} value.
   *
   * <p>The concat operation satisfies the Left <a target="_blank"
   * href="https://en.wikipedia.org/wiki/Distributive_property">Distributive property</a>.
   *
   * <p>This means, given the following instances:
   *
   * <pre>{@code
   * var A = Crc32cValue.of(a);
   * var B = Crc32cValue.of(b, 4);
   * var C = Crc32cValue.of(c, 4);
   * var D = Crc32cValue.of(d, 4);
   * }</pre>
   *
   * Each of the following lines will all produce the same value:
   *
   * <pre>{@code
   * var ABCD1 = A.concat(B).concat(C).concat(D);
   * var ABCD2 = A.concat(B.concat(C.concat(D)));
   * var ABCD3 = A.concat(B.concat(C)).concat(D);
   * }</pre>
   */
  public abstract Res concat(Crc32cLengthKnown other);

  public abstract String debugString();

  public boolean eqValue(Crc32cValue<?> other) {
    return this.getValue() == other.getValue();
  }

  static Crc32cLengthKnown zero() {
    return Crc32cLengthKnown.ZERO;
  }

  static Crc32cLengthUnknown of(int value) {
    return new Crc32cLengthUnknown(value);
  }

  static Crc32cLengthKnown of(int value, long length) {
    return new Crc32cLengthKnown(value, length);
  }

  static String fmtCrc32cValue(int value1) {
    return String.format(Locale.US, "crc32c{0x%08x}", value1);
  }

  static final class Crc32cLengthUnknown extends Crc32cValue<Crc32cLengthUnknown> {
    private final int value;

    public Crc32cLengthUnknown(int value) {
      this.value = value;
    }

    public int getValue() {
      return value;
    }

    @Override
    public Crc32cLengthUnknown concat(Crc32cLengthKnown other) {
      if (other == Crc32cLengthKnown.ZERO) {
        return this;
      }
      int combined = Crc32cUtility.concatCrc32c(value, other.value, other.length);
      return new Crc32cLengthUnknown(combined);
    }

    @Override
    public String toString() {
      return Crc32cLengthKnown.fmtCrc32cValue(value);
    }

    @Override
    public String debugString() {
      return toString();
    }

    public Crc32cLengthKnown withLength(long length) {
      return new Crc32cLengthKnown(value, length);
    }

    @Override
    public boolean equals(Object o) {
      if (this == o) {
        return true;
      }
      if (!(o instanceof Crc32cLengthUnknown)) {
        return false;
      }
      Crc32cLengthUnknown that = (Crc32cLengthUnknown) o;
      return value == that.value;
    }

    @Override
    public int hashCode() {
      return Objects.hash(value);
    }
  }

  static final class Crc32cLengthKnown extends Crc32cValue<Crc32cLengthKnown> {
    private static final Crc32cLengthKnown ZERO = Hasher.enabled().hash(ByteBuffer.allocate(0));
    private final int value;
    private final long length;

    private Crc32cLengthKnown(int value, long length) {
      this.value = value;
      this.length = length;
    }

    @Override
    public int getValue() {
      return value;
    }

    public long getLength() {
      return length;
    }

    @Override
    public Crc32cLengthKnown concat(Crc32cLengthKnown other) {
      if (other == ZERO) {
        return this;
      } else if (this == ZERO) {
        return other;
      }
      int combined = Crc32cUtility.concatCrc32c(value, other.value, other.length);
      return new Crc32cLengthKnown(combined, length + other.length);
    }

    @Override
    public String toString() {
      return String.format(Locale.US, "crc32c{0x%08x (length = %d)}", value, length);
    }

    @Override
    public String debugString() {
      return fmtCrc32cValue(value);
    }

    @Override
    public boolean equals(Object o) {
      if (this == o) {
        return true;
      }
      if (!(o instanceof Crc32cLengthKnown)) {
        return false;
      }
      Crc32cLengthKnown that = (Crc32cLengthKnown) o;
      return value == that.value && length == that.length;
    }

    @Override
    public int hashCode() {
      return Objects.hash(value, length);
    }
  }
}
