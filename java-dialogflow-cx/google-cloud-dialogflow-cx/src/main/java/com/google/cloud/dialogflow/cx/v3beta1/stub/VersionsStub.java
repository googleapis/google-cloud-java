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

package com.google.cloud.dialogflow.cx.v3beta1.stub;

import static com.google.cloud.dialogflow.cx.v3beta1.VersionsClient.ListVersionsPagedResponse;

import com.google.api.gax.core.BackgroundResource;
import com.google.api.gax.rpc.OperationCallable;
import com.google.api.gax.rpc.UnaryCallable;
import com.google.cloud.dialogflow.cx.v3beta1.CreateVersionOperationMetadata;
import com.google.cloud.dialogflow.cx.v3beta1.CreateVersionRequest;
import com.google.cloud.dialogflow.cx.v3beta1.DeleteVersionRequest;
import com.google.cloud.dialogflow.cx.v3beta1.GetVersionRequest;
import com.google.cloud.dialogflow.cx.v3beta1.ListVersionsRequest;
import com.google.cloud.dialogflow.cx.v3beta1.ListVersionsResponse;
import com.google.cloud.dialogflow.cx.v3beta1.LoadVersionRequest;
import com.google.cloud.dialogflow.cx.v3beta1.UpdateVersionRequest;
import com.google.cloud.dialogflow.cx.v3beta1.Version;
import com.google.longrunning.Operation;
import com.google.longrunning.stub.OperationsStub;
import com.google.protobuf.Empty;
import com.google.protobuf.Struct;
import javax.annotation.Generated;

// AUTO-GENERATED DOCUMENTATION AND CLASS.
/**
 * Base stub class for the Versions service API.
 *
 * <p>This class is for advanced usage and reflects the underlying API directly.
 */
@Generated("by gapic-generator")
public abstract class VersionsStub implements BackgroundResource {

  public OperationsStub getOperationsStub() {
    throw new UnsupportedOperationException("Not implemented: getOperationsStub()");
  }

  public UnaryCallable<ListVersionsRequest, ListVersionsPagedResponse> listVersionsPagedCallable() {
    throw new UnsupportedOperationException("Not implemented: listVersionsPagedCallable()");
  }

  public UnaryCallable<ListVersionsRequest, ListVersionsResponse> listVersionsCallable() {
    throw new UnsupportedOperationException("Not implemented: listVersionsCallable()");
  }

  public UnaryCallable<GetVersionRequest, Version> getVersionCallable() {
    throw new UnsupportedOperationException("Not implemented: getVersionCallable()");
  }

  public OperationCallable<CreateVersionRequest, Version, CreateVersionOperationMetadata>
      createVersionOperationCallable() {
    throw new UnsupportedOperationException("Not implemented: createVersionOperationCallable()");
  }

  public UnaryCallable<CreateVersionRequest, Operation> createVersionCallable() {
    throw new UnsupportedOperationException("Not implemented: createVersionCallable()");
  }

  public UnaryCallable<UpdateVersionRequest, Version> updateVersionCallable() {
    throw new UnsupportedOperationException("Not implemented: updateVersionCallable()");
  }

  public UnaryCallable<DeleteVersionRequest, Empty> deleteVersionCallable() {
    throw new UnsupportedOperationException("Not implemented: deleteVersionCallable()");
  }

  public OperationCallable<LoadVersionRequest, Empty, Struct> loadVersionOperationCallable() {
    throw new UnsupportedOperationException("Not implemented: loadVersionOperationCallable()");
  }

  public UnaryCallable<LoadVersionRequest, Operation> loadVersionCallable() {
    throw new UnsupportedOperationException("Not implemented: loadVersionCallable()");
  }

  @Override
  public abstract void close();
}
