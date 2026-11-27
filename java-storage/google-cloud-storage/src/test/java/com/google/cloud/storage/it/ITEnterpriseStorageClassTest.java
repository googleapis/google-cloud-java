/*
 * Copyright 2026 Google LLC
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
import static java.nio.charset.StandardCharsets.UTF_8;
import static org.junit.Assert.assertThrows;
import static org.junit.Assume.assumeTrue;

import com.google.cloud.WriteChannel;
import com.google.cloud.storage.Blob;
import com.google.cloud.storage.BlobId;
import com.google.cloud.storage.BlobInfo;
import com.google.cloud.storage.Bucket;
import com.google.cloud.storage.BucketInfo;
import com.google.cloud.storage.BucketInfo.Autoclass;
import com.google.cloud.storage.BucketInfo.HierarchicalNamespace;
import com.google.cloud.storage.BucketInfo.IamConfiguration;
import com.google.cloud.storage.BucketInfo.LifecycleRule;
import com.google.cloud.storage.BucketInfo.LifecycleRule.DeleteLifecycleAction;
import com.google.cloud.storage.BucketInfo.LifecycleRule.LifecycleAction;
import com.google.cloud.storage.BucketInfo.LifecycleRule.LifecycleCondition;
import com.google.cloud.storage.BucketInfo.LifecycleRule.SetStorageClassLifecycleAction;
import com.google.cloud.storage.BucketInfo.SoftDeletePolicy;
import com.google.cloud.storage.Storage;
import com.google.cloud.storage.Storage.BlobSourceOption;
import com.google.cloud.storage.Storage.BlobTargetOption;
import com.google.cloud.storage.Storage.BlobWriteOption;
import com.google.cloud.storage.Storage.BucketTargetOption;
import com.google.cloud.storage.Storage.ComposeRequest;
import com.google.cloud.storage.Storage.CopyRequest;
import com.google.cloud.storage.Storage.MoveBlobRequest;
import com.google.cloud.storage.StorageClass;
import com.google.cloud.storage.StorageException;
import com.google.cloud.storage.TransportCompatibility.Transport;
import com.google.cloud.storage.it.runner.StorageITRunner;
import com.google.cloud.storage.it.runner.annotations.Backend;
import com.google.cloud.storage.it.runner.annotations.CrossRun;
import com.google.cloud.storage.it.runner.annotations.Inject;
import com.google.cloud.storage.it.runner.registry.Generator;
import com.google.common.base.MoreObjects;
import com.google.common.collect.ImmutableList;
import java.nio.ByteBuffer;
import java.time.Duration;
import java.util.List;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;

/**
 * End-to-end integration tests for GCS Enterprise storage classes ({@link
 * StorageClass#STANDARD_ENTERPRISE}, {@link StorageClass#LR_STANDARD_ENTERPRISE}, and {@link
 * StorageClass#STANDARD_FLEXBACKUP_ENTERPRISE}) across both HTTP (JSON) and gRPC transports.
 *
 * <p>Requires a project allowlisted for Enterprise storage classes and opt-in activation via the
 * {@code GOOGLE_CLOUD_JAVA_TEST_ENTERPRISE} system property or environment variable set to {@code
 * true} or {@code 1}.
 */
@RunWith(StorageITRunner.class)
@CrossRun(
    transports = {Transport.HTTP, Transport.GRPC},
    backends = {Backend.PROD})
public final class ITEnterpriseStorageClassTest {

  private static final String ENABLE_ENV = "GOOGLE_CLOUD_JAVA_TEST_ENTERPRISE";
  private static final String REGIONAL_LOCATION = "us-central1";
  private static final String MULTI_REGIONAL_LOCATION = "us";
  private static final byte[] PAYLOAD =
      "enterprise storage class end-to-end verification payload".getBytes(UTF_8);

  @Inject public Storage storage;
  @Inject public Generator generator;

