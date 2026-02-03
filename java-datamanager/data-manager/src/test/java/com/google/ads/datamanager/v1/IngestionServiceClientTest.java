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

package com.google.ads.datamanager.v1;

import com.google.api.gax.core.NoCredentialsProvider;
import com.google.api.gax.grpc.GaxGrpcProperties;
import com.google.api.gax.grpc.testing.LocalChannelProvider;
import com.google.api.gax.grpc.testing.MockGrpcService;
import com.google.api.gax.grpc.testing.MockServiceHelper;
import com.google.api.gax.rpc.ApiClientHeaderProvider;
import com.google.api.gax.rpc.InvalidArgumentException;
import com.google.protobuf.AbstractMessage;
import io.grpc.StatusRuntimeException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
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
public class IngestionServiceClientTest {
  private static MockIngestionService mockIngestionService;
  private static MockServiceHelper mockServiceHelper;
  private LocalChannelProvider channelProvider;
  private IngestionServiceClient client;

  @BeforeClass
  public static void startStaticServer() {
    mockIngestionService = new MockIngestionService();
    mockServiceHelper =
        new MockServiceHelper(
            UUID.randomUUID().toString(), Arrays.<MockGrpcService>asList(mockIngestionService));
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
    IngestionServiceSettings settings =
        IngestionServiceSettings.newBuilder()
            .setTransportChannelProvider(channelProvider)
            .setCredentialsProvider(NoCredentialsProvider.create())
            .build();
    client = IngestionServiceClient.create(settings);
  }

  @After
  public void tearDown() throws Exception {
    client.close();
  }

