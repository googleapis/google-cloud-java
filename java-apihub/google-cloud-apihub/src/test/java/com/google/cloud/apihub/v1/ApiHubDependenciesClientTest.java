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

package com.google.cloud.apihub.v1;

import static com.google.cloud.apihub.v1.ApiHubDependenciesClient.ListDependenciesPagedResponse;
import static com.google.cloud.apihub.v1.ApiHubDependenciesClient.ListLocationsPagedResponse;

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
public class ApiHubDependenciesClientTest {
  private static MockApiHubDependencies mockApiHubDependencies;
  private static MockLocations mockLocations;
  private static MockServiceHelper mockServiceHelper;
  private LocalChannelProvider channelProvider;
  private ApiHubDependenciesClient client;

  @BeforeClass
  public static void startStaticServer() {
    mockApiHubDependencies = new MockApiHubDependencies();
    mockLocations = new MockLocations();
    mockServiceHelper =
        new MockServiceHelper(
            UUID.randomUUID().toString(),
            Arrays.<MockGrpcService>asList(mockApiHubDependencies, mockLocations));
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
    ApiHubDependenciesSettings settings =
        ApiHubDependenciesSettings.newBuilder()
            .setTransportChannelProvider(channelProvider)
            .setCredentialsProvider(NoCredentialsProvider.create())
            .build();
    client = ApiHubDependenciesClient.create(settings);
  }

  @After
  public void tearDown() throws Exception {
    client.close();
  }

