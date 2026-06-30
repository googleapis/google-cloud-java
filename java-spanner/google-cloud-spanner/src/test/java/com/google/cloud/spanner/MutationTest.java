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
import static org.junit.Assert.assertThrows;
import static org.junit.Assert.assertTrue;

import com.google.cloud.ByteArray;
import com.google.cloud.Date;
import com.google.cloud.Timestamp;
import com.google.cloud.spanner.SingerProto.Genre;
import com.google.cloud.spanner.SingerProto.SingerInfo;
import com.google.common.collect.ImmutableList;
import com.google.common.collect.ImmutableMap;
import com.google.common.testing.EqualsTester;
import java.math.BigDecimal;
import java.time.Instant;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import org.hamcrest.Matcher;
import org.hamcrest.MatcherAssert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;

/** Unit tests for {@link com.google.cloud.spanner.Mutation}. */
@RunWith(JUnit4.class)
public class MutationTest {

  @Test
  public void insertEmpty() {
    Mutation m = Mutation.newInsertBuilder("T1").build();
    assertThat(m.getTable()).isEqualTo("T1");
    assertThat(m.getOperation()).isEqualTo(Mutation.Op.INSERT);
    assertThat(m.getColumns()).isEmpty();
    assertThat(m.getValues()).isEmpty();
    assertThat(m.toString()).isEqualTo("insert(T1{})");
  }

  @Test
  public void insert() {
    Mutation m = Mutation.newInsertBuilder("T1").set("C1").to(true).set("C2").to(1234).build();
    assertThat(m.getTable()).isEqualTo("T1");
    assertThat(m.getOperation()).isEqualTo(Mutation.Op.INSERT);
    assertThat(m.getColumns()).containsExactly("C1", "C2").inOrder();
    assertThat(m.getValues()).containsExactly(Value.bool(true), Value.int64(1234)).inOrder();
    assertThat(m.toString()).isEqualTo("insert(T1{C1=true,C2=1234})");
  }

  @Test
  public void insertOrUpdateEmpty() {
    Mutation m = Mutation.newInsertOrUpdateBuilder("T2").build();
    assertThat(m.getTable()).isEqualTo("T2");
    assertThat(m.getOperation()).isEqualTo(Mutation.Op.INSERT_OR_UPDATE);
    assertThat(m.getColumns()).isEmpty();
    assertThat(m.getValues()).isEmpty();
    assertThat(m.toString()).isEqualTo("insert_or_update(T2{})");
  }

  @Test
  public void insertOrUpdate() {
    Mutation m = Mutation.newInsertOrUpdateBuilder("T1").set("C1").to(true).build();
    assertThat(m.getTable()).isEqualTo("T1");
    assertThat(m.getOperation()).isEqualTo(Mutation.Op.INSERT_OR_UPDATE);
    assertThat(m.getColumns()).containsExactly("C1");
    assertThat(m.getValues()).containsExactly(Value.bool(true));
    assertThat(m.toString()).isEqualTo("insert_or_update(T1{C1=true})");
  }

  @Test
  public void updateEmpty() {
    Mutation m = Mutation.newUpdateBuilder("T2").build();
    assertThat(m.getTable()).isEqualTo("T2");
    assertThat(m.getOperation()).isEqualTo(Mutation.Op.UPDATE);
    assertThat(m.getColumns()).isEmpty();
    assertThat(m.getValues()).isEmpty();
    assertThat(m.toString()).isEqualTo("update(T2{})");
  }

  @Test
  public void update() {
    Mutation m = Mutation.newUpdateBuilder("T1").set("C1").to(true).set("C2").to(1234).build();
    assertThat(m.getTable()).isEqualTo("T1");
    assertThat(m.getOperation()).isEqualTo(Mutation.Op.UPDATE);
    assertThat(m.getColumns()).containsExactly("C1", "C2").inOrder();
    assertThat(m.getValues()).containsExactly(Value.bool(true), Value.int64(1234)).inOrder();
    assertThat(m.toString()).isEqualTo("update(T1{C1=true,C2=1234})");
  }

  @Test
  public void replaceEmpty() {
    Mutation m = Mutation.newReplaceBuilder("T2").build();
    assertThat(m.getTable()).isEqualTo("T2");
    assertThat(m.getOperation()).isEqualTo(Mutation.Op.REPLACE);
    assertThat(m.getColumns()).isEmpty();
    assertThat(m.getValues()).isEmpty();
    assertThat(m.toString()).isEqualTo("replace(T2{})");
  }

