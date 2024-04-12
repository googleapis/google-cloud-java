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

package com.google.cloud.discoveryengine.v1;

import static com.google.cloud.discoveryengine.v1.SiteSearchEngineServiceClient.FetchDomainVerificationStatusPagedResponse;
import static com.google.cloud.discoveryengine.v1.SiteSearchEngineServiceClient.ListTargetSitesPagedResponse;

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
import com.google.protobuf.Timestamp;
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
public class SiteSearchEngineServiceClientTest {
  private static MockLocations mockLocations;
  private static MockServiceHelper mockServiceHelper;
  private static MockSiteSearchEngineService mockSiteSearchEngineService;
  private LocalChannelProvider channelProvider;
  private SiteSearchEngineServiceClient client;

  @BeforeClass
  public static void startStaticServer() {
    mockSiteSearchEngineService = new MockSiteSearchEngineService();
    mockLocations = new MockLocations();
    mockServiceHelper =
        new MockServiceHelper(
            UUID.randomUUID().toString(),
            Arrays.<MockGrpcService>asList(mockSiteSearchEngineService, mockLocations));
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
    SiteSearchEngineServiceSettings settings =
        SiteSearchEngineServiceSettings.newBuilder()
            .setTransportChannelProvider(channelProvider)
            .setCredentialsProvider(NoCredentialsProvider.create())
            .build();
    client = SiteSearchEngineServiceClient.create(settings);
  }

  @After
  public void tearDown() throws Exception {
    client.close();
  }

