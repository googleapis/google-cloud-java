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
 * A client to Vector Search API
 *
 * <p>The interfaces provided are listed below, along with usage samples.
 *
 * <p>======================= DataObjectSearchServiceClient =======================
 *
 * <p>Service Description: Service for searching data objects.
 *
 * <p>Sample for DataObjectSearchServiceClient:
 *
 * <pre>{@code
 * // This snippet has been automatically generated and should be regarded as a code template only.
 * // It will require modifications to work:
 * // - It may require correct/in-range values for request initialization.
 * // - It may require specifying regional endpoints when creating the service client as shown in
 * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
 * try (DataObjectSearchServiceClient dataObjectSearchServiceClient =
 *     DataObjectSearchServiceClient.create()) {
 *   AggregateDataObjectsRequest request =
 *       AggregateDataObjectsRequest.newBuilder()
 *           .setParent(CollectionName.of("[PROJECT]", "[LOCATION]", "[COLLECTION]").toString())
 *           .setFilter(Struct.newBuilder().build())
 *           .setAggregate(AggregationMethod.forNumber(0))
 *           .build();
 *   AggregateDataObjectsResponse response =
 *       dataObjectSearchServiceClient.aggregateDataObjects(request);
 * }
 * }</pre>
 *
 * <p>======================= DataObjectServiceClient =======================
 *
 * <p>Service Description: Service for creating and managing data objects.
 *
 * <p>Sample for DataObjectServiceClient:
 *
 * <pre>{@code
 * // This snippet has been automatically generated and should be regarded as a code template only.
 * // It will require modifications to work:
 * // - It may require correct/in-range values for request initialization.
 * // - It may require specifying regional endpoints when creating the service client as shown in
 * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
 * try (DataObjectServiceClient dataObjectServiceClient = DataObjectServiceClient.create()) {
 *   CollectionName parent = CollectionName.of("[PROJECT]", "[LOCATION]", "[COLLECTION]");
 *   DataObject dataObject = DataObject.newBuilder().build();
 *   String dataObjectId = "dataObjectId1417732740";
 *   DataObject response =
 *       dataObjectServiceClient.createDataObject(parent, dataObject, dataObjectId);
 * }
 * }</pre>
 *
 * <p>======================= VectorSearchServiceClient =======================
 *
 * <p>Service Description: VectorSearchService provides methods for managing Collection resources,
 * and Collection Index resources. The primary resources offered by this service are Collections
 * which are a container for a set of related JSON data objects, and Collection Indexes which enable
 * efficient ANN search across data objects within a Collection.
 *
 * <p>Sample for VectorSearchServiceClient:
 *
 * <pre>{@code
 * // This snippet has been automatically generated and should be regarded as a code template only.
 * // It will require modifications to work:
 * // - It may require correct/in-range values for request initialization.
 * // - It may require specifying regional endpoints when creating the service client as shown in
 * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
 * try (VectorSearchServiceClient vectorSearchServiceClient = VectorSearchServiceClient.create()) {
 *   CollectionName name = CollectionName.of("[PROJECT]", "[LOCATION]", "[COLLECTION]");
 *   Collection response = vectorSearchServiceClient.getCollection(name);
 * }
 * }</pre>
 */
@Generated("by gapic-generator-java")
package com.google.cloud.vectorsearch.v1beta;

import javax.annotation.Generated;
