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

package com.google.cloud.run.v2.stub;

import com.google.api.gax.core.BackgroundResource;
import com.google.api.gax.core.BackgroundResourceAggregation;
import com.google.api.gax.grpc.GrpcCallSettings;
import com.google.api.gax.grpc.GrpcStubCallableFactory;
import com.google.api.gax.rpc.ClientContext;
import com.google.api.gax.rpc.RequestParamsBuilder;
import com.google.api.gax.rpc.UnaryCallable;
import com.google.api.pathtemplate.PathTemplate;
import com.google.cloud.run.v2.UploadSourceRequest;
import com.google.cloud.run.v2.UploadSourceResponse;
import com.google.longrunning.stub.GrpcOperationsStub;
import io.grpc.MethodDescriptor;
import io.grpc.protobuf.ProtoUtils;
import java.io.IOException;
import java.util.concurrent.TimeUnit;
import javax.annotation.Generated;
import org.jspecify.annotations.NullMarked;

// AUTO-GENERATED DOCUMENTATION AND CLASS.
/**
 * gRPC stub implementation for the SourceUpload service API.
 *
 * <p>This class is for advanced usage and reflects the underlying API directly.
 */
@NullMarked
@Generated("by gapic-generator-java")
public class GrpcSourceUploadStub extends SourceUploadStub {
  private static final MethodDescriptor<UploadSourceRequest, UploadSourceResponse>
      uploadSourceMethodDescriptor =
          MethodDescriptor.<UploadSourceRequest, UploadSourceResponse>newBuilder()
              .setType(MethodDescriptor.MethodType.UNARY)
              .setFullMethodName("google.cloud.run.v2.SourceUpload/UploadSource")
              .setRequestMarshaller(ProtoUtils.marshaller(UploadSourceRequest.getDefaultInstance()))
              .setResponseMarshaller(
                  ProtoUtils.marshaller(UploadSourceResponse.getDefaultInstance()))
              .setSampledToLocalTracing(true)
              .build();

  private final UnaryCallable<UploadSourceRequest, UploadSourceResponse> uploadSourceCallable;

  private final BackgroundResource backgroundResources;
  private final GrpcOperationsStub operationsStub;
  private final GrpcStubCallableFactory callableFactory;

  private static final PathTemplate UPLOAD_SOURCE_0_PATH_TEMPLATE =
      PathTemplate.create("projects/*/locations/{location=*}");

  public static final GrpcSourceUploadStub create(SourceUploadStubSettings settings)
      throws IOException {
    return new GrpcSourceUploadStub(settings, ClientContext.create(settings));
  }

  public static final GrpcSourceUploadStub create(ClientContext clientContext) throws IOException {
    return new GrpcSourceUploadStub(SourceUploadStubSettings.newBuilder().build(), clientContext);
  }

  public static final GrpcSourceUploadStub create(
      ClientContext clientContext, GrpcStubCallableFactory callableFactory) throws IOException {
    return new GrpcSourceUploadStub(
        SourceUploadStubSettings.newBuilder().build(), clientContext, callableFactory);
  }

  /**
   * Constructs an instance of GrpcSourceUploadStub, using the given settings. This is protected so
   * that it is easy to make a subclass, but otherwise, the static factory methods should be
   * preferred.
   */
  protected GrpcSourceUploadStub(SourceUploadStubSettings settings, ClientContext clientContext)
      throws IOException {
    this(settings, clientContext, new GrpcSourceUploadCallableFactory());
  }

  /**
   * Constructs an instance of GrpcSourceUploadStub, using the given settings. This is protected so
   * that it is easy to make a subclass, but otherwise, the static factory methods should be
   * preferred.
   */
  protected GrpcSourceUploadStub(
      SourceUploadStubSettings settings,
      ClientContext clientContext,
      GrpcStubCallableFactory callableFactory)
      throws IOException {
    this.callableFactory = callableFactory;
    this.operationsStub = GrpcOperationsStub.create(clientContext, callableFactory);

    GrpcCallSettings<UploadSourceRequest, UploadSourceResponse> uploadSourceTransportSettings =
        GrpcCallSettings.<UploadSourceRequest, UploadSourceResponse>newBuilder()
            .setMethodDescriptor(uploadSourceMethodDescriptor)
            .setParamsExtractor(
                request -> {
                  RequestParamsBuilder builder = RequestParamsBuilder.create();
                  builder.add(request.getParent(), "location", UPLOAD_SOURCE_0_PATH_TEMPLATE);
                  return builder.build();
                })
            .setResourceNameExtractor(request -> request.getParent())
            .build();

    this.uploadSourceCallable =
        callableFactory.createUnaryCallable(
            uploadSourceTransportSettings, settings.uploadSourceSettings(), clientContext);

    this.backgroundResources =
        new BackgroundResourceAggregation(clientContext.getBackgroundResources());
  }

  public GrpcOperationsStub getOperationsStub() {
    return operationsStub;
  }

  @Override
  public UnaryCallable<UploadSourceRequest, UploadSourceResponse> uploadSourceCallable() {
    return uploadSourceCallable;
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
