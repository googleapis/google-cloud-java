/*
 * Copyright 2026 Google LLC
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

package com.google.cloud.bigtable.data.v2.internal.session;

import com.google.bigtable.v2.AuthorizedViewRequest;
import com.google.bigtable.v2.AuthorizedViewResponse;
import com.google.bigtable.v2.BigtableGrpc;
import com.google.bigtable.v2.MaterializedViewRequest;
import com.google.bigtable.v2.MaterializedViewResponse;
import com.google.bigtable.v2.MutateRowRequest;
import com.google.bigtable.v2.OpenAuthorizedViewRequest;
import com.google.bigtable.v2.OpenMaterializedViewRequest;
import com.google.bigtable.v2.OpenTableRequest;
import com.google.bigtable.v2.ReadRowsRequest;
import com.google.bigtable.v2.RowSet;
import com.google.bigtable.v2.SessionMutateRowRequest;
import com.google.bigtable.v2.SessionMutateRowResponse;
import com.google.bigtable.v2.SessionReadRowRequest;
import com.google.bigtable.v2.SessionReadRowResponse;
import com.google.bigtable.v2.SessionRequest;
import com.google.bigtable.v2.SessionResponse;
import com.google.bigtable.v2.SessionType;
import com.google.bigtable.v2.TableRequest;
import com.google.bigtable.v2.TableResponse;
import com.google.cloud.bigtable.data.v2.internal.csm.attributes.MethodInfo;
import com.google.common.base.Preconditions;
import com.google.common.collect.ImmutableMap;
import com.google.protobuf.ByteString;
import com.google.protobuf.InvalidProtocolBufferException;
import com.google.protobuf.Message;
import io.grpc.MethodDescriptor;
import java.util.Map;
import java.util.function.BiConsumer;
import java.util.function.Function;

/**
 * Static descriptor for virtual RPCs.
 *
 * <p>Contains a const for each supported vRPC. The descriptors help ensure vRPC are statically
 * typed and provide encoding/decoding.
 *
 * <p>The structure of the descriptor is to have a constant for each vRPC and the constant is
 * defined using a pair of encoder/decoder factories for that vRPC family.
 */
public final class VRpcDescriptor<OpenReqT extends Message, ReqT, RespT> {
  public static final SessionDescriptor<OpenTableRequest> TABLE_SESSION =
      new SessionDescriptor<>(
          BigtableGrpc.getOpenTableMethod(),
          r ->
              String.format(
                  "%s(%s, %s, %s)",
                  SessionType.SESSION_TYPE_TABLE,
                  r.getTableName(),
                  r.getAppProfileId(),
                  r.getPermission()),
          r ->
              ImmutableMap.of(
                  "open_session.payload.table_name", r.getTableName(),
                  "open_session.payload.app_profile_id", r.getAppProfileId(),
                  "open_session.payload.permission", r.getPermission().name()));

  public static final SessionDescriptor<OpenAuthorizedViewRequest> AUTHORIZED_VIEW_SESSION =
      new SessionDescriptor<>(
          BigtableGrpc.getOpenAuthorizedViewMethod(),
          r ->
              String.format(
                  "%s(%s, %s, %s)",
                  SessionType.SESSION_TYPE_AUTHORIZED_VIEW,
                  r.getAuthorizedViewName(),
                  r.getAppProfileId(),
                  r.getPermission()),
          r ->
              ImmutableMap.of(
                  "open_session.payload.authorized_view_name",
                  r.getAuthorizedViewName(),
                  "open_session.payload.app_profile_id",
                  r.getAppProfileId(),
                  "open_session.payload.permission",
                  r.getPermission().name()));

  public static final SessionDescriptor<OpenMaterializedViewRequest> MATERIALIZED_VIEW_SESSION =
      new SessionDescriptor<>(
          BigtableGrpc.getOpenMaterializedViewMethod(),
          r ->
              String.format(
                  "%s(%s, %s, %s)",
                  SessionType.SESSION_TYPE_MATERIALIZED_VIEW,
                  r.getMaterializedViewName(),
                  r.getAppProfileId(),
                  r.getPermission()),
          r ->
              ImmutableMap.of(
                  "open_session.payload.materialized_view_name",
                  r.getMaterializedViewName(),
                  "open_session.payload.app_profile_id",
                  r.getAppProfileId(),
                  "open_session.payload.permission",
                  r.getPermission().name()));

