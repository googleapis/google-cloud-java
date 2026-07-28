/*
 * Copyright 2024 Google LLC
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *    https://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package com.google.cloud.bigtable.data.v2.internal;

import com.google.api.core.InternalApi;
import com.google.auto.value.AutoValue;
import com.google.bigtable.v2.ArrayValue;
import com.google.bigtable.v2.Value;
import com.google.cloud.bigtable.data.v2.models.sql.SqlType;
import com.google.cloud.bigtable.data.v2.models.sql.Struct;
import java.util.List;

/**
 * Implementation of a {@link Struct} backed by protobuf {@link Value}s.
 *
 * <p>This is considered an internal implementation detail and not meant to be used by applications.
 */
@InternalApi("For internal use only")
@AutoValue
public abstract class ProtoStruct extends AbstractProtoStructReader implements Struct {

  @InternalApi
  static ProtoStruct create(SqlType.Struct type, ArrayValue fieldValues) {
    return new AutoValue_ProtoStruct(type, fieldValues);
  }

  protected abstract SqlType.Struct type();

  protected abstract ArrayValue fieldValues();

  @Override
  List<Value> values() {
    return fieldValues().getValuesList();
  }

  @Override
  public int getColumnIndex(String columnName) {
    return type().getColumnIndex(columnName);
  }

  @Override
  public SqlType<?> getColumnType(int columnIndex) {
    return type().getType(columnIndex);
  }
}
