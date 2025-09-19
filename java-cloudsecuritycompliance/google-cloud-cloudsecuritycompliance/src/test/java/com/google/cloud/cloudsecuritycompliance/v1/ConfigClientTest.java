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

package com.google.cloud.cloudsecuritycompliance.v1;

import static com.google.cloud.cloudsecuritycompliance.v1.ConfigClient.ListCloudControlsPagedResponse;
import static com.google.cloud.cloudsecuritycompliance.v1.ConfigClient.ListFrameworksPagedResponse;
import static com.google.cloud.cloudsecuritycompliance.v1.ConfigClient.ListLocationsPagedResponse;

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
public class ConfigClientTest {
  private static MockConfig mockConfig;
  private static MockLocations mockLocations;
  private static MockServiceHelper mockServiceHelper;
  private LocalChannelProvider channelProvider;
  private ConfigClient client;

  @BeforeClass
  public static void startStaticServer() {
    mockConfig = new MockConfig();
    mockLocations = new MockLocations();
    mockServiceHelper =
        new MockServiceHelper(
            UUID.randomUUID().toString(),
            Arrays.<MockGrpcService>asList(mockConfig, mockLocations));
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
    ConfigSettings settings =
        ConfigSettings.newBuilder()
            .setTransportChannelProvider(channelProvider)
            .setCredentialsProvider(NoCredentialsProvider.create())
            .build();
    client = ConfigClient.create(settings);
  }

  @After
  public void tearDown() throws Exception {
    client.close();
  }

