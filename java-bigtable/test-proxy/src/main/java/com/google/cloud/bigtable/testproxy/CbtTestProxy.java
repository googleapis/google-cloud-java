/*
 * Copyright 2024 Google LLC
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
package com.google.cloud.bigtable.testproxy;

import static com.google.cloud.bigtable.data.v2.models.Filters.FILTERS;
import static java.nio.charset.StandardCharsets.UTF_8;

import com.google.api.core.ApiFunction;
import com.google.api.gax.core.CredentialsProvider;
import com.google.api.gax.core.FixedCredentialsProvider;
import com.google.api.gax.core.NoCredentialsProvider;
import com.google.api.gax.grpc.InstantiatingGrpcChannelProvider;
import com.google.api.gax.retrying.RetrySettings;
import com.google.api.gax.rpc.ApiException;
import com.google.api.gax.rpc.ServerStream;
import com.google.auth.oauth2.AccessToken;
import com.google.auth.oauth2.OAuth2Credentials;
import com.google.auto.value.AutoValue;
import com.google.bigtable.v2.Column;
import com.google.bigtable.v2.Family;
import com.google.bigtable.v2.Row;
import com.google.bigtable.v2.Value;
import com.google.cloud.bigtable.data.v2.BigtableDataClient;
import com.google.cloud.bigtable.data.v2.BigtableDataSettings;
import com.google.cloud.bigtable.data.v2.models.BulkMutation;
import com.google.cloud.bigtable.data.v2.models.ConditionalRowMutation;
import com.google.cloud.bigtable.data.v2.models.KeyOffset;
import com.google.cloud.bigtable.data.v2.models.MutateRowsException;
import com.google.cloud.bigtable.data.v2.models.Query;
import com.google.cloud.bigtable.data.v2.models.ReadModifyWriteRow;
import com.google.cloud.bigtable.data.v2.models.RowCell;
import com.google.cloud.bigtable.data.v2.models.RowMutation;
import com.google.cloud.bigtable.data.v2.models.sql.PreparedStatement;
import com.google.cloud.bigtable.data.v2.models.sql.ResultSet;
import com.google.cloud.bigtable.data.v2.models.sql.SqlType;
import com.google.cloud.bigtable.data.v2.stub.EnhancedBigtableStubSettings;
import com.google.cloud.bigtable.testproxy.CloudBigtableV2TestProxyGrpc.CloudBigtableV2TestProxyImplBase;
import com.google.common.base.Preconditions;
import com.google.protobuf.ByteString;
import com.google.protobuf.util.Durations;
import com.google.rpc.Code;
import io.grpc.ManagedChannelBuilder;
import io.grpc.Status;
import io.grpc.StatusException;
import io.grpc.StatusRuntimeException;
import io.grpc.netty.shaded.io.grpc.netty.GrpcSslContexts;
import io.grpc.netty.shaded.io.grpc.netty.NettyChannelBuilder;
import io.grpc.netty.shaded.io.netty.handler.ssl.SslContext;
import io.grpc.protobuf.StatusProto;
import io.grpc.stub.StreamObserver;
import java.io.ByteArrayInputStream;
import java.io.Closeable;
import java.io.IOException;
import java.time.Duration;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ExecutionException;
import java.util.logging.Logger;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.stream.Collectors;

/** Java implementation of the CBT test proxy. Used to test the Java CBT client. */
public class CbtTestProxy extends CloudBigtableV2TestProxyImplBase implements Closeable {

  /**
   * Class that holds BigtableDataSettings and a BigtableDataClient created with those settings.
   * Used so users can retrieve settings for a particular client.
   */
  @AutoValue
  abstract static class CbtClient {
    static CbtClient create(BigtableDataSettings settings, BigtableDataClient dataClient) {
      return new AutoValue_CbtTestProxy_CbtClient(settings, dataClient);
    }

    abstract BigtableDataSettings settings();

    abstract BigtableDataClient dataClient();
  }

  private static final Logger logger = Logger.getLogger(CbtTestProxy.class.getName());

