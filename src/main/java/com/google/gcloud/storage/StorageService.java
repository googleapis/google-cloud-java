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

import com.google.gcloud.Service;

public interface StorageService extends Service<StorageServiceOptions> {

  //todo: implement add/delete bucket
  //todo: consider what to do with predefinedAcl

  Bucket get(String bucket);

  Blob get(String bucket, String blob);

  Iterable<Blob> list(ListOptions settings);

  Bucket update(Bucket bucket);

  Blob update(Blob blob);

  void delete(String bucket, String blob);

  Blob compose(String bucket, Iterable<String> srcBlobs, String destBlob);

  Blob copy(String srcBucket, String srcBlob, String destBucket, String destBlob);

  ObjectReadChannel newReader(String bucket, String blob);

  ObjectWriteChannel newWriter(Blob blob);
}
