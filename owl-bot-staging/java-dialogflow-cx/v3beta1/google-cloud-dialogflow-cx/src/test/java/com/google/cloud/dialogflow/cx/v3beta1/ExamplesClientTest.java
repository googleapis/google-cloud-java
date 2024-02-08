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
import com.google.api.gax.grpc.GaxGrpcProperties;
import com.google.api.gax.grpc.testing.LocalChannelProvider;
import com.google.api.gax.grpc.testing.MockGrpcService;
import com.google.api.gax.grpc.testing.MockServiceHelper;
import com.google.api.gax.rpc.ApiClientHeaderProvider;
import com.google.api.gax.rpc.InvalidArgumentException;
import com.google.cloud.location.GetLocationRequest;
import com.google.cloud.location.ListLocationsRequest;
import com.google.cloud.location.ListLocationsResponse;
import com.google.cloud.location.Location;
import com.google.common.collect.Lists;
import com.google.protobuf.AbstractMessage;
import com.google.protobuf.Any;
import com.google.protobuf.Empty;
import com.google.protobuf.FieldMask;
import com.google.protobuf.Timestamp;
import io.grpc.StatusRuntimeException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
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
public class ExamplesClientTest {
  private static MockExamples mockExamples;
  private static MockLocations mockLocations;
  private static MockServiceHelper mockServiceHelper;
  private LocalChannelProvider channelProvider;
  private ExamplesClient client;

  @BeforeClass
  public static void startStaticServer() {
    mockExamples = new MockExamples();
    mockLocations = new MockLocations();
    mockServiceHelper =
        new MockServiceHelper(
            UUID.randomUUID().toString(),
            Arrays.<MockGrpcService>asList(mockExamples, mockLocations));
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
    ExamplesSettings settings =
        ExamplesSettings.newBuilder()
            .setTransportChannelProvider(channelProvider)
            .setCredentialsProvider(NoCredentialsProvider.create())
            .build();
    client = ExamplesClient.create(settings);
  }

