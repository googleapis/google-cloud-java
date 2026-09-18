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

package com.google.cloud.chronicle.v1.stub;

import static com.google.cloud.chronicle.v1.FeedsServiceClient.ListFeedPacksPagedResponse;
import static com.google.cloud.chronicle.v1.FeedsServiceClient.ListFeedSourceTypeSchemasPagedResponse;
import static com.google.cloud.chronicle.v1.FeedsServiceClient.ListFeedsPagedResponse;
import static com.google.cloud.chronicle.v1.FeedsServiceClient.ListLogTypeSchemasPagedResponse;

import com.google.api.HttpBody;
import com.google.api.gax.core.BackgroundResource;
import com.google.api.gax.core.BackgroundResourceAggregation;
import com.google.api.gax.grpc.GrpcCallSettings;
import com.google.api.gax.grpc.GrpcStubCallableFactory;
import com.google.api.gax.rpc.ClientContext;
import com.google.api.gax.rpc.RequestParamsBuilder;
import com.google.api.gax.rpc.UnaryCallable;
import com.google.cloud.chronicle.v1.CreateFeedRequest;
import com.google.cloud.chronicle.v1.DeleteFeedRequest;
import com.google.cloud.chronicle.v1.DisableFeedRequest;
import com.google.cloud.chronicle.v1.EnableFeedRequest;
import com.google.cloud.chronicle.v1.Feed;
import com.google.cloud.chronicle.v1.FeedPack;
import com.google.cloud.chronicle.v1.FeedServiceAccount;
import com.google.cloud.chronicle.v1.FetchServiceAccountForCustomerRequest;
import com.google.cloud.chronicle.v1.GenerateSecretRequest;
import com.google.cloud.chronicle.v1.GenerateSecretResponse;
import com.google.cloud.chronicle.v1.GetFeedPackRequest;
import com.google.cloud.chronicle.v1.GetFeedRequest;
import com.google.cloud.chronicle.v1.ImportPushLogsRequest;
import com.google.cloud.chronicle.v1.ListFeedPacksRequest;
import com.google.cloud.chronicle.v1.ListFeedPacksResponse;
import com.google.cloud.chronicle.v1.ListFeedSourceTypeSchemasRequest;
import com.google.cloud.chronicle.v1.ListFeedSourceTypeSchemasResponse;
import com.google.cloud.chronicle.v1.ListFeedsRequest;
import com.google.cloud.chronicle.v1.ListFeedsResponse;
import com.google.cloud.chronicle.v1.ListLogTypeSchemasRequest;
import com.google.cloud.chronicle.v1.ListLogTypeSchemasResponse;
import com.google.cloud.chronicle.v1.UpdateFeedRequest;
import com.google.longrunning.stub.GrpcOperationsStub;
import com.google.protobuf.Empty;
import io.grpc.MethodDescriptor;
import io.grpc.protobuf.ProtoUtils;
import java.io.IOException;
import java.util.concurrent.TimeUnit;
import javax.annotation.Generated;
import org.jspecify.annotations.NullMarked;

// AUTO-GENERATED DOCUMENTATION AND CLASS.
/**
 * gRPC stub implementation for the FeedsService service API.
 *
 * <p>This class is for advanced usage and reflects the underlying API directly.
 */
