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

import com.google.api.core.InternalApi;
import com.google.common.collect.ImmutableList;
import com.google.firestore.v1.Function;
import com.google.firestore.v1.Value;
import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import javax.annotation.Nullable;

/** A class that represents a window function. */
public final class WindowFunction {
  final String name;
  final ImmutableList<Expression> params;
  final Map<String, Value> options;
  @Nullable final WindowSpec window;

  WindowFunction(
      String name,
      List<Expression> params,
      Map<String, Value> options,
      @Nullable WindowSpec window) {
    this.name = name;
    this.params = ImmutableList.copyOf(params);
    this.options = Collections.unmodifiableMap(options);
    this.window = window;
  }

  private WindowFunction(String name) {
    this(name, Collections.emptyList(), Collections.emptyMap(), null);
  }

  /**
   * Creates a window function that assigns a unique rank to each row based on the sort order.
   *
   * @return A new {@link WindowFunction} representing the rank window function.
   */
  @InternalApi
  public static WindowFunction rank() {
    return new WindowFunction("rank");
  }

  /**
   * Creates a window function that assigns a dense rank to each row based on the sort order.
   *
   * @return A new {@link WindowFunction} representing the dense_rank window function.
   */
  @InternalApi
  public static WindowFunction denseRank() {
    return new WindowFunction("dense_rank");
  }

  /**
   * Creates a window function that assigns the row number to each row based on the sort order.
   *
   * @return A new {@link WindowFunction} representing the row_number window function.
   */
  @InternalApi
  public static WindowFunction rowNumber() {
    return new WindowFunction("row_number");
  }

  /**
   * Lifts an {@link AggregateFunction} into a window function, preserving its name, arguments and
   * options.
   */
  static WindowFunction fromAggregate(AggregateFunction aggregate, @Nullable WindowSpec window) {
    return new WindowFunction(aggregate.name, aggregate.params, Collections.emptyMap(), window);
  }

  /**
   * Assigns an alias to this window function.
   *
   * @param alias The alias to assign to this window function.
   * @return A new {@link AliasedWindowFunction} that wraps this window function and associates it
   *     with the provided alias.
   */
  public AliasedWindowFunction as(String alias) {
    return new AliasedWindowFunction(alias, this);
  }

  /**
   * Evaluates this function over an explicit window frame.
   *
   * <p>The returned function carries its own framing, overriding the window declared on the
   * enclosing {@code addWindowFields} stage.
   *
   * @param window The window specification to evaluate this function over.
   * @return A new {@link WindowFunction} with the given framing.
   */
  @InternalApi
  public WindowFunction over(WindowSpec window) {
    return new WindowFunction(name, params, options, window);
  }

  @InternalApi
  public Value toProto() {
    Function.Builder builder = Function.newBuilder();
    builder.setName(name);
    for (Expression param : params) {
      builder.addArgs(FunctionUtils.exprToValue(param));
    }
    builder.putAllOptions(options);
    Value functionValue = Value.newBuilder().setFunctionValue(builder).build();

    // An accumulator-level frame is encoded as an enclosing `over(fn, windowSpec)` call. Without
    // one, the function is emitted bare and inherits the stage's window.
    WindowSpec frame = window;
    if (frame == null) {
      return functionValue;
    }

    Function.Builder over =
        Function.newBuilder().setName("over").addArgs(functionValue).addArgs(frame.buildInternal());
    return Value.newBuilder().setFunctionValue(over).build();
  }

  @Override
  public boolean equals(Object other) {
    return this == other
        || (other instanceof WindowFunction
            && Objects.equals(toProto(), ((WindowFunction) other).toProto()));
  }

  @Override
  public int hashCode() {
    return toProto().hashCode();
  }
}
