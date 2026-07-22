/*
 * Copyright 2026 Google LLC
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

package com.google.cloud.sql.v1beta4.stub;

import com.google.api.core.BetaApi;
import com.google.api.gax.core.BackgroundResource;
import com.google.api.gax.core.BackgroundResourceAggregation;
import com.google.api.gax.grpc.GrpcCallSettings;
import com.google.api.gax.grpc.GrpcStubCallableFactory;
import com.google.api.gax.rpc.ClientContext;
import com.google.api.gax.rpc.RequestParamsBuilder;
import com.google.api.gax.rpc.UnaryCallable;
import com.google.api.pathtemplate.PathTemplate;
import com.google.cloud.sql.v1beta4.Operation;
import com.google.cloud.sql.v1beta4.SqlSslCertsDeleteRequest;
import com.google.cloud.sql.v1beta4.SqlSslCertsGetRequest;
import com.google.cloud.sql.v1beta4.SqlSslCertsInsertRequest;
import com.google.cloud.sql.v1beta4.SqlSslCertsListRequest;
import com.google.cloud.sql.v1beta4.SslCert;
import com.google.cloud.sql.v1beta4.SslCertsInsertResponse;
import com.google.cloud.sql.v1beta4.SslCertsListResponse;
import com.google.longrunning.stub.GrpcOperationsStub;
import io.grpc.MethodDescriptor;
import io.grpc.protobuf.ProtoUtils;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.TimeUnit;
import javax.annotation.Generated;
import org.jspecify.annotations.NullMarked;

// AUTO-GENERATED DOCUMENTATION AND CLASS.
/**
 * gRPC stub implementation for the SqlSslCertsService service API.
 *
 * <p>This class is for advanced usage and reflects the underlying API directly.
 */
@NullMarked
@BetaApi
@Generated("by gapic-generator-java")
public class GrpcSqlSslCertsServiceStub extends SqlSslCertsServiceStub {
  private static final MethodDescriptor<SqlSslCertsDeleteRequest, Operation>
      deleteMethodDescriptor =
          MethodDescriptor.<SqlSslCertsDeleteRequest, Operation>newBuilder()
              .setType(MethodDescriptor.MethodType.UNARY)
              .setFullMethodName("google.cloud.sql.v1beta4.SqlSslCertsService/Delete")
              .setRequestMarshaller(
                  ProtoUtils.marshaller(SqlSslCertsDeleteRequest.getDefaultInstance()))
              .setResponseMarshaller(ProtoUtils.marshaller(Operation.getDefaultInstance()))
              .setSampledToLocalTracing(true)
              .build();

  private static final MethodDescriptor<SqlSslCertsGetRequest, SslCert> getMethodDescriptor =
      MethodDescriptor.<SqlSslCertsGetRequest, SslCert>newBuilder()
          .setType(MethodDescriptor.MethodType.UNARY)
          .setFullMethodName("google.cloud.sql.v1beta4.SqlSslCertsService/Get")
          .setRequestMarshaller(ProtoUtils.marshaller(SqlSslCertsGetRequest.getDefaultInstance()))
          .setResponseMarshaller(ProtoUtils.marshaller(SslCert.getDefaultInstance()))
          .setSampledToLocalTracing(true)
          .build();

  private static final MethodDescriptor<SqlSslCertsInsertRequest, SslCertsInsertResponse>
      insertMethodDescriptor =
          MethodDescriptor.<SqlSslCertsInsertRequest, SslCertsInsertResponse>newBuilder()
              .setType(MethodDescriptor.MethodType.UNARY)
              .setFullMethodName("google.cloud.sql.v1beta4.SqlSslCertsService/Insert")
              .setRequestMarshaller(
                  ProtoUtils.marshaller(SqlSslCertsInsertRequest.getDefaultInstance()))
              .setResponseMarshaller(
                  ProtoUtils.marshaller(SslCertsInsertResponse.getDefaultInstance()))
              .setSampledToLocalTracing(true)
              .build();

  private static final MethodDescriptor<SqlSslCertsListRequest, SslCertsListResponse>
      listMethodDescriptor =
          MethodDescriptor.<SqlSslCertsListRequest, SslCertsListResponse>newBuilder()
              .setType(MethodDescriptor.MethodType.UNARY)
              .setFullMethodName("google.cloud.sql.v1beta4.SqlSslCertsService/List")
              .setRequestMarshaller(
                  ProtoUtils.marshaller(SqlSslCertsListRequest.getDefaultInstance()))
              .setResponseMarshaller(
                  ProtoUtils.marshaller(SslCertsListResponse.getDefaultInstance()))
              .setSampledToLocalTracing(true)
              .build();

