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

import static com.google.cloud.storage.TestUtils.assertAll;
import static com.google.cloud.storage.TestUtils.retry429s;
import static com.google.common.truth.Truth.assertThat;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertThrows;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.fail;

import com.google.cloud.Policy;
import com.google.cloud.storage.Acl;
import com.google.cloud.storage.Acl.Entity;
import com.google.cloud.storage.Acl.Project.ProjectRole;
import com.google.cloud.storage.Acl.Role;
import com.google.cloud.storage.Acl.User;
import com.google.cloud.storage.Blob;
import com.google.cloud.storage.BlobInfo;
import com.google.cloud.storage.Bucket;
import com.google.cloud.storage.BucketInfo;
import com.google.cloud.storage.BucketInfo.IamConfiguration;
import com.google.cloud.storage.BucketInfo.PublicAccessPrevention;
import com.google.cloud.storage.Storage;
import com.google.cloud.storage.Storage.BlobTargetOption;
import com.google.cloud.storage.Storage.BucketField;
import com.google.cloud.storage.Storage.BucketGetOption;
import com.google.cloud.storage.Storage.BucketTargetOption;
import com.google.cloud.storage.StorageException;
import com.google.cloud.storage.TestUtils;
import com.google.cloud.storage.TransportCompatibility.Transport;
import com.google.cloud.storage.it.runner.StorageITRunner;
import com.google.cloud.storage.it.runner.annotations.Backend;
import com.google.cloud.storage.it.runner.annotations.CrossRun;
import com.google.cloud.storage.it.runner.annotations.Inject;
import com.google.cloud.storage.it.runner.registry.Generator;
import com.google.common.collect.ImmutableList;
import java.time.Duration;
import java.util.Collections;
import java.util.List;
import java.util.Optional;
import java.util.function.Predicate;
import java.util.stream.Collectors;
import org.junit.Ignore;
import org.junit.Test;
import org.junit.runner.RunWith;

@RunWith(StorageITRunner.class)
@CrossRun(
    transports = {Transport.HTTP, Transport.GRPC},
    backends = {Backend.PROD})
public class ITAccessTest {

  private static final Long RETENTION_PERIOD = 5L;
  private static final Duration RETENTION_PERIOD_DURATION = Duration.ofSeconds(5);

  @Inject public Storage storage;

  @Inject public Transport transport;

  @Inject public BucketInfo bucket;

  @Inject public Generator generator;

  @Test
  public void bucket_defaultAcl_get() {
    String bucketName = bucket.getName();
    // lookup an entity from the bucket which is known to exist
    Bucket bucketWithAcls =
        storage.get(
            bucketName, BucketGetOption.fields(BucketField.ACL, BucketField.DEFAULT_OBJECT_ACL));

    Acl actual = bucketWithAcls.getDefaultAcl().iterator().next();

    Acl acl = retry429s(() -> storage.getDefaultAcl(bucketName, actual.getEntity()), storage);

    assertThat(acl).isEqualTo(actual);
  }

  /** When a bucket does exist, but an acl for the specified entity is not defined return null */
  @Test
  public void bucket_defaultAcl_get_notFoundReturnsNull() {
    Acl acl = retry429s(() -> storage.getDefaultAcl(bucket.getName(), User.ofAllUsers()), storage);

    assertThat(acl).isNull();
  }

  /** When a bucket doesn't exist, return null for the acl value */
  @Test
  public void bucket_defaultAcl_get_bucket404() {
    Acl acl =
        retry429s(() -> storage.getDefaultAcl(bucket.getName() + "x", User.ofAllUsers()), storage);

    assertThat(acl).isNull();
  }

  @Test
  public void bucket_defaultAcl_list() {
    String bucketName = bucket.getName();
    // lookup an entity from the bucket which is known to exist
    Bucket bucketWithAcls =
        storage.get(
            bucketName, BucketGetOption.fields(BucketField.ACL, BucketField.DEFAULT_OBJECT_ACL));

    Acl actual = bucketWithAcls.getDefaultAcl().iterator().next();

    List<Acl> acls = retry429s(() -> storage.listDefaultAcls(bucketName), storage);

    assertThat(acls).contains(actual);
  }