  // region vRPC definitions
  public static final VRpcDescriptor<
          OpenTableRequest, SessionReadRowRequest, SessionReadRowResponse>
      READ_ROW =
          new VRpcDescriptor<>(
              TABLE_SESSION,
              MethodInfo.of("Bigtable.ReadRow", false),
              createTableEncoder(TableRequest.Builder::setReadRow),
              createTableDecoder(TableResponse::getReadRow),
              (name, appProfileId, req) ->
                  ReadRowsRequest.newBuilder()
                      .setTableName(name)
                      .setAppProfileId(appProfileId)
                      .setRows(RowSet.newBuilder().addRowKeys(req.getKey()).build())
                      .setFilter(req.getFilter())
                      .setRowsLimit(1)
                      .build());

  public static final VRpcDescriptor<
          OpenTableRequest, SessionMutateRowRequest, SessionMutateRowResponse>
      MUTATE_ROW =
          new VRpcDescriptor<>(
              TABLE_SESSION,
              MethodInfo.of("Bigtable.MutateRow", false),
              createTableEncoder(TableRequest.Builder::setMutateRow),
              createTableDecoder(TableResponse::getMutateRow),
              (name, appProfileId, req) ->
                  MutateRowRequest.newBuilder()
                      .setTableName(name)
                      .setAppProfileId(appProfileId)
                      .setRowKey(req.getKey())
                      .addAllMutations(req.getMutationsList())
                      .build());

  public static final VRpcDescriptor<
          OpenAuthorizedViewRequest, SessionReadRowRequest, SessionReadRowResponse>
      READ_ROW_AUTH_VIEW =
          new VRpcDescriptor<>(
              AUTHORIZED_VIEW_SESSION,
              MethodInfo.of("Bigtable.ReadRow", false),
              createAuthViewEncoder(AuthorizedViewRequest.Builder::setReadRow),
              createAuthViewDecoder(AuthorizedViewResponse::getReadRow),
              (name, appProfileId, req) ->
                  ReadRowsRequest.newBuilder()
                      .setAuthorizedViewName(name)
                      .setAppProfileId(appProfileId)
                      .setRows(RowSet.newBuilder().addRowKeys(req.getKey()).build())
                      .setFilter(req.getFilter())
                      .setRowsLimit(1)
                      .build());

  public static final VRpcDescriptor<
          OpenAuthorizedViewRequest, SessionMutateRowRequest, SessionMutateRowResponse>
      MUTATE_ROW_AUTH_VIEW =
          new VRpcDescriptor<>(
              AUTHORIZED_VIEW_SESSION,
              MethodInfo.of("Bigtable.MutateRow", false),
              createAuthViewEncoder(AuthorizedViewRequest.Builder::setMutateRow),
              createAuthViewDecoder(AuthorizedViewResponse::getMutateRow),
              (name, appProfileId, req) ->
                  MutateRowRequest.newBuilder()
                      .setAuthorizedViewName(name)
                      .setAppProfileId(appProfileId)
                      .setRowKey(req.getKey())
                      .addAllMutations(req.getMutationsList())
                      .build());

  public static final VRpcDescriptor<
          OpenMaterializedViewRequest, SessionReadRowRequest, SessionReadRowResponse>
      READ_ROW_MAT_VIEW =
          new VRpcDescriptor<>(
              MATERIALIZED_VIEW_SESSION,
              MethodInfo.of("Bigtable.ReadRow", false),
              createMatViewEncoder(MaterializedViewRequest.Builder::setReadRow),
              createMatViewDecoder(MaterializedViewResponse::getReadRow),
              (name, appProfileId, req) ->
                  ReadRowsRequest.newBuilder()
                      .setMaterializedViewName(name)
                      .setAppProfileId(appProfileId)
                      .setRows(RowSet.newBuilder().addRowKeys(req.getKey()).build())
                      .setFilter(req.getFilter())
                      .setRowsLimit(1)
                      .build());

  // endregion

  // region vRPC family encoder/decoder factories
  private static <ReqT> Encoder<ReqT> createTableEncoder(
      BiConsumer<TableRequest.Builder, ReqT> subEncoder) {
    return req -> {
      TableRequest.Builder builder = TableRequest.newBuilder();
      subEncoder.accept(builder, req);
      return builder.build().toByteString();
    };
  }

