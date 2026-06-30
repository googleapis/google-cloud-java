/*
 * Copyright 2022 Google LLC
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

import static com.google.cloud.storage.Utils.bucketNameCodec;
import static com.google.common.truth.Truth.assertThat;

import com.google.cloud.storage.Acl.Role;
import com.google.cloud.storage.Acl.User;
import com.google.cloud.storage.BlobInfo.CustomerEncryption;
import com.google.cloud.storage.BucketInfo.CustomPlacementConfig;
import com.google.cloud.storage.BucketInfo.IamConfiguration;
import com.google.cloud.storage.BucketInfo.LifecycleRule;
import com.google.cloud.storage.BucketInfo.LifecycleRule.LifecycleAction;
import com.google.cloud.storage.BucketInfo.LifecycleRule.LifecycleCondition;
import com.google.cloud.storage.BucketInfo.Logging;
import com.google.cloud.storage.Storage.BlobField;
import com.google.cloud.storage.Storage.BucketField;
import com.google.cloud.storage.UnifiedOpts.NamedField;
import com.google.common.collect.ImmutableList;
import com.google.common.collect.ImmutableMap;
import com.google.common.collect.ImmutableSet;
import com.google.protobuf.FieldMask;
import com.google.storage.v2.Bucket;
import com.google.storage.v2.Object;
import com.google.storage.v2.StorageGrpc.StorageImplBase;
import com.google.storage.v2.UpdateBucketRequest;
import com.google.storage.v2.UpdateObjectRequest;
import io.grpc.stub.StreamObserver;
import java.time.Duration;
import java.time.OffsetDateTime;
import java.util.concurrent.atomic.AtomicReference;
import java.util.function.UnaryOperator;
import org.junit.Test;
import org.junit.experimental.runners.Enclosed;
import org.junit.runner.RunWith;

@RunWith(Enclosed.class)
public final class ITUpdateMaskTest {

  public static final class BlobInfoUpdateMask {

    @Test
    public void updateObjectRequest() throws Exception {
      Object expectedObject =
          Object.newBuilder()
              .setBucket(bucketNameCodec.encode("bucket"))
              .setName("obj-name")
              .putMetadata("x", "X")
              .build();
      UpdateObjectRequest expected =
          UpdateObjectRequest.newBuilder()
              .setObject(expectedObject)
              .setUpdateMask(FieldMask.newBuilder().addPaths("metadata.x").build())
              .build();

      AtomicReference<UpdateObjectRequest> actualRequest = new AtomicReference<>();
      StorageImplBase service =
          new StorageImplBase() {
            @Override
            public void updateObject(UpdateObjectRequest request, StreamObserver<Object> obs) {
              try {
                actualRequest.compareAndSet(null, request);
                obs.onNext(expectedObject);
                obs.onCompleted();
              } catch (Exception e) {
                obs.onError(e);
              }
            }
          };

      try (FakeServer fake = FakeServer.of(service);
          Storage s = fake.getGrpcStorageOptions().getService()) {
        BlobInfo base = base();
        s.update(base.toBuilder().setMetadata(ImmutableMap.of("x", "X")).build());
      }

      UpdateObjectRequest actual = actualRequest.get();
      assertThat(actual).isNotNull();
      assertThat(actual).isEqualTo(expected);
    }

    @Test
    public void blobInfo_field_metadata() {
      testBlobField(
          b -> b.setMetadata(ImmutableMap.of("x", "X")),
          NamedField.nested(BlobField.METADATA, NamedField.literal("x")));
    }

    @Test
    public void blobInfo_field_acl() {
      testBlobField(b -> b.setAcl(ImmutableList.of()), BlobField.ACL);
    }

    @Test
    public void blobInfo_field_cacheControl() {
      testBlobField(b -> b.setCacheControl("cc"), BlobField.CACHE_CONTROL);
    }

    @Test
    public void blobInfo_field_contentDisposition() {
      testBlobField(b -> b.setContentDisposition("cd"), BlobField.CONTENT_DISPOSITION);
    }

    @Test
    public void blobInfo_field_contentEncoding() {
      testBlobField(b -> b.setContentEncoding("ce"), BlobField.CONTENT_ENCODING);
    }

    @Test
    public void blobInfo_field_contentLanguage() {
      testBlobField(b -> b.setContentLanguage("cl"), BlobField.CONTENT_LANGUAGE);
    }

    @Test
    public void blobInfo_field_contentType() {
      testBlobField(b -> b.setContentType("ct"), BlobField.CONTENT_TYPE);
    }

    @Test
    public void blobInfo_field_crc32c() {
      testBlobField(b -> b.setCrc32c("c"), BlobField.CRC32C);
    }

    @Test
    public void blobInfo_field_crc32cFromHexString() {
      testBlobField(b -> b.setCrc32cFromHexString("145d34"), BlobField.CRC32C);
    }

    @Test
    public void blobInfo_field_etag() {
      testBlobField(b -> b.setEtag("e"), BlobField.ETAG);
    }

    @Test
    public void blobInfo_field_md5() {
      testBlobField(b -> b.setMd5("m"), BlobField.MD5HASH);
    }

    @Test
    public void blobInfo_field_md5FromHexString() {
      testBlobField(b -> b.setMd5FromHexString("145d34"), BlobField.MD5HASH);
    }

    @Test
    public void blobInfo_field_owner() {
      testBlobField(b -> b.setOwner(new User("x@y.z")), BlobField.OWNER);
    }

    @Test
    public void blobInfo_field_storageClass() {
      testBlobField(b -> b.setStorageClass(StorageClass.COLDLINE), BlobField.STORAGE_CLASS);
    }

    @Test
    public void blobInfo_field_timeDeleted() {
      testBlobField(b -> b.setDeleteTimeOffsetDateTime(OffsetDateTime.MAX), BlobField.TIME_DELETED);
    }

    @Test
    public void blobInfo_field_timeCreated() {
      testBlobField(b -> b.setCreateTimeOffsetDateTime(OffsetDateTime.MAX), BlobField.TIME_CREATED);
    }

    @Test
    public void blobInfo_field_kmsKeyName() {
      testBlobField(b -> b.setKmsKeyName("key"), BlobField.KMS_KEY_NAME);
    }

    @Test
    public void blobInfo_field_eventBasedHold() {
      testBlobField(b -> b.setEventBasedHold(true), BlobField.EVENT_BASED_HOLD);
    }

    @Test
    public void blobInfo_field_temporaryHold() {
      testBlobField(b -> b.setTemporaryHold(true), BlobField.TEMPORARY_HOLD);
    }

    @Test
    public void blobInfo_field_retentionExpirationTime() {
      testBlobField(
          b -> b.setRetentionExpirationTimeOffsetDateTime(OffsetDateTime.MAX),
          BlobField.RETENTION_EXPIRATION_TIME);
    }

    @Test
    public void blobInfo_field_updated() {
      testBlobField(b -> b.setUpdateTimeOffsetDateTime(OffsetDateTime.MAX), BlobField.UPDATED);
    }

    @Test
    public void blobInfo_field_customTime() {
      testBlobField(b -> b.setCustomTimeOffsetDateTime(OffsetDateTime.MAX), BlobField.CUSTOM_TIME);
    }

    @Test
    public void blobInfo_field_timeStorageClassUpdated() {
      testBlobField(
          b -> b.setTimeStorageClassUpdatedOffsetDateTime(OffsetDateTime.MAX),
          BlobField.TIME_STORAGE_CLASS_UPDATED);
    }

    @Test
    public void blobInfo_field_customerEncryption() {
      testBlobField(
          b -> b.setCustomerEncryption(new CustomerEncryption("alg", "sha")),
          BlobField.CUSTOMER_ENCRYPTION);
    }

    @Test
    public void blobInfo_field_blobId_changeBucketNameGeneration() {
      testBlobField(
          b -> b.setBlobId(BlobId.of("bucket2", "obj2", 3L)),
          BlobField.BUCKET,
          BlobField.NAME,
          BlobField.GENERATION);
    }

    @Test
    public void blobInfo_field_blobId_changeName() {
      testBlobField(b -> b.setBlobId(BlobId.of("bucket", "obj2")), BlobField.NAME);
    }

    @Test
    public void blobInfo_field_blobId_changeGeneration() {
      testBlobField(b -> b.setBlobId(BlobId.of("bucket", "obj-name", 3L)), BlobField.GENERATION);
    }

    private static void testBlobField(
        UnaryOperator<BlobInfo.Builder> f, NamedField... expectedModified) {
      BlobInfo actual1 = f.apply(base().toBuilder()).build();
      assertThat(actual1.getModifiedFields()).isEqualTo(ImmutableSet.copyOf(expectedModified));
      // verify that nothing is carried through from a previous state, and that setting the same
      // value does not mark it as modified.
      BlobInfo actual2 = f.apply(actual1.toBuilder()).build();
      assertThat(actual2.getModifiedFields()).isEqualTo(ImmutableSet.of());
    }

    private static BlobInfo base() {
      return BlobInfo.newBuilder("bucket", "obj-name").build();
    }
  }

  public static final class BucketInfoUpdateMask {

    @Test
    public void updateBucketRequest() throws Exception {
      Bucket expectedBucket =
          Bucket.newBuilder().setName(bucketNameCodec.encode("bucket")).putLabels("x", "X").build();
      UpdateBucketRequest expected =
          UpdateBucketRequest.newBuilder()
              .setBucket(expectedBucket)
              .setUpdateMask(FieldMask.newBuilder().addPaths("labels.x").build())
              .build();

      AtomicReference<UpdateBucketRequest> actualRequest = new AtomicReference<>();
      StorageImplBase service =
          new StorageImplBase() {
            @Override
            public void updateBucket(UpdateBucketRequest request, StreamObserver<Bucket> obs) {
              try {
                actualRequest.compareAndSet(null, request);
                obs.onNext(expectedBucket);
                obs.onCompleted();
              } catch (Exception e) {
                obs.onError(e);
              }
            }
          };

      try (FakeServer fake = FakeServer.of(service);
          Storage s = fake.getGrpcStorageOptions().getService()) {
        BucketInfo base = base();
        s.update(base.toBuilder().setLabels(ImmutableMap.of("x", "X")).build());
      }

      UpdateBucketRequest actual = actualRequest.get();
      assertThat(actual).isNotNull();
      assertThat(actual).isEqualTo(expected);
    }

    @Test
    public void bucketInfo_field_setOwner() {
      testBucketField(b -> b.setOwner(new User("x@y.z")), BucketField.OWNER);
    }

    @Test
    public void bucketInfo_field_setVersioningEnabled() {
      testBucketField(b -> b.setVersioningEnabled(true), BucketField.VERSIONING);
    }

    @Test
    public void bucketInfo_field_setRequesterPays() {
      testBucketField(b -> b.setRequesterPays(true), BucketField.BILLING);
    }

    @Test
    public void bucketInfo_field_setIndexPage() {
      testBucketField(b -> b.setIndexPage("i"), BucketField.WEBSITE);
    }

    @Test
    public void bucketInfo_field_setNotFoundPage() {
      testBucketField(b -> b.setNotFoundPage("n"), BucketField.WEBSITE);
    }

    @Test
    public void bucketInfo_field_setLifecycleRules() {
      testBucketField(
          b ->
              b.setLifecycleRules(
                  ImmutableList.of(
                      new LifecycleRule(
                          LifecycleAction.newDeleteAction(),
                          LifecycleCondition.newBuilder().setAge(1).build()))),
          BucketField.LIFECYCLE);
    }

    @Test
    public void bucketInfo_field_setRpo() {
      testBucketField(b -> b.setRpo(Rpo.ASYNC_TURBO), BucketField.RPO);
    }

    @Test
    public void bucketInfo_field_setStorageClass() {
      testBucketField(b -> b.setStorageClass(StorageClass.COLDLINE), BucketField.STORAGE_CLASS);
    }

    @Test
    public void bucketInfo_field_setLocation() {
      testBucketField(b -> b.setLocation("l"), BucketField.LOCATION);
    }

    @Test
    public void bucketInfo_field_setEtag() {
      testBucketField(b -> b.setEtag("e"), BucketField.ETAG);
    }

    @Test
    public void bucketInfo_field_setCreateTimeOffsetDateTime() {
      testBucketField(
          b -> b.setCreateTimeOffsetDateTime(OffsetDateTime.MAX), BucketField.TIME_CREATED);
    }

    @Test
    public void bucketInfo_field_setUpdateTimeOffsetDateTime() {
      testBucketField(b -> b.setUpdateTimeOffsetDateTime(OffsetDateTime.MAX), BucketField.UPDATED);
    }

    @Test
    public void bucketInfo_field_setCors() {
      testBucketField(
          b -> b.setCors(ImmutableList.of(Cors.newBuilder().setMaxAgeSeconds(2).build())),
          BucketField.CORS);
    }

    @Test
    public void bucketInfo_field_setAcl() {
      testBucketField(
          b -> b.setAcl(ImmutableList.of(Acl.of(new User("x@y.x"), Role.READER))), BucketField.ACL);
    }

    @Test
    public void bucketInfo_field_setDefaultAcl() {
      testBucketField(
          b -> b.setDefaultAcl(ImmutableList.of(Acl.of(new User("x@y.x"), Role.READER))),
          BucketField.DEFAULT_OBJECT_ACL);
    }

    @Test
    public void bucketInfo_field_setLabels() {
      testBucketField(
          b -> b.setLabels(ImmutableMap.of("x", "X")),
          NamedField.nested(BucketField.LABELS, NamedField.literal("x")));
    }

    @Test
    public void bucketInfo_field_setDefaultKmsKeyName() {
      testBucketField(b -> b.setDefaultKmsKeyName("k"), BucketField.ENCRYPTION);
    }

    @Test
    public void bucketInfo_field_setDefaultEventBasedHold() {
      testBucketField(b -> b.setDefaultEventBasedHold(true), BucketField.DEFAULT_EVENT_BASED_HOLD);
    }

    @Test
    public void bucketInfo_field_setRetentionEffectiveTimeOffsetDateTime() {
      testBucketField(
          b -> b.setRetentionEffectiveTimeOffsetDateTime(OffsetDateTime.MAX),
          BucketField.RETENTION_POLICY);
    }

    @Test
    public void bucketInfo_field_setRetentionPolicyIsLocked() {
      testBucketField(b -> b.setRetentionPolicyIsLocked(true), BucketField.RETENTION_POLICY);
    }

    @Test
    public void bucketInfo_field_setRetentionPeriodDuration() {
      testBucketField(
          b -> b.setRetentionPeriodDuration(Duration.ofDays(3)), BucketField.RETENTION_POLICY);
    }

    @Test
    public void bucketInfo_field_setIamConfiguration() {
      testBucketField(
          b ->
              b.setIamConfiguration(
                  IamConfiguration.newBuilder().setIsUniformBucketLevelAccessEnabled(true).build()),
          BucketField.IAMCONFIGURATION);
    }

    @Test
    public void bucketInfo_field_setLogging() {
      testBucketField(
          b -> b.setLogging(Logging.newBuilder().setLogBucket("bucket2").build()),
          BucketField.LOGGING);
    }

    @Test
    public void bucketInfo_field_setCustomPlacementConfig() {
      testBucketField(
          b ->
              b.setCustomPlacementConfig(
                  CustomPlacementConfig.newBuilder()
                      .setDataLocations(ImmutableList.of("a", "b"))
                      .build()),
          BucketField.CUSTOM_PLACEMENT_CONFIG);
    }

    @Test
    public void bucketInfo_field_setLocationType() {
      testBucketField(b -> b.setLocationType("l"), BucketField.LOCATION_TYPE);
    }

    private static void testBucketField(
        UnaryOperator<BucketInfo.Builder> f, NamedField... expectedModified) {
      BucketInfo actual1 = f.apply(base().toBuilder()).build();
      assertThat(actual1.getModifiedFields()).isEqualTo(ImmutableSet.copyOf(expectedModified));
      // verify that nothing is carried through from a previous state, and that setting the same
      // value does not mark it as modified.
      BucketInfo actual2 = f.apply(actual1.toBuilder()).build();
      assertThat(actual2.getModifiedFields()).isEqualTo(ImmutableSet.of());
    }

    private static BucketInfo base() {
      return BucketInfo.newBuilder("bucket").build();
    }
  }
}
