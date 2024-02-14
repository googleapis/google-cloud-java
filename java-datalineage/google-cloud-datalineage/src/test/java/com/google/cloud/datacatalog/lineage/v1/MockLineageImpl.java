/*
 * Copyright 2024 Google LLC
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

package com.google.cloud.datacatalog.lineage.v1;

import com.google.api.core.BetaApi;
import com.google.cloud.datacatalog.lineage.v1.LineageGrpc.LineageImplBase;
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
public class MockLineageImpl extends LineageImplBase {
  private List<AbstractMessage> requests;
  private Queue<Object> responses;

  public MockLineageImpl() {
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
  public void processOpenLineageRunEvent(
      ProcessOpenLineageRunEventRequest request,
      StreamObserver<ProcessOpenLineageRunEventResponse> responseObserver) {
    Object response = responses.poll();
    if (response instanceof ProcessOpenLineageRunEventResponse) {
      requests.add(request);
      responseObserver.onNext(((ProcessOpenLineageRunEventResponse) response));
      responseObserver.onCompleted();
    } else if (response instanceof Exception) {
      responseObserver.onError(((Exception) response));
    } else {
      responseObserver.onError(
          new IllegalArgumentException(
              String.format(
                  "Unrecognized response type %s for method ProcessOpenLineageRunEvent, expected %s or %s",
                  response == null ? "null" : response.getClass().getName(),
                  ProcessOpenLineageRunEventResponse.class.getName(),
                  Exception.class.getName())));
    }
  }

  @Override
  public void createProcess(
      CreateProcessRequest request, StreamObserver<Process> responseObserver) {
    Object response = responses.poll();
    if (response instanceof Process) {
      requests.add(request);
      responseObserver.onNext(((Process) response));
      responseObserver.onCompleted();
    } else if (response instanceof Exception) {
      responseObserver.onError(((Exception) response));
    } else {
      responseObserver.onError(
          new IllegalArgumentException(
              String.format(
                  "Unrecognized response type %s for method CreateProcess, expected %s or %s",
                  response == null ? "null" : response.getClass().getName(),
                  Process.class.getName(),
                  Exception.class.getName())));
    }
  }

  @Override
  public void updateProcess(
      UpdateProcessRequest request, StreamObserver<Process> responseObserver) {
    Object response = responses.poll();
    if (response instanceof Process) {
      requests.add(request);
      responseObserver.onNext(((Process) response));
      responseObserver.onCompleted();
    } else if (response instanceof Exception) {
      responseObserver.onError(((Exception) response));
    } else {
      responseObserver.onError(
          new IllegalArgumentException(
              String.format(
                  "Unrecognized response type %s for method UpdateProcess, expected %s or %s",
                  response == null ? "null" : response.getClass().getName(),
                  Process.class.getName(),
                  Exception.class.getName())));
    }
  }

  @Override
  public void getProcess(GetProcessRequest request, StreamObserver<Process> responseObserver) {
    Object response = responses.poll();
    if (response instanceof Process) {
      requests.add(request);
      responseObserver.onNext(((Process) response));
      responseObserver.onCompleted();
    } else if (response instanceof Exception) {
      responseObserver.onError(((Exception) response));
    } else {
      responseObserver.onError(
          new IllegalArgumentException(
              String.format(
                  "Unrecognized response type %s for method GetProcess, expected %s or %s",
                  response == null ? "null" : response.getClass().getName(),
                  Process.class.getName(),
                  Exception.class.getName())));
    }
  }

  @Override
  public void listProcesses(
      ListProcessesRequest request, StreamObserver<ListProcessesResponse> responseObserver) {
    Object response = responses.poll();
    if (response instanceof ListProcessesResponse) {
      requests.add(request);
      responseObserver.onNext(((ListProcessesResponse) response));
      responseObserver.onCompleted();
    } else if (response instanceof Exception) {
      responseObserver.onError(((Exception) response));
    } else {
      responseObserver.onError(
          new IllegalArgumentException(
              String.format(
                  "Unrecognized response type %s for method ListProcesses, expected %s or %s",
                  response == null ? "null" : response.getClass().getName(),
                  ListProcessesResponse.class.getName(),
                  Exception.class.getName())));
    }
  }

  @Override
  public void deleteProcess(
      DeleteProcessRequest request, StreamObserver<Operation> responseObserver) {
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
                  "Unrecognized response type %s for method DeleteProcess, expected %s or %s",
                  response == null ? "null" : response.getClass().getName(),
                  Operation.class.getName(),
                  Exception.class.getName())));
    }
  }

  @Override
  public void createRun(CreateRunRequest request, StreamObserver<Run> responseObserver) {
    Object response = responses.poll();
    if (response instanceof Run) {
      requests.add(request);
      responseObserver.onNext(((Run) response));
      responseObserver.onCompleted();
    } else if (response instanceof Exception) {
      responseObserver.onError(((Exception) response));
    } else {
      responseObserver.onError(
          new IllegalArgumentException(
              String.format(
                  "Unrecognized response type %s for method CreateRun, expected %s or %s",
                  response == null ? "null" : response.getClass().getName(),
                  Run.class.getName(),
                  Exception.class.getName())));
    }
  }

  @Override
  public void updateRun(UpdateRunRequest request, StreamObserver<Run> responseObserver) {
    Object response = responses.poll();
    if (response instanceof Run) {
      requests.add(request);
      responseObserver.onNext(((Run) response));
      responseObserver.onCompleted();
    } else if (response instanceof Exception) {
      responseObserver.onError(((Exception) response));
    } else {
      responseObserver.onError(
          new IllegalArgumentException(
              String.format(
                  "Unrecognized response type %s for method UpdateRun, expected %s or %s",
                  response == null ? "null" : response.getClass().getName(),
                  Run.class.getName(),
                  Exception.class.getName())));
    }
  }

  @Override
  public void getRun(GetRunRequest request, StreamObserver<Run> responseObserver) {
    Object response = responses.poll();
    if (response instanceof Run) {
      requests.add(request);
      responseObserver.onNext(((Run) response));
      responseObserver.onCompleted();
    } else if (response instanceof Exception) {
      responseObserver.onError(((Exception) response));
    } else {
      responseObserver.onError(
          new IllegalArgumentException(
              String.format(
                  "Unrecognized response type %s for method GetRun, expected %s or %s",
                  response == null ? "null" : response.getClass().getName(),
                  Run.class.getName(),
                  Exception.class.getName())));
    }
  }

  @Override
  public void listRuns(ListRunsRequest request, StreamObserver<ListRunsResponse> responseObserver) {
    Object response = responses.poll();
    if (response instanceof ListRunsResponse) {
      requests.add(request);
      responseObserver.onNext(((ListRunsResponse) response));
      responseObserver.onCompleted();
    } else if (response instanceof Exception) {
      responseObserver.onError(((Exception) response));
    } else {
      responseObserver.onError(
          new IllegalArgumentException(
              String.format(
                  "Unrecognized response type %s for method ListRuns, expected %s or %s",
                  response == null ? "null" : response.getClass().getName(),
                  ListRunsResponse.class.getName(),
                  Exception.class.getName())));
    }
  }

  @Override
  public void deleteRun(DeleteRunRequest request, StreamObserver<Operation> responseObserver) {
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
                  "Unrecognized response type %s for method DeleteRun, expected %s or %s",
                  response == null ? "null" : response.getClass().getName(),
                  Operation.class.getName(),
                  Exception.class.getName())));
    }
  }

  @Override
  public void createLineageEvent(
      CreateLineageEventRequest request, StreamObserver<LineageEvent> responseObserver) {
    Object response = responses.poll();
    if (response instanceof LineageEvent) {
      requests.add(request);
      responseObserver.onNext(((LineageEvent) response));
      responseObserver.onCompleted();
    } else if (response instanceof Exception) {
      responseObserver.onError(((Exception) response));
    } else {
      responseObserver.onError(
          new IllegalArgumentException(
              String.format(
                  "Unrecognized response type %s for method CreateLineageEvent, expected %s or %s",
                  response == null ? "null" : response.getClass().getName(),
                  LineageEvent.class.getName(),
                  Exception.class.getName())));
    }
  }

  @Override
  public void getLineageEvent(
      GetLineageEventRequest request, StreamObserver<LineageEvent> responseObserver) {
    Object response = responses.poll();
    if (response instanceof LineageEvent) {
      requests.add(request);
      responseObserver.onNext(((LineageEvent) response));
      responseObserver.onCompleted();
    } else if (response instanceof Exception) {
      responseObserver.onError(((Exception) response));
    } else {
      responseObserver.onError(
          new IllegalArgumentException(
              String.format(
                  "Unrecognized response type %s for method GetLineageEvent, expected %s or %s",
                  response == null ? "null" : response.getClass().getName(),
                  LineageEvent.class.getName(),
                  Exception.class.getName())));
    }
  }

  @Override
  public void listLineageEvents(
      ListLineageEventsRequest request,
      StreamObserver<ListLineageEventsResponse> responseObserver) {
    Object response = responses.poll();
    if (response instanceof ListLineageEventsResponse) {
      requests.add(request);
      responseObserver.onNext(((ListLineageEventsResponse) response));
      responseObserver.onCompleted();
    } else if (response instanceof Exception) {
      responseObserver.onError(((Exception) response));
    } else {
      responseObserver.onError(
          new IllegalArgumentException(
              String.format(
                  "Unrecognized response type %s for method ListLineageEvents, expected %s or %s",
                  response == null ? "null" : response.getClass().getName(),
                  ListLineageEventsResponse.class.getName(),
                  Exception.class.getName())));
    }
  }

  @Override
  public void deleteLineageEvent(
      DeleteLineageEventRequest request, StreamObserver<Empty> responseObserver) {
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
                  "Unrecognized response type %s for method DeleteLineageEvent, expected %s or %s",
                  response == null ? "null" : response.getClass().getName(),
                  Empty.class.getName(),
                  Exception.class.getName())));
    }
  }

  @Override
  public void searchLinks(
      SearchLinksRequest request, StreamObserver<SearchLinksResponse> responseObserver) {
    Object response = responses.poll();
    if (response instanceof SearchLinksResponse) {
      requests.add(request);
      responseObserver.onNext(((SearchLinksResponse) response));
      responseObserver.onCompleted();
    } else if (response instanceof Exception) {
      responseObserver.onError(((Exception) response));
    } else {
      responseObserver.onError(
          new IllegalArgumentException(
              String.format(
                  "Unrecognized response type %s for method SearchLinks, expected %s or %s",
                  response == null ? "null" : response.getClass().getName(),
                  SearchLinksResponse.class.getName(),
                  Exception.class.getName())));
    }
  }

  @Override
  public void batchSearchLinkProcesses(
      BatchSearchLinkProcessesRequest request,
      StreamObserver<BatchSearchLinkProcessesResponse> responseObserver) {
    Object response = responses.poll();
    if (response instanceof BatchSearchLinkProcessesResponse) {
      requests.add(request);
      responseObserver.onNext(((BatchSearchLinkProcessesResponse) response));
      responseObserver.onCompleted();
    } else if (response instanceof Exception) {
      responseObserver.onError(((Exception) response));
    } else {
      responseObserver.onError(
          new IllegalArgumentException(
              String.format(
                  "Unrecognized response type %s for method BatchSearchLinkProcesses, expected %s or %s",
                  response == null ? "null" : response.getClass().getName(),
                  BatchSearchLinkProcessesResponse.class.getName(),
                  Exception.class.getName())));
    }
  }
}
