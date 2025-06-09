/*
 * Copyright 2015 Google LLC
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

import com.google.common.base.MoreObjects;
import com.google.common.collect.ImmutableList;
import com.google.common.collect.ImmutableMap;
import com.google.common.collect.Lists;
import io.opentelemetry.api.common.Attributes;
import java.io.Serializable;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;

/**
 * Google Cloud BigQuery insert all request. This class can be used to stream data into BigQuery one
 * record at a time without needing to run a load job. This approach enables querying data without
 * the delay of running a load job. There are several important trade-offs to consider before
 * choosing an approach.
 *
 * @see <a href="https://cloud.google.com/bigquery/streaming-data-into-bigquery">Streaming Data into
 *     BigQuery</a>
 */
public final class InsertAllRequest implements Serializable {

  private static final long serialVersionUID = 211200307773853078L;

  private final TableId table;
  private final List<RowToInsert> rows;
  private final Boolean skipInvalidRows;
  private final Boolean ignoreUnknownValues;
  private final String templateSuffix;

  /**
   * A Google Big Query row to be inserted into a table. Each {@code RowToInsert} has an associated
   * id used by BigQuery to detect duplicate insertion requests on a best-effort basis.
   *
   * <p>To ensure proper serialization of numeric data, it is recommended to supply values using a
   * string-typed representation. Additionally, data for fields of {@link LegacySQLTypeName#BYTES}
   * must be provided as a base64 encoded string.
   *
   * <p>Example usage of creating a row to insert:
   *
   * <pre>{@code
   * List<Long> repeatedFieldValue = Arrays.asList(1L, 2L);
   * Map<String, Object> recordContent = new HashMap<String, Object>();
   * recordContent.put("subfieldName1", "value");
   * recordContent.put("subfieldName2", repeatedFieldValue);
   * Map<String, Object> rowContent = new HashMap<String, Object>();
   * rowContent.put("booleanFieldName", true);
   * rowContent.put("bytesFieldName", "DQ4KDQ==");
   * rowContent.put("recordFieldName", recordContent);
   * rowContent.put("numericFieldName", "1298930929292.129593272");
   * RowToInsert row = new RowToInsert("rowId", rowContent);
   * }</pre>
   *
   * @see <a href ="https://cloud.google.com/bigquery/streaming-data-into-bigquery#dataconsistency">
   *     Data Consistency</a>
   */
  public static class RowToInsert implements Serializable {

    private static final long serialVersionUID = 8563060538219179157L;

    private final String id;

    // Always immutable, but might not be ImmutableMap, since they don't support nulls.
    private final Map<String, Object> content;

    RowToInsert(String id, Map<String, ?> content) {
      this.id = id;

      if (content instanceof ImmutableMap) {
        this.content = ImmutableMap.copyOf(content);
      } else {
        this.content = Collections.unmodifiableMap(new HashMap<>(content));
      }
    }

    /** Returns the id associated with the row. Returns {@code null} if not set. */
    public String getId() {
      return id;
    }

    /**
     * Returns the actual content of the row, as a map.
     *
     * <p>The returned map is always immutable. Its iteration order is unspecified.
     */
    public Map<String, Object> getContent() {
      return content;
    }

    @Override
    public String toString() {
      return MoreObjects.toStringHelper(this).add("id", id).add("content", content).toString();
    }

    @Override
    public int hashCode() {
      return Objects.hash(id, content);
    }

    @Override
    public boolean equals(Object obj) {
      if (!(obj instanceof RowToInsert)) {
        return false;
      }
      RowToInsert other = (RowToInsert) obj;
      return Objects.equals(id, other.id) && Objects.equals(content, other.content);
    }

    /**
     * Creates a row to be inserted with associated id.
     *
     * <p>To ensure proper serialization of numeric data, supply values using a string-typed
     * representation. Additionally, data for fields of {@link LegacySQLTypeName#BYTES} must be
     * provided as a base64 encoded string.
     *
     * @param id id of the row, used to identify duplicates
     * @param content the actual content of the row
     */
    public static RowToInsert of(String id, Map<String, ?> content) {
      return new RowToInsert(checkNotNull(id), checkNotNull(content));
    }

