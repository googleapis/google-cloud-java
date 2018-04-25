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

import com.google.api.core.ApiFunction;
import com.google.common.testing.EqualsTester;
import java.util.Arrays;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

public class StringEnumTest {

  @Rule
  public ExpectedException expectedException = ExpectedException.none();

  public static class Letter extends StringEnumValue {
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

    private static final StringEnumType<Letter> type = new StringEnumType(
        Letter.class,
        CONSTRUCTOR);

    public static final Letter A = type.createAndRegister("A");
    public static final Letter B = type.createAndRegister("B");
    public static final Letter C = type.createAndRegister("C");

    public static Letter valueOfStrict(String constant) {
      return type.valueOfStrict(constant);
    }

    /**
     * Get the StorageClass for the given String constant, and allow unrecognized values.
     */
    public static Letter valueOf(String constant) {
      return type.valueOf(constant);
    }

    /**
     * Return the known values for StorageClass.
     */
    public static Letter[] values() {
      return type.values();
    }
  }

  @Test
  public void testNullClass() {
    expectedException.expect(NullPointerException.class);
    new StringEnumType<Letter>(null, Letter.CONSTRUCTOR);
  }

  @Test
  public void testNullConstructor() {
    expectedException.expect(NullPointerException.class);
    new StringEnumType<Letter>(Letter.class, null);
  }

  @Test
  public void testEnumInstances() {
    assertThat(Letter.A.toString()).isEqualTo("A");
  }

  @Test
  public void testValueOf() {
    assertThat(Letter.valueOf("A")).isSameAs(Letter.A);
    assertThat(Letter.valueOf("B")).isSameAs(Letter.B);
    assertThat(Letter.valueOf("C")).isSameAs(Letter.C);
    assertThat(Letter.valueOf("NonExistentLetter").toString()).isEqualTo("NonExistentLetter");
  }

  @Test
  public void testValueOfStrict() {
    assertThat(Letter.valueOfStrict("A")).isSameAs(Letter.A);
    assertThat(Letter.valueOfStrict("B")).isSameAs(Letter.B);
    assertThat(Letter.valueOfStrict("C")).isSameAs(Letter.C);
  }

  @Test
  public void testEquals() {
    EqualsTester tester = new EqualsTester();

    tester.addEqualityGroup(Letter.A, Letter.valueOf("A"), Letter.valueOfStrict("A"));
    tester.addEqualityGroup(Letter.B, Letter.valueOf("B"), Letter.valueOfStrict("B"));
    tester.addEqualityGroup(Letter.C, Letter.valueOf("C"), Letter.valueOfStrict("C"));
    tester
        .addEqualityGroup(Letter.valueOf("NonExistentLetter"), Letter.valueOf("NonExistentLetter"));
  }

  @Test
  public void testValueOfStrict_invalid() {
    expectedException.expect(IllegalArgumentException.class);
    Letter.valueOfStrict("NonExistentLetter");
  }

  @Test
  public void testValues() {
    assertThat(
        Arrays.asList(Letter.values()).containsAll(Arrays.asList(Letter.A, Letter.B, Letter.C)));
  }
}
