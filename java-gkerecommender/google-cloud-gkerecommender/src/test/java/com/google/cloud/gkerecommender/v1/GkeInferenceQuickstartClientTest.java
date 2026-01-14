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

package com.google.cloud.gkerecommender.v1;

import static com.google.cloud.gkerecommender.v1.GkeInferenceQuickstartClient.FetchModelServerVersionsPagedResponse;
import static com.google.cloud.gkerecommender.v1.GkeInferenceQuickstartClient.FetchModelServersPagedResponse;
import static com.google.cloud.gkerecommender.v1.GkeInferenceQuickstartClient.FetchModelsPagedResponse;
import static com.google.cloud.gkerecommender.v1.GkeInferenceQuickstartClient.FetchProfilesPagedResponse;

import com.google.api.gax.core.NoCredentialsProvider;
import com.google.api.gax.grpc.GaxGrpcProperties;
import com.google.api.gax.grpc.testing.LocalChannelProvider;
import com.google.api.gax.grpc.testing.MockGrpcService;
import com.google.api.gax.grpc.testing.MockServiceHelper;
import com.google.api.gax.rpc.ApiClientHeaderProvider;
import com.google.api.gax.rpc.InvalidArgumentException;
import com.google.common.collect.Lists;
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
public class GkeInferenceQuickstartClientTest {
  private static MockGkeInferenceQuickstart mockGkeInferenceQuickstart;
  private static MockServiceHelper mockServiceHelper;
  private LocalChannelProvider channelProvider;
  private GkeInferenceQuickstartClient client;

  @BeforeClass
  public static void startStaticServer() {
    mockGkeInferenceQuickstart = new MockGkeInferenceQuickstart();
    mockServiceHelper =
        new MockServiceHelper(
            UUID.randomUUID().toString(),
            Arrays.<MockGrpcService>asList(mockGkeInferenceQuickstart));
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
    GkeInferenceQuickstartSettings settings =
        GkeInferenceQuickstartSettings.newBuilder()
            .setTransportChannelProvider(channelProvider)
            .setCredentialsProvider(NoCredentialsProvider.create())
            .build();
    client = GkeInferenceQuickstartClient.create(settings);
  }

  @After
  public void tearDown() throws Exception {
    client.close();
  }