  @Test
  public void replace() {
    Mutation m = Mutation.newReplaceBuilder("T1").set("C1").to(true).set("C2").to(1234).build();
    assertThat(m.getTable()).isEqualTo("T1");
    assertThat(m.getOperation()).isEqualTo(Mutation.Op.REPLACE);
    assertThat(m.getColumns()).containsExactly("C1", "C2").inOrder();
    assertThat(m.getValues()).containsExactly(Value.bool(true), Value.int64(1234)).inOrder();
    assertThat(m.toString()).isEqualTo("replace(T1{C1=true,C2=1234})");
  }

  @Test
  public void duplicateColumn() {
    IllegalStateException e =
        assertThrows(
            IllegalStateException.class,
            () -> Mutation.newInsertBuilder("T1").set("C1").to(true).set("C1").to(false).build());
    assertThat(e.getMessage()).contains("Duplicate column");
  }

  @Test
  public void duplicateColumnCaseInsensitive() {
    IllegalStateException e =
        assertThrows(
            IllegalStateException.class,
            () -> Mutation.newInsertBuilder("T1").set("C1").to(true).set("c1").to(false).build());
    assertThat(e.getMessage()).contains("Duplicate column");
  }

  @Test
  public void asMap() {
    Mutation m = Mutation.newInsertBuilder("T").build();
    assertThat(m.asMap()).isEqualTo(ImmutableMap.of());

    m = Mutation.newInsertBuilder("T").set("C1").to(true).set("C2").to(1234).build();
    assertThat(m.asMap())
        .isEqualTo(ImmutableMap.of("C1", Value.bool(true), "C2", Value.int64(1234)));
  }

  @Test
  public void unfinishedBindingV1() {
    Mutation.WriteBuilder b = Mutation.newInsertBuilder("T1");
    b.set("C1");
    IllegalStateException e = assertThrows(IllegalStateException.class, () -> b.build());
    assertThat(e.getMessage()).contains("Incomplete binding for column C1");
  }

  @Test
  public void unfinishedBindingV2() {
    Mutation.WriteBuilder b = Mutation.newInsertBuilder("T1");
    b.set("C1");
    IllegalStateException e = assertThrows(IllegalStateException.class, () -> b.set("C2"));
    assertThat(e.getMessage()).contains("Incomplete binding for column C1");
  }

  @Test
  public void notInBinding() {
    ValueBinder<Mutation.WriteBuilder> binder = Mutation.newInsertBuilder("T1").set("C1");
    binder.to(1234);
    IllegalStateException e = assertThrows(IllegalStateException.class, () -> binder.to(5678));
    assertThat(e.getMessage()).contains("No binding currently active");
  }

  @Test
  public void delete() {
    KeySet keySet = KeySet.singleKey(Key.of("k1"));
    Mutation m = Mutation.delete("T1", keySet);
    assertThat(m.getOperation()).isEqualTo(Mutation.Op.DELETE);
    assertThat(m.getKeySet()).isEqualTo(keySet);
    assertThat(m.toString()).isEqualTo("delete(T1{[k1]})");
  }

  @Test
  public void send() {
    Key key = Key.of(123);
    Value payload = Value.bytes(ByteArray.copyFrom("payload"));
    Instant deliverAt = Instant.now().plusSeconds(3600);
    Mutation m =
        Mutation.newSendBuilder("TestQueue")
            .setKey(key)
            .setPayload(payload)
            .setDeliveryTime(deliverAt)
            .build();
    assertThat(m.getOperation()).isEqualTo(Mutation.Op.SEND);
    assertThat(m.getQueue()).isEqualTo("TestQueue");
    assertThat(m.getKey()).isEqualTo(key);
    assertThat(m.getPayload()).isEqualTo(payload);
    assertThat(m.getDeliveryTime()).isEqualTo(deliverAt);
    assertThat(m.toString())
        .isEqualTo(
            "send(TestQueue{key=[123], payload=" + payload + ", deliveryTime=" + deliverAt + "})");
  }

  @Test
  public void sendMissingKey() {
    IllegalStateException e =
        assertThrows(
            IllegalStateException.class,
            () -> Mutation.newSendBuilder("TestQueue").setPayload(Value.string("payload")).build());
    assertThat(e.getMessage()).contains("Key must be set");
  }

  @Test
  public void sendMissingPayload() {
    IllegalStateException e =
        assertThrows(
            IllegalStateException.class,
            () -> Mutation.newSendBuilder("TestQueue").setKey(Key.of("k1")).build());
    assertThat(e.getMessage()).contains("Payload must be set");
  }

  @Test
  public void ackIgnoreNotFound() {
    Key key = Key.of("k1");
    Mutation m = Mutation.newAckBuilder("TestQueue").setKey(key).setIgnoreNotFound(true).build();
    assertThat(m.getOperation()).isEqualTo(Mutation.Op.ACK);
    assertThat(m.getQueue()).isEqualTo("TestQueue");
    assertThat(m.getKey()).isEqualTo(key);
    assertTrue(m.getIgnoreNotFound());
    assertThat(m.toString()).isEqualTo("ack(TestQueue{key=[k1], ignoreNotFound=true})");
  }

