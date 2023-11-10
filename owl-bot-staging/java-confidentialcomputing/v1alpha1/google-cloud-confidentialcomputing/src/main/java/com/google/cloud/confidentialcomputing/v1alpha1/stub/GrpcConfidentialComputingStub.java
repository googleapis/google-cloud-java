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

package com.google.cloud.confidentialcomputing.v1alpha1.stub;

import static com.google.cloud.confidentialcomputing.v1alpha1.ConfidentialComputingClient.ListLocationsPagedResponse;

import com.google.api.core.BetaApi;
import com.google.api.gax.core.BackgroundResource;
import com.google.api.gax.core.BackgroundResourceAggregation;
import com.google.api.gax.grpc.GrpcCallSettings;
import com.google.api.gax.grpc.GrpcStubCallableFactory;
import com.google.api.gax.rpc.ClientContext;
import com.google.api.gax.rpc.RequestParamsBuilder;
import com.google.api.gax.rpc.UnaryCallable;
import com.google.cloud.confidentialcomputing.v1alpha1.Challenge;
import com.google.cloud.confidentialcomputing.v1alpha1.CreateChallengeRequest;
import com.google.cloud.confidentialcomputing.v1alpha1.VerifyAttestationRequest;
import com.google.cloud.confidentialcomputing.v1alpha1.VerifyAttestationResponse;
import com.google.cloud.location.GetLocationRequest;
import com.google.cloud.location.ListLocationsRequest;
import com.google.cloud.location.ListLocationsResponse;
import com.google.cloud.location.Location;
import com.google.longrunning.stub.GrpcOperationsStub;
import io.grpc.MethodDescriptor;
import io.grpc.protobuf.ProtoUtils;
import java.io.IOException;
import java.util.Map;
import java.util.concurrent.TimeUnit;
import javax.annotation.Generated;

// AUTO-GENERATED DOCUMENTATION AND CLASS.
/**
 * gRPC stub implementation for the ConfidentialComputing service API.
 *
 * <p>This class is for advanced usage and reflects the underlying API directly.
 */
@BetaApi
@Generated("by gapic-generator-java")
public class GrpcConfidentialComputingStub extends ConfidentialComputingStub {
  private static final MethodDescriptor<CreateChallengeRequest, Challenge>
      createChallengeMethodDescriptor =
          MethodDescriptor.<CreateChallengeRequest, Challenge>newBuilder()
              .setType(MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(
                  "google.cloud.confidentialcomputing.v1alpha1.ConfidentialComputing/CreateChallenge")
              .setRequestMarshaller(
                  ProtoUtils.marshaller(CreateChallengeRequest.getDefaultInstance()))
              .setResponseMarshaller(ProtoUtils.marshaller(Challenge.getDefaultInstance()))
              .build();

  private static final MethodDescriptor<VerifyAttestationRequest, VerifyAttestationResponse>
      verifyAttestationMethodDescriptor =
          MethodDescriptor.<VerifyAttestationRequest, VerifyAttestationResponse>newBuilder()
              .setType(MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(
                  "google.cloud.confidentialcomputing.v1alpha1.ConfidentialComputing/VerifyAttestation")
              .setRequestMarshaller(
                  ProtoUtils.marshaller(VerifyAttestationRequest.getDefaultInstance()))
              .setResponseMarshaller(
                  ProtoUtils.marshaller(VerifyAttestationResponse.getDefaultInstance()))
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

  private final UnaryCallable<CreateChallengeRequest, Challenge> createChallengeCallable;
  private final UnaryCallable<VerifyAttestationRequest, VerifyAttestationResponse>
      verifyAttestationCallable;
  private final UnaryCallable<ListLocationsRequest, ListLocationsResponse> listLocationsCallable;
  private final UnaryCallable<ListLocationsRequest, ListLocationsPagedResponse>
      listLocationsPagedCallable;
  private final UnaryCallable<GetLocationRequest, Location> getLocationCallable;

  private final BackgroundResource backgroundResources;
  private final GrpcOperationsStub operationsStub;
  private final GrpcStubCallableFactory callableFactory;

  public static final GrpcConfidentialComputingStub create(
      ConfidentialComputingStubSettings settings) throws IOException {
    return new GrpcConfidentialComputingStub(settings, ClientContext.create(settings));
  }

  public static final GrpcConfidentialComputingStub create(ClientContext clientContext)
      throws IOException {
    return new GrpcConfidentialComputingStub(
        ConfidentialComputingStubSettings.newBuilder().build(), clientContext);
  }

  public static final GrpcConfidentialComputingStub create(
      ClientContext clientContext, GrpcStubCallableFactory callableFactory) throws IOException {
    return new GrpcConfidentialComputingStub(
        ConfidentialComputingStubSettings.newBuilder().build(), clientContext, callableFactory);
  }

  /**
   * Constructs an instance of GrpcConfidentialComputingStub, using the given settings. This is
   * protected so that it is easy to make a subclass, but otherwise, the static factory methods
   * should be preferred.
   */
  protected GrpcConfidentialComputingStub(
      ConfidentialComputingStubSettings settings, ClientContext clientContext) throws IOException {
    this(settings, clientContext, new GrpcConfidentialComputingCallableFactory());
  }

  /**
   * Constructs an instance of GrpcConfidentialComputingStub, using the given settings. This is
   * protected so that it is easy to make a subclass, but otherwise, the static factory methods
   * should be preferred.
   */
  protected GrpcConfidentialComputingStub(
      ConfidentialComputingStubSettings settings,
      ClientContext clientContext,
      GrpcStubCallableFactory callableFactory)
      throws IOException {
    this.callableFactory = callableFactory;
    this.operationsStub = GrpcOperationsStub.create(clientContext, callableFactory);

    GrpcCallSettings<CreateChallengeRequest, Challenge> createChallengeTransportSettings =
        GrpcCallSettings.<CreateChallengeRequest, Challenge>newBuilder()
            .setMethodDescriptor(createChallengeMethodDescriptor)
            .setParamsExtractor(
                request -> {
                  RequestParamsBuilder builder = RequestParamsBuilder.create();
                  builder.add("parent", String.valueOf(request.getParent()));
                  return builder.build();
                })
            .build();
    GrpcCallSettings<VerifyAttestationRequest, VerifyAttestationResponse>
        verifyAttestationTransportSettings =
            GrpcCallSettings.<VerifyAttestationRequest, VerifyAttestationResponse>newBuilder()
                .setMethodDescriptor(verifyAttestationMethodDescriptor)
                .setParamsExtractor(
                    request -> {
                      RequestParamsBuilder builder = RequestParamsBuilder.create();
                      builder.add("challenge", String.valueOf(request.getChallenge()));
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

    this.createChallengeCallable =
        callableFactory.createUnaryCallable(
            createChallengeTransportSettings, settings.createChallengeSettings(), clientContext);
    this.verifyAttestationCallable =
        callableFactory.createUnaryCallable(
            verifyAttestationTransportSettings,
            settings.verifyAttestationSettings(),
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
  public UnaryCallable<CreateChallengeRequest, Challenge> createChallengeCallable() {
    return createChallengeCallable;
  }

  @Override
  public UnaryCallable<VerifyAttestationRequest, VerifyAttestationResponse>
      verifyAttestationCallable() {
    return verifyAttestationCallable;
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