  @Test
  public void bucket_defaultAcl_list_bucket404() {
    StorageException storageException =
        assertThrows(
            StorageException.class,
            () -> retry429s(() -> storage.listDefaultAcls(bucket.getName() + "x"), storage));

    assertThat(storageException.getCode()).isEqualTo(404);
  }

  @Test
  @Ignore("TODO: fix b/468377909 to enable test again")
  public void bucket_defaultAcl_create() throws Exception {
    BucketInfo bucketInfo = BucketInfo.newBuilder(generator.randomBucketName()).build();
    try (TemporaryBucket tempB =
        TemporaryBucket.newBuilder().setBucketInfo(bucketInfo).setStorage(storage).build()) {
      BucketInfo bucket = tempB.getBucket();

      Acl readAll = Acl.of(User.ofAllAuthenticatedUsers(), Role.READER);
      Acl actual = retry429s(() -> storage.createDefaultAcl(bucket.getName(), readAll), storage);

      assertThat(actual.getEntity()).isEqualTo(readAll.getEntity());
      assertThat(actual.getRole()).isEqualTo(readAll.getRole());
      assertThat(actual.getEtag()).isNotEmpty();

      Bucket bucketUpdated =
          storage.get(
              bucket.getName(),
              BucketGetOption.fields(
                  TestUtils.filterOutHttpOnlyBucketFields(BucketField.values())));
      assertThat(bucketUpdated.getMetageneration()).isNotEqualTo(bucket.getMetageneration());

      // etags change when updates happen, drop before our comparison
      List<Acl> expectedAcls = dropEtags(bucket.getDefaultAcl());
      List<Acl> actualAcls = dropEtags(bucketUpdated.getDefaultAcl());
      assertThat(actualAcls).containsAtLeastElementsIn(expectedAcls);
      assertThat(actualAcls).contains(readAll);
    }
  }

  @Test
  public void bucket_defaultAcl_create_bucket404() {
    Acl readAll = Acl.of(User.ofAllAuthenticatedUsers(), Role.READER);
    StorageException storageException =
        assertThrows(
            StorageException.class,
            () ->
                retry429s(
                    () -> storage.createDefaultAcl(bucket.getName() + "x", readAll), storage));

    assertThat(storageException.getCode()).isEqualTo(404);
  }

  @Test
  public void bucket_defaultAcl_update() throws Exception {
    BucketInfo bucketInfo = BucketInfo.newBuilder(generator.randomBucketName()).build();
    try (TemporaryBucket tempB =
        TemporaryBucket.newBuilder().setBucketInfo(bucketInfo).setStorage(storage).build()) {
      BucketInfo bucket = tempB.getBucket();

      List<Acl> defaultAcls = bucket.getDefaultAcl();
      assertThat(defaultAcls).isNotEmpty();

      Predicate<Acl> isProjectEditor = hasProjectRole(ProjectRole.EDITORS);

      //noinspection OptionalGetWithoutIsPresent
      Acl projectEditorAsOwner =
          defaultAcls.stream().filter(hasRole(Role.OWNER).and(isProjectEditor)).findFirst().get();

      // lower the privileges of project editors to writer from owner
      Entity entity = projectEditorAsOwner.getEntity();
      Acl projectEditorAsReader = Acl.of(entity, Role.READER);

      Acl actual =
          retry429s(
              () -> storage.updateDefaultAcl(bucket.getName(), projectEditorAsReader), storage);

      assertThat(actual.getEntity()).isEqualTo(projectEditorAsReader.getEntity());
      assertThat(actual.getRole()).isEqualTo(projectEditorAsReader.getRole());
      assertThat(actual.getEtag()).isNotEmpty();

      Bucket bucketUpdated =
          storage.get(
              bucket.getName(),
              BucketGetOption.fields(
                  TestUtils.filterOutHttpOnlyBucketFields(BucketField.values())));
      assertThat(bucketUpdated.getMetageneration()).isNotEqualTo(bucket.getMetageneration());

      // etags change when updates happen, drop before our comparison
      List<Acl> expectedAcls =
          dropEtags(
              bucket.getDefaultAcl().stream()
                  .filter(isProjectEditor.negate())
                  .collect(Collectors.toList()));
      List<Acl> actualAcls = dropEtags(bucketUpdated.getDefaultAcl());
      assertThat(actualAcls).containsAtLeastElementsIn(expectedAcls);
      assertThat(actualAcls).doesNotContain(projectEditorAsOwner);
      assertThat(actualAcls).contains(projectEditorAsReader);
    }
  }

