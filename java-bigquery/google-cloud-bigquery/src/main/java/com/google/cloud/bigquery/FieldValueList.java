/*
 * Copyright 2017 Google LLC
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

import com.google.api.core.BetaApi;
import com.google.common.collect.ImmutableList;
import java.io.Serializable;
import java.util.AbstractList;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/**
 * Google BigQuery Table Field Values class, which represents a row in returned query result (table
 * row). Tables rows can be retrieved as a result of a query or when listing table data.
 *
 * <p>Depending on how a corresponding query was executed, each row (an instance of {@code
 * FieldValueList}) may or may not contain related schema. If schema is not provided, the individual
 * cells of the row will still be accessible by index but not by name.
 */
public class FieldValueList extends AbstractList<FieldValue> implements Serializable {

  private static final long serialVersionUID = 2103346761764976902L;

  private final FieldList schema;
  private final List<FieldValue> row;

  private FieldValueList(List<FieldValue> row, FieldList schema) {
    if (schema != null && row.size() != schema.size()) {
      throw new IllegalArgumentException("Row size and fields schema sizes should match");
    }
    this.row = ImmutableList.copyOf(row);
    this.schema = schema;
  }

  /**
   * Gets field value by index.
   *
   * @param index field value index
   */
  @Override
  public FieldValue get(int index) {
    return row.get(index);
  }

  /**
   * Gets field value by index.
   *
   * @param name field name (defined in schema)
   * @throws IllegalArgumentException if schema is not provided or if {@code name} was not found in
   *     the schema
   */
  public FieldValue get(String name) {
    if (schema == null) {
      throw new UnsupportedOperationException(
          "Retrieving field value by name is not supported when there is no fields schema provided");
    }
    return get(schema.getIndex(name));
  }

  /** Returns {@code true} if schema is provided, {@code false} otherwise. */
  public boolean hasSchema() {
    return schema != null;
  }

  /** Returns the total number of field values in the row. */
  @Override
  public int size() {
    return row.size();
  }

  /**
   * Creates an instance of {@code FieldValueList}, useful for testing.
   *
   * <p>This method is unstable. See <a
   * href="https://github.com/googleapis/google-cloud-java/pull/2891">this discussion</a> for more
   * context.
   */
  @BetaApi
  public static FieldValueList of(List<FieldValue> row, FieldList schema) {
    return new FieldValueList(row, schema);
  }

  /**
   * Creates an instance of {@code FieldValueList}, useful for testing.
   *
   * <p>This method is unstable. See <a
   * href="https://github.com/googleapis/google-cloud-java/pull/2891">this discussion</a> for more
   * context.
   */
  @BetaApi
  public static FieldValueList of(List<FieldValue> row, Field... schema) {
    return of(row, schema.length > 0 ? FieldList.of(schema) : null);
  }

  FieldValueList withSchema(FieldList schema) {
    return new FieldValueList(this.row, schema);
  }

  static FieldValueList fromPb(List<?> rowPb, FieldList schema) {
    return fromPb(rowPb, schema, false);
  }

  static FieldValueList fromPb(List<?> rowPb, FieldList schema, Boolean useInt64Timestamps) {
    List<FieldValue> row = new ArrayList<>(rowPb.size());
    if (schema != null) {
      if (schema.size() != rowPb.size()) {
        throw new IllegalArgumentException("Row size and fields schema sizes should match");
      }
      Iterator<Field> schemaIter = schema.iterator();
      Iterator<?> rowPbIter = rowPb.iterator();
      while (rowPbIter.hasNext() && schemaIter.hasNext()) {
        row.add(FieldValue.fromPb(rowPbIter.next(), schemaIter.next(), useInt64Timestamps));
      }
    } else {
      for (Object cellPb : rowPb) {
        row.add(FieldValue.fromPb(cellPb, null, useInt64Timestamps));
      }
    }

    return FieldValueList.of(row, schema);
  }
}
