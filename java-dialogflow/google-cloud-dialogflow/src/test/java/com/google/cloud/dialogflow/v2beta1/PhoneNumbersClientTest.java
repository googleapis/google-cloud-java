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

package com.google.cloud.dialogflow.v2beta1;

import static com.google.cloud.dialogflow.v2beta1.PhoneNumbersClient.ListLocationsPagedResponse;
import static com.google.cloud.dialogflow.v2beta1.PhoneNumbersClient.ListPhoneNumbersPagedResponse;

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
public class PhoneNumbersClientTest {
  private static MockLocations mockLocations;
  private static MockPhoneNumbers mockPhoneNumbers;
  private static MockServiceHelper mockServiceHelper;
  private LocalChannelProvider channelProvider;
  private PhoneNumbersClient client;

  @BeforeClass
  public static void startStaticServer() {
    mockPhoneNumbers = new MockPhoneNumbers();
    mockLocations = new MockLocations();
    mockServiceHelper =
        new MockServiceHelper(
            UUID.randomUUID().toString(),
            Arrays.<MockGrpcService>asList(mockPhoneNumbers, mockLocations));
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
    PhoneNumbersSettings settings =
        PhoneNumbersSettings.newBuilder()
            .setTransportChannelProvider(channelProvider)
            .setCredentialsProvider(NoCredentialsProvider.create())
            .build();
    client = PhoneNumbersClient.create(settings);
  }

  @After
  public void tearDown() throws Exception {
    client.close();
  }

