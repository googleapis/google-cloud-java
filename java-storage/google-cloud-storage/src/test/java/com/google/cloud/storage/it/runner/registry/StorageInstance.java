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

package com.google.cloud.storage.it.runner.registry;

import com.google.cloud.Policy;
import com.google.cloud.storage.Acl;
import com.google.cloud.storage.Acl.Entity;
import com.google.cloud.storage.Bucket;
import com.google.cloud.storage.BucketInfo;
import com.google.cloud.storage.Storage;
import com.google.cloud.storage.StorageOptions;

final class StorageInstance implements ManagedLifecycle {

  private final StorageOptions options;
  private Storage storage;

  private Storage proxy;

  private final ProtectedBucketNames protectedBucketNames;

  StorageInstance(StorageOptions options, ProtectedBucketNames protectedBucketNames) {
    this.options = options;
    this.protectedBucketNames = protectedBucketNames;
  }

  Storage getStorage() {
    return storage;
  }

  @Override
  public Object get() {
    return proxy;
  }

  @Override
  public void start() {
    storage = options.getService();
    proxy = new VetoingStorageProxy();
  }

  @Override
  public void stop() {
    try (Storage ignore = storage) {
      storage = null;
      proxy = null;
    } catch (Exception e) {
      throw new RuntimeException(e);
    }
  }

  private static VetoedBucketUpdateException err(String bucketName) {
    return new VetoedBucketUpdateException("Attempted to modify global bucket: " + bucketName);
  }

  private static class VetoException extends RuntimeException {
    private VetoException(String message) {
      super(message);
    }
  }

  private static final class VetoedBucketUpdateException extends VetoException {
    private VetoedBucketUpdateException(String message) {
      super(message);
    }
  }

  /**
   * Define a proxy which can veto calls attempting to mutate protected buckets. this helps guard
   * against a test trying to mutate the global bucket rather than creating its own bucket.
   */
  private final class VetoingStorageProxy extends AbstractStorageProxy {

    private VetoingStorageProxy() {
      super(storage);
    }

    @Override
    public Bucket update(BucketInfo bucketInfo, BucketTargetOption... options) {
      checkBucketProtected(bucketInfo);
      return super.update(bucketInfo, options);
    }

    @Override
    public boolean delete(String bucket, BucketSourceOption... options) {
      checkBucketProtected(bucket);
      return super.delete(bucket, options);
    }

    @Override
    public Policy setIamPolicy(String bucket, Policy policy, BucketSourceOption... options) {
      checkBucketProtected(bucket);
      return super.setIamPolicy(bucket, policy, options);
    }

    @Override
    public boolean deleteDefaultAcl(String bucket, Entity entity) {
      checkBucketProtected(bucket);
      return super.deleteDefaultAcl(bucket, entity);
    }

    @Override
    public Acl createDefaultAcl(String bucket, Acl acl) {
      checkBucketProtected(bucket);
      return super.createDefaultAcl(bucket, acl);
    }

    @Override
    public Acl updateDefaultAcl(String bucket, Acl acl) {
      checkBucketProtected(bucket);
      return super.updateDefaultAcl(bucket, acl);
    }

    @Override
    public boolean deleteAcl(String bucket, Entity entity, BucketSourceOption... options) {
      checkBucketProtected(bucket);
      return super.deleteAcl(bucket, entity, options);
    }

    @Override
    public boolean deleteAcl(String bucket, Entity entity) {
      checkBucketProtected(bucket);
      return super.deleteAcl(bucket, entity);
    }

    @Override
    public Acl createAcl(String bucket, Acl acl, BucketSourceOption... options) {
      checkBucketProtected(bucket);
      return super.createAcl(bucket, acl, options);
    }

    @Override
    public Acl createAcl(String bucket, Acl acl) {
      checkBucketProtected(bucket);
      return super.createAcl(bucket, acl);
    }

    @Override
    public Acl updateAcl(String bucket, Acl acl, BucketSourceOption... options) {
      checkBucketProtected(bucket);
      return super.updateAcl(bucket, acl, options);
    }

    @Override
    public Acl updateAcl(String bucket, Acl acl) {
      checkBucketProtected(bucket);
      return super.updateAcl(bucket, acl);
    }

    @Override
    public Bucket lockRetentionPolicy(BucketInfo bucket, BucketTargetOption... options) {
      checkBucketProtected(bucket);
      return super.lockRetentionPolicy(bucket, options);
    }

    @Override
    public void close() throws Exception {
      throw new VetoException("Called #close() on global Storage instance");
    }

    private void checkBucketProtected(BucketInfo bucket) {
      checkBucketProtected(bucket.getName());
    }

    private void checkBucketProtected(String bucketName) {
      if (protectedBucketNames.isProtected(bucketName)) {
        throw err(bucketName);
      }
    }
  }
}