  @Test
  public void ingestAudienceMembersTest() throws Exception {
    IngestAudienceMembersResponse expectedResponse =
        IngestAudienceMembersResponse.newBuilder().setRequestId("requestId693933066").build();
    mockIngestionService.addResponse(expectedResponse);

    IngestAudienceMembersRequest request =
        IngestAudienceMembersRequest.newBuilder()
            .addAllDestinations(new ArrayList<Destination>())
            .addAllAudienceMembers(new ArrayList<AudienceMember>())
            .setConsent(Consent.newBuilder().build())
            .setValidateOnly(true)
            .setEncoding(Encoding.forNumber(0))
            .setEncryptionInfo(EncryptionInfo.newBuilder().build())
            .setTermsOfService(TermsOfService.newBuilder().build())
            .build();

    IngestAudienceMembersResponse actualResponse = client.ingestAudienceMembers(request);
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockIngestionService.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    IngestAudienceMembersRequest actualRequest =
        ((IngestAudienceMembersRequest) actualRequests.get(0));

    Assert.assertEquals(request.getDestinationsList(), actualRequest.getDestinationsList());
    Assert.assertEquals(request.getAudienceMembersList(), actualRequest.getAudienceMembersList());
    Assert.assertEquals(request.getConsent(), actualRequest.getConsent());
    Assert.assertEquals(request.getValidateOnly(), actualRequest.getValidateOnly());
    Assert.assertEquals(request.getEncoding(), actualRequest.getEncoding());
    Assert.assertEquals(request.getEncryptionInfo(), actualRequest.getEncryptionInfo());
    Assert.assertEquals(request.getTermsOfService(), actualRequest.getTermsOfService());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void ingestAudienceMembersExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockIngestionService.addException(exception);

    try {
      IngestAudienceMembersRequest request =
          IngestAudienceMembersRequest.newBuilder()
              .addAllDestinations(new ArrayList<Destination>())
              .addAllAudienceMembers(new ArrayList<AudienceMember>())
              .setConsent(Consent.newBuilder().build())
              .setValidateOnly(true)
              .setEncoding(Encoding.forNumber(0))
              .setEncryptionInfo(EncryptionInfo.newBuilder().build())
              .setTermsOfService(TermsOfService.newBuilder().build())
              .build();
      client.ingestAudienceMembers(request);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void removeAudienceMembersTest() throws Exception {
    RemoveAudienceMembersResponse expectedResponse =
        RemoveAudienceMembersResponse.newBuilder().setRequestId("requestId693933066").build();
    mockIngestionService.addResponse(expectedResponse);

    RemoveAudienceMembersRequest request =
        RemoveAudienceMembersRequest.newBuilder()
            .addAllDestinations(new ArrayList<Destination>())
            .addAllAudienceMembers(new ArrayList<AudienceMember>())
            .setValidateOnly(true)
            .setEncoding(Encoding.forNumber(0))
            .setEncryptionInfo(EncryptionInfo.newBuilder().build())
            .build();

    RemoveAudienceMembersResponse actualResponse = client.removeAudienceMembers(request);
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockIngestionService.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    RemoveAudienceMembersRequest actualRequest =
        ((RemoveAudienceMembersRequest) actualRequests.get(0));

    Assert.assertEquals(request.getDestinationsList(), actualRequest.getDestinationsList());
    Assert.assertEquals(request.getAudienceMembersList(), actualRequest.getAudienceMembersList());
    Assert.assertEquals(request.getValidateOnly(), actualRequest.getValidateOnly());
    Assert.assertEquals(request.getEncoding(), actualRequest.getEncoding());
    Assert.assertEquals(request.getEncryptionInfo(), actualRequest.getEncryptionInfo());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void removeAudienceMembersExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockIngestionService.addException(exception);

    try {
      RemoveAudienceMembersRequest request =
          RemoveAudienceMembersRequest.newBuilder()
              .addAllDestinations(new ArrayList<Destination>())
              .addAllAudienceMembers(new ArrayList<AudienceMember>())
              .setValidateOnly(true)
              .setEncoding(Encoding.forNumber(0))
              .setEncryptionInfo(EncryptionInfo.newBuilder().build())
              .build();
      client.removeAudienceMembers(request);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void ingestEventsTest() throws Exception {
    IngestEventsResponse expectedResponse =
        IngestEventsResponse.newBuilder().setRequestId("requestId693933066").build();
    mockIngestionService.addResponse(expectedResponse);

    IngestEventsRequest request =
        IngestEventsRequest.newBuilder()
            .addAllDestinations(new ArrayList<Destination>())
            .addAllEvents(new ArrayList<Event>())
            .setConsent(Consent.newBuilder().build())
            .setValidateOnly(true)
            .setEncoding(Encoding.forNumber(0))
            .setEncryptionInfo(EncryptionInfo.newBuilder().build())
            .build();

    IngestEventsResponse actualResponse = client.ingestEvents(request);
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockIngestionService.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    IngestEventsRequest actualRequest = ((IngestEventsRequest) actualRequests.get(0));

    Assert.assertEquals(request.getDestinationsList(), actualRequest.getDestinationsList());
    Assert.assertEquals(request.getEventsList(), actualRequest.getEventsList());
    Assert.assertEquals(request.getConsent(), actualRequest.getConsent());
    Assert.assertEquals(request.getValidateOnly(), actualRequest.getValidateOnly());
    Assert.assertEquals(request.getEncoding(), actualRequest.getEncoding());
    Assert.assertEquals(request.getEncryptionInfo(), actualRequest.getEncryptionInfo());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void ingestEventsExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockIngestionService.addException(exception);

    try {
      IngestEventsRequest request =
          IngestEventsRequest.newBuilder()
              .addAllDestinations(new ArrayList<Destination>())
              .addAllEvents(new ArrayList<Event>())
              .setConsent(Consent.newBuilder().build())
              .setValidateOnly(true)
              .setEncoding(Encoding.forNumber(0))
              .setEncryptionInfo(EncryptionInfo.newBuilder().build())
              .build();
      client.ingestEvents(request);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void retrieveRequestStatusTest() throws Exception {
    RetrieveRequestStatusResponse expectedResponse =
        RetrieveRequestStatusResponse.newBuilder()
            .addAllRequestStatusPerDestination(new ArrayList<RequestStatusPerDestination>())
            .build();
    mockIngestionService.addResponse(expectedResponse);

    RetrieveRequestStatusRequest request =
        RetrieveRequestStatusRequest.newBuilder().setRequestId("requestId693933066").build();

    RetrieveRequestStatusResponse actualResponse = client.retrieveRequestStatus(request);
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockIngestionService.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    RetrieveRequestStatusRequest actualRequest =
        ((RetrieveRequestStatusRequest) actualRequests.get(0));

    Assert.assertEquals(request.getRequestId(), actualRequest.getRequestId());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void retrieveRequestStatusExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockIngestionService.addException(exception);

    try {
      RetrieveRequestStatusRequest request =
          RetrieveRequestStatusRequest.newBuilder().setRequestId("requestId693933066").build();
      client.retrieveRequestStatus(request);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }
}
