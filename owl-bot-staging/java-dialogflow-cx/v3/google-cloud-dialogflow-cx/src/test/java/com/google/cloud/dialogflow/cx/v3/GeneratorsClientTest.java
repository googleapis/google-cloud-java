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

package com.google.cloud.dialogflow.cx.v3;

import static com.google.cloud.dialogflow.cx.v3.GeneratorsClient.ListGeneratorsPagedResponse;
import static com.google.cloud.dialogflow.cx.v3.GeneratorsClient.ListLocationsPagedResponse;

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
public class GeneratorsClientTest {
  private static MockGenerators mockGenerators;
  private static MockLocations mockLocations;
  private static MockServiceHelper mockServiceHelper;
  private LocalChannelProvider channelProvider;
  private GeneratorsClient client;

  @BeforeClass
  public static void startStaticServer() {
    mockGenerators = new MockGenerators();
    mockLocations = new MockLocations();
    mockServiceHelper =
        new MockServiceHelper(
            UUID.randomUUID().toString(),
            Arrays.<MockGrpcService>asList(mockGenerators, mockLocations));
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
    GeneratorsSettings settings =
        GeneratorsSettings.newBuilder()
            .setTransportChannelProvider(channelProvider)
            .setCredentialsProvider(NoCredentialsProvider.create())
            .build();
    client = GeneratorsClient.create(settings);
  }

  @After
  public void tearDown() throws Exception {
    client.close();
  }

