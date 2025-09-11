/*
 * Copyright 2025 Google LLC
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
 * A client to BigLake API
 *
 * <p>The interfaces provided are listed below, along with usage samples.
 *
 * <p>======================= IcebergCatalogServiceClient =======================
 *
 * <p>Service Description: Iceberg Catalog Service API: this implements the open-source Iceberg REST
 * Catalog API. See the API definition here:
 * https://github.com/apache/iceberg/blob/main/open-api/rest-catalog-open-api.yaml
 *
 * <p>The API is defined as OpenAPI 3.1.1 spec.
 *
 * <p>Currently we only support the following methods: - GetConfig/GetIcebergCatalogConfig -
 * ListIcebergNamespaces - CheckIcebergNamespaceExists - GetIcebergNamespace -
 * CreateIcebergNamespace (only supports single level) - DeleteIcebergNamespace -
 * UpdateIcebergNamespace properties - ListTableIdentifiers - CreateIcebergTable -
 * DeleteIcebergTable - GetIcebergTable - UpdateIcebergTable (CommitTable) -
 * LoadIcebergTableCredentials - RegisterTable
 *
 * <p>Users are required to provided the `X-Goog-User-Project` header with the project id or number
 * which can be different from the bucket project id. That project will be charged for the API calls
 * and the calling user must have access to that project. The caller must have
 * `serviceusage.services.use` permission on the project.
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
