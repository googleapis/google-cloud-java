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

import static com.google.common.base.Preconditions.checkNotNull;

import java.util.List;

/**
 * A Google cloud storage bucket.
 */
public class Bucket {

  private final Storage storage;
  private final BucketInfo info;

  Bucket(Storage storage, BucketInfo info) {
    this.storage = checkNotNull(storage);
    this.info = checkNotNull(info);
  }

  public ListResult<BlobInfo> list(Storage.BlobListOption... options) {
    return storage.list(info.name(), options);
  }

  public List<Blob> get(String... blob) {
    // todo
    return null;
  }
}
