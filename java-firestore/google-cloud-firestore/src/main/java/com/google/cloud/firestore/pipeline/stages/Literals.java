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

package com.google.cloud.firestore.pipeline.stages;

import com.google.api.core.InternalApi;
import com.google.cloud.firestore.PipelineUtils;
import com.google.cloud.firestore.pipeline.expressions.Expression;
import com.google.common.base.Preconditions;
import com.google.firestore.v1.Value;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

@InternalApi
public final class Literals extends Stage {

  private final List<Map<String, Object>> data;

  public Literals(Map<String, Object>... data) {
    super("literals", InternalOptions.EMPTY);
    Preconditions.checkNotNull(data, "Documents must not be null.");
    for (int i = 0; i < data.length; i++) {
      Preconditions.checkNotNull(data[i], "Document %s must not be null.", i);
    }
    this.data = Arrays.asList(data);
  }

  @Override
  Iterable<Value> toStageArgs() {
    List<Value> args = new ArrayList<>();
    for (Map<String, Object> map : data) {
      args.add(encodeLiteralMap(map));
    }
    return args;
  }

  private Value encodeLiteralMap(Map<?, ?> map) {
    com.google.firestore.v1.MapValue.Builder mapValue =
        com.google.firestore.v1.MapValue.newBuilder();
    for (Map.Entry<?, ?> entry : map.entrySet()) {
      String key = String.valueOf(entry.getKey());
      Object v = entry.getValue();
      if (v instanceof Expression) {
        mapValue.putFields(key, PipelineUtils.encodeValue((Expression) v));
      } else if (containsExpression(v)) {
        // The backend evaluates expressions only in the top-level fields of a literal document,
        // so a map or list that contains a nested expression is sent as a map(...) or array(...)
        // expression instead of a raw map or array value.
        mapValue.putFields(key, PipelineUtils.encodeValue(toExpression(v)));
      } else if (v instanceof Map) {
        mapValue.putFields(key, encodeLiteralMap((Map<?, ?>) v));
      } else {
        mapValue.putFields(key, PipelineUtils.encodeValue(v));
      }
    }
    return Value.newBuilder().setMapValue(mapValue.build()).build();
  }

  /** Returns whether {@code value} is a map or list that contains an expression at any depth. */
  private static boolean containsExpression(Object value) {
    if (value instanceof Map) {
      for (Object child : ((Map<?, ?>) value).values()) {
        if (child instanceof Expression || containsExpression(child)) {
          return true;
        }
      }
    } else if (value instanceof List) {
      for (Object child : (List<?>) value) {
        if (child instanceof Expression || containsExpression(child)) {
          return true;
        }
      }
    }
    return false;
  }

  /**
   * Converts a map or list that contains nested expressions into an equivalent {@code map(...)} or
   * {@code array(...)} expression. Children without expressions are kept as constants.
   */
  private static Expression toExpression(Object value) {
    if (value instanceof Expression) {
      return (Expression) value;
    } else if (value instanceof Map) {
      Map<String, Object> elements = new LinkedHashMap<>();
      for (Map.Entry<?, ?> entry : ((Map<?, ?>) value).entrySet()) {
        elements.put(String.valueOf(entry.getKey()), toExpressionIfNeeded(entry.getValue()));
      }
      return Expression.map(elements);
    } else {
      List<Object> elements = new ArrayList<>();
      for (Object child : (List<?>) value) {
        elements.add(toExpressionIfNeeded(child));
      }
      return Expression.array(elements);
    }
  }

  private static Object toExpressionIfNeeded(Object value) {
    return value instanceof Expression || containsExpression(value) ? toExpression(value) : value;
  }
}
