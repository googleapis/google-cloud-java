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

package com.google.cloud.networkservices.v1;

import com.google.api.core.BetaApi;
import com.google.cloud.networkservices.v1.NetworkServicesGrpc.NetworkServicesImplBase;
import com.google.longrunning.Operation;
import com.google.protobuf.AbstractMessage;
import io.grpc.stub.StreamObserver;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import javax.annotation.Generated;

@BetaApi
@Generated("by gapic-generator-java")
public class MockNetworkServicesImpl extends NetworkServicesImplBase {
  private List<AbstractMessage> requests;
  private Queue<Object> responses;

  public MockNetworkServicesImpl() {
    requests = new ArrayList<>();
    responses = new LinkedList<>();
  }

  public List<AbstractMessage> getRequests() {
    return requests;
  }

  public void addResponse(AbstractMessage response) {
    responses.add(response);
  }

  public void setResponses(List<AbstractMessage> responses) {
    this.responses = new LinkedList<Object>(responses);
  }

  public void addException(Exception exception) {
    responses.add(exception);
  }

  public void reset() {
    requests = new ArrayList<>();
    responses = new LinkedList<>();
  }

  @Override
  public void listEndpointPolicies(
      ListEndpointPoliciesRequest request,
      StreamObserver<ListEndpointPoliciesResponse> responseObserver) {
    Object response = responses.poll();
    if (response instanceof ListEndpointPoliciesResponse) {
      requests.add(request);
      responseObserver.onNext(((ListEndpointPoliciesResponse) response));
      responseObserver.onCompleted();
    } else if (response instanceof Exception) {
      responseObserver.onError(((Exception) response));
    } else {
      responseObserver.onError(
          new IllegalArgumentException(
              String.format(
                  "Unrecognized response type %s for method ListEndpointPolicies, expected %s or"
                      + " %s",
                  response == null ? "null" : response.getClass().getName(),
                  ListEndpointPoliciesResponse.class.getName(),
                  Exception.class.getName())));
    }
  }

  @Override
  public void getEndpointPolicy(
      GetEndpointPolicyRequest request, StreamObserver<EndpointPolicy> responseObserver) {
    Object response = responses.poll();
    if (response instanceof EndpointPolicy) {
      requests.add(request);
      responseObserver.onNext(((EndpointPolicy) response));
      responseObserver.onCompleted();
    } else if (response instanceof Exception) {
      responseObserver.onError(((Exception) response));
    } else {
      responseObserver.onError(
          new IllegalArgumentException(
              String.format(
                  "Unrecognized response type %s for method GetEndpointPolicy, expected %s or %s",
                  response == null ? "null" : response.getClass().getName(),
                  EndpointPolicy.class.getName(),
                  Exception.class.getName())));
    }
  }

  @Override
  public void createEndpointPolicy(
      CreateEndpointPolicyRequest request, StreamObserver<Operation> responseObserver) {
    Object response = responses.poll();
    if (response instanceof Operation) {
      requests.add(request);
      responseObserver.onNext(((Operation) response));
      responseObserver.onCompleted();
    } else if (response instanceof Exception) {
      responseObserver.onError(((Exception) response));
    } else {
      responseObserver.onError(
          new IllegalArgumentException(
              String.format(
                  "Unrecognized response type %s for method CreateEndpointPolicy, expected %s or"
                      + " %s",
                  response == null ? "null" : response.getClass().getName(),
                  Operation.class.getName(),
                  Exception.class.getName())));
    }
  }

  @Override
  public void updateEndpointPolicy(
      UpdateEndpointPolicyRequest request, StreamObserver<Operation> responseObserver) {
    Object response = responses.poll();
    if (response instanceof Operation) {
      requests.add(request);
      responseObserver.onNext(((Operation) response));
      responseObserver.onCompleted();
    } else if (response instanceof Exception) {
      responseObserver.onError(((Exception) response));
    } else {
      responseObserver.onError(
          new IllegalArgumentException(
              String.format(
                  "Unrecognized response type %s for method UpdateEndpointPolicy, expected %s or"
                      + " %s",
                  response == null ? "null" : response.getClass().getName(),
                  Operation.class.getName(),
                  Exception.class.getName())));
    }
  }

  @Override
  public void deleteEndpointPolicy(
      DeleteEndpointPolicyRequest request, StreamObserver<Operation> responseObserver) {
    Object response = responses.poll();
    if (response instanceof Operation) {
      requests.add(request);
      responseObserver.onNext(((Operation) response));
      responseObserver.onCompleted();
    } else if (response instanceof Exception) {
      responseObserver.onError(((Exception) response));
    } else {
      responseObserver.onError(
          new IllegalArgumentException(
              String.format(
                  "Unrecognized response type %s for method DeleteEndpointPolicy, expected %s or"
                      + " %s",
                  response == null ? "null" : response.getClass().getName(),
                  Operation.class.getName(),
                  Exception.class.getName())));
    }
  }

  @Override
  public void listWasmPluginVersions(
      ListWasmPluginVersionsRequest request,
      StreamObserver<ListWasmPluginVersionsResponse> responseObserver) {
    Object response = responses.poll();
    if (response instanceof ListWasmPluginVersionsResponse) {
      requests.add(request);
      responseObserver.onNext(((ListWasmPluginVersionsResponse) response));
      responseObserver.onCompleted();
    } else if (response instanceof Exception) {
      responseObserver.onError(((Exception) response));
    } else {
      responseObserver.onError(
          new IllegalArgumentException(
              String.format(
                  "Unrecognized response type %s for method ListWasmPluginVersions, expected %s or"
                      + " %s",
                  response == null ? "null" : response.getClass().getName(),
                  ListWasmPluginVersionsResponse.class.getName(),
                  Exception.class.getName())));
    }
  }

