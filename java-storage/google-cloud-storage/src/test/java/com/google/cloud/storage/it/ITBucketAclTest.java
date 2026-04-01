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

import static com.google.cloud.storage.TestUtils.retry429s;
import static com.google.cloud.storage.it.ITAccessTest.dropEtags;
import static com.google.cloud.storage.it.ITAccessTest.hasProjectRole;
import static com.google.cloud.storage.it.ITAccessTest.hasRole;
import static com.google.common.truth.Truth.assertThat;
import static org.junit.Assert.assertThrows;

import com.google.cloud.storage.Acl;
import com.google.cloud.storage.Acl.Entity;
import com.google.cloud.storage.Acl.Project.ProjectRole;
import com.google.cloud.storage.Acl.Role;
import com.google.cloud.storage.Acl.User;
import com.google.cloud.storage.Bucket;
import com.google.cloud.storage.BucketInfo;
import com.google.cloud.storage.Storage;
import com.google.cloud.storage.Storage.BucketField;
import com.google.cloud.storage.Storage.BucketGetOption;
import com.google.cloud.storage.StorageException;
import com.google.cloud.storage.TestUtils;
import com.google.cloud.storage.TransportCompatibility.Transport;
import com.google.cloud.storage.it.runner.StorageITRunner;
import com.google.cloud.storage.it.runner.annotations.Backend;
import com.google.cloud.storage.it.runner.annotations.CrossRun;
import com.google.cloud.storage.it.runner.annotations.Inject;
import com.google.cloud.storage.it.runner.annotations.ParallelFriendly;
import com.google.cloud.storage.it.runner.registry.Generator;
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
@ParallelFriendly
public final class ITBucketAclTest {
  @Inject public Storage storage;

  @Inject public BucketInfo bucket;

  @Inject public Generator generator;

  @Test
  public void bucket_acl_get() {
    String bucketName = bucket.getName();
    // lookup an entity from the bucket which is known to exist
    Bucket bucketWithAcls = storage.get(bucketName, BucketGetOption.fields(BucketField.ACL));

    Acl actual = bucketWithAcls.getAcl().iterator().next();

    Acl acl = retry429s(() -> storage.getAcl(bucketName, actual.getEntity()), storage);

    assertThat(acl).isEqualTo(actual);
  }

  /** When a bucket does exist, but an acl for the specified entity is not defined return null */
  @Test
  public void bucket_acl_get_notFoundReturnsNull() {
    Acl acl = retry429s(() -> storage.getAcl(bucket.getName(), User.ofAllUsers()), storage);

    assertThat(acl).isNull();
  }

  /** When a bucket doesn't exist, return null for the acl value */
  @Test
  public void bucket_acl_get_bucket404() {
    Acl acl = retry429s(() -> storage.getAcl(bucket.getName() + "x", User.ofAllUsers()), storage);

    assertThat(acl).isNull();
  }

  @Test
  public void bucket_acl_list() {
    String bucketName = bucket.getName();
    // lookup an entity from the bucket which is known to exist
    Bucket bucketWithAcls = storage.get(bucketName, BucketGetOption.fields(BucketField.ACL));

    Acl actual = bucketWithAcls.getAcl().iterator().next();

    List<Acl> acls = retry429s(() -> storage.listAcls(bucketName), storage);

    assertThat(acls).contains(actual);
  }

  @Test
  public void bucket_acl_list_bucket404() {
    StorageException storageException =
        assertThrows(
            StorageException.class,
            () -> retry429s(() -> storage.listAcls(bucket.getName() + "x"), storage));

    assertThat(storageException.getCode()).isEqualTo(404);
  }

  @Test
  @Ignore("TODO: fix b/468377909 to enable test again")
  public void bucket_acl_create() throws Exception {
    BucketInfo bucketInfo = BucketInfo.newBuilder(generator.randomBucketName()).build();
    try (TemporaryBucket tempB =
        TemporaryBucket.newBuilder().setBucketInfo(bucketInfo).setStorage(storage).build()) {
      BucketInfo bucket = tempB.getBucket();

      Acl readAll = Acl.of(User.ofAllAuthenticatedUsers(), Role.READER);
      Acl actual = retry429s(() -> storage.createAcl(bucket.getName(), readAll), storage);

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
      List<Acl> expectedAcls = dropEtags(bucket.getAcl());
      List<Acl> actualAcls = dropEtags(bucketUpdated.getAcl());
      assertThat(actualAcls).containsAtLeastElementsIn(expectedAcls);
      assertThat(actualAcls).contains(readAll);
    }
  }

  @Test
  public void bucket_acl_create_bucket404() {
    Acl readAll = Acl.of(User.ofAllAuthenticatedUsers(), Role.READER);
    StorageException storageException =
        assertThrows(
            StorageException.class,
            () -> retry429s(() -> storage.createAcl(bucket.getName() + "x", readAll), storage));

    assertThat(storageException.getCode()).isEqualTo(404);
  }

