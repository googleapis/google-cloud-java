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
import com.google.protobuf.Timestamp;
import io.grpc.StatusRuntimeException;
import java.io.IOException;
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
public class RealmsServiceClientTest {
  private static MockRealmsService mockRealmsService;
  private static MockServiceHelper mockServiceHelper;
  private LocalChannelProvider channelProvider;
  private RealmsServiceClient client;

  @BeforeClass
  public static void startStaticServer() {
    mockRealmsService = new MockRealmsService();
    mockServiceHelper =
        new MockServiceHelper(
            UUID.randomUUID().toString(), Arrays.<MockGrpcService>asList(mockRealmsService));
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
  public void listRealmsTest() throws Exception {
    Realm responsesElement = Realm.newBuilder().build();
    ListRealmsResponse expectedResponse =
        ListRealmsResponse.newBuilder()
            .setNextPageToken("")
            .addAllRealms(Arrays.asList(responsesElement))
            .build();
    mockRealmsService.addResponse(expectedResponse);

    LocationName parent = LocationName.of("[PROJECT]", "[LOCATION]");

    ListRealmsPagedResponse pagedListResponse = client.listRealms(parent);

    List<Realm> resources = Lists.newArrayList(pagedListResponse.iterateAll());

    Assert.assertEquals(1, resources.size());
    Assert.assertEquals(expectedResponse.getRealmsList().get(0), resources.get(0));

    List<AbstractMessage> actualRequests = mockRealmsService.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    ListRealmsRequest actualRequest = ((ListRealmsRequest) actualRequests.get(0));

    Assert.assertEquals(parent.toString(), actualRequest.getParent());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void listRealmsExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockRealmsService.addException(exception);

    try {
      LocationName parent = LocationName.of("[PROJECT]", "[LOCATION]");
      client.listRealms(parent);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void listRealmsTest2() throws Exception {
    Realm responsesElement = Realm.newBuilder().build();
    ListRealmsResponse expectedResponse =
        ListRealmsResponse.newBuilder()
            .setNextPageToken("")
            .addAllRealms(Arrays.asList(responsesElement))
            .build();
    mockRealmsService.addResponse(expectedResponse);

    String parent = "parent-995424086";

    ListRealmsPagedResponse pagedListResponse = client.listRealms(parent);

    List<Realm> resources = Lists.newArrayList(pagedListResponse.iterateAll());

    Assert.assertEquals(1, resources.size());
    Assert.assertEquals(expectedResponse.getRealmsList().get(0), resources.get(0));

    List<AbstractMessage> actualRequests = mockRealmsService.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    ListRealmsRequest actualRequest = ((ListRealmsRequest) actualRequests.get(0));

    Assert.assertEquals(parent, actualRequest.getParent());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void listRealmsExceptionTest2() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockRealmsService.addException(exception);

    try {
      String parent = "parent-995424086";
      client.listRealms(parent);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void getRealmTest() throws Exception {
    Realm expectedResponse =
        Realm.newBuilder()
            .setName(RealmName.of("[PROJECT]", "[LOCATION]", "[REALM]").toString())
            .setCreateTime(Timestamp.newBuilder().build())
            .setUpdateTime(Timestamp.newBuilder().build())
            .putAllLabels(new HashMap<String, String>())
            .setTimeZone("timeZone-2077180903")
            .setEtag("etag3123477")
            .setDescription("description-1724546052")
            .build();
    mockRealmsService.addResponse(expectedResponse);

    RealmName name = RealmName.of("[PROJECT]", "[LOCATION]", "[REALM]");

    Realm actualResponse = client.getRealm(name);
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockRealmsService.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    GetRealmRequest actualRequest = ((GetRealmRequest) actualRequests.get(0));

    Assert.assertEquals(name.toString(), actualRequest.getName());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void getRealmExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockRealmsService.addException(exception);

    try {
      RealmName name = RealmName.of("[PROJECT]", "[LOCATION]", "[REALM]");
      client.getRealm(name);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void getRealmTest2() throws Exception {
    Realm expectedResponse =
        Realm.newBuilder()
            .setName(RealmName.of("[PROJECT]", "[LOCATION]", "[REALM]").toString())
            .setCreateTime(Timestamp.newBuilder().build())
            .setUpdateTime(Timestamp.newBuilder().build())
            .putAllLabels(new HashMap<String, String>())
            .setTimeZone("timeZone-2077180903")
            .setEtag("etag3123477")
            .setDescription("description-1724546052")
            .build();
    mockRealmsService.addResponse(expectedResponse);

    String name = "name3373707";

    Realm actualResponse = client.getRealm(name);
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockRealmsService.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    GetRealmRequest actualRequest = ((GetRealmRequest) actualRequests.get(0));

    Assert.assertEquals(name, actualRequest.getName());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void getRealmExceptionTest2() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockRealmsService.addException(exception);

    try {
      String name = "name3373707";
      client.getRealm(name);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void createRealmTest() throws Exception {
    Realm expectedResponse =
        Realm.newBuilder()
            .setName(RealmName.of("[PROJECT]", "[LOCATION]", "[REALM]").toString())
            .setCreateTime(Timestamp.newBuilder().build())
            .setUpdateTime(Timestamp.newBuilder().build())
            .putAllLabels(new HashMap<String, String>())
            .setTimeZone("timeZone-2077180903")
            .setEtag("etag3123477")
            .setDescription("description-1724546052")
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
    String realmId = "realmId1080654858";

    Realm actualResponse = client.createRealmAsync(parent, realm, realmId).get();
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockRealmsService.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    CreateRealmRequest actualRequest = ((CreateRealmRequest) actualRequests.get(0));

    Assert.assertEquals(parent.toString(), actualRequest.getParent());
    Assert.assertEquals(realm, actualRequest.getRealm());
    Assert.assertEquals(realmId, actualRequest.getRealmId());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void createRealmExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockRealmsService.addException(exception);

    try {
      LocationName parent = LocationName.of("[PROJECT]", "[LOCATION]");
      Realm realm = Realm.newBuilder().build();
      String realmId = "realmId1080654858";
      client.createRealmAsync(parent, realm, realmId).get();
      Assert.fail("No exception raised");
    } catch (ExecutionException e) {
      Assert.assertEquals(InvalidArgumentException.class, e.getCause().getClass());
      InvalidArgumentException apiException = ((InvalidArgumentException) e.getCause());
      Assert.assertEquals(StatusCode.Code.INVALID_ARGUMENT, apiException.getStatusCode().getCode());
    }
  }

  @Test
  public void createRealmTest2() throws Exception {
    Realm expectedResponse =
        Realm.newBuilder()
            .setName(RealmName.of("[PROJECT]", "[LOCATION]", "[REALM]").toString())
            .setCreateTime(Timestamp.newBuilder().build())
            .setUpdateTime(Timestamp.newBuilder().build())
            .putAllLabels(new HashMap<String, String>())
            .setTimeZone("timeZone-2077180903")
            .setEtag("etag3123477")
            .setDescription("description-1724546052")
            .build();
    Operation resultOperation =
        Operation.newBuilder()
            .setName("createRealmTest")
            .setDone(true)
            .setResponse(Any.pack(expectedResponse))
            .build();
    mockRealmsService.addResponse(resultOperation);

    String parent = "parent-995424086";
    Realm realm = Realm.newBuilder().build();
    String realmId = "realmId1080654858";

    Realm actualResponse = client.createRealmAsync(parent, realm, realmId).get();
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockRealmsService.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    CreateRealmRequest actualRequest = ((CreateRealmRequest) actualRequests.get(0));

    Assert.assertEquals(parent, actualRequest.getParent());
    Assert.assertEquals(realm, actualRequest.getRealm());
    Assert.assertEquals(realmId, actualRequest.getRealmId());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void createRealmExceptionTest2() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockRealmsService.addException(exception);

    try {
      String parent = "parent-995424086";
      Realm realm = Realm.newBuilder().build();
      String realmId = "realmId1080654858";
      client.createRealmAsync(parent, realm, realmId).get();
      Assert.fail("No exception raised");
    } catch (ExecutionException e) {
      Assert.assertEquals(InvalidArgumentException.class, e.getCause().getClass());
      InvalidArgumentException apiException = ((InvalidArgumentException) e.getCause());
      Assert.assertEquals(StatusCode.Code.INVALID_ARGUMENT, apiException.getStatusCode().getCode());
    }
  }

  @Test
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

    client.deleteRealmAsync(name).get();

    List<AbstractMessage> actualRequests = mockRealmsService.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    DeleteRealmRequest actualRequest = ((DeleteRealmRequest) actualRequests.get(0));

    Assert.assertEquals(name.toString(), actualRequest.getName());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void deleteRealmExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockRealmsService.addException(exception);

    try {
      RealmName name = RealmName.of("[PROJECT]", "[LOCATION]", "[REALM]");
      client.deleteRealmAsync(name).get();
      Assert.fail("No exception raised");
    } catch (ExecutionException e) {
      Assert.assertEquals(InvalidArgumentException.class, e.getCause().getClass());
      InvalidArgumentException apiException = ((InvalidArgumentException) e.getCause());
      Assert.assertEquals(StatusCode.Code.INVALID_ARGUMENT, apiException.getStatusCode().getCode());
    }
  }

  @Test
  public void deleteRealmTest2() throws Exception {
    Empty expectedResponse = Empty.newBuilder().build();
    Operation resultOperation =
        Operation.newBuilder()
            .setName("deleteRealmTest")
            .setDone(true)
            .setResponse(Any.pack(expectedResponse))
            .build();
    mockRealmsService.addResponse(resultOperation);

    String name = "name3373707";

    client.deleteRealmAsync(name).get();

    List<AbstractMessage> actualRequests = mockRealmsService.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    DeleteRealmRequest actualRequest = ((DeleteRealmRequest) actualRequests.get(0));

    Assert.assertEquals(name, actualRequest.getName());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void deleteRealmExceptionTest2() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockRealmsService.addException(exception);

    try {
      String name = "name3373707";
      client.deleteRealmAsync(name).get();
      Assert.fail("No exception raised");
    } catch (ExecutionException e) {
      Assert.assertEquals(InvalidArgumentException.class, e.getCause().getClass());
      InvalidArgumentException apiException = ((InvalidArgumentException) e.getCause());
      Assert.assertEquals(StatusCode.Code.INVALID_ARGUMENT, apiException.getStatusCode().getCode());
    }
  }

  @Test
  public void updateRealmTest() throws Exception {
    Realm expectedResponse =
        Realm.newBuilder()
            .setName(RealmName.of("[PROJECT]", "[LOCATION]", "[REALM]").toString())
            .setCreateTime(Timestamp.newBuilder().build())
            .setUpdateTime(Timestamp.newBuilder().build())
            .putAllLabels(new HashMap<String, String>())
            .setTimeZone("timeZone-2077180903")
            .setEtag("etag3123477")
            .setDescription("description-1724546052")
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
    UpdateRealmRequest actualRequest = ((UpdateRealmRequest) actualRequests.get(0));

    Assert.assertEquals(realm, actualRequest.getRealm());
    Assert.assertEquals(updateMask, actualRequest.getUpdateMask());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void updateRealmExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockRealmsService.addException(exception);

    try {
      Realm realm = Realm.newBuilder().build();
      FieldMask updateMask = FieldMask.newBuilder().build();
      client.updateRealmAsync(realm, updateMask).get();
      Assert.fail("No exception raised");
    } catch (ExecutionException e) {
      Assert.assertEquals(InvalidArgumentException.class, e.getCause().getClass());
      InvalidArgumentException apiException = ((InvalidArgumentException) e.getCause());
      Assert.assertEquals(StatusCode.Code.INVALID_ARGUMENT, apiException.getStatusCode().getCode());
    }
  }

  @Test
  public void previewRealmUpdateTest() throws Exception {
    PreviewRealmUpdateResponse expectedResponse =
        PreviewRealmUpdateResponse.newBuilder()
            .setEtag("etag3123477")
            .setTargetState(TargetState.newBuilder().build())
            .build();
    mockRealmsService.addResponse(expectedResponse);

    PreviewRealmUpdateRequest request =
        PreviewRealmUpdateRequest.newBuilder()
            .setRealm(Realm.newBuilder().build())
            .setUpdateMask(FieldMask.newBuilder().build())
            .setPreviewTime(Timestamp.newBuilder().build())
            .build();

    PreviewRealmUpdateResponse actualResponse = client.previewRealmUpdate(request);
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockRealmsService.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    PreviewRealmUpdateRequest actualRequest = ((PreviewRealmUpdateRequest) actualRequests.get(0));

    Assert.assertEquals(request.getRealm(), actualRequest.getRealm());
    Assert.assertEquals(request.getUpdateMask(), actualRequest.getUpdateMask());
    Assert.assertEquals(request.getPreviewTime(), actualRequest.getPreviewTime());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void previewRealmUpdateExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockRealmsService.addException(exception);

    try {
      PreviewRealmUpdateRequest request =
          PreviewRealmUpdateRequest.newBuilder()
              .setRealm(Realm.newBuilder().build())
              .setUpdateMask(FieldMask.newBuilder().build())
              .setPreviewTime(Timestamp.newBuilder().build())
              .build();
      client.previewRealmUpdate(request);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }
}