  @Override
  public void getWasmPluginVersion(
      GetWasmPluginVersionRequest request, StreamObserver<WasmPluginVersion> responseObserver) {
    Object response = responses.poll();
    if (response instanceof WasmPluginVersion) {
      requests.add(request);
      responseObserver.onNext(((WasmPluginVersion) response));
      responseObserver.onCompleted();
    } else if (response instanceof Exception) {
      responseObserver.onError(((Exception) response));
    } else {
      responseObserver.onError(
          new IllegalArgumentException(
              String.format(
                  "Unrecognized response type %s for method GetWasmPluginVersion, expected %s or"
                      + " %s",
                  response == null ? "null" : response.getClass().getName(),
                  WasmPluginVersion.class.getName(),
                  Exception.class.getName())));
    }
  }

  @Override
  public void createWasmPluginVersion(
      CreateWasmPluginVersionRequest request, StreamObserver<Operation> responseObserver) {
    Object response = responses.poll();
    if (response instanceof Operation) {
      requests.add(request);
      responseObserver.onNext(((Operation) response));
      responseObserver.onCompleted();
    } else if (response instanceof Exception) {
      responseObserver.onError(((Exception) response));
    } else {
      responseObserver.onError(
          new IllegalArgumentException(
              String.format(
                  "Unrecognized response type %s for method CreateWasmPluginVersion, expected %s or"
                      + " %s",
                  response == null ? "null" : response.getClass().getName(),
                  Operation.class.getName(),
                  Exception.class.getName())));
    }
  }

  @Override
  public void deleteWasmPluginVersion(
      DeleteWasmPluginVersionRequest request, StreamObserver<Operation> responseObserver) {
    Object response = responses.poll();
    if (response instanceof Operation) {
      requests.add(request);
      responseObserver.onNext(((Operation) response));
      responseObserver.onCompleted();
    } else if (response instanceof Exception) {
      responseObserver.onError(((Exception) response));
    } else {
      responseObserver.onError(
          new IllegalArgumentException(
              String.format(
                  "Unrecognized response type %s for method DeleteWasmPluginVersion, expected %s or"
                      + " %s",
                  response == null ? "null" : response.getClass().getName(),
                  Operation.class.getName(),
                  Exception.class.getName())));
    }
  }

  @Override
  public void listWasmPlugins(
      ListWasmPluginsRequest request, StreamObserver<ListWasmPluginsResponse> responseObserver) {
    Object response = responses.poll();
    if (response instanceof ListWasmPluginsResponse) {
      requests.add(request);
      responseObserver.onNext(((ListWasmPluginsResponse) response));
      responseObserver.onCompleted();
    } else if (response instanceof Exception) {
      responseObserver.onError(((Exception) response));
    } else {
      responseObserver.onError(
          new IllegalArgumentException(
              String.format(
                  "Unrecognized response type %s for method ListWasmPlugins, expected %s or %s",
                  response == null ? "null" : response.getClass().getName(),
                  ListWasmPluginsResponse.class.getName(),
                  Exception.class.getName())));
    }
  }

  @Override
  public void getWasmPlugin(
      GetWasmPluginRequest request, StreamObserver<WasmPlugin> responseObserver) {
    Object response = responses.poll();
    if (response instanceof WasmPlugin) {
      requests.add(request);
      responseObserver.onNext(((WasmPlugin) response));
      responseObserver.onCompleted();
    } else if (response instanceof Exception) {
      responseObserver.onError(((Exception) response));
    } else {
      responseObserver.onError(
          new IllegalArgumentException(
              String.format(
                  "Unrecognized response type %s for method GetWasmPlugin, expected %s or %s",
                  response == null ? "null" : response.getClass().getName(),
                  WasmPlugin.class.getName(),
                  Exception.class.getName())));
    }
  }

  @Override
  public void createWasmPlugin(
      CreateWasmPluginRequest request, StreamObserver<Operation> responseObserver) {
    Object response = responses.poll();
    if (response instanceof Operation) {
      requests.add(request);
      responseObserver.onNext(((Operation) response));
      responseObserver.onCompleted();
    } else if (response instanceof Exception) {
      responseObserver.onError(((Exception) response));
    } else {
      responseObserver.onError(
          new IllegalArgumentException(
              String.format(
                  "Unrecognized response type %s for method CreateWasmPlugin, expected %s or %s",
                  response == null ? "null" : response.getClass().getName(),
                  Operation.class.getName(),
                  Exception.class.getName())));
    }
  }

  @Override
  public void updateWasmPlugin(
      UpdateWasmPluginRequest request, StreamObserver<Operation> responseObserver) {
    Object response = responses.poll();
    if (response instanceof Operation) {
      requests.add(request);
      responseObserver.onNext(((Operation) response));
      responseObserver.onCompleted();
    } else if (response instanceof Exception) {
      responseObserver.onError(((Exception) response));
    } else {
      responseObserver.onError(
          new IllegalArgumentException(
              String.format(
                  "Unrecognized response type %s for method UpdateWasmPlugin, expected %s or %s",
                  response == null ? "null" : response.getClass().getName(),
                  Operation.class.getName(),
                  Exception.class.getName())));
    }
  }

