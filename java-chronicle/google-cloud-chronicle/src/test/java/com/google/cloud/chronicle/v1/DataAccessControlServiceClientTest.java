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

package com.google.cloud.chronicle.v1;

import static com.google.cloud.chronicle.v1.DataAccessControlServiceClient.ListDataAccessLabelsPagedResponse;
import static com.google.cloud.chronicle.v1.DataAccessControlServiceClient.ListDataAccessScopesPagedResponse;

import com.google.api.gax.core.NoCredentialsProvider;
import com.google.api.gax.grpc.GaxGrpcProperties;
import com.google.api.gax.grpc.testing.LocalChannelProvider;
import com.google.api.gax.grpc.testing.MockGrpcService;
import com.google.api.gax.grpc.testing.MockServiceHelper;
import com.google.api.gax.rpc.ApiClientHeaderProvider;
import com.google.api.gax.rpc.InvalidArgumentException;
import com.google.common.collect.Lists;
import com.google.protobuf.AbstractMessage;
import com.google.protobuf.Empty;
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
public class DataAccessControlServiceClientTest {
  private static MockDataAccessControlService mockDataAccessControlService;
  private static MockServiceHelper mockServiceHelper;
  private LocalChannelProvider channelProvider;
  private DataAccessControlServiceClient client;

  @BeforeClass
  public static void startStaticServer() {
    mockDataAccessControlService = new MockDataAccessControlService();
    mockServiceHelper =
        new MockServiceHelper(
            UUID.randomUUID().toString(),
            Arrays.<MockGrpcService>asList(mockDataAccessControlService));
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
    DataAccessControlServiceSettings settings =
        DataAccessControlServiceSettings.newBuilder()
            .setTransportChannelProvider(channelProvider)
            .setCredentialsProvider(NoCredentialsProvider.create())
            .build();
    client = DataAccessControlServiceClient.create(settings);
  }

  @After
  public void tearDown() throws Exception {
    client.close();
  }

