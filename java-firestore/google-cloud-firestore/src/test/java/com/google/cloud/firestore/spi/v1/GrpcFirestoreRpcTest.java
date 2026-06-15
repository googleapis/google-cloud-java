/*
 * Copyright 2024 Google LLC
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

package com.google.cloud.firestore.spi.v1;

import static com.google.common.truth.Truth.assertThat;

import com.google.api.gax.retrying.ExponentialRetryAlgorithm;
import com.google.api.gax.retrying.RetryAlgorithm;
import com.google.api.gax.retrying.RetrySettings;
import com.google.api.gax.retrying.ScheduledRetryingExecutor;
import com.google.api.gax.rpc.PagedCallSettings;
import com.google.api.gax.rpc.ServerStreamingCallSettings;
import com.google.api.gax.rpc.StatusCode.Code;
import com.google.api.gax.rpc.UnaryCallSettings;
import com.google.cloud.firestore.FirestoreOptions;
import com.google.cloud.firestore.v1.FirestoreClient.ListDocumentsPagedResponse;
import com.google.cloud.firestore.v1.FirestoreClient.PartitionQueryPagedResponse;
import com.google.cloud.firestore.v1.stub.FirestoreStubSettings;
import com.google.firestore.v1.BatchGetDocumentsRequest;
import com.google.firestore.v1.BatchGetDocumentsResponse;
import com.google.firestore.v1.BatchWriteRequest;
import com.google.firestore.v1.BatchWriteResponse;
import com.google.firestore.v1.BeginTransactionRequest;
import com.google.firestore.v1.BeginTransactionResponse;
import com.google.firestore.v1.CommitRequest;
import com.google.firestore.v1.CommitResponse;
import com.google.firestore.v1.ExecutePipelineRequest;
import com.google.firestore.v1.ExecutePipelineResponse;
import com.google.firestore.v1.ListDocumentsRequest;
import com.google.firestore.v1.ListDocumentsResponse;
import com.google.firestore.v1.PartitionQueryRequest;
import com.google.firestore.v1.PartitionQueryResponse;
import com.google.firestore.v1.RollbackRequest;
import com.google.firestore.v1.RunAggregationQueryRequest;
import com.google.firestore.v1.RunAggregationQueryResponse;
import com.google.firestore.v1.RunQueryRequest;
import com.google.firestore.v1.RunQueryResponse;
import com.google.protobuf.Empty;
import java.io.IOException;
import java.lang.reflect.Field;
import java.util.Set;
import org.junit.BeforeClass;
import org.junit.Test;

public class GrpcFirestoreRpcTest {

  private static FirestoreStubSettings defaultStubSettings;

  private final FirestoreOptions firestoreOptionsWithoutOverride =
      FirestoreOptions.newBuilder().setProjectId("test-project").build();

  @BeforeClass
  public static void beforeClass() throws IOException {
    defaultStubSettings = FirestoreStubSettings.newBuilder().build();
  }

  static <T> T getViaReflection(Object o, String fieldName)
      throws NoSuchFieldException, IllegalAccessException {
    return getViaReflection(o.getClass(), fieldName, o);
  }

  static <T> T getViaReflection(Class clazz, String fieldName, Object o)
      throws NoSuchFieldException, IllegalAccessException {
    Field field = clazz.getDeclaredField(fieldName);
    field.setAccessible(true);
    return (T) field.get(o);
  }

  @Test
  public void retrySettingsOverride() throws Exception {
    RetrySettings retrySettings = RetrySettings.newBuilder().setMaxAttempts(2).build();
    FirestoreOptions firestoreOptions =
        FirestoreOptions.newBuilder()
            .setProjectId("test-project")
            .setRetrySettings(retrySettings)
            .build();
    GrpcFirestoreRpc grpcFirestoreRpc = new GrpcFirestoreRpc(firestoreOptions);

    CallableRetryData commit = getRetryData(grpcFirestoreRpc.commitCallable());
    assertThat(commit.retrySettings).isEqualTo(retrySettings);
    assertThat(commit.retryableCodes)
        .containsExactlyElementsIn(defaultStubSettings.commitSettings().getRetryableCodes());

    CallableRetryData batchWrite = getRetryData(grpcFirestoreRpc.batchWriteCallable());
    assertThat(batchWrite.retrySettings).isEqualTo(retrySettings);
    assertThat(batchWrite.retryableCodes)
        .containsExactlyElementsIn(defaultStubSettings.batchWriteSettings().getRetryableCodes());

    CallableRetryData batchGetDocuments =
        getRetryData(grpcFirestoreRpc.batchGetDocumentsCallable());
    assertThat(batchGetDocuments.retrySettings).isEqualTo(retrySettings);
    assertThat(batchGetDocuments.retryableCodes)
        .containsExactlyElementsIn(
            defaultStubSettings.batchGetDocumentsSettings().getRetryableCodes());

    CallableRetryData runQuery = getRetryData(grpcFirestoreRpc.runQueryCallable());
    assertThat(runQuery.retrySettings).isEqualTo(retrySettings);
    assertThat(runQuery.retryableCodes)
        .containsExactlyElementsIn(defaultStubSettings.runQuerySettings().getRetryableCodes());

    CallableRetryData runAggregationQuery =
        getRetryData(grpcFirestoreRpc.runAggregationQueryCallable());
    assertThat(runAggregationQuery.retrySettings).isEqualTo(retrySettings);
    assertThat(runAggregationQuery.retryableCodes)
        .containsExactlyElementsIn(
            defaultStubSettings.runAggregationQuerySettings().getRetryableCodes());

    CallableRetryData beginTransaction = getRetryData(grpcFirestoreRpc.beginTransactionCallable());
    assertThat(beginTransaction.retrySettings).isEqualTo(retrySettings);
    assertThat(beginTransaction.retryableCodes)
        .containsExactlyElementsIn(
            defaultStubSettings.beginTransactionSettings().getRetryableCodes());

    CallableRetryData rollback = getRetryData(grpcFirestoreRpc.rollbackCallable());
    assertThat(rollback.retrySettings).isEqualTo(retrySettings);
    assertThat(rollback.retryableCodes)
        .containsExactlyElementsIn(defaultStubSettings.rollbackSettings().getRetryableCodes());

    CallableRetryData listCollectionIdsPaged =
        getRetryData(grpcFirestoreRpc.listCollectionIdsPagedCallable());
    assertThat(listCollectionIdsPaged.retrySettings).isEqualTo(retrySettings);
    assertThat(listCollectionIdsPaged.retryableCodes)
        .containsExactlyElementsIn(
            defaultStubSettings.listCollectionIdsSettings().getRetryableCodes());

    CallableRetryData partitionQueryPaged =
        getRetryData(grpcFirestoreRpc.partitionQueryPagedCallable());
    assertThat(partitionQueryPaged.retrySettings).isEqualTo(retrySettings);
    assertThat(partitionQueryPaged.retryableCodes)
        .containsExactlyElementsIn(
            defaultStubSettings.partitionQuerySettings().getRetryableCodes());

    CallableRetryData listDocumentsPaged =
        getRetryData(grpcFirestoreRpc.listDocumentsPagedCallable());
    assertThat(listDocumentsPaged.retrySettings).isEqualTo(retrySettings);
    assertThat(listDocumentsPaged.retryableCodes)
        .containsExactlyElementsIn(defaultStubSettings.listDocumentsSettings().getRetryableCodes());
  }

  private static RetrySettings withMaxAttempt5(RetrySettings retrySettings) {
    return retrySettings.toBuilder().setMaxAttempts(5).build();
  }

  @Test
  public void commitCallableFollowsServiceConfig() throws Exception {
    GrpcFirestoreRpc grpcFirestoreRpc = new GrpcFirestoreRpc(firestoreOptionsWithoutOverride);
    CallableRetryData actual = getRetryData(grpcFirestoreRpc.commitCallable());
    UnaryCallSettings<CommitRequest, CommitResponse> expectedSettings =
        defaultStubSettings.commitSettings();
    assertThat(actual.retrySettings)
        .isEqualTo(withMaxAttempt5(expectedSettings.getRetrySettings()));
    assertThat(actual.retryableCodes)
        .containsExactlyElementsIn(expectedSettings.getRetryableCodes());
  }

  @Test
  public void batchWriteCallableFollowsServiceConfig() throws Exception {
    GrpcFirestoreRpc grpcFirestoreRpc = new GrpcFirestoreRpc(firestoreOptionsWithoutOverride);
    CallableRetryData actual = getRetryData(grpcFirestoreRpc.batchWriteCallable());
    UnaryCallSettings<BatchWriteRequest, BatchWriteResponse> expectedSettings =
        defaultStubSettings.batchWriteSettings();
    assertThat(actual.retrySettings)
        .isEqualTo(withMaxAttempt5(expectedSettings.getRetrySettings()));
    assertThat(actual.retryableCodes)
        .containsExactlyElementsIn(expectedSettings.getRetryableCodes());
  }

  @Test
  public void batchGetDocumentsCallableFollowsServiceConfig() throws Exception {
    GrpcFirestoreRpc grpcFirestoreRpc = new GrpcFirestoreRpc(firestoreOptionsWithoutOverride);
    CallableRetryData actual = getRetryData(grpcFirestoreRpc.batchGetDocumentsCallable());
    ServerStreamingCallSettings<BatchGetDocumentsRequest, BatchGetDocumentsResponse>
        expectedSettings = defaultStubSettings.batchGetDocumentsSettings();
    assertThat(actual.retrySettings)
        .isEqualTo(withMaxAttempt5(expectedSettings.getRetrySettings()));
    assertThat(actual.retryableCodes)
        .containsExactlyElementsIn(expectedSettings.getRetryableCodes());
  }

  @Test
  public void runQueryCallableFollowsServiceConfig() throws Exception {
    GrpcFirestoreRpc grpcFirestoreRpc = new GrpcFirestoreRpc(firestoreOptionsWithoutOverride);
    CallableRetryData actual = getRetryData(grpcFirestoreRpc.runQueryCallable());
    ServerStreamingCallSettings<RunQueryRequest, RunQueryResponse> expectedSettings =
        defaultStubSettings.runQuerySettings();
    assertThat(actual.retrySettings)
        .isEqualTo(withMaxAttempt5(expectedSettings.getRetrySettings()));
    assertThat(actual.retryableCodes)
        .containsExactlyElementsIn(expectedSettings.getRetryableCodes());
  }

  @Test
  public void runAggregationQueryCallableFollowsServiceConfig() throws Exception {
    GrpcFirestoreRpc grpcFirestoreRpc = new GrpcFirestoreRpc(firestoreOptionsWithoutOverride);
    CallableRetryData actual = getRetryData(grpcFirestoreRpc.runAggregationQueryCallable());
    ServerStreamingCallSettings<RunAggregationQueryRequest, RunAggregationQueryResponse>
        expectedSettings = defaultStubSettings.runAggregationQuerySettings();
    assertThat(actual.retrySettings)
        .isEqualTo(withMaxAttempt5(expectedSettings.getRetrySettings()));
    assertThat(actual.retryableCodes)
        .containsExactlyElementsIn(expectedSettings.getRetryableCodes());
  }

  @Test
  public void executePipelineCallableFollowsServiceConfig() throws Exception {
    GrpcFirestoreRpc grpcFirestoreRpc = new GrpcFirestoreRpc(firestoreOptionsWithoutOverride);
    CallableRetryData actual = getRetryData(grpcFirestoreRpc.executePipelineCallable());
    ServerStreamingCallSettings<ExecutePipelineRequest, ExecutePipelineResponse> expectedSettings =
        defaultStubSettings.executePipelineSettings();
    assertThat(actual.retrySettings)
        .isEqualTo(withMaxAttempt5(expectedSettings.getRetrySettings()));
    assertThat(actual.retryableCodes)
        .containsExactlyElementsIn(expectedSettings.getRetryableCodes());
  }

  @Test
  public void beginTransactionCallableFollowsServiceConfig() throws Exception {
    GrpcFirestoreRpc grpcFirestoreRpc = new GrpcFirestoreRpc(firestoreOptionsWithoutOverride);
    CallableRetryData actual = getRetryData(grpcFirestoreRpc.beginTransactionCallable());
    UnaryCallSettings<BeginTransactionRequest, BeginTransactionResponse> expectedSettings =
        defaultStubSettings.beginTransactionSettings();
    assertThat(actual.retrySettings)
        .isEqualTo(withMaxAttempt5(expectedSettings.getRetrySettings()));
    assertThat(actual.retryableCodes)
        .containsExactlyElementsIn(expectedSettings.getRetryableCodes());
  }

  @Test
  public void rollbackCallableFollowsServiceConfig() throws Exception {
    GrpcFirestoreRpc grpcFirestoreRpc = new GrpcFirestoreRpc(firestoreOptionsWithoutOverride);
    CallableRetryData actual = getRetryData(grpcFirestoreRpc.rollbackCallable());
    UnaryCallSettings<RollbackRequest, Empty> expectedSettings =
        defaultStubSettings.rollbackSettings();
    assertThat(actual.retrySettings)
        .isEqualTo(withMaxAttempt5(expectedSettings.getRetrySettings()));
    assertThat(actual.retryableCodes)
        .containsExactlyElementsIn(expectedSettings.getRetryableCodes());
  }

  @Test
  public void listCollectionIdsPagedCallableFollowsServiceConfig() throws Exception {
    GrpcFirestoreRpc grpcFirestoreRpc = new GrpcFirestoreRpc(firestoreOptionsWithoutOverride);
    CallableRetryData actual = getRetryData(grpcFirestoreRpc.listCollectionIdsPagedCallable());
    PagedCallSettings<ListDocumentsRequest, ListDocumentsResponse, ListDocumentsPagedResponse>
        expectedSettings = defaultStubSettings.listDocumentsSettings();
    assertThat(actual.retrySettings)
        .isEqualTo(withMaxAttempt5(expectedSettings.getRetrySettings()));
    assertThat(actual.retryableCodes)
        .containsExactlyElementsIn(expectedSettings.getRetryableCodes());
  }

  @Test
  public void partitionQueryPagedCallableFollowsServiceConfig() throws Exception {
    GrpcFirestoreRpc grpcFirestoreRpc = new GrpcFirestoreRpc(firestoreOptionsWithoutOverride);
    CallableRetryData actual = getRetryData(grpcFirestoreRpc.partitionQueryPagedCallable());
    PagedCallSettings<PartitionQueryRequest, PartitionQueryResponse, PartitionQueryPagedResponse>
        expectedSettings = defaultStubSettings.partitionQuerySettings();
    assertThat(actual.retrySettings)
        .isEqualTo(withMaxAttempt5(expectedSettings.getRetrySettings()));
    assertThat(actual.retryableCodes)
        .containsExactlyElementsIn(expectedSettings.getRetryableCodes());
  }

  @Test
  public void listDocumentsPagedCallableFollowsServiceConfig() throws Exception {
    GrpcFirestoreRpc grpcFirestoreRpc = new GrpcFirestoreRpc(firestoreOptionsWithoutOverride);
    CallableRetryData actual = getRetryData(grpcFirestoreRpc.listDocumentsPagedCallable());
    PagedCallSettings<ListDocumentsRequest, ListDocumentsResponse, ListDocumentsPagedResponse>
        expectedSettings = defaultStubSettings.listDocumentsSettings();
    assertThat(actual.retrySettings)
        .isEqualTo(withMaxAttempt5(expectedSettings.getRetrySettings()));
    assertThat(actual.retryableCodes)
        .containsExactlyElementsIn(expectedSettings.getRetryableCodes());
  }

  private static CallableRetryData getRetryData(Object callable) throws Exception {
    String aClassName = callable.getClass().getName();
    switch (aClassName) {
      case "com.google.api.gax.tracing.TracedUnaryCallable":
      case "com.google.api.gax.tracing.TracedServerStreamingCallable":
        return getRetryData(getViaReflection(callable, "innerCallable"));
      case "com.google.api.gax.rpc.UnaryCallable$1":
      case "com.google.api.gax.rpc.ServerStreamingCallable$1":
        return getRetryData(getViaReflection(callable, "this$0"));
      case "com.google.api.gax.rpc.RetryingCallable":
        return new CallableRetryData(
            getRetrySettings(getViaReflection(callable, "executor")),
            getRetryableCodes(getViaReflection(callable, "callable")));
      case "com.google.api.gax.rpc.RetryingServerStreamingCallable":
        return new CallableRetryData(
            getRetrySettings(getViaReflection(callable, "executor")),
            getRetryableCodes(getViaReflection(callable, "innerCallable")));
      case "com.google.api.gax.rpc.PagedCallable":
        return getRetryData(getViaReflection(callable, "callable"));
      default:
        throw new Exception("Unexpected class " + aClassName);
    }
  }

  private static Set<Code> getRetryableCodes(Object o)
      throws NoSuchFieldException, IllegalAccessException {
    switch (o.getClass().getName()) {
      case "com.google.api.gax.rpc.ServerStreamingCallable$1":
        return getRetryableCodes(getViaReflection(o, "this$0"));
      case "com.google.api.gax.rpc.WatchdogServerStreamingCallable":
        return getRetryableCodes(getViaReflection(o, "inner"));
    }
    Object exceptionFactory = getViaReflection(o, "exceptionFactory");
    return getViaReflection(exceptionFactory, "retryableCodes");
  }

  private static RetrySettings getRetrySettings(Object o) throws Exception {
    String aClassName = o.getClass().getName();
    switch (aClassName) {
      case "com.google.api.gax.retrying.ScheduledRetryingExecutor":
        {
          Object retryAlgorithm =
              getViaReflection(ScheduledRetryingExecutor.class, "retryAlgorithm", o);
          Object exponentialRetryAlgorithm =
              getViaReflection(RetryAlgorithm.class, "timedAlgorithmWithContext", retryAlgorithm);
          return getViaReflection(
              ExponentialRetryAlgorithm.class, "globalSettings", exponentialRetryAlgorithm);
        }
      default:
        throw new Exception("Unexpected class " + aClassName);
    }
  }

  static class CallableRetryData {
    final RetrySettings retrySettings;
    final Set<Code> retryableCodes;

    CallableRetryData(RetrySettings retrySettings, Set<Code> retryableCodes) {
      this.retrySettings = retrySettings;
      this.retryableCodes = retryableCodes;
    }
  }
}
