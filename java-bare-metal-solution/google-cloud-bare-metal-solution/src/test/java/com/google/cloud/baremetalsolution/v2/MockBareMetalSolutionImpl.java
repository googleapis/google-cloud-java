/*
 * Copyright 2021 Google LLC
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
import com.google.protobuf.Empty;
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
  public void listSnapshotSchedulePolicies(
      ListSnapshotSchedulePoliciesRequest request,
      StreamObserver<ListSnapshotSchedulePoliciesResponse> responseObserver) {
    Object response = responses.poll();
    if (response instanceof ListSnapshotSchedulePoliciesResponse) {
      requests.add(request);
      responseObserver.onNext(((ListSnapshotSchedulePoliciesResponse) response));
      responseObserver.onCompleted();
    } else if (response instanceof Exception) {
      responseObserver.onError(((Exception) response));
    } else {
      responseObserver.onError(
          new IllegalArgumentException(
              String.format(
                  "Unrecognized response type %s for method ListSnapshotSchedulePolicies, expected %s or %s",
                  response == null ? "null" : response.getClass().getName(),
                  ListSnapshotSchedulePoliciesResponse.class.getName(),
                  Exception.class.getName())));
    }
  }

  @Override
  public void getSnapshotSchedulePolicy(
      GetSnapshotSchedulePolicyRequest request,
      StreamObserver<SnapshotSchedulePolicy> responseObserver) {
    Object response = responses.poll();
    if (response instanceof SnapshotSchedulePolicy) {
      requests.add(request);
      responseObserver.onNext(((SnapshotSchedulePolicy) response));
      responseObserver.onCompleted();
    } else if (response instanceof Exception) {
      responseObserver.onError(((Exception) response));
    } else {
      responseObserver.onError(
          new IllegalArgumentException(
              String.format(
                  "Unrecognized response type %s for method GetSnapshotSchedulePolicy, expected %s or %s",
                  response == null ? "null" : response.getClass().getName(),
                  SnapshotSchedulePolicy.class.getName(),
                  Exception.class.getName())));
    }
  }

  @Override
  public void createSnapshotSchedulePolicy(
      CreateSnapshotSchedulePolicyRequest request,
      StreamObserver<SnapshotSchedulePolicy> responseObserver) {
    Object response = responses.poll();
    if (response instanceof SnapshotSchedulePolicy) {
      requests.add(request);
      responseObserver.onNext(((SnapshotSchedulePolicy) response));
      responseObserver.onCompleted();
    } else if (response instanceof Exception) {
      responseObserver.onError(((Exception) response));
    } else {
      responseObserver.onError(
          new IllegalArgumentException(
              String.format(
                  "Unrecognized response type %s for method CreateSnapshotSchedulePolicy, expected %s or %s",
                  response == null ? "null" : response.getClass().getName(),
                  SnapshotSchedulePolicy.class.getName(),
                  Exception.class.getName())));
    }
  }

  @Override
  public void updateSnapshotSchedulePolicy(
      UpdateSnapshotSchedulePolicyRequest request,
      StreamObserver<SnapshotSchedulePolicy> responseObserver) {
    Object response = responses.poll();
    if (response instanceof SnapshotSchedulePolicy) {
      requests.add(request);
      responseObserver.onNext(((SnapshotSchedulePolicy) response));
      responseObserver.onCompleted();
    } else if (response instanceof Exception) {
      responseObserver.onError(((Exception) response));
    } else {
      responseObserver.onError(
          new IllegalArgumentException(
              String.format(
                  "Unrecognized response type %s for method UpdateSnapshotSchedulePolicy, expected %s or %s",
                  response == null ? "null" : response.getClass().getName(),
                  SnapshotSchedulePolicy.class.getName(),
                  Exception.class.getName())));
    }
  }

  @Override
  public void deleteSnapshotSchedulePolicy(
      DeleteSnapshotSchedulePolicyRequest request, StreamObserver<Empty> responseObserver) {
    Object response = responses.poll();
    if (response instanceof Empty) {
      requests.add(request);
      responseObserver.onNext(((Empty) response));
      responseObserver.onCompleted();
    } else if (response instanceof Exception) {
      responseObserver.onError(((Exception) response));
    } else {
      responseObserver.onError(
          new IllegalArgumentException(
              String.format(
                  "Unrecognized response type %s for method DeleteSnapshotSchedulePolicy, expected %s or %s",
                  response == null ? "null" : response.getClass().getName(),
                  Empty.class.getName(),
                  Exception.class.getName())));
    }
  }

  @Override
  public void createVolumeSnapshot(
      CreateVolumeSnapshotRequest request, StreamObserver<VolumeSnapshot> responseObserver) {
    Object response = responses.poll();
    if (response instanceof VolumeSnapshot) {
      requests.add(request);
      responseObserver.onNext(((VolumeSnapshot) response));
      responseObserver.onCompleted();
    } else if (response instanceof Exception) {
      responseObserver.onError(((Exception) response));
    } else {
      responseObserver.onError(
          new IllegalArgumentException(
              String.format(
                  "Unrecognized response type %s for method CreateVolumeSnapshot, expected %s or %s",
                  response == null ? "null" : response.getClass().getName(),
                  VolumeSnapshot.class.getName(),
                  Exception.class.getName())));
    }
  }

  @Override
  public void restoreVolumeSnapshot(
      RestoreVolumeSnapshotRequest request, StreamObserver<Operation> responseObserver) {
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
                  "Unrecognized response type %s for method RestoreVolumeSnapshot, expected %s or %s",
                  response == null ? "null" : response.getClass().getName(),
                  Operation.class.getName(),
                  Exception.class.getName())));
    }
  }

  @Override
  public void deleteVolumeSnapshot(
      DeleteVolumeSnapshotRequest request, StreamObserver<Empty> responseObserver) {
    Object response = responses.poll();
    if (response instanceof Empty) {
      requests.add(request);
      responseObserver.onNext(((Empty) response));
      responseObserver.onCompleted();
    } else if (response instanceof Exception) {
      responseObserver.onError(((Exception) response));
    } else {
      responseObserver.onError(
          new IllegalArgumentException(
              String.format(
                  "Unrecognized response type %s for method DeleteVolumeSnapshot, expected %s or %s",
                  response == null ? "null" : response.getClass().getName(),
                  Empty.class.getName(),
                  Exception.class.getName())));
    }
  }

  @Override
  public void getVolumeSnapshot(
      GetVolumeSnapshotRequest request, StreamObserver<VolumeSnapshot> responseObserver) {
    Object response = responses.poll();
    if (response instanceof VolumeSnapshot) {
      requests.add(request);
      responseObserver.onNext(((VolumeSnapshot) response));
      responseObserver.onCompleted();
    } else if (response instanceof Exception) {
      responseObserver.onError(((Exception) response));
    } else {
      responseObserver.onError(
          new IllegalArgumentException(
              String.format(
                  "Unrecognized response type %s for method GetVolumeSnapshot, expected %s or %s",
                  response == null ? "null" : response.getClass().getName(),
                  VolumeSnapshot.class.getName(),
                  Exception.class.getName())));
    }
  }

  @Override
  public void listVolumeSnapshots(
      ListVolumeSnapshotsRequest request,
      StreamObserver<ListVolumeSnapshotsResponse> responseObserver) {
    Object response = responses.poll();
    if (response instanceof ListVolumeSnapshotsResponse) {
      requests.add(request);
      responseObserver.onNext(((ListVolumeSnapshotsResponse) response));
      responseObserver.onCompleted();
    } else if (response instanceof Exception) {
      responseObserver.onError(((Exception) response));
    } else {
      responseObserver.onError(
          new IllegalArgumentException(
              String.format(
                  "Unrecognized response type %s for method ListVolumeSnapshots, expected %s or %s",
                  response == null ? "null" : response.getClass().getName(),
                  ListVolumeSnapshotsResponse.class.getName(),
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
}
