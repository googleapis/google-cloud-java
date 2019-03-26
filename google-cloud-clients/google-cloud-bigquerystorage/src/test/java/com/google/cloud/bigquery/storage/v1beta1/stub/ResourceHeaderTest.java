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
package com.google.cloud.bigquery.storage.v1beta1.stub;

import static com.google.common.truth.Truth.assertWithMessage;

import com.google.api.gax.core.NoCredentialsProvider;
import com.google.api.gax.grpc.testing.InProcessServer;
import com.google.api.gax.grpc.testing.LocalChannelProvider;
import com.google.api.gax.rpc.FixedHeaderProvider;
import com.google.api.gax.rpc.UnimplementedException;
import com.google.cloud.bigquery.storage.v1beta1.BigQueryStorageClient;
import com.google.cloud.bigquery.storage.v1beta1.BigQueryStorageGrpc.BigQueryStorageImplBase;
import com.google.cloud.bigquery.storage.v1beta1.BigQueryStorageSettings;
import com.google.cloud.bigquery.storage.v1beta1.Storage.ReadRowsRequest;
import com.google.cloud.bigquery.storage.v1beta1.Storage.ReadSession;
import com.google.cloud.bigquery.storage.v1beta1.Storage.Stream;
import com.google.cloud.bigquery.storage.v1beta1.Storage.StreamPosition;
import com.google.cloud.bigquery.storage.v1beta1.TableReferenceProto.TableReference;
import java.util.regex.Pattern;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;

@RunWith(JUnit4.class)
public class ResourceHeaderTest {

  private static final TableReference TEST_TABLE_REFERENCE =
      TableReference.newBuilder()
          .setProjectId("project")
          .setDatasetId("dataset")
          .setTableId("table")
          .build();

  private static final ReadSession TEST_SESSION =
      ReadSession.newBuilder().setName("sessionName").build();

  private static final Stream TEST_STREAM = Stream.newBuilder().setName("streamName").build();

  private static final String NAME = "resource-header-test:123";

  private static final String HEADER_NAME = "x-goog-request-params";

  private static final Pattern DATASET_PATTERN =
      Pattern.compile(".*" + "table_reference\\.dataset_id=dataset" + ".*");
  private static final Pattern ORIGINAL_STREAM_PATTERN =
      Pattern.compile(".*" + "original_stream\\.name=streamName" + ".*");
  private static final Pattern PROJECT_PATTERN =
      Pattern.compile(".*" + "table_reference\\.project_id=project" + ".*");
  private static final Pattern READ_POSITION_PATTERN =
      Pattern.compile(".*" + "read_position\\.stream\\.name=streamName" + ".*");
  private static final Pattern SESSION_PATTERN =
      Pattern.compile(".*" + "session\\.name=sessionName" + ".*");
  private static final Pattern STREAM_PATTERN =
      Pattern.compile(".*" + "stream\\.name=streamName" + ".*");

  private static final String TEST_HEADER_NAME = "simple-header-name";
  private static final String TEST_HEADER_VALUE = "simple-header-value";
  private static final Pattern TEST_PATTERN = Pattern.compile(".*" + TEST_HEADER_VALUE + ".*");

  private static InProcessServer<?> server;

  private LocalChannelProvider channelProvider;
  private BigQueryStorageClient client;

  @BeforeClass
  public static void setUpClass() throws Exception {
    server = new InProcessServer<>(new BigQueryStorageImplBase() {}, NAME);
    server.start();
  }

  @Before
  public void setUp() throws Exception {
    channelProvider = LocalChannelProvider.create(NAME);
    BigQueryStorageSettings.Builder settingsBuilder =
        BigQueryStorageSettings.newBuilder()
            .setCredentialsProvider(NoCredentialsProvider.create())
            .setHeaderProvider(FixedHeaderProvider.create(TEST_HEADER_NAME, TEST_HEADER_VALUE))
            .setTransportChannelProvider(channelProvider);
    client = BigQueryStorageClient.create(settingsBuilder.build());
  }

  @After
  public void tearDown() throws Exception {
    client.close();
  }

  @AfterClass
  public static void tearDownClass() throws Exception {
    server.stop();
    server.blockUntilShutdown();
  }

  @Test
  public void createReadSessionTest() {
    try {
      client.createReadSession(TEST_TABLE_REFERENCE, "parents/project", 1);
    } catch (UnimplementedException e) {
      // Ignore the error: none of the methods are actually implemented.
    }
    verifyHeaderSent(PROJECT_PATTERN, DATASET_PATTERN);
  }

  @Test
  public void readRowsTest() {
    try {
      ReadRowsRequest request =
          ReadRowsRequest.newBuilder()
              .setReadPosition(StreamPosition.newBuilder().setStream(TEST_STREAM).setOffset(125))
              .build();
      client.readRowsCallable().call(request);
    } catch (UnimplementedException e) {
      // Ignore the error: none of the methods are actually implemented.
    }

    verifyHeaderSent(READ_POSITION_PATTERN);
  }

  @Test
  public void batchCreateReadStreamsForSessionTest() {
    try {
      client.batchCreateReadSessionStreams(TEST_SESSION, 1);
    } catch (UnimplementedException e) {
      // Ignore the error: none of the methods are actually implemented.
    }

    verifyHeaderSent(SESSION_PATTERN);
  }

  @Test
  public void finalizeStreamTest() {
    try {
      client.finalizeStream(TEST_STREAM);
    } catch (UnimplementedException e) {
      // Ignore the error: none of the methods are actually implemented.
    }

    verifyHeaderSent(STREAM_PATTERN);
  }

  @Test
  public void splitReadStreamTest() {
    try {
      client.splitReadStream(TEST_STREAM);
    } catch (UnimplementedException e) {
      // Ignore the error: none of the methods are actually implemented.
    }

    verifyHeaderSent(ORIGINAL_STREAM_PATTERN);
  }

  private void verifyHeaderSent(Pattern... patterns) {
    for (Pattern pattern : patterns) {
      boolean headerSent = channelProvider.isHeaderSent(HEADER_NAME, pattern);
      assertWithMessage("Generated header was sent").that(headerSent).isTrue();
    }
    boolean testHeaderSent = channelProvider.isHeaderSent(TEST_HEADER_NAME, TEST_PATTERN);
    assertWithMessage("Provided header was sent").that(testHeaderSent).isTrue();
  }
}
