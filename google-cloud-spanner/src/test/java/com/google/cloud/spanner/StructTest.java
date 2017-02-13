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

import com.google.common.testing.EqualsTester;
import java.util.Arrays;
import java.util.List;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;

/** Unit tests for {@link com.google.cloud.spanner.Struct}. */
@RunWith(JUnit4.class)
public class StructTest {
  @Test
  public void builder() {
    // These tests are basic: AbstractStructReaderTypesTest already covers all type getters.
    Struct struct =
        Struct.newBuilder().set("f1").to("x").set("f2").to(2).add("f3", Value.bool(null)).build();
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
    Struct struct = Struct.newBuilder().set("").to("x").add("", Value.int64(2)).build();
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
  public void structWithArrayOfStructField() {
    List<Type.StructField> fieldTypes =
        Arrays.asList(
            Type.StructField.of("ff1", Type.string()), Type.StructField.of("ff2", Type.int64()));
    List<Struct> arrayElements =
        Arrays.asList(
            Struct.newBuilder().set("ff1").to("v1").set("ff2").to(1).build(),
            Struct.newBuilder().set("ff1").to("v1").set("ff2").to(1).build());
    Struct struct =
        Struct.newBuilder().set("f1").to("x").add("f2", fieldTypes, arrayElements).build();
    assertThat(struct.getType())
        .isEqualTo(
            Type.struct(
                Type.StructField.of("f1", Type.string()),
                Type.StructField.of("f2", Type.array(Type.struct(fieldTypes)))));
    assertThat(struct.isNull(0)).isFalse();
    assertThat(struct.isNull(1)).isFalse();
    assertThat(struct.getString(0)).isEqualTo("x");
    assertThat(struct.getStructList(1)).isEqualTo(arrayElements);
  }

  @Test
  public void equalsAndHashCode() {
    EqualsTester tester = new EqualsTester();
    tester.addEqualityGroup(Struct.newBuilder().build(), Struct.newBuilder().build());
    tester.addEqualityGroup(
        Struct.newBuilder().set("x").to(1).build(),
        Struct.newBuilder().add("x", Value.int64(1)).build());
    tester.addEqualityGroup(Struct.newBuilder().set("x").to((Long) null).build());
    tester.addEqualityGroup(Struct.newBuilder().set("x").to((String) null).build());
    tester.addEqualityGroup(Struct.newBuilder().set("x").to(1).set("y").to(2).build());
    tester.addEqualityGroup(Struct.newBuilder().set("x").to(1).set("y").to("2").build());
    tester.addEqualityGroup(Struct.newBuilder().set("y").to(2).set("x").to(1).build());
    tester.testEquals();
  }
}