  private CbtTestProxy() {
    this.idClientMap = new ConcurrentHashMap<>();
  }

  /** Factory method to return a proxy instance. */
  public static CbtTestProxy create() {
    return new CbtTestProxy();
  }

  /**
   * Helper method to override the timeout settings of data APIs. TODO(developer): per-attempt
   * timeout may also be overridden, which will involve test harness update.
   *
   * @param settingsBuilder The Builder object of BigtableDataSettings.
   * @param newTimeout The value that is used to set the timeout.
   */
  private static BigtableDataSettings.Builder overrideTimeoutSetting(
      Duration newTimeout, BigtableDataSettings.Builder settingsBuilder) {

    updateTimeout(
        settingsBuilder.stubSettings().bulkMutateRowsSettings().retrySettings(), newTimeout);
    updateTimeout(settingsBuilder.stubSettings().mutateRowSettings().retrySettings(), newTimeout);
    updateTimeout(settingsBuilder.stubSettings().readRowSettings().retrySettings(), newTimeout);
    updateTimeout(settingsBuilder.stubSettings().readRowsSettings().retrySettings(), newTimeout);
    updateTimeout(
        settingsBuilder.stubSettings().checkAndMutateRowSettings().retrySettings(), newTimeout);
    updateTimeout(
        settingsBuilder.stubSettings().readModifyWriteRowSettings().retrySettings(), newTimeout);
    updateTimeout(
        settingsBuilder.stubSettings().sampleRowKeysSettings().retrySettings(), newTimeout);
    updateTimeout(
        settingsBuilder.stubSettings().executeQuerySettings().retrySettings(), newTimeout);
    updateTimeout(
        settingsBuilder.stubSettings().prepareQuerySettings().retrySettings(), newTimeout);

    return settingsBuilder;
  }

  private static void updateTimeout(RetrySettings.Builder settings, Duration newTimeout) {
    Duration rpcTimeout = settings.getInitialRpcTimeoutDuration();

    // TODO: this should happen in gax
    // Clamp the rpcTimeout to the overall timeout
    if (rpcTimeout != null && rpcTimeout.compareTo(newTimeout) > 0) {
      settings.setInitialRpcTimeoutDuration(newTimeout).setMaxRpcTimeoutDuration(newTimeout);
    }

    settings.setTotalTimeoutDuration(newTimeout);
  }

  /** Helper method to get a client object by its id. */
  private CbtClient getClient(String id) throws StatusException {
    CbtClient client = idClientMap.get(id);
    if (client == null) {
      throw Status.NOT_FOUND.withDescription("Client " + id + " not found.").asException();
    }
    return client;
  }

