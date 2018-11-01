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

import com.google.common.testing.EqualsTester;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;

/** Unit tests for {@link com.google.cloud.spanner.Struct}. */
@RunWith(JUnit4.class)
public class StructTest {

  @Rule public ExpectedException expectedException = ExpectedException.none();

  @Test
  public void builder() {
    // These tests are basic: AbstractStructReaderTypesTest already covers all type getters.
    Struct struct =
        Struct.newBuilder()
            .set("f1")
            .to("x")
            .set("f2")
            .to(2)
            .set("f3")
            .to(Value.bool(null))
            .build();
    assertThat(struct.getType())
        .isEqualTo(
            Type.struct(
                Type.StructField.of("f1", Type.string()),
                Type.StructField.of("f2", Type.int64()),
                Type.StructField.of("f3", Type.bool())));
    assertThat(struct.isNull(0)).isFalse();
    assertThat(struct.isNull(1)).isFalse();
    assertThat(struct.isNull(2)).isTrue();
    assertThat(struct.getString(0)).isEqualTo("x");
    assertThat(struct.getLong(1)).isEqualTo(2);
  }

  @Test
  public void duplicateFields() {
    // Duplicate fields are allowed - some SQL queries produce this type of value.
    Struct struct = Struct.newBuilder().set("").to("x").set("").to(Value.int64(2)).build();
    assertThat(struct.getType())
        .isEqualTo(
            Type.struct(
                Type.StructField.of("", Type.string()), Type.StructField.of("", Type.int64())));
    assertThat(struct.isNull(0)).isFalse();
    assertThat(struct.isNull(1)).isFalse();
    assertThat(struct.getString(0)).isEqualTo("x");
    assertThat(struct.getLong(1)).isEqualTo(2);
  }

  @Test
  public void unnamedFields() {
    Struct struct = Struct.newBuilder().add(Value.int64(2)).add(Value.int64(3)).build();
    assertThat(struct.getType())
        .isEqualTo(
            Type.struct(
                Type.StructField.of("", Type.int64()), Type.StructField.of("", Type.int64())));
    assertThat(struct.getLong(0)).isEqualTo(2);
    assertThat(struct.getLong(1)).isEqualTo(3);
  }

  @Test
  public void structWithStructField() {
    Struct nestedStruct = Struct.newBuilder().set("f2f1").to(10).build();
    Struct struct =
        Struct.newBuilder()
            .set("f1")
            .to("v1")
            .set("f2")
            .to(nestedStruct)
            .set("f3")
            .to(nestedStruct.getType(), null)
            .build();
    assertThat(struct.getType())
        .isEqualTo(
            Type.struct(
                Type.StructField.of("f1", Type.string()),
                Type.StructField.of("f2", Type.struct(Type.StructField.of("f2f1", Type.int64()))),
                Type.StructField.of("f3", Type.struct(Type.StructField.of("f2f1", Type.int64())))));
    assertThat(struct.isNull(0)).isFalse();
    assertThat(struct.isNull(1)).isFalse();
    assertThat(struct.isNull(2)).isTrue();
    assertThat(struct.getString(0)).isEqualTo("v1");
    assertThat(struct.getString("f1")).isEqualTo("v1");
    assertThat(struct.getStruct(1)).isEqualTo(nestedStruct);
    assertThat(struct.getStruct("f2")).isEqualTo(nestedStruct);
  }

  @Test
  public void structWithArrayOfStructField() {
    Type elementType =
        Type.struct(
            Arrays.asList(
                Type.StructField.of("ff1", Type.string()),
                Type.StructField.of("ff2", Type.int64())));
    List<Struct> arrayElements =
        Arrays.asList(
            Struct.newBuilder().set("ff1").to("v1").set("ff2").to(1).build(),
            Struct.newBuilder().set("ff1").to("v1").set("ff2").to(1).build());
    Struct struct =
        Struct.newBuilder()
            .set("f1")
            .to("x")
            .set("f2")
            .toStructArray(elementType, arrayElements)
            .build();
    assertThat(struct.getType())
        .isEqualTo(
            Type.struct(
                Type.StructField.of("f1", Type.string()),
                Type.StructField.of("f2", Type.array(elementType))));
    assertThat(struct.isNull(0)).isFalse();
    assertThat(struct.isNull(1)).isFalse();
    assertThat(struct.getString(0)).isEqualTo("x");
    assertThat(struct.getStructList(1)).isEqualTo(arrayElements);
  }