  @Test
  public void createDependencyTest() throws Exception {
    Dependency expectedResponse =
        Dependency.newBuilder()
            .setName(DependencyName.of("[PROJECT]", "[LOCATION]", "[DEPENDENCY]").toString())
            .setConsumer(DependencyEntityReference.newBuilder().build())
            .setSupplier(DependencyEntityReference.newBuilder().build())
            .setDescription("description-1724546052")
            .setErrorDetail(DependencyErrorDetail.newBuilder().build())
            .setCreateTime(Timestamp.newBuilder().build())
            .setUpdateTime(Timestamp.newBuilder().build())
            .putAllAttributes(new HashMap<String, AttributeValues>())
            .build();
    mockApiHubDependencies.addResponse(expectedResponse);

    LocationName parent = LocationName.of("[PROJECT]", "[LOCATION]");
    Dependency dependency = Dependency.newBuilder().build();
    String dependencyId = "dependencyId503788998";

    Dependency actualResponse = client.createDependency(parent, dependency, dependencyId);
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockApiHubDependencies.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    CreateDependencyRequest actualRequest = ((CreateDependencyRequest) actualRequests.get(0));

    Assert.assertEquals(parent.toString(), actualRequest.getParent());
    Assert.assertEquals(dependency, actualRequest.getDependency());
    Assert.assertEquals(dependencyId, actualRequest.getDependencyId());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void createDependencyExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockApiHubDependencies.addException(exception);

    try {
      LocationName parent = LocationName.of("[PROJECT]", "[LOCATION]");
      Dependency dependency = Dependency.newBuilder().build();
      String dependencyId = "dependencyId503788998";
      client.createDependency(parent, dependency, dependencyId);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void createDependencyTest2() throws Exception {
    Dependency expectedResponse =
        Dependency.newBuilder()
            .setName(DependencyName.of("[PROJECT]", "[LOCATION]", "[DEPENDENCY]").toString())
            .setConsumer(DependencyEntityReference.newBuilder().build())
            .setSupplier(DependencyEntityReference.newBuilder().build())
            .setDescription("description-1724546052")
            .setErrorDetail(DependencyErrorDetail.newBuilder().build())
            .setCreateTime(Timestamp.newBuilder().build())
            .setUpdateTime(Timestamp.newBuilder().build())
            .putAllAttributes(new HashMap<String, AttributeValues>())
            .build();
    mockApiHubDependencies.addResponse(expectedResponse);

    String parent = "parent-995424086";
    Dependency dependency = Dependency.newBuilder().build();
    String dependencyId = "dependencyId503788998";

    Dependency actualResponse = client.createDependency(parent, dependency, dependencyId);
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockApiHubDependencies.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    CreateDependencyRequest actualRequest = ((CreateDependencyRequest) actualRequests.get(0));

    Assert.assertEquals(parent, actualRequest.getParent());
    Assert.assertEquals(dependency, actualRequest.getDependency());
    Assert.assertEquals(dependencyId, actualRequest.getDependencyId());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void createDependencyExceptionTest2() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockApiHubDependencies.addException(exception);

    try {
      String parent = "parent-995424086";
      Dependency dependency = Dependency.newBuilder().build();
      String dependencyId = "dependencyId503788998";
      client.createDependency(parent, dependency, dependencyId);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void getDependencyTest() throws Exception {
    Dependency expectedResponse =
        Dependency.newBuilder()
            .setName(DependencyName.of("[PROJECT]", "[LOCATION]", "[DEPENDENCY]").toString())
            .setConsumer(DependencyEntityReference.newBuilder().build())
            .setSupplier(DependencyEntityReference.newBuilder().build())
            .setDescription("description-1724546052")
            .setErrorDetail(DependencyErrorDetail.newBuilder().build())
            .setCreateTime(Timestamp.newBuilder().build())
            .setUpdateTime(Timestamp.newBuilder().build())
            .putAllAttributes(new HashMap<String, AttributeValues>())
            .build();
    mockApiHubDependencies.addResponse(expectedResponse);

    DependencyName name = DependencyName.of("[PROJECT]", "[LOCATION]", "[DEPENDENCY]");

    Dependency actualResponse = client.getDependency(name);
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockApiHubDependencies.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    GetDependencyRequest actualRequest = ((GetDependencyRequest) actualRequests.get(0));

    Assert.assertEquals(name.toString(), actualRequest.getName());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void getDependencyExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockApiHubDependencies.addException(exception);

    try {
      DependencyName name = DependencyName.of("[PROJECT]", "[LOCATION]", "[DEPENDENCY]");
      client.getDependency(name);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void getDependencyTest2() throws Exception {
    Dependency expectedResponse =
        Dependency.newBuilder()
            .setName(DependencyName.of("[PROJECT]", "[LOCATION]", "[DEPENDENCY]").toString())
            .setConsumer(DependencyEntityReference.newBuilder().build())
            .setSupplier(DependencyEntityReference.newBuilder().build())
            .setDescription("description-1724546052")
            .setErrorDetail(DependencyErrorDetail.newBuilder().build())
            .setCreateTime(Timestamp.newBuilder().build())
            .setUpdateTime(Timestamp.newBuilder().build())
            .putAllAttributes(new HashMap<String, AttributeValues>())
            .build();
    mockApiHubDependencies.addResponse(expectedResponse);

    String name = "name3373707";

    Dependency actualResponse = client.getDependency(name);
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockApiHubDependencies.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    GetDependencyRequest actualRequest = ((GetDependencyRequest) actualRequests.get(0));

    Assert.assertEquals(name, actualRequest.getName());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void getDependencyExceptionTest2() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockApiHubDependencies.addException(exception);

    try {
      String name = "name3373707";
      client.getDependency(name);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void updateDependencyTest() throws Exception {
    Dependency expectedResponse =
        Dependency.newBuilder()
            .setName(DependencyName.of("[PROJECT]", "[LOCATION]", "[DEPENDENCY]").toString())
            .setConsumer(DependencyEntityReference.newBuilder().build())
            .setSupplier(DependencyEntityReference.newBuilder().build())
            .setDescription("description-1724546052")
            .setErrorDetail(DependencyErrorDetail.newBuilder().build())
            .setCreateTime(Timestamp.newBuilder().build())
            .setUpdateTime(Timestamp.newBuilder().build())
            .putAllAttributes(new HashMap<String, AttributeValues>())
            .build();
    mockApiHubDependencies.addResponse(expectedResponse);

    Dependency dependency = Dependency.newBuilder().build();
    FieldMask updateMask = FieldMask.newBuilder().build();

    Dependency actualResponse = client.updateDependency(dependency, updateMask);
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockApiHubDependencies.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    UpdateDependencyRequest actualRequest = ((UpdateDependencyRequest) actualRequests.get(0));

    Assert.assertEquals(dependency, actualRequest.getDependency());
    Assert.assertEquals(updateMask, actualRequest.getUpdateMask());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void updateDependencyExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockApiHubDependencies.addException(exception);

    try {
      Dependency dependency = Dependency.newBuilder().build();
      FieldMask updateMask = FieldMask.newBuilder().build();
      client.updateDependency(dependency, updateMask);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void deleteDependencyTest() throws Exception {
    Empty expectedResponse = Empty.newBuilder().build();
    mockApiHubDependencies.addResponse(expectedResponse);

    DependencyName name = DependencyName.of("[PROJECT]", "[LOCATION]", "[DEPENDENCY]");

    client.deleteDependency(name);

    List<AbstractMessage> actualRequests = mockApiHubDependencies.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    DeleteDependencyRequest actualRequest = ((DeleteDependencyRequest) actualRequests.get(0));

    Assert.assertEquals(name.toString(), actualRequest.getName());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void deleteDependencyExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockApiHubDependencies.addException(exception);

    try {
      DependencyName name = DependencyName.of("[PROJECT]", "[LOCATION]", "[DEPENDENCY]");
      client.deleteDependency(name);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void deleteDependencyTest2() throws Exception {
    Empty expectedResponse = Empty.newBuilder().build();
    mockApiHubDependencies.addResponse(expectedResponse);

    String name = "name3373707";

    client.deleteDependency(name);

    List<AbstractMessage> actualRequests = mockApiHubDependencies.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    DeleteDependencyRequest actualRequest = ((DeleteDependencyRequest) actualRequests.get(0));

    Assert.assertEquals(name, actualRequest.getName());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void deleteDependencyExceptionTest2() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockApiHubDependencies.addException(exception);

    try {
      String name = "name3373707";
      client.deleteDependency(name);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void listDependenciesTest() throws Exception {
    Dependency responsesElement = Dependency.newBuilder().build();
    ListDependenciesResponse expectedResponse =
        ListDependenciesResponse.newBuilder()
            .setNextPageToken("")
            .addAllDependencies(Arrays.asList(responsesElement))
            .build();
    mockApiHubDependencies.addResponse(expectedResponse);

    LocationName parent = LocationName.of("[PROJECT]", "[LOCATION]");

    ListDependenciesPagedResponse pagedListResponse = client.listDependencies(parent);

    List<Dependency> resources = Lists.newArrayList(pagedListResponse.iterateAll());

    Assert.assertEquals(1, resources.size());
    Assert.assertEquals(expectedResponse.getDependenciesList().get(0), resources.get(0));

    List<AbstractMessage> actualRequests = mockApiHubDependencies.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    ListDependenciesRequest actualRequest = ((ListDependenciesRequest) actualRequests.get(0));

    Assert.assertEquals(parent.toString(), actualRequest.getParent());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void listDependenciesExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockApiHubDependencies.addException(exception);

    try {
      LocationName parent = LocationName.of("[PROJECT]", "[LOCATION]");
      client.listDependencies(parent);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void listDependenciesTest2() throws Exception {
    Dependency responsesElement = Dependency.newBuilder().build();
    ListDependenciesResponse expectedResponse =
        ListDependenciesResponse.newBuilder()
            .setNextPageToken("")
            .addAllDependencies(Arrays.asList(responsesElement))
            .build();
    mockApiHubDependencies.addResponse(expectedResponse);

    String parent = "parent-995424086";

    ListDependenciesPagedResponse pagedListResponse = client.listDependencies(parent);

    List<Dependency> resources = Lists.newArrayList(pagedListResponse.iterateAll());

    Assert.assertEquals(1, resources.size());
    Assert.assertEquals(expectedResponse.getDependenciesList().get(0), resources.get(0));

    List<AbstractMessage> actualRequests = mockApiHubDependencies.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    ListDependenciesRequest actualRequest = ((ListDependenciesRequest) actualRequests.get(0));

    Assert.assertEquals(parent, actualRequest.getParent());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void listDependenciesExceptionTest2() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockApiHubDependencies.addException(exception);

    try {
      String parent = "parent-995424086";
      client.listDependencies(parent);
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
