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
import javax.annotation.Nullable;

@AutoValue
public abstract class ColumnReference {
  public static ColumnReference.Builder newBuilder() {
    return new AutoValue_ColumnReference.Builder();
  }

  static ColumnReference fromPb(
      com.google.api.services.bigquery.model.TableConstraints.ForeignKeys.ColumnReferences
          columnReference) {
    ColumnReference.Builder builder = newBuilder();

    if (columnReference.getReferencedColumn() != null) {
      builder.setReferencedColumn(columnReference.getReferencedColumn());
    }

    if (columnReference.getReferencingColumn() != null) {
      builder.setReferencingColumn(columnReference.getReferencingColumn());
    }

    return builder.build();
  }

  com.google.api.services.bigquery.model.TableConstraints.ForeignKeys.ColumnReferences toPb() {

    com.google.api.services.bigquery.model.TableConstraints.ForeignKeys.ColumnReferences
        columnReference =
            new com.google.api.services.bigquery.model.TableConstraints.ForeignKeys
                .ColumnReferences();
    columnReference.setReferencedColumn(getReferencedColumn());
    columnReference.setReferencingColumn(getReferencingColumn());

    return columnReference;
  }

  @Nullable
  public abstract String getReferencedColumn();

  @Nullable
  public abstract String getReferencingColumn();

  /** Returns a builder for column reference. */
  @VisibleForTesting
  public abstract ColumnReference.Builder toBuilder();

  @AutoValue.Builder
  public abstract static class Builder {

    /** The target column of this reference. * */
    public abstract ColumnReference.Builder setReferencedColumn(String referencedColumn);

    /** The source column of this reference. * */
    public abstract ColumnReference.Builder setReferencingColumn(String referencingColumn);

    /** Creates a {@code ColumnReference} object. */
    public abstract ColumnReference build();
  }
}
