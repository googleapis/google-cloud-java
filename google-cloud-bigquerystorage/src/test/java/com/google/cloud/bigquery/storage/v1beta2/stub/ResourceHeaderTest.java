/*
 * Copyright 2020 Google LLC
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
package com.google.cloud.bigquery.storage.v1beta2.stub;

import static com.google.common.truth.Truth.assertWithMessage;

import com.google.api.gax.core.NoCredentialsProvider;
import com.google.api.gax.grpc.testing.InProcessServer;
import com.google.api.gax.grpc.testing.LocalChannelProvider;
import com.google.api.gax.rpc.FixedHeaderProvider;
import com.google.api.gax.rpc.UnimplementedException;
import com.google.cloud.bigquery.storage.v1beta2.BigQueryReadClient;
import com.google.cloud.bigquery.storage.v1beta2.BigQueryReadGrpc.BigQueryReadImplBase;
import com.google.cloud.bigquery.storage.v1beta2.BigQueryReadSettings;
import com.google.cloud.bigquery.storage.v1beta2.BigQueryWriteClient;
import com.google.cloud.bigquery.storage.v1beta2.BigQueryWriteSettings;
import com.google.cloud.bigquery.storage.v1beta2.ReadRowsRequest;
import com.google.cloud.bigquery.storage.v1beta2.ReadSession;
import com.google.cloud.bigquery.storage.v1beta2.SplitReadStreamRequest;
import com.google.cloud.bigquery.storage.v1beta2.WriteStream;
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

  private static final String TEST_TABLE_REFERENCE =
      "projects/project/datasets/dataset/tables/table";

  private static final String WRITE_STREAM_NAME =
      "projects/project/datasets/dataset/tables/table/streams/stream";

  private static final String TEST_STREAM_NAME = "streamName";

  private static final String NAME = "resource-header-test:123";

  private static final String HEADER_NAME = "x-goog-request-params";

  private static final Pattern READ_SESSION_NAME_PATTERN =
      Pattern.compile(
          ".*"
              + "read_session\\.table=projects%2Fproject%2Fdatasets%2Fdataset%2Ftables%2Ftable"
              + ".*");

  private static final Pattern PARENT_PATTERN =
      Pattern.compile(
          ".*" + "parent=projects%2Fproject%2Fdatasets%2Fdataset%2Ftables%2Ftable" + ".*");

  private static final Pattern NAME_PATTERN =
      Pattern.compile(
          ".*"
              + "name=projects%2Fproject%2Fdatasets%2Fdataset%2Ftables%2Ftable%2Fstreams%2Fstream"
              + ".*");

  private static final Pattern WRITE_STREAM_PATTERN =
      Pattern.compile(
          ".*write_stream=projects%2Fproject%2Fdatasets%2Fdataset%2Ftables%2Ftable%2Fstreams%2Fstream"
              + ".*");

  private static final Pattern READ_STREAM_PATTERN =
      Pattern.compile(".*" + "read_stream=streamName" + ".*");
  private static final Pattern STREAM_NAME_PATTERN =
      Pattern.compile(".*" + "name=streamName" + ".*");

  private static final String TEST_HEADER_NAME = "simple-header-name";
  private static final String TEST_HEADER_VALUE = "simple-header-value";
  private static final Pattern TEST_PATTERN = Pattern.compile(".*" + TEST_HEADER_VALUE + ".*");

  private static InProcessServer<?> server;

  private LocalChannelProvider channelProvider;
  private LocalChannelProvider channelProvider2;
  private BigQueryReadClient client;
  private BigQueryWriteClient writeClient;

  @BeforeClass
  public static void setUpClass() throws Exception {
    server = new InProcessServer<>(new BigQueryReadImplBase() {}, NAME);
    server.start();
  }

  @Before
  public void setUp() throws Exception {
    channelProvider = LocalChannelProvider.create(NAME);
    BigQueryReadSettings.Builder settingsBuilder =
        BigQueryReadSettings.newBuilder()
            .setCredentialsProvider(NoCredentialsProvider.create())
            .setHeaderProvider(FixedHeaderProvider.create(TEST_HEADER_NAME, TEST_HEADER_VALUE))
            .setTransportChannelProvider(channelProvider);
    client = BigQueryReadClient.create(settingsBuilder.build());
    channelProvider2 = LocalChannelProvider.create(NAME);
    BigQueryWriteSettings.Builder writeSettingsBuilder =
        BigQueryWriteSettings.newBuilder()
            .setCredentialsProvider(NoCredentialsProvider.create())
            .setTransportChannelProvider(channelProvider2);
    writeClient = BigQueryWriteClient.create(writeSettingsBuilder.build());
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
      client.createReadSession(
          "parents/project", ReadSession.newBuilder().setTable(TEST_TABLE_REFERENCE).build(), 1);
    } catch (UnimplementedException e) {
      // Ignore the error: none of the methods are actually implemented.
    }
    verifyHeaderSent(READ_SESSION_NAME_PATTERN);
  }

  @Test
  public void readRowsTest() {
    try {
      ReadRowsRequest request =
          ReadRowsRequest.newBuilder().setReadStream(TEST_STREAM_NAME).setOffset(125).build();
      client.readRowsCallable().call(request);
    } catch (UnimplementedException e) {
      // Ignore the error: none of the methods are actually implemented.
    }

    verifyHeaderSent(READ_STREAM_PATTERN);
  }

  @Test
  public void splitReadStreamTest() {
    try {
      client.splitReadStream(SplitReadStreamRequest.newBuilder().setName(TEST_STREAM_NAME).build());
    } catch (UnimplementedException e) {
      // Ignore the error: none of the methods are actually implemented.
    }

    verifyHeaderSent(STREAM_NAME_PATTERN);
  }

  @Test
  public void createWriteStreamTest() {
    try {
      writeClient.createWriteStream(
          "projects/project/datasets/dataset/tables/table",
          WriteStream.newBuilder().setType(WriteStream.Type.BUFFERED).build());
    } catch (UnimplementedException e) {
      // Ignore the error: none of the methods are actually implemented.
    }
    boolean headerSent = channelProvider2.isHeaderSent(HEADER_NAME, PARENT_PATTERN);
    assertWithMessage("Generated header was sent").that(headerSent).isTrue();
  }

  @Test
  public void getWriteStreamTest() {
    try {
      writeClient.getWriteStream(WRITE_STREAM_NAME);
    } catch (UnimplementedException e) {
      // Ignore the error: none of the methods are actually implemented.
    }
    boolean headerSent = channelProvider2.isHeaderSent(HEADER_NAME, NAME_PATTERN);
    assertWithMessage("Generated header was sent").that(headerSent).isTrue();
  }

  // Following tests will work after b/185842996 is fixed.
  //  @Test
  //  public void appendRowsTest() {
  //    try {
  //      AppendRowsRequest req =
  //          AppendRowsRequest.newBuilder().setWriteStream(WRITE_STREAM_NAME).build();
  //      BidiStream<AppendRowsRequest, AppendRowsResponse> bidiStream =
  //          writeClient.appendRowsCallable().call();
  //      bidiStream.send(req);
  //    } catch (UnimplementedException e) {
  //      // Ignore the error: none of the methods are actually implemented.
  //    }
  //    boolean headerSent = channelProvider2.isHeaderSent(HEADER_NAME, WRITE_STREAM_PATTERN);
  //    assertWithMessage("Generated header was sent").that(headerSent).isTrue();
  //  }
  //
  //  @Test
  //  public void appendRowsManualTest() {
  //    try {
  //      StreamWriterV2 streamWriter =
  //          StreamWriterV2.newBuilder(WRITE_STREAM_NAME, writeClient)
  //              .setWriterSchema(ProtoSchema.newBuilder().build())
  //              .build();
  //      streamWriter.append(ProtoRows.newBuilder().build(), 1);
  //    } catch (UnimplementedException e) {
  //      // Ignore the error: none of the methods are actually implemented.
  //    } catch (IOException e) {
  //      // Ignore the error: none of the methods are actually implemented.
  //    }
  //    boolean headerSent = channelProvider2.isHeaderSent(HEADER_NAME, WRITE_STREAM_PATTERN);
  //    assertWithMessage("Generated header was sent").that(headerSent).isTrue();
  //  }

  private void verifyHeaderSent(Pattern... patterns) {
    for (Pattern pattern : patterns) {
      boolean headerSent = channelProvider.isHeaderSent(HEADER_NAME, pattern);
      assertWithMessage("Generated header was sent").that(headerSent).isTrue();
    }
    boolean testHeaderSent = channelProvider.isHeaderSent(TEST_HEADER_NAME, TEST_PATTERN);
    assertWithMessage("Provided header was sent").that(testHeaderSent).isTrue();
  }
}
