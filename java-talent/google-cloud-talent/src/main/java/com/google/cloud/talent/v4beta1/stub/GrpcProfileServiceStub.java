/*
 * Copyright 2020 Google LLC
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

package com.google.cloud.talent.v4beta1.stub;

import static com.google.cloud.talent.v4beta1.ProfileServiceClient.ListProfilesPagedResponse;
import static com.google.cloud.talent.v4beta1.ProfileServiceClient.SearchProfilesPagedResponse;

import com.google.api.core.BetaApi;
import com.google.api.gax.core.BackgroundResource;
import com.google.api.gax.core.BackgroundResourceAggregation;
import com.google.api.gax.grpc.GrpcCallSettings;
import com.google.api.gax.grpc.GrpcStubCallableFactory;
import com.google.api.gax.rpc.ClientContext;
import com.google.api.gax.rpc.RequestParamsExtractor;
import com.google.api.gax.rpc.UnaryCallable;
import com.google.cloud.talent.v4beta1.CreateProfileRequest;
import com.google.cloud.talent.v4beta1.DeleteProfileRequest;
import com.google.cloud.talent.v4beta1.GetProfileRequest;
import com.google.cloud.talent.v4beta1.ListProfilesRequest;
import com.google.cloud.talent.v4beta1.ListProfilesResponse;
import com.google.cloud.talent.v4beta1.Profile;
import com.google.cloud.talent.v4beta1.SearchProfilesRequest;
import com.google.cloud.talent.v4beta1.SearchProfilesResponse;
import com.google.cloud.talent.v4beta1.UpdateProfileRequest;
import com.google.common.collect.ImmutableMap;
import com.google.longrunning.stub.GrpcOperationsStub;
import com.google.protobuf.Empty;
import io.grpc.MethodDescriptor;
import io.grpc.protobuf.ProtoUtils;
import java.io.IOException;
import java.util.Map;
import java.util.concurrent.TimeUnit;
import javax.annotation.Generated;

// AUTO-GENERATED DOCUMENTATION AND CLASS.
/**
 * gRPC stub implementation for the ProfileService service API.
 *
 * <p>This class is for advanced usage and reflects the underlying API directly.
 */
@BetaApi
@Generated("by gapic-generator-java")
public class GrpcProfileServiceStub extends ProfileServiceStub {
  private static final MethodDescriptor<ListProfilesRequest, ListProfilesResponse>
      listProfilesMethodDescriptor =
          MethodDescriptor.<ListProfilesRequest, ListProfilesResponse>newBuilder()
              .setType(MethodDescriptor.MethodType.UNARY)
              .setFullMethodName("google.cloud.talent.v4beta1.ProfileService/ListProfiles")
              .setRequestMarshaller(ProtoUtils.marshaller(ListProfilesRequest.getDefaultInstance()))
              .setResponseMarshaller(
                  ProtoUtils.marshaller(ListProfilesResponse.getDefaultInstance()))
              .build();

  private static final MethodDescriptor<CreateProfileRequest, Profile>
      createProfileMethodDescriptor =
          MethodDescriptor.<CreateProfileRequest, Profile>newBuilder()
              .setType(MethodDescriptor.MethodType.UNARY)
              .setFullMethodName("google.cloud.talent.v4beta1.ProfileService/CreateProfile")
              .setRequestMarshaller(
                  ProtoUtils.marshaller(CreateProfileRequest.getDefaultInstance()))
              .setResponseMarshaller(ProtoUtils.marshaller(Profile.getDefaultInstance()))
              .build();

  private static final MethodDescriptor<GetProfileRequest, Profile> getProfileMethodDescriptor =
      MethodDescriptor.<GetProfileRequest, Profile>newBuilder()
          .setType(MethodDescriptor.MethodType.UNARY)
          .setFullMethodName("google.cloud.talent.v4beta1.ProfileService/GetProfile")
          .setRequestMarshaller(ProtoUtils.marshaller(GetProfileRequest.getDefaultInstance()))
          .setResponseMarshaller(ProtoUtils.marshaller(Profile.getDefaultInstance()))
          .build();

  private static final MethodDescriptor<UpdateProfileRequest, Profile>
      updateProfileMethodDescriptor =
          MethodDescriptor.<UpdateProfileRequest, Profile>newBuilder()
              .setType(MethodDescriptor.MethodType.UNARY)
              .setFullMethodName("google.cloud.talent.v4beta1.ProfileService/UpdateProfile")
              .setRequestMarshaller(
                  ProtoUtils.marshaller(UpdateProfileRequest.getDefaultInstance()))
              .setResponseMarshaller(ProtoUtils.marshaller(Profile.getDefaultInstance()))
              .build();

  private static final MethodDescriptor<DeleteProfileRequest, Empty> deleteProfileMethodDescriptor =
      MethodDescriptor.<DeleteProfileRequest, Empty>newBuilder()
          .setType(MethodDescriptor.MethodType.UNARY)
          .setFullMethodName("google.cloud.talent.v4beta1.ProfileService/DeleteProfile")
          .setRequestMarshaller(ProtoUtils.marshaller(DeleteProfileRequest.getDefaultInstance()))
          .setResponseMarshaller(ProtoUtils.marshaller(Empty.getDefaultInstance()))
          .build();

