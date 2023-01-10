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
}
