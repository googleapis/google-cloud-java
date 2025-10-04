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

package com.google.cloud.developerconnect.v1;

import static com.google.cloud.developerconnect.v1.InsightsConfigServiceClient.ListInsightsConfigsPagedResponse;
import static com.google.cloud.developerconnect.v1.InsightsConfigServiceClient.ListLocationsPagedResponse;

import com.google.api.gax.core.NoCredentialsProvider;
import com.google.api.gax.httpjson.GaxHttpJsonProperties;
import com.google.api.gax.httpjson.testing.MockHttpService;
import com.google.api.gax.rpc.ApiClientHeaderProvider;
import com.google.api.gax.rpc.ApiException;
import com.google.api.gax.rpc.ApiExceptionFactory;
import com.google.api.gax.rpc.InvalidArgumentException;
import com.google.api.gax.rpc.StatusCode;
import com.google.api.gax.rpc.testing.FakeStatusCode;
import com.google.cloud.developerconnect.v1.stub.HttpJsonInsightsConfigServiceStub;
import com.google.cloud.location.GetLocationRequest;
import com.google.cloud.location.ListLocationsRequest;
import com.google.cloud.location.ListLocationsResponse;
import com.google.cloud.location.Location;
import com.google.common.collect.Lists;
import com.google.longrunning.Operation;
import com.google.protobuf.Any;
import com.google.protobuf.Empty;
import com.google.protobuf.Timestamp;
import com.google.rpc.Status;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.concurrent.ExecutionException;
import javax.annotation.Generated;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Assert;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

@Generated("by gapic-generator-java")
public class InsightsConfigServiceClientHttpJsonTest {
  private static MockHttpService mockService;
  private static InsightsConfigServiceClient client;