  @Override
  public synchronized void createClient(
      CreateClientRequest request, StreamObserver<CreateClientResponse> responseObserver) {
    Preconditions.checkArgument(!request.getClientId().isEmpty(), "client id must be provided");
    Preconditions.checkArgument(!request.getProjectId().isEmpty(), "project id must be provided");
    Preconditions.checkArgument(!request.getInstanceId().isEmpty(), "instance id must be provided");
    Preconditions.checkArgument(!request.getDataTarget().isEmpty(), "data target must be provided");
    Preconditions.checkArgument(
        !request.getSecurityOptions().getUseSsl()
            || !request.getSecurityOptions().getSslRootCertsPemBytes().isEmpty(),
        "security_options.ssl_root_certs_pem must be provided if security_options.use_ssl is true");

    if (idClientMap.containsKey(request.getClientId())) {
      responseObserver.onError(
          Status.ALREADY_EXISTS
              .withDescription("Client " + request.getClientId() + " already exists.")
              .asException());
      return;
    }

    // setRefreshingChannel is needed for now.
    @SuppressWarnings("deprecation")
    BigtableDataSettings.Builder settingsBuilder =
        BigtableDataSettings.newBuilder()
            // Disable channel refreshing when not using the real server
            .setRefreshingChannel(false)
            .setProjectId(request.getProjectId())
            .setInstanceId(request.getInstanceId())
            .setAppProfileId(request.getAppProfileId());

    if (request.hasPerOperationTimeout()) {
      Duration newTimeout = Duration.ofMillis(Durations.toMillis(request.getPerOperationTimeout()));
      settingsBuilder = overrideTimeoutSetting(newTimeout, settingsBuilder);
      logger.info(
          String.format(
              "Total timeout is set to %s for all the methods",
              Durations.toString(request.getPerOperationTimeout())));
    }

    if (request.getOptionalFeatureConfig()
        == OptionalFeatureConfig.OPTIONAL_FEATURE_CONFIG_ENABLE_ALL) {
      logger.info("Enabling all the optional features");
      try {
        BigtableDataSettings.enableBuiltinMetrics();
      } catch (IOException e) {
        // Exception will be raised if Application Default Credentials is not found.
        // We can ignore it as it doesn't impact the client correctness testing.
        if (!e.getMessage().toUpperCase().contains("APPLICATION DEFAULT CREDENTIALS")) {
          responseObserver.onError(Status.INTERNAL.withDescription(e.getMessage()).asException());
          return;
        }
      }
      settingsBuilder.stubSettings().bulkMutateRowsSettings().setServerInitiatedFlowControl(true);
      settingsBuilder.stubSettings().setEnableRoutingCookie(true);
      settingsBuilder.stubSettings().setEnableRetryInfo(true);
    }

    // Create and store CbtClient for later use
    try {
      if (!request.getDataTarget().equals("emulator")) {
        settingsBuilder
            .stubSettings()
            .setEndpoint(request.getDataTarget())
            .setTransportChannelProvider(
                getTransportChannel(
                    request.getSecurityOptions().getUseSsl(),
                    request.getSecurityOptions().getSslRootCertsPem(),
                    request.getSecurityOptions().getSslEndpointOverride()))
            .setCredentialsProvider(
                getCredentialsProvider(request.getSecurityOptions().getAccessToken()));
      }
      BigtableDataSettings settings = settingsBuilder.build();
      BigtableDataClient client = BigtableDataClient.create(settings);
      CbtClient cbtClient = CbtClient.create(settings, client);
      idClientMap.put(request.getClientId(), cbtClient);
    } catch (IOException e) {
      responseObserver.onError(Status.INTERNAL.withDescription(e.getMessage()).asException());
      return;
    }

    responseObserver.onNext(CreateClientResponse.getDefaultInstance());
    responseObserver.onCompleted();
  }

  @Override
  public void closeClient(
      CloseClientRequest request, StreamObserver<CloseClientResponse> responseObserver) {
    CbtClient client;
    try {
      client = getClient(request.getClientId());
    } catch (StatusException e) {
      responseObserver.onError(e);
      return;
    }

    client.dataClient().close();

    responseObserver.onNext(CloseClientResponse.getDefaultInstance());
    responseObserver.onCompleted();
  }

  @Override
  public void removeClient(
      RemoveClientRequest request, StreamObserver<RemoveClientResponse> responseObserver) {
    CbtClient client = idClientMap.remove(request.getClientId());
    if (client == null) {
      responseObserver.onError(
          Status.NOT_FOUND
              .withDescription("Client " + request.getClientId() + " not found.")
              .asException());
      return;
    }

    responseObserver.onNext(RemoveClientResponse.getDefaultInstance());
    responseObserver.onCompleted();
  }

