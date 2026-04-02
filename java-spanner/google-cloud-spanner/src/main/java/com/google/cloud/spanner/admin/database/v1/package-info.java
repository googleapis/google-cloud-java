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
 * A client to Cloud Spanner API
 *
 * <p>The interfaces provided are listed below, along with usage samples.
 *
 * <p>======================= DatabaseAdminClient =======================
 *
 * <p>Service Description: Cloud Spanner Database Admin API
 *
 * <p>The Cloud Spanner Database Admin API can be used to: &#42; create, drop, and list databases
 * &#42; update the schema of pre-existing databases &#42; create, delete, copy and list backups for
 * a database &#42; restore a database from an existing backup
 *
 * <p>Sample for DatabaseAdminClient:
 *
 * <pre>{@code
 * // This snippet has been automatically generated and should be regarded as a code template only.
 * // It will require modifications to work:
 * // - It may require correct/in-range values for request initialization.
 * // - It may require specifying regional endpoints when creating the service client as shown in
 * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
 * try (DatabaseAdminClient databaseAdminClient = DatabaseAdminClient.create()) {
 *   DatabaseName name = DatabaseName.of("[PROJECT]", "[INSTANCE]", "[DATABASE]");
 *   Database response = databaseAdminClient.getDatabase(name);
 * }
 * }</pre>
 */
@Generated("by gapic-generator-java")
package com.google.cloud.spanner.admin.database.v1;

import javax.annotation.Generated;
