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

package google.cloud.edgenetwork.v1;

import com.google.api.core.BetaApi;
import com.google.longrunning.Operation;
import com.google.protobuf.AbstractMessage;
import google.cloud.edgenetwork.v1.EdgeNetworkGrpc.EdgeNetworkImplBase;
import io.grpc.stub.StreamObserver;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import javax.annotation.Generated;

@BetaApi
@Generated("by gapic-generator-java")
public class MockEdgeNetworkImpl extends EdgeNetworkImplBase {
  private List<AbstractMessage> requests;
  private Queue<Object> responses;

  public MockEdgeNetworkImpl() {
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
  public void initializeZone(
      InitializeZoneRequest request, StreamObserver<InitializeZoneResponse> responseObserver) {
    Object response = responses.poll();
    if (response instanceof InitializeZoneResponse) {
      requests.add(request);
      responseObserver.onNext(((InitializeZoneResponse) response));
      responseObserver.onCompleted();
    } else if (response instanceof Exception) {
      responseObserver.onError(((Exception) response));
    } else {
      responseObserver.onError(
          new IllegalArgumentException(
              String.format(
                  "Unrecognized response type %s for method InitializeZone, expected %s or %s",
                  response == null ? "null" : response.getClass().getName(),
                  InitializeZoneResponse.class.getName(),
                  Exception.class.getName())));
    }
  }

  @Override
  public void listZones(
      ListZonesRequest request, StreamObserver<ListZonesResponse> responseObserver) {
    Object response = responses.poll();
    if (response instanceof ListZonesResponse) {
      requests.add(request);
      responseObserver.onNext(((ListZonesResponse) response));
      responseObserver.onCompleted();
    } else if (response instanceof Exception) {
      responseObserver.onError(((Exception) response));
    } else {
      responseObserver.onError(
          new IllegalArgumentException(
              String.format(
                  "Unrecognized response type %s for method ListZones, expected %s or %s",
                  response == null ? "null" : response.getClass().getName(),
                  ListZonesResponse.class.getName(),
                  Exception.class.getName())));
    }
  }

  @Override
  public void getZone(GetZoneRequest request, StreamObserver<Zone> responseObserver) {
    Object response = responses.poll();
    if (response instanceof Zone) {
      requests.add(request);
      responseObserver.onNext(((Zone) response));
      responseObserver.onCompleted();
    } else if (response instanceof Exception) {
      responseObserver.onError(((Exception) response));
    } else {
      responseObserver.onError(
          new IllegalArgumentException(
              String.format(
                  "Unrecognized response type %s for method GetZone, expected %s or %s",
                  response == null ? "null" : response.getClass().getName(),
                  Zone.class.getName(),
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
  public void diagnoseNetwork(
      DiagnoseNetworkRequest request, StreamObserver<DiagnoseNetworkResponse> responseObserver) {
    Object response = responses.poll();
    if (response instanceof DiagnoseNetworkResponse) {
      requests.add(request);
      responseObserver.onNext(((DiagnoseNetworkResponse) response));
      responseObserver.onCompleted();
    } else if (response instanceof Exception) {
      responseObserver.onError(((Exception) response));
    } else {
      responseObserver.onError(
          new IllegalArgumentException(
              String.format(
                  "Unrecognized response type %s for method DiagnoseNetwork, expected %s or %s",
                  response == null ? "null" : response.getClass().getName(),
                  DiagnoseNetworkResponse.class.getName(),
                  Exception.class.getName())));
    }
  }

  @Override
  public void createNetwork(
      CreateNetworkRequest request, StreamObserver<Operation> responseObserver) {
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
                  "Unrecognized response type %s for method CreateNetwork, expected %s or %s",
                  response == null ? "null" : response.getClass().getName(),
                  Operation.class.getName(),
                  Exception.class.getName())));
    }
  }

  @Override
  public void deleteNetwork(
      DeleteNetworkRequest request, StreamObserver<Operation> responseObserver) {
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
                  "Unrecognized response type %s for method DeleteNetwork, expected %s or %s",
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
  public void createSubnet(
      CreateSubnetRequest request, StreamObserver<Operation> responseObserver) {
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
                  "Unrecognized response type %s for method CreateSubnet, expected %s or %s",
                  response == null ? "null" : response.getClass().getName(),
                  Operation.class.getName(),
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
  public void deleteSubnet(
      DeleteSubnetRequest request, StreamObserver<Operation> responseObserver) {
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
                  "Unrecognized response type %s for method DeleteSubnet, expected %s or %s",
                  response == null ? "null" : response.getClass().getName(),
                  Operation.class.getName(),
                  Exception.class.getName())));
    }
  }

