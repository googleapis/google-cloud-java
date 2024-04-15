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
 * A client to Discovery Engine API
 *
 * <p>The interfaces provided are listed below, along with usage samples.
 *
 * <p>======================= AclConfigServiceClient =======================
 *
 * <p>Service Description: Service for managing Acl Configuration.
 *
 * <p>Sample for AclConfigServiceClient:
 *
 * <pre>{@code
 * // This snippet has been automatically generated and should be regarded as a code template only.
 * // It will require modifications to work:
 * // - It may require correct/in-range values for request initialization.
 * // - It may require specifying regional endpoints when creating the service client as shown in
 * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
 * try (AclConfigServiceClient aclConfigServiceClient = AclConfigServiceClient.create()) {
 *   UpdateAclConfigRequest request =
 *       UpdateAclConfigRequest.newBuilder().setAclConfig(AclConfig.newBuilder().build()).build();
 *   AclConfig response = aclConfigServiceClient.updateAclConfig(request);
 * }
 * }</pre>
 *
 * <p>======================= ChunkServiceClient =======================
 *
 * <p>Service Description: Service for displaying processed
 * [Chunk][google.cloud.discoveryengine.v1alpha.Chunk] information of the customer's unstructured
 * data.
 *
 * <p>Sample for ChunkServiceClient:
 *
 * <pre>{@code
 * // This snippet has been automatically generated and should be regarded as a code template only.
 * // It will require modifications to work:
 * // - It may require correct/in-range values for request initialization.
 * // - It may require specifying regional endpoints when creating the service client as shown in
 * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
 * try (ChunkServiceClient chunkServiceClient = ChunkServiceClient.create()) {
 *   ChunkName name =
 *       ChunkName.ofProjectLocationDataStoreBranchDocumentChunkName(
 *           "[PROJECT]", "[LOCATION]", "[DATA_STORE]", "[BRANCH]", "[DOCUMENT]", "[CHUNK]");
 *   Chunk response = chunkServiceClient.getChunk(name);
 * }
 * }</pre>
 *
 * <p>======================= CompletionServiceClient =======================
 *
 * <p>Service Description: Service for Auto-Completion.
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
 *           .setDataStore(
 *               DataStoreName.ofProjectLocationDataStoreName(
 *                       "[PROJECT]", "[LOCATION]", "[DATA_STORE]")
 *                   .toString())
 *           .setQuery("query107944136")
 *           .setQueryModel("queryModel-184930495")
 *           .setUserPseudoId("userPseudoId-1155274652")
 *           .setIncludeTailSuggestions(true)
 *           .build();
 *   CompleteQueryResponse response = completionServiceClient.completeQuery(request);
 * }
 * }</pre>
 *
 * <p>======================= ConversationalSearchServiceClient =======================
 *
 * <p>Service Description: Service for conversational search.
 *
 * <p>Sample for ConversationalSearchServiceClient:
 *
 * <pre>{@code
 * // This snippet has been automatically generated and should be regarded as a code template only.
 * // It will require modifications to work:
 * // - It may require correct/in-range values for request initialization.
 * // - It may require specifying regional endpoints when creating the service client as shown in
 * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
 * try (ConversationalSearchServiceClient conversationalSearchServiceClient =
 *     ConversationalSearchServiceClient.create()) {
 *   ConversationName name =
 *       ConversationName.ofProjectLocationDataStoreConversationName(
 *           "[PROJECT]", "[LOCATION]", "[DATA_STORE]", "[CONVERSATION]");
 *   TextInput query = TextInput.newBuilder().build();
 *   ConverseConversationResponse response =
 *       conversationalSearchServiceClient.converseConversation(name, query);
 * }
 * }</pre>
 *
 * <p>======================= DataStoreServiceClient =======================
 *
 * <p>Service Description: Service for managing
 * [DataStore][google.cloud.discoveryengine.v1alpha.DataStore] configuration.
 *
 * <p>Sample for DataStoreServiceClient:
 *
 * <pre>{@code
 * // This snippet has been automatically generated and should be regarded as a code template only.
 * // It will require modifications to work:
 * // - It may require correct/in-range values for request initialization.
 * // - It may require specifying regional endpoints when creating the service client as shown in
 * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
 * try (DataStoreServiceClient dataStoreServiceClient = DataStoreServiceClient.create()) {
 *   DataStoreName name =
 *       DataStoreName.ofProjectLocationDataStoreName("[PROJECT]", "[LOCATION]", "[DATA_STORE]");
 *   DataStore response = dataStoreServiceClient.getDataStore(name);
 * }
 * }</pre>
 *
 * <p>======================= DocumentServiceClient =======================
 *
 * <p>Service Description: Service for ingesting
 * [Document][google.cloud.discoveryengine.v1alpha.Document] information of the customer's website.
 *
 * <p>Sample for DocumentServiceClient:
 *
 * <pre>{@code
 * // This snippet has been automatically generated and should be regarded as a code template only.
 * // It will require modifications to work:
 * // - It may require correct/in-range values for request initialization.
 * // - It may require specifying regional endpoints when creating the service client as shown in
 * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
 * try (DocumentServiceClient documentServiceClient = DocumentServiceClient.create()) {
 *   DocumentName name =
 *       DocumentName.ofProjectLocationDataStoreBranchDocumentName(
 *           "[PROJECT]", "[LOCATION]", "[DATA_STORE]", "[BRANCH]", "[DOCUMENT]");
 *   Document response = documentServiceClient.getDocument(name);
 * }
 * }</pre>
 *
 * <p>======================= EngineServiceClient =======================
 *
 * <p>Service Description: Service for managing
 * [Engine][google.cloud.discoveryengine.v1alpha.Engine] configuration.
 *
 * <p>Sample for EngineServiceClient:
 *
 * <pre>{@code
 * // This snippet has been automatically generated and should be regarded as a code template only.
 * // It will require modifications to work:
 * // - It may require correct/in-range values for request initialization.
 * // - It may require specifying regional endpoints when creating the service client as shown in
 * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
 * try (EngineServiceClient engineServiceClient = EngineServiceClient.create()) {
 *   Engine engine = Engine.newBuilder().build();
 *   FieldMask updateMask = FieldMask.newBuilder().build();
 *   Engine response = engineServiceClient.updateEngine(engine, updateMask);
 * }
 * }</pre>
 *
 * <p>======================= EstimateBillingServiceClient =======================
 *
 * <p>Service Description: Service for managing billing estimations resources.
 *
 * <p>Sample for EstimateBillingServiceClient:
 *
 * <pre>{@code
 * // This snippet has been automatically generated and should be regarded as a code template only.
 * // It will require modifications to work:
 * // - It may require correct/in-range values for request initialization.
 * // - It may require specifying regional endpoints when creating the service client as shown in
 * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
 * try (EstimateBillingServiceClient estimateBillingServiceClient =
 *     EstimateBillingServiceClient.create()) {
 *   EstimateDataSizeRequest request =
 *       EstimateDataSizeRequest.newBuilder()
 *           .setLocation(LocationName.of("[PROJECT]", "[LOCATION]").toString())
 *           .build();
 *   EstimateDataSizeResponse response =
 *       estimateBillingServiceClient.estimateDataSizeAsync(request).get();
 * }
 * }</pre>
 *
 * <p>======================= GroundedGenerationServiceClient =======================
 *
 * <p>Service Description: Service for grounded generation.
 *
 * <p>Sample for GroundedGenerationServiceClient:
 *
 * <pre>{@code
 * // This snippet has been automatically generated and should be regarded as a code template only.
 * // It will require modifications to work:
 * // - It may require correct/in-range values for request initialization.
 * // - It may require specifying regional endpoints when creating the service client as shown in
 * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
 * try (GroundedGenerationServiceClient groundedGenerationServiceClient =
 *     GroundedGenerationServiceClient.create()) {
 *   CheckGroundingRequest request =
 *       CheckGroundingRequest.newBuilder()
 *           .setGroundingConfig(
 *               GroundingConfigName.of("[PROJECT]", "[LOCATION]", "[GROUNDING_CONFIG]")
 *                   .toString())
 *           .setAnswerCandidate("answerCandidate-292402331")
 *           .addAllFacts(new ArrayList<GroundingFact>())
 *           .setGroundingSpec(CheckGroundingSpec.newBuilder().build())
 *           .build();
 *   CheckGroundingResponse response = groundedGenerationServiceClient.checkGrounding(request);
 * }
 * }</pre>
 *
 * <p>======================= ProjectServiceClient =======================
 *
 * <p>Service Description: Service for operations on the
 * [Project][google.cloud.discoveryengine.v1alpha.Project].
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
 *   ProjectName name = ProjectName.of("[PROJECT]");
 *   Project response = projectServiceClient.getProject(name);
 * }
 * }</pre>
 *
 * <p>======================= RankServiceClient =======================
 *
 * <p>Service Description: Service for ranking text records.
 *
 * <p>Sample for RankServiceClient:
 *
 * <pre>{@code
 * // This snippet has been automatically generated and should be regarded as a code template only.
 * // It will require modifications to work:
 * // - It may require correct/in-range values for request initialization.
 * // - It may require specifying regional endpoints when creating the service client as shown in
 * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
 * try (RankServiceClient rankServiceClient = RankServiceClient.create()) {
 *   RankRequest request =
 *       RankRequest.newBuilder()
 *           .setRankingConfig(
 *               RankingConfigName.of("[PROJECT]", "[LOCATION]", "[RANKING_CONFIG]").toString())
 *           .setModel("model104069929")
 *           .setTopN(110545924)
 *           .setQuery("query107944136")
 *           .addAllRecords(new ArrayList<RankingRecord>())
 *           .setIgnoreRecordDetailsInResponse(true)
 *           .build();
 *   RankResponse response = rankServiceClient.rank(request);
 * }
 * }</pre>
 *
 * <p>======================= RecommendationServiceClient =======================
 *
 * <p>Service Description: Service for making recommendations.
 *
 * <p>Sample for RecommendationServiceClient:
 *
 * <pre>{@code
 * // This snippet has been automatically generated and should be regarded as a code template only.
 * // It will require modifications to work:
 * // - It may require correct/in-range values for request initialization.
 * // - It may require specifying regional endpoints when creating the service client as shown in
 * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
 * try (RecommendationServiceClient recommendationServiceClient =
 *     RecommendationServiceClient.create()) {
 *   RecommendRequest request =
 *       RecommendRequest.newBuilder()
 *           .setServingConfig(
 *               ServingConfigName.ofProjectLocationDataStoreServingConfigName(
 *                       "[PROJECT]", "[LOCATION]", "[DATA_STORE]", "[SERVING_CONFIG]")
 *                   .toString())
 *           .setUserEvent(UserEvent.newBuilder().build())
 *           .setPageSize(883849137)
 *           .setFilter("filter-1274492040")
 *           .setValidateOnly(true)
 *           .putAllParams(new HashMap<String, Value>())
 *           .putAllUserLabels(new HashMap<String, String>())
 *           .build();
 *   RecommendResponse response = recommendationServiceClient.recommend(request);
 * }
 * }</pre>
 *
 * <p>======================= SchemaServiceClient =======================
 *
 * <p>Service Description: Service for managing
 * [Schema][google.cloud.discoveryengine.v1alpha.Schema]s.
 *
 * <p>Sample for SchemaServiceClient:
 *
 * <pre>{@code
 * // This snippet has been automatically generated and should be regarded as a code template only.
 * // It will require modifications to work:
 * // - It may require correct/in-range values for request initialization.
 * // - It may require specifying regional endpoints when creating the service client as shown in
 * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
 * try (SchemaServiceClient schemaServiceClient = SchemaServiceClient.create()) {
 *   SchemaName name =
 *       SchemaName.ofProjectLocationDataStoreSchemaName(
 *           "[PROJECT]", "[LOCATION]", "[DATA_STORE]", "[SCHEMA]");
 *   Schema response = schemaServiceClient.getSchema(name);
 * }
 * }</pre>
 *
 * <p>======================= SearchServiceClient =======================
 *
 * <p>Service Description: Service for search.
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
 *           .setServingConfig(
 *               ServingConfigName.ofProjectLocationDataStoreServingConfigName(
 *                       "[PROJECT]", "[LOCATION]", "[DATA_STORE]", "[SERVING_CONFIG]")
 *                   .toString())
 *           .setBranch(
 *               BranchName.ofProjectLocationDataStoreBranchName(
 *                       "[PROJECT]", "[LOCATION]", "[DATA_STORE]", "[BRANCH]")
 *                   .toString())
 *           .setQuery("query107944136")
 *           .setImageQuery(SearchRequest.ImageQuery.newBuilder().build())
 *           .setPageSize(883849137)
 *           .setPageToken("pageToken873572522")
 *           .setOffset(-1019779949)
 *           .addAllDataStoreSpecs(new ArrayList<SearchRequest.DataStoreSpec>())
 *           .setFilter("filter-1274492040")
 *           .setCanonicalFilter("canonicalFilter-722283124")
 *           .setOrderBy("orderBy-1207110587")
 *           .setUserInfo(UserInfo.newBuilder().build())
 *           .addAllFacetSpecs(new ArrayList<SearchRequest.FacetSpec>())
 *           .setBoostSpec(SearchRequest.BoostSpec.newBuilder().build())
 *           .putAllParams(new HashMap<String, Value>())
 *           .setQueryExpansionSpec(SearchRequest.QueryExpansionSpec.newBuilder().build())
 *           .setSpellCorrectionSpec(SearchRequest.SpellCorrectionSpec.newBuilder().build())
 *           .setUserPseudoId("userPseudoId-1155274652")
 *           .setContentSearchSpec(SearchRequest.ContentSearchSpec.newBuilder().build())
 *           .setEmbeddingSpec(SearchRequest.EmbeddingSpec.newBuilder().build())
 *           .setRankingExpression("rankingExpression2110320494")
 *           .setSafeSearch(true)
 *           .putAllUserLabels(new HashMap<String, String>())
 *           .setCustomFineTuningSpec(CustomFineTuningSpec.newBuilder().build())
 *           .build();
 *   for (SearchResponse.SearchResult element : searchServiceClient.search(request).iterateAll()) {
 *     // doThingsWith(element);
 *   }
 * }
 * }</pre>
 *
 * <p>======================= SearchTuningServiceClient =======================
 *
 * <p>Service Description: Service for search tuning.
 *
 * <p>Sample for SearchTuningServiceClient:
 *
 * <pre>{@code
 * // This snippet has been automatically generated and should be regarded as a code template only.
 * // It will require modifications to work:
 * // - It may require correct/in-range values for request initialization.
 * // - It may require specifying regional endpoints when creating the service client as shown in
 * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
 * try (SearchTuningServiceClient searchTuningServiceClient = SearchTuningServiceClient.create()) {
 *   TrainCustomModelRequest request =
 *       TrainCustomModelRequest.newBuilder()
 *           .setDataStore(
 *               DataStoreName.ofProjectLocationCollectionDataStoreName(
 *                       "[PROJECT]", "[LOCATION]", "[COLLECTION]", "[DATA_STORE]")
 *                   .toString())
 *           .setModelType("modelType-2010627581")
 *           .setErrorConfig(ImportErrorConfig.newBuilder().build())
 *           .build();
 *   TrainCustomModelResponse response =
 *       searchTuningServiceClient.trainCustomModelAsync(request).get();
 * }
 * }</pre>
 *
 * <p>======================= ServingConfigServiceClient =======================
 *
 * <p>Service Description: Service for operations related to
 * [ServingConfig][google.cloud.discoveryengine.v1alpha.ServingConfig].
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
 *   ServingConfig servingConfig = ServingConfig.newBuilder().build();
 *   FieldMask updateMask = FieldMask.newBuilder().build();
 *   ServingConfig response =
 *       servingConfigServiceClient.updateServingConfig(servingConfig, updateMask);
 * }
 * }</pre>
 *
 * <p>======================= SiteSearchEngineServiceClient =======================
 *
 * <p>Service Description: Service for managing site search related resources.
 *
 * <p>Sample for SiteSearchEngineServiceClient:
 *
 * <pre>{@code
 * // This snippet has been automatically generated and should be regarded as a code template only.
 * // It will require modifications to work:
 * // - It may require correct/in-range values for request initialization.
 * // - It may require specifying regional endpoints when creating the service client as shown in
 * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
 * try (SiteSearchEngineServiceClient siteSearchEngineServiceClient =
 *     SiteSearchEngineServiceClient.create()) {
 *   SiteSearchEngineName name =
 *       SiteSearchEngineName.ofProjectLocationDataStoreName(
 *           "[PROJECT]", "[LOCATION]", "[DATA_STORE]");
 *   SiteSearchEngine response = siteSearchEngineServiceClient.getSiteSearchEngine(name);
 * }
 * }</pre>
 *
 * <p>======================= UserEventServiceClient =======================
 *
 * <p>Service Description: Service for ingesting end user actions on a website to Discovery Engine
 * API.
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
 *           .setParent(
 *               DataStoreName.ofProjectLocationDataStoreName(
 *                       "[PROJECT]", "[LOCATION]", "[DATA_STORE]")
 *                   .toString())
 *           .setUserEvent(UserEvent.newBuilder().build())
 *           .build();
 *   UserEvent response = userEventServiceClient.writeUserEvent(request);
 * }
 * }</pre>
 */
@Generated("by gapic-generator-java")
package com.google.cloud.discoveryengine.v1alpha;

import javax.annotation.Generated;
