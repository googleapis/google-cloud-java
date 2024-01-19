/*
 * Copyright 2023 Google LLC
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

package com.google.cloud.vmwareengine.v1;

import com.google.api.core.BetaApi;
import com.google.cloud.vmwareengine.v1.VmwareEngineGrpc.VmwareEngineImplBase;
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
public class MockVmwareEngineImpl extends VmwareEngineImplBase {
  private List<AbstractMessage> requests;
  private Queue<Object> responses;

  public MockVmwareEngineImpl() {
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
  public void listPrivateClouds(
      ListPrivateCloudsRequest request,
      StreamObserver<ListPrivateCloudsResponse> responseObserver) {
    Object response = responses.poll();
    if (response instanceof ListPrivateCloudsResponse) {
      requests.add(request);
      responseObserver.onNext(((ListPrivateCloudsResponse) response));
      responseObserver.onCompleted();
    } else if (response instanceof Exception) {
      responseObserver.onError(((Exception) response));
    } else {
      responseObserver.onError(
          new IllegalArgumentException(
              String.format(
                  "Unrecognized response type %s for method ListPrivateClouds, expected %s or %s",
                  response == null ? "null" : response.getClass().getName(),
                  ListPrivateCloudsResponse.class.getName(),
                  Exception.class.getName())));
    }
  }

  @Override
  public void getPrivateCloud(
      GetPrivateCloudRequest request, StreamObserver<PrivateCloud> responseObserver) {
    Object response = responses.poll();
    if (response instanceof PrivateCloud) {
      requests.add(request);
      responseObserver.onNext(((PrivateCloud) response));
      responseObserver.onCompleted();
    } else if (response instanceof Exception) {
      responseObserver.onError(((Exception) response));
    } else {
      responseObserver.onError(
          new IllegalArgumentException(
              String.format(
                  "Unrecognized response type %s for method GetPrivateCloud, expected %s or %s",
                  response == null ? "null" : response.getClass().getName(),
                  PrivateCloud.class.getName(),
                  Exception.class.getName())));
    }
  }

  @Override
  public void createPrivateCloud(
      CreatePrivateCloudRequest request, StreamObserver<Operation> responseObserver) {
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
                  "Unrecognized response type %s for method CreatePrivateCloud, expected %s or %s",
                  response == null ? "null" : response.getClass().getName(),
                  Operation.class.getName(),
                  Exception.class.getName())));
    }
  }

  @Override
  public void updatePrivateCloud(
      UpdatePrivateCloudRequest request, StreamObserver<Operation> responseObserver) {
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
                  "Unrecognized response type %s for method UpdatePrivateCloud, expected %s or %s",
                  response == null ? "null" : response.getClass().getName(),
                  Operation.class.getName(),
                  Exception.class.getName())));
    }
  }

  @Override
  public void deletePrivateCloud(
      DeletePrivateCloudRequest request, StreamObserver<Operation> responseObserver) {
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
                  "Unrecognized response type %s for method DeletePrivateCloud, expected %s or %s",
                  response == null ? "null" : response.getClass().getName(),
                  Operation.class.getName(),
                  Exception.class.getName())));
    }
  }

  @Override
  public void undeletePrivateCloud(
      UndeletePrivateCloudRequest request, StreamObserver<Operation> responseObserver) {
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
                  "Unrecognized response type %s for method UndeletePrivateCloud, expected %s or %s",
                  response == null ? "null" : response.getClass().getName(),
                  Operation.class.getName(),
                  Exception.class.getName())));
    }
  }

  @Override
  public void listClusters(
      ListClustersRequest request, StreamObserver<ListClustersResponse> responseObserver) {
    Object response = responses.poll();
    if (response instanceof ListClustersResponse) {
      requests.add(request);
      responseObserver.onNext(((ListClustersResponse) response));
      responseObserver.onCompleted();
    } else if (response instanceof Exception) {
      responseObserver.onError(((Exception) response));
    } else {
      responseObserver.onError(
          new IllegalArgumentException(
              String.format(
                  "Unrecognized response type %s for method ListClusters, expected %s or %s",
                  response == null ? "null" : response.getClass().getName(),
                  ListClustersResponse.class.getName(),
                  Exception.class.getName())));
    }
  }

  @Override
  public void getCluster(GetClusterRequest request, StreamObserver<Cluster> responseObserver) {
    Object response = responses.poll();
    if (response instanceof Cluster) {
      requests.add(request);
      responseObserver.onNext(((Cluster) response));
      responseObserver.onCompleted();
    } else if (response instanceof Exception) {
      responseObserver.onError(((Exception) response));
    } else {
      responseObserver.onError(
          new IllegalArgumentException(
              String.format(
                  "Unrecognized response type %s for method GetCluster, expected %s or %s",
                  response == null ? "null" : response.getClass().getName(),
                  Cluster.class.getName(),
                  Exception.class.getName())));
    }
  }

  @Override
  public void createCluster(
      CreateClusterRequest request, StreamObserver<Operation> responseObserver) {
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
                  "Unrecognized response type %s for method CreateCluster, expected %s or %s",
                  response == null ? "null" : response.getClass().getName(),
                  Operation.class.getName(),
                  Exception.class.getName())));
    }
  }

  @Override
  public void updateCluster(
      UpdateClusterRequest request, StreamObserver<Operation> responseObserver) {
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
                  "Unrecognized response type %s for method UpdateCluster, expected %s or %s",
                  response == null ? "null" : response.getClass().getName(),
                  Operation.class.getName(),
                  Exception.class.getName())));
    }
  }

  @Override
  public void deleteCluster(
      DeleteClusterRequest request, StreamObserver<Operation> responseObserver) {
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
                  "Unrecognized response type %s for method DeleteCluster, expected %s or %s",
                  response == null ? "null" : response.getClass().getName(),
                  Operation.class.getName(),
                  Exception.class.getName())));
    }
  }

  @Override
  public void listNodes(
      ListNodesRequest request, StreamObserver<ListNodesResponse> responseObserver) {
    Object response = responses.poll();
    if (response instanceof ListNodesResponse) {
      requests.add(request);
      responseObserver.onNext(((ListNodesResponse) response));
      responseObserver.onCompleted();
    } else if (response instanceof Exception) {
      responseObserver.onError(((Exception) response));
    } else {
      responseObserver.onError(
          new IllegalArgumentException(
              String.format(
                  "Unrecognized response type %s for method ListNodes, expected %s or %s",
                  response == null ? "null" : response.getClass().getName(),
                  ListNodesResponse.class.getName(),
                  Exception.class.getName())));
    }
  }

  @Override
  public void getNode(GetNodeRequest request, StreamObserver<Node> responseObserver) {
    Object response = responses.poll();
    if (response instanceof Node) {
      requests.add(request);
      responseObserver.onNext(((Node) response));
      responseObserver.onCompleted();
    } else if (response instanceof Exception) {
      responseObserver.onError(((Exception) response));
    } else {
      responseObserver.onError(
          new IllegalArgumentException(
              String.format(
                  "Unrecognized response type %s for method GetNode, expected %s or %s",
                  response == null ? "null" : response.getClass().getName(),
                  Node.class.getName(),
                  Exception.class.getName())));
    }
  }

  @Override
  public void listExternalAddresses(
      ListExternalAddressesRequest request,
      StreamObserver<ListExternalAddressesResponse> responseObserver) {
    Object response = responses.poll();
    if (response instanceof ListExternalAddressesResponse) {
      requests.add(request);
      responseObserver.onNext(((ListExternalAddressesResponse) response));
      responseObserver.onCompleted();
    } else if (response instanceof Exception) {
      responseObserver.onError(((Exception) response));
    } else {
      responseObserver.onError(
          new IllegalArgumentException(
              String.format(
                  "Unrecognized response type %s for method ListExternalAddresses, expected %s or %s",
                  response == null ? "null" : response.getClass().getName(),
                  ListExternalAddressesResponse.class.getName(),
                  Exception.class.getName())));
    }
  }

  @Override
  public void fetchNetworkPolicyExternalAddresses(
      FetchNetworkPolicyExternalAddressesRequest request,
      StreamObserver<FetchNetworkPolicyExternalAddressesResponse> responseObserver) {
    Object response = responses.poll();
    if (response instanceof FetchNetworkPolicyExternalAddressesResponse) {
      requests.add(request);
      responseObserver.onNext(((FetchNetworkPolicyExternalAddressesResponse) response));
      responseObserver.onCompleted();
    } else if (response instanceof Exception) {
      responseObserver.onError(((Exception) response));
    } else {
      responseObserver.onError(
          new IllegalArgumentException(
              String.format(
                  "Unrecognized response type %s for method FetchNetworkPolicyExternalAddresses, expected %s or %s",
                  response == null ? "null" : response.getClass().getName(),
                  FetchNetworkPolicyExternalAddressesResponse.class.getName(),
                  Exception.class.getName())));
    }
  }

  @Override
  public void getExternalAddress(
      GetExternalAddressRequest request, StreamObserver<ExternalAddress> responseObserver) {
    Object response = responses.poll();
    if (response instanceof ExternalAddress) {
      requests.add(request);
      responseObserver.onNext(((ExternalAddress) response));
      responseObserver.onCompleted();
    } else if (response instanceof Exception) {
      responseObserver.onError(((Exception) response));
    } else {
      responseObserver.onError(
          new IllegalArgumentException(
              String.format(
                  "Unrecognized response type %s for method GetExternalAddress, expected %s or %s",
                  response == null ? "null" : response.getClass().getName(),
                  ExternalAddress.class.getName(),
                  Exception.class.getName())));
    }
  }

  @Override
  public void createExternalAddress(
      CreateExternalAddressRequest request, StreamObserver<Operation> responseObserver) {
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
                  "Unrecognized response type %s for method CreateExternalAddress, expected %s or %s",
                  response == null ? "null" : response.getClass().getName(),
                  Operation.class.getName(),
                  Exception.class.getName())));
    }
  }

  @Override
  public void updateExternalAddress(
      UpdateExternalAddressRequest request, StreamObserver<Operation> responseObserver) {
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
                  "Unrecognized response type %s for method UpdateExternalAddress, expected %s or %s",
                  response == null ? "null" : response.getClass().getName(),
                  Operation.class.getName(),
                  Exception.class.getName())));
    }
  }

  @Override
  public void deleteExternalAddress(
      DeleteExternalAddressRequest request, StreamObserver<Operation> responseObserver) {
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
                  "Unrecognized response type %s for method DeleteExternalAddress, expected %s or %s",
                  response == null ? "null" : response.getClass().getName(),
                  Operation.class.getName(),
                  Exception.class.getName())));
    }
  }

  @Override
  public void listSubnets(
      ListSubnetsRequest request, StreamObserver<ListSubnetsResponse> responseObserver) {
    Object response = responses.poll();
    if (response instanceof ListSubnetsResponse) {
      requests.add(request);
      responseObserver.onNext(((ListSubnetsResponse) response));
      responseObserver.onCompleted();
    } else if (response instanceof Exception) {
      responseObserver.onError(((Exception) response));
    } else {
      responseObserver.onError(
          new IllegalArgumentException(
              String.format(
                  "Unrecognized response type %s for method ListSubnets, expected %s or %s",
                  response == null ? "null" : response.getClass().getName(),
                  ListSubnetsResponse.class.getName(),
                  Exception.class.getName())));
    }
  }

  @Override
  public void getSubnet(GetSubnetRequest request, StreamObserver<Subnet> responseObserver) {
    Object response = responses.poll();
    if (response instanceof Subnet) {
      requests.add(request);
      responseObserver.onNext(((Subnet) response));
      responseObserver.onCompleted();
    } else if (response instanceof Exception) {
      responseObserver.onError(((Exception) response));
    } else {
      responseObserver.onError(
          new IllegalArgumentException(
              String.format(
                  "Unrecognized response type %s for method GetSubnet, expected %s or %s",
                  response == null ? "null" : response.getClass().getName(),
                  Subnet.class.getName(),
                  Exception.class.getName())));
    }
  }

  @Override
  public void updateSubnet(
      UpdateSubnetRequest request, StreamObserver<Operation> responseObserver) {
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
                  "Unrecognized response type %s for method UpdateSubnet, expected %s or %s",
                  response == null ? "null" : response.getClass().getName(),
                  Operation.class.getName(),
                  Exception.class.getName())));
    }
  }

  @Override
  public void listExternalAccessRules(
      ListExternalAccessRulesRequest request,
      StreamObserver<ListExternalAccessRulesResponse> responseObserver) {
    Object response = responses.poll();
    if (response instanceof ListExternalAccessRulesResponse) {
      requests.add(request);
      responseObserver.onNext(((ListExternalAccessRulesResponse) response));
      responseObserver.onCompleted();
    } else if (response instanceof Exception) {
      responseObserver.onError(((Exception) response));
    } else {
      responseObserver.onError(
          new IllegalArgumentException(
              String.format(
                  "Unrecognized response type %s for method ListExternalAccessRules, expected %s or %s",
                  response == null ? "null" : response.getClass().getName(),
                  ListExternalAccessRulesResponse.class.getName(),
                  Exception.class.getName())));
    }
  }

  @Override
  public void getExternalAccessRule(
      GetExternalAccessRuleRequest request, StreamObserver<ExternalAccessRule> responseObserver) {
    Object response = responses.poll();
    if (response instanceof ExternalAccessRule) {
      requests.add(request);
      responseObserver.onNext(((ExternalAccessRule) response));
      responseObserver.onCompleted();
    } else if (response instanceof Exception) {
      responseObserver.onError(((Exception) response));
    } else {
      responseObserver.onError(
          new IllegalArgumentException(
              String.format(
                  "Unrecognized response type %s for method GetExternalAccessRule, expected %s or %s",
                  response == null ? "null" : response.getClass().getName(),
                  ExternalAccessRule.class.getName(),
                  Exception.class.getName())));
    }
  }

  @Override
  public void createExternalAccessRule(
      CreateExternalAccessRuleRequest request, StreamObserver<Operation> responseObserver) {
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
                  "Unrecognized response type %s for method CreateExternalAccessRule, expected %s or %s",
                  response == null ? "null" : response.getClass().getName(),
                  Operation.class.getName(),
                  Exception.class.getName())));
    }
  }

  @Override
  public void updateExternalAccessRule(
      UpdateExternalAccessRuleRequest request, StreamObserver<Operation> responseObserver) {
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
                  "Unrecognized response type %s for method UpdateExternalAccessRule, expected %s or %s",
                  response == null ? "null" : response.getClass().getName(),
                  Operation.class.getName(),
                  Exception.class.getName())));
    }
  }

  @Override
  public void deleteExternalAccessRule(
      DeleteExternalAccessRuleRequest request, StreamObserver<Operation> responseObserver) {
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
                  "Unrecognized response type %s for method DeleteExternalAccessRule, expected %s or %s",
                  response == null ? "null" : response.getClass().getName(),
                  Operation.class.getName(),
                  Exception.class.getName())));
    }
  }

  @Override
  public void listLoggingServers(
      ListLoggingServersRequest request,
      StreamObserver<ListLoggingServersResponse> responseObserver) {
    Object response = responses.poll();
    if (response instanceof ListLoggingServersResponse) {
      requests.add(request);
      responseObserver.onNext(((ListLoggingServersResponse) response));
      responseObserver.onCompleted();
    } else if (response instanceof Exception) {
      responseObserver.onError(((Exception) response));
    } else {
      responseObserver.onError(
          new IllegalArgumentException(
              String.format(
                  "Unrecognized response type %s for method ListLoggingServers, expected %s or %s",
                  response == null ? "null" : response.getClass().getName(),
                  ListLoggingServersResponse.class.getName(),
                  Exception.class.getName())));
    }
  }

  @Override
  public void getLoggingServer(
      GetLoggingServerRequest request, StreamObserver<LoggingServer> responseObserver) {
    Object response = responses.poll();
    if (response instanceof LoggingServer) {
      requests.add(request);
      responseObserver.onNext(((LoggingServer) response));
      responseObserver.onCompleted();
    } else if (response instanceof Exception) {
      responseObserver.onError(((Exception) response));
    } else {
      responseObserver.onError(
          new IllegalArgumentException(
              String.format(
                  "Unrecognized response type %s for method GetLoggingServer, expected %s or %s",
                  response == null ? "null" : response.getClass().getName(),
                  LoggingServer.class.getName(),
                  Exception.class.getName())));
    }
  }

  @Override
  public void createLoggingServer(
      CreateLoggingServerRequest request, StreamObserver<Operation> responseObserver) {
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
                  "Unrecognized response type %s for method CreateLoggingServer, expected %s or %s",
                  response == null ? "null" : response.getClass().getName(),
                  Operation.class.getName(),
                  Exception.class.getName())));
    }
  }

  @Override
  public void updateLoggingServer(
      UpdateLoggingServerRequest request, StreamObserver<Operation> responseObserver) {
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
                  "Unrecognized response type %s for method UpdateLoggingServer, expected %s or %s",
                  response == null ? "null" : response.getClass().getName(),
                  Operation.class.getName(),
                  Exception.class.getName())));
    }
  }

  @Override
  public void deleteLoggingServer(
      DeleteLoggingServerRequest request, StreamObserver<Operation> responseObserver) {
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
                  "Unrecognized response type %s for method DeleteLoggingServer, expected %s or %s",
                  response == null ? "null" : response.getClass().getName(),
                  Operation.class.getName(),
                  Exception.class.getName())));
    }
  }

  @Override
  public void listNodeTypes(
      ListNodeTypesRequest request, StreamObserver<ListNodeTypesResponse> responseObserver) {
    Object response = responses.poll();
    if (response instanceof ListNodeTypesResponse) {
      requests.add(request);
      responseObserver.onNext(((ListNodeTypesResponse) response));
      responseObserver.onCompleted();
    } else if (response instanceof Exception) {
      responseObserver.onError(((Exception) response));
    } else {
      responseObserver.onError(
          new IllegalArgumentException(
              String.format(
                  "Unrecognized response type %s for method ListNodeTypes, expected %s or %s",
                  response == null ? "null" : response.getClass().getName(),
                  ListNodeTypesResponse.class.getName(),
                  Exception.class.getName())));
    }
  }

  @Override
  public void getNodeType(GetNodeTypeRequest request, StreamObserver<NodeType> responseObserver) {
    Object response = responses.poll();
    if (response instanceof NodeType) {
      requests.add(request);
      responseObserver.onNext(((NodeType) response));
      responseObserver.onCompleted();
    } else if (response instanceof Exception) {
      responseObserver.onError(((Exception) response));
    } else {
      responseObserver.onError(
          new IllegalArgumentException(
              String.format(
                  "Unrecognized response type %s for method GetNodeType, expected %s or %s",
                  response == null ? "null" : response.getClass().getName(),
                  NodeType.class.getName(),
                  Exception.class.getName())));
    }
  }

  @Override
  public void showNsxCredentials(
      ShowNsxCredentialsRequest request, StreamObserver<Credentials> responseObserver) {
    Object response = responses.poll();
    if (response instanceof Credentials) {
      requests.add(request);
      responseObserver.onNext(((Credentials) response));
      responseObserver.onCompleted();
    } else if (response instanceof Exception) {
      responseObserver.onError(((Exception) response));
    } else {
      responseObserver.onError(
          new IllegalArgumentException(
              String.format(
                  "Unrecognized response type %s for method ShowNsxCredentials, expected %s or %s",
                  response == null ? "null" : response.getClass().getName(),
                  Credentials.class.getName(),
                  Exception.class.getName())));
    }
  }

  @Override
  public void showVcenterCredentials(
      ShowVcenterCredentialsRequest request, StreamObserver<Credentials> responseObserver) {
    Object response = responses.poll();
    if (response instanceof Credentials) {
      requests.add(request);
      responseObserver.onNext(((Credentials) response));
      responseObserver.onCompleted();
    } else if (response instanceof Exception) {
      responseObserver.onError(((Exception) response));
    } else {
      responseObserver.onError(
          new IllegalArgumentException(
              String.format(
                  "Unrecognized response type %s for method ShowVcenterCredentials, expected %s or %s",
                  response == null ? "null" : response.getClass().getName(),
                  Credentials.class.getName(),
                  Exception.class.getName())));
    }
  }

  @Override
  public void resetNsxCredentials(
      ResetNsxCredentialsRequest request, StreamObserver<Operation> responseObserver) {
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
                  "Unrecognized response type %s for method ResetNsxCredentials, expected %s or %s",
                  response == null ? "null" : response.getClass().getName(),
                  Operation.class.getName(),
                  Exception.class.getName())));
    }
  }

  @Override
  public void resetVcenterCredentials(
      ResetVcenterCredentialsRequest request, StreamObserver<Operation> responseObserver) {
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
                  "Unrecognized response type %s for method ResetVcenterCredentials, expected %s or %s",
                  response == null ? "null" : response.getClass().getName(),
                  Operation.class.getName(),
                  Exception.class.getName())));
    }
  }

  @Override
  public void getDnsForwarding(
      GetDnsForwardingRequest request, StreamObserver<DnsForwarding> responseObserver) {
    Object response = responses.poll();
    if (response instanceof DnsForwarding) {
      requests.add(request);
      responseObserver.onNext(((DnsForwarding) response));
      responseObserver.onCompleted();
    } else if (response instanceof Exception) {
      responseObserver.onError(((Exception) response));
    } else {
      responseObserver.onError(
          new IllegalArgumentException(
              String.format(
                  "Unrecognized response type %s for method GetDnsForwarding, expected %s or %s",
                  response == null ? "null" : response.getClass().getName(),
                  DnsForwarding.class.getName(),
                  Exception.class.getName())));
    }
  }

  @Override
  public void updateDnsForwarding(
      UpdateDnsForwardingRequest request, StreamObserver<Operation> responseObserver) {
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
                  "Unrecognized response type %s for method UpdateDnsForwarding, expected %s or %s",
                  response == null ? "null" : response.getClass().getName(),
                  Operation.class.getName(),
                  Exception.class.getName())));
    }
  }

  @Override
  public void getNetworkPeering(
      GetNetworkPeeringRequest request, StreamObserver<NetworkPeering> responseObserver) {
    Object response = responses.poll();
    if (response instanceof NetworkPeering) {
      requests.add(request);
      responseObserver.onNext(((NetworkPeering) response));
      responseObserver.onCompleted();
    } else if (response instanceof Exception) {
      responseObserver.onError(((Exception) response));
    } else {
      responseObserver.onError(
          new IllegalArgumentException(
              String.format(
                  "Unrecognized response type %s for method GetNetworkPeering, expected %s or %s",
                  response == null ? "null" : response.getClass().getName(),
                  NetworkPeering.class.getName(),
                  Exception.class.getName())));
    }
  }

  @Override
  public void listNetworkPeerings(
      ListNetworkPeeringsRequest request,
      StreamObserver<ListNetworkPeeringsResponse> responseObserver) {
    Object response = responses.poll();
    if (response instanceof ListNetworkPeeringsResponse) {
      requests.add(request);
      responseObserver.onNext(((ListNetworkPeeringsResponse) response));
      responseObserver.onCompleted();
    } else if (response instanceof Exception) {
      responseObserver.onError(((Exception) response));
    } else {
      responseObserver.onError(
          new IllegalArgumentException(
              String.format(
                  "Unrecognized response type %s for method ListNetworkPeerings, expected %s or %s",
                  response == null ? "null" : response.getClass().getName(),
                  ListNetworkPeeringsResponse.class.getName(),
                  Exception.class.getName())));
    }
  }

  @Override
  public void createNetworkPeering(
      CreateNetworkPeeringRequest request, StreamObserver<Operation> responseObserver) {
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
                  "Unrecognized response type %s for method CreateNetworkPeering, expected %s or %s",
                  response == null ? "null" : response.getClass().getName(),
                  Operation.class.getName(),
                  Exception.class.getName())));
    }
  }

  @Override
  public void deleteNetworkPeering(
      DeleteNetworkPeeringRequest request, StreamObserver<Operation> responseObserver) {
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
                  "Unrecognized response type %s for method DeleteNetworkPeering, expected %s or %s",
                  response == null ? "null" : response.getClass().getName(),
                  Operation.class.getName(),
                  Exception.class.getName())));
    }
  }

  @Override
  public void updateNetworkPeering(
      UpdateNetworkPeeringRequest request, StreamObserver<Operation> responseObserver) {
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
                  "Unrecognized response type %s for method UpdateNetworkPeering, expected %s or %s",
                  response == null ? "null" : response.getClass().getName(),
                  Operation.class.getName(),
                  Exception.class.getName())));
    }
  }

  @Override
  public void listPeeringRoutes(
      ListPeeringRoutesRequest request,
      StreamObserver<ListPeeringRoutesResponse> responseObserver) {
    Object response = responses.poll();
    if (response instanceof ListPeeringRoutesResponse) {
      requests.add(request);
      responseObserver.onNext(((ListPeeringRoutesResponse) response));
      responseObserver.onCompleted();
    } else if (response instanceof Exception) {
      responseObserver.onError(((Exception) response));
    } else {
      responseObserver.onError(
          new IllegalArgumentException(
              String.format(
                  "Unrecognized response type %s for method ListPeeringRoutes, expected %s or %s",
                  response == null ? "null" : response.getClass().getName(),
                  ListPeeringRoutesResponse.class.getName(),
                  Exception.class.getName())));
    }
  }

  @Override
  public void createHcxActivationKey(
      CreateHcxActivationKeyRequest request, StreamObserver<Operation> responseObserver) {
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
                  "Unrecognized response type %s for method CreateHcxActivationKey, expected %s or %s",
                  response == null ? "null" : response.getClass().getName(),
                  Operation.class.getName(),
                  Exception.class.getName())));
    }
  }

  @Override
  public void listHcxActivationKeys(
      ListHcxActivationKeysRequest request,
      StreamObserver<ListHcxActivationKeysResponse> responseObserver) {
    Object response = responses.poll();
    if (response instanceof ListHcxActivationKeysResponse) {
      requests.add(request);
      responseObserver.onNext(((ListHcxActivationKeysResponse) response));
      responseObserver.onCompleted();
    } else if (response instanceof Exception) {
      responseObserver.onError(((Exception) response));
    } else {
      responseObserver.onError(
          new IllegalArgumentException(
              String.format(
                  "Unrecognized response type %s for method ListHcxActivationKeys, expected %s or %s",
                  response == null ? "null" : response.getClass().getName(),
                  ListHcxActivationKeysResponse.class.getName(),
                  Exception.class.getName())));
    }
  }

  @Override
  public void getHcxActivationKey(
      GetHcxActivationKeyRequest request, StreamObserver<HcxActivationKey> responseObserver) {
    Object response = responses.poll();
    if (response instanceof HcxActivationKey) {
      requests.add(request);
      responseObserver.onNext(((HcxActivationKey) response));
      responseObserver.onCompleted();
    } else if (response instanceof Exception) {
      responseObserver.onError(((Exception) response));
    } else {
      responseObserver.onError(
          new IllegalArgumentException(
              String.format(
                  "Unrecognized response type %s for method GetHcxActivationKey, expected %s or %s",
                  response == null ? "null" : response.getClass().getName(),
                  HcxActivationKey.class.getName(),
                  Exception.class.getName())));
    }
  }

  @Override
  public void getNetworkPolicy(
      GetNetworkPolicyRequest request, StreamObserver<NetworkPolicy> responseObserver) {
    Object response = responses.poll();
    if (response instanceof NetworkPolicy) {
      requests.add(request);
      responseObserver.onNext(((NetworkPolicy) response));
      responseObserver.onCompleted();
    } else if (response instanceof Exception) {
      responseObserver.onError(((Exception) response));
    } else {
      responseObserver.onError(
          new IllegalArgumentException(
              String.format(
                  "Unrecognized response type %s for method GetNetworkPolicy, expected %s or %s",
                  response == null ? "null" : response.getClass().getName(),
                  NetworkPolicy.class.getName(),
                  Exception.class.getName())));
    }
  }

  @Override
  public void listNetworkPolicies(
      ListNetworkPoliciesRequest request,
      StreamObserver<ListNetworkPoliciesResponse> responseObserver) {
    Object response = responses.poll();
    if (response instanceof ListNetworkPoliciesResponse) {
      requests.add(request);
      responseObserver.onNext(((ListNetworkPoliciesResponse) response));
      responseObserver.onCompleted();
    } else if (response instanceof Exception) {
      responseObserver.onError(((Exception) response));
    } else {
      responseObserver.onError(
          new IllegalArgumentException(
              String.format(
                  "Unrecognized response type %s for method ListNetworkPolicies, expected %s or %s",
                  response == null ? "null" : response.getClass().getName(),
                  ListNetworkPoliciesResponse.class.getName(),
                  Exception.class.getName())));
    }
  }

  @Override
  public void createNetworkPolicy(
      CreateNetworkPolicyRequest request, StreamObserver<Operation> responseObserver) {
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
                  "Unrecognized response type %s for method CreateNetworkPolicy, expected %s or %s",
                  response == null ? "null" : response.getClass().getName(),
                  Operation.class.getName(),
                  Exception.class.getName())));
    }
  }

  @Override
  public void updateNetworkPolicy(
      UpdateNetworkPolicyRequest request, StreamObserver<Operation> responseObserver) {
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
                  "Unrecognized response type %s for method UpdateNetworkPolicy, expected %s or %s",
                  response == null ? "null" : response.getClass().getName(),
                  Operation.class.getName(),
                  Exception.class.getName())));
    }
  }

  @Override
  public void deleteNetworkPolicy(
      DeleteNetworkPolicyRequest request, StreamObserver<Operation> responseObserver) {
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
                  "Unrecognized response type %s for method DeleteNetworkPolicy, expected %s or %s",
                  response == null ? "null" : response.getClass().getName(),
                  Operation.class.getName(),
                  Exception.class.getName())));
    }
  }

  @Override
  public void listManagementDnsZoneBindings(
      ListManagementDnsZoneBindingsRequest request,
      StreamObserver<ListManagementDnsZoneBindingsResponse> responseObserver) {
    Object response = responses.poll();
    if (response instanceof ListManagementDnsZoneBindingsResponse) {
      requests.add(request);
      responseObserver.onNext(((ListManagementDnsZoneBindingsResponse) response));
      responseObserver.onCompleted();
    } else if (response instanceof Exception) {
      responseObserver.onError(((Exception) response));
    } else {
      responseObserver.onError(
          new IllegalArgumentException(
              String.format(
                  "Unrecognized response type %s for method ListManagementDnsZoneBindings, expected %s or %s",
                  response == null ? "null" : response.getClass().getName(),
                  ListManagementDnsZoneBindingsResponse.class.getName(),
                  Exception.class.getName())));
    }
  }

  @Override
  public void getManagementDnsZoneBinding(
      GetManagementDnsZoneBindingRequest request,
      StreamObserver<ManagementDnsZoneBinding> responseObserver) {
    Object response = responses.poll();
    if (response instanceof ManagementDnsZoneBinding) {
      requests.add(request);
      responseObserver.onNext(((ManagementDnsZoneBinding) response));
      responseObserver.onCompleted();
    } else if (response instanceof Exception) {
      responseObserver.onError(((Exception) response));
    } else {
      responseObserver.onError(
          new IllegalArgumentException(
              String.format(
                  "Unrecognized response type %s for method GetManagementDnsZoneBinding, expected %s or %s",
                  response == null ? "null" : response.getClass().getName(),
                  ManagementDnsZoneBinding.class.getName(),
                  Exception.class.getName())));
    }
  }

  @Override
  public void createManagementDnsZoneBinding(
      CreateManagementDnsZoneBindingRequest request, StreamObserver<Operation> responseObserver) {
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
                  "Unrecognized response type %s for method CreateManagementDnsZoneBinding, expected %s or %s",
                  response == null ? "null" : response.getClass().getName(),
                  Operation.class.getName(),
                  Exception.class.getName())));
    }
  }

  @Override
  public void updateManagementDnsZoneBinding(
      UpdateManagementDnsZoneBindingRequest request, StreamObserver<Operation> responseObserver) {
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
                  "Unrecognized response type %s for method UpdateManagementDnsZoneBinding, expected %s or %s",
                  response == null ? "null" : response.getClass().getName(),
                  Operation.class.getName(),
                  Exception.class.getName())));
    }
  }

  @Override
  public void deleteManagementDnsZoneBinding(
      DeleteManagementDnsZoneBindingRequest request, StreamObserver<Operation> responseObserver) {
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
                  "Unrecognized response type %s for method DeleteManagementDnsZoneBinding, expected %s or %s",
                  response == null ? "null" : response.getClass().getName(),
                  Operation.class.getName(),
                  Exception.class.getName())));
    }
  }

  @Override
  public void repairManagementDnsZoneBinding(
      RepairManagementDnsZoneBindingRequest request, StreamObserver<Operation> responseObserver) {
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
                  "Unrecognized response type %s for method RepairManagementDnsZoneBinding, expected %s or %s",
                  response == null ? "null" : response.getClass().getName(),
                  Operation.class.getName(),
                  Exception.class.getName())));
    }
  }

  @Override
  public void createVmwareEngineNetwork(
      CreateVmwareEngineNetworkRequest request, StreamObserver<Operation> responseObserver) {
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
                  "Unrecognized response type %s for method CreateVmwareEngineNetwork, expected %s or %s",
                  response == null ? "null" : response.getClass().getName(),
                  Operation.class.getName(),
                  Exception.class.getName())));
    }
  }

  @Override
  public void updateVmwareEngineNetwork(
      UpdateVmwareEngineNetworkRequest request, StreamObserver<Operation> responseObserver) {
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
                  "Unrecognized response type %s for method UpdateVmwareEngineNetwork, expected %s or %s",
                  response == null ? "null" : response.getClass().getName(),
                  Operation.class.getName(),
                  Exception.class.getName())));
    }
  }

  @Override
  public void deleteVmwareEngineNetwork(
      DeleteVmwareEngineNetworkRequest request, StreamObserver<Operation> responseObserver) {
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
                  "Unrecognized response type %s for method DeleteVmwareEngineNetwork, expected %s or %s",
                  response == null ? "null" : response.getClass().getName(),
                  Operation.class.getName(),
                  Exception.class.getName())));
    }
  }

  @Override
  public void getVmwareEngineNetwork(
      GetVmwareEngineNetworkRequest request, StreamObserver<VmwareEngineNetwork> responseObserver) {
    Object response = responses.poll();
    if (response instanceof VmwareEngineNetwork) {
      requests.add(request);
      responseObserver.onNext(((VmwareEngineNetwork) response));
      responseObserver.onCompleted();
    } else if (response instanceof Exception) {
      responseObserver.onError(((Exception) response));
    } else {
      responseObserver.onError(
          new IllegalArgumentException(
              String.format(
                  "Unrecognized response type %s for method GetVmwareEngineNetwork, expected %s or %s",
                  response == null ? "null" : response.getClass().getName(),
                  VmwareEngineNetwork.class.getName(),
                  Exception.class.getName())));
    }
  }

  @Override
  public void listVmwareEngineNetworks(
      ListVmwareEngineNetworksRequest request,
      StreamObserver<ListVmwareEngineNetworksResponse> responseObserver) {
    Object response = responses.poll();
    if (response instanceof ListVmwareEngineNetworksResponse) {
      requests.add(request);
      responseObserver.onNext(((ListVmwareEngineNetworksResponse) response));
      responseObserver.onCompleted();
    } else if (response instanceof Exception) {
      responseObserver.onError(((Exception) response));
    } else {
      responseObserver.onError(
          new IllegalArgumentException(
              String.format(
                  "Unrecognized response type %s for method ListVmwareEngineNetworks, expected %s or %s",
                  response == null ? "null" : response.getClass().getName(),
                  ListVmwareEngineNetworksResponse.class.getName(),
                  Exception.class.getName())));
    }
  }

  @Override
  public void createPrivateConnection(
      CreatePrivateConnectionRequest request, StreamObserver<Operation> responseObserver) {
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
                  "Unrecognized response type %s for method CreatePrivateConnection, expected %s or %s",
                  response == null ? "null" : response.getClass().getName(),
                  Operation.class.getName(),
                  Exception.class.getName())));
    }
  }

  @Override
  public void getPrivateConnection(
      GetPrivateConnectionRequest request, StreamObserver<PrivateConnection> responseObserver) {
    Object response = responses.poll();
    if (response instanceof PrivateConnection) {
      requests.add(request);
      responseObserver.onNext(((PrivateConnection) response));
      responseObserver.onCompleted();
    } else if (response instanceof Exception) {
      responseObserver.onError(((Exception) response));
    } else {
      responseObserver.onError(
          new IllegalArgumentException(
              String.format(
                  "Unrecognized response type %s for method GetPrivateConnection, expected %s or %s",
                  response == null ? "null" : response.getClass().getName(),
                  PrivateConnection.class.getName(),
                  Exception.class.getName())));
    }
  }

  @Override
  public void listPrivateConnections(
      ListPrivateConnectionsRequest request,
      StreamObserver<ListPrivateConnectionsResponse> responseObserver) {
    Object response = responses.poll();
    if (response instanceof ListPrivateConnectionsResponse) {
      requests.add(request);
      responseObserver.onNext(((ListPrivateConnectionsResponse) response));
      responseObserver.onCompleted();
    } else if (response instanceof Exception) {
      responseObserver.onError(((Exception) response));
    } else {
      responseObserver.onError(
          new IllegalArgumentException(
              String.format(
                  "Unrecognized response type %s for method ListPrivateConnections, expected %s or %s",
                  response == null ? "null" : response.getClass().getName(),
                  ListPrivateConnectionsResponse.class.getName(),
                  Exception.class.getName())));
    }
  }

  @Override
  public void updatePrivateConnection(
      UpdatePrivateConnectionRequest request, StreamObserver<Operation> responseObserver) {
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
                  "Unrecognized response type %s for method UpdatePrivateConnection, expected %s or %s",
                  response == null ? "null" : response.getClass().getName(),
                  Operation.class.getName(),
                  Exception.class.getName())));
    }
  }

  @Override
  public void deletePrivateConnection(
      DeletePrivateConnectionRequest request, StreamObserver<Operation> responseObserver) {
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
                  "Unrecognized response type %s for method DeletePrivateConnection, expected %s or %s",
                  response == null ? "null" : response.getClass().getName(),
                  Operation.class.getName(),
                  Exception.class.getName())));
    }
  }

  @Override
  public void listPrivateConnectionPeeringRoutes(
      ListPrivateConnectionPeeringRoutesRequest request,
      StreamObserver<ListPrivateConnectionPeeringRoutesResponse> responseObserver) {
    Object response = responses.poll();
    if (response instanceof ListPrivateConnectionPeeringRoutesResponse) {
      requests.add(request);
      responseObserver.onNext(((ListPrivateConnectionPeeringRoutesResponse) response));
      responseObserver.onCompleted();
    } else if (response instanceof Exception) {
      responseObserver.onError(((Exception) response));
    } else {
      responseObserver.onError(
          new IllegalArgumentException(
              String.format(
                  "Unrecognized response type %s for method ListPrivateConnectionPeeringRoutes, expected %s or %s",
                  response == null ? "null" : response.getClass().getName(),
                  ListPrivateConnectionPeeringRoutesResponse.class.getName(),
                  Exception.class.getName())));
    }
  }

  @Override
  public void grantDnsBindPermission(
      GrantDnsBindPermissionRequest request, StreamObserver<Operation> responseObserver) {
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
                  "Unrecognized response type %s for method GrantDnsBindPermission, expected %s or %s",
                  response == null ? "null" : response.getClass().getName(),
                  Operation.class.getName(),
                  Exception.class.getName())));
    }
  }

  @Override
  public void getDnsBindPermission(
      GetDnsBindPermissionRequest request, StreamObserver<DnsBindPermission> responseObserver) {
    Object response = responses.poll();
    if (response instanceof DnsBindPermission) {
      requests.add(request);
      responseObserver.onNext(((DnsBindPermission) response));
      responseObserver.onCompleted();
    } else if (response instanceof Exception) {
      responseObserver.onError(((Exception) response));
    } else {
      responseObserver.onError(
          new IllegalArgumentException(
              String.format(
                  "Unrecognized response type %s for method GetDnsBindPermission, expected %s or %s",
                  response == null ? "null" : response.getClass().getName(),
                  DnsBindPermission.class.getName(),
                  Exception.class.getName())));
    }
  }

  @Override
  public void revokeDnsBindPermission(
      RevokeDnsBindPermissionRequest request, StreamObserver<Operation> responseObserver) {
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
                  "Unrecognized response type %s for method RevokeDnsBindPermission, expected %s or %s",
                  response == null ? "null" : response.getClass().getName(),
                  Operation.class.getName(),
                  Exception.class.getName())));
    }
  }
}
