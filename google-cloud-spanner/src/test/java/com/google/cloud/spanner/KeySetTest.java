/*
 * Copyright 2017 Google Inc. All Rights Reserved.
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

package com.google.cloud.spanner;

import static com.google.common.truth.Truth.assertThat;

import com.google.cloud.ByteArray;
import com.google.common.testing.EqualsTester;
import org.hamcrest.MatcherAssert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;

/** Unit tests for {@link com.google.cloud.spanner.KeySet}. */
@RunWith(JUnit4.class)
public class KeySetTest {

  @Test
  public void singleKey() {
    KeySet set = KeySet.singleKey(Key.of("a", "b", "c"));
    assertThat(set.isAll()).isFalse();
    assertThat(set.getKeys()).containsExactly(Key.of("a", "b", "c"));
    assertThat(set.getRanges()).isEmpty();
  }

  @Test
  public void range() {
    KeySet set = KeySet.range(KeyRange.closedOpen(Key.of("a"), Key.of("b")));
    assertThat(set.isAll()).isFalse();
    assertThat(set.getKeys()).isEmpty();
    assertThat(set.getRanges()).containsExactly(KeyRange.closedOpen(Key.of("a"), Key.of("b")));
  }

  @Test
  public void prefixRange() {
    KeySet set = KeySet.prefixRange(Key.of("a", "b"));
    assertThat(set.isAll()).isFalse();
    assertThat(set.getKeys()).isEmpty();
    assertThat(set.getRanges()).containsExactly(KeyRange.prefix(Key.of("a", "b")));
  }

  @Test
  public void all() {
    KeySet set = KeySet.all();
    assertThat(set.isAll()).isTrue();
    assertThat(set.getKeys()).isEmpty();
    assertThat(set.getRanges()).isEmpty();
  }

  @Test
  public void builder() {
    KeySet set =
        KeySet.newBuilder()
            .addKey(Key.of("k1"))
            .addKey(Key.of("k2"))
            .addRange(KeyRange.closedOpen(Key.of("r1"), Key.of("rr1")))
            .addRange(KeyRange.closedOpen(Key.of("r2"), Key.of("rr2")))
            .build();
    assertThat(set.isAll()).isFalse();
    // Order isn't strictly important to the API, but it's helpful to preserve it.
    assertThat(set.getKeys()).containsExactly(Key.of("k1"), Key.of("k2")).inOrder();
    assertThat(set.getRanges())
        .containsExactly(
            KeyRange.closedOpen(Key.of("r1"), Key.of("rr1")),
            KeyRange.closedOpen(Key.of("r2"), Key.of("rr2")))
        .inOrder();
    assertThat(set.toString()).isEqualTo("{[k1],[k2],[[r1],[rr1]),[[r2],[rr2])}");
  }

  @Test
  public void toBuilder() {
    KeySet set = KeySet.singleKey(Key.of(1)).toBuilder().addKey(Key.of(2)).build();
    assertThat(set.isAll()).isFalse();
    assertThat(set.getKeys()).containsExactly(Key.of(1), Key.of(2)).inOrder();
    assertThat(set.getRanges()).isEmpty();

    set =
        KeySet.range(KeyRange.closedOpen(Key.of("a"), Key.of("b")))
            .toBuilder()
            .addRange(KeyRange.closedOpen(Key.of("c"), Key.of("d")))
            .build();
    assertThat(set.isAll()).isFalse();
    assertThat(set.getKeys()).isEmpty();
    assertThat(set.getRanges())
        .containsExactly(
            KeyRange.closedOpen(Key.of("a"), Key.of("b")),
            KeyRange.closedOpen(Key.of("c"), Key.of("d")))
        .inOrder();

    set = KeySet.all().toBuilder().addKey(Key.of(1)).build();
    assertThat(set.isAll()).isTrue();
    assertThat(set.getKeys()).containsExactly(Key.of(1));
    assertThat(set.getRanges()).isEmpty();
  }

  @Test
  public void testToString() {
    assertThat(KeySet.all().toString()).isEqualTo("{<all>}");
    assertThat(KeySet.singleKey(Key.of("x")).toString()).isEqualTo("{[x]}");
    assertThat(KeySet.range(KeyRange.closedOpen(Key.of("a"), Key.of("z"))).toString())
        .isEqualTo("{[[a],[z])}");
  }

  @Test
  public void equalsAndHashCode() {
    EqualsTester tester = new EqualsTester();
    tester.addEqualityGroup(KeySet.newBuilder().build());
    tester.addEqualityGroup(KeySet.all(), KeySet.newBuilder().setAll().build());
    tester.addEqualityGroup(
        KeySet.singleKey(Key.of("a")), KeySet.newBuilder().addKey(Key.of("a")).build());
    tester.addEqualityGroup(
        KeySet.range(KeyRange.closedOpen(Key.of("a"), Key.of("b"))),
        KeySet.newBuilder().addRange(KeyRange.closedOpen(Key.of("a"), Key.of("b"))).build());
    tester.addEqualityGroup(KeySet.newBuilder().addKey(Key.of(1)).addKey(Key.of(2)).build());
    // We currently consider order, although this doesn't affect visible results.
    tester.addEqualityGroup(KeySet.newBuilder().addKey(Key.of(2)).addKey(Key.of(1)).build());
    tester.addEqualityGroup(KeySet.newBuilder().setAll().addKey(Key.of("a")).build());
    tester.addEqualityGroup(
        KeySet.newBuilder()
            .addKey(Key.of("a"))
            .addRange(KeyRange.closedOpen(Key.of("a"), Key.of("b")))
            .build());
    tester.testEquals();
  }

