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
import static com.google.cloud.storage.it.ITAccessTest.dropEtag;
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
import com.google.cloud.storage.Blob;
import com.google.cloud.storage.BlobId;
import com.google.cloud.storage.BlobInfo;
import com.google.cloud.storage.BucketInfo;
import com.google.cloud.storage.Storage;
import com.google.cloud.storage.Storage.BlobField;
import com.google.cloud.storage.Storage.BlobGetOption;
import com.google.cloud.storage.Storage.BlobTargetOption;
import com.google.cloud.storage.StorageException;
import com.google.cloud.storage.TransportCompatibility.Transport;
import com.google.cloud.storage.it.runner.StorageITRunner;
import com.google.cloud.storage.it.runner.annotations.Backend;
import com.google.cloud.storage.it.runner.annotations.CrossRun;
import com.google.cloud.storage.it.runner.annotations.Inject;
import com.google.cloud.storage.it.runner.annotations.ParallelFriendly;
import com.google.cloud.storage.it.runner.registry.Generator;
import com.google.cloud.storage.it.runner.registry.ObjectsFixture;
import java.util.List;
import java.util.Optional;
import java.util.function.Predicate;
import java.util.stream.Collectors;
import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;
import org.junit.runner.RunWith;

@RunWith(StorageITRunner.class)
@CrossRun(
    transports = {Transport.HTTP, Transport.GRPC},
    backends = {Backend.PROD})
@ParallelFriendly
public final class ITObjectAclTest {

  @Inject public Generator generator;

  @Inject public Storage storage;

  @Inject public BucketInfo bucketInfo;

  @Inject public ObjectsFixture objectsFixture;

  private BlobId idWith404Bucket;

  private static final Acl readAll = Acl.of(User.ofAllAuthenticatedUsers(), Role.READER);

  @Before
  public void setUp() throws Exception {
    String bucketName = bucketInfo.getName() + "x";
    idWith404Bucket = BlobId.of(bucketName, "does-not-matter");
  }

  /** When a bucket doesn't exist, return null for the acl value */
  @Test
  public void object_acl_404_bucket_get() {
    Acl acl = retry429s(() -> storage.getAcl(idWith404Bucket, User.ofAllUsers()), storage);

    assertThat(acl).isNull();
  }

  @Test
  public void object_acl_404_bucket_list() {
    StorageException storageException =
        assertThrows(
            StorageException.class,
            () -> retry429s(() -> storage.listAcls(idWith404Bucket), storage));

    assertThat(storageException.getCode()).isEqualTo(404);
  }

  @Test
  public void object_acl_404_bucket_create() {
    StorageException storageException =
        assertThrows(
            StorageException.class,
            () -> retry429s(() -> storage.createAcl(idWith404Bucket, readAll), storage));

    assertThat(storageException.getCode()).isEqualTo(404);
  }

  @Test
  public void object_acl_404_bucket_update() {
    StorageException storageException =
        assertThrows(
            StorageException.class,
            () -> retry429s(() -> storage.updateAcl(idWith404Bucket, readAll), storage));

    assertThat(storageException.getCode()).isEqualTo(404);
  }

  @Test
  public void object_acl_404_bucket_delete() {
    boolean actual =
        retry429s(() -> storage.deleteAcl(idWith404Bucket, User.ofAllUsers()), storage);

    assertThat(actual).isFalse();
  }

  /** When a blob doesn't exist, return null for the acl value */
  @Test
  public void object_acl_404_object_get() {
    BlobId id = tmpId();
    Acl acl = retry429s(() -> storage.getAcl(id, User.ofAllUsers()), storage);

    assertThat(acl).isNull();
  }

  @Test
  public void object_acl_404_object_list() {
    BlobId id = tmpId();
    StorageException storageException =
        assertThrows(StorageException.class, () -> retry429s(() -> storage.listAcls(id), storage));

    assertThat(storageException.getCode()).isEqualTo(404);
  }

  @Test
  public void object_acl_404_object_create() {
    BlobId id = tmpId();
    StorageException storageException =
        assertThrows(
            StorageException.class, () -> retry429s(() -> storage.createAcl(id, readAll), storage));

    assertThat(storageException.getCode()).isEqualTo(404);
  }

  @Test
  public void object_acl_404_object_update() {
    BlobId id = tmpId();
    StorageException storageException =
        assertThrows(
            StorageException.class, () -> retry429s(() -> storage.updateAcl(id, readAll), storage));

    assertThat(storageException.getCode()).isEqualTo(404);
  }

  @Test
  public void object_acl_404_object_delete() {
    BlobId id = tmpId();
    // todo: json non-idempotent?
    boolean actual = retry429s(() -> storage.deleteAcl(id, User.ofAllUsers()), storage);

    assertThat(actual).isFalse();
  }

  /** When an object does exist, but an acl for the specified entity is not defined return null */
  @Test
  public void object_acl_404_acl_get() {
    BlobId id = tmpId();
    Acl acl = retry429s(() -> storage.getAcl(id, User.ofAllUsers()), storage);

    assertThat(acl).isNull();
  }

  /** Update of an acl that doesn't exist should create it */
  @Test
  @Ignore("TODO: fix b/468377909 to enable test again")
  public void object_acl_404_acl_update() {
    Blob mgen1 = tmpObject();

    Acl actual =
        // todo: json non-idempotent?
        retry429s(() -> storage.updateAcl(mgen1.getBlobId(), readAll), storage);

    assertThat(dropEtag(actual)).isEqualTo(readAll);
  }

  @Test
  public void object_acl_404_acl_delete() {
    Blob mgen1 = tmpObject();

    boolean actual =
        // todo: json non-idempotent?
        retry429s(() -> storage.deleteAcl(mgen1.getBlobId(), User.ofAllUsers()), storage);

    assertThat(actual).isFalse();
  }

