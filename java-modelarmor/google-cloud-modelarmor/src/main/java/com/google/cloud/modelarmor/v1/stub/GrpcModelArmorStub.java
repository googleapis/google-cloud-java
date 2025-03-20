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

package com.google.cloud.modelarmor.v1.stub;

import static com.google.cloud.modelarmor.v1.ModelArmorClient.ListLocationsPagedResponse;
import static com.google.cloud.modelarmor.v1.ModelArmorClient.ListTemplatesPagedResponse;

import com.google.api.gax.core.BackgroundResource;
import com.google.api.gax.core.BackgroundResourceAggregation;
import com.google.api.gax.grpc.GrpcCallSettings;
import com.google.api.gax.grpc.GrpcStubCallableFactory;
import com.google.api.gax.rpc.ClientContext;
import com.google.api.gax.rpc.RequestParamsBuilder;
import com.google.api.gax.rpc.UnaryCallable;
import com.google.cloud.location.GetLocationRequest;
import com.google.cloud.location.ListLocationsRequest;
import com.google.cloud.location.ListLocationsResponse;
import com.google.cloud.location.Location;
import com.google.cloud.modelarmor.v1.CreateTemplateRequest;
import com.google.cloud.modelarmor.v1.DeleteTemplateRequest;
import com.google.cloud.modelarmor.v1.FloorSetting;
import com.google.cloud.modelarmor.v1.GetFloorSettingRequest;
import com.google.cloud.modelarmor.v1.GetTemplateRequest;
import com.google.cloud.modelarmor.v1.ListTemplatesRequest;
import com.google.cloud.modelarmor.v1.ListTemplatesResponse;
import com.google.cloud.modelarmor.v1.SanitizeModelResponseRequest;
import com.google.cloud.modelarmor.v1.SanitizeModelResponseResponse;
import com.google.cloud.modelarmor.v1.SanitizeUserPromptRequest;
import com.google.cloud.modelarmor.v1.SanitizeUserPromptResponse;
import com.google.cloud.modelarmor.v1.Template;
import com.google.cloud.modelarmor.v1.UpdateFloorSettingRequest;
import com.google.cloud.modelarmor.v1.UpdateTemplateRequest;
import com.google.longrunning.stub.GrpcOperationsStub;
import com.google.protobuf.Empty;
import io.grpc.MethodDescriptor;
import io.grpc.protobuf.ProtoUtils;
import java.io.IOException;
import java.util.concurrent.TimeUnit;
import javax.annotation.Generated;

// AUTO-GENERATED DOCUMENTATION AND CLASS.
/**
 * gRPC stub implementation for the ModelArmor service API.
 *
 * <p>This class is for advanced usage and reflects the underlying API directly.
 */
@Generated("by gapic-generator-java")
public class GrpcModelArmorStub extends ModelArmorStub {
  private static final MethodDescriptor<ListTemplatesRequest, ListTemplatesResponse>
      listTemplatesMethodDescriptor =
          MethodDescriptor.<ListTemplatesRequest, ListTemplatesResponse>newBuilder()
              .setType(MethodDescriptor.MethodType.UNARY)
              .setFullMethodName("google.cloud.modelarmor.v1.ModelArmor/ListTemplates")
              .setRequestMarshaller(
                  ProtoUtils.marshaller(ListTemplatesRequest.getDefaultInstance()))
              .setResponseMarshaller(
                  ProtoUtils.marshaller(ListTemplatesResponse.getDefaultInstance()))
              .build();

  private static final MethodDescriptor<GetTemplateRequest, Template> getTemplateMethodDescriptor =
      MethodDescriptor.<GetTemplateRequest, Template>newBuilder()
          .setType(MethodDescriptor.MethodType.UNARY)
          .setFullMethodName("google.cloud.modelarmor.v1.ModelArmor/GetTemplate")
          .setRequestMarshaller(ProtoUtils.marshaller(GetTemplateRequest.getDefaultInstance()))
          .setResponseMarshaller(ProtoUtils.marshaller(Template.getDefaultInstance()))
          .build();

