/*
 * Copyright 2024 Google LLC
 *
 * Redistribution and use in source and binary forms, with or without
 * modification, are permitted provided that the following conditions are
 * met:
 *
 *     * Redistributions of source code must retain the above copyright
 * notice, this list of conditions and the following disclaimer.
 *     * Redistributions in binary form must reproduce the above
 * copyright notice, this list of conditions and the following disclaimer
 * in the documentation and/or other materials provided with the
 * distribution.
 *     * Neither the name of Google LLC nor the names of its
 * contributors may be used to endorse or promote products derived from
 * this software without specific prior written permission.
 *
 * THIS SOFTWARE IS PROVIDED BY THE COPYRIGHT HOLDERS AND CONTRIBUTORS
 * "AS IS" AND ANY EXPRESS OR IMPLIED WARRANTIES, INCLUDING, BUT NOT
 * LIMITED TO, THE IMPLIED WARRANTIES OF MERCHANTABILITY AND FITNESS FOR
 * A PARTICULAR PURPOSE ARE DISCLAIMED. IN NO EVENT SHALL THE COPYRIGHT
 * OWNER OR CONTRIBUTORS BE LIABLE FOR ANY DIRECT, INDIRECT, INCIDENTAL,
 * SPECIAL, EXEMPLARY, OR CONSEQUENTIAL DAMAGES (INCLUDING, BUT NOT
 * LIMITED TO, PROCUREMENT OF SUBSTITUTE GOODS OR SERVICES; LOSS OF USE,
 * DATA, OR PROFITS; OR BUSINESS INTERRUPTION) HOWEVER CAUSED AND ON ANY
 * THEORY OF LIABILITY, WHETHER IN CONTRACT, STRICT LIABILITY, OR TORT
 * (INCLUDING NEGLIGENCE OR OTHERWISE) ARISING IN ANY WAY OUT OF THE USE
 * OF THIS SOFTWARE, EVEN IF ADVISED OF THE POSSIBILITY OF SUCH DAMAGE.
 */
package com.google.api.gax.util;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;

import java.util.function.Function;

public class TimeConversionTestUtils {

  /**
   * Confirms that the behavior of getters and setters of an Instant property (both {@link
   * java.time.Instant} and {@link org.threeten.bp.Instant}) is the same.
   *
   * @param testValue the value in millis to be tested
   * @param javaTimeTargetSupplier a supplier of a {@link Target} that is created using an {@link
   *     java.time.Instant}
   * @param threetenTargetSupplier a supplier of a {@link Target} that is created using an {@link
   *     org.threeten.bp.Instant}
   * @param javaTimeGetter a getter of the {@link java.time.Instant} obtained from the instance of
   *     {@link Target}
   * @param threetenGetter a getter of the {{@link org.threeten.bp.Instant} obtained from the
   *     instance of {@link Target}
   * @param <Target> the type of the target containing the Instant property
   */
  public static <Target> void testInstantMethod(
      Long testValue,
      Function<java.time.Instant, Target> javaTimeTargetSupplier,
      Function<org.threeten.bp.Instant, Target> threetenTargetSupplier,
      Function<Target, java.time.Instant> javaTimeGetter,
      Function<Target, org.threeten.bp.Instant> threetenGetter) {
    Function<java.time.Instant, Long> javaTimeTester = value -> value.toEpochMilli();
    Function<org.threeten.bp.Instant, Long> threetenTester = value -> value.toEpochMilli();
    java.time.Instant javaTimeSupplierValue =
        testValue == null ? null : java.time.Instant.ofEpochMilli(testValue);
    org.threeten.bp.Instant threetenSupplierValue =
        testValue == null ? null : org.threeten.bp.Instant.ofEpochMilli(testValue);
    testTimeObjectMethod(
        testValue,
        javaTimeSupplierValue,
        javaTimeTargetSupplier,
        javaTimeGetter,
        threetenGetter,
        javaTimeTester,
        threetenTester);
    testTimeObjectMethod(
        testValue,
        threetenSupplierValue,
        threetenTargetSupplier,
        javaTimeGetter,
        threetenGetter,
        javaTimeTester,
        threetenTester);
  }

  /**
   * Confirms that the behavior of getters and setters of a Duration property (both {@link
   * java.time.Duration} and {@link org.threeten.bp.Duration}) is the same.
   *
   * @param testValue the value in millis to be tested
   * @param javaTimeTargetSupplier a supplier of a {@link Target} that is created using an {@link
   *     java.time.Duration}
   * @param threetenTargetSupplier a supplier of a {@link Target} that is created using an {@link
   *     org.threeten.bp.Duration}
   * @param javaTimeGetter a getter of the {@link java.time.Duration} obtained from the instance of
   *     {@link Target}
   * @param threetenGetter a getter of the {{@link org.threeten.bp.Duration} obtained from the
   *     instance of {@link Target}
   * @param <Target> the type of the target containing the Duration property
   */
  public static <Target> void testDurationMethod(
      Long testValue,
      Function<java.time.Duration, Target> javaTimeTargetSupplier,
      Function<org.threeten.bp.Duration, Target> threetenTargetSupplier,
      Function<Target, java.time.Duration> javaTimeGetter,
      Function<Target, org.threeten.bp.Duration> threetenGetter) {
    Function<java.time.Duration, Long> javaTimeTester = value -> value.toMillis();
    Function<org.threeten.bp.Duration, Long> threetenTester = value -> value.toMillis();
    java.time.Duration javaTimeSupplierValue =
        testValue == null ? null : java.time.Duration.ofMillis(testValue);
    org.threeten.bp.Duration threetenSupplierValue =
        testValue == null ? null : org.threeten.bp.Duration.ofMillis(testValue);
    testTimeObjectMethod(
        testValue,
        javaTimeSupplierValue,
        javaTimeTargetSupplier,
        javaTimeGetter,
        threetenGetter,
        javaTimeTester,
        threetenTester);
    testTimeObjectMethod(
        testValue,
        threetenSupplierValue,
        threetenTargetSupplier,
        javaTimeGetter,
        threetenGetter,
        javaTimeTester,
        threetenTester);
  }

  /**
   * Contains the common implementation of {@link #testInstantMethod(Long, Function, Function,
   * Function, Function)} and {@link #testDurationMethod(Long, Function, Function, Function,
   * Function)} and performs the corresponding assertions.
   */
  private static <Target, Threeten, JavaTime, SupplierType> void testTimeObjectMethod(
      Long testValue,
      SupplierType targetSupplierValue,
      Function<SupplierType, Target> targetSupplier,
      Function<Target, JavaTime> javaTimeGetter,
      Function<Target, Threeten> threetenGetter,
      Function<JavaTime, Long> javaTimeTester,
      Function<Threeten, Long> threetenTester) {
    Target target = targetSupplier.apply(targetSupplierValue);
    JavaTime javaTimeValue = javaTimeGetter.apply(target);
    Threeten threetenValue = threetenGetter.apply(target);
    if (testValue == null) {
      assertNull(javaTimeValue);
      assertNull(threetenValue);
    } else {
      assertEquals(testValue.longValue(), javaTimeTester.apply(javaTimeValue).longValue());
      assertEquals(testValue.longValue(), threetenTester.apply(threetenValue).longValue());
    }
  }
}
