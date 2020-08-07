/*
 * Copyright 2020 Google LLC
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
package com.google.cloud.gaming.v1;

import static com.google.cloud.gaming.v1.RealmsServiceClient.ListRealmsPagedResponse;

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
import java.util.UUID;
import java.util.concurrent.ExecutionException;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Assert;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

@javax.annotation.Generated("by GAPIC")
public class RealmsServiceClientTest {
  private static MockGameServerClustersService mockGameServerClustersService;
  private static MockGameServerConfigsService mockGameServerConfigsService;
  private static MockGameServerDeploymentsService mockGameServerDeploymentsService;
  private static MockRealmsService mockRealmsService;
  private static MockServiceHelper serviceHelper;
  private RealmsServiceClient client;
  private LocalChannelProvider channelProvider;

  @BeforeClass
  public static void startStaticServer() {
    mockGameServerClustersService = new MockGameServerClustersService();
    mockGameServerConfigsService = new MockGameServerConfigsService();
    mockGameServerDeploymentsService = new MockGameServerDeploymentsService();
    mockRealmsService = new MockRealmsService();
    serviceHelper =
        new MockServiceHelper(
            UUID.randomUUID().toString(),
            Arrays.<MockGrpcService>asList(
                mockGameServerClustersService,
                mockGameServerConfigsService,
                mockGameServerDeploymentsService,
                mockRealmsService));
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

    LocationName parent = LocationName.of("[PROJECT]", "[LOCATION]");

    ListRealmsPagedResponse pagedListResponse = client.listRealms(parent);

    List<Realm> resources = Lists.newArrayList(pagedListResponse.iterateAll());
    Assert.assertEquals(1, resources.size());
    Assert.assertEquals(expectedResponse.getRealmsList().get(0), resources.get(0));

    List<AbstractMessage> actualRequests = mockRealmsService.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    ListRealmsRequest actualRequest = (ListRealmsRequest) actualRequests.get(0);

    Assert.assertEquals(parent, LocationName.parse(actualRequest.getParent()));
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
      LocationName parent = LocationName.of("[PROJECT]", "[LOCATION]");

      client.listRealms(parent);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception
    }
  }

  @Test
  @SuppressWarnings("all")
  public void getRealmTest() {
    RealmName name2 = RealmName.of("[PROJECT]", "[LOCATION]", "[REALM]");
    String timeZone = "timeZone36848094";
    String etag = "etag3123477";
    String description = "description-1724546052";
    Realm expectedResponse =
        Realm.newBuilder()
            .setName(name2.toString())
            .setTimeZone(timeZone)
            .setEtag(etag)
            .setDescription(description)
            .build();
    mockRealmsService.addResponse(expectedResponse);

    RealmName name = RealmName.of("[PROJECT]", "[LOCATION]", "[REALM]");

    Realm actualResponse = client.getRealm(name);
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockRealmsService.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    GetRealmRequest actualRequest = (GetRealmRequest) actualRequests.get(0);

    Assert.assertEquals(name, RealmName.parse(actualRequest.getName()));
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
      RealmName name = RealmName.of("[PROJECT]", "[LOCATION]", "[REALM]");

      client.getRealm(name);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception
    }
  }

  @Test
  @SuppressWarnings("all")
  public void createRealmTest() throws Exception {
    RealmName name = RealmName.of("[PROJECT]", "[LOCATION]", "[REALM]");
    String timeZone = "timeZone36848094";
    String etag = "etag3123477";
    String description = "description-1724546052";
    Realm expectedResponse =
        Realm.newBuilder()
            .setName(name.toString())
            .setTimeZone(timeZone)
            .setEtag(etag)
            .setDescription(description)
            .build();
    Operation resultOperation =
        Operation.newBuilder()
            .setName("createRealmTest")
            .setDone(true)
            .setResponse(Any.pack(expectedResponse))
            .build();
    mockRealmsService.addResponse(resultOperation);

    LocationName parent = LocationName.of("[PROJECT]", "[LOCATION]");
    Realm realm = Realm.newBuilder().build();
    String realmId = "realmId-859416373";

    Realm actualResponse = client.createRealmAsync(parent, realm, realmId).get();
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockRealmsService.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    CreateRealmRequest actualRequest = (CreateRealmRequest) actualRequests.get(0);

    Assert.assertEquals(parent, LocationName.parse(actualRequest.getParent()));
    Assert.assertEquals(realm, actualRequest.getRealm());
    Assert.assertEquals(realmId, actualRequest.getRealmId());
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
      LocationName parent = LocationName.of("[PROJECT]", "[LOCATION]");
      Realm realm = Realm.newBuilder().build();
      String realmId = "realmId-859416373";

      client.createRealmAsync(parent, realm, realmId).get();
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

    RealmName name = RealmName.of("[PROJECT]", "[LOCATION]", "[REALM]");

    Empty actualResponse = client.deleteRealmAsync(name).get();
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockRealmsService.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    DeleteRealmRequest actualRequest = (DeleteRealmRequest) actualRequests.get(0);

    Assert.assertEquals(name, RealmName.parse(actualRequest.getName()));
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
      RealmName name = RealmName.of("[PROJECT]", "[LOCATION]", "[REALM]");

      client.deleteRealmAsync(name).get();
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
    RealmName name = RealmName.of("[PROJECT]", "[LOCATION]", "[REALM]");
    String timeZone = "timeZone36848094";
    String etag = "etag3123477";
    String description = "description-1724546052";
    Realm expectedResponse =
        Realm.newBuilder()
            .setName(name.toString())
            .setTimeZone(timeZone)
            .setEtag(etag)
            .setDescription(description)
            .build();
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

  @Test
  @SuppressWarnings("all")
  public void previewRealmUpdateTest() {
    String etag = "etag3123477";
    PreviewRealmUpdateResponse expectedResponse =
        PreviewRealmUpdateResponse.newBuilder().setEtag(etag).build();
    mockRealmsService.addResponse(expectedResponse);

    Realm realm = Realm.newBuilder().build();
    FieldMask updateMask = FieldMask.newBuilder().build();
    PreviewRealmUpdateRequest request =
        PreviewRealmUpdateRequest.newBuilder().setRealm(realm).setUpdateMask(updateMask).build();

    PreviewRealmUpdateResponse actualResponse = client.previewRealmUpdate(request);
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockRealmsService.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    PreviewRealmUpdateRequest actualRequest = (PreviewRealmUpdateRequest) actualRequests.get(0);

    Assert.assertEquals(realm, actualRequest.getRealm());
    Assert.assertEquals(updateMask, actualRequest.getUpdateMask());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  @SuppressWarnings("all")
  public void previewRealmUpdateExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(Status.INVALID_ARGUMENT);
    mockRealmsService.addException(exception);

    try {
      Realm realm = Realm.newBuilder().build();
      FieldMask updateMask = FieldMask.newBuilder().build();
      PreviewRealmUpdateRequest request =
          PreviewRealmUpdateRequest.newBuilder().setRealm(realm).setUpdateMask(updateMask).build();

      client.previewRealmUpdate(request);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception
    }
  }
}