  @Before
  public void setUp() {
    String enabled = MoreObjects.firstNonNull(System.getProperty(ENABLE_ENV), "");
    if (enabled.isEmpty()) {
      enabled = MoreObjects.firstNonNull(System.getenv(ENABLE_ENV), "");
    }
    assumeTrue(
        "Skipping Enterprise storage class integration tests; set "
            + ENABLE_ENV
            + "=true on an allowlisted project to enable.",
        "true".equalsIgnoreCase(enabled) || "1".equals(enabled));
  }

  @Test
  public void createBucketWithStandardEnterprise_andObjectOperations() throws Exception {
    String bucketName = generator.randomBucketName();
    BucketInfo bucketInfo =
        BucketInfo.newBuilder(bucketName)
            .setLocation(REGIONAL_LOCATION)
            .setStorageClass(StorageClass.STANDARD_ENTERPRISE)
            .setSoftDeletePolicy(
                SoftDeletePolicy.newBuilder().setRetentionDuration(Duration.ofDays(7)).build())
            .build();

    try (TemporaryBucket tempBucket =
        TemporaryBucket.newBuilder().setBucketInfo(bucketInfo).setStorage(storage).build()) {
      BucketInfo createdBucket = tempBucket.getBucket();
      assertThat(createdBucket.getStorageClass()).isEqualTo(StorageClass.STANDARD_ENTERPRISE);
      assertThat(storage.get(bucketName).getStorageClass())
          .isEqualTo(StorageClass.STANDARD_ENTERPRISE);

      // Update bucket default storage class: STANDARD_ENTERPRISE -> LR_STANDARD_ENTERPRISE ->
      // STANDARD_ENTERPRISE
      Bucket patchedLr =
          storage.update(
              createdBucket.toBuilder()
                  .setStorageClass(StorageClass.LR_STANDARD_ENTERPRISE)
                  .build(),
              BucketTargetOption.metagenerationMatch());
      assertThat(patchedLr.getStorageClass()).isEqualTo(StorageClass.LR_STANDARD_ENTERPRISE);

      Bucket patchedSe =
          storage.update(
              patchedLr.toBuilder().setStorageClass(StorageClass.STANDARD_ENTERPRISE).build(),
              BucketTargetOption.metagenerationMatch());
      assertThat(patchedSe.getStorageClass()).isEqualTo(StorageClass.STANDARD_ENTERPRISE);

      // Simple upload inheriting bucket default storage class (STANDARD_ENTERPRISE)
      String inheritedName = generator.randomObjectName();
      Blob inheritedBlob =
          storage.create(
              BlobInfo.newBuilder(bucketName, inheritedName).setContentType("text/plain").build(),
              PAYLOAD,
              BlobTargetOption.doesNotExist());
      assertThat(inheritedBlob.getStorageClass()).isEqualTo(StorageClass.STANDARD_ENTERPRISE);
      assertThat(storage.readAllBytes(inheritedBlob.getBlobId())).isEqualTo(PAYLOAD);

      // Upload with explicit per-object storage class override (LR_STANDARD_ENTERPRISE)
      String explicitLrName = generator.randomObjectName();
      Blob explicitLrBlob =
          storage.create(
              BlobInfo.newBuilder(bucketName, explicitLrName)
                  .setContentType("text/plain")
                  .setStorageClass(StorageClass.LR_STANDARD_ENTERPRISE)
                  .build(),
              PAYLOAD,
              BlobTargetOption.doesNotExist());
      assertThat(explicitLrBlob.getStorageClass()).isEqualTo(StorageClass.LR_STANDARD_ENTERPRISE);
      assertThat(storage.get(explicitLrBlob.getBlobId()).getStorageClass())
          .isEqualTo(StorageClass.LR_STANDARD_ENTERPRISE);

      // Resumable upload with explicit STANDARD_ENTERPRISE storage class
      String resumableName = generator.randomObjectName();
      BlobInfo resumableInfo =
          BlobInfo.newBuilder(bucketName, resumableName)
              .setContentType("text/plain")
              .setStorageClass(StorageClass.STANDARD_ENTERPRISE)
              .build();
      try (WriteChannel writer = storage.writer(resumableInfo, BlobWriteOption.doesNotExist())) {
        writer.write(ByteBuffer.wrap(PAYLOAD));
      }
      Blob resumableBlob = storage.get(bucketName, resumableName);
      assertThat(resumableBlob.getStorageClass()).isEqualTo(StorageClass.STANDARD_ENTERPRISE);
      assertThat(storage.readAllBytes(resumableBlob.getBlobId())).isEqualTo(PAYLOAD);

      // In-place rewrite: STANDARD_ENTERPRISE -> LR_STANDARD_ENTERPRISE -> STANDARD ->
      // STANDARD_ENTERPRISE
      BlobId inheritedId = BlobId.of(bucketName, inheritedName);
      Blob rewrittenLr =
          storage
              .copy(
                  CopyRequest.newBuilder()
                      .setSource(inheritedId)
                      .setTarget(
                          BlobInfo.newBuilder(inheritedId)
                              .setStorageClass(StorageClass.LR_STANDARD_ENTERPRISE)
                              .build(),
                          BlobTargetOption.generationMatch(inheritedBlob.getGeneration()))
                      .build())
              .getResult();
      assertThat(rewrittenLr.getStorageClass()).isEqualTo(StorageClass.LR_STANDARD_ENTERPRISE);

      Blob rewrittenStandard =
          storage
              .copy(
                  CopyRequest.newBuilder()
                      .setSource(inheritedId)
                      .setTarget(
                          BlobInfo.newBuilder(inheritedId)
                              .setStorageClass(StorageClass.STANDARD)
                              .build(),
                          BlobTargetOption.generationMatch(rewrittenLr.getGeneration()))
                      .build())
              .getResult();
      assertThat(rewrittenStandard.getStorageClass()).isEqualTo(StorageClass.STANDARD);

      Blob rewrittenSe =
          storage
              .copy(
                  CopyRequest.newBuilder()
                      .setSource(inheritedId)
                      .setTarget(
                          BlobInfo.newBuilder(inheritedId)
                              .setStorageClass(StorageClass.STANDARD_ENTERPRISE)
                              .build(),
                          BlobTargetOption.generationMatch(rewrittenStandard.getGeneration()))
                      .build())
              .getResult();
      assertThat(rewrittenSe.getStorageClass()).isEqualTo(StorageClass.STANDARD_ENTERPRISE);

      // Compose two objects into a destination object with STANDARD_ENTERPRISE
      String composedName = generator.randomObjectName();
      Blob composedBlob =
          storage.compose(
              ComposeRequest.of(
                  ImmutableList.of(inheritedName, resumableName),
                  BlobInfo.newBuilder(bucketName, composedName)
                      .setContentType("text/plain")
                      .setStorageClass(StorageClass.STANDARD_ENTERPRISE)
                      .build()));
      assertThat(composedBlob.getStorageClass()).isEqualTo(StorageClass.STANDARD_ENTERPRISE);
      assertThat(composedBlob.getSize()).isEqualTo(PAYLOAD.length * 2L);

      // Move object and verify LR_STANDARD_ENTERPRISE is preserved
      String movedName = generator.randomObjectName();
      Blob movedBlob =
          storage.moveBlob(
              MoveBlobRequest.newBuilder()
                  .setSource(explicitLrBlob.getBlobId())
                  .setTarget(BlobId.of(bucketName, movedName))
                  .setSourceOptions(BlobSourceOption.generationMatch())
                  .setTargetOptions(BlobTargetOption.doesNotExist())
                  .build());
      assertThat(movedBlob.getStorageClass()).isEqualTo(StorageClass.LR_STANDARD_ENTERPRISE);

      // Soft-delete and restore object, verifying Enterprise storage class is preserved
      BlobId movedBlobIdWithGen = movedBlob.getBlobId();
      assertThat(storage.delete(movedBlobIdWithGen)).isTrue();
      Blob restoredBlob = storage.restore(movedBlobIdWithGen);
      assertThat(restoredBlob.getStorageClass()).isEqualTo(StorageClass.LR_STANDARD_ENTERPRISE);
      assertThat(storage.readAllBytes(restoredBlob.getBlobId())).isEqualTo(PAYLOAD);
    }
  }

