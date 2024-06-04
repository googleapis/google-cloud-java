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

package com.google.cloud.iap.v1;

import static com.google.cloud.iap.v1.IdentityAwareProxyAdminServiceClient.ListTunnelDestGroupsPagedResponse;

import com.google.api.gax.core.NoCredentialsProvider;
import com.google.api.gax.httpjson.GaxHttpJsonProperties;
import com.google.api.gax.httpjson.testing.MockHttpService;
import com.google.api.gax.rpc.ApiClientHeaderProvider;
import com.google.api.gax.rpc.ApiException;
import com.google.api.gax.rpc.ApiExceptionFactory;
import com.google.api.gax.rpc.InvalidArgumentException;
import com.google.api.gax.rpc.StatusCode;
import com.google.api.gax.rpc.testing.FakeStatusCode;
import com.google.cloud.iap.v1.stub.HttpJsonIdentityAwareProxyAdminServiceStub;
import com.google.common.collect.Lists;
import com.google.iam.v1.AuditConfig;
import com.google.iam.v1.Binding;
import com.google.iam.v1.GetIamPolicyRequest;
import com.google.iam.v1.GetPolicyOptions;
import com.google.iam.v1.Policy;
import com.google.iam.v1.SetIamPolicyRequest;
import com.google.iam.v1.TestIamPermissionsRequest;
import com.google.iam.v1.TestIamPermissionsResponse;
import com.google.protobuf.ByteString;
import com.google.protobuf.Empty;
import com.google.protobuf.FieldMask;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import javax.annotation.Generated;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Assert;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

@Generated("by gapic-generator-java")
public class IdentityAwareProxyAdminServiceClientHttpJsonTest {
  private static MockHttpService mockService;
  private static IdentityAwareProxyAdminServiceClient client;

  @BeforeClass
  public static void startStaticServer() throws IOException {
    mockService =
        new MockHttpService(
            HttpJsonIdentityAwareProxyAdminServiceStub.getMethodDescriptors(),
            IdentityAwareProxyAdminServiceSettings.getDefaultEndpoint());
    IdentityAwareProxyAdminServiceSettings settings =
        IdentityAwareProxyAdminServiceSettings.newHttpJsonBuilder()
            .setTransportChannelProvider(
                IdentityAwareProxyAdminServiceSettings.defaultHttpJsonTransportProviderBuilder()
                    .setHttpTransport(mockService)
                    .build())
            .setCredentialsProvider(NoCredentialsProvider.create())
            .build();
    client = IdentityAwareProxyAdminServiceClient.create(settings);
  }

  @AfterClass
  public static void stopServer() {
    client.close();
  }

  @Before
  public void setUp() {}

  @After
  public void tearDown() throws Exception {
    mockService.reset();
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
    mockService.addResponse(expectedResponse);

    SetIamPolicyRequest request =
        SetIamPolicyRequest.newBuilder()
            .setResource(
                TunnelDestGroupName.of("[PROJECT]", "[LOCATION]", "[DEST_GROUP]").toString())
            .setPolicy(Policy.newBuilder().build())
            .setUpdateMask(FieldMask.newBuilder().build())
            .build();

    Policy actualResponse = client.setIamPolicy(request);
    Assert.assertEquals(expectedResponse, actualResponse);

    List<String> actualRequests = mockService.getRequestPaths();
    Assert.assertEquals(1, actualRequests.size());

    String apiClientHeaderKey =
        mockService
            .getRequestHeaders()
            .get(ApiClientHeaderProvider.getDefaultApiClientHeaderKey())
            .iterator()
            .next();
    Assert.assertTrue(
        GaxHttpJsonProperties.getDefaultApiClientHeaderPattern()
            .matcher(apiClientHeaderKey)
            .matches());
  }

  @Test
  public void setIamPolicyExceptionTest() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