  @Override
  public void deleteWasmPlugin(
      DeleteWasmPluginRequest request, StreamObserver<Operation> responseObserver) {
    Object response = responses.poll();
    if (response instanceof Operation) {
      requests.add(request);
      responseObserver.onNext(((Operation) response));
      responseObserver.onCompleted();
    } else if (response instanceof Exception) {
      responseObserver.onError(((Exception) response));
    } else {
      responseObserver.onError(
          new IllegalArgumentException(
              String.format(
                  "Unrecognized response type %s for method DeleteWasmPlugin, expected %s or %s",
                  response == null ? "null" : response.getClass().getName(),
                  Operation.class.getName(),
                  Exception.class.getName())));
    }
  }

  @Override
  public void listGateways(
      ListGatewaysRequest request, StreamObserver<ListGatewaysResponse> responseObserver) {
    Object response = responses.poll();
    if (response instanceof ListGatewaysResponse) {
      requests.add(request);
      responseObserver.onNext(((ListGatewaysResponse) response));
      responseObserver.onCompleted();
    } else if (response instanceof Exception) {
      responseObserver.onError(((Exception) response));
    } else {
      responseObserver.onError(
          new IllegalArgumentException(
              String.format(
                  "Unrecognized response type %s for method ListGateways, expected %s or %s",
                  response == null ? "null" : response.getClass().getName(),
                  ListGatewaysResponse.class.getName(),
                  Exception.class.getName())));
    }
  }

  @Override
  public void getGateway(GetGatewayRequest request, StreamObserver<Gateway> responseObserver) {
    Object response = responses.poll();
    if (response instanceof Gateway) {
      requests.add(request);
      responseObserver.onNext(((Gateway) response));
      responseObserver.onCompleted();
    } else if (response instanceof Exception) {
      responseObserver.onError(((Exception) response));
    } else {
      responseObserver.onError(
          new IllegalArgumentException(
              String.format(
                  "Unrecognized response type %s for method GetGateway, expected %s or %s",
                  response == null ? "null" : response.getClass().getName(),
                  Gateway.class.getName(),
                  Exception.class.getName())));
    }
  }

  @Override
  public void createGateway(
      CreateGatewayRequest request, StreamObserver<Operation> responseObserver) {
    Object response = responses.poll();
    if (response instanceof Operation) {
      requests.add(request);
      responseObserver.onNext(((Operation) response));
      responseObserver.onCompleted();
    } else if (response instanceof Exception) {
      responseObserver.onError(((Exception) response));
    } else {
      responseObserver.onError(
          new IllegalArgumentException(
              String.format(
                  "Unrecognized response type %s for method CreateGateway, expected %s or %s",
                  response == null ? "null" : response.getClass().getName(),
                  Operation.class.getName(),
                  Exception.class.getName())));
    }
  }

  @Override
  public void updateGateway(
      UpdateGatewayRequest request, StreamObserver<Operation> responseObserver) {
    Object response = responses.poll();
    if (response instanceof Operation) {
      requests.add(request);
      responseObserver.onNext(((Operation) response));
      responseObserver.onCompleted();
    } else if (response instanceof Exception) {
      responseObserver.onError(((Exception) response));
    } else {
      responseObserver.onError(
          new IllegalArgumentException(
              String.format(
                  "Unrecognized response type %s for method UpdateGateway, expected %s or %s",
                  response == null ? "null" : response.getClass().getName(),
                  Operation.class.getName(),
                  Exception.class.getName())));
    }
  }

  @Override
  public void deleteGateway(
      DeleteGatewayRequest request, StreamObserver<Operation> responseObserver) {
    Object response = responses.poll();
    if (response instanceof Operation) {
      requests.add(request);
      responseObserver.onNext(((Operation) response));
      responseObserver.onCompleted();
    } else if (response instanceof Exception) {
      responseObserver.onError(((Exception) response));
    } else {
      responseObserver.onError(
          new IllegalArgumentException(
              String.format(
                  "Unrecognized response type %s for method DeleteGateway, expected %s or %s",
                  response == null ? "null" : response.getClass().getName(),
                  Operation.class.getName(),
                  Exception.class.getName())));
    }
  }

  @Override
  public void listGrpcRoutes(
      ListGrpcRoutesRequest request, StreamObserver<ListGrpcRoutesResponse> responseObserver) {
    Object response = responses.poll();
    if (response instanceof ListGrpcRoutesResponse) {
      requests.add(request);
      responseObserver.onNext(((ListGrpcRoutesResponse) response));
      responseObserver.onCompleted();
    } else if (response instanceof Exception) {
      responseObserver.onError(((Exception) response));
    } else {
      responseObserver.onError(
          new IllegalArgumentException(
              String.format(
                  "Unrecognized response type %s for method ListGrpcRoutes, expected %s or %s",
                  response == null ? "null" : response.getClass().getName(),
                  ListGrpcRoutesResponse.class.getName(),
                  Exception.class.getName())));
    }
  }

  @Override
  public void getGrpcRoute(
      GetGrpcRouteRequest request, StreamObserver<GrpcRoute> responseObserver) {
    Object response = responses.poll();
    if (response instanceof GrpcRoute) {
      requests.add(request);
      responseObserver.onNext(((GrpcRoute) response));
      responseObserver.onCompleted();
    } else if (response instanceof Exception) {
      responseObserver.onError(((Exception) response));
    } else {
      responseObserver.onError(
          new IllegalArgumentException(
              String.format(
                  "Unrecognized response type %s for method GetGrpcRoute, expected %s or %s",
                  response == null ? "null" : response.getClass().getName(),
                  GrpcRoute.class.getName(),
                  Exception.class.getName())));
    }
  }

