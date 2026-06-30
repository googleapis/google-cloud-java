/*
 * Copyright 2023 Google LLC
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

import com.google.auto.value.AutoValue;
import com.google.common.annotations.VisibleForTesting;
import java.io.Serializable;
import java.util.List;
import java.util.stream.Collectors;
import javax.annotation.Nullable;

@AutoValue
public abstract class ForeignKey implements Serializable {
  public static ForeignKey.Builder newBuilder() {
    return new AutoValue_ForeignKey.Builder();
  }

  static ForeignKey fromPb(
      com.google.api.services.bigquery.model.TableConstraints.ForeignKeys foreignKey) {
    ForeignKey.Builder builder = newBuilder();

    if (foreignKey.getName() != null) {
      builder.setName(foreignKey.getName());
    }

    if (foreignKey.getReferencedTable() != null) {
      com.google.api.services.bigquery.model.TableConstraints.ForeignKeys.ReferencedTable
          referencedTable = foreignKey.getReferencedTable();
      builder.setReferencedTable(
          TableId.of(
              referencedTable.getProjectId(),
              referencedTable.getDatasetId(),
              referencedTable.getTableId()));
    }

    if (foreignKey.getColumnReferences() != null) {
      builder.setColumnReferences(
          foreignKey.getColumnReferences().stream()
              .map(ColumnReference::fromPb)
              .collect(Collectors.toList()));
    }

    return builder.build();
  }

  com.google.api.services.bigquery.model.TableConstraints.ForeignKeys toPb() {

    com.google.api.services.bigquery.model.TableConstraints.ForeignKeys foreignKey =
        new com.google.api.services.bigquery.model.TableConstraints.ForeignKeys();
    if (getName() != null) {
      foreignKey.setName(getName());
    }
    if (getReferencedTable() != null) {
      TableId referencedTableId = getReferencedTable();
      foreignKey.setReferencedTable(
          new com.google.api.services.bigquery.model.TableConstraints.ForeignKeys.ReferencedTable()
              .setTableId(referencedTableId.getTable())
              .setDatasetId(referencedTableId.getDataset())
              .setProjectId(referencedTableId.getProject()));
    }
    if (getColumnReferences() != null) {
      foreignKey.setColumnReferences(
          getColumnReferences().stream().map(ColumnReference::toPb).collect(Collectors.toList()));
    }
    return foreignKey;
  }

  @Nullable
  public abstract String getName();

  @Nullable
  public abstract TableId getReferencedTable();

  @Nullable
  public abstract List<ColumnReference> getColumnReferences();

  /** Returns a builder for foreign key. */
  @VisibleForTesting
  public abstract ForeignKey.Builder toBuilder();

  @AutoValue.Builder
  public abstract static class Builder {

    /** The name of the foreign key. * */
    public abstract ForeignKey.Builder setName(String name);

    /** The table referenced by this foreign key. * */
    public abstract ForeignKey.Builder setReferencedTable(TableId referencedTable);

    /** The set of column references for this foreign key. * */
    public abstract ForeignKey.Builder setColumnReferences(List<ColumnReference> columnReferences);

    /** Creates a {@code ForignKey} object. */
    public abstract ForeignKey build();
  }
}
