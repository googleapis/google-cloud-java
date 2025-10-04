/*
 * Copyright 2025 Google LLC
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

package com.google.ads.marketingplatform.admin.v1alpha.stub;

import static com.google.ads.marketingplatform.admin.v1alpha.MarketingplatformAdminServiceClient.ListAnalyticsAccountLinksPagedResponse;

import com.google.ads.marketingplatform.admin.v1alpha.AnalyticsAccountLink;
import com.google.ads.marketingplatform.admin.v1alpha.CreateAnalyticsAccountLinkRequest;
import com.google.ads.marketingplatform.admin.v1alpha.DeleteAnalyticsAccountLinkRequest;
import com.google.ads.marketingplatform.admin.v1alpha.GetOrganizationRequest;
import com.google.ads.marketingplatform.admin.v1alpha.ListAnalyticsAccountLinksRequest;
import com.google.ads.marketingplatform.admin.v1alpha.ListAnalyticsAccountLinksResponse;
import com.google.ads.marketingplatform.admin.v1alpha.Organization;
import com.google.ads.marketingplatform.admin.v1alpha.SetPropertyServiceLevelRequest;
import com.google.ads.marketingplatform.admin.v1alpha.SetPropertyServiceLevelResponse;
import com.google.api.core.BetaApi;
import com.google.api.gax.core.BackgroundResource;
import com.google.api.gax.core.BackgroundResourceAggregation;
import com.google.api.gax.grpc.GrpcCallSettings;
import com.google.api.gax.grpc.GrpcStubCallableFactory;
import com.google.api.gax.rpc.ClientContext;
import com.google.api.gax.rpc.RequestParamsBuilder;
import com.google.api.gax.rpc.UnaryCallable;
import com.google.longrunning.stub.GrpcOperationsStub;
import com.google.protobuf.Empty;
import io.grpc.MethodDescriptor;
import io.grpc.protobuf.ProtoUtils;
import java.io.IOException;
import java.util.concurrent.TimeUnit;
import javax.annotation.Generated;

// AUTO-GENERATED DOCUMENTATION AND CLASS.
/**
 * gRPC stub implementation for the MarketingplatformAdminService service API.
 *
 * <p>This class is for advanced usage and reflects the underlying API directly.
 */
