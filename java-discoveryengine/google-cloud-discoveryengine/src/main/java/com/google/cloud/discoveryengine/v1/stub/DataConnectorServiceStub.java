/*
 * Copyright 2026 Google LLC
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

package com.google.cloud.discoveryengine.v1.stub;

import com.google.api.gax.core.BackgroundResource;
import com.google.api.gax.rpc.OperationCallable;
import com.google.api.gax.rpc.UnaryCallable;
import com.google.cloud.discoveryengine.v1.DataConnector;
import com.google.cloud.discoveryengine.v1.GetDataConnectorRequest;
import com.google.cloud.discoveryengine.v1.SetUpDataConnectorMetadata;
import com.google.cloud.discoveryengine.v1.SetUpDataConnectorRequest;
import com.google.cloud.discoveryengine.v1.UpdateDataConnectorRequest;
import com.google.longrunning.Operation;
import com.google.longrunning.stub.OperationsStub;
import javax.annotation.Generated;
import org.jspecify.annotations.NullMarked;
import org.jspecify.annotations.Nullable;

// AUTO-GENERATED DOCUMENTATION AND CLASS.
/**
 * Base stub class for the DataConnectorService service API.
 *
 * <p>This class is for advanced usage and reflects the underlying API directly.
 */
@NullMarked
@Generated("by gapic-generator-java")
public abstract class DataConnectorServiceStub implements BackgroundResource {

  public @Nullable OperationsStub getOperationsStub() {
    return null;
  }

  public com.google.api.gax.httpjson.longrunning.stub.@Nullable OperationsStub
      getHttpJsonOperationsStub() {
    return null;
  }

  public OperationCallable<SetUpDataConnectorRequest, DataConnector, SetUpDataConnectorMetadata>
      setUpDataConnectorOperationCallable() {
    throw new UnsupportedOperationException(
        "Not implemented: setUpDataConnectorOperationCallable()");
  }

  public UnaryCallable<SetUpDataConnectorRequest, Operation> setUpDataConnectorCallable() {
    throw new UnsupportedOperationException("Not implemented: setUpDataConnectorCallable()");
  }

  public UnaryCallable<GetDataConnectorRequest, DataConnector> getDataConnectorCallable() {
    throw new UnsupportedOperationException("Not implemented: getDataConnectorCallable()");
  }

  public UnaryCallable<UpdateDataConnectorRequest, DataConnector> updateDataConnectorCallable() {
    throw new UnsupportedOperationException("Not implemented: updateDataConnectorCallable()");
  }

  @Override
  public abstract void close();
}