  @Test
  public void ackMissingKey() {
    IllegalStateException e =
        assertThrows(
            IllegalStateException.class, () -> Mutation.newAckBuilder("TestQueue").build());
    assertThat(e.getMessage()).contains("Key must be set");
  }

  @Test
  public void equalsAndHashCode() {
    EqualsTester tester = new EqualsTester();

    // Equality, not identity.
    tester.addEqualityGroup(
        Mutation.newInsertBuilder("T1").build(), Mutation.newInsertBuilder("T1").build());

    // Operation types are distinguished.
    tester.addEqualityGroup(Mutation.newInsertOrUpdateBuilder("T1").build());
    tester.addEqualityGroup(Mutation.newUpdateBuilder("T1").build());
    tester.addEqualityGroup(Mutation.newReplaceBuilder("T1").build());

    // Table is distinguished.
    tester.addEqualityGroup(Mutation.newInsertBuilder("T2").build());

    // Columns/values are distinguished (but by equality, not identity).
    tester.addEqualityGroup(
        Mutation.newInsertBuilder("T1").set("C").to("V").build(),
        Mutation.newInsertBuilder("T1").set("C").to("V").build());

    // Deletes consider the key set.
    tester.addEqualityGroup(Mutation.delete("T1", KeySet.all()));
    tester.addEqualityGroup(
        Mutation.delete("T1", KeySet.singleKey(Key.of("k"))), Mutation.delete("T1", Key.of("k")));

    // Test NaNs
    // Refer the comment in `Value.hashCode()` for more details on NaN equality.
    tester.addEqualityGroup(
        Mutation.newInsertBuilder("T1").set("C").to(Double.NaN).build(),
        Mutation.newInsertBuilder("T1").set("C").to(Value.float64(Double.NaN)).build(),
        Mutation.newInsertBuilder("T1").set("C").to(Float.NaN).build(),
        Mutation.newInsertBuilder("T1").set("C").to(Value.float64(Float.NaN)).build(),
        Mutation.newInsertBuilder("T1").set("C").to(Value.float32(Float.NaN)).build());

    // Test NaN arrays
    tester.addEqualityGroup(
        Mutation.newInsertBuilder("T1").set("C").toFloat32Array(new float[] {Float.NaN}).build(),
        Mutation.newInsertBuilder("T1")
            .set("C")
            .toFloat32Array(new float[] {Float.NaN}, 0, 1)
            .build(),
        Mutation.newInsertBuilder("T1")
            .set("C")
            .toFloat32Array(Collections.singletonList(Float.NaN))
            .build(),
        Mutation.newInsertBuilder("T1")
            .set("C")
            .to(Value.float32Array(new float[] {Float.NaN}))
            .build(),
        Mutation.newInsertBuilder("T1")
            .set("C")
            .to(Value.float32Array(new float[] {Float.NaN}, 0, 1))
            .build(),
        Mutation.newInsertBuilder("T1")
            .set("C")
            .to(Value.float32Array(Collections.singletonList(Float.NaN)))
            .build());
    tester.addEqualityGroup(
        Mutation.newInsertBuilder("T1").set("C").toFloat64Array(new double[] {Double.NaN}).build(),
        Mutation.newInsertBuilder("T1").set("C").toFloat64Array(new double[] {Float.NaN}).build(),
        Mutation.newInsertBuilder("T1")
            .set("C")
            .toFloat64Array(new double[] {Double.NaN}, 0, 1)
            .build(),
        Mutation.newInsertBuilder("T1")
            .set("C")
            .toFloat64Array(new double[] {Float.NaN}, 0, 1)
            .build(),
        Mutation.newInsertBuilder("T1")
            .set("C")
            .toFloat64Array(Collections.singletonList(Double.NaN))
            .build(),
        Mutation.newInsertBuilder("T1")
            .set("C")
            .toFloat64Array(Collections.singletonList((double) Float.NaN))
            .build(),
        Mutation.newInsertBuilder("T1")
            .set("C")
            .to(Value.float64Array(new double[] {Double.NaN}))
            .build(),
        Mutation.newInsertBuilder("T1")
            .set("C")
            .to(Value.float64Array(new double[] {Float.NaN}))
            .build(),
        Mutation.newInsertBuilder("T1")
            .set("C")
            .to(Value.float64Array(new double[] {Double.NaN}, 0, 1))
            .build(),
        Mutation.newInsertBuilder("T1")
            .set("C")
            .to(Value.float64Array(new double[] {Float.NaN}, 0, 1))
            .build(),
        Mutation.newInsertBuilder("T1")
            .set("C")
            .to(Value.float64Array(Collections.singletonList(Double.NaN)))
            .build(),
        Mutation.newInsertBuilder("T1")
            .set("C")
            .to(Value.float64Array(Collections.singletonList((double) Float.NaN)))
            .build());
    // Test NaNs and nulls
    tester.addEqualityGroup(
        Mutation.newInsertBuilder("T1")
            .set("C")
            .toFloat64Array(Arrays.asList(null, Double.NaN))
            .build(),
        Mutation.newInsertBuilder("T1")
            .set("C")
            .toFloat64Array(Arrays.asList(null, (double) Float.NaN))
            .build());
    tester.addEqualityGroup(
        Mutation.newInsertBuilder("T1")
            .set("C")
            .toFloat32Array(Arrays.asList(null, Float.NaN))
            .build());

    tester.testEquals();
  }

