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
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import javax.annotation.Nonnull;

/**
 * Parameters for creating a new Cloud Bigtable {@link SchemaBundle}, which represents subsets of a
 * particular table.
 *
 * <p>Sample code:
 *
 * <pre>{@code
 * CreateSchemaBundleRequest request =
 *     CreateSchemaBundleRequest.of("my-table", "my-new-schema-bundle")
 *         .setProtoSchemaFile("proto_file.pb");
 * }</pre>
 *
 * @see SchemaBundle for more details.
 */
public final class CreateSchemaBundleRequest {
  private final String tableId;
  private final com.google.bigtable.admin.v2.CreateSchemaBundleRequest.Builder requestBuilder =
      com.google.bigtable.admin.v2.CreateSchemaBundleRequest.newBuilder();

  public static CreateSchemaBundleRequest of(
      @Nonnull String tableId, @Nonnull String schemaBundleId) {
    return new CreateSchemaBundleRequest(tableId, schemaBundleId);
  }

  private CreateSchemaBundleRequest(@Nonnull String tableId, @Nonnull String schemaBundleId) {
    Preconditions.checkNotNull(tableId, "tableId must be set");
    Preconditions.checkNotNull(schemaBundleId, "schemaBundleId must be set");

    this.tableId = tableId;
    requestBuilder.setSchemaBundleId(schemaBundleId);
  }

  /** Sets the proto schema for this schema bundle. */
  public CreateSchemaBundleRequest setProtoSchemaFile(@Nonnull String protoSchemaFile)
      throws IOException {
    Preconditions.checkNotNull(protoSchemaFile, "protoSchemaFile must be set");
    byte[] content = Files.readAllBytes(Paths.get(protoSchemaFile));
    return setProtoSchema(ByteString.copyFrom(content));
  }

  /** Sets the proto schema for this schema bundle. */
  public CreateSchemaBundleRequest setProtoSchema(@Nonnull ByteString protoSchema) {
    Preconditions.checkNotNull(protoSchema, "protoSchema must be set");
    requestBuilder.setSchemaBundle(
        com.google.bigtable.admin.v2.SchemaBundle.newBuilder()
            .setProtoSchema(ProtoSchema.newBuilder().setProtoDescriptors(protoSchema)));
    return this;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    CreateSchemaBundleRequest that = (CreateSchemaBundleRequest) o;
    return Objects.equal(requestBuilder.build(), that.requestBuilder.build())
        && Objects.equal(tableId, that.tableId);
  }

  @Override
  public int hashCode() {
    return Objects.hashCode(requestBuilder.build(), tableId);
  }

  /**
   * Creates the request protobuf. This method is considered an internal implementation detail and
   * not meant to be used by applications.
   */
  @InternalApi
  public com.google.bigtable.admin.v2.CreateSchemaBundleRequest toProto(
      @Nonnull String projectId, @Nonnull String instanceId) {
    return requestBuilder
        .setParent(NameUtil.formatTableName(projectId, instanceId, tableId))
        .build();
  }
}
