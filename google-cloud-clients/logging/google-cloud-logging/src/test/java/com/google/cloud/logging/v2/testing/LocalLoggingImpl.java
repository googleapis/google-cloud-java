/*
 * Copyright 2016 Google LLC
 *
 * Licensed under the Apache License, Version 2.0 (the "License"); you may not use this file except
 * in compliance with the License. You may obtain a copy of the License at
 *
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software distributed under the License
 * is distributed on an "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express
 * or implied. See the License for the specific language governing permissions and limitations under
 * the License.
 */

package com.google.cloud.logging.v2.testing;

import com.google.logging.v2.DeleteLogRequest;
import com.google.logging.v2.ListLogEntriesRequest;
import com.google.logging.v2.ListLogEntriesResponse;
import com.google.logging.v2.ListMonitoredResourceDescriptorsRequest;
import com.google.logging.v2.ListMonitoredResourceDescriptorsResponse;
import com.google.logging.v2.LogEntry;
import com.google.logging.v2.LoggingServiceV2Grpc;
import com.google.logging.v2.WriteLogEntriesRequest;
import com.google.logging.v2.WriteLogEntriesResponse;
import com.google.protobuf.ByteString;
import com.google.protobuf.Empty;
import io.grpc.stub.StreamObserver;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class LocalLoggingImpl extends LoggingServiceV2Grpc.LoggingServiceV2ImplBase {

  private Map<String, List<LogEntry>> logs = new HashMap<>();

  @Override
  public void deleteLog(DeleteLogRequest request, StreamObserver<Empty> responseObserver) {
    logs.remove(request.getLogName());
    responseObserver.onNext(Empty.getDefaultInstance());
    responseObserver.onCompleted();
  }

  @Override
  public void writeLogEntries(
      WriteLogEntriesRequest request, StreamObserver<WriteLogEntriesResponse> responseObserver) {
    List<LogEntry> entries = logs.get(request.getLogName());
    if (entries == null) {
      entries = new ArrayList<LogEntry>();
      logs.put(request.getLogName(), entries);
    }
    entries.addAll(request.getEntriesList());
    // Response is empty
    responseObserver.onNext(WriteLogEntriesResponse.newBuilder().build());
    responseObserver.onCompleted();
  }

  @Override
  public void listLogEntries(
      ListLogEntriesRequest request, StreamObserver<ListLogEntriesResponse> responseObserver) {
    List<LogEntry> entries = new ArrayList<>();

    for (ByteString proj : request.getProjectIdsList().asByteStringList()) {
      String prefix = "projects/" + proj.toStringUtf8() + "/";
      for (Map.Entry<String, List<LogEntry>> entry : logs.entrySet()) {
        if (entry.getKey().startsWith(prefix)) {
          entries.addAll(entry.getValue());
        }
      }
    }
    responseObserver.onNext(ListLogEntriesResponse.newBuilder().addAllEntries(entries).build());
    responseObserver.onCompleted();
  }

  @Override
  public void listMonitoredResourceDescriptors(
      ListMonitoredResourceDescriptorsRequest request,
      StreamObserver<ListMonitoredResourceDescriptorsResponse> responseObserver) {
    throw new UnsupportedOperationException();
  }

  public void reset() {
    logs.clear();
  }
}
