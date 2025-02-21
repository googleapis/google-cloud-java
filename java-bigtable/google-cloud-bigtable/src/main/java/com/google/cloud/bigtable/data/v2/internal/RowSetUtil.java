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
import com.google.auto.value.AutoValue;
import com.google.bigtable.v2.ReadRowsRequest;
import com.google.bigtable.v2.RowRange;
import com.google.bigtable.v2.RowSet;
import com.google.cloud.bigtable.data.v2.models.Query;
import com.google.cloud.bigtable.data.v2.models.Range.ByteStringRange;
import com.google.cloud.bigtable.data.v2.stub.readrows.ReadRowsResumptionStrategy;
import com.google.common.base.Preconditions;
import com.google.common.collect.ComparisonChain;
import com.google.protobuf.ByteString;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.SortedSet;
import java.util.stream.Collectors;
import javax.annotation.Nonnull;
import javax.annotation.Nullable;

/**
 * Internal helper to split a {@link RowSet} into segments based on keys.
 *
 * <p>This class is considered an internal implementation detail and not meant to be used by
 * applications.
 *
 * @see Query#shard(List)
 * @see Query#getBound()
 * @see ReadRowsResumptionStrategy#getResumeRequest(ReadRowsRequest)
 */
@InternalApi
public final class RowSetUtil {
  private RowSetUtil() {}

  /** Removes the {@code #excludePoint} rowkey from the {@code RowSet} */
  public static RowSet eraseLargeRow(RowSet rowSet, ByteString excludePoint) {

    RowSet.Builder newRowSet = RowSet.newBuilder();

    if (rowSet.getRowKeysList().isEmpty() && rowSet.getRowRangesList().isEmpty()) {
      // querying range (, excludePoint) and (excludePoint, )
      newRowSet.addRowRanges(RowRange.newBuilder().setEndKeyOpen(excludePoint).build());
      newRowSet.addRowRanges(RowRange.newBuilder().setStartKeyOpen(excludePoint).build());
    }

    // remove large row key from point reads
    rowSet.getRowKeysList().stream()
        .filter(k -> !k.equals(excludePoint))
        .forEach(newRowSet::addRowKeys);

    // Handle ranges
    for (RowRange rowRange : rowSet.getRowRangesList()) {
      List<RowRange> afterSplit = splitOnLargeRowKey(rowRange, excludePoint);
      if (afterSplit != null && !afterSplit.isEmpty()) {
        afterSplit.forEach(newRowSet::addRowRanges);
      }
    }

    if (newRowSet.getRowKeysList().isEmpty() && newRowSet.getRowRangesList().isEmpty()) {
      return null;
    }
    return newRowSet.build();
  }

  /**
   * Removes all the keys and range parts that fall on or before the splitPoint.
   *
   * <p>The direction of before is determined by fromStart: for forward scans fromStart is true and
   * will remove all the keys and range segments that would've been read prior to the splitPoint
   * (ie. all of the keys sort lexiographically at or before the split point. For reverse scans,
   * fromStart is false and all segments that sort lexiographically at or after the split point are
   * removed. The primary usecase is to resume a broken ReadRows stream.
   */
  public static RowSet erase(RowSet rowSet, ByteString splitPoint, boolean fromStart) {
    RowSet.Builder newRowSet = RowSet.newBuilder();

    if (rowSet.getRowKeysList().isEmpty() && rowSet.getRowRangesList().isEmpty()) {
      rowSet = RowSet.newBuilder().addRowRanges(RowRange.getDefaultInstance()).build();
    }

    // Handle point lookups
    for (ByteString key : rowSet.getRowKeysList()) {
      if (fromStart) {
        // key is right of the split
        if (ByteStringComparator.INSTANCE.compare(key, splitPoint) > 0) {
          newRowSet.addRowKeys(key);
        }
      } else {
        // key is left of the split
        if (ByteStringComparator.INSTANCE.compare(key, splitPoint) < 0) {
          newRowSet.addRowKeys(key);
        }
      }
    }

    // Handle ranges
    for (RowRange rowRange : rowSet.getRowRangesList()) {
      RowRange newRange = truncateRange(rowRange, splitPoint, fromStart);
      if (newRange != null) {
        newRowSet.addRowRanges(newRange);
      }
    }

    // Return the new rowset if there is anything left to read
    RowSet result = newRowSet.build();
    if (result.getRowKeysList().isEmpty() && result.getRowRangesList().isEmpty()) {
      return null;
    }
    return result;
  }

  private static RowRange truncateRange(RowRange range, ByteString split, boolean fromStart) {
    if (fromStart) {
      // range end is on or left of the split: skip
      if (EndPoint.extract(range).compareTo(new EndPoint(split, true)) <= 0) {
        return null;
      }
    } else {
      // range is on or right of the split
      if (StartPoint.extract(range).compareTo(new StartPoint(split, true)) >= 0) {
        return null;
      }
    }
    RowRange.Builder newRange = range.toBuilder();

    if (fromStart) {
      // range start is on or left of the split
      if (StartPoint.extract(range).compareTo(new StartPoint(split, true)) <= 0) {
        newRange.setStartKeyOpen(split);
      }
    } else {
      // range end is on or right of the split
      if (EndPoint.extract(range).compareTo(new EndPoint(split, true)) >= 0) {
        newRange.setEndKeyOpen(split);
      }
    }

    return newRange.build();
  }

