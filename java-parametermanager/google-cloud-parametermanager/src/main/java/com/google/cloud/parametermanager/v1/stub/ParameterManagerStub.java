/*
 * Copyright 2025 Google LLC
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

package com.google.cloud.parametermanager.v1.stub;

import static com.google.cloud.parametermanager.v1.ParameterManagerClient.ListLocationsPagedResponse;
import static com.google.cloud.parametermanager.v1.ParameterManagerClient.ListParameterVersionsPagedResponse;
import static com.google.cloud.parametermanager.v1.ParameterManagerClient.ListParametersPagedResponse;

import com.google.api.gax.core.BackgroundResource;
import com.google.api.gax.rpc.UnaryCallable;
import com.google.cloud.location.GetLocationRequest;
import com.google.cloud.location.ListLocationsRequest;
import com.google.cloud.location.ListLocationsResponse;
import com.google.cloud.location.Location;
import com.google.cloud.parametermanager.v1.CreateParameterRequest;
import com.google.cloud.parametermanager.v1.CreateParameterVersionRequest;
import com.google.cloud.parametermanager.v1.DeleteParameterRequest;
import com.google.cloud.parametermanager.v1.DeleteParameterVersionRequest;
import com.google.cloud.parametermanager.v1.GetParameterRequest;
import com.google.cloud.parametermanager.v1.GetParameterVersionRequest;
import com.google.cloud.parametermanager.v1.ListParameterVersionsRequest;
import com.google.cloud.parametermanager.v1.ListParameterVersionsResponse;
import com.google.cloud.parametermanager.v1.ListParametersRequest;
import com.google.cloud.parametermanager.v1.ListParametersResponse;
import com.google.cloud.parametermanager.v1.Parameter;
import com.google.cloud.parametermanager.v1.ParameterVersion;
import com.google.cloud.parametermanager.v1.RenderParameterVersionRequest;
import com.google.cloud.parametermanager.v1.RenderParameterVersionResponse;
import com.google.cloud.parametermanager.v1.UpdateParameterRequest;
import com.google.cloud.parametermanager.v1.UpdateParameterVersionRequest;
import com.google.protobuf.Empty;
import javax.annotation.Generated;

// AUTO-GENERATED DOCUMENTATION AND CLASS.
/**
 * Base stub class for the ParameterManager service API.
 *
 * <p>This class is for advanced usage and reflects the underlying API directly.
 */
@Generated("by gapic-generator-java")
public abstract class ParameterManagerStub implements BackgroundResource {

  public UnaryCallable<ListParametersRequest, ListParametersPagedResponse>
      listParametersPagedCallable() {
    throw new UnsupportedOperationException("Not implemented: listParametersPagedCallable()");
  }

  public UnaryCallable<ListParametersRequest, ListParametersResponse> listParametersCallable() {
    throw new UnsupportedOperationException("Not implemented: listParametersCallable()");
  }

  public UnaryCallable<GetParameterRequest, Parameter> getParameterCallable() {
    throw new UnsupportedOperationException("Not implemented: getParameterCallable()");
  }

  public UnaryCallable<CreateParameterRequest, Parameter> createParameterCallable() {
    throw new UnsupportedOperationException("Not implemented: createParameterCallable()");
  }

  public UnaryCallable<UpdateParameterRequest, Parameter> updateParameterCallable() {
    throw new UnsupportedOperationException("Not implemented: updateParameterCallable()");
  }

  public UnaryCallable<DeleteParameterRequest, Empty> deleteParameterCallable() {
    throw new UnsupportedOperationException("Not implemented: deleteParameterCallable()");
  }

  public UnaryCallable<ListParameterVersionsRequest, ListParameterVersionsPagedResponse>
      listParameterVersionsPagedCallable() {
    throw new UnsupportedOperationException(
        "Not implemented: listParameterVersionsPagedCallable()");
  }

  public UnaryCallable<ListParameterVersionsRequest, ListParameterVersionsResponse>
      listParameterVersionsCallable() {
    throw new UnsupportedOperationException("Not implemented: listParameterVersionsCallable()");
  }

  public UnaryCallable<GetParameterVersionRequest, ParameterVersion> getParameterVersionCallable() {
    throw new UnsupportedOperationException("Not implemented: getParameterVersionCallable()");
  }

  public UnaryCallable<RenderParameterVersionRequest, RenderParameterVersionResponse>
      renderParameterVersionCallable() {
    throw new UnsupportedOperationException("Not implemented: renderParameterVersionCallable()");
  }

  public UnaryCallable<CreateParameterVersionRequest, ParameterVersion>
      createParameterVersionCallable() {
    throw new UnsupportedOperationException("Not implemented: createParameterVersionCallable()");
  }

  public UnaryCallable<UpdateParameterVersionRequest, ParameterVersion>
      updateParameterVersionCallable() {
    throw new UnsupportedOperationException("Not implemented: updateParameterVersionCallable()");
  }

  public UnaryCallable<DeleteParameterVersionRequest, Empty> deleteParameterVersionCallable() {
    throw new UnsupportedOperationException("Not implemented: deleteParameterVersionCallable()");
  }

  public UnaryCallable<ListLocationsRequest, ListLocationsPagedResponse>
      listLocationsPagedCallable() {
    throw new UnsupportedOperationException("Not implemented: listLocationsPagedCallable()");
  }

  public UnaryCallable<ListLocationsRequest, ListLocationsResponse> listLocationsCallable() {
    throw new UnsupportedOperationException("Not implemented: listLocationsCallable()");
  }

  public UnaryCallable<GetLocationRequest, Location> getLocationCallable() {
    throw new UnsupportedOperationException("Not implemented: getLocationCallable()");
  }

  @Override
  public abstract void close();
}
