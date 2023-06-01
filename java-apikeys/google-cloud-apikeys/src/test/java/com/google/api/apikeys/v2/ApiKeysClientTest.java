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

package com.google.api.apikeys.v2;

import static com.google.api.apikeys.v2.ApiKeysClient.ListKeysPagedResponse;

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
public class ApiKeysClientTest {
  private static MockApiKeys mockApiKeys;
  private static MockServiceHelper mockServiceHelper;
  private LocalChannelProvider channelProvider;
  private ApiKeysClient client;

  @BeforeClass
  public static void startStaticServer() {
    mockApiKeys = new MockApiKeys();
    mockServiceHelper =
        new MockServiceHelper(
            UUID.randomUUID().toString(), Arrays.<MockGrpcService>asList(mockApiKeys));
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
    ApiKeysSettings settings =
        ApiKeysSettings.newBuilder()
            .setTransportChannelProvider(channelProvider)
            .setCredentialsProvider(NoCredentialsProvider.create())
            .build();
    client = ApiKeysClient.create(settings);
  }

  @After
  public void tearDown() throws Exception {
    client.close();
  }

  @Test
  public void createKeyTest() throws Exception {
    Key expectedResponse =
        Key.newBuilder()
            .setName(KeyName.of("[PROJECT]", "[LOCATION]", "[KEY]").toString())
            .setUid("uid115792")
            .setDisplayName("displayName1714148973")
            .setKeyString("keyString-1988270256")
            .setCreateTime(Timestamp.newBuilder().build())
            .setUpdateTime(Timestamp.newBuilder().build())
            .setDeleteTime(Timestamp.newBuilder().build())
            .putAllAnnotations(new HashMap<String, String>())
            .setRestrictions(Restrictions.newBuilder().build())
            .setEtag("etag3123477")
            .build();
    Operation resultOperation =
        Operation.newBuilder()
            .setName("createKeyTest")
            .setDone(true)
            .setResponse(Any.pack(expectedResponse))
            .build();
    mockApiKeys.addResponse(resultOperation);

    LocationName parent = LocationName.of("[PROJECT]", "[LOCATION]");
    Key key = Key.newBuilder().build();
    String keyId = "keyId101944282";

    Key actualResponse = client.createKeyAsync(parent, key, keyId).get();
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockApiKeys.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    CreateKeyRequest actualRequest = ((CreateKeyRequest) actualRequests.get(0));

    Assert.assertEquals(parent.toString(), actualRequest.getParent());
    Assert.assertEquals(key, actualRequest.getKey());
    Assert.assertEquals(keyId, actualRequest.getKeyId());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void createKeyExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockApiKeys.addException(exception);

    try {
      LocationName parent = LocationName.of("[PROJECT]", "[LOCATION]");
      Key key = Key.newBuilder().build();
      String keyId = "keyId101944282";
      client.createKeyAsync(parent, key, keyId).get();
      Assert.fail("No exception raised");
    } catch (ExecutionException e) {
      Assert.assertEquals(InvalidArgumentException.class, e.getCause().getClass());
      InvalidArgumentException apiException = ((InvalidArgumentException) e.getCause());
      Assert.assertEquals(StatusCode.Code.INVALID_ARGUMENT, apiException.getStatusCode().getCode());
    }
  }

