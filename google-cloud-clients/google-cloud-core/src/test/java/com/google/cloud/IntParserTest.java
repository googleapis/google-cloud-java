/*
 * Copyright 2019 Google LLC
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
import static org.junit.Assert.fail;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;

@RunWith(JUnit4.class)
public class IntParserTest {

  @Test
  public void testParse() {
    assertThat(IntParser.parseInt("1", 0, 1)).isEqualTo(1);
    assertThat(IntParser.parseInt("1234", 0, 4)).isEqualTo(1234);
    assertThat(IntParser.parseInt("1234", 2, 4)).isEqualTo(34);
    assertThat(IntParser.parseInt("1234", 0, 2)).isEqualTo(12);
    assertThat(IntParser.parseInt("1234567890", 0, 10)).isEqualTo(1234567890);
    assertThat(IntParser.parseInt("1234567890", 1, 10)).isEqualTo(234567890);
    assertThat(IntParser.parseInt("0123456789", 0, 10)).isEqualTo(123456789);
    assertThat(IntParser.parseInt("00001234", 0, 8)).isEqualTo(1234);
    assertThat(IntParser.parseInt("", 0, 0)).isEqualTo(0);
    parseInvalidNumber("test", 0, 4);
    parseInvalidNumber("123T456", 0, 4);
    parseInvalidArgument("", 0, 1);
    parseInvalidArgument("1234", 0, 5);
    parseInvalidArgument("1234", -1, 4);
    parseInvalidArgument("1234", 3, 2);
    // Roman literal 50 is a valid numeric character, but not a decimal digit.
    char c = '\u216C';
    int val = Character.getNumericValue(c);
    assertThat(val).isEqualTo(50);
    parseInvalidArgument(String.valueOf(c), 0, 1);
  }

  private void parseInvalidNumber(String input, int begin, int end) {
    try {
      IntParser.parseInt(input, begin, end);
      fail("Expected exception");
    } catch (NumberFormatException e) {
    }
  }

  private void parseInvalidArgument(String input, int begin, int end) {
    try {
      IntParser.parseInt(input, begin, end);
      fail("Expected exception");
    } catch (IllegalArgumentException e) {
    }
  }
}
