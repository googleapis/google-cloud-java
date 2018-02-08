/*
 * Copyright 2018 Google LLC
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     https://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package com.google.cloud.bigtable.data.v2.internal;

import static com.google.common.truth.Truth.assertThat;

import com.google.protobuf.ByteString;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;

@RunWith(JUnit4.class)
public class RegexUtilTest {
  @Test
  public void literalRegexPassthroughTest() {
    ByteString input = ByteString.copyFromUtf8("hi");
    ByteString actual = RegexUtil.literalRegex(input);

    assertThat(actual).isEqualTo(input);
  }

  @Test
  public void literalRegexEscapeTest() {
    ByteString input = ByteString.copyFromUtf8("h.*i");
    ByteString actual = RegexUtil.literalRegex(input);
    ByteString expected = ByteString.copyFromUtf8("h\\.\\*i");

    assertThat(actual).isEqualTo(expected);
  }

  @Test
  public void literalRegexEscapeBytes() {
    ByteString input = ByteString.copyFrom(new byte[] {(byte) 0xe2, (byte) 0x80, (byte) 0xb3});
    ByteString actual = RegexUtil.literalRegex(input);

    assertThat(actual).isEqualTo(input);
  }
}