  private static <RespT> Decoder<RespT> createTableDecoder(
      Function<TableResponse, RespT> subDecoder) {
    return (bytes) -> subDecoder.apply(TableResponse.parseFrom(bytes));
  }

  private static <ReqT> Encoder<ReqT> createAuthViewEncoder(
      BiConsumer<AuthorizedViewRequest.Builder, ReqT> subEncoder) {
    return req -> {
      AuthorizedViewRequest.Builder builder = AuthorizedViewRequest.newBuilder();
      subEncoder.accept(builder, req);
      return builder.build().toByteString();
    };
  }

  private static <RespT> Decoder<RespT> createAuthViewDecoder(
      Function<AuthorizedViewResponse, RespT> subDecoder) {
    return (bytes) -> subDecoder.apply(AuthorizedViewResponse.parseFrom(bytes));
  }

  private static <ReqT> Encoder<ReqT> createMatViewEncoder(
      BiConsumer<MaterializedViewRequest.Builder, ReqT> subEncoder) {
    return req -> {
      MaterializedViewRequest.Builder builder = MaterializedViewRequest.newBuilder();
      subEncoder.accept(builder, req);
      return builder.build().toByteString();
    };
  }

  private static <RespT> Decoder<RespT> createMatViewDecoder(
      Function<MaterializedViewResponse, RespT> subDecoder) {
    return (bytes) -> subDecoder.apply(MaterializedViewResponse.parseFrom(bytes));
  }

  // endregion

  private final SessionDescriptor<OpenReqT> session;
  private final MethodInfo methodInfo;
  private final Encoder<ReqT> encoder;
  private final Decoder<RespT> decoder;
  private final LegacyConverter<ReqT> legacyConverter;

  VRpcDescriptor(
      SessionDescriptor<OpenReqT> session,
      MethodInfo methodInfo,
      Encoder<ReqT> encoder,
      Decoder<RespT> decoder,
      LegacyConverter<ReqT> legacyConverter) {
    this.session = session;
    this.methodInfo = methodInfo;
    this.encoder = encoder;
    this.decoder = decoder;
    this.legacyConverter = legacyConverter;
  }

  public SessionDescriptor<OpenReqT> getSessionDescriptor() {
    return session;
  }

  public MethodInfo getMethodInfo() {
    return methodInfo;
  }

  public RespT decode(ByteString bytes) throws InvalidProtocolBufferException {
    return decoder.decode(bytes);
  }

  public ByteString encode(ReqT req) {
    return encoder.encode(req);
  }

  public Message toLegacyProto(String name, String appProfileId, ReqT sessionRequest) {
    return legacyConverter.convert(name, appProfileId, sessionRequest);
  }

  interface Decoder<RespT> {
    RespT decode(ByteString bytes) throws InvalidProtocolBufferException;
  }

  interface Encoder<ReqT> {
    ByteString encode(ReqT req);
  }

  @FunctionalInterface
  interface LegacyConverter<ReqT> {
    Message convert(String name, String appProfileId, ReqT sessionRequest);
  }

  public static final class SessionDescriptor<OpenReqT extends Message> {
    private final SessionType type;
    private final MethodDescriptor<SessionRequest, SessionResponse> methodDescriptor;
    private final Function<OpenReqT, Map<String, String>> headerPopulator;
    private final Function<OpenReqT, String> logNameExtractor;

    public SessionDescriptor(
        MethodDescriptor<SessionRequest, SessionResponse> methodDescriptor,
        Function<OpenReqT, String> logNameExtractor,
        Function<OpenReqT, Map<String, String>> headerPopulator) {
      this.type = SessionUtil.extractSessionTypeFromMethod(methodDescriptor);
      this.methodDescriptor = methodDescriptor;
      this.logNameExtractor = logNameExtractor;
      this.headerPopulator = headerPopulator;
    }

    public SessionType getType() {
      return type;
    }

    public MethodDescriptor<SessionRequest, SessionResponse> getMethodDescriptor() {
      return methodDescriptor;
    }

    public Map<String, String> extractHeaderParams(OpenReqT req) {
      Preconditions.checkArgument(SessionUtil.extractOpenSessionTypeFromOpenMsg(req) == type);
      return headerPopulator.apply(req);
    }

    public String getLogName(OpenReqT req) {
      return logNameExtractor.apply(req);
    }
  }
}
