/*
 * Copyright 2015 Google Inc. All Rights Reserved.
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

import static com.google.cloud.storage.testing.ApiPolicyMatcher.eqApiPolicy;
import static org.easymock.EasyMock.cmp;
import static org.easymock.EasyMock.eq;
import static java.nio.charset.StandardCharsets.UTF_8;
import static org.junit.Assert.assertArrayEquals;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertSame;
import static org.junit.Assert.assertTrue;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.net.URL;
import java.net.URLDecoder;
import java.nio.ByteBuffer;
import java.security.InvalidKeyException;
import java.security.Key;
import java.security.KeyFactory;
import java.security.NoSuchAlgorithmException;
import java.security.PrivateKey;
import java.security.PublicKey;
import java.security.Signature;
import java.security.SignatureException;
import java.security.spec.EncodedKeySpec;
import java.security.spec.InvalidKeySpecException;
import java.security.spec.PKCS8EncodedKeySpec;
import java.security.spec.X509EncodedKeySpec;
import java.util.List;
import java.util.Map;
import java.util.concurrent.TimeUnit;

import javax.crypto.spec.SecretKeySpec;

import org.easymock.Capture;
import org.easymock.EasyMock;
import org.easymock.LogicalOperator;
import org.junit.After;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

import com.google.api.client.googleapis.json.GoogleJsonError;
import com.google.api.gax.core.ApiClock;
import com.google.api.services.storage.model.Policy.Bindings;
import com.google.api.services.storage.model.StorageObject;
import com.google.api.services.storage.model.TestIamPermissionsResponse;
import com.google.auth.oauth2.ServiceAccountCredentials;
import com.google.cloud.Identity;
import com.google.cloud.Policy;
import com.google.cloud.ReadChannel;
import com.google.cloud.ServiceOptions;
import com.google.cloud.WriteChannel;
import com.google.cloud.storage.Acl.Project;
import com.google.cloud.storage.Acl.Project.ProjectRole;
import com.google.cloud.storage.Acl.Role;
import com.google.cloud.storage.Acl.User;
import com.google.cloud.storage.Storage.BlobSourceOption;
import com.google.cloud.storage.Storage.BlobTargetOption;
import com.google.cloud.storage.Storage.BlobWriteOption;
import com.google.cloud.storage.Storage.BucketSourceOption;
import com.google.cloud.storage.Storage.CopyRequest;
import com.google.cloud.storage.spi.v1.RpcBatch;
import com.google.cloud.storage.spi.v1.StorageRpc;
import com.google.cloud.storage.spi.v1.StorageRpc.Tuple;
import com.google.cloud.storage.spi.StorageRpcFactory;
import com.google.common.collect.ImmutableList;
import com.google.common.collect.ImmutableMap;
import com.google.common.collect.Iterables;
import com.google.common.io.BaseEncoding;
import com.google.common.net.UrlEscapers;

public class StorageImplTest {

  private static final String BUCKET_NAME1 = "b1";
  private static final String BUCKET_NAME2 = "b2";
  private static final String BLOB_NAME1 = "n1";
  private static final String BLOB_NAME2 = "n2";
  private static final String BLOB_NAME3 = "n3";
  private static final byte[] BLOB_CONTENT = {0xD, 0xE, 0xA, 0xD};
  private static final String CONTENT_MD5 = "O1R4G1HJSDUISJjoIYmVhQ==";
  private static final String CONTENT_CRC32C = "9N3EPQ==";
  private static final int DEFAULT_CHUNK_SIZE = 2 * 1024 * 1024;
  private static final String BASE64_KEY = "JVzfVl8NLD9FjedFuStegjRfES5ll5zc59CIXw572OA=";
  private static final Key KEY =
      new SecretKeySpec(BaseEncoding.base64().decode(BASE64_KEY), "AES256");

  // BucketInfo objects
  private static final BucketInfo BUCKET_INFO1 =
      BucketInfo.newBuilder(BUCKET_NAME1).setMetageneration(42L).build();
  private static final BucketInfo BUCKET_INFO2 = BucketInfo.newBuilder(BUCKET_NAME2).build();

  // BlobInfo objects
  private static final BlobInfo BLOB_INFO1 =
      BlobInfo.newBuilder(BUCKET_NAME1, BLOB_NAME1, 24L)
          .setMetageneration(42L)
          .setContentType("application/json")
          .setMd5("md5string")
          .build();
  private static final BlobInfo BLOB_INFO2 = BlobInfo.newBuilder(BUCKET_NAME1, BLOB_NAME2).build();
  private static final BlobInfo BLOB_INFO3 = BlobInfo.newBuilder(BUCKET_NAME1, BLOB_NAME3).build();

  // Empty StorageRpc options
  private static final Map<StorageRpc.Option, ?> EMPTY_RPC_OPTIONS = ImmutableMap.of();

  // Bucket target options
  private static final Storage.BucketTargetOption BUCKET_TARGET_METAGENERATION =
      Storage.BucketTargetOption.metagenerationMatch();
  private static final Storage.BucketTargetOption BUCKET_TARGET_PREDEFINED_ACL =
      Storage.BucketTargetOption.predefinedAcl(Storage.PredefinedAcl.PRIVATE);
  private static final Map<StorageRpc.Option, ?> BUCKET_TARGET_OPTIONS =
      ImmutableMap.of(
          StorageRpc.Option.IF_METAGENERATION_MATCH, BUCKET_INFO1.getMetageneration(),
          StorageRpc.Option.PREDEFINED_ACL, BUCKET_TARGET_PREDEFINED_ACL.getValue());

  // Blob target options (create, update, compose)
  private static final BlobTargetOption BLOB_TARGET_GENERATION = BlobTargetOption.generationMatch();
  private static final BlobTargetOption BLOB_TARGET_METAGENERATION =
      BlobTargetOption.metagenerationMatch();
  private static final BlobTargetOption BLOB_TARGET_NOT_EXIST = BlobTargetOption.doesNotExist();
  private static final BlobTargetOption BLOB_TARGET_PREDEFINED_ACL =
      BlobTargetOption.predefinedAcl(Storage.PredefinedAcl.PRIVATE);
  private static final Map<StorageRpc.Option, ?> BLOB_TARGET_OPTIONS_CREATE =
      ImmutableMap.of(
          StorageRpc.Option.IF_METAGENERATION_MATCH, BLOB_INFO1.getMetageneration(),
          StorageRpc.Option.IF_GENERATION_MATCH, 0L,
          StorageRpc.Option.PREDEFINED_ACL, BUCKET_TARGET_PREDEFINED_ACL.getValue());
  private static final Map<StorageRpc.Option, ?> BLOB_TARGET_OPTIONS_UPDATE =
      ImmutableMap.of(
          StorageRpc.Option.IF_METAGENERATION_MATCH, BLOB_INFO1.getMetageneration(),
          StorageRpc.Option.PREDEFINED_ACL, BUCKET_TARGET_PREDEFINED_ACL.getValue());
  private static final Map<StorageRpc.Option, ?> BLOB_TARGET_OPTIONS_COMPOSE =
      ImmutableMap.of(
          StorageRpc.Option.IF_GENERATION_MATCH, BLOB_INFO1.getGeneration(),
          StorageRpc.Option.IF_METAGENERATION_MATCH, BLOB_INFO1.getMetageneration());

  // Blob write options (create, writer)
  private static final BlobWriteOption BLOB_WRITE_METAGENERATION =
      BlobWriteOption.metagenerationMatch();
  private static final BlobWriteOption BLOB_WRITE_NOT_EXIST = BlobWriteOption.doesNotExist();
  private static final BlobWriteOption BLOB_WRITE_PREDEFINED_ACL =
      BlobWriteOption.predefinedAcl(Storage.PredefinedAcl.PRIVATE);
  private static final BlobWriteOption BLOB_WRITE_MD5_HASH = BlobWriteOption.md5Match();
  private static final BlobWriteOption BLOB_WRITE_CRC2C = BlobWriteOption.crc32cMatch();

  // Bucket get/source options
  private static final BucketSourceOption BUCKET_SOURCE_METAGENERATION =
      BucketSourceOption.metagenerationMatch(BUCKET_INFO1.getMetageneration());
  private static final Map<StorageRpc.Option, ?> BUCKET_SOURCE_OPTIONS =
      ImmutableMap.of(
          StorageRpc.Option.IF_METAGENERATION_MATCH, BUCKET_SOURCE_METAGENERATION.getValue());
  private static final Storage.BucketGetOption BUCKET_GET_METAGENERATION =
      Storage.BucketGetOption.metagenerationMatch(BUCKET_INFO1.getMetageneration());
  private static final Storage.BucketGetOption BUCKET_GET_FIELDS =
      Storage.BucketGetOption.fields(Storage.BucketField.LOCATION, Storage.BucketField.ACL);
  private static final Storage.BucketGetOption BUCKET_GET_EMPTY_FIELDS =
      Storage.BucketGetOption.fields();
  private static final Map<StorageRpc.Option, ?> BUCKET_GET_OPTIONS =
      ImmutableMap.of(
          StorageRpc.Option.IF_METAGENERATION_MATCH, BUCKET_SOURCE_METAGENERATION.getValue());

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
          StorageRpc.Option.IF_METAGENERATION_MATCH, BLOB_GET_METAGENERATION.getValue(),
          StorageRpc.Option.IF_GENERATION_MATCH, BLOB_GET_GENERATION.getValue());
  private static final BlobSourceOption BLOB_SOURCE_METAGENERATION =
      BlobSourceOption.metagenerationMatch(BLOB_INFO1.getMetageneration());
  private static final BlobSourceOption BLOB_SOURCE_GENERATION =
      BlobSourceOption.generationMatch(BLOB_INFO1.getGeneration());
  private static final BlobSourceOption BLOB_SOURCE_GENERATION_FROM_BLOB_ID =
      BlobSourceOption.generationMatch();
  private static final Map<StorageRpc.Option, ?> BLOB_SOURCE_OPTIONS =
      ImmutableMap.of(
          StorageRpc.Option.IF_METAGENERATION_MATCH, BLOB_SOURCE_METAGENERATION.getValue(),
          StorageRpc.Option.IF_GENERATION_MATCH, BLOB_SOURCE_GENERATION.getValue());
  private static final Map<StorageRpc.Option, ?> BLOB_SOURCE_OPTIONS_COPY =
      ImmutableMap.of(
          StorageRpc.Option.IF_SOURCE_METAGENERATION_MATCH, BLOB_SOURCE_METAGENERATION.getValue(),
          StorageRpc.Option.IF_SOURCE_GENERATION_MATCH, BLOB_SOURCE_GENERATION.getValue());

  // Bucket list options
  private static final Storage.BucketListOption BUCKET_LIST_PAGE_SIZE =
      Storage.BucketListOption.pageSize(42L);
  private static final Storage.BucketListOption BUCKET_LIST_PREFIX =
      Storage.BucketListOption.prefix("prefix");
  private static final Storage.BucketListOption BUCKET_LIST_FIELDS =
      Storage.BucketListOption.fields(Storage.BucketField.LOCATION, Storage.BucketField.ACL);
  private static final Storage.BucketListOption BUCKET_LIST_EMPTY_FIELDS =
      Storage.BucketListOption.fields();
  private static final Map<StorageRpc.Option, ?> BUCKET_LIST_OPTIONS =
      ImmutableMap.of(
          StorageRpc.Option.MAX_RESULTS, BUCKET_LIST_PAGE_SIZE.getValue(),
          StorageRpc.Option.PREFIX, BUCKET_LIST_PREFIX.getValue());

  // Blob list options
  private static final Storage.BlobListOption BLOB_LIST_PAGE_SIZE =
      Storage.BlobListOption.pageSize(42L);
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
          StorageRpc.Option.MAX_RESULTS, BLOB_LIST_PAGE_SIZE.getValue(),
          StorageRpc.Option.PREFIX, BLOB_LIST_PREFIX.getValue(),
          StorageRpc.Option.VERSIONS, BLOB_LIST_VERSIONS.getValue());

  // ACLs
  private static final Acl ACL = Acl.of(User.ofAllAuthenticatedUsers(), Role.OWNER);
  private static final Acl OTHER_ACL = Acl.of(new Project(ProjectRole.OWNERS, "p"), Role.READER);

  // Customer supplied encryption key options
  private static final Map<StorageRpc.Option, ?> ENCRYPTION_KEY_OPTIONS =
      ImmutableMap.of(StorageRpc.Option.CUSTOMER_SUPPLIED_KEY, BASE64_KEY);

  // IAM policies
  private static final String POLICY_ETAG1 = "CAE=";
  private static final String POLICY_ETAG2 = "CAI=";
  private static final Policy LIB_POLICY1 =
      Policy.newBuilder()
          .addIdentity(StorageRoles.objectViewer(), Identity.allUsers())
          .addIdentity(
              StorageRoles.objectAdmin(),
              Identity.user("test1@gmail.com"),
              Identity.user("test2@gmail.com"))
          .setEtag(POLICY_ETAG1)
          .build();

  private static final com.google.api.services.storage.model.Policy API_POLICY1 =
      new com.google.api.services.storage.model.Policy()
          .setBindings(ImmutableList.of(
              new Bindings()
                  .setMembers(ImmutableList.of("allUsers"))
                  .setRole("roles/storage.objectViewer"),
              new Bindings()
                  .setMembers(
                      ImmutableList.of(
                          "user:test1@gmail.com",
                          "user:test2@gmail.com"))
                  .setRole("roles/storage.objectAdmin")))
          .setEtag(POLICY_ETAG1);

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

  private static final String ACCOUNT = "account";
  private static PrivateKey privateKey;
  private static PublicKey publicKey;

  private StorageOptions options;
  private StorageRpcFactory rpcFactoryMock;
  private StorageRpc storageRpcMock;
  private Storage storage;

  private Blob expectedBlob1, expectedBlob2, expectedBlob3;
  private Bucket expectedBucket1, expectedBucket2;

  @Rule public ExpectedException thrown = ExpectedException.none();

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

  @Before
  public void setUp() {
    rpcFactoryMock = EasyMock.createMock(StorageRpcFactory.class);
    storageRpcMock = EasyMock.createMock(StorageRpc.class);
    EasyMock.expect(rpcFactoryMock.create(EasyMock.anyObject(StorageOptions.class)))
        .andReturn(storageRpcMock);
    EasyMock.replay(rpcFactoryMock);
    options =
        StorageOptions.newBuilder()
            .setProjectId("projectId")
            .setClock(TIME_SOURCE)
            .setServiceRpcFactory(rpcFactoryMock)
            .setRetrySettings(ServiceOptions.getNoRetrySettings())
            .build();
  }

  @After
  public void tearDown() throws Exception {
    EasyMock.verify(rpcFactoryMock, storageRpcMock);
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
  }

  @Test
  public void testGetOptions() {
    EasyMock.replay(storageRpcMock);
    initializeService();
    assertSame(options, storage.getOptions());
  }

  @Test
  public void testCreateBucket() {
    EasyMock.expect(storageRpcMock.create(BUCKET_INFO1.toPb(), EMPTY_RPC_OPTIONS))
        .andReturn(BUCKET_INFO1.toPb());
    EasyMock.replay(storageRpcMock);
    initializeService();
    Bucket bucket = storage.create(BUCKET_INFO1);
    assertEquals(expectedBucket1, bucket);
  }

  @Test
  public void testCreateBucketWithOptions() {
    EasyMock.expect(storageRpcMock.create(BUCKET_INFO1.toPb(), BUCKET_TARGET_OPTIONS))
        .andReturn(BUCKET_INFO1.toPb());
    EasyMock.replay(storageRpcMock);
    initializeService();
    Bucket bucket =
        storage.create(BUCKET_INFO1, BUCKET_TARGET_METAGENERATION, BUCKET_TARGET_PREDEFINED_ACL);
    assertEquals(expectedBucket1, bucket);
  }

  @Test
  public void testCreateBlob() throws IOException {
    Capture<ByteArrayInputStream> capturedStream = Capture.newInstance();
    EasyMock.expect(
            storageRpcMock.create(
                EasyMock.eq(
                    BLOB_INFO1
                        .toBuilder()
                        .setMd5(CONTENT_MD5)
                        .setCrc32c(CONTENT_CRC32C)
                        .build()
                        .toPb()),
                EasyMock.capture(capturedStream),
                EasyMock.eq(EMPTY_RPC_OPTIONS)))
        .andReturn(BLOB_INFO1.toPb());
    EasyMock.replay(storageRpcMock);
    initializeService();
    Blob blob = storage.create(BLOB_INFO1, BLOB_CONTENT);
    assertEquals(expectedBlob1, blob);
    ByteArrayInputStream byteStream = capturedStream.getValue();
    byte[] streamBytes = new byte[BLOB_CONTENT.length];
    assertEquals(BLOB_CONTENT.length, byteStream.read(streamBytes));
    assertArrayEquals(BLOB_CONTENT, streamBytes);
    assertEquals(-1, byteStream.read(streamBytes));
  }

  @Test
  public void testCreateEmptyBlob() throws IOException {
    Capture<ByteArrayInputStream> capturedStream = Capture.newInstance();
    EasyMock.expect(
            storageRpcMock.create(
                EasyMock.eq(
                    BLOB_INFO1
                        .toBuilder()
                        .setMd5("1B2M2Y8AsgTpgAmY7PhCfg==")
                        .setCrc32c("AAAAAA==")
                        .build()
                        .toPb()),
                EasyMock.capture(capturedStream),
                EasyMock.eq(EMPTY_RPC_OPTIONS)))
        .andReturn(BLOB_INFO1.toPb());
    EasyMock.replay(storageRpcMock);
    initializeService();
    Blob blob = storage.create(BLOB_INFO1);
    assertEquals(expectedBlob1, blob);
    ByteArrayInputStream byteStream = capturedStream.getValue();
    byte[] streamBytes = new byte[BLOB_CONTENT.length];
    assertEquals(-1, byteStream.read(streamBytes));
  }

  @Test
  public void testCreateBlobWithOptions() throws IOException {
    Capture<ByteArrayInputStream> capturedStream = Capture.newInstance();
    EasyMock.expect(
            storageRpcMock.create(
                EasyMock.eq(
                    BLOB_INFO1
                        .toBuilder()
                        .setMd5(CONTENT_MD5)
                        .setCrc32c(CONTENT_CRC32C)
                        .build()
                        .toPb()),
                EasyMock.capture(capturedStream),
                EasyMock.eq(BLOB_TARGET_OPTIONS_CREATE)))
        .andReturn(BLOB_INFO1.toPb());
    EasyMock.replay(storageRpcMock);
    initializeService();
    Blob blob =
        storage.create(
            BLOB_INFO1,
            BLOB_CONTENT,
            BLOB_TARGET_METAGENERATION,
            BLOB_TARGET_NOT_EXIST,
            BLOB_TARGET_PREDEFINED_ACL);
    assertEquals(expectedBlob1, blob);
    ByteArrayInputStream byteStream = capturedStream.getValue();
    byte[] streamBytes = new byte[BLOB_CONTENT.length];
    assertEquals(BLOB_CONTENT.length, byteStream.read(streamBytes));
    assertArrayEquals(BLOB_CONTENT, streamBytes);
    assertEquals(-1, byteStream.read(streamBytes));
  }

  @Test
  public void testCreateBlobWithEncryptionKey() throws IOException {
    Capture<ByteArrayInputStream> capturedStream = Capture.newInstance();
    EasyMock.expect(
            storageRpcMock.create(
                EasyMock.eq(
                    BLOB_INFO1
                        .toBuilder()
                        .setMd5(CONTENT_MD5)
                        .setCrc32c(CONTENT_CRC32C)
                        .build()
                        .toPb()),
                EasyMock.capture(capturedStream),
                EasyMock.eq(ENCRYPTION_KEY_OPTIONS)))
        .andReturn(BLOB_INFO1.toPb())
        .times(2);
    EasyMock.replay(storageRpcMock);
    initializeService();
    Blob blob = storage.create(BLOB_INFO1, BLOB_CONTENT, BlobTargetOption.encryptionKey(KEY));
    assertEquals(expectedBlob1, blob);
    ByteArrayInputStream byteStream = capturedStream.getValue();
    byte[] streamBytes = new byte[BLOB_CONTENT.length];
    assertEquals(BLOB_CONTENT.length, byteStream.read(streamBytes));
    assertArrayEquals(BLOB_CONTENT, streamBytes);
    assertEquals(-1, byteStream.read(streamBytes));
    blob = storage.create(BLOB_INFO1, BLOB_CONTENT, BlobTargetOption.encryptionKey(BASE64_KEY));
    assertEquals(expectedBlob1, blob);
    byteStream = capturedStream.getValue();
    streamBytes = new byte[BLOB_CONTENT.length];
    assertEquals(BLOB_CONTENT.length, byteStream.read(streamBytes));
    assertArrayEquals(BLOB_CONTENT, streamBytes);
    assertEquals(-1, byteStream.read(streamBytes));
  }

  @Test
  public void testCreateBlobFromStream() {
    ByteArrayInputStream fileStream = new ByteArrayInputStream(BLOB_CONTENT);
    BlobInfo.Builder infoBuilder = BLOB_INFO1.toBuilder();
    BlobInfo infoWithHashes = infoBuilder.setMd5(CONTENT_MD5).setCrc32c(CONTENT_CRC32C).build();
    BlobInfo infoWithoutHashes = infoBuilder.setMd5(null).setCrc32c(null).build();
    EasyMock.expect(storageRpcMock.create(infoWithoutHashes.toPb(), fileStream, EMPTY_RPC_OPTIONS))
        .andReturn(BLOB_INFO1.toPb());
    EasyMock.replay(storageRpcMock);
    initializeService();
    Blob blob = storage.create(infoWithHashes, fileStream);
    assertEquals(expectedBlob1, blob);
  }

  @Test
  public void testCreateBlobFromStreamWithEncryptionKey() throws IOException {
    ByteArrayInputStream fileStream = new ByteArrayInputStream(BLOB_CONTENT);
    BlobInfo.Builder infoBuilder = BLOB_INFO1.toBuilder();
    BlobInfo infoWithHashes = infoBuilder.setMd5(CONTENT_MD5).setCrc32c(CONTENT_CRC32C).build();
    BlobInfo infoWithoutHashes = infoBuilder.setMd5(null).setCrc32c(null).build();
    EasyMock.expect(
            storageRpcMock.create(infoWithoutHashes.toPb(), fileStream, ENCRYPTION_KEY_OPTIONS))
        .andReturn(BLOB_INFO1.toPb())
        .times(2);
    EasyMock.replay(storageRpcMock);
    initializeService();
    Blob blob =
        storage.create(infoWithHashes, fileStream, BlobWriteOption.encryptionKey(BASE64_KEY));
    assertEquals(expectedBlob1, blob);
    blob = storage.create(infoWithHashes, fileStream, BlobWriteOption.encryptionKey(BASE64_KEY));
    assertEquals(expectedBlob1, blob);
  }

  @Test
  public void testGetBucket() {
    EasyMock.expect(storageRpcMock.get(BucketInfo.of(BUCKET_NAME1).toPb(), EMPTY_RPC_OPTIONS))
        .andReturn(BUCKET_INFO1.toPb());
    EasyMock.replay(storageRpcMock);
    initializeService();
    Bucket bucket = storage.get(BUCKET_NAME1);
    assertEquals(expectedBucket1, bucket);
  }

  @Test
  public void testGetBucketWithOptions() {
    EasyMock.expect(storageRpcMock.get(BucketInfo.of(BUCKET_NAME1).toPb(), BUCKET_GET_OPTIONS))
        .andReturn(BUCKET_INFO1.toPb());
    EasyMock.replay(storageRpcMock);
    initializeService();
    Bucket bucket = storage.get(BUCKET_NAME1, BUCKET_GET_METAGENERATION);
    assertEquals(expectedBucket1, bucket);
  }

  @Test
  public void testGetBucketWithSelectedFields() {
    Capture<Map<StorageRpc.Option, Object>> capturedOptions = Capture.newInstance();
    EasyMock.expect(
            storageRpcMock.get(
                EasyMock.eq(BucketInfo.of(BUCKET_NAME1).toPb()), EasyMock.capture(capturedOptions)))
        .andReturn(BUCKET_INFO1.toPb());
    EasyMock.replay(storageRpcMock);
    initializeService();
    Bucket bucket = storage.get(BUCKET_NAME1, BUCKET_GET_METAGENERATION, BUCKET_GET_FIELDS);
    assertEquals(
        BUCKET_GET_METAGENERATION.getValue(),
        capturedOptions.getValue().get(BUCKET_GET_METAGENERATION.getRpcOption()));
    String selector = (String) capturedOptions.getValue().get(BLOB_GET_FIELDS.getRpcOption());
    assertTrue(selector.contains("name"));
    assertTrue(selector.contains("location"));
    assertTrue(selector.contains("acl"));
    assertEquals(17, selector.length());
    assertEquals(BUCKET_INFO1.getName(), bucket.getName());
  }

  @Test
  public void testGetBucketWithEmptyFields() {
    Capture<Map<StorageRpc.Option, Object>> capturedOptions = Capture.newInstance();
    EasyMock.expect(
            storageRpcMock.get(
                EasyMock.eq(BucketInfo.of(BUCKET_NAME1).toPb()), EasyMock.capture(capturedOptions)))
        .andReturn(BUCKET_INFO1.toPb());
    EasyMock.replay(storageRpcMock);
    initializeService();
    Bucket bucket = storage.get(BUCKET_NAME1, BUCKET_GET_METAGENERATION, BUCKET_GET_EMPTY_FIELDS);
    assertEquals(
        BUCKET_GET_METAGENERATION.getValue(),
        capturedOptions.getValue().get(BUCKET_GET_METAGENERATION.getRpcOption()));
    String selector = (String) capturedOptions.getValue().get(BLOB_GET_FIELDS.getRpcOption());
    assertTrue(selector.contains("name"));
    assertEquals(4, selector.length());
    assertEquals(BUCKET_INFO1.getName(), bucket.getName());
  }

  @Test
  public void testGetBlob() {
    EasyMock.expect(
            storageRpcMock.get(BlobId.of(BUCKET_NAME1, BLOB_NAME1).toPb(), EMPTY_RPC_OPTIONS))
        .andReturn(BLOB_INFO1.toPb());
    EasyMock.replay(storageRpcMock);
    initializeService();
    Blob blob = storage.get(BUCKET_NAME1, BLOB_NAME1);
    assertEquals(expectedBlob1, blob);
  }

  @Test
  public void testGetBlobWithOptions() {
    EasyMock.expect(
            storageRpcMock.get(BlobId.of(BUCKET_NAME1, BLOB_NAME1).toPb(), BLOB_GET_OPTIONS))
        .andReturn(BLOB_INFO1.toPb());
    EasyMock.replay(storageRpcMock);
    initializeService();
    Blob blob = storage.get(BUCKET_NAME1, BLOB_NAME1, BLOB_GET_METAGENERATION, BLOB_GET_GENERATION);
    assertEquals(expectedBlob1, blob);
  }

  @Test
  public void testGetBlobWithOptionsFromBlobId() {
    EasyMock.expect(storageRpcMock.get(BLOB_INFO1.getBlobId().toPb(), BLOB_GET_OPTIONS))
        .andReturn(BLOB_INFO1.toPb());
    EasyMock.replay(storageRpcMock);
    initializeService();
    Blob blob =
        storage.get(
            BLOB_INFO1.getBlobId(), BLOB_GET_METAGENERATION, BLOB_GET_GENERATION_FROM_BLOB_ID);
    assertEquals(expectedBlob1, blob);
  }

  @Test
  public void testGetBlobWithSelectedFields() {
    Capture<Map<StorageRpc.Option, Object>> capturedOptions = Capture.newInstance();
    EasyMock.expect(
            storageRpcMock.get(
                EasyMock.eq(BlobId.of(BUCKET_NAME1, BLOB_NAME1).toPb()),
                EasyMock.capture(capturedOptions)))
        .andReturn(BLOB_INFO1.toPb());
    EasyMock.replay(storageRpcMock);
    initializeService();
    Blob blob =
        storage.get(
            BUCKET_NAME1,
            BLOB_NAME1,
            BLOB_GET_METAGENERATION,
            BLOB_GET_GENERATION,
            BLOB_GET_FIELDS);
    assertEquals(
        BLOB_GET_METAGENERATION.getValue(),
        capturedOptions.getValue().get(BLOB_GET_METAGENERATION.getRpcOption()));
    assertEquals(
        BLOB_GET_GENERATION.getValue(),
        capturedOptions.getValue().get(BLOB_GET_GENERATION.getRpcOption()));
    String selector = (String) capturedOptions.getValue().get(BLOB_GET_FIELDS.getRpcOption());
    assertTrue(selector.contains("bucket"));
    assertTrue(selector.contains("name"));
    assertTrue(selector.contains("contentType"));
    assertTrue(selector.contains("crc32c"));
    assertEquals(30, selector.length());
    assertEquals(expectedBlob1, blob);
  }

  @Test
  public void testGetBlobWithEmptyFields() {
    Capture<Map<StorageRpc.Option, Object>> capturedOptions = Capture.newInstance();
    EasyMock.expect(
            storageRpcMock.get(
                EasyMock.eq(BlobId.of(BUCKET_NAME1, BLOB_NAME1).toPb()),
                EasyMock.capture(capturedOptions)))
        .andReturn(BLOB_INFO1.toPb());
    EasyMock.replay(storageRpcMock);
    initializeService();
    Blob blob =
        storage.get(
            BUCKET_NAME1,
            BLOB_NAME1,
            BLOB_GET_METAGENERATION,
            BLOB_GET_GENERATION,
            BLOB_GET_EMPTY_FIELDS);
    assertEquals(
        BLOB_GET_METAGENERATION.getValue(),
        capturedOptions.getValue().get(BLOB_GET_METAGENERATION.getRpcOption()));
    assertEquals(
        BLOB_GET_GENERATION.getValue(),
        capturedOptions.getValue().get(BLOB_GET_GENERATION.getRpcOption()));
    String selector = (String) capturedOptions.getValue().get(BLOB_GET_FIELDS.getRpcOption());
    assertTrue(selector.contains("bucket"));
    assertTrue(selector.contains("name"));
    assertEquals(11, selector.length());
    assertEquals(expectedBlob1, blob);
  }

  @Test
  public void testListBuckets() {
    String cursor = "cursor";
    ImmutableList<BucketInfo> bucketInfoList = ImmutableList.of(BUCKET_INFO1, BUCKET_INFO2);
    Tuple<String, Iterable<com.google.api.services.storage.model.Bucket>> result =
        Tuple.of(cursor, Iterables.transform(bucketInfoList, BucketInfo.TO_PB_FUNCTION));
    EasyMock.expect(storageRpcMock.list(EMPTY_RPC_OPTIONS)).andReturn(result);
    EasyMock.replay(storageRpcMock);
    initializeService();
    ImmutableList<Bucket> bucketList = ImmutableList.of(expectedBucket1, expectedBucket2);
    Page<Bucket> page = storage.list();
    assertEquals(cursor, page.getNextPageToken());
    assertArrayEquals(bucketList.toArray(), Iterables.toArray(page.getValues(), Bucket.class));
  }

  @Test
  public void testListBucketsEmpty() {
    EasyMock.expect(storageRpcMock.list(EMPTY_RPC_OPTIONS))
        .andReturn(
            Tuple.<String, Iterable<com.google.api.services.storage.model.Bucket>>of(null, null));
    EasyMock.replay(storageRpcMock);
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
        Tuple.of(cursor, Iterables.transform(bucketInfoList, BucketInfo.TO_PB_FUNCTION));
    EasyMock.expect(storageRpcMock.list(BUCKET_LIST_OPTIONS)).andReturn(result);
    EasyMock.replay(storageRpcMock);
    initializeService();
    ImmutableList<Bucket> bucketList = ImmutableList.of(expectedBucket1, expectedBucket2);
    Page<Bucket> page = storage.list(BUCKET_LIST_PAGE_SIZE, BUCKET_LIST_PREFIX);
    assertEquals(cursor, page.getNextPageToken());
    assertArrayEquals(bucketList.toArray(), Iterables.toArray(page.getValues(), Bucket.class));
  }

  @Test
  public void testListBucketsWithSelectedFields() {
    String cursor = "cursor";
    Capture<Map<StorageRpc.Option, Object>> capturedOptions = Capture.newInstance();
    ImmutableList<BucketInfo> bucketInfoList = ImmutableList.of(BUCKET_INFO1, BUCKET_INFO2);
    Tuple<String, Iterable<com.google.api.services.storage.model.Bucket>> result =
        Tuple.of(cursor, Iterables.transform(bucketInfoList, BucketInfo.TO_PB_FUNCTION));
    EasyMock.expect(storageRpcMock.list(EasyMock.capture(capturedOptions))).andReturn(result);
    EasyMock.replay(storageRpcMock);
    initializeService();
    ImmutableList<Bucket> bucketList = ImmutableList.of(expectedBucket1, expectedBucket2);
    Page<Bucket> page = storage.list(BUCKET_LIST_FIELDS);
    String selector = (String) capturedOptions.getValue().get(BUCKET_LIST_FIELDS.getRpcOption());
    assertTrue(selector.contains("items("));
    assertTrue(selector.contains("name"));
    assertTrue(selector.contains("acl"));
    assertTrue(selector.contains("location"));
    assertTrue(selector.contains("nextPageToken"));
    assertTrue(selector.endsWith(")"));
    assertEquals(38, selector.length());
    assertEquals(cursor, page.getNextPageToken());
    assertArrayEquals(bucketList.toArray(), Iterables.toArray(page.getValues(), Bucket.class));
  }

  @Test
  public void testListBucketsWithEmptyFields() {
    String cursor = "cursor";
    Capture<Map<StorageRpc.Option, Object>> capturedOptions = Capture.newInstance();
    ImmutableList<BucketInfo> bucketInfoList = ImmutableList.of(BUCKET_INFO1, BUCKET_INFO2);
    Tuple<String, Iterable<com.google.api.services.storage.model.Bucket>> result =
        Tuple.of(cursor, Iterables.transform(bucketInfoList, BucketInfo.TO_PB_FUNCTION));
    EasyMock.expect(storageRpcMock.list(EasyMock.capture(capturedOptions))).andReturn(result);
    EasyMock.replay(storageRpcMock);
    initializeService();
    ImmutableList<Bucket> bucketList = ImmutableList.of(expectedBucket1, expectedBucket2);
    Page<Bucket> page = storage.list(BUCKET_LIST_EMPTY_FIELDS);
    String selector =
        (String) capturedOptions.getValue().get(BUCKET_LIST_EMPTY_FIELDS.getRpcOption());
    assertTrue(selector.contains("items("));
    assertTrue(selector.contains("name"));
    assertTrue(selector.contains("nextPageToken"));
    assertTrue(selector.endsWith(")"));
    assertEquals(25, selector.length());
    assertEquals(cursor, page.getNextPageToken());
    assertArrayEquals(bucketList.toArray(), Iterables.toArray(page.getValues(), Bucket.class));
  }

  @Test
  public void testListBlobs() {
    String cursor = "cursor";
    ImmutableList<BlobInfo> blobInfoList = ImmutableList.of(BLOB_INFO1, BLOB_INFO2);
    Tuple<String, Iterable<com.google.api.services.storage.model.StorageObject>> result =
        Tuple.of(cursor, Iterables.transform(blobInfoList, BlobInfo.INFO_TO_PB_FUNCTION));
    EasyMock.expect(storageRpcMock.list(BUCKET_NAME1, EMPTY_RPC_OPTIONS)).andReturn(result);
    EasyMock.replay(storageRpcMock);
    initializeService();
    ImmutableList<Blob> blobList = ImmutableList.of(expectedBlob1, expectedBlob2);
    Page<Blob> page = storage.list(BUCKET_NAME1);
    assertEquals(cursor, page.getNextPageToken());
    assertArrayEquals(blobList.toArray(), Iterables.toArray(page.getValues(), Blob.class));
  }

  @Test
  public void testListBlobsEmpty() {
    EasyMock.expect(storageRpcMock.list(BUCKET_NAME1, EMPTY_RPC_OPTIONS))
        .andReturn(
            Tuple.<String, Iterable<com.google.api.services.storage.model.StorageObject>>of(
                null, null));
    EasyMock.replay(storageRpcMock);
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
        Tuple.of(cursor, Iterables.transform(blobInfoList, BlobInfo.INFO_TO_PB_FUNCTION));
    EasyMock.expect(storageRpcMock.list(BUCKET_NAME1, BLOB_LIST_OPTIONS)).andReturn(result);
    EasyMock.replay(storageRpcMock);
    initializeService();
    ImmutableList<Blob> blobList = ImmutableList.of(expectedBlob1, expectedBlob2);
    Page<Blob> page =
        storage.list(BUCKET_NAME1, BLOB_LIST_PAGE_SIZE, BLOB_LIST_PREFIX, BLOB_LIST_VERSIONS);
    assertEquals(cursor, page.getNextPageToken());
    assertArrayEquals(blobList.toArray(), Iterables.toArray(page.getValues(), Blob.class));
  }

  @Test
  public void testListBlobsWithSelectedFields() {
    String cursor = "cursor";
    Capture<Map<StorageRpc.Option, Object>> capturedOptions = Capture.newInstance();
    ImmutableList<BlobInfo> blobInfoList = ImmutableList.of(BLOB_INFO1, BLOB_INFO2);
    Tuple<String, Iterable<com.google.api.services.storage.model.StorageObject>> result =
        Tuple.of(cursor, Iterables.transform(blobInfoList, BlobInfo.INFO_TO_PB_FUNCTION));
    EasyMock.expect(
            storageRpcMock.list(EasyMock.eq(BUCKET_NAME1), EasyMock.capture(capturedOptions)))
        .andReturn(result);
    EasyMock.replay(storageRpcMock);
    initializeService();
    ImmutableList<Blob> blobList = ImmutableList.of(expectedBlob1, expectedBlob2);
    Page<Blob> page =
        storage.list(BUCKET_NAME1, BLOB_LIST_PAGE_SIZE, BLOB_LIST_PREFIX, BLOB_LIST_FIELDS);
    assertEquals(
        BLOB_LIST_PAGE_SIZE.getValue(),
        capturedOptions.getValue().get(BLOB_LIST_PAGE_SIZE.getRpcOption()));
    assertEquals(
        BLOB_LIST_PREFIX.getValue(),
        capturedOptions.getValue().get(BLOB_LIST_PREFIX.getRpcOption()));
    String selector = (String) capturedOptions.getValue().get(BLOB_LIST_FIELDS.getRpcOption());
    assertTrue(selector.contains("prefixes"));
    assertTrue(selector.contains("items("));
    assertTrue(selector.contains("bucket"));
    assertTrue(selector.contains("name"));
    assertTrue(selector.contains("contentType"));
    assertTrue(selector.contains("md5Hash"));
    assertTrue(selector.contains("nextPageToken"));
    assertTrue(selector.endsWith(")"));
    assertEquals(61, selector.length());
    assertEquals(cursor, page.getNextPageToken());
    assertArrayEquals(blobList.toArray(), Iterables.toArray(page.getValues(), Blob.class));
  }

  @Test
  public void testListBlobsWithEmptyFields() {
    String cursor = "cursor";
    Capture<Map<StorageRpc.Option, Object>> capturedOptions = Capture.newInstance();
    ImmutableList<BlobInfo> blobInfoList = ImmutableList.of(BLOB_INFO1, BLOB_INFO2);
    Tuple<String, Iterable<com.google.api.services.storage.model.StorageObject>> result =
        Tuple.of(cursor, Iterables.transform(blobInfoList, BlobInfo.INFO_TO_PB_FUNCTION));
    EasyMock.expect(
            storageRpcMock.list(EasyMock.eq(BUCKET_NAME1), EasyMock.capture(capturedOptions)))
        .andReturn(result);
    EasyMock.replay(storageRpcMock);
    initializeService();
    ImmutableList<Blob> blobList = ImmutableList.of(expectedBlob1, expectedBlob2);
    Page<Blob> page =
        storage.list(BUCKET_NAME1, BLOB_LIST_PAGE_SIZE, BLOB_LIST_PREFIX, BLOB_LIST_EMPTY_FIELDS);
    assertEquals(
        BLOB_LIST_PAGE_SIZE.getValue(),
        capturedOptions.getValue().get(BLOB_LIST_PAGE_SIZE.getRpcOption()));
    assertEquals(
        BLOB_LIST_PREFIX.getValue(),
        capturedOptions.getValue().get(BLOB_LIST_PREFIX.getRpcOption()));
    String selector =
        (String) capturedOptions.getValue().get(BLOB_LIST_EMPTY_FIELDS.getRpcOption());
    assertTrue(selector.contains("prefixes"));
    assertTrue(selector.contains("items("));
    assertTrue(selector.contains("bucket"));
    assertTrue(selector.contains("name"));
    assertTrue(selector.contains("nextPageToken"));
    assertTrue(selector.endsWith(")"));
    assertEquals(41, selector.length());
    assertEquals(cursor, page.getNextPageToken());
    assertArrayEquals(blobList.toArray(), Iterables.toArray(page.getValues(), Blob.class));
  }

  @Test
  public void testListBlobsCurrentDirectory() {
    String cursor = "cursor";
    Map<StorageRpc.Option, ?> options = ImmutableMap.of(StorageRpc.Option.DELIMITER, "/");
    ImmutableList<BlobInfo> blobInfoList = ImmutableList.of(BLOB_INFO1, BLOB_INFO2);
    Tuple<String, Iterable<com.google.api.services.storage.model.StorageObject>> result =
        Tuple.of(cursor, Iterables.transform(blobInfoList, BlobInfo.INFO_TO_PB_FUNCTION));
    EasyMock.expect(storageRpcMock.list(BUCKET_NAME1, options)).andReturn(result);
    EasyMock.replay(storageRpcMock);
    initializeService();
    ImmutableList<Blob> blobList = ImmutableList.of(expectedBlob1, expectedBlob2);
    Page<Blob> page = storage.list(BUCKET_NAME1, Storage.BlobListOption.currentDirectory());
    assertEquals(cursor, page.getNextPageToken());
    assertArrayEquals(blobList.toArray(), Iterables.toArray(page.getValues(), Blob.class));
  }

  @Test
  public void testUpdateBucket() {
    BucketInfo updatedBucketInfo = BUCKET_INFO1.toBuilder().setIndexPage("some-page").build();
    EasyMock.expect(storageRpcMock.patch(updatedBucketInfo.toPb(), EMPTY_RPC_OPTIONS))
        .andReturn(updatedBucketInfo.toPb());
    EasyMock.replay(storageRpcMock);
    initializeService();
    Bucket bucket = storage.update(updatedBucketInfo);
    assertEquals(new Bucket(storage, new BucketInfo.BuilderImpl(updatedBucketInfo)), bucket);
  }

  @Test
  public void testUpdateBucketWithOptions() {
    BucketInfo updatedBucketInfo = BUCKET_INFO1.toBuilder().setIndexPage("some-page").build();
    EasyMock.expect(storageRpcMock.patch(updatedBucketInfo.toPb(), BUCKET_TARGET_OPTIONS))
        .andReturn(updatedBucketInfo.toPb());
    EasyMock.replay(storageRpcMock);
    initializeService();
    Bucket bucket =
        storage.update(
            updatedBucketInfo, BUCKET_TARGET_METAGENERATION, BUCKET_TARGET_PREDEFINED_ACL);
    assertEquals(new Bucket(storage, new BucketInfo.BuilderImpl(updatedBucketInfo)), bucket);
  }

  @Test
  public void testUpdateBlob() {
    BlobInfo updatedBlobInfo = BLOB_INFO1.toBuilder().setContentType("some-content-type").build();
    EasyMock.expect(storageRpcMock.patch(updatedBlobInfo.toPb(), EMPTY_RPC_OPTIONS))
        .andReturn(updatedBlobInfo.toPb());
    EasyMock.replay(storageRpcMock);
    initializeService();
    Blob blob = storage.update(updatedBlobInfo);
    assertEquals(new Blob(storage, new BlobInfo.BuilderImpl(updatedBlobInfo)), blob);
  }

  @Test
  public void testUpdateBlobWithOptions() {
    BlobInfo updatedBlobInfo = BLOB_INFO1.toBuilder().setContentType("some-content-type").build();
    EasyMock.expect(storageRpcMock.patch(updatedBlobInfo.toPb(), BLOB_TARGET_OPTIONS_UPDATE))
        .andReturn(updatedBlobInfo.toPb());
    EasyMock.replay(storageRpcMock);
    initializeService();
    Blob blob =
        storage.update(updatedBlobInfo, BLOB_TARGET_METAGENERATION, BLOB_TARGET_PREDEFINED_ACL);
    assertEquals(new Blob(storage, new BlobInfo.BuilderImpl(updatedBlobInfo)), blob);
  }

  @Test
  public void testDeleteBucket() {
    EasyMock.expect(storageRpcMock.delete(BucketInfo.of(BUCKET_NAME1).toPb(), EMPTY_RPC_OPTIONS))
        .andReturn(true);
    EasyMock.replay(storageRpcMock);
    initializeService();
    assertTrue(storage.delete(BUCKET_NAME1));
  }

  @Test
  public void testDeleteBucketWithOptions() {
    EasyMock.expect(
            storageRpcMock.delete(BucketInfo.of(BUCKET_NAME1).toPb(), BUCKET_SOURCE_OPTIONS))
        .andReturn(true);
    EasyMock.replay(storageRpcMock);
    initializeService();
    assertTrue(storage.delete(BUCKET_NAME1, BUCKET_SOURCE_METAGENERATION));
  }

  @Test
  public void testDeleteBlob() {
    EasyMock.expect(
            storageRpcMock.delete(BlobId.of(BUCKET_NAME1, BLOB_NAME1).toPb(), EMPTY_RPC_OPTIONS))
        .andReturn(true);
    EasyMock.replay(storageRpcMock);
    initializeService();
    assertTrue(storage.delete(BUCKET_NAME1, BLOB_NAME1));
  }

  @Test
  public void testDeleteBlobWithOptions() {
    EasyMock.expect(
            storageRpcMock.delete(BlobId.of(BUCKET_NAME1, BLOB_NAME1).toPb(), BLOB_SOURCE_OPTIONS))
        .andReturn(true);
    EasyMock.replay(storageRpcMock);
    initializeService();
    assertTrue(
        storage.delete(
            BUCKET_NAME1, BLOB_NAME1, BLOB_SOURCE_GENERATION, BLOB_SOURCE_METAGENERATION));
  }

  @Test
  public void testDeleteBlobWithOptionsFromBlobId() {
    EasyMock.expect(storageRpcMock.delete(BLOB_INFO1.getBlobId().toPb(), BLOB_SOURCE_OPTIONS))
        .andReturn(true);
    EasyMock.replay(storageRpcMock);
    initializeService();
    assertTrue(
        storage.delete(
            BLOB_INFO1.getBlobId(),
            BLOB_SOURCE_GENERATION_FROM_BLOB_ID,
            BLOB_SOURCE_METAGENERATION));
  }

  @Test
  public void testCompose() {
    Storage.ComposeRequest req =
        Storage.ComposeRequest.newBuilder()
            .addSource(BLOB_NAME2, BLOB_NAME3)
            .setTarget(BLOB_INFO1)
            .build();
    EasyMock.expect(
            storageRpcMock.compose(
                ImmutableList.of(BLOB_INFO2.toPb(), BLOB_INFO3.toPb()),
                BLOB_INFO1.toPb(),
                EMPTY_RPC_OPTIONS))
        .andReturn(BLOB_INFO1.toPb());
    EasyMock.replay(storageRpcMock);
    initializeService();
    Blob blob = storage.compose(req);
    assertEquals(expectedBlob1, blob);
  }

  @Test
  public void testComposeWithOptions() {
    Storage.ComposeRequest req =
        Storage.ComposeRequest.newBuilder()
            .addSource(BLOB_NAME2, BLOB_NAME3)
            .setTarget(BLOB_INFO1)
            .setTargetOptions(BLOB_TARGET_GENERATION, BLOB_TARGET_METAGENERATION)
            .build();
    EasyMock.expect(
            storageRpcMock.compose(
                ImmutableList.of(BLOB_INFO2.toPb(), BLOB_INFO3.toPb()),
                BLOB_INFO1.toPb(),
                BLOB_TARGET_OPTIONS_COMPOSE))
        .andReturn(BLOB_INFO1.toPb());
    EasyMock.replay(storageRpcMock);
    initializeService();
    Blob blob = storage.compose(req);
    assertEquals(expectedBlob1, blob);
  }

  @Test
  public void testCopy() {
    CopyRequest request = Storage.CopyRequest.of(BLOB_INFO1.getBlobId(), BLOB_INFO2.getBlobId());
    StorageRpc.RewriteRequest rpcRequest =
        new StorageRpc.RewriteRequest(
            request.getSource().toPb(),
            EMPTY_RPC_OPTIONS,
            false,
            BLOB_INFO2.toPb(),
            EMPTY_RPC_OPTIONS,
            null);
    StorageRpc.RewriteResponse rpcResponse =
        new StorageRpc.RewriteResponse(rpcRequest, null, 42L, false, "token", 21L);
    EasyMock.expect(storageRpcMock.openRewrite(rpcRequest)).andReturn(rpcResponse);
    EasyMock.replay(storageRpcMock);
    initializeService();
    CopyWriter writer = storage.copy(request);
    assertEquals(42L, writer.getBlobSize());
    assertEquals(21L, writer.getTotalBytesCopied());
    assertTrue(!writer.isDone());
  }

  @Test
  public void testCopyWithOptions() {
    CopyRequest request =
        Storage.CopyRequest.newBuilder()
            .setSource(BLOB_INFO2.getBlobId())
            .setSourceOptions(BLOB_SOURCE_GENERATION, BLOB_SOURCE_METAGENERATION)
            .setTarget(BLOB_INFO1, BLOB_TARGET_GENERATION, BLOB_TARGET_METAGENERATION)
            .build();
    StorageRpc.RewriteRequest rpcRequest =
        new StorageRpc.RewriteRequest(
            request.getSource().toPb(),
            BLOB_SOURCE_OPTIONS_COPY,
            true,
            request.getTarget().toPb(),
            BLOB_TARGET_OPTIONS_COMPOSE,
            null);
    StorageRpc.RewriteResponse rpcResponse =
        new StorageRpc.RewriteResponse(rpcRequest, null, 42L, false, "token", 21L);
    EasyMock.expect(storageRpcMock.openRewrite(rpcRequest)).andReturn(rpcResponse);
    EasyMock.replay(storageRpcMock);
    initializeService();
    CopyWriter writer = storage.copy(request);
    assertEquals(42L, writer.getBlobSize());
    assertEquals(21L, writer.getTotalBytesCopied());
    assertTrue(!writer.isDone());
  }

  @Test
  public void testCopyWithEncryptionKey() {
    CopyRequest request =
        Storage.CopyRequest.newBuilder()
            .setSource(BLOB_INFO2.getBlobId())
            .setSourceOptions(BlobSourceOption.decryptionKey(KEY))
            .setTarget(BLOB_INFO1, BlobTargetOption.encryptionKey(BASE64_KEY))
            .build();
    StorageRpc.RewriteRequest rpcRequest =
        new StorageRpc.RewriteRequest(
            request.getSource().toPb(),
            ENCRYPTION_KEY_OPTIONS,
            true,
            request.getTarget().toPb(),
            ENCRYPTION_KEY_OPTIONS,
            null);
    StorageRpc.RewriteResponse rpcResponse =
        new StorageRpc.RewriteResponse(rpcRequest, null, 42L, false, "token", 21L);
    EasyMock.expect(storageRpcMock.openRewrite(rpcRequest)).andReturn(rpcResponse).times(2);
    EasyMock.replay(storageRpcMock);
    initializeService();
    CopyWriter writer = storage.copy(request);
    assertEquals(42L, writer.getBlobSize());
    assertEquals(21L, writer.getTotalBytesCopied());
    assertTrue(!writer.isDone());
    request =
        Storage.CopyRequest.newBuilder()
            .setSource(BLOB_INFO2.getBlobId())
            .setSourceOptions(BlobSourceOption.decryptionKey(BASE64_KEY))
            .setTarget(BLOB_INFO1, BlobTargetOption.encryptionKey(KEY))
            .build();
    writer = storage.copy(request);
    assertEquals(42L, writer.getBlobSize());
    assertEquals(21L, writer.getTotalBytesCopied());
    assertTrue(!writer.isDone());
  }

  @Test
  public void testCopyWithOptionsFromBlobId() {
    CopyRequest request =
        Storage.CopyRequest.newBuilder()
            .setSource(BLOB_INFO1.getBlobId())
            .setSourceOptions(BLOB_SOURCE_GENERATION_FROM_BLOB_ID, BLOB_SOURCE_METAGENERATION)
            .setTarget(BLOB_INFO1, BLOB_TARGET_GENERATION, BLOB_TARGET_METAGENERATION)
            .build();
    StorageRpc.RewriteRequest rpcRequest =
        new StorageRpc.RewriteRequest(
            request.getSource().toPb(),
            BLOB_SOURCE_OPTIONS_COPY,
            true,
            request.getTarget().toPb(),
            BLOB_TARGET_OPTIONS_COMPOSE,
            null);
    StorageRpc.RewriteResponse rpcResponse =
        new StorageRpc.RewriteResponse(rpcRequest, null, 42L, false, "token", 21L);
    EasyMock.expect(storageRpcMock.openRewrite(rpcRequest)).andReturn(rpcResponse);
    EasyMock.replay(storageRpcMock);
    initializeService();
    CopyWriter writer = storage.copy(request);
    assertEquals(42L, writer.getBlobSize());
    assertEquals(21L, writer.getTotalBytesCopied());
    assertTrue(!writer.isDone());
  }

  @Test
  public void testCopyMultipleRequests() {
    CopyRequest request = Storage.CopyRequest.of(BLOB_INFO1.getBlobId(), BLOB_INFO2.getBlobId());
    StorageRpc.RewriteRequest rpcRequest =
        new StorageRpc.RewriteRequest(
            request.getSource().toPb(),
            EMPTY_RPC_OPTIONS,
            false,
            BLOB_INFO2.toPb(),
            EMPTY_RPC_OPTIONS,
            null);
    StorageRpc.RewriteResponse rpcResponse1 =
        new StorageRpc.RewriteResponse(rpcRequest, null, 42L, false, "token", 21L);
    StorageRpc.RewriteResponse rpcResponse2 =
        new StorageRpc.RewriteResponse(rpcRequest, BLOB_INFO1.toPb(), 42L, true, "token", 42L);
    EasyMock.expect(storageRpcMock.openRewrite(rpcRequest)).andReturn(rpcResponse1);
    EasyMock.expect(storageRpcMock.continueRewrite(rpcResponse1)).andReturn(rpcResponse2);
    EasyMock.replay(storageRpcMock);
    initializeService();
    CopyWriter writer = storage.copy(request);
    assertEquals(42L, writer.getBlobSize());
    assertEquals(21L, writer.getTotalBytesCopied());
    assertTrue(!writer.isDone());
    assertEquals(expectedBlob1, writer.getResult());
    assertTrue(writer.isDone());
    assertEquals(42L, writer.getTotalBytesCopied());
    assertEquals(42L, writer.getBlobSize());
  }

  @Test
  public void testReadAllBytes() {
    EasyMock.expect(
            storageRpcMock.load(BlobId.of(BUCKET_NAME1, BLOB_NAME1).toPb(), EMPTY_RPC_OPTIONS))
        .andReturn(BLOB_CONTENT);
    EasyMock.replay(storageRpcMock);
    initializeService();
    byte[] readBytes = storage.readAllBytes(BUCKET_NAME1, BLOB_NAME1);
    assertArrayEquals(BLOB_CONTENT, readBytes);
  }

  @Test
  public void testReadAllBytesWithOptions() {
    EasyMock.expect(
            storageRpcMock.load(BlobId.of(BUCKET_NAME1, BLOB_NAME1).toPb(), BLOB_SOURCE_OPTIONS))
        .andReturn(BLOB_CONTENT);
    EasyMock.replay(storageRpcMock);
    initializeService();
    byte[] readBytes =
        storage.readAllBytes(
            BUCKET_NAME1, BLOB_NAME1, BLOB_SOURCE_GENERATION, BLOB_SOURCE_METAGENERATION);
    assertArrayEquals(BLOB_CONTENT, readBytes);
  }

  @Test
  public void testReadAllBytesWithDecriptionKey() {
    EasyMock.expect(
            storageRpcMock.load(BlobId.of(BUCKET_NAME1, BLOB_NAME1).toPb(), ENCRYPTION_KEY_OPTIONS))
        .andReturn(BLOB_CONTENT)
        .times(2);
    EasyMock.replay(storageRpcMock);
    initializeService();
    byte[] readBytes =
        storage.readAllBytes(BUCKET_NAME1, BLOB_NAME1, BlobSourceOption.decryptionKey(KEY));
    assertArrayEquals(BLOB_CONTENT, readBytes);
    readBytes =
        storage.readAllBytes(BUCKET_NAME1, BLOB_NAME1, BlobSourceOption.decryptionKey(BASE64_KEY));
    assertArrayEquals(BLOB_CONTENT, readBytes);
  }

  @Test
  public void testReadAllBytesFromBlobIdWithOptions() {
    EasyMock.expect(storageRpcMock.load(BLOB_INFO1.getBlobId().toPb(), BLOB_SOURCE_OPTIONS))
        .andReturn(BLOB_CONTENT);
    EasyMock.replay(storageRpcMock);
    initializeService();
    byte[] readBytes =
        storage.readAllBytes(
            BLOB_INFO1.getBlobId(),
            BLOB_SOURCE_GENERATION_FROM_BLOB_ID,
            BLOB_SOURCE_METAGENERATION);
    assertArrayEquals(BLOB_CONTENT, readBytes);
  }

  @Test
  public void testReadAllBytesFromBlobIdWithDecriptionKey() {
    EasyMock.expect(storageRpcMock.load(BLOB_INFO1.getBlobId().toPb(), ENCRYPTION_KEY_OPTIONS))
        .andReturn(BLOB_CONTENT)
        .times(2);
    EasyMock.replay(storageRpcMock);
    initializeService();
    byte[] readBytes =
        storage.readAllBytes(BLOB_INFO1.getBlobId(), BlobSourceOption.decryptionKey(KEY));
    assertArrayEquals(BLOB_CONTENT, readBytes);
    readBytes =
        storage.readAllBytes(BLOB_INFO1.getBlobId(), BlobSourceOption.decryptionKey(BASE64_KEY));
    assertArrayEquals(BLOB_CONTENT, readBytes);
  }

  @Test
  public void testBatch() {
    RpcBatch batchMock = EasyMock.mock(RpcBatch.class);
    EasyMock.expect(storageRpcMock.createBatch()).andReturn(batchMock);
    EasyMock.replay(batchMock, storageRpcMock);
    initializeService();
    StorageBatch batch = storage.batch();
    assertSame(options, batch.getOptions());
    assertSame(storageRpcMock, batch.getStorageRpc());
    assertSame(batchMock, batch.getBatch());
    EasyMock.verify(batchMock);
  }

  @Test
  public void testReader() {
    EasyMock.replay(storageRpcMock);
    initializeService();
    ReadChannel channel = storage.reader(BUCKET_NAME1, BLOB_NAME1);
    assertNotNull(channel);
    assertTrue(channel.isOpen());
  }

  @Test
  public void testReaderWithOptions() throws IOException {
    byte[] result = new byte[DEFAULT_CHUNK_SIZE];
    EasyMock.expect(
            storageRpcMock.read(BLOB_INFO2.toPb(), BLOB_SOURCE_OPTIONS, 0, DEFAULT_CHUNK_SIZE))
        .andReturn(StorageRpc.Tuple.of("etag", result));
    EasyMock.replay(storageRpcMock);
    initializeService();
    ReadChannel channel =
        storage.reader(
            BUCKET_NAME1, BLOB_NAME2, BLOB_SOURCE_GENERATION, BLOB_SOURCE_METAGENERATION);
    assertNotNull(channel);
    assertTrue(channel.isOpen());
    channel.read(ByteBuffer.allocate(42));
  }

  @Test
  public void testReaderWithDecryptionKey() throws IOException {
    byte[] result = new byte[DEFAULT_CHUNK_SIZE];
    EasyMock.expect(
            storageRpcMock.read(BLOB_INFO2.toPb(), ENCRYPTION_KEY_OPTIONS, 0, DEFAULT_CHUNK_SIZE))
        .andReturn(StorageRpc.Tuple.of("etag", result))
        .times(2);
    EasyMock.replay(storageRpcMock);
    initializeService();
    ReadChannel channel =
        storage.reader(BUCKET_NAME1, BLOB_NAME2, BlobSourceOption.decryptionKey(KEY));
    assertNotNull(channel);
    assertTrue(channel.isOpen());
    channel.read(ByteBuffer.allocate(42));
    channel = storage.reader(BUCKET_NAME1, BLOB_NAME2, BlobSourceOption.decryptionKey(BASE64_KEY));
    assertNotNull(channel);
    assertTrue(channel.isOpen());
    channel.read(ByteBuffer.allocate(42));
  }

  @Test
  public void testReaderWithOptionsFromBlobId() throws IOException {
    byte[] result = new byte[DEFAULT_CHUNK_SIZE];
    EasyMock.expect(
            storageRpcMock.read(
                BLOB_INFO1.getBlobId().toPb(), BLOB_SOURCE_OPTIONS, 0, DEFAULT_CHUNK_SIZE))
        .andReturn(StorageRpc.Tuple.of("etag", result));
    EasyMock.replay(storageRpcMock);
    initializeService();
    ReadChannel channel =
        storage.reader(
            BLOB_INFO1.getBlobId(),
            BLOB_SOURCE_GENERATION_FROM_BLOB_ID,
            BLOB_SOURCE_METAGENERATION);
    assertNotNull(channel);
    assertTrue(channel.isOpen());
    channel.read(ByteBuffer.allocate(42));
  }

  @Test
  public void testWriter() {
    BlobInfo.Builder infoBuilder = BLOB_INFO1.toBuilder();
    BlobInfo infoWithHashes = infoBuilder.setMd5(CONTENT_MD5).setCrc32c(CONTENT_CRC32C).build();
    BlobInfo infoWithoutHashes = infoBuilder.setMd5(null).setCrc32c(null).build();
    EasyMock.expect(storageRpcMock.open(infoWithoutHashes.toPb(), EMPTY_RPC_OPTIONS))
        .andReturn("upload-id");
    EasyMock.replay(storageRpcMock);
    initializeService();
    WriteChannel channel = storage.writer(infoWithHashes);
    assertNotNull(channel);
    assertTrue(channel.isOpen());
  }

  @Test
  public void testWriterWithOptions() {
    BlobInfo info = BLOB_INFO1.toBuilder().setMd5(CONTENT_MD5).setCrc32c(CONTENT_CRC32C).build();
    EasyMock.expect(storageRpcMock.open(info.toPb(), BLOB_TARGET_OPTIONS_CREATE))
        .andReturn("upload-id");
    EasyMock.replay(storageRpcMock);
    initializeService();
    WriteChannel channel =
        storage.writer(
            info,
            BLOB_WRITE_METAGENERATION,
            BLOB_WRITE_NOT_EXIST,
            BLOB_WRITE_PREDEFINED_ACL,
            BLOB_WRITE_CRC2C,
            BLOB_WRITE_MD5_HASH);
    assertNotNull(channel);
    assertTrue(channel.isOpen());
  }

  @Test
  public void testWriterWithEncryptionKey() {
    BlobInfo info = BLOB_INFO1.toBuilder().setMd5(null).setCrc32c(null).build();
    EasyMock.expect(storageRpcMock.open(info.toPb(), ENCRYPTION_KEY_OPTIONS))
        .andReturn("upload-id")
        .times(2);
    EasyMock.replay(storageRpcMock);
    initializeService();
    WriteChannel channel = storage.writer(info, BlobWriteOption.encryptionKey(KEY));
    assertNotNull(channel);
    assertTrue(channel.isOpen());
    channel = storage.writer(info, BlobWriteOption.encryptionKey(BASE64_KEY));
    assertNotNull(channel);
    assertTrue(channel.isOpen());
  }

  @Test
  public void testSignUrl()
      throws NoSuchAlgorithmException, InvalidKeyException, SignatureException,
          UnsupportedEncodingException {
    EasyMock.replay(storageRpcMock);
    ServiceAccountCredentials credentials =
        new ServiceAccountCredentials(null, ACCOUNT, privateKey, null, null);
    storage = options.toBuilder().setCredentials(credentials).build().getService();
    URL url = storage.signUrl(BLOB_INFO1, 14, TimeUnit.DAYS);
    String stringUrl = url.toString();
    String expectedUrl =
        new StringBuilder("https://storage.googleapis.com/")
            .append(BUCKET_NAME1)
            .append('/')
            .append(BLOB_NAME1)
            .append("?GoogleAccessId=")
            .append(ACCOUNT)
            .append("&Expires=")
            .append(42L + 1209600)
            .append("&Signature=")
            .toString();
    assertTrue(stringUrl.startsWith(expectedUrl));
    String signature = stringUrl.substring(expectedUrl.length());

    StringBuilder signedMessageBuilder = new StringBuilder();
    signedMessageBuilder
        .append(HttpMethod.GET)
        .append("\n\n\n")
        .append(42L + 1209600)
        .append("\n/")
        .append(BUCKET_NAME1)
        .append('/')
        .append(BLOB_NAME1);

    Signature signer = Signature.getInstance("SHA256withRSA");
    signer.initVerify(publicKey);
    signer.update(signedMessageBuilder.toString().getBytes(UTF_8));
    assertTrue(
        signer.verify(BaseEncoding.base64().decode(URLDecoder.decode(signature, UTF_8.name()))));
  }

  @Test
  public void testSignUrlLeadingSlash()
      throws NoSuchAlgorithmException, InvalidKeyException, SignatureException,
          UnsupportedEncodingException {
    String blobName = "/b1";
    EasyMock.replay(storageRpcMock);
    ServiceAccountCredentials credentials =
        new ServiceAccountCredentials(null, ACCOUNT, privateKey, null, null);
    storage = options.toBuilder().setCredentials(credentials).build().getService();
    URL url =
        storage.signUrl(BlobInfo.newBuilder(BUCKET_NAME1, blobName).build(), 14, TimeUnit.DAYS);
    String escapedBlobName = UrlEscapers.urlFragmentEscaper().escape(blobName);
    String stringUrl = url.toString();
    String expectedUrl =
        new StringBuilder("https://storage.googleapis.com/")
            .append(BUCKET_NAME1)
            .append(escapedBlobName)
            .append("?GoogleAccessId=")
            .append(ACCOUNT)
            .append("&Expires=")
            .append(42L + 1209600)
            .append("&Signature=")
            .toString();
    assertTrue(stringUrl.startsWith(expectedUrl));
    String signature = stringUrl.substring(expectedUrl.length());

    StringBuilder signedMessageBuilder = new StringBuilder();
    signedMessageBuilder
        .append(HttpMethod.GET)
        .append("\n\n\n")
        .append(42L + 1209600)
        .append("\n/")
        .append(BUCKET_NAME1)
        .append(escapedBlobName);

    Signature signer = Signature.getInstance("SHA256withRSA");
    signer.initVerify(publicKey);
    signer.update(signedMessageBuilder.toString().getBytes(UTF_8));
    assertTrue(
        signer.verify(BaseEncoding.base64().decode(URLDecoder.decode(signature, UTF_8.name()))));
  }

  @Test
  public void testSignUrlWithOptions()
      throws NoSuchAlgorithmException, InvalidKeyException, SignatureException,
          UnsupportedEncodingException {
    EasyMock.replay(storageRpcMock);
    ServiceAccountCredentials credentials =
        new ServiceAccountCredentials(null, ACCOUNT, privateKey, null, null);
    storage = options.toBuilder().setCredentials(credentials).build().getService();
    URL url =
        storage.signUrl(
            BLOB_INFO1,
            14,
            TimeUnit.DAYS,
            Storage.SignUrlOption.httpMethod(HttpMethod.POST),
            Storage.SignUrlOption.withContentType(),
            Storage.SignUrlOption.withMd5());
    String stringUrl = url.toString();
    String expectedUrl =
        new StringBuilder("https://storage.googleapis.com/")
            .append(BUCKET_NAME1)
            .append('/')
            .append(BLOB_NAME1)
            .append("?GoogleAccessId=")
            .append(ACCOUNT)
            .append("&Expires=")
            .append(42L + 1209600)
            .append("&Signature=")
            .toString();
    assertTrue(stringUrl.startsWith(expectedUrl));
    String signature = stringUrl.substring(expectedUrl.length());

    StringBuilder signedMessageBuilder = new StringBuilder();
    signedMessageBuilder
        .append(HttpMethod.POST)
        .append('\n')
        .append(BLOB_INFO1.getMd5())
        .append('\n')
        .append(BLOB_INFO1.getContentType())
        .append('\n')
        .append(42L + 1209600)
        .append("\n/")
        .append(BUCKET_NAME1)
        .append('/')
        .append(BLOB_NAME1);

    Signature signer = Signature.getInstance("SHA256withRSA");
    signer.initVerify(publicKey);
    signer.update(signedMessageBuilder.toString().getBytes(UTF_8));
    assertTrue(
        signer.verify(BaseEncoding.base64().decode(URLDecoder.decode(signature, UTF_8.name()))));
  }

  @Test
  public void testSignUrlForBlobWithSpecialChars()
      throws NoSuchAlgorithmException, InvalidKeyException, SignatureException,
          UnsupportedEncodingException {
    // List of chars under test were taken from
    // https://en.wikipedia.org/wiki/Percent-encoding#Percent-encoding_reserved_characters
    char[] specialChars =
        new char[] {
          '!', '#', '$', '&', '\'', '(', ')', '*', '+', ',', ':', ';', '=', '?', '@', '[', ']'
        };
    EasyMock.replay(storageRpcMock);
    ServiceAccountCredentials credentials =
        new ServiceAccountCredentials(null, ACCOUNT, privateKey, null, null);
    storage = options.toBuilder().setCredentials(credentials).build().getService();

    for (char specialChar : specialChars) {
      String blobName = "/a" + specialChar + "b";
      URL url =
          storage.signUrl(BlobInfo.newBuilder(BUCKET_NAME1, blobName).build(), 14, TimeUnit.DAYS);
      String escapedBlobName =
          UrlEscapers.urlFragmentEscaper().escape(blobName).replace("?", "%3F");
      String stringUrl = url.toString();
      String expectedUrl =
          new StringBuilder("https://storage.googleapis.com/")
              .append(BUCKET_NAME1)
              .append(escapedBlobName)
              .append("?GoogleAccessId=")
              .append(ACCOUNT)
              .append("&Expires=")
              .append(42L + 1209600)
              .append("&Signature=")
              .toString();
      assertTrue(stringUrl.startsWith(expectedUrl));
      String signature = stringUrl.substring(expectedUrl.length());

      StringBuilder signedMessageBuilder = new StringBuilder();
      signedMessageBuilder
          .append(HttpMethod.GET)
          .append("\n\n\n")
          .append(42L + 1209600)
          .append("\n/")
          .append(BUCKET_NAME1)
          .append(escapedBlobName);

      Signature signer = Signature.getInstance("SHA256withRSA");
      signer.initVerify(publicKey);
      signer.update(signedMessageBuilder.toString().getBytes(UTF_8));
      assertTrue(
          signer.verify(BaseEncoding.base64().decode(URLDecoder.decode(signature, UTF_8.name()))));
    }
  }

  @Test
  public void testSignUrlForBlobWithSlashes()
      throws NoSuchAlgorithmException, InvalidKeyException, SignatureException,
          UnsupportedEncodingException {
    EasyMock.replay(storageRpcMock);
    ServiceAccountCredentials credentials =
        new ServiceAccountCredentials(null, ACCOUNT, privateKey, null, null);
    storage = options.toBuilder().setCredentials(credentials).build().getService();

    String blobName = "/foo/bar/baz #%20other cool stuff.txt";
    URL url =
        storage.signUrl(BlobInfo.newBuilder(BUCKET_NAME1, blobName).build(), 14, TimeUnit.DAYS);
    String escapedBlobName = UrlEscapers.urlFragmentEscaper().escape(blobName);
    String stringUrl = url.toString();
    String expectedUrl =
        new StringBuilder("https://storage.googleapis.com/")
            .append(BUCKET_NAME1)
            .append(escapedBlobName)
            .append("?GoogleAccessId=")
            .append(ACCOUNT)
            .append("&Expires=")
            .append(42L + 1209600)
            .append("&Signature=")
            .toString();
    assertTrue(stringUrl.startsWith(expectedUrl));
    String signature = stringUrl.substring(expectedUrl.length());

    StringBuilder signedMessageBuilder = new StringBuilder();
    signedMessageBuilder
        .append(HttpMethod.GET)
        .append("\n\n\n")
        .append(42L + 1209600)
        .append("\n/")
        .append(BUCKET_NAME1)
        .append(escapedBlobName);

    Signature signer = Signature.getInstance("SHA256withRSA");
    signer.initVerify(publicKey);
    signer.update(signedMessageBuilder.toString().getBytes(UTF_8));
    assertTrue(
        signer.verify(BaseEncoding.base64().decode(URLDecoder.decode(signature, UTF_8.name()))));
  }

  @Test
  public void testGetAllArray() {
    BlobId blobId1 = BlobId.of(BUCKET_NAME1, BLOB_NAME1);
    BlobId blobId2 = BlobId.of(BUCKET_NAME1, BLOB_NAME2);
    RpcBatch batchMock = EasyMock.createMock(RpcBatch.class);
    Capture<RpcBatch.Callback<StorageObject>> callback1 = Capture.newInstance();
    Capture<RpcBatch.Callback<StorageObject>> callback2 = Capture.newInstance();
    batchMock.addGet(
        EasyMock.eq(blobId1.toPb()),
        EasyMock.capture(callback1),
        EasyMock.eq(ImmutableMap.<StorageRpc.Option, Object>of()));
    batchMock.addGet(
        EasyMock.eq(blobId2.toPb()),
        EasyMock.capture(callback2),
        EasyMock.eq(ImmutableMap.<StorageRpc.Option, Object>of()));
    EasyMock.expect(storageRpcMock.createBatch()).andReturn(batchMock);
    batchMock.submit();
    EasyMock.replay(storageRpcMock, batchMock);
    initializeService();
    List<Blob> resultBlobs = storage.get(blobId1, blobId2);
    callback1.getValue().onSuccess(BLOB_INFO1.toPb());
    callback2.getValue().onFailure(new GoogleJsonError());
    assertEquals(2, resultBlobs.size());
    assertEquals(new Blob(storage, new BlobInfo.BuilderImpl(BLOB_INFO1)), resultBlobs.get(0));
    assertNull(resultBlobs.get(1));
    EasyMock.verify(batchMock);
  }

  @Test
  public void testGetAllArrayIterable() {
    BlobId blobId1 = BlobId.of(BUCKET_NAME1, BLOB_NAME1);
    BlobId blobId2 = BlobId.of(BUCKET_NAME1, BLOB_NAME2);
    RpcBatch batchMock = EasyMock.createMock(RpcBatch.class);
    Capture<RpcBatch.Callback<StorageObject>> callback1 = Capture.newInstance();
    Capture<RpcBatch.Callback<StorageObject>> callback2 = Capture.newInstance();
    batchMock.addGet(
        EasyMock.eq(blobId1.toPb()),
        EasyMock.capture(callback1),
        EasyMock.eq(ImmutableMap.<StorageRpc.Option, Object>of()));
    batchMock.addGet(
        EasyMock.eq(blobId2.toPb()),
        EasyMock.capture(callback2),
        EasyMock.eq(ImmutableMap.<StorageRpc.Option, Object>of()));
    EasyMock.expect(storageRpcMock.createBatch()).andReturn(batchMock);
    batchMock.submit();
    EasyMock.replay(storageRpcMock, batchMock);
    initializeService();
    List<Blob> resultBlobs = storage.get(ImmutableList.of(blobId1, blobId2));
    callback1.getValue().onSuccess(BLOB_INFO1.toPb());
    callback2.getValue().onFailure(new GoogleJsonError());
    assertEquals(2, resultBlobs.size());
    assertEquals(new Blob(storage, new BlobInfo.BuilderImpl(BLOB_INFO1)), resultBlobs.get(0));
    assertNull(resultBlobs.get(1));
    EasyMock.verify(batchMock);
  }

  @Test
  public void testDeleteAllArray() {
    BlobId blobId1 = BlobId.of(BUCKET_NAME1, BLOB_NAME1);
    BlobId blobId2 = BlobId.of(BUCKET_NAME1, BLOB_NAME2);
    RpcBatch batchMock = EasyMock.createMock(RpcBatch.class);
    Capture<RpcBatch.Callback<Void>> callback1 = Capture.newInstance();
    Capture<RpcBatch.Callback<Void>> callback2 = Capture.newInstance();
    batchMock.addDelete(
        EasyMock.eq(blobId1.toPb()),
        EasyMock.capture(callback1),
        EasyMock.eq(ImmutableMap.<StorageRpc.Option, Object>of()));
    batchMock.addDelete(
        EasyMock.eq(blobId2.toPb()),
        EasyMock.capture(callback2),
        EasyMock.eq(ImmutableMap.<StorageRpc.Option, Object>of()));
    EasyMock.expect(storageRpcMock.createBatch()).andReturn(batchMock);
    batchMock.submit();
    EasyMock.replay(storageRpcMock, batchMock);
    initializeService();
    List<Boolean> result = storage.delete(blobId1, blobId2);
    callback1.getValue().onSuccess(null);
    callback2.getValue().onFailure(new GoogleJsonError());
    assertEquals(2, result.size());
    assertTrue(result.get(0));
    assertFalse(result.get(1));
    EasyMock.verify(batchMock);
  }

  @Test
  public void testDeleteAllIterable() {
    BlobId blobId1 = BlobId.of(BUCKET_NAME1, BLOB_NAME1);
    BlobId blobId2 = BlobId.of(BUCKET_NAME1, BLOB_NAME2);
    RpcBatch batchMock = EasyMock.createMock(RpcBatch.class);
    Capture<RpcBatch.Callback<Void>> callback1 = Capture.newInstance();
    Capture<RpcBatch.Callback<Void>> callback2 = Capture.newInstance();
    batchMock.addDelete(
        EasyMock.eq(blobId1.toPb()),
        EasyMock.capture(callback1),
        EasyMock.eq(ImmutableMap.<StorageRpc.Option, Object>of()));
    batchMock.addDelete(
        EasyMock.eq(blobId2.toPb()),
        EasyMock.capture(callback2),
        EasyMock.eq(ImmutableMap.<StorageRpc.Option, Object>of()));
    EasyMock.expect(storageRpcMock.createBatch()).andReturn(batchMock);
    batchMock.submit();
    EasyMock.replay(storageRpcMock, batchMock);
    initializeService();
    List<Boolean> result = storage.delete(blobId1, blobId2);
    callback1.getValue().onSuccess(null);
    callback2.getValue().onFailure(new GoogleJsonError());
    assertEquals(2, result.size());
    assertTrue(result.get(0));
    assertFalse(result.get(1));
    EasyMock.verify(batchMock);
  }

  @Test
  public void testUpdateAllArray() {
    RpcBatch batchMock = EasyMock.createMock(RpcBatch.class);
    Capture<RpcBatch.Callback<StorageObject>> callback1 = Capture.newInstance();
    Capture<RpcBatch.Callback<StorageObject>> callback2 = Capture.newInstance();
    batchMock.addPatch(
        EasyMock.eq(BLOB_INFO1.toPb()),
        EasyMock.capture(callback1),
        EasyMock.eq(ImmutableMap.<StorageRpc.Option, Object>of()));
    batchMock.addPatch(
        EasyMock.eq(BLOB_INFO2.toPb()),
        EasyMock.capture(callback2),
        EasyMock.eq(ImmutableMap.<StorageRpc.Option, Object>of()));
    EasyMock.expect(storageRpcMock.createBatch()).andReturn(batchMock);
    batchMock.submit();
    EasyMock.replay(storageRpcMock, batchMock);
    initializeService();
    List<Blob> resultBlobs = storage.update(BLOB_INFO1, BLOB_INFO2);
    callback1.getValue().onSuccess(BLOB_INFO1.toPb());
    callback2.getValue().onFailure(new GoogleJsonError());
    assertEquals(2, resultBlobs.size());
    assertEquals(new Blob(storage, new BlobInfo.BuilderImpl(BLOB_INFO1)), resultBlobs.get(0));
    assertNull(resultBlobs.get(1));
    EasyMock.verify(batchMock);
  }

  @Test
  public void testUpdateAllIterable() {
    RpcBatch batchMock = EasyMock.createMock(RpcBatch.class);
    Capture<RpcBatch.Callback<StorageObject>> callback1 = Capture.newInstance();
    Capture<RpcBatch.Callback<StorageObject>> callback2 = Capture.newInstance();
    batchMock.addPatch(
        EasyMock.eq(BLOB_INFO1.toPb()),
        EasyMock.capture(callback1),
        EasyMock.eq(ImmutableMap.<StorageRpc.Option, Object>of()));
    batchMock.addPatch(
        EasyMock.eq(BLOB_INFO2.toPb()),
        EasyMock.capture(callback2),
        EasyMock.eq(ImmutableMap.<StorageRpc.Option, Object>of()));
    EasyMock.expect(storageRpcMock.createBatch()).andReturn(batchMock);
    batchMock.submit();
    EasyMock.replay(storageRpcMock, batchMock);
    initializeService();
    List<Blob> resultBlobs = storage.update(ImmutableList.of(BLOB_INFO1, BLOB_INFO2));
    callback1.getValue().onSuccess(BLOB_INFO1.toPb());
    callback2.getValue().onFailure(new GoogleJsonError());
    assertEquals(2, resultBlobs.size());
    assertEquals(new Blob(storage, new BlobInfo.BuilderImpl(BLOB_INFO1)), resultBlobs.get(0));
    assertNull(resultBlobs.get(1));
    EasyMock.verify(batchMock);
  }

  @Test
  public void testGetBucketAcl() {
    EasyMock.expect(storageRpcMock.getAcl(BUCKET_NAME1, "allAuthenticatedUsers"))
        .andReturn(ACL.toBucketPb());
    EasyMock.replay(storageRpcMock);
    initializeService();
    Acl acl = storage.getAcl(BUCKET_NAME1, User.ofAllAuthenticatedUsers());
    assertEquals(ACL, acl);
  }

  @Test
  public void testGetBucketAclNull() {
    EasyMock.expect(storageRpcMock.getAcl(BUCKET_NAME1, "allAuthenticatedUsers")).andReturn(null);
    EasyMock.replay(storageRpcMock);
    initializeService();
    assertNull(storage.getAcl(BUCKET_NAME1, User.ofAllAuthenticatedUsers()));
  }

  @Test
  public void testDeleteBucketAcl() {
    EasyMock.expect(storageRpcMock.deleteAcl(BUCKET_NAME1, "allAuthenticatedUsers"))
        .andReturn(true);
    EasyMock.replay(storageRpcMock);
    initializeService();
    assertTrue(storage.deleteAcl(BUCKET_NAME1, User.ofAllAuthenticatedUsers()));
  }

  @Test
  public void testCreateBucketAcl() {
    Acl returnedAcl = ACL.toBuilder().setEtag("ETAG").setId("ID").build();
    EasyMock.expect(storageRpcMock.createAcl(ACL.toBucketPb().setBucket(BUCKET_NAME1)))
        .andReturn(returnedAcl.toBucketPb());
    EasyMock.replay(storageRpcMock);
    initializeService();
    Acl acl = storage.createAcl(BUCKET_NAME1, ACL);
    assertEquals(returnedAcl, acl);
  }

  @Test
  public void testUpdateBucketAcl() {
    Acl returnedAcl = ACL.toBuilder().setEtag("ETAG").setId("ID").build();
    EasyMock.expect(storageRpcMock.patchAcl(ACL.toBucketPb().setBucket(BUCKET_NAME1)))
        .andReturn(returnedAcl.toBucketPb());
    EasyMock.replay(storageRpcMock);
    initializeService();
    Acl acl = storage.updateAcl(BUCKET_NAME1, ACL);
    assertEquals(returnedAcl, acl);
  }

  @Test
  public void testListBucketAcl() {
    EasyMock.expect(storageRpcMock.listAcls(BUCKET_NAME1))
        .andReturn(ImmutableList.of(ACL.toBucketPb(), OTHER_ACL.toBucketPb()));
    EasyMock.replay(storageRpcMock);
    initializeService();
    List<Acl> acls = storage.listAcls(BUCKET_NAME1);
    assertEquals(ImmutableList.of(ACL, OTHER_ACL), acls);
  }

  @Test
  public void testGetDefaultBucketAcl() {
    EasyMock.expect(storageRpcMock.getDefaultAcl(BUCKET_NAME1, "allAuthenticatedUsers"))
        .andReturn(ACL.toObjectPb());
    EasyMock.replay(storageRpcMock);
    initializeService();
    Acl acl = storage.getDefaultAcl(BUCKET_NAME1, User.ofAllAuthenticatedUsers());
    assertEquals(ACL, acl);
  }

  @Test
  public void testGetDefaultBucketAclNull() {
    EasyMock.expect(storageRpcMock.getDefaultAcl(BUCKET_NAME1, "allAuthenticatedUsers"))
        .andReturn(null);
    EasyMock.replay(storageRpcMock);
    initializeService();
    assertNull(storage.getDefaultAcl(BUCKET_NAME1, User.ofAllAuthenticatedUsers()));
  }

  @Test
  public void testDeleteDefaultBucketAcl() {
    EasyMock.expect(storageRpcMock.deleteDefaultAcl(BUCKET_NAME1, "allAuthenticatedUsers"))
        .andReturn(true);
    EasyMock.replay(storageRpcMock);
    initializeService();
    assertTrue(storage.deleteDefaultAcl(BUCKET_NAME1, User.ofAllAuthenticatedUsers()));
  }

  @Test
  public void testCreateDefaultBucketAcl() {
    Acl returnedAcl = ACL.toBuilder().setEtag("ETAG").setId("ID").build();
    EasyMock.expect(storageRpcMock.createDefaultAcl(ACL.toObjectPb().setBucket(BUCKET_NAME1)))
        .andReturn(returnedAcl.toObjectPb());
    EasyMock.replay(storageRpcMock);
    initializeService();
    Acl acl = storage.createDefaultAcl(BUCKET_NAME1, ACL);
    assertEquals(returnedAcl, acl);
  }

  @Test
  public void testUpdateDefaultBucketAcl() {
    Acl returnedAcl = ACL.toBuilder().setEtag("ETAG").setId("ID").build();
    EasyMock.expect(storageRpcMock.patchDefaultAcl(ACL.toObjectPb().setBucket(BUCKET_NAME1)))
        .andReturn(returnedAcl.toObjectPb());
    EasyMock.replay(storageRpcMock);
    initializeService();
    Acl acl = storage.updateDefaultAcl(BUCKET_NAME1, ACL);
    assertEquals(returnedAcl, acl);
  }

  @Test
  public void testListDefaultBucketAcl() {
    EasyMock.expect(storageRpcMock.listDefaultAcls(BUCKET_NAME1))
        .andReturn(ImmutableList.of(ACL.toObjectPb(), OTHER_ACL.toObjectPb()));
    EasyMock.replay(storageRpcMock);
    initializeService();
    List<Acl> acls = storage.listDefaultAcls(BUCKET_NAME1);
    assertEquals(ImmutableList.of(ACL, OTHER_ACL), acls);
  }

  @Test
  public void testGetBlobAcl() {
    BlobId blobId = BlobId.of(BUCKET_NAME1, BLOB_NAME1, 42L);
    EasyMock.expect(storageRpcMock.getAcl(BUCKET_NAME1, BLOB_NAME1, 42L, "allAuthenticatedUsers"))
        .andReturn(ACL.toObjectPb());
    EasyMock.replay(storageRpcMock);
    initializeService();
    Acl acl = storage.getAcl(blobId, User.ofAllAuthenticatedUsers());
    assertEquals(ACL, acl);
  }

  @Test
  public void testGetBlobAclNull() {
    BlobId blobId = BlobId.of(BUCKET_NAME1, BLOB_NAME1, 42L);
    EasyMock.expect(storageRpcMock.getAcl(BUCKET_NAME1, BLOB_NAME1, 42L, "allAuthenticatedUsers"))
        .andReturn(null);
    EasyMock.replay(storageRpcMock);
    initializeService();
    assertNull(storage.getAcl(blobId, User.ofAllAuthenticatedUsers()));
  }

  @Test
  public void testDeleteBlobAcl() {
    BlobId blobId = BlobId.of(BUCKET_NAME1, BLOB_NAME1, 42L);
    EasyMock.expect(
            storageRpcMock.deleteAcl(BUCKET_NAME1, BLOB_NAME1, 42L, "allAuthenticatedUsers"))
        .andReturn(true);
    EasyMock.replay(storageRpcMock);
    initializeService();
    assertTrue(storage.deleteAcl(blobId, User.ofAllAuthenticatedUsers()));
  }

  @Test
  public void testCreateBlobAcl() {
    BlobId blobId = BlobId.of(BUCKET_NAME1, BLOB_NAME1, 42L);
    Acl returnedAcl = ACL.toBuilder().setEtag("ETAG").setId("ID").build();
    EasyMock.expect(
            storageRpcMock.createAcl(
                ACL.toObjectPb().setBucket(BUCKET_NAME1).setObject(BLOB_NAME1).setGeneration(42L)))
        .andReturn(returnedAcl.toObjectPb());
    EasyMock.replay(storageRpcMock);
    initializeService();
    Acl acl = storage.createAcl(blobId, ACL);
    assertEquals(returnedAcl, acl);
  }

  @Test
  public void testUpdateBlobAcl() {
    BlobId blobId = BlobId.of(BUCKET_NAME1, BLOB_NAME1, 42L);
    Acl returnedAcl = ACL.toBuilder().setEtag("ETAG").setId("ID").build();
    EasyMock.expect(
            storageRpcMock.patchAcl(
                ACL.toObjectPb().setBucket(BUCKET_NAME1).setObject(BLOB_NAME1).setGeneration(42L)))
        .andReturn(returnedAcl.toObjectPb());
    EasyMock.replay(storageRpcMock);
    initializeService();
    Acl acl = storage.updateAcl(blobId, ACL);
    assertEquals(returnedAcl, acl);
  }

  @Test
  public void testListBlobAcl() {
    BlobId blobId = BlobId.of(BUCKET_NAME1, BLOB_NAME1, 42L);
    EasyMock.expect(storageRpcMock.listAcls(BUCKET_NAME1, BLOB_NAME1, 42L))
        .andReturn(ImmutableList.of(ACL.toObjectPb(), OTHER_ACL.toObjectPb()));
    EasyMock.replay(storageRpcMock);
    initializeService();
    List<Acl> acls = storage.listAcls(blobId);
    assertEquals(ImmutableList.of(ACL, OTHER_ACL), acls);
  }

  @Test
  public void testGetIamPolicy() {
    EasyMock.expect(storageRpcMock.getIamPolicy(BUCKET_NAME1)).andReturn(API_POLICY1);
    EasyMock.replay(storageRpcMock);
    initializeService();
    assertEquals(LIB_POLICY1, storage.getIamPolicy(BUCKET_NAME1));
  }

  @Test
  public void testSetIamPolicy() {
    com.google.api.services.storage.model.Policy preCommitApiPolicy =
        new com.google.api.services.storage.model.Policy()
            .setBindings(ImmutableList.of(
                new Bindings()
                    .setMembers(ImmutableList.of("allUsers"))
                    .setRole("roles/storage.objectViewer"),
                new Bindings()
                    .setMembers(
                        ImmutableList.of(
                            "user:test1@gmail.com",
                            "user:test2@gmail.com"))
                    .setRole("roles/storage.objectAdmin"),
                new Bindings()
                    .setMembers(ImmutableList.of("group:test-group@gmail.com"))
                    .setRole("roles/storage.admin")))
            .setEtag(POLICY_ETAG1);
    // postCommitApiPolicy is identical but for the etag, which has been updated.
    com.google.api.services.storage.model.Policy postCommitApiPolicy =
        new com.google.api.services.storage.model.Policy()
            .setBindings(ImmutableList.of(
                new Bindings()
                    .setMembers(ImmutableList.of("allUsers"))
                    .setRole("roles/storage.objectViewer"),
                new Bindings()
                    .setMembers(
                        ImmutableList.of(
                            "user:test1@gmail.com",
                            "user:test2@gmail.com"))
                    .setRole("roles/storage.objectAdmin"),
                new Bindings()
                    .setMembers(ImmutableList.of("group:test-group@gmail.com"))
                    .setRole("roles/storage.admin")))
            .setEtag(POLICY_ETAG2);
    Policy postCommitLibPolicy =
        Policy.newBuilder()
            .addIdentity(StorageRoles.objectViewer(), Identity.allUsers())
            .addIdentity(
                StorageRoles.objectAdmin(),
                Identity.user("test1@gmail.com"),
                Identity.user("test2@gmail.com"))
            .addIdentity(StorageRoles.admin(), Identity.group("test-group@gmail.com"))
            .setEtag(POLICY_ETAG2)
            .build();

    EasyMock.expect(storageRpcMock.getIamPolicy(BUCKET_NAME1)).andReturn(API_POLICY1);
    EasyMock.expect(
          storageRpcMock.setIamPolicy(
              eq(BUCKET_NAME1),
              eqApiPolicy(preCommitApiPolicy)))
        .andReturn(postCommitApiPolicy);
    EasyMock.replay(storageRpcMock);
    initializeService();

    Policy currentPolicy = storage.getIamPolicy(BUCKET_NAME1);
    Policy updatedPolicy =
        storage.setIamPolicy(
            BUCKET_NAME1,
            currentPolicy.toBuilder()
                .addIdentity(StorageRoles.admin(), Identity.group("test-group@gmail.com"))
                .build());
    assertEquals(updatedPolicy, postCommitLibPolicy);
  }

  @Test
  public void testTestIamPermissionsNull() {
    ImmutableList<Boolean> expectedPermissions = ImmutableList.of(false, false, false);
    ImmutableList<String> checkedPermissions =
        ImmutableList.of("storage.buckets.get", "storage.buckets.getIamPolicy", "storage.objects.list");

    EasyMock.expect(storageRpcMock.testIamPermissions(BUCKET_NAME1, checkedPermissions))
        .andReturn(new TestIamPermissionsResponse());
    EasyMock.replay(storageRpcMock);
    initializeService();
    assertEquals(expectedPermissions, storage.testIamPermissions(BUCKET_NAME1, checkedPermissions));
  }

  @Test
  public void testTestIamPermissionsNonNull() {
    ImmutableList<Boolean> expectedPermissions = ImmutableList.of(true, false, true);
    ImmutableList<String> checkedPermissions =
        ImmutableList.of("storage.buckets.get", "storage.buckets.getIamPolicy", "storage.objects.list");

    EasyMock.expect(storageRpcMock.testIamPermissions(BUCKET_NAME1, checkedPermissions))
        .andReturn(new TestIamPermissionsResponse()
            .setPermissions(ImmutableList.of("storage.objects.list", "storage.buckets.get")));
    EasyMock.replay(storageRpcMock);
    initializeService();
    assertEquals(expectedPermissions, storage.testIamPermissions(BUCKET_NAME1, checkedPermissions));
  }

  @Test
  public void testRetryableException() {
    BlobId blob = BlobId.of(BUCKET_NAME1, BLOB_NAME1);
    EasyMock.expect(storageRpcMock.get(blob.toPb(), EMPTY_RPC_OPTIONS))
        .andThrow(new StorageException(500, "internalError"))
        .andReturn(BLOB_INFO1.toPb());
    EasyMock.replay(storageRpcMock);
    storage =
        options
            .toBuilder()
            .setRetrySettings(ServiceOptions.getDefaultRetrySettings())
            .build()
            .getService();
    initializeServiceDependentObjects();
    Blob readBlob = storage.get(blob);
    assertEquals(expectedBlob1, readBlob);
  }

  @Test
  public void testNonRetryableException() {
    BlobId blob = BlobId.of(BUCKET_NAME1, BLOB_NAME1);
    String exceptionMessage = "Not Implemented";
    EasyMock.expect(storageRpcMock.get(blob.toPb(), EMPTY_RPC_OPTIONS))
        .andThrow(new StorageException(501, exceptionMessage));
    EasyMock.replay(storageRpcMock);
    storage =
        options
            .toBuilder()
            .setRetrySettings(ServiceOptions.getDefaultRetrySettings())
            .build()
            .getService();
    initializeServiceDependentObjects();
    thrown.expect(StorageException.class);
    thrown.expectMessage(exceptionMessage);
    storage.get(blob);
  }

  @Test
  public void testRuntimeException() {
    BlobId blob = BlobId.of(BUCKET_NAME1, BLOB_NAME1);
    String exceptionMessage = "Artificial runtime exception";
    EasyMock.expect(storageRpcMock.get(blob.toPb(), EMPTY_RPC_OPTIONS))
        .andThrow(new RuntimeException(exceptionMessage));
    EasyMock.replay(storageRpcMock);
    storage =
        options
            .toBuilder()
            .setRetrySettings(ServiceOptions.getDefaultRetrySettings())
            .build()
            .getService();
    thrown.expect(StorageException.class);
    thrown.expectMessage(exceptionMessage);
    storage.get(blob);
  }
}