  @Test
  public void equalsAndHashCode_sendAndAck() {
    EqualsTester tester = new EqualsTester();

    Key key1 = Key.of("k1");
    Key key2 = Key.of("k2");
    Value payload1 = Value.string("p1");
    Value payload2 = Value.string("p2");
    Instant time1 = Instant.now();
    Instant time2 = time1.plusSeconds(10);

    // SEND
    tester.addEqualityGroup(
        Mutation.newSendBuilder("TestQueue").setKey(key1).setPayload(payload1).build(),
        Mutation.newSendBuilder("TestQueue").setKey(key1).setPayload(payload1).build());
    // Different key
    tester.addEqualityGroup(
        Mutation.newSendBuilder("TestQueue").setKey(key2).setPayload(payload1).build());
    // Different payload
    tester.addEqualityGroup(
        Mutation.newSendBuilder("TestQueue").setKey(key1).setPayload(payload2).build());
    // Different queue
    tester.addEqualityGroup(
        Mutation.newSendBuilder("TestQueue2").setKey(key1).setPayload(payload1).build());
    // Different time
    tester.addEqualityGroup(
        Mutation.newSendBuilder("TestQueue")
            .setKey(key1)
            .setPayload(payload1)
            .setDeliveryTime(time1)
            .build(),
        Mutation.newSendBuilder("TestQueue")
            .setKey(key1)
            .setPayload(payload1)
            .setDeliveryTime(time1)
            .build());
    tester.addEqualityGroup(
        Mutation.newSendBuilder("TestQueue")
            .setKey(key1)
            .setPayload(payload1)
            .setDeliveryTime(time2)
            .build());

    // ACK
    tester.addEqualityGroup(
        Mutation.newAckBuilder("TestQueue").setKey(key1).build(),
        Mutation.newAckBuilder("TestQueue").setKey(key1).build());
    // Different key
    tester.addEqualityGroup(Mutation.newAckBuilder("TestQueue").setKey(key2).build());
    // Different queue
    tester.addEqualityGroup(Mutation.newAckBuilder("TestQueue2").setKey(key1).build());
    // Different ignoreNotFound
    tester.addEqualityGroup(
        Mutation.newAckBuilder("TestQueue").setKey(key1).setIgnoreNotFound(true).build(),
        Mutation.newAckBuilder("TestQueue").setKey(key1).setIgnoreNotFound(true).build());

    // Distinct Op types
    tester.addEqualityGroup(Mutation.newInsertBuilder("TestQueue").build());

    tester.testEquals();
  }

  @Test
  public void serializationBasic() {
    Instant time = Instant.now();
    List<Mutation> mutations =
        Arrays.asList(
            Mutation.newInsertBuilder("T").set("C").to("V").build(),
            Mutation.newUpdateBuilder("T").set("C").to("V").build(),
            Mutation.newInsertOrUpdateBuilder("T").set("C").to("V").build(),
            Mutation.newReplaceBuilder("T").set("C").to("V").build(),
            Mutation.delete("T", KeySet.singleKey(Key.of("k"))),
            Mutation.newSendBuilder("Q")
                .setKey(Key.of("k"))
                .setPayload(Value.string("p"))
                .setDeliveryTime(time)
                .build(),
            Mutation.newAckBuilder("Q").setKey(Key.of("k")).setIgnoreNotFound(true).build());

    List<com.google.spanner.v1.Mutation> proto = new ArrayList<>();

    // Include an existing element so that we know toProto() do not clear the list.
    com.google.spanner.v1.Mutation existingProto =
        com.google.spanner.v1.Mutation.getDefaultInstance();
    proto.add(existingProto);

    Mutation.toProtoAndReturnRandomMutation(mutations, proto);

    assertThat(proto.size()).isAtLeast(1);
    assertThat(proto.get(0)).isSameInstanceAs(existingProto);
    proto.remove(0);

    assertThat(proto.size()).isEqualTo(7);
    MatcherAssert.assertThat(
        proto.get(0),
        matchesProto("insert { table: 'T' columns: 'C' values { values { string_value: 'V' } } }"));
    MatcherAssert.assertThat(
        proto.get(1),
        matchesProto("update { table: 'T' columns: 'C' values { values { string_value: 'V' } } }"));
    MatcherAssert.assertThat(
        proto.get(2),
        matchesProto(
            "insert_or_update { table: 'T' columns: 'C'"
                + " values { values { string_value: 'V' } } }"));
    MatcherAssert.assertThat(
        proto.get(3),
        matchesProto(
            "replace { table: 'T' columns: 'C' values { values { string_value: 'V' } } }"));
    MatcherAssert.assertThat(
        proto.get(4),
        matchesProto("delete { table: 'T' key_set { keys { values { string_value: 'k' } } } }"));
    MatcherAssert.assertThat(
        proto.get(5),
        matchesProto(
            "send { queue: 'Q' key { values { string_value: 'k' } } deliver_time { seconds: "
                + time.getEpochSecond()
                + " nanos: "
                + time.getNano()
                + " } payload { string_value: 'p' } }"));
    MatcherAssert.assertThat(
        proto.get(6),
        matchesProto(
            "ack { queue: 'Q' key { values { string_value: 'k' } } ignore_not_found: true }"));
  }

