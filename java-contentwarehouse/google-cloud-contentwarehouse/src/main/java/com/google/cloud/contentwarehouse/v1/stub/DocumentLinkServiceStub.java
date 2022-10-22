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

package com.google.cloud.contentwarehouse.v1.stub;

import static com.google.cloud.contentwarehouse.v1.DocumentLinkServiceClient.ListLinkedSourcesPagedResponse;

import com.google.api.gax.core.BackgroundResource;
import com.google.api.gax.rpc.UnaryCallable;
import com.google.cloud.contentwarehouse.v1.CreateDocumentLinkRequest;
import com.google.cloud.contentwarehouse.v1.DeleteDocumentLinkRequest;
import com.google.cloud.contentwarehouse.v1.DocumentLink;
import com.google.cloud.contentwarehouse.v1.ListLinkedSourcesRequest;
import com.google.cloud.contentwarehouse.v1.ListLinkedSourcesResponse;
import com.google.cloud.contentwarehouse.v1.ListLinkedTargetsRequest;
import com.google.cloud.contentwarehouse.v1.ListLinkedTargetsResponse;
import com.google.protobuf.Empty;
import javax.annotation.Generated;

// AUTO-GENERATED DOCUMENTATION AND CLASS.
/**
 * Base stub class for the DocumentLinkService service API.
 *
 * <p>This class is for advanced usage and reflects the underlying API directly.
 */
@Generated("by gapic-generator-java")
public abstract class DocumentLinkServiceStub implements BackgroundResource {

  public UnaryCallable<ListLinkedTargetsRequest, ListLinkedTargetsResponse>
      listLinkedTargetsCallable() {
    throw new UnsupportedOperationException("Not implemented: listLinkedTargetsCallable()");
  }

  public UnaryCallable<ListLinkedSourcesRequest, ListLinkedSourcesPagedResponse>
      listLinkedSourcesPagedCallable() {
    throw new UnsupportedOperationException("Not implemented: listLinkedSourcesPagedCallable()");
  }

  public UnaryCallable<ListLinkedSourcesRequest, ListLinkedSourcesResponse>
      listLinkedSourcesCallable() {
    throw new UnsupportedOperationException("Not implemented: listLinkedSourcesCallable()");
  }

  public UnaryCallable<CreateDocumentLinkRequest, DocumentLink> createDocumentLinkCallable() {
    throw new UnsupportedOperationException("Not implemented: createDocumentLinkCallable()");
  }

  public UnaryCallable<DeleteDocumentLinkRequest, Empty> deleteDocumentLinkCallable() {
    throw new UnsupportedOperationException("Not implemented: deleteDocumentLinkCallable()");
  }

  @Override
  public abstract void close();
}