  @Test
  public void createDataAccessLabelTest() throws Exception {
    DataAccessLabel expectedResponse =
        DataAccessLabel.newBuilder()
            .setName(
                DataAccessLabelName.of(
                        "[PROJECT]", "[LOCATION]", "[INSTANCE]", "[DATA_ACCESS_LABEL]")
                    .toString())
            .setDisplayName("displayName1714148973")
            .setCreateTime(Timestamp.newBuilder().build())
            .setUpdateTime(Timestamp.newBuilder().build())
            .setAuthor("author-1406328437")
            .setLastEditor("lastEditor1523898275")
            .setDescription("description-1724546052")
            .build();
    mockDataAccessControlService.addResponse(expectedResponse);

    InstanceName parent = InstanceName.of("[PROJECT]", "[LOCATION]", "[INSTANCE]");
    DataAccessLabel dataAccessLabel = DataAccessLabel.newBuilder().build();
    String dataAccessLabelId = "dataAccessLabelId1775298977";

    DataAccessLabel actualResponse =
        client.createDataAccessLabel(parent, dataAccessLabel, dataAccessLabelId);
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockDataAccessControlService.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    CreateDataAccessLabelRequest actualRequest =
        ((CreateDataAccessLabelRequest) actualRequests.get(0));

    Assert.assertEquals(parent.toString(), actualRequest.getParent());
    Assert.assertEquals(dataAccessLabel, actualRequest.getDataAccessLabel());
    Assert.assertEquals(dataAccessLabelId, actualRequest.getDataAccessLabelId());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void createDataAccessLabelExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockDataAccessControlService.addException(exception);

    try {
      InstanceName parent = InstanceName.of("[PROJECT]", "[LOCATION]", "[INSTANCE]");
      DataAccessLabel dataAccessLabel = DataAccessLabel.newBuilder().build();
      String dataAccessLabelId = "dataAccessLabelId1775298977";
      client.createDataAccessLabel(parent, dataAccessLabel, dataAccessLabelId);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void createDataAccessLabelTest2() throws Exception {
    DataAccessLabel expectedResponse =
        DataAccessLabel.newBuilder()
            .setName(
                DataAccessLabelName.of(
                        "[PROJECT]", "[LOCATION]", "[INSTANCE]", "[DATA_ACCESS_LABEL]")
                    .toString())
            .setDisplayName("displayName1714148973")
            .setCreateTime(Timestamp.newBuilder().build())
            .setUpdateTime(Timestamp.newBuilder().build())
            .setAuthor("author-1406328437")
            .setLastEditor("lastEditor1523898275")
            .setDescription("description-1724546052")
            .build();
    mockDataAccessControlService.addResponse(expectedResponse);

    String parent = "parent-995424086";
    DataAccessLabel dataAccessLabel = DataAccessLabel.newBuilder().build();
    String dataAccessLabelId = "dataAccessLabelId1775298977";

    DataAccessLabel actualResponse =
        client.createDataAccessLabel(parent, dataAccessLabel, dataAccessLabelId);
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockDataAccessControlService.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    CreateDataAccessLabelRequest actualRequest =
        ((CreateDataAccessLabelRequest) actualRequests.get(0));

    Assert.assertEquals(parent, actualRequest.getParent());
    Assert.assertEquals(dataAccessLabel, actualRequest.getDataAccessLabel());
    Assert.assertEquals(dataAccessLabelId, actualRequest.getDataAccessLabelId());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void createDataAccessLabelExceptionTest2() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockDataAccessControlService.addException(exception);

    try {
      String parent = "parent-995424086";
      DataAccessLabel dataAccessLabel = DataAccessLabel.newBuilder().build();
      String dataAccessLabelId = "dataAccessLabelId1775298977";
      client.createDataAccessLabel(parent, dataAccessLabel, dataAccessLabelId);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void getDataAccessLabelTest() throws Exception {
    DataAccessLabel expectedResponse =
        DataAccessLabel.newBuilder()
            .setName(
                DataAccessLabelName.of(
                        "[PROJECT]", "[LOCATION]", "[INSTANCE]", "[DATA_ACCESS_LABEL]")
                    .toString())
            .setDisplayName("displayName1714148973")
            .setCreateTime(Timestamp.newBuilder().build())
            .setUpdateTime(Timestamp.newBuilder().build())
            .setAuthor("author-1406328437")
            .setLastEditor("lastEditor1523898275")
            .setDescription("description-1724546052")
            .build();
    mockDataAccessControlService.addResponse(expectedResponse);

    DataAccessLabelName name =
        DataAccessLabelName.of("[PROJECT]", "[LOCATION]", "[INSTANCE]", "[DATA_ACCESS_LABEL]");

    DataAccessLabel actualResponse = client.getDataAccessLabel(name);
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockDataAccessControlService.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    GetDataAccessLabelRequest actualRequest = ((GetDataAccessLabelRequest) actualRequests.get(0));

    Assert.assertEquals(name.toString(), actualRequest.getName());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void getDataAccessLabelExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockDataAccessControlService.addException(exception);

    try {
      DataAccessLabelName name =
          DataAccessLabelName.of("[PROJECT]", "[LOCATION]", "[INSTANCE]", "[DATA_ACCESS_LABEL]");
      client.getDataAccessLabel(name);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void getDataAccessLabelTest2() throws Exception {
    DataAccessLabel expectedResponse =
        DataAccessLabel.newBuilder()
            .setName(
                DataAccessLabelName.of(
                        "[PROJECT]", "[LOCATION]", "[INSTANCE]", "[DATA_ACCESS_LABEL]")
                    .toString())
            .setDisplayName("displayName1714148973")
            .setCreateTime(Timestamp.newBuilder().build())
            .setUpdateTime(Timestamp.newBuilder().build())
            .setAuthor("author-1406328437")
            .setLastEditor("lastEditor1523898275")
            .setDescription("description-1724546052")
            .build();
    mockDataAccessControlService.addResponse(expectedResponse);

    String name = "name3373707";

    DataAccessLabel actualResponse = client.getDataAccessLabel(name);
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockDataAccessControlService.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    GetDataAccessLabelRequest actualRequest = ((GetDataAccessLabelRequest) actualRequests.get(0));

    Assert.assertEquals(name, actualRequest.getName());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void getDataAccessLabelExceptionTest2() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockDataAccessControlService.addException(exception);

    try {
      String name = "name3373707";
      client.getDataAccessLabel(name);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void listDataAccessLabelsTest() throws Exception {
    DataAccessLabel responsesElement = DataAccessLabel.newBuilder().build();
    ListDataAccessLabelsResponse expectedResponse =
        ListDataAccessLabelsResponse.newBuilder()
            .setNextPageToken("")
            .addAllDataAccessLabels(Arrays.asList(responsesElement))
            .build();
    mockDataAccessControlService.addResponse(expectedResponse);

    InstanceName parent = InstanceName.of("[PROJECT]", "[LOCATION]", "[INSTANCE]");

    ListDataAccessLabelsPagedResponse pagedListResponse = client.listDataAccessLabels(parent);

    List<DataAccessLabel> resources = Lists.newArrayList(pagedListResponse.iterateAll());

    Assert.assertEquals(1, resources.size());
    Assert.assertEquals(expectedResponse.getDataAccessLabelsList().get(0), resources.get(0));

    List<AbstractMessage> actualRequests = mockDataAccessControlService.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    ListDataAccessLabelsRequest actualRequest =
        ((ListDataAccessLabelsRequest) actualRequests.get(0));

    Assert.assertEquals(parent.toString(), actualRequest.getParent());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void listDataAccessLabelsExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockDataAccessControlService.addException(exception);

    try {
      InstanceName parent = InstanceName.of("[PROJECT]", "[LOCATION]", "[INSTANCE]");
      client.listDataAccessLabels(parent);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void listDataAccessLabelsTest2() throws Exception {
    DataAccessLabel responsesElement = DataAccessLabel.newBuilder().build();
    ListDataAccessLabelsResponse expectedResponse =
        ListDataAccessLabelsResponse.newBuilder()
            .setNextPageToken("")
            .addAllDataAccessLabels(Arrays.asList(responsesElement))
            .build();
    mockDataAccessControlService.addResponse(expectedResponse);

    String parent = "parent-995424086";

    ListDataAccessLabelsPagedResponse pagedListResponse = client.listDataAccessLabels(parent);

    List<DataAccessLabel> resources = Lists.newArrayList(pagedListResponse.iterateAll());

    Assert.assertEquals(1, resources.size());
    Assert.assertEquals(expectedResponse.getDataAccessLabelsList().get(0), resources.get(0));

    List<AbstractMessage> actualRequests = mockDataAccessControlService.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    ListDataAccessLabelsRequest actualRequest =
        ((ListDataAccessLabelsRequest) actualRequests.get(0));

    Assert.assertEquals(parent, actualRequest.getParent());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void listDataAccessLabelsExceptionTest2() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockDataAccessControlService.addException(exception);

    try {
      String parent = "parent-995424086";
      client.listDataAccessLabels(parent);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void updateDataAccessLabelTest() throws Exception {
    DataAccessLabel expectedResponse =
        DataAccessLabel.newBuilder()
            .setName(
                DataAccessLabelName.of(
                        "[PROJECT]", "[LOCATION]", "[INSTANCE]", "[DATA_ACCESS_LABEL]")
                    .toString())
            .setDisplayName("displayName1714148973")
            .setCreateTime(Timestamp.newBuilder().build())
            .setUpdateTime(Timestamp.newBuilder().build())
            .setAuthor("author-1406328437")
            .setLastEditor("lastEditor1523898275")
            .setDescription("description-1724546052")
            .build();
    mockDataAccessControlService.addResponse(expectedResponse);

    DataAccessLabel dataAccessLabel = DataAccessLabel.newBuilder().build();
    FieldMask updateMask = FieldMask.newBuilder().build();

    DataAccessLabel actualResponse = client.updateDataAccessLabel(dataAccessLabel, updateMask);
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockDataAccessControlService.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    UpdateDataAccessLabelRequest actualRequest =
        ((UpdateDataAccessLabelRequest) actualRequests.get(0));

    Assert.assertEquals(dataAccessLabel, actualRequest.getDataAccessLabel());
    Assert.assertEquals(updateMask, actualRequest.getUpdateMask());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void updateDataAccessLabelExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockDataAccessControlService.addException(exception);

    try {
      DataAccessLabel dataAccessLabel = DataAccessLabel.newBuilder().build();
      FieldMask updateMask = FieldMask.newBuilder().build();
      client.updateDataAccessLabel(dataAccessLabel, updateMask);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void deleteDataAccessLabelTest() throws Exception {
    Empty expectedResponse = Empty.newBuilder().build();
    mockDataAccessControlService.addResponse(expectedResponse);

    DataAccessLabelName name =
        DataAccessLabelName.of("[PROJECT]", "[LOCATION]", "[INSTANCE]", "[DATA_ACCESS_LABEL]");

    client.deleteDataAccessLabel(name);

    List<AbstractMessage> actualRequests = mockDataAccessControlService.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    DeleteDataAccessLabelRequest actualRequest =
        ((DeleteDataAccessLabelRequest) actualRequests.get(0));

    Assert.assertEquals(name.toString(), actualRequest.getName());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void deleteDataAccessLabelExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockDataAccessControlService.addException(exception);

    try {
      DataAccessLabelName name =
          DataAccessLabelName.of("[PROJECT]", "[LOCATION]", "[INSTANCE]", "[DATA_ACCESS_LABEL]");
      client.deleteDataAccessLabel(name);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void deleteDataAccessLabelTest2() throws Exception {
    Empty expectedResponse = Empty.newBuilder().build();
    mockDataAccessControlService.addResponse(expectedResponse);

    String name = "name3373707";

    client.deleteDataAccessLabel(name);

    List<AbstractMessage> actualRequests = mockDataAccessControlService.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    DeleteDataAccessLabelRequest actualRequest =
        ((DeleteDataAccessLabelRequest) actualRequests.get(0));

    Assert.assertEquals(name, actualRequest.getName());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void deleteDataAccessLabelExceptionTest2() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockDataAccessControlService.addException(exception);

    try {
      String name = "name3373707";
      client.deleteDataAccessLabel(name);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void createDataAccessScopeTest() throws Exception {
    DataAccessScope expectedResponse =
        DataAccessScope.newBuilder()
            .setName(
                DataAccessScopeName.of(
                        "[PROJECT]", "[LOCATION]", "[INSTANCE]", "[DATA_ACCESS_SCOPE]")
                    .toString())
            .addAllAllowedDataAccessLabels(new ArrayList<DataAccessLabelReference>())
            .addAllDeniedDataAccessLabels(new ArrayList<DataAccessLabelReference>())
            .setDisplayName("displayName1714148973")
            .setCreateTime(Timestamp.newBuilder().build())
            .setUpdateTime(Timestamp.newBuilder().build())
            .setAuthor("author-1406328437")
            .setLastEditor("lastEditor1523898275")
            .setDescription("description-1724546052")
            .setAllowAll(true)
            .build();
    mockDataAccessControlService.addResponse(expectedResponse);

    InstanceName parent = InstanceName.of("[PROJECT]", "[LOCATION]", "[INSTANCE]");
    DataAccessScope dataAccessScope = DataAccessScope.newBuilder().build();
    String dataAccessScopeId = "dataAccessScopeId-532524799";

    DataAccessScope actualResponse =
        client.createDataAccessScope(parent, dataAccessScope, dataAccessScopeId);
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockDataAccessControlService.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    CreateDataAccessScopeRequest actualRequest =
        ((CreateDataAccessScopeRequest) actualRequests.get(0));

    Assert.assertEquals(parent.toString(), actualRequest.getParent());
    Assert.assertEquals(dataAccessScope, actualRequest.getDataAccessScope());
    Assert.assertEquals(dataAccessScopeId, actualRequest.getDataAccessScopeId());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void createDataAccessScopeExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockDataAccessControlService.addException(exception);

    try {
      InstanceName parent = InstanceName.of("[PROJECT]", "[LOCATION]", "[INSTANCE]");
      DataAccessScope dataAccessScope = DataAccessScope.newBuilder().build();
      String dataAccessScopeId = "dataAccessScopeId-532524799";
      client.createDataAccessScope(parent, dataAccessScope, dataAccessScopeId);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void createDataAccessScopeTest2() throws Exception {
    DataAccessScope expectedResponse =
        DataAccessScope.newBuilder()
            .setName(
                DataAccessScopeName.of(
                        "[PROJECT]", "[LOCATION]", "[INSTANCE]", "[DATA_ACCESS_SCOPE]")
                    .toString())
            .addAllAllowedDataAccessLabels(new ArrayList<DataAccessLabelReference>())
            .addAllDeniedDataAccessLabels(new ArrayList<DataAccessLabelReference>())
            .setDisplayName("displayName1714148973")
            .setCreateTime(Timestamp.newBuilder().build())
            .setUpdateTime(Timestamp.newBuilder().build())
            .setAuthor("author-1406328437")
            .setLastEditor("lastEditor1523898275")
            .setDescription("description-1724546052")
            .setAllowAll(true)
            .build();
    mockDataAccessControlService.addResponse(expectedResponse);

    String parent = "parent-995424086";
    DataAccessScope dataAccessScope = DataAccessScope.newBuilder().build();
    String dataAccessScopeId = "dataAccessScopeId-532524799";

    DataAccessScope actualResponse =
        client.createDataAccessScope(parent, dataAccessScope, dataAccessScopeId);
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockDataAccessControlService.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    CreateDataAccessScopeRequest actualRequest =
        ((CreateDataAccessScopeRequest) actualRequests.get(0));

    Assert.assertEquals(parent, actualRequest.getParent());
    Assert.assertEquals(dataAccessScope, actualRequest.getDataAccessScope());
    Assert.assertEquals(dataAccessScopeId, actualRequest.getDataAccessScopeId());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void createDataAccessScopeExceptionTest2() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockDataAccessControlService.addException(exception);

    try {
      String parent = "parent-995424086";
      DataAccessScope dataAccessScope = DataAccessScope.newBuilder().build();
      String dataAccessScopeId = "dataAccessScopeId-532524799";
      client.createDataAccessScope(parent, dataAccessScope, dataAccessScopeId);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void getDataAccessScopeTest() throws Exception {
    DataAccessScope expectedResponse =
        DataAccessScope.newBuilder()
            .setName(
                DataAccessScopeName.of(
                        "[PROJECT]", "[LOCATION]", "[INSTANCE]", "[DATA_ACCESS_SCOPE]")
                    .toString())
            .addAllAllowedDataAccessLabels(new ArrayList<DataAccessLabelReference>())
            .addAllDeniedDataAccessLabels(new ArrayList<DataAccessLabelReference>())
            .setDisplayName("displayName1714148973")
            .setCreateTime(Timestamp.newBuilder().build())
            .setUpdateTime(Timestamp.newBuilder().build())
            .setAuthor("author-1406328437")
            .setLastEditor("lastEditor1523898275")
            .setDescription("description-1724546052")
            .setAllowAll(true)
            .build();
    mockDataAccessControlService.addResponse(expectedResponse);

    DataAccessScopeName name =
        DataAccessScopeName.of("[PROJECT]", "[LOCATION]", "[INSTANCE]", "[DATA_ACCESS_SCOPE]");

    DataAccessScope actualResponse = client.getDataAccessScope(name);
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockDataAccessControlService.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    GetDataAccessScopeRequest actualRequest = ((GetDataAccessScopeRequest) actualRequests.get(0));

    Assert.assertEquals(name.toString(), actualRequest.getName());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void getDataAccessScopeExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockDataAccessControlService.addException(exception);

    try {
      DataAccessScopeName name =
          DataAccessScopeName.of("[PROJECT]", "[LOCATION]", "[INSTANCE]", "[DATA_ACCESS_SCOPE]");
      client.getDataAccessScope(name);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void getDataAccessScopeTest2() throws Exception {
    DataAccessScope expectedResponse =
        DataAccessScope.newBuilder()
            .setName(
                DataAccessScopeName.of(
                        "[PROJECT]", "[LOCATION]", "[INSTANCE]", "[DATA_ACCESS_SCOPE]")
                    .toString())
            .addAllAllowedDataAccessLabels(new ArrayList<DataAccessLabelReference>())
            .addAllDeniedDataAccessLabels(new ArrayList<DataAccessLabelReference>())
            .setDisplayName("displayName1714148973")
            .setCreateTime(Timestamp.newBuilder().build())
            .setUpdateTime(Timestamp.newBuilder().build())
            .setAuthor("author-1406328437")
            .setLastEditor("lastEditor1523898275")
            .setDescription("description-1724546052")
            .setAllowAll(true)
            .build();
    mockDataAccessControlService.addResponse(expectedResponse);

    String name = "name3373707";

    DataAccessScope actualResponse = client.getDataAccessScope(name);
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockDataAccessControlService.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    GetDataAccessScopeRequest actualRequest = ((GetDataAccessScopeRequest) actualRequests.get(0));

    Assert.assertEquals(name, actualRequest.getName());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void getDataAccessScopeExceptionTest2() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockDataAccessControlService.addException(exception);

    try {
      String name = "name3373707";
      client.getDataAccessScope(name);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void listDataAccessScopesTest() throws Exception {
    DataAccessScope responsesElement = DataAccessScope.newBuilder().build();
    ListDataAccessScopesResponse expectedResponse =
        ListDataAccessScopesResponse.newBuilder()
            .setNextPageToken("")
            .addAllDataAccessScopes(Arrays.asList(responsesElement))
            .build();
    mockDataAccessControlService.addResponse(expectedResponse);

    InstanceName parent = InstanceName.of("[PROJECT]", "[LOCATION]", "[INSTANCE]");

    ListDataAccessScopesPagedResponse pagedListResponse = client.listDataAccessScopes(parent);

    List<DataAccessScope> resources = Lists.newArrayList(pagedListResponse.iterateAll());

    Assert.assertEquals(1, resources.size());
    Assert.assertEquals(expectedResponse.getDataAccessScopesList().get(0), resources.get(0));

    List<AbstractMessage> actualRequests = mockDataAccessControlService.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    ListDataAccessScopesRequest actualRequest =
        ((ListDataAccessScopesRequest) actualRequests.get(0));

    Assert.assertEquals(parent.toString(), actualRequest.getParent());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void listDataAccessScopesExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockDataAccessControlService.addException(exception);

    try {
      InstanceName parent = InstanceName.of("[PROJECT]", "[LOCATION]", "[INSTANCE]");
      client.listDataAccessScopes(parent);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void listDataAccessScopesTest2() throws Exception {
    DataAccessScope responsesElement = DataAccessScope.newBuilder().build();
    ListDataAccessScopesResponse expectedResponse =
        ListDataAccessScopesResponse.newBuilder()
            .setNextPageToken("")
            .addAllDataAccessScopes(Arrays.asList(responsesElement))
            .build();
    mockDataAccessControlService.addResponse(expectedResponse);

    String parent = "parent-995424086";

    ListDataAccessScopesPagedResponse pagedListResponse = client.listDataAccessScopes(parent);

    List<DataAccessScope> resources = Lists.newArrayList(pagedListResponse.iterateAll());

    Assert.assertEquals(1, resources.size());
    Assert.assertEquals(expectedResponse.getDataAccessScopesList().get(0), resources.get(0));

    List<AbstractMessage> actualRequests = mockDataAccessControlService.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    ListDataAccessScopesRequest actualRequest =
        ((ListDataAccessScopesRequest) actualRequests.get(0));

    Assert.assertEquals(parent, actualRequest.getParent());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void listDataAccessScopesExceptionTest2() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockDataAccessControlService.addException(exception);

    try {
      String parent = "parent-995424086";
      client.listDataAccessScopes(parent);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void updateDataAccessScopeTest() throws Exception {
    DataAccessScope expectedResponse =
        DataAccessScope.newBuilder()
            .setName(
                DataAccessScopeName.of(
                        "[PROJECT]", "[LOCATION]", "[INSTANCE]", "[DATA_ACCESS_SCOPE]")
                    .toString())
            .addAllAllowedDataAccessLabels(new ArrayList<DataAccessLabelReference>())
            .addAllDeniedDataAccessLabels(new ArrayList<DataAccessLabelReference>())
            .setDisplayName("displayName1714148973")
            .setCreateTime(Timestamp.newBuilder().build())
            .setUpdateTime(Timestamp.newBuilder().build())
            .setAuthor("author-1406328437")
            .setLastEditor("lastEditor1523898275")
            .setDescription("description-1724546052")
            .setAllowAll(true)
            .build();
    mockDataAccessControlService.addResponse(expectedResponse);

    DataAccessScope dataAccessScope = DataAccessScope.newBuilder().build();
    FieldMask updateMask = FieldMask.newBuilder().build();

    DataAccessScope actualResponse = client.updateDataAccessScope(dataAccessScope, updateMask);
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockDataAccessControlService.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    UpdateDataAccessScopeRequest actualRequest =
        ((UpdateDataAccessScopeRequest) actualRequests.get(0));

    Assert.assertEquals(dataAccessScope, actualRequest.getDataAccessScope());
    Assert.assertEquals(updateMask, actualRequest.getUpdateMask());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void updateDataAccessScopeExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockDataAccessControlService.addException(exception);

    try {
      DataAccessScope dataAccessScope = DataAccessScope.newBuilder().build();
      FieldMask updateMask = FieldMask.newBuilder().build();
      client.updateDataAccessScope(dataAccessScope, updateMask);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void deleteDataAccessScopeTest() throws Exception {
    Empty expectedResponse = Empty.newBuilder().build();
    mockDataAccessControlService.addResponse(expectedResponse);

    DataAccessScopeName name =
        DataAccessScopeName.of("[PROJECT]", "[LOCATION]", "[INSTANCE]", "[DATA_ACCESS_SCOPE]");

    client.deleteDataAccessScope(name);

    List<AbstractMessage> actualRequests = mockDataAccessControlService.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    DeleteDataAccessScopeRequest actualRequest =
        ((DeleteDataAccessScopeRequest) actualRequests.get(0));

    Assert.assertEquals(name.toString(), actualRequest.getName());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void deleteDataAccessScopeExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockDataAccessControlService.addException(exception);

    try {
      DataAccessScopeName name =
          DataAccessScopeName.of("[PROJECT]", "[LOCATION]", "[INSTANCE]", "[DATA_ACCESS_SCOPE]");
      client.deleteDataAccessScope(name);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void deleteDataAccessScopeTest2() throws Exception {
    Empty expectedResponse = Empty.newBuilder().build();
    mockDataAccessControlService.addResponse(expectedResponse);

    String name = "name3373707";

    client.deleteDataAccessScope(name);

    List<AbstractMessage> actualRequests = mockDataAccessControlService.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    DeleteDataAccessScopeRequest actualRequest =
        ((DeleteDataAccessScopeRequest) actualRequests.get(0));

    Assert.assertEquals(name, actualRequest.getName());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void deleteDataAccessScopeExceptionTest2() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockDataAccessControlService.addException(exception);

    try {
      String name = "name3373707";
      client.deleteDataAccessScope(name);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }
}
