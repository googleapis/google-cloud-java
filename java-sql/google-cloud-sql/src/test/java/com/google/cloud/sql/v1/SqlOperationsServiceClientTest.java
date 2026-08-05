/*
 * Copyright 2026 Google LLC
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

package com.google.cloud.sql.v1;

import com.google.api.gax.core.NoCredentialsProvider;
import com.google.api.gax.grpc.GaxGrpcProperties;
import com.google.api.gax.grpc.testing.LocalChannelProvider;
import com.google.api.gax.grpc.testing.MockGrpcService;
import com.google.api.gax.grpc.testing.MockServiceHelper;
import com.google.api.gax.rpc.ApiClientHeaderProvider;
import com.google.api.gax.rpc.InvalidArgumentException;
import com.google.protobuf.AbstractMessage;
import com.google.protobuf.Empty;
import com.google.protobuf.Timestamp;
import io.grpc.StatusRuntimeException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.UUID;
import javax.annotation.Generated;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Assert;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

@Generated("by gapic-generator-java")
public class SqlOperationsServiceClientTest {
  private static MockLocations mockLocations;
  private static MockServiceHelper mockServiceHelper;
  private static MockSqlOperationsService mockSqlOperationsService;
  private LocalChannelProvider channelProvider;
  private SqlOperationsServiceClient client;

  @BeforeClass
  public static void startStaticServer() {
    mockSqlOperationsService = new MockSqlOperationsService();
    mockLocations = new MockLocations();
    mockServiceHelper =
        new MockServiceHelper(
            UUID.randomUUID().toString(),
            Arrays.<MockGrpcService>asList(mockSqlOperationsService, mockLocations));
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
    SqlOperationsServiceSettings settings =
        SqlOperationsServiceSettings.newBuilder()
            .setTransportChannelProvider(channelProvider)
            .setCredentialsProvider(NoCredentialsProvider.create())
            .build();
    client = SqlOperationsServiceClient.create(settings);
  }

  @After
  public void tearDown() throws Exception {
    client.close();
  }

  @Test
  public void getTest() throws Exception {
    Operation expectedResponse =
        Operation.newBuilder()
            .setKind("kind3292052")
            .setTargetLink("targetLink486368555")
            .setUser("user3599307")
            .setInsertTime(Timestamp.newBuilder().build())
            .setStartTime(Timestamp.newBuilder().build())
            .setEndTime(Timestamp.newBuilder().build())
            .setError(OperationErrors.newBuilder().build())
            .setApiWarning(ApiWarning.newBuilder().build())
            .setImportContext(ImportContext.newBuilder().build())
            .setExportContext(ExportContext.newBuilder().build())
            .setBackupContext(BackupContext.newBuilder().build())
            .setPreCheckMajorVersionUpgradeContext(
                PreCheckMajorVersionUpgradeContext.newBuilder().build())
            .setName("name3373707")
            .setTargetId("targetId-441951604")
            .setSelfLink("selfLink1191800166")
            .setTargetProject("targetProject1994636360")
            .setAcquireSsrsLeaseContext(AcquireSsrsLeaseContext.newBuilder().build())
            .setSubOperationType(SqlSubOperationType.newBuilder().build())
            .build();
    mockSqlOperationsService.addResponse(expectedResponse);

    SqlOperationsGetRequest request =
        SqlOperationsGetRequest.newBuilder()
            .setOperation("operation1662702951")
            .setProject("project-309310695")
            .setLocation("location1901043637")
            .build();

    Operation actualResponse = client.get(request);
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockSqlOperationsService.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    SqlOperationsGetRequest actualRequest = ((SqlOperationsGetRequest) actualRequests.get(0));

    Assert.assertEquals(request.getOperation(), actualRequest.getOperation());
    Assert.assertEquals(request.getProject(), actualRequest.getProject());
    Assert.assertEquals(request.getLocation(), actualRequest.getLocation());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void getExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockSqlOperationsService.addException(exception);

    try {
      SqlOperationsGetRequest request =
          SqlOperationsGetRequest.newBuilder()
              .setOperation("operation1662702951")
              .setProject("project-309310695")
              .setLocation("location1901043637")
              .build();
      client.get(request);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void listTest() throws Exception {
    OperationsListResponse expectedResponse =
        OperationsListResponse.newBuilder()
            .setKind("kind3292052")
            .addAllItems(new ArrayList<Operation>())
            .setNextPageToken("nextPageToken-1386094857")
            .build();
    mockSqlOperationsService.addResponse(expectedResponse);

    SqlOperationsListRequest request =
        SqlOperationsListRequest.newBuilder()
            .setInstance("instance555127957")
            .setMaxResults(1128457243)
            .setPageToken("pageToken873572522")
            .setProject("project-309310695")
            .setLocation("location1901043637")
            .build();

    OperationsListResponse actualResponse = client.list(request);
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockSqlOperationsService.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    SqlOperationsListRequest actualRequest = ((SqlOperationsListRequest) actualRequests.get(0));

    Assert.assertEquals(request.getInstance(), actualRequest.getInstance());
    Assert.assertEquals(request.getMaxResults(), actualRequest.getMaxResults());
    Assert.assertEquals(request.getPageToken(), actualRequest.getPageToken());
    Assert.assertEquals(request.getProject(), actualRequest.getProject());
    Assert.assertEquals(request.getLocation(), actualRequest.getLocation());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void listExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockSqlOperationsService.addException(exception);

    try {
      SqlOperationsListRequest request =
          SqlOperationsListRequest.newBuilder()
              .setInstance("instance555127957")
              .setMaxResults(1128457243)
              .setPageToken("pageToken873572522")
              .setProject("project-309310695")
              .setLocation("location1901043637")
              .build();
      client.list(request);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void cancelTest() throws Exception {
    Empty expectedResponse = Empty.newBuilder().build();
    mockSqlOperationsService.addResponse(expectedResponse);

    SqlOperationsCancelRequest request =
        SqlOperationsCancelRequest.newBuilder()
            .setOperation("operation1662702951")
            .setProject("project-309310695")
            .setLocation("location1901043637")
            .build();

    client.cancel(request);

    List<AbstractMessage> actualRequests = mockSqlOperationsService.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    SqlOperationsCancelRequest actualRequest = ((SqlOperationsCancelRequest) actualRequests.get(0));

    Assert.assertEquals(request.getOperation(), actualRequest.getOperation());
    Assert.assertEquals(request.getProject(), actualRequest.getProject());
    Assert.assertEquals(request.getLocation(), actualRequest.getLocation());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void cancelExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockSqlOperationsService.addException(exception);

    try {
      SqlOperationsCancelRequest request =
          SqlOperationsCancelRequest.newBuilder()
              .setOperation("operation1662702951")
              .setProject("project-309310695")
              .setLocation("location1901043637")
              .build();
      client.cancel(request);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }
}
