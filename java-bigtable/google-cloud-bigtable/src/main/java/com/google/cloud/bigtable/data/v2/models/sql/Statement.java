/*
 * Copyright 2024 Google LLC
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
package com.google.cloud.bigtable.data.v2.models.sql;

import com.google.api.core.BetaApi;
import com.google.api.core.InternalApi;
import com.google.bigtable.v2.ExecuteQueryRequest;
import com.google.bigtable.v2.Type;
import com.google.bigtable.v2.Value;
import com.google.cloud.Date;
import com.google.cloud.bigtable.data.v2.internal.NameUtil;
import com.google.cloud.bigtable.data.v2.internal.RequestContext;
import com.google.common.collect.ImmutableMap;
import com.google.protobuf.ByteString;
import com.google.protobuf.Timestamp;
import java.util.HashMap;
import java.util.Map;
import javax.annotation.Nullable;
import org.threeten.bp.Instant;

/**
 * A SQL statement that can be executed by calling {@link
 * com.google.cloud.bigtable.data.v2.BigtableDataClient#executeQuery(Statement)}.
 *
 * <p>A statement contains a SQL string and optional parameters. A parameterized query should
 * contain placeholders in the form of {@literal @} followed by the parameter name. Parameter names
 * may consist of any combination of letters, numbers, and underscores.
 *
 * <p>Parameters can appear anywhere that a literal value is expected. The same parameter name can
 * be used more than once, for example: {@code WHERE cf["qualifier1"] = @value OR cf["qualifier2"]
 * = @value }
 *
 * <p>It is an error to execute an SQL query with placeholders for unset parameters.
 *
 * <p>Parameterized Statements are constructed using a {@link Builder} and calling
 * setTypeParam(String paramName, Type value) for the appropriate type. For example:
 *
 * <pre>{@code
 * Statement statement = Statement
 *     .newBuilder("SELECT cf[@qualifer] FROM table WHERE _key=@key")
 *     .setBytesParam("qualifier", ByteString.copyFromUtf8("test"))
 *     .setBytesParam("key", ByteString.copyFromUtf8("testKey"))
 *     .build();
 * }</pre>
 */
@BetaApi
public class Statement {

  private static final Type STRING_TYPE =
      Type.newBuilder().setStringType(Type.String.getDefaultInstance()).build();
  private static final Type BYTES_TYPE =
      Type.newBuilder().setBytesType(Type.Bytes.getDefaultInstance()).build();
  private static final Type INT64_TYPE =
      Type.newBuilder().setInt64Type(Type.Int64.getDefaultInstance()).build();
  private static final Type BOOL_TYPE =
      Type.newBuilder().setBoolType(Type.Bool.getDefaultInstance()).build();
  private static final Type TIMESTAMP_TYPE =
      Type.newBuilder().setTimestampType(Type.Timestamp.getDefaultInstance()).build();
  private static final Type DATE_TYPE =
      Type.newBuilder().setDateType(Type.Date.getDefaultInstance()).build();

  private final String sql;
  private final Map<String, Value> params;

  private Statement(String sql, Map<String, Value> params) {
    this.sql = sql;
    this.params = params;
  }

  /** Creates a {@code Statement} with the given SQL query and no query parameters. */
  public static Statement of(String sql) {
    return newBuilder(sql).build();
  }

  /** Creates a new {@code Builder} with the given SQL query */
  public static Builder newBuilder(String sql) {
    return new Builder(sql);
  }

  public static class Builder {
    private final String sql;
    private final Map<String, Value> params;

    private Builder(String sql) {
      this.sql = sql;
      this.params = new HashMap<>();
    }

    /** Builds a {@code Statement} from the builder */
    public Statement build() {
      return new Statement(sql, ImmutableMap.copyOf(params));
    }

    /**
     * Sets a query parameter with the name {@code paramName} and the String typed value {@code
     * value}
     */
    public Builder setStringParam(String paramName, @Nullable String value) {
      params.put(paramName, stringParamOf(value));
      return this;
    }

    /**
     * Sets a query parameter with the name {@code paramName} and the Bytes typed value {@code
     * value}
     */
    public Builder setBytesParam(String paramName, @Nullable ByteString value) {
      params.put(paramName, bytesParamOf(value));
      return this;
    }

    /**
     * Sets a query parameter with the name {@code paramName} and the INT64 typed value {@code
     * value}
     */
    public Builder setLongParam(String paramName, @Nullable Long value) {
      params.put(paramName, int64ParamOf(value));
      return this;
    }

    /**
     * Sets a query parameter with the name {@code paramName} and the BOOL typed value {@code value}
     */
    public Builder setBooleanParam(String paramName, @Nullable Boolean value) {
      params.put(paramName, booleanParamOf(value));
      return this;
    }

    /**
     * Sets a query parameter with the name {@code paramName} and the TIMESTAMP typed value {@code
     * value}
     */
    public Builder setTimestampParam(String paramName, @Nullable Instant value) {
      params.put(paramName, timestampParamOf(value));
      return this;
    }

    /**
     * Sets a query parameter with the name {@code paramName} and the DATE typed value {@code value}
     */
    public Builder setDateParam(String paramName, @Nullable Date value) {
      params.put(paramName, dateParamOf(value));
      return this;
    }

    private static Value stringParamOf(@Nullable String value) {
      Value.Builder builder = nullValueWithType(STRING_TYPE);
      if (value != null) {
        builder.setStringValue(value);
      }
      return builder.build();
    }

    private static Value bytesParamOf(@Nullable ByteString value) {
      Value.Builder builder = nullValueWithType(BYTES_TYPE);
      if (value != null) {
        builder.setBytesValue(value);
      }
      return builder.build();
    }

    private static Value int64ParamOf(@Nullable Long value) {
      Value.Builder builder = nullValueWithType(INT64_TYPE);
      if (value != null) {
        builder.setIntValue(value);
      }
      return builder.build();
    }

    private static Value booleanParamOf(@Nullable Boolean value) {
      Value.Builder builder = nullValueWithType(BOOL_TYPE);
      if (value != null) {
        builder.setBoolValue(value);
      }
      return builder.build();
    }

    private static Value timestampParamOf(@Nullable Instant value) {
      Value.Builder builder = nullValueWithType(TIMESTAMP_TYPE);
      if (value != null) {
        builder.setTimestampValue(
            Timestamp.newBuilder()
                .setSeconds(value.getEpochSecond())
                .setNanos(value.getNano())
                .build());
      }
      return builder.build();
    }

    private static Value dateParamOf(@Nullable Date value) {
      Value.Builder builder = nullValueWithType(DATE_TYPE);
      if (value != null) {
        builder.setDateValue(
            com.google.type.Date.newBuilder()
                .setYear(value.getYear())
                .setMonth(value.getMonth())
                .setDay(value.getDayOfMonth())
                .build());
      }
      return builder.build();
    }

    private static Value.Builder nullValueWithType(Type type) {
      return Value.newBuilder().setType(type);
    }
  }

  /**
   * Creates the request protobuf. This method is considered an internal implementation detail and
   * not meant to be used by applications.
   */
  @InternalApi("For internal use only")
  public ExecuteQueryRequest toProto(RequestContext requestContext) {
    return ExecuteQueryRequest.newBuilder()
        .setInstanceName(
            NameUtil.formatInstanceName(
                requestContext.getProjectId(), requestContext.getInstanceId()))
        .setAppProfileId(requestContext.getAppProfileId())
        .setQuery(sql)
        .putAllParams(params)
        .build();
  }
}
