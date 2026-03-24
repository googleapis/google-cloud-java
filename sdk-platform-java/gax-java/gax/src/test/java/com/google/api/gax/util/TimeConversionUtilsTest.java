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

import org.junit.jupiter.api.Test;

public class TimeConversionUtilsTest {

  // 0.999999999 seconds (1 second - 1 nano) - we need to subtract the nano or the Duration would
  // overflow otherwise
  final long MAX_DURATION_NANOS =
      1 * 1000 /*=1 micro*/ * 1000 /*=1 milli*/ * 1000 /*=1 second*/ - 1;

  // Arbitrary durations/instants to confirm conversion works as expected
  final org.threeten.bp.Duration ttDuration = org.threeten.bp.Duration.ofMillis(123);
  final org.threeten.bp.Instant ttInstant = org.threeten.bp.Instant.ofEpochMilli(123);
  final java.time.Duration jtDuration = java.time.Duration.ofMillis(345);
  final java.time.Instant jtInstant = java.time.Instant.ofEpochMilli(345);

  @Test
  void testToJavaTimeDuration_validInput_succeeds() {
    assertEquals(
        ttDuration.toMillis(), TimeConversionUtils.toJavaTimeDuration(ttDuration).toMillis());
    assertNull(TimeConversionUtils.toJavaTimeDuration(null));
  }

  @Test
  void testToThreetenTimeDuration_validInput_succeeds() {
    assertEquals(
        jtDuration.toMillis(), TimeConversionUtils.toThreetenDuration(jtDuration).toMillis());
    assertNull(TimeConversionUtils.toThreetenDuration(null));
  }

  @Test
  void testToJavaTimeInstant_validInput_succeeds() {
    assertEquals(
        ttInstant.toEpochMilli(), TimeConversionUtils.toJavaTimeInstant(ttInstant).toEpochMilli());
    assertNull(TimeConversionUtils.toJavaTimeInstant(null));
  }

  @Test
  void testToThreetenTimeInstant_validInput_succeeds() {
    assertEquals(
        jtInstant.toEpochMilli(), TimeConversionUtils.toThreetenInstant(jtInstant).toEpochMilli());
    assertNull(TimeConversionUtils.toThreetenInstant(null));
  }

  @Test
  void testToThreeteenInstant_bigInput_doesNotOverflow() {
    // defaults to MAX_SECONDS plus the max value of long for the nanos part
    java.time.Instant jtInstant = java.time.Instant.MAX;
    org.threeten.bp.Instant ttInstant = TimeConversionUtils.toThreetenInstant(jtInstant);
    assertEquals(jtInstant.getEpochSecond(), ttInstant.getEpochSecond());
    assertEquals(jtInstant.getNano(), ttInstant.getNano());
  }

  @Test
  void testToJavaTimeInstant_bigInput_doesNotOverflow() {
    // defaults to MAX_SECONDS plus the max value of long for the nanos part
    org.threeten.bp.Instant ttInstant = org.threeten.bp.Instant.MAX;
    java.time.Instant jtInstant = TimeConversionUtils.toJavaTimeInstant(ttInstant);
    assertEquals(jtInstant.getEpochSecond(), ttInstant.getEpochSecond());
    assertEquals(jtInstant.getNano(), ttInstant.getNano());
  }

  @Test
  void testToThreeteenDuration_bigInput_doesNotOverflow() {
    // we use the max long value for the seconds part and an arbitrary int for the nanos part, so we
    // can confirm that both components are preserved
    java.time.Duration jtDuration =
        java.time.Duration.ofSeconds(Long.MAX_VALUE, MAX_DURATION_NANOS);
    org.threeten.bp.Duration ttDuration = TimeConversionUtils.toThreetenDuration(jtDuration);
    assertEquals(jtDuration.getSeconds(), ttDuration.getSeconds());
    assertEquals(jtDuration.getNano(), ttDuration.getNano());
  }

  @Test
  void testToJavaTimeDuration_bigInput_doesNotOverflow() {
    // we use the max long value for the seconds part and an arbitrary int for the nanos part, so we
    // can confirm that both components are preserved
    org.threeten.bp.Duration ttDuration =
        org.threeten.bp.Duration.ofSeconds(Long.MAX_VALUE, MAX_DURATION_NANOS);
    java.time.Duration jtDuration = TimeConversionUtils.toJavaTimeDuration(ttDuration);
    assertEquals(jtDuration.getSeconds(), ttDuration.getSeconds());
    assertEquals(jtDuration.getNano(), ttDuration.getNano());
  }
}
