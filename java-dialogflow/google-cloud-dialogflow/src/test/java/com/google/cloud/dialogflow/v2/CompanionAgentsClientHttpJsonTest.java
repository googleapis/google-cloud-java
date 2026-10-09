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

package com.google.cloud.dialogflow.v2;

import static com.google.cloud.dialogflow.v2.CompanionAgentsClient.ListCompanionAgentsPagedResponse;
import static com.google.cloud.dialogflow.v2.CompanionAgentsClient.ListLocationsPagedResponse;

import com.google.api.gax.core.NoCredentialsProvider;
import com.google.api.gax.httpjson.GaxHttpJsonProperties;
import com.google.api.gax.httpjson.testing.MockHttpService;
import com.google.api.gax.rpc.ApiClientHeaderProvider;
import com.google.api.gax.rpc.ApiException;
import com.google.api.gax.rpc.ApiExceptionFactory;
import com.google.api.gax.rpc.InvalidArgumentException;
import com.google.api.gax.rpc.StatusCode;
import com.google.api.gax.rpc.testing.FakeStatusCode;
import com.google.cloud.dialogflow.v2.stub.HttpJsonCompanionAgentsStub;
import com.google.cloud.location.GetLocationRequest;
import com.google.cloud.location.ListLocationsRequest;
import com.google.cloud.location.ListLocationsResponse;
import com.google.cloud.location.Location;
import com.google.common.collect.Lists;
import com.google.protobuf.Any;
import com.google.protobuf.Empty;
import com.google.protobuf.FieldMask;
import com.google.protobuf.Timestamp;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import javax.annotation.Generated;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Assert;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

@Generated("by gapic-generator-java")
public class CompanionAgentsClientHttpJsonTest {
  private static MockHttpService mockService;
  private static CompanionAgentsClient client;

