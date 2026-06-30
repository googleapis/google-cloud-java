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

import org.checkerframework.checker.nullness.qual.Nullable;

/**
 * Abstraction utilities for converting between two different types.
 *
 * <p>Primarily targeted at encapsulating the logic for conversion from our model classes and the
 * respective transport specific models.
 */
final class Conversions {

  private Conversions() {}

  /** Entry point to the registry of Codecs for conversions with the JSON Api model */
  static JsonConversions json() {
    return JsonConversions.INSTANCE;
  }

  /** Entry point to the registry of Codecs for conversions with the gRPC Api model */
  static GrpcConversions grpc() {
    return GrpcConversions.INSTANCE;
  }

  /**
   * Abstraction representing a conversion to a different model type.
   *
   * <p>This class is the inverse of {@link Decoder}
   *
   * <p>A symmetric {@link Encoder} {@link Decoder} pair can make a {@link Codec}
   *
   * @param <From>
   * @param <To>
   * @see Decoder
   * @see Codec
   */
  @FunctionalInterface
  interface Encoder<From, To> {
    To encode(From f);
  }

  /**
   * Abstraction representing a conversion from a different model type.
   *
   * <p>This class is the inverse of {@link Encoder}
   *
   * <p>A symmetric {@link Encoder} {@link Decoder} pair can make a {@link Codec}
   *
   * @param <From>
   * @param <To>
   * @see Encoder
   * @see Codec
   */
  @FunctionalInterface
  interface Decoder<From, To> {
    To decode(From f);

    default <R> Decoder<From, R> andThen(Decoder<To, R> d) {
      return f -> d.decode(this.decode(f));
    }

    default <In> Decoder<In, To> compose(Decoder<In, From> before) {
      return in -> this.decode(before.decode(in));
    }

    static <X> Decoder<X, X> identity() {
      return (x) -> x;
    }
  }

  interface Codec<A, B> extends Encoder<A, B>, Decoder<B, A> {
    static <X, Y> Codec<X, Y> of(Encoder<X, Y> e, Decoder<Y, X> d) {
      return new SimpleCodec<>(e, d);
    }

    default <R> Codec<A, R> andThen(Codec<B, R> c) {
      Codec<A, B> self = this;
      return new Codec<A, R>() {
        @Override
        public A decode(R f) {
          return self.decode(c.decode(f));
        }

        @Override
        public R encode(A f) {
          return c.encode(self.encode(f));
        }
      };
    }

    /**
     * Create a new Codec which guards calling each method with a null check.
     *
     * <p>If the values provided to either {@link #decode(Object)} or {@link #encode(Object)} is
     * null, null will be returned.
     */
    default Codec<@Nullable A, @Nullable B> nullable() {
      Codec<A, B> self = this;
      return new Codec<A, B>() {
        @Override
        public A decode(B f) {
          return f == null ? null : self.decode(f);
        }

        @Override
        public B encode(A f) {
          return f == null ? null : self.encode(f);
        }
      };
    }
  }

  /**
   * Internal implementation detail, not to be opened if the containing class and interfaces are
   * ever opened up for access.
   */
  private static final class SimpleCodec<A, B> implements Codec<A, B> {
    private final Encoder<A, B> e;
    private final Decoder<B, A> d;

    private SimpleCodec(Encoder<A, B> e, Decoder<B, A> d) {
      this.e = e;
      this.d = d;
    }

    @Override
    public B encode(A f) {
      return e.encode(f);
    }

    @Override
    public A decode(B f) {
      return d.decode(f);
    }
  }
}
