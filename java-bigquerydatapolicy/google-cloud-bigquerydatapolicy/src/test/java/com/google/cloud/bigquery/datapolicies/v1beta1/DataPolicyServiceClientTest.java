/*
 * Copyright 2022 Google LLC
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

package com.google.cloud.bigquery.datapolicies.v1beta1;

import static com.google.cloud.bigquery.datapolicies.v1beta1.DataPolicyServiceClient.ListDataPoliciesPagedResponse;

import com.google.api.gax.core.NoCredentialsProvider;
import com.google.api.gax.grpc.GaxGrpcProperties;
import com.google.api.gax.grpc.testing.LocalChannelProvider;
import com.google.api.gax.grpc.testing.MockGrpcService;
import com.google.api.gax.grpc.testing.MockServiceHelper;
import com.google.api.gax.rpc.ApiClientHeaderProvider;
import com.google.api.gax.rpc.InvalidArgumentException;
import com.google.common.collect.Lists;
import com.google.iam.v1.AuditConfig;
import com.google.iam.v1.Binding;
import com.google.iam.v1.GetIamPolicyRequest;
import com.google.iam.v1.GetPolicyOptions;
import com.google.iam.v1.Policy;
import com.google.iam.v1.SetIamPolicyRequest;
import com.google.iam.v1.TestIamPermissionsRequest;
import com.google.iam.v1.TestIamPermissionsResponse;
import com.google.protobuf.AbstractMessage;
import com.google.protobuf.ByteString;
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
public class DataPolicyServiceClientTest {
  private static MockDataPolicyService mockDataPolicyService;
  private static MockServiceHelper mockServiceHelper;
  private LocalChannelProvider channelProvider;
  private DataPolicyServiceClient client;

  @BeforeClass
  public static void startStaticServer() {
    mockDataPolicyService = new MockDataPolicyService();
    mockServiceHelper =
        new MockServiceHelper(
            UUID.randomUUID().toString(), Arrays.<MockGrpcService>asList(mockDataPolicyService));
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
    DataPolicyServiceSettings settings =
        DataPolicyServiceSettings.newBuilder()
            .setTransportChannelProvider(channelProvider)
            .setCredentialsProvider(NoCredentialsProvider.create())
            .build();
    client = DataPolicyServiceClient.create(settings);
  }

  @After
  public void tearDown() throws Exception {
    client.close();
  }

  @Test
  public void createDataPolicyTest() throws Exception {
    DataPolicy expectedResponse =
        DataPolicy.newBuilder()
            .setName(DataPolicyName.of("[PROJECT]", "[LOCATION]", "[DATA_POLICY]").toString())
            .setDataPolicyId("dataPolicyId1874146231")
            .build();
    mockDataPolicyService.addResponse(expectedResponse);

    LocationName parent = LocationName.of("[PROJECT]", "[LOCATION]");
    DataPolicy dataPolicy = DataPolicy.newBuilder().build();

    DataPolicy actualResponse = client.createDataPolicy(parent, dataPolicy);
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockDataPolicyService.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    CreateDataPolicyRequest actualRequest = ((CreateDataPolicyRequest) actualRequests.get(0));

    Assert.assertEquals(parent.toString(), actualRequest.getParent());
    Assert.assertEquals(dataPolicy, actualRequest.getDataPolicy());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void createDataPolicyExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockDataPolicyService.addException(exception);

    try {
      LocationName parent = LocationName.of("[PROJECT]", "[LOCATION]");
      DataPolicy dataPolicy = DataPolicy.newBuilder().build();
      client.createDataPolicy(parent, dataPolicy);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void createDataPolicyTest2() throws Exception {
    DataPolicy expectedResponse =
        DataPolicy.newBuilder()
            .setName(DataPolicyName.of("[PROJECT]", "[LOCATION]", "[DATA_POLICY]").toString())
            .setDataPolicyId("dataPolicyId1874146231")
            .build();
    mockDataPolicyService.addResponse(expectedResponse);

    String parent = "parent-995424086";
    DataPolicy dataPolicy = DataPolicy.newBuilder().build();

    DataPolicy actualResponse = client.createDataPolicy(parent, dataPolicy);
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockDataPolicyService.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    CreateDataPolicyRequest actualRequest = ((CreateDataPolicyRequest) actualRequests.get(0));

    Assert.assertEquals(parent, actualRequest.getParent());
    Assert.assertEquals(dataPolicy, actualRequest.getDataPolicy());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void createDataPolicyExceptionTest2() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockDataPolicyService.addException(exception);

    try {
      String parent = "parent-995424086";
      DataPolicy dataPolicy = DataPolicy.newBuilder().build();
      client.createDataPolicy(parent, dataPolicy);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void updateDataPolicyTest() throws Exception {
    DataPolicy expectedResponse =
        DataPolicy.newBuilder()
            .setName(DataPolicyName.of("[PROJECT]", "[LOCATION]", "[DATA_POLICY]").toString())
            .setDataPolicyId("dataPolicyId1874146231")
            .build();
    mockDataPolicyService.addResponse(expectedResponse);

    DataPolicy dataPolicy = DataPolicy.newBuilder().build();
    FieldMask updateMask = FieldMask.newBuilder().build();

    DataPolicy actualResponse = client.updateDataPolicy(dataPolicy, updateMask);
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockDataPolicyService.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    UpdateDataPolicyRequest actualRequest = ((UpdateDataPolicyRequest) actualRequests.get(0));

    Assert.assertEquals(dataPolicy, actualRequest.getDataPolicy());
    Assert.assertEquals(updateMask, actualRequest.getUpdateMask());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void updateDataPolicyExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockDataPolicyService.addException(exception);

    try {
      DataPolicy dataPolicy = DataPolicy.newBuilder().build();
      FieldMask updateMask = FieldMask.newBuilder().build();
      client.updateDataPolicy(dataPolicy, updateMask);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void deleteDataPolicyTest() throws Exception {
    Empty expectedResponse = Empty.newBuilder().build();
    mockDataPolicyService.addResponse(expectedResponse);

    DataPolicyName name = DataPolicyName.of("[PROJECT]", "[LOCATION]", "[DATA_POLICY]");

    client.deleteDataPolicy(name);

    List<AbstractMessage> actualRequests = mockDataPolicyService.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    DeleteDataPolicyRequest actualRequest = ((DeleteDataPolicyRequest) actualRequests.get(0));

    Assert.assertEquals(name.toString(), actualRequest.getName());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void deleteDataPolicyExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockDataPolicyService.addException(exception);

    try {
      DataPolicyName name = DataPolicyName.of("[PROJECT]", "[LOCATION]", "[DATA_POLICY]");
      client.deleteDataPolicy(name);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void deleteDataPolicyTest2() throws Exception {
    Empty expectedResponse = Empty.newBuilder().build();
    mockDataPolicyService.addResponse(expectedResponse);

    String name = "name3373707";

    client.deleteDataPolicy(name);

    List<AbstractMessage> actualRequests = mockDataPolicyService.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    DeleteDataPolicyRequest actualRequest = ((DeleteDataPolicyRequest) actualRequests.get(0));

    Assert.assertEquals(name, actualRequest.getName());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void deleteDataPolicyExceptionTest2() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockDataPolicyService.addException(exception);

    try {
      String name = "name3373707";
      client.deleteDataPolicy(name);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void getDataPolicyTest() throws Exception {
    DataPolicy expectedResponse =
        DataPolicy.newBuilder()
            .setName(DataPolicyName.of("[PROJECT]", "[LOCATION]", "[DATA_POLICY]").toString())
            .setDataPolicyId("dataPolicyId1874146231")
            .build();
    mockDataPolicyService.addResponse(expectedResponse);

    DataPolicyName name = DataPolicyName.of("[PROJECT]", "[LOCATION]", "[DATA_POLICY]");

    DataPolicy actualResponse = client.getDataPolicy(name);
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockDataPolicyService.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    GetDataPolicyRequest actualRequest = ((GetDataPolicyRequest) actualRequests.get(0));

    Assert.assertEquals(name.toString(), actualRequest.getName());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void getDataPolicyExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockDataPolicyService.addException(exception);

    try {
      DataPolicyName name = DataPolicyName.of("[PROJECT]", "[LOCATION]", "[DATA_POLICY]");
      client.getDataPolicy(name);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void getDataPolicyTest2() throws Exception {
    DataPolicy expectedResponse =
        DataPolicy.newBuilder()
            .setName(DataPolicyName.of("[PROJECT]", "[LOCATION]", "[DATA_POLICY]").toString())
            .setDataPolicyId("dataPolicyId1874146231")
            .build();
    mockDataPolicyService.addResponse(expectedResponse);

    String name = "name3373707";

    DataPolicy actualResponse = client.getDataPolicy(name);
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockDataPolicyService.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    GetDataPolicyRequest actualRequest = ((GetDataPolicyRequest) actualRequests.get(0));

    Assert.assertEquals(name, actualRequest.getName());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void getDataPolicyExceptionTest2() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockDataPolicyService.addException(exception);

    try {
      String name = "name3373707";
      client.getDataPolicy(name);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void listDataPoliciesTest() throws Exception {
    DataPolicy responsesElement = DataPolicy.newBuilder().build();
    ListDataPoliciesResponse expectedResponse =
        ListDataPoliciesResponse.newBuilder()
            .setNextPageToken("")
            .addAllDataPolicies(Arrays.asList(responsesElement))
            .build();
    mockDataPolicyService.addResponse(expectedResponse);

    LocationName parent = LocationName.of("[PROJECT]", "[LOCATION]");

    ListDataPoliciesPagedResponse pagedListResponse = client.listDataPolicies(parent);

    List<DataPolicy> resources = Lists.newArrayList(pagedListResponse.iterateAll());

    Assert.assertEquals(1, resources.size());
    Assert.assertEquals(expectedResponse.getDataPoliciesList().get(0), resources.get(0));

    List<AbstractMessage> actualRequests = mockDataPolicyService.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    ListDataPoliciesRequest actualRequest = ((ListDataPoliciesRequest) actualRequests.get(0));

    Assert.assertEquals(parent.toString(), actualRequest.getParent());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void listDataPoliciesExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockDataPolicyService.addException(exception);

    try {
      LocationName parent = LocationName.of("[PROJECT]", "[LOCATION]");
      client.listDataPolicies(parent);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void listDataPoliciesTest2() throws Exception {
    DataPolicy responsesElement = DataPolicy.newBuilder().build();
    ListDataPoliciesResponse expectedResponse =
        ListDataPoliciesResponse.newBuilder()
            .setNextPageToken("")
            .addAllDataPolicies(Arrays.asList(responsesElement))
            .build();
    mockDataPolicyService.addResponse(expectedResponse);

    String parent = "parent-995424086";

    ListDataPoliciesPagedResponse pagedListResponse = client.listDataPolicies(parent);

    List<DataPolicy> resources = Lists.newArrayList(pagedListResponse.iterateAll());

    Assert.assertEquals(1, resources.size());
    Assert.assertEquals(expectedResponse.getDataPoliciesList().get(0), resources.get(0));

    List<AbstractMessage> actualRequests = mockDataPolicyService.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    ListDataPoliciesRequest actualRequest = ((ListDataPoliciesRequest) actualRequests.get(0));

    Assert.assertEquals(parent, actualRequest.getParent());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void listDataPoliciesExceptionTest2() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockDataPolicyService.addException(exception);

    try {
      String parent = "parent-995424086";
      client.listDataPolicies(parent);
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
    mockDataPolicyService.addResponse(expectedResponse);

    GetIamPolicyRequest request =
        GetIamPolicyRequest.newBuilder()
            .setResource(DataPolicyName.of("[PROJECT]", "[LOCATION]", "[DATA_POLICY]").toString())
            .setOptions(GetPolicyOptions.newBuilder().build())
            .build();

    Policy actualResponse = client.getIamPolicy(request);
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockDataPolicyService.getRequests();
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
    mockDataPolicyService.addException(exception);

    try {
      GetIamPolicyRequest request =
          GetIamPolicyRequest.newBuilder()
              .setResource(DataPolicyName.of("[PROJECT]", "[LOCATION]", "[DATA_POLICY]").toString())
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
    mockDataPolicyService.addResponse(expectedResponse);

    SetIamPolicyRequest request =
        SetIamPolicyRequest.newBuilder()
            .setResource(DataPolicyName.of("[PROJECT]", "[LOCATION]", "[DATA_POLICY]").toString())
            .setPolicy(Policy.newBuilder().build())
            .setUpdateMask(FieldMask.newBuilder().build())
            .build();

    Policy actualResponse = client.setIamPolicy(request);
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockDataPolicyService.getRequests();
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
    mockDataPolicyService.addException(exception);

    try {
      SetIamPolicyRequest request =
          SetIamPolicyRequest.newBuilder()
              .setResource(DataPolicyName.of("[PROJECT]", "[LOCATION]", "[DATA_POLICY]").toString())
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
    mockDataPolicyService.addResponse(expectedResponse);

    TestIamPermissionsRequest request =
        TestIamPermissionsRequest.newBuilder()
            .setResource(DataPolicyName.of("[PROJECT]", "[LOCATION]", "[DATA_POLICY]").toString())
            .addAllPermissions(new ArrayList<String>())
            .build();

    TestIamPermissionsResponse actualResponse = client.testIamPermissions(request);
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockDataPolicyService.getRequests();
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
    mockDataPolicyService.addException(exception);

    try {
      TestIamPermissionsRequest request =
          TestIamPermissionsRequest.newBuilder()
              .setResource(DataPolicyName.of("[PROJECT]", "[LOCATION]", "[DATA_POLICY]").toString())
              .addAllPermissions(new ArrayList<String>())
              .build();
      client.testIamPermissions(request);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }
}