  @Override
  public void mutateRow(
      MutateRowRequest request, StreamObserver<MutateRowResult> responseObserver) {
    CbtClient client;
    try {
      client = getClient(request.getClientId());
    } catch (StatusException e) {
      responseObserver.onError(e);
      return;
    }

    // TODO(developer): evaluate if we want to manually unpack the proto into a model, instead of
    // using fromProto. Same for the other methods.
    RowMutation mutation = RowMutation.fromProto(request.getRequest());
    try {
      // This response is empty.
      client.dataClient().mutateRow(mutation);
    } catch (ApiException e) {
      responseObserver.onNext(
          MutateRowResult.newBuilder()
              .setStatus(
                  com.google.rpc.Status.newBuilder()
                      .setCode(e.getStatusCode().getCode().ordinal())
                      .setMessage(e.getMessage())
                      .build())
              .build());
      responseObserver.onCompleted();
      return;
    } catch (StatusRuntimeException e) {
      responseObserver.onNext(
          MutateRowResult.newBuilder().setStatus(StatusProto.fromThrowable(e)).build());
      responseObserver.onCompleted();
      return;
    }

    responseObserver.onNext(
        MutateRowResult.newBuilder().setStatus(com.google.rpc.Status.getDefaultInstance()).build());
    responseObserver.onCompleted();
  }

  @Override
  public void bulkMutateRows(
      MutateRowsRequest request, StreamObserver<MutateRowsResult> responseObserver) {
    CbtClient client;
    try {
      client = getClient(request.getClientId());
    } catch (StatusException e) {
      responseObserver.onError(e);
      return;
    }

    BulkMutation batch = BulkMutation.fromProto(request.getRequest());
    try {
      client.dataClient().bulkMutateRows(batch);
    } catch (MutateRowsException e) {
      MutateRowsResult.Builder resultBuilder = MutateRowsResult.newBuilder();
      for (MutateRowsException.FailedMutation failed : e.getFailedMutations()) {
        resultBuilder
            .addEntriesBuilder()
            .setIndex(failed.getIndex())
            .setStatus(
                com.google.rpc.Status.newBuilder()
                    .setCode(failed.getError().getStatusCode().getCode().ordinal())
                    .setMessage(failed.getError().getMessage())
                    .build());
      }
      responseObserver.onNext(
          resultBuilder
              .setStatus(
                  com.google.rpc.Status.newBuilder()
                      .setCode(e.getStatusCode().getCode().ordinal())
                      .setMessage(e.getMessage())
                      .build())
              .build());
      responseObserver.onCompleted();
      return;
    } catch (ApiException e) {
      responseObserver.onNext(
          MutateRowsResult.newBuilder()
              .setStatus(
                  com.google.rpc.Status.newBuilder()
                      .setCode(e.getStatusCode().getCode().ordinal())
                      .setMessage(e.getMessage())
                      .build())
              .build());
      responseObserver.onCompleted();
      return;
    } catch (StatusRuntimeException e) {
      responseObserver.onNext(
          MutateRowsResult.newBuilder().setStatus(StatusProto.fromThrowable(e)).build());
      responseObserver.onCompleted();
      return;
    }

    responseObserver.onNext(
        MutateRowsResult.newBuilder()
            // Note that the default instance == OK
            .setStatus(com.google.rpc.Status.getDefaultInstance())
            .build());
    responseObserver.onCompleted();
  }

  @Override
  public void readRow(ReadRowRequest request, StreamObserver<RowResult> responseObserver) {
    CbtClient client;
    try {
      client = getClient(request.getClientId());
    } catch (StatusException e) {
      responseObserver.onError(e);
      return;
    }

    String tableId;
    try {
      tableId = extractTableIdFromTableName(request.getTableName());
    } catch (IllegalArgumentException e) {
      responseObserver.onError(
          Status.INVALID_ARGUMENT.withDescription(e.getMessage()).asException());
      return;
    }

    com.google.cloud.bigtable.data.v2.models.Row row;
    try {
      row =
          client
              .dataClient()
              .readRow(tableId, request.getRowKey(), FILTERS.fromProto(request.getFilter()));
      if (row != null) {
        RowResult.Builder resultBuilder = convertRowResult(row);
        responseObserver.onNext(
            // Note that the default instance == OK
            resultBuilder.setStatus(com.google.rpc.Status.getDefaultInstance()).build());
      } else {
        logger.info(String.format("readRow() did not find row: %s", request.getRowKey()));
      }
    } catch (ApiException e) {
      responseObserver.onNext(
          RowResult.newBuilder()
              .setStatus(
                  com.google.rpc.Status.newBuilder()
                      .setCode(e.getStatusCode().getCode().ordinal())
                      .setMessage(e.getMessage())
                      .build())
              .build());
      responseObserver.onCompleted();
      return;
    } catch (StatusRuntimeException e) {
      responseObserver.onNext(
          RowResult.newBuilder().setStatus(StatusProto.fromThrowable(e)).build());
      responseObserver.onCompleted();
      return;
    } catch (RuntimeException e) {
      // If client encounters problem, don't return any row result.
      responseObserver.onNext(
          RowResult.newBuilder()
              .setStatus(
                  com.google.rpc.Status.newBuilder()
                      .setCode(Code.INTERNAL.getNumber())
                      .setMessage(e.getMessage())
                      .build())
              .build());
      responseObserver.onCompleted();
      return;
    }
    responseObserver.onCompleted();
  }

