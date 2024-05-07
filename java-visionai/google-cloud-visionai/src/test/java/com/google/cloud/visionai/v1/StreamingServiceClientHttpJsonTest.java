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

package com.google.cloud.visionai.v1;

import com.google.api.gax.core.NoCredentialsProvider;
import com.google.api.gax.httpjson.GaxHttpJsonProperties;
import com.google.api.gax.httpjson.testing.MockHttpService;
import com.google.api.gax.rpc.ApiClientHeaderProvider;
import com.google.api.gax.rpc.ApiException;
import com.google.api.gax.rpc.ApiExceptionFactory;
import com.google.api.gax.rpc.InvalidArgumentException;
import com.google.api.gax.rpc.StatusCode;
import com.google.api.gax.rpc.testing.FakeStatusCode;
import com.google.cloud.visionai.v1.stub.HttpJsonStreamingServiceStub;
import com.google.protobuf.Duration;
import com.google.protobuf.Timestamp;
import java.io.IOException;
import java.util.List;
import javax.annotation.Generated;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Assert;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

@Generated("by gapic-generator-java")
public class StreamingServiceClientHttpJsonTest {
  private static MockHttpService mockService;
  private static StreamingServiceClient client;

  @BeforeClass
  public static void startStaticServer() throws IOException {
    mockService =
        new MockHttpService(
            HttpJsonStreamingServiceStub.getMethodDescriptors(),
            StreamingServiceSettings.getDefaultEndpoint());
    StreamingServiceSettings settings =
        StreamingServiceSettings.newHttpJsonBuilder()
            .setTransportChannelProvider(
                StreamingServiceSettings.defaultHttpJsonTransportProviderBuilder()
                    .setHttpTransport(mockService)
                    .build())
            .setCredentialsProvider(NoCredentialsProvider.create())
            .build();
    client = StreamingServiceClient.create(settings);
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
  public void sendPacketsUnsupportedMethodTest() throws Exception {
    // The sendPackets() method is not supported in REST transport.
    // This empty test is generated for technical reasons.
  }

  @Test
  public void receivePacketsUnsupportedMethodTest() throws Exception {
    // The receivePackets() method is not supported in REST transport.
    // This empty test is generated for technical reasons.
  }

  @Test
  public void receiveEventsUnsupportedMethodTest() throws Exception {
    // The receiveEvents() method is not supported in REST transport.
    // This empty test is generated for technical reasons.
  }

  @Test
  public void acquireLeaseTest() throws Exception {
    Lease expectedResponse =
        Lease.newBuilder()
            .setId("id3355")
            .setSeries("series-905838985")
            .setOwner("owner106164915")
            .setExpireTime(Timestamp.newBuilder().build())
            .setLeaseType(LeaseType.forNumber(0))
            .build();
    mockService.addResponse(expectedResponse);

    AcquireLeaseRequest request =
        AcquireLeaseRequest.newBuilder()
            .setSeries(
                "projects/project-4804/locations/location-4804/clusters/cluster-4804/series/serie-4804")
            .setOwner("owner106164915")
            .setTerm(Duration.newBuilder().build())
            .setLeaseType(LeaseType.forNumber(0))
            .build();

    Lease actualResponse = client.acquireLease(request);
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
  public void acquireLeaseExceptionTest() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

    try {
      AcquireLeaseRequest request =
          AcquireLeaseRequest.newBuilder()
              .setSeries(
                  "projects/project-4804/locations/location-4804/clusters/cluster-4804/series/serie-4804")
              .setOwner("owner106164915")
              .setTerm(Duration.newBuilder().build())
              .setLeaseType(LeaseType.forNumber(0))
              .build();
      client.acquireLease(request);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void renewLeaseTest() throws Exception {
    Lease expectedResponse =
        Lease.newBuilder()
            .setId("id3355")
            .setSeries("series-905838985")
            .setOwner("owner106164915")
            .setExpireTime(Timestamp.newBuilder().build())
            .setLeaseType(LeaseType.forNumber(0))
            .build();
    mockService.addResponse(expectedResponse);

    RenewLeaseRequest request =
        RenewLeaseRequest.newBuilder()
            .setId("id3355")
            .setSeries(
                "projects/project-4804/locations/location-4804/clusters/cluster-4804/series/serie-4804")
            .setOwner("owner106164915")
            .setTerm(Duration.newBuilder().build())
            .build();

    Lease actualResponse = client.renewLease(request);
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
  public void renewLeaseExceptionTest() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

    try {
      RenewLeaseRequest request =
          RenewLeaseRequest.newBuilder()
              .setId("id3355")
              .setSeries(
                  "projects/project-4804/locations/location-4804/clusters/cluster-4804/series/serie-4804")
              .setOwner("owner106164915")
              .setTerm(Duration.newBuilder().build())
              .build();
      client.renewLease(request);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void releaseLeaseTest() throws Exception {
    ReleaseLeaseResponse expectedResponse = ReleaseLeaseResponse.newBuilder().build();
    mockService.addResponse(expectedResponse);

    ReleaseLeaseRequest request =
        ReleaseLeaseRequest.newBuilder()
            .setId("id3355")
            .setSeries(
                "projects/project-4804/locations/location-4804/clusters/cluster-4804/series/serie-4804")
            .setOwner("owner106164915")
            .build();

    ReleaseLeaseResponse actualResponse = client.releaseLease(request);
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
  public void releaseLeaseExceptionTest() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

    try {
      ReleaseLeaseRequest request =
          ReleaseLeaseRequest.newBuilder()
              .setId("id3355")
              .setSeries(
                  "projects/project-4804/locations/location-4804/clusters/cluster-4804/series/serie-4804")
              .setOwner("owner106164915")
              .build();
      client.releaseLease(request);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }
}