  @Override
  public void createGrpcRoute(
      CreateGrpcRouteRequest request, StreamObserver<Operation> responseObserver) {
    Object response = responses.poll();
    if (response instanceof Operation) {
      requests.add(request);
      responseObserver.onNext(((Operation) response));
      responseObserver.onCompleted();
    } else if (response instanceof Exception) {
      responseObserver.onError(((Exception) response));
    } else {
      responseObserver.onError(
          new IllegalArgumentException(
              String.format(
                  "Unrecognized response type %s for method CreateGrpcRoute, expected %s or %s",
                  response == null ? "null" : response.getClass().getName(),
                  Operation.class.getName(),
                  Exception.class.getName())));
    }
  }

  @Override
  public void updateGrpcRoute(
      UpdateGrpcRouteRequest request, StreamObserver<Operation> responseObserver) {
    Object response = responses.poll();
    if (response instanceof Operation) {
      requests.add(request);
      responseObserver.onNext(((Operation) response));
      responseObserver.onCompleted();
    } else if (response instanceof Exception) {
      responseObserver.onError(((Exception) response));
    } else {
      responseObserver.onError(
          new IllegalArgumentException(
              String.format(
                  "Unrecognized response type %s for method UpdateGrpcRoute, expected %s or %s",
                  response == null ? "null" : response.getClass().getName(),
                  Operation.class.getName(),
                  Exception.class.getName())));
    }
  }

  @Override
  public void deleteGrpcRoute(
      DeleteGrpcRouteRequest request, StreamObserver<Operation> responseObserver) {
    Object response = responses.poll();
    if (response instanceof Operation) {
      requests.add(request);
      responseObserver.onNext(((Operation) response));
      responseObserver.onCompleted();
    } else if (response instanceof Exception) {
      responseObserver.onError(((Exception) response));
    } else {
      responseObserver.onError(
          new IllegalArgumentException(
              String.format(
                  "Unrecognized response type %s for method DeleteGrpcRoute, expected %s or %s",
                  response == null ? "null" : response.getClass().getName(),
                  Operation.class.getName(),
                  Exception.class.getName())));
    }
  }

  @Override
  public void listHttpRoutes(
      ListHttpRoutesRequest request, StreamObserver<ListHttpRoutesResponse> responseObserver) {
    Object response = responses.poll();
    if (response instanceof ListHttpRoutesResponse) {
      requests.add(request);
      responseObserver.onNext(((ListHttpRoutesResponse) response));
      responseObserver.onCompleted();
    } else if (response instanceof Exception) {
      responseObserver.onError(((Exception) response));
    } else {
      responseObserver.onError(
          new IllegalArgumentException(
              String.format(
                  "Unrecognized response type %s for method ListHttpRoutes, expected %s or %s",
                  response == null ? "null" : response.getClass().getName(),
                  ListHttpRoutesResponse.class.getName(),
                  Exception.class.getName())));
    }
  }

  @Override
  public void getHttpRoute(
      GetHttpRouteRequest request, StreamObserver<HttpRoute> responseObserver) {
    Object response = responses.poll();
    if (response instanceof HttpRoute) {
      requests.add(request);
      responseObserver.onNext(((HttpRoute) response));
      responseObserver.onCompleted();
    } else if (response instanceof Exception) {
      responseObserver.onError(((Exception) response));
    } else {
      responseObserver.onError(
          new IllegalArgumentException(
              String.format(
                  "Unrecognized response type %s for method GetHttpRoute, expected %s or %s",
                  response == null ? "null" : response.getClass().getName(),
                  HttpRoute.class.getName(),
                  Exception.class.getName())));
    }
  }

  @Override
  public void createHttpRoute(
      CreateHttpRouteRequest request, StreamObserver<Operation> responseObserver) {
    Object response = responses.poll();
    if (response instanceof Operation) {
      requests.add(request);
      responseObserver.onNext(((Operation) response));
      responseObserver.onCompleted();
    } else if (response instanceof Exception) {
      responseObserver.onError(((Exception) response));
    } else {
      responseObserver.onError(
          new IllegalArgumentException(
              String.format(
                  "Unrecognized response type %s for method CreateHttpRoute, expected %s or %s",
                  response == null ? "null" : response.getClass().getName(),
                  Operation.class.getName(),
                  Exception.class.getName())));
    }
  }

  @Override
  public void updateHttpRoute(
      UpdateHttpRouteRequest request, StreamObserver<Operation> responseObserver) {
    Object response = responses.poll();
    if (response instanceof Operation) {
      requests.add(request);
      responseObserver.onNext(((Operation) response));
      responseObserver.onCompleted();
    } else if (response instanceof Exception) {
      responseObserver.onError(((Exception) response));
    } else {
      responseObserver.onError(
          new IllegalArgumentException(
              String.format(
                  "Unrecognized response type %s for method UpdateHttpRoute, expected %s or %s",
                  response == null ? "null" : response.getClass().getName(),
                  Operation.class.getName(),
                  Exception.class.getName())));
    }
  }