  private static final MethodDescriptor<CreateTemplateRequest, Template>
      createTemplateMethodDescriptor =
          MethodDescriptor.<CreateTemplateRequest, Template>newBuilder()
              .setType(MethodDescriptor.MethodType.UNARY)
              .setFullMethodName("google.cloud.modelarmor.v1.ModelArmor/CreateTemplate")
              .setRequestMarshaller(
                  ProtoUtils.marshaller(CreateTemplateRequest.getDefaultInstance()))
              .setResponseMarshaller(ProtoUtils.marshaller(Template.getDefaultInstance()))
              .build();

  private static final MethodDescriptor<UpdateTemplateRequest, Template>
      updateTemplateMethodDescriptor =
          MethodDescriptor.<UpdateTemplateRequest, Template>newBuilder()
              .setType(MethodDescriptor.MethodType.UNARY)
              .setFullMethodName("google.cloud.modelarmor.v1.ModelArmor/UpdateTemplate")
              .setRequestMarshaller(
                  ProtoUtils.marshaller(UpdateTemplateRequest.getDefaultInstance()))
              .setResponseMarshaller(ProtoUtils.marshaller(Template.getDefaultInstance()))
              .build();

  private static final MethodDescriptor<DeleteTemplateRequest, Empty>
      deleteTemplateMethodDescriptor =
          MethodDescriptor.<DeleteTemplateRequest, Empty>newBuilder()
              .setType(MethodDescriptor.MethodType.UNARY)
              .setFullMethodName("google.cloud.modelarmor.v1.ModelArmor/DeleteTemplate")
              .setRequestMarshaller(
                  ProtoUtils.marshaller(DeleteTemplateRequest.getDefaultInstance()))
              .setResponseMarshaller(ProtoUtils.marshaller(Empty.getDefaultInstance()))
              .build();

  private static final MethodDescriptor<GetFloorSettingRequest, FloorSetting>
      getFloorSettingMethodDescriptor =
          MethodDescriptor.<GetFloorSettingRequest, FloorSetting>newBuilder()
              .setType(MethodDescriptor.MethodType.UNARY)
              .setFullMethodName("google.cloud.modelarmor.v1.ModelArmor/GetFloorSetting")
              .setRequestMarshaller(
                  ProtoUtils.marshaller(GetFloorSettingRequest.getDefaultInstance()))
              .setResponseMarshaller(ProtoUtils.marshaller(FloorSetting.getDefaultInstance()))
              .build();

  private static final MethodDescriptor<UpdateFloorSettingRequest, FloorSetting>
      updateFloorSettingMethodDescriptor =
          MethodDescriptor.<UpdateFloorSettingRequest, FloorSetting>newBuilder()
              .setType(MethodDescriptor.MethodType.UNARY)
              .setFullMethodName("google.cloud.modelarmor.v1.ModelArmor/UpdateFloorSetting")
              .setRequestMarshaller(
                  ProtoUtils.marshaller(UpdateFloorSettingRequest.getDefaultInstance()))
              .setResponseMarshaller(ProtoUtils.marshaller(FloorSetting.getDefaultInstance()))
              .build();

  private static final MethodDescriptor<SanitizeUserPromptRequest, SanitizeUserPromptResponse>
      sanitizeUserPromptMethodDescriptor =
          MethodDescriptor.<SanitizeUserPromptRequest, SanitizeUserPromptResponse>newBuilder()
              .setType(MethodDescriptor.MethodType.UNARY)
              .setFullMethodName("google.cloud.modelarmor.v1.ModelArmor/SanitizeUserPrompt")
              .setRequestMarshaller(
                  ProtoUtils.marshaller(SanitizeUserPromptRequest.getDefaultInstance()))
              .setResponseMarshaller(
                  ProtoUtils.marshaller(SanitizeUserPromptResponse.getDefaultInstance()))
              .build();

