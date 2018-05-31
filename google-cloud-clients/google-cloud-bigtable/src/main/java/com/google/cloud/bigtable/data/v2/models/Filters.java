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

import com.google.api.core.InternalApi;
import com.google.api.core.InternalExtensionOnly;
import com.google.bigtable.v2.ColumnRange;
import com.google.bigtable.v2.RowFilter;
import com.google.bigtable.v2.ValueRange;
import com.google.cloud.bigtable.data.v2.internal.RegexUtil;
import com.google.cloud.bigtable.data.v2.models.Range.AbstractByteStringRange;
import com.google.cloud.bigtable.data.v2.models.Range.AbstractTimestampRange;
import com.google.common.base.Preconditions;
import com.google.protobuf.ByteString;
import java.io.Serializable;
import javax.annotation.Nonnull;

/**
 * A Fluent DSL to create a hierarchy of filters for the CheckAndMutateRow RPCs and ReadRows Query.
 *
 * <p>Intended usage is to statically import, or in case of conflict, assign the static variable
 * FILTERS and use its fluent API to build filters.
 *
 * <p>Sample code:
 *
 * <pre>{@code
 * import static com.google.cloud.bigtable.data.v2.models.Filters.FILTERS;
 *
 * void main() {
 *   // Build the filter expression
 *   RowFilter filter = FILTERS.chain()
 *     .filter(FILTERS.qualifier().regex("prefix.*"))
 *     .filter(FILTERS.limit().cellsPerRow(10));
 *
 *   // Use it in a Query
 *   Query query = Query.create("[TABLE]")
 *     .filter(filter);
 * }
 *
 * }</pre>
 */
public final class Filters {
  /** Entry point into the DSL. */
  @SuppressWarnings("WeakerAccess")
  public static final Filters FILTERS = new Filters();

  private static final SimpleFilter PASS =
      new SimpleFilter(RowFilter.newBuilder().setPassAllFilter(true).build());
  private static final SimpleFilter BLOCK =
      new SimpleFilter(RowFilter.newBuilder().setBlockAllFilter(true).build());
  private static final SimpleFilter SINK =
      new SimpleFilter(RowFilter.newBuilder().setSink(true).build());
  private static final SimpleFilter STRIP_VALUE =
      new SimpleFilter(RowFilter.newBuilder().setStripValueTransformer(true).build());

  private Filters() {}

  /**
   * Creates an empty chain filter list. Filters can be added to the chain by invoking {@link
   * ChainFilter#filter(Filters.Filter)}.
   *
   * <p>The elements of "filters" are chained together to process the input row:
   *
   * <pre>{@code in row -> filter0 -> intermediate row -> filter1 -> ... -> filterN -> out row}
   * </pre>
   *
   * The full chain is executed atomically.
   */
  public ChainFilter chain() {
    return new ChainFilter();
  }

  /**
   * Creates an empty interleave filter list. Filters can be added to the interleave by invoking
   * {@link InterleaveFilter#filter(Filters.Filter)}.
   *
   * <p>The elements of "filters" all process a copy of the input row, and the results are pooled,
   * sorted, and combined into a single output row. If multiple cells are produced with the same
   * column and timestamp, they will all appear in the output row in an unspecified mutual order.
   * The full chain is executed atomically.
   */
  public InterleaveFilter interleave() {
    return new InterleaveFilter();
  }

  /**
   * Creates an empty condition filter. The filter results of the predicate can be configured by
   * invoking {@link ConditionFilter#then(Filters.Filter)} and {@link
   * ConditionFilter#otherwise(Filters.Filter)}.
   *
   * <p>A RowFilter which evaluates one of two possible RowFilters, depending on whether or not a
   * predicate RowFilter outputs any cells from the input row.
   *
   * <p>IMPORTANT NOTE: The predicate filter does not execute atomically with the {@link
   * ConditionFilter#then(Filters.Filter)} and {@link ConditionFilter#otherwise(Filters.Filter)}
   * (Filter)} filters, which may lead to inconsistent or unexpected results. Additionally, {@link
   * ConditionFilter} may have poor performance, especially when filters are set for the {@link
   * ConditionFilter#otherwise(Filters.Filter)}.
   */
  public ConditionFilter condition(@Nonnull Filter predicate) {
    Preconditions.checkNotNull(predicate);
    return new ConditionFilter(predicate);
  }

