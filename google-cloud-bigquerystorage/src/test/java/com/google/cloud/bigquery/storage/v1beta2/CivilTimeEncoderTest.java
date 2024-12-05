/*
 * Copyright 2021 Google LLC
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package com.google.cloud.bigquery.storage.v1beta2;

import static org.junit.Assert.assertEquals;

import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.logging.Logger;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;

@RunWith(JUnit4.class)
public class CivilTimeEncoderTest {
  private static final Logger LOG = Logger.getLogger(CivilTimeEncoderTest.class.getName());

  // Time
  @Test
  public void encodeAndDecodePacked64TimeMicros_validTime() {
    // 00:00:00.000000
    // 0b000000000000000000000000000|00000|000000|000000|00000000000000000000
    // 0x0
    assertEquals(
        0x0L, CivilTimeEncoder.encodePacked64TimeMicrosLocalTime(LocalTime.of(0, 0, 0, 0)));
    assertEquals(
        LocalTime.of(0, 0, 0, 0), CivilTimeEncoder.decodePacked64TimeMicrosLocalTime(0x0L));

    // 00:01:02.003000
    // 0b000000000000000000000000000|00000|000001|000010|00000000101110111000
    // 0x4200BB8
    assertEquals(
        0x4200BB8L,
        CivilTimeEncoder.encodePacked64TimeMicrosLocalTime(LocalTime.of(0, 1, 2, 3_000_000)));
    assertEquals(
        LocalTime.of(0, 1, 2, 3_000_000),
        CivilTimeEncoder.decodePacked64TimeMicrosLocalTime(0x4200BB8L));

    // 12:00:00.000000
    // 0b000000000000000000000000000|01100|000000|000000|00000000000000000000
    // 0xC00000000
    assertEquals(
        0xC00000000L,
        CivilTimeEncoder.encodePacked64TimeMicrosLocalTime(LocalTime.of(12, 0, 0, 0)));
    assertEquals(
        LocalTime.of(12, 0, 0, 0),
        CivilTimeEncoder.decodePacked64TimeMicrosLocalTime(0xC00000000L));

    // 13:14:15.016000
    // 0b000000000000000000000000000|01101|001110|001111|00000011111010000000
    // 0xD38F03E80
    assertEquals(
        0xD38F03E80L,
        CivilTimeEncoder.encodePacked64TimeMicrosLocalTime(LocalTime.of(13, 14, 15, 16_000_000)));
    assertEquals(
        LocalTime.of(13, 14, 15, 16_000_000),
        CivilTimeEncoder.decodePacked64TimeMicrosLocalTime(0xD38F03E80L));

    // 23:59:59.999000
    // 0b000000000000000000000000000|10111|111011|111011|11110011111001011000
    // 0x17EFBF3E58
    assertEquals(
        0x17EFBF3E58L,
        CivilTimeEncoder.encodePacked64TimeMicrosLocalTime(LocalTime.of(23, 59, 59, 999_000_000)));
    assertEquals(
        LocalTime.of(23, 59, 59, 999_000_000),
        CivilTimeEncoder.decodePacked64TimeMicrosLocalTime(0x17EFBF3E58L));
  }

  @Test
  public void encodePacked64TimeMicros_giveErrorWhenPrecisionIsLost() {
    try { // 00:00:00.000000999
      // 0b000000000000000000000000000|00000|000000|000000|00000000000000000000
      // 0x0
      assertEquals(
          0x0L, CivilTimeEncoder.encodePacked64TimeMicrosLocalTime(LocalTime.of(0, 0, 0, 999)));
      Assert.fail();
    } catch (IllegalArgumentException e) {
    }
  }

  @Test
  public void decodePacked64TimeMicros_invalidBitField_throwsIllegalArgumentException() {
    try {
      // 00:00:00.000000
      // 0b000000000000000000000000001|00000|000000|000000|00000000000000000000
      // 0x2000000000
      CivilTimeEncoder.decodePacked64TimeMicros(0x2000000000L);
      Assert.fail();
    } catch (IllegalArgumentException e) {
      assertEquals(null, e.getMessage());
    }
  }

  @Test
  public void decodePacked64TimeMicros_invalidMicroOfSecond_throwsIllegalArgumentException() {
    try {
      // 00:00:00.1000000
      // 0b000000000000000000000000000|00000|000000|000000|11110100001001000000
      // 0xF4240
      CivilTimeEncoder.decodePacked64TimeMicros(0xF4240L);
      Assert.fail();
    } catch (IllegalArgumentException e) {
      assertEquals(null, e.getMessage());
    }
  }

  @Test
  public void decodePacked64TimeMicros_invalidSecondOfMinute_throwsIllegalArgumentException() {
    try {
      // 00:00:60.000000
      // 0b000000000000000000000000000|00000|000000|111100|00000000000000000000
      // 0x3C00000
      CivilTimeEncoder.decodePacked64TimeMicros(0x3C00000L);
      Assert.fail();
    } catch (IllegalArgumentException e) {
      assertEquals("Invalid value for SecondOfMinute (valid values 0 - 59): 60", e.getMessage());
    }
  }

  @Test
  public void decodePacked64TimeMicros_invalidMinuteOfHour_throwsIllegalArgumentException() {
    try {
      // 00:60:00.000000
      // 0b000000000000000000000000000|00000|111100|000000|00000000000000000000
      // 0xF0000000
      CivilTimeEncoder.decodePacked64TimeMicros(0xF0000000L);
      Assert.fail();
    } catch (IllegalArgumentException expected) {
    }
  }

  @Test
  public void decodePacked64TimeMicros_invalidHourOfDay_throwsIllegalArgumentException() {
    try {
      // 24:00:00.000000
      // 0b000000000000000000000000000|11000|000000|000000|00000000000000000000
      // 0x1800000000
      CivilTimeEncoder.decodePacked64TimeMicros(0x1800000000L);
      Assert.fail();
    } catch (IllegalArgumentException e) {
      assertEquals("Invalid value for HourOfDay (valid values 0 - 23): 24", e.getMessage());
    }
  }

  // Date Time Tests
  @Test
  public void encodeAndDecodePacked64DatetimeMicros_validDateTime() {
    // 0001/01/01 00:00:00
    // 0b0000000000000000000000|00000000000001|0001|00001|00000|000000|000000
    // 0x4420000
    assertEquals(
        0x442000000000L,
        CivilTimeEncoder.encodePacked64DatetimeMicrosLocalDateTime(
            LocalDateTime.of(1, 1, 1, 0, 0, 0, 0)));
    assertEquals(
        LocalDateTime.of(1, 1, 1, 0, 0, 0, 0),
        CivilTimeEncoder.decodePacked64DatetimeMicrosLocalDateTime(0x442000000000L));

    // 0001/02/03 00:01:02
    // 0b0000000000000000000000|00000000000001|0010|00011|00000|000001|000010
    // 0x4860042
    assertEquals(
        0x486004200BB8L,
        CivilTimeEncoder.encodePacked64DatetimeMicrosLocalDateTime(
            LocalDateTime.of(1, 2, 3, 0, 1, 2, 3_000_000)));
    assertEquals(
        LocalDateTime.of(1, 2, 3, 0, 1, 2, 3_000_000),
        CivilTimeEncoder.decodePacked64DatetimeMicrosLocalDateTime(0x486004200BB8L));

    // 0001/01/01 12:00:00
    // 0b0000000000000000000000|00000000000001|0001|00001|01100|000000|000000
    // 0x442C000
    assertEquals(
        0x442C00000000L,
        CivilTimeEncoder.encodePacked64DatetimeMicrosLocalDateTime(
            LocalDateTime.of(1, 1, 1, 12, 0, 0, 0)));
    assertEquals(
        LocalDateTime.of(1, 1, 1, 12, 0, 0, 0),
        CivilTimeEncoder.decodePacked64DatetimeMicrosLocalDateTime(0x442C00000000L));

    // 0001/01/01 13:14:15
    // 0b0000000000000000000000|00000000000001|0001|00001|01101|001110|001111
    // 0x442D38F
    assertEquals(
        0x442D38F03E80L,
        CivilTimeEncoder.encodePacked64DatetimeMicrosLocalDateTime(
            LocalDateTime.of(1, 1, 1, 13, 14, 15, 16_000_000)));
    assertEquals(
        LocalDateTime.of(1, 1, 1, 13, 14, 15, 16_000_000),
        CivilTimeEncoder.decodePacked64DatetimeMicrosLocalDateTime(0x442D38F03E80L));

    // 9999/12/31 23:59:59
    // 0b0000000000000000000000|10011100001111|1100|11111|10111|111011|111011
    // 0x9C3F3F7EFB
    assertEquals(
        0x9C3F3F7EFBF3E58L,
        CivilTimeEncoder.encodePacked64DatetimeMicrosLocalDateTime(
            LocalDateTime.of(9999, 12, 31, 23, 59, 59, 999_000_000)));
    assertEquals(
        LocalDateTime.of(9999, 12, 31, 23, 59, 59, 999_000_000),
        CivilTimeEncoder.decodePacked64DatetimeMicrosLocalDateTime(0x9C3F3F7EFBF3E58L));
  }

  @Test
  public void encodePacked64DateTimeMicros_giveErrorWhenPrecisionIsLost() {
    // 0001/01/01 00:00:00.000000999
    // 0b0000000000000000000000|00000000000001|0001|00001|00000|000000|000000
    // 0x4420000
    try {
      CivilTimeEncoder.encodePacked64DatetimeMicrosLocalDateTime(
          LocalDateTime.of(1, 1, 1, 0, 0, 0, 999));
      Assert.fail();
    } catch (IllegalArgumentException e) {
    }
  }

  @Test
  public void encodePacked64DatetimeMicros_invalidYear_throwsIllegalArgumentException() {
    // 10000/01/01 00:00:00.000000
    // 0b00|10011100010000|0001|00001|00000|000000|000000|00000000000000000000
    // 0x9C4042000000000
    LocalDateTime dateTime = LocalDateTime.of(10000, 1, 1, 0, 0, 0, 0);
    try {
      CivilTimeEncoder.encodePacked64DatetimeMicrosLocalDateTime(dateTime);
      Assert.fail();
    } catch (IllegalArgumentException expected) {
    }
  }

  @Test
  public void decodePacked64DatetimeMicros_validBitFieldDatetimeMicros() {}

  @Test
  public void decodePacked64DatetimeMicros_invalidBitField() {
    try {
      // 0001/01/01 00:00:00
      // 0b0000000000000000000001|00000000000001|0001|00001|00000|000000|000000
      // 0x10004420000
      CivilTimeEncoder.decodePacked64DatetimeMicros(0x10004420000L);
      Assert.fail();
    } catch (IllegalArgumentException e) {
    }
  }

  @Test
  public void decodePacked64DatetimeMicros_invalidMicroOfSecond_throwsIllegalArgumentException() {
    try {
      // 0001/01/01 00:00:00.1000000
      // 0b00|00000000000001|0001|00001|00000|000000|000000|11110100001001000000
      // 0x4420000F4240
      CivilTimeEncoder.decodePacked64DatetimeMicros(0x4420000F4240L);
      Assert.fail();
    } catch (IllegalArgumentException expected) {
    }
  }

  @Test
  public void decodePacked64DatetimeMicros_invalidSecondOfMinute_throwsIllegalArgumentException() {
    try {
      // 0001/01/01 00:00:60.000000
      // 0b00|00000000000001|0001|00001|00000|000000|111100|00000000000000000000
      // 0x442003C00000
      CivilTimeEncoder.decodePacked64DatetimeMicros(0x442003C00000L);
      Assert.fail();
    } catch (IllegalArgumentException expected) {
    }
  }

  @Test
  public void decodePacked64DatetimeMicros_invalidMinuteOfHour_throwsIllegalArgumentException() {
    try {
      // 0001/01/01 00:60:00.000000
      // 0b00|00000000000001|0001|00001|00000|111100|000000|00000000000000000000
      // 0x4420F0000000
      CivilTimeEncoder.decodePacked64DatetimeMicros(0x4420F0000000L);
      Assert.fail();
    } catch (IllegalArgumentException expected) {
    }
  }

  @Test
  public void decodePacked64DatetimeMicros_invalidHourOfDay_throwsIllegalArgumentException() {
    try {
      // 0001/01/01 24:00:00.000000
      // 0b00|00000000000001|0001|00001|11000|000000|000000|00000000000000000000
      // 0x443800000000
      CivilTimeEncoder.decodePacked64DatetimeMicros(0x443800000000L);
      Assert.fail();
    } catch (IllegalArgumentException expected) {
    }
  }

  @Test
  public void decodePacked64DatetimeMicros_invalidDayOfMonth_throwsIllegalArgumentException() {
    try {
      // 0001/01/00 00:00:00.000000
      // 0b00|00000000000001|0001|00000|00000|000000|000000|00000000000000000000
      // 0x440000000000
      CivilTimeEncoder.decodePacked64DatetimeMicros(0x440000000000L);
      Assert.fail();
    } catch (IllegalArgumentException expected) {
    }
  }

  @Test
  public void decodePacked64DatetimeMicros_invalidMonthOfYear_throwsIllegalArgumentException() {
    try {
      // 0001/13/01 00:00:00.000000
      // 0b00|00000000000001|1101|00001|00000|000000|000000|00000000000000000000
      // 0x742000000000
      CivilTimeEncoder.decodePacked64DatetimeMicros(0x742000000000L);
      Assert.fail();
    } catch (IllegalArgumentException expected) {
    }
  }

  @Test
  public void decodePacked64DatetimeMicros_invalidYear_throwsIllegalArgumentException() {
    try {
      // 10000/01/01 00:00:00.000000
      // 0b00|10011100010000|0001|00001|00000|000000|000000|00000000000000000000
      // 0x9C4042000000000
      CivilTimeEncoder.decodePacked64DatetimeMicros(0x9C4042000000000L);
      Assert.fail();
    } catch (IllegalArgumentException expected) {
    }
  }
}
