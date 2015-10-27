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
 * StorageOptions options = StorageOptions.builder().projectId("project").build();
 * Storage storage = options.service();
 * BlobId blobId = BlobId.of("bucket", "blob_name");
 * Blob blob = Blob.load(storage, blobId);
 * if (blob == null) {
 *   BlobInfo blobInfo = BlobInfo.builder(blobId).contentType("text/plain").build();
 *   storage.create(blobInfo, "Hello, Cloud Storage!".getBytes(UTF_8));
 * } else {
 *   System.out.println("Updating content for " + blobId.name());
 *   byte[] prevContent = blob.content();
 *   System.out.println(new String(prevContent, UTF_8));
 *   WritableByteChannel channel = blob.writer();
 *   channel.write(ByteBuffer.wrap("Updated content".getBytes(UTF_8)));
 *   channel.close();
 * }}</pre>
 *
 * @see <a href="https://cloud.google.com/storage/">Google Cloud Storage</a>
 */
package com.google.gcloud.storage;

