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

package com.google.cloud.apphub.v1;

import static com.google.cloud.apphub.v1.AppHubClient.ListApplicationsPagedResponse;
import static com.google.cloud.apphub.v1.AppHubClient.ListDiscoveredServicesPagedResponse;
import static com.google.cloud.apphub.v1.AppHubClient.ListDiscoveredWorkloadsPagedResponse;
import static com.google.cloud.apphub.v1.AppHubClient.ListLocationsPagedResponse;
import static com.google.cloud.apphub.v1.AppHubClient.ListServiceProjectAttachmentsPagedResponse;
import static com.google.cloud.apphub.v1.AppHubClient.ListServicesPagedResponse;
import static com.google.cloud.apphub.v1.AppHubClient.ListWorkloadsPagedResponse;

import com.google.api.gax.core.NoCredentialsProvider;
import com.google.api.gax.grpc.GaxGrpcProperties;
import com.google.api.gax.grpc.testing.LocalChannelProvider;
import com.google.api.gax.grpc.testing.MockGrpcService;
import com.google.api.gax.grpc.testing.MockServiceHelper;
import com.google.api.gax.rpc.ApiClientHeaderProvider;
import com.google.api.gax.rpc.InvalidArgumentException;
import com.google.api.gax.rpc.StatusCode;
import com.google.cloud.location.GetLocationRequest;
import com.google.cloud.location.ListLocationsRequest;
import com.google.cloud.location.ListLocationsResponse;
import com.google.cloud.location.Location;
import com.google.common.collect.Lists;
import com.google.iam.v1.AuditConfig;
import com.google.iam.v1.Binding;
import com.google.iam.v1.GetIamPolicyRequest;
import com.google.iam.v1.GetPolicyOptions;
import com.google.iam.v1.Policy;
import com.google.iam.v1.SetIamPolicyRequest;
import com.google.iam.v1.TestIamPermissionsRequest;
import com.google.iam.v1.TestIamPermissionsResponse;
import com.google.longrunning.Operation;
import com.google.protobuf.AbstractMessage;
import com.google.protobuf.Any;
import com.google.protobuf.ByteString;
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
public class AppHubClientTest {
  private static MockAppHub mockAppHub;
  private static MockIAMPolicy mockIAMPolicy;
  private static MockLocations mockLocations;
  private static MockServiceHelper mockServiceHelper;
  private LocalChannelProvider channelProvider;
  private AppHubClient client;

  @BeforeClass
  public static void startStaticServer() {
    mockAppHub = new MockAppHub();
    mockLocations = new MockLocations();
    mockIAMPolicy = new MockIAMPolicy();
    mockServiceHelper =
        new MockServiceHelper(
            UUID.randomUUID().toString(),
            Arrays.<MockGrpcService>asList(mockAppHub, mockLocations, mockIAMPolicy));
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
    AppHubSettings settings =
        AppHubSettings.newBuilder()
            .setTransportChannelProvider(channelProvider)
            .setCredentialsProvider(NoCredentialsProvider.create())
            .build();
    client = AppHubClient.create(settings);
  }

  @After
  public void tearDown() throws Exception {
    client.close();
  }

