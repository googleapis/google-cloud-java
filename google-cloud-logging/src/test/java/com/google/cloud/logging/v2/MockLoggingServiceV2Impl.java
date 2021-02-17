/*
 * Copyright 2020 Google LLC
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

package com.google.cloud.logging.v2;

import com.google.api.core.BetaApi;
import com.google.logging.v2.DeleteLogRequest;
import com.google.logging.v2.ListLogEntriesRequest;
import com.google.logging.v2.ListLogEntriesResponse;
import com.google.logging.v2.ListLogsRequest;
import com.google.logging.v2.ListLogsResponse;
import com.google.logging.v2.ListMonitoredResourceDescriptorsRequest;
import com.google.logging.v2.ListMonitoredResourceDescriptorsResponse;
import com.google.logging.v2.LoggingServiceV2Grpc.LoggingServiceV2ImplBase;
import com.google.logging.v2.TailLogEntriesRequest;
import com.google.logging.v2.TailLogEntriesResponse;
import com.google.logging.v2.WriteLogEntriesRequest;
import com.google.logging.v2.WriteLogEntriesResponse;
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
public class MockLoggingServiceV2Impl extends LoggingServiceV2ImplBase {
  private List<AbstractMessage> requests;
  private Queue<Object> responses;

  public MockLoggingServiceV2Impl() {
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
  public void deleteLog(DeleteLogRequest request, StreamObserver<Empty> responseObserver) {
    Object response = responses.remove();
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
                  "Unrecognized response type %s for method DeleteLog, expected %s or %s",
                  response.getClass().getName(),
                  Empty.class.getName(),
                  Exception.class.getName())));
    }
  }

  @Override
  public void writeLogEntries(
      WriteLogEntriesRequest request, StreamObserver<WriteLogEntriesResponse> responseObserver) {
    Object response = responses.remove();
    if (response instanceof WriteLogEntriesResponse) {
      requests.add(request);
      responseObserver.onNext(((WriteLogEntriesResponse) response));
      responseObserver.onCompleted();
    } else if (response instanceof Exception) {
      responseObserver.onError(((Exception) response));
    } else {
      responseObserver.onError(
          new IllegalArgumentException(
              String.format(
                  "Unrecognized response type %s for method WriteLogEntries, expected %s or %s",
                  response.getClass().getName(),
                  WriteLogEntriesResponse.class.getName(),
                  Exception.class.getName())));
    }
  }

  @Override
  public void listLogEntries(
      ListLogEntriesRequest request, StreamObserver<ListLogEntriesResponse> responseObserver) {
    Object response = responses.remove();
    if (response instanceof ListLogEntriesResponse) {
      requests.add(request);
      responseObserver.onNext(((ListLogEntriesResponse) response));
      responseObserver.onCompleted();
    } else if (response instanceof Exception) {
      responseObserver.onError(((Exception) response));
    } else {
      responseObserver.onError(
          new IllegalArgumentException(
              String.format(
                  "Unrecognized response type %s for method ListLogEntries, expected %s or %s",
                  response.getClass().getName(),
                  ListLogEntriesResponse.class.getName(),
                  Exception.class.getName())));
    }
  }

  @Override
  public void listMonitoredResourceDescriptors(
      ListMonitoredResourceDescriptorsRequest request,
      StreamObserver<ListMonitoredResourceDescriptorsResponse> responseObserver) {
    Object response = responses.remove();
    if (response instanceof ListMonitoredResourceDescriptorsResponse) {
      requests.add(request);
      responseObserver.onNext(((ListMonitoredResourceDescriptorsResponse) response));
      responseObserver.onCompleted();
    } else if (response instanceof Exception) {
      responseObserver.onError(((Exception) response));
    } else {
      responseObserver.onError(
          new IllegalArgumentException(
              String.format(
                  "Unrecognized response type %s for method ListMonitoredResourceDescriptors, expected %s or %s",
                  response.getClass().getName(),
                  ListMonitoredResourceDescriptorsResponse.class.getName(),
                  Exception.class.getName())));
    }
  }

  @Override
  public void listLogs(ListLogsRequest request, StreamObserver<ListLogsResponse> responseObserver) {
    Object response = responses.remove();
    if (response instanceof ListLogsResponse) {
      requests.add(request);
      responseObserver.onNext(((ListLogsResponse) response));
      responseObserver.onCompleted();
    } else if (response instanceof Exception) {
      responseObserver.onError(((Exception) response));
    } else {
      responseObserver.onError(
          new IllegalArgumentException(
              String.format(
                  "Unrecognized response type %s for method ListLogs, expected %s or %s",
                  response.getClass().getName(),
                  ListLogsResponse.class.getName(),
                  Exception.class.getName())));
    }
  }

  @Override
  public StreamObserver<TailLogEntriesRequest> tailLogEntries(
      final StreamObserver<TailLogEntriesResponse> responseObserver) {
    StreamObserver<TailLogEntriesRequest> requestObserver =
        new StreamObserver<TailLogEntriesRequest>() {
          @Override
          public void onNext(TailLogEntriesRequest value) {
            requests.add(value);
            final Object response = responses.remove();
            if (response instanceof TailLogEntriesResponse) {
              responseObserver.onNext(((TailLogEntriesResponse) response));
            } else if (response instanceof Exception) {
              responseObserver.onError(((Exception) response));
            } else {
              responseObserver.onError(
                  new IllegalArgumentException(
                      String.format(
                          "Unrecognized response type %s for method TailLogEntries, expected %s or %s",
                          response.getClass().getName(),
                          TailLogEntriesResponse.class.getName(),
                          Exception.class.getName())));
            }
          }

          @Override
          public void onError(Throwable t) {
            responseObserver.onError(t);
          }

          @Override
          public void onCompleted() {
            responseObserver.onCompleted();
          }
        };
    return requestObserver;
  }
}
