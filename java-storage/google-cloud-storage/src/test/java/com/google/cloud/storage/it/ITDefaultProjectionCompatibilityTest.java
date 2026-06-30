/*
 * Copyright 2023 Google LLC
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

import com.google.cloud.storage.Acl;
import com.google.cloud.storage.Acl.Entity;
import com.google.cloud.storage.Blob;
import com.google.cloud.storage.Bucket;
import com.google.cloud.storage.BucketInfo;
import com.google.cloud.storage.Storage;
import com.google.cloud.storage.Storage.BlobListOption;
import com.google.cloud.storage.Storage.BucketListOption;
import com.google.cloud.storage.TransportCompatibility.Transport;
import com.google.cloud.storage.it.runner.StorageITRunner;
import com.google.cloud.storage.it.runner.annotations.Backend;
import com.google.cloud.storage.it.runner.annotations.Inject;
import com.google.cloud.storage.it.runner.annotations.SingleBackend;
import com.google.cloud.storage.it.runner.annotations.StorageFixture;
import com.google.cloud.storage.it.runner.registry.ObjectsFixture;
import com.google.common.base.MoreObjects;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;
import org.checkerframework.checker.nullness.qual.NonNull;
import org.checkerframework.checker.nullness.qual.Nullable;
import org.junit.Test;
import org.junit.runner.RunWith;

@RunWith(StorageITRunner.class)
@SingleBackend(Backend.PROD)
public final class ITDefaultProjectionCompatibilityTest {

  @Inject
  @StorageFixture(Transport.HTTP)
  public Storage http;

  @Inject
  @StorageFixture(Transport.GRPC)
  public Storage grpc;

  @Inject public BucketInfo bucket;

  @Inject public ObjectsFixture objectsFixture;

  @Test
  public void objectMetadata_includesAcls() {
    Blob httpBlob = http.get(objectsFixture.getInfo1().getBlobId());
    Blob grpcBlob = grpc.get(objectsFixture.getInfo1().getBlobId());

    assertThat(extractFromBlob(grpcBlob)).isEqualTo(extractFromBlob(httpBlob));
  }

  @Test
  public void listObjectMetadata_includesAcls() {
    String bucketName = bucket.getName();
    BlobListOption prefix = BlobListOption.prefix(objectsFixture.getInfo1().getBlobId().getName());
    List<Blob> httpBlob = http.list(bucketName, prefix).streamAll().collect(Collectors.toList());
    List<Blob> grpcBlob = grpc.list(bucketName, prefix).streamAll().collect(Collectors.toList());

    List<AclRelatedFields> a = extractFromBlobs(httpBlob);
    List<AclRelatedFields> b = extractFromBlobs(grpcBlob);

    assertThat(a).isEqualTo(b);
  }

  @Test
  public void bucketMetadata_includesAcls() {
    Bucket httpBucket = http.get(bucket.getName());
    Bucket grpcBucket = grpc.get(bucket.getName());

    assertThat(extractFromBucket(httpBucket)).isEqualTo(extractFromBucket(grpcBucket));
  }

  @Test
  public void listBucketMetadata_includesAcls() {
    BucketListOption prefix = BucketListOption.prefix(bucket.getName());
    List<Bucket> httpBucket = http.list(prefix).streamAll().collect(Collectors.toList());
    List<Bucket> grpcBucket = grpc.list(prefix).streamAll().collect(Collectors.toList());

    List<AclRelatedFields> a = extractFromBuckets(httpBucket);
    List<AclRelatedFields> b = extractFromBuckets(grpcBucket);

    assertThat(a).isEqualTo(b);
  }

  @NonNull
  private static List<AclRelatedFields> extractFromBlobs(List<Blob> httpBlob) {
    return httpBlob.stream()
        .map(ITDefaultProjectionCompatibilityTest::extractFromBlob)
        .collect(Collectors.toList());
  }

  @NonNull
  private static AclRelatedFields extractFromBlob(Blob b) {
    return new AclRelatedFields(b.getOwner(), b.getAcl(), null);
  }

  @NonNull
  private static List<AclRelatedFields> extractFromBuckets(List<Bucket> httpBucket) {
    return httpBucket.stream()
        .map(ITDefaultProjectionCompatibilityTest::extractFromBucket)
        .collect(Collectors.toList());
  }

  @NonNull
  private static AclRelatedFields extractFromBucket(Bucket b) {
    return new AclRelatedFields(b.getOwner(), b.getAcl(), null);
  }

  private static final class AclRelatedFields {
    @Nullable private final Entity owner;
    @Nullable private final List<Acl> acls;
    @Nullable private final List<Acl> defaultAcls;

    private AclRelatedFields(
        @Nullable Entity owner, @Nullable List<Acl> acls, @Nullable List<Acl> defaultAcls) {
      this.owner = owner;
      this.acls = acls;
      this.defaultAcls = defaultAcls;
    }

    @Override
    public boolean equals(Object o) {
      if (this == o) {
        return true;
      }
      if (!(o instanceof AclRelatedFields)) {
        return false;
      }
      AclRelatedFields that = (AclRelatedFields) o;
      return Objects.equals(owner, that.owner)
          && Objects.equals(acls, that.acls)
          && Objects.equals(defaultAcls, that.defaultAcls);
    }

    @Override
    public int hashCode() {
      return Objects.hash(owner, acls, defaultAcls);
    }

    @Override
    public String toString() {
      return MoreObjects.toStringHelper(this)
          .add("owner", owner)
          .add("acls", acls)
          .add("defaultAcls", defaultAcls)
          .toString();
    }
  }
}