  @Test
  public void createKeyTest2() throws Exception {
    Key expectedResponse =
        Key.newBuilder()
            .setName(KeyName.of("[PROJECT]", "[LOCATION]", "[KEY]").toString())
            .setUid("uid115792")
            .setDisplayName("displayName1714148973")
            .setKeyString("keyString-1988270256")
            .setCreateTime(Timestamp.newBuilder().build())
            .setUpdateTime(Timestamp.newBuilder().build())
            .setDeleteTime(Timestamp.newBuilder().build())
            .putAllAnnotations(new HashMap<String, String>())
            .setRestrictions(Restrictions.newBuilder().build())
            .setEtag("etag3123477")
            .build();
    Operation resultOperation =
        Operation.newBuilder()
            .setName("createKeyTest")
            .setDone(true)
            .setResponse(Any.pack(expectedResponse))
            .build();
    mockApiKeys.addResponse(resultOperation);

    String parent = "parent-995424086";
    Key key = Key.newBuilder().build();
    String keyId = "keyId101944282";

    Key actualResponse = client.createKeyAsync(parent, key, keyId).get();
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockApiKeys.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    CreateKeyRequest actualRequest = ((CreateKeyRequest) actualRequests.get(0));

    Assert.assertEquals(parent, actualRequest.getParent());
    Assert.assertEquals(key, actualRequest.getKey());
    Assert.assertEquals(keyId, actualRequest.getKeyId());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void createKeyExceptionTest2() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockApiKeys.addException(exception);

    try {
      String parent = "parent-995424086";
      Key key = Key.newBuilder().build();
      String keyId = "keyId101944282";
      client.createKeyAsync(parent, key, keyId).get();
      Assert.fail("No exception raised");
    } catch (ExecutionException e) {
      Assert.assertEquals(InvalidArgumentException.class, e.getCause().getClass());
      InvalidArgumentException apiException = ((InvalidArgumentException) e.getCause());
      Assert.assertEquals(StatusCode.Code.INVALID_ARGUMENT, apiException.getStatusCode().getCode());
    }
  }