  /** Returns the builder for row key related filters. */
  public KeyFilter key() {
    return new KeyFilter();
  }

  /** Returns the builder for column family related filters. */
  public FamilyFilter family() {
    return new FamilyFilter();
  }

  /** Returns the builder for column qualifier related filters. */
  public QualifierFilter qualifier() {
    return new QualifierFilter();
  }

  /** Returns the builder for timestamp related filters. */
  public TimestampFilter timestamp() {
    return new TimestampFilter();
  }

  /** Returns the builder for value related filters. */
  public ValueFilter value() {
    return new ValueFilter();
  }

  /** Returns the builder for offset related filters. */
  public OffsetFilter offset() {
    return new OffsetFilter();
  }

  /** Returns the builder for limit related filters. */
  public LimitFilter limit() {
    return new LimitFilter();
  }

  // Miscellaneous filters without a clear target.
  /**
   * Wraps protobuf representation of a filter.
   *
   * <p>For advanced use only.
   */
  public Filter fromProto(RowFilter rowFilter) {
    return new SimpleFilter(rowFilter);
  }

  /** Matches all cells, regardless of input. Functionally equivalent to having no filter. */
  public Filter pass() {
    return PASS;
  }

  /**
   * Does not match any cells, regardless of input. Useful for temporarily disabling just part of a
   * filter.
   */
  public Filter block() {
    return BLOCK;
  }

  /**
   * Outputs all cells directly to the output of the read rather than to any parent filter. For
   * advanced usage, see comments in
   * https://github.com/googleapis/googleapis/blob/master/google/bigtable/v2/data.proto for more
   * details.
   */
  public Filter sink() {
    return SINK;
  }

  /**
   * Applies the given label to all cells in the output row. This allows the caller to determine
   * which results were produced from which part of the filter.
   *
   * <p>Due to a technical limitation, it is not currently possible to apply multiple labels to a
   * cell. As a result, a {@link ChainFilter} may have no more than one sub-filter which contains a
   * label. It is okay for an {@link InterleaveFilter} to contain multiple labels, as they will be
   * applied to separate copies of the input. This may be relaxed in the future.
   */
  public Filter label(@Nonnull String label) {
    Preconditions.checkNotNull(label);
    return new SimpleFilter(RowFilter.newBuilder().setApplyLabelTransformer(label).build());
  }

  // Implementations of target specific filters.
  /** DSL for adding filters to a chain. */
  public static final class ChainFilter implements Filter {
    private RowFilter.Chain.Builder builder;

    private ChainFilter() {
      this.builder = RowFilter.Chain.newBuilder();
    }

    /** Add a filter to chain. */
    public ChainFilter filter(@Nonnull Filter filter) {
      Preconditions.checkNotNull(filter);
      builder.addFilters(filter.toProto());
      return this;
    }

    @InternalApi
    @Override
    public RowFilter toProto() {
      switch (builder.getFiltersCount()) {
        case 0:
          return PASS.toProto();
        case 1:
          return builder.getFilters(0);
        default:
          return RowFilter.newBuilder().setChain(builder.build()).build();
      }
    }

    /** Makes a deep copy of the Chain. */
    @Override
    public ChainFilter clone() {
      try {
        ChainFilter clone = (ChainFilter) super.clone();
        clone.builder = builder.clone();
        return clone;
      } catch (CloneNotSupportedException | ClassCastException e) {
        throw new RuntimeException("should never happen");
      }
    }
  }

  /** DSL for adding filters to the interleave list. */
  public static final class InterleaveFilter implements Filter {
    private RowFilter.Interleave.Builder builder;

