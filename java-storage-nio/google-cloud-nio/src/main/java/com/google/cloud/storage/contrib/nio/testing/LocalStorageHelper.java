/*
 * Copyright 2016 Google LLC
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

package com.google.cloud.storage.contrib.nio.testing;

import com.google.cloud.ServiceRpc;
import com.google.cloud.spi.ServiceRpcFactory;
import com.google.cloud.storage.StorageOptions;

/**
 * Utility to create an in-memory storage configuration for testing. Storage options can be obtained
 * via the {@link #getOptions()} method. Returned options will point to FakeStorageRpc.
 *
 * <p>Note, the created in-memory storage configuration supports limited set of operations and is
 * <b>not</b> thread-safe:
 *
 * <ul>
 *   <li>Supported operations
 *       <ul>
 *         <li>object create
 *         <li>object get
 *         <li>object delete
 *         <li>list the contents of a bucket
 *       </ul>
 *   <li>Unsupported operations
 *       <ul>
 *         <li>bucket create
 *         <li>bucket get
 *         <li>bucket delete
 *         <li>list all buckets
 *         <li>generations
 *         <li>file attributes
 *         <li>patch
 *         <li>continueRewrite
 *         <li>createBatch
 *         <li>checksums, etags
 *         <li>IAM operations
 *       </ul>
 * </ul>
 *
 * {@link FakeStorageRpc#list(String, java.util.Map)} lists all the objects that have been created
 * rather than the objects in the provided bucket. Since this class does not support creating,
 * listing and deleting buckets, the parameter bucket here is not actually used and on serves as a
 * placeholder.
 */
public final class LocalStorageHelper {

  // used for testing. Will throw if you pass it an option.
  private static final FakeStorageRpc instance = new FakeStorageRpc(true);

  private LocalStorageHelper() {}

  /**
   * Returns a {@link StorageOptions} that use the static FakeStorageRpc instance, and resets it
   * first so you start from a clean slate. That instance will throw if you pass it any option.
   */
  public static StorageOptions getOptions() {
    instance.reset();
    return StorageOptions.newBuilder()
        .setProjectId("fake-project-for-testing")
        .setServiceRpcFactory(new FakeStorageRpcFactory())
        .build();
  }

  /**
   * Returns a {@link StorageOptions} that creates a new FakeStorageRpc instance with the given
   * option.
   */
  public static StorageOptions customOptions(final boolean throwIfOptions) {
    return StorageOptions.newBuilder()
        .setProjectId("fake-project-for-testing")
        .setServiceRpcFactory(new FakeStorageRpcFactory(new FakeStorageRpc(throwIfOptions)))
        .build();
  }

  public static class FakeStorageRpcFactory implements ServiceRpcFactory<StorageOptions> {

    private final FakeStorageRpc instance;

    public FakeStorageRpcFactory() {
      this(LocalStorageHelper.instance);
    }

    public FakeStorageRpcFactory(FakeStorageRpc instance) {
      this.instance = instance;
    }

    @Override
    public ServiceRpc create(StorageOptions storageOptions) {
      return instance;
    }
  }
}