  private static final MethodDescriptor<SanitizeModelResponseRequest, SanitizeModelResponseResponse>
      sanitizeModelResponseMethodDescriptor =
          MethodDescriptor.<SanitizeModelResponseRequest, SanitizeModelResponseResponse>newBuilder()
              .setType(MethodDescriptor.MethodType.UNARY)
              .setFullMethodName("google.cloud.modelarmor.v1.ModelArmor/SanitizeModelResponse")
              .setRequestMarshaller(
                  ProtoUtils.marshaller(SanitizeModelResponseRequest.getDefaultInstance()))
              .setResponseMarshaller(
                  ProtoUtils.marshaller(SanitizeModelResponseResponse.getDefaultInstance()))
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

  private final UnaryCallable<ListTemplatesRequest, ListTemplatesResponse> listTemplatesCallable;
  private final UnaryCallable<ListTemplatesRequest, ListTemplatesPagedResponse>
      listTemplatesPagedCallable;
  private final UnaryCallable<GetTemplateRequest, Template> getTemplateCallable;
  private final UnaryCallable<CreateTemplateRequest, Template> createTemplateCallable;
  private final UnaryCallable<UpdateTemplateRequest, Template> updateTemplateCallable;
  private final UnaryCallable<DeleteTemplateRequest, Empty> deleteTemplateCallable;
  private final UnaryCallable<GetFloorSettingRequest, FloorSetting> getFloorSettingCallable;
  private final UnaryCallable<UpdateFloorSettingRequest, FloorSetting> updateFloorSettingCallable;
  private final UnaryCallable<SanitizeUserPromptRequest, SanitizeUserPromptResponse>
      sanitizeUserPromptCallable;
  private final UnaryCallable<SanitizeModelResponseRequest, SanitizeModelResponseResponse>
      sanitizeModelResponseCallable;
  private final UnaryCallable<ListLocationsRequest, ListLocationsResponse> listLocationsCallable;
  private final UnaryCallable<ListLocationsRequest, ListLocationsPagedResponse>
      listLocationsPagedCallable;
  private final UnaryCallable<GetLocationRequest, Location> getLocationCallable;

  private final BackgroundResource backgroundResources;
  private final GrpcOperationsStub operationsStub;
  private final GrpcStubCallableFactory callableFactory;

  public static final GrpcModelArmorStub create(ModelArmorStubSettings settings)
      throws IOException {
    return new GrpcModelArmorStub(settings, ClientContext.create(settings));
  }

  public static final GrpcModelArmorStub create(ClientContext clientContext) throws IOException {
    return new GrpcModelArmorStub(ModelArmorStubSettings.newBuilder().build(), clientContext);
  }

  public static final GrpcModelArmorStub create(
      ClientContext clientContext, GrpcStubCallableFactory callableFactory) throws IOException {
    return new GrpcModelArmorStub(
        ModelArmorStubSettings.newBuilder().build(), clientContext, callableFactory);
  }

  /**
   * Constructs an instance of GrpcModelArmorStub, using the given settings. This is protected so
   * that it is easy to make a subclass, but otherwise, the static factory methods should be
   * preferred.
   */
  protected GrpcModelArmorStub(ModelArmorStubSettings settings, ClientContext clientContext)
      throws IOException {
    this(settings, clientContext, new GrpcModelArmorCallableFactory());
  }

