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

package com.google.cloud.recaptchaenterprise.v1.stub;

import static com.google.cloud.recaptchaenterprise.v1.RecaptchaEnterpriseServiceClient.ListFirewallPoliciesPagedResponse;
import static com.google.cloud.recaptchaenterprise.v1.RecaptchaEnterpriseServiceClient.ListIpOverridesPagedResponse;
import static com.google.cloud.recaptchaenterprise.v1.RecaptchaEnterpriseServiceClient.ListKeysPagedResponse;
import static com.google.cloud.recaptchaenterprise.v1.RecaptchaEnterpriseServiceClient.ListRelatedAccountGroupMembershipsPagedResponse;
import static com.google.cloud.recaptchaenterprise.v1.RecaptchaEnterpriseServiceClient.ListRelatedAccountGroupsPagedResponse;
import static com.google.cloud.recaptchaenterprise.v1.RecaptchaEnterpriseServiceClient.SearchRelatedAccountGroupMembershipsPagedResponse;

import com.google.api.gax.core.BackgroundResource;
import com.google.api.gax.core.BackgroundResourceAggregation;
import com.google.api.gax.grpc.GrpcCallSettings;
import com.google.api.gax.grpc.GrpcStubCallableFactory;
import com.google.api.gax.rpc.ClientContext;
import com.google.api.gax.rpc.RequestParamsBuilder;
import com.google.api.gax.rpc.UnaryCallable;
import com.google.longrunning.stub.GrpcOperationsStub;
import com.google.protobuf.Empty;
import com.google.recaptchaenterprise.v1.AddIpOverrideRequest;
import com.google.recaptchaenterprise.v1.AddIpOverrideResponse;
import com.google.recaptchaenterprise.v1.AnnotateAssessmentRequest;
import com.google.recaptchaenterprise.v1.AnnotateAssessmentResponse;
import com.google.recaptchaenterprise.v1.Assessment;
import com.google.recaptchaenterprise.v1.CreateAssessmentRequest;
import com.google.recaptchaenterprise.v1.CreateFirewallPolicyRequest;
import com.google.recaptchaenterprise.v1.CreateKeyRequest;
import com.google.recaptchaenterprise.v1.DeleteFirewallPolicyRequest;
import com.google.recaptchaenterprise.v1.DeleteKeyRequest;
import com.google.recaptchaenterprise.v1.FirewallPolicy;
import com.google.recaptchaenterprise.v1.GetFirewallPolicyRequest;
import com.google.recaptchaenterprise.v1.GetKeyRequest;
import com.google.recaptchaenterprise.v1.GetMetricsRequest;
import com.google.recaptchaenterprise.v1.Key;
import com.google.recaptchaenterprise.v1.ListFirewallPoliciesRequest;
import com.google.recaptchaenterprise.v1.ListFirewallPoliciesResponse;
import com.google.recaptchaenterprise.v1.ListIpOverridesRequest;
import com.google.recaptchaenterprise.v1.ListIpOverridesResponse;
import com.google.recaptchaenterprise.v1.ListKeysRequest;
import com.google.recaptchaenterprise.v1.ListKeysResponse;
import com.google.recaptchaenterprise.v1.ListRelatedAccountGroupMembershipsRequest;
import com.google.recaptchaenterprise.v1.ListRelatedAccountGroupMembershipsResponse;
import com.google.recaptchaenterprise.v1.ListRelatedAccountGroupsRequest;
import com.google.recaptchaenterprise.v1.ListRelatedAccountGroupsResponse;
import com.google.recaptchaenterprise.v1.Metrics;
import com.google.recaptchaenterprise.v1.MigrateKeyRequest;
import com.google.recaptchaenterprise.v1.RemoveIpOverrideRequest;
import com.google.recaptchaenterprise.v1.RemoveIpOverrideResponse;
import com.google.recaptchaenterprise.v1.ReorderFirewallPoliciesRequest;
import com.google.recaptchaenterprise.v1.ReorderFirewallPoliciesResponse;
import com.google.recaptchaenterprise.v1.RetrieveLegacySecretKeyRequest;
import com.google.recaptchaenterprise.v1.RetrieveLegacySecretKeyResponse;
import com.google.recaptchaenterprise.v1.SearchRelatedAccountGroupMembershipsRequest;
import com.google.recaptchaenterprise.v1.SearchRelatedAccountGroupMembershipsResponse;
import com.google.recaptchaenterprise.v1.UpdateFirewallPolicyRequest;
import com.google.recaptchaenterprise.v1.UpdateKeyRequest;
import io.grpc.MethodDescriptor;
import io.grpc.protobuf.ProtoUtils;
import java.io.IOException;
import java.util.concurrent.TimeUnit;
import javax.annotation.Generated;

// AUTO-GENERATED DOCUMENTATION AND CLASS.
/**
 * gRPC stub implementation for the RecaptchaEnterpriseService service API.
 *
 * <p>This class is for advanced usage and reflects the underlying API directly.
 */
