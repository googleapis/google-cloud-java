/*
 * Copyright 2020 Google LLC
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
public class TenantServiceClientTest {
  private static MockServiceHelper mockServiceHelper;
  private static MockTenantService mockTenantService;
  private TenantServiceClient client;
  private LocalChannelProvider channelProvider;

  @BeforeClass
  public static void startStaticServer() {
    mockTenantService = new MockTenantService();
    mockServiceHelper =
        new MockServiceHelper(
            UUID.randomUUID().toString(), Arrays.<MockGrpcService>asList(mockTenantService));
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
  public void createTenantTest() throws Exception {
    Tenant expectedResponse =
        Tenant.newBuilder()
            .setName(TenantName.of("[PROJECT]", "[TENANT]").toString())
            .setExternalId("externalId-1699764666")
            .addAllKeywordSearchableProfileCustomAttributes(new ArrayList<String>())
            .build();
    mockTenantService.addResponse(expectedResponse);

    ProjectName parent = ProjectName.of("[PROJECT]");
    Tenant tenant = Tenant.newBuilder().build();

    Tenant actualResponse = client.createTenant(parent, tenant);
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockTenantService.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    CreateTenantRequest actualRequest = ((CreateTenantRequest) actualRequests.get(0));

    Assert.assertEquals(parent.toString(), actualRequest.getParent());
    Assert.assertEquals(tenant, actualRequest.getTenant());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void createTenantExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockTenantService.addException(exception);

    try {
      ProjectName parent = ProjectName.of("[PROJECT]");
      Tenant tenant = Tenant.newBuilder().build();
      client.createTenant(parent, tenant);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void createTenantTest2() throws Exception {
    Tenant expectedResponse =
        Tenant.newBuilder()
            .setName(TenantName.of("[PROJECT]", "[TENANT]").toString())
            .setExternalId("externalId-1699764666")
            .addAllKeywordSearchableProfileCustomAttributes(new ArrayList<String>())
            .build();
    mockTenantService.addResponse(expectedResponse);

    String parent = "parent-995424086";
    Tenant tenant = Tenant.newBuilder().build();

    Tenant actualResponse = client.createTenant(parent, tenant);
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockTenantService.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    CreateTenantRequest actualRequest = ((CreateTenantRequest) actualRequests.get(0));

    Assert.assertEquals(parent, actualRequest.getParent());
    Assert.assertEquals(tenant, actualRequest.getTenant());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void createTenantExceptionTest2() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockTenantService.addException(exception);

    try {
      String parent = "parent-995424086";
      Tenant tenant = Tenant.newBuilder().build();
      client.createTenant(parent, tenant);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void getTenantTest() throws Exception {
    Tenant expectedResponse =
        Tenant.newBuilder()
            .setName(TenantName.of("[PROJECT]", "[TENANT]").toString())
            .setExternalId("externalId-1699764666")
            .addAllKeywordSearchableProfileCustomAttributes(new ArrayList<String>())
            .build();
    mockTenantService.addResponse(expectedResponse);

    TenantName name = TenantName.of("[PROJECT]", "[TENANT]");

    Tenant actualResponse = client.getTenant(name);
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockTenantService.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    GetTenantRequest actualRequest = ((GetTenantRequest) actualRequests.get(0));

    Assert.assertEquals(name.toString(), actualRequest.getName());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void getTenantExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockTenantService.addException(exception);

    try {
      TenantName name = TenantName.of("[PROJECT]", "[TENANT]");
      client.getTenant(name);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void getTenantTest2() throws Exception {
    Tenant expectedResponse =
        Tenant.newBuilder()
            .setName(TenantName.of("[PROJECT]", "[TENANT]").toString())
            .setExternalId("externalId-1699764666")
            .addAllKeywordSearchableProfileCustomAttributes(new ArrayList<String>())
            .build();
    mockTenantService.addResponse(expectedResponse);

    String name = "name3373707";

    Tenant actualResponse = client.getTenant(name);
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockTenantService.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    GetTenantRequest actualRequest = ((GetTenantRequest) actualRequests.get(0));

    Assert.assertEquals(name, actualRequest.getName());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void getTenantExceptionTest2() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockTenantService.addException(exception);

    try {
      String name = "name3373707";
      client.getTenant(name);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void updateTenantTest() throws Exception {
    Tenant expectedResponse =
        Tenant.newBuilder()
            .setName(TenantName.of("[PROJECT]", "[TENANT]").toString())
            .setExternalId("externalId-1699764666")
            .addAllKeywordSearchableProfileCustomAttributes(new ArrayList<String>())
            .build();
    mockTenantService.addResponse(expectedResponse);

    Tenant tenant = Tenant.newBuilder().build();

    Tenant actualResponse = client.updateTenant(tenant);
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockTenantService.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    UpdateTenantRequest actualRequest = ((UpdateTenantRequest) actualRequests.get(0));

    Assert.assertEquals(tenant, actualRequest.getTenant());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void updateTenantExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockTenantService.addException(exception);

    try {
      Tenant tenant = Tenant.newBuilder().build();
      client.updateTenant(tenant);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void deleteTenantTest() throws Exception {
    Empty expectedResponse = Empty.newBuilder().build();
    mockTenantService.addResponse(expectedResponse);

    TenantName name = TenantName.of("[PROJECT]", "[TENANT]");

    client.deleteTenant(name);

    List<AbstractMessage> actualRequests = mockTenantService.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    DeleteTenantRequest actualRequest = ((DeleteTenantRequest) actualRequests.get(0));

    Assert.assertEquals(name.toString(), actualRequest.getName());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void deleteTenantExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockTenantService.addException(exception);

    try {
      TenantName name = TenantName.of("[PROJECT]", "[TENANT]");
      client.deleteTenant(name);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void deleteTenantTest2() throws Exception {
    Empty expectedResponse = Empty.newBuilder().build();
    mockTenantService.addResponse(expectedResponse);

    String name = "name3373707";

    client.deleteTenant(name);

    List<AbstractMessage> actualRequests = mockTenantService.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    DeleteTenantRequest actualRequest = ((DeleteTenantRequest) actualRequests.get(0));

    Assert.assertEquals(name, actualRequest.getName());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void deleteTenantExceptionTest2() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockTenantService.addException(exception);

    try {
      String name = "name3373707";
      client.deleteTenant(name);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void listTenantsTest() throws Exception {
    Tenant responsesElement = Tenant.newBuilder().build();
    ListTenantsResponse expectedResponse =
        ListTenantsResponse.newBuilder()
            .setNextPageToken("")
            .addAllTenants(Arrays.asList(responsesElement))
            .build();
    mockTenantService.addResponse(expectedResponse);

    ProjectName parent = ProjectName.of("[PROJECT]");

    ListTenantsPagedResponse pagedListResponse = client.listTenants(parent);

    List<Tenant> resources = Lists.newArrayList(pagedListResponse.iterateAll());

    Assert.assertEquals(1, resources.size());
    Assert.assertEquals(expectedResponse.getTenantsList().get(0), resources.get(0));

    List<AbstractMessage> actualRequests = mockTenantService.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    ListTenantsRequest actualRequest = ((ListTenantsRequest) actualRequests.get(0));

    Assert.assertEquals(parent.toString(), actualRequest.getParent());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void listTenantsExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockTenantService.addException(exception);

    try {
      ProjectName parent = ProjectName.of("[PROJECT]");
      client.listTenants(parent);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void listTenantsTest2() throws Exception {
    Tenant responsesElement = Tenant.newBuilder().build();
    ListTenantsResponse expectedResponse =
        ListTenantsResponse.newBuilder()
            .setNextPageToken("")
            .addAllTenants(Arrays.asList(responsesElement))
            .build();
    mockTenantService.addResponse(expectedResponse);

    String parent = "parent-995424086";

    ListTenantsPagedResponse pagedListResponse = client.listTenants(parent);

    List<Tenant> resources = Lists.newArrayList(pagedListResponse.iterateAll());

    Assert.assertEquals(1, resources.size());
    Assert.assertEquals(expectedResponse.getTenantsList().get(0), resources.get(0));

    List<AbstractMessage> actualRequests = mockTenantService.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    ListTenantsRequest actualRequest = ((ListTenantsRequest) actualRequests.get(0));

    Assert.assertEquals(parent, actualRequest.getParent());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void listTenantsExceptionTest2() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockTenantService.addException(exception);

    try {
      String parent = "parent-995424086";
      client.listTenants(parent);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }
}
