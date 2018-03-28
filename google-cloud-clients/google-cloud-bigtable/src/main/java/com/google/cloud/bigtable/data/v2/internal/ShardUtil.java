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

import com.google.api.core.InternalApi;
import com.google.bigtable.v2.ReadRowsRequest;
import com.google.bigtable.v2.RowRange;
import com.google.bigtable.v2.RowSet;
import com.google.cloud.bigtable.data.v2.models.Query;
import com.google.cloud.bigtable.data.v2.stub.readrows.ReadRowsResumptionStrategy;
import com.google.common.base.Preconditions;
import com.google.common.collect.ComparisonChain;
import com.google.common.collect.ImmutableSortedSet;
import com.google.common.collect.Lists;
import com.google.protobuf.ByteString;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.SortedSet;
import javax.annotation.Nonnull;
import javax.annotation.Nullable;

/**
 * Internal helper to split a {@link RowSet} into segments based on keys.
 *
 * <p>This class is considered an internal implementation detail and not meant to be used by
 * applications.
 *
 * @see Query#shard(List)
 * @see ReadRowsResumptionStrategy#getResumeRequest(ReadRowsRequest)
 */
@InternalApi
public final class ShardUtil {
  private ShardUtil() {}

  /**
   * Splits the provided {@link RowSet} on the provided split and returns the second segment. If the
   * second segment is empty, then it will return null. Note that the split point represents the
   * last row in the first segment.
   */
  @Nullable
  public static RowSet getRemaining(@Nonnull RowSet rowSet, @Nonnull ByteString split) {
    ImmutableSortedSet<ByteString> splitPoints =
        ImmutableSortedSet.orderedBy(ByteStringComparator.INSTANCE).add(split).build();
    return split(rowSet, splitPoints, true).get(1);
  }

  /**
   * Splits the provided {@link RowSet} into segments partitioned by the provided {@code
   * splitPoints}. Each split point represents the last row of the corresponding segment. The row
   * keys contained in the provided {@link RowSet} will be distributed across the segments. Each
   * range in the {@link RowSet} will be split up across each segment.
   *
   * @see #split(RowSet, SortedSet, boolean) for more details.
   */
  @Nonnull
  public static List<RowSet> shard(
      @Nonnull RowSet rowSet, @Nonnull SortedSet<ByteString> splitPoints) {
    return split(rowSet, splitPoints, false);
  }

  /**
   * Split a {@link RowSet} into segments.
   *
   * <p>Each segment is defined by a split point. The split point identifies the segment's inclusive
   * end. This means that the first segment will start at the beginning of the table and extend to
   * include the first split point. The last segment will start just after the last split point and
   * extend until the end of the table. The maximum number of segments that can be returned is the
   * number of split points + 1.
   *
   * <p>Each segment is represented by a RowSet in the returned List. Each of the returned RowSets
   * will contain all of the {@link RowRange}s and keys that fall between the previous segment and
   * this segment's split point. If there are no {@link RowRange}s or keys that belong to a segment,
   * then that segment will either be omitted or if {@code allowEmptySplit} is true, then it will be
   * represented by a null value in the returned list.
   *
   * <p>The segments in the returned list are guaranteed to be sorted. If {@code allowEmptySplit} is
   * true, then it will have exactly {@code splitPoints.size() + 1} items.
   */
  @Nonnull
  static List<RowSet> split(
      @Nonnull RowSet rowSet, @Nonnull SortedSet<ByteString> splitPoints, boolean allowEmptySplit) {
    // An empty RowSet represents a full table scan. Make that explicit so that there is RowRange to
    // split.
    if (RowSet.getDefaultInstance().equals(rowSet)) {
      rowSet = RowSet.newBuilder().addRowRanges(RowRange.getDefaultInstance()).build();
    }

    // Create sorted copies of the ranges and keys in the RowSet
    ByteString[] rowKeys =
        rowSet.getRowKeysList().toArray(new ByteString[rowSet.getRowKeysCount()]);
    RowRange[] rowRanges =
        rowSet.getRowRangesList().toArray(new RowRange[rowSet.getRowRangesCount()]);

    Arrays.sort(rowKeys, ByteStringComparator.INSTANCE);
    Arrays.sort(rowRanges, RANGE_START_COMPARATOR);

    List<RowSet> results = Lists.newArrayList();

    // Track consumption of input ranges & keys.
    int rowKeysStart = 0;
    int rowRangesStart = 0;

    // Keys and ranges that lie before the current split point,
    RowSet.Builder segment = RowSet.newBuilder();
    boolean isSegmentEmpty = true;

    for (ByteString splitPoint : splitPoints) {
      Preconditions.checkState(!splitPoint.isEmpty(), "Split point can't be empty");

      // Consume all of the row keys that lie to the left of the split point. Consumption is
      // designated by advancing rowKeysStart.
      for (int i = rowKeysStart; i < rowKeys.length; i++) {
        ByteString rowKey = rowKeys[i];
        if (ByteStringComparator.INSTANCE.compare(rowKey, splitPoint) <= 0) {
          segment.addRowKeys(rowKey);
          isSegmentEmpty = false;
          rowKeysStart++;
        } else {
          // This key and all following keys belong to a later segment.
          break;
        }
      }

      // Consume all of the ranges that lie before the split point (splitting the range if
      // necessary). Consumption is designated by advancing rowRangesStart.
      for (int i = rowRangesStart; i < rowRanges.length; i++) {
        RowRange rowRange = rowRanges[i];

        // Break early when encountering the first start point that is past the split point.
        // (The split point is the inclusive end of of the segment)
        int startCmp = StartPoint.extract(rowRange).compareTo(new StartPoint(splitPoint, true));
        if (startCmp > 0) {
          break;
        }

        // Some part of this range will be in the segment.
        isSegmentEmpty = false;

        // Figure out the endpoint and remainder.
        int endCmp = EndPoint.extract(rowRange).compareTo(new EndPoint(splitPoint, true));
        if (endCmp <= 0) {
          // The range is fully contained in the segment.
          segment.addRowRanges(rowRange);

          // Consume the range, but take care to shift partially consumed ranges.
          // Partially consumed ranges will only exist if the original RowSet had overlapping
          // ranges, this should be a rare occurrence.
          System.arraycopy(
              rowRanges, rowRangesStart, rowRanges, rowRangesStart + 1, i - rowRangesStart);
          rowRangesStart++;
        } else {
          // The range is split:
          // Add the left part to the segment
          RowRange leftSubRange = rowRange.toBuilder().setEndKeyClosed(splitPoint).build();
          segment.addRowRanges(leftSubRange);
          // Save the remainder for the next segment. This is done by replacing the current rowRange
          // with the remainder and not advancing rowRangesStart.
          RowRange rightSubRange = rowRange.toBuilder().setStartKeyOpen(splitPoint).build();
          rowRanges[i] = rightSubRange;
        }
      }

      // Build the current segment
      if (!isSegmentEmpty) {
        results.add(segment.build());
        isSegmentEmpty = true;
        segment = RowSet.newBuilder();
      } else if (allowEmptySplit) {
        results.add(null);
      }
    }

    // Create the last segment (from the last splitKey to the end of the table)
    for (int i = rowKeysStart; i < rowKeys.length; i++) {
      isSegmentEmpty = false;
      segment.addRowKeys(rowKeys[i]);
    }
    for (int i = rowRangesStart; i < rowRanges.length; i++) {
      isSegmentEmpty = false;
      segment.addRowRanges(rowRanges[i]);
    }
    if (!isSegmentEmpty) {
      results.add(segment.build());
    } else if (allowEmptySplit) {
      results.add(null);
    }

    return results;
  }

