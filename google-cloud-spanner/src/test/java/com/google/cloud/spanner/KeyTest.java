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
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;

/** Unit tests for {@link com.google.cloud.spanner.Key}. */
@RunWith(JUnit4.class)
public class KeyTest {
  @Test
  public void of() {
    Key k = Key.of();
    assertThat(k.size()).isEqualTo(0);
    assertThat(k.getParts()).isEmpty();

    k = Key.of("a", "b", "c");
    assertThat(k.size()).isEqualTo(3);
    assertThat(k.getParts()).containsExactly("a", "b", "c").inOrder();

    k = Key.of("a", null, "c");
    assertThat(k.size()).isEqualTo(3);
    assertThat(k.getParts()).containsExactly("a", null, "c").inOrder();

    // All supported Java types: note coercion to canonical types.
    String timestamp = "2015-09-15T00:00:00Z";
    String date = "2015-09-15";
    k =
        Key.of(
            null,
            true,
            32,
            64L,
            2.0f,
            4.0d,
            "x",
            ByteArray.copyFrom("y"),
            Timestamp.parseTimestamp(timestamp),
            Date.parseDate(date));
    assertThat(k.size()).isEqualTo(10);
    assertThat(k.getParts())
        .containsExactly(
            null,
            Boolean.TRUE,
            32L,
            64L,
            2.0d,
            4.0d,
            "x",
            ByteArray.copyFrom("y"),
            Timestamp.parseTimestamp(timestamp),
            Date.parseDate(date))
        .inOrder();

    // Singleton null key.
    k = Key.of((Object) null);
    assertThat(k.size()).isEqualTo(1);
    assertThat(k.getParts()).contains(null);
  }

  @Test
  public void builder() {
    String timestamp = "2015-09-15T00:00:00Z";
    String date = "2015-09-15";
    Key k =
        Key.newBuilder()
            .append((Boolean) null)
            .append(true)
            .append(32)
            .append(64L)
            .append(2.0f)
            .append(4.0d)
            .append("x")
            .append(ByteArray.copyFrom("y"))
            .append(Timestamp.parseTimestamp(timestamp))
            .append(Date.parseDate(date))
            .build();
    assertThat(k.size()).isEqualTo(10);
    assertThat(k.getParts())
        .containsExactly(
            null,
            Boolean.TRUE,
            32L,
            64L,
            2.0d,
            4.0d,
            "x",
            ByteArray.copyFrom("y"),
            Timestamp.parseTimestamp(timestamp),
            Date.parseDate(date))
        .inOrder();
  }

  @Test
  public void toBuilder() {
    Key k = Key.of(1, 2).toBuilder().append(3).build();
    assertThat(k.size()).isEqualTo(3);
    assertThat(k.getParts()).containsExactly(1L, 2L, 3L).inOrder();
  }

  @Test
  public void testToString() {
    assertThat(Key.of().toString()).isEqualTo("[]");
    assertThat(Key.of(new Object[] {null}).toString()).isEqualTo("[<null>]");
    assertThat(Key.of(true).toString()).isEqualTo("[true]");
    assertThat(Key.of(32).toString()).isEqualTo("[32]");
    assertThat(Key.of(2.0).toString()).isEqualTo("[2.0]");
    assertThat(Key.of("xyz").toString()).isEqualTo("[xyz]");
    assertThat(Key.of(ByteArray.copyFrom("xyz")).toString()).isEqualTo("[xyz]");
    String timestamp = "2015-09-15T00:00:00Z";
    assertThat(Key.of(Timestamp.parseTimestamp(timestamp)).toString())
        .isEqualTo("[" + timestamp + "]");
    String date = "2015-09-15";
    assertThat(Key.of(Date.parseDate(date)).toString()).isEqualTo("[" + date + "]");
    assertThat(Key.of(1, 2, 3).toString()).isEqualTo("[1,2,3]");
  }

  @Test
  public void equalsAndHashCode() {
    EqualsTester tester = new EqualsTester();

    tester.addEqualityGroup(Key.of(), Key.newBuilder().build());

    // All types of null are considered equal.
    tester.addEqualityGroup(
        Key.of((Object) null),
        Key.newBuilder().append((Boolean) null).build(),
        Key.newBuilder().append((Long) null).build(),
        Key.newBuilder().append((Double) null).build(),
        Key.newBuilder().append((String) null).build(),
        Key.newBuilder().append((ByteArray) null).build(),
        Key.newBuilder().append((Timestamp) null).build(),
        Key.newBuilder().append((Date) null).build(),
        Key.newBuilder().appendObject(null).build());

    tester.addEqualityGroup(Key.of(true), Key.newBuilder().append(true).build());
    tester.addEqualityGroup(Key.of(false), Key.newBuilder().append(false).build());
    tester.addEqualityGroup(Key.of(1), Key.of(1L), Key.newBuilder().append(1).build());
    tester.addEqualityGroup(Key.of(2), Key.of(2L), Key.newBuilder().append(2).build());
    tester.addEqualityGroup(Key.of(1, 2));
    tester.addEqualityGroup(Key.of(1.0f), Key.of(1.0d), Key.newBuilder().append(1.0).build());
    tester.addEqualityGroup(Key.of(2.0f), Key.of(2.0d), Key.newBuilder().append(2.0).build());
    tester.addEqualityGroup(Key.of("a"), Key.newBuilder().append("a").build());
    tester.addEqualityGroup(Key.of("a", "b", "c"));
    tester.addEqualityGroup(
        Key.of(ByteArray.copyFrom("a")), Key.newBuilder().append(ByteArray.copyFrom("a")).build());
    Timestamp t = Timestamp.parseTimestamp("2015-09-15T00:00:00Z");
    tester.addEqualityGroup(Key.of(t), Key.newBuilder().append(t).build());
    Date d = Date.parseDate("2016-09-15");
    tester.addEqualityGroup(Key.of(d), Key.newBuilder().append(d).build());
    tester.addEqualityGroup(Key.of("a", 2, null));

    tester.testEquals();
  }
}