  /**
   * Constructs an instance of GrpcModelArmorStub, using the given settings. This is protected so
   * that it is easy to make a subclass, but otherwise, the static factory methods should be
   * preferred.
   */
  protected GrpcModelArmorStub(
      ModelArmorStubSettings settings,
      ClientContext clientContext,
      GrpcStubCallableFactory callableFactory)
      throws IOException {
    this.callableFactory = callableFactory;
    this.operationsStub = GrpcOperationsStub.create(clientContext, callableFactory);

    GrpcCallSettings<ListTemplatesRequest, ListTemplatesResponse> listTemplatesTransportSettings =
        GrpcCallSettings.<ListTemplatesRequest, ListTemplatesResponse>newBuilder()
            .setMethodDescriptor(listTemplatesMethodDescriptor)
            .setParamsExtractor(
                request -> {
                  RequestParamsBuilder builder = RequestParamsBuilder.create();
                  builder.add("parent", String.valueOf(request.getParent()));
                  return builder.build();
                })
            .build();
    GrpcCallSettings<GetTemplateRequest, Template> getTemplateTransportSettings =
        GrpcCallSettings.<GetTemplateRequest, Template>newBuilder()
            .setMethodDescriptor(getTemplateMethodDescriptor)
            .setParamsExtractor(
                request -> {
                  RequestParamsBuilder builder = RequestParamsBuilder.create();
                  builder.add("name", String.valueOf(request.getName()));
                  return builder.build();
                })
            .build();
    GrpcCallSettings<CreateTemplateRequest, Template> createTemplateTransportSettings =
        GrpcCallSettings.<CreateTemplateRequest, Template>newBuilder()
            .setMethodDescriptor(createTemplateMethodDescriptor)
            .setParamsExtractor(
                request -> {
                  RequestParamsBuilder builder = RequestParamsBuilder.create();
                  builder.add("parent", String.valueOf(request.getParent()));
                  return builder.build();
                })
            .build();
    GrpcCallSettings<UpdateTemplateRequest, Template> updateTemplateTransportSettings =
        GrpcCallSettings.<UpdateTemplateRequest, Template>newBuilder()
            .setMethodDescriptor(updateTemplateMethodDescriptor)
            .setParamsExtractor(
                request -> {
                  RequestParamsBuilder builder = RequestParamsBuilder.create();
                  builder.add("template.name", String.valueOf(request.getTemplate().getName()));
                  return builder.build();
                })
            .build();
    GrpcCallSettings<DeleteTemplateRequest, Empty> deleteTemplateTransportSettings =
        GrpcCallSettings.<DeleteTemplateRequest, Empty>newBuilder()
            .setMethodDescriptor(deleteTemplateMethodDescriptor)
            .setParamsExtractor(
                request -> {
                  RequestParamsBuilder builder = RequestParamsBuilder.create();
                  builder.add("name", String.valueOf(request.getName()));
                  return builder.build();
                })
            .build();
    GrpcCallSettings<GetFloorSettingRequest, FloorSetting> getFloorSettingTransportSettings =
        GrpcCallSettings.<GetFloorSettingRequest, FloorSetting>newBuilder()
            .setMethodDescriptor(getFloorSettingMethodDescriptor)
            .setParamsExtractor(
                request -> {
                  RequestParamsBuilder builder = RequestParamsBuilder.create();
                  builder.add("name", String.valueOf(request.getName()));
                  return builder.build();
                })
            .build();
    GrpcCallSettings<UpdateFloorSettingRequest, FloorSetting> updateFloorSettingTransportSettings =
        GrpcCallSettings.<UpdateFloorSettingRequest, FloorSetting>newBuilder()
            .setMethodDescriptor(updateFloorSettingMethodDescriptor)
            .setParamsExtractor(
                request -> {
                  RequestParamsBuilder builder = RequestParamsBuilder.create();
                  builder.add(
                      "floor_setting.name", String.valueOf(request.getFloorSetting().getName()));
                  return builder.build();
                })
            .build();
    GrpcCallSettings<SanitizeUserPromptRequest, SanitizeUserPromptResponse>
        sanitizeUserPromptTransportSettings =
            GrpcCallSettings.<SanitizeUserPromptRequest, SanitizeUserPromptResponse>newBuilder()
                .setMethodDescriptor(sanitizeUserPromptMethodDescriptor)
                .setParamsExtractor(
                    request -> {
                      RequestParamsBuilder builder = RequestParamsBuilder.create();
                      builder.add("name", String.valueOf(request.getName()));
                      return builder.build();
                    })
                .build();
    GrpcCallSettings<SanitizeModelResponseRequest, SanitizeModelResponseResponse>
        sanitizeModelResponseTransportSettings =
            GrpcCallSettings
                .<SanitizeModelResponseRequest, SanitizeModelResponseResponse>newBuilder()
                .setMethodDescriptor(sanitizeModelResponseMethodDescriptor)
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

    this.listTemplatesCallable =
        callableFactory.createUnaryCallable(
            listTemplatesTransportSettings, settings.listTemplatesSettings(), clientContext);
    this.listTemplatesPagedCallable =
        callableFactory.createPagedCallable(
            listTemplatesTransportSettings, settings.listTemplatesSettings(), clientContext);
    this.getTemplateCallable =
        callableFactory.createUnaryCallable(
            getTemplateTransportSettings, settings.getTemplateSettings(), clientContext);
    this.createTemplateCallable =
        callableFactory.createUnaryCallable(
            createTemplateTransportSettings, settings.createTemplateSettings(), clientContext);
    this.updateTemplateCallable =
        callableFactory.createUnaryCallable(
            updateTemplateTransportSettings, settings.updateTemplateSettings(), clientContext);
    this.deleteTemplateCallable =
        callableFactory.createUnaryCallable(
            deleteTemplateTransportSettings, settings.deleteTemplateSettings(), clientContext);
    this.getFloorSettingCallable =
        callableFactory.createUnaryCallable(
            getFloorSettingTransportSettings, settings.getFloorSettingSettings(), clientContext);
    this.updateFloorSettingCallable =
        callableFactory.createUnaryCallable(
            updateFloorSettingTransportSettings,
            settings.updateFloorSettingSettings(),
            clientContext);
    this.sanitizeUserPromptCallable =
        callableFactory.createUnaryCallable(
            sanitizeUserPromptTransportSettings,
            settings.sanitizeUserPromptSettings(),
            clientContext);
    this.sanitizeModelResponseCallable =
        callableFactory.createUnaryCallable(
            sanitizeModelResponseTransportSettings,
            settings.sanitizeModelResponseSettings(),
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
  public UnaryCallable<ListTemplatesRequest, ListTemplatesResponse> listTemplatesCallable() {
    return listTemplatesCallable;
  }

  @Override
  public UnaryCallable<ListTemplatesRequest, ListTemplatesPagedResponse>
      listTemplatesPagedCallable() {
    return listTemplatesPagedCallable;
  }

  @Override
  public UnaryCallable<GetTemplateRequest, Template> getTemplateCallable() {
    return getTemplateCallable;
  }

  @Override
  public UnaryCallable<CreateTemplateRequest, Template> createTemplateCallable() {
    return createTemplateCallable;
  }

  @Override
  public UnaryCallable<UpdateTemplateRequest, Template> updateTemplateCallable() {
    return updateTemplateCallable;
  }

  @Override
  public UnaryCallable<DeleteTemplateRequest, Empty> deleteTemplateCallable() {
    return deleteTemplateCallable;
  }

  @Override
  public UnaryCallable<GetFloorSettingRequest, FloorSetting> getFloorSettingCallable() {
    return getFloorSettingCallable;
  }

  @Override
  public UnaryCallable<UpdateFloorSettingRequest, FloorSetting> updateFloorSettingCallable() {
    return updateFloorSettingCallable;
  }

  @Override
  public UnaryCallable<SanitizeUserPromptRequest, SanitizeUserPromptResponse>
      sanitizeUserPromptCallable() {
    return sanitizeUserPromptCallable;
  }

  @Override
  public UnaryCallable<SanitizeModelResponseRequest, SanitizeModelResponseResponse>
      sanitizeModelResponseCallable() {
    return sanitizeModelResponseCallable;
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