@BetaApi
@Generated("by gapic-generator-java")
public class GrpcMarketingplatformAdminServiceStub extends MarketingplatformAdminServiceStub {
  private static final MethodDescriptor<GetOrganizationRequest, Organization>
      getOrganizationMethodDescriptor =
          MethodDescriptor.<GetOrganizationRequest, Organization>newBuilder()
              .setType(MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(
                  "google.marketingplatform.admin.v1alpha.MarketingplatformAdminService/GetOrganization")
              .setRequestMarshaller(
                  ProtoUtils.marshaller(GetOrganizationRequest.getDefaultInstance()))
              .setResponseMarshaller(ProtoUtils.marshaller(Organization.getDefaultInstance()))
              .setSampledToLocalTracing(true)
              .build();

  private static final MethodDescriptor<
          ListAnalyticsAccountLinksRequest, ListAnalyticsAccountLinksResponse>
      listAnalyticsAccountLinksMethodDescriptor =
          MethodDescriptor
              .<ListAnalyticsAccountLinksRequest, ListAnalyticsAccountLinksResponse>newBuilder()
              .setType(MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(
                  "google.marketingplatform.admin.v1alpha.MarketingplatformAdminService/ListAnalyticsAccountLinks")
              .setRequestMarshaller(
                  ProtoUtils.marshaller(ListAnalyticsAccountLinksRequest.getDefaultInstance()))
              .setResponseMarshaller(
                  ProtoUtils.marshaller(ListAnalyticsAccountLinksResponse.getDefaultInstance()))
              .setSampledToLocalTracing(true)
              .build();

  private static final MethodDescriptor<CreateAnalyticsAccountLinkRequest, AnalyticsAccountLink>
      createAnalyticsAccountLinkMethodDescriptor =
          MethodDescriptor.<CreateAnalyticsAccountLinkRequest, AnalyticsAccountLink>newBuilder()
              .setType(MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(
                  "google.marketingplatform.admin.v1alpha.MarketingplatformAdminService/CreateAnalyticsAccountLink")
              .setRequestMarshaller(
                  ProtoUtils.marshaller(CreateAnalyticsAccountLinkRequest.getDefaultInstance()))
              .setResponseMarshaller(
                  ProtoUtils.marshaller(AnalyticsAccountLink.getDefaultInstance()))
              .setSampledToLocalTracing(true)
              .build();

  private static final MethodDescriptor<DeleteAnalyticsAccountLinkRequest, Empty>
      deleteAnalyticsAccountLinkMethodDescriptor =
          MethodDescriptor.<DeleteAnalyticsAccountLinkRequest, Empty>newBuilder()
              .setType(MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(
                  "google.marketingplatform.admin.v1alpha.MarketingplatformAdminService/DeleteAnalyticsAccountLink")
              .setRequestMarshaller(
                  ProtoUtils.marshaller(DeleteAnalyticsAccountLinkRequest.getDefaultInstance()))
              .setResponseMarshaller(ProtoUtils.marshaller(Empty.getDefaultInstance()))
              .setSampledToLocalTracing(true)
              .build();

  private static final MethodDescriptor<
          SetPropertyServiceLevelRequest, SetPropertyServiceLevelResponse>
      setPropertyServiceLevelMethodDescriptor =
          MethodDescriptor
              .<SetPropertyServiceLevelRequest, SetPropertyServiceLevelResponse>newBuilder()
              .setType(MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(
                  "google.marketingplatform.admin.v1alpha.MarketingplatformAdminService/SetPropertyServiceLevel")
              .setRequestMarshaller(
                  ProtoUtils.marshaller(SetPropertyServiceLevelRequest.getDefaultInstance()))
              .setResponseMarshaller(
                  ProtoUtils.marshaller(SetPropertyServiceLevelResponse.getDefaultInstance()))
              .setSampledToLocalTracing(true)
              .build();

  private final UnaryCallable<GetOrganizationRequest, Organization> getOrganizationCallable;
  private final UnaryCallable<ListAnalyticsAccountLinksRequest, ListAnalyticsAccountLinksResponse>
      listAnalyticsAccountLinksCallable;
  private final UnaryCallable<
          ListAnalyticsAccountLinksRequest, ListAnalyticsAccountLinksPagedResponse>
      listAnalyticsAccountLinksPagedCallable;
  private final UnaryCallable<CreateAnalyticsAccountLinkRequest, AnalyticsAccountLink>
      createAnalyticsAccountLinkCallable;
  private final UnaryCallable<DeleteAnalyticsAccountLinkRequest, Empty>
      deleteAnalyticsAccountLinkCallable;
  private final UnaryCallable<SetPropertyServiceLevelRequest, SetPropertyServiceLevelResponse>
      setPropertyServiceLevelCallable;

  private final BackgroundResource backgroundResources;
  private final GrpcOperationsStub operationsStub;
  private final GrpcStubCallableFactory callableFactory;

  public static final GrpcMarketingplatformAdminServiceStub create(
      MarketingplatformAdminServiceStubSettings settings) throws IOException {
    return new GrpcMarketingplatformAdminServiceStub(settings, ClientContext.create(settings));
  }

  public static final GrpcMarketingplatformAdminServiceStub create(ClientContext clientContext)
      throws IOException {
    return new GrpcMarketingplatformAdminServiceStub(
        MarketingplatformAdminServiceStubSettings.newBuilder().build(), clientContext);
  }

  public static final GrpcMarketingplatformAdminServiceStub create(
      ClientContext clientContext, GrpcStubCallableFactory callableFactory) throws IOException {
    return new GrpcMarketingplatformAdminServiceStub(
        MarketingplatformAdminServiceStubSettings.newBuilder().build(),
        clientContext,
        callableFactory);
  }

  /**
   * Constructs an instance of GrpcMarketingplatformAdminServiceStub, using the given settings. This
   * is protected so that it is easy to make a subclass, but otherwise, the static factory methods
   * should be preferred.
   */
  protected GrpcMarketingplatformAdminServiceStub(
      MarketingplatformAdminServiceStubSettings settings, ClientContext clientContext)
      throws IOException {
    this(settings, clientContext, new GrpcMarketingplatformAdminServiceCallableFactory());
  }

  /**
   * Constructs an instance of GrpcMarketingplatformAdminServiceStub, using the given settings. This
   * is protected so that it is easy to make a subclass, but otherwise, the static factory methods
   * should be preferred.
   */
  protected GrpcMarketingplatformAdminServiceStub(
      MarketingplatformAdminServiceStubSettings settings,
      ClientContext clientContext,
      GrpcStubCallableFactory callableFactory)
      throws IOException {
    this.callableFactory = callableFactory;
    this.operationsStub = GrpcOperationsStub.create(clientContext, callableFactory);

    GrpcCallSettings<GetOrganizationRequest, Organization> getOrganizationTransportSettings =
        GrpcCallSettings.<GetOrganizationRequest, Organization>newBuilder()
            .setMethodDescriptor(getOrganizationMethodDescriptor)
            .setParamsExtractor(
                request -> {
                  RequestParamsBuilder builder = RequestParamsBuilder.create();
                  builder.add("name", String.valueOf(request.getName()));
                  return builder.build();
                })
            .build();
    GrpcCallSettings<ListAnalyticsAccountLinksRequest, ListAnalyticsAccountLinksResponse>
        listAnalyticsAccountLinksTransportSettings =
            GrpcCallSettings
                .<ListAnalyticsAccountLinksRequest, ListAnalyticsAccountLinksResponse>newBuilder()
                .setMethodDescriptor(listAnalyticsAccountLinksMethodDescriptor)
                .setParamsExtractor(
                    request -> {
                      RequestParamsBuilder builder = RequestParamsBuilder.create();
                      builder.add("parent", String.valueOf(request.getParent()));
                      return builder.build();
                    })
                .build();
    GrpcCallSettings<CreateAnalyticsAccountLinkRequest, AnalyticsAccountLink>
        createAnalyticsAccountLinkTransportSettings =
            GrpcCallSettings.<CreateAnalyticsAccountLinkRequest, AnalyticsAccountLink>newBuilder()
                .setMethodDescriptor(createAnalyticsAccountLinkMethodDescriptor)
                .setParamsExtractor(
                    request -> {
                      RequestParamsBuilder builder = RequestParamsBuilder.create();
                      builder.add("parent", String.valueOf(request.getParent()));
                      return builder.build();
                    })
                .build();
    GrpcCallSettings<DeleteAnalyticsAccountLinkRequest, Empty>
        deleteAnalyticsAccountLinkTransportSettings =
            GrpcCallSettings.<DeleteAnalyticsAccountLinkRequest, Empty>newBuilder()
                .setMethodDescriptor(deleteAnalyticsAccountLinkMethodDescriptor)
                .setParamsExtractor(
                    request -> {
                      RequestParamsBuilder builder = RequestParamsBuilder.create();
                      builder.add("name", String.valueOf(request.getName()));
                      return builder.build();
                    })
                .build();
    GrpcCallSettings<SetPropertyServiceLevelRequest, SetPropertyServiceLevelResponse>
        setPropertyServiceLevelTransportSettings =
            GrpcCallSettings
                .<SetPropertyServiceLevelRequest, SetPropertyServiceLevelResponse>newBuilder()
                .setMethodDescriptor(setPropertyServiceLevelMethodDescriptor)
                .setParamsExtractor(
                    request -> {
                      RequestParamsBuilder builder = RequestParamsBuilder.create();
                      builder.add(
                          "analytics_account_link",
                          String.valueOf(request.getAnalyticsAccountLink()));
                      return builder.build();
                    })
                .build();

    this.getOrganizationCallable =
        callableFactory.createUnaryCallable(
            getOrganizationTransportSettings, settings.getOrganizationSettings(), clientContext);
    this.listAnalyticsAccountLinksCallable =
        callableFactory.createUnaryCallable(
            listAnalyticsAccountLinksTransportSettings,
            settings.listAnalyticsAccountLinksSettings(),
            clientContext);
    this.listAnalyticsAccountLinksPagedCallable =
        callableFactory.createPagedCallable(
            listAnalyticsAccountLinksTransportSettings,
            settings.listAnalyticsAccountLinksSettings(),
            clientContext);
    this.createAnalyticsAccountLinkCallable =
        callableFactory.createUnaryCallable(
            createAnalyticsAccountLinkTransportSettings,
            settings.createAnalyticsAccountLinkSettings(),
            clientContext);
    this.deleteAnalyticsAccountLinkCallable =
        callableFactory.createUnaryCallable(
            deleteAnalyticsAccountLinkTransportSettings,
            settings.deleteAnalyticsAccountLinkSettings(),
            clientContext);
    this.setPropertyServiceLevelCallable =
        callableFactory.createUnaryCallable(
            setPropertyServiceLevelTransportSettings,
            settings.setPropertyServiceLevelSettings(),
            clientContext);

    this.backgroundResources =
        new BackgroundResourceAggregation(clientContext.getBackgroundResources());
  }

  public GrpcOperationsStub getOperationsStub() {
    return operationsStub;
  }

  @Override
  public UnaryCallable<GetOrganizationRequest, Organization> getOrganizationCallable() {
    return getOrganizationCallable;
  }

  @Override
  public UnaryCallable<ListAnalyticsAccountLinksRequest, ListAnalyticsAccountLinksResponse>
      listAnalyticsAccountLinksCallable() {
    return listAnalyticsAccountLinksCallable;
  }

  @Override
  public UnaryCallable<ListAnalyticsAccountLinksRequest, ListAnalyticsAccountLinksPagedResponse>
      listAnalyticsAccountLinksPagedCallable() {
    return listAnalyticsAccountLinksPagedCallable;
  }

  @Override
  public UnaryCallable<CreateAnalyticsAccountLinkRequest, AnalyticsAccountLink>
      createAnalyticsAccountLinkCallable() {
    return createAnalyticsAccountLinkCallable;
  }

  @Override
  public UnaryCallable<DeleteAnalyticsAccountLinkRequest, Empty>
      deleteAnalyticsAccountLinkCallable() {
    return deleteAnalyticsAccountLinkCallable;
  }

  @Override
  public UnaryCallable<SetPropertyServiceLevelRequest, SetPropertyServiceLevelResponse>
      setPropertyServiceLevelCallable() {
    return setPropertyServiceLevelCallable;
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