  @Test
  public void bucket_defaultAcl_update_bucket404() {
    Acl readAll = Acl.of(User.ofAllAuthenticatedUsers(), Role.READER);
    StorageException storageException =
        assertThrows(
            StorageException.class,
            () ->
                retry429s(
                    () -> storage.updateDefaultAcl(bucket.getName() + "x", readAll), storage));

    assertThat(storageException.getCode()).isEqualTo(404);
  }

  @Test
  public void bucket_defaultAcl_delete() throws Exception {
    BucketInfo bucketInfo = BucketInfo.newBuilder(generator.randomBucketName()).build();
    try (TemporaryBucket tempB =
        TemporaryBucket.newBuilder().setBucketInfo(bucketInfo).setStorage(storage).build()) {
      BucketInfo bucket = tempB.getBucket();

      List<Acl> defaultAcls = bucket.getDefaultAcl();
      assertThat(defaultAcls).isNotEmpty();

      Predicate<Acl> isProjectEditor = hasProjectRole(ProjectRole.VIEWERS);

      //noinspection OptionalGetWithoutIsPresent
      Acl projectViewerAsReader =
          defaultAcls.stream().filter(hasRole(Role.READER).and(isProjectEditor)).findFirst().get();

      Entity entity = projectViewerAsReader.getEntity();

      boolean actual = retry429s(() -> storage.deleteDefaultAcl(bucket.getName(), entity), storage);

      assertThat(actual).isTrue();

      Bucket bucketUpdated =
          storage.get(
              bucket.getName(),
              BucketGetOption.fields(
                  TestUtils.filterOutHttpOnlyBucketFields(BucketField.values())));
      assertThat(bucketUpdated.getMetageneration()).isNotEqualTo(bucket.getMetageneration());

      // etags change when deletes happen, drop before our comparison
      List<Acl> expectedAcls =
          dropEtags(
              bucket.getDefaultAcl().stream()
                  .filter(isProjectEditor.negate())
                  .collect(Collectors.toList()));
      List<Acl> actualAcls = dropEtags(bucketUpdated.getDefaultAcl());
      assertThat(actualAcls).containsAtLeastElementsIn(expectedAcls);
      Optional<Entity> search =
          actualAcls.stream().map(Acl::getEntity).filter(e -> e.equals(entity)).findAny();
      assertThat(search.isPresent()).isFalse();
    }
  }

  @Test
  public void bucket_defaultAcl_delete_bucket404() {
    boolean actual =
        retry429s(
            () -> storage.deleteDefaultAcl(bucket.getName() + "x", User.ofAllUsers()), storage);

    assertThat(actual).isEqualTo(false);
  }

  @Test
  public void bucket_defaultAcl_delete_noExistingAcl() throws Exception {
    BucketInfo bucketInfo = BucketInfo.newBuilder(generator.randomBucketName()).build();
    try (TemporaryBucket tempB =
        TemporaryBucket.newBuilder().setBucketInfo(bucketInfo).setStorage(storage).build()) {
      BucketInfo bucket = tempB.getBucket();
      boolean actual =
          retry429s(() -> storage.deleteDefaultAcl(bucket.getName(), User.ofAllUsers()), storage);

      assertThat(actual).isEqualTo(false);
    }
  }

  /** Validate legacy deprecated field is redirected correctly */
  @Test
  @SuppressWarnings("deprecation")
  public void testBucketWithBucketPolicyOnlyEnabled() throws Exception {
    doTestUniformBucketLevelAccessAclImpact(
        BucketInfo.IamConfiguration.newBuilder().setIsBucketPolicyOnlyEnabled(true).build());
  }

  @Test
  public void testBucketWithUniformBucketLevelAccessEnabled() throws Exception {
    doTestUniformBucketLevelAccessAclImpact(
        BucketInfo.IamConfiguration.newBuilder()
            .setIsUniformBucketLevelAccessEnabled(true)
            .build());
  }

