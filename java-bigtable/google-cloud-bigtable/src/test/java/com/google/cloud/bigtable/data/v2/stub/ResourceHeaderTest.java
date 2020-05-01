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

import com.google.api.gax.batching.Batcher;
import com.google.api.gax.core.NoCredentialsProvider;
import com.google.api.gax.grpc.testing.InProcessServer;
import com.google.api.gax.grpc.testing.LocalChannelProvider;
import com.google.api.gax.rpc.FixedHeaderProvider;
import com.google.bigtable.v2.BigtableGrpc;
import com.google.cloud.bigtable.data.v2.BigtableDataClient;
import com.google.cloud.bigtable.data.v2.BigtableDataSettings;
import com.google.cloud.bigtable.data.v2.internal.NameUtil;
import com.google.cloud.bigtable.data.v2.models.ConditionalRowMutation;
import com.google.cloud.bigtable.data.v2.models.Mutation;
import com.google.cloud.bigtable.data.v2.models.Query;
import com.google.cloud.bigtable.data.v2.models.ReadModifyWriteRow;
import com.google.cloud.bigtable.data.v2.models.RowMutation;
import com.google.cloud.bigtable.data.v2.models.RowMutationEntry;
import java.util.regex.Pattern;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;

@RunWith(JUnit4.class)
public class ResourceHeaderTest {
  private static final String PROJECT_ID = "fake-project";
  private static final String INSTANCE_ID = "fake-instance";
  private static final String TABLE_ID = "fake-table";
  private static final String TABLE_NAME =
      NameUtil.formatTableName(PROJECT_ID, INSTANCE_ID, TABLE_ID);
  private static final String APP_PROFILE_ID = "fake-profile";

  private static final String CHANNEL_NAME = "resource-header-test:123";
  private static final String X_GOOG_REQUEST_PARAMS_KEY = "x-goog-request-params";
  private static final String TEST_HEADER_KEY = "simple-header-name";
  private static final String TEST_HEADER_VALUE = "simple-header-value";

  private InProcessServer<?> server;
  private LocalChannelProvider channelProvider;
  private BigtableDataClient client;

  @Before
  public void setUp() throws Exception {
    server = new InProcessServer<>(new BigtableGrpc.BigtableImplBase() {}, CHANNEL_NAME);
    server.start();
    channelProvider = LocalChannelProvider.create(CHANNEL_NAME);

    BigtableDataSettings.Builder settings =
        BigtableDataSettings.newBuilder()
            .setProjectId(PROJECT_ID)
            .setInstanceId(INSTANCE_ID)
            .setAppProfileId(APP_PROFILE_ID)
            .setCredentialsProvider(NoCredentialsProvider.create());

    settings
        .stubSettings()
        .setTransportChannelProvider(channelProvider)
        .setHeaderProvider(FixedHeaderProvider.create(TEST_HEADER_KEY, TEST_HEADER_VALUE));

    // Force immediate flush
    settings
        .stubSettings()
        .bulkMutateRowsSettings()
        .setBatchingSettings(
            settings
                .stubSettings()
                .bulkMutateRowsSettings()
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
    client.readRows(Query.create(TABLE_ID));
    verifyHeaderSent();
  }

  @Test
  public void sampleRowKeysTest() {
    client.sampleRowKeysAsync(TABLE_ID);
    verifyHeaderSent();
  }

  @Test
  public void mutateRowTest() {
    client.mutateRowAsync(RowMutation.create(TABLE_ID, "fake-key").deleteRow());
    verifyHeaderSent();
  }

  @Test
  public void mutateRowsTest() throws InterruptedException {
    try (Batcher<RowMutationEntry, Void> batcher = client.newBulkMutationBatcher(TABLE_ID)) {
      batcher.add(RowMutationEntry.create("fake-key").deleteRow());
    } catch (RuntimeException e) {
      // Ignore the errors: none of the methods are actually implemented
    }
    verifyHeaderSent();
  }

  @Test
  public void checkAndMutateRowTest() {
    client.checkAndMutateRowAsync(
        ConditionalRowMutation.create(TABLE_ID, "fake-key").then(Mutation.create().deleteRow()));
    verifyHeaderSent();
  }

  @Test
  public void readModifyWriteTest() {
    client.readModifyWriteRowAsync(
        ReadModifyWriteRow.create(TABLE_ID, "fake-key").increment("cf", "q", 1));
    verifyHeaderSent();
  }

  private void verifyHeaderSent() {
    boolean tableHeaderSent =
        channelProvider.isHeaderSent(
            X_GOOG_REQUEST_PARAMS_KEY,
            Pattern.compile("(^|.*&)table_name=" + TABLE_NAME + "($|&.*)"));
    assertWithMessage("Tablename header was sent").that(tableHeaderSent).isTrue();

    boolean appProfileHeaderSent =
        channelProvider.isHeaderSent(
            X_GOOG_REQUEST_PARAMS_KEY,
            Pattern.compile("(^|.*&)app_profile_id=" + APP_PROFILE_ID + "($|&.*)"));
    assertWithMessage("App profile header was sent").that(appProfileHeaderSent).isTrue();

    boolean testHeader =
        channelProvider.isHeaderSent(
            TEST_HEADER_KEY, Pattern.compile("^" + TEST_HEADER_VALUE + "$"));
    assertWithMessage("HeaderProvider's header received in Channel").that(testHeader).isTrue();
  }
}