  @Override
  public void deleteHttpRoute(
      DeleteHttpRouteRequest request, StreamObserver<Operation> responseObserver) {
    Object response = responses.poll();
    if (response instanceof Operation) {
      requests.add(request);
      responseObserver.onNext(((Operation) response));
      responseObserver.onCompleted();
    } else if (response instanceof Exception) {
      responseObserver.onError(((Exception) response));
    } else {
      responseObserver.onError(
          new IllegalArgumentException(
              String.format(
                  "Unrecognized response type %s for method DeleteHttpRoute, expected %s or %s",
                  response == null ? "null" : response.getClass().getName(),
                  Operation.class.getName(),
                  Exception.class.getName())));
    }
  }

  @Override
  public void listTcpRoutes(
      ListTcpRoutesRequest request, StreamObserver<ListTcpRoutesResponse> responseObserver) {
    Object response = responses.poll();
    if (response instanceof ListTcpRoutesResponse) {
      requests.add(request);
      responseObserver.onNext(((ListTcpRoutesResponse) response));
      responseObserver.onCompleted();
    } else if (response instanceof Exception) {
      responseObserver.onError(((Exception) response));
    } else {
      responseObserver.onError(
          new IllegalArgumentException(
              String.format(
                  "Unrecognized response type %s for method ListTcpRoutes, expected %s or %s",
                  response == null ? "null" : response.getClass().getName(),
                  ListTcpRoutesResponse.class.getName(),
                  Exception.class.getName())));
    }
  }

  @Override
  public void getTcpRoute(GetTcpRouteRequest request, StreamObserver<TcpRoute> responseObserver) {
    Object response = responses.poll();
    if (response instanceof TcpRoute) {
      requests.add(request);
      responseObserver.onNext(((TcpRoute) response));
      responseObserver.onCompleted();
    } else if (response instanceof Exception) {
      responseObserver.onError(((Exception) response));
    } else {
      responseObserver.onError(
          new IllegalArgumentException(
              String.format(
                  "Unrecognized response type %s for method GetTcpRoute, expected %s or %s",
                  response == null ? "null" : response.getClass().getName(),
                  TcpRoute.class.getName(),
                  Exception.class.getName())));
    }
  }

  @Override
  public void createTcpRoute(
      CreateTcpRouteRequest request, StreamObserver<Operation> responseObserver) {
    Object response = responses.poll();
    if (response instanceof Operation) {
      requests.add(request);
      responseObserver.onNext(((Operation) response));
      responseObserver.onCompleted();
    } else if (response instanceof Exception) {
      responseObserver.onError(((Exception) response));
    } else {
      responseObserver.onError(
          new IllegalArgumentException(
              String.format(
                  "Unrecognized response type %s for method CreateTcpRoute, expected %s or %s",
                  response == null ? "null" : response.getClass().getName(),
                  Operation.class.getName(),
                  Exception.class.getName())));
    }
  }

  @Override
  public void updateTcpRoute(
      UpdateTcpRouteRequest request, StreamObserver<Operation> responseObserver) {
    Object response = responses.poll();
    if (response instanceof Operation) {
      requests.add(request);
      responseObserver.onNext(((Operation) response));
      responseObserver.onCompleted();
    } else if (response instanceof Exception) {
      responseObserver.onError(((Exception) response));
    } else {
      responseObserver.onError(
          new IllegalArgumentException(
              String.format(
                  "Unrecognized response type %s for method UpdateTcpRoute, expected %s or %s",
                  response == null ? "null" : response.getClass().getName(),
                  Operation.class.getName(),
                  Exception.class.getName())));
    }
  }

  @Override
  public void deleteTcpRoute(
      DeleteTcpRouteRequest request, StreamObserver<Operation> responseObserver) {
    Object response = responses.poll();
    if (response instanceof Operation) {
      requests.add(request);
      responseObserver.onNext(((Operation) response));
      responseObserver.onCompleted();
    } else if (response instanceof Exception) {
      responseObserver.onError(((Exception) response));
    } else {
      responseObserver.onError(
          new IllegalArgumentException(
              String.format(
                  "Unrecognized response type %s for method DeleteTcpRoute, expected %s or %s",
                  response == null ? "null" : response.getClass().getName(),
                  Operation.class.getName(),
                  Exception.class.getName())));
    }
  }

  @Override
  public void listTlsRoutes(
      ListTlsRoutesRequest request, StreamObserver<ListTlsRoutesResponse> responseObserver) {
    Object response = responses.poll();
    if (response instanceof ListTlsRoutesResponse) {
      requests.add(request);
      responseObserver.onNext(((ListTlsRoutesResponse) response));
      responseObserver.onCompleted();
    } else if (response instanceof Exception) {
      responseObserver.onError(((Exception) response));
    } else {
      responseObserver.onError(
          new IllegalArgumentException(
              String.format(
                  "Unrecognized response type %s for method ListTlsRoutes, expected %s or %s",
                  response == null ? "null" : response.getClass().getName(),
                  ListTlsRoutesResponse.class.getName(),
                  Exception.class.getName())));
    }
  }

  @Override
  public void getTlsRoute(GetTlsRouteRequest request, StreamObserver<TlsRoute> responseObserver) {
    Object response = responses.poll();
    if (response instanceof TlsRoute) {
      requests.add(request);
      responseObserver.onNext(((TlsRoute) response));
      responseObserver.onCompleted();
    } else if (response instanceof Exception) {
      responseObserver.onError(((Exception) response));
    } else {
      responseObserver.onError(
          new IllegalArgumentException(
              String.format(
                  "Unrecognized response type %s for method GetTlsRoute, expected %s or %s",
                  response == null ? "null" : response.getClass().getName(),
                  TlsRoute.class.getName(),
                  Exception.class.getName())));
    }
  }

