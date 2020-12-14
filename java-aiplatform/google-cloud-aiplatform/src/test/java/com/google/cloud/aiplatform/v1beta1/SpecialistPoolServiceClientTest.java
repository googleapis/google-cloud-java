/*
 * Copyright 2020 Google LLC
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

package com.google.cloud.aiplatform.v1beta1;

import static com.google.cloud.aiplatform.v1beta1.SpecialistPoolServiceClient.ListSpecialistPoolsPagedResponse;

import com.google.api.gax.core.NoCredentialsProvider;
import com.google.api.gax.grpc.GaxGrpcProperties;
import com.google.api.gax.grpc.testing.LocalChannelProvider;
import com.google.api.gax.grpc.testing.MockGrpcService;
import com.google.api.gax.grpc.testing.MockServiceHelper;
import com.google.api.gax.rpc.ApiClientHeaderProvider;
import com.google.api.gax.rpc.InvalidArgumentException;
import com.google.api.gax.rpc.StatusCode;
import com.google.common.collect.Lists;
import com.google.longrunning.Operation;
import com.google.protobuf.AbstractMessage;
import com.google.protobuf.Any;
import com.google.protobuf.Empty;
import com.google.protobuf.FieldMask;
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
public class SpecialistPoolServiceClientTest {
  private static MockServiceHelper mockServiceHelper;
  private SpecialistPoolServiceClient client;
  private static MockSpecialistPoolService mockSpecialistPoolService;
  private LocalChannelProvider channelProvider;

  @BeforeClass
  public static void startStaticServer() {
    mockSpecialistPoolService = new MockSpecialistPoolService();
    mockServiceHelper =
        new MockServiceHelper(
            UUID.randomUUID().toString(),
            Arrays.<MockGrpcService>asList(mockSpecialistPoolService));
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
    SpecialistPoolServiceSettings settings =
        SpecialistPoolServiceSettings.newBuilder()
            .setTransportChannelProvider(channelProvider)
            .setCredentialsProvider(NoCredentialsProvider.create())
            .build();
    client = SpecialistPoolServiceClient.create(settings);
  }

  @After
  public void tearDown() throws Exception {
    client.close();
  }

  @Test
  public void createSpecialistPoolTest() throws Exception {
    SpecialistPool expectedResponse =
        SpecialistPool.newBuilder()
            .setName(
                SpecialistPoolName.of("[PROJECT]", "[LOCATION]", "[SPECIALIST_POOL]").toString())
            .setDisplayName("displayName1714148973")
            .setSpecialistManagersCount(-984151356)
            .addAllSpecialistManagerEmails(new ArrayList<String>())
            .addAllPendingDataLabelingJobs(new ArrayList<String>())
            .build();
    Operation resultOperation =
        Operation.newBuilder()
            .setName("createSpecialistPoolTest")
            .setDone(true)
            .setResponse(Any.pack(expectedResponse))
            .build();
    mockSpecialistPoolService.addResponse(resultOperation);

    LocationName parent = LocationName.of("[PROJECT]", "[LOCATION]");
    SpecialistPool specialistPool = SpecialistPool.newBuilder().build();

    SpecialistPool actualResponse = client.createSpecialistPoolAsync(parent, specialistPool).get();
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockSpecialistPoolService.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    CreateSpecialistPoolRequest actualRequest =
        ((CreateSpecialistPoolRequest) actualRequests.get(0));

    Assert.assertEquals(parent.toString(), actualRequest.getParent());
    Assert.assertEquals(specialistPool, actualRequest.getSpecialistPool());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void createSpecialistPoolExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockSpecialistPoolService.addException(exception);

    try {
      LocationName parent = LocationName.of("[PROJECT]", "[LOCATION]");
      SpecialistPool specialistPool = SpecialistPool.newBuilder().build();
      client.createSpecialistPoolAsync(parent, specialistPool).get();
      Assert.fail("No exception raised");
    } catch (ExecutionException e) {
      Assert.assertEquals(InvalidArgumentException.class, e.getCause().getClass());
      InvalidArgumentException apiException = ((InvalidArgumentException) e.getCause());
      Assert.assertEquals(StatusCode.Code.INVALID_ARGUMENT, apiException.getStatusCode().getCode());
    }
  }

  @Test
  public void createSpecialistPoolTest2() throws Exception {
    SpecialistPool expectedResponse =
        SpecialistPool.newBuilder()
            .setName(
                SpecialistPoolName.of("[PROJECT]", "[LOCATION]", "[SPECIALIST_POOL]").toString())
            .setDisplayName("displayName1714148973")
            .setSpecialistManagersCount(-984151356)
            .addAllSpecialistManagerEmails(new ArrayList<String>())
            .addAllPendingDataLabelingJobs(new ArrayList<String>())
            .build();
    Operation resultOperation =
        Operation.newBuilder()
            .setName("createSpecialistPoolTest")
            .setDone(true)
            .setResponse(Any.pack(expectedResponse))
            .build();
    mockSpecialistPoolService.addResponse(resultOperation);

    String parent = "parent-995424086";
    SpecialistPool specialistPool = SpecialistPool.newBuilder().build();

    SpecialistPool actualResponse = client.createSpecialistPoolAsync(parent, specialistPool).get();
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockSpecialistPoolService.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    CreateSpecialistPoolRequest actualRequest =
        ((CreateSpecialistPoolRequest) actualRequests.get(0));

    Assert.assertEquals(parent, actualRequest.getParent());
    Assert.assertEquals(specialistPool, actualRequest.getSpecialistPool());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void createSpecialistPoolExceptionTest2() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockSpecialistPoolService.addException(exception);

    try {
      String parent = "parent-995424086";
      SpecialistPool specialistPool = SpecialistPool.newBuilder().build();
      client.createSpecialistPoolAsync(parent, specialistPool).get();
      Assert.fail("No exception raised");
    } catch (ExecutionException e) {
      Assert.assertEquals(InvalidArgumentException.class, e.getCause().getClass());
      InvalidArgumentException apiException = ((InvalidArgumentException) e.getCause());
      Assert.assertEquals(StatusCode.Code.INVALID_ARGUMENT, apiException.getStatusCode().getCode());
    }
  }

  @Test
  public void getSpecialistPoolTest() throws Exception {
    SpecialistPool expectedResponse =
        SpecialistPool.newBuilder()
            .setName(
                SpecialistPoolName.of("[PROJECT]", "[LOCATION]", "[SPECIALIST_POOL]").toString())
            .setDisplayName("displayName1714148973")
            .setSpecialistManagersCount(-984151356)
            .addAllSpecialistManagerEmails(new ArrayList<String>())
            .addAllPendingDataLabelingJobs(new ArrayList<String>())
            .build();
    mockSpecialistPoolService.addResponse(expectedResponse);

    SpecialistPoolName name = SpecialistPoolName.of("[PROJECT]", "[LOCATION]", "[SPECIALIST_POOL]");

    SpecialistPool actualResponse = client.getSpecialistPool(name);
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockSpecialistPoolService.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    GetSpecialistPoolRequest actualRequest = ((GetSpecialistPoolRequest) actualRequests.get(0));

    Assert.assertEquals(name.toString(), actualRequest.getName());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void getSpecialistPoolExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockSpecialistPoolService.addException(exception);

    try {
      SpecialistPoolName name =
          SpecialistPoolName.of("[PROJECT]", "[LOCATION]", "[SPECIALIST_POOL]");
      client.getSpecialistPool(name);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void getSpecialistPoolTest2() throws Exception {
    SpecialistPool expectedResponse =
        SpecialistPool.newBuilder()
            .setName(
                SpecialistPoolName.of("[PROJECT]", "[LOCATION]", "[SPECIALIST_POOL]").toString())
            .setDisplayName("displayName1714148973")
            .setSpecialistManagersCount(-984151356)
            .addAllSpecialistManagerEmails(new ArrayList<String>())
            .addAllPendingDataLabelingJobs(new ArrayList<String>())
            .build();
    mockSpecialistPoolService.addResponse(expectedResponse);

    String name = "name3373707";

    SpecialistPool actualResponse = client.getSpecialistPool(name);
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockSpecialistPoolService.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    GetSpecialistPoolRequest actualRequest = ((GetSpecialistPoolRequest) actualRequests.get(0));

    Assert.assertEquals(name, actualRequest.getName());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void getSpecialistPoolExceptionTest2() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockSpecialistPoolService.addException(exception);

    try {
      String name = "name3373707";
      client.getSpecialistPool(name);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void listSpecialistPoolsTest() throws Exception {
    SpecialistPool responsesElement = SpecialistPool.newBuilder().build();
    ListSpecialistPoolsResponse expectedResponse =
        ListSpecialistPoolsResponse.newBuilder()
            .setNextPageToken("")
            .addAllSpecialistPools(Arrays.asList(responsesElement))
            .build();
    mockSpecialistPoolService.addResponse(expectedResponse);

    LocationName parent = LocationName.of("[PROJECT]", "[LOCATION]");

    ListSpecialistPoolsPagedResponse pagedListResponse = client.listSpecialistPools(parent);

    List<SpecialistPool> resources = Lists.newArrayList(pagedListResponse.iterateAll());

    Assert.assertEquals(1, resources.size());
    Assert.assertEquals(expectedResponse.getSpecialistPoolsList().get(0), resources.get(0));

    List<AbstractMessage> actualRequests = mockSpecialistPoolService.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    ListSpecialistPoolsRequest actualRequest = ((ListSpecialistPoolsRequest) actualRequests.get(0));

    Assert.assertEquals(parent.toString(), actualRequest.getParent());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void listSpecialistPoolsExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockSpecialistPoolService.addException(exception);

    try {
      LocationName parent = LocationName.of("[PROJECT]", "[LOCATION]");
      client.listSpecialistPools(parent);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void listSpecialistPoolsTest2() throws Exception {
    SpecialistPool responsesElement = SpecialistPool.newBuilder().build();
    ListSpecialistPoolsResponse expectedResponse =
        ListSpecialistPoolsResponse.newBuilder()
            .setNextPageToken("")
            .addAllSpecialistPools(Arrays.asList(responsesElement))
            .build();
    mockSpecialistPoolService.addResponse(expectedResponse);

    String parent = "parent-995424086";

    ListSpecialistPoolsPagedResponse pagedListResponse = client.listSpecialistPools(parent);

    List<SpecialistPool> resources = Lists.newArrayList(pagedListResponse.iterateAll());

    Assert.assertEquals(1, resources.size());
    Assert.assertEquals(expectedResponse.getSpecialistPoolsList().get(0), resources.get(0));

    List<AbstractMessage> actualRequests = mockSpecialistPoolService.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    ListSpecialistPoolsRequest actualRequest = ((ListSpecialistPoolsRequest) actualRequests.get(0));

    Assert.assertEquals(parent, actualRequest.getParent());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void listSpecialistPoolsExceptionTest2() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockSpecialistPoolService.addException(exception);

    try {
      String parent = "parent-995424086";
      client.listSpecialistPools(parent);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void deleteSpecialistPoolTest() throws Exception {
    Empty expectedResponse = Empty.newBuilder().build();
    Operation resultOperation =
        Operation.newBuilder()
            .setName("deleteSpecialistPoolTest")
            .setDone(true)
            .setResponse(Any.pack(expectedResponse))
            .build();
    mockSpecialistPoolService.addResponse(resultOperation);

    SpecialistPoolName name = SpecialistPoolName.of("[PROJECT]", "[LOCATION]", "[SPECIALIST_POOL]");

    client.deleteSpecialistPoolAsync(name).get();

    List<AbstractMessage> actualRequests = mockSpecialistPoolService.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    DeleteSpecialistPoolRequest actualRequest =
        ((DeleteSpecialistPoolRequest) actualRequests.get(0));

    Assert.assertEquals(name.toString(), actualRequest.getName());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void deleteSpecialistPoolExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockSpecialistPoolService.addException(exception);

    try {
      SpecialistPoolName name =
          SpecialistPoolName.of("[PROJECT]", "[LOCATION]", "[SPECIALIST_POOL]");
      client.deleteSpecialistPoolAsync(name).get();
      Assert.fail("No exception raised");
    } catch (ExecutionException e) {
      Assert.assertEquals(InvalidArgumentException.class, e.getCause().getClass());
      InvalidArgumentException apiException = ((InvalidArgumentException) e.getCause());
      Assert.assertEquals(StatusCode.Code.INVALID_ARGUMENT, apiException.getStatusCode().getCode());
    }
  }

  @Test
  public void deleteSpecialistPoolTest2() throws Exception {
    Empty expectedResponse = Empty.newBuilder().build();
    Operation resultOperation =
        Operation.newBuilder()
            .setName("deleteSpecialistPoolTest")
            .setDone(true)
            .setResponse(Any.pack(expectedResponse))
            .build();
    mockSpecialistPoolService.addResponse(resultOperation);

    String name = "name3373707";

    client.deleteSpecialistPoolAsync(name).get();

    List<AbstractMessage> actualRequests = mockSpecialistPoolService.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    DeleteSpecialistPoolRequest actualRequest =
        ((DeleteSpecialistPoolRequest) actualRequests.get(0));

    Assert.assertEquals(name, actualRequest.getName());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void deleteSpecialistPoolExceptionTest2() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockSpecialistPoolService.addException(exception);

    try {
      String name = "name3373707";
      client.deleteSpecialistPoolAsync(name).get();
      Assert.fail("No exception raised");
    } catch (ExecutionException e) {
      Assert.assertEquals(InvalidArgumentException.class, e.getCause().getClass());
      InvalidArgumentException apiException = ((InvalidArgumentException) e.getCause());
      Assert.assertEquals(StatusCode.Code.INVALID_ARGUMENT, apiException.getStatusCode().getCode());
    }
  }

  @Test
  public void updateSpecialistPoolTest() throws Exception {
    SpecialistPool expectedResponse =
        SpecialistPool.newBuilder()
            .setName(
                SpecialistPoolName.of("[PROJECT]", "[LOCATION]", "[SPECIALIST_POOL]").toString())
            .setDisplayName("displayName1714148973")
            .setSpecialistManagersCount(-984151356)
            .addAllSpecialistManagerEmails(new ArrayList<String>())
            .addAllPendingDataLabelingJobs(new ArrayList<String>())
            .build();
    Operation resultOperation =
        Operation.newBuilder()
            .setName("updateSpecialistPoolTest")
            .setDone(true)
            .setResponse(Any.pack(expectedResponse))
            .build();
    mockSpecialistPoolService.addResponse(resultOperation);

    SpecialistPool specialistPool = SpecialistPool.newBuilder().build();
    FieldMask updateMask = FieldMask.newBuilder().build();

    SpecialistPool actualResponse =
        client.updateSpecialistPoolAsync(specialistPool, updateMask).get();
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockSpecialistPoolService.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    UpdateSpecialistPoolRequest actualRequest =
        ((UpdateSpecialistPoolRequest) actualRequests.get(0));

    Assert.assertEquals(specialistPool, actualRequest.getSpecialistPool());
    Assert.assertEquals(updateMask, actualRequest.getUpdateMask());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void updateSpecialistPoolExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockSpecialistPoolService.addException(exception);

    try {
      SpecialistPool specialistPool = SpecialistPool.newBuilder().build();
      FieldMask updateMask = FieldMask.newBuilder().build();
      client.updateSpecialistPoolAsync(specialistPool, updateMask).get();
      Assert.fail("No exception raised");
    } catch (ExecutionException e) {
      Assert.assertEquals(InvalidArgumentException.class, e.getCause().getClass());
      InvalidArgumentException apiException = ((InvalidArgumentException) e.getCause());
      Assert.assertEquals(StatusCode.Code.INVALID_ARGUMENT, apiException.getStatusCode().getCode());
    }
  }
}
