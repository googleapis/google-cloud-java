/*
 * Copyright 2023 Google LLC
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

package com.google.cloud.dialogflow.cx.v3beta1.stub;

import static com.google.cloud.dialogflow.cx.v3beta1.PlaybooksClient.ListLocationsPagedResponse;
import static com.google.cloud.dialogflow.cx.v3beta1.PlaybooksClient.ListPlaybookVersionsPagedResponse;
import static com.google.cloud.dialogflow.cx.v3beta1.PlaybooksClient.ListPlaybooksPagedResponse;

import com.google.api.core.BetaApi;
import com.google.api.gax.core.BackgroundResource;
import com.google.api.gax.core.BackgroundResourceAggregation;
import com.google.api.gax.grpc.GrpcCallSettings;
import com.google.api.gax.grpc.GrpcStubCallableFactory;
import com.google.api.gax.rpc.ClientContext;
import com.google.api.gax.rpc.RequestParamsBuilder;
import com.google.api.gax.rpc.UnaryCallable;
import com.google.cloud.dialogflow.cx.v3beta1.CreatePlaybookRequest;
import com.google.cloud.dialogflow.cx.v3beta1.CreatePlaybookVersionRequest;
import com.google.cloud.dialogflow.cx.v3beta1.DeletePlaybookRequest;
import com.google.cloud.dialogflow.cx.v3beta1.DeletePlaybookVersionRequest;
import com.google.cloud.dialogflow.cx.v3beta1.GetPlaybookRequest;
import com.google.cloud.dialogflow.cx.v3beta1.GetPlaybookVersionRequest;
import com.google.cloud.dialogflow.cx.v3beta1.ListPlaybookVersionsRequest;
import com.google.cloud.dialogflow.cx.v3beta1.ListPlaybookVersionsResponse;
import com.google.cloud.dialogflow.cx.v3beta1.ListPlaybooksRequest;
import com.google.cloud.dialogflow.cx.v3beta1.ListPlaybooksResponse;
import com.google.cloud.dialogflow.cx.v3beta1.Playbook;
import com.google.cloud.dialogflow.cx.v3beta1.PlaybookVersion;
import com.google.cloud.dialogflow.cx.v3beta1.UpdatePlaybookRequest;
import com.google.cloud.location.GetLocationRequest;
import com.google.cloud.location.ListLocationsRequest;
import com.google.cloud.location.ListLocationsResponse;
import com.google.cloud.location.Location;
import com.google.longrunning.stub.GrpcOperationsStub;
import com.google.protobuf.Empty;
import io.grpc.MethodDescriptor;
import io.grpc.protobuf.ProtoUtils;
import java.io.IOException;
import java.util.concurrent.TimeUnit;
import javax.annotation.Generated;

// AUTO-GENERATED DOCUMENTATION AND CLASS.
/**
 * gRPC stub implementation for the Playbooks service API.
 *
 * <p>This class is for advanced usage and reflects the underlying API directly.
 */
@BetaApi
@Generated("by gapic-generator-java")
public class GrpcPlaybooksStub extends PlaybooksStub {
  private static final MethodDescriptor<CreatePlaybookRequest, Playbook>
      createPlaybookMethodDescriptor =
          MethodDescriptor.<CreatePlaybookRequest, Playbook>newBuilder()
              .setType(MethodDescriptor.MethodType.UNARY)
              .setFullMethodName("google.cloud.dialogflow.cx.v3beta1.Playbooks/CreatePlaybook")
              .setRequestMarshaller(
                  ProtoUtils.marshaller(CreatePlaybookRequest.getDefaultInstance()))
              .setResponseMarshaller(ProtoUtils.marshaller(Playbook.getDefaultInstance()))
              .build();

  private static final MethodDescriptor<DeletePlaybookRequest, Empty>
      deletePlaybookMethodDescriptor =
          MethodDescriptor.<DeletePlaybookRequest, Empty>newBuilder()
              .setType(MethodDescriptor.MethodType.UNARY)
              .setFullMethodName("google.cloud.dialogflow.cx.v3beta1.Playbooks/DeletePlaybook")
              .setRequestMarshaller(
                  ProtoUtils.marshaller(DeletePlaybookRequest.getDefaultInstance()))
              .setResponseMarshaller(ProtoUtils.marshaller(Empty.getDefaultInstance()))
              .build();

