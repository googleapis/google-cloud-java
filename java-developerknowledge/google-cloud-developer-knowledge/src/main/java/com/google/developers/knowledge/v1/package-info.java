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
 * A client to Developer Knowledge API
 *
 * <p>The interfaces provided are listed below, along with usage samples.
 *
 * <p>======================= DeveloperKnowledgeClient =======================
 *
 * <p>Service Description: The Developer Knowledge API provides programmatic access to Google's
 * public developer documentation, enabling you to integrate this knowledge base into your own
 * applications and workflows.
 *
 * <p>The API is designed to be the canonical source for machine-readable access to Google's
 * developer documentation.
 *
 * <p>A typical use case is to first use
 * [DeveloperKnowledge.SearchDocumentChunks][google.developers.knowledge.v1.DeveloperKnowledge.SearchDocumentChunks]
 * to find relevant page URIs based on a query, and then use
 * [DeveloperKnowledge.GetDocument][google.developers.knowledge.v1.DeveloperKnowledge.GetDocument]
 * or
 * [DeveloperKnowledge.BatchGetDocuments][google.developers.knowledge.v1.DeveloperKnowledge.BatchGetDocuments]
 * to fetch the full content of the top results.
 *
 * <p>All document content is provided in Markdown format.
 *
 * <p>Sample for DeveloperKnowledgeClient:
 *
 * <pre>{@code
 * // This snippet has been automatically generated and should be regarded as a code template only.
 * // It will require modifications to work:
 * // - It may require correct/in-range values for request initialization.
 * // - It may require specifying regional endpoints when creating the service client as shown in
 * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
 * try (DeveloperKnowledgeClient developerKnowledgeClient = DeveloperKnowledgeClient.create()) {
 *   DocumentName name = DocumentName.of("[DOCUMENT]");
 *   Document response = developerKnowledgeClient.getDocument(name);
 * }
 * }</pre>
 */
@Generated("by gapic-generator-java")
package com.google.developers.knowledge.v1;

import javax.annotation.Generated;
