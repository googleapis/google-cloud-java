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

package com.google.cloud.storage.it;

import static com.google.common.truth.Truth.assertThat;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertTrue;

import com.google.api.gax.paging.Page;
import com.google.api.services.storage.model.Folder;
import com.google.cloud.Policy;
import com.google.cloud.storage.Blob;
import com.google.cloud.storage.BlobInfo;
import com.google.cloud.storage.Bucket;
import com.google.cloud.storage.BucketInfo;
import com.google.cloud.storage.BucketInfo.Autoclass;
import com.google.cloud.storage.BucketInfo.CustomPlacementConfig;
import com.google.cloud.storage.BucketInfo.ObjectRetention.Mode;
import com.google.cloud.storage.Cors;
import com.google.cloud.storage.HttpMethod;
import com.google.cloud.storage.Rpo;
import com.google.cloud.storage.Storage;
import com.google.cloud.storage.Storage.BlobField;
import com.google.cloud.storage.Storage.BlobTargetOption;
import com.google.cloud.storage.Storage.BucketField;
import com.google.cloud.storage.Storage.BucketGetOption;
import com.google.cloud.storage.Storage.BucketListOption;
import com.google.cloud.storage.Storage.BucketTargetOption;
import com.google.cloud.storage.StorageClass;
import com.google.cloud.storage.StorageOptions;
import com.google.cloud.storage.TestUtils;
import com.google.cloud.storage.TransportCompatibility.Transport;
import com.google.cloud.storage.it.runner.StorageITRunner;
import com.google.cloud.storage.it.runner.annotations.Backend;
import com.google.cloud.storage.it.runner.annotations.BucketFixture;
import com.google.cloud.storage.it.runner.annotations.BucketType;
import com.google.cloud.storage.it.runner.annotations.CrossRun;
import com.google.cloud.storage.it.runner.annotations.Inject;
import com.google.cloud.storage.it.runner.registry.Generator;
import com.google.cloud.storage.spi.v1.HttpStorageRpc;
import com.google.common.collect.ImmutableList;
import com.google.common.collect.ImmutableMap;
import java.time.Duration;
import java.time.OffsetDateTime;
import java.time.temporal.ChronoUnit;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.stream.StreamSupport;
import org.junit.Test;
import org.junit.runner.RunWith;

@RunWith(StorageITRunner.class)
@CrossRun(
    transports = {Transport.HTTP, Transport.GRPC},
    backends = {Backend.PROD})
public class ITBucketTest {

  private static final byte[] BLOB_BYTE_CONTENT = {0xD, 0xE, 0xA, 0xD};
  private static final Map<String, String> BUCKET_LABELS = ImmutableMap.of("label1", "value1");
  private static final Long RETENTION_PERIOD = 5L;
  private static final Duration RETENTION_DURATION = Duration.ofSeconds(5);

  @Inject
  @BucketFixture(BucketType.DEFAULT)
  public BucketInfo bucket;

  @Inject
  @BucketFixture(BucketType.REQUESTER_PAYS)
  public BucketInfo requesterPaysBucket;

  @Inject public Storage storage;
  @Inject public Generator generator;

  @Test
  public void testListBuckets() {
    Page<Bucket> page =
        storage.list(
            BucketListOption.prefix(bucket.getName()), BucketListOption.fields(BucketField.NAME));
    ImmutableList<String> bucketNames =
        StreamSupport.stream(page.iterateAll().spliterator(), false)
            .map(BucketInfo::getName)
            .collect(ImmutableList.toImmutableList());
    assertThat(bucketNames).contains(bucket.getName());
  }

  @Test
  public void testGetBucketSelectedFields() {
    Bucket remoteBucket =
        storage.get(bucket.getName(), Storage.BucketGetOption.fields(BucketField.ID));
    assertEquals(bucket.getName(), remoteBucket.getName());
    assertNull(remoteBucket.getCreateTime());
    assertNotNull(remoteBucket.getGeneratedId());
  }

  @Test
  public void testGetBucketAllSelectedFields() {
    Bucket remoteBucket =
        storage.get(
            bucket.getName(),
            Storage.BucketGetOption.fields(
                TestUtils.filterOutHttpOnlyBucketFields(BucketField.values())));
    assertEquals(bucket.getName(), remoteBucket.getName());
    assertNotNull(remoteBucket.getCreateTime());
  }

