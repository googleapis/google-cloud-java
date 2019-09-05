/*
 * Copyright 2019 Google LLC
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

import com.google.bigtable.v2.MutateRowsRequest;
import com.google.bigtable.v2.Mutation;
import com.google.common.collect.ImmutableList;
import com.google.protobuf.ByteString;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.List;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;

@RunWith(JUnit4.class)
public class RowMutationEntryTest {

  @Test
  public void serializationTest() throws IOException, ClassNotFoundException {
    long timestamp = 10_000L;
    RowMutationEntry underTest =
        RowMutationEntry.create("row-key")
            .setCell("fake-family", "qualifier-1", timestamp, "fake-values");
    ByteArrayOutputStream bos = new ByteArrayOutputStream();
    ObjectOutputStream oos = new ObjectOutputStream(bos);
    oos.writeObject(underTest);
    oos.close();

    ObjectInputStream ois = new ObjectInputStream(new ByteArrayInputStream(bos.toByteArray()));

    RowMutationEntry actual = (RowMutationEntry) ois.readObject();
    assertThat(actual.toProto()).isEqualTo(underTest.toProto());
  }

  @Test
  public void toProtoTest() {
    long timestamp = 10_000L;
    ByteString rowKey = ByteString.copyFromUtf8("row-key");
    RowMutationEntry underTest =
        RowMutationEntry.create(rowKey)
            .setCell("fake-family", "qualifier-1", timestamp, "fake-values");
    MutateRowsRequest.Entry entry = underTest.toProto();
    assertThat(entry)
        .isEqualTo(
            MutateRowsRequest.Entry.newBuilder()
                .setRowKey(rowKey)
                .addMutations(
                    Mutation.newBuilder()
                        .setSetCell(
                            Mutation.SetCell.newBuilder()
                                .setFamilyName("fake-family")
                                .setColumnQualifier(ByteString.copyFromUtf8("qualifier-1"))
                                .setTimestampMicros(timestamp)
                                .setValue(ByteString.copyFromUtf8("fake-values"))))
                .build());
  }

  @Test
  public void multipleMutationTest() {
    RowMutationEntry rowEntry =
        RowMutationEntry.create("row-key")
            .setCell("family-1", "qualifier-1", 10_000L, "fake-values")
            .deleteCells("family-2", "qualifier-2")
            .deleteFamily("family-3");

    List<Mutation> mutationList =
        ImmutableList.of(
            Mutation.newBuilder()
                .setSetCell(
                    Mutation.SetCell.newBuilder()
                        .setFamilyName("family-1")
                        .setColumnQualifier(ByteString.copyFromUtf8("qualifier-1"))
                        .setTimestampMicros(10_000L)
                        .setValue(ByteString.copyFromUtf8("fake-values")))
                .build(),
            Mutation.newBuilder()
                .setDeleteFromColumn(
                    Mutation.DeleteFromColumn.newBuilder()
                        .setFamilyName("family-2")
                        .setColumnQualifier(ByteString.copyFromUtf8("qualifier-2")))
                .build(),
            Mutation.newBuilder()
                .setDeleteFromFamily(
                    Mutation.DeleteFromFamily.newBuilder().setFamilyName("family-3"))
                .build());

    assertThat(rowEntry.toProto().getMutationsList()).isEqualTo(mutationList);

    rowEntry = RowMutationEntry.create("row-key").deleteRow();
    assertThat(rowEntry.toProto().getMutationsList()).hasSize(1);
    assertThat(rowEntry.toProto().getMutationsList().get(0))
        .isEqualTo(
            Mutation.newBuilder()
                .setDeleteFromRow(Mutation.DeleteFromRow.newBuilder().build())
                .build());
  }

  @Test
  public void unsafeMutationTest() {
    ByteString rowKey = ByteString.copyFromUtf8("row-key");
    RowMutationEntry rowMutationEntry =
        RowMutationEntry.createUnsafe(rowKey)
            .setCell("family-1", "qualifier-1", 10_000L, "fake-values")
            .deleteFamily("family-2");

    MutateRowsRequest.Entry entry = rowMutationEntry.toProto();
    assertThat(entry.getMutationsCount()).isEqualTo(2);
    assertThat(entry.getMutationsList())
        .isEqualTo(
            ImmutableList.of(
                Mutation.newBuilder()
                    .setSetCell(
                        Mutation.SetCell.newBuilder()
                            .setFamilyName("family-1")
                            .setColumnQualifier(ByteString.copyFromUtf8("qualifier-1"))
                            .setTimestampMicros(10_000L)
                            .setValue(ByteString.copyFromUtf8("fake-values")))
                    .build(),
                Mutation.newBuilder()
                    .setDeleteFromFamily(
                        Mutation.DeleteFromFamily.newBuilder().setFamilyName("family-2"))
                    .build()));
  }
}
