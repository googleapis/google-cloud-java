/*
 * Copyright 2026 Google LLC
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

package com.google.cloud.parametermanager.v1;

import static com.google.cloud.parametermanager.v1.ParameterManagerClient.ListLocationsPagedResponse;
import static com.google.cloud.parametermanager.v1.ParameterManagerClient.ListParameterVersionsPagedResponse;
import static com.google.cloud.parametermanager.v1.ParameterManagerClient.ListParametersPagedResponse;
import static com.google.cloud.parametermanager.v1.ParameterManagerClient.ListTemplateVersionsPagedResponse;
import static com.google.cloud.parametermanager.v1.ParameterManagerClient.ListTemplatesPagedResponse;

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
import com.google.iam.v1.ResourcePolicyMember;
import com.google.protobuf.AbstractMessage;
import com.google.protobuf.Any;
import com.google.protobuf.ByteString;
import com.google.protobuf.Empty;
import com.google.protobuf.FieldMask;
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
public class ParameterManagerClientTest {
  private static MockLocations mockLocations;
  private static MockParameterManager mockParameterManager;
  private static MockServiceHelper mockServiceHelper;
  private LocalChannelProvider channelProvider;
  private ParameterManagerClient client;

  @BeforeClass
  public static void startStaticServer() {
    mockParameterManager = new MockParameterManager();
    mockLocations = new MockLocations();
    mockServiceHelper =
        new MockServiceHelper(
            UUID.randomUUID().toString(),
            Arrays.<MockGrpcService>asList(mockParameterManager, mockLocations));
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
    ParameterManagerSettings settings =
        ParameterManagerSettings.newBuilder()
            .setTransportChannelProvider(channelProvider)
            .setCredentialsProvider(NoCredentialsProvider.create())
            .build();
    client = ParameterManagerClient.create(settings);
  }

  @After
  public void tearDown() throws Exception {
    client.close();
  }

  @Test
  public void listParametersTest() throws Exception {
    Parameter responsesElement = Parameter.newBuilder().build();
    ListParametersResponse expectedResponse =
        ListParametersResponse.newBuilder()
            .setNextPageToken("")
            .addAllParameters(Arrays.asList(responsesElement))
            .build();
    mockParameterManager.addResponse(expectedResponse);

    LocationName parent = LocationName.of("[PROJECT]", "[LOCATION]");

    ListParametersPagedResponse pagedListResponse = client.listParameters(parent);

    List<Parameter> resources = Lists.newArrayList(pagedListResponse.iterateAll());

    Assert.assertEquals(1, resources.size());
    Assert.assertEquals(expectedResponse.getParametersList().get(0), resources.get(0));

    List<AbstractMessage> actualRequests = mockParameterManager.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    ListParametersRequest actualRequest = ((ListParametersRequest) actualRequests.get(0));

    Assert.assertEquals(parent.toString(), actualRequest.getParent());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void listParametersExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockParameterManager.addException(exception);

    try {
      LocationName parent = LocationName.of("[PROJECT]", "[LOCATION]");
      client.listParameters(parent);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void listParametersTest2() throws Exception {
    Parameter responsesElement = Parameter.newBuilder().build();
    ListParametersResponse expectedResponse =
        ListParametersResponse.newBuilder()
            .setNextPageToken("")
            .addAllParameters(Arrays.asList(responsesElement))
            .build();
    mockParameterManager.addResponse(expectedResponse);

    String parent = "parent-995424086";

    ListParametersPagedResponse pagedListResponse = client.listParameters(parent);

    List<Parameter> resources = Lists.newArrayList(pagedListResponse.iterateAll());

    Assert.assertEquals(1, resources.size());
    Assert.assertEquals(expectedResponse.getParametersList().get(0), resources.get(0));

    List<AbstractMessage> actualRequests = mockParameterManager.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    ListParametersRequest actualRequest = ((ListParametersRequest) actualRequests.get(0));

    Assert.assertEquals(parent, actualRequest.getParent());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void listParametersExceptionTest2() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockParameterManager.addException(exception);

    try {
      String parent = "parent-995424086";
      client.listParameters(parent);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void getParameterTest() throws Exception {
    Parameter expectedResponse =
        Parameter.newBuilder()
            .setName(ParameterName.of("[PROJECT]", "[LOCATION]", "[PARAMETER]").toString())
            .setCreateTime(Timestamp.newBuilder().build())
            .setUpdateTime(Timestamp.newBuilder().build())
            .putAllLabels(new HashMap<String, String>())
            .setFormat(ParameterFormat.forNumber(0))
            .setPolicyMember(ResourcePolicyMember.newBuilder().build())
            .setKmsKey("kmsKey-1127483058")
            .putAllTags(new HashMap<String, String>())
            .build();
    mockParameterManager.addResponse(expectedResponse);

    ParameterName name = ParameterName.of("[PROJECT]", "[LOCATION]", "[PARAMETER]");

    Parameter actualResponse = client.getParameter(name);
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockParameterManager.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    GetParameterRequest actualRequest = ((GetParameterRequest) actualRequests.get(0));

    Assert.assertEquals(name.toString(), actualRequest.getName());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void getParameterExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockParameterManager.addException(exception);

    try {
      ParameterName name = ParameterName.of("[PROJECT]", "[LOCATION]", "[PARAMETER]");
      client.getParameter(name);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void getParameterTest2() throws Exception {
    Parameter expectedResponse =
        Parameter.newBuilder()
            .setName(ParameterName.of("[PROJECT]", "[LOCATION]", "[PARAMETER]").toString())
            .setCreateTime(Timestamp.newBuilder().build())
            .setUpdateTime(Timestamp.newBuilder().build())
            .putAllLabels(new HashMap<String, String>())
            .setFormat(ParameterFormat.forNumber(0))
            .setPolicyMember(ResourcePolicyMember.newBuilder().build())
            .setKmsKey("kmsKey-1127483058")
            .putAllTags(new HashMap<String, String>())
            .build();
    mockParameterManager.addResponse(expectedResponse);

    String name = "name3373707";

    Parameter actualResponse = client.getParameter(name);
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockParameterManager.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    GetParameterRequest actualRequest = ((GetParameterRequest) actualRequests.get(0));

    Assert.assertEquals(name, actualRequest.getName());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void getParameterExceptionTest2() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockParameterManager.addException(exception);

    try {
      String name = "name3373707";
      client.getParameter(name);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void createParameterTest() throws Exception {
    Parameter expectedResponse =
        Parameter.newBuilder()
            .setName(ParameterName.of("[PROJECT]", "[LOCATION]", "[PARAMETER]").toString())
            .setCreateTime(Timestamp.newBuilder().build())
            .setUpdateTime(Timestamp.newBuilder().build())
            .putAllLabels(new HashMap<String, String>())
            .setFormat(ParameterFormat.forNumber(0))
            .setPolicyMember(ResourcePolicyMember.newBuilder().build())
            .setKmsKey("kmsKey-1127483058")
            .putAllTags(new HashMap<String, String>())
            .build();
    mockParameterManager.addResponse(expectedResponse);

    LocationName parent = LocationName.of("[PROJECT]", "[LOCATION]");
    Parameter parameter = Parameter.newBuilder().build();
    String parameterId = "parameterId1335916196";

    Parameter actualResponse = client.createParameter(parent, parameter, parameterId);
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockParameterManager.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    CreateParameterRequest actualRequest = ((CreateParameterRequest) actualRequests.get(0));

    Assert.assertEquals(parent.toString(), actualRequest.getParent());
    Assert.assertEquals(parameter, actualRequest.getParameter());
    Assert.assertEquals(parameterId, actualRequest.getParameterId());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void createParameterExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockParameterManager.addException(exception);

    try {
      LocationName parent = LocationName.of("[PROJECT]", "[LOCATION]");
      Parameter parameter = Parameter.newBuilder().build();
      String parameterId = "parameterId1335916196";
      client.createParameter(parent, parameter, parameterId);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void createParameterTest2() throws Exception {
    Parameter expectedResponse =
        Parameter.newBuilder()
            .setName(ParameterName.of("[PROJECT]", "[LOCATION]", "[PARAMETER]").toString())
            .setCreateTime(Timestamp.newBuilder().build())
            .setUpdateTime(Timestamp.newBuilder().build())
            .putAllLabels(new HashMap<String, String>())
            .setFormat(ParameterFormat.forNumber(0))
            .setPolicyMember(ResourcePolicyMember.newBuilder().build())
            .setKmsKey("kmsKey-1127483058")
            .putAllTags(new HashMap<String, String>())
            .build();
    mockParameterManager.addResponse(expectedResponse);

    String parent = "parent-995424086";
    Parameter parameter = Parameter.newBuilder().build();
    String parameterId = "parameterId1335916196";

    Parameter actualResponse = client.createParameter(parent, parameter, parameterId);
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockParameterManager.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    CreateParameterRequest actualRequest = ((CreateParameterRequest) actualRequests.get(0));

    Assert.assertEquals(parent, actualRequest.getParent());
    Assert.assertEquals(parameter, actualRequest.getParameter());
    Assert.assertEquals(parameterId, actualRequest.getParameterId());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void createParameterExceptionTest2() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockParameterManager.addException(exception);

    try {
      String parent = "parent-995424086";
      Parameter parameter = Parameter.newBuilder().build();
      String parameterId = "parameterId1335916196";
      client.createParameter(parent, parameter, parameterId);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void updateParameterTest() throws Exception {
    Parameter expectedResponse =
        Parameter.newBuilder()
            .setName(ParameterName.of("[PROJECT]", "[LOCATION]", "[PARAMETER]").toString())
            .setCreateTime(Timestamp.newBuilder().build())
            .setUpdateTime(Timestamp.newBuilder().build())
            .putAllLabels(new HashMap<String, String>())
            .setFormat(ParameterFormat.forNumber(0))
            .setPolicyMember(ResourcePolicyMember.newBuilder().build())
            .setKmsKey("kmsKey-1127483058")
            .putAllTags(new HashMap<String, String>())
            .build();
    mockParameterManager.addResponse(expectedResponse);

    Parameter parameter = Parameter.newBuilder().build();
    FieldMask updateMask = FieldMask.newBuilder().build();

    Parameter actualResponse = client.updateParameter(parameter, updateMask);
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockParameterManager.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    UpdateParameterRequest actualRequest = ((UpdateParameterRequest) actualRequests.get(0));

    Assert.assertEquals(parameter, actualRequest.getParameter());
    Assert.assertEquals(updateMask, actualRequest.getUpdateMask());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void updateParameterExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockParameterManager.addException(exception);

    try {
      Parameter parameter = Parameter.newBuilder().build();
      FieldMask updateMask = FieldMask.newBuilder().build();
      client.updateParameter(parameter, updateMask);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void deleteParameterTest() throws Exception {
    Empty expectedResponse = Empty.newBuilder().build();
    mockParameterManager.addResponse(expectedResponse);

    ParameterName name = ParameterName.of("[PROJECT]", "[LOCATION]", "[PARAMETER]");

    client.deleteParameter(name);

    List<AbstractMessage> actualRequests = mockParameterManager.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    DeleteParameterRequest actualRequest = ((DeleteParameterRequest) actualRequests.get(0));

    Assert.assertEquals(name.toString(), actualRequest.getName());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void deleteParameterExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockParameterManager.addException(exception);

    try {
      ParameterName name = ParameterName.of("[PROJECT]", "[LOCATION]", "[PARAMETER]");
      client.deleteParameter(name);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void deleteParameterTest2() throws Exception {
    Empty expectedResponse = Empty.newBuilder().build();
    mockParameterManager.addResponse(expectedResponse);

    String name = "name3373707";

    client.deleteParameter(name);

    List<AbstractMessage> actualRequests = mockParameterManager.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    DeleteParameterRequest actualRequest = ((DeleteParameterRequest) actualRequests.get(0));

    Assert.assertEquals(name, actualRequest.getName());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void deleteParameterExceptionTest2() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockParameterManager.addException(exception);

    try {
      String name = "name3373707";
      client.deleteParameter(name);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void listParameterVersionsTest() throws Exception {
    ParameterVersion responsesElement = ParameterVersion.newBuilder().build();
    ListParameterVersionsResponse expectedResponse =
        ListParameterVersionsResponse.newBuilder()
            .setNextPageToken("")
            .addAllParameterVersions(Arrays.asList(responsesElement))
            .build();
    mockParameterManager.addResponse(expectedResponse);

    ParameterName parent = ParameterName.of("[PROJECT]", "[LOCATION]", "[PARAMETER]");

    ListParameterVersionsPagedResponse pagedListResponse = client.listParameterVersions(parent);

    List<ParameterVersion> resources = Lists.newArrayList(pagedListResponse.iterateAll());

    Assert.assertEquals(1, resources.size());
    Assert.assertEquals(expectedResponse.getParameterVersionsList().get(0), resources.get(0));

    List<AbstractMessage> actualRequests = mockParameterManager.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    ListParameterVersionsRequest actualRequest =
        ((ListParameterVersionsRequest) actualRequests.get(0));

    Assert.assertEquals(parent.toString(), actualRequest.getParent());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void listParameterVersionsExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockParameterManager.addException(exception);

    try {
      ParameterName parent = ParameterName.of("[PROJECT]", "[LOCATION]", "[PARAMETER]");
      client.listParameterVersions(parent);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void listParameterVersionsTest2() throws Exception {
    ParameterVersion responsesElement = ParameterVersion.newBuilder().build();
    ListParameterVersionsResponse expectedResponse =
        ListParameterVersionsResponse.newBuilder()
            .setNextPageToken("")
            .addAllParameterVersions(Arrays.asList(responsesElement))
            .build();
    mockParameterManager.addResponse(expectedResponse);

    String parent = "parent-995424086";

    ListParameterVersionsPagedResponse pagedListResponse = client.listParameterVersions(parent);

    List<ParameterVersion> resources = Lists.newArrayList(pagedListResponse.iterateAll());

    Assert.assertEquals(1, resources.size());
    Assert.assertEquals(expectedResponse.getParameterVersionsList().get(0), resources.get(0));

    List<AbstractMessage> actualRequests = mockParameterManager.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    ListParameterVersionsRequest actualRequest =
        ((ListParameterVersionsRequest) actualRequests.get(0));

    Assert.assertEquals(parent, actualRequest.getParent());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void listParameterVersionsExceptionTest2() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockParameterManager.addException(exception);

    try {
      String parent = "parent-995424086";
      client.listParameterVersions(parent);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void getParameterVersionTest() throws Exception {
    ParameterVersion expectedResponse =
        ParameterVersion.newBuilder()
            .setName(
                ParameterVersionName.of(
                        "[PROJECT]", "[LOCATION]", "[PARAMETER]", "[PARAMETER_VERSION]")
                    .toString())
            .setCreateTime(Timestamp.newBuilder().build())
            .setUpdateTime(Timestamp.newBuilder().build())
            .setDisabled(true)
            .setPayload(ParameterVersionPayload.newBuilder().build())
            .setKmsKeyVersion("kmsKeyVersion2084784042")
            .build();
    mockParameterManager.addResponse(expectedResponse);

    ParameterVersionName name =
        ParameterVersionName.of("[PROJECT]", "[LOCATION]", "[PARAMETER]", "[PARAMETER_VERSION]");

    ParameterVersion actualResponse = client.getParameterVersion(name);
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockParameterManager.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    GetParameterVersionRequest actualRequest = ((GetParameterVersionRequest) actualRequests.get(0));

    Assert.assertEquals(name.toString(), actualRequest.getName());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void getParameterVersionExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockParameterManager.addException(exception);

    try {
      ParameterVersionName name =
          ParameterVersionName.of("[PROJECT]", "[LOCATION]", "[PARAMETER]", "[PARAMETER_VERSION]");
      client.getParameterVersion(name);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void getParameterVersionTest2() throws Exception {
    ParameterVersion expectedResponse =
        ParameterVersion.newBuilder()
            .setName(
                ParameterVersionName.of(
                        "[PROJECT]", "[LOCATION]", "[PARAMETER]", "[PARAMETER_VERSION]")
                    .toString())
            .setCreateTime(Timestamp.newBuilder().build())
            .setUpdateTime(Timestamp.newBuilder().build())
            .setDisabled(true)
            .setPayload(ParameterVersionPayload.newBuilder().build())
            .setKmsKeyVersion("kmsKeyVersion2084784042")
            .build();
    mockParameterManager.addResponse(expectedResponse);

    String name = "name3373707";

    ParameterVersion actualResponse = client.getParameterVersion(name);
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockParameterManager.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    GetParameterVersionRequest actualRequest = ((GetParameterVersionRequest) actualRequests.get(0));

    Assert.assertEquals(name, actualRequest.getName());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void getParameterVersionExceptionTest2() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockParameterManager.addException(exception);

    try {
      String name = "name3373707";
      client.getParameterVersion(name);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void renderParameterVersionTest() throws Exception {
    RenderParameterVersionResponse expectedResponse =
        RenderParameterVersionResponse.newBuilder()
            .setParameterVersion(
                ParameterVersionName.of(
                        "[PROJECT]", "[LOCATION]", "[PARAMETER]", "[PARAMETER_VERSION]")
                    .toString())
            .setPayload(ParameterVersionPayload.newBuilder().build())
            .setRenderedPayload(ByteString.EMPTY)
            .build();
    mockParameterManager.addResponse(expectedResponse);

    ParameterVersionName name =
        ParameterVersionName.of("[PROJECT]", "[LOCATION]", "[PARAMETER]", "[PARAMETER_VERSION]");

    RenderParameterVersionResponse actualResponse = client.renderParameterVersion(name);
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockParameterManager.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    RenderParameterVersionRequest actualRequest =
        ((RenderParameterVersionRequest) actualRequests.get(0));

    Assert.assertEquals(name.toString(), actualRequest.getName());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void renderParameterVersionExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockParameterManager.addException(exception);

    try {
      ParameterVersionName name =
          ParameterVersionName.of("[PROJECT]", "[LOCATION]", "[PARAMETER]", "[PARAMETER_VERSION]");
      client.renderParameterVersion(name);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void renderParameterVersionTest2() throws Exception {
    RenderParameterVersionResponse expectedResponse =
        RenderParameterVersionResponse.newBuilder()
            .setParameterVersion(
                ParameterVersionName.of(
                        "[PROJECT]", "[LOCATION]", "[PARAMETER]", "[PARAMETER_VERSION]")
                    .toString())
            .setPayload(ParameterVersionPayload.newBuilder().build())
            .setRenderedPayload(ByteString.EMPTY)
            .build();
    mockParameterManager.addResponse(expectedResponse);

    String name = "name3373707";

    RenderParameterVersionResponse actualResponse = client.renderParameterVersion(name);
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockParameterManager.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    RenderParameterVersionRequest actualRequest =
        ((RenderParameterVersionRequest) actualRequests.get(0));

    Assert.assertEquals(name, actualRequest.getName());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void renderParameterVersionExceptionTest2() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockParameterManager.addException(exception);

    try {
      String name = "name3373707";
      client.renderParameterVersion(name);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void createParameterVersionTest() throws Exception {
    ParameterVersion expectedResponse =
        ParameterVersion.newBuilder()
            .setName(
                ParameterVersionName.of(
                        "[PROJECT]", "[LOCATION]", "[PARAMETER]", "[PARAMETER_VERSION]")
                    .toString())
            .setCreateTime(Timestamp.newBuilder().build())
            .setUpdateTime(Timestamp.newBuilder().build())
            .setDisabled(true)
            .setPayload(ParameterVersionPayload.newBuilder().build())
            .setKmsKeyVersion("kmsKeyVersion2084784042")
            .build();
    mockParameterManager.addResponse(expectedResponse);

    ParameterName parent = ParameterName.of("[PROJECT]", "[LOCATION]", "[PARAMETER]");
    ParameterVersion parameterVersion = ParameterVersion.newBuilder().build();
    String parameterVersionId = "parameterVersionId2070530666";

    ParameterVersion actualResponse =
        client.createParameterVersion(parent, parameterVersion, parameterVersionId);
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockParameterManager.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    CreateParameterVersionRequest actualRequest =
        ((CreateParameterVersionRequest) actualRequests.get(0));

    Assert.assertEquals(parent.toString(), actualRequest.getParent());
    Assert.assertEquals(parameterVersion, actualRequest.getParameterVersion());
    Assert.assertEquals(parameterVersionId, actualRequest.getParameterVersionId());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void createParameterVersionExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockParameterManager.addException(exception);

    try {
      ParameterName parent = ParameterName.of("[PROJECT]", "[LOCATION]", "[PARAMETER]");
      ParameterVersion parameterVersion = ParameterVersion.newBuilder().build();
      String parameterVersionId = "parameterVersionId2070530666";
      client.createParameterVersion(parent, parameterVersion, parameterVersionId);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void createParameterVersionTest2() throws Exception {
    ParameterVersion expectedResponse =
        ParameterVersion.newBuilder()
            .setName(
                ParameterVersionName.of(
                        "[PROJECT]", "[LOCATION]", "[PARAMETER]", "[PARAMETER_VERSION]")
                    .toString())
            .setCreateTime(Timestamp.newBuilder().build())
            .setUpdateTime(Timestamp.newBuilder().build())
            .setDisabled(true)
            .setPayload(ParameterVersionPayload.newBuilder().build())
            .setKmsKeyVersion("kmsKeyVersion2084784042")
            .build();
    mockParameterManager.addResponse(expectedResponse);

    String parent = "parent-995424086";
    ParameterVersion parameterVersion = ParameterVersion.newBuilder().build();
    String parameterVersionId = "parameterVersionId2070530666";

    ParameterVersion actualResponse =
        client.createParameterVersion(parent, parameterVersion, parameterVersionId);
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockParameterManager.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    CreateParameterVersionRequest actualRequest =
        ((CreateParameterVersionRequest) actualRequests.get(0));

    Assert.assertEquals(parent, actualRequest.getParent());
    Assert.assertEquals(parameterVersion, actualRequest.getParameterVersion());
    Assert.assertEquals(parameterVersionId, actualRequest.getParameterVersionId());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void createParameterVersionExceptionTest2() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockParameterManager.addException(exception);

    try {
      String parent = "parent-995424086";
      ParameterVersion parameterVersion = ParameterVersion.newBuilder().build();
      String parameterVersionId = "parameterVersionId2070530666";
      client.createParameterVersion(parent, parameterVersion, parameterVersionId);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void updateParameterVersionTest() throws Exception {
    ParameterVersion expectedResponse =
        ParameterVersion.newBuilder()
            .setName(
                ParameterVersionName.of(
                        "[PROJECT]", "[LOCATION]", "[PARAMETER]", "[PARAMETER_VERSION]")
                    .toString())
            .setCreateTime(Timestamp.newBuilder().build())
            .setUpdateTime(Timestamp.newBuilder().build())
            .setDisabled(true)
            .setPayload(ParameterVersionPayload.newBuilder().build())
            .setKmsKeyVersion("kmsKeyVersion2084784042")
            .build();
    mockParameterManager.addResponse(expectedResponse);

    ParameterVersion parameterVersion = ParameterVersion.newBuilder().build();
    FieldMask updateMask = FieldMask.newBuilder().build();

    ParameterVersion actualResponse = client.updateParameterVersion(parameterVersion, updateMask);
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockParameterManager.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    UpdateParameterVersionRequest actualRequest =
        ((UpdateParameterVersionRequest) actualRequests.get(0));

    Assert.assertEquals(parameterVersion, actualRequest.getParameterVersion());
    Assert.assertEquals(updateMask, actualRequest.getUpdateMask());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void updateParameterVersionExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockParameterManager.addException(exception);

    try {
      ParameterVersion parameterVersion = ParameterVersion.newBuilder().build();
      FieldMask updateMask = FieldMask.newBuilder().build();
      client.updateParameterVersion(parameterVersion, updateMask);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void deleteParameterVersionTest() throws Exception {
    Empty expectedResponse = Empty.newBuilder().build();
    mockParameterManager.addResponse(expectedResponse);

    ParameterVersionName name =
        ParameterVersionName.of("[PROJECT]", "[LOCATION]", "[PARAMETER]", "[PARAMETER_VERSION]");

    client.deleteParameterVersion(name);

    List<AbstractMessage> actualRequests = mockParameterManager.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    DeleteParameterVersionRequest actualRequest =
        ((DeleteParameterVersionRequest) actualRequests.get(0));

    Assert.assertEquals(name.toString(), actualRequest.getName());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void deleteParameterVersionExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockParameterManager.addException(exception);

    try {
      ParameterVersionName name =
          ParameterVersionName.of("[PROJECT]", "[LOCATION]", "[PARAMETER]", "[PARAMETER_VERSION]");
      client.deleteParameterVersion(name);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void deleteParameterVersionTest2() throws Exception {
    Empty expectedResponse = Empty.newBuilder().build();
    mockParameterManager.addResponse(expectedResponse);

    String name = "name3373707";

    client.deleteParameterVersion(name);

    List<AbstractMessage> actualRequests = mockParameterManager.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    DeleteParameterVersionRequest actualRequest =
        ((DeleteParameterVersionRequest) actualRequests.get(0));

    Assert.assertEquals(name, actualRequest.getName());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void deleteParameterVersionExceptionTest2() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockParameterManager.addException(exception);

    try {
      String name = "name3373707";
      client.deleteParameterVersion(name);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void listTemplatesTest() throws Exception {
    Template responsesElement = Template.newBuilder().build();
    ListTemplatesResponse expectedResponse =
        ListTemplatesResponse.newBuilder()
            .setNextPageToken("")
            .addAllTemplates(Arrays.asList(responsesElement))
            .build();
    mockParameterManager.addResponse(expectedResponse);

    LocationName parent = LocationName.of("[PROJECT]", "[LOCATION]");

    ListTemplatesPagedResponse pagedListResponse = client.listTemplates(parent);

    List<Template> resources = Lists.newArrayList(pagedListResponse.iterateAll());

    Assert.assertEquals(1, resources.size());
    Assert.assertEquals(expectedResponse.getTemplatesList().get(0), resources.get(0));

    List<AbstractMessage> actualRequests = mockParameterManager.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    ListTemplatesRequest actualRequest = ((ListTemplatesRequest) actualRequests.get(0));

    Assert.assertEquals(parent.toString(), actualRequest.getParent());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void listTemplatesExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockParameterManager.addException(exception);

    try {
      LocationName parent = LocationName.of("[PROJECT]", "[LOCATION]");
      client.listTemplates(parent);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void listTemplatesTest2() throws Exception {
    Template responsesElement = Template.newBuilder().build();
    ListTemplatesResponse expectedResponse =
        ListTemplatesResponse.newBuilder()
            .setNextPageToken("")
            .addAllTemplates(Arrays.asList(responsesElement))
            .build();
    mockParameterManager.addResponse(expectedResponse);

    String parent = "parent-995424086";

    ListTemplatesPagedResponse pagedListResponse = client.listTemplates(parent);

    List<Template> resources = Lists.newArrayList(pagedListResponse.iterateAll());

    Assert.assertEquals(1, resources.size());
    Assert.assertEquals(expectedResponse.getTemplatesList().get(0), resources.get(0));

    List<AbstractMessage> actualRequests = mockParameterManager.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    ListTemplatesRequest actualRequest = ((ListTemplatesRequest) actualRequests.get(0));

    Assert.assertEquals(parent, actualRequest.getParent());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void listTemplatesExceptionTest2() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockParameterManager.addException(exception);

    try {
      String parent = "parent-995424086";
      client.listTemplates(parent);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void getTemplateTest() throws Exception {
    Template expectedResponse =
        Template.newBuilder()
            .setName(TemplateName.of("[PROJECT]", "[LOCATION]", "[TEMPLATE]").toString())
            .setCreateTime(Timestamp.newBuilder().build())
            .setUpdateTime(Timestamp.newBuilder().build())
            .putAllLabels(new HashMap<String, String>())
            .setFormat(TemplateFormat.forNumber(0))
            .build();
    mockParameterManager.addResponse(expectedResponse);

    TemplateName name = TemplateName.of("[PROJECT]", "[LOCATION]", "[TEMPLATE]");

    Template actualResponse = client.getTemplate(name);
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockParameterManager.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    GetTemplateRequest actualRequest = ((GetTemplateRequest) actualRequests.get(0));

    Assert.assertEquals(name.toString(), actualRequest.getName());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void getTemplateExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockParameterManager.addException(exception);

    try {
      TemplateName name = TemplateName.of("[PROJECT]", "[LOCATION]", "[TEMPLATE]");
      client.getTemplate(name);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void getTemplateTest2() throws Exception {
    Template expectedResponse =
        Template.newBuilder()
            .setName(TemplateName.of("[PROJECT]", "[LOCATION]", "[TEMPLATE]").toString())
            .setCreateTime(Timestamp.newBuilder().build())
            .setUpdateTime(Timestamp.newBuilder().build())
            .putAllLabels(new HashMap<String, String>())
            .setFormat(TemplateFormat.forNumber(0))
            .build();
    mockParameterManager.addResponse(expectedResponse);

    String name = "name3373707";

    Template actualResponse = client.getTemplate(name);
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockParameterManager.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    GetTemplateRequest actualRequest = ((GetTemplateRequest) actualRequests.get(0));

    Assert.assertEquals(name, actualRequest.getName());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void getTemplateExceptionTest2() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockParameterManager.addException(exception);

    try {
      String name = "name3373707";
      client.getTemplate(name);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void createTemplateTest() throws Exception {
    Template expectedResponse =
        Template.newBuilder()
            .setName(TemplateName.of("[PROJECT]", "[LOCATION]", "[TEMPLATE]").toString())
            .setCreateTime(Timestamp.newBuilder().build())
            .setUpdateTime(Timestamp.newBuilder().build())
            .putAllLabels(new HashMap<String, String>())
            .setFormat(TemplateFormat.forNumber(0))
            .build();
    mockParameterManager.addResponse(expectedResponse);

    LocationName parent = LocationName.of("[PROJECT]", "[LOCATION]");
    Template template = Template.newBuilder().build();
    String templateId = "templateId1304010549";

    Template actualResponse = client.createTemplate(parent, template, templateId);
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockParameterManager.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    CreateTemplateRequest actualRequest = ((CreateTemplateRequest) actualRequests.get(0));

    Assert.assertEquals(parent.toString(), actualRequest.getParent());
    Assert.assertEquals(template, actualRequest.getTemplate());
    Assert.assertEquals(templateId, actualRequest.getTemplateId());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void createTemplateExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockParameterManager.addException(exception);

    try {
      LocationName parent = LocationName.of("[PROJECT]", "[LOCATION]");
      Template template = Template.newBuilder().build();
      String templateId = "templateId1304010549";
      client.createTemplate(parent, template, templateId);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void createTemplateTest2() throws Exception {
    Template expectedResponse =
        Template.newBuilder()
            .setName(TemplateName.of("[PROJECT]", "[LOCATION]", "[TEMPLATE]").toString())
            .setCreateTime(Timestamp.newBuilder().build())
            .setUpdateTime(Timestamp.newBuilder().build())
            .putAllLabels(new HashMap<String, String>())
            .setFormat(TemplateFormat.forNumber(0))
            .build();
    mockParameterManager.addResponse(expectedResponse);

    String parent = "parent-995424086";
    Template template = Template.newBuilder().build();
    String templateId = "templateId1304010549";

    Template actualResponse = client.createTemplate(parent, template, templateId);
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockParameterManager.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    CreateTemplateRequest actualRequest = ((CreateTemplateRequest) actualRequests.get(0));

    Assert.assertEquals(parent, actualRequest.getParent());
    Assert.assertEquals(template, actualRequest.getTemplate());
    Assert.assertEquals(templateId, actualRequest.getTemplateId());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void createTemplateExceptionTest2() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockParameterManager.addException(exception);

    try {
      String parent = "parent-995424086";
      Template template = Template.newBuilder().build();
      String templateId = "templateId1304010549";
      client.createTemplate(parent, template, templateId);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void updateTemplateTest() throws Exception {
    Template expectedResponse =
        Template.newBuilder()
            .setName(TemplateName.of("[PROJECT]", "[LOCATION]", "[TEMPLATE]").toString())
            .setCreateTime(Timestamp.newBuilder().build())
            .setUpdateTime(Timestamp.newBuilder().build())
            .putAllLabels(new HashMap<String, String>())
            .setFormat(TemplateFormat.forNumber(0))
            .build();
    mockParameterManager.addResponse(expectedResponse);

    Template template = Template.newBuilder().build();
    FieldMask updateMask = FieldMask.newBuilder().build();

    Template actualResponse = client.updateTemplate(template, updateMask);
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockParameterManager.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    UpdateTemplateRequest actualRequest = ((UpdateTemplateRequest) actualRequests.get(0));

    Assert.assertEquals(template, actualRequest.getTemplate());
    Assert.assertEquals(updateMask, actualRequest.getUpdateMask());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void updateTemplateExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockParameterManager.addException(exception);

    try {
      Template template = Template.newBuilder().build();
      FieldMask updateMask = FieldMask.newBuilder().build();
      client.updateTemplate(template, updateMask);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void deleteTemplateTest() throws Exception {
    Empty expectedResponse = Empty.newBuilder().build();
    mockParameterManager.addResponse(expectedResponse);

    TemplateName name = TemplateName.of("[PROJECT]", "[LOCATION]", "[TEMPLATE]");

    client.deleteTemplate(name);

    List<AbstractMessage> actualRequests = mockParameterManager.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    DeleteTemplateRequest actualRequest = ((DeleteTemplateRequest) actualRequests.get(0));

    Assert.assertEquals(name.toString(), actualRequest.getName());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void deleteTemplateExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockParameterManager.addException(exception);

    try {
      TemplateName name = TemplateName.of("[PROJECT]", "[LOCATION]", "[TEMPLATE]");
      client.deleteTemplate(name);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void deleteTemplateTest2() throws Exception {
    Empty expectedResponse = Empty.newBuilder().build();
    mockParameterManager.addResponse(expectedResponse);

    String name = "name3373707";

    client.deleteTemplate(name);

    List<AbstractMessage> actualRequests = mockParameterManager.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    DeleteTemplateRequest actualRequest = ((DeleteTemplateRequest) actualRequests.get(0));

    Assert.assertEquals(name, actualRequest.getName());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void deleteTemplateExceptionTest2() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockParameterManager.addException(exception);

    try {
      String name = "name3373707";
      client.deleteTemplate(name);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void listTemplateVersionsTest() throws Exception {
    TemplateVersion responsesElement = TemplateVersion.newBuilder().build();
    ListTemplateVersionsResponse expectedResponse =
        ListTemplateVersionsResponse.newBuilder()
            .setNextPageToken("")
            .addAllTemplateVersions(Arrays.asList(responsesElement))
            .build();
    mockParameterManager.addResponse(expectedResponse);

    TemplateName parent = TemplateName.of("[PROJECT]", "[LOCATION]", "[TEMPLATE]");

    ListTemplateVersionsPagedResponse pagedListResponse = client.listTemplateVersions(parent);

    List<TemplateVersion> resources = Lists.newArrayList(pagedListResponse.iterateAll());

    Assert.assertEquals(1, resources.size());
    Assert.assertEquals(expectedResponse.getTemplateVersionsList().get(0), resources.get(0));

    List<AbstractMessage> actualRequests = mockParameterManager.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    ListTemplateVersionsRequest actualRequest =
        ((ListTemplateVersionsRequest) actualRequests.get(0));

    Assert.assertEquals(parent.toString(), actualRequest.getParent());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void listTemplateVersionsExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockParameterManager.addException(exception);

    try {
      TemplateName parent = TemplateName.of("[PROJECT]", "[LOCATION]", "[TEMPLATE]");
      client.listTemplateVersions(parent);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void listTemplateVersionsTest2() throws Exception {
    TemplateVersion responsesElement = TemplateVersion.newBuilder().build();
    ListTemplateVersionsResponse expectedResponse =
        ListTemplateVersionsResponse.newBuilder()
            .setNextPageToken("")
            .addAllTemplateVersions(Arrays.asList(responsesElement))
            .build();
    mockParameterManager.addResponse(expectedResponse);

    String parent = "parent-995424086";

    ListTemplateVersionsPagedResponse pagedListResponse = client.listTemplateVersions(parent);

    List<TemplateVersion> resources = Lists.newArrayList(pagedListResponse.iterateAll());

    Assert.assertEquals(1, resources.size());
    Assert.assertEquals(expectedResponse.getTemplateVersionsList().get(0), resources.get(0));

    List<AbstractMessage> actualRequests = mockParameterManager.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    ListTemplateVersionsRequest actualRequest =
        ((ListTemplateVersionsRequest) actualRequests.get(0));

    Assert.assertEquals(parent, actualRequest.getParent());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void listTemplateVersionsExceptionTest2() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockParameterManager.addException(exception);

    try {
      String parent = "parent-995424086";
      client.listTemplateVersions(parent);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void getTemplateVersionTest() throws Exception {
    TemplateVersion expectedResponse =
        TemplateVersion.newBuilder()
            .setName(
                TemplateVersionName.of(
                        "[PROJECT]", "[LOCATION]", "[TEMPLATE]", "[TEMPLATE_VERSION]")
                    .toString())
            .setCreateTime(Timestamp.newBuilder().build())
            .setUpdateTime(Timestamp.newBuilder().build())
            .setDisabled(true)
            .setPayload(TemplateVersionPayload.newBuilder().build())
            .build();
    mockParameterManager.addResponse(expectedResponse);

    TemplateVersionName name =
        TemplateVersionName.of("[PROJECT]", "[LOCATION]", "[TEMPLATE]", "[TEMPLATE_VERSION]");

    TemplateVersion actualResponse = client.getTemplateVersion(name);
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockParameterManager.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    GetTemplateVersionRequest actualRequest = ((GetTemplateVersionRequest) actualRequests.get(0));

    Assert.assertEquals(name.toString(), actualRequest.getName());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void getTemplateVersionExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockParameterManager.addException(exception);

    try {
      TemplateVersionName name =
          TemplateVersionName.of("[PROJECT]", "[LOCATION]", "[TEMPLATE]", "[TEMPLATE_VERSION]");
      client.getTemplateVersion(name);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void getTemplateVersionTest2() throws Exception {
    TemplateVersion expectedResponse =
        TemplateVersion.newBuilder()
            .setName(
                TemplateVersionName.of(
                        "[PROJECT]", "[LOCATION]", "[TEMPLATE]", "[TEMPLATE_VERSION]")
                    .toString())
            .setCreateTime(Timestamp.newBuilder().build())
            .setUpdateTime(Timestamp.newBuilder().build())
            .setDisabled(true)
            .setPayload(TemplateVersionPayload.newBuilder().build())
            .build();
    mockParameterManager.addResponse(expectedResponse);

    String name = "name3373707";

    TemplateVersion actualResponse = client.getTemplateVersion(name);
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockParameterManager.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    GetTemplateVersionRequest actualRequest = ((GetTemplateVersionRequest) actualRequests.get(0));

    Assert.assertEquals(name, actualRequest.getName());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void getTemplateVersionExceptionTest2() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockParameterManager.addException(exception);

    try {
      String name = "name3373707";
      client.getTemplateVersion(name);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void createTemplateVersionTest() throws Exception {
    TemplateVersion expectedResponse =
        TemplateVersion.newBuilder()
            .setName(
                TemplateVersionName.of(
                        "[PROJECT]", "[LOCATION]", "[TEMPLATE]", "[TEMPLATE_VERSION]")
                    .toString())
            .setCreateTime(Timestamp.newBuilder().build())
            .setUpdateTime(Timestamp.newBuilder().build())
            .setDisabled(true)
            .setPayload(TemplateVersionPayload.newBuilder().build())
            .build();
    mockParameterManager.addResponse(expectedResponse);

    TemplateName parent = TemplateName.of("[PROJECT]", "[LOCATION]", "[TEMPLATE]");
    TemplateVersion templateVersion = TemplateVersion.newBuilder().build();
    String templateVersionId = "templateVersionId616434873";

    TemplateVersion actualResponse =
        client.createTemplateVersion(parent, templateVersion, templateVersionId);
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockParameterManager.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    CreateTemplateVersionRequest actualRequest =
        ((CreateTemplateVersionRequest) actualRequests.get(0));

    Assert.assertEquals(parent.toString(), actualRequest.getParent());
    Assert.assertEquals(templateVersion, actualRequest.getTemplateVersion());
    Assert.assertEquals(templateVersionId, actualRequest.getTemplateVersionId());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void createTemplateVersionExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockParameterManager.addException(exception);

    try {
      TemplateName parent = TemplateName.of("[PROJECT]", "[LOCATION]", "[TEMPLATE]");
      TemplateVersion templateVersion = TemplateVersion.newBuilder().build();
      String templateVersionId = "templateVersionId616434873";
      client.createTemplateVersion(parent, templateVersion, templateVersionId);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void createTemplateVersionTest2() throws Exception {
    TemplateVersion expectedResponse =
        TemplateVersion.newBuilder()
            .setName(
                TemplateVersionName.of(
                        "[PROJECT]", "[LOCATION]", "[TEMPLATE]", "[TEMPLATE_VERSION]")
                    .toString())
            .setCreateTime(Timestamp.newBuilder().build())
            .setUpdateTime(Timestamp.newBuilder().build())
            .setDisabled(true)
            .setPayload(TemplateVersionPayload.newBuilder().build())
            .build();
    mockParameterManager.addResponse(expectedResponse);

    String parent = "parent-995424086";
    TemplateVersion templateVersion = TemplateVersion.newBuilder().build();
    String templateVersionId = "templateVersionId616434873";

    TemplateVersion actualResponse =
        client.createTemplateVersion(parent, templateVersion, templateVersionId);
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockParameterManager.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    CreateTemplateVersionRequest actualRequest =
        ((CreateTemplateVersionRequest) actualRequests.get(0));

    Assert.assertEquals(parent, actualRequest.getParent());
    Assert.assertEquals(templateVersion, actualRequest.getTemplateVersion());
    Assert.assertEquals(templateVersionId, actualRequest.getTemplateVersionId());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void createTemplateVersionExceptionTest2() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockParameterManager.addException(exception);

    try {
      String parent = "parent-995424086";
      TemplateVersion templateVersion = TemplateVersion.newBuilder().build();
      String templateVersionId = "templateVersionId616434873";
      client.createTemplateVersion(parent, templateVersion, templateVersionId);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void updateTemplateVersionTest() throws Exception {
    TemplateVersion expectedResponse =
        TemplateVersion.newBuilder()
            .setName(
                TemplateVersionName.of(
                        "[PROJECT]", "[LOCATION]", "[TEMPLATE]", "[TEMPLATE_VERSION]")
                    .toString())
            .setCreateTime(Timestamp.newBuilder().build())
            .setUpdateTime(Timestamp.newBuilder().build())
            .setDisabled(true)
            .setPayload(TemplateVersionPayload.newBuilder().build())
            .build();
    mockParameterManager.addResponse(expectedResponse);

    TemplateVersion templateVersion = TemplateVersion.newBuilder().build();
    FieldMask updateMask = FieldMask.newBuilder().build();

    TemplateVersion actualResponse = client.updateTemplateVersion(templateVersion, updateMask);
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockParameterManager.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    UpdateTemplateVersionRequest actualRequest =
        ((UpdateTemplateVersionRequest) actualRequests.get(0));

    Assert.assertEquals(templateVersion, actualRequest.getTemplateVersion());
    Assert.assertEquals(updateMask, actualRequest.getUpdateMask());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void updateTemplateVersionExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockParameterManager.addException(exception);

    try {
      TemplateVersion templateVersion = TemplateVersion.newBuilder().build();
      FieldMask updateMask = FieldMask.newBuilder().build();
      client.updateTemplateVersion(templateVersion, updateMask);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void deleteTemplateVersionTest() throws Exception {
    Empty expectedResponse = Empty.newBuilder().build();
    mockParameterManager.addResponse(expectedResponse);

    TemplateVersionName name =
        TemplateVersionName.of("[PROJECT]", "[LOCATION]", "[TEMPLATE]", "[TEMPLATE_VERSION]");

    client.deleteTemplateVersion(name);

    List<AbstractMessage> actualRequests = mockParameterManager.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    DeleteTemplateVersionRequest actualRequest =
        ((DeleteTemplateVersionRequest) actualRequests.get(0));

    Assert.assertEquals(name.toString(), actualRequest.getName());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void deleteTemplateVersionExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockParameterManager.addException(exception);

    try {
      TemplateVersionName name =
          TemplateVersionName.of("[PROJECT]", "[LOCATION]", "[TEMPLATE]", "[TEMPLATE_VERSION]");
      client.deleteTemplateVersion(name);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void deleteTemplateVersionTest2() throws Exception {
    Empty expectedResponse = Empty.newBuilder().build();
    mockParameterManager.addResponse(expectedResponse);

    String name = "name3373707";

    client.deleteTemplateVersion(name);

    List<AbstractMessage> actualRequests = mockParameterManager.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    DeleteTemplateVersionRequest actualRequest =
        ((DeleteTemplateVersionRequest) actualRequests.get(0));

    Assert.assertEquals(name, actualRequest.getName());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void deleteTemplateVersionExceptionTest2() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockParameterManager.addException(exception);

    try {
      String name = "name3373707";
      client.deleteTemplateVersion(name);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void renderTemplateVersionTest() throws Exception {
    RenderTemplateVersionResponse expectedResponse =
        RenderTemplateVersionResponse.newBuilder()
            .setTemplateVersion(
                TemplateVersionName.of(
                        "[PROJECT]", "[LOCATION]", "[TEMPLATE]", "[TEMPLATE_VERSION]")
                    .toString())
            .setPayload(TemplateVersionPayload.newBuilder().build())
            .setRenderedPayload(ByteString.EMPTY)
            .setTemplateFormat(TemplateFormat.forNumber(0))
            .setParameterVersion(
                ParameterVersionName.of(
                        "[PROJECT]", "[LOCATION]", "[PARAMETER]", "[PARAMETER_VERSION]")
                    .toString())
            .build();
    mockParameterManager.addResponse(expectedResponse);

    TemplateVersionName name =
        TemplateVersionName.of("[PROJECT]", "[LOCATION]", "[TEMPLATE]", "[TEMPLATE_VERSION]");

    RenderTemplateVersionResponse actualResponse = client.renderTemplateVersion(name);
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockParameterManager.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    RenderTemplateVersionRequest actualRequest =
        ((RenderTemplateVersionRequest) actualRequests.get(0));

    Assert.assertEquals(name.toString(), actualRequest.getName());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void renderTemplateVersionExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockParameterManager.addException(exception);

    try {
      TemplateVersionName name =
          TemplateVersionName.of("[PROJECT]", "[LOCATION]", "[TEMPLATE]", "[TEMPLATE_VERSION]");
      client.renderTemplateVersion(name);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void renderTemplateVersionTest2() throws Exception {
    RenderTemplateVersionResponse expectedResponse =
        RenderTemplateVersionResponse.newBuilder()
            .setTemplateVersion(
                TemplateVersionName.of(
                        "[PROJECT]", "[LOCATION]", "[TEMPLATE]", "[TEMPLATE_VERSION]")
                    .toString())
            .setPayload(TemplateVersionPayload.newBuilder().build())
            .setRenderedPayload(ByteString.EMPTY)
            .setTemplateFormat(TemplateFormat.forNumber(0))
            .setParameterVersion(
                ParameterVersionName.of(
                        "[PROJECT]", "[LOCATION]", "[PARAMETER]", "[PARAMETER_VERSION]")
                    .toString())
            .build();
    mockParameterManager.addResponse(expectedResponse);

    String name = "name3373707";

    RenderTemplateVersionResponse actualResponse = client.renderTemplateVersion(name);
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockParameterManager.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    RenderTemplateVersionRequest actualRequest =
        ((RenderTemplateVersionRequest) actualRequests.get(0));

    Assert.assertEquals(name, actualRequest.getName());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void renderTemplateVersionExceptionTest2() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockParameterManager.addException(exception);

    try {
      String name = "name3373707";
      client.renderTemplateVersion(name);
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