  @Test
  public void testBucketLocationType() throws Exception {
    String bucketName = generator.randomBucketName();
    BucketInfo bucketInfo = BucketInfo.newBuilder(bucketName).setLocation("us").build();
    try (TemporaryBucket tempB =
        TemporaryBucket.newBuilder().setBucketInfo(bucketInfo).setStorage(storage).build()) {
      BucketInfo bucket = tempB.getBucket();

      assertEquals("multi-region", bucket.getLocationType());
    }
  }

  @Test
  public void testBucketCustomPlacmentConfigDualRegion() throws Exception {
    String bucketName = generator.randomBucketName();
    List<String> locations = new ArrayList<>();
    locations.add("US-EAST1");
    locations.add("US-WEST1");
    CustomPlacementConfig customPlacementConfig =
        CustomPlacementConfig.newBuilder().setDataLocations(locations).build();
    BucketInfo bucketInfo =
        BucketInfo.newBuilder(bucketName)
            .setCustomPlacementConfig(customPlacementConfig)
            .setLocation("us")
            .build();
    try (TemporaryBucket tempB =
        TemporaryBucket.newBuilder().setBucketInfo(bucketInfo).setStorage(storage).build()) {
      BucketInfo bucket = tempB.getBucket();
      assertTrue(bucket.getCustomPlacementConfig().getDataLocations().contains("US-EAST1"));
      assertTrue(bucket.getCustomPlacementConfig().getDataLocations().contains("US-WEST1"));
      assertTrue(bucket.getLocation().equalsIgnoreCase("us"));
    }
  }

  @Test
  public void testBucketLogging() throws Exception {
    String logsBucketName = generator.randomBucketName();
    String loggingBucketName = generator.randomBucketName();

    BucketInfo logsBucketInfo = BucketInfo.newBuilder(logsBucketName).setLocation("us").build();
    BucketInfo loggingBucketInfo =
        BucketInfo.newBuilder(loggingBucketName)
            .setLocation("us")
            .setLogging(
                BucketInfo.Logging.newBuilder()
                    .setLogBucket(logsBucketName)
                    .setLogObjectPrefix("test-logs")
                    .build())
            .build();

    try (TemporaryBucket tempLogsB =
            TemporaryBucket.newBuilder().setBucketInfo(logsBucketInfo).setStorage(storage).build();
        TemporaryBucket tempLoggingB =
            TemporaryBucket.newBuilder()
                .setBucketInfo(loggingBucketInfo)
                .setStorage(storage)
                .build(); ) {
      BucketInfo logsBucket = tempLogsB.getBucket();
      BucketInfo loggingBucket = tempLoggingB.getBucket();
      assertNotNull(logsBucket);

      Policy policy = storage.getIamPolicy(logsBucketName);
      assertNotNull(policy);
      assertEquals(logsBucketName, loggingBucket.getLogging().getLogBucket());
      assertEquals("test-logs", loggingBucket.getLogging().getLogObjectPrefix());

      // Disable bucket logging.
      Bucket updatedBucket =
          storage.update(
              loggingBucket.toBuilder().setLogging(null).build(),
              BucketTargetOption.metagenerationMatch());
      assertNull(updatedBucket.getLogging());
    }
  }