  @Test
  public void toProtoCoalescingChangeOfTable() {
    List<Mutation> mutations =
        Arrays.asList(
            Mutation.newInsertBuilder("T1").set("C").to("V1").build(),
            Mutation.newInsertBuilder("T1").set("C").to("V2").build(),
            Mutation.newInsertBuilder("T1").set("C").to("V3").build(),
            Mutation.newInsertBuilder("T2").set("C").to("V4").build(),
            Mutation.newInsertBuilder("T2").set("C").to("V5").build());

    List<com.google.spanner.v1.Mutation> proto = new ArrayList<>();
    com.google.spanner.v1.Mutation mutation =
        Mutation.toProtoAndReturnRandomMutation(mutations, proto);
    // Random mutation returned should be INSERT with large number of values
    MatcherAssert.assertThat(
        mutation,
        matchesProto(
            "insert { table: 'T1' columns: 'C' values { values { string_value: 'V1' } }"
                + " values { values { string_value: 'V2' } }"
                + " values { values { string_value: 'V3' } } }"));

    assertThat(proto.size()).isEqualTo(2);
    MatcherAssert.assertThat(
        proto.get(0),
        matchesProto(
            "insert { table: 'T1' columns: 'C' values { values { string_value: 'V1' } }"
                + " values { values { string_value: 'V2' } }"
                + " values { values { string_value: 'V3' } } }"));
    MatcherAssert.assertThat(
        proto.get(1),
        matchesProto(
            "insert { table: 'T2' columns: 'C' values { values { string_value: 'V4' } }"
                + " values { values { string_value: 'V5' } } }"));
  }

  @Test
  public void toProtoCoalescingChangeOfOperation() {
    List<Mutation> mutations =
        Arrays.asList(
            Mutation.newInsertBuilder("T").set("C").to("V1").build(),
            Mutation.newInsertBuilder("T").set("C").to("V2").build(),
            Mutation.newInsertBuilder("T").set("C").to("V3").build(),
            Mutation.newUpdateBuilder("T").set("C").to("V4").build(),
            Mutation.newUpdateBuilder("T").set("C").to("V5").build());

    List<com.google.spanner.v1.Mutation> proto = new ArrayList<>();
    com.google.spanner.v1.Mutation mutation =
        Mutation.toProtoAndReturnRandomMutation(mutations, proto);
    // Random mutation returned should be of UPDATE operation
    MatcherAssert.assertThat(
        mutation,
        matchesProto(
            "update { table: 'T' columns: 'C' values { values { string_value: 'V4' } }"
                + " values { values { string_value: 'V5' } } }"));

    assertThat(proto.size()).isEqualTo(2);
    MatcherAssert.assertThat(
        proto.get(0),
        matchesProto(
            "insert { table: 'T' columns: 'C' values { values { string_value: 'V1' } }"
                + " values { values { string_value: 'V2' } }"
                + " values { values { string_value: 'V3' } } }"));
    MatcherAssert.assertThat(
        proto.get(1),
        matchesProto(
            "update { table: 'T' columns: 'C' values { values { string_value: 'V4' } }"
                + " values { values { string_value: 'V5' } } }"));
  }

