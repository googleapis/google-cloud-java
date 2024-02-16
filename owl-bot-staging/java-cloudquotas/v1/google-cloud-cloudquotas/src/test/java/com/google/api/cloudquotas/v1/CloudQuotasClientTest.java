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

package com.google.api.cloudquotas.v1;

import static com.google.api.cloudquotas.v1.CloudQuotasClient.ListQuotaInfosPagedResponse;
import static com.google.api.cloudquotas.v1.CloudQuotasClient.ListQuotaPreferencesPagedResponse;

import com.google.api.gax.core.NoCredentialsProvider;
import com.google.api.gax.grpc.GaxGrpcProperties;
import com.google.api.gax.grpc.testing.LocalChannelProvider;
import com.google.api.gax.grpc.testing.MockGrpcService;
import com.google.api.gax.grpc.testing.MockServiceHelper;
import com.google.api.gax.rpc.ApiClientHeaderProvider;
import com.google.api.gax.rpc.InvalidArgumentException;
import com.google.common.collect.Lists;
import com.google.protobuf.AbstractMessage;
import com.google.protobuf.FieldMask;
import com.google.protobuf.Timestamp;
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
public class CloudQuotasClientTest {
  private static MockCloudQuotas mockCloudQuotas;
  private static MockServiceHelper mockServiceHelper;
  private LocalChannelProvider channelProvider;
  private CloudQuotasClient client;

  @BeforeClass
  public static void startStaticServer() {
    mockCloudQuotas = new MockCloudQuotas();
    mockServiceHelper =
        new MockServiceHelper(
            UUID.randomUUID().toString(), Arrays.<MockGrpcService>asList(mockCloudQuotas));
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
    CloudQuotasSettings settings =
        CloudQuotasSettings.newBuilder()
            .setTransportChannelProvider(channelProvider)
            .setCredentialsProvider(NoCredentialsProvider.create())
            .build();
    client = CloudQuotasClient.create(settings);
  }

  @After
  public void tearDown() throws Exception {
    client.close();
  }