  @Test
  public void testRemoveBucketCORS() {
    String bucketName = generator.randomBucketName();
    List<Cors.Origin> origins = ImmutableList.of(Cors.Origin.of("http://cloud.google.com"));
    List<HttpMethod> httpMethods = ImmutableList.of(HttpMethod.GET);
    List<String> responseHeaders = ImmutableList.of("Content-Type");
    try {
      Cors cors =
          Cors.newBuilder()
              .setOrigins(origins)
              .setMethods(httpMethods)
              .setResponseHeaders(responseHeaders)
              .setMaxAgeSeconds(100)
              .build();
      // GRPC creation bug
      storage.create(BucketInfo.newBuilder(bucketName).setCors(ImmutableList.of(cors)).build());

      // case-1 : Cors are set and field selector is selected then returns not-null.
      Bucket remoteBucket =
          storage.get(bucketName, Storage.BucketGetOption.fields(BucketField.CORS));
      assertThat(remoteBucket.getCors()).isNotNull();
      assertThat(remoteBucket.getCors().get(0).getMaxAgeSeconds()).isEqualTo(100);
      assertThat(remoteBucket.getCors().get(0).getMethods()).isEqualTo(httpMethods);
      assertThat(remoteBucket.getCors().get(0).getOrigins()).isEqualTo(origins);
      assertThat(remoteBucket.getCors().get(0).getResponseHeaders()).isEqualTo(responseHeaders);

      // case-2 : Cors are set but field selector isn't selected then returns not-null.
      remoteBucket = storage.get(bucketName);
      assertThat(remoteBucket.getCors()).isNotNull();

      // Remove CORS configuration from the bucket.
      Bucket updatedBucket = remoteBucket.toBuilder().setCors(null).build().update();
      assertThat(updatedBucket.getCors()).isNull();

      // case-3 : Cors are not set and field selector is selected then returns null.
      updatedBucket = storage.get(bucketName, Storage.BucketGetOption.fields(BucketField.CORS));

      assertThat(updatedBucket.getCors()).isNull();

      // case-4 : Cors are not set and field selector isn't selected then returns null.
      updatedBucket = storage.get(bucketName);
      assertThat(updatedBucket.getCors()).isNull();

    } finally {
      BucketCleaner.doCleanup(bucketName, storage);
    }
  }

  @Test
  public void testRpoConfig() {
    String rpoBucket = generator.randomBucketName();
    try {
      Bucket bucket =
          storage.create(
              BucketInfo.newBuilder(rpoBucket).setLocation("NAM4").setRpo(Rpo.ASYNC_TURBO).build());
      assertEquals("ASYNC_TURBO", bucket.getRpo().toString());

      bucket.toBuilder().setRpo(Rpo.DEFAULT).build().update();

      assertEquals("DEFAULT", storage.get(rpoBucket).getRpo().toString());
    } finally {
      BucketCleaner.doCleanup(rpoBucket, storage);
    }
  }

  @Test
  public void testRetentionPolicyLock() {
    retentionPolicyLockRequesterPays(false);
  }

  @Test
  public void testRetentionPolicyLockRequesterPays() {
    retentionPolicyLockRequesterPays(true);
  }

  private void retentionPolicyLockRequesterPays(boolean requesterPays) {
    String projectId = storage.getOptions().getProjectId();
    String bucketName = generator.randomBucketName();
    BucketInfo bucketInfo;
    if (requesterPays) {
      bucketInfo =
          BucketInfo.newBuilder(bucketName)
              .setRetentionPeriod(RETENTION_PERIOD)
              .setRequesterPays(true)
              .build();
    } else {
      bucketInfo = BucketInfo.newBuilder(bucketName).setRetentionPeriod(RETENTION_PERIOD).build();
    }
    Bucket remoteBucket = storage.create(bucketInfo);
    assertThat(remoteBucket.getRetentionPeriod()).isEqualTo(RETENTION_PERIOD);
    assertThat(remoteBucket.getRetentionPeriodDuration()).isEqualTo(RETENTION_DURATION);
    try {
      // in json if the bucket retention policy is not locked null is possible, however in grpc
      // there is no distinguishment between unset and false.
      assertThat(remoteBucket.retentionPolicyIsLocked()).isAnyOf(null, false);
      assertNotNull(remoteBucket.getRetentionEffectiveTime());
      assertNotNull(remoteBucket.getMetageneration());
      if (requesterPays) {
        remoteBucket =
            storage.lockRetentionPolicy(
                remoteBucket,
                Storage.BucketTargetOption.metagenerationMatch(),
                Storage.BucketTargetOption.userProject(projectId));
      } else {
        remoteBucket =
            storage.lockRetentionPolicy(
                remoteBucket, Storage.BucketTargetOption.metagenerationMatch());
      }
      assertTrue(remoteBucket.retentionPolicyIsLocked());
      assertNotNull(remoteBucket.getRetentionEffectiveTime());
    } finally {
      if (requesterPays) {
        bucketInfo = bucketInfo.toBuilder().setRequesterPays(false).build();
        Bucket updateBucket =
            storage.update(bucketInfo, Storage.BucketTargetOption.userProject(projectId));
        assertFalse(updateBucket.requesterPays());
      }
      BucketCleaner.doCleanup(bucketName, storage);
    }
  }

