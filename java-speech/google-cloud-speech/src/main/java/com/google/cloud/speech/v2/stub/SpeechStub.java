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

package com.google.cloud.speech.v2.stub;

import static com.google.cloud.speech.v2.SpeechClient.ListCustomClassesPagedResponse;
import static com.google.cloud.speech.v2.SpeechClient.ListPhraseSetsPagedResponse;
import static com.google.cloud.speech.v2.SpeechClient.ListRecognizersPagedResponse;

import com.google.api.gax.core.BackgroundResource;
import com.google.api.gax.rpc.BidiStreamingCallable;
import com.google.api.gax.rpc.OperationCallable;
import com.google.api.gax.rpc.UnaryCallable;
import com.google.cloud.speech.v2.BatchRecognizeRequest;
import com.google.cloud.speech.v2.BatchRecognizeResponse;
import com.google.cloud.speech.v2.Config;
import com.google.cloud.speech.v2.CreateCustomClassRequest;
import com.google.cloud.speech.v2.CreatePhraseSetRequest;
import com.google.cloud.speech.v2.CreateRecognizerRequest;
import com.google.cloud.speech.v2.CustomClass;
import com.google.cloud.speech.v2.DeleteCustomClassRequest;
import com.google.cloud.speech.v2.DeletePhraseSetRequest;
import com.google.cloud.speech.v2.DeleteRecognizerRequest;
import com.google.cloud.speech.v2.GetConfigRequest;
import com.google.cloud.speech.v2.GetCustomClassRequest;
import com.google.cloud.speech.v2.GetPhraseSetRequest;
import com.google.cloud.speech.v2.GetRecognizerRequest;
import com.google.cloud.speech.v2.ListCustomClassesRequest;
import com.google.cloud.speech.v2.ListCustomClassesResponse;
import com.google.cloud.speech.v2.ListPhraseSetsRequest;
import com.google.cloud.speech.v2.ListPhraseSetsResponse;
import com.google.cloud.speech.v2.ListRecognizersRequest;
import com.google.cloud.speech.v2.ListRecognizersResponse;
import com.google.cloud.speech.v2.OperationMetadata;
import com.google.cloud.speech.v2.PhraseSet;
import com.google.cloud.speech.v2.RecognizeRequest;
import com.google.cloud.speech.v2.RecognizeResponse;
import com.google.cloud.speech.v2.Recognizer;
import com.google.cloud.speech.v2.StreamingRecognizeRequest;
import com.google.cloud.speech.v2.StreamingRecognizeResponse;
import com.google.cloud.speech.v2.UndeleteCustomClassRequest;
import com.google.cloud.speech.v2.UndeletePhraseSetRequest;
import com.google.cloud.speech.v2.UndeleteRecognizerRequest;
import com.google.cloud.speech.v2.UpdateConfigRequest;
import com.google.cloud.speech.v2.UpdateCustomClassRequest;
import com.google.cloud.speech.v2.UpdatePhraseSetRequest;
import com.google.cloud.speech.v2.UpdateRecognizerRequest;
import com.google.longrunning.Operation;
import com.google.longrunning.stub.OperationsStub;
import javax.annotation.Generated;

// AUTO-GENERATED DOCUMENTATION AND CLASS.
/**
 * Base stub class for the Speech service API.
 *
 * <p>This class is for advanced usage and reflects the underlying API directly.
 */
@Generated("by gapic-generator-java")
public abstract class SpeechStub implements BackgroundResource {

  public OperationsStub getOperationsStub() {
    return null;
  }

  public com.google.api.gax.httpjson.longrunning.stub.OperationsStub getHttpJsonOperationsStub() {
    return null;
  }

  public OperationCallable<CreateRecognizerRequest, Recognizer, OperationMetadata>
      createRecognizerOperationCallable() {
    throw new UnsupportedOperationException("Not implemented: createRecognizerOperationCallable()");
  }

  public UnaryCallable<CreateRecognizerRequest, Operation> createRecognizerCallable() {
    throw new UnsupportedOperationException("Not implemented: createRecognizerCallable()");
  }