  @Override
  public void readRows(ReadRowsRequest request, StreamObserver<RowsResult> responseObserver) {
    CbtClient client;
    try {
      client = getClient(request.getClientId());
    } catch (StatusException e) {
      responseObserver.onError(e);
      return;
    }

    ServerStream<com.google.cloud.bigtable.data.v2.models.Row> rows;
    Query query = Query.fromProto(request.getRequest());
    try {
      rows = client.dataClient().readRows(query);
      int cancelAfterRows = request.getCancelAfterRows();
      RowsResult.Builder resultBuilder = convertRowsResult(rows, cancelAfterRows);
      responseObserver.onNext(
          // Note that the default instance == OK
          resultBuilder.setStatus(com.google.rpc.Status.getDefaultInstance()).build());
    } catch (ApiException e) {
      responseObserver.onNext(
          RowsResult.newBuilder()
              .setStatus(
                  com.google.rpc.Status.newBuilder()
                      .setCode(e.getStatusCode().getCode().ordinal())
                      .setMessage(e.getMessage())
                      .build())
              .build());
      responseObserver.onCompleted();
      return;
    } catch (StatusRuntimeException e) {
      responseObserver.onNext(
          RowsResult.newBuilder().setStatus(StatusProto.fromThrowable(e)).build());
      responseObserver.onCompleted();
      return;
    } catch (RuntimeException e) {
      // If client encounters problem, don't return any row result.
      responseObserver.onNext(
          RowsResult.newBuilder()
              .setStatus(
                  com.google.rpc.Status.newBuilder()
                      .setCode(Code.INTERNAL.getNumber())
                      .setMessage(e.getMessage())
                      .build())
              .build());
      responseObserver.onCompleted();
      return;
    }

    responseObserver.onCompleted();
  }

  /**
   * Helper method to convert row from type com.google.cloud.bigtable.data.v2.models.Row to type
   * com.google.bigtable.v2.Row. After conversion, row cells within the same column and family are
   * grouped and ordered; the ordering of qualifiers within the same family is preserved; but the
   * ordering of families is not (the original order is not specified after all).
   *
   * @param row Logical row of type com.google.cloud.bigtable.data.v2.models.Row
   * @return the converted row in RowResult Builder
   */
  private static RowResult.Builder convertRowResult(
      com.google.cloud.bigtable.data.v2.models.Row row) {
    Row.Builder rowBuilder = Row.newBuilder();
    rowBuilder.setKey(row.getKey());

    Map<String, Map<ByteString, List<RowCell>>> grouped =
        row.getCells().stream()
            .collect(
                Collectors.groupingBy(
                    RowCell::getFamily,
                    Collectors.groupingBy(
                        RowCell::getQualifier, LinkedHashMap::new, Collectors.toList())));
    for (Map.Entry<String, Map<ByteString, List<RowCell>>> e : grouped.entrySet()) {
      Family.Builder family = rowBuilder.addFamiliesBuilder().setName(e.getKey());

      for (Map.Entry<ByteString, List<RowCell>> e2 : e.getValue().entrySet()) {
        Column.Builder column = family.addColumnsBuilder().setQualifier(e2.getKey());

        for (RowCell rowCell : e2.getValue()) {
          column
              .addCellsBuilder()
              .setTimestampMicros(rowCell.getTimestamp())
              .setValue(rowCell.getValue())
              .addAllLabels(rowCell.getLabels());
        }
      }
    }

    RowResult.Builder resultBuilder = RowResult.newBuilder();
    resultBuilder.setRow(rowBuilder.build());
    return resultBuilder;
  }

