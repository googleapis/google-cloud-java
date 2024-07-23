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

package com.google.cloud.discoveryengine.v1alpha;

import static com.google.cloud.discoveryengine.v1alpha.SampleQueryServiceClient.ListSampleQueriesPagedResponse;

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
import com.google.protobuf.Empty;
import com.google.protobuf.FieldMask;
import com.google.protobuf.Timestamp;
import com.google.rpc.Status;
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
public class SampleQueryServiceClientTest {
  private static MockLocations mockLocations;
  private static MockSampleQueryService mockSampleQueryService;
  private static MockServiceHelper mockServiceHelper;
  private LocalChannelProvider channelProvider;
  private SampleQueryServiceClient client;

  @BeforeClass
  public static void startStaticServer() {
    mockSampleQueryService = new MockSampleQueryService();
    mockLocations = new MockLocations();
    mockServiceHelper =
        new MockServiceHelper(
            UUID.randomUUID().toString(),
            Arrays.<MockGrpcService>asList(mockSampleQueryService, mockLocations));
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
    SampleQueryServiceSettings settings =
        SampleQueryServiceSettings.newBuilder()
            .setTransportChannelProvider(channelProvider)
            .setCredentialsProvider(NoCredentialsProvider.create())
            .build();
    client = SampleQueryServiceClient.create(settings);
  }

  @After
  public void tearDown() throws Exception {
    client.close();
  }