  public UnaryCallable<ListRecognizersRequest, ListRecognizersPagedResponse>
      listRecognizersPagedCallable() {
    throw new UnsupportedOperationException("Not implemented: listRecognizersPagedCallable()");
  }

  public UnaryCallable<ListRecognizersRequest, ListRecognizersResponse> listRecognizersCallable() {
    throw new UnsupportedOperationException("Not implemented: listRecognizersCallable()");
  }

  public UnaryCallable<GetRecognizerRequest, Recognizer> getRecognizerCallable() {
    throw new UnsupportedOperationException("Not implemented: getRecognizerCallable()");
  }

  public OperationCallable<UpdateRecognizerRequest, Recognizer, OperationMetadata>
      updateRecognizerOperationCallable() {
    throw new UnsupportedOperationException("Not implemented: updateRecognizerOperationCallable()");
  }

  public UnaryCallable<UpdateRecognizerRequest, Operation> updateRecognizerCallable() {
    throw new UnsupportedOperationException("Not implemented: updateRecognizerCallable()");
  }

  public OperationCallable<DeleteRecognizerRequest, Recognizer, OperationMetadata>
      deleteRecognizerOperationCallable() {
    throw new UnsupportedOperationException("Not implemented: deleteRecognizerOperationCallable()");
  }

  public UnaryCallable<DeleteRecognizerRequest, Operation> deleteRecognizerCallable() {
    throw new UnsupportedOperationException("Not implemented: deleteRecognizerCallable()");
  }

  public OperationCallable<UndeleteRecognizerRequest, Recognizer, OperationMetadata>
      undeleteRecognizerOperationCallable() {
    throw new UnsupportedOperationException(
        "Not implemented: undeleteRecognizerOperationCallable()");
  }

  public UnaryCallable<UndeleteRecognizerRequest, Operation> undeleteRecognizerCallable() {
    throw new UnsupportedOperationException("Not implemented: undeleteRecognizerCallable()");
  }

  public UnaryCallable<RecognizeRequest, RecognizeResponse> recognizeCallable() {
    throw new UnsupportedOperationException("Not implemented: recognizeCallable()");
  }

  public BidiStreamingCallable<StreamingRecognizeRequest, StreamingRecognizeResponse>
      streamingRecognizeCallable() {
    throw new UnsupportedOperationException("Not implemented: streamingRecognizeCallable()");
  }

  public OperationCallable<BatchRecognizeRequest, BatchRecognizeResponse, OperationMetadata>
      batchRecognizeOperationCallable() {
    throw new UnsupportedOperationException("Not implemented: batchRecognizeOperationCallable()");
  }

  public UnaryCallable<BatchRecognizeRequest, Operation> batchRecognizeCallable() {
    throw new UnsupportedOperationException("Not implemented: batchRecognizeCallable()");
  }

  public UnaryCallable<GetConfigRequest, Config> getConfigCallable() {
    throw new UnsupportedOperationException("Not implemented: getConfigCallable()");
  }

  public UnaryCallable<UpdateConfigRequest, Config> updateConfigCallable() {
    throw new UnsupportedOperationException("Not implemented: updateConfigCallable()");
  }

  public OperationCallable<CreateCustomClassRequest, CustomClass, OperationMetadata>
      createCustomClassOperationCallable() {
    throw new UnsupportedOperationException(
        "Not implemented: createCustomClassOperationCallable()");
  }

  public UnaryCallable<CreateCustomClassRequest, Operation> createCustomClassCallable() {
    throw new UnsupportedOperationException("Not implemented: createCustomClassCallable()");
  }

  public UnaryCallable<ListCustomClassesRequest, ListCustomClassesPagedResponse>
      listCustomClassesPagedCallable() {
    throw new UnsupportedOperationException("Not implemented: listCustomClassesPagedCallable()");
  }

  public UnaryCallable<ListCustomClassesRequest, ListCustomClassesResponse>
      listCustomClassesCallable() {
    throw new UnsupportedOperationException("Not implemented: listCustomClassesCallable()");
  }

