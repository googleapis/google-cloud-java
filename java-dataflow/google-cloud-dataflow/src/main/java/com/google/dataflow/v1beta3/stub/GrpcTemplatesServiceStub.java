/*
 * Copyright 2022 Google LLC
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

package com.google.dataflow.v1beta3.stub;

import com.google.api.core.BetaApi;
import com.google.api.gax.core.BackgroundResource;
import com.google.api.gax.core.BackgroundResourceAggregation;
import com.google.api.gax.grpc.GrpcCallSettings;
import com.google.api.gax.grpc.GrpcStubCallableFactory;
import com.google.api.gax.rpc.ClientContext;
import com.google.api.gax.rpc.UnaryCallable;
import com.google.common.collect.ImmutableMap;
import com.google.dataflow.v1beta3.CreateJobFromTemplateRequest;
import com.google.dataflow.v1beta3.GetTemplateRequest;
import com.google.dataflow.v1beta3.GetTemplateResponse;
import com.google.dataflow.v1beta3.Job;
import com.google.dataflow.v1beta3.LaunchTemplateRequest;
import com.google.dataflow.v1beta3.LaunchTemplateResponse;
import com.google.longrunning.stub.GrpcOperationsStub;
import io.grpc.MethodDescriptor;
import io.grpc.protobuf.ProtoUtils;
import java.io.IOException;
import java.util.concurrent.TimeUnit;
import javax.annotation.Generated;

// AUTO-GENERATED DOCUMENTATION AND CLASS.
/**
 * gRPC stub implementation for the TemplatesService service API.
 *
 * <p>This class is for advanced usage and reflects the underlying API directly.
 */
@BetaApi
@Generated("by gapic-generator-java")
public class GrpcTemplatesServiceStub extends TemplatesServiceStub {
  private static final MethodDescriptor<CreateJobFromTemplateRequest, Job>
      createJobFromTemplateMethodDescriptor =
          MethodDescriptor.<CreateJobFromTemplateRequest, Job>newBuilder()
              .setType(MethodDescriptor.MethodType.UNARY)
              .setFullMethodName("google.dataflow.v1beta3.TemplatesService/CreateJobFromTemplate")
              .setRequestMarshaller(
                  ProtoUtils.marshaller(CreateJobFromTemplateRequest.getDefaultInstance()))
              .setResponseMarshaller(ProtoUtils.marshaller(Job.getDefaultInstance()))
              .build();

  private static final MethodDescriptor<LaunchTemplateRequest, LaunchTemplateResponse>
      launchTemplateMethodDescriptor =
          MethodDescriptor.<LaunchTemplateRequest, LaunchTemplateResponse>newBuilder()
              .setType(MethodDescriptor.MethodType.UNARY)
              .setFullMethodName("google.dataflow.v1beta3.TemplatesService/LaunchTemplate")
              .setRequestMarshaller(
                  ProtoUtils.marshaller(LaunchTemplateRequest.getDefaultInstance()))
              .setResponseMarshaller(
                  ProtoUtils.marshaller(LaunchTemplateResponse.getDefaultInstance()))
              .build();

  private static final MethodDescriptor<GetTemplateRequest, GetTemplateResponse>
      getTemplateMethodDescriptor =
          MethodDescriptor.<GetTemplateRequest, GetTemplateResponse>newBuilder()
              .setType(MethodDescriptor.MethodType.UNARY)
              .setFullMethodName("google.dataflow.v1beta3.TemplatesService/GetTemplate")
              .setRequestMarshaller(ProtoUtils.marshaller(GetTemplateRequest.getDefaultInstance()))
              .setResponseMarshaller(
                  ProtoUtils.marshaller(GetTemplateResponse.getDefaultInstance()))
              .build();

  private final UnaryCallable<CreateJobFromTemplateRequest, Job> createJobFromTemplateCallable;
  private final UnaryCallable<LaunchTemplateRequest, LaunchTemplateResponse> launchTemplateCallable;
  private final UnaryCallable<GetTemplateRequest, GetTemplateResponse> getTemplateCallable;

  private final BackgroundResource backgroundResources;
  private final GrpcOperationsStub operationsStub;
  private final GrpcStubCallableFactory callableFactory;

  public static final GrpcTemplatesServiceStub create(TemplatesServiceStubSettings settings)
      throws IOException {
    return new GrpcTemplatesServiceStub(settings, ClientContext.create(settings));
  }

