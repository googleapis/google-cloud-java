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

package com.google.cloud.managedidentities.v1;

import static com.google.cloud.managedidentities.v1.ManagedIdentitiesServiceClient.ListDomainsPagedResponse;

import com.google.api.gax.core.NoCredentialsProvider;
import com.google.api.gax.grpc.GaxGrpcProperties;
import com.google.api.gax.grpc.testing.LocalChannelProvider;
import com.google.api.gax.grpc.testing.MockGrpcService;
import com.google.api.gax.grpc.testing.MockServiceHelper;
import com.google.api.gax.rpc.ApiClientHeaderProvider;
import com.google.api.gax.rpc.InvalidArgumentException;
import com.google.api.gax.rpc.StatusCode;
import com.google.common.collect.Lists;
import com.google.longrunning.Operation;
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
import java.util.concurrent.ExecutionException;
import javax.annotation.Generated;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Assert;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

@Generated("by gapic-generator-java")
public class ManagedIdentitiesServiceClientTest {
  private static MockManagedIdentitiesService mockManagedIdentitiesService;
  private static MockServiceHelper mockServiceHelper;
  private LocalChannelProvider channelProvider;
  private ManagedIdentitiesServiceClient client;

  @BeforeClass
  public static void startStaticServer() {
    mockManagedIdentitiesService = new MockManagedIdentitiesService();
    mockServiceHelper =
        new MockServiceHelper(
            UUID.randomUUID().toString(),
            Arrays.<MockGrpcService>asList(mockManagedIdentitiesService));
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
    ManagedIdentitiesServiceSettings settings =
        ManagedIdentitiesServiceSettings.newBuilder()
            .setTransportChannelProvider(channelProvider)
            .setCredentialsProvider(NoCredentialsProvider.create())
            .build();
    client = ManagedIdentitiesServiceClient.create(settings);
  }

  @After
  public void tearDown() throws Exception {
    client.close();
  }

  @Test
  public void createMicrosoftAdDomainTest() throws Exception {
    Domain expectedResponse =
        Domain.newBuilder()
            .setName(DomainName.of("[PROJECT]", "[LOCATION]", "[DOMAIN]").toString())
            .putAllLabels(new HashMap<String, String>())
            .addAllAuthorizedNetworks(new ArrayList<String>())
            .setReservedIpRange("reservedIpRange575015950")
            .addAllLocations(new ArrayList<String>())
            .setAdmin("admin92668751")
            .setFqdn("fqdn3150485")
            .setCreateTime(Timestamp.newBuilder().build())
            .setUpdateTime(Timestamp.newBuilder().build())
            .setStatusMessage("statusMessage-958704715")
            .addAllTrusts(new ArrayList<Trust>())
            .build();
    Operation resultOperation =
        Operation.newBuilder()
            .setName("createMicrosoftAdDomainTest")
            .setDone(true)
            .setResponse(Any.pack(expectedResponse))
            .build();
    mockManagedIdentitiesService.addResponse(resultOperation);

    LocationName parent = LocationName.of("[PROJECT]", "[LOCATION]");
    String domainName = "domainName-1244085905";
    Domain domain = Domain.newBuilder().build();

    Domain actualResponse = client.createMicrosoftAdDomainAsync(parent, domainName, domain).get();
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockManagedIdentitiesService.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    CreateMicrosoftAdDomainRequest actualRequest =
        ((CreateMicrosoftAdDomainRequest) actualRequests.get(0));

    Assert.assertEquals(parent.toString(), actualRequest.getParent());
    Assert.assertEquals(domainName, actualRequest.getDomainName());
    Assert.assertEquals(domain, actualRequest.getDomain());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void createMicrosoftAdDomainExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockManagedIdentitiesService.addException(exception);

    try {
      LocationName parent = LocationName.of("[PROJECT]", "[LOCATION]");
      String domainName = "domainName-1244085905";
      Domain domain = Domain.newBuilder().build();
      client.createMicrosoftAdDomainAsync(parent, domainName, domain).get();
      Assert.fail("No exception raised");
    } catch (ExecutionException e) {
      Assert.assertEquals(InvalidArgumentException.class, e.getCause().getClass());
      InvalidArgumentException apiException = ((InvalidArgumentException) e.getCause());
      Assert.assertEquals(StatusCode.Code.INVALID_ARGUMENT, apiException.getStatusCode().getCode());
    }
  }