  /** This method erases the {@code #split} key from the range */
  private static List<RowRange> splitOnLargeRowKey(RowRange range, ByteString largeRowKey) {
    List<RowRange> rowRanges = new ArrayList<>();

    ByteString startKey = StartPoint.extract(range).value;
    ByteString endKey = EndPoint.extract(range).value;

    // if end key is on the left of large row key, don't split
    if (ByteStringComparator.INSTANCE.compare(endKey, largeRowKey) < 0) {
      rowRanges.add(range);
      return rowRanges;
    }

    // if start key is on the right of the large row key, don't split
    if (ByteStringComparator.INSTANCE.compare(startKey, largeRowKey) > 0) {
      rowRanges.add(range);
      return rowRanges;
    }

    // if start key is on the left of the large row key, set the end key to be large row key open
    if (ByteStringComparator.INSTANCE.compare(startKey, largeRowKey) < 0) {
      RowRange beforeSplit = range.toBuilder().setEndKeyOpen(largeRowKey).build();
      rowRanges.add(beforeSplit);
    }

    // if the end key is on the right of the large row key, set the start key to be large row key
    // open
    if (ByteStringComparator.INSTANCE.compare(endKey, largeRowKey) > 0) {
      RowRange afterSplit = range.toBuilder().setStartKeyOpen(largeRowKey).build();
      rowRanges.add(afterSplit);
    }
    return rowRanges;
  }

  /**
   * Splits the provided {@link RowSet} into segments partitioned by the provided {@code
   * splitPoints}. The split points will be treated as start keys of the segments. The primary
   * usecase is for sharding a query for MapReduce style processing.
   */
  @Nonnull
  public static List<RowSet> shard(
      @Nonnull RowSet rowSet, @Nonnull SortedSet<ByteString> splitPoints) {

    // An empty RowSet represents a full table scan. Make that explicit so that there is RowRange to
    // split.
    if (rowSet.getRowKeysList().isEmpty() && rowSet.getRowRangesList().isEmpty()) {
      rowSet = RowSet.newBuilder().addRowRanges(RowRange.getDefaultInstance()).build();
    }

    ArrayDeque<ByteString> keys =
        rowSet.getRowKeysList().stream()
            .sorted(ByteStringComparator.INSTANCE)
            .collect(Collectors.toCollection(ArrayDeque::new));
    ArrayDeque<RowRange> ranges =
        rowSet.getRowRangesList().stream()
            .sorted(Comparator.comparing(StartPoint::extract))
            .collect(Collectors.toCollection(ArrayDeque::new));

    List<RowSet> segments = new ArrayList<>();

    boolean currentSegmentIsEmpty;
    RowSet.Builder segment;

    for (ByteString splitPoint : splitPoints) {
      Preconditions.checkArgument(!splitPoint.isEmpty(), "Can't handle empty splitPoints");

      segment = RowSet.newBuilder();
      currentSegmentIsEmpty = true;

      // Handle keys - add all keys strictly < split point
      while (!keys.isEmpty()) {
        if (ByteStringComparator.INSTANCE.compare(keys.peek(), splitPoint) < 0) {
          segment.addRowKeys(keys.poll());
          currentSegmentIsEmpty = false;
        } else {
          // This key and the following will be in a later segment
          break;
        }
      }

      // Handle ranges
      while (!ranges.isEmpty()) {
        // Break early when encountering the first start point that is past the split point.
        // Ranges start on or after the split point lay to the right
        StartPoint startPoint = StartPoint.extract(ranges.peek());
        int startCmp =
            ComparisonChain.start()
                .compareTrueFirst(startPoint.value.isEmpty(), false)
                .compare(startPoint.value, splitPoint, ByteStringComparator.INSTANCE)
                // when start point is on the split point, it will always be on the right
                .result();
        if (startCmp >= 0) {
          break;
        }
        RowRange range = ranges.poll();

        @SuppressWarnings("ConstantConditions")
        EndPoint endPoint = EndPoint.extract(range);

        int endCmp =
            ComparisonChain.start()
                .compareFalseFirst(endPoint.value.isEmpty(), false)
                .compare(endPoint.value, splitPoint, ByteStringComparator.INSTANCE)
                .compareFalseFirst(endPoint.isClosed, true)
                .result();
        if (endCmp < 0) {
          segment.addRowRanges(range);
          currentSegmentIsEmpty = false;
        } else {
          segment.addRowRanges(range.toBuilder().setEndKeyOpen(splitPoint));
          currentSegmentIsEmpty = false;
          ranges.addFirst(range.toBuilder().setStartKeyClosed(splitPoint).build());
        }
      }

      if (!currentSegmentIsEmpty) {
        segments.add(segment.build());
      }
    }

    if (!keys.isEmpty() || !ranges.isEmpty()) {
      segment = RowSet.newBuilder().addAllRowKeys(keys).addAllRowRanges(ranges);
      segments.add(segment.build());
    }

    return segments;
  }

