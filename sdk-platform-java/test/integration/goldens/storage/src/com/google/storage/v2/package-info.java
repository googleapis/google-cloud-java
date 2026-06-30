/*
 * Copyright 2026 Google LLC
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      https://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

/**
 * The interfaces provided are listed below, along with usage samples.
 *
 * <p>======================= StorageClient =======================
 *
 * <p>Service Description: ## API Overview and Naming Syntax
 *
 * <p>The Cloud Storage gRPC API allows applications to read and write data through the abstractions
 * of buckets and objects. For a description of these abstractions please see
 * https://cloud.google.com/storage/docs.
 *
 * <p>Resources are named as follows: - Projects are referred to as they are defined by the Resource
 * Manager API, using strings like `projects/123456` or `projects/my-string-id`. - Buckets are named
 * using string names of the form: `projects/{project}/buckets/{bucket}` For globally unique
 * buckets, `_` may be substituted for the project. - Objects are uniquely identified by their name
 * along with the name of the bucket they belong to, as separate strings in this API. For example:
 *
 * <p>ReadObjectRequest { bucket: 'projects/_/buckets/my-bucket' object: 'my-object' } Note that
 * object names can contain `/` characters, which are treated as any other character (no special
 * directory semantics).
 *
 * <p>Sample for StorageClient:
 *
 * <pre>{@code
 * // This snippet has been automatically generated and should be regarded as a code template only.
 * // It will require modifications to work:
 * // - It may require correct/in-range values for request initialization.
 * // - It may require specifying regional endpoints when creating the service client as shown in
 * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
 * try (StorageClient storageClient = StorageClient.create()) {
 *   BucketName name = BucketName.of("[PROJECT]", "[BUCKET]");
 *   storageClient.deleteBucket(name);
 * }
 * }</pre>
 */
@Generated("by gapic-generator-java")
package com.google.storage.v2;

import javax.annotation.Generated;
