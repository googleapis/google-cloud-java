/*
 * Copyright 2026 Google LLC
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

package com.google.cloud.firestore.pipeline.expressions;

import static com.google.cloud.firestore.PipelineUtils.encodeValue;

import com.google.api.core.InternalApi;
import com.google.cloud.firestore.FieldPath;
import com.google.common.collect.ImmutableList;
import com.google.common.collect.Lists;
import com.google.firestore.v1.Value;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import javax.annotation.Nullable;

/**
 * Specification for a window in an {@code addWindowFields} stage, defining how documents are
 * partitioned, ordered, and framed.
 *
 * <p><b>Sort and frame interaction:</b>
 *
 * <ul>
 *   <li>For document-based ({@link #documents}) window frames, {@code sort} is optional. If no sort
 *       expressions are specified, documents are processed in incoming stream (fetch) order.
 *   <li>For range-based ({@link #range}) window frames whose bounds are only {@link
 *       WindowBound#CURRENT} or {@link WindowBound#UNBOUNDED} (and without a time {@code unit}),
 *       one or more {@code sort} expressions are required and may be of any sortable type
 *       (including strings and booleans). Range frames with numeric or time offsets (or a time
 *       {@code unit}) require a single numeric or timestamp {@code sort} expression.
 *   <li>When neither {@code documents} nor {@code range} is specified, omitting {@code sort}
 *       defaults the frame to {@code documents(WindowBound.UNBOUNDED, WindowBound.UNBOUNDED)} (the
 *       entire partition), while specifying {@code sort} defaults the frame to {@code
 *       range(WindowBound.UNBOUNDED, WindowBound.CURRENT)}.
 * </ul>
 */
public final class WindowSpec {
  private final List<Expression> partition;
  private final List<Ordering> sort;
  @Nullable private final Frame documentsFrame;
  @Nullable private final Frame rangeFrame;

  static final class Frame {
    final Expression preceding;
    final Expression following;
    @Nullable final Expression unit;

    Frame(Expression preceding, Expression following, @Nullable Expression unit) {
      this.preceding = preceding;
      this.following = following;
      this.unit = unit;
    }

    Frame(Expression preceding, Expression following) {
      this(preceding, following, null);
    }
  }

  WindowSpec(
      List<Expression> partition,
      List<Ordering> sort,
      @Nullable Frame documentsFrame,
      @Nullable Frame rangeFrame) {
    this.partition = ImmutableList.copyOf(partition);
    this.sort = ImmutableList.copyOf(sort);
    this.documentsFrame = documentsFrame;
    this.rangeFrame = rangeFrame;
  }

  /**
   * Creates an empty window spec: a single global partition covering the entire result set, with no
   * sort and no explicit frame.
   */
  public WindowSpec() {
    this(Collections.emptyList(), Collections.emptyList(), null, null);
  }

  /** Specify partition group columns. */
  public WindowSpec partition(Expression expression, Object... additionalExpressions) {
    return new WindowSpec(
        resolveGroups(expression, additionalExpressions), this.sort, documentsFrame, rangeFrame);
  }

  public WindowSpec partition(String fieldName, Object... additionalExpressions) {
    return new WindowSpec(
        resolveGroups(fieldName, additionalExpressions), this.sort, documentsFrame, rangeFrame);
  }

  /**
   * Specifies the sort order of documents within each partition.
   *
   * <p>For document-based ({@link #documents}) window frames, {@code sort} is optional; if no sort
   * expressions are specified, documents are processed in incoming stream (fetch) order. For
   * range-based ({@link #range}) window frames whose bounds are only {@link WindowBound#CURRENT} or
   * {@link WindowBound#UNBOUNDED} (without a time {@code unit}), one or more {@code sort}
   * expressions are required and may be of any sortable type (including strings and booleans);
   * range frames with numeric or time offsets require a single numeric or timestamp {@code sort}
   * expression.
   *
   * <p>Setting {@code sort} without an explicit {@code documents} or {@code range} frame changes
   * the default window frame from {@code documents(WindowBound.UNBOUNDED, WindowBound.UNBOUNDED)}
   * (when {@code sort} is omitted) to {@code range(WindowBound.UNBOUNDED, WindowBound.CURRENT)}
   * (when {@code sort} is specified).
   */
  public WindowSpec sort(Ordering order, Ordering... additionalOrders) {
    Ordering[] allOrders = new Ordering[additionalOrders.length + 1];
    allOrders[0] = order;
    System.arraycopy(additionalOrders, 0, allOrders, 1, additionalOrders.length);
    return new WindowSpec(partition, Arrays.asList(allOrders), documentsFrame, rangeFrame);
  }

