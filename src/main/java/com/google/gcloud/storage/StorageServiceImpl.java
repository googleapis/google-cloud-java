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
  public Bucket get(String bucket) {
    try {
      return Bucket.fromPb(storageRpc.get(bucket));
    } catch (IOException ex) {
      throw new StorageServiceException(ex);
    }
  }

  @Override
  public Blob get(String bucket, String object) {
    try {
      return Blob.fromPb(storageRpc.get(bucket, object));
    } catch (IOException ex) {
      throw new StorageServiceException(ex);
    }
  }

  @Override
  public Iterable<Blob> list(ListOptions settings) {
    return null;
  }

  @Override
  public Bucket update(Bucket bucket) {
    return null;
  }

  @Override
  public Blob update(Blob blob) {
    return null;
  }

  @Override
  public void delete(String bucket, String object) {

  }

  @Override
  public Blob compose(String bucket, Iterable<String> sourceObjects, String destObject) {
    return null;
  }

  @Override
  public Blob copy(String fromBucket, String fromObject, String destBucket,
      String destObject) {
    return null;
  }

  @Override
  public ObjectReadChannel newReader(String bucket, String ObjectName) {
    return null;
  }

  @Override
  public ObjectWriteChannel newWriter(Blob blob) {
    return null;
  }
}
