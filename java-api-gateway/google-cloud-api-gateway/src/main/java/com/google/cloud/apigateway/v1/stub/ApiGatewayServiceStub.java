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

package com.google.cloud.apigateway.v1.stub;

import static com.google.cloud.apigateway.v1.ApiGatewayServiceClient.ListApiConfigsPagedResponse;
import static com.google.cloud.apigateway.v1.ApiGatewayServiceClient.ListApisPagedResponse;
import static com.google.cloud.apigateway.v1.ApiGatewayServiceClient.ListGatewaysPagedResponse;

import com.google.api.gax.core.BackgroundResource;
import com.google.api.gax.rpc.OperationCallable;
import com.google.api.gax.rpc.UnaryCallable;
import com.google.cloud.apigateway.v1.Api;
import com.google.cloud.apigateway.v1.ApiConfig;
import com.google.cloud.apigateway.v1.CreateApiConfigRequest;
import com.google.cloud.apigateway.v1.CreateApiRequest;
import com.google.cloud.apigateway.v1.CreateGatewayRequest;
import com.google.cloud.apigateway.v1.DeleteApiConfigRequest;
import com.google.cloud.apigateway.v1.DeleteApiRequest;
import com.google.cloud.apigateway.v1.DeleteGatewayRequest;
import com.google.cloud.apigateway.v1.Gateway;
import com.google.cloud.apigateway.v1.GetApiConfigRequest;
import com.google.cloud.apigateway.v1.GetApiRequest;
import com.google.cloud.apigateway.v1.GetGatewayRequest;
import com.google.cloud.apigateway.v1.ListApiConfigsRequest;
import com.google.cloud.apigateway.v1.ListApiConfigsResponse;
import com.google.cloud.apigateway.v1.ListApisRequest;
import com.google.cloud.apigateway.v1.ListApisResponse;
import com.google.cloud.apigateway.v1.ListGatewaysRequest;
import com.google.cloud.apigateway.v1.ListGatewaysResponse;
import com.google.cloud.apigateway.v1.OperationMetadata;
import com.google.cloud.apigateway.v1.UpdateApiConfigRequest;
import com.google.cloud.apigateway.v1.UpdateApiRequest;
import com.google.cloud.apigateway.v1.UpdateGatewayRequest;
import com.google.longrunning.Operation;
import com.google.longrunning.stub.OperationsStub;
import com.google.protobuf.Empty;
import javax.annotation.Generated;

// AUTO-GENERATED DOCUMENTATION AND CLASS.
/**
 * Base stub class for the ApiGatewayService service API.
 *
 * <p>This class is for advanced usage and reflects the underlying API directly.
 */
@Generated("by gapic-generator-java")
public abstract class ApiGatewayServiceStub implements BackgroundResource {

  public OperationsStub getOperationsStub() {
    return null;
  }

  public com.google.api.gax.httpjson.longrunning.stub.OperationsStub getHttpJsonOperationsStub() {
    return null;
  }

  public UnaryCallable<ListGatewaysRequest, ListGatewaysPagedResponse> listGatewaysPagedCallable() {
    throw new UnsupportedOperationException("Not implemented: listGatewaysPagedCallable()");
  }

  public UnaryCallable<ListGatewaysRequest, ListGatewaysResponse> listGatewaysCallable() {
    throw new UnsupportedOperationException("Not implemented: listGatewaysCallable()");
  }

  public UnaryCallable<GetGatewayRequest, Gateway> getGatewayCallable() {
    throw new UnsupportedOperationException("Not implemented: getGatewayCallable()");
  }

  public OperationCallable<CreateGatewayRequest, Gateway, OperationMetadata>
      createGatewayOperationCallable() {
    throw new UnsupportedOperationException("Not implemented: createGatewayOperationCallable()");
  }

  public UnaryCallable<CreateGatewayRequest, Operation> createGatewayCallable() {
    throw new UnsupportedOperationException("Not implemented: createGatewayCallable()");
  }

  public OperationCallable<UpdateGatewayRequest, Gateway, OperationMetadata>
      updateGatewayOperationCallable() {
    throw new UnsupportedOperationException("Not implemented: updateGatewayOperationCallable()");
  }