  /**
   * Helper method to convert rows from type com.google.cloud.bigtable.data.v2.models.Row to type
   * com.google.bigtable.v2.Row. Row order is preserved.
   *
   * @param rows Logical rows in ServerStream<com.google.cloud.bigtable.data.v2.models.Row>
   * @param cancelAfterRows Ignore the results after this row if set positive
   * @return the converted rows in RowsResult Builder
   */
  private static RowsResult.Builder convertRowsResult(
      ServerStream<com.google.cloud.bigtable.data.v2.models.Row> rows, int cancelAfterRows) {
    RowsResult.Builder resultBuilder = RowsResult.newBuilder();
    int rowCounter = 0;
    for (com.google.cloud.bigtable.data.v2.models.Row row : rows) {
      rowCounter++;
      RowResult.Builder rowResultBuilder = convertRowResult(row);
      resultBuilder.addRows(rowResultBuilder.getRow());

      if (cancelAfterRows > 0 && rowCounter >= cancelAfterRows) {
        logger.info(
            String.format("Canceling ReadRows() to respect cancel_after_rows=%d", cancelAfterRows));
        break;
      }
    }
    return resultBuilder;
  }

  @Override
  public void sampleRowKeys(
      SampleRowKeysRequest request, StreamObserver<SampleRowKeysResult> responseObserver) {
    CbtClient client;
    try {
      client = getClient(request.getClientId());
    } catch (StatusException e) {
      responseObserver.onError(e);
      return;
    }

    String tableId;
    try {
      tableId = extractTableIdFromTableName(request.getRequest().getTableName());
    } catch (IllegalArgumentException e) {
      responseObserver.onError(
          Status.INVALID_ARGUMENT.withDescription(e.getMessage()).asException());
      return;
    }

    List<KeyOffset> keyOffsets;
    try {
      keyOffsets = client.dataClient().sampleRowKeys(tableId);
    } catch (ApiException e) {
      responseObserver.onNext(
          SampleRowKeysResult.newBuilder()
              .setStatus(
                  com.google.rpc.Status.newBuilder()
                      .setCode(e.getStatusCode().getCode().ordinal())
                      .setMessage(e.getMessage())
                      .build())
              .build());
      responseObserver.onCompleted();
      return;
    } catch (StatusRuntimeException e) {
      responseObserver.onNext(
          SampleRowKeysResult.newBuilder().setStatus(StatusProto.fromThrowable(e)).build());
      responseObserver.onCompleted();
      return;
    }

    SampleRowKeysResult.Builder resultBuilder = SampleRowKeysResult.newBuilder();
    for (KeyOffset keyOffset : keyOffsets) {
      resultBuilder
          .addSamplesBuilder()
          .setRowKey(keyOffset.getKey())
          .setOffsetBytes(keyOffset.getOffsetBytes());
    }
    responseObserver.onNext(
        // Note that the default instance == OK
        resultBuilder.setStatus(com.google.rpc.Status.getDefaultInstance()).build());
    responseObserver.onCompleted();
  }

