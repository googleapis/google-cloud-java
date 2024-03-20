/*
 * Copyright 2024 Google LLC
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
 * A client to Cloud Dataplex API
 *
 * <p>The interfaces provided are listed below, along with usage samples.
 *
 * <p>======================= CatalogServiceClient =======================
 *
 * <p>Service Description: The primary resources offered by this service are EntryGroups,
 * EntryTypes, AspectTypes, Entry and Aspect which collectively allow a data administrator to
 * organize, manage, secure and catalog data across their organization located across cloud projects
 * in a variety of storage systems including Cloud Storage and BigQuery.
 *
 * <p>Sample for CatalogServiceClient:
 *
 * <pre>{@code
 * // This snippet has been automatically generated and should be regarded as a code template only.
 * // It will require modifications to work:
 * // - It may require correct/in-range values for request initialization.
 * // - It may require specifying regional endpoints when creating the service client as shown in
 * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
 * try (CatalogServiceClient catalogServiceClient = CatalogServiceClient.create()) {
 *   EntryTypeName name = EntryTypeName.of("[PROJECT]", "[LOCATION]", "[ENTRY_TYPE]");
 *   EntryType response = catalogServiceClient.getEntryType(name);
 * }
 * }</pre>
 *
 * <p>======================= ContentServiceClient =======================
 *
 * <p>Service Description: ContentService manages Notebook and SQL Scripts for Dataplex.
 *
 * <p>Sample for ContentServiceClient:
 *
 * <pre>{@code
 * // This snippet has been automatically generated and should be regarded as a code template only.
 * // It will require modifications to work:
 * // - It may require correct/in-range values for request initialization.
 * // - It may require specifying regional endpoints when creating the service client as shown in
 * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
 * try (ContentServiceClient contentServiceClient = ContentServiceClient.create()) {
 *   LakeName parent = LakeName.of("[PROJECT]", "[LOCATION]", "[LAKE]");
 *   Content content = Content.newBuilder().build();
 *   Content response = contentServiceClient.createContent(parent, content);
 * }
 * }</pre>
 *
 * <p>======================= DataTaxonomyServiceClient =======================
 *
 * <p>Service Description: DataTaxonomyService enables attribute-based governance. The resources
 * currently offered include DataTaxonomy and DataAttribute.
 *
 * <p>Sample for DataTaxonomyServiceClient:
 *
 * <pre>{@code
 * // This snippet has been automatically generated and should be regarded as a code template only.
 * // It will require modifications to work:
 * // - It may require correct/in-range values for request initialization.
 * // - It may require specifying regional endpoints when creating the service client as shown in
 * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
 * try (DataTaxonomyServiceClient dataTaxonomyServiceClient = DataTaxonomyServiceClient.create()) {
 *   DataTaxonomyName name = DataTaxonomyName.of("[PROJECT]", "[LOCATION]", "[DATA_TAXONOMY_ID]");
 *   DataTaxonomy response = dataTaxonomyServiceClient.getDataTaxonomy(name);
 * }
 * }</pre>
 *
 * <p>======================= DataScanServiceClient =======================
 *
 * <p>Service Description: DataScanService manages DataScan resources which can be configured to run
 * various types of data scanning workload and generate enriched metadata (e.g. Data Profile, Data
 * Quality) for the data source.
 *
 * <p>Sample for DataScanServiceClient:
 *
 * <pre>{@code
 * // This snippet has been automatically generated and should be regarded as a code template only.
 * // It will require modifications to work:
 * // - It may require correct/in-range values for request initialization.
 * // - It may require specifying regional endpoints when creating the service client as shown in
 * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
 * try (DataScanServiceClient dataScanServiceClient = DataScanServiceClient.create()) {
 *   DataScanName name = DataScanName.of("[PROJECT]", "[LOCATION]", "[DATASCAN]");
 *   DataScan response = dataScanServiceClient.getDataScan(name);
 * }
 * }</pre>
 *
 * <p>======================= MetadataServiceClient =======================
 *
 * <p>Service Description: Metadata service manages metadata resources such as tables, filesets and
 * partitions.
 *
 * <p>Sample for MetadataServiceClient:
 *
 * <pre>{@code
 * // This snippet has been automatically generated and should be regarded as a code template only.
 * // It will require modifications to work:
 * // - It may require correct/in-range values for request initialization.
 * // - It may require specifying regional endpoints when creating the service client as shown in
 * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
 * try (MetadataServiceClient metadataServiceClient = MetadataServiceClient.create()) {
 *   ZoneName parent = ZoneName.of("[PROJECT]", "[LOCATION]", "[LAKE]", "[ZONE]");
 *   Entity entity = Entity.newBuilder().build();
 *   Entity response = metadataServiceClient.createEntity(parent, entity);
 * }
 * }</pre>
 *
 * <p>======================= DataplexServiceClient =======================
 *
 * <p>Service Description: Dataplex service provides data lakes as a service. The primary resources
 * offered by this service are Lakes, Zones and Assets which collectively allow a data administrator
 * to organize, manage, secure and catalog data across their organization located across cloud
 * projects in a variety of storage systems including Cloud Storage and BigQuery.
 *
 * <p>Sample for DataplexServiceClient:
 *
 * <pre>{@code
 * // This snippet has been automatically generated and should be regarded as a code template only.
 * // It will require modifications to work:
 * // - It may require correct/in-range values for request initialization.
 * // - It may require specifying regional endpoints when creating the service client as shown in
 * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
 * try (DataplexServiceClient dataplexServiceClient = DataplexServiceClient.create()) {
 *   LakeName name = LakeName.of("[PROJECT]", "[LOCATION]", "[LAKE]");
 *   Lake response = dataplexServiceClient.getLake(name);
 * }
 * }</pre>
 */
@Generated("by gapic-generator-java")
package com.google.cloud.dataplex.v1;

import javax.annotation.Generated;
