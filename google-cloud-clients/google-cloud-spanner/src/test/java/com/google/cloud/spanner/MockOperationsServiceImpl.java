/*
 * Copyright 2019 Google LLC
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     https://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package com.google.cloud.spanner;

import com.google.api.gax.grpc.testing.MockGrpcService;
import com.google.common.util.concurrent.MoreExecutors;
import com.google.common.util.concurrent.ThreadFactoryBuilder;
import com.google.longrunning.CancelOperationRequest;
import com.google.longrunning.DeleteOperationRequest;
import com.google.longrunning.GetOperationRequest;
import com.google.longrunning.ListOperationsRequest;
import com.google.longrunning.ListOperationsResponse;
import com.google.longrunning.Operation;
import com.google.longrunning.OperationsGrpc.OperationsImplBase;
import com.google.protobuf.AbstractMessage;
import com.google.protobuf.Empty;
import io.grpc.ServerServiceDefinition;
import io.grpc.Status;
import io.grpc.stub.StreamObserver;
import java.util.Collections;
import java.util.List;
import java.util.concurrent.Callable;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.atomic.AtomicLong;

public class MockOperationsServiceImpl extends OperationsImplBase implements MockGrpcService {
  private final AtomicLong operationCounter = new AtomicLong();
  private final ConcurrentMap<String, Operation> operations = new ConcurrentHashMap<>();
  private final ConcurrentMap<String, Future<?>> futures = new ConcurrentHashMap<>();
  private final ExecutorService executor =
      Executors.newScheduledThreadPool(
          8,
          new ThreadFactoryBuilder()
              .setThreadFactory(MoreExecutors.platformThreadFactory())
              .setNameFormat("mock-operations-%d")
              .setDaemon(true)
              .build());

  String generateOperationName(String parent) {
    return String.format("%s/operations/%d", parent, operationCounter.incrementAndGet());
  }

  <T> Future<T> addOperation(Operation operation, Callable<T> task) {
    operations.put(operation.getName(), operation);
    Future<T> future = executor.submit(task);
    futures.put(operation.getName(), future);
    return future;
  }

  Operation get(String name) {
    return operations.get(name);
  }

  void update(Operation operation) {
    operations.put(operation.getName(), operation);
  }

  Iterable<Operation> iterable() {
    return operations.values();
  }

  @Override
  public void listOperations(
      ListOperationsRequest request, StreamObserver<ListOperationsResponse> responseObserver) {
    ListOperationsResponse.Builder builder = ListOperationsResponse.newBuilder();
    for (Operation op : iterable()) {
      if (op.getName().startsWith(request.getName())) {
        builder.addOperations(op);
      }
    }
    responseObserver.onNext(builder.build());
    responseObserver.onCompleted();
  }

  @Override
  public void getOperation(
      GetOperationRequest request, StreamObserver<Operation> responseObserver) {
    Operation op = operations.get(request.getName());
    if (op != null) {
      responseObserver.onNext(op);
      responseObserver.onCompleted();
    } else {
      responseObserver.onError(Status.NOT_FOUND.asRuntimeException());
    }
  }

  @Override
  public void deleteOperation(
      DeleteOperationRequest request, StreamObserver<Empty> responseObserver) {
    Operation op = operations.get(request.getName());
    if (op != null) {
      if (op.getDone()) {
        if (operations.remove(request.getName(), op)) {
          futures.remove(request.getName());
          responseObserver.onNext(Empty.getDefaultInstance());
          responseObserver.onCompleted();
        } else {
          responseObserver.onError(Status.NOT_FOUND.asRuntimeException());
        }
      } else {
        responseObserver.onError(
            Status.FAILED_PRECONDITION
                .withDescription("Operation is not done")
                .asRuntimeException());
      }
    } else {
      responseObserver.onError(Status.NOT_FOUND.asRuntimeException());
    }
  }

  @Override
  public void cancelOperation(
      CancelOperationRequest request, StreamObserver<Empty> responseObserver) {
    Operation op = operations.get(request.getName());
    Future<?> fut = futures.get(request.getName());
    if (op != null && fut != null) {
      if (!op.getDone()) {
        fut.cancel(true);
      }
    } else {
      responseObserver.onError(Status.NOT_FOUND.asRuntimeException());
    }
  }

  @Override
  public List<AbstractMessage> getRequests() {
    return Collections.emptyList();
  }

  @Override
  public void addResponse(AbstractMessage response) {
    throw new UnsupportedOperationException();
  }

  @Override
  public void addException(Exception exception) {
    throw new UnsupportedOperationException();
  }

  @Override
  public ServerServiceDefinition getServiceDefinition() {
    return bindService();
  }

  @Override
  public void reset() {
    for (Future<?> fut : futures.values()) {
      fut.cancel(true);
    }
    operations.clear();
    futures.clear();
  }
}
