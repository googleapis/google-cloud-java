/*
 * Copyright 2017 Google LLC
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

import static com.google.common.testing.SerializableTester.reserializeAndAssert;
import static com.google.common.truth.Truth.assertThat;

import com.google.cloud.ByteArray;
import com.google.cloud.Date;
import com.google.cloud.Timestamp;
import com.google.common.testing.EqualsTester;
import com.google.protobuf.ListValue;
import com.google.protobuf.NullValue;
import java.math.BigDecimal;
import java.util.UUID;
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
    String numeric = "3.141592";
    String timestamp = "2015-09-15T00:00:00Z";
    String date = "2015-09-15";
    String uuid = UUID.randomUUID().toString();
    String json = "{\"color\":\"red\",\"value\":\"#f00\"}";
    k =
        Key.of(
            null,
            true,
            32,
            64L,
            2.0f,
            4.0d,
            new BigDecimal(numeric),
            "x",
            json,
            ByteArray.copyFrom("y"),
            Timestamp.parseTimestamp(timestamp),
            Date.parseDate(date),
            UUID.fromString(uuid));
    assertThat(k.size()).isEqualTo(13);
    assertThat(k.getParts())
        .containsExactly(
            null,
            Boolean.TRUE,
            32L,
            64L,
            2.0d,
            4.0d,
            BigDecimal.valueOf(3141592, 6),
            "x",
            json,
            ByteArray.copyFrom("y"),
            Timestamp.parseTimestamp(timestamp),
            Date.parseDate(date),
            UUID.fromString(uuid))
        .inOrder();

    // Singleton null key.
    k = Key.of((Object) null);
    assertThat(k.size()).isEqualTo(1);
    assertThat(k.getParts()).contains(null);
  }

  @Test
  public void builder() {
    String numeric = "3.141592";
    String timestamp = "2015-09-15T00:00:00Z";
    String date = "2015-09-15";
    String uuid = UUID.randomUUID().toString();
    String json = "{\"color\":\"red\",\"value\":\"#f00\"}";
    Key k =
        Key.newBuilder()
            .append((Boolean) null)
            .append(true)
            .append(32)
            .append(64L)
            .append(2.0f)
            .append(4.0d)
            .append(new BigDecimal(numeric))
            .append("x")
            .append(json)
            .append(ByteArray.copyFrom("y"))
            .append(Timestamp.parseTimestamp(timestamp))
            .append(Date.parseDate(date))
            .append(UUID.fromString(uuid))
            .build();
    assertThat(k.size()).isEqualTo(13);
    assertThat(k.getParts())
        .containsExactly(
            null,
            Boolean.TRUE,
            32L,
            64L,
            2.0d,
            4.0d,
            BigDecimal.valueOf(3141592, 6),
            "x",
            json,
            ByteArray.copyFrom("y"),
            Timestamp.parseTimestamp(timestamp),
            Date.parseDate(date),
            UUID.fromString(uuid))
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
    assertThat(Key.of(new BigDecimal("3.14")).toString()).isEqualTo("[3.14]");
    assertThat(Key.of("xyz").toString()).isEqualTo("[xyz]");
    assertThat(Key.of("{\"color\":\"red\",\"value\":\"#f00\"}").toString())
        .isEqualTo("[{\"color\":\"red\",\"value\":\"#f00\"}]");
    ByteArray b = ByteArray.copyFrom("xyz");
    assertThat(Key.of(b).toString()).isEqualTo("[" + b.toString() + "]");
    String timestamp = "2015-09-15T00:00:00Z";
    assertThat(Key.of(Timestamp.parseTimestamp(timestamp)).toString())
        .isEqualTo("[" + timestamp + "]");
    String date = "2015-09-15";
    assertThat(Key.of(Date.parseDate(date)).toString()).isEqualTo("[" + date + "]");
    String uuid = UUID.randomUUID().toString();
    assertThat(Key.of(UUID.fromString(uuid)).toString()).isEqualTo("[" + uuid + "]");
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
        Key.newBuilder().append((BigDecimal) null).build(),
        Key.newBuilder().append((String) null).build(),
        Key.newBuilder().append((ByteArray) null).build(),
        Key.newBuilder().append((Timestamp) null).build(),
        Key.newBuilder().append((Date) null).build(),
        Key.newBuilder().append((UUID) null).build(),
        Key.newBuilder().appendObject(null).build());

    tester.addEqualityGroup(Key.of(true), Key.newBuilder().append(true).build());
    tester.addEqualityGroup(Key.of(false), Key.newBuilder().append(false).build());
    tester.addEqualityGroup(Key.of(1), Key.of(1L), Key.newBuilder().append(1).build());
    tester.addEqualityGroup(Key.of(2), Key.of(2L), Key.newBuilder().append(2).build());
    tester.addEqualityGroup(Key.of(1, 2));
    tester.addEqualityGroup(Key.of(1.0f), Key.of(1.0d), Key.newBuilder().append(1.0).build());
    tester.addEqualityGroup(Key.of(2.0f), Key.of(2.0d), Key.newBuilder().append(2.0).build());
    tester.addEqualityGroup(
        Key.of(new BigDecimal("3.141592")),
        Key.of(BigDecimal.valueOf(3141592, 6)),
        Key.newBuilder().append(new BigDecimal("3141592e-6")).build());
    tester.addEqualityGroup(Key.of("a"), Key.newBuilder().append("a").build());
    tester.addEqualityGroup(Key.of("a", "b", "c"));
    tester.addEqualityGroup(
        Key.of(ByteArray.copyFrom("a")), Key.newBuilder().append(ByteArray.copyFrom("a")).build());
    tester.addEqualityGroup(
        Key.of("{\"color\":\"red\",\"value\":\"#f00\"}"),
        Key.newBuilder().append("{\"color\":\"red\",\"value\":\"#f00\"}").build());
    Timestamp t = Timestamp.parseTimestamp("2015-09-15T00:00:00Z");
    tester.addEqualityGroup(Key.of(t), Key.newBuilder().append(t).build());
    Date d = Date.parseDate("2016-09-15");
    tester.addEqualityGroup(Key.of(d), Key.newBuilder().append(d).build());
    UUID uuid = UUID.randomUUID();
    tester.addEqualityGroup(Key.of(uuid), Key.newBuilder().append(uuid).build());
    tester.addEqualityGroup(Key.of("a", 2, null));

    tester.testEquals();
  }

  @Test
  public void serialization() {
    reserializeAndAssert(Key.of());
    reserializeAndAssert(Key.of(new Object[] {null}));
    reserializeAndAssert(Key.of(true));
    reserializeAndAssert(Key.of(32));
    reserializeAndAssert(Key.of(2.0));
    reserializeAndAssert(Key.of(new BigDecimal("3.141592")));
    reserializeAndAssert(Key.of("xyz"));
    reserializeAndAssert(Key.of("{\"color\":\"red\",\"value\":\"#f00\"}"));
    reserializeAndAssert(Key.of(ByteArray.copyFrom("xyz")));
    reserializeAndAssert(Key.of(Timestamp.parseTimestamp("2015-09-15T00:00:00Z")));
    reserializeAndAssert(Key.of(Date.parseDate("2015-09-15")));
    reserializeAndAssert(Key.of(UUID.randomUUID()));
    reserializeAndAssert(Key.of(1, 2, 3));
  }

  @Test
  public void toProto() {
    String timestamp = "2015-09-15T00:00:00Z";
    String date = "2015-09-15";
    String uuid = UUID.randomUUID().toString();
    Key k =
        Key.newBuilder()
            .append((Boolean) null)
            .append(true)
            .append(32)
            .append(64L)
            .append(2.0f)
            .append(4.0d)
            .append(new BigDecimal("6.62607004e-34"))
            .append("x")
            .append("{\"color\":\"red\",\"value\":\"#f00\"}")
            .append(ByteArray.copyFrom("y"))
            .append(Timestamp.parseTimestamp(timestamp))
            .append(Date.parseDate(date))
            .append(UUID.fromString(uuid))
            .build();
    ListValue.Builder builder = ListValue.newBuilder();
    builder.addValuesBuilder().setNullValue(NullValue.NULL_VALUE);
    builder.addValuesBuilder().setBoolValue(true);
    builder.addValuesBuilder().setStringValue("32");
    builder.addValuesBuilder().setStringValue("64");
    builder.addValuesBuilder().setNumberValue(2.0f);
    builder.addValuesBuilder().setNumberValue(4.0d);
    builder.addValuesBuilder().setStringValue("6.62607004E-34");
    builder.addValuesBuilder().setStringValue("x");
    builder.addValuesBuilder().setStringValue("{\"color\":\"red\",\"value\":\"#f00\"}");
    builder.addValuesBuilder().setStringValue("eQ==");
    builder.addValuesBuilder().setStringValue(timestamp);
    builder.addValuesBuilder().setStringValue(date);
    builder.addValuesBuilder().setStringValue(uuid);
    assertThat(k.toProto()).isEqualTo(builder.build());
  }
}