  @Test
  public void createMicrosoftAdDomainTest2() throws Exception {
    Domain expectedResponse =
        Domain.newBuilder()
            .setName(DomainName.of("[PROJECT]", "[LOCATION]", "[DOMAIN]").toString())
            .putAllLabels(new HashMap<String, String>())
            .addAllAuthorizedNetworks(new ArrayList<String>())
            .setReservedIpRange("reservedIpRange575015950")
            .addAllLocations(new ArrayList<String>())
            .setAdmin("admin92668751")
            .setFqdn("fqdn3150485")
            .setCreateTime(Timestamp.newBuilder().build())
            .setUpdateTime(Timestamp.newBuilder().build())
            .setStatusMessage("statusMessage-958704715")
            .addAllTrusts(new ArrayList<Trust>())
            .build();
    Operation resultOperation =
        Operation.newBuilder()
            .setName("createMicrosoftAdDomainTest")
            .setDone(true)
            .setResponse(Any.pack(expectedResponse))
            .build();
    mockManagedIdentitiesService.addResponse(resultOperation);

    String parent = "parent-995424086";
    String domainName = "domainName-1244085905";
    Domain domain = Domain.newBuilder().build();

    Domain actualResponse = client.createMicrosoftAdDomainAsync(parent, domainName, domain).get();
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockManagedIdentitiesService.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    CreateMicrosoftAdDomainRequest actualRequest =
        ((CreateMicrosoftAdDomainRequest) actualRequests.get(0));

    Assert.assertEquals(parent, actualRequest.getParent());
    Assert.assertEquals(domainName, actualRequest.getDomainName());
    Assert.assertEquals(domain, actualRequest.getDomain());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void createMicrosoftAdDomainExceptionTest2() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockManagedIdentitiesService.addException(exception);

    try {
      String parent = "parent-995424086";
      String domainName = "domainName-1244085905";
      Domain domain = Domain.newBuilder().build();
      client.createMicrosoftAdDomainAsync(parent, domainName, domain).get();
      Assert.fail("No exception raised");
    } catch (ExecutionException e) {
      Assert.assertEquals(InvalidArgumentException.class, e.getCause().getClass());
      InvalidArgumentException apiException = ((InvalidArgumentException) e.getCause());
      Assert.assertEquals(StatusCode.Code.INVALID_ARGUMENT, apiException.getStatusCode().getCode());
    }
  }

