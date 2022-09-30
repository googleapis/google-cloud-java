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

import com.google.api.apikeys.v2.stub.HttpJsonApiKeysStub;
import com.google.api.gax.core.NoCredentialsProvider;
import com.google.api.gax.httpjson.GaxHttpJsonProperties;
import com.google.api.gax.httpjson.testing.MockHttpService;
import com.google.api.gax.rpc.ApiClientHeaderProvider;
import com.google.api.gax.rpc.ApiException;
import com.google.api.gax.rpc.ApiExceptionFactory;
import com.google.api.gax.rpc.InvalidArgumentException;
import com.google.api.gax.rpc.StatusCode;
import com.google.api.gax.rpc.testing.FakeStatusCode;
import com.google.common.collect.Lists;
import com.google.longrunning.Operation;
import com.google.protobuf.Any;
import com.google.protobuf.FieldMask;
import com.google.protobuf.Timestamp;
import java.io.IOException;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.concurrent.ExecutionException;
import javax.annotation.Generated;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Assert;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

@Generated("by gapic-generator-java")
public class ApiKeysClientHttpJsonTest {
  private static MockHttpService mockService;
  private static ApiKeysClient client;

  @BeforeClass
  public static void startStaticServer() throws IOException {
    mockService =
        new MockHttpService(
            HttpJsonApiKeysStub.getMethodDescriptors(), ApiKeysSettings.getDefaultEndpoint());
    ApiKeysSettings settings =
        ApiKeysSettings.newHttpJsonBuilder()
            .setTransportChannelProvider(
                ApiKeysSettings.defaultHttpJsonTransportProviderBuilder()
                    .setHttpTransport(mockService)
                    .build())
            .setCredentialsProvider(NoCredentialsProvider.create())
            .build();
    client = ApiKeysClient.create(settings);
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
    mockService.addResponse(resultOperation);

    LocationName parent = LocationName.of("[PROJECT]", "[LOCATION]");
    Key key = Key.newBuilder().build();
    String keyId = "keyId101944282";

    Key actualResponse = client.createKeyAsync(parent, key, keyId).get();
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
  public void createKeyExceptionTest() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

    try {
      LocationName parent = LocationName.of("[PROJECT]", "[LOCATION]");
      Key key = Key.newBuilder().build();
      String keyId = "keyId101944282";
      client.createKeyAsync(parent, key, keyId).get();
      Assert.fail("No exception raised");
    } catch (ExecutionException e) {
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
    mockService.addResponse(resultOperation);

    String parent = "projects/project-5833/locations/location-5833";
    Key key = Key.newBuilder().build();
    String keyId = "keyId101944282";

    Key actualResponse = client.createKeyAsync(parent, key, keyId).get();
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
  public void createKeyExceptionTest2() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

    try {
      String parent = "projects/project-5833/locations/location-5833";
      Key key = Key.newBuilder().build();
      String keyId = "keyId101944282";
      client.createKeyAsync(parent, key, keyId).get();
      Assert.fail("No exception raised");
    } catch (ExecutionException e) {
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
    mockService.addResponse(expectedResponse);

    LocationName parent = LocationName.of("[PROJECT]", "[LOCATION]");

    ListKeysPagedResponse pagedListResponse = client.listKeys(parent);

    List<Key> resources = Lists.newArrayList(pagedListResponse.iterateAll());

    Assert.assertEquals(1, resources.size());
    Assert.assertEquals(expectedResponse.getKeysList().get(0), resources.get(0));

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
  public void listKeysExceptionTest() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

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
    mockService.addResponse(expectedResponse);

    String parent = "projects/project-5833/locations/location-5833";

    ListKeysPagedResponse pagedListResponse = client.listKeys(parent);

    List<Key> resources = Lists.newArrayList(pagedListResponse.iterateAll());

    Assert.assertEquals(1, resources.size());
    Assert.assertEquals(expectedResponse.getKeysList().get(0), resources.get(0));

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
  public void listKeysExceptionTest2() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

    try {
      String parent = "projects/project-5833/locations/location-5833";
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
    mockService.addResponse(expectedResponse);

    KeyName name = KeyName.of("[PROJECT]", "[LOCATION]", "[KEY]");

    Key actualResponse = client.getKey(name);
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
  public void getKeyExceptionTest() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

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
    mockService.addResponse(expectedResponse);

    String name = "projects/project-4172/locations/location-4172/keys/key-4172";

    Key actualResponse = client.getKey(name);
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
  public void getKeyExceptionTest2() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

    try {
      String name = "projects/project-4172/locations/location-4172/keys/key-4172";
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
    mockService.addResponse(expectedResponse);

    KeyName name = KeyName.of("[PROJECT]", "[LOCATION]", "[KEY]");

    GetKeyStringResponse actualResponse = client.getKeyString(name);
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
  public void getKeyStringExceptionTest() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

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
    mockService.addResponse(expectedResponse);

    String name = "projects/project-4172/locations/location-4172/keys/key-4172";

    GetKeyStringResponse actualResponse = client.getKeyString(name);
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
  public void getKeyStringExceptionTest2() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

    try {
      String name = "projects/project-4172/locations/location-4172/keys/key-4172";
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
    mockService.addResponse(resultOperation);

    Key key =
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
    FieldMask updateMask = FieldMask.newBuilder().build();

    Key actualResponse = client.updateKeyAsync(key, updateMask).get();
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
  public void updateKeyExceptionTest() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

    try {
      Key key =
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
      FieldMask updateMask = FieldMask.newBuilder().build();
      client.updateKeyAsync(key, updateMask).get();
      Assert.fail("No exception raised");
    } catch (ExecutionException e) {
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
    mockService.addResponse(resultOperation);

    KeyName name = KeyName.of("[PROJECT]", "[LOCATION]", "[KEY]");

    Key actualResponse = client.deleteKeyAsync(name).get();
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
  public void deleteKeyExceptionTest() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

    try {
      KeyName name = KeyName.of("[PROJECT]", "[LOCATION]", "[KEY]");
      client.deleteKeyAsync(name).get();
      Assert.fail("No exception raised");
    } catch (ExecutionException e) {
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
    mockService.addResponse(resultOperation);

    String name = "projects/project-4172/locations/location-4172/keys/key-4172";

    Key actualResponse = client.deleteKeyAsync(name).get();
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
  public void deleteKeyExceptionTest2() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

    try {
      String name = "projects/project-4172/locations/location-4172/keys/key-4172";
      client.deleteKeyAsync(name).get();
      Assert.fail("No exception raised");
    } catch (ExecutionException e) {
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
    mockService.addResponse(resultOperation);

    UndeleteKeyRequest request =
        UndeleteKeyRequest.newBuilder()
            .setName(KeyName.of("[PROJECT]", "[LOCATION]", "[KEY]").toString())
            .build();

    Key actualResponse = client.undeleteKeyAsync(request).get();
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
  public void undeleteKeyExceptionTest() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

    try {
      UndeleteKeyRequest request =
          UndeleteKeyRequest.newBuilder()
              .setName(KeyName.of("[PROJECT]", "[LOCATION]", "[KEY]").toString())
              .build();
      client.undeleteKeyAsync(request).get();
      Assert.fail("No exception raised");
    } catch (ExecutionException e) {
    }
  }

  @Test
  public void lookupKeyTest() throws Exception {
    LookupKeyResponse expectedResponse =
        LookupKeyResponse.newBuilder().setParent("parent-995424086").setName("name3373707").build();
    mockService.addResponse(expectedResponse);

    LookupKeyRequest request =
        LookupKeyRequest.newBuilder().setKeyString("keyString-1988270256").build();

    LookupKeyResponse actualResponse = client.lookupKey(request);
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
  public void lookupKeyExceptionTest() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

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
