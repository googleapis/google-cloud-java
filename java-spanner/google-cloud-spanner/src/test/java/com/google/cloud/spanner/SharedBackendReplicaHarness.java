/*
 * Copyright 2026 Google LLC
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *       http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package com.google.cloud.spanner;

import com.google.protobuf.AbstractMessage;
import com.google.protobuf.Empty;
import com.google.spanner.v1.BatchCreateSessionsRequest;
import com.google.spanner.v1.BatchCreateSessionsResponse;
import com.google.spanner.v1.BeginTransactionRequest;
import com.google.spanner.v1.CommitRequest;
import com.google.spanner.v1.CommitResponse;
import com.google.spanner.v1.CreateSessionRequest;
import com.google.spanner.v1.DeleteSessionRequest;
import com.google.spanner.v1.ExecuteSqlRequest;
import com.google.spanner.v1.GetSessionRequest;
import com.google.spanner.v1.PartialResultSet;
import com.google.spanner.v1.ReadRequest;
import com.google.spanner.v1.ResultSet;
import com.google.spanner.v1.RollbackRequest;
import com.google.spanner.v1.Session;
import com.google.spanner.v1.SpannerGrpc;
import com.google.spanner.v1.Transaction;
import io.grpc.Metadata;
import io.grpc.Server;
import io.grpc.ServerCall;
import io.grpc.ServerCallHandler;
import io.grpc.ServerInterceptor;
import io.grpc.ServerInterceptors;
import io.grpc.netty.shaded.io.grpc.netty.NettyServerBuilder;
import io.grpc.stub.StreamObserver;
import java.io.Closeable;
import java.io.IOException;
import java.net.InetSocketAddress;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/** Shared-backend replica harness for end-to-end location-aware routing tests. */
final class SharedBackendReplicaHarness implements Closeable {

  static final String METHOD_BATCH_CREATE_SESSIONS = "BatchCreateSessions";
  static final String METHOD_BEGIN_TRANSACTION = "BeginTransaction";
  static final String METHOD_COMMIT = "Commit";
  static final String METHOD_CREATE_SESSION = "CreateSession";
  static final String METHOD_DELETE_SESSION = "DeleteSession";
  static final String METHOD_EXECUTE_SQL = "ExecuteSql";
  static final String METHOD_EXECUTE_STREAMING_SQL = "ExecuteStreamingSql";
  static final String METHOD_GET_SESSION = "GetSession";
  static final String METHOD_READ = "Read";
  static final String METHOD_ROLLBACK = "Rollback";
  static final String METHOD_STREAMING_READ = "StreamingRead";

  static final class HookedReplicaSpannerService extends SpannerGrpc.SpannerImplBase {
    private final MockSpannerServiceImpl backend;
    private final Map<String, ArrayDeque<Throwable>> methodErrors = new HashMap<>();
    private final Map<String, List<AbstractMessage>> requests = new HashMap<>();
    private final Map<String, List<String>> requestIds = new HashMap<>();

    private HookedReplicaSpannerService(MockSpannerServiceImpl backend) {
      this.backend = backend;
    }

    synchronized void putMethodErrors(String method, Throwable... errors) {
      ArrayDeque<Throwable> queue = new ArrayDeque<>();
      for (Throwable error : errors) {
        queue.addLast(error);
      }
      methodErrors.put(method, queue);
    }

    synchronized List<AbstractMessage> getRequests(String method) {
      return new ArrayList<>(requests.getOrDefault(method, new ArrayList<>()));
    }

    synchronized List<String> getRequestIds(String method) {
      return new ArrayList<>(requestIds.getOrDefault(method, new ArrayList<>()));
    }

    synchronized void clearRequests() {
      requests.clear();
      requestIds.clear();
    }

    synchronized void clearMethodErrors() {
      methodErrors.clear();
    }

    private synchronized void recordRequest(String method, AbstractMessage request) {
      requests.computeIfAbsent(method, ignored -> new ArrayList<>()).add(request);
    }

