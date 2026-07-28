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

package com.google.cloud.bigtable.admin.v2.models;

import com.google.api.core.InternalApi;
import com.google.bigtable.admin.v2.ProtoSchema;
import com.google.cloud.bigtable.admin.v2.internal.NameUtil;
import com.google.common.base.Objects;
import com.google.common.base.Preconditions;
import com.google.protobuf.ByteString;
import com.google.protobuf.FieldMask;
import com.google.protobuf.util.FieldMaskUtil;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import javax.annotation.Nonnull;

/**
 * Parameters for updating an existing Cloud Bigtable {@link SchemaBundle}.
 *
 * <p>Sample code:
 *
 * <pre>{@code
 * SchemaBundle existingSchemaBundle = client.getSchemaBundle("my-table", "my-schema-bundle");
 * UpdateSchemaBundleRequest request =
 *     UpdateSchemaBundleRequest.of(existingSchemaBundle).setProtoSchemaFile("file.pb");
 * }</pre>
 *
 * @see SchemaBundle for more details.
 */
public final class UpdateSchemaBundleRequest {
  private final com.google.bigtable.admin.v2.UpdateSchemaBundleRequest.Builder requestBuilder;
  private final String tableId;
  private final String schemaBundleId;

  /** Builds a new update request using an existing schema bundle. */
  public static UpdateSchemaBundleRequest of(@Nonnull SchemaBundle schemaBundle) {
    return new UpdateSchemaBundleRequest(
        schemaBundle.getTableId(),
        schemaBundle.getId(),
        com.google.bigtable.admin.v2.UpdateSchemaBundleRequest.newBuilder()
            .setSchemaBundle(schemaBundle.toProto()));
  }

  /** Builds a new update schema bundle request. */
  public static UpdateSchemaBundleRequest of(
      @Nonnull String tableId, @Nonnull String schemaBundleId) {
    return new UpdateSchemaBundleRequest(
        tableId,
        schemaBundleId,
        com.google.bigtable.admin.v2.UpdateSchemaBundleRequest.newBuilder());
  }

  private UpdateSchemaBundleRequest(
      @Nonnull String tableId,
      @Nonnull String schemaBundleId,
      @Nonnull com.google.bigtable.admin.v2.UpdateSchemaBundleRequest.Builder requestBuilder) {
    Preconditions.checkNotNull(tableId, "tableId must be set");
    Preconditions.checkNotNull(schemaBundleId, "schemaBundleId must be set");
    Preconditions.checkNotNull(requestBuilder, "proto builder must be set");

    this.tableId = tableId;
    this.schemaBundleId = schemaBundleId;
    this.requestBuilder = requestBuilder;
  }

  /** Sets the proto schema for this schema bundle. */
  public UpdateSchemaBundleRequest setProtoSchemaFile(@Nonnull String protoSchemaFile)
      throws IOException {
    Preconditions.checkNotNull(protoSchemaFile, "protoSchemaFile must be set");
    byte[] content = Files.readAllBytes(Paths.get(protoSchemaFile));
    return setProtoSchema(ByteString.copyFrom(content));
  }

  /** Sets the proto schema for this schema bundle. */
  public UpdateSchemaBundleRequest setProtoSchema(@Nonnull ByteString protoSchema)
      throws IOException {
    Preconditions.checkNotNull(protoSchema, "protoSchema must be set");
    requestBuilder.setSchemaBundle(
        com.google.bigtable.admin.v2.SchemaBundle.newBuilder()
            .setProtoSchema(ProtoSchema.newBuilder().setProtoDescriptors(protoSchema)));
    updateFieldMask(com.google.bigtable.admin.v2.SchemaBundle.PROTO_SCHEMA_FIELD_NUMBER);
    return this;
  }

  /**
   * Configures if safety warnings should be disabled. If set, then non backwards compatible changes
   * are allowed.
   */
  @SuppressWarnings("WeakerAccess")
  public UpdateSchemaBundleRequest setIgnoreWarnings(boolean value) {
    requestBuilder.setIgnoreWarnings(value);
    return this;
  }

  private void updateFieldMask(int fieldNumber) {
    FieldMask newMask =
        FieldMaskUtil.fromFieldNumbers(
            com.google.bigtable.admin.v2.SchemaBundle.class, fieldNumber);
    requestBuilder.setUpdateMask(FieldMaskUtil.union(requestBuilder.getUpdateMask(), newMask));
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    UpdateSchemaBundleRequest that = (UpdateSchemaBundleRequest) o;
    return Objects.equal(requestBuilder.build(), that.requestBuilder.build())
        && Objects.equal(tableId, that.tableId)
        && Objects.equal(schemaBundleId, that.schemaBundleId);
  }

  @Override
  public int hashCode() {
    return Objects.hashCode(requestBuilder.build(), tableId, schemaBundleId);
  }

  /**
   * Creates the request protobuf. This method is considered an internal implementation detail and
   * not meant to be used by applications.
   */
  @InternalApi
  public com.google.bigtable.admin.v2.UpdateSchemaBundleRequest toProto(
      @Nonnull String projectId, @Nonnull String instanceId) {
    requestBuilder
        .getSchemaBundleBuilder()
        .setName(NameUtil.formatSchemaBundleName(projectId, instanceId, tableId, schemaBundleId));
    return requestBuilder.build();
  }
}
