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

package com.google.cloud.securityposture.v1.stub;

import static com.google.cloud.securityposture.v1.SecurityPostureClient.ListLocationsPagedResponse;
import static com.google.cloud.securityposture.v1.SecurityPostureClient.ListPostureDeploymentsPagedResponse;
import static com.google.cloud.securityposture.v1.SecurityPostureClient.ListPostureRevisionsPagedResponse;
import static com.google.cloud.securityposture.v1.SecurityPostureClient.ListPostureTemplatesPagedResponse;
import static com.google.cloud.securityposture.v1.SecurityPostureClient.ListPosturesPagedResponse;

import com.google.api.gax.core.BackgroundResource;
import com.google.api.gax.core.BackgroundResourceAggregation;
import com.google.api.gax.grpc.GrpcCallSettings;
import com.google.api.gax.grpc.GrpcStubCallableFactory;
import com.google.api.gax.rpc.ClientContext;
import com.google.api.gax.rpc.OperationCallable;
import com.google.api.gax.rpc.RequestParamsBuilder;
import com.google.api.gax.rpc.UnaryCallable;
import com.google.cloud.location.GetLocationRequest;
import com.google.cloud.location.ListLocationsRequest;
import com.google.cloud.location.ListLocationsResponse;
import com.google.cloud.location.Location;
import com.google.cloud.securityposture.v1.CreatePostureDeploymentRequest;
import com.google.cloud.securityposture.v1.CreatePostureRequest;
import com.google.cloud.securityposture.v1.DeletePostureDeploymentRequest;
import com.google.cloud.securityposture.v1.DeletePostureRequest;
import com.google.cloud.securityposture.v1.ExtractPostureRequest;
import com.google.cloud.securityposture.v1.GetPostureDeploymentRequest;
import com.google.cloud.securityposture.v1.GetPostureRequest;
import com.google.cloud.securityposture.v1.GetPostureTemplateRequest;
import com.google.cloud.securityposture.v1.ListPostureDeploymentsRequest;
import com.google.cloud.securityposture.v1.ListPostureDeploymentsResponse;
import com.google.cloud.securityposture.v1.ListPostureRevisionsRequest;
import com.google.cloud.securityposture.v1.ListPostureRevisionsResponse;
import com.google.cloud.securityposture.v1.ListPostureTemplatesRequest;
import com.google.cloud.securityposture.v1.ListPostureTemplatesResponse;
import com.google.cloud.securityposture.v1.ListPosturesRequest;
import com.google.cloud.securityposture.v1.ListPosturesResponse;
import com.google.cloud.securityposture.v1.OperationMetadata;
import com.google.cloud.securityposture.v1.Posture;
import com.google.cloud.securityposture.v1.PostureDeployment;
import com.google.cloud.securityposture.v1.PostureTemplate;
import com.google.cloud.securityposture.v1.UpdatePostureDeploymentRequest;
import com.google.cloud.securityposture.v1.UpdatePostureRequest;
import com.google.longrunning.Operation;
import com.google.longrunning.stub.GrpcOperationsStub;
import com.google.protobuf.Empty;
import io.grpc.MethodDescriptor;
import io.grpc.protobuf.ProtoUtils;
import java.io.IOException;
import java.util.concurrent.TimeUnit;
import javax.annotation.Generated;

// AUTO-GENERATED DOCUMENTATION AND CLASS.
/**
 * gRPC stub implementation for the SecurityPosture service API.
 *
 * <p>This class is for advanced usage and reflects the underlying API directly.
 */
@Generated("by gapic-generator-java")
public class GrpcSecurityPostureStub extends SecurityPostureStub {
  private static final MethodDescriptor<ListPosturesRequest, ListPosturesResponse>
      listPosturesMethodDescriptor =
          MethodDescriptor.<ListPosturesRequest, ListPosturesResponse>newBuilder()
              .setType(MethodDescriptor.MethodType.UNARY)
              .setFullMethodName("google.cloud.securityposture.v1.SecurityPosture/ListPostures")
              .setRequestMarshaller(ProtoUtils.marshaller(ListPosturesRequest.getDefaultInstance()))
              .setResponseMarshaller(
                  ProtoUtils.marshaller(ListPosturesResponse.getDefaultInstance()))
              .build();

