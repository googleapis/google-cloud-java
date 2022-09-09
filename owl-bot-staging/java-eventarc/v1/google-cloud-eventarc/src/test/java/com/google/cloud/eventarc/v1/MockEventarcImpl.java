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

package com.google.cloud.eventarc.v1;

import com.google.api.core.BetaApi;
import com.google.cloud.eventarc.v1.EventarcGrpc.EventarcImplBase;
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
public class MockEventarcImpl extends EventarcImplBase {
  private List<AbstractMessage> requests;
  private Queue<Object> responses;

  public MockEventarcImpl() {
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
  public void getTrigger(GetTriggerRequest request, StreamObserver<Trigger> responseObserver) {
    Object response = responses.poll();
    if (response instanceof Trigger) {
      requests.add(request);
      responseObserver.onNext(((Trigger) response));
      responseObserver.onCompleted();
    } else if (response instanceof Exception) {
      responseObserver.onError(((Exception) response));
    } else {
      responseObserver.onError(
          new IllegalArgumentException(
              String.format(
                  "Unrecognized response type %s for method GetTrigger, expected %s or %s",
                  response == null ? "null" : response.getClass().getName(),
                  Trigger.class.getName(),
                  Exception.class.getName())));
    }
  }

  @Override
  public void listTriggers(
      ListTriggersRequest request, StreamObserver<ListTriggersResponse> responseObserver) {
    Object response = responses.poll();
    if (response instanceof ListTriggersResponse) {
      requests.add(request);
      responseObserver.onNext(((ListTriggersResponse) response));
      responseObserver.onCompleted();
    } else if (response instanceof Exception) {
      responseObserver.onError(((Exception) response));
    } else {
      responseObserver.onError(
          new IllegalArgumentException(
              String.format(
                  "Unrecognized response type %s for method ListTriggers, expected %s or %s",
                  response == null ? "null" : response.getClass().getName(),
                  ListTriggersResponse.class.getName(),
                  Exception.class.getName())));
    }
  }

  @Override
  public void createTrigger(
      CreateTriggerRequest request, StreamObserver<Operation> responseObserver) {
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
                  "Unrecognized response type %s for method CreateTrigger, expected %s or %s",
                  response == null ? "null" : response.getClass().getName(),
                  Operation.class.getName(),
                  Exception.class.getName())));
    }
  }

  @Override
  public void updateTrigger(
      UpdateTriggerRequest request, StreamObserver<Operation> responseObserver) {
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
                  "Unrecognized response type %s for method UpdateTrigger, expected %s or %s",
                  response == null ? "null" : response.getClass().getName(),
                  Operation.class.getName(),
                  Exception.class.getName())));
    }
  }

  @Override
  public void deleteTrigger(
      DeleteTriggerRequest request, StreamObserver<Operation> responseObserver) {
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
                  "Unrecognized response type %s for method DeleteTrigger, expected %s or %s",
                  response == null ? "null" : response.getClass().getName(),
                  Operation.class.getName(),
                  Exception.class.getName())));
    }
  }

  @Override
  public void getChannel(GetChannelRequest request, StreamObserver<Channel> responseObserver) {
    Object response = responses.poll();
    if (response instanceof Channel) {
      requests.add(request);
      responseObserver.onNext(((Channel) response));
      responseObserver.onCompleted();
    } else if (response instanceof Exception) {
      responseObserver.onError(((Exception) response));
    } else {
      responseObserver.onError(
          new IllegalArgumentException(
              String.format(
                  "Unrecognized response type %s for method GetChannel, expected %s or %s",
                  response == null ? "null" : response.getClass().getName(),
                  Channel.class.getName(),
                  Exception.class.getName())));
    }
  }

  @Override
  public void listChannels(
      ListChannelsRequest request, StreamObserver<ListChannelsResponse> responseObserver) {
    Object response = responses.poll();
    if (response instanceof ListChannelsResponse) {
      requests.add(request);
      responseObserver.onNext(((ListChannelsResponse) response));
      responseObserver.onCompleted();
    } else if (response instanceof Exception) {
      responseObserver.onError(((Exception) response));
    } else {
      responseObserver.onError(
          new IllegalArgumentException(
              String.format(
                  "Unrecognized response type %s for method ListChannels, expected %s or %s",
                  response == null ? "null" : response.getClass().getName(),
                  ListChannelsResponse.class.getName(),
                  Exception.class.getName())));
    }
  }

  @Override
  public void createChannel(
      CreateChannelRequest request, StreamObserver<Operation> responseObserver) {
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
                  "Unrecognized response type %s for method CreateChannel, expected %s or %s",
                  response == null ? "null" : response.getClass().getName(),
                  Operation.class.getName(),
                  Exception.class.getName())));
    }
  }

  @Override
  public void updateChannel(
      UpdateChannelRequest request, StreamObserver<Operation> responseObserver) {
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
                  "Unrecognized response type %s for method UpdateChannel, expected %s or %s",
                  response == null ? "null" : response.getClass().getName(),
                  Operation.class.getName(),
                  Exception.class.getName())));
    }
  }

  @Override
  public void deleteChannel(
      DeleteChannelRequest request, StreamObserver<Operation> responseObserver) {
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
                  "Unrecognized response type %s for method DeleteChannel, expected %s or %s",
                  response == null ? "null" : response.getClass().getName(),
                  Operation.class.getName(),
                  Exception.class.getName())));
    }
  }

  @Override
  public void getProvider(GetProviderRequest request, StreamObserver<Provider> responseObserver) {
    Object response = responses.poll();
    if (response instanceof Provider) {
      requests.add(request);
      responseObserver.onNext(((Provider) response));
      responseObserver.onCompleted();
    } else if (response instanceof Exception) {
      responseObserver.onError(((Exception) response));
    } else {
      responseObserver.onError(
          new IllegalArgumentException(
              String.format(
                  "Unrecognized response type %s for method GetProvider, expected %s or %s",
                  response == null ? "null" : response.getClass().getName(),
                  Provider.class.getName(),
                  Exception.class.getName())));
    }
  }

  @Override
  public void listProviders(
      ListProvidersRequest request, StreamObserver<ListProvidersResponse> responseObserver) {
    Object response = responses.poll();
    if (response instanceof ListProvidersResponse) {
      requests.add(request);
      responseObserver.onNext(((ListProvidersResponse) response));
      responseObserver.onCompleted();
    } else if (response instanceof Exception) {
      responseObserver.onError(((Exception) response));
    } else {
      responseObserver.onError(
          new IllegalArgumentException(
              String.format(
                  "Unrecognized response type %s for method ListProviders, expected %s or %s",
                  response == null ? "null" : response.getClass().getName(),
                  ListProvidersResponse.class.getName(),
                  Exception.class.getName())));
    }
  }

  @Override
  public void getChannelConnection(
      GetChannelConnectionRequest request, StreamObserver<ChannelConnection> responseObserver) {
    Object response = responses.poll();
    if (response instanceof ChannelConnection) {
      requests.add(request);
      responseObserver.onNext(((ChannelConnection) response));
      responseObserver.onCompleted();
    } else if (response instanceof Exception) {
      responseObserver.onError(((Exception) response));
    } else {
      responseObserver.onError(
          new IllegalArgumentException(
              String.format(
                  "Unrecognized response type %s for method GetChannelConnection, expected %s or %s",
                  response == null ? "null" : response.getClass().getName(),
                  ChannelConnection.class.getName(),
                  Exception.class.getName())));
    }
  }

  @Override
  public void listChannelConnections(
      ListChannelConnectionsRequest request,
      StreamObserver<ListChannelConnectionsResponse> responseObserver) {
    Object response = responses.poll();
    if (response instanceof ListChannelConnectionsResponse) {
      requests.add(request);
      responseObserver.onNext(((ListChannelConnectionsResponse) response));
      responseObserver.onCompleted();
    } else if (response instanceof Exception) {
      responseObserver.onError(((Exception) response));
    } else {
      responseObserver.onError(
          new IllegalArgumentException(
              String.format(
                  "Unrecognized response type %s for method ListChannelConnections, expected %s or %s",
                  response == null ? "null" : response.getClass().getName(),
                  ListChannelConnectionsResponse.class.getName(),
                  Exception.class.getName())));
    }
  }

  @Override
  public void createChannelConnection(
      CreateChannelConnectionRequest request, StreamObserver<Operation> responseObserver) {
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
                  "Unrecognized response type %s for method CreateChannelConnection, expected %s or %s",
                  response == null ? "null" : response.getClass().getName(),
                  Operation.class.getName(),
                  Exception.class.getName())));
    }
  }

  @Override
  public void deleteChannelConnection(
      DeleteChannelConnectionRequest request, StreamObserver<Operation> responseObserver) {
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
                  "Unrecognized response type %s for method DeleteChannelConnection, expected %s or %s",
                  response == null ? "null" : response.getClass().getName(),
                  Operation.class.getName(),
                  Exception.class.getName())));
    }
  }
}
