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
package com.google.cloud.bigtable.data.v2.wrappers;

import static com.google.common.truth.Truth.assertThat;

import com.google.protobuf.ByteString;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;

@RunWith(JUnit4.class)
public class RangeTest {
  @Test
  public void utf8StringsTest() {
    Range<ByteString> range = Range.ofUtf8ByteStrings("begin", "end");

    assertThat(range.getStart()).isEqualTo(ByteString.copyFromUtf8("begin"));
    assertThat(range.getEnd()).isEqualTo(ByteString.copyFromUtf8("end"));
  }

  @Test
  public void changeStartTest() {
    Range<ByteString> range =
        Range.ofUtf8ByteStrings("begin", "end").withStart(ByteString.copyFromUtf8("begin2"));

    assertThat(range.getStart()).isEqualTo(ByteString.copyFromUtf8("begin2"));
    assertThat(range.getEnd()).isEqualTo(ByteString.copyFromUtf8("end"));
  }

  @Test
  public void changeEndTest() {
    Range<Integer> range = Range.of(10, 20).withEnd(30);

    assertThat(range.getStart()).isEqualTo(10);
    assertThat(range.getEnd()).isEqualTo(30);
  }
}