  private static final MethodDescriptor<ListPostureRevisionsRequest, ListPostureRevisionsResponse>
      listPostureRevisionsMethodDescriptor =
          MethodDescriptor.<ListPostureRevisionsRequest, ListPostureRevisionsResponse>newBuilder()
              .setType(MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(
                  "google.cloud.securityposture.v1.SecurityPosture/ListPostureRevisions")
              .setRequestMarshaller(
                  ProtoUtils.marshaller(ListPostureRevisionsRequest.getDefaultInstance()))
              .setResponseMarshaller(
                  ProtoUtils.marshaller(ListPostureRevisionsResponse.getDefaultInstance()))
              .build();

  private static final MethodDescriptor<GetPostureRequest, Posture> getPostureMethodDescriptor =
      MethodDescriptor.<GetPostureRequest, Posture>newBuilder()
          .setType(MethodDescriptor.MethodType.UNARY)
          .setFullMethodName("google.cloud.securityposture.v1.SecurityPosture/GetPosture")
          .setRequestMarshaller(ProtoUtils.marshaller(GetPostureRequest.getDefaultInstance()))
          .setResponseMarshaller(ProtoUtils.marshaller(Posture.getDefaultInstance()))
          .build();

  private static final MethodDescriptor<CreatePostureRequest, Operation>
      createPostureMethodDescriptor =
          MethodDescriptor.<CreatePostureRequest, Operation>newBuilder()
              .setType(MethodDescriptor.MethodType.UNARY)
              .setFullMethodName("google.cloud.securityposture.v1.SecurityPosture/CreatePosture")
              .setRequestMarshaller(
                  ProtoUtils.marshaller(CreatePostureRequest.getDefaultInstance()))
              .setResponseMarshaller(ProtoUtils.marshaller(Operation.getDefaultInstance()))
              .build();

  private static final MethodDescriptor<UpdatePostureRequest, Operation>
      updatePostureMethodDescriptor =
          MethodDescriptor.<UpdatePostureRequest, Operation>newBuilder()
              .setType(MethodDescriptor.MethodType.UNARY)
              .setFullMethodName("google.cloud.securityposture.v1.SecurityPosture/UpdatePosture")
              .setRequestMarshaller(
                  ProtoUtils.marshaller(UpdatePostureRequest.getDefaultInstance()))
              .setResponseMarshaller(ProtoUtils.marshaller(Operation.getDefaultInstance()))
              .build();

  private static final MethodDescriptor<DeletePostureRequest, Operation>
      deletePostureMethodDescriptor =
          MethodDescriptor.<DeletePostureRequest, Operation>newBuilder()
              .setType(MethodDescriptor.MethodType.UNARY)
              .setFullMethodName("google.cloud.securityposture.v1.SecurityPosture/DeletePosture")
              .setRequestMarshaller(
                  ProtoUtils.marshaller(DeletePostureRequest.getDefaultInstance()))
              .setResponseMarshaller(ProtoUtils.marshaller(Operation.getDefaultInstance()))
              .build();

  private static final MethodDescriptor<ExtractPostureRequest, Operation>
      extractPostureMethodDescriptor =
          MethodDescriptor.<ExtractPostureRequest, Operation>newBuilder()
              .setType(MethodDescriptor.MethodType.UNARY)
              .setFullMethodName("google.cloud.securityposture.v1.SecurityPosture/ExtractPosture")
              .setRequestMarshaller(
                  ProtoUtils.marshaller(ExtractPostureRequest.getDefaultInstance()))
              .setResponseMarshaller(ProtoUtils.marshaller(Operation.getDefaultInstance()))
              .build();

  private static final MethodDescriptor<
          ListPostureDeploymentsRequest, ListPostureDeploymentsResponse>
      listPostureDeploymentsMethodDescriptor =
          MethodDescriptor
              .<ListPostureDeploymentsRequest, ListPostureDeploymentsResponse>newBuilder()
              .setType(MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(
                  "google.cloud.securityposture.v1.SecurityPosture/ListPostureDeployments")
              .setRequestMarshaller(
                  ProtoUtils.marshaller(ListPostureDeploymentsRequest.getDefaultInstance()))
              .setResponseMarshaller(
                  ProtoUtils.marshaller(ListPostureDeploymentsResponse.getDefaultInstance()))
              .build();

  private static final MethodDescriptor<GetPostureDeploymentRequest, PostureDeployment>
      getPostureDeploymentMethodDescriptor =
          MethodDescriptor.<GetPostureDeploymentRequest, PostureDeployment>newBuilder()
              .setType(MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(
                  "google.cloud.securityposture.v1.SecurityPosture/GetPostureDeployment")
              .setRequestMarshaller(
                  ProtoUtils.marshaller(GetPostureDeploymentRequest.getDefaultInstance()))
              .setResponseMarshaller(ProtoUtils.marshaller(PostureDeployment.getDefaultInstance()))
              .build();

  private static final MethodDescriptor<CreatePostureDeploymentRequest, Operation>
      createPostureDeploymentMethodDescriptor =
          MethodDescriptor.<CreatePostureDeploymentRequest, Operation>newBuilder()
              .setType(MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(
                  "google.cloud.securityposture.v1.SecurityPosture/CreatePostureDeployment")
              .setRequestMarshaller(
                  ProtoUtils.marshaller(CreatePostureDeploymentRequest.getDefaultInstance()))
              .setResponseMarshaller(ProtoUtils.marshaller(Operation.getDefaultInstance()))
              .build();

  private static final MethodDescriptor<UpdatePostureDeploymentRequest, Operation>
      updatePostureDeploymentMethodDescriptor =
          MethodDescriptor.<UpdatePostureDeploymentRequest, Operation>newBuilder()
              .setType(MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(
                  "google.cloud.securityposture.v1.SecurityPosture/UpdatePostureDeployment")
              .setRequestMarshaller(
                  ProtoUtils.marshaller(UpdatePostureDeploymentRequest.getDefaultInstance()))
              .setResponseMarshaller(ProtoUtils.marshaller(Operation.getDefaultInstance()))
              .build();

  private static final MethodDescriptor<DeletePostureDeploymentRequest, Operation>
      deletePostureDeploymentMethodDescriptor =
          MethodDescriptor.<DeletePostureDeploymentRequest, Operation>newBuilder()
              .setType(MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(
                  "google.cloud.securityposture.v1.SecurityPosture/DeletePostureDeployment")
              .setRequestMarshaller(
                  ProtoUtils.marshaller(DeletePostureDeploymentRequest.getDefaultInstance()))
              .setResponseMarshaller(ProtoUtils.marshaller(Operation.getDefaultInstance()))
              .build();

  private static final MethodDescriptor<ListPostureTemplatesRequest, ListPostureTemplatesResponse>
      listPostureTemplatesMethodDescriptor =
          MethodDescriptor.<ListPostureTemplatesRequest, ListPostureTemplatesResponse>newBuilder()
              .setType(MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(
                  "google.cloud.securityposture.v1.SecurityPosture/ListPostureTemplates")
              .setRequestMarshaller(
                  ProtoUtils.marshaller(ListPostureTemplatesRequest.getDefaultInstance()))
              .setResponseMarshaller(
                  ProtoUtils.marshaller(ListPostureTemplatesResponse.getDefaultInstance()))
              .build();

  private static final MethodDescriptor<GetPostureTemplateRequest, PostureTemplate>
      getPostureTemplateMethodDescriptor =
          MethodDescriptor.<GetPostureTemplateRequest, PostureTemplate>newBuilder()
              .setType(MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(
                  "google.cloud.securityposture.v1.SecurityPosture/GetPostureTemplate")
              .setRequestMarshaller(
                  ProtoUtils.marshaller(GetPostureTemplateRequest.getDefaultInstance()))
              .setResponseMarshaller(ProtoUtils.marshaller(PostureTemplate.getDefaultInstance()))
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

  private final UnaryCallable<ListPosturesRequest, ListPosturesResponse> listPosturesCallable;
  private final UnaryCallable<ListPosturesRequest, ListPosturesPagedResponse>
      listPosturesPagedCallable;
  private final UnaryCallable<ListPostureRevisionsRequest, ListPostureRevisionsResponse>
      listPostureRevisionsCallable;
  private final UnaryCallable<ListPostureRevisionsRequest, ListPostureRevisionsPagedResponse>
      listPostureRevisionsPagedCallable;
  private final UnaryCallable<GetPostureRequest, Posture> getPostureCallable;
  private final UnaryCallable<CreatePostureRequest, Operation> createPostureCallable;
  private final OperationCallable<CreatePostureRequest, Posture, OperationMetadata>
      createPostureOperationCallable;
  private final UnaryCallable<UpdatePostureRequest, Operation> updatePostureCallable;
  private final OperationCallable<UpdatePostureRequest, Posture, OperationMetadata>
      updatePostureOperationCallable;
  private final UnaryCallable<DeletePostureRequest, Operation> deletePostureCallable;
  private final OperationCallable<DeletePostureRequest, Empty, OperationMetadata>
      deletePostureOperationCallable;
  private final UnaryCallable<ExtractPostureRequest, Operation> extractPostureCallable;
  private final OperationCallable<ExtractPostureRequest, Posture, OperationMetadata>
      extractPostureOperationCallable;
  private final UnaryCallable<ListPostureDeploymentsRequest, ListPostureDeploymentsResponse>
      listPostureDeploymentsCallable;
  private final UnaryCallable<ListPostureDeploymentsRequest, ListPostureDeploymentsPagedResponse>
      listPostureDeploymentsPagedCallable;
  private final UnaryCallable<GetPostureDeploymentRequest, PostureDeployment>
      getPostureDeploymentCallable;
  private final UnaryCallable<CreatePostureDeploymentRequest, Operation>
      createPostureDeploymentCallable;
  private final OperationCallable<
          CreatePostureDeploymentRequest, PostureDeployment, OperationMetadata>
      createPostureDeploymentOperationCallable;
  private final UnaryCallable<UpdatePostureDeploymentRequest, Operation>
      updatePostureDeploymentCallable;
  private final OperationCallable<
          UpdatePostureDeploymentRequest, PostureDeployment, OperationMetadata>
      updatePostureDeploymentOperationCallable;
  private final UnaryCallable<DeletePostureDeploymentRequest, Operation>
      deletePostureDeploymentCallable;
  private final OperationCallable<DeletePostureDeploymentRequest, Empty, OperationMetadata>
      deletePostureDeploymentOperationCallable;
  private final UnaryCallable<ListPostureTemplatesRequest, ListPostureTemplatesResponse>
      listPostureTemplatesCallable;
  private final UnaryCallable<ListPostureTemplatesRequest, ListPostureTemplatesPagedResponse>
      listPostureTemplatesPagedCallable;
  private final UnaryCallable<GetPostureTemplateRequest, PostureTemplate>
      getPostureTemplateCallable;
  private final UnaryCallable<ListLocationsRequest, ListLocationsResponse> listLocationsCallable;
  private final UnaryCallable<ListLocationsRequest, ListLocationsPagedResponse>
      listLocationsPagedCallable;
  private final UnaryCallable<GetLocationRequest, Location> getLocationCallable;

  private final BackgroundResource backgroundResources;
  private final GrpcOperationsStub operationsStub;
  private final GrpcStubCallableFactory callableFactory;

  public static final GrpcSecurityPostureStub create(SecurityPostureStubSettings settings)
      throws IOException {
    return new GrpcSecurityPostureStub(settings, ClientContext.create(settings));
  }

  public static final GrpcSecurityPostureStub create(ClientContext clientContext)
      throws IOException {
    return new GrpcSecurityPostureStub(
        SecurityPostureStubSettings.newBuilder().build(), clientContext);
  }

  public static final GrpcSecurityPostureStub create(
      ClientContext clientContext, GrpcStubCallableFactory callableFactory) throws IOException {
    return new GrpcSecurityPostureStub(
        SecurityPostureStubSettings.newBuilder().build(), clientContext, callableFactory);
  }

  /**
   * Constructs an instance of GrpcSecurityPostureStub, using the given settings. This is protected
   * so that it is easy to make a subclass, but otherwise, the static factory methods should be
   * preferred.
   */
  protected GrpcSecurityPostureStub(
      SecurityPostureStubSettings settings, ClientContext clientContext) throws IOException {
    this(settings, clientContext, new GrpcSecurityPostureCallableFactory());
  }

  /**
   * Constructs an instance of GrpcSecurityPostureStub, using the given settings. This is protected
   * so that it is easy to make a subclass, but otherwise, the static factory methods should be
   * preferred.
   */
  protected GrpcSecurityPostureStub(
      SecurityPostureStubSettings settings,
      ClientContext clientContext,
      GrpcStubCallableFactory callableFactory)
      throws IOException {
    this.callableFactory = callableFactory;
    this.operationsStub = GrpcOperationsStub.create(clientContext, callableFactory);

    GrpcCallSettings<ListPosturesRequest, ListPosturesResponse> listPosturesTransportSettings =
        GrpcCallSettings.<ListPosturesRequest, ListPosturesResponse>newBuilder()
            .setMethodDescriptor(listPosturesMethodDescriptor)
            .setParamsExtractor(
                request -> {
                  RequestParamsBuilder builder = RequestParamsBuilder.create();
                  builder.add("parent", String.valueOf(request.getParent()));
                  return builder.build();
                })
            .build();
    GrpcCallSettings<ListPostureRevisionsRequest, ListPostureRevisionsResponse>
        listPostureRevisionsTransportSettings =
            GrpcCallSettings.<ListPostureRevisionsRequest, ListPostureRevisionsResponse>newBuilder()
                .setMethodDescriptor(listPostureRevisionsMethodDescriptor)
                .setParamsExtractor(
                    request -> {
                      RequestParamsBuilder builder = RequestParamsBuilder.create();
                      builder.add("name", String.valueOf(request.getName()));
                      return builder.build();
                    })
                .build();
    GrpcCallSettings<GetPostureRequest, Posture> getPostureTransportSettings =
        GrpcCallSettings.<GetPostureRequest, Posture>newBuilder()
            .setMethodDescriptor(getPostureMethodDescriptor)
            .setParamsExtractor(
                request -> {
                  RequestParamsBuilder builder = RequestParamsBuilder.create();
                  builder.add("name", String.valueOf(request.getName()));
                  return builder.build();
                })
            .build();
    GrpcCallSettings<CreatePostureRequest, Operation> createPostureTransportSettings =
        GrpcCallSettings.<CreatePostureRequest, Operation>newBuilder()
            .setMethodDescriptor(createPostureMethodDescriptor)
            .setParamsExtractor(
                request -> {
                  RequestParamsBuilder builder = RequestParamsBuilder.create();
                  builder.add("parent", String.valueOf(request.getParent()));
                  return builder.build();
                })
            .build();
    GrpcCallSettings<UpdatePostureRequest, Operation> updatePostureTransportSettings =
        GrpcCallSettings.<UpdatePostureRequest, Operation>newBuilder()
            .setMethodDescriptor(updatePostureMethodDescriptor)
            .setParamsExtractor(
                request -> {
                  RequestParamsBuilder builder = RequestParamsBuilder.create();
                  builder.add("posture.name", String.valueOf(request.getPosture().getName()));
                  return builder.build();
                })
            .build();
    GrpcCallSettings<DeletePostureRequest, Operation> deletePostureTransportSettings =
        GrpcCallSettings.<DeletePostureRequest, Operation>newBuilder()
            .setMethodDescriptor(deletePostureMethodDescriptor)
            .setParamsExtractor(
                request -> {
                  RequestParamsBuilder builder = RequestParamsBuilder.create();
                  builder.add("name", String.valueOf(request.getName()));
                  return builder.build();
                })
            .build();
    GrpcCallSettings<ExtractPostureRequest, Operation> extractPostureTransportSettings =
        GrpcCallSettings.<ExtractPostureRequest, Operation>newBuilder()
            .setMethodDescriptor(extractPostureMethodDescriptor)
            .setParamsExtractor(
                request -> {
                  RequestParamsBuilder builder = RequestParamsBuilder.create();
                  builder.add("parent", String.valueOf(request.getParent()));
                  return builder.build();
                })
            .build();
    GrpcCallSettings<ListPostureDeploymentsRequest, ListPostureDeploymentsResponse>
        listPostureDeploymentsTransportSettings =
            GrpcCallSettings
                .<ListPostureDeploymentsRequest, ListPostureDeploymentsResponse>newBuilder()
                .setMethodDescriptor(listPostureDeploymentsMethodDescriptor)
                .setParamsExtractor(
                    request -> {
                      RequestParamsBuilder builder = RequestParamsBuilder.create();
                      builder.add("parent", String.valueOf(request.getParent()));
                      return builder.build();
                    })
                .build();
    GrpcCallSettings<GetPostureDeploymentRequest, PostureDeployment>
        getPostureDeploymentTransportSettings =
            GrpcCallSettings.<GetPostureDeploymentRequest, PostureDeployment>newBuilder()
                .setMethodDescriptor(getPostureDeploymentMethodDescriptor)
                .setParamsExtractor(
                    request -> {
                      RequestParamsBuilder builder = RequestParamsBuilder.create();
                      builder.add("name", String.valueOf(request.getName()));
                      return builder.build();
                    })
                .build();
    GrpcCallSettings<CreatePostureDeploymentRequest, Operation>
        createPostureDeploymentTransportSettings =
            GrpcCallSettings.<CreatePostureDeploymentRequest, Operation>newBuilder()
                .setMethodDescriptor(createPostureDeploymentMethodDescriptor)
                .setParamsExtractor(
                    request -> {
                      RequestParamsBuilder builder = RequestParamsBuilder.create();
                      builder.add("parent", String.valueOf(request.getParent()));
                      return builder.build();
                    })
                .build();
    GrpcCallSettings<UpdatePostureDeploymentRequest, Operation>
        updatePostureDeploymentTransportSettings =
            GrpcCallSettings.<UpdatePostureDeploymentRequest, Operation>newBuilder()
                .setMethodDescriptor(updatePostureDeploymentMethodDescriptor)
                .setParamsExtractor(
                    request -> {
                      RequestParamsBuilder builder = RequestParamsBuilder.create();
                      builder.add(
                          "posture_deployment.name",
                          String.valueOf(request.getPostureDeployment().getName()));
                      return builder.build();
                    })
                .build();
    GrpcCallSettings<DeletePostureDeploymentRequest, Operation>
        deletePostureDeploymentTransportSettings =
            GrpcCallSettings.<DeletePostureDeploymentRequest, Operation>newBuilder()
                .setMethodDescriptor(deletePostureDeploymentMethodDescriptor)
                .setParamsExtractor(
                    request -> {
                      RequestParamsBuilder builder = RequestParamsBuilder.create();
                      builder.add("name", String.valueOf(request.getName()));
                      return builder.build();
                    })
                .build();
    GrpcCallSettings<ListPostureTemplatesRequest, ListPostureTemplatesResponse>
        listPostureTemplatesTransportSettings =
            GrpcCallSettings.<ListPostureTemplatesRequest, ListPostureTemplatesResponse>newBuilder()
                .setMethodDescriptor(listPostureTemplatesMethodDescriptor)
                .setParamsExtractor(
                    request -> {
                      RequestParamsBuilder builder = RequestParamsBuilder.create();
                      builder.add("parent", String.valueOf(request.getParent()));
                      return builder.build();
                    })
                .build();
    GrpcCallSettings<GetPostureTemplateRequest, PostureTemplate>
        getPostureTemplateTransportSettings =
            GrpcCallSettings.<GetPostureTemplateRequest, PostureTemplate>newBuilder()
                .setMethodDescriptor(getPostureTemplateMethodDescriptor)
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

    this.listPosturesCallable =
        callableFactory.createUnaryCallable(
            listPosturesTransportSettings, settings.listPosturesSettings(), clientContext);
    this.listPosturesPagedCallable =
        callableFactory.createPagedCallable(
            listPosturesTransportSettings, settings.listPosturesSettings(), clientContext);
    this.listPostureRevisionsCallable =
        callableFactory.createUnaryCallable(
            listPostureRevisionsTransportSettings,
            settings.listPostureRevisionsSettings(),
            clientContext);
    this.listPostureRevisionsPagedCallable =
        callableFactory.createPagedCallable(
            listPostureRevisionsTransportSettings,
            settings.listPostureRevisionsSettings(),
            clientContext);
    this.getPostureCallable =
        callableFactory.createUnaryCallable(
            getPostureTransportSettings, settings.getPostureSettings(), clientContext);
    this.createPostureCallable =
        callableFactory.createUnaryCallable(
            createPostureTransportSettings, settings.createPostureSettings(), clientContext);
    this.createPostureOperationCallable =
        callableFactory.createOperationCallable(
            createPostureTransportSettings,
            settings.createPostureOperationSettings(),
            clientContext,
            operationsStub);
    this.updatePostureCallable =
        callableFactory.createUnaryCallable(
            updatePostureTransportSettings, settings.updatePostureSettings(), clientContext);
    this.updatePostureOperationCallable =
        callableFactory.createOperationCallable(
            updatePostureTransportSettings,
            settings.updatePostureOperationSettings(),
            clientContext,
            operationsStub);
    this.deletePostureCallable =
        callableFactory.createUnaryCallable(
            deletePostureTransportSettings, settings.deletePostureSettings(), clientContext);
    this.deletePostureOperationCallable =
        callableFactory.createOperationCallable(
            deletePostureTransportSettings,
            settings.deletePostureOperationSettings(),
            clientContext,
            operationsStub);
    this.extractPostureCallable =
        callableFactory.createUnaryCallable(
            extractPostureTransportSettings, settings.extractPostureSettings(), clientContext);
    this.extractPostureOperationCallable =
        callableFactory.createOperationCallable(
            extractPostureTransportSettings,
            settings.extractPostureOperationSettings(),
            clientContext,
            operationsStub);
    this.listPostureDeploymentsCallable =
        callableFactory.createUnaryCallable(
            listPostureDeploymentsTransportSettings,
            settings.listPostureDeploymentsSettings(),
            clientContext);
    this.listPostureDeploymentsPagedCallable =
        callableFactory.createPagedCallable(
            listPostureDeploymentsTransportSettings,
            settings.listPostureDeploymentsSettings(),
            clientContext);
    this.getPostureDeploymentCallable =
        callableFactory.createUnaryCallable(
            getPostureDeploymentTransportSettings,
            settings.getPostureDeploymentSettings(),
            clientContext);
    this.createPostureDeploymentCallable =
        callableFactory.createUnaryCallable(
            createPostureDeploymentTransportSettings,
            settings.createPostureDeploymentSettings(),
            clientContext);
    this.createPostureDeploymentOperationCallable =
        callableFactory.createOperationCallable(
            createPostureDeploymentTransportSettings,
            settings.createPostureDeploymentOperationSettings(),
            clientContext,
            operationsStub);
    this.updatePostureDeploymentCallable =
        callableFactory.createUnaryCallable(
            updatePostureDeploymentTransportSettings,
            settings.updatePostureDeploymentSettings(),
            clientContext);
    this.updatePostureDeploymentOperationCallable =
        callableFactory.createOperationCallable(
            updatePostureDeploymentTransportSettings,
            settings.updatePostureDeploymentOperationSettings(),
            clientContext,
            operationsStub);
    this.deletePostureDeploymentCallable =
        callableFactory.createUnaryCallable(
            deletePostureDeploymentTransportSettings,
            settings.deletePostureDeploymentSettings(),
            clientContext);
    this.deletePostureDeploymentOperationCallable =
        callableFactory.createOperationCallable(
            deletePostureDeploymentTransportSettings,
            settings.deletePostureDeploymentOperationSettings(),
            clientContext,
            operationsStub);
    this.listPostureTemplatesCallable =
        callableFactory.createUnaryCallable(
            listPostureTemplatesTransportSettings,
            settings.listPostureTemplatesSettings(),
            clientContext);
    this.listPostureTemplatesPagedCallable =
        callableFactory.createPagedCallable(
            listPostureTemplatesTransportSettings,
            settings.listPostureTemplatesSettings(),
            clientContext);
    this.getPostureTemplateCallable =
        callableFactory.createUnaryCallable(
            getPostureTemplateTransportSettings,
            settings.getPostureTemplateSettings(),
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
  public UnaryCallable<ListPosturesRequest, ListPosturesResponse> listPosturesCallable() {
    return listPosturesCallable;
  }

  @Override
  public UnaryCallable<ListPosturesRequest, ListPosturesPagedResponse> listPosturesPagedCallable() {
    return listPosturesPagedCallable;
  }

  @Override
  public UnaryCallable<ListPostureRevisionsRequest, ListPostureRevisionsResponse>
      listPostureRevisionsCallable() {
    return listPostureRevisionsCallable;
  }

  @Override
  public UnaryCallable<ListPostureRevisionsRequest, ListPostureRevisionsPagedResponse>
      listPostureRevisionsPagedCallable() {
    return listPostureRevisionsPagedCallable;
  }

  @Override
  public UnaryCallable<GetPostureRequest, Posture> getPostureCallable() {
    return getPostureCallable;
  }

  @Override
  public UnaryCallable<CreatePostureRequest, Operation> createPostureCallable() {
    return createPostureCallable;
  }

  @Override
  public OperationCallable<CreatePostureRequest, Posture, OperationMetadata>
      createPostureOperationCallable() {
    return createPostureOperationCallable;
  }

  @Override
  public UnaryCallable<UpdatePostureRequest, Operation> updatePostureCallable() {
    return updatePostureCallable;
  }

  @Override
  public OperationCallable<UpdatePostureRequest, Posture, OperationMetadata>
      updatePostureOperationCallable() {
    return updatePostureOperationCallable;
  }

  @Override
  public UnaryCallable<DeletePostureRequest, Operation> deletePostureCallable() {
    return deletePostureCallable;
  }

  @Override
  public OperationCallable<DeletePostureRequest, Empty, OperationMetadata>
      deletePostureOperationCallable() {
    return deletePostureOperationCallable;
  }

  @Override
  public UnaryCallable<ExtractPostureRequest, Operation> extractPostureCallable() {
    return extractPostureCallable;
  }

  @Override
  public OperationCallable<ExtractPostureRequest, Posture, OperationMetadata>
      extractPostureOperationCallable() {
    return extractPostureOperationCallable;
  }

  @Override
  public UnaryCallable<ListPostureDeploymentsRequest, ListPostureDeploymentsResponse>
      listPostureDeploymentsCallable() {
    return listPostureDeploymentsCallable;
  }

  @Override
  public UnaryCallable<ListPostureDeploymentsRequest, ListPostureDeploymentsPagedResponse>
      listPostureDeploymentsPagedCallable() {
    return listPostureDeploymentsPagedCallable;
  }

  @Override
  public UnaryCallable<GetPostureDeploymentRequest, PostureDeployment>
      getPostureDeploymentCallable() {
    return getPostureDeploymentCallable;
  }

  @Override
  public UnaryCallable<CreatePostureDeploymentRequest, Operation>
      createPostureDeploymentCallable() {
    return createPostureDeploymentCallable;
  }

  @Override
  public OperationCallable<CreatePostureDeploymentRequest, PostureDeployment, OperationMetadata>
      createPostureDeploymentOperationCallable() {
    return createPostureDeploymentOperationCallable;
  }

  @Override
  public UnaryCallable<UpdatePostureDeploymentRequest, Operation>
      updatePostureDeploymentCallable() {
    return updatePostureDeploymentCallable;
  }

  @Override
  public OperationCallable<UpdatePostureDeploymentRequest, PostureDeployment, OperationMetadata>
      updatePostureDeploymentOperationCallable() {
    return updatePostureDeploymentOperationCallable;
  }

  @Override
  public UnaryCallable<DeletePostureDeploymentRequest, Operation>
      deletePostureDeploymentCallable() {
    return deletePostureDeploymentCallable;
  }

  @Override
  public OperationCallable<DeletePostureDeploymentRequest, Empty, OperationMetadata>
      deletePostureDeploymentOperationCallable() {
    return deletePostureDeploymentOperationCallable;
  }

  @Override
  public UnaryCallable<ListPostureTemplatesRequest, ListPostureTemplatesResponse>
      listPostureTemplatesCallable() {
    return listPostureTemplatesCallable;
  }

  @Override
  public UnaryCallable<ListPostureTemplatesRequest, ListPostureTemplatesPagedResponse>
      listPostureTemplatesPagedCallable() {
    return listPostureTemplatesPagedCallable;
  }

  @Override
  public UnaryCallable<GetPostureTemplateRequest, PostureTemplate> getPostureTemplateCallable() {
    return getPostureTemplateCallable;
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
