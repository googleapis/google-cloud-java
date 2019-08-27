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
package com.google.cloud.gaming.v1alpha;

import static com.google.cloud.gaming.v1alpha.RealmsServiceClient.ListRealmsPagedResponse;

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
import io.grpc.Status;
import io.grpc.StatusRuntimeException;
import java.io.IOException;
import java.util.Arrays;
import java.util.List;
import java.util.concurrent.ExecutionException;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Assert;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

@javax.annotation.Generated("by GAPIC")
public class RealmsServiceClientTest {
  private static MockAllocationPoliciesService mockAllocationPoliciesService;
  private static MockGameServerClustersService mockGameServerClustersService;
  private static MockGameServerDeploymentsService mockGameServerDeploymentsService;
  private static MockRealmsService mockRealmsService;
  private static MockScalingPoliciesService mockScalingPoliciesService;
  private static MockServiceHelper serviceHelper;
  private RealmsServiceClient client;
  private LocalChannelProvider channelProvider;

  @BeforeClass
  public static void startStaticServer() {
    mockAllocationPoliciesService = new MockAllocationPoliciesService();
    mockGameServerClustersService = new MockGameServerClustersService();
    mockGameServerDeploymentsService = new MockGameServerDeploymentsService();
    mockRealmsService = new MockRealmsService();
    mockScalingPoliciesService = new MockScalingPoliciesService();
    serviceHelper =
        new MockServiceHelper(
            "in-process-1",
            Arrays.<MockGrpcService>asList(
                mockAllocationPoliciesService,
                mockGameServerClustersService,
                mockGameServerDeploymentsService,
                mockRealmsService,
                mockScalingPoliciesService));
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
    RealmsServiceSettings settings =
        RealmsServiceSettings.newBuilder()
            .setTransportChannelProvider(channelProvider)
            .setCredentialsProvider(NoCredentialsProvider.create())
            .build();
    client = RealmsServiceClient.create(settings);
  }

  @After
  public void tearDown() throws Exception {
    client.close();
  }

  @Test
  @SuppressWarnings("all")
  public void listRealmsTest() {
    String nextPageToken = "";
    Realm realmsElement = Realm.newBuilder().build();
    List<Realm> realms = Arrays.asList(realmsElement);
    ListRealmsResponse expectedResponse =
        ListRealmsResponse.newBuilder()
            .setNextPageToken(nextPageToken)
            .addAllRealms(realms)
            .build();
    mockRealmsService.addResponse(expectedResponse);

    String formattedParent = RealmsServiceClient.formatLocationName("[PROJECT]", "[LOCATION]");

    ListRealmsPagedResponse pagedListResponse = client.listRealms(formattedParent);

    List<Realm> resources = Lists.newArrayList(pagedListResponse.iterateAll());
    Assert.assertEquals(1, resources.size());
    Assert.assertEquals(expectedResponse.getRealmsList().get(0), resources.get(0));

    List<AbstractMessage> actualRequests = mockRealmsService.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    ListRealmsRequest actualRequest = (ListRealmsRequest) actualRequests.get(0);

    Assert.assertEquals(formattedParent, actualRequest.getParent());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  @SuppressWarnings("all")
  public void listRealmsExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(Status.INVALID_ARGUMENT);
    mockRealmsService.addException(exception);

    try {
      String formattedParent = RealmsServiceClient.formatLocationName("[PROJECT]", "[LOCATION]");

      client.listRealms(formattedParent);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception
    }
  }

  @Test
  @SuppressWarnings("all")
  public void getRealmTest() {
    String name2 = "name2-1052831874";
    String timeZone = "timeZone36848094";
    Realm expectedResponse = Realm.newBuilder().setName(name2).setTimeZone(timeZone).build();
    mockRealmsService.addResponse(expectedResponse);

    String formattedName =
        RealmsServiceClient.formatRealmName("[PROJECT]", "[LOCATION]", "[REALM]");

    Realm actualResponse = client.getRealm(formattedName);
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockRealmsService.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    GetRealmRequest actualRequest = (GetRealmRequest) actualRequests.get(0);

    Assert.assertEquals(formattedName, actualRequest.getName());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  @SuppressWarnings("all")
  public void getRealmExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(Status.INVALID_ARGUMENT);
    mockRealmsService.addException(exception);

    try {
      String formattedName =
          RealmsServiceClient.formatRealmName("[PROJECT]", "[LOCATION]", "[REALM]");

      client.getRealm(formattedName);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception
    }
  }