  @Test
  public void listKeysTest() throws Exception {
    Key responsesElement = Key.newBuilder().build();
    ListKeysResponse expectedResponse =
        ListKeysResponse.newBuilder()
            .setNextPageToken("")
            .addAllKeys(Arrays.asList(responsesElement))
            .build();
    mockApiKeys.addResponse(expectedResponse);

    LocationName parent = LocationName.of("[PROJECT]", "[LOCATION]");

    ListKeysPagedResponse pagedListResponse = client.listKeys(parent);

    List<Key> resources = Lists.newArrayList(pagedListResponse.iterateAll());

    Assert.assertEquals(1, resources.size());
    Assert.assertEquals(expectedResponse.getKeysList().get(0), resources.get(0));

    List<AbstractMessage> actualRequests = mockApiKeys.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    ListKeysRequest actualRequest = ((ListKeysRequest) actualRequests.get(0));

    Assert.assertEquals(parent.toString(), actualRequest.getParent());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void listKeysExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockApiKeys.addException(exception);

    try {
      LocationName parent = LocationName.of("[PROJECT]", "[LOCATION]");
      client.listKeys(parent);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void listKeysTest2() throws Exception {
    Key responsesElement = Key.newBuilder().build();
    ListKeysResponse expectedResponse =
        ListKeysResponse.newBuilder()
            .setNextPageToken("")
            .addAllKeys(Arrays.asList(responsesElement))
            .build();
    mockApiKeys.addResponse(expectedResponse);

    String parent = "parent-995424086";

    ListKeysPagedResponse pagedListResponse = client.listKeys(parent);

    List<Key> resources = Lists.newArrayList(pagedListResponse.iterateAll());

    Assert.assertEquals(1, resources.size());
    Assert.assertEquals(expectedResponse.getKeysList().get(0), resources.get(0));

    List<AbstractMessage> actualRequests = mockApiKeys.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    ListKeysRequest actualRequest = ((ListKeysRequest) actualRequests.get(0));

    Assert.assertEquals(parent, actualRequest.getParent());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void listKeysExceptionTest2() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockApiKeys.addException(exception);

    try {
      String parent = "parent-995424086";
      client.listKeys(parent);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void getKeyTest() throws Exception {
    Key expectedResponse =
        Key.newBuilder()
            .setName(KeyName.of("[PROJECT]", "[LOCATION]", "[KEY]").toString())
            .setUid("uid115792")
            .setDisplayName("displayName1714148973")
            .setKeyString("keyString-1988270256")
            .setCreateTime(Timestamp.newBuilder().build())
            .setUpdateTime(Timestamp.newBuilder().build())
            .setDeleteTime(Timestamp.newBuilder().build())
            .putAllAnnotations(new HashMap<String, String>())
            .setRestrictions(Restrictions.newBuilder().build())
            .setEtag("etag3123477")
            .build();
    mockApiKeys.addResponse(expectedResponse);

    KeyName name = KeyName.of("[PROJECT]", "[LOCATION]", "[KEY]");

    Key actualResponse = client.getKey(name);
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockApiKeys.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    GetKeyRequest actualRequest = ((GetKeyRequest) actualRequests.get(0));

    Assert.assertEquals(name.toString(), actualRequest.getName());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void getKeyExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockApiKeys.addException(exception);

    try {
      KeyName name = KeyName.of("[PROJECT]", "[LOCATION]", "[KEY]");
      client.getKey(name);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void getKeyTest2() throws Exception {
    Key expectedResponse =
        Key.newBuilder()
            .setName(KeyName.of("[PROJECT]", "[LOCATION]", "[KEY]").toString())
            .setUid("uid115792")
            .setDisplayName("displayName1714148973")
            .setKeyString("keyString-1988270256")
            .setCreateTime(Timestamp.newBuilder().build())
            .setUpdateTime(Timestamp.newBuilder().build())
            .setDeleteTime(Timestamp.newBuilder().build())
            .putAllAnnotations(new HashMap<String, String>())
            .setRestrictions(Restrictions.newBuilder().build())
            .setEtag("etag3123477")
            .build();
    mockApiKeys.addResponse(expectedResponse);

    String name = "name3373707";

    Key actualResponse = client.getKey(name);
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockApiKeys.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    GetKeyRequest actualRequest = ((GetKeyRequest) actualRequests.get(0));

    Assert.assertEquals(name, actualRequest.getName());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void getKeyExceptionTest2() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockApiKeys.addException(exception);

    try {
      String name = "name3373707";
      client.getKey(name);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void getKeyStringTest() throws Exception {
    GetKeyStringResponse expectedResponse =
        GetKeyStringResponse.newBuilder().setKeyString("keyString-1988270256").build();
    mockApiKeys.addResponse(expectedResponse);

    KeyName name = KeyName.of("[PROJECT]", "[LOCATION]", "[KEY]");

    GetKeyStringResponse actualResponse = client.getKeyString(name);
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockApiKeys.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    GetKeyStringRequest actualRequest = ((GetKeyStringRequest) actualRequests.get(0));

    Assert.assertEquals(name.toString(), actualRequest.getName());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void getKeyStringExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockApiKeys.addException(exception);

    try {
      KeyName name = KeyName.of("[PROJECT]", "[LOCATION]", "[KEY]");
      client.getKeyString(name);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void getKeyStringTest2() throws Exception {
    GetKeyStringResponse expectedResponse =
        GetKeyStringResponse.newBuilder().setKeyString("keyString-1988270256").build();
    mockApiKeys.addResponse(expectedResponse);

    String name = "name3373707";

    GetKeyStringResponse actualResponse = client.getKeyString(name);
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockApiKeys.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    GetKeyStringRequest actualRequest = ((GetKeyStringRequest) actualRequests.get(0));

    Assert.assertEquals(name, actualRequest.getName());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void getKeyStringExceptionTest2() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockApiKeys.addException(exception);

    try {
      String name = "name3373707";
      client.getKeyString(name);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void updateKeyTest() throws Exception {
    Key expectedResponse =
        Key.newBuilder()
            .setName(KeyName.of("[PROJECT]", "[LOCATION]", "[KEY]").toString())
            .setUid("uid115792")
            .setDisplayName("displayName1714148973")
            .setKeyString("keyString-1988270256")
            .setCreateTime(Timestamp.newBuilder().build())
            .setUpdateTime(Timestamp.newBuilder().build())
            .setDeleteTime(Timestamp.newBuilder().build())
            .putAllAnnotations(new HashMap<String, String>())
            .setRestrictions(Restrictions.newBuilder().build())
            .setEtag("etag3123477")
            .build();
    Operation resultOperation =
        Operation.newBuilder()
            .setName("updateKeyTest")
            .setDone(true)
            .setResponse(Any.pack(expectedResponse))
            .build();
    mockApiKeys.addResponse(resultOperation);

    Key key = Key.newBuilder().build();
    FieldMask updateMask = FieldMask.newBuilder().build();

    Key actualResponse = client.updateKeyAsync(key, updateMask).get();
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockApiKeys.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    UpdateKeyRequest actualRequest = ((UpdateKeyRequest) actualRequests.get(0));

    Assert.assertEquals(key, actualRequest.getKey());
    Assert.assertEquals(updateMask, actualRequest.getUpdateMask());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void updateKeyExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockApiKeys.addException(exception);

    try {
      Key key = Key.newBuilder().build();
      FieldMask updateMask = FieldMask.newBuilder().build();
      client.updateKeyAsync(key, updateMask).get();
      Assert.fail("No exception raised");
    } catch (ExecutionException e) {
      Assert.assertEquals(InvalidArgumentException.class, e.getCause().getClass());
      InvalidArgumentException apiException = ((InvalidArgumentException) e.getCause());
      Assert.assertEquals(StatusCode.Code.INVALID_ARGUMENT, apiException.getStatusCode().getCode());
    }
  }

  @Test
  public void deleteKeyTest() throws Exception {
    Key expectedResponse =
        Key.newBuilder()
            .setName(KeyName.of("[PROJECT]", "[LOCATION]", "[KEY]").toString())
            .setUid("uid115792")
            .setDisplayName("displayName1714148973")
            .setKeyString("keyString-1988270256")
            .setCreateTime(Timestamp.newBuilder().build())
            .setUpdateTime(Timestamp.newBuilder().build())
            .setDeleteTime(Timestamp.newBuilder().build())
            .putAllAnnotations(new HashMap<String, String>())
            .setRestrictions(Restrictions.newBuilder().build())
            .setEtag("etag3123477")
            .build();
    Operation resultOperation =
        Operation.newBuilder()
            .setName("deleteKeyTest")
            .setDone(true)
            .setResponse(Any.pack(expectedResponse))
            .build();
    mockApiKeys.addResponse(resultOperation);

    KeyName name = KeyName.of("[PROJECT]", "[LOCATION]", "[KEY]");

    Key actualResponse = client.deleteKeyAsync(name).get();
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockApiKeys.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    DeleteKeyRequest actualRequest = ((DeleteKeyRequest) actualRequests.get(0));

    Assert.assertEquals(name.toString(), actualRequest.getName());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void deleteKeyExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockApiKeys.addException(exception);

    try {
      KeyName name = KeyName.of("[PROJECT]", "[LOCATION]", "[KEY]");
      client.deleteKeyAsync(name).get();
      Assert.fail("No exception raised");
    } catch (ExecutionException e) {
      Assert.assertEquals(InvalidArgumentException.class, e.getCause().getClass());
      InvalidArgumentException apiException = ((InvalidArgumentException) e.getCause());
      Assert.assertEquals(StatusCode.Code.INVALID_ARGUMENT, apiException.getStatusCode().getCode());
    }
  }

  @Test
  public void deleteKeyTest2() throws Exception {
    Key expectedResponse =
        Key.newBuilder()
            .setName(KeyName.of("[PROJECT]", "[LOCATION]", "[KEY]").toString())
            .setUid("uid115792")
            .setDisplayName("displayName1714148973")
            .setKeyString("keyString-1988270256")
            .setCreateTime(Timestamp.newBuilder().build())
            .setUpdateTime(Timestamp.newBuilder().build())
            .setDeleteTime(Timestamp.newBuilder().build())
            .putAllAnnotations(new HashMap<String, String>())
            .setRestrictions(Restrictions.newBuilder().build())
            .setEtag("etag3123477")
            .build();
    Operation resultOperation =
        Operation.newBuilder()
            .setName("deleteKeyTest")
            .setDone(true)
            .setResponse(Any.pack(expectedResponse))
            .build();
    mockApiKeys.addResponse(resultOperation);

    String name = "name3373707";

    Key actualResponse = client.deleteKeyAsync(name).get();
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockApiKeys.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    DeleteKeyRequest actualRequest = ((DeleteKeyRequest) actualRequests.get(0));

    Assert.assertEquals(name, actualRequest.getName());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void deleteKeyExceptionTest2() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockApiKeys.addException(exception);

    try {
      String name = "name3373707";
      client.deleteKeyAsync(name).get();
      Assert.fail("No exception raised");
    } catch (ExecutionException e) {
      Assert.assertEquals(InvalidArgumentException.class, e.getCause().getClass());
      InvalidArgumentException apiException = ((InvalidArgumentException) e.getCause());
      Assert.assertEquals(StatusCode.Code.INVALID_ARGUMENT, apiException.getStatusCode().getCode());
    }
  }

  @Test
  public void undeleteKeyTest() throws Exception {
    Key expectedResponse =
        Key.newBuilder()
            .setName(KeyName.of("[PROJECT]", "[LOCATION]", "[KEY]").toString())
            .setUid("uid115792")
            .setDisplayName("displayName1714148973")
            .setKeyString("keyString-1988270256")
            .setCreateTime(Timestamp.newBuilder().build())
            .setUpdateTime(Timestamp.newBuilder().build())
            .setDeleteTime(Timestamp.newBuilder().build())
            .putAllAnnotations(new HashMap<String, String>())
            .setRestrictions(Restrictions.newBuilder().build())
            .setEtag("etag3123477")
            .build();
    Operation resultOperation =
        Operation.newBuilder()
            .setName("undeleteKeyTest")
            .setDone(true)
            .setResponse(Any.pack(expectedResponse))
            .build();
    mockApiKeys.addResponse(resultOperation);

    UndeleteKeyRequest request =
        UndeleteKeyRequest.newBuilder()
            .setName(KeyName.of("[PROJECT]", "[LOCATION]", "[KEY]").toString())
            .build();

    Key actualResponse = client.undeleteKeyAsync(request).get();
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockApiKeys.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    UndeleteKeyRequest actualRequest = ((UndeleteKeyRequest) actualRequests.get(0));

    Assert.assertEquals(request.getName(), actualRequest.getName());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void undeleteKeyExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockApiKeys.addException(exception);

    try {
      UndeleteKeyRequest request =
          UndeleteKeyRequest.newBuilder()
              .setName(KeyName.of("[PROJECT]", "[LOCATION]", "[KEY]").toString())
              .build();
      client.undeleteKeyAsync(request).get();
      Assert.fail("No exception raised");
    } catch (ExecutionException e) {
      Assert.assertEquals(InvalidArgumentException.class, e.getCause().getClass());
      InvalidArgumentException apiException = ((InvalidArgumentException) e.getCause());
      Assert.assertEquals(StatusCode.Code.INVALID_ARGUMENT, apiException.getStatusCode().getCode());
    }
  }

  @Test
  public void lookupKeyTest() throws Exception {
    LookupKeyResponse expectedResponse =
        LookupKeyResponse.newBuilder().setParent("parent-995424086").setName("name3373707").build();
    mockApiKeys.addResponse(expectedResponse);

    LookupKeyRequest request =
        LookupKeyRequest.newBuilder().setKeyString("keyString-1988270256").build();

    LookupKeyResponse actualResponse = client.lookupKey(request);
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockApiKeys.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    LookupKeyRequest actualRequest = ((LookupKeyRequest) actualRequests.get(0));

    Assert.assertEquals(request.getKeyString(), actualRequest.getKeyString());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void lookupKeyExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockApiKeys.addException(exception);

    try {
      LookupKeyRequest request =
          LookupKeyRequest.newBuilder().setKeyString("keyString-1988270256").build();
      client.lookupKey(request);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }
}