  private static final MethodDescriptor<ListPlaybooksRequest, ListPlaybooksResponse>
      listPlaybooksMethodDescriptor =
          MethodDescriptor.<ListPlaybooksRequest, ListPlaybooksResponse>newBuilder()
              .setType(MethodDescriptor.MethodType.UNARY)
              .setFullMethodName("google.cloud.dialogflow.cx.v3beta1.Playbooks/ListPlaybooks")
              .setRequestMarshaller(
                  ProtoUtils.marshaller(ListPlaybooksRequest.getDefaultInstance()))
              .setResponseMarshaller(
                  ProtoUtils.marshaller(ListPlaybooksResponse.getDefaultInstance()))
              .build();

  private static final MethodDescriptor<GetPlaybookRequest, Playbook> getPlaybookMethodDescriptor =
      MethodDescriptor.<GetPlaybookRequest, Playbook>newBuilder()
          .setType(MethodDescriptor.MethodType.UNARY)
          .setFullMethodName("google.cloud.dialogflow.cx.v3beta1.Playbooks/GetPlaybook")
          .setRequestMarshaller(ProtoUtils.marshaller(GetPlaybookRequest.getDefaultInstance()))
          .setResponseMarshaller(ProtoUtils.marshaller(Playbook.getDefaultInstance()))
          .build();

  private static final MethodDescriptor<UpdatePlaybookRequest, Playbook>
      updatePlaybookMethodDescriptor =
          MethodDescriptor.<UpdatePlaybookRequest, Playbook>newBuilder()
              .setType(MethodDescriptor.MethodType.UNARY)
              .setFullMethodName("google.cloud.dialogflow.cx.v3beta1.Playbooks/UpdatePlaybook")
              .setRequestMarshaller(
                  ProtoUtils.marshaller(UpdatePlaybookRequest.getDefaultInstance()))
              .setResponseMarshaller(ProtoUtils.marshaller(Playbook.getDefaultInstance()))
              .build();

