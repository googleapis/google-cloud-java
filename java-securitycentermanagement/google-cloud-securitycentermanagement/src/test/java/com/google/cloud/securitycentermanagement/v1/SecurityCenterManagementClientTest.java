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

package com.google.cloud.securitycentermanagement.v1;

import static com.google.cloud.securitycentermanagement.v1.SecurityCenterManagementClient.ListDescendantEventThreatDetectionCustomModulesPagedResponse;
import static com.google.cloud.securitycentermanagement.v1.SecurityCenterManagementClient.ListDescendantSecurityHealthAnalyticsCustomModulesPagedResponse;
import static com.google.cloud.securitycentermanagement.v1.SecurityCenterManagementClient.ListEffectiveEventThreatDetectionCustomModulesPagedResponse;
import static com.google.cloud.securitycentermanagement.v1.SecurityCenterManagementClient.ListEffectiveSecurityHealthAnalyticsCustomModulesPagedResponse;
import static com.google.cloud.securitycentermanagement.v1.SecurityCenterManagementClient.ListEventThreatDetectionCustomModulesPagedResponse;
import static com.google.cloud.securitycentermanagement.v1.SecurityCenterManagementClient.ListLocationsPagedResponse;
import static com.google.cloud.securitycentermanagement.v1.SecurityCenterManagementClient.ListSecurityHealthAnalyticsCustomModulesPagedResponse;

import com.google.api.gax.core.NoCredentialsProvider;
import com.google.api.gax.grpc.GaxGrpcProperties;
import com.google.api.gax.grpc.testing.LocalChannelProvider;
import com.google.api.gax.grpc.testing.MockGrpcService;
import com.google.api.gax.grpc.testing.MockServiceHelper;
import com.google.api.gax.rpc.ApiClientHeaderProvider;
import com.google.api.gax.rpc.InvalidArgumentException;
import com.google.cloud.location.GetLocationRequest;
import com.google.cloud.location.ListLocationsRequest;
import com.google.cloud.location.ListLocationsResponse;
import com.google.cloud.location.Location;
import com.google.common.collect.Lists;
import com.google.protobuf.AbstractMessage;
import com.google.protobuf.Any;
import com.google.protobuf.Empty;
import com.google.protobuf.FieldMask;
import com.google.protobuf.Struct;
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
public class SecurityCenterManagementClientTest {
  private static MockLocations mockLocations;
  private static MockSecurityCenterManagement mockSecurityCenterManagement;
  private static MockServiceHelper mockServiceHelper;
  private LocalChannelProvider channelProvider;
  private SecurityCenterManagementClient client;

  @BeforeClass
  public static void startStaticServer() {
    mockSecurityCenterManagement = new MockSecurityCenterManagement();
    mockLocations = new MockLocations();
    mockServiceHelper =
        new MockServiceHelper(
            UUID.randomUUID().toString(),
            Arrays.<MockGrpcService>asList(mockSecurityCenterManagement, mockLocations));
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
    SecurityCenterManagementSettings settings =
        SecurityCenterManagementSettings.newBuilder()
            .setTransportChannelProvider(channelProvider)
            .setCredentialsProvider(NoCredentialsProvider.create())
            .build();
    client = SecurityCenterManagementClient.create(settings);
  }

  @After
  public void tearDown() throws Exception {
    client.close();
  }