  /**
   * Specifies the sort order of documents within each partition.
   *
   * <p>For document-based ({@link #documents}) window frames, {@code sort} is optional; if no sort
   * expressions are specified, documents are processed in incoming stream (fetch) order. For
   * range-based ({@link #range}) window frames whose bounds are only {@link WindowBound#CURRENT} or
   * {@link WindowBound#UNBOUNDED} (without a time {@code unit}), one or more {@code sort}
   * expressions are required and may be of any sortable type (including strings and booleans);
   * range frames with numeric or time offsets require a single numeric or timestamp {@code sort}
   * expression.
   *
   * <p>Setting {@code sort} without an explicit {@code documents} or {@code range} frame changes
   * the default window frame from {@code documents(WindowBound.UNBOUNDED, WindowBound.UNBOUNDED)}
   * (when {@code sort} is omitted) to {@code range(WindowBound.UNBOUNDED, WindowBound.CURRENT)}
   * (when {@code sort} is specified).
   */
  public WindowSpec sort(List<Ordering> orders) {
    return new WindowSpec(partition, orders, documentsFrame, rangeFrame);
  }

  // A window has at most one frame: `documents` and `range` are mutually exclusive (the backend
  // rejects a spec carrying both). The frame setters therefore *replace* the whole frame state
  // rather than merging into it, so the last call wins — `range(1, 2).documents(3, 4)` is a
  // documents frame, exactly as `documents(1, 2).documents(3, 4)` is `documents(3, 4)`.

  private WindowSpec withDocumentsFrame(Object preceding, Object following) {
    return new WindowSpec(
        partition, sort, new Frame(toBoundaryExpr(preceding), toBoundaryExpr(following)), null);
  }

  private WindowSpec withRangeFrame(Object preceding, Object following, @Nullable Object unit) {
    return new WindowSpec(
        partition,
        sort,
        null,
        new Frame(
            toBoundaryExpr(preceding),
            toBoundaryExpr(following),
            unit != null ? Expression.toExprOrConstant(unit) : null));
  }

  /**
   * Specify a document-count based window frame.
   *
   * <p>{@code sort} is optional for document frames; if no {@code sort} is specified, documents are
   * processed in incoming stream (fetch) order.
   *
   * @param preceding A positive integer (e.g. {@code 2}) includes up to that many documents before
   *     the current document. A negative integer (e.g. {@code -1}) indicates a boundary following
   *     the current document, enabling frames that start after the current document.
   * @param following A positive integer (e.g. {@code 2}) includes up to that many documents after
   *     the current document. A negative integer (e.g. {@code -1}) indicates a boundary preceding
   *     the current document, enabling frames that end before the current document (e.g. excluding
   *     the current document).
   */
  public WindowSpec documents(int preceding, int following) {
    return withDocumentsFrame(preceding, following);
  }

  /**
   * Specify a document-count frame using symbolic bounds, e.g. {@code (WindowBound.UNBOUNDED,
   * WindowBound.CURRENT)}.
   *
   * <p>{@code sort} is optional for document frames; if no {@code sort} is specified, documents are
   * processed in incoming stream (fetch) order.
   *
   * @param preceding The symbolic lower bound of the frame ({@link WindowBound#UNBOUNDED} or {@link
   *     WindowBound#CURRENT}).
   * @param following The symbolic upper bound of the frame ({@link WindowBound#UNBOUNDED} or {@link
   *     WindowBound#CURRENT}).
   */
  public WindowSpec documents(WindowBound preceding, WindowBound following) {
    return withDocumentsFrame(preceding, following);
  }

  /**
   * Specify a document-count frame using expression bounds.
   *
   * <p>{@code sort} is optional for document frames; if no {@code sort} is specified, documents are
   * processed in incoming stream (fetch) order.
   *
   * @param preceding An expression evaluating to the lower bound of the frame. A positive integer
   *     (e.g. {@code 2}) includes up to that many documents before the current document. A negative
   *     integer (e.g. {@code -1}) indicates a boundary following the current document, enabling
   *     frames that start after the current document.
   * @param following An expression evaluating to the upper bound of the frame. A positive integer
   *     (e.g. {@code 2}) includes up to that many documents after the current document. A negative
   *     integer (e.g. {@code -1}) indicates a boundary preceding the current document, enabling
   *     frames that end before the current document (e.g. excluding the current document).
   */
  public WindowSpec documents(Expression preceding, Expression following) {
    return withDocumentsFrame(preceding, following);
  }

