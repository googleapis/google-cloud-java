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
package com.google.cloud.datastore.v1;

import com.google.api.gax.core.NoCredentialsProvider;
import com.google.api.gax.grpc.GaxGrpcProperties;
import com.google.api.gax.grpc.testing.LocalChannelProvider;
import com.google.api.gax.grpc.testing.MockGrpcService;
import com.google.api.gax.grpc.testing.MockServiceHelper;
import com.google.api.gax.rpc.ApiClientHeaderProvider;
import com.google.api.gax.rpc.InvalidArgumentException;
import com.google.datastore.v1.AllocateIdsRequest;
import com.google.datastore.v1.AllocateIdsResponse;
import com.google.datastore.v1.BeginTransactionRequest;
import com.google.datastore.v1.BeginTransactionResponse;
import com.google.datastore.v1.CommitRequest;
import com.google.datastore.v1.CommitResponse;
import com.google.datastore.v1.Key;
import com.google.datastore.v1.LookupRequest;
import com.google.datastore.v1.LookupResponse;
import com.google.datastore.v1.Mutation;
import com.google.datastore.v1.ReadOptions;
import com.google.datastore.v1.ReserveIdsRequest;
import com.google.datastore.v1.ReserveIdsResponse;
import com.google.datastore.v1.RollbackRequest;
import com.google.datastore.v1.RollbackResponse;
import com.google.protobuf.ByteString;
import com.google.protobuf.GeneratedMessageV3;
import io.grpc.Status;
import io.grpc.StatusRuntimeException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Assert;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

@javax.annotation.Generated("by GAPIC")
public class DatastoreClientTest {
  private static MockDatastore mockDatastore;
  private static MockServiceHelper serviceHelper;
  private DatastoreClient client;
  private LocalChannelProvider channelProvider;

  @BeforeClass
  public static void startStaticServer() {
    mockDatastore = new MockDatastore();
    serviceHelper =
        new MockServiceHelper("in-process-1", Arrays.<MockGrpcService>asList(mockDatastore));
    serviceHelper.start();
  }

  @AfterClass
  public static void stopServer() {
    serviceHelper.stop();
  }

  @Before
  public void setUp() throws IOException {
    serviceHelper.reset();
    channelProvider = serviceHelper.createChannelProvider();
    DatastoreSettings settings =
        DatastoreSettings.newBuilder()
            .setTransportChannelProvider(channelProvider)
            .setCredentialsProvider(NoCredentialsProvider.create())
            .build();
    client = DatastoreClient.create(settings);
  }

  @After
  public void tearDown() throws Exception {
    client.close();
  }

  @Test
  @SuppressWarnings("all")
  public void lookupTest() {
    LookupResponse expectedResponse = LookupResponse.newBuilder().build();
    mockDatastore.addResponse(expectedResponse);

    String projectId = "projectId-1969970175";
    ReadOptions readOptions = ReadOptions.newBuilder().build();
    List<Key> keys = new ArrayList<>();

    LookupResponse actualResponse = client.lookup(projectId, readOptions, keys);
    Assert.assertEquals(expectedResponse, actualResponse);

    List<GeneratedMessageV3> actualRequests = mockDatastore.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    LookupRequest actualRequest = (LookupRequest) actualRequests.get(0);

    Assert.assertEquals(projectId, actualRequest.getProjectId());
    Assert.assertEquals(readOptions, actualRequest.getReadOptions());
    Assert.assertEquals(keys, actualRequest.getKeysList());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  @SuppressWarnings("all")
  public void lookupExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(Status.INVALID_ARGUMENT);
    mockDatastore.addException(exception);

    try {
      String projectId = "projectId-1969970175";
      ReadOptions readOptions = ReadOptions.newBuilder().build();
      List<Key> keys = new ArrayList<>();

      client.lookup(projectId, readOptions, keys);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception
    }
  }

  @Test
  @SuppressWarnings("all")
  public void beginTransactionTest() {
    ByteString transaction = ByteString.copyFromUtf8("-34");
    BeginTransactionResponse expectedResponse =
        BeginTransactionResponse.newBuilder().setTransaction(transaction).build();
    mockDatastore.addResponse(expectedResponse);

    String projectId = "projectId-1969970175";

    BeginTransactionResponse actualResponse = client.beginTransaction(projectId);
    Assert.assertEquals(expectedResponse, actualResponse);

    List<GeneratedMessageV3> actualRequests = mockDatastore.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    BeginTransactionRequest actualRequest = (BeginTransactionRequest) actualRequests.get(0);

    Assert.assertEquals(projectId, actualRequest.getProjectId());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  @SuppressWarnings("all")
  public void beginTransactionExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(Status.INVALID_ARGUMENT);
    mockDatastore.addException(exception);

    try {
      String projectId = "projectId-1969970175";

      client.beginTransaction(projectId);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception
    }
  }

