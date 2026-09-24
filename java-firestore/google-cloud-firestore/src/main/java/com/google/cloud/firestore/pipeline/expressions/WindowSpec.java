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

  /**
   * Alias for {@link WindowBound#CURRENT}: the current document's position as a frame boundary.
   *
   * <p>Note this is <i>not</i> the same as a numeric offset of {@code 0} — see {@link WindowBound}.
   */
  public static final WindowBound CURRENT = WindowBound.CURRENT;

  /** Alias for {@link WindowBound#UNBOUNDED}: no boundary in this direction. */
  public static final WindowBound UNBOUNDED = WindowBound.UNBOUNDED;

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

  public List<Expression> getPartition() {
    return partition;
  }

  public List<Ordering> getSort() {
    return sort;
  }

  /** Specify partition group columns. */
  public WindowSpec withPartition(Expression expression, Object... additionalExpressions) {
    return new WindowSpec(
        resolveGroups(expression, additionalExpressions), this.sort, documentsFrame, rangeFrame);
  }

  public WindowSpec withPartition(String fieldName, Object... additionalExpressions) {
    return new WindowSpec(
        resolveGroups(fieldName, additionalExpressions), this.sort, documentsFrame, rangeFrame);
  }

  public WindowSpec withPartition(FieldPath fieldPath, Object... additionalExpressions) {
    return new WindowSpec(
        resolveGroups(fieldPath, additionalExpressions), this.sort, documentsFrame, rangeFrame);
  }

  /** Specify sort order for this window spec. */
  public WindowSpec withSort(Ordering order, Ordering... additionalOrders) {
    Ordering[] allOrders = new Ordering[additionalOrders.length + 1];
    allOrders[0] = order;
    System.arraycopy(additionalOrders, 0, allOrders, 1, additionalOrders.length);
    return new WindowSpec(partition, Arrays.asList(allOrders), documentsFrame, rangeFrame);
  }

  public WindowSpec withSort(List<Ordering> orders) {
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

  /** Specify document-count based window frame. */
  public WindowSpec withDocuments(int preceding, int following) {
    return withDocumentsFrame(preceding, following);
  }

  /** Specify a document-count frame using symbolic bounds, e.g. {@code (UNBOUNDED, CURRENT)}. */
  public WindowSpec withDocuments(WindowBound preceding, WindowBound following) {
    return withDocumentsFrame(preceding, following);
  }

  public WindowSpec withDocuments(Expression preceding, Expression following) {
    return withDocumentsFrame(preceding, following);
  }

  /**
   * Specify a document-count frame with bounds of mixed or heterogeneous types, e.g. {@code (int,
   * Expression)} or {@code (String, String)}. Invalid combinations are encoded and rejected by the
   * backend.
   */
  public WindowSpec withDocuments(Object preceding, Object following) {
    return withDocumentsFrame(preceding, following);
  }

  /** Specify range-value based window frame. */
  public WindowSpec withRange(int preceding, int following) {
    return withRangeFrame(preceding, following, null);
  }

  public WindowSpec withRange(int preceding, int following, String unit) {
    return withRangeFrame(preceding, following, unit);
  }

  public WindowSpec withRange(int preceding, int following, Expression unit) {
    return withRangeFrame(preceding, following, unit);
  }

  /** Specify a range frame using symbolic bounds, e.g. {@code (UNBOUNDED, CURRENT)}. */
  public WindowSpec withRange(WindowBound preceding, WindowBound following) {
    return withRangeFrame(preceding, following, null);
  }

  public WindowSpec withRange(WindowBound preceding, WindowBound following, String unit) {
    return withRangeFrame(preceding, following, unit);
  }

  public WindowSpec withRange(WindowBound preceding, WindowBound following, Expression unit) {
    return withRangeFrame(preceding, following, unit);
  }

  /**
   * Specify a numeric range frame with fractional bounds.
   *
   * <p>Only meaningful for value-based (non-time) range frames, e.g. when sorting by a price or
   * score. The backend rejects fractional offsets for time-based range frames.
   */
  public WindowSpec withRange(double preceding, double following) {
    return withRangeFrame(preceding, following, null);
  }

  public WindowSpec withRange(double preceding, double following, String unit) {
    return withRangeFrame(preceding, following, unit);
  }

  public WindowSpec withRange(double preceding, double following, Expression unit) {
    return withRangeFrame(preceding, following, unit);
  }

  /**
   * Specify a range frame with bounds of mixed or heterogeneous types, e.g. {@code (int,
   * Expression)} or {@code (String, String)}. Invalid combinations are encoded and rejected by the
   * backend.
   */
  public WindowSpec withRange(Object preceding, Object following) {
    return withRangeFrame(preceding, following, null);
  }

  public WindowSpec withRange(Object preceding, Object following, String unit) {
    return withRangeFrame(preceding, following, unit);
  }

  public WindowSpec withRange(Object preceding, Object following, Expression unit) {
    return withRangeFrame(preceding, following, unit);
  }

  public WindowSpec withRange(Expression preceding, Expression following) {
    return withRangeFrame(preceding, following, null);
  }

  public WindowSpec withRange(Expression preceding, Expression following, String unit) {
    return withRangeFrame(preceding, following, unit);
  }

  public WindowSpec withRange(Expression preceding, Expression following, Expression unit) {
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

  public static WindowSpec partition(Expression expression, Object... additionalExpressions) {
    return new WindowSpec(
        resolveGroups(expression, additionalExpressions), Collections.emptyList(), null, null);
  }

  public static WindowSpec partition(String fieldName, Object... additionalExpressions) {
    return new WindowSpec(
        resolveGroups(fieldName, additionalExpressions), Collections.emptyList(), null, null);
  }

  public static WindowSpec partition(FieldPath fieldPath, Object... additionalExpressions) {
    return new WindowSpec(
        resolveGroups(fieldPath, additionalExpressions), Collections.emptyList(), null, null);
  }

  public static WindowSpec documents(int preceding, int following) {
    return new WindowSpec().withDocuments(preceding, following);
  }

  public static WindowSpec documents(WindowBound preceding, WindowBound following) {
    return new WindowSpec().withDocuments(preceding, following);
  }

  public static WindowSpec documents(Expression preceding, Expression following) {
    return new WindowSpec().withDocuments(preceding, following);
  }

  public static WindowSpec documents(Object preceding, Object following) {
    return new WindowSpec().withDocuments(preceding, following);
  }

  public static WindowSpec range(int preceding, int following) {
    return new WindowSpec().withRange(preceding, following);
  }

  public static WindowSpec range(int preceding, int following, String unit) {
    return new WindowSpec().withRange(preceding, following, unit);
  }

  public static WindowSpec range(int preceding, int following, Expression unit) {
    return new WindowSpec().withRange(preceding, following, unit);
  }

  public static WindowSpec range(WindowBound preceding, WindowBound following) {
    return new WindowSpec().withRange(preceding, following);
  }

  public static WindowSpec range(WindowBound preceding, WindowBound following, String unit) {
    return new WindowSpec().withRange(preceding, following, unit);
  }

  public static WindowSpec range(WindowBound preceding, WindowBound following, Expression unit) {
    return new WindowSpec().withRange(preceding, following, unit);
  }

  public static WindowSpec range(double preceding, double following) {
    return new WindowSpec().withRange(preceding, following);
  }

  public static WindowSpec range(double preceding, double following, String unit) {
    return new WindowSpec().withRange(preceding, following, unit);
  }

  public static WindowSpec range(double preceding, double following, Expression unit) {
    return new WindowSpec().withRange(preceding, following, unit);
  }

  public static WindowSpec range(Object preceding, Object following) {
    return new WindowSpec().withRange(preceding, following);
  }

  public static WindowSpec range(Object preceding, Object following, String unit) {
    return new WindowSpec().withRange(preceding, following, unit);
  }

  public static WindowSpec range(Object preceding, Object following, Expression unit) {
    return new WindowSpec().withRange(preceding, following, unit);
  }

  public static WindowSpec range(Expression preceding, Expression following) {
    return new WindowSpec().withRange(preceding, following);
  }

  public static WindowSpec range(Expression preceding, Expression following, String unit) {
    return new WindowSpec().withRange(preceding, following, unit);
  }

  public static WindowSpec range(Expression preceding, Expression following, Expression unit) {
    return new WindowSpec().withRange(preceding, following, unit);
  }

  public static WindowSpec sort(Ordering order, Ordering... additionalOrders) {
    return new WindowSpec().withSort(order, additionalOrders);
  }

  public static WindowSpec sort(List<Ordering> orders) {
    return new WindowSpec().withSort(orders);
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
   * <p>Symbolic bounds are expressed with {@link WindowBound} and encode as the strings {@code
   * "current"} / {@code "unbounded"}. Other values are converted via {@link
   * Expression#toExprOrConstant} — in particular {@code 0} is a genuine zero offset and is
   * <i>not</i> the same boundary as {@link WindowBound#CURRENT}.
   */
  private static Expression toBoundaryExpr(Object boundary) {
    if (boundary instanceof WindowBound) {
      return Expression.constant(((WindowBound) boundary).wireName());
    } else {
      return Expression.toExprOrConstant(boundary);
    }
  }
}
