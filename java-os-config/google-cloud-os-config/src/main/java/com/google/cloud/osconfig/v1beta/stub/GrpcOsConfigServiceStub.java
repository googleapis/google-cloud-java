/*
 * Copyright 2021 Google LLC
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

package com.google.cloud.osconfig.v1beta.stub;

import static com.google.cloud.osconfig.v1beta.OsConfigServiceClient.ListGuestPoliciesPagedResponse;
import static com.google.cloud.osconfig.v1beta.OsConfigServiceClient.ListPatchDeploymentsPagedResponse;
import static com.google.cloud.osconfig.v1beta.OsConfigServiceClient.ListPatchJobInstanceDetailsPagedResponse;
import static com.google.cloud.osconfig.v1beta.OsConfigServiceClient.ListPatchJobsPagedResponse;

import com.google.api.core.BetaApi;
import com.google.api.gax.core.BackgroundResource;
import com.google.api.gax.core.BackgroundResourceAggregation;
import com.google.api.gax.grpc.GrpcCallSettings;
import com.google.api.gax.grpc.GrpcStubCallableFactory;
import com.google.api.gax.rpc.ClientContext;
import com.google.api.gax.rpc.RequestParamsExtractor;
import com.google.api.gax.rpc.UnaryCallable;
import com.google.cloud.osconfig.v1beta.GuestPolicies;
import com.google.cloud.osconfig.v1beta.PatchDeployments;
import com.google.cloud.osconfig.v1beta.PatchJobs;
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
 * gRPC stub implementation for the OsConfigService service API.
 *
 * <p>This class is for advanced usage and reflects the underlying API directly.
 */
@BetaApi
@Generated("by gapic-generator-java")
public class GrpcOsConfigServiceStub extends OsConfigServiceStub {
  private static final MethodDescriptor<PatchJobs.ExecutePatchJobRequest, PatchJobs.PatchJob>
      executePatchJobMethodDescriptor =
          MethodDescriptor.<PatchJobs.ExecutePatchJobRequest, PatchJobs.PatchJob>newBuilder()
              .setType(MethodDescriptor.MethodType.UNARY)
              .setFullMethodName("google.cloud.osconfig.v1beta.OsConfigService/ExecutePatchJob")
              .setRequestMarshaller(
                  ProtoUtils.marshaller(PatchJobs.ExecutePatchJobRequest.getDefaultInstance()))
              .setResponseMarshaller(ProtoUtils.marshaller(PatchJobs.PatchJob.getDefaultInstance()))
              .build();

  private static final MethodDescriptor<PatchJobs.GetPatchJobRequest, PatchJobs.PatchJob>
      getPatchJobMethodDescriptor =
          MethodDescriptor.<PatchJobs.GetPatchJobRequest, PatchJobs.PatchJob>newBuilder()
              .setType(MethodDescriptor.MethodType.UNARY)
              .setFullMethodName("google.cloud.osconfig.v1beta.OsConfigService/GetPatchJob")
              .setRequestMarshaller(
                  ProtoUtils.marshaller(PatchJobs.GetPatchJobRequest.getDefaultInstance()))
              .setResponseMarshaller(ProtoUtils.marshaller(PatchJobs.PatchJob.getDefaultInstance()))
              .build();

  private static final MethodDescriptor<PatchJobs.CancelPatchJobRequest, PatchJobs.PatchJob>
      cancelPatchJobMethodDescriptor =
          MethodDescriptor.<PatchJobs.CancelPatchJobRequest, PatchJobs.PatchJob>newBuilder()
              .setType(MethodDescriptor.MethodType.UNARY)
              .setFullMethodName("google.cloud.osconfig.v1beta.OsConfigService/CancelPatchJob")
              .setRequestMarshaller(
                  ProtoUtils.marshaller(PatchJobs.CancelPatchJobRequest.getDefaultInstance()))
              .setResponseMarshaller(ProtoUtils.marshaller(PatchJobs.PatchJob.getDefaultInstance()))
              .build();

  private static final MethodDescriptor<
          PatchJobs.ListPatchJobsRequest, PatchJobs.ListPatchJobsResponse>
      listPatchJobsMethodDescriptor =
          MethodDescriptor
              .<PatchJobs.ListPatchJobsRequest, PatchJobs.ListPatchJobsResponse>newBuilder()
              .setType(MethodDescriptor.MethodType.UNARY)
              .setFullMethodName("google.cloud.osconfig.v1beta.OsConfigService/ListPatchJobs")
              .setRequestMarshaller(
                  ProtoUtils.marshaller(PatchJobs.ListPatchJobsRequest.getDefaultInstance()))
              .setResponseMarshaller(
                  ProtoUtils.marshaller(PatchJobs.ListPatchJobsResponse.getDefaultInstance()))
              .build();

