/*
 * Copyright 2025 Google LLC
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
package com.google.cloud.bigtable.data.v2.stub.sql;

import static com.google.cloud.bigtable.data.v2.stub.sql.SqlProtoFactory.columnMetadata;
import static com.google.cloud.bigtable.data.v2.stub.sql.SqlProtoFactory.metadata;
import static com.google.cloud.bigtable.data.v2.stub.sql.SqlProtoFactory.partialResultSetWithToken;
import static com.google.cloud.bigtable.data.v2.stub.sql.SqlProtoFactory.partialResultSetWithoutToken;
import static com.google.cloud.bigtable.data.v2.stub.sql.SqlProtoFactory.preparedStatement;
import static com.google.cloud.bigtable.data.v2.stub.sql.SqlProtoFactory.stringType;
import static com.google.cloud.bigtable.data.v2.stub.sql.SqlProtoFactory.stringValue;
import static com.google.common.truth.extensions.proto.ProtoTruth.assertThat;

import com.google.api.core.SettableApiFuture;
import com.google.bigtable.v2.ExecuteQueryRequest;
import com.google.cloud.bigtable.data.v2.internal.NameUtil;
import com.google.cloud.bigtable.data.v2.internal.RequestContext;
import com.google.cloud.bigtable.data.v2.models.sql.PreparedStatement;
import com.google.cloud.bigtable.data.v2.models.sql.ResultSetMetadata;
import com.google.protobuf.ByteString;
import io.grpc.Deadline;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.TimeUnit;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;

@RunWith(JUnit4.class)
public class ExecuteQueryResumptionStrategyTest {

  @Test
  public void tracksResumeToken() throws ExecutionException, InterruptedException {
    ExecuteQueryResumptionStrategy resumptionStrategy = new ExecuteQueryResumptionStrategy();

    PreparedStatement preparedStatement =
        preparedStatement(metadata(columnMetadata("s", stringType())));
    SettableApiFuture<ResultSetMetadata> mdFuture = SettableApiFuture.create();
    ExecuteQueryCallContext callContext =
        SqlProtoFactory.callContext(preparedStatement.bind().build(), mdFuture);

    resumptionStrategy.processResponse(
        partialResultSetWithToken(ByteString.copyFromUtf8("token"), stringValue("s")));
    // This should not change the token
    resumptionStrategy.processResponse(partialResultSetWithoutToken(stringValue("bar")));

    ExecuteQueryCallContext updatedCallContext = resumptionStrategy.getResumeRequest(callContext);
    assertThat(
            updatedCallContext.buildRequestWithDeadline(
                RequestContext.create("project", "instance", "profile"),
                Deadline.after(1, TimeUnit.MINUTES)))
        .isEqualTo(
            ExecuteQueryRequest.newBuilder()
                .setInstanceName(NameUtil.formatInstanceName("project", "instance"))
                .setAppProfileId("profile")
                .setPreparedQuery(ByteString.copyFromUtf8("foo"))
                .setResumeToken(ByteString.copyFromUtf8("token"))
                .build());
  }
}