  @Test
  public void fetchModelsTest() throws Exception {
    String responsesElement = "responsesElement-318365110";
    FetchModelsResponse expectedResponse =
        FetchModelsResponse.newBuilder()
            .setNextPageToken("")
            .addAllModels(Arrays.asList(responsesElement))
            .build();
    mockGkeInferenceQuickstart.addResponse(expectedResponse);

    FetchModelsRequest request =
        FetchModelsRequest.newBuilder()
            .setPageSize(883849137)
            .setPageToken("pageToken873572522")
            .build();

    FetchModelsPagedResponse pagedListResponse = client.fetchModels(request);

    List<String> resources = Lists.newArrayList(pagedListResponse.iterateAll());

    Assert.assertEquals(1, resources.size());
    Assert.assertEquals(expectedResponse.getModelsList().get(0), resources.get(0));

    List<AbstractMessage> actualRequests = mockGkeInferenceQuickstart.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    FetchModelsRequest actualRequest = ((FetchModelsRequest) actualRequests.get(0));

    Assert.assertEquals(request.getPageSize(), actualRequest.getPageSize());
    Assert.assertEquals(request.getPageToken(), actualRequest.getPageToken());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void fetchModelsExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockGkeInferenceQuickstart.addException(exception);

    try {
      FetchModelsRequest request =
          FetchModelsRequest.newBuilder()
              .setPageSize(883849137)
              .setPageToken("pageToken873572522")
              .build();
      client.fetchModels(request);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void fetchModelServersTest() throws Exception {
    String responsesElement = "responsesElement-318365110";
    FetchModelServersResponse expectedResponse =
        FetchModelServersResponse.newBuilder()
            .setNextPageToken("")
            .addAllModelServers(Arrays.asList(responsesElement))
            .build();
    mockGkeInferenceQuickstart.addResponse(expectedResponse);

    FetchModelServersRequest request =
        FetchModelServersRequest.newBuilder()
            .setModel("model104069929")
            .setPageSize(883849137)
            .setPageToken("pageToken873572522")
            .build();

    FetchModelServersPagedResponse pagedListResponse = client.fetchModelServers(request);

    List<String> resources = Lists.newArrayList(pagedListResponse.iterateAll());

    Assert.assertEquals(1, resources.size());
    Assert.assertEquals(expectedResponse.getModelServersList().get(0), resources.get(0));

    List<AbstractMessage> actualRequests = mockGkeInferenceQuickstart.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    FetchModelServersRequest actualRequest = ((FetchModelServersRequest) actualRequests.get(0));

    Assert.assertEquals(request.getModel(), actualRequest.getModel());
    Assert.assertEquals(request.getPageSize(), actualRequest.getPageSize());
    Assert.assertEquals(request.getPageToken(), actualRequest.getPageToken());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void fetchModelServersExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockGkeInferenceQuickstart.addException(exception);

    try {
      FetchModelServersRequest request =
          FetchModelServersRequest.newBuilder()
              .setModel("model104069929")
              .setPageSize(883849137)
              .setPageToken("pageToken873572522")
              .build();
      client.fetchModelServers(request);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void fetchModelServerVersionsTest() throws Exception {
    String responsesElement = "responsesElement-318365110";
    FetchModelServerVersionsResponse expectedResponse =
        FetchModelServerVersionsResponse.newBuilder()
            .setNextPageToken("")
            .addAllModelServerVersions(Arrays.asList(responsesElement))
            .build();
    mockGkeInferenceQuickstart.addResponse(expectedResponse);

    FetchModelServerVersionsRequest request =
        FetchModelServerVersionsRequest.newBuilder()
            .setModel("model104069929")
            .setModelServer("modelServer475157452")
            .setPageSize(883849137)
            .setPageToken("pageToken873572522")
            .build();

    FetchModelServerVersionsPagedResponse pagedListResponse =
        client.fetchModelServerVersions(request);

    List<String> resources = Lists.newArrayList(pagedListResponse.iterateAll());

    Assert.assertEquals(1, resources.size());
    Assert.assertEquals(expectedResponse.getModelServerVersionsList().get(0), resources.get(0));

    List<AbstractMessage> actualRequests = mockGkeInferenceQuickstart.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    FetchModelServerVersionsRequest actualRequest =
        ((FetchModelServerVersionsRequest) actualRequests.get(0));

    Assert.assertEquals(request.getModel(), actualRequest.getModel());
    Assert.assertEquals(request.getModelServer(), actualRequest.getModelServer());
    Assert.assertEquals(request.getPageSize(), actualRequest.getPageSize());
    Assert.assertEquals(request.getPageToken(), actualRequest.getPageToken());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void fetchModelServerVersionsExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockGkeInferenceQuickstart.addException(exception);

    try {
      FetchModelServerVersionsRequest request =
          FetchModelServerVersionsRequest.newBuilder()
              .setModel("model104069929")
              .setModelServer("modelServer475157452")
              .setPageSize(883849137)
              .setPageToken("pageToken873572522")
              .build();
      client.fetchModelServerVersions(request);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void fetchProfilesTest() throws Exception {
    Profile responsesElement = Profile.newBuilder().build();
    FetchProfilesResponse expectedResponse =
        FetchProfilesResponse.newBuilder()
            .setNextPageToken("")
            .addAllProfile(Arrays.asList(responsesElement))
            .build();
    mockGkeInferenceQuickstart.addResponse(expectedResponse);

    FetchProfilesRequest request =
        FetchProfilesRequest.newBuilder()
            .setModel("model104069929")
            .setModelServer("modelServer475157452")
            .setModelServerVersion("modelServerVersion77054828")
            .setPerformanceRequirements(PerformanceRequirements.newBuilder().build())
            .setPageSize(883849137)
            .setPageToken("pageToken873572522")
            .build();

    FetchProfilesPagedResponse pagedListResponse = client.fetchProfiles(request);

    List<Profile> resources = Lists.newArrayList(pagedListResponse.iterateAll());

    Assert.assertEquals(1, resources.size());
    Assert.assertEquals(expectedResponse.getProfileList().get(0), resources.get(0));

    List<AbstractMessage> actualRequests = mockGkeInferenceQuickstart.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    FetchProfilesRequest actualRequest = ((FetchProfilesRequest) actualRequests.get(0));

    Assert.assertEquals(request.getModel(), actualRequest.getModel());
    Assert.assertEquals(request.getModelServer(), actualRequest.getModelServer());
    Assert.assertEquals(request.getModelServerVersion(), actualRequest.getModelServerVersion());
    Assert.assertEquals(
        request.getPerformanceRequirements(), actualRequest.getPerformanceRequirements());
    Assert.assertEquals(request.getPageSize(), actualRequest.getPageSize());
    Assert.assertEquals(request.getPageToken(), actualRequest.getPageToken());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void fetchProfilesExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockGkeInferenceQuickstart.addException(exception);

    try {
      FetchProfilesRequest request =
          FetchProfilesRequest.newBuilder()
              .setModel("model104069929")
              .setModelServer("modelServer475157452")
              .setModelServerVersion("modelServerVersion77054828")
              .setPerformanceRequirements(PerformanceRequirements.newBuilder().build())
              .setPageSize(883849137)
              .setPageToken("pageToken873572522")
              .build();
      client.fetchProfiles(request);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void generateOptimizedManifestTest() throws Exception {
    GenerateOptimizedManifestResponse expectedResponse =
        GenerateOptimizedManifestResponse.newBuilder()
            .addAllKubernetesManifests(new ArrayList<KubernetesManifest>())
            .addAllComments(new ArrayList<String>())
            .setManifestVersion("manifestVersion1420559273")
            .build();
    mockGkeInferenceQuickstart.addResponse(expectedResponse);

    GenerateOptimizedManifestRequest request =
        GenerateOptimizedManifestRequest.newBuilder()
            .setModelServerInfo(ModelServerInfo.newBuilder().build())
            .setAcceleratorType("acceleratorType-82462651")
            .setKubernetesNamespace("kubernetesNamespace-1862862667")
            .setPerformanceRequirements(PerformanceRequirements.newBuilder().build())
            .setStorageConfig(StorageConfig.newBuilder().build())
            .build();

    GenerateOptimizedManifestResponse actualResponse = client.generateOptimizedManifest(request);
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockGkeInferenceQuickstart.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    GenerateOptimizedManifestRequest actualRequest =
        ((GenerateOptimizedManifestRequest) actualRequests.get(0));

    Assert.assertEquals(request.getModelServerInfo(), actualRequest.getModelServerInfo());
    Assert.assertEquals(request.getAcceleratorType(), actualRequest.getAcceleratorType());
    Assert.assertEquals(request.getKubernetesNamespace(), actualRequest.getKubernetesNamespace());
    Assert.assertEquals(
        request.getPerformanceRequirements(), actualRequest.getPerformanceRequirements());
    Assert.assertEquals(request.getStorageConfig(), actualRequest.getStorageConfig());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void generateOptimizedManifestExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockGkeInferenceQuickstart.addException(exception);

    try {
      GenerateOptimizedManifestRequest request =
          GenerateOptimizedManifestRequest.newBuilder()
              .setModelServerInfo(ModelServerInfo.newBuilder().build())
              .setAcceleratorType("acceleratorType-82462651")
              .setKubernetesNamespace("kubernetesNamespace-1862862667")
              .setPerformanceRequirements(PerformanceRequirements.newBuilder().build())
              .setStorageConfig(StorageConfig.newBuilder().build())
              .build();
      client.generateOptimizedManifest(request);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void fetchBenchmarkingDataTest() throws Exception {
    FetchBenchmarkingDataResponse expectedResponse =
        FetchBenchmarkingDataResponse.newBuilder().addAllProfile(new ArrayList<Profile>()).build();
    mockGkeInferenceQuickstart.addResponse(expectedResponse);

    FetchBenchmarkingDataRequest request =
        FetchBenchmarkingDataRequest.newBuilder()
            .setModelServerInfo(ModelServerInfo.newBuilder().build())
            .setInstanceType("instanceType-737655441")
            .setPricingModel("pricingModel1050892035")
            .build();

    FetchBenchmarkingDataResponse actualResponse = client.fetchBenchmarkingData(request);
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockGkeInferenceQuickstart.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    FetchBenchmarkingDataRequest actualRequest =
        ((FetchBenchmarkingDataRequest) actualRequests.get(0));

    Assert.assertEquals(request.getModelServerInfo(), actualRequest.getModelServerInfo());
    Assert.assertEquals(request.getInstanceType(), actualRequest.getInstanceType());
    Assert.assertEquals(request.getPricingModel(), actualRequest.getPricingModel());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void fetchBenchmarkingDataExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockGkeInferenceQuickstart.addException(exception);

    try {
      FetchBenchmarkingDataRequest request =
          FetchBenchmarkingDataRequest.newBuilder()
              .setModelServerInfo(ModelServerInfo.newBuilder().build())
              .setInstanceType("instanceType-737655441")
              .setPricingModel("pricingModel1050892035")
              .build();
      client.fetchBenchmarkingData(request);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }
}