  @After
  public void tearDown() throws Exception {
    client.close();
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
    mockExamples.addResponse(expectedResponse);

    PlaybookName parent = PlaybookName.of("[PROJECT]", "[LOCATION]", "[AGENT]", "[PLAYBOOK]");
    Example example = Example.newBuilder().build();

    Example actualResponse = client.createExample(parent, example);
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockExamples.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    CreateExampleRequest actualRequest = ((CreateExampleRequest) actualRequests.get(0));

    Assert.assertEquals(parent.toString(), actualRequest.getParent());
    Assert.assertEquals(example, actualRequest.getExample());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void createExampleExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockExamples.addException(exception);

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
    mockExamples.addResponse(expectedResponse);

    String parent = "parent-995424086";
    Example example = Example.newBuilder().build();

    Example actualResponse = client.createExample(parent, example);
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockExamples.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    CreateExampleRequest actualRequest = ((CreateExampleRequest) actualRequests.get(0));

    Assert.assertEquals(parent, actualRequest.getParent());
    Assert.assertEquals(example, actualRequest.getExample());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void createExampleExceptionTest2() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockExamples.addException(exception);

    try {
      String parent = "parent-995424086";
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
    mockExamples.addResponse(expectedResponse);

    ExampleName name =
        ExampleName.of("[PROJECT]", "[LOCATION]", "[AGENT]", "[PLAYBOOK]", "[EXAMPLE]");

    client.deleteExample(name);

    List<AbstractMessage> actualRequests = mockExamples.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    DeleteExampleRequest actualRequest = ((DeleteExampleRequest) actualRequests.get(0));

    Assert.assertEquals(name.toString(), actualRequest.getName());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void deleteExampleExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockExamples.addException(exception);

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
    mockExamples.addResponse(expectedResponse);

    String name = "name3373707";

    client.deleteExample(name);

    List<AbstractMessage> actualRequests = mockExamples.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    DeleteExampleRequest actualRequest = ((DeleteExampleRequest) actualRequests.get(0));

    Assert.assertEquals(name, actualRequest.getName());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void deleteExampleExceptionTest2() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockExamples.addException(exception);

    try {
      String name = "name3373707";
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
    mockExamples.addResponse(expectedResponse);

    PlaybookName parent = PlaybookName.of("[PROJECT]", "[LOCATION]", "[AGENT]", "[PLAYBOOK]");

    ListExamplesPagedResponse pagedListResponse = client.listExamples(parent);

    List<Example> resources = Lists.newArrayList(pagedListResponse.iterateAll());

    Assert.assertEquals(1, resources.size());
    Assert.assertEquals(expectedResponse.getExamplesList().get(0), resources.get(0));

    List<AbstractMessage> actualRequests = mockExamples.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    ListExamplesRequest actualRequest = ((ListExamplesRequest) actualRequests.get(0));

    Assert.assertEquals(parent.toString(), actualRequest.getParent());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void listExamplesExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockExamples.addException(exception);

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
    mockExamples.addResponse(expectedResponse);

    String parent = "parent-995424086";

    ListExamplesPagedResponse pagedListResponse = client.listExamples(parent);

    List<Example> resources = Lists.newArrayList(pagedListResponse.iterateAll());

    Assert.assertEquals(1, resources.size());
    Assert.assertEquals(expectedResponse.getExamplesList().get(0), resources.get(0));

    List<AbstractMessage> actualRequests = mockExamples.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    ListExamplesRequest actualRequest = ((ListExamplesRequest) actualRequests.get(0));

    Assert.assertEquals(parent, actualRequest.getParent());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void listExamplesExceptionTest2() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockExamples.addException(exception);

    try {
      String parent = "parent-995424086";
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
    mockExamples.addResponse(expectedResponse);

    ExampleName name =
        ExampleName.of("[PROJECT]", "[LOCATION]", "[AGENT]", "[PLAYBOOK]", "[EXAMPLE]");

    Example actualResponse = client.getExample(name);
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockExamples.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    GetExampleRequest actualRequest = ((GetExampleRequest) actualRequests.get(0));

    Assert.assertEquals(name.toString(), actualRequest.getName());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void getExampleExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockExamples.addException(exception);

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
    mockExamples.addResponse(expectedResponse);

    String name = "name3373707";

    Example actualResponse = client.getExample(name);
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockExamples.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    GetExampleRequest actualRequest = ((GetExampleRequest) actualRequests.get(0));

    Assert.assertEquals(name, actualRequest.getName());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void getExampleExceptionTest2() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockExamples.addException(exception);

    try {
      String name = "name3373707";
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
    mockExamples.addResponse(expectedResponse);

    Example example = Example.newBuilder().build();
    FieldMask updateMask = FieldMask.newBuilder().build();

    Example actualResponse = client.updateExample(example, updateMask);
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockExamples.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    UpdateExampleRequest actualRequest = ((UpdateExampleRequest) actualRequests.get(0));

    Assert.assertEquals(example, actualRequest.getExample());
    Assert.assertEquals(updateMask, actualRequest.getUpdateMask());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void updateExampleExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockExamples.addException(exception);

    try {
      Example example = Example.newBuilder().build();
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
    mockLocations.addResponse(expectedResponse);

    ListLocationsRequest request =
        ListLocationsRequest.newBuilder()
            .setName("name3373707")
            .setFilter("filter-1274492040")
            .setPageSize(883849137)
            .setPageToken("pageToken873572522")
            .build();

    ListLocationsPagedResponse pagedListResponse = client.listLocations(request);

    List<Location> resources = Lists.newArrayList(pagedListResponse.iterateAll());

    Assert.assertEquals(1, resources.size());
    Assert.assertEquals(expectedResponse.getLocationsList().get(0), resources.get(0));

    List<AbstractMessage> actualRequests = mockLocations.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    ListLocationsRequest actualRequest = ((ListLocationsRequest) actualRequests.get(0));

    Assert.assertEquals(request.getName(), actualRequest.getName());
    Assert.assertEquals(request.getFilter(), actualRequest.getFilter());
    Assert.assertEquals(request.getPageSize(), actualRequest.getPageSize());
    Assert.assertEquals(request.getPageToken(), actualRequest.getPageToken());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void listLocationsExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockLocations.addException(exception);

    try {
      ListLocationsRequest request =
          ListLocationsRequest.newBuilder()
              .setName("name3373707")
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
    mockLocations.addResponse(expectedResponse);

    GetLocationRequest request = GetLocationRequest.newBuilder().setName("name3373707").build();

    Location actualResponse = client.getLocation(request);
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockLocations.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    GetLocationRequest actualRequest = ((GetLocationRequest) actualRequests.get(0));

    Assert.assertEquals(request.getName(), actualRequest.getName());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void getLocationExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockLocations.addException(exception);

    try {
      GetLocationRequest request = GetLocationRequest.newBuilder().setName("name3373707").build();
      client.getLocation(request);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }
}
