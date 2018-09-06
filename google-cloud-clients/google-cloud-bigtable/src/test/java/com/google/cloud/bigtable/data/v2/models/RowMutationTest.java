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

import static com.google.common.truth.Truth.assertThat;

import com.google.bigtable.v2.MutateRowRequest;
import com.google.bigtable.v2.MutateRowsRequest;
import com.google.bigtable.v2.TableName;
import com.google.cloud.bigtable.data.v2.internal.RequestContext;
import com.google.protobuf.ByteString;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;

@RunWith(JUnit4.class)
public class RowMutationTest {
  private static final InstanceName INSTANCE_NAME =
      InstanceName.of("fake-project", "fake-instance");
  private static final String APP_PROFILE_ID = "fake-profile";
  private static final RequestContext REQUEST_CONTEXT =
      RequestContext.create(INSTANCE_NAME, APP_PROFILE_ID);
  private static final String TABLE_ID = "fake-table";
  private static final ByteString ROW_KEY = ByteString.copyFromUtf8("fake-key");
  private static final String FAMILY_NAME = "fake-family";
  private static final ByteString QUALIFIER = ByteString.copyFromUtf8("fake-qualifier");
  private static final ByteString VALUE = ByteString.copyFromUtf8("fake-value");
  private static final String TABLE_NAME = TableName
      .of(INSTANCE_NAME.getProject(), INSTANCE_NAME.getInstance(), "fake-table")
      .toString();
  private static final long TIMESTAMP = System.currentTimeMillis() * 1_000;

  @Test
  public void toProtoTest() {
    RowMutation rowMutation =
        RowMutation.create(TABLE_ID, ROW_KEY)
            .setCell(FAMILY_NAME, QUALIFIER, TIMESTAMP, VALUE);

    MutateRowRequest actualRowMutation = rowMutation.toProto(REQUEST_CONTEXT);

    assertThat(actualRowMutation).isEqualTo(createMutateRowRequest());
  }

  @Test
  public void toBulkProtoTest() {
    RowMutation rowMutation =
        RowMutation.create(TABLE_ID, ROW_KEY)
            .setCell(FAMILY_NAME, QUALIFIER, TIMESTAMP, VALUE);

    MutateRowsRequest actualRowMutation = rowMutation.toBulkProto(REQUEST_CONTEXT);

    assertThat(actualRowMutation).isEqualTo(createMutateRowsRequest());
  }

  @Test
  public void toProtoTestWithProvidedMutation() {
    Mutation mutation = Mutation.create().setCell(FAMILY_NAME, QUALIFIER, TIMESTAMP, VALUE);
    RowMutation rowMutation = RowMutation.create(TABLE_ID, ROW_KEY, mutation);

    MutateRowRequest actualRowMutation = rowMutation.toProto(REQUEST_CONTEXT);

    assertThat(actualRowMutation).isEqualTo(createMutateRowRequest());
  }

  @Test
  public void serializationTest() throws IOException, ClassNotFoundException {
    RowMutation expected =
        RowMutation.create(TABLE_ID, ROW_KEY)
            .setCell(FAMILY_NAME, QUALIFIER, TIMESTAMP, VALUE);

    ByteArrayOutputStream bos = new ByteArrayOutputStream();
    ObjectOutputStream oos = new ObjectOutputStream(bos);
    oos.writeObject(expected);
    oos.close();

    ObjectInputStream ois = new ObjectInputStream(new ByteArrayInputStream(bos.toByteArray()));

    RowMutation actual = (RowMutation) ois.readObject();
    assertThat(actual.toProto(REQUEST_CONTEXT)).isEqualTo(expected.toProto(REQUEST_CONTEXT));
  }

  private static com.google.bigtable.v2.Mutation.SetCell createSetCell() {
    return com.google.bigtable.v2.Mutation.SetCell.newBuilder()
        .setFamilyName(FAMILY_NAME)
        .setColumnQualifier(QUALIFIER)
        .setValue(VALUE)
        .setTimestampMicros(TIMESTAMP)
        .build();
  }

  private static com.google.bigtable.v2.Mutation createSetCellMutation() {
    return com.google.bigtable.v2.Mutation.newBuilder()
        .setSetCell(createSetCell())
        .build();
  }

  private static MutateRowRequest createMutateRowRequest() {
    return MutateRowRequest.newBuilder()
        .addMutations(createSetCellMutation())
        .setAppProfileId(APP_PROFILE_ID)
        .setTableName(TABLE_NAME)
        .setRowKey(ROW_KEY)
        .build();
  }

  private static MutateRowsRequest.Entry createEntry() {
    return MutateRowsRequest.Entry.newBuilder()
        .addMutations(createSetCellMutation())
        .setRowKey(ROW_KEY)
        .build();
  }

  private static MutateRowsRequest createMutateRowsRequest() {
    return MutateRowsRequest.newBuilder()
        .addEntries(createEntry())
        .setAppProfileId(APP_PROFILE_ID)
        .setTableName(TABLE_NAME)
        .build();
  }
}
