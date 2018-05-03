/*
 * Copyright 2018 Google LLC
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
package com.google.cloud.bigtable.data.v2.models;

import com.google.api.core.InternalApi;
import com.google.bigtable.v2.ReadModifyWriteRowRequest;
import com.google.bigtable.v2.ReadModifyWriteRule;
import com.google.bigtable.v2.TableName;
import com.google.cloud.bigtable.data.v2.internal.RequestContext;
import com.google.common.base.Preconditions;
import com.google.protobuf.ByteString;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import javax.annotation.Nonnull;

/** Wraps a {@link ReadModifyWriteRowRequest}. */
public final class ReadModifyWriteRow implements Serializable {
  private static final long serialVersionUID = -8150045424541029193L;

  private final String tableId;
  private transient ReadModifyWriteRowRequest.Builder builder =
      ReadModifyWriteRowRequest.newBuilder();

  private ReadModifyWriteRow(@Nonnull String tableId, @Nonnull ByteString key) {
    Preconditions.checkNotNull(tableId, "tableId can't be null.");
    Preconditions.checkNotNull(key, "key can't be null.");
    this.tableId = tableId;

    builder.setRowKey(key);
  }

  public static ReadModifyWriteRow create(@Nonnull String tableId, @Nonnull String key) {
    Preconditions.checkNotNull(key, "key can't be null.");
    return new ReadModifyWriteRow(tableId, ByteString.copyFromUtf8(key));
  }

  public static ReadModifyWriteRow create(@Nonnull String tableId, @Nonnull ByteString key) {
    return new ReadModifyWriteRow(tableId, key);
  }

  private void readObject(ObjectInputStream input) throws IOException, ClassNotFoundException {
    input.defaultReadObject();
    builder = ReadModifyWriteRowRequest.newBuilder().mergeFrom(input);
  }

  private void writeObject(ObjectOutputStream output) throws IOException {
    output.defaultWriteObject();
    builder.build().writeTo(output);
  }

  /**
   * Appends the value to the existing value of the cell. If the targeted cell is unset, it will be
   * treated as containing the empty string.
   */
  public ReadModifyWriteRow append(
      @Nonnull String familyName, @Nonnull String qualifier, @Nonnull String value) {
    return append(familyName, ByteString.copyFromUtf8(qualifier), ByteString.copyFromUtf8(value));
  }

  /**
   * Appends the value to the existing value of the cell. If the targeted cell is unset, it will be
   * treated as containing the empty string.
   */
  public ReadModifyWriteRow append(
      @Nonnull String familyName, @Nonnull ByteString qualifier, @Nonnull ByteString value) {
    Validations.validateFamily(familyName);
    Preconditions.checkNotNull(qualifier, "Qualifier can't be null");
    Preconditions.checkNotNull(value, "Value can't be null");
    Preconditions.checkArgument(!value.isEmpty(), "Value can't be empty");

    ReadModifyWriteRule rule =
        ReadModifyWriteRule.newBuilder()
            .setFamilyName(familyName)
            .setColumnQualifier(qualifier)
            .setAppendValue(value)
            .build();

    builder.addRules(rule);

    return this;
  }

  /**
   * Adds `amount` be added to the existing value. If the targeted cell is unset, it will be treated
   * as containing a zero. Otherwise, the targeted cell must contain an 8-byte value (interpreted as
   * a 64-bit big-endian signed integer), or the entire request will fail.
   */
  public ReadModifyWriteRow increment(
      @Nonnull String familyName, @Nonnull String qualifier, long amount) {
    return increment(familyName, ByteString.copyFromUtf8(qualifier), amount);
  }

  /**
   * Adds `amount` be added to the existing value. If the targeted cell is unset, it will be treated
   * as containing a zero. Otherwise, the targeted cell must contain an 8-byte value (interpreted as
   * a 64-bit big-endian signed integer), or the entire request will fail.
   */
  public ReadModifyWriteRow increment(
      @Nonnull String familyName, @Nonnull ByteString qualifier, long amount) {
    Validations.validateFamily(familyName);
    Preconditions.checkNotNull(qualifier, "Qualifier can't be null");

    ReadModifyWriteRule rule =
        ReadModifyWriteRule.newBuilder()
            .setFamilyName(familyName)
            .setColumnQualifier(qualifier)
            .setIncrementAmount(amount)
            .build();

    builder.addRules(rule);
    return this;
  }

  @InternalApi
  public ReadModifyWriteRowRequest toProto(RequestContext requestContext) {
    TableName tableName =
        TableName.of(
            requestContext.getInstanceName().getProject(),
            requestContext.getInstanceName().getInstance(),
            tableId);
    return builder
        .setTableName(tableName.toString())
        .setAppProfileId(requestContext.getAppProfileId())
        .build();
  }
}