  /**
   * Specify a document-count frame with bounds of mixed or heterogeneous types, e.g. {@code (int,
   * Expression)} or {@code (String, String)}. Invalid combinations are encoded and rejected by the
   * backend.
   *
   * <p>{@code sort} is optional for document frames; if no {@code sort} is specified, documents are
   * processed in incoming stream (fetch) order.
   *
   * @param preceding The lower bound of the frame (an integer offset, {@link WindowBound}, or
   *     {@link Expression}). A positive integer (e.g. {@code 2}) includes up to that many documents
   *     before the current document. A negative integer (e.g. {@code -1}) indicates a boundary
   *     following the current document, enabling frames that start after the current document.
   * @param following The upper bound of the frame (an integer offset, {@link WindowBound}, or
   *     {@link Expression}). A positive integer (e.g. {@code 2}) includes up to that many documents
   *     after the current document. A negative integer (e.g. {@code -1}) indicates a boundary
   *     preceding the current document, enabling frames that end before the current document (e.g.
   *     excluding the current document).
   */
  public WindowSpec documents(Object preceding, Object following) {
    return withDocumentsFrame(preceding, following);
  }

  /**
   * Specify a range-value based window frame.
   *
   * <p>A single numeric {@code sort} expression is required when using numeric range offsets.
   *
   * @param preceding A positive offset subtracts from the current document's sort value (looking
   *     into the past). A negative offset adds to the current document's sort value (shifting the
   *     lower boundary past the current document).
   * @param following A positive offset adds to the current document's sort value (looking into the
   *     future). A negative offset subtracts from the current document's sort value (shifting the
   *     upper boundary before the current document).
   */
  public WindowSpec range(int preceding, int following) {
    return withRangeFrame(preceding, following, null);
  }

  /**
   * Specify a time-range based window frame with a time {@code unit}.
   *
   * <p>A single timestamp {@code sort} expression is required when using a time-range window frame.
   *
   * <p>Supported duration units are {@code "microsecond"}, {@code "millisecond"}, {@code "second"},
   * {@code "minute"}, {@code "hour"}, {@code "day"}, {@code "week"}, {@code "month"}, {@code
   * "quarter"}, and {@code "year"}.
   *
   * @param preceding A positive offset subtracts from the current document's sort value (looking
   *     into the past). A negative offset adds to the current document's sort value (shifting the
   *     lower boundary past the current document).
   * @param following A positive offset adds to the current document's sort value (looking into the
   *     future). A negative offset subtracts from the current document's sort value (shifting the
   *     upper boundary before the current document).
   * @param unit The duration unit for the time-range offsets.
   */
  public WindowSpec range(int preceding, int following, String unit) {
    return withRangeFrame(preceding, following, unit);
  }

  /**
   * Specify a time-range based window frame with a time {@code unit} expression.
   *
   * <p>A single timestamp {@code sort} expression is required when using a time-range window frame.
   *
   * @param preceding A positive offset subtracts from the current document's sort value (looking
   *     into the past). A negative offset adds to the current document's sort value (shifting the
   *     lower boundary past the current document).
   * @param following A positive offset adds to the current document's sort value (looking into the
   *     future). A negative offset subtracts from the current document's sort value (shifting the
   *     upper boundary before the current document).
   * @param unit An expression evaluating to the duration unit for the time-range offsets.
   */
  public WindowSpec range(int preceding, int following, Expression unit) {
    return withRangeFrame(preceding, following, unit);
  }

  /**
   * Specify a range frame using symbolic bounds, e.g. {@code (WindowBound.UNBOUNDED,
   * WindowBound.CURRENT)}.
   *
   * <p>One or more {@code sort} expressions are required and may be of any sortable type (including
   * strings and booleans) when both bounds are symbolic ({@link WindowBound#CURRENT} or {@link
   * WindowBound#UNBOUNDED}) and no time {@code unit} is specified.
   *
   * @param preceding The symbolic lower bound of the frame ({@link WindowBound#UNBOUNDED} or {@link
   *     WindowBound#CURRENT}).
   * @param following The symbolic upper bound of the frame ({@link WindowBound#UNBOUNDED} or {@link
   *     WindowBound#CURRENT}).
   */
  public WindowSpec range(WindowBound preceding, WindowBound following) {
    return withRangeFrame(preceding, following, null);
  }