    private InterleaveFilter() {
      builder = RowFilter.Interleave.newBuilder();
    }

    /** Adds a {@link Filter} to the interleave list. */
    public InterleaveFilter filter(@Nonnull Filter filter) {
      Preconditions.checkNotNull(filter);
      builder.addFilters(filter.toProto());
      return this;
    }

    @InternalApi
    @Override
    public RowFilter toProto() {
      switch (builder.getFiltersCount()) {
        case 0:
          return PASS.toProto();
        case 1:
          return builder.getFilters(0);
        default:
          return RowFilter.newBuilder().setInterleave(builder.build()).build();
      }
    }

    @Override
    public InterleaveFilter clone() {
      try {
        InterleaveFilter clone = (InterleaveFilter) super.clone();
        clone.builder = builder.clone();
        return clone;
      } catch (CloneNotSupportedException | ClassCastException e) {
        throw new RuntimeException("should never happen");
      }
    }
  }

  /** DSL for configuring a conditional filter. */
  public static final class ConditionFilter implements Filter {
    private RowFilter.Condition.Builder builder;

    private ConditionFilter(@Nonnull Filter predicate) {
      Preconditions.checkNotNull(predicate);
      builder = RowFilter.Condition.newBuilder().setPredicateFilter(predicate.toProto());
    }

    /** Sets (replaces) the filter to apply when the predicate is true. */
    public ConditionFilter then(@Nonnull Filter filter) {
      Preconditions.checkNotNull(filter);
      builder.setTrueFilter(filter.toProto());
      return this;
    }

    /** Sets (replaces) the filter to apply when the predicate is false. */
    public ConditionFilter otherwise(@Nonnull Filter filter) {
      Preconditions.checkNotNull(filter);
      builder.setFalseFilter(filter.toProto());
      return this;
    }

    @InternalApi
    @Override
    public RowFilter toProto() {
      Preconditions.checkState(
          builder.hasTrueFilter() || builder.hasFalseFilter(),
          "ConditionFilter must have either a then or otherwise filter.");
      return RowFilter.newBuilder().setCondition(builder.build()).build();
    }

    @Override
    public ConditionFilter clone() {
      try {
        ConditionFilter clone = (ConditionFilter) super.clone();
        clone.builder = builder.clone();
        return clone;
      } catch (CloneNotSupportedException | ClassCastException e) {
        throw new RuntimeException("should never happen");
      }
    }
  }

  public static final class KeyFilter {
    private KeyFilter() {}

    /**
     * Matches only cells from rows whose keys satisfy the given <a
     * href="https://github.com/google/re2/wiki/Syntax">RE2 regex</a>. In other words, passes
     * through the entire row when the key matches, and otherwise produces an empty row. Note that,
     * since row keys can contain arbitrary bytes, the `\C` escape sequence must be used if a true
     * wildcard is desired. The `.` character will not match the new line character `\n`, which may
     * be present in a binary key.
     */
    public Filter regex(@Nonnull String regex) {
      Preconditions.checkNotNull(regex);
      return regex(ByteString.copyFromUtf8(regex));
    }

    /**
     * Matches only cells from rows whose keys satisfy the given <a
     * href="https://github.com/google/re2/wiki/Syntax">RE2 regex</a>. In other words, passes
     * through the entire row when the key matches, and otherwise produces an empty row. Note that,
     * since row keys can contain arbitrary bytes, the `\C` escape sequence must be used if a true
     * wildcard is desired. The `.` character will not match the new line character `\n`, which may
     * be present in a binary key.
     */
    public Filter regex(@Nonnull ByteString regex) {
      Preconditions.checkNotNull(regex);
      return new SimpleFilter(RowFilter.newBuilder().setRowKeyRegexFilter(regex).build());
    }

    /**
     * Matches only cells from rows whose keys equal the value. In other words, passes through the
     * entire row when the key matches, and otherwise produces an empty row.
     */
    public Filter exactMatch(@Nonnull String value) {
      Preconditions.checkNotNull(value);
      return exactMatch(ByteString.copyFromUtf8(value));
    }