  @BeforeClass
  public static void startStaticServer() throws IOException {
    mockService =
        new MockHttpService(
            HttpJsonCompanionAgentsStub.getMethodDescriptors(),
            CompanionAgentsSettings.getDefaultEndpoint());
    CompanionAgentsSettings settings =
        CompanionAgentsSettings.newHttpJsonBuilder()
            .setTransportChannelProvider(
                CompanionAgentsSettings.defaultHttpJsonTransportProviderBuilder()
                    .setHttpTransport(mockService)
                    .build())
            .setCredentialsProvider(NoCredentialsProvider.create())
            .build();
    client = CompanionAgentsClient.create(settings);
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
  public void createCompanionAgentTest() throws Exception {
    CompanionAgent expectedResponse =
        CompanionAgent.newBuilder()
            .setName(
                CompanionAgentName.of("[PROJECT]", "[LOCATION]", "[COMPANION_AGENT]").toString())
            .setCreateTime(Timestamp.newBuilder().build())
            .setUpdateTime(Timestamp.newBuilder().build())
            .addAllToolsetTools(new ArrayList<ToolsetTool>())
            .addAllCesToolSpecs(new ArrayList<CesToolSpec>())
            .setDisplayName("displayName1714148973")
            .setDescription("description-1724546052")
            .addAllSkillConfigs(new ArrayList<CompanionAgent.SkillConfig>())
            .build();
    mockService.addResponse(expectedResponse);

    LocationName parent = LocationName.of("[PROJECT]", "[LOCATION]");
    CompanionAgent companionAgent = CompanionAgent.newBuilder().build();
    String companionAgentId = "companionAgentId-580252076";

    CompanionAgent actualResponse =
        client.createCompanionAgent(parent, companionAgent, companionAgentId);
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
  public void createCompanionAgentExceptionTest() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

    try {
      LocationName parent = LocationName.of("[PROJECT]", "[LOCATION]");
      CompanionAgent companionAgent = CompanionAgent.newBuilder().build();
      String companionAgentId = "companionAgentId-580252076";
      client.createCompanionAgent(parent, companionAgent, companionAgentId);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void createCompanionAgentTest2() throws Exception {
    CompanionAgent expectedResponse =
        CompanionAgent.newBuilder()
            .setName(
                CompanionAgentName.of("[PROJECT]", "[LOCATION]", "[COMPANION_AGENT]").toString())
            .setCreateTime(Timestamp.newBuilder().build())
            .setUpdateTime(Timestamp.newBuilder().build())
            .addAllToolsetTools(new ArrayList<ToolsetTool>())
            .addAllCesToolSpecs(new ArrayList<CesToolSpec>())
            .setDisplayName("displayName1714148973")
            .setDescription("description-1724546052")
            .addAllSkillConfigs(new ArrayList<CompanionAgent.SkillConfig>())
            .build();
    mockService.addResponse(expectedResponse);

    String parent = "projects/project-5833/locations/location-5833";
    CompanionAgent companionAgent = CompanionAgent.newBuilder().build();
    String companionAgentId = "companionAgentId-580252076";

    CompanionAgent actualResponse =
        client.createCompanionAgent(parent, companionAgent, companionAgentId);
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
  public void createCompanionAgentExceptionTest2() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

    try {
      String parent = "projects/project-5833/locations/location-5833";
      CompanionAgent companionAgent = CompanionAgent.newBuilder().build();
      String companionAgentId = "companionAgentId-580252076";
      client.createCompanionAgent(parent, companionAgent, companionAgentId);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void getCompanionAgentTest() throws Exception {
    CompanionAgent expectedResponse =
        CompanionAgent.newBuilder()
            .setName(
                CompanionAgentName.of("[PROJECT]", "[LOCATION]", "[COMPANION_AGENT]").toString())
            .setCreateTime(Timestamp.newBuilder().build())
            .setUpdateTime(Timestamp.newBuilder().build())
            .addAllToolsetTools(new ArrayList<ToolsetTool>())
            .addAllCesToolSpecs(new ArrayList<CesToolSpec>())
            .setDisplayName("displayName1714148973")
            .setDescription("description-1724546052")
            .addAllSkillConfigs(new ArrayList<CompanionAgent.SkillConfig>())
            .build();
    mockService.addResponse(expectedResponse);

    CompanionAgentName name = CompanionAgentName.of("[PROJECT]", "[LOCATION]", "[COMPANION_AGENT]");

    CompanionAgent actualResponse = client.getCompanionAgent(name);
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
  public void getCompanionAgentExceptionTest() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

    try {
      CompanionAgentName name =
          CompanionAgentName.of("[PROJECT]", "[LOCATION]", "[COMPANION_AGENT]");
      client.getCompanionAgent(name);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void getCompanionAgentTest2() throws Exception {
    CompanionAgent expectedResponse =
        CompanionAgent.newBuilder()
            .setName(
                CompanionAgentName.of("[PROJECT]", "[LOCATION]", "[COMPANION_AGENT]").toString())
            .setCreateTime(Timestamp.newBuilder().build())
            .setUpdateTime(Timestamp.newBuilder().build())
            .addAllToolsetTools(new ArrayList<ToolsetTool>())
            .addAllCesToolSpecs(new ArrayList<CesToolSpec>())
            .setDisplayName("displayName1714148973")
            .setDescription("description-1724546052")
            .addAllSkillConfigs(new ArrayList<CompanionAgent.SkillConfig>())
            .build();
    mockService.addResponse(expectedResponse);

    String name =
        "projects/project-8720/locations/location-8720/companionAgents/companionAgent-8720";

    CompanionAgent actualResponse = client.getCompanionAgent(name);
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
  public void getCompanionAgentExceptionTest2() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

    try {
      String name =
          "projects/project-8720/locations/location-8720/companionAgents/companionAgent-8720";
      client.getCompanionAgent(name);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void updateCompanionAgentTest() throws Exception {
    CompanionAgent expectedResponse =
        CompanionAgent.newBuilder()
            .setName(
                CompanionAgentName.of("[PROJECT]", "[LOCATION]", "[COMPANION_AGENT]").toString())
            .setCreateTime(Timestamp.newBuilder().build())
            .setUpdateTime(Timestamp.newBuilder().build())
            .addAllToolsetTools(new ArrayList<ToolsetTool>())
            .addAllCesToolSpecs(new ArrayList<CesToolSpec>())
            .setDisplayName("displayName1714148973")
            .setDescription("description-1724546052")
            .addAllSkillConfigs(new ArrayList<CompanionAgent.SkillConfig>())
            .build();
    mockService.addResponse(expectedResponse);

    CompanionAgent companionAgent =
        CompanionAgent.newBuilder()
            .setName(
                CompanionAgentName.of("[PROJECT]", "[LOCATION]", "[COMPANION_AGENT]").toString())
            .setCreateTime(Timestamp.newBuilder().build())
            .setUpdateTime(Timestamp.newBuilder().build())
            .addAllToolsetTools(new ArrayList<ToolsetTool>())
            .addAllCesToolSpecs(new ArrayList<CesToolSpec>())
            .setDisplayName("displayName1714148973")
            .setDescription("description-1724546052")
            .addAllSkillConfigs(new ArrayList<CompanionAgent.SkillConfig>())
            .build();
    FieldMask updateMask = FieldMask.newBuilder().build();

    CompanionAgent actualResponse = client.updateCompanionAgent(companionAgent, updateMask);
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
  public void updateCompanionAgentExceptionTest() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

    try {
      CompanionAgent companionAgent =
          CompanionAgent.newBuilder()
              .setName(
                  CompanionAgentName.of("[PROJECT]", "[LOCATION]", "[COMPANION_AGENT]").toString())
              .setCreateTime(Timestamp.newBuilder().build())
              .setUpdateTime(Timestamp.newBuilder().build())
              .addAllToolsetTools(new ArrayList<ToolsetTool>())
              .addAllCesToolSpecs(new ArrayList<CesToolSpec>())
              .setDisplayName("displayName1714148973")
              .setDescription("description-1724546052")
              .addAllSkillConfigs(new ArrayList<CompanionAgent.SkillConfig>())
              .build();
      FieldMask updateMask = FieldMask.newBuilder().build();
      client.updateCompanionAgent(companionAgent, updateMask);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void deleteCompanionAgentTest() throws Exception {
    Empty expectedResponse = Empty.newBuilder().build();
    mockService.addResponse(expectedResponse);

    CompanionAgentName name = CompanionAgentName.of("[PROJECT]", "[LOCATION]", "[COMPANION_AGENT]");

    client.deleteCompanionAgent(name);

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
  public void deleteCompanionAgentExceptionTest() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

    try {
      CompanionAgentName name =
          CompanionAgentName.of("[PROJECT]", "[LOCATION]", "[COMPANION_AGENT]");
      client.deleteCompanionAgent(name);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void deleteCompanionAgentTest2() throws Exception {
    Empty expectedResponse = Empty.newBuilder().build();
    mockService.addResponse(expectedResponse);

    String name =
        "projects/project-8720/locations/location-8720/companionAgents/companionAgent-8720";

    client.deleteCompanionAgent(name);

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
  public void deleteCompanionAgentExceptionTest2() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

    try {
      String name =
          "projects/project-8720/locations/location-8720/companionAgents/companionAgent-8720";
      client.deleteCompanionAgent(name);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void listCompanionAgentsTest() throws Exception {
    CompanionAgent responsesElement = CompanionAgent.newBuilder().build();
    ListCompanionAgentsResponse expectedResponse =
        ListCompanionAgentsResponse.newBuilder()
            .setNextPageToken("")
            .addAllCompanionAgents(Arrays.asList(responsesElement))
            .build();
    mockService.addResponse(expectedResponse);

    LocationName parent = LocationName.of("[PROJECT]", "[LOCATION]");

    ListCompanionAgentsPagedResponse pagedListResponse = client.listCompanionAgents(parent);

    List<CompanionAgent> resources = Lists.newArrayList(pagedListResponse.iterateAll());

    Assert.assertEquals(1, resources.size());
    Assert.assertEquals(expectedResponse.getCompanionAgentsList().get(0), resources.get(0));

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
  public void listCompanionAgentsExceptionTest() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

    try {
      LocationName parent = LocationName.of("[PROJECT]", "[LOCATION]");
      client.listCompanionAgents(parent);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void listCompanionAgentsTest2() throws Exception {
    CompanionAgent responsesElement = CompanionAgent.newBuilder().build();
    ListCompanionAgentsResponse expectedResponse =
        ListCompanionAgentsResponse.newBuilder()
            .setNextPageToken("")
            .addAllCompanionAgents(Arrays.asList(responsesElement))
            .build();
    mockService.addResponse(expectedResponse);

    String parent = "projects/project-5833/locations/location-5833";

    ListCompanionAgentsPagedResponse pagedListResponse = client.listCompanionAgents(parent);

    List<CompanionAgent> resources = Lists.newArrayList(pagedListResponse.iterateAll());

    Assert.assertEquals(1, resources.size());
    Assert.assertEquals(expectedResponse.getCompanionAgentsList().get(0), resources.get(0));

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
  public void listCompanionAgentsExceptionTest2() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

    try {
      String parent = "projects/project-5833/locations/location-5833";
      client.listCompanionAgents(parent);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
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
