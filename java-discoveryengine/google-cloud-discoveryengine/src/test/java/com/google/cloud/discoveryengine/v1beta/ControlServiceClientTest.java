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

package com.google.cloud.discoveryengine.v1beta;

import static com.google.cloud.discoveryengine.v1beta.ControlServiceClient.ListControlsPagedResponse;

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
public class ControlServiceClientTest {
  private static MockControlService mockControlService;
  private static MockLocations mockLocations;
  private static MockServiceHelper mockServiceHelper;
  private LocalChannelProvider channelProvider;
  private ControlServiceClient client;

  @BeforeClass
  public static void startStaticServer() {
    mockControlService = new MockControlService();
    mockLocations = new MockLocations();
    mockServiceHelper =
        new MockServiceHelper(
            UUID.randomUUID().toString(),
            Arrays.<MockGrpcService>asList(mockControlService, mockLocations));
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
    ControlServiceSettings settings =
        ControlServiceSettings.newBuilder()
            .setTransportChannelProvider(channelProvider)
            .setCredentialsProvider(NoCredentialsProvider.create())
            .build();
    client = ControlServiceClient.create(settings);
  }

  @After
  public void tearDown() throws Exception {
    client.close();
  }

  @Test
  public void createControlTest() throws Exception {
    Control expectedResponse =
        Control.newBuilder()
            .setName(
                ControlName.ofProjectLocationDataStoreControlName(
                        "[PROJECT]", "[LOCATION]", "[DATA_STORE]", "[CONTROL]")
                    .toString())
            .setDisplayName("displayName1714148973")
            .addAllAssociatedServingConfigIds(new ArrayList<String>())
            .setSolutionType(SolutionType.forNumber(0))
            .addAllUseCases(new ArrayList<SearchUseCase>())
            .addAllConditions(new ArrayList<Condition>())
            .build();
    mockControlService.addResponse(expectedResponse);

    DataStoreName parent =
        DataStoreName.ofProjectLocationDataStoreName("[PROJECT]", "[LOCATION]", "[DATA_STORE]");
    Control control = Control.newBuilder().build();
    String controlId = "controlId-395080872";

    Control actualResponse = client.createControl(parent, control, controlId);
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockControlService.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    CreateControlRequest actualRequest = ((CreateControlRequest) actualRequests.get(0));

    Assert.assertEquals(parent.toString(), actualRequest.getParent());
    Assert.assertEquals(control, actualRequest.getControl());
    Assert.assertEquals(controlId, actualRequest.getControlId());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void createControlExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockControlService.addException(exception);

    try {
      DataStoreName parent =
          DataStoreName.ofProjectLocationDataStoreName("[PROJECT]", "[LOCATION]", "[DATA_STORE]");
      Control control = Control.newBuilder().build();
      String controlId = "controlId-395080872";
      client.createControl(parent, control, controlId);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void createControlTest2() throws Exception {
    Control expectedResponse =
        Control.newBuilder()
            .setName(
                ControlName.ofProjectLocationDataStoreControlName(
                        "[PROJECT]", "[LOCATION]", "[DATA_STORE]", "[CONTROL]")
                    .toString())
            .setDisplayName("displayName1714148973")
            .addAllAssociatedServingConfigIds(new ArrayList<String>())
            .setSolutionType(SolutionType.forNumber(0))
            .addAllUseCases(new ArrayList<SearchUseCase>())
            .addAllConditions(new ArrayList<Condition>())
            .build();
    mockControlService.addResponse(expectedResponse);

    EngineName parent = EngineName.of("[PROJECT]", "[LOCATION]", "[COLLECTION]", "[ENGINE]");
    Control control = Control.newBuilder().build();
    String controlId = "controlId-395080872";

    Control actualResponse = client.createControl(parent, control, controlId);
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockControlService.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    CreateControlRequest actualRequest = ((CreateControlRequest) actualRequests.get(0));

    Assert.assertEquals(parent.toString(), actualRequest.getParent());
    Assert.assertEquals(control, actualRequest.getControl());
    Assert.assertEquals(controlId, actualRequest.getControlId());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void createControlExceptionTest2() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockControlService.addException(exception);

    try {
      EngineName parent = EngineName.of("[PROJECT]", "[LOCATION]", "[COLLECTION]", "[ENGINE]");
      Control control = Control.newBuilder().build();
      String controlId = "controlId-395080872";
      client.createControl(parent, control, controlId);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void createControlTest3() throws Exception {
    Control expectedResponse =
        Control.newBuilder()
            .setName(
                ControlName.ofProjectLocationDataStoreControlName(
                        "[PROJECT]", "[LOCATION]", "[DATA_STORE]", "[CONTROL]")
                    .toString())
            .setDisplayName("displayName1714148973")
            .addAllAssociatedServingConfigIds(new ArrayList<String>())
            .setSolutionType(SolutionType.forNumber(0))
            .addAllUseCases(new ArrayList<SearchUseCase>())
            .addAllConditions(new ArrayList<Condition>())
            .build();
    mockControlService.addResponse(expectedResponse);

    String parent = "parent-995424086";
    Control control = Control.newBuilder().build();
    String controlId = "controlId-395080872";

    Control actualResponse = client.createControl(parent, control, controlId);
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockControlService.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    CreateControlRequest actualRequest = ((CreateControlRequest) actualRequests.get(0));

    Assert.assertEquals(parent, actualRequest.getParent());
    Assert.assertEquals(control, actualRequest.getControl());
    Assert.assertEquals(controlId, actualRequest.getControlId());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void createControlExceptionTest3() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockControlService.addException(exception);

    try {
      String parent = "parent-995424086";
      Control control = Control.newBuilder().build();
      String controlId = "controlId-395080872";
      client.createControl(parent, control, controlId);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void deleteControlTest() throws Exception {
    Empty expectedResponse = Empty.newBuilder().build();
    mockControlService.addResponse(expectedResponse);

    ControlName name =
        ControlName.ofProjectLocationDataStoreControlName(
            "[PROJECT]", "[LOCATION]", "[DATA_STORE]", "[CONTROL]");

    client.deleteControl(name);

    List<AbstractMessage> actualRequests = mockControlService.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    DeleteControlRequest actualRequest = ((DeleteControlRequest) actualRequests.get(0));

    Assert.assertEquals(name.toString(), actualRequest.getName());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void deleteControlExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockControlService.addException(exception);

    try {
      ControlName name =
          ControlName.ofProjectLocationDataStoreControlName(
              "[PROJECT]", "[LOCATION]", "[DATA_STORE]", "[CONTROL]");
      client.deleteControl(name);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void deleteControlTest2() throws Exception {
    Empty expectedResponse = Empty.newBuilder().build();
    mockControlService.addResponse(expectedResponse);

    String name = "name3373707";

    client.deleteControl(name);

    List<AbstractMessage> actualRequests = mockControlService.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    DeleteControlRequest actualRequest = ((DeleteControlRequest) actualRequests.get(0));

    Assert.assertEquals(name, actualRequest.getName());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void deleteControlExceptionTest2() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockControlService.addException(exception);

    try {
      String name = "name3373707";
      client.deleteControl(name);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void updateControlTest() throws Exception {
    Control expectedResponse =
        Control.newBuilder()
            .setName(
                ControlName.ofProjectLocationDataStoreControlName(
                        "[PROJECT]", "[LOCATION]", "[DATA_STORE]", "[CONTROL]")
                    .toString())
            .setDisplayName("displayName1714148973")
            .addAllAssociatedServingConfigIds(new ArrayList<String>())
            .setSolutionType(SolutionType.forNumber(0))
            .addAllUseCases(new ArrayList<SearchUseCase>())
            .addAllConditions(new ArrayList<Condition>())
            .build();
    mockControlService.addResponse(expectedResponse);

    Control control = Control.newBuilder().build();
    FieldMask updateMask = FieldMask.newBuilder().build();

    Control actualResponse = client.updateControl(control, updateMask);
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockControlService.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    UpdateControlRequest actualRequest = ((UpdateControlRequest) actualRequests.get(0));

    Assert.assertEquals(control, actualRequest.getControl());
    Assert.assertEquals(updateMask, actualRequest.getUpdateMask());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void updateControlExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockControlService.addException(exception);

    try {
      Control control = Control.newBuilder().build();
      FieldMask updateMask = FieldMask.newBuilder().build();
      client.updateControl(control, updateMask);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void getControlTest() throws Exception {
    Control expectedResponse =
        Control.newBuilder()
            .setName(
                ControlName.ofProjectLocationDataStoreControlName(
                        "[PROJECT]", "[LOCATION]", "[DATA_STORE]", "[CONTROL]")
                    .toString())
            .setDisplayName("displayName1714148973")
            .addAllAssociatedServingConfigIds(new ArrayList<String>())
            .setSolutionType(SolutionType.forNumber(0))
            .addAllUseCases(new ArrayList<SearchUseCase>())
            .addAllConditions(new ArrayList<Condition>())
            .build();
    mockControlService.addResponse(expectedResponse);

    ControlName name =
        ControlName.ofProjectLocationDataStoreControlName(
            "[PROJECT]", "[LOCATION]", "[DATA_STORE]", "[CONTROL]");

    Control actualResponse = client.getControl(name);
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockControlService.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    GetControlRequest actualRequest = ((GetControlRequest) actualRequests.get(0));

    Assert.assertEquals(name.toString(), actualRequest.getName());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void getControlExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockControlService.addException(exception);

    try {
      ControlName name =
          ControlName.ofProjectLocationDataStoreControlName(
              "[PROJECT]", "[LOCATION]", "[DATA_STORE]", "[CONTROL]");
      client.getControl(name);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void getControlTest2() throws Exception {
    Control expectedResponse =
        Control.newBuilder()
            .setName(
                ControlName.ofProjectLocationDataStoreControlName(
                        "[PROJECT]", "[LOCATION]", "[DATA_STORE]", "[CONTROL]")
                    .toString())
            .setDisplayName("displayName1714148973")
            .addAllAssociatedServingConfigIds(new ArrayList<String>())
            .setSolutionType(SolutionType.forNumber(0))
            .addAllUseCases(new ArrayList<SearchUseCase>())
            .addAllConditions(new ArrayList<Condition>())
            .build();
    mockControlService.addResponse(expectedResponse);

    String name = "name3373707";

    Control actualResponse = client.getControl(name);
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockControlService.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    GetControlRequest actualRequest = ((GetControlRequest) actualRequests.get(0));

    Assert.assertEquals(name, actualRequest.getName());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void getControlExceptionTest2() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockControlService.addException(exception);

    try {
      String name = "name3373707";
      client.getControl(name);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void listControlsTest() throws Exception {
    Control responsesElement = Control.newBuilder().build();
    ListControlsResponse expectedResponse =
        ListControlsResponse.newBuilder()
            .setNextPageToken("")
            .addAllControls(Arrays.asList(responsesElement))
            .build();
    mockControlService.addResponse(expectedResponse);

    DataStoreName parent =
        DataStoreName.ofProjectLocationDataStoreName("[PROJECT]", "[LOCATION]", "[DATA_STORE]");

    ListControlsPagedResponse pagedListResponse = client.listControls(parent);

    List<Control> resources = Lists.newArrayList(pagedListResponse.iterateAll());

    Assert.assertEquals(1, resources.size());
    Assert.assertEquals(expectedResponse.getControlsList().get(0), resources.get(0));

    List<AbstractMessage> actualRequests = mockControlService.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    ListControlsRequest actualRequest = ((ListControlsRequest) actualRequests.get(0));

    Assert.assertEquals(parent.toString(), actualRequest.getParent());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void listControlsExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockControlService.addException(exception);

    try {
      DataStoreName parent =
          DataStoreName.ofProjectLocationDataStoreName("[PROJECT]", "[LOCATION]", "[DATA_STORE]");
      client.listControls(parent);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void listControlsTest2() throws Exception {
    Control responsesElement = Control.newBuilder().build();
    ListControlsResponse expectedResponse =
        ListControlsResponse.newBuilder()
            .setNextPageToken("")
            .addAllControls(Arrays.asList(responsesElement))
            .build();
    mockControlService.addResponse(expectedResponse);

    EngineName parent = EngineName.of("[PROJECT]", "[LOCATION]", "[COLLECTION]", "[ENGINE]");

    ListControlsPagedResponse pagedListResponse = client.listControls(parent);

    List<Control> resources = Lists.newArrayList(pagedListResponse.iterateAll());

    Assert.assertEquals(1, resources.size());
    Assert.assertEquals(expectedResponse.getControlsList().get(0), resources.get(0));

    List<AbstractMessage> actualRequests = mockControlService.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    ListControlsRequest actualRequest = ((ListControlsRequest) actualRequests.get(0));

    Assert.assertEquals(parent.toString(), actualRequest.getParent());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void listControlsExceptionTest2() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockControlService.addException(exception);

    try {
      EngineName parent = EngineName.of("[PROJECT]", "[LOCATION]", "[COLLECTION]", "[ENGINE]");
      client.listControls(parent);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void listControlsTest3() throws Exception {
    Control responsesElement = Control.newBuilder().build();
    ListControlsResponse expectedResponse =
        ListControlsResponse.newBuilder()
            .setNextPageToken("")
            .addAllControls(Arrays.asList(responsesElement))
            .build();
    mockControlService.addResponse(expectedResponse);

    String parent = "parent-995424086";

    ListControlsPagedResponse pagedListResponse = client.listControls(parent);

    List<Control> resources = Lists.newArrayList(pagedListResponse.iterateAll());

    Assert.assertEquals(1, resources.size());
    Assert.assertEquals(expectedResponse.getControlsList().get(0), resources.get(0));

    List<AbstractMessage> actualRequests = mockControlService.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    ListControlsRequest actualRequest = ((ListControlsRequest) actualRequests.get(0));

    Assert.assertEquals(parent, actualRequest.getParent());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void listControlsExceptionTest3() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockControlService.addException(exception);

    try {
      String parent = "parent-995424086";
      client.listControls(parent);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }
}
