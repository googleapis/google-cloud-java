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

package com.google.cloud.baremetalsolution.v2;

import com.google.api.core.BetaApi;
import com.google.cloud.baremetalsolution.v2.BareMetalSolutionGrpc.BareMetalSolutionImplBase;
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
public class MockBareMetalSolutionImpl extends BareMetalSolutionImplBase {
  private List<AbstractMessage> requests;
  private Queue<Object> responses;

  public MockBareMetalSolutionImpl() {
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
  public void listInstances(
      ListInstancesRequest request, StreamObserver<ListInstancesResponse> responseObserver) {
    Object response = responses.poll();
    if (response instanceof ListInstancesResponse) {
      requests.add(request);
      responseObserver.onNext(((ListInstancesResponse) response));
      responseObserver.onCompleted();
    } else if (response instanceof Exception) {
      responseObserver.onError(((Exception) response));
    } else {
      responseObserver.onError(
          new IllegalArgumentException(
              String.format(
                  "Unrecognized response type %s for method ListInstances, expected %s or %s",
                  response == null ? "null" : response.getClass().getName(),
                  ListInstancesResponse.class.getName(),
                  Exception.class.getName())));
    }
  }

  @Override
  public void getInstance(GetInstanceRequest request, StreamObserver<Instance> responseObserver) {
    Object response = responses.poll();
    if (response instanceof Instance) {
      requests.add(request);
      responseObserver.onNext(((Instance) response));
      responseObserver.onCompleted();
    } else if (response instanceof Exception) {
      responseObserver.onError(((Exception) response));
    } else {
      responseObserver.onError(
          new IllegalArgumentException(
              String.format(
                  "Unrecognized response type %s for method GetInstance, expected %s or %s",
                  response == null ? "null" : response.getClass().getName(),
                  Instance.class.getName(),
                  Exception.class.getName())));
    }
  }

  @Override
  public void updateInstance(
      UpdateInstanceRequest request, StreamObserver<Operation> responseObserver) {
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
                  "Unrecognized response type %s for method UpdateInstance, expected %s or %s",
                  response == null ? "null" : response.getClass().getName(),
                  Operation.class.getName(),
                  Exception.class.getName())));
    }
  }

  @Override
  public void resetInstance(
      ResetInstanceRequest request, StreamObserver<Operation> responseObserver) {
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
                  "Unrecognized response type %s for method ResetInstance, expected %s or %s",
                  response == null ? "null" : response.getClass().getName(),
                  Operation.class.getName(),
                  Exception.class.getName())));
    }
  }

  @Override
  public void startInstance(
      StartInstanceRequest request, StreamObserver<Operation> responseObserver) {
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
                  "Unrecognized response type %s for method StartInstance, expected %s or %s",
                  response == null ? "null" : response.getClass().getName(),
                  Operation.class.getName(),
                  Exception.class.getName())));
    }
  }

  @Override
  public void stopInstance(
      StopInstanceRequest request, StreamObserver<Operation> responseObserver) {
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
                  "Unrecognized response type %s for method StopInstance, expected %s or %s",
                  response == null ? "null" : response.getClass().getName(),
                  Operation.class.getName(),
                  Exception.class.getName())));
    }
  }

  @Override
  public void detachLun(DetachLunRequest request, StreamObserver<Operation> responseObserver) {
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
                  "Unrecognized response type %s for method DetachLun, expected %s or %s",
                  response == null ? "null" : response.getClass().getName(),
                  Operation.class.getName(),
                  Exception.class.getName())));
    }
  }

  @Override
  public void listVolumes(
      ListVolumesRequest request, StreamObserver<ListVolumesResponse> responseObserver) {
    Object response = responses.poll();
    if (response instanceof ListVolumesResponse) {
      requests.add(request);
      responseObserver.onNext(((ListVolumesResponse) response));
      responseObserver.onCompleted();
    } else if (response instanceof Exception) {
      responseObserver.onError(((Exception) response));
    } else {
      responseObserver.onError(
          new IllegalArgumentException(
              String.format(
                  "Unrecognized response type %s for method ListVolumes, expected %s or %s",
                  response == null ? "null" : response.getClass().getName(),
                  ListVolumesResponse.class.getName(),
                  Exception.class.getName())));
    }
  }

  @Override
  public void getVolume(GetVolumeRequest request, StreamObserver<Volume> responseObserver) {
    Object response = responses.poll();
    if (response instanceof Volume) {
      requests.add(request);
      responseObserver.onNext(((Volume) response));
      responseObserver.onCompleted();
    } else if (response instanceof Exception) {
      responseObserver.onError(((Exception) response));
    } else {
      responseObserver.onError(
          new IllegalArgumentException(
              String.format(
                  "Unrecognized response type %s for method GetVolume, expected %s or %s",
                  response == null ? "null" : response.getClass().getName(),
                  Volume.class.getName(),
                  Exception.class.getName())));
    }
  }

  @Override
  public void updateVolume(
      UpdateVolumeRequest request, StreamObserver<Operation> responseObserver) {
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
                  "Unrecognized response type %s for method UpdateVolume, expected %s or %s",
                  response == null ? "null" : response.getClass().getName(),
                  Operation.class.getName(),
                  Exception.class.getName())));
    }
  }

  @Override
  public void resizeVolume(
      ResizeVolumeRequest request, StreamObserver<Operation> responseObserver) {
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
                  "Unrecognized response type %s for method ResizeVolume, expected %s or %s",
                  response == null ? "null" : response.getClass().getName(),
                  Operation.class.getName(),
                  Exception.class.getName())));
    }
  }

  @Override
  public void listNetworks(
      ListNetworksRequest request, StreamObserver<ListNetworksResponse> responseObserver) {
    Object response = responses.poll();
    if (response instanceof ListNetworksResponse) {
      requests.add(request);
      responseObserver.onNext(((ListNetworksResponse) response));
      responseObserver.onCompleted();
    } else if (response instanceof Exception) {
      responseObserver.onError(((Exception) response));
    } else {
      responseObserver.onError(
          new IllegalArgumentException(
              String.format(
                  "Unrecognized response type %s for method ListNetworks, expected %s or %s",
                  response == null ? "null" : response.getClass().getName(),
                  ListNetworksResponse.class.getName(),
                  Exception.class.getName())));
    }
  }

  @Override
  public void listNetworkUsage(
      ListNetworkUsageRequest request, StreamObserver<ListNetworkUsageResponse> responseObserver) {
    Object response = responses.poll();
    if (response instanceof ListNetworkUsageResponse) {
      requests.add(request);
      responseObserver.onNext(((ListNetworkUsageResponse) response));
      responseObserver.onCompleted();
    } else if (response instanceof Exception) {
      responseObserver.onError(((Exception) response));
    } else {
      responseObserver.onError(
          new IllegalArgumentException(
              String.format(
                  "Unrecognized response type %s for method ListNetworkUsage, expected %s or %s",
                  response == null ? "null" : response.getClass().getName(),
                  ListNetworkUsageResponse.class.getName(),
                  Exception.class.getName())));
    }
  }

  @Override
  public void getNetwork(GetNetworkRequest request, StreamObserver<Network> responseObserver) {
    Object response = responses.poll();
    if (response instanceof Network) {
      requests.add(request);
      responseObserver.onNext(((Network) response));
      responseObserver.onCompleted();
    } else if (response instanceof Exception) {
      responseObserver.onError(((Exception) response));
    } else {
      responseObserver.onError(
          new IllegalArgumentException(
              String.format(
                  "Unrecognized response type %s for method GetNetwork, expected %s or %s",
                  response == null ? "null" : response.getClass().getName(),
                  Network.class.getName(),
                  Exception.class.getName())));
    }
  }

  @Override
  public void updateNetwork(
      UpdateNetworkRequest request, StreamObserver<Operation> responseObserver) {
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
                  "Unrecognized response type %s for method UpdateNetwork, expected %s or %s",
                  response == null ? "null" : response.getClass().getName(),
                  Operation.class.getName(),
                  Exception.class.getName())));
    }
  }

  @Override
  public void getLun(GetLunRequest request, StreamObserver<Lun> responseObserver) {
    Object response = responses.poll();
    if (response instanceof Lun) {
      requests.add(request);
      responseObserver.onNext(((Lun) response));
      responseObserver.onCompleted();
    } else if (response instanceof Exception) {
      responseObserver.onError(((Exception) response));
    } else {
      responseObserver.onError(
          new IllegalArgumentException(
              String.format(
                  "Unrecognized response type %s for method GetLun, expected %s or %s",
                  response == null ? "null" : response.getClass().getName(),
                  Lun.class.getName(),
                  Exception.class.getName())));
    }
  }

  @Override
  public void listLuns(ListLunsRequest request, StreamObserver<ListLunsResponse> responseObserver) {
    Object response = responses.poll();
    if (response instanceof ListLunsResponse) {
      requests.add(request);
      responseObserver.onNext(((ListLunsResponse) response));
      responseObserver.onCompleted();
    } else if (response instanceof Exception) {
      responseObserver.onError(((Exception) response));
    } else {
      responseObserver.onError(
          new IllegalArgumentException(
              String.format(
                  "Unrecognized response type %s for method ListLuns, expected %s or %s",
                  response == null ? "null" : response.getClass().getName(),
                  ListLunsResponse.class.getName(),
                  Exception.class.getName())));
    }
  }

  @Override
  public void getNfsShare(GetNfsShareRequest request, StreamObserver<NfsShare> responseObserver) {
    Object response = responses.poll();
    if (response instanceof NfsShare) {
      requests.add(request);
      responseObserver.onNext(((NfsShare) response));
      responseObserver.onCompleted();
    } else if (response instanceof Exception) {
      responseObserver.onError(((Exception) response));
    } else {
      responseObserver.onError(
          new IllegalArgumentException(
              String.format(
                  "Unrecognized response type %s for method GetNfsShare, expected %s or %s",
                  response == null ? "null" : response.getClass().getName(),
                  NfsShare.class.getName(),
                  Exception.class.getName())));
    }
  }

  @Override
  public void listNfsShares(
      ListNfsSharesRequest request, StreamObserver<ListNfsSharesResponse> responseObserver) {
    Object response = responses.poll();
    if (response instanceof ListNfsSharesResponse) {
      requests.add(request);
      responseObserver.onNext(((ListNfsSharesResponse) response));
      responseObserver.onCompleted();
    } else if (response instanceof Exception) {
      responseObserver.onError(((Exception) response));
    } else {
      responseObserver.onError(
          new IllegalArgumentException(
              String.format(
                  "Unrecognized response type %s for method ListNfsShares, expected %s or %s",
                  response == null ? "null" : response.getClass().getName(),
                  ListNfsSharesResponse.class.getName(),
                  Exception.class.getName())));
    }
  }

  @Override
  public void updateNfsShare(
      UpdateNfsShareRequest request, StreamObserver<Operation> responseObserver) {
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
                  "Unrecognized response type %s for method UpdateNfsShare, expected %s or %s",
                  response == null ? "null" : response.getClass().getName(),
                  Operation.class.getName(),
                  Exception.class.getName())));
    }
  }
}