  private static final MethodDescriptor<SearchProfilesRequest, SearchProfilesResponse>
      searchProfilesMethodDescriptor =
          MethodDescriptor.<SearchProfilesRequest, SearchProfilesResponse>newBuilder()
              .setType(MethodDescriptor.MethodType.UNARY)
              .setFullMethodName("google.cloud.talent.v4beta1.ProfileService/SearchProfiles")
              .setRequestMarshaller(
                  ProtoUtils.marshaller(SearchProfilesRequest.getDefaultInstance()))
              .setResponseMarshaller(
                  ProtoUtils.marshaller(SearchProfilesResponse.getDefaultInstance()))
              .build();

  private final UnaryCallable<ListProfilesRequest, ListProfilesResponse> listProfilesCallable;
  private final UnaryCallable<ListProfilesRequest, ListProfilesPagedResponse>
      listProfilesPagedCallable;
  private final UnaryCallable<CreateProfileRequest, Profile> createProfileCallable;
  private final UnaryCallable<GetProfileRequest, Profile> getProfileCallable;
  private final UnaryCallable<UpdateProfileRequest, Profile> updateProfileCallable;
  private final UnaryCallable<DeleteProfileRequest, Empty> deleteProfileCallable;
  private final UnaryCallable<SearchProfilesRequest, SearchProfilesResponse> searchProfilesCallable;
  private final UnaryCallable<SearchProfilesRequest, SearchProfilesPagedResponse>
      searchProfilesPagedCallable;

  private final BackgroundResource backgroundResources;
  private final GrpcOperationsStub operationsStub;
  private final GrpcStubCallableFactory callableFactory;

  public static final GrpcProfileServiceStub create(ProfileServiceStubSettings settings)
      throws IOException {
    return new GrpcProfileServiceStub(settings, ClientContext.create(settings));
  }

  public static final GrpcProfileServiceStub create(ClientContext clientContext)
      throws IOException {
    return new GrpcProfileServiceStub(
        ProfileServiceStubSettings.newBuilder().build(), clientContext);
  }

  public static final GrpcProfileServiceStub create(
      ClientContext clientContext, GrpcStubCallableFactory callableFactory) throws IOException {
    return new GrpcProfileServiceStub(
        ProfileServiceStubSettings.newBuilder().build(), clientContext, callableFactory);
  }

  /**
   * Constructs an instance of GrpcProfileServiceStub, using the given settings. This is protected
   * so that it is easy to make a subclass, but otherwise, the static factory methods should be
   * preferred.
   */
  protected GrpcProfileServiceStub(ProfileServiceStubSettings settings, ClientContext clientContext)
      throws IOException {
    this(settings, clientContext, new GrpcProfileServiceCallableFactory());
  }

