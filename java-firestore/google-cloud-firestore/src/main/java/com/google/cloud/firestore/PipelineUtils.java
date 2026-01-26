/*
 * Copyright 2024 Google LLC
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

package com.google.cloud.firestore;

import static com.google.cloud.firestore.pipeline.expressions.AggregateFunction.countAll;
import static com.google.cloud.firestore.pipeline.expressions.Expression.and;
import static com.google.cloud.firestore.pipeline.expressions.Expression.arrayContainsAny;
import static com.google.cloud.firestore.pipeline.expressions.Expression.field;
import static com.google.cloud.firestore.pipeline.expressions.Expression.not;
import static com.google.cloud.firestore.pipeline.expressions.Expression.nullValue;
import static com.google.cloud.firestore.pipeline.expressions.Expression.or;
import static com.google.cloud.firestore.pipeline.expressions.FunctionUtils.aggregateFunctionToValue;
import static com.google.cloud.firestore.pipeline.expressions.FunctionUtils.exprToValue;

import com.google.api.core.InternalApi;
import com.google.cloud.firestore.Query.ComparisonFilterInternal;
import com.google.cloud.firestore.Query.CompositeFilterInternal;
import com.google.cloud.firestore.Query.FilterInternal;
import com.google.cloud.firestore.Query.UnaryFilterInternal;
import com.google.cloud.firestore.pipeline.expressions.AggregateFunction;
import com.google.cloud.firestore.pipeline.expressions.AliasedAggregate;
import com.google.cloud.firestore.pipeline.expressions.AliasedExpression;
import com.google.cloud.firestore.pipeline.expressions.BooleanExpression;
import com.google.cloud.firestore.pipeline.expressions.Expression;
import com.google.cloud.firestore.pipeline.expressions.Field;
import com.google.cloud.firestore.pipeline.expressions.Selectable;
import com.google.common.collect.Lists;
import com.google.firestore.v1.MapValue;
import com.google.firestore.v1.Value;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@InternalApi
public class PipelineUtils {
  @InternalApi
  public static Value encodeValue(Object value) {
    return UserDataConverter.encodeValue(FieldPath.empty(), value, UserDataConverter.ARGUMENT);
  }

  @InternalApi
  public static Value encodeValue(Expression value) {
    return exprToValue(value);
  }

  @InternalApi
  public static Value encodeValue(AggregateFunction value) {
    return aggregateFunctionToValue(value);
  }

  @InternalApi
  public static Value encodeValue(String value) {
    return Value.newBuilder().setStringValue(value).build();
  }

  @InternalApi
  public static Value encodeValue(boolean value) {
    return Value.newBuilder().setBooleanValue(value).build();
  }

  @InternalApi
  public static Value encodeValue(long value) {
    return Value.newBuilder().setIntegerValue(value).build();
  }

  @InternalApi
  public static Value encodeValue(double value) {
    return Value.newBuilder().setDoubleValue(value).build();
  }

  @InternalApi
  public static Value encodeValue(Map<String, Value> options) {
    return Value.newBuilder()
        .setMapValue(MapValue.newBuilder().putAllFields(options).build())
        .build();
  }

  @InternalApi
  static BooleanExpression toPipelineBooleanExpr(FilterInternal f) {
    if (f instanceof ComparisonFilterInternal) {
      ComparisonFilterInternal comparisonFilter = (ComparisonFilterInternal) f;
      Field field = Field.ofServerPath(comparisonFilter.fieldReference.getFieldPath());
      Value value = comparisonFilter.value;
      switch (comparisonFilter.operator) {
        case LESS_THAN:
          return and(field.exists(), field.lessThan(value));
        case LESS_THAN_OR_EQUAL:
          return and(field.exists(), field.lessThanOrEqual(value));
        case GREATER_THAN:
          return and(field.exists(), field.greaterThan(value));
        case GREATER_THAN_OR_EQUAL:
          return and(field.exists(), field.greaterThanOrEqual(value));
        case EQUAL:
          return and(field.exists(), field.equal(value));
        case NOT_EQUAL:
          return field.notEqual(value);
        case ARRAY_CONTAINS:
          return and(field.exists(), field.arrayContains(value));
        case IN:
          List<Value> valuesList = value.getArrayValue().getValuesList();
          return and(field.exists(), Expression.equalAny(field, Lists.newArrayList(valuesList)));
        case ARRAY_CONTAINS_ANY:
          List<Value> valuesListAny = value.getArrayValue().getValuesList();
          return and(field.exists(), arrayContainsAny(field, Lists.newArrayList(valuesListAny)));
        case NOT_IN:
          List<Value> notInValues = value.getArrayValue().getValuesList();
          return not(Expression.equalAny(field, Lists.newArrayList(notInValues)));
        default:
          // Handle OPERATOR_UNSPECIFIED and UNRECOGNIZED cases as needed
          throw new IllegalArgumentException("Unsupported operator: " + comparisonFilter.operator);
      }
    } else if (f instanceof CompositeFilterInternal) {
      CompositeFilterInternal compositeFilter = (CompositeFilterInternal) f;
      switch (compositeFilter.getOperator()) {
        case AND:
          List<BooleanExpression> conditions =
              compositeFilter.getFilters().stream()
                  .map(PipelineUtils::toPipelineBooleanExpr)
                  .collect(Collectors.toList());
          return and(
              conditions.get(0),
              conditions.subList(1, conditions.size()).toArray(new BooleanExpression[0]));
        case OR:
          List<BooleanExpression> orConditions =
              compositeFilter.getFilters().stream()
                  .map(PipelineUtils::toPipelineBooleanExpr)
                  .collect(Collectors.toList());
          return or(
              orConditions.get(0),
              orConditions.subList(1, orConditions.size()).toArray(new BooleanExpression[0]));
        default:
          // Handle OPERATOR_UNSPECIFIED and UNRECOGNIZED cases as needed
          throw new IllegalArgumentException(
              "Unsupported operator: " + compositeFilter.getOperator());
      }
    } else if (f instanceof UnaryFilterInternal) {
      UnaryFilterInternal unaryFilter = (UnaryFilterInternal) f;
      Field field = Field.ofServerPath(unaryFilter.fieldReference.getFieldPath());
      switch (unaryFilter.getOperator()) {
        case IS_NAN:
          return and(field.exists(), field.equal(Double.NaN));
        case IS_NULL:
          return and(field.exists(), field.equal(nullValue()));
        case IS_NOT_NAN:
          return and(field.exists(), field.notEqual(Double.NaN));
        case IS_NOT_NULL:
          return and(field.exists(), field.notEqual(nullValue()));
        default:
          // Handle OPERATOR_UNSPECIFIED and UNRECOGNIZED cases as needed
          throw new IllegalArgumentException("Unsupported operator: " + unaryFilter.getOperator());
      }
    } else {
      // Handle other FilterInternal types as needed
      throw new IllegalArgumentException("Unsupported filter type: " + f.getClass().getName());
    }
  }

  @InternalApi
  static AliasedAggregate toPipelineAggregatorTarget(AggregateField f) {
    String operator = f.getOperator();
    String fieldPath = f.getFieldPath();

    switch (operator) {
      case "sum":
        return Field.ofServerPath(fieldPath).sum().as(f.getAlias());

      case "count":
        return countAll().as(f.getAlias());
      case "average":
        return Field.ofServerPath(fieldPath).average().as(f.getAlias());
      default:
        // Handle the 'else' case appropriately in your Java code
        throw new IllegalArgumentException("Unsupported operator: " + operator);
    }
  }

  @InternalApi
  static BooleanExpression toPipelineExistsExpr(AggregateField f) {
    String fieldPath = f.getFieldPath();

    if (fieldPath.isEmpty()) {
      return null;
    }
    return Field.ofServerPath(fieldPath).exists();
  }

  @InternalApi
  public static Map<String, Expression> selectablesToMap(Selectable... selectables) {
    Map<String, Expression> projMap = new HashMap<>();
    for (Selectable proj : selectables) {
      if (proj instanceof Field) {
        Field fieldProj = (Field) proj;
        if (projMap.containsKey(fieldProj.getPath().getEncodedPath())) {
          throw new IllegalArgumentException(
              "Duplicate alias or field name: " + fieldProj.getPath().getEncodedPath());
        }
        projMap.put(fieldProj.getPath().getEncodedPath(), fieldProj);
      } else if (proj instanceof AliasedExpression) {
        AliasedExpression aliasedExpr = (AliasedExpression) proj;
        if (projMap.containsKey(aliasedExpr.getAlias())) {
          throw new IllegalArgumentException(
              "Duplicate alias or field name: " + aliasedExpr.getAlias());
        }
        projMap.put(aliasedExpr.getAlias(), aliasedExpr.getExpr());
      }
    }
    return projMap;
  }

  @InternalApi
  public static Map<String, Expression> fieldNamesToMap(String... fields) {
    Map<String, Expression> projMap = new HashMap<>();
    for (String field : fields) {
      projMap.put(field, field(field));
    }
    return projMap;
  }
}