  @Test
  public void listFrameworksTest() throws Exception {
    Framework responsesElement = Framework.newBuilder().build();
    ListFrameworksResponse expectedResponse =
        ListFrameworksResponse.newBuilder()
            .setNextPageToken("")
            .addAllFrameworks(Arrays.asList(responsesElement))
            .build();
    mockConfig.addResponse(expectedResponse);

    OrganizationLocationName parent = OrganizationLocationName.of("[ORGANIZATION]", "[LOCATION]");

    ListFrameworksPagedResponse pagedListResponse = client.listFrameworks(parent);

    List<Framework> resources = Lists.newArrayList(pagedListResponse.iterateAll());

    Assert.assertEquals(1, resources.size());
    Assert.assertEquals(expectedResponse.getFrameworksList().get(0), resources.get(0));

    List<AbstractMessage> actualRequests = mockConfig.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    ListFrameworksRequest actualRequest = ((ListFrameworksRequest) actualRequests.get(0));

    Assert.assertEquals(parent.toString(), actualRequest.getParent());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void listFrameworksExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockConfig.addException(exception);

    try {
      OrganizationLocationName parent = OrganizationLocationName.of("[ORGANIZATION]", "[LOCATION]");
      client.listFrameworks(parent);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void listFrameworksTest2() throws Exception {
    Framework responsesElement = Framework.newBuilder().build();
    ListFrameworksResponse expectedResponse =
        ListFrameworksResponse.newBuilder()
            .setNextPageToken("")
            .addAllFrameworks(Arrays.asList(responsesElement))
            .build();
    mockConfig.addResponse(expectedResponse);

    String parent = "parent-995424086";

    ListFrameworksPagedResponse pagedListResponse = client.listFrameworks(parent);

    List<Framework> resources = Lists.newArrayList(pagedListResponse.iterateAll());

    Assert.assertEquals(1, resources.size());
    Assert.assertEquals(expectedResponse.getFrameworksList().get(0), resources.get(0));

    List<AbstractMessage> actualRequests = mockConfig.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    ListFrameworksRequest actualRequest = ((ListFrameworksRequest) actualRequests.get(0));

    Assert.assertEquals(parent, actualRequest.getParent());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void listFrameworksExceptionTest2() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockConfig.addException(exception);

    try {
      String parent = "parent-995424086";
      client.listFrameworks(parent);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void getFrameworkTest() throws Exception {
    Framework expectedResponse =
        Framework.newBuilder()
            .setName(FrameworkName.of("[ORGANIZATION]", "[LOCATION]", "[FRAMEWORK]").toString())
            .setMajorRevisionId(612576889)
            .setDisplayName("displayName1714148973")
            .setDescription("description-1724546052")
            .addAllCloudControlDetails(new ArrayList<CloudControlDetails>())
            .addAllCategory(new ArrayList<FrameworkCategory>())
            .addAllSupportedCloudProviders(new ArrayList<CloudProvider>())
            .addAllSupportedTargetResourceTypes(new ArrayList<TargetResourceType>())
            .addAllSupportedEnforcementModes(new ArrayList<EnforcementMode>())
            .build();
    mockConfig.addResponse(expectedResponse);

    FrameworkName name = FrameworkName.of("[ORGANIZATION]", "[LOCATION]", "[FRAMEWORK]");

    Framework actualResponse = client.getFramework(name);
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockConfig.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    GetFrameworkRequest actualRequest = ((GetFrameworkRequest) actualRequests.get(0));

    Assert.assertEquals(name.toString(), actualRequest.getName());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void getFrameworkExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockConfig.addException(exception);

    try {
      FrameworkName name = FrameworkName.of("[ORGANIZATION]", "[LOCATION]", "[FRAMEWORK]");
      client.getFramework(name);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void getFrameworkTest2() throws Exception {
    Framework expectedResponse =
        Framework.newBuilder()
            .setName(FrameworkName.of("[ORGANIZATION]", "[LOCATION]", "[FRAMEWORK]").toString())
            .setMajorRevisionId(612576889)
            .setDisplayName("displayName1714148973")
            .setDescription("description-1724546052")
            .addAllCloudControlDetails(new ArrayList<CloudControlDetails>())
            .addAllCategory(new ArrayList<FrameworkCategory>())
            .addAllSupportedCloudProviders(new ArrayList<CloudProvider>())
            .addAllSupportedTargetResourceTypes(new ArrayList<TargetResourceType>())
            .addAllSupportedEnforcementModes(new ArrayList<EnforcementMode>())
            .build();
    mockConfig.addResponse(expectedResponse);

    String name = "name3373707";

    Framework actualResponse = client.getFramework(name);
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockConfig.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    GetFrameworkRequest actualRequest = ((GetFrameworkRequest) actualRequests.get(0));

    Assert.assertEquals(name, actualRequest.getName());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void getFrameworkExceptionTest2() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockConfig.addException(exception);

    try {
      String name = "name3373707";
      client.getFramework(name);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void createFrameworkTest() throws Exception {
    Framework expectedResponse =
        Framework.newBuilder()
            .setName(FrameworkName.of("[ORGANIZATION]", "[LOCATION]", "[FRAMEWORK]").toString())
            .setMajorRevisionId(612576889)
            .setDisplayName("displayName1714148973")
            .setDescription("description-1724546052")
            .addAllCloudControlDetails(new ArrayList<CloudControlDetails>())
            .addAllCategory(new ArrayList<FrameworkCategory>())
            .addAllSupportedCloudProviders(new ArrayList<CloudProvider>())
            .addAllSupportedTargetResourceTypes(new ArrayList<TargetResourceType>())
            .addAllSupportedEnforcementModes(new ArrayList<EnforcementMode>())
            .build();
    mockConfig.addResponse(expectedResponse);

    OrganizationLocationName parent = OrganizationLocationName.of("[ORGANIZATION]", "[LOCATION]");
    Framework framework = Framework.newBuilder().build();
    String frameworkId = "frameworkId886666169";

    Framework actualResponse = client.createFramework(parent, framework, frameworkId);
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockConfig.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    CreateFrameworkRequest actualRequest = ((CreateFrameworkRequest) actualRequests.get(0));

    Assert.assertEquals(parent.toString(), actualRequest.getParent());
    Assert.assertEquals(framework, actualRequest.getFramework());
    Assert.assertEquals(frameworkId, actualRequest.getFrameworkId());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void createFrameworkExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockConfig.addException(exception);

    try {
      OrganizationLocationName parent = OrganizationLocationName.of("[ORGANIZATION]", "[LOCATION]");
      Framework framework = Framework.newBuilder().build();
      String frameworkId = "frameworkId886666169";
      client.createFramework(parent, framework, frameworkId);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void createFrameworkTest2() throws Exception {
    Framework expectedResponse =
        Framework.newBuilder()
            .setName(FrameworkName.of("[ORGANIZATION]", "[LOCATION]", "[FRAMEWORK]").toString())
            .setMajorRevisionId(612576889)
            .setDisplayName("displayName1714148973")
            .setDescription("description-1724546052")
            .addAllCloudControlDetails(new ArrayList<CloudControlDetails>())
            .addAllCategory(new ArrayList<FrameworkCategory>())
            .addAllSupportedCloudProviders(new ArrayList<CloudProvider>())
            .addAllSupportedTargetResourceTypes(new ArrayList<TargetResourceType>())
            .addAllSupportedEnforcementModes(new ArrayList<EnforcementMode>())
            .build();
    mockConfig.addResponse(expectedResponse);

    String parent = "parent-995424086";
    Framework framework = Framework.newBuilder().build();
    String frameworkId = "frameworkId886666169";

    Framework actualResponse = client.createFramework(parent, framework, frameworkId);
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockConfig.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    CreateFrameworkRequest actualRequest = ((CreateFrameworkRequest) actualRequests.get(0));

    Assert.assertEquals(parent, actualRequest.getParent());
    Assert.assertEquals(framework, actualRequest.getFramework());
    Assert.assertEquals(frameworkId, actualRequest.getFrameworkId());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void createFrameworkExceptionTest2() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockConfig.addException(exception);

    try {
      String parent = "parent-995424086";
      Framework framework = Framework.newBuilder().build();
      String frameworkId = "frameworkId886666169";
      client.createFramework(parent, framework, frameworkId);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void updateFrameworkTest() throws Exception {
    Framework expectedResponse =
        Framework.newBuilder()
            .setName(FrameworkName.of("[ORGANIZATION]", "[LOCATION]", "[FRAMEWORK]").toString())
            .setMajorRevisionId(612576889)
            .setDisplayName("displayName1714148973")
            .setDescription("description-1724546052")
            .addAllCloudControlDetails(new ArrayList<CloudControlDetails>())
            .addAllCategory(new ArrayList<FrameworkCategory>())
            .addAllSupportedCloudProviders(new ArrayList<CloudProvider>())
            .addAllSupportedTargetResourceTypes(new ArrayList<TargetResourceType>())
            .addAllSupportedEnforcementModes(new ArrayList<EnforcementMode>())
            .build();
    mockConfig.addResponse(expectedResponse);

    Framework framework = Framework.newBuilder().build();
    FieldMask updateMask = FieldMask.newBuilder().build();

    Framework actualResponse = client.updateFramework(framework, updateMask);
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockConfig.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    UpdateFrameworkRequest actualRequest = ((UpdateFrameworkRequest) actualRequests.get(0));

    Assert.assertEquals(framework, actualRequest.getFramework());
    Assert.assertEquals(updateMask, actualRequest.getUpdateMask());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void updateFrameworkExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockConfig.addException(exception);

    try {
      Framework framework = Framework.newBuilder().build();
      FieldMask updateMask = FieldMask.newBuilder().build();
      client.updateFramework(framework, updateMask);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void deleteFrameworkTest() throws Exception {
    Empty expectedResponse = Empty.newBuilder().build();
    mockConfig.addResponse(expectedResponse);

    FrameworkName name = FrameworkName.of("[ORGANIZATION]", "[LOCATION]", "[FRAMEWORK]");

    client.deleteFramework(name);

    List<AbstractMessage> actualRequests = mockConfig.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    DeleteFrameworkRequest actualRequest = ((DeleteFrameworkRequest) actualRequests.get(0));

    Assert.assertEquals(name.toString(), actualRequest.getName());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void deleteFrameworkExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockConfig.addException(exception);

    try {
      FrameworkName name = FrameworkName.of("[ORGANIZATION]", "[LOCATION]", "[FRAMEWORK]");
      client.deleteFramework(name);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void deleteFrameworkTest2() throws Exception {
    Empty expectedResponse = Empty.newBuilder().build();
    mockConfig.addResponse(expectedResponse);

    String name = "name3373707";

    client.deleteFramework(name);

    List<AbstractMessage> actualRequests = mockConfig.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    DeleteFrameworkRequest actualRequest = ((DeleteFrameworkRequest) actualRequests.get(0));

    Assert.assertEquals(name, actualRequest.getName());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void deleteFrameworkExceptionTest2() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockConfig.addException(exception);

    try {
      String name = "name3373707";
      client.deleteFramework(name);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void listCloudControlsTest() throws Exception {
    CloudControl responsesElement = CloudControl.newBuilder().build();
    ListCloudControlsResponse expectedResponse =
        ListCloudControlsResponse.newBuilder()
            .setNextPageToken("")
            .addAllCloudControls(Arrays.asList(responsesElement))
            .build();
    mockConfig.addResponse(expectedResponse);

    OrganizationLocationName parent = OrganizationLocationName.of("[ORGANIZATION]", "[LOCATION]");

    ListCloudControlsPagedResponse pagedListResponse = client.listCloudControls(parent);

    List<CloudControl> resources = Lists.newArrayList(pagedListResponse.iterateAll());

    Assert.assertEquals(1, resources.size());
    Assert.assertEquals(expectedResponse.getCloudControlsList().get(0), resources.get(0));

    List<AbstractMessage> actualRequests = mockConfig.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    ListCloudControlsRequest actualRequest = ((ListCloudControlsRequest) actualRequests.get(0));

    Assert.assertEquals(parent.toString(), actualRequest.getParent());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void listCloudControlsExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockConfig.addException(exception);

    try {
      OrganizationLocationName parent = OrganizationLocationName.of("[ORGANIZATION]", "[LOCATION]");
      client.listCloudControls(parent);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void listCloudControlsTest2() throws Exception {
    CloudControl responsesElement = CloudControl.newBuilder().build();
    ListCloudControlsResponse expectedResponse =
        ListCloudControlsResponse.newBuilder()
            .setNextPageToken("")
            .addAllCloudControls(Arrays.asList(responsesElement))
            .build();
    mockConfig.addResponse(expectedResponse);

    String parent = "parent-995424086";

    ListCloudControlsPagedResponse pagedListResponse = client.listCloudControls(parent);

    List<CloudControl> resources = Lists.newArrayList(pagedListResponse.iterateAll());

    Assert.assertEquals(1, resources.size());
    Assert.assertEquals(expectedResponse.getCloudControlsList().get(0), resources.get(0));

    List<AbstractMessage> actualRequests = mockConfig.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    ListCloudControlsRequest actualRequest = ((ListCloudControlsRequest) actualRequests.get(0));

    Assert.assertEquals(parent, actualRequest.getParent());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void listCloudControlsExceptionTest2() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockConfig.addException(exception);

    try {
      String parent = "parent-995424086";
      client.listCloudControls(parent);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void getCloudControlTest() throws Exception {
    CloudControl expectedResponse =
        CloudControl.newBuilder()
            .setName(
                CloudControlName.of("[ORGANIZATION]", "[LOCATION]", "[CLOUD_CONTROL]").toString())
            .setMajorRevisionId(612576889)
            .setDescription("description-1724546052")
            .setDisplayName("displayName1714148973")
            .addAllSupportedEnforcementModes(new ArrayList<EnforcementMode>())
            .addAllParameterSpec(new ArrayList<ParameterSpec>())
            .addAllRules(new ArrayList<Rule>())
            .setSeverity(Severity.forNumber(0))
            .setFindingCategory("findingCategory-1495850073")
            .addAllSupportedCloudProviders(new ArrayList<CloudProvider>())
            .addAllRelatedFrameworks(new ArrayList<String>())
            .setRemediationSteps("remediationSteps1230652930")
            .addAllCategories(new ArrayList<CloudControlCategory>())
            .setCreateTime(Timestamp.newBuilder().build())
            .addAllSupportedTargetResourceTypes(new ArrayList<TargetResourceType>())
            .build();
    mockConfig.addResponse(expectedResponse);

    CloudControlName name = CloudControlName.of("[ORGANIZATION]", "[LOCATION]", "[CLOUD_CONTROL]");

    CloudControl actualResponse = client.getCloudControl(name);
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockConfig.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    GetCloudControlRequest actualRequest = ((GetCloudControlRequest) actualRequests.get(0));

    Assert.assertEquals(name.toString(), actualRequest.getName());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void getCloudControlExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockConfig.addException(exception);

    try {
      CloudControlName name =
          CloudControlName.of("[ORGANIZATION]", "[LOCATION]", "[CLOUD_CONTROL]");
      client.getCloudControl(name);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void getCloudControlTest2() throws Exception {
    CloudControl expectedResponse =
        CloudControl.newBuilder()
            .setName(
                CloudControlName.of("[ORGANIZATION]", "[LOCATION]", "[CLOUD_CONTROL]").toString())
            .setMajorRevisionId(612576889)
            .setDescription("description-1724546052")
            .setDisplayName("displayName1714148973")
            .addAllSupportedEnforcementModes(new ArrayList<EnforcementMode>())
            .addAllParameterSpec(new ArrayList<ParameterSpec>())
            .addAllRules(new ArrayList<Rule>())
            .setSeverity(Severity.forNumber(0))
            .setFindingCategory("findingCategory-1495850073")
            .addAllSupportedCloudProviders(new ArrayList<CloudProvider>())
            .addAllRelatedFrameworks(new ArrayList<String>())
            .setRemediationSteps("remediationSteps1230652930")
            .addAllCategories(new ArrayList<CloudControlCategory>())
            .setCreateTime(Timestamp.newBuilder().build())
            .addAllSupportedTargetResourceTypes(new ArrayList<TargetResourceType>())
            .build();
    mockConfig.addResponse(expectedResponse);

    String name = "name3373707";

    CloudControl actualResponse = client.getCloudControl(name);
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockConfig.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    GetCloudControlRequest actualRequest = ((GetCloudControlRequest) actualRequests.get(0));

    Assert.assertEquals(name, actualRequest.getName());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void getCloudControlExceptionTest2() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockConfig.addException(exception);

    try {
      String name = "name3373707";
      client.getCloudControl(name);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void createCloudControlTest() throws Exception {
    CloudControl expectedResponse =
        CloudControl.newBuilder()
            .setName(
                CloudControlName.of("[ORGANIZATION]", "[LOCATION]", "[CLOUD_CONTROL]").toString())
            .setMajorRevisionId(612576889)
            .setDescription("description-1724546052")
            .setDisplayName("displayName1714148973")
            .addAllSupportedEnforcementModes(new ArrayList<EnforcementMode>())
            .addAllParameterSpec(new ArrayList<ParameterSpec>())
            .addAllRules(new ArrayList<Rule>())
            .setSeverity(Severity.forNumber(0))
            .setFindingCategory("findingCategory-1495850073")
            .addAllSupportedCloudProviders(new ArrayList<CloudProvider>())
            .addAllRelatedFrameworks(new ArrayList<String>())
            .setRemediationSteps("remediationSteps1230652930")
            .addAllCategories(new ArrayList<CloudControlCategory>())
            .setCreateTime(Timestamp.newBuilder().build())
            .addAllSupportedTargetResourceTypes(new ArrayList<TargetResourceType>())
            .build();
    mockConfig.addResponse(expectedResponse);

    OrganizationLocationName parent = OrganizationLocationName.of("[ORGANIZATION]", "[LOCATION]");
    CloudControl cloudControl = CloudControl.newBuilder().build();
    String cloudControlId = "cloudControlId657324195";

    CloudControl actualResponse = client.createCloudControl(parent, cloudControl, cloudControlId);
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockConfig.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    CreateCloudControlRequest actualRequest = ((CreateCloudControlRequest) actualRequests.get(0));

    Assert.assertEquals(parent.toString(), actualRequest.getParent());
    Assert.assertEquals(cloudControl, actualRequest.getCloudControl());
    Assert.assertEquals(cloudControlId, actualRequest.getCloudControlId());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void createCloudControlExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockConfig.addException(exception);

    try {
      OrganizationLocationName parent = OrganizationLocationName.of("[ORGANIZATION]", "[LOCATION]");
      CloudControl cloudControl = CloudControl.newBuilder().build();
      String cloudControlId = "cloudControlId657324195";
      client.createCloudControl(parent, cloudControl, cloudControlId);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void createCloudControlTest2() throws Exception {
    CloudControl expectedResponse =
        CloudControl.newBuilder()
            .setName(
                CloudControlName.of("[ORGANIZATION]", "[LOCATION]", "[CLOUD_CONTROL]").toString())
            .setMajorRevisionId(612576889)
            .setDescription("description-1724546052")
            .setDisplayName("displayName1714148973")
            .addAllSupportedEnforcementModes(new ArrayList<EnforcementMode>())
            .addAllParameterSpec(new ArrayList<ParameterSpec>())
            .addAllRules(new ArrayList<Rule>())
            .setSeverity(Severity.forNumber(0))
            .setFindingCategory("findingCategory-1495850073")
            .addAllSupportedCloudProviders(new ArrayList<CloudProvider>())
            .addAllRelatedFrameworks(new ArrayList<String>())
            .setRemediationSteps("remediationSteps1230652930")
            .addAllCategories(new ArrayList<CloudControlCategory>())
            .setCreateTime(Timestamp.newBuilder().build())
            .addAllSupportedTargetResourceTypes(new ArrayList<TargetResourceType>())
            .build();
    mockConfig.addResponse(expectedResponse);

    String parent = "parent-995424086";
    CloudControl cloudControl = CloudControl.newBuilder().build();
    String cloudControlId = "cloudControlId657324195";

    CloudControl actualResponse = client.createCloudControl(parent, cloudControl, cloudControlId);
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockConfig.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    CreateCloudControlRequest actualRequest = ((CreateCloudControlRequest) actualRequests.get(0));

    Assert.assertEquals(parent, actualRequest.getParent());
    Assert.assertEquals(cloudControl, actualRequest.getCloudControl());
    Assert.assertEquals(cloudControlId, actualRequest.getCloudControlId());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void createCloudControlExceptionTest2() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockConfig.addException(exception);

    try {
      String parent = "parent-995424086";
      CloudControl cloudControl = CloudControl.newBuilder().build();
      String cloudControlId = "cloudControlId657324195";
      client.createCloudControl(parent, cloudControl, cloudControlId);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void updateCloudControlTest() throws Exception {
    CloudControl expectedResponse =
        CloudControl.newBuilder()
            .setName(
                CloudControlName.of("[ORGANIZATION]", "[LOCATION]", "[CLOUD_CONTROL]").toString())
            .setMajorRevisionId(612576889)
            .setDescription("description-1724546052")
            .setDisplayName("displayName1714148973")
            .addAllSupportedEnforcementModes(new ArrayList<EnforcementMode>())
            .addAllParameterSpec(new ArrayList<ParameterSpec>())
            .addAllRules(new ArrayList<Rule>())
            .setSeverity(Severity.forNumber(0))
            .setFindingCategory("findingCategory-1495850073")
            .addAllSupportedCloudProviders(new ArrayList<CloudProvider>())
            .addAllRelatedFrameworks(new ArrayList<String>())
            .setRemediationSteps("remediationSteps1230652930")
            .addAllCategories(new ArrayList<CloudControlCategory>())
            .setCreateTime(Timestamp.newBuilder().build())
            .addAllSupportedTargetResourceTypes(new ArrayList<TargetResourceType>())
            .build();
    mockConfig.addResponse(expectedResponse);

    CloudControl cloudControl = CloudControl.newBuilder().build();
    FieldMask updateMask = FieldMask.newBuilder().build();

    CloudControl actualResponse = client.updateCloudControl(cloudControl, updateMask);
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockConfig.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    UpdateCloudControlRequest actualRequest = ((UpdateCloudControlRequest) actualRequests.get(0));

    Assert.assertEquals(cloudControl, actualRequest.getCloudControl());
    Assert.assertEquals(updateMask, actualRequest.getUpdateMask());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void updateCloudControlExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockConfig.addException(exception);

    try {
      CloudControl cloudControl = CloudControl.newBuilder().build();
      FieldMask updateMask = FieldMask.newBuilder().build();
      client.updateCloudControl(cloudControl, updateMask);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void deleteCloudControlTest() throws Exception {
    Empty expectedResponse = Empty.newBuilder().build();
    mockConfig.addResponse(expectedResponse);

    CloudControlName name = CloudControlName.of("[ORGANIZATION]", "[LOCATION]", "[CLOUD_CONTROL]");

    client.deleteCloudControl(name);

    List<AbstractMessage> actualRequests = mockConfig.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    DeleteCloudControlRequest actualRequest = ((DeleteCloudControlRequest) actualRequests.get(0));

    Assert.assertEquals(name.toString(), actualRequest.getName());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void deleteCloudControlExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockConfig.addException(exception);

    try {
      CloudControlName name =
          CloudControlName.of("[ORGANIZATION]", "[LOCATION]", "[CLOUD_CONTROL]");
      client.deleteCloudControl(name);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void deleteCloudControlTest2() throws Exception {
    Empty expectedResponse = Empty.newBuilder().build();
    mockConfig.addResponse(expectedResponse);

    String name = "name3373707";

    client.deleteCloudControl(name);

    List<AbstractMessage> actualRequests = mockConfig.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    DeleteCloudControlRequest actualRequest = ((DeleteCloudControlRequest) actualRequests.get(0));

    Assert.assertEquals(name, actualRequest.getName());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void deleteCloudControlExceptionTest2() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockConfig.addException(exception);

    try {
      String name = "name3373707";
      client.deleteCloudControl(name);
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