    /**
     * Matches only cells from rows whose keys equal the value. In other words, passes through the
     * entire row when the key matches, and otherwise produces an empty row.
     */
    public Filter exactMatch(@Nonnull ByteString value) {
      Preconditions.checkNotNull(value);

      return regex(RegexUtil.literalRegex(value));
    }

    /**
     * Matches all cells from a row with `probability`, and matches no cells from the row with
     * probability 1-`probability`.
     */
    public Filter sample(double probability) {
      Preconditions.checkArgument(0 <= probability, "Probability must be positive");
      Preconditions.checkArgument(probability <= 1.0, "Probability must be less than 1.0");

      return new SimpleFilter(RowFilter.newBuilder().setRowSampleFilter(probability).build());
    }
  }

  public static final class FamilyFilter {
    private FamilyFilter() {}

    /**
     * Matches only cells from columns whose families satisfy the given <a
     * href="https://github.com/google/re2/wiki/Syntax">RE2 regex</a>. For technical reasons, the
     * regex must not contain the `:` character, even if it is not being used as a literal. Note
     * that, since column families cannot contain the new line character `\n`, it is sufficient to
     * use `.` as a full wildcard when matching column family names.
     */
    public Filter regex(@Nonnull String regex) {
      Preconditions.checkNotNull(regex);
      return new SimpleFilter(RowFilter.newBuilder().setFamilyNameRegexFilter(regex).build());
    }

    /** Matches only cells from columns whose families match the value. */
    public Filter exactMatch(@Nonnull String value) {
      Preconditions.checkNotNull(value);
      return regex(RegexUtil.literalRegex(value));
    }
  }

  public static final class QualifierFilter {
    private QualifierFilter() {}

    /**
     * Matches only cells from columns whose qualifiers satisfy the given <a
     * href="https://github.com/google/re2/wiki/Syntax">RE2 regex</a>. Note that, since column
     * qualifiers can contain arbitrary bytes, the `\C` escape sequence must be used if a true
     * wildcard is desired. The `.` character will not match the new line character `\n`, which may
     * be present in a binary qualifier.
     */
    public Filter regex(@Nonnull String regex) {
      Preconditions.checkNotNull(regex);
      return regex(ByteString.copyFromUtf8(regex));
    }

    /**
     * Matches only cells from columns whose qualifiers satisfy the given <a
     * href="https://github.com/google/re2/wiki/Syntax">RE2 regex</a>. Note that, since column
     * qualifiers can contain arbitrary bytes, the `\C` escape sequence must be used if a true
     * wildcard is desired. The `.` character will not match the new line character `\n`, which may
     * be present in a binary qualifier.
     */
    public Filter regex(@Nonnull ByteString regex) {
      Preconditions.checkNotNull(regex);

      return new SimpleFilter(RowFilter.newBuilder().setColumnQualifierRegexFilter(regex).build());
    }

    /** Matches only cells from columns whose qualifiers equal the value. */
    public Filter exactMatch(@Nonnull String value) {
      Preconditions.checkNotNull(value);
      return exactMatch(ByteString.copyFromUtf8(value));
    }

    /** Matches only cells from columns whose qualifiers equal the value. */
    public Filter exactMatch(@Nonnull ByteString value) {
      Preconditions.checkNotNull(value);
      return regex(RegexUtil.literalRegex(value));
    }

    /**
     * Construct a {@link QualifierRangeFilter} that can create a {@link ColumnRange} oriented
     * {@link Filter}.
     *
     * @return a new {@link QualifierRangeFilter}
     */
    public QualifierRangeFilter rangeWithinFamily(@Nonnull String family) {
      Preconditions.checkNotNull(family);
      return new QualifierRangeFilter(family);
    }
  }

