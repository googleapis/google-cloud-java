/*
 * Copyright 2018 Google LLC
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

package com.google.cloud.batchingexperimental;

import static com.google.common.truth.Truth.assertThat;

import org.junit.Test;

public class RequestAccumulatorTest {
  @Test
  public void testCount() {
    RequestAccumulator<String, Void> acc = new RequestAccumulator<>(2, Long.MAX_VALUE);
    assertThat(acc.hasBatch()).isFalse();

    acc.add("a", 1, null);
    assertThat(acc.hasBatch()).isFalse();

    acc.add("b", 1, null);
    assertThat(acc.hasBatch()).isTrue();
    assertThat(acc.batch()).containsExactly("a", "b");
    assertThat(acc.bytes()).isEqualTo(2);

    acc.next();
    assertThat(acc.hasBatch()).isFalse();

    acc.add("c", 1, null);
    assertThat(acc.hasBatch()).isFalse();

    acc.add("d", 1, null);
    assertThat(acc.hasBatch()).isTrue();
    assertThat(acc.batch()).containsExactly("c", "d");
    assertThat(acc.bytes()).isEqualTo(2);

    acc.next();
    assertThat(acc.hasBatch()).isFalse();
  }

  @Test
  public void testSize() {
    RequestAccumulator<String, Void> acc = new RequestAccumulator<>(Integer.MAX_VALUE, 3);
    assertThat(acc.hasBatch()).isFalse();

    acc.add("a", 1, null);
    assertThat(acc.hasBatch()).isFalse();

    acc.add("bc", 2, null);
    assertThat(acc.hasBatch()).isTrue();
    assertThat(acc.batch()).containsExactly("a", "bc");
    assertThat(acc.bytes()).isEqualTo(3);

    acc.next();
    assertThat(acc.hasBatch()).isFalse();

    acc.add("de", 2, null);
    assertThat(acc.hasBatch()).isFalse();

    acc.add("fg", 2, null);
    assertThat(acc.hasBatch()).isTrue();
    assertThat(acc.batch()).containsExactly("de", "fg");
    assertThat(acc.bytes()).isEqualTo(4);

    acc.next();
    assertThat(acc.hasBatch()).isFalse();
  }

  @Test
  public void testOversizeAlone() {
    RequestAccumulator<String, Void> acc = new RequestAccumulator<>(Integer.MAX_VALUE, 2);
    acc.add("abc", 3, null);
    assertThat(acc.hasBatch()).isTrue();
    assertThat(acc.batch()).containsExactly("abc");
    assertThat(acc.bytes()).isEqualTo(3);
  }

  @Test
  public void testOversize() {
    RequestAccumulator<String, Void> acc = new RequestAccumulator<>(Integer.MAX_VALUE, 2);
    acc.add("a", 1, null);
    assertThat(acc.hasBatch()).isFalse();

    acc.add("xyz", 3, null);
    assertThat(acc.hasBatch()).isTrue();
    assertThat(acc.batch()).containsExactly("a");
    assertThat(acc.bytes()).isEqualTo(1);

    acc.next();
    assertThat(acc.hasBatch()).isTrue();
    assertThat(acc.batch()).containsExactly("xyz");
    assertThat(acc.bytes()).isEqualTo(3);

    acc.next();
    assertThat(acc.hasBatch()).isFalse();
  }

  @Test(expected = IllegalStateException.class)
  public void testOverflow() {
    RequestAccumulator<String, Void> acc = new RequestAccumulator<>(1, Long.MAX_VALUE);
    acc.add("a", 1, null);
    assertThat(acc.hasBatch()).isTrue();
    acc.add("b", 1, null);
  }
}