  @Test
  public void getSampleQueryTest() throws Exception {
    SampleQuery expectedResponse =
        SampleQuery.newBuilder()
            .setName(
                SampleQueryName.of(
                        "[PROJECT]", "[LOCATION]", "[SAMPLE_QUERY_SET]", "[SAMPLE_QUERY]")
                    .toString())
            .setCreateTime(Timestamp.newBuilder().build())
            .build();
    mockSampleQueryService.addResponse(expectedResponse);

    SampleQueryName name =
        SampleQueryName.of("[PROJECT]", "[LOCATION]", "[SAMPLE_QUERY_SET]", "[SAMPLE_QUERY]");

    SampleQuery actualResponse = client.getSampleQuery(name);
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockSampleQueryService.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    GetSampleQueryRequest actualRequest = ((GetSampleQueryRequest) actualRequests.get(0));

    Assert.assertEquals(name.toString(), actualRequest.getName());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void getSampleQueryExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockSampleQueryService.addException(exception);

    try {
      SampleQueryName name =
          SampleQueryName.of("[PROJECT]", "[LOCATION]", "[SAMPLE_QUERY_SET]", "[SAMPLE_QUERY]");
      client.getSampleQuery(name);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void getSampleQueryTest2() throws Exception {
    SampleQuery expectedResponse =
        SampleQuery.newBuilder()
            .setName(
                SampleQueryName.of(
                        "[PROJECT]", "[LOCATION]", "[SAMPLE_QUERY_SET]", "[SAMPLE_QUERY]")
                    .toString())
            .setCreateTime(Timestamp.newBuilder().build())
            .build();
    mockSampleQueryService.addResponse(expectedResponse);

    String name = "name3373707";

    SampleQuery actualResponse = client.getSampleQuery(name);
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockSampleQueryService.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    GetSampleQueryRequest actualRequest = ((GetSampleQueryRequest) actualRequests.get(0));

    Assert.assertEquals(name, actualRequest.getName());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void getSampleQueryExceptionTest2() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockSampleQueryService.addException(exception);

    try {
      String name = "name3373707";
      client.getSampleQuery(name);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void listSampleQueriesTest() throws Exception {
    SampleQuery responsesElement = SampleQuery.newBuilder().build();
    ListSampleQueriesResponse expectedResponse =
        ListSampleQueriesResponse.newBuilder()
            .setNextPageToken("")
            .addAllSampleQueries(Arrays.asList(responsesElement))
            .build();
    mockSampleQueryService.addResponse(expectedResponse);

    SampleQuerySetName parent =
        SampleQuerySetName.of("[PROJECT]", "[LOCATION]", "[SAMPLE_QUERY_SET]");

    ListSampleQueriesPagedResponse pagedListResponse = client.listSampleQueries(parent);

    List<SampleQuery> resources = Lists.newArrayList(pagedListResponse.iterateAll());

    Assert.assertEquals(1, resources.size());
    Assert.assertEquals(expectedResponse.getSampleQueriesList().get(0), resources.get(0));

    List<AbstractMessage> actualRequests = mockSampleQueryService.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    ListSampleQueriesRequest actualRequest = ((ListSampleQueriesRequest) actualRequests.get(0));

    Assert.assertEquals(parent.toString(), actualRequest.getParent());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void listSampleQueriesExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockSampleQueryService.addException(exception);

    try {
      SampleQuerySetName parent =
          SampleQuerySetName.of("[PROJECT]", "[LOCATION]", "[SAMPLE_QUERY_SET]");
      client.listSampleQueries(parent);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void listSampleQueriesTest2() throws Exception {
    SampleQuery responsesElement = SampleQuery.newBuilder().build();
    ListSampleQueriesResponse expectedResponse =
        ListSampleQueriesResponse.newBuilder()
            .setNextPageToken("")
            .addAllSampleQueries(Arrays.asList(responsesElement))
            .build();
    mockSampleQueryService.addResponse(expectedResponse);

    String parent = "parent-995424086";

    ListSampleQueriesPagedResponse pagedListResponse = client.listSampleQueries(parent);

    List<SampleQuery> resources = Lists.newArrayList(pagedListResponse.iterateAll());

    Assert.assertEquals(1, resources.size());
    Assert.assertEquals(expectedResponse.getSampleQueriesList().get(0), resources.get(0));

    List<AbstractMessage> actualRequests = mockSampleQueryService.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    ListSampleQueriesRequest actualRequest = ((ListSampleQueriesRequest) actualRequests.get(0));

    Assert.assertEquals(parent, actualRequest.getParent());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void listSampleQueriesExceptionTest2() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockSampleQueryService.addException(exception);

    try {
      String parent = "parent-995424086";
      client.listSampleQueries(parent);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void createSampleQueryTest() throws Exception {
    SampleQuery expectedResponse =
        SampleQuery.newBuilder()
            .setName(
                SampleQueryName.of(
                        "[PROJECT]", "[LOCATION]", "[SAMPLE_QUERY_SET]", "[SAMPLE_QUERY]")
                    .toString())
            .setCreateTime(Timestamp.newBuilder().build())
            .build();
    mockSampleQueryService.addResponse(expectedResponse);

    SampleQuerySetName parent =
        SampleQuerySetName.of("[PROJECT]", "[LOCATION]", "[SAMPLE_QUERY_SET]");
    SampleQuery sampleQuery = SampleQuery.newBuilder().build();
    String sampleQueryId = "sampleQueryId1739022073";

    SampleQuery actualResponse = client.createSampleQuery(parent, sampleQuery, sampleQueryId);
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockSampleQueryService.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    CreateSampleQueryRequest actualRequest = ((CreateSampleQueryRequest) actualRequests.get(0));

    Assert.assertEquals(parent.toString(), actualRequest.getParent());
    Assert.assertEquals(sampleQuery, actualRequest.getSampleQuery());
    Assert.assertEquals(sampleQueryId, actualRequest.getSampleQueryId());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void createSampleQueryExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockSampleQueryService.addException(exception);

    try {
      SampleQuerySetName parent =
          SampleQuerySetName.of("[PROJECT]", "[LOCATION]", "[SAMPLE_QUERY_SET]");
      SampleQuery sampleQuery = SampleQuery.newBuilder().build();
      String sampleQueryId = "sampleQueryId1739022073";
      client.createSampleQuery(parent, sampleQuery, sampleQueryId);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void createSampleQueryTest2() throws Exception {
    SampleQuery expectedResponse =
        SampleQuery.newBuilder()
            .setName(
                SampleQueryName.of(
                        "[PROJECT]", "[LOCATION]", "[SAMPLE_QUERY_SET]", "[SAMPLE_QUERY]")
                    .toString())
            .setCreateTime(Timestamp.newBuilder().build())
            .build();
    mockSampleQueryService.addResponse(expectedResponse);

    String parent = "parent-995424086";
    SampleQuery sampleQuery = SampleQuery.newBuilder().build();
    String sampleQueryId = "sampleQueryId1739022073";

    SampleQuery actualResponse = client.createSampleQuery(parent, sampleQuery, sampleQueryId);
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockSampleQueryService.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    CreateSampleQueryRequest actualRequest = ((CreateSampleQueryRequest) actualRequests.get(0));

    Assert.assertEquals(parent, actualRequest.getParent());
    Assert.assertEquals(sampleQuery, actualRequest.getSampleQuery());
    Assert.assertEquals(sampleQueryId, actualRequest.getSampleQueryId());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void createSampleQueryExceptionTest2() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockSampleQueryService.addException(exception);

    try {
      String parent = "parent-995424086";
      SampleQuery sampleQuery = SampleQuery.newBuilder().build();
      String sampleQueryId = "sampleQueryId1739022073";
      client.createSampleQuery(parent, sampleQuery, sampleQueryId);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void updateSampleQueryTest() throws Exception {
    SampleQuery expectedResponse =
        SampleQuery.newBuilder()
            .setName(
                SampleQueryName.of(
                        "[PROJECT]", "[LOCATION]", "[SAMPLE_QUERY_SET]", "[SAMPLE_QUERY]")
                    .toString())
            .setCreateTime(Timestamp.newBuilder().build())
            .build();
    mockSampleQueryService.addResponse(expectedResponse);

    SampleQuery sampleQuery = SampleQuery.newBuilder().build();
    FieldMask updateMask = FieldMask.newBuilder().build();

    SampleQuery actualResponse = client.updateSampleQuery(sampleQuery, updateMask);
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockSampleQueryService.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    UpdateSampleQueryRequest actualRequest = ((UpdateSampleQueryRequest) actualRequests.get(0));

    Assert.assertEquals(sampleQuery, actualRequest.getSampleQuery());
    Assert.assertEquals(updateMask, actualRequest.getUpdateMask());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void updateSampleQueryExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockSampleQueryService.addException(exception);

    try {
      SampleQuery sampleQuery = SampleQuery.newBuilder().build();
      FieldMask updateMask = FieldMask.newBuilder().build();
      client.updateSampleQuery(sampleQuery, updateMask);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void deleteSampleQueryTest() throws Exception {
    Empty expectedResponse = Empty.newBuilder().build();
    mockSampleQueryService.addResponse(expectedResponse);

    SampleQueryName name =
        SampleQueryName.of("[PROJECT]", "[LOCATION]", "[SAMPLE_QUERY_SET]", "[SAMPLE_QUERY]");

    client.deleteSampleQuery(name);

    List<AbstractMessage> actualRequests = mockSampleQueryService.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    DeleteSampleQueryRequest actualRequest = ((DeleteSampleQueryRequest) actualRequests.get(0));

    Assert.assertEquals(name.toString(), actualRequest.getName());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void deleteSampleQueryExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockSampleQueryService.addException(exception);

    try {
      SampleQueryName name =
          SampleQueryName.of("[PROJECT]", "[LOCATION]", "[SAMPLE_QUERY_SET]", "[SAMPLE_QUERY]");
      client.deleteSampleQuery(name);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void deleteSampleQueryTest2() throws Exception {
    Empty expectedResponse = Empty.newBuilder().build();
    mockSampleQueryService.addResponse(expectedResponse);

    String name = "name3373707";

    client.deleteSampleQuery(name);

    List<AbstractMessage> actualRequests = mockSampleQueryService.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    DeleteSampleQueryRequest actualRequest = ((DeleteSampleQueryRequest) actualRequests.get(0));

    Assert.assertEquals(name, actualRequest.getName());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void deleteSampleQueryExceptionTest2() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockSampleQueryService.addException(exception);

    try {
      String name = "name3373707";
      client.deleteSampleQuery(name);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void importSampleQueriesTest() throws Exception {
    ImportSampleQueriesResponse expectedResponse =
        ImportSampleQueriesResponse.newBuilder()
            .addAllErrorSamples(new ArrayList<Status>())
            .setErrorConfig(ImportErrorConfig.newBuilder().build())
            .build();
    Operation resultOperation =
        Operation.newBuilder()
            .setName("importSampleQueriesTest")
            .setDone(true)
            .setResponse(Any.pack(expectedResponse))
            .build();
    mockSampleQueryService.addResponse(resultOperation);

    ImportSampleQueriesRequest request =
        ImportSampleQueriesRequest.newBuilder()
            .setParent(
                SampleQuerySetName.of("[PROJECT]", "[LOCATION]", "[SAMPLE_QUERY_SET]").toString())
            .setErrorConfig(ImportErrorConfig.newBuilder().build())
            .build();

    ImportSampleQueriesResponse actualResponse = client.importSampleQueriesAsync(request).get();
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockSampleQueryService.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    ImportSampleQueriesRequest actualRequest = ((ImportSampleQueriesRequest) actualRequests.get(0));

    Assert.assertEquals(request.getInlineSource(), actualRequest.getInlineSource());
    Assert.assertEquals(request.getGcsSource(), actualRequest.getGcsSource());
    Assert.assertEquals(request.getBigquerySource(), actualRequest.getBigquerySource());
    Assert.assertEquals(request.getParent(), actualRequest.getParent());
    Assert.assertEquals(request.getErrorConfig(), actualRequest.getErrorConfig());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void importSampleQueriesExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockSampleQueryService.addException(exception);

    try {
      ImportSampleQueriesRequest request =
          ImportSampleQueriesRequest.newBuilder()
              .setParent(
                  SampleQuerySetName.of("[PROJECT]", "[LOCATION]", "[SAMPLE_QUERY_SET]").toString())
              .setErrorConfig(ImportErrorConfig.newBuilder().build())
              .build();
      client.importSampleQueriesAsync(request).get();
      Assert.fail("No exception raised");
    } catch (ExecutionException e) {
      Assert.assertEquals(InvalidArgumentException.class, e.getCause().getClass());
      InvalidArgumentException apiException = ((InvalidArgumentException) e.getCause());
      Assert.assertEquals(StatusCode.Code.INVALID_ARGUMENT, apiException.getStatusCode().getCode());
    }
  }
}
