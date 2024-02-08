/*
 * Copyright 2023 Google LLC
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

package com.google.cloud.dialogflow.cx.v3beta1;

import static com.google.cloud.dialogflow.cx.v3beta1.ExamplesClient.ListExamplesPagedResponse;
import static com.google.cloud.dialogflow.cx.v3beta1.ExamplesClient.ListLocationsPagedResponse;

import com.google.api.gax.core.NoCredentialsProvider;
import com.google.api.gax.httpjson.GaxHttpJsonProperties;
import com.google.api.gax.httpjson.testing.MockHttpService;
import com.google.api.gax.rpc.ApiClientHeaderProvider;
import com.google.api.gax.rpc.ApiException;
import com.google.api.gax.rpc.ApiExceptionFactory;
import com.google.api.gax.rpc.InvalidArgumentException;
import com.google.api.gax.rpc.StatusCode;
import com.google.api.gax.rpc.testing.FakeStatusCode;
import com.google.cloud.dialogflow.cx.v3beta1.stub.HttpJsonExamplesStub;
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
public class ExamplesClientHttpJsonTest {
  private static MockHttpService mockService;
  private static ExamplesClient client;

  @BeforeClass
  public static void startStaticServer() throws IOException {
    mockService =
        new MockHttpService(
            HttpJsonExamplesStub.getMethodDescriptors(), ExamplesSettings.getDefaultEndpoint());
    ExamplesSettings settings =
        ExamplesSettings.newHttpJsonBuilder()
            .setTransportChannelProvider(
                ExamplesSettings.defaultHttpJsonTransportProviderBuilder()
                    .setHttpTransport(mockService)
                    .build())
            .setCredentialsProvider(NoCredentialsProvider.create())
            .build();
    client = ExamplesClient.create(settings);
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
  public void createExampleTest() throws Exception {
    Example expectedResponse =
        Example.newBuilder()
            .setName(
                ExampleName.of("[PROJECT]", "[LOCATION]", "[AGENT]", "[PLAYBOOK]", "[EXAMPLE]")
                    .toString())
            .setPlaybookInput(PlaybookInput.newBuilder().build())
            .setPlaybookOutput(PlaybookOutput.newBuilder().build())
            .addAllActions(new ArrayList<Action>())
            .setDisplayName("displayName1714148973")
            .setDescription("description-1724546052")
            .setTokenCount(-1164226743)
            .setCreateTime(Timestamp.newBuilder().build())
            .setUpdateTime(Timestamp.newBuilder().build())
            .setConversationState(OutputState.forNumber(0))
            .setLanguageCode("languageCode-2092349083")
            .build();
    mockService.addResponse(expectedResponse);

    PlaybookName parent = PlaybookName.of("[PROJECT]", "[LOCATION]", "[AGENT]", "[PLAYBOOK]");
    Example example = Example.newBuilder().build();

    Example actualResponse = client.createExample(parent, example);
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
  public void createExampleExceptionTest() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

    try {
      PlaybookName parent = PlaybookName.of("[PROJECT]", "[LOCATION]", "[AGENT]", "[PLAYBOOK]");
      Example example = Example.newBuilder().build();
      client.createExample(parent, example);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void createExampleTest2() throws Exception {
    Example expectedResponse =
        Example.newBuilder()
            .setName(
                ExampleName.of("[PROJECT]", "[LOCATION]", "[AGENT]", "[PLAYBOOK]", "[EXAMPLE]")
                    .toString())
            .setPlaybookInput(PlaybookInput.newBuilder().build())
            .setPlaybookOutput(PlaybookOutput.newBuilder().build())
            .addAllActions(new ArrayList<Action>())
            .setDisplayName("displayName1714148973")
            .setDescription("description-1724546052")
            .setTokenCount(-1164226743)
            .setCreateTime(Timestamp.newBuilder().build())
            .setUpdateTime(Timestamp.newBuilder().build())
            .setConversationState(OutputState.forNumber(0))
            .setLanguageCode("languageCode-2092349083")
            .build();
    mockService.addResponse(expectedResponse);

    String parent =
        "projects/project-897/locations/location-897/agents/agent-897/playbooks/playbook-897";
    Example example = Example.newBuilder().build();

    Example actualResponse = client.createExample(parent, example);
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
  public void createExampleExceptionTest2() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

    try {
      String parent =
          "projects/project-897/locations/location-897/agents/agent-897/playbooks/playbook-897";
      Example example = Example.newBuilder().build();
      client.createExample(parent, example);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void deleteExampleTest() throws Exception {
    Empty expectedResponse = Empty.newBuilder().build();
    mockService.addResponse(expectedResponse);

    ExampleName name =
        ExampleName.of("[PROJECT]", "[LOCATION]", "[AGENT]", "[PLAYBOOK]", "[EXAMPLE]");

    client.deleteExample(name);

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
  public void deleteExampleExceptionTest() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

    try {
      ExampleName name =
          ExampleName.of("[PROJECT]", "[LOCATION]", "[AGENT]", "[PLAYBOOK]", "[EXAMPLE]");
      client.deleteExample(name);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void deleteExampleTest2() throws Exception {
    Empty expectedResponse = Empty.newBuilder().build();
    mockService.addResponse(expectedResponse);

    String name =
        "projects/project-7619/locations/location-7619/agents/agent-7619/playbooks/playbook-7619/examples/example-7619";

    client.deleteExample(name);

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
  public void deleteExampleExceptionTest2() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

    try {
      String name =
          "projects/project-7619/locations/location-7619/agents/agent-7619/playbooks/playbook-7619/examples/example-7619";
      client.deleteExample(name);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void listExamplesTest() throws Exception {
    Example responsesElement = Example.newBuilder().build();
    ListExamplesResponse expectedResponse =
        ListExamplesResponse.newBuilder()
            .setNextPageToken("")
            .addAllExamples(Arrays.asList(responsesElement))
            .build();
    mockService.addResponse(expectedResponse);

    PlaybookName parent = PlaybookName.of("[PROJECT]", "[LOCATION]", "[AGENT]", "[PLAYBOOK]");

    ListExamplesPagedResponse pagedListResponse = client.listExamples(parent);

    List<Example> resources = Lists.newArrayList(pagedListResponse.iterateAll());

    Assert.assertEquals(1, resources.size());
    Assert.assertEquals(expectedResponse.getExamplesList().get(0), resources.get(0));

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
  public void listExamplesExceptionTest() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

    try {
      PlaybookName parent = PlaybookName.of("[PROJECT]", "[LOCATION]", "[AGENT]", "[PLAYBOOK]");
      client.listExamples(parent);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void listExamplesTest2() throws Exception {
    Example responsesElement = Example.newBuilder().build();
    ListExamplesResponse expectedResponse =
        ListExamplesResponse.newBuilder()
            .setNextPageToken("")
            .addAllExamples(Arrays.asList(responsesElement))
            .build();
    mockService.addResponse(expectedResponse);

    String parent =
        "projects/project-897/locations/location-897/agents/agent-897/playbooks/playbook-897";

    ListExamplesPagedResponse pagedListResponse = client.listExamples(parent);

    List<Example> resources = Lists.newArrayList(pagedListResponse.iterateAll());

    Assert.assertEquals(1, resources.size());
    Assert.assertEquals(expectedResponse.getExamplesList().get(0), resources.get(0));

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
  public void listExamplesExceptionTest2() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

    try {
      String parent =
          "projects/project-897/locations/location-897/agents/agent-897/playbooks/playbook-897";
      client.listExamples(parent);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void getExampleTest() throws Exception {
    Example expectedResponse =
        Example.newBuilder()
            .setName(
                ExampleName.of("[PROJECT]", "[LOCATION]", "[AGENT]", "[PLAYBOOK]", "[EXAMPLE]")
                    .toString())
            .setPlaybookInput(PlaybookInput.newBuilder().build())
            .setPlaybookOutput(PlaybookOutput.newBuilder().build())
            .addAllActions(new ArrayList<Action>())
            .setDisplayName("displayName1714148973")
            .setDescription("description-1724546052")
            .setTokenCount(-1164226743)
            .setCreateTime(Timestamp.newBuilder().build())
            .setUpdateTime(Timestamp.newBuilder().build())
            .setConversationState(OutputState.forNumber(0))
            .setLanguageCode("languageCode-2092349083")
            .build();
    mockService.addResponse(expectedResponse);

    ExampleName name =
        ExampleName.of("[PROJECT]", "[LOCATION]", "[AGENT]", "[PLAYBOOK]", "[EXAMPLE]");

    Example actualResponse = client.getExample(name);
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
  public void getExampleExceptionTest() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

    try {
      ExampleName name =
          ExampleName.of("[PROJECT]", "[LOCATION]", "[AGENT]", "[PLAYBOOK]", "[EXAMPLE]");
      client.getExample(name);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void getExampleTest2() throws Exception {
    Example expectedResponse =
        Example.newBuilder()
            .setName(
                ExampleName.of("[PROJECT]", "[LOCATION]", "[AGENT]", "[PLAYBOOK]", "[EXAMPLE]")
                    .toString())
            .setPlaybookInput(PlaybookInput.newBuilder().build())
            .setPlaybookOutput(PlaybookOutput.newBuilder().build())
            .addAllActions(new ArrayList<Action>())
            .setDisplayName("displayName1714148973")
            .setDescription("description-1724546052")
            .setTokenCount(-1164226743)
            .setCreateTime(Timestamp.newBuilder().build())
            .setUpdateTime(Timestamp.newBuilder().build())
            .setConversationState(OutputState.forNumber(0))
            .setLanguageCode("languageCode-2092349083")
            .build();
    mockService.addResponse(expectedResponse);

    String name =
        "projects/project-7619/locations/location-7619/agents/agent-7619/playbooks/playbook-7619/examples/example-7619";

    Example actualResponse = client.getExample(name);
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
  public void getExampleExceptionTest2() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

    try {
      String name =
          "projects/project-7619/locations/location-7619/agents/agent-7619/playbooks/playbook-7619/examples/example-7619";
      client.getExample(name);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void updateExampleTest() throws Exception {
    Example expectedResponse =
        Example.newBuilder()
            .setName(
                ExampleName.of("[PROJECT]", "[LOCATION]", "[AGENT]", "[PLAYBOOK]", "[EXAMPLE]")
                    .toString())
            .setPlaybookInput(PlaybookInput.newBuilder().build())
            .setPlaybookOutput(PlaybookOutput.newBuilder().build())
            .addAllActions(new ArrayList<Action>())
            .setDisplayName("displayName1714148973")
            .setDescription("description-1724546052")
            .setTokenCount(-1164226743)
            .setCreateTime(Timestamp.newBuilder().build())
            .setUpdateTime(Timestamp.newBuilder().build())
            .setConversationState(OutputState.forNumber(0))
            .setLanguageCode("languageCode-2092349083")
            .build();
    mockService.addResponse(expectedResponse);

    Example example =
        Example.newBuilder()
            .setName(
                ExampleName.of("[PROJECT]", "[LOCATION]", "[AGENT]", "[PLAYBOOK]", "[EXAMPLE]")
                    .toString())
            .setPlaybookInput(PlaybookInput.newBuilder().build())
            .setPlaybookOutput(PlaybookOutput.newBuilder().build())
            .addAllActions(new ArrayList<Action>())
            .setDisplayName("displayName1714148973")
            .setDescription("description-1724546052")
            .setTokenCount(-1164226743)
            .setCreateTime(Timestamp.newBuilder().build())
            .setUpdateTime(Timestamp.newBuilder().build())
            .setConversationState(OutputState.forNumber(0))
            .setLanguageCode("languageCode-2092349083")
            .build();
    FieldMask updateMask = FieldMask.newBuilder().build();

    Example actualResponse = client.updateExample(example, updateMask);
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
  public void updateExampleExceptionTest() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

    try {
      Example example =
          Example.newBuilder()
              .setName(
                  ExampleName.of("[PROJECT]", "[LOCATION]", "[AGENT]", "[PLAYBOOK]", "[EXAMPLE]")
                      .toString())
              .setPlaybookInput(PlaybookInput.newBuilder().build())
              .setPlaybookOutput(PlaybookOutput.newBuilder().build())
              .addAllActions(new ArrayList<Action>())
              .setDisplayName("displayName1714148973")
              .setDescription("description-1724546052")
              .setTokenCount(-1164226743)
              .setCreateTime(Timestamp.newBuilder().build())
              .setUpdateTime(Timestamp.newBuilder().build())
              .setConversationState(OutputState.forNumber(0))
              .setLanguageCode("languageCode-2092349083")
              .build();
      FieldMask updateMask = FieldMask.newBuilder().build();
      client.updateExample(example, updateMask);
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