  /** Get the bounding range of a {@link RowSet}. */
  public static ByteStringRange getBound(RowSet rowSet) {
    // Find min & max keys
    ByteString minKey = null;
    ByteString maxKey = null;

    for (ByteString key : rowSet.getRowKeysList()) {
      if (minKey == null || ByteStringComparator.INSTANCE.compare(minKey, key) > 0) {
        minKey = key;
      }
      if (maxKey == null || ByteStringComparator.INSTANCE.compare(maxKey, key) < 0) {
        maxKey = key;
      }
    }

    // Convert min & max keys in start & end points for a range
    StartPoint minStartPoint = null;
    EndPoint maxEndPoint = null;
    if (minKey != null) {
      minStartPoint = new StartPoint(minKey, true);
    }
    if (maxKey != null) {
      maxEndPoint = new EndPoint(maxKey, true);
    }

    // Expand the range using the RowSet ranges
    for (RowRange rowRange : rowSet.getRowRangesList()) {
      StartPoint currentStartPoint = StartPoint.extract(rowRange);
      if (minStartPoint == null || minStartPoint.compareTo(currentStartPoint) > 0) {
        minStartPoint = currentStartPoint;
      }

      EndPoint currentEndpoint = EndPoint.extract(rowRange);
      if (maxEndPoint == null || maxEndPoint.compareTo(currentEndpoint) < 0) {
        maxEndPoint = currentEndpoint;
      }
    }

    // Build a range using the endpoints
    ByteStringRange boundingRange = ByteStringRange.unbounded();
    if (minStartPoint != null) {
      if (minStartPoint.isClosed) {
        boundingRange.startClosed(minStartPoint.value);
      } else {
        boundingRange.startOpen(minStartPoint.value);
      }
    }
    if (maxEndPoint != null) {
      if (maxEndPoint.isClosed) {
        boundingRange.endClosed(maxEndPoint.value);
      } else {
        boundingRange.endOpen(maxEndPoint.value);
      }
    }

    return boundingRange;
  }

  /**
   * Represents a RowSet split into 2 non-overlapping parts.
   *
   * <p>This class is considered an internal implementation detail and not meant to be used by
   * applications.
   */
  @InternalApi
  @AutoValue
  public abstract static class Split {
    @Nullable
    public abstract RowSet getLeft();

    @Nullable
    public abstract RowSet getRight();

    public static Split of(RowSet left, RowSet right) {
      return new AutoValue_RowSetUtil_Split(left, right);
    }
  }

  /** Helper class to ease comparison of RowRange start points. */
  private static final class StartPoint implements Comparable<StartPoint> {
    private final ByteString value;
    private final boolean isClosed;

    @Nonnull
    static StartPoint extract(@Nonnull RowRange rowRange) {
      switch (rowRange.getStartKeyCase()) {
        case STARTKEY_NOT_SET:
          return new StartPoint(ByteString.EMPTY, true);
        case START_KEY_CLOSED:
          return new StartPoint(rowRange.getStartKeyClosed(), true);
        case START_KEY_OPEN:
          if (rowRange.getStartKeyOpen().isEmpty()) {
            // Take care to normalize an open empty start key to be closed.
            return new StartPoint(ByteString.EMPTY, true);
          } else {
            return new StartPoint(rowRange.getStartKeyOpen(), false);
          }
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
          // Closed start point comes before an open start point: [x,y] starts before (x,y].
          .compareTrueFirst(isClosed, o.isClosed)
          .result();
    }
  }

  /** Helper class to ease comparison of RowRange endpoints. */
  private static final class EndPoint implements Comparable<EndPoint> {
    private final ByteString value;
    private final boolean isClosed;

    @Nonnull
    static EndPoint extract(@Nonnull RowRange rowRange) {
      switch (rowRange.getEndKeyCase()) {
        case ENDKEY_NOT_SET:
          return new EndPoint(ByteString.EMPTY, true);
        case END_KEY_CLOSED:
          return new EndPoint(rowRange.getEndKeyClosed(), true);
        case END_KEY_OPEN:
          if (rowRange.getEndKeyOpen().isEmpty()) {
            // Take care to normalize an open empty end key to be closed.
            return new EndPoint(ByteString.EMPTY, true);
          } else {
            return new EndPoint(rowRange.getEndKeyOpen(), false);
          }
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
          // Open end point comes before a closed end point: [x,y) ends before [x,y].
          .compareFalseFirst(isClosed, o.isClosed)
          .result();
    }
  }
}
