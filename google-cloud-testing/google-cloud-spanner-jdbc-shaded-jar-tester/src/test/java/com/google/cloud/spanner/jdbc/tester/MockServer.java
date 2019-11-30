/*
 * Copyright 2019 Google LLC
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

package com.google.cloud.spanner.jdbc.tester;

import com.google.protobuf.Empty;
import com.google.protobuf.Timestamp;
import com.google.spanner.v1.BatchCreateSessionsRequest;
import com.google.spanner.v1.BatchCreateSessionsResponse;
import com.google.spanner.v1.CreateSessionRequest;
import com.google.spanner.v1.DeleteSessionRequest;
import com.google.spanner.v1.ExecuteSqlRequest;
import com.google.spanner.v1.PartialResultSet;
import com.google.spanner.v1.ResultSetMetadata;
import com.google.spanner.v1.Session;
import com.google.spanner.v1.SpannerGrpc.SpannerImplBase;
import com.google.spanner.v1.StructType;
import com.google.spanner.v1.StructType.Field;
import com.google.spanner.v1.Transaction;
import com.google.spanner.v1.Type;
import com.google.spanner.v1.TypeCode;
import io.grpc.Server;
import io.grpc.netty.shaded.io.grpc.netty.NettyServerBuilder;
import io.grpc.stub.StreamObserver;
import java.io.IOException;

/**
 * A minimal implementation of Spanner server that can be used to execute one query using the JDBC
 * driver.
 */
public class MockServer extends SpannerImplBase {

  @Override
  public void batchCreateSessions(
      BatchCreateSessionsRequest request,
      StreamObserver<BatchCreateSessionsResponse> responseObserver) {
    BatchCreateSessionsResponse.Builder builder = BatchCreateSessionsResponse.newBuilder();
    for (int i = 0; i < request.getSessionCount(); i++) {
      builder.addSession(Session.newBuilder().setName(String.format("session-%05d", i)).build());
    }
    responseObserver.onNext(builder.build());
    responseObserver.onCompleted();
  }

  @Override
  public void createSession(
      CreateSessionRequest request, StreamObserver<Session> responseObserver) {
    responseObserver.onNext(Session.newBuilder().setName("session").build());
    responseObserver.onCompleted();
  }

  @Override
  public void deleteSession(DeleteSessionRequest request, StreamObserver<Empty> responseObserver) {
    responseObserver.onNext(Empty.getDefaultInstance());
    responseObserver.onCompleted();
  }

  @Override
  public void executeStreamingSql(
      ExecuteSqlRequest request, StreamObserver<PartialResultSet> responseObserver) {
    responseObserver.onNext(
        PartialResultSet.newBuilder()
            .setMetadata(
                ResultSetMetadata.newBuilder()
                    .setRowType(
                        StructType.newBuilder()
                            .addFields(
                                Field.newBuilder()
                                    .setName("COL1")
                                    .setType(Type.newBuilder().setCode(TypeCode.INT64).build())
                                    .build()))
                    .setTransaction(
                        Transaction.newBuilder()
                            .setReadTimestamp(
                                Timestamp.newBuilder()
                                    .setSeconds(System.currentTimeMillis() / 1000)
                                    .build())
                            .build()))
            .build());
    responseObserver.onCompleted();
  }

  static Server startMockServer() throws IOException {
    return NettyServerBuilder.forPort(0).addService(new MockServer()).build().start();
  }
}