  private final UnaryCallable<SqlSslCertsDeleteRequest, Operation> deleteCallable;
  private final UnaryCallable<SqlSslCertsGetRequest, SslCert> getCallable;
  private final UnaryCallable<SqlSslCertsInsertRequest, SslCertsInsertResponse> insertCallable;
  private final UnaryCallable<SqlSslCertsListRequest, SslCertsListResponse> listCallable;

  private final BackgroundResource backgroundResources;
  private final GrpcOperationsStub operationsStub;
  private final GrpcStubCallableFactory callableFactory;

  private static final PathTemplate DELETE_RESOURCE_NAME_TEMPLATE =
      PathTemplate.create("projects/{project}/instances/{instance}/sslCerts/{sha1_fingerprint}");
  private static final PathTemplate GET_RESOURCE_NAME_TEMPLATE =
      PathTemplate.create("projects/{project}/instances/{instance}/sslCerts/{sha1_fingerprint}");
  private static final PathTemplate INSERT_RESOURCE_NAME_TEMPLATE =
      PathTemplate.create("projects/{project}/instances/{instance}");
  private static final PathTemplate LIST_RESOURCE_NAME_TEMPLATE =
      PathTemplate.create("projects/{project}/instances/{instance}");

  public static final GrpcSqlSslCertsServiceStub create(SqlSslCertsServiceStubSettings settings)
      throws IOException {
    return new GrpcSqlSslCertsServiceStub(settings, ClientContext.create(settings));
  }

  public static final GrpcSqlSslCertsServiceStub create(ClientContext clientContext)
      throws IOException {
    return new GrpcSqlSslCertsServiceStub(
        SqlSslCertsServiceStubSettings.newBuilder().build(), clientContext);
  }

  public static final GrpcSqlSslCertsServiceStub create(
      ClientContext clientContext, GrpcStubCallableFactory callableFactory) throws IOException {
    return new GrpcSqlSslCertsServiceStub(
        SqlSslCertsServiceStubSettings.newBuilder().build(), clientContext, callableFactory);
  }

  /**
   * Constructs an instance of GrpcSqlSslCertsServiceStub, using the given settings. This is
   * protected so that it is easy to make a subclass, but otherwise, the static factory methods
   * should be preferred.
   */
  protected GrpcSqlSslCertsServiceStub(
      SqlSslCertsServiceStubSettings settings, ClientContext clientContext) throws IOException {
    this(settings, clientContext, new GrpcSqlSslCertsServiceCallableFactory());
  }

