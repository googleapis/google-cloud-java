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

import com.google.bigtable.v2.RowRange;
import com.google.bigtable.v2.RowSet;
import com.google.cloud.bigtable.data.v2.models.Range.ByteStringRange;
import com.google.common.base.Preconditions;
import com.google.protobuf.ByteString;
import java.util.Arrays;
import java.util.List;
import java.util.SortedSet;
import java.util.TreeSet;
import java.util.stream.Collectors;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;

@RunWith(JUnit4.class)
public class RowSetUtilTest {
  @Test
  public void testSplitFullScan() {
    RowSet input = RowSet.getDefaultInstance();
    RowSetUtil.Split split = RowSetUtil.split(input, ByteString.copyFromUtf8("g"));

    assertThat(split.getLeft()).isEqualTo(parse("-g]"));
    assertThat(split.getRight()).isEqualTo(parse("(g-"));
  }

  @Test
  public void testSplitAllLeft() {
    RowSet input = parse("a,c,(a1-c],[a2-c],(a3-c),[a4-c)");
    RowSetUtil.Split split = RowSetUtil.split(input, ByteString.copyFromUtf8("c"));

    assertThat(split.getLeft()).isEqualTo(input);
    assertThat(split.getRight()).isNull();
  }

  @Test
  public void testSplitAllRight() {
    RowSet input = parse("a1,c,(a-c],[a2-c],(a3-c),[a4-c)");
    RowSetUtil.Split split = RowSetUtil.split(input, ByteString.copyFromUtf8("a"));

    assertThat(split.getLeft()).isNull();
    assertThat(split.getRight()).isEqualTo(input);
  }

  @Test
  public void testSplit() {
    RowSet input = parse("a1,c,(a1-c],[a2-c],(a3-c),[a4-c)");
    RowSetUtil.Split split = RowSetUtil.split(input, ByteString.copyFromUtf8("b"));

    assertThat(split.getLeft()).isEqualTo(parse("a1,(a1-b],[a2-b],(a3-b],[a4-b]"));
    assertThat(split.getRight()).isEqualTo(parse("c,(b-c],(b-c],(b-c),(b-c)"));
  }

  @Test
  public void testShardNoop() {
    assertShardNoSplit("a,[p-q)");
    assertShardNoSplit("0_key,[1_range_start-2_range_end)", "3_split");
    assertShardNoSplit("-1_range_end)", "5_split");
    assertShardNoSplit("0_key,[1_range_start-2_range_end)", "2_range_end");
    assertShardNoSplit("9_row_key,(5_range_start-7_range_end)", "3_split");
    assertShardNoSplit("(5_range_start-", "3_split");
    assertShardNoSplit("3_split,[3_split-5_split)", "3_split", "5_split");
    assertShardNoSplit("[3_split-", "3_split");
  }

  private static void assertShardNoSplit(String rowStr, String... splits) {
    RowSet input = parse(rowStr);

    assertThat(RowSetUtil.shard(input, splitPoints(splits))).containsExactly(input);
  }

  @Test
  public void testShardFullTableScan() {
    RowSet input = RowSet.getDefaultInstance();
    SortedSet<ByteString> splitPoints = splitPoints("a");

    assertThat(RowSetUtil.shard(input, splitPoints))
        .containsExactly(parse("-a)"), parse("[a-"))
        .inOrder();
  }

  @Test
  public void testShardMultipleKeys() {
    RowSet input = parse("1_beforeSplit,2_onSplit,3_afterSplit");
    SortedSet<ByteString> splitPoints = splitPoints("2_onSplit");

    assertThat(RowSetUtil.shard(input, splitPoints))
        .containsExactly(parse("1_beforeSplit"), parse("2_onSplit,3_afterSplit"))
        .inOrder();
  }

  @Test
  public void testShardKeysEmptyLeft() {
    RowSet input = parse("5_test,8_test");
    SortedSet<ByteString> splitPoints = splitPoints("0_split", "6-split");

    assertThat(RowSetUtil.shard(input, splitPoints))
        .containsExactly(parse("5_test"), parse("8_test"))
        .inOrder();
  }

