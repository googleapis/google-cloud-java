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

import com.google.api.services.bigquery.model.TableReference;
import com.google.common.base.Function;

import java.io.Serializable;
import java.util.Objects;

/**
 * Google BigQuery Table identity.
 */
public class TableId implements Serializable {

  static final Function<TableReference, TableId> FROM_PB_FUNCTION =
      new Function<TableReference, TableId>() {
        @Override
        public TableId apply(TableReference pb) {
          return TableId.fromPb(pb);
        }
      };
  static final Function<TableId, TableReference> TO_PB_FUNCTION =
      new Function<TableId, TableReference>() {
        @Override
        public TableReference apply(TableId tableId) {
          return tableId.toPb();
        }
      };
  private static final long serialVersionUID = -6186254820908152300L;

  private final String project;
  private final String dataset;
  private final String table;

  /**
   * Returns project's user-defined id
   */
  public String project() {
    return project;
  }

  /**
   * Returns dataset's user-defined id.
   */
  public String dataset() {
    return dataset;
  }

  /**
   * Returns table's user-defined id.
   */
  public String table() {
    return table;
  }

  private TableId(String project, String dataset, String table) {
    this.project = project;
    this.dataset = dataset;
    this.table = table;
  }

  /**
   * Creates a table identity given project's, dataset's and table's user-defined ids.
   */
  public static TableId of(String project, String dataset, String table) {
    return new TableId(checkNotNull(project), checkNotNull(dataset), checkNotNull(table));
  }

  /**
   * Creates a table identity given dataset's and table's user-defined ids.
   */
  public static TableId of(String dataset, String table) {
    return new TableId(null, checkNotNull(dataset), checkNotNull(table));
  }

  @Override
  public boolean equals(Object obj) {
    return obj instanceof TableId && Objects.equals(toPb(), ((TableId) obj).toPb());
  }

  @Override
  public int hashCode() {
    return Objects.hash(project, dataset, table);
  }

  @Override
  public String toString() {
    return toPb().toString();
  }

  TableReference toPb() {
    return new TableReference().setProjectId(project).setDatasetId(dataset).setTableId(table);
  }

  static TableId fromPb(TableReference tableRef) {
    return new TableId(
        tableRef.getProjectId(),
        tableRef.getDatasetId(),
        tableRef.getTableId());
  }
}
