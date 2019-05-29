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

import com.google.common.truth.Truth;
import com.google.protobuf.ByteString;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;

@RunWith(JUnit4.class)
public class ByteStringComparatorTest {
  @Test
  public void emptyTest() {
    int result = ByteStringComparator.INSTANCE.compare(ByteString.EMPTY, ByteString.EMPTY);

    Truth.assertThat(result).isEqualTo(0);
  }

  @Test
  public void equalTest() {
    int result =
        ByteStringComparator.INSTANCE.compare(
            ByteString.copyFromUtf8("a"), ByteString.copyFromUtf8("a"));

    Truth.assertThat(result).isEqualTo(0);
  }

  @Test
  public void unequalTest() {
    ByteString a = ByteString.copyFromUtf8("a");
    ByteString b = ByteString.copyFromUtf8("b");

    Truth.assertThat(ByteStringComparator.INSTANCE.compare(a, b)).isEqualTo("a".compareTo("b"));
    Truth.assertThat(ByteStringComparator.INSTANCE.compare(b, a)).isEqualTo("b".compareTo("a"));
  }

  @Test
  public void lengthTest() {
    ByteString a = ByteString.copyFromUtf8("a");
    ByteString a_ = ByteString.copyFromUtf8("b").concat(ByteString.copyFrom(new byte[] {0}));

    Truth.assertThat(ByteStringComparator.INSTANCE.compare(a, a_)).isEqualTo(-1);
    Truth.assertThat(ByteStringComparator.INSTANCE.compare(a_, a)).isEqualTo(1);
  }
}