    /**
     * Creates a row to be inserted without associated id.
     *
     * <p>To ensure proper serialization of numeric data, supply values using a string-typed
     * representation. Additionally, data for fields of type {@link LegacySQLTypeName#BYTES} must be
     * provided as a base64 encoded string.
     *
     * @param content the actual content of the row
     */
    public static RowToInsert of(Map<String, ?> content) {
      return new RowToInsert(null, checkNotNull(content));
    }
  }

  public static final class Builder {

    private TableId table;
    private List<RowToInsert> rows;
    private Boolean skipInvalidRows;
    private Boolean ignoreUnknownValues;
    private String templateSuffix;

    private Builder() {}

    /** Sets the destination table for rows insert request. */
    public Builder setTable(TableId table) {
      this.table = checkNotNull(table);
      return this;
    }

    /** Sets the rows to insert as a list of {@link RowToInsert} objects. */
    public Builder setRows(Iterable<RowToInsert> rows) {
      this.rows = Lists.newLinkedList(checkNotNull(rows));
      return this;
    }

    /** Adds a row to be inserted. */
    public Builder addRow(RowToInsert rowToInsert) {
      checkNotNull(rowToInsert);
      if (rows == null) {
        rows = Lists.newArrayList();
      }
      rows.add(rowToInsert);
      return this;
    }

    /**
     * Adds a row to be inserted with associated id.
     *
     * <p>To ensure proper serialization of numeric data, supply values using a string-typed
     * representation. Additionally, data for fields of {@link LegacySQLTypeName#BYTES} must be
     * provided as a base64 encoded string.
     *
     * <p>Example usage of adding a row with associated id:
     *
     * <pre>{@code
     * InsertAllRequest.Builder builder = InsertAllRequest.builder(tableId);
     * List<Long> repeatedFieldValue = Arrays.asList(1L, 2L);
     * Map<String, Object> recordContent = new HashMap<String, Object>();
     * recordContent.put("subfieldName1", "value");
     * recordContent.put("subfieldName2", repeatedFieldValue);
     * Map<String, Object> rowContent = new HashMap<String, Object>();
     * rowContent.put("booleanFieldName", true);
     * rowContent.put("bytesFieldName", "DQ4KDQ==");
     * rowContent.put("recordFieldName", recordContent);
     * rowContent.put("numericFieldName", "1298930929292.129593272");
     * builder.addRow("rowId", rowContent);
     * }</pre>
     */
    public Builder addRow(String id, Map<String, ?> content) {
      addRow(new RowToInsert(id, content));
      return this;
    }

    /**
     * Adds a row to be inserted without an associated id.
     *
     * <p>To ensure proper serialization of numeric data, it is recommended to supply values using a
     * string-typed representation. Additionally, data for fields of type {@link
     * LegacySQLTypeName#BYTES} must be provided as a base64 encoded string.
     *
     * <p>Example usage of adding a row without an associated id:
     *
     * <pre>{@code
     * InsertAllRequest.Builder builder = InsertAllRequest.builder(tableId);
     * List<Long> repeatedFieldValue = Arrays.asList(1L, 2L);
     * Map<String, Object> recordContent = new HashMap<String, Object>();
     * recordContent.put("subfieldName1", "value");
     * recordContent.put("subfieldName2", repeatedFieldValue);
     * Map<String, Object> rowContent = new HashMap<String, Object>();
     * rowContent.put("booleanFieldName", true);
     * rowContent.put("bytesFieldName", "DQ4KDQ==");
     * rowContent.put("recordFieldName", recordContent);
     * rowContent.put("numericFieldName", "1298930929292.129593272");
     * builder.addRow(rowContent);
     * }</pre>
     */
    public Builder addRow(Map<String, ?> content) {
      addRow(new RowToInsert(null, content));
      return this;
    }

    /**
     * Sets whether to insert all valid rows of a request, even if invalid rows exist. If not set
     * the entire insert request will fail if it contains an invalid row.
     */
    public Builder setSkipInvalidRows(boolean skipInvalidRows) {
      this.skipInvalidRows = skipInvalidRows;
      return this;
    }

