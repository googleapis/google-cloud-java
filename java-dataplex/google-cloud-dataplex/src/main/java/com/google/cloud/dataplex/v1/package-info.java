/*
 * Copyright 2021 Google LLC
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
 * <p>======================= MetadataServiceClient =======================
 *
 * <p>Service Description: Metadata service manages metadata resources such as tables, filesets and
 * partitions.
 *
 * <p>Sample for MetadataServiceClient:
 *
 * <pre>{@code
 * try (MetadataServiceClient metadataServiceClient = MetadataServiceClient.create()) {
 *   EntityName name = EntityName.of("[PROJECT]", "[LOCATION]", "[LAKE]", "[ZONE]", "[ENTITY]");
 *   Entity response = metadataServiceClient.getEntity(name);
 * }
 * }</pre>
 *
 * <p>======================= DataplexServiceClient =======================
 *
 * <p>Service Description: Dataplex service provides data lakes as a service. The primary resources
 * offered by this service are Lakes, Zones and Assets which collectively allow a data adminstrator
 * to organize, manage, secure and catalog data across their organization located across cloud
 * projects in a variety of storage systems including Cloud Storage and BigQuery.
 *
 * <p>Sample for DataplexServiceClient:
 *
 * <pre>{@code
 * try (DataplexServiceClient dataplexServiceClient = DataplexServiceClient.create()) {
 *   LakeName name = LakeName.of("[PROJECT]", "[LOCATION]", "[LAKE]");
 *   Lake response = dataplexServiceClient.getLake(name);
 * }
 * }</pre>
 */
@Generated("by gapic-generator-java")
package com.google.cloud.dataplex.v1;

import javax.annotation.Generated;