  private void doTestUniformBucketLevelAccessAclImpact(IamConfiguration iamConfiguration)
      throws Exception {
    String bucketName = generator.randomBucketName();
    try (TemporaryBucket tempB =
        TemporaryBucket.newBuilder()
            .setBucketInfo(
                Bucket.newBuilder(bucketName).setIamConfiguration(iamConfiguration).build())
            .setStorage(storage)
            .build()) {
      BucketInfo bucket = tempB.getBucket();

      assertTrue(bucket.getIamConfiguration().isUniformBucketLevelAccessEnabled());
      assertNotNull(
          bucket.getIamConfiguration().getUniformBucketLevelAccessLockedTimeOffsetDateTime());

      if (transport == Transport.HTTP) {
        StorageException listAclsError =
            assertThrows(StorageException.class, () -> storage.listAcls(bucketName));
        assertAll(
            () -> assertThat(listAclsError.getCode()).isEqualTo(400),
            () -> assertThat(listAclsError.getReason()).isEqualTo("invalid"));

        StorageException listDefaultAclsError =
            assertThrows(StorageException.class, () -> storage.listDefaultAcls(bucketName));
        assertAll(
            () -> assertThat(listDefaultAclsError.getCode()).isEqualTo(400),
            () -> assertThat(listDefaultAclsError.getReason()).isEqualTo("invalid"));
      } else if (transport == Transport.GRPC) {
        assertThat(storage.listAcls(bucketName)).isEmpty();
        assertThat(storage.listDefaultAcls(bucketName)).isEmpty();
      }
    }
  }

  @Test
  @Ignore("TODO: fix b/468377909 to enable test again")
  public void testEnableAndDisableUniformBucketLevelAccessOnExistingBucket() throws Exception {
    String bpoBucket = generator.randomBucketName();
    BucketInfo.IamConfiguration ublaDisabledIamConfiguration =
        BucketInfo.IamConfiguration.newBuilder()
            .setIsUniformBucketLevelAccessEnabled(false)
            .build();
    BucketInfo bucketInfo =
        Bucket.newBuilder(bpoBucket)
            .setIamConfiguration(ublaDisabledIamConfiguration)
            .setAcl(ImmutableList.of(Acl.of(User.ofAllAuthenticatedUsers(), Role.READER)))
            .setDefaultAcl(ImmutableList.of(Acl.of(User.ofAllAuthenticatedUsers(), Role.READER)))
            .build();
    try (TemporaryBucket tempB =
        TemporaryBucket.newBuilder().setBucketInfo(bucketInfo).setStorage(storage).build()) {
      // BPO is disabled by default.
      BucketInfo bucket = tempB.getBucket();
      assertThat(bucket.getIamConfiguration().isUniformBucketLevelAccessEnabled()).isFalse();

      storage.update(
          bucket.toBuilder()
              .setAcl(null)
              .setDefaultAcl(null)
              .setIamConfiguration(
                  ublaDisabledIamConfiguration.toBuilder()
                      .setIsUniformBucketLevelAccessEnabled(true)
                      .build())
              .build(),
          BucketTargetOption.metagenerationMatch());

      Bucket remoteBucket =
          storage.get(
              bpoBucket,
              Storage.BucketGetOption.fields(
                  BucketField.IAMCONFIGURATION, BucketField.METAGENERATION));

      assertTrue(remoteBucket.getIamConfiguration().isUniformBucketLevelAccessEnabled());
      assertNotNull(remoteBucket.getIamConfiguration().getUniformBucketLevelAccessLockedTime());

      remoteBucket.toBuilder()
          .setIamConfiguration(ublaDisabledIamConfiguration)
          .build()
          .update(BucketTargetOption.metagenerationMatch());

      remoteBucket =
          storage.get(
              bpoBucket,
              Storage.BucketGetOption.fields(
                  BucketField.IAMCONFIGURATION, BucketField.ACL, BucketField.DEFAULT_OBJECT_ACL));

      assertFalse(remoteBucket.getIamConfiguration().isUniformBucketLevelAccessEnabled());
      assertEquals(User.ofAllAuthenticatedUsers(), remoteBucket.getDefaultAcl().get(0).getEntity());
      assertEquals(Role.READER, remoteBucket.getDefaultAcl().get(0).getRole());
      assertEquals(User.ofAllAuthenticatedUsers(), remoteBucket.getAcl().get(0).getEntity());
      assertEquals(Role.READER, remoteBucket.getAcl().get(0).getRole());
    }
  }

