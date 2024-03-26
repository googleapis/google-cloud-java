/*
 * Copyright 2024 Google LLC
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

package com.google.api.cloudquotas.v1.stub;

import static com.google.api.cloudquotas.v1.CloudQuotasClient.ListQuotaInfosPagedResponse;
import static com.google.api.cloudquotas.v1.CloudQuotasClient.ListQuotaPreferencesPagedResponse;

import com.google.api.cloudquotas.v1.CreateQuotaPreferenceRequest;
import com.google.api.cloudquotas.v1.GetQuotaInfoRequest;
import com.google.api.cloudquotas.v1.GetQuotaPreferenceRequest;
import com.google.api.cloudquotas.v1.ListQuotaInfosRequest;
import com.google.api.cloudquotas.v1.ListQuotaInfosResponse;
import com.google.api.cloudquotas.v1.ListQuotaPreferencesRequest;
import com.google.api.cloudquotas.v1.ListQuotaPreferencesResponse;
import com.google.api.cloudquotas.v1.QuotaInfo;
import com.google.api.cloudquotas.v1.QuotaPreference;
import com.google.api.cloudquotas.v1.UpdateQuotaPreferenceRequest;
import com.google.api.gax.core.BackgroundResource;
import com.google.api.gax.core.BackgroundResourceAggregation;
import com.google.api.gax.grpc.GrpcCallSettings;
import com.google.api.gax.grpc.GrpcStubCallableFactory;
import com.google.api.gax.rpc.ClientContext;
import com.google.api.gax.rpc.RequestParamsBuilder;
import com.google.api.gax.rpc.UnaryCallable;
import com.google.longrunning.stub.GrpcOperationsStub;
import io.grpc.MethodDescriptor;
import io.grpc.protobuf.ProtoUtils;
import java.io.IOException;
import java.util.Map;
import java.util.concurrent.TimeUnit;
import javax.annotation.Generated;

// AUTO-GENERATED DOCUMENTATION AND CLASS.
/**
 * gRPC stub implementation for the CloudQuotas service API.
 *
 * <p>This class is for advanced usage and reflects the underlying API directly.
 */
@Generated("by gapic-generator-java")
public class GrpcCloudQuotasStub extends CloudQuotasStub {
  private static final MethodDescriptor<ListQuotaInfosRequest, ListQuotaInfosResponse>
      listQuotaInfosMethodDescriptor =
          MethodDescriptor.<ListQuotaInfosRequest, ListQuotaInfosResponse>newBuilder()
              .setType(MethodDescriptor.MethodType.UNARY)
              .setFullMethodName("google.api.cloudquotas.v1.CloudQuotas/ListQuotaInfos")
              .setRequestMarshaller(
                  ProtoUtils.marshaller(ListQuotaInfosRequest.getDefaultInstance()))
              .setResponseMarshaller(
                  ProtoUtils.marshaller(ListQuotaInfosResponse.getDefaultInstance()))
              .build();

  private static final MethodDescriptor<GetQuotaInfoRequest, QuotaInfo>
      getQuotaInfoMethodDescriptor =
          MethodDescriptor.<GetQuotaInfoRequest, QuotaInfo>newBuilder()
              .setType(MethodDescriptor.MethodType.UNARY)
              .setFullMethodName("google.api.cloudquotas.v1.CloudQuotas/GetQuotaInfo")
              .setRequestMarshaller(ProtoUtils.marshaller(GetQuotaInfoRequest.getDefaultInstance()))
              .setResponseMarshaller(ProtoUtils.marshaller(QuotaInfo.getDefaultInstance()))
              .build();

  private static final MethodDescriptor<ListQuotaPreferencesRequest, ListQuotaPreferencesResponse>
      listQuotaPreferencesMethodDescriptor =
          MethodDescriptor.<ListQuotaPreferencesRequest, ListQuotaPreferencesResponse>newBuilder()
              .setType(MethodDescriptor.MethodType.UNARY)
              .setFullMethodName("google.api.cloudquotas.v1.CloudQuotas/ListQuotaPreferences")
              .setRequestMarshaller(
                  ProtoUtils.marshaller(ListQuotaPreferencesRequest.getDefaultInstance()))
              .setResponseMarshaller(
                  ProtoUtils.marshaller(ListQuotaPreferencesResponse.getDefaultInstance()))
              .build();