  @Test
  public void listQuotaInfosTest() throws Exception {
    QuotaInfo responsesElement = QuotaInfo.newBuilder().build();
    ListQuotaInfosResponse expectedResponse =
        ListQuotaInfosResponse.newBuilder()
            .setNextPageToken("")
            .addAllQuotaInfos(Arrays.asList(responsesElement))
            .build();
    mockCloudQuotas.addResponse(expectedResponse);

    ServiceName parent =
        ServiceName.ofProjectLocationServiceName("[PROJECT]", "[LOCATION]", "[SERVICE]");

    ListQuotaInfosPagedResponse pagedListResponse = client.listQuotaInfos(parent);

    List<QuotaInfo> resources = Lists.newArrayList(pagedListResponse.iterateAll());

    Assert.assertEquals(1, resources.size());
    Assert.assertEquals(expectedResponse.getQuotaInfosList().get(0), resources.get(0));

    List<AbstractMessage> actualRequests = mockCloudQuotas.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    ListQuotaInfosRequest actualRequest = ((ListQuotaInfosRequest) actualRequests.get(0));

    Assert.assertEquals(parent.toString(), actualRequest.getParent());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void listQuotaInfosExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockCloudQuotas.addException(exception);

    try {
      ServiceName parent =
          ServiceName.ofProjectLocationServiceName("[PROJECT]", "[LOCATION]", "[SERVICE]");
      client.listQuotaInfos(parent);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void listQuotaInfosTest2() throws Exception {
    QuotaInfo responsesElement = QuotaInfo.newBuilder().build();
    ListQuotaInfosResponse expectedResponse =
        ListQuotaInfosResponse.newBuilder()
            .setNextPageToken("")
            .addAllQuotaInfos(Arrays.asList(responsesElement))
            .build();
    mockCloudQuotas.addResponse(expectedResponse);

    String parent = "parent-995424086";

    ListQuotaInfosPagedResponse pagedListResponse = client.listQuotaInfos(parent);

    List<QuotaInfo> resources = Lists.newArrayList(pagedListResponse.iterateAll());

    Assert.assertEquals(1, resources.size());
    Assert.assertEquals(expectedResponse.getQuotaInfosList().get(0), resources.get(0));

    List<AbstractMessage> actualRequests = mockCloudQuotas.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    ListQuotaInfosRequest actualRequest = ((ListQuotaInfosRequest) actualRequests.get(0));

    Assert.assertEquals(parent, actualRequest.getParent());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void listQuotaInfosExceptionTest2() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockCloudQuotas.addException(exception);

    try {
      String parent = "parent-995424086";
      client.listQuotaInfos(parent);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void getQuotaInfoTest() throws Exception {
    QuotaInfo expectedResponse =
        QuotaInfo.newBuilder()
            .setName(
                QuotaInfoName.ofProjectLocationServiceQuotaInfoName(
                        "[PROJECT]", "[LOCATION]", "[SERVICE]", "[QUOTA_INFO]")
                    .toString())
            .setQuotaId("quotaId664373683")
            .setMetric("metric-1077545552")
            .setService("service1984153269")
            .setIsPrecise(true)
            .setRefreshInterval("refreshInterval1919275200")
            .addAllDimensions(new ArrayList<String>())
            .setMetricDisplayName("metricDisplayName974527133")
            .setQuotaDisplayName("quotaDisplayName1494811861")
            .setMetricUnit("metricUnit-610538668")
            .setQuotaIncreaseEligibility(QuotaIncreaseEligibility.newBuilder().build())
            .setIsFixed(true)
            .addAllDimensionsInfos(new ArrayList<DimensionsInfo>())
            .setIsConcurrent(true)
            .setServiceRequestQuotaUri("serviceRequestQuotaUri1402291214")
            .build();
    mockCloudQuotas.addResponse(expectedResponse);

    QuotaInfoName name =
        QuotaInfoName.ofProjectLocationServiceQuotaInfoName(
            "[PROJECT]", "[LOCATION]", "[SERVICE]", "[QUOTA_INFO]");

    QuotaInfo actualResponse = client.getQuotaInfo(name);
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockCloudQuotas.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    GetQuotaInfoRequest actualRequest = ((GetQuotaInfoRequest) actualRequests.get(0));

    Assert.assertEquals(name.toString(), actualRequest.getName());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void getQuotaInfoExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockCloudQuotas.addException(exception);

    try {
      QuotaInfoName name =
          QuotaInfoName.ofProjectLocationServiceQuotaInfoName(
              "[PROJECT]", "[LOCATION]", "[SERVICE]", "[QUOTA_INFO]");
      client.getQuotaInfo(name);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void getQuotaInfoTest2() throws Exception {
    QuotaInfo expectedResponse =
        QuotaInfo.newBuilder()
            .setName(
                QuotaInfoName.ofProjectLocationServiceQuotaInfoName(
                        "[PROJECT]", "[LOCATION]", "[SERVICE]", "[QUOTA_INFO]")
                    .toString())
            .setQuotaId("quotaId664373683")
            .setMetric("metric-1077545552")
            .setService("service1984153269")
            .setIsPrecise(true)
            .setRefreshInterval("refreshInterval1919275200")
            .addAllDimensions(new ArrayList<String>())
            .setMetricDisplayName("metricDisplayName974527133")
            .setQuotaDisplayName("quotaDisplayName1494811861")
            .setMetricUnit("metricUnit-610538668")
            .setQuotaIncreaseEligibility(QuotaIncreaseEligibility.newBuilder().build())
            .setIsFixed(true)
            .addAllDimensionsInfos(new ArrayList<DimensionsInfo>())
            .setIsConcurrent(true)
            .setServiceRequestQuotaUri("serviceRequestQuotaUri1402291214")
            .build();
    mockCloudQuotas.addResponse(expectedResponse);

    String name = "name3373707";

    QuotaInfo actualResponse = client.getQuotaInfo(name);
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockCloudQuotas.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    GetQuotaInfoRequest actualRequest = ((GetQuotaInfoRequest) actualRequests.get(0));

    Assert.assertEquals(name, actualRequest.getName());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void getQuotaInfoExceptionTest2() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockCloudQuotas.addException(exception);

    try {
      String name = "name3373707";
      client.getQuotaInfo(name);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void listQuotaPreferencesTest() throws Exception {
    QuotaPreference responsesElement = QuotaPreference.newBuilder().build();
    ListQuotaPreferencesResponse expectedResponse =
        ListQuotaPreferencesResponse.newBuilder()
            .setNextPageToken("")
            .addAllQuotaPreferences(Arrays.asList(responsesElement))
            .build();
    mockCloudQuotas.addResponse(expectedResponse);

    LocationName parent = LocationName.ofProjectLocationName("[PROJECT]", "[LOCATION]");

    ListQuotaPreferencesPagedResponse pagedListResponse = client.listQuotaPreferences(parent);

    List<QuotaPreference> resources = Lists.newArrayList(pagedListResponse.iterateAll());

    Assert.assertEquals(1, resources.size());
    Assert.assertEquals(expectedResponse.getQuotaPreferencesList().get(0), resources.get(0));

    List<AbstractMessage> actualRequests = mockCloudQuotas.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    ListQuotaPreferencesRequest actualRequest =
        ((ListQuotaPreferencesRequest) actualRequests.get(0));

    Assert.assertEquals(parent.toString(), actualRequest.getParent());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void listQuotaPreferencesExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockCloudQuotas.addException(exception);

    try {
      LocationName parent = LocationName.ofProjectLocationName("[PROJECT]", "[LOCATION]");
      client.listQuotaPreferences(parent);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void listQuotaPreferencesTest2() throws Exception {
    QuotaPreference responsesElement = QuotaPreference.newBuilder().build();
    ListQuotaPreferencesResponse expectedResponse =
        ListQuotaPreferencesResponse.newBuilder()
            .setNextPageToken("")
            .addAllQuotaPreferences(Arrays.asList(responsesElement))
            .build();
    mockCloudQuotas.addResponse(expectedResponse);

    String parent = "parent-995424086";

    ListQuotaPreferencesPagedResponse pagedListResponse = client.listQuotaPreferences(parent);

    List<QuotaPreference> resources = Lists.newArrayList(pagedListResponse.iterateAll());

    Assert.assertEquals(1, resources.size());
    Assert.assertEquals(expectedResponse.getQuotaPreferencesList().get(0), resources.get(0));

    List<AbstractMessage> actualRequests = mockCloudQuotas.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    ListQuotaPreferencesRequest actualRequest =
        ((ListQuotaPreferencesRequest) actualRequests.get(0));

    Assert.assertEquals(parent, actualRequest.getParent());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void listQuotaPreferencesExceptionTest2() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockCloudQuotas.addException(exception);

    try {
      String parent = "parent-995424086";
      client.listQuotaPreferences(parent);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void getQuotaPreferenceTest() throws Exception {
    QuotaPreference expectedResponse =
        QuotaPreference.newBuilder()
            .setName(
                QuotaPreferenceName.ofProjectLocationQuotaPreferenceName(
                        "[PROJECT]", "[LOCATION]", "[QUOTA_PREFERENCE]")
                    .toString())
            .putAllDimensions(new HashMap<String, String>())
            .setQuotaConfig(QuotaConfig.newBuilder().build())
            .setEtag("etag3123477")
            .setCreateTime(Timestamp.newBuilder().build())
            .setUpdateTime(Timestamp.newBuilder().build())
            .setService("service1984153269")
            .setQuotaId("quotaId664373683")
            .setReconciling(true)
            .setJustification("justification1864993522")
            .setContactEmail("contactEmail1253690204")
            .build();
    mockCloudQuotas.addResponse(expectedResponse);

    QuotaPreferenceName name =
        QuotaPreferenceName.ofProjectLocationQuotaPreferenceName(
            "[PROJECT]", "[LOCATION]", "[QUOTA_PREFERENCE]");

    QuotaPreference actualResponse = client.getQuotaPreference(name);
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockCloudQuotas.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    GetQuotaPreferenceRequest actualRequest = ((GetQuotaPreferenceRequest) actualRequests.get(0));

    Assert.assertEquals(name.toString(), actualRequest.getName());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void getQuotaPreferenceExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockCloudQuotas.addException(exception);

    try {
      QuotaPreferenceName name =
          QuotaPreferenceName.ofProjectLocationQuotaPreferenceName(
              "[PROJECT]", "[LOCATION]", "[QUOTA_PREFERENCE]");
      client.getQuotaPreference(name);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void getQuotaPreferenceTest2() throws Exception {
    QuotaPreference expectedResponse =
        QuotaPreference.newBuilder()
            .setName(
                QuotaPreferenceName.ofProjectLocationQuotaPreferenceName(
                        "[PROJECT]", "[LOCATION]", "[QUOTA_PREFERENCE]")
                    .toString())
            .putAllDimensions(new HashMap<String, String>())
            .setQuotaConfig(QuotaConfig.newBuilder().build())
            .setEtag("etag3123477")
            .setCreateTime(Timestamp.newBuilder().build())
            .setUpdateTime(Timestamp.newBuilder().build())
            .setService("service1984153269")
            .setQuotaId("quotaId664373683")
            .setReconciling(true)
            .setJustification("justification1864993522")
            .setContactEmail("contactEmail1253690204")
            .build();
    mockCloudQuotas.addResponse(expectedResponse);

    String name = "name3373707";

    QuotaPreference actualResponse = client.getQuotaPreference(name);
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockCloudQuotas.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    GetQuotaPreferenceRequest actualRequest = ((GetQuotaPreferenceRequest) actualRequests.get(0));

    Assert.assertEquals(name, actualRequest.getName());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void getQuotaPreferenceExceptionTest2() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockCloudQuotas.addException(exception);

    try {
      String name = "name3373707";
      client.getQuotaPreference(name);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void createQuotaPreferenceTest() throws Exception {
    QuotaPreference expectedResponse =
        QuotaPreference.newBuilder()
            .setName(
                QuotaPreferenceName.ofProjectLocationQuotaPreferenceName(
                        "[PROJECT]", "[LOCATION]", "[QUOTA_PREFERENCE]")
                    .toString())
            .putAllDimensions(new HashMap<String, String>())
            .setQuotaConfig(QuotaConfig.newBuilder().build())
            .setEtag("etag3123477")
            .setCreateTime(Timestamp.newBuilder().build())
            .setUpdateTime(Timestamp.newBuilder().build())
            .setService("service1984153269")
            .setQuotaId("quotaId664373683")
            .setReconciling(true)
            .setJustification("justification1864993522")
            .setContactEmail("contactEmail1253690204")
            .build();
    mockCloudQuotas.addResponse(expectedResponse);

    LocationName parent = LocationName.ofProjectLocationName("[PROJECT]", "[LOCATION]");
    QuotaPreference quotaPreference = QuotaPreference.newBuilder().build();

    QuotaPreference actualResponse = client.createQuotaPreference(parent, quotaPreference);
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockCloudQuotas.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    CreateQuotaPreferenceRequest actualRequest =
        ((CreateQuotaPreferenceRequest) actualRequests.get(0));

    Assert.assertEquals(parent.toString(), actualRequest.getParent());
    Assert.assertEquals(quotaPreference, actualRequest.getQuotaPreference());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void createQuotaPreferenceExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockCloudQuotas.addException(exception);

    try {
      LocationName parent = LocationName.ofProjectLocationName("[PROJECT]", "[LOCATION]");
      QuotaPreference quotaPreference = QuotaPreference.newBuilder().build();
      client.createQuotaPreference(parent, quotaPreference);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void createQuotaPreferenceTest2() throws Exception {
    QuotaPreference expectedResponse =
        QuotaPreference.newBuilder()
            .setName(
                QuotaPreferenceName.ofProjectLocationQuotaPreferenceName(
                        "[PROJECT]", "[LOCATION]", "[QUOTA_PREFERENCE]")
                    .toString())
            .putAllDimensions(new HashMap<String, String>())
            .setQuotaConfig(QuotaConfig.newBuilder().build())
            .setEtag("etag3123477")
            .setCreateTime(Timestamp.newBuilder().build())
            .setUpdateTime(Timestamp.newBuilder().build())
            .setService("service1984153269")
            .setQuotaId("quotaId664373683")
            .setReconciling(true)
            .setJustification("justification1864993522")
            .setContactEmail("contactEmail1253690204")
            .build();
    mockCloudQuotas.addResponse(expectedResponse);

    String parent = "parent-995424086";
    QuotaPreference quotaPreference = QuotaPreference.newBuilder().build();

    QuotaPreference actualResponse = client.createQuotaPreference(parent, quotaPreference);
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockCloudQuotas.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    CreateQuotaPreferenceRequest actualRequest =
        ((CreateQuotaPreferenceRequest) actualRequests.get(0));

    Assert.assertEquals(parent, actualRequest.getParent());
    Assert.assertEquals(quotaPreference, actualRequest.getQuotaPreference());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void createQuotaPreferenceExceptionTest2() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockCloudQuotas.addException(exception);

    try {
      String parent = "parent-995424086";
      QuotaPreference quotaPreference = QuotaPreference.newBuilder().build();
      client.createQuotaPreference(parent, quotaPreference);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void createQuotaPreferenceTest3() throws Exception {
    QuotaPreference expectedResponse =
        QuotaPreference.newBuilder()
            .setName(
                QuotaPreferenceName.ofProjectLocationQuotaPreferenceName(
                        "[PROJECT]", "[LOCATION]", "[QUOTA_PREFERENCE]")
                    .toString())
            .putAllDimensions(new HashMap<String, String>())
            .setQuotaConfig(QuotaConfig.newBuilder().build())
            .setEtag("etag3123477")
            .setCreateTime(Timestamp.newBuilder().build())
            .setUpdateTime(Timestamp.newBuilder().build())
            .setService("service1984153269")
            .setQuotaId("quotaId664373683")
            .setReconciling(true)
            .setJustification("justification1864993522")
            .setContactEmail("contactEmail1253690204")
            .build();
    mockCloudQuotas.addResponse(expectedResponse);

    LocationName parent = LocationName.ofProjectLocationName("[PROJECT]", "[LOCATION]");
    QuotaPreference quotaPreference = QuotaPreference.newBuilder().build();
    String quotaPreferenceId = "quotaPreferenceId-948332050";

    QuotaPreference actualResponse =
        client.createQuotaPreference(parent, quotaPreference, quotaPreferenceId);
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockCloudQuotas.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    CreateQuotaPreferenceRequest actualRequest =
        ((CreateQuotaPreferenceRequest) actualRequests.get(0));

    Assert.assertEquals(parent.toString(), actualRequest.getParent());
    Assert.assertEquals(quotaPreference, actualRequest.getQuotaPreference());
    Assert.assertEquals(quotaPreferenceId, actualRequest.getQuotaPreferenceId());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void createQuotaPreferenceExceptionTest3() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockCloudQuotas.addException(exception);

    try {
      LocationName parent = LocationName.ofProjectLocationName("[PROJECT]", "[LOCATION]");
      QuotaPreference quotaPreference = QuotaPreference.newBuilder().build();
      String quotaPreferenceId = "quotaPreferenceId-948332050";
      client.createQuotaPreference(parent, quotaPreference, quotaPreferenceId);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void createQuotaPreferenceTest4() throws Exception {
    QuotaPreference expectedResponse =
        QuotaPreference.newBuilder()
            .setName(
                QuotaPreferenceName.ofProjectLocationQuotaPreferenceName(
                        "[PROJECT]", "[LOCATION]", "[QUOTA_PREFERENCE]")
                    .toString())
            .putAllDimensions(new HashMap<String, String>())
            .setQuotaConfig(QuotaConfig.newBuilder().build())
            .setEtag("etag3123477")
            .setCreateTime(Timestamp.newBuilder().build())
            .setUpdateTime(Timestamp.newBuilder().build())
            .setService("service1984153269")
            .setQuotaId("quotaId664373683")
            .setReconciling(true)
            .setJustification("justification1864993522")
            .setContactEmail("contactEmail1253690204")
            .build();
    mockCloudQuotas.addResponse(expectedResponse);

    String parent = "parent-995424086";
    QuotaPreference quotaPreference = QuotaPreference.newBuilder().build();
    String quotaPreferenceId = "quotaPreferenceId-948332050";

    QuotaPreference actualResponse =
        client.createQuotaPreference(parent, quotaPreference, quotaPreferenceId);
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockCloudQuotas.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    CreateQuotaPreferenceRequest actualRequest =
        ((CreateQuotaPreferenceRequest) actualRequests.get(0));

    Assert.assertEquals(parent, actualRequest.getParent());
    Assert.assertEquals(quotaPreference, actualRequest.getQuotaPreference());
    Assert.assertEquals(quotaPreferenceId, actualRequest.getQuotaPreferenceId());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void createQuotaPreferenceExceptionTest4() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockCloudQuotas.addException(exception);

    try {
      String parent = "parent-995424086";
      QuotaPreference quotaPreference = QuotaPreference.newBuilder().build();
      String quotaPreferenceId = "quotaPreferenceId-948332050";
      client.createQuotaPreference(parent, quotaPreference, quotaPreferenceId);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void updateQuotaPreferenceTest() throws Exception {
    QuotaPreference expectedResponse =
        QuotaPreference.newBuilder()
            .setName(
                QuotaPreferenceName.ofProjectLocationQuotaPreferenceName(
                        "[PROJECT]", "[LOCATION]", "[QUOTA_PREFERENCE]")
                    .toString())
            .putAllDimensions(new HashMap<String, String>())
            .setQuotaConfig(QuotaConfig.newBuilder().build())
            .setEtag("etag3123477")
            .setCreateTime(Timestamp.newBuilder().build())
            .setUpdateTime(Timestamp.newBuilder().build())
            .setService("service1984153269")
            .setQuotaId("quotaId664373683")
            .setReconciling(true)
            .setJustification("justification1864993522")
            .setContactEmail("contactEmail1253690204")
            .build();
    mockCloudQuotas.addResponse(expectedResponse);

    QuotaPreference quotaPreference = QuotaPreference.newBuilder().build();
    FieldMask updateMask = FieldMask.newBuilder().build();

    QuotaPreference actualResponse = client.updateQuotaPreference(quotaPreference, updateMask);
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockCloudQuotas.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    UpdateQuotaPreferenceRequest actualRequest =
        ((UpdateQuotaPreferenceRequest) actualRequests.get(0));

    Assert.assertEquals(quotaPreference, actualRequest.getQuotaPreference());
    Assert.assertEquals(updateMask, actualRequest.getUpdateMask());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void updateQuotaPreferenceExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockCloudQuotas.addException(exception);

    try {
      QuotaPreference quotaPreference = QuotaPreference.newBuilder().build();
      FieldMask updateMask = FieldMask.newBuilder().build();
      client.updateQuotaPreference(quotaPreference, updateMask);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }
}