  public UnaryCallable<GetCustomClassRequest, CustomClass> getCustomClassCallable() {
    throw new UnsupportedOperationException("Not implemented: getCustomClassCallable()");
  }

  public OperationCallable<UpdateCustomClassRequest, CustomClass, OperationMetadata>
      updateCustomClassOperationCallable() {
    throw new UnsupportedOperationException(
        "Not implemented: updateCustomClassOperationCallable()");
  }

  public UnaryCallable<UpdateCustomClassRequest, Operation> updateCustomClassCallable() {
    throw new UnsupportedOperationException("Not implemented: updateCustomClassCallable()");
  }

  public OperationCallable<DeleteCustomClassRequest, CustomClass, OperationMetadata>
      deleteCustomClassOperationCallable() {
    throw new UnsupportedOperationException(
        "Not implemented: deleteCustomClassOperationCallable()");
  }

  public UnaryCallable<DeleteCustomClassRequest, Operation> deleteCustomClassCallable() {
    throw new UnsupportedOperationException("Not implemented: deleteCustomClassCallable()");
  }

  public OperationCallable<UndeleteCustomClassRequest, CustomClass, OperationMetadata>
      undeleteCustomClassOperationCallable() {
    throw new UnsupportedOperationException(
        "Not implemented: undeleteCustomClassOperationCallable()");
  }

  public UnaryCallable<UndeleteCustomClassRequest, Operation> undeleteCustomClassCallable() {
    throw new UnsupportedOperationException("Not implemented: undeleteCustomClassCallable()");
  }

  public OperationCallable<CreatePhraseSetRequest, PhraseSet, OperationMetadata>
      createPhraseSetOperationCallable() {
    throw new UnsupportedOperationException("Not implemented: createPhraseSetOperationCallable()");
  }

  public UnaryCallable<CreatePhraseSetRequest, Operation> createPhraseSetCallable() {
    throw new UnsupportedOperationException("Not implemented: createPhraseSetCallable()");
  }

  public UnaryCallable<ListPhraseSetsRequest, ListPhraseSetsPagedResponse>
      listPhraseSetsPagedCallable() {
    throw new UnsupportedOperationException("Not implemented: listPhraseSetsPagedCallable()");
  }

  public UnaryCallable<ListPhraseSetsRequest, ListPhraseSetsResponse> listPhraseSetsCallable() {
    throw new UnsupportedOperationException("Not implemented: listPhraseSetsCallable()");
  }

  public UnaryCallable<GetPhraseSetRequest, PhraseSet> getPhraseSetCallable() {
    throw new UnsupportedOperationException("Not implemented: getPhraseSetCallable()");
  }

  public OperationCallable<UpdatePhraseSetRequest, PhraseSet, OperationMetadata>
      updatePhraseSetOperationCallable() {
    throw new UnsupportedOperationException("Not implemented: updatePhraseSetOperationCallable()");
  }

  public UnaryCallable<UpdatePhraseSetRequest, Operation> updatePhraseSetCallable() {
    throw new UnsupportedOperationException("Not implemented: updatePhraseSetCallable()");
  }

  public OperationCallable<DeletePhraseSetRequest, PhraseSet, OperationMetadata>
      deletePhraseSetOperationCallable() {
    throw new UnsupportedOperationException("Not implemented: deletePhraseSetOperationCallable()");
  }

  public UnaryCallable<DeletePhraseSetRequest, Operation> deletePhraseSetCallable() {
    throw new UnsupportedOperationException("Not implemented: deletePhraseSetCallable()");
  }

  public OperationCallable<UndeletePhraseSetRequest, PhraseSet, OperationMetadata>
      undeletePhraseSetOperationCallable() {
    throw new UnsupportedOperationException(
        "Not implemented: undeletePhraseSetOperationCallable()");
  }

  public UnaryCallable<UndeletePhraseSetRequest, Operation> undeletePhraseSetCallable() {
    throw new UnsupportedOperationException("Not implemented: undeletePhraseSetCallable()");
  }

  @Override
  public abstract void close();
}