@Generated("by gapic-generator-java")
public class GrpcRecaptchaEnterpriseServiceStub extends RecaptchaEnterpriseServiceStub {
  private static final MethodDescriptor<CreateAssessmentRequest, Assessment>
      createAssessmentMethodDescriptor =
          MethodDescriptor.<CreateAssessmentRequest, Assessment>newBuilder()
              .setType(MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(
                  "google.cloud.recaptchaenterprise.v1.RecaptchaEnterpriseService/CreateAssessment")
              .setRequestMarshaller(
                  ProtoUtils.marshaller(CreateAssessmentRequest.getDefaultInstance()))
              .setResponseMarshaller(ProtoUtils.marshaller(Assessment.getDefaultInstance()))
              .setSampledToLocalTracing(true)
              .build();

  private static final MethodDescriptor<AnnotateAssessmentRequest, AnnotateAssessmentResponse>
      annotateAssessmentMethodDescriptor =
          MethodDescriptor.<AnnotateAssessmentRequest, AnnotateAssessmentResponse>newBuilder()
              .setType(MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(
                  "google.cloud.recaptchaenterprise.v1.RecaptchaEnterpriseService/AnnotateAssessment")
              .setRequestMarshaller(
                  ProtoUtils.marshaller(AnnotateAssessmentRequest.getDefaultInstance()))
              .setResponseMarshaller(
                  ProtoUtils.marshaller(AnnotateAssessmentResponse.getDefaultInstance()))
              .setSampledToLocalTracing(true)
              .build();

  private static final MethodDescriptor<CreateKeyRequest, Key> createKeyMethodDescriptor =
      MethodDescriptor.<CreateKeyRequest, Key>newBuilder()
          .setType(MethodDescriptor.MethodType.UNARY)
          .setFullMethodName(
              "google.cloud.recaptchaenterprise.v1.RecaptchaEnterpriseService/CreateKey")
          .setRequestMarshaller(ProtoUtils.marshaller(CreateKeyRequest.getDefaultInstance()))
          .setResponseMarshaller(ProtoUtils.marshaller(Key.getDefaultInstance()))
          .setSampledToLocalTracing(true)
          .build();

  private static final MethodDescriptor<ListKeysRequest, ListKeysResponse>
      listKeysMethodDescriptor =
          MethodDescriptor.<ListKeysRequest, ListKeysResponse>newBuilder()
              .setType(MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(
                  "google.cloud.recaptchaenterprise.v1.RecaptchaEnterpriseService/ListKeys")
              .setRequestMarshaller(ProtoUtils.marshaller(ListKeysRequest.getDefaultInstance()))
              .setResponseMarshaller(ProtoUtils.marshaller(ListKeysResponse.getDefaultInstance()))
              .setSampledToLocalTracing(true)
              .build();

  private static final MethodDescriptor<
          RetrieveLegacySecretKeyRequest, RetrieveLegacySecretKeyResponse>
      retrieveLegacySecretKeyMethodDescriptor =
          MethodDescriptor
              .<RetrieveLegacySecretKeyRequest, RetrieveLegacySecretKeyResponse>newBuilder()
              .setType(MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(
                  "google.cloud.recaptchaenterprise.v1.RecaptchaEnterpriseService/RetrieveLegacySecretKey")
              .setRequestMarshaller(
                  ProtoUtils.marshaller(RetrieveLegacySecretKeyRequest.getDefaultInstance()))
              .setResponseMarshaller(
                  ProtoUtils.marshaller(RetrieveLegacySecretKeyResponse.getDefaultInstance()))
              .setSampledToLocalTracing(true)
              .build();

  private static final MethodDescriptor<GetKeyRequest, Key> getKeyMethodDescriptor =
      MethodDescriptor.<GetKeyRequest, Key>newBuilder()
          .setType(MethodDescriptor.MethodType.UNARY)
          .setFullMethodName(
              "google.cloud.recaptchaenterprise.v1.RecaptchaEnterpriseService/GetKey")
          .setRequestMarshaller(ProtoUtils.marshaller(GetKeyRequest.getDefaultInstance()))
          .setResponseMarshaller(ProtoUtils.marshaller(Key.getDefaultInstance()))
          .setSampledToLocalTracing(true)
          .build();

  private static final MethodDescriptor<UpdateKeyRequest, Key> updateKeyMethodDescriptor =
      MethodDescriptor.<UpdateKeyRequest, Key>newBuilder()
          .setType(MethodDescriptor.MethodType.UNARY)
          .setFullMethodName(
              "google.cloud.recaptchaenterprise.v1.RecaptchaEnterpriseService/UpdateKey")
          .setRequestMarshaller(ProtoUtils.marshaller(UpdateKeyRequest.getDefaultInstance()))
          .setResponseMarshaller(ProtoUtils.marshaller(Key.getDefaultInstance()))
          .setSampledToLocalTracing(true)
          .build();

  private static final MethodDescriptor<DeleteKeyRequest, Empty> deleteKeyMethodDescriptor =
      MethodDescriptor.<DeleteKeyRequest, Empty>newBuilder()
          .setType(MethodDescriptor.MethodType.UNARY)
          .setFullMethodName(
              "google.cloud.recaptchaenterprise.v1.RecaptchaEnterpriseService/DeleteKey")
          .setRequestMarshaller(ProtoUtils.marshaller(DeleteKeyRequest.getDefaultInstance()))
          .setResponseMarshaller(ProtoUtils.marshaller(Empty.getDefaultInstance()))
          .setSampledToLocalTracing(true)
          .build();

  private static final MethodDescriptor<MigrateKeyRequest, Key> migrateKeyMethodDescriptor =
      MethodDescriptor.<MigrateKeyRequest, Key>newBuilder()
          .setType(MethodDescriptor.MethodType.UNARY)
          .setFullMethodName(
              "google.cloud.recaptchaenterprise.v1.RecaptchaEnterpriseService/MigrateKey")
          .setRequestMarshaller(ProtoUtils.marshaller(MigrateKeyRequest.getDefaultInstance()))
          .setResponseMarshaller(ProtoUtils.marshaller(Key.getDefaultInstance()))
          .setSampledToLocalTracing(true)
          .build();

  private static final MethodDescriptor<AddIpOverrideRequest, AddIpOverrideResponse>
      addIpOverrideMethodDescriptor =
          MethodDescriptor.<AddIpOverrideRequest, AddIpOverrideResponse>newBuilder()
              .setType(MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(
                  "google.cloud.recaptchaenterprise.v1.RecaptchaEnterpriseService/AddIpOverride")
              .setRequestMarshaller(
                  ProtoUtils.marshaller(AddIpOverrideRequest.getDefaultInstance()))
              .setResponseMarshaller(
                  ProtoUtils.marshaller(AddIpOverrideResponse.getDefaultInstance()))
              .setSampledToLocalTracing(true)
              .build();

  private static final MethodDescriptor<RemoveIpOverrideRequest, RemoveIpOverrideResponse>
      removeIpOverrideMethodDescriptor =
          MethodDescriptor.<RemoveIpOverrideRequest, RemoveIpOverrideResponse>newBuilder()
              .setType(MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(
                  "google.cloud.recaptchaenterprise.v1.RecaptchaEnterpriseService/RemoveIpOverride")
              .setRequestMarshaller(
                  ProtoUtils.marshaller(RemoveIpOverrideRequest.getDefaultInstance()))
              .setResponseMarshaller(
                  ProtoUtils.marshaller(RemoveIpOverrideResponse.getDefaultInstance()))
              .setSampledToLocalTracing(true)
              .build();

  private static final MethodDescriptor<ListIpOverridesRequest, ListIpOverridesResponse>
      listIpOverridesMethodDescriptor =
          MethodDescriptor.<ListIpOverridesRequest, ListIpOverridesResponse>newBuilder()
              .setType(MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(
                  "google.cloud.recaptchaenterprise.v1.RecaptchaEnterpriseService/ListIpOverrides")
              .setRequestMarshaller(
                  ProtoUtils.marshaller(ListIpOverridesRequest.getDefaultInstance()))
              .setResponseMarshaller(
                  ProtoUtils.marshaller(ListIpOverridesResponse.getDefaultInstance()))
              .setSampledToLocalTracing(true)
              .build();

  private static final MethodDescriptor<GetMetricsRequest, Metrics> getMetricsMethodDescriptor =
      MethodDescriptor.<GetMetricsRequest, Metrics>newBuilder()
          .setType(MethodDescriptor.MethodType.UNARY)
          .setFullMethodName(
              "google.cloud.recaptchaenterprise.v1.RecaptchaEnterpriseService/GetMetrics")
          .setRequestMarshaller(ProtoUtils.marshaller(GetMetricsRequest.getDefaultInstance()))
          .setResponseMarshaller(ProtoUtils.marshaller(Metrics.getDefaultInstance()))
          .setSampledToLocalTracing(true)
          .build();

  private static final MethodDescriptor<CreateFirewallPolicyRequest, FirewallPolicy>
      createFirewallPolicyMethodDescriptor =
          MethodDescriptor.<CreateFirewallPolicyRequest, FirewallPolicy>newBuilder()
              .setType(MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(
                  "google.cloud.recaptchaenterprise.v1.RecaptchaEnterpriseService/CreateFirewallPolicy")
              .setRequestMarshaller(
                  ProtoUtils.marshaller(CreateFirewallPolicyRequest.getDefaultInstance()))
              .setResponseMarshaller(ProtoUtils.marshaller(FirewallPolicy.getDefaultInstance()))
              .setSampledToLocalTracing(true)
              .build();

  private static final MethodDescriptor<ListFirewallPoliciesRequest, ListFirewallPoliciesResponse>
      listFirewallPoliciesMethodDescriptor =
          MethodDescriptor.<ListFirewallPoliciesRequest, ListFirewallPoliciesResponse>newBuilder()
              .setType(MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(
                  "google.cloud.recaptchaenterprise.v1.RecaptchaEnterpriseService/ListFirewallPolicies")
              .setRequestMarshaller(
                  ProtoUtils.marshaller(ListFirewallPoliciesRequest.getDefaultInstance()))
              .setResponseMarshaller(
                  ProtoUtils.marshaller(ListFirewallPoliciesResponse.getDefaultInstance()))
              .setSampledToLocalTracing(true)
              .build();

  private static final MethodDescriptor<GetFirewallPolicyRequest, FirewallPolicy>
      getFirewallPolicyMethodDescriptor =
          MethodDescriptor.<GetFirewallPolicyRequest, FirewallPolicy>newBuilder()
              .setType(MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(
                  "google.cloud.recaptchaenterprise.v1.RecaptchaEnterpriseService/GetFirewallPolicy")
              .setRequestMarshaller(
                  ProtoUtils.marshaller(GetFirewallPolicyRequest.getDefaultInstance()))
              .setResponseMarshaller(ProtoUtils.marshaller(FirewallPolicy.getDefaultInstance()))
              .setSampledToLocalTracing(true)
              .build();

  private static final MethodDescriptor<UpdateFirewallPolicyRequest, FirewallPolicy>
      updateFirewallPolicyMethodDescriptor =
          MethodDescriptor.<UpdateFirewallPolicyRequest, FirewallPolicy>newBuilder()
              .setType(MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(
                  "google.cloud.recaptchaenterprise.v1.RecaptchaEnterpriseService/UpdateFirewallPolicy")
              .setRequestMarshaller(
                  ProtoUtils.marshaller(UpdateFirewallPolicyRequest.getDefaultInstance()))
              .setResponseMarshaller(ProtoUtils.marshaller(FirewallPolicy.getDefaultInstance()))
              .setSampledToLocalTracing(true)
              .build();

  private static final MethodDescriptor<DeleteFirewallPolicyRequest, Empty>
      deleteFirewallPolicyMethodDescriptor =
          MethodDescriptor.<DeleteFirewallPolicyRequest, Empty>newBuilder()
              .setType(MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(
                  "google.cloud.recaptchaenterprise.v1.RecaptchaEnterpriseService/DeleteFirewallPolicy")
              .setRequestMarshaller(
                  ProtoUtils.marshaller(DeleteFirewallPolicyRequest.getDefaultInstance()))
              .setResponseMarshaller(ProtoUtils.marshaller(Empty.getDefaultInstance()))
              .setSampledToLocalTracing(true)
              .build();

  private static final MethodDescriptor<
          ReorderFirewallPoliciesRequest, ReorderFirewallPoliciesResponse>
      reorderFirewallPoliciesMethodDescriptor =
          MethodDescriptor
              .<ReorderFirewallPoliciesRequest, ReorderFirewallPoliciesResponse>newBuilder()
              .setType(MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(
                  "google.cloud.recaptchaenterprise.v1.RecaptchaEnterpriseService/ReorderFirewallPolicies")
              .setRequestMarshaller(
                  ProtoUtils.marshaller(ReorderFirewallPoliciesRequest.getDefaultInstance()))
              .setResponseMarshaller(
                  ProtoUtils.marshaller(ReorderFirewallPoliciesResponse.getDefaultInstance()))
              .setSampledToLocalTracing(true)
              .build();

  private static final MethodDescriptor<
          ListRelatedAccountGroupsRequest, ListRelatedAccountGroupsResponse>
      listRelatedAccountGroupsMethodDescriptor =
          MethodDescriptor
              .<ListRelatedAccountGroupsRequest, ListRelatedAccountGroupsResponse>newBuilder()
              .setType(MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(
                  "google.cloud.recaptchaenterprise.v1.RecaptchaEnterpriseService/ListRelatedAccountGroups")
              .setRequestMarshaller(
                  ProtoUtils.marshaller(ListRelatedAccountGroupsRequest.getDefaultInstance()))
              .setResponseMarshaller(
                  ProtoUtils.marshaller(ListRelatedAccountGroupsResponse.getDefaultInstance()))
              .setSampledToLocalTracing(true)
              .build();

  private static final MethodDescriptor<
          ListRelatedAccountGroupMembershipsRequest, ListRelatedAccountGroupMembershipsResponse>
      listRelatedAccountGroupMembershipsMethodDescriptor =
          MethodDescriptor
              .<ListRelatedAccountGroupMembershipsRequest,
                  ListRelatedAccountGroupMembershipsResponse>
                  newBuilder()
              .setType(MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(
                  "google.cloud.recaptchaenterprise.v1.RecaptchaEnterpriseService/ListRelatedAccountGroupMemberships")
              .setRequestMarshaller(
                  ProtoUtils.marshaller(
                      ListRelatedAccountGroupMembershipsRequest.getDefaultInstance()))
              .setResponseMarshaller(
                  ProtoUtils.marshaller(
                      ListRelatedAccountGroupMembershipsResponse.getDefaultInstance()))
              .setSampledToLocalTracing(true)
              .build();

  private static final MethodDescriptor<
          SearchRelatedAccountGroupMembershipsRequest, SearchRelatedAccountGroupMembershipsResponse>
      searchRelatedAccountGroupMembershipsMethodDescriptor =
          MethodDescriptor
              .<SearchRelatedAccountGroupMembershipsRequest,
                  SearchRelatedAccountGroupMembershipsResponse>
                  newBuilder()
              .setType(MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(
                  "google.cloud.recaptchaenterprise.v1.RecaptchaEnterpriseService/SearchRelatedAccountGroupMemberships")
              .setRequestMarshaller(
                  ProtoUtils.marshaller(
                      SearchRelatedAccountGroupMembershipsRequest.getDefaultInstance()))
              .setResponseMarshaller(
                  ProtoUtils.marshaller(
                      SearchRelatedAccountGroupMembershipsResponse.getDefaultInstance()))
              .setSampledToLocalTracing(true)
              .build();

  private final UnaryCallable<CreateAssessmentRequest, Assessment> createAssessmentCallable;
  private final UnaryCallable<AnnotateAssessmentRequest, AnnotateAssessmentResponse>
      annotateAssessmentCallable;
  private final UnaryCallable<CreateKeyRequest, Key> createKeyCallable;
  private final UnaryCallable<ListKeysRequest, ListKeysResponse> listKeysCallable;
  private final UnaryCallable<ListKeysRequest, ListKeysPagedResponse> listKeysPagedCallable;
  private final UnaryCallable<RetrieveLegacySecretKeyRequest, RetrieveLegacySecretKeyResponse>
      retrieveLegacySecretKeyCallable;
  private final UnaryCallable<GetKeyRequest, Key> getKeyCallable;
  private final UnaryCallable<UpdateKeyRequest, Key> updateKeyCallable;
  private final UnaryCallable<DeleteKeyRequest, Empty> deleteKeyCallable;
  private final UnaryCallable<MigrateKeyRequest, Key> migrateKeyCallable;
  private final UnaryCallable<AddIpOverrideRequest, AddIpOverrideResponse> addIpOverrideCallable;
  private final UnaryCallable<RemoveIpOverrideRequest, RemoveIpOverrideResponse>
      removeIpOverrideCallable;
  private final UnaryCallable<ListIpOverridesRequest, ListIpOverridesResponse>
      listIpOverridesCallable;
  private final UnaryCallable<ListIpOverridesRequest, ListIpOverridesPagedResponse>
      listIpOverridesPagedCallable;
  private final UnaryCallable<GetMetricsRequest, Metrics> getMetricsCallable;
  private final UnaryCallable<CreateFirewallPolicyRequest, FirewallPolicy>
      createFirewallPolicyCallable;
  private final UnaryCallable<ListFirewallPoliciesRequest, ListFirewallPoliciesResponse>
      listFirewallPoliciesCallable;
  private final UnaryCallable<ListFirewallPoliciesRequest, ListFirewallPoliciesPagedResponse>
      listFirewallPoliciesPagedCallable;
  private final UnaryCallable<GetFirewallPolicyRequest, FirewallPolicy> getFirewallPolicyCallable;
  private final UnaryCallable<UpdateFirewallPolicyRequest, FirewallPolicy>
      updateFirewallPolicyCallable;
  private final UnaryCallable<DeleteFirewallPolicyRequest, Empty> deleteFirewallPolicyCallable;
  private final UnaryCallable<ReorderFirewallPoliciesRequest, ReorderFirewallPoliciesResponse>
      reorderFirewallPoliciesCallable;
  private final UnaryCallable<ListRelatedAccountGroupsRequest, ListRelatedAccountGroupsResponse>
      listRelatedAccountGroupsCallable;
  private final UnaryCallable<
          ListRelatedAccountGroupsRequest, ListRelatedAccountGroupsPagedResponse>
      listRelatedAccountGroupsPagedCallable;
  private final UnaryCallable<
          ListRelatedAccountGroupMembershipsRequest, ListRelatedAccountGroupMembershipsResponse>
      listRelatedAccountGroupMembershipsCallable;
  private final UnaryCallable<
          ListRelatedAccountGroupMembershipsRequest,
          ListRelatedAccountGroupMembershipsPagedResponse>
      listRelatedAccountGroupMembershipsPagedCallable;
  private final UnaryCallable<
          SearchRelatedAccountGroupMembershipsRequest, SearchRelatedAccountGroupMembershipsResponse>
      searchRelatedAccountGroupMembershipsCallable;
  private final UnaryCallable<
          SearchRelatedAccountGroupMembershipsRequest,
          SearchRelatedAccountGroupMembershipsPagedResponse>
      searchRelatedAccountGroupMembershipsPagedCallable;

  private final BackgroundResource backgroundResources;
  private final GrpcOperationsStub operationsStub;
  private final GrpcStubCallableFactory callableFactory;

  public static final GrpcRecaptchaEnterpriseServiceStub create(
      RecaptchaEnterpriseServiceStubSettings settings) throws IOException {
    return new GrpcRecaptchaEnterpriseServiceStub(settings, ClientContext.create(settings));
  }

  public static final GrpcRecaptchaEnterpriseServiceStub create(ClientContext clientContext)
      throws IOException {
    return new GrpcRecaptchaEnterpriseServiceStub(
        RecaptchaEnterpriseServiceStubSettings.newBuilder().build(), clientContext);
  }

  public static final GrpcRecaptchaEnterpriseServiceStub create(
      ClientContext clientContext, GrpcStubCallableFactory callableFactory) throws IOException {
    return new GrpcRecaptchaEnterpriseServiceStub(
        RecaptchaEnterpriseServiceStubSettings.newBuilder().build(),
        clientContext,
        callableFactory);
  }

  /**
   * Constructs an instance of GrpcRecaptchaEnterpriseServiceStub, using the given settings. This is
   * protected so that it is easy to make a subclass, but otherwise, the static factory methods
   * should be preferred.
   */
  protected GrpcRecaptchaEnterpriseServiceStub(
      RecaptchaEnterpriseServiceStubSettings settings, ClientContext clientContext)
      throws IOException {
    this(settings, clientContext, new GrpcRecaptchaEnterpriseServiceCallableFactory());
  }

  /**
   * Constructs an instance of GrpcRecaptchaEnterpriseServiceStub, using the given settings. This is
   * protected so that it is easy to make a subclass, but otherwise, the static factory methods
   * should be preferred.
   */
  protected GrpcRecaptchaEnterpriseServiceStub(
      RecaptchaEnterpriseServiceStubSettings settings,
      ClientContext clientContext,
      GrpcStubCallableFactory callableFactory)
      throws IOException {
    this.callableFactory = callableFactory;
    this.operationsStub = GrpcOperationsStub.create(clientContext, callableFactory);

    GrpcCallSettings<CreateAssessmentRequest, Assessment> createAssessmentTransportSettings =
        GrpcCallSettings.<CreateAssessmentRequest, Assessment>newBuilder()
            .setMethodDescriptor(createAssessmentMethodDescriptor)
            .setParamsExtractor(
                request -> {
                  RequestParamsBuilder builder = RequestParamsBuilder.create();
                  builder.add("parent", String.valueOf(request.getParent()));
                  return builder.build();
                })
            .build();
    GrpcCallSettings<AnnotateAssessmentRequest, AnnotateAssessmentResponse>
        annotateAssessmentTransportSettings =
            GrpcCallSettings.<AnnotateAssessmentRequest, AnnotateAssessmentResponse>newBuilder()
                .setMethodDescriptor(annotateAssessmentMethodDescriptor)
                .setParamsExtractor(
                    request -> {
                      RequestParamsBuilder builder = RequestParamsBuilder.create();
                      builder.add("name", String.valueOf(request.getName()));
                      return builder.build();
                    })
                .build();
    GrpcCallSettings<CreateKeyRequest, Key> createKeyTransportSettings =
        GrpcCallSettings.<CreateKeyRequest, Key>newBuilder()
            .setMethodDescriptor(createKeyMethodDescriptor)
            .setParamsExtractor(
                request -> {
                  RequestParamsBuilder builder = RequestParamsBuilder.create();
                  builder.add("parent", String.valueOf(request.getParent()));
                  return builder.build();
                })
            .build();
    GrpcCallSettings<ListKeysRequest, ListKeysResponse> listKeysTransportSettings =
        GrpcCallSettings.<ListKeysRequest, ListKeysResponse>newBuilder()
            .setMethodDescriptor(listKeysMethodDescriptor)
            .setParamsExtractor(
                request -> {
                  RequestParamsBuilder builder = RequestParamsBuilder.create();
                  builder.add("parent", String.valueOf(request.getParent()));
                  return builder.build();
                })
            .build();
    GrpcCallSettings<RetrieveLegacySecretKeyRequest, RetrieveLegacySecretKeyResponse>
        retrieveLegacySecretKeyTransportSettings =
            GrpcCallSettings
                .<RetrieveLegacySecretKeyRequest, RetrieveLegacySecretKeyResponse>newBuilder()
                .setMethodDescriptor(retrieveLegacySecretKeyMethodDescriptor)
                .setParamsExtractor(
                    request -> {
                      RequestParamsBuilder builder = RequestParamsBuilder.create();
                      builder.add("key", String.valueOf(request.getKey()));
                      return builder.build();
                    })
                .build();
    GrpcCallSettings<GetKeyRequest, Key> getKeyTransportSettings =
        GrpcCallSettings.<GetKeyRequest, Key>newBuilder()
            .setMethodDescriptor(getKeyMethodDescriptor)
            .setParamsExtractor(
                request -> {
                  RequestParamsBuilder builder = RequestParamsBuilder.create();
                  builder.add("name", String.valueOf(request.getName()));
                  return builder.build();
                })
            .build();
    GrpcCallSettings<UpdateKeyRequest, Key> updateKeyTransportSettings =
        GrpcCallSettings.<UpdateKeyRequest, Key>newBuilder()
            .setMethodDescriptor(updateKeyMethodDescriptor)
            .setParamsExtractor(
                request -> {
                  RequestParamsBuilder builder = RequestParamsBuilder.create();
                  builder.add("key.name", String.valueOf(request.getKey().getName()));
                  return builder.build();
                })
            .build();
    GrpcCallSettings<DeleteKeyRequest, Empty> deleteKeyTransportSettings =
        GrpcCallSettings.<DeleteKeyRequest, Empty>newBuilder()
            .setMethodDescriptor(deleteKeyMethodDescriptor)
            .setParamsExtractor(
                request -> {
                  RequestParamsBuilder builder = RequestParamsBuilder.create();
                  builder.add("name", String.valueOf(request.getName()));
                  return builder.build();
                })
            .build();
    GrpcCallSettings<MigrateKeyRequest, Key> migrateKeyTransportSettings =
        GrpcCallSettings.<MigrateKeyRequest, Key>newBuilder()
            .setMethodDescriptor(migrateKeyMethodDescriptor)
            .setParamsExtractor(
                request -> {
                  RequestParamsBuilder builder = RequestParamsBuilder.create();
                  builder.add("name", String.valueOf(request.getName()));
                  return builder.build();
                })
            .build();
    GrpcCallSettings<AddIpOverrideRequest, AddIpOverrideResponse> addIpOverrideTransportSettings =
        GrpcCallSettings.<AddIpOverrideRequest, AddIpOverrideResponse>newBuilder()
            .setMethodDescriptor(addIpOverrideMethodDescriptor)
            .setParamsExtractor(
                request -> {
                  RequestParamsBuilder builder = RequestParamsBuilder.create();
                  builder.add("name", String.valueOf(request.getName()));
                  return builder.build();
                })
            .build();
    GrpcCallSettings<RemoveIpOverrideRequest, RemoveIpOverrideResponse>
        removeIpOverrideTransportSettings =
            GrpcCallSettings.<RemoveIpOverrideRequest, RemoveIpOverrideResponse>newBuilder()
                .setMethodDescriptor(removeIpOverrideMethodDescriptor)
                .setParamsExtractor(
                    request -> {
                      RequestParamsBuilder builder = RequestParamsBuilder.create();
                      builder.add("name", String.valueOf(request.getName()));
                      return builder.build();
                    })
                .build();
    GrpcCallSettings<ListIpOverridesRequest, ListIpOverridesResponse>
        listIpOverridesTransportSettings =
            GrpcCallSettings.<ListIpOverridesRequest, ListIpOverridesResponse>newBuilder()
                .setMethodDescriptor(listIpOverridesMethodDescriptor)
                .setParamsExtractor(
                    request -> {
                      RequestParamsBuilder builder = RequestParamsBuilder.create();
                      builder.add("parent", String.valueOf(request.getParent()));
                      return builder.build();
                    })
                .build();
    GrpcCallSettings<GetMetricsRequest, Metrics> getMetricsTransportSettings =
        GrpcCallSettings.<GetMetricsRequest, Metrics>newBuilder()
            .setMethodDescriptor(getMetricsMethodDescriptor)
            .setParamsExtractor(
                request -> {
                  RequestParamsBuilder builder = RequestParamsBuilder.create();
                  builder.add("name", String.valueOf(request.getName()));
                  return builder.build();
                })
            .build();
    GrpcCallSettings<CreateFirewallPolicyRequest, FirewallPolicy>
        createFirewallPolicyTransportSettings =
            GrpcCallSettings.<CreateFirewallPolicyRequest, FirewallPolicy>newBuilder()
                .setMethodDescriptor(createFirewallPolicyMethodDescriptor)
                .setParamsExtractor(
                    request -> {
                      RequestParamsBuilder builder = RequestParamsBuilder.create();
                      builder.add("parent", String.valueOf(request.getParent()));
                      return builder.build();
                    })
                .build();
    GrpcCallSettings<ListFirewallPoliciesRequest, ListFirewallPoliciesResponse>
        listFirewallPoliciesTransportSettings =
            GrpcCallSettings.<ListFirewallPoliciesRequest, ListFirewallPoliciesResponse>newBuilder()
                .setMethodDescriptor(listFirewallPoliciesMethodDescriptor)
                .setParamsExtractor(
                    request -> {
                      RequestParamsBuilder builder = RequestParamsBuilder.create();
                      builder.add("parent", String.valueOf(request.getParent()));
                      return builder.build();
                    })
                .build();
    GrpcCallSettings<GetFirewallPolicyRequest, FirewallPolicy> getFirewallPolicyTransportSettings =
        GrpcCallSettings.<GetFirewallPolicyRequest, FirewallPolicy>newBuilder()
            .setMethodDescriptor(getFirewallPolicyMethodDescriptor)
            .setParamsExtractor(
                request -> {
                  RequestParamsBuilder builder = RequestParamsBuilder.create();
                  builder.add("name", String.valueOf(request.getName()));
                  return builder.build();
                })
            .build();
    GrpcCallSettings<UpdateFirewallPolicyRequest, FirewallPolicy>
        updateFirewallPolicyTransportSettings =
            GrpcCallSettings.<UpdateFirewallPolicyRequest, FirewallPolicy>newBuilder()
                .setMethodDescriptor(updateFirewallPolicyMethodDescriptor)
                .setParamsExtractor(
                    request -> {
                      RequestParamsBuilder builder = RequestParamsBuilder.create();
                      builder.add(
                          "firewall_policy.name",
                          String.valueOf(request.getFirewallPolicy().getName()));
                      return builder.build();
                    })
                .build();
    GrpcCallSettings<DeleteFirewallPolicyRequest, Empty> deleteFirewallPolicyTransportSettings =
        GrpcCallSettings.<DeleteFirewallPolicyRequest, Empty>newBuilder()
            .setMethodDescriptor(deleteFirewallPolicyMethodDescriptor)
            .setParamsExtractor(
                request -> {
                  RequestParamsBuilder builder = RequestParamsBuilder.create();
                  builder.add("name", String.valueOf(request.getName()));
                  return builder.build();
                })
            .build();
    GrpcCallSettings<ReorderFirewallPoliciesRequest, ReorderFirewallPoliciesResponse>
        reorderFirewallPoliciesTransportSettings =
            GrpcCallSettings
                .<ReorderFirewallPoliciesRequest, ReorderFirewallPoliciesResponse>newBuilder()
                .setMethodDescriptor(reorderFirewallPoliciesMethodDescriptor)
                .setParamsExtractor(
                    request -> {
                      RequestParamsBuilder builder = RequestParamsBuilder.create();
                      builder.add("parent", String.valueOf(request.getParent()));
                      return builder.build();
                    })
                .build();
    GrpcCallSettings<ListRelatedAccountGroupsRequest, ListRelatedAccountGroupsResponse>
        listRelatedAccountGroupsTransportSettings =
            GrpcCallSettings
                .<ListRelatedAccountGroupsRequest, ListRelatedAccountGroupsResponse>newBuilder()
                .setMethodDescriptor(listRelatedAccountGroupsMethodDescriptor)
                .setParamsExtractor(
                    request -> {
                      RequestParamsBuilder builder = RequestParamsBuilder.create();
                      builder.add("parent", String.valueOf(request.getParent()));
                      return builder.build();
                    })
                .build();
    GrpcCallSettings<
            ListRelatedAccountGroupMembershipsRequest, ListRelatedAccountGroupMembershipsResponse>
        listRelatedAccountGroupMembershipsTransportSettings =
            GrpcCallSettings
                .<ListRelatedAccountGroupMembershipsRequest,
                    ListRelatedAccountGroupMembershipsResponse>
                    newBuilder()
                .setMethodDescriptor(listRelatedAccountGroupMembershipsMethodDescriptor)
                .setParamsExtractor(
                    request -> {
                      RequestParamsBuilder builder = RequestParamsBuilder.create();
                      builder.add("parent", String.valueOf(request.getParent()));
                      return builder.build();
                    })
                .build();
    GrpcCallSettings<
            SearchRelatedAccountGroupMembershipsRequest,
            SearchRelatedAccountGroupMembershipsResponse>
        searchRelatedAccountGroupMembershipsTransportSettings =
            GrpcCallSettings
                .<SearchRelatedAccountGroupMembershipsRequest,
                    SearchRelatedAccountGroupMembershipsResponse>
                    newBuilder()
                .setMethodDescriptor(searchRelatedAccountGroupMembershipsMethodDescriptor)
                .setParamsExtractor(
                    request -> {
                      RequestParamsBuilder builder = RequestParamsBuilder.create();
                      builder.add("project", String.valueOf(request.getProject()));
                      return builder.build();
                    })
                .build();

    this.createAssessmentCallable =
        callableFactory.createUnaryCallable(
            createAssessmentTransportSettings, settings.createAssessmentSettings(), clientContext);
    this.annotateAssessmentCallable =
        callableFactory.createUnaryCallable(
            annotateAssessmentTransportSettings,
            settings.annotateAssessmentSettings(),
            clientContext);
    this.createKeyCallable =
        callableFactory.createUnaryCallable(
            createKeyTransportSettings, settings.createKeySettings(), clientContext);
    this.listKeysCallable =
        callableFactory.createUnaryCallable(
            listKeysTransportSettings, settings.listKeysSettings(), clientContext);
    this.listKeysPagedCallable =
        callableFactory.createPagedCallable(
            listKeysTransportSettings, settings.listKeysSettings(), clientContext);
    this.retrieveLegacySecretKeyCallable =
        callableFactory.createUnaryCallable(
            retrieveLegacySecretKeyTransportSettings,
            settings.retrieveLegacySecretKeySettings(),
            clientContext);
    this.getKeyCallable =
        callableFactory.createUnaryCallable(
            getKeyTransportSettings, settings.getKeySettings(), clientContext);
    this.updateKeyCallable =
        callableFactory.createUnaryCallable(
            updateKeyTransportSettings, settings.updateKeySettings(), clientContext);
    this.deleteKeyCallable =
        callableFactory.createUnaryCallable(
            deleteKeyTransportSettings, settings.deleteKeySettings(), clientContext);
    this.migrateKeyCallable =
        callableFactory.createUnaryCallable(
            migrateKeyTransportSettings, settings.migrateKeySettings(), clientContext);
    this.addIpOverrideCallable =
        callableFactory.createUnaryCallable(
            addIpOverrideTransportSettings, settings.addIpOverrideSettings(), clientContext);
    this.removeIpOverrideCallable =
        callableFactory.createUnaryCallable(
            removeIpOverrideTransportSettings, settings.removeIpOverrideSettings(), clientContext);
    this.listIpOverridesCallable =
        callableFactory.createUnaryCallable(
            listIpOverridesTransportSettings, settings.listIpOverridesSettings(), clientContext);
    this.listIpOverridesPagedCallable =
        callableFactory.createPagedCallable(
            listIpOverridesTransportSettings, settings.listIpOverridesSettings(), clientContext);
    this.getMetricsCallable =
        callableFactory.createUnaryCallable(
            getMetricsTransportSettings, settings.getMetricsSettings(), clientContext);
    this.createFirewallPolicyCallable =
        callableFactory.createUnaryCallable(
            createFirewallPolicyTransportSettings,
            settings.createFirewallPolicySettings(),
            clientContext);
    this.listFirewallPoliciesCallable =
        callableFactory.createUnaryCallable(
            listFirewallPoliciesTransportSettings,
            settings.listFirewallPoliciesSettings(),
            clientContext);
    this.listFirewallPoliciesPagedCallable =
        callableFactory.createPagedCallable(
            listFirewallPoliciesTransportSettings,
            settings.listFirewallPoliciesSettings(),
            clientContext);
    this.getFirewallPolicyCallable =
        callableFactory.createUnaryCallable(
            getFirewallPolicyTransportSettings,
            settings.getFirewallPolicySettings(),
            clientContext);
    this.updateFirewallPolicyCallable =
        callableFactory.createUnaryCallable(
            updateFirewallPolicyTransportSettings,
            settings.updateFirewallPolicySettings(),
            clientContext);
    this.deleteFirewallPolicyCallable =
        callableFactory.createUnaryCallable(
            deleteFirewallPolicyTransportSettings,
            settings.deleteFirewallPolicySettings(),
            clientContext);
    this.reorderFirewallPoliciesCallable =
        callableFactory.createUnaryCallable(
            reorderFirewallPoliciesTransportSettings,
            settings.reorderFirewallPoliciesSettings(),
            clientContext);
    this.listRelatedAccountGroupsCallable =
        callableFactory.createUnaryCallable(
            listRelatedAccountGroupsTransportSettings,
            settings.listRelatedAccountGroupsSettings(),
            clientContext);
    this.listRelatedAccountGroupsPagedCallable =
        callableFactory.createPagedCallable(
            listRelatedAccountGroupsTransportSettings,
            settings.listRelatedAccountGroupsSettings(),
            clientContext);
    this.listRelatedAccountGroupMembershipsCallable =
        callableFactory.createUnaryCallable(
            listRelatedAccountGroupMembershipsTransportSettings,
            settings.listRelatedAccountGroupMembershipsSettings(),
            clientContext);
    this.listRelatedAccountGroupMembershipsPagedCallable =
        callableFactory.createPagedCallable(
            listRelatedAccountGroupMembershipsTransportSettings,
            settings.listRelatedAccountGroupMembershipsSettings(),
            clientContext);
    this.searchRelatedAccountGroupMembershipsCallable =
        callableFactory.createUnaryCallable(
            searchRelatedAccountGroupMembershipsTransportSettings,
            settings.searchRelatedAccountGroupMembershipsSettings(),
            clientContext);
    this.searchRelatedAccountGroupMembershipsPagedCallable =
        callableFactory.createPagedCallable(
            searchRelatedAccountGroupMembershipsTransportSettings,
            settings.searchRelatedAccountGroupMembershipsSettings(),
            clientContext);

    this.backgroundResources =
        new BackgroundResourceAggregation(clientContext.getBackgroundResources());
  }

  public GrpcOperationsStub getOperationsStub() {
    return operationsStub;
  }

  @Override
  public UnaryCallable<CreateAssessmentRequest, Assessment> createAssessmentCallable() {
    return createAssessmentCallable;
  }

  @Override
  public UnaryCallable<AnnotateAssessmentRequest, AnnotateAssessmentResponse>
      annotateAssessmentCallable() {
    return annotateAssessmentCallable;
  }

  @Override
  public UnaryCallable<CreateKeyRequest, Key> createKeyCallable() {
    return createKeyCallable;
  }

  @Override
  public UnaryCallable<ListKeysRequest, ListKeysResponse> listKeysCallable() {
    return listKeysCallable;
  }

  @Override
  public UnaryCallable<ListKeysRequest, ListKeysPagedResponse> listKeysPagedCallable() {
    return listKeysPagedCallable;
  }

  @Override
  public UnaryCallable<RetrieveLegacySecretKeyRequest, RetrieveLegacySecretKeyResponse>
      retrieveLegacySecretKeyCallable() {
    return retrieveLegacySecretKeyCallable;
  }

  @Override
  public UnaryCallable<GetKeyRequest, Key> getKeyCallable() {
    return getKeyCallable;
  }

  @Override
  public UnaryCallable<UpdateKeyRequest, Key> updateKeyCallable() {
    return updateKeyCallable;
  }

  @Override
  public UnaryCallable<DeleteKeyRequest, Empty> deleteKeyCallable() {
    return deleteKeyCallable;
  }

  @Override
  public UnaryCallable<MigrateKeyRequest, Key> migrateKeyCallable() {
    return migrateKeyCallable;
  }

  @Override
  public UnaryCallable<AddIpOverrideRequest, AddIpOverrideResponse> addIpOverrideCallable() {
    return addIpOverrideCallable;
  }

  @Override
  public UnaryCallable<RemoveIpOverrideRequest, RemoveIpOverrideResponse>
      removeIpOverrideCallable() {
    return removeIpOverrideCallable;
  }

  @Override
  public UnaryCallable<ListIpOverridesRequest, ListIpOverridesResponse> listIpOverridesCallable() {
    return listIpOverridesCallable;
  }

  @Override
  public UnaryCallable<ListIpOverridesRequest, ListIpOverridesPagedResponse>
      listIpOverridesPagedCallable() {
    return listIpOverridesPagedCallable;
  }

  @Override
  public UnaryCallable<GetMetricsRequest, Metrics> getMetricsCallable() {
    return getMetricsCallable;
  }

  @Override
  public UnaryCallable<CreateFirewallPolicyRequest, FirewallPolicy> createFirewallPolicyCallable() {
    return createFirewallPolicyCallable;
  }

  @Override
  public UnaryCallable<ListFirewallPoliciesRequest, ListFirewallPoliciesResponse>
      listFirewallPoliciesCallable() {
    return listFirewallPoliciesCallable;
  }

  @Override
  public UnaryCallable<ListFirewallPoliciesRequest, ListFirewallPoliciesPagedResponse>
      listFirewallPoliciesPagedCallable() {
    return listFirewallPoliciesPagedCallable;
  }

  @Override
  public UnaryCallable<GetFirewallPolicyRequest, FirewallPolicy> getFirewallPolicyCallable() {
    return getFirewallPolicyCallable;
  }

  @Override
  public UnaryCallable<UpdateFirewallPolicyRequest, FirewallPolicy> updateFirewallPolicyCallable() {
    return updateFirewallPolicyCallable;
  }

  @Override
  public UnaryCallable<DeleteFirewallPolicyRequest, Empty> deleteFirewallPolicyCallable() {
    return deleteFirewallPolicyCallable;
  }

  @Override
  public UnaryCallable<ReorderFirewallPoliciesRequest, ReorderFirewallPoliciesResponse>
      reorderFirewallPoliciesCallable() {
    return reorderFirewallPoliciesCallable;
  }

  @Override
  public UnaryCallable<ListRelatedAccountGroupsRequest, ListRelatedAccountGroupsResponse>
      listRelatedAccountGroupsCallable() {
    return listRelatedAccountGroupsCallable;
  }

  @Override
  public UnaryCallable<ListRelatedAccountGroupsRequest, ListRelatedAccountGroupsPagedResponse>
      listRelatedAccountGroupsPagedCallable() {
    return listRelatedAccountGroupsPagedCallable;
  }

  @Override
  public UnaryCallable<
          ListRelatedAccountGroupMembershipsRequest, ListRelatedAccountGroupMembershipsResponse>
      listRelatedAccountGroupMembershipsCallable() {
    return listRelatedAccountGroupMembershipsCallable;
  }

  @Override
  public UnaryCallable<
          ListRelatedAccountGroupMembershipsRequest,
          ListRelatedAccountGroupMembershipsPagedResponse>
      listRelatedAccountGroupMembershipsPagedCallable() {
    return listRelatedAccountGroupMembershipsPagedCallable;
  }

  @Override
  public UnaryCallable<
          SearchRelatedAccountGroupMembershipsRequest, SearchRelatedAccountGroupMembershipsResponse>
      searchRelatedAccountGroupMembershipsCallable() {
    return searchRelatedAccountGroupMembershipsCallable;
  }

  @Override
  public UnaryCallable<
          SearchRelatedAccountGroupMembershipsRequest,
          SearchRelatedAccountGroupMembershipsPagedResponse>
      searchRelatedAccountGroupMembershipsPagedCallable() {
    return searchRelatedAccountGroupMembershipsPagedCallable;
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