    try {
      SetIamPolicyRequest request =
          SetIamPolicyRequest.newBuilder()
              .setResource(
                  TunnelDestGroupName.of("[PROJECT]", "[LOCATION]", "[DEST_GROUP]").toString())
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
  public void getIamPolicyTest() throws Exception {
    Policy expectedResponse =
        Policy.newBuilder()
            .setVersion(351608024)
            .addAllBindings(new ArrayList<Binding>())
            .addAllAuditConfigs(new ArrayList<AuditConfig>())
            .setEtag(ByteString.EMPTY)
            .build();
    mockService.addResponse(expectedResponse);

    GetIamPolicyRequest request =
        GetIamPolicyRequest.newBuilder()
            .setResource(
                TunnelDestGroupName.of("[PROJECT]", "[LOCATION]", "[DEST_GROUP]").toString())
            .setOptions(GetPolicyOptions.newBuilder().build())
            .build();

    Policy actualResponse = client.getIamPolicy(request);
    Assert.assertEquals(expectedResponse, actualResponse);

    List<String> actualRequests = mockService.getRequestPaths();
    Assert.assertEquals(1, actualRequests.size());

    String apiClientHeaderKey =
        mockService
            .getRequestHeaders()
            .get(ApiClientHeaderProvider.getDefaultApiClientHeaderKey())
            .iterator()
            .next();
    Assert.assertTrue(
        GaxHttpJsonProperties.getDefaultApiClientHeaderPattern()
            .matcher(apiClientHeaderKey)
            .matches());
  }

  @Test
  public void getIamPolicyExceptionTest() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

    try {
      GetIamPolicyRequest request =
          GetIamPolicyRequest.newBuilder()
              .setResource(
                  TunnelDestGroupName.of("[PROJECT]", "[LOCATION]", "[DEST_GROUP]").toString())
              .setOptions(GetPolicyOptions.newBuilder().build())
              .build();
      client.getIamPolicy(request);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void testIamPermissionsTest() throws Exception {
    TestIamPermissionsResponse expectedResponse =
        TestIamPermissionsResponse.newBuilder().addAllPermissions(new ArrayList<String>()).build();
    mockService.addResponse(expectedResponse);

    TestIamPermissionsRequest request =
        TestIamPermissionsRequest.newBuilder()
            .setResource(
                TunnelDestGroupName.of("[PROJECT]", "[LOCATION]", "[DEST_GROUP]").toString())
            .addAllPermissions(new ArrayList<String>())
            .build();

    TestIamPermissionsResponse actualResponse = client.testIamPermissions(request);
    Assert.assertEquals(expectedResponse, actualResponse);

    List<String> actualRequests = mockService.getRequestPaths();
    Assert.assertEquals(1, actualRequests.size());

    String apiClientHeaderKey =
        mockService
            .getRequestHeaders()
            .get(ApiClientHeaderProvider.getDefaultApiClientHeaderKey())
            .iterator()
            .next();
    Assert.assertTrue(
        GaxHttpJsonProperties.getDefaultApiClientHeaderPattern()
            .matcher(apiClientHeaderKey)
            .matches());
  }

  @Test
  public void testIamPermissionsExceptionTest() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

    try {
      TestIamPermissionsRequest request =
          TestIamPermissionsRequest.newBuilder()
              .setResource(
                  TunnelDestGroupName.of("[PROJECT]", "[LOCATION]", "[DEST_GROUP]").toString())
              .addAllPermissions(new ArrayList<String>())
              .build();
      client.testIamPermissions(request);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void getIapSettingsTest() throws Exception {
    IapSettings expectedResponse =
        IapSettings.newBuilder()
            .setName("name3373707")
            .setAccessSettings(AccessSettings.newBuilder().build())
            .setApplicationSettings(ApplicationSettings.newBuilder().build())
            .build();
    mockService.addResponse(expectedResponse);

    GetIapSettingsRequest request = GetIapSettingsRequest.newBuilder().setName("name-3525").build();

    IapSettings actualResponse = client.getIapSettings(request);
    Assert.assertEquals(expectedResponse, actualResponse);

    List<String> actualRequests = mockService.getRequestPaths();
    Assert.assertEquals(1, actualRequests.size());

    String apiClientHeaderKey =
        mockService
            .getRequestHeaders()
            .get(ApiClientHeaderProvider.getDefaultApiClientHeaderKey())
            .iterator()
            .next();
    Assert.assertTrue(
        GaxHttpJsonProperties.getDefaultApiClientHeaderPattern()
            .matcher(apiClientHeaderKey)
            .matches());
  }

  @Test
  public void getIapSettingsExceptionTest() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

    try {
      GetIapSettingsRequest request =
          GetIapSettingsRequest.newBuilder().setName("name-3525").build();
      client.getIapSettings(request);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void updateIapSettingsTest() throws Exception {
    IapSettings expectedResponse =
        IapSettings.newBuilder()
            .setName("name3373707")
            .setAccessSettings(AccessSettings.newBuilder().build())
            .setApplicationSettings(ApplicationSettings.newBuilder().build())
            .build();
    mockService.addResponse(expectedResponse);

    UpdateIapSettingsRequest request =
        UpdateIapSettingsRequest.newBuilder()
            .setIapSettings(
                IapSettings.newBuilder()
                    .setName("name-3525")
                    .setAccessSettings(AccessSettings.newBuilder().build())
                    .setApplicationSettings(ApplicationSettings.newBuilder().build())
                    .build())
            .setUpdateMask(FieldMask.newBuilder().build())
            .build();

    IapSettings actualResponse = client.updateIapSettings(request);
    Assert.assertEquals(expectedResponse, actualResponse);

    List<String> actualRequests = mockService.getRequestPaths();
    Assert.assertEquals(1, actualRequests.size());

    String apiClientHeaderKey =
        mockService
            .getRequestHeaders()
            .get(ApiClientHeaderProvider.getDefaultApiClientHeaderKey())
            .iterator()
            .next();
    Assert.assertTrue(
        GaxHttpJsonProperties.getDefaultApiClientHeaderPattern()
            .matcher(apiClientHeaderKey)
            .matches());
  }

  @Test
  public void updateIapSettingsExceptionTest() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

    try {
      UpdateIapSettingsRequest request =
          UpdateIapSettingsRequest.newBuilder()
              .setIapSettings(
                  IapSettings.newBuilder()
                      .setName("name-3525")
                      .setAccessSettings(AccessSettings.newBuilder().build())
                      .setApplicationSettings(ApplicationSettings.newBuilder().build())
                      .build())
              .setUpdateMask(FieldMask.newBuilder().build())
              .build();
      client.updateIapSettings(request);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void listTunnelDestGroupsTest() throws Exception {
    TunnelDestGroup responsesElement = TunnelDestGroup.newBuilder().build();
    ListTunnelDestGroupsResponse expectedResponse =
        ListTunnelDestGroupsResponse.newBuilder()
            .setNextPageToken("")
            .addAllTunnelDestGroups(Arrays.asList(responsesElement))
            .build();
    mockService.addResponse(expectedResponse);

    TunnelLocationName parent = TunnelLocationName.of("[PROJECT]", "[LOCATION]");

    ListTunnelDestGroupsPagedResponse pagedListResponse = client.listTunnelDestGroups(parent);

    List<TunnelDestGroup> resources = Lists.newArrayList(pagedListResponse.iterateAll());

    Assert.assertEquals(1, resources.size());
    Assert.assertEquals(expectedResponse.getTunnelDestGroupsList().get(0), resources.get(0));

    List<String> actualRequests = mockService.getRequestPaths();
    Assert.assertEquals(1, actualRequests.size());

    String apiClientHeaderKey =
        mockService
            .getRequestHeaders()
            .get(ApiClientHeaderProvider.getDefaultApiClientHeaderKey())
            .iterator()
            .next();
    Assert.assertTrue(
        GaxHttpJsonProperties.getDefaultApiClientHeaderPattern()
            .matcher(apiClientHeaderKey)
            .matches());
  }

  @Test
  public void listTunnelDestGroupsExceptionTest() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

    try {
      TunnelLocationName parent = TunnelLocationName.of("[PROJECT]", "[LOCATION]");
      client.listTunnelDestGroups(parent);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void listTunnelDestGroupsTest2() throws Exception {
    TunnelDestGroup responsesElement = TunnelDestGroup.newBuilder().build();
    ListTunnelDestGroupsResponse expectedResponse =
        ListTunnelDestGroupsResponse.newBuilder()
            .setNextPageToken("")
            .addAllTunnelDestGroups(Arrays.asList(responsesElement))
            .build();
    mockService.addResponse(expectedResponse);

    String parent = "projects/project-4985/iap_tunnel/locations/location-4985";

    ListTunnelDestGroupsPagedResponse pagedListResponse = client.listTunnelDestGroups(parent);

    List<TunnelDestGroup> resources = Lists.newArrayList(pagedListResponse.iterateAll());

    Assert.assertEquals(1, resources.size());
    Assert.assertEquals(expectedResponse.getTunnelDestGroupsList().get(0), resources.get(0));

    List<String> actualRequests = mockService.getRequestPaths();
    Assert.assertEquals(1, actualRequests.size());

    String apiClientHeaderKey =
        mockService
            .getRequestHeaders()
            .get(ApiClientHeaderProvider.getDefaultApiClientHeaderKey())
            .iterator()
            .next();
    Assert.assertTrue(
        GaxHttpJsonProperties.getDefaultApiClientHeaderPattern()
            .matcher(apiClientHeaderKey)
            .matches());
  }

  @Test
  public void listTunnelDestGroupsExceptionTest2() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

    try {
      String parent = "projects/project-4985/iap_tunnel/locations/location-4985";
      client.listTunnelDestGroups(parent);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void createTunnelDestGroupTest() throws Exception {
    TunnelDestGroup expectedResponse =
        TunnelDestGroup.newBuilder()
            .setName(TunnelDestGroupName.of("[PROJECT]", "[LOCATION]", "[DEST_GROUP]").toString())
            .addAllCidrs(new ArrayList<String>())
            .addAllFqdns(new ArrayList<String>())
            .build();
    mockService.addResponse(expectedResponse);

    TunnelLocationName parent = TunnelLocationName.of("[PROJECT]", "[LOCATION]");
    TunnelDestGroup tunnelDestGroup = TunnelDestGroup.newBuilder().build();
    String tunnelDestGroupId = "tunnelDestGroupId-1240473232";

    TunnelDestGroup actualResponse =
        client.createTunnelDestGroup(parent, tunnelDestGroup, tunnelDestGroupId);
    Assert.assertEquals(expectedResponse, actualResponse);

    List<String> actualRequests = mockService.getRequestPaths();
    Assert.assertEquals(1, actualRequests.size());

    String apiClientHeaderKey =
        mockService
            .getRequestHeaders()
            .get(ApiClientHeaderProvider.getDefaultApiClientHeaderKey())
            .iterator()
            .next();
    Assert.assertTrue(
        GaxHttpJsonProperties.getDefaultApiClientHeaderPattern()
            .matcher(apiClientHeaderKey)
            .matches());
  }

  @Test
  public void createTunnelDestGroupExceptionTest() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

    try {
      TunnelLocationName parent = TunnelLocationName.of("[PROJECT]", "[LOCATION]");
      TunnelDestGroup tunnelDestGroup = TunnelDestGroup.newBuilder().build();
      String tunnelDestGroupId = "tunnelDestGroupId-1240473232";
      client.createTunnelDestGroup(parent, tunnelDestGroup, tunnelDestGroupId);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void createTunnelDestGroupTest2() throws Exception {
    TunnelDestGroup expectedResponse =
        TunnelDestGroup.newBuilder()
            .setName(TunnelDestGroupName.of("[PROJECT]", "[LOCATION]", "[DEST_GROUP]").toString())
            .addAllCidrs(new ArrayList<String>())
            .addAllFqdns(new ArrayList<String>())
            .build();
    mockService.addResponse(expectedResponse);

    String parent = "projects/project-4985/iap_tunnel/locations/location-4985";
    TunnelDestGroup tunnelDestGroup = TunnelDestGroup.newBuilder().build();
    String tunnelDestGroupId = "tunnelDestGroupId-1240473232";

    TunnelDestGroup actualResponse =
        client.createTunnelDestGroup(parent, tunnelDestGroup, tunnelDestGroupId);
    Assert.assertEquals(expectedResponse, actualResponse);

    List<String> actualRequests = mockService.getRequestPaths();
    Assert.assertEquals(1, actualRequests.size());

    String apiClientHeaderKey =
        mockService
            .getRequestHeaders()
            .get(ApiClientHeaderProvider.getDefaultApiClientHeaderKey())
            .iterator()
            .next();
    Assert.assertTrue(
        GaxHttpJsonProperties.getDefaultApiClientHeaderPattern()
            .matcher(apiClientHeaderKey)
            .matches());
  }

  @Test
  public void createTunnelDestGroupExceptionTest2() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

    try {
      String parent = "projects/project-4985/iap_tunnel/locations/location-4985";
      TunnelDestGroup tunnelDestGroup = TunnelDestGroup.newBuilder().build();
      String tunnelDestGroupId = "tunnelDestGroupId-1240473232";
      client.createTunnelDestGroup(parent, tunnelDestGroup, tunnelDestGroupId);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void getTunnelDestGroupTest() throws Exception {
    TunnelDestGroup expectedResponse =
        TunnelDestGroup.newBuilder()
            .setName(TunnelDestGroupName.of("[PROJECT]", "[LOCATION]", "[DEST_GROUP]").toString())
            .addAllCidrs(new ArrayList<String>())
            .addAllFqdns(new ArrayList<String>())
            .build();
    mockService.addResponse(expectedResponse);

    TunnelDestGroupName name = TunnelDestGroupName.of("[PROJECT]", "[LOCATION]", "[DEST_GROUP]");

    TunnelDestGroup actualResponse = client.getTunnelDestGroup(name);
    Assert.assertEquals(expectedResponse, actualResponse);

    List<String> actualRequests = mockService.getRequestPaths();
    Assert.assertEquals(1, actualRequests.size());

    String apiClientHeaderKey =
        mockService
            .getRequestHeaders()
            .get(ApiClientHeaderProvider.getDefaultApiClientHeaderKey())
            .iterator()
            .next();
    Assert.assertTrue(
        GaxHttpJsonProperties.getDefaultApiClientHeaderPattern()
            .matcher(apiClientHeaderKey)
            .matches());
  }

  @Test
  public void getTunnelDestGroupExceptionTest() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

    try {
      TunnelDestGroupName name = TunnelDestGroupName.of("[PROJECT]", "[LOCATION]", "[DEST_GROUP]");
      client.getTunnelDestGroup(name);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void getTunnelDestGroupTest2() throws Exception {
    TunnelDestGroup expectedResponse =
        TunnelDestGroup.newBuilder()
            .setName(TunnelDestGroupName.of("[PROJECT]", "[LOCATION]", "[DEST_GROUP]").toString())
            .addAllCidrs(new ArrayList<String>())
            .addAllFqdns(new ArrayList<String>())
            .build();
    mockService.addResponse(expectedResponse);

    String name =
        "projects/project-4008/iap_tunnel/locations/location-4008/destGroups/destGroup-4008";

    TunnelDestGroup actualResponse = client.getTunnelDestGroup(name);
    Assert.assertEquals(expectedResponse, actualResponse);

    List<String> actualRequests = mockService.getRequestPaths();
    Assert.assertEquals(1, actualRequests.size());

    String apiClientHeaderKey =
        mockService
            .getRequestHeaders()
            .get(ApiClientHeaderProvider.getDefaultApiClientHeaderKey())
            .iterator()
            .next();
    Assert.assertTrue(
        GaxHttpJsonProperties.getDefaultApiClientHeaderPattern()
            .matcher(apiClientHeaderKey)
            .matches());
  }

  @Test
  public void getTunnelDestGroupExceptionTest2() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

    try {
      String name =
          "projects/project-4008/iap_tunnel/locations/location-4008/destGroups/destGroup-4008";
      client.getTunnelDestGroup(name);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void deleteTunnelDestGroupTest() throws Exception {
    Empty expectedResponse = Empty.newBuilder().build();
    mockService.addResponse(expectedResponse);

    TunnelDestGroupName name = TunnelDestGroupName.of("[PROJECT]", "[LOCATION]", "[DEST_GROUP]");

    client.deleteTunnelDestGroup(name);

    List<String> actualRequests = mockService.getRequestPaths();
    Assert.assertEquals(1, actualRequests.size());

    String apiClientHeaderKey =
        mockService
            .getRequestHeaders()
            .get(ApiClientHeaderProvider.getDefaultApiClientHeaderKey())
            .iterator()
            .next();
    Assert.assertTrue(
        GaxHttpJsonProperties.getDefaultApiClientHeaderPattern()
            .matcher(apiClientHeaderKey)
            .matches());
  }

  @Test
  public void deleteTunnelDestGroupExceptionTest() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

    try {
      TunnelDestGroupName name = TunnelDestGroupName.of("[PROJECT]", "[LOCATION]", "[DEST_GROUP]");
      client.deleteTunnelDestGroup(name);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void deleteTunnelDestGroupTest2() throws Exception {
    Empty expectedResponse = Empty.newBuilder().build();
    mockService.addResponse(expectedResponse);

    String name =
        "projects/project-4008/iap_tunnel/locations/location-4008/destGroups/destGroup-4008";

    client.deleteTunnelDestGroup(name);

    List<String> actualRequests = mockService.getRequestPaths();
    Assert.assertEquals(1, actualRequests.size());

    String apiClientHeaderKey =
        mockService
            .getRequestHeaders()
            .get(ApiClientHeaderProvider.getDefaultApiClientHeaderKey())
            .iterator()
            .next();
    Assert.assertTrue(
        GaxHttpJsonProperties.getDefaultApiClientHeaderPattern()
            .matcher(apiClientHeaderKey)
            .matches());
  }

  @Test
  public void deleteTunnelDestGroupExceptionTest2() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

    try {
      String name =
          "projects/project-4008/iap_tunnel/locations/location-4008/destGroups/destGroup-4008";
      client.deleteTunnelDestGroup(name);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void updateTunnelDestGroupTest() throws Exception {
    TunnelDestGroup expectedResponse =
        TunnelDestGroup.newBuilder()
            .setName(TunnelDestGroupName.of("[PROJECT]", "[LOCATION]", "[DEST_GROUP]").toString())
            .addAllCidrs(new ArrayList<String>())
            .addAllFqdns(new ArrayList<String>())
            .build();
    mockService.addResponse(expectedResponse);

    TunnelDestGroup tunnelDestGroup =
        TunnelDestGroup.newBuilder()
            .setName(TunnelDestGroupName.of("[PROJECT]", "[LOCATION]", "[DEST_GROUP]").toString())
            .addAllCidrs(new ArrayList<String>())
            .addAllFqdns(new ArrayList<String>())
            .build();
    FieldMask updateMask = FieldMask.newBuilder().build();

    TunnelDestGroup actualResponse = client.updateTunnelDestGroup(tunnelDestGroup, updateMask);
    Assert.assertEquals(expectedResponse, actualResponse);

    List<String> actualRequests = mockService.getRequestPaths();
    Assert.assertEquals(1, actualRequests.size());

    String apiClientHeaderKey =
        mockService
            .getRequestHeaders()
            .get(ApiClientHeaderProvider.getDefaultApiClientHeaderKey())
            .iterator()
            .next();
    Assert.assertTrue(
        GaxHttpJsonProperties.getDefaultApiClientHeaderPattern()
            .matcher(apiClientHeaderKey)
            .matches());
  }

  @Test
  public void updateTunnelDestGroupExceptionTest() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

    try {
      TunnelDestGroup tunnelDestGroup =
          TunnelDestGroup.newBuilder()
              .setName(TunnelDestGroupName.of("[PROJECT]", "[LOCATION]", "[DEST_GROUP]").toString())
              .addAllCidrs(new ArrayList<String>())
              .addAllFqdns(new ArrayList<String>())
              .build();
      FieldMask updateMask = FieldMask.newBuilder().build();
      client.updateTunnelDestGroup(tunnelDestGroup, updateMask);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }
}
