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

package com.google.cloud.storage.it;

import static com.google.common.truth.Truth.assertThat;
import static org.junit.Assume.assumeTrue;

import java.util.List;
import java.util.function.Function;

final class ReadMaskTestUtils {

  static final class Args<F, T> {
    private final F field;
    private final LazyAssertion<T> assertion;

    Args(F field, LazyAssertion<T> assertion) {
      this.field = field;
      this.assertion = assertion;
    }

    F getField() {
      return field;
    }

    LazyAssertion<T> getAssertion() {
      return assertion;
    }

    @Override
    public String toString() {
      return field.toString();
    }
  }

  @FunctionalInterface
  interface LazyAssertion<T> {
    void validate(T jsonT, T grpcT) throws AssertionError;

    default LazyAssertion<List<T>> pairwiseList() {
      LazyAssertion<T> self = this;
      return (jsonTs, grpcTs) -> {
        final int length = Math.min(jsonTs.size(), grpcTs.size());
        int idx = 0;
        for (; idx < length; idx++) {
          T jT = jsonTs.get(idx);
          T gT = grpcTs.get(idx);
          self.validate(jT, gT);
        }

        assertThat(idx).isEqualTo(jsonTs.size());
        assertThat(idx).isEqualTo(grpcTs.size());

        assertThat(jsonTs.size()).isEqualTo(length);
        assertThat(grpcTs.size()).isEqualTo(length);
      };
    }

    static <X> LazyAssertion<X> equal() {
      return (a, g) -> assertThat(g).isEqualTo(a);
    }

    static <X> LazyAssertion<X> skip(String message) {
      return (a, g) -> assumeTrue(message, false);
    }

    static <X, F> LazyAssertion<X> apiaryNullGrpcDefault(F def, Function<X, F> extractor) {
      return (jsonT, grpcT) -> {
        assertThat(extractor.apply(jsonT)).isNull();
        assertThat(extractor.apply(grpcT)).isEqualTo(def);
      };
    }
  }
}