  @Test
  public void toProtoCoalescingChangeOfColumn() {
    List<Mutation> mutations =
        Arrays.asList(
            Mutation.newInsertBuilder("T").set("C1").to("V1").build(),
            Mutation.newInsertBuilder("T").set("C1").to("V2").build(),
            Mutation.newInsertBuilder("T").set("C1").to("V3").build(),
            Mutation.newInsertBuilder("T").set("C2").to("V4").build(),
            Mutation.newInsertBuilder("T").set("C2").to("V5").build());

    List<com.google.spanner.v1.Mutation> proto = new ArrayList<>();
    com.google.spanner.v1.Mutation mutation =
        Mutation.toProtoAndReturnRandomMutation(mutations, proto);
    MatcherAssert.assertThat(
        mutation,
        matchesProto(
            "insert { table: 'T' columns: 'C1' values { values { string_value: 'V1' } }"
                + " values { values { string_value: 'V2' } }"
                + " values { values { string_value: 'V3' } } }"));

    assertThat(proto.size()).isEqualTo(2);
    MatcherAssert.assertThat(
        proto.get(0),
        matchesProto(
            "insert { table: 'T' columns: 'C1' values { values { string_value: 'V1' } }"
                + " values { values { string_value: 'V2' } }"
                + " values { values { string_value: 'V3' } } }"));
    MatcherAssert.assertThat(
        proto.get(1),
        matchesProto(
            "insert { table: 'T' columns: 'C2' values { values { string_value: 'V4' } }"
                + " values { values { string_value: 'V5' } } }"));
  }

  @Test
  public void toProtoCoalescingDelete() {
    List<Mutation> mutations =
        Arrays.asList(
            Mutation.delete("T", Key.of("k1")),
            Mutation.delete("T", Key.of("k2")),
            Mutation.delete("T", KeySet.range(KeyRange.closedOpen(Key.of("ka"), Key.of("kb")))),
            Mutation.delete("T", KeySet.range(KeyRange.closedClosed(Key.of("kc"), Key.of("kd")))));

    List<com.google.spanner.v1.Mutation> proto = new ArrayList<>();
    com.google.spanner.v1.Mutation mutation =
        Mutation.toProtoAndReturnRandomMutation(mutations, proto);
    // Random mutation returned should be of DELETE operation
    assertTrue(mutation.hasDelete());

    assertThat(proto.size()).isEqualTo(1);
    MatcherAssert.assertThat(
        proto.get(0),
        matchesProto(
            "delete {"
                + "  table: 'T'"
                + "  key_set {"
                + "    keys { values { string_value: 'k1' } }"
                + "    keys { values { string_value: 'k2' } }"
                + "    ranges { start_closed { values { string_value: 'ka' } } "
                + "             end_open { values { string_value: 'kb' } } }"
                + "    ranges { start_closed { values { string_value: 'kc' } } "
                + "             end_closed { values { string_value: 'kd' } } }"
                + "  }"
                + "} "));
  }

  @Test
  public void toProtoCoalescingDeleteChanges() {
    List<Mutation> mutations =
        Arrays.asList(
            Mutation.newInsertBuilder("T1").set("C").to("V1").build(),
            Mutation.delete("T1", Key.of("k1")),
            Mutation.delete("T1", Key.of("k2")),
            Mutation.delete("T2", Key.of("k3")),
            Mutation.delete("T2", Key.of("k4")),
            Mutation.newInsertBuilder("T2").set("C").to("V1").build());

    List<com.google.spanner.v1.Mutation> proto = new ArrayList<>();
    com.google.spanner.v1.Mutation mutation =
        Mutation.toProtoAndReturnRandomMutation(mutations, proto);
    assertTrue(mutation.hasDelete());

    assertThat(proto.size()).isEqualTo(4);
    MatcherAssert.assertThat(
        proto.get(0),
        matchesProto(
            "insert { table: 'T1' columns: 'C' values { values { string_value: 'V1' } } }"));
    MatcherAssert.assertThat(
        proto.get(1),
        matchesProto(
            "delete { table: 'T1' key_set { keys { values { string_value: 'k1' } } "
                + "keys { values { string_value: 'k2' } } } }"));
    MatcherAssert.assertThat(
        proto.get(2),
        matchesProto(
            "delete { table: 'T2' key_set { keys { values { string_value: 'k3' } } "
                + "keys { values { string_value: 'k4' } } } }"));
    MatcherAssert.assertThat(
        proto.get(3),
        matchesProto(
            "insert { table: 'T2', columns: 'C', values { values { string_value: 'V1' } } }"));
  }

  @Test
  public void toProtoWithEmptyInsertMutations() {
    List<Mutation> mutations =
        Arrays.asList(
            Mutation.newInsertBuilder("T").build(), Mutation.newInsertBuilder("A").build());

    List<com.google.spanner.v1.Mutation> proto = new ArrayList<>();
    com.google.spanner.v1.Mutation mutation =
        Mutation.toProtoAndReturnRandomMutation(mutations, proto);

    // Random mutation returned should be of INSERT operation with empty values
    MatcherAssert.assertThat(mutation, matchesProto("insert { table: 'T' values { } }"));

    assertThat(proto.size()).isEqualTo(2);
  }

