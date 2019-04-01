/*
 * Copyright 2019 Google LLC
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     https://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package com.google.cloud.talent.v4beta1;

import static com.google.cloud.talent.v4beta1.TenantServiceClient.ListTenantsPagedResponse;

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
import io.grpc.Status;
import io.grpc.StatusRuntimeException;
import java.io.IOException;
import java.util.Arrays;
import java.util.List;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Assert;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

@javax.annotation.Generated("by GAPIC")
public class TenantServiceClientTest {
  private static MockApplicationService mockApplicationService;
  private static MockCompanyService mockCompanyService;
  private static MockCompletion mockCompletion;
  private static MockEventService mockEventService;
  private static MockJobService mockJobService;
  private static MockProfileService mockProfileService;
  private static MockTenantService mockTenantService;
  private static MockServiceHelper serviceHelper;
  private TenantServiceClient client;
  private LocalChannelProvider channelProvider;

  @BeforeClass
  public static void startStaticServer() {
    mockApplicationService = new MockApplicationService();
    mockCompanyService = new MockCompanyService();
    mockCompletion = new MockCompletion();
    mockEventService = new MockEventService();
    mockJobService = new MockJobService();
    mockProfileService = new MockProfileService();
    mockTenantService = new MockTenantService();
    serviceHelper =
        new MockServiceHelper(
            "in-process-1",
            Arrays.<MockGrpcService>asList(
                mockApplicationService,
                mockCompanyService,
                mockCompletion,
                mockEventService,
                mockJobService,
                mockProfileService,
                mockTenantService));
    serviceHelper.start();
  }

  @AfterClass
  public static void stopServer() {
    serviceHelper.stop();
  }

  @Before
  public void setUp() throws IOException {
    serviceHelper.reset();
    channelProvider = serviceHelper.createChannelProvider();
    TenantServiceSettings settings =
        TenantServiceSettings.newBuilder()
            .setTransportChannelProvider(channelProvider)
            .setCredentialsProvider(NoCredentialsProvider.create())
            .build();
    client = TenantServiceClient.create(settings);
  }

  @After
  public void tearDown() throws Exception {
    client.close();
  }

  @Test
  @SuppressWarnings("all")
  public void createTenantTest() {
    TenantName name = TenantName.of("[PROJECT]", "[TENANT]");
    String externalId = "externalId-1153075697";
    Tenant expectedResponse =
        Tenant.newBuilder().setName(name.toString()).setExternalId(externalId).build();
    mockTenantService.addResponse(expectedResponse);

    ProjectName parent = ProjectName.of("[PROJECT]");
    Tenant tenant = Tenant.newBuilder().build();

    Tenant actualResponse = client.createTenant(parent, tenant);
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockTenantService.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    CreateTenantRequest actualRequest = (CreateTenantRequest) actualRequests.get(0);

    Assert.assertEquals(parent, ProjectName.parse(actualRequest.getParent()));
    Assert.assertEquals(tenant, actualRequest.getTenant());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  @SuppressWarnings("all")
  public void createTenantExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(Status.INVALID_ARGUMENT);
    mockTenantService.addException(exception);

    try {
      ProjectName parent = ProjectName.of("[PROJECT]");
      Tenant tenant = Tenant.newBuilder().build();

      client.createTenant(parent, tenant);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception
    }
  }

  @Test
  @SuppressWarnings("all")
  public void getTenantTest() {
    TenantName name2 = TenantName.of("[PROJECT]", "[TENANT]");
    String externalId = "externalId-1153075697";
    Tenant expectedResponse =
        Tenant.newBuilder().setName(name2.toString()).setExternalId(externalId).build();
    mockTenantService.addResponse(expectedResponse);

    TenantName name = TenantName.of("[PROJECT]", "[TENANT]");

    Tenant actualResponse = client.getTenant(name);
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockTenantService.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    GetTenantRequest actualRequest = (GetTenantRequest) actualRequests.get(0);

    Assert.assertEquals(name, TenantName.parse(actualRequest.getName()));
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  @SuppressWarnings("all")
  public void getTenantExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(Status.INVALID_ARGUMENT);
    mockTenantService.addException(exception);

    try {
      TenantName name = TenantName.of("[PROJECT]", "[TENANT]");

      client.getTenant(name);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception
    }
  }

  @Test
  @SuppressWarnings("all")
  public void updateTenantTest() {
    TenantName name = TenantName.of("[PROJECT]", "[TENANT]");
    String externalId = "externalId-1153075697";
    Tenant expectedResponse =
        Tenant.newBuilder().setName(name.toString()).setExternalId(externalId).build();
    mockTenantService.addResponse(expectedResponse);

    Tenant tenant = Tenant.newBuilder().build();

    Tenant actualResponse = client.updateTenant(tenant);
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockTenantService.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    UpdateTenantRequest actualRequest = (UpdateTenantRequest) actualRequests.get(0);

    Assert.assertEquals(tenant, actualRequest.getTenant());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  @SuppressWarnings("all")
  public void updateTenantExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(Status.INVALID_ARGUMENT);
    mockTenantService.addException(exception);

    try {
      Tenant tenant = Tenant.newBuilder().build();

      client.updateTenant(tenant);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception
    }
  }

  @Test
  @SuppressWarnings("all")
  public void deleteTenantTest() {
    Empty expectedResponse = Empty.newBuilder().build();
    mockTenantService.addResponse(expectedResponse);

    TenantName name = TenantName.of("[PROJECT]", "[TENANT]");

    client.deleteTenant(name);

    List<AbstractMessage> actualRequests = mockTenantService.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    DeleteTenantRequest actualRequest = (DeleteTenantRequest) actualRequests.get(0);

    Assert.assertEquals(name, TenantName.parse(actualRequest.getName()));
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  @SuppressWarnings("all")
  public void deleteTenantExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(Status.INVALID_ARGUMENT);
    mockTenantService.addException(exception);

    try {
      TenantName name = TenantName.of("[PROJECT]", "[TENANT]");

      client.deleteTenant(name);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception
    }
  }

  @Test
  @SuppressWarnings("all")
  public void listTenantsTest() {
    String nextPageToken = "";
    Tenant tenantsElement = Tenant.newBuilder().build();
    List<Tenant> tenants = Arrays.asList(tenantsElement);
    ListTenantsResponse expectedResponse =
        ListTenantsResponse.newBuilder()
            .setNextPageToken(nextPageToken)
            .addAllTenants(tenants)
            .build();
    mockTenantService.addResponse(expectedResponse);

    ProjectName parent = ProjectName.of("[PROJECT]");

    ListTenantsPagedResponse pagedListResponse = client.listTenants(parent);

    List<Tenant> resources = Lists.newArrayList(pagedListResponse.iterateAll());
    Assert.assertEquals(1, resources.size());
    Assert.assertEquals(expectedResponse.getTenantsList().get(0), resources.get(0));

    List<AbstractMessage> actualRequests = mockTenantService.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    ListTenantsRequest actualRequest = (ListTenantsRequest) actualRequests.get(0);

    Assert.assertEquals(parent, ProjectName.parse(actualRequest.getParent()));
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  @SuppressWarnings("all")
  public void listTenantsExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(Status.INVALID_ARGUMENT);
    mockTenantService.addException(exception);

    try {
      ProjectName parent = ProjectName.of("[PROJECT]");

      client.listTenants(parent);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception
    }
  }
}