    private synchronized void recordRequestId(String method, String requestId) {
      requestIds.computeIfAbsent(method, ignored -> new ArrayList<>()).add(requestId);
    }

    private synchronized Throwable nextError(String method) {
      ArrayDeque<Throwable> queue = methodErrors.get(method);
      if (queue == null || queue.isEmpty()) {
        return null;
      }
      return queue.removeFirst();
    }

    private boolean maybeFail(String method, StreamObserver<?> responseObserver) {
      Throwable error = nextError(method);
      if (error == null) {
        return false;
      }
      responseObserver.onError(error);
      return true;
    }

    @Override
    public void batchCreateSessions(
        BatchCreateSessionsRequest request,
        StreamObserver<BatchCreateSessionsResponse> responseObserver) {
      recordRequest(METHOD_BATCH_CREATE_SESSIONS, request);
      if (!maybeFail(METHOD_BATCH_CREATE_SESSIONS, responseObserver)) {
        backend.batchCreateSessions(request, responseObserver);
      }
    }

    @Override
    public void beginTransaction(
        BeginTransactionRequest request, StreamObserver<Transaction> responseObserver) {
      recordRequest(METHOD_BEGIN_TRANSACTION, request);
      if (!maybeFail(METHOD_BEGIN_TRANSACTION, responseObserver)) {
        backend.beginTransaction(request, responseObserver);
      }
    }

    @Override
    public void commit(CommitRequest request, StreamObserver<CommitResponse> responseObserver) {
      recordRequest(METHOD_COMMIT, request);
      if (!maybeFail(METHOD_COMMIT, responseObserver)) {
        backend.commit(request, responseObserver);
      }
    }

    @Override
    public void createSession(
        CreateSessionRequest request, StreamObserver<Session> responseObserver) {
      recordRequest(METHOD_CREATE_SESSION, request);
      if (!maybeFail(METHOD_CREATE_SESSION, responseObserver)) {
        backend.createSession(request, responseObserver);
      }
    }

    @Override
    public void deleteSession(
        DeleteSessionRequest request, StreamObserver<Empty> responseObserver) {
      recordRequest(METHOD_DELETE_SESSION, request);
      if (!maybeFail(METHOD_DELETE_SESSION, responseObserver)) {
        backend.deleteSession(request, responseObserver);
      }
    }

    @Override
    public void executeSql(ExecuteSqlRequest request, StreamObserver<ResultSet> responseObserver) {
      recordRequest(METHOD_EXECUTE_SQL, request);
      if (!maybeFail(METHOD_EXECUTE_SQL, responseObserver)) {
        backend.executeSql(request, responseObserver);
      }
    }

    @Override
    public void executeStreamingSql(
        ExecuteSqlRequest request, StreamObserver<PartialResultSet> responseObserver) {
      recordRequest(METHOD_EXECUTE_STREAMING_SQL, request);
      if (!maybeFail(METHOD_EXECUTE_STREAMING_SQL, responseObserver)) {
        backend.executeStreamingSql(request, responseObserver);
      }
    }

    @Override
    public void getSession(GetSessionRequest request, StreamObserver<Session> responseObserver) {
      recordRequest(METHOD_GET_SESSION, request);
      if (!maybeFail(METHOD_GET_SESSION, responseObserver)) {
        backend.getSession(request, responseObserver);
      }
    }

    @Override
    public void read(ReadRequest request, StreamObserver<ResultSet> responseObserver) {
      recordRequest(METHOD_READ, request);
      if (!maybeFail(METHOD_READ, responseObserver)) {
        backend.read(request, responseObserver);
      }
    }

    @Override
    public void rollback(RollbackRequest request, StreamObserver<Empty> responseObserver) {
      recordRequest(METHOD_ROLLBACK, request);
      if (!maybeFail(METHOD_ROLLBACK, responseObserver)) {
        backend.rollback(request, responseObserver);
      }
    }

