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

package com.google.cloud.confidentialcomputing.v1.stub;

import static com.google.cloud.confidentialcomputing.v1.ConfidentialComputingClient.ListLocationsPagedResponse;

import com.google.api.core.InternalApi;
import com.google.api.gax.core.BackgroundResource;
import com.google.api.gax.core.BackgroundResourceAggregation;
import com.google.api.gax.httpjson.ApiMethodDescriptor;
import com.google.api.gax.httpjson.HttpJsonCallSettings;
import com.google.api.gax.httpjson.HttpJsonStubCallableFactory;
import com.google.api.gax.httpjson.ProtoMessageRequestFormatter;
import com.google.api.gax.httpjson.ProtoMessageResponseParser;
import com.google.api.gax.httpjson.ProtoRestSerializer;
import com.google.api.gax.rpc.ClientContext;
import com.google.api.gax.rpc.RequestParamsBuilder;
import com.google.api.gax.rpc.UnaryCallable;
import com.google.cloud.confidentialcomputing.v1.Challenge;
import com.google.cloud.confidentialcomputing.v1.CreateChallengeRequest;
import com.google.cloud.confidentialcomputing.v1.VerifyAttestationRequest;
import com.google.cloud.confidentialcomputing.v1.VerifyAttestationResponse;
import com.google.cloud.confidentialcomputing.v1.VerifyConfidentialGkeRequest;
import com.google.cloud.confidentialcomputing.v1.VerifyConfidentialGkeResponse;
import com.google.cloud.confidentialcomputing.v1.VerifyConfidentialSpaceRequest;
import com.google.cloud.confidentialcomputing.v1.VerifyConfidentialSpaceResponse;
import com.google.cloud.location.GetLocationRequest;
import com.google.cloud.location.ListLocationsRequest;
import com.google.cloud.location.ListLocationsResponse;
import com.google.cloud.location.Location;
import com.google.protobuf.TypeRegistry;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.TimeUnit;
import javax.annotation.Generated;

// AUTO-GENERATED DOCUMENTATION AND CLASS.
/**
 * REST stub implementation for the ConfidentialComputing service API.
 *
 * <p>This class is for advanced usage and reflects the underlying API directly.
 */
@Generated("by gapic-generator-java")
public class HttpJsonConfidentialComputingStub extends ConfidentialComputingStub {
  private static final TypeRegistry typeRegistry = TypeRegistry.newBuilder().build();

  private static final ApiMethodDescriptor<CreateChallengeRequest, Challenge>
      createChallengeMethodDescriptor =
          ApiMethodDescriptor.<CreateChallengeRequest, Challenge>newBuilder()
              .setFullMethodName(
                  "google.cloud.confidentialcomputing.v1.ConfidentialComputing/CreateChallenge")
              .setHttpMethod("POST")
              .setType(ApiMethodDescriptor.MethodType.UNARY)
              .setRequestFormatter(
                  ProtoMessageRequestFormatter.<CreateChallengeRequest>newBuilder()
                      .setPath(
                          "/v1/{parent=projects/*/locations/*}/challenges",
                          request -> {
                            Map<String, String> fields = new HashMap<>();
                            ProtoRestSerializer<CreateChallengeRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putPathParam(fields, "parent", request.getParent());
                            return fields;
                          })
                      .setQueryParamsExtractor(
                          request -> {
                            Map<String, List<String>> fields = new HashMap<>();
                            ProtoRestSerializer<CreateChallengeRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putQueryParam(fields, "$alt", "json;enum-encoding=int");
                            return fields;
                          })
                      .setRequestBodyExtractor(
                          request ->
                              ProtoRestSerializer.create()
                                  .toBody("challenge", request.getChallenge(), true))
                      .build())
              .setResponseParser(
                  ProtoMessageResponseParser.<Challenge>newBuilder()
                      .setDefaultInstance(Challenge.getDefaultInstance())
                      .setDefaultTypeRegistry(typeRegistry)
                      .build())
              .build();