  @Test
  public void createBucketWithLrStandardEnterprise() throws Exception {
    String bucketName = generator.randomBucketName();
    BucketInfo bucketInfo =
        BucketInfo.newBuilder(bucketName)
            .setLocation(REGIONAL_LOCATION)
            .setStorageClass(StorageClass.LR_STANDARD_ENTERPRISE)
            .build();

    try (TemporaryBucket tempBucket =
        TemporaryBucket.newBuilder().setBucketInfo(bucketInfo).setStorage(storage).build()) {
      assertThat(tempBucket.getBucket().getStorageClass())
          .isEqualTo(StorageClass.LR_STANDARD_ENTERPRISE);

      String objectName = generator.randomObjectName();
      Blob uploaded =
          storage.create(
              BlobInfo.newBuilder(bucketName, objectName).build(),
              PAYLOAD,
              BlobTargetOption.doesNotExist());
      assertThat(uploaded.getStorageClass()).isEqualTo(StorageClass.LR_STANDARD_ENTERPRISE);
      assertThat(storage.get(uploaded.getBlobId()).getStorageClass())
          .isEqualTo(StorageClass.LR_STANDARD_ENTERPRISE);
      assertThat(storage.readAllBytes(uploaded.getBlobId())).isEqualTo(PAYLOAD);
    }
  }

