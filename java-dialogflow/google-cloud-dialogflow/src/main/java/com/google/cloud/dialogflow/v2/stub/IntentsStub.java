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

package com.google.cloud.dialogflow.v2.stub;

import static com.google.cloud.dialogflow.v2.IntentsClient.ListIntentsPagedResponse;

import com.google.api.gax.core.BackgroundResource;
import com.google.api.gax.rpc.OperationCallable;
import com.google.api.gax.rpc.UnaryCallable;
import com.google.cloud.dialogflow.v2.BatchDeleteIntentsRequest;
import com.google.cloud.dialogflow.v2.BatchUpdateIntentsRequest;
import com.google.cloud.dialogflow.v2.BatchUpdateIntentsResponse;
import com.google.cloud.dialogflow.v2.CreateIntentRequest;
import com.google.cloud.dialogflow.v2.DeleteIntentRequest;
import com.google.cloud.dialogflow.v2.GetIntentRequest;
import com.google.cloud.dialogflow.v2.Intent;
import com.google.cloud.dialogflow.v2.ListIntentsRequest;
import com.google.cloud.dialogflow.v2.ListIntentsResponse;
import com.google.cloud.dialogflow.v2.UpdateIntentRequest;
import com.google.longrunning.Operation;
import com.google.longrunning.stub.OperationsStub;
import com.google.protobuf.Empty;
import com.google.protobuf.Struct;
import javax.annotation.Generated;

// AUTO-GENERATED DOCUMENTATION AND CLASS.
/**
 * Base stub class for the Intents service API.
 *
 * <p>This class is for advanced usage and reflects the underlying API directly.
 */
@Generated("by gapic-generator")
public abstract class IntentsStub implements BackgroundResource {

  public OperationsStub getOperationsStub() {
    throw new UnsupportedOperationException("Not implemented: getOperationsStub()");
  }

  public UnaryCallable<ListIntentsRequest, ListIntentsPagedResponse> listIntentsPagedCallable() {
    throw new UnsupportedOperationException("Not implemented: listIntentsPagedCallable()");
  }

  public UnaryCallable<ListIntentsRequest, ListIntentsResponse> listIntentsCallable() {
    throw new UnsupportedOperationException("Not implemented: listIntentsCallable()");
  }

  public UnaryCallable<GetIntentRequest, Intent> getIntentCallable() {
    throw new UnsupportedOperationException("Not implemented: getIntentCallable()");
  }

  public UnaryCallable<CreateIntentRequest, Intent> createIntentCallable() {
    throw new UnsupportedOperationException("Not implemented: createIntentCallable()");
  }

  public UnaryCallable<UpdateIntentRequest, Intent> updateIntentCallable() {
    throw new UnsupportedOperationException("Not implemented: updateIntentCallable()");
  }

  public UnaryCallable<DeleteIntentRequest, Empty> deleteIntentCallable() {
    throw new UnsupportedOperationException("Not implemented: deleteIntentCallable()");
  }

  public OperationCallable<BatchUpdateIntentsRequest, BatchUpdateIntentsResponse, Struct>
      batchUpdateIntentsOperationCallable() {
    throw new UnsupportedOperationException(
        "Not implemented: batchUpdateIntentsOperationCallable()");
  }

  public UnaryCallable<BatchUpdateIntentsRequest, Operation> batchUpdateIntentsCallable() {
    throw new UnsupportedOperationException("Not implemented: batchUpdateIntentsCallable()");
  }

  public OperationCallable<BatchDeleteIntentsRequest, Empty, Struct>
      batchDeleteIntentsOperationCallable() {
    throw new UnsupportedOperationException(
        "Not implemented: batchDeleteIntentsOperationCallable()");
  }

  public UnaryCallable<BatchDeleteIntentsRequest, Operation> batchDeleteIntentsCallable() {
    throw new UnsupportedOperationException("Not implemented: batchDeleteIntentsCallable()");
  }

  @Override
  public abstract void close();
}
