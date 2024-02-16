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

package com.google.cloud.logging.v2;

import static com.google.cloud.logging.v2.MetricsClient.ListLogMetricsPagedResponse;

import com.google.api.Distribution;
import com.google.api.MetricDescriptor;
import com.google.api.gax.core.NoCredentialsProvider;
import com.google.api.gax.grpc.GaxGrpcProperties;
import com.google.api.gax.grpc.testing.LocalChannelProvider;
import com.google.api.gax.grpc.testing.MockGrpcService;
import com.google.api.gax.grpc.testing.MockServiceHelper;
import com.google.api.gax.rpc.ApiClientHeaderProvider;
import com.google.api.gax.rpc.InvalidArgumentException;
import com.google.common.collect.Lists;
import com.google.logging.v2.CreateLogMetricRequest;
import com.google.logging.v2.DeleteLogMetricRequest;
import com.google.logging.v2.GetLogMetricRequest;
import com.google.logging.v2.ListLogMetricsRequest;
import com.google.logging.v2.ListLogMetricsResponse;
import com.google.logging.v2.LogMetric;
import com.google.logging.v2.LogMetricName;
import com.google.logging.v2.ProjectName;
import com.google.logging.v2.UpdateLogMetricRequest;
import com.google.protobuf.AbstractMessage;
import com.google.protobuf.Empty;
import com.google.protobuf.Timestamp;
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
public class MetricsClientTest {
  private static MockMetricsServiceV2 mockMetricsServiceV2;
  private static MockServiceHelper mockServiceHelper;
  private LocalChannelProvider channelProvider;
  private MetricsClient client;

  @BeforeClass
  public static void startStaticServer() {
    mockMetricsServiceV2 = new MockMetricsServiceV2();
    mockServiceHelper =
        new MockServiceHelper(
            UUID.randomUUID().toString(), Arrays.<MockGrpcService>asList(mockMetricsServiceV2));
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
    MetricsSettings settings =
        MetricsSettings.newBuilder()
            .setTransportChannelProvider(channelProvider)
            .setCredentialsProvider(NoCredentialsProvider.create())
            .build();
    client = MetricsClient.create(settings);
  }

  @After
  public void tearDown() throws Exception {
    client.close();
  }