  private static final Comparator<RowRange> RANGE_START_COMPARATOR =
      new Comparator<RowRange>() {
        @Override
        public int compare(@Nonnull RowRange o1, @Nonnull RowRange o2) {
          return StartPoint.extract(o1).compareTo(StartPoint.extract(o2));
        }
      };

  /** Helper class to ease comparison of RowRange start points. */
  private static class StartPoint implements Comparable<StartPoint> {
    private final ByteString value;
    private final boolean isClosed;

    @Nonnull
    static StartPoint extract(@Nonnull RowRange rowRange) {
      switch (rowRange.getStartKeyCase()) {
        case STARTKEY_NOT_SET:
          // Minimum point is inclusive
          return new StartPoint(ByteString.EMPTY, true);
        case START_KEY_CLOSED:
          return new StartPoint(rowRange.getStartKeyClosed(), true);
        case START_KEY_OPEN:
          return new StartPoint(rowRange.getStartKeyOpen(), false);
        default:
          throw new IllegalArgumentException("Unknown startKeyCase: " + rowRange.getStartKeyCase());
      }
    }

    StartPoint(@Nonnull ByteString value, boolean isClosed) {
      this.value = value;
      this.isClosed = isClosed;
    }

    @Override
    public int compareTo(@Nonnull StartPoint o) {
      return ComparisonChain.start()
          // Empty string comes first
          .compareTrueFirst(value.isEmpty(), o.value.isEmpty())
          .compare(value, o.value, ByteStringComparator.INSTANCE)
          // Closed start comes after open
          .compareTrueFirst(isClosed, o.isClosed)
          .result();
    }
  }

  /** Helper class to ease comparison of RowRange endpoints. */
  private static class EndPoint implements Comparable<EndPoint> {
    private final ByteString value;
    private final boolean isClosed;

    @Nonnull
    static EndPoint extract(@Nonnull RowRange rowRange) {
      switch (rowRange.getEndKeyCase()) {
        case ENDKEY_NOT_SET:
          // Maximum point is exclusive
          return new EndPoint(ByteString.EMPTY, false);
        case END_KEY_CLOSED:
          return new EndPoint(rowRange.getEndKeyClosed(), true);
        case END_KEY_OPEN:
          return new EndPoint(rowRange.getEndKeyOpen(), false);
        default:
          throw new IllegalArgumentException("Unknown endKeyCase: " + rowRange.getEndKeyCase());
      }
    }

    EndPoint(@Nonnull ByteString value, boolean isClosed) {
      this.value = value;
      this.isClosed = isClosed;
    }

    @Override
    public int compareTo(@Nonnull EndPoint o) {
      return ComparisonChain.start()
          // Empty string comes last
          .compareFalseFirst(value.isEmpty(), o.value.isEmpty())
          .compare(value, o.value, ByteStringComparator.INSTANCE)
          // A closed end comes before an open end
          .compareFalseFirst(isClosed, o.isClosed)
          .result();
    }
  }
}
