/*
 * Copyright 2020 Google Inc.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package com.example.spanner;

import com.google.api.gax.grpc.GrpcCallContext;
import com.google.api.gax.rpc.ApiCallContext;
import com.google.cloud.spanner.DatabaseClient;
import com.google.cloud.spanner.DatabaseId;
import com.google.cloud.spanner.Spanner;
import com.google.cloud.spanner.SpannerOptions;
import com.google.cloud.spanner.SpannerOptions.CallContextConfigurator;
import com.google.cloud.spanner.Statement;
import com.google.spanner.v1.SpannerGrpc;
import io.grpc.CallOptions;
import io.grpc.Context;
import io.grpc.MethodDescriptor;
import java.util.concurrent.TimeUnit;

class StatementTimeoutExample {

  // [START spanner_set_statement_timeout]

  static void executeSqlWithTimeout() {
    // TODO(developer): Replace these variables before running the sample.
    String projectId = "my-project";
    String instanceId = "my-instance";
    String databaseId = "my-database";

    try (Spanner spanner =
        SpannerOptions.newBuilder().setProjectId(projectId).build().getService()) {
      DatabaseClient client =
          spanner.getDatabaseClient(DatabaseId.of(projectId, instanceId, databaseId));
      executeSqlWithTimeout(client);
    }
  }

  static void executeSqlWithTimeout(DatabaseClient client) {
    CallContextConfigurator configurator = new CallContextConfigurator() {
      public <ReqT, RespT> ApiCallContext configure(ApiCallContext context, ReqT request,
          MethodDescriptor<ReqT, RespT> method) {
        // DML uses the ExecuteSql RPC.
        if (method == SpannerGrpc.getExecuteSqlMethod()) {
          // NOTE: You can use a GrpcCallContext to set a custom timeout for a single RPC
          // invocation. This timeout can however ONLY BE SHORTER than the default timeout
          // for the RPC. If you set a timeout that is longer than the default timeout, then
          // the default timeout will be used.
          return GrpcCallContext.createDefault()
              .withCallOptions(CallOptions.DEFAULT.withDeadlineAfter(60L, TimeUnit.SECONDS));
        }
        // Return null to indicate that the default should be used for other methods.
        return null;
      }
    };
    // Create a context that uses the custom call configuration.
    Context context =
        Context.current().withValue(SpannerOptions.CALL_CONTEXT_CONFIGURATOR_KEY, configurator);
    // Run the transaction in the custom context.
    context.run(() ->
        client.readWriteTransaction().<long[]>run(transaction -> {
          String sql = "INSERT INTO Singers (SingerId, FirstName, LastName)\n"
              + "VALUES (20, 'George', 'Washington')";
          long rowCount = transaction.executeUpdate(Statement.of(sql));
          System.out.printf("%d record inserted.%n", rowCount);
          return null;
        })
    );
  }
  // [END spanner_set_statement_timeout]
}