  @Test
  public void bucket_acl_update() throws Exception {
    BucketInfo bucketInfo = BucketInfo.newBuilder(generator.randomBucketName()).build();
    try (TemporaryBucket tempB =
        TemporaryBucket.newBuilder().setBucketInfo(bucketInfo).setStorage(storage).build()) {
      BucketInfo bucket = tempB.getBucket();

      List<Acl> acls = bucket.getAcl();
      assertThat(acls).isNotEmpty();

      Predicate<Acl> isProjectEditor = hasProjectRole(ProjectRole.EDITORS);

      //noinspection OptionalGetWithoutIsPresent
      Acl projectEditorAsOwner =
          acls.stream().filter(hasRole(Role.OWNER).and(isProjectEditor)).findFirst().get();

      // lower the privileges of project editors to writer from owner
      Entity entity = projectEditorAsOwner.getEntity();
      Acl projectEditorAsReader = Acl.of(entity, Role.READER);

      Acl actual =
          retry429s(() -> storage.updateAcl(bucket.getName(), projectEditorAsReader), storage);

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
              bucket.getAcl().stream()
                  .filter(isProjectEditor.negate())
                  .collect(Collectors.toList()));
      List<Acl> actualAcls = dropEtags(bucketUpdated.getAcl());
      assertThat(actualAcls).containsAtLeastElementsIn(expectedAcls);
      assertThat(actualAcls).doesNotContain(projectEditorAsOwner);
      assertThat(actualAcls).contains(projectEditorAsReader);
    }
  }

  @Test
  public void bucket_acl_update_bucket404() {
    Acl readAll = Acl.of(User.ofAllAuthenticatedUsers(), Role.READER);
    StorageException storageException =
        assertThrows(
            StorageException.class,
            () -> retry429s(() -> storage.updateAcl(bucket.getName() + "x", readAll), storage));

    assertThat(storageException.getCode()).isEqualTo(404);
  }

  /** Update of an acl that doesn't exist should create it */
  @Test
  @Ignore("TODO: fix b/468377909 to enable test again")
  public void bucket_acl_404_acl_update() throws Exception {
    BucketInfo bucketInfo = BucketInfo.newBuilder(generator.randomBucketName()).build();
    try (TemporaryBucket tempB =
        TemporaryBucket.newBuilder().setBucketInfo(bucketInfo).setStorage(storage).build()) {
      BucketInfo mgen1 = tempB.getBucket();
      Acl readAll = Acl.of(User.ofAllAuthenticatedUsers(), Role.READER);
      Acl actual =
          // todo: json non-idempotent?
          retry429s(() -> storage.updateAcl(mgen1.getName(), readAll), storage);

      assertThat(actual.getEntity()).isEqualTo(readAll.getEntity());
      assertThat(actual.getRole()).isEqualTo(readAll.getRole());
      assertThat(actual.getEtag()).isNotEmpty();

      Bucket updated =
          storage.get(
              mgen1.getName(),
              BucketGetOption.fields(
                  TestUtils.filterOutHttpOnlyBucketFields(BucketField.values())));
      assertThat(updated.getMetageneration()).isNotEqualTo(bucket.getMetageneration());

      // etags change when updates happen, drop before our comparison
      List<Acl> expectedAcls = dropEtags(mgen1.getAcl());
      List<Acl> actualAcls = dropEtags(updated.getAcl());
      assertThat(actualAcls).containsAtLeastElementsIn(expectedAcls);
      assertThat(actualAcls).contains(readAll);
    }
  }

  @Test
  public void bucket_acl_delete() throws Exception {
    BucketInfo bucketInfo = BucketInfo.newBuilder(generator.randomBucketName()).build();
    try (TemporaryBucket tempB =
        TemporaryBucket.newBuilder().setBucketInfo(bucketInfo).setStorage(storage).build()) {
      BucketInfo bucket = tempB.getBucket();

      List<Acl> acls = bucket.getAcl();
      assertThat(acls).isNotEmpty();

      Predicate<Acl> isProjectEditor = hasProjectRole(ProjectRole.VIEWERS);

      //noinspection OptionalGetWithoutIsPresent
      Acl projectViewerAsReader =
          acls.stream().filter(hasRole(Role.READER).and(isProjectEditor)).findFirst().get();

      Entity entity = projectViewerAsReader.getEntity();

      boolean actual = retry429s(() -> storage.deleteAcl(bucket.getName(), entity), storage);

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
              bucket.getAcl().stream()
                  .filter(isProjectEditor.negate())
                  .collect(Collectors.toList()));
      List<Acl> actualAcls = dropEtags(bucketUpdated.getAcl());
      assertThat(actualAcls).containsAtLeastElementsIn(expectedAcls);
      Optional<Entity> search =
          actualAcls.stream().map(Acl::getEntity).filter(e -> e.equals(entity)).findAny();
      assertThat(search.isPresent()).isFalse();
    }
  }

  @Test
  public void bucket_acl_delete_bucket404() {
    boolean actual =
        retry429s(() -> storage.deleteAcl(bucket.getName() + "x", User.ofAllUsers()), storage);

    assertThat(actual).isEqualTo(false);
  }

  @Test
  public void bucket_acl_delete_noExistingAcl() throws Exception {
    BucketInfo bucketInfo = BucketInfo.newBuilder(generator.randomBucketName()).build();
    try (TemporaryBucket tempB =
        TemporaryBucket.newBuilder().setBucketInfo(bucketInfo).setStorage(storage).build()) {
      BucketInfo bucket = tempB.getBucket();
      boolean actual =
          retry429s(() -> storage.deleteAcl(bucket.getName(), User.ofAllUsers()), storage);

      assertThat(actual).isEqualTo(false);
    }
  }
}