@NullMarked
@Generated("by gapic-generator-java")
public class GrpcFeedsServiceStub extends FeedsServiceStub {
  private static final MethodDescriptor<FetchServiceAccountForCustomerRequest, FeedServiceAccount>
      fetchServiceAccountForCustomerMethodDescriptor =
          MethodDescriptor.<FetchServiceAccountForCustomerRequest, FeedServiceAccount>newBuilder()
              .setType(MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(
                  "google.cloud.chronicle.v1.FeedsService/FetchServiceAccountForCustomer")
              .setRequestMarshaller(
                  ProtoUtils.marshaller(FetchServiceAccountForCustomerRequest.getDefaultInstance()))
              .setResponseMarshaller(ProtoUtils.marshaller(FeedServiceAccount.getDefaultInstance()))
              .setSampledToLocalTracing(true)
              .build();

  private static final MethodDescriptor<CreateFeedRequest, Feed> createFeedMethodDescriptor =
      MethodDescriptor.<CreateFeedRequest, Feed>newBuilder()
          .setType(MethodDescriptor.MethodType.UNARY)
          .setFullMethodName("google.cloud.chronicle.v1.FeedsService/CreateFeed")
          .setRequestMarshaller(ProtoUtils.marshaller(CreateFeedRequest.getDefaultInstance()))
          .setResponseMarshaller(ProtoUtils.marshaller(Feed.getDefaultInstance()))
          .setSampledToLocalTracing(true)
          .build();

  private static final MethodDescriptor<GetFeedRequest, Feed> getFeedMethodDescriptor =
      MethodDescriptor.<GetFeedRequest, Feed>newBuilder()
          .setType(MethodDescriptor.MethodType.UNARY)
          .setFullMethodName("google.cloud.chronicle.v1.FeedsService/GetFeed")
          .setRequestMarshaller(ProtoUtils.marshaller(GetFeedRequest.getDefaultInstance()))
          .setResponseMarshaller(ProtoUtils.marshaller(Feed.getDefaultInstance()))
          .setSampledToLocalTracing(true)
          .build();

  private static final MethodDescriptor<DeleteFeedRequest, Empty> deleteFeedMethodDescriptor =
      MethodDescriptor.<DeleteFeedRequest, Empty>newBuilder()
          .setType(MethodDescriptor.MethodType.UNARY)
          .setFullMethodName("google.cloud.chronicle.v1.FeedsService/DeleteFeed")
          .setRequestMarshaller(ProtoUtils.marshaller(DeleteFeedRequest.getDefaultInstance()))
          .setResponseMarshaller(ProtoUtils.marshaller(Empty.getDefaultInstance()))
          .setSampledToLocalTracing(true)
          .build();

  private static final MethodDescriptor<EnableFeedRequest, Feed> enableFeedMethodDescriptor =
      MethodDescriptor.<EnableFeedRequest, Feed>newBuilder()
          .setType(MethodDescriptor.MethodType.UNARY)
          .setFullMethodName("google.cloud.chronicle.v1.FeedsService/EnableFeed")
          .setRequestMarshaller(ProtoUtils.marshaller(EnableFeedRequest.getDefaultInstance()))
          .setResponseMarshaller(ProtoUtils.marshaller(Feed.getDefaultInstance()))
          .setSampledToLocalTracing(true)
          .build();

  private static final MethodDescriptor<DisableFeedRequest, Feed> disableFeedMethodDescriptor =
      MethodDescriptor.<DisableFeedRequest, Feed>newBuilder()
          .setType(MethodDescriptor.MethodType.UNARY)
          .setFullMethodName("google.cloud.chronicle.v1.FeedsService/DisableFeed")
          .setRequestMarshaller(ProtoUtils.marshaller(DisableFeedRequest.getDefaultInstance()))
          .setResponseMarshaller(ProtoUtils.marshaller(Feed.getDefaultInstance()))
          .setSampledToLocalTracing(true)
          .build();

  private static final MethodDescriptor<ListFeedsRequest, ListFeedsResponse>
      listFeedsMethodDescriptor =
          MethodDescriptor.<ListFeedsRequest, ListFeedsResponse>newBuilder()
              .setType(MethodDescriptor.MethodType.UNARY)
              .setFullMethodName("google.cloud.chronicle.v1.FeedsService/ListFeeds")
              .setRequestMarshaller(ProtoUtils.marshaller(ListFeedsRequest.getDefaultInstance()))
              .setResponseMarshaller(ProtoUtils.marshaller(ListFeedsResponse.getDefaultInstance()))
              .setSampledToLocalTracing(true)
              .build();

  private static final MethodDescriptor<ListFeedPacksRequest, ListFeedPacksResponse>
      listFeedPacksMethodDescriptor =
          MethodDescriptor.<ListFeedPacksRequest, ListFeedPacksResponse>newBuilder()
              .setType(MethodDescriptor.MethodType.UNARY)
              .setFullMethodName("google.cloud.chronicle.v1.FeedsService/ListFeedPacks")
              .setRequestMarshaller(
                  ProtoUtils.marshaller(ListFeedPacksRequest.getDefaultInstance()))
              .setResponseMarshaller(
                  ProtoUtils.marshaller(ListFeedPacksResponse.getDefaultInstance()))
              .setSampledToLocalTracing(true)
              .build();

  private static final MethodDescriptor<GetFeedPackRequest, FeedPack> getFeedPackMethodDescriptor =
      MethodDescriptor.<GetFeedPackRequest, FeedPack>newBuilder()
          .setType(MethodDescriptor.MethodType.UNARY)
          .setFullMethodName("google.cloud.chronicle.v1.FeedsService/GetFeedPack")
          .setRequestMarshaller(ProtoUtils.marshaller(GetFeedPackRequest.getDefaultInstance()))
          .setResponseMarshaller(ProtoUtils.marshaller(FeedPack.getDefaultInstance()))
          .setSampledToLocalTracing(true)
          .build();

  private static final MethodDescriptor<UpdateFeedRequest, Feed> updateFeedMethodDescriptor =
      MethodDescriptor.<UpdateFeedRequest, Feed>newBuilder()
          .setType(MethodDescriptor.MethodType.UNARY)
          .setFullMethodName("google.cloud.chronicle.v1.FeedsService/UpdateFeed")
          .setRequestMarshaller(ProtoUtils.marshaller(UpdateFeedRequest.getDefaultInstance()))
          .setResponseMarshaller(ProtoUtils.marshaller(Feed.getDefaultInstance()))
          .setSampledToLocalTracing(true)
          .build();

  private static final MethodDescriptor<
          ListFeedSourceTypeSchemasRequest, ListFeedSourceTypeSchemasResponse>
      listFeedSourceTypeSchemasMethodDescriptor =
          MethodDescriptor
              .<ListFeedSourceTypeSchemasRequest, ListFeedSourceTypeSchemasResponse>newBuilder()
              .setType(MethodDescriptor.MethodType.UNARY)
              .setFullMethodName("google.cloud.chronicle.v1.FeedsService/ListFeedSourceTypeSchemas")
              .setRequestMarshaller(
                  ProtoUtils.marshaller(ListFeedSourceTypeSchemasRequest.getDefaultInstance()))
              .setResponseMarshaller(
                  ProtoUtils.marshaller(ListFeedSourceTypeSchemasResponse.getDefaultInstance()))
              .setSampledToLocalTracing(true)
              .build();

  private static final MethodDescriptor<ListLogTypeSchemasRequest, ListLogTypeSchemasResponse>
      listLogTypeSchemasMethodDescriptor =
          MethodDescriptor.<ListLogTypeSchemasRequest, ListLogTypeSchemasResponse>newBuilder()
              .setType(MethodDescriptor.MethodType.UNARY)
              .setFullMethodName("google.cloud.chronicle.v1.FeedsService/ListLogTypeSchemas")
              .setRequestMarshaller(
                  ProtoUtils.marshaller(ListLogTypeSchemasRequest.getDefaultInstance()))
              .setResponseMarshaller(
                  ProtoUtils.marshaller(ListLogTypeSchemasResponse.getDefaultInstance()))
              .setSampledToLocalTracing(true)
              .build();

  private static final MethodDescriptor<ImportPushLogsRequest, HttpBody>
      importPushLogsMethodDescriptor =
          MethodDescriptor.<ImportPushLogsRequest, HttpBody>newBuilder()
              .setType(MethodDescriptor.MethodType.UNARY)
              .setFullMethodName("google.cloud.chronicle.v1.FeedsService/ImportPushLogs")
              .setRequestMarshaller(
                  ProtoUtils.marshaller(ImportPushLogsRequest.getDefaultInstance()))
              .setResponseMarshaller(ProtoUtils.marshaller(HttpBody.getDefaultInstance()))
              .setSampledToLocalTracing(true)
              .build();

  private static final MethodDescriptor<GenerateSecretRequest, GenerateSecretResponse>
      generateSecretMethodDescriptor =
          MethodDescriptor.<GenerateSecretRequest, GenerateSecretResponse>newBuilder()
              .setType(MethodDescriptor.MethodType.UNARY)
              .setFullMethodName("google.cloud.chronicle.v1.FeedsService/GenerateSecret")
              .setRequestMarshaller(
                  ProtoUtils.marshaller(GenerateSecretRequest.getDefaultInstance()))
              .setResponseMarshaller(
                  ProtoUtils.marshaller(GenerateSecretResponse.getDefaultInstance()))
              .setSampledToLocalTracing(true)
              .build();

  private final UnaryCallable<FetchServiceAccountForCustomerRequest, FeedServiceAccount>
      fetchServiceAccountForCustomerCallable;
  private final UnaryCallable<CreateFeedRequest, Feed> createFeedCallable;
  private final UnaryCallable<GetFeedRequest, Feed> getFeedCallable;
  private final UnaryCallable<DeleteFeedRequest, Empty> deleteFeedCallable;
  private final UnaryCallable<EnableFeedRequest, Feed> enableFeedCallable;
  private final UnaryCallable<DisableFeedRequest, Feed> disableFeedCallable;
  private final UnaryCallable<ListFeedsRequest, ListFeedsResponse> listFeedsCallable;
  private final UnaryCallable<ListFeedsRequest, ListFeedsPagedResponse> listFeedsPagedCallable;
  private final UnaryCallable<ListFeedPacksRequest, ListFeedPacksResponse> listFeedPacksCallable;
  private final UnaryCallable<ListFeedPacksRequest, ListFeedPacksPagedResponse>
      listFeedPacksPagedCallable;
  private final UnaryCallable<GetFeedPackRequest, FeedPack> getFeedPackCallable;
  private final UnaryCallable<UpdateFeedRequest, Feed> updateFeedCallable;
  private final UnaryCallable<ListFeedSourceTypeSchemasRequest, ListFeedSourceTypeSchemasResponse>
      listFeedSourceTypeSchemasCallable;
  private final UnaryCallable<
          ListFeedSourceTypeSchemasRequest, ListFeedSourceTypeSchemasPagedResponse>
      listFeedSourceTypeSchemasPagedCallable;
  private final UnaryCallable<ListLogTypeSchemasRequest, ListLogTypeSchemasResponse>
      listLogTypeSchemasCallable;
  private final UnaryCallable<ListLogTypeSchemasRequest, ListLogTypeSchemasPagedResponse>
      listLogTypeSchemasPagedCallable;
  private final UnaryCallable<ImportPushLogsRequest, HttpBody> importPushLogsCallable;
  private final UnaryCallable<GenerateSecretRequest, GenerateSecretResponse> generateSecretCallable;

  private final BackgroundResource backgroundResources;
  private final GrpcOperationsStub operationsStub;
  private final GrpcStubCallableFactory callableFactory;

  public static final GrpcFeedsServiceStub create(FeedsServiceStubSettings settings)
      throws IOException {
    return new GrpcFeedsServiceStub(settings, ClientContext.create(settings));
  }

  public static final GrpcFeedsServiceStub create(ClientContext clientContext) throws IOException {
    return new GrpcFeedsServiceStub(FeedsServiceStubSettings.newBuilder().build(), clientContext);
  }

  public static final GrpcFeedsServiceStub create(
      ClientContext clientContext, GrpcStubCallableFactory callableFactory) throws IOException {
    return new GrpcFeedsServiceStub(
        FeedsServiceStubSettings.newBuilder().build(), clientContext, callableFactory);
  }

  /**
   * Constructs an instance of GrpcFeedsServiceStub, using the given settings. This is protected so
   * that it is easy to make a subclass, but otherwise, the static factory methods should be
   * preferred.
   */
  protected GrpcFeedsServiceStub(FeedsServiceStubSettings settings, ClientContext clientContext)
      throws IOException {
    this(settings, clientContext, new GrpcFeedsServiceCallableFactory());
  }

  /**
   * Constructs an instance of GrpcFeedsServiceStub, using the given settings. This is protected so
   * that it is easy to make a subclass, but otherwise, the static factory methods should be
   * preferred.
   */
  protected GrpcFeedsServiceStub(
      FeedsServiceStubSettings settings,
      ClientContext clientContext,
      GrpcStubCallableFactory callableFactory)
      throws IOException {
    this.callableFactory = callableFactory;
    this.operationsStub = GrpcOperationsStub.create(clientContext, callableFactory);

    GrpcCallSettings<FetchServiceAccountForCustomerRequest, FeedServiceAccount>
        fetchServiceAccountForCustomerTransportSettings =
            GrpcCallSettings.<FetchServiceAccountForCustomerRequest, FeedServiceAccount>newBuilder()
                .setMethodDescriptor(fetchServiceAccountForCustomerMethodDescriptor)
                .setParamsExtractor(
                    request -> {
                      RequestParamsBuilder builder = RequestParamsBuilder.create();
                      builder.add("parent", String.valueOf(request.getParent()));
                      return builder.build();
                    })
                .setResourceNameExtractor(request -> request.getParent())
                .build();
    GrpcCallSettings<CreateFeedRequest, Feed> createFeedTransportSettings =
        GrpcCallSettings.<CreateFeedRequest, Feed>newBuilder()
            .setMethodDescriptor(createFeedMethodDescriptor)
            .setParamsExtractor(
                request -> {
                  RequestParamsBuilder builder = RequestParamsBuilder.create();
                  builder.add("parent", String.valueOf(request.getParent()));
                  return builder.build();
                })
            .setResourceNameExtractor(request -> request.getParent())
            .build();
    GrpcCallSettings<GetFeedRequest, Feed> getFeedTransportSettings =
        GrpcCallSettings.<GetFeedRequest, Feed>newBuilder()
            .setMethodDescriptor(getFeedMethodDescriptor)
            .setParamsExtractor(
                request -> {
                  RequestParamsBuilder builder = RequestParamsBuilder.create();
                  builder.add("name", String.valueOf(request.getName()));
                  return builder.build();
                })
            .setResourceNameExtractor(request -> request.getName())
            .build();
    GrpcCallSettings<DeleteFeedRequest, Empty> deleteFeedTransportSettings =
        GrpcCallSettings.<DeleteFeedRequest, Empty>newBuilder()
            .setMethodDescriptor(deleteFeedMethodDescriptor)
            .setParamsExtractor(
                request -> {
                  RequestParamsBuilder builder = RequestParamsBuilder.create();
                  builder.add("name", String.valueOf(request.getName()));
                  return builder.build();
                })
            .setResourceNameExtractor(request -> request.getName())
            .build();
    GrpcCallSettings<EnableFeedRequest, Feed> enableFeedTransportSettings =
        GrpcCallSettings.<EnableFeedRequest, Feed>newBuilder()
            .setMethodDescriptor(enableFeedMethodDescriptor)
            .setParamsExtractor(
                request -> {
                  RequestParamsBuilder builder = RequestParamsBuilder.create();
                  builder.add("name", String.valueOf(request.getName()));
                  return builder.build();
                })
            .setResourceNameExtractor(request -> request.getName())
            .build();
    GrpcCallSettings<DisableFeedRequest, Feed> disableFeedTransportSettings =
        GrpcCallSettings.<DisableFeedRequest, Feed>newBuilder()
            .setMethodDescriptor(disableFeedMethodDescriptor)
            .setParamsExtractor(
                request -> {
                  RequestParamsBuilder builder = RequestParamsBuilder.create();
                  builder.add("name", String.valueOf(request.getName()));
                  return builder.build();
                })
            .setResourceNameExtractor(request -> request.getName())
            .build();
    GrpcCallSettings<ListFeedsRequest, ListFeedsResponse> listFeedsTransportSettings =
        GrpcCallSettings.<ListFeedsRequest, ListFeedsResponse>newBuilder()
            .setMethodDescriptor(listFeedsMethodDescriptor)
            .setParamsExtractor(
                request -> {
                  RequestParamsBuilder builder = RequestParamsBuilder.create();
                  builder.add("parent", String.valueOf(request.getParent()));
                  return builder.build();
                })
            .setResourceNameExtractor(request -> request.getParent())
            .build();
    GrpcCallSettings<ListFeedPacksRequest, ListFeedPacksResponse> listFeedPacksTransportSettings =
        GrpcCallSettings.<ListFeedPacksRequest, ListFeedPacksResponse>newBuilder()
            .setMethodDescriptor(listFeedPacksMethodDescriptor)
            .setParamsExtractor(
                request -> {
                  RequestParamsBuilder builder = RequestParamsBuilder.create();
                  builder.add("parent", String.valueOf(request.getParent()));
                  return builder.build();
                })
            .setResourceNameExtractor(request -> request.getParent())
            .build();
    GrpcCallSettings<GetFeedPackRequest, FeedPack> getFeedPackTransportSettings =
        GrpcCallSettings.<GetFeedPackRequest, FeedPack>newBuilder()
            .setMethodDescriptor(getFeedPackMethodDescriptor)
            .setParamsExtractor(
                request -> {
                  RequestParamsBuilder builder = RequestParamsBuilder.create();
                  builder.add("name", String.valueOf(request.getName()));
                  return builder.build();
                })
            .setResourceNameExtractor(request -> request.getName())
            .build();
    GrpcCallSettings<UpdateFeedRequest, Feed> updateFeedTransportSettings =
        GrpcCallSettings.<UpdateFeedRequest, Feed>newBuilder()
            .setMethodDescriptor(updateFeedMethodDescriptor)
            .setParamsExtractor(
                request -> {
                  RequestParamsBuilder builder = RequestParamsBuilder.create();
                  builder.add("feed.name", String.valueOf(request.getFeed().getName()));
                  return builder.build();
                })
            .build();
    GrpcCallSettings<ListFeedSourceTypeSchemasRequest, ListFeedSourceTypeSchemasResponse>
        listFeedSourceTypeSchemasTransportSettings =
            GrpcCallSettings
                .<ListFeedSourceTypeSchemasRequest, ListFeedSourceTypeSchemasResponse>newBuilder()
                .setMethodDescriptor(listFeedSourceTypeSchemasMethodDescriptor)
                .setParamsExtractor(
                    request -> {
                      RequestParamsBuilder builder = RequestParamsBuilder.create();
                      builder.add("parent", String.valueOf(request.getParent()));
                      return builder.build();
                    })
                .setResourceNameExtractor(request -> request.getParent())
                .build();
    GrpcCallSettings<ListLogTypeSchemasRequest, ListLogTypeSchemasResponse>
        listLogTypeSchemasTransportSettings =
            GrpcCallSettings.<ListLogTypeSchemasRequest, ListLogTypeSchemasResponse>newBuilder()
                .setMethodDescriptor(listLogTypeSchemasMethodDescriptor)
                .setParamsExtractor(
                    request -> {
                      RequestParamsBuilder builder = RequestParamsBuilder.create();
                      builder.add("parent", String.valueOf(request.getParent()));
                      return builder.build();
                    })
                .setResourceNameExtractor(request -> request.getParent())
                .build();
    GrpcCallSettings<ImportPushLogsRequest, HttpBody> importPushLogsTransportSettings =
        GrpcCallSettings.<ImportPushLogsRequest, HttpBody>newBuilder()
            .setMethodDescriptor(importPushLogsMethodDescriptor)
            .setParamsExtractor(
                request -> {
                  RequestParamsBuilder builder = RequestParamsBuilder.create();
                  builder.add("parent", String.valueOf(request.getParent()));
                  return builder.build();
                })
            .setResourceNameExtractor(request -> request.getParent())
            .build();
    GrpcCallSettings<GenerateSecretRequest, GenerateSecretResponse>
        generateSecretTransportSettings =
            GrpcCallSettings.<GenerateSecretRequest, GenerateSecretResponse>newBuilder()
                .setMethodDescriptor(generateSecretMethodDescriptor)
                .setParamsExtractor(
                    request -> {
                      RequestParamsBuilder builder = RequestParamsBuilder.create();
                      builder.add("name", String.valueOf(request.getName()));
                      return builder.build();
                    })
                .setResourceNameExtractor(request -> request.getName())
                .build();

    this.fetchServiceAccountForCustomerCallable =
        callableFactory.createUnaryCallable(
            fetchServiceAccountForCustomerTransportSettings,
            settings.fetchServiceAccountForCustomerSettings(),
            clientContext);
    this.createFeedCallable =
        callableFactory.createUnaryCallable(
            createFeedTransportSettings, settings.createFeedSettings(), clientContext);
    this.getFeedCallable =
        callableFactory.createUnaryCallable(
            getFeedTransportSettings, settings.getFeedSettings(), clientContext);
    this.deleteFeedCallable =
        callableFactory.createUnaryCallable(
            deleteFeedTransportSettings, settings.deleteFeedSettings(), clientContext);
    this.enableFeedCallable =
        callableFactory.createUnaryCallable(
            enableFeedTransportSettings, settings.enableFeedSettings(), clientContext);
    this.disableFeedCallable =
        callableFactory.createUnaryCallable(
            disableFeedTransportSettings, settings.disableFeedSettings(), clientContext);
    this.listFeedsCallable =
        callableFactory.createUnaryCallable(
            listFeedsTransportSettings, settings.listFeedsSettings(), clientContext);
    this.listFeedsPagedCallable =
        callableFactory.createPagedCallable(
            listFeedsTransportSettings, settings.listFeedsSettings(), clientContext);
    this.listFeedPacksCallable =
        callableFactory.createUnaryCallable(
            listFeedPacksTransportSettings, settings.listFeedPacksSettings(), clientContext);
    this.listFeedPacksPagedCallable =
        callableFactory.createPagedCallable(
            listFeedPacksTransportSettings, settings.listFeedPacksSettings(), clientContext);
    this.getFeedPackCallable =
        callableFactory.createUnaryCallable(
            getFeedPackTransportSettings, settings.getFeedPackSettings(), clientContext);
    this.updateFeedCallable =
        callableFactory.createUnaryCallable(
            updateFeedTransportSettings, settings.updateFeedSettings(), clientContext);
    this.listFeedSourceTypeSchemasCallable =
        callableFactory.createUnaryCallable(
            listFeedSourceTypeSchemasTransportSettings,
            settings.listFeedSourceTypeSchemasSettings(),
            clientContext);
    this.listFeedSourceTypeSchemasPagedCallable =
        callableFactory.createPagedCallable(
            listFeedSourceTypeSchemasTransportSettings,
            settings.listFeedSourceTypeSchemasSettings(),
            clientContext);
    this.listLogTypeSchemasCallable =
        callableFactory.createUnaryCallable(
            listLogTypeSchemasTransportSettings,
            settings.listLogTypeSchemasSettings(),
            clientContext);
    this.listLogTypeSchemasPagedCallable =
        callableFactory.createPagedCallable(
            listLogTypeSchemasTransportSettings,
            settings.listLogTypeSchemasSettings(),
            clientContext);
    this.importPushLogsCallable =
        callableFactory.createUnaryCallable(
            importPushLogsTransportSettings, settings.importPushLogsSettings(), clientContext);
    this.generateSecretCallable =
        callableFactory.createUnaryCallable(
            generateSecretTransportSettings, settings.generateSecretSettings(), clientContext);

    this.backgroundResources =
        new BackgroundResourceAggregation(clientContext.getBackgroundResources());
  }

  public GrpcOperationsStub getOperationsStub() {
    return operationsStub;
  }

  @Override
  public UnaryCallable<FetchServiceAccountForCustomerRequest, FeedServiceAccount>
      fetchServiceAccountForCustomerCallable() {
    return fetchServiceAccountForCustomerCallable;
  }

  @Override
  public UnaryCallable<CreateFeedRequest, Feed> createFeedCallable() {
    return createFeedCallable;
  }

  @Override
  public UnaryCallable<GetFeedRequest, Feed> getFeedCallable() {
    return getFeedCallable;
  }

  @Override
  public UnaryCallable<DeleteFeedRequest, Empty> deleteFeedCallable() {
    return deleteFeedCallable;
  }

  @Override
  public UnaryCallable<EnableFeedRequest, Feed> enableFeedCallable() {
    return enableFeedCallable;
  }

  @Override
  public UnaryCallable<DisableFeedRequest, Feed> disableFeedCallable() {
    return disableFeedCallable;
  }

  @Override
  public UnaryCallable<ListFeedsRequest, ListFeedsResponse> listFeedsCallable() {
    return listFeedsCallable;
  }

  @Override
  public UnaryCallable<ListFeedsRequest, ListFeedsPagedResponse> listFeedsPagedCallable() {
    return listFeedsPagedCallable;
  }

  @Override
  public UnaryCallable<ListFeedPacksRequest, ListFeedPacksResponse> listFeedPacksCallable() {
    return listFeedPacksCallable;
  }

  @Override
  public UnaryCallable<ListFeedPacksRequest, ListFeedPacksPagedResponse>
      listFeedPacksPagedCallable() {
    return listFeedPacksPagedCallable;
  }

  @Override
  public UnaryCallable<GetFeedPackRequest, FeedPack> getFeedPackCallable() {
    return getFeedPackCallable;
  }

  @Override
  public UnaryCallable<UpdateFeedRequest, Feed> updateFeedCallable() {
    return updateFeedCallable;
  }

  @Override
  public UnaryCallable<ListFeedSourceTypeSchemasRequest, ListFeedSourceTypeSchemasResponse>
      listFeedSourceTypeSchemasCallable() {
    return listFeedSourceTypeSchemasCallable;
  }

  @Override
  public UnaryCallable<ListFeedSourceTypeSchemasRequest, ListFeedSourceTypeSchemasPagedResponse>
      listFeedSourceTypeSchemasPagedCallable() {
    return listFeedSourceTypeSchemasPagedCallable;
  }

  @Override
  public UnaryCallable<ListLogTypeSchemasRequest, ListLogTypeSchemasResponse>
      listLogTypeSchemasCallable() {
    return listLogTypeSchemasCallable;
  }

  @Override
  public UnaryCallable<ListLogTypeSchemasRequest, ListLogTypeSchemasPagedResponse>
      listLogTypeSchemasPagedCallable() {
    return listLogTypeSchemasPagedCallable;
  }

  @Override
  public UnaryCallable<ImportPushLogsRequest, HttpBody> importPushLogsCallable() {
    return importPushLogsCallable;
  }

  @Override
  public UnaryCallable<GenerateSecretRequest, GenerateSecretResponse> generateSecretCallable() {
    return generateSecretCallable;
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