  @Test
  public void createBucketWithStandardFlexbackupEnterprise() throws Exception {
    String bucketName = generator.randomBucketName();
    BucketInfo bucketInfo =
        BucketInfo.newBuilder(bucketName)
            .setLocation(MULTI_REGIONAL_LOCATION)
            .setStorageClass(StorageClass.STANDARD_FLEXBACKUP_ENTERPRISE)
            .build();

    try (TemporaryBucket tempBucket =
        TemporaryBucket.newBuilder().setBucketInfo(bucketInfo).setStorage(storage).build()) {
      assertThat(tempBucket.getBucket().getStorageClass())
          .isEqualTo(StorageClass.STANDARD_FLEXBACKUP_ENTERPRISE);

      String objectName = generator.randomObjectName();
      Blob uploaded =
          storage.create(
              BlobInfo.newBuilder(bucketName, objectName).build(),
              PAYLOAD,
              BlobTargetOption.doesNotExist());
      assertThat(uploaded.getStorageClass()).isEqualTo(StorageClass.STANDARD_FLEXBACKUP_ENTERPRISE);
      assertThat(storage.get(uploaded.getBlobId()).getStorageClass())
          .isEqualTo(StorageClass.STANDARD_FLEXBACKUP_ENTERPRISE);
      assertThat(storage.readAllBytes(uploaded.getBlobId())).isEqualTo(PAYLOAD);
    }
  }

  @Test
  public void createHnsBucketWithStandardEnterprise() throws Exception {
    String bucketName = generator.randomBucketName();
    BucketInfo bucketInfo =
        BucketInfo.newBuilder(bucketName)
            .setLocation(REGIONAL_LOCATION)
            .setStorageClass(StorageClass.STANDARD_ENTERPRISE)
            .setHierarchicalNamespace(HierarchicalNamespace.newBuilder().setEnabled(true).build())
            .setIamConfiguration(
                IamConfiguration.newBuilder().setIsUniformBucketLevelAccessEnabled(true).build())
            .build();

    try (TemporaryBucket tempBucket =
        TemporaryBucket.newBuilder().setBucketInfo(bucketInfo).setStorage(storage).build()) {
      BucketInfo created = tempBucket.getBucket();
      assertThat(created.getStorageClass()).isEqualTo(StorageClass.STANDARD_ENTERPRISE);
      assertThat(created.getHierarchicalNamespace().getEnabled()).isTrue();

      String objectName = generator.randomObjectName();
      Blob uploaded =
          storage.create(
              BlobInfo.newBuilder(bucketName, objectName).build(),
              PAYLOAD,
              BlobTargetOption.doesNotExist());
      assertThat(uploaded.getStorageClass()).isEqualTo(StorageClass.STANDARD_ENTERPRISE);
      assertThat(storage.readAllBytes(uploaded.getBlobId())).isEqualTo(PAYLOAD);
    }
  }

