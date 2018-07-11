/*
 * Copyright 2018 Google LLC
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
package com.google.cloud.kms.v1;

import static com.google.cloud.kms.v1.KeyManagementServiceClient.ListCryptoKeyVersionsPagedResponse;
import static com.google.cloud.kms.v1.KeyManagementServiceClient.ListCryptoKeysPagedResponse;
import static com.google.cloud.kms.v1.KeyManagementServiceClient.ListKeyRingsPagedResponse;

import com.google.api.gax.core.NoCredentialsProvider;
import com.google.api.gax.grpc.GaxGrpcProperties;
import com.google.api.gax.grpc.testing.LocalChannelProvider;
import com.google.api.gax.grpc.testing.MockGrpcService;
import com.google.api.gax.grpc.testing.MockServiceHelper;
import com.google.api.gax.rpc.ApiClientHeaderProvider;
import com.google.api.gax.rpc.InvalidArgumentException;
import com.google.cloud.kms.v1.CryptoKey.CryptoKeyPurpose;
import com.google.common.collect.Lists;
import com.google.iam.v1.GetIamPolicyRequest;
import com.google.iam.v1.Policy;
import com.google.iam.v1.SetIamPolicyRequest;
import com.google.iam.v1.TestIamPermissionsRequest;
import com.google.iam.v1.TestIamPermissionsResponse;
import com.google.protobuf.ByteString;
import com.google.protobuf.Duration;
import com.google.protobuf.FieldMask;
import com.google.protobuf.GeneratedMessageV3;
import com.google.protobuf.Timestamp;
import io.grpc.Status;
import io.grpc.StatusRuntimeException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Objects;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Assert;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

@javax.annotation.Generated("by GAPIC")
public class KeyManagementServiceClientTest {
  private static MockKeyManagementService mockKeyManagementService;
  private static MockIAMPolicy mockIAMPolicy;
  private static MockServiceHelper serviceHelper;
  private KeyManagementServiceClient client;
  private LocalChannelProvider channelProvider;

  @BeforeClass
  public static void startStaticServer() {
    mockKeyManagementService = new MockKeyManagementService();
    mockIAMPolicy = new MockIAMPolicy();
    serviceHelper =
        new MockServiceHelper(
            "in-process-1",
            Arrays.<MockGrpcService>asList(mockKeyManagementService, mockIAMPolicy));
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
    KeyManagementServiceSettings settings =
        KeyManagementServiceSettings.newBuilder()
            .setTransportChannelProvider(channelProvider)
            .setCredentialsProvider(NoCredentialsProvider.create())
            .build();
    client = KeyManagementServiceClient.create(settings);
  }

  @After
  public void tearDown() throws Exception {
    client.close();
  }

  @Test
  @SuppressWarnings("all")
  public void listKeyRingsTest() {
    String nextPageToken = "";
    int totalSize = 705419236;
    KeyRing keyRingsElement = KeyRing.newBuilder().build();
    List<KeyRing> keyRings = Arrays.asList(keyRingsElement);
    ListKeyRingsResponse expectedResponse =
        ListKeyRingsResponse.newBuilder()
            .setNextPageToken(nextPageToken)
            .setTotalSize(totalSize)
            .addAllKeyRings(keyRings)
            .build();
    mockKeyManagementService.addResponse(expectedResponse);

    LocationName parent = LocationName.of("[PROJECT]", "[LOCATION]");

    ListKeyRingsPagedResponse pagedListResponse = client.listKeyRings(parent);

    List<KeyRing> resources = Lists.newArrayList(pagedListResponse.iterateAll());
    Assert.assertEquals(1, resources.size());
    Assert.assertEquals(expectedResponse.getKeyRingsList().get(0), resources.get(0));

    List<GeneratedMessageV3> actualRequests = mockKeyManagementService.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    ListKeyRingsRequest actualRequest = (ListKeyRingsRequest) actualRequests.get(0);

    Assert.assertEquals(parent, LocationName.parse(actualRequest.getParent()));
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  @SuppressWarnings("all")
  public void listKeyRingsExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(Status.INVALID_ARGUMENT);
    mockKeyManagementService.addException(exception);

    try {
      LocationName parent = LocationName.of("[PROJECT]", "[LOCATION]");

      client.listKeyRings(parent);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception
    }
  }

  @Test
  @SuppressWarnings("all")
  public void listCryptoKeysTest() {
    String nextPageToken = "";
    int totalSize = 705419236;
    CryptoKey cryptoKeysElement = CryptoKey.newBuilder().build();
    List<CryptoKey> cryptoKeys = Arrays.asList(cryptoKeysElement);
    ListCryptoKeysResponse expectedResponse =
        ListCryptoKeysResponse.newBuilder()
            .setNextPageToken(nextPageToken)
            .setTotalSize(totalSize)
            .addAllCryptoKeys(cryptoKeys)
            .build();
    mockKeyManagementService.addResponse(expectedResponse);

    KeyRingName parent = KeyRingName.of("[PROJECT]", "[LOCATION]", "[KEY_RING]");

    ListCryptoKeysPagedResponse pagedListResponse = client.listCryptoKeys(parent);

    List<CryptoKey> resources = Lists.newArrayList(pagedListResponse.iterateAll());
    Assert.assertEquals(1, resources.size());
    Assert.assertEquals(expectedResponse.getCryptoKeysList().get(0), resources.get(0));

    List<GeneratedMessageV3> actualRequests = mockKeyManagementService.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    ListCryptoKeysRequest actualRequest = (ListCryptoKeysRequest) actualRequests.get(0);

    Assert.assertEquals(parent, KeyRingName.parse(actualRequest.getParent()));
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  @SuppressWarnings("all")
  public void listCryptoKeysExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(Status.INVALID_ARGUMENT);
    mockKeyManagementService.addException(exception);

    try {
      KeyRingName parent = KeyRingName.of("[PROJECT]", "[LOCATION]", "[KEY_RING]");

      client.listCryptoKeys(parent);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception
    }
  }

  @Test
  @SuppressWarnings("all")
  public void listCryptoKeyVersionsTest() {
    String nextPageToken = "";
    int totalSize = 705419236;
    CryptoKeyVersion cryptoKeyVersionsElement = CryptoKeyVersion.newBuilder().build();
    List<CryptoKeyVersion> cryptoKeyVersions = Arrays.asList(cryptoKeyVersionsElement);
    ListCryptoKeyVersionsResponse expectedResponse =
        ListCryptoKeyVersionsResponse.newBuilder()
            .setNextPageToken(nextPageToken)
            .setTotalSize(totalSize)
            .addAllCryptoKeyVersions(cryptoKeyVersions)
            .build();
    mockKeyManagementService.addResponse(expectedResponse);

    CryptoKeyName parent =
        CryptoKeyName.of("[PROJECT]", "[LOCATION]", "[KEY_RING]", "[CRYPTO_KEY]");

    ListCryptoKeyVersionsPagedResponse pagedListResponse = client.listCryptoKeyVersions(parent);

    List<CryptoKeyVersion> resources = Lists.newArrayList(pagedListResponse.iterateAll());
    Assert.assertEquals(1, resources.size());
    Assert.assertEquals(expectedResponse.getCryptoKeyVersionsList().get(0), resources.get(0));

    List<GeneratedMessageV3> actualRequests = mockKeyManagementService.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    ListCryptoKeyVersionsRequest actualRequest =
        (ListCryptoKeyVersionsRequest) actualRequests.get(0);

    Assert.assertEquals(parent, CryptoKeyName.parse(actualRequest.getParent()));
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  @SuppressWarnings("all")
  public void listCryptoKeyVersionsExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(Status.INVALID_ARGUMENT);
    mockKeyManagementService.addException(exception);

    try {
      CryptoKeyName parent =
          CryptoKeyName.of("[PROJECT]", "[LOCATION]", "[KEY_RING]", "[CRYPTO_KEY]");

      client.listCryptoKeyVersions(parent);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception
    }
  }

  @Test
  @SuppressWarnings("all")
  public void getKeyRingTest() {
    KeyRingName name2 = KeyRingName.of("[PROJECT]", "[LOCATION]", "[KEY_RING]");
    KeyRing expectedResponse = KeyRing.newBuilder().setName(name2.toString()).build();
    mockKeyManagementService.addResponse(expectedResponse);

    KeyRingName name = KeyRingName.of("[PROJECT]", "[LOCATION]", "[KEY_RING]");

    KeyRing actualResponse = client.getKeyRing(name);
    Assert.assertEquals(expectedResponse, actualResponse);

    List<GeneratedMessageV3> actualRequests = mockKeyManagementService.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    GetKeyRingRequest actualRequest = (GetKeyRingRequest) actualRequests.get(0);

    Assert.assertEquals(name, KeyRingName.parse(actualRequest.getName()));
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  @SuppressWarnings("all")
  public void getKeyRingExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(Status.INVALID_ARGUMENT);
    mockKeyManagementService.addException(exception);

    try {
      KeyRingName name = KeyRingName.of("[PROJECT]", "[LOCATION]", "[KEY_RING]");

      client.getKeyRing(name);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception
    }
  }

  @Test
  @SuppressWarnings("all")
  public void getCryptoKeyTest() {
    CryptoKeyName name2 = CryptoKeyName.of("[PROJECT]", "[LOCATION]", "[KEY_RING]", "[CRYPTO_KEY]");
    CryptoKey expectedResponse = CryptoKey.newBuilder().setName(name2.toString()).build();
    mockKeyManagementService.addResponse(expectedResponse);

    CryptoKeyName name = CryptoKeyName.of("[PROJECT]", "[LOCATION]", "[KEY_RING]", "[CRYPTO_KEY]");

    CryptoKey actualResponse = client.getCryptoKey(name);
    Assert.assertEquals(expectedResponse, actualResponse);

    List<GeneratedMessageV3> actualRequests = mockKeyManagementService.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    GetCryptoKeyRequest actualRequest = (GetCryptoKeyRequest) actualRequests.get(0);

    Assert.assertEquals(name, CryptoKeyName.parse(actualRequest.getName()));
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  @SuppressWarnings("all")
  public void getCryptoKeyExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(Status.INVALID_ARGUMENT);
    mockKeyManagementService.addException(exception);

    try {
      CryptoKeyName name =
          CryptoKeyName.of("[PROJECT]", "[LOCATION]", "[KEY_RING]", "[CRYPTO_KEY]");

      client.getCryptoKey(name);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception
    }
  }

  @Test
  @SuppressWarnings("all")
  public void getCryptoKeyVersionTest() {
    CryptoKeyVersionName name2 =
        CryptoKeyVersionName.of(
            "[PROJECT]", "[LOCATION]", "[KEY_RING]", "[CRYPTO_KEY]", "[CRYPTO_KEY_VERSION]");
    CryptoKeyVersion expectedResponse =
        CryptoKeyVersion.newBuilder().setName(name2.toString()).build();
    mockKeyManagementService.addResponse(expectedResponse);

    CryptoKeyVersionName name =
        CryptoKeyVersionName.of(
            "[PROJECT]", "[LOCATION]", "[KEY_RING]", "[CRYPTO_KEY]", "[CRYPTO_KEY_VERSION]");

    CryptoKeyVersion actualResponse = client.getCryptoKeyVersion(name);
    Assert.assertEquals(expectedResponse, actualResponse);

    List<GeneratedMessageV3> actualRequests = mockKeyManagementService.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    GetCryptoKeyVersionRequest actualRequest = (GetCryptoKeyVersionRequest) actualRequests.get(0);

    Assert.assertEquals(name, CryptoKeyVersionName.parse(actualRequest.getName()));
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  @SuppressWarnings("all")
  public void getCryptoKeyVersionExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(Status.INVALID_ARGUMENT);
    mockKeyManagementService.addException(exception);

    try {
      CryptoKeyVersionName name =
          CryptoKeyVersionName.of(
              "[PROJECT]", "[LOCATION]", "[KEY_RING]", "[CRYPTO_KEY]", "[CRYPTO_KEY_VERSION]");

      client.getCryptoKeyVersion(name);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception
    }
  }

  @Test
  @SuppressWarnings("all")
  public void createKeyRingTest() {
    KeyRingName name = KeyRingName.of("[PROJECT]", "[LOCATION]", "[KEY_RING]");
    KeyRing expectedResponse = KeyRing.newBuilder().setName(name.toString()).build();
    mockKeyManagementService.addResponse(expectedResponse);

    LocationName parent = LocationName.of("[PROJECT]", "[LOCATION]");
    String keyRingId = "keyRingId-2056646742";
    KeyRing keyRing = KeyRing.newBuilder().build();

    KeyRing actualResponse = client.createKeyRing(parent, keyRingId, keyRing);
    Assert.assertEquals(expectedResponse, actualResponse);

    List<GeneratedMessageV3> actualRequests = mockKeyManagementService.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    CreateKeyRingRequest actualRequest = (CreateKeyRingRequest) actualRequests.get(0);

    Assert.assertEquals(parent, LocationName.parse(actualRequest.getParent()));
    Assert.assertEquals(keyRingId, actualRequest.getKeyRingId());
    Assert.assertEquals(keyRing, actualRequest.getKeyRing());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  @SuppressWarnings("all")
  public void createKeyRingExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(Status.INVALID_ARGUMENT);
    mockKeyManagementService.addException(exception);

    try {
      LocationName parent = LocationName.of("[PROJECT]", "[LOCATION]");
      String keyRingId = "keyRingId-2056646742";
      KeyRing keyRing = KeyRing.newBuilder().build();

      client.createKeyRing(parent, keyRingId, keyRing);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception
    }
  }

  @Test
  @SuppressWarnings("all")
  public void createCryptoKeyTest() {
    CryptoKeyName name = CryptoKeyName.of("[PROJECT]", "[LOCATION]", "[KEY_RING]", "[CRYPTO_KEY]");
    CryptoKey expectedResponse = CryptoKey.newBuilder().setName(name.toString()).build();
    mockKeyManagementService.addResponse(expectedResponse);

    KeyRingName parent = KeyRingName.of("[PROJECT]", "[LOCATION]", "[KEY_RING]");
    String cryptoKeyId = "my-app-key";
    CryptoKey.CryptoKeyPurpose purpose = CryptoKey.CryptoKeyPurpose.ENCRYPT_DECRYPT;
    long seconds = 2147483647L;
    Timestamp nextRotationTime = Timestamp.newBuilder().setSeconds(seconds).build();
    long seconds2 = 604800L;
    Duration rotationPeriod = Duration.newBuilder().setSeconds(seconds2).build();
    CryptoKey cryptoKey =
        CryptoKey.newBuilder()
            .setPurpose(purpose)
            .setNextRotationTime(nextRotationTime)
            .setRotationPeriod(rotationPeriod)
            .build();

    CryptoKey actualResponse = client.createCryptoKey(parent, cryptoKeyId, cryptoKey);
    Assert.assertEquals(expectedResponse, actualResponse);

    List<GeneratedMessageV3> actualRequests = mockKeyManagementService.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    CreateCryptoKeyRequest actualRequest = (CreateCryptoKeyRequest) actualRequests.get(0);

    Assert.assertEquals(parent, KeyRingName.parse(actualRequest.getParent()));
    Assert.assertEquals(cryptoKeyId, actualRequest.getCryptoKeyId());
    Assert.assertEquals(cryptoKey, actualRequest.getCryptoKey());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  @SuppressWarnings("all")
  public void createCryptoKeyExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(Status.INVALID_ARGUMENT);
    mockKeyManagementService.addException(exception);

    try {
      KeyRingName parent = KeyRingName.of("[PROJECT]", "[LOCATION]", "[KEY_RING]");
      String cryptoKeyId = "my-app-key";
      CryptoKey.CryptoKeyPurpose purpose = CryptoKey.CryptoKeyPurpose.ENCRYPT_DECRYPT;
      long seconds = 2147483647L;
      Timestamp nextRotationTime = Timestamp.newBuilder().setSeconds(seconds).build();
      long seconds2 = 604800L;
      Duration rotationPeriod = Duration.newBuilder().setSeconds(seconds2).build();
      CryptoKey cryptoKey =
          CryptoKey.newBuilder()
              .setPurpose(purpose)
              .setNextRotationTime(nextRotationTime)
              .setRotationPeriod(rotationPeriod)
              .build();

      client.createCryptoKey(parent, cryptoKeyId, cryptoKey);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception
    }
  }

  @Test
  @SuppressWarnings("all")
  public void createCryptoKeyVersionTest() {
    CryptoKeyVersionName name =
        CryptoKeyVersionName.of(
            "[PROJECT]", "[LOCATION]", "[KEY_RING]", "[CRYPTO_KEY]", "[CRYPTO_KEY_VERSION]");
    CryptoKeyVersion expectedResponse =
        CryptoKeyVersion.newBuilder().setName(name.toString()).build();
    mockKeyManagementService.addResponse(expectedResponse);

    CryptoKeyName parent =
        CryptoKeyName.of("[PROJECT]", "[LOCATION]", "[KEY_RING]", "[CRYPTO_KEY]");
    CryptoKeyVersion cryptoKeyVersion = CryptoKeyVersion.newBuilder().build();

    CryptoKeyVersion actualResponse = client.createCryptoKeyVersion(parent, cryptoKeyVersion);
    Assert.assertEquals(expectedResponse, actualResponse);

    List<GeneratedMessageV3> actualRequests = mockKeyManagementService.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    CreateCryptoKeyVersionRequest actualRequest =
        (CreateCryptoKeyVersionRequest) actualRequests.get(0);

    Assert.assertEquals(parent, CryptoKeyName.parse(actualRequest.getParent()));
    Assert.assertEquals(cryptoKeyVersion, actualRequest.getCryptoKeyVersion());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  @SuppressWarnings("all")
  public void createCryptoKeyVersionExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(Status.INVALID_ARGUMENT);
    mockKeyManagementService.addException(exception);

    try {
      CryptoKeyName parent =
          CryptoKeyName.of("[PROJECT]", "[LOCATION]", "[KEY_RING]", "[CRYPTO_KEY]");
      CryptoKeyVersion cryptoKeyVersion = CryptoKeyVersion.newBuilder().build();

      client.createCryptoKeyVersion(parent, cryptoKeyVersion);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception
    }
  }

  @Test
  @SuppressWarnings("all")
  public void updateCryptoKeyTest() {
    CryptoKeyName name = CryptoKeyName.of("[PROJECT]", "[LOCATION]", "[KEY_RING]", "[CRYPTO_KEY]");
    CryptoKey expectedResponse = CryptoKey.newBuilder().setName(name.toString()).build();
    mockKeyManagementService.addResponse(expectedResponse);

    CryptoKey cryptoKey = CryptoKey.newBuilder().build();
    FieldMask updateMask = FieldMask.newBuilder().build();

    CryptoKey actualResponse = client.updateCryptoKey(cryptoKey, updateMask);
    Assert.assertEquals(expectedResponse, actualResponse);

    List<GeneratedMessageV3> actualRequests = mockKeyManagementService.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    UpdateCryptoKeyRequest actualRequest = (UpdateCryptoKeyRequest) actualRequests.get(0);

    Assert.assertEquals(cryptoKey, actualRequest.getCryptoKey());
    Assert.assertEquals(updateMask, actualRequest.getUpdateMask());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  @SuppressWarnings("all")
  public void updateCryptoKeyExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(Status.INVALID_ARGUMENT);
    mockKeyManagementService.addException(exception);

    try {
      CryptoKey cryptoKey = CryptoKey.newBuilder().build();
      FieldMask updateMask = FieldMask.newBuilder().build();

      client.updateCryptoKey(cryptoKey, updateMask);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception
    }
  }

  @Test
  @SuppressWarnings("all")
  public void updateCryptoKeyVersionTest() {
    CryptoKeyVersionName name =
        CryptoKeyVersionName.of(
            "[PROJECT]", "[LOCATION]", "[KEY_RING]", "[CRYPTO_KEY]", "[CRYPTO_KEY_VERSION]");
    CryptoKeyVersion expectedResponse =
        CryptoKeyVersion.newBuilder().setName(name.toString()).build();
    mockKeyManagementService.addResponse(expectedResponse);

    CryptoKeyVersion cryptoKeyVersion = CryptoKeyVersion.newBuilder().build();
    FieldMask updateMask = FieldMask.newBuilder().build();

    CryptoKeyVersion actualResponse = client.updateCryptoKeyVersion(cryptoKeyVersion, updateMask);
    Assert.assertEquals(expectedResponse, actualResponse);

    List<GeneratedMessageV3> actualRequests = mockKeyManagementService.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    UpdateCryptoKeyVersionRequest actualRequest =
        (UpdateCryptoKeyVersionRequest) actualRequests.get(0);

    Assert.assertEquals(cryptoKeyVersion, actualRequest.getCryptoKeyVersion());
    Assert.assertEquals(updateMask, actualRequest.getUpdateMask());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  @SuppressWarnings("all")
  public void updateCryptoKeyVersionExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(Status.INVALID_ARGUMENT);
    mockKeyManagementService.addException(exception);

    try {
      CryptoKeyVersion cryptoKeyVersion = CryptoKeyVersion.newBuilder().build();
      FieldMask updateMask = FieldMask.newBuilder().build();

      client.updateCryptoKeyVersion(cryptoKeyVersion, updateMask);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception
    }
  }

  @Test
  @SuppressWarnings("all")
  public void encryptTest() {
    String name2 = "name2-1052831874";
    ByteString ciphertext = ByteString.copyFromUtf8("-72");
    EncryptResponse expectedResponse =
        EncryptResponse.newBuilder().setName(name2).setCiphertext(ciphertext).build();
    mockKeyManagementService.addResponse(expectedResponse);

    CryptoKeyPathName name =
        CryptoKeyPathName.of("[PROJECT]", "[LOCATION]", "[KEY_RING]", "[CRYPTO_KEY_PATH]");
    ByteString plaintext = ByteString.copyFromUtf8("-9");

    EncryptResponse actualResponse = client.encrypt(name, plaintext);
    Assert.assertEquals(expectedResponse, actualResponse);

    List<GeneratedMessageV3> actualRequests = mockKeyManagementService.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    EncryptRequest actualRequest = (EncryptRequest) actualRequests.get(0);

    Assert.assertEquals(name, CryptoKeyPathName.parse(actualRequest.getName()));
    Assert.assertEquals(plaintext, actualRequest.getPlaintext());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  @SuppressWarnings("all")
  public void encryptExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(Status.INVALID_ARGUMENT);
    mockKeyManagementService.addException(exception);

    try {
      CryptoKeyPathName name =
          CryptoKeyPathName.of("[PROJECT]", "[LOCATION]", "[KEY_RING]", "[CRYPTO_KEY_PATH]");
      ByteString plaintext = ByteString.copyFromUtf8("-9");

      client.encrypt(name, plaintext);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception
    }
  }

  @Test
  @SuppressWarnings("all")
  public void decryptTest() {
    ByteString plaintext = ByteString.copyFromUtf8("-9");
    DecryptResponse expectedResponse = DecryptResponse.newBuilder().setPlaintext(plaintext).build();
    mockKeyManagementService.addResponse(expectedResponse);

    CryptoKeyName name = CryptoKeyName.of("[PROJECT]", "[LOCATION]", "[KEY_RING]", "[CRYPTO_KEY]");
    ByteString ciphertext = ByteString.copyFromUtf8("-72");

    DecryptResponse actualResponse = client.decrypt(name, ciphertext);
    Assert.assertEquals(expectedResponse, actualResponse);

    List<GeneratedMessageV3> actualRequests = mockKeyManagementService.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    DecryptRequest actualRequest = (DecryptRequest) actualRequests.get(0);

    Assert.assertEquals(name, CryptoKeyName.parse(actualRequest.getName()));
    Assert.assertEquals(ciphertext, actualRequest.getCiphertext());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  @SuppressWarnings("all")
  public void decryptExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(Status.INVALID_ARGUMENT);
    mockKeyManagementService.addException(exception);

    try {
      CryptoKeyName name =
          CryptoKeyName.of("[PROJECT]", "[LOCATION]", "[KEY_RING]", "[CRYPTO_KEY]");
      ByteString ciphertext = ByteString.copyFromUtf8("-72");

      client.decrypt(name, ciphertext);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception
    }
  }

  @Test
  @SuppressWarnings("all")
  public void updateCryptoKeyPrimaryVersionTest() {
    CryptoKeyName name2 = CryptoKeyName.of("[PROJECT]", "[LOCATION]", "[KEY_RING]", "[CRYPTO_KEY]");
    CryptoKey expectedResponse = CryptoKey.newBuilder().setName(name2.toString()).build();
    mockKeyManagementService.addResponse(expectedResponse);

    CryptoKeyName name = CryptoKeyName.of("[PROJECT]", "[LOCATION]", "[KEY_RING]", "[CRYPTO_KEY]");
    String cryptoKeyVersionId = "cryptoKeyVersionId729489152";

    CryptoKey actualResponse = client.updateCryptoKeyPrimaryVersion(name, cryptoKeyVersionId);
    Assert.assertEquals(expectedResponse, actualResponse);

    List<GeneratedMessageV3> actualRequests = mockKeyManagementService.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    UpdateCryptoKeyPrimaryVersionRequest actualRequest =
        (UpdateCryptoKeyPrimaryVersionRequest) actualRequests.get(0);

    Assert.assertEquals(name, CryptoKeyName.parse(actualRequest.getName()));
    Assert.assertEquals(cryptoKeyVersionId, actualRequest.getCryptoKeyVersionId());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  @SuppressWarnings("all")
  public void updateCryptoKeyPrimaryVersionExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(Status.INVALID_ARGUMENT);
    mockKeyManagementService.addException(exception);

    try {
      CryptoKeyName name =
          CryptoKeyName.of("[PROJECT]", "[LOCATION]", "[KEY_RING]", "[CRYPTO_KEY]");
      String cryptoKeyVersionId = "cryptoKeyVersionId729489152";

      client.updateCryptoKeyPrimaryVersion(name, cryptoKeyVersionId);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception
    }
  }

  @Test
  @SuppressWarnings("all")
  public void destroyCryptoKeyVersionTest() {
    CryptoKeyVersionName name2 =
        CryptoKeyVersionName.of(
            "[PROJECT]", "[LOCATION]", "[KEY_RING]", "[CRYPTO_KEY]", "[CRYPTO_KEY_VERSION]");
    CryptoKeyVersion expectedResponse =
        CryptoKeyVersion.newBuilder().setName(name2.toString()).build();
    mockKeyManagementService.addResponse(expectedResponse);

    CryptoKeyVersionName name =
        CryptoKeyVersionName.of(
            "[PROJECT]", "[LOCATION]", "[KEY_RING]", "[CRYPTO_KEY]", "[CRYPTO_KEY_VERSION]");

    CryptoKeyVersion actualResponse = client.destroyCryptoKeyVersion(name);
    Assert.assertEquals(expectedResponse, actualResponse);

    List<GeneratedMessageV3> actualRequests = mockKeyManagementService.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    DestroyCryptoKeyVersionRequest actualRequest =
        (DestroyCryptoKeyVersionRequest) actualRequests.get(0);

    Assert.assertEquals(name, CryptoKeyVersionName.parse(actualRequest.getName()));
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  @SuppressWarnings("all")
  public void destroyCryptoKeyVersionExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(Status.INVALID_ARGUMENT);
    mockKeyManagementService.addException(exception);

    try {
      CryptoKeyVersionName name =
          CryptoKeyVersionName.of(
              "[PROJECT]", "[LOCATION]", "[KEY_RING]", "[CRYPTO_KEY]", "[CRYPTO_KEY_VERSION]");

      client.destroyCryptoKeyVersion(name);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception
    }
  }

  @Test
  @SuppressWarnings("all")
  public void restoreCryptoKeyVersionTest() {
    CryptoKeyVersionName name2 =
        CryptoKeyVersionName.of(
            "[PROJECT]", "[LOCATION]", "[KEY_RING]", "[CRYPTO_KEY]", "[CRYPTO_KEY_VERSION]");
    CryptoKeyVersion expectedResponse =
        CryptoKeyVersion.newBuilder().setName(name2.toString()).build();
    mockKeyManagementService.addResponse(expectedResponse);

    CryptoKeyVersionName name =
        CryptoKeyVersionName.of(
            "[PROJECT]", "[LOCATION]", "[KEY_RING]", "[CRYPTO_KEY]", "[CRYPTO_KEY_VERSION]");

    CryptoKeyVersion actualResponse = client.restoreCryptoKeyVersion(name);
    Assert.assertEquals(expectedResponse, actualResponse);

    List<GeneratedMessageV3> actualRequests = mockKeyManagementService.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    RestoreCryptoKeyVersionRequest actualRequest =
        (RestoreCryptoKeyVersionRequest) actualRequests.get(0);

    Assert.assertEquals(name, CryptoKeyVersionName.parse(actualRequest.getName()));
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  @SuppressWarnings("all")
  public void restoreCryptoKeyVersionExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(Status.INVALID_ARGUMENT);
    mockKeyManagementService.addException(exception);

    try {
      CryptoKeyVersionName name =
          CryptoKeyVersionName.of(
              "[PROJECT]", "[LOCATION]", "[KEY_RING]", "[CRYPTO_KEY]", "[CRYPTO_KEY_VERSION]");

      client.restoreCryptoKeyVersion(name);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception
    }
  }

  @Test
  @SuppressWarnings("all")
  public void setIamPolicyTest() {
    int version = 351608024;
    ByteString etag = ByteString.copyFromUtf8("21");
    Policy expectedResponse = Policy.newBuilder().setVersion(version).setEtag(etag).build();
    mockIAMPolicy.addResponse(expectedResponse);

    KeyName resource = KeyRingName.of("[PROJECT]", "[LOCATION]", "[KEY_RING]");
    Policy policy = Policy.newBuilder().build();

    Policy actualResponse = client.setIamPolicy(resource, policy);
    Assert.assertEquals(expectedResponse, actualResponse);

    List<GeneratedMessageV3> actualRequests = mockIAMPolicy.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    SetIamPolicyRequest actualRequest = (SetIamPolicyRequest) actualRequests.get(0);

    Assert.assertEquals(Objects.toString(resource), Objects.toString(actualRequest.getResource()));
    Assert.assertEquals(policy, actualRequest.getPolicy());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  @SuppressWarnings("all")
  public void setIamPolicyExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(Status.INVALID_ARGUMENT);
    mockIAMPolicy.addException(exception);

    try {
      KeyName resource = KeyRingName.of("[PROJECT]", "[LOCATION]", "[KEY_RING]");
      Policy policy = Policy.newBuilder().build();

      client.setIamPolicy(resource, policy);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception
    }
  }

  @Test
  @SuppressWarnings("all")
  public void getIamPolicyTest() {
    int version = 351608024;
    ByteString etag = ByteString.copyFromUtf8("21");
    Policy expectedResponse = Policy.newBuilder().setVersion(version).setEtag(etag).build();
    mockIAMPolicy.addResponse(expectedResponse);

    KeyName resource = KeyRingName.of("[PROJECT]", "[LOCATION]", "[KEY_RING]");

    Policy actualResponse = client.getIamPolicy(resource);
    Assert.assertEquals(expectedResponse, actualResponse);

    List<GeneratedMessageV3> actualRequests = mockIAMPolicy.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    GetIamPolicyRequest actualRequest = (GetIamPolicyRequest) actualRequests.get(0);

    Assert.assertEquals(Objects.toString(resource), Objects.toString(actualRequest.getResource()));
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  @SuppressWarnings("all")
  public void getIamPolicyExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(Status.INVALID_ARGUMENT);
    mockIAMPolicy.addException(exception);

    try {
      KeyName resource = KeyRingName.of("[PROJECT]", "[LOCATION]", "[KEY_RING]");

      client.getIamPolicy(resource);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception
    }
  }

  @Test
  @SuppressWarnings("all")
  public void testIamPermissionsTest() {
    TestIamPermissionsResponse expectedResponse = TestIamPermissionsResponse.newBuilder().build();
    mockIAMPolicy.addResponse(expectedResponse);

    KeyName resource = KeyRingName.of("[PROJECT]", "[LOCATION]", "[KEY_RING]");
    List<String> permissions = new ArrayList<>();

    TestIamPermissionsResponse actualResponse = client.testIamPermissions(resource, permissions);
    Assert.assertEquals(expectedResponse, actualResponse);

    List<GeneratedMessageV3> actualRequests = mockIAMPolicy.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    TestIamPermissionsRequest actualRequest = (TestIamPermissionsRequest) actualRequests.get(0);

    Assert.assertEquals(Objects.toString(resource), Objects.toString(actualRequest.getResource()));
    Assert.assertEquals(permissions, actualRequest.getPermissionsList());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  @SuppressWarnings("all")
  public void testIamPermissionsExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(Status.INVALID_ARGUMENT);
    mockIAMPolicy.addException(exception);

    try {
      KeyName resource = KeyRingName.of("[PROJECT]", "[LOCATION]", "[KEY_RING]");
      List<String> permissions = new ArrayList<>();

      client.testIamPermissions(resource, permissions);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception
    }
  }
}
