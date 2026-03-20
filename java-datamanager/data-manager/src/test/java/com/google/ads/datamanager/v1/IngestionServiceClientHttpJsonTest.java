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

import com.google.ads.datamanager.v1.stub.HttpJsonIngestionServiceStub;
import com.google.api.gax.core.NoCredentialsProvider;
import com.google.api.gax.httpjson.GaxHttpJsonProperties;
import com.google.api.gax.httpjson.testing.MockHttpService;
import com.google.api.gax.rpc.ApiClientHeaderProvider;
import com.google.api.gax.rpc.ApiException;
import com.google.api.gax.rpc.ApiExceptionFactory;
import com.google.api.gax.rpc.InvalidArgumentException;
import com.google.api.gax.rpc.StatusCode;
import com.google.api.gax.rpc.testing.FakeStatusCode;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.Generated;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Assert;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

@Generated("by gapic-generator-java")
public class IngestionServiceClientHttpJsonTest {
  private static MockHttpService mockService;
  private static IngestionServiceClient client;

  @BeforeClass
  public static void startStaticServer() throws IOException {
    mockService =
        new MockHttpService(
            HttpJsonIngestionServiceStub.getMethodDescriptors(),
            IngestionServiceSettings.getDefaultEndpoint());
    IngestionServiceSettings settings =
        IngestionServiceSettings.newHttpJsonBuilder()
            .setTransportChannelProvider(
                IngestionServiceSettings.defaultHttpJsonTransportProviderBuilder()
                    .setHttpTransport(mockService)
                    .build())
            .setCredentialsProvider(NoCredentialsProvider.create())
            .build();
    client = IngestionServiceClient.create(settings);
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
  public void ingestAudienceMembersTest() throws Exception {
    IngestAudienceMembersResponse expectedResponse =
        IngestAudienceMembersResponse.newBuilder().setRequestId("requestId693933066").build();
    mockService.addResponse(expectedResponse);

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
  public void ingestAudienceMembersExceptionTest() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

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
    mockService.addResponse(expectedResponse);

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
  public void removeAudienceMembersExceptionTest() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

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
    mockService.addResponse(expectedResponse);

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
  public void ingestEventsExceptionTest() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

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
    mockService.addResponse(expectedResponse);

    RetrieveRequestStatusRequest request =
        RetrieveRequestStatusRequest.newBuilder().setRequestId("requestId693933066").build();

    RetrieveRequestStatusResponse actualResponse = client.retrieveRequestStatus(request);
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
  public void retrieveRequestStatusExceptionTest() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

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