  @Test
  public void javaSerialization() {
    reserializeAndAssert(appendAllTypes(Mutation.newInsertBuilder("test")).build());
    reserializeAndAssert(appendAllTypes(Mutation.newUpdateBuilder("test")).build());
    reserializeAndAssert(appendAllTypes(Mutation.newReplaceBuilder("test")).build());
    reserializeAndAssert(appendAllTypes(Mutation.newInsertOrUpdateBuilder("test")).build());

    reserializeAndAssert(
        Mutation.delete(
            "test",
            Key.of(
                "one",
                2,
                null,
                true,
                2.3,
                ByteArray.fromBase64("abcd"),
                Timestamp.ofTimeSecondsAndNanos(1, 2),
                Date.fromYearMonthDay(2017, 4, 17))));
    reserializeAndAssert(Mutation.delete("test", KeySet.all()));
    reserializeAndAssert(
        Mutation.delete(
            "test",
            KeySet.newBuilder()
                .addRange(KeyRange.closedClosed(Key.of("one", 2, null), Key.of("two", 3, null)))
                .build()));
    reserializeAndAssert(
        Mutation.delete(
            "test",
            KeySet.newBuilder()
                .addRange(KeyRange.closedOpen(Key.of("one", 2, null), Key.of("two", 3, null)))
                .build()));
    reserializeAndAssert(
        Mutation.delete(
            "test",
            KeySet.newBuilder()
                .addRange(KeyRange.openClosed(Key.of("one", 2, null), Key.of("two", 3, null)))
                .build()));
    reserializeAndAssert(
        Mutation.delete(
            "test",
            KeySet.newBuilder()
                .addRange(KeyRange.openOpen(Key.of("one", 2, null), Key.of("two", 3, null)))
                .build()));
  }