  @Test
  public void object_acl_200_get() {
    // lookup an entity from the blob which is known to exist
    BlobId id = objectsFixture.getInfo1().getBlobId();
    Blob withAcls = storage.get(id, BlobGetOption.fields(BlobField.ACL));

    Acl expected = withAcls.getAcl().iterator().next();

    Acl acl = retry429s(() -> storage.getAcl(id, expected.getEntity()), storage);

    assertThat(acl).isEqualTo(expected);
  }

  @Test
  public void object_acl_200_list() {
    BlobId id = objectsFixture.getInfo1().getBlobId();
    // lookup an entity from the blob which is known to exist
    Blob withAcls = storage.get(id, BlobGetOption.fields(BlobField.ACL));

    Acl expected = withAcls.getAcl().iterator().next();

    List<Acl> acls = retry429s(() -> storage.listAcls(id), storage);

    assertThat(acls).contains(expected);
  }

  @Test
  @Ignore("TODO: fix b/468377909 to enable test again")
  public void object_acl_200_create() {
    Blob mgen1 = tmpObject();

    Acl readAll = Acl.of(User.ofAllAuthenticatedUsers(), Role.READER);
    Acl actual = retry429s(() -> storage.createAcl(mgen1.getBlobId(), readAll), storage);

    assertThat(actual.getEntity()).isEqualTo(readAll.getEntity());
    assertThat(actual.getRole()).isEqualTo(readAll.getRole());
    assertThat(actual.getEtag()).isNotEmpty();

    Blob updated = storage.get(mgen1.getBlobId(), BlobGetOption.fields(BlobField.values()));
    assertThat(updated.getMetageneration()).isNotEqualTo(mgen1.getMetageneration());

    // etags change when updates happen, drop before our comparison
    List<Acl> expectedAcls = dropEtags(mgen1.getAcl());
    List<Acl> actualAcls = dropEtags(updated.getAcl());
    assertThat(actualAcls).containsAtLeastElementsIn(expectedAcls);
    assertThat(actualAcls).contains(readAll);
  }

  @Test
  public void object_acl_200_update() {
    Blob mgen1 = tmpObject();

    List<Acl> acls = mgen1.getAcl();
    assertThat(acls).isNotEmpty();

    Predicate<Acl> isProjectEditor = hasProjectRole(ProjectRole.EDITORS);

    //noinspection OptionalGetWithoutIsPresent
    Acl projectEditorAsOwner =
        acls.stream().filter(hasRole(Role.OWNER).and(isProjectEditor)).findFirst().get();

    // lower the privileges of project editors to writer from owner
    Entity entity = projectEditorAsOwner.getEntity();
    Acl projectEditorAsReader = Acl.of(entity, Role.READER);

    Acl actual =
        retry429s(() -> storage.updateAcl(mgen1.getBlobId(), projectEditorAsReader), storage);

    assertThat(actual.getEntity()).isEqualTo(projectEditorAsReader.getEntity());
    assertThat(actual.getRole()).isEqualTo(projectEditorAsReader.getRole());
    assertThat(actual.getEtag()).isNotEmpty();

    Blob updated = storage.get(mgen1.getBlobId(), BlobGetOption.fields(BlobField.values()));
    assertThat(updated.getMetageneration()).isNotEqualTo(mgen1.getMetageneration());

    // etags change when updates happen, drop before our comparison
    List<Acl> expectedAcls =
        dropEtags(
            mgen1.getAcl().stream().filter(isProjectEditor.negate()).collect(Collectors.toList()));
    List<Acl> actualAcls = dropEtags(updated.getAcl());
    assertThat(actualAcls).containsAtLeastElementsIn(expectedAcls);
    assertThat(actualAcls).doesNotContain(projectEditorAsOwner);
    assertThat(actualAcls).contains(projectEditorAsReader);
  }

  @Test
  public void object_acl_200_delete() {
    Blob mgen1 = tmpObject();

    List<Acl> acls = mgen1.getAcl();
    assertThat(acls).isNotEmpty();

    Predicate<Acl> isProjectEditor = hasProjectRole(ProjectRole.EDITORS);

    //noinspection OptionalGetWithoutIsPresent
    Acl projectEditorAsOwner =
        acls.stream().filter(hasRole(Role.OWNER).and(isProjectEditor)).findFirst().get();

    // lower the privileges of project editors to writer from owner
    Entity entity = projectEditorAsOwner.getEntity();

    boolean actual = retry429s(() -> storage.deleteAcl(mgen1.getBlobId(), entity), storage);

    assertThat(actual).isTrue();

    Blob updated = storage.get(mgen1.getBlobId(), BlobGetOption.fields(BlobField.values()));
    assertThat(updated.getMetageneration()).isNotEqualTo(mgen1.getMetageneration());

    // etags change when updates happen, drop before our comparison
    List<Acl> expectedAcls =
        dropEtags(
            mgen1.getAcl().stream().filter(isProjectEditor.negate()).collect(Collectors.toList()));
    List<Acl> actualAcls = dropEtags(updated.getAcl());
    assertThat(actualAcls).containsAtLeastElementsIn(expectedAcls);
    assertThat(actualAcls).doesNotContain(projectEditorAsOwner);
    Optional<Entity> search =
        actualAcls.stream().map(Acl::getEntity).filter(e -> e.equals(entity)).findAny();
    assertThat(search.isPresent()).isFalse();
  }

  private BlobId tmpId() {
    return BlobId.of(bucketInfo.getName(), generator.randomObjectName());
  }

  private Blob tmpObject() {
    BlobId id = tmpId();
    BlobInfo info = BlobInfo.newBuilder(id).build();
    return storage.create(info, BlobTargetOption.doesNotExist());
  }
}