  @Test
  public void lookupServiceProjectAttachmentTest() throws Exception {
    LookupServiceProjectAttachmentResponse expectedResponse =
        LookupServiceProjectAttachmentResponse.newBuilder()
            .setServiceProjectAttachment(ServiceProjectAttachment.newBuilder().build())
            .build();
    mockAppHub.addResponse(expectedResponse);

    LocationName name = LocationName.of("[PROJECT]", "[LOCATION]");

    LookupServiceProjectAttachmentResponse actualResponse =
        client.lookupServiceProjectAttachment(name);
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockAppHub.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    LookupServiceProjectAttachmentRequest actualRequest =
        ((LookupServiceProjectAttachmentRequest) actualRequests.get(0));

    Assert.assertEquals(name.toString(), actualRequest.getName());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void lookupServiceProjectAttachmentExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockAppHub.addException(exception);

    try {
      LocationName name = LocationName.of("[PROJECT]", "[LOCATION]");
      client.lookupServiceProjectAttachment(name);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void lookupServiceProjectAttachmentTest2() throws Exception {
    LookupServiceProjectAttachmentResponse expectedResponse =
        LookupServiceProjectAttachmentResponse.newBuilder()
            .setServiceProjectAttachment(ServiceProjectAttachment.newBuilder().build())
            .build();
    mockAppHub.addResponse(expectedResponse);

    String name = "name3373707";

    LookupServiceProjectAttachmentResponse actualResponse =
        client.lookupServiceProjectAttachment(name);
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockAppHub.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    LookupServiceProjectAttachmentRequest actualRequest =
        ((LookupServiceProjectAttachmentRequest) actualRequests.get(0));

    Assert.assertEquals(name, actualRequest.getName());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void lookupServiceProjectAttachmentExceptionTest2() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockAppHub.addException(exception);

    try {
      String name = "name3373707";
      client.lookupServiceProjectAttachment(name);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void listServiceProjectAttachmentsTest() throws Exception {
    ServiceProjectAttachment responsesElement = ServiceProjectAttachment.newBuilder().build();
    ListServiceProjectAttachmentsResponse expectedResponse =
        ListServiceProjectAttachmentsResponse.newBuilder()
            .setNextPageToken("")
            .addAllServiceProjectAttachments(Arrays.asList(responsesElement))
            .build();
    mockAppHub.addResponse(expectedResponse);

    LocationName parent = LocationName.of("[PROJECT]", "[LOCATION]");

    ListServiceProjectAttachmentsPagedResponse pagedListResponse =
        client.listServiceProjectAttachments(parent);

    List<ServiceProjectAttachment> resources = Lists.newArrayList(pagedListResponse.iterateAll());

    Assert.assertEquals(1, resources.size());
    Assert.assertEquals(
        expectedResponse.getServiceProjectAttachmentsList().get(0), resources.get(0));

    List<AbstractMessage> actualRequests = mockAppHub.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    ListServiceProjectAttachmentsRequest actualRequest =
        ((ListServiceProjectAttachmentsRequest) actualRequests.get(0));

    Assert.assertEquals(parent.toString(), actualRequest.getParent());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void listServiceProjectAttachmentsExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockAppHub.addException(exception);

    try {
      LocationName parent = LocationName.of("[PROJECT]", "[LOCATION]");
      client.listServiceProjectAttachments(parent);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void listServiceProjectAttachmentsTest2() throws Exception {
    ServiceProjectAttachment responsesElement = ServiceProjectAttachment.newBuilder().build();
    ListServiceProjectAttachmentsResponse expectedResponse =
        ListServiceProjectAttachmentsResponse.newBuilder()
            .setNextPageToken("")
            .addAllServiceProjectAttachments(Arrays.asList(responsesElement))
            .build();
    mockAppHub.addResponse(expectedResponse);

    String parent = "parent-995424086";

    ListServiceProjectAttachmentsPagedResponse pagedListResponse =
        client.listServiceProjectAttachments(parent);

    List<ServiceProjectAttachment> resources = Lists.newArrayList(pagedListResponse.iterateAll());

    Assert.assertEquals(1, resources.size());
    Assert.assertEquals(
        expectedResponse.getServiceProjectAttachmentsList().get(0), resources.get(0));

    List<AbstractMessage> actualRequests = mockAppHub.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    ListServiceProjectAttachmentsRequest actualRequest =
        ((ListServiceProjectAttachmentsRequest) actualRequests.get(0));

    Assert.assertEquals(parent, actualRequest.getParent());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void listServiceProjectAttachmentsExceptionTest2() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockAppHub.addException(exception);

    try {
      String parent = "parent-995424086";
      client.listServiceProjectAttachments(parent);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void createServiceProjectAttachmentTest() throws Exception {
    ServiceProjectAttachment expectedResponse =
        ServiceProjectAttachment.newBuilder()
            .setName(
                ServiceProjectAttachmentName.of(
                        "[PROJECT]", "[LOCATION]", "[SERVICE_PROJECT_ATTACHMENT]")
                    .toString())
            .setServiceProject("serviceProject1947145892")
            .setCreateTime(Timestamp.newBuilder().build())
            .setUid("uid115792")
            .build();
    Operation resultOperation =
        Operation.newBuilder()
            .setName("createServiceProjectAttachmentTest")
            .setDone(true)
            .setResponse(Any.pack(expectedResponse))
            .build();
    mockAppHub.addResponse(resultOperation);

    LocationName parent = LocationName.of("[PROJECT]", "[LOCATION]");
    ServiceProjectAttachment serviceProjectAttachment =
        ServiceProjectAttachment.newBuilder().build();
    String serviceProjectAttachmentId = "serviceProjectAttachmentId-1738589598";

    ServiceProjectAttachment actualResponse =
        client
            .createServiceProjectAttachmentAsync(
                parent, serviceProjectAttachment, serviceProjectAttachmentId)
            .get();
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockAppHub.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    CreateServiceProjectAttachmentRequest actualRequest =
        ((CreateServiceProjectAttachmentRequest) actualRequests.get(0));

    Assert.assertEquals(parent.toString(), actualRequest.getParent());
    Assert.assertEquals(serviceProjectAttachment, actualRequest.getServiceProjectAttachment());
    Assert.assertEquals(serviceProjectAttachmentId, actualRequest.getServiceProjectAttachmentId());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void createServiceProjectAttachmentExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockAppHub.addException(exception);

    try {
      LocationName parent = LocationName.of("[PROJECT]", "[LOCATION]");
      ServiceProjectAttachment serviceProjectAttachment =
          ServiceProjectAttachment.newBuilder().build();
      String serviceProjectAttachmentId = "serviceProjectAttachmentId-1738589598";
      client
          .createServiceProjectAttachmentAsync(
              parent, serviceProjectAttachment, serviceProjectAttachmentId)
          .get();
      Assert.fail("No exception raised");
    } catch (ExecutionException e) {
      Assert.assertEquals(InvalidArgumentException.class, e.getCause().getClass());
      InvalidArgumentException apiException = ((InvalidArgumentException) e.getCause());
      Assert.assertEquals(StatusCode.Code.INVALID_ARGUMENT, apiException.getStatusCode().getCode());
    }
  }

  @Test
  public void createServiceProjectAttachmentTest2() throws Exception {
    ServiceProjectAttachment expectedResponse =
        ServiceProjectAttachment.newBuilder()
            .setName(
                ServiceProjectAttachmentName.of(
                        "[PROJECT]", "[LOCATION]", "[SERVICE_PROJECT_ATTACHMENT]")
                    .toString())
            .setServiceProject("serviceProject1947145892")
            .setCreateTime(Timestamp.newBuilder().build())
            .setUid("uid115792")
            .build();
    Operation resultOperation =
        Operation.newBuilder()
            .setName("createServiceProjectAttachmentTest")
            .setDone(true)
            .setResponse(Any.pack(expectedResponse))
            .build();
    mockAppHub.addResponse(resultOperation);

    String parent = "parent-995424086";
    ServiceProjectAttachment serviceProjectAttachment =
        ServiceProjectAttachment.newBuilder().build();
    String serviceProjectAttachmentId = "serviceProjectAttachmentId-1738589598";

    ServiceProjectAttachment actualResponse =
        client
            .createServiceProjectAttachmentAsync(
                parent, serviceProjectAttachment, serviceProjectAttachmentId)
            .get();
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockAppHub.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    CreateServiceProjectAttachmentRequest actualRequest =
        ((CreateServiceProjectAttachmentRequest) actualRequests.get(0));

    Assert.assertEquals(parent, actualRequest.getParent());
    Assert.assertEquals(serviceProjectAttachment, actualRequest.getServiceProjectAttachment());
    Assert.assertEquals(serviceProjectAttachmentId, actualRequest.getServiceProjectAttachmentId());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void createServiceProjectAttachmentExceptionTest2() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockAppHub.addException(exception);

    try {
      String parent = "parent-995424086";
      ServiceProjectAttachment serviceProjectAttachment =
          ServiceProjectAttachment.newBuilder().build();
      String serviceProjectAttachmentId = "serviceProjectAttachmentId-1738589598";
      client
          .createServiceProjectAttachmentAsync(
              parent, serviceProjectAttachment, serviceProjectAttachmentId)
          .get();
      Assert.fail("No exception raised");
    } catch (ExecutionException e) {
      Assert.assertEquals(InvalidArgumentException.class, e.getCause().getClass());
      InvalidArgumentException apiException = ((InvalidArgumentException) e.getCause());
      Assert.assertEquals(StatusCode.Code.INVALID_ARGUMENT, apiException.getStatusCode().getCode());
    }
  }

  @Test
  public void getServiceProjectAttachmentTest() throws Exception {
    ServiceProjectAttachment expectedResponse =
        ServiceProjectAttachment.newBuilder()
            .setName(
                ServiceProjectAttachmentName.of(
                        "[PROJECT]", "[LOCATION]", "[SERVICE_PROJECT_ATTACHMENT]")
                    .toString())
            .setServiceProject("serviceProject1947145892")
            .setCreateTime(Timestamp.newBuilder().build())
            .setUid("uid115792")
            .build();
    mockAppHub.addResponse(expectedResponse);

    ServiceProjectAttachmentName name =
        ServiceProjectAttachmentName.of("[PROJECT]", "[LOCATION]", "[SERVICE_PROJECT_ATTACHMENT]");

    ServiceProjectAttachment actualResponse = client.getServiceProjectAttachment(name);
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockAppHub.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    GetServiceProjectAttachmentRequest actualRequest =
        ((GetServiceProjectAttachmentRequest) actualRequests.get(0));

    Assert.assertEquals(name.toString(), actualRequest.getName());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void getServiceProjectAttachmentExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockAppHub.addException(exception);

    try {
      ServiceProjectAttachmentName name =
          ServiceProjectAttachmentName.of(
              "[PROJECT]", "[LOCATION]", "[SERVICE_PROJECT_ATTACHMENT]");
      client.getServiceProjectAttachment(name);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void getServiceProjectAttachmentTest2() throws Exception {
    ServiceProjectAttachment expectedResponse =
        ServiceProjectAttachment.newBuilder()
            .setName(
                ServiceProjectAttachmentName.of(
                        "[PROJECT]", "[LOCATION]", "[SERVICE_PROJECT_ATTACHMENT]")
                    .toString())
            .setServiceProject("serviceProject1947145892")
            .setCreateTime(Timestamp.newBuilder().build())
            .setUid("uid115792")
            .build();
    mockAppHub.addResponse(expectedResponse);

    String name = "name3373707";

    ServiceProjectAttachment actualResponse = client.getServiceProjectAttachment(name);
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockAppHub.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    GetServiceProjectAttachmentRequest actualRequest =
        ((GetServiceProjectAttachmentRequest) actualRequests.get(0));

    Assert.assertEquals(name, actualRequest.getName());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void getServiceProjectAttachmentExceptionTest2() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockAppHub.addException(exception);

    try {
      String name = "name3373707";
      client.getServiceProjectAttachment(name);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void deleteServiceProjectAttachmentTest() throws Exception {
    Empty expectedResponse = Empty.newBuilder().build();
    Operation resultOperation =
        Operation.newBuilder()
            .setName("deleteServiceProjectAttachmentTest")
            .setDone(true)
            .setResponse(Any.pack(expectedResponse))
            .build();
    mockAppHub.addResponse(resultOperation);

    ServiceProjectAttachmentName name =
        ServiceProjectAttachmentName.of("[PROJECT]", "[LOCATION]", "[SERVICE_PROJECT_ATTACHMENT]");

    client.deleteServiceProjectAttachmentAsync(name).get();

    List<AbstractMessage> actualRequests = mockAppHub.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    DeleteServiceProjectAttachmentRequest actualRequest =
        ((DeleteServiceProjectAttachmentRequest) actualRequests.get(0));

    Assert.assertEquals(name.toString(), actualRequest.getName());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void deleteServiceProjectAttachmentExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockAppHub.addException(exception);

    try {
      ServiceProjectAttachmentName name =
          ServiceProjectAttachmentName.of(
              "[PROJECT]", "[LOCATION]", "[SERVICE_PROJECT_ATTACHMENT]");
      client.deleteServiceProjectAttachmentAsync(name).get();
      Assert.fail("No exception raised");
    } catch (ExecutionException e) {
      Assert.assertEquals(InvalidArgumentException.class, e.getCause().getClass());
      InvalidArgumentException apiException = ((InvalidArgumentException) e.getCause());
      Assert.assertEquals(StatusCode.Code.INVALID_ARGUMENT, apiException.getStatusCode().getCode());
    }
  }

  @Test
  public void deleteServiceProjectAttachmentTest2() throws Exception {
    Empty expectedResponse = Empty.newBuilder().build();
    Operation resultOperation =
        Operation.newBuilder()
            .setName("deleteServiceProjectAttachmentTest")
            .setDone(true)
            .setResponse(Any.pack(expectedResponse))
            .build();
    mockAppHub.addResponse(resultOperation);

    String name = "name3373707";

    client.deleteServiceProjectAttachmentAsync(name).get();

    List<AbstractMessage> actualRequests = mockAppHub.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    DeleteServiceProjectAttachmentRequest actualRequest =
        ((DeleteServiceProjectAttachmentRequest) actualRequests.get(0));

    Assert.assertEquals(name, actualRequest.getName());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void deleteServiceProjectAttachmentExceptionTest2() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockAppHub.addException(exception);

    try {
      String name = "name3373707";
      client.deleteServiceProjectAttachmentAsync(name).get();
      Assert.fail("No exception raised");
    } catch (ExecutionException e) {
      Assert.assertEquals(InvalidArgumentException.class, e.getCause().getClass());
      InvalidArgumentException apiException = ((InvalidArgumentException) e.getCause());
      Assert.assertEquals(StatusCode.Code.INVALID_ARGUMENT, apiException.getStatusCode().getCode());
    }
  }

  @Test
  public void detachServiceProjectAttachmentTest() throws Exception {
    DetachServiceProjectAttachmentResponse expectedResponse =
        DetachServiceProjectAttachmentResponse.newBuilder().build();
    mockAppHub.addResponse(expectedResponse);

    LocationName name = LocationName.of("[PROJECT]", "[LOCATION]");

    DetachServiceProjectAttachmentResponse actualResponse =
        client.detachServiceProjectAttachment(name);
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockAppHub.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    DetachServiceProjectAttachmentRequest actualRequest =
        ((DetachServiceProjectAttachmentRequest) actualRequests.get(0));

    Assert.assertEquals(name.toString(), actualRequest.getName());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void detachServiceProjectAttachmentExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockAppHub.addException(exception);

    try {
      LocationName name = LocationName.of("[PROJECT]", "[LOCATION]");
      client.detachServiceProjectAttachment(name);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void detachServiceProjectAttachmentTest2() throws Exception {
    DetachServiceProjectAttachmentResponse expectedResponse =
        DetachServiceProjectAttachmentResponse.newBuilder().build();
    mockAppHub.addResponse(expectedResponse);

    String name = "name3373707";

    DetachServiceProjectAttachmentResponse actualResponse =
        client.detachServiceProjectAttachment(name);
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockAppHub.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    DetachServiceProjectAttachmentRequest actualRequest =
        ((DetachServiceProjectAttachmentRequest) actualRequests.get(0));

    Assert.assertEquals(name, actualRequest.getName());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void detachServiceProjectAttachmentExceptionTest2() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockAppHub.addException(exception);

    try {
      String name = "name3373707";
      client.detachServiceProjectAttachment(name);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void listDiscoveredServicesTest() throws Exception {
    DiscoveredService responsesElement = DiscoveredService.newBuilder().build();
    ListDiscoveredServicesResponse expectedResponse =
        ListDiscoveredServicesResponse.newBuilder()
            .setNextPageToken("")
            .addAllDiscoveredServices(Arrays.asList(responsesElement))
            .build();
    mockAppHub.addResponse(expectedResponse);

    LocationName parent = LocationName.of("[PROJECT]", "[LOCATION]");

    ListDiscoveredServicesPagedResponse pagedListResponse = client.listDiscoveredServices(parent);

    List<DiscoveredService> resources = Lists.newArrayList(pagedListResponse.iterateAll());

    Assert.assertEquals(1, resources.size());
    Assert.assertEquals(expectedResponse.getDiscoveredServicesList().get(0), resources.get(0));

    List<AbstractMessage> actualRequests = mockAppHub.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    ListDiscoveredServicesRequest actualRequest =
        ((ListDiscoveredServicesRequest) actualRequests.get(0));

    Assert.assertEquals(parent.toString(), actualRequest.getParent());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void listDiscoveredServicesExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockAppHub.addException(exception);

    try {
      LocationName parent = LocationName.of("[PROJECT]", "[LOCATION]");
      client.listDiscoveredServices(parent);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void listDiscoveredServicesTest2() throws Exception {
    DiscoveredService responsesElement = DiscoveredService.newBuilder().build();
    ListDiscoveredServicesResponse expectedResponse =
        ListDiscoveredServicesResponse.newBuilder()
            .setNextPageToken("")
            .addAllDiscoveredServices(Arrays.asList(responsesElement))
            .build();
    mockAppHub.addResponse(expectedResponse);

    String parent = "parent-995424086";

    ListDiscoveredServicesPagedResponse pagedListResponse = client.listDiscoveredServices(parent);

    List<DiscoveredService> resources = Lists.newArrayList(pagedListResponse.iterateAll());

    Assert.assertEquals(1, resources.size());
    Assert.assertEquals(expectedResponse.getDiscoveredServicesList().get(0), resources.get(0));

    List<AbstractMessage> actualRequests = mockAppHub.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    ListDiscoveredServicesRequest actualRequest =
        ((ListDiscoveredServicesRequest) actualRequests.get(0));

    Assert.assertEquals(parent, actualRequest.getParent());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void listDiscoveredServicesExceptionTest2() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockAppHub.addException(exception);

    try {
      String parent = "parent-995424086";
      client.listDiscoveredServices(parent);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void getDiscoveredServiceTest() throws Exception {
    DiscoveredService expectedResponse =
        DiscoveredService.newBuilder()
            .setName(
                DiscoveredServiceName.of("[PROJECT]", "[LOCATION]", "[DISCOVERED_SERVICE]")
                    .toString())
            .setServiceReference(ServiceReference.newBuilder().build())
            .setServiceProperties(ServiceProperties.newBuilder().build())
            .build();
    mockAppHub.addResponse(expectedResponse);

    DiscoveredServiceName name =
        DiscoveredServiceName.of("[PROJECT]", "[LOCATION]", "[DISCOVERED_SERVICE]");

    DiscoveredService actualResponse = client.getDiscoveredService(name);
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockAppHub.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    GetDiscoveredServiceRequest actualRequest =
        ((GetDiscoveredServiceRequest) actualRequests.get(0));

    Assert.assertEquals(name.toString(), actualRequest.getName());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void getDiscoveredServiceExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockAppHub.addException(exception);

    try {
      DiscoveredServiceName name =
          DiscoveredServiceName.of("[PROJECT]", "[LOCATION]", "[DISCOVERED_SERVICE]");
      client.getDiscoveredService(name);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void getDiscoveredServiceTest2() throws Exception {
    DiscoveredService expectedResponse =
        DiscoveredService.newBuilder()
            .setName(
                DiscoveredServiceName.of("[PROJECT]", "[LOCATION]", "[DISCOVERED_SERVICE]")
                    .toString())
            .setServiceReference(ServiceReference.newBuilder().build())
            .setServiceProperties(ServiceProperties.newBuilder().build())
            .build();
    mockAppHub.addResponse(expectedResponse);

    String name = "name3373707";

    DiscoveredService actualResponse = client.getDiscoveredService(name);
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockAppHub.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    GetDiscoveredServiceRequest actualRequest =
        ((GetDiscoveredServiceRequest) actualRequests.get(0));

    Assert.assertEquals(name, actualRequest.getName());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void getDiscoveredServiceExceptionTest2() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockAppHub.addException(exception);

    try {
      String name = "name3373707";
      client.getDiscoveredService(name);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void lookupDiscoveredServiceTest() throws Exception {
    LookupDiscoveredServiceResponse expectedResponse =
        LookupDiscoveredServiceResponse.newBuilder()
            .setDiscoveredService(DiscoveredService.newBuilder().build())
            .build();
    mockAppHub.addResponse(expectedResponse);

    LocationName parent = LocationName.of("[PROJECT]", "[LOCATION]");
    String uri = "uri116076";

    LookupDiscoveredServiceResponse actualResponse = client.lookupDiscoveredService(parent, uri);
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockAppHub.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    LookupDiscoveredServiceRequest actualRequest =
        ((LookupDiscoveredServiceRequest) actualRequests.get(0));

    Assert.assertEquals(parent.toString(), actualRequest.getParent());
    Assert.assertEquals(uri, actualRequest.getUri());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void lookupDiscoveredServiceExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockAppHub.addException(exception);

    try {
      LocationName parent = LocationName.of("[PROJECT]", "[LOCATION]");
      String uri = "uri116076";
      client.lookupDiscoveredService(parent, uri);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void lookupDiscoveredServiceTest2() throws Exception {
    LookupDiscoveredServiceResponse expectedResponse =
        LookupDiscoveredServiceResponse.newBuilder()
            .setDiscoveredService(DiscoveredService.newBuilder().build())
            .build();
    mockAppHub.addResponse(expectedResponse);

    String parent = "parent-995424086";
    String uri = "uri116076";

    LookupDiscoveredServiceResponse actualResponse = client.lookupDiscoveredService(parent, uri);
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockAppHub.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    LookupDiscoveredServiceRequest actualRequest =
        ((LookupDiscoveredServiceRequest) actualRequests.get(0));

    Assert.assertEquals(parent, actualRequest.getParent());
    Assert.assertEquals(uri, actualRequest.getUri());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void lookupDiscoveredServiceExceptionTest2() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockAppHub.addException(exception);

    try {
      String parent = "parent-995424086";
      String uri = "uri116076";
      client.lookupDiscoveredService(parent, uri);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void listServicesTest() throws Exception {
    Service responsesElement = Service.newBuilder().build();
    ListServicesResponse expectedResponse =
        ListServicesResponse.newBuilder()
            .setNextPageToken("")
            .addAllServices(Arrays.asList(responsesElement))
            .build();
    mockAppHub.addResponse(expectedResponse);

    ApplicationName parent = ApplicationName.of("[PROJECT]", "[LOCATION]", "[APPLICATION]");

    ListServicesPagedResponse pagedListResponse = client.listServices(parent);

    List<Service> resources = Lists.newArrayList(pagedListResponse.iterateAll());

    Assert.assertEquals(1, resources.size());
    Assert.assertEquals(expectedResponse.getServicesList().get(0), resources.get(0));

    List<AbstractMessage> actualRequests = mockAppHub.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    ListServicesRequest actualRequest = ((ListServicesRequest) actualRequests.get(0));

    Assert.assertEquals(parent.toString(), actualRequest.getParent());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void listServicesExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockAppHub.addException(exception);

    try {
      ApplicationName parent = ApplicationName.of("[PROJECT]", "[LOCATION]", "[APPLICATION]");
      client.listServices(parent);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void listServicesTest2() throws Exception {
    Service responsesElement = Service.newBuilder().build();
    ListServicesResponse expectedResponse =
        ListServicesResponse.newBuilder()
            .setNextPageToken("")
            .addAllServices(Arrays.asList(responsesElement))
            .build();
    mockAppHub.addResponse(expectedResponse);

    String parent = "parent-995424086";

    ListServicesPagedResponse pagedListResponse = client.listServices(parent);

    List<Service> resources = Lists.newArrayList(pagedListResponse.iterateAll());

    Assert.assertEquals(1, resources.size());
    Assert.assertEquals(expectedResponse.getServicesList().get(0), resources.get(0));

    List<AbstractMessage> actualRequests = mockAppHub.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    ListServicesRequest actualRequest = ((ListServicesRequest) actualRequests.get(0));

    Assert.assertEquals(parent, actualRequest.getParent());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void listServicesExceptionTest2() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockAppHub.addException(exception);

    try {
      String parent = "parent-995424086";
      client.listServices(parent);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void createServiceTest() throws Exception {
    Service expectedResponse =
        Service.newBuilder()
            .setName(
                ServiceName.of("[PROJECT]", "[LOCATION]", "[APPLICATION]", "[SERVICE]").toString())
            .setDisplayName("displayName1714148973")
            .setDescription("description-1724546052")
            .setServiceReference(ServiceReference.newBuilder().build())
            .setServiceProperties(ServiceProperties.newBuilder().build())
            .setAttributes(Attributes.newBuilder().build())
            .setDiscoveredService(LocationName.of("[PROJECT]", "[LOCATION]").toString())
            .setCreateTime(Timestamp.newBuilder().build())
            .setUpdateTime(Timestamp.newBuilder().build())
            .setUid("uid115792")
            .build();
    Operation resultOperation =
        Operation.newBuilder()
            .setName("createServiceTest")
            .setDone(true)
            .setResponse(Any.pack(expectedResponse))
            .build();
    mockAppHub.addResponse(resultOperation);

    ApplicationName parent = ApplicationName.of("[PROJECT]", "[LOCATION]", "[APPLICATION]");
    Service service = Service.newBuilder().build();
    String serviceId = "serviceId-194185552";

    Service actualResponse = client.createServiceAsync(parent, service, serviceId).get();
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockAppHub.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    CreateServiceRequest actualRequest = ((CreateServiceRequest) actualRequests.get(0));

    Assert.assertEquals(parent.toString(), actualRequest.getParent());
    Assert.assertEquals(service, actualRequest.getService());
    Assert.assertEquals(serviceId, actualRequest.getServiceId());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void createServiceExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockAppHub.addException(exception);

    try {
      ApplicationName parent = ApplicationName.of("[PROJECT]", "[LOCATION]", "[APPLICATION]");
      Service service = Service.newBuilder().build();
      String serviceId = "serviceId-194185552";
      client.createServiceAsync(parent, service, serviceId).get();
      Assert.fail("No exception raised");
    } catch (ExecutionException e) {
      Assert.assertEquals(InvalidArgumentException.class, e.getCause().getClass());
      InvalidArgumentException apiException = ((InvalidArgumentException) e.getCause());
      Assert.assertEquals(StatusCode.Code.INVALID_ARGUMENT, apiException.getStatusCode().getCode());
    }
  }

  @Test
  public void createServiceTest2() throws Exception {
    Service expectedResponse =
        Service.newBuilder()
            .setName(
                ServiceName.of("[PROJECT]", "[LOCATION]", "[APPLICATION]", "[SERVICE]").toString())
            .setDisplayName("displayName1714148973")
            .setDescription("description-1724546052")
            .setServiceReference(ServiceReference.newBuilder().build())
            .setServiceProperties(ServiceProperties.newBuilder().build())
            .setAttributes(Attributes.newBuilder().build())
            .setDiscoveredService(LocationName.of("[PROJECT]", "[LOCATION]").toString())
            .setCreateTime(Timestamp.newBuilder().build())
            .setUpdateTime(Timestamp.newBuilder().build())
            .setUid("uid115792")
            .build();
    Operation resultOperation =
        Operation.newBuilder()
            .setName("createServiceTest")
            .setDone(true)
            .setResponse(Any.pack(expectedResponse))
            .build();
    mockAppHub.addResponse(resultOperation);

    String parent = "parent-995424086";
    Service service = Service.newBuilder().build();
    String serviceId = "serviceId-194185552";

    Service actualResponse = client.createServiceAsync(parent, service, serviceId).get();
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockAppHub.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    CreateServiceRequest actualRequest = ((CreateServiceRequest) actualRequests.get(0));

    Assert.assertEquals(parent, actualRequest.getParent());
    Assert.assertEquals(service, actualRequest.getService());
    Assert.assertEquals(serviceId, actualRequest.getServiceId());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void createServiceExceptionTest2() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockAppHub.addException(exception);

    try {
      String parent = "parent-995424086";
      Service service = Service.newBuilder().build();
      String serviceId = "serviceId-194185552";
      client.createServiceAsync(parent, service, serviceId).get();
      Assert.fail("No exception raised");
    } catch (ExecutionException e) {
      Assert.assertEquals(InvalidArgumentException.class, e.getCause().getClass());
      InvalidArgumentException apiException = ((InvalidArgumentException) e.getCause());
      Assert.assertEquals(StatusCode.Code.INVALID_ARGUMENT, apiException.getStatusCode().getCode());
    }
  }

  @Test
  public void getServiceTest() throws Exception {
    Service expectedResponse =
        Service.newBuilder()
            .setName(
                ServiceName.of("[PROJECT]", "[LOCATION]", "[APPLICATION]", "[SERVICE]").toString())
            .setDisplayName("displayName1714148973")
            .setDescription("description-1724546052")
            .setServiceReference(ServiceReference.newBuilder().build())
            .setServiceProperties(ServiceProperties.newBuilder().build())
            .setAttributes(Attributes.newBuilder().build())
            .setDiscoveredService(LocationName.of("[PROJECT]", "[LOCATION]").toString())
            .setCreateTime(Timestamp.newBuilder().build())
            .setUpdateTime(Timestamp.newBuilder().build())
            .setUid("uid115792")
            .build();
    mockAppHub.addResponse(expectedResponse);

    ServiceName name = ServiceName.of("[PROJECT]", "[LOCATION]", "[APPLICATION]", "[SERVICE]");

    Service actualResponse = client.getService(name);
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockAppHub.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    GetServiceRequest actualRequest = ((GetServiceRequest) actualRequests.get(0));

    Assert.assertEquals(name.toString(), actualRequest.getName());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void getServiceExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockAppHub.addException(exception);

    try {
      ServiceName name = ServiceName.of("[PROJECT]", "[LOCATION]", "[APPLICATION]", "[SERVICE]");
      client.getService(name);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void getServiceTest2() throws Exception {
    Service expectedResponse =
        Service.newBuilder()
            .setName(
                ServiceName.of("[PROJECT]", "[LOCATION]", "[APPLICATION]", "[SERVICE]").toString())
            .setDisplayName("displayName1714148973")
            .setDescription("description-1724546052")
            .setServiceReference(ServiceReference.newBuilder().build())
            .setServiceProperties(ServiceProperties.newBuilder().build())
            .setAttributes(Attributes.newBuilder().build())
            .setDiscoveredService(LocationName.of("[PROJECT]", "[LOCATION]").toString())
            .setCreateTime(Timestamp.newBuilder().build())
            .setUpdateTime(Timestamp.newBuilder().build())
            .setUid("uid115792")
            .build();
    mockAppHub.addResponse(expectedResponse);

    String name = "name3373707";

    Service actualResponse = client.getService(name);
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockAppHub.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    GetServiceRequest actualRequest = ((GetServiceRequest) actualRequests.get(0));

    Assert.assertEquals(name, actualRequest.getName());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void getServiceExceptionTest2() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockAppHub.addException(exception);

    try {
      String name = "name3373707";
      client.getService(name);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void updateServiceTest() throws Exception {
    Service expectedResponse =
        Service.newBuilder()
            .setName(
                ServiceName.of("[PROJECT]", "[LOCATION]", "[APPLICATION]", "[SERVICE]").toString())
            .setDisplayName("displayName1714148973")
            .setDescription("description-1724546052")
            .setServiceReference(ServiceReference.newBuilder().build())
            .setServiceProperties(ServiceProperties.newBuilder().build())
            .setAttributes(Attributes.newBuilder().build())
            .setDiscoveredService(LocationName.of("[PROJECT]", "[LOCATION]").toString())
            .setCreateTime(Timestamp.newBuilder().build())
            .setUpdateTime(Timestamp.newBuilder().build())
            .setUid("uid115792")
            .build();
    Operation resultOperation =
        Operation.newBuilder()
            .setName("updateServiceTest")
            .setDone(true)
            .setResponse(Any.pack(expectedResponse))
            .build();
    mockAppHub.addResponse(resultOperation);

    Service service = Service.newBuilder().build();
    FieldMask updateMask = FieldMask.newBuilder().build();

    Service actualResponse = client.updateServiceAsync(service, updateMask).get();
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockAppHub.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    UpdateServiceRequest actualRequest = ((UpdateServiceRequest) actualRequests.get(0));

    Assert.assertEquals(service, actualRequest.getService());
    Assert.assertEquals(updateMask, actualRequest.getUpdateMask());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void updateServiceExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockAppHub.addException(exception);

    try {
      Service service = Service.newBuilder().build();
      FieldMask updateMask = FieldMask.newBuilder().build();
      client.updateServiceAsync(service, updateMask).get();
      Assert.fail("No exception raised");
    } catch (ExecutionException e) {
      Assert.assertEquals(InvalidArgumentException.class, e.getCause().getClass());
      InvalidArgumentException apiException = ((InvalidArgumentException) e.getCause());
      Assert.assertEquals(StatusCode.Code.INVALID_ARGUMENT, apiException.getStatusCode().getCode());
    }
  }

  @Test
  public void deleteServiceTest() throws Exception {
    Empty expectedResponse = Empty.newBuilder().build();
    Operation resultOperation =
        Operation.newBuilder()
            .setName("deleteServiceTest")
            .setDone(true)
            .setResponse(Any.pack(expectedResponse))
            .build();
    mockAppHub.addResponse(resultOperation);

    ServiceName name = ServiceName.of("[PROJECT]", "[LOCATION]", "[APPLICATION]", "[SERVICE]");

    client.deleteServiceAsync(name).get();

    List<AbstractMessage> actualRequests = mockAppHub.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    DeleteServiceRequest actualRequest = ((DeleteServiceRequest) actualRequests.get(0));

    Assert.assertEquals(name.toString(), actualRequest.getName());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void deleteServiceExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockAppHub.addException(exception);

    try {
      ServiceName name = ServiceName.of("[PROJECT]", "[LOCATION]", "[APPLICATION]", "[SERVICE]");
      client.deleteServiceAsync(name).get();
      Assert.fail("No exception raised");
    } catch (ExecutionException e) {
      Assert.assertEquals(InvalidArgumentException.class, e.getCause().getClass());
      InvalidArgumentException apiException = ((InvalidArgumentException) e.getCause());
      Assert.assertEquals(StatusCode.Code.INVALID_ARGUMENT, apiException.getStatusCode().getCode());
    }
  }

  @Test
  public void deleteServiceTest2() throws Exception {
    Empty expectedResponse = Empty.newBuilder().build();
    Operation resultOperation =
        Operation.newBuilder()
            .setName("deleteServiceTest")
            .setDone(true)
            .setResponse(Any.pack(expectedResponse))
            .build();
    mockAppHub.addResponse(resultOperation);

    String name = "name3373707";

    client.deleteServiceAsync(name).get();

    List<AbstractMessage> actualRequests = mockAppHub.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    DeleteServiceRequest actualRequest = ((DeleteServiceRequest) actualRequests.get(0));

    Assert.assertEquals(name, actualRequest.getName());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void deleteServiceExceptionTest2() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockAppHub.addException(exception);

    try {
      String name = "name3373707";
      client.deleteServiceAsync(name).get();
      Assert.fail("No exception raised");
    } catch (ExecutionException e) {
      Assert.assertEquals(InvalidArgumentException.class, e.getCause().getClass());
      InvalidArgumentException apiException = ((InvalidArgumentException) e.getCause());
      Assert.assertEquals(StatusCode.Code.INVALID_ARGUMENT, apiException.getStatusCode().getCode());
    }
  }

  @Test
  public void listDiscoveredWorkloadsTest() throws Exception {
    DiscoveredWorkload responsesElement = DiscoveredWorkload.newBuilder().build();
    ListDiscoveredWorkloadsResponse expectedResponse =
        ListDiscoveredWorkloadsResponse.newBuilder()
            .setNextPageToken("")
            .addAllDiscoveredWorkloads(Arrays.asList(responsesElement))
            .build();
    mockAppHub.addResponse(expectedResponse);

    LocationName parent = LocationName.of("[PROJECT]", "[LOCATION]");

    ListDiscoveredWorkloadsPagedResponse pagedListResponse = client.listDiscoveredWorkloads(parent);

    List<DiscoveredWorkload> resources = Lists.newArrayList(pagedListResponse.iterateAll());

    Assert.assertEquals(1, resources.size());
    Assert.assertEquals(expectedResponse.getDiscoveredWorkloadsList().get(0), resources.get(0));

    List<AbstractMessage> actualRequests = mockAppHub.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    ListDiscoveredWorkloadsRequest actualRequest =
        ((ListDiscoveredWorkloadsRequest) actualRequests.get(0));

    Assert.assertEquals(parent.toString(), actualRequest.getParent());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void listDiscoveredWorkloadsExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockAppHub.addException(exception);

    try {
      LocationName parent = LocationName.of("[PROJECT]", "[LOCATION]");
      client.listDiscoveredWorkloads(parent);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void listDiscoveredWorkloadsTest2() throws Exception {
    DiscoveredWorkload responsesElement = DiscoveredWorkload.newBuilder().build();
    ListDiscoveredWorkloadsResponse expectedResponse =
        ListDiscoveredWorkloadsResponse.newBuilder()
            .setNextPageToken("")
            .addAllDiscoveredWorkloads(Arrays.asList(responsesElement))
            .build();
    mockAppHub.addResponse(expectedResponse);

    String parent = "parent-995424086";

    ListDiscoveredWorkloadsPagedResponse pagedListResponse = client.listDiscoveredWorkloads(parent);

    List<DiscoveredWorkload> resources = Lists.newArrayList(pagedListResponse.iterateAll());

    Assert.assertEquals(1, resources.size());
    Assert.assertEquals(expectedResponse.getDiscoveredWorkloadsList().get(0), resources.get(0));

    List<AbstractMessage> actualRequests = mockAppHub.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    ListDiscoveredWorkloadsRequest actualRequest =
        ((ListDiscoveredWorkloadsRequest) actualRequests.get(0));

    Assert.assertEquals(parent, actualRequest.getParent());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void listDiscoveredWorkloadsExceptionTest2() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockAppHub.addException(exception);

    try {
      String parent = "parent-995424086";
      client.listDiscoveredWorkloads(parent);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void getDiscoveredWorkloadTest() throws Exception {
    DiscoveredWorkload expectedResponse =
        DiscoveredWorkload.newBuilder()
            .setName(
                DiscoveredWorkloadName.of("[PROJECT]", "[LOCATION]", "[DISCOVERED_WORKLOAD]")
                    .toString())
            .setWorkloadReference(WorkloadReference.newBuilder().build())
            .setWorkloadProperties(WorkloadProperties.newBuilder().build())
            .build();
    mockAppHub.addResponse(expectedResponse);

    DiscoveredWorkloadName name =
        DiscoveredWorkloadName.of("[PROJECT]", "[LOCATION]", "[DISCOVERED_WORKLOAD]");

    DiscoveredWorkload actualResponse = client.getDiscoveredWorkload(name);
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockAppHub.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    GetDiscoveredWorkloadRequest actualRequest =
        ((GetDiscoveredWorkloadRequest) actualRequests.get(0));

    Assert.assertEquals(name.toString(), actualRequest.getName());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void getDiscoveredWorkloadExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockAppHub.addException(exception);

    try {
      DiscoveredWorkloadName name =
          DiscoveredWorkloadName.of("[PROJECT]", "[LOCATION]", "[DISCOVERED_WORKLOAD]");
      client.getDiscoveredWorkload(name);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void getDiscoveredWorkloadTest2() throws Exception {
    DiscoveredWorkload expectedResponse =
        DiscoveredWorkload.newBuilder()
            .setName(
                DiscoveredWorkloadName.of("[PROJECT]", "[LOCATION]", "[DISCOVERED_WORKLOAD]")
                    .toString())
            .setWorkloadReference(WorkloadReference.newBuilder().build())
            .setWorkloadProperties(WorkloadProperties.newBuilder().build())
            .build();
    mockAppHub.addResponse(expectedResponse);

    String name = "name3373707";

    DiscoveredWorkload actualResponse = client.getDiscoveredWorkload(name);
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockAppHub.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    GetDiscoveredWorkloadRequest actualRequest =
        ((GetDiscoveredWorkloadRequest) actualRequests.get(0));

    Assert.assertEquals(name, actualRequest.getName());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void getDiscoveredWorkloadExceptionTest2() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockAppHub.addException(exception);

    try {
      String name = "name3373707";
      client.getDiscoveredWorkload(name);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void lookupDiscoveredWorkloadTest() throws Exception {
    LookupDiscoveredWorkloadResponse expectedResponse =
        LookupDiscoveredWorkloadResponse.newBuilder()
            .setDiscoveredWorkload(DiscoveredWorkload.newBuilder().build())
            .build();
    mockAppHub.addResponse(expectedResponse);

    LocationName parent = LocationName.of("[PROJECT]", "[LOCATION]");
    String uri = "uri116076";

    LookupDiscoveredWorkloadResponse actualResponse = client.lookupDiscoveredWorkload(parent, uri);
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockAppHub.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    LookupDiscoveredWorkloadRequest actualRequest =
        ((LookupDiscoveredWorkloadRequest) actualRequests.get(0));

    Assert.assertEquals(parent.toString(), actualRequest.getParent());
    Assert.assertEquals(uri, actualRequest.getUri());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void lookupDiscoveredWorkloadExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockAppHub.addException(exception);

    try {
      LocationName parent = LocationName.of("[PROJECT]", "[LOCATION]");
      String uri = "uri116076";
      client.lookupDiscoveredWorkload(parent, uri);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void lookupDiscoveredWorkloadTest2() throws Exception {
    LookupDiscoveredWorkloadResponse expectedResponse =
        LookupDiscoveredWorkloadResponse.newBuilder()
            .setDiscoveredWorkload(DiscoveredWorkload.newBuilder().build())
            .build();
    mockAppHub.addResponse(expectedResponse);

    String parent = "parent-995424086";
    String uri = "uri116076";

    LookupDiscoveredWorkloadResponse actualResponse = client.lookupDiscoveredWorkload(parent, uri);
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockAppHub.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    LookupDiscoveredWorkloadRequest actualRequest =
        ((LookupDiscoveredWorkloadRequest) actualRequests.get(0));

    Assert.assertEquals(parent, actualRequest.getParent());
    Assert.assertEquals(uri, actualRequest.getUri());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void lookupDiscoveredWorkloadExceptionTest2() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockAppHub.addException(exception);

    try {
      String parent = "parent-995424086";
      String uri = "uri116076";
      client.lookupDiscoveredWorkload(parent, uri);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void listWorkloadsTest() throws Exception {
    Workload responsesElement = Workload.newBuilder().build();
    ListWorkloadsResponse expectedResponse =
        ListWorkloadsResponse.newBuilder()
            .setNextPageToken("")
            .addAllWorkloads(Arrays.asList(responsesElement))
            .build();
    mockAppHub.addResponse(expectedResponse);

    ApplicationName parent = ApplicationName.of("[PROJECT]", "[LOCATION]", "[APPLICATION]");

    ListWorkloadsPagedResponse pagedListResponse = client.listWorkloads(parent);

    List<Workload> resources = Lists.newArrayList(pagedListResponse.iterateAll());

    Assert.assertEquals(1, resources.size());
    Assert.assertEquals(expectedResponse.getWorkloadsList().get(0), resources.get(0));

    List<AbstractMessage> actualRequests = mockAppHub.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    ListWorkloadsRequest actualRequest = ((ListWorkloadsRequest) actualRequests.get(0));

    Assert.assertEquals(parent.toString(), actualRequest.getParent());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void listWorkloadsExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockAppHub.addException(exception);

    try {
      ApplicationName parent = ApplicationName.of("[PROJECT]", "[LOCATION]", "[APPLICATION]");
      client.listWorkloads(parent);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void listWorkloadsTest2() throws Exception {
    Workload responsesElement = Workload.newBuilder().build();
    ListWorkloadsResponse expectedResponse =
        ListWorkloadsResponse.newBuilder()
            .setNextPageToken("")
            .addAllWorkloads(Arrays.asList(responsesElement))
            .build();
    mockAppHub.addResponse(expectedResponse);

    String parent = "parent-995424086";

    ListWorkloadsPagedResponse pagedListResponse = client.listWorkloads(parent);

    List<Workload> resources = Lists.newArrayList(pagedListResponse.iterateAll());

    Assert.assertEquals(1, resources.size());
    Assert.assertEquals(expectedResponse.getWorkloadsList().get(0), resources.get(0));

    List<AbstractMessage> actualRequests = mockAppHub.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    ListWorkloadsRequest actualRequest = ((ListWorkloadsRequest) actualRequests.get(0));

    Assert.assertEquals(parent, actualRequest.getParent());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void listWorkloadsExceptionTest2() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockAppHub.addException(exception);

    try {
      String parent = "parent-995424086";
      client.listWorkloads(parent);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void createWorkloadTest() throws Exception {
    Workload expectedResponse =
        Workload.newBuilder()
            .setName(
                WorkloadName.of("[PROJECT]", "[LOCATION]", "[APPLICATION]", "[WORKLOAD]")
                    .toString())
            .setDisplayName("displayName1714148973")
            .setDescription("description-1724546052")
            .setWorkloadReference(WorkloadReference.newBuilder().build())
            .setWorkloadProperties(WorkloadProperties.newBuilder().build())
            .setDiscoveredWorkload(LocationName.of("[PROJECT]", "[LOCATION]").toString())
            .setAttributes(Attributes.newBuilder().build())
            .setCreateTime(Timestamp.newBuilder().build())
            .setUpdateTime(Timestamp.newBuilder().build())
            .setUid("uid115792")
            .build();
    Operation resultOperation =
        Operation.newBuilder()
            .setName("createWorkloadTest")
            .setDone(true)
            .setResponse(Any.pack(expectedResponse))
            .build();
    mockAppHub.addResponse(resultOperation);

    ApplicationName parent = ApplicationName.of("[PROJECT]", "[LOCATION]", "[APPLICATION]");
    Workload workload = Workload.newBuilder().build();
    String workloadId = "workloadId-186277134";

    Workload actualResponse = client.createWorkloadAsync(parent, workload, workloadId).get();
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockAppHub.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    CreateWorkloadRequest actualRequest = ((CreateWorkloadRequest) actualRequests.get(0));

    Assert.assertEquals(parent.toString(), actualRequest.getParent());
    Assert.assertEquals(workload, actualRequest.getWorkload());
    Assert.assertEquals(workloadId, actualRequest.getWorkloadId());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void createWorkloadExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockAppHub.addException(exception);

    try {
      ApplicationName parent = ApplicationName.of("[PROJECT]", "[LOCATION]", "[APPLICATION]");
      Workload workload = Workload.newBuilder().build();
      String workloadId = "workloadId-186277134";
      client.createWorkloadAsync(parent, workload, workloadId).get();
      Assert.fail("No exception raised");
    } catch (ExecutionException e) {
      Assert.assertEquals(InvalidArgumentException.class, e.getCause().getClass());
      InvalidArgumentException apiException = ((InvalidArgumentException) e.getCause());
      Assert.assertEquals(StatusCode.Code.INVALID_ARGUMENT, apiException.getStatusCode().getCode());
    }
  }

  @Test
  public void createWorkloadTest2() throws Exception {
    Workload expectedResponse =
        Workload.newBuilder()
            .setName(
                WorkloadName.of("[PROJECT]", "[LOCATION]", "[APPLICATION]", "[WORKLOAD]")
                    .toString())
            .setDisplayName("displayName1714148973")
            .setDescription("description-1724546052")
            .setWorkloadReference(WorkloadReference.newBuilder().build())
            .setWorkloadProperties(WorkloadProperties.newBuilder().build())
            .setDiscoveredWorkload(LocationName.of("[PROJECT]", "[LOCATION]").toString())
            .setAttributes(Attributes.newBuilder().build())
            .setCreateTime(Timestamp.newBuilder().build())
            .setUpdateTime(Timestamp.newBuilder().build())
            .setUid("uid115792")
            .build();
    Operation resultOperation =
        Operation.newBuilder()
            .setName("createWorkloadTest")
            .setDone(true)
            .setResponse(Any.pack(expectedResponse))
            .build();
    mockAppHub.addResponse(resultOperation);

    String parent = "parent-995424086";
    Workload workload = Workload.newBuilder().build();
    String workloadId = "workloadId-186277134";

    Workload actualResponse = client.createWorkloadAsync(parent, workload, workloadId).get();
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockAppHub.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    CreateWorkloadRequest actualRequest = ((CreateWorkloadRequest) actualRequests.get(0));

    Assert.assertEquals(parent, actualRequest.getParent());
    Assert.assertEquals(workload, actualRequest.getWorkload());
    Assert.assertEquals(workloadId, actualRequest.getWorkloadId());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void createWorkloadExceptionTest2() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockAppHub.addException(exception);

    try {
      String parent = "parent-995424086";
      Workload workload = Workload.newBuilder().build();
      String workloadId = "workloadId-186277134";
      client.createWorkloadAsync(parent, workload, workloadId).get();
      Assert.fail("No exception raised");
    } catch (ExecutionException e) {
      Assert.assertEquals(InvalidArgumentException.class, e.getCause().getClass());
      InvalidArgumentException apiException = ((InvalidArgumentException) e.getCause());
      Assert.assertEquals(StatusCode.Code.INVALID_ARGUMENT, apiException.getStatusCode().getCode());
    }
  }

  @Test
  public void getWorkloadTest() throws Exception {
    Workload expectedResponse =
        Workload.newBuilder()
            .setName(
                WorkloadName.of("[PROJECT]", "[LOCATION]", "[APPLICATION]", "[WORKLOAD]")
                    .toString())
            .setDisplayName("displayName1714148973")
            .setDescription("description-1724546052")
            .setWorkloadReference(WorkloadReference.newBuilder().build())
            .setWorkloadProperties(WorkloadProperties.newBuilder().build())
            .setDiscoveredWorkload(LocationName.of("[PROJECT]", "[LOCATION]").toString())
            .setAttributes(Attributes.newBuilder().build())
            .setCreateTime(Timestamp.newBuilder().build())
            .setUpdateTime(Timestamp.newBuilder().build())
            .setUid("uid115792")
            .build();
    mockAppHub.addResponse(expectedResponse);

    WorkloadName name = WorkloadName.of("[PROJECT]", "[LOCATION]", "[APPLICATION]", "[WORKLOAD]");

    Workload actualResponse = client.getWorkload(name);
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockAppHub.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    GetWorkloadRequest actualRequest = ((GetWorkloadRequest) actualRequests.get(0));

    Assert.assertEquals(name.toString(), actualRequest.getName());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void getWorkloadExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockAppHub.addException(exception);

    try {
      WorkloadName name = WorkloadName.of("[PROJECT]", "[LOCATION]", "[APPLICATION]", "[WORKLOAD]");
      client.getWorkload(name);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void getWorkloadTest2() throws Exception {
    Workload expectedResponse =
        Workload.newBuilder()
            .setName(
                WorkloadName.of("[PROJECT]", "[LOCATION]", "[APPLICATION]", "[WORKLOAD]")
                    .toString())
            .setDisplayName("displayName1714148973")
            .setDescription("description-1724546052")
            .setWorkloadReference(WorkloadReference.newBuilder().build())
            .setWorkloadProperties(WorkloadProperties.newBuilder().build())
            .setDiscoveredWorkload(LocationName.of("[PROJECT]", "[LOCATION]").toString())
            .setAttributes(Attributes.newBuilder().build())
            .setCreateTime(Timestamp.newBuilder().build())
            .setUpdateTime(Timestamp.newBuilder().build())
            .setUid("uid115792")
            .build();
    mockAppHub.addResponse(expectedResponse);

    String name = "name3373707";

    Workload actualResponse = client.getWorkload(name);
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockAppHub.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    GetWorkloadRequest actualRequest = ((GetWorkloadRequest) actualRequests.get(0));

    Assert.assertEquals(name, actualRequest.getName());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void getWorkloadExceptionTest2() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockAppHub.addException(exception);

    try {
      String name = "name3373707";
      client.getWorkload(name);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void updateWorkloadTest() throws Exception {
    Workload expectedResponse =
        Workload.newBuilder()
            .setName(
                WorkloadName.of("[PROJECT]", "[LOCATION]", "[APPLICATION]", "[WORKLOAD]")
                    .toString())
            .setDisplayName("displayName1714148973")
            .setDescription("description-1724546052")
            .setWorkloadReference(WorkloadReference.newBuilder().build())
            .setWorkloadProperties(WorkloadProperties.newBuilder().build())
            .setDiscoveredWorkload(LocationName.of("[PROJECT]", "[LOCATION]").toString())
            .setAttributes(Attributes.newBuilder().build())
            .setCreateTime(Timestamp.newBuilder().build())
            .setUpdateTime(Timestamp.newBuilder().build())
            .setUid("uid115792")
            .build();
    Operation resultOperation =
        Operation.newBuilder()
            .setName("updateWorkloadTest")
            .setDone(true)
            .setResponse(Any.pack(expectedResponse))
            .build();
    mockAppHub.addResponse(resultOperation);

    Workload workload = Workload.newBuilder().build();
    FieldMask updateMask = FieldMask.newBuilder().build();

    Workload actualResponse = client.updateWorkloadAsync(workload, updateMask).get();
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockAppHub.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    UpdateWorkloadRequest actualRequest = ((UpdateWorkloadRequest) actualRequests.get(0));

    Assert.assertEquals(workload, actualRequest.getWorkload());
    Assert.assertEquals(updateMask, actualRequest.getUpdateMask());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void updateWorkloadExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockAppHub.addException(exception);

    try {
      Workload workload = Workload.newBuilder().build();
      FieldMask updateMask = FieldMask.newBuilder().build();
      client.updateWorkloadAsync(workload, updateMask).get();
      Assert.fail("No exception raised");
    } catch (ExecutionException e) {
      Assert.assertEquals(InvalidArgumentException.class, e.getCause().getClass());
      InvalidArgumentException apiException = ((InvalidArgumentException) e.getCause());
      Assert.assertEquals(StatusCode.Code.INVALID_ARGUMENT, apiException.getStatusCode().getCode());
    }
  }

  @Test
  public void deleteWorkloadTest() throws Exception {
    Empty expectedResponse = Empty.newBuilder().build();
    Operation resultOperation =
        Operation.newBuilder()
            .setName("deleteWorkloadTest")
            .setDone(true)
            .setResponse(Any.pack(expectedResponse))
            .build();
    mockAppHub.addResponse(resultOperation);

    WorkloadName name = WorkloadName.of("[PROJECT]", "[LOCATION]", "[APPLICATION]", "[WORKLOAD]");

    client.deleteWorkloadAsync(name).get();

    List<AbstractMessage> actualRequests = mockAppHub.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    DeleteWorkloadRequest actualRequest = ((DeleteWorkloadRequest) actualRequests.get(0));

    Assert.assertEquals(name.toString(), actualRequest.getName());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void deleteWorkloadExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockAppHub.addException(exception);

    try {
      WorkloadName name = WorkloadName.of("[PROJECT]", "[LOCATION]", "[APPLICATION]", "[WORKLOAD]");
      client.deleteWorkloadAsync(name).get();
      Assert.fail("No exception raised");
    } catch (ExecutionException e) {
      Assert.assertEquals(InvalidArgumentException.class, e.getCause().getClass());
      InvalidArgumentException apiException = ((InvalidArgumentException) e.getCause());
      Assert.assertEquals(StatusCode.Code.INVALID_ARGUMENT, apiException.getStatusCode().getCode());
    }
  }

  @Test
  public void deleteWorkloadTest2() throws Exception {
    Empty expectedResponse = Empty.newBuilder().build();
    Operation resultOperation =
        Operation.newBuilder()
            .setName("deleteWorkloadTest")
            .setDone(true)
            .setResponse(Any.pack(expectedResponse))
            .build();
    mockAppHub.addResponse(resultOperation);

    String name = "name3373707";

    client.deleteWorkloadAsync(name).get();

    List<AbstractMessage> actualRequests = mockAppHub.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    DeleteWorkloadRequest actualRequest = ((DeleteWorkloadRequest) actualRequests.get(0));

    Assert.assertEquals(name, actualRequest.getName());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void deleteWorkloadExceptionTest2() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockAppHub.addException(exception);

    try {
      String name = "name3373707";
      client.deleteWorkloadAsync(name).get();
      Assert.fail("No exception raised");
    } catch (ExecutionException e) {
      Assert.assertEquals(InvalidArgumentException.class, e.getCause().getClass());
      InvalidArgumentException apiException = ((InvalidArgumentException) e.getCause());
      Assert.assertEquals(StatusCode.Code.INVALID_ARGUMENT, apiException.getStatusCode().getCode());
    }
  }

  @Test
  public void listApplicationsTest() throws Exception {
    Application responsesElement = Application.newBuilder().build();
    ListApplicationsResponse expectedResponse =
        ListApplicationsResponse.newBuilder()
            .setNextPageToken("")
            .addAllApplications(Arrays.asList(responsesElement))
            .build();
    mockAppHub.addResponse(expectedResponse);

    LocationName parent = LocationName.of("[PROJECT]", "[LOCATION]");

    ListApplicationsPagedResponse pagedListResponse = client.listApplications(parent);

    List<Application> resources = Lists.newArrayList(pagedListResponse.iterateAll());

    Assert.assertEquals(1, resources.size());
    Assert.assertEquals(expectedResponse.getApplicationsList().get(0), resources.get(0));

    List<AbstractMessage> actualRequests = mockAppHub.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    ListApplicationsRequest actualRequest = ((ListApplicationsRequest) actualRequests.get(0));

    Assert.assertEquals(parent.toString(), actualRequest.getParent());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void listApplicationsExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockAppHub.addException(exception);

    try {
      LocationName parent = LocationName.of("[PROJECT]", "[LOCATION]");
      client.listApplications(parent);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void listApplicationsTest2() throws Exception {
    Application responsesElement = Application.newBuilder().build();
    ListApplicationsResponse expectedResponse =
        ListApplicationsResponse.newBuilder()
            .setNextPageToken("")
            .addAllApplications(Arrays.asList(responsesElement))
            .build();
    mockAppHub.addResponse(expectedResponse);

    String parent = "parent-995424086";

    ListApplicationsPagedResponse pagedListResponse = client.listApplications(parent);

    List<Application> resources = Lists.newArrayList(pagedListResponse.iterateAll());

    Assert.assertEquals(1, resources.size());
    Assert.assertEquals(expectedResponse.getApplicationsList().get(0), resources.get(0));

    List<AbstractMessage> actualRequests = mockAppHub.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    ListApplicationsRequest actualRequest = ((ListApplicationsRequest) actualRequests.get(0));

    Assert.assertEquals(parent, actualRequest.getParent());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void listApplicationsExceptionTest2() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockAppHub.addException(exception);

    try {
      String parent = "parent-995424086";
      client.listApplications(parent);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void createApplicationTest() throws Exception {
    Application expectedResponse =
        Application.newBuilder()
            .setName(ApplicationName.of("[PROJECT]", "[LOCATION]", "[APPLICATION]").toString())
            .setDisplayName("displayName1714148973")
            .setDescription("description-1724546052")
            .setAttributes(Attributes.newBuilder().build())
            .setCreateTime(Timestamp.newBuilder().build())
            .setUpdateTime(Timestamp.newBuilder().build())
            .setScope(Scope.newBuilder().build())
            .setUid("uid115792")
            .build();
    Operation resultOperation =
        Operation.newBuilder()
            .setName("createApplicationTest")
            .setDone(true)
            .setResponse(Any.pack(expectedResponse))
            .build();
    mockAppHub.addResponse(resultOperation);

    LocationName parent = LocationName.of("[PROJECT]", "[LOCATION]");
    Application application = Application.newBuilder().build();
    String applicationId = "applicationId-1011352949";

    Application actualResponse =
        client.createApplicationAsync(parent, application, applicationId).get();
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockAppHub.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    CreateApplicationRequest actualRequest = ((CreateApplicationRequest) actualRequests.get(0));

    Assert.assertEquals(parent.toString(), actualRequest.getParent());
    Assert.assertEquals(application, actualRequest.getApplication());
    Assert.assertEquals(applicationId, actualRequest.getApplicationId());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void createApplicationExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockAppHub.addException(exception);

    try {
      LocationName parent = LocationName.of("[PROJECT]", "[LOCATION]");
      Application application = Application.newBuilder().build();
      String applicationId = "applicationId-1011352949";
      client.createApplicationAsync(parent, application, applicationId).get();
      Assert.fail("No exception raised");
    } catch (ExecutionException e) {
      Assert.assertEquals(InvalidArgumentException.class, e.getCause().getClass());
      InvalidArgumentException apiException = ((InvalidArgumentException) e.getCause());
      Assert.assertEquals(StatusCode.Code.INVALID_ARGUMENT, apiException.getStatusCode().getCode());
    }
  }

  @Test
  public void createApplicationTest2() throws Exception {
    Application expectedResponse =
        Application.newBuilder()
            .setName(ApplicationName.of("[PROJECT]", "[LOCATION]", "[APPLICATION]").toString())
            .setDisplayName("displayName1714148973")
            .setDescription("description-1724546052")
            .setAttributes(Attributes.newBuilder().build())
            .setCreateTime(Timestamp.newBuilder().build())
            .setUpdateTime(Timestamp.newBuilder().build())
            .setScope(Scope.newBuilder().build())
            .setUid("uid115792")
            .build();
    Operation resultOperation =
        Operation.newBuilder()
            .setName("createApplicationTest")
            .setDone(true)
            .setResponse(Any.pack(expectedResponse))
            .build();
    mockAppHub.addResponse(resultOperation);

    String parent = "parent-995424086";
    Application application = Application.newBuilder().build();
    String applicationId = "applicationId-1011352949";

    Application actualResponse =
        client.createApplicationAsync(parent, application, applicationId).get();
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockAppHub.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    CreateApplicationRequest actualRequest = ((CreateApplicationRequest) actualRequests.get(0));

    Assert.assertEquals(parent, actualRequest.getParent());
    Assert.assertEquals(application, actualRequest.getApplication());
    Assert.assertEquals(applicationId, actualRequest.getApplicationId());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void createApplicationExceptionTest2() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockAppHub.addException(exception);

    try {
      String parent = "parent-995424086";
      Application application = Application.newBuilder().build();
      String applicationId = "applicationId-1011352949";
      client.createApplicationAsync(parent, application, applicationId).get();
      Assert.fail("No exception raised");
    } catch (ExecutionException e) {
      Assert.assertEquals(InvalidArgumentException.class, e.getCause().getClass());
      InvalidArgumentException apiException = ((InvalidArgumentException) e.getCause());
      Assert.assertEquals(StatusCode.Code.INVALID_ARGUMENT, apiException.getStatusCode().getCode());
    }
  }

  @Test
  public void getApplicationTest() throws Exception {
    Application expectedResponse =
        Application.newBuilder()
            .setName(ApplicationName.of("[PROJECT]", "[LOCATION]", "[APPLICATION]").toString())
            .setDisplayName("displayName1714148973")
            .setDescription("description-1724546052")
            .setAttributes(Attributes.newBuilder().build())
            .setCreateTime(Timestamp.newBuilder().build())
            .setUpdateTime(Timestamp.newBuilder().build())
            .setScope(Scope.newBuilder().build())
            .setUid("uid115792")
            .build();
    mockAppHub.addResponse(expectedResponse);

    ApplicationName name = ApplicationName.of("[PROJECT]", "[LOCATION]", "[APPLICATION]");

    Application actualResponse = client.getApplication(name);
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockAppHub.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    GetApplicationRequest actualRequest = ((GetApplicationRequest) actualRequests.get(0));

    Assert.assertEquals(name.toString(), actualRequest.getName());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void getApplicationExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockAppHub.addException(exception);

    try {
      ApplicationName name = ApplicationName.of("[PROJECT]", "[LOCATION]", "[APPLICATION]");
      client.getApplication(name);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void getApplicationTest2() throws Exception {
    Application expectedResponse =
        Application.newBuilder()
            .setName(ApplicationName.of("[PROJECT]", "[LOCATION]", "[APPLICATION]").toString())
            .setDisplayName("displayName1714148973")
            .setDescription("description-1724546052")
            .setAttributes(Attributes.newBuilder().build())
            .setCreateTime(Timestamp.newBuilder().build())
            .setUpdateTime(Timestamp.newBuilder().build())
            .setScope(Scope.newBuilder().build())
            .setUid("uid115792")
            .build();
    mockAppHub.addResponse(expectedResponse);

    String name = "name3373707";

    Application actualResponse = client.getApplication(name);
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockAppHub.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    GetApplicationRequest actualRequest = ((GetApplicationRequest) actualRequests.get(0));

    Assert.assertEquals(name, actualRequest.getName());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void getApplicationExceptionTest2() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockAppHub.addException(exception);

    try {
      String name = "name3373707";
      client.getApplication(name);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void updateApplicationTest() throws Exception {
    Application expectedResponse =
        Application.newBuilder()
            .setName(ApplicationName.of("[PROJECT]", "[LOCATION]", "[APPLICATION]").toString())
            .setDisplayName("displayName1714148973")
            .setDescription("description-1724546052")
            .setAttributes(Attributes.newBuilder().build())
            .setCreateTime(Timestamp.newBuilder().build())
            .setUpdateTime(Timestamp.newBuilder().build())
            .setScope(Scope.newBuilder().build())
            .setUid("uid115792")
            .build();
    Operation resultOperation =
        Operation.newBuilder()
            .setName("updateApplicationTest")
            .setDone(true)
            .setResponse(Any.pack(expectedResponse))
            .build();
    mockAppHub.addResponse(resultOperation);

    Application application = Application.newBuilder().build();
    FieldMask updateMask = FieldMask.newBuilder().build();

    Application actualResponse = client.updateApplicationAsync(application, updateMask).get();
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockAppHub.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    UpdateApplicationRequest actualRequest = ((UpdateApplicationRequest) actualRequests.get(0));

    Assert.assertEquals(application, actualRequest.getApplication());
    Assert.assertEquals(updateMask, actualRequest.getUpdateMask());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void updateApplicationExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockAppHub.addException(exception);

    try {
      Application application = Application.newBuilder().build();
      FieldMask updateMask = FieldMask.newBuilder().build();
      client.updateApplicationAsync(application, updateMask).get();
      Assert.fail("No exception raised");
    } catch (ExecutionException e) {
      Assert.assertEquals(InvalidArgumentException.class, e.getCause().getClass());
      InvalidArgumentException apiException = ((InvalidArgumentException) e.getCause());
      Assert.assertEquals(StatusCode.Code.INVALID_ARGUMENT, apiException.getStatusCode().getCode());
    }
  }

  @Test
  public void deleteApplicationTest() throws Exception {
    Empty expectedResponse = Empty.newBuilder().build();
    Operation resultOperation =
        Operation.newBuilder()
            .setName("deleteApplicationTest")
            .setDone(true)
            .setResponse(Any.pack(expectedResponse))
            .build();
    mockAppHub.addResponse(resultOperation);

    ApplicationName name = ApplicationName.of("[PROJECT]", "[LOCATION]", "[APPLICATION]");

    client.deleteApplicationAsync(name).get();

    List<AbstractMessage> actualRequests = mockAppHub.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    DeleteApplicationRequest actualRequest = ((DeleteApplicationRequest) actualRequests.get(0));

    Assert.assertEquals(name.toString(), actualRequest.getName());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void deleteApplicationExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockAppHub.addException(exception);

    try {
      ApplicationName name = ApplicationName.of("[PROJECT]", "[LOCATION]", "[APPLICATION]");
      client.deleteApplicationAsync(name).get();
      Assert.fail("No exception raised");
    } catch (ExecutionException e) {
      Assert.assertEquals(InvalidArgumentException.class, e.getCause().getClass());
      InvalidArgumentException apiException = ((InvalidArgumentException) e.getCause());
      Assert.assertEquals(StatusCode.Code.INVALID_ARGUMENT, apiException.getStatusCode().getCode());
    }
  }

  @Test
  public void deleteApplicationTest2() throws Exception {
    Empty expectedResponse = Empty.newBuilder().build();
    Operation resultOperation =
        Operation.newBuilder()
            .setName("deleteApplicationTest")
            .setDone(true)
            .setResponse(Any.pack(expectedResponse))
            .build();
    mockAppHub.addResponse(resultOperation);

    String name = "name3373707";

    client.deleteApplicationAsync(name).get();

    List<AbstractMessage> actualRequests = mockAppHub.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    DeleteApplicationRequest actualRequest = ((DeleteApplicationRequest) actualRequests.get(0));

    Assert.assertEquals(name, actualRequest.getName());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void deleteApplicationExceptionTest2() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockAppHub.addException(exception);

    try {
      String name = "name3373707";
      client.deleteApplicationAsync(name).get();
      Assert.fail("No exception raised");
    } catch (ExecutionException e) {
      Assert.assertEquals(InvalidArgumentException.class, e.getCause().getClass());
      InvalidArgumentException apiException = ((InvalidArgumentException) e.getCause());
      Assert.assertEquals(StatusCode.Code.INVALID_ARGUMENT, apiException.getStatusCode().getCode());
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

  @Test
  public void setIamPolicyTest() throws Exception {
    Policy expectedResponse =
        Policy.newBuilder()
            .setVersion(351608024)
            .addAllBindings(new ArrayList<Binding>())
            .addAllAuditConfigs(new ArrayList<AuditConfig>())
            .setEtag(ByteString.EMPTY)
            .build();
    mockIAMPolicy.addResponse(expectedResponse);

    SetIamPolicyRequest request =
        SetIamPolicyRequest.newBuilder()
            .setResource(ApplicationName.of("[PROJECT]", "[LOCATION]", "[APPLICATION]").toString())
            .setPolicy(Policy.newBuilder().build())
            .setUpdateMask(FieldMask.newBuilder().build())
            .build();

    Policy actualResponse = client.setIamPolicy(request);
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockIAMPolicy.getRequests();
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
    mockIAMPolicy.addException(exception);

    try {
      SetIamPolicyRequest request =
          SetIamPolicyRequest.newBuilder()
              .setResource(
                  ApplicationName.of("[PROJECT]", "[LOCATION]", "[APPLICATION]").toString())
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
    mockIAMPolicy.addResponse(expectedResponse);

    GetIamPolicyRequest request =
        GetIamPolicyRequest.newBuilder()
            .setResource(ApplicationName.of("[PROJECT]", "[LOCATION]", "[APPLICATION]").toString())
            .setOptions(GetPolicyOptions.newBuilder().build())
            .build();

    Policy actualResponse = client.getIamPolicy(request);
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockIAMPolicy.getRequests();
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
    mockIAMPolicy.addException(exception);

    try {
      GetIamPolicyRequest request =
          GetIamPolicyRequest.newBuilder()
              .setResource(
                  ApplicationName.of("[PROJECT]", "[LOCATION]", "[APPLICATION]").toString())
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
    mockIAMPolicy.addResponse(expectedResponse);

    TestIamPermissionsRequest request =
        TestIamPermissionsRequest.newBuilder()
            .setResource(ApplicationName.of("[PROJECT]", "[LOCATION]", "[APPLICATION]").toString())
            .addAllPermissions(new ArrayList<String>())
            .build();

    TestIamPermissionsResponse actualResponse = client.testIamPermissions(request);
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockIAMPolicy.getRequests();
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
    mockIAMPolicy.addException(exception);

    try {
      TestIamPermissionsRequest request =
          TestIamPermissionsRequest.newBuilder()
              .setResource(
                  ApplicationName.of("[PROJECT]", "[LOCATION]", "[APPLICATION]").toString())
              .addAllPermissions(new ArrayList<String>())
              .build();
      client.testIamPermissions(request);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }
}
