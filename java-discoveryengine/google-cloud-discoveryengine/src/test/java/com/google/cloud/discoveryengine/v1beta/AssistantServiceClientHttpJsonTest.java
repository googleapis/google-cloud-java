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

package com.google.cloud.discoveryengine.v1beta;

import static com.google.cloud.discoveryengine.v1beta.AssistantServiceClient.ListAssistantsPagedResponse;

import com.google.api.gax.core.NoCredentialsProvider;
import com.google.api.gax.httpjson.GaxHttpJsonProperties;
import com.google.api.gax.httpjson.testing.MockHttpService;
import com.google.api.gax.rpc.ApiClientHeaderProvider;
import com.google.api.gax.rpc.ApiException;
import com.google.api.gax.rpc.ApiExceptionFactory;
import com.google.api.gax.rpc.InvalidArgumentException;
import com.google.api.gax.rpc.StatusCode;
import com.google.api.gax.rpc.testing.FakeStatusCode;
import com.google.cloud.discoveryengine.v1beta.stub.HttpJsonAssistantServiceStub;
import com.google.common.collect.Lists;
import com.google.protobuf.Empty;
import com.google.protobuf.FieldMask;
import com.google.protobuf.Timestamp;
import java.io.IOException;
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
public class AssistantServiceClientHttpJsonTest {
  private static MockHttpService mockService;
  private static AssistantServiceClient client;

