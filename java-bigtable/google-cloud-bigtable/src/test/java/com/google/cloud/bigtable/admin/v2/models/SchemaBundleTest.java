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

import com.google.bigtable.admin.v2.SchemaBundleName;
import com.google.protobuf.ByteString;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;

@RunWith(JUnit4.class)
public class SchemaBundleTest {
  private static final String PROJECT_ID = "my-project";
  private static final String INSTANCE_ID = "my-instance";
  private static final String TABLE_ID = "my-table";
  private static final String SCHEMA_BUNDLE_ID = "my-schema-bundle";

  @Test
  public void testFromProto() {
    SchemaBundleName schemaBundleName =
        SchemaBundleName.of(PROJECT_ID, INSTANCE_ID, TABLE_ID, SCHEMA_BUNDLE_ID);

    com.google.bigtable.admin.v2.SchemaBundle schemaBundleProto =
        com.google.bigtable.admin.v2.SchemaBundle.newBuilder()
            .setName(schemaBundleName.toString())
            .setProtoSchema(
                com.google.bigtable.admin.v2.ProtoSchema.newBuilder()
                    .setProtoDescriptors(ByteString.copyFromUtf8("schema"))
                    .build())
            .build();

    SchemaBundle result = SchemaBundle.fromProto(schemaBundleProto);

    assertThat(result.getId()).isEqualTo(SCHEMA_BUNDLE_ID);
    assertThat(result.getTableId()).isEqualTo(TABLE_ID);
    assertThat(result.getProtoSchema()).isEqualTo(ByteString.copyFromUtf8("schema"));
  }

  @Test
  public void testRequiresName() {
    com.google.bigtable.admin.v2.SchemaBundle proto =
        com.google.bigtable.admin.v2.SchemaBundle.newBuilder()
            .setProtoSchema(
                com.google.bigtable.admin.v2.ProtoSchema.newBuilder()
                    .setProtoDescriptors(ByteString.copyFromUtf8("schema"))
                    .build())
            .build();
    Exception actualException = null;

    try {
      SchemaBundle.fromProto(proto);
    } catch (Exception e) {
      actualException = e;
    }

    assertThat(actualException).isInstanceOf(IllegalArgumentException.class);
  }

  @Test
  public void testRequiresSchemaBundleType() {
    SchemaBundleName schemaBundleName =
        SchemaBundleName.of(PROJECT_ID, INSTANCE_ID, TABLE_ID, SCHEMA_BUNDLE_ID);
    com.google.bigtable.admin.v2.SchemaBundle proto =
        com.google.bigtable.admin.v2.SchemaBundle.newBuilder()
            .setName(schemaBundleName.toString())
            .build();
    Exception actualException = null;

    try {
      SchemaBundle.fromProto(proto);
    } catch (Exception e) {
      actualException = e;
    }

    assertThat(actualException).isInstanceOf(IllegalArgumentException.class);
  }

  @Test
  public void testEquality() {
    SchemaBundleName schemaBundleName =
        SchemaBundleName.of(PROJECT_ID, INSTANCE_ID, TABLE_ID, SCHEMA_BUNDLE_ID);
    com.google.bigtable.admin.v2.SchemaBundle proto =
        com.google.bigtable.admin.v2.SchemaBundle.newBuilder()
            .setName(schemaBundleName.toString())
            .setProtoSchema(
                com.google.bigtable.admin.v2.ProtoSchema.newBuilder()
                    .setProtoDescriptors(ByteString.copyFromUtf8("schema"))
                    .build())
            .build();
    SchemaBundle schemaBundle = SchemaBundle.fromProto(proto);

    assertThat(schemaBundle).isEqualTo(SchemaBundle.fromProto(proto));

    assertThat(schemaBundle)
        .isNotEqualTo(
            com.google.bigtable.admin.v2.SchemaBundle.newBuilder()
                .setName(schemaBundleName.toString())
                .setProtoSchema(
                    com.google.bigtable.admin.v2.ProtoSchema.newBuilder()
                        .setProtoDescriptors(ByteString.copyFromUtf8("schema"))
                        .build())
                .build());
  }

  @Test
  public void testHashCode() {
    SchemaBundleName schemaBundleName =
        SchemaBundleName.of(PROJECT_ID, INSTANCE_ID, TABLE_ID, SCHEMA_BUNDLE_ID);
    com.google.bigtable.admin.v2.SchemaBundle proto =
        com.google.bigtable.admin.v2.SchemaBundle.newBuilder()
            .setName(schemaBundleName.toString())
            .setProtoSchema(
                com.google.bigtable.admin.v2.ProtoSchema.newBuilder()
                    .setProtoDescriptors(ByteString.copyFromUtf8("schema"))
                    .build())
            .build();
    SchemaBundle schemaBundle = SchemaBundle.fromProto(proto);

    assertThat(schemaBundle.hashCode()).isEqualTo(SchemaBundle.fromProto(proto).hashCode());

    assertThat(schemaBundle.hashCode())
        .isNotEqualTo(
            com.google.bigtable.admin.v2.SchemaBundle.newBuilder()
                .setName(schemaBundleName.toString())
                .setProtoSchema(
                    com.google.bigtable.admin.v2.ProtoSchema.newBuilder()
                        .setProtoDescriptors(ByteString.copyFromUtf8("schema"))
                        .build())
                .build()
                .hashCode());
  }
}
