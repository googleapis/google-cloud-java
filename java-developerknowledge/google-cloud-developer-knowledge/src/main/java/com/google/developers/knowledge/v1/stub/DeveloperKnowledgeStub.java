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

package com.google.developers.knowledge.v1.stub;

import static com.google.developers.knowledge.v1.DeveloperKnowledgeClient.SearchDocumentChunksPagedResponse;

import com.google.api.gax.core.BackgroundResource;
import com.google.api.gax.rpc.UnaryCallable;
import com.google.developers.knowledge.v1.BatchGetDocumentsRequest;
import com.google.developers.knowledge.v1.BatchGetDocumentsResponse;
import com.google.developers.knowledge.v1.Document;
import com.google.developers.knowledge.v1.GetDocumentRequest;
import com.google.developers.knowledge.v1.SearchDocumentChunksRequest;
import com.google.developers.knowledge.v1.SearchDocumentChunksResponse;
import javax.annotation.Generated;
import org.jspecify.annotations.NullMarked;

// AUTO-GENERATED DOCUMENTATION AND CLASS.
/**
 * Base stub class for the DeveloperKnowledge service API.
 *
 * <p>This class is for advanced usage and reflects the underlying API directly.
 */
@NullMarked
@Generated("by gapic-generator-java")
public abstract class DeveloperKnowledgeStub implements BackgroundResource {

  public UnaryCallable<SearchDocumentChunksRequest, SearchDocumentChunksPagedResponse>
      searchDocumentChunksPagedCallable() {
    throw new UnsupportedOperationException("Not implemented: searchDocumentChunksPagedCallable()");
  }

  public UnaryCallable<SearchDocumentChunksRequest, SearchDocumentChunksResponse>
      searchDocumentChunksCallable() {
    throw new UnsupportedOperationException("Not implemented: searchDocumentChunksCallable()");
  }

  public UnaryCallable<GetDocumentRequest, Document> getDocumentCallable() {
    throw new UnsupportedOperationException("Not implemented: getDocumentCallable()");
  }

  public UnaryCallable<BatchGetDocumentsRequest, BatchGetDocumentsResponse>
      batchGetDocumentsCallable() {
    throw new UnsupportedOperationException("Not implemented: batchGetDocumentsCallable()");
  }

  @Override
  public abstract void close();
}
