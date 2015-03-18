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

import java.util.Iterator;

public interface StorageService extends Service<StorageServiceOptions> {

  Iterable<BucketInfo> list();

  Iterable<ObjectInfo> list(ListOptions settings);

  BucketInfo get(String bucket);

  Iterator<BucketInfo> get(String... bucket);

  ObjectInfo get(String bucket, String object);

  Iterator<ObjectInfo> get(String bucket, String... object);

  void update(BucketInfo bucketInfo);

  void update(ObjectInfo objectInfo);

  void delete(String bucket, String... object);

  void compose(String bucket, Iterable<String> sourceObjects, String destObject);

  void copy(String fromBucket, String fromObject, String destBucket, String destObject);


  ObjectReadChannel getInputChannel(String bucket, String ObjectName);

  ObjectWriteChannel write(String ObjectName);

  // TODO: add listing

  ObjectReadChannel getInputChannel();

  ObjectWriteChannel getOutputChannel();
}
