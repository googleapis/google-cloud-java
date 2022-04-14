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

  /**
   * Splits the provided {@link RowSet} along the provided splitPoint into 2 segments. The right
   * segment will contain all keys that are strictly greater than the splitPoint and all {@link
   * RowRange}s truncated to start right after the splitPoint. The primary usecase is to resume a
   * broken ReadRows stream.
   */
  @Nonnull
  public static Split split(@Nonnull RowSet rowSet, @Nonnull ByteString splitPoint) {
    // Edgecase: splitPoint is the leftmost key ("")
    if (splitPoint.isEmpty()) {
      return Split.of(null, rowSet);
    }

    // An empty RowSet represents a full table scan. Make that explicit so that there is RowRange to
    // split.
    if (rowSet.getRowKeysList().isEmpty() && rowSet.getRowRangesList().isEmpty()) {
      rowSet = RowSet.newBuilder().addRowRanges(RowRange.getDefaultInstance()).build();
    }

    RowSet.Builder leftBuilder = RowSet.newBuilder();
    boolean leftIsEmpty = true;
    RowSet.Builder rightBuilder = RowSet.newBuilder();
    boolean rightIsEmpty = true;

    for (ByteString key : rowSet.getRowKeysList()) {
      if (ByteStringComparator.INSTANCE.compare(key, splitPoint) <= 0) {
        leftBuilder.addRowKeys(key);
        leftIsEmpty = false;
      } else {
        rightBuilder.addRowKeys(key);
        rightIsEmpty = false;
      }
    }

    for (RowRange range : rowSet.getRowRangesList()) {
      StartPoint startPoint = StartPoint.extract(range);
      int startCmp =
          ComparisonChain.start()
              .compare(startPoint.value, splitPoint, ByteStringComparator.INSTANCE)
              // when value lies on the split point, only closed start points are on the left
              .compareTrueFirst(startPoint.isClosed, true)
              .result();

      // Range is fully on the right side
      if (startCmp > 0) {
        rightBuilder.addRowRanges(range);
        rightIsEmpty = false;
        continue;
      }

      EndPoint endPoint = EndPoint.extract(range);
      int endCmp =
          ComparisonChain.start()
              // empty (true) end key means rightmost regardless of the split point
              .compareFalseFirst(endPoint.value.isEmpty(), false)
              .compare(endPoint.value, splitPoint, ByteStringComparator.INSTANCE)
              // don't care if the endpoint is open/closed: both will be on the left if the value is
              // <=
              .result();

      if (endCmp <= 0) {
        // Range is fully on the left
        leftBuilder.addRowRanges(range);
        leftIsEmpty = false;
      } else {
        // Range is split
        leftBuilder.addRowRanges(range.toBuilder().setEndKeyClosed(splitPoint));
        leftIsEmpty = false;
        rightBuilder.addRowRanges(range.toBuilder().setStartKeyOpen(splitPoint));
        rightIsEmpty = false;
      }
    }

    return Split.of(
        leftIsEmpty ? null : leftBuilder.build(), rightIsEmpty ? null : rightBuilder.build());
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
