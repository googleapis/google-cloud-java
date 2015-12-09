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

package com.google.gcloud.bigquery;

import static com.google.common.base.Preconditions.checkNotNull;

import com.google.common.base.MoreObjects;
import com.google.common.collect.ImmutableList;
import com.google.common.collect.Lists;

import java.io.Serializable;
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
public class InsertAllRequest implements Serializable {

  private static final long serialVersionUID = 211200307773853078L;

  private final TableId table;
  private final List<RowToInsert> rows;
  private final Boolean skipInvalidRows;
  private final Boolean ignoreUnknownValues;

  /**
   * A Google Big Query row to be inserted into a table. Each {@code RowToInsert} has an associated
   * id used by BigQuery to detect duplicate insertion requests on a best-effort basis.
   *
   * <p>
   * Example usage of creating a row to insert:
   * <pre>    {@code
   *   List<Long> repeatedFieldValue = Arrays.asList(1L, 2L);
   *   Map<String, Object> recordContent = new HashMap<String, Object>();
   *   recordContent.put("subfieldName1", "value");
   *   recordContent.put("subfieldName2", repeatedFieldValue);
   *   Map<String, Object> rowContent = new HashMap<String, Object>();
   *   rowContent.put("fieldName1", true);
   *   rowContent.put("fieldName2", recordContent);
   *   RowToInsert row = new RowToInsert("rowId", rowContent);
   * }</pre>
   *
   * @see <a href ="https://cloud.google.com/bigquery/streaming-data-into-bigquery#dataconsistency">
   *     Data Consistency</a>
   */
  public static class RowToInsert implements Serializable {

    private static final long serialVersionUID = 8563060538219179157L;

    private final String id;
    private final Map<String, Object> content;

    RowToInsert(String id, Map<String, Object> content) {
      this.id = id;
      this.content = content;
    }

    /**
     * Returns the id associated with the row. Returns {@code null} if not set.
     */
    public String id() {
      return id;
    }

    /**
     * Returns the actual content of the row, as a map.
     */
    public Map<String, Object> content() {
      return content;
    }

    @Override
    public String toString() {
      return MoreObjects.toStringHelper(this)
          .add("id", id)
          .add("content", content)
          .toString();
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
      return Objects.equals(id, other.id)
          && Objects.equals(content, other.content);
    }

    /**
     * Creates a row to be inserted.
     *
     * @param id id of the row, used to identify duplicates
     * @param content the actual content of the row
     */
    public static RowToInsert of(String id, Map<String, Object> content) {
      return new RowToInsert(checkNotNull(id), checkNotNull(content));
    }
  }

  public static final class Builder {

    private TableId table;
    private List<RowToInsert> rows;
    private Boolean skipInvalidRows;
    private Boolean ignoreUnknownValues;

    private Builder() {}

    /**
     * Sets the destination table for rows insert request.
     */
    public Builder table(TableId table) {
      this.table = checkNotNull(table);
      return this;
    }

    /**
     * Sets the rows to insert as a list of {@link RowToInsert} objects.
     */
    public Builder rows(Iterable<RowToInsert> rows) {
      this.rows = Lists.newLinkedList(checkNotNull(rows));
      return this;
    }

    /**
     * Adds a row to be inserted.
     */
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
     * <p>
     * Example usage of adding a row with associated id:
     * <pre>    {@code
     *   InsertAllRequest.Buider builder = InsertAllRequest.builder(tableId);
     *   List<Long> repeatedFieldValue = Arrays.asList(1L, 2L);
     *   Map<String, Object> recordContent = new HashMap<String, Object>();
     *   recordContent.put("subfieldName1", "value");
     *   recordContent.put("subfieldName2", repeatedFieldValue);
     *   Map<String, Object> rowContent = new HashMap<String, Object>();
     *   rowContent.put("fieldName1", true);
     *   rowContent.put("fieldName2", recordContent);
     *   builder.addRow("rowId", rowContent);
     * }</pre>
     */
    public Builder addRow(String id, Map<String, Object> content) {
      addRow(new RowToInsert(id, content));
      return this;
    }

    /**
     * Adds a row to be inserted without an associated id.
     *
     * <p>
     * Example usage of adding a row without an associated id:
     * <pre>    {@code
     *   InsertAllRequest.Buider builder = InsertAllRequest.builder(tableId);
     *   List<Long> repeatedFieldValue = Arrays.asList(1L, 2L);
     *   Map<String, Object> recordContent = new HashMap<String, Object>();
     *   recordContent.put("subfieldName1", "value");
     *   recordContent.put("subfieldName2", repeatedFieldValue);
     *   Map<String, Object> rowContent = new HashMap<String, Object>();
     *   rowContent.put("fieldName1", true);
     *   rowContent.put("fieldName2", recordContent);
     *   builder.addRow(rowContent);
     * }</pre>
     */
    public Builder addRow(Map<String, Object> content) {
      addRow(new RowToInsert(null, content));
      return this;
    }

    /**
     * Sets whether to insert all valid rows of a request, even if invalid rows exist. If not set
     * the entire insert request will fail if it contains an invalid row.
     */
    public Builder skipInvalidRows(boolean skipInvalidRows) {
      this.skipInvalidRows = skipInvalidRows;
      return this;
    }