    /**
     * Sets whether to accept rows that contain values that do not match the schema. The unknown
     * values are ignored. If not set, rows with unknown values are considered to be invalid.
     */
    public Builder setIgnoreUnknownValues(boolean ignoreUnknownValues) {
      this.ignoreUnknownValues = ignoreUnknownValues;
      return this;
    }

    /**
     * If specified, the destination table is treated as a base template. Rows are inserted into an
     * instance table named "{destination}{templateSuffix}". BigQuery will manage the creation of
     * the instance table, using the schema of the base template table. Table creation might take
     * some time. To obtain table's information after {@link BigQuery#insertAll(InsertAllRequest)}
     * is called use:
     *
     * <pre>{@code
     * String suffixTableId = ...;
     * TableInfo suffixTable = bigquery.getTable(DATASET, suffixTableId);
     * while (suffixTable == null) {
     *   Thread.sleep(1000L);
     *   suffixTable = bigquery.getTable(DATASET, suffixTableId);
     * }
     * }</pre>
     *
     * @see <a
     *     href="https://cloud.google.com/bigquery/streaming-data-into-bigquery#template-tables">
     *     Template Tables</a>
     */
    public Builder setTemplateSuffix(String templateSuffix) {
      this.templateSuffix = templateSuffix;
      return this;
    }

    /** Creates an {@code InsertAllRequest} object. */
    public InsertAllRequest build() {
      return new InsertAllRequest(this);
    }
  }

  private InsertAllRequest(Builder builder) {
    this.table = checkNotNull(builder.table);
    this.rows = ImmutableList.copyOf(checkNotNull(builder.rows));
    this.ignoreUnknownValues = builder.ignoreUnknownValues;
    this.skipInvalidRows = builder.skipInvalidRows;
    this.templateSuffix = builder.templateSuffix;
  }

  /** Returns the destination table for rows insert request. */
  public TableId getTable() {
    return table;
  }

  /** Returns the rows to be inserted. */
  public List<RowToInsert> getRows() {
    return rows;
  }

  /**
   * Returns whether to accept rows that contain values that do not match the schema. The unknown
   * values are ignored. If not set, rows with unknown values are considered to be invalid.
   */
  public Boolean ignoreUnknownValues() {
    return ignoreUnknownValues;
  }

  /**
   * Returns whether to insert all valid rows of a request, even if invalid rows exist. If not set
   * the entire insert request will fail if it contains an invalid row.
   */
  public Boolean skipInvalidRows() {
    return skipInvalidRows;
  }

  /**
   * If specified, the destination table is treated as a base template. Rows are inserted into an
   * instance table named "{destination}{templateSuffix}". BigQuery will manage the creation of the
   * instance table, using the schema of the base template table. Table creation might take some
   * time. To obtain table's information after {@link BigQuery#insertAll(InsertAllRequest)} is
   * called use:
   *
   * <pre>{@code
   * String suffixTableId = ...;
   * TableInfo suffixTable = bigquery.getTable(DATASET, suffixTableId);
   * while (suffixTable == null) {
   *   Thread.sleep(1000L);
   *   suffixTable = bigquery.getTable(DATASET, suffixTableId);
   * }
   * }</pre>
   *
   * @see <a href="https://cloud.google.com/bigquery/streaming-data-into-bigquery#template-tables">
   *     Template Tables</a>
   */
  public String getTemplateSuffix() {
    return templateSuffix;
  }

  /** Returns a builder for an {@code InsertAllRequest} object given the destination table. */
  public static Builder newBuilder(TableId table) {
    return new Builder().setTable(table);
  }

  /**
   * Returns a builder for an {@code InsertAllRequest} object given the destination table and the
   * rows to insert.
   */
  public static Builder newBuilder(TableId table, Iterable<RowToInsert> rows) {
    return newBuilder(table).setRows(rows);
  }

  /**
   * Returns a builder for an {@code InsertAllRequest} object given the destination table and the
   * rows to insert.
   */
  public static Builder newBuilder(TableId table, RowToInsert... rows) {
    return newBuilder(table, ImmutableList.copyOf(rows));
  }

  /** Returns a builder for an {@code InsertAllRequest} object given the destination table. */
  public static Builder newBuilder(String datasetId, String tableId) {
    return new Builder().setTable(TableId.of(datasetId, tableId));
  }