  @Test
  public void listLogMetricsTest() throws Exception {
    LogMetric responsesElement = LogMetric.newBuilder().build();
    ListLogMetricsResponse expectedResponse =
        ListLogMetricsResponse.newBuilder()
            .setNextPageToken("")
            .addAllMetrics(Arrays.asList(responsesElement))
            .build();
    mockMetricsServiceV2.addResponse(expectedResponse);

    ProjectName parent = ProjectName.of("[PROJECT]");

    ListLogMetricsPagedResponse pagedListResponse = client.listLogMetrics(parent);

    List<LogMetric> resources = Lists.newArrayList(pagedListResponse.iterateAll());

    Assert.assertEquals(1, resources.size());
    Assert.assertEquals(expectedResponse.getMetricsList().get(0), resources.get(0));

    List<AbstractMessage> actualRequests = mockMetricsServiceV2.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    ListLogMetricsRequest actualRequest = ((ListLogMetricsRequest) actualRequests.get(0));

    Assert.assertEquals(parent.toString(), actualRequest.getParent());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void listLogMetricsExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockMetricsServiceV2.addException(exception);

    try {
      ProjectName parent = ProjectName.of("[PROJECT]");
      client.listLogMetrics(parent);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void listLogMetricsTest2() throws Exception {
    LogMetric responsesElement = LogMetric.newBuilder().build();
    ListLogMetricsResponse expectedResponse =
        ListLogMetricsResponse.newBuilder()
            .setNextPageToken("")
            .addAllMetrics(Arrays.asList(responsesElement))
            .build();
    mockMetricsServiceV2.addResponse(expectedResponse);

    String parent = "parent-995424086";

    ListLogMetricsPagedResponse pagedListResponse = client.listLogMetrics(parent);

    List<LogMetric> resources = Lists.newArrayList(pagedListResponse.iterateAll());

    Assert.assertEquals(1, resources.size());
    Assert.assertEquals(expectedResponse.getMetricsList().get(0), resources.get(0));

    List<AbstractMessage> actualRequests = mockMetricsServiceV2.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    ListLogMetricsRequest actualRequest = ((ListLogMetricsRequest) actualRequests.get(0));

    Assert.assertEquals(parent, actualRequest.getParent());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void listLogMetricsExceptionTest2() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockMetricsServiceV2.addException(exception);

    try {
      String parent = "parent-995424086";
      client.listLogMetrics(parent);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void getLogMetricTest() throws Exception {
    LogMetric expectedResponse =
        LogMetric.newBuilder()
            .setName(LogMetricName.of("[PROJECT]", "[METRIC]").toString())
            .setDescription("description-1724546052")
            .setFilter("filter-1274492040")
            .setBucketName("bucketName1117008789")
            .setDisabled(true)
            .setMetricDescriptor(MetricDescriptor.newBuilder().build())
            .setValueExtractor("valueExtractor-1867420749")
            .putAllLabelExtractors(new HashMap<String, String>())
            .setBucketOptions(Distribution.BucketOptions.newBuilder().build())
            .setCreateTime(Timestamp.newBuilder().build())
            .setUpdateTime(Timestamp.newBuilder().build())
            .build();
    mockMetricsServiceV2.addResponse(expectedResponse);

    LogMetricName metricName = LogMetricName.of("[PROJECT]", "[METRIC]");

    LogMetric actualResponse = client.getLogMetric(metricName);
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockMetricsServiceV2.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    GetLogMetricRequest actualRequest = ((GetLogMetricRequest) actualRequests.get(0));

    Assert.assertEquals(metricName.toString(), actualRequest.getMetricName());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void getLogMetricExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockMetricsServiceV2.addException(exception);

    try {
      LogMetricName metricName = LogMetricName.of("[PROJECT]", "[METRIC]");
      client.getLogMetric(metricName);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void getLogMetricTest2() throws Exception {
    LogMetric expectedResponse =
        LogMetric.newBuilder()
            .setName(LogMetricName.of("[PROJECT]", "[METRIC]").toString())
            .setDescription("description-1724546052")
            .setFilter("filter-1274492040")
            .setBucketName("bucketName1117008789")
            .setDisabled(true)
            .setMetricDescriptor(MetricDescriptor.newBuilder().build())
            .setValueExtractor("valueExtractor-1867420749")
            .putAllLabelExtractors(new HashMap<String, String>())
            .setBucketOptions(Distribution.BucketOptions.newBuilder().build())
            .setCreateTime(Timestamp.newBuilder().build())
            .setUpdateTime(Timestamp.newBuilder().build())
            .build();
    mockMetricsServiceV2.addResponse(expectedResponse);

    String metricName = "metricName-610759589";

    LogMetric actualResponse = client.getLogMetric(metricName);
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockMetricsServiceV2.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    GetLogMetricRequest actualRequest = ((GetLogMetricRequest) actualRequests.get(0));

    Assert.assertEquals(metricName, actualRequest.getMetricName());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void getLogMetricExceptionTest2() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockMetricsServiceV2.addException(exception);

    try {
      String metricName = "metricName-610759589";
      client.getLogMetric(metricName);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void createLogMetricTest() throws Exception {
    LogMetric expectedResponse =
        LogMetric.newBuilder()
            .setName(LogMetricName.of("[PROJECT]", "[METRIC]").toString())
            .setDescription("description-1724546052")
            .setFilter("filter-1274492040")
            .setBucketName("bucketName1117008789")
            .setDisabled(true)
            .setMetricDescriptor(MetricDescriptor.newBuilder().build())
            .setValueExtractor("valueExtractor-1867420749")
            .putAllLabelExtractors(new HashMap<String, String>())
            .setBucketOptions(Distribution.BucketOptions.newBuilder().build())
            .setCreateTime(Timestamp.newBuilder().build())
            .setUpdateTime(Timestamp.newBuilder().build())
            .build();
    mockMetricsServiceV2.addResponse(expectedResponse);

    ProjectName parent = ProjectName.of("[PROJECT]");
    LogMetric metric = LogMetric.newBuilder().build();

    LogMetric actualResponse = client.createLogMetric(parent, metric);
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockMetricsServiceV2.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    CreateLogMetricRequest actualRequest = ((CreateLogMetricRequest) actualRequests.get(0));

    Assert.assertEquals(parent.toString(), actualRequest.getParent());
    Assert.assertEquals(metric, actualRequest.getMetric());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void createLogMetricExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockMetricsServiceV2.addException(exception);

    try {
      ProjectName parent = ProjectName.of("[PROJECT]");
      LogMetric metric = LogMetric.newBuilder().build();
      client.createLogMetric(parent, metric);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void createLogMetricTest2() throws Exception {
    LogMetric expectedResponse =
        LogMetric.newBuilder()
            .setName(LogMetricName.of("[PROJECT]", "[METRIC]").toString())
            .setDescription("description-1724546052")
            .setFilter("filter-1274492040")
            .setBucketName("bucketName1117008789")
            .setDisabled(true)
            .setMetricDescriptor(MetricDescriptor.newBuilder().build())
            .setValueExtractor("valueExtractor-1867420749")
            .putAllLabelExtractors(new HashMap<String, String>())
            .setBucketOptions(Distribution.BucketOptions.newBuilder().build())
            .setCreateTime(Timestamp.newBuilder().build())
            .setUpdateTime(Timestamp.newBuilder().build())
            .build();
    mockMetricsServiceV2.addResponse(expectedResponse);

    String parent = "parent-995424086";
    LogMetric metric = LogMetric.newBuilder().build();

    LogMetric actualResponse = client.createLogMetric(parent, metric);
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockMetricsServiceV2.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    CreateLogMetricRequest actualRequest = ((CreateLogMetricRequest) actualRequests.get(0));

    Assert.assertEquals(parent, actualRequest.getParent());
    Assert.assertEquals(metric, actualRequest.getMetric());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void createLogMetricExceptionTest2() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockMetricsServiceV2.addException(exception);

    try {
      String parent = "parent-995424086";
      LogMetric metric = LogMetric.newBuilder().build();
      client.createLogMetric(parent, metric);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void updateLogMetricTest() throws Exception {
    LogMetric expectedResponse =
        LogMetric.newBuilder()
            .setName(LogMetricName.of("[PROJECT]", "[METRIC]").toString())
            .setDescription("description-1724546052")
            .setFilter("filter-1274492040")
            .setBucketName("bucketName1117008789")
            .setDisabled(true)
            .setMetricDescriptor(MetricDescriptor.newBuilder().build())
            .setValueExtractor("valueExtractor-1867420749")
            .putAllLabelExtractors(new HashMap<String, String>())
            .setBucketOptions(Distribution.BucketOptions.newBuilder().build())
            .setCreateTime(Timestamp.newBuilder().build())
            .setUpdateTime(Timestamp.newBuilder().build())
            .build();
    mockMetricsServiceV2.addResponse(expectedResponse);

    LogMetricName metricName = LogMetricName.of("[PROJECT]", "[METRIC]");
    LogMetric metric = LogMetric.newBuilder().build();

    LogMetric actualResponse = client.updateLogMetric(metricName, metric);
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockMetricsServiceV2.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    UpdateLogMetricRequest actualRequest = ((UpdateLogMetricRequest) actualRequests.get(0));

    Assert.assertEquals(metricName.toString(), actualRequest.getMetricName());
    Assert.assertEquals(metric, actualRequest.getMetric());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void updateLogMetricExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockMetricsServiceV2.addException(exception);

    try {
      LogMetricName metricName = LogMetricName.of("[PROJECT]", "[METRIC]");
      LogMetric metric = LogMetric.newBuilder().build();
      client.updateLogMetric(metricName, metric);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void updateLogMetricTest2() throws Exception {
    LogMetric expectedResponse =
        LogMetric.newBuilder()
            .setName(LogMetricName.of("[PROJECT]", "[METRIC]").toString())
            .setDescription("description-1724546052")
            .setFilter("filter-1274492040")
            .setBucketName("bucketName1117008789")
            .setDisabled(true)
            .setMetricDescriptor(MetricDescriptor.newBuilder().build())
            .setValueExtractor("valueExtractor-1867420749")
            .putAllLabelExtractors(new HashMap<String, String>())
            .setBucketOptions(Distribution.BucketOptions.newBuilder().build())
            .setCreateTime(Timestamp.newBuilder().build())
            .setUpdateTime(Timestamp.newBuilder().build())
            .build();
    mockMetricsServiceV2.addResponse(expectedResponse);

    String metricName = "metricName-610759589";
    LogMetric metric = LogMetric.newBuilder().build();

    LogMetric actualResponse = client.updateLogMetric(metricName, metric);
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockMetricsServiceV2.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    UpdateLogMetricRequest actualRequest = ((UpdateLogMetricRequest) actualRequests.get(0));

    Assert.assertEquals(metricName, actualRequest.getMetricName());
    Assert.assertEquals(metric, actualRequest.getMetric());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void updateLogMetricExceptionTest2() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockMetricsServiceV2.addException(exception);

    try {
      String metricName = "metricName-610759589";
      LogMetric metric = LogMetric.newBuilder().build();
      client.updateLogMetric(metricName, metric);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void deleteLogMetricTest() throws Exception {
    Empty expectedResponse = Empty.newBuilder().build();
    mockMetricsServiceV2.addResponse(expectedResponse);

    LogMetricName metricName = LogMetricName.of("[PROJECT]", "[METRIC]");

    client.deleteLogMetric(metricName);

    List<AbstractMessage> actualRequests = mockMetricsServiceV2.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    DeleteLogMetricRequest actualRequest = ((DeleteLogMetricRequest) actualRequests.get(0));

    Assert.assertEquals(metricName.toString(), actualRequest.getMetricName());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void deleteLogMetricExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockMetricsServiceV2.addException(exception);

    try {
      LogMetricName metricName = LogMetricName.of("[PROJECT]", "[METRIC]");
      client.deleteLogMetric(metricName);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void deleteLogMetricTest2() throws Exception {
    Empty expectedResponse = Empty.newBuilder().build();
    mockMetricsServiceV2.addResponse(expectedResponse);

    String metricName = "metricName-610759589";

    client.deleteLogMetric(metricName);

    List<AbstractMessage> actualRequests = mockMetricsServiceV2.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    DeleteLogMetricRequest actualRequest = ((DeleteLogMetricRequest) actualRequests.get(0));

    Assert.assertEquals(metricName, actualRequest.getMetricName());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void deleteLogMetricExceptionTest2() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockMetricsServiceV2.addException(exception);

    try {
      String metricName = "metricName-610759589";
      client.deleteLogMetric(metricName);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }
}
