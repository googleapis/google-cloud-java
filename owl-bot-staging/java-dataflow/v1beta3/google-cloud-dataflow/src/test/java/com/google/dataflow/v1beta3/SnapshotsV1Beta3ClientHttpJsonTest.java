/*
 * Copyright 2022 Google LLC
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

package com.google.dataflow.v1beta3;

import com.google.api.gax.core.NoCredentialsProvider;
import com.google.api.gax.httpjson.GaxHttpJsonProperties;
import com.google.api.gax.httpjson.testing.MockHttpService;
import com.google.api.gax.rpc.ApiClientHeaderProvider;
import com.google.api.gax.rpc.ApiException;
import com.google.api.gax.rpc.ApiExceptionFactory;
import com.google.api.gax.rpc.InvalidArgumentException;
import com.google.api.gax.rpc.StatusCode;
import com.google.api.gax.rpc.testing.FakeStatusCode;
import com.google.dataflow.v1beta3.stub.HttpJsonSnapshotsV1Beta3Stub;
import com.google.protobuf.Duration;
import com.google.protobuf.Timestamp;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.Generated;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Assert;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

@Generated("by gapic-generator-java")
public class SnapshotsV1Beta3ClientHttpJsonTest {
  private static MockHttpService mockService;
  private static SnapshotsV1Beta3Client client;

  @BeforeClass
  public static void startStaticServer() throws IOException {
    mockService =
        new MockHttpService(
            HttpJsonSnapshotsV1Beta3Stub.getMethodDescriptors(),
            SnapshotsV1Beta3Settings.getDefaultEndpoint());
    SnapshotsV1Beta3Settings settings =
        SnapshotsV1Beta3Settings.newHttpJsonBuilder()
            .setTransportChannelProvider(
                SnapshotsV1Beta3Settings.defaultHttpJsonTransportProviderBuilder()
                    .setHttpTransport(mockService)
                    .build())
            .setCredentialsProvider(NoCredentialsProvider.create())
            .build();
    client = SnapshotsV1Beta3Client.create(settings);
  }

  @AfterClass
  public static void stopServer() {
    client.close();
  }

  @Before
  public void setUp() {}

  @After
  public void tearDown() throws Exception {
    mockService.reset();
  }

  @Test
  public void getSnapshotTest() throws Exception {
    Snapshot expectedResponse =
        Snapshot.newBuilder()
            .setId("id3355")
            .setProjectId("projectId-894832108")
            .setSourceJobId("sourceJobId-104191395")
            .setCreationTime(Timestamp.newBuilder().build())
            .setTtl(Duration.newBuilder().build())
            .setState(SnapshotState.forNumber(0))
            .addAllPubsubMetadata(new ArrayList<PubsubSnapshotMetadata>())
            .setDescription("description-1724546052")
            .setDiskSizeBytes(-275393905)
            .setRegion("region-934795532")
            .build();
    mockService.addResponse(expectedResponse);

    GetSnapshotRequest request =
        GetSnapshotRequest.newBuilder()
            .setProjectId("projectId-1530")
            .setSnapshotId("snapshotId-7221")
            .setLocation("location-9355")
            .build();

    Snapshot actualResponse = client.getSnapshot(request);
    Assert.assertEquals(expectedResponse, actualResponse);

    List<String> actualRequests = mockService.getRequestPaths();
    Assert.assertEquals(1, actualRequests.size());

    String apiClientHeaderKey =
        mockService
            .getRequestHeaders()
            .get(ApiClientHeaderProvider.getDefaultApiClientHeaderKey())
            .iterator()
            .next();
    Assert.assertTrue(
        GaxHttpJsonProperties.getDefaultApiClientHeaderPattern()
            .matcher(apiClientHeaderKey)
            .matches());
  }

  @Test
  public void getSnapshotExceptionTest() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

    try {
      GetSnapshotRequest request =
          GetSnapshotRequest.newBuilder()
              .setProjectId("projectId-1530")
              .setSnapshotId("snapshotId-7221")
              .setLocation("location-9355")
              .build();
      client.getSnapshot(request);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void deleteSnapshotTest() throws Exception {
    DeleteSnapshotResponse expectedResponse = DeleteSnapshotResponse.newBuilder().build();
    mockService.addResponse(expectedResponse);

    DeleteSnapshotRequest request =
        DeleteSnapshotRequest.newBuilder()
            .setProjectId("projectId-1530")
            .setSnapshotId("snapshotId-7221")
            .setLocation("location-9355")
            .build();

    DeleteSnapshotResponse actualResponse = client.deleteSnapshot(request);
    Assert.assertEquals(expectedResponse, actualResponse);

    List<String> actualRequests = mockService.getRequestPaths();
    Assert.assertEquals(1, actualRequests.size());

    String apiClientHeaderKey =
        mockService
            .getRequestHeaders()
            .get(ApiClientHeaderProvider.getDefaultApiClientHeaderKey())
            .iterator()
            .next();
    Assert.assertTrue(
        GaxHttpJsonProperties.getDefaultApiClientHeaderPattern()
            .matcher(apiClientHeaderKey)
            .matches());
  }

  @Test
  public void deleteSnapshotExceptionTest() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

    try {
      DeleteSnapshotRequest request =
          DeleteSnapshotRequest.newBuilder()
              .setProjectId("projectId-1530")
              .setSnapshotId("snapshotId-7221")
              .setLocation("location-9355")
              .build();
      client.deleteSnapshot(request);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void listSnapshotsTest() throws Exception {
    ListSnapshotsResponse expectedResponse =
        ListSnapshotsResponse.newBuilder().addAllSnapshots(new ArrayList<Snapshot>()).build();
    mockService.addResponse(expectedResponse);

    ListSnapshotsRequest request =
        ListSnapshotsRequest.newBuilder()
            .setProjectId("projectId-1530")
            .setJobId("jobId-3646")
            .setLocation("location-9355")
            .build();

    ListSnapshotsResponse actualResponse = client.listSnapshots(request);
    Assert.assertEquals(expectedResponse, actualResponse);

    List<String> actualRequests = mockService.getRequestPaths();
    Assert.assertEquals(1, actualRequests.size());

    String apiClientHeaderKey =
        mockService
            .getRequestHeaders()
            .get(ApiClientHeaderProvider.getDefaultApiClientHeaderKey())
            .iterator()
            .next();
    Assert.assertTrue(
        GaxHttpJsonProperties.getDefaultApiClientHeaderPattern()
            .matcher(apiClientHeaderKey)
            .matches());
  }

  @Test
  public void listSnapshotsExceptionTest() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

    try {
      ListSnapshotsRequest request =
          ListSnapshotsRequest.newBuilder()
              .setProjectId("projectId-1530")
              .setJobId("jobId-3646")
              .setLocation("location-9355")
              .build();
      client.listSnapshots(request);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }
}