  @Test
  public void equalsAndHashCode() {
    EqualsTester tester = new EqualsTester();
    tester.addEqualityGroup(
        Struct.newBuilder().set("x").to(1).build(),
        Struct.newBuilder().set("x").to(Value.int64(1)).build());
    tester.addEqualityGroup(Struct.newBuilder().set("x").to((Long) null).build());
    tester.addEqualityGroup(Struct.newBuilder().set("x").to((String) null).build());
    tester.addEqualityGroup(Struct.newBuilder().set("x").to(1).set("y").to(2).build());
    tester.addEqualityGroup(Struct.newBuilder().set("x").to(1).set("y").to("2").build());
    tester.addEqualityGroup(Struct.newBuilder().set("y").to(2).set("x").to(1).build());

    // Equality comparison with empty structs.
    tester.addEqualityGroup(Struct.newBuilder().build(), Struct.newBuilder().build());

    // Equality comparison with structs with struct-typed fields.
    Struct nestedStruct = Struct.newBuilder().set("f").to(1).build();
    Struct structFieldStruct1 =
        Struct.newBuilder()
            .set("sf")
            .to(nestedStruct)
            .set("nullsf")
            .to(nestedStruct.getType(), null)
            .build();
    Struct structFieldStruct2 =
        Struct.newBuilder()
            .set("sf")
            .to(Value.struct(nestedStruct))
            .set("nullsf")
            .to(Value.struct(nestedStruct.getType(), null))
            .build();
    tester.addEqualityGroup(structFieldStruct1, structFieldStruct2);

    // Equality comparison with array-of-struct typed fields.
    Struct arrayStructFieldStruct1 =
        Struct.newBuilder()
            .set("arraysf")
            .toStructArray(nestedStruct.getType(), Arrays.asList(null, nestedStruct))
            .set("nullarraysf")
            .toStructArray(nestedStruct.getType(), null)
            .build();
    Struct arrayStructFieldStruct2 =
        Struct.newBuilder()
            .set("arraysf")
            .to(Value.structArray(nestedStruct.getType(), Arrays.asList(null, nestedStruct)))
            .set("nullarraysf")
            .to(Value.structArray(nestedStruct.getType(), null))
            .build();
    tester.addEqualityGroup(arrayStructFieldStruct1, arrayStructFieldStruct2);

    // Equality comparison of structs with duplicate fields.
    Struct duplicateFieldStruct1 =
        Struct.newBuilder().set("f1").to(3).set("f1").to(nestedStruct).build();
    Struct duplicateFieldStruct2 =
        Struct.newBuilder()
            .set("f1")
            .to(Value.int64(3))
            .set("f1")
            .to(Value.struct(nestedStruct))
            .build();
    tester.addEqualityGroup(duplicateFieldStruct1, duplicateFieldStruct2);

    // Equality comparison of structs with unnamed fields.
    Struct emptyFieldStruct1 = Struct.newBuilder().set("").to(3).set("").to(nestedStruct).build();
    Struct emptyFieldStruct2 =
        Struct.newBuilder().add(Value.int64(3)).add(Value.struct(nestedStruct)).build();
    tester.addEqualityGroup(emptyFieldStruct1, emptyFieldStruct2);

    tester.testEquals();
  }

  @Test
  public void serialization() {
    // Simple struct.
    Struct simpleStruct = Struct.newBuilder().set("x").to(1).build();
    reserializeAndAssert(simpleStruct);
    simpleStruct = Struct.newBuilder().set("x").to((Long) null).build();
    reserializeAndAssert(simpleStruct);

    // Struct with struct field.
    Struct structFieldStruct = Struct.newBuilder().set("f1").to(simpleStruct).build();
    reserializeAndAssert(structFieldStruct);
    structFieldStruct = Struct.newBuilder().set("f1").to(simpleStruct.getType(), null).build();
    reserializeAndAssert(structFieldStruct);

    // Struct with array-of-struct field
    Struct arrayStructFieldStruct =
        Struct.newBuilder()
            .set("f1")
            .toStructArray(simpleStruct.getType(), new ArrayList<Struct>())
            .build();
    reserializeAndAssert(arrayStructFieldStruct);
    arrayStructFieldStruct =
        Struct.newBuilder().set("f1").toStructArray(simpleStruct.getType(), null).build();
    reserializeAndAssert(arrayStructFieldStruct);

    // Struct with no field.
    reserializeAndAssert(Struct.newBuilder().build());

    // Struct with duplicate field names.
    reserializeAndAssert(Struct.newBuilder().set("f1").to(3).set("f1").to(30).build());

    // Struct with unnamed fields.
    reserializeAndAssert(Struct.newBuilder().add(Value.int64(3)).add(Value.int64(30)).build());
  }
}
