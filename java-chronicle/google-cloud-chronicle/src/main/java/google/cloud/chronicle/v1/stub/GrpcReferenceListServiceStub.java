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

package google.cloud.chronicle.v1.stub;

import static google.cloud.chronicle.v1.ReferenceListServiceClient.ListReferenceListsPagedResponse;

import com.google.api.gax.core.BackgroundResource;
import com.google.api.gax.core.BackgroundResourceAggregation;
import com.google.api.gax.grpc.GrpcCallSettings;
import com.google.api.gax.grpc.GrpcStubCallableFactory;
import com.google.api.gax.rpc.ClientContext;
import com.google.api.gax.rpc.RequestParamsBuilder;
import com.google.api.gax.rpc.UnaryCallable;
import com.google.longrunning.stub.GrpcOperationsStub;
import google.cloud.chronicle.v1.CreateReferenceListRequest;
import google.cloud.chronicle.v1.GetReferenceListRequest;
import google.cloud.chronicle.v1.ListReferenceListsRequest;
import google.cloud.chronicle.v1.ListReferenceListsResponse;
import google.cloud.chronicle.v1.ReferenceList;
import google.cloud.chronicle.v1.UpdateReferenceListRequest;
import io.grpc.MethodDescriptor;
import io.grpc.protobuf.ProtoUtils;
import java.io.IOException;
import java.util.concurrent.TimeUnit;
import javax.annotation.Generated;

// AUTO-GENERATED DOCUMENTATION AND CLASS.
/**
 * gRPC stub implementation for the ReferenceListService service API.
 *
 * <p>This class is for advanced usage and reflects the underlying API directly.
 */
@Generated("by gapic-generator-java")
public class GrpcReferenceListServiceStub extends ReferenceListServiceStub {
  private static final MethodDescriptor<GetReferenceListRequest, ReferenceList>
      getReferenceListMethodDescriptor =
          MethodDescriptor.<GetReferenceListRequest, ReferenceList>newBuilder()
              .setType(MethodDescriptor.MethodType.UNARY)
              .setFullMethodName("google.cloud.chronicle.v1.ReferenceListService/GetReferenceList")
              .setRequestMarshaller(
                  ProtoUtils.marshaller(GetReferenceListRequest.getDefaultInstance()))
              .setResponseMarshaller(ProtoUtils.marshaller(ReferenceList.getDefaultInstance()))
              .build();