  private static final ApiMethodDescriptor<VerifyAttestationRequest, VerifyAttestationResponse>
      verifyAttestationMethodDescriptor =
          ApiMethodDescriptor.<VerifyAttestationRequest, VerifyAttestationResponse>newBuilder()
              .setFullMethodName(
                  "google.cloud.confidentialcomputing.v1.ConfidentialComputing/VerifyAttestation")
              .setHttpMethod("POST")
              .setType(ApiMethodDescriptor.MethodType.UNARY)
              .setRequestFormatter(
                  ProtoMessageRequestFormatter.<VerifyAttestationRequest>newBuilder()
                      .setPath(
                          "/v1/{challenge=projects/*/locations/*/challenges/*}:verifyAttestation",
                          request -> {
                            Map<String, String> fields = new HashMap<>();
                            ProtoRestSerializer<VerifyAttestationRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putPathParam(fields, "challenge", request.getChallenge());
                            return fields;
                          })
                      .setQueryParamsExtractor(
                          request -> {
                            Map<String, List<String>> fields = new HashMap<>();
                            ProtoRestSerializer<VerifyAttestationRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putQueryParam(fields, "$alt", "json;enum-encoding=int");
                            return fields;
                          })
                      .setRequestBodyExtractor(
                          request ->
                              ProtoRestSerializer.create()
                                  .toBody("*", request.toBuilder().clearChallenge().build(), true))
                      .build())
              .setResponseParser(
                  ProtoMessageResponseParser.<VerifyAttestationResponse>newBuilder()
                      .setDefaultInstance(VerifyAttestationResponse.getDefaultInstance())
                      .setDefaultTypeRegistry(typeRegistry)
                      .build())
              .build();

  private static final ApiMethodDescriptor<
          VerifyConfidentialSpaceRequest, VerifyConfidentialSpaceResponse>
      verifyConfidentialSpaceMethodDescriptor =
          ApiMethodDescriptor
              .<VerifyConfidentialSpaceRequest, VerifyConfidentialSpaceResponse>newBuilder()
              .setFullMethodName(
                  "google.cloud.confidentialcomputing.v1.ConfidentialComputing/VerifyConfidentialSpace")
              .setHttpMethod("POST")
              .setType(ApiMethodDescriptor.MethodType.UNARY)
              .setRequestFormatter(
                  ProtoMessageRequestFormatter.<VerifyConfidentialSpaceRequest>newBuilder()
                      .setPath(
                          "/v1/{challenge=projects/*/locations/*/challenges/*}:verifyConfidentialSpace",
                          request -> {
                            Map<String, String> fields = new HashMap<>();
                            ProtoRestSerializer<VerifyConfidentialSpaceRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putPathParam(fields, "challenge", request.getChallenge());
                            return fields;
                          })
                      .setQueryParamsExtractor(
                          request -> {
                            Map<String, List<String>> fields = new HashMap<>();
                            ProtoRestSerializer<VerifyConfidentialSpaceRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putQueryParam(fields, "$alt", "json;enum-encoding=int");
                            return fields;
                          })
                      .setRequestBodyExtractor(
                          request ->
                              ProtoRestSerializer.create()
                                  .toBody("*", request.toBuilder().clearChallenge().build(), true))
                      .build())
              .setResponseParser(
                  ProtoMessageResponseParser.<VerifyConfidentialSpaceResponse>newBuilder()
                      .setDefaultInstance(VerifyConfidentialSpaceResponse.getDefaultInstance())
                      .setDefaultTypeRegistry(typeRegistry)
                      .build())
              .build();