  /** Matches only cells from columns within the given range. */
  public static final class QualifierRangeFilter
      extends AbstractByteStringRange<QualifierRangeFilter> implements Filter, Serializable {
    private final String family;

    private QualifierRangeFilter(String family) {
      this.family = family;
    }

    @InternalApi
    @Override
    public RowFilter toProto() {
      ColumnRange.Builder builder = ColumnRange.newBuilder().setFamilyName(family);

      switch (getStartBound()) {
        case CLOSED:
          builder.setStartQualifierClosed(getStart());
          break;
        case OPEN:
          builder.setStartQualifierOpen(getStart());
          break;
        case UNBOUNDED:
          break;
        default:
          throw new IllegalStateException("Unknown start bound: " + getStartBound());
      }
      switch (getEndBound()) {
        case CLOSED:
          builder.setEndQualifierClosed(getEnd());
          break;
        case OPEN:
          builder.setEndQualifierOpen(getEnd());
          break;
        case UNBOUNDED:
          break;
        default:
          throw new IllegalStateException("Unknown end bound: " + getEndBound());
      }

      return RowFilter.newBuilder().setColumnRangeFilter(builder.build()).build();
    }

    @Override
    public QualifierRangeFilter clone() {
      return super.clone();
    }
  }

  public static final class TimestampFilter {
    private TimestampFilter() {}

    /**
     * Matches only cells with timestamps within the given range.
     *
     * @return a {@link TimestampRangeFilter} on which start / end timestamps can be specified.
     */
    public TimestampRangeFilter range() {
      return new TimestampRangeFilter();
    }
  }

  /** Matches only cells with microsecond timestamps within the given range. */
  public static final class TimestampRangeFilter
      extends AbstractTimestampRange<TimestampRangeFilter> implements Filter, Serializable {
    private TimestampRangeFilter() {}

    @InternalApi
    @Override
    public RowFilter toProto() {
      com.google.bigtable.v2.TimestampRange.Builder builder =
          com.google.bigtable.v2.TimestampRange.newBuilder();

      switch (getStartBound()) {
        case CLOSED:
          builder.setStartTimestampMicros(getStart());
          break;
        case OPEN:
          builder.setStartTimestampMicros(getStart() + 1);
          break;
        case UNBOUNDED:
          break;
        default:
          throw new IllegalStateException("Unknown start bound: " + getStartBound());
      }
      switch (getEndBound()) {
        case CLOSED:
          builder.setEndTimestampMicros(getEnd() + 1);
          break;
        case OPEN:
          builder.setEndTimestampMicros(getEnd());
          break;
        case UNBOUNDED:
          break;
        default:
          throw new IllegalStateException("Unknown end bound: " + getEndBound());
      }
      return RowFilter.newBuilder().setTimestampRangeFilter(builder.build()).build();
    }

    @Override
    public TimestampRangeFilter clone() {
      return super.clone();
    }
  }

  public static final class ValueFilter {
    private ValueFilter() {}

    /**
     * Matches only cells with values that satisfy the given <a
     * href="https://github.com/google/re2/wiki/Syntax">RE2 regex</a>. Note that, since cell values
     * can contain arbitrary bytes, the `\C` escape sequence must be used if a true wildcard is
     * desired. The `.` character will not match the new line character `\n`, which may be present
     * in a binary value.
     */
    public Filter regex(@Nonnull String regex) {
      Preconditions.checkNotNull(regex);
      return regex(ByteString.copyFromUtf8(regex));
    }

    /** Matches only cells with values that match the given value. */
    public Filter exactMatch(@Nonnull String value) {
      Preconditions.checkNotNull(value);
      return exactMatch(ByteString.copyFromUtf8(value));
    }

    /** Matches only cells with values that match the given value. */
    public Filter exactMatch(@Nonnull ByteString value) {
      Preconditions.checkNotNull(value);
      return regex(RegexUtil.literalRegex(value));
    }