  private Mutation.WriteBuilder appendAllTypes(Mutation.WriteBuilder builder) {
    return builder
        .set("bool")
        .to(true)
        .set("boolNull")
        .to((Boolean) null)
        .set("boolValue")
        .to(Value.bool(false))
        .set("int")
        .to(42)
        .set("intNull")
        .to((Long) null)
        .set("intValue")
        .to(Value.int64(1L))
        .set("float32")
        .to(42.1f)
        .set("float32Null")
        .to((Float) null)
        .set("float32Value")
        .to(Value.float32(10f))
        .set("float64")
        .to(42.1)
        .set("float64Null")
        .to((Double) null)
        .set("float64Value")
        .to(Value.float64(10D))
        .set("string")
        .to("str")
        .set("stringNull")
        .to((String) null)
        .set("stringValue")
        .to(Value.string("strValue"))
        .set("bigDecimal")
        .to(BigDecimal.valueOf(123, 2))
        .set("bigDecimalNull")
        .to((BigDecimal) null)
        .set("bigDecimalValueAsNumeric")
        .to(Value.numeric(BigDecimal.TEN))
        .set("pgNumericValue")
        .to(Value.pgNumeric("4.2"))
        .set("json")
        .to(Value.json("{\"key\": \"value\"}}"))
        .set("jsonNull")
        .to(Value.json(null))
        .set("protoMessage")
        .to(SingerInfo.newBuilder().setSingerId(232).setGenre(Genre.POP).build())
        .set("protoMessageNull")
        .to(Value.protoMessage(null, SingerInfo.getDescriptor().getFullName()))
        .set("protoEnum")
        .to(Genre.JAZZ)
        .set("protoEnumNull")
        .to(Value.protoEnum(null, SingerInfo.getDescriptor().getFullName()))
        .set("pgJsonb")
        .to(Value.pgJsonb("{\"key\": \"value\"}}"))
        .set("pgJsonbNull")
        .to(Value.pgJsonb(null))
        .set("pgOid")
        .to(Value.pgOid(42))
        .set("pgOidNull")
        .to(Value.pgOid(null))
        .set("timestamp")
        .to(Timestamp.MAX_VALUE)
        .set("timestampNull")
        .to((Timestamp) null)
        .set("timestampValue")
        .to(Value.timestamp(Timestamp.MIN_VALUE))
        .set("date")
        .to(Date.fromYearMonthDay(2017, 4, 17))
        .set("dateNull")
        .to((Date) null)
        .set("dateValue")
        .to(Value.date(Date.fromYearMonthDay(2021, 1, 2)))
        .set("boolArr")
        .toBoolArray(new boolean[] {true, false})
        .set("boolArrNull")
        .toBoolArray((boolean[]) null)
        .set("boolArrValue")
        .to(Value.boolArray(ImmutableList.of(false, true)))
        .set("intArr")
        .toInt64Array(new long[] {1, 2, 3})
        .set("intArrNull")
        .toInt64Array((long[]) null)
        .set("intArrValue")
        .to(Value.int64Array(ImmutableList.of(1L, 2L)))
        .set("float32Arr")
        .toFloat32Array(new float[] {1.1f, 2.2f, 3.3f})
        .set("float32ArrNull")
        .toFloat32Array((float[]) null)
        .set("float32ArrValue")
        .to(Value.float32Array(ImmutableList.of(10.1F, 10.2F, 10.3F)))
        .set("float64Arr")
        .toFloat64Array(new double[] {1.1, 2.2, 3.3})
        .set("float64ArrNull")
        .toFloat64Array((double[]) null)
        .set("float64ArrValue")
        .to(Value.float64Array(ImmutableList.of(10.1D, 10.2D, 10.3D)))
        .set("stringArr")
        .toStringArray(ImmutableList.of("one", "two"))
        .set("stringArrNull")
        .toStringArray(null)
        .set("stringArrValue")
        .to(Value.stringArray(ImmutableList.of("uno", "dos")))
        .set("numericArr")
        .toNumericArray(ImmutableList.of(BigDecimal.ONE, BigDecimal.TEN))
        .set("numericArrNull")
        .toNumericArray(null)
        .set("numericArrValue")
        .to(Value.numericArray(ImmutableList.of(BigDecimal.ZERO, BigDecimal.valueOf(234, 2))))
        .set("pgNumericArr")
        .toPgNumericArray(ImmutableList.of("1.23", "2.34"))
        .set("pgNumericArrNull")
        .toPgNumericArray(null)
        .set("pgNumericArrValue")
        .to(Value.pgNumericArray(ImmutableList.of("10.20", "20.30")))
        .set("jsonArr")
        .toJsonArray(ImmutableList.of("{\"key\": \"value1\"}}", "{\"key\": \"value2\"}"))
        .set("jsonArrNull")
        .toJsonArray(null)
        .set("jsonArrValue")
        .to(Value.jsonArray(ImmutableList.of("{\"key\": \"value1\"}}", "{\"key\": \"value2\"}")))
        .set("protoMessageArr")
        .toProtoMessageArray(
            ImmutableList.of(SingerInfo.newBuilder().setSingerId(232).setGenre(Genre.POP).build()),
            SingerInfo.getDescriptor())
        .set("protoMessageArrNull")
        .toProtoMessageArray(null, SingerInfo.getDescriptor())
        .set("protoMessageArrValue")
        .to(
            Value.protoMessageArray(
                ImmutableList.of(
                    SingerInfo.newBuilder().setSingerId(232).setGenre(Genre.POP).build()),
                SingerInfo.getDescriptor()))
        .set("protoEnumArr")
        .toProtoEnumArray(ImmutableList.of(Genre.JAZZ), Genre.getDescriptor())
        .set("protoEnumArrNull")
        .toProtoEnumArray(null, Genre.getDescriptor())
        .set("protoEnumArrValue")
        .to(Value.protoEnumArray(ImmutableList.of(Genre.JAZZ), Genre.getDescriptor()))
        .set("pgJsonbArr")
        .toPgJsonbArray(ImmutableList.of("{\"key\": \"value1\"}}", "{\"key\": \"value2\"}"))
        .set("pgJsonbArrNull")
        .toPgJsonbArray(null)
        .set("pgJsonbArrValue")
        .to(Value.pgJsonbArray(ImmutableList.of("{\"key\": \"value1\"}}", "{\"key\": \"value2\"}")))
        .set("pgOidArr")
        .toPgOidArray(new long[] {1, 2, 3})
        .set("pgOidArrNull")
        .toPgOidArray((long[]) null)
        .set("pgOidArrValue")
        .to(Value.pgOidArray(ImmutableList.of(1L, 2L)))
        .set("timestampArr")
        .toTimestampArray(ImmutableList.of(Timestamp.MAX_VALUE, Timestamp.MAX_VALUE))
        .set("timestampArrNull")
        .toTimestampArray(null)
        .set("timestampArrValue")
        .to(Value.timestampArray(ImmutableList.of(Timestamp.MIN_VALUE, Timestamp.MAX_VALUE)))
        .set("dateArr")
        .toDateArray(
            ImmutableList.of(
                Date.fromYearMonthDay(2017, 4, 17), Date.fromYearMonthDay(2017, 4, 18)))
        .set("dateArrNull")
        .toDateArray(null)
        .set("dateArrValue")
        .to(
            Value.dateArray(
                ImmutableList.of(
                    Date.fromYearMonthDay(2021, 1, 2), Date.fromYearMonthDay(2022, 2, 3))));
  }

  static Matcher<com.google.spanner.v1.Mutation> matchesProto(String expected) {
    return SpannerMatchers.matchesProto(com.google.spanner.v1.Mutation.class, expected);
  }
}
