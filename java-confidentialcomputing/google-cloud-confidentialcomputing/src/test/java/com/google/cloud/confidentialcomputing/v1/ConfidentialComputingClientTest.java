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

package com.google.cloud.confidentialcomputing.v1;

import static com.google.cloud.confidentialcomputing.v1.ConfidentialComputingClient.ListLocationsPagedResponse;

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
import com.google.protobuf.Timestamp;
import com.google.rpc.Status;
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
public class ConfidentialComputingClientTest {
  private static MockConfidentialComputing mockConfidentialComputing;
  private static MockLocations mockLocations;
  private static MockServiceHelper mockServiceHelper;
  private LocalChannelProvider channelProvider;
  private ConfidentialComputingClient client;

  @BeforeClass
  public static void startStaticServer() {
    mockConfidentialComputing = new MockConfidentialComputing();
    mockLocations = new MockLocations();
    mockServiceHelper =
        new MockServiceHelper(
            UUID.randomUUID().toString(),
            Arrays.<MockGrpcService>asList(mockConfidentialComputing, mockLocations));
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
    ConfidentialComputingSettings settings =
        ConfidentialComputingSettings.newBuilder()
            .setTransportChannelProvider(channelProvider)
            .setCredentialsProvider(NoCredentialsProvider.create())
            .build();
    client = ConfidentialComputingClient.create(settings);
  }

  @After
  public void tearDown() throws Exception {
    client.close();
  }

  @Test
  public void createChallengeTest() throws Exception {
    Challenge expectedResponse =
        Challenge.newBuilder()
            .setName(ChallengeName.of("[PROJECT]", "[LOCATION]", "[UUID]").toString())
            .setCreateTime(Timestamp.newBuilder().build())
            .setExpireTime(Timestamp.newBuilder().build())
            .setUsed(true)
            .setTpmNonce("tpmNonce-180239106")
            .build();
    mockConfidentialComputing.addResponse(expectedResponse);

    LocationName parent = LocationName.of("[PROJECT]", "[LOCATION]");
    Challenge challenge = Challenge.newBuilder().build();

    Challenge actualResponse = client.createChallenge(parent, challenge);
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockConfidentialComputing.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    CreateChallengeRequest actualRequest = ((CreateChallengeRequest) actualRequests.get(0));

    Assert.assertEquals(parent.toString(), actualRequest.getParent());
    Assert.assertEquals(challenge, actualRequest.getChallenge());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void createChallengeExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockConfidentialComputing.addException(exception);

    try {
      LocationName parent = LocationName.of("[PROJECT]", "[LOCATION]");
      Challenge challenge = Challenge.newBuilder().build();
      client.createChallenge(parent, challenge);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void createChallengeTest2() throws Exception {
    Challenge expectedResponse =
        Challenge.newBuilder()
            .setName(ChallengeName.of("[PROJECT]", "[LOCATION]", "[UUID]").toString())
            .setCreateTime(Timestamp.newBuilder().build())
            .setExpireTime(Timestamp.newBuilder().build())
            .setUsed(true)
            .setTpmNonce("tpmNonce-180239106")
            .build();
    mockConfidentialComputing.addResponse(expectedResponse);

    String parent = "parent-995424086";
    Challenge challenge = Challenge.newBuilder().build();

    Challenge actualResponse = client.createChallenge(parent, challenge);
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockConfidentialComputing.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    CreateChallengeRequest actualRequest = ((CreateChallengeRequest) actualRequests.get(0));

    Assert.assertEquals(parent, actualRequest.getParent());
    Assert.assertEquals(challenge, actualRequest.getChallenge());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void createChallengeExceptionTest2() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockConfidentialComputing.addException(exception);

    try {
      String parent = "parent-995424086";
      Challenge challenge = Challenge.newBuilder().build();
      client.createChallenge(parent, challenge);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void verifyAttestationTest() throws Exception {
    VerifyAttestationResponse expectedResponse =
        VerifyAttestationResponse.newBuilder()
            .setOidcClaimsToken("oidcClaimsToken-566980887")
            .addAllPartialErrors(new ArrayList<Status>())
            .build();
    mockConfidentialComputing.addResponse(expectedResponse);

    VerifyAttestationRequest request =
        VerifyAttestationRequest.newBuilder()
            .setChallenge(ChallengeName.of("[PROJECT]", "[LOCATION]", "[UUID]").toString())
            .setGcpCredentials(GcpCredentials.newBuilder().build())
            .setTpmAttestation(TpmAttestation.newBuilder().build())
            .setConfidentialSpaceInfo(ConfidentialSpaceInfo.newBuilder().build())
            .setTokenOptions(TokenOptions.newBuilder().build())
            .build();

    VerifyAttestationResponse actualResponse = client.verifyAttestation(request);
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockConfidentialComputing.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    VerifyAttestationRequest actualRequest = ((VerifyAttestationRequest) actualRequests.get(0));

    Assert.assertEquals(request.getChallenge(), actualRequest.getChallenge());
    Assert.assertEquals(request.getGcpCredentials(), actualRequest.getGcpCredentials());
    Assert.assertEquals(request.getTpmAttestation(), actualRequest.getTpmAttestation());
    Assert.assertEquals(
        request.getConfidentialSpaceInfo(), actualRequest.getConfidentialSpaceInfo());
    Assert.assertEquals(request.getTokenOptions(), actualRequest.getTokenOptions());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void verifyAttestationExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockConfidentialComputing.addException(exception);

    try {
      VerifyAttestationRequest request =
          VerifyAttestationRequest.newBuilder()
              .setChallenge(ChallengeName.of("[PROJECT]", "[LOCATION]", "[UUID]").toString())
              .setGcpCredentials(GcpCredentials.newBuilder().build())
              .setTpmAttestation(TpmAttestation.newBuilder().build())
              .setConfidentialSpaceInfo(ConfidentialSpaceInfo.newBuilder().build())
              .setTokenOptions(TokenOptions.newBuilder().build())
              .build();
      client.verifyAttestation(request);
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