  @Test
  public void listPhoneNumbersTest() throws Exception {
    PhoneNumber responsesElement = PhoneNumber.newBuilder().build();
    ListPhoneNumbersResponse expectedResponse =
        ListPhoneNumbersResponse.newBuilder()
            .setNextPageToken("")
            .addAllPhoneNumbers(Arrays.asList(responsesElement))
            .build();
    mockPhoneNumbers.addResponse(expectedResponse);

    LocationName parent = LocationName.of("[PROJECT]", "[LOCATION]");

    ListPhoneNumbersPagedResponse pagedListResponse = client.listPhoneNumbers(parent);

    List<PhoneNumber> resources = Lists.newArrayList(pagedListResponse.iterateAll());

    Assert.assertEquals(1, resources.size());
    Assert.assertEquals(expectedResponse.getPhoneNumbersList().get(0), resources.get(0));

    List<AbstractMessage> actualRequests = mockPhoneNumbers.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    ListPhoneNumbersRequest actualRequest = ((ListPhoneNumbersRequest) actualRequests.get(0));

    Assert.assertEquals(parent.toString(), actualRequest.getParent());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void listPhoneNumbersExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockPhoneNumbers.addException(exception);

    try {
      LocationName parent = LocationName.of("[PROJECT]", "[LOCATION]");
      client.listPhoneNumbers(parent);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void listPhoneNumbersTest2() throws Exception {
    PhoneNumber responsesElement = PhoneNumber.newBuilder().build();
    ListPhoneNumbersResponse expectedResponse =
        ListPhoneNumbersResponse.newBuilder()
            .setNextPageToken("")
            .addAllPhoneNumbers(Arrays.asList(responsesElement))
            .build();
    mockPhoneNumbers.addResponse(expectedResponse);

    ProjectName parent = ProjectName.of("[PROJECT]");

    ListPhoneNumbersPagedResponse pagedListResponse = client.listPhoneNumbers(parent);

    List<PhoneNumber> resources = Lists.newArrayList(pagedListResponse.iterateAll());

    Assert.assertEquals(1, resources.size());
    Assert.assertEquals(expectedResponse.getPhoneNumbersList().get(0), resources.get(0));

    List<AbstractMessage> actualRequests = mockPhoneNumbers.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    ListPhoneNumbersRequest actualRequest = ((ListPhoneNumbersRequest) actualRequests.get(0));

    Assert.assertEquals(parent.toString(), actualRequest.getParent());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void listPhoneNumbersExceptionTest2() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockPhoneNumbers.addException(exception);

    try {
      ProjectName parent = ProjectName.of("[PROJECT]");
      client.listPhoneNumbers(parent);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void listPhoneNumbersTest3() throws Exception {
    PhoneNumber responsesElement = PhoneNumber.newBuilder().build();
    ListPhoneNumbersResponse expectedResponse =
        ListPhoneNumbersResponse.newBuilder()
            .setNextPageToken("")
            .addAllPhoneNumbers(Arrays.asList(responsesElement))
            .build();
    mockPhoneNumbers.addResponse(expectedResponse);

    String parent = "parent-995424086";

    ListPhoneNumbersPagedResponse pagedListResponse = client.listPhoneNumbers(parent);

    List<PhoneNumber> resources = Lists.newArrayList(pagedListResponse.iterateAll());

    Assert.assertEquals(1, resources.size());
    Assert.assertEquals(expectedResponse.getPhoneNumbersList().get(0), resources.get(0));

    List<AbstractMessage> actualRequests = mockPhoneNumbers.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    ListPhoneNumbersRequest actualRequest = ((ListPhoneNumbersRequest) actualRequests.get(0));

    Assert.assertEquals(parent, actualRequest.getParent());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void listPhoneNumbersExceptionTest3() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockPhoneNumbers.addException(exception);

    try {
      String parent = "parent-995424086";
      client.listPhoneNumbers(parent);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void updatePhoneNumberTest() throws Exception {
    PhoneNumber expectedResponse =
        PhoneNumber.newBuilder()
            .setName(
                PhoneNumberName.ofProjectPhoneNumberName("[PROJECT]", "[PHONE_NUMBER]").toString())
            .setPhoneNumber("phoneNumber-1192969641")
            .setConversationProfile("conversationProfile1691597734")
            .build();
    mockPhoneNumbers.addResponse(expectedResponse);

    PhoneNumber phoneNumber = PhoneNumber.newBuilder().build();
    FieldMask updateMask = FieldMask.newBuilder().build();

    PhoneNumber actualResponse = client.updatePhoneNumber(phoneNumber, updateMask);
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockPhoneNumbers.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    UpdatePhoneNumberRequest actualRequest = ((UpdatePhoneNumberRequest) actualRequests.get(0));

    Assert.assertEquals(phoneNumber, actualRequest.getPhoneNumber());
    Assert.assertEquals(updateMask, actualRequest.getUpdateMask());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void updatePhoneNumberExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockPhoneNumbers.addException(exception);

    try {
      PhoneNumber phoneNumber = PhoneNumber.newBuilder().build();
      FieldMask updateMask = FieldMask.newBuilder().build();
      client.updatePhoneNumber(phoneNumber, updateMask);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void deletePhoneNumberTest() throws Exception {
    PhoneNumber expectedResponse =
        PhoneNumber.newBuilder()
            .setName(
                PhoneNumberName.ofProjectPhoneNumberName("[PROJECT]", "[PHONE_NUMBER]").toString())
            .setPhoneNumber("phoneNumber-1192969641")
            .setConversationProfile("conversationProfile1691597734")
            .build();
    mockPhoneNumbers.addResponse(expectedResponse);

    PhoneNumberName name = PhoneNumberName.ofProjectPhoneNumberName("[PROJECT]", "[PHONE_NUMBER]");

    PhoneNumber actualResponse = client.deletePhoneNumber(name);
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockPhoneNumbers.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    DeletePhoneNumberRequest actualRequest = ((DeletePhoneNumberRequest) actualRequests.get(0));

    Assert.assertEquals(name.toString(), actualRequest.getName());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void deletePhoneNumberExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockPhoneNumbers.addException(exception);

    try {
      PhoneNumberName name =
          PhoneNumberName.ofProjectPhoneNumberName("[PROJECT]", "[PHONE_NUMBER]");
      client.deletePhoneNumber(name);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void deletePhoneNumberTest2() throws Exception {
    PhoneNumber expectedResponse =
        PhoneNumber.newBuilder()
            .setName(
                PhoneNumberName.ofProjectPhoneNumberName("[PROJECT]", "[PHONE_NUMBER]").toString())
            .setPhoneNumber("phoneNumber-1192969641")
            .setConversationProfile("conversationProfile1691597734")
            .build();
    mockPhoneNumbers.addResponse(expectedResponse);

    String name = "name3373707";

    PhoneNumber actualResponse = client.deletePhoneNumber(name);
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockPhoneNumbers.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    DeletePhoneNumberRequest actualRequest = ((DeletePhoneNumberRequest) actualRequests.get(0));

    Assert.assertEquals(name, actualRequest.getName());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void deletePhoneNumberExceptionTest2() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockPhoneNumbers.addException(exception);

    try {
      String name = "name3373707";
      client.deletePhoneNumber(name);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void undeletePhoneNumberTest() throws Exception {
    PhoneNumber expectedResponse =
        PhoneNumber.newBuilder()
            .setName(
                PhoneNumberName.ofProjectPhoneNumberName("[PROJECT]", "[PHONE_NUMBER]").toString())
            .setPhoneNumber("phoneNumber-1192969641")
            .setConversationProfile("conversationProfile1691597734")
            .build();
    mockPhoneNumbers.addResponse(expectedResponse);

    PhoneNumberName name = PhoneNumberName.ofProjectPhoneNumberName("[PROJECT]", "[PHONE_NUMBER]");

    PhoneNumber actualResponse = client.undeletePhoneNumber(name);
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockPhoneNumbers.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    UndeletePhoneNumberRequest actualRequest = ((UndeletePhoneNumberRequest) actualRequests.get(0));

    Assert.assertEquals(name.toString(), actualRequest.getName());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void undeletePhoneNumberExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockPhoneNumbers.addException(exception);

    try {
      PhoneNumberName name =
          PhoneNumberName.ofProjectPhoneNumberName("[PROJECT]", "[PHONE_NUMBER]");
      client.undeletePhoneNumber(name);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void undeletePhoneNumberTest2() throws Exception {
    PhoneNumber expectedResponse =
        PhoneNumber.newBuilder()
            .setName(
                PhoneNumberName.ofProjectPhoneNumberName("[PROJECT]", "[PHONE_NUMBER]").toString())
            .setPhoneNumber("phoneNumber-1192969641")
            .setConversationProfile("conversationProfile1691597734")
            .build();
    mockPhoneNumbers.addResponse(expectedResponse);

    String name = "name3373707";

    PhoneNumber actualResponse = client.undeletePhoneNumber(name);
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockPhoneNumbers.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    UndeletePhoneNumberRequest actualRequest = ((UndeletePhoneNumberRequest) actualRequests.get(0));

    Assert.assertEquals(name, actualRequest.getName());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void undeletePhoneNumberExceptionTest2() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockPhoneNumbers.addException(exception);

    try {
      String name = "name3373707";
      client.undeletePhoneNumber(name);
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