  private static final MethodDescriptor<CreatePlaybookVersionRequest, PlaybookVersion>
      createPlaybookVersionMethodDescriptor =
          MethodDescriptor.<CreatePlaybookVersionRequest, PlaybookVersion>newBuilder()
              .setType(MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(
                  "google.cloud.dialogflow.cx.v3beta1.Playbooks/CreatePlaybookVersion")
              .setRequestMarshaller(
                  ProtoUtils.marshaller(CreatePlaybookVersionRequest.getDefaultInstance()))
              .setResponseMarshaller(ProtoUtils.marshaller(PlaybookVersion.getDefaultInstance()))
              .build();

  private static final MethodDescriptor<GetPlaybookVersionRequest, PlaybookVersion>
      getPlaybookVersionMethodDescriptor =
          MethodDescriptor.<GetPlaybookVersionRequest, PlaybookVersion>newBuilder()
              .setType(MethodDescriptor.MethodType.UNARY)
              .setFullMethodName("google.cloud.dialogflow.cx.v3beta1.Playbooks/GetPlaybookVersion")
              .setRequestMarshaller(
                  ProtoUtils.marshaller(GetPlaybookVersionRequest.getDefaultInstance()))
              .setResponseMarshaller(ProtoUtils.marshaller(PlaybookVersion.getDefaultInstance()))
              .build();

  private static final MethodDescriptor<ListPlaybookVersionsRequest, ListPlaybookVersionsResponse>
      listPlaybookVersionsMethodDescriptor =
          MethodDescriptor.<ListPlaybookVersionsRequest, ListPlaybookVersionsResponse>newBuilder()
              .setType(MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(
                  "google.cloud.dialogflow.cx.v3beta1.Playbooks/ListPlaybookVersions")
              .setRequestMarshaller(
                  ProtoUtils.marshaller(ListPlaybookVersionsRequest.getDefaultInstance()))
              .setResponseMarshaller(
                  ProtoUtils.marshaller(ListPlaybookVersionsResponse.getDefaultInstance()))
              .build();

  private static final MethodDescriptor<DeletePlaybookVersionRequest, Empty>
      deletePlaybookVersionMethodDescriptor =
          MethodDescriptor.<DeletePlaybookVersionRequest, Empty>newBuilder()
              .setType(MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(
                  "google.cloud.dialogflow.cx.v3beta1.Playbooks/DeletePlaybookVersion")
              .setRequestMarshaller(
                  ProtoUtils.marshaller(DeletePlaybookVersionRequest.getDefaultInstance()))
              .setResponseMarshaller(ProtoUtils.marshaller(Empty.getDefaultInstance()))
              .build();

  private static final MethodDescriptor<ListLocationsRequest, ListLocationsResponse>
      listLocationsMethodDescriptor =
          MethodDescriptor.<ListLocationsRequest, ListLocationsResponse>newBuilder()
              .setType(MethodDescriptor.MethodType.UNARY)
              .setFullMethodName("google.cloud.location.Locations/ListLocations")
              .setRequestMarshaller(
                  ProtoUtils.marshaller(ListLocationsRequest.getDefaultInstance()))
              .setResponseMarshaller(
                  ProtoUtils.marshaller(ListLocationsResponse.getDefaultInstance()))
              .build();

  private static final MethodDescriptor<GetLocationRequest, Location> getLocationMethodDescriptor =
      MethodDescriptor.<GetLocationRequest, Location>newBuilder()
          .setType(MethodDescriptor.MethodType.UNARY)
          .setFullMethodName("google.cloud.location.Locations/GetLocation")
          .setRequestMarshaller(ProtoUtils.marshaller(GetLocationRequest.getDefaultInstance()))
          .setResponseMarshaller(ProtoUtils.marshaller(Location.getDefaultInstance()))
          .build();

  private final UnaryCallable<CreatePlaybookRequest, Playbook> createPlaybookCallable;
  private final UnaryCallable<DeletePlaybookRequest, Empty> deletePlaybookCallable;
  private final UnaryCallable<ListPlaybooksRequest, ListPlaybooksResponse> listPlaybooksCallable;
  private final UnaryCallable<ListPlaybooksRequest, ListPlaybooksPagedResponse>
      listPlaybooksPagedCallable;
  private final UnaryCallable<GetPlaybookRequest, Playbook> getPlaybookCallable;
  private final UnaryCallable<UpdatePlaybookRequest, Playbook> updatePlaybookCallable;
  private final UnaryCallable<CreatePlaybookVersionRequest, PlaybookVersion>
      createPlaybookVersionCallable;
  private final UnaryCallable<GetPlaybookVersionRequest, PlaybookVersion>
      getPlaybookVersionCallable;
  private final UnaryCallable<ListPlaybookVersionsRequest, ListPlaybookVersionsResponse>
      listPlaybookVersionsCallable;
  private final UnaryCallable<ListPlaybookVersionsRequest, ListPlaybookVersionsPagedResponse>
      listPlaybookVersionsPagedCallable;
  private final UnaryCallable<DeletePlaybookVersionRequest, Empty> deletePlaybookVersionCallable;
  private final UnaryCallable<ListLocationsRequest, ListLocationsResponse> listLocationsCallable;
  private final UnaryCallable<ListLocationsRequest, ListLocationsPagedResponse>
      listLocationsPagedCallable;
  private final UnaryCallable<GetLocationRequest, Location> getLocationCallable;

  private final BackgroundResource backgroundResources;
  private final GrpcOperationsStub operationsStub;
  private final GrpcStubCallableFactory callableFactory;

  public static final GrpcPlaybooksStub create(PlaybooksStubSettings settings) throws IOException {
    return new GrpcPlaybooksStub(settings, ClientContext.create(settings));
  }

  public static final GrpcPlaybooksStub create(ClientContext clientContext) throws IOException {
    return new GrpcPlaybooksStub(PlaybooksStubSettings.newBuilder().build(), clientContext);
  }

  public static final GrpcPlaybooksStub create(
      ClientContext clientContext, GrpcStubCallableFactory callableFactory) throws IOException {
    return new GrpcPlaybooksStub(
        PlaybooksStubSettings.newBuilder().build(), clientContext, callableFactory);
  }

  /**
   * Constructs an instance of GrpcPlaybooksStub, using the given settings. This is protected so
   * that it is easy to make a subclass, but otherwise, the static factory methods should be
   * preferred.
   */
  protected GrpcPlaybooksStub(PlaybooksStubSettings settings, ClientContext clientContext)
      throws IOException {
    this(settings, clientContext, new GrpcPlaybooksCallableFactory());
  }

  /**
   * Constructs an instance of GrpcPlaybooksStub, using the given settings. This is protected so
   * that it is easy to make a subclass, but otherwise, the static factory methods should be
   * preferred.
   */
  protected GrpcPlaybooksStub(
      PlaybooksStubSettings settings,
      ClientContext clientContext,
      GrpcStubCallableFactory callableFactory)
      throws IOException {
    this.callableFactory = callableFactory;
    this.operationsStub = GrpcOperationsStub.create(clientContext, callableFactory);

    GrpcCallSettings<CreatePlaybookRequest, Playbook> createPlaybookTransportSettings =
        GrpcCallSettings.<CreatePlaybookRequest, Playbook>newBuilder()
            .setMethodDescriptor(createPlaybookMethodDescriptor)
            .setParamsExtractor(
                request -> {
                  RequestParamsBuilder builder = RequestParamsBuilder.create();
                  builder.add("parent", String.valueOf(request.getParent()));
                  return builder.build();
                })
            .build();
    GrpcCallSettings<DeletePlaybookRequest, Empty> deletePlaybookTransportSettings =
        GrpcCallSettings.<DeletePlaybookRequest, Empty>newBuilder()
            .setMethodDescriptor(deletePlaybookMethodDescriptor)
            .setParamsExtractor(
                request -> {
                  RequestParamsBuilder builder = RequestParamsBuilder.create();
                  builder.add("name", String.valueOf(request.getName()));
                  return builder.build();
                })
            .build();
    GrpcCallSettings<ListPlaybooksRequest, ListPlaybooksResponse> listPlaybooksTransportSettings =
        GrpcCallSettings.<ListPlaybooksRequest, ListPlaybooksResponse>newBuilder()
            .setMethodDescriptor(listPlaybooksMethodDescriptor)
            .setParamsExtractor(
                request -> {
                  RequestParamsBuilder builder = RequestParamsBuilder.create();
                  builder.add("parent", String.valueOf(request.getParent()));
                  return builder.build();
                })
            .build();
    GrpcCallSettings<GetPlaybookRequest, Playbook> getPlaybookTransportSettings =
        GrpcCallSettings.<GetPlaybookRequest, Playbook>newBuilder()
            .setMethodDescriptor(getPlaybookMethodDescriptor)
            .setParamsExtractor(
                request -> {
                  RequestParamsBuilder builder = RequestParamsBuilder.create();
                  builder.add("name", String.valueOf(request.getName()));
                  return builder.build();
                })
            .build();
    GrpcCallSettings<UpdatePlaybookRequest, Playbook> updatePlaybookTransportSettings =
        GrpcCallSettings.<UpdatePlaybookRequest, Playbook>newBuilder()
            .setMethodDescriptor(updatePlaybookMethodDescriptor)
            .setParamsExtractor(
                request -> {
                  RequestParamsBuilder builder = RequestParamsBuilder.create();
                  builder.add("playbook.name", String.valueOf(request.getPlaybook().getName()));
                  return builder.build();
                })
            .build();
    GrpcCallSettings<CreatePlaybookVersionRequest, PlaybookVersion>
        createPlaybookVersionTransportSettings =
            GrpcCallSettings.<CreatePlaybookVersionRequest, PlaybookVersion>newBuilder()
                .setMethodDescriptor(createPlaybookVersionMethodDescriptor)
                .setParamsExtractor(
                    request -> {
                      RequestParamsBuilder builder = RequestParamsBuilder.create();
                      builder.add("parent", String.valueOf(request.getParent()));
                      return builder.build();
                    })
                .build();
    GrpcCallSettings<GetPlaybookVersionRequest, PlaybookVersion>
        getPlaybookVersionTransportSettings =
            GrpcCallSettings.<GetPlaybookVersionRequest, PlaybookVersion>newBuilder()
                .setMethodDescriptor(getPlaybookVersionMethodDescriptor)
                .setParamsExtractor(
                    request -> {
                      RequestParamsBuilder builder = RequestParamsBuilder.create();
                      builder.add("name", String.valueOf(request.getName()));
                      return builder.build();
                    })
                .build();
    GrpcCallSettings<ListPlaybookVersionsRequest, ListPlaybookVersionsResponse>
        listPlaybookVersionsTransportSettings =
            GrpcCallSettings.<ListPlaybookVersionsRequest, ListPlaybookVersionsResponse>newBuilder()
                .setMethodDescriptor(listPlaybookVersionsMethodDescriptor)
                .setParamsExtractor(
                    request -> {
                      RequestParamsBuilder builder = RequestParamsBuilder.create();
                      builder.add("parent", String.valueOf(request.getParent()));
                      return builder.build();
                    })
                .build();
    GrpcCallSettings<DeletePlaybookVersionRequest, Empty> deletePlaybookVersionTransportSettings =
        GrpcCallSettings.<DeletePlaybookVersionRequest, Empty>newBuilder()
            .setMethodDescriptor(deletePlaybookVersionMethodDescriptor)
            .setParamsExtractor(
                request -> {
                  RequestParamsBuilder builder = RequestParamsBuilder.create();
                  builder.add("name", String.valueOf(request.getName()));
                  return builder.build();
                })
            .build();
    GrpcCallSettings<ListLocationsRequest, ListLocationsResponse> listLocationsTransportSettings =
        GrpcCallSettings.<ListLocationsRequest, ListLocationsResponse>newBuilder()
            .setMethodDescriptor(listLocationsMethodDescriptor)
            .setParamsExtractor(
                request -> {
                  RequestParamsBuilder builder = RequestParamsBuilder.create();
                  builder.add("name", String.valueOf(request.getName()));
                  return builder.build();
                })
            .build();
    GrpcCallSettings<GetLocationRequest, Location> getLocationTransportSettings =
        GrpcCallSettings.<GetLocationRequest, Location>newBuilder()
            .setMethodDescriptor(getLocationMethodDescriptor)
            .setParamsExtractor(
                request -> {
                  RequestParamsBuilder builder = RequestParamsBuilder.create();
                  builder.add("name", String.valueOf(request.getName()));
                  return builder.build();
                })
            .build();

    this.createPlaybookCallable =
        callableFactory.createUnaryCallable(
            createPlaybookTransportSettings, settings.createPlaybookSettings(), clientContext);
    this.deletePlaybookCallable =
        callableFactory.createUnaryCallable(
            deletePlaybookTransportSettings, settings.deletePlaybookSettings(), clientContext);
    this.listPlaybooksCallable =
        callableFactory.createUnaryCallable(
            listPlaybooksTransportSettings, settings.listPlaybooksSettings(), clientContext);
    this.listPlaybooksPagedCallable =
        callableFactory.createPagedCallable(
            listPlaybooksTransportSettings, settings.listPlaybooksSettings(), clientContext);
    this.getPlaybookCallable =
        callableFactory.createUnaryCallable(
            getPlaybookTransportSettings, settings.getPlaybookSettings(), clientContext);
    this.updatePlaybookCallable =
        callableFactory.createUnaryCallable(
            updatePlaybookTransportSettings, settings.updatePlaybookSettings(), clientContext);
    this.createPlaybookVersionCallable =
        callableFactory.createUnaryCallable(
            createPlaybookVersionTransportSettings,
            settings.createPlaybookVersionSettings(),
            clientContext);
    this.getPlaybookVersionCallable =
        callableFactory.createUnaryCallable(
            getPlaybookVersionTransportSettings,
            settings.getPlaybookVersionSettings(),
            clientContext);
    this.listPlaybookVersionsCallable =
        callableFactory.createUnaryCallable(
            listPlaybookVersionsTransportSettings,
            settings.listPlaybookVersionsSettings(),
            clientContext);
    this.listPlaybookVersionsPagedCallable =
        callableFactory.createPagedCallable(
            listPlaybookVersionsTransportSettings,
            settings.listPlaybookVersionsSettings(),
            clientContext);
    this.deletePlaybookVersionCallable =
        callableFactory.createUnaryCallable(
            deletePlaybookVersionTransportSettings,
            settings.deletePlaybookVersionSettings(),
            clientContext);
    this.listLocationsCallable =
        callableFactory.createUnaryCallable(
            listLocationsTransportSettings, settings.listLocationsSettings(), clientContext);
    this.listLocationsPagedCallable =
        callableFactory.createPagedCallable(
            listLocationsTransportSettings, settings.listLocationsSettings(), clientContext);
    this.getLocationCallable =
        callableFactory.createUnaryCallable(
            getLocationTransportSettings, settings.getLocationSettings(), clientContext);

    this.backgroundResources =
        new BackgroundResourceAggregation(clientContext.getBackgroundResources());
  }

  public GrpcOperationsStub getOperationsStub() {
    return operationsStub;
  }

  @Override
  public UnaryCallable<CreatePlaybookRequest, Playbook> createPlaybookCallable() {
    return createPlaybookCallable;
  }

  @Override
  public UnaryCallable<DeletePlaybookRequest, Empty> deletePlaybookCallable() {
    return deletePlaybookCallable;
  }

  @Override
  public UnaryCallable<ListPlaybooksRequest, ListPlaybooksResponse> listPlaybooksCallable() {
    return listPlaybooksCallable;
  }

  @Override
  public UnaryCallable<ListPlaybooksRequest, ListPlaybooksPagedResponse>
      listPlaybooksPagedCallable() {
    return listPlaybooksPagedCallable;
  }

  @Override
  public UnaryCallable<GetPlaybookRequest, Playbook> getPlaybookCallable() {
    return getPlaybookCallable;
  }

  @Override
  public UnaryCallable<UpdatePlaybookRequest, Playbook> updatePlaybookCallable() {
    return updatePlaybookCallable;
  }

  @Override
  public UnaryCallable<CreatePlaybookVersionRequest, PlaybookVersion>
      createPlaybookVersionCallable() {
    return createPlaybookVersionCallable;
  }

  @Override
  public UnaryCallable<GetPlaybookVersionRequest, PlaybookVersion> getPlaybookVersionCallable() {
    return getPlaybookVersionCallable;
  }

  @Override
  public UnaryCallable<ListPlaybookVersionsRequest, ListPlaybookVersionsResponse>
      listPlaybookVersionsCallable() {
    return listPlaybookVersionsCallable;
  }

  @Override
  public UnaryCallable<ListPlaybookVersionsRequest, ListPlaybookVersionsPagedResponse>
      listPlaybookVersionsPagedCallable() {
    return listPlaybookVersionsPagedCallable;
  }

  @Override
  public UnaryCallable<DeletePlaybookVersionRequest, Empty> deletePlaybookVersionCallable() {
    return deletePlaybookVersionCallable;
  }

  @Override
  public UnaryCallable<ListLocationsRequest, ListLocationsResponse> listLocationsCallable() {
    return listLocationsCallable;
  }

  @Override
  public UnaryCallable<ListLocationsRequest, ListLocationsPagedResponse>
      listLocationsPagedCallable() {
    return listLocationsPagedCallable;
  }

  @Override
  public UnaryCallable<GetLocationRequest, Location> getLocationCallable() {
    return getLocationCallable;
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
