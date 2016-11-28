/*
 * Copyright 2015 Google Inc. All Rights Reserved.
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

package com.google.cloud.bigquery;

import static com.google.common.base.Preconditions.checkNotNull;

import com.google.api.services.bigquery.Bigquery.Jobs.Query;
import com.google.cloud.bigquery.Field.Builder;
import com.google.cloud.bigquery.Field.Mode;
import com.google.cloud.bigquery.Field.Type;
import com.google.common.base.Function;
import com.google.common.base.MoreObjects;
import com.google.common.collect.ImmutableList;
import com.google.common.collect.Lists;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Objects;

/**
 * A query parameter for a Google BigQuery query.
 *
 * <p>Each query parameter has a name and a typed value. The name is used for queries with named
 * parameters, and should be null for queries with positional parameters. All scalar types are
 * converted into strings before being passed to the server, but the nature of the conversion
 * depends on the particular type.
 *
 * <p>See {@link QueryParameterValue} for more details on the supported types and how to provide
 * them.
 */
public class QueryParameter implements Serializable {
  static final Function<com.google.api.services.bigquery.model.QueryParameter, QueryParameter>
      FROM_PB_FUNCTION =
          new Function<com.google.api.services.bigquery.model.QueryParameter, QueryParameter>() {
            @Override
            public QueryParameter apply(com.google.api.services.bigquery.model.QueryParameter pb) {
              return QueryParameter.fromPb(pb);
            }
          };
  static final Function<QueryParameter, com.google.api.services.bigquery.model.QueryParameter>
      TO_PB_FUNCTION =
          new Function<QueryParameter, com.google.api.services.bigquery.model.QueryParameter>() {
            @Override
            public com.google.api.services.bigquery.model.QueryParameter apply(
                QueryParameter queryParameter) {
              return queryParameter.toPb();
            }
          };

  private static final long serialVersionUID = -3106977352686037480L;

  private final String name;
  private final QueryParameterValue parameterValue;

  private QueryParameter(String name, QueryParameterValue parameterValue) {
    this.name = name;
    this.parameterValue = checkNotNull(parameterValue);
  }

  /** Returns the query parameter name. */
  public String getName() {
    return name;
  }

  /** Returns the typed query parameter value. */
  public QueryParameterValue getParameterValue() {
    return parameterValue;
  }

  /**
   * Creates a positional {@code QueryParameter} object with the given value.
   */
  public static QueryParameter of(QueryParameterValue value) {
    return new QueryParameter(null, value);
  }

  /**
   * Creates a named {@code QueryParameter} object with the given value.
   */
  public static QueryParameter named(String name, QueryParameterValue value) {
    return new QueryParameter(name, value);
  }

  @Override
  public String toString() {
    return MoreObjects.toStringHelper(this)
        .add("name", name)
        .add("parameterValue", parameterValue)
        .toString();
  }

  @Override
  public int hashCode() {
    return Objects.hash(name, parameterValue);
  }

  @Override
  public boolean equals(Object obj) {
    return obj instanceof QueryParameter && Objects.equals(toPb(), ((QueryParameter) obj).toPb());
  }

  com.google.api.services.bigquery.model.QueryParameter toPb() {
    com.google.api.services.bigquery.model.QueryParameter queryParameterPb =
        new com.google.api.services.bigquery.model.QueryParameter();
    queryParameterPb.setName(name);
    if (parameterValue != null) {
      queryParameterPb.setParameterValue(parameterValue.toValuePb());
      queryParameterPb.setParameterType(parameterValue.toTypePb());
    }
    return queryParameterPb;
  }

  static QueryParameter fromPb(
      com.google.api.services.bigquery.model.QueryParameter queryParameterPb) {
    checkNotNull(queryParameterPb.getParameterType());
    checkNotNull(queryParameterPb.getParameterValue());
    QueryParameterValue value =
          QueryParameterValue.fromPb(
              queryParameterPb.getParameterValue(), queryParameterPb.getParameterType());
    return named(queryParameterPb.getName(), value);
  }
}