  public UnaryCallable<UpdateGatewayRequest, Operation> updateGatewayCallable() {
    throw new UnsupportedOperationException("Not implemented: updateGatewayCallable()");
  }

  public OperationCallable<DeleteGatewayRequest, Empty, OperationMetadata>
      deleteGatewayOperationCallable() {
    throw new UnsupportedOperationException("Not implemented: deleteGatewayOperationCallable()");
  }

  public UnaryCallable<DeleteGatewayRequest, Operation> deleteGatewayCallable() {
    throw new UnsupportedOperationException("Not implemented: deleteGatewayCallable()");
  }

  public UnaryCallable<ListApisRequest, ListApisPagedResponse> listApisPagedCallable() {
    throw new UnsupportedOperationException("Not implemented: listApisPagedCallable()");
  }

  public UnaryCallable<ListApisRequest, ListApisResponse> listApisCallable() {
    throw new UnsupportedOperationException("Not implemented: listApisCallable()");
  }

  public UnaryCallable<GetApiRequest, Api> getApiCallable() {
    throw new UnsupportedOperationException("Not implemented: getApiCallable()");
  }

  public OperationCallable<CreateApiRequest, Api, OperationMetadata> createApiOperationCallable() {
    throw new UnsupportedOperationException("Not implemented: createApiOperationCallable()");
  }

  public UnaryCallable<CreateApiRequest, Operation> createApiCallable() {
    throw new UnsupportedOperationException("Not implemented: createApiCallable()");
  }

  public OperationCallable<UpdateApiRequest, Api, OperationMetadata> updateApiOperationCallable() {
    throw new UnsupportedOperationException("Not implemented: updateApiOperationCallable()");
  }

  public UnaryCallable<UpdateApiRequest, Operation> updateApiCallable() {
    throw new UnsupportedOperationException("Not implemented: updateApiCallable()");
  }

  public OperationCallable<DeleteApiRequest, Empty, OperationMetadata>
      deleteApiOperationCallable() {
    throw new UnsupportedOperationException("Not implemented: deleteApiOperationCallable()");
  }

  public UnaryCallable<DeleteApiRequest, Operation> deleteApiCallable() {
    throw new UnsupportedOperationException("Not implemented: deleteApiCallable()");
  }

  public UnaryCallable<ListApiConfigsRequest, ListApiConfigsPagedResponse>
      listApiConfigsPagedCallable() {
    throw new UnsupportedOperationException("Not implemented: listApiConfigsPagedCallable()");
  }

  public UnaryCallable<ListApiConfigsRequest, ListApiConfigsResponse> listApiConfigsCallable() {
    throw new UnsupportedOperationException("Not implemented: listApiConfigsCallable()");
  }

  public UnaryCallable<GetApiConfigRequest, ApiConfig> getApiConfigCallable() {
    throw new UnsupportedOperationException("Not implemented: getApiConfigCallable()");
  }

  public OperationCallable<CreateApiConfigRequest, ApiConfig, OperationMetadata>
      createApiConfigOperationCallable() {
    throw new UnsupportedOperationException("Not implemented: createApiConfigOperationCallable()");
  }

  public UnaryCallable<CreateApiConfigRequest, Operation> createApiConfigCallable() {
    throw new UnsupportedOperationException("Not implemented: createApiConfigCallable()");
  }

  public OperationCallable<UpdateApiConfigRequest, ApiConfig, OperationMetadata>
      updateApiConfigOperationCallable() {
    throw new UnsupportedOperationException("Not implemented: updateApiConfigOperationCallable()");
  }

  public UnaryCallable<UpdateApiConfigRequest, Operation> updateApiConfigCallable() {
    throw new UnsupportedOperationException("Not implemented: updateApiConfigCallable()");
  }

  public OperationCallable<DeleteApiConfigRequest, Empty, OperationMetadata>
      deleteApiConfigOperationCallable() {
    throw new UnsupportedOperationException("Not implemented: deleteApiConfigOperationCallable()");
  }

  public UnaryCallable<DeleteApiConfigRequest, Operation> deleteApiConfigCallable() {
    throw new UnsupportedOperationException("Not implemented: deleteApiConfigCallable()");
  }

  @Override
  public abstract void close();
}
