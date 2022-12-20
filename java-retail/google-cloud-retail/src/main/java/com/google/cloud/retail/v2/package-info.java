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
 * A client to Retail API
 *
 * <p>The interfaces provided are listed below, along with usage samples.
 *
 * <p>======================= CatalogServiceClient =======================
 *
 * <p>Service Description: Service for managing catalog configuration.
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
 *   Catalog catalog = Catalog.newBuilder().build();
 *   FieldMask updateMask = FieldMask.newBuilder().build();
 *   Catalog response = catalogServiceClient.updateCatalog(catalog, updateMask);
 * }
 * }</pre>
 *
 * <p>======================= CompletionServiceClient =======================
 *
 * <p>Service Description: Auto-completion service for retail.
 *
 * <p>This feature is only available for users who have Retail Search enabled. Enable Retail Search
 * on Cloud Console before using this feature.
 *
 * <p>Sample for CompletionServiceClient:
 *
 * <pre>{@code
 * // This snippet has been automatically generated and should be regarded as a code template only.
 * // It will require modifications to work:
 * // - It may require correct/in-range values for request initialization.
 * // - It may require specifying regional endpoints when creating the service client as shown in
 * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
 * try (CompletionServiceClient completionServiceClient = CompletionServiceClient.create()) {
 *   CompleteQueryRequest request =
 *       CompleteQueryRequest.newBuilder()
 *           .setCatalog(CatalogName.of("[PROJECT]", "[LOCATION]", "[CATALOG]").toString())
 *           .setQuery("query107944136")
 *           .setVisitorId("visitorId1880545833")
 *           .addAllLanguageCodes(new ArrayList<String>())
 *           .setDeviceType("deviceType781190832")
 *           .setDataset("dataset1443214456")
 *           .setMaxSuggestions(618824852)
 *           .build();
 *   CompleteQueryResponse response = completionServiceClient.completeQuery(request);
 * }
 * }</pre>
 *
 * <p>======================= ControlServiceClient =======================
 *
 * <p>Service Description: Service for modifying Control.
 *
 * <p>Sample for ControlServiceClient:
 *
 * <pre>{@code
 * // This snippet has been automatically generated and should be regarded as a code template only.
 * // It will require modifications to work:
 * // - It may require correct/in-range values for request initialization.
 * // - It may require specifying regional endpoints when creating the service client as shown in
 * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
 * try (ControlServiceClient controlServiceClient = ControlServiceClient.create()) {
 *   CatalogName parent = CatalogName.of("[PROJECT]", "[LOCATION]", "[CATALOG]");
 *   Control control = Control.newBuilder().build();
 *   String controlId = "controlId-395080872";
 *   Control response = controlServiceClient.createControl(parent, control, controlId);
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
 * // This snippet has been automatically generated and should be regarded as a code template only.
 * // It will require modifications to work:
 * // - It may require correct/in-range values for request initialization.
 * // - It may require specifying regional endpoints when creating the service client as shown in
 * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
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
 * // This snippet has been automatically generated and should be regarded as a code template only.
 * // It will require modifications to work:
 * // - It may require correct/in-range values for request initialization.
 * // - It may require specifying regional endpoints when creating the service client as shown in
 * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
 * try (ProductServiceClient productServiceClient = ProductServiceClient.create()) {
 *   BranchName parent = BranchName.of("[PROJECT]", "[LOCATION]", "[CATALOG]", "[BRANCH]");
 *   Product product = Product.newBuilder().build();
 *   String productId = "productId-1051830678";
 *   Product response = productServiceClient.createProduct(parent, product, productId);
 * }
 * }</pre>
 *
 * <p>======================= SearchServiceClient =======================
 *
 * <p>Service Description: Service for search.
 *
 * <p>This feature is only available for users who have Retail Search enabled. Enable Retail Search
 * on Cloud Console before using this feature.
 *
 * <p>Sample for SearchServiceClient:
 *
 * <pre>{@code
 * // This snippet has been automatically generated and should be regarded as a code template only.
 * // It will require modifications to work:
 * // - It may require correct/in-range values for request initialization.
 * // - It may require specifying regional endpoints when creating the service client as shown in
 * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
 * try (SearchServiceClient searchServiceClient = SearchServiceClient.create()) {
 *   SearchRequest request =
 *       SearchRequest.newBuilder()
 *           .setPlacement("placement1792938725")
 *           .setBranch(
 *               BranchName.of("[PROJECT]", "[LOCATION]", "[CATALOG]", "[BRANCH]").toString())
 *           .setQuery("query107944136")
 *           .setVisitorId("visitorId1880545833")
 *           .setUserInfo(UserInfo.newBuilder().build())
 *           .setPageSize(883849137)
 *           .setPageToken("pageToken873572522")
 *           .setOffset(-1019779949)
 *           .setFilter("filter-1274492040")
 *           .setCanonicalFilter("canonicalFilter-722283124")
 *           .setOrderBy("orderBy-1207110587")
 *           .addAllFacetSpecs(new ArrayList<SearchRequest.FacetSpec>())
 *           .setDynamicFacetSpec(SearchRequest.DynamicFacetSpec.newBuilder().build())
 *           .setBoostSpec(SearchRequest.BoostSpec.newBuilder().build())
 *           .setQueryExpansionSpec(SearchRequest.QueryExpansionSpec.newBuilder().build())
 *           .addAllVariantRollupKeys(new ArrayList<String>())
 *           .addAllPageCategories(new ArrayList<String>())
 *           .setPersonalizationSpec(SearchRequest.PersonalizationSpec.newBuilder().build())
 *           .putAllLabels(new HashMap<String, String>())
 *           .setSpellCorrectionSpec(SearchRequest.SpellCorrectionSpec.newBuilder().build())
 *           .build();
 *   for (SearchResponse.SearchResult element : searchServiceClient.search(request).iterateAll()) {
 *     // doThingsWith(element);
 *   }
 * }
 * }</pre>
 *
 * <p>======================= ServingConfigServiceClient =======================
 *
 * <p>Service Description: Service for modifying ServingConfig.
 *
 * <p>Sample for ServingConfigServiceClient:
 *
 * <pre>{@code
 * // This snippet has been automatically generated and should be regarded as a code template only.
 * // It will require modifications to work:
 * // - It may require correct/in-range values for request initialization.
 * // - It may require specifying regional endpoints when creating the service client as shown in
 * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
 * try (ServingConfigServiceClient servingConfigServiceClient =
 *     ServingConfigServiceClient.create()) {
 *   CatalogName parent = CatalogName.of("[PROJECT]", "[LOCATION]", "[CATALOG]");
 *   ServingConfig servingConfig = ServingConfig.newBuilder().build();
 *   String servingConfigId = "servingConfigId-831052759";
 *   ServingConfig response =
 *       servingConfigServiceClient.createServingConfig(parent, servingConfig, servingConfigId);
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
 * // This snippet has been automatically generated and should be regarded as a code template only.
 * // It will require modifications to work:
 * // - It may require correct/in-range values for request initialization.
 * // - It may require specifying regional endpoints when creating the service client as shown in
 * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
 * try (UserEventServiceClient userEventServiceClient = UserEventServiceClient.create()) {
 *   WriteUserEventRequest request =
 *       WriteUserEventRequest.newBuilder()
 *           .setParent("parent-995424086")
 *           .setUserEvent(UserEvent.newBuilder().build())
 *           .setWriteAsync(true)
 *           .build();
 *   UserEvent response = userEventServiceClient.writeUserEvent(request);
 * }
 * }</pre>
 */
@Generated("by gapic-generator-java")
package com.google.cloud.retail.v2;

import javax.annotation.Generated;
