/*
 * Copyright 2026 Google LLC
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

package com.google.storage.v2;

import static com.google.storage.v2.StorageClient.ListBucketsPagedResponse;
import static com.google.storage.v2.StorageClient.ListHmacKeysPagedResponse;
import static com.google.storage.v2.StorageClient.ListNotificationsPagedResponse;
import static com.google.storage.v2.StorageClient.ListObjectsPagedResponse;

import com.google.api.gax.core.NoCredentialsProvider;
import com.google.api.gax.grpc.GaxGrpcProperties;
import com.google.api.gax.grpc.testing.LocalChannelProvider;
import com.google.api.gax.grpc.testing.MockGrpcService;
import com.google.api.gax.grpc.testing.MockServiceHelper;
import com.google.api.gax.grpc.testing.MockStreamObserver;
import com.google.api.gax.rpc.ApiClientHeaderProvider;
import com.google.api.gax.rpc.ApiStreamObserver;
import com.google.api.gax.rpc.ClientStreamingCallable;
import com.google.api.gax.rpc.InvalidArgumentException;
import com.google.api.gax.rpc.ServerStreamingCallable;
import com.google.api.gax.rpc.StatusCode;
import com.google.api.resourcenames.ResourceName;
import com.google.common.collect.Lists;
import com.google.iam.v1.AuditConfig;
import com.google.iam.v1.Binding;
import com.google.iam.v1.GetIamPolicyRequest;
import com.google.iam.v1.Policy;
import com.google.iam.v1.SetIamPolicyRequest;
import com.google.iam.v1.TestIamPermissionsRequest;
import com.google.iam.v1.TestIamPermissionsResponse;
import com.google.protobuf.AbstractMessage;
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
public class StorageClientTest {
  private static MockServiceHelper mockServiceHelper;
  private static MockStorage mockStorage;
  private LocalChannelProvider channelProvider;
  private StorageClient client;

  @BeforeClass
  public static void startStaticServer() {
    mockStorage = new MockStorage();
    mockServiceHelper =
        new MockServiceHelper(
            UUID.randomUUID().toString(), Arrays.<MockGrpcService>asList(mockStorage));
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
    StorageSettings settings =
        StorageSettings.newBuilder()
            .setTransportChannelProvider(channelProvider)
            .setCredentialsProvider(NoCredentialsProvider.create())
            .build();
    client = StorageClient.create(settings);
  }

  @After
  public void tearDown() throws Exception {
    client.close();
  }

  @Test
  public void deleteBucketTest() throws Exception {
    Empty expectedResponse = Empty.newBuilder().build();
    mockStorage.addResponse(expectedResponse);

    BucketName name = BucketName.of("[PROJECT]", "[BUCKET]");

    client.deleteBucket(name);

    List<AbstractMessage> actualRequests = mockStorage.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    DeleteBucketRequest actualRequest = ((DeleteBucketRequest) actualRequests.get(0));

    Assert.assertEquals(name.toString(), actualRequest.getName());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void deleteBucketExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockStorage.addException(exception);

    try {
      BucketName name = BucketName.of("[PROJECT]", "[BUCKET]");
      client.deleteBucket(name);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void deleteBucketTest2() throws Exception {
    Empty expectedResponse = Empty.newBuilder().build();
    mockStorage.addResponse(expectedResponse);

    String name = "name3373707";

    client.deleteBucket(name);

    List<AbstractMessage> actualRequests = mockStorage.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    DeleteBucketRequest actualRequest = ((DeleteBucketRequest) actualRequests.get(0));

    Assert.assertEquals(name, actualRequest.getName());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void deleteBucketExceptionTest2() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockStorage.addException(exception);

    try {
      String name = "name3373707";
      client.deleteBucket(name);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void getBucketTest() throws Exception {
    Bucket expectedResponse =
        Bucket.newBuilder()
            .setName(BucketName.of("[PROJECT]", "[BUCKET]").toString())
            .setBucketId("bucketId-1603305307")
            .setEtag("etag3123477")
            .setProject(ProjectName.of("[PROJECT]").toString())
            .setMetageneration(1048558813)
            .setLocation("location1901043637")
            .setLocationType("locationType-58277745")
            .setStorageClass("storageClass871353277")
            .setRpo("rpo113137")
            .addAllAcl(new ArrayList<BucketAccessControl>())
            .addAllDefaultObjectAcl(new ArrayList<ObjectAccessControl>())
            .setLifecycle(Bucket.Lifecycle.newBuilder().build())
            .setCreateTime(Timestamp.newBuilder().build())
            .addAllCors(new ArrayList<Bucket.Cors>())
            .setUpdateTime(Timestamp.newBuilder().build())
            .setDefaultEventBasedHold(true)
            .putAllLabels(new HashMap<String, String>())
            .setWebsite(Bucket.Website.newBuilder().build())
            .setVersioning(Bucket.Versioning.newBuilder().build())
            .setLogging(Bucket.Logging.newBuilder().build())
            .setOwner(Owner.newBuilder().build())
            .setEncryption(Bucket.Encryption.newBuilder().build())
            .setBilling(Bucket.Billing.newBuilder().build())
            .setRetentionPolicy(Bucket.RetentionPolicy.newBuilder().build())
            .setIamConfig(Bucket.IamConfig.newBuilder().build())
            .setSatisfiesPzs(true)
            .setCustomPlacementConfig(Bucket.CustomPlacementConfig.newBuilder().build())
            .setAutoclass(Bucket.Autoclass.newBuilder().build())
            .build();
    mockStorage.addResponse(expectedResponse);

    BucketName name = BucketName.of("[PROJECT]", "[BUCKET]");

    Bucket actualResponse = client.getBucket(name);
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockStorage.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    GetBucketRequest actualRequest = ((GetBucketRequest) actualRequests.get(0));

    Assert.assertEquals(name.toString(), actualRequest.getName());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void getBucketExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockStorage.addException(exception);

    try {
      BucketName name = BucketName.of("[PROJECT]", "[BUCKET]");
      client.getBucket(name);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void getBucketTest2() throws Exception {
    Bucket expectedResponse =
        Bucket.newBuilder()
            .setName(BucketName.of("[PROJECT]", "[BUCKET]").toString())
            .setBucketId("bucketId-1603305307")
            .setEtag("etag3123477")
            .setProject(ProjectName.of("[PROJECT]").toString())
            .setMetageneration(1048558813)
            .setLocation("location1901043637")
            .setLocationType("locationType-58277745")
            .setStorageClass("storageClass871353277")
            .setRpo("rpo113137")
            .addAllAcl(new ArrayList<BucketAccessControl>())
            .addAllDefaultObjectAcl(new ArrayList<ObjectAccessControl>())
            .setLifecycle(Bucket.Lifecycle.newBuilder().build())
            .setCreateTime(Timestamp.newBuilder().build())
            .addAllCors(new ArrayList<Bucket.Cors>())
            .setUpdateTime(Timestamp.newBuilder().build())
            .setDefaultEventBasedHold(true)
            .putAllLabels(new HashMap<String, String>())
            .setWebsite(Bucket.Website.newBuilder().build())
            .setVersioning(Bucket.Versioning.newBuilder().build())
            .setLogging(Bucket.Logging.newBuilder().build())
            .setOwner(Owner.newBuilder().build())
            .setEncryption(Bucket.Encryption.newBuilder().build())
            .setBilling(Bucket.Billing.newBuilder().build())
            .setRetentionPolicy(Bucket.RetentionPolicy.newBuilder().build())
            .setIamConfig(Bucket.IamConfig.newBuilder().build())
            .setSatisfiesPzs(true)
            .setCustomPlacementConfig(Bucket.CustomPlacementConfig.newBuilder().build())
            .setAutoclass(Bucket.Autoclass.newBuilder().build())
            .build();
    mockStorage.addResponse(expectedResponse);

    String name = "name3373707";

    Bucket actualResponse = client.getBucket(name);
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockStorage.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    GetBucketRequest actualRequest = ((GetBucketRequest) actualRequests.get(0));

    Assert.assertEquals(name, actualRequest.getName());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void getBucketExceptionTest2() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockStorage.addException(exception);

    try {
      String name = "name3373707";
      client.getBucket(name);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void createBucketTest() throws Exception {
    Bucket expectedResponse =
        Bucket.newBuilder()
            .setName(BucketName.of("[PROJECT]", "[BUCKET]").toString())
            .setBucketId("bucketId-1603305307")
            .setEtag("etag3123477")
            .setProject(ProjectName.of("[PROJECT]").toString())
            .setMetageneration(1048558813)
            .setLocation("location1901043637")
            .setLocationType("locationType-58277745")
            .setStorageClass("storageClass871353277")
            .setRpo("rpo113137")
            .addAllAcl(new ArrayList<BucketAccessControl>())
            .addAllDefaultObjectAcl(new ArrayList<ObjectAccessControl>())
            .setLifecycle(Bucket.Lifecycle.newBuilder().build())
            .setCreateTime(Timestamp.newBuilder().build())
            .addAllCors(new ArrayList<Bucket.Cors>())
            .setUpdateTime(Timestamp.newBuilder().build())
            .setDefaultEventBasedHold(true)
            .putAllLabels(new HashMap<String, String>())
            .setWebsite(Bucket.Website.newBuilder().build())
            .setVersioning(Bucket.Versioning.newBuilder().build())
            .setLogging(Bucket.Logging.newBuilder().build())
            .setOwner(Owner.newBuilder().build())
            .setEncryption(Bucket.Encryption.newBuilder().build())
            .setBilling(Bucket.Billing.newBuilder().build())
            .setRetentionPolicy(Bucket.RetentionPolicy.newBuilder().build())
            .setIamConfig(Bucket.IamConfig.newBuilder().build())
            .setSatisfiesPzs(true)
            .setCustomPlacementConfig(Bucket.CustomPlacementConfig.newBuilder().build())
            .setAutoclass(Bucket.Autoclass.newBuilder().build())
            .build();
    mockStorage.addResponse(expectedResponse);

    ProjectName parent = ProjectName.of("[PROJECT]");
    Bucket bucket = Bucket.newBuilder().build();
    String bucketId = "bucketId-1603305307";

    Bucket actualResponse = client.createBucket(parent, bucket, bucketId);
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockStorage.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    CreateBucketRequest actualRequest = ((CreateBucketRequest) actualRequests.get(0));

    Assert.assertEquals(parent.toString(), actualRequest.getParent());
    Assert.assertEquals(bucket, actualRequest.getBucket());
    Assert.assertEquals(bucketId, actualRequest.getBucketId());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void createBucketExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockStorage.addException(exception);

    try {
      ProjectName parent = ProjectName.of("[PROJECT]");
      Bucket bucket = Bucket.newBuilder().build();
      String bucketId = "bucketId-1603305307";
      client.createBucket(parent, bucket, bucketId);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void createBucketTest2() throws Exception {
    Bucket expectedResponse =
        Bucket.newBuilder()
            .setName(BucketName.of("[PROJECT]", "[BUCKET]").toString())
            .setBucketId("bucketId-1603305307")
            .setEtag("etag3123477")
            .setProject(ProjectName.of("[PROJECT]").toString())
            .setMetageneration(1048558813)
            .setLocation("location1901043637")
            .setLocationType("locationType-58277745")
            .setStorageClass("storageClass871353277")
            .setRpo("rpo113137")
            .addAllAcl(new ArrayList<BucketAccessControl>())
            .addAllDefaultObjectAcl(new ArrayList<ObjectAccessControl>())
            .setLifecycle(Bucket.Lifecycle.newBuilder().build())
            .setCreateTime(Timestamp.newBuilder().build())
            .addAllCors(new ArrayList<Bucket.Cors>())
            .setUpdateTime(Timestamp.newBuilder().build())
            .setDefaultEventBasedHold(true)
            .putAllLabels(new HashMap<String, String>())
            .setWebsite(Bucket.Website.newBuilder().build())
            .setVersioning(Bucket.Versioning.newBuilder().build())
            .setLogging(Bucket.Logging.newBuilder().build())
            .setOwner(Owner.newBuilder().build())
            .setEncryption(Bucket.Encryption.newBuilder().build())
            .setBilling(Bucket.Billing.newBuilder().build())
            .setRetentionPolicy(Bucket.RetentionPolicy.newBuilder().build())
            .setIamConfig(Bucket.IamConfig.newBuilder().build())
            .setSatisfiesPzs(true)
            .setCustomPlacementConfig(Bucket.CustomPlacementConfig.newBuilder().build())
            .setAutoclass(Bucket.Autoclass.newBuilder().build())
            .build();
    mockStorage.addResponse(expectedResponse);

    String parent = "parent-995424086";
    Bucket bucket = Bucket.newBuilder().build();
    String bucketId = "bucketId-1603305307";

    Bucket actualResponse = client.createBucket(parent, bucket, bucketId);
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockStorage.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    CreateBucketRequest actualRequest = ((CreateBucketRequest) actualRequests.get(0));

    Assert.assertEquals(parent, actualRequest.getParent());
    Assert.assertEquals(bucket, actualRequest.getBucket());
    Assert.assertEquals(bucketId, actualRequest.getBucketId());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void createBucketExceptionTest2() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockStorage.addException(exception);

    try {
      String parent = "parent-995424086";
      Bucket bucket = Bucket.newBuilder().build();
      String bucketId = "bucketId-1603305307";
      client.createBucket(parent, bucket, bucketId);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void listBucketsTest() throws Exception {
    Bucket responsesElement = Bucket.newBuilder().build();
    ListBucketsResponse expectedResponse =
        ListBucketsResponse.newBuilder()
            .setNextPageToken("")
            .addAllBuckets(Arrays.asList(responsesElement))
            .build();
    mockStorage.addResponse(expectedResponse);

    ProjectName parent = ProjectName.of("[PROJECT]");

    ListBucketsPagedResponse pagedListResponse = client.listBuckets(parent);

    List<Bucket> resources = Lists.newArrayList(pagedListResponse.iterateAll());

    Assert.assertEquals(1, resources.size());
    Assert.assertEquals(expectedResponse.getBucketsList().get(0), resources.get(0));

    List<AbstractMessage> actualRequests = mockStorage.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    ListBucketsRequest actualRequest = ((ListBucketsRequest) actualRequests.get(0));

    Assert.assertEquals(parent.toString(), actualRequest.getParent());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void listBucketsExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockStorage.addException(exception);

    try {
      ProjectName parent = ProjectName.of("[PROJECT]");
      client.listBuckets(parent);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void listBucketsTest2() throws Exception {
    Bucket responsesElement = Bucket.newBuilder().build();
    ListBucketsResponse expectedResponse =
        ListBucketsResponse.newBuilder()
            .setNextPageToken("")
            .addAllBuckets(Arrays.asList(responsesElement))
            .build();
    mockStorage.addResponse(expectedResponse);

    String parent = "parent-995424086";

    ListBucketsPagedResponse pagedListResponse = client.listBuckets(parent);

    List<Bucket> resources = Lists.newArrayList(pagedListResponse.iterateAll());

    Assert.assertEquals(1, resources.size());
    Assert.assertEquals(expectedResponse.getBucketsList().get(0), resources.get(0));

    List<AbstractMessage> actualRequests = mockStorage.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    ListBucketsRequest actualRequest = ((ListBucketsRequest) actualRequests.get(0));

    Assert.assertEquals(parent, actualRequest.getParent());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void listBucketsExceptionTest2() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockStorage.addException(exception);

    try {
      String parent = "parent-995424086";
      client.listBuckets(parent);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void lockBucketRetentionPolicyTest() throws Exception {
    Bucket expectedResponse =
        Bucket.newBuilder()
            .setName(BucketName.of("[PROJECT]", "[BUCKET]").toString())
            .setBucketId("bucketId-1603305307")
            .setEtag("etag3123477")
            .setProject(ProjectName.of("[PROJECT]").toString())
            .setMetageneration(1048558813)
            .setLocation("location1901043637")
            .setLocationType("locationType-58277745")
            .setStorageClass("storageClass871353277")
            .setRpo("rpo113137")
            .addAllAcl(new ArrayList<BucketAccessControl>())
            .addAllDefaultObjectAcl(new ArrayList<ObjectAccessControl>())
            .setLifecycle(Bucket.Lifecycle.newBuilder().build())
            .setCreateTime(Timestamp.newBuilder().build())
            .addAllCors(new ArrayList<Bucket.Cors>())
            .setUpdateTime(Timestamp.newBuilder().build())
            .setDefaultEventBasedHold(true)
            .putAllLabels(new HashMap<String, String>())
            .setWebsite(Bucket.Website.newBuilder().build())
            .setVersioning(Bucket.Versioning.newBuilder().build())
            .setLogging(Bucket.Logging.newBuilder().build())
            .setOwner(Owner.newBuilder().build())
            .setEncryption(Bucket.Encryption.newBuilder().build())
            .setBilling(Bucket.Billing.newBuilder().build())
            .setRetentionPolicy(Bucket.RetentionPolicy.newBuilder().build())
            .setIamConfig(Bucket.IamConfig.newBuilder().build())
            .setSatisfiesPzs(true)
            .setCustomPlacementConfig(Bucket.CustomPlacementConfig.newBuilder().build())
            .setAutoclass(Bucket.Autoclass.newBuilder().build())
            .build();
    mockStorage.addResponse(expectedResponse);

    BucketName bucket = BucketName.of("[PROJECT]", "[BUCKET]");

    Bucket actualResponse = client.lockBucketRetentionPolicy(bucket);
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockStorage.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    LockBucketRetentionPolicyRequest actualRequest =
        ((LockBucketRetentionPolicyRequest) actualRequests.get(0));

    Assert.assertEquals(bucket.toString(), actualRequest.getBucket());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void lockBucketRetentionPolicyExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockStorage.addException(exception);

    try {
      BucketName bucket = BucketName.of("[PROJECT]", "[BUCKET]");
      client.lockBucketRetentionPolicy(bucket);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void lockBucketRetentionPolicyTest2() throws Exception {
    Bucket expectedResponse =
        Bucket.newBuilder()
            .setName(BucketName.of("[PROJECT]", "[BUCKET]").toString())
            .setBucketId("bucketId-1603305307")
            .setEtag("etag3123477")
            .setProject(ProjectName.of("[PROJECT]").toString())
            .setMetageneration(1048558813)
            .setLocation("location1901043637")
            .setLocationType("locationType-58277745")
            .setStorageClass("storageClass871353277")
            .setRpo("rpo113137")
            .addAllAcl(new ArrayList<BucketAccessControl>())
            .addAllDefaultObjectAcl(new ArrayList<ObjectAccessControl>())
            .setLifecycle(Bucket.Lifecycle.newBuilder().build())
            .setCreateTime(Timestamp.newBuilder().build())
            .addAllCors(new ArrayList<Bucket.Cors>())
            .setUpdateTime(Timestamp.newBuilder().build())
            .setDefaultEventBasedHold(true)
            .putAllLabels(new HashMap<String, String>())
            .setWebsite(Bucket.Website.newBuilder().build())
            .setVersioning(Bucket.Versioning.newBuilder().build())
            .setLogging(Bucket.Logging.newBuilder().build())
            .setOwner(Owner.newBuilder().build())
            .setEncryption(Bucket.Encryption.newBuilder().build())
            .setBilling(Bucket.Billing.newBuilder().build())
            .setRetentionPolicy(Bucket.RetentionPolicy.newBuilder().build())
            .setIamConfig(Bucket.IamConfig.newBuilder().build())
            .setSatisfiesPzs(true)
            .setCustomPlacementConfig(Bucket.CustomPlacementConfig.newBuilder().build())
            .setAutoclass(Bucket.Autoclass.newBuilder().build())
            .build();
    mockStorage.addResponse(expectedResponse);

    String bucket = "bucket-1378203158";

    Bucket actualResponse = client.lockBucketRetentionPolicy(bucket);
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockStorage.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    LockBucketRetentionPolicyRequest actualRequest =
        ((LockBucketRetentionPolicyRequest) actualRequests.get(0));

    Assert.assertEquals(bucket, actualRequest.getBucket());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void lockBucketRetentionPolicyExceptionTest2() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockStorage.addException(exception);

    try {
      String bucket = "bucket-1378203158";
      client.lockBucketRetentionPolicy(bucket);
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
    mockStorage.addResponse(expectedResponse);

    ResourceName resource =
        CryptoKeyName.of("[PROJECT]", "[LOCATION]", "[KEY_RING]", "[CRYPTO_KEY]");

    Policy actualResponse = client.getIamPolicy(resource);
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockStorage.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    GetIamPolicyRequest actualRequest = ((GetIamPolicyRequest) actualRequests.get(0));

    Assert.assertEquals(resource.toString(), actualRequest.getResource());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void getIamPolicyExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockStorage.addException(exception);

    try {
      ResourceName resource =
          CryptoKeyName.of("[PROJECT]", "[LOCATION]", "[KEY_RING]", "[CRYPTO_KEY]");
      client.getIamPolicy(resource);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void getIamPolicyTest2() throws Exception {
    Policy expectedResponse =
        Policy.newBuilder()
            .setVersion(351608024)
            .addAllBindings(new ArrayList<Binding>())
            .addAllAuditConfigs(new ArrayList<AuditConfig>())
            .setEtag(ByteString.EMPTY)
            .build();
    mockStorage.addResponse(expectedResponse);

    String resource = "resource-341064690";

    Policy actualResponse = client.getIamPolicy(resource);
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockStorage.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    GetIamPolicyRequest actualRequest = ((GetIamPolicyRequest) actualRequests.get(0));

    Assert.assertEquals(resource, actualRequest.getResource());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void getIamPolicyExceptionTest2() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockStorage.addException(exception);

    try {
      String resource = "resource-341064690";
      client.getIamPolicy(resource);
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
    mockStorage.addResponse(expectedResponse);

    ResourceName resource =
        CryptoKeyName.of("[PROJECT]", "[LOCATION]", "[KEY_RING]", "[CRYPTO_KEY]");
    Policy policy = Policy.newBuilder().build();

    Policy actualResponse = client.setIamPolicy(resource, policy);
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockStorage.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    SetIamPolicyRequest actualRequest = ((SetIamPolicyRequest) actualRequests.get(0));

    Assert.assertEquals(resource.toString(), actualRequest.getResource());
    Assert.assertEquals(policy, actualRequest.getPolicy());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void setIamPolicyExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockStorage.addException(exception);

    try {
      ResourceName resource =
          CryptoKeyName.of("[PROJECT]", "[LOCATION]", "[KEY_RING]", "[CRYPTO_KEY]");
      Policy policy = Policy.newBuilder().build();
      client.setIamPolicy(resource, policy);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void setIamPolicyTest2() throws Exception {
    Policy expectedResponse =
        Policy.newBuilder()
            .setVersion(351608024)
            .addAllBindings(new ArrayList<Binding>())
            .addAllAuditConfigs(new ArrayList<AuditConfig>())
            .setEtag(ByteString.EMPTY)
            .build();
    mockStorage.addResponse(expectedResponse);

    String resource = "resource-341064690";
    Policy policy = Policy.newBuilder().build();

    Policy actualResponse = client.setIamPolicy(resource, policy);
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockStorage.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    SetIamPolicyRequest actualRequest = ((SetIamPolicyRequest) actualRequests.get(0));

    Assert.assertEquals(resource, actualRequest.getResource());
    Assert.assertEquals(policy, actualRequest.getPolicy());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void setIamPolicyExceptionTest2() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockStorage.addException(exception);

    try {
      String resource = "resource-341064690";
      Policy policy = Policy.newBuilder().build();
      client.setIamPolicy(resource, policy);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void testIamPermissionsTest() throws Exception {
    TestIamPermissionsResponse expectedResponse =
        TestIamPermissionsResponse.newBuilder().addAllPermissions(new ArrayList<String>()).build();
    mockStorage.addResponse(expectedResponse);

    ResourceName resource =
        CryptoKeyName.of("[PROJECT]", "[LOCATION]", "[KEY_RING]", "[CRYPTO_KEY]");
    List<String> permissions = new ArrayList<>();

    TestIamPermissionsResponse actualResponse = client.testIamPermissions(resource, permissions);
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockStorage.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    TestIamPermissionsRequest actualRequest = ((TestIamPermissionsRequest) actualRequests.get(0));

    Assert.assertEquals(resource.toString(), actualRequest.getResource());
    Assert.assertEquals(permissions, actualRequest.getPermissionsList());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void testIamPermissionsExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockStorage.addException(exception);

    try {
      ResourceName resource =
          CryptoKeyName.of("[PROJECT]", "[LOCATION]", "[KEY_RING]", "[CRYPTO_KEY]");
      List<String> permissions = new ArrayList<>();
      client.testIamPermissions(resource, permissions);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void testIamPermissionsTest2() throws Exception {
    TestIamPermissionsResponse expectedResponse =
        TestIamPermissionsResponse.newBuilder().addAllPermissions(new ArrayList<String>()).build();
    mockStorage.addResponse(expectedResponse);

    String resource = "resource-341064690";
    List<String> permissions = new ArrayList<>();

    TestIamPermissionsResponse actualResponse = client.testIamPermissions(resource, permissions);
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockStorage.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    TestIamPermissionsRequest actualRequest = ((TestIamPermissionsRequest) actualRequests.get(0));

    Assert.assertEquals(resource, actualRequest.getResource());
    Assert.assertEquals(permissions, actualRequest.getPermissionsList());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void testIamPermissionsExceptionTest2() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockStorage.addException(exception);

    try {
      String resource = "resource-341064690";
      List<String> permissions = new ArrayList<>();
      client.testIamPermissions(resource, permissions);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void updateBucketTest() throws Exception {
    Bucket expectedResponse =
        Bucket.newBuilder()
            .setName(BucketName.of("[PROJECT]", "[BUCKET]").toString())
            .setBucketId("bucketId-1603305307")
            .setEtag("etag3123477")
            .setProject(ProjectName.of("[PROJECT]").toString())
            .setMetageneration(1048558813)
            .setLocation("location1901043637")
            .setLocationType("locationType-58277745")
            .setStorageClass("storageClass871353277")
            .setRpo("rpo113137")
            .addAllAcl(new ArrayList<BucketAccessControl>())
            .addAllDefaultObjectAcl(new ArrayList<ObjectAccessControl>())
            .setLifecycle(Bucket.Lifecycle.newBuilder().build())
            .setCreateTime(Timestamp.newBuilder().build())
            .addAllCors(new ArrayList<Bucket.Cors>())
            .setUpdateTime(Timestamp.newBuilder().build())
            .setDefaultEventBasedHold(true)
            .putAllLabels(new HashMap<String, String>())
            .setWebsite(Bucket.Website.newBuilder().build())
            .setVersioning(Bucket.Versioning.newBuilder().build())
            .setLogging(Bucket.Logging.newBuilder().build())
            .setOwner(Owner.newBuilder().build())
            .setEncryption(Bucket.Encryption.newBuilder().build())
            .setBilling(Bucket.Billing.newBuilder().build())
            .setRetentionPolicy(Bucket.RetentionPolicy.newBuilder().build())
            .setIamConfig(Bucket.IamConfig.newBuilder().build())
            .setSatisfiesPzs(true)
            .setCustomPlacementConfig(Bucket.CustomPlacementConfig.newBuilder().build())
            .setAutoclass(Bucket.Autoclass.newBuilder().build())
            .build();
    mockStorage.addResponse(expectedResponse);

    Bucket bucket = Bucket.newBuilder().build();
    FieldMask updateMask = FieldMask.newBuilder().build();

    Bucket actualResponse = client.updateBucket(bucket, updateMask);
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockStorage.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    UpdateBucketRequest actualRequest = ((UpdateBucketRequest) actualRequests.get(0));

    Assert.assertEquals(bucket, actualRequest.getBucket());
    Assert.assertEquals(updateMask, actualRequest.getUpdateMask());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void updateBucketExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockStorage.addException(exception);

    try {
      Bucket bucket = Bucket.newBuilder().build();
      FieldMask updateMask = FieldMask.newBuilder().build();
      client.updateBucket(bucket, updateMask);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void deleteNotificationTest() throws Exception {
    Empty expectedResponse = Empty.newBuilder().build();
    mockStorage.addResponse(expectedResponse);

    NotificationName name = NotificationName.of("[PROJECT]", "[BUCKET]", "[NOTIFICATION]");

    client.deleteNotification(name);

    List<AbstractMessage> actualRequests = mockStorage.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    DeleteNotificationRequest actualRequest = ((DeleteNotificationRequest) actualRequests.get(0));

    Assert.assertEquals(name.toString(), actualRequest.getName());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void deleteNotificationExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockStorage.addException(exception);

    try {
      NotificationName name = NotificationName.of("[PROJECT]", "[BUCKET]", "[NOTIFICATION]");
      client.deleteNotification(name);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void deleteNotificationTest2() throws Exception {
    Empty expectedResponse = Empty.newBuilder().build();
    mockStorage.addResponse(expectedResponse);

    String name = "name3373707";

    client.deleteNotification(name);

    List<AbstractMessage> actualRequests = mockStorage.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    DeleteNotificationRequest actualRequest = ((DeleteNotificationRequest) actualRequests.get(0));

    Assert.assertEquals(name, actualRequest.getName());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void deleteNotificationExceptionTest2() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockStorage.addException(exception);

    try {
      String name = "name3373707";
      client.deleteNotification(name);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void getNotificationTest() throws Exception {
    Notification expectedResponse =
        Notification.newBuilder()
            .setName(NotificationName.of("[PROJECT]", "[BUCKET]", "[NOTIFICATION]").toString())
            .setTopic("topic110546223")
            .setEtag("etag3123477")
            .addAllEventTypes(new ArrayList<String>())
            .putAllCustomAttributes(new HashMap<String, String>())
            .setObjectNamePrefix("objectNamePrefix-1978236516")
            .setPayloadFormat("payloadFormat-2140609755")
            .build();
    mockStorage.addResponse(expectedResponse);

    BucketName name = BucketName.of("[PROJECT]", "[BUCKET]");

    Notification actualResponse = client.getNotification(name);
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockStorage.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    GetNotificationRequest actualRequest = ((GetNotificationRequest) actualRequests.get(0));

    Assert.assertEquals(name.toString(), actualRequest.getName());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void getNotificationExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockStorage.addException(exception);

    try {
      BucketName name = BucketName.of("[PROJECT]", "[BUCKET]");
      client.getNotification(name);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void getNotificationTest2() throws Exception {
    Notification expectedResponse =
        Notification.newBuilder()
            .setName(NotificationName.of("[PROJECT]", "[BUCKET]", "[NOTIFICATION]").toString())
            .setTopic("topic110546223")
            .setEtag("etag3123477")
            .addAllEventTypes(new ArrayList<String>())
            .putAllCustomAttributes(new HashMap<String, String>())
            .setObjectNamePrefix("objectNamePrefix-1978236516")
            .setPayloadFormat("payloadFormat-2140609755")
            .build();
    mockStorage.addResponse(expectedResponse);

    String name = "name3373707";

    Notification actualResponse = client.getNotification(name);
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockStorage.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    GetNotificationRequest actualRequest = ((GetNotificationRequest) actualRequests.get(0));

    Assert.assertEquals(name, actualRequest.getName());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void getNotificationExceptionTest2() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockStorage.addException(exception);

    try {
      String name = "name3373707";
      client.getNotification(name);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void createNotificationTest() throws Exception {
    Notification expectedResponse =
        Notification.newBuilder()
            .setName(NotificationName.of("[PROJECT]", "[BUCKET]", "[NOTIFICATION]").toString())
            .setTopic("topic110546223")
            .setEtag("etag3123477")
            .addAllEventTypes(new ArrayList<String>())
            .putAllCustomAttributes(new HashMap<String, String>())
            .setObjectNamePrefix("objectNamePrefix-1978236516")
            .setPayloadFormat("payloadFormat-2140609755")
            .build();
    mockStorage.addResponse(expectedResponse);

    ProjectName parent = ProjectName.of("[PROJECT]");
    Notification notification = Notification.newBuilder().build();

    Notification actualResponse = client.createNotification(parent, notification);
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockStorage.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    CreateNotificationRequest actualRequest = ((CreateNotificationRequest) actualRequests.get(0));

    Assert.assertEquals(parent.toString(), actualRequest.getParent());
    Assert.assertEquals(notification, actualRequest.getNotification());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void createNotificationExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockStorage.addException(exception);

    try {
      ProjectName parent = ProjectName.of("[PROJECT]");
      Notification notification = Notification.newBuilder().build();
      client.createNotification(parent, notification);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void createNotificationTest2() throws Exception {
    Notification expectedResponse =
        Notification.newBuilder()
            .setName(NotificationName.of("[PROJECT]", "[BUCKET]", "[NOTIFICATION]").toString())
            .setTopic("topic110546223")
            .setEtag("etag3123477")
            .addAllEventTypes(new ArrayList<String>())
            .putAllCustomAttributes(new HashMap<String, String>())
            .setObjectNamePrefix("objectNamePrefix-1978236516")
            .setPayloadFormat("payloadFormat-2140609755")
            .build();
    mockStorage.addResponse(expectedResponse);

    String parent = "parent-995424086";
    Notification notification = Notification.newBuilder().build();

    Notification actualResponse = client.createNotification(parent, notification);
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockStorage.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    CreateNotificationRequest actualRequest = ((CreateNotificationRequest) actualRequests.get(0));

    Assert.assertEquals(parent, actualRequest.getParent());
    Assert.assertEquals(notification, actualRequest.getNotification());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void createNotificationExceptionTest2() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockStorage.addException(exception);

    try {
      String parent = "parent-995424086";
      Notification notification = Notification.newBuilder().build();
      client.createNotification(parent, notification);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void listNotificationsTest() throws Exception {
    Notification responsesElement = Notification.newBuilder().build();
    ListNotificationsResponse expectedResponse =
        ListNotificationsResponse.newBuilder()
            .setNextPageToken("")
            .addAllNotifications(Arrays.asList(responsesElement))
            .build();
    mockStorage.addResponse(expectedResponse);

    ProjectName parent = ProjectName.of("[PROJECT]");

    ListNotificationsPagedResponse pagedListResponse = client.listNotifications(parent);

    List<Notification> resources = Lists.newArrayList(pagedListResponse.iterateAll());

    Assert.assertEquals(1, resources.size());
    Assert.assertEquals(expectedResponse.getNotificationsList().get(0), resources.get(0));

    List<AbstractMessage> actualRequests = mockStorage.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    ListNotificationsRequest actualRequest = ((ListNotificationsRequest) actualRequests.get(0));

    Assert.assertEquals(parent.toString(), actualRequest.getParent());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void listNotificationsExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockStorage.addException(exception);

    try {
      ProjectName parent = ProjectName.of("[PROJECT]");
      client.listNotifications(parent);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void listNotificationsTest2() throws Exception {
    Notification responsesElement = Notification.newBuilder().build();
    ListNotificationsResponse expectedResponse =
        ListNotificationsResponse.newBuilder()
            .setNextPageToken("")
            .addAllNotifications(Arrays.asList(responsesElement))
            .build();
    mockStorage.addResponse(expectedResponse);

    String parent = "parent-995424086";

    ListNotificationsPagedResponse pagedListResponse = client.listNotifications(parent);

    List<Notification> resources = Lists.newArrayList(pagedListResponse.iterateAll());

    Assert.assertEquals(1, resources.size());
    Assert.assertEquals(expectedResponse.getNotificationsList().get(0), resources.get(0));

    List<AbstractMessage> actualRequests = mockStorage.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    ListNotificationsRequest actualRequest = ((ListNotificationsRequest) actualRequests.get(0));

    Assert.assertEquals(parent, actualRequest.getParent());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void listNotificationsExceptionTest2() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockStorage.addException(exception);

    try {
      String parent = "parent-995424086";
      client.listNotifications(parent);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void composeObjectTest() throws Exception {
    Object expectedResponse =
        Object.newBuilder()
            .setName("name3373707")
            .setBucket(BucketName.of("[PROJECT]", "[BUCKET]").toString())
            .setEtag("etag3123477")
            .setGeneration(305703192)
            .setMetageneration(1048558813)
            .setStorageClass("storageClass871353277")
            .setSize(3530753)
            .setContentEncoding("contentEncoding-160088852")
            .setContentDisposition("contentDisposition1034341758")
            .setCacheControl("cacheControl-1336592517")
            .addAllAcl(new ArrayList<ObjectAccessControl>())
            .setContentLanguage("contentLanguage810066673")
            .setDeleteTime(Timestamp.newBuilder().build())
            .setContentType("contentType-389131437")
            .setCreateTime(Timestamp.newBuilder().build())
            .setComponentCount(-485073075)
            .setChecksums(ObjectChecksums.newBuilder().build())
            .setUpdateTime(Timestamp.newBuilder().build())
            .setKmsKey(
                CryptoKeyName.of("[PROJECT]", "[LOCATION]", "[KEY_RING]", "[CRYPTO_KEY]")
                    .toString())
            .setUpdateStorageClassTime(Timestamp.newBuilder().build())
            .setTemporaryHold(true)
            .setRetentionExpireTime(Timestamp.newBuilder().build())
            .putAllMetadata(new HashMap<String, String>())
            .setEventBasedHold(true)
            .setOwner(Owner.newBuilder().build())
            .setCustomerEncryption(CustomerEncryption.newBuilder().build())
            .setCustomTime(Timestamp.newBuilder().build())
            .build();
    mockStorage.addResponse(expectedResponse);

    ComposeObjectRequest request =
        ComposeObjectRequest.newBuilder()
            .setDestination(Object.newBuilder().build())
            .addAllSourceObjects(new ArrayList<ComposeObjectRequest.SourceObject>())
            .setDestinationPredefinedAcl("destinationPredefinedAcl1111125814")
            .setIfGenerationMatch(-1086241088)
            .setIfMetagenerationMatch(1043427781)
            .setKmsKey(
                CryptoKeyName.of("[PROJECT]", "[LOCATION]", "[KEY_RING]", "[CRYPTO_KEY]")
                    .toString())
            .setCommonObjectRequestParams(CommonObjectRequestParams.newBuilder().build())
            .setObjectChecksums(ObjectChecksums.newBuilder().build())
            .build();

    Object actualResponse = client.composeObject(request);
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockStorage.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    ComposeObjectRequest actualRequest = ((ComposeObjectRequest) actualRequests.get(0));

    Assert.assertEquals(request.getDestination(), actualRequest.getDestination());
    Assert.assertEquals(request.getSourceObjectsList(), actualRequest.getSourceObjectsList());
    Assert.assertEquals(
        request.getDestinationPredefinedAcl(), actualRequest.getDestinationPredefinedAcl());
    Assert.assertEquals(request.getIfGenerationMatch(), actualRequest.getIfGenerationMatch());
    Assert.assertEquals(
        request.getIfMetagenerationMatch(), actualRequest.getIfMetagenerationMatch());
    Assert.assertEquals(request.getKmsKey(), actualRequest.getKmsKey());
    Assert.assertEquals(
        request.getCommonObjectRequestParams(), actualRequest.getCommonObjectRequestParams());
    Assert.assertEquals(request.getObjectChecksums(), actualRequest.getObjectChecksums());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void composeObjectExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockStorage.addException(exception);

    try {
      ComposeObjectRequest request =
          ComposeObjectRequest.newBuilder()
              .setDestination(Object.newBuilder().build())
              .addAllSourceObjects(new ArrayList<ComposeObjectRequest.SourceObject>())
              .setDestinationPredefinedAcl("destinationPredefinedAcl1111125814")
              .setIfGenerationMatch(-1086241088)
              .setIfMetagenerationMatch(1043427781)
              .setKmsKey(
                  CryptoKeyName.of("[PROJECT]", "[LOCATION]", "[KEY_RING]", "[CRYPTO_KEY]")
                      .toString())
              .setCommonObjectRequestParams(CommonObjectRequestParams.newBuilder().build())
              .setObjectChecksums(ObjectChecksums.newBuilder().build())
              .build();
      client.composeObject(request);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void deleteObjectTest() throws Exception {
    Empty expectedResponse = Empty.newBuilder().build();
    mockStorage.addResponse(expectedResponse);

    String bucket = "bucket-1378203158";
    String object = "object-1023368385";

    client.deleteObject(bucket, object);

    List<AbstractMessage> actualRequests = mockStorage.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    DeleteObjectRequest actualRequest = ((DeleteObjectRequest) actualRequests.get(0));

    Assert.assertEquals(bucket, actualRequest.getBucket());
    Assert.assertEquals(object, actualRequest.getObject());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void deleteObjectExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockStorage.addException(exception);

    try {
      String bucket = "bucket-1378203158";
      String object = "object-1023368385";
      client.deleteObject(bucket, object);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void deleteObjectTest2() throws Exception {
    Empty expectedResponse = Empty.newBuilder().build();
    mockStorage.addResponse(expectedResponse);

    String bucket = "bucket-1378203158";
    String object = "object-1023368385";
    long generation = 305703192;

    client.deleteObject(bucket, object, generation);

    List<AbstractMessage> actualRequests = mockStorage.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    DeleteObjectRequest actualRequest = ((DeleteObjectRequest) actualRequests.get(0));

    Assert.assertEquals(bucket, actualRequest.getBucket());
    Assert.assertEquals(object, actualRequest.getObject());
    Assert.assertEquals(generation, actualRequest.getGeneration());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void deleteObjectExceptionTest2() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockStorage.addException(exception);

    try {
      String bucket = "bucket-1378203158";
      String object = "object-1023368385";
      long generation = 305703192;
      client.deleteObject(bucket, object, generation);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void cancelResumableWriteTest() throws Exception {
    CancelResumableWriteResponse expectedResponse =
        CancelResumableWriteResponse.newBuilder().build();
    mockStorage.addResponse(expectedResponse);

    String uploadId = "uploadId1563990780";

    CancelResumableWriteResponse actualResponse = client.cancelResumableWrite(uploadId);
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockStorage.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    CancelResumableWriteRequest actualRequest =
        ((CancelResumableWriteRequest) actualRequests.get(0));

    Assert.assertEquals(uploadId, actualRequest.getUploadId());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void cancelResumableWriteExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockStorage.addException(exception);

    try {
      String uploadId = "uploadId1563990780";
      client.cancelResumableWrite(uploadId);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void getObjectTest() throws Exception {
    Object expectedResponse =
        Object.newBuilder()
            .setName("name3373707")
            .setBucket(BucketName.of("[PROJECT]", "[BUCKET]").toString())
            .setEtag("etag3123477")
            .setGeneration(305703192)
            .setMetageneration(1048558813)
            .setStorageClass("storageClass871353277")
            .setSize(3530753)
            .setContentEncoding("contentEncoding-160088852")
            .setContentDisposition("contentDisposition1034341758")
            .setCacheControl("cacheControl-1336592517")
            .addAllAcl(new ArrayList<ObjectAccessControl>())
            .setContentLanguage("contentLanguage810066673")
            .setDeleteTime(Timestamp.newBuilder().build())
            .setContentType("contentType-389131437")
            .setCreateTime(Timestamp.newBuilder().build())
            .setComponentCount(-485073075)
            .setChecksums(ObjectChecksums.newBuilder().build())
            .setUpdateTime(Timestamp.newBuilder().build())
            .setKmsKey(
                CryptoKeyName.of("[PROJECT]", "[LOCATION]", "[KEY_RING]", "[CRYPTO_KEY]")
                    .toString())
            .setUpdateStorageClassTime(Timestamp.newBuilder().build())
            .setTemporaryHold(true)
            .setRetentionExpireTime(Timestamp.newBuilder().build())
            .putAllMetadata(new HashMap<String, String>())
            .setEventBasedHold(true)
            .setOwner(Owner.newBuilder().build())
            .setCustomerEncryption(CustomerEncryption.newBuilder().build())
            .setCustomTime(Timestamp.newBuilder().build())
            .build();
    mockStorage.addResponse(expectedResponse);

    String bucket = "bucket-1378203158";
    String object = "object-1023368385";

    Object actualResponse = client.getObject(bucket, object);
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockStorage.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    GetObjectRequest actualRequest = ((GetObjectRequest) actualRequests.get(0));

    Assert.assertEquals(bucket, actualRequest.getBucket());
    Assert.assertEquals(object, actualRequest.getObject());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void getObjectExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockStorage.addException(exception);

    try {
      String bucket = "bucket-1378203158";
      String object = "object-1023368385";
      client.getObject(bucket, object);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void getObjectTest2() throws Exception {
    Object expectedResponse =
        Object.newBuilder()
            .setName("name3373707")
            .setBucket(BucketName.of("[PROJECT]", "[BUCKET]").toString())
            .setEtag("etag3123477")
            .setGeneration(305703192)
            .setMetageneration(1048558813)
            .setStorageClass("storageClass871353277")
            .setSize(3530753)
            .setContentEncoding("contentEncoding-160088852")
            .setContentDisposition("contentDisposition1034341758")
            .setCacheControl("cacheControl-1336592517")
            .addAllAcl(new ArrayList<ObjectAccessControl>())
            .setContentLanguage("contentLanguage810066673")
            .setDeleteTime(Timestamp.newBuilder().build())
            .setContentType("contentType-389131437")
            .setCreateTime(Timestamp.newBuilder().build())
            .setComponentCount(-485073075)
            .setChecksums(ObjectChecksums.newBuilder().build())
            .setUpdateTime(Timestamp.newBuilder().build())
            .setKmsKey(
                CryptoKeyName.of("[PROJECT]", "[LOCATION]", "[KEY_RING]", "[CRYPTO_KEY]")
                    .toString())
            .setUpdateStorageClassTime(Timestamp.newBuilder().build())
            .setTemporaryHold(true)
            .setRetentionExpireTime(Timestamp.newBuilder().build())
            .putAllMetadata(new HashMap<String, String>())
            .setEventBasedHold(true)
            .setOwner(Owner.newBuilder().build())
            .setCustomerEncryption(CustomerEncryption.newBuilder().build())
            .setCustomTime(Timestamp.newBuilder().build())
            .build();
    mockStorage.addResponse(expectedResponse);

    String bucket = "bucket-1378203158";
    String object = "object-1023368385";
    long generation = 305703192;

    Object actualResponse = client.getObject(bucket, object, generation);
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockStorage.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    GetObjectRequest actualRequest = ((GetObjectRequest) actualRequests.get(0));

    Assert.assertEquals(bucket, actualRequest.getBucket());
    Assert.assertEquals(object, actualRequest.getObject());
    Assert.assertEquals(generation, actualRequest.getGeneration());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void getObjectExceptionTest2() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockStorage.addException(exception);

    try {
      String bucket = "bucket-1378203158";
      String object = "object-1023368385";
      long generation = 305703192;
      client.getObject(bucket, object, generation);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void readObjectTest() throws Exception {
    ReadObjectResponse expectedResponse =
        ReadObjectResponse.newBuilder()
            .setChecksummedData(ChecksummedData.newBuilder().build())
            .setObjectChecksums(ObjectChecksums.newBuilder().build())
            .setContentRange(ContentRange.newBuilder().build())
            .setMetadata(Object.newBuilder().build())
            .build();
    mockStorage.addResponse(expectedResponse);
    ReadObjectRequest request =
        ReadObjectRequest.newBuilder()
            .setBucket("bucket-1378203158")
            .setObject("object-1023368385")
            .setGeneration(305703192)
            .setReadOffset(-715377828)
            .setReadLimit(-164298798)
            .setIfGenerationMatch(-1086241088)
            .setIfGenerationNotMatch(1475720404)
            .setIfMetagenerationMatch(1043427781)
            .setIfMetagenerationNotMatch(1025430873)
            .setCommonObjectRequestParams(CommonObjectRequestParams.newBuilder().build())
            .setReadMask(FieldMask.newBuilder().build())
            .build();

    MockStreamObserver<ReadObjectResponse> responseObserver = new MockStreamObserver<>();

    ServerStreamingCallable<ReadObjectRequest, ReadObjectResponse> callable =
        client.readObjectCallable();
    callable.serverStreamingCall(request, responseObserver);

    List<ReadObjectResponse> actualResponses = responseObserver.future().get();
    Assert.assertEquals(1, actualResponses.size());
    Assert.assertEquals(expectedResponse, actualResponses.get(0));
  }

  @Test
  public void readObjectExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockStorage.addException(exception);
    ReadObjectRequest request =
        ReadObjectRequest.newBuilder()
            .setBucket("bucket-1378203158")
            .setObject("object-1023368385")
            .setGeneration(305703192)
            .setReadOffset(-715377828)
            .setReadLimit(-164298798)
            .setIfGenerationMatch(-1086241088)
            .setIfGenerationNotMatch(1475720404)
            .setIfMetagenerationMatch(1043427781)
            .setIfMetagenerationNotMatch(1025430873)
            .setCommonObjectRequestParams(CommonObjectRequestParams.newBuilder().build())
            .setReadMask(FieldMask.newBuilder().build())
            .build();

    MockStreamObserver<ReadObjectResponse> responseObserver = new MockStreamObserver<>();

    ServerStreamingCallable<ReadObjectRequest, ReadObjectResponse> callable =
        client.readObjectCallable();
    callable.serverStreamingCall(request, responseObserver);

    try {
      List<ReadObjectResponse> actualResponses = responseObserver.future().get();
      Assert.fail("No exception thrown");
    } catch (ExecutionException e) {
      Assert.assertTrue(e.getCause() instanceof InvalidArgumentException);
      InvalidArgumentException apiException = ((InvalidArgumentException) e.getCause());
      Assert.assertEquals(StatusCode.Code.INVALID_ARGUMENT, apiException.getStatusCode().getCode());
    }
  }

  @Test
  public void updateObjectTest() throws Exception {
    Object expectedResponse =
        Object.newBuilder()
            .setName("name3373707")
            .setBucket(BucketName.of("[PROJECT]", "[BUCKET]").toString())
            .setEtag("etag3123477")
            .setGeneration(305703192)
            .setMetageneration(1048558813)
            .setStorageClass("storageClass871353277")
            .setSize(3530753)
            .setContentEncoding("contentEncoding-160088852")
            .setContentDisposition("contentDisposition1034341758")
            .setCacheControl("cacheControl-1336592517")
            .addAllAcl(new ArrayList<ObjectAccessControl>())
            .setContentLanguage("contentLanguage810066673")
            .setDeleteTime(Timestamp.newBuilder().build())
            .setContentType("contentType-389131437")
            .setCreateTime(Timestamp.newBuilder().build())
            .setComponentCount(-485073075)
            .setChecksums(ObjectChecksums.newBuilder().build())
            .setUpdateTime(Timestamp.newBuilder().build())
            .setKmsKey(
                CryptoKeyName.of("[PROJECT]", "[LOCATION]", "[KEY_RING]", "[CRYPTO_KEY]")
                    .toString())
            .setUpdateStorageClassTime(Timestamp.newBuilder().build())
            .setTemporaryHold(true)
            .setRetentionExpireTime(Timestamp.newBuilder().build())
            .putAllMetadata(new HashMap<String, String>())
            .setEventBasedHold(true)
            .setOwner(Owner.newBuilder().build())
            .setCustomerEncryption(CustomerEncryption.newBuilder().build())
            .setCustomTime(Timestamp.newBuilder().build())
            .build();
    mockStorage.addResponse(expectedResponse);

    Object object = Object.newBuilder().build();
    FieldMask updateMask = FieldMask.newBuilder().build();

    Object actualResponse = client.updateObject(object, updateMask);
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockStorage.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    UpdateObjectRequest actualRequest = ((UpdateObjectRequest) actualRequests.get(0));

    Assert.assertEquals(object, actualRequest.getObject());
    Assert.assertEquals(updateMask, actualRequest.getUpdateMask());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void updateObjectExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockStorage.addException(exception);

    try {
      Object object = Object.newBuilder().build();
      FieldMask updateMask = FieldMask.newBuilder().build();
      client.updateObject(object, updateMask);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void writeObjectTest() throws Exception {
    WriteObjectResponse expectedResponse = WriteObjectResponse.newBuilder().build();
    mockStorage.addResponse(expectedResponse);
    WriteObjectRequest request =
        WriteObjectRequest.newBuilder()
            .setWriteOffset(-1559543565)
            .setObjectChecksums(ObjectChecksums.newBuilder().build())
            .setFinishWrite(true)
            .setCommonObjectRequestParams(CommonObjectRequestParams.newBuilder().build())
            .build();

    MockStreamObserver<WriteObjectResponse> responseObserver = new MockStreamObserver<>();

    ClientStreamingCallable<WriteObjectRequest, WriteObjectResponse> callable =
        client.writeObjectCallable();
    ApiStreamObserver<WriteObjectRequest> requestObserver =
        callable.clientStreamingCall(responseObserver);

    requestObserver.onNext(request);
    requestObserver.onCompleted();

    List<WriteObjectResponse> actualResponses = responseObserver.future().get();
    Assert.assertEquals(1, actualResponses.size());
    Assert.assertEquals(expectedResponse, actualResponses.get(0));
  }

  @Test
  public void writeObjectExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockStorage.addException(exception);
    WriteObjectRequest request =
        WriteObjectRequest.newBuilder()
            .setWriteOffset(-1559543565)
            .setObjectChecksums(ObjectChecksums.newBuilder().build())
            .setFinishWrite(true)
            .setCommonObjectRequestParams(CommonObjectRequestParams.newBuilder().build())
            .build();

    MockStreamObserver<WriteObjectResponse> responseObserver = new MockStreamObserver<>();

    ClientStreamingCallable<WriteObjectRequest, WriteObjectResponse> callable =
        client.writeObjectCallable();
    ApiStreamObserver<WriteObjectRequest> requestObserver =
        callable.clientStreamingCall(responseObserver);

    requestObserver.onNext(request);

    try {
      List<WriteObjectResponse> actualResponses = responseObserver.future().get();
      Assert.fail("No exception thrown");
    } catch (ExecutionException e) {
      Assert.assertTrue(e.getCause() instanceof InvalidArgumentException);
      InvalidArgumentException apiException = ((InvalidArgumentException) e.getCause());
      Assert.assertEquals(StatusCode.Code.INVALID_ARGUMENT, apiException.getStatusCode().getCode());
    }
  }

  @Test
  public void listObjectsTest() throws Exception {
    Object responsesElement = Object.newBuilder().build();
    ListObjectsResponse expectedResponse =
        ListObjectsResponse.newBuilder()
            .setNextPageToken("")
            .addAllObjects(Arrays.asList(responsesElement))
            .build();
    mockStorage.addResponse(expectedResponse);

    ProjectName parent = ProjectName.of("[PROJECT]");

    ListObjectsPagedResponse pagedListResponse = client.listObjects(parent);

    List<Object> resources = Lists.newArrayList(pagedListResponse.iterateAll());

    Assert.assertEquals(1, resources.size());
    Assert.assertEquals(expectedResponse.getObjectsList().get(0), resources.get(0));

    List<AbstractMessage> actualRequests = mockStorage.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    ListObjectsRequest actualRequest = ((ListObjectsRequest) actualRequests.get(0));

    Assert.assertEquals(parent.toString(), actualRequest.getParent());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void listObjectsExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockStorage.addException(exception);

    try {
      ProjectName parent = ProjectName.of("[PROJECT]");
      client.listObjects(parent);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void listObjectsTest2() throws Exception {
    Object responsesElement = Object.newBuilder().build();
    ListObjectsResponse expectedResponse =
        ListObjectsResponse.newBuilder()
            .setNextPageToken("")
            .addAllObjects(Arrays.asList(responsesElement))
            .build();
    mockStorage.addResponse(expectedResponse);

    String parent = "parent-995424086";

    ListObjectsPagedResponse pagedListResponse = client.listObjects(parent);

    List<Object> resources = Lists.newArrayList(pagedListResponse.iterateAll());

    Assert.assertEquals(1, resources.size());
    Assert.assertEquals(expectedResponse.getObjectsList().get(0), resources.get(0));

    List<AbstractMessage> actualRequests = mockStorage.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    ListObjectsRequest actualRequest = ((ListObjectsRequest) actualRequests.get(0));

    Assert.assertEquals(parent, actualRequest.getParent());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void listObjectsExceptionTest2() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockStorage.addException(exception);

    try {
      String parent = "parent-995424086";
      client.listObjects(parent);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void rewriteObjectTest() throws Exception {
    RewriteResponse expectedResponse =
        RewriteResponse.newBuilder()
            .setTotalBytesRewritten(-1109205579)
            .setObjectSize(-1277221631)
            .setDone(true)
            .setRewriteToken("rewriteToken80654285")
            .setResource(Object.newBuilder().build())
            .build();
    mockStorage.addResponse(expectedResponse);

    RewriteObjectRequest request =
        RewriteObjectRequest.newBuilder()
            .setDestinationName("destinationName-1762755655")
            .setDestinationBucket(BucketName.of("[PROJECT]", "[BUCKET]").toString())
            .setDestinationKmsKey(
                CryptoKeyName.of("[PROJECT]", "[LOCATION]", "[KEY_RING]", "[CRYPTO_KEY]")
                    .toString())
            .setDestination(Object.newBuilder().build())
            .setSourceBucket("sourceBucket841604581")
            .setSourceObject("sourceObject1196439354")
            .setSourceGeneration(1232209852)
            .setRewriteToken("rewriteToken80654285")
            .setDestinationPredefinedAcl("destinationPredefinedAcl1111125814")
            .setIfGenerationMatch(-1086241088)
            .setIfGenerationNotMatch(1475720404)
            .setIfMetagenerationMatch(1043427781)
            .setIfMetagenerationNotMatch(1025430873)
            .setIfSourceGenerationMatch(-1427877280)
            .setIfSourceGenerationNotMatch(1575612532)
            .setIfSourceMetagenerationMatch(1143319909)
            .setIfSourceMetagenerationNotMatch(1900822777)
            .setMaxBytesRewrittenPerCall(1178170730)
            .setCopySourceEncryptionAlgorithm("copySourceEncryptionAlgorithm-1524952548")
            .setCopySourceEncryptionKeyBytes(ByteString.EMPTY)
            .setCopySourceEncryptionKeySha256Bytes(ByteString.EMPTY)
            .setCommonObjectRequestParams(CommonObjectRequestParams.newBuilder().build())
            .setObjectChecksums(ObjectChecksums.newBuilder().build())
            .build();

    RewriteResponse actualResponse = client.rewriteObject(request);
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockStorage.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    RewriteObjectRequest actualRequest = ((RewriteObjectRequest) actualRequests.get(0));

    Assert.assertEquals(request.getDestinationName(), actualRequest.getDestinationName());
    Assert.assertEquals(request.getDestinationBucket(), actualRequest.getDestinationBucket());
    Assert.assertEquals(request.getDestinationKmsKey(), actualRequest.getDestinationKmsKey());
    Assert.assertEquals(request.getDestination(), actualRequest.getDestination());
    Assert.assertEquals(request.getSourceBucket(), actualRequest.getSourceBucket());
    Assert.assertEquals(request.getSourceObject(), actualRequest.getSourceObject());
    Assert.assertEquals(request.getSourceGeneration(), actualRequest.getSourceGeneration());
    Assert.assertEquals(request.getRewriteToken(), actualRequest.getRewriteToken());
    Assert.assertEquals(
        request.getDestinationPredefinedAcl(), actualRequest.getDestinationPredefinedAcl());
    Assert.assertEquals(request.getIfGenerationMatch(), actualRequest.getIfGenerationMatch());
    Assert.assertEquals(request.getIfGenerationNotMatch(), actualRequest.getIfGenerationNotMatch());
    Assert.assertEquals(
        request.getIfMetagenerationMatch(), actualRequest.getIfMetagenerationMatch());
    Assert.assertEquals(
        request.getIfMetagenerationNotMatch(), actualRequest.getIfMetagenerationNotMatch());
    Assert.assertEquals(
        request.getIfSourceGenerationMatch(), actualRequest.getIfSourceGenerationMatch());
    Assert.assertEquals(
        request.getIfSourceGenerationNotMatch(), actualRequest.getIfSourceGenerationNotMatch());
    Assert.assertEquals(
        request.getIfSourceMetagenerationMatch(), actualRequest.getIfSourceMetagenerationMatch());
    Assert.assertEquals(
        request.getIfSourceMetagenerationNotMatch(),
        actualRequest.getIfSourceMetagenerationNotMatch());
    Assert.assertEquals(
        request.getMaxBytesRewrittenPerCall(), actualRequest.getMaxBytesRewrittenPerCall());
    Assert.assertEquals(
        request.getCopySourceEncryptionAlgorithm(),
        actualRequest.getCopySourceEncryptionAlgorithm());
    Assert.assertEquals(
        request.getCopySourceEncryptionKeyBytes(), actualRequest.getCopySourceEncryptionKeyBytes());
    Assert.assertEquals(
        request.getCopySourceEncryptionKeySha256Bytes(),
        actualRequest.getCopySourceEncryptionKeySha256Bytes());
    Assert.assertEquals(
        request.getCommonObjectRequestParams(), actualRequest.getCommonObjectRequestParams());
    Assert.assertEquals(request.getObjectChecksums(), actualRequest.getObjectChecksums());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void rewriteObjectExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockStorage.addException(exception);

    try {
      RewriteObjectRequest request =
          RewriteObjectRequest.newBuilder()
              .setDestinationName("destinationName-1762755655")
              .setDestinationBucket(BucketName.of("[PROJECT]", "[BUCKET]").toString())
              .setDestinationKmsKey(
                  CryptoKeyName.of("[PROJECT]", "[LOCATION]", "[KEY_RING]", "[CRYPTO_KEY]")
                      .toString())
              .setDestination(Object.newBuilder().build())
              .setSourceBucket("sourceBucket841604581")
              .setSourceObject("sourceObject1196439354")
              .setSourceGeneration(1232209852)
              .setRewriteToken("rewriteToken80654285")
              .setDestinationPredefinedAcl("destinationPredefinedAcl1111125814")
              .setIfGenerationMatch(-1086241088)
              .setIfGenerationNotMatch(1475720404)
              .setIfMetagenerationMatch(1043427781)
              .setIfMetagenerationNotMatch(1025430873)
              .setIfSourceGenerationMatch(-1427877280)
              .setIfSourceGenerationNotMatch(1575612532)
              .setIfSourceMetagenerationMatch(1143319909)
              .setIfSourceMetagenerationNotMatch(1900822777)
              .setMaxBytesRewrittenPerCall(1178170730)
              .setCopySourceEncryptionAlgorithm("copySourceEncryptionAlgorithm-1524952548")
              .setCopySourceEncryptionKeyBytes(ByteString.EMPTY)
              .setCopySourceEncryptionKeySha256Bytes(ByteString.EMPTY)
              .setCommonObjectRequestParams(CommonObjectRequestParams.newBuilder().build())
              .setObjectChecksums(ObjectChecksums.newBuilder().build())
              .build();
      client.rewriteObject(request);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void startResumableWriteTest() throws Exception {
    StartResumableWriteResponse expectedResponse =
        StartResumableWriteResponse.newBuilder().setUploadId("uploadId1563990780").build();
    mockStorage.addResponse(expectedResponse);

    StartResumableWriteRequest request =
        StartResumableWriteRequest.newBuilder()
            .setWriteObjectSpec(WriteObjectSpec.newBuilder().build())
            .setCommonObjectRequestParams(CommonObjectRequestParams.newBuilder().build())
            .setObjectChecksums(ObjectChecksums.newBuilder().build())
            .build();

    StartResumableWriteResponse actualResponse = client.startResumableWrite(request);
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockStorage.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    StartResumableWriteRequest actualRequest = ((StartResumableWriteRequest) actualRequests.get(0));

    Assert.assertEquals(request.getWriteObjectSpec(), actualRequest.getWriteObjectSpec());
    Assert.assertEquals(
        request.getCommonObjectRequestParams(), actualRequest.getCommonObjectRequestParams());
    Assert.assertEquals(request.getObjectChecksums(), actualRequest.getObjectChecksums());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void startResumableWriteExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockStorage.addException(exception);

    try {
      StartResumableWriteRequest request =
          StartResumableWriteRequest.newBuilder()
              .setWriteObjectSpec(WriteObjectSpec.newBuilder().build())
              .setCommonObjectRequestParams(CommonObjectRequestParams.newBuilder().build())
              .setObjectChecksums(ObjectChecksums.newBuilder().build())
              .build();
      client.startResumableWrite(request);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void queryWriteStatusTest() throws Exception {
    QueryWriteStatusResponse expectedResponse = QueryWriteStatusResponse.newBuilder().build();
    mockStorage.addResponse(expectedResponse);

    String uploadId = "uploadId1563990780";

    QueryWriteStatusResponse actualResponse = client.queryWriteStatus(uploadId);
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockStorage.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    QueryWriteStatusRequest actualRequest = ((QueryWriteStatusRequest) actualRequests.get(0));

    Assert.assertEquals(uploadId, actualRequest.getUploadId());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void queryWriteStatusExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockStorage.addException(exception);

    try {
      String uploadId = "uploadId1563990780";
      client.queryWriteStatus(uploadId);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void getServiceAccountTest() throws Exception {
    ServiceAccount expectedResponse =
        ServiceAccount.newBuilder().setEmailAddress("emailAddress-1070931784").build();
    mockStorage.addResponse(expectedResponse);

    ProjectName project = ProjectName.of("[PROJECT]");

    ServiceAccount actualResponse = client.getServiceAccount(project);
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockStorage.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    GetServiceAccountRequest actualRequest = ((GetServiceAccountRequest) actualRequests.get(0));

    Assert.assertEquals(project.toString(), actualRequest.getProject());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void getServiceAccountExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockStorage.addException(exception);

    try {
      ProjectName project = ProjectName.of("[PROJECT]");
      client.getServiceAccount(project);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void getServiceAccountTest2() throws Exception {
    ServiceAccount expectedResponse =
        ServiceAccount.newBuilder().setEmailAddress("emailAddress-1070931784").build();
    mockStorage.addResponse(expectedResponse);

    String project = "project-309310695";

    ServiceAccount actualResponse = client.getServiceAccount(project);
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockStorage.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    GetServiceAccountRequest actualRequest = ((GetServiceAccountRequest) actualRequests.get(0));

    Assert.assertEquals(project, actualRequest.getProject());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void getServiceAccountExceptionTest2() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockStorage.addException(exception);

    try {
      String project = "project-309310695";
      client.getServiceAccount(project);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void createHmacKeyTest() throws Exception {
    CreateHmacKeyResponse expectedResponse =
        CreateHmacKeyResponse.newBuilder()
            .setMetadata(HmacKeyMetadata.newBuilder().build())
            .setSecretKeyBytes(ByteString.EMPTY)
            .build();
    mockStorage.addResponse(expectedResponse);

    ProjectName project = ProjectName.of("[PROJECT]");
    String serviceAccountEmail = "serviceAccountEmail1825953988";

    CreateHmacKeyResponse actualResponse = client.createHmacKey(project, serviceAccountEmail);
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockStorage.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    CreateHmacKeyRequest actualRequest = ((CreateHmacKeyRequest) actualRequests.get(0));

    Assert.assertEquals(project.toString(), actualRequest.getProject());
    Assert.assertEquals(serviceAccountEmail, actualRequest.getServiceAccountEmail());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void createHmacKeyExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockStorage.addException(exception);

    try {
      ProjectName project = ProjectName.of("[PROJECT]");
      String serviceAccountEmail = "serviceAccountEmail1825953988";
      client.createHmacKey(project, serviceAccountEmail);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void createHmacKeyTest2() throws Exception {
    CreateHmacKeyResponse expectedResponse =
        CreateHmacKeyResponse.newBuilder()
            .setMetadata(HmacKeyMetadata.newBuilder().build())
            .setSecretKeyBytes(ByteString.EMPTY)
            .build();
    mockStorage.addResponse(expectedResponse);

    String project = "project-309310695";
    String serviceAccountEmail = "serviceAccountEmail1825953988";

    CreateHmacKeyResponse actualResponse = client.createHmacKey(project, serviceAccountEmail);
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockStorage.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    CreateHmacKeyRequest actualRequest = ((CreateHmacKeyRequest) actualRequests.get(0));

    Assert.assertEquals(project, actualRequest.getProject());
    Assert.assertEquals(serviceAccountEmail, actualRequest.getServiceAccountEmail());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void createHmacKeyExceptionTest2() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockStorage.addException(exception);

    try {
      String project = "project-309310695";
      String serviceAccountEmail = "serviceAccountEmail1825953988";
      client.createHmacKey(project, serviceAccountEmail);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void deleteHmacKeyTest() throws Exception {
    Empty expectedResponse = Empty.newBuilder().build();
    mockStorage.addResponse(expectedResponse);

    String accessId = "accessId-2146437729";
    ProjectName project = ProjectName.of("[PROJECT]");

    client.deleteHmacKey(accessId, project);

    List<AbstractMessage> actualRequests = mockStorage.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    DeleteHmacKeyRequest actualRequest = ((DeleteHmacKeyRequest) actualRequests.get(0));

    Assert.assertEquals(accessId, actualRequest.getAccessId());
    Assert.assertEquals(project.toString(), actualRequest.getProject());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void deleteHmacKeyExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockStorage.addException(exception);

    try {
      String accessId = "accessId-2146437729";
      ProjectName project = ProjectName.of("[PROJECT]");
      client.deleteHmacKey(accessId, project);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void deleteHmacKeyTest2() throws Exception {
    Empty expectedResponse = Empty.newBuilder().build();
    mockStorage.addResponse(expectedResponse);

    String accessId = "accessId-2146437729";
    String project = "project-309310695";

    client.deleteHmacKey(accessId, project);

    List<AbstractMessage> actualRequests = mockStorage.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    DeleteHmacKeyRequest actualRequest = ((DeleteHmacKeyRequest) actualRequests.get(0));

    Assert.assertEquals(accessId, actualRequest.getAccessId());
    Assert.assertEquals(project, actualRequest.getProject());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void deleteHmacKeyExceptionTest2() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockStorage.addException(exception);

    try {
      String accessId = "accessId-2146437729";
      String project = "project-309310695";
      client.deleteHmacKey(accessId, project);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void getHmacKeyTest() throws Exception {
    HmacKeyMetadata expectedResponse =
        HmacKeyMetadata.newBuilder()
            .setId("id3355")
            .setAccessId("accessId-2146437729")
            .setProject(ProjectName.of("[PROJECT]").toString())
            .setServiceAccountEmail("serviceAccountEmail1825953988")
            .setState("state109757585")
            .setCreateTime(Timestamp.newBuilder().build())
            .setUpdateTime(Timestamp.newBuilder().build())
            .setEtag("etag3123477")
            .build();
    mockStorage.addResponse(expectedResponse);

    String accessId = "accessId-2146437729";
    ProjectName project = ProjectName.of("[PROJECT]");

    HmacKeyMetadata actualResponse = client.getHmacKey(accessId, project);
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockStorage.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    GetHmacKeyRequest actualRequest = ((GetHmacKeyRequest) actualRequests.get(0));

    Assert.assertEquals(accessId, actualRequest.getAccessId());
    Assert.assertEquals(project.toString(), actualRequest.getProject());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void getHmacKeyExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockStorage.addException(exception);

    try {
      String accessId = "accessId-2146437729";
      ProjectName project = ProjectName.of("[PROJECT]");
      client.getHmacKey(accessId, project);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void getHmacKeyTest2() throws Exception {
    HmacKeyMetadata expectedResponse =
        HmacKeyMetadata.newBuilder()
            .setId("id3355")
            .setAccessId("accessId-2146437729")
            .setProject(ProjectName.of("[PROJECT]").toString())
            .setServiceAccountEmail("serviceAccountEmail1825953988")
            .setState("state109757585")
            .setCreateTime(Timestamp.newBuilder().build())
            .setUpdateTime(Timestamp.newBuilder().build())
            .setEtag("etag3123477")
            .build();
    mockStorage.addResponse(expectedResponse);

    String accessId = "accessId-2146437729";
    String project = "project-309310695";

    HmacKeyMetadata actualResponse = client.getHmacKey(accessId, project);
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockStorage.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    GetHmacKeyRequest actualRequest = ((GetHmacKeyRequest) actualRequests.get(0));

    Assert.assertEquals(accessId, actualRequest.getAccessId());
    Assert.assertEquals(project, actualRequest.getProject());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void getHmacKeyExceptionTest2() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockStorage.addException(exception);

    try {
      String accessId = "accessId-2146437729";
      String project = "project-309310695";
      client.getHmacKey(accessId, project);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void listHmacKeysTest() throws Exception {
    HmacKeyMetadata responsesElement = HmacKeyMetadata.newBuilder().build();
    ListHmacKeysResponse expectedResponse =
        ListHmacKeysResponse.newBuilder()
            .setNextPageToken("")
            .addAllHmacKeys(Arrays.asList(responsesElement))
            .build();
    mockStorage.addResponse(expectedResponse);

    ProjectName project = ProjectName.of("[PROJECT]");

    ListHmacKeysPagedResponse pagedListResponse = client.listHmacKeys(project);

    List<HmacKeyMetadata> resources = Lists.newArrayList(pagedListResponse.iterateAll());

    Assert.assertEquals(1, resources.size());
    Assert.assertEquals(expectedResponse.getHmacKeysList().get(0), resources.get(0));

    List<AbstractMessage> actualRequests = mockStorage.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    ListHmacKeysRequest actualRequest = ((ListHmacKeysRequest) actualRequests.get(0));

    Assert.assertEquals(project.toString(), actualRequest.getProject());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void listHmacKeysExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockStorage.addException(exception);

    try {
      ProjectName project = ProjectName.of("[PROJECT]");
      client.listHmacKeys(project);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void listHmacKeysTest2() throws Exception {
    HmacKeyMetadata responsesElement = HmacKeyMetadata.newBuilder().build();
    ListHmacKeysResponse expectedResponse =
        ListHmacKeysResponse.newBuilder()
            .setNextPageToken("")
            .addAllHmacKeys(Arrays.asList(responsesElement))
            .build();
    mockStorage.addResponse(expectedResponse);

    String project = "project-309310695";

    ListHmacKeysPagedResponse pagedListResponse = client.listHmacKeys(project);

    List<HmacKeyMetadata> resources = Lists.newArrayList(pagedListResponse.iterateAll());

    Assert.assertEquals(1, resources.size());
    Assert.assertEquals(expectedResponse.getHmacKeysList().get(0), resources.get(0));

    List<AbstractMessage> actualRequests = mockStorage.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    ListHmacKeysRequest actualRequest = ((ListHmacKeysRequest) actualRequests.get(0));

    Assert.assertEquals(project, actualRequest.getProject());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void listHmacKeysExceptionTest2() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockStorage.addException(exception);

    try {
      String project = "project-309310695";
      client.listHmacKeys(project);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void updateHmacKeyTest() throws Exception {
    HmacKeyMetadata expectedResponse =
        HmacKeyMetadata.newBuilder()
            .setId("id3355")
            .setAccessId("accessId-2146437729")
            .setProject(ProjectName.of("[PROJECT]").toString())
            .setServiceAccountEmail("serviceAccountEmail1825953988")
            .setState("state109757585")
            .setCreateTime(Timestamp.newBuilder().build())
            .setUpdateTime(Timestamp.newBuilder().build())
            .setEtag("etag3123477")
            .build();
    mockStorage.addResponse(expectedResponse);

    HmacKeyMetadata hmacKey = HmacKeyMetadata.newBuilder().build();
    FieldMask updateMask = FieldMask.newBuilder().build();

    HmacKeyMetadata actualResponse = client.updateHmacKey(hmacKey, updateMask);
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockStorage.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    UpdateHmacKeyRequest actualRequest = ((UpdateHmacKeyRequest) actualRequests.get(0));

    Assert.assertEquals(hmacKey, actualRequest.getHmacKey());
    Assert.assertEquals(updateMask, actualRequest.getUpdateMask());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void updateHmacKeyExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockStorage.addException(exception);

    try {
      HmacKeyMetadata hmacKey = HmacKeyMetadata.newBuilder().build();
      FieldMask updateMask = FieldMask.newBuilder().build();
      client.updateHmacKey(hmacKey, updateMask);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }
}