  @Override
  public void listInterconnects(
      ListInterconnectsRequest request,
      StreamObserver<ListInterconnectsResponse> responseObserver) {
    Object response = responses.poll();
    if (response instanceof ListInterconnectsResponse) {
      requests.add(request);
      responseObserver.onNext(((ListInterconnectsResponse) response));
      responseObserver.onCompleted();
    } else if (response instanceof Exception) {
      responseObserver.onError(((Exception) response));
    } else {
      responseObserver.onError(
          new IllegalArgumentException(
              String.format(
                  "Unrecognized response type %s for method ListInterconnects, expected %s or %s",
                  response == null ? "null" : response.getClass().getName(),
                  ListInterconnectsResponse.class.getName(),
                  Exception.class.getName())));
    }
  }

  @Override
  public void getInterconnect(
      GetInterconnectRequest request, StreamObserver<Interconnect> responseObserver) {
    Object response = responses.poll();
    if (response instanceof Interconnect) {
      requests.add(request);
      responseObserver.onNext(((Interconnect) response));
      responseObserver.onCompleted();
    } else if (response instanceof Exception) {
      responseObserver.onError(((Exception) response));
    } else {
      responseObserver.onError(
          new IllegalArgumentException(
              String.format(
                  "Unrecognized response type %s for method GetInterconnect, expected %s or %s",
                  response == null ? "null" : response.getClass().getName(),
                  Interconnect.class.getName(),
                  Exception.class.getName())));
    }
  }

  @Override
  public void diagnoseInterconnect(
      DiagnoseInterconnectRequest request,
      StreamObserver<DiagnoseInterconnectResponse> responseObserver) {
    Object response = responses.poll();
    if (response instanceof DiagnoseInterconnectResponse) {
      requests.add(request);
      responseObserver.onNext(((DiagnoseInterconnectResponse) response));
      responseObserver.onCompleted();
    } else if (response instanceof Exception) {
      responseObserver.onError(((Exception) response));
    } else {
      responseObserver.onError(
          new IllegalArgumentException(
              String.format(
                  "Unrecognized response type %s for method DiagnoseInterconnect, expected %s or %s",
                  response == null ? "null" : response.getClass().getName(),
                  DiagnoseInterconnectResponse.class.getName(),
                  Exception.class.getName())));
    }
  }

  @Override
  public void listInterconnectAttachments(
      ListInterconnectAttachmentsRequest request,
      StreamObserver<ListInterconnectAttachmentsResponse> responseObserver) {
    Object response = responses.poll();
    if (response instanceof ListInterconnectAttachmentsResponse) {
      requests.add(request);
      responseObserver.onNext(((ListInterconnectAttachmentsResponse) response));
      responseObserver.onCompleted();
    } else if (response instanceof Exception) {
      responseObserver.onError(((Exception) response));
    } else {
      responseObserver.onError(
          new IllegalArgumentException(
              String.format(
                  "Unrecognized response type %s for method ListInterconnectAttachments, expected %s or %s",
                  response == null ? "null" : response.getClass().getName(),
                  ListInterconnectAttachmentsResponse.class.getName(),
                  Exception.class.getName())));
    }
  }

  @Override
  public void getInterconnectAttachment(
      GetInterconnectAttachmentRequest request,
      StreamObserver<InterconnectAttachment> responseObserver) {
    Object response = responses.poll();
    if (response instanceof InterconnectAttachment) {
      requests.add(request);
      responseObserver.onNext(((InterconnectAttachment) response));
      responseObserver.onCompleted();
    } else if (response instanceof Exception) {
      responseObserver.onError(((Exception) response));
    } else {
      responseObserver.onError(
          new IllegalArgumentException(
              String.format(
                  "Unrecognized response type %s for method GetInterconnectAttachment, expected %s or %s",
                  response == null ? "null" : response.getClass().getName(),
                  InterconnectAttachment.class.getName(),
                  Exception.class.getName())));
    }
  }

