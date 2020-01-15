/*
 * Copyright 2020 Google LLC
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     https://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

/**
 * A client to Google Cloud Data Catalog API.
 *
 * <p>The interfaces provided are listed below, along with usage samples.
 *
 * <p>================= DataCatalogClient =================
 *
 * <p>Service Description: Data Catalog API service allows clients to discover, understand, and
 * manage their data.
 *
 * <p>Sample for DataCatalogClient:
 *
 * <pre>
 * <code>
 * try (DataCatalogClient dataCatalogClient = DataCatalogClient.create()) {
 *   String formattedParent = DataCatalogClient.formatLocationName("[PROJECT]", "[LOCATION]");
 *   String entryGroupId = "";
 *   EntryGroup entryGroup = EntryGroup.newBuilder().build();
 *   EntryGroup response = dataCatalogClient.createEntryGroup(formattedParent, entryGroupId, entryGroup);
 * }
 * </code>
 * </pre>
 *
 * ====================== PolicyTagManagerClient ======================
 *
 * <p>Service Description: The policy tag manager API service allows clients to manage their
 * taxonomies and policy tags.
 *
 * <p>Sample for PolicyTagManagerClient:
 *
 * <pre>
 * <code>
 * try (PolicyTagManagerClient policyTagManagerClient = PolicyTagManagerClient.create()) {
 *   CreateTaxonomyRequest request = CreateTaxonomyRequest.newBuilder().build();
 *   Taxonomy response = policyTagManagerClient.createTaxonomy(request);
 * }
 * </code>
 * </pre>
 *
 * =================================== PolicyTagManagerSerializationClient
 * ===================================
 *
 * <p>Service Description: Policy tag manager serialization API service allows clients to manipulate
 * their taxonomies and policy tags data with serialized format.
 *
 * <p>Sample for PolicyTagManagerSerializationClient:
 *
 * <pre>
 * <code>
 * try (PolicyTagManagerSerializationClient policyTagManagerSerializationClient = PolicyTagManagerSerializationClient.create()) {
 *   ImportTaxonomiesRequest request = ImportTaxonomiesRequest.newBuilder().build();
 *   ImportTaxonomiesResponse response = policyTagManagerSerializationClient.importTaxonomies(request);
 * }
 * </code>
 * </pre>
 */
@Generated("by gapic-generator")
package com.google.cloud.datacatalog.v1beta1;

import javax.annotation.Generated;
