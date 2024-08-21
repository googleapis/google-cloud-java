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

import static com.google.cloud.apihub.v1.LintingServiceClient.ListLocationsPagedResponse;

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
import com.google.protobuf.ByteString;
import com.google.protobuf.Empty;
import com.google.protobuf.FieldMask;
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
public class LintingServiceClientTest {
  private static MockLintingService mockLintingService;
  private static MockLocations mockLocations;
  private static MockServiceHelper mockServiceHelper;
  private LocalChannelProvider channelProvider;
  private LintingServiceClient client;

  @BeforeClass
  public static void startStaticServer() {
    mockLintingService = new MockLintingService();
    mockLocations = new MockLocations();
    mockServiceHelper =
        new MockServiceHelper(
            UUID.randomUUID().toString(),
            Arrays.<MockGrpcService>asList(mockLintingService, mockLocations));
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
    LintingServiceSettings settings =
        LintingServiceSettings.newBuilder()
            .setTransportChannelProvider(channelProvider)
            .setCredentialsProvider(NoCredentialsProvider.create())
            .build();
    client = LintingServiceClient.create(settings);
  }

  @After
  public void tearDown() throws Exception {
    client.close();
  }

  @Test
  public void getStyleGuideTest() throws Exception {
    StyleGuide expectedResponse =
        StyleGuide.newBuilder()
            .setName(StyleGuideName.of("[PROJECT]", "[LOCATION]", "[PLUGIN]").toString())
            .setLinter(Linter.forNumber(0))
            .setContents(StyleGuideContents.newBuilder().build())
            .build();
    mockLintingService.addResponse(expectedResponse);

    StyleGuideName name = StyleGuideName.of("[PROJECT]", "[LOCATION]", "[PLUGIN]");

    StyleGuide actualResponse = client.getStyleGuide(name);
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockLintingService.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    GetStyleGuideRequest actualRequest = ((GetStyleGuideRequest) actualRequests.get(0));

    Assert.assertEquals(name.toString(), actualRequest.getName());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void getStyleGuideExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockLintingService.addException(exception);

    try {
      StyleGuideName name = StyleGuideName.of("[PROJECT]", "[LOCATION]", "[PLUGIN]");
      client.getStyleGuide(name);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void getStyleGuideTest2() throws Exception {
    StyleGuide expectedResponse =
        StyleGuide.newBuilder()
            .setName(StyleGuideName.of("[PROJECT]", "[LOCATION]", "[PLUGIN]").toString())
            .setLinter(Linter.forNumber(0))
            .setContents(StyleGuideContents.newBuilder().build())
            .build();
    mockLintingService.addResponse(expectedResponse);

    String name = "name3373707";

    StyleGuide actualResponse = client.getStyleGuide(name);
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockLintingService.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    GetStyleGuideRequest actualRequest = ((GetStyleGuideRequest) actualRequests.get(0));

    Assert.assertEquals(name, actualRequest.getName());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void getStyleGuideExceptionTest2() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockLintingService.addException(exception);

    try {
      String name = "name3373707";
      client.getStyleGuide(name);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void updateStyleGuideTest() throws Exception {
    StyleGuide expectedResponse =
        StyleGuide.newBuilder()
            .setName(StyleGuideName.of("[PROJECT]", "[LOCATION]", "[PLUGIN]").toString())
            .setLinter(Linter.forNumber(0))
            .setContents(StyleGuideContents.newBuilder().build())
            .build();
    mockLintingService.addResponse(expectedResponse);

    StyleGuide styleGuide = StyleGuide.newBuilder().build();
    FieldMask updateMask = FieldMask.newBuilder().build();

    StyleGuide actualResponse = client.updateStyleGuide(styleGuide, updateMask);
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockLintingService.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    UpdateStyleGuideRequest actualRequest = ((UpdateStyleGuideRequest) actualRequests.get(0));

    Assert.assertEquals(styleGuide, actualRequest.getStyleGuide());
    Assert.assertEquals(updateMask, actualRequest.getUpdateMask());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void updateStyleGuideExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockLintingService.addException(exception);

    try {
      StyleGuide styleGuide = StyleGuide.newBuilder().build();
      FieldMask updateMask = FieldMask.newBuilder().build();
      client.updateStyleGuide(styleGuide, updateMask);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void getStyleGuideContentsTest() throws Exception {
    StyleGuideContents expectedResponse =
        StyleGuideContents.newBuilder()
            .setContents(ByteString.EMPTY)
            .setMimeType("mimeType-1392120434")
            .build();
    mockLintingService.addResponse(expectedResponse);

    StyleGuideName name = StyleGuideName.of("[PROJECT]", "[LOCATION]", "[PLUGIN]");

    StyleGuideContents actualResponse = client.getStyleGuideContents(name);
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockLintingService.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    GetStyleGuideContentsRequest actualRequest =
        ((GetStyleGuideContentsRequest) actualRequests.get(0));

    Assert.assertEquals(name.toString(), actualRequest.getName());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void getStyleGuideContentsExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockLintingService.addException(exception);

    try {
      StyleGuideName name = StyleGuideName.of("[PROJECT]", "[LOCATION]", "[PLUGIN]");
      client.getStyleGuideContents(name);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void getStyleGuideContentsTest2() throws Exception {
    StyleGuideContents expectedResponse =
        StyleGuideContents.newBuilder()
            .setContents(ByteString.EMPTY)
            .setMimeType("mimeType-1392120434")
            .build();
    mockLintingService.addResponse(expectedResponse);

    String name = "name3373707";

    StyleGuideContents actualResponse = client.getStyleGuideContents(name);
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockLintingService.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    GetStyleGuideContentsRequest actualRequest =
        ((GetStyleGuideContentsRequest) actualRequests.get(0));

    Assert.assertEquals(name, actualRequest.getName());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void getStyleGuideContentsExceptionTest2() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockLintingService.addException(exception);

    try {
      String name = "name3373707";
      client.getStyleGuideContents(name);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void lintSpecTest() throws Exception {
    Empty expectedResponse = Empty.newBuilder().build();
    mockLintingService.addResponse(expectedResponse);

    LintSpecRequest request =
        LintSpecRequest.newBuilder()
            .setName(
                SpecName.of("[PROJECT]", "[LOCATION]", "[API]", "[VERSION]", "[SPEC]").toString())
            .build();

    client.lintSpec(request);

    List<AbstractMessage> actualRequests = mockLintingService.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    LintSpecRequest actualRequest = ((LintSpecRequest) actualRequests.get(0));

    Assert.assertEquals(request.getName(), actualRequest.getName());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void lintSpecExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockLintingService.addException(exception);

    try {
      LintSpecRequest request =
          LintSpecRequest.newBuilder()
              .setName(
                  SpecName.of("[PROJECT]", "[LOCATION]", "[API]", "[VERSION]", "[SPEC]").toString())
              .build();
      client.lintSpec(request);
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
