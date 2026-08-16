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
 * A client to Lakehouse API
 *
 * <p>The interfaces provided are listed below, along with usage samples.
 *
 * <p>======================= IcebergCatalogServiceClient =======================
 *
 * <p>Service Description: Lakehouse runtime catalog supports the following catalog management
 * methods: - GetIcebergCatalog - ListIcebergCatalogs - DeleteIcebergCatalog - UpdateIcebergCatalog
 * - CreateIcebergCatalog - FailoverIcebergCatalog
 *
 * <p>Sample for IcebergCatalogServiceClient:
 *
 * <pre>{@code
 * // This snippet has been automatically generated and should be regarded as a code template only.
 * // It will require modifications to work:
 * // - It may require correct/in-range values for request initialization.
 * // - It may require specifying regional endpoints when creating the service client as shown in
 * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
 * try (IcebergCatalogServiceClient icebergCatalogServiceClient =
 *     IcebergCatalogServiceClient.create()) {
 *   CatalogName name = CatalogName.of("[PROJECT]", "[CATALOG]");
 *   IcebergCatalog response = icebergCatalogServiceClient.getIcebergCatalog(name);
 * }
 * }</pre>
 */
@Generated("by gapic-generator-java")
package com.google.cloud.biglake.v1;

import javax.annotation.Generated;
