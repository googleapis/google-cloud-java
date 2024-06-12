/*
 * Copyright 2024 Google LLC
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
package com.google.cloud.bigquery.storage.v1.stub;

import static com.google.common.truth.Truth.assertWithMessage;

import com.google.api.gax.core.NoCredentialsProvider;
import com.google.api.gax.grpc.testing.InProcessServer;
import com.google.api.gax.grpc.testing.LocalChannelProvider;
import com.google.api.gax.rpc.ApiCallContext;
import com.google.api.gax.rpc.BidiStreamingCallable;
import com.google.api.gax.rpc.ClientStream;
import com.google.api.gax.rpc.FixedHeaderProvider;
import com.google.api.gax.rpc.ResponseObserver;
import com.google.api.gax.rpc.StreamController;
import com.google.api.gax.rpc.UnimplementedException;
import com.google.cloud.bigquery.storage.v1.*;
import com.google.cloud.bigquery.storage.v1.BigQueryWriteGrpc.BigQueryWriteImplBase;
import java.util.regex.Pattern;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;

@RunWith(JUnit4.class)
public class WriteHeaderTest {

  private static final String TEST_TABLE_REFERENCE =
      "projects/project/datasets/dataset/tables/table";

  private static final String TEST_STREAM_NAME = "streamName";

  private static final String NAME = "write-header-test:456";

  private static final String TEST_HEADER_NAME = "simple-header-name";
  private static final String TEST_HEADER_VALUE = "simple-header-value";
  private static final Pattern TEST_PATTERN = Pattern.compile(".*" + TEST_HEADER_VALUE + ".*");
  private static final String USER_AGENT_HEADER_NAME = "User-Agent";
  private static final String USER_AGENT_HEADER_VALUE = "justChecking";
  private static final Pattern USER_AGENT_PATTERN =
      Pattern.compile(".*" + USER_AGENT_HEADER_VALUE + ".*");

  private static InProcessServer<?> server;

  private LocalChannelProvider channelProvider;
  private BigQueryWriteClient client;

  @BeforeClass
  public static void setUpClass() throws Exception {
    server = new InProcessServer<>(new BigQueryWriteImplBase() {}, NAME);
    server.start();
  }

  @Before
  public void setUp() throws Exception {
    channelProvider = LocalChannelProvider.create(NAME);
    BigQueryWriteSettings.Builder settingsBuilder =
        BigQueryWriteSettings.newBuilder()
            .setCredentialsProvider(NoCredentialsProvider.create())
            .setHeaderProvider(
                FixedHeaderProvider.create(
                    TEST_HEADER_NAME,
                    TEST_HEADER_VALUE,
                    USER_AGENT_HEADER_NAME,
                    USER_AGENT_HEADER_VALUE))
            .setTransportChannelProvider(channelProvider);
    client = BigQueryWriteClient.create(settingsBuilder.build());
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
  public void createWriteStreamTest() {
    CreateWriteStreamRequest request =
        CreateWriteStreamRequest.newBuilder()
            .setParent(TEST_TABLE_REFERENCE)
            .setWriteStream(WriteStream.newBuilder().build())
            .build();
    try {
      client.createWriteStream(request);
    } catch (UnimplementedException e) {
      // Ignore the error: none of the methods are actually implemented.
    }
    verifyWriteHeaderSent();
  }

  @Test
  public void writeRowsTest() {
    BidiStreamingCallable<AppendRowsRequest, AppendRowsResponse> callable =
        client.appendRowsCallable();
    ApiCallContext apiCallContext = null;
    ClientStream<AppendRowsRequest> clientStream =
        callable.splitCall(
            new ResponseObserver<AppendRowsResponse>() {
              @Override
              public void onStart(StreamController controller) {}

              @Override
              public void onResponse(AppendRowsResponse response) {}

              @Override
              public void onError(Throwable t) {}

              @Override
              public void onComplete() {}
            },
            apiCallContext);

    AppendRowsRequest request =
        AppendRowsRequest.newBuilder().setWriteStream(TEST_STREAM_NAME).build();
    try {
      clientStream.send(request);
    } catch (UnimplementedException e) {
      // Ignore the error: none of the methods are actually implemented.
    }
    verifyWriteHeaderSent();
  }

  private void verifyWriteHeaderSent() {
    boolean testHeaderSent = channelProvider.isHeaderSent(TEST_HEADER_NAME, TEST_PATTERN);
    assertWithMessage("Test header was sent").that(testHeaderSent).isTrue();
    boolean userAgentHeaderSent =
        channelProvider.isHeaderSent(USER_AGENT_HEADER_NAME, USER_AGENT_PATTERN);
    assertWithMessage("User Agent header was sent").that(userAgentHeaderSent).isTrue();
  }
}