  @Test
  public void resetAdminPasswordTest() throws Exception {
    ResetAdminPasswordResponse expectedResponse =
        ResetAdminPasswordResponse.newBuilder().setPassword("password1216985755").build();
    mockManagedIdentitiesService.addResponse(expectedResponse);

    DomainName name = DomainName.of("[PROJECT]", "[LOCATION]", "[DOMAIN]");

    ResetAdminPasswordResponse actualResponse = client.resetAdminPassword(name);
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockManagedIdentitiesService.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    ResetAdminPasswordRequest actualRequest = ((ResetAdminPasswordRequest) actualRequests.get(0));

    Assert.assertEquals(name.toString(), actualRequest.getName());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void resetAdminPasswordExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockManagedIdentitiesService.addException(exception);

    try {
      DomainName name = DomainName.of("[PROJECT]", "[LOCATION]", "[DOMAIN]");
      client.resetAdminPassword(name);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void resetAdminPasswordTest2() throws Exception {
    ResetAdminPasswordResponse expectedResponse =
        ResetAdminPasswordResponse.newBuilder().setPassword("password1216985755").build();
    mockManagedIdentitiesService.addResponse(expectedResponse);

    String name = "name3373707";

    ResetAdminPasswordResponse actualResponse = client.resetAdminPassword(name);
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockManagedIdentitiesService.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    ResetAdminPasswordRequest actualRequest = ((ResetAdminPasswordRequest) actualRequests.get(0));

    Assert.assertEquals(name, actualRequest.getName());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void resetAdminPasswordExceptionTest2() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockManagedIdentitiesService.addException(exception);

    try {
      String name = "name3373707";
      client.resetAdminPassword(name);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void listDomainsTest() throws Exception {
    Domain responsesElement = Domain.newBuilder().build();
    ListDomainsResponse expectedResponse =
        ListDomainsResponse.newBuilder()
            .setNextPageToken("")
            .addAllDomains(Arrays.asList(responsesElement))
            .build();
    mockManagedIdentitiesService.addResponse(expectedResponse);

    LocationName parent = LocationName.of("[PROJECT]", "[LOCATION]");

    ListDomainsPagedResponse pagedListResponse = client.listDomains(parent);

    List<Domain> resources = Lists.newArrayList(pagedListResponse.iterateAll());

    Assert.assertEquals(1, resources.size());
    Assert.assertEquals(expectedResponse.getDomainsList().get(0), resources.get(0));

    List<AbstractMessage> actualRequests = mockManagedIdentitiesService.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    ListDomainsRequest actualRequest = ((ListDomainsRequest) actualRequests.get(0));

    Assert.assertEquals(parent.toString(), actualRequest.getParent());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void listDomainsExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockManagedIdentitiesService.addException(exception);

    try {
      LocationName parent = LocationName.of("[PROJECT]", "[LOCATION]");
      client.listDomains(parent);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void listDomainsTest2() throws Exception {
    Domain responsesElement = Domain.newBuilder().build();
    ListDomainsResponse expectedResponse =
        ListDomainsResponse.newBuilder()
            .setNextPageToken("")
            .addAllDomains(Arrays.asList(responsesElement))
            .build();
    mockManagedIdentitiesService.addResponse(expectedResponse);

    String parent = "parent-995424086";

    ListDomainsPagedResponse pagedListResponse = client.listDomains(parent);

    List<Domain> resources = Lists.newArrayList(pagedListResponse.iterateAll());

    Assert.assertEquals(1, resources.size());
    Assert.assertEquals(expectedResponse.getDomainsList().get(0), resources.get(0));

    List<AbstractMessage> actualRequests = mockManagedIdentitiesService.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    ListDomainsRequest actualRequest = ((ListDomainsRequest) actualRequests.get(0));

    Assert.assertEquals(parent, actualRequest.getParent());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void listDomainsExceptionTest2() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockManagedIdentitiesService.addException(exception);

    try {
      String parent = "parent-995424086";
      client.listDomains(parent);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void getDomainTest() throws Exception {
    Domain expectedResponse =
        Domain.newBuilder()
            .setName(DomainName.of("[PROJECT]", "[LOCATION]", "[DOMAIN]").toString())
            .putAllLabels(new HashMap<String, String>())
            .addAllAuthorizedNetworks(new ArrayList<String>())
            .setReservedIpRange("reservedIpRange575015950")
            .addAllLocations(new ArrayList<String>())
            .setAdmin("admin92668751")
            .setFqdn("fqdn3150485")
            .setCreateTime(Timestamp.newBuilder().build())
            .setUpdateTime(Timestamp.newBuilder().build())
            .setStatusMessage("statusMessage-958704715")
            .addAllTrusts(new ArrayList<Trust>())
            .build();
    mockManagedIdentitiesService.addResponse(expectedResponse);

    DomainName name = DomainName.of("[PROJECT]", "[LOCATION]", "[DOMAIN]");

    Domain actualResponse = client.getDomain(name);
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockManagedIdentitiesService.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    GetDomainRequest actualRequest = ((GetDomainRequest) actualRequests.get(0));

    Assert.assertEquals(name.toString(), actualRequest.getName());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void getDomainExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockManagedIdentitiesService.addException(exception);

    try {
      DomainName name = DomainName.of("[PROJECT]", "[LOCATION]", "[DOMAIN]");
      client.getDomain(name);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void getDomainTest2() throws Exception {
    Domain expectedResponse =
        Domain.newBuilder()
            .setName(DomainName.of("[PROJECT]", "[LOCATION]", "[DOMAIN]").toString())
            .putAllLabels(new HashMap<String, String>())
            .addAllAuthorizedNetworks(new ArrayList<String>())
            .setReservedIpRange("reservedIpRange575015950")
            .addAllLocations(new ArrayList<String>())
            .setAdmin("admin92668751")
            .setFqdn("fqdn3150485")
            .setCreateTime(Timestamp.newBuilder().build())
            .setUpdateTime(Timestamp.newBuilder().build())
            .setStatusMessage("statusMessage-958704715")
            .addAllTrusts(new ArrayList<Trust>())
            .build();
    mockManagedIdentitiesService.addResponse(expectedResponse);

    String name = "name3373707";

    Domain actualResponse = client.getDomain(name);
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockManagedIdentitiesService.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    GetDomainRequest actualRequest = ((GetDomainRequest) actualRequests.get(0));

    Assert.assertEquals(name, actualRequest.getName());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void getDomainExceptionTest2() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockManagedIdentitiesService.addException(exception);

    try {
      String name = "name3373707";
      client.getDomain(name);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void updateDomainTest() throws Exception {
    Domain expectedResponse =
        Domain.newBuilder()
            .setName(DomainName.of("[PROJECT]", "[LOCATION]", "[DOMAIN]").toString())
            .putAllLabels(new HashMap<String, String>())
            .addAllAuthorizedNetworks(new ArrayList<String>())
            .setReservedIpRange("reservedIpRange575015950")
            .addAllLocations(new ArrayList<String>())
            .setAdmin("admin92668751")
            .setFqdn("fqdn3150485")
            .setCreateTime(Timestamp.newBuilder().build())
            .setUpdateTime(Timestamp.newBuilder().build())
            .setStatusMessage("statusMessage-958704715")
            .addAllTrusts(new ArrayList<Trust>())
            .build();
    Operation resultOperation =
        Operation.newBuilder()
            .setName("updateDomainTest")
            .setDone(true)
            .setResponse(Any.pack(expectedResponse))
            .build();
    mockManagedIdentitiesService.addResponse(resultOperation);

    Domain domain = Domain.newBuilder().build();
    FieldMask updateMask = FieldMask.newBuilder().build();

    Domain actualResponse = client.updateDomainAsync(domain, updateMask).get();
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockManagedIdentitiesService.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    UpdateDomainRequest actualRequest = ((UpdateDomainRequest) actualRequests.get(0));

    Assert.assertEquals(domain, actualRequest.getDomain());
    Assert.assertEquals(updateMask, actualRequest.getUpdateMask());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void updateDomainExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockManagedIdentitiesService.addException(exception);

    try {
      Domain domain = Domain.newBuilder().build();
      FieldMask updateMask = FieldMask.newBuilder().build();
      client.updateDomainAsync(domain, updateMask).get();
      Assert.fail("No exception raised");
    } catch (ExecutionException e) {
      Assert.assertEquals(InvalidArgumentException.class, e.getCause().getClass());
      InvalidArgumentException apiException = ((InvalidArgumentException) e.getCause());
      Assert.assertEquals(StatusCode.Code.INVALID_ARGUMENT, apiException.getStatusCode().getCode());
    }
  }

  @Test
  public void deleteDomainTest() throws Exception {
    Empty expectedResponse = Empty.newBuilder().build();
    Operation resultOperation =
        Operation.newBuilder()
            .setName("deleteDomainTest")
            .setDone(true)
            .setResponse(Any.pack(expectedResponse))
            .build();
    mockManagedIdentitiesService.addResponse(resultOperation);

    DomainName name = DomainName.of("[PROJECT]", "[LOCATION]", "[DOMAIN]");

    client.deleteDomainAsync(name).get();

    List<AbstractMessage> actualRequests = mockManagedIdentitiesService.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    DeleteDomainRequest actualRequest = ((DeleteDomainRequest) actualRequests.get(0));

    Assert.assertEquals(name.toString(), actualRequest.getName());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void deleteDomainExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockManagedIdentitiesService.addException(exception);

    try {
      DomainName name = DomainName.of("[PROJECT]", "[LOCATION]", "[DOMAIN]");
      client.deleteDomainAsync(name).get();
      Assert.fail("No exception raised");
    } catch (ExecutionException e) {
      Assert.assertEquals(InvalidArgumentException.class, e.getCause().getClass());
      InvalidArgumentException apiException = ((InvalidArgumentException) e.getCause());
      Assert.assertEquals(StatusCode.Code.INVALID_ARGUMENT, apiException.getStatusCode().getCode());
    }
  }

  @Test
  public void deleteDomainTest2() throws Exception {
    Empty expectedResponse = Empty.newBuilder().build();
    Operation resultOperation =
        Operation.newBuilder()
            .setName("deleteDomainTest")
            .setDone(true)
            .setResponse(Any.pack(expectedResponse))
            .build();
    mockManagedIdentitiesService.addResponse(resultOperation);

    String name = "name3373707";

    client.deleteDomainAsync(name).get();

    List<AbstractMessage> actualRequests = mockManagedIdentitiesService.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    DeleteDomainRequest actualRequest = ((DeleteDomainRequest) actualRequests.get(0));

    Assert.assertEquals(name, actualRequest.getName());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void deleteDomainExceptionTest2() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockManagedIdentitiesService.addException(exception);

    try {
      String name = "name3373707";
      client.deleteDomainAsync(name).get();
      Assert.fail("No exception raised");
    } catch (ExecutionException e) {
      Assert.assertEquals(InvalidArgumentException.class, e.getCause().getClass());
      InvalidArgumentException apiException = ((InvalidArgumentException) e.getCause());
      Assert.assertEquals(StatusCode.Code.INVALID_ARGUMENT, apiException.getStatusCode().getCode());
    }
  }

  @Test
  public void attachTrustTest() throws Exception {
    Domain expectedResponse =
        Domain.newBuilder()
            .setName(DomainName.of("[PROJECT]", "[LOCATION]", "[DOMAIN]").toString())
            .putAllLabels(new HashMap<String, String>())
            .addAllAuthorizedNetworks(new ArrayList<String>())
            .setReservedIpRange("reservedIpRange575015950")
            .addAllLocations(new ArrayList<String>())
            .setAdmin("admin92668751")
            .setFqdn("fqdn3150485")
            .setCreateTime(Timestamp.newBuilder().build())
            .setUpdateTime(Timestamp.newBuilder().build())
            .setStatusMessage("statusMessage-958704715")
            .addAllTrusts(new ArrayList<Trust>())
            .build();
    Operation resultOperation =
        Operation.newBuilder()
            .setName("attachTrustTest")
            .setDone(true)
            .setResponse(Any.pack(expectedResponse))
            .build();
    mockManagedIdentitiesService.addResponse(resultOperation);

    DomainName name = DomainName.of("[PROJECT]", "[LOCATION]", "[DOMAIN]");
    Trust trust = Trust.newBuilder().build();

    Domain actualResponse = client.attachTrustAsync(name, trust).get();
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockManagedIdentitiesService.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    AttachTrustRequest actualRequest = ((AttachTrustRequest) actualRequests.get(0));

    Assert.assertEquals(name.toString(), actualRequest.getName());
    Assert.assertEquals(trust, actualRequest.getTrust());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void attachTrustExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockManagedIdentitiesService.addException(exception);

    try {
      DomainName name = DomainName.of("[PROJECT]", "[LOCATION]", "[DOMAIN]");
      Trust trust = Trust.newBuilder().build();
      client.attachTrustAsync(name, trust).get();
      Assert.fail("No exception raised");
    } catch (ExecutionException e) {
      Assert.assertEquals(InvalidArgumentException.class, e.getCause().getClass());
      InvalidArgumentException apiException = ((InvalidArgumentException) e.getCause());
      Assert.assertEquals(StatusCode.Code.INVALID_ARGUMENT, apiException.getStatusCode().getCode());
    }
  }

  @Test
  public void attachTrustTest2() throws Exception {
    Domain expectedResponse =
        Domain.newBuilder()
            .setName(DomainName.of("[PROJECT]", "[LOCATION]", "[DOMAIN]").toString())
            .putAllLabels(new HashMap<String, String>())
            .addAllAuthorizedNetworks(new ArrayList<String>())
            .setReservedIpRange("reservedIpRange575015950")
            .addAllLocations(new ArrayList<String>())
            .setAdmin("admin92668751")
            .setFqdn("fqdn3150485")
            .setCreateTime(Timestamp.newBuilder().build())
            .setUpdateTime(Timestamp.newBuilder().build())
            .setStatusMessage("statusMessage-958704715")
            .addAllTrusts(new ArrayList<Trust>())
            .build();
    Operation resultOperation =
        Operation.newBuilder()
            .setName("attachTrustTest")
            .setDone(true)
            .setResponse(Any.pack(expectedResponse))
            .build();
    mockManagedIdentitiesService.addResponse(resultOperation);

    String name = "name3373707";
    Trust trust = Trust.newBuilder().build();

    Domain actualResponse = client.attachTrustAsync(name, trust).get();
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockManagedIdentitiesService.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    AttachTrustRequest actualRequest = ((AttachTrustRequest) actualRequests.get(0));

    Assert.assertEquals(name, actualRequest.getName());
    Assert.assertEquals(trust, actualRequest.getTrust());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void attachTrustExceptionTest2() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockManagedIdentitiesService.addException(exception);

    try {
      String name = "name3373707";
      Trust trust = Trust.newBuilder().build();
      client.attachTrustAsync(name, trust).get();
      Assert.fail("No exception raised");
    } catch (ExecutionException e) {
      Assert.assertEquals(InvalidArgumentException.class, e.getCause().getClass());
      InvalidArgumentException apiException = ((InvalidArgumentException) e.getCause());
      Assert.assertEquals(StatusCode.Code.INVALID_ARGUMENT, apiException.getStatusCode().getCode());
    }
  }

  @Test
  public void reconfigureTrustTest() throws Exception {
    Domain expectedResponse =
        Domain.newBuilder()
            .setName(DomainName.of("[PROJECT]", "[LOCATION]", "[DOMAIN]").toString())
            .putAllLabels(new HashMap<String, String>())
            .addAllAuthorizedNetworks(new ArrayList<String>())
            .setReservedIpRange("reservedIpRange575015950")
            .addAllLocations(new ArrayList<String>())
            .setAdmin("admin92668751")
            .setFqdn("fqdn3150485")
            .setCreateTime(Timestamp.newBuilder().build())
            .setUpdateTime(Timestamp.newBuilder().build())
            .setStatusMessage("statusMessage-958704715")
            .addAllTrusts(new ArrayList<Trust>())
            .build();
    Operation resultOperation =
        Operation.newBuilder()
            .setName("reconfigureTrustTest")
            .setDone(true)
            .setResponse(Any.pack(expectedResponse))
            .build();
    mockManagedIdentitiesService.addResponse(resultOperation);

    DomainName name = DomainName.of("[PROJECT]", "[LOCATION]", "[DOMAIN]");
    String targetDomainName = "targetDomainName2065239520";
    List<String> targetDnsIpAddresses = new ArrayList<>();

    Domain actualResponse =
        client.reconfigureTrustAsync(name, targetDomainName, targetDnsIpAddresses).get();
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockManagedIdentitiesService.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    ReconfigureTrustRequest actualRequest = ((ReconfigureTrustRequest) actualRequests.get(0));

    Assert.assertEquals(name.toString(), actualRequest.getName());
    Assert.assertEquals(targetDomainName, actualRequest.getTargetDomainName());
    Assert.assertEquals(targetDnsIpAddresses, actualRequest.getTargetDnsIpAddressesList());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void reconfigureTrustExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockManagedIdentitiesService.addException(exception);

    try {
      DomainName name = DomainName.of("[PROJECT]", "[LOCATION]", "[DOMAIN]");
      String targetDomainName = "targetDomainName2065239520";
      List<String> targetDnsIpAddresses = new ArrayList<>();
      client.reconfigureTrustAsync(name, targetDomainName, targetDnsIpAddresses).get();
      Assert.fail("No exception raised");
    } catch (ExecutionException e) {
      Assert.assertEquals(InvalidArgumentException.class, e.getCause().getClass());
      InvalidArgumentException apiException = ((InvalidArgumentException) e.getCause());
      Assert.assertEquals(StatusCode.Code.INVALID_ARGUMENT, apiException.getStatusCode().getCode());
    }
  }

  @Test
  public void reconfigureTrustTest2() throws Exception {
    Domain expectedResponse =
        Domain.newBuilder()
            .setName(DomainName.of("[PROJECT]", "[LOCATION]", "[DOMAIN]").toString())
            .putAllLabels(new HashMap<String, String>())
            .addAllAuthorizedNetworks(new ArrayList<String>())
            .setReservedIpRange("reservedIpRange575015950")
            .addAllLocations(new ArrayList<String>())
            .setAdmin("admin92668751")
            .setFqdn("fqdn3150485")
            .setCreateTime(Timestamp.newBuilder().build())
            .setUpdateTime(Timestamp.newBuilder().build())
            .setStatusMessage("statusMessage-958704715")
            .addAllTrusts(new ArrayList<Trust>())
            .build();
    Operation resultOperation =
        Operation.newBuilder()
            .setName("reconfigureTrustTest")
            .setDone(true)
            .setResponse(Any.pack(expectedResponse))
            .build();
    mockManagedIdentitiesService.addResponse(resultOperation);

    String name = "name3373707";
    String targetDomainName = "targetDomainName2065239520";
    List<String> targetDnsIpAddresses = new ArrayList<>();

    Domain actualResponse =
        client.reconfigureTrustAsync(name, targetDomainName, targetDnsIpAddresses).get();
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockManagedIdentitiesService.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    ReconfigureTrustRequest actualRequest = ((ReconfigureTrustRequest) actualRequests.get(0));

    Assert.assertEquals(name, actualRequest.getName());
    Assert.assertEquals(targetDomainName, actualRequest.getTargetDomainName());
    Assert.assertEquals(targetDnsIpAddresses, actualRequest.getTargetDnsIpAddressesList());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void reconfigureTrustExceptionTest2() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockManagedIdentitiesService.addException(exception);

    try {
      String name = "name3373707";
      String targetDomainName = "targetDomainName2065239520";
      List<String> targetDnsIpAddresses = new ArrayList<>();
      client.reconfigureTrustAsync(name, targetDomainName, targetDnsIpAddresses).get();
      Assert.fail("No exception raised");
    } catch (ExecutionException e) {
      Assert.assertEquals(InvalidArgumentException.class, e.getCause().getClass());
      InvalidArgumentException apiException = ((InvalidArgumentException) e.getCause());
      Assert.assertEquals(StatusCode.Code.INVALID_ARGUMENT, apiException.getStatusCode().getCode());
    }
  }

  @Test
  public void detachTrustTest() throws Exception {
    Domain expectedResponse =
        Domain.newBuilder()
            .setName(DomainName.of("[PROJECT]", "[LOCATION]", "[DOMAIN]").toString())
            .putAllLabels(new HashMap<String, String>())
            .addAllAuthorizedNetworks(new ArrayList<String>())
            .setReservedIpRange("reservedIpRange575015950")
            .addAllLocations(new ArrayList<String>())
            .setAdmin("admin92668751")
            .setFqdn("fqdn3150485")
            .setCreateTime(Timestamp.newBuilder().build())
            .setUpdateTime(Timestamp.newBuilder().build())
            .setStatusMessage("statusMessage-958704715")
            .addAllTrusts(new ArrayList<Trust>())
            .build();
    Operation resultOperation =
        Operation.newBuilder()
            .setName("detachTrustTest")
            .setDone(true)
            .setResponse(Any.pack(expectedResponse))
            .build();
    mockManagedIdentitiesService.addResponse(resultOperation);

    DomainName name = DomainName.of("[PROJECT]", "[LOCATION]", "[DOMAIN]");
    Trust trust = Trust.newBuilder().build();

    Domain actualResponse = client.detachTrustAsync(name, trust).get();
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockManagedIdentitiesService.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    DetachTrustRequest actualRequest = ((DetachTrustRequest) actualRequests.get(0));

    Assert.assertEquals(name.toString(), actualRequest.getName());
    Assert.assertEquals(trust, actualRequest.getTrust());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void detachTrustExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockManagedIdentitiesService.addException(exception);

    try {
      DomainName name = DomainName.of("[PROJECT]", "[LOCATION]", "[DOMAIN]");
      Trust trust = Trust.newBuilder().build();
      client.detachTrustAsync(name, trust).get();
      Assert.fail("No exception raised");
    } catch (ExecutionException e) {
      Assert.assertEquals(InvalidArgumentException.class, e.getCause().getClass());
      InvalidArgumentException apiException = ((InvalidArgumentException) e.getCause());
      Assert.assertEquals(StatusCode.Code.INVALID_ARGUMENT, apiException.getStatusCode().getCode());
    }
  }

  @Test
  public void detachTrustTest2() throws Exception {
    Domain expectedResponse =
        Domain.newBuilder()
            .setName(DomainName.of("[PROJECT]", "[LOCATION]", "[DOMAIN]").toString())
            .putAllLabels(new HashMap<String, String>())
            .addAllAuthorizedNetworks(new ArrayList<String>())
            .setReservedIpRange("reservedIpRange575015950")
            .addAllLocations(new ArrayList<String>())
            .setAdmin("admin92668751")
            .setFqdn("fqdn3150485")
            .setCreateTime(Timestamp.newBuilder().build())
            .setUpdateTime(Timestamp.newBuilder().build())
            .setStatusMessage("statusMessage-958704715")
            .addAllTrusts(new ArrayList<Trust>())
            .build();
    Operation resultOperation =
        Operation.newBuilder()
            .setName("detachTrustTest")
            .setDone(true)
            .setResponse(Any.pack(expectedResponse))
            .build();
    mockManagedIdentitiesService.addResponse(resultOperation);

    String name = "name3373707";
    Trust trust = Trust.newBuilder().build();

    Domain actualResponse = client.detachTrustAsync(name, trust).get();
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockManagedIdentitiesService.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    DetachTrustRequest actualRequest = ((DetachTrustRequest) actualRequests.get(0));

    Assert.assertEquals(name, actualRequest.getName());
    Assert.assertEquals(trust, actualRequest.getTrust());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void detachTrustExceptionTest2() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockManagedIdentitiesService.addException(exception);

    try {
      String name = "name3373707";
      Trust trust = Trust.newBuilder().build();
      client.detachTrustAsync(name, trust).get();
      Assert.fail("No exception raised");
    } catch (ExecutionException e) {
      Assert.assertEquals(InvalidArgumentException.class, e.getCause().getClass());
      InvalidArgumentException apiException = ((InvalidArgumentException) e.getCause());
      Assert.assertEquals(StatusCode.Code.INVALID_ARGUMENT, apiException.getStatusCode().getCode());
    }
  }

  @Test
  public void validateTrustTest() throws Exception {
    Domain expectedResponse =
        Domain.newBuilder()
            .setName(DomainName.of("[PROJECT]", "[LOCATION]", "[DOMAIN]").toString())
            .putAllLabels(new HashMap<String, String>())
            .addAllAuthorizedNetworks(new ArrayList<String>())
            .setReservedIpRange("reservedIpRange575015950")
            .addAllLocations(new ArrayList<String>())
            .setAdmin("admin92668751")
            .setFqdn("fqdn3150485")
            .setCreateTime(Timestamp.newBuilder().build())
            .setUpdateTime(Timestamp.newBuilder().build())
            .setStatusMessage("statusMessage-958704715")
            .addAllTrusts(new ArrayList<Trust>())
            .build();
    Operation resultOperation =
        Operation.newBuilder()
            .setName("validateTrustTest")
            .setDone(true)
            .setResponse(Any.pack(expectedResponse))
            .build();
    mockManagedIdentitiesService.addResponse(resultOperation);

    DomainName name = DomainName.of("[PROJECT]", "[LOCATION]", "[DOMAIN]");
    Trust trust = Trust.newBuilder().build();

    Domain actualResponse = client.validateTrustAsync(name, trust).get();
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockManagedIdentitiesService.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    ValidateTrustRequest actualRequest = ((ValidateTrustRequest) actualRequests.get(0));

    Assert.assertEquals(name.toString(), actualRequest.getName());
    Assert.assertEquals(trust, actualRequest.getTrust());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void validateTrustExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockManagedIdentitiesService.addException(exception);

    try {
      DomainName name = DomainName.of("[PROJECT]", "[LOCATION]", "[DOMAIN]");
      Trust trust = Trust.newBuilder().build();
      client.validateTrustAsync(name, trust).get();
      Assert.fail("No exception raised");
    } catch (ExecutionException e) {
      Assert.assertEquals(InvalidArgumentException.class, e.getCause().getClass());
      InvalidArgumentException apiException = ((InvalidArgumentException) e.getCause());
      Assert.assertEquals(StatusCode.Code.INVALID_ARGUMENT, apiException.getStatusCode().getCode());
    }
  }

  @Test
  public void validateTrustTest2() throws Exception {
    Domain expectedResponse =
        Domain.newBuilder()
            .setName(DomainName.of("[PROJECT]", "[LOCATION]", "[DOMAIN]").toString())
            .putAllLabels(new HashMap<String, String>())
            .addAllAuthorizedNetworks(new ArrayList<String>())
            .setReservedIpRange("reservedIpRange575015950")
            .addAllLocations(new ArrayList<String>())
            .setAdmin("admin92668751")
            .setFqdn("fqdn3150485")
            .setCreateTime(Timestamp.newBuilder().build())
            .setUpdateTime(Timestamp.newBuilder().build())
            .setStatusMessage("statusMessage-958704715")
            .addAllTrusts(new ArrayList<Trust>())
            .build();
    Operation resultOperation =
        Operation.newBuilder()
            .setName("validateTrustTest")
            .setDone(true)
            .setResponse(Any.pack(expectedResponse))
            .build();
    mockManagedIdentitiesService.addResponse(resultOperation);

    String name = "name3373707";
    Trust trust = Trust.newBuilder().build();

    Domain actualResponse = client.validateTrustAsync(name, trust).get();
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockManagedIdentitiesService.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    ValidateTrustRequest actualRequest = ((ValidateTrustRequest) actualRequests.get(0));

    Assert.assertEquals(name, actualRequest.getName());
    Assert.assertEquals(trust, actualRequest.getTrust());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void validateTrustExceptionTest2() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockManagedIdentitiesService.addException(exception);

    try {
      String name = "name3373707";
      Trust trust = Trust.newBuilder().build();
      client.validateTrustAsync(name, trust).get();
      Assert.fail("No exception raised");
    } catch (ExecutionException e) {
      Assert.assertEquals(InvalidArgumentException.class, e.getCause().getClass());
      InvalidArgumentException apiException = ((InvalidArgumentException) e.getCause());
      Assert.assertEquals(StatusCode.Code.INVALID_ARGUMENT, apiException.getStatusCode().getCode());
    }
  }
}
