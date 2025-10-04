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

package com.google.cloud.saasplatform.saasservicemgmt.v1beta1;

import static com.google.cloud.saasplatform.saasservicemgmt.v1beta1.SaasDeploymentsClient.ListLocationsPagedResponse;
import static com.google.cloud.saasplatform.saasservicemgmt.v1beta1.SaasDeploymentsClient.ListReleasesPagedResponse;
import static com.google.cloud.saasplatform.saasservicemgmt.v1beta1.SaasDeploymentsClient.ListSaasPagedResponse;
import static com.google.cloud.saasplatform.saasservicemgmt.v1beta1.SaasDeploymentsClient.ListTenantsPagedResponse;
import static com.google.cloud.saasplatform.saasservicemgmt.v1beta1.SaasDeploymentsClient.ListUnitKindsPagedResponse;
import static com.google.cloud.saasplatform.saasservicemgmt.v1beta1.SaasDeploymentsClient.ListUnitOperationsPagedResponse;
import static com.google.cloud.saasplatform.saasservicemgmt.v1beta1.SaasDeploymentsClient.ListUnitsPagedResponse;

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
public class SaasDeploymentsClientTest {
  private static MockLocations mockLocations;
  private static MockSaasDeployments mockSaasDeployments;
  private static MockServiceHelper mockServiceHelper;
  private LocalChannelProvider channelProvider;
  private SaasDeploymentsClient client;

  @BeforeClass
  public static void startStaticServer() {
    mockSaasDeployments = new MockSaasDeployments();
    mockLocations = new MockLocations();
    mockServiceHelper =
        new MockServiceHelper(
            UUID.randomUUID().toString(),
            Arrays.<MockGrpcService>asList(mockSaasDeployments, mockLocations));
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
    SaasDeploymentsSettings settings =
        SaasDeploymentsSettings.newBuilder()
            .setTransportChannelProvider(channelProvider)
            .setCredentialsProvider(NoCredentialsProvider.create())
            .build();
    client = SaasDeploymentsClient.create(settings);
  }

  @After
  public void tearDown() throws Exception {
    client.close();
  }

