/*
 * Copyright 2018 Google LLC
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
import com.google.common.base.Function;
import java.io.Serializable;
import javax.annotation.Nullable;

@AutoValue
public abstract class BigtableColumn implements Serializable {

  private static final long serialVersionUID = 1L;

  @Nullable
  public abstract String getQualifierEncoded();

  @Nullable
  public abstract String getFieldName();

  @Nullable
  public abstract Boolean getOnlyReadLatest();

  @Nullable
  public abstract String getEncoding();

  @Nullable
  public abstract String getType();

  @AutoValue.Builder
  public abstract static class Builder {

    /**
     * Qualifier of the column.
     *
     * <p>Columns in the parent column family that has this exact qualifier are exposed as . field.
     * If the qualifier is valid UTF-8 string, it can be specified in the qualifier_string field.
     * Otherwise, a base-64 encoded value must be set to qualifier_encoded. The column field name is
     * the same as the column qualifier. However, if the qualifier is not a valid BigQuery field
     * identifier, a valid identifier must be provided as field_name.
     */
    public abstract Builder setQualifierEncoded(String qualifierEncoded);

    /**
     * If the qualifier is not a valid BigQuery field identifier, a valid identifier must be
     * provided as the column field name and is used as field name in queries.
     */
    public abstract Builder setFieldName(String fieldName);

    /**
     * If this is set, only the latest version of value in this column are exposed.
     *
     * <p>'onlyReadLatest' can also be set at the column family level. However, the setting at the
     * column level takes precedence if 'onlyReadLatest' is set at both levels.
     */
    public abstract Builder setOnlyReadLatest(Boolean onlyReadLatest);

    /**
     * The encoding of the values when the type is not STRING. Acceptable encoding values are: TEXT
     * - indicates values are alphanumeric text strings. BINARY - indicates values are encoded using
     * HBase Bytes.toBytes family of functions.
     *
     * <p>Encoding can also be set at the column family level. However, the setting at the column
     * level takes precedence if 'encoding' is set at both levels.
     */
    public abstract Builder setEncoding(String encoding);

    /**
     * The type to convert the value in cells of this column.
     *
     * <p>The values are expected to be encoded using HBase Bytes.toBytes function when using the
     * BINARY encoding value. Following BigQuery types are allowed (case-sensitive): BYTES STRING
     * INTEGER FLOAT BOOLEAN Default type is BYTES.
     *
     * <p>'type' can also be set at the column family level. However, the setting at the column
     * level takes precedence if 'type' is set at both levels.
     */
    public abstract Builder setType(String type);

    public abstract BigtableColumn build();
  }

  static Builder newBuilder() {
    return new AutoValue_BigtableColumn.Builder();
  }

  static BigtableColumn fromPb(com.google.api.services.bigquery.model.BigtableColumn column) {
    Builder builder = newBuilder();
    builder.setQualifierEncoded(column.getQualifierEncoded());
    builder.setFieldName(column.getFieldName());
    builder.setOnlyReadLatest(column.getOnlyReadLatest());
    builder.setEncoding(column.getEncoding());
    builder.setType(column.getType());
    return builder.build();
  }

  com.google.api.services.bigquery.model.BigtableColumn toPb() {
    com.google.api.services.bigquery.model.BigtableColumn column =
        new com.google.api.services.bigquery.model.BigtableColumn()
            .setQualifierEncoded(getQualifierEncoded())
            .setFieldName(getFieldName())
            .setOnlyReadLatest(getOnlyReadLatest())
            .setEncoding(getEncoding())
            .setType(getType());
    return column;
  }

  static final Function<com.google.api.services.bigquery.model.BigtableColumn, BigtableColumn>
      FROM_PB_FUNCTION =
          new Function<com.google.api.services.bigquery.model.BigtableColumn, BigtableColumn>() {
            @Override
            public BigtableColumn apply(com.google.api.services.bigquery.model.BigtableColumn pb) {
              return BigtableColumn.fromPb(pb);
            }
          };

  static final Function<BigtableColumn, com.google.api.services.bigquery.model.BigtableColumn>
      TO_PB_FUNCTION =
          new Function<BigtableColumn, com.google.api.services.bigquery.model.BigtableColumn>() {
            @Override
            public com.google.api.services.bigquery.model.BigtableColumn apply(
                BigtableColumn column) {
              return column.toPb();
            }
          };
}
