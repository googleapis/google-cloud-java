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

package com.google.cloud.bigquery;

import static com.google.common.base.Preconditions.checkNotNull;

import com.google.api.services.bigquery.model.TableSchema;
import com.google.common.base.Function;
import com.google.common.base.MoreObjects;

import java.io.Serializable;
import java.util.Objects;

/**
 * This class represents the schema for a Google BigQuery Table or data source.
 */
public final class Schema implements Serializable {

  static final Function<com.google.api.services.bigquery.model.TableSchema, Schema>
      FROM_PB_FUNCTION = new Function<com.google.api.services.bigquery.model.TableSchema,
          Schema>() {
            @Override
            public Schema apply(com.google.api.services.bigquery.model.TableSchema pb) {
              return Schema.fromPb(pb);
            }
          };
  static final Function<Schema, com.google.api.services.bigquery.model.TableSchema>
      TO_PB_FUNCTION = new Function<Schema,
          com.google.api.services.bigquery.model.TableSchema>() {
            @Override
            public com.google.api.services.bigquery.model.TableSchema apply(Schema schema) {
              return schema.toPb();
            }
          };

  private static final long serialVersionUID = 5522743613515073017L;

  private final FieldList fields;

  private Schema(FieldList fields) {
    this.fields = checkNotNull(fields);
  }

  /**
   * Returns the fields in the current table schema.
   */
  public FieldList getFields() {
    return fields;
  }

  @Override
  public String toString() {
    return MoreObjects.toStringHelper(this)
        .add("fields", fields)
        .toString();
  }

  @Override
  public int hashCode() {
    return Objects.hash(fields);
  }

  @Override
  public boolean equals(Object obj) {
    return obj == this
        || obj instanceof Schema
        && Objects.equals(toPb(), ((Schema) obj).toPb());
  }

  /**
   * Creates a {@code Schema} object given a list of fields.
   */
  public static Schema of(Iterable<Field> fields) {
    return new Schema(FieldList.of(fields));
  }

  /**
   * Creates a {@code Schema} object given some fields.
   */
  public static Schema of(Field... fields) {
    return new Schema(FieldList.of(fields));
  }

  TableSchema toPb() {
      TableSchema tableSchemaPb = new TableSchema();
    if (fields != null) {
      tableSchemaPb.setFields(fields.toPb());
    }
    return tableSchemaPb;
  }

  static Schema fromPb(com.google.api.services.bigquery.model.TableSchema tableSchemaPb) {
    return Schema.of(FieldList.fromPb(tableSchemaPb.getFields()));
  }
}