    /**
     * Sets whether to accept rows that contain values that do not match the schema. The unknown
     * values are ignored. If not set, rows with unknown values are considered to be invalid.
     */
    public Builder ignoreUnknownValues(boolean ignoreUnknownValues) {
      this.ignoreUnknownValues = ignoreUnknownValues;
      return this;
    }

    public InsertAllRequest build() {
      return new InsertAllRequest(this);
    }
  }

  private InsertAllRequest(Builder builder) {
    this.table = checkNotNull(builder.table);
    this.rows = ImmutableList.copyOf(checkNotNull(builder.rows));
    this.ignoreUnknownValues = builder.ignoreUnknownValues;
    this.skipInvalidRows = builder.skipInvalidRows;
  }

  /**
   * Returns the destination table for rows insert request.
   */
  public TableId table() {
    return table;
  }

  /**
   * Returns the rows to be inserted.
   */
  public List<RowToInsert> rows() {
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
   * Returns a builder for an {@code InsertAllRequest} object given the destination table.
   */
  public static Builder builder(TableId table) {
    return new Builder().table(table);
  }

  /**
   * Returns a builder for an {@code InsertAllRequest} object given the destination table and the
   * rows to insert.
   */
  public static Builder builder(TableId table, Iterable<RowToInsert> rows) {
    return builder(table).rows(rows);
  }

  /**
   * Returns a builder for an {@code InsertAllRequest} object given the destination table and the
   * rows to insert.
   */
  public static Builder builder(TableId table, RowToInsert... rows) {
    return builder(table, ImmutableList.copyOf(rows));
  }

  /**
   * Returns a builder for an {@code InsertAllRequest} object given the destination table.
   */
  public static Builder builder(String datasetId, String tableId) {
    return new Builder().table(TableId.of(datasetId, tableId));
  }

  /**
   * Returns a builder for an {@code InsertAllRequest} object given the destination table and the
   * rows to insert.
   */
  public static Builder builder(String datasetId, String tableId, Iterable<RowToInsert> rows) {
    return builder(TableId.of(datasetId, tableId), rows);
  }

  /**
   * Returns a builder for an {@code InsertAllRequest} object given the destination table and the
   * rows to insert.
   */
  public static Builder builder(String datasetId, String tableId, RowToInsert... rows) {
    return builder(TableId.of(datasetId, tableId), rows);
  }

  /**
   * Returns a builder for an {@code InsertAllRequest} object given the destination table and the
   * rows to insert.
   */
  public static Builder builder(BaseTableInfo tableInfo, Iterable<RowToInsert> rows) {
    return builder(tableInfo.tableId(), rows);
  }

  /**
   * Returns a builder for an {@code InsertAllRequest} object given the destination table and the
   * rows to insert.
   */
  public static Builder builder(BaseTableInfo tableInfo, RowToInsert... rows) {
    return builder(tableInfo.tableId(), rows);
  }

  /**
   * Returns a {@code InsertAllRequest} object given the destination table and the rows to insert.
   */
  public static InsertAllRequest of(TableId tableId, Iterable<RowToInsert> rows) {
    return builder(tableId, rows).build();
  }

  /**
   * Returns a {@code InsertAllRequest} object given the destination table and the rows to insert.
   */
  public static InsertAllRequest of(TableId tableId, RowToInsert... rows) {
    return builder(tableId, rows).build();
  }

  /**
   * Returns a {@code InsertAllRequest} object given the destination table and the rows to insert.
   */
  public static InsertAllRequest of(String datasetId, String tableId, Iterable<RowToInsert> rows) {
    return builder(datasetId, tableId, rows).build();
  }

  /**
   * Returns a {@code InsertAllRequest} object given the destination table and the rows to insert.
   */
  public static InsertAllRequest of(String datasetId, String tableId, RowToInsert... rows) {
    return builder(datasetId, tableId, rows).build();
  }

  /**
   * Returns a {@code InsertAllRequest} object given the destination table and the rows to insert.
   */
  public static InsertAllRequest of(BaseTableInfo tableInfo, Iterable<RowToInsert> rows) {
    return builder(tableInfo.tableId(), rows).build();
  }

  /**
   * Returns a {@code InsertAllRequest} object given the destination table and the rows to insert.
   */
  public static InsertAllRequest of(BaseTableInfo tableInfo, RowToInsert... rows) {
    return builder(tableInfo.tableId(), rows).build();
  }

  @Override
  public String toString() {
    return MoreObjects.toStringHelper(this)
        .add("table", table)
        .add("rows", rows)
        .add("ignoreUnknownValues", ignoreUnknownValues)
        .add("skipInvalidRows", skipInvalidRows)
        .toString();
  }

  @Override
  public int hashCode() {
    return Objects.hash(table, rows, ignoreUnknownValues, skipInvalidRows);
  }

  @Override
  public boolean equals(Object obj) {
    if (!(obj instanceof InsertAllRequest)) {
      return false;
    }
    InsertAllRequest other = (InsertAllRequest) obj;
    return Objects.equals(table, other.table)
        && Objects.equals(rows, other.rows)
        && Objects.equals(ignoreUnknownValues, other.ignoreUnknownValues)
        && Objects.equals(skipInvalidRows, other.skipInvalidRows);
  }
}
