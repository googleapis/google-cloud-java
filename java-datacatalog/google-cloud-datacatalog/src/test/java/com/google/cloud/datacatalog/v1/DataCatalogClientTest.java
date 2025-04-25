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

package com.google.cloud.datacatalog.v1;

import static com.google.cloud.datacatalog.v1.DataCatalogClient.ListEntriesPagedResponse;
import static com.google.cloud.datacatalog.v1.DataCatalogClient.ListEntryGroupsPagedResponse;
import static com.google.cloud.datacatalog.v1.DataCatalogClient.ListTagsPagedResponse;
import static com.google.cloud.datacatalog.v1.DataCatalogClient.SearchCatalogPagedResponse;

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
public class DataCatalogClientTest {
  private static MockDataCatalog mockDataCatalog;
  private static MockIAMPolicy mockIAMPolicy;
  private static MockServiceHelper mockServiceHelper;
  private LocalChannelProvider channelProvider;
  private DataCatalogClient client;

  @BeforeClass
  public static void startStaticServer() {
    mockDataCatalog = new MockDataCatalog();
    mockIAMPolicy = new MockIAMPolicy();
    mockServiceHelper =
        new MockServiceHelper(
            UUID.randomUUID().toString(),
            Arrays.<MockGrpcService>asList(mockDataCatalog, mockIAMPolicy));
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
    DataCatalogSettings settings =
        DataCatalogSettings.newBuilder()
            .setTransportChannelProvider(channelProvider)
            .setCredentialsProvider(NoCredentialsProvider.create())
            .build();
    client = DataCatalogClient.create(settings);
  }

  @After
  public void tearDown() throws Exception {
    client.close();
  }