    @Override
    public void streamingRead(
        ReadRequest request, StreamObserver<PartialResultSet> responseObserver) {
      recordRequest(METHOD_STREAMING_READ, request);
      if (!maybeFail(METHOD_STREAMING_READ, responseObserver)) {
        backend.streamingRead(request, responseObserver);
      }
    }
  }

  private final List<Server> servers;
  final MockSpannerServiceImpl backend;
  final HookedReplicaSpannerService defaultReplica;
  final String defaultAddress;
  final List<HookedReplicaSpannerService> replicas;
  final List<String> replicaAddresses;

  private SharedBackendReplicaHarness(
      MockSpannerServiceImpl backend,
      HookedReplicaSpannerService defaultReplica,
      String defaultAddress,
      List<HookedReplicaSpannerService> replicas,
      List<String> replicaAddresses,
      List<Server> servers) {
    this.backend = backend;
    this.defaultReplica = defaultReplica;
    this.defaultAddress = defaultAddress;
    this.replicas = replicas;
    this.replicaAddresses = replicaAddresses;
    this.servers = servers;
  }

  static SharedBackendReplicaHarness create(int replicaCount) throws IOException {
    MockSpannerServiceImpl backend = new MockSpannerServiceImpl();
    backend.setAbortProbability(0.0D);
    List<Server> servers = new ArrayList<>();
    HookedReplicaSpannerService defaultReplica = new HookedReplicaSpannerService(backend);
    List<HookedReplicaSpannerService> replicas = new ArrayList<>();
    List<String> replicaAddresses = new ArrayList<>();
    String defaultAddress = startServer(servers, defaultReplica);
    for (int i = 0; i < replicaCount; i++) {
      HookedReplicaSpannerService replica = new HookedReplicaSpannerService(backend);
      replicas.add(replica);
      replicaAddresses.add(startServer(servers, replica));
    }
    return new SharedBackendReplicaHarness(
        backend, defaultReplica, defaultAddress, replicas, replicaAddresses, servers);
  }

  private static String startServer(List<Server> servers, HookedReplicaSpannerService service)
      throws IOException {
    InetSocketAddress address = new InetSocketAddress("localhost", 0);
    ServerInterceptor interceptor =
        new ServerInterceptor() {
          @Override
          public <ReqT, RespT> ServerCall.Listener<ReqT> interceptCall(
              ServerCall<ReqT, RespT> call, Metadata headers, ServerCallHandler<ReqT, RespT> next) {
            service.recordRequestId(
                call.getMethodDescriptor().getBareMethodName(),
                headers.get(XGoogSpannerRequestId.REQUEST_ID_HEADER_KEY));
            return next.startCall(call, headers);
          }
        };
    Server server =
        NettyServerBuilder.forAddress(address)
            .addService(ServerInterceptors.intercept(service, interceptor))
            .build()
            .start();
    servers.add(server);
    return "localhost:" + server.getPort();
  }

  void clearRequests() {
    defaultReplica.clearRequests();
    for (HookedReplicaSpannerService replica : replicas) {
      replica.clearRequests();
    }
  }

  void reset() {
    backend.reset();
    backend.removeAllExecutionTimes();
    backend.setAbortProbability(0.0D);
    defaultReplica.clearRequests();
    defaultReplica.clearMethodErrors();
    for (HookedReplicaSpannerService replica : replicas) {
      replica.clearRequests();
      replica.clearMethodErrors();
    }
  }

  @Override
  public void close() throws IOException {
    IOException failure = null;
    for (Server server : servers) {
      server.shutdown();
    }
    for (Server server : servers) {
      try {
        server.awaitTermination(5L, java.util.concurrent.TimeUnit.SECONDS);
      } catch (InterruptedException e) {
        Thread.currentThread().interrupt();
        if (failure == null) {
          failure = new IOException("Interrupted while stopping replica harness", e);
        }
      }
    }
    if (failure != null) {
      throw failure;
    }
  }
}