  @BeforeClass
  public static void startStaticServer() throws IOException {
    mockService =
        new MockHttpService(
            HttpJsonAssistantServiceStub.getMethodDescriptors(),
            AssistantServiceSettings.getDefaultEndpoint());
    AssistantServiceSettings settings =
        AssistantServiceSettings.newHttpJsonBuilder()
            .setTransportChannelProvider(
                AssistantServiceSettings.defaultHttpJsonTransportProviderBuilder()
                    .setHttpTransport(mockService)
                    .build())
            .setCredentialsProvider(NoCredentialsProvider.create())
            .build();
    client = AssistantServiceClient.create(settings);
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
  public void streamAssistTest() throws Exception {}

  @Test
  public void streamAssistExceptionTest() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);
  }

  @Test
  public void createAssistantTest() throws Exception {
    Assistant expectedResponse =
        Assistant.newBuilder()
            .setName(
                AssistantName.of(
                        "[PROJECT]", "[LOCATION]", "[COLLECTION]", "[ENGINE]", "[ASSISTANT]")
                    .toString())
            .setDisplayName("displayName1714148973")
            .setDescription("description-1724546052")
            .setGenerationConfig(Assistant.GenerationConfig.newBuilder().build())
            .setDefaultWebGroundingToggleOff(true)
            .putAllEnabledTools(new HashMap<String, Assistant.ToolList>())
            .setCustomerPolicy(Assistant.CustomerPolicy.newBuilder().build())
            .setCreateTime(Timestamp.newBuilder().build())
            .setUpdateTime(Timestamp.newBuilder().build())
            .build();
    mockService.addResponse(expectedResponse);

    CreateAssistantRequest request =
        CreateAssistantRequest.newBuilder()
            .setParent(
                EngineName.of("[PROJECT]", "[LOCATION]", "[COLLECTION]", "[ENGINE]").toString())
            .setAssistant(Assistant.newBuilder().build())
            .setAssistantId("assistantId-324518759")
            .build();

    Assistant actualResponse = client.createAssistant(request);
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
  public void createAssistantExceptionTest() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

    try {
      CreateAssistantRequest request =
          CreateAssistantRequest.newBuilder()
              .setParent(
                  EngineName.of("[PROJECT]", "[LOCATION]", "[COLLECTION]", "[ENGINE]").toString())
              .setAssistant(Assistant.newBuilder().build())
              .setAssistantId("assistantId-324518759")
              .build();
      client.createAssistant(request);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void deleteAssistantTest() throws Exception {
    Empty expectedResponse = Empty.newBuilder().build();
    mockService.addResponse(expectedResponse);

    AssistantName name =
        AssistantName.of("[PROJECT]", "[LOCATION]", "[COLLECTION]", "[ENGINE]", "[ASSISTANT]");

    client.deleteAssistant(name);

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
  public void deleteAssistantExceptionTest() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

    try {
      AssistantName name =
          AssistantName.of("[PROJECT]", "[LOCATION]", "[COLLECTION]", "[ENGINE]", "[ASSISTANT]");
      client.deleteAssistant(name);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void deleteAssistantTest2() throws Exception {
    Empty expectedResponse = Empty.newBuilder().build();
    mockService.addResponse(expectedResponse);

    String name =
        "projects/project-3577/locations/location-3577/collections/collection-3577/engines/engine-3577/assistants/assistant-3577";

    client.deleteAssistant(name);

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
  public void deleteAssistantExceptionTest2() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

    try {
      String name =
          "projects/project-3577/locations/location-3577/collections/collection-3577/engines/engine-3577/assistants/assistant-3577";
      client.deleteAssistant(name);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void updateAssistantTest() throws Exception {
    Assistant expectedResponse =
        Assistant.newBuilder()
            .setName(
                AssistantName.of(
                        "[PROJECT]", "[LOCATION]", "[COLLECTION]", "[ENGINE]", "[ASSISTANT]")
                    .toString())
            .setDisplayName("displayName1714148973")
            .setDescription("description-1724546052")
            .setGenerationConfig(Assistant.GenerationConfig.newBuilder().build())
            .setDefaultWebGroundingToggleOff(true)
            .putAllEnabledTools(new HashMap<String, Assistant.ToolList>())
            .setCustomerPolicy(Assistant.CustomerPolicy.newBuilder().build())
            .setCreateTime(Timestamp.newBuilder().build())
            .setUpdateTime(Timestamp.newBuilder().build())
            .build();
    mockService.addResponse(expectedResponse);

    Assistant assistant =
        Assistant.newBuilder()
            .setName(
                AssistantName.of(
                        "[PROJECT]", "[LOCATION]", "[COLLECTION]", "[ENGINE]", "[ASSISTANT]")
                    .toString())
            .setDisplayName("displayName1714148973")
            .setDescription("description-1724546052")
            .setGenerationConfig(Assistant.GenerationConfig.newBuilder().build())
            .setDefaultWebGroundingToggleOff(true)
            .putAllEnabledTools(new HashMap<String, Assistant.ToolList>())
            .setCustomerPolicy(Assistant.CustomerPolicy.newBuilder().build())
            .setCreateTime(Timestamp.newBuilder().build())
            .setUpdateTime(Timestamp.newBuilder().build())
            .build();
    FieldMask updateMask = FieldMask.newBuilder().build();

    Assistant actualResponse = client.updateAssistant(assistant, updateMask);
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
  public void updateAssistantExceptionTest() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

    try {
      Assistant assistant =
          Assistant.newBuilder()
              .setName(
                  AssistantName.of(
                          "[PROJECT]", "[LOCATION]", "[COLLECTION]", "[ENGINE]", "[ASSISTANT]")
                      .toString())
              .setDisplayName("displayName1714148973")
              .setDescription("description-1724546052")
              .setGenerationConfig(Assistant.GenerationConfig.newBuilder().build())
              .setDefaultWebGroundingToggleOff(true)
              .putAllEnabledTools(new HashMap<String, Assistant.ToolList>())
              .setCustomerPolicy(Assistant.CustomerPolicy.newBuilder().build())
              .setCreateTime(Timestamp.newBuilder().build())
              .setUpdateTime(Timestamp.newBuilder().build())
              .build();
      FieldMask updateMask = FieldMask.newBuilder().build();
      client.updateAssistant(assistant, updateMask);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void getAssistantTest() throws Exception {
    Assistant expectedResponse =
        Assistant.newBuilder()
            .setName(
                AssistantName.of(
                        "[PROJECT]", "[LOCATION]", "[COLLECTION]", "[ENGINE]", "[ASSISTANT]")
                    .toString())
            .setDisplayName("displayName1714148973")
            .setDescription("description-1724546052")
            .setGenerationConfig(Assistant.GenerationConfig.newBuilder().build())
            .setDefaultWebGroundingToggleOff(true)
            .putAllEnabledTools(new HashMap<String, Assistant.ToolList>())
            .setCustomerPolicy(Assistant.CustomerPolicy.newBuilder().build())
            .setCreateTime(Timestamp.newBuilder().build())
            .setUpdateTime(Timestamp.newBuilder().build())
            .build();
    mockService.addResponse(expectedResponse);

    AssistantName name =
        AssistantName.of("[PROJECT]", "[LOCATION]", "[COLLECTION]", "[ENGINE]", "[ASSISTANT]");

    Assistant actualResponse = client.getAssistant(name);
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
  public void getAssistantExceptionTest() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

    try {
      AssistantName name =
          AssistantName.of("[PROJECT]", "[LOCATION]", "[COLLECTION]", "[ENGINE]", "[ASSISTANT]");
      client.getAssistant(name);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void getAssistantTest2() throws Exception {
    Assistant expectedResponse =
        Assistant.newBuilder()
            .setName(
                AssistantName.of(
                        "[PROJECT]", "[LOCATION]", "[COLLECTION]", "[ENGINE]", "[ASSISTANT]")
                    .toString())
            .setDisplayName("displayName1714148973")
            .setDescription("description-1724546052")
            .setGenerationConfig(Assistant.GenerationConfig.newBuilder().build())
            .setDefaultWebGroundingToggleOff(true)
            .putAllEnabledTools(new HashMap<String, Assistant.ToolList>())
            .setCustomerPolicy(Assistant.CustomerPolicy.newBuilder().build())
            .setCreateTime(Timestamp.newBuilder().build())
            .setUpdateTime(Timestamp.newBuilder().build())
            .build();
    mockService.addResponse(expectedResponse);

    String name =
        "projects/project-3577/locations/location-3577/collections/collection-3577/engines/engine-3577/assistants/assistant-3577";

    Assistant actualResponse = client.getAssistant(name);
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
  public void getAssistantExceptionTest2() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

    try {
      String name =
          "projects/project-3577/locations/location-3577/collections/collection-3577/engines/engine-3577/assistants/assistant-3577";
      client.getAssistant(name);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void listAssistantsTest() throws Exception {
    Assistant responsesElement = Assistant.newBuilder().build();
    ListAssistantsResponse expectedResponse =
        ListAssistantsResponse.newBuilder()
            .setNextPageToken("")
            .addAllAssistants(Arrays.asList(responsesElement))
            .build();
    mockService.addResponse(expectedResponse);

    EngineName parent = EngineName.of("[PROJECT]", "[LOCATION]", "[COLLECTION]", "[ENGINE]");

    ListAssistantsPagedResponse pagedListResponse = client.listAssistants(parent);

    List<Assistant> resources = Lists.newArrayList(pagedListResponse.iterateAll());

    Assert.assertEquals(1, resources.size());
    Assert.assertEquals(expectedResponse.getAssistantsList().get(0), resources.get(0));

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
  public void listAssistantsExceptionTest() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

    try {
      EngineName parent = EngineName.of("[PROJECT]", "[LOCATION]", "[COLLECTION]", "[ENGINE]");
      client.listAssistants(parent);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void listAssistantsTest2() throws Exception {
    Assistant responsesElement = Assistant.newBuilder().build();
    ListAssistantsResponse expectedResponse =
        ListAssistantsResponse.newBuilder()
            .setNextPageToken("")
            .addAllAssistants(Arrays.asList(responsesElement))
            .build();
    mockService.addResponse(expectedResponse);

    String parent =
        "projects/project-6937/locations/location-6937/collections/collection-6937/engines/engine-6937";

    ListAssistantsPagedResponse pagedListResponse = client.listAssistants(parent);

    List<Assistant> resources = Lists.newArrayList(pagedListResponse.iterateAll());

    Assert.assertEquals(1, resources.size());
    Assert.assertEquals(expectedResponse.getAssistantsList().get(0), resources.get(0));

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
  public void listAssistantsExceptionTest2() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

    try {
      String parent =
          "projects/project-6937/locations/location-6937/collections/collection-6937/engines/engine-6937";
      client.listAssistants(parent);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }
}
