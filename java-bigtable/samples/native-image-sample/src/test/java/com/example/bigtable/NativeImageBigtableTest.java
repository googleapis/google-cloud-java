/*
 * Copyright 2022 Google LLC
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

package com.example.bigtable;

import static com.google.common.truth.Truth.assertThat;

import com.google.cloud.ServiceOptions;
import com.google.cloud.bigtable.admin.v2.BigtableInstanceAdminClient;
import com.google.cloud.bigtable.admin.v2.BigtableInstanceAdminSettings;
import com.google.cloud.bigtable.admin.v2.BigtableTableAdminClient;
import com.google.cloud.bigtable.admin.v2.BigtableTableAdminSettings;
import com.google.cloud.bigtable.admin.v2.models.CreateInstanceRequest;
import com.google.cloud.bigtable.admin.v2.models.Instance;
import com.google.cloud.bigtable.admin.v2.models.StorageType;
import com.google.cloud.bigtable.data.v2.BigtableDataClient;
import com.google.cloud.bigtable.data.v2.BigtableDataSettings;
import com.google.common.collect.ImmutableMap;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.PrintStream;
import java.time.Instant;
import java.util.UUID;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class NativeImageBigtableTest {

  private static final String INSTANCE_NAME =
      System.getProperty("bigtable.instance", "nativeimage-it-instance");
  private static final String TABLE_SUFFIX = "nativeimage-it-";

  private static final String PROJECT_ID = ServiceOptions.getDefaultProjectId();

  private static final Instant TIMESTAMP = Instant.EPOCH;

  private String tableName;
  private BigtableDataClient dataClient;
  private BigtableTableAdminClient adminClient;

  private static PrintStream originalOut;
  public ByteArrayOutputStream bout;

  @After
  public void tearDown() {
    System.setOut(originalOut);
    bout.reset();
  }

  @Before
  public void setUp() throws IOException {
    // Create instance if not present
    BigtableInstanceAdminSettings instanceAdminSettings =
        BigtableInstanceAdminSettings.newBuilder().setProjectId(PROJECT_ID).build();
    BigtableInstanceAdminClient instanceAdminClient =
        BigtableInstanceAdminClient.create(instanceAdminSettings);
    if (!instanceAdminClient.exists(INSTANCE_NAME)) {
      instanceAdminClient.createInstance(
          CreateInstanceRequest.of(INSTANCE_NAME)
              .addCluster("cluster", "us-central1-f", 3, StorageType.SSD)
              .setType(Instance.Type.PRODUCTION)
              .addLabel("example", "instance_admin"));
    }

    BigtableTableAdminSettings adminClientSettings =
        BigtableTableAdminSettings.newBuilder()
            .setInstanceId(INSTANCE_NAME)
            .setProjectId(PROJECT_ID)
            .build();
    BigtableDataSettings clientSettings =
        BigtableDataSettings.newBuilder()
            .setInstanceId(INSTANCE_NAME)
            .setProjectId(PROJECT_ID)
            .build();
    adminClient = BigtableTableAdminClient.create(adminClientSettings);
    tableName = TABLE_SUFFIX + UUID.randomUUID().toString().replace("-", "");
    NativeImageBigtableSample.createTable(adminClient, tableName);

    dataClient = BigtableDataClient.create(clientSettings);

    // To test output stream
    originalOut = System.out;
    bout = new ByteArrayOutputStream();
    System.setOut(new PrintStream(bout));
  }

  @Test
  public void testReadData() {
    ImmutableMap<String, Long> dataWithInts = ImmutableMap.of("connection_cell", 1L);
    ImmutableMap<String, String> dataWithStrings = ImmutableMap.of("os_build", "build_value");
    NativeImageBigtableSample.insertData(
        dataClient, tableName, TIMESTAMP.getEpochSecond(), dataWithInts, dataWithStrings);

    NativeImageBigtableSample.readData(dataClient, tableName);

    String output = bout.toString();
    assertThat(output)
        .contains(
            "Successfully wrote row: phone#0\n"
                + "Reading phone data in table:\n"
                + "Key: phone#0\n"
                + "\tconnection_cell: \u0000\u0000\u0000\u0000\u0000\u0000\u0000\u0001 @0\n"
                + "\tos_build: build_value @0\n\n");

    // Clean up
    NativeImageBigtableSample.deleteTable(adminClient, tableName);
  }
}
