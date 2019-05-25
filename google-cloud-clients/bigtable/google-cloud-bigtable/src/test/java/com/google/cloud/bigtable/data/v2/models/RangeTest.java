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
package com.google.cloud.bigtable.data.v2.models;

import static com.google.common.truth.Truth.assertThat;

import com.google.cloud.bigtable.data.v2.models.Range.BoundType;
import com.google.cloud.bigtable.data.v2.models.Range.ByteStringRange;
import com.google.cloud.bigtable.data.v2.models.Range.TimestampRange;
import com.google.protobuf.ByteString;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;

@RunWith(JUnit4.class)
public class RangeTest {
  @Test
  public void timestampUnboundedTest() {
    TimestampRange range = TimestampRange.unbounded();
    assertThat(range.getStartBound()).isEqualTo(BoundType.UNBOUNDED);
    assertThat(range.getEndBound()).isEqualTo(BoundType.UNBOUNDED);

    Throwable actualError = null;
    try {
      //noinspection ResultOfMethodCallIgnored
      range.getStart();
    } catch (Throwable e) {
      actualError = e;
    }
    assertThat(actualError).isInstanceOf(IllegalStateException.class);

    try {
      //noinspection ResultOfMethodCallIgnored
      range.getEnd();
    } catch (Throwable e) {
      actualError = e;
    }
    assertThat(actualError).isInstanceOf(IllegalStateException.class);
  }

  @Test
  public void timestampOfTest() {
    TimestampRange range = TimestampRange.create(10, 2_000);
    assertThat(range.getStartBound()).isEqualTo(BoundType.CLOSED);
    assertThat(range.getStart()).isEqualTo(10);
    assertThat(range.getEndBound()).isEqualTo(BoundType.OPEN);
    assertThat(range.getEnd()).isEqualTo(2_000);
  }

  @Test
  public void timestampChangeStartTest() {
    TimestampRange range = TimestampRange.create(10, 2_000).startOpen(20L);

    assertThat(range.getEndBound()).isEqualTo(BoundType.OPEN);
    assertThat(range.getEnd()).isEqualTo(2_000);

    assertThat(range.getStartBound()).isEqualTo(BoundType.OPEN);
    assertThat(range.getStart()).isEqualTo(20);

    range = range.startClosed(30L);
    assertThat(range.getStartBound()).isEqualTo(BoundType.CLOSED);
    assertThat(range.getStart()).isEqualTo(30);
  }

  @Test
  public void timestampChangeEndTest() {
    TimestampRange range = TimestampRange.create(10, 2_000).endClosed(1_000L);

    assertThat(range.getStartBound()).isEqualTo(BoundType.CLOSED);
    assertThat(range.getStart()).isEqualTo(10);

    assertThat(range.getEndBound()).isEqualTo(BoundType.CLOSED);
    assertThat(range.getEnd()).isEqualTo(1_000);

    range = range.endOpen(3_000L);
    assertThat(range.getEndBound()).isEqualTo(BoundType.OPEN);
    assertThat(range.getEnd()).isEqualTo(3_000);
  }

  @Test
  public void timestampCloneTest() {
    TimestampRange range = TimestampRange.create(10, 2_000);
    TimestampRange rangeSame = range.endClosed(3_000L);
    TimestampRange rangeClone = range.clone().endClosed(4_000L);

    assertThat(range.getEnd()).isEqualTo(3_000);
    assertThat(rangeSame.getEnd()).isEqualTo(3_000);
    assertThat(rangeClone.getEnd()).isEqualTo(4_000);
  }

  @Test
  public void timestampEqualsTest() {
    TimestampRange r1 = TimestampRange.create(1, 10);
    TimestampRange r2 = TimestampRange.create(1, 10);
    TimestampRange r3 = TimestampRange.create(2, 20);

    assertThat(r1).isEqualTo(r2);
    assertThat(r2).isEqualTo(r1);
    assertThat(r1).isNotEqualTo(r3);
  }

  @Test
  public void timestampSerializationTest() throws IOException, ClassNotFoundException {
    TimestampRange expected = TimestampRange.create(10, 20);

    ByteArrayOutputStream bos = new ByteArrayOutputStream();
    ObjectOutputStream oos = new ObjectOutputStream(bos);
    oos.writeObject(expected);
    oos.close();

    ObjectInputStream ois = new ObjectInputStream(new ByteArrayInputStream(bos.toByteArray()));

    TimestampRange actual = (TimestampRange) ois.readObject();
    assertThat(actual).isEqualTo(expected);
  }

