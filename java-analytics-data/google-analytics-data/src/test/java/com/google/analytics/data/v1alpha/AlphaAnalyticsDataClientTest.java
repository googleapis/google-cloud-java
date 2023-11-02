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

import com.google.api.gax.core.NoCredentialsProvider;
import com.google.api.gax.grpc.GaxGrpcProperties;
import com.google.api.gax.grpc.testing.LocalChannelProvider;
import com.google.api.gax.grpc.testing.MockGrpcService;
import com.google.api.gax.grpc.testing.MockServiceHelper;
import com.google.api.gax.rpc.ApiClientHeaderProvider;
import com.google.api.gax.rpc.InvalidArgumentException;
import com.google.api.gax.rpc.StatusCode;
import com.google.common.collect.Lists;
import com.google.longrunning.Operation;
import com.google.protobuf.AbstractMessage;
import com.google.protobuf.Any;
import com.google.protobuf.Timestamp;
import io.grpc.StatusRuntimeException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.UUID;
import java.util.concurrent.ExecutionException;
import javax.annotation.Generated;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Assert;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

@Generated("by gapic-generator-java")
public class AlphaAnalyticsDataClientTest {
  private static MockAlphaAnalyticsData mockAlphaAnalyticsData;
  private static MockServiceHelper mockServiceHelper;
  private LocalChannelProvider channelProvider;
  private AlphaAnalyticsDataClient client;

  @BeforeClass
  public static void startStaticServer() {
    mockAlphaAnalyticsData = new MockAlphaAnalyticsData();
    mockServiceHelper =
        new MockServiceHelper(
            UUID.randomUUID().toString(), Arrays.<MockGrpcService>asList(mockAlphaAnalyticsData));
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
    AlphaAnalyticsDataSettings settings =
        AlphaAnalyticsDataSettings.newBuilder()
            .setTransportChannelProvider(channelProvider)
            .setCredentialsProvider(NoCredentialsProvider.create())
            .build();
    client = AlphaAnalyticsDataClient.create(settings);
  }

