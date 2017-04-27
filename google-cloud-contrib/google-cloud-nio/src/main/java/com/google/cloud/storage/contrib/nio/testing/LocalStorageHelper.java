/*
 * Copyright 2016 Google Inc. All Rights Reserved.
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

import com.google.cloud.spi.ServiceRpcFactory;
import com.google.cloud.storage.spi.v1.StorageRpc;
import com.google.cloud.storage.StorageOptions;

/**
 * Utility to create an in-memory storage configuration for testing. Storage options can be
 * obtained via the {@link #getOptions()} method. Returned options will point to FakeStorageRpc.
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
      .setProjectId("dummy-project-for-testing")
      .setServiceRpcFactory(
        new ServiceRpcFactory<StorageOptions>() {
          @Override
          public StorageRpc create(StorageOptions options) {
            return instance;
          }
        })
      .build();
  }

  /**
   * Returns a {@link StorageOptions} that creates a new FakeStorageRpc instance with the given
   * option.
   */
  public static StorageOptions customOptions(final boolean throwIfOptions) {
    return StorageOptions.newBuilder()
      .setProjectId("dummy-project-for-testing")
      .setServiceRpcFactory(
         new ServiceRpcFactory<StorageOptions>() {
           @Override
           public StorageRpc create(StorageOptions options) {
             return new FakeStorageRpc(throwIfOptions);
           }
         })
      .build();
  }
}
