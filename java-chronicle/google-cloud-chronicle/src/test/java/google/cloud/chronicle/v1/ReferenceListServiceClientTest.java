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

package google.cloud.chronicle.v1;

import static google.cloud.chronicle.v1.ReferenceListServiceClient.ListReferenceListsPagedResponse;

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
public class ReferenceListServiceClientTest {
  private static MockReferenceListService mockReferenceListService;
  private static MockServiceHelper mockServiceHelper;
  private LocalChannelProvider channelProvider;
  private ReferenceListServiceClient client;

  @BeforeClass
  public static void startStaticServer() {
    mockReferenceListService = new MockReferenceListService();
    mockServiceHelper =
        new MockServiceHelper(
            UUID.randomUUID().toString(), Arrays.<MockGrpcService>asList(mockReferenceListService));
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
    ReferenceListServiceSettings settings =
        ReferenceListServiceSettings.newBuilder()
            .setTransportChannelProvider(channelProvider)
            .setCredentialsProvider(NoCredentialsProvider.create())
            .build();
    client = ReferenceListServiceClient.create(settings);
  }

  @After
  public void tearDown() throws Exception {
    client.close();
  }

  @Test
  public void getReferenceListTest() throws Exception {
    ReferenceList expectedResponse =
        ReferenceList.newBuilder()
            .setName(
                ReferenceListName.of("[PROJECT]", "[LOCATION]", "[INSTANCE]", "[REFERENCE_LIST]")
                    .toString())
            .setDisplayName("displayName1714148973")
            .setRevisionCreateTime(Timestamp.newBuilder().build())
            .setDescription("description-1724546052")
            .addAllEntries(new ArrayList<ReferenceListEntry>())
            .addAllRules(new ArrayList<String>())
            .setSyntaxType(ReferenceListSyntaxType.forNumber(0))
            .setRuleAssociationsCount(-1522562875)
            .setScopeInfo(ScopeInfo.newBuilder().build())
            .build();
    mockReferenceListService.addResponse(expectedResponse);

    ReferenceListName name =
        ReferenceListName.of("[PROJECT]", "[LOCATION]", "[INSTANCE]", "[REFERENCE_LIST]");

    ReferenceList actualResponse = client.getReferenceList(name);
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockReferenceListService.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    GetReferenceListRequest actualRequest = ((GetReferenceListRequest) actualRequests.get(0));

    Assert.assertEquals(name.toString(), actualRequest.getName());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void getReferenceListExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockReferenceListService.addException(exception);

    try {
      ReferenceListName name =
          ReferenceListName.of("[PROJECT]", "[LOCATION]", "[INSTANCE]", "[REFERENCE_LIST]");
      client.getReferenceList(name);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void getReferenceListTest2() throws Exception {
    ReferenceList expectedResponse =
        ReferenceList.newBuilder()
            .setName(
                ReferenceListName.of("[PROJECT]", "[LOCATION]", "[INSTANCE]", "[REFERENCE_LIST]")
                    .toString())
            .setDisplayName("displayName1714148973")
            .setRevisionCreateTime(Timestamp.newBuilder().build())
            .setDescription("description-1724546052")
            .addAllEntries(new ArrayList<ReferenceListEntry>())
            .addAllRules(new ArrayList<String>())
            .setSyntaxType(ReferenceListSyntaxType.forNumber(0))
            .setRuleAssociationsCount(-1522562875)
            .setScopeInfo(ScopeInfo.newBuilder().build())
            .build();
    mockReferenceListService.addResponse(expectedResponse);

    String name = "name3373707";

    ReferenceList actualResponse = client.getReferenceList(name);
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockReferenceListService.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    GetReferenceListRequest actualRequest = ((GetReferenceListRequest) actualRequests.get(0));

    Assert.assertEquals(name, actualRequest.getName());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void getReferenceListExceptionTest2() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockReferenceListService.addException(exception);

    try {
      String name = "name3373707";
      client.getReferenceList(name);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void listReferenceListsTest() throws Exception {
    ReferenceList responsesElement = ReferenceList.newBuilder().build();
    ListReferenceListsResponse expectedResponse =
        ListReferenceListsResponse.newBuilder()
            .setNextPageToken("")
            .addAllReferenceLists(Arrays.asList(responsesElement))
            .build();
    mockReferenceListService.addResponse(expectedResponse);

    InstanceName parent = InstanceName.of("[PROJECT]", "[LOCATION]", "[INSTANCE]");

    ListReferenceListsPagedResponse pagedListResponse = client.listReferenceLists(parent);

    List<ReferenceList> resources = Lists.newArrayList(pagedListResponse.iterateAll());

    Assert.assertEquals(1, resources.size());
    Assert.assertEquals(expectedResponse.getReferenceListsList().get(0), resources.get(0));

    List<AbstractMessage> actualRequests = mockReferenceListService.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    ListReferenceListsRequest actualRequest = ((ListReferenceListsRequest) actualRequests.get(0));

    Assert.assertEquals(parent.toString(), actualRequest.getParent());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void listReferenceListsExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockReferenceListService.addException(exception);

    try {
      InstanceName parent = InstanceName.of("[PROJECT]", "[LOCATION]", "[INSTANCE]");
      client.listReferenceLists(parent);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void listReferenceListsTest2() throws Exception {
    ReferenceList responsesElement = ReferenceList.newBuilder().build();
    ListReferenceListsResponse expectedResponse =
        ListReferenceListsResponse.newBuilder()
            .setNextPageToken("")
            .addAllReferenceLists(Arrays.asList(responsesElement))
            .build();
    mockReferenceListService.addResponse(expectedResponse);

    String parent = "parent-995424086";

    ListReferenceListsPagedResponse pagedListResponse = client.listReferenceLists(parent);

    List<ReferenceList> resources = Lists.newArrayList(pagedListResponse.iterateAll());

    Assert.assertEquals(1, resources.size());
    Assert.assertEquals(expectedResponse.getReferenceListsList().get(0), resources.get(0));

    List<AbstractMessage> actualRequests = mockReferenceListService.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    ListReferenceListsRequest actualRequest = ((ListReferenceListsRequest) actualRequests.get(0));

    Assert.assertEquals(parent, actualRequest.getParent());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void listReferenceListsExceptionTest2() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockReferenceListService.addException(exception);

    try {
      String parent = "parent-995424086";
      client.listReferenceLists(parent);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void createReferenceListTest() throws Exception {
    ReferenceList expectedResponse =
        ReferenceList.newBuilder()
            .setName(
                ReferenceListName.of("[PROJECT]", "[LOCATION]", "[INSTANCE]", "[REFERENCE_LIST]")
                    .toString())
            .setDisplayName("displayName1714148973")
            .setRevisionCreateTime(Timestamp.newBuilder().build())
            .setDescription("description-1724546052")
            .addAllEntries(new ArrayList<ReferenceListEntry>())
            .addAllRules(new ArrayList<String>())
            .setSyntaxType(ReferenceListSyntaxType.forNumber(0))
            .setRuleAssociationsCount(-1522562875)
            .setScopeInfo(ScopeInfo.newBuilder().build())
            .build();
    mockReferenceListService.addResponse(expectedResponse);

    InstanceName parent = InstanceName.of("[PROJECT]", "[LOCATION]", "[INSTANCE]");
    ReferenceList referenceList = ReferenceList.newBuilder().build();
    String referenceListId = "referenceListId676417924";

    ReferenceList actualResponse =
        client.createReferenceList(parent, referenceList, referenceListId);
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockReferenceListService.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    CreateReferenceListRequest actualRequest = ((CreateReferenceListRequest) actualRequests.get(0));

    Assert.assertEquals(parent.toString(), actualRequest.getParent());
    Assert.assertEquals(referenceList, actualRequest.getReferenceList());
    Assert.assertEquals(referenceListId, actualRequest.getReferenceListId());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void createReferenceListExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockReferenceListService.addException(exception);

    try {
      InstanceName parent = InstanceName.of("[PROJECT]", "[LOCATION]", "[INSTANCE]");
      ReferenceList referenceList = ReferenceList.newBuilder().build();
      String referenceListId = "referenceListId676417924";
      client.createReferenceList(parent, referenceList, referenceListId);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void createReferenceListTest2() throws Exception {
    ReferenceList expectedResponse =
        ReferenceList.newBuilder()
            .setName(
                ReferenceListName.of("[PROJECT]", "[LOCATION]", "[INSTANCE]", "[REFERENCE_LIST]")
                    .toString())
            .setDisplayName("displayName1714148973")
            .setRevisionCreateTime(Timestamp.newBuilder().build())
            .setDescription("description-1724546052")
            .addAllEntries(new ArrayList<ReferenceListEntry>())
            .addAllRules(new ArrayList<String>())
            .setSyntaxType(ReferenceListSyntaxType.forNumber(0))
            .setRuleAssociationsCount(-1522562875)
            .setScopeInfo(ScopeInfo.newBuilder().build())
            .build();
    mockReferenceListService.addResponse(expectedResponse);

    String parent = "parent-995424086";
    ReferenceList referenceList = ReferenceList.newBuilder().build();
    String referenceListId = "referenceListId676417924";

    ReferenceList actualResponse =
        client.createReferenceList(parent, referenceList, referenceListId);
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockReferenceListService.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    CreateReferenceListRequest actualRequest = ((CreateReferenceListRequest) actualRequests.get(0));

    Assert.assertEquals(parent, actualRequest.getParent());
    Assert.assertEquals(referenceList, actualRequest.getReferenceList());
    Assert.assertEquals(referenceListId, actualRequest.getReferenceListId());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void createReferenceListExceptionTest2() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockReferenceListService.addException(exception);

    try {
      String parent = "parent-995424086";
      ReferenceList referenceList = ReferenceList.newBuilder().build();
      String referenceListId = "referenceListId676417924";
      client.createReferenceList(parent, referenceList, referenceListId);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void updateReferenceListTest() throws Exception {
    ReferenceList expectedResponse =
        ReferenceList.newBuilder()
            .setName(
                ReferenceListName.of("[PROJECT]", "[LOCATION]", "[INSTANCE]", "[REFERENCE_LIST]")
                    .toString())
            .setDisplayName("displayName1714148973")
            .setRevisionCreateTime(Timestamp.newBuilder().build())
            .setDescription("description-1724546052")
            .addAllEntries(new ArrayList<ReferenceListEntry>())
            .addAllRules(new ArrayList<String>())
            .setSyntaxType(ReferenceListSyntaxType.forNumber(0))
            .setRuleAssociationsCount(-1522562875)
            .setScopeInfo(ScopeInfo.newBuilder().build())
            .build();
    mockReferenceListService.addResponse(expectedResponse);

    ReferenceList referenceList = ReferenceList.newBuilder().build();
    FieldMask updateMask = FieldMask.newBuilder().build();

    ReferenceList actualResponse = client.updateReferenceList(referenceList, updateMask);
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockReferenceListService.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    UpdateReferenceListRequest actualRequest = ((UpdateReferenceListRequest) actualRequests.get(0));

    Assert.assertEquals(referenceList, actualRequest.getReferenceList());
    Assert.assertEquals(updateMask, actualRequest.getUpdateMask());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void updateReferenceListExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockReferenceListService.addException(exception);

    try {
      ReferenceList referenceList = ReferenceList.newBuilder().build();
      FieldMask updateMask = FieldMask.newBuilder().build();
      client.updateReferenceList(referenceList, updateMask);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }
}