  @Override
  public void createTlsRoute(
      CreateTlsRouteRequest request, StreamObserver<Operation> responseObserver) {
    Object response = responses.poll();
    if (response instanceof Operation) {
      requests.add(request);
      responseObserver.onNext(((Operation) response));
      responseObserver.onCompleted();
    } else if (response instanceof Exception) {
      responseObserver.onError(((Exception) response));
    } else {
      responseObserver.onError(
          new IllegalArgumentException(
              String.format(
                  "Unrecognized response type %s for method CreateTlsRoute, expected %s or %s",
                  response == null ? "null" : response.getClass().getName(),
                  Operation.class.getName(),
                  Exception.class.getName())));
    }
  }

  @Override
  public void updateTlsRoute(
      UpdateTlsRouteRequest request, StreamObserver<Operation> responseObserver) {
    Object response = responses.poll();
    if (response instanceof Operation) {
      requests.add(request);
      responseObserver.onNext(((Operation) response));
      responseObserver.onCompleted();
    } else if (response instanceof Exception) {
      responseObserver.onError(((Exception) response));
    } else {
      responseObserver.onError(
          new IllegalArgumentException(
              String.format(
                  "Unrecognized response type %s for method UpdateTlsRoute, expected %s or %s",
                  response == null ? "null" : response.getClass().getName(),
                  Operation.class.getName(),
                  Exception.class.getName())));
    }
  }

  @Override
  public void deleteTlsRoute(
      DeleteTlsRouteRequest request, StreamObserver<Operation> responseObserver) {
    Object response = responses.poll();
    if (response instanceof Operation) {
      requests.add(request);
      responseObserver.onNext(((Operation) response));
      responseObserver.onCompleted();
    } else if (response instanceof Exception) {
      responseObserver.onError(((Exception) response));
    } else {
      responseObserver.onError(
          new IllegalArgumentException(
              String.format(
                  "Unrecognized response type %s for method DeleteTlsRoute, expected %s or %s",
                  response == null ? "null" : response.getClass().getName(),
                  Operation.class.getName(),
                  Exception.class.getName())));
    }
  }

  @Override
  public void listServiceBindings(
      ListServiceBindingsRequest request,
      StreamObserver<ListServiceBindingsResponse> responseObserver) {
    Object response = responses.poll();
    if (response instanceof ListServiceBindingsResponse) {
      requests.add(request);
      responseObserver.onNext(((ListServiceBindingsResponse) response));
      responseObserver.onCompleted();
    } else if (response instanceof Exception) {
      responseObserver.onError(((Exception) response));
    } else {
      responseObserver.onError(
          new IllegalArgumentException(
              String.format(
                  "Unrecognized response type %s for method ListServiceBindings, expected %s or %s",
                  response == null ? "null" : response.getClass().getName(),
                  ListServiceBindingsResponse.class.getName(),
                  Exception.class.getName())));
    }
  }

  @Override
  public void getServiceBinding(
      GetServiceBindingRequest request, StreamObserver<ServiceBinding> responseObserver) {
    Object response = responses.poll();
    if (response instanceof ServiceBinding) {
      requests.add(request);
      responseObserver.onNext(((ServiceBinding) response));
      responseObserver.onCompleted();
    } else if (response instanceof Exception) {
      responseObserver.onError(((Exception) response));
    } else {
      responseObserver.onError(
          new IllegalArgumentException(
              String.format(
                  "Unrecognized response type %s for method GetServiceBinding, expected %s or %s",
                  response == null ? "null" : response.getClass().getName(),
                  ServiceBinding.class.getName(),
                  Exception.class.getName())));
    }
  }

  @Override
  public void createServiceBinding(
      CreateServiceBindingRequest request, StreamObserver<Operation> responseObserver) {
    Object response = responses.poll();
    if (response instanceof Operation) {
      requests.add(request);
      responseObserver.onNext(((Operation) response));
      responseObserver.onCompleted();
    } else if (response instanceof Exception) {
      responseObserver.onError(((Exception) response));
    } else {
      responseObserver.onError(
          new IllegalArgumentException(
              String.format(
                  "Unrecognized response type %s for method CreateServiceBinding, expected %s or"
                      + " %s",
                  response == null ? "null" : response.getClass().getName(),
                  Operation.class.getName(),
                  Exception.class.getName())));
    }
  }

  @Override
  public void updateServiceBinding(
      UpdateServiceBindingRequest request, StreamObserver<Operation> responseObserver) {
    Object response = responses.poll();
    if (response instanceof Operation) {
      requests.add(request);
      responseObserver.onNext(((Operation) response));
      responseObserver.onCompleted();
    } else if (response instanceof Exception) {
      responseObserver.onError(((Exception) response));
    } else {
      responseObserver.onError(
          new IllegalArgumentException(
              String.format(
                  "Unrecognized response type %s for method UpdateServiceBinding, expected %s or"
                      + " %s",
                  response == null ? "null" : response.getClass().getName(),
                  Operation.class.getName(),
                  Exception.class.getName())));
    }
  }