  @Test
  @SuppressWarnings("all")
  public void createRealmTest() throws Exception {
    String name = "name3373707";
    String timeZone = "timeZone36848094";
    Realm expectedResponse = Realm.newBuilder().setName(name).setTimeZone(timeZone).build();
    Operation resultOperation =
        Operation.newBuilder()
            .setName("createRealmTest")
            .setDone(true)
            .setResponse(Any.pack(expectedResponse))
            .build();
    mockRealmsService.addResponse(resultOperation);

    String formattedParent = RealmsServiceClient.formatLocationName("[PROJECT]", "[LOCATION]");
    String realmId = "realmId-859416373";
    Realm realm = Realm.newBuilder().build();

    Realm actualResponse = client.createRealmAsync(formattedParent, realmId, realm).get();
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockRealmsService.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    CreateRealmRequest actualRequest = (CreateRealmRequest) actualRequests.get(0);

    Assert.assertEquals(formattedParent, actualRequest.getParent());
    Assert.assertEquals(realmId, actualRequest.getRealmId());
    Assert.assertEquals(realm, actualRequest.getRealm());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  @SuppressWarnings("all")
  public void createRealmExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(Status.INVALID_ARGUMENT);
    mockRealmsService.addException(exception);

    try {
      String formattedParent = RealmsServiceClient.formatLocationName("[PROJECT]", "[LOCATION]");
      String realmId = "realmId-859416373";
      Realm realm = Realm.newBuilder().build();

      client.createRealmAsync(formattedParent, realmId, realm).get();
      Assert.fail("No exception raised");
    } catch (ExecutionException e) {
      Assert.assertEquals(InvalidArgumentException.class, e.getCause().getClass());
      InvalidArgumentException apiException = (InvalidArgumentException) e.getCause();
      Assert.assertEquals(StatusCode.Code.INVALID_ARGUMENT, apiException.getStatusCode().getCode());
    }
  }

  @Test
  @SuppressWarnings("all")
  public void deleteRealmTest() throws Exception {
    Empty expectedResponse = Empty.newBuilder().build();
    Operation resultOperation =
        Operation.newBuilder()
            .setName("deleteRealmTest")
            .setDone(true)
            .setResponse(Any.pack(expectedResponse))
            .build();
    mockRealmsService.addResponse(resultOperation);

    String formattedName =
        RealmsServiceClient.formatRealmName("[PROJECT]", "[LOCATION]", "[REALM]");

    Empty actualResponse = client.deleteRealmAsync(formattedName).get();
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockRealmsService.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    DeleteRealmRequest actualRequest = (DeleteRealmRequest) actualRequests.get(0);

    Assert.assertEquals(formattedName, actualRequest.getName());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  @SuppressWarnings("all")
  public void deleteRealmExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(Status.INVALID_ARGUMENT);
    mockRealmsService.addException(exception);

    try {
      String formattedName =
          RealmsServiceClient.formatRealmName("[PROJECT]", "[LOCATION]", "[REALM]");

      client.deleteRealmAsync(formattedName).get();
      Assert.fail("No exception raised");
    } catch (ExecutionException e) {
      Assert.assertEquals(InvalidArgumentException.class, e.getCause().getClass());
      InvalidArgumentException apiException = (InvalidArgumentException) e.getCause();
      Assert.assertEquals(StatusCode.Code.INVALID_ARGUMENT, apiException.getStatusCode().getCode());
    }
  }

  @Test
  @SuppressWarnings("all")
  public void updateRealmTest() throws Exception {
    String name = "name3373707";
    String timeZone = "timeZone36848094";
    Realm expectedResponse = Realm.newBuilder().setName(name).setTimeZone(timeZone).build();
    Operation resultOperation =
        Operation.newBuilder()
            .setName("updateRealmTest")
            .setDone(true)
            .setResponse(Any.pack(expectedResponse))
            .build();
    mockRealmsService.addResponse(resultOperation);

    Realm realm = Realm.newBuilder().build();
    FieldMask updateMask = FieldMask.newBuilder().build();

    Realm actualResponse = client.updateRealmAsync(realm, updateMask).get();
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockRealmsService.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    UpdateRealmRequest actualRequest = (UpdateRealmRequest) actualRequests.get(0);

    Assert.assertEquals(realm, actualRequest.getRealm());
    Assert.assertEquals(updateMask, actualRequest.getUpdateMask());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  @SuppressWarnings("all")
  public void updateRealmExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(Status.INVALID_ARGUMENT);
    mockRealmsService.addException(exception);

    try {
      Realm realm = Realm.newBuilder().build();
      FieldMask updateMask = FieldMask.newBuilder().build();

      client.updateRealmAsync(realm, updateMask).get();
      Assert.fail("No exception raised");
    } catch (ExecutionException e) {
      Assert.assertEquals(InvalidArgumentException.class, e.getCause().getClass());
      InvalidArgumentException apiException = (InvalidArgumentException) e.getCause();
      Assert.assertEquals(StatusCode.Code.INVALID_ARGUMENT, apiException.getStatusCode().getCode());
    }
  }
}
