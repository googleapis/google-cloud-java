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
import javax.annotation.Nullable;

@AutoValue
public abstract class PrimaryKey implements Serializable {
  public static PrimaryKey.Builder newBuilder() {
    return new AutoValue_PrimaryKey.Builder();
  }

  static PrimaryKey fromPb(
      com.google.api.services.bigquery.model.TableConstraints.PrimaryKey primaryKey) {
    PrimaryKey.Builder builder = newBuilder();

    if (primaryKey.getColumns() != null) {
      builder.setColumns(primaryKey.getColumns());
    }

    return builder.build();
  }

  com.google.api.services.bigquery.model.TableConstraints.PrimaryKey toPb() {

    com.google.api.services.bigquery.model.TableConstraints.PrimaryKey primaryKey =
        new com.google.api.services.bigquery.model.TableConstraints.PrimaryKey();
    if (getColumns() != null) {
      primaryKey.setColumns(getColumns());
    }
    return primaryKey;
  }

  @Nullable
  public abstract List<String> getColumns();

  /** Returns a builder for primary key. */
  @VisibleForTesting
  public abstract PrimaryKey.Builder toBuilder();

  @AutoValue.Builder
  public abstract static class Builder {

    /** The column names that are primary keys. * */
    public abstract PrimaryKey.Builder setColumns(List<String> columns);

    /** Creates a {@code PrimaryKey} object. */
    public abstract PrimaryKey build();
  }
}
