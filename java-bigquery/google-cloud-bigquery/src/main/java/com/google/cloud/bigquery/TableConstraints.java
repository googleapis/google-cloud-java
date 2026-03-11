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
public abstract class TableConstraints implements Serializable {
  public static TableConstraints.Builder newBuilder() {
    return new AutoValue_TableConstraints.Builder();
  }

  static TableConstraints fromPb(
      com.google.api.services.bigquery.model.TableConstraints tableConstraints) {
    TableConstraints.Builder builder = newBuilder();

    if (tableConstraints.getForeignKeys() != null) {
      builder.setForeignKeys(
          tableConstraints.getForeignKeys().stream()
              .map(ForeignKey::fromPb)
              .collect(Collectors.toList()));
    }
    if (tableConstraints.getPrimaryKey() != null) {
      builder.setPrimaryKey(PrimaryKey.fromPb(tableConstraints.getPrimaryKey()));
    }

    return builder.build();
  }

  com.google.api.services.bigquery.model.TableConstraints toPb() {

    com.google.api.services.bigquery.model.TableConstraints tableConstraints =
        new com.google.api.services.bigquery.model.TableConstraints();
    if (getForeignKeys() != null) {
      tableConstraints.setForeignKeys(
          getForeignKeys().stream().map(ForeignKey::toPb).collect(Collectors.toList()));
    }
    if (getPrimaryKey() != null) {
      tableConstraints.setPrimaryKey(getPrimaryKey().toPb());
    }

    return tableConstraints;
  }

  @Nullable
  public abstract List<ForeignKey> getForeignKeys();

  @Nullable
  public abstract PrimaryKey getPrimaryKey();

  /** Returns a builder for table constraints. */
  @VisibleForTesting
  public abstract TableConstraints.Builder toBuilder();

  @AutoValue.Builder
  public abstract static class Builder {

    /** The list of foreign keys for the table constraints. * */
    public abstract TableConstraints.Builder setForeignKeys(List<ForeignKey> foreignKeys);

    /** The primary key for the table constraints. * */
    public abstract TableConstraints.Builder setPrimaryKey(PrimaryKey primaryKey);

    /** Creates a {@code TableConstraints} object. */
    public abstract TableConstraints build();
  }
}
