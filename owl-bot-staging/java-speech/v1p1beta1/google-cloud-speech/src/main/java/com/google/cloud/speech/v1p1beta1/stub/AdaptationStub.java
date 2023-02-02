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

package com.google.cloud.speech.v1p1beta1.stub;

import static com.google.cloud.speech.v1p1beta1.AdaptationClient.ListCustomClassesPagedResponse;
import static com.google.cloud.speech.v1p1beta1.AdaptationClient.ListPhraseSetPagedResponse;

import com.google.api.core.BetaApi;
import com.google.api.gax.core.BackgroundResource;
import com.google.api.gax.rpc.UnaryCallable;
import com.google.cloud.speech.v1p1beta1.CreateCustomClassRequest;
import com.google.cloud.speech.v1p1beta1.CreatePhraseSetRequest;
import com.google.cloud.speech.v1p1beta1.CustomClass;
import com.google.cloud.speech.v1p1beta1.DeleteCustomClassRequest;
import com.google.cloud.speech.v1p1beta1.DeletePhraseSetRequest;
import com.google.cloud.speech.v1p1beta1.GetCustomClassRequest;
import com.google.cloud.speech.v1p1beta1.GetPhraseSetRequest;
import com.google.cloud.speech.v1p1beta1.ListCustomClassesRequest;
import com.google.cloud.speech.v1p1beta1.ListCustomClassesResponse;
import com.google.cloud.speech.v1p1beta1.ListPhraseSetRequest;
import com.google.cloud.speech.v1p1beta1.ListPhraseSetResponse;
import com.google.cloud.speech.v1p1beta1.PhraseSet;
import com.google.cloud.speech.v1p1beta1.UpdateCustomClassRequest;
import com.google.cloud.speech.v1p1beta1.UpdatePhraseSetRequest;
import com.google.protobuf.Empty;
import javax.annotation.Generated;

// AUTO-GENERATED DOCUMENTATION AND CLASS.
/**
 * Base stub class for the Adaptation service API.
 *
 * <p>This class is for advanced usage and reflects the underlying API directly.
 */
@BetaApi
@Generated("by gapic-generator-java")
public abstract class AdaptationStub implements BackgroundResource {

  public UnaryCallable<CreatePhraseSetRequest, PhraseSet> createPhraseSetCallable() {
    throw new UnsupportedOperationException("Not implemented: createPhraseSetCallable()");
  }

  public UnaryCallable<GetPhraseSetRequest, PhraseSet> getPhraseSetCallable() {
    throw new UnsupportedOperationException("Not implemented: getPhraseSetCallable()");
  }

  public UnaryCallable<ListPhraseSetRequest, ListPhraseSetPagedResponse>
      listPhraseSetPagedCallable() {
    throw new UnsupportedOperationException("Not implemented: listPhraseSetPagedCallable()");
  }

  public UnaryCallable<ListPhraseSetRequest, ListPhraseSetResponse> listPhraseSetCallable() {
    throw new UnsupportedOperationException("Not implemented: listPhraseSetCallable()");
  }

  public UnaryCallable<UpdatePhraseSetRequest, PhraseSet> updatePhraseSetCallable() {
    throw new UnsupportedOperationException("Not implemented: updatePhraseSetCallable()");
  }

  public UnaryCallable<DeletePhraseSetRequest, Empty> deletePhraseSetCallable() {
    throw new UnsupportedOperationException("Not implemented: deletePhraseSetCallable()");
  }

  public UnaryCallable<CreateCustomClassRequest, CustomClass> createCustomClassCallable() {
    throw new UnsupportedOperationException("Not implemented: createCustomClassCallable()");
  }

  public UnaryCallable<GetCustomClassRequest, CustomClass> getCustomClassCallable() {
    throw new UnsupportedOperationException("Not implemented: getCustomClassCallable()");
  }

  public UnaryCallable<ListCustomClassesRequest, ListCustomClassesPagedResponse>
      listCustomClassesPagedCallable() {
    throw new UnsupportedOperationException("Not implemented: listCustomClassesPagedCallable()");
  }

  public UnaryCallable<ListCustomClassesRequest, ListCustomClassesResponse>
      listCustomClassesCallable() {
    throw new UnsupportedOperationException("Not implemented: listCustomClassesCallable()");
  }

  public UnaryCallable<UpdateCustomClassRequest, CustomClass> updateCustomClassCallable() {
    throw new UnsupportedOperationException("Not implemented: updateCustomClassCallable()");
  }

  public UnaryCallable<DeleteCustomClassRequest, Empty> deleteCustomClassCallable() {
    throw new UnsupportedOperationException("Not implemented: deleteCustomClassCallable()");
  }

  @Override
  public abstract void close();
}