  @Test
  public void searchCatalogTest() throws Exception {
    SearchCatalogResult responsesElement = SearchCatalogResult.newBuilder().build();
    SearchCatalogResponse expectedResponse =
        SearchCatalogResponse.newBuilder()
            .setNextPageToken("")
            .addAllResults(Arrays.asList(responsesElement))
            .build();
    mockDataCatalog.addResponse(expectedResponse);

    SearchCatalogRequest.Scope scope = SearchCatalogRequest.Scope.newBuilder().build();
    String query = "query107944136";

    SearchCatalogPagedResponse pagedListResponse = client.searchCatalog(scope, query);

    List<SearchCatalogResult> resources = Lists.newArrayList(pagedListResponse.iterateAll());

    Assert.assertEquals(1, resources.size());
    Assert.assertEquals(expectedResponse.getResultsList().get(0), resources.get(0));

    List<AbstractMessage> actualRequests = mockDataCatalog.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    SearchCatalogRequest actualRequest = ((SearchCatalogRequest) actualRequests.get(0));

    Assert.assertEquals(scope, actualRequest.getScope());
    Assert.assertEquals(query, actualRequest.getQuery());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void searchCatalogExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockDataCatalog.addException(exception);

    try {
      SearchCatalogRequest.Scope scope = SearchCatalogRequest.Scope.newBuilder().build();
      String query = "query107944136";
      client.searchCatalog(scope, query);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void createEntryGroupTest() throws Exception {
    EntryGroup expectedResponse =
        EntryGroup.newBuilder()
            .setName(EntryGroupName.of("[PROJECT]", "[LOCATION]", "[ENTRY_GROUP]").toString())
            .setDisplayName("displayName1714148973")
            .setDescription("description-1724546052")
            .setDataCatalogTimestamps(SystemTimestamps.newBuilder().build())
            .setTransferredToDataplex(true)
            .build();
    mockDataCatalog.addResponse(expectedResponse);

    LocationName parent = LocationName.of("[PROJECT]", "[LOCATION]");
    String entryGroupId = "entryGroupId1228924712";
    EntryGroup entryGroup = EntryGroup.newBuilder().build();

    EntryGroup actualResponse = client.createEntryGroup(parent, entryGroupId, entryGroup);
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockDataCatalog.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    CreateEntryGroupRequest actualRequest = ((CreateEntryGroupRequest) actualRequests.get(0));

    Assert.assertEquals(parent.toString(), actualRequest.getParent());
    Assert.assertEquals(entryGroupId, actualRequest.getEntryGroupId());
    Assert.assertEquals(entryGroup, actualRequest.getEntryGroup());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void createEntryGroupExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockDataCatalog.addException(exception);

    try {
      LocationName parent = LocationName.of("[PROJECT]", "[LOCATION]");
      String entryGroupId = "entryGroupId1228924712";
      EntryGroup entryGroup = EntryGroup.newBuilder().build();
      client.createEntryGroup(parent, entryGroupId, entryGroup);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void createEntryGroupTest2() throws Exception {
    EntryGroup expectedResponse =
        EntryGroup.newBuilder()
            .setName(EntryGroupName.of("[PROJECT]", "[LOCATION]", "[ENTRY_GROUP]").toString())
            .setDisplayName("displayName1714148973")
            .setDescription("description-1724546052")
            .setDataCatalogTimestamps(SystemTimestamps.newBuilder().build())
            .setTransferredToDataplex(true)
            .build();
    mockDataCatalog.addResponse(expectedResponse);

    String parent = "parent-995424086";
    String entryGroupId = "entryGroupId1228924712";
    EntryGroup entryGroup = EntryGroup.newBuilder().build();

    EntryGroup actualResponse = client.createEntryGroup(parent, entryGroupId, entryGroup);
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockDataCatalog.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    CreateEntryGroupRequest actualRequest = ((CreateEntryGroupRequest) actualRequests.get(0));

    Assert.assertEquals(parent, actualRequest.getParent());
    Assert.assertEquals(entryGroupId, actualRequest.getEntryGroupId());
    Assert.assertEquals(entryGroup, actualRequest.getEntryGroup());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void createEntryGroupExceptionTest2() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockDataCatalog.addException(exception);

    try {
      String parent = "parent-995424086";
      String entryGroupId = "entryGroupId1228924712";
      EntryGroup entryGroup = EntryGroup.newBuilder().build();
      client.createEntryGroup(parent, entryGroupId, entryGroup);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void getEntryGroupTest() throws Exception {
    EntryGroup expectedResponse =
        EntryGroup.newBuilder()
            .setName(EntryGroupName.of("[PROJECT]", "[LOCATION]", "[ENTRY_GROUP]").toString())
            .setDisplayName("displayName1714148973")
            .setDescription("description-1724546052")
            .setDataCatalogTimestamps(SystemTimestamps.newBuilder().build())
            .setTransferredToDataplex(true)
            .build();
    mockDataCatalog.addResponse(expectedResponse);

    EntryGroupName name = EntryGroupName.of("[PROJECT]", "[LOCATION]", "[ENTRY_GROUP]");

    EntryGroup actualResponse = client.getEntryGroup(name);
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockDataCatalog.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    GetEntryGroupRequest actualRequest = ((GetEntryGroupRequest) actualRequests.get(0));

    Assert.assertEquals(name.toString(), actualRequest.getName());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void getEntryGroupExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockDataCatalog.addException(exception);

    try {
      EntryGroupName name = EntryGroupName.of("[PROJECT]", "[LOCATION]", "[ENTRY_GROUP]");
      client.getEntryGroup(name);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void getEntryGroupTest2() throws Exception {
    EntryGroup expectedResponse =
        EntryGroup.newBuilder()
            .setName(EntryGroupName.of("[PROJECT]", "[LOCATION]", "[ENTRY_GROUP]").toString())
            .setDisplayName("displayName1714148973")
            .setDescription("description-1724546052")
            .setDataCatalogTimestamps(SystemTimestamps.newBuilder().build())
            .setTransferredToDataplex(true)
            .build();
    mockDataCatalog.addResponse(expectedResponse);

    String name = "name3373707";

    EntryGroup actualResponse = client.getEntryGroup(name);
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockDataCatalog.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    GetEntryGroupRequest actualRequest = ((GetEntryGroupRequest) actualRequests.get(0));

    Assert.assertEquals(name, actualRequest.getName());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void getEntryGroupExceptionTest2() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockDataCatalog.addException(exception);

    try {
      String name = "name3373707";
      client.getEntryGroup(name);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void getEntryGroupTest3() throws Exception {
    EntryGroup expectedResponse =
        EntryGroup.newBuilder()
            .setName(EntryGroupName.of("[PROJECT]", "[LOCATION]", "[ENTRY_GROUP]").toString())
            .setDisplayName("displayName1714148973")
            .setDescription("description-1724546052")
            .setDataCatalogTimestamps(SystemTimestamps.newBuilder().build())
            .setTransferredToDataplex(true)
            .build();
    mockDataCatalog.addResponse(expectedResponse);

    EntryGroupName name = EntryGroupName.of("[PROJECT]", "[LOCATION]", "[ENTRY_GROUP]");
    FieldMask readMask = FieldMask.newBuilder().build();

    EntryGroup actualResponse = client.getEntryGroup(name, readMask);
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockDataCatalog.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    GetEntryGroupRequest actualRequest = ((GetEntryGroupRequest) actualRequests.get(0));

    Assert.assertEquals(name.toString(), actualRequest.getName());
    Assert.assertEquals(readMask, actualRequest.getReadMask());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void getEntryGroupExceptionTest3() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockDataCatalog.addException(exception);

    try {
      EntryGroupName name = EntryGroupName.of("[PROJECT]", "[LOCATION]", "[ENTRY_GROUP]");
      FieldMask readMask = FieldMask.newBuilder().build();
      client.getEntryGroup(name, readMask);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void getEntryGroupTest4() throws Exception {
    EntryGroup expectedResponse =
        EntryGroup.newBuilder()
            .setName(EntryGroupName.of("[PROJECT]", "[LOCATION]", "[ENTRY_GROUP]").toString())
            .setDisplayName("displayName1714148973")
            .setDescription("description-1724546052")
            .setDataCatalogTimestamps(SystemTimestamps.newBuilder().build())
            .setTransferredToDataplex(true)
            .build();
    mockDataCatalog.addResponse(expectedResponse);

    String name = "name3373707";
    FieldMask readMask = FieldMask.newBuilder().build();

    EntryGroup actualResponse = client.getEntryGroup(name, readMask);
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockDataCatalog.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    GetEntryGroupRequest actualRequest = ((GetEntryGroupRequest) actualRequests.get(0));

    Assert.assertEquals(name, actualRequest.getName());
    Assert.assertEquals(readMask, actualRequest.getReadMask());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void getEntryGroupExceptionTest4() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockDataCatalog.addException(exception);

    try {
      String name = "name3373707";
      FieldMask readMask = FieldMask.newBuilder().build();
      client.getEntryGroup(name, readMask);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void updateEntryGroupTest() throws Exception {
    EntryGroup expectedResponse =
        EntryGroup.newBuilder()
            .setName(EntryGroupName.of("[PROJECT]", "[LOCATION]", "[ENTRY_GROUP]").toString())
            .setDisplayName("displayName1714148973")
            .setDescription("description-1724546052")
            .setDataCatalogTimestamps(SystemTimestamps.newBuilder().build())
            .setTransferredToDataplex(true)
            .build();
    mockDataCatalog.addResponse(expectedResponse);

    EntryGroup entryGroup = EntryGroup.newBuilder().build();

    EntryGroup actualResponse = client.updateEntryGroup(entryGroup);
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockDataCatalog.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    UpdateEntryGroupRequest actualRequest = ((UpdateEntryGroupRequest) actualRequests.get(0));

    Assert.assertEquals(entryGroup, actualRequest.getEntryGroup());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void updateEntryGroupExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockDataCatalog.addException(exception);

    try {
      EntryGroup entryGroup = EntryGroup.newBuilder().build();
      client.updateEntryGroup(entryGroup);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void updateEntryGroupTest2() throws Exception {
    EntryGroup expectedResponse =
        EntryGroup.newBuilder()
            .setName(EntryGroupName.of("[PROJECT]", "[LOCATION]", "[ENTRY_GROUP]").toString())
            .setDisplayName("displayName1714148973")
            .setDescription("description-1724546052")
            .setDataCatalogTimestamps(SystemTimestamps.newBuilder().build())
            .setTransferredToDataplex(true)
            .build();
    mockDataCatalog.addResponse(expectedResponse);

    EntryGroup entryGroup = EntryGroup.newBuilder().build();
    FieldMask updateMask = FieldMask.newBuilder().build();

    EntryGroup actualResponse = client.updateEntryGroup(entryGroup, updateMask);
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockDataCatalog.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    UpdateEntryGroupRequest actualRequest = ((UpdateEntryGroupRequest) actualRequests.get(0));

    Assert.assertEquals(entryGroup, actualRequest.getEntryGroup());
    Assert.assertEquals(updateMask, actualRequest.getUpdateMask());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void updateEntryGroupExceptionTest2() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockDataCatalog.addException(exception);

    try {
      EntryGroup entryGroup = EntryGroup.newBuilder().build();
      FieldMask updateMask = FieldMask.newBuilder().build();
      client.updateEntryGroup(entryGroup, updateMask);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void deleteEntryGroupTest() throws Exception {
    Empty expectedResponse = Empty.newBuilder().build();
    mockDataCatalog.addResponse(expectedResponse);

    EntryGroupName name = EntryGroupName.of("[PROJECT]", "[LOCATION]", "[ENTRY_GROUP]");

    client.deleteEntryGroup(name);

    List<AbstractMessage> actualRequests = mockDataCatalog.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    DeleteEntryGroupRequest actualRequest = ((DeleteEntryGroupRequest) actualRequests.get(0));

    Assert.assertEquals(name.toString(), actualRequest.getName());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void deleteEntryGroupExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockDataCatalog.addException(exception);

    try {
      EntryGroupName name = EntryGroupName.of("[PROJECT]", "[LOCATION]", "[ENTRY_GROUP]");
      client.deleteEntryGroup(name);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void deleteEntryGroupTest2() throws Exception {
    Empty expectedResponse = Empty.newBuilder().build();
    mockDataCatalog.addResponse(expectedResponse);

    String name = "name3373707";

    client.deleteEntryGroup(name);

    List<AbstractMessage> actualRequests = mockDataCatalog.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    DeleteEntryGroupRequest actualRequest = ((DeleteEntryGroupRequest) actualRequests.get(0));

    Assert.assertEquals(name, actualRequest.getName());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void deleteEntryGroupExceptionTest2() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockDataCatalog.addException(exception);

    try {
      String name = "name3373707";
      client.deleteEntryGroup(name);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void listEntryGroupsTest() throws Exception {
    EntryGroup responsesElement = EntryGroup.newBuilder().build();
    ListEntryGroupsResponse expectedResponse =
        ListEntryGroupsResponse.newBuilder()
            .setNextPageToken("")
            .addAllEntryGroups(Arrays.asList(responsesElement))
            .build();
    mockDataCatalog.addResponse(expectedResponse);

    LocationName parent = LocationName.of("[PROJECT]", "[LOCATION]");

    ListEntryGroupsPagedResponse pagedListResponse = client.listEntryGroups(parent);

    List<EntryGroup> resources = Lists.newArrayList(pagedListResponse.iterateAll());

    Assert.assertEquals(1, resources.size());
    Assert.assertEquals(expectedResponse.getEntryGroupsList().get(0), resources.get(0));

    List<AbstractMessage> actualRequests = mockDataCatalog.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    ListEntryGroupsRequest actualRequest = ((ListEntryGroupsRequest) actualRequests.get(0));

    Assert.assertEquals(parent.toString(), actualRequest.getParent());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void listEntryGroupsExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockDataCatalog.addException(exception);

    try {
      LocationName parent = LocationName.of("[PROJECT]", "[LOCATION]");
      client.listEntryGroups(parent);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void listEntryGroupsTest2() throws Exception {
    EntryGroup responsesElement = EntryGroup.newBuilder().build();
    ListEntryGroupsResponse expectedResponse =
        ListEntryGroupsResponse.newBuilder()
            .setNextPageToken("")
            .addAllEntryGroups(Arrays.asList(responsesElement))
            .build();
    mockDataCatalog.addResponse(expectedResponse);

    String parent = "parent-995424086";

    ListEntryGroupsPagedResponse pagedListResponse = client.listEntryGroups(parent);

    List<EntryGroup> resources = Lists.newArrayList(pagedListResponse.iterateAll());

    Assert.assertEquals(1, resources.size());
    Assert.assertEquals(expectedResponse.getEntryGroupsList().get(0), resources.get(0));

    List<AbstractMessage> actualRequests = mockDataCatalog.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    ListEntryGroupsRequest actualRequest = ((ListEntryGroupsRequest) actualRequests.get(0));

    Assert.assertEquals(parent, actualRequest.getParent());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void listEntryGroupsExceptionTest2() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockDataCatalog.addException(exception);

    try {
      String parent = "parent-995424086";
      client.listEntryGroups(parent);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void createEntryTest() throws Exception {
    Entry expectedResponse =
        Entry.newBuilder()
            .setName(EntryGroupName.of("[PROJECT]", "[LOCATION]", "[ENTRY_GROUP]").toString())
            .setLinkedResource("linkedResource-495606457")
            .setFullyQualifiedName("fullyQualifiedName288467357")
            .setDisplayName("displayName1714148973")
            .setDescription("description-1724546052")
            .setBusinessContext(BusinessContext.newBuilder().build())
            .setSchema(Schema.newBuilder().build())
            .setSourceSystemTimestamps(SystemTimestamps.newBuilder().build())
            .setUsageSignal(UsageSignal.newBuilder().build())
            .putAllLabels(new HashMap<String, String>())
            .setDataSource(DataSource.newBuilder().build())
            .setPersonalDetails(PersonalDetails.newBuilder().build())
            .build();
    mockDataCatalog.addResponse(expectedResponse);

    EntryGroupName parent = EntryGroupName.of("[PROJECT]", "[LOCATION]", "[ENTRY_GROUP]");
    String entryId = "entryId-1591558867";
    Entry entry = Entry.newBuilder().build();

    Entry actualResponse = client.createEntry(parent, entryId, entry);
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockDataCatalog.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    CreateEntryRequest actualRequest = ((CreateEntryRequest) actualRequests.get(0));

    Assert.assertEquals(parent.toString(), actualRequest.getParent());
    Assert.assertEquals(entryId, actualRequest.getEntryId());
    Assert.assertEquals(entry, actualRequest.getEntry());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void createEntryExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockDataCatalog.addException(exception);

    try {
      EntryGroupName parent = EntryGroupName.of("[PROJECT]", "[LOCATION]", "[ENTRY_GROUP]");
      String entryId = "entryId-1591558867";
      Entry entry = Entry.newBuilder().build();
      client.createEntry(parent, entryId, entry);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void createEntryTest2() throws Exception {
    Entry expectedResponse =
        Entry.newBuilder()
            .setName(EntryGroupName.of("[PROJECT]", "[LOCATION]", "[ENTRY_GROUP]").toString())
            .setLinkedResource("linkedResource-495606457")
            .setFullyQualifiedName("fullyQualifiedName288467357")
            .setDisplayName("displayName1714148973")
            .setDescription("description-1724546052")
            .setBusinessContext(BusinessContext.newBuilder().build())
            .setSchema(Schema.newBuilder().build())
            .setSourceSystemTimestamps(SystemTimestamps.newBuilder().build())
            .setUsageSignal(UsageSignal.newBuilder().build())
            .putAllLabels(new HashMap<String, String>())
            .setDataSource(DataSource.newBuilder().build())
            .setPersonalDetails(PersonalDetails.newBuilder().build())
            .build();
    mockDataCatalog.addResponse(expectedResponse);

    String parent = "parent-995424086";
    String entryId = "entryId-1591558867";
    Entry entry = Entry.newBuilder().build();

    Entry actualResponse = client.createEntry(parent, entryId, entry);
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockDataCatalog.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    CreateEntryRequest actualRequest = ((CreateEntryRequest) actualRequests.get(0));

    Assert.assertEquals(parent, actualRequest.getParent());
    Assert.assertEquals(entryId, actualRequest.getEntryId());
    Assert.assertEquals(entry, actualRequest.getEntry());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void createEntryExceptionTest2() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockDataCatalog.addException(exception);

    try {
      String parent = "parent-995424086";
      String entryId = "entryId-1591558867";
      Entry entry = Entry.newBuilder().build();
      client.createEntry(parent, entryId, entry);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void updateEntryTest() throws Exception {
    Entry expectedResponse =
        Entry.newBuilder()
            .setName(EntryGroupName.of("[PROJECT]", "[LOCATION]", "[ENTRY_GROUP]").toString())
            .setLinkedResource("linkedResource-495606457")
            .setFullyQualifiedName("fullyQualifiedName288467357")
            .setDisplayName("displayName1714148973")
            .setDescription("description-1724546052")
            .setBusinessContext(BusinessContext.newBuilder().build())
            .setSchema(Schema.newBuilder().build())
            .setSourceSystemTimestamps(SystemTimestamps.newBuilder().build())
            .setUsageSignal(UsageSignal.newBuilder().build())
            .putAllLabels(new HashMap<String, String>())
            .setDataSource(DataSource.newBuilder().build())
            .setPersonalDetails(PersonalDetails.newBuilder().build())
            .build();
    mockDataCatalog.addResponse(expectedResponse);

    Entry entry = Entry.newBuilder().build();

    Entry actualResponse = client.updateEntry(entry);
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockDataCatalog.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    UpdateEntryRequest actualRequest = ((UpdateEntryRequest) actualRequests.get(0));

    Assert.assertEquals(entry, actualRequest.getEntry());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void updateEntryExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockDataCatalog.addException(exception);

    try {
      Entry entry = Entry.newBuilder().build();
      client.updateEntry(entry);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void updateEntryTest2() throws Exception {
    Entry expectedResponse =
        Entry.newBuilder()
            .setName(EntryGroupName.of("[PROJECT]", "[LOCATION]", "[ENTRY_GROUP]").toString())
            .setLinkedResource("linkedResource-495606457")
            .setFullyQualifiedName("fullyQualifiedName288467357")
            .setDisplayName("displayName1714148973")
            .setDescription("description-1724546052")
            .setBusinessContext(BusinessContext.newBuilder().build())
            .setSchema(Schema.newBuilder().build())
            .setSourceSystemTimestamps(SystemTimestamps.newBuilder().build())
            .setUsageSignal(UsageSignal.newBuilder().build())
            .putAllLabels(new HashMap<String, String>())
            .setDataSource(DataSource.newBuilder().build())
            .setPersonalDetails(PersonalDetails.newBuilder().build())
            .build();
    mockDataCatalog.addResponse(expectedResponse);

    Entry entry = Entry.newBuilder().build();
    FieldMask updateMask = FieldMask.newBuilder().build();

    Entry actualResponse = client.updateEntry(entry, updateMask);
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockDataCatalog.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    UpdateEntryRequest actualRequest = ((UpdateEntryRequest) actualRequests.get(0));

    Assert.assertEquals(entry, actualRequest.getEntry());
    Assert.assertEquals(updateMask, actualRequest.getUpdateMask());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void updateEntryExceptionTest2() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockDataCatalog.addException(exception);

    try {
      Entry entry = Entry.newBuilder().build();
      FieldMask updateMask = FieldMask.newBuilder().build();
      client.updateEntry(entry, updateMask);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void deleteEntryTest() throws Exception {
    Empty expectedResponse = Empty.newBuilder().build();
    mockDataCatalog.addResponse(expectedResponse);

    EntryName name = EntryName.of("[PROJECT]", "[LOCATION]", "[ENTRY_GROUP]", "[ENTRY]");

    client.deleteEntry(name);

    List<AbstractMessage> actualRequests = mockDataCatalog.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    DeleteEntryRequest actualRequest = ((DeleteEntryRequest) actualRequests.get(0));

    Assert.assertEquals(name.toString(), actualRequest.getName());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void deleteEntryExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockDataCatalog.addException(exception);

    try {
      EntryName name = EntryName.of("[PROJECT]", "[LOCATION]", "[ENTRY_GROUP]", "[ENTRY]");
      client.deleteEntry(name);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void deleteEntryTest2() throws Exception {
    Empty expectedResponse = Empty.newBuilder().build();
    mockDataCatalog.addResponse(expectedResponse);

    String name = "name3373707";

    client.deleteEntry(name);

    List<AbstractMessage> actualRequests = mockDataCatalog.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    DeleteEntryRequest actualRequest = ((DeleteEntryRequest) actualRequests.get(0));

    Assert.assertEquals(name, actualRequest.getName());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void deleteEntryExceptionTest2() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockDataCatalog.addException(exception);

    try {
      String name = "name3373707";
      client.deleteEntry(name);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void getEntryTest() throws Exception {
    Entry expectedResponse =
        Entry.newBuilder()
            .setName(EntryGroupName.of("[PROJECT]", "[LOCATION]", "[ENTRY_GROUP]").toString())
            .setLinkedResource("linkedResource-495606457")
            .setFullyQualifiedName("fullyQualifiedName288467357")
            .setDisplayName("displayName1714148973")
            .setDescription("description-1724546052")
            .setBusinessContext(BusinessContext.newBuilder().build())
            .setSchema(Schema.newBuilder().build())
            .setSourceSystemTimestamps(SystemTimestamps.newBuilder().build())
            .setUsageSignal(UsageSignal.newBuilder().build())
            .putAllLabels(new HashMap<String, String>())
            .setDataSource(DataSource.newBuilder().build())
            .setPersonalDetails(PersonalDetails.newBuilder().build())
            .build();
    mockDataCatalog.addResponse(expectedResponse);

    EntryName name = EntryName.of("[PROJECT]", "[LOCATION]", "[ENTRY_GROUP]", "[ENTRY]");

    Entry actualResponse = client.getEntry(name);
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockDataCatalog.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    GetEntryRequest actualRequest = ((GetEntryRequest) actualRequests.get(0));

    Assert.assertEquals(name.toString(), actualRequest.getName());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void getEntryExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockDataCatalog.addException(exception);

    try {
      EntryName name = EntryName.of("[PROJECT]", "[LOCATION]", "[ENTRY_GROUP]", "[ENTRY]");
      client.getEntry(name);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void getEntryTest2() throws Exception {
    Entry expectedResponse =
        Entry.newBuilder()
            .setName(EntryGroupName.of("[PROJECT]", "[LOCATION]", "[ENTRY_GROUP]").toString())
            .setLinkedResource("linkedResource-495606457")
            .setFullyQualifiedName("fullyQualifiedName288467357")
            .setDisplayName("displayName1714148973")
            .setDescription("description-1724546052")
            .setBusinessContext(BusinessContext.newBuilder().build())
            .setSchema(Schema.newBuilder().build())
            .setSourceSystemTimestamps(SystemTimestamps.newBuilder().build())
            .setUsageSignal(UsageSignal.newBuilder().build())
            .putAllLabels(new HashMap<String, String>())
            .setDataSource(DataSource.newBuilder().build())
            .setPersonalDetails(PersonalDetails.newBuilder().build())
            .build();
    mockDataCatalog.addResponse(expectedResponse);

    String name = "name3373707";

    Entry actualResponse = client.getEntry(name);
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockDataCatalog.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    GetEntryRequest actualRequest = ((GetEntryRequest) actualRequests.get(0));

    Assert.assertEquals(name, actualRequest.getName());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void getEntryExceptionTest2() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockDataCatalog.addException(exception);

    try {
      String name = "name3373707";
      client.getEntry(name);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void lookupEntryTest() throws Exception {
    Entry expectedResponse =
        Entry.newBuilder()
            .setName(EntryGroupName.of("[PROJECT]", "[LOCATION]", "[ENTRY_GROUP]").toString())
            .setLinkedResource("linkedResource-495606457")
            .setFullyQualifiedName("fullyQualifiedName288467357")
            .setDisplayName("displayName1714148973")
            .setDescription("description-1724546052")
            .setBusinessContext(BusinessContext.newBuilder().build())
            .setSchema(Schema.newBuilder().build())
            .setSourceSystemTimestamps(SystemTimestamps.newBuilder().build())
            .setUsageSignal(UsageSignal.newBuilder().build())
            .putAllLabels(new HashMap<String, String>())
            .setDataSource(DataSource.newBuilder().build())
            .setPersonalDetails(PersonalDetails.newBuilder().build())
            .build();
    mockDataCatalog.addResponse(expectedResponse);

    LookupEntryRequest request =
        LookupEntryRequest.newBuilder()
            .setProject("project-309310695")
            .setLocation("location1901043637")
            .build();

    Entry actualResponse = client.lookupEntry(request);
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockDataCatalog.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    LookupEntryRequest actualRequest = ((LookupEntryRequest) actualRequests.get(0));

    Assert.assertEquals(request.getLinkedResource(), actualRequest.getLinkedResource());
    Assert.assertEquals(request.getSqlResource(), actualRequest.getSqlResource());
    Assert.assertEquals(request.getFullyQualifiedName(), actualRequest.getFullyQualifiedName());
    Assert.assertEquals(request.getProject(), actualRequest.getProject());
    Assert.assertEquals(request.getLocation(), actualRequest.getLocation());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void lookupEntryExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockDataCatalog.addException(exception);

    try {
      LookupEntryRequest request =
          LookupEntryRequest.newBuilder()
              .setProject("project-309310695")
              .setLocation("location1901043637")
              .build();
      client.lookupEntry(request);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void listEntriesTest() throws Exception {
    Entry responsesElement = Entry.newBuilder().build();
    ListEntriesResponse expectedResponse =
        ListEntriesResponse.newBuilder()
            .setNextPageToken("")
            .addAllEntries(Arrays.asList(responsesElement))
            .build();
    mockDataCatalog.addResponse(expectedResponse);

    EntryGroupName parent = EntryGroupName.of("[PROJECT]", "[LOCATION]", "[ENTRY_GROUP]");

    ListEntriesPagedResponse pagedListResponse = client.listEntries(parent);

    List<Entry> resources = Lists.newArrayList(pagedListResponse.iterateAll());

    Assert.assertEquals(1, resources.size());
    Assert.assertEquals(expectedResponse.getEntriesList().get(0), resources.get(0));

    List<AbstractMessage> actualRequests = mockDataCatalog.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    ListEntriesRequest actualRequest = ((ListEntriesRequest) actualRequests.get(0));

    Assert.assertEquals(parent.toString(), actualRequest.getParent());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void listEntriesExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockDataCatalog.addException(exception);

    try {
      EntryGroupName parent = EntryGroupName.of("[PROJECT]", "[LOCATION]", "[ENTRY_GROUP]");
      client.listEntries(parent);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void listEntriesTest2() throws Exception {
    Entry responsesElement = Entry.newBuilder().build();
    ListEntriesResponse expectedResponse =
        ListEntriesResponse.newBuilder()
            .setNextPageToken("")
            .addAllEntries(Arrays.asList(responsesElement))
            .build();
    mockDataCatalog.addResponse(expectedResponse);

    String parent = "parent-995424086";

    ListEntriesPagedResponse pagedListResponse = client.listEntries(parent);

    List<Entry> resources = Lists.newArrayList(pagedListResponse.iterateAll());

    Assert.assertEquals(1, resources.size());
    Assert.assertEquals(expectedResponse.getEntriesList().get(0), resources.get(0));

    List<AbstractMessage> actualRequests = mockDataCatalog.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    ListEntriesRequest actualRequest = ((ListEntriesRequest) actualRequests.get(0));

    Assert.assertEquals(parent, actualRequest.getParent());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void listEntriesExceptionTest2() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockDataCatalog.addException(exception);

    try {
      String parent = "parent-995424086";
      client.listEntries(parent);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void modifyEntryOverviewTest() throws Exception {
    EntryOverview expectedResponse =
        EntryOverview.newBuilder().setOverview("overview530115961").build();
    mockDataCatalog.addResponse(expectedResponse);

    ModifyEntryOverviewRequest request =
        ModifyEntryOverviewRequest.newBuilder()
            .setName(EntryName.of("[PROJECT]", "[LOCATION]", "[ENTRY_GROUP]", "[ENTRY]").toString())
            .setEntryOverview(EntryOverview.newBuilder().build())
            .build();

    EntryOverview actualResponse = client.modifyEntryOverview(request);
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockDataCatalog.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    ModifyEntryOverviewRequest actualRequest = ((ModifyEntryOverviewRequest) actualRequests.get(0));

    Assert.assertEquals(request.getName(), actualRequest.getName());
    Assert.assertEquals(request.getEntryOverview(), actualRequest.getEntryOverview());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void modifyEntryOverviewExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockDataCatalog.addException(exception);

    try {
      ModifyEntryOverviewRequest request =
          ModifyEntryOverviewRequest.newBuilder()
              .setName(
                  EntryName.of("[PROJECT]", "[LOCATION]", "[ENTRY_GROUP]", "[ENTRY]").toString())
              .setEntryOverview(EntryOverview.newBuilder().build())
              .build();
      client.modifyEntryOverview(request);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void modifyEntryContactsTest() throws Exception {
    Contacts expectedResponse =
        Contacts.newBuilder().addAllPeople(new ArrayList<Contacts.Person>()).build();
    mockDataCatalog.addResponse(expectedResponse);

    ModifyEntryContactsRequest request =
        ModifyEntryContactsRequest.newBuilder()
            .setName(EntryName.of("[PROJECT]", "[LOCATION]", "[ENTRY_GROUP]", "[ENTRY]").toString())
            .setContacts(Contacts.newBuilder().build())
            .build();

    Contacts actualResponse = client.modifyEntryContacts(request);
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockDataCatalog.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    ModifyEntryContactsRequest actualRequest = ((ModifyEntryContactsRequest) actualRequests.get(0));

    Assert.assertEquals(request.getName(), actualRequest.getName());
    Assert.assertEquals(request.getContacts(), actualRequest.getContacts());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void modifyEntryContactsExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockDataCatalog.addException(exception);

    try {
      ModifyEntryContactsRequest request =
          ModifyEntryContactsRequest.newBuilder()
              .setName(
                  EntryName.of("[PROJECT]", "[LOCATION]", "[ENTRY_GROUP]", "[ENTRY]").toString())
              .setContacts(Contacts.newBuilder().build())
              .build();
      client.modifyEntryContacts(request);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void createTagTemplateTest() throws Exception {
    TagTemplate expectedResponse =
        TagTemplate.newBuilder()
            .setName(TagTemplateName.of("[PROJECT]", "[LOCATION]", "[TAG_TEMPLATE]").toString())
            .setDisplayName("displayName1714148973")
            .setIsPubliclyReadable(true)
            .putAllFields(new HashMap<String, TagTemplateField>())
            .build();
    mockDataCatalog.addResponse(expectedResponse);

    LocationName parent = LocationName.of("[PROJECT]", "[LOCATION]");
    String tagTemplateId = "tagTemplateId-1438776721";
    TagTemplate tagTemplate = TagTemplate.newBuilder().build();

    TagTemplate actualResponse = client.createTagTemplate(parent, tagTemplateId, tagTemplate);
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockDataCatalog.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    CreateTagTemplateRequest actualRequest = ((CreateTagTemplateRequest) actualRequests.get(0));

    Assert.assertEquals(parent.toString(), actualRequest.getParent());
    Assert.assertEquals(tagTemplateId, actualRequest.getTagTemplateId());
    Assert.assertEquals(tagTemplate, actualRequest.getTagTemplate());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void createTagTemplateExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockDataCatalog.addException(exception);

    try {
      LocationName parent = LocationName.of("[PROJECT]", "[LOCATION]");
      String tagTemplateId = "tagTemplateId-1438776721";
      TagTemplate tagTemplate = TagTemplate.newBuilder().build();
      client.createTagTemplate(parent, tagTemplateId, tagTemplate);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void createTagTemplateTest2() throws Exception {
    TagTemplate expectedResponse =
        TagTemplate.newBuilder()
            .setName(TagTemplateName.of("[PROJECT]", "[LOCATION]", "[TAG_TEMPLATE]").toString())
            .setDisplayName("displayName1714148973")
            .setIsPubliclyReadable(true)
            .putAllFields(new HashMap<String, TagTemplateField>())
            .build();
    mockDataCatalog.addResponse(expectedResponse);

    String parent = "parent-995424086";
    String tagTemplateId = "tagTemplateId-1438776721";
    TagTemplate tagTemplate = TagTemplate.newBuilder().build();

    TagTemplate actualResponse = client.createTagTemplate(parent, tagTemplateId, tagTemplate);
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockDataCatalog.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    CreateTagTemplateRequest actualRequest = ((CreateTagTemplateRequest) actualRequests.get(0));

    Assert.assertEquals(parent, actualRequest.getParent());
    Assert.assertEquals(tagTemplateId, actualRequest.getTagTemplateId());
    Assert.assertEquals(tagTemplate, actualRequest.getTagTemplate());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void createTagTemplateExceptionTest2() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockDataCatalog.addException(exception);

    try {
      String parent = "parent-995424086";
      String tagTemplateId = "tagTemplateId-1438776721";
      TagTemplate tagTemplate = TagTemplate.newBuilder().build();
      client.createTagTemplate(parent, tagTemplateId, tagTemplate);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void getTagTemplateTest() throws Exception {
    TagTemplate expectedResponse =
        TagTemplate.newBuilder()
            .setName(TagTemplateName.of("[PROJECT]", "[LOCATION]", "[TAG_TEMPLATE]").toString())
            .setDisplayName("displayName1714148973")
            .setIsPubliclyReadable(true)
            .putAllFields(new HashMap<String, TagTemplateField>())
            .build();
    mockDataCatalog.addResponse(expectedResponse);

    TagTemplateName name = TagTemplateName.of("[PROJECT]", "[LOCATION]", "[TAG_TEMPLATE]");

    TagTemplate actualResponse = client.getTagTemplate(name);
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockDataCatalog.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    GetTagTemplateRequest actualRequest = ((GetTagTemplateRequest) actualRequests.get(0));

    Assert.assertEquals(name.toString(), actualRequest.getName());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void getTagTemplateExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockDataCatalog.addException(exception);

    try {
      TagTemplateName name = TagTemplateName.of("[PROJECT]", "[LOCATION]", "[TAG_TEMPLATE]");
      client.getTagTemplate(name);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void getTagTemplateTest2() throws Exception {
    TagTemplate expectedResponse =
        TagTemplate.newBuilder()
            .setName(TagTemplateName.of("[PROJECT]", "[LOCATION]", "[TAG_TEMPLATE]").toString())
            .setDisplayName("displayName1714148973")
            .setIsPubliclyReadable(true)
            .putAllFields(new HashMap<String, TagTemplateField>())
            .build();
    mockDataCatalog.addResponse(expectedResponse);

    String name = "name3373707";

    TagTemplate actualResponse = client.getTagTemplate(name);
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockDataCatalog.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    GetTagTemplateRequest actualRequest = ((GetTagTemplateRequest) actualRequests.get(0));

    Assert.assertEquals(name, actualRequest.getName());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void getTagTemplateExceptionTest2() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockDataCatalog.addException(exception);

    try {
      String name = "name3373707";
      client.getTagTemplate(name);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void updateTagTemplateTest() throws Exception {
    TagTemplate expectedResponse =
        TagTemplate.newBuilder()
            .setName(TagTemplateName.of("[PROJECT]", "[LOCATION]", "[TAG_TEMPLATE]").toString())
            .setDisplayName("displayName1714148973")
            .setIsPubliclyReadable(true)
            .putAllFields(new HashMap<String, TagTemplateField>())
            .build();
    mockDataCatalog.addResponse(expectedResponse);

    TagTemplate tagTemplate = TagTemplate.newBuilder().build();

    TagTemplate actualResponse = client.updateTagTemplate(tagTemplate);
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockDataCatalog.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    UpdateTagTemplateRequest actualRequest = ((UpdateTagTemplateRequest) actualRequests.get(0));

    Assert.assertEquals(tagTemplate, actualRequest.getTagTemplate());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void updateTagTemplateExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockDataCatalog.addException(exception);

    try {
      TagTemplate tagTemplate = TagTemplate.newBuilder().build();
      client.updateTagTemplate(tagTemplate);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void updateTagTemplateTest2() throws Exception {
    TagTemplate expectedResponse =
        TagTemplate.newBuilder()
            .setName(TagTemplateName.of("[PROJECT]", "[LOCATION]", "[TAG_TEMPLATE]").toString())
            .setDisplayName("displayName1714148973")
            .setIsPubliclyReadable(true)
            .putAllFields(new HashMap<String, TagTemplateField>())
            .build();
    mockDataCatalog.addResponse(expectedResponse);

    TagTemplate tagTemplate = TagTemplate.newBuilder().build();
    FieldMask updateMask = FieldMask.newBuilder().build();

    TagTemplate actualResponse = client.updateTagTemplate(tagTemplate, updateMask);
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockDataCatalog.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    UpdateTagTemplateRequest actualRequest = ((UpdateTagTemplateRequest) actualRequests.get(0));

    Assert.assertEquals(tagTemplate, actualRequest.getTagTemplate());
    Assert.assertEquals(updateMask, actualRequest.getUpdateMask());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void updateTagTemplateExceptionTest2() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockDataCatalog.addException(exception);

    try {
      TagTemplate tagTemplate = TagTemplate.newBuilder().build();
      FieldMask updateMask = FieldMask.newBuilder().build();
      client.updateTagTemplate(tagTemplate, updateMask);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void deleteTagTemplateTest() throws Exception {
    Empty expectedResponse = Empty.newBuilder().build();
    mockDataCatalog.addResponse(expectedResponse);

    TagTemplateName name = TagTemplateName.of("[PROJECT]", "[LOCATION]", "[TAG_TEMPLATE]");
    boolean force = true;

    client.deleteTagTemplate(name, force);

    List<AbstractMessage> actualRequests = mockDataCatalog.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    DeleteTagTemplateRequest actualRequest = ((DeleteTagTemplateRequest) actualRequests.get(0));

    Assert.assertEquals(name.toString(), actualRequest.getName());
    Assert.assertEquals(force, actualRequest.getForce());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void deleteTagTemplateExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockDataCatalog.addException(exception);

    try {
      TagTemplateName name = TagTemplateName.of("[PROJECT]", "[LOCATION]", "[TAG_TEMPLATE]");
      boolean force = true;
      client.deleteTagTemplate(name, force);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void deleteTagTemplateTest2() throws Exception {
    Empty expectedResponse = Empty.newBuilder().build();
    mockDataCatalog.addResponse(expectedResponse);

    String name = "name3373707";
    boolean force = true;

    client.deleteTagTemplate(name, force);

    List<AbstractMessage> actualRequests = mockDataCatalog.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    DeleteTagTemplateRequest actualRequest = ((DeleteTagTemplateRequest) actualRequests.get(0));

    Assert.assertEquals(name, actualRequest.getName());
    Assert.assertEquals(force, actualRequest.getForce());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void deleteTagTemplateExceptionTest2() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockDataCatalog.addException(exception);

    try {
      String name = "name3373707";
      boolean force = true;
      client.deleteTagTemplate(name, force);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void createTagTemplateFieldTest() throws Exception {
    TagTemplateField expectedResponse =
        TagTemplateField.newBuilder()
            .setName(
                TagTemplateFieldName.of("[PROJECT]", "[LOCATION]", "[TAG_TEMPLATE]", "[FIELD]")
                    .toString())
            .setDisplayName("displayName1714148973")
            .setType(FieldType.newBuilder().build())
            .setIsRequired(true)
            .setDescription("description-1724546052")
            .setOrder(106006350)
            .build();
    mockDataCatalog.addResponse(expectedResponse);

    TagTemplateName parent = TagTemplateName.of("[PROJECT]", "[LOCATION]", "[TAG_TEMPLATE]");
    String tagTemplateFieldId = "tagTemplateFieldId-1556835615";
    TagTemplateField tagTemplateField = TagTemplateField.newBuilder().build();

    TagTemplateField actualResponse =
        client.createTagTemplateField(parent, tagTemplateFieldId, tagTemplateField);
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockDataCatalog.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    CreateTagTemplateFieldRequest actualRequest =
        ((CreateTagTemplateFieldRequest) actualRequests.get(0));

    Assert.assertEquals(parent.toString(), actualRequest.getParent());
    Assert.assertEquals(tagTemplateFieldId, actualRequest.getTagTemplateFieldId());
    Assert.assertEquals(tagTemplateField, actualRequest.getTagTemplateField());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void createTagTemplateFieldExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockDataCatalog.addException(exception);

    try {
      TagTemplateName parent = TagTemplateName.of("[PROJECT]", "[LOCATION]", "[TAG_TEMPLATE]");
      String tagTemplateFieldId = "tagTemplateFieldId-1556835615";
      TagTemplateField tagTemplateField = TagTemplateField.newBuilder().build();
      client.createTagTemplateField(parent, tagTemplateFieldId, tagTemplateField);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void createTagTemplateFieldTest2() throws Exception {
    TagTemplateField expectedResponse =
        TagTemplateField.newBuilder()
            .setName(
                TagTemplateFieldName.of("[PROJECT]", "[LOCATION]", "[TAG_TEMPLATE]", "[FIELD]")
                    .toString())
            .setDisplayName("displayName1714148973")
            .setType(FieldType.newBuilder().build())
            .setIsRequired(true)
            .setDescription("description-1724546052")
            .setOrder(106006350)
            .build();
    mockDataCatalog.addResponse(expectedResponse);

    String parent = "parent-995424086";
    String tagTemplateFieldId = "tagTemplateFieldId-1556835615";
    TagTemplateField tagTemplateField = TagTemplateField.newBuilder().build();

    TagTemplateField actualResponse =
        client.createTagTemplateField(parent, tagTemplateFieldId, tagTemplateField);
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockDataCatalog.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    CreateTagTemplateFieldRequest actualRequest =
        ((CreateTagTemplateFieldRequest) actualRequests.get(0));

    Assert.assertEquals(parent, actualRequest.getParent());
    Assert.assertEquals(tagTemplateFieldId, actualRequest.getTagTemplateFieldId());
    Assert.assertEquals(tagTemplateField, actualRequest.getTagTemplateField());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void createTagTemplateFieldExceptionTest2() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockDataCatalog.addException(exception);

    try {
      String parent = "parent-995424086";
      String tagTemplateFieldId = "tagTemplateFieldId-1556835615";
      TagTemplateField tagTemplateField = TagTemplateField.newBuilder().build();
      client.createTagTemplateField(parent, tagTemplateFieldId, tagTemplateField);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void updateTagTemplateFieldTest() throws Exception {
    TagTemplateField expectedResponse =
        TagTemplateField.newBuilder()
            .setName(
                TagTemplateFieldName.of("[PROJECT]", "[LOCATION]", "[TAG_TEMPLATE]", "[FIELD]")
                    .toString())
            .setDisplayName("displayName1714148973")
            .setType(FieldType.newBuilder().build())
            .setIsRequired(true)
            .setDescription("description-1724546052")
            .setOrder(106006350)
            .build();
    mockDataCatalog.addResponse(expectedResponse);

    TagTemplateFieldName name =
        TagTemplateFieldName.of("[PROJECT]", "[LOCATION]", "[TAG_TEMPLATE]", "[FIELD]");
    TagTemplateField tagTemplateField = TagTemplateField.newBuilder().build();

    TagTemplateField actualResponse = client.updateTagTemplateField(name, tagTemplateField);
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockDataCatalog.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    UpdateTagTemplateFieldRequest actualRequest =
        ((UpdateTagTemplateFieldRequest) actualRequests.get(0));

    Assert.assertEquals(name.toString(), actualRequest.getName());
    Assert.assertEquals(tagTemplateField, actualRequest.getTagTemplateField());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void updateTagTemplateFieldExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockDataCatalog.addException(exception);

    try {
      TagTemplateFieldName name =
          TagTemplateFieldName.of("[PROJECT]", "[LOCATION]", "[TAG_TEMPLATE]", "[FIELD]");
      TagTemplateField tagTemplateField = TagTemplateField.newBuilder().build();
      client.updateTagTemplateField(name, tagTemplateField);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void updateTagTemplateFieldTest2() throws Exception {
    TagTemplateField expectedResponse =
        TagTemplateField.newBuilder()
            .setName(
                TagTemplateFieldName.of("[PROJECT]", "[LOCATION]", "[TAG_TEMPLATE]", "[FIELD]")
                    .toString())
            .setDisplayName("displayName1714148973")
            .setType(FieldType.newBuilder().build())
            .setIsRequired(true)
            .setDescription("description-1724546052")
            .setOrder(106006350)
            .build();
    mockDataCatalog.addResponse(expectedResponse);

    String name = "name3373707";
    TagTemplateField tagTemplateField = TagTemplateField.newBuilder().build();

    TagTemplateField actualResponse = client.updateTagTemplateField(name, tagTemplateField);
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockDataCatalog.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    UpdateTagTemplateFieldRequest actualRequest =
        ((UpdateTagTemplateFieldRequest) actualRequests.get(0));

    Assert.assertEquals(name, actualRequest.getName());
    Assert.assertEquals(tagTemplateField, actualRequest.getTagTemplateField());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void updateTagTemplateFieldExceptionTest2() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockDataCatalog.addException(exception);

    try {
      String name = "name3373707";
      TagTemplateField tagTemplateField = TagTemplateField.newBuilder().build();
      client.updateTagTemplateField(name, tagTemplateField);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void updateTagTemplateFieldTest3() throws Exception {
    TagTemplateField expectedResponse =
        TagTemplateField.newBuilder()
            .setName(
                TagTemplateFieldName.of("[PROJECT]", "[LOCATION]", "[TAG_TEMPLATE]", "[FIELD]")
                    .toString())
            .setDisplayName("displayName1714148973")
            .setType(FieldType.newBuilder().build())
            .setIsRequired(true)
            .setDescription("description-1724546052")
            .setOrder(106006350)
            .build();
    mockDataCatalog.addResponse(expectedResponse);

    TagTemplateFieldName name =
        TagTemplateFieldName.of("[PROJECT]", "[LOCATION]", "[TAG_TEMPLATE]", "[FIELD]");
    TagTemplateField tagTemplateField = TagTemplateField.newBuilder().build();
    FieldMask updateMask = FieldMask.newBuilder().build();

    TagTemplateField actualResponse =
        client.updateTagTemplateField(name, tagTemplateField, updateMask);
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockDataCatalog.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    UpdateTagTemplateFieldRequest actualRequest =
        ((UpdateTagTemplateFieldRequest) actualRequests.get(0));

    Assert.assertEquals(name.toString(), actualRequest.getName());
    Assert.assertEquals(tagTemplateField, actualRequest.getTagTemplateField());
    Assert.assertEquals(updateMask, actualRequest.getUpdateMask());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void updateTagTemplateFieldExceptionTest3() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockDataCatalog.addException(exception);

    try {
      TagTemplateFieldName name =
          TagTemplateFieldName.of("[PROJECT]", "[LOCATION]", "[TAG_TEMPLATE]", "[FIELD]");
      TagTemplateField tagTemplateField = TagTemplateField.newBuilder().build();
      FieldMask updateMask = FieldMask.newBuilder().build();
      client.updateTagTemplateField(name, tagTemplateField, updateMask);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void updateTagTemplateFieldTest4() throws Exception {
    TagTemplateField expectedResponse =
        TagTemplateField.newBuilder()
            .setName(
                TagTemplateFieldName.of("[PROJECT]", "[LOCATION]", "[TAG_TEMPLATE]", "[FIELD]")
                    .toString())
            .setDisplayName("displayName1714148973")
            .setType(FieldType.newBuilder().build())
            .setIsRequired(true)
            .setDescription("description-1724546052")
            .setOrder(106006350)
            .build();
    mockDataCatalog.addResponse(expectedResponse);

    String name = "name3373707";
    TagTemplateField tagTemplateField = TagTemplateField.newBuilder().build();
    FieldMask updateMask = FieldMask.newBuilder().build();

    TagTemplateField actualResponse =
        client.updateTagTemplateField(name, tagTemplateField, updateMask);
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockDataCatalog.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    UpdateTagTemplateFieldRequest actualRequest =
        ((UpdateTagTemplateFieldRequest) actualRequests.get(0));

    Assert.assertEquals(name, actualRequest.getName());
    Assert.assertEquals(tagTemplateField, actualRequest.getTagTemplateField());
    Assert.assertEquals(updateMask, actualRequest.getUpdateMask());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void updateTagTemplateFieldExceptionTest4() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockDataCatalog.addException(exception);

    try {
      String name = "name3373707";
      TagTemplateField tagTemplateField = TagTemplateField.newBuilder().build();
      FieldMask updateMask = FieldMask.newBuilder().build();
      client.updateTagTemplateField(name, tagTemplateField, updateMask);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void renameTagTemplateFieldTest() throws Exception {
    TagTemplateField expectedResponse =
        TagTemplateField.newBuilder()
            .setName(
                TagTemplateFieldName.of("[PROJECT]", "[LOCATION]", "[TAG_TEMPLATE]", "[FIELD]")
                    .toString())
            .setDisplayName("displayName1714148973")
            .setType(FieldType.newBuilder().build())
            .setIsRequired(true)
            .setDescription("description-1724546052")
            .setOrder(106006350)
            .build();
    mockDataCatalog.addResponse(expectedResponse);

    TagTemplateFieldName name =
        TagTemplateFieldName.of("[PROJECT]", "[LOCATION]", "[TAG_TEMPLATE]", "[FIELD]");
    String newTagTemplateFieldId = "newTagTemplateFieldId2008993953";

    TagTemplateField actualResponse = client.renameTagTemplateField(name, newTagTemplateFieldId);
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockDataCatalog.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    RenameTagTemplateFieldRequest actualRequest =
        ((RenameTagTemplateFieldRequest) actualRequests.get(0));

    Assert.assertEquals(name.toString(), actualRequest.getName());
    Assert.assertEquals(newTagTemplateFieldId, actualRequest.getNewTagTemplateFieldId());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void renameTagTemplateFieldExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockDataCatalog.addException(exception);

    try {
      TagTemplateFieldName name =
          TagTemplateFieldName.of("[PROJECT]", "[LOCATION]", "[TAG_TEMPLATE]", "[FIELD]");
      String newTagTemplateFieldId = "newTagTemplateFieldId2008993953";
      client.renameTagTemplateField(name, newTagTemplateFieldId);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void renameTagTemplateFieldTest2() throws Exception {
    TagTemplateField expectedResponse =
        TagTemplateField.newBuilder()
            .setName(
                TagTemplateFieldName.of("[PROJECT]", "[LOCATION]", "[TAG_TEMPLATE]", "[FIELD]")
                    .toString())
            .setDisplayName("displayName1714148973")
            .setType(FieldType.newBuilder().build())
            .setIsRequired(true)
            .setDescription("description-1724546052")
            .setOrder(106006350)
            .build();
    mockDataCatalog.addResponse(expectedResponse);

    String name = "name3373707";
    String newTagTemplateFieldId = "newTagTemplateFieldId2008993953";

    TagTemplateField actualResponse = client.renameTagTemplateField(name, newTagTemplateFieldId);
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockDataCatalog.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    RenameTagTemplateFieldRequest actualRequest =
        ((RenameTagTemplateFieldRequest) actualRequests.get(0));

    Assert.assertEquals(name, actualRequest.getName());
    Assert.assertEquals(newTagTemplateFieldId, actualRequest.getNewTagTemplateFieldId());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void renameTagTemplateFieldExceptionTest2() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockDataCatalog.addException(exception);

    try {
      String name = "name3373707";
      String newTagTemplateFieldId = "newTagTemplateFieldId2008993953";
      client.renameTagTemplateField(name, newTagTemplateFieldId);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void renameTagTemplateFieldEnumValueTest() throws Exception {
    TagTemplateField expectedResponse =
        TagTemplateField.newBuilder()
            .setName(
                TagTemplateFieldName.of("[PROJECT]", "[LOCATION]", "[TAG_TEMPLATE]", "[FIELD]")
                    .toString())
            .setDisplayName("displayName1714148973")
            .setType(FieldType.newBuilder().build())
            .setIsRequired(true)
            .setDescription("description-1724546052")
            .setOrder(106006350)
            .build();
    mockDataCatalog.addResponse(expectedResponse);

    TagTemplateFieldEnumValueName name =
        TagTemplateFieldEnumValueName.of(
            "[PROJECT]",
            "[LOCATION]",
            "[TAG_TEMPLATE]",
            "[TAG_TEMPLATE_FIELD_ID]",
            "[ENUM_VALUE_DISPLAY_NAME]");
    String newEnumValueDisplayName = "newEnumValueDisplayName-1119629027";

    TagTemplateField actualResponse =
        client.renameTagTemplateFieldEnumValue(name, newEnumValueDisplayName);
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockDataCatalog.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    RenameTagTemplateFieldEnumValueRequest actualRequest =
        ((RenameTagTemplateFieldEnumValueRequest) actualRequests.get(0));

    Assert.assertEquals(name.toString(), actualRequest.getName());
    Assert.assertEquals(newEnumValueDisplayName, actualRequest.getNewEnumValueDisplayName());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void renameTagTemplateFieldEnumValueExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockDataCatalog.addException(exception);

    try {
      TagTemplateFieldEnumValueName name =
          TagTemplateFieldEnumValueName.of(
              "[PROJECT]",
              "[LOCATION]",
              "[TAG_TEMPLATE]",
              "[TAG_TEMPLATE_FIELD_ID]",
              "[ENUM_VALUE_DISPLAY_NAME]");
      String newEnumValueDisplayName = "newEnumValueDisplayName-1119629027";
      client.renameTagTemplateFieldEnumValue(name, newEnumValueDisplayName);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void renameTagTemplateFieldEnumValueTest2() throws Exception {
    TagTemplateField expectedResponse =
        TagTemplateField.newBuilder()
            .setName(
                TagTemplateFieldName.of("[PROJECT]", "[LOCATION]", "[TAG_TEMPLATE]", "[FIELD]")
                    .toString())
            .setDisplayName("displayName1714148973")
            .setType(FieldType.newBuilder().build())
            .setIsRequired(true)
            .setDescription("description-1724546052")
            .setOrder(106006350)
            .build();
    mockDataCatalog.addResponse(expectedResponse);

    String name = "name3373707";
    String newEnumValueDisplayName = "newEnumValueDisplayName-1119629027";

    TagTemplateField actualResponse =
        client.renameTagTemplateFieldEnumValue(name, newEnumValueDisplayName);
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockDataCatalog.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    RenameTagTemplateFieldEnumValueRequest actualRequest =
        ((RenameTagTemplateFieldEnumValueRequest) actualRequests.get(0));

    Assert.assertEquals(name, actualRequest.getName());
    Assert.assertEquals(newEnumValueDisplayName, actualRequest.getNewEnumValueDisplayName());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void renameTagTemplateFieldEnumValueExceptionTest2() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockDataCatalog.addException(exception);

    try {
      String name = "name3373707";
      String newEnumValueDisplayName = "newEnumValueDisplayName-1119629027";
      client.renameTagTemplateFieldEnumValue(name, newEnumValueDisplayName);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void deleteTagTemplateFieldTest() throws Exception {
    Empty expectedResponse = Empty.newBuilder().build();
    mockDataCatalog.addResponse(expectedResponse);

    TagTemplateFieldName name =
        TagTemplateFieldName.of("[PROJECT]", "[LOCATION]", "[TAG_TEMPLATE]", "[FIELD]");
    boolean force = true;

    client.deleteTagTemplateField(name, force);

    List<AbstractMessage> actualRequests = mockDataCatalog.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    DeleteTagTemplateFieldRequest actualRequest =
        ((DeleteTagTemplateFieldRequest) actualRequests.get(0));

    Assert.assertEquals(name.toString(), actualRequest.getName());
    Assert.assertEquals(force, actualRequest.getForce());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void deleteTagTemplateFieldExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockDataCatalog.addException(exception);

    try {
      TagTemplateFieldName name =
          TagTemplateFieldName.of("[PROJECT]", "[LOCATION]", "[TAG_TEMPLATE]", "[FIELD]");
      boolean force = true;
      client.deleteTagTemplateField(name, force);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void deleteTagTemplateFieldTest2() throws Exception {
    Empty expectedResponse = Empty.newBuilder().build();
    mockDataCatalog.addResponse(expectedResponse);

    String name = "name3373707";
    boolean force = true;

    client.deleteTagTemplateField(name, force);

    List<AbstractMessage> actualRequests = mockDataCatalog.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    DeleteTagTemplateFieldRequest actualRequest =
        ((DeleteTagTemplateFieldRequest) actualRequests.get(0));

    Assert.assertEquals(name, actualRequest.getName());
    Assert.assertEquals(force, actualRequest.getForce());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void deleteTagTemplateFieldExceptionTest2() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockDataCatalog.addException(exception);

    try {
      String name = "name3373707";
      boolean force = true;
      client.deleteTagTemplateField(name, force);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void createTagTest() throws Exception {
    Tag expectedResponse =
        Tag.newBuilder()
            .setName(
                TagName.of("[PROJECT]", "[LOCATION]", "[ENTRY_GROUP]", "[ENTRY]", "[TAG]")
                    .toString())
            .setTemplate("template-1321546630")
            .setTemplateDisplayName("templateDisplayName713818515")
            .putAllFields(new HashMap<String, TagField>())
            .build();
    mockDataCatalog.addResponse(expectedResponse);

    EntryName parent = EntryName.of("[PROJECT]", "[LOCATION]", "[ENTRY_GROUP]", "[ENTRY]");
    Tag tag = Tag.newBuilder().build();

    Tag actualResponse = client.createTag(parent, tag);
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockDataCatalog.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    CreateTagRequest actualRequest = ((CreateTagRequest) actualRequests.get(0));

    Assert.assertEquals(parent.toString(), actualRequest.getParent());
    Assert.assertEquals(tag, actualRequest.getTag());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void createTagExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockDataCatalog.addException(exception);

    try {
      EntryName parent = EntryName.of("[PROJECT]", "[LOCATION]", "[ENTRY_GROUP]", "[ENTRY]");
      Tag tag = Tag.newBuilder().build();
      client.createTag(parent, tag);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void createTagTest2() throws Exception {
    Tag expectedResponse =
        Tag.newBuilder()
            .setName(
                TagName.of("[PROJECT]", "[LOCATION]", "[ENTRY_GROUP]", "[ENTRY]", "[TAG]")
                    .toString())
            .setTemplate("template-1321546630")
            .setTemplateDisplayName("templateDisplayName713818515")
            .putAllFields(new HashMap<String, TagField>())
            .build();
    mockDataCatalog.addResponse(expectedResponse);

    String parent = "parent-995424086";
    Tag tag = Tag.newBuilder().build();

    Tag actualResponse = client.createTag(parent, tag);
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockDataCatalog.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    CreateTagRequest actualRequest = ((CreateTagRequest) actualRequests.get(0));

    Assert.assertEquals(parent, actualRequest.getParent());
    Assert.assertEquals(tag, actualRequest.getTag());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void createTagExceptionTest2() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockDataCatalog.addException(exception);

    try {
      String parent = "parent-995424086";
      Tag tag = Tag.newBuilder().build();
      client.createTag(parent, tag);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void updateTagTest() throws Exception {
    Tag expectedResponse =
        Tag.newBuilder()
            .setName(
                TagName.of("[PROJECT]", "[LOCATION]", "[ENTRY_GROUP]", "[ENTRY]", "[TAG]")
                    .toString())
            .setTemplate("template-1321546630")
            .setTemplateDisplayName("templateDisplayName713818515")
            .putAllFields(new HashMap<String, TagField>())
            .build();
    mockDataCatalog.addResponse(expectedResponse);

    Tag tag = Tag.newBuilder().build();

    Tag actualResponse = client.updateTag(tag);
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockDataCatalog.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    UpdateTagRequest actualRequest = ((UpdateTagRequest) actualRequests.get(0));

    Assert.assertEquals(tag, actualRequest.getTag());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void updateTagExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockDataCatalog.addException(exception);

    try {
      Tag tag = Tag.newBuilder().build();
      client.updateTag(tag);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void updateTagTest2() throws Exception {
    Tag expectedResponse =
        Tag.newBuilder()
            .setName(
                TagName.of("[PROJECT]", "[LOCATION]", "[ENTRY_GROUP]", "[ENTRY]", "[TAG]")
                    .toString())
            .setTemplate("template-1321546630")
            .setTemplateDisplayName("templateDisplayName713818515")
            .putAllFields(new HashMap<String, TagField>())
            .build();
    mockDataCatalog.addResponse(expectedResponse);

    Tag tag = Tag.newBuilder().build();
    FieldMask updateMask = FieldMask.newBuilder().build();

    Tag actualResponse = client.updateTag(tag, updateMask);
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockDataCatalog.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    UpdateTagRequest actualRequest = ((UpdateTagRequest) actualRequests.get(0));

    Assert.assertEquals(tag, actualRequest.getTag());
    Assert.assertEquals(updateMask, actualRequest.getUpdateMask());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void updateTagExceptionTest2() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockDataCatalog.addException(exception);

    try {
      Tag tag = Tag.newBuilder().build();
      FieldMask updateMask = FieldMask.newBuilder().build();
      client.updateTag(tag, updateMask);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void deleteTagTest() throws Exception {
    Empty expectedResponse = Empty.newBuilder().build();
    mockDataCatalog.addResponse(expectedResponse);

    EntryName name = EntryName.of("[PROJECT]", "[LOCATION]", "[ENTRY_GROUP]", "[ENTRY]");

    client.deleteTag(name);

    List<AbstractMessage> actualRequests = mockDataCatalog.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    DeleteTagRequest actualRequest = ((DeleteTagRequest) actualRequests.get(0));

    Assert.assertEquals(name.toString(), actualRequest.getName());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void deleteTagExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockDataCatalog.addException(exception);

    try {
      EntryName name = EntryName.of("[PROJECT]", "[LOCATION]", "[ENTRY_GROUP]", "[ENTRY]");
      client.deleteTag(name);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void deleteTagTest2() throws Exception {
    Empty expectedResponse = Empty.newBuilder().build();
    mockDataCatalog.addResponse(expectedResponse);

    String name = "name3373707";

    client.deleteTag(name);

    List<AbstractMessage> actualRequests = mockDataCatalog.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    DeleteTagRequest actualRequest = ((DeleteTagRequest) actualRequests.get(0));

    Assert.assertEquals(name, actualRequest.getName());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void deleteTagExceptionTest2() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockDataCatalog.addException(exception);

    try {
      String name = "name3373707";
      client.deleteTag(name);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void listTagsTest() throws Exception {
    Tag responsesElement = Tag.newBuilder().build();
    ListTagsResponse expectedResponse =
        ListTagsResponse.newBuilder()
            .setNextPageToken("")
            .addAllTags(Arrays.asList(responsesElement))
            .build();
    mockDataCatalog.addResponse(expectedResponse);

    EntryName parent = EntryName.of("[PROJECT]", "[LOCATION]", "[ENTRY_GROUP]", "[ENTRY]");

    ListTagsPagedResponse pagedListResponse = client.listTags(parent);

    List<Tag> resources = Lists.newArrayList(pagedListResponse.iterateAll());

    Assert.assertEquals(1, resources.size());
    Assert.assertEquals(expectedResponse.getTagsList().get(0), resources.get(0));

    List<AbstractMessage> actualRequests = mockDataCatalog.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    ListTagsRequest actualRequest = ((ListTagsRequest) actualRequests.get(0));

    Assert.assertEquals(parent.toString(), actualRequest.getParent());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void listTagsExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockDataCatalog.addException(exception);

    try {
      EntryName parent = EntryName.of("[PROJECT]", "[LOCATION]", "[ENTRY_GROUP]", "[ENTRY]");
      client.listTags(parent);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void listTagsTest2() throws Exception {
    Tag responsesElement = Tag.newBuilder().build();
    ListTagsResponse expectedResponse =
        ListTagsResponse.newBuilder()
            .setNextPageToken("")
            .addAllTags(Arrays.asList(responsesElement))
            .build();
    mockDataCatalog.addResponse(expectedResponse);

    String parent = "parent-995424086";

    ListTagsPagedResponse pagedListResponse = client.listTags(parent);

    List<Tag> resources = Lists.newArrayList(pagedListResponse.iterateAll());

    Assert.assertEquals(1, resources.size());
    Assert.assertEquals(expectedResponse.getTagsList().get(0), resources.get(0));

    List<AbstractMessage> actualRequests = mockDataCatalog.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    ListTagsRequest actualRequest = ((ListTagsRequest) actualRequests.get(0));

    Assert.assertEquals(parent, actualRequest.getParent());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void listTagsExceptionTest2() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockDataCatalog.addException(exception);

    try {
      String parent = "parent-995424086";
      client.listTags(parent);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void reconcileTagsTest() throws Exception {
    ReconcileTagsResponse expectedResponse =
        ReconcileTagsResponse.newBuilder()
            .setCreatedTagsCount(-986601696)
            .setUpdatedTagsCount(344847213)
            .setDeletedTagsCount(59637071)
            .build();
    Operation resultOperation =
        Operation.newBuilder()
            .setName("reconcileTagsTest")
            .setDone(true)
            .setResponse(Any.pack(expectedResponse))
            .build();
    mockDataCatalog.addResponse(resultOperation);

    ReconcileTagsRequest request =
        ReconcileTagsRequest.newBuilder()
            .setParent(
                EntryName.of("[PROJECT]", "[LOCATION]", "[ENTRY_GROUP]", "[ENTRY]").toString())
            .setTagTemplate(
                TagTemplateName.of("[PROJECT]", "[LOCATION]", "[TAG_TEMPLATE]").toString())
            .setForceDeleteMissing(true)
            .addAllTags(new ArrayList<Tag>())
            .build();

    ReconcileTagsResponse actualResponse = client.reconcileTagsAsync(request).get();
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockDataCatalog.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    ReconcileTagsRequest actualRequest = ((ReconcileTagsRequest) actualRequests.get(0));

    Assert.assertEquals(request.getParent(), actualRequest.getParent());
    Assert.assertEquals(request.getTagTemplate(), actualRequest.getTagTemplate());
    Assert.assertEquals(request.getForceDeleteMissing(), actualRequest.getForceDeleteMissing());
    Assert.assertEquals(request.getTagsList(), actualRequest.getTagsList());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void reconcileTagsExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockDataCatalog.addException(exception);

    try {
      ReconcileTagsRequest request =
          ReconcileTagsRequest.newBuilder()
              .setParent(
                  EntryName.of("[PROJECT]", "[LOCATION]", "[ENTRY_GROUP]", "[ENTRY]").toString())
              .setTagTemplate(
                  TagTemplateName.of("[PROJECT]", "[LOCATION]", "[TAG_TEMPLATE]").toString())
              .setForceDeleteMissing(true)
              .addAllTags(new ArrayList<Tag>())
              .build();
      client.reconcileTagsAsync(request).get();
      Assert.fail("No exception raised");
    } catch (ExecutionException e) {
      Assert.assertEquals(InvalidArgumentException.class, e.getCause().getClass());
      InvalidArgumentException apiException = ((InvalidArgumentException) e.getCause());
      Assert.assertEquals(StatusCode.Code.INVALID_ARGUMENT, apiException.getStatusCode().getCode());
    }
  }

  @Test
  public void starEntryTest() throws Exception {
    StarEntryResponse expectedResponse = StarEntryResponse.newBuilder().build();
    mockDataCatalog.addResponse(expectedResponse);

    EntryName name = EntryName.of("[PROJECT]", "[LOCATION]", "[ENTRY_GROUP]", "[ENTRY]");

    StarEntryResponse actualResponse = client.starEntry(name);
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockDataCatalog.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    StarEntryRequest actualRequest = ((StarEntryRequest) actualRequests.get(0));

    Assert.assertEquals(name.toString(), actualRequest.getName());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void starEntryExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockDataCatalog.addException(exception);

    try {
      EntryName name = EntryName.of("[PROJECT]", "[LOCATION]", "[ENTRY_GROUP]", "[ENTRY]");
      client.starEntry(name);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void starEntryTest2() throws Exception {
    StarEntryResponse expectedResponse = StarEntryResponse.newBuilder().build();
    mockDataCatalog.addResponse(expectedResponse);

    String name = "name3373707";

    StarEntryResponse actualResponse = client.starEntry(name);
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockDataCatalog.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    StarEntryRequest actualRequest = ((StarEntryRequest) actualRequests.get(0));

    Assert.assertEquals(name, actualRequest.getName());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void starEntryExceptionTest2() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockDataCatalog.addException(exception);

    try {
      String name = "name3373707";
      client.starEntry(name);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void unstarEntryTest() throws Exception {
    UnstarEntryResponse expectedResponse = UnstarEntryResponse.newBuilder().build();
    mockDataCatalog.addResponse(expectedResponse);

    EntryName name = EntryName.of("[PROJECT]", "[LOCATION]", "[ENTRY_GROUP]", "[ENTRY]");

    UnstarEntryResponse actualResponse = client.unstarEntry(name);
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockDataCatalog.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    UnstarEntryRequest actualRequest = ((UnstarEntryRequest) actualRequests.get(0));

    Assert.assertEquals(name.toString(), actualRequest.getName());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void unstarEntryExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockDataCatalog.addException(exception);

    try {
      EntryName name = EntryName.of("[PROJECT]", "[LOCATION]", "[ENTRY_GROUP]", "[ENTRY]");
      client.unstarEntry(name);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void unstarEntryTest2() throws Exception {
    UnstarEntryResponse expectedResponse = UnstarEntryResponse.newBuilder().build();
    mockDataCatalog.addResponse(expectedResponse);

    String name = "name3373707";

    UnstarEntryResponse actualResponse = client.unstarEntry(name);
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockDataCatalog.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    UnstarEntryRequest actualRequest = ((UnstarEntryRequest) actualRequests.get(0));

    Assert.assertEquals(name, actualRequest.getName());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void unstarEntryExceptionTest2() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockDataCatalog.addException(exception);

    try {
      String name = "name3373707";
      client.unstarEntry(name);
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
    mockDataCatalog.addResponse(expectedResponse);

    ResourceName resource = EntryGroupName.of("[PROJECT]", "[LOCATION]", "[ENTRY_GROUP]");
    Policy policy = Policy.newBuilder().build();

    Policy actualResponse = client.setIamPolicy(resource, policy);
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockDataCatalog.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    SetIamPolicyRequest actualRequest = ((SetIamPolicyRequest) actualRequests.get(0));

    Assert.assertEquals(resource.toString(), actualRequest.getResource());
    Assert.assertEquals(policy, actualRequest.getPolicy());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void setIamPolicyExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockDataCatalog.addException(exception);

    try {
      ResourceName resource = EntryGroupName.of("[PROJECT]", "[LOCATION]", "[ENTRY_GROUP]");
      Policy policy = Policy.newBuilder().build();
      client.setIamPolicy(resource, policy);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void setIamPolicyTest2() throws Exception {
    Policy expectedResponse =
        Policy.newBuilder()
            .setVersion(351608024)
            .addAllBindings(new ArrayList<Binding>())
            .addAllAuditConfigs(new ArrayList<AuditConfig>())
            .setEtag(ByteString.EMPTY)
            .build();
    mockDataCatalog.addResponse(expectedResponse);

    String resource = "resource-341064690";
    Policy policy = Policy.newBuilder().build();

    Policy actualResponse = client.setIamPolicy(resource, policy);
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockDataCatalog.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    SetIamPolicyRequest actualRequest = ((SetIamPolicyRequest) actualRequests.get(0));

    Assert.assertEquals(resource, actualRequest.getResource());
    Assert.assertEquals(policy, actualRequest.getPolicy());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void setIamPolicyExceptionTest2() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockDataCatalog.addException(exception);

    try {
      String resource = "resource-341064690";
      Policy policy = Policy.newBuilder().build();
      client.setIamPolicy(resource, policy);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
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
    mockDataCatalog.addResponse(expectedResponse);

    ResourceName resource = EntryName.of("[PROJECT]", "[LOCATION]", "[ENTRY_GROUP]", "[ENTRY]");

    Policy actualResponse = client.getIamPolicy(resource);
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockDataCatalog.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    GetIamPolicyRequest actualRequest = ((GetIamPolicyRequest) actualRequests.get(0));

    Assert.assertEquals(resource.toString(), actualRequest.getResource());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void getIamPolicyExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockDataCatalog.addException(exception);

    try {
      ResourceName resource = EntryName.of("[PROJECT]", "[LOCATION]", "[ENTRY_GROUP]", "[ENTRY]");
      client.getIamPolicy(resource);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void getIamPolicyTest2() throws Exception {
    Policy expectedResponse =
        Policy.newBuilder()
            .setVersion(351608024)
            .addAllBindings(new ArrayList<Binding>())
            .addAllAuditConfigs(new ArrayList<AuditConfig>())
            .setEtag(ByteString.EMPTY)
            .build();
    mockDataCatalog.addResponse(expectedResponse);

    String resource = "resource-341064690";

    Policy actualResponse = client.getIamPolicy(resource);
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockDataCatalog.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    GetIamPolicyRequest actualRequest = ((GetIamPolicyRequest) actualRequests.get(0));

    Assert.assertEquals(resource, actualRequest.getResource());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void getIamPolicyExceptionTest2() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockDataCatalog.addException(exception);

    try {
      String resource = "resource-341064690";
      client.getIamPolicy(resource);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void testIamPermissionsTest() throws Exception {
    TestIamPermissionsResponse expectedResponse =
        TestIamPermissionsResponse.newBuilder().addAllPermissions(new ArrayList<String>()).build();
    mockDataCatalog.addResponse(expectedResponse);

    TestIamPermissionsRequest request =
        TestIamPermissionsRequest.newBuilder()
            .setResource(
                EntryName.of("[PROJECT]", "[LOCATION]", "[ENTRY_GROUP]", "[ENTRY]").toString())
            .addAllPermissions(new ArrayList<String>())
            .build();

    TestIamPermissionsResponse actualResponse = client.testIamPermissions(request);
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockDataCatalog.getRequests();
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
    mockDataCatalog.addException(exception);

    try {
      TestIamPermissionsRequest request =
          TestIamPermissionsRequest.newBuilder()
              .setResource(
                  EntryName.of("[PROJECT]", "[LOCATION]", "[ENTRY_GROUP]", "[ENTRY]").toString())
              .addAllPermissions(new ArrayList<String>())
              .build();
      client.testIamPermissions(request);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void importEntriesTest() throws Exception {
    ImportEntriesResponse expectedResponse =
        ImportEntriesResponse.newBuilder()
            .setUpsertedEntriesCount(250168367)
            .setDeletedEntriesCount(-167383302)
            .build();
    Operation resultOperation =
        Operation.newBuilder()
            .setName("importEntriesTest")
            .setDone(true)
            .setResponse(Any.pack(expectedResponse))
            .build();
    mockDataCatalog.addResponse(resultOperation);

    ImportEntriesRequest request =
        ImportEntriesRequest.newBuilder()
            .setParent(EntryGroupName.of("[PROJECT]", "[LOCATION]", "[ENTRY_GROUP]").toString())
            .setJobId("jobId101296568")
            .build();

    ImportEntriesResponse actualResponse = client.importEntriesAsync(request).get();
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockDataCatalog.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    ImportEntriesRequest actualRequest = ((ImportEntriesRequest) actualRequests.get(0));

    Assert.assertEquals(request.getParent(), actualRequest.getParent());
    Assert.assertEquals(request.getGcsBucketPath(), actualRequest.getGcsBucketPath());
    Assert.assertEquals(request.getJobId(), actualRequest.getJobId());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void importEntriesExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockDataCatalog.addException(exception);

    try {
      ImportEntriesRequest request =
          ImportEntriesRequest.newBuilder()
              .setParent(EntryGroupName.of("[PROJECT]", "[LOCATION]", "[ENTRY_GROUP]").toString())
              .setJobId("jobId101296568")
              .build();
      client.importEntriesAsync(request).get();
      Assert.fail("No exception raised");
    } catch (ExecutionException e) {
      Assert.assertEquals(InvalidArgumentException.class, e.getCause().getClass());
      InvalidArgumentException apiException = ((InvalidArgumentException) e.getCause());
      Assert.assertEquals(StatusCode.Code.INVALID_ARGUMENT, apiException.getStatusCode().getCode());
    }
  }

  @Test
  public void setConfigTest() throws Exception {
    MigrationConfig expectedResponse =
        MigrationConfig.newBuilder()
            .setTagTemplateMigration(TagTemplateMigration.forNumber(0))
            .setCatalogUiExperience(CatalogUIExperience.forNumber(0))
            .build();
    mockDataCatalog.addResponse(expectedResponse);

    SetConfigRequest request = SetConfigRequest.newBuilder().setName("name3373707").build();

    MigrationConfig actualResponse = client.setConfig(request);
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockDataCatalog.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    SetConfigRequest actualRequest = ((SetConfigRequest) actualRequests.get(0));

    Assert.assertEquals(request.getName(), actualRequest.getName());
    Assert.assertEquals(request.getTagTemplateMigration(), actualRequest.getTagTemplateMigration());
    Assert.assertEquals(request.getCatalogUiExperience(), actualRequest.getCatalogUiExperience());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void setConfigExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockDataCatalog.addException(exception);

    try {
      SetConfigRequest request = SetConfigRequest.newBuilder().setName("name3373707").build();
      client.setConfig(request);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void retrieveConfigTest() throws Exception {
    OrganizationConfig expectedResponse =
        OrganizationConfig.newBuilder()
            .putAllConfig(new HashMap<String, MigrationConfig>())
            .build();
    mockDataCatalog.addResponse(expectedResponse);

    RetrieveConfigRequest request =
        RetrieveConfigRequest.newBuilder().setName("name3373707").build();

    OrganizationConfig actualResponse = client.retrieveConfig(request);
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockDataCatalog.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    RetrieveConfigRequest actualRequest = ((RetrieveConfigRequest) actualRequests.get(0));

    Assert.assertEquals(request.getName(), actualRequest.getName());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void retrieveConfigExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockDataCatalog.addException(exception);

    try {
      RetrieveConfigRequest request =
          RetrieveConfigRequest.newBuilder().setName("name3373707").build();
      client.retrieveConfig(request);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void retrieveEffectiveConfigTest() throws Exception {
    MigrationConfig expectedResponse =
        MigrationConfig.newBuilder()
            .setTagTemplateMigration(TagTemplateMigration.forNumber(0))
            .setCatalogUiExperience(CatalogUIExperience.forNumber(0))
            .build();
    mockDataCatalog.addResponse(expectedResponse);

    RetrieveEffectiveConfigRequest request =
        RetrieveEffectiveConfigRequest.newBuilder().setName("name3373707").build();

    MigrationConfig actualResponse = client.retrieveEffectiveConfig(request);
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockDataCatalog.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    RetrieveEffectiveConfigRequest actualRequest =
        ((RetrieveEffectiveConfigRequest) actualRequests.get(0));

    Assert.assertEquals(request.getName(), actualRequest.getName());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void retrieveEffectiveConfigExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockDataCatalog.addException(exception);

    try {
      RetrieveEffectiveConfigRequest request =
          RetrieveEffectiveConfigRequest.newBuilder().setName("name3373707").build();
      client.retrieveEffectiveConfig(request);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }
}
