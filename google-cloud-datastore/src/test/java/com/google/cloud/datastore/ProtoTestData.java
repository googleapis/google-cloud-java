/*
 * Copyright 2022 Google LLC
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
package com.google.cloud.datastore;

import static com.google.datastore.v1.PropertyOrder.Direction.ASCENDING;

import com.google.datastore.v1.AggregationQuery.Aggregation;
import com.google.datastore.v1.AggregationQuery.Aggregation.Count;
import com.google.datastore.v1.Filter;
import com.google.datastore.v1.GqlQueryParameter;
import com.google.datastore.v1.KindExpression;
import com.google.datastore.v1.Projection;
import com.google.datastore.v1.PropertyFilter.Operator;
import com.google.datastore.v1.PropertyOrder;
import com.google.datastore.v1.PropertyReference;
import com.google.datastore.v1.Value;

public class ProtoTestData {

  public static Value booleanValue(boolean value) {
    return Value.newBuilder().setBooleanValue(value).build();
  }

  public static Value stringValue(String value) {
    return Value.newBuilder().setStringValue(value).build();
  }

  public static Value intValue(long value) {
    return Value.newBuilder().setIntegerValue(value).build();
  }

  public static GqlQueryParameter gqlQueryParameter(Value value) {
    return GqlQueryParameter.newBuilder().setValue(value).build();
  }

  public static KindExpression kind(String kind) {
    return KindExpression.newBuilder().setName(kind).build();
  }

  public static Filter propertyFilter(String propertyName, Operator operator, Value value) {
    return Filter.newBuilder()
        .setPropertyFilter(
            com.google.datastore.v1.PropertyFilter.newBuilder()
                .setProperty(propertyReference(propertyName))
                .setOp(operator)
                .setValue(value)
                .build())
        .build();
  }

  public static PropertyReference propertyReference(String value) {
    return PropertyReference.newBuilder().setName(value).build();
  }

  public static Aggregation countAggregation(String alias) {
    return Aggregation.newBuilder().setAlias(alias).setCount(Count.newBuilder().build()).build();
  }

  public static PropertyOrder propertyOrder(String value) {
    return PropertyOrder.newBuilder()
        .setProperty(propertyReference(value))
        .setDirection(ASCENDING)
        .build();
  }

  public static Projection projection(String value) {
    return Projection.newBuilder().setProperty(propertyReference(value)).build();
  }
}
