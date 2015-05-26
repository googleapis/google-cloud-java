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
 * A client to Google Cloud Storage.
 *
 * <p>A simple usage example:
 * <pre>{@code
 * StorageServiceOptions options = StorageServiceOptions.builder().projectId("project").build();
 * StorageService storage = StorageServiceFactory.instance().get(options);
 * byte[] content = readContent();
 * Blob blob = storage.get("bucket", "blob_name");
 * if (blob == null) {
 *   storage.create(Blob.of("bucket", "blob_name"), content);
 * } else {
 *   byte[] prevContent = storage.load("bucket", "blob_name");
 *   content = mergeContent(prevContent, content);
 *   WritableByteChannel channel = storage.writer(blob);
 *   channel.write(ByteBuffer.wrap(content));
 *   channel.close();
 * }}</pre>
 *
 * @see <a href="https://cloud.google.com/storage/">Google Cloud Storage</a>
 */
package com.google.gcloud.storage;