  private static final MethodDescriptor<GetQuotaPreferenceRequest, QuotaPreference>
      getQuotaPreferenceMethodDescriptor =
          MethodDescriptor.<GetQuotaPreferenceRequest, QuotaPreference>newBuilder()
              .setType(MethodDescriptor.MethodType.UNARY)
              .setFullMethodName("google.api.cloudquotas.v1.CloudQuotas/GetQuotaPreference")
              .setRequestMarshaller(
                  ProtoUtils.marshaller(GetQuotaPreferenceRequest.getDefaultInstance()))
              .setResponseMarshaller(ProtoUtils.marshaller(QuotaPreference.getDefaultInstance()))
              .build();

  private static final MethodDescriptor<CreateQuotaPreferenceRequest, QuotaPreference>
      createQuotaPreferenceMethodDescriptor =
          MethodDescriptor.<CreateQuotaPreferenceRequest, QuotaPreference>newBuilder()
              .setType(MethodDescriptor.MethodType.UNARY)
              .setFullMethodName("google.api.cloudquotas.v1.CloudQuotas/CreateQuotaPreference")
              .setRequestMarshaller(
                  ProtoUtils.marshaller(CreateQuotaPreferenceRequest.getDefaultInstance()))
              .setResponseMarshaller(ProtoUtils.marshaller(QuotaPreference.getDefaultInstance()))
              .build();

  private static final MethodDescriptor<UpdateQuotaPreferenceRequest, QuotaPreference>
      updateQuotaPreferenceMethodDescriptor =
          MethodDescriptor.<UpdateQuotaPreferenceRequest, QuotaPreference>newBuilder()
              .setType(MethodDescriptor.MethodType.UNARY)
              .setFullMethodName("google.api.cloudquotas.v1.CloudQuotas/UpdateQuotaPreference")
              .setRequestMarshaller(
                  ProtoUtils.marshaller(UpdateQuotaPreferenceRequest.getDefaultInstance()))
              .setResponseMarshaller(ProtoUtils.marshaller(QuotaPreference.getDefaultInstance()))
              .build();

  private final UnaryCallable<ListQuotaInfosRequest, ListQuotaInfosResponse> listQuotaInfosCallable;
  private final UnaryCallable<ListQuotaInfosRequest, ListQuotaInfosPagedResponse>
      listQuotaInfosPagedCallable;
  private final UnaryCallable<GetQuotaInfoRequest, QuotaInfo> getQuotaInfoCallable;
  private final UnaryCallable<ListQuotaPreferencesRequest, ListQuotaPreferencesResponse>
      listQuotaPreferencesCallable;
  private final UnaryCallable<ListQuotaPreferencesRequest, ListQuotaPreferencesPagedResponse>
      listQuotaPreferencesPagedCallable;
  private final UnaryCallable<GetQuotaPreferenceRequest, QuotaPreference>
      getQuotaPreferenceCallable;
  private final UnaryCallable<CreateQuotaPreferenceRequest, QuotaPreference>
      createQuotaPreferenceCallable;
  private final UnaryCallable<UpdateQuotaPreferenceRequest, QuotaPreference>
      updateQuotaPreferenceCallable;

  private final BackgroundResource backgroundResources;
  private final GrpcOperationsStub operationsStub;
  private final GrpcStubCallableFactory callableFactory;

  public static final GrpcCloudQuotasStub create(CloudQuotasStubSettings settings)
      throws IOException {
    return new GrpcCloudQuotasStub(settings, ClientContext.create(settings));
  }

  public static final GrpcCloudQuotasStub create(ClientContext clientContext) throws IOException {
    return new GrpcCloudQuotasStub(CloudQuotasStubSettings.newBuilder().build(), clientContext);
  }

