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
package com.google.cloud;

import static com.google.common.truth.Truth.assertThat;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertThrows;

import com.google.api.core.ApiFunction;
import com.google.common.testing.EqualsTester;
import java.util.Arrays;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class StringEnumTest {

  static class Letter extends StringEnumValue {
    private static final long serialVersionUID = -1717976087182628526L;

    private Letter(String constant) {
      super(constant);
    }

    private static final ApiFunction<String, Letter> CONSTRUCTOR =
        new ApiFunction<String, Letter>() {
          @Override
          public Letter apply(String constant) {
            return new Letter(constant);
          }
        };

    private static final StringEnumType<Letter> type =
        new StringEnumType(Letter.class, CONSTRUCTOR);

    public static final Letter A = type.createAndRegister("A");
    public static final Letter B = type.createAndRegister("B");
    public static final Letter C = type.createAndRegister("C");

    public static Letter valueOfStrict(String constant) {
      return type.valueOfStrict(constant);
    }

    /** Get the StorageClass for the given String constant, and allow unrecognized values. */
    public static Letter valueOf(String constant) {
      return type.valueOf(constant);
    }

    /** Return the known values for StorageClass. */
    public static Letter[] values() {
      return type.values();
    }
  }

  @Test
  void testNullClass() {
    assertThrows(
        NullPointerException.class, () -> new StringEnumType<Letter>(null, Letter.CONSTRUCTOR));
  }

  @Test
  void testNullConstructor() {
    try {
      new StringEnumType<Letter>(Letter.class, null);
      Assertions.fail();
    } catch (NullPointerException ex) {
      assertNull(ex.getMessage());
    }
  }

  @Test
  void testEnumInstances() {
    assertThat(Letter.A.toString()).isEqualTo("A");
  }

  @Test
  void testValueOf() {
    assertThat(Letter.valueOf("A")).isSameInstanceAs(Letter.A);
    assertThat(Letter.valueOf("B")).isSameInstanceAs(Letter.B);
    assertThat(Letter.valueOf("C")).isSameInstanceAs(Letter.C);
    assertThat(Letter.valueOf("NonExistentLetter").toString()).isEqualTo("NonExistentLetter");
  }

  @Test
  void testValueOfStrict() {
    assertThat(Letter.valueOfStrict("A")).isSameInstanceAs(Letter.A);
    assertThat(Letter.valueOfStrict("B")).isSameInstanceAs(Letter.B);
    assertThat(Letter.valueOfStrict("C")).isSameInstanceAs(Letter.C);
  }

  @Test
  void testEquals() {
    new EqualsTester()
        .addEqualityGroup(Letter.A, Letter.valueOf("A"), Letter.valueOfStrict("A"))
        .addEqualityGroup(Letter.B, Letter.valueOf("B"), Letter.valueOfStrict("B"))
        .addEqualityGroup(Letter.C, Letter.valueOf("C"), Letter.valueOfStrict("C"))
        .addEqualityGroup(Letter.valueOf("NonExistentLetter"), Letter.valueOf("NonExistentLetter"))
        .testEquals();
  }

  @Test
  void testValueOfStrict_invalid() {
    try {
      Letter.valueOfStrict("NonExistentLetter");
      Assertions.fail();
    } catch (IllegalArgumentException ex) {
      assertNotNull(ex.getMessage());
    }
  }

  @Test
  void testValues() {
    assertThat(
            Arrays.asList(Letter.values()).containsAll(Arrays.asList(Letter.A, Letter.B, Letter.C)))
        .isTrue();
  }
}