  @BeforeClass
  public static void startStaticServer() throws IOException {
    mockService =
        new MockHttpService(
            HttpJsonInsightsConfigServiceStub.getMethodDescriptors(),
            InsightsConfigServiceSettings.getDefaultEndpoint());
    InsightsConfigServiceSettings settings =
        InsightsConfigServiceSettings.newHttpJsonBuilder()
            .setTransportChannelProvider(
                InsightsConfigServiceSettings.defaultHttpJsonTransportProviderBuilder()
                    .setHttpTransport(mockService)
                    .build())
            .setCredentialsProvider(NoCredentialsProvider.create())
            .build();
    client = InsightsConfigServiceClient.create(settings);
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
  public void listInsightsConfigsTest() throws Exception {
    InsightsConfig responsesElement = InsightsConfig.newBuilder().build();
    ListInsightsConfigsResponse expectedResponse =
        ListInsightsConfigsResponse.newBuilder()
            .setNextPageToken("")
            .addAllInsightsConfigs(Arrays.asList(responsesElement))
            .build();
    mockService.addResponse(expectedResponse);

    LocationName parent = LocationName.of("[PROJECT]", "[LOCATION]");

    ListInsightsConfigsPagedResponse pagedListResponse = client.listInsightsConfigs(parent);

    List<InsightsConfig> resources = Lists.newArrayList(pagedListResponse.iterateAll());

    Assert.assertEquals(1, resources.size());
    Assert.assertEquals(expectedResponse.getInsightsConfigsList().get(0), resources.get(0));

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
  public void listInsightsConfigsExceptionTest() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

    try {
      LocationName parent = LocationName.of("[PROJECT]", "[LOCATION]");
      client.listInsightsConfigs(parent);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void listInsightsConfigsTest2() throws Exception {
    InsightsConfig responsesElement = InsightsConfig.newBuilder().build();
    ListInsightsConfigsResponse expectedResponse =
        ListInsightsConfigsResponse.newBuilder()
            .setNextPageToken("")
            .addAllInsightsConfigs(Arrays.asList(responsesElement))
            .build();
    mockService.addResponse(expectedResponse);

    String parent = "projects/project-5833/locations/location-5833";

    ListInsightsConfigsPagedResponse pagedListResponse = client.listInsightsConfigs(parent);

    List<InsightsConfig> resources = Lists.newArrayList(pagedListResponse.iterateAll());

    Assert.assertEquals(1, resources.size());
    Assert.assertEquals(expectedResponse.getInsightsConfigsList().get(0), resources.get(0));

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
  public void listInsightsConfigsExceptionTest2() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

    try {
      String parent = "projects/project-5833/locations/location-5833";
      client.listInsightsConfigs(parent);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void createInsightsConfigTest() throws Exception {
    InsightsConfig expectedResponse =
        InsightsConfig.newBuilder()
            .setName(
                InsightsConfigName.of("[PROJECT]", "[LOCATION]", "[INSIGHTS_CONFIG]").toString())
            .setCreateTime(Timestamp.newBuilder().build())
            .setUpdateTime(Timestamp.newBuilder().build())
            .addAllRuntimeConfigs(new ArrayList<RuntimeConfig>())
            .addAllArtifactConfigs(new ArrayList<ArtifactConfig>())
            .putAllAnnotations(new HashMap<String, String>())
            .putAllLabels(new HashMap<String, String>())
            .setReconciling(true)
            .addAllErrors(new ArrayList<Status>())
            .build();
    Operation resultOperation =
        Operation.newBuilder()
            .setName("createInsightsConfigTest")
            .setDone(true)
            .setResponse(Any.pack(expectedResponse))
            .build();
    mockService.addResponse(resultOperation);

    LocationName parent = LocationName.of("[PROJECT]", "[LOCATION]");
    InsightsConfig insightsConfig = InsightsConfig.newBuilder().build();
    String insightsConfigId = "insightsConfigId774395128";

    InsightsConfig actualResponse =
        client.createInsightsConfigAsync(parent, insightsConfig, insightsConfigId).get();
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
  public void createInsightsConfigExceptionTest() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

    try {
      LocationName parent = LocationName.of("[PROJECT]", "[LOCATION]");
      InsightsConfig insightsConfig = InsightsConfig.newBuilder().build();
      String insightsConfigId = "insightsConfigId774395128";
      client.createInsightsConfigAsync(parent, insightsConfig, insightsConfigId).get();
      Assert.fail("No exception raised");
    } catch (ExecutionException e) {
    }
  }

  @Test
  public void createInsightsConfigTest2() throws Exception {
    InsightsConfig expectedResponse =
        InsightsConfig.newBuilder()
            .setName(
                InsightsConfigName.of("[PROJECT]", "[LOCATION]", "[INSIGHTS_CONFIG]").toString())
            .setCreateTime(Timestamp.newBuilder().build())
            .setUpdateTime(Timestamp.newBuilder().build())
            .addAllRuntimeConfigs(new ArrayList<RuntimeConfig>())
            .addAllArtifactConfigs(new ArrayList<ArtifactConfig>())
            .putAllAnnotations(new HashMap<String, String>())
            .putAllLabels(new HashMap<String, String>())
            .setReconciling(true)
            .addAllErrors(new ArrayList<Status>())
            .build();
    Operation resultOperation =
        Operation.newBuilder()
            .setName("createInsightsConfigTest")
            .setDone(true)
            .setResponse(Any.pack(expectedResponse))
            .build();
    mockService.addResponse(resultOperation);

    String parent = "projects/project-5833/locations/location-5833";
    InsightsConfig insightsConfig = InsightsConfig.newBuilder().build();
    String insightsConfigId = "insightsConfigId774395128";

    InsightsConfig actualResponse =
        client.createInsightsConfigAsync(parent, insightsConfig, insightsConfigId).get();
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
  public void createInsightsConfigExceptionTest2() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

    try {
      String parent = "projects/project-5833/locations/location-5833";
      InsightsConfig insightsConfig = InsightsConfig.newBuilder().build();
      String insightsConfigId = "insightsConfigId774395128";
      client.createInsightsConfigAsync(parent, insightsConfig, insightsConfigId).get();
      Assert.fail("No exception raised");
    } catch (ExecutionException e) {
    }
  }

  @Test
  public void getInsightsConfigTest() throws Exception {
    InsightsConfig expectedResponse =
        InsightsConfig.newBuilder()
            .setName(
                InsightsConfigName.of("[PROJECT]", "[LOCATION]", "[INSIGHTS_CONFIG]").toString())
            .setCreateTime(Timestamp.newBuilder().build())
            .setUpdateTime(Timestamp.newBuilder().build())
            .addAllRuntimeConfigs(new ArrayList<RuntimeConfig>())
            .addAllArtifactConfigs(new ArrayList<ArtifactConfig>())
            .putAllAnnotations(new HashMap<String, String>())
            .putAllLabels(new HashMap<String, String>())
            .setReconciling(true)
            .addAllErrors(new ArrayList<Status>())
            .build();
    mockService.addResponse(expectedResponse);

    InsightsConfigName name = InsightsConfigName.of("[PROJECT]", "[LOCATION]", "[INSIGHTS_CONFIG]");

    InsightsConfig actualResponse = client.getInsightsConfig(name);
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
  public void getInsightsConfigExceptionTest() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

    try {
      InsightsConfigName name =
          InsightsConfigName.of("[PROJECT]", "[LOCATION]", "[INSIGHTS_CONFIG]");
      client.getInsightsConfig(name);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void getInsightsConfigTest2() throws Exception {
    InsightsConfig expectedResponse =
        InsightsConfig.newBuilder()
            .setName(
                InsightsConfigName.of("[PROJECT]", "[LOCATION]", "[INSIGHTS_CONFIG]").toString())
            .setCreateTime(Timestamp.newBuilder().build())
            .setUpdateTime(Timestamp.newBuilder().build())
            .addAllRuntimeConfigs(new ArrayList<RuntimeConfig>())
            .addAllArtifactConfigs(new ArrayList<ArtifactConfig>())
            .putAllAnnotations(new HashMap<String, String>())
            .putAllLabels(new HashMap<String, String>())
            .setReconciling(true)
            .addAllErrors(new ArrayList<Status>())
            .build();
    mockService.addResponse(expectedResponse);

    String name =
        "projects/project-9084/locations/location-9084/insightsConfigs/insightsConfig-9084";

    InsightsConfig actualResponse = client.getInsightsConfig(name);
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
  public void getInsightsConfigExceptionTest2() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

    try {
      String name =
          "projects/project-9084/locations/location-9084/insightsConfigs/insightsConfig-9084";
      client.getInsightsConfig(name);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void updateInsightsConfigTest() throws Exception {
    InsightsConfig expectedResponse =
        InsightsConfig.newBuilder()
            .setName(
                InsightsConfigName.of("[PROJECT]", "[LOCATION]", "[INSIGHTS_CONFIG]").toString())
            .setCreateTime(Timestamp.newBuilder().build())
            .setUpdateTime(Timestamp.newBuilder().build())
            .addAllRuntimeConfigs(new ArrayList<RuntimeConfig>())
            .addAllArtifactConfigs(new ArrayList<ArtifactConfig>())
            .putAllAnnotations(new HashMap<String, String>())
            .putAllLabels(new HashMap<String, String>())
            .setReconciling(true)
            .addAllErrors(new ArrayList<Status>())
            .build();
    Operation resultOperation =
        Operation.newBuilder()
            .setName("updateInsightsConfigTest")
            .setDone(true)
            .setResponse(Any.pack(expectedResponse))
            .build();
    mockService.addResponse(resultOperation);

    UpdateInsightsConfigRequest request =
        UpdateInsightsConfigRequest.newBuilder()
            .setInsightsConfig(
                InsightsConfig.newBuilder()
                    .setName(
                        InsightsConfigName.of("[PROJECT]", "[LOCATION]", "[INSIGHTS_CONFIG]")
                            .toString())
                    .setCreateTime(Timestamp.newBuilder().build())
                    .setUpdateTime(Timestamp.newBuilder().build())
                    .addAllRuntimeConfigs(new ArrayList<RuntimeConfig>())
                    .addAllArtifactConfigs(new ArrayList<ArtifactConfig>())
                    .putAllAnnotations(new HashMap<String, String>())
                    .putAllLabels(new HashMap<String, String>())
                    .setReconciling(true)
                    .addAllErrors(new ArrayList<Status>())
                    .build())
            .setRequestId("requestId693933066")
            .setAllowMissing(true)
            .setValidateOnly(true)
            .build();

    InsightsConfig actualResponse = client.updateInsightsConfigAsync(request).get();
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
  public void updateInsightsConfigExceptionTest() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

    try {
      UpdateInsightsConfigRequest request =
          UpdateInsightsConfigRequest.newBuilder()
              .setInsightsConfig(
                  InsightsConfig.newBuilder()
                      .setName(
                          InsightsConfigName.of("[PROJECT]", "[LOCATION]", "[INSIGHTS_CONFIG]")
                              .toString())
                      .setCreateTime(Timestamp.newBuilder().build())
                      .setUpdateTime(Timestamp.newBuilder().build())
                      .addAllRuntimeConfigs(new ArrayList<RuntimeConfig>())
                      .addAllArtifactConfigs(new ArrayList<ArtifactConfig>())
                      .putAllAnnotations(new HashMap<String, String>())
                      .putAllLabels(new HashMap<String, String>())
                      .setReconciling(true)
                      .addAllErrors(new ArrayList<Status>())
                      .build())
              .setRequestId("requestId693933066")
              .setAllowMissing(true)
              .setValidateOnly(true)
              .build();
      client.updateInsightsConfigAsync(request).get();
      Assert.fail("No exception raised");
    } catch (ExecutionException e) {
    }
  }

  @Test
  public void deleteInsightsConfigTest() throws Exception {
    Empty expectedResponse = Empty.newBuilder().build();
    Operation resultOperation =
        Operation.newBuilder()
            .setName("deleteInsightsConfigTest")
            .setDone(true)
            .setResponse(Any.pack(expectedResponse))
            .build();
    mockService.addResponse(resultOperation);

    InsightsConfigName name = InsightsConfigName.of("[PROJECT]", "[LOCATION]", "[INSIGHTS_CONFIG]");

    client.deleteInsightsConfigAsync(name).get();

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
  public void deleteInsightsConfigExceptionTest() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

    try {
      InsightsConfigName name =
          InsightsConfigName.of("[PROJECT]", "[LOCATION]", "[INSIGHTS_CONFIG]");
      client.deleteInsightsConfigAsync(name).get();
      Assert.fail("No exception raised");
    } catch (ExecutionException e) {
    }
  }

  @Test
  public void deleteInsightsConfigTest2() throws Exception {
    Empty expectedResponse = Empty.newBuilder().build();
    Operation resultOperation =
        Operation.newBuilder()
            .setName("deleteInsightsConfigTest")
            .setDone(true)
            .setResponse(Any.pack(expectedResponse))
            .build();
    mockService.addResponse(resultOperation);

    String name =
        "projects/project-9084/locations/location-9084/insightsConfigs/insightsConfig-9084";

    client.deleteInsightsConfigAsync(name).get();

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
  public void deleteInsightsConfigExceptionTest2() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

    try {
      String name =
          "projects/project-9084/locations/location-9084/insightsConfigs/insightsConfig-9084";
      client.deleteInsightsConfigAsync(name).get();
      Assert.fail("No exception raised");
    } catch (ExecutionException e) {
    }
  }

  @Test
  public void listLocationsTest() throws Exception {
    Location responsesElement = Location.newBuilder().build();
    ListLocationsResponse expectedResponse =
        ListLocationsResponse.newBuilder()
            .setNextPageToken("")
            .addAllLocations(Arrays.asList(responsesElement))
            .build();
    mockService.addResponse(expectedResponse);

    ListLocationsRequest request =
        ListLocationsRequest.newBuilder()
            .setName("projects/project-3664")
            .setFilter("filter-1274492040")
            .setPageSize(883849137)
            .setPageToken("pageToken873572522")
            .build();

    ListLocationsPagedResponse pagedListResponse = client.listLocations(request);

    List<Location> resources = Lists.newArrayList(pagedListResponse.iterateAll());

    Assert.assertEquals(1, resources.size());
    Assert.assertEquals(expectedResponse.getLocationsList().get(0), resources.get(0));

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
  public void listLocationsExceptionTest() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

    try {
      ListLocationsRequest request =
          ListLocationsRequest.newBuilder()
              .setName("projects/project-3664")
              .setFilter("filter-1274492040")
              .setPageSize(883849137)
              .setPageToken("pageToken873572522")
              .build();
      client.listLocations(request);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void getLocationTest() throws Exception {
    Location expectedResponse =
        Location.newBuilder()
            .setName("name3373707")
            .setLocationId("locationId1541836720")
            .setDisplayName("displayName1714148973")
            .putAllLabels(new HashMap<String, String>())
            .setMetadata(Any.newBuilder().build())
            .build();
    mockService.addResponse(expectedResponse);

    GetLocationRequest request =
        GetLocationRequest.newBuilder()
            .setName("projects/project-9062/locations/location-9062")
            .build();

    Location actualResponse = client.getLocation(request);
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
  public void getLocationExceptionTest() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

    try {
      GetLocationRequest request =
          GetLocationRequest.newBuilder()
              .setName("projects/project-9062/locations/location-9062")
              .build();
      client.getLocation(request);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }
}