  @Test
  public void listEffectiveSecurityHealthAnalyticsCustomModulesTest() throws Exception {
    EffectiveSecurityHealthAnalyticsCustomModule responsesElement =
        EffectiveSecurityHealthAnalyticsCustomModule.newBuilder().build();
    ListEffectiveSecurityHealthAnalyticsCustomModulesResponse expectedResponse =
        ListEffectiveSecurityHealthAnalyticsCustomModulesResponse.newBuilder()
            .setNextPageToken("")
            .addAllEffectiveSecurityHealthAnalyticsCustomModules(Arrays.asList(responsesElement))
            .build();
    mockSecurityCenterManagement.addResponse(expectedResponse);

    FolderLocationName parent = FolderLocationName.of("[FOLDER]", "[LOCATION]");

    ListEffectiveSecurityHealthAnalyticsCustomModulesPagedResponse pagedListResponse =
        client.listEffectiveSecurityHealthAnalyticsCustomModules(parent);

    List<EffectiveSecurityHealthAnalyticsCustomModule> resources =
        Lists.newArrayList(pagedListResponse.iterateAll());

    Assert.assertEquals(1, resources.size());
    Assert.assertEquals(
        expectedResponse.getEffectiveSecurityHealthAnalyticsCustomModulesList().get(0),
        resources.get(0));

    List<AbstractMessage> actualRequests = mockSecurityCenterManagement.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    ListEffectiveSecurityHealthAnalyticsCustomModulesRequest actualRequest =
        ((ListEffectiveSecurityHealthAnalyticsCustomModulesRequest) actualRequests.get(0));

    Assert.assertEquals(parent.toString(), actualRequest.getParent());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void listEffectiveSecurityHealthAnalyticsCustomModulesExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockSecurityCenterManagement.addException(exception);

    try {
      FolderLocationName parent = FolderLocationName.of("[FOLDER]", "[LOCATION]");
      client.listEffectiveSecurityHealthAnalyticsCustomModules(parent);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void listEffectiveSecurityHealthAnalyticsCustomModulesTest2() throws Exception {
    EffectiveSecurityHealthAnalyticsCustomModule responsesElement =
        EffectiveSecurityHealthAnalyticsCustomModule.newBuilder().build();
    ListEffectiveSecurityHealthAnalyticsCustomModulesResponse expectedResponse =
        ListEffectiveSecurityHealthAnalyticsCustomModulesResponse.newBuilder()
            .setNextPageToken("")
            .addAllEffectiveSecurityHealthAnalyticsCustomModules(Arrays.asList(responsesElement))
            .build();
    mockSecurityCenterManagement.addResponse(expectedResponse);

    LocationName parent = LocationName.of("[PROJECT]", "[LOCATION]");

    ListEffectiveSecurityHealthAnalyticsCustomModulesPagedResponse pagedListResponse =
        client.listEffectiveSecurityHealthAnalyticsCustomModules(parent);

    List<EffectiveSecurityHealthAnalyticsCustomModule> resources =
        Lists.newArrayList(pagedListResponse.iterateAll());

    Assert.assertEquals(1, resources.size());
    Assert.assertEquals(
        expectedResponse.getEffectiveSecurityHealthAnalyticsCustomModulesList().get(0),
        resources.get(0));

    List<AbstractMessage> actualRequests = mockSecurityCenterManagement.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    ListEffectiveSecurityHealthAnalyticsCustomModulesRequest actualRequest =
        ((ListEffectiveSecurityHealthAnalyticsCustomModulesRequest) actualRequests.get(0));

    Assert.assertEquals(parent.toString(), actualRequest.getParent());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void listEffectiveSecurityHealthAnalyticsCustomModulesExceptionTest2() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockSecurityCenterManagement.addException(exception);

    try {
      LocationName parent = LocationName.of("[PROJECT]", "[LOCATION]");
      client.listEffectiveSecurityHealthAnalyticsCustomModules(parent);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void listEffectiveSecurityHealthAnalyticsCustomModulesTest3() throws Exception {
    EffectiveSecurityHealthAnalyticsCustomModule responsesElement =
        EffectiveSecurityHealthAnalyticsCustomModule.newBuilder().build();
    ListEffectiveSecurityHealthAnalyticsCustomModulesResponse expectedResponse =
        ListEffectiveSecurityHealthAnalyticsCustomModulesResponse.newBuilder()
            .setNextPageToken("")
            .addAllEffectiveSecurityHealthAnalyticsCustomModules(Arrays.asList(responsesElement))
            .build();
    mockSecurityCenterManagement.addResponse(expectedResponse);

    OrganizationLocationName parent = OrganizationLocationName.of("[ORGANIZATION]", "[LOCATION]");

    ListEffectiveSecurityHealthAnalyticsCustomModulesPagedResponse pagedListResponse =
        client.listEffectiveSecurityHealthAnalyticsCustomModules(parent);

    List<EffectiveSecurityHealthAnalyticsCustomModule> resources =
        Lists.newArrayList(pagedListResponse.iterateAll());

    Assert.assertEquals(1, resources.size());
    Assert.assertEquals(
        expectedResponse.getEffectiveSecurityHealthAnalyticsCustomModulesList().get(0),
        resources.get(0));

    List<AbstractMessage> actualRequests = mockSecurityCenterManagement.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    ListEffectiveSecurityHealthAnalyticsCustomModulesRequest actualRequest =
        ((ListEffectiveSecurityHealthAnalyticsCustomModulesRequest) actualRequests.get(0));

    Assert.assertEquals(parent.toString(), actualRequest.getParent());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void listEffectiveSecurityHealthAnalyticsCustomModulesExceptionTest3() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockSecurityCenterManagement.addException(exception);

    try {
      OrganizationLocationName parent = OrganizationLocationName.of("[ORGANIZATION]", "[LOCATION]");
      client.listEffectiveSecurityHealthAnalyticsCustomModules(parent);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void listEffectiveSecurityHealthAnalyticsCustomModulesTest4() throws Exception {
    EffectiveSecurityHealthAnalyticsCustomModule responsesElement =
        EffectiveSecurityHealthAnalyticsCustomModule.newBuilder().build();
    ListEffectiveSecurityHealthAnalyticsCustomModulesResponse expectedResponse =
        ListEffectiveSecurityHealthAnalyticsCustomModulesResponse.newBuilder()
            .setNextPageToken("")
            .addAllEffectiveSecurityHealthAnalyticsCustomModules(Arrays.asList(responsesElement))
            .build();
    mockSecurityCenterManagement.addResponse(expectedResponse);

    String parent = "parent-995424086";

    ListEffectiveSecurityHealthAnalyticsCustomModulesPagedResponse pagedListResponse =
        client.listEffectiveSecurityHealthAnalyticsCustomModules(parent);

    List<EffectiveSecurityHealthAnalyticsCustomModule> resources =
        Lists.newArrayList(pagedListResponse.iterateAll());

    Assert.assertEquals(1, resources.size());
    Assert.assertEquals(
        expectedResponse.getEffectiveSecurityHealthAnalyticsCustomModulesList().get(0),
        resources.get(0));

    List<AbstractMessage> actualRequests = mockSecurityCenterManagement.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    ListEffectiveSecurityHealthAnalyticsCustomModulesRequest actualRequest =
        ((ListEffectiveSecurityHealthAnalyticsCustomModulesRequest) actualRequests.get(0));

    Assert.assertEquals(parent, actualRequest.getParent());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void listEffectiveSecurityHealthAnalyticsCustomModulesExceptionTest4() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockSecurityCenterManagement.addException(exception);

    try {
      String parent = "parent-995424086";
      client.listEffectiveSecurityHealthAnalyticsCustomModules(parent);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void getEffectiveSecurityHealthAnalyticsCustomModuleTest() throws Exception {
    EffectiveSecurityHealthAnalyticsCustomModule expectedResponse =
        EffectiveSecurityHealthAnalyticsCustomModule.newBuilder()
            .setName(
                EffectiveSecurityHealthAnalyticsCustomModuleName
                    .ofProjectLocationEffectiveSecurityHealthAnalyticsCustomModuleName(
                        "[PROJECT]",
                        "[LOCATION]",
                        "[EFFECTIVE_SECURITY_HEALTH_ANALYTICS_CUSTOM_MODULE]")
                    .toString())
            .setCustomConfig(CustomConfig.newBuilder().build())
            .setDisplayName("displayName1714148973")
            .build();
    mockSecurityCenterManagement.addResponse(expectedResponse);

    EffectiveSecurityHealthAnalyticsCustomModuleName name =
        EffectiveSecurityHealthAnalyticsCustomModuleName
            .ofProjectLocationEffectiveSecurityHealthAnalyticsCustomModuleName(
                "[PROJECT]", "[LOCATION]", "[EFFECTIVE_SECURITY_HEALTH_ANALYTICS_CUSTOM_MODULE]");

    EffectiveSecurityHealthAnalyticsCustomModule actualResponse =
        client.getEffectiveSecurityHealthAnalyticsCustomModule(name);
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockSecurityCenterManagement.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    GetEffectiveSecurityHealthAnalyticsCustomModuleRequest actualRequest =
        ((GetEffectiveSecurityHealthAnalyticsCustomModuleRequest) actualRequests.get(0));

    Assert.assertEquals(name.toString(), actualRequest.getName());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void getEffectiveSecurityHealthAnalyticsCustomModuleExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockSecurityCenterManagement.addException(exception);

    try {
      EffectiveSecurityHealthAnalyticsCustomModuleName name =
          EffectiveSecurityHealthAnalyticsCustomModuleName
              .ofProjectLocationEffectiveSecurityHealthAnalyticsCustomModuleName(
                  "[PROJECT]", "[LOCATION]", "[EFFECTIVE_SECURITY_HEALTH_ANALYTICS_CUSTOM_MODULE]");
      client.getEffectiveSecurityHealthAnalyticsCustomModule(name);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void getEffectiveSecurityHealthAnalyticsCustomModuleTest2() throws Exception {
    EffectiveSecurityHealthAnalyticsCustomModule expectedResponse =
        EffectiveSecurityHealthAnalyticsCustomModule.newBuilder()
            .setName(
                EffectiveSecurityHealthAnalyticsCustomModuleName
                    .ofProjectLocationEffectiveSecurityHealthAnalyticsCustomModuleName(
                        "[PROJECT]",
                        "[LOCATION]",
                        "[EFFECTIVE_SECURITY_HEALTH_ANALYTICS_CUSTOM_MODULE]")
                    .toString())
            .setCustomConfig(CustomConfig.newBuilder().build())
            .setDisplayName("displayName1714148973")
            .build();
    mockSecurityCenterManagement.addResponse(expectedResponse);

    String name = "name3373707";

    EffectiveSecurityHealthAnalyticsCustomModule actualResponse =
        client.getEffectiveSecurityHealthAnalyticsCustomModule(name);
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockSecurityCenterManagement.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    GetEffectiveSecurityHealthAnalyticsCustomModuleRequest actualRequest =
        ((GetEffectiveSecurityHealthAnalyticsCustomModuleRequest) actualRequests.get(0));

    Assert.assertEquals(name, actualRequest.getName());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void getEffectiveSecurityHealthAnalyticsCustomModuleExceptionTest2() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockSecurityCenterManagement.addException(exception);

    try {
      String name = "name3373707";
      client.getEffectiveSecurityHealthAnalyticsCustomModule(name);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void listSecurityHealthAnalyticsCustomModulesTest() throws Exception {
    SecurityHealthAnalyticsCustomModule responsesElement =
        SecurityHealthAnalyticsCustomModule.newBuilder().build();
    ListSecurityHealthAnalyticsCustomModulesResponse expectedResponse =
        ListSecurityHealthAnalyticsCustomModulesResponse.newBuilder()
            .setNextPageToken("")
            .addAllSecurityHealthAnalyticsCustomModules(Arrays.asList(responsesElement))
            .build();
    mockSecurityCenterManagement.addResponse(expectedResponse);

    FolderLocationName parent = FolderLocationName.of("[FOLDER]", "[LOCATION]");

    ListSecurityHealthAnalyticsCustomModulesPagedResponse pagedListResponse =
        client.listSecurityHealthAnalyticsCustomModules(parent);

    List<SecurityHealthAnalyticsCustomModule> resources =
        Lists.newArrayList(pagedListResponse.iterateAll());

    Assert.assertEquals(1, resources.size());
    Assert.assertEquals(
        expectedResponse.getSecurityHealthAnalyticsCustomModulesList().get(0), resources.get(0));

    List<AbstractMessage> actualRequests = mockSecurityCenterManagement.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    ListSecurityHealthAnalyticsCustomModulesRequest actualRequest =
        ((ListSecurityHealthAnalyticsCustomModulesRequest) actualRequests.get(0));

    Assert.assertEquals(parent.toString(), actualRequest.getParent());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void listSecurityHealthAnalyticsCustomModulesExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockSecurityCenterManagement.addException(exception);

    try {
      FolderLocationName parent = FolderLocationName.of("[FOLDER]", "[LOCATION]");
      client.listSecurityHealthAnalyticsCustomModules(parent);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void listSecurityHealthAnalyticsCustomModulesTest2() throws Exception {
    SecurityHealthAnalyticsCustomModule responsesElement =
        SecurityHealthAnalyticsCustomModule.newBuilder().build();
    ListSecurityHealthAnalyticsCustomModulesResponse expectedResponse =
        ListSecurityHealthAnalyticsCustomModulesResponse.newBuilder()
            .setNextPageToken("")
            .addAllSecurityHealthAnalyticsCustomModules(Arrays.asList(responsesElement))
            .build();
    mockSecurityCenterManagement.addResponse(expectedResponse);

    LocationName parent = LocationName.of("[PROJECT]", "[LOCATION]");

    ListSecurityHealthAnalyticsCustomModulesPagedResponse pagedListResponse =
        client.listSecurityHealthAnalyticsCustomModules(parent);

    List<SecurityHealthAnalyticsCustomModule> resources =
        Lists.newArrayList(pagedListResponse.iterateAll());

    Assert.assertEquals(1, resources.size());
    Assert.assertEquals(
        expectedResponse.getSecurityHealthAnalyticsCustomModulesList().get(0), resources.get(0));

    List<AbstractMessage> actualRequests = mockSecurityCenterManagement.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    ListSecurityHealthAnalyticsCustomModulesRequest actualRequest =
        ((ListSecurityHealthAnalyticsCustomModulesRequest) actualRequests.get(0));

    Assert.assertEquals(parent.toString(), actualRequest.getParent());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void listSecurityHealthAnalyticsCustomModulesExceptionTest2() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockSecurityCenterManagement.addException(exception);

    try {
      LocationName parent = LocationName.of("[PROJECT]", "[LOCATION]");
      client.listSecurityHealthAnalyticsCustomModules(parent);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void listSecurityHealthAnalyticsCustomModulesTest3() throws Exception {
    SecurityHealthAnalyticsCustomModule responsesElement =
        SecurityHealthAnalyticsCustomModule.newBuilder().build();
    ListSecurityHealthAnalyticsCustomModulesResponse expectedResponse =
        ListSecurityHealthAnalyticsCustomModulesResponse.newBuilder()
            .setNextPageToken("")
            .addAllSecurityHealthAnalyticsCustomModules(Arrays.asList(responsesElement))
            .build();
    mockSecurityCenterManagement.addResponse(expectedResponse);

    OrganizationLocationName parent = OrganizationLocationName.of("[ORGANIZATION]", "[LOCATION]");

    ListSecurityHealthAnalyticsCustomModulesPagedResponse pagedListResponse =
        client.listSecurityHealthAnalyticsCustomModules(parent);

    List<SecurityHealthAnalyticsCustomModule> resources =
        Lists.newArrayList(pagedListResponse.iterateAll());

    Assert.assertEquals(1, resources.size());
    Assert.assertEquals(
        expectedResponse.getSecurityHealthAnalyticsCustomModulesList().get(0), resources.get(0));

    List<AbstractMessage> actualRequests = mockSecurityCenterManagement.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    ListSecurityHealthAnalyticsCustomModulesRequest actualRequest =
        ((ListSecurityHealthAnalyticsCustomModulesRequest) actualRequests.get(0));

    Assert.assertEquals(parent.toString(), actualRequest.getParent());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void listSecurityHealthAnalyticsCustomModulesExceptionTest3() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockSecurityCenterManagement.addException(exception);

    try {
      OrganizationLocationName parent = OrganizationLocationName.of("[ORGANIZATION]", "[LOCATION]");
      client.listSecurityHealthAnalyticsCustomModules(parent);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void listSecurityHealthAnalyticsCustomModulesTest4() throws Exception {
    SecurityHealthAnalyticsCustomModule responsesElement =
        SecurityHealthAnalyticsCustomModule.newBuilder().build();
    ListSecurityHealthAnalyticsCustomModulesResponse expectedResponse =
        ListSecurityHealthAnalyticsCustomModulesResponse.newBuilder()
            .setNextPageToken("")
            .addAllSecurityHealthAnalyticsCustomModules(Arrays.asList(responsesElement))
            .build();
    mockSecurityCenterManagement.addResponse(expectedResponse);

    String parent = "parent-995424086";

    ListSecurityHealthAnalyticsCustomModulesPagedResponse pagedListResponse =
        client.listSecurityHealthAnalyticsCustomModules(parent);

    List<SecurityHealthAnalyticsCustomModule> resources =
        Lists.newArrayList(pagedListResponse.iterateAll());

    Assert.assertEquals(1, resources.size());
    Assert.assertEquals(
        expectedResponse.getSecurityHealthAnalyticsCustomModulesList().get(0), resources.get(0));

    List<AbstractMessage> actualRequests = mockSecurityCenterManagement.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    ListSecurityHealthAnalyticsCustomModulesRequest actualRequest =
        ((ListSecurityHealthAnalyticsCustomModulesRequest) actualRequests.get(0));

    Assert.assertEquals(parent, actualRequest.getParent());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void listSecurityHealthAnalyticsCustomModulesExceptionTest4() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockSecurityCenterManagement.addException(exception);

    try {
      String parent = "parent-995424086";
      client.listSecurityHealthAnalyticsCustomModules(parent);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void listDescendantSecurityHealthAnalyticsCustomModulesTest() throws Exception {
    SecurityHealthAnalyticsCustomModule responsesElement =
        SecurityHealthAnalyticsCustomModule.newBuilder().build();
    ListDescendantSecurityHealthAnalyticsCustomModulesResponse expectedResponse =
        ListDescendantSecurityHealthAnalyticsCustomModulesResponse.newBuilder()
            .setNextPageToken("")
            .addAllSecurityHealthAnalyticsCustomModules(Arrays.asList(responsesElement))
            .build();
    mockSecurityCenterManagement.addResponse(expectedResponse);

    FolderLocationName parent = FolderLocationName.of("[FOLDER]", "[LOCATION]");

    ListDescendantSecurityHealthAnalyticsCustomModulesPagedResponse pagedListResponse =
        client.listDescendantSecurityHealthAnalyticsCustomModules(parent);

    List<SecurityHealthAnalyticsCustomModule> resources =
        Lists.newArrayList(pagedListResponse.iterateAll());

    Assert.assertEquals(1, resources.size());
    Assert.assertEquals(
        expectedResponse.getSecurityHealthAnalyticsCustomModulesList().get(0), resources.get(0));

    List<AbstractMessage> actualRequests = mockSecurityCenterManagement.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    ListDescendantSecurityHealthAnalyticsCustomModulesRequest actualRequest =
        ((ListDescendantSecurityHealthAnalyticsCustomModulesRequest) actualRequests.get(0));

    Assert.assertEquals(parent.toString(), actualRequest.getParent());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void listDescendantSecurityHealthAnalyticsCustomModulesExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockSecurityCenterManagement.addException(exception);

    try {
      FolderLocationName parent = FolderLocationName.of("[FOLDER]", "[LOCATION]");
      client.listDescendantSecurityHealthAnalyticsCustomModules(parent);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void listDescendantSecurityHealthAnalyticsCustomModulesTest2() throws Exception {
    SecurityHealthAnalyticsCustomModule responsesElement =
        SecurityHealthAnalyticsCustomModule.newBuilder().build();
    ListDescendantSecurityHealthAnalyticsCustomModulesResponse expectedResponse =
        ListDescendantSecurityHealthAnalyticsCustomModulesResponse.newBuilder()
            .setNextPageToken("")
            .addAllSecurityHealthAnalyticsCustomModules(Arrays.asList(responsesElement))
            .build();
    mockSecurityCenterManagement.addResponse(expectedResponse);

    LocationName parent = LocationName.of("[PROJECT]", "[LOCATION]");

    ListDescendantSecurityHealthAnalyticsCustomModulesPagedResponse pagedListResponse =
        client.listDescendantSecurityHealthAnalyticsCustomModules(parent);

    List<SecurityHealthAnalyticsCustomModule> resources =
        Lists.newArrayList(pagedListResponse.iterateAll());

    Assert.assertEquals(1, resources.size());
    Assert.assertEquals(
        expectedResponse.getSecurityHealthAnalyticsCustomModulesList().get(0), resources.get(0));

    List<AbstractMessage> actualRequests = mockSecurityCenterManagement.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    ListDescendantSecurityHealthAnalyticsCustomModulesRequest actualRequest =
        ((ListDescendantSecurityHealthAnalyticsCustomModulesRequest) actualRequests.get(0));

    Assert.assertEquals(parent.toString(), actualRequest.getParent());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void listDescendantSecurityHealthAnalyticsCustomModulesExceptionTest2() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockSecurityCenterManagement.addException(exception);

    try {
      LocationName parent = LocationName.of("[PROJECT]", "[LOCATION]");
      client.listDescendantSecurityHealthAnalyticsCustomModules(parent);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void listDescendantSecurityHealthAnalyticsCustomModulesTest3() throws Exception {
    SecurityHealthAnalyticsCustomModule responsesElement =
        SecurityHealthAnalyticsCustomModule.newBuilder().build();
    ListDescendantSecurityHealthAnalyticsCustomModulesResponse expectedResponse =
        ListDescendantSecurityHealthAnalyticsCustomModulesResponse.newBuilder()
            .setNextPageToken("")
            .addAllSecurityHealthAnalyticsCustomModules(Arrays.asList(responsesElement))
            .build();
    mockSecurityCenterManagement.addResponse(expectedResponse);

    OrganizationLocationName parent = OrganizationLocationName.of("[ORGANIZATION]", "[LOCATION]");

    ListDescendantSecurityHealthAnalyticsCustomModulesPagedResponse pagedListResponse =
        client.listDescendantSecurityHealthAnalyticsCustomModules(parent);

    List<SecurityHealthAnalyticsCustomModule> resources =
        Lists.newArrayList(pagedListResponse.iterateAll());

    Assert.assertEquals(1, resources.size());
    Assert.assertEquals(
        expectedResponse.getSecurityHealthAnalyticsCustomModulesList().get(0), resources.get(0));

    List<AbstractMessage> actualRequests = mockSecurityCenterManagement.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    ListDescendantSecurityHealthAnalyticsCustomModulesRequest actualRequest =
        ((ListDescendantSecurityHealthAnalyticsCustomModulesRequest) actualRequests.get(0));

    Assert.assertEquals(parent.toString(), actualRequest.getParent());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void listDescendantSecurityHealthAnalyticsCustomModulesExceptionTest3() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockSecurityCenterManagement.addException(exception);

    try {
      OrganizationLocationName parent = OrganizationLocationName.of("[ORGANIZATION]", "[LOCATION]");
      client.listDescendantSecurityHealthAnalyticsCustomModules(parent);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void listDescendantSecurityHealthAnalyticsCustomModulesTest4() throws Exception {
    SecurityHealthAnalyticsCustomModule responsesElement =
        SecurityHealthAnalyticsCustomModule.newBuilder().build();
    ListDescendantSecurityHealthAnalyticsCustomModulesResponse expectedResponse =
        ListDescendantSecurityHealthAnalyticsCustomModulesResponse.newBuilder()
            .setNextPageToken("")
            .addAllSecurityHealthAnalyticsCustomModules(Arrays.asList(responsesElement))
            .build();
    mockSecurityCenterManagement.addResponse(expectedResponse);

    String parent = "parent-995424086";

    ListDescendantSecurityHealthAnalyticsCustomModulesPagedResponse pagedListResponse =
        client.listDescendantSecurityHealthAnalyticsCustomModules(parent);

    List<SecurityHealthAnalyticsCustomModule> resources =
        Lists.newArrayList(pagedListResponse.iterateAll());

    Assert.assertEquals(1, resources.size());
    Assert.assertEquals(
        expectedResponse.getSecurityHealthAnalyticsCustomModulesList().get(0), resources.get(0));

    List<AbstractMessage> actualRequests = mockSecurityCenterManagement.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    ListDescendantSecurityHealthAnalyticsCustomModulesRequest actualRequest =
        ((ListDescendantSecurityHealthAnalyticsCustomModulesRequest) actualRequests.get(0));

    Assert.assertEquals(parent, actualRequest.getParent());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void listDescendantSecurityHealthAnalyticsCustomModulesExceptionTest4() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockSecurityCenterManagement.addException(exception);

    try {
      String parent = "parent-995424086";
      client.listDescendantSecurityHealthAnalyticsCustomModules(parent);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void getSecurityHealthAnalyticsCustomModuleTest() throws Exception {
    SecurityHealthAnalyticsCustomModule expectedResponse =
        SecurityHealthAnalyticsCustomModule.newBuilder()
            .setName(
                SecurityHealthAnalyticsCustomModuleName
                    .ofProjectLocationSecurityHealthAnalyticsCustomModuleName(
                        "[PROJECT]", "[LOCATION]", "[SECURITY_HEALTH_ANALYTICS_CUSTOM_MODULE]")
                    .toString())
            .setDisplayName("displayName1714148973")
            .setUpdateTime(Timestamp.newBuilder().build())
            .setLastEditor("lastEditor1523898275")
            .setAncestorModule(
                SecurityHealthAnalyticsCustomModuleName
                    .ofProjectLocationSecurityHealthAnalyticsCustomModuleName(
                        "[PROJECT]", "[LOCATION]", "[SECURITY_HEALTH_ANALYTICS_CUSTOM_MODULE]")
                    .toString())
            .setCustomConfig(CustomConfig.newBuilder().build())
            .build();
    mockSecurityCenterManagement.addResponse(expectedResponse);

    SecurityHealthAnalyticsCustomModuleName name =
        SecurityHealthAnalyticsCustomModuleName
            .ofProjectLocationSecurityHealthAnalyticsCustomModuleName(
                "[PROJECT]", "[LOCATION]", "[SECURITY_HEALTH_ANALYTICS_CUSTOM_MODULE]");

    SecurityHealthAnalyticsCustomModule actualResponse =
        client.getSecurityHealthAnalyticsCustomModule(name);
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockSecurityCenterManagement.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    GetSecurityHealthAnalyticsCustomModuleRequest actualRequest =
        ((GetSecurityHealthAnalyticsCustomModuleRequest) actualRequests.get(0));

    Assert.assertEquals(name.toString(), actualRequest.getName());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void getSecurityHealthAnalyticsCustomModuleExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockSecurityCenterManagement.addException(exception);

    try {
      SecurityHealthAnalyticsCustomModuleName name =
          SecurityHealthAnalyticsCustomModuleName
              .ofProjectLocationSecurityHealthAnalyticsCustomModuleName(
                  "[PROJECT]", "[LOCATION]", "[SECURITY_HEALTH_ANALYTICS_CUSTOM_MODULE]");
      client.getSecurityHealthAnalyticsCustomModule(name);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void getSecurityHealthAnalyticsCustomModuleTest2() throws Exception {
    SecurityHealthAnalyticsCustomModule expectedResponse =
        SecurityHealthAnalyticsCustomModule.newBuilder()
            .setName(
                SecurityHealthAnalyticsCustomModuleName
                    .ofProjectLocationSecurityHealthAnalyticsCustomModuleName(
                        "[PROJECT]", "[LOCATION]", "[SECURITY_HEALTH_ANALYTICS_CUSTOM_MODULE]")
                    .toString())
            .setDisplayName("displayName1714148973")
            .setUpdateTime(Timestamp.newBuilder().build())
            .setLastEditor("lastEditor1523898275")
            .setAncestorModule(
                SecurityHealthAnalyticsCustomModuleName
                    .ofProjectLocationSecurityHealthAnalyticsCustomModuleName(
                        "[PROJECT]", "[LOCATION]", "[SECURITY_HEALTH_ANALYTICS_CUSTOM_MODULE]")
                    .toString())
            .setCustomConfig(CustomConfig.newBuilder().build())
            .build();
    mockSecurityCenterManagement.addResponse(expectedResponse);

    String name = "name3373707";

    SecurityHealthAnalyticsCustomModule actualResponse =
        client.getSecurityHealthAnalyticsCustomModule(name);
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockSecurityCenterManagement.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    GetSecurityHealthAnalyticsCustomModuleRequest actualRequest =
        ((GetSecurityHealthAnalyticsCustomModuleRequest) actualRequests.get(0));

    Assert.assertEquals(name, actualRequest.getName());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void getSecurityHealthAnalyticsCustomModuleExceptionTest2() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockSecurityCenterManagement.addException(exception);

    try {
      String name = "name3373707";
      client.getSecurityHealthAnalyticsCustomModule(name);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void createSecurityHealthAnalyticsCustomModuleTest() throws Exception {
    SecurityHealthAnalyticsCustomModule expectedResponse =
        SecurityHealthAnalyticsCustomModule.newBuilder()
            .setName(
                SecurityHealthAnalyticsCustomModuleName
                    .ofOrganizationLocationSecurityHealthAnalyticsCustomModuleName(
                        "[ORGANIZATION]", "[LOCATION]", "[SECURITY_HEALTH_ANALYTICS_CUSTOM_MODULE]")
                    .toString())
            .setDisplayName("displayName1714148973")
            .setUpdateTime(Timestamp.newBuilder().build())
            .setLastEditor("lastEditor1523898275")
            .setAncestorModule(
                SecurityHealthAnalyticsCustomModuleName
                    .ofOrganizationLocationSecurityHealthAnalyticsCustomModuleName(
                        "[ORGANIZATION]", "[LOCATION]", "[SECURITY_HEALTH_ANALYTICS_CUSTOM_MODULE]")
                    .toString())
            .setCustomConfig(CustomConfig.newBuilder().build())
            .build();
    mockSecurityCenterManagement.addResponse(expectedResponse);

    FolderLocationName parent = FolderLocationName.of("[FOLDER]", "[LOCATION]");
    SecurityHealthAnalyticsCustomModule securityHealthAnalyticsCustomModule =
        SecurityHealthAnalyticsCustomModule.newBuilder().build();

    SecurityHealthAnalyticsCustomModule actualResponse =
        client.createSecurityHealthAnalyticsCustomModule(
            parent, securityHealthAnalyticsCustomModule);
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockSecurityCenterManagement.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    CreateSecurityHealthAnalyticsCustomModuleRequest actualRequest =
        ((CreateSecurityHealthAnalyticsCustomModuleRequest) actualRequests.get(0));

    Assert.assertEquals(parent.toString(), actualRequest.getParent());
    Assert.assertEquals(
        securityHealthAnalyticsCustomModule,
        actualRequest.getSecurityHealthAnalyticsCustomModule());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void createSecurityHealthAnalyticsCustomModuleExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockSecurityCenterManagement.addException(exception);

    try {
      FolderLocationName parent = FolderLocationName.of("[FOLDER]", "[LOCATION]");
      SecurityHealthAnalyticsCustomModule securityHealthAnalyticsCustomModule =
          SecurityHealthAnalyticsCustomModule.newBuilder().build();
      client.createSecurityHealthAnalyticsCustomModule(parent, securityHealthAnalyticsCustomModule);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void createSecurityHealthAnalyticsCustomModuleTest2() throws Exception {
    SecurityHealthAnalyticsCustomModule expectedResponse =
        SecurityHealthAnalyticsCustomModule.newBuilder()
            .setName(
                SecurityHealthAnalyticsCustomModuleName
                    .ofOrganizationLocationSecurityHealthAnalyticsCustomModuleName(
                        "[ORGANIZATION]", "[LOCATION]", "[SECURITY_HEALTH_ANALYTICS_CUSTOM_MODULE]")
                    .toString())
            .setDisplayName("displayName1714148973")
            .setUpdateTime(Timestamp.newBuilder().build())
            .setLastEditor("lastEditor1523898275")
            .setAncestorModule(
                SecurityHealthAnalyticsCustomModuleName
                    .ofOrganizationLocationSecurityHealthAnalyticsCustomModuleName(
                        "[ORGANIZATION]", "[LOCATION]", "[SECURITY_HEALTH_ANALYTICS_CUSTOM_MODULE]")
                    .toString())
            .setCustomConfig(CustomConfig.newBuilder().build())
            .build();
    mockSecurityCenterManagement.addResponse(expectedResponse);

    LocationName parent = LocationName.of("[PROJECT]", "[LOCATION]");
    SecurityHealthAnalyticsCustomModule securityHealthAnalyticsCustomModule =
        SecurityHealthAnalyticsCustomModule.newBuilder().build();

    SecurityHealthAnalyticsCustomModule actualResponse =
        client.createSecurityHealthAnalyticsCustomModule(
            parent, securityHealthAnalyticsCustomModule);
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockSecurityCenterManagement.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    CreateSecurityHealthAnalyticsCustomModuleRequest actualRequest =
        ((CreateSecurityHealthAnalyticsCustomModuleRequest) actualRequests.get(0));

    Assert.assertEquals(parent.toString(), actualRequest.getParent());
    Assert.assertEquals(
        securityHealthAnalyticsCustomModule,
        actualRequest.getSecurityHealthAnalyticsCustomModule());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void createSecurityHealthAnalyticsCustomModuleExceptionTest2() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockSecurityCenterManagement.addException(exception);

    try {
      LocationName parent = LocationName.of("[PROJECT]", "[LOCATION]");
      SecurityHealthAnalyticsCustomModule securityHealthAnalyticsCustomModule =
          SecurityHealthAnalyticsCustomModule.newBuilder().build();
      client.createSecurityHealthAnalyticsCustomModule(parent, securityHealthAnalyticsCustomModule);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void createSecurityHealthAnalyticsCustomModuleTest3() throws Exception {
    SecurityHealthAnalyticsCustomModule expectedResponse =
        SecurityHealthAnalyticsCustomModule.newBuilder()
            .setName(
                SecurityHealthAnalyticsCustomModuleName
                    .ofOrganizationLocationSecurityHealthAnalyticsCustomModuleName(
                        "[ORGANIZATION]", "[LOCATION]", "[SECURITY_HEALTH_ANALYTICS_CUSTOM_MODULE]")
                    .toString())
            .setDisplayName("displayName1714148973")
            .setUpdateTime(Timestamp.newBuilder().build())
            .setLastEditor("lastEditor1523898275")
            .setAncestorModule(
                SecurityHealthAnalyticsCustomModuleName
                    .ofOrganizationLocationSecurityHealthAnalyticsCustomModuleName(
                        "[ORGANIZATION]", "[LOCATION]", "[SECURITY_HEALTH_ANALYTICS_CUSTOM_MODULE]")
                    .toString())
            .setCustomConfig(CustomConfig.newBuilder().build())
            .build();
    mockSecurityCenterManagement.addResponse(expectedResponse);

    OrganizationLocationName parent = OrganizationLocationName.of("[ORGANIZATION]", "[LOCATION]");
    SecurityHealthAnalyticsCustomModule securityHealthAnalyticsCustomModule =
        SecurityHealthAnalyticsCustomModule.newBuilder().build();

    SecurityHealthAnalyticsCustomModule actualResponse =
        client.createSecurityHealthAnalyticsCustomModule(
            parent, securityHealthAnalyticsCustomModule);
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockSecurityCenterManagement.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    CreateSecurityHealthAnalyticsCustomModuleRequest actualRequest =
        ((CreateSecurityHealthAnalyticsCustomModuleRequest) actualRequests.get(0));

    Assert.assertEquals(parent.toString(), actualRequest.getParent());
    Assert.assertEquals(
        securityHealthAnalyticsCustomModule,
        actualRequest.getSecurityHealthAnalyticsCustomModule());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void createSecurityHealthAnalyticsCustomModuleExceptionTest3() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockSecurityCenterManagement.addException(exception);

    try {
      OrganizationLocationName parent = OrganizationLocationName.of("[ORGANIZATION]", "[LOCATION]");
      SecurityHealthAnalyticsCustomModule securityHealthAnalyticsCustomModule =
          SecurityHealthAnalyticsCustomModule.newBuilder().build();
      client.createSecurityHealthAnalyticsCustomModule(parent, securityHealthAnalyticsCustomModule);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void createSecurityHealthAnalyticsCustomModuleTest4() throws Exception {
    SecurityHealthAnalyticsCustomModule expectedResponse =
        SecurityHealthAnalyticsCustomModule.newBuilder()
            .setName(
                SecurityHealthAnalyticsCustomModuleName
                    .ofOrganizationLocationSecurityHealthAnalyticsCustomModuleName(
                        "[ORGANIZATION]", "[LOCATION]", "[SECURITY_HEALTH_ANALYTICS_CUSTOM_MODULE]")
                    .toString())
            .setDisplayName("displayName1714148973")
            .setUpdateTime(Timestamp.newBuilder().build())
            .setLastEditor("lastEditor1523898275")
            .setAncestorModule(
                SecurityHealthAnalyticsCustomModuleName
                    .ofOrganizationLocationSecurityHealthAnalyticsCustomModuleName(
                        "[ORGANIZATION]", "[LOCATION]", "[SECURITY_HEALTH_ANALYTICS_CUSTOM_MODULE]")
                    .toString())
            .setCustomConfig(CustomConfig.newBuilder().build())
            .build();
    mockSecurityCenterManagement.addResponse(expectedResponse);

    String parent = "parent-995424086";
    SecurityHealthAnalyticsCustomModule securityHealthAnalyticsCustomModule =
        SecurityHealthAnalyticsCustomModule.newBuilder().build();

    SecurityHealthAnalyticsCustomModule actualResponse =
        client.createSecurityHealthAnalyticsCustomModule(
            parent, securityHealthAnalyticsCustomModule);
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockSecurityCenterManagement.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    CreateSecurityHealthAnalyticsCustomModuleRequest actualRequest =
        ((CreateSecurityHealthAnalyticsCustomModuleRequest) actualRequests.get(0));

    Assert.assertEquals(parent, actualRequest.getParent());
    Assert.assertEquals(
        securityHealthAnalyticsCustomModule,
        actualRequest.getSecurityHealthAnalyticsCustomModule());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void createSecurityHealthAnalyticsCustomModuleExceptionTest4() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockSecurityCenterManagement.addException(exception);

    try {
      String parent = "parent-995424086";
      SecurityHealthAnalyticsCustomModule securityHealthAnalyticsCustomModule =
          SecurityHealthAnalyticsCustomModule.newBuilder().build();
      client.createSecurityHealthAnalyticsCustomModule(parent, securityHealthAnalyticsCustomModule);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void updateSecurityHealthAnalyticsCustomModuleTest() throws Exception {
    SecurityHealthAnalyticsCustomModule expectedResponse =
        SecurityHealthAnalyticsCustomModule.newBuilder()
            .setName(
                SecurityHealthAnalyticsCustomModuleName
                    .ofProjectLocationSecurityHealthAnalyticsCustomModuleName(
                        "[PROJECT]", "[LOCATION]", "[SECURITY_HEALTH_ANALYTICS_CUSTOM_MODULE]")
                    .toString())
            .setDisplayName("displayName1714148973")
            .setUpdateTime(Timestamp.newBuilder().build())
            .setLastEditor("lastEditor1523898275")
            .setAncestorModule(
                SecurityHealthAnalyticsCustomModuleName
                    .ofProjectLocationSecurityHealthAnalyticsCustomModuleName(
                        "[PROJECT]", "[LOCATION]", "[SECURITY_HEALTH_ANALYTICS_CUSTOM_MODULE]")
                    .toString())
            .setCustomConfig(CustomConfig.newBuilder().build())
            .build();
    mockSecurityCenterManagement.addResponse(expectedResponse);

    SecurityHealthAnalyticsCustomModule securityHealthAnalyticsCustomModule =
        SecurityHealthAnalyticsCustomModule.newBuilder().build();
    FieldMask updateMask = FieldMask.newBuilder().build();

    SecurityHealthAnalyticsCustomModule actualResponse =
        client.updateSecurityHealthAnalyticsCustomModule(
            securityHealthAnalyticsCustomModule, updateMask);
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockSecurityCenterManagement.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    UpdateSecurityHealthAnalyticsCustomModuleRequest actualRequest =
        ((UpdateSecurityHealthAnalyticsCustomModuleRequest) actualRequests.get(0));

    Assert.assertEquals(
        securityHealthAnalyticsCustomModule,
        actualRequest.getSecurityHealthAnalyticsCustomModule());
    Assert.assertEquals(updateMask, actualRequest.getUpdateMask());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void updateSecurityHealthAnalyticsCustomModuleExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockSecurityCenterManagement.addException(exception);

    try {
      SecurityHealthAnalyticsCustomModule securityHealthAnalyticsCustomModule =
          SecurityHealthAnalyticsCustomModule.newBuilder().build();
      FieldMask updateMask = FieldMask.newBuilder().build();
      client.updateSecurityHealthAnalyticsCustomModule(
          securityHealthAnalyticsCustomModule, updateMask);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void deleteSecurityHealthAnalyticsCustomModuleTest() throws Exception {
    Empty expectedResponse = Empty.newBuilder().build();
    mockSecurityCenterManagement.addResponse(expectedResponse);

    SecurityHealthAnalyticsCustomModuleName name =
        SecurityHealthAnalyticsCustomModuleName
            .ofProjectLocationSecurityHealthAnalyticsCustomModuleName(
                "[PROJECT]", "[LOCATION]", "[SECURITY_HEALTH_ANALYTICS_CUSTOM_MODULE]");

    client.deleteSecurityHealthAnalyticsCustomModule(name);

    List<AbstractMessage> actualRequests = mockSecurityCenterManagement.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    DeleteSecurityHealthAnalyticsCustomModuleRequest actualRequest =
        ((DeleteSecurityHealthAnalyticsCustomModuleRequest) actualRequests.get(0));

    Assert.assertEquals(name.toString(), actualRequest.getName());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void deleteSecurityHealthAnalyticsCustomModuleExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockSecurityCenterManagement.addException(exception);

    try {
      SecurityHealthAnalyticsCustomModuleName name =
          SecurityHealthAnalyticsCustomModuleName
              .ofProjectLocationSecurityHealthAnalyticsCustomModuleName(
                  "[PROJECT]", "[LOCATION]", "[SECURITY_HEALTH_ANALYTICS_CUSTOM_MODULE]");
      client.deleteSecurityHealthAnalyticsCustomModule(name);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void deleteSecurityHealthAnalyticsCustomModuleTest2() throws Exception {
    Empty expectedResponse = Empty.newBuilder().build();
    mockSecurityCenterManagement.addResponse(expectedResponse);

    String name = "name3373707";

    client.deleteSecurityHealthAnalyticsCustomModule(name);

    List<AbstractMessage> actualRequests = mockSecurityCenterManagement.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    DeleteSecurityHealthAnalyticsCustomModuleRequest actualRequest =
        ((DeleteSecurityHealthAnalyticsCustomModuleRequest) actualRequests.get(0));

    Assert.assertEquals(name, actualRequest.getName());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void deleteSecurityHealthAnalyticsCustomModuleExceptionTest2() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockSecurityCenterManagement.addException(exception);

    try {
      String name = "name3373707";
      client.deleteSecurityHealthAnalyticsCustomModule(name);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void simulateSecurityHealthAnalyticsCustomModuleTest() throws Exception {
    SimulateSecurityHealthAnalyticsCustomModuleResponse expectedResponse =
        SimulateSecurityHealthAnalyticsCustomModuleResponse.newBuilder()
            .setResult(
                SimulateSecurityHealthAnalyticsCustomModuleResponse.SimulatedResult.newBuilder()
                    .build())
            .build();
    mockSecurityCenterManagement.addResponse(expectedResponse);

    String parent = "parent-995424086";
    CustomConfig customConfig = CustomConfig.newBuilder().build();
    SimulateSecurityHealthAnalyticsCustomModuleRequest.SimulatedResource resource =
        SimulateSecurityHealthAnalyticsCustomModuleRequest.SimulatedResource.newBuilder().build();

    SimulateSecurityHealthAnalyticsCustomModuleResponse actualResponse =
        client.simulateSecurityHealthAnalyticsCustomModule(parent, customConfig, resource);
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockSecurityCenterManagement.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    SimulateSecurityHealthAnalyticsCustomModuleRequest actualRequest =
        ((SimulateSecurityHealthAnalyticsCustomModuleRequest) actualRequests.get(0));

    Assert.assertEquals(parent, actualRequest.getParent());
    Assert.assertEquals(customConfig, actualRequest.getCustomConfig());
    Assert.assertEquals(resource, actualRequest.getResource());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void simulateSecurityHealthAnalyticsCustomModuleExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockSecurityCenterManagement.addException(exception);

    try {
      String parent = "parent-995424086";
      CustomConfig customConfig = CustomConfig.newBuilder().build();
      SimulateSecurityHealthAnalyticsCustomModuleRequest.SimulatedResource resource =
          SimulateSecurityHealthAnalyticsCustomModuleRequest.SimulatedResource.newBuilder().build();
      client.simulateSecurityHealthAnalyticsCustomModule(parent, customConfig, resource);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void listEffectiveEventThreatDetectionCustomModulesTest() throws Exception {
    EffectiveEventThreatDetectionCustomModule responsesElement =
        EffectiveEventThreatDetectionCustomModule.newBuilder().build();
    ListEffectiveEventThreatDetectionCustomModulesResponse expectedResponse =
        ListEffectiveEventThreatDetectionCustomModulesResponse.newBuilder()
            .setNextPageToken("")
            .addAllEffectiveEventThreatDetectionCustomModules(Arrays.asList(responsesElement))
            .build();
    mockSecurityCenterManagement.addResponse(expectedResponse);

    FolderLocationName parent = FolderLocationName.of("[FOLDER]", "[LOCATION]");

    ListEffectiveEventThreatDetectionCustomModulesPagedResponse pagedListResponse =
        client.listEffectiveEventThreatDetectionCustomModules(parent);

    List<EffectiveEventThreatDetectionCustomModule> resources =
        Lists.newArrayList(pagedListResponse.iterateAll());

    Assert.assertEquals(1, resources.size());
    Assert.assertEquals(
        expectedResponse.getEffectiveEventThreatDetectionCustomModulesList().get(0),
        resources.get(0));

    List<AbstractMessage> actualRequests = mockSecurityCenterManagement.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    ListEffectiveEventThreatDetectionCustomModulesRequest actualRequest =
        ((ListEffectiveEventThreatDetectionCustomModulesRequest) actualRequests.get(0));

    Assert.assertEquals(parent.toString(), actualRequest.getParent());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void listEffectiveEventThreatDetectionCustomModulesExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockSecurityCenterManagement.addException(exception);

    try {
      FolderLocationName parent = FolderLocationName.of("[FOLDER]", "[LOCATION]");
      client.listEffectiveEventThreatDetectionCustomModules(parent);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void listEffectiveEventThreatDetectionCustomModulesTest2() throws Exception {
    EffectiveEventThreatDetectionCustomModule responsesElement =
        EffectiveEventThreatDetectionCustomModule.newBuilder().build();
    ListEffectiveEventThreatDetectionCustomModulesResponse expectedResponse =
        ListEffectiveEventThreatDetectionCustomModulesResponse.newBuilder()
            .setNextPageToken("")
            .addAllEffectiveEventThreatDetectionCustomModules(Arrays.asList(responsesElement))
            .build();
    mockSecurityCenterManagement.addResponse(expectedResponse);

    LocationName parent = LocationName.of("[PROJECT]", "[LOCATION]");

    ListEffectiveEventThreatDetectionCustomModulesPagedResponse pagedListResponse =
        client.listEffectiveEventThreatDetectionCustomModules(parent);

    List<EffectiveEventThreatDetectionCustomModule> resources =
        Lists.newArrayList(pagedListResponse.iterateAll());

    Assert.assertEquals(1, resources.size());
    Assert.assertEquals(
        expectedResponse.getEffectiveEventThreatDetectionCustomModulesList().get(0),
        resources.get(0));

    List<AbstractMessage> actualRequests = mockSecurityCenterManagement.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    ListEffectiveEventThreatDetectionCustomModulesRequest actualRequest =
        ((ListEffectiveEventThreatDetectionCustomModulesRequest) actualRequests.get(0));

    Assert.assertEquals(parent.toString(), actualRequest.getParent());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void listEffectiveEventThreatDetectionCustomModulesExceptionTest2() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockSecurityCenterManagement.addException(exception);

    try {
      LocationName parent = LocationName.of("[PROJECT]", "[LOCATION]");
      client.listEffectiveEventThreatDetectionCustomModules(parent);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void listEffectiveEventThreatDetectionCustomModulesTest3() throws Exception {
    EffectiveEventThreatDetectionCustomModule responsesElement =
        EffectiveEventThreatDetectionCustomModule.newBuilder().build();
    ListEffectiveEventThreatDetectionCustomModulesResponse expectedResponse =
        ListEffectiveEventThreatDetectionCustomModulesResponse.newBuilder()
            .setNextPageToken("")
            .addAllEffectiveEventThreatDetectionCustomModules(Arrays.asList(responsesElement))
            .build();
    mockSecurityCenterManagement.addResponse(expectedResponse);

    OrganizationLocationName parent = OrganizationLocationName.of("[ORGANIZATION]", "[LOCATION]");

    ListEffectiveEventThreatDetectionCustomModulesPagedResponse pagedListResponse =
        client.listEffectiveEventThreatDetectionCustomModules(parent);

    List<EffectiveEventThreatDetectionCustomModule> resources =
        Lists.newArrayList(pagedListResponse.iterateAll());

    Assert.assertEquals(1, resources.size());
    Assert.assertEquals(
        expectedResponse.getEffectiveEventThreatDetectionCustomModulesList().get(0),
        resources.get(0));

    List<AbstractMessage> actualRequests = mockSecurityCenterManagement.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    ListEffectiveEventThreatDetectionCustomModulesRequest actualRequest =
        ((ListEffectiveEventThreatDetectionCustomModulesRequest) actualRequests.get(0));

    Assert.assertEquals(parent.toString(), actualRequest.getParent());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void listEffectiveEventThreatDetectionCustomModulesExceptionTest3() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockSecurityCenterManagement.addException(exception);

    try {
      OrganizationLocationName parent = OrganizationLocationName.of("[ORGANIZATION]", "[LOCATION]");
      client.listEffectiveEventThreatDetectionCustomModules(parent);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void listEffectiveEventThreatDetectionCustomModulesTest4() throws Exception {
    EffectiveEventThreatDetectionCustomModule responsesElement =
        EffectiveEventThreatDetectionCustomModule.newBuilder().build();
    ListEffectiveEventThreatDetectionCustomModulesResponse expectedResponse =
        ListEffectiveEventThreatDetectionCustomModulesResponse.newBuilder()
            .setNextPageToken("")
            .addAllEffectiveEventThreatDetectionCustomModules(Arrays.asList(responsesElement))
            .build();
    mockSecurityCenterManagement.addResponse(expectedResponse);

    String parent = "parent-995424086";

    ListEffectiveEventThreatDetectionCustomModulesPagedResponse pagedListResponse =
        client.listEffectiveEventThreatDetectionCustomModules(parent);

    List<EffectiveEventThreatDetectionCustomModule> resources =
        Lists.newArrayList(pagedListResponse.iterateAll());

    Assert.assertEquals(1, resources.size());
    Assert.assertEquals(
        expectedResponse.getEffectiveEventThreatDetectionCustomModulesList().get(0),
        resources.get(0));

    List<AbstractMessage> actualRequests = mockSecurityCenterManagement.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    ListEffectiveEventThreatDetectionCustomModulesRequest actualRequest =
        ((ListEffectiveEventThreatDetectionCustomModulesRequest) actualRequests.get(0));

    Assert.assertEquals(parent, actualRequest.getParent());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void listEffectiveEventThreatDetectionCustomModulesExceptionTest4() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockSecurityCenterManagement.addException(exception);

    try {
      String parent = "parent-995424086";
      client.listEffectiveEventThreatDetectionCustomModules(parent);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void getEffectiveEventThreatDetectionCustomModuleTest() throws Exception {
    EffectiveEventThreatDetectionCustomModule expectedResponse =
        EffectiveEventThreatDetectionCustomModule.newBuilder()
            .setName(
                EffectiveEventThreatDetectionCustomModuleName
                    .ofProjectLocationEffectiveEventThreatDetectionCustomModuleName(
                        "[PROJECT]",
                        "[LOCATION]",
                        "[EFFECTIVE_EVENT_THREAT_DETECTION_CUSTOM_MODULE]")
                    .toString())
            .setConfig(Struct.newBuilder().build())
            .setType("type3575610")
            .setDisplayName("displayName1714148973")
            .setDescription("description-1724546052")
            .build();
    mockSecurityCenterManagement.addResponse(expectedResponse);

    EffectiveEventThreatDetectionCustomModuleName name =
        EffectiveEventThreatDetectionCustomModuleName
            .ofProjectLocationEffectiveEventThreatDetectionCustomModuleName(
                "[PROJECT]", "[LOCATION]", "[EFFECTIVE_EVENT_THREAT_DETECTION_CUSTOM_MODULE]");

    EffectiveEventThreatDetectionCustomModule actualResponse =
        client.getEffectiveEventThreatDetectionCustomModule(name);
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockSecurityCenterManagement.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    GetEffectiveEventThreatDetectionCustomModuleRequest actualRequest =
        ((GetEffectiveEventThreatDetectionCustomModuleRequest) actualRequests.get(0));

    Assert.assertEquals(name.toString(), actualRequest.getName());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void getEffectiveEventThreatDetectionCustomModuleExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockSecurityCenterManagement.addException(exception);

    try {
      EffectiveEventThreatDetectionCustomModuleName name =
          EffectiveEventThreatDetectionCustomModuleName
              .ofProjectLocationEffectiveEventThreatDetectionCustomModuleName(
                  "[PROJECT]", "[LOCATION]", "[EFFECTIVE_EVENT_THREAT_DETECTION_CUSTOM_MODULE]");
      client.getEffectiveEventThreatDetectionCustomModule(name);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void getEffectiveEventThreatDetectionCustomModuleTest2() throws Exception {
    EffectiveEventThreatDetectionCustomModule expectedResponse =
        EffectiveEventThreatDetectionCustomModule.newBuilder()
            .setName(
                EffectiveEventThreatDetectionCustomModuleName
                    .ofProjectLocationEffectiveEventThreatDetectionCustomModuleName(
                        "[PROJECT]",
                        "[LOCATION]",
                        "[EFFECTIVE_EVENT_THREAT_DETECTION_CUSTOM_MODULE]")
                    .toString())
            .setConfig(Struct.newBuilder().build())
            .setType("type3575610")
            .setDisplayName("displayName1714148973")
            .setDescription("description-1724546052")
            .build();
    mockSecurityCenterManagement.addResponse(expectedResponse);

    String name = "name3373707";

    EffectiveEventThreatDetectionCustomModule actualResponse =
        client.getEffectiveEventThreatDetectionCustomModule(name);
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockSecurityCenterManagement.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    GetEffectiveEventThreatDetectionCustomModuleRequest actualRequest =
        ((GetEffectiveEventThreatDetectionCustomModuleRequest) actualRequests.get(0));

    Assert.assertEquals(name, actualRequest.getName());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void getEffectiveEventThreatDetectionCustomModuleExceptionTest2() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockSecurityCenterManagement.addException(exception);

    try {
      String name = "name3373707";
      client.getEffectiveEventThreatDetectionCustomModule(name);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void listEventThreatDetectionCustomModulesTest() throws Exception {
    EventThreatDetectionCustomModule responsesElement =
        EventThreatDetectionCustomModule.newBuilder().build();
    ListEventThreatDetectionCustomModulesResponse expectedResponse =
        ListEventThreatDetectionCustomModulesResponse.newBuilder()
            .setNextPageToken("")
            .addAllEventThreatDetectionCustomModules(Arrays.asList(responsesElement))
            .build();
    mockSecurityCenterManagement.addResponse(expectedResponse);

    FolderLocationName parent = FolderLocationName.of("[FOLDER]", "[LOCATION]");

    ListEventThreatDetectionCustomModulesPagedResponse pagedListResponse =
        client.listEventThreatDetectionCustomModules(parent);

    List<EventThreatDetectionCustomModule> resources =
        Lists.newArrayList(pagedListResponse.iterateAll());

    Assert.assertEquals(1, resources.size());
    Assert.assertEquals(
        expectedResponse.getEventThreatDetectionCustomModulesList().get(0), resources.get(0));

    List<AbstractMessage> actualRequests = mockSecurityCenterManagement.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    ListEventThreatDetectionCustomModulesRequest actualRequest =
        ((ListEventThreatDetectionCustomModulesRequest) actualRequests.get(0));

    Assert.assertEquals(parent.toString(), actualRequest.getParent());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void listEventThreatDetectionCustomModulesExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockSecurityCenterManagement.addException(exception);

    try {
      FolderLocationName parent = FolderLocationName.of("[FOLDER]", "[LOCATION]");
      client.listEventThreatDetectionCustomModules(parent);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void listEventThreatDetectionCustomModulesTest2() throws Exception {
    EventThreatDetectionCustomModule responsesElement =
        EventThreatDetectionCustomModule.newBuilder().build();
    ListEventThreatDetectionCustomModulesResponse expectedResponse =
        ListEventThreatDetectionCustomModulesResponse.newBuilder()
            .setNextPageToken("")
            .addAllEventThreatDetectionCustomModules(Arrays.asList(responsesElement))
            .build();
    mockSecurityCenterManagement.addResponse(expectedResponse);

    LocationName parent = LocationName.of("[PROJECT]", "[LOCATION]");

    ListEventThreatDetectionCustomModulesPagedResponse pagedListResponse =
        client.listEventThreatDetectionCustomModules(parent);

    List<EventThreatDetectionCustomModule> resources =
        Lists.newArrayList(pagedListResponse.iterateAll());

    Assert.assertEquals(1, resources.size());
    Assert.assertEquals(
        expectedResponse.getEventThreatDetectionCustomModulesList().get(0), resources.get(0));

    List<AbstractMessage> actualRequests = mockSecurityCenterManagement.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    ListEventThreatDetectionCustomModulesRequest actualRequest =
        ((ListEventThreatDetectionCustomModulesRequest) actualRequests.get(0));

    Assert.assertEquals(parent.toString(), actualRequest.getParent());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void listEventThreatDetectionCustomModulesExceptionTest2() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockSecurityCenterManagement.addException(exception);

    try {
      LocationName parent = LocationName.of("[PROJECT]", "[LOCATION]");
      client.listEventThreatDetectionCustomModules(parent);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void listEventThreatDetectionCustomModulesTest3() throws Exception {
    EventThreatDetectionCustomModule responsesElement =
        EventThreatDetectionCustomModule.newBuilder().build();
    ListEventThreatDetectionCustomModulesResponse expectedResponse =
        ListEventThreatDetectionCustomModulesResponse.newBuilder()
            .setNextPageToken("")
            .addAllEventThreatDetectionCustomModules(Arrays.asList(responsesElement))
            .build();
    mockSecurityCenterManagement.addResponse(expectedResponse);

    OrganizationLocationName parent = OrganizationLocationName.of("[ORGANIZATION]", "[LOCATION]");

    ListEventThreatDetectionCustomModulesPagedResponse pagedListResponse =
        client.listEventThreatDetectionCustomModules(parent);

    List<EventThreatDetectionCustomModule> resources =
        Lists.newArrayList(pagedListResponse.iterateAll());

    Assert.assertEquals(1, resources.size());
    Assert.assertEquals(
        expectedResponse.getEventThreatDetectionCustomModulesList().get(0), resources.get(0));

    List<AbstractMessage> actualRequests = mockSecurityCenterManagement.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    ListEventThreatDetectionCustomModulesRequest actualRequest =
        ((ListEventThreatDetectionCustomModulesRequest) actualRequests.get(0));

    Assert.assertEquals(parent.toString(), actualRequest.getParent());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void listEventThreatDetectionCustomModulesExceptionTest3() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockSecurityCenterManagement.addException(exception);

    try {
      OrganizationLocationName parent = OrganizationLocationName.of("[ORGANIZATION]", "[LOCATION]");
      client.listEventThreatDetectionCustomModules(parent);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void listEventThreatDetectionCustomModulesTest4() throws Exception {
    EventThreatDetectionCustomModule responsesElement =
        EventThreatDetectionCustomModule.newBuilder().build();
    ListEventThreatDetectionCustomModulesResponse expectedResponse =
        ListEventThreatDetectionCustomModulesResponse.newBuilder()
            .setNextPageToken("")
            .addAllEventThreatDetectionCustomModules(Arrays.asList(responsesElement))
            .build();
    mockSecurityCenterManagement.addResponse(expectedResponse);

    String parent = "parent-995424086";

    ListEventThreatDetectionCustomModulesPagedResponse pagedListResponse =
        client.listEventThreatDetectionCustomModules(parent);

    List<EventThreatDetectionCustomModule> resources =
        Lists.newArrayList(pagedListResponse.iterateAll());

    Assert.assertEquals(1, resources.size());
    Assert.assertEquals(
        expectedResponse.getEventThreatDetectionCustomModulesList().get(0), resources.get(0));

    List<AbstractMessage> actualRequests = mockSecurityCenterManagement.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    ListEventThreatDetectionCustomModulesRequest actualRequest =
        ((ListEventThreatDetectionCustomModulesRequest) actualRequests.get(0));

    Assert.assertEquals(parent, actualRequest.getParent());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void listEventThreatDetectionCustomModulesExceptionTest4() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockSecurityCenterManagement.addException(exception);

    try {
      String parent = "parent-995424086";
      client.listEventThreatDetectionCustomModules(parent);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void listDescendantEventThreatDetectionCustomModulesTest() throws Exception {
    EventThreatDetectionCustomModule responsesElement =
        EventThreatDetectionCustomModule.newBuilder().build();
    ListDescendantEventThreatDetectionCustomModulesResponse expectedResponse =
        ListDescendantEventThreatDetectionCustomModulesResponse.newBuilder()
            .setNextPageToken("")
            .addAllEventThreatDetectionCustomModules(Arrays.asList(responsesElement))
            .build();
    mockSecurityCenterManagement.addResponse(expectedResponse);

    FolderLocationName parent = FolderLocationName.of("[FOLDER]", "[LOCATION]");

    ListDescendantEventThreatDetectionCustomModulesPagedResponse pagedListResponse =
        client.listDescendantEventThreatDetectionCustomModules(parent);

    List<EventThreatDetectionCustomModule> resources =
        Lists.newArrayList(pagedListResponse.iterateAll());

    Assert.assertEquals(1, resources.size());
    Assert.assertEquals(
        expectedResponse.getEventThreatDetectionCustomModulesList().get(0), resources.get(0));

    List<AbstractMessage> actualRequests = mockSecurityCenterManagement.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    ListDescendantEventThreatDetectionCustomModulesRequest actualRequest =
        ((ListDescendantEventThreatDetectionCustomModulesRequest) actualRequests.get(0));

    Assert.assertEquals(parent.toString(), actualRequest.getParent());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void listDescendantEventThreatDetectionCustomModulesExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockSecurityCenterManagement.addException(exception);

    try {
      FolderLocationName parent = FolderLocationName.of("[FOLDER]", "[LOCATION]");
      client.listDescendantEventThreatDetectionCustomModules(parent);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void listDescendantEventThreatDetectionCustomModulesTest2() throws Exception {
    EventThreatDetectionCustomModule responsesElement =
        EventThreatDetectionCustomModule.newBuilder().build();
    ListDescendantEventThreatDetectionCustomModulesResponse expectedResponse =
        ListDescendantEventThreatDetectionCustomModulesResponse.newBuilder()
            .setNextPageToken("")
            .addAllEventThreatDetectionCustomModules(Arrays.asList(responsesElement))
            .build();
    mockSecurityCenterManagement.addResponse(expectedResponse);

    LocationName parent = LocationName.of("[PROJECT]", "[LOCATION]");

    ListDescendantEventThreatDetectionCustomModulesPagedResponse pagedListResponse =
        client.listDescendantEventThreatDetectionCustomModules(parent);

    List<EventThreatDetectionCustomModule> resources =
        Lists.newArrayList(pagedListResponse.iterateAll());

    Assert.assertEquals(1, resources.size());
    Assert.assertEquals(
        expectedResponse.getEventThreatDetectionCustomModulesList().get(0), resources.get(0));

    List<AbstractMessage> actualRequests = mockSecurityCenterManagement.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    ListDescendantEventThreatDetectionCustomModulesRequest actualRequest =
        ((ListDescendantEventThreatDetectionCustomModulesRequest) actualRequests.get(0));

    Assert.assertEquals(parent.toString(), actualRequest.getParent());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void listDescendantEventThreatDetectionCustomModulesExceptionTest2() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockSecurityCenterManagement.addException(exception);

    try {
      LocationName parent = LocationName.of("[PROJECT]", "[LOCATION]");
      client.listDescendantEventThreatDetectionCustomModules(parent);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void listDescendantEventThreatDetectionCustomModulesTest3() throws Exception {
    EventThreatDetectionCustomModule responsesElement =
        EventThreatDetectionCustomModule.newBuilder().build();
    ListDescendantEventThreatDetectionCustomModulesResponse expectedResponse =
        ListDescendantEventThreatDetectionCustomModulesResponse.newBuilder()
            .setNextPageToken("")
            .addAllEventThreatDetectionCustomModules(Arrays.asList(responsesElement))
            .build();
    mockSecurityCenterManagement.addResponse(expectedResponse);

    OrganizationLocationName parent = OrganizationLocationName.of("[ORGANIZATION]", "[LOCATION]");

    ListDescendantEventThreatDetectionCustomModulesPagedResponse pagedListResponse =
        client.listDescendantEventThreatDetectionCustomModules(parent);

    List<EventThreatDetectionCustomModule> resources =
        Lists.newArrayList(pagedListResponse.iterateAll());

    Assert.assertEquals(1, resources.size());
    Assert.assertEquals(
        expectedResponse.getEventThreatDetectionCustomModulesList().get(0), resources.get(0));

    List<AbstractMessage> actualRequests = mockSecurityCenterManagement.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    ListDescendantEventThreatDetectionCustomModulesRequest actualRequest =
        ((ListDescendantEventThreatDetectionCustomModulesRequest) actualRequests.get(0));

    Assert.assertEquals(parent.toString(), actualRequest.getParent());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void listDescendantEventThreatDetectionCustomModulesExceptionTest3() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockSecurityCenterManagement.addException(exception);

    try {
      OrganizationLocationName parent = OrganizationLocationName.of("[ORGANIZATION]", "[LOCATION]");
      client.listDescendantEventThreatDetectionCustomModules(parent);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void listDescendantEventThreatDetectionCustomModulesTest4() throws Exception {
    EventThreatDetectionCustomModule responsesElement =
        EventThreatDetectionCustomModule.newBuilder().build();
    ListDescendantEventThreatDetectionCustomModulesResponse expectedResponse =
        ListDescendantEventThreatDetectionCustomModulesResponse.newBuilder()
            .setNextPageToken("")
            .addAllEventThreatDetectionCustomModules(Arrays.asList(responsesElement))
            .build();
    mockSecurityCenterManagement.addResponse(expectedResponse);

    String parent = "parent-995424086";

    ListDescendantEventThreatDetectionCustomModulesPagedResponse pagedListResponse =
        client.listDescendantEventThreatDetectionCustomModules(parent);

    List<EventThreatDetectionCustomModule> resources =
        Lists.newArrayList(pagedListResponse.iterateAll());

    Assert.assertEquals(1, resources.size());
    Assert.assertEquals(
        expectedResponse.getEventThreatDetectionCustomModulesList().get(0), resources.get(0));

    List<AbstractMessage> actualRequests = mockSecurityCenterManagement.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    ListDescendantEventThreatDetectionCustomModulesRequest actualRequest =
        ((ListDescendantEventThreatDetectionCustomModulesRequest) actualRequests.get(0));

    Assert.assertEquals(parent, actualRequest.getParent());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void listDescendantEventThreatDetectionCustomModulesExceptionTest4() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockSecurityCenterManagement.addException(exception);

    try {
      String parent = "parent-995424086";
      client.listDescendantEventThreatDetectionCustomModules(parent);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void getEventThreatDetectionCustomModuleTest() throws Exception {
    EventThreatDetectionCustomModule expectedResponse =
        EventThreatDetectionCustomModule.newBuilder()
            .setName(
                EventThreatDetectionCustomModuleName
                    .ofProjectLocationEventThreatDetectionCustomModuleName(
                        "[PROJECT]", "[LOCATION]", "[EVENT_THREAT_DETECTION_CUSTOM_MODULE]")
                    .toString())
            .setConfig(Struct.newBuilder().build())
            .setAncestorModule(
                EventThreatDetectionCustomModuleName
                    .ofProjectLocationEventThreatDetectionCustomModuleName(
                        "[PROJECT]", "[LOCATION]", "[EVENT_THREAT_DETECTION_CUSTOM_MODULE]")
                    .toString())
            .setType("type3575610")
            .setDisplayName("displayName1714148973")
            .setDescription("description-1724546052")
            .setUpdateTime(Timestamp.newBuilder().build())
            .setLastEditor("lastEditor1523898275")
            .build();
    mockSecurityCenterManagement.addResponse(expectedResponse);

    EventThreatDetectionCustomModuleName name =
        EventThreatDetectionCustomModuleName.ofProjectLocationEventThreatDetectionCustomModuleName(
            "[PROJECT]", "[LOCATION]", "[EVENT_THREAT_DETECTION_CUSTOM_MODULE]");

    EventThreatDetectionCustomModule actualResponse =
        client.getEventThreatDetectionCustomModule(name);
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockSecurityCenterManagement.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    GetEventThreatDetectionCustomModuleRequest actualRequest =
        ((GetEventThreatDetectionCustomModuleRequest) actualRequests.get(0));

    Assert.assertEquals(name.toString(), actualRequest.getName());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void getEventThreatDetectionCustomModuleExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockSecurityCenterManagement.addException(exception);

    try {
      EventThreatDetectionCustomModuleName name =
          EventThreatDetectionCustomModuleName
              .ofProjectLocationEventThreatDetectionCustomModuleName(
                  "[PROJECT]", "[LOCATION]", "[EVENT_THREAT_DETECTION_CUSTOM_MODULE]");
      client.getEventThreatDetectionCustomModule(name);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void getEventThreatDetectionCustomModuleTest2() throws Exception {
    EventThreatDetectionCustomModule expectedResponse =
        EventThreatDetectionCustomModule.newBuilder()
            .setName(
                EventThreatDetectionCustomModuleName
                    .ofProjectLocationEventThreatDetectionCustomModuleName(
                        "[PROJECT]", "[LOCATION]", "[EVENT_THREAT_DETECTION_CUSTOM_MODULE]")
                    .toString())
            .setConfig(Struct.newBuilder().build())
            .setAncestorModule(
                EventThreatDetectionCustomModuleName
                    .ofProjectLocationEventThreatDetectionCustomModuleName(
                        "[PROJECT]", "[LOCATION]", "[EVENT_THREAT_DETECTION_CUSTOM_MODULE]")
                    .toString())
            .setType("type3575610")
            .setDisplayName("displayName1714148973")
            .setDescription("description-1724546052")
            .setUpdateTime(Timestamp.newBuilder().build())
            .setLastEditor("lastEditor1523898275")
            .build();
    mockSecurityCenterManagement.addResponse(expectedResponse);

    String name = "name3373707";

    EventThreatDetectionCustomModule actualResponse =
        client.getEventThreatDetectionCustomModule(name);
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockSecurityCenterManagement.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    GetEventThreatDetectionCustomModuleRequest actualRequest =
        ((GetEventThreatDetectionCustomModuleRequest) actualRequests.get(0));

    Assert.assertEquals(name, actualRequest.getName());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void getEventThreatDetectionCustomModuleExceptionTest2() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockSecurityCenterManagement.addException(exception);

    try {
      String name = "name3373707";
      client.getEventThreatDetectionCustomModule(name);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void createEventThreatDetectionCustomModuleTest() throws Exception {
    EventThreatDetectionCustomModule expectedResponse =
        EventThreatDetectionCustomModule.newBuilder()
            .setName(
                EventThreatDetectionCustomModuleName
                    .ofOrganizationLocationEventThreatDetectionCustomModuleName(
                        "[ORGANIZATION]", "[LOCATION]", "[EVENT_THREAT_DETECTION_CUSTOM_MODULE]")
                    .toString())
            .setConfig(Struct.newBuilder().build())
            .setAncestorModule(
                EventThreatDetectionCustomModuleName
                    .ofOrganizationLocationEventThreatDetectionCustomModuleName(
                        "[ORGANIZATION]", "[LOCATION]", "[EVENT_THREAT_DETECTION_CUSTOM_MODULE]")
                    .toString())
            .setType("type3575610")
            .setDisplayName("displayName1714148973")
            .setDescription("description-1724546052")
            .setUpdateTime(Timestamp.newBuilder().build())
            .setLastEditor("lastEditor1523898275")
            .build();
    mockSecurityCenterManagement.addResponse(expectedResponse);

    FolderLocationName parent = FolderLocationName.of("[FOLDER]", "[LOCATION]");
    EventThreatDetectionCustomModule eventThreatDetectionCustomModule =
        EventThreatDetectionCustomModule.newBuilder().build();

    EventThreatDetectionCustomModule actualResponse =
        client.createEventThreatDetectionCustomModule(parent, eventThreatDetectionCustomModule);
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockSecurityCenterManagement.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    CreateEventThreatDetectionCustomModuleRequest actualRequest =
        ((CreateEventThreatDetectionCustomModuleRequest) actualRequests.get(0));

    Assert.assertEquals(parent.toString(), actualRequest.getParent());
    Assert.assertEquals(
        eventThreatDetectionCustomModule, actualRequest.getEventThreatDetectionCustomModule());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void createEventThreatDetectionCustomModuleExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockSecurityCenterManagement.addException(exception);

    try {
      FolderLocationName parent = FolderLocationName.of("[FOLDER]", "[LOCATION]");
      EventThreatDetectionCustomModule eventThreatDetectionCustomModule =
          EventThreatDetectionCustomModule.newBuilder().build();
      client.createEventThreatDetectionCustomModule(parent, eventThreatDetectionCustomModule);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void createEventThreatDetectionCustomModuleTest2() throws Exception {
    EventThreatDetectionCustomModule expectedResponse =
        EventThreatDetectionCustomModule.newBuilder()
            .setName(
                EventThreatDetectionCustomModuleName
                    .ofOrganizationLocationEventThreatDetectionCustomModuleName(
                        "[ORGANIZATION]", "[LOCATION]", "[EVENT_THREAT_DETECTION_CUSTOM_MODULE]")
                    .toString())
            .setConfig(Struct.newBuilder().build())
            .setAncestorModule(
                EventThreatDetectionCustomModuleName
                    .ofOrganizationLocationEventThreatDetectionCustomModuleName(
                        "[ORGANIZATION]", "[LOCATION]", "[EVENT_THREAT_DETECTION_CUSTOM_MODULE]")
                    .toString())
            .setType("type3575610")
            .setDisplayName("displayName1714148973")
            .setDescription("description-1724546052")
            .setUpdateTime(Timestamp.newBuilder().build())
            .setLastEditor("lastEditor1523898275")
            .build();
    mockSecurityCenterManagement.addResponse(expectedResponse);

    LocationName parent = LocationName.of("[PROJECT]", "[LOCATION]");
    EventThreatDetectionCustomModule eventThreatDetectionCustomModule =
        EventThreatDetectionCustomModule.newBuilder().build();

    EventThreatDetectionCustomModule actualResponse =
        client.createEventThreatDetectionCustomModule(parent, eventThreatDetectionCustomModule);
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockSecurityCenterManagement.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    CreateEventThreatDetectionCustomModuleRequest actualRequest =
        ((CreateEventThreatDetectionCustomModuleRequest) actualRequests.get(0));

    Assert.assertEquals(parent.toString(), actualRequest.getParent());
    Assert.assertEquals(
        eventThreatDetectionCustomModule, actualRequest.getEventThreatDetectionCustomModule());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void createEventThreatDetectionCustomModuleExceptionTest2() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockSecurityCenterManagement.addException(exception);

    try {
      LocationName parent = LocationName.of("[PROJECT]", "[LOCATION]");
      EventThreatDetectionCustomModule eventThreatDetectionCustomModule =
          EventThreatDetectionCustomModule.newBuilder().build();
      client.createEventThreatDetectionCustomModule(parent, eventThreatDetectionCustomModule);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void createEventThreatDetectionCustomModuleTest3() throws Exception {
    EventThreatDetectionCustomModule expectedResponse =
        EventThreatDetectionCustomModule.newBuilder()
            .setName(
                EventThreatDetectionCustomModuleName
                    .ofOrganizationLocationEventThreatDetectionCustomModuleName(
                        "[ORGANIZATION]", "[LOCATION]", "[EVENT_THREAT_DETECTION_CUSTOM_MODULE]")
                    .toString())
            .setConfig(Struct.newBuilder().build())
            .setAncestorModule(
                EventThreatDetectionCustomModuleName
                    .ofOrganizationLocationEventThreatDetectionCustomModuleName(
                        "[ORGANIZATION]", "[LOCATION]", "[EVENT_THREAT_DETECTION_CUSTOM_MODULE]")
                    .toString())
            .setType("type3575610")
            .setDisplayName("displayName1714148973")
            .setDescription("description-1724546052")
            .setUpdateTime(Timestamp.newBuilder().build())
            .setLastEditor("lastEditor1523898275")
            .build();
    mockSecurityCenterManagement.addResponse(expectedResponse);

    OrganizationLocationName parent = OrganizationLocationName.of("[ORGANIZATION]", "[LOCATION]");
    EventThreatDetectionCustomModule eventThreatDetectionCustomModule =
        EventThreatDetectionCustomModule.newBuilder().build();

    EventThreatDetectionCustomModule actualResponse =
        client.createEventThreatDetectionCustomModule(parent, eventThreatDetectionCustomModule);
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockSecurityCenterManagement.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    CreateEventThreatDetectionCustomModuleRequest actualRequest =
        ((CreateEventThreatDetectionCustomModuleRequest) actualRequests.get(0));

    Assert.assertEquals(parent.toString(), actualRequest.getParent());
    Assert.assertEquals(
        eventThreatDetectionCustomModule, actualRequest.getEventThreatDetectionCustomModule());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void createEventThreatDetectionCustomModuleExceptionTest3() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockSecurityCenterManagement.addException(exception);

    try {
      OrganizationLocationName parent = OrganizationLocationName.of("[ORGANIZATION]", "[LOCATION]");
      EventThreatDetectionCustomModule eventThreatDetectionCustomModule =
          EventThreatDetectionCustomModule.newBuilder().build();
      client.createEventThreatDetectionCustomModule(parent, eventThreatDetectionCustomModule);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void createEventThreatDetectionCustomModuleTest4() throws Exception {
    EventThreatDetectionCustomModule expectedResponse =
        EventThreatDetectionCustomModule.newBuilder()
            .setName(
                EventThreatDetectionCustomModuleName
                    .ofOrganizationLocationEventThreatDetectionCustomModuleName(
                        "[ORGANIZATION]", "[LOCATION]", "[EVENT_THREAT_DETECTION_CUSTOM_MODULE]")
                    .toString())
            .setConfig(Struct.newBuilder().build())
            .setAncestorModule(
                EventThreatDetectionCustomModuleName
                    .ofOrganizationLocationEventThreatDetectionCustomModuleName(
                        "[ORGANIZATION]", "[LOCATION]", "[EVENT_THREAT_DETECTION_CUSTOM_MODULE]")
                    .toString())
            .setType("type3575610")
            .setDisplayName("displayName1714148973")
            .setDescription("description-1724546052")
            .setUpdateTime(Timestamp.newBuilder().build())
            .setLastEditor("lastEditor1523898275")
            .build();
    mockSecurityCenterManagement.addResponse(expectedResponse);

    String parent = "parent-995424086";
    EventThreatDetectionCustomModule eventThreatDetectionCustomModule =
        EventThreatDetectionCustomModule.newBuilder().build();

    EventThreatDetectionCustomModule actualResponse =
        client.createEventThreatDetectionCustomModule(parent, eventThreatDetectionCustomModule);
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockSecurityCenterManagement.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    CreateEventThreatDetectionCustomModuleRequest actualRequest =
        ((CreateEventThreatDetectionCustomModuleRequest) actualRequests.get(0));

    Assert.assertEquals(parent, actualRequest.getParent());
    Assert.assertEquals(
        eventThreatDetectionCustomModule, actualRequest.getEventThreatDetectionCustomModule());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void createEventThreatDetectionCustomModuleExceptionTest4() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockSecurityCenterManagement.addException(exception);

    try {
      String parent = "parent-995424086";
      EventThreatDetectionCustomModule eventThreatDetectionCustomModule =
          EventThreatDetectionCustomModule.newBuilder().build();
      client.createEventThreatDetectionCustomModule(parent, eventThreatDetectionCustomModule);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void updateEventThreatDetectionCustomModuleTest() throws Exception {
    EventThreatDetectionCustomModule expectedResponse =
        EventThreatDetectionCustomModule.newBuilder()
            .setName(
                EventThreatDetectionCustomModuleName
                    .ofProjectLocationEventThreatDetectionCustomModuleName(
                        "[PROJECT]", "[LOCATION]", "[EVENT_THREAT_DETECTION_CUSTOM_MODULE]")
                    .toString())
            .setConfig(Struct.newBuilder().build())
            .setAncestorModule(
                EventThreatDetectionCustomModuleName
                    .ofProjectLocationEventThreatDetectionCustomModuleName(
                        "[PROJECT]", "[LOCATION]", "[EVENT_THREAT_DETECTION_CUSTOM_MODULE]")
                    .toString())
            .setType("type3575610")
            .setDisplayName("displayName1714148973")
            .setDescription("description-1724546052")
            .setUpdateTime(Timestamp.newBuilder().build())
            .setLastEditor("lastEditor1523898275")
            .build();
    mockSecurityCenterManagement.addResponse(expectedResponse);

    EventThreatDetectionCustomModule eventThreatDetectionCustomModule =
        EventThreatDetectionCustomModule.newBuilder().build();
    FieldMask updateMask = FieldMask.newBuilder().build();

    EventThreatDetectionCustomModule actualResponse =
        client.updateEventThreatDetectionCustomModule(eventThreatDetectionCustomModule, updateMask);
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockSecurityCenterManagement.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    UpdateEventThreatDetectionCustomModuleRequest actualRequest =
        ((UpdateEventThreatDetectionCustomModuleRequest) actualRequests.get(0));

    Assert.assertEquals(
        eventThreatDetectionCustomModule, actualRequest.getEventThreatDetectionCustomModule());
    Assert.assertEquals(updateMask, actualRequest.getUpdateMask());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void updateEventThreatDetectionCustomModuleExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockSecurityCenterManagement.addException(exception);

    try {
      EventThreatDetectionCustomModule eventThreatDetectionCustomModule =
          EventThreatDetectionCustomModule.newBuilder().build();
      FieldMask updateMask = FieldMask.newBuilder().build();
      client.updateEventThreatDetectionCustomModule(eventThreatDetectionCustomModule, updateMask);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void deleteEventThreatDetectionCustomModuleTest() throws Exception {
    Empty expectedResponse = Empty.newBuilder().build();
    mockSecurityCenterManagement.addResponse(expectedResponse);

    EventThreatDetectionCustomModuleName name =
        EventThreatDetectionCustomModuleName.ofProjectLocationEventThreatDetectionCustomModuleName(
            "[PROJECT]", "[LOCATION]", "[EVENT_THREAT_DETECTION_CUSTOM_MODULE]");

    client.deleteEventThreatDetectionCustomModule(name);

    List<AbstractMessage> actualRequests = mockSecurityCenterManagement.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    DeleteEventThreatDetectionCustomModuleRequest actualRequest =
        ((DeleteEventThreatDetectionCustomModuleRequest) actualRequests.get(0));

    Assert.assertEquals(name.toString(), actualRequest.getName());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void deleteEventThreatDetectionCustomModuleExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockSecurityCenterManagement.addException(exception);

    try {
      EventThreatDetectionCustomModuleName name =
          EventThreatDetectionCustomModuleName
              .ofProjectLocationEventThreatDetectionCustomModuleName(
                  "[PROJECT]", "[LOCATION]", "[EVENT_THREAT_DETECTION_CUSTOM_MODULE]");
      client.deleteEventThreatDetectionCustomModule(name);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void deleteEventThreatDetectionCustomModuleTest2() throws Exception {
    Empty expectedResponse = Empty.newBuilder().build();
    mockSecurityCenterManagement.addResponse(expectedResponse);

    String name = "name3373707";

    client.deleteEventThreatDetectionCustomModule(name);

    List<AbstractMessage> actualRequests = mockSecurityCenterManagement.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    DeleteEventThreatDetectionCustomModuleRequest actualRequest =
        ((DeleteEventThreatDetectionCustomModuleRequest) actualRequests.get(0));

    Assert.assertEquals(name, actualRequest.getName());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void deleteEventThreatDetectionCustomModuleExceptionTest2() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockSecurityCenterManagement.addException(exception);

    try {
      String name = "name3373707";
      client.deleteEventThreatDetectionCustomModule(name);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void validateEventThreatDetectionCustomModuleTest() throws Exception {
    ValidateEventThreatDetectionCustomModuleResponse expectedResponse =
        ValidateEventThreatDetectionCustomModuleResponse.newBuilder()
            .addAllErrors(
                new ArrayList<
                    ValidateEventThreatDetectionCustomModuleResponse.CustomModuleValidationError>())
            .build();
    mockSecurityCenterManagement.addResponse(expectedResponse);

    ValidateEventThreatDetectionCustomModuleRequest request =
        ValidateEventThreatDetectionCustomModuleRequest.newBuilder()
            .setParent(OrganizationLocationName.of("[ORGANIZATION]", "[LOCATION]").toString())
            .setRawText("rawText985734517")
            .setType("type3575610")
            .build();

    ValidateEventThreatDetectionCustomModuleResponse actualResponse =
        client.validateEventThreatDetectionCustomModule(request);
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockSecurityCenterManagement.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    ValidateEventThreatDetectionCustomModuleRequest actualRequest =
        ((ValidateEventThreatDetectionCustomModuleRequest) actualRequests.get(0));

    Assert.assertEquals(request.getParent(), actualRequest.getParent());
    Assert.assertEquals(request.getRawText(), actualRequest.getRawText());
    Assert.assertEquals(request.getType(), actualRequest.getType());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void validateEventThreatDetectionCustomModuleExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockSecurityCenterManagement.addException(exception);

    try {
      ValidateEventThreatDetectionCustomModuleRequest request =
          ValidateEventThreatDetectionCustomModuleRequest.newBuilder()
              .setParent(OrganizationLocationName.of("[ORGANIZATION]", "[LOCATION]").toString())
              .setRawText("rawText985734517")
              .setType("type3575610")
              .build();
      client.validateEventThreatDetectionCustomModule(request);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void listLocationsTest() throws Exception {
    Location responsesElement = Location.newBuilder().build();
    ListLocationsResponse expectedResponse =
        ListLocationsResponse.newBuilder()
            .setNextPageToken("")
            .addAllLocations(Arrays.asList(responsesElement))
            .build();
    mockLocations.addResponse(expectedResponse);

    ListLocationsRequest request =
        ListLocationsRequest.newBuilder()
            .setName("name3373707")
            .setFilter("filter-1274492040")
            .setPageSize(883849137)
            .setPageToken("pageToken873572522")
            .build();

    ListLocationsPagedResponse pagedListResponse = client.listLocations(request);

    List<Location> resources = Lists.newArrayList(pagedListResponse.iterateAll());

    Assert.assertEquals(1, resources.size());
    Assert.assertEquals(expectedResponse.getLocationsList().get(0), resources.get(0));

    List<AbstractMessage> actualRequests = mockLocations.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    ListLocationsRequest actualRequest = ((ListLocationsRequest) actualRequests.get(0));

    Assert.assertEquals(request.getName(), actualRequest.getName());
    Assert.assertEquals(request.getFilter(), actualRequest.getFilter());
    Assert.assertEquals(request.getPageSize(), actualRequest.getPageSize());
    Assert.assertEquals(request.getPageToken(), actualRequest.getPageToken());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void listLocationsExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockLocations.addException(exception);

    try {
      ListLocationsRequest request =
          ListLocationsRequest.newBuilder()
              .setName("name3373707")
              .setFilter("filter-1274492040")
              .setPageSize(883849137)
              .setPageToken("pageToken873572522")
              .build();
      client.listLocations(request);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void getLocationTest() throws Exception {
    Location expectedResponse =
        Location.newBuilder()
            .setName("name3373707")
            .setLocationId("locationId1541836720")
            .setDisplayName("displayName1714148973")
            .putAllLabels(new HashMap<String, String>())
            .setMetadata(Any.newBuilder().build())
            .build();
    mockLocations.addResponse(expectedResponse);

    GetLocationRequest request = GetLocationRequest.newBuilder().setName("name3373707").build();

    Location actualResponse = client.getLocation(request);
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockLocations.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    GetLocationRequest actualRequest = ((GetLocationRequest) actualRequests.get(0));

    Assert.assertEquals(request.getName(), actualRequest.getName());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void getLocationExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockLocations.addException(exception);

    try {
      GetLocationRequest request = GetLocationRequest.newBuilder().setName("name3373707").build();
      client.getLocation(request);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }
}