  private static final ApiMethodDescriptor<
          VerifyConfidentialGkeRequest, VerifyConfidentialGkeResponse>
      verifyConfidentialGkeMethodDescriptor =
          ApiMethodDescriptor
              .<VerifyConfidentialGkeRequest, VerifyConfidentialGkeResponse>newBuilder()
              .setFullMethodName(
                  "google.cloud.confidentialcomputing.v1.ConfidentialComputing/VerifyConfidentialGke")
              .setHttpMethod("POST")
              .setType(ApiMethodDescriptor.MethodType.UNARY)
              .setRequestFormatter(
                  ProtoMessageRequestFormatter.<VerifyConfidentialGkeRequest>newBuilder()
                      .setPath(
                          "/v1/{challenge=projects/*/locations/*/challenges/*}:verifyConfidentialGke",
                          request -> {
                            Map<String, String> fields = new HashMap<>();
                            ProtoRestSerializer<VerifyConfidentialGkeRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putPathParam(fields, "challenge", request.getChallenge());
                            return fields;
                          })
                      .setQueryParamsExtractor(
                          request -> {
                            Map<String, List<String>> fields = new HashMap<>();
                            ProtoRestSerializer<VerifyConfidentialGkeRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putQueryParam(fields, "$alt", "json;enum-encoding=int");
                            return fields;
                          })
                      .setRequestBodyExtractor(
                          request ->
                              ProtoRestSerializer.create()
                                  .toBody("*", request.toBuilder().clearChallenge().build(), true))
                      .build())
              .setResponseParser(
                  ProtoMessageResponseParser.<VerifyConfidentialGkeResponse>newBuilder()
                      .setDefaultInstance(VerifyConfidentialGkeResponse.getDefaultInstance())
                      .setDefaultTypeRegistry(typeRegistry)
                      .build())
              .build();

  private static final ApiMethodDescriptor<ListLocationsRequest, ListLocationsResponse>
      listLocationsMethodDescriptor =
          ApiMethodDescriptor.<ListLocationsRequest, ListLocationsResponse>newBuilder()
              .setFullMethodName("google.cloud.location.Locations/ListLocations")
              .setHttpMethod("GET")
              .setType(ApiMethodDescriptor.MethodType.UNARY)
              .setRequestFormatter(
                  ProtoMessageRequestFormatter.<ListLocationsRequest>newBuilder()
                      .setPath(
                          "/v1/{name=projects/*}/locations",
                          request -> {
                            Map<String, String> fields = new HashMap<>();
                            ProtoRestSerializer<ListLocationsRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putPathParam(fields, "name", request.getName());
                            return fields;
                          })
                      .setQueryParamsExtractor(
                          request -> {
                            Map<String, List<String>> fields = new HashMap<>();
                            ProtoRestSerializer<ListLocationsRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putQueryParam(fields, "$alt", "json;enum-encoding=int");
                            return fields;
                          })
                      .setRequestBodyExtractor(request -> null)
                      .build())
              .setResponseParser(
                  ProtoMessageResponseParser.<ListLocationsResponse>newBuilder()
                      .setDefaultInstance(ListLocationsResponse.getDefaultInstance())
                      .setDefaultTypeRegistry(typeRegistry)
                      .build())
              .build();

  private static final ApiMethodDescriptor<GetLocationRequest, Location>
      getLocationMethodDescriptor =
          ApiMethodDescriptor.<GetLocationRequest, Location>newBuilder()
              .setFullMethodName("google.cloud.location.Locations/GetLocation")
              .setHttpMethod("GET")
              .setType(ApiMethodDescriptor.MethodType.UNARY)
              .setRequestFormatter(
                  ProtoMessageRequestFormatter.<GetLocationRequest>newBuilder()
                      .setPath(
                          "/v1/{name=projects/*/locations/*}",
                          request -> {
                            Map<String, String> fields = new HashMap<>();
                            ProtoRestSerializer<GetLocationRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putPathParam(fields, "name", request.getName());
                            return fields;
                          })
                      .setQueryParamsExtractor(
                          request -> {
                            Map<String, List<String>> fields = new HashMap<>();
                            ProtoRestSerializer<GetLocationRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putQueryParam(fields, "$alt", "json;enum-encoding=int");
                            return fields;
                          })
                      .setRequestBodyExtractor(request -> null)
                      .build())
              .setResponseParser(
                  ProtoMessageResponseParser.<Location>newBuilder()
                      .setDefaultInstance(Location.getDefaultInstance())
                      .setDefaultTypeRegistry(typeRegistry)
                      .build())
              .build();

