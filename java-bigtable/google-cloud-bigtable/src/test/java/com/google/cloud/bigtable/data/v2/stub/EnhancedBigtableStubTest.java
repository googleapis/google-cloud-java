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
package com.google.cloud.bigtable.data.v2.stub;

import static com.google.common.truth.Truth.assertThat;

import com.google.api.gax.core.NoCredentialsProvider;
import com.google.api.gax.rpc.ServerStreamingCallable;
import com.google.bigtable.v2.BigtableGrpc;
import com.google.bigtable.v2.ReadRowsRequest;
import com.google.bigtable.v2.ReadRowsResponse;
import com.google.bigtable.v2.RowSet;
import com.google.cloud.bigtable.admin.v2.internal.NameUtil;
import com.google.cloud.bigtable.data.v2.BigtableDataSettings;
import com.google.cloud.bigtable.data.v2.FakeServiceHelper;
import com.google.cloud.bigtable.data.v2.internal.RequestContext;
import com.google.cloud.bigtable.data.v2.models.DefaultRowAdapter;
import com.google.cloud.bigtable.data.v2.models.Query;
import com.google.cloud.bigtable.data.v2.models.Row;
import com.google.common.collect.Queues;
import com.google.protobuf.ByteString;
import com.google.protobuf.BytesValue;
import com.google.protobuf.StringValue;
import io.grpc.Metadata;
import io.grpc.ServerCall;
import io.grpc.ServerCall.Listener;
import io.grpc.ServerCallHandler;
import io.grpc.ServerInterceptor;
import io.grpc.stub.StreamObserver;
import java.io.IOException;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.TimeUnit;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;

@RunWith(JUnit4.class)
public class EnhancedBigtableStubTest {

  private static final String PROJECT_ID = "fake-project";
  private static final String INSTANCE_ID = "fake-instance";
  private static final String TABLE_NAME =
      NameUtil.formatTableName(PROJECT_ID, INSTANCE_ID, "fake-table");
  private static final String APP_PROFILE_ID = "app-profile-id";

  FakeServiceHelper serviceHelper;
  private MetadataInterceptor metadataInterceptor;
  private FakeDataService fakeDataService;
  private EnhancedBigtableStubSettings defaultSettings;
  private EnhancedBigtableStub enhancedBigtableStub;

  @Before
  public void setUp() throws IOException, IllegalAccessException, InstantiationException {
    metadataInterceptor = new MetadataInterceptor();
    fakeDataService = new FakeDataService();
    serviceHelper = new FakeServiceHelper(metadataInterceptor, fakeDataService);
    serviceHelper.start();

    defaultSettings =
        BigtableDataSettings.newBuilderForEmulator(serviceHelper.getPort())
            .setProjectId(PROJECT_ID)
            .setInstanceId(INSTANCE_ID)
            .setAppProfileId(APP_PROFILE_ID)
            .setCredentialsProvider(NoCredentialsProvider.create())
            .build()
            .getStubSettings();

    enhancedBigtableStub = EnhancedBigtableStub.create(defaultSettings);
  }

  @After
  public void tearDown() {
    serviceHelper.shutdown();
  }

  @Test
  public void testCreateReadRowsCallable() throws InterruptedException {
    ServerStreamingCallable<Query, Row> streamingCallable =
        enhancedBigtableStub.createReadRowsCallable(new DefaultRowAdapter());

    Query request = Query.create("table-id").rowKey("row-key");
    streamingCallable.call(request).iterator().next();
    ReadRowsRequest expected =
        request.toProto(RequestContext.create(PROJECT_ID, INSTANCE_ID, APP_PROFILE_ID));
    assertThat(fakeDataService.popLastRequest()).isEqualTo(expected);
  }

  @Test
  public void testCreateReadRowsRawCallable() throws InterruptedException {
    ServerStreamingCallable<ReadRowsRequest, Row> callable =
        enhancedBigtableStub.createReadRowsRawCallable(new DefaultRowAdapter());

    ReadRowsRequest expectedRequest =
        ReadRowsRequest.newBuilder()
            .setTableName(TABLE_NAME)
            .setAppProfileId("app-profile-1")
            .setRows(RowSet.newBuilder().addRowKeys(ByteString.copyFromUtf8("test-row-key")))
            .build();
    callable.call(expectedRequest).iterator().next();
    assertThat(fakeDataService.popLastRequest()).isEqualTo(expectedRequest);

    ReadRowsRequest expectedRequest2 =
        ReadRowsRequest.newBuilder()
            .setTableName(TABLE_NAME)
            .setAppProfileId("app-profile-2")
            .build();
    callable.call(expectedRequest2).iterator().next();
    assertThat(fakeDataService.popLastRequest()).isEqualTo(expectedRequest2);
  }

  @Test
  public void testChannelPrimerConfigured() throws IOException {
    EnhancedBigtableStubSettings settings =
        defaultSettings
            .toBuilder()
            .setRefreshingChannel(true)
            .setPrimedTableIds("table1", "table2")
            .build();

    try (EnhancedBigtableStub ignored = EnhancedBigtableStub.create(settings)) {
      // priming will issue a request per table on startup
      assertThat(fakeDataService.requests).hasSize(2);
    }
  }

  @Test
  public void testUserAgent() throws InterruptedException {
    ServerStreamingCallable<Query, Row> streamingCallable =
        enhancedBigtableStub.createReadRowsCallable(new DefaultRowAdapter());

    Query request = Query.create("table-id").rowKey("row-key");
    streamingCallable.call(request).iterator().next();

    assertThat(metadataInterceptor.headers).hasSize(1);
    Metadata metadata = metadataInterceptor.headers.take();
    assertThat(metadata.get(Metadata.Key.of("user-agent", Metadata.ASCII_STRING_MARSHALLER)))
        .containsMatch("bigtable-java/\\d+\\.\\d+\\.\\d+(?:-SNAPSHOT)?");
  }

  private static class MetadataInterceptor implements ServerInterceptor {
    final BlockingQueue<Metadata> headers = Queues.newLinkedBlockingDeque();

    @Override
    public <ReqT, RespT> Listener<ReqT> interceptCall(
        ServerCall<ReqT, RespT> serverCall,
        Metadata metadata,
        ServerCallHandler<ReqT, RespT> serverCallHandler) {
      headers.add(metadata);
      return serverCallHandler.startCall(serverCall, metadata);
    }
  }

  private static class FakeDataService extends BigtableGrpc.BigtableImplBase {
    final BlockingQueue<ReadRowsRequest> requests = Queues.newLinkedBlockingDeque();

    @SuppressWarnings("unchecked")
    ReadRowsRequest popLastRequest() throws InterruptedException {
      return requests.poll(1, TimeUnit.SECONDS);
    }

    @Override
    public void readRows(
        ReadRowsRequest request, StreamObserver<ReadRowsResponse> responseObserver) {
      requests.add(request);
      // Dummy row for stream
      responseObserver.onNext(
          ReadRowsResponse.newBuilder()
              .addChunks(
                  ReadRowsResponse.CellChunk.newBuilder()
                      .setCommitRow(true)
                      .setRowKey(ByteString.copyFromUtf8("a"))
                      .setFamilyName(StringValue.getDefaultInstance())
                      .setQualifier(BytesValue.getDefaultInstance())
                      .setValueSize(0))
              .build());
      responseObserver.onCompleted();
    }
  }
}