  @Test
  public void testEnableDisableBucketDefaultEventBasedHold() {
    String bucketName = generator.randomBucketName();
    Bucket remoteBucket =
        storage.create(BucketInfo.newBuilder(bucketName).setDefaultEventBasedHold(true).build());
    try {
      assertTrue(remoteBucket.getDefaultEventBasedHold());
      remoteBucket =
          storage.get(
              bucketName,
              Storage.BucketGetOption.fields(
                  BucketField.DEFAULT_EVENT_BASED_HOLD, BucketField.METAGENERATION));
      assertTrue(remoteBucket.getDefaultEventBasedHold());
      String blobName = generator.randomObjectName();
      BlobInfo blobInfo = BlobInfo.newBuilder(bucketName, blobName).build();
      Blob remoteBlob = storage.create(blobInfo, BlobTargetOption.doesNotExist());
      assertTrue(remoteBlob.getEventBasedHold());
      remoteBlob =
          storage.get(
              blobInfo.getBlobId(),
              Storage.BlobGetOption.fields(BlobField.EVENT_BASED_HOLD, BlobField.METAGENERATION));
      assertTrue(remoteBlob.getEventBasedHold());
      remoteBlob =
          remoteBlob.toBuilder()
              .setEventBasedHold(false)
              .build()
              .update(BlobTargetOption.metagenerationMatch());
      assertFalse(remoteBlob.getEventBasedHold());
      remoteBucket =
          remoteBucket.toBuilder()
              .setDefaultEventBasedHold(false)
              .build()
              .update(BucketTargetOption.metagenerationMatch());
      assertFalse(remoteBucket.getDefaultEventBasedHold());
    } finally {
      BucketCleaner.doCleanup(bucketName, storage);
    }
  }

  @Test
  public void testCreateBucketWithAutoclass() {
    String bucketName = generator.randomBucketName();
    storage.create(
        BucketInfo.newBuilder(bucketName)
            .setAutoclass(Autoclass.newBuilder().setEnabled(true).build())
            .build());
    try {
      Bucket remoteBucket = storage.get(bucketName);

      assertNotNull(remoteBucket.getAutoclass());
      assertTrue(remoteBucket.getAutoclass().getEnabled());
      OffsetDateTime time = remoteBucket.getAutoclass().getToggleTime();
      assertNotNull(time);

      remoteBucket.toBuilder()
          .setAutoclass(Autoclass.newBuilder().setEnabled(false).build())
          .build()
          .update();

      remoteBucket = storage.get(bucketName);
      assertNotNull(remoteBucket.getAutoclass());
      assertFalse(remoteBucket.getAutoclass().getEnabled());
      assertNotNull(remoteBucket.getAutoclass().getToggleTime());
      assertNotEquals(time, remoteBucket.getAutoclass().getToggleTime());
    } finally {
      BucketCleaner.doCleanup(bucketName, storage);
    }
  }

  @Test
  @CrossRun.Exclude(transports = Transport.GRPC)
  public void testObjectRetention() {
    String bucketName = generator.randomBucketName();

    // Create a bucket with object retention enabled
    storage.create(
        BucketInfo.newBuilder(bucketName).build(), BucketTargetOption.enableObjectRetention(true));

    try {
      Bucket remoteBucket = storage.get(bucketName);
      assertNotNull(remoteBucket.getObjectRetention());
      assertEquals(Mode.ENABLED, remoteBucket.getObjectRetention().getMode());

      OffsetDateTime now = OffsetDateTime.now();

      // Create an object with a retention policy configured
      storage.create(
          BlobInfo.newBuilder(bucketName, "retentionObject")
              .setRetention(
                  BlobInfo.Retention.newBuilder()
                      .setMode(BlobInfo.Retention.Mode.UNLOCKED)
                      .setRetainUntilTime(now.plusDays(2))
                      .build())
              .build());

      Blob remoteBlob = storage.get(bucketName, "retentionObject");
      assertNotNull(remoteBlob.getRetention());
      assertEquals(BlobInfo.Retention.Mode.UNLOCKED, remoteBlob.getRetention().getMode());

      // Reduce the retainUntilTime of an object's retention policy
      remoteBlob.toBuilder()
          .setRetention(
              BlobInfo.Retention.newBuilder()
                  .setMode(BlobInfo.Retention.Mode.UNLOCKED)
                  .setRetainUntilTime(now.plusHours(1))
                  .build())
          .build()
          .update(
              Storage.BlobTargetOption.overrideUnlockedRetention(true),
              BlobTargetOption.metagenerationMatch());

      remoteBlob = storage.get(bucketName, "retentionObject");
      assertEquals(
          now.plusHours(1).toInstant().truncatedTo(ChronoUnit.SECONDS),
          remoteBlob
              .getRetention()
              .getRetainUntilTime()
              .toInstant()
              .truncatedTo(ChronoUnit.SECONDS));

      // Remove an unlocked retention policy
      remoteBlob.toBuilder()
          .setRetention(null)
          .build()
          .update(
              Storage.BlobTargetOption.overrideUnlockedRetention(true),
              BlobTargetOption.metagenerationMatch());

      remoteBlob = storage.get(bucketName, "retentionObject");
      assertNull(remoteBlob.getRetention());
    } finally {
      BucketCleaner.doCleanup(bucketName, storage);
    }
  }

