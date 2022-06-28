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

import com.google.api.gax.core.BackgroundResource;
import com.google.api.gax.rpc.OperationCallable;
import com.google.api.gax.rpc.UnaryCallable;
import com.google.appengine.v1.Application;
import com.google.appengine.v1.CreateApplicationRequest;
import com.google.appengine.v1.GetApplicationRequest;
import com.google.appengine.v1.OperationMetadataV1;
import com.google.appengine.v1.RepairApplicationRequest;
import com.google.appengine.v1.UpdateApplicationRequest;
import com.google.longrunning.Operation;
import com.google.longrunning.stub.OperationsStub;
import javax.annotation.Generated;

// AUTO-GENERATED DOCUMENTATION AND CLASS.
/**
 * Base stub class for the Applications service API.
 *
 * <p>This class is for advanced usage and reflects the underlying API directly.
 */
@Generated("by gapic-generator-java")
public abstract class ApplicationsStub implements BackgroundResource {

  public OperationsStub getOperationsStub() {
    return null;
  }

  public com.google.api.gax.httpjson.longrunning.stub.OperationsStub getHttpJsonOperationsStub() {
    return null;
  }

  public UnaryCallable<GetApplicationRequest, Application> getApplicationCallable() {
    throw new UnsupportedOperationException("Not implemented: getApplicationCallable()");
  }

  public OperationCallable<CreateApplicationRequest, Application, OperationMetadataV1>
      createApplicationOperationCallable() {
    throw new UnsupportedOperationException(
        "Not implemented: createApplicationOperationCallable()");
  }

  public UnaryCallable<CreateApplicationRequest, Operation> createApplicationCallable() {
    throw new UnsupportedOperationException("Not implemented: createApplicationCallable()");
  }

  public OperationCallable<UpdateApplicationRequest, Application, OperationMetadataV1>
      updateApplicationOperationCallable() {
    throw new UnsupportedOperationException(
        "Not implemented: updateApplicationOperationCallable()");
  }

  public UnaryCallable<UpdateApplicationRequest, Operation> updateApplicationCallable() {
    throw new UnsupportedOperationException("Not implemented: updateApplicationCallable()");
  }

  public OperationCallable<RepairApplicationRequest, Application, OperationMetadataV1>
      repairApplicationOperationCallable() {
    throw new UnsupportedOperationException(
        "Not implemented: repairApplicationOperationCallable()");
  }

  public UnaryCallable<RepairApplicationRequest, Operation> repairApplicationCallable() {
    throw new UnsupportedOperationException("Not implemented: repairApplicationCallable()");
  }

  @Override
  public abstract void close();
}
