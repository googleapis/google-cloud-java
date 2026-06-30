/*
 * Copyright 2015 Google LLC
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
 * A client for Cloud Storage - Unified object storage.
 *
 * <p>Here's a simple usage example the Java Storage client. This example shows how to create a
 * Storage object.
 *
 * <pre>{@code
 * Storage storage = StorageOptions.getDefaultInstance().getService();
 * BlobId blobId = BlobId.of("bucket", "blob_name");
 * BlobInfo blobInfo = BlobInfo.newBuilder(blobId).setContentType("text/plain").build();
 * Blob blob = storage.create(blobInfo, "Hello, Cloud Storage!".getBytes(UTF_8));
 * }</pre>
 *
 * <p>This second example shows how to update an object's content if the object exists.
 *
 * <pre>{@code
 * Storage storage = StorageOptions.getDefaultInstance().getService();
 * BlobId blobId = BlobId.of("bucket", "blob_name");
 * Blob blob = storage.get(blobId);
 * if (blob != null) {
 *   byte[] prevContent = blob.getContent();
 *   System.out.println(new String(prevContent, UTF_8));
 *   WritableByteChannel channel = blob.writer();
 *   channel.write(ByteBuffer.wrap("Updated content".getBytes(UTF_8)));
 *   channel.close();
 * }
 * }</pre>
 *
 * <p>For more detailed code examples, see the <a
 * href="https://cloud.google.com/storage/docs/samples">sample library</a>.
 *
 * <p>When using google-cloud from outside of App/Compute Engine, you have to <a
 * href="https://github.com/googleapis/google-cloud-java#specifying-a-project-id">specify a project
 * ID</a> and <a href="https://github.com/googleapis/google-cloud-java#authentication">provide
 * credentials</a>.
 *
 * <p>Operations in this library are generally thread safe, except for the use of <a
 * href="https://github.com/googleapis/java-storage/blob/main/google-cloud-storage/src/main/java/com/google/cloud/storage/BlobReadChannel.java">
 * BlobReadChannel</a> and <a
 * href="https://github.com/googleapis/java-storage/blob/main/google-cloud-storage/src/main/java/com/google/cloud/storage/BlobWriteChannel.java">
 * BlobWriteChannel</a>.
 *
 * <p>The GCS Java client library includes support to GCS via gRPC. When using GCS from Google
 * Compute Engine (GCE) this library enable higher total throughput across large workloads that run
 * on hundreds or thousands of VMs.
 *
 * <p>At present, GCS gRPC is GA with Allowlist. To access this API, kindly contact the Google Cloud
 * Storage gRPC team at gcs-grpc-contact@google.com with a list of GCS buckets you would like to
 * Allowlist. Please note that while the **service** is GA (with Allowlist), the client library
 * features remain experimental and subject to change without notice. The methods to create, list,
 * query, and delete HMAC keys and notifications are unavailable in gRPC transport.
 *
 * <p>This example shows how to enable gRPC with Direct Google Access only supported on Google
 * Compute Engine.
 *
 * <pre>{@code
 * StorageOptions options = StorageOptions.grpc().setAttemptDirectPath(true).build();
 * try (Storage storage = options.getService()) {
 * BlobId blobId = BlobId.of("bucket", "blob_name");
 * Blob blob = storage.get(blobId);
 * if (blob != null) {
 *   byte[] prevContent = blob.getContent();
 *   System.out.println(new String(prevContent, UTF_8));
 *   WritableByteChannel channel = blob.writer();
 *   channel.write(ByteBuffer.wrap("Updated content".getBytes(UTF_8)));
 *   channel.close();
 * }
 * }
 * }</pre>
 *
 * <p>This example shows how to enable gRPC.
 *
 * <pre>{@code
 * StorageOptions options = StorageOptions.grpc().build();
 * try (Storage storage = options.getService()) {
 * BlobId blobId = BlobId.of("bucket", "blob_name");
 * Blob blob = storage.get(blobId);
 * if (blob != null) {
 *   byte[] prevContent = blob.getContent();
 *   System.out.println(new String(prevContent, UTF_8));
 *   WritableByteChannel channel = blob.writer();
 *   channel.write(ByteBuffer.wrap("Updated content".getBytes(UTF_8)));
 *   channel.close();
 * }
 * }
 * }</pre>
 *
 * @see <a href="https://cloud.google.com/storage/">Google Cloud Storage</a>
 */
package com.google.cloud.storage;