  @Override
  public void createInterconnectAttachment(
      CreateInterconnectAttachmentRequest request, StreamObserver<Operation> responseObserver) {
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
                  "Unrecognized response type %s for method CreateInterconnectAttachment, expected %s or %s",
                  response == null ? "null" : response.getClass().getName(),
                  Operation.class.getName(),
                  Exception.class.getName())));
    }
  }

  @Override
  public void deleteInterconnectAttachment(
      DeleteInterconnectAttachmentRequest request, StreamObserver<Operation> responseObserver) {
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
                  "Unrecognized response type %s for method DeleteInterconnectAttachment, expected %s or %s",
                  response == null ? "null" : response.getClass().getName(),
                  Operation.class.getName(),
                  Exception.class.getName())));
    }
  }

  @Override
  public void listRouters(
      ListRoutersRequest request, StreamObserver<ListRoutersResponse> responseObserver) {
    Object response = responses.poll();
    if (response instanceof ListRoutersResponse) {
      requests.add(request);
      responseObserver.onNext(((ListRoutersResponse) response));
      responseObserver.onCompleted();
    } else if (response instanceof Exception) {
      responseObserver.onError(((Exception) response));
    } else {
      responseObserver.onError(
          new IllegalArgumentException(
              String.format(
                  "Unrecognized response type %s for method ListRouters, expected %s or %s",
                  response == null ? "null" : response.getClass().getName(),
                  ListRoutersResponse.class.getName(),
                  Exception.class.getName())));
    }
  }

  @Override
  public void getRouter(GetRouterRequest request, StreamObserver<Router> responseObserver) {
    Object response = responses.poll();
    if (response instanceof Router) {
      requests.add(request);
      responseObserver.onNext(((Router) response));
      responseObserver.onCompleted();
    } else if (response instanceof Exception) {
      responseObserver.onError(((Exception) response));
    } else {
      responseObserver.onError(
          new IllegalArgumentException(
              String.format(
                  "Unrecognized response type %s for method GetRouter, expected %s or %s",
                  response == null ? "null" : response.getClass().getName(),
                  Router.class.getName(),
                  Exception.class.getName())));
    }
  }

  @Override
  public void diagnoseRouter(
      DiagnoseRouterRequest request, StreamObserver<DiagnoseRouterResponse> responseObserver) {
    Object response = responses.poll();
    if (response instanceof DiagnoseRouterResponse) {
      requests.add(request);
      responseObserver.onNext(((DiagnoseRouterResponse) response));
      responseObserver.onCompleted();
    } else if (response instanceof Exception) {
      responseObserver.onError(((Exception) response));
    } else {
      responseObserver.onError(
          new IllegalArgumentException(
              String.format(
                  "Unrecognized response type %s for method DiagnoseRouter, expected %s or %s",
                  response == null ? "null" : response.getClass().getName(),
                  DiagnoseRouterResponse.class.getName(),
                  Exception.class.getName())));
    }
  }

  @Override
  public void createRouter(
      CreateRouterRequest request, StreamObserver<Operation> responseObserver) {
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
                  "Unrecognized response type %s for method CreateRouter, expected %s or %s",
                  response == null ? "null" : response.getClass().getName(),
                  Operation.class.getName(),
                  Exception.class.getName())));
    }
  }

  @Override
  public void updateRouter(
      UpdateRouterRequest request, StreamObserver<Operation> responseObserver) {
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
                  "Unrecognized response type %s for method UpdateRouter, expected %s or %s",
                  response == null ? "null" : response.getClass().getName(),
                  Operation.class.getName(),
                  Exception.class.getName())));
    }
  }

  @Override
  public void deleteRouter(
      DeleteRouterRequest request, StreamObserver<Operation> responseObserver) {
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
                  "Unrecognized response type %s for method DeleteRouter, expected %s or %s",
                  response == null ? "null" : response.getClass().getName(),
                  Operation.class.getName(),
                  Exception.class.getName())));
    }
  }
}