  @Override
  public void deleteServiceBinding(
      DeleteServiceBindingRequest request, StreamObserver<Operation> responseObserver) {
    Object response = responses.poll();
    if (response instanceof Operation) {
      requests.add(request);
      responseObserver.onNext(((Operation) response));
      responseObserver.onCompleted();
    } else if (response instanceof Exception) {
      responseObserver.onError(((Exception) response));
    } else {
      responseObserver.onError(
          new IllegalArgumentException(
              String.format(
                  "Unrecognized response type %s for method DeleteServiceBinding, expected %s or"
                      + " %s",
                  response == null ? "null" : response.getClass().getName(),
                  Operation.class.getName(),
                  Exception.class.getName())));
    }
  }

  @Override
  public void listMeshes(
      ListMeshesRequest request, StreamObserver<ListMeshesResponse> responseObserver) {
    Object response = responses.poll();
    if (response instanceof ListMeshesResponse) {
      requests.add(request);
      responseObserver.onNext(((ListMeshesResponse) response));
      responseObserver.onCompleted();
    } else if (response instanceof Exception) {
      responseObserver.onError(((Exception) response));
    } else {
      responseObserver.onError(
          new IllegalArgumentException(
              String.format(
                  "Unrecognized response type %s for method ListMeshes, expected %s or %s",
                  response == null ? "null" : response.getClass().getName(),
                  ListMeshesResponse.class.getName(),
                  Exception.class.getName())));
    }
  }

  @Override
  public void getMesh(GetMeshRequest request, StreamObserver<Mesh> responseObserver) {
    Object response = responses.poll();
    if (response instanceof Mesh) {
      requests.add(request);
      responseObserver.onNext(((Mesh) response));
      responseObserver.onCompleted();
    } else if (response instanceof Exception) {
      responseObserver.onError(((Exception) response));
    } else {
      responseObserver.onError(
          new IllegalArgumentException(
              String.format(
                  "Unrecognized response type %s for method GetMesh, expected %s or %s",
                  response == null ? "null" : response.getClass().getName(),
                  Mesh.class.getName(),
                  Exception.class.getName())));
    }
  }

  @Override
  public void createMesh(CreateMeshRequest request, StreamObserver<Operation> responseObserver) {
    Object response = responses.poll();
    if (response instanceof Operation) {
      requests.add(request);
      responseObserver.onNext(((Operation) response));
      responseObserver.onCompleted();
    } else if (response instanceof Exception) {
      responseObserver.onError(((Exception) response));
    } else {
      responseObserver.onError(
          new IllegalArgumentException(
              String.format(
                  "Unrecognized response type %s for method CreateMesh, expected %s or %s",
                  response == null ? "null" : response.getClass().getName(),
                  Operation.class.getName(),
                  Exception.class.getName())));
    }
  }

  @Override
  public void updateMesh(UpdateMeshRequest request, StreamObserver<Operation> responseObserver) {
    Object response = responses.poll();
    if (response instanceof Operation) {
      requests.add(request);
      responseObserver.onNext(((Operation) response));
      responseObserver.onCompleted();
    } else if (response instanceof Exception) {
      responseObserver.onError(((Exception) response));
    } else {
      responseObserver.onError(
          new IllegalArgumentException(
              String.format(
                  "Unrecognized response type %s for method UpdateMesh, expected %s or %s",
                  response == null ? "null" : response.getClass().getName(),
                  Operation.class.getName(),
                  Exception.class.getName())));
    }
  }

  @Override
  public void deleteMesh(DeleteMeshRequest request, StreamObserver<Operation> responseObserver) {
    Object response = responses.poll();
    if (response instanceof Operation) {
      requests.add(request);
      responseObserver.onNext(((Operation) response));
      responseObserver.onCompleted();
    } else if (response instanceof Exception) {
      responseObserver.onError(((Exception) response));
    } else {
      responseObserver.onError(
          new IllegalArgumentException(
              String.format(
                  "Unrecognized response type %s for method DeleteMesh, expected %s or %s",
                  response == null ? "null" : response.getClass().getName(),
                  Operation.class.getName(),
                  Exception.class.getName())));
    }
  }

  @Override
  public void listServiceLbPolicies(
      ListServiceLbPoliciesRequest request,
      StreamObserver<ListServiceLbPoliciesResponse> responseObserver) {
    Object response = responses.poll();
    if (response instanceof ListServiceLbPoliciesResponse) {
      requests.add(request);
      responseObserver.onNext(((ListServiceLbPoliciesResponse) response));
      responseObserver.onCompleted();
    } else if (response instanceof Exception) {
      responseObserver.onError(((Exception) response));
    } else {
      responseObserver.onError(
          new IllegalArgumentException(
              String.format(
                  "Unrecognized response type %s for method ListServiceLbPolicies, expected %s or"
                      + " %s",
                  response == null ? "null" : response.getClass().getName(),
                  ListServiceLbPoliciesResponse.class.getName(),
                  Exception.class.getName())));
    }
  }

  @Override
  public void getServiceLbPolicy(
      GetServiceLbPolicyRequest request, StreamObserver<ServiceLbPolicy> responseObserver) {
    Object response = responses.poll();
    if (response instanceof ServiceLbPolicy) {
      requests.add(request);
      responseObserver.onNext(((ServiceLbPolicy) response));
      responseObserver.onCompleted();
    } else if (response instanceof Exception) {
      responseObserver.onError(((Exception) response));
    } else {
      responseObserver.onError(
          new IllegalArgumentException(
              String.format(
                  "Unrecognized response type %s for method GetServiceLbPolicy, expected %s or %s",
                  response == null ? "null" : response.getClass().getName(),
                  ServiceLbPolicy.class.getName(),
                  Exception.class.getName())));
    }
  }

