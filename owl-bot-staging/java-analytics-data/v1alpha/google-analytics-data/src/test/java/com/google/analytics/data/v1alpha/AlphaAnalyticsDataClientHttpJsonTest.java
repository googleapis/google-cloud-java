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

package com.google.analytics.data.v1alpha;

import static com.google.analytics.data.v1alpha.AlphaAnalyticsDataClient.ListAudienceListsPagedResponse;

import com.google.analytics.data.v1alpha.stub.HttpJsonAlphaAnalyticsDataStub;
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
import com.google.longrunning.Operation;
import com.google.protobuf.Any;
import com.google.protobuf.Timestamp;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.concurrent.ExecutionException;
import javax.annotation.Generated;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Assert;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

@Generated("by gapic-generator-java")
public class AlphaAnalyticsDataClientHttpJsonTest {
  private static MockHttpService mockService;
  private static AlphaAnalyticsDataClient client;

  @BeforeClass
  public static void startStaticServer() throws IOException {
    mockService =
        new MockHttpService(
            HttpJsonAlphaAnalyticsDataStub.getMethodDescriptors(),
            AlphaAnalyticsDataSettings.getDefaultEndpoint());
    AlphaAnalyticsDataSettings settings =
        AlphaAnalyticsDataSettings.newHttpJsonBuilder()
            .setTransportChannelProvider(
                AlphaAnalyticsDataSettings.defaultHttpJsonTransportProviderBuilder()
                    .setHttpTransport(mockService)
                    .build())
            .setCredentialsProvider(NoCredentialsProvider.create())
            .build();
    client = AlphaAnalyticsDataClient.create(settings);
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
  public void runFunnelReportTest() throws Exception {
    RunFunnelReportResponse expectedResponse =
        RunFunnelReportResponse.newBuilder()
            .setFunnelTable(FunnelSubReport.newBuilder().build())
            .setFunnelVisualization(FunnelSubReport.newBuilder().build())
            .setPropertyQuota(PropertyQuota.newBuilder().build())
            .setKind("kind3292052")
            .build();
    mockService.addResponse(expectedResponse);

    RunFunnelReportRequest request =
        RunFunnelReportRequest.newBuilder()
            .setProperty("properties/propertie-2179")
            .addAllDateRanges(new ArrayList<DateRange>())
            .setFunnel(Funnel.newBuilder().build())
            .setFunnelBreakdown(FunnelBreakdown.newBuilder().build())
            .setFunnelNextAction(FunnelNextAction.newBuilder().build())
            .addAllSegments(new ArrayList<Segment>())
            .setLimit(102976443)
            .setDimensionFilter(FilterExpression.newBuilder().build())
            .setReturnPropertyQuota(true)
            .build();

    RunFunnelReportResponse actualResponse = client.runFunnelReport(request);
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
  public void runFunnelReportExceptionTest() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

    try {
      RunFunnelReportRequest request =
          RunFunnelReportRequest.newBuilder()
              .setProperty("properties/propertie-2179")
              .addAllDateRanges(new ArrayList<DateRange>())
              .setFunnel(Funnel.newBuilder().build())
              .setFunnelBreakdown(FunnelBreakdown.newBuilder().build())
              .setFunnelNextAction(FunnelNextAction.newBuilder().build())
              .addAllSegments(new ArrayList<Segment>())
              .setLimit(102976443)
              .setDimensionFilter(FilterExpression.newBuilder().build())
              .setReturnPropertyQuota(true)
              .build();
      client.runFunnelReport(request);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void createAudienceListTest() throws Exception {
    AudienceList expectedResponse =
        AudienceList.newBuilder()
            .setName(AudienceListName.of("[PROPERTYID]", "[AUDIENCELISTID]").toString())
            .setAudience("audience975628804")
            .setAudienceDisplayName("audienceDisplayName1537141193")
            .addAllDimensions(new ArrayList<AudienceDimension>())
            .setBeginCreatingTime(Timestamp.newBuilder().build())
            .build();
    Operation resultOperation =
        Operation.newBuilder()
            .setName("createAudienceListTest")
            .setDone(true)
            .setResponse(Any.pack(expectedResponse))
            .build();
    mockService.addResponse(resultOperation);

    PropertyName parent = PropertyName.of("[PROPERTYID]");
    AudienceList audienceList = AudienceList.newBuilder().build();

    AudienceList actualResponse = client.createAudienceListAsync(parent, audienceList).get();
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
  public void createAudienceListExceptionTest() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

    try {
      PropertyName parent = PropertyName.of("[PROPERTYID]");
      AudienceList audienceList = AudienceList.newBuilder().build();
      client.createAudienceListAsync(parent, audienceList).get();
      Assert.fail("No exception raised");
    } catch (ExecutionException e) {
    }
  }

  @Test
  public void createAudienceListTest2() throws Exception {
    AudienceList expectedResponse =
        AudienceList.newBuilder()
            .setName(AudienceListName.of("[PROPERTYID]", "[AUDIENCELISTID]").toString())
            .setAudience("audience975628804")
            .setAudienceDisplayName("audienceDisplayName1537141193")
            .addAllDimensions(new ArrayList<AudienceDimension>())
            .setBeginCreatingTime(Timestamp.newBuilder().build())
            .build();
    Operation resultOperation =
        Operation.newBuilder()
            .setName("createAudienceListTest")
            .setDone(true)
            .setResponse(Any.pack(expectedResponse))
            .build();
    mockService.addResponse(resultOperation);

    String parent = "properties/propertie-2024";
    AudienceList audienceList = AudienceList.newBuilder().build();

    AudienceList actualResponse = client.createAudienceListAsync(parent, audienceList).get();
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
  public void createAudienceListExceptionTest2() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

    try {
      String parent = "properties/propertie-2024";
      AudienceList audienceList = AudienceList.newBuilder().build();
      client.createAudienceListAsync(parent, audienceList).get();
      Assert.fail("No exception raised");
    } catch (ExecutionException e) {
    }
  }

  @Test
  public void queryAudienceListTest() throws Exception {
    QueryAudienceListResponse expectedResponse =
        QueryAudienceListResponse.newBuilder()
            .setAudienceList(AudienceList.newBuilder().build())
            .addAllAudienceRows(new ArrayList<AudienceRow>())
            .setRowCount(1340416618)
            .build();
    mockService.addResponse(expectedResponse);

    String name = "properties/propertie-6618/audienceLists/audienceList-6618";

    QueryAudienceListResponse actualResponse = client.queryAudienceList(name);
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
  public void queryAudienceListExceptionTest() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

    try {
      String name = "properties/propertie-6618/audienceLists/audienceList-6618";
      client.queryAudienceList(name);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void getAudienceListTest() throws Exception {
    AudienceList expectedResponse =
        AudienceList.newBuilder()
            .setName(AudienceListName.of("[PROPERTYID]", "[AUDIENCELISTID]").toString())
            .setAudience("audience975628804")
            .setAudienceDisplayName("audienceDisplayName1537141193")
            .addAllDimensions(new ArrayList<AudienceDimension>())
            .setBeginCreatingTime(Timestamp.newBuilder().build())
            .build();
    mockService.addResponse(expectedResponse);

    AudienceListName name = AudienceListName.of("[PROPERTYID]", "[AUDIENCELISTID]");

    AudienceList actualResponse = client.getAudienceList(name);
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
  public void getAudienceListExceptionTest() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

    try {
      AudienceListName name = AudienceListName.of("[PROPERTYID]", "[AUDIENCELISTID]");
      client.getAudienceList(name);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void getAudienceListTest2() throws Exception {
    AudienceList expectedResponse =
        AudienceList.newBuilder()
            .setName(AudienceListName.of("[PROPERTYID]", "[AUDIENCELISTID]").toString())
            .setAudience("audience975628804")
            .setAudienceDisplayName("audienceDisplayName1537141193")
            .addAllDimensions(new ArrayList<AudienceDimension>())
            .setBeginCreatingTime(Timestamp.newBuilder().build())
            .build();
    mockService.addResponse(expectedResponse);

    String name = "properties/propertie-6618/audienceLists/audienceList-6618";

    AudienceList actualResponse = client.getAudienceList(name);
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
  public void getAudienceListExceptionTest2() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

    try {
      String name = "properties/propertie-6618/audienceLists/audienceList-6618";
      client.getAudienceList(name);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void listAudienceListsTest() throws Exception {
    AudienceList responsesElement = AudienceList.newBuilder().build();
    ListAudienceListsResponse expectedResponse =
        ListAudienceListsResponse.newBuilder()
            .setNextPageToken("")
            .addAllAudienceLists(Arrays.asList(responsesElement))
            .build();
    mockService.addResponse(expectedResponse);

    PropertyName parent = PropertyName.of("[PROPERTYID]");

    ListAudienceListsPagedResponse pagedListResponse = client.listAudienceLists(parent);

    List<AudienceList> resources = Lists.newArrayList(pagedListResponse.iterateAll());

    Assert.assertEquals(1, resources.size());
    Assert.assertEquals(expectedResponse.getAudienceListsList().get(0), resources.get(0));

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
  public void listAudienceListsExceptionTest() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

    try {
      PropertyName parent = PropertyName.of("[PROPERTYID]");
      client.listAudienceLists(parent);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void listAudienceListsTest2() throws Exception {
    AudienceList responsesElement = AudienceList.newBuilder().build();
    ListAudienceListsResponse expectedResponse =
        ListAudienceListsResponse.newBuilder()
            .setNextPageToken("")
            .addAllAudienceLists(Arrays.asList(responsesElement))
            .build();
    mockService.addResponse(expectedResponse);

    String parent = "properties/propertie-2024";

    ListAudienceListsPagedResponse pagedListResponse = client.listAudienceLists(parent);

    List<AudienceList> resources = Lists.newArrayList(pagedListResponse.iterateAll());

    Assert.assertEquals(1, resources.size());
    Assert.assertEquals(expectedResponse.getAudienceListsList().get(0), resources.get(0));

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
  public void listAudienceListsExceptionTest2() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

    try {
      String parent = "properties/propertie-2024";
      client.listAudienceLists(parent);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }
}
