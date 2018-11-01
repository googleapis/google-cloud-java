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
package com.google.cloud.bigtable.data.v2.stub;

import static com.google.common.truth.Truth.assertWithMessage;

import com.google.api.gax.core.NoCredentialsProvider;
import com.google.api.gax.grpc.testing.InProcessServer;
import com.google.api.gax.grpc.testing.LocalChannelProvider;
import com.google.bigtable.v2.BigtableGrpc;
import com.google.bigtable.v2.TableName;
import com.google.cloud.bigtable.data.v2.BigtableDataClient;
import com.google.cloud.bigtable.data.v2.BigtableDataSettings;
import com.google.cloud.bigtable.data.v2.models.BulkMutationBatcher;
import com.google.cloud.bigtable.data.v2.models.BulkMutationBatcher.BulkMutationFailure;
import com.google.cloud.bigtable.data.v2.models.ConditionalRowMutation;
import com.google.cloud.bigtable.data.v2.models.InstanceName;
import com.google.cloud.bigtable.data.v2.models.Mutation;
import com.google.cloud.bigtable.data.v2.models.Query;
import com.google.cloud.bigtable.data.v2.models.ReadModifyWriteRow;
import com.google.cloud.bigtable.data.v2.models.RowMutation;
import java.util.concurrent.TimeoutException;
import java.util.regex.Pattern;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;

@RunWith(JUnit4.class)
public class ResourceHeaderTest {
  private static final String NAME = "resource-header-test:123";
  private static final TableName TABLE_NAME =
      TableName.of("fake-project", "fake-instance", "fake-table");
  private static final Pattern EXPECTED_HEADER_PATTERN =
      Pattern.compile(".*" + TABLE_NAME.toString() + ".*");
  private static final String HEADER_NAME = "x-goog-request-params";

  private InProcessServer<?> server;
  private LocalChannelProvider channelProvider;
  private BigtableDataClient client;

  @Before
  public void setUp() throws Exception {
    server = new InProcessServer<>(new BigtableGrpc.BigtableImplBase() {}, NAME);
    server.start();
    channelProvider = LocalChannelProvider.create(NAME);

    BigtableDataSettings.Builder settings =
        BigtableDataSettings.newBuilder()
            .setInstanceName(InstanceName.of(TABLE_NAME.getProject(), TABLE_NAME.getInstance()))
            .setTransportChannelProvider(channelProvider)
            .setCredentialsProvider(NoCredentialsProvider.create());

    // Force immediate flush
    settings
        .bulkMutationsSettings()
        .setBatchingSettings(
            settings
                .bulkMutationsSettings()
                .getBatchingSettings()
                .toBuilder()
                .setElementCountThreshold(1L)
                .build());

    client = BigtableDataClient.create(settings.build());
  }

  @After
  public void tearDown() throws Exception {
    client.close();
    server.stop();
    server.blockUntilShutdown();
  }

  @Test
  public void readRowsTest() {
    client.readRows(Query.create(TABLE_NAME.getTable()));
    verifyHeaderSent();
  }

  @Test
  public void sampleRowKeysTest() {
    client.sampleRowKeysAsync(TABLE_NAME.getTable());
    verifyHeaderSent();
  }

  @Test
  public void mutateRowTest() {
    client.mutateRowAsync(RowMutation.create(TABLE_NAME.getTable(), "fake-key").deleteRow());
    verifyHeaderSent();
  }

  @Test
  public void mutateRowsTest() throws TimeoutException, InterruptedException {
    try (BulkMutationBatcher batcher = client.newBulkMutationBatcher()) {
      batcher.add(RowMutation.create(TABLE_NAME.getTable(), "fake-key").deleteRow());
    } catch (BulkMutationFailure e) {
      // Ignore the errors: none of the methods are actually implemented
    }
    verifyHeaderSent();
  }

  @Test
  public void checkAndMutateRowTest() {
    client.checkAndMutateRowAsync(
        ConditionalRowMutation.create(TABLE_NAME.getTable(), "fake-key")
            .then(Mutation.create().deleteRow()));
    verifyHeaderSent();
  }

  @Test
  public void readModifyWriteTest() {
    client.readModifyWriteRowAsync(
        ReadModifyWriteRow.create(TABLE_NAME.getTable(), "fake-key").increment("cf", "q", 1));
    verifyHeaderSent();
  }

  private void verifyHeaderSent() {
    boolean headerSent = channelProvider.isHeaderSent(HEADER_NAME, EXPECTED_HEADER_PATTERN);
    assertWithMessage("Header was sent").that(headerSent).isTrue();
  }
}