  @After
  public void tearDown() throws Exception {
    client.close();
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
    mockAlphaAnalyticsData.addResponse(expectedResponse);

    RunFunnelReportRequest request =
        RunFunnelReportRequest.newBuilder()
            .setProperty("property-993141291")
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

    List<AbstractMessage> actualRequests = mockAlphaAnalyticsData.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    RunFunnelReportRequest actualRequest = ((RunFunnelReportRequest) actualRequests.get(0));

    Assert.assertEquals(request.getProperty(), actualRequest.getProperty());
    Assert.assertEquals(request.getDateRangesList(), actualRequest.getDateRangesList());
    Assert.assertEquals(request.getFunnel(), actualRequest.getFunnel());
    Assert.assertEquals(request.getFunnelBreakdown(), actualRequest.getFunnelBreakdown());
    Assert.assertEquals(request.getFunnelNextAction(), actualRequest.getFunnelNextAction());
    Assert.assertEquals(
        request.getFunnelVisualizationType(), actualRequest.getFunnelVisualizationType());
    Assert.assertEquals(request.getSegmentsList(), actualRequest.getSegmentsList());
    Assert.assertEquals(request.getLimit(), actualRequest.getLimit());
    Assert.assertEquals(request.getDimensionFilter(), actualRequest.getDimensionFilter());
    Assert.assertEquals(request.getReturnPropertyQuota(), actualRequest.getReturnPropertyQuota());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void runFunnelReportExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockAlphaAnalyticsData.addException(exception);

    try {
      RunFunnelReportRequest request =
          RunFunnelReportRequest.newBuilder()
              .setProperty("property-993141291")
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
    mockAlphaAnalyticsData.addResponse(resultOperation);

    PropertyName parent = PropertyName.of("[PROPERTYID]");
    AudienceList audienceList = AudienceList.newBuilder().build();

    AudienceList actualResponse = client.createAudienceListAsync(parent, audienceList).get();
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockAlphaAnalyticsData.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    CreateAudienceListRequest actualRequest = ((CreateAudienceListRequest) actualRequests.get(0));

    Assert.assertEquals(parent.toString(), actualRequest.getParent());
    Assert.assertEquals(audienceList, actualRequest.getAudienceList());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void createAudienceListExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockAlphaAnalyticsData.addException(exception);

    try {
      PropertyName parent = PropertyName.of("[PROPERTYID]");
      AudienceList audienceList = AudienceList.newBuilder().build();
      client.createAudienceListAsync(parent, audienceList).get();
      Assert.fail("No exception raised");
    } catch (ExecutionException e) {
      Assert.assertEquals(InvalidArgumentException.class, e.getCause().getClass());
      InvalidArgumentException apiException = ((InvalidArgumentException) e.getCause());
      Assert.assertEquals(StatusCode.Code.INVALID_ARGUMENT, apiException.getStatusCode().getCode());
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
    mockAlphaAnalyticsData.addResponse(resultOperation);

    String parent = "parent-995424086";
    AudienceList audienceList = AudienceList.newBuilder().build();

    AudienceList actualResponse = client.createAudienceListAsync(parent, audienceList).get();
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockAlphaAnalyticsData.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    CreateAudienceListRequest actualRequest = ((CreateAudienceListRequest) actualRequests.get(0));

    Assert.assertEquals(parent, actualRequest.getParent());
    Assert.assertEquals(audienceList, actualRequest.getAudienceList());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void createAudienceListExceptionTest2() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockAlphaAnalyticsData.addException(exception);

    try {
      String parent = "parent-995424086";
      AudienceList audienceList = AudienceList.newBuilder().build();
      client.createAudienceListAsync(parent, audienceList).get();
      Assert.fail("No exception raised");
    } catch (ExecutionException e) {
      Assert.assertEquals(InvalidArgumentException.class, e.getCause().getClass());
      InvalidArgumentException apiException = ((InvalidArgumentException) e.getCause());
      Assert.assertEquals(StatusCode.Code.INVALID_ARGUMENT, apiException.getStatusCode().getCode());
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
    mockAlphaAnalyticsData.addResponse(expectedResponse);

    String name = "name3373707";

    QueryAudienceListResponse actualResponse = client.queryAudienceList(name);
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockAlphaAnalyticsData.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    QueryAudienceListRequest actualRequest = ((QueryAudienceListRequest) actualRequests.get(0));

    Assert.assertEquals(name, actualRequest.getName());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void queryAudienceListExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockAlphaAnalyticsData.addException(exception);

    try {
      String name = "name3373707";
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
    mockAlphaAnalyticsData.addResponse(expectedResponse);

    AudienceListName name = AudienceListName.of("[PROPERTYID]", "[AUDIENCELISTID]");

    AudienceList actualResponse = client.getAudienceList(name);
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockAlphaAnalyticsData.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    GetAudienceListRequest actualRequest = ((GetAudienceListRequest) actualRequests.get(0));

    Assert.assertEquals(name.toString(), actualRequest.getName());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void getAudienceListExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockAlphaAnalyticsData.addException(exception);

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
    mockAlphaAnalyticsData.addResponse(expectedResponse);

    String name = "name3373707";

    AudienceList actualResponse = client.getAudienceList(name);
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockAlphaAnalyticsData.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    GetAudienceListRequest actualRequest = ((GetAudienceListRequest) actualRequests.get(0));

    Assert.assertEquals(name, actualRequest.getName());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void getAudienceListExceptionTest2() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockAlphaAnalyticsData.addException(exception);

    try {
      String name = "name3373707";
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
    mockAlphaAnalyticsData.addResponse(expectedResponse);

    PropertyName parent = PropertyName.of("[PROPERTYID]");

    ListAudienceListsPagedResponse pagedListResponse = client.listAudienceLists(parent);

    List<AudienceList> resources = Lists.newArrayList(pagedListResponse.iterateAll());

    Assert.assertEquals(1, resources.size());
    Assert.assertEquals(expectedResponse.getAudienceListsList().get(0), resources.get(0));

    List<AbstractMessage> actualRequests = mockAlphaAnalyticsData.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    ListAudienceListsRequest actualRequest = ((ListAudienceListsRequest) actualRequests.get(0));

    Assert.assertEquals(parent.toString(), actualRequest.getParent());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void listAudienceListsExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockAlphaAnalyticsData.addException(exception);

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
    mockAlphaAnalyticsData.addResponse(expectedResponse);

    String parent = "parent-995424086";

    ListAudienceListsPagedResponse pagedListResponse = client.listAudienceLists(parent);

    List<AudienceList> resources = Lists.newArrayList(pagedListResponse.iterateAll());

    Assert.assertEquals(1, resources.size());
    Assert.assertEquals(expectedResponse.getAudienceListsList().get(0), resources.get(0));

    List<AbstractMessage> actualRequests = mockAlphaAnalyticsData.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    ListAudienceListsRequest actualRequest = ((ListAudienceListsRequest) actualRequests.get(0));

    Assert.assertEquals(parent, actualRequest.getParent());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void listAudienceListsExceptionTest2() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockAlphaAnalyticsData.addException(exception);

    try {
      String parent = "parent-995424086";
      client.listAudienceLists(parent);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }
}