  public static final GrpcCloudQuotasStub create(
      ClientContext clientContext, GrpcStubCallableFactory callableFactory) throws IOException {
    return new GrpcCloudQuotasStub(
        CloudQuotasStubSettings.newBuilder().build(), clientContext, callableFactory);
  }

  /**
   * Constructs an instance of GrpcCloudQuotasStub, using the given settings. This is protected so
   * that it is easy to make a subclass, but otherwise, the static factory methods should be
   * preferred.
   */
  protected GrpcCloudQuotasStub(CloudQuotasStubSettings settings, ClientContext clientContext)
      throws IOException {
    this(settings, clientContext, new GrpcCloudQuotasCallableFactory());
  }

  /**
   * Constructs an instance of GrpcCloudQuotasStub, using the given settings. This is protected so
   * that it is easy to make a subclass, but otherwise, the static factory methods should be
   * preferred.
   */
  protected GrpcCloudQuotasStub(
      CloudQuotasStubSettings settings,
      ClientContext clientContext,
      GrpcStubCallableFactory callableFactory)
      throws IOException {
    this.callableFactory = callableFactory;
    this.operationsStub = GrpcOperationsStub.create(clientContext, callableFactory);

    GrpcCallSettings<ListQuotaInfosRequest, ListQuotaInfosResponse>
        listQuotaInfosTransportSettings =
            GrpcCallSettings.<ListQuotaInfosRequest, ListQuotaInfosResponse>newBuilder()
                .setMethodDescriptor(listQuotaInfosMethodDescriptor)
                .setParamsExtractor(
                    request -> {
                      RequestParamsBuilder builder = RequestParamsBuilder.create();
                      builder.add("parent", String.valueOf(request.getParent()));
                      return builder.build();
                    })
                .build();
    GrpcCallSettings<GetQuotaInfoRequest, QuotaInfo> getQuotaInfoTransportSettings =
        GrpcCallSettings.<GetQuotaInfoRequest, QuotaInfo>newBuilder()
            .setMethodDescriptor(getQuotaInfoMethodDescriptor)
            .setParamsExtractor(
                request -> {
                  RequestParamsBuilder builder = RequestParamsBuilder.create();
                  builder.add("name", String.valueOf(request.getName()));
                  return builder.build();
                })
            .build();
    GrpcCallSettings<ListQuotaPreferencesRequest, ListQuotaPreferencesResponse>
        listQuotaPreferencesTransportSettings =
            GrpcCallSettings.<ListQuotaPreferencesRequest, ListQuotaPreferencesResponse>newBuilder()
                .setMethodDescriptor(listQuotaPreferencesMethodDescriptor)
                .setParamsExtractor(
                    request -> {
                      RequestParamsBuilder builder = RequestParamsBuilder.create();
                      builder.add("parent", String.valueOf(request.getParent()));
                      return builder.build();
                    })
                .build();
    GrpcCallSettings<GetQuotaPreferenceRequest, QuotaPreference>
        getQuotaPreferenceTransportSettings =
            GrpcCallSettings.<GetQuotaPreferenceRequest, QuotaPreference>newBuilder()
                .setMethodDescriptor(getQuotaPreferenceMethodDescriptor)
                .setParamsExtractor(
                    request -> {
                      RequestParamsBuilder builder = RequestParamsBuilder.create();
                      builder.add("name", String.valueOf(request.getName()));
                      return builder.build();
                    })
                .build();
    GrpcCallSettings<CreateQuotaPreferenceRequest, QuotaPreference>
        createQuotaPreferenceTransportSettings =
            GrpcCallSettings.<CreateQuotaPreferenceRequest, QuotaPreference>newBuilder()
                .setMethodDescriptor(createQuotaPreferenceMethodDescriptor)
                .setParamsExtractor(
                    request -> {
                      RequestParamsBuilder builder = RequestParamsBuilder.create();
                      builder.add("parent", String.valueOf(request.getParent()));
                      return builder.build();
                    })
                .build();
    GrpcCallSettings<UpdateQuotaPreferenceRequest, QuotaPreference>
        updateQuotaPreferenceTransportSettings =
            GrpcCallSettings.<UpdateQuotaPreferenceRequest, QuotaPreference>newBuilder()
                .setMethodDescriptor(updateQuotaPreferenceMethodDescriptor)
                .setParamsExtractor(
                    request -> {
                      RequestParamsBuilder builder = RequestParamsBuilder.create();
                      builder.add(
                          "quota_preference.name",
                          String.valueOf(request.getQuotaPreference().getName()));
                      return builder.build();
                    })
                .build();

    this.listQuotaInfosCallable =
        callableFactory.createUnaryCallable(
            listQuotaInfosTransportSettings, settings.listQuotaInfosSettings(), clientContext);
    this.listQuotaInfosPagedCallable =
        callableFactory.createPagedCallable(
            listQuotaInfosTransportSettings, settings.listQuotaInfosSettings(), clientContext);
    this.getQuotaInfoCallable =
        callableFactory.createUnaryCallable(
            getQuotaInfoTransportSettings, settings.getQuotaInfoSettings(), clientContext);
    this.listQuotaPreferencesCallable =
        callableFactory.createUnaryCallable(
            listQuotaPreferencesTransportSettings,
            settings.listQuotaPreferencesSettings(),
            clientContext);
    this.listQuotaPreferencesPagedCallable =
        callableFactory.createPagedCallable(
            listQuotaPreferencesTransportSettings,
            settings.listQuotaPreferencesSettings(),
            clientContext);
    this.getQuotaPreferenceCallable =
        callableFactory.createUnaryCallable(
            getQuotaPreferenceTransportSettings,
            settings.getQuotaPreferenceSettings(),
            clientContext);
    this.createQuotaPreferenceCallable =
        callableFactory.createUnaryCallable(
            createQuotaPreferenceTransportSettings,
            settings.createQuotaPreferenceSettings(),
            clientContext);
    this.updateQuotaPreferenceCallable =
        callableFactory.createUnaryCallable(
            updateQuotaPreferenceTransportSettings,
            settings.updateQuotaPreferenceSettings(),
            clientContext);

    this.backgroundResources =
        new BackgroundResourceAggregation(clientContext.getBackgroundResources());
  }