  public void testCreateBucketWithAutoclass_ARCHIVE() throws Exception {
    String bucketName = generator.randomBucketName();
    Autoclass autoclass =
        Autoclass.newBuilder()
            .setEnabled(true)
            .setTerminalStorageClass(StorageClass.ARCHIVE)
            .build();
    BucketInfo info = BucketInfo.newBuilder(bucketName).setAutoclass(autoclass).build();
    try (TemporaryBucket tmpb =
        TemporaryBucket.newBuilder().setStorage(storage).setBucketInfo(info).build()) {
      BucketInfo remoteBucket = tmpb.getBucket();

      Autoclass remoteBucketAutoclass = remoteBucket.getAutoclass();
      assertThat(remoteBucketAutoclass).isNotNull();
      assertThat(remoteBucketAutoclass.getEnabled()).isTrue();
      assertThat(remoteBucketAutoclass.getToggleTime()).isNotNull();
      assertThat(remoteBucketAutoclass.getTerminalStorageClassUpdateTime()).isNotNull();
      assertThat(remoteBucketAutoclass.getTerminalStorageClass()).isEqualTo(StorageClass.ARCHIVE);

      Page<Bucket> bucketPage = storage.list(BucketListOption.prefix(bucketName));
      ImmutableList<Bucket> buckets = ImmutableList.copyOf(bucketPage.iterateAll());

      Optional<Bucket> first =
          buckets.stream().filter(b -> bucketName.equals(b.getName())).findFirst();

      assertThat(first.isPresent()).isTrue();
      assertThat(first.get().getAutoclass().getTerminalStorageClass())
          .isEqualTo(StorageClass.ARCHIVE);

      BucketInfo disabled =
          remoteBucket.toBuilder()
              .setAutoclass(Autoclass.newBuilder().setEnabled(false).build())
              .build();
      Bucket updated = storage.update(disabled, BucketTargetOption.metagenerationMatch());

      Autoclass updatedAutoclass = updated.getAutoclass();
      assertThat(updatedAutoclass.getEnabled()).isFalse();
      assertThat(updatedAutoclass.getTerminalStorageClass()).isNull();

      assertThat(updatedAutoclass).isNotEqualTo(remoteBucketAutoclass);
    }
  }

  @Test
  public void testUpdateBucket_noModification() throws Exception {
    String bucketName = generator.randomBucketName();
    BucketInfo bucketInfo = BucketInfo.newBuilder(bucketName).build();
    try (TemporaryBucket tempB =
        TemporaryBucket.newBuilder().setBucketInfo(bucketInfo).setStorage(storage).build()) {
      // in grpc, create will return acls but update does not. re-get the metadata with default
      // fields
      BucketInfo bucket = tempB.getBucket();
      Bucket gen1 =
          storage.get(
              bucket.getName(), BucketGetOption.metagenerationMatch(bucket.getMetageneration()));

      Bucket gen2 = storage.update(gen1, BucketTargetOption.metagenerationMatch());
      assertThat(gen2).isEqualTo(gen1);
    }
  }

  @Test
  public void nonExistentBucketReturnsNull() {
    Bucket bucket = storage.get(generator.randomBucketName());
    assertThat(bucket).isNull();
  }