  /**
   * Specify a time-range frame using symbolic bounds and a time {@code unit}.
   *
   * <p>A timestamp {@code sort} expression is required when specifying a time {@code unit}.
   *
   * <p>Supported duration units are {@code "microsecond"}, {@code "millisecond"}, {@code "second"},
   * {@code "minute"}, {@code "hour"}, {@code "day"}, {@code "week"}, {@code "month"}, {@code
   * "quarter"}, and {@code "year"}.
   *
   * @param preceding The symbolic lower bound of the frame ({@link WindowBound#UNBOUNDED} or {@link
   *     WindowBound#CURRENT}).
   * @param following The symbolic upper bound of the frame ({@link WindowBound#UNBOUNDED} or {@link
   *     WindowBound#CURRENT}).
   * @param unit The duration unit for the time-range frame.
   */
  public WindowSpec range(WindowBound preceding, WindowBound following, String unit) {
    return withRangeFrame(preceding, following, unit);
  }

  /**
   * Specify a time-range frame using symbolic bounds and a time {@code unit} expression.
   *
   * <p>A timestamp {@code sort} expression is required when specifying a time {@code unit}.
   *
   * @param preceding The symbolic lower bound of the frame ({@link WindowBound#UNBOUNDED} or {@link
   *     WindowBound#CURRENT}).
   * @param following The symbolic upper bound of the frame ({@link WindowBound#UNBOUNDED} or {@link
   *     WindowBound#CURRENT}).
   * @param unit An expression evaluating to the duration unit for the time-range frame.
   */
  public WindowSpec range(WindowBound preceding, WindowBound following, Expression unit) {
    return withRangeFrame(preceding, following, unit);
  }

  /**
   * Specify a numeric range frame with fractional bounds.
   *
   * <p>Only meaningful for value-based (non-time) range frames, e.g. when sorting by a price or
   * score. The backend rejects fractional offsets for time-based range frames. A single numeric
   * {@code sort} expression is required when using numeric range offsets.
   *
   * @param preceding A positive offset subtracts from the current document's sort value (looking
   *     into the past). A negative offset adds to the current document's sort value (shifting the
   *     lower boundary past the current document).
   * @param following A positive offset adds to the current document's sort value (looking into the
   *     future). A negative offset subtracts from the current document's sort value (shifting the
   *     upper boundary before the current document).
   */
  public WindowSpec range(double preceding, double following) {
    return withRangeFrame(preceding, following, null);
  }

  /**
   * Specify a time-range frame with fractional bounds and a time {@code unit}.
   *
   * <p>Supported duration units are {@code "microsecond"}, {@code "millisecond"}, {@code "second"},
   * {@code "minute"}, {@code "hour"}, {@code "day"}, {@code "week"}, {@code "month"}, {@code
   * "quarter"}, and {@code "year"}.
   *
   * @param preceding A positive offset subtracts from the current document's sort value (looking
   *     into the past). A negative offset adds to the current document's sort value (shifting the
   *     lower boundary past the current document).
   * @param following A positive offset adds to the current document's sort value (looking into the
   *     future). A negative offset subtracts from the current document's sort value (shifting the
   *     upper boundary before the current document).
   * @param unit The duration unit for the time-range offsets.
   */
  public WindowSpec range(double preceding, double following, String unit) {
    return withRangeFrame(preceding, following, unit);
  }

  /**
   * Specify a time-range frame with fractional bounds and a time {@code unit} expression.
   *
   * @param preceding A positive offset subtracts from the current document's sort value (looking
   *     into the past). A negative offset adds to the current document's sort value (shifting the
   *     lower boundary past the current document).
   * @param following A positive offset adds to the current document's sort value (looking into the
   *     future). A negative offset subtracts from the current document's sort value (shifting the
   *     upper boundary before the current document).
   * @param unit An expression evaluating to the duration unit for the time-range offsets.
   */
  public WindowSpec range(double preceding, double following, Expression unit) {
    return withRangeFrame(preceding, following, unit);
  }

