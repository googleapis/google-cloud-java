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
 * A client to Vertex AI Search for Retail API
 *
 * <p>The interfaces provided are listed below, along with usage samples.
 *
 * <p>======================= AnalyticsServiceClient =======================
 *
 * <p>Service Description: Service for managing &amp; accessing retail search business metric.
 * Retail recommendation business metric is currently not available.
 *
 * <p>Sample for AnalyticsServiceClient:
 *
 * <pre>{@code
 * // This snippet has been automatically generated and should be regarded as a code template only.
 * // It will require modifications to work:
 * // - It may require correct/in-range values for request initialization.
 * // - It may require specifying regional endpoints when creating the service client as shown in
 * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
 * try (AnalyticsServiceClient analyticsServiceClient = AnalyticsServiceClient.create()) {
 *   ExportAnalyticsMetricsRequest request =
 *       ExportAnalyticsMetricsRequest.newBuilder()
 *           .setCatalog("catalog555704345")
 *           .setOutputConfig(OutputConfig.newBuilder().build())
 *           .setFilter("filter-1274492040")
 *           .build();
 *   ExportAnalyticsMetricsResponse response =
 *       analyticsServiceClient.exportAnalyticsMetricsAsync(request).get();
 * }
 * }</pre>
 *
 * <p>======================= BranchServiceClient =======================
 *
 * <p>Service Description: Service for [Branch][google.cloud.retail.v2alpha.Branch] Management
 *
 * <p>[Branch][google.cloud.retail.v2alpha.Branch]es are automatically created when a
 * [Catalog][google.cloud.retail.v2alpha.Catalog] is created. There are fixed three branches in each
 * catalog, and may use [ListBranches][google.cloud.retail.v2alpha.BranchService.ListBranches]
 * method to get the details of all branches.
 *
 * <p>Sample for BranchServiceClient:
 *
 * <pre>{@code
 * // This snippet has been automatically generated and should be regarded as a code template only.
 * // It will require modifications to work:
 * // - It may require correct/in-range values for request initialization.
 * // - It may require specifying regional endpoints when creating the service client as shown in
 * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
 * try (BranchServiceClient branchServiceClient = BranchServiceClient.create()) {
 *   CatalogName parent = CatalogName.of("[PROJECT]", "[LOCATION]", "[CATALOG]");
 *   ListBranchesResponse response = branchServiceClient.listBranches(parent);
 * }
 * }</pre>
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
 * <p>Service Description: Autocomplete service for retail.
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
 *           .setEnableAttributeSuggestions(true)
 *           .setEntity("entity-1298275357")
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
 * <p>======================= GenerativeQuestionServiceClient =======================
 *
 * <p>Service Description: Service for managing LLM generated questions in search serving.
 *
 * <p>Sample for GenerativeQuestionServiceClient:
 *
 * <pre>{@code
 * // This snippet has been automatically generated and should be regarded as a code template only.
 * // It will require modifications to work:
 * // - It may require correct/in-range values for request initialization.
 * // - It may require specifying regional endpoints when creating the service client as shown in
 * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
 * try (GenerativeQuestionServiceClient generativeQuestionServiceClient =
 *     GenerativeQuestionServiceClient.create()) {
 *   GenerativeQuestionsFeatureConfig generativeQuestionsFeatureConfig =
 *       GenerativeQuestionsFeatureConfig.newBuilder().build();
 *   FieldMask updateMask = FieldMask.newBuilder().build();
 *   GenerativeQuestionsFeatureConfig response =
 *       generativeQuestionServiceClient.updateGenerativeQuestionsFeatureConfig(
 *           generativeQuestionsFeatureConfig, updateMask);
 * }
 * }</pre>
 *
 * <p>======================= MerchantCenterAccountLinkServiceClient =======================
 *
 * <p>Service Description: Merchant Center Link service to link a Branch to a Merchant Center
 * Account.
 *
 * <p>Sample for MerchantCenterAccountLinkServiceClient:
 *
 * <pre>{@code
 * // This snippet has been automatically generated and should be regarded as a code template only.
 * // It will require modifications to work:
 * // - It may require correct/in-range values for request initialization.
 * // - It may require specifying regional endpoints when creating the service client as shown in
 * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
 * try (MerchantCenterAccountLinkServiceClient merchantCenterAccountLinkServiceClient =
 *     MerchantCenterAccountLinkServiceClient.create()) {
 *   CatalogName parent = CatalogName.of("[PROJECT]", "[LOCATION]", "[CATALOG]");
 *   ListMerchantCenterAccountLinksResponse response =
 *       merchantCenterAccountLinkServiceClient.listMerchantCenterAccountLinks(parent);
 * }
 * }</pre>
 *
 * <p>======================= ModelServiceClient =======================
 *
 * <p>Service Description: Service for performing CRUD operations on models. Recommendation models
 * contain all the metadata necessary to generate a set of models for the `Predict()` API. A model
 * is queried indirectly via a ServingConfig, which associates a model with a given Placement (e.g.
 * Frequently Bought Together on Home Page).
 *
 * <p>This service allows you to do the following:
 *
 * <ul>
 *   <li>Initiate training of a model.
 *   <li>Pause training of an existing model.
 *   <li>List all the available models along with their metadata.
 *   <li>Control their tuning schedule.
 * </ul>
 *
 * <p>Sample for ModelServiceClient:
 *
 * <pre>{@code
 * // This snippet has been automatically generated and should be regarded as a code template only.
 * // It will require modifications to work:
 * // - It may require correct/in-range values for request initialization.
 * // - It may require specifying regional endpoints when creating the service client as shown in
 * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
 * try (ModelServiceClient modelServiceClient = ModelServiceClient.create()) {
 *   ModelName name = ModelName.of("[PROJECT]", "[LOCATION]", "[CATALOG]", "[MODEL]");
 *   Model response = modelServiceClient.getModel(name);
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
 * <p>Service Description: Service for ingesting [Product][google.cloud.retail.v2alpha.Product]
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
 * <p>======================= ProjectServiceClient =======================
 *
 * <p>Service Description: Service for settings at Project level.
 *
 * <p>Sample for ProjectServiceClient:
 *
 * <pre>{@code
 * // This snippet has been automatically generated and should be regarded as a code template only.
 * // It will require modifications to work:
 * // - It may require correct/in-range values for request initialization.
 * // - It may require specifying regional endpoints when creating the service client as shown in
 * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
 * try (ProjectServiceClient projectServiceClient = ProjectServiceClient.create()) {
 *   RetailProjectName name = RetailProjectName.of("[PROJECT]");
 *   Project response = projectServiceClient.getProject(name);
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
 *           .setEntity("entity-1298275357")
 *           .setConversationalSearchSpec(
 *               SearchRequest.ConversationalSearchSpec.newBuilder().build())
 *           .setTileNavigationSpec(SearchRequest.TileNavigationSpec.newBuilder().build())
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
package com.google.cloud.retail.v2alpha;

import javax.annotation.Generated;