  @Test
  public void byteStringUnboundedTest() {
    ByteStringRange range = ByteStringRange.unbounded();
    assertThat(range.getStartBound()).isEqualTo(BoundType.UNBOUNDED);
    assertThat(range.getEndBound()).isEqualTo(BoundType.UNBOUNDED);

    Throwable actualError = null;
    try {
      range.getStart();
    } catch (Throwable e) {
      actualError = e;
    }
    assertThat(actualError).isInstanceOf(IllegalStateException.class);

    try {
      range.getEnd();
    } catch (Throwable e) {
      actualError = e;
    }
    assertThat(actualError).isInstanceOf(IllegalStateException.class);
  }

  @Test
  public void byteStringOfTest() {
    ByteStringRange range =
        ByteStringRange.create(ByteString.copyFromUtf8("a"), ByteString.copyFromUtf8("b"));

    assertThat(range.getStartBound()).isEqualTo(BoundType.CLOSED);
    assertThat(range.getStart()).isEqualTo(ByteString.copyFromUtf8("a"));
    assertThat(range.getEndBound()).isEqualTo(BoundType.OPEN);
    assertThat(range.getEnd()).isEqualTo(ByteString.copyFromUtf8("b"));
  }

  @Test
  public void byteStringOfStringTest() {
    ByteStringRange range = ByteStringRange.create("a", "b");

    assertThat(range.getStartBound()).isEqualTo(BoundType.CLOSED);
    assertThat(range.getStart()).isEqualTo(ByteString.copyFromUtf8("a"));
    assertThat(range.getEndBound()).isEqualTo(BoundType.OPEN);
    assertThat(range.getEnd()).isEqualTo(ByteString.copyFromUtf8("b"));
  }

  @Test
  public void byteStringPrefixTest() {
    assertThat(ByteStringRange.prefix("a")).isEqualTo(ByteStringRange.create("a", "b"));

    assertThat(ByteStringRange.prefix("ab")).isEqualTo(ByteStringRange.create("ab", "ac"));

    ByteString prefix2 = ByteString.copyFrom(new byte[] {'a', (byte) 0xFF});

    assertThat(ByteStringRange.prefix(prefix2))
        .isEqualTo(ByteStringRange.create(prefix2, ByteString.copyFromUtf8("b")));

    ByteString prefix3 = ByteString.copyFrom(new byte[] {(byte) 0xFF, (byte) 0xFF});

    assertThat(ByteStringRange.prefix(prefix3))
        .isEqualTo(ByteStringRange.unbounded().startClosed(prefix3));

    assertThat(ByteStringRange.prefix(ByteString.EMPTY)).isEqualTo(ByteStringRange.unbounded());
  }

  @Test
  public void byteStringChangeStartTest() {
    ByteStringRange range =
        ByteStringRange.create(ByteString.copyFromUtf8("a"), ByteString.copyFromUtf8("z"))
            .startOpen(ByteString.copyFromUtf8("b"));

    assertThat(range.getEndBound()).isEqualTo(BoundType.OPEN);
    assertThat(range.getEnd()).isEqualTo(ByteString.copyFromUtf8("z"));

    assertThat(range.getStartBound()).isEqualTo(BoundType.OPEN);
    assertThat(range.getStart()).isEqualTo(ByteString.copyFromUtf8("b"));

    range = range.startClosed(ByteString.copyFromUtf8("c"));
    assertThat(range.getStartBound()).isEqualTo(BoundType.CLOSED);
    assertThat(range.getStart()).isEqualTo(ByteString.copyFromUtf8("c"));

    assertThat(range.startOpen(ByteString.EMPTY).getStartBound()).isEqualTo(BoundType.UNBOUNDED);
    assertThat(range.startClosed(ByteString.EMPTY).getStartBound()).isEqualTo(BoundType.UNBOUNDED);
  }