  /**
   * Constructs an instance of GrpcSqlSslCertsServiceStub, using the given settings. This is
   * protected so that it is easy to make a subclass, but otherwise, the static factory methods
   * should be preferred.
   */
  protected GrpcSqlSslCertsServiceStub(
      SqlSslCertsServiceStubSettings settings,
      ClientContext clientContext,
      GrpcStubCallableFactory callableFactory)
      throws IOException {
    this.callableFactory = callableFactory;
    this.operationsStub = GrpcOperationsStub.create(clientContext, callableFactory);

    GrpcCallSettings<SqlSslCertsDeleteRequest, Operation> deleteTransportSettings =
        GrpcCallSettings.<SqlSslCertsDeleteRequest, Operation>newBuilder()
            .setMethodDescriptor(deleteMethodDescriptor)
            .setParamsExtractor(
                request -> {
                  RequestParamsBuilder builder = RequestParamsBuilder.create();
                  builder.add("instance", String.valueOf(request.getInstance()));
                  builder.add("project", String.valueOf(request.getProject()));
                  builder.add("sha1_fingerprint", String.valueOf(request.getSha1Fingerprint()));
                  return builder.build();
                })
            .setResourceNameExtractor(
                request -> {
                  Map<String, String> resourceNameSegments = new HashMap<String, String>();
                  resourceNameSegments.put("instance", String.valueOf(request.getInstance()));
                  resourceNameSegments.put("project", String.valueOf(request.getProject()));
                  resourceNameSegments.put(
                      "sha1_fingerprint", String.valueOf(request.getSha1Fingerprint()));
                  return DELETE_RESOURCE_NAME_TEMPLATE.instantiate(resourceNameSegments);
                })
            .build();
    GrpcCallSettings<SqlSslCertsGetRequest, SslCert> getTransportSettings =
        GrpcCallSettings.<SqlSslCertsGetRequest, SslCert>newBuilder()
            .setMethodDescriptor(getMethodDescriptor)
            .setParamsExtractor(
                request -> {
                  RequestParamsBuilder builder = RequestParamsBuilder.create();
                  builder.add("instance", String.valueOf(request.getInstance()));
                  builder.add("project", String.valueOf(request.getProject()));
                  builder.add("sha1_fingerprint", String.valueOf(request.getSha1Fingerprint()));
                  return builder.build();
                })
            .setResourceNameExtractor(
                request -> {
                  Map<String, String> resourceNameSegments = new HashMap<String, String>();
                  resourceNameSegments.put("instance", String.valueOf(request.getInstance()));
                  resourceNameSegments.put("project", String.valueOf(request.getProject()));
                  resourceNameSegments.put(
                      "sha1_fingerprint", String.valueOf(request.getSha1Fingerprint()));
                  return GET_RESOURCE_NAME_TEMPLATE.instantiate(resourceNameSegments);
                })
            .build();
    GrpcCallSettings<SqlSslCertsInsertRequest, SslCertsInsertResponse> insertTransportSettings =
        GrpcCallSettings.<SqlSslCertsInsertRequest, SslCertsInsertResponse>newBuilder()
            .setMethodDescriptor(insertMethodDescriptor)
            .setParamsExtractor(
                request -> {
                  RequestParamsBuilder builder = RequestParamsBuilder.create();
                  builder.add("instance", String.valueOf(request.getInstance()));
                  builder.add("project", String.valueOf(request.getProject()));
                  return builder.build();
                })
            .setResourceNameExtractor(
                request -> {
                  Map<String, String> resourceNameSegments = new HashMap<String, String>();
                  resourceNameSegments.put("instance", String.valueOf(request.getInstance()));
                  resourceNameSegments.put("project", String.valueOf(request.getProject()));
                  return INSERT_RESOURCE_NAME_TEMPLATE.instantiate(resourceNameSegments);
                })
            .build();
    GrpcCallSettings<SqlSslCertsListRequest, SslCertsListResponse> listTransportSettings =
        GrpcCallSettings.<SqlSslCertsListRequest, SslCertsListResponse>newBuilder()
            .setMethodDescriptor(listMethodDescriptor)
            .setParamsExtractor(
                request -> {
                  RequestParamsBuilder builder = RequestParamsBuilder.create();
                  builder.add("instance", String.valueOf(request.getInstance()));
                  builder.add("project", String.valueOf(request.getProject()));
                  return builder.build();
                })
            .setResourceNameExtractor(
                request -> {
                  Map<String, String> resourceNameSegments = new HashMap<String, String>();
                  resourceNameSegments.put("instance", String.valueOf(request.getInstance()));
                  resourceNameSegments.put("project", String.valueOf(request.getProject()));
                  return LIST_RESOURCE_NAME_TEMPLATE.instantiate(resourceNameSegments);
                })
            .build();

    this.deleteCallable =
        callableFactory.createUnaryCallable(
            deleteTransportSettings, settings.deleteSettings(), clientContext);
    this.getCallable =
        callableFactory.createUnaryCallable(
            getTransportSettings, settings.getSettings(), clientContext);
    this.insertCallable =
        callableFactory.createUnaryCallable(
            insertTransportSettings, settings.insertSettings(), clientContext);
    this.listCallable =
        callableFactory.createUnaryCallable(
            listTransportSettings, settings.listSettings(), clientContext);

    this.backgroundResources =
        new BackgroundResourceAggregation(clientContext.getBackgroundResources());
  }

  public GrpcOperationsStub getOperationsStub() {
    return operationsStub;
  }

  @Override
  public UnaryCallable<SqlSslCertsDeleteRequest, Operation> deleteCallable() {
    return deleteCallable;
  }

  @Override
  public UnaryCallable<SqlSslCertsGetRequest, SslCert> getCallable() {
    return getCallable;
  }

  @Override
  public UnaryCallable<SqlSslCertsInsertRequest, SslCertsInsertResponse> insertCallable() {
    return insertCallable;
  }

  @Override
  public UnaryCallable<SqlSslCertsListRequest, SslCertsListResponse> listCallable() {
    return listCallable;
  }

  @Override
  public final void close() {
    try {
      backgroundResources.close();
    } catch (RuntimeException e) {
      throw e;
    } catch (Exception e) {
      throw new IllegalStateException("Failed to close resource", e);
    }
  }

  @Override
  public void shutdown() {
    backgroundResources.shutdown();
  }

  @Override
  public boolean isShutdown() {
    return backgroundResources.isShutdown();
  }

  @Override
  public boolean isTerminated() {
    return backgroundResources.isTerminated();
  }

  @Override
  public void shutdownNow() {
    backgroundResources.shutdownNow();
  }

  @Override
  public boolean awaitTermination(long duration, TimeUnit unit) throws InterruptedException {
    return backgroundResources.awaitTermination(duration, unit);
  }
}