  @Test
  public void testEnforcedPublicAccessPreventionOnBucket() throws Exception {
    String papBucket = generator.randomBucketName();
    BucketInfo bucketInfo =
        BucketInfo.newBuilder(papBucket)
            .setIamConfiguration(
                IamConfiguration.newBuilder()
                    .setPublicAccessPrevention(PublicAccessPrevention.ENFORCED)
                    .build())
            .build();

    try (TemporaryBucket tempB =
        TemporaryBucket.newBuilder().setBucketInfo(bucketInfo).setStorage(storage).build()) {
      BucketInfo bucket = tempB.getBucket();
      // Making bucket public should fail.
      try {
        storage.setIamPolicy(
            papBucket,
            Policy.newBuilder()
                .setVersion(3)
                .setBindings(
                    ImmutableList.of(
                        com.google.cloud.Binding.newBuilder()
                            .setRole("roles/storage.objectViewer")
                            .addMembers("allUsers")
                            .build()))
                .build());
        fail("pap: expected adding allUsers policy to bucket should fail");
      } catch (StorageException storageException) {
        // Creating a bucket with roles/storage.objectViewer is not
        // allowed when publicAccessPrevention is enabled.
        assertEquals(storageException.getCode(), 412);
      }

      // Making object public via ACL should fail.
      try {
        // Create a public object
        storage.create(
            BlobInfo.newBuilder(bucket, "pap-test-object").build(),
            BlobTargetOption.predefinedAcl(Storage.PredefinedAcl.PUBLIC_READ));
        fail("pap: expected adding allUsers ACL to object should fail");
      } catch (StorageException storageException) {
        // Creating an object with allUsers roles/storage.viewer permission
        // is not allowed. When Public Access Prevention is enabled.
        assertEquals(storageException.getCode(), 412);
      }
    }
  }

  @Test
  @Ignore("TODO: fix b/468377909 to enable test again")
  public void testUnspecifiedPublicAccessPreventionOnBucket() throws Exception {
    String papBucket = generator.randomBucketName();
    BucketInfo bucketInfo =
        BucketInfo.newBuilder(papBucket)
            .setIamConfiguration(
                IamConfiguration.newBuilder()
                    .setPublicAccessPrevention(PublicAccessPrevention.INHERITED)
                    .build())
            .build();

    try (TemporaryBucket tempB =
        TemporaryBucket.newBuilder().setBucketInfo(bucketInfo).setStorage(storage).build()) {
      BucketInfo bucket = tempB.getBucket();

      // Now, making object public or making bucket public should succeed.
      try {
        // Create a public object
        storage.create(
            BlobInfo.newBuilder(bucket, "pap-test-object").build(),
            BlobTargetOption.predefinedAcl(Storage.PredefinedAcl.PUBLIC_READ));
      } catch (StorageException storageException) {
        fail("pap: expected adding allUsers ACL to object to succeed");
      }

      // Now, making bucket public should succeed.
      try {
        storage.setIamPolicy(
            papBucket,
            Policy.newBuilder()
                .setVersion(3)
                .setBindings(
                    ImmutableList.of(
                        com.google.cloud.Binding.newBuilder()
                            .setRole("roles/storage.objectViewer")
                            .addMembers("allUsers")
                            .build()))
                .build());
      } catch (StorageException storageException) {
        fail("pap: expected adding allUsers policy to bucket to succeed");
      }
    }
  }

