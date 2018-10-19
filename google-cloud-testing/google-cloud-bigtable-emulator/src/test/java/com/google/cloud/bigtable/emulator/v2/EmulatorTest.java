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

import com.google.api.gax.core.NoCredentialsProvider;
import com.google.api.gax.grpc.GrpcTransportChannel;
import com.google.api.gax.rpc.FixedTransportChannelProvider;
import com.google.bigtable.admin.v2.InstanceName;
import com.google.cloud.bigtable.admin.v2.BigtableTableAdminClient;
import com.google.cloud.bigtable.admin.v2.BigtableTableAdminSettings;
import com.google.cloud.bigtable.admin.v2.models.CreateTableRequest;
import com.google.cloud.bigtable.admin.v2.models.Table;
import com.google.cloud.bigtable.data.v2.BigtableDataClient;
import com.google.cloud.bigtable.data.v2.BigtableDataSettings;
import com.google.cloud.bigtable.data.v2.models.Row;
import com.google.cloud.bigtable.data.v2.models.RowMutation;
import com.google.protobuf.ByteString;
import java.io.IOException;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;

@RunWith(JUnit4.class)
public class EmulatorTest {

  private Emulator emulator;
  private BigtableTableAdminClient tableAdminClient;
  private BigtableDataClient dataClient;


  @Before
  public void setUp() throws Exception {
    emulator = Emulator.createBundled();
    emulator.start();
    tableAdminClient = createTableAdminClient();
    dataClient = createDataClient();
  }

  @After
  public void tearDown() throws Exception {
    tableAdminClient.close();
    dataClient.close();
    emulator.stop();
    emulator = null;
  }

  private BigtableTableAdminClient createTableAdminClient() throws IOException {
    BigtableTableAdminSettings.Builder settingsBuilder = BigtableTableAdminSettings.newBuilder()
        .setInstanceName(InstanceName.of("fake-project", "fake-instance"));

    settingsBuilder.stubSettings()
        .setTransportChannelProvider(
            FixedTransportChannelProvider.create(
                GrpcTransportChannel.create(emulator.getAdminChannel())
            )
        )
        .setCredentialsProvider(NoCredentialsProvider.create());

    BigtableTableAdminSettings settings = settingsBuilder.build();

    return BigtableTableAdminClient.create(settings);
  }

  private BigtableDataClient createDataClient() throws IOException {
    BigtableDataSettings.Builder settingsBuilder = BigtableDataSettings.newBuilder()
        .setInstanceName(com.google.cloud.bigtable.data.v2.models.InstanceName
            .of("fake-project", "fake-instance"));

    settingsBuilder
        .setTransportChannelProvider(
            FixedTransportChannelProvider.create(
                GrpcTransportChannel.create(emulator.getAdminChannel())
            )
        )
        .setCredentialsProvider(NoCredentialsProvider.create());

    BigtableDataSettings settings = settingsBuilder.build();

    return BigtableDataClient.create(settings);
  }

  @Test
  public void testTableAdminClient() {
    Table table = tableAdminClient.createTable(
        CreateTableRequest.of("fake-table")
    );

    assertThat(table.getId()).isEqualTo("fake-table");
  }

  @Test
  public void testDataClient() throws Exception {
    tableAdminClient.createTable(
        CreateTableRequest.of("fake-table")
            .addFamily("cf")
    );

    dataClient.mutateRowCallable().call(
        RowMutation.create("fake-table", "test")
            .setCell("cf", "qualifier", "value")
    );

    Row row = dataClient.readRowAsync("fake-table", "test").get();
    assertThat(row.getCells().get(0).getValue()).isEqualTo(ByteString.copyFromUtf8("value"));
  }

}
