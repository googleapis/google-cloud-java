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

package com.google.cloud.discoveryengine.v1;

import com.google.api.gax.core.NoCredentialsProvider;
import com.google.api.gax.grpc.GaxGrpcProperties;
import com.google.api.gax.grpc.testing.LocalChannelProvider;
import com.google.api.gax.grpc.testing.MockGrpcService;
import com.google.api.gax.grpc.testing.MockServiceHelper;
import com.google.api.gax.rpc.ApiClientHeaderProvider;
import com.google.api.gax.rpc.InvalidArgumentException;
import com.google.api.gax.rpc.StatusCode;
import com.google.longrunning.Operation;
import com.google.protobuf.AbstractMessage;
import com.google.protobuf.Any;
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
public class CmekConfigServiceClientTest {
  private static MockCmekConfigService mockCmekConfigService;
  private static MockLocations mockLocations;
  private static MockServiceHelper mockServiceHelper;
  private LocalChannelProvider channelProvider;
  private CmekConfigServiceClient client;

  @BeforeClass
  public static void startStaticServer() {
    mockCmekConfigService = new MockCmekConfigService();
    mockLocations = new MockLocations();
    mockServiceHelper =
        new MockServiceHelper(
            UUID.randomUUID().toString(),
            Arrays.<MockGrpcService>asList(mockCmekConfigService, mockLocations));
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
    CmekConfigServiceSettings settings =
        CmekConfigServiceSettings.newBuilder()
            .setTransportChannelProvider(channelProvider)
            .setCredentialsProvider(NoCredentialsProvider.create())
            .build();
    client = CmekConfigServiceClient.create(settings);
  }

  @After
  public void tearDown() throws Exception {
    client.close();
  }

  @Test
  public void updateCmekConfigTest() throws Exception {
    CmekConfig expectedResponse =
        CmekConfig.newBuilder()
            .setName(CmekConfigName.ofProjectLocationName("[PROJECT]", "[LOCATION]").toString())
            .setKmsKey("kmsKey-1127483058")
            .setKmsKeyVersion("kmsKeyVersion2084784042")
            .setIsDefault(true)
            .setLastRotationTimestampMicros(-1869978704)
            .addAllSingleRegionKeys(new ArrayList<SingleRegionKey>())
            .build();
    Operation resultOperation =
        Operation.newBuilder()
            .setName("updateCmekConfigTest")
            .setDone(true)
            .setResponse(Any.pack(expectedResponse))
            .build();
    mockCmekConfigService.addResponse(resultOperation);

    CmekConfig config = CmekConfig.newBuilder().build();

    CmekConfig actualResponse = client.updateCmekConfigAsync(config).get();
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockCmekConfigService.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    UpdateCmekConfigRequest actualRequest = ((UpdateCmekConfigRequest) actualRequests.get(0));

    Assert.assertEquals(config, actualRequest.getConfig());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void updateCmekConfigExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockCmekConfigService.addException(exception);

    try {
      CmekConfig config = CmekConfig.newBuilder().build();
      client.updateCmekConfigAsync(config).get();
      Assert.fail("No exception raised");
    } catch (ExecutionException e) {
      Assert.assertEquals(InvalidArgumentException.class, e.getCause().getClass());
      InvalidArgumentException apiException = ((InvalidArgumentException) e.getCause());
      Assert.assertEquals(StatusCode.Code.INVALID_ARGUMENT, apiException.getStatusCode().getCode());
    }
  }