  @Test
  public void serializationEmpty() {
    KeySet keySet = KeySet.singleKey(Key.of());
    checkProto(keySet, "keys {}");
  }

  @Test
  public void serializationSingleKeyBool() {
    KeySet keySet = KeySet.singleKey(Key.of(true));
    checkProto(keySet, "keys { values { bool_value: true } }");
  }

  @Test
  public void serializationSingleKeyInt64() {
    KeySet keySet = KeySet.singleKey(Key.of(1234L));
    checkProto(keySet, "keys { values { string_value: '1234' } }");
  }

  @Test
  public void serializationSingleKeyFloat64() {
    KeySet keySet = KeySet.singleKey(Key.of(2.0));
    checkProto(keySet, "keys { values { number_value: 2.0 } }");
  }

  @Test
  public void serializationSingleKeyString() {
    KeySet keySet = KeySet.singleKey(Key.of("abc"));
    checkProto(keySet, "keys { values { string_value: 'abc' } }");
  }

  @Test
  public void serializationSingleKeyBytes() {
    KeySet keySet = KeySet.singleKey(Key.of(ByteArray.copyFrom(new byte[] {'a'})));
    checkProto(keySet, "keys { values { string_value: 'YQ==' } }");
  }

  @Test
  public void serializationSingleKeyNull() {
    KeySet keySet = KeySet.singleKey(Key.of((String) null));
    checkProto(keySet, "keys { values { null_value: NULL_VALUE } }");
  }

  @Test
  public void serializationSingleKeyMultiPart() {
    KeySet keySet = KeySet.singleKey(Key.of("a", false));
    checkProto(keySet, "keys { values { string_value: 'a' } values { bool_value: false } }");
  }

  @Test
  public void serializationSingleRangeClosedOpen() {
    KeySet keySet = KeySet.range(KeyRange.closedOpen(Key.of("a"), Key.of("z")));
    checkProto(
        keySet,
        "ranges { start_closed { values { string_value: 'a' } }"
            + "  end_open { values { string_value: 'z' } } }");
  }

  @Test
  public void serializationSingleRangeClosedClosed() {
    KeySet keySet = KeySet.range(KeyRange.closedClosed(Key.of("a"), Key.of("z")));
    checkProto(
        keySet,
        "ranges { start_closed { values { string_value: 'a' } }"
            + " end_closed { values { string_value: 'z' } } }");
  }

  @Test
  public void serializationSingleRangeOpenOpen() {
    KeySet keySet = KeySet.range(KeyRange.openOpen(Key.of("a"), Key.of("z")));
    checkProto(
        keySet,
        "ranges { start_open { values { string_value: 'a' } }"
            + " end_open { values { string_value: 'z' } } }");
  }

  @Test
  public void serializationSingleRangeOpenClosed() {
    KeySet keySet = KeySet.range(KeyRange.openClosed(Key.of("a"), Key.of("z")));
    checkProto(
        keySet,
        "ranges { start_open { values { string_value: 'a' } }"
            + " end_closed { values { string_value: 'z' } } }");
  }

  @Test
  public void serializationAll() {
    KeySet keySet = KeySet.all();
    checkProto(keySet, "all: true");
  }

  @Test
  public void serializationMulti() {
    KeySet keySet =
        KeySet.newBuilder()
            .addKey(Key.of("d", 1))
            .addRange(KeyRange.closedOpen(Key.of("m"), Key.of("p")))
            .addKey(Key.of("a", 1))
            .addRange(KeyRange.closedClosed(Key.of("a"), Key.of("d")))
            .build();
    checkProto(
        keySet,
        "keys { values { string_value: 'd' } values { string_value: '1' } }"
            + " keys { values { string_value: 'a' } values { string_value:'1' } }"
            + " ranges { start_closed { values { string_value: 'm' } }"
            + "          end_open { values { string_value: 'p' } } }"
            + " ranges { start_closed { values { string_value: 'a' } }"
            + "          end_closed { values { string_value: 'd' } } }");
  }

  @Test
  public void serializationMultiWithAll() {
    KeySet keySet =
        KeySet.all()
            .toBuilder()
            .addKey(Key.of("a", 1))
            .addRange(KeyRange.closedOpen(Key.of("m"), Key.of("p")))
            .build();
    checkProto(
        keySet,
        "keys { values { string_value: 'a' } values { string_value: '1' } }"
            + " ranges { start_closed { values { string_value: 'm' } }"
            + "          end_open { values { string_value: 'p' } } }"
            + " all:true");
  }

  private static void checkProto(KeySet keySet, String proto) {
    com.google.spanner.v1.KeySet.Builder builder = com.google.spanner.v1.KeySet.newBuilder();
    keySet.appendToProto(builder);
    MatcherAssert.assertThat(
        builder.build(), SpannerMatchers.matchesProto(com.google.spanner.v1.KeySet.class, proto));
  }
}