  @Test
  public void changingPAPDoesNotAffectUBLA() throws Exception {
    String bucketName = generator.randomBucketName();
    try (TemporaryBucket tempB =
        TemporaryBucket.newBuilder()
            .setBucketInfo(
                BucketInfo.newBuilder(bucketName)
                    .setIamConfiguration(
                        BucketInfo.IamConfiguration.newBuilder()
                            .setPublicAccessPrevention(PublicAccessPrevention.INHERITED)
                            .setIsUniformBucketLevelAccessEnabled(false)
                            .build())
                    .build())
            .setStorage(storage)
            .build()) {
      BucketInfo bucket = tempB.getBucket();
      assertEquals(
          bucket.getIamConfiguration().getPublicAccessPrevention(),
          BucketInfo.PublicAccessPrevention.INHERITED);
      assertFalse(bucket.getIamConfiguration().isUniformBucketLevelAccessEnabled());
      assertFalse(bucket.getIamConfiguration().isBucketPolicyOnlyEnabled());

      IamConfiguration iamConfiguration1 =
          bucket.getIamConfiguration().toBuilder()
              .setPublicAccessPrevention(PublicAccessPrevention.ENFORCED)
              .build();
      // Update PAP setting to ENFORCED and should not affect UBLA setting.
      storage.update(
          bucket.toBuilder().setIamConfiguration(iamConfiguration1).build(),
          BucketTargetOption.metagenerationMatch());
      Bucket bucket2 =
          storage.get(bucketName, Storage.BucketGetOption.fields(BucketField.IAMCONFIGURATION));
      assertEquals(
          bucket2.getIamConfiguration().getPublicAccessPrevention(),
          BucketInfo.PublicAccessPrevention.ENFORCED);
      assertFalse(bucket2.getIamConfiguration().isUniformBucketLevelAccessEnabled());
      assertFalse(bucket2.getIamConfiguration().isBucketPolicyOnlyEnabled());
    }
  }

  @Test
  public void changingUBLADoesNotAffectPAP() throws Exception {
    String bucketName = generator.randomBucketName();
    try (TemporaryBucket tempB =
        TemporaryBucket.newBuilder()
            .setBucketInfo(
                BucketInfo.newBuilder(bucketName)
                    .setIamConfiguration(
                        BucketInfo.IamConfiguration.newBuilder()
                            .setPublicAccessPrevention(PublicAccessPrevention.INHERITED)
                            .setIsUniformBucketLevelAccessEnabled(false)
                            .build())
                    .build())
            .setStorage(storage)
            .build()) {
      BucketInfo bucket = tempB.getBucket();
      assertEquals(
          bucket.getIamConfiguration().getPublicAccessPrevention(),
          PublicAccessPrevention.INHERITED);
      assertFalse(bucket.getIamConfiguration().isUniformBucketLevelAccessEnabled());
      assertFalse(bucket.getIamConfiguration().isBucketPolicyOnlyEnabled());

      IamConfiguration iamConfiguration1 =
          bucket.getIamConfiguration().toBuilder()
              .setIsUniformBucketLevelAccessEnabled(true)
              .build();
      // Updating UBLA should not affect PAP setting.
      Bucket bucket2 =
          storage.update(
              bucket.toBuilder()
                  .setIamConfiguration(iamConfiguration1)
                  // clear out ACL related config in conjunction with enabling UBLA
                  .setAcl(Collections.emptyList())
                  .setDefaultAcl(Collections.emptyList())
                  .build(),
              BucketTargetOption.metagenerationMatch());
      assertEquals(
          bucket2.getIamConfiguration().getPublicAccessPrevention(),
          PublicAccessPrevention.INHERITED);
      assertTrue(bucket2.getIamConfiguration().isUniformBucketLevelAccessEnabled());
      assertTrue(bucket2.getIamConfiguration().isBucketPolicyOnlyEnabled());
    }
  }

  @Test
  public void testRetentionPolicyNoLock() throws Exception {
    String bucketName = generator.randomBucketName();
    try (TemporaryBucket tempB =
        TemporaryBucket.newBuilder()
            .setBucketInfo(
                BucketInfo.newBuilder(bucketName).setRetentionPeriod(RETENTION_PERIOD).build())
            .setStorage(storage)
            .build()) {
      BucketInfo remoteBucket = tempB.getBucket();

      assertThat(remoteBucket.getRetentionPeriod()).isEqualTo(RETENTION_PERIOD);
      assertThat(remoteBucket.getRetentionPeriodDuration()).isEqualTo(RETENTION_PERIOD_DURATION);
      assertNotNull(remoteBucket.getRetentionEffectiveTime());
      assertThat(remoteBucket.retentionPolicyIsLocked()).isAnyOf(null, false);

      Bucket remoteBucket2 =
          storage.get(
              bucketName,
              Storage.BucketGetOption.fields(
                  BucketField.RETENTION_POLICY, BucketField.METAGENERATION));
      assertEquals(RETENTION_PERIOD, remoteBucket2.getRetentionPeriod());
      assertThat(remoteBucket2.getRetentionPeriodDuration()).isEqualTo(RETENTION_PERIOD_DURATION);
      assertNotNull(remoteBucket2.getRetentionEffectiveTime());
      assertThat(remoteBucket2.retentionPolicyIsLocked()).isAnyOf(null, false);

      String blobName = generator.randomObjectName();
      BlobInfo blobInfo = BlobInfo.newBuilder(bucketName, blobName).build();
      Blob remoteBlob = storage.create(blobInfo);
      assertNotNull(remoteBlob.getRetentionExpirationTime());

      Bucket remoteBucket3 =
          remoteBucket2.toBuilder()
              .setRetentionPeriod(null)
              .build()
              .update(BucketTargetOption.metagenerationMatch());
      assertNull(remoteBucket3.getRetentionPeriod());
    }
  }

