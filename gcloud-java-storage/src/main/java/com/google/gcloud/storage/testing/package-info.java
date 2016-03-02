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

/**
 * Two testing helpers for Google Cloud Storage.
 *
 * RemoteGcsHelper helps with testing on the actual cloud.
 *
 * <p>A simple usage example:
 *
 * <p>Before the test:
 * <pre> {@code
 * RemoteGcsHelper gcsHelper = RemoteGcsHelper.create();
 * Storage storage = gcsHelper.options().service();
 * String bucket = RemoteGcsHelper.generateBucketName();
 * storage.create(BucketInfo.of(bucket));
 * } </pre>
 *
 * <p>After the test:
 * <pre> {@code
 * RemoteGcsHelper.forceDelete(storage, bucket, 5, TimeUnit.SECONDS);
 * } </pre>
 *
 * LocalGcsHelper helps with testing on an in-memory filesystem (this is best for unit tests).
 * Note that this filesystem isn't a complete implementation. In particular, it is not thread-safe.
 *
 * <p>A simple usage example:
 *
 * <pre>
 * CloudStorageFileSystemProvider.setGCloudOptions(LocalGcsHelper.options());
 * Path path = Paths.get(URI.create("gs://bucket/wednesday"));
 * thrown.expect(NoSuchFileException.class);
 * Files.newByteChannel(path);
 * </pre>
 *
 * <p>The first line ensures that the test uses the in-memory GCS instead of the real one
 * (note that you have to set the cloud options before the first usage of the gs:// prefix).
 *
 * @see <a href="https://github.com/GoogleCloudPlatform/gcloud-java/blob/master/TESTING.md#testing-code-that-uses-storage">
 *     gcloud-java tools for testing</a>
 */
package com.google.gcloud.storage.testing;