  @Test
  public void listSaasTest() throws Exception {
    Saas responsesElement = Saas.newBuilder().build();
    ListSaasResponse expectedResponse =
        ListSaasResponse.newBuilder()
            .setNextPageToken("")
            .addAllSaas(Arrays.asList(responsesElement))
            .build();
    mockSaasDeployments.addResponse(expectedResponse);

    LocationName parent = LocationName.of("[PROJECT]", "[LOCATION]");

    ListSaasPagedResponse pagedListResponse = client.listSaas(parent);

    List<Saas> resources = Lists.newArrayList(pagedListResponse.iterateAll());

    Assert.assertEquals(1, resources.size());
    Assert.assertEquals(expectedResponse.getSaasList().get(0), resources.get(0));

    List<AbstractMessage> actualRequests = mockSaasDeployments.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    ListSaasRequest actualRequest = ((ListSaasRequest) actualRequests.get(0));

    Assert.assertEquals(parent.toString(), actualRequest.getParent());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void listSaasExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockSaasDeployments.addException(exception);

    try {
      LocationName parent = LocationName.of("[PROJECT]", "[LOCATION]");
      client.listSaas(parent);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void listSaasTest2() throws Exception {
    Saas responsesElement = Saas.newBuilder().build();
    ListSaasResponse expectedResponse =
        ListSaasResponse.newBuilder()
            .setNextPageToken("")
            .addAllSaas(Arrays.asList(responsesElement))
            .build();
    mockSaasDeployments.addResponse(expectedResponse);

    String parent = "parent-995424086";

    ListSaasPagedResponse pagedListResponse = client.listSaas(parent);

    List<Saas> resources = Lists.newArrayList(pagedListResponse.iterateAll());

    Assert.assertEquals(1, resources.size());
    Assert.assertEquals(expectedResponse.getSaasList().get(0), resources.get(0));

    List<AbstractMessage> actualRequests = mockSaasDeployments.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    ListSaasRequest actualRequest = ((ListSaasRequest) actualRequests.get(0));

    Assert.assertEquals(parent, actualRequest.getParent());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void listSaasExceptionTest2() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockSaasDeployments.addException(exception);

    try {
      String parent = "parent-995424086";
      client.listSaas(parent);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void getSaasTest() throws Exception {
    Saas expectedResponse =
        Saas.newBuilder()
            .setName(SaasName.of("[PROJECT]", "[LOCATION]", "[SAAS]").toString())
            .addAllLocations(
                new ArrayList<com.google.cloud.saasplatform.saasservicemgmt.v1beta1.Location>())
            .putAllLabels(new HashMap<String, String>())
            .putAllAnnotations(new HashMap<String, String>())
            .setUid("uid115792")
            .setEtag("etag3123477")
            .setCreateTime(Timestamp.newBuilder().build())
            .setUpdateTime(Timestamp.newBuilder().build())
            .build();
    mockSaasDeployments.addResponse(expectedResponse);

    SaasName name = SaasName.of("[PROJECT]", "[LOCATION]", "[SAAS]");

    Saas actualResponse = client.getSaas(name);
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockSaasDeployments.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    GetSaasRequest actualRequest = ((GetSaasRequest) actualRequests.get(0));

    Assert.assertEquals(name.toString(), actualRequest.getName());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void getSaasExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockSaasDeployments.addException(exception);

    try {
      SaasName name = SaasName.of("[PROJECT]", "[LOCATION]", "[SAAS]");
      client.getSaas(name);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void getSaasTest2() throws Exception {
    Saas expectedResponse =
        Saas.newBuilder()
            .setName(SaasName.of("[PROJECT]", "[LOCATION]", "[SAAS]").toString())
            .addAllLocations(
                new ArrayList<com.google.cloud.saasplatform.saasservicemgmt.v1beta1.Location>())
            .putAllLabels(new HashMap<String, String>())
            .putAllAnnotations(new HashMap<String, String>())
            .setUid("uid115792")
            .setEtag("etag3123477")
            .setCreateTime(Timestamp.newBuilder().build())
            .setUpdateTime(Timestamp.newBuilder().build())
            .build();
    mockSaasDeployments.addResponse(expectedResponse);

    String name = "name3373707";

    Saas actualResponse = client.getSaas(name);
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockSaasDeployments.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    GetSaasRequest actualRequest = ((GetSaasRequest) actualRequests.get(0));

    Assert.assertEquals(name, actualRequest.getName());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void getSaasExceptionTest2() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockSaasDeployments.addException(exception);

    try {
      String name = "name3373707";
      client.getSaas(name);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void createSaasTest() throws Exception {
    Saas expectedResponse =
        Saas.newBuilder()
            .setName(SaasName.of("[PROJECT]", "[LOCATION]", "[SAAS]").toString())
            .addAllLocations(
                new ArrayList<com.google.cloud.saasplatform.saasservicemgmt.v1beta1.Location>())
            .putAllLabels(new HashMap<String, String>())
            .putAllAnnotations(new HashMap<String, String>())
            .setUid("uid115792")
            .setEtag("etag3123477")
            .setCreateTime(Timestamp.newBuilder().build())
            .setUpdateTime(Timestamp.newBuilder().build())
            .build();
    mockSaasDeployments.addResponse(expectedResponse);

    LocationName parent = LocationName.of("[PROJECT]", "[LOCATION]");
    Saas saas = Saas.newBuilder().build();
    String saasId = "saasId-910030789";

    Saas actualResponse = client.createSaas(parent, saas, saasId);
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockSaasDeployments.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    CreateSaasRequest actualRequest = ((CreateSaasRequest) actualRequests.get(0));

    Assert.assertEquals(parent.toString(), actualRequest.getParent());
    Assert.assertEquals(saas, actualRequest.getSaas());
    Assert.assertEquals(saasId, actualRequest.getSaasId());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void createSaasExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockSaasDeployments.addException(exception);

    try {
      LocationName parent = LocationName.of("[PROJECT]", "[LOCATION]");
      Saas saas = Saas.newBuilder().build();
      String saasId = "saasId-910030789";
      client.createSaas(parent, saas, saasId);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void createSaasTest2() throws Exception {
    Saas expectedResponse =
        Saas.newBuilder()
            .setName(SaasName.of("[PROJECT]", "[LOCATION]", "[SAAS]").toString())
            .addAllLocations(
                new ArrayList<com.google.cloud.saasplatform.saasservicemgmt.v1beta1.Location>())
            .putAllLabels(new HashMap<String, String>())
            .putAllAnnotations(new HashMap<String, String>())
            .setUid("uid115792")
            .setEtag("etag3123477")
            .setCreateTime(Timestamp.newBuilder().build())
            .setUpdateTime(Timestamp.newBuilder().build())
            .build();
    mockSaasDeployments.addResponse(expectedResponse);

    String parent = "parent-995424086";
    Saas saas = Saas.newBuilder().build();
    String saasId = "saasId-910030789";

    Saas actualResponse = client.createSaas(parent, saas, saasId);
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockSaasDeployments.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    CreateSaasRequest actualRequest = ((CreateSaasRequest) actualRequests.get(0));

    Assert.assertEquals(parent, actualRequest.getParent());
    Assert.assertEquals(saas, actualRequest.getSaas());
    Assert.assertEquals(saasId, actualRequest.getSaasId());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void createSaasExceptionTest2() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockSaasDeployments.addException(exception);

    try {
      String parent = "parent-995424086";
      Saas saas = Saas.newBuilder().build();
      String saasId = "saasId-910030789";
      client.createSaas(parent, saas, saasId);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void updateSaasTest() throws Exception {
    Saas expectedResponse =
        Saas.newBuilder()
            .setName(SaasName.of("[PROJECT]", "[LOCATION]", "[SAAS]").toString())
            .addAllLocations(
                new ArrayList<com.google.cloud.saasplatform.saasservicemgmt.v1beta1.Location>())
            .putAllLabels(new HashMap<String, String>())
            .putAllAnnotations(new HashMap<String, String>())
            .setUid("uid115792")
            .setEtag("etag3123477")
            .setCreateTime(Timestamp.newBuilder().build())
            .setUpdateTime(Timestamp.newBuilder().build())
            .build();
    mockSaasDeployments.addResponse(expectedResponse);

    Saas saas = Saas.newBuilder().build();
    FieldMask updateMask = FieldMask.newBuilder().build();

    Saas actualResponse = client.updateSaas(saas, updateMask);
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockSaasDeployments.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    UpdateSaasRequest actualRequest = ((UpdateSaasRequest) actualRequests.get(0));

    Assert.assertEquals(saas, actualRequest.getSaas());
    Assert.assertEquals(updateMask, actualRequest.getUpdateMask());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void updateSaasExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockSaasDeployments.addException(exception);

    try {
      Saas saas = Saas.newBuilder().build();
      FieldMask updateMask = FieldMask.newBuilder().build();
      client.updateSaas(saas, updateMask);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void deleteSaasTest() throws Exception {
    Empty expectedResponse = Empty.newBuilder().build();
    mockSaasDeployments.addResponse(expectedResponse);

    SaasName name = SaasName.of("[PROJECT]", "[LOCATION]", "[SAAS]");

    client.deleteSaas(name);

    List<AbstractMessage> actualRequests = mockSaasDeployments.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    DeleteSaasRequest actualRequest = ((DeleteSaasRequest) actualRequests.get(0));

    Assert.assertEquals(name.toString(), actualRequest.getName());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void deleteSaasExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockSaasDeployments.addException(exception);

    try {
      SaasName name = SaasName.of("[PROJECT]", "[LOCATION]", "[SAAS]");
      client.deleteSaas(name);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void deleteSaasTest2() throws Exception {
    Empty expectedResponse = Empty.newBuilder().build();
    mockSaasDeployments.addResponse(expectedResponse);

    String name = "name3373707";

    client.deleteSaas(name);

    List<AbstractMessage> actualRequests = mockSaasDeployments.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    DeleteSaasRequest actualRequest = ((DeleteSaasRequest) actualRequests.get(0));

    Assert.assertEquals(name, actualRequest.getName());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void deleteSaasExceptionTest2() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockSaasDeployments.addException(exception);

    try {
      String name = "name3373707";
      client.deleteSaas(name);
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
    mockSaasDeployments.addResponse(expectedResponse);

    LocationName parent = LocationName.of("[PROJECT]", "[LOCATION]");

    ListTenantsPagedResponse pagedListResponse = client.listTenants(parent);

    List<Tenant> resources = Lists.newArrayList(pagedListResponse.iterateAll());

    Assert.assertEquals(1, resources.size());
    Assert.assertEquals(expectedResponse.getTenantsList().get(0), resources.get(0));

    List<AbstractMessage> actualRequests = mockSaasDeployments.getRequests();
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
    mockSaasDeployments.addException(exception);

    try {
      LocationName parent = LocationName.of("[PROJECT]", "[LOCATION]");
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
    mockSaasDeployments.addResponse(expectedResponse);

    String parent = "parent-995424086";

    ListTenantsPagedResponse pagedListResponse = client.listTenants(parent);

    List<Tenant> resources = Lists.newArrayList(pagedListResponse.iterateAll());

    Assert.assertEquals(1, resources.size());
    Assert.assertEquals(expectedResponse.getTenantsList().get(0), resources.get(0));

    List<AbstractMessage> actualRequests = mockSaasDeployments.getRequests();
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
    mockSaasDeployments.addException(exception);

    try {
      String parent = "parent-995424086";
      client.listTenants(parent);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void getTenantTest() throws Exception {
    Tenant expectedResponse =
        Tenant.newBuilder()
            .setName(TenantName.of("[PROJECT]", "[LOCATION]", "[TENANT]").toString())
            .setConsumerResource("consumerResource-1539418588")
            .setSaas(SaasName.of("[PROJECT]", "[LOCATION]", "[SAAS]").toString())
            .putAllLabels(new HashMap<String, String>())
            .putAllAnnotations(new HashMap<String, String>())
            .setUid("uid115792")
            .setEtag("etag3123477")
            .setCreateTime(Timestamp.newBuilder().build())
            .setUpdateTime(Timestamp.newBuilder().build())
            .build();
    mockSaasDeployments.addResponse(expectedResponse);

    TenantName name = TenantName.of("[PROJECT]", "[LOCATION]", "[TENANT]");

    Tenant actualResponse = client.getTenant(name);
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockSaasDeployments.getRequests();
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
    mockSaasDeployments.addException(exception);

    try {
      TenantName name = TenantName.of("[PROJECT]", "[LOCATION]", "[TENANT]");
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
            .setName(TenantName.of("[PROJECT]", "[LOCATION]", "[TENANT]").toString())
            .setConsumerResource("consumerResource-1539418588")
            .setSaas(SaasName.of("[PROJECT]", "[LOCATION]", "[SAAS]").toString())
            .putAllLabels(new HashMap<String, String>())
            .putAllAnnotations(new HashMap<String, String>())
            .setUid("uid115792")
            .setEtag("etag3123477")
            .setCreateTime(Timestamp.newBuilder().build())
            .setUpdateTime(Timestamp.newBuilder().build())
            .build();
    mockSaasDeployments.addResponse(expectedResponse);

    String name = "name3373707";

    Tenant actualResponse = client.getTenant(name);
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockSaasDeployments.getRequests();
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
    mockSaasDeployments.addException(exception);

    try {
      String name = "name3373707";
      client.getTenant(name);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void createTenantTest() throws Exception {
    Tenant expectedResponse =
        Tenant.newBuilder()
            .setName(TenantName.of("[PROJECT]", "[LOCATION]", "[TENANT]").toString())
            .setConsumerResource("consumerResource-1539418588")
            .setSaas(SaasName.of("[PROJECT]", "[LOCATION]", "[SAAS]").toString())
            .putAllLabels(new HashMap<String, String>())
            .putAllAnnotations(new HashMap<String, String>())
            .setUid("uid115792")
            .setEtag("etag3123477")
            .setCreateTime(Timestamp.newBuilder().build())
            .setUpdateTime(Timestamp.newBuilder().build())
            .build();
    mockSaasDeployments.addResponse(expectedResponse);

    LocationName parent = LocationName.of("[PROJECT]", "[LOCATION]");
    Tenant tenant = Tenant.newBuilder().build();
    String tenantId = "tenantId-1306693787";

    Tenant actualResponse = client.createTenant(parent, tenant, tenantId);
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockSaasDeployments.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    CreateTenantRequest actualRequest = ((CreateTenantRequest) actualRequests.get(0));

    Assert.assertEquals(parent.toString(), actualRequest.getParent());
    Assert.assertEquals(tenant, actualRequest.getTenant());
    Assert.assertEquals(tenantId, actualRequest.getTenantId());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void createTenantExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockSaasDeployments.addException(exception);

    try {
      LocationName parent = LocationName.of("[PROJECT]", "[LOCATION]");
      Tenant tenant = Tenant.newBuilder().build();
      String tenantId = "tenantId-1306693787";
      client.createTenant(parent, tenant, tenantId);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void createTenantTest2() throws Exception {
    Tenant expectedResponse =
        Tenant.newBuilder()
            .setName(TenantName.of("[PROJECT]", "[LOCATION]", "[TENANT]").toString())
            .setConsumerResource("consumerResource-1539418588")
            .setSaas(SaasName.of("[PROJECT]", "[LOCATION]", "[SAAS]").toString())
            .putAllLabels(new HashMap<String, String>())
            .putAllAnnotations(new HashMap<String, String>())
            .setUid("uid115792")
            .setEtag("etag3123477")
            .setCreateTime(Timestamp.newBuilder().build())
            .setUpdateTime(Timestamp.newBuilder().build())
            .build();
    mockSaasDeployments.addResponse(expectedResponse);

    String parent = "parent-995424086";
    Tenant tenant = Tenant.newBuilder().build();
    String tenantId = "tenantId-1306693787";

    Tenant actualResponse = client.createTenant(parent, tenant, tenantId);
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockSaasDeployments.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    CreateTenantRequest actualRequest = ((CreateTenantRequest) actualRequests.get(0));

    Assert.assertEquals(parent, actualRequest.getParent());
    Assert.assertEquals(tenant, actualRequest.getTenant());
    Assert.assertEquals(tenantId, actualRequest.getTenantId());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void createTenantExceptionTest2() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockSaasDeployments.addException(exception);

    try {
      String parent = "parent-995424086";
      Tenant tenant = Tenant.newBuilder().build();
      String tenantId = "tenantId-1306693787";
      client.createTenant(parent, tenant, tenantId);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void updateTenantTest() throws Exception {
    Tenant expectedResponse =
        Tenant.newBuilder()
            .setName(TenantName.of("[PROJECT]", "[LOCATION]", "[TENANT]").toString())
            .setConsumerResource("consumerResource-1539418588")
            .setSaas(SaasName.of("[PROJECT]", "[LOCATION]", "[SAAS]").toString())
            .putAllLabels(new HashMap<String, String>())
            .putAllAnnotations(new HashMap<String, String>())
            .setUid("uid115792")
            .setEtag("etag3123477")
            .setCreateTime(Timestamp.newBuilder().build())
            .setUpdateTime(Timestamp.newBuilder().build())
            .build();
    mockSaasDeployments.addResponse(expectedResponse);

    Tenant tenant = Tenant.newBuilder().build();
    FieldMask updateMask = FieldMask.newBuilder().build();

    Tenant actualResponse = client.updateTenant(tenant, updateMask);
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockSaasDeployments.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    UpdateTenantRequest actualRequest = ((UpdateTenantRequest) actualRequests.get(0));

    Assert.assertEquals(tenant, actualRequest.getTenant());
    Assert.assertEquals(updateMask, actualRequest.getUpdateMask());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void updateTenantExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockSaasDeployments.addException(exception);

    try {
      Tenant tenant = Tenant.newBuilder().build();
      FieldMask updateMask = FieldMask.newBuilder().build();
      client.updateTenant(tenant, updateMask);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void deleteTenantTest() throws Exception {
    Empty expectedResponse = Empty.newBuilder().build();
    mockSaasDeployments.addResponse(expectedResponse);

    TenantName name = TenantName.of("[PROJECT]", "[LOCATION]", "[TENANT]");

    client.deleteTenant(name);

    List<AbstractMessage> actualRequests = mockSaasDeployments.getRequests();
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
    mockSaasDeployments.addException(exception);

    try {
      TenantName name = TenantName.of("[PROJECT]", "[LOCATION]", "[TENANT]");
      client.deleteTenant(name);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void deleteTenantTest2() throws Exception {
    Empty expectedResponse = Empty.newBuilder().build();
    mockSaasDeployments.addResponse(expectedResponse);

    String name = "name3373707";

    client.deleteTenant(name);

    List<AbstractMessage> actualRequests = mockSaasDeployments.getRequests();
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
    mockSaasDeployments.addException(exception);

    try {
      String name = "name3373707";
      client.deleteTenant(name);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void listUnitKindsTest() throws Exception {
    UnitKind responsesElement = UnitKind.newBuilder().build();
    ListUnitKindsResponse expectedResponse =
        ListUnitKindsResponse.newBuilder()
            .setNextPageToken("")
            .addAllUnitKinds(Arrays.asList(responsesElement))
            .build();
    mockSaasDeployments.addResponse(expectedResponse);

    LocationName parent = LocationName.of("[PROJECT]", "[LOCATION]");

    ListUnitKindsPagedResponse pagedListResponse = client.listUnitKinds(parent);

    List<UnitKind> resources = Lists.newArrayList(pagedListResponse.iterateAll());

    Assert.assertEquals(1, resources.size());
    Assert.assertEquals(expectedResponse.getUnitKindsList().get(0), resources.get(0));

    List<AbstractMessage> actualRequests = mockSaasDeployments.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    ListUnitKindsRequest actualRequest = ((ListUnitKindsRequest) actualRequests.get(0));

    Assert.assertEquals(parent.toString(), actualRequest.getParent());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void listUnitKindsExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockSaasDeployments.addException(exception);

    try {
      LocationName parent = LocationName.of("[PROJECT]", "[LOCATION]");
      client.listUnitKinds(parent);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void listUnitKindsTest2() throws Exception {
    UnitKind responsesElement = UnitKind.newBuilder().build();
    ListUnitKindsResponse expectedResponse =
        ListUnitKindsResponse.newBuilder()
            .setNextPageToken("")
            .addAllUnitKinds(Arrays.asList(responsesElement))
            .build();
    mockSaasDeployments.addResponse(expectedResponse);

    String parent = "parent-995424086";

    ListUnitKindsPagedResponse pagedListResponse = client.listUnitKinds(parent);

    List<UnitKind> resources = Lists.newArrayList(pagedListResponse.iterateAll());

    Assert.assertEquals(1, resources.size());
    Assert.assertEquals(expectedResponse.getUnitKindsList().get(0), resources.get(0));

    List<AbstractMessage> actualRequests = mockSaasDeployments.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    ListUnitKindsRequest actualRequest = ((ListUnitKindsRequest) actualRequests.get(0));

    Assert.assertEquals(parent, actualRequest.getParent());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void listUnitKindsExceptionTest2() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockSaasDeployments.addException(exception);

    try {
      String parent = "parent-995424086";
      client.listUnitKinds(parent);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void getUnitKindTest() throws Exception {
    UnitKind expectedResponse =
        UnitKind.newBuilder()
            .setName(UnitKindName.of("[PROJECT]", "[LOCATION]", "[UNITKIND]").toString())
            .setDefaultRelease(ReleaseName.of("[PROJECT]", "[LOCATION]", "[RELEASE]").toString())
            .addAllDependencies(new ArrayList<Dependency>())
            .addAllInputVariableMappings(new ArrayList<VariableMapping>())
            .addAllOutputVariableMappings(new ArrayList<VariableMapping>())
            .setSaas(SaasName.of("[PROJECT]", "[LOCATION]", "[SAAS]").toString())
            .putAllLabels(new HashMap<String, String>())
            .putAllAnnotations(new HashMap<String, String>())
            .setUid("uid115792")
            .setEtag("etag3123477")
            .setCreateTime(Timestamp.newBuilder().build())
            .setUpdateTime(Timestamp.newBuilder().build())
            .build();
    mockSaasDeployments.addResponse(expectedResponse);

    UnitKindName name = UnitKindName.of("[PROJECT]", "[LOCATION]", "[UNITKIND]");

    UnitKind actualResponse = client.getUnitKind(name);
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockSaasDeployments.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    GetUnitKindRequest actualRequest = ((GetUnitKindRequest) actualRequests.get(0));

    Assert.assertEquals(name.toString(), actualRequest.getName());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void getUnitKindExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockSaasDeployments.addException(exception);

    try {
      UnitKindName name = UnitKindName.of("[PROJECT]", "[LOCATION]", "[UNITKIND]");
      client.getUnitKind(name);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void getUnitKindTest2() throws Exception {
    UnitKind expectedResponse =
        UnitKind.newBuilder()
            .setName(UnitKindName.of("[PROJECT]", "[LOCATION]", "[UNITKIND]").toString())
            .setDefaultRelease(ReleaseName.of("[PROJECT]", "[LOCATION]", "[RELEASE]").toString())
            .addAllDependencies(new ArrayList<Dependency>())
            .addAllInputVariableMappings(new ArrayList<VariableMapping>())
            .addAllOutputVariableMappings(new ArrayList<VariableMapping>())
            .setSaas(SaasName.of("[PROJECT]", "[LOCATION]", "[SAAS]").toString())
            .putAllLabels(new HashMap<String, String>())
            .putAllAnnotations(new HashMap<String, String>())
            .setUid("uid115792")
            .setEtag("etag3123477")
            .setCreateTime(Timestamp.newBuilder().build())
            .setUpdateTime(Timestamp.newBuilder().build())
            .build();
    mockSaasDeployments.addResponse(expectedResponse);

    String name = "name3373707";

    UnitKind actualResponse = client.getUnitKind(name);
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockSaasDeployments.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    GetUnitKindRequest actualRequest = ((GetUnitKindRequest) actualRequests.get(0));

    Assert.assertEquals(name, actualRequest.getName());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void getUnitKindExceptionTest2() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockSaasDeployments.addException(exception);

    try {
      String name = "name3373707";
      client.getUnitKind(name);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void createUnitKindTest() throws Exception {
    UnitKind expectedResponse =
        UnitKind.newBuilder()
            .setName(UnitKindName.of("[PROJECT]", "[LOCATION]", "[UNITKIND]").toString())
            .setDefaultRelease(ReleaseName.of("[PROJECT]", "[LOCATION]", "[RELEASE]").toString())
            .addAllDependencies(new ArrayList<Dependency>())
            .addAllInputVariableMappings(new ArrayList<VariableMapping>())
            .addAllOutputVariableMappings(new ArrayList<VariableMapping>())
            .setSaas(SaasName.of("[PROJECT]", "[LOCATION]", "[SAAS]").toString())
            .putAllLabels(new HashMap<String, String>())
            .putAllAnnotations(new HashMap<String, String>())
            .setUid("uid115792")
            .setEtag("etag3123477")
            .setCreateTime(Timestamp.newBuilder().build())
            .setUpdateTime(Timestamp.newBuilder().build())
            .build();
    mockSaasDeployments.addResponse(expectedResponse);

    LocationName parent = LocationName.of("[PROJECT]", "[LOCATION]");
    UnitKind unitKind = UnitKind.newBuilder().build();
    String unitKindId = "unitKindId1956463219";

    UnitKind actualResponse = client.createUnitKind(parent, unitKind, unitKindId);
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockSaasDeployments.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    CreateUnitKindRequest actualRequest = ((CreateUnitKindRequest) actualRequests.get(0));

    Assert.assertEquals(parent.toString(), actualRequest.getParent());
    Assert.assertEquals(unitKind, actualRequest.getUnitKind());
    Assert.assertEquals(unitKindId, actualRequest.getUnitKindId());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void createUnitKindExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockSaasDeployments.addException(exception);

    try {
      LocationName parent = LocationName.of("[PROJECT]", "[LOCATION]");
      UnitKind unitKind = UnitKind.newBuilder().build();
      String unitKindId = "unitKindId1956463219";
      client.createUnitKind(parent, unitKind, unitKindId);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void createUnitKindTest2() throws Exception {
    UnitKind expectedResponse =
        UnitKind.newBuilder()
            .setName(UnitKindName.of("[PROJECT]", "[LOCATION]", "[UNITKIND]").toString())
            .setDefaultRelease(ReleaseName.of("[PROJECT]", "[LOCATION]", "[RELEASE]").toString())
            .addAllDependencies(new ArrayList<Dependency>())
            .addAllInputVariableMappings(new ArrayList<VariableMapping>())
            .addAllOutputVariableMappings(new ArrayList<VariableMapping>())
            .setSaas(SaasName.of("[PROJECT]", "[LOCATION]", "[SAAS]").toString())
            .putAllLabels(new HashMap<String, String>())
            .putAllAnnotations(new HashMap<String, String>())
            .setUid("uid115792")
            .setEtag("etag3123477")
            .setCreateTime(Timestamp.newBuilder().build())
            .setUpdateTime(Timestamp.newBuilder().build())
            .build();
    mockSaasDeployments.addResponse(expectedResponse);

    String parent = "parent-995424086";
    UnitKind unitKind = UnitKind.newBuilder().build();
    String unitKindId = "unitKindId1956463219";

    UnitKind actualResponse = client.createUnitKind(parent, unitKind, unitKindId);
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockSaasDeployments.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    CreateUnitKindRequest actualRequest = ((CreateUnitKindRequest) actualRequests.get(0));

    Assert.assertEquals(parent, actualRequest.getParent());
    Assert.assertEquals(unitKind, actualRequest.getUnitKind());
    Assert.assertEquals(unitKindId, actualRequest.getUnitKindId());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void createUnitKindExceptionTest2() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockSaasDeployments.addException(exception);

    try {
      String parent = "parent-995424086";
      UnitKind unitKind = UnitKind.newBuilder().build();
      String unitKindId = "unitKindId1956463219";
      client.createUnitKind(parent, unitKind, unitKindId);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void updateUnitKindTest() throws Exception {
    UnitKind expectedResponse =
        UnitKind.newBuilder()
            .setName(UnitKindName.of("[PROJECT]", "[LOCATION]", "[UNITKIND]").toString())
            .setDefaultRelease(ReleaseName.of("[PROJECT]", "[LOCATION]", "[RELEASE]").toString())
            .addAllDependencies(new ArrayList<Dependency>())
            .addAllInputVariableMappings(new ArrayList<VariableMapping>())
            .addAllOutputVariableMappings(new ArrayList<VariableMapping>())
            .setSaas(SaasName.of("[PROJECT]", "[LOCATION]", "[SAAS]").toString())
            .putAllLabels(new HashMap<String, String>())
            .putAllAnnotations(new HashMap<String, String>())
            .setUid("uid115792")
            .setEtag("etag3123477")
            .setCreateTime(Timestamp.newBuilder().build())
            .setUpdateTime(Timestamp.newBuilder().build())
            .build();
    mockSaasDeployments.addResponse(expectedResponse);

    UnitKind unitKind = UnitKind.newBuilder().build();
    FieldMask updateMask = FieldMask.newBuilder().build();

    UnitKind actualResponse = client.updateUnitKind(unitKind, updateMask);
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockSaasDeployments.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    UpdateUnitKindRequest actualRequest = ((UpdateUnitKindRequest) actualRequests.get(0));

    Assert.assertEquals(unitKind, actualRequest.getUnitKind());
    Assert.assertEquals(updateMask, actualRequest.getUpdateMask());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void updateUnitKindExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockSaasDeployments.addException(exception);

    try {
      UnitKind unitKind = UnitKind.newBuilder().build();
      FieldMask updateMask = FieldMask.newBuilder().build();
      client.updateUnitKind(unitKind, updateMask);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void deleteUnitKindTest() throws Exception {
    Empty expectedResponse = Empty.newBuilder().build();
    mockSaasDeployments.addResponse(expectedResponse);

    UnitKindName name = UnitKindName.of("[PROJECT]", "[LOCATION]", "[UNITKIND]");

    client.deleteUnitKind(name);

    List<AbstractMessage> actualRequests = mockSaasDeployments.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    DeleteUnitKindRequest actualRequest = ((DeleteUnitKindRequest) actualRequests.get(0));

    Assert.assertEquals(name.toString(), actualRequest.getName());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void deleteUnitKindExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockSaasDeployments.addException(exception);

    try {
      UnitKindName name = UnitKindName.of("[PROJECT]", "[LOCATION]", "[UNITKIND]");
      client.deleteUnitKind(name);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void deleteUnitKindTest2() throws Exception {
    Empty expectedResponse = Empty.newBuilder().build();
    mockSaasDeployments.addResponse(expectedResponse);

    String name = "name3373707";

    client.deleteUnitKind(name);

    List<AbstractMessage> actualRequests = mockSaasDeployments.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    DeleteUnitKindRequest actualRequest = ((DeleteUnitKindRequest) actualRequests.get(0));

    Assert.assertEquals(name, actualRequest.getName());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void deleteUnitKindExceptionTest2() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockSaasDeployments.addException(exception);

    try {
      String name = "name3373707";
      client.deleteUnitKind(name);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void listUnitsTest() throws Exception {
    Unit responsesElement = Unit.newBuilder().build();
    ListUnitsResponse expectedResponse =
        ListUnitsResponse.newBuilder()
            .setNextPageToken("")
            .addAllUnits(Arrays.asList(responsesElement))
            .build();
    mockSaasDeployments.addResponse(expectedResponse);

    LocationName parent = LocationName.of("[PROJECT]", "[LOCATION]");

    ListUnitsPagedResponse pagedListResponse = client.listUnits(parent);

    List<Unit> resources = Lists.newArrayList(pagedListResponse.iterateAll());

    Assert.assertEquals(1, resources.size());
    Assert.assertEquals(expectedResponse.getUnitsList().get(0), resources.get(0));

    List<AbstractMessage> actualRequests = mockSaasDeployments.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    ListUnitsRequest actualRequest = ((ListUnitsRequest) actualRequests.get(0));

    Assert.assertEquals(parent.toString(), actualRequest.getParent());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void listUnitsExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockSaasDeployments.addException(exception);

    try {
      LocationName parent = LocationName.of("[PROJECT]", "[LOCATION]");
      client.listUnits(parent);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void listUnitsTest2() throws Exception {
    Unit responsesElement = Unit.newBuilder().build();
    ListUnitsResponse expectedResponse =
        ListUnitsResponse.newBuilder()
            .setNextPageToken("")
            .addAllUnits(Arrays.asList(responsesElement))
            .build();
    mockSaasDeployments.addResponse(expectedResponse);

    String parent = "parent-995424086";

    ListUnitsPagedResponse pagedListResponse = client.listUnits(parent);

    List<Unit> resources = Lists.newArrayList(pagedListResponse.iterateAll());

    Assert.assertEquals(1, resources.size());
    Assert.assertEquals(expectedResponse.getUnitsList().get(0), resources.get(0));

    List<AbstractMessage> actualRequests = mockSaasDeployments.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    ListUnitsRequest actualRequest = ((ListUnitsRequest) actualRequests.get(0));

    Assert.assertEquals(parent, actualRequest.getParent());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void listUnitsExceptionTest2() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockSaasDeployments.addException(exception);

    try {
      String parent = "parent-995424086";
      client.listUnits(parent);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void getUnitTest() throws Exception {
    Unit expectedResponse =
        Unit.newBuilder()
            .setName(UnitName.of("[PROJECT]", "[LOCATION]", "[UNIT]").toString())
            .setUnitKind(UnitKindName.of("[PROJECT]", "[LOCATION]", "[UNITKIND]").toString())
            .setRelease(ReleaseName.of("[PROJECT]", "[LOCATION]", "[RELEASE]").toString())
            .setTenant(TenantName.of("[PROJECT]", "[LOCATION]", "[TENANT]").toString())
            .addAllOngoingOperations(new ArrayList<String>())
            .addAllPendingOperations(new ArrayList<String>())
            .addAllScheduledOperations(new ArrayList<String>())
            .addAllDependents(new ArrayList<UnitDependency>())
            .addAllDependencies(new ArrayList<UnitDependency>())
            .addAllInputVariables(new ArrayList<UnitVariable>())
            .addAllOutputVariables(new ArrayList<UnitVariable>())
            .setMaintenance(Unit.MaintenanceSettings.newBuilder().build())
            .addAllConditions(new ArrayList<UnitCondition>())
            .setSystemCleanupAt(Timestamp.newBuilder().build())
            .putAllLabels(new HashMap<String, String>())
            .putAllAnnotations(new HashMap<String, String>())
            .setUid("uid115792")
            .setEtag("etag3123477")
            .setCreateTime(Timestamp.newBuilder().build())
            .setUpdateTime(Timestamp.newBuilder().build())
            .build();
    mockSaasDeployments.addResponse(expectedResponse);

    UnitName name = UnitName.of("[PROJECT]", "[LOCATION]", "[UNIT]");

    Unit actualResponse = client.getUnit(name);
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockSaasDeployments.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    GetUnitRequest actualRequest = ((GetUnitRequest) actualRequests.get(0));

    Assert.assertEquals(name.toString(), actualRequest.getName());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void getUnitExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockSaasDeployments.addException(exception);

    try {
      UnitName name = UnitName.of("[PROJECT]", "[LOCATION]", "[UNIT]");
      client.getUnit(name);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void getUnitTest2() throws Exception {
    Unit expectedResponse =
        Unit.newBuilder()
            .setName(UnitName.of("[PROJECT]", "[LOCATION]", "[UNIT]").toString())
            .setUnitKind(UnitKindName.of("[PROJECT]", "[LOCATION]", "[UNITKIND]").toString())
            .setRelease(ReleaseName.of("[PROJECT]", "[LOCATION]", "[RELEASE]").toString())
            .setTenant(TenantName.of("[PROJECT]", "[LOCATION]", "[TENANT]").toString())
            .addAllOngoingOperations(new ArrayList<String>())
            .addAllPendingOperations(new ArrayList<String>())
            .addAllScheduledOperations(new ArrayList<String>())
            .addAllDependents(new ArrayList<UnitDependency>())
            .addAllDependencies(new ArrayList<UnitDependency>())
            .addAllInputVariables(new ArrayList<UnitVariable>())
            .addAllOutputVariables(new ArrayList<UnitVariable>())
            .setMaintenance(Unit.MaintenanceSettings.newBuilder().build())
            .addAllConditions(new ArrayList<UnitCondition>())
            .setSystemCleanupAt(Timestamp.newBuilder().build())
            .putAllLabels(new HashMap<String, String>())
            .putAllAnnotations(new HashMap<String, String>())
            .setUid("uid115792")
            .setEtag("etag3123477")
            .setCreateTime(Timestamp.newBuilder().build())
            .setUpdateTime(Timestamp.newBuilder().build())
            .build();
    mockSaasDeployments.addResponse(expectedResponse);

    String name = "name3373707";

    Unit actualResponse = client.getUnit(name);
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockSaasDeployments.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    GetUnitRequest actualRequest = ((GetUnitRequest) actualRequests.get(0));

    Assert.assertEquals(name, actualRequest.getName());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void getUnitExceptionTest2() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockSaasDeployments.addException(exception);

    try {
      String name = "name3373707";
      client.getUnit(name);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void createUnitTest() throws Exception {
    Unit expectedResponse =
        Unit.newBuilder()
            .setName(UnitName.of("[PROJECT]", "[LOCATION]", "[UNIT]").toString())
            .setUnitKind(UnitKindName.of("[PROJECT]", "[LOCATION]", "[UNITKIND]").toString())
            .setRelease(ReleaseName.of("[PROJECT]", "[LOCATION]", "[RELEASE]").toString())
            .setTenant(TenantName.of("[PROJECT]", "[LOCATION]", "[TENANT]").toString())
            .addAllOngoingOperations(new ArrayList<String>())
            .addAllPendingOperations(new ArrayList<String>())
            .addAllScheduledOperations(new ArrayList<String>())
            .addAllDependents(new ArrayList<UnitDependency>())
            .addAllDependencies(new ArrayList<UnitDependency>())
            .addAllInputVariables(new ArrayList<UnitVariable>())
            .addAllOutputVariables(new ArrayList<UnitVariable>())
            .setMaintenance(Unit.MaintenanceSettings.newBuilder().build())
            .addAllConditions(new ArrayList<UnitCondition>())
            .setSystemCleanupAt(Timestamp.newBuilder().build())
            .putAllLabels(new HashMap<String, String>())
            .putAllAnnotations(new HashMap<String, String>())
            .setUid("uid115792")
            .setEtag("etag3123477")
            .setCreateTime(Timestamp.newBuilder().build())
            .setUpdateTime(Timestamp.newBuilder().build())
            .build();
    mockSaasDeployments.addResponse(expectedResponse);

    LocationName parent = LocationName.of("[PROJECT]", "[LOCATION]");
    Unit unit = Unit.newBuilder().build();
    String unitId = "unitId-840527425";

    Unit actualResponse = client.createUnit(parent, unit, unitId);
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockSaasDeployments.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    CreateUnitRequest actualRequest = ((CreateUnitRequest) actualRequests.get(0));

    Assert.assertEquals(parent.toString(), actualRequest.getParent());
    Assert.assertEquals(unit, actualRequest.getUnit());
    Assert.assertEquals(unitId, actualRequest.getUnitId());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void createUnitExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockSaasDeployments.addException(exception);

    try {
      LocationName parent = LocationName.of("[PROJECT]", "[LOCATION]");
      Unit unit = Unit.newBuilder().build();
      String unitId = "unitId-840527425";
      client.createUnit(parent, unit, unitId);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void createUnitTest2() throws Exception {
    Unit expectedResponse =
        Unit.newBuilder()
            .setName(UnitName.of("[PROJECT]", "[LOCATION]", "[UNIT]").toString())
            .setUnitKind(UnitKindName.of("[PROJECT]", "[LOCATION]", "[UNITKIND]").toString())
            .setRelease(ReleaseName.of("[PROJECT]", "[LOCATION]", "[RELEASE]").toString())
            .setTenant(TenantName.of("[PROJECT]", "[LOCATION]", "[TENANT]").toString())
            .addAllOngoingOperations(new ArrayList<String>())
            .addAllPendingOperations(new ArrayList<String>())
            .addAllScheduledOperations(new ArrayList<String>())
            .addAllDependents(new ArrayList<UnitDependency>())
            .addAllDependencies(new ArrayList<UnitDependency>())
            .addAllInputVariables(new ArrayList<UnitVariable>())
            .addAllOutputVariables(new ArrayList<UnitVariable>())
            .setMaintenance(Unit.MaintenanceSettings.newBuilder().build())
            .addAllConditions(new ArrayList<UnitCondition>())
            .setSystemCleanupAt(Timestamp.newBuilder().build())
            .putAllLabels(new HashMap<String, String>())
            .putAllAnnotations(new HashMap<String, String>())
            .setUid("uid115792")
            .setEtag("etag3123477")
            .setCreateTime(Timestamp.newBuilder().build())
            .setUpdateTime(Timestamp.newBuilder().build())
            .build();
    mockSaasDeployments.addResponse(expectedResponse);

    String parent = "parent-995424086";
    Unit unit = Unit.newBuilder().build();
    String unitId = "unitId-840527425";

    Unit actualResponse = client.createUnit(parent, unit, unitId);
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockSaasDeployments.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    CreateUnitRequest actualRequest = ((CreateUnitRequest) actualRequests.get(0));

    Assert.assertEquals(parent, actualRequest.getParent());
    Assert.assertEquals(unit, actualRequest.getUnit());
    Assert.assertEquals(unitId, actualRequest.getUnitId());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void createUnitExceptionTest2() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockSaasDeployments.addException(exception);

    try {
      String parent = "parent-995424086";
      Unit unit = Unit.newBuilder().build();
      String unitId = "unitId-840527425";
      client.createUnit(parent, unit, unitId);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void updateUnitTest() throws Exception {
    Unit expectedResponse =
        Unit.newBuilder()
            .setName(UnitName.of("[PROJECT]", "[LOCATION]", "[UNIT]").toString())
            .setUnitKind(UnitKindName.of("[PROJECT]", "[LOCATION]", "[UNITKIND]").toString())
            .setRelease(ReleaseName.of("[PROJECT]", "[LOCATION]", "[RELEASE]").toString())
            .setTenant(TenantName.of("[PROJECT]", "[LOCATION]", "[TENANT]").toString())
            .addAllOngoingOperations(new ArrayList<String>())
            .addAllPendingOperations(new ArrayList<String>())
            .addAllScheduledOperations(new ArrayList<String>())
            .addAllDependents(new ArrayList<UnitDependency>())
            .addAllDependencies(new ArrayList<UnitDependency>())
            .addAllInputVariables(new ArrayList<UnitVariable>())
            .addAllOutputVariables(new ArrayList<UnitVariable>())
            .setMaintenance(Unit.MaintenanceSettings.newBuilder().build())
            .addAllConditions(new ArrayList<UnitCondition>())
            .setSystemCleanupAt(Timestamp.newBuilder().build())
            .putAllLabels(new HashMap<String, String>())
            .putAllAnnotations(new HashMap<String, String>())
            .setUid("uid115792")
            .setEtag("etag3123477")
            .setCreateTime(Timestamp.newBuilder().build())
            .setUpdateTime(Timestamp.newBuilder().build())
            .build();
    mockSaasDeployments.addResponse(expectedResponse);

    Unit unit = Unit.newBuilder().build();
    FieldMask updateMask = FieldMask.newBuilder().build();

    Unit actualResponse = client.updateUnit(unit, updateMask);
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockSaasDeployments.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    UpdateUnitRequest actualRequest = ((UpdateUnitRequest) actualRequests.get(0));

    Assert.assertEquals(unit, actualRequest.getUnit());
    Assert.assertEquals(updateMask, actualRequest.getUpdateMask());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void updateUnitExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockSaasDeployments.addException(exception);

    try {
      Unit unit = Unit.newBuilder().build();
      FieldMask updateMask = FieldMask.newBuilder().build();
      client.updateUnit(unit, updateMask);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void deleteUnitTest() throws Exception {
    Empty expectedResponse = Empty.newBuilder().build();
    mockSaasDeployments.addResponse(expectedResponse);

    UnitName name = UnitName.of("[PROJECT]", "[LOCATION]", "[UNIT]");

    client.deleteUnit(name);

    List<AbstractMessage> actualRequests = mockSaasDeployments.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    DeleteUnitRequest actualRequest = ((DeleteUnitRequest) actualRequests.get(0));

    Assert.assertEquals(name.toString(), actualRequest.getName());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void deleteUnitExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockSaasDeployments.addException(exception);

    try {
      UnitName name = UnitName.of("[PROJECT]", "[LOCATION]", "[UNIT]");
      client.deleteUnit(name);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void deleteUnitTest2() throws Exception {
    Empty expectedResponse = Empty.newBuilder().build();
    mockSaasDeployments.addResponse(expectedResponse);

    String name = "name3373707";

    client.deleteUnit(name);

    List<AbstractMessage> actualRequests = mockSaasDeployments.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    DeleteUnitRequest actualRequest = ((DeleteUnitRequest) actualRequests.get(0));

    Assert.assertEquals(name, actualRequest.getName());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void deleteUnitExceptionTest2() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockSaasDeployments.addException(exception);

    try {
      String name = "name3373707";
      client.deleteUnit(name);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void listUnitOperationsTest() throws Exception {
    UnitOperation responsesElement = UnitOperation.newBuilder().build();
    ListUnitOperationsResponse expectedResponse =
        ListUnitOperationsResponse.newBuilder()
            .setNextPageToken("")
            .addAllUnitOperations(Arrays.asList(responsesElement))
            .build();
    mockSaasDeployments.addResponse(expectedResponse);

    LocationName parent = LocationName.of("[PROJECT]", "[LOCATION]");

    ListUnitOperationsPagedResponse pagedListResponse = client.listUnitOperations(parent);

    List<UnitOperation> resources = Lists.newArrayList(pagedListResponse.iterateAll());

    Assert.assertEquals(1, resources.size());
    Assert.assertEquals(expectedResponse.getUnitOperationsList().get(0), resources.get(0));

    List<AbstractMessage> actualRequests = mockSaasDeployments.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    ListUnitOperationsRequest actualRequest = ((ListUnitOperationsRequest) actualRequests.get(0));

    Assert.assertEquals(parent.toString(), actualRequest.getParent());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void listUnitOperationsExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockSaasDeployments.addException(exception);

    try {
      LocationName parent = LocationName.of("[PROJECT]", "[LOCATION]");
      client.listUnitOperations(parent);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void listUnitOperationsTest2() throws Exception {
    UnitOperation responsesElement = UnitOperation.newBuilder().build();
    ListUnitOperationsResponse expectedResponse =
        ListUnitOperationsResponse.newBuilder()
            .setNextPageToken("")
            .addAllUnitOperations(Arrays.asList(responsesElement))
            .build();
    mockSaasDeployments.addResponse(expectedResponse);

    String parent = "parent-995424086";

    ListUnitOperationsPagedResponse pagedListResponse = client.listUnitOperations(parent);

    List<UnitOperation> resources = Lists.newArrayList(pagedListResponse.iterateAll());

    Assert.assertEquals(1, resources.size());
    Assert.assertEquals(expectedResponse.getUnitOperationsList().get(0), resources.get(0));

    List<AbstractMessage> actualRequests = mockSaasDeployments.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    ListUnitOperationsRequest actualRequest = ((ListUnitOperationsRequest) actualRequests.get(0));

    Assert.assertEquals(parent, actualRequest.getParent());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void listUnitOperationsExceptionTest2() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockSaasDeployments.addException(exception);

    try {
      String parent = "parent-995424086";
      client.listUnitOperations(parent);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void getUnitOperationTest() throws Exception {
    UnitOperation expectedResponse =
        UnitOperation.newBuilder()
            .setName(UnitOperationName.of("[PROJECT]", "[LOCATION]", "[UNITOPERATION]").toString())
            .setUnit(UnitName.of("[PROJECT]", "[LOCATION]", "[UNIT]").toString())
            .setParentUnitOperation(
                UnitOperationName.of("[PROJECT]", "[LOCATION]", "[UNITOPERATION]").toString())
            .setRollout(RolloutName.of("[PROJECT]", "[LOCATION]", "[ROLLOUT_ID]").toString())
            .setCancel(true)
            .addAllConditions(new ArrayList<UnitOperationCondition>())
            .setSchedule(Schedule.newBuilder().build())
            .setEngineState("engineState1690039151")
            .setErrorCategory(UnitOperationErrorCategory.forNumber(0))
            .putAllLabels(new HashMap<String, String>())
            .putAllAnnotations(new HashMap<String, String>())
            .setUid("uid115792")
            .setEtag("etag3123477")
            .setCreateTime(Timestamp.newBuilder().build())
            .setUpdateTime(Timestamp.newBuilder().build())
            .build();
    mockSaasDeployments.addResponse(expectedResponse);

    UnitOperationName name = UnitOperationName.of("[PROJECT]", "[LOCATION]", "[UNITOPERATION]");

    UnitOperation actualResponse = client.getUnitOperation(name);
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockSaasDeployments.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    GetUnitOperationRequest actualRequest = ((GetUnitOperationRequest) actualRequests.get(0));

    Assert.assertEquals(name.toString(), actualRequest.getName());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void getUnitOperationExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockSaasDeployments.addException(exception);

    try {
      UnitOperationName name = UnitOperationName.of("[PROJECT]", "[LOCATION]", "[UNITOPERATION]");
      client.getUnitOperation(name);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void getUnitOperationTest2() throws Exception {
    UnitOperation expectedResponse =
        UnitOperation.newBuilder()
            .setName(UnitOperationName.of("[PROJECT]", "[LOCATION]", "[UNITOPERATION]").toString())
            .setUnit(UnitName.of("[PROJECT]", "[LOCATION]", "[UNIT]").toString())
            .setParentUnitOperation(
                UnitOperationName.of("[PROJECT]", "[LOCATION]", "[UNITOPERATION]").toString())
            .setRollout(RolloutName.of("[PROJECT]", "[LOCATION]", "[ROLLOUT_ID]").toString())
            .setCancel(true)
            .addAllConditions(new ArrayList<UnitOperationCondition>())
            .setSchedule(Schedule.newBuilder().build())
            .setEngineState("engineState1690039151")
            .setErrorCategory(UnitOperationErrorCategory.forNumber(0))
            .putAllLabels(new HashMap<String, String>())
            .putAllAnnotations(new HashMap<String, String>())
            .setUid("uid115792")
            .setEtag("etag3123477")
            .setCreateTime(Timestamp.newBuilder().build())
            .setUpdateTime(Timestamp.newBuilder().build())
            .build();
    mockSaasDeployments.addResponse(expectedResponse);

    String name = "name3373707";

    UnitOperation actualResponse = client.getUnitOperation(name);
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockSaasDeployments.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    GetUnitOperationRequest actualRequest = ((GetUnitOperationRequest) actualRequests.get(0));

    Assert.assertEquals(name, actualRequest.getName());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void getUnitOperationExceptionTest2() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockSaasDeployments.addException(exception);

    try {
      String name = "name3373707";
      client.getUnitOperation(name);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void createUnitOperationTest() throws Exception {
    UnitOperation expectedResponse =
        UnitOperation.newBuilder()
            .setName(UnitOperationName.of("[PROJECT]", "[LOCATION]", "[UNITOPERATION]").toString())
            .setUnit(UnitName.of("[PROJECT]", "[LOCATION]", "[UNIT]").toString())
            .setParentUnitOperation(
                UnitOperationName.of("[PROJECT]", "[LOCATION]", "[UNITOPERATION]").toString())
            .setRollout(RolloutName.of("[PROJECT]", "[LOCATION]", "[ROLLOUT_ID]").toString())
            .setCancel(true)
            .addAllConditions(new ArrayList<UnitOperationCondition>())
            .setSchedule(Schedule.newBuilder().build())
            .setEngineState("engineState1690039151")
            .setErrorCategory(UnitOperationErrorCategory.forNumber(0))
            .putAllLabels(new HashMap<String, String>())
            .putAllAnnotations(new HashMap<String, String>())
            .setUid("uid115792")
            .setEtag("etag3123477")
            .setCreateTime(Timestamp.newBuilder().build())
            .setUpdateTime(Timestamp.newBuilder().build())
            .build();
    mockSaasDeployments.addResponse(expectedResponse);

    LocationName parent = LocationName.of("[PROJECT]", "[LOCATION]");
    UnitOperation unitOperation = UnitOperation.newBuilder().build();
    String unitOperationId = "unitOperationId-638217026";

    UnitOperation actualResponse =
        client.createUnitOperation(parent, unitOperation, unitOperationId);
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockSaasDeployments.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    CreateUnitOperationRequest actualRequest = ((CreateUnitOperationRequest) actualRequests.get(0));

    Assert.assertEquals(parent.toString(), actualRequest.getParent());
    Assert.assertEquals(unitOperation, actualRequest.getUnitOperation());
    Assert.assertEquals(unitOperationId, actualRequest.getUnitOperationId());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void createUnitOperationExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockSaasDeployments.addException(exception);

    try {
      LocationName parent = LocationName.of("[PROJECT]", "[LOCATION]");
      UnitOperation unitOperation = UnitOperation.newBuilder().build();
      String unitOperationId = "unitOperationId-638217026";
      client.createUnitOperation(parent, unitOperation, unitOperationId);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void createUnitOperationTest2() throws Exception {
    UnitOperation expectedResponse =
        UnitOperation.newBuilder()
            .setName(UnitOperationName.of("[PROJECT]", "[LOCATION]", "[UNITOPERATION]").toString())
            .setUnit(UnitName.of("[PROJECT]", "[LOCATION]", "[UNIT]").toString())
            .setParentUnitOperation(
                UnitOperationName.of("[PROJECT]", "[LOCATION]", "[UNITOPERATION]").toString())
            .setRollout(RolloutName.of("[PROJECT]", "[LOCATION]", "[ROLLOUT_ID]").toString())
            .setCancel(true)
            .addAllConditions(new ArrayList<UnitOperationCondition>())
            .setSchedule(Schedule.newBuilder().build())
            .setEngineState("engineState1690039151")
            .setErrorCategory(UnitOperationErrorCategory.forNumber(0))
            .putAllLabels(new HashMap<String, String>())
            .putAllAnnotations(new HashMap<String, String>())
            .setUid("uid115792")
            .setEtag("etag3123477")
            .setCreateTime(Timestamp.newBuilder().build())
            .setUpdateTime(Timestamp.newBuilder().build())
            .build();
    mockSaasDeployments.addResponse(expectedResponse);

    String parent = "parent-995424086";
    UnitOperation unitOperation = UnitOperation.newBuilder().build();
    String unitOperationId = "unitOperationId-638217026";

    UnitOperation actualResponse =
        client.createUnitOperation(parent, unitOperation, unitOperationId);
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockSaasDeployments.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    CreateUnitOperationRequest actualRequest = ((CreateUnitOperationRequest) actualRequests.get(0));

    Assert.assertEquals(parent, actualRequest.getParent());
    Assert.assertEquals(unitOperation, actualRequest.getUnitOperation());
    Assert.assertEquals(unitOperationId, actualRequest.getUnitOperationId());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void createUnitOperationExceptionTest2() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockSaasDeployments.addException(exception);

    try {
      String parent = "parent-995424086";
      UnitOperation unitOperation = UnitOperation.newBuilder().build();
      String unitOperationId = "unitOperationId-638217026";
      client.createUnitOperation(parent, unitOperation, unitOperationId);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void updateUnitOperationTest() throws Exception {
    UnitOperation expectedResponse =
        UnitOperation.newBuilder()
            .setName(UnitOperationName.of("[PROJECT]", "[LOCATION]", "[UNITOPERATION]").toString())
            .setUnit(UnitName.of("[PROJECT]", "[LOCATION]", "[UNIT]").toString())
            .setParentUnitOperation(
                UnitOperationName.of("[PROJECT]", "[LOCATION]", "[UNITOPERATION]").toString())
            .setRollout(RolloutName.of("[PROJECT]", "[LOCATION]", "[ROLLOUT_ID]").toString())
            .setCancel(true)
            .addAllConditions(new ArrayList<UnitOperationCondition>())
            .setSchedule(Schedule.newBuilder().build())
            .setEngineState("engineState1690039151")
            .setErrorCategory(UnitOperationErrorCategory.forNumber(0))
            .putAllLabels(new HashMap<String, String>())
            .putAllAnnotations(new HashMap<String, String>())
            .setUid("uid115792")
            .setEtag("etag3123477")
            .setCreateTime(Timestamp.newBuilder().build())
            .setUpdateTime(Timestamp.newBuilder().build())
            .build();
    mockSaasDeployments.addResponse(expectedResponse);

    UnitOperation unitOperation = UnitOperation.newBuilder().build();
    FieldMask updateMask = FieldMask.newBuilder().build();

    UnitOperation actualResponse = client.updateUnitOperation(unitOperation, updateMask);
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockSaasDeployments.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    UpdateUnitOperationRequest actualRequest = ((UpdateUnitOperationRequest) actualRequests.get(0));

    Assert.assertEquals(unitOperation, actualRequest.getUnitOperation());
    Assert.assertEquals(updateMask, actualRequest.getUpdateMask());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void updateUnitOperationExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockSaasDeployments.addException(exception);

    try {
      UnitOperation unitOperation = UnitOperation.newBuilder().build();
      FieldMask updateMask = FieldMask.newBuilder().build();
      client.updateUnitOperation(unitOperation, updateMask);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void deleteUnitOperationTest() throws Exception {
    Empty expectedResponse = Empty.newBuilder().build();
    mockSaasDeployments.addResponse(expectedResponse);

    UnitOperationName name = UnitOperationName.of("[PROJECT]", "[LOCATION]", "[UNITOPERATION]");

    client.deleteUnitOperation(name);

    List<AbstractMessage> actualRequests = mockSaasDeployments.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    DeleteUnitOperationRequest actualRequest = ((DeleteUnitOperationRequest) actualRequests.get(0));

    Assert.assertEquals(name.toString(), actualRequest.getName());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void deleteUnitOperationExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockSaasDeployments.addException(exception);

    try {
      UnitOperationName name = UnitOperationName.of("[PROJECT]", "[LOCATION]", "[UNITOPERATION]");
      client.deleteUnitOperation(name);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void deleteUnitOperationTest2() throws Exception {
    Empty expectedResponse = Empty.newBuilder().build();
    mockSaasDeployments.addResponse(expectedResponse);

    String name = "name3373707";

    client.deleteUnitOperation(name);

    List<AbstractMessage> actualRequests = mockSaasDeployments.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    DeleteUnitOperationRequest actualRequest = ((DeleteUnitOperationRequest) actualRequests.get(0));

    Assert.assertEquals(name, actualRequest.getName());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void deleteUnitOperationExceptionTest2() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockSaasDeployments.addException(exception);

    try {
      String name = "name3373707";
      client.deleteUnitOperation(name);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void listReleasesTest() throws Exception {
    Release responsesElement = Release.newBuilder().build();
    ListReleasesResponse expectedResponse =
        ListReleasesResponse.newBuilder()
            .setNextPageToken("")
            .addAllReleases(Arrays.asList(responsesElement))
            .build();
    mockSaasDeployments.addResponse(expectedResponse);

    LocationName parent = LocationName.of("[PROJECT]", "[LOCATION]");

    ListReleasesPagedResponse pagedListResponse = client.listReleases(parent);

    List<Release> resources = Lists.newArrayList(pagedListResponse.iterateAll());

    Assert.assertEquals(1, resources.size());
    Assert.assertEquals(expectedResponse.getReleasesList().get(0), resources.get(0));

    List<AbstractMessage> actualRequests = mockSaasDeployments.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    ListReleasesRequest actualRequest = ((ListReleasesRequest) actualRequests.get(0));

    Assert.assertEquals(parent.toString(), actualRequest.getParent());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void listReleasesExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockSaasDeployments.addException(exception);

    try {
      LocationName parent = LocationName.of("[PROJECT]", "[LOCATION]");
      client.listReleases(parent);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void listReleasesTest2() throws Exception {
    Release responsesElement = Release.newBuilder().build();
    ListReleasesResponse expectedResponse =
        ListReleasesResponse.newBuilder()
            .setNextPageToken("")
            .addAllReleases(Arrays.asList(responsesElement))
            .build();
    mockSaasDeployments.addResponse(expectedResponse);

    String parent = "parent-995424086";

    ListReleasesPagedResponse pagedListResponse = client.listReleases(parent);

    List<Release> resources = Lists.newArrayList(pagedListResponse.iterateAll());

    Assert.assertEquals(1, resources.size());
    Assert.assertEquals(expectedResponse.getReleasesList().get(0), resources.get(0));

    List<AbstractMessage> actualRequests = mockSaasDeployments.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    ListReleasesRequest actualRequest = ((ListReleasesRequest) actualRequests.get(0));

    Assert.assertEquals(parent, actualRequest.getParent());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void listReleasesExceptionTest2() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockSaasDeployments.addException(exception);

    try {
      String parent = "parent-995424086";
      client.listReleases(parent);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void getReleaseTest() throws Exception {
    Release expectedResponse =
        Release.newBuilder()
            .setName(ReleaseName.of("[PROJECT]", "[LOCATION]", "[RELEASE]").toString())
            .setUnitKind(UnitKindName.of("[PROJECT]", "[LOCATION]", "[UNITKIND]").toString())
            .setBlueprint(Blueprint.newBuilder().build())
            .setReleaseRequirements(Release.ReleaseRequirements.newBuilder().build())
            .addAllInputVariables(new ArrayList<UnitVariable>())
            .addAllOutputVariables(new ArrayList<UnitVariable>())
            .addAllInputVariableDefaults(new ArrayList<UnitVariable>())
            .putAllLabels(new HashMap<String, String>())
            .putAllAnnotations(new HashMap<String, String>())
            .setUid("uid115792")
            .setEtag("etag3123477")
            .setCreateTime(Timestamp.newBuilder().build())
            .setUpdateTime(Timestamp.newBuilder().build())
            .build();
    mockSaasDeployments.addResponse(expectedResponse);

    ReleaseName name = ReleaseName.of("[PROJECT]", "[LOCATION]", "[RELEASE]");

    Release actualResponse = client.getRelease(name);
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockSaasDeployments.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    GetReleaseRequest actualRequest = ((GetReleaseRequest) actualRequests.get(0));

    Assert.assertEquals(name.toString(), actualRequest.getName());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void getReleaseExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockSaasDeployments.addException(exception);

    try {
      ReleaseName name = ReleaseName.of("[PROJECT]", "[LOCATION]", "[RELEASE]");
      client.getRelease(name);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void getReleaseTest2() throws Exception {
    Release expectedResponse =
        Release.newBuilder()
            .setName(ReleaseName.of("[PROJECT]", "[LOCATION]", "[RELEASE]").toString())
            .setUnitKind(UnitKindName.of("[PROJECT]", "[LOCATION]", "[UNITKIND]").toString())
            .setBlueprint(Blueprint.newBuilder().build())
            .setReleaseRequirements(Release.ReleaseRequirements.newBuilder().build())
            .addAllInputVariables(new ArrayList<UnitVariable>())
            .addAllOutputVariables(new ArrayList<UnitVariable>())
            .addAllInputVariableDefaults(new ArrayList<UnitVariable>())
            .putAllLabels(new HashMap<String, String>())
            .putAllAnnotations(new HashMap<String, String>())
            .setUid("uid115792")
            .setEtag("etag3123477")
            .setCreateTime(Timestamp.newBuilder().build())
            .setUpdateTime(Timestamp.newBuilder().build())
            .build();
    mockSaasDeployments.addResponse(expectedResponse);

    String name = "name3373707";

    Release actualResponse = client.getRelease(name);
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockSaasDeployments.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    GetReleaseRequest actualRequest = ((GetReleaseRequest) actualRequests.get(0));

    Assert.assertEquals(name, actualRequest.getName());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void getReleaseExceptionTest2() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockSaasDeployments.addException(exception);

    try {
      String name = "name3373707";
      client.getRelease(name);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void createReleaseTest() throws Exception {
    Release expectedResponse =
        Release.newBuilder()
            .setName(ReleaseName.of("[PROJECT]", "[LOCATION]", "[RELEASE]").toString())
            .setUnitKind(UnitKindName.of("[PROJECT]", "[LOCATION]", "[UNITKIND]").toString())
            .setBlueprint(Blueprint.newBuilder().build())
            .setReleaseRequirements(Release.ReleaseRequirements.newBuilder().build())
            .addAllInputVariables(new ArrayList<UnitVariable>())
            .addAllOutputVariables(new ArrayList<UnitVariable>())
            .addAllInputVariableDefaults(new ArrayList<UnitVariable>())
            .putAllLabels(new HashMap<String, String>())
            .putAllAnnotations(new HashMap<String, String>())
            .setUid("uid115792")
            .setEtag("etag3123477")
            .setCreateTime(Timestamp.newBuilder().build())
            .setUpdateTime(Timestamp.newBuilder().build())
            .build();
    mockSaasDeployments.addResponse(expectedResponse);

    LocationName parent = LocationName.of("[PROJECT]", "[LOCATION]");
    Release release = Release.newBuilder().build();
    String releaseId = "releaseId89607042";

    Release actualResponse = client.createRelease(parent, release, releaseId);
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockSaasDeployments.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    CreateReleaseRequest actualRequest = ((CreateReleaseRequest) actualRequests.get(0));

    Assert.assertEquals(parent.toString(), actualRequest.getParent());
    Assert.assertEquals(release, actualRequest.getRelease());
    Assert.assertEquals(releaseId, actualRequest.getReleaseId());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void createReleaseExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockSaasDeployments.addException(exception);

    try {
      LocationName parent = LocationName.of("[PROJECT]", "[LOCATION]");
      Release release = Release.newBuilder().build();
      String releaseId = "releaseId89607042";
      client.createRelease(parent, release, releaseId);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void createReleaseTest2() throws Exception {
    Release expectedResponse =
        Release.newBuilder()
            .setName(ReleaseName.of("[PROJECT]", "[LOCATION]", "[RELEASE]").toString())
            .setUnitKind(UnitKindName.of("[PROJECT]", "[LOCATION]", "[UNITKIND]").toString())
            .setBlueprint(Blueprint.newBuilder().build())
            .setReleaseRequirements(Release.ReleaseRequirements.newBuilder().build())
            .addAllInputVariables(new ArrayList<UnitVariable>())
            .addAllOutputVariables(new ArrayList<UnitVariable>())
            .addAllInputVariableDefaults(new ArrayList<UnitVariable>())
            .putAllLabels(new HashMap<String, String>())
            .putAllAnnotations(new HashMap<String, String>())
            .setUid("uid115792")
            .setEtag("etag3123477")
            .setCreateTime(Timestamp.newBuilder().build())
            .setUpdateTime(Timestamp.newBuilder().build())
            .build();
    mockSaasDeployments.addResponse(expectedResponse);

    String parent = "parent-995424086";
    Release release = Release.newBuilder().build();
    String releaseId = "releaseId89607042";

    Release actualResponse = client.createRelease(parent, release, releaseId);
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockSaasDeployments.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    CreateReleaseRequest actualRequest = ((CreateReleaseRequest) actualRequests.get(0));

    Assert.assertEquals(parent, actualRequest.getParent());
    Assert.assertEquals(release, actualRequest.getRelease());
    Assert.assertEquals(releaseId, actualRequest.getReleaseId());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void createReleaseExceptionTest2() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockSaasDeployments.addException(exception);

    try {
      String parent = "parent-995424086";
      Release release = Release.newBuilder().build();
      String releaseId = "releaseId89607042";
      client.createRelease(parent, release, releaseId);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void updateReleaseTest() throws Exception {
    Release expectedResponse =
        Release.newBuilder()
            .setName(ReleaseName.of("[PROJECT]", "[LOCATION]", "[RELEASE]").toString())
            .setUnitKind(UnitKindName.of("[PROJECT]", "[LOCATION]", "[UNITKIND]").toString())
            .setBlueprint(Blueprint.newBuilder().build())
            .setReleaseRequirements(Release.ReleaseRequirements.newBuilder().build())
            .addAllInputVariables(new ArrayList<UnitVariable>())
            .addAllOutputVariables(new ArrayList<UnitVariable>())
            .addAllInputVariableDefaults(new ArrayList<UnitVariable>())
            .putAllLabels(new HashMap<String, String>())
            .putAllAnnotations(new HashMap<String, String>())
            .setUid("uid115792")
            .setEtag("etag3123477")
            .setCreateTime(Timestamp.newBuilder().build())
            .setUpdateTime(Timestamp.newBuilder().build())
            .build();
    mockSaasDeployments.addResponse(expectedResponse);

    Release release = Release.newBuilder().build();
    FieldMask updateMask = FieldMask.newBuilder().build();

    Release actualResponse = client.updateRelease(release, updateMask);
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockSaasDeployments.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    UpdateReleaseRequest actualRequest = ((UpdateReleaseRequest) actualRequests.get(0));

    Assert.assertEquals(release, actualRequest.getRelease());
    Assert.assertEquals(updateMask, actualRequest.getUpdateMask());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void updateReleaseExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockSaasDeployments.addException(exception);

    try {
      Release release = Release.newBuilder().build();
      FieldMask updateMask = FieldMask.newBuilder().build();
      client.updateRelease(release, updateMask);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void deleteReleaseTest() throws Exception {
    Empty expectedResponse = Empty.newBuilder().build();
    mockSaasDeployments.addResponse(expectedResponse);

    ReleaseName name = ReleaseName.of("[PROJECT]", "[LOCATION]", "[RELEASE]");

    client.deleteRelease(name);

    List<AbstractMessage> actualRequests = mockSaasDeployments.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    DeleteReleaseRequest actualRequest = ((DeleteReleaseRequest) actualRequests.get(0));

    Assert.assertEquals(name.toString(), actualRequest.getName());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void deleteReleaseExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockSaasDeployments.addException(exception);

    try {
      ReleaseName name = ReleaseName.of("[PROJECT]", "[LOCATION]", "[RELEASE]");
      client.deleteRelease(name);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void deleteReleaseTest2() throws Exception {
    Empty expectedResponse = Empty.newBuilder().build();
    mockSaasDeployments.addResponse(expectedResponse);

    String name = "name3373707";

    client.deleteRelease(name);

    List<AbstractMessage> actualRequests = mockSaasDeployments.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    DeleteReleaseRequest actualRequest = ((DeleteReleaseRequest) actualRequests.get(0));

    Assert.assertEquals(name, actualRequest.getName());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void deleteReleaseExceptionTest2() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockSaasDeployments.addException(exception);

    try {
      String name = "name3373707";
      client.deleteRelease(name);
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