  @Test
  public void listGeneratorsTest() throws Exception {
    Generator responsesElement = Generator.newBuilder().build();
    ListGeneratorsResponse expectedResponse =
        ListGeneratorsResponse.newBuilder()
            .setNextPageToken("")
            .addAllGenerators(Arrays.asList(responsesElement))
            .build();
    mockGenerators.addResponse(expectedResponse);

    AgentName parent = AgentName.of("[PROJECT]", "[LOCATION]", "[AGENT]");

    ListGeneratorsPagedResponse pagedListResponse = client.listGenerators(parent);

    List<Generator> resources = Lists.newArrayList(pagedListResponse.iterateAll());

    Assert.assertEquals(1, resources.size());
    Assert.assertEquals(expectedResponse.getGeneratorsList().get(0), resources.get(0));

    List<AbstractMessage> actualRequests = mockGenerators.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    ListGeneratorsRequest actualRequest = ((ListGeneratorsRequest) actualRequests.get(0));

    Assert.assertEquals(parent.toString(), actualRequest.getParent());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void listGeneratorsExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockGenerators.addException(exception);

    try {
      AgentName parent = AgentName.of("[PROJECT]", "[LOCATION]", "[AGENT]");
      client.listGenerators(parent);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void listGeneratorsTest2() throws Exception {
    Generator responsesElement = Generator.newBuilder().build();
    ListGeneratorsResponse expectedResponse =
        ListGeneratorsResponse.newBuilder()
            .setNextPageToken("")
            .addAllGenerators(Arrays.asList(responsesElement))
            .build();
    mockGenerators.addResponse(expectedResponse);

    String parent = "parent-995424086";

    ListGeneratorsPagedResponse pagedListResponse = client.listGenerators(parent);

    List<Generator> resources = Lists.newArrayList(pagedListResponse.iterateAll());

    Assert.assertEquals(1, resources.size());
    Assert.assertEquals(expectedResponse.getGeneratorsList().get(0), resources.get(0));

    List<AbstractMessage> actualRequests = mockGenerators.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    ListGeneratorsRequest actualRequest = ((ListGeneratorsRequest) actualRequests.get(0));

    Assert.assertEquals(parent, actualRequest.getParent());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void listGeneratorsExceptionTest2() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockGenerators.addException(exception);

    try {
      String parent = "parent-995424086";
      client.listGenerators(parent);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void getGeneratorTest() throws Exception {
    Generator expectedResponse =
        Generator.newBuilder()
            .setName(
                GeneratorName.of("[PROJECT]", "[LOCATION]", "[AGENT]", "[GENERATOR]").toString())
            .setDisplayName("displayName1714148973")
            .setPromptText(Phrase.newBuilder().build())
            .addAllPlaceholders(new ArrayList<Generator.Placeholder>())
            .build();
    mockGenerators.addResponse(expectedResponse);

    GeneratorName name = GeneratorName.of("[PROJECT]", "[LOCATION]", "[AGENT]", "[GENERATOR]");

    Generator actualResponse = client.getGenerator(name);
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockGenerators.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    GetGeneratorRequest actualRequest = ((GetGeneratorRequest) actualRequests.get(0));

    Assert.assertEquals(name.toString(), actualRequest.getName());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void getGeneratorExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockGenerators.addException(exception);

    try {
      GeneratorName name = GeneratorName.of("[PROJECT]", "[LOCATION]", "[AGENT]", "[GENERATOR]");
      client.getGenerator(name);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void getGeneratorTest2() throws Exception {
    Generator expectedResponse =
        Generator.newBuilder()
            .setName(
                GeneratorName.of("[PROJECT]", "[LOCATION]", "[AGENT]", "[GENERATOR]").toString())
            .setDisplayName("displayName1714148973")
            .setPromptText(Phrase.newBuilder().build())
            .addAllPlaceholders(new ArrayList<Generator.Placeholder>())
            .build();
    mockGenerators.addResponse(expectedResponse);

    String name = "name3373707";

    Generator actualResponse = client.getGenerator(name);
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockGenerators.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    GetGeneratorRequest actualRequest = ((GetGeneratorRequest) actualRequests.get(0));

    Assert.assertEquals(name, actualRequest.getName());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void getGeneratorExceptionTest2() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockGenerators.addException(exception);

    try {
      String name = "name3373707";
      client.getGenerator(name);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void createGeneratorTest() throws Exception {
    Generator expectedResponse =
        Generator.newBuilder()
            .setName(
                GeneratorName.of("[PROJECT]", "[LOCATION]", "[AGENT]", "[GENERATOR]").toString())
            .setDisplayName("displayName1714148973")
            .setPromptText(Phrase.newBuilder().build())
            .addAllPlaceholders(new ArrayList<Generator.Placeholder>())
            .build();
    mockGenerators.addResponse(expectedResponse);

    AgentName parent = AgentName.of("[PROJECT]", "[LOCATION]", "[AGENT]");
    Generator generator = Generator.newBuilder().build();

    Generator actualResponse = client.createGenerator(parent, generator);
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockGenerators.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    CreateGeneratorRequest actualRequest = ((CreateGeneratorRequest) actualRequests.get(0));

    Assert.assertEquals(parent.toString(), actualRequest.getParent());
    Assert.assertEquals(generator, actualRequest.getGenerator());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void createGeneratorExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockGenerators.addException(exception);

    try {
      AgentName parent = AgentName.of("[PROJECT]", "[LOCATION]", "[AGENT]");
      Generator generator = Generator.newBuilder().build();
      client.createGenerator(parent, generator);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void createGeneratorTest2() throws Exception {
    Generator expectedResponse =
        Generator.newBuilder()
            .setName(
                GeneratorName.of("[PROJECT]", "[LOCATION]", "[AGENT]", "[GENERATOR]").toString())
            .setDisplayName("displayName1714148973")
            .setPromptText(Phrase.newBuilder().build())
            .addAllPlaceholders(new ArrayList<Generator.Placeholder>())
            .build();
    mockGenerators.addResponse(expectedResponse);

    String parent = "parent-995424086";
    Generator generator = Generator.newBuilder().build();

    Generator actualResponse = client.createGenerator(parent, generator);
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockGenerators.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    CreateGeneratorRequest actualRequest = ((CreateGeneratorRequest) actualRequests.get(0));

    Assert.assertEquals(parent, actualRequest.getParent());
    Assert.assertEquals(generator, actualRequest.getGenerator());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void createGeneratorExceptionTest2() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockGenerators.addException(exception);

    try {
      String parent = "parent-995424086";
      Generator generator = Generator.newBuilder().build();
      client.createGenerator(parent, generator);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void updateGeneratorTest() throws Exception {
    Generator expectedResponse =
        Generator.newBuilder()
            .setName(
                GeneratorName.of("[PROJECT]", "[LOCATION]", "[AGENT]", "[GENERATOR]").toString())
            .setDisplayName("displayName1714148973")
            .setPromptText(Phrase.newBuilder().build())
            .addAllPlaceholders(new ArrayList<Generator.Placeholder>())
            .build();
    mockGenerators.addResponse(expectedResponse);

    Generator generator = Generator.newBuilder().build();
    FieldMask updateMask = FieldMask.newBuilder().build();

    Generator actualResponse = client.updateGenerator(generator, updateMask);
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockGenerators.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    UpdateGeneratorRequest actualRequest = ((UpdateGeneratorRequest) actualRequests.get(0));

    Assert.assertEquals(generator, actualRequest.getGenerator());
    Assert.assertEquals(updateMask, actualRequest.getUpdateMask());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void updateGeneratorExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockGenerators.addException(exception);

    try {
      Generator generator = Generator.newBuilder().build();
      FieldMask updateMask = FieldMask.newBuilder().build();
      client.updateGenerator(generator, updateMask);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void deleteGeneratorTest() throws Exception {
    Empty expectedResponse = Empty.newBuilder().build();
    mockGenerators.addResponse(expectedResponse);

    GeneratorName name = GeneratorName.of("[PROJECT]", "[LOCATION]", "[AGENT]", "[GENERATOR]");

    client.deleteGenerator(name);

    List<AbstractMessage> actualRequests = mockGenerators.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    DeleteGeneratorRequest actualRequest = ((DeleteGeneratorRequest) actualRequests.get(0));

    Assert.assertEquals(name.toString(), actualRequest.getName());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void deleteGeneratorExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockGenerators.addException(exception);

    try {
      GeneratorName name = GeneratorName.of("[PROJECT]", "[LOCATION]", "[AGENT]", "[GENERATOR]");
      client.deleteGenerator(name);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void deleteGeneratorTest2() throws Exception {
    Empty expectedResponse = Empty.newBuilder().build();
    mockGenerators.addResponse(expectedResponse);

    String name = "name3373707";

    client.deleteGenerator(name);

    List<AbstractMessage> actualRequests = mockGenerators.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    DeleteGeneratorRequest actualRequest = ((DeleteGeneratorRequest) actualRequests.get(0));

    Assert.assertEquals(name, actualRequest.getName());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void deleteGeneratorExceptionTest2() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockGenerators.addException(exception);

    try {
      String name = "name3373707";
      client.deleteGenerator(name);
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