    /**
     * Matches only cells with values that satisfy the given <a
     * href="https://github.com/google/re2/wiki/Syntax">RE2 regex</a>. Note that, since cell values
     * can contain arbitrary bytes, the `\C` escape sequence must be used if a true wildcard is
     * desired. The `.` character will not match the new line character `\n`, which may be present
     * in a binary value.
     */
    public Filter regex(@Nonnull ByteString regex) {
      Preconditions.checkNotNull(regex);
      return new SimpleFilter(RowFilter.newBuilder().setValueRegexFilter(regex).build());
    }

    /**
     * Construct a {@link ValueRangeFilter} that can create a {@link ValueRange} oriented {@link
     * Filter}.
     *
     * @return a new {@link ValueRangeFilter}
     */
    public ValueRangeFilter range() {
      return new ValueRangeFilter();
    }

    /** Replaces each cell's value with the empty string. */
    public Filter strip() {
      return STRIP_VALUE;
    }
  }

  /** Matches only cells with values that fall within the given value range. */
  public static final class ValueRangeFilter extends AbstractByteStringRange<ValueRangeFilter>
      implements Filter, Serializable {
    private ValueRangeFilter() {}

    @InternalApi
    @Override
    public RowFilter toProto() {
      ValueRange.Builder builder = ValueRange.newBuilder();
      switch (getStartBound()) {
        case CLOSED:
          builder.setStartValueClosed(getStart());
          break;
        case OPEN:
          builder.setStartValueOpen(getStart());
          break;
        case UNBOUNDED:
          break;
        default:
          throw new IllegalStateException("Unknown start bound: " + getStartBound());
      }
      switch (getEndBound()) {
        case CLOSED:
          builder.setEndValueClosed(getEnd());
          break;
        case OPEN:
          builder.setEndValueOpen(getEnd());
          break;
        case UNBOUNDED:
          break;
        default:
          throw new IllegalStateException("Unknown end bound: " + getEndBound());
      }
      return RowFilter.newBuilder().setValueRangeFilter(builder.build()).build();
    }

    @Override
    public ValueRangeFilter clone() {
      return super.clone();
    }
  }

  public static final class OffsetFilter {
    private OffsetFilter() {}

    /**
     * Skips the first N cells of each row, matching all subsequent cells. If duplicate cells are
     * present, as is possible when using an {@link InterleaveFilter}, each copy of the cell is
     * counted separately.
     */
    public Filter cellsPerRow(int count) {
      return new SimpleFilter(RowFilter.newBuilder().setCellsPerRowOffsetFilter(count).build());
    }
  }

  public static final class LimitFilter {
    private LimitFilter() {}

    /**
     * Matches only the first N cells of each row. If duplicate cells are present, as is possible
     * when using an Interleave, each copy of the cell is counted separately.
     */
    public Filter cellsPerRow(int count) {
      return new SimpleFilter(RowFilter.newBuilder().setCellsPerRowLimitFilter(count).build());
    }

    /**
     * Matches only the most recent `count` cells within each column. For example, if count=2, this
     * filter would match column `foo:bar` at timestamps 10 and 9 skip all earlier cells in
     * `foo:bar`, and then begin matching again in column `foo:bar2`. If duplicate cells are
     * present, as is possible when using an {@link InterleaveFilter}, each copy of the cell is
     * counted separately.
     */
    public Filter cellsPerColumn(int count) {
      return new SimpleFilter(RowFilter.newBuilder().setCellsPerColumnLimitFilter(count).build());
    }
  }

  private static final class SimpleFilter implements Filter {
    private final RowFilter proto;

    private SimpleFilter(@Nonnull RowFilter proto) {
      Preconditions.checkNotNull(proto);
      this.proto = proto;
    }

    @InternalApi
    @Override
    public RowFilter toProto() {
      return proto;
    }

    @Override
    public SimpleFilter clone() {
      try {
        return (SimpleFilter) super.clone();
      } catch (CloneNotSupportedException e) {
        throw new RuntimeException("should never happen", e);
      }
    }
  }

  @InternalExtensionOnly
  public interface Filter extends Cloneable {
    @InternalApi
    RowFilter toProto();
  }
}
