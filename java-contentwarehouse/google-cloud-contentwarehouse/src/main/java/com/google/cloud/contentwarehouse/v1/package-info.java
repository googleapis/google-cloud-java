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
 * A client to contentwarehouse API
 *
 * <p>The interfaces provided are listed below, along with usage samples.
 *
 * <p>======================= DocumentLinkServiceClient =======================
 *
 * <p>Service Description: This service lets you manage document-links. Document-Links are treated
 * as sub-resources under source documents.
 *
 * <p>Sample for DocumentLinkServiceClient:
 *
 * <pre>{@code
 * // This snippet has been automatically generated and should be regarded as a code template only.
 * // It will require modifications to work:
 * // - It may require correct/in-range values for request initialization.
 * // - It may require specifying regional endpoints when creating the service client as shown in
 * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
 * try (DocumentLinkServiceClient documentLinkServiceClient = DocumentLinkServiceClient.create()) {
 *   DocumentName parent =
 *       DocumentName.ofProjectLocationDocumentName("[PROJECT]", "[LOCATION]", "[DOCUMENT]");
 *   ListLinkedTargetsResponse response = documentLinkServiceClient.listLinkedTargets(parent);
 * }
 * }</pre>
 *
 * <p>======================= DocumentSchemaServiceClient =======================
 *
 * <p>Service Description: This service lets you manage document schema.
 *
 * <p>Sample for DocumentSchemaServiceClient:
 *
 * <pre>{@code
 * // This snippet has been automatically generated and should be regarded as a code template only.
 * // It will require modifications to work:
 * // - It may require correct/in-range values for request initialization.
 * // - It may require specifying regional endpoints when creating the service client as shown in
 * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
 * try (DocumentSchemaServiceClient documentSchemaServiceClient =
 *     DocumentSchemaServiceClient.create()) {
 *   LocationName parent = LocationName.of("[PROJECT]", "[LOCATION]");
 *   DocumentSchema documentSchema = DocumentSchema.newBuilder().build();
 *   DocumentSchema response =
 *       documentSchemaServiceClient.createDocumentSchema(parent, documentSchema);
 * }
 * }</pre>
 *
 * <p>======================= DocumentServiceClient =======================
 *
 * <p>Service Description: This service lets you manage document.
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
 *   LocationName parent = LocationName.of("[PROJECT]", "[LOCATION]");
 *   Document document = Document.newBuilder().build();
 *   CreateDocumentResponse response = documentServiceClient.createDocument(parent, document);
 * }
 * }</pre>
 *
 * <p>======================= RuleSetServiceClient =======================
 *
 * <p>Service Description: Service to manage customer specific RuleSets.
 *
 * <p>Sample for RuleSetServiceClient:
 *
 * <pre>{@code
 * // This snippet has been automatically generated and should be regarded as a code template only.
 * // It will require modifications to work:
 * // - It may require correct/in-range values for request initialization.
 * // - It may require specifying regional endpoints when creating the service client as shown in
 * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
 * try (RuleSetServiceClient ruleSetServiceClient = RuleSetServiceClient.create()) {
 *   LocationName parent = LocationName.of("[PROJECT]", "[LOCATION]");
 *   RuleSet ruleSet = RuleSet.newBuilder().build();
 *   RuleSet response = ruleSetServiceClient.createRuleSet(parent, ruleSet);
 * }
 * }</pre>
 *
 * <p>======================= SynonymSetServiceClient =======================
 *
 * <p>Service Description: A Service that manage/custom customer specified SynonymSets.
 *
 * <p>Sample for SynonymSetServiceClient:
 *
 * <pre>{@code
 * // This snippet has been automatically generated and should be regarded as a code template only.
 * // It will require modifications to work:
 * // - It may require correct/in-range values for request initialization.
 * // - It may require specifying regional endpoints when creating the service client as shown in
 * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
 * try (SynonymSetServiceClient synonymSetServiceClient = SynonymSetServiceClient.create()) {
 *   LocationName parent = LocationName.of("[PROJECT]", "[LOCATION]");
 *   SynonymSet synonymSet = SynonymSet.newBuilder().build();
 *   SynonymSet response = synonymSetServiceClient.createSynonymSet(parent, synonymSet);
 * }
 * }</pre>
 */
@Generated("by gapic-generator-java")
package com.google.cloud.contentwarehouse.v1;

import javax.annotation.Generated;