  public static final GrpcTemplatesServiceStub create(ClientContext clientContext)
      throws IOException {
    return new GrpcTemplatesServiceStub(
        TemplatesServiceStubSettings.newBuilder().build(), clientContext);
  }

  public static final GrpcTemplatesServiceStub create(
      ClientContext clientContext, GrpcStubCallableFactory callableFactory) throws IOException {
    return new GrpcTemplatesServiceStub(
        TemplatesServiceStubSettings.newBuilder().build(), clientContext, callableFactory);
  }

  /**
   * Constructs an instance of GrpcTemplatesServiceStub, using the given settings. This is protected
   * so that it is easy to make a subclass, but otherwise, the static factory methods should be
   * preferred.
   */
  protected GrpcTemplatesServiceStub(
      TemplatesServiceStubSettings settings, ClientContext clientContext) throws IOException {
    this(settings, clientContext, new GrpcTemplatesServiceCallableFactory());
  }

  /**
   * Constructs an instance of GrpcTemplatesServiceStub, using the given settings. This is protected
   * so that it is easy to make a subclass, but otherwise, the static factory methods should be
   * preferred.
   */
  protected GrpcTemplatesServiceStub(
      TemplatesServiceStubSettings settings,
      ClientContext clientContext,
      GrpcStubCallableFactory callableFactory)
      throws IOException {
    this.callableFactory = callableFactory;
    this.operationsStub = GrpcOperationsStub.create(clientContext, callableFactory);

    GrpcCallSettings<CreateJobFromTemplateRequest, Job> createJobFromTemplateTransportSettings =
        GrpcCallSettings.<CreateJobFromTemplateRequest, Job>newBuilder()
            .setMethodDescriptor(createJobFromTemplateMethodDescriptor)
            .setParamsExtractor(
                request -> {
                  ImmutableMap.Builder<String, String> params = ImmutableMap.builder();
                  params.put("location", String.valueOf(request.getLocation()));
                  params.put("project_id", String.valueOf(request.getProjectId()));
                  return params.build();
                })
            .build();
    GrpcCallSettings<LaunchTemplateRequest, LaunchTemplateResponse>
        launchTemplateTransportSettings =
            GrpcCallSettings.<LaunchTemplateRequest, LaunchTemplateResponse>newBuilder()
                .setMethodDescriptor(launchTemplateMethodDescriptor)
                .setParamsExtractor(
                    request -> {
                      ImmutableMap.Builder<String, String> params = ImmutableMap.builder();
                      params.put("location", String.valueOf(request.getLocation()));
                      params.put("project_id", String.valueOf(request.getProjectId()));
                      return params.build();
                    })
                .build();
    GrpcCallSettings<GetTemplateRequest, GetTemplateResponse> getTemplateTransportSettings =
        GrpcCallSettings.<GetTemplateRequest, GetTemplateResponse>newBuilder()
            .setMethodDescriptor(getTemplateMethodDescriptor)
            .setParamsExtractor(
                request -> {
                  ImmutableMap.Builder<String, String> params = ImmutableMap.builder();
                  params.put("location", String.valueOf(request.getLocation()));
                  params.put("project_id", String.valueOf(request.getProjectId()));
                  return params.build();
                })
            .build();

    this.createJobFromTemplateCallable =
        callableFactory.createUnaryCallable(
            createJobFromTemplateTransportSettings,
            settings.createJobFromTemplateSettings(),
            clientContext);
    this.launchTemplateCallable =
        callableFactory.createUnaryCallable(
            launchTemplateTransportSettings, settings.launchTemplateSettings(), clientContext);
    this.getTemplateCallable =
        callableFactory.createUnaryCallable(
            getTemplateTransportSettings, settings.getTemplateSettings(), clientContext);

    this.backgroundResources =
        new BackgroundResourceAggregation(clientContext.getBackgroundResources());
  }

  public GrpcOperationsStub getOperationsStub() {
    return operationsStub;
  }

  @Override
  public UnaryCallable<CreateJobFromTemplateRequest, Job> createJobFromTemplateCallable() {
    return createJobFromTemplateCallable;
  }

  @Override
  public UnaryCallable<LaunchTemplateRequest, LaunchTemplateResponse> launchTemplateCallable() {
    return launchTemplateCallable;
  }

  @Override
  public UnaryCallable<GetTemplateRequest, GetTemplateResponse> getTemplateCallable() {
    return getTemplateCallable;
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