  /**
   * Returns a builder for an {@code InsertAllRequest} object given the destination table and the
   * rows to insert.
   */
  public static Builder newBuilder(String datasetId, String tableId, Iterable<RowToInsert> rows) {
    return newBuilder(TableId.of(datasetId, tableId), rows);
  }

  /**
   * Returns a builder for an {@code InsertAllRequest} object given the destination table and the
   * rows to insert.
   */
  public static Builder newBuilder(String datasetId, String tableId, RowToInsert... rows) {
    return newBuilder(TableId.of(datasetId, tableId), rows);
  }

  /**
   * Returns a builder for an {@code InsertAllRequest} object given the destination table and the
   * rows to insert.
   */
  public static Builder newBuilder(TableInfo tableInfo, Iterable<RowToInsert> rows) {
    return newBuilder(tableInfo.getTableId(), rows);
  }

  /**
   * Returns a builder for an {@code InsertAllRequest} object given the destination table and the
   * rows to insert.
   */
  public static Builder newBuilder(TableInfo tableInfo, RowToInsert... rows) {
    return newBuilder(tableInfo.getTableId(), rows);
  }

  /**
   * Returns a {@code InsertAllRequest} object given the destination table and the rows to insert.
   */
  public static InsertAllRequest of(TableId tableId, Iterable<RowToInsert> rows) {
    return newBuilder(tableId, rows).build();
  }

  /**
   * Returns a {@code InsertAllRequest} object given the destination table and the rows to insert.
   */
  public static InsertAllRequest of(TableId tableId, RowToInsert... rows) {
    return newBuilder(tableId, rows).build();
  }

  /**
   * Returns a {@code InsertAllRequest} object given the destination table and the rows to insert.
   */
  public static InsertAllRequest of(String datasetId, String tableId, Iterable<RowToInsert> rows) {
    return newBuilder(datasetId, tableId, rows).build();
  }

  /**
   * Returns a {@code InsertAllRequest} object given the destination table and the rows to insert.
   */
  public static InsertAllRequest of(String datasetId, String tableId, RowToInsert... rows) {
    return newBuilder(datasetId, tableId, rows).build();
  }

  /**
   * Returns a {@code InsertAllRequest} object given the destination table and the rows to insert.
   */
  public static InsertAllRequest of(TableInfo tableInfo, Iterable<RowToInsert> rows) {
    return newBuilder(tableInfo.getTableId(), rows).build();
  }

  /**
   * Returns a {@code InsertAllRequest} object given the destination table and the rows to insert.
   */
  public static InsertAllRequest of(TableInfo tableInfo, RowToInsert... rows) {
    return newBuilder(tableInfo.getTableId(), rows).build();
  }

  @Override
  public String toString() {
    return MoreObjects.toStringHelper(this)
        .add("table", table)
        .add("rows", rows)
        .add("ignoreUnknownValues", ignoreUnknownValues)
        .add("skipInvalidRows", skipInvalidRows)
        .add("templateSuffix", templateSuffix)
        .toString();
  }

  @Override
  public int hashCode() {
    return Objects.hash(table, rows, ignoreUnknownValues, skipInvalidRows, templateSuffix);
  }

  @Override
  public boolean equals(Object obj) {
    if (obj == this) {
      return true;
    }
    if (!(obj instanceof InsertAllRequest)) {
      return false;
    }
    InsertAllRequest other = (InsertAllRequest) obj;
    return Objects.equals(table, other.table)
        && Objects.equals(rows, other.rows)
        && Objects.equals(ignoreUnknownValues, other.ignoreUnknownValues)
        && Objects.equals(skipInvalidRows, other.skipInvalidRows)
        && Objects.equals(templateSuffix, other.templateSuffix);
  }

  private static String getFieldAsString(Object field) {
    return field == null ? "null" : field.toString();
  }

  public Attributes getOtelAttributes() {
    return Attributes.builder()
        .put("bq.insert_all.table", getFieldAsString(this.getTable().getTable()))
        .put("bq.insert_all.template_suffix", getFieldAsString(this.getTemplateSuffix()))
        .build();
  }
}