  private static final MethodDescriptor<
          PatchJobs.ListPatchJobInstanceDetailsRequest,
          PatchJobs.ListPatchJobInstanceDetailsResponse>
      listPatchJobInstanceDetailsMethodDescriptor =
          MethodDescriptor
              .<PatchJobs.ListPatchJobInstanceDetailsRequest,
                  PatchJobs.ListPatchJobInstanceDetailsResponse>
                  newBuilder()
              .setType(MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(
                  "google.cloud.osconfig.v1beta.OsConfigService/ListPatchJobInstanceDetails")
              .setRequestMarshaller(
                  ProtoUtils.marshaller(
                      PatchJobs.ListPatchJobInstanceDetailsRequest.getDefaultInstance()))
              .setResponseMarshaller(
                  ProtoUtils.marshaller(
                      PatchJobs.ListPatchJobInstanceDetailsResponse.getDefaultInstance()))
              .build();

  private static final MethodDescriptor<
          PatchDeployments.CreatePatchDeploymentRequest, PatchDeployments.PatchDeployment>
      createPatchDeploymentMethodDescriptor =
          MethodDescriptor
              .<PatchDeployments.CreatePatchDeploymentRequest, PatchDeployments.PatchDeployment>
                  newBuilder()
              .setType(MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(
                  "google.cloud.osconfig.v1beta.OsConfigService/CreatePatchDeployment")
              .setRequestMarshaller(
                  ProtoUtils.marshaller(
                      PatchDeployments.CreatePatchDeploymentRequest.getDefaultInstance()))
              .setResponseMarshaller(
                  ProtoUtils.marshaller(PatchDeployments.PatchDeployment.getDefaultInstance()))
              .build();

  private static final MethodDescriptor<
          PatchDeployments.GetPatchDeploymentRequest, PatchDeployments.PatchDeployment>
      getPatchDeploymentMethodDescriptor =
          MethodDescriptor
              .<PatchDeployments.GetPatchDeploymentRequest, PatchDeployments.PatchDeployment>
                  newBuilder()
              .setType(MethodDescriptor.MethodType.UNARY)
              .setFullMethodName("google.cloud.osconfig.v1beta.OsConfigService/GetPatchDeployment")
              .setRequestMarshaller(
                  ProtoUtils.marshaller(
                      PatchDeployments.GetPatchDeploymentRequest.getDefaultInstance()))
              .setResponseMarshaller(
                  ProtoUtils.marshaller(PatchDeployments.PatchDeployment.getDefaultInstance()))
              .build();

  private static final MethodDescriptor<
          PatchDeployments.ListPatchDeploymentsRequest,
          PatchDeployments.ListPatchDeploymentsResponse>
      listPatchDeploymentsMethodDescriptor =
          MethodDescriptor
              .<PatchDeployments.ListPatchDeploymentsRequest,
                  PatchDeployments.ListPatchDeploymentsResponse>
                  newBuilder()
              .setType(MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(
                  "google.cloud.osconfig.v1beta.OsConfigService/ListPatchDeployments")
              .setRequestMarshaller(
                  ProtoUtils.marshaller(
                      PatchDeployments.ListPatchDeploymentsRequest.getDefaultInstance()))
              .setResponseMarshaller(
                  ProtoUtils.marshaller(
                      PatchDeployments.ListPatchDeploymentsResponse.getDefaultInstance()))
              .build();

  private static final MethodDescriptor<PatchDeployments.DeletePatchDeploymentRequest, Empty>
      deletePatchDeploymentMethodDescriptor =
          MethodDescriptor.<PatchDeployments.DeletePatchDeploymentRequest, Empty>newBuilder()
              .setType(MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(
                  "google.cloud.osconfig.v1beta.OsConfigService/DeletePatchDeployment")
              .setRequestMarshaller(
                  ProtoUtils.marshaller(
                      PatchDeployments.DeletePatchDeploymentRequest.getDefaultInstance()))
              .setResponseMarshaller(ProtoUtils.marshaller(Empty.getDefaultInstance()))
              .build();

  private static final MethodDescriptor<
          GuestPolicies.CreateGuestPolicyRequest, GuestPolicies.GuestPolicy>
      createGuestPolicyMethodDescriptor =
          MethodDescriptor
              .<GuestPolicies.CreateGuestPolicyRequest, GuestPolicies.GuestPolicy>newBuilder()
              .setType(MethodDescriptor.MethodType.UNARY)
              .setFullMethodName("google.cloud.osconfig.v1beta.OsConfigService/CreateGuestPolicy")
              .setRequestMarshaller(
                  ProtoUtils.marshaller(
                      GuestPolicies.CreateGuestPolicyRequest.getDefaultInstance()))
              .setResponseMarshaller(
                  ProtoUtils.marshaller(GuestPolicies.GuestPolicy.getDefaultInstance()))
              .build();

  private static final MethodDescriptor<
          GuestPolicies.GetGuestPolicyRequest, GuestPolicies.GuestPolicy>
      getGuestPolicyMethodDescriptor =
          MethodDescriptor
              .<GuestPolicies.GetGuestPolicyRequest, GuestPolicies.GuestPolicy>newBuilder()
              .setType(MethodDescriptor.MethodType.UNARY)
              .setFullMethodName("google.cloud.osconfig.v1beta.OsConfigService/GetGuestPolicy")
              .setRequestMarshaller(
                  ProtoUtils.marshaller(GuestPolicies.GetGuestPolicyRequest.getDefaultInstance()))
              .setResponseMarshaller(
                  ProtoUtils.marshaller(GuestPolicies.GuestPolicy.getDefaultInstance()))
              .build();

  private static final MethodDescriptor<
          GuestPolicies.ListGuestPoliciesRequest, GuestPolicies.ListGuestPoliciesResponse>
      listGuestPoliciesMethodDescriptor =
          MethodDescriptor
              .<GuestPolicies.ListGuestPoliciesRequest, GuestPolicies.ListGuestPoliciesResponse>
                  newBuilder()
              .setType(MethodDescriptor.MethodType.UNARY)
              .setFullMethodName("google.cloud.osconfig.v1beta.OsConfigService/ListGuestPolicies")
              .setRequestMarshaller(
                  ProtoUtils.marshaller(
                      GuestPolicies.ListGuestPoliciesRequest.getDefaultInstance()))
              .setResponseMarshaller(
                  ProtoUtils.marshaller(
                      GuestPolicies.ListGuestPoliciesResponse.getDefaultInstance()))
              .build();

  private static final MethodDescriptor<
          GuestPolicies.UpdateGuestPolicyRequest, GuestPolicies.GuestPolicy>
      updateGuestPolicyMethodDescriptor =
          MethodDescriptor
              .<GuestPolicies.UpdateGuestPolicyRequest, GuestPolicies.GuestPolicy>newBuilder()
              .setType(MethodDescriptor.MethodType.UNARY)
              .setFullMethodName("google.cloud.osconfig.v1beta.OsConfigService/UpdateGuestPolicy")
              .setRequestMarshaller(
                  ProtoUtils.marshaller(
                      GuestPolicies.UpdateGuestPolicyRequest.getDefaultInstance()))
              .setResponseMarshaller(
                  ProtoUtils.marshaller(GuestPolicies.GuestPolicy.getDefaultInstance()))
              .build();

  private static final MethodDescriptor<GuestPolicies.DeleteGuestPolicyRequest, Empty>
      deleteGuestPolicyMethodDescriptor =
          MethodDescriptor.<GuestPolicies.DeleteGuestPolicyRequest, Empty>newBuilder()
              .setType(MethodDescriptor.MethodType.UNARY)
              .setFullMethodName("google.cloud.osconfig.v1beta.OsConfigService/DeleteGuestPolicy")
              .setRequestMarshaller(
                  ProtoUtils.marshaller(
                      GuestPolicies.DeleteGuestPolicyRequest.getDefaultInstance()))
              .setResponseMarshaller(ProtoUtils.marshaller(Empty.getDefaultInstance()))
              .build();

  private static final MethodDescriptor<
          GuestPolicies.LookupEffectiveGuestPolicyRequest, GuestPolicies.EffectiveGuestPolicy>
      lookupEffectiveGuestPolicyMethodDescriptor =
          MethodDescriptor
              .<GuestPolicies.LookupEffectiveGuestPolicyRequest, GuestPolicies.EffectiveGuestPolicy>
                  newBuilder()
              .setType(MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(
                  "google.cloud.osconfig.v1beta.OsConfigService/LookupEffectiveGuestPolicy")
              .setRequestMarshaller(
                  ProtoUtils.marshaller(
                      GuestPolicies.LookupEffectiveGuestPolicyRequest.getDefaultInstance()))
              .setResponseMarshaller(
                  ProtoUtils.marshaller(GuestPolicies.EffectiveGuestPolicy.getDefaultInstance()))
              .build();

  private final UnaryCallable<PatchJobs.ExecutePatchJobRequest, PatchJobs.PatchJob>
      executePatchJobCallable;
  private final UnaryCallable<PatchJobs.GetPatchJobRequest, PatchJobs.PatchJob> getPatchJobCallable;
  private final UnaryCallable<PatchJobs.CancelPatchJobRequest, PatchJobs.PatchJob>
      cancelPatchJobCallable;
  private final UnaryCallable<PatchJobs.ListPatchJobsRequest, PatchJobs.ListPatchJobsResponse>
      listPatchJobsCallable;
  private final UnaryCallable<PatchJobs.ListPatchJobsRequest, ListPatchJobsPagedResponse>
      listPatchJobsPagedCallable;
  private final UnaryCallable<
          PatchJobs.ListPatchJobInstanceDetailsRequest,
          PatchJobs.ListPatchJobInstanceDetailsResponse>
      listPatchJobInstanceDetailsCallable;
  private final UnaryCallable<
          PatchJobs.ListPatchJobInstanceDetailsRequest, ListPatchJobInstanceDetailsPagedResponse>
      listPatchJobInstanceDetailsPagedCallable;
  private final UnaryCallable<
          PatchDeployments.CreatePatchDeploymentRequest, PatchDeployments.PatchDeployment>
      createPatchDeploymentCallable;
  private final UnaryCallable<
          PatchDeployments.GetPatchDeploymentRequest, PatchDeployments.PatchDeployment>
      getPatchDeploymentCallable;
  private final UnaryCallable<
          PatchDeployments.ListPatchDeploymentsRequest,
          PatchDeployments.ListPatchDeploymentsResponse>
      listPatchDeploymentsCallable;
  private final UnaryCallable<
          PatchDeployments.ListPatchDeploymentsRequest, ListPatchDeploymentsPagedResponse>
      listPatchDeploymentsPagedCallable;
  private final UnaryCallable<PatchDeployments.DeletePatchDeploymentRequest, Empty>
      deletePatchDeploymentCallable;
  private final UnaryCallable<GuestPolicies.CreateGuestPolicyRequest, GuestPolicies.GuestPolicy>
      createGuestPolicyCallable;
  private final UnaryCallable<GuestPolicies.GetGuestPolicyRequest, GuestPolicies.GuestPolicy>
      getGuestPolicyCallable;
  private final UnaryCallable<
          GuestPolicies.ListGuestPoliciesRequest, GuestPolicies.ListGuestPoliciesResponse>
      listGuestPoliciesCallable;
  private final UnaryCallable<
          GuestPolicies.ListGuestPoliciesRequest, ListGuestPoliciesPagedResponse>
      listGuestPoliciesPagedCallable;
  private final UnaryCallable<GuestPolicies.UpdateGuestPolicyRequest, GuestPolicies.GuestPolicy>
      updateGuestPolicyCallable;
  private final UnaryCallable<GuestPolicies.DeleteGuestPolicyRequest, Empty>
      deleteGuestPolicyCallable;
  private final UnaryCallable<
          GuestPolicies.LookupEffectiveGuestPolicyRequest, GuestPolicies.EffectiveGuestPolicy>
      lookupEffectiveGuestPolicyCallable;

  private final BackgroundResource backgroundResources;
  private final GrpcOperationsStub operationsStub;
  private final GrpcStubCallableFactory callableFactory;

  public static final GrpcOsConfigServiceStub create(OsConfigServiceStubSettings settings)
      throws IOException {
    return new GrpcOsConfigServiceStub(settings, ClientContext.create(settings));
  }

  public static final GrpcOsConfigServiceStub create(ClientContext clientContext)
      throws IOException {
    return new GrpcOsConfigServiceStub(
        OsConfigServiceStubSettings.newBuilder().build(), clientContext);
  }

  public static final GrpcOsConfigServiceStub create(
      ClientContext clientContext, GrpcStubCallableFactory callableFactory) throws IOException {
    return new GrpcOsConfigServiceStub(
        OsConfigServiceStubSettings.newBuilder().build(), clientContext, callableFactory);
  }

  /**
   * Constructs an instance of GrpcOsConfigServiceStub, using the given settings. This is protected
   * so that it is easy to make a subclass, but otherwise, the static factory methods should be
   * preferred.
   */
  protected GrpcOsConfigServiceStub(
      OsConfigServiceStubSettings settings, ClientContext clientContext) throws IOException {
    this(settings, clientContext, new GrpcOsConfigServiceCallableFactory());
  }

  /**
   * Constructs an instance of GrpcOsConfigServiceStub, using the given settings. This is protected
   * so that it is easy to make a subclass, but otherwise, the static factory methods should be
   * preferred.
   */
  protected GrpcOsConfigServiceStub(
      OsConfigServiceStubSettings settings,
      ClientContext clientContext,
      GrpcStubCallableFactory callableFactory)
      throws IOException {
    this.callableFactory = callableFactory;
    this.operationsStub = GrpcOperationsStub.create(clientContext, callableFactory);

    GrpcCallSettings<PatchJobs.ExecutePatchJobRequest, PatchJobs.PatchJob>
        executePatchJobTransportSettings =
            GrpcCallSettings.<PatchJobs.ExecutePatchJobRequest, PatchJobs.PatchJob>newBuilder()
                .setMethodDescriptor(executePatchJobMethodDescriptor)
                .setParamsExtractor(
                    new RequestParamsExtractor<PatchJobs.ExecutePatchJobRequest>() {
                      @Override
                      public Map<String, String> extract(PatchJobs.ExecutePatchJobRequest request) {
                        ImmutableMap.Builder<String, String> params = ImmutableMap.builder();
                        params.put("parent", String.valueOf(request.getParent()));
                        return params.build();
                      }
                    })
                .build();
    GrpcCallSettings<PatchJobs.GetPatchJobRequest, PatchJobs.PatchJob>
        getPatchJobTransportSettings =
            GrpcCallSettings.<PatchJobs.GetPatchJobRequest, PatchJobs.PatchJob>newBuilder()
                .setMethodDescriptor(getPatchJobMethodDescriptor)
                .setParamsExtractor(
                    new RequestParamsExtractor<PatchJobs.GetPatchJobRequest>() {
                      @Override
                      public Map<String, String> extract(PatchJobs.GetPatchJobRequest request) {
                        ImmutableMap.Builder<String, String> params = ImmutableMap.builder();
                        params.put("name", String.valueOf(request.getName()));
                        return params.build();
                      }
                    })
                .build();
    GrpcCallSettings<PatchJobs.CancelPatchJobRequest, PatchJobs.PatchJob>
        cancelPatchJobTransportSettings =
            GrpcCallSettings.<PatchJobs.CancelPatchJobRequest, PatchJobs.PatchJob>newBuilder()
                .setMethodDescriptor(cancelPatchJobMethodDescriptor)
                .setParamsExtractor(
                    new RequestParamsExtractor<PatchJobs.CancelPatchJobRequest>() {
                      @Override
                      public Map<String, String> extract(PatchJobs.CancelPatchJobRequest request) {
                        ImmutableMap.Builder<String, String> params = ImmutableMap.builder();
                        params.put("name", String.valueOf(request.getName()));
                        return params.build();
                      }
                    })
                .build();
    GrpcCallSettings<PatchJobs.ListPatchJobsRequest, PatchJobs.ListPatchJobsResponse>
        listPatchJobsTransportSettings =
            GrpcCallSettings
                .<PatchJobs.ListPatchJobsRequest, PatchJobs.ListPatchJobsResponse>newBuilder()
                .setMethodDescriptor(listPatchJobsMethodDescriptor)
                .setParamsExtractor(
                    new RequestParamsExtractor<PatchJobs.ListPatchJobsRequest>() {
                      @Override
                      public Map<String, String> extract(PatchJobs.ListPatchJobsRequest request) {
                        ImmutableMap.Builder<String, String> params = ImmutableMap.builder();
                        params.put("parent", String.valueOf(request.getParent()));
                        return params.build();
                      }
                    })
                .build();
    GrpcCallSettings<
            PatchJobs.ListPatchJobInstanceDetailsRequest,
            PatchJobs.ListPatchJobInstanceDetailsResponse>
        listPatchJobInstanceDetailsTransportSettings =
            GrpcCallSettings
                .<PatchJobs.ListPatchJobInstanceDetailsRequest,
                    PatchJobs.ListPatchJobInstanceDetailsResponse>
                    newBuilder()
                .setMethodDescriptor(listPatchJobInstanceDetailsMethodDescriptor)
                .setParamsExtractor(
                    new RequestParamsExtractor<PatchJobs.ListPatchJobInstanceDetailsRequest>() {
                      @Override
                      public Map<String, String> extract(
                          PatchJobs.ListPatchJobInstanceDetailsRequest request) {
                        ImmutableMap.Builder<String, String> params = ImmutableMap.builder();
                        params.put("parent", String.valueOf(request.getParent()));
                        return params.build();
                      }
                    })
                .build();
    GrpcCallSettings<
            PatchDeployments.CreatePatchDeploymentRequest, PatchDeployments.PatchDeployment>
        createPatchDeploymentTransportSettings =
            GrpcCallSettings
                .<PatchDeployments.CreatePatchDeploymentRequest, PatchDeployments.PatchDeployment>
                    newBuilder()
                .setMethodDescriptor(createPatchDeploymentMethodDescriptor)
                .setParamsExtractor(
                    new RequestParamsExtractor<PatchDeployments.CreatePatchDeploymentRequest>() {
                      @Override
                      public Map<String, String> extract(
                          PatchDeployments.CreatePatchDeploymentRequest request) {
                        ImmutableMap.Builder<String, String> params = ImmutableMap.builder();
                        params.put("parent", String.valueOf(request.getParent()));
                        return params.build();
                      }
                    })
                .build();
    GrpcCallSettings<PatchDeployments.GetPatchDeploymentRequest, PatchDeployments.PatchDeployment>
        getPatchDeploymentTransportSettings =
            GrpcCallSettings
                .<PatchDeployments.GetPatchDeploymentRequest, PatchDeployments.PatchDeployment>
                    newBuilder()
                .setMethodDescriptor(getPatchDeploymentMethodDescriptor)
                .setParamsExtractor(
                    new RequestParamsExtractor<PatchDeployments.GetPatchDeploymentRequest>() {
                      @Override
                      public Map<String, String> extract(
                          PatchDeployments.GetPatchDeploymentRequest request) {
                        ImmutableMap.Builder<String, String> params = ImmutableMap.builder();
                        params.put("name", String.valueOf(request.getName()));
                        return params.build();
                      }
                    })
                .build();
    GrpcCallSettings<
            PatchDeployments.ListPatchDeploymentsRequest,
            PatchDeployments.ListPatchDeploymentsResponse>
        listPatchDeploymentsTransportSettings =
            GrpcCallSettings
                .<PatchDeployments.ListPatchDeploymentsRequest,
                    PatchDeployments.ListPatchDeploymentsResponse>
                    newBuilder()
                .setMethodDescriptor(listPatchDeploymentsMethodDescriptor)
                .setParamsExtractor(
                    new RequestParamsExtractor<PatchDeployments.ListPatchDeploymentsRequest>() {
                      @Override
                      public Map<String, String> extract(
                          PatchDeployments.ListPatchDeploymentsRequest request) {
                        ImmutableMap.Builder<String, String> params = ImmutableMap.builder();
                        params.put("parent", String.valueOf(request.getParent()));
                        return params.build();
                      }
                    })
                .build();
    GrpcCallSettings<PatchDeployments.DeletePatchDeploymentRequest, Empty>
        deletePatchDeploymentTransportSettings =
            GrpcCallSettings.<PatchDeployments.DeletePatchDeploymentRequest, Empty>newBuilder()
                .setMethodDescriptor(deletePatchDeploymentMethodDescriptor)
                .setParamsExtractor(
                    new RequestParamsExtractor<PatchDeployments.DeletePatchDeploymentRequest>() {
                      @Override
                      public Map<String, String> extract(
                          PatchDeployments.DeletePatchDeploymentRequest request) {
                        ImmutableMap.Builder<String, String> params = ImmutableMap.builder();
                        params.put("name", String.valueOf(request.getName()));
                        return params.build();
                      }
                    })
                .build();
    GrpcCallSettings<GuestPolicies.CreateGuestPolicyRequest, GuestPolicies.GuestPolicy>
        createGuestPolicyTransportSettings =
            GrpcCallSettings
                .<GuestPolicies.CreateGuestPolicyRequest, GuestPolicies.GuestPolicy>newBuilder()
                .setMethodDescriptor(createGuestPolicyMethodDescriptor)
                .setParamsExtractor(
                    new RequestParamsExtractor<GuestPolicies.CreateGuestPolicyRequest>() {
                      @Override
                      public Map<String, String> extract(
                          GuestPolicies.CreateGuestPolicyRequest request) {
                        ImmutableMap.Builder<String, String> params = ImmutableMap.builder();
                        params.put("parent", String.valueOf(request.getParent()));
                        return params.build();
                      }
                    })
                .build();
    GrpcCallSettings<GuestPolicies.GetGuestPolicyRequest, GuestPolicies.GuestPolicy>
        getGuestPolicyTransportSettings =
            GrpcCallSettings
                .<GuestPolicies.GetGuestPolicyRequest, GuestPolicies.GuestPolicy>newBuilder()
                .setMethodDescriptor(getGuestPolicyMethodDescriptor)
                .setParamsExtractor(
                    new RequestParamsExtractor<GuestPolicies.GetGuestPolicyRequest>() {
                      @Override
                      public Map<String, String> extract(
                          GuestPolicies.GetGuestPolicyRequest request) {
                        ImmutableMap.Builder<String, String> params = ImmutableMap.builder();
                        params.put("name", String.valueOf(request.getName()));
                        return params.build();
                      }
                    })
                .build();
    GrpcCallSettings<
            GuestPolicies.ListGuestPoliciesRequest, GuestPolicies.ListGuestPoliciesResponse>
        listGuestPoliciesTransportSettings =
            GrpcCallSettings
                .<GuestPolicies.ListGuestPoliciesRequest, GuestPolicies.ListGuestPoliciesResponse>
                    newBuilder()
                .setMethodDescriptor(listGuestPoliciesMethodDescriptor)
                .setParamsExtractor(
                    new RequestParamsExtractor<GuestPolicies.ListGuestPoliciesRequest>() {
                      @Override
                      public Map<String, String> extract(
                          GuestPolicies.ListGuestPoliciesRequest request) {
                        ImmutableMap.Builder<String, String> params = ImmutableMap.builder();
                        params.put("parent", String.valueOf(request.getParent()));
                        return params.build();
                      }
                    })
                .build();
    GrpcCallSettings<GuestPolicies.UpdateGuestPolicyRequest, GuestPolicies.GuestPolicy>
        updateGuestPolicyTransportSettings =
            GrpcCallSettings
                .<GuestPolicies.UpdateGuestPolicyRequest, GuestPolicies.GuestPolicy>newBuilder()
                .setMethodDescriptor(updateGuestPolicyMethodDescriptor)
                .setParamsExtractor(
                    new RequestParamsExtractor<GuestPolicies.UpdateGuestPolicyRequest>() {
                      @Override
                      public Map<String, String> extract(
                          GuestPolicies.UpdateGuestPolicyRequest request) {
                        ImmutableMap.Builder<String, String> params = ImmutableMap.builder();
                        params.put(
                            "guest_policy.name",
                            String.valueOf(request.getGuestPolicy().getName()));
                        return params.build();
                      }
                    })
                .build();
    GrpcCallSettings<GuestPolicies.DeleteGuestPolicyRequest, Empty>
        deleteGuestPolicyTransportSettings =
            GrpcCallSettings.<GuestPolicies.DeleteGuestPolicyRequest, Empty>newBuilder()
                .setMethodDescriptor(deleteGuestPolicyMethodDescriptor)
                .setParamsExtractor(
                    new RequestParamsExtractor<GuestPolicies.DeleteGuestPolicyRequest>() {
                      @Override
                      public Map<String, String> extract(
                          GuestPolicies.DeleteGuestPolicyRequest request) {
                        ImmutableMap.Builder<String, String> params = ImmutableMap.builder();
                        params.put("name", String.valueOf(request.getName()));
                        return params.build();
                      }
                    })
                .build();
    GrpcCallSettings<
            GuestPolicies.LookupEffectiveGuestPolicyRequest, GuestPolicies.EffectiveGuestPolicy>
        lookupEffectiveGuestPolicyTransportSettings =
            GrpcCallSettings
                .<GuestPolicies.LookupEffectiveGuestPolicyRequest,
                    GuestPolicies.EffectiveGuestPolicy>
                    newBuilder()
                .setMethodDescriptor(lookupEffectiveGuestPolicyMethodDescriptor)
                .setParamsExtractor(
                    new RequestParamsExtractor<GuestPolicies.LookupEffectiveGuestPolicyRequest>() {
                      @Override
                      public Map<String, String> extract(
                          GuestPolicies.LookupEffectiveGuestPolicyRequest request) {
                        ImmutableMap.Builder<String, String> params = ImmutableMap.builder();
                        params.put("instance", String.valueOf(request.getInstance()));
                        return params.build();
                      }
                    })
                .build();

    this.executePatchJobCallable =
        callableFactory.createUnaryCallable(
            executePatchJobTransportSettings, settings.executePatchJobSettings(), clientContext);
    this.getPatchJobCallable =
        callableFactory.createUnaryCallable(
            getPatchJobTransportSettings, settings.getPatchJobSettings(), clientContext);
    this.cancelPatchJobCallable =
        callableFactory.createUnaryCallable(
            cancelPatchJobTransportSettings, settings.cancelPatchJobSettings(), clientContext);
    this.listPatchJobsCallable =
        callableFactory.createUnaryCallable(
            listPatchJobsTransportSettings, settings.listPatchJobsSettings(), clientContext);
    this.listPatchJobsPagedCallable =
        callableFactory.createPagedCallable(
            listPatchJobsTransportSettings, settings.listPatchJobsSettings(), clientContext);
    this.listPatchJobInstanceDetailsCallable =
        callableFactory.createUnaryCallable(
            listPatchJobInstanceDetailsTransportSettings,
            settings.listPatchJobInstanceDetailsSettings(),
            clientContext);
    this.listPatchJobInstanceDetailsPagedCallable =
        callableFactory.createPagedCallable(
            listPatchJobInstanceDetailsTransportSettings,
            settings.listPatchJobInstanceDetailsSettings(),
            clientContext);
    this.createPatchDeploymentCallable =
        callableFactory.createUnaryCallable(
            createPatchDeploymentTransportSettings,
            settings.createPatchDeploymentSettings(),
            clientContext);
    this.getPatchDeploymentCallable =
        callableFactory.createUnaryCallable(
            getPatchDeploymentTransportSettings,
            settings.getPatchDeploymentSettings(),
            clientContext);
    this.listPatchDeploymentsCallable =
        callableFactory.createUnaryCallable(
            listPatchDeploymentsTransportSettings,
            settings.listPatchDeploymentsSettings(),
            clientContext);
    this.listPatchDeploymentsPagedCallable =
        callableFactory.createPagedCallable(
            listPatchDeploymentsTransportSettings,
            settings.listPatchDeploymentsSettings(),
            clientContext);
    this.deletePatchDeploymentCallable =
        callableFactory.createUnaryCallable(
            deletePatchDeploymentTransportSettings,
            settings.deletePatchDeploymentSettings(),
            clientContext);
    this.createGuestPolicyCallable =
        callableFactory.createUnaryCallable(
            createGuestPolicyTransportSettings,
            settings.createGuestPolicySettings(),
            clientContext);
    this.getGuestPolicyCallable =
        callableFactory.createUnaryCallable(
            getGuestPolicyTransportSettings, settings.getGuestPolicySettings(), clientContext);
    this.listGuestPoliciesCallable =
        callableFactory.createUnaryCallable(
            listGuestPoliciesTransportSettings,
            settings.listGuestPoliciesSettings(),
            clientContext);
    this.listGuestPoliciesPagedCallable =
        callableFactory.createPagedCallable(
            listGuestPoliciesTransportSettings,
            settings.listGuestPoliciesSettings(),
            clientContext);
    this.updateGuestPolicyCallable =
        callableFactory.createUnaryCallable(
            updateGuestPolicyTransportSettings,
            settings.updateGuestPolicySettings(),
            clientContext);
    this.deleteGuestPolicyCallable =
        callableFactory.createUnaryCallable(
            deleteGuestPolicyTransportSettings,
            settings.deleteGuestPolicySettings(),
            clientContext);
    this.lookupEffectiveGuestPolicyCallable =
        callableFactory.createUnaryCallable(
            lookupEffectiveGuestPolicyTransportSettings,
            settings.lookupEffectiveGuestPolicySettings(),
            clientContext);

    this.backgroundResources =
        new BackgroundResourceAggregation(clientContext.getBackgroundResources());
  }

  public GrpcOperationsStub getOperationsStub() {
    return operationsStub;
  }

  @Override
  public UnaryCallable<PatchJobs.ExecutePatchJobRequest, PatchJobs.PatchJob>
      executePatchJobCallable() {
    return executePatchJobCallable;
  }

  @Override
  public UnaryCallable<PatchJobs.GetPatchJobRequest, PatchJobs.PatchJob> getPatchJobCallable() {
    return getPatchJobCallable;
  }

  @Override
  public UnaryCallable<PatchJobs.CancelPatchJobRequest, PatchJobs.PatchJob>
      cancelPatchJobCallable() {
    return cancelPatchJobCallable;
  }

  @Override
  public UnaryCallable<PatchJobs.ListPatchJobsRequest, PatchJobs.ListPatchJobsResponse>
      listPatchJobsCallable() {
    return listPatchJobsCallable;
  }

  @Override
  public UnaryCallable<PatchJobs.ListPatchJobsRequest, ListPatchJobsPagedResponse>
      listPatchJobsPagedCallable() {
    return listPatchJobsPagedCallable;
  }

  @Override
  public UnaryCallable<
          PatchJobs.ListPatchJobInstanceDetailsRequest,
          PatchJobs.ListPatchJobInstanceDetailsResponse>
      listPatchJobInstanceDetailsCallable() {
    return listPatchJobInstanceDetailsCallable;
  }

  @Override
  public UnaryCallable<
          PatchJobs.ListPatchJobInstanceDetailsRequest, ListPatchJobInstanceDetailsPagedResponse>
      listPatchJobInstanceDetailsPagedCallable() {
    return listPatchJobInstanceDetailsPagedCallable;
  }

  @Override
  public UnaryCallable<
          PatchDeployments.CreatePatchDeploymentRequest, PatchDeployments.PatchDeployment>
      createPatchDeploymentCallable() {
    return createPatchDeploymentCallable;
  }

  @Override
  public UnaryCallable<PatchDeployments.GetPatchDeploymentRequest, PatchDeployments.PatchDeployment>
      getPatchDeploymentCallable() {
    return getPatchDeploymentCallable;
  }

  @Override
  public UnaryCallable<
          PatchDeployments.ListPatchDeploymentsRequest,
          PatchDeployments.ListPatchDeploymentsResponse>
      listPatchDeploymentsCallable() {
    return listPatchDeploymentsCallable;
  }

  @Override
  public UnaryCallable<
          PatchDeployments.ListPatchDeploymentsRequest, ListPatchDeploymentsPagedResponse>
      listPatchDeploymentsPagedCallable() {
    return listPatchDeploymentsPagedCallable;
  }

  @Override
  public UnaryCallable<PatchDeployments.DeletePatchDeploymentRequest, Empty>
      deletePatchDeploymentCallable() {
    return deletePatchDeploymentCallable;
  }

  @Override
  public UnaryCallable<GuestPolicies.CreateGuestPolicyRequest, GuestPolicies.GuestPolicy>
      createGuestPolicyCallable() {
    return createGuestPolicyCallable;
  }

  @Override
  public UnaryCallable<GuestPolicies.GetGuestPolicyRequest, GuestPolicies.GuestPolicy>
      getGuestPolicyCallable() {
    return getGuestPolicyCallable;
  }

  @Override
  public UnaryCallable<
          GuestPolicies.ListGuestPoliciesRequest, GuestPolicies.ListGuestPoliciesResponse>
      listGuestPoliciesCallable() {
    return listGuestPoliciesCallable;
  }

  @Override
  public UnaryCallable<GuestPolicies.ListGuestPoliciesRequest, ListGuestPoliciesPagedResponse>
      listGuestPoliciesPagedCallable() {
    return listGuestPoliciesPagedCallable;
  }

  @Override
  public UnaryCallable<GuestPolicies.UpdateGuestPolicyRequest, GuestPolicies.GuestPolicy>
      updateGuestPolicyCallable() {
    return updateGuestPolicyCallable;
  }

  @Override
  public UnaryCallable<GuestPolicies.DeleteGuestPolicyRequest, Empty> deleteGuestPolicyCallable() {
    return deleteGuestPolicyCallable;
  }

  @Override
  public UnaryCallable<
          GuestPolicies.LookupEffectiveGuestPolicyRequest, GuestPolicies.EffectiveGuestPolicy>
      lookupEffectiveGuestPolicyCallable() {
    return lookupEffectiveGuestPolicyCallable;
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
