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

package com.google.ads.admanager.v1;

import static com.google.ads.admanager.v1.AudienceSegmentServiceClient.ListAudienceSegmentsPagedResponse;

import com.google.ads.admanager.v1.stub.HttpJsonAudienceSegmentServiceStub;
import com.google.api.gax.core.NoCredentialsProvider;
import com.google.api.gax.httpjson.GaxHttpJsonProperties;
import com.google.api.gax.httpjson.testing.MockHttpService;
import com.google.api.gax.rpc.ApiClientHeaderProvider;
import com.google.api.gax.rpc.ApiException;
import com.google.api.gax.rpc.ApiExceptionFactory;
import com.google.api.gax.rpc.InvalidArgumentException;
import com.google.api.gax.rpc.StatusCode;
import com.google.api.gax.rpc.testing.FakeStatusCode;
import com.google.common.collect.Lists;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import javax.annotation.Generated;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Assert;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

@Generated("by gapic-generator-java")
public class AudienceSegmentServiceClientTest {
  private static MockHttpService mockService;
  private static AudienceSegmentServiceClient client;

  @BeforeClass
  public static void startStaticServer() throws IOException {
    mockService =
        new MockHttpService(
            HttpJsonAudienceSegmentServiceStub.getMethodDescriptors(),
            AudienceSegmentServiceSettings.getDefaultEndpoint());
    AudienceSegmentServiceSettings settings =
        AudienceSegmentServiceSettings.newBuilder()
            .setTransportChannelProvider(
                AudienceSegmentServiceSettings.defaultHttpJsonTransportProviderBuilder()
                    .setHttpTransport(mockService)
                    .build())
            .setCredentialsProvider(NoCredentialsProvider.create())
            .build();
    client = AudienceSegmentServiceClient.create(settings);
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
  public void getAudienceSegmentTest() throws Exception {
    AudienceSegment expectedResponse =
        AudienceSegment.newBuilder()
            .setName(AudienceSegmentName.of("[NETWORK_CODE]", "[AUDIENCE_SEGMENT]").toString())
            .setSharedId(-1581568203)
            .setDisplayName("displayName1714148973")
            .addAllCategoryIds(new ArrayList<Long>())
            .setDescription("description-1724546052")
            .setSize(3530753)
            .setMobileWebSize(-1281165047)
            .setIdfaSize(582571914)
            .setAdIdSize(1772250249)
            .setPpidSize(-1292388699)
            .setDataProviderDisplayName("dataProviderDisplayName-1798710350")
            .build();
    mockService.addResponse(expectedResponse);

    AudienceSegmentName name = AudienceSegmentName.of("[NETWORK_CODE]", "[AUDIENCE_SEGMENT]");

    AudienceSegment actualResponse = client.getAudienceSegment(name);
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
  public void getAudienceSegmentExceptionTest() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

    try {
      AudienceSegmentName name = AudienceSegmentName.of("[NETWORK_CODE]", "[AUDIENCE_SEGMENT]");
      client.getAudienceSegment(name);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void getAudienceSegmentTest2() throws Exception {
    AudienceSegment expectedResponse =
        AudienceSegment.newBuilder()
            .setName(AudienceSegmentName.of("[NETWORK_CODE]", "[AUDIENCE_SEGMENT]").toString())
            .setSharedId(-1581568203)
            .setDisplayName("displayName1714148973")
            .addAllCategoryIds(new ArrayList<Long>())
            .setDescription("description-1724546052")
            .setSize(3530753)
            .setMobileWebSize(-1281165047)
            .setIdfaSize(582571914)
            .setAdIdSize(1772250249)
            .setPpidSize(-1292388699)
            .setDataProviderDisplayName("dataProviderDisplayName-1798710350")
            .build();
    mockService.addResponse(expectedResponse);

    String name = "networks/network-4525/audienceSegments/audienceSegment-4525";

    AudienceSegment actualResponse = client.getAudienceSegment(name);
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
  public void getAudienceSegmentExceptionTest2() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

    try {
      String name = "networks/network-4525/audienceSegments/audienceSegment-4525";
      client.getAudienceSegment(name);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void listAudienceSegmentsTest() throws Exception {
    AudienceSegment responsesElement = AudienceSegment.newBuilder().build();
    ListAudienceSegmentsResponse expectedResponse =
        ListAudienceSegmentsResponse.newBuilder()
            .setNextPageToken("")
            .addAllAudienceSegments(Arrays.asList(responsesElement))
            .build();
    mockService.addResponse(expectedResponse);

    NetworkName parent = NetworkName.of("[NETWORK_CODE]");

    ListAudienceSegmentsPagedResponse pagedListResponse = client.listAudienceSegments(parent);

    List<AudienceSegment> resources = Lists.newArrayList(pagedListResponse.iterateAll());

    Assert.assertEquals(1, resources.size());
    Assert.assertEquals(expectedResponse.getAudienceSegmentsList().get(0), resources.get(0));

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
  public void listAudienceSegmentsExceptionTest() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

    try {
      NetworkName parent = NetworkName.of("[NETWORK_CODE]");
      client.listAudienceSegments(parent);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void listAudienceSegmentsTest2() throws Exception {
    AudienceSegment responsesElement = AudienceSegment.newBuilder().build();
    ListAudienceSegmentsResponse expectedResponse =
        ListAudienceSegmentsResponse.newBuilder()
            .setNextPageToken("")
            .addAllAudienceSegments(Arrays.asList(responsesElement))
            .build();
    mockService.addResponse(expectedResponse);

    String parent = "networks/network-5450";

    ListAudienceSegmentsPagedResponse pagedListResponse = client.listAudienceSegments(parent);

    List<AudienceSegment> resources = Lists.newArrayList(pagedListResponse.iterateAll());

    Assert.assertEquals(1, resources.size());
    Assert.assertEquals(expectedResponse.getAudienceSegmentsList().get(0), resources.get(0));

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
  public void listAudienceSegmentsExceptionTest2() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

    try {
      String parent = "networks/network-5450";
      client.listAudienceSegments(parent);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void batchActivateAudienceSegmentsTest() throws Exception {
    BatchActivateAudienceSegmentsResponse expectedResponse =
        BatchActivateAudienceSegmentsResponse.newBuilder().setChangeCount(235488192).build();
    mockService.addResponse(expectedResponse);

    NetworkName parent = NetworkName.of("[NETWORK_CODE]");
    List<String> names = new ArrayList<>();

    BatchActivateAudienceSegmentsResponse actualResponse =
        client.batchActivateAudienceSegments(parent, names);
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
  public void batchActivateAudienceSegmentsExceptionTest() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

    try {
      NetworkName parent = NetworkName.of("[NETWORK_CODE]");
      List<String> names = new ArrayList<>();
      client.batchActivateAudienceSegments(parent, names);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void batchActivateAudienceSegmentsTest2() throws Exception {
    BatchActivateAudienceSegmentsResponse expectedResponse =
        BatchActivateAudienceSegmentsResponse.newBuilder().setChangeCount(235488192).build();
    mockService.addResponse(expectedResponse);

    String parent = "networks/network-5450";
    List<String> names = new ArrayList<>();

    BatchActivateAudienceSegmentsResponse actualResponse =
        client.batchActivateAudienceSegments(parent, names);
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
  public void batchActivateAudienceSegmentsExceptionTest2() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

    try {
      String parent = "networks/network-5450";
      List<String> names = new ArrayList<>();
      client.batchActivateAudienceSegments(parent, names);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void batchDeactivateAudienceSegmentsTest() throws Exception {
    BatchDeactivateAudienceSegmentsResponse expectedResponse =
        BatchDeactivateAudienceSegmentsResponse.newBuilder().setChangeCount(235488192).build();
    mockService.addResponse(expectedResponse);

    NetworkName parent = NetworkName.of("[NETWORK_CODE]");
    List<String> names = new ArrayList<>();

    BatchDeactivateAudienceSegmentsResponse actualResponse =
        client.batchDeactivateAudienceSegments(parent, names);
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
  public void batchDeactivateAudienceSegmentsExceptionTest() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

    try {
      NetworkName parent = NetworkName.of("[NETWORK_CODE]");
      List<String> names = new ArrayList<>();
      client.batchDeactivateAudienceSegments(parent, names);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void batchDeactivateAudienceSegmentsTest2() throws Exception {
    BatchDeactivateAudienceSegmentsResponse expectedResponse =
        BatchDeactivateAudienceSegmentsResponse.newBuilder().setChangeCount(235488192).build();
    mockService.addResponse(expectedResponse);

    String parent = "networks/network-5450";
    List<String> names = new ArrayList<>();

    BatchDeactivateAudienceSegmentsResponse actualResponse =
        client.batchDeactivateAudienceSegments(parent, names);
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
  public void batchDeactivateAudienceSegmentsExceptionTest2() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

    try {
      String parent = "networks/network-5450";
      List<String> names = new ArrayList<>();
      client.batchDeactivateAudienceSegments(parent, names);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void batchApproveAudienceSegmentsTest() throws Exception {
    BatchApproveAudienceSegmentsResponse expectedResponse =
        BatchApproveAudienceSegmentsResponse.newBuilder().setChangeCount(235488192).build();
    mockService.addResponse(expectedResponse);

    NetworkName parent = NetworkName.of("[NETWORK_CODE]");
    List<String> names = new ArrayList<>();

    BatchApproveAudienceSegmentsResponse actualResponse =
        client.batchApproveAudienceSegments(parent, names);
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
  public void batchApproveAudienceSegmentsExceptionTest() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

    try {
      NetworkName parent = NetworkName.of("[NETWORK_CODE]");
      List<String> names = new ArrayList<>();
      client.batchApproveAudienceSegments(parent, names);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void batchApproveAudienceSegmentsTest2() throws Exception {
    BatchApproveAudienceSegmentsResponse expectedResponse =
        BatchApproveAudienceSegmentsResponse.newBuilder().setChangeCount(235488192).build();
    mockService.addResponse(expectedResponse);

    String parent = "networks/network-5450";
    List<String> names = new ArrayList<>();

    BatchApproveAudienceSegmentsResponse actualResponse =
        client.batchApproveAudienceSegments(parent, names);
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
  public void batchApproveAudienceSegmentsExceptionTest2() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

    try {
      String parent = "networks/network-5450";
      List<String> names = new ArrayList<>();
      client.batchApproveAudienceSegments(parent, names);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void batchRejectAudienceSegmentsTest() throws Exception {
    BatchRejectAudienceSegmentsResponse expectedResponse =
        BatchRejectAudienceSegmentsResponse.newBuilder().setChangeCount(235488192).build();
    mockService.addResponse(expectedResponse);

    NetworkName parent = NetworkName.of("[NETWORK_CODE]");
    List<String> names = new ArrayList<>();

    BatchRejectAudienceSegmentsResponse actualResponse =
        client.batchRejectAudienceSegments(parent, names);
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
  public void batchRejectAudienceSegmentsExceptionTest() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

    try {
      NetworkName parent = NetworkName.of("[NETWORK_CODE]");
      List<String> names = new ArrayList<>();
      client.batchRejectAudienceSegments(parent, names);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void batchRejectAudienceSegmentsTest2() throws Exception {
    BatchRejectAudienceSegmentsResponse expectedResponse =
        BatchRejectAudienceSegmentsResponse.newBuilder().setChangeCount(235488192).build();
    mockService.addResponse(expectedResponse);

    String parent = "networks/network-5450";
    List<String> names = new ArrayList<>();

    BatchRejectAudienceSegmentsResponse actualResponse =
        client.batchRejectAudienceSegments(parent, names);
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
  public void batchRejectAudienceSegmentsExceptionTest2() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

    try {
      String parent = "networks/network-5450";
      List<String> names = new ArrayList<>();
      client.batchRejectAudienceSegments(parent, names);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void batchPopulateAudienceSegmentsTest() throws Exception {
    BatchPopulateAudienceSegmentsResponse expectedResponse =
        BatchPopulateAudienceSegmentsResponse.newBuilder().setChangeCount(235488192).build();
    mockService.addResponse(expectedResponse);

    NetworkName parent = NetworkName.of("[NETWORK_CODE]");
    List<String> names = new ArrayList<>();

    BatchPopulateAudienceSegmentsResponse actualResponse =
        client.batchPopulateAudienceSegments(parent, names);
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
  public void batchPopulateAudienceSegmentsExceptionTest() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

    try {
      NetworkName parent = NetworkName.of("[NETWORK_CODE]");
      List<String> names = new ArrayList<>();
      client.batchPopulateAudienceSegments(parent, names);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void batchPopulateAudienceSegmentsTest2() throws Exception {
    BatchPopulateAudienceSegmentsResponse expectedResponse =
        BatchPopulateAudienceSegmentsResponse.newBuilder().setChangeCount(235488192).build();
    mockService.addResponse(expectedResponse);

    String parent = "networks/network-5450";
    List<String> names = new ArrayList<>();

    BatchPopulateAudienceSegmentsResponse actualResponse =
        client.batchPopulateAudienceSegments(parent, names);
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
  public void batchPopulateAudienceSegmentsExceptionTest2() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

    try {
      String parent = "networks/network-5450";
      List<String> names = new ArrayList<>();
      client.batchPopulateAudienceSegments(parent, names);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }
}
