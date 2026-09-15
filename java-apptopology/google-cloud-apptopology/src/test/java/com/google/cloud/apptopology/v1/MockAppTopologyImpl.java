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

package com.google.cloud.apptopology.v1;

import com.google.api.core.BetaApi;
import com.google.cloud.apptopology.v1.AppTopologyGrpc.AppTopologyImplBase;
import com.google.protobuf.AbstractMessage;
import io.grpc.stub.StreamObserver;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import javax.annotation.Generated;

@BetaApi
@Generated("by gapic-generator-java")
public class MockAppTopologyImpl extends AppTopologyImplBase {
  private List<AbstractMessage> requests;
  private Queue<Object> responses;

  public MockAppTopologyImpl() {
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
  public void generateDiscoveredResourcesTopology(
      GenerateDiscoveredResourcesTopologyRequest request,
      StreamObserver<GenerateDiscoveredResourcesTopologyResponse> responseObserver) {
    Object response = responses.poll();
    if (response instanceof GenerateDiscoveredResourcesTopologyResponse) {
      requests.add(request);
      responseObserver.onNext(((GenerateDiscoveredResourcesTopologyResponse) response));
      responseObserver.onCompleted();
    } else if (response instanceof Exception) {
      responseObserver.onError(((Exception) response));
    } else {
      responseObserver.onError(
          new IllegalArgumentException(
              String.format(
                  "Unrecognized response type %s for method GenerateDiscoveredResourcesTopology,"
                      + " expected %s or %s",
                  response == null ? "null" : response.getClass().getName(),
                  GenerateDiscoveredResourcesTopologyResponse.class.getName(),
                  Exception.class.getName())));
    }
  }

  @Override
  public void getSchema(GetSchemaRequest request, StreamObserver<Schema> responseObserver) {
    Object response = responses.poll();
    if (response instanceof Schema) {
      requests.add(request);
      responseObserver.onNext(((Schema) response));
      responseObserver.onCompleted();
    } else if (response instanceof Exception) {
      responseObserver.onError(((Exception) response));
    } else {
      responseObserver.onError(
          new IllegalArgumentException(
              String.format(
                  "Unrecognized response type %s for method GetSchema, expected %s or %s",
                  response == null ? "null" : response.getClass().getName(),
                  Schema.class.getName(),
                  Exception.class.getName())));
    }
  }

  @Override
  public void getDomain(GetDomainRequest request, StreamObserver<Domain> responseObserver) {
    Object response = responses.poll();
    if (response instanceof Domain) {
      requests.add(request);
      responseObserver.onNext(((Domain) response));
      responseObserver.onCompleted();
    } else if (response instanceof Exception) {
      responseObserver.onError(((Exception) response));
    } else {
      responseObserver.onError(
          new IllegalArgumentException(
              String.format(
                  "Unrecognized response type %s for method GetDomain, expected %s or %s",
                  response == null ? "null" : response.getClass().getName(),
                  Domain.class.getName(),
                  Exception.class.getName())));
    }
  }

  @Override
  public void listDomains(
      ListDomainsRequest request, StreamObserver<ListDomainsResponse> responseObserver) {
    Object response = responses.poll();
    if (response instanceof ListDomainsResponse) {
      requests.add(request);
      responseObserver.onNext(((ListDomainsResponse) response));
      responseObserver.onCompleted();
    } else if (response instanceof Exception) {
      responseObserver.onError(((Exception) response));
    } else {
      responseObserver.onError(
          new IllegalArgumentException(
              String.format(
                  "Unrecognized response type %s for method ListDomains, expected %s or %s",
                  response == null ? "null" : response.getClass().getName(),
                  ListDomainsResponse.class.getName(),
                  Exception.class.getName())));
    }
  }
}
