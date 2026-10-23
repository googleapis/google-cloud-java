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

package com.google.cloud.parametermanager.v1.stub;

import static com.google.cloud.parametermanager.v1.ParameterManagerClient.ListLocationsPagedResponse;
import static com.google.cloud.parametermanager.v1.ParameterManagerClient.ListParameterVersionsPagedResponse;
import static com.google.cloud.parametermanager.v1.ParameterManagerClient.ListParametersPagedResponse;
import static com.google.cloud.parametermanager.v1.ParameterManagerClient.ListTemplateVersionsPagedResponse;
import static com.google.cloud.parametermanager.v1.ParameterManagerClient.ListTemplatesPagedResponse;

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
import com.google.cloud.parametermanager.v1.CreateParameterRequest;
import com.google.cloud.parametermanager.v1.CreateParameterVersionRequest;
import com.google.cloud.parametermanager.v1.CreateTemplateRequest;
import com.google.cloud.parametermanager.v1.CreateTemplateVersionRequest;
import com.google.cloud.parametermanager.v1.DeleteParameterRequest;
import com.google.cloud.parametermanager.v1.DeleteParameterVersionRequest;
import com.google.cloud.parametermanager.v1.DeleteTemplateRequest;
import com.google.cloud.parametermanager.v1.DeleteTemplateVersionRequest;
import com.google.cloud.parametermanager.v1.GetParameterRequest;
import com.google.cloud.parametermanager.v1.GetParameterVersionRequest;
import com.google.cloud.parametermanager.v1.GetTemplateRequest;
import com.google.cloud.parametermanager.v1.GetTemplateVersionRequest;
import com.google.cloud.parametermanager.v1.ListParameterVersionsRequest;
import com.google.cloud.parametermanager.v1.ListParameterVersionsResponse;
import com.google.cloud.parametermanager.v1.ListParametersRequest;
import com.google.cloud.parametermanager.v1.ListParametersResponse;
import com.google.cloud.parametermanager.v1.ListTemplateVersionsRequest;
import com.google.cloud.parametermanager.v1.ListTemplateVersionsResponse;
import com.google.cloud.parametermanager.v1.ListTemplatesRequest;
import com.google.cloud.parametermanager.v1.ListTemplatesResponse;
import com.google.cloud.parametermanager.v1.Parameter;
import com.google.cloud.parametermanager.v1.ParameterVersion;
import com.google.cloud.parametermanager.v1.RenderParameterVersionRequest;
import com.google.cloud.parametermanager.v1.RenderParameterVersionResponse;
import com.google.cloud.parametermanager.v1.RenderTemplateVersionRequest;
import com.google.cloud.parametermanager.v1.RenderTemplateVersionResponse;
import com.google.cloud.parametermanager.v1.Template;
import com.google.cloud.parametermanager.v1.TemplateVersion;
import com.google.cloud.parametermanager.v1.UpdateParameterRequest;
import com.google.cloud.parametermanager.v1.UpdateParameterVersionRequest;
import com.google.cloud.parametermanager.v1.UpdateTemplateRequest;
import com.google.cloud.parametermanager.v1.UpdateTemplateVersionRequest;
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
 * gRPC stub implementation for the ParameterManager service API.
 *
 * <p>This class is for advanced usage and reflects the underlying API directly.
 */
@NullMarked
@Generated("by gapic-generator-java")
public class GrpcParameterManagerStub extends ParameterManagerStub {
  private static final MethodDescriptor<ListParametersRequest, ListParametersResponse>
      listParametersMethodDescriptor =
          MethodDescriptor.<ListParametersRequest, ListParametersResponse>newBuilder()
              .setType(MethodDescriptor.MethodType.UNARY)
              .setFullMethodName("google.cloud.parametermanager.v1.ParameterManager/ListParameters")
              .setRequestMarshaller(
                  ProtoUtils.marshaller(ListParametersRequest.getDefaultInstance()))
              .setResponseMarshaller(
                  ProtoUtils.marshaller(ListParametersResponse.getDefaultInstance()))
              .setSampledToLocalTracing(true)
              .build();

  private static final MethodDescriptor<GetParameterRequest, Parameter>
      getParameterMethodDescriptor =
          MethodDescriptor.<GetParameterRequest, Parameter>newBuilder()
              .setType(MethodDescriptor.MethodType.UNARY)
              .setFullMethodName("google.cloud.parametermanager.v1.ParameterManager/GetParameter")
              .setRequestMarshaller(ProtoUtils.marshaller(GetParameterRequest.getDefaultInstance()))
              .setResponseMarshaller(ProtoUtils.marshaller(Parameter.getDefaultInstance()))
              .setSampledToLocalTracing(true)
              .build();

