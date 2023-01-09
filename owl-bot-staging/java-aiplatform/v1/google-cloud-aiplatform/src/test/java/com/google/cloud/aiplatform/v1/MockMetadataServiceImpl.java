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

package com.google.cloud.aiplatform.v1;

import com.google.api.core.BetaApi;
import com.google.cloud.aiplatform.v1.MetadataServiceGrpc.MetadataServiceImplBase;
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
public class MockMetadataServiceImpl extends MetadataServiceImplBase {
  private List<AbstractMessage> requests;
  private Queue<Object> responses;

  public MockMetadataServiceImpl() {
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
  public void createMetadataStore(
      CreateMetadataStoreRequest request, StreamObserver<Operation> responseObserver) {
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
                  "Unrecognized response type %s for method CreateMetadataStore, expected %s or %s",
                  response == null ? "null" : response.getClass().getName(),
                  Operation.class.getName(),
                  Exception.class.getName())));
    }
  }

  @Override
  public void getMetadataStore(
      GetMetadataStoreRequest request, StreamObserver<MetadataStore> responseObserver) {
    Object response = responses.poll();
    if (response instanceof MetadataStore) {
      requests.add(request);
      responseObserver.onNext(((MetadataStore) response));
      responseObserver.onCompleted();
    } else if (response instanceof Exception) {
      responseObserver.onError(((Exception) response));
    } else {
      responseObserver.onError(
          new IllegalArgumentException(
              String.format(
                  "Unrecognized response type %s for method GetMetadataStore, expected %s or %s",
                  response == null ? "null" : response.getClass().getName(),
                  MetadataStore.class.getName(),
                  Exception.class.getName())));
    }
  }

  @Override
  public void listMetadataStores(
      ListMetadataStoresRequest request,
      StreamObserver<ListMetadataStoresResponse> responseObserver) {
    Object response = responses.poll();
    if (response instanceof ListMetadataStoresResponse) {
      requests.add(request);
      responseObserver.onNext(((ListMetadataStoresResponse) response));
      responseObserver.onCompleted();
    } else if (response instanceof Exception) {
      responseObserver.onError(((Exception) response));
    } else {
      responseObserver.onError(
          new IllegalArgumentException(
              String.format(
                  "Unrecognized response type %s for method ListMetadataStores, expected %s or %s",
                  response == null ? "null" : response.getClass().getName(),
                  ListMetadataStoresResponse.class.getName(),
                  Exception.class.getName())));
    }
  }

  @Override
  public void deleteMetadataStore(
      DeleteMetadataStoreRequest request, StreamObserver<Operation> responseObserver) {
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
                  "Unrecognized response type %s for method DeleteMetadataStore, expected %s or %s",
                  response == null ? "null" : response.getClass().getName(),
                  Operation.class.getName(),
                  Exception.class.getName())));
    }
  }

  @Override
  public void createArtifact(
      CreateArtifactRequest request, StreamObserver<Artifact> responseObserver) {
    Object response = responses.poll();
    if (response instanceof Artifact) {
      requests.add(request);
      responseObserver.onNext(((Artifact) response));
      responseObserver.onCompleted();
    } else if (response instanceof Exception) {
      responseObserver.onError(((Exception) response));
    } else {
      responseObserver.onError(
          new IllegalArgumentException(
              String.format(
                  "Unrecognized response type %s for method CreateArtifact, expected %s or %s",
                  response == null ? "null" : response.getClass().getName(),
                  Artifact.class.getName(),
                  Exception.class.getName())));
    }
  }

  @Override
  public void getArtifact(GetArtifactRequest request, StreamObserver<Artifact> responseObserver) {
    Object response = responses.poll();
    if (response instanceof Artifact) {
      requests.add(request);
      responseObserver.onNext(((Artifact) response));
      responseObserver.onCompleted();
    } else if (response instanceof Exception) {
      responseObserver.onError(((Exception) response));
    } else {
      responseObserver.onError(
          new IllegalArgumentException(
              String.format(
                  "Unrecognized response type %s for method GetArtifact, expected %s or %s",
                  response == null ? "null" : response.getClass().getName(),
                  Artifact.class.getName(),
                  Exception.class.getName())));
    }
  }

  @Override
  public void listArtifacts(
      ListArtifactsRequest request, StreamObserver<ListArtifactsResponse> responseObserver) {
    Object response = responses.poll();
    if (response instanceof ListArtifactsResponse) {
      requests.add(request);
      responseObserver.onNext(((ListArtifactsResponse) response));
      responseObserver.onCompleted();
    } else if (response instanceof Exception) {
      responseObserver.onError(((Exception) response));
    } else {
      responseObserver.onError(
          new IllegalArgumentException(
              String.format(
                  "Unrecognized response type %s for method ListArtifacts, expected %s or %s",
                  response == null ? "null" : response.getClass().getName(),
                  ListArtifactsResponse.class.getName(),
                  Exception.class.getName())));
    }
  }

  @Override
  public void updateArtifact(
      UpdateArtifactRequest request, StreamObserver<Artifact> responseObserver) {
    Object response = responses.poll();
    if (response instanceof Artifact) {
      requests.add(request);
      responseObserver.onNext(((Artifact) response));
      responseObserver.onCompleted();
    } else if (response instanceof Exception) {
      responseObserver.onError(((Exception) response));
    } else {
      responseObserver.onError(
          new IllegalArgumentException(
              String.format(
                  "Unrecognized response type %s for method UpdateArtifact, expected %s or %s",
                  response == null ? "null" : response.getClass().getName(),
                  Artifact.class.getName(),
                  Exception.class.getName())));
    }
  }

  @Override
  public void deleteArtifact(
      DeleteArtifactRequest request, StreamObserver<Operation> responseObserver) {
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
                  "Unrecognized response type %s for method DeleteArtifact, expected %s or %s",
                  response == null ? "null" : response.getClass().getName(),
                  Operation.class.getName(),
                  Exception.class.getName())));
    }
  }

  @Override
  public void purgeArtifacts(
      PurgeArtifactsRequest request, StreamObserver<Operation> responseObserver) {
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
                  "Unrecognized response type %s for method PurgeArtifacts, expected %s or %s",
                  response == null ? "null" : response.getClass().getName(),
                  Operation.class.getName(),
                  Exception.class.getName())));
    }
  }

  @Override
  public void createContext(
      CreateContextRequest request, StreamObserver<Context> responseObserver) {
    Object response = responses.poll();
    if (response instanceof Context) {
      requests.add(request);
      responseObserver.onNext(((Context) response));
      responseObserver.onCompleted();
    } else if (response instanceof Exception) {
      responseObserver.onError(((Exception) response));
    } else {
      responseObserver.onError(
          new IllegalArgumentException(
              String.format(
                  "Unrecognized response type %s for method CreateContext, expected %s or %s",
                  response == null ? "null" : response.getClass().getName(),
                  Context.class.getName(),
                  Exception.class.getName())));
    }
  }

  @Override
  public void getContext(GetContextRequest request, StreamObserver<Context> responseObserver) {
    Object response = responses.poll();
    if (response instanceof Context) {
      requests.add(request);
      responseObserver.onNext(((Context) response));
      responseObserver.onCompleted();
    } else if (response instanceof Exception) {
      responseObserver.onError(((Exception) response));
    } else {
      responseObserver.onError(
          new IllegalArgumentException(
              String.format(
                  "Unrecognized response type %s for method GetContext, expected %s or %s",
                  response == null ? "null" : response.getClass().getName(),
                  Context.class.getName(),
                  Exception.class.getName())));
    }
  }

  @Override
  public void listContexts(
      ListContextsRequest request, StreamObserver<ListContextsResponse> responseObserver) {
    Object response = responses.poll();
    if (response instanceof ListContextsResponse) {
      requests.add(request);
      responseObserver.onNext(((ListContextsResponse) response));
      responseObserver.onCompleted();
    } else if (response instanceof Exception) {
      responseObserver.onError(((Exception) response));
    } else {
      responseObserver.onError(
          new IllegalArgumentException(
              String.format(
                  "Unrecognized response type %s for method ListContexts, expected %s or %s",
                  response == null ? "null" : response.getClass().getName(),
                  ListContextsResponse.class.getName(),
                  Exception.class.getName())));
    }
  }

  @Override
  public void updateContext(
      UpdateContextRequest request, StreamObserver<Context> responseObserver) {
    Object response = responses.poll();
    if (response instanceof Context) {
      requests.add(request);
      responseObserver.onNext(((Context) response));
      responseObserver.onCompleted();
    } else if (response instanceof Exception) {
      responseObserver.onError(((Exception) response));
    } else {
      responseObserver.onError(
          new IllegalArgumentException(
              String.format(
                  "Unrecognized response type %s for method UpdateContext, expected %s or %s",
                  response == null ? "null" : response.getClass().getName(),
                  Context.class.getName(),
                  Exception.class.getName())));
    }
  }

  @Override
  public void deleteContext(
      DeleteContextRequest request, StreamObserver<Operation> responseObserver) {
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
                  "Unrecognized response type %s for method DeleteContext, expected %s or %s",
                  response == null ? "null" : response.getClass().getName(),
                  Operation.class.getName(),
                  Exception.class.getName())));
    }
  }

  @Override
  public void purgeContexts(
      PurgeContextsRequest request, StreamObserver<Operation> responseObserver) {
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
                  "Unrecognized response type %s for method PurgeContexts, expected %s or %s",
                  response == null ? "null" : response.getClass().getName(),
                  Operation.class.getName(),
                  Exception.class.getName())));
    }
  }

  @Override
  public void addContextArtifactsAndExecutions(
      AddContextArtifactsAndExecutionsRequest request,
      StreamObserver<AddContextArtifactsAndExecutionsResponse> responseObserver) {
    Object response = responses.poll();
    if (response instanceof AddContextArtifactsAndExecutionsResponse) {
      requests.add(request);
      responseObserver.onNext(((AddContextArtifactsAndExecutionsResponse) response));
      responseObserver.onCompleted();
    } else if (response instanceof Exception) {
      responseObserver.onError(((Exception) response));
    } else {
      responseObserver.onError(
          new IllegalArgumentException(
              String.format(
                  "Unrecognized response type %s for method AddContextArtifactsAndExecutions, expected %s or %s",
                  response == null ? "null" : response.getClass().getName(),
                  AddContextArtifactsAndExecutionsResponse.class.getName(),
                  Exception.class.getName())));
    }
  }

  @Override
  public void addContextChildren(
      AddContextChildrenRequest request,
      StreamObserver<AddContextChildrenResponse> responseObserver) {
    Object response = responses.poll();
    if (response instanceof AddContextChildrenResponse) {
      requests.add(request);
      responseObserver.onNext(((AddContextChildrenResponse) response));
      responseObserver.onCompleted();
    } else if (response instanceof Exception) {
      responseObserver.onError(((Exception) response));
    } else {
      responseObserver.onError(
          new IllegalArgumentException(
              String.format(
                  "Unrecognized response type %s for method AddContextChildren, expected %s or %s",
                  response == null ? "null" : response.getClass().getName(),
                  AddContextChildrenResponse.class.getName(),
                  Exception.class.getName())));
    }
  }

  @Override
  public void removeContextChildren(
      RemoveContextChildrenRequest request,
      StreamObserver<RemoveContextChildrenResponse> responseObserver) {
    Object response = responses.poll();
    if (response instanceof RemoveContextChildrenResponse) {
      requests.add(request);
      responseObserver.onNext(((RemoveContextChildrenResponse) response));
      responseObserver.onCompleted();
    } else if (response instanceof Exception) {
      responseObserver.onError(((Exception) response));
    } else {
      responseObserver.onError(
          new IllegalArgumentException(
              String.format(
                  "Unrecognized response type %s for method RemoveContextChildren, expected %s or %s",
                  response == null ? "null" : response.getClass().getName(),
                  RemoveContextChildrenResponse.class.getName(),
                  Exception.class.getName())));
    }
  }

  @Override
  public void queryContextLineageSubgraph(
      QueryContextLineageSubgraphRequest request,
      StreamObserver<LineageSubgraph> responseObserver) {
    Object response = responses.poll();
    if (response instanceof LineageSubgraph) {
      requests.add(request);
      responseObserver.onNext(((LineageSubgraph) response));
      responseObserver.onCompleted();
    } else if (response instanceof Exception) {
      responseObserver.onError(((Exception) response));
    } else {
      responseObserver.onError(
          new IllegalArgumentException(
              String.format(
                  "Unrecognized response type %s for method QueryContextLineageSubgraph, expected %s or %s",
                  response == null ? "null" : response.getClass().getName(),
                  LineageSubgraph.class.getName(),
                  Exception.class.getName())));
    }
  }

  @Override
  public void createExecution(
      CreateExecutionRequest request, StreamObserver<Execution> responseObserver) {
    Object response = responses.poll();
    if (response instanceof Execution) {
      requests.add(request);
      responseObserver.onNext(((Execution) response));
      responseObserver.onCompleted();
    } else if (response instanceof Exception) {
      responseObserver.onError(((Exception) response));
    } else {
      responseObserver.onError(
          new IllegalArgumentException(
              String.format(
                  "Unrecognized response type %s for method CreateExecution, expected %s or %s",
                  response == null ? "null" : response.getClass().getName(),
                  Execution.class.getName(),
                  Exception.class.getName())));
    }
  }

  @Override
  public void getExecution(
      GetExecutionRequest request, StreamObserver<Execution> responseObserver) {
    Object response = responses.poll();
    if (response instanceof Execution) {
      requests.add(request);
      responseObserver.onNext(((Execution) response));
      responseObserver.onCompleted();
    } else if (response instanceof Exception) {
      responseObserver.onError(((Exception) response));
    } else {
      responseObserver.onError(
          new IllegalArgumentException(
              String.format(
                  "Unrecognized response type %s for method GetExecution, expected %s or %s",
                  response == null ? "null" : response.getClass().getName(),
                  Execution.class.getName(),
                  Exception.class.getName())));
    }
  }

  @Override
  public void listExecutions(
      ListExecutionsRequest request, StreamObserver<ListExecutionsResponse> responseObserver) {
    Object response = responses.poll();
    if (response instanceof ListExecutionsResponse) {
      requests.add(request);
      responseObserver.onNext(((ListExecutionsResponse) response));
      responseObserver.onCompleted();
    } else if (response instanceof Exception) {
      responseObserver.onError(((Exception) response));
    } else {
      responseObserver.onError(
          new IllegalArgumentException(
              String.format(
                  "Unrecognized response type %s for method ListExecutions, expected %s or %s",
                  response == null ? "null" : response.getClass().getName(),
                  ListExecutionsResponse.class.getName(),
                  Exception.class.getName())));
    }
  }

  @Override
  public void updateExecution(
      UpdateExecutionRequest request, StreamObserver<Execution> responseObserver) {
    Object response = responses.poll();
    if (response instanceof Execution) {
      requests.add(request);
      responseObserver.onNext(((Execution) response));
      responseObserver.onCompleted();
    } else if (response instanceof Exception) {
      responseObserver.onError(((Exception) response));
    } else {
      responseObserver.onError(
          new IllegalArgumentException(
              String.format(
                  "Unrecognized response type %s for method UpdateExecution, expected %s or %s",
                  response == null ? "null" : response.getClass().getName(),
                  Execution.class.getName(),
                  Exception.class.getName())));
    }
  }

  @Override
  public void deleteExecution(
      DeleteExecutionRequest request, StreamObserver<Operation> responseObserver) {
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
                  "Unrecognized response type %s for method DeleteExecution, expected %s or %s",
                  response == null ? "null" : response.getClass().getName(),
                  Operation.class.getName(),
                  Exception.class.getName())));
    }
  }

  @Override
  public void purgeExecutions(
      PurgeExecutionsRequest request, StreamObserver<Operation> responseObserver) {
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
                  "Unrecognized response type %s for method PurgeExecutions, expected %s or %s",
                  response == null ? "null" : response.getClass().getName(),
                  Operation.class.getName(),
                  Exception.class.getName())));
    }
  }

  @Override
  public void addExecutionEvents(
      AddExecutionEventsRequest request,
      StreamObserver<AddExecutionEventsResponse> responseObserver) {
    Object response = responses.poll();
    if (response instanceof AddExecutionEventsResponse) {
      requests.add(request);
      responseObserver.onNext(((AddExecutionEventsResponse) response));
      responseObserver.onCompleted();
    } else if (response instanceof Exception) {
      responseObserver.onError(((Exception) response));
    } else {
      responseObserver.onError(
          new IllegalArgumentException(
              String.format(
                  "Unrecognized response type %s for method AddExecutionEvents, expected %s or %s",
                  response == null ? "null" : response.getClass().getName(),
                  AddExecutionEventsResponse.class.getName(),
                  Exception.class.getName())));
    }
  }

  @Override
  public void queryExecutionInputsAndOutputs(
      QueryExecutionInputsAndOutputsRequest request,
      StreamObserver<LineageSubgraph> responseObserver) {
    Object response = responses.poll();
    if (response instanceof LineageSubgraph) {
      requests.add(request);
      responseObserver.onNext(((LineageSubgraph) response));
      responseObserver.onCompleted();
    } else if (response instanceof Exception) {
      responseObserver.onError(((Exception) response));
    } else {
      responseObserver.onError(
          new IllegalArgumentException(
              String.format(
                  "Unrecognized response type %s for method QueryExecutionInputsAndOutputs, expected %s or %s",
                  response == null ? "null" : response.getClass().getName(),
                  LineageSubgraph.class.getName(),
                  Exception.class.getName())));
    }
  }

  @Override
  public void createMetadataSchema(
      CreateMetadataSchemaRequest request, StreamObserver<MetadataSchema> responseObserver) {
    Object response = responses.poll();
    if (response instanceof MetadataSchema) {
      requests.add(request);
      responseObserver.onNext(((MetadataSchema) response));
      responseObserver.onCompleted();
    } else if (response instanceof Exception) {
      responseObserver.onError(((Exception) response));
    } else {
      responseObserver.onError(
          new IllegalArgumentException(
              String.format(
                  "Unrecognized response type %s for method CreateMetadataSchema, expected %s or %s",
                  response == null ? "null" : response.getClass().getName(),
                  MetadataSchema.class.getName(),
                  Exception.class.getName())));
    }
  }

  @Override
  public void getMetadataSchema(
      GetMetadataSchemaRequest request, StreamObserver<MetadataSchema> responseObserver) {
    Object response = responses.poll();
    if (response instanceof MetadataSchema) {
      requests.add(request);
      responseObserver.onNext(((MetadataSchema) response));
      responseObserver.onCompleted();
    } else if (response instanceof Exception) {
      responseObserver.onError(((Exception) response));
    } else {
      responseObserver.onError(
          new IllegalArgumentException(
              String.format(
                  "Unrecognized response type %s for method GetMetadataSchema, expected %s or %s",
                  response == null ? "null" : response.getClass().getName(),
                  MetadataSchema.class.getName(),
                  Exception.class.getName())));
    }
  }

  @Override
  public void listMetadataSchemas(
      ListMetadataSchemasRequest request,
      StreamObserver<ListMetadataSchemasResponse> responseObserver) {
    Object response = responses.poll();
    if (response instanceof ListMetadataSchemasResponse) {
      requests.add(request);
      responseObserver.onNext(((ListMetadataSchemasResponse) response));
      responseObserver.onCompleted();
    } else if (response instanceof Exception) {
      responseObserver.onError(((Exception) response));
    } else {
      responseObserver.onError(
          new IllegalArgumentException(
              String.format(
                  "Unrecognized response type %s for method ListMetadataSchemas, expected %s or %s",
                  response == null ? "null" : response.getClass().getName(),
                  ListMetadataSchemasResponse.class.getName(),
                  Exception.class.getName())));
    }
  }

  @Override
  public void queryArtifactLineageSubgraph(
      QueryArtifactLineageSubgraphRequest request,
      StreamObserver<LineageSubgraph> responseObserver) {
    Object response = responses.poll();
    if (response instanceof LineageSubgraph) {
      requests.add(request);
      responseObserver.onNext(((LineageSubgraph) response));
      responseObserver.onCompleted();
    } else if (response instanceof Exception) {
      responseObserver.onError(((Exception) response));
    } else {
      responseObserver.onError(
          new IllegalArgumentException(
              String.format(
                  "Unrecognized response type %s for method QueryArtifactLineageSubgraph, expected %s or %s",
                  response == null ? "null" : response.getClass().getName(),
                  LineageSubgraph.class.getName(),
                  Exception.class.getName())));
    }
  }
}
