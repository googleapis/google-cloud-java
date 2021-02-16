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

package com.google.cloud.dialogflow.v2beta1.stub;

import static com.google.cloud.dialogflow.v2beta1.KnowledgeBasesClient.ListKnowledgeBasesPagedResponse;

import com.google.api.gax.core.BackgroundResource;
import com.google.api.gax.rpc.UnaryCallable;
import com.google.cloud.dialogflow.v2beta1.CreateKnowledgeBaseRequest;
import com.google.cloud.dialogflow.v2beta1.DeleteKnowledgeBaseRequest;
import com.google.cloud.dialogflow.v2beta1.GetKnowledgeBaseRequest;
import com.google.cloud.dialogflow.v2beta1.KnowledgeBase;
import com.google.cloud.dialogflow.v2beta1.ListKnowledgeBasesRequest;
import com.google.cloud.dialogflow.v2beta1.ListKnowledgeBasesResponse;
import com.google.cloud.dialogflow.v2beta1.UpdateKnowledgeBaseRequest;
import com.google.protobuf.Empty;
import javax.annotation.Generated;

// AUTO-GENERATED DOCUMENTATION AND CLASS.
/**
 * Base stub class for the KnowledgeBases service API.
 *
 * <p>This class is for advanced usage and reflects the underlying API directly.
 */
@Generated("by gapic-generator")
public abstract class KnowledgeBasesStub implements BackgroundResource {

  public UnaryCallable<ListKnowledgeBasesRequest, ListKnowledgeBasesPagedResponse>
      listKnowledgeBasesPagedCallable() {
    throw new UnsupportedOperationException("Not implemented: listKnowledgeBasesPagedCallable()");
  }

  public UnaryCallable<ListKnowledgeBasesRequest, ListKnowledgeBasesResponse>
      listKnowledgeBasesCallable() {
    throw new UnsupportedOperationException("Not implemented: listKnowledgeBasesCallable()");
  }

  public UnaryCallable<GetKnowledgeBaseRequest, KnowledgeBase> getKnowledgeBaseCallable() {
    throw new UnsupportedOperationException("Not implemented: getKnowledgeBaseCallable()");
  }

  public UnaryCallable<CreateKnowledgeBaseRequest, KnowledgeBase> createKnowledgeBaseCallable() {
    throw new UnsupportedOperationException("Not implemented: createKnowledgeBaseCallable()");
  }

  public UnaryCallable<DeleteKnowledgeBaseRequest, Empty> deleteKnowledgeBaseCallable() {
    throw new UnsupportedOperationException("Not implemented: deleteKnowledgeBaseCallable()");
  }

  public UnaryCallable<UpdateKnowledgeBaseRequest, KnowledgeBase> updateKnowledgeBaseCallable() {
    throw new UnsupportedOperationException("Not implemented: updateKnowledgeBaseCallable()");
  }

  @Override
  public abstract void close();
}