  @Test
  public void testSoftDeletePolicy() {
    String bucketName = generator.randomBucketName();
    BucketInfo bucketInfo =
        BucketInfo.newBuilder(bucketName)
            .setSoftDeletePolicy(
                BucketInfo.SoftDeletePolicy.newBuilder()
                    .setRetentionDuration(Duration.ofDays(10))
                    .build())
            .build();
    try {
      storage.create(bucketInfo);

      Bucket remoteBucket = storage.get(bucketName);
      assertEquals(Duration.ofDays(10), remoteBucket.getSoftDeletePolicy().getRetentionDuration());
      assertNotNull(remoteBucket.getSoftDeletePolicy().getEffectiveTime());

      String softDelBlobName = "softdelblob";
      remoteBucket.create(softDelBlobName, BLOB_BYTE_CONTENT);

      Blob blob = remoteBucket.get(softDelBlobName);
      long gen = blob.getGeneration();

      assertNull(blob.getSoftDeleteTime());
      assertNull(blob.getHardDeleteTime());

      blob.delete();

      assertNull(remoteBucket.get(softDelBlobName));

      ImmutableList<Blob> softDeletedBlobs =
          ImmutableList.copyOf(
              remoteBucket.list(Storage.BlobListOption.softDeleted(true)).iterateAll());
      assertThat(softDeletedBlobs.size() > 0);

      Blob softDeletedBlob =
          remoteBucket.get(softDelBlobName, gen, Storage.BlobGetOption.softDeleted(true));

      assertNotNull(softDeletedBlob);
      assertNotNull(softDeletedBlob.getSoftDeleteTime());
      assertNotNull(softDeletedBlob.getHardDeleteTime());

      assertNotNull(storage.restore(softDeletedBlob.getBlobId()));

      remoteBucket.toBuilder()
          .setSoftDeletePolicy(
              BucketInfo.SoftDeletePolicy.newBuilder()
                  .setRetentionDuration(Duration.ofDays(20))
                  .build())
          .build()
          .update(BucketTargetOption.metagenerationMatch());

      assertEquals(
          Duration.ofDays(20),
          storage.get(bucketName).getSoftDeletePolicy().getRetentionDuration());
    } finally {
      BucketCleaner.doCleanup(bucketName, storage);
    }
  }

  @Test
  public void createBucketWithHierarchicalNamespace() {
    String bucketName = generator.randomBucketName();
    storage.create(
        BucketInfo.newBuilder(bucketName)
            .setHierarchicalNamespace(
                BucketInfo.HierarchicalNamespace.newBuilder().setEnabled(true).build())
            .setIamConfiguration(
                BucketInfo.IamConfiguration.newBuilder()
                    .setIsUniformBucketLevelAccessEnabled(true)
                    .build())
            .build());
    try {
      Bucket remoteBucket = storage.get(bucketName);
      assertNotNull(remoteBucket.getHierarchicalNamespace());
      assertTrue(remoteBucket.getHierarchicalNamespace().getEnabled());
    } finally {
      BucketCleaner.doCleanup(bucketName, storage);
    }
  }

  @Test
  public void testListObjectsWithFolders() throws Exception {
    String bucketName = generator.randomBucketName();
    storage.create(
        BucketInfo.newBuilder(bucketName)
            .setHierarchicalNamespace(
                BucketInfo.HierarchicalNamespace.newBuilder().setEnabled(true).build())
            .setIamConfiguration(
                BucketInfo.IamConfiguration.newBuilder()
                    .setIsUniformBucketLevelAccessEnabled(true)
                    .build())
            .build());
    try {
      com.google.api.services.storage.Storage apiaryStorage =
          new HttpStorageRpc(StorageOptions.getDefaultInstance()).getStorage();
      apiaryStorage
          .folders()
          .insert(bucketName, new Folder().setName("F").setBucket(bucketName))
          .execute();

      Page<Blob> blobs =
          storage.list(
              bucketName,
              Storage.BlobListOption.delimiter("/"),
              Storage.BlobListOption.includeFolders(false));

      boolean found = false;
      for (Blob blob : blobs.iterateAll()) {
        if (blob.getName().equals("F/")) {
          found = true;
        }
      }
      assert (!found);

      blobs =
          storage.list(
              bucketName,
              Storage.BlobListOption.delimiter("/"),
              Storage.BlobListOption.includeFolders(true));

      for (Blob blob : blobs.iterateAll()) {
        if (blob.getName().equals("F/")) {
          found = true;
        }
      }
      assert (found);

    } finally {
      BucketCleaner.doCleanup(bucketName, storage);
    }
  }
}
