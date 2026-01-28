/*
 * Copyright 2023 Google LLC
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 * https://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package com.google.cloud.bigquery.jdbc;

import static com.google.cloud.bigquery.StandardSQLTypeName.STRUCT;
import static com.google.cloud.bigquery.jdbc.BigQueryErrorMessage.CUSTOMER_TYPE_MAPPING_NOT_SUPPORTED;

import com.google.cloud.bigquery.Field;
import com.google.cloud.bigquery.FieldList;
import com.google.cloud.bigquery.exception.BigQueryJdbcSqlFeatureNotSupportedException;
import java.sql.Date;
import java.sql.SQLException;
import java.sql.Time;
import java.sql.Timestamp;
import java.util.Base64;
import java.util.Map;

/**
 * An abstract implementation of {@link java.sql.Struct} used as a base class for {@link
 * BigQueryArrowStruct} and {@link BigQueryJsonStruct}. A Struct object contains a value for each
 * attribute of the SQL structured type that it represents.
 */
abstract class BigQueryBaseStruct implements java.sql.Struct {
  private static final BigQueryJdbcCustomLogger LOG =
      new BigQueryJdbcCustomLogger(BigQueryBaseStruct.class.getName());

  abstract FieldList getSchema();

  @Override
  public final String getSQLTypeName() throws SQLException {
    throw new BigQueryJdbcSqlFeatureNotSupportedException(CUSTOMER_TYPE_MAPPING_NOT_SUPPORTED);
  }

  @Override
  public final Object[] getAttributes(Map<String, Class<?>> map) throws SQLException {
    throw new BigQueryJdbcSqlFeatureNotSupportedException(CUSTOMER_TYPE_MAPPING_NOT_SUPPORTED);
  }

  static boolean isStruct(Field currentSchema) {
    LOG.finest("++enter++");
    return currentSchema.getType().getStandardType() == STRUCT;
  }

  @Override
  public String toString() {
    try {
      FieldList schema = getSchema();
      Object[] attributes = getAttributes();

      if (schema == null || attributes == null || schema.size() != attributes.length) {
        return "{}";
      }

      StringBuilder sb = new StringBuilder("{");
      for (int i = 0; i < attributes.length; i++) {
        if (i > 0) {
          sb.append(",");
        }
        String fieldName = schema.get(i).getName();
        Object value = attributes[i];

        sb.append("\"").append(fieldName.replace("\"", "\\\"")).append("\":");

        if (value == null) {
          sb.append("null");
        } else if (value instanceof String || value instanceof org.apache.arrow.vector.util.Text) {
          String stringValue = value.toString().replace("\"", "\\\"");
          sb.append("\"").append(stringValue).append("\"");
        } else if (value instanceof Timestamp || value instanceof Date || value instanceof Time) {
          sb.append("\"").append(value.toString()).append("\"");
        } else if (value instanceof byte[]) {
          sb.append("\"").append(Base64.getEncoder().encodeToString((byte[]) value)).append("\"");
        } else {
          sb.append(value.toString());
        }
      }
      sb.append("}");
      return sb.toString();
    } catch (SQLException e) {
      return "{ \"error\": \"Error converting struct to string: " + e.getMessage() + "\" }";
    }
  }
}
