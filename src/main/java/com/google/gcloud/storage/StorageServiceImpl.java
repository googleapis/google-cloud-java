/*
 * Copyright 2015 Google Inc. All Rights Reserved.
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

package com.google.gcloud.storage;

import com.google.common.base.Function;
import com.google.common.collect.Iterables;
import com.google.gcloud.BaseService;
import com.google.gcloud.spi.StorageRpc;

import java.io.IOException;

final class StorageServiceImpl extends BaseService<StorageServiceOptions> implements StorageService {

  private final StorageRpc storageRpc;

  StorageServiceImpl(StorageServiceOptions options) {
    super(options);
    storageRpc = options.storageRpc();
  }

  @Override
  public Iterable<Bucket> listBuckets() {
    try {
      return Iterables.transform(storageRpc.buckets(),
          new Function<com.google.api.services.storage.model.Bucket, Bucket>() {
            @Override public Bucket apply(com.google.api.services.storage.model.Bucket model) {
              return new BucketImpl(StorageServiceImpl.this, model);
            }
          });
    } catch (IOException ex) {
      throw new StorageServiceException(ex);
    }
  }

  @Override
  public Bucket getBucket(String bucket) {
    try {
      return new BucketImpl(this, storageRpc.bucket(bucket));
    } catch (IOException ex) {
      throw new StorageServiceException(ex);
    }
  }
}
