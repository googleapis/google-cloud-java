/*
 * Copyright 2024 Google LLC
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     https://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package com.google.cloud.bigtable.data.v2.internal;

import com.google.api.core.InternalApi;
import com.google.bigtable.v2.ProtoSchema;
import com.google.bigtable.v2.ResultSetMetadata.SchemaCase;
import com.google.bigtable.v2.Type;
import com.google.cloud.bigtable.data.v2.models.sql.ColumnMetadata;
import com.google.cloud.bigtable.data.v2.models.sql.ResultSetMetadata;
import com.google.cloud.bigtable.data.v2.models.sql.SqlType;
import com.google.common.base.Objects;
import com.google.common.base.Preconditions;
import com.google.common.collect.ImmutableList;
import java.util.List;
import javax.annotation.Nullable;

/**
 * Implementation of {@link ResultSetMetadata} using an underlying protobuf schema.
 *
 * <p>This is considered an internal implementation detail and not meant to be used by applications.
 */
@InternalApi
public class ProtoResultSetMetadata extends ColumnToIndexMapper implements ResultSetMetadata {
  private final List<ColumnMetadata> columns;

  public static ResultSetMetadata create(List<ColumnMetadata> columns) {
    return new ProtoResultSetMetadata(columns);
  }

  private ProtoResultSetMetadata(List<ColumnMetadata> columns) {
    super(columns);
    this.columns = ImmutableList.copyOf(columns);
  }

  @Override
  public List<ColumnMetadata> getColumns() {
    return columns;
  }

  @Override
  public SqlType<?> getColumnType(int columnIndex) {
    return columns.get(columnIndex).type();
  }

  @Override
  public SqlType<?> getColumnType(String columnName) {
    return getColumnType(getColumnIndex(columnName));
  }

  @InternalApi
  public static ResultSetMetadata fromProto(com.google.bigtable.v2.ResultSetMetadata proto) {
    Preconditions.checkState(
        proto.getSchemaCase().equals(SchemaCase.PROTO_SCHEMA),
        "Unsupported schema type: %s",
        proto.getSchemaCase().name());
    ProtoSchema schema = proto.getProtoSchema();
    validateSchema(schema);
    ImmutableList.Builder<ColumnMetadata> columnsBuilder = ImmutableList.builder();
    for (com.google.bigtable.v2.ColumnMetadata protoColumn : schema.getColumnsList()) {
      columnsBuilder.add(ColumnMetadataImpl.fromProto(protoColumn));
    }
    return create(columnsBuilder.build());
  }

  private static void validateSchema(ProtoSchema schema) {
    List<com.google.bigtable.v2.ColumnMetadata> columns = schema.getColumnsList();
    Preconditions.checkState(!columns.isEmpty(), "columns cannot be empty");
    for (com.google.bigtable.v2.ColumnMetadata column : columns) {
      Preconditions.checkState(
          column.getType().getKindCase() != Type.KindCase.KIND_NOT_SET,
          "Column type cannot be empty");
    }
  }

  @Override
  public boolean equals(@Nullable Object other) {
    if (other instanceof ProtoResultSetMetadata) {
      ProtoResultSetMetadata o = (ProtoResultSetMetadata) other;
      // columnNameMapping is derived from columns, so we only need to compare columns
      return columns.equals(o.columns);
    }
    return false;
  }

  @Override
  public int hashCode() {
    return Objects.hashCode(columns);
  }
}