  private final UnaryCallable<CreateChallengeRequest, Challenge> createChallengeCallable;
  private final UnaryCallable<VerifyAttestationRequest, VerifyAttestationResponse>
      verifyAttestationCallable;
  private final UnaryCallable<VerifyConfidentialSpaceRequest, VerifyConfidentialSpaceResponse>
      verifyConfidentialSpaceCallable;
  private final UnaryCallable<VerifyConfidentialGkeRequest, VerifyConfidentialGkeResponse>
      verifyConfidentialGkeCallable;
  private final UnaryCallable<ListLocationsRequest, ListLocationsResponse> listLocationsCallable;
  private final UnaryCallable<ListLocationsRequest, ListLocationsPagedResponse>
      listLocationsPagedCallable;
  private final UnaryCallable<GetLocationRequest, Location> getLocationCallable;

  private final BackgroundResource backgroundResources;
  private final HttpJsonStubCallableFactory callableFactory;

  public static final HttpJsonConfidentialComputingStub create(
      ConfidentialComputingStubSettings settings) throws IOException {
    return new HttpJsonConfidentialComputingStub(settings, ClientContext.create(settings));
  }

  public static final HttpJsonConfidentialComputingStub create(ClientContext clientContext)
      throws IOException {
    return new HttpJsonConfidentialComputingStub(
        ConfidentialComputingStubSettings.newHttpJsonBuilder().build(), clientContext);
  }

  public static final HttpJsonConfidentialComputingStub create(
      ClientContext clientContext, HttpJsonStubCallableFactory callableFactory) throws IOException {
    return new HttpJsonConfidentialComputingStub(
        ConfidentialComputingStubSettings.newHttpJsonBuilder().build(),
        clientContext,
        callableFactory);
  }

  /**
   * Constructs an instance of HttpJsonConfidentialComputingStub, using the given settings. This is
   * protected so that it is easy to make a subclass, but otherwise, the static factory methods
   * should be preferred.
   */
  protected HttpJsonConfidentialComputingStub(
      ConfidentialComputingStubSettings settings, ClientContext clientContext) throws IOException {
    this(settings, clientContext, new HttpJsonConfidentialComputingCallableFactory());
  }

