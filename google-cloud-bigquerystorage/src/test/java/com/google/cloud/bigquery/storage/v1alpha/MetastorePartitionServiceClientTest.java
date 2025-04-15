/*
 * Copyright 2025 Google LLC
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      https://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package com.google.cloud.bigquery.storage.v1alpha;

import com.google.api.gax.core.NoCredentialsProvider;
import com.google.api.gax.grpc.GaxGrpcProperties;
import com.google.api.gax.grpc.testing.LocalChannelProvider;
import com.google.api.gax.grpc.testing.MockGrpcService;
import com.google.api.gax.grpc.testing.MockServiceHelper;
import com.google.api.gax.grpc.testing.MockStreamObserver;
import com.google.api.gax.rpc.ApiClientHeaderProvider;
import com.google.api.gax.rpc.ApiStreamObserver;
import com.google.api.gax.rpc.BidiStreamingCallable;
import com.google.api.gax.rpc.InvalidArgumentException;
import com.google.api.gax.rpc.StatusCode;
import com.google.protobuf.AbstractMessage;
import com.google.protobuf.Empty;
import io.grpc.StatusRuntimeException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.UUID;
import java.util.concurrent.ExecutionException;
import javax.annotation.Generated;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Assert;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

@Generated("by gapic-generator-java")
public class MetastorePartitionServiceClientTest {
  private static MockMetastorePartitionService mockMetastorePartitionService;
  private static MockServiceHelper mockServiceHelper;
  private LocalChannelProvider channelProvider;
  private MetastorePartitionServiceClient client;

  @BeforeClass
  public static void startStaticServer() {
    mockMetastorePartitionService = new MockMetastorePartitionService();
    mockServiceHelper =
        new MockServiceHelper(
            UUID.randomUUID().toString(),
            Arrays.<MockGrpcService>asList(mockMetastorePartitionService));
    mockServiceHelper.start();
  }

  @AfterClass
  public static void stopServer() {
    mockServiceHelper.stop();
  }

  @Before
  public void setUp() throws IOException {
    mockServiceHelper.reset();
    channelProvider = mockServiceHelper.createChannelProvider();
    MetastorePartitionServiceSettings settings =
        MetastorePartitionServiceSettings.newBuilder()
            .setTransportChannelProvider(channelProvider)
            .setCredentialsProvider(NoCredentialsProvider.create())
            .build();
    client = MetastorePartitionServiceClient.create(settings);
  }

  @After
  public void tearDown() throws Exception {
    client.close();
  }

  @Test
  public void batchCreateMetastorePartitionsTest() throws Exception {
    BatchCreateMetastorePartitionsResponse expectedResponse =
        BatchCreateMetastorePartitionsResponse.newBuilder()
            .addAllPartitions(new ArrayList<MetastorePartition>())
            .build();
    mockMetastorePartitionService.addResponse(expectedResponse);

    BatchCreateMetastorePartitionsRequest request =
        BatchCreateMetastorePartitionsRequest.newBuilder()
            .setParent(TableName.of("[PROJECT]", "[DATASET]", "[TABLE]").toString())
            .addAllRequests(new ArrayList<CreateMetastorePartitionRequest>())
            .setSkipExistingPartitions(true)
            .setTraceId("traceId-1067401920")
            .build();

    BatchCreateMetastorePartitionsResponse actualResponse =
        client.batchCreateMetastorePartitions(request);
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockMetastorePartitionService.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    BatchCreateMetastorePartitionsRequest actualRequest =
        ((BatchCreateMetastorePartitionsRequest) actualRequests.get(0));

    Assert.assertEquals(request.getParent(), actualRequest.getParent());
    Assert.assertEquals(request.getRequestsList(), actualRequest.getRequestsList());
    Assert.assertEquals(
        request.getSkipExistingPartitions(), actualRequest.getSkipExistingPartitions());
    Assert.assertEquals(request.getTraceId(), actualRequest.getTraceId());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void batchCreateMetastorePartitionsExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockMetastorePartitionService.addException(exception);

    try {
      BatchCreateMetastorePartitionsRequest request =
          BatchCreateMetastorePartitionsRequest.newBuilder()
              .setParent(TableName.of("[PROJECT]", "[DATASET]", "[TABLE]").toString())
              .addAllRequests(new ArrayList<CreateMetastorePartitionRequest>())
              .setSkipExistingPartitions(true)
              .setTraceId("traceId-1067401920")
              .build();
      client.batchCreateMetastorePartitions(request);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void batchDeleteMetastorePartitionsTest() throws Exception {
    Empty expectedResponse = Empty.newBuilder().build();
    mockMetastorePartitionService.addResponse(expectedResponse);

    BatchDeleteMetastorePartitionsRequest request =
        BatchDeleteMetastorePartitionsRequest.newBuilder()
            .setParent(TableName.of("[PROJECT]", "[DATASET]", "[TABLE]").toString())
            .addAllPartitionValues(new ArrayList<MetastorePartitionValues>())
            .setTraceId("traceId-1067401920")
            .build();

    client.batchDeleteMetastorePartitions(request);

    List<AbstractMessage> actualRequests = mockMetastorePartitionService.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    BatchDeleteMetastorePartitionsRequest actualRequest =
        ((BatchDeleteMetastorePartitionsRequest) actualRequests.get(0));

    Assert.assertEquals(request.getParent(), actualRequest.getParent());
    Assert.assertEquals(request.getPartitionValuesList(), actualRequest.getPartitionValuesList());
    Assert.assertEquals(request.getTraceId(), actualRequest.getTraceId());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void batchDeleteMetastorePartitionsExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockMetastorePartitionService.addException(exception);

    try {
      BatchDeleteMetastorePartitionsRequest request =
          BatchDeleteMetastorePartitionsRequest.newBuilder()
              .setParent(TableName.of("[PROJECT]", "[DATASET]", "[TABLE]").toString())
              .addAllPartitionValues(new ArrayList<MetastorePartitionValues>())
              .setTraceId("traceId-1067401920")
              .build();
      client.batchDeleteMetastorePartitions(request);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void batchUpdateMetastorePartitionsTest() throws Exception {
    BatchUpdateMetastorePartitionsResponse expectedResponse =
        BatchUpdateMetastorePartitionsResponse.newBuilder()
            .addAllPartitions(new ArrayList<MetastorePartition>())
            .build();
    mockMetastorePartitionService.addResponse(expectedResponse);

    BatchUpdateMetastorePartitionsRequest request =
        BatchUpdateMetastorePartitionsRequest.newBuilder()
            .setParent(TableName.of("[PROJECT]", "[DATASET]", "[TABLE]").toString())
            .addAllRequests(new ArrayList<UpdateMetastorePartitionRequest>())
            .setTraceId("traceId-1067401920")
            .build();

    BatchUpdateMetastorePartitionsResponse actualResponse =
        client.batchUpdateMetastorePartitions(request);
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockMetastorePartitionService.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    BatchUpdateMetastorePartitionsRequest actualRequest =
        ((BatchUpdateMetastorePartitionsRequest) actualRequests.get(0));

    Assert.assertEquals(request.getParent(), actualRequest.getParent());
    Assert.assertEquals(request.getRequestsList(), actualRequest.getRequestsList());
    Assert.assertEquals(request.getTraceId(), actualRequest.getTraceId());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void batchUpdateMetastorePartitionsExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockMetastorePartitionService.addException(exception);

    try {
      BatchUpdateMetastorePartitionsRequest request =
          BatchUpdateMetastorePartitionsRequest.newBuilder()
              .setParent(TableName.of("[PROJECT]", "[DATASET]", "[TABLE]").toString())
              .addAllRequests(new ArrayList<UpdateMetastorePartitionRequest>())
              .setTraceId("traceId-1067401920")
              .build();
      client.batchUpdateMetastorePartitions(request);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void listMetastorePartitionsTest() throws Exception {
    ListMetastorePartitionsResponse expectedResponse =
        ListMetastorePartitionsResponse.newBuilder().build();
    mockMetastorePartitionService.addResponse(expectedResponse);

    TableName parent = TableName.of("[PROJECT]", "[DATASET]", "[TABLE]");

    ListMetastorePartitionsResponse actualResponse = client.listMetastorePartitions(parent);
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockMetastorePartitionService.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    ListMetastorePartitionsRequest actualRequest =
        ((ListMetastorePartitionsRequest) actualRequests.get(0));

    Assert.assertEquals(parent.toString(), actualRequest.getParent());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void listMetastorePartitionsExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockMetastorePartitionService.addException(exception);

    try {
      TableName parent = TableName.of("[PROJECT]", "[DATASET]", "[TABLE]");
      client.listMetastorePartitions(parent);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void listMetastorePartitionsTest2() throws Exception {
    ListMetastorePartitionsResponse expectedResponse =
        ListMetastorePartitionsResponse.newBuilder().build();
    mockMetastorePartitionService.addResponse(expectedResponse);

    String parent = "parent-995424086";

    ListMetastorePartitionsResponse actualResponse = client.listMetastorePartitions(parent);
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockMetastorePartitionService.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    ListMetastorePartitionsRequest actualRequest =
        ((ListMetastorePartitionsRequest) actualRequests.get(0));

    Assert.assertEquals(parent, actualRequest.getParent());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void listMetastorePartitionsExceptionTest2() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockMetastorePartitionService.addException(exception);

    try {
      String parent = "parent-995424086";
      client.listMetastorePartitions(parent);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void streamMetastorePartitionsTest() throws Exception {
    StreamMetastorePartitionsResponse expectedResponse =
        StreamMetastorePartitionsResponse.newBuilder()
            .setTotalPartitionsStreamedCount(-1442980886)
            .setTotalPartitionsInsertedCount(-1900870109)
            .build();
    mockMetastorePartitionService.addResponse(expectedResponse);
    StreamMetastorePartitionsRequest request =
        StreamMetastorePartitionsRequest.newBuilder()
            .setParent(TableName.of("[PROJECT]", "[DATASET]", "[TABLE]").toString())
            .addAllMetastorePartitions(new ArrayList<MetastorePartition>())
            .setSkipExistingPartitions(true)
            .build();

    MockStreamObserver<StreamMetastorePartitionsResponse> responseObserver =
        new MockStreamObserver<>();

    BidiStreamingCallable<StreamMetastorePartitionsRequest, StreamMetastorePartitionsResponse>
        callable = client.streamMetastorePartitionsCallable();
    ApiStreamObserver<StreamMetastorePartitionsRequest> requestObserver =
        callable.bidiStreamingCall(responseObserver);

    requestObserver.onNext(request);
    requestObserver.onCompleted();

    List<StreamMetastorePartitionsResponse> actualResponses = responseObserver.future().get();
    Assert.assertEquals(1, actualResponses.size());
    Assert.assertEquals(expectedResponse, actualResponses.get(0));
  }

  @Test
  public void streamMetastorePartitionsExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockMetastorePartitionService.addException(exception);
    StreamMetastorePartitionsRequest request =
        StreamMetastorePartitionsRequest.newBuilder()
            .setParent(TableName.of("[PROJECT]", "[DATASET]", "[TABLE]").toString())
            .addAllMetastorePartitions(new ArrayList<MetastorePartition>())
            .setSkipExistingPartitions(true)
            .build();

    MockStreamObserver<StreamMetastorePartitionsResponse> responseObserver =
        new MockStreamObserver<>();

    BidiStreamingCallable<StreamMetastorePartitionsRequest, StreamMetastorePartitionsResponse>
        callable = client.streamMetastorePartitionsCallable();
    ApiStreamObserver<StreamMetastorePartitionsRequest> requestObserver =
        callable.bidiStreamingCall(responseObserver);

    requestObserver.onNext(request);

    try {
      List<StreamMetastorePartitionsResponse> actualResponses = responseObserver.future().get();
      Assert.fail("No exception thrown");
    } catch (ExecutionException e) {
      Assert.assertTrue(e.getCause() instanceof InvalidArgumentException);
      InvalidArgumentException apiException = ((InvalidArgumentException) e.getCause());
      Assert.assertEquals(StatusCode.Code.INVALID_ARGUMENT, apiException.getStatusCode().getCode());
    }
  }
}