  @Override
  public void checkAndMutateRow(
      CheckAndMutateRowRequest request, StreamObserver<CheckAndMutateRowResult> responseObserver) {
    CbtClient client;
    try {
      client = getClient(request.getClientId());
    } catch (StatusException e) {
      responseObserver.onError(e);
      return;
    }

    ConditionalRowMutation mutation = ConditionalRowMutation.fromProto(request.getRequest());
    Boolean matched;
    try {
      matched = client.dataClient().checkAndMutateRow(mutation);
    } catch (ApiException e) {
      responseObserver.onNext(
          CheckAndMutateRowResult.newBuilder()
              .setStatus(
                  com.google.rpc.Status.newBuilder()
                      .setCode(e.getStatusCode().getCode().ordinal())
                      .setMessage(e.getMessage())
                      .build())
              .build());
      responseObserver.onCompleted();
      return;
    } catch (StatusRuntimeException e) {
      responseObserver.onNext(
          CheckAndMutateRowResult.newBuilder().setStatus(StatusProto.fromThrowable(e)).build());
      responseObserver.onCompleted();
      return;
    }

    CheckAndMutateRowResult.Builder resultBuilder = CheckAndMutateRowResult.newBuilder();
    resultBuilder.getResultBuilder().setPredicateMatched(matched);
    responseObserver.onNext(
        // Note that the default instance == OK
        resultBuilder.setStatus(com.google.rpc.Status.getDefaultInstance()).build());
    responseObserver.onCompleted();
  }

  @Override
  public void readModifyWriteRow(
      ReadModifyWriteRowRequest request, StreamObserver<RowResult> responseObserver) {
    CbtClient client;
    try {
      client = getClient(request.getClientId());
    } catch (StatusException e) {
      responseObserver.onError(e);
      return;
    }

    com.google.cloud.bigtable.data.v2.models.Row row;
    ReadModifyWriteRow mutation = ReadModifyWriteRow.fromProto(request.getRequest());
    try {
      row = client.dataClient().readModifyWriteRow(mutation);
      if (row != null) {
        RowResult.Builder resultBuilder = convertRowResult(row);
        responseObserver.onNext(
            // Note that the default instance == OK
            resultBuilder.setStatus(com.google.rpc.Status.getDefaultInstance()).build());
      } else {
        logger.info(
            String.format(
                "readModifyWriteRow() did not find row: %s", request.getRequest().getRowKey()));
      }
    } catch (ApiException e) {
      responseObserver.onNext(
          RowResult.newBuilder()
              .setStatus(
                  com.google.rpc.Status.newBuilder()
                      .setCode(e.getStatusCode().getCode().ordinal())
                      .setMessage(e.getMessage())
                      .build())
              .build());
      responseObserver.onCompleted();
      return;
    } catch (StatusRuntimeException e) {
      responseObserver.onNext(
          RowResult.newBuilder().setStatus(StatusProto.fromThrowable(e)).build());
      responseObserver.onCompleted();
      return;
    } catch (RuntimeException e) {
      // If client encounters problem, fail the whole operation.
      responseObserver.onNext(
          RowResult.newBuilder()
              .setStatus(
                  com.google.rpc.Status.newBuilder()
                      .setCode(Code.INTERNAL.getNumber())
                      .setMessage(e.getMessage())
                      .build())
              .build());
      responseObserver.onCompleted();
      return;
    }
    responseObserver.onCompleted();
  }