  /**
   * Specify a range frame with bounds of mixed or heterogeneous types, e.g. {@code (int,
   * Expression)} or {@code (String, String)}. Invalid combinations are encoded and rejected by the
   * backend.
   *
   * <p>One or more {@code sort} expressions are required when both bounds are symbolic ({@link
   * WindowBound#CURRENT} or {@link WindowBound#UNBOUNDED}); a single numeric {@code sort}
   * expression is required when either bound is a numeric offset.
   *
   * @param preceding The lower bound of the frame (a numeric offset, {@link WindowBound}, or {@link
   *     Expression}). A positive offset subtracts from the current document's sort value (looking
   *     into the past). A negative offset adds to the current document's sort value (shifting the
   *     lower boundary past the current document).
   * @param following The upper bound of the frame (a numeric offset, {@link WindowBound}, or {@link
   *     Expression}). A positive offset adds to the current document's sort value (looking into the
   *     future). A negative offset subtracts from the current document's sort value (shifting the
   *     upper boundary before the current document).
   */
  public WindowSpec range(Object preceding, Object following) {
    return withRangeFrame(preceding, following, null);
  }

  /**
   * Specify a time-range frame with bounds of mixed or heterogeneous types and a time {@code unit}.
   *
   * <p>A single timestamp {@code sort} expression is required when using a time-range window frame.
   *
   * <p>Supported duration units are {@code "microsecond"}, {@code "millisecond"}, {@code "second"},
   * {@code "minute"}, {@code "hour"}, {@code "day"}, {@code "week"}, {@code "month"}, {@code
   * "quarter"}, and {@code "year"}.
   *
   * @param preceding The lower bound of the frame (a numeric offset, {@link WindowBound}, or {@link
   *     Expression}). A positive offset subtracts from the current document's sort value (looking
   *     into the past). A negative offset adds to the current document's sort value (shifting the
   *     lower boundary past the current document).
   * @param following The upper bound of the frame (a numeric offset, {@link WindowBound}, or {@link
   *     Expression}). A positive offset adds to the current document's sort value (looking into the
   *     future). A negative offset subtracts from the current document's sort value (shifting the
   *     upper boundary before the current document).
   * @param unit The duration unit for the time-range offsets.
   */
  public WindowSpec range(Object preceding, Object following, String unit) {
    return withRangeFrame(preceding, following, unit);
  }

  /**
   * Specify a time-range frame with bounds of mixed or heterogeneous types and a time {@code unit}
   * expression.
   *
   * @param preceding The lower bound of the frame (a numeric offset, {@link WindowBound}, or {@link
   *     Expression}). A positive offset subtracts from the current document's sort value (looking
   *     into the past). A negative offset adds to the current document's sort value (shifting the
   *     lower boundary past the current document).
   * @param following The upper bound of the frame (a numeric offset, {@link WindowBound}, or {@link
   *     Expression}). A positive offset adds to the current document's sort value (looking into the
   *     future). A negative offset subtracts from the current document's sort value (shifting the
   *     upper boundary before the current document).
   * @param unit An expression evaluating to the duration unit for the time-range offsets.
   */
  public WindowSpec range(Object preceding, Object following, Expression unit) {
    return withRangeFrame(preceding, following, unit);
  }

  /**
   * Specify a range frame using expression bounds.
   *
   * <p>One or more {@code sort} expressions are required when both bounds are symbolic ({@link
   * WindowBound#CURRENT} or {@link WindowBound#UNBOUNDED}); a single numeric {@code sort}
   * expression is required when either bound is a numeric offset.
   *
   * @param preceding An expression evaluating to the lower bound of the frame. A positive offset
   *     subtracts from the current document's sort value (looking into the past). A negative offset
   *     adds to the current document's sort value (shifting the lower boundary past the current
   *     document).
   * @param following An expression evaluating to the upper bound of the frame. A positive offset
   *     adds to the current document's sort value (looking into the future). A negative offset
   *     subtracts from the current document's sort value (shifting the upper boundary before the
   *     current document).
   */
  public WindowSpec range(Expression preceding, Expression following) {
    return withRangeFrame(preceding, following, null);
  }