  /**
   * Constructs an instance of GrpcProfileServiceStub, using the given settings. This is protected
   * so that it is easy to make a subclass, but otherwise, the static factory methods should be
   * preferred.
   */
  protected GrpcProfileServiceStub(
      ProfileServiceStubSettings settings,
      ClientContext clientContext,
      GrpcStubCallableFactory callableFactory)
      throws IOException {
    this.callableFactory = callableFactory;
    this.operationsStub = GrpcOperationsStub.create(clientContext, callableFactory);

    GrpcCallSettings<ListProfilesRequest, ListProfilesResponse> listProfilesTransportSettings =
        GrpcCallSettings.<ListProfilesRequest, ListProfilesResponse>newBuilder()
            .setMethodDescriptor(listProfilesMethodDescriptor)
            .setParamsExtractor(
                new RequestParamsExtractor<ListProfilesRequest>() {
                  @Override
                  public Map<String, String> extract(ListProfilesRequest request) {
                    ImmutableMap.Builder<String, String> params = ImmutableMap.builder();
                    params.put("parent", String.valueOf(request.getParent()));
                    return params.build();
                  }
                })
            .build();
    GrpcCallSettings<CreateProfileRequest, Profile> createProfileTransportSettings =
        GrpcCallSettings.<CreateProfileRequest, Profile>newBuilder()
            .setMethodDescriptor(createProfileMethodDescriptor)
            .setParamsExtractor(
                new RequestParamsExtractor<CreateProfileRequest>() {
                  @Override
                  public Map<String, String> extract(CreateProfileRequest request) {
                    ImmutableMap.Builder<String, String> params = ImmutableMap.builder();
                    params.put("parent", String.valueOf(request.getParent()));
                    return params.build();
                  }
                })
            .build();
    GrpcCallSettings<GetProfileRequest, Profile> getProfileTransportSettings =
        GrpcCallSettings.<GetProfileRequest, Profile>newBuilder()
            .setMethodDescriptor(getProfileMethodDescriptor)
            .setParamsExtractor(
                new RequestParamsExtractor<GetProfileRequest>() {
                  @Override
                  public Map<String, String> extract(GetProfileRequest request) {
                    ImmutableMap.Builder<String, String> params = ImmutableMap.builder();
                    params.put("name", String.valueOf(request.getName()));
                    return params.build();
                  }
                })
            .build();
    GrpcCallSettings<UpdateProfileRequest, Profile> updateProfileTransportSettings =
        GrpcCallSettings.<UpdateProfileRequest, Profile>newBuilder()
            .setMethodDescriptor(updateProfileMethodDescriptor)
            .setParamsExtractor(
                new RequestParamsExtractor<UpdateProfileRequest>() {
                  @Override
                  public Map<String, String> extract(UpdateProfileRequest request) {
                    ImmutableMap.Builder<String, String> params = ImmutableMap.builder();
                    params.put("profile.name", String.valueOf(request.getProfile().getName()));
                    return params.build();
                  }
                })
            .build();
    GrpcCallSettings<DeleteProfileRequest, Empty> deleteProfileTransportSettings =
        GrpcCallSettings.<DeleteProfileRequest, Empty>newBuilder()
            .setMethodDescriptor(deleteProfileMethodDescriptor)
            .setParamsExtractor(
                new RequestParamsExtractor<DeleteProfileRequest>() {
                  @Override
                  public Map<String, String> extract(DeleteProfileRequest request) {
                    ImmutableMap.Builder<String, String> params = ImmutableMap.builder();
                    params.put("name", String.valueOf(request.getName()));
                    return params.build();
                  }
                })
            .build();
    GrpcCallSettings<SearchProfilesRequest, SearchProfilesResponse>
        searchProfilesTransportSettings =
            GrpcCallSettings.<SearchProfilesRequest, SearchProfilesResponse>newBuilder()
                .setMethodDescriptor(searchProfilesMethodDescriptor)
                .setParamsExtractor(
                    new RequestParamsExtractor<SearchProfilesRequest>() {
                      @Override
                      public Map<String, String> extract(SearchProfilesRequest request) {
                        ImmutableMap.Builder<String, String> params = ImmutableMap.builder();
                        params.put("parent", String.valueOf(request.getParent()));
                        return params.build();
                      }
                    })
                .build();

    this.listProfilesCallable =
        callableFactory.createUnaryCallable(
            listProfilesTransportSettings, settings.listProfilesSettings(), clientContext);
    this.listProfilesPagedCallable =
        callableFactory.createPagedCallable(
            listProfilesTransportSettings, settings.listProfilesSettings(), clientContext);
    this.createProfileCallable =
        callableFactory.createUnaryCallable(
            createProfileTransportSettings, settings.createProfileSettings(), clientContext);
    this.getProfileCallable =
        callableFactory.createUnaryCallable(
            getProfileTransportSettings, settings.getProfileSettings(), clientContext);
    this.updateProfileCallable =
        callableFactory.createUnaryCallable(
            updateProfileTransportSettings, settings.updateProfileSettings(), clientContext);
    this.deleteProfileCallable =
        callableFactory.createUnaryCallable(
            deleteProfileTransportSettings, settings.deleteProfileSettings(), clientContext);
    this.searchProfilesCallable =
        callableFactory.createUnaryCallable(
            searchProfilesTransportSettings, settings.searchProfilesSettings(), clientContext);
    this.searchProfilesPagedCallable =
        callableFactory.createPagedCallable(
            searchProfilesTransportSettings, settings.searchProfilesSettings(), clientContext);

    this.backgroundResources =
        new BackgroundResourceAggregation(clientContext.getBackgroundResources());
  }

  public GrpcOperationsStub getOperationsStub() {
    return operationsStub;
  }

  public UnaryCallable<ListProfilesRequest, ListProfilesResponse> listProfilesCallable() {
    return listProfilesCallable;
  }

  public UnaryCallable<ListProfilesRequest, ListProfilesPagedResponse> listProfilesPagedCallable() {
    return listProfilesPagedCallable;
  }

  public UnaryCallable<CreateProfileRequest, Profile> createProfileCallable() {
    return createProfileCallable;
  }

  public UnaryCallable<GetProfileRequest, Profile> getProfileCallable() {
    return getProfileCallable;
  }

  public UnaryCallable<UpdateProfileRequest, Profile> updateProfileCallable() {
    return updateProfileCallable;
  }

  public UnaryCallable<DeleteProfileRequest, Empty> deleteProfileCallable() {
    return deleteProfileCallable;
  }

  public UnaryCallable<SearchProfilesRequest, SearchProfilesResponse> searchProfilesCallable() {
    return searchProfilesCallable;
  }

  public UnaryCallable<SearchProfilesRequest, SearchProfilesPagedResponse>
      searchProfilesPagedCallable() {
    return searchProfilesPagedCallable;
  }

  @Override
  public final void close() {
    shutdown();
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