  /**
   * Constructs an instance of HttpJsonConfidentialComputingStub, using the given settings. This is
   * protected so that it is easy to make a subclass, but otherwise, the static factory methods
   * should be preferred.
   */
  protected HttpJsonConfidentialComputingStub(
      ConfidentialComputingStubSettings settings,
      ClientContext clientContext,
      HttpJsonStubCallableFactory callableFactory)
      throws IOException {
    this.callableFactory = callableFactory;

    HttpJsonCallSettings<CreateChallengeRequest, Challenge> createChallengeTransportSettings =
        HttpJsonCallSettings.<CreateChallengeRequest, Challenge>newBuilder()
            .setMethodDescriptor(createChallengeMethodDescriptor)
            .setTypeRegistry(typeRegistry)
            .setParamsExtractor(
                request -> {
                  RequestParamsBuilder builder = RequestParamsBuilder.create();
                  builder.add("parent", String.valueOf(request.getParent()));
                  return builder.build();
                })
            .build();
    HttpJsonCallSettings<VerifyAttestationRequest, VerifyAttestationResponse>
        verifyAttestationTransportSettings =
            HttpJsonCallSettings.<VerifyAttestationRequest, VerifyAttestationResponse>newBuilder()
                .setMethodDescriptor(verifyAttestationMethodDescriptor)
                .setTypeRegistry(typeRegistry)
                .setParamsExtractor(
                    request -> {
                      RequestParamsBuilder builder = RequestParamsBuilder.create();
                      builder.add("challenge", String.valueOf(request.getChallenge()));
                      return builder.build();
                    })
                .build();
    HttpJsonCallSettings<VerifyConfidentialSpaceRequest, VerifyConfidentialSpaceResponse>
        verifyConfidentialSpaceTransportSettings =
            HttpJsonCallSettings
                .<VerifyConfidentialSpaceRequest, VerifyConfidentialSpaceResponse>newBuilder()
                .setMethodDescriptor(verifyConfidentialSpaceMethodDescriptor)
                .setTypeRegistry(typeRegistry)
                .setParamsExtractor(
                    request -> {
                      RequestParamsBuilder builder = RequestParamsBuilder.create();
                      builder.add("challenge", String.valueOf(request.getChallenge()));
                      return builder.build();
                    })
                .build();
    HttpJsonCallSettings<VerifyConfidentialGkeRequest, VerifyConfidentialGkeResponse>
        verifyConfidentialGkeTransportSettings =
            HttpJsonCallSettings
                .<VerifyConfidentialGkeRequest, VerifyConfidentialGkeResponse>newBuilder()
                .setMethodDescriptor(verifyConfidentialGkeMethodDescriptor)
                .setTypeRegistry(typeRegistry)
                .setParamsExtractor(
                    request -> {
                      RequestParamsBuilder builder = RequestParamsBuilder.create();
                      builder.add("challenge", String.valueOf(request.getChallenge()));
                      return builder.build();
                    })
                .build();
    HttpJsonCallSettings<ListLocationsRequest, ListLocationsResponse>
        listLocationsTransportSettings =
            HttpJsonCallSettings.<ListLocationsRequest, ListLocationsResponse>newBuilder()
                .setMethodDescriptor(listLocationsMethodDescriptor)
                .setTypeRegistry(typeRegistry)
                .setParamsExtractor(
                    request -> {
                      RequestParamsBuilder builder = RequestParamsBuilder.create();
                      builder.add("name", String.valueOf(request.getName()));
                      return builder.build();
                    })
                .build();
    HttpJsonCallSettings<GetLocationRequest, Location> getLocationTransportSettings =
        HttpJsonCallSettings.<GetLocationRequest, Location>newBuilder()
            .setMethodDescriptor(getLocationMethodDescriptor)
            .setTypeRegistry(typeRegistry)
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
    this.verifyConfidentialSpaceCallable =
        callableFactory.createUnaryCallable(
            verifyConfidentialSpaceTransportSettings,
            settings.verifyConfidentialSpaceSettings(),
            clientContext);
    this.verifyConfidentialGkeCallable =
        callableFactory.createUnaryCallable(
            verifyConfidentialGkeTransportSettings,
            settings.verifyConfidentialGkeSettings(),
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

  @InternalApi
  public static List<ApiMethodDescriptor> getMethodDescriptors() {
    List<ApiMethodDescriptor> methodDescriptors = new ArrayList<>();
    methodDescriptors.add(createChallengeMethodDescriptor);
    methodDescriptors.add(verifyAttestationMethodDescriptor);
    methodDescriptors.add(verifyConfidentialSpaceMethodDescriptor);
    methodDescriptors.add(verifyConfidentialGkeMethodDescriptor);
    methodDescriptors.add(listLocationsMethodDescriptor);
    methodDescriptors.add(getLocationMethodDescriptor);
    return methodDescriptors;
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
  public UnaryCallable<VerifyConfidentialSpaceRequest, VerifyConfidentialSpaceResponse>
      verifyConfidentialSpaceCallable() {
    return verifyConfidentialSpaceCallable;
  }

  @Override
  public UnaryCallable<VerifyConfidentialGkeRequest, VerifyConfidentialGkeResponse>
      verifyConfidentialGkeCallable() {
    return verifyConfidentialGkeCallable;
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
