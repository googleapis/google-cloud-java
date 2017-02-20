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

import com.google.cloud.ByteArray;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;

/** Unit tests for {@link ByteArrays}. */
@RunWith(JUnit4.class)
public class ByteArraysTest {
  @Test
  public void toStringMethod() {
    assertThat(ByteArrays.toString(ByteArray.copyFrom(new byte[] {'a', 'b'}))).isEqualTo("ab");
    byte[] data = new byte[] {'x', 0, 30, 32, 126, 127, -1, 'y'};
    assertThat(ByteArrays.toString(ByteArray.copyFrom(data))).isEqualTo("x\\0\\36 ~\\177\\377y");
  }

  @Test
  public void toStringMaxLength() {
    assertThat(ByteArrays.toString(ByteArray.copyFrom(new byte[] {}), 0)).isEqualTo("");
    assertThat(ByteArrays.toString(ByteArray.copyFrom(new byte[] {}), 10)).isEqualTo("");

    // Even small max lengths will never produce a longer string due to the ellipsis.
    assertThat(ByteArrays.toString(ByteArray.copyFrom(new byte[] {'0', '1'}), 0)).isEqualTo("01");
    assertThat(ByteArrays.toString(ByteArray.copyFrom(new byte[] {'0', '1'}), 2)).isEqualTo("01");
    assertThat(ByteArrays.toString(ByteArray.copyFrom(new byte[] {'0', '1', '2'}), 3))
        .isEqualTo("012");
    assertThat(ByteArrays.toString(ByteArray.copyFrom(new byte[] {'0', '1', '2', '3'}), 3))
        .isEqualTo("...");
    assertThat(ByteArrays.toString(ByteArray.copyFrom(new byte[] {'0', '1', '2', '3'}), 4))
        .isEqualTo("0123");
    assertThat(ByteArrays.toString(ByteArray.copyFrom(new byte[] {'0', '1', '2', '3', '4'}), 3))
        .isEqualTo("...");
    assertThat(ByteArrays.toString(ByteArray.copyFrom(new byte[] {'0', '1', '2', '3', '4'}), 4))
        .isEqualTo("0...");
    assertThat(
            ByteArrays.toString(ByteArray.copyFrom(new byte[] {'0', '1', '2', '3', '4', '5'}), 5))
        .isEqualTo("01...");
    assertThat(
            ByteArrays.toString(ByteArray.copyFrom(new byte[] {'0', '1', '2', '3', '4', '5'}), 99))
        .isEqualTo("012345");

    // Escaped length should be considered.
    byte[] data2 = new byte[] {'x', -1, 'x'};
    assertThat(ByteArrays.toString(ByteArray.copyFrom(data2), 6)).isEqualTo("x\\377x");
    byte[] data1 = new byte[] {'x', -1, 'x'};
    assertThat(ByteArrays.toString(ByteArray.copyFrom(data1), 5)).isEqualTo("x...");
    byte[] data = new byte[] {'x', -1, 'x'};
    assertThat(ByteArrays.toString(ByteArray.copyFrom(data), 3)).isEqualTo("...");
  }
}
