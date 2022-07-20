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

package com.google.appengine.v1.stub;

import static com.google.appengine.v1.VersionsClient.ListVersionsPagedResponse;

import com.google.api.gax.core.BackgroundResource;
import com.google.api.gax.rpc.OperationCallable;
import com.google.api.gax.rpc.UnaryCallable;
import com.google.appengine.v1.CreateVersionMetadataV1;
import com.google.appengine.v1.CreateVersionRequest;
import com.google.appengine.v1.DeleteVersionRequest;
import com.google.appengine.v1.GetVersionRequest;
import com.google.appengine.v1.ListVersionsRequest;
import com.google.appengine.v1.ListVersionsResponse;
import com.google.appengine.v1.OperationMetadataV1;
import com.google.appengine.v1.UpdateVersionRequest;
import com.google.appengine.v1.Version;
import com.google.longrunning.Operation;
import com.google.longrunning.stub.OperationsStub;
import com.google.protobuf.Empty;
import javax.annotation.Generated;

// AUTO-GENERATED DOCUMENTATION AND CLASS.
/**
 * Base stub class for the Versions service API.
 *
 * <p>This class is for advanced usage and reflects the underlying API directly.
 */
@Generated("by gapic-generator-java")
public abstract class VersionsStub implements BackgroundResource {

  public OperationsStub getOperationsStub() {
    return null;
  }

  public com.google.api.gax.httpjson.longrunning.stub.OperationsStub getHttpJsonOperationsStub() {
    return null;
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

  public OperationCallable<CreateVersionRequest, Version, CreateVersionMetadataV1>
      createVersionOperationCallable() {
    throw new UnsupportedOperationException("Not implemented: createVersionOperationCallable()");
  }

  public UnaryCallable<CreateVersionRequest, Operation> createVersionCallable() {
    throw new UnsupportedOperationException("Not implemented: createVersionCallable()");
  }

  public OperationCallable<UpdateVersionRequest, Version, OperationMetadataV1>
      updateVersionOperationCallable() {
    throw new UnsupportedOperationException("Not implemented: updateVersionOperationCallable()");
  }

  public UnaryCallable<UpdateVersionRequest, Operation> updateVersionCallable() {
    throw new UnsupportedOperationException("Not implemented: updateVersionCallable()");
  }

  public OperationCallable<DeleteVersionRequest, Empty, OperationMetadataV1>
      deleteVersionOperationCallable() {
    throw new UnsupportedOperationException("Not implemented: deleteVersionOperationCallable()");
  }

  public UnaryCallable<DeleteVersionRequest, Operation> deleteVersionCallable() {
    throw new UnsupportedOperationException("Not implemented: deleteVersionCallable()");
  }

  @Override
  public abstract void close();
}