  private static final MethodDescriptor<ListReferenceListsRequest, ListReferenceListsResponse>
      listReferenceListsMethodDescriptor =
          MethodDescriptor.<ListReferenceListsRequest, ListReferenceListsResponse>newBuilder()
              .setType(MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(
                  "google.cloud.chronicle.v1.ReferenceListService/ListReferenceLists")
              .setRequestMarshaller(
                  ProtoUtils.marshaller(ListReferenceListsRequest.getDefaultInstance()))
              .setResponseMarshaller(
                  ProtoUtils.marshaller(ListReferenceListsResponse.getDefaultInstance()))
              .build();

  private static final MethodDescriptor<CreateReferenceListRequest, ReferenceList>
      createReferenceListMethodDescriptor =
          MethodDescriptor.<CreateReferenceListRequest, ReferenceList>newBuilder()
              .setType(MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(
                  "google.cloud.chronicle.v1.ReferenceListService/CreateReferenceList")
              .setRequestMarshaller(
                  ProtoUtils.marshaller(CreateReferenceListRequest.getDefaultInstance()))
              .setResponseMarshaller(ProtoUtils.marshaller(ReferenceList.getDefaultInstance()))
              .build();

  private static final MethodDescriptor<UpdateReferenceListRequest, ReferenceList>
      updateReferenceListMethodDescriptor =
          MethodDescriptor.<UpdateReferenceListRequest, ReferenceList>newBuilder()
              .setType(MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(
                  "google.cloud.chronicle.v1.ReferenceListService/UpdateReferenceList")
              .setRequestMarshaller(
                  ProtoUtils.marshaller(UpdateReferenceListRequest.getDefaultInstance()))
              .setResponseMarshaller(ProtoUtils.marshaller(ReferenceList.getDefaultInstance()))
              .build();

  private final UnaryCallable<GetReferenceListRequest, ReferenceList> getReferenceListCallable;
  private final UnaryCallable<ListReferenceListsRequest, ListReferenceListsResponse>
      listReferenceListsCallable;
  private final UnaryCallable<ListReferenceListsRequest, ListReferenceListsPagedResponse>
      listReferenceListsPagedCallable;
  private final UnaryCallable<CreateReferenceListRequest, ReferenceList>
      createReferenceListCallable;
  private final UnaryCallable<UpdateReferenceListRequest, ReferenceList>
      updateReferenceListCallable;

  private final BackgroundResource backgroundResources;
  private final GrpcOperationsStub operationsStub;
  private final GrpcStubCallableFactory callableFactory;

  public static final GrpcReferenceListServiceStub create(ReferenceListServiceStubSettings settings)
      throws IOException {
    return new GrpcReferenceListServiceStub(settings, ClientContext.create(settings));
  }

  public static final GrpcReferenceListServiceStub create(ClientContext clientContext)
      throws IOException {
    return new GrpcReferenceListServiceStub(
        ReferenceListServiceStubSettings.newBuilder().build(), clientContext);
  }

  public static final GrpcReferenceListServiceStub create(
      ClientContext clientContext, GrpcStubCallableFactory callableFactory) throws IOException {
    return new GrpcReferenceListServiceStub(
        ReferenceListServiceStubSettings.newBuilder().build(), clientContext, callableFactory);
  }

  /**
   * Constructs an instance of GrpcReferenceListServiceStub, using the given settings. This is
   * protected so that it is easy to make a subclass, but otherwise, the static factory methods
   * should be preferred.
   */
  protected GrpcReferenceListServiceStub(
      ReferenceListServiceStubSettings settings, ClientContext clientContext) throws IOException {
    this(settings, clientContext, new GrpcReferenceListServiceCallableFactory());
  }

  /**
   * Constructs an instance of GrpcReferenceListServiceStub, using the given settings. This is
   * protected so that it is easy to make a subclass, but otherwise, the static factory methods
   * should be preferred.
   */
  protected GrpcReferenceListServiceStub(
      ReferenceListServiceStubSettings settings,
      ClientContext clientContext,
      GrpcStubCallableFactory callableFactory)
      throws IOException {
    this.callableFactory = callableFactory;
    this.operationsStub = GrpcOperationsStub.create(clientContext, callableFactory);

    GrpcCallSettings<GetReferenceListRequest, ReferenceList> getReferenceListTransportSettings =
        GrpcCallSettings.<GetReferenceListRequest, ReferenceList>newBuilder()
            .setMethodDescriptor(getReferenceListMethodDescriptor)
            .setParamsExtractor(
                request -> {
                  RequestParamsBuilder builder = RequestParamsBuilder.create();
                  builder.add("name", String.valueOf(request.getName()));
                  return builder.build();
                })
            .build();
    GrpcCallSettings<ListReferenceListsRequest, ListReferenceListsResponse>
        listReferenceListsTransportSettings =
            GrpcCallSettings.<ListReferenceListsRequest, ListReferenceListsResponse>newBuilder()
                .setMethodDescriptor(listReferenceListsMethodDescriptor)
                .setParamsExtractor(
                    request -> {
                      RequestParamsBuilder builder = RequestParamsBuilder.create();
                      builder.add("parent", String.valueOf(request.getParent()));
                      return builder.build();
                    })
                .build();
    GrpcCallSettings<CreateReferenceListRequest, ReferenceList>
        createReferenceListTransportSettings =
            GrpcCallSettings.<CreateReferenceListRequest, ReferenceList>newBuilder()
                .setMethodDescriptor(createReferenceListMethodDescriptor)
                .setParamsExtractor(
                    request -> {
                      RequestParamsBuilder builder = RequestParamsBuilder.create();
                      builder.add("parent", String.valueOf(request.getParent()));
                      return builder.build();
                    })
                .build();
    GrpcCallSettings<UpdateReferenceListRequest, ReferenceList>
        updateReferenceListTransportSettings =
            GrpcCallSettings.<UpdateReferenceListRequest, ReferenceList>newBuilder()
                .setMethodDescriptor(updateReferenceListMethodDescriptor)
                .setParamsExtractor(
                    request -> {
                      RequestParamsBuilder builder = RequestParamsBuilder.create();
                      builder.add(
                          "reference_list.name",
                          String.valueOf(request.getReferenceList().getName()));
                      return builder.build();
                    })
                .build();

    this.getReferenceListCallable =
        callableFactory.createUnaryCallable(
            getReferenceListTransportSettings, settings.getReferenceListSettings(), clientContext);
    this.listReferenceListsCallable =
        callableFactory.createUnaryCallable(
            listReferenceListsTransportSettings,
            settings.listReferenceListsSettings(),
            clientContext);
    this.listReferenceListsPagedCallable =
        callableFactory.createPagedCallable(
            listReferenceListsTransportSettings,
            settings.listReferenceListsSettings(),
            clientContext);
    this.createReferenceListCallable =
        callableFactory.createUnaryCallable(
            createReferenceListTransportSettings,
            settings.createReferenceListSettings(),
            clientContext);
    this.updateReferenceListCallable =
        callableFactory.createUnaryCallable(
            updateReferenceListTransportSettings,
            settings.updateReferenceListSettings(),
            clientContext);

    this.backgroundResources =
        new BackgroundResourceAggregation(clientContext.getBackgroundResources());
  }

  public GrpcOperationsStub getOperationsStub() {
    return operationsStub;
  }

  @Override
  public UnaryCallable<GetReferenceListRequest, ReferenceList> getReferenceListCallable() {
    return getReferenceListCallable;
  }

  @Override
  public UnaryCallable<ListReferenceListsRequest, ListReferenceListsResponse>
      listReferenceListsCallable() {
    return listReferenceListsCallable;
  }

  @Override
  public UnaryCallable<ListReferenceListsRequest, ListReferenceListsPagedResponse>
      listReferenceListsPagedCallable() {
    return listReferenceListsPagedCallable;
  }

  @Override
  public UnaryCallable<CreateReferenceListRequest, ReferenceList> createReferenceListCallable() {
    return createReferenceListCallable;
  }

  @Override
  public UnaryCallable<UpdateReferenceListRequest, ReferenceList> updateReferenceListCallable() {
    return updateReferenceListCallable;
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