  public GrpcOperationsStub getOperationsStub() {
    return operationsStub;
  }

  @Override
  public UnaryCallable<ListQuotaInfosRequest, ListQuotaInfosResponse> listQuotaInfosCallable() {
    return listQuotaInfosCallable;
  }

  @Override
  public UnaryCallable<ListQuotaInfosRequest, ListQuotaInfosPagedResponse>
      listQuotaInfosPagedCallable() {
    return listQuotaInfosPagedCallable;
  }

  @Override
  public UnaryCallable<GetQuotaInfoRequest, QuotaInfo> getQuotaInfoCallable() {
    return getQuotaInfoCallable;
  }

  @Override
  public UnaryCallable<ListQuotaPreferencesRequest, ListQuotaPreferencesResponse>
      listQuotaPreferencesCallable() {
    return listQuotaPreferencesCallable;
  }

  @Override
  public UnaryCallable<ListQuotaPreferencesRequest, ListQuotaPreferencesPagedResponse>
      listQuotaPreferencesPagedCallable() {
    return listQuotaPreferencesPagedCallable;
  }

  @Override
  public UnaryCallable<GetQuotaPreferenceRequest, QuotaPreference> getQuotaPreferenceCallable() {
    return getQuotaPreferenceCallable;
  }

  @Override
  public UnaryCallable<CreateQuotaPreferenceRequest, QuotaPreference>
      createQuotaPreferenceCallable() {
    return createQuotaPreferenceCallable;
  }

  @Override
  public UnaryCallable<UpdateQuotaPreferenceRequest, QuotaPreference>
      updateQuotaPreferenceCallable() {
    return updateQuotaPreferenceCallable;
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