  @Test
  @SuppressWarnings("all")
  public void commitTest() {
    int indexUpdates = 1425228195;
    CommitResponse expectedResponse =
        CommitResponse.newBuilder().setIndexUpdates(indexUpdates).build();
    mockDatastore.addResponse(expectedResponse);

    String projectId = "projectId-1969970175";
    CommitRequest.Mode mode = CommitRequest.Mode.MODE_UNSPECIFIED;
    ByteString transaction = ByteString.copyFromUtf8("-34");
    List<Mutation> mutations = new ArrayList<>();

    CommitResponse actualResponse = client.commit(projectId, mode, transaction, mutations);
    Assert.assertEquals(expectedResponse, actualResponse);

    List<GeneratedMessageV3> actualRequests = mockDatastore.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    CommitRequest actualRequest = (CommitRequest) actualRequests.get(0);

    Assert.assertEquals(projectId, actualRequest.getProjectId());
    Assert.assertEquals(mode, actualRequest.getMode());
    Assert.assertEquals(transaction, actualRequest.getTransaction());
    Assert.assertEquals(mutations, actualRequest.getMutationsList());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  @SuppressWarnings("all")
  public void commitExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(Status.INVALID_ARGUMENT);
    mockDatastore.addException(exception);

    try {
      String projectId = "projectId-1969970175";
      CommitRequest.Mode mode = CommitRequest.Mode.MODE_UNSPECIFIED;
      ByteString transaction = ByteString.copyFromUtf8("-34");
      List<Mutation> mutations = new ArrayList<>();

      client.commit(projectId, mode, transaction, mutations);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception
    }
  }

  @Test
  @SuppressWarnings("all")
  public void commitTest2() {
    int indexUpdates = 1425228195;
    CommitResponse expectedResponse =
        CommitResponse.newBuilder().setIndexUpdates(indexUpdates).build();
    mockDatastore.addResponse(expectedResponse);

    String projectId = "projectId-1969970175";
    CommitRequest.Mode mode = CommitRequest.Mode.MODE_UNSPECIFIED;
    List<Mutation> mutations = new ArrayList<>();

    CommitResponse actualResponse = client.commit(projectId, mode, mutations);
    Assert.assertEquals(expectedResponse, actualResponse);

    List<GeneratedMessageV3> actualRequests = mockDatastore.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    CommitRequest actualRequest = (CommitRequest) actualRequests.get(0);

    Assert.assertEquals(projectId, actualRequest.getProjectId());
    Assert.assertEquals(mode, actualRequest.getMode());
    Assert.assertEquals(mutations, actualRequest.getMutationsList());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  @SuppressWarnings("all")
  public void commitExceptionTest2() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(Status.INVALID_ARGUMENT);
    mockDatastore.addException(exception);

    try {
      String projectId = "projectId-1969970175";
      CommitRequest.Mode mode = CommitRequest.Mode.MODE_UNSPECIFIED;
      List<Mutation> mutations = new ArrayList<>();

      client.commit(projectId, mode, mutations);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception
    }
  }

  @Test
  @SuppressWarnings("all")
  public void rollbackTest() {
    RollbackResponse expectedResponse = RollbackResponse.newBuilder().build();
    mockDatastore.addResponse(expectedResponse);

    String projectId = "projectId-1969970175";
    ByteString transaction = ByteString.copyFromUtf8("-34");

    RollbackResponse actualResponse = client.rollback(projectId, transaction);
    Assert.assertEquals(expectedResponse, actualResponse);

    List<GeneratedMessageV3> actualRequests = mockDatastore.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    RollbackRequest actualRequest = (RollbackRequest) actualRequests.get(0);

    Assert.assertEquals(projectId, actualRequest.getProjectId());
    Assert.assertEquals(transaction, actualRequest.getTransaction());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  @SuppressWarnings("all")
  public void rollbackExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(Status.INVALID_ARGUMENT);
    mockDatastore.addException(exception);

    try {
      String projectId = "projectId-1969970175";
      ByteString transaction = ByteString.copyFromUtf8("-34");

      client.rollback(projectId, transaction);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception
    }
  }

  @Test
  @SuppressWarnings("all")
  public void allocateIdsTest() {
    AllocateIdsResponse expectedResponse = AllocateIdsResponse.newBuilder().build();
    mockDatastore.addResponse(expectedResponse);

    String projectId = "projectId-1969970175";
    List<Key> keys = new ArrayList<>();

    AllocateIdsResponse actualResponse = client.allocateIds(projectId, keys);
    Assert.assertEquals(expectedResponse, actualResponse);

    List<GeneratedMessageV3> actualRequests = mockDatastore.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    AllocateIdsRequest actualRequest = (AllocateIdsRequest) actualRequests.get(0);

    Assert.assertEquals(projectId, actualRequest.getProjectId());
    Assert.assertEquals(keys, actualRequest.getKeysList());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  @SuppressWarnings("all")
  public void allocateIdsExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(Status.INVALID_ARGUMENT);
    mockDatastore.addException(exception);

    try {
      String projectId = "projectId-1969970175";
      List<Key> keys = new ArrayList<>();

      client.allocateIds(projectId, keys);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception
    }
  }

  @Test
  @SuppressWarnings("all")
  public void reserveIdsTest() {
    ReserveIdsResponse expectedResponse = ReserveIdsResponse.newBuilder().build();
    mockDatastore.addResponse(expectedResponse);

    String projectId = "projectId-1969970175";
    List<Key> keys = new ArrayList<>();

    ReserveIdsResponse actualResponse = client.reserveIds(projectId, keys);
    Assert.assertEquals(expectedResponse, actualResponse);

    List<GeneratedMessageV3> actualRequests = mockDatastore.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    ReserveIdsRequest actualRequest = (ReserveIdsRequest) actualRequests.get(0);

    Assert.assertEquals(projectId, actualRequest.getProjectId());
    Assert.assertEquals(keys, actualRequest.getKeysList());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  @SuppressWarnings("all")
  public void reserveIdsExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(Status.INVALID_ARGUMENT);
    mockDatastore.addException(exception);

    try {
      String projectId = "projectId-1969970175";
      List<Key> keys = new ArrayList<>();

      client.reserveIds(projectId, keys);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception
    }
  }
}