  /**
   * Specify a time-range frame using expression bounds and a time {@code unit}.
   *
   * <p>A single timestamp {@code sort} expression is required when using a time-range window frame.
   *
   * <p>Supported duration units are {@code "microsecond"}, {@code "millisecond"}, {@code "second"},
   * {@code "minute"}, {@code "hour"}, {@code "day"}, {@code "week"}, {@code "month"}, {@code
   * "quarter"}, and {@code "year"}.
   *
   * @param preceding An expression evaluating to the lower bound of the frame. A positive offset
   *     subtracts from the current document's sort value (looking into the past). A negative offset
   *     adds to the current document's sort value (shifting the lower boundary past the current
   *     document).
   * @param following An expression evaluating to the upper bound of the frame. A positive offset
   *     adds to the current document's sort value (looking into the future). A negative offset
   *     subtracts from the current document's sort value (shifting the upper boundary before the
   *     current document).
   * @param unit The duration unit for the time-range offsets.
   */
  public WindowSpec range(Expression preceding, Expression following, String unit) {
    return withRangeFrame(preceding, following, unit);
  }

  /**
   * Specify a time-range frame using expression bounds and a time {@code unit} expression.
   *
   * @param preceding An expression evaluating to the lower bound of the frame. A positive offset
   *     subtracts from the current document's sort value (looking into the past). A negative offset
   *     adds to the current document's sort value (shifting the lower boundary past the current
   *     document).
   * @param following An expression evaluating to the upper bound of the frame. A positive offset
   *     adds to the current document's sort value (looking into the future). A negative offset
   *     subtracts from the current document's sort value (shifting the upper boundary before the
   *     current document).
   * @param unit An expression evaluating to the duration unit for the time-range offsets.
   */
  public WindowSpec range(Expression preceding, Expression following, Expression unit) {
    return withRangeFrame(preceding, following, unit);
  }

  @InternalApi
  public Value buildInternal() {
    Map<String, Value> fields = new LinkedHashMap<>();

    if (!partition.isEmpty()) {
      fields.put("partition", encodeValue(Lists.transform(partition, FunctionUtils::exprToValue)));
    }

    if (!sort.isEmpty()) {
      fields.put("sort", encodeValue(Lists.transform(sort, Ordering::toProto)));
    }

    if (documentsFrame != null) {
      fields.put("documents", frameToProto(documentsFrame));
    }

    if (rangeFrame != null) {
      fields.put("range", frameToProto(rangeFrame));
    }

    return encodeValue(fields);
  }

  /**
   * Builds a frame {@code MapValue}. The {@code unit} is nested <i>inside</i> the frame, alongside
   * {@code preceding} and {@code following}.
   */
  private static Value frameToProto(Frame frame) {
    Map<String, Value> fields = new LinkedHashMap<>();
    fields.put("preceding", FunctionUtils.exprToValue(frame.preceding));
    fields.put("following", FunctionUtils.exprToValue(frame.following));
    if (frame.unit != null) {
      fields.put("unit", FunctionUtils.exprToValue(frame.unit));
    }
    return encodeValue(fields);
  }

  @Override
  public boolean equals(Object other) {
    return this == other
        || (other instanceof WindowSpec
            && Objects.equals(buildInternal(), ((WindowSpec) other).buildInternal()));
  }

  @Override
  public int hashCode() {
    return buildInternal().hashCode();
  }

  static List<Expression> resolveGroups(Object first, Object... additional) {
    Object[] groups = new Object[additional.length + 1];
    groups[0] = first;
    System.arraycopy(additional, 0, groups, 1, additional.length);

    List<Expression> result = new ArrayList<>(groups.length);
    for (Object it : groups) {
      if (it instanceof String) {
        result.add(Expression.field((String) it));
      } else if (it instanceof FieldPath) {
        result.add(Expression.field((FieldPath) it));
      } else if (it instanceof Expression) {
        result.add((Expression) it);
      } else {
        throw new IllegalArgumentException("Invalid partition group type: " + it);
      }
    }
    return result;
  }

  /**
   * Converts a frame boundary into an {@link Expression}.
   *
   * <p>Symbolic bounds are expressed with {@link WindowBound} and encode on the wire as the strings
   * {@code "current"} / {@code "unbounded"}, whereas other values are converted via {@link
   * Expression#toExprOrConstant} (so a numeric offset of {@code 0} encodes on the wire as the
   * integer {@code 0} rather than {@code "current"}, even though both are semantically equivalent).
   */
  private static Expression toBoundaryExpr(Object boundary) {
    if (boundary instanceof WindowBound) {
      return Expression.constant(((WindowBound) boundary).wireName());
    } else {
      return Expression.toExprOrConstant(boundary);
    }
  }
}