  @Test
  public void testShardKeysEmptyRight() {
    RowSet input = parse("0_test,2_test");
    SortedSet<ByteString> splitPoints = splitPoints("1_split", "5_split");

    assertThat(RowSetUtil.shard(input, splitPoints))
        .containsExactly(parse("0_test"), parse("2_test"))
        .inOrder();
  }

  @Test
  public void testShardMixedSplit() {
    RowSet input = parse("0,a,c,-a],-b],(c-e],(d-f],(m-");
    SortedSet<ByteString> splitPoints = splitPoints("a", "d", "j", "o");

    assertThat(RowSetUtil.shard(input, splitPoints))
        .containsExactly(
            parse("0,-a)"),
            parse("a,c,[a-a],-b],(c-d)"),
            parse("[d-e],(d-f]"),
            parse("(m-o)"),
            parse("[o-"))
        .inOrder();
  }

  @Test
  public void testShardUnsortedRequest() {
    RowSet input =
        parse(
            "7_row_key_1,2_row_key_2,[8_range_1_start-9_range_1_end),[3_range_2_start-4_range_2_end)");
    SortedSet<ByteString> splitPoints = splitPoints("5-split");

    assertThat(RowSetUtil.shard(input, splitPoints))
        .containsExactly(
            parse("2_row_key_2,[3_range_2_start-4_range_2_end)"),
            parse("7_row_key_1,[8_range_1_start-9_range_1_end)"))
        .inOrder();
  }

  private static SortedSet<ByteString> splitPoints(String... s) {

    return Arrays.stream(s)
        .map(ByteString::copyFromUtf8)
        .collect(Collectors.toCollection(() -> new TreeSet<>(ByteStringComparator.INSTANCE)));
  }

  private static RowSet parse(String encodedRowSet) {
    RowSet.Builder builder = RowSet.newBuilder();

    for (String s : encodedRowSet.split(",")) {
      if (s.contains("-")) {
        builder.addRowRanges(parseRange(s));
      } else {
        builder.addRowKeys(ByteString.copyFromUtf8(s));
      }
    }
    return builder.build();
  }

  private static RowRange parseRange(String s) {
    String[] parts = s.split("-", 2);
    Preconditions.checkArgument(parts.length == 2, "Ranges must have exactly 2 parts: " + s);

    RowRange.Builder builder = RowRange.newBuilder();

    String encodedStart = parts[0];
    if ("".equals(encodedStart)) {
      // noop - start key unset
    } else if (encodedStart.startsWith("(")) {
      String value = encodedStart.substring(1);
      builder.setStartKeyOpen(ByteString.copyFromUtf8(value));
    } else if (encodedStart.startsWith("[")) {
      String value = encodedStart.substring(1);
      builder.setStartKeyClosed(ByteString.copyFromUtf8(value));
    } else {
      throw new IllegalArgumentException("unexpected range start format");
    }

    String encodedEnd = parts[1];
    if (encodedEnd.isEmpty()) {
      // noop - end key unset
    } else if (encodedEnd.endsWith(")")) {
      String value = encodedEnd.substring(0, encodedEnd.length() - 1);
      builder.setEndKeyOpen(ByteString.copyFromUtf8(value));
    } else if (encodedEnd.endsWith("]")) {
      String value = encodedEnd.substring(0, encodedEnd.length() - 1);
      builder.setEndKeyClosed(ByteString.copyFromUtf8(value));
    } else {
      throw new IllegalArgumentException("unexpected range end format");
    }
    return builder.build();
  }

  @Test
  public void emptyBoundTest() {
    RowSet rowSet = RowSet.getDefaultInstance();

    ByteStringRange actual = RowSetUtil.getBound(rowSet);
    assertThat(actual).isEqualTo(ByteStringRange.unbounded());
  }

  @Test
  public void singleKeyBoundTest() {
    RowSet rowSet = RowSet.newBuilder().addRowKeys(ByteString.copyFromUtf8("a")).build();

    ByteStringRange actual = RowSetUtil.getBound(rowSet);
    assertThat(actual).isEqualTo(ByteStringRange.unbounded().startClosed("a").endClosed("a"));
  }

  @Test
  public void multiKeyBoundTest() {
    RowSet rowSet =
        RowSet.newBuilder()
            .addRowKeys(ByteString.copyFromUtf8("a"))
            .addRowKeys(ByteString.copyFromUtf8("d"))
            .build();

    ByteStringRange actual = RowSetUtil.getBound(rowSet);
    assertThat(actual).isEqualTo(ByteStringRange.unbounded().startClosed("a").endClosed("d"));
  }

