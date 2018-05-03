/*
 * Copyright 2018 Google LLC
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     https://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package com.google.cloud.speech.v1beta1.stub;

import com.google.api.core.BetaApi;
import com.google.api.gax.core.BackgroundResource;
import com.google.api.gax.rpc.BidiStreamingCallable;
import com.google.api.gax.rpc.OperationCallable;
import com.google.api.gax.rpc.UnaryCallable;
import com.google.cloud.speech.v1beta1.AsyncRecognizeMetadata;
import com.google.cloud.speech.v1beta1.AsyncRecognizeRequest;
import com.google.cloud.speech.v1beta1.AsyncRecognizeResponse;
import com.google.cloud.speech.v1beta1.StreamingRecognizeRequest;
import com.google.cloud.speech.v1beta1.StreamingRecognizeResponse;
import com.google.cloud.speech.v1beta1.SyncRecognizeRequest;
import com.google.cloud.speech.v1beta1.SyncRecognizeResponse;
import com.google.longrunning.Operation;
import com.google.longrunning.stub.OperationsStub;
import javax.annotation.Generated;

// AUTO-GENERATED DOCUMENTATION AND CLASS
/**
 * Base stub class for Google Cloud Speech API.
 *
 * <p>This class is for advanced usage and reflects the underlying API directly.
 */
@Generated("by gapic-generator")
@BetaApi("A restructuring of stub classes is planned, so this may break in the future")
public abstract class SpeechStub implements BackgroundResource {

  public OperationsStub getOperationsStub() {
    throw new UnsupportedOperationException("Not implemented: getOperationsStub()");
  }

  public UnaryCallable<SyncRecognizeRequest, SyncRecognizeResponse> syncRecognizeCallable() {
    throw new UnsupportedOperationException("Not implemented: syncRecognizeCallable()");
  }

  public OperationCallable<AsyncRecognizeRequest, AsyncRecognizeResponse, AsyncRecognizeMetadata>
      asyncRecognizeOperationCallable() {
    throw new UnsupportedOperationException("Not implemented: asyncRecognizeOperationCallable()");
  }

  public UnaryCallable<AsyncRecognizeRequest, Operation> asyncRecognizeCallable() {
    throw new UnsupportedOperationException("Not implemented: asyncRecognizeCallable()");
  }

  public BidiStreamingCallable<StreamingRecognizeRequest, StreamingRecognizeResponse>
      streamingRecognizeCallable() {
    throw new UnsupportedOperationException("Not implemented: streamingRecognizeCallable()");
  }

  @Override
  public abstract void close();
}
