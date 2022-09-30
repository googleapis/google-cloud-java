/*
 * Copyright 2022 Google LLC
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
 * <p>======================= DataCatalogClient =======================
 *
 * <p>Service Description: Data Catalog API service allows clients to discover, understand, and
 * manage their data.
 *
 * <p>Sample for DataCatalogClient:
 *
 * <pre>{@code
 * // This snippet has been automatically generated and should be regarded as a code template only.
 * // It will require modifications to work:
 * // - It may require correct/in-range values for request initialization.
 * // - It may require specifying regional endpoints when creating the service client as shown in
 * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
 * try (DataCatalogClient dataCatalogClient = DataCatalogClient.create()) {
 *   LocationName parent = LocationName.of("[PROJECT]", "[LOCATION]");
 *   String entryGroupId = "entryGroupId1228924712";
 *   EntryGroup entryGroup = EntryGroup.newBuilder().build();
 *   EntryGroup response = dataCatalogClient.createEntryGroup(parent, entryGroupId, entryGroup);
 * }
 * }</pre>
 *
 * <p>======================= PolicyTagManagerClient =======================
 *
 * <p>Service Description: The policy tag manager API service allows clients to manage their
 * taxonomies and policy tags.
 *
 * <p>Sample for PolicyTagManagerClient:
 *
 * <pre>{@code
 * // This snippet has been automatically generated and should be regarded as a code template only.
 * // It will require modifications to work:
 * // - It may require correct/in-range values for request initialization.
 * // - It may require specifying regional endpoints when creating the service client as shown in
 * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
 * try (PolicyTagManagerClient policyTagManagerClient = PolicyTagManagerClient.create()) {
 *   LocationName parent = LocationName.of("[PROJECT]", "[LOCATION]");
 *   Taxonomy taxonomy = Taxonomy.newBuilder().build();
 *   Taxonomy response = policyTagManagerClient.createTaxonomy(parent, taxonomy);
 * }
 * }</pre>
 *
 * <p>======================= PolicyTagManagerSerializationClient =======================
 *
 * <p>Service Description: Policy tag manager serialization API service allows clients to manipulate
 * their taxonomies and policy tags data with serialized format.
 *
 * <p>Sample for PolicyTagManagerSerializationClient:
 *
 * <pre>{@code
 * // This snippet has been automatically generated and should be regarded as a code template only.
 * // It will require modifications to work:
 * // - It may require correct/in-range values for request initialization.
 * // - It may require specifying regional endpoints when creating the service client as shown in
 * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
 * try (PolicyTagManagerSerializationClient policyTagManagerSerializationClient =
 *     PolicyTagManagerSerializationClient.create()) {
 *   ImportTaxonomiesRequest request =
 *       ImportTaxonomiesRequest.newBuilder()
 *           .setParent(LocationName.of("[PROJECT]", "[LOCATION]").toString())
 *           .build();
 *   ImportTaxonomiesResponse response =
 *       policyTagManagerSerializationClient.importTaxonomies(request);
 * }
 * }</pre>
 */
@Generated("by gapic-generator-java")
package com.google.cloud.datacatalog.v1beta1;

import javax.annotation.Generated;
