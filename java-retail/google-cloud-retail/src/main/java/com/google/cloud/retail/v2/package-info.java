/*
 * Copyright 2020 Google LLC
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
 * <p>======================= CatalogServiceClient =======================
 *
 * <p>Service Description: Service for managing catalog configuration.
 *
 * <p>Sample for CatalogServiceClient:
 *
 * <pre>{@code
 * try (CatalogServiceClient catalogServiceClient = CatalogServiceClient.create()) {
 *   Catalog catalog = Catalog.newBuilder().build();
 *   FieldMask updateMask = FieldMask.newBuilder().build();
 *   Catalog response = catalogServiceClient.updateCatalog(catalog, updateMask);
 * }
 * }</pre>
 *
 * <p>======================= PredictionServiceClient =======================
 *
 * <p>Service Description: Service for making recommendation prediction.
 *
 * <p>Sample for PredictionServiceClient:
 *
 * <pre>{@code
 * try (PredictionServiceClient predictionServiceClient = PredictionServiceClient.create()) {
 *   PredictRequest request =
 *       PredictRequest.newBuilder()
 *           .setPlacement("placement1792938725")
 *           .setUserEvent(UserEvent.newBuilder().build())
 *           .setPageSize(883849137)
 *           .setPageToken("pageToken873572522")
 *           .setFilter("filter-1274492040")
 *           .setValidateOnly(true)
 *           .putAllParams(new HashMap<String, Value>())
 *           .putAllLabels(new HashMap<String, String>())
 *           .build();
 *   PredictResponse response = predictionServiceClient.predict(request);
 * }
 * }</pre>
 *
 * <p>======================= ProductServiceClient =======================
 *
 * <p>Service Description: Service for ingesting [Product][google.cloud.retail.v2.Product]
 * information of the customer's website.
 *
 * <p>Sample for ProductServiceClient:
 *
 * <pre>{@code
 * try (ProductServiceClient productServiceClient = ProductServiceClient.create()) {
 *   BranchName parent = BranchName.of("[PROJECT]", "[LOCATION]", "[CATALOG]", "[BRANCH]");
 *   Product product = Product.newBuilder().build();
 *   String productId = "productId-1051830678";
 *   Product response = productServiceClient.createProduct(parent, product, productId);
 * }
 * }</pre>
 *
 * <p>======================= UserEventServiceClient =======================
 *
 * <p>Service Description: Service for ingesting end user actions on the customer website.
 *
 * <p>Sample for UserEventServiceClient:
 *
 * <pre>{@code
 * try (UserEventServiceClient userEventServiceClient = UserEventServiceClient.create()) {
 *   WriteUserEventRequest request =
 *       WriteUserEventRequest.newBuilder()
 *           .setParent("parent-995424086")
 *           .setUserEvent(UserEvent.newBuilder().build())
 *           .build();
 *   UserEvent response = userEventServiceClient.writeUserEvent(request);
 * }
 * }</pre>
 */
@Generated("by gapic-generator-java")
package com.google.cloud.retail.v2;

import javax.annotation.Generated;