  @Test
  @Ignore("TODO: fix b/468377909 to enable test again.")
  @SuppressWarnings({"unchecked", "deprecation"})
  public void testEnableAndDisableBucketPolicyOnlyOnExistingBucket() throws Exception {
    String bpoBucket = generator.randomBucketName();
    try (TemporaryBucket tempB =
        TemporaryBucket.newBuilder()
            .setBucketInfo(
                Bucket.newBuilder(bpoBucket)
                    .setAcl(ImmutableList.of(Acl.of(User.ofAllAuthenticatedUsers(), Role.READER)))
                    .setDefaultAcl(
                        ImmutableList.of(Acl.of(User.ofAllAuthenticatedUsers(), Role.READER)))
                    .build())
            .setStorage(storage)
            .build()) {
      // BPO is disabled by default.
      BucketInfo bucket = tempB.getBucket();
      assertThat(bucket.getIamConfiguration().isBucketPolicyOnlyEnabled()).isFalse();

      BucketInfo.IamConfiguration bpoEnabledIamConfiguration =
          BucketInfo.IamConfiguration.newBuilder().setIsBucketPolicyOnlyEnabled(true).build();
      storage.update(
          bucket.toBuilder()
              .setAcl(null)
              .setDefaultAcl(null)
              .setIamConfiguration(bpoEnabledIamConfiguration)
              .build(),
          BucketTargetOption.metagenerationMatch());

      Bucket remoteBucket = storage.get(bpoBucket);

      assertTrue(remoteBucket.getIamConfiguration().isBucketPolicyOnlyEnabled());
      assertNotNull(remoteBucket.getIamConfiguration().getBucketPolicyOnlyLockedTime());

      remoteBucket.toBuilder()
          .setIamConfiguration(
              bpoEnabledIamConfiguration.toBuilder().setIsBucketPolicyOnlyEnabled(false).build())
          .build()
          .update(BucketTargetOption.metagenerationMatch());

      remoteBucket =
          storage.get(
              bpoBucket,
              Storage.BucketGetOption.fields(
                  BucketField.IAMCONFIGURATION, BucketField.ACL, BucketField.DEFAULT_OBJECT_ACL));

      assertFalse(remoteBucket.getIamConfiguration().isBucketPolicyOnlyEnabled());
      assertEquals(User.ofAllAuthenticatedUsers(), remoteBucket.getDefaultAcl().get(0).getEntity());
      assertEquals(Role.READER, remoteBucket.getDefaultAcl().get(0).getRole());
      assertEquals(User.ofAllAuthenticatedUsers(), remoteBucket.getAcl().get(0).getEntity());
      assertEquals(Role.READER, remoteBucket.getAcl().get(0).getRole());
    }
  }

  static ImmutableList<Acl> dropEtags(List<Acl> defaultAcls) {
    return defaultAcls.stream()
        .map(ITAccessTest::dropEtag)
        .collect(ImmutableList.toImmutableList());
  }

  static Acl dropEtag(Acl acl) {
    return Acl.of(acl.getEntity(), acl.getRole());
  }

  static Predicate<Acl> hasRole(Acl.Role expected) {
    return acl -> acl.getRole().equals(expected);
  }

  static Predicate<Acl> hasProjectRole(Acl.Project.ProjectRole expected) {
    return acl -> {
      Entity entity = acl.getEntity();
      if (entity.getType().equals(Entity.Type.PROJECT)) {
        return ((Acl.Project) entity).getProjectRole().equals(expected);
      }
      return false;
    };
  }
}
