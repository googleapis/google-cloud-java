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

package com.google.cloud.shell.v1.stub;

import com.google.api.gax.core.BackgroundResource;
import com.google.api.gax.rpc.OperationCallable;
import com.google.api.gax.rpc.UnaryCallable;
import com.google.cloud.shell.v1.AddPublicKeyMetadata;
import com.google.cloud.shell.v1.AddPublicKeyRequest;
import com.google.cloud.shell.v1.AddPublicKeyResponse;
import com.google.cloud.shell.v1.AuthorizeEnvironmentMetadata;
import com.google.cloud.shell.v1.AuthorizeEnvironmentRequest;
import com.google.cloud.shell.v1.AuthorizeEnvironmentResponse;
import com.google.cloud.shell.v1.Environment;
import com.google.cloud.shell.v1.GetEnvironmentRequest;
import com.google.cloud.shell.v1.RemovePublicKeyMetadata;
import com.google.cloud.shell.v1.RemovePublicKeyRequest;
import com.google.cloud.shell.v1.RemovePublicKeyResponse;
import com.google.cloud.shell.v1.StartEnvironmentMetadata;
import com.google.cloud.shell.v1.StartEnvironmentRequest;
import com.google.cloud.shell.v1.StartEnvironmentResponse;
import com.google.longrunning.Operation;
import com.google.longrunning.stub.OperationsStub;
import javax.annotation.Generated;

// AUTO-GENERATED DOCUMENTATION AND CLASS.
/**
 * Base stub class for the CloudShellService service API.
 *
 * <p>This class is for advanced usage and reflects the underlying API directly.
 */
@Generated("by gapic-generator-java")
public abstract class CloudShellServiceStub implements BackgroundResource {

  public OperationsStub getOperationsStub() {
    return null;
  }

  public com.google.api.gax.httpjson.longrunning.stub.OperationsStub getHttpJsonOperationsStub() {
    return null;
  }

  public UnaryCallable<GetEnvironmentRequest, Environment> getEnvironmentCallable() {
    throw new UnsupportedOperationException("Not implemented: getEnvironmentCallable()");
  }

  public OperationCallable<
          StartEnvironmentRequest, StartEnvironmentResponse, StartEnvironmentMetadata>
      startEnvironmentOperationCallable() {
    throw new UnsupportedOperationException("Not implemented: startEnvironmentOperationCallable()");
  }

  public UnaryCallable<StartEnvironmentRequest, Operation> startEnvironmentCallable() {
    throw new UnsupportedOperationException("Not implemented: startEnvironmentCallable()");
  }

  public OperationCallable<
          AuthorizeEnvironmentRequest, AuthorizeEnvironmentResponse, AuthorizeEnvironmentMetadata>
      authorizeEnvironmentOperationCallable() {
    throw new UnsupportedOperationException(
        "Not implemented: authorizeEnvironmentOperationCallable()");
  }

  public UnaryCallable<AuthorizeEnvironmentRequest, Operation> authorizeEnvironmentCallable() {
    throw new UnsupportedOperationException("Not implemented: authorizeEnvironmentCallable()");
  }

  public OperationCallable<AddPublicKeyRequest, AddPublicKeyResponse, AddPublicKeyMetadata>
      addPublicKeyOperationCallable() {
    throw new UnsupportedOperationException("Not implemented: addPublicKeyOperationCallable()");
  }

  public UnaryCallable<AddPublicKeyRequest, Operation> addPublicKeyCallable() {
    throw new UnsupportedOperationException("Not implemented: addPublicKeyCallable()");
  }

  public OperationCallable<RemovePublicKeyRequest, RemovePublicKeyResponse, RemovePublicKeyMetadata>
      removePublicKeyOperationCallable() {
    throw new UnsupportedOperationException("Not implemented: removePublicKeyOperationCallable()");
  }

  public UnaryCallable<RemovePublicKeyRequest, Operation> removePublicKeyCallable() {
    throw new UnsupportedOperationException("Not implemented: removePublicKeyCallable()");
  }

  @Override
  public abstract void close();
}
