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
package com.google.cloud.bigtable.emulator.v2;

import static com.google.common.truth.Truth.assertThat;

import com.google.bigtable.admin.v2.BigtableTableAdminGrpc;
import com.google.bigtable.admin.v2.BigtableTableAdminGrpc.BigtableTableAdminBlockingStub;
import com.google.bigtable.admin.v2.ColumnFamily;
import com.google.bigtable.admin.v2.CreateTableRequest;
import com.google.bigtable.admin.v2.Table;
import com.google.bigtable.v2.BigtableGrpc;
import com.google.bigtable.v2.BigtableGrpc.BigtableBlockingStub;
import com.google.bigtable.v2.MutateRowRequest;
import com.google.bigtable.v2.Mutation;
import com.google.bigtable.v2.Mutation.SetCell;
import com.google.bigtable.v2.ReadRowsRequest;
import com.google.bigtable.v2.ReadRowsResponse;
import com.google.protobuf.ByteString;
import java.util.Iterator;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;

@RunWith(JUnit4.class)
public class EmulatorTest {

  private Emulator emulator;
  private BigtableTableAdminBlockingStub tableAdminStub;
  private BigtableBlockingStub dataStub;


  @Before
  public void setUp() throws Exception {
    emulator = Emulator.createBundled();
    emulator.start();
    tableAdminStub = BigtableTableAdminGrpc.newBlockingStub(emulator.getAdminChannel());
    dataStub = BigtableGrpc.newBlockingStub(emulator.getDataChannel());
  }

  @After
  public void tearDown() {
    emulator.stop();
    emulator = null;
  }

  @Test
  public void testTableAdminClient() {
    Table table = tableAdminStub.createTable(
        CreateTableRequest.newBuilder()
            .setParent("projects/fake-project/instances/fake-instance")
            .setTableId("fake-table")
            .setTable(
                Table.newBuilder()
                    .putColumnFamilies("cf", ColumnFamily.getDefaultInstance())
            )
            .build()
    );

    assertThat(table.getName())
        .isEqualTo("projects/fake-project/instances/fake-instance/tables/fake-table");
  }

  @Test
  public void testDataClient() {
    tableAdminStub.createTable(
        CreateTableRequest.newBuilder()
            .setParent("projects/fake-project/instances/fake-instance")
            .setTableId("fake-table")
            .setTable(
                Table.newBuilder()
                    .putColumnFamilies("cf", ColumnFamily.getDefaultInstance())
            )
            .build()
    );

    dataStub.mutateRow(
        MutateRowRequest.newBuilder()
            .setTableName("projects/fake-project/instances/fake-instance/tables/fake-table")
            .setRowKey(ByteString.copyFromUtf8("fake-key"))
            .addMutations(
                Mutation.newBuilder().setSetCell(
                    SetCell.newBuilder()
                      .setFamilyName("cf")
                      .setColumnQualifier(ByteString.EMPTY)
                      .setValue(ByteString.copyFromUtf8("value"))
                )
            )
            .build()
    );

    Iterator<ReadRowsResponse> results = dataStub.readRows(
        ReadRowsRequest.newBuilder()
            .setTableName("projects/fake-project/instances/fake-instance/tables/fake-table")
            .build()
    );

    ReadRowsResponse row = results.next();
    assertThat(row.getChunks(0).getValue()).isEqualTo(ByteString.copyFromUtf8("value"));
  }
}