  @Override
  public void createServiceLbPolicy(
      CreateServiceLbPolicyRequest request, StreamObserver<Operation> responseObserver) {
    Object response = responses.poll();
    if (response instanceof Operation) {
      requests.add(request);
      responseObserver.onNext(((Operation) response));
      responseObserver.onCompleted();
    } else if (response instanceof Exception) {
      responseObserver.onError(((Exception) response));
    } else {
      responseObserver.onError(
          new IllegalArgumentException(
              String.format(
                  "Unrecognized response type %s for method CreateServiceLbPolicy, expected %s or"
                      + " %s",
                  response == null ? "null" : response.getClass().getName(),
                  Operation.class.getName(),
                  Exception.class.getName())));
    }
  }

  @Override
  public void updateServiceLbPolicy(
      UpdateServiceLbPolicyRequest request, StreamObserver<Operation> responseObserver) {
    Object response = responses.poll();
    if (response instanceof Operation) {
      requests.add(request);
      responseObserver.onNext(((Operation) response));
      responseObserver.onCompleted();
    } else if (response instanceof Exception) {
      responseObserver.onError(((Exception) response));
    } else {
      responseObserver.onError(
          new IllegalArgumentException(
              String.format(
                  "Unrecognized response type %s for method UpdateServiceLbPolicy, expected %s or"
                      + " %s",
                  response == null ? "null" : response.getClass().getName(),
                  Operation.class.getName(),
                  Exception.class.getName())));
    }
  }

  @Override
  public void deleteServiceLbPolicy(
      DeleteServiceLbPolicyRequest request, StreamObserver<Operation> responseObserver) {
    Object response = responses.poll();
    if (response instanceof Operation) {
      requests.add(request);
      responseObserver.onNext(((Operation) response));
      responseObserver.onCompleted();
    } else if (response instanceof Exception) {
      responseObserver.onError(((Exception) response));
    } else {
      responseObserver.onError(
          new IllegalArgumentException(
              String.format(
                  "Unrecognized response type %s for method DeleteServiceLbPolicy, expected %s or"
                      + " %s",
                  response == null ? "null" : response.getClass().getName(),
                  Operation.class.getName(),
                  Exception.class.getName())));
    }
  }

  @Override
  public void getGatewayRouteView(
      GetGatewayRouteViewRequest request, StreamObserver<GatewayRouteView> responseObserver) {
    Object response = responses.poll();
    if (response instanceof GatewayRouteView) {
      requests.add(request);
      responseObserver.onNext(((GatewayRouteView) response));
      responseObserver.onCompleted();
    } else if (response instanceof Exception) {
      responseObserver.onError(((Exception) response));
    } else {
      responseObserver.onError(
          new IllegalArgumentException(
              String.format(
                  "Unrecognized response type %s for method GetGatewayRouteView, expected %s or %s",
                  response == null ? "null" : response.getClass().getName(),
                  GatewayRouteView.class.getName(),
                  Exception.class.getName())));
    }
  }

  @Override
  public void getMeshRouteView(
      GetMeshRouteViewRequest request, StreamObserver<MeshRouteView> responseObserver) {
    Object response = responses.poll();
    if (response instanceof MeshRouteView) {
      requests.add(request);
      responseObserver.onNext(((MeshRouteView) response));
      responseObserver.onCompleted();
    } else if (response instanceof Exception) {
      responseObserver.onError(((Exception) response));
    } else {
      responseObserver.onError(
          new IllegalArgumentException(
              String.format(
                  "Unrecognized response type %s for method GetMeshRouteView, expected %s or %s",
                  response == null ? "null" : response.getClass().getName(),
                  MeshRouteView.class.getName(),
                  Exception.class.getName())));
    }
  }

  @Override
  public void listGatewayRouteViews(
      ListGatewayRouteViewsRequest request,
      StreamObserver<ListGatewayRouteViewsResponse> responseObserver) {
    Object response = responses.poll();
    if (response instanceof ListGatewayRouteViewsResponse) {
      requests.add(request);
      responseObserver.onNext(((ListGatewayRouteViewsResponse) response));
      responseObserver.onCompleted();
    } else if (response instanceof Exception) {
      responseObserver.onError(((Exception) response));
    } else {
      responseObserver.onError(
          new IllegalArgumentException(
              String.format(
                  "Unrecognized response type %s for method ListGatewayRouteViews, expected %s or"
                      + " %s",
                  response == null ? "null" : response.getClass().getName(),
                  ListGatewayRouteViewsResponse.class.getName(),
                  Exception.class.getName())));
    }
  }

  @Override
  public void listMeshRouteViews(
      ListMeshRouteViewsRequest request,
      StreamObserver<ListMeshRouteViewsResponse> responseObserver) {
    Object response = responses.poll();
    if (response instanceof ListMeshRouteViewsResponse) {
      requests.add(request);
      responseObserver.onNext(((ListMeshRouteViewsResponse) response));
      responseObserver.onCompleted();
    } else if (response instanceof Exception) {
      responseObserver.onError(((Exception) response));
    } else {
      responseObserver.onError(
          new IllegalArgumentException(
              String.format(
                  "Unrecognized response type %s for method ListMeshRouteViews, expected %s or %s",
                  response == null ? "null" : response.getClass().getName(),
                  ListMeshRouteViewsResponse.class.getName(),
                  Exception.class.getName())));
    }
  }
}
