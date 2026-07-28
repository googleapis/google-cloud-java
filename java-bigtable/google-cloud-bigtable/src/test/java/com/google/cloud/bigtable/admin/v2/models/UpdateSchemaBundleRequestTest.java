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

import static com.google.common.truth.Truth.assertThat;

import com.google.bigtable.admin.v2.ProtoSchema;
import com.google.cloud.bigtable.admin.v2.internal.NameUtil;
import com.google.protobuf.ByteString;
import com.google.protobuf.FieldMask;
import java.io.IOException;
import java.net.URISyntaxException;
import java.net.URL;
import java.nio.file.Files;
import java.nio.file.Paths;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;

@RunWith(JUnit4.class)
public class UpdateSchemaBundleRequestTest {
  private static final String PROJECT_ID = "my-project";
  private static final String INSTANCE_ID = "my-instance";
  private static final String TABLE_ID = "my-table";
  private static final String SCHEMA_BUNDLE_ID = "my-schema-bundle";
  // Location: `google-cloud-bigtable/src/test/resources/proto_schema_bundle.pb`
  private static final String TEST_PROTO_SCHEMA_BUNDLE = "proto_schema_bundle.pb";
  // Location: `google-cloud-bigtable/src/test/resources/updated_proto_schema_bundle.pb`
  private static final String TEST_UPDATED_PROTO_SCHEMA_BUNDLE = "updated_proto_schema_bundle.pb";

  @Test
  public void testToProto() throws IOException, URISyntaxException {
    UpdateSchemaBundleRequest request =
        UpdateSchemaBundleRequest.of(TABLE_ID, SCHEMA_BUNDLE_ID)
            .setProtoSchemaFile(getResourceFilePath(TEST_PROTO_SCHEMA_BUNDLE))
            .setIgnoreWarnings(true);
    byte[] content = Files.readAllBytes(Paths.get(getResourceFilePath(TEST_PROTO_SCHEMA_BUNDLE)));

    com.google.bigtable.admin.v2.UpdateSchemaBundleRequest requestProto =
        com.google.bigtable.admin.v2.UpdateSchemaBundleRequest.newBuilder()
            .setSchemaBundle(
                com.google.bigtable.admin.v2.SchemaBundle.newBuilder()
                    .setName(
                        NameUtil.formatSchemaBundleName(
                            PROJECT_ID, INSTANCE_ID, TABLE_ID, SCHEMA_BUNDLE_ID))
                    .setProtoSchema(
                        com.google.bigtable.admin.v2.ProtoSchema.newBuilder()
                            .setProtoDescriptors(ByteString.copyFrom(content))
                            .build())
                    .build())
            .setUpdateMask(FieldMask.newBuilder().addPaths("proto_schema"))
            .setIgnoreWarnings(true)
            .build();
    assertThat(request.toProto(PROJECT_ID, INSTANCE_ID)).isEqualTo(requestProto);
  }

  @Test
  public void testUpdateProtoSchema() throws IOException, URISyntaxException {
    byte[] content = Files.readAllBytes(Paths.get(getResourceFilePath(TEST_PROTO_SCHEMA_BUNDLE)));
    byte[] updated_content =
        Files.readAllBytes(Paths.get(getResourceFilePath(TEST_UPDATED_PROTO_SCHEMA_BUNDLE)));

    com.google.bigtable.admin.v2.SchemaBundle existingSchemaBundle =
        com.google.bigtable.admin.v2.SchemaBundle.newBuilder()
            .setName(
                NameUtil.formatSchemaBundleName(
                    PROJECT_ID, INSTANCE_ID, TABLE_ID, SCHEMA_BUNDLE_ID))
            .setProtoSchema(
                com.google.bigtable.admin.v2.ProtoSchema.newBuilder()
                    .setProtoDescriptors(ByteString.copyFrom(content))
                    .build())
            .build();

    UpdateSchemaBundleRequest request =
        UpdateSchemaBundleRequest.of(SchemaBundle.fromProto(existingSchemaBundle))
            .setProtoSchemaFile(getResourceFilePath(TEST_UPDATED_PROTO_SCHEMA_BUNDLE));

    com.google.bigtable.admin.v2.UpdateSchemaBundleRequest requestProto =
        com.google.bigtable.admin.v2.UpdateSchemaBundleRequest.newBuilder()
            .setSchemaBundle(
                existingSchemaBundle.toBuilder()
                    .setProtoSchema(
                        ProtoSchema.newBuilder()
                            .setProtoDescriptors(ByteString.copyFrom(updated_content))))
            .setUpdateMask(FieldMask.newBuilder().addPaths("proto_schema"))
            .build();
    assertThat(request.toProto(PROJECT_ID, INSTANCE_ID)).isEqualTo(requestProto);
  }

  @Test
  public void testEquality() throws IOException, URISyntaxException {
    UpdateSchemaBundleRequest request =
        UpdateSchemaBundleRequest.of(TABLE_ID, SCHEMA_BUNDLE_ID)
            .setProtoSchemaFile(getResourceFilePath(TEST_PROTO_SCHEMA_BUNDLE));

    assertThat(request)
        .isEqualTo(
            UpdateSchemaBundleRequest.of(TABLE_ID, SCHEMA_BUNDLE_ID)
                .setProtoSchemaFile(getResourceFilePath(TEST_PROTO_SCHEMA_BUNDLE)));

    assertThat(request)
        .isNotEqualTo(
            UpdateSchemaBundleRequest.of(TABLE_ID, SCHEMA_BUNDLE_ID)
                .setProtoSchemaFile(getResourceFilePath(TEST_UPDATED_PROTO_SCHEMA_BUNDLE)));
  }

  @Test
  public void testHashCode() throws IOException, URISyntaxException {
    UpdateSchemaBundleRequest request =
        UpdateSchemaBundleRequest.of(TABLE_ID, SCHEMA_BUNDLE_ID)
            .setProtoSchemaFile(getResourceFilePath(TEST_PROTO_SCHEMA_BUNDLE));

    assertThat(request.hashCode())
        .isEqualTo(
            UpdateSchemaBundleRequest.of(TABLE_ID, SCHEMA_BUNDLE_ID)
                .setProtoSchemaFile(getResourceFilePath(TEST_PROTO_SCHEMA_BUNDLE))
                .hashCode());

    assertThat(request.hashCode())
        .isNotEqualTo(
            UpdateSchemaBundleRequest.of(TABLE_ID, SCHEMA_BUNDLE_ID)
                .setProtoSchemaFile(getResourceFilePath(TEST_UPDATED_PROTO_SCHEMA_BUNDLE))
                .hashCode());
  }

  private String getResourceFilePath(String filePath) throws URISyntaxException {
    ClassLoader cl = Thread.currentThread().getContextClassLoader();
    URL protoSchema = cl.getResource(filePath);
    return Paths.get(protoSchema.toURI()).toAbsolutePath().toString();
  }
}