  @Test
  public void getCmekConfigTest() throws Exception {
    CmekConfig expectedResponse =
        CmekConfig.newBuilder()
            .setName(CmekConfigName.ofProjectLocationName("[PROJECT]", "[LOCATION]").toString())
            .setKmsKey("kmsKey-1127483058")
            .setKmsKeyVersion("kmsKeyVersion2084784042")
            .setIsDefault(true)
            .setLastRotationTimestampMicros(-1869978704)
            .addAllSingleRegionKeys(new ArrayList<SingleRegionKey>())
            .build();
    mockCmekConfigService.addResponse(expectedResponse);

    CmekConfigName name = CmekConfigName.ofProjectLocationName("[PROJECT]", "[LOCATION]");

    CmekConfig actualResponse = client.getCmekConfig(name);
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockCmekConfigService.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    GetCmekConfigRequest actualRequest = ((GetCmekConfigRequest) actualRequests.get(0));

    Assert.assertEquals(name.toString(), actualRequest.getName());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void getCmekConfigExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockCmekConfigService.addException(exception);

    try {
      CmekConfigName name = CmekConfigName.ofProjectLocationName("[PROJECT]", "[LOCATION]");
      client.getCmekConfig(name);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void getCmekConfigTest2() throws Exception {
    CmekConfig expectedResponse =
        CmekConfig.newBuilder()
            .setName(CmekConfigName.ofProjectLocationName("[PROJECT]", "[LOCATION]").toString())
            .setKmsKey("kmsKey-1127483058")
            .setKmsKeyVersion("kmsKeyVersion2084784042")
            .setIsDefault(true)
            .setLastRotationTimestampMicros(-1869978704)
            .addAllSingleRegionKeys(new ArrayList<SingleRegionKey>())
            .build();
    mockCmekConfigService.addResponse(expectedResponse);

    String name = "name3373707";

    CmekConfig actualResponse = client.getCmekConfig(name);
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockCmekConfigService.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    GetCmekConfigRequest actualRequest = ((GetCmekConfigRequest) actualRequests.get(0));

    Assert.assertEquals(name, actualRequest.getName());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void getCmekConfigExceptionTest2() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockCmekConfigService.addException(exception);

    try {
      String name = "name3373707";
      client.getCmekConfig(name);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void listCmekConfigsTest() throws Exception {
    ListCmekConfigsResponse expectedResponse =
        ListCmekConfigsResponse.newBuilder().addAllCmekConfigs(new ArrayList<CmekConfig>()).build();
    mockCmekConfigService.addResponse(expectedResponse);

    LocationName parent = LocationName.of("[PROJECT]", "[LOCATION]");

    ListCmekConfigsResponse actualResponse = client.listCmekConfigs(parent);
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockCmekConfigService.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    ListCmekConfigsRequest actualRequest = ((ListCmekConfigsRequest) actualRequests.get(0));

    Assert.assertEquals(parent.toString(), actualRequest.getParent());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void listCmekConfigsExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockCmekConfigService.addException(exception);

    try {
      LocationName parent = LocationName.of("[PROJECT]", "[LOCATION]");
      client.listCmekConfigs(parent);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void listCmekConfigsTest2() throws Exception {
    ListCmekConfigsResponse expectedResponse =
        ListCmekConfigsResponse.newBuilder().addAllCmekConfigs(new ArrayList<CmekConfig>()).build();
    mockCmekConfigService.addResponse(expectedResponse);

    String parent = "parent-995424086";

    ListCmekConfigsResponse actualResponse = client.listCmekConfigs(parent);
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockCmekConfigService.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    ListCmekConfigsRequest actualRequest = ((ListCmekConfigsRequest) actualRequests.get(0));

    Assert.assertEquals(parent, actualRequest.getParent());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void listCmekConfigsExceptionTest2() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockCmekConfigService.addException(exception);

    try {
      String parent = "parent-995424086";
      client.listCmekConfigs(parent);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void deleteCmekConfigTest() throws Exception {
    Empty expectedResponse = Empty.newBuilder().build();
    Operation resultOperation =
        Operation.newBuilder()
            .setName("deleteCmekConfigTest")
            .setDone(true)
            .setResponse(Any.pack(expectedResponse))
            .build();
    mockCmekConfigService.addResponse(resultOperation);

    CmekConfigName name =
        CmekConfigName.ofProjectLocationCmekConfigName("[PROJECT]", "[LOCATION]", "[CMEK_CONFIG]");

    client.deleteCmekConfigAsync(name).get();

    List<AbstractMessage> actualRequests = mockCmekConfigService.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    DeleteCmekConfigRequest actualRequest = ((DeleteCmekConfigRequest) actualRequests.get(0));

    Assert.assertEquals(name.toString(), actualRequest.getName());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void deleteCmekConfigExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockCmekConfigService.addException(exception);

    try {
      CmekConfigName name =
          CmekConfigName.ofProjectLocationCmekConfigName(
              "[PROJECT]", "[LOCATION]", "[CMEK_CONFIG]");
      client.deleteCmekConfigAsync(name).get();
      Assert.fail("No exception raised");
    } catch (ExecutionException e) {
      Assert.assertEquals(InvalidArgumentException.class, e.getCause().getClass());
      InvalidArgumentException apiException = ((InvalidArgumentException) e.getCause());
      Assert.assertEquals(StatusCode.Code.INVALID_ARGUMENT, apiException.getStatusCode().getCode());
    }
  }

  @Test
  public void deleteCmekConfigTest2() throws Exception {
    Empty expectedResponse = Empty.newBuilder().build();
    Operation resultOperation =
        Operation.newBuilder()
            .setName("deleteCmekConfigTest")
            .setDone(true)
            .setResponse(Any.pack(expectedResponse))
            .build();
    mockCmekConfigService.addResponse(resultOperation);

    String name = "name3373707";

    client.deleteCmekConfigAsync(name).get();

    List<AbstractMessage> actualRequests = mockCmekConfigService.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    DeleteCmekConfigRequest actualRequest = ((DeleteCmekConfigRequest) actualRequests.get(0));

    Assert.assertEquals(name, actualRequest.getName());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void deleteCmekConfigExceptionTest2() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockCmekConfigService.addException(exception);

    try {
      String name = "name3373707";
      client.deleteCmekConfigAsync(name).get();
      Assert.fail("No exception raised");
    } catch (ExecutionException e) {
      Assert.assertEquals(InvalidArgumentException.class, e.getCause().getClass());
      InvalidArgumentException apiException = ((InvalidArgumentException) e.getCause());
      Assert.assertEquals(StatusCode.Code.INVALID_ARGUMENT, apiException.getStatusCode().getCode());
    }
  }
}
