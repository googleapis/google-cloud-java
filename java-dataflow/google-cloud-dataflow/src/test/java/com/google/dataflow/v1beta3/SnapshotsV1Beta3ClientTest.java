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
import com.google.api.gax.grpc.GaxGrpcProperties;
import com.google.api.gax.grpc.testing.LocalChannelProvider;
import com.google.api.gax.grpc.testing.MockGrpcService;
import com.google.api.gax.grpc.testing.MockServiceHelper;
import com.google.api.gax.rpc.ApiClientHeaderProvider;
import com.google.api.gax.rpc.InvalidArgumentException;
import com.google.protobuf.AbstractMessage;
import com.google.protobuf.Duration;
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
public class SnapshotsV1Beta3ClientTest {
  private static MockServiceHelper mockServiceHelper;
  private static MockSnapshotsV1Beta3 mockSnapshotsV1Beta3;
  private LocalChannelProvider channelProvider;
  private SnapshotsV1Beta3Client client;

  @BeforeClass
  public static void startStaticServer() {
    mockSnapshotsV1Beta3 = new MockSnapshotsV1Beta3();
    mockServiceHelper =
        new MockServiceHelper(
            UUID.randomUUID().toString(), Arrays.<MockGrpcService>asList(mockSnapshotsV1Beta3));
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
    SnapshotsV1Beta3Settings settings =
        SnapshotsV1Beta3Settings.newBuilder()
            .setTransportChannelProvider(channelProvider)
            .setCredentialsProvider(NoCredentialsProvider.create())
            .build();
    client = SnapshotsV1Beta3Client.create(settings);
  }

  @After
  public void tearDown() throws Exception {
    client.close();
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
    mockSnapshotsV1Beta3.addResponse(expectedResponse);

    GetSnapshotRequest request =
        GetSnapshotRequest.newBuilder()
            .setProjectId("projectId-894832108")
            .setSnapshotId("snapshotId-1113817601")
            .setLocation("location1901043637")
            .build();

    Snapshot actualResponse = client.getSnapshot(request);
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockSnapshotsV1Beta3.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    GetSnapshotRequest actualRequest = ((GetSnapshotRequest) actualRequests.get(0));

    Assert.assertEquals(request.getProjectId(), actualRequest.getProjectId());
    Assert.assertEquals(request.getSnapshotId(), actualRequest.getSnapshotId());
    Assert.assertEquals(request.getLocation(), actualRequest.getLocation());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void getSnapshotExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockSnapshotsV1Beta3.addException(exception);

    try {
      GetSnapshotRequest request =
          GetSnapshotRequest.newBuilder()
              .setProjectId("projectId-894832108")
              .setSnapshotId("snapshotId-1113817601")
              .setLocation("location1901043637")
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
    mockSnapshotsV1Beta3.addResponse(expectedResponse);

    DeleteSnapshotRequest request =
        DeleteSnapshotRequest.newBuilder()
            .setProjectId("projectId-894832108")
            .setSnapshotId("snapshotId-1113817601")
            .setLocation("location1901043637")
            .build();

    DeleteSnapshotResponse actualResponse = client.deleteSnapshot(request);
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockSnapshotsV1Beta3.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    DeleteSnapshotRequest actualRequest = ((DeleteSnapshotRequest) actualRequests.get(0));

    Assert.assertEquals(request.getProjectId(), actualRequest.getProjectId());
    Assert.assertEquals(request.getSnapshotId(), actualRequest.getSnapshotId());
    Assert.assertEquals(request.getLocation(), actualRequest.getLocation());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void deleteSnapshotExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockSnapshotsV1Beta3.addException(exception);

    try {
      DeleteSnapshotRequest request =
          DeleteSnapshotRequest.newBuilder()
              .setProjectId("projectId-894832108")
              .setSnapshotId("snapshotId-1113817601")
              .setLocation("location1901043637")
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
    mockSnapshotsV1Beta3.addResponse(expectedResponse);

    ListSnapshotsRequest request =
        ListSnapshotsRequest.newBuilder()
            .setProjectId("projectId-894832108")
            .setJobId("jobId101296568")
            .setLocation("location1901043637")
            .build();

    ListSnapshotsResponse actualResponse = client.listSnapshots(request);
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockSnapshotsV1Beta3.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    ListSnapshotsRequest actualRequest = ((ListSnapshotsRequest) actualRequests.get(0));

    Assert.assertEquals(request.getProjectId(), actualRequest.getProjectId());
    Assert.assertEquals(request.getJobId(), actualRequest.getJobId());
    Assert.assertEquals(request.getLocation(), actualRequest.getLocation());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void listSnapshotsExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockSnapshotsV1Beta3.addException(exception);

    try {
      ListSnapshotsRequest request =
          ListSnapshotsRequest.newBuilder()
              .setProjectId("projectId-894832108")
              .setJobId("jobId101296568")
              .setLocation("location1901043637")
              .build();
      client.listSnapshots(request);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }
}
