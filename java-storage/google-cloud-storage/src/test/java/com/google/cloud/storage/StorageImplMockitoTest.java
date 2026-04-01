/*
 * Copyright 2020 Google LLC
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *       http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package com.google.cloud.storage;

import static org.junit.Assert.assertArrayEquals;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertSame;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.fail;
import static org.mockito.Mockito.doReturn;
import static org.mockito.Mockito.doThrow;
import static org.mockito.Mockito.mock;

import com.google.api.core.ApiClock;
import com.google.api.gax.paging.Page;
import com.google.api.services.storage.model.StorageObject;
import com.google.cloud.ServiceOptions;
import com.google.cloud.Tuple;
import com.google.cloud.storage.spi.StorageRpcFactory;
import com.google.cloud.storage.spi.v1.StorageRpc;
import com.google.common.collect.ImmutableList;
import com.google.common.collect.ImmutableMap;
import com.google.common.collect.Iterables;
import com.google.common.io.BaseEncoding;
import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.math.BigInteger;
import java.nio.file.Files;
import java.nio.file.Path;
import java.security.Key;
import java.security.KeyFactory;
import java.security.NoSuchAlgorithmException;
import java.security.PrivateKey;
import java.security.PublicKey;
import java.security.spec.EncodedKeySpec;
import java.security.spec.InvalidKeySpecException;
import java.security.spec.PKCS8EncodedKeySpec;
import java.security.spec.X509EncodedKeySpec;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import javax.crypto.spec.SecretKeySpec;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.mockito.ArgumentCaptor;
import org.mockito.Mockito;
import org.mockito.stubbing.Answer;

public class StorageImplMockitoTest {

  private static final String BUCKET_NAME1 = "b1";
  private static final String BUCKET_NAME2 = "b2";
  private static final String BUCKET_NAME3 = "b3";
  private static final String BLOB_NAME1 = "n1";
  private static final String BLOB_NAME2 = "n2";
  private static final String BLOB_NAME3 = "n3";
  private static final byte[] BLOB_CONTENT = {0xD, 0xE, 0xA, 0xD};
  private static final byte[] BLOB_SUB_CONTENT = {0xE, 0xA};
  private static final String CONTENT_MD5 = "O1R4G1HJSDUISJjoIYmVhQ==";
  private static final String CONTENT_CRC32C = "9N3EPQ==";
  private static final String SUB_CONTENT_MD5 = "5e7c7CdasUiOn3BO560jPg==";
  private static final String SUB_CONTENT_CRC32C = "bljNYA==";
  private static final int DEFAULT_CHUNK_SIZE = 2 * 1024 * 1024;
  private static final String BASE64_KEY = "JVzfVl8NLD9FjedFuStegjRfES5ll5zc59CIXw572OA=";
  private static final Key KEY =
      new SecretKeySpec(BaseEncoding.base64().decode(BASE64_KEY), "AES256");
  private static final String KMS_KEY_NAME =
      "projects/gcloud-devel/locations/us/keyRings/gcs_kms_key_ring_us/cryptoKeys/key";
  private static final Long RETENTION_PERIOD = 10L;
  private static final int DEFAULT_BUFFER_SIZE = 15 * 1024 * 1024;
  private static final int MIN_BUFFER_SIZE = 256 * 1024;
  protected static final long PAGE_SIZE = 42L;
  // BucketInfo objects
  private static final BucketInfo BUCKET_INFO1 =
      BucketInfo.newBuilder(BUCKET_NAME1).setMetageneration(PAGE_SIZE).build();
  private static final BucketInfo BUCKET_INFO2 = BucketInfo.newBuilder(BUCKET_NAME2).build();
  private static final BucketInfo BUCKET_INFO3 =
      BucketInfo.newBuilder(BUCKET_NAME3)
          .setRetentionPeriod(RETENTION_PERIOD)
          .setRetentionPolicyIsLocked(true)
          .setMetageneration(PAGE_SIZE)
          .build();

  // BlobInfo objects
  private static final BlobInfo BLOB_INFO1 =
      BlobInfo.newBuilder(BUCKET_NAME1, BLOB_NAME1, 24L)
          .setMetageneration(PAGE_SIZE)
          .setContentType("application/json")
          .build();
  private static final BlobInfo BLOB_INFO2 = BlobInfo.newBuilder(BUCKET_NAME1, BLOB_NAME2).build();
  private static final BlobInfo BLOB_INFO3 = BlobInfo.newBuilder(BUCKET_NAME1, BLOB_NAME3).build();

  private static final BlobInfo BLOB_INFO_WITH_HASHES =
      BLOB_INFO1.toBuilder().setCrc32c(CONTENT_CRC32C).build();
  private static final BlobInfo BLOB_INFO_WITHOUT_HASHES =
      BLOB_INFO1.toBuilder().setCrc32c(null).build();

  // Empty StorageRpc options
  private static final Map<StorageRpc.Option, ?> EMPTY_RPC_OPTIONS = ImmutableMap.of();
  private static final Map<StorageRpc.Option, ?> BLOB_INFO1_RPC_OPTIONS_WITH_GENERATION =
      ImmutableMap.of(StorageRpc.Option.IF_GENERATION_MATCH, 24L);

  // Bucket target options
  private static final Storage.BucketTargetOption BUCKET_TARGET_METAGENERATION =
      Storage.BucketTargetOption.metagenerationMatch();
  private static final Storage.BucketTargetOption BUCKET_TARGET_PREDEFINED_ACL =
      Storage.BucketTargetOption.predefinedAcl(Storage.PredefinedAcl.PRIVATE);
  private static final Map<StorageRpc.Option, ?> BUCKET_TARGET_OPTIONS =
      ImmutableMap.of(
          StorageRpc.Option.IF_METAGENERATION_MATCH, BUCKET_INFO1.getMetageneration(),
          StorageRpc.Option.PREDEFINED_ACL, Storage.PredefinedAcl.PRIVATE.getEntry());

  private static final Storage.BlobTargetOption BLOB_TARGET_METAGENERATION =
      Storage.BlobTargetOption.metagenerationMatch();
  private static final Storage.BlobTargetOption BLOB_TARGET_DISABLE_GZIP_CONTENT =
      Storage.BlobTargetOption.disableGzipContent();
  private static final Storage.BlobTargetOption BLOB_TARGET_NOT_EXIST =
      Storage.BlobTargetOption.doesNotExist();
  private static final Storage.BlobTargetOption BLOB_TARGET_PREDEFINED_ACL =
      Storage.BlobTargetOption.predefinedAcl(Storage.PredefinedAcl.PRIVATE);
  private static final Map<StorageRpc.Option, ?> BLOB_TARGET_OPTIONS_CREATE =
      ImmutableMap.of(
          StorageRpc.Option.IF_METAGENERATION_MATCH, BLOB_INFO1.getMetageneration(),
          StorageRpc.Option.IF_GENERATION_MATCH, 0L,
          StorageRpc.Option.PREDEFINED_ACL, Storage.PredefinedAcl.PRIVATE.getEntry());
  private static final Map<StorageRpc.Option, ?> BLOB_TARGET_OPTIONS_CREATE_DISABLE_GZIP_CONTENT =
      ImmutableMap.of(StorageRpc.Option.IF_DISABLE_GZIP_CONTENT, true);

  // Blob write options (create, writer)
  private static final Storage.BlobWriteOption BLOB_WRITE_METAGENERATION =
      Storage.BlobWriteOption.metagenerationMatch();
  private static final Storage.BlobWriteOption BLOB_WRITE_NOT_EXIST =
      Storage.BlobWriteOption.doesNotExist();
  private static final Storage.BlobWriteOption BLOB_WRITE_PREDEFINED_ACL =
      Storage.BlobWriteOption.predefinedAcl(Storage.PredefinedAcl.PRIVATE);
  private static final Storage.BlobWriteOption BLOB_WRITE_MD5_HASH =
      Storage.BlobWriteOption.md5Match();
  private static final Storage.BlobWriteOption BLOB_WRITE_CRC2C =
      Storage.BlobWriteOption.crc32cMatch();

  // Bucket get/source options
  private static final Storage.BucketGetOption BUCKET_GET_METAGENERATION =
      Storage.BucketGetOption.metagenerationMatch(BUCKET_INFO1.getMetageneration());
  private static final Storage.BucketGetOption BUCKET_GET_FIELDS =
      Storage.BucketGetOption.fields(Storage.BucketField.LOCATION, Storage.BucketField.ACL);
  private static final Storage.BucketGetOption BUCKET_GET_EMPTY_FIELDS =
      Storage.BucketGetOption.fields();
  private static final Map<StorageRpc.Option, ?> BUCKET_GET_OPTIONS =
      ImmutableMap.of(StorageRpc.Option.IF_METAGENERATION_MATCH, BUCKET_INFO1.getMetageneration());

  // Blob get/source options
  private static final Storage.BlobGetOption BLOB_GET_METAGENERATION =
      Storage.BlobGetOption.metagenerationMatch(BLOB_INFO1.getMetageneration());
  private static final Storage.BlobGetOption BLOB_GET_GENERATION =
      Storage.BlobGetOption.generationMatch(BLOB_INFO1.getGeneration());
  private static final Storage.BlobGetOption BLOB_GET_GENERATION_FROM_BLOB_ID =
      Storage.BlobGetOption.generationMatch();
  private static final Storage.BlobGetOption BLOB_GET_FIELDS =
      Storage.BlobGetOption.fields(Storage.BlobField.CONTENT_TYPE, Storage.BlobField.CRC32C);
  private static final Storage.BlobGetOption BLOB_GET_EMPTY_FIELDS = Storage.BlobGetOption.fields();
  private static final Map<StorageRpc.Option, ?> BLOB_GET_OPTIONS =
      ImmutableMap.of(
          StorageRpc.Option.IF_METAGENERATION_MATCH, BLOB_INFO1.getMetageneration(),
          StorageRpc.Option.IF_GENERATION_MATCH, BLOB_INFO1.getGeneration());
  private static final Storage.BlobSourceOption BLOB_SOURCE_METAGENERATION =
      Storage.BlobSourceOption.metagenerationMatch(BLOB_INFO1.getMetageneration());
  private static final Storage.BlobSourceOption BLOB_SOURCE_GENERATION =
      Storage.BlobSourceOption.generationMatch(BLOB_INFO1.getGeneration());
  private static final Storage.BlobSourceOption BLOB_SOURCE_GENERATION_FROM_BLOB_ID =
      Storage.BlobSourceOption.generationMatch();
  private static final Map<StorageRpc.Option, ?> BLOB_SOURCE_OPTIONS =
      ImmutableMap.of(
          StorageRpc.Option.IF_METAGENERATION_MATCH, BLOB_INFO1.getMetageneration(),
          StorageRpc.Option.IF_GENERATION_MATCH, BLOB_INFO1.getGeneration());

  // Bucket list options
  private static final Storage.BucketListOption BUCKET_LIST_PAGE_SIZE =
      Storage.BucketListOption.pageSize(PAGE_SIZE);
  private static final Storage.BucketListOption BUCKET_LIST_PREFIX =
      Storage.BucketListOption.prefix("prefix");
  private static final Storage.BucketListOption BUCKET_LIST_FIELDS =
      Storage.BucketListOption.fields(Storage.BucketField.LOCATION, Storage.BucketField.ACL);
  private static final Storage.BucketListOption BUCKET_LIST_EMPTY_FIELDS =
      Storage.BucketListOption.fields();
  private static final Map<StorageRpc.Option, ?> BUCKET_LIST_OPTIONS =
      ImmutableMap.of(StorageRpc.Option.MAX_RESULTS, PAGE_SIZE, StorageRpc.Option.PREFIX, "prefix");
  private static final Map<StorageRpc.Option, ?> BUCKET_LIST_PARTIAL_SUCCESS_OPTION =
      ImmutableMap.of(StorageRpc.Option.RETURN_PARTIAL_SUCCESS, true);

  // Blob list options
  private static final Storage.BlobListOption BLOB_LIST_PAGE_SIZE =
      Storage.BlobListOption.pageSize(PAGE_SIZE);
  private static final Storage.BlobListOption BLOB_LIST_PREFIX =
      Storage.BlobListOption.prefix("prefix");
  private static final Storage.BlobListOption BLOB_LIST_FIELDS =
      Storage.BlobListOption.fields(Storage.BlobField.CONTENT_TYPE, Storage.BlobField.MD5HASH);
  private static final Storage.BlobListOption BLOB_LIST_VERSIONS =
      Storage.BlobListOption.versions(false);
  private static final Storage.BlobListOption BLOB_LIST_EMPTY_FIELDS =
      Storage.BlobListOption.fields();
  private static final Map<StorageRpc.Option, ?> BLOB_LIST_OPTIONS =
      ImmutableMap.of(
          StorageRpc.Option.MAX_RESULTS,
          PAGE_SIZE,
          StorageRpc.Option.PREFIX,
          "prefix",
          StorageRpc.Option.VERSIONS,
          false);

  // Customer supplied encryption key options
  private static final Map<StorageRpc.Option, ?> ENCRYPTION_KEY_OPTIONS =
      ImmutableMap.of(StorageRpc.Option.CUSTOMER_SUPPLIED_KEY, BASE64_KEY);

  // Customer managed encryption key options
  private static final Map<StorageRpc.Option, ?> KMS_KEY_NAME_OPTIONS =
      ImmutableMap.of(StorageRpc.Option.KMS_KEY_NAME, KMS_KEY_NAME);

  private static final String PRIVATE_KEY_STRING =
      "MIICdwIBADANBgkqhkiG9w0BAQEFAASCAmEwggJdAgEAAoG"
          + "BAL2xolH1zrISQ8+GzOV29BNjjzq4/HIP8Psd1+cZb81vDklSF+95wB250MSE0BDc81pvIMwj5OmIfLg1NY6uB"
          + "1xavOPpVdx1z664AGc/BEJ1zInXGXaQ6s+SxGenVq40Yws57gikQGMZjttpf1Qbz4DjkxsbRoeaRHn06n9pH1e"
          + "jAgMBAAECgYEAkWcm0AJF5LMhbWKbjkxm/LG06UNApkHX6vTOOOODkonM/qDBnhvKCj8Tan+PaU2j7679Cd19q"
          + "xCm4SBQJET7eBhqLD9L2j9y0h2YUQnLbISaqUS1/EXcr2C1Lf9VCEn1y/GYuDYqs85rGoQ4ZYfM9ClROSq86fH"
          + "+cbIIssqJqukCQQD18LjfJz/ichFeli5/l1jaFid2XoCH3T6TVuuysszVx68fh60gSIxEF/0X2xB+wuPxTP4IQ"
          + "+t8tD/ktd232oWXAkEAxXPych2QBHePk9/lek4tOkKBgfnDzex7S/pI0G1vpB3VmzBbCsokn9lpOv7JV8071GD"
          + "lW/7R6jlLfpQy3hN31QJAE10osSk99m5Uv8XDU3hvHnywDrnSFOBulNs7I47AYfSe7TSZhPkxUgsxejddTR27J"
          + "LyTI8N1PxRSE4feNSOXcQJAMMKJRJT4U6IS2rmXubREhvaVdLtxFxEnAYQ1JwNfZm/XqBMw6GEy2iaeTetNXVl"
          + "ZRQEIoscyn1y2v/No/F5iYQJBAKBOGASoQcBjGTOg/H/SfcE8QVNsKEpthRrs6CkpT80aZ/AV+ksfoIf2zw2M3"
          + "mAHfrO+TBLdz4sicuFQvlN9SEc=";

  private static final String PUBLIC_KEY_STRING =
      "MIGfMA0GCSqGSIb3DQEBAQUAA4GNADCBiQKBgQC9saJR9c6y"
          + "EkPPhszldvQTY486uPxyD/D7HdfnGW/Nbw5JUhfvecAdudDEhNAQ3PNabyDMI+TpiHy4NTWOrgdcWrzj6VXcdc"
          + "+uuABnPwRCdcyJ1xl2kOrPksRnp1auNGMLOe4IpEBjGY7baX9UG8+A45MbG0aHmkR59Op/aR9XowIDAQAB";

  private static final ApiClock TIME_SOURCE =
      new ApiClock() {
        @Override
        public long nanoTime() {
          return 42_000_000_000L;
        }

        @Override
        public long millisTime() {
          return 42_000L;
        }
      };

  // Notification
  private static final String ETAG = "0xFF00";
  private static final String GENERATED_ID = "B/N:1";
  private static final String SELF_LINK = "http://storage/b/n";
  private static final Notification.EventType[] EVENT_TYPES = {
    Notification.EventType.OBJECT_FINALIZE, Notification.EventType.OBJECT_METADATA_UPDATE
  };
  private static final String OBJECT_NAME_PREFIX = "index.html";
  private static final Notification.PayloadFormat PAYLOAD_FORMAT =
      Notification.PayloadFormat.JSON_API_V1.JSON_API_V1;
  private static final String TOPIC = "projects/myProject/topics/topic1";
  private static final Map<String, String> CUSTOM_ATTRIBUTES = ImmutableMap.of("label1", "value1");
  private static final NotificationInfo NOTIFICATION_INFO_01 =
      NotificationInfo.newBuilder(TOPIC)
          .setEtag(ETAG)
          .setCustomAttributes(CUSTOM_ATTRIBUTES)
          .setSelfLink(SELF_LINK)
          .setEventTypes(EVENT_TYPES)
          .setObjectNamePrefix(OBJECT_NAME_PREFIX)
          .setPayloadFormat(PAYLOAD_FORMAT)
          .build();
  private static final NotificationInfo NOTIFICATION_INFO_02 =
      NotificationInfo.newBuilder(TOPIC)
          .setEtag(ETAG)
          .setCustomAttributes(CUSTOM_ATTRIBUTES)
          .setSelfLink(SELF_LINK)
          .setEventTypes(EVENT_TYPES)
          .setObjectNamePrefix(OBJECT_NAME_PREFIX)
          .setPayloadFormat(PAYLOAD_FORMAT)
          .build();

  private static PrivateKey privateKey;
  private static PublicKey publicKey;

  private StorageOptions options;
  private StorageRpcFactory rpcFactoryMock;
  private StorageRpc storageRpcMock;
  private Storage storage;
  private com.google.api.services.storage.Storage apiary;

  private Blob expectedBlob1, expectedBlob2, expectedBlob3, expectedUpdated;
  private Bucket expectedBucket1, expectedBucket2, expectedBucket3;

  @BeforeClass
  public static void beforeClass() throws NoSuchAlgorithmException, InvalidKeySpecException {
    KeyFactory keyFactory = KeyFactory.getInstance("RSA");
    EncodedKeySpec privateKeySpec =
        new PKCS8EncodedKeySpec(BaseEncoding.base64().decode(PRIVATE_KEY_STRING));
    privateKey = keyFactory.generatePrivate(privateKeySpec);
    EncodedKeySpec publicKeySpec =
        new X509EncodedKeySpec(BaseEncoding.base64().decode(PUBLIC_KEY_STRING));
    publicKey = keyFactory.generatePublic(publicKeySpec);
  }

  private static final RuntimeException STORAGE_FAILURE =
      new RuntimeException("Something went wrong");

  private static final RuntimeException UNEXPECTED_CALL_EXCEPTION =
      new RuntimeException("Unexpected call");
  private static final Answer<?> UNEXPECTED_CALL_ANSWER =
      invocation -> {
        throw new IllegalArgumentException(
            "Unexpected call of "
                + invocation.getMethod()
                + " with "
                + Arrays.toString(invocation.getArguments()));
      };

  @Before
  public void setUp() {
    rpcFactoryMock = mock(StorageRpcFactory.class, UNEXPECTED_CALL_ANSWER);
    storageRpcMock = mock(StorageRpc.class, UNEXPECTED_CALL_ANSWER);
    apiary = mock(com.google.api.services.storage.Storage.class, UNEXPECTED_CALL_ANSWER);
    doReturn(storageRpcMock).when(rpcFactoryMock).create(Mockito.any(StorageOptions.class));
    doReturn(apiary).when(storageRpcMock).getStorage();
    options =
        StorageOptions.http()
            .setProjectId("projectId")
            .setClock(TIME_SOURCE)
            .setServiceRpcFactory(rpcFactoryMock)
            .setRetrySettings(ServiceOptions.getNoRetrySettings())
            .build();
  }

  private void initializeService() {
    storage = options.getService();
    initializeServiceDependentObjects();
  }

  private void initializeServiceDependentObjects() {
    expectedBlob1 = new Blob(storage, new BlobInfo.BuilderImpl(BLOB_INFO1));
    expectedBlob2 = new Blob(storage, new BlobInfo.BuilderImpl(BLOB_INFO2));
    expectedBlob3 = new Blob(storage, new BlobInfo.BuilderImpl(BLOB_INFO3));
    expectedBucket1 = new Bucket(storage, new BucketInfo.BuilderImpl(BUCKET_INFO1));
    expectedBucket2 = new Bucket(storage, new BucketInfo.BuilderImpl(BUCKET_INFO2));
    expectedBucket3 = new Bucket(storage, new BucketInfo.BuilderImpl(BUCKET_INFO3));
    expectedUpdated = null;
  }

  @Test
  public void testGetOptions() {
    initializeService();
    assertSame(options, storage.getOptions());
  }

  @Test
  public void testCreateBucket() {
    doReturn(Conversions.json().bucketInfo().encode(BUCKET_INFO1))
        .doThrow(UNEXPECTED_CALL_EXCEPTION)
        .when(storageRpcMock)
        .create(Conversions.json().bucketInfo().encode(BUCKET_INFO1), EMPTY_RPC_OPTIONS);
    initializeService();
    Bucket bucket = storage.create(BUCKET_INFO1);
    assertEquals(expectedBucket1, bucket);
  }

  @Test
  public void testCreateBucketWithOptions() {
    doReturn(Conversions.json().bucketInfo().encode(BUCKET_INFO1))
        .doThrow(UNEXPECTED_CALL_EXCEPTION)
        .when(storageRpcMock)
        .create(Conversions.json().bucketInfo().encode(BUCKET_INFO1), BUCKET_TARGET_OPTIONS);
    initializeService();
    Bucket bucket =
        storage.create(BUCKET_INFO1, BUCKET_TARGET_METAGENERATION, BUCKET_TARGET_PREDEFINED_ACL);
    assertEquals(expectedBucket1, bucket);
  }

  @Test
  public void testCreateBucketFailure() {
    doThrow(STORAGE_FAILURE)
        .when(storageRpcMock)
        .create(Conversions.json().bucketInfo().encode(BUCKET_INFO1), EMPTY_RPC_OPTIONS);
    initializeService();
    try {
      storage.create(BUCKET_INFO1);
      fail();
    } catch (StorageException e) {
      assertEquals(STORAGE_FAILURE, e.getCause());
    }
  }

  @Test
  public void testGetBucket() {
    doReturn(Conversions.json().bucketInfo().encode(BUCKET_INFO1))
        .doThrow(UNEXPECTED_CALL_EXCEPTION)
        .when(storageRpcMock)
        .get(
            Conversions.json().bucketInfo().encode(BucketInfo.of(BUCKET_NAME1)), EMPTY_RPC_OPTIONS);
    initializeService();
    Bucket bucket = storage.get(BUCKET_NAME1);
    assertEquals(expectedBucket1, bucket);
  }

  @Test
  public void testGetBucketWithOptions() {
    doReturn(Conversions.json().bucketInfo().encode(BUCKET_INFO1))
        .doThrow(UNEXPECTED_CALL_EXCEPTION)
        .when(storageRpcMock)
        .get(
            Conversions.json().bucketInfo().encode(BucketInfo.of(BUCKET_NAME1)),
            BUCKET_GET_OPTIONS);
    initializeService();
    Bucket bucket = storage.get(BUCKET_NAME1, BUCKET_GET_METAGENERATION);
    assertEquals(expectedBucket1, bucket);
  }

  @Test
  public void testGetBucketWithSelectedFields() {
    ArgumentCaptor<Map<StorageRpc.Option, Object>> capturedOptions =
        ArgumentCaptor.forClass(Map.class);
    doReturn(Conversions.json().bucketInfo().encode(BUCKET_INFO1))
        .doThrow(UNEXPECTED_CALL_EXCEPTION)
        .when(storageRpcMock)
        .get(
            Mockito.eq(Conversions.json().bucketInfo().encode(BucketInfo.of(BUCKET_NAME1))),
            capturedOptions.capture());
    initializeService();
    Bucket bucket = storage.get(BUCKET_NAME1, BUCKET_GET_METAGENERATION, BUCKET_GET_FIELDS);
    assertEquals(
        BUCKET_INFO1.getMetageneration(),
        capturedOptions.getValue().get(StorageRpc.Option.IF_METAGENERATION_MATCH));
    String selector = (String) capturedOptions.getValue().get(StorageRpc.Option.FIELDS);
    assertTrue(selector.contains("name"));
    assertTrue(selector.contains("location"));
    assertTrue(selector.contains("acl"));
    assertEquals(17, selector.length());
    assertEquals(BUCKET_INFO1.getName(), bucket.getName());
  }

  @Test
  public void testGetBucketWithEmptyFields() {
    ArgumentCaptor<Map<StorageRpc.Option, Object>> capturedOptions =
        ArgumentCaptor.forClass(Map.class);
    doReturn(Conversions.json().bucketInfo().encode(BUCKET_INFO1))
        .doThrow(UNEXPECTED_CALL_EXCEPTION)
        .when(storageRpcMock)
        .get(
            Mockito.eq(Conversions.json().bucketInfo().encode(BucketInfo.of(BUCKET_NAME1))),
            capturedOptions.capture());
    initializeService();
    Bucket bucket = storage.get(BUCKET_NAME1, BUCKET_GET_METAGENERATION, BUCKET_GET_EMPTY_FIELDS);
    assertEquals(
        BUCKET_INFO1.getMetageneration(),
        capturedOptions.getValue().get(StorageRpc.Option.IF_METAGENERATION_MATCH));
    String selector = (String) capturedOptions.getValue().get(StorageRpc.Option.FIELDS);
    assertTrue(selector.contains("name"));
    assertEquals(4, selector.length());
    assertEquals(BUCKET_INFO1.getName(), bucket.getName());
  }

  @Test
  public void testGetBucketFailure() {
    doThrow(STORAGE_FAILURE)
        .when(storageRpcMock)
        .get(
            Conversions.json().bucketInfo().encode(BucketInfo.of(BUCKET_NAME1)), EMPTY_RPC_OPTIONS);
    initializeService();
    try {
      storage.get(BUCKET_NAME1);
      fail();
    } catch (StorageException e) {
      assertEquals(STORAGE_FAILURE, e.getCause());
    }
  }

  @Test
  public void testGetBlob() {
    doReturn(Conversions.json().blobInfo().encode(BLOB_INFO1))
        .doThrow(UNEXPECTED_CALL_EXCEPTION)
        .when(storageRpcMock)
        .get(
            Conversions.json().blobId().encode(BlobId.of(BUCKET_NAME1, BLOB_NAME1)),
            EMPTY_RPC_OPTIONS);
    initializeService();
    Blob blob = storage.get(BUCKET_NAME1, BLOB_NAME1);
    assertEquals(expectedBlob1, blob);
  }

  @Test
  public void testGetBlobWithOptions() {
    doReturn(Conversions.json().blobInfo().encode(BLOB_INFO1))
        .doThrow(UNEXPECTED_CALL_EXCEPTION)
        .when(storageRpcMock)
        .get(
            Conversions.json().blobId().encode(BlobId.of(BUCKET_NAME1, BLOB_NAME1)),
            BLOB_GET_OPTIONS);
    initializeService();
    Blob blob = storage.get(BUCKET_NAME1, BLOB_NAME1, BLOB_GET_METAGENERATION, BLOB_GET_GENERATION);
    assertEquals(expectedBlob1, blob);
  }

  @Test
  public void testGetBlobWithOptionsFromBlobId() {
    doReturn(Conversions.json().blobInfo().encode(BLOB_INFO1))
        .doThrow(UNEXPECTED_CALL_EXCEPTION)
        .when(storageRpcMock)
        .get(Conversions.json().blobId().encode(BLOB_INFO1.getBlobId()), BLOB_GET_OPTIONS);
    initializeService();
    Blob blob =
        storage.get(
            BLOB_INFO1.getBlobId(), BLOB_GET_METAGENERATION, BLOB_GET_GENERATION_FROM_BLOB_ID);
    assertEquals(expectedBlob1, blob);
  }

  @Test
  public void testGetBlobWithSelectedFields() {
    ArgumentCaptor<Map<StorageRpc.Option, Object>> capturedOptions =
        ArgumentCaptor.forClass(Map.class);
    doReturn(Conversions.json().blobInfo().encode(BLOB_INFO1))
        .doThrow(UNEXPECTED_CALL_EXCEPTION)
        .when(storageRpcMock)
        .get(
            Mockito.eq(Conversions.json().blobId().encode(BlobId.of(BUCKET_NAME1, BLOB_NAME1))),
            capturedOptions.capture());
    initializeService();
    Blob blob =
        storage.get(
            BUCKET_NAME1,
            BLOB_NAME1,
            BLOB_GET_METAGENERATION,
            BLOB_GET_GENERATION,
            BLOB_GET_FIELDS);
    assertEquals(
        BLOB_INFO1.getMetageneration(),
        capturedOptions.getValue().get(StorageRpc.Option.IF_METAGENERATION_MATCH));
    assertEquals(
        BLOB_INFO1.getGeneration(),
        capturedOptions.getValue().get(StorageRpc.Option.IF_GENERATION_MATCH));
    String selector = (String) capturedOptions.getValue().get(StorageRpc.Option.FIELDS);
    assertTrue(selector.contains("bucket"));
    assertTrue(selector.contains("name"));
    assertTrue(selector.contains("contentType"));
    assertTrue(selector.contains("crc32c"));
    assertEquals(30, selector.length());
    assertEquals(expectedBlob1, blob);
  }

  @Test
  public void testGetBlobWithEmptyFields() {
    ArgumentCaptor<Map<StorageRpc.Option, Object>> capturedOptions =
        ArgumentCaptor.forClass(Map.class);
    doReturn(Conversions.json().blobInfo().encode(BLOB_INFO1))
        .doThrow(UNEXPECTED_CALL_EXCEPTION)
        .when(storageRpcMock)
        .get(
            Mockito.eq(Conversions.json().blobId().encode(BlobId.of(BUCKET_NAME1, BLOB_NAME1))),
            capturedOptions.capture());
    initializeService();
    Blob blob =
        storage.get(
            BUCKET_NAME1,
            BLOB_NAME1,
            BLOB_GET_METAGENERATION,
            BLOB_GET_GENERATION,
            BLOB_GET_EMPTY_FIELDS);
    assertEquals(
        BLOB_INFO1.getMetageneration(),
        capturedOptions.getValue().get(StorageRpc.Option.IF_METAGENERATION_MATCH));
    assertEquals(
        BLOB_INFO1.getGeneration(),
        capturedOptions.getValue().get(StorageRpc.Option.IF_GENERATION_MATCH));
    String selector = (String) capturedOptions.getValue().get(StorageRpc.Option.FIELDS);
    assertTrue(selector.contains("bucket"));
    assertTrue(selector.contains("name"));
    assertEquals(11, selector.length());
    assertEquals(expectedBlob1, blob);
  }

  @Test
  public void testGetBlobFailure() {
    doThrow(STORAGE_FAILURE)
        .when(storageRpcMock)
        .get(
            Conversions.json().blobId().encode(BlobId.of(BUCKET_NAME1, BLOB_NAME1)),
            EMPTY_RPC_OPTIONS);
    initializeService();
    try {
      storage.get(BUCKET_NAME1, BLOB_NAME1);
      fail();
    } catch (StorageException e) {
      assertEquals(STORAGE_FAILURE, e.getCause());
    }
  }

  private void verifyCreateBlobCapturedStream(ArgumentCaptor<ByteArrayInputStream> capturedStream)
      throws IOException {
    ByteArrayInputStream byteStream = capturedStream.getValue();
    byte[] streamBytes = new byte[BLOB_CONTENT.length];
    assertEquals(BLOB_CONTENT.length, byteStream.read(streamBytes));
    assertArrayEquals(BLOB_CONTENT, streamBytes);
    assertEquals(-1, byteStream.read(streamBytes));
  }

  @Test
  @SuppressWarnings({"unchecked", "deprecation"})
  public void testCreateBlobFromStream() throws IOException {
    ArgumentCaptor<ByteArrayInputStream> capturedStream =
        ArgumentCaptor.forClass(ByteArrayInputStream.class);

    ByteArrayInputStream fileStream = new ByteArrayInputStream(BLOB_CONTENT);

    // verify that md5 and crc32c are cleared if present when calling create
    doReturn(Conversions.json().blobInfo().encode(BLOB_INFO1))
        .doThrow(UNEXPECTED_CALL_EXCEPTION)
        .when(storageRpcMock)
        .create(
            Mockito.eq(Conversions.json().blobInfo().encode(BLOB_INFO_WITHOUT_HASHES)),
            capturedStream.capture(),
            Mockito.eq(EMPTY_RPC_OPTIONS));
    initializeService();

    Blob blob = storage.create(BLOB_INFO_WITH_HASHES, fileStream);

    assertEquals(expectedBlob1, blob);
    verifyCreateBlobCapturedStream(capturedStream);
  }

  @Test
  @SuppressWarnings({"unchecked", "deprecation"})
  public void testCreateBlobFromStreamDisableGzipContent() throws IOException {
    ArgumentCaptor<ByteArrayInputStream> capturedStream =
        ArgumentCaptor.forClass(ByteArrayInputStream.class);

    // verify that md5 and crc32c are cleared if present when calling create
    ByteArrayInputStream fileStream = new ByteArrayInputStream(BLOB_CONTENT);
    doReturn(Conversions.json().blobInfo().encode(BLOB_INFO1))
        .doThrow(UNEXPECTED_CALL_EXCEPTION)
        .when(storageRpcMock)
        .create(
            Mockito.eq(Conversions.json().blobInfo().encode(BLOB_INFO_WITHOUT_HASHES)),
            capturedStream.capture(),
            Mockito.eq(BLOB_TARGET_OPTIONS_CREATE_DISABLE_GZIP_CONTENT));
    initializeService();

    Blob blob =
        storage.create(
            BLOB_INFO_WITH_HASHES, fileStream, Storage.BlobWriteOption.disableGzipContent());

    assertEquals(expectedBlob1, blob);
    verifyCreateBlobCapturedStream(capturedStream);
  }

  @Test
  @SuppressWarnings({"unchecked", "deprecation"})
  public void testCreateBlobFromStreamWithEncryptionKey() throws IOException {
    ByteArrayInputStream fileStream = new ByteArrayInputStream(BLOB_CONTENT);

    // verify that md5 and crc32c are cleared if present when calling create
    doReturn(Conversions.json().blobInfo().encode(BLOB_INFO1))
        .doReturn(Conversions.json().blobInfo().encode(BLOB_INFO1))
        .doThrow(UNEXPECTED_CALL_EXCEPTION)
        .when(storageRpcMock)
        .create(
            Conversions.json().blobInfo().encode(BLOB_INFO_WITHOUT_HASHES),
            fileStream,
            ENCRYPTION_KEY_OPTIONS);
    initializeService();
    Blob blob =
        storage.create(
            BLOB_INFO_WITH_HASHES, fileStream, Storage.BlobWriteOption.encryptionKey(BASE64_KEY));
    assertEquals(expectedBlob1, blob);
    blob =
        storage.create(
            BLOB_INFO_WITH_HASHES, fileStream, Storage.BlobWriteOption.encryptionKey(BASE64_KEY));
    assertEquals(expectedBlob1, blob);
  }

  @Test
  @SuppressWarnings({"unchecked", "deprecation"})
  public void testCreateBlobFromStreamRetryableException() throws IOException {

    ByteArrayInputStream fileStream = new ByteArrayInputStream(BLOB_CONTENT);

    // verify that md5 and crc32c are cleared if present when calling create
    Exception internalErrorException = new StorageException(500, "internalError");
    doThrow(internalErrorException)
        .when(storageRpcMock)
        .create(
            Conversions.json().blobInfo().encode(BLOB_INFO_WITHOUT_HASHES),
            fileStream,
            EMPTY_RPC_OPTIONS);

    storage =
        options.toBuilder()
            .setRetrySettings(ServiceOptions.getDefaultRetrySettings())
            .build()
            .getService();

    // Even though this exception is retryable, storage.create(BlobInfo, InputStream)
    // shouldn't retry.
    try {
      storage.create(BLOB_INFO_WITH_HASHES, fileStream);
      fail();
    } catch (StorageException ex) {
      assertSame(internalErrorException, ex);
    }
  }

  @Test
  public void testCreateFromDirectory() throws IOException {
    initializeService();
    Path dir = Files.createTempDirectory("unit_");
    try {
      storage.createFrom(BLOB_INFO1, dir);
      fail();
    } catch (StorageException e) {
      assertEquals(dir + " is a directory", e.getMessage());
    }
  }

  private BlobInfo initializeUpload(byte[] bytes) {
    return initializeUpload(bytes, DEFAULT_BUFFER_SIZE, EMPTY_RPC_OPTIONS);
  }

  private BlobInfo initializeUpload(byte[] bytes, int bufferSize) {
    return initializeUpload(bytes, bufferSize, EMPTY_RPC_OPTIONS);
  }

  private BlobInfo initializeUpload(
      byte[] bytes, int bufferSize, Map<StorageRpc.Option, ?> rpcOptions) {
    String uploadId = "upload-id";
    byte[] buffer = new byte[bufferSize];
    System.arraycopy(bytes, 0, buffer, 0, bytes.length);
    BlobInfo blobInfo = BLOB_INFO1.toBuilder().setMd5(null).setCrc32c(null).build();
    StorageObject storageObject = new StorageObject();
    storageObject.setBucket(BLOB_INFO1.getBucket());
    storageObject.setName(BLOB_INFO1.getName());
    storageObject.setSize(BigInteger.valueOf(bytes.length));
    doReturn(uploadId)
        .doThrow(UNEXPECTED_CALL_EXCEPTION)
        .when(storageRpcMock)
        .open(Conversions.json().blobInfo().encode(blobInfo), rpcOptions);

    doReturn(storageObject)
        .doThrow(UNEXPECTED_CALL_EXCEPTION)
        .when(storageRpcMock)
        .writeWithResponse(uploadId, buffer, 0, 0L, bytes.length, true);

    initializeService();
    BlobInfo info = Conversions.json().blobInfo().decode(storageObject);
    expectedUpdated = info.asBlob(storage);
    return blobInfo;
  }

  @Test
  public void testListBuckets() {
    String cursor = "cursor";
    ImmutableList<BucketInfo> bucketInfoList = ImmutableList.of(BUCKET_INFO1, BUCKET_INFO2);
    Tuple<String, Iterable<com.google.api.services.storage.model.Bucket>> result =
        Tuple.of(
            cursor, Iterables.transform(bucketInfoList, Conversions.json().bucketInfo()::encode));

    doReturn(result)
        .doThrow(UNEXPECTED_CALL_EXCEPTION)
        .when(storageRpcMock)
        .list(EMPTY_RPC_OPTIONS);

    initializeService();
    ImmutableList<Bucket> bucketList = ImmutableList.of(expectedBucket1, expectedBucket2);
    Page<Bucket> page = storage.list();
    assertEquals(cursor, page.getNextPageToken());
    assertArrayEquals(bucketList.toArray(), Iterables.toArray(page.getValues(), Bucket.class));
  }

  @Test
  public void testListBucketsEmpty() {
    doReturn(Tuple.<String, Iterable<com.google.api.services.storage.model.Bucket>>of(null, null))
        .doThrow(UNEXPECTED_CALL_EXCEPTION)
        .when(storageRpcMock)
        .list(EMPTY_RPC_OPTIONS);

    initializeService();
    Page<Bucket> page = storage.list();
    assertNull(page.getNextPageToken());
    assertArrayEquals(
        ImmutableList.of().toArray(), Iterables.toArray(page.getValues(), Bucket.class));
  }

  @Test
  public void testListBucketsWithOptions() {
    String cursor = "cursor";
    ImmutableList<BucketInfo> bucketInfoList = ImmutableList.of(BUCKET_INFO1, BUCKET_INFO2);
    Tuple<String, Iterable<com.google.api.services.storage.model.Bucket>> result =
        Tuple.of(
            cursor, Iterables.transform(bucketInfoList, Conversions.json().bucketInfo()::encode));

    doReturn(result)
        .doThrow(UNEXPECTED_CALL_EXCEPTION)
        .when(storageRpcMock)
        .list(BUCKET_LIST_OPTIONS);

    initializeService();
    ImmutableList<Bucket> bucketList = ImmutableList.of(expectedBucket1, expectedBucket2);
    Page<Bucket> page = storage.list(BUCKET_LIST_PAGE_SIZE, BUCKET_LIST_PREFIX);
    assertEquals(cursor, page.getNextPageToken());
    assertArrayEquals(bucketList.toArray(), Iterables.toArray(page.getValues(), Bucket.class));
  }

  @Test
  public void testListBucketsWithException() {
    doThrow(STORAGE_FAILURE).when(storageRpcMock).list(EMPTY_RPC_OPTIONS);
    initializeService();
    try {
      storage.list();
      fail();
    } catch (StorageException e) {
      assertEquals(STORAGE_FAILURE.getMessage(), e.getMessage());
    }
  }

  @Test
  public void testListBlobs() {
    String cursor = "cursor";
    ImmutableList<BlobInfo> blobInfoList = ImmutableList.of(BLOB_INFO1, BLOB_INFO2);
    Tuple<String, Iterable<com.google.api.services.storage.model.StorageObject>> result =
        Tuple.of(cursor, Iterables.transform(blobInfoList, Conversions.json().blobInfo()::encode));

    doReturn(result)
        .doThrow(UNEXPECTED_CALL_EXCEPTION)
        .when(storageRpcMock)
        .list(BUCKET_NAME1, EMPTY_RPC_OPTIONS);

    initializeService();
    ImmutableList<Blob> blobList = ImmutableList.of(expectedBlob1, expectedBlob2);
    Page<Blob> page = storage.list(BUCKET_NAME1);
    assertEquals(cursor, page.getNextPageToken());
    assertArrayEquals(blobList.toArray(), Iterables.toArray(page.getValues(), Blob.class));
  }

  @Test
  public void testListBlobsEmpty() {
    doReturn(
            Tuple.<String, Iterable<com.google.api.services.storage.model.StorageObject>>of(
                null, null))
        .doThrow(UNEXPECTED_CALL_EXCEPTION)
        .when(storageRpcMock)
        .list(BUCKET_NAME1, EMPTY_RPC_OPTIONS);

    initializeService();
    Page<Blob> page = storage.list(BUCKET_NAME1);
    assertNull(page.getNextPageToken());
    assertArrayEquals(
        ImmutableList.of().toArray(), Iterables.toArray(page.getValues(), Blob.class));
  }

  @Test
  public void testListBlobsWithOptions() {
    String cursor = "cursor";
    ImmutableList<BlobInfo> blobInfoList = ImmutableList.of(BLOB_INFO1, BLOB_INFO2);
    Tuple<String, Iterable<com.google.api.services.storage.model.StorageObject>> result =
        Tuple.of(cursor, Iterables.transform(blobInfoList, Conversions.json().blobInfo()::encode));
    doReturn(result)
        .doThrow(UNEXPECTED_CALL_EXCEPTION)
        .when(storageRpcMock)
        .list(BUCKET_NAME1, BLOB_LIST_OPTIONS);
    initializeService();
    ImmutableList<Blob> blobList = ImmutableList.of(expectedBlob1, expectedBlob2);
    Page<Blob> page =
        storage.list(BUCKET_NAME1, BLOB_LIST_PAGE_SIZE, BLOB_LIST_PREFIX, BLOB_LIST_VERSIONS);
    assertEquals(cursor, page.getNextPageToken());
    assertArrayEquals(blobList.toArray(), Iterables.toArray(page.getValues(), Blob.class));
  }

  @Test
  public void testListBlobsCurrentDirectory() {
    String cursor = "cursor";
    Map<StorageRpc.Option, ?> options = ImmutableMap.of(StorageRpc.Option.DELIMITER, "/");
    ImmutableList<BlobInfo> blobInfoList = ImmutableList.of(BLOB_INFO1, BLOB_INFO2);
    Tuple<String, Iterable<com.google.api.services.storage.model.StorageObject>> result =
        Tuple.of(cursor, Iterables.transform(blobInfoList, Conversions.json().blobInfo()::encode));
    doReturn(result)
        .doThrow(UNEXPECTED_CALL_EXCEPTION)
        .when(storageRpcMock)
        .list(BUCKET_NAME1, options);

    initializeService();
    ImmutableList<Blob> blobList = ImmutableList.of(expectedBlob1, expectedBlob2);
    Page<Blob> page = storage.list(BUCKET_NAME1, Storage.BlobListOption.currentDirectory());
    assertEquals(cursor, page.getNextPageToken());
    assertArrayEquals(blobList.toArray(), Iterables.toArray(page.getValues(), Blob.class));
  }

  @Test
  public void testListBlobsDelimiter() {
    String cursor = "cursor";
    String delimiter = "/";
    Map<StorageRpc.Option, ?> options = ImmutableMap.of(StorageRpc.Option.DELIMITER, delimiter);
    ImmutableList<BlobInfo> blobInfoList = ImmutableList.of(BLOB_INFO1, BLOB_INFO2);
    Tuple<String, Iterable<com.google.api.services.storage.model.StorageObject>> result =
        Tuple.of(cursor, Iterables.transform(blobInfoList, Conversions.json().blobInfo()::encode));
    doReturn(result)
        .doThrow(UNEXPECTED_CALL_EXCEPTION)
        .when(storageRpcMock)
        .list(BUCKET_NAME1, options);

    initializeService();
    ImmutableList<Blob> blobList = ImmutableList.of(expectedBlob1, expectedBlob2);
    Page<Blob> page = storage.list(BUCKET_NAME1, Storage.BlobListOption.delimiter(delimiter));
    assertEquals(cursor, page.getNextPageToken());
    assertArrayEquals(blobList.toArray(), Iterables.toArray(page.getValues(), Blob.class));
  }

  @Test
  public void testListBlobsWithOffset() {
    String cursor = "cursor";
    String startOffset = "startOffset";
    String endOffset = "endOffset";
    Map<StorageRpc.Option, ?> options =
        ImmutableMap.of(
            StorageRpc.Option.START_OFF_SET, startOffset, StorageRpc.Option.END_OFF_SET, endOffset);
    ImmutableList<BlobInfo> blobInfoList = ImmutableList.of(BLOB_INFO1, BLOB_INFO2);
    Tuple<String, Iterable<com.google.api.services.storage.model.StorageObject>> result =
        Tuple.of(cursor, Iterables.transform(blobInfoList, Conversions.json().blobInfo()::encode));
    doReturn(result)
        .doThrow(UNEXPECTED_CALL_EXCEPTION)
        .when(storageRpcMock)
        .list(BUCKET_NAME1, options);

    initializeService();
    ImmutableList<Blob> blobList = ImmutableList.of(expectedBlob1, expectedBlob2);
    Page<Blob> page =
        storage.list(
            BUCKET_NAME1,
            Storage.BlobListOption.startOffset(startOffset),
            Storage.BlobListOption.endOffset(endOffset));
    assertEquals(cursor, page.getNextPageToken());
    assertArrayEquals(blobList.toArray(), Iterables.toArray(page.getValues(), Blob.class));
  }

  @Test
  public void testListBlobsMatchGlob() {
    String cursor = "cursor";
    String matchGlob = "foo*bar";
    Map<StorageRpc.Option, ?> options = ImmutableMap.of(StorageRpc.Option.MATCH_GLOB, matchGlob);
    ImmutableList<BlobInfo> blobInfoList = ImmutableList.of(BLOB_INFO1, BLOB_INFO2);
    Tuple<String, Iterable<com.google.api.services.storage.model.StorageObject>> result =
        Tuple.of(cursor, Iterables.transform(blobInfoList, Conversions.json().blobInfo()::encode));
    doReturn(result)
        .doThrow(UNEXPECTED_CALL_EXCEPTION)
        .when(storageRpcMock)
        .list(BUCKET_NAME1, options);

    initializeService();
    ImmutableList<Blob> blobList = ImmutableList.of(expectedBlob1, expectedBlob2);
    Page<Blob> page = storage.list(BUCKET_NAME1, Storage.BlobListOption.matchGlob(matchGlob));
    assertEquals(cursor, page.getNextPageToken());
    assertArrayEquals(blobList.toArray(), Iterables.toArray(page.getValues(), Blob.class));
  }

  @Test
  public void testListBlobsWithException() {
    doThrow(STORAGE_FAILURE).when(storageRpcMock).list(BUCKET_NAME1, EMPTY_RPC_OPTIONS);
    initializeService();
    try {
      storage.list(BUCKET_NAME1);
      fail();
    } catch (StorageException e) {
      assertEquals(STORAGE_FAILURE.getMessage(), e.getMessage());
    }
  }

  @Test
  public void testCreateNotification() {
    doReturn(Conversions.json().notificationInfo().encode(NOTIFICATION_INFO_01))
        .when(storageRpcMock)
        .createNotification(
            BUCKET_NAME1, Conversions.json().notificationInfo().encode(NOTIFICATION_INFO_01));
    initializeService();
    Notification notification = storage.createNotification(BUCKET_NAME1, NOTIFICATION_INFO_01);
    verifyBucketNotification(notification);
  }

  @Test
  public void testGetNotification() {
    doReturn(Conversions.json().notificationInfo().encode(NOTIFICATION_INFO_01))
        .when(storageRpcMock)
        .getNotification(BUCKET_NAME1, GENERATED_ID);
    initializeService();
    Notification notification = storage.getNotification(BUCKET_NAME1, GENERATED_ID);
    verifyBucketNotification(notification);
  }

  @Test
  public void testListNotification() {
    doReturn(
            Arrays.asList(
                Conversions.json().notificationInfo().encode(NOTIFICATION_INFO_01),
                Conversions.json().notificationInfo().encode(NOTIFICATION_INFO_02)))
        .when(storageRpcMock)
        .listNotifications(BUCKET_NAME1);
    initializeService();
    List<Notification> notifications = storage.listNotifications(BUCKET_NAME1);
    assertEquals(2, notifications.size());
    verifyBucketNotification(notifications.get(0));
    verifyBucketNotification(notifications.get(1));
  }

  @Test
  public void testDeleteNotification() {
    doReturn(true).when(storageRpcMock).deleteNotification(BUCKET_NAME1, GENERATED_ID);
    initializeService();
    Boolean isDeleted = storage.deleteNotification(BUCKET_NAME1, GENERATED_ID);
    assertEquals(isDeleted, Boolean.TRUE);
  }

  private void verifyBucketNotification(Notification value) {
    assertNull(value.getNotificationId());
    assertEquals(CUSTOM_ATTRIBUTES, value.getCustomAttributes());
    assertEquals(ETAG, value.getEtag());
    assertEquals(SELF_LINK, value.getSelfLink());
    assertEquals(OBJECT_NAME_PREFIX, value.getObjectNamePrefix());
    assertEquals(PAYLOAD_FORMAT.name(), value.getPayloadFormat().name());
    assertEquals(TOPIC, value.getTopic());
    assertEquals(Arrays.asList(EVENT_TYPES), value.getEventTypes());
  }
}