  @Test
  public void byteStringChangeStartStringTest() {
    ByteStringRange range = ByteStringRange.create("a", "z").startOpen("b");

    assertThat(range.getEndBound()).isEqualTo(BoundType.OPEN);
    assertThat(range.getEnd()).isEqualTo(ByteString.copyFromUtf8("z"));

    assertThat(range.getStartBound()).isEqualTo(BoundType.OPEN);
    assertThat(range.getStart()).isEqualTo(ByteString.copyFromUtf8("b"));

    range = range.startClosed("c");
    assertThat(range.getStartBound()).isEqualTo(BoundType.CLOSED);
    assertThat(range.getStart()).isEqualTo(ByteString.copyFromUtf8("c"));

    assertThat(range.startOpen("").getStartBound()).isEqualTo(BoundType.UNBOUNDED);
    assertThat(range.startClosed("").getStartBound()).isEqualTo(BoundType.UNBOUNDED);
  }

  @Test
  public void byteStringChangeEndTest() {
    ByteStringRange range =
        ByteStringRange.create(ByteString.copyFromUtf8("a"), ByteString.copyFromUtf8("z"))
            .endClosed(ByteString.copyFromUtf8("y"));

    assertThat(range.getStartBound()).isEqualTo(BoundType.CLOSED);
    assertThat(range.getStart()).isEqualTo(ByteString.copyFromUtf8("a"));

    assertThat(range.getEndBound()).isEqualTo(BoundType.CLOSED);
    assertThat(range.getEnd()).isEqualTo(ByteString.copyFromUtf8("y"));

    range = range.endOpen(ByteString.copyFromUtf8("x"));
    assertThat(range.getEndBound()).isEqualTo(BoundType.OPEN);
    assertThat(range.getEnd()).isEqualTo(ByteString.copyFromUtf8("x"));

    assertThat(range.endOpen(ByteString.EMPTY).getEndBound()).isEqualTo(BoundType.UNBOUNDED);
    assertThat(range.endClosed(ByteString.EMPTY).getEndBound()).isEqualTo(BoundType.UNBOUNDED);
  }

  @Test
  public void byteStringChangeEndStringTest() {
    ByteStringRange range = ByteStringRange.create("a", "z").endClosed("y");

    assertThat(range.getStartBound()).isEqualTo(BoundType.CLOSED);
    assertThat(range.getStart()).isEqualTo(ByteString.copyFromUtf8("a"));

    assertThat(range.getEndBound()).isEqualTo(BoundType.CLOSED);
    assertThat(range.getEnd()).isEqualTo(ByteString.copyFromUtf8("y"));

    range = range.endOpen("x");
    assertThat(range.getEndBound()).isEqualTo(BoundType.OPEN);
    assertThat(range.getEnd()).isEqualTo(ByteString.copyFromUtf8("x"));

    assertThat(range.endOpen("").getEndBound()).isEqualTo(BoundType.UNBOUNDED);
    assertThat(range.endClosed("").getEndBound()).isEqualTo(BoundType.UNBOUNDED);
  }

  @Test
  public void byteStringCloneTest() {
    ByteStringRange range = ByteStringRange.create("a", "original");
    ByteStringRange rangeSame = range.endClosed("sameInstance");
    ByteStringRange rangeClone = range.clone().endClosed("cloneInstance");

    assertThat(range.getEnd().toStringUtf8()).isEqualTo("sameInstance");
    assertThat(rangeSame.getEnd().toStringUtf8()).isEqualTo("sameInstance");
    assertThat(rangeClone.getEnd().toStringUtf8()).isEqualTo("cloneInstance");
  }

  @Test
  public void byteStringEqualsTest() {
    ByteStringRange r1 = ByteStringRange.create("a", "c");
    ByteStringRange r2 = ByteStringRange.create("a", "c");
    ByteStringRange r3 = ByteStringRange.create("q", "z");

    assertThat(r1).isEqualTo(r2);
    assertThat(r2).isEqualTo(r1);
    assertThat(r1).isNotEqualTo(r3);
  }

  @Test
  public void byteStringSerializationTest() throws IOException, ClassNotFoundException {
    ByteStringRange expected = ByteStringRange.create("a", "z");

    ByteArrayOutputStream bos = new ByteArrayOutputStream();
    ObjectOutputStream oos = new ObjectOutputStream(bos);
    oos.writeObject(expected);
    oos.close();

    ObjectInputStream ois = new ObjectInputStream(new ByteArrayInputStream(bos.toByteArray()));

    ByteStringRange actual = (ByteStringRange) ois.readObject();
    assertThat(actual).isEqualTo(expected);
  }
}