  @Test
  public void configureLifecycleRulesWithEnterpriseStorageClasses() throws Exception {
    String bucketName = generator.randomBucketName();
    ImmutableList<LifecycleRule> rules =
        ImmutableList.of(
            new LifecycleRule(
                LifecycleAction.newSetStorageClassAction(StorageClass.STANDARD_ENTERPRISE),
                LifecycleCondition.newBuilder()
                    .setAge(10)
                    .setMatchesStorageClass(ImmutableList.of(StorageClass.STANDARD))
                    .build()),
            new LifecycleRule(
                LifecycleAction.newSetStorageClassAction(StorageClass.LR_STANDARD_ENTERPRISE),
                LifecycleCondition.newBuilder()
                    .setAge(20)
                    .setMatchesStorageClass(
                        ImmutableList.of(
                            StorageClass.STANDARD,
                            StorageClass.valueOf("LR_STANDARD"),
                            StorageClass.STANDARD_ENTERPRISE))
                    .build()),
            new LifecycleRule(
                LifecycleAction.newDeleteAction(),
                LifecycleCondition.newBuilder()
                    .setAge(30)
                    .setMatchesStorageClass(
                        ImmutableList.of(
                            StorageClass.STANDARD_ENTERPRISE, StorageClass.LR_STANDARD_ENTERPRISE))
                    .build()));

    BucketInfo bucketInfo =
        BucketInfo.newBuilder(bucketName)
            .setLocation(REGIONAL_LOCATION)
            .setStorageClass(StorageClass.STANDARD_ENTERPRISE)
            .setLifecycleRules(rules)
            .build();

    try (TemporaryBucket tempBucket =
        TemporaryBucket.newBuilder().setBucketInfo(bucketInfo).setStorage(storage).build()) {
      List<? extends LifecycleRule> remoteRules = tempBucket.getBucket().getLifecycleRules();
      assertThat(remoteRules).hasSize(3);

      LifecycleRule rule0 = remoteRules.get(0);
      assertThat(rule0.getAction().getActionType()).isEqualTo(SetStorageClassLifecycleAction.TYPE);
      assertThat(((SetStorageClassLifecycleAction) rule0.getAction()).getStorageClass())
          .isEqualTo(StorageClass.STANDARD_ENTERPRISE);
      assertThat(rule0.getCondition().getMatchesStorageClass())
          .containsExactly(StorageClass.STANDARD);

      LifecycleRule rule1 = remoteRules.get(1);
      assertThat(rule1.getAction().getActionType()).isEqualTo(SetStorageClassLifecycleAction.TYPE);
      assertThat(((SetStorageClassLifecycleAction) rule1.getAction()).getStorageClass())
          .isEqualTo(StorageClass.LR_STANDARD_ENTERPRISE);
      assertThat(rule1.getCondition().getMatchesStorageClass())
          .containsExactly(
              StorageClass.STANDARD,
              StorageClass.valueOf("LR_STANDARD"),
              StorageClass.STANDARD_ENTERPRISE);

      LifecycleRule rule2 = remoteRules.get(2);
      assertThat(rule2.getAction().getActionType()).isEqualTo(DeleteLifecycleAction.TYPE);
      assertThat(rule2.getCondition().getMatchesStorageClass())
          .containsExactly(StorageClass.STANDARD_ENTERPRISE, StorageClass.LR_STANDARD_ENTERPRISE);
    }
  }

  @Test
  public void autoclassWithEnterpriseStorageClass_rejected() {
    String bucketName = generator.randomBucketName();
    BucketInfo bucketInfo =
        BucketInfo.newBuilder(bucketName)
            .setLocation(REGIONAL_LOCATION)
            .setStorageClass(StorageClass.STANDARD_ENTERPRISE)
            .setAutoclass(Autoclass.newBuilder().setEnabled(true).build())
            .build();

    StorageException ex = assertThrows(StorageException.class, () -> storage.create(bucketInfo));
    assertThat(ex.getCode()).isEqualTo(400);
  }
}