  @Override
  public void executeQuery(
      ExecuteQueryRequest request, StreamObserver<ExecuteQueryResult> responseObserver) {
    CbtClient client;
    try {
      client = getClient(request.getClientId());
    } catch (StatusException e) {
      responseObserver.onError(e);
      return;
    }
    ResultSet resultSet = null;
    try {
      Map<String, SqlType<?>> paramTypes = new HashMap<>();
      for (Map.Entry<String, Value> entry : request.getRequest().getParamsMap().entrySet()) {
        paramTypes.put(entry.getKey(), SqlType.fromProto(entry.getValue().getType()));
      }
      PreparedStatement preparedStatement =
          client.dataClient().prepareStatement(request.getRequest().getQuery(), paramTypes);
      resultSet =
          client
              .dataClient()
              .executeQuery(
                  BoundStatementDeserializer.toBoundStatement(preparedStatement, request));
      responseObserver.onNext(
          new ResultSetSerializer(request.getProtoDescriptors()).toExecuteQueryResult(resultSet));
    } catch (InterruptedException e) {
      responseObserver.onError(e);
      return;
    } catch (ExecutionException e) {
      responseObserver.onError(e);
      return;
    } catch (ApiException e) {
      responseObserver.onNext(
          ExecuteQueryResult.newBuilder()
              .setStatus(
                  com.google.rpc.Status.newBuilder()
                      .setCode(e.getStatusCode().getCode().ordinal())
                      .setMessage(e.getMessage())
                      .build())
              .build());
      responseObserver.onCompleted();
      return;
    } catch (StatusRuntimeException e) {
      responseObserver.onNext(
          ExecuteQueryResult.newBuilder().setStatus(StatusProto.fromThrowable(e)).build());
      responseObserver.onCompleted();
      return;
    } catch (RuntimeException e) {
      // If client encounters problem, don't return any results.
      responseObserver.onNext(
          ExecuteQueryResult.newBuilder()
              .setStatus(
                  com.google.rpc.Status.newBuilder()
                      .setCode(Code.INTERNAL.getNumber())
                      .setMessage(e.getMessage())
                      .build())
              .build());
      responseObserver.onCompleted();
      return;
    } finally {
      if (resultSet != null) {
        resultSet.close();
      }
    }
    responseObserver.onCompleted();
  }

  @Override
  public synchronized void close() {
    Iterator<Map.Entry<String, CbtClient>> it = idClientMap.entrySet().iterator();
    while (it.hasNext()) {
      Map.Entry<String, CbtClient> entry = it.next();
      entry.getValue().dataClient().close();
      it.remove();
    }
  }

  private static String extractTableIdFromTableName(String fullTableName)
      throws IllegalArgumentException {
    Matcher matcher = tablePattern.matcher(fullTableName);
    if (!matcher.matches()) {
      throw new IllegalArgumentException("Invalid table name: " + fullTableName);
    }
    return matcher.group(3);
  }

  @SuppressWarnings("rawtypes")
  private InstantiatingGrpcChannelProvider getTransportChannel(
      boolean encrypted, String rootCertsPem, String sslTarget) {
    if (!encrypted) {
      return EnhancedBigtableStubSettings.defaultGrpcTransportProviderBuilder()
          .setChannelConfigurator(ManagedChannelBuilder::usePlaintext)
          .build();
    }

    final SslContext sslContext;
    if (rootCertsPem.isEmpty()) {
      sslContext = null;
    } else {
      try {
        sslContext =
            GrpcSslContexts.forClient()
                .trustManager(new ByteArrayInputStream(rootCertsPem.getBytes(UTF_8)))
                .build();
      } catch (IOException e) {
        throw new IllegalArgumentException(e);
      }
    }

    return EnhancedBigtableStubSettings.defaultGrpcTransportProviderBuilder()
        .setChannelConfigurator(
            new ApiFunction<ManagedChannelBuilder, ManagedChannelBuilder>() {
              @Override
              public ManagedChannelBuilder apply(ManagedChannelBuilder input) {
                NettyChannelBuilder channelBuilder = (NettyChannelBuilder) input;

                // The default replaces long (several KiB) error messages with "http2 exception"
                channelBuilder.maxInboundMetadataSize(Integer.MAX_VALUE);

                if (sslContext != null) {
                  channelBuilder.sslContext(sslContext);
                }

                if (!sslTarget.isEmpty()) {
                  channelBuilder.overrideAuthority(sslTarget);
                }

                return channelBuilder;
              }
            })
        .build();
  }

  private CredentialsProvider getCredentialsProvider(String accessToken) {
    if (accessToken.isEmpty()) {
      return NoCredentialsProvider.create();
    }

    return FixedCredentialsProvider.create(
        OAuth2Credentials.create(new AccessToken(accessToken, null)));
  }

  private final ConcurrentHashMap<String, CbtClient> idClientMap;

  private static final Pattern tablePattern =
      Pattern.compile("projects/([^/]+)/instances/([^/]+)/tables/([^/]+)");
}
