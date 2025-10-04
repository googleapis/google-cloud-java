/*
 * Copyright 2025 Google LLC
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

package com.google.cloud.bigquery.analyticshub.v1;

import static com.google.cloud.bigquery.analyticshub.v1.AnalyticsHubServiceClient.ListDataExchangesPagedResponse;
import static com.google.cloud.bigquery.analyticshub.v1.AnalyticsHubServiceClient.ListListingsPagedResponse;
import static com.google.cloud.bigquery.analyticshub.v1.AnalyticsHubServiceClient.ListOrgDataExchangesPagedResponse;
import static com.google.cloud.bigquery.analyticshub.v1.AnalyticsHubServiceClient.ListQueryTemplatesPagedResponse;
import static com.google.cloud.bigquery.analyticshub.v1.AnalyticsHubServiceClient.ListSharedResourceSubscriptionsPagedResponse;
import static com.google.cloud.bigquery.analyticshub.v1.AnalyticsHubServiceClient.ListSubscriptionsPagedResponse;

import com.google.api.gax.core.NoCredentialsProvider;
import com.google.api.gax.grpc.GaxGrpcProperties;
import com.google.api.gax.grpc.testing.LocalChannelProvider;
import com.google.api.gax.grpc.testing.MockGrpcService;
import com.google.api.gax.grpc.testing.MockServiceHelper;
import com.google.api.gax.rpc.ApiClientHeaderProvider;
import com.google.api.gax.rpc.InvalidArgumentException;
import com.google.api.gax.rpc.StatusCode;
import com.google.api.resourcenames.ResourceName;
import com.google.common.collect.Lists;
import com.google.iam.v1.AuditConfig;
import com.google.iam.v1.Binding;
import com.google.iam.v1.GetIamPolicyRequest;
import com.google.iam.v1.GetPolicyOptions;
import com.google.iam.v1.Policy;
import com.google.iam.v1.SetIamPolicyRequest;
import com.google.iam.v1.TestIamPermissionsRequest;
import com.google.iam.v1.TestIamPermissionsResponse;
import com.google.longrunning.Operation;
import com.google.protobuf.AbstractMessage;
import com.google.protobuf.Any;
import com.google.protobuf.ByteString;
import com.google.protobuf.Empty;
import com.google.protobuf.FieldMask;
import com.google.protobuf.Timestamp;
import io.grpc.StatusRuntimeException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
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
public class AnalyticsHubServiceClientTest {
  private static MockAnalyticsHubService mockAnalyticsHubService;
  private static MockServiceHelper mockServiceHelper;
  private LocalChannelProvider channelProvider;
  private AnalyticsHubServiceClient client;

  @BeforeClass
  public static void startStaticServer() {
    mockAnalyticsHubService = new MockAnalyticsHubService();
    mockServiceHelper =
        new MockServiceHelper(
            UUID.randomUUID().toString(), Arrays.<MockGrpcService>asList(mockAnalyticsHubService));
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
    AnalyticsHubServiceSettings settings =
        AnalyticsHubServiceSettings.newBuilder()
            .setTransportChannelProvider(channelProvider)
            .setCredentialsProvider(NoCredentialsProvider.create())
            .build();
    client = AnalyticsHubServiceClient.create(settings);
  }

  @After
  public void tearDown() throws Exception {
    client.close();
  }

  @Test
  public void listDataExchangesTest() throws Exception {
    DataExchange responsesElement = DataExchange.newBuilder().build();
    ListDataExchangesResponse expectedResponse =
        ListDataExchangesResponse.newBuilder()
            .setNextPageToken("")
            .addAllDataExchanges(Arrays.asList(responsesElement))
            .build();
    mockAnalyticsHubService.addResponse(expectedResponse);

    LocationName parent = LocationName.of("[PROJECT]", "[LOCATION]");

    ListDataExchangesPagedResponse pagedListResponse = client.listDataExchanges(parent);

    List<DataExchange> resources = Lists.newArrayList(pagedListResponse.iterateAll());

    Assert.assertEquals(1, resources.size());
    Assert.assertEquals(expectedResponse.getDataExchangesList().get(0), resources.get(0));

    List<AbstractMessage> actualRequests = mockAnalyticsHubService.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    ListDataExchangesRequest actualRequest = ((ListDataExchangesRequest) actualRequests.get(0));

    Assert.assertEquals(parent.toString(), actualRequest.getParent());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void listDataExchangesExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockAnalyticsHubService.addException(exception);

    try {
      LocationName parent = LocationName.of("[PROJECT]", "[LOCATION]");
      client.listDataExchanges(parent);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void listDataExchangesTest2() throws Exception {
    DataExchange responsesElement = DataExchange.newBuilder().build();
    ListDataExchangesResponse expectedResponse =
        ListDataExchangesResponse.newBuilder()
            .setNextPageToken("")
            .addAllDataExchanges(Arrays.asList(responsesElement))
            .build();
    mockAnalyticsHubService.addResponse(expectedResponse);

    String parent = "parent-995424086";

    ListDataExchangesPagedResponse pagedListResponse = client.listDataExchanges(parent);

    List<DataExchange> resources = Lists.newArrayList(pagedListResponse.iterateAll());

    Assert.assertEquals(1, resources.size());
    Assert.assertEquals(expectedResponse.getDataExchangesList().get(0), resources.get(0));

    List<AbstractMessage> actualRequests = mockAnalyticsHubService.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    ListDataExchangesRequest actualRequest = ((ListDataExchangesRequest) actualRequests.get(0));

    Assert.assertEquals(parent, actualRequest.getParent());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void listDataExchangesExceptionTest2() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockAnalyticsHubService.addException(exception);

    try {
      String parent = "parent-995424086";
      client.listDataExchanges(parent);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void listOrgDataExchangesTest() throws Exception {
    DataExchange responsesElement = DataExchange.newBuilder().build();
    ListOrgDataExchangesResponse expectedResponse =
        ListOrgDataExchangesResponse.newBuilder()
            .setNextPageToken("")
            .addAllDataExchanges(Arrays.asList(responsesElement))
            .build();
    mockAnalyticsHubService.addResponse(expectedResponse);

    String organization = "organization1178922291";

    ListOrgDataExchangesPagedResponse pagedListResponse = client.listOrgDataExchanges(organization);

    List<DataExchange> resources = Lists.newArrayList(pagedListResponse.iterateAll());

    Assert.assertEquals(1, resources.size());
    Assert.assertEquals(expectedResponse.getDataExchangesList().get(0), resources.get(0));

    List<AbstractMessage> actualRequests = mockAnalyticsHubService.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    ListOrgDataExchangesRequest actualRequest =
        ((ListOrgDataExchangesRequest) actualRequests.get(0));

    Assert.assertEquals(organization, actualRequest.getOrganization());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void listOrgDataExchangesExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockAnalyticsHubService.addException(exception);

    try {
      String organization = "organization1178922291";
      client.listOrgDataExchanges(organization);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void getDataExchangeTest() throws Exception {
    DataExchange expectedResponse =
        DataExchange.newBuilder()
            .setName(DataExchangeName.of("[PROJECT]", "[LOCATION]", "[DATA_EXCHANGE]").toString())
            .setDisplayName("displayName1714148973")
            .setDescription("description-1724546052")
            .setPrimaryContact("primaryContact-532068418")
            .setDocumentation("documentation1587405498")
            .setListingCount(-1101038700)
            .setIcon(ByteString.EMPTY)
            .setSharingEnvironmentConfig(SharingEnvironmentConfig.newBuilder().build())
            .setDiscoveryType(DiscoveryType.forNumber(0))
            .setLogLinkedDatasetQueryUserEmail(true)
            .build();
    mockAnalyticsHubService.addResponse(expectedResponse);

    DataExchangeName name = DataExchangeName.of("[PROJECT]", "[LOCATION]", "[DATA_EXCHANGE]");

    DataExchange actualResponse = client.getDataExchange(name);
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockAnalyticsHubService.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    GetDataExchangeRequest actualRequest = ((GetDataExchangeRequest) actualRequests.get(0));

    Assert.assertEquals(name.toString(), actualRequest.getName());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void getDataExchangeExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockAnalyticsHubService.addException(exception);

    try {
      DataExchangeName name = DataExchangeName.of("[PROJECT]", "[LOCATION]", "[DATA_EXCHANGE]");
      client.getDataExchange(name);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void getDataExchangeTest2() throws Exception {
    DataExchange expectedResponse =
        DataExchange.newBuilder()
            .setName(DataExchangeName.of("[PROJECT]", "[LOCATION]", "[DATA_EXCHANGE]").toString())
            .setDisplayName("displayName1714148973")
            .setDescription("description-1724546052")
            .setPrimaryContact("primaryContact-532068418")
            .setDocumentation("documentation1587405498")
            .setListingCount(-1101038700)
            .setIcon(ByteString.EMPTY)
            .setSharingEnvironmentConfig(SharingEnvironmentConfig.newBuilder().build())
            .setDiscoveryType(DiscoveryType.forNumber(0))
            .setLogLinkedDatasetQueryUserEmail(true)
            .build();
    mockAnalyticsHubService.addResponse(expectedResponse);

    String name = "name3373707";

    DataExchange actualResponse = client.getDataExchange(name);
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockAnalyticsHubService.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    GetDataExchangeRequest actualRequest = ((GetDataExchangeRequest) actualRequests.get(0));

    Assert.assertEquals(name, actualRequest.getName());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void getDataExchangeExceptionTest2() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockAnalyticsHubService.addException(exception);

    try {
      String name = "name3373707";
      client.getDataExchange(name);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void createDataExchangeTest() throws Exception {
    DataExchange expectedResponse =
        DataExchange.newBuilder()
            .setName(DataExchangeName.of("[PROJECT]", "[LOCATION]", "[DATA_EXCHANGE]").toString())
            .setDisplayName("displayName1714148973")
            .setDescription("description-1724546052")
            .setPrimaryContact("primaryContact-532068418")
            .setDocumentation("documentation1587405498")
            .setListingCount(-1101038700)
            .setIcon(ByteString.EMPTY)
            .setSharingEnvironmentConfig(SharingEnvironmentConfig.newBuilder().build())
            .setDiscoveryType(DiscoveryType.forNumber(0))
            .setLogLinkedDatasetQueryUserEmail(true)
            .build();
    mockAnalyticsHubService.addResponse(expectedResponse);

    LocationName parent = LocationName.of("[PROJECT]", "[LOCATION]");
    DataExchange dataExchange = DataExchange.newBuilder().build();

    DataExchange actualResponse = client.createDataExchange(parent, dataExchange);
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockAnalyticsHubService.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    CreateDataExchangeRequest actualRequest = ((CreateDataExchangeRequest) actualRequests.get(0));

    Assert.assertEquals(parent.toString(), actualRequest.getParent());
    Assert.assertEquals(dataExchange, actualRequest.getDataExchange());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void createDataExchangeExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockAnalyticsHubService.addException(exception);

    try {
      LocationName parent = LocationName.of("[PROJECT]", "[LOCATION]");
      DataExchange dataExchange = DataExchange.newBuilder().build();
      client.createDataExchange(parent, dataExchange);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void createDataExchangeTest2() throws Exception {
    DataExchange expectedResponse =
        DataExchange.newBuilder()
            .setName(DataExchangeName.of("[PROJECT]", "[LOCATION]", "[DATA_EXCHANGE]").toString())
            .setDisplayName("displayName1714148973")
            .setDescription("description-1724546052")
            .setPrimaryContact("primaryContact-532068418")
            .setDocumentation("documentation1587405498")
            .setListingCount(-1101038700)
            .setIcon(ByteString.EMPTY)
            .setSharingEnvironmentConfig(SharingEnvironmentConfig.newBuilder().build())
            .setDiscoveryType(DiscoveryType.forNumber(0))
            .setLogLinkedDatasetQueryUserEmail(true)
            .build();
    mockAnalyticsHubService.addResponse(expectedResponse);

    String parent = "parent-995424086";
    DataExchange dataExchange = DataExchange.newBuilder().build();

    DataExchange actualResponse = client.createDataExchange(parent, dataExchange);
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockAnalyticsHubService.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    CreateDataExchangeRequest actualRequest = ((CreateDataExchangeRequest) actualRequests.get(0));

    Assert.assertEquals(parent, actualRequest.getParent());
    Assert.assertEquals(dataExchange, actualRequest.getDataExchange());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void createDataExchangeExceptionTest2() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockAnalyticsHubService.addException(exception);

    try {
      String parent = "parent-995424086";
      DataExchange dataExchange = DataExchange.newBuilder().build();
      client.createDataExchange(parent, dataExchange);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void updateDataExchangeTest() throws Exception {
    DataExchange expectedResponse =
        DataExchange.newBuilder()
            .setName(DataExchangeName.of("[PROJECT]", "[LOCATION]", "[DATA_EXCHANGE]").toString())
            .setDisplayName("displayName1714148973")
            .setDescription("description-1724546052")
            .setPrimaryContact("primaryContact-532068418")
            .setDocumentation("documentation1587405498")
            .setListingCount(-1101038700)
            .setIcon(ByteString.EMPTY)
            .setSharingEnvironmentConfig(SharingEnvironmentConfig.newBuilder().build())
            .setDiscoveryType(DiscoveryType.forNumber(0))
            .setLogLinkedDatasetQueryUserEmail(true)
            .build();
    mockAnalyticsHubService.addResponse(expectedResponse);

    DataExchange dataExchange = DataExchange.newBuilder().build();
    FieldMask updateMask = FieldMask.newBuilder().build();

    DataExchange actualResponse = client.updateDataExchange(dataExchange, updateMask);
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockAnalyticsHubService.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    UpdateDataExchangeRequest actualRequest = ((UpdateDataExchangeRequest) actualRequests.get(0));

    Assert.assertEquals(dataExchange, actualRequest.getDataExchange());
    Assert.assertEquals(updateMask, actualRequest.getUpdateMask());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void updateDataExchangeExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockAnalyticsHubService.addException(exception);

    try {
      DataExchange dataExchange = DataExchange.newBuilder().build();
      FieldMask updateMask = FieldMask.newBuilder().build();
      client.updateDataExchange(dataExchange, updateMask);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void deleteDataExchangeTest() throws Exception {
    Empty expectedResponse = Empty.newBuilder().build();
    mockAnalyticsHubService.addResponse(expectedResponse);

    DataExchangeName name = DataExchangeName.of("[PROJECT]", "[LOCATION]", "[DATA_EXCHANGE]");

    client.deleteDataExchange(name);

    List<AbstractMessage> actualRequests = mockAnalyticsHubService.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    DeleteDataExchangeRequest actualRequest = ((DeleteDataExchangeRequest) actualRequests.get(0));

    Assert.assertEquals(name.toString(), actualRequest.getName());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void deleteDataExchangeExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockAnalyticsHubService.addException(exception);

    try {
      DataExchangeName name = DataExchangeName.of("[PROJECT]", "[LOCATION]", "[DATA_EXCHANGE]");
      client.deleteDataExchange(name);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void deleteDataExchangeTest2() throws Exception {
    Empty expectedResponse = Empty.newBuilder().build();
    mockAnalyticsHubService.addResponse(expectedResponse);

    String name = "name3373707";

    client.deleteDataExchange(name);

    List<AbstractMessage> actualRequests = mockAnalyticsHubService.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    DeleteDataExchangeRequest actualRequest = ((DeleteDataExchangeRequest) actualRequests.get(0));

    Assert.assertEquals(name, actualRequest.getName());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void deleteDataExchangeExceptionTest2() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockAnalyticsHubService.addException(exception);

    try {
      String name = "name3373707";
      client.deleteDataExchange(name);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void listListingsTest() throws Exception {
    Listing responsesElement = Listing.newBuilder().build();
    ListListingsResponse expectedResponse =
        ListListingsResponse.newBuilder()
            .setNextPageToken("")
            .addAllListings(Arrays.asList(responsesElement))
            .build();
    mockAnalyticsHubService.addResponse(expectedResponse);

    DataExchangeName parent = DataExchangeName.of("[PROJECT]", "[LOCATION]", "[DATA_EXCHANGE]");

    ListListingsPagedResponse pagedListResponse = client.listListings(parent);

    List<Listing> resources = Lists.newArrayList(pagedListResponse.iterateAll());

    Assert.assertEquals(1, resources.size());
    Assert.assertEquals(expectedResponse.getListingsList().get(0), resources.get(0));

    List<AbstractMessage> actualRequests = mockAnalyticsHubService.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    ListListingsRequest actualRequest = ((ListListingsRequest) actualRequests.get(0));

    Assert.assertEquals(parent.toString(), actualRequest.getParent());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void listListingsExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockAnalyticsHubService.addException(exception);

    try {
      DataExchangeName parent = DataExchangeName.of("[PROJECT]", "[LOCATION]", "[DATA_EXCHANGE]");
      client.listListings(parent);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void listListingsTest2() throws Exception {
    Listing responsesElement = Listing.newBuilder().build();
    ListListingsResponse expectedResponse =
        ListListingsResponse.newBuilder()
            .setNextPageToken("")
            .addAllListings(Arrays.asList(responsesElement))
            .build();
    mockAnalyticsHubService.addResponse(expectedResponse);

    String parent = "parent-995424086";

    ListListingsPagedResponse pagedListResponse = client.listListings(parent);

    List<Listing> resources = Lists.newArrayList(pagedListResponse.iterateAll());

    Assert.assertEquals(1, resources.size());
    Assert.assertEquals(expectedResponse.getListingsList().get(0), resources.get(0));

    List<AbstractMessage> actualRequests = mockAnalyticsHubService.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    ListListingsRequest actualRequest = ((ListListingsRequest) actualRequests.get(0));

    Assert.assertEquals(parent, actualRequest.getParent());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void listListingsExceptionTest2() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockAnalyticsHubService.addException(exception);

    try {
      String parent = "parent-995424086";
      client.listListings(parent);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void getListingTest() throws Exception {
    Listing expectedResponse =
        Listing.newBuilder()
            .setName(
                ListingName.of("[PROJECT]", "[LOCATION]", "[DATA_EXCHANGE]", "[LISTING]")
                    .toString())
            .setDisplayName("displayName1714148973")
            .setDescription("description-1724546052")
            .setPrimaryContact("primaryContact-532068418")
            .setDocumentation("documentation1587405498")
            .setIcon(ByteString.EMPTY)
            .setDataProvider(DataProvider.newBuilder().build())
            .addAllCategories(new ArrayList<Listing.Category>())
            .setPublisher(Publisher.newBuilder().build())
            .setRequestAccess("requestAccess871967955")
            .setRestrictedExportConfig(Listing.RestrictedExportConfig.newBuilder().build())
            .setDiscoveryType(DiscoveryType.forNumber(0))
            .setResourceType(SharedResourceType.forNumber(0))
            .setCommercialInfo(Listing.CommercialInfo.newBuilder().build())
            .setLogLinkedDatasetQueryUserEmail(true)
            .setAllowOnlyMetadataSharing(true)
            .build();
    mockAnalyticsHubService.addResponse(expectedResponse);

    ListingName name = ListingName.of("[PROJECT]", "[LOCATION]", "[DATA_EXCHANGE]", "[LISTING]");

    Listing actualResponse = client.getListing(name);
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockAnalyticsHubService.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    GetListingRequest actualRequest = ((GetListingRequest) actualRequests.get(0));

    Assert.assertEquals(name.toString(), actualRequest.getName());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void getListingExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockAnalyticsHubService.addException(exception);

    try {
      ListingName name = ListingName.of("[PROJECT]", "[LOCATION]", "[DATA_EXCHANGE]", "[LISTING]");
      client.getListing(name);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void getListingTest2() throws Exception {
    Listing expectedResponse =
        Listing.newBuilder()
            .setName(
                ListingName.of("[PROJECT]", "[LOCATION]", "[DATA_EXCHANGE]", "[LISTING]")
                    .toString())
            .setDisplayName("displayName1714148973")
            .setDescription("description-1724546052")
            .setPrimaryContact("primaryContact-532068418")
            .setDocumentation("documentation1587405498")
            .setIcon(ByteString.EMPTY)
            .setDataProvider(DataProvider.newBuilder().build())
            .addAllCategories(new ArrayList<Listing.Category>())
            .setPublisher(Publisher.newBuilder().build())
            .setRequestAccess("requestAccess871967955")
            .setRestrictedExportConfig(Listing.RestrictedExportConfig.newBuilder().build())
            .setDiscoveryType(DiscoveryType.forNumber(0))
            .setResourceType(SharedResourceType.forNumber(0))
            .setCommercialInfo(Listing.CommercialInfo.newBuilder().build())
            .setLogLinkedDatasetQueryUserEmail(true)
            .setAllowOnlyMetadataSharing(true)
            .build();
    mockAnalyticsHubService.addResponse(expectedResponse);

    String name = "name3373707";

    Listing actualResponse = client.getListing(name);
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockAnalyticsHubService.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    GetListingRequest actualRequest = ((GetListingRequest) actualRequests.get(0));

    Assert.assertEquals(name, actualRequest.getName());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void getListingExceptionTest2() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockAnalyticsHubService.addException(exception);

    try {
      String name = "name3373707";
      client.getListing(name);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void createListingTest() throws Exception {
    Listing expectedResponse =
        Listing.newBuilder()
            .setName(
                ListingName.of("[PROJECT]", "[LOCATION]", "[DATA_EXCHANGE]", "[LISTING]")
                    .toString())
            .setDisplayName("displayName1714148973")
            .setDescription("description-1724546052")
            .setPrimaryContact("primaryContact-532068418")
            .setDocumentation("documentation1587405498")
            .setIcon(ByteString.EMPTY)
            .setDataProvider(DataProvider.newBuilder().build())
            .addAllCategories(new ArrayList<Listing.Category>())
            .setPublisher(Publisher.newBuilder().build())
            .setRequestAccess("requestAccess871967955")
            .setRestrictedExportConfig(Listing.RestrictedExportConfig.newBuilder().build())
            .setDiscoveryType(DiscoveryType.forNumber(0))
            .setResourceType(SharedResourceType.forNumber(0))
            .setCommercialInfo(Listing.CommercialInfo.newBuilder().build())
            .setLogLinkedDatasetQueryUserEmail(true)
            .setAllowOnlyMetadataSharing(true)
            .build();
    mockAnalyticsHubService.addResponse(expectedResponse);

    DataExchangeName parent = DataExchangeName.of("[PROJECT]", "[LOCATION]", "[DATA_EXCHANGE]");
    Listing listing = Listing.newBuilder().build();

    Listing actualResponse = client.createListing(parent, listing);
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockAnalyticsHubService.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    CreateListingRequest actualRequest = ((CreateListingRequest) actualRequests.get(0));

    Assert.assertEquals(parent.toString(), actualRequest.getParent());
    Assert.assertEquals(listing, actualRequest.getListing());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void createListingExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockAnalyticsHubService.addException(exception);

    try {
      DataExchangeName parent = DataExchangeName.of("[PROJECT]", "[LOCATION]", "[DATA_EXCHANGE]");
      Listing listing = Listing.newBuilder().build();
      client.createListing(parent, listing);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void createListingTest2() throws Exception {
    Listing expectedResponse =
        Listing.newBuilder()
            .setName(
                ListingName.of("[PROJECT]", "[LOCATION]", "[DATA_EXCHANGE]", "[LISTING]")
                    .toString())
            .setDisplayName("displayName1714148973")
            .setDescription("description-1724546052")
            .setPrimaryContact("primaryContact-532068418")
            .setDocumentation("documentation1587405498")
            .setIcon(ByteString.EMPTY)
            .setDataProvider(DataProvider.newBuilder().build())
            .addAllCategories(new ArrayList<Listing.Category>())
            .setPublisher(Publisher.newBuilder().build())
            .setRequestAccess("requestAccess871967955")
            .setRestrictedExportConfig(Listing.RestrictedExportConfig.newBuilder().build())
            .setDiscoveryType(DiscoveryType.forNumber(0))
            .setResourceType(SharedResourceType.forNumber(0))
            .setCommercialInfo(Listing.CommercialInfo.newBuilder().build())
            .setLogLinkedDatasetQueryUserEmail(true)
            .setAllowOnlyMetadataSharing(true)
            .build();
    mockAnalyticsHubService.addResponse(expectedResponse);

    String parent = "parent-995424086";
    Listing listing = Listing.newBuilder().build();

    Listing actualResponse = client.createListing(parent, listing);
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockAnalyticsHubService.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    CreateListingRequest actualRequest = ((CreateListingRequest) actualRequests.get(0));

    Assert.assertEquals(parent, actualRequest.getParent());
    Assert.assertEquals(listing, actualRequest.getListing());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void createListingExceptionTest2() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockAnalyticsHubService.addException(exception);

    try {
      String parent = "parent-995424086";
      Listing listing = Listing.newBuilder().build();
      client.createListing(parent, listing);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void updateListingTest() throws Exception {
    Listing expectedResponse =
        Listing.newBuilder()
            .setName(
                ListingName.of("[PROJECT]", "[LOCATION]", "[DATA_EXCHANGE]", "[LISTING]")
                    .toString())
            .setDisplayName("displayName1714148973")
            .setDescription("description-1724546052")
            .setPrimaryContact("primaryContact-532068418")
            .setDocumentation("documentation1587405498")
            .setIcon(ByteString.EMPTY)
            .setDataProvider(DataProvider.newBuilder().build())
            .addAllCategories(new ArrayList<Listing.Category>())
            .setPublisher(Publisher.newBuilder().build())
            .setRequestAccess("requestAccess871967955")
            .setRestrictedExportConfig(Listing.RestrictedExportConfig.newBuilder().build())
            .setDiscoveryType(DiscoveryType.forNumber(0))
            .setResourceType(SharedResourceType.forNumber(0))
            .setCommercialInfo(Listing.CommercialInfo.newBuilder().build())
            .setLogLinkedDatasetQueryUserEmail(true)
            .setAllowOnlyMetadataSharing(true)
            .build();
    mockAnalyticsHubService.addResponse(expectedResponse);

    Listing listing = Listing.newBuilder().build();
    FieldMask updateMask = FieldMask.newBuilder().build();

    Listing actualResponse = client.updateListing(listing, updateMask);
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockAnalyticsHubService.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    UpdateListingRequest actualRequest = ((UpdateListingRequest) actualRequests.get(0));

    Assert.assertEquals(listing, actualRequest.getListing());
    Assert.assertEquals(updateMask, actualRequest.getUpdateMask());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void updateListingExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockAnalyticsHubService.addException(exception);

    try {
      Listing listing = Listing.newBuilder().build();
      FieldMask updateMask = FieldMask.newBuilder().build();
      client.updateListing(listing, updateMask);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void deleteListingTest() throws Exception {
    Empty expectedResponse = Empty.newBuilder().build();
    mockAnalyticsHubService.addResponse(expectedResponse);

    ListingName name = ListingName.of("[PROJECT]", "[LOCATION]", "[DATA_EXCHANGE]", "[LISTING]");

    client.deleteListing(name);

    List<AbstractMessage> actualRequests = mockAnalyticsHubService.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    DeleteListingRequest actualRequest = ((DeleteListingRequest) actualRequests.get(0));

    Assert.assertEquals(name.toString(), actualRequest.getName());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void deleteListingExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockAnalyticsHubService.addException(exception);

    try {
      ListingName name = ListingName.of("[PROJECT]", "[LOCATION]", "[DATA_EXCHANGE]", "[LISTING]");
      client.deleteListing(name);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void deleteListingTest2() throws Exception {
    Empty expectedResponse = Empty.newBuilder().build();
    mockAnalyticsHubService.addResponse(expectedResponse);

    String name = "name3373707";

    client.deleteListing(name);

    List<AbstractMessage> actualRequests = mockAnalyticsHubService.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    DeleteListingRequest actualRequest = ((DeleteListingRequest) actualRequests.get(0));

    Assert.assertEquals(name, actualRequest.getName());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void deleteListingExceptionTest2() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockAnalyticsHubService.addException(exception);

    try {
      String name = "name3373707";
      client.deleteListing(name);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void subscribeListingTest() throws Exception {
    SubscribeListingResponse expectedResponse =
        SubscribeListingResponse.newBuilder()
            .setSubscription(Subscription.newBuilder().build())
            .build();
    mockAnalyticsHubService.addResponse(expectedResponse);

    ListingName name = ListingName.of("[PROJECT]", "[LOCATION]", "[DATA_EXCHANGE]", "[LISTING]");

    SubscribeListingResponse actualResponse = client.subscribeListing(name);
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockAnalyticsHubService.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    SubscribeListingRequest actualRequest = ((SubscribeListingRequest) actualRequests.get(0));

    Assert.assertEquals(name.toString(), actualRequest.getName());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void subscribeListingExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockAnalyticsHubService.addException(exception);

    try {
      ListingName name = ListingName.of("[PROJECT]", "[LOCATION]", "[DATA_EXCHANGE]", "[LISTING]");
      client.subscribeListing(name);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void subscribeListingTest2() throws Exception {
    SubscribeListingResponse expectedResponse =
        SubscribeListingResponse.newBuilder()
            .setSubscription(Subscription.newBuilder().build())
            .build();
    mockAnalyticsHubService.addResponse(expectedResponse);

    String name = "name3373707";

    SubscribeListingResponse actualResponse = client.subscribeListing(name);
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockAnalyticsHubService.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    SubscribeListingRequest actualRequest = ((SubscribeListingRequest) actualRequests.get(0));

    Assert.assertEquals(name, actualRequest.getName());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void subscribeListingExceptionTest2() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockAnalyticsHubService.addException(exception);

    try {
      String name = "name3373707";
      client.subscribeListing(name);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void subscribeDataExchangeTest() throws Exception {
    SubscribeDataExchangeResponse expectedResponse =
        SubscribeDataExchangeResponse.newBuilder()
            .setSubscription(Subscription.newBuilder().build())
            .build();
    Operation resultOperation =
        Operation.newBuilder()
            .setName("subscribeDataExchangeTest")
            .setDone(true)
            .setResponse(Any.pack(expectedResponse))
            .build();
    mockAnalyticsHubService.addResponse(resultOperation);

    DataExchangeName name = DataExchangeName.of("[PROJECT]", "[LOCATION]", "[DATA_EXCHANGE]");

    SubscribeDataExchangeResponse actualResponse = client.subscribeDataExchangeAsync(name).get();
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockAnalyticsHubService.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    SubscribeDataExchangeRequest actualRequest =
        ((SubscribeDataExchangeRequest) actualRequests.get(0));

    Assert.assertEquals(name.toString(), actualRequest.getName());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void subscribeDataExchangeExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockAnalyticsHubService.addException(exception);

    try {
      DataExchangeName name = DataExchangeName.of("[PROJECT]", "[LOCATION]", "[DATA_EXCHANGE]");
      client.subscribeDataExchangeAsync(name).get();
      Assert.fail("No exception raised");
    } catch (ExecutionException e) {
      Assert.assertEquals(InvalidArgumentException.class, e.getCause().getClass());
      InvalidArgumentException apiException = ((InvalidArgumentException) e.getCause());
      Assert.assertEquals(StatusCode.Code.INVALID_ARGUMENT, apiException.getStatusCode().getCode());
    }
  }

  @Test
  public void subscribeDataExchangeTest2() throws Exception {
    SubscribeDataExchangeResponse expectedResponse =
        SubscribeDataExchangeResponse.newBuilder()
            .setSubscription(Subscription.newBuilder().build())
            .build();
    Operation resultOperation =
        Operation.newBuilder()
            .setName("subscribeDataExchangeTest")
            .setDone(true)
            .setResponse(Any.pack(expectedResponse))
            .build();
    mockAnalyticsHubService.addResponse(resultOperation);

    String name = "name3373707";

    SubscribeDataExchangeResponse actualResponse = client.subscribeDataExchangeAsync(name).get();
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockAnalyticsHubService.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    SubscribeDataExchangeRequest actualRequest =
        ((SubscribeDataExchangeRequest) actualRequests.get(0));

    Assert.assertEquals(name, actualRequest.getName());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void subscribeDataExchangeExceptionTest2() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockAnalyticsHubService.addException(exception);

    try {
      String name = "name3373707";
      client.subscribeDataExchangeAsync(name).get();
      Assert.fail("No exception raised");
    } catch (ExecutionException e) {
      Assert.assertEquals(InvalidArgumentException.class, e.getCause().getClass());
      InvalidArgumentException apiException = ((InvalidArgumentException) e.getCause());
      Assert.assertEquals(StatusCode.Code.INVALID_ARGUMENT, apiException.getStatusCode().getCode());
    }
  }

  @Test
  public void refreshSubscriptionTest() throws Exception {
    RefreshSubscriptionResponse expectedResponse =
        RefreshSubscriptionResponse.newBuilder()
            .setSubscription(Subscription.newBuilder().build())
            .build();
    Operation resultOperation =
        Operation.newBuilder()
            .setName("refreshSubscriptionTest")
            .setDone(true)
            .setResponse(Any.pack(expectedResponse))
            .build();
    mockAnalyticsHubService.addResponse(resultOperation);

    SubscriptionName name = SubscriptionName.of("[PROJECT]", "[LOCATION]", "[SUBSCRIPTION]");

    RefreshSubscriptionResponse actualResponse = client.refreshSubscriptionAsync(name).get();
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockAnalyticsHubService.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    RefreshSubscriptionRequest actualRequest = ((RefreshSubscriptionRequest) actualRequests.get(0));

    Assert.assertEquals(name.toString(), actualRequest.getName());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void refreshSubscriptionExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockAnalyticsHubService.addException(exception);

    try {
      SubscriptionName name = SubscriptionName.of("[PROJECT]", "[LOCATION]", "[SUBSCRIPTION]");
      client.refreshSubscriptionAsync(name).get();
      Assert.fail("No exception raised");
    } catch (ExecutionException e) {
      Assert.assertEquals(InvalidArgumentException.class, e.getCause().getClass());
      InvalidArgumentException apiException = ((InvalidArgumentException) e.getCause());
      Assert.assertEquals(StatusCode.Code.INVALID_ARGUMENT, apiException.getStatusCode().getCode());
    }
  }

  @Test
  public void refreshSubscriptionTest2() throws Exception {
    RefreshSubscriptionResponse expectedResponse =
        RefreshSubscriptionResponse.newBuilder()
            .setSubscription(Subscription.newBuilder().build())
            .build();
    Operation resultOperation =
        Operation.newBuilder()
            .setName("refreshSubscriptionTest")
            .setDone(true)
            .setResponse(Any.pack(expectedResponse))
            .build();
    mockAnalyticsHubService.addResponse(resultOperation);

    String name = "name3373707";

    RefreshSubscriptionResponse actualResponse = client.refreshSubscriptionAsync(name).get();
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockAnalyticsHubService.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    RefreshSubscriptionRequest actualRequest = ((RefreshSubscriptionRequest) actualRequests.get(0));

    Assert.assertEquals(name, actualRequest.getName());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void refreshSubscriptionExceptionTest2() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockAnalyticsHubService.addException(exception);

    try {
      String name = "name3373707";
      client.refreshSubscriptionAsync(name).get();
      Assert.fail("No exception raised");
    } catch (ExecutionException e) {
      Assert.assertEquals(InvalidArgumentException.class, e.getCause().getClass());
      InvalidArgumentException apiException = ((InvalidArgumentException) e.getCause());
      Assert.assertEquals(StatusCode.Code.INVALID_ARGUMENT, apiException.getStatusCode().getCode());
    }
  }

  @Test
  public void getSubscriptionTest() throws Exception {
    Subscription expectedResponse =
        Subscription.newBuilder()
            .setName(SubscriptionName.of("[PROJECT]", "[LOCATION]", "[SUBSCRIPTION]").toString())
            .setCreationTime(Timestamp.newBuilder().build())
            .setLastModifyTime(Timestamp.newBuilder().build())
            .setOrganizationId("organizationId-927042130")
            .setOrganizationDisplayName("organizationDisplayName-1353817286")
            .putAllLinkedDatasetMap(new HashMap<String, Subscription.LinkedResource>())
            .setSubscriberContact("subscriberContact-847205736")
            .addAllLinkedResources(new ArrayList<Subscription.LinkedResource>())
            .setResourceType(SharedResourceType.forNumber(0))
            .setCommercialInfo(Subscription.CommercialInfo.newBuilder().build())
            .setLogLinkedDatasetQueryUserEmail(true)
            .setDestinationDataset(DestinationDataset.newBuilder().build())
            .build();
    mockAnalyticsHubService.addResponse(expectedResponse);

    SubscriptionName name = SubscriptionName.of("[PROJECT]", "[LOCATION]", "[SUBSCRIPTION]");

    Subscription actualResponse = client.getSubscription(name);
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockAnalyticsHubService.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    GetSubscriptionRequest actualRequest = ((GetSubscriptionRequest) actualRequests.get(0));

    Assert.assertEquals(name.toString(), actualRequest.getName());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void getSubscriptionExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockAnalyticsHubService.addException(exception);

    try {
      SubscriptionName name = SubscriptionName.of("[PROJECT]", "[LOCATION]", "[SUBSCRIPTION]");
      client.getSubscription(name);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void getSubscriptionTest2() throws Exception {
    Subscription expectedResponse =
        Subscription.newBuilder()
            .setName(SubscriptionName.of("[PROJECT]", "[LOCATION]", "[SUBSCRIPTION]").toString())
            .setCreationTime(Timestamp.newBuilder().build())
            .setLastModifyTime(Timestamp.newBuilder().build())
            .setOrganizationId("organizationId-927042130")
            .setOrganizationDisplayName("organizationDisplayName-1353817286")
            .putAllLinkedDatasetMap(new HashMap<String, Subscription.LinkedResource>())
            .setSubscriberContact("subscriberContact-847205736")
            .addAllLinkedResources(new ArrayList<Subscription.LinkedResource>())
            .setResourceType(SharedResourceType.forNumber(0))
            .setCommercialInfo(Subscription.CommercialInfo.newBuilder().build())
            .setLogLinkedDatasetQueryUserEmail(true)
            .setDestinationDataset(DestinationDataset.newBuilder().build())
            .build();
    mockAnalyticsHubService.addResponse(expectedResponse);

    String name = "name3373707";

    Subscription actualResponse = client.getSubscription(name);
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockAnalyticsHubService.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    GetSubscriptionRequest actualRequest = ((GetSubscriptionRequest) actualRequests.get(0));

    Assert.assertEquals(name, actualRequest.getName());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void getSubscriptionExceptionTest2() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockAnalyticsHubService.addException(exception);

    try {
      String name = "name3373707";
      client.getSubscription(name);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void listSubscriptionsTest() throws Exception {
    Subscription responsesElement = Subscription.newBuilder().build();
    ListSubscriptionsResponse expectedResponse =
        ListSubscriptionsResponse.newBuilder()
            .setNextPageToken("")
            .addAllSubscriptions(Arrays.asList(responsesElement))
            .build();
    mockAnalyticsHubService.addResponse(expectedResponse);

    LocationName parent = LocationName.of("[PROJECT]", "[LOCATION]");

    ListSubscriptionsPagedResponse pagedListResponse = client.listSubscriptions(parent);

    List<Subscription> resources = Lists.newArrayList(pagedListResponse.iterateAll());

    Assert.assertEquals(1, resources.size());
    Assert.assertEquals(expectedResponse.getSubscriptionsList().get(0), resources.get(0));

    List<AbstractMessage> actualRequests = mockAnalyticsHubService.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    ListSubscriptionsRequest actualRequest = ((ListSubscriptionsRequest) actualRequests.get(0));

    Assert.assertEquals(parent.toString(), actualRequest.getParent());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void listSubscriptionsExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockAnalyticsHubService.addException(exception);

    try {
      LocationName parent = LocationName.of("[PROJECT]", "[LOCATION]");
      client.listSubscriptions(parent);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void listSubscriptionsTest2() throws Exception {
    Subscription responsesElement = Subscription.newBuilder().build();
    ListSubscriptionsResponse expectedResponse =
        ListSubscriptionsResponse.newBuilder()
            .setNextPageToken("")
            .addAllSubscriptions(Arrays.asList(responsesElement))
            .build();
    mockAnalyticsHubService.addResponse(expectedResponse);

    String parent = "parent-995424086";

    ListSubscriptionsPagedResponse pagedListResponse = client.listSubscriptions(parent);

    List<Subscription> resources = Lists.newArrayList(pagedListResponse.iterateAll());

    Assert.assertEquals(1, resources.size());
    Assert.assertEquals(expectedResponse.getSubscriptionsList().get(0), resources.get(0));

    List<AbstractMessage> actualRequests = mockAnalyticsHubService.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    ListSubscriptionsRequest actualRequest = ((ListSubscriptionsRequest) actualRequests.get(0));

    Assert.assertEquals(parent, actualRequest.getParent());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void listSubscriptionsExceptionTest2() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockAnalyticsHubService.addException(exception);

    try {
      String parent = "parent-995424086";
      client.listSubscriptions(parent);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void listSharedResourceSubscriptionsTest() throws Exception {
    Subscription responsesElement = Subscription.newBuilder().build();
    ListSharedResourceSubscriptionsResponse expectedResponse =
        ListSharedResourceSubscriptionsResponse.newBuilder()
            .setNextPageToken("")
            .addAllSharedResourceSubscriptions(Arrays.asList(responsesElement))
            .build();
    mockAnalyticsHubService.addResponse(expectedResponse);

    ResourceName resource = DataExchangeName.of("[PROJECT]", "[LOCATION]", "[DATA_EXCHANGE]");

    ListSharedResourceSubscriptionsPagedResponse pagedListResponse =
        client.listSharedResourceSubscriptions(resource);

    List<Subscription> resources = Lists.newArrayList(pagedListResponse.iterateAll());

    Assert.assertEquals(1, resources.size());
    Assert.assertEquals(
        expectedResponse.getSharedResourceSubscriptionsList().get(0), resources.get(0));

    List<AbstractMessage> actualRequests = mockAnalyticsHubService.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    ListSharedResourceSubscriptionsRequest actualRequest =
        ((ListSharedResourceSubscriptionsRequest) actualRequests.get(0));

    Assert.assertEquals(resource.toString(), actualRequest.getResource());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void listSharedResourceSubscriptionsExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockAnalyticsHubService.addException(exception);

    try {
      ResourceName resource = DataExchangeName.of("[PROJECT]", "[LOCATION]", "[DATA_EXCHANGE]");
      client.listSharedResourceSubscriptions(resource);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void listSharedResourceSubscriptionsTest2() throws Exception {
    Subscription responsesElement = Subscription.newBuilder().build();
    ListSharedResourceSubscriptionsResponse expectedResponse =
        ListSharedResourceSubscriptionsResponse.newBuilder()
            .setNextPageToken("")
            .addAllSharedResourceSubscriptions(Arrays.asList(responsesElement))
            .build();
    mockAnalyticsHubService.addResponse(expectedResponse);

    String resource = "resource-341064690";

    ListSharedResourceSubscriptionsPagedResponse pagedListResponse =
        client.listSharedResourceSubscriptions(resource);

    List<Subscription> resources = Lists.newArrayList(pagedListResponse.iterateAll());

    Assert.assertEquals(1, resources.size());
    Assert.assertEquals(
        expectedResponse.getSharedResourceSubscriptionsList().get(0), resources.get(0));

    List<AbstractMessage> actualRequests = mockAnalyticsHubService.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    ListSharedResourceSubscriptionsRequest actualRequest =
        ((ListSharedResourceSubscriptionsRequest) actualRequests.get(0));

    Assert.assertEquals(resource, actualRequest.getResource());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void listSharedResourceSubscriptionsExceptionTest2() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockAnalyticsHubService.addException(exception);

    try {
      String resource = "resource-341064690";
      client.listSharedResourceSubscriptions(resource);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void revokeSubscriptionTest() throws Exception {
    RevokeSubscriptionResponse expectedResponse = RevokeSubscriptionResponse.newBuilder().build();
    mockAnalyticsHubService.addResponse(expectedResponse);

    SubscriptionName name = SubscriptionName.of("[PROJECT]", "[LOCATION]", "[SUBSCRIPTION]");

    RevokeSubscriptionResponse actualResponse = client.revokeSubscription(name);
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockAnalyticsHubService.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    RevokeSubscriptionRequest actualRequest = ((RevokeSubscriptionRequest) actualRequests.get(0));

    Assert.assertEquals(name.toString(), actualRequest.getName());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void revokeSubscriptionExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockAnalyticsHubService.addException(exception);

    try {
      SubscriptionName name = SubscriptionName.of("[PROJECT]", "[LOCATION]", "[SUBSCRIPTION]");
      client.revokeSubscription(name);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void revokeSubscriptionTest2() throws Exception {
    RevokeSubscriptionResponse expectedResponse = RevokeSubscriptionResponse.newBuilder().build();
    mockAnalyticsHubService.addResponse(expectedResponse);

    String name = "name3373707";

    RevokeSubscriptionResponse actualResponse = client.revokeSubscription(name);
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockAnalyticsHubService.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    RevokeSubscriptionRequest actualRequest = ((RevokeSubscriptionRequest) actualRequests.get(0));

    Assert.assertEquals(name, actualRequest.getName());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void revokeSubscriptionExceptionTest2() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockAnalyticsHubService.addException(exception);

    try {
      String name = "name3373707";
      client.revokeSubscription(name);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void deleteSubscriptionTest() throws Exception {
    Empty expectedResponse = Empty.newBuilder().build();
    Operation resultOperation =
        Operation.newBuilder()
            .setName("deleteSubscriptionTest")
            .setDone(true)
            .setResponse(Any.pack(expectedResponse))
            .build();
    mockAnalyticsHubService.addResponse(resultOperation);

    SubscriptionName name = SubscriptionName.of("[PROJECT]", "[LOCATION]", "[SUBSCRIPTION]");

    client.deleteSubscriptionAsync(name).get();

    List<AbstractMessage> actualRequests = mockAnalyticsHubService.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    DeleteSubscriptionRequest actualRequest = ((DeleteSubscriptionRequest) actualRequests.get(0));

    Assert.assertEquals(name.toString(), actualRequest.getName());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void deleteSubscriptionExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockAnalyticsHubService.addException(exception);

    try {
      SubscriptionName name = SubscriptionName.of("[PROJECT]", "[LOCATION]", "[SUBSCRIPTION]");
      client.deleteSubscriptionAsync(name).get();
      Assert.fail("No exception raised");
    } catch (ExecutionException e) {
      Assert.assertEquals(InvalidArgumentException.class, e.getCause().getClass());
      InvalidArgumentException apiException = ((InvalidArgumentException) e.getCause());
      Assert.assertEquals(StatusCode.Code.INVALID_ARGUMENT, apiException.getStatusCode().getCode());
    }
  }

  @Test
  public void deleteSubscriptionTest2() throws Exception {
    Empty expectedResponse = Empty.newBuilder().build();
    Operation resultOperation =
        Operation.newBuilder()
            .setName("deleteSubscriptionTest")
            .setDone(true)
            .setResponse(Any.pack(expectedResponse))
            .build();
    mockAnalyticsHubService.addResponse(resultOperation);

    String name = "name3373707";

    client.deleteSubscriptionAsync(name).get();

    List<AbstractMessage> actualRequests = mockAnalyticsHubService.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    DeleteSubscriptionRequest actualRequest = ((DeleteSubscriptionRequest) actualRequests.get(0));

    Assert.assertEquals(name, actualRequest.getName());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void deleteSubscriptionExceptionTest2() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockAnalyticsHubService.addException(exception);

    try {
      String name = "name3373707";
      client.deleteSubscriptionAsync(name).get();
      Assert.fail("No exception raised");
    } catch (ExecutionException e) {
      Assert.assertEquals(InvalidArgumentException.class, e.getCause().getClass());
      InvalidArgumentException apiException = ((InvalidArgumentException) e.getCause());
      Assert.assertEquals(StatusCode.Code.INVALID_ARGUMENT, apiException.getStatusCode().getCode());
    }
  }

  @Test
  public void getIamPolicyTest() throws Exception {
    Policy expectedResponse =
        Policy.newBuilder()
            .setVersion(351608024)
            .addAllBindings(new ArrayList<Binding>())
            .addAllAuditConfigs(new ArrayList<AuditConfig>())
            .setEtag(ByteString.EMPTY)
            .build();
    mockAnalyticsHubService.addResponse(expectedResponse);

    GetIamPolicyRequest request =
        GetIamPolicyRequest.newBuilder()
            .setResource(
                DataExchangeName.of("[PROJECT]", "[LOCATION]", "[DATA_EXCHANGE]").toString())
            .setOptions(GetPolicyOptions.newBuilder().build())
            .build();

    Policy actualResponse = client.getIamPolicy(request);
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockAnalyticsHubService.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    GetIamPolicyRequest actualRequest = ((GetIamPolicyRequest) actualRequests.get(0));

    Assert.assertEquals(request.getResource(), actualRequest.getResource());
    Assert.assertEquals(request.getOptions(), actualRequest.getOptions());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void getIamPolicyExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockAnalyticsHubService.addException(exception);

    try {
      GetIamPolicyRequest request =
          GetIamPolicyRequest.newBuilder()
              .setResource(
                  DataExchangeName.of("[PROJECT]", "[LOCATION]", "[DATA_EXCHANGE]").toString())
              .setOptions(GetPolicyOptions.newBuilder().build())
              .build();
      client.getIamPolicy(request);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void setIamPolicyTest() throws Exception {
    Policy expectedResponse =
        Policy.newBuilder()
            .setVersion(351608024)
            .addAllBindings(new ArrayList<Binding>())
            .addAllAuditConfigs(new ArrayList<AuditConfig>())
            .setEtag(ByteString.EMPTY)
            .build();
    mockAnalyticsHubService.addResponse(expectedResponse);

    SetIamPolicyRequest request =
        SetIamPolicyRequest.newBuilder()
            .setResource(
                DataExchangeName.of("[PROJECT]", "[LOCATION]", "[DATA_EXCHANGE]").toString())
            .setPolicy(Policy.newBuilder().build())
            .setUpdateMask(FieldMask.newBuilder().build())
            .build();

    Policy actualResponse = client.setIamPolicy(request);
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockAnalyticsHubService.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    SetIamPolicyRequest actualRequest = ((SetIamPolicyRequest) actualRequests.get(0));

    Assert.assertEquals(request.getResource(), actualRequest.getResource());
    Assert.assertEquals(request.getPolicy(), actualRequest.getPolicy());
    Assert.assertEquals(request.getUpdateMask(), actualRequest.getUpdateMask());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void setIamPolicyExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockAnalyticsHubService.addException(exception);

    try {
      SetIamPolicyRequest request =
          SetIamPolicyRequest.newBuilder()
              .setResource(
                  DataExchangeName.of("[PROJECT]", "[LOCATION]", "[DATA_EXCHANGE]").toString())
              .setPolicy(Policy.newBuilder().build())
              .setUpdateMask(FieldMask.newBuilder().build())
              .build();
      client.setIamPolicy(request);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void testIamPermissionsTest() throws Exception {
    TestIamPermissionsResponse expectedResponse =
        TestIamPermissionsResponse.newBuilder().addAllPermissions(new ArrayList<String>()).build();
    mockAnalyticsHubService.addResponse(expectedResponse);

    TestIamPermissionsRequest request =
        TestIamPermissionsRequest.newBuilder()
            .setResource(
                DataExchangeName.of("[PROJECT]", "[LOCATION]", "[DATA_EXCHANGE]").toString())
            .addAllPermissions(new ArrayList<String>())
            .build();

    TestIamPermissionsResponse actualResponse = client.testIamPermissions(request);
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockAnalyticsHubService.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    TestIamPermissionsRequest actualRequest = ((TestIamPermissionsRequest) actualRequests.get(0));

    Assert.assertEquals(request.getResource(), actualRequest.getResource());
    Assert.assertEquals(request.getPermissionsList(), actualRequest.getPermissionsList());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void testIamPermissionsExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockAnalyticsHubService.addException(exception);

    try {
      TestIamPermissionsRequest request =
          TestIamPermissionsRequest.newBuilder()
              .setResource(
                  DataExchangeName.of("[PROJECT]", "[LOCATION]", "[DATA_EXCHANGE]").toString())
              .addAllPermissions(new ArrayList<String>())
              .build();
      client.testIamPermissions(request);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void createQueryTemplateTest() throws Exception {
    QueryTemplate expectedResponse =
        QueryTemplate.newBuilder()
            .setName(
                QueryTemplateName.of(
                        "[PROJECT]", "[LOCATION]", "[DATA_EXCHANGE]", "[QUERY_TEMPLATE]")
                    .toString())
            .setDisplayName("displayName1714148973")
            .setDescription("description-1724546052")
            .setProposer("proposer-992842892")
            .setPrimaryContact("primaryContact-532068418")
            .setDocumentation("documentation1587405498")
            .setRoutine(Routine.newBuilder().build())
            .setCreateTime(Timestamp.newBuilder().build())
            .setUpdateTime(Timestamp.newBuilder().build())
            .build();
    mockAnalyticsHubService.addResponse(expectedResponse);

    DataExchangeName parent = DataExchangeName.of("[PROJECT]", "[LOCATION]", "[DATA_EXCHANGE]");
    QueryTemplate queryTemplate = QueryTemplate.newBuilder().build();
    String queryTemplateId = "queryTemplateId-1884800483";

    QueryTemplate actualResponse =
        client.createQueryTemplate(parent, queryTemplate, queryTemplateId);
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockAnalyticsHubService.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    CreateQueryTemplateRequest actualRequest = ((CreateQueryTemplateRequest) actualRequests.get(0));

    Assert.assertEquals(parent.toString(), actualRequest.getParent());
    Assert.assertEquals(queryTemplate, actualRequest.getQueryTemplate());
    Assert.assertEquals(queryTemplateId, actualRequest.getQueryTemplateId());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void createQueryTemplateExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockAnalyticsHubService.addException(exception);

    try {
      DataExchangeName parent = DataExchangeName.of("[PROJECT]", "[LOCATION]", "[DATA_EXCHANGE]");
      QueryTemplate queryTemplate = QueryTemplate.newBuilder().build();
      String queryTemplateId = "queryTemplateId-1884800483";
      client.createQueryTemplate(parent, queryTemplate, queryTemplateId);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void createQueryTemplateTest2() throws Exception {
    QueryTemplate expectedResponse =
        QueryTemplate.newBuilder()
            .setName(
                QueryTemplateName.of(
                        "[PROJECT]", "[LOCATION]", "[DATA_EXCHANGE]", "[QUERY_TEMPLATE]")
                    .toString())
            .setDisplayName("displayName1714148973")
            .setDescription("description-1724546052")
            .setProposer("proposer-992842892")
            .setPrimaryContact("primaryContact-532068418")
            .setDocumentation("documentation1587405498")
            .setRoutine(Routine.newBuilder().build())
            .setCreateTime(Timestamp.newBuilder().build())
            .setUpdateTime(Timestamp.newBuilder().build())
            .build();
    mockAnalyticsHubService.addResponse(expectedResponse);

    String parent = "parent-995424086";
    QueryTemplate queryTemplate = QueryTemplate.newBuilder().build();
    String queryTemplateId = "queryTemplateId-1884800483";

    QueryTemplate actualResponse =
        client.createQueryTemplate(parent, queryTemplate, queryTemplateId);
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockAnalyticsHubService.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    CreateQueryTemplateRequest actualRequest = ((CreateQueryTemplateRequest) actualRequests.get(0));

    Assert.assertEquals(parent, actualRequest.getParent());
    Assert.assertEquals(queryTemplate, actualRequest.getQueryTemplate());
    Assert.assertEquals(queryTemplateId, actualRequest.getQueryTemplateId());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void createQueryTemplateExceptionTest2() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockAnalyticsHubService.addException(exception);

    try {
      String parent = "parent-995424086";
      QueryTemplate queryTemplate = QueryTemplate.newBuilder().build();
      String queryTemplateId = "queryTemplateId-1884800483";
      client.createQueryTemplate(parent, queryTemplate, queryTemplateId);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void getQueryTemplateTest() throws Exception {
    QueryTemplate expectedResponse =
        QueryTemplate.newBuilder()
            .setName(
                QueryTemplateName.of(
                        "[PROJECT]", "[LOCATION]", "[DATA_EXCHANGE]", "[QUERY_TEMPLATE]")
                    .toString())
            .setDisplayName("displayName1714148973")
            .setDescription("description-1724546052")
            .setProposer("proposer-992842892")
            .setPrimaryContact("primaryContact-532068418")
            .setDocumentation("documentation1587405498")
            .setRoutine(Routine.newBuilder().build())
            .setCreateTime(Timestamp.newBuilder().build())
            .setUpdateTime(Timestamp.newBuilder().build())
            .build();
    mockAnalyticsHubService.addResponse(expectedResponse);

    QueryTemplateName name =
        QueryTemplateName.of("[PROJECT]", "[LOCATION]", "[DATA_EXCHANGE]", "[QUERY_TEMPLATE]");

    QueryTemplate actualResponse = client.getQueryTemplate(name);
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockAnalyticsHubService.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    GetQueryTemplateRequest actualRequest = ((GetQueryTemplateRequest) actualRequests.get(0));

    Assert.assertEquals(name.toString(), actualRequest.getName());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void getQueryTemplateExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockAnalyticsHubService.addException(exception);

    try {
      QueryTemplateName name =
          QueryTemplateName.of("[PROJECT]", "[LOCATION]", "[DATA_EXCHANGE]", "[QUERY_TEMPLATE]");
      client.getQueryTemplate(name);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void getQueryTemplateTest2() throws Exception {
    QueryTemplate expectedResponse =
        QueryTemplate.newBuilder()
            .setName(
                QueryTemplateName.of(
                        "[PROJECT]", "[LOCATION]", "[DATA_EXCHANGE]", "[QUERY_TEMPLATE]")
                    .toString())
            .setDisplayName("displayName1714148973")
            .setDescription("description-1724546052")
            .setProposer("proposer-992842892")
            .setPrimaryContact("primaryContact-532068418")
            .setDocumentation("documentation1587405498")
            .setRoutine(Routine.newBuilder().build())
            .setCreateTime(Timestamp.newBuilder().build())
            .setUpdateTime(Timestamp.newBuilder().build())
            .build();
    mockAnalyticsHubService.addResponse(expectedResponse);

    String name = "name3373707";

    QueryTemplate actualResponse = client.getQueryTemplate(name);
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockAnalyticsHubService.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    GetQueryTemplateRequest actualRequest = ((GetQueryTemplateRequest) actualRequests.get(0));

    Assert.assertEquals(name, actualRequest.getName());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void getQueryTemplateExceptionTest2() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockAnalyticsHubService.addException(exception);

    try {
      String name = "name3373707";
      client.getQueryTemplate(name);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void listQueryTemplatesTest() throws Exception {
    QueryTemplate responsesElement = QueryTemplate.newBuilder().build();
    ListQueryTemplatesResponse expectedResponse =
        ListQueryTemplatesResponse.newBuilder()
            .setNextPageToken("")
            .addAllQueryTemplates(Arrays.asList(responsesElement))
            .build();
    mockAnalyticsHubService.addResponse(expectedResponse);

    DataExchangeName parent = DataExchangeName.of("[PROJECT]", "[LOCATION]", "[DATA_EXCHANGE]");

    ListQueryTemplatesPagedResponse pagedListResponse = client.listQueryTemplates(parent);

    List<QueryTemplate> resources = Lists.newArrayList(pagedListResponse.iterateAll());

    Assert.assertEquals(1, resources.size());
    Assert.assertEquals(expectedResponse.getQueryTemplatesList().get(0), resources.get(0));

    List<AbstractMessage> actualRequests = mockAnalyticsHubService.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    ListQueryTemplatesRequest actualRequest = ((ListQueryTemplatesRequest) actualRequests.get(0));

    Assert.assertEquals(parent.toString(), actualRequest.getParent());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void listQueryTemplatesExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockAnalyticsHubService.addException(exception);

    try {
      DataExchangeName parent = DataExchangeName.of("[PROJECT]", "[LOCATION]", "[DATA_EXCHANGE]");
      client.listQueryTemplates(parent);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void listQueryTemplatesTest2() throws Exception {
    QueryTemplate responsesElement = QueryTemplate.newBuilder().build();
    ListQueryTemplatesResponse expectedResponse =
        ListQueryTemplatesResponse.newBuilder()
            .setNextPageToken("")
            .addAllQueryTemplates(Arrays.asList(responsesElement))
            .build();
    mockAnalyticsHubService.addResponse(expectedResponse);

    String parent = "parent-995424086";

    ListQueryTemplatesPagedResponse pagedListResponse = client.listQueryTemplates(parent);

    List<QueryTemplate> resources = Lists.newArrayList(pagedListResponse.iterateAll());

    Assert.assertEquals(1, resources.size());
    Assert.assertEquals(expectedResponse.getQueryTemplatesList().get(0), resources.get(0));

    List<AbstractMessage> actualRequests = mockAnalyticsHubService.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    ListQueryTemplatesRequest actualRequest = ((ListQueryTemplatesRequest) actualRequests.get(0));

    Assert.assertEquals(parent, actualRequest.getParent());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void listQueryTemplatesExceptionTest2() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockAnalyticsHubService.addException(exception);

    try {
      String parent = "parent-995424086";
      client.listQueryTemplates(parent);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void updateQueryTemplateTest() throws Exception {
    QueryTemplate expectedResponse =
        QueryTemplate.newBuilder()
            .setName(
                QueryTemplateName.of(
                        "[PROJECT]", "[LOCATION]", "[DATA_EXCHANGE]", "[QUERY_TEMPLATE]")
                    .toString())
            .setDisplayName("displayName1714148973")
            .setDescription("description-1724546052")
            .setProposer("proposer-992842892")
            .setPrimaryContact("primaryContact-532068418")
            .setDocumentation("documentation1587405498")
            .setRoutine(Routine.newBuilder().build())
            .setCreateTime(Timestamp.newBuilder().build())
            .setUpdateTime(Timestamp.newBuilder().build())
            .build();
    mockAnalyticsHubService.addResponse(expectedResponse);

    QueryTemplate queryTemplate = QueryTemplate.newBuilder().build();
    FieldMask updateMask = FieldMask.newBuilder().build();

    QueryTemplate actualResponse = client.updateQueryTemplate(queryTemplate, updateMask);
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockAnalyticsHubService.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    UpdateQueryTemplateRequest actualRequest = ((UpdateQueryTemplateRequest) actualRequests.get(0));

    Assert.assertEquals(queryTemplate, actualRequest.getQueryTemplate());
    Assert.assertEquals(updateMask, actualRequest.getUpdateMask());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void updateQueryTemplateExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockAnalyticsHubService.addException(exception);

    try {
      QueryTemplate queryTemplate = QueryTemplate.newBuilder().build();
      FieldMask updateMask = FieldMask.newBuilder().build();
      client.updateQueryTemplate(queryTemplate, updateMask);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void deleteQueryTemplateTest() throws Exception {
    Empty expectedResponse = Empty.newBuilder().build();
    mockAnalyticsHubService.addResponse(expectedResponse);

    QueryTemplateName name =
        QueryTemplateName.of("[PROJECT]", "[LOCATION]", "[DATA_EXCHANGE]", "[QUERY_TEMPLATE]");

    client.deleteQueryTemplate(name);

    List<AbstractMessage> actualRequests = mockAnalyticsHubService.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    DeleteQueryTemplateRequest actualRequest = ((DeleteQueryTemplateRequest) actualRequests.get(0));

    Assert.assertEquals(name.toString(), actualRequest.getName());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void deleteQueryTemplateExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockAnalyticsHubService.addException(exception);

    try {
      QueryTemplateName name =
          QueryTemplateName.of("[PROJECT]", "[LOCATION]", "[DATA_EXCHANGE]", "[QUERY_TEMPLATE]");
      client.deleteQueryTemplate(name);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void deleteQueryTemplateTest2() throws Exception {
    Empty expectedResponse = Empty.newBuilder().build();
    mockAnalyticsHubService.addResponse(expectedResponse);

    String name = "name3373707";

    client.deleteQueryTemplate(name);

    List<AbstractMessage> actualRequests = mockAnalyticsHubService.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    DeleteQueryTemplateRequest actualRequest = ((DeleteQueryTemplateRequest) actualRequests.get(0));

    Assert.assertEquals(name, actualRequest.getName());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void deleteQueryTemplateExceptionTest2() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockAnalyticsHubService.addException(exception);

    try {
      String name = "name3373707";
      client.deleteQueryTemplate(name);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void submitQueryTemplateTest() throws Exception {
    QueryTemplate expectedResponse =
        QueryTemplate.newBuilder()
            .setName(
                QueryTemplateName.of(
                        "[PROJECT]", "[LOCATION]", "[DATA_EXCHANGE]", "[QUERY_TEMPLATE]")
                    .toString())
            .setDisplayName("displayName1714148973")
            .setDescription("description-1724546052")
            .setProposer("proposer-992842892")
            .setPrimaryContact("primaryContact-532068418")
            .setDocumentation("documentation1587405498")
            .setRoutine(Routine.newBuilder().build())
            .setCreateTime(Timestamp.newBuilder().build())
            .setUpdateTime(Timestamp.newBuilder().build())
            .build();
    mockAnalyticsHubService.addResponse(expectedResponse);

    QueryTemplateName name =
        QueryTemplateName.of("[PROJECT]", "[LOCATION]", "[DATA_EXCHANGE]", "[QUERY_TEMPLATE]");

    QueryTemplate actualResponse = client.submitQueryTemplate(name);
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockAnalyticsHubService.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    SubmitQueryTemplateRequest actualRequest = ((SubmitQueryTemplateRequest) actualRequests.get(0));

    Assert.assertEquals(name.toString(), actualRequest.getName());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void submitQueryTemplateExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockAnalyticsHubService.addException(exception);

    try {
      QueryTemplateName name =
          QueryTemplateName.of("[PROJECT]", "[LOCATION]", "[DATA_EXCHANGE]", "[QUERY_TEMPLATE]");
      client.submitQueryTemplate(name);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void submitQueryTemplateTest2() throws Exception {
    QueryTemplate expectedResponse =
        QueryTemplate.newBuilder()
            .setName(
                QueryTemplateName.of(
                        "[PROJECT]", "[LOCATION]", "[DATA_EXCHANGE]", "[QUERY_TEMPLATE]")
                    .toString())
            .setDisplayName("displayName1714148973")
            .setDescription("description-1724546052")
            .setProposer("proposer-992842892")
            .setPrimaryContact("primaryContact-532068418")
            .setDocumentation("documentation1587405498")
            .setRoutine(Routine.newBuilder().build())
            .setCreateTime(Timestamp.newBuilder().build())
            .setUpdateTime(Timestamp.newBuilder().build())
            .build();
    mockAnalyticsHubService.addResponse(expectedResponse);

    String name = "name3373707";

    QueryTemplate actualResponse = client.submitQueryTemplate(name);
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockAnalyticsHubService.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    SubmitQueryTemplateRequest actualRequest = ((SubmitQueryTemplateRequest) actualRequests.get(0));

    Assert.assertEquals(name, actualRequest.getName());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void submitQueryTemplateExceptionTest2() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockAnalyticsHubService.addException(exception);

    try {
      String name = "name3373707";
      client.submitQueryTemplate(name);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void approveQueryTemplateTest() throws Exception {
    QueryTemplate expectedResponse =
        QueryTemplate.newBuilder()
            .setName(
                QueryTemplateName.of(
                        "[PROJECT]", "[LOCATION]", "[DATA_EXCHANGE]", "[QUERY_TEMPLATE]")
                    .toString())
            .setDisplayName("displayName1714148973")
            .setDescription("description-1724546052")
            .setProposer("proposer-992842892")
            .setPrimaryContact("primaryContact-532068418")
            .setDocumentation("documentation1587405498")
            .setRoutine(Routine.newBuilder().build())
            .setCreateTime(Timestamp.newBuilder().build())
            .setUpdateTime(Timestamp.newBuilder().build())
            .build();
    mockAnalyticsHubService.addResponse(expectedResponse);

    QueryTemplateName name =
        QueryTemplateName.of("[PROJECT]", "[LOCATION]", "[DATA_EXCHANGE]", "[QUERY_TEMPLATE]");

    QueryTemplate actualResponse = client.approveQueryTemplate(name);
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockAnalyticsHubService.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    ApproveQueryTemplateRequest actualRequest =
        ((ApproveQueryTemplateRequest) actualRequests.get(0));

    Assert.assertEquals(name.toString(), actualRequest.getName());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void approveQueryTemplateExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockAnalyticsHubService.addException(exception);

    try {
      QueryTemplateName name =
          QueryTemplateName.of("[PROJECT]", "[LOCATION]", "[DATA_EXCHANGE]", "[QUERY_TEMPLATE]");
      client.approveQueryTemplate(name);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void approveQueryTemplateTest2() throws Exception {
    QueryTemplate expectedResponse =
        QueryTemplate.newBuilder()
            .setName(
                QueryTemplateName.of(
                        "[PROJECT]", "[LOCATION]", "[DATA_EXCHANGE]", "[QUERY_TEMPLATE]")
                    .toString())
            .setDisplayName("displayName1714148973")
            .setDescription("description-1724546052")
            .setProposer("proposer-992842892")
            .setPrimaryContact("primaryContact-532068418")
            .setDocumentation("documentation1587405498")
            .setRoutine(Routine.newBuilder().build())
            .setCreateTime(Timestamp.newBuilder().build())
            .setUpdateTime(Timestamp.newBuilder().build())
            .build();
    mockAnalyticsHubService.addResponse(expectedResponse);

    String name = "name3373707";

    QueryTemplate actualResponse = client.approveQueryTemplate(name);
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockAnalyticsHubService.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    ApproveQueryTemplateRequest actualRequest =
        ((ApproveQueryTemplateRequest) actualRequests.get(0));

    Assert.assertEquals(name, actualRequest.getName());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void approveQueryTemplateExceptionTest2() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockAnalyticsHubService.addException(exception);

    try {
      String name = "name3373707";
      client.approveQueryTemplate(name);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }
}