  private static final MethodDescriptor<CreateParameterRequest, Parameter>
      createParameterMethodDescriptor =
          MethodDescriptor.<CreateParameterRequest, Parameter>newBuilder()
              .setType(MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(
                  "google.cloud.parametermanager.v1.ParameterManager/CreateParameter")
              .setRequestMarshaller(
                  ProtoUtils.marshaller(CreateParameterRequest.getDefaultInstance()))
              .setResponseMarshaller(ProtoUtils.marshaller(Parameter.getDefaultInstance()))
              .setSampledToLocalTracing(true)
              .build();

  private static final MethodDescriptor<UpdateParameterRequest, Parameter>
      updateParameterMethodDescriptor =
          MethodDescriptor.<UpdateParameterRequest, Parameter>newBuilder()
              .setType(MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(
                  "google.cloud.parametermanager.v1.ParameterManager/UpdateParameter")
              .setRequestMarshaller(
                  ProtoUtils.marshaller(UpdateParameterRequest.getDefaultInstance()))
              .setResponseMarshaller(ProtoUtils.marshaller(Parameter.getDefaultInstance()))
              .setSampledToLocalTracing(true)
              .build();

  private static final MethodDescriptor<DeleteParameterRequest, Empty>
      deleteParameterMethodDescriptor =
          MethodDescriptor.<DeleteParameterRequest, Empty>newBuilder()
              .setType(MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(
                  "google.cloud.parametermanager.v1.ParameterManager/DeleteParameter")
              .setRequestMarshaller(
                  ProtoUtils.marshaller(DeleteParameterRequest.getDefaultInstance()))
              .setResponseMarshaller(ProtoUtils.marshaller(Empty.getDefaultInstance()))
              .setSampledToLocalTracing(true)
              .build();

  private static final MethodDescriptor<ListParameterVersionsRequest, ListParameterVersionsResponse>
      listParameterVersionsMethodDescriptor =
          MethodDescriptor.<ListParameterVersionsRequest, ListParameterVersionsResponse>newBuilder()
              .setType(MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(
                  "google.cloud.parametermanager.v1.ParameterManager/ListParameterVersions")
              .setRequestMarshaller(
                  ProtoUtils.marshaller(ListParameterVersionsRequest.getDefaultInstance()))
              .setResponseMarshaller(
                  ProtoUtils.marshaller(ListParameterVersionsResponse.getDefaultInstance()))
              .setSampledToLocalTracing(true)
              .build();

  private static final MethodDescriptor<GetParameterVersionRequest, ParameterVersion>
      getParameterVersionMethodDescriptor =
          MethodDescriptor.<GetParameterVersionRequest, ParameterVersion>newBuilder()
              .setType(MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(
                  "google.cloud.parametermanager.v1.ParameterManager/GetParameterVersion")
              .setRequestMarshaller(
                  ProtoUtils.marshaller(GetParameterVersionRequest.getDefaultInstance()))
              .setResponseMarshaller(ProtoUtils.marshaller(ParameterVersion.getDefaultInstance()))
              .setSampledToLocalTracing(true)
              .build();

  private static final MethodDescriptor<
          RenderParameterVersionRequest, RenderParameterVersionResponse>
      renderParameterVersionMethodDescriptor =
          MethodDescriptor
              .<RenderParameterVersionRequest, RenderParameterVersionResponse>newBuilder()
              .setType(MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(
                  "google.cloud.parametermanager.v1.ParameterManager/RenderParameterVersion")
              .setRequestMarshaller(
                  ProtoUtils.marshaller(RenderParameterVersionRequest.getDefaultInstance()))
              .setResponseMarshaller(
                  ProtoUtils.marshaller(RenderParameterVersionResponse.getDefaultInstance()))
              .setSampledToLocalTracing(true)
              .build();

  private static final MethodDescriptor<CreateParameterVersionRequest, ParameterVersion>
      createParameterVersionMethodDescriptor =
          MethodDescriptor.<CreateParameterVersionRequest, ParameterVersion>newBuilder()
              .setType(MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(
                  "google.cloud.parametermanager.v1.ParameterManager/CreateParameterVersion")
              .setRequestMarshaller(
                  ProtoUtils.marshaller(CreateParameterVersionRequest.getDefaultInstance()))
              .setResponseMarshaller(ProtoUtils.marshaller(ParameterVersion.getDefaultInstance()))
              .setSampledToLocalTracing(true)
              .build();

  private static final MethodDescriptor<UpdateParameterVersionRequest, ParameterVersion>
      updateParameterVersionMethodDescriptor =
          MethodDescriptor.<UpdateParameterVersionRequest, ParameterVersion>newBuilder()
              .setType(MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(
                  "google.cloud.parametermanager.v1.ParameterManager/UpdateParameterVersion")
              .setRequestMarshaller(
                  ProtoUtils.marshaller(UpdateParameterVersionRequest.getDefaultInstance()))
              .setResponseMarshaller(ProtoUtils.marshaller(ParameterVersion.getDefaultInstance()))
              .setSampledToLocalTracing(true)
              .build();

  private static final MethodDescriptor<DeleteParameterVersionRequest, Empty>
      deleteParameterVersionMethodDescriptor =
          MethodDescriptor.<DeleteParameterVersionRequest, Empty>newBuilder()
              .setType(MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(
                  "google.cloud.parametermanager.v1.ParameterManager/DeleteParameterVersion")
              .setRequestMarshaller(
                  ProtoUtils.marshaller(DeleteParameterVersionRequest.getDefaultInstance()))
              .setResponseMarshaller(ProtoUtils.marshaller(Empty.getDefaultInstance()))
              .setSampledToLocalTracing(true)
              .build();

  private static final MethodDescriptor<ListTemplatesRequest, ListTemplatesResponse>
      listTemplatesMethodDescriptor =
          MethodDescriptor.<ListTemplatesRequest, ListTemplatesResponse>newBuilder()
              .setType(MethodDescriptor.MethodType.UNARY)
              .setFullMethodName("google.cloud.parametermanager.v1.ParameterManager/ListTemplates")
              .setRequestMarshaller(
                  ProtoUtils.marshaller(ListTemplatesRequest.getDefaultInstance()))
              .setResponseMarshaller(
                  ProtoUtils.marshaller(ListTemplatesResponse.getDefaultInstance()))
              .setSampledToLocalTracing(true)
              .build();

  private static final MethodDescriptor<GetTemplateRequest, Template> getTemplateMethodDescriptor =
      MethodDescriptor.<GetTemplateRequest, Template>newBuilder()
          .setType(MethodDescriptor.MethodType.UNARY)
          .setFullMethodName("google.cloud.parametermanager.v1.ParameterManager/GetTemplate")
          .setRequestMarshaller(ProtoUtils.marshaller(GetTemplateRequest.getDefaultInstance()))
          .setResponseMarshaller(ProtoUtils.marshaller(Template.getDefaultInstance()))
          .setSampledToLocalTracing(true)
          .build();

  private static final MethodDescriptor<CreateTemplateRequest, Template>
      createTemplateMethodDescriptor =
          MethodDescriptor.<CreateTemplateRequest, Template>newBuilder()
              .setType(MethodDescriptor.MethodType.UNARY)
              .setFullMethodName("google.cloud.parametermanager.v1.ParameterManager/CreateTemplate")
              .setRequestMarshaller(
                  ProtoUtils.marshaller(CreateTemplateRequest.getDefaultInstance()))
              .setResponseMarshaller(ProtoUtils.marshaller(Template.getDefaultInstance()))
              .setSampledToLocalTracing(true)
              .build();

  private static final MethodDescriptor<UpdateTemplateRequest, Template>
      updateTemplateMethodDescriptor =
          MethodDescriptor.<UpdateTemplateRequest, Template>newBuilder()
              .setType(MethodDescriptor.MethodType.UNARY)
              .setFullMethodName("google.cloud.parametermanager.v1.ParameterManager/UpdateTemplate")
              .setRequestMarshaller(
                  ProtoUtils.marshaller(UpdateTemplateRequest.getDefaultInstance()))
              .setResponseMarshaller(ProtoUtils.marshaller(Template.getDefaultInstance()))
              .setSampledToLocalTracing(true)
              .build();

  private static final MethodDescriptor<DeleteTemplateRequest, Empty>
      deleteTemplateMethodDescriptor =
          MethodDescriptor.<DeleteTemplateRequest, Empty>newBuilder()
              .setType(MethodDescriptor.MethodType.UNARY)
              .setFullMethodName("google.cloud.parametermanager.v1.ParameterManager/DeleteTemplate")
              .setRequestMarshaller(
                  ProtoUtils.marshaller(DeleteTemplateRequest.getDefaultInstance()))
              .setResponseMarshaller(ProtoUtils.marshaller(Empty.getDefaultInstance()))
              .setSampledToLocalTracing(true)
              .build();

  private static final MethodDescriptor<ListTemplateVersionsRequest, ListTemplateVersionsResponse>
      listTemplateVersionsMethodDescriptor =
          MethodDescriptor.<ListTemplateVersionsRequest, ListTemplateVersionsResponse>newBuilder()
              .setType(MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(
                  "google.cloud.parametermanager.v1.ParameterManager/ListTemplateVersions")
              .setRequestMarshaller(
                  ProtoUtils.marshaller(ListTemplateVersionsRequest.getDefaultInstance()))
              .setResponseMarshaller(
                  ProtoUtils.marshaller(ListTemplateVersionsResponse.getDefaultInstance()))
              .setSampledToLocalTracing(true)
              .build();

  private static final MethodDescriptor<GetTemplateVersionRequest, TemplateVersion>
      getTemplateVersionMethodDescriptor =
          MethodDescriptor.<GetTemplateVersionRequest, TemplateVersion>newBuilder()
              .setType(MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(
                  "google.cloud.parametermanager.v1.ParameterManager/GetTemplateVersion")
              .setRequestMarshaller(
                  ProtoUtils.marshaller(GetTemplateVersionRequest.getDefaultInstance()))
              .setResponseMarshaller(ProtoUtils.marshaller(TemplateVersion.getDefaultInstance()))
              .setSampledToLocalTracing(true)
              .build();

  private static final MethodDescriptor<CreateTemplateVersionRequest, TemplateVersion>
      createTemplateVersionMethodDescriptor =
          MethodDescriptor.<CreateTemplateVersionRequest, TemplateVersion>newBuilder()
              .setType(MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(
                  "google.cloud.parametermanager.v1.ParameterManager/CreateTemplateVersion")
              .setRequestMarshaller(
                  ProtoUtils.marshaller(CreateTemplateVersionRequest.getDefaultInstance()))
              .setResponseMarshaller(ProtoUtils.marshaller(TemplateVersion.getDefaultInstance()))
              .setSampledToLocalTracing(true)
              .build();

  private static final MethodDescriptor<UpdateTemplateVersionRequest, TemplateVersion>
      updateTemplateVersionMethodDescriptor =
          MethodDescriptor.<UpdateTemplateVersionRequest, TemplateVersion>newBuilder()
              .setType(MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(
                  "google.cloud.parametermanager.v1.ParameterManager/UpdateTemplateVersion")
              .setRequestMarshaller(
                  ProtoUtils.marshaller(UpdateTemplateVersionRequest.getDefaultInstance()))
              .setResponseMarshaller(ProtoUtils.marshaller(TemplateVersion.getDefaultInstance()))
              .setSampledToLocalTracing(true)
              .build();

  private static final MethodDescriptor<DeleteTemplateVersionRequest, Empty>
      deleteTemplateVersionMethodDescriptor =
          MethodDescriptor.<DeleteTemplateVersionRequest, Empty>newBuilder()
              .setType(MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(
                  "google.cloud.parametermanager.v1.ParameterManager/DeleteTemplateVersion")
              .setRequestMarshaller(
                  ProtoUtils.marshaller(DeleteTemplateVersionRequest.getDefaultInstance()))
              .setResponseMarshaller(ProtoUtils.marshaller(Empty.getDefaultInstance()))
              .setSampledToLocalTracing(true)
              .build();

  private static final MethodDescriptor<RenderTemplateVersionRequest, RenderTemplateVersionResponse>
      renderTemplateVersionMethodDescriptor =
          MethodDescriptor.<RenderTemplateVersionRequest, RenderTemplateVersionResponse>newBuilder()
              .setType(MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(
                  "google.cloud.parametermanager.v1.ParameterManager/RenderTemplateVersion")
              .setRequestMarshaller(
                  ProtoUtils.marshaller(RenderTemplateVersionRequest.getDefaultInstance()))
              .setResponseMarshaller(
                  ProtoUtils.marshaller(RenderTemplateVersionResponse.getDefaultInstance()))
              .setSampledToLocalTracing(true)
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
              .setSampledToLocalTracing(true)
              .build();

  private static final MethodDescriptor<GetLocationRequest, Location> getLocationMethodDescriptor =
      MethodDescriptor.<GetLocationRequest, Location>newBuilder()
          .setType(MethodDescriptor.MethodType.UNARY)
          .setFullMethodName("google.cloud.location.Locations/GetLocation")
          .setRequestMarshaller(ProtoUtils.marshaller(GetLocationRequest.getDefaultInstance()))
          .setResponseMarshaller(ProtoUtils.marshaller(Location.getDefaultInstance()))
          .setSampledToLocalTracing(true)
          .build();

  private final UnaryCallable<ListParametersRequest, ListParametersResponse> listParametersCallable;
  private final UnaryCallable<ListParametersRequest, ListParametersPagedResponse>
      listParametersPagedCallable;
  private final UnaryCallable<GetParameterRequest, Parameter> getParameterCallable;
  private final UnaryCallable<CreateParameterRequest, Parameter> createParameterCallable;
  private final UnaryCallable<UpdateParameterRequest, Parameter> updateParameterCallable;
  private final UnaryCallable<DeleteParameterRequest, Empty> deleteParameterCallable;
  private final UnaryCallable<ListParameterVersionsRequest, ListParameterVersionsResponse>
      listParameterVersionsCallable;
  private final UnaryCallable<ListParameterVersionsRequest, ListParameterVersionsPagedResponse>
      listParameterVersionsPagedCallable;
  private final UnaryCallable<GetParameterVersionRequest, ParameterVersion>
      getParameterVersionCallable;
  private final UnaryCallable<RenderParameterVersionRequest, RenderParameterVersionResponse>
      renderParameterVersionCallable;
  private final UnaryCallable<CreateParameterVersionRequest, ParameterVersion>
      createParameterVersionCallable;
  private final UnaryCallable<UpdateParameterVersionRequest, ParameterVersion>
      updateParameterVersionCallable;
  private final UnaryCallable<DeleteParameterVersionRequest, Empty> deleteParameterVersionCallable;
  private final UnaryCallable<ListTemplatesRequest, ListTemplatesResponse> listTemplatesCallable;
  private final UnaryCallable<ListTemplatesRequest, ListTemplatesPagedResponse>
      listTemplatesPagedCallable;
  private final UnaryCallable<GetTemplateRequest, Template> getTemplateCallable;
  private final UnaryCallable<CreateTemplateRequest, Template> createTemplateCallable;
  private final UnaryCallable<UpdateTemplateRequest, Template> updateTemplateCallable;
  private final UnaryCallable<DeleteTemplateRequest, Empty> deleteTemplateCallable;
  private final UnaryCallable<ListTemplateVersionsRequest, ListTemplateVersionsResponse>
      listTemplateVersionsCallable;
  private final UnaryCallable<ListTemplateVersionsRequest, ListTemplateVersionsPagedResponse>
      listTemplateVersionsPagedCallable;
  private final UnaryCallable<GetTemplateVersionRequest, TemplateVersion>
      getTemplateVersionCallable;
  private final UnaryCallable<CreateTemplateVersionRequest, TemplateVersion>
      createTemplateVersionCallable;
  private final UnaryCallable<UpdateTemplateVersionRequest, TemplateVersion>
      updateTemplateVersionCallable;
  private final UnaryCallable<DeleteTemplateVersionRequest, Empty> deleteTemplateVersionCallable;
  private final UnaryCallable<RenderTemplateVersionRequest, RenderTemplateVersionResponse>
      renderTemplateVersionCallable;
  private final UnaryCallable<ListLocationsRequest, ListLocationsResponse> listLocationsCallable;
  private final UnaryCallable<ListLocationsRequest, ListLocationsPagedResponse>
      listLocationsPagedCallable;
  private final UnaryCallable<GetLocationRequest, Location> getLocationCallable;

  private final BackgroundResource backgroundResources;
  private final GrpcOperationsStub operationsStub;
  private final GrpcStubCallableFactory callableFactory;

  public static final GrpcParameterManagerStub create(ParameterManagerStubSettings settings)
      throws IOException {
    return new GrpcParameterManagerStub(settings, ClientContext.create(settings));
  }

  public static final GrpcParameterManagerStub create(ClientContext clientContext)
      throws IOException {
    return new GrpcParameterManagerStub(
        ParameterManagerStubSettings.newBuilder().build(), clientContext);
  }

  public static final GrpcParameterManagerStub create(
      ClientContext clientContext, GrpcStubCallableFactory callableFactory) throws IOException {
    return new GrpcParameterManagerStub(
        ParameterManagerStubSettings.newBuilder().build(), clientContext, callableFactory);
  }

  /**
   * Constructs an instance of GrpcParameterManagerStub, using the given settings. This is protected
   * so that it is easy to make a subclass, but otherwise, the static factory methods should be
   * preferred.
   */
  protected GrpcParameterManagerStub(
      ParameterManagerStubSettings settings, ClientContext clientContext) throws IOException {
    this(settings, clientContext, new GrpcParameterManagerCallableFactory());
  }

  /**
   * Constructs an instance of GrpcParameterManagerStub, using the given settings. This is protected
   * so that it is easy to make a subclass, but otherwise, the static factory methods should be
   * preferred.
   */
  protected GrpcParameterManagerStub(
      ParameterManagerStubSettings settings,
      ClientContext clientContext,
      GrpcStubCallableFactory callableFactory)
      throws IOException {
    this.callableFactory = callableFactory;
    this.operationsStub = GrpcOperationsStub.create(clientContext, callableFactory);

    GrpcCallSettings<ListParametersRequest, ListParametersResponse>
        listParametersTransportSettings =
            GrpcCallSettings.<ListParametersRequest, ListParametersResponse>newBuilder()
                .setMethodDescriptor(listParametersMethodDescriptor)
                .setParamsExtractor(
                    request -> {
                      RequestParamsBuilder builder = RequestParamsBuilder.create();
                      builder.add("parent", String.valueOf(request.getParent()));
                      return builder.build();
                    })
                .setResourceNameExtractor(request -> request.getParent())
                .build();
    GrpcCallSettings<GetParameterRequest, Parameter> getParameterTransportSettings =
        GrpcCallSettings.<GetParameterRequest, Parameter>newBuilder()
            .setMethodDescriptor(getParameterMethodDescriptor)
            .setParamsExtractor(
                request -> {
                  RequestParamsBuilder builder = RequestParamsBuilder.create();
                  builder.add("name", String.valueOf(request.getName()));
                  return builder.build();
                })
            .setResourceNameExtractor(request -> request.getName())
            .build();
    GrpcCallSettings<CreateParameterRequest, Parameter> createParameterTransportSettings =
        GrpcCallSettings.<CreateParameterRequest, Parameter>newBuilder()
            .setMethodDescriptor(createParameterMethodDescriptor)
            .setParamsExtractor(
                request -> {
                  RequestParamsBuilder builder = RequestParamsBuilder.create();
                  builder.add("parent", String.valueOf(request.getParent()));
                  return builder.build();
                })
            .setResourceNameExtractor(request -> request.getParent())
            .build();
    GrpcCallSettings<UpdateParameterRequest, Parameter> updateParameterTransportSettings =
        GrpcCallSettings.<UpdateParameterRequest, Parameter>newBuilder()
            .setMethodDescriptor(updateParameterMethodDescriptor)
            .setParamsExtractor(
                request -> {
                  RequestParamsBuilder builder = RequestParamsBuilder.create();
                  builder.add("parameter.name", String.valueOf(request.getParameter().getName()));
                  return builder.build();
                })
            .build();
    GrpcCallSettings<DeleteParameterRequest, Empty> deleteParameterTransportSettings =
        GrpcCallSettings.<DeleteParameterRequest, Empty>newBuilder()
            .setMethodDescriptor(deleteParameterMethodDescriptor)
            .setParamsExtractor(
                request -> {
                  RequestParamsBuilder builder = RequestParamsBuilder.create();
                  builder.add("name", String.valueOf(request.getName()));
                  return builder.build();
                })
            .setResourceNameExtractor(request -> request.getName())
            .build();
    GrpcCallSettings<ListParameterVersionsRequest, ListParameterVersionsResponse>
        listParameterVersionsTransportSettings =
            GrpcCallSettings
                .<ListParameterVersionsRequest, ListParameterVersionsResponse>newBuilder()
                .setMethodDescriptor(listParameterVersionsMethodDescriptor)
                .setParamsExtractor(
                    request -> {
                      RequestParamsBuilder builder = RequestParamsBuilder.create();
                      builder.add("parent", String.valueOf(request.getParent()));
                      return builder.build();
                    })
                .setResourceNameExtractor(request -> request.getParent())
                .build();
    GrpcCallSettings<GetParameterVersionRequest, ParameterVersion>
        getParameterVersionTransportSettings =
            GrpcCallSettings.<GetParameterVersionRequest, ParameterVersion>newBuilder()
                .setMethodDescriptor(getParameterVersionMethodDescriptor)
                .setParamsExtractor(
                    request -> {
                      RequestParamsBuilder builder = RequestParamsBuilder.create();
                      builder.add("name", String.valueOf(request.getName()));
                      return builder.build();
                    })
                .setResourceNameExtractor(request -> request.getName())
                .build();
    GrpcCallSettings<RenderParameterVersionRequest, RenderParameterVersionResponse>
        renderParameterVersionTransportSettings =
            GrpcCallSettings
                .<RenderParameterVersionRequest, RenderParameterVersionResponse>newBuilder()
                .setMethodDescriptor(renderParameterVersionMethodDescriptor)
                .setParamsExtractor(
                    request -> {
                      RequestParamsBuilder builder = RequestParamsBuilder.create();
                      builder.add("name", String.valueOf(request.getName()));
                      return builder.build();
                    })
                .setResourceNameExtractor(request -> request.getName())
                .build();
    GrpcCallSettings<CreateParameterVersionRequest, ParameterVersion>
        createParameterVersionTransportSettings =
            GrpcCallSettings.<CreateParameterVersionRequest, ParameterVersion>newBuilder()
                .setMethodDescriptor(createParameterVersionMethodDescriptor)
                .setParamsExtractor(
                    request -> {
                      RequestParamsBuilder builder = RequestParamsBuilder.create();
                      builder.add("parent", String.valueOf(request.getParent()));
                      return builder.build();
                    })
                .setResourceNameExtractor(request -> request.getParent())
                .build();
    GrpcCallSettings<UpdateParameterVersionRequest, ParameterVersion>
        updateParameterVersionTransportSettings =
            GrpcCallSettings.<UpdateParameterVersionRequest, ParameterVersion>newBuilder()
                .setMethodDescriptor(updateParameterVersionMethodDescriptor)
                .setParamsExtractor(
                    request -> {
                      RequestParamsBuilder builder = RequestParamsBuilder.create();
                      builder.add(
                          "parameter_version.name",
                          String.valueOf(request.getParameterVersion().getName()));
                      return builder.build();
                    })
                .build();
    GrpcCallSettings<DeleteParameterVersionRequest, Empty> deleteParameterVersionTransportSettings =
        GrpcCallSettings.<DeleteParameterVersionRequest, Empty>newBuilder()
            .setMethodDescriptor(deleteParameterVersionMethodDescriptor)
            .setParamsExtractor(
                request -> {
                  RequestParamsBuilder builder = RequestParamsBuilder.create();
                  builder.add("name", String.valueOf(request.getName()));
                  return builder.build();
                })
            .setResourceNameExtractor(request -> request.getName())
            .build();
    GrpcCallSettings<ListTemplatesRequest, ListTemplatesResponse> listTemplatesTransportSettings =
        GrpcCallSettings.<ListTemplatesRequest, ListTemplatesResponse>newBuilder()
            .setMethodDescriptor(listTemplatesMethodDescriptor)
            .setParamsExtractor(
                request -> {
                  RequestParamsBuilder builder = RequestParamsBuilder.create();
                  builder.add("parent", String.valueOf(request.getParent()));
                  return builder.build();
                })
            .setResourceNameExtractor(request -> request.getParent())
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
            .setResourceNameExtractor(request -> request.getName())
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
            .setResourceNameExtractor(request -> request.getParent())
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
            .setResourceNameExtractor(request -> request.getName())
            .build();
    GrpcCallSettings<ListTemplateVersionsRequest, ListTemplateVersionsResponse>
        listTemplateVersionsTransportSettings =
            GrpcCallSettings.<ListTemplateVersionsRequest, ListTemplateVersionsResponse>newBuilder()
                .setMethodDescriptor(listTemplateVersionsMethodDescriptor)
                .setParamsExtractor(
                    request -> {
                      RequestParamsBuilder builder = RequestParamsBuilder.create();
                      builder.add("parent", String.valueOf(request.getParent()));
                      return builder.build();
                    })
                .setResourceNameExtractor(request -> request.getParent())
                .build();
    GrpcCallSettings<GetTemplateVersionRequest, TemplateVersion>
        getTemplateVersionTransportSettings =
            GrpcCallSettings.<GetTemplateVersionRequest, TemplateVersion>newBuilder()
                .setMethodDescriptor(getTemplateVersionMethodDescriptor)
                .setParamsExtractor(
                    request -> {
                      RequestParamsBuilder builder = RequestParamsBuilder.create();
                      builder.add("name", String.valueOf(request.getName()));
                      return builder.build();
                    })
                .setResourceNameExtractor(request -> request.getName())
                .build();
    GrpcCallSettings<CreateTemplateVersionRequest, TemplateVersion>
        createTemplateVersionTransportSettings =
            GrpcCallSettings.<CreateTemplateVersionRequest, TemplateVersion>newBuilder()
                .setMethodDescriptor(createTemplateVersionMethodDescriptor)
                .setParamsExtractor(
                    request -> {
                      RequestParamsBuilder builder = RequestParamsBuilder.create();
                      builder.add("parent", String.valueOf(request.getParent()));
                      return builder.build();
                    })
                .setResourceNameExtractor(request -> request.getParent())
                .build();
    GrpcCallSettings<UpdateTemplateVersionRequest, TemplateVersion>
        updateTemplateVersionTransportSettings =
            GrpcCallSettings.<UpdateTemplateVersionRequest, TemplateVersion>newBuilder()
                .setMethodDescriptor(updateTemplateVersionMethodDescriptor)
                .setParamsExtractor(
                    request -> {
                      RequestParamsBuilder builder = RequestParamsBuilder.create();
                      builder.add(
                          "template_version.name",
                          String.valueOf(request.getTemplateVersion().getName()));
                      return builder.build();
                    })
                .build();
    GrpcCallSettings<DeleteTemplateVersionRequest, Empty> deleteTemplateVersionTransportSettings =
        GrpcCallSettings.<DeleteTemplateVersionRequest, Empty>newBuilder()
            .setMethodDescriptor(deleteTemplateVersionMethodDescriptor)
            .setParamsExtractor(
                request -> {
                  RequestParamsBuilder builder = RequestParamsBuilder.create();
                  builder.add("name", String.valueOf(request.getName()));
                  return builder.build();
                })
            .setResourceNameExtractor(request -> request.getName())
            .build();
    GrpcCallSettings<RenderTemplateVersionRequest, RenderTemplateVersionResponse>
        renderTemplateVersionTransportSettings =
            GrpcCallSettings
                .<RenderTemplateVersionRequest, RenderTemplateVersionResponse>newBuilder()
                .setMethodDescriptor(renderTemplateVersionMethodDescriptor)
                .setParamsExtractor(
                    request -> {
                      RequestParamsBuilder builder = RequestParamsBuilder.create();
                      builder.add("name", String.valueOf(request.getName()));
                      return builder.build();
                    })
                .setResourceNameExtractor(request -> request.getName())
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

    this.listParametersCallable =
        callableFactory.createUnaryCallable(
            listParametersTransportSettings, settings.listParametersSettings(), clientContext);
    this.listParametersPagedCallable =
        callableFactory.createPagedCallable(
            listParametersTransportSettings, settings.listParametersSettings(), clientContext);
    this.getParameterCallable =
        callableFactory.createUnaryCallable(
            getParameterTransportSettings, settings.getParameterSettings(), clientContext);
    this.createParameterCallable =
        callableFactory.createUnaryCallable(
            createParameterTransportSettings, settings.createParameterSettings(), clientContext);
    this.updateParameterCallable =
        callableFactory.createUnaryCallable(
            updateParameterTransportSettings, settings.updateParameterSettings(), clientContext);
    this.deleteParameterCallable =
        callableFactory.createUnaryCallable(
            deleteParameterTransportSettings, settings.deleteParameterSettings(), clientContext);
    this.listParameterVersionsCallable =
        callableFactory.createUnaryCallable(
            listParameterVersionsTransportSettings,
            settings.listParameterVersionsSettings(),
            clientContext);
    this.listParameterVersionsPagedCallable =
        callableFactory.createPagedCallable(
            listParameterVersionsTransportSettings,
            settings.listParameterVersionsSettings(),
            clientContext);
    this.getParameterVersionCallable =
        callableFactory.createUnaryCallable(
            getParameterVersionTransportSettings,
            settings.getParameterVersionSettings(),
            clientContext);
    this.renderParameterVersionCallable =
        callableFactory.createUnaryCallable(
            renderParameterVersionTransportSettings,
            settings.renderParameterVersionSettings(),
            clientContext);
    this.createParameterVersionCallable =
        callableFactory.createUnaryCallable(
            createParameterVersionTransportSettings,
            settings.createParameterVersionSettings(),
            clientContext);
    this.updateParameterVersionCallable =
        callableFactory.createUnaryCallable(
            updateParameterVersionTransportSettings,
            settings.updateParameterVersionSettings(),
            clientContext);
    this.deleteParameterVersionCallable =
        callableFactory.createUnaryCallable(
            deleteParameterVersionTransportSettings,
            settings.deleteParameterVersionSettings(),
            clientContext);
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
    this.listTemplateVersionsCallable =
        callableFactory.createUnaryCallable(
            listTemplateVersionsTransportSettings,
            settings.listTemplateVersionsSettings(),
            clientContext);
    this.listTemplateVersionsPagedCallable =
        callableFactory.createPagedCallable(
            listTemplateVersionsTransportSettings,
            settings.listTemplateVersionsSettings(),
            clientContext);
    this.getTemplateVersionCallable =
        callableFactory.createUnaryCallable(
            getTemplateVersionTransportSettings,
            settings.getTemplateVersionSettings(),
            clientContext);
    this.createTemplateVersionCallable =
        callableFactory.createUnaryCallable(
            createTemplateVersionTransportSettings,
            settings.createTemplateVersionSettings(),
            clientContext);
    this.updateTemplateVersionCallable =
        callableFactory.createUnaryCallable(
            updateTemplateVersionTransportSettings,
            settings.updateTemplateVersionSettings(),
            clientContext);
    this.deleteTemplateVersionCallable =
        callableFactory.createUnaryCallable(
            deleteTemplateVersionTransportSettings,
            settings.deleteTemplateVersionSettings(),
            clientContext);
    this.renderTemplateVersionCallable =
        callableFactory.createUnaryCallable(
            renderTemplateVersionTransportSettings,
            settings.renderTemplateVersionSettings(),
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
  public UnaryCallable<ListParametersRequest, ListParametersResponse> listParametersCallable() {
    return listParametersCallable;
  }

  @Override
  public UnaryCallable<ListParametersRequest, ListParametersPagedResponse>
      listParametersPagedCallable() {
    return listParametersPagedCallable;
  }

  @Override
  public UnaryCallable<GetParameterRequest, Parameter> getParameterCallable() {
    return getParameterCallable;
  }

  @Override
  public UnaryCallable<CreateParameterRequest, Parameter> createParameterCallable() {
    return createParameterCallable;
  }

  @Override
  public UnaryCallable<UpdateParameterRequest, Parameter> updateParameterCallable() {
    return updateParameterCallable;
  }

  @Override
  public UnaryCallable<DeleteParameterRequest, Empty> deleteParameterCallable() {
    return deleteParameterCallable;
  }

  @Override
  public UnaryCallable<ListParameterVersionsRequest, ListParameterVersionsResponse>
      listParameterVersionsCallable() {
    return listParameterVersionsCallable;
  }

  @Override
  public UnaryCallable<ListParameterVersionsRequest, ListParameterVersionsPagedResponse>
      listParameterVersionsPagedCallable() {
    return listParameterVersionsPagedCallable;
  }

  @Override
  public UnaryCallable<GetParameterVersionRequest, ParameterVersion> getParameterVersionCallable() {
    return getParameterVersionCallable;
  }

  @Override
  public UnaryCallable<RenderParameterVersionRequest, RenderParameterVersionResponse>
      renderParameterVersionCallable() {
    return renderParameterVersionCallable;
  }

  @Override
  public UnaryCallable<CreateParameterVersionRequest, ParameterVersion>
      createParameterVersionCallable() {
    return createParameterVersionCallable;
  }

  @Override
  public UnaryCallable<UpdateParameterVersionRequest, ParameterVersion>
      updateParameterVersionCallable() {
    return updateParameterVersionCallable;
  }

  @Override
  public UnaryCallable<DeleteParameterVersionRequest, Empty> deleteParameterVersionCallable() {
    return deleteParameterVersionCallable;
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
  public UnaryCallable<ListTemplateVersionsRequest, ListTemplateVersionsResponse>
      listTemplateVersionsCallable() {
    return listTemplateVersionsCallable;
  }

  @Override
  public UnaryCallable<ListTemplateVersionsRequest, ListTemplateVersionsPagedResponse>
      listTemplateVersionsPagedCallable() {
    return listTemplateVersionsPagedCallable;
  }

  @Override
  public UnaryCallable<GetTemplateVersionRequest, TemplateVersion> getTemplateVersionCallable() {
    return getTemplateVersionCallable;
  }

  @Override
  public UnaryCallable<CreateTemplateVersionRequest, TemplateVersion>
      createTemplateVersionCallable() {
    return createTemplateVersionCallable;
  }

  @Override
  public UnaryCallable<UpdateTemplateVersionRequest, TemplateVersion>
      updateTemplateVersionCallable() {
    return updateTemplateVersionCallable;
  }

  @Override
  public UnaryCallable<DeleteTemplateVersionRequest, Empty> deleteTemplateVersionCallable() {
    return deleteTemplateVersionCallable;
  }

  @Override
  public UnaryCallable<RenderTemplateVersionRequest, RenderTemplateVersionResponse>
      renderTemplateVersionCallable() {
    return renderTemplateVersionCallable;
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