  @Test
  public void getSiteSearchEngineTest() throws Exception {
    SiteSearchEngine expectedResponse =
        SiteSearchEngine.newBuilder()
            .setName(
                SiteSearchEngineName.ofProjectLocationDataStoreName(
                        "[PROJECT]", "[LOCATION]", "[DATA_STORE]")
                    .toString())
            .build();
    mockSiteSearchEngineService.addResponse(expectedResponse);

    SiteSearchEngineName name =
        SiteSearchEngineName.ofProjectLocationDataStoreName(
            "[PROJECT]", "[LOCATION]", "[DATA_STORE]");

    SiteSearchEngine actualResponse = client.getSiteSearchEngine(name);
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockSiteSearchEngineService.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    GetSiteSearchEngineRequest actualRequest = ((GetSiteSearchEngineRequest) actualRequests.get(0));

    Assert.assertEquals(name.toString(), actualRequest.getName());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void getSiteSearchEngineExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockSiteSearchEngineService.addException(exception);

    try {
      SiteSearchEngineName name =
          SiteSearchEngineName.ofProjectLocationDataStoreName(
              "[PROJECT]", "[LOCATION]", "[DATA_STORE]");
      client.getSiteSearchEngine(name);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void getSiteSearchEngineTest2() throws Exception {
    SiteSearchEngine expectedResponse =
        SiteSearchEngine.newBuilder()
            .setName(
                SiteSearchEngineName.ofProjectLocationDataStoreName(
                        "[PROJECT]", "[LOCATION]", "[DATA_STORE]")
                    .toString())
            .build();
    mockSiteSearchEngineService.addResponse(expectedResponse);

    String name = "name3373707";

    SiteSearchEngine actualResponse = client.getSiteSearchEngine(name);
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockSiteSearchEngineService.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    GetSiteSearchEngineRequest actualRequest = ((GetSiteSearchEngineRequest) actualRequests.get(0));

    Assert.assertEquals(name, actualRequest.getName());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void getSiteSearchEngineExceptionTest2() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockSiteSearchEngineService.addException(exception);

    try {
      String name = "name3373707";
      client.getSiteSearchEngine(name);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void createTargetSiteTest() throws Exception {
    TargetSite expectedResponse =
        TargetSite.newBuilder()
            .setName(
                TargetSiteName.ofProjectLocationDataStoreTargetSiteName(
                        "[PROJECT]", "[LOCATION]", "[DATA_STORE]", "[TARGET_SITE]")
                    .toString())
            .setProvidedUriPattern("providedUriPattern414527175")
            .setExactMatch(true)
            .setGeneratedUriPattern("generatedUriPattern-981984397")
            .setSiteVerificationInfo(SiteVerificationInfo.newBuilder().build())
            .setUpdateTime(Timestamp.newBuilder().build())
            .setFailureReason(TargetSite.FailureReason.newBuilder().build())
            .build();
    Operation resultOperation =
        Operation.newBuilder()
            .setName("createTargetSiteTest")
            .setDone(true)
            .setResponse(Any.pack(expectedResponse))
            .build();
    mockSiteSearchEngineService.addResponse(resultOperation);

    SiteSearchEngineName parent =
        SiteSearchEngineName.ofProjectLocationDataStoreName(
            "[PROJECT]", "[LOCATION]", "[DATA_STORE]");
    TargetSite targetSite = TargetSite.newBuilder().build();

    TargetSite actualResponse = client.createTargetSiteAsync(parent, targetSite).get();
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockSiteSearchEngineService.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    CreateTargetSiteRequest actualRequest = ((CreateTargetSiteRequest) actualRequests.get(0));

    Assert.assertEquals(parent.toString(), actualRequest.getParent());
    Assert.assertEquals(targetSite, actualRequest.getTargetSite());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void createTargetSiteExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockSiteSearchEngineService.addException(exception);

    try {
      SiteSearchEngineName parent =
          SiteSearchEngineName.ofProjectLocationDataStoreName(
              "[PROJECT]", "[LOCATION]", "[DATA_STORE]");
      TargetSite targetSite = TargetSite.newBuilder().build();
      client.createTargetSiteAsync(parent, targetSite).get();
      Assert.fail("No exception raised");
    } catch (ExecutionException e) {
      Assert.assertEquals(InvalidArgumentException.class, e.getCause().getClass());
      InvalidArgumentException apiException = ((InvalidArgumentException) e.getCause());
      Assert.assertEquals(StatusCode.Code.INVALID_ARGUMENT, apiException.getStatusCode().getCode());
    }
  }

  @Test
  public void createTargetSiteTest2() throws Exception {
    TargetSite expectedResponse =
        TargetSite.newBuilder()
            .setName(
                TargetSiteName.ofProjectLocationDataStoreTargetSiteName(
                        "[PROJECT]", "[LOCATION]", "[DATA_STORE]", "[TARGET_SITE]")
                    .toString())
            .setProvidedUriPattern("providedUriPattern414527175")
            .setExactMatch(true)
            .setGeneratedUriPattern("generatedUriPattern-981984397")
            .setSiteVerificationInfo(SiteVerificationInfo.newBuilder().build())
            .setUpdateTime(Timestamp.newBuilder().build())
            .setFailureReason(TargetSite.FailureReason.newBuilder().build())
            .build();
    Operation resultOperation =
        Operation.newBuilder()
            .setName("createTargetSiteTest")
            .setDone(true)
            .setResponse(Any.pack(expectedResponse))
            .build();
    mockSiteSearchEngineService.addResponse(resultOperation);

    String parent = "parent-995424086";
    TargetSite targetSite = TargetSite.newBuilder().build();

    TargetSite actualResponse = client.createTargetSiteAsync(parent, targetSite).get();
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockSiteSearchEngineService.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    CreateTargetSiteRequest actualRequest = ((CreateTargetSiteRequest) actualRequests.get(0));

    Assert.assertEquals(parent, actualRequest.getParent());
    Assert.assertEquals(targetSite, actualRequest.getTargetSite());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void createTargetSiteExceptionTest2() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockSiteSearchEngineService.addException(exception);

    try {
      String parent = "parent-995424086";
      TargetSite targetSite = TargetSite.newBuilder().build();
      client.createTargetSiteAsync(parent, targetSite).get();
      Assert.fail("No exception raised");
    } catch (ExecutionException e) {
      Assert.assertEquals(InvalidArgumentException.class, e.getCause().getClass());
      InvalidArgumentException apiException = ((InvalidArgumentException) e.getCause());
      Assert.assertEquals(StatusCode.Code.INVALID_ARGUMENT, apiException.getStatusCode().getCode());
    }
  }

  @Test
  public void batchCreateTargetSitesTest() throws Exception {
    BatchCreateTargetSitesResponse expectedResponse =
        BatchCreateTargetSitesResponse.newBuilder()
            .addAllTargetSites(new ArrayList<TargetSite>())
            .build();
    Operation resultOperation =
        Operation.newBuilder()
            .setName("batchCreateTargetSitesTest")
            .setDone(true)
            .setResponse(Any.pack(expectedResponse))
            .build();
    mockSiteSearchEngineService.addResponse(resultOperation);

    BatchCreateTargetSitesRequest request =
        BatchCreateTargetSitesRequest.newBuilder()
            .setParent(
                SiteSearchEngineName.ofProjectLocationDataStoreName(
                        "[PROJECT]", "[LOCATION]", "[DATA_STORE]")
                    .toString())
            .addAllRequests(new ArrayList<CreateTargetSiteRequest>())
            .build();

    BatchCreateTargetSitesResponse actualResponse =
        client.batchCreateTargetSitesAsync(request).get();
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockSiteSearchEngineService.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    BatchCreateTargetSitesRequest actualRequest =
        ((BatchCreateTargetSitesRequest) actualRequests.get(0));

    Assert.assertEquals(request.getParent(), actualRequest.getParent());
    Assert.assertEquals(request.getRequestsList(), actualRequest.getRequestsList());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void batchCreateTargetSitesExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockSiteSearchEngineService.addException(exception);

    try {
      BatchCreateTargetSitesRequest request =
          BatchCreateTargetSitesRequest.newBuilder()
              .setParent(
                  SiteSearchEngineName.ofProjectLocationDataStoreName(
                          "[PROJECT]", "[LOCATION]", "[DATA_STORE]")
                      .toString())
              .addAllRequests(new ArrayList<CreateTargetSiteRequest>())
              .build();
      client.batchCreateTargetSitesAsync(request).get();
      Assert.fail("No exception raised");
    } catch (ExecutionException e) {
      Assert.assertEquals(InvalidArgumentException.class, e.getCause().getClass());
      InvalidArgumentException apiException = ((InvalidArgumentException) e.getCause());
      Assert.assertEquals(StatusCode.Code.INVALID_ARGUMENT, apiException.getStatusCode().getCode());
    }
  }

  @Test
  public void getTargetSiteTest() throws Exception {
    TargetSite expectedResponse =
        TargetSite.newBuilder()
            .setName(
                TargetSiteName.ofProjectLocationDataStoreTargetSiteName(
                        "[PROJECT]", "[LOCATION]", "[DATA_STORE]", "[TARGET_SITE]")
                    .toString())
            .setProvidedUriPattern("providedUriPattern414527175")
            .setExactMatch(true)
            .setGeneratedUriPattern("generatedUriPattern-981984397")
            .setSiteVerificationInfo(SiteVerificationInfo.newBuilder().build())
            .setUpdateTime(Timestamp.newBuilder().build())
            .setFailureReason(TargetSite.FailureReason.newBuilder().build())
            .build();
    mockSiteSearchEngineService.addResponse(expectedResponse);

    TargetSiteName name =
        TargetSiteName.ofProjectLocationDataStoreTargetSiteName(
            "[PROJECT]", "[LOCATION]", "[DATA_STORE]", "[TARGET_SITE]");

    TargetSite actualResponse = client.getTargetSite(name);
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockSiteSearchEngineService.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    GetTargetSiteRequest actualRequest = ((GetTargetSiteRequest) actualRequests.get(0));

    Assert.assertEquals(name.toString(), actualRequest.getName());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void getTargetSiteExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockSiteSearchEngineService.addException(exception);

    try {
      TargetSiteName name =
          TargetSiteName.ofProjectLocationDataStoreTargetSiteName(
              "[PROJECT]", "[LOCATION]", "[DATA_STORE]", "[TARGET_SITE]");
      client.getTargetSite(name);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void getTargetSiteTest2() throws Exception {
    TargetSite expectedResponse =
        TargetSite.newBuilder()
            .setName(
                TargetSiteName.ofProjectLocationDataStoreTargetSiteName(
                        "[PROJECT]", "[LOCATION]", "[DATA_STORE]", "[TARGET_SITE]")
                    .toString())
            .setProvidedUriPattern("providedUriPattern414527175")
            .setExactMatch(true)
            .setGeneratedUriPattern("generatedUriPattern-981984397")
            .setSiteVerificationInfo(SiteVerificationInfo.newBuilder().build())
            .setUpdateTime(Timestamp.newBuilder().build())
            .setFailureReason(TargetSite.FailureReason.newBuilder().build())
            .build();
    mockSiteSearchEngineService.addResponse(expectedResponse);

    String name = "name3373707";

    TargetSite actualResponse = client.getTargetSite(name);
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockSiteSearchEngineService.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    GetTargetSiteRequest actualRequest = ((GetTargetSiteRequest) actualRequests.get(0));

    Assert.assertEquals(name, actualRequest.getName());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void getTargetSiteExceptionTest2() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockSiteSearchEngineService.addException(exception);

    try {
      String name = "name3373707";
      client.getTargetSite(name);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void updateTargetSiteTest() throws Exception {
    TargetSite expectedResponse =
        TargetSite.newBuilder()
            .setName(
                TargetSiteName.ofProjectLocationDataStoreTargetSiteName(
                        "[PROJECT]", "[LOCATION]", "[DATA_STORE]", "[TARGET_SITE]")
                    .toString())
            .setProvidedUriPattern("providedUriPattern414527175")
            .setExactMatch(true)
            .setGeneratedUriPattern("generatedUriPattern-981984397")
            .setSiteVerificationInfo(SiteVerificationInfo.newBuilder().build())
            .setUpdateTime(Timestamp.newBuilder().build())
            .setFailureReason(TargetSite.FailureReason.newBuilder().build())
            .build();
    Operation resultOperation =
        Operation.newBuilder()
            .setName("updateTargetSiteTest")
            .setDone(true)
            .setResponse(Any.pack(expectedResponse))
            .build();
    mockSiteSearchEngineService.addResponse(resultOperation);

    TargetSite targetSite = TargetSite.newBuilder().build();

    TargetSite actualResponse = client.updateTargetSiteAsync(targetSite).get();
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockSiteSearchEngineService.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    UpdateTargetSiteRequest actualRequest = ((UpdateTargetSiteRequest) actualRequests.get(0));

    Assert.assertEquals(targetSite, actualRequest.getTargetSite());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void updateTargetSiteExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockSiteSearchEngineService.addException(exception);

    try {
      TargetSite targetSite = TargetSite.newBuilder().build();
      client.updateTargetSiteAsync(targetSite).get();
      Assert.fail("No exception raised");
    } catch (ExecutionException e) {
      Assert.assertEquals(InvalidArgumentException.class, e.getCause().getClass());
      InvalidArgumentException apiException = ((InvalidArgumentException) e.getCause());
      Assert.assertEquals(StatusCode.Code.INVALID_ARGUMENT, apiException.getStatusCode().getCode());
    }
  }

  @Test
  public void deleteTargetSiteTest() throws Exception {
    Empty expectedResponse = Empty.newBuilder().build();
    Operation resultOperation =
        Operation.newBuilder()
            .setName("deleteTargetSiteTest")
            .setDone(true)
            .setResponse(Any.pack(expectedResponse))
            .build();
    mockSiteSearchEngineService.addResponse(resultOperation);

    TargetSiteName name =
        TargetSiteName.ofProjectLocationDataStoreTargetSiteName(
            "[PROJECT]", "[LOCATION]", "[DATA_STORE]", "[TARGET_SITE]");

    client.deleteTargetSiteAsync(name).get();

    List<AbstractMessage> actualRequests = mockSiteSearchEngineService.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    DeleteTargetSiteRequest actualRequest = ((DeleteTargetSiteRequest) actualRequests.get(0));

    Assert.assertEquals(name.toString(), actualRequest.getName());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void deleteTargetSiteExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockSiteSearchEngineService.addException(exception);

    try {
      TargetSiteName name =
          TargetSiteName.ofProjectLocationDataStoreTargetSiteName(
              "[PROJECT]", "[LOCATION]", "[DATA_STORE]", "[TARGET_SITE]");
      client.deleteTargetSiteAsync(name).get();
      Assert.fail("No exception raised");
    } catch (ExecutionException e) {
      Assert.assertEquals(InvalidArgumentException.class, e.getCause().getClass());
      InvalidArgumentException apiException = ((InvalidArgumentException) e.getCause());
      Assert.assertEquals(StatusCode.Code.INVALID_ARGUMENT, apiException.getStatusCode().getCode());
    }
  }

  @Test
  public void deleteTargetSiteTest2() throws Exception {
    Empty expectedResponse = Empty.newBuilder().build();
    Operation resultOperation =
        Operation.newBuilder()
            .setName("deleteTargetSiteTest")
            .setDone(true)
            .setResponse(Any.pack(expectedResponse))
            .build();
    mockSiteSearchEngineService.addResponse(resultOperation);

    String name = "name3373707";

    client.deleteTargetSiteAsync(name).get();

    List<AbstractMessage> actualRequests = mockSiteSearchEngineService.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    DeleteTargetSiteRequest actualRequest = ((DeleteTargetSiteRequest) actualRequests.get(0));

    Assert.assertEquals(name, actualRequest.getName());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void deleteTargetSiteExceptionTest2() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockSiteSearchEngineService.addException(exception);

    try {
      String name = "name3373707";
      client.deleteTargetSiteAsync(name).get();
      Assert.fail("No exception raised");
    } catch (ExecutionException e) {
      Assert.assertEquals(InvalidArgumentException.class, e.getCause().getClass());
      InvalidArgumentException apiException = ((InvalidArgumentException) e.getCause());
      Assert.assertEquals(StatusCode.Code.INVALID_ARGUMENT, apiException.getStatusCode().getCode());
    }
  }

  @Test
  public void listTargetSitesTest() throws Exception {
    TargetSite responsesElement = TargetSite.newBuilder().build();
    ListTargetSitesResponse expectedResponse =
        ListTargetSitesResponse.newBuilder()
            .setNextPageToken("")
            .addAllTargetSites(Arrays.asList(responsesElement))
            .build();
    mockSiteSearchEngineService.addResponse(expectedResponse);

    SiteSearchEngineName parent =
        SiteSearchEngineName.ofProjectLocationDataStoreName(
            "[PROJECT]", "[LOCATION]", "[DATA_STORE]");

    ListTargetSitesPagedResponse pagedListResponse = client.listTargetSites(parent);

    List<TargetSite> resources = Lists.newArrayList(pagedListResponse.iterateAll());

    Assert.assertEquals(1, resources.size());
    Assert.assertEquals(expectedResponse.getTargetSitesList().get(0), resources.get(0));

    List<AbstractMessage> actualRequests = mockSiteSearchEngineService.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    ListTargetSitesRequest actualRequest = ((ListTargetSitesRequest) actualRequests.get(0));

    Assert.assertEquals(parent.toString(), actualRequest.getParent());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void listTargetSitesExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockSiteSearchEngineService.addException(exception);

    try {
      SiteSearchEngineName parent =
          SiteSearchEngineName.ofProjectLocationDataStoreName(
              "[PROJECT]", "[LOCATION]", "[DATA_STORE]");
      client.listTargetSites(parent);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void listTargetSitesTest2() throws Exception {
    TargetSite responsesElement = TargetSite.newBuilder().build();
    ListTargetSitesResponse expectedResponse =
        ListTargetSitesResponse.newBuilder()
            .setNextPageToken("")
            .addAllTargetSites(Arrays.asList(responsesElement))
            .build();
    mockSiteSearchEngineService.addResponse(expectedResponse);

    String parent = "parent-995424086";

    ListTargetSitesPagedResponse pagedListResponse = client.listTargetSites(parent);

    List<TargetSite> resources = Lists.newArrayList(pagedListResponse.iterateAll());

    Assert.assertEquals(1, resources.size());
    Assert.assertEquals(expectedResponse.getTargetSitesList().get(0), resources.get(0));

    List<AbstractMessage> actualRequests = mockSiteSearchEngineService.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    ListTargetSitesRequest actualRequest = ((ListTargetSitesRequest) actualRequests.get(0));

    Assert.assertEquals(parent, actualRequest.getParent());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void listTargetSitesExceptionTest2() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockSiteSearchEngineService.addException(exception);

    try {
      String parent = "parent-995424086";
      client.listTargetSites(parent);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void enableAdvancedSiteSearchTest() throws Exception {
    EnableAdvancedSiteSearchResponse expectedResponse =
        EnableAdvancedSiteSearchResponse.newBuilder().build();
    Operation resultOperation =
        Operation.newBuilder()
            .setName("enableAdvancedSiteSearchTest")
            .setDone(true)
            .setResponse(Any.pack(expectedResponse))
            .build();
    mockSiteSearchEngineService.addResponse(resultOperation);

    EnableAdvancedSiteSearchRequest request =
        EnableAdvancedSiteSearchRequest.newBuilder()
            .setSiteSearchEngine(
                SiteSearchEngineName.ofProjectLocationDataStoreName(
                        "[PROJECT]", "[LOCATION]", "[DATA_STORE]")
                    .toString())
            .build();

    EnableAdvancedSiteSearchResponse actualResponse =
        client.enableAdvancedSiteSearchAsync(request).get();
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockSiteSearchEngineService.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    EnableAdvancedSiteSearchRequest actualRequest =
        ((EnableAdvancedSiteSearchRequest) actualRequests.get(0));

    Assert.assertEquals(request.getSiteSearchEngine(), actualRequest.getSiteSearchEngine());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void enableAdvancedSiteSearchExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockSiteSearchEngineService.addException(exception);

    try {
      EnableAdvancedSiteSearchRequest request =
          EnableAdvancedSiteSearchRequest.newBuilder()
              .setSiteSearchEngine(
                  SiteSearchEngineName.ofProjectLocationDataStoreName(
                          "[PROJECT]", "[LOCATION]", "[DATA_STORE]")
                      .toString())
              .build();
      client.enableAdvancedSiteSearchAsync(request).get();
      Assert.fail("No exception raised");
    } catch (ExecutionException e) {
      Assert.assertEquals(InvalidArgumentException.class, e.getCause().getClass());
      InvalidArgumentException apiException = ((InvalidArgumentException) e.getCause());
      Assert.assertEquals(StatusCode.Code.INVALID_ARGUMENT, apiException.getStatusCode().getCode());
    }
  }

  @Test
  public void disableAdvancedSiteSearchTest() throws Exception {
    DisableAdvancedSiteSearchResponse expectedResponse =
        DisableAdvancedSiteSearchResponse.newBuilder().build();
    Operation resultOperation =
        Operation.newBuilder()
            .setName("disableAdvancedSiteSearchTest")
            .setDone(true)
            .setResponse(Any.pack(expectedResponse))
            .build();
    mockSiteSearchEngineService.addResponse(resultOperation);

    DisableAdvancedSiteSearchRequest request =
        DisableAdvancedSiteSearchRequest.newBuilder()
            .setSiteSearchEngine(
                SiteSearchEngineName.ofProjectLocationDataStoreName(
                        "[PROJECT]", "[LOCATION]", "[DATA_STORE]")
                    .toString())
            .build();

    DisableAdvancedSiteSearchResponse actualResponse =
        client.disableAdvancedSiteSearchAsync(request).get();
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockSiteSearchEngineService.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    DisableAdvancedSiteSearchRequest actualRequest =
        ((DisableAdvancedSiteSearchRequest) actualRequests.get(0));

    Assert.assertEquals(request.getSiteSearchEngine(), actualRequest.getSiteSearchEngine());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void disableAdvancedSiteSearchExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockSiteSearchEngineService.addException(exception);

    try {
      DisableAdvancedSiteSearchRequest request =
          DisableAdvancedSiteSearchRequest.newBuilder()
              .setSiteSearchEngine(
                  SiteSearchEngineName.ofProjectLocationDataStoreName(
                          "[PROJECT]", "[LOCATION]", "[DATA_STORE]")
                      .toString())
              .build();
      client.disableAdvancedSiteSearchAsync(request).get();
      Assert.fail("No exception raised");
    } catch (ExecutionException e) {
      Assert.assertEquals(InvalidArgumentException.class, e.getCause().getClass());
      InvalidArgumentException apiException = ((InvalidArgumentException) e.getCause());
      Assert.assertEquals(StatusCode.Code.INVALID_ARGUMENT, apiException.getStatusCode().getCode());
    }
  }

  @Test
  public void recrawlUrisTest() throws Exception {
    RecrawlUrisResponse expectedResponse =
        RecrawlUrisResponse.newBuilder()
            .addAllFailureSamples(new ArrayList<RecrawlUrisResponse.FailureInfo>())
            .addAllFailedUris(new ArrayList<String>())
            .build();
    Operation resultOperation =
        Operation.newBuilder()
            .setName("recrawlUrisTest")
            .setDone(true)
            .setResponse(Any.pack(expectedResponse))
            .build();
    mockSiteSearchEngineService.addResponse(resultOperation);

    RecrawlUrisRequest request =
        RecrawlUrisRequest.newBuilder()
            .setSiteSearchEngine(
                SiteSearchEngineName.ofProjectLocationDataStoreName(
                        "[PROJECT]", "[LOCATION]", "[DATA_STORE]")
                    .toString())
            .addAllUris(new ArrayList<String>())
            .build();

    RecrawlUrisResponse actualResponse = client.recrawlUrisAsync(request).get();
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockSiteSearchEngineService.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    RecrawlUrisRequest actualRequest = ((RecrawlUrisRequest) actualRequests.get(0));

    Assert.assertEquals(request.getSiteSearchEngine(), actualRequest.getSiteSearchEngine());
    Assert.assertEquals(request.getUrisList(), actualRequest.getUrisList());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void recrawlUrisExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockSiteSearchEngineService.addException(exception);

    try {
      RecrawlUrisRequest request =
          RecrawlUrisRequest.newBuilder()
              .setSiteSearchEngine(
                  SiteSearchEngineName.ofProjectLocationDataStoreName(
                          "[PROJECT]", "[LOCATION]", "[DATA_STORE]")
                      .toString())
              .addAllUris(new ArrayList<String>())
              .build();
      client.recrawlUrisAsync(request).get();
      Assert.fail("No exception raised");
    } catch (ExecutionException e) {
      Assert.assertEquals(InvalidArgumentException.class, e.getCause().getClass());
      InvalidArgumentException apiException = ((InvalidArgumentException) e.getCause());
      Assert.assertEquals(StatusCode.Code.INVALID_ARGUMENT, apiException.getStatusCode().getCode());
    }
  }

  @Test
  public void batchVerifyTargetSitesTest() throws Exception {
    BatchVerifyTargetSitesResponse expectedResponse =
        BatchVerifyTargetSitesResponse.newBuilder().build();
    Operation resultOperation =
        Operation.newBuilder()
            .setName("batchVerifyTargetSitesTest")
            .setDone(true)
            .setResponse(Any.pack(expectedResponse))
            .build();
    mockSiteSearchEngineService.addResponse(resultOperation);

    BatchVerifyTargetSitesRequest request =
        BatchVerifyTargetSitesRequest.newBuilder()
            .setParent(
                SiteSearchEngineName.ofProjectLocationCollectionDataStoreName(
                        "[PROJECT]", "[LOCATION]", "[COLLECTION]", "[DATA_STORE]")
                    .toString())
            .build();

    BatchVerifyTargetSitesResponse actualResponse =
        client.batchVerifyTargetSitesAsync(request).get();
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockSiteSearchEngineService.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    BatchVerifyTargetSitesRequest actualRequest =
        ((BatchVerifyTargetSitesRequest) actualRequests.get(0));

    Assert.assertEquals(request.getParent(), actualRequest.getParent());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void batchVerifyTargetSitesExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockSiteSearchEngineService.addException(exception);

    try {
      BatchVerifyTargetSitesRequest request =
          BatchVerifyTargetSitesRequest.newBuilder()
              .setParent(
                  SiteSearchEngineName.ofProjectLocationCollectionDataStoreName(
                          "[PROJECT]", "[LOCATION]", "[COLLECTION]", "[DATA_STORE]")
                      .toString())
              .build();
      client.batchVerifyTargetSitesAsync(request).get();
      Assert.fail("No exception raised");
    } catch (ExecutionException e) {
      Assert.assertEquals(InvalidArgumentException.class, e.getCause().getClass());
      InvalidArgumentException apiException = ((InvalidArgumentException) e.getCause());
      Assert.assertEquals(StatusCode.Code.INVALID_ARGUMENT, apiException.getStatusCode().getCode());
    }
  }

  @Test
  public void fetchDomainVerificationStatusTest() throws Exception {
    TargetSite responsesElement = TargetSite.newBuilder().build();
    FetchDomainVerificationStatusResponse expectedResponse =
        FetchDomainVerificationStatusResponse.newBuilder()
            .setNextPageToken("")
            .addAllTargetSites(Arrays.asList(responsesElement))
            .build();
    mockSiteSearchEngineService.addResponse(expectedResponse);

    FetchDomainVerificationStatusRequest request =
        FetchDomainVerificationStatusRequest.newBuilder()
            .setSiteSearchEngine(
                SiteSearchEngineName.ofProjectLocationCollectionDataStoreName(
                        "[PROJECT]", "[LOCATION]", "[COLLECTION]", "[DATA_STORE]")
                    .toString())
            .setPageSize(883849137)
            .setPageToken("pageToken873572522")
            .build();

    FetchDomainVerificationStatusPagedResponse pagedListResponse =
        client.fetchDomainVerificationStatus(request);

    List<TargetSite> resources = Lists.newArrayList(pagedListResponse.iterateAll());

    Assert.assertEquals(1, resources.size());
    Assert.assertEquals(expectedResponse.getTargetSitesList().get(0), resources.get(0));

    List<AbstractMessage> actualRequests = mockSiteSearchEngineService.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    FetchDomainVerificationStatusRequest actualRequest =
        ((FetchDomainVerificationStatusRequest) actualRequests.get(0));

    Assert.assertEquals(request.getSiteSearchEngine(), actualRequest.getSiteSearchEngine());
    Assert.assertEquals(request.getPageSize(), actualRequest.getPageSize());
    Assert.assertEquals(request.getPageToken(), actualRequest.getPageToken());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void fetchDomainVerificationStatusExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockSiteSearchEngineService.addException(exception);

    try {
      FetchDomainVerificationStatusRequest request =
          FetchDomainVerificationStatusRequest.newBuilder()
              .setSiteSearchEngine(
                  SiteSearchEngineName.ofProjectLocationCollectionDataStoreName(
                          "[PROJECT]", "[LOCATION]", "[COLLECTION]", "[DATA_STORE]")
                      .toString())
              .setPageSize(883849137)
              .setPageToken("pageToken873572522")
              .build();
      client.fetchDomainVerificationStatus(request);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }
}
