/*
 * Copyright 2024 Google LLC
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

package com.google.cloud.run.v2;

import com.google.api.gax.core.NoCredentialsProvider;
import com.google.api.gax.grpc.GaxGrpcProperties;
import com.google.api.gax.grpc.testing.LocalChannelProvider;
import com.google.api.gax.grpc.testing.MockGrpcService;
import com.google.api.gax.grpc.testing.MockServiceHelper;
import com.google.api.gax.rpc.ApiClientHeaderProvider;
import com.google.api.gax.rpc.InvalidArgumentException;
import com.google.longrunning.Operation;
import com.google.protobuf.AbstractMessage;
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
public class BuildsClientTest {
  private static MockBuilds mockBuilds;
  private static MockLocations mockLocations;
  private static MockServiceHelper mockServiceHelper;
  private LocalChannelProvider channelProvider;
  private BuildsClient client;

  @BeforeClass
  public static void startStaticServer() {
    mockBuilds = new MockBuilds();
    mockLocations = new MockLocations();
    mockServiceHelper =
        new MockServiceHelper(
            UUID.randomUUID().toString(),
            Arrays.<MockGrpcService>asList(mockBuilds, mockLocations));
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
    BuildsSettings settings =
        BuildsSettings.newBuilder()
            .setTransportChannelProvider(channelProvider)
            .setCredentialsProvider(NoCredentialsProvider.create())
            .build();
    client = BuildsClient.create(settings);
  }

  @After
  public void tearDown() throws Exception {
    client.close();
  }

  @Test
  public void submitBuildTest() throws Exception {
    SubmitBuildResponse expectedResponse =
        SubmitBuildResponse.newBuilder()
            .setBuildOperation(Operation.newBuilder().build())
            .setBaseImageUri("baseImageUri1766091778")
            .setBaseImageWarning("baseImageWarning1724324658")
            .build();
    mockBuilds.addResponse(expectedResponse);

    SubmitBuildRequest request =
        SubmitBuildRequest.newBuilder()
            .setParent("parent-995424086")
            .setImageUri("imageUri-859610607")
            .setServiceAccount("serviceAccount1079137720")
            .setWorkerPool(WorkerPoolName.of("[PROJECT]", "[LOCATION]", "[WORKER_POOL]").toString())
            .addAllTags(new ArrayList<String>())
            .build();

    SubmitBuildResponse actualResponse = client.submitBuild(request);
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockBuilds.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    SubmitBuildRequest actualRequest = ((SubmitBuildRequest) actualRequests.get(0));

    Assert.assertEquals(request.getParent(), actualRequest.getParent());
    Assert.assertEquals(request.getStorageSource(), actualRequest.getStorageSource());
    Assert.assertEquals(request.getImageUri(), actualRequest.getImageUri());
    Assert.assertEquals(request.getBuildpackBuild(), actualRequest.getBuildpackBuild());
    Assert.assertEquals(request.getDockerBuild(), actualRequest.getDockerBuild());
    Assert.assertEquals(request.getServiceAccount(), actualRequest.getServiceAccount());
    Assert.assertEquals(request.getWorkerPool(), actualRequest.getWorkerPool());
    Assert.assertEquals(request.getTagsList(), actualRequest.getTagsList());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void submitBuildExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockBuilds.addException(exception);

    try {
      SubmitBuildRequest request =
          SubmitBuildRequest.newBuilder()
              .setParent("parent-995424086")
              .setImageUri("imageUri-859610607")
              .setServiceAccount("serviceAccount1079137720")
              .setWorkerPool(
                  WorkerPoolName.of("[PROJECT]", "[LOCATION]", "[WORKER_POOL]").toString())
              .addAllTags(new ArrayList<String>())
              .build();
      client.submitBuild(request);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }
}