  @Test
  public void singleClosedClosedRangeBoundTest() {
    RowSet rowSet =
        RowSet.newBuilder()
            .addRowRanges(
                RowRange.newBuilder()
                    .setStartKeyClosed(ByteString.copyFromUtf8("a"))
                    .setEndKeyClosed(ByteString.copyFromUtf8("b")))
            .build();
    ByteStringRange actual = RowSetUtil.getBound(rowSet);
    assertThat(actual).isEqualTo(ByteStringRange.unbounded().startClosed("a").endClosed("b"));
  }

  @Test
  public void singleClosedOpenRangeBoundTest() {
    RowSet rowSet =
        RowSet.newBuilder()
            .addRowRanges(
                RowRange.newBuilder()
                    .setStartKeyClosed(ByteString.copyFromUtf8("a"))
                    .setEndKeyOpen(ByteString.copyFromUtf8("b")))
            .build();
    ByteStringRange actual = RowSetUtil.getBound(rowSet);
    assertThat(actual).isEqualTo(ByteStringRange.unbounded().startClosed("a").endOpen("b"));
  }

  @Test
  public void singleOpenOpenRangeBoundTest() {
    RowSet rowSet =
        RowSet.newBuilder()
            .addRowRanges(
                RowRange.newBuilder()
                    .setStartKeyOpen(ByteString.copyFromUtf8("a"))
                    .setEndKeyOpen(ByteString.copyFromUtf8("b")))
            .build();
    ByteStringRange actual = RowSetUtil.getBound(rowSet);
    assertThat(actual).isEqualTo(ByteStringRange.unbounded().startOpen("a").endOpen("b"));
  }

  @Test
  public void singleRangeOpenClosedBoundTest() {
    RowSet rowSet =
        RowSet.newBuilder()
            .addRowRanges(
                RowRange.newBuilder()
                    .setStartKeyOpen(ByteString.copyFromUtf8("a"))
                    .setEndKeyClosed(ByteString.copyFromUtf8("b")))
            .build();
    ByteStringRange actual = RowSetUtil.getBound(rowSet);
    assertThat(actual).isEqualTo(ByteStringRange.unbounded().startOpen("a").endClosed("b"));
  }

  @Test
  public void singleRangeUnbounded1BoundTest() {
    RowSet rowSet =
        RowSet.newBuilder()
            .addRowRanges(RowRange.newBuilder().setStartKeyClosed(ByteString.copyFromUtf8("a")))
            .build();
    ByteStringRange actual = RowSetUtil.getBound(rowSet);
    assertThat(actual).isEqualTo(ByteStringRange.unbounded().startClosed("a"));
  }

  @Test
  public void singleRangeUnbounded2BoundTest() {
    RowSet rowSet =
        RowSet.newBuilder()
            .addRowRanges(RowRange.newBuilder().setEndKeyClosed(ByteString.copyFromUtf8("z")))
            .build();
    ByteStringRange actual = RowSetUtil.getBound(rowSet);
    assertThat(actual).isEqualTo(ByteStringRange.unbounded().endClosed("z"));
  }

  @Test
  public void multipleRangeBoundTest() {
    RowSet rowSet =
        RowSet.newBuilder()
            .addRowRanges(
                RowRange.newBuilder()
                    .setStartKeyClosed(ByteString.copyFromUtf8("a"))
                    .setEndKeyOpen(ByteString.copyFromUtf8("m")))
            .addRowRanges(
                RowRange.newBuilder()
                    .setStartKeyClosed(ByteString.copyFromUtf8("q"))
                    .setEndKeyOpen(ByteString.copyFromUtf8("z")))
            .build();
    ByteStringRange actual = RowSetUtil.getBound(rowSet);
    assertThat(actual).isEqualTo(ByteStringRange.create("a", "z"));
  }

  // Helpers
  private static void verifyShard(RowSet input, SortedSet<ByteString> splits, RowSet... expected) {
    List<RowSet> actualWithNull = RowSetUtil.shard(input, splits);
    assertThat(actualWithNull).containsExactlyElementsIn(Arrays.asList(expected)).inOrder();
  }
}
