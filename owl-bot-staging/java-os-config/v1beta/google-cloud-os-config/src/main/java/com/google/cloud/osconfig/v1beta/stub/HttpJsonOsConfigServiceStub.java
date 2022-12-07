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

package com.google.cloud.osconfig.v1beta.stub;

import static com.google.cloud.osconfig.v1beta.OsConfigServiceClient.ListGuestPoliciesPagedResponse;
import static com.google.cloud.osconfig.v1beta.OsConfigServiceClient.ListPatchDeploymentsPagedResponse;
import static com.google.cloud.osconfig.v1beta.OsConfigServiceClient.ListPatchJobInstanceDetailsPagedResponse;
import static com.google.cloud.osconfig.v1beta.OsConfigServiceClient.ListPatchJobsPagedResponse;

import com.google.api.core.BetaApi;
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
import com.google.api.gax.rpc.UnaryCallable;
import com.google.cloud.osconfig.v1beta.GuestPolicies;
import com.google.cloud.osconfig.v1beta.PatchDeployments;
import com.google.cloud.osconfig.v1beta.PatchJobs;
import com.google.protobuf.Empty;
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
 * REST stub implementation for the OsConfigService service API.
 *
 * <p>This class is for advanced usage and reflects the underlying API directly.
 */
@BetaApi
@Generated("by gapic-generator-java")
public class HttpJsonOsConfigServiceStub extends OsConfigServiceStub {
  private static final TypeRegistry typeRegistry = TypeRegistry.newBuilder().build();

  private static final ApiMethodDescriptor<PatchJobs.ExecutePatchJobRequest, PatchJobs.PatchJob>
      executePatchJobMethodDescriptor =
          ApiMethodDescriptor.<PatchJobs.ExecutePatchJobRequest, PatchJobs.PatchJob>newBuilder()
              .setFullMethodName("google.cloud.osconfig.v1beta.OsConfigService/ExecutePatchJob")
              .setHttpMethod("POST")
              .setType(ApiMethodDescriptor.MethodType.UNARY)
              .setRequestFormatter(
                  ProtoMessageRequestFormatter.<PatchJobs.ExecutePatchJobRequest>newBuilder()
                      .setPath(
                          "/v1beta/{parent=projects/*}/patchJobs:execute",
                          request -> {
                            Map<String, String> fields = new HashMap<>();
                            ProtoRestSerializer<PatchJobs.ExecutePatchJobRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putPathParam(fields, "parent", request.getParent());
                            return fields;
                          })
                      .setQueryParamsExtractor(
                          request -> {
                            Map<String, List<String>> fields = new HashMap<>();
                            ProtoRestSerializer<PatchJobs.ExecutePatchJobRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putQueryParam(fields, "$alt", "json;enum-encoding=int");
                            return fields;
                          })
                      .setRequestBodyExtractor(
                          request ->
                              ProtoRestSerializer.create()
                                  .toBody("*", request.toBuilder().clearParent().build(), true))
                      .build())
              .setResponseParser(
                  ProtoMessageResponseParser.<PatchJobs.PatchJob>newBuilder()
                      .setDefaultInstance(PatchJobs.PatchJob.getDefaultInstance())
                      .setDefaultTypeRegistry(typeRegistry)
                      .build())
              .build();

  private static final ApiMethodDescriptor<PatchJobs.GetPatchJobRequest, PatchJobs.PatchJob>
      getPatchJobMethodDescriptor =
          ApiMethodDescriptor.<PatchJobs.GetPatchJobRequest, PatchJobs.PatchJob>newBuilder()
              .setFullMethodName("google.cloud.osconfig.v1beta.OsConfigService/GetPatchJob")
              .setHttpMethod("GET")
              .setType(ApiMethodDescriptor.MethodType.UNARY)
              .setRequestFormatter(
                  ProtoMessageRequestFormatter.<PatchJobs.GetPatchJobRequest>newBuilder()
                      .setPath(
                          "/v1beta/{name=projects/*/patchJobs/*}",
                          request -> {
                            Map<String, String> fields = new HashMap<>();
                            ProtoRestSerializer<PatchJobs.GetPatchJobRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putPathParam(fields, "name", request.getName());
                            return fields;
                          })
                      .setQueryParamsExtractor(
                          request -> {
                            Map<String, List<String>> fields = new HashMap<>();
                            ProtoRestSerializer<PatchJobs.GetPatchJobRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putQueryParam(fields, "$alt", "json;enum-encoding=int");
                            return fields;
                          })
                      .setRequestBodyExtractor(request -> null)
                      .build())
              .setResponseParser(
                  ProtoMessageResponseParser.<PatchJobs.PatchJob>newBuilder()
                      .setDefaultInstance(PatchJobs.PatchJob.getDefaultInstance())
                      .setDefaultTypeRegistry(typeRegistry)
                      .build())
              .build();

  private static final ApiMethodDescriptor<PatchJobs.CancelPatchJobRequest, PatchJobs.PatchJob>
      cancelPatchJobMethodDescriptor =
          ApiMethodDescriptor.<PatchJobs.CancelPatchJobRequest, PatchJobs.PatchJob>newBuilder()
              .setFullMethodName("google.cloud.osconfig.v1beta.OsConfigService/CancelPatchJob")
              .setHttpMethod("POST")
              .setType(ApiMethodDescriptor.MethodType.UNARY)
              .setRequestFormatter(
                  ProtoMessageRequestFormatter.<PatchJobs.CancelPatchJobRequest>newBuilder()
                      .setPath(
                          "/v1beta/{name=projects/*/patchJobs/*}:cancel",
                          request -> {
                            Map<String, String> fields = new HashMap<>();
                            ProtoRestSerializer<PatchJobs.CancelPatchJobRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putPathParam(fields, "name", request.getName());
                            return fields;
                          })
                      .setQueryParamsExtractor(
                          request -> {
                            Map<String, List<String>> fields = new HashMap<>();
                            ProtoRestSerializer<PatchJobs.CancelPatchJobRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putQueryParam(fields, "$alt", "json;enum-encoding=int");
                            return fields;
                          })
                      .setRequestBodyExtractor(
                          request ->
                              ProtoRestSerializer.create()
                                  .toBody("*", request.toBuilder().clearName().build(), true))
                      .build())
              .setResponseParser(
                  ProtoMessageResponseParser.<PatchJobs.PatchJob>newBuilder()
                      .setDefaultInstance(PatchJobs.PatchJob.getDefaultInstance())
                      .setDefaultTypeRegistry(typeRegistry)
                      .build())
              .build();

  private static final ApiMethodDescriptor<
          PatchJobs.ListPatchJobsRequest, PatchJobs.ListPatchJobsResponse>
      listPatchJobsMethodDescriptor =
          ApiMethodDescriptor
              .<PatchJobs.ListPatchJobsRequest, PatchJobs.ListPatchJobsResponse>newBuilder()
              .setFullMethodName("google.cloud.osconfig.v1beta.OsConfigService/ListPatchJobs")
              .setHttpMethod("GET")
              .setType(ApiMethodDescriptor.MethodType.UNARY)
              .setRequestFormatter(
                  ProtoMessageRequestFormatter.<PatchJobs.ListPatchJobsRequest>newBuilder()
                      .setPath(
                          "/v1beta/{parent=projects/*}/patchJobs",
                          request -> {
                            Map<String, String> fields = new HashMap<>();
                            ProtoRestSerializer<PatchJobs.ListPatchJobsRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putPathParam(fields, "parent", request.getParent());
                            return fields;
                          })
                      .setQueryParamsExtractor(
                          request -> {
                            Map<String, List<String>> fields = new HashMap<>();
                            ProtoRestSerializer<PatchJobs.ListPatchJobsRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putQueryParam(fields, "filter", request.getFilter());
                            serializer.putQueryParam(fields, "pageSize", request.getPageSize());
                            serializer.putQueryParam(fields, "pageToken", request.getPageToken());
                            serializer.putQueryParam(fields, "$alt", "json;enum-encoding=int");
                            return fields;
                          })
                      .setRequestBodyExtractor(request -> null)
                      .build())
              .setResponseParser(
                  ProtoMessageResponseParser.<PatchJobs.ListPatchJobsResponse>newBuilder()
                      .setDefaultInstance(PatchJobs.ListPatchJobsResponse.getDefaultInstance())
                      .setDefaultTypeRegistry(typeRegistry)
                      .build())
              .build();

  private static final ApiMethodDescriptor<
          PatchJobs.ListPatchJobInstanceDetailsRequest,
          PatchJobs.ListPatchJobInstanceDetailsResponse>
      listPatchJobInstanceDetailsMethodDescriptor =
          ApiMethodDescriptor
              .<PatchJobs.ListPatchJobInstanceDetailsRequest,
                  PatchJobs.ListPatchJobInstanceDetailsResponse>
                  newBuilder()
              .setFullMethodName(
                  "google.cloud.osconfig.v1beta.OsConfigService/ListPatchJobInstanceDetails")
              .setHttpMethod("GET")
              .setType(ApiMethodDescriptor.MethodType.UNARY)
              .setRequestFormatter(
                  ProtoMessageRequestFormatter
                      .<PatchJobs.ListPatchJobInstanceDetailsRequest>newBuilder()
                      .setPath(
                          "/v1beta/{parent=projects/*/patchJobs/*}/instanceDetails",
                          request -> {
                            Map<String, String> fields = new HashMap<>();
                            ProtoRestSerializer<PatchJobs.ListPatchJobInstanceDetailsRequest>
                                serializer = ProtoRestSerializer.create();
                            serializer.putPathParam(fields, "parent", request.getParent());
                            return fields;
                          })
                      .setQueryParamsExtractor(
                          request -> {
                            Map<String, List<String>> fields = new HashMap<>();
                            ProtoRestSerializer<PatchJobs.ListPatchJobInstanceDetailsRequest>
                                serializer = ProtoRestSerializer.create();
                            serializer.putQueryParam(fields, "filter", request.getFilter());
                            serializer.putQueryParam(fields, "pageSize", request.getPageSize());
                            serializer.putQueryParam(fields, "pageToken", request.getPageToken());
                            serializer.putQueryParam(fields, "$alt", "json;enum-encoding=int");
                            return fields;
                          })
                      .setRequestBodyExtractor(request -> null)
                      .build())
              .setResponseParser(
                  ProtoMessageResponseParser
                      .<PatchJobs.ListPatchJobInstanceDetailsResponse>newBuilder()
                      .setDefaultInstance(
                          PatchJobs.ListPatchJobInstanceDetailsResponse.getDefaultInstance())
                      .setDefaultTypeRegistry(typeRegistry)
                      .build())
              .build();

  private static final ApiMethodDescriptor<
          PatchDeployments.CreatePatchDeploymentRequest, PatchDeployments.PatchDeployment>
      createPatchDeploymentMethodDescriptor =
          ApiMethodDescriptor
              .<PatchDeployments.CreatePatchDeploymentRequest, PatchDeployments.PatchDeployment>
                  newBuilder()
              .setFullMethodName(
                  "google.cloud.osconfig.v1beta.OsConfigService/CreatePatchDeployment")
              .setHttpMethod("POST")
              .setType(ApiMethodDescriptor.MethodType.UNARY)
              .setRequestFormatter(
                  ProtoMessageRequestFormatter
                      .<PatchDeployments.CreatePatchDeploymentRequest>newBuilder()
                      .setPath(
                          "/v1beta/{parent=projects/*}/patchDeployments",
                          request -> {
                            Map<String, String> fields = new HashMap<>();
                            ProtoRestSerializer<PatchDeployments.CreatePatchDeploymentRequest>
                                serializer = ProtoRestSerializer.create();
                            serializer.putPathParam(fields, "parent", request.getParent());
                            return fields;
                          })
                      .setQueryParamsExtractor(
                          request -> {
                            Map<String, List<String>> fields = new HashMap<>();
                            ProtoRestSerializer<PatchDeployments.CreatePatchDeploymentRequest>
                                serializer = ProtoRestSerializer.create();
                            serializer.putQueryParam(
                                fields, "patchDeploymentId", request.getPatchDeploymentId());
                            serializer.putQueryParam(fields, "$alt", "json;enum-encoding=int");
                            return fields;
                          })
                      .setRequestBodyExtractor(
                          request ->
                              ProtoRestSerializer.create()
                                  .toBody("patchDeployment", request.getPatchDeployment(), true))
                      .build())
              .setResponseParser(
                  ProtoMessageResponseParser.<PatchDeployments.PatchDeployment>newBuilder()
                      .setDefaultInstance(PatchDeployments.PatchDeployment.getDefaultInstance())
                      .setDefaultTypeRegistry(typeRegistry)
                      .build())
              .build();

  private static final ApiMethodDescriptor<
          PatchDeployments.GetPatchDeploymentRequest, PatchDeployments.PatchDeployment>
      getPatchDeploymentMethodDescriptor =
          ApiMethodDescriptor
              .<PatchDeployments.GetPatchDeploymentRequest, PatchDeployments.PatchDeployment>
                  newBuilder()
              .setFullMethodName("google.cloud.osconfig.v1beta.OsConfigService/GetPatchDeployment")
              .setHttpMethod("GET")
              .setType(ApiMethodDescriptor.MethodType.UNARY)
              .setRequestFormatter(
                  ProtoMessageRequestFormatter
                      .<PatchDeployments.GetPatchDeploymentRequest>newBuilder()
                      .setPath(
                          "/v1beta/{name=projects/*/patchDeployments/*}",
                          request -> {
                            Map<String, String> fields = new HashMap<>();
                            ProtoRestSerializer<PatchDeployments.GetPatchDeploymentRequest>
                                serializer = ProtoRestSerializer.create();
                            serializer.putPathParam(fields, "name", request.getName());
                            return fields;
                          })
                      .setQueryParamsExtractor(
                          request -> {
                            Map<String, List<String>> fields = new HashMap<>();
                            ProtoRestSerializer<PatchDeployments.GetPatchDeploymentRequest>
                                serializer = ProtoRestSerializer.create();
                            serializer.putQueryParam(fields, "$alt", "json;enum-encoding=int");
                            return fields;
                          })
                      .setRequestBodyExtractor(request -> null)
                      .build())
              .setResponseParser(
                  ProtoMessageResponseParser.<PatchDeployments.PatchDeployment>newBuilder()
                      .setDefaultInstance(PatchDeployments.PatchDeployment.getDefaultInstance())
                      .setDefaultTypeRegistry(typeRegistry)
                      .build())
              .build();

  private static final ApiMethodDescriptor<
          PatchDeployments.ListPatchDeploymentsRequest,
          PatchDeployments.ListPatchDeploymentsResponse>
      listPatchDeploymentsMethodDescriptor =
          ApiMethodDescriptor
              .<PatchDeployments.ListPatchDeploymentsRequest,
                  PatchDeployments.ListPatchDeploymentsResponse>
                  newBuilder()
              .setFullMethodName(
                  "google.cloud.osconfig.v1beta.OsConfigService/ListPatchDeployments")
              .setHttpMethod("GET")
              .setType(ApiMethodDescriptor.MethodType.UNARY)
              .setRequestFormatter(
                  ProtoMessageRequestFormatter
                      .<PatchDeployments.ListPatchDeploymentsRequest>newBuilder()
                      .setPath(
                          "/v1beta/{parent=projects/*}/patchDeployments",
                          request -> {
                            Map<String, String> fields = new HashMap<>();
                            ProtoRestSerializer<PatchDeployments.ListPatchDeploymentsRequest>
                                serializer = ProtoRestSerializer.create();
                            serializer.putPathParam(fields, "parent", request.getParent());
                            return fields;
                          })
                      .setQueryParamsExtractor(
                          request -> {
                            Map<String, List<String>> fields = new HashMap<>();
                            ProtoRestSerializer<PatchDeployments.ListPatchDeploymentsRequest>
                                serializer = ProtoRestSerializer.create();
                            serializer.putQueryParam(fields, "pageSize", request.getPageSize());
                            serializer.putQueryParam(fields, "pageToken", request.getPageToken());
                            serializer.putQueryParam(fields, "$alt", "json;enum-encoding=int");
                            return fields;
                          })
                      .setRequestBodyExtractor(request -> null)
                      .build())
              .setResponseParser(
                  ProtoMessageResponseParser
                      .<PatchDeployments.ListPatchDeploymentsResponse>newBuilder()
                      .setDefaultInstance(
                          PatchDeployments.ListPatchDeploymentsResponse.getDefaultInstance())
                      .setDefaultTypeRegistry(typeRegistry)
                      .build())
              .build();

  private static final ApiMethodDescriptor<PatchDeployments.DeletePatchDeploymentRequest, Empty>
      deletePatchDeploymentMethodDescriptor =
          ApiMethodDescriptor.<PatchDeployments.DeletePatchDeploymentRequest, Empty>newBuilder()
              .setFullMethodName(
                  "google.cloud.osconfig.v1beta.OsConfigService/DeletePatchDeployment")
              .setHttpMethod("DELETE")
              .setType(ApiMethodDescriptor.MethodType.UNARY)
              .setRequestFormatter(
                  ProtoMessageRequestFormatter
                      .<PatchDeployments.DeletePatchDeploymentRequest>newBuilder()
                      .setPath(
                          "/v1beta/{name=projects/*/patchDeployments/*}",
                          request -> {
                            Map<String, String> fields = new HashMap<>();
                            ProtoRestSerializer<PatchDeployments.DeletePatchDeploymentRequest>
                                serializer = ProtoRestSerializer.create();
                            serializer.putPathParam(fields, "name", request.getName());
                            return fields;
                          })
                      .setQueryParamsExtractor(
                          request -> {
                            Map<String, List<String>> fields = new HashMap<>();
                            ProtoRestSerializer<PatchDeployments.DeletePatchDeploymentRequest>
                                serializer = ProtoRestSerializer.create();
                            serializer.putQueryParam(fields, "$alt", "json;enum-encoding=int");
                            return fields;
                          })
                      .setRequestBodyExtractor(request -> null)
                      .build())
              .setResponseParser(
                  ProtoMessageResponseParser.<Empty>newBuilder()
                      .setDefaultInstance(Empty.getDefaultInstance())
                      .setDefaultTypeRegistry(typeRegistry)
                      .build())
              .build();

  private static final ApiMethodDescriptor<
          PatchDeployments.UpdatePatchDeploymentRequest, PatchDeployments.PatchDeployment>
      updatePatchDeploymentMethodDescriptor =
          ApiMethodDescriptor
              .<PatchDeployments.UpdatePatchDeploymentRequest, PatchDeployments.PatchDeployment>
                  newBuilder()
              .setFullMethodName(
                  "google.cloud.osconfig.v1beta.OsConfigService/UpdatePatchDeployment")
              .setHttpMethod("PATCH")
              .setType(ApiMethodDescriptor.MethodType.UNARY)
              .setRequestFormatter(
                  ProtoMessageRequestFormatter
                      .<PatchDeployments.UpdatePatchDeploymentRequest>newBuilder()
                      .setPath(
                          "/v1beta/{patchDeployment.name=projects/*/patchDeployments/*}",
                          request -> {
                            Map<String, String> fields = new HashMap<>();
                            ProtoRestSerializer<PatchDeployments.UpdatePatchDeploymentRequest>
                                serializer = ProtoRestSerializer.create();
                            serializer.putPathParam(
                                fields,
                                "patchDeployment.name",
                                request.getPatchDeployment().getName());
                            return fields;
                          })
                      .setQueryParamsExtractor(
                          request -> {
                            Map<String, List<String>> fields = new HashMap<>();
                            ProtoRestSerializer<PatchDeployments.UpdatePatchDeploymentRequest>
                                serializer = ProtoRestSerializer.create();
                            serializer.putQueryParam(fields, "updateMask", request.getUpdateMask());
                            serializer.putQueryParam(fields, "$alt", "json;enum-encoding=int");
                            return fields;
                          })
                      .setRequestBodyExtractor(
                          request ->
                              ProtoRestSerializer.create()
                                  .toBody("patchDeployment", request.getPatchDeployment(), true))
                      .build())
              .setResponseParser(
                  ProtoMessageResponseParser.<PatchDeployments.PatchDeployment>newBuilder()
                      .setDefaultInstance(PatchDeployments.PatchDeployment.getDefaultInstance())
                      .setDefaultTypeRegistry(typeRegistry)
                      .build())
              .build();

  private static final ApiMethodDescriptor<
          PatchDeployments.PausePatchDeploymentRequest, PatchDeployments.PatchDeployment>
      pausePatchDeploymentMethodDescriptor =
          ApiMethodDescriptor
              .<PatchDeployments.PausePatchDeploymentRequest, PatchDeployments.PatchDeployment>
                  newBuilder()
              .setFullMethodName(
                  "google.cloud.osconfig.v1beta.OsConfigService/PausePatchDeployment")
              .setHttpMethod("POST")
              .setType(ApiMethodDescriptor.MethodType.UNARY)
              .setRequestFormatter(
                  ProtoMessageRequestFormatter
                      .<PatchDeployments.PausePatchDeploymentRequest>newBuilder()
                      .setPath(
                          "/v1beta/{name=projects/*/patchDeployments/*}:pause",
                          request -> {
                            Map<String, String> fields = new HashMap<>();
                            ProtoRestSerializer<PatchDeployments.PausePatchDeploymentRequest>
                                serializer = ProtoRestSerializer.create();
                            serializer.putPathParam(fields, "name", request.getName());
                            return fields;
                          })
                      .setQueryParamsExtractor(
                          request -> {
                            Map<String, List<String>> fields = new HashMap<>();
                            ProtoRestSerializer<PatchDeployments.PausePatchDeploymentRequest>
                                serializer = ProtoRestSerializer.create();
                            serializer.putQueryParam(fields, "$alt", "json;enum-encoding=int");
                            return fields;
                          })
                      .setRequestBodyExtractor(
                          request ->
                              ProtoRestSerializer.create()
                                  .toBody("*", request.toBuilder().clearName().build(), true))
                      .build())
              .setResponseParser(
                  ProtoMessageResponseParser.<PatchDeployments.PatchDeployment>newBuilder()
                      .setDefaultInstance(PatchDeployments.PatchDeployment.getDefaultInstance())
                      .setDefaultTypeRegistry(typeRegistry)
                      .build())
              .build();

  private static final ApiMethodDescriptor<
          PatchDeployments.ResumePatchDeploymentRequest, PatchDeployments.PatchDeployment>
      resumePatchDeploymentMethodDescriptor =
          ApiMethodDescriptor
              .<PatchDeployments.ResumePatchDeploymentRequest, PatchDeployments.PatchDeployment>
                  newBuilder()
              .setFullMethodName(
                  "google.cloud.osconfig.v1beta.OsConfigService/ResumePatchDeployment")
              .setHttpMethod("POST")
              .setType(ApiMethodDescriptor.MethodType.UNARY)
              .setRequestFormatter(
                  ProtoMessageRequestFormatter
                      .<PatchDeployments.ResumePatchDeploymentRequest>newBuilder()
                      .setPath(
                          "/v1beta/{name=projects/*/patchDeployments/*}:resume",
                          request -> {
                            Map<String, String> fields = new HashMap<>();
                            ProtoRestSerializer<PatchDeployments.ResumePatchDeploymentRequest>
                                serializer = ProtoRestSerializer.create();
                            serializer.putPathParam(fields, "name", request.getName());
                            return fields;
                          })
                      .setQueryParamsExtractor(
                          request -> {
                            Map<String, List<String>> fields = new HashMap<>();
                            ProtoRestSerializer<PatchDeployments.ResumePatchDeploymentRequest>
                                serializer = ProtoRestSerializer.create();
                            serializer.putQueryParam(fields, "$alt", "json;enum-encoding=int");
                            return fields;
                          })
                      .setRequestBodyExtractor(
                          request ->
                              ProtoRestSerializer.create()
                                  .toBody("*", request.toBuilder().clearName().build(), true))
                      .build())
              .setResponseParser(
                  ProtoMessageResponseParser.<PatchDeployments.PatchDeployment>newBuilder()
                      .setDefaultInstance(PatchDeployments.PatchDeployment.getDefaultInstance())
                      .setDefaultTypeRegistry(typeRegistry)
                      .build())
              .build();

  private static final ApiMethodDescriptor<
          GuestPolicies.CreateGuestPolicyRequest, GuestPolicies.GuestPolicy>
      createGuestPolicyMethodDescriptor =
          ApiMethodDescriptor
              .<GuestPolicies.CreateGuestPolicyRequest, GuestPolicies.GuestPolicy>newBuilder()
              .setFullMethodName("google.cloud.osconfig.v1beta.OsConfigService/CreateGuestPolicy")
              .setHttpMethod("POST")
              .setType(ApiMethodDescriptor.MethodType.UNARY)
              .setRequestFormatter(
                  ProtoMessageRequestFormatter.<GuestPolicies.CreateGuestPolicyRequest>newBuilder()
                      .setPath(
                          "/v1beta/{parent=projects/*}/guestPolicies",
                          request -> {
                            Map<String, String> fields = new HashMap<>();
                            ProtoRestSerializer<GuestPolicies.CreateGuestPolicyRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putPathParam(fields, "parent", request.getParent());
                            return fields;
                          })
                      .setQueryParamsExtractor(
                          request -> {
                            Map<String, List<String>> fields = new HashMap<>();
                            ProtoRestSerializer<GuestPolicies.CreateGuestPolicyRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putQueryParam(
                                fields, "guestPolicyId", request.getGuestPolicyId());
                            serializer.putQueryParam(fields, "$alt", "json;enum-encoding=int");
                            return fields;
                          })
                      .setRequestBodyExtractor(
                          request ->
                              ProtoRestSerializer.create()
                                  .toBody("guestPolicy", request.getGuestPolicy(), true))
                      .build())
              .setResponseParser(
                  ProtoMessageResponseParser.<GuestPolicies.GuestPolicy>newBuilder()
                      .setDefaultInstance(GuestPolicies.GuestPolicy.getDefaultInstance())
                      .setDefaultTypeRegistry(typeRegistry)
                      .build())
              .build();

  private static final ApiMethodDescriptor<
          GuestPolicies.GetGuestPolicyRequest, GuestPolicies.GuestPolicy>
      getGuestPolicyMethodDescriptor =
          ApiMethodDescriptor
              .<GuestPolicies.GetGuestPolicyRequest, GuestPolicies.GuestPolicy>newBuilder()
              .setFullMethodName("google.cloud.osconfig.v1beta.OsConfigService/GetGuestPolicy")
              .setHttpMethod("GET")
              .setType(ApiMethodDescriptor.MethodType.UNARY)
              .setRequestFormatter(
                  ProtoMessageRequestFormatter.<GuestPolicies.GetGuestPolicyRequest>newBuilder()
                      .setPath(
                          "/v1beta/{name=projects/*/guestPolicies/*}",
                          request -> {
                            Map<String, String> fields = new HashMap<>();
                            ProtoRestSerializer<GuestPolicies.GetGuestPolicyRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putPathParam(fields, "name", request.getName());
                            return fields;
                          })
                      .setQueryParamsExtractor(
                          request -> {
                            Map<String, List<String>> fields = new HashMap<>();
                            ProtoRestSerializer<GuestPolicies.GetGuestPolicyRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putQueryParam(fields, "$alt", "json;enum-encoding=int");
                            return fields;
                          })
                      .setRequestBodyExtractor(request -> null)
                      .build())
              .setResponseParser(
                  ProtoMessageResponseParser.<GuestPolicies.GuestPolicy>newBuilder()
                      .setDefaultInstance(GuestPolicies.GuestPolicy.getDefaultInstance())
                      .setDefaultTypeRegistry(typeRegistry)
                      .build())
              .build();

  private static final ApiMethodDescriptor<
          GuestPolicies.ListGuestPoliciesRequest, GuestPolicies.ListGuestPoliciesResponse>
      listGuestPoliciesMethodDescriptor =
          ApiMethodDescriptor
              .<GuestPolicies.ListGuestPoliciesRequest, GuestPolicies.ListGuestPoliciesResponse>
                  newBuilder()
              .setFullMethodName("google.cloud.osconfig.v1beta.OsConfigService/ListGuestPolicies")
              .setHttpMethod("GET")
              .setType(ApiMethodDescriptor.MethodType.UNARY)
              .setRequestFormatter(
                  ProtoMessageRequestFormatter.<GuestPolicies.ListGuestPoliciesRequest>newBuilder()
                      .setPath(
                          "/v1beta/{parent=projects/*}/guestPolicies",
                          request -> {
                            Map<String, String> fields = new HashMap<>();
                            ProtoRestSerializer<GuestPolicies.ListGuestPoliciesRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putPathParam(fields, "parent", request.getParent());
                            return fields;
                          })
                      .setQueryParamsExtractor(
                          request -> {
                            Map<String, List<String>> fields = new HashMap<>();
                            ProtoRestSerializer<GuestPolicies.ListGuestPoliciesRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putQueryParam(fields, "pageSize", request.getPageSize());
                            serializer.putQueryParam(fields, "pageToken", request.getPageToken());
                            serializer.putQueryParam(fields, "$alt", "json;enum-encoding=int");
                            return fields;
                          })
                      .setRequestBodyExtractor(request -> null)
                      .build())
              .setResponseParser(
                  ProtoMessageResponseParser.<GuestPolicies.ListGuestPoliciesResponse>newBuilder()
                      .setDefaultInstance(
                          GuestPolicies.ListGuestPoliciesResponse.getDefaultInstance())
                      .setDefaultTypeRegistry(typeRegistry)
                      .build())
              .build();

  private static final ApiMethodDescriptor<
          GuestPolicies.UpdateGuestPolicyRequest, GuestPolicies.GuestPolicy>
      updateGuestPolicyMethodDescriptor =
          ApiMethodDescriptor
              .<GuestPolicies.UpdateGuestPolicyRequest, GuestPolicies.GuestPolicy>newBuilder()
              .setFullMethodName("google.cloud.osconfig.v1beta.OsConfigService/UpdateGuestPolicy")
              .setHttpMethod("PATCH")
              .setType(ApiMethodDescriptor.MethodType.UNARY)
              .setRequestFormatter(
                  ProtoMessageRequestFormatter.<GuestPolicies.UpdateGuestPolicyRequest>newBuilder()
                      .setPath(
                          "/v1beta/{guestPolicy.name=projects/*/guestPolicies/*}",
                          request -> {
                            Map<String, String> fields = new HashMap<>();
                            ProtoRestSerializer<GuestPolicies.UpdateGuestPolicyRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putPathParam(
                                fields, "guestPolicy.name", request.getGuestPolicy().getName());
                            return fields;
                          })
                      .setQueryParamsExtractor(
                          request -> {
                            Map<String, List<String>> fields = new HashMap<>();
                            ProtoRestSerializer<GuestPolicies.UpdateGuestPolicyRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putQueryParam(fields, "updateMask", request.getUpdateMask());
                            serializer.putQueryParam(fields, "$alt", "json;enum-encoding=int");
                            return fields;
                          })
                      .setRequestBodyExtractor(
                          request ->
                              ProtoRestSerializer.create()
                                  .toBody("guestPolicy", request.getGuestPolicy(), true))
                      .build())
              .setResponseParser(
                  ProtoMessageResponseParser.<GuestPolicies.GuestPolicy>newBuilder()
                      .setDefaultInstance(GuestPolicies.GuestPolicy.getDefaultInstance())
                      .setDefaultTypeRegistry(typeRegistry)
                      .build())
              .build();

  private static final ApiMethodDescriptor<GuestPolicies.DeleteGuestPolicyRequest, Empty>
      deleteGuestPolicyMethodDescriptor =
          ApiMethodDescriptor.<GuestPolicies.DeleteGuestPolicyRequest, Empty>newBuilder()
              .setFullMethodName("google.cloud.osconfig.v1beta.OsConfigService/DeleteGuestPolicy")
              .setHttpMethod("DELETE")
              .setType(ApiMethodDescriptor.MethodType.UNARY)
              .setRequestFormatter(
                  ProtoMessageRequestFormatter.<GuestPolicies.DeleteGuestPolicyRequest>newBuilder()
                      .setPath(
                          "/v1beta/{name=projects/*/guestPolicies/*}",
                          request -> {
                            Map<String, String> fields = new HashMap<>();
                            ProtoRestSerializer<GuestPolicies.DeleteGuestPolicyRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putPathParam(fields, "name", request.getName());
                            return fields;
                          })
                      .setQueryParamsExtractor(
                          request -> {
                            Map<String, List<String>> fields = new HashMap<>();
                            ProtoRestSerializer<GuestPolicies.DeleteGuestPolicyRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putQueryParam(fields, "$alt", "json;enum-encoding=int");
                            return fields;
                          })
                      .setRequestBodyExtractor(request -> null)
                      .build())
              .setResponseParser(
                  ProtoMessageResponseParser.<Empty>newBuilder()
                      .setDefaultInstance(Empty.getDefaultInstance())
                      .setDefaultTypeRegistry(typeRegistry)
                      .build())
              .build();

  private static final ApiMethodDescriptor<
          GuestPolicies.LookupEffectiveGuestPolicyRequest, GuestPolicies.EffectiveGuestPolicy>
      lookupEffectiveGuestPolicyMethodDescriptor =
          ApiMethodDescriptor
              .<GuestPolicies.LookupEffectiveGuestPolicyRequest, GuestPolicies.EffectiveGuestPolicy>
                  newBuilder()
              .setFullMethodName(
                  "google.cloud.osconfig.v1beta.OsConfigService/LookupEffectiveGuestPolicy")
              .setHttpMethod("POST")
              .setType(ApiMethodDescriptor.MethodType.UNARY)
              .setRequestFormatter(
                  ProtoMessageRequestFormatter
                      .<GuestPolicies.LookupEffectiveGuestPolicyRequest>newBuilder()
                      .setPath(
                          "/v1beta/{instance=projects/*/zones/*/instances/*}:lookupEffectiveGuestPolicy",
                          request -> {
                            Map<String, String> fields = new HashMap<>();
                            ProtoRestSerializer<GuestPolicies.LookupEffectiveGuestPolicyRequest>
                                serializer = ProtoRestSerializer.create();
                            serializer.putPathParam(fields, "instance", request.getInstance());
                            return fields;
                          })
                      .setQueryParamsExtractor(
                          request -> {
                            Map<String, List<String>> fields = new HashMap<>();
                            ProtoRestSerializer<GuestPolicies.LookupEffectiveGuestPolicyRequest>
                                serializer = ProtoRestSerializer.create();
                            serializer.putQueryParam(fields, "$alt", "json;enum-encoding=int");
                            return fields;
                          })
                      .setRequestBodyExtractor(
                          request ->
                              ProtoRestSerializer.create()
                                  .toBody("*", request.toBuilder().clearInstance().build(), true))
                      .build())
              .setResponseParser(
                  ProtoMessageResponseParser.<GuestPolicies.EffectiveGuestPolicy>newBuilder()
                      .setDefaultInstance(GuestPolicies.EffectiveGuestPolicy.getDefaultInstance())
                      .setDefaultTypeRegistry(typeRegistry)
                      .build())
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
  private final UnaryCallable<
          PatchDeployments.UpdatePatchDeploymentRequest, PatchDeployments.PatchDeployment>
      updatePatchDeploymentCallable;
  private final UnaryCallable<
          PatchDeployments.PausePatchDeploymentRequest, PatchDeployments.PatchDeployment>
      pausePatchDeploymentCallable;
  private final UnaryCallable<
          PatchDeployments.ResumePatchDeploymentRequest, PatchDeployments.PatchDeployment>
      resumePatchDeploymentCallable;
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
  private final HttpJsonStubCallableFactory callableFactory;

  public static final HttpJsonOsConfigServiceStub create(OsConfigServiceStubSettings settings)
      throws IOException {
    return new HttpJsonOsConfigServiceStub(settings, ClientContext.create(settings));
  }

  public static final HttpJsonOsConfigServiceStub create(ClientContext clientContext)
      throws IOException {
    return new HttpJsonOsConfigServiceStub(
        OsConfigServiceStubSettings.newHttpJsonBuilder().build(), clientContext);
  }

  public static final HttpJsonOsConfigServiceStub create(
      ClientContext clientContext, HttpJsonStubCallableFactory callableFactory) throws IOException {
    return new HttpJsonOsConfigServiceStub(
        OsConfigServiceStubSettings.newHttpJsonBuilder().build(), clientContext, callableFactory);
  }

  /**
   * Constructs an instance of HttpJsonOsConfigServiceStub, using the given settings. This is
   * protected so that it is easy to make a subclass, but otherwise, the static factory methods
   * should be preferred.
   */
  protected HttpJsonOsConfigServiceStub(
      OsConfigServiceStubSettings settings, ClientContext clientContext) throws IOException {
    this(settings, clientContext, new HttpJsonOsConfigServiceCallableFactory());
  }

  /**
   * Constructs an instance of HttpJsonOsConfigServiceStub, using the given settings. This is
   * protected so that it is easy to make a subclass, but otherwise, the static factory methods
   * should be preferred.
   */
  protected HttpJsonOsConfigServiceStub(
      OsConfigServiceStubSettings settings,
      ClientContext clientContext,
      HttpJsonStubCallableFactory callableFactory)
      throws IOException {
    this.callableFactory = callableFactory;

    HttpJsonCallSettings<PatchJobs.ExecutePatchJobRequest, PatchJobs.PatchJob>
        executePatchJobTransportSettings =
            HttpJsonCallSettings.<PatchJobs.ExecutePatchJobRequest, PatchJobs.PatchJob>newBuilder()
                .setMethodDescriptor(executePatchJobMethodDescriptor)
                .setTypeRegistry(typeRegistry)
                .build();
    HttpJsonCallSettings<PatchJobs.GetPatchJobRequest, PatchJobs.PatchJob>
        getPatchJobTransportSettings =
            HttpJsonCallSettings.<PatchJobs.GetPatchJobRequest, PatchJobs.PatchJob>newBuilder()
                .setMethodDescriptor(getPatchJobMethodDescriptor)
                .setTypeRegistry(typeRegistry)
                .build();
    HttpJsonCallSettings<PatchJobs.CancelPatchJobRequest, PatchJobs.PatchJob>
        cancelPatchJobTransportSettings =
            HttpJsonCallSettings.<PatchJobs.CancelPatchJobRequest, PatchJobs.PatchJob>newBuilder()
                .setMethodDescriptor(cancelPatchJobMethodDescriptor)
                .setTypeRegistry(typeRegistry)
                .build();
    HttpJsonCallSettings<PatchJobs.ListPatchJobsRequest, PatchJobs.ListPatchJobsResponse>
        listPatchJobsTransportSettings =
            HttpJsonCallSettings
                .<PatchJobs.ListPatchJobsRequest, PatchJobs.ListPatchJobsResponse>newBuilder()
                .setMethodDescriptor(listPatchJobsMethodDescriptor)
                .setTypeRegistry(typeRegistry)
                .build();
    HttpJsonCallSettings<
            PatchJobs.ListPatchJobInstanceDetailsRequest,
            PatchJobs.ListPatchJobInstanceDetailsResponse>
        listPatchJobInstanceDetailsTransportSettings =
            HttpJsonCallSettings
                .<PatchJobs.ListPatchJobInstanceDetailsRequest,
                    PatchJobs.ListPatchJobInstanceDetailsResponse>
                    newBuilder()
                .setMethodDescriptor(listPatchJobInstanceDetailsMethodDescriptor)
                .setTypeRegistry(typeRegistry)
                .build();
    HttpJsonCallSettings<
            PatchDeployments.CreatePatchDeploymentRequest, PatchDeployments.PatchDeployment>
        createPatchDeploymentTransportSettings =
            HttpJsonCallSettings
                .<PatchDeployments.CreatePatchDeploymentRequest, PatchDeployments.PatchDeployment>
                    newBuilder()
                .setMethodDescriptor(createPatchDeploymentMethodDescriptor)
                .setTypeRegistry(typeRegistry)
                .build();
    HttpJsonCallSettings<
            PatchDeployments.GetPatchDeploymentRequest, PatchDeployments.PatchDeployment>
        getPatchDeploymentTransportSettings =
            HttpJsonCallSettings
                .<PatchDeployments.GetPatchDeploymentRequest, PatchDeployments.PatchDeployment>
                    newBuilder()
                .setMethodDescriptor(getPatchDeploymentMethodDescriptor)
                .setTypeRegistry(typeRegistry)
                .build();
    HttpJsonCallSettings<
            PatchDeployments.ListPatchDeploymentsRequest,
            PatchDeployments.ListPatchDeploymentsResponse>
        listPatchDeploymentsTransportSettings =
            HttpJsonCallSettings
                .<PatchDeployments.ListPatchDeploymentsRequest,
                    PatchDeployments.ListPatchDeploymentsResponse>
                    newBuilder()
                .setMethodDescriptor(listPatchDeploymentsMethodDescriptor)
                .setTypeRegistry(typeRegistry)
                .build();
    HttpJsonCallSettings<PatchDeployments.DeletePatchDeploymentRequest, Empty>
        deletePatchDeploymentTransportSettings =
            HttpJsonCallSettings.<PatchDeployments.DeletePatchDeploymentRequest, Empty>newBuilder()
                .setMethodDescriptor(deletePatchDeploymentMethodDescriptor)
                .setTypeRegistry(typeRegistry)
                .build();
    HttpJsonCallSettings<
            PatchDeployments.UpdatePatchDeploymentRequest, PatchDeployments.PatchDeployment>
        updatePatchDeploymentTransportSettings =
            HttpJsonCallSettings
                .<PatchDeployments.UpdatePatchDeploymentRequest, PatchDeployments.PatchDeployment>
                    newBuilder()
                .setMethodDescriptor(updatePatchDeploymentMethodDescriptor)
                .setTypeRegistry(typeRegistry)
                .build();
    HttpJsonCallSettings<
            PatchDeployments.PausePatchDeploymentRequest, PatchDeployments.PatchDeployment>
        pausePatchDeploymentTransportSettings =
            HttpJsonCallSettings
                .<PatchDeployments.PausePatchDeploymentRequest, PatchDeployments.PatchDeployment>
                    newBuilder()
                .setMethodDescriptor(pausePatchDeploymentMethodDescriptor)
                .setTypeRegistry(typeRegistry)
                .build();
    HttpJsonCallSettings<
            PatchDeployments.ResumePatchDeploymentRequest, PatchDeployments.PatchDeployment>
        resumePatchDeploymentTransportSettings =
            HttpJsonCallSettings
                .<PatchDeployments.ResumePatchDeploymentRequest, PatchDeployments.PatchDeployment>
                    newBuilder()
                .setMethodDescriptor(resumePatchDeploymentMethodDescriptor)
                .setTypeRegistry(typeRegistry)
                .build();
    HttpJsonCallSettings<GuestPolicies.CreateGuestPolicyRequest, GuestPolicies.GuestPolicy>
        createGuestPolicyTransportSettings =
            HttpJsonCallSettings
                .<GuestPolicies.CreateGuestPolicyRequest, GuestPolicies.GuestPolicy>newBuilder()
                .setMethodDescriptor(createGuestPolicyMethodDescriptor)
                .setTypeRegistry(typeRegistry)
                .build();
    HttpJsonCallSettings<GuestPolicies.GetGuestPolicyRequest, GuestPolicies.GuestPolicy>
        getGuestPolicyTransportSettings =
            HttpJsonCallSettings
                .<GuestPolicies.GetGuestPolicyRequest, GuestPolicies.GuestPolicy>newBuilder()
                .setMethodDescriptor(getGuestPolicyMethodDescriptor)
                .setTypeRegistry(typeRegistry)
                .build();
    HttpJsonCallSettings<
            GuestPolicies.ListGuestPoliciesRequest, GuestPolicies.ListGuestPoliciesResponse>
        listGuestPoliciesTransportSettings =
            HttpJsonCallSettings
                .<GuestPolicies.ListGuestPoliciesRequest, GuestPolicies.ListGuestPoliciesResponse>
                    newBuilder()
                .setMethodDescriptor(listGuestPoliciesMethodDescriptor)
                .setTypeRegistry(typeRegistry)
                .build();
    HttpJsonCallSettings<GuestPolicies.UpdateGuestPolicyRequest, GuestPolicies.GuestPolicy>
        updateGuestPolicyTransportSettings =
            HttpJsonCallSettings
                .<GuestPolicies.UpdateGuestPolicyRequest, GuestPolicies.GuestPolicy>newBuilder()
                .setMethodDescriptor(updateGuestPolicyMethodDescriptor)
                .setTypeRegistry(typeRegistry)
                .build();
    HttpJsonCallSettings<GuestPolicies.DeleteGuestPolicyRequest, Empty>
        deleteGuestPolicyTransportSettings =
            HttpJsonCallSettings.<GuestPolicies.DeleteGuestPolicyRequest, Empty>newBuilder()
                .setMethodDescriptor(deleteGuestPolicyMethodDescriptor)
                .setTypeRegistry(typeRegistry)
                .build();
    HttpJsonCallSettings<
            GuestPolicies.LookupEffectiveGuestPolicyRequest, GuestPolicies.EffectiveGuestPolicy>
        lookupEffectiveGuestPolicyTransportSettings =
            HttpJsonCallSettings
                .<GuestPolicies.LookupEffectiveGuestPolicyRequest,
                    GuestPolicies.EffectiveGuestPolicy>
                    newBuilder()
                .setMethodDescriptor(lookupEffectiveGuestPolicyMethodDescriptor)
                .setTypeRegistry(typeRegistry)
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
    this.updatePatchDeploymentCallable =
        callableFactory.createUnaryCallable(
            updatePatchDeploymentTransportSettings,
            settings.updatePatchDeploymentSettings(),
            clientContext);
    this.pausePatchDeploymentCallable =
        callableFactory.createUnaryCallable(
            pausePatchDeploymentTransportSettings,
            settings.pausePatchDeploymentSettings(),
            clientContext);
    this.resumePatchDeploymentCallable =
        callableFactory.createUnaryCallable(
            resumePatchDeploymentTransportSettings,
            settings.resumePatchDeploymentSettings(),
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

  @InternalApi
  public static List<ApiMethodDescriptor> getMethodDescriptors() {
    List<ApiMethodDescriptor> methodDescriptors = new ArrayList<>();
    methodDescriptors.add(executePatchJobMethodDescriptor);
    methodDescriptors.add(getPatchJobMethodDescriptor);
    methodDescriptors.add(cancelPatchJobMethodDescriptor);
    methodDescriptors.add(listPatchJobsMethodDescriptor);
    methodDescriptors.add(listPatchJobInstanceDetailsMethodDescriptor);
    methodDescriptors.add(createPatchDeploymentMethodDescriptor);
    methodDescriptors.add(getPatchDeploymentMethodDescriptor);
    methodDescriptors.add(listPatchDeploymentsMethodDescriptor);
    methodDescriptors.add(deletePatchDeploymentMethodDescriptor);
    methodDescriptors.add(updatePatchDeploymentMethodDescriptor);
    methodDescriptors.add(pausePatchDeploymentMethodDescriptor);
    methodDescriptors.add(resumePatchDeploymentMethodDescriptor);
    methodDescriptors.add(createGuestPolicyMethodDescriptor);
    methodDescriptors.add(getGuestPolicyMethodDescriptor);
    methodDescriptors.add(listGuestPoliciesMethodDescriptor);
    methodDescriptors.add(updateGuestPolicyMethodDescriptor);
    methodDescriptors.add(deleteGuestPolicyMethodDescriptor);
    methodDescriptors.add(lookupEffectiveGuestPolicyMethodDescriptor);
    return methodDescriptors;
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
  public UnaryCallable<
          PatchDeployments.UpdatePatchDeploymentRequest, PatchDeployments.PatchDeployment>
      updatePatchDeploymentCallable() {
    return updatePatchDeploymentCallable;
  }

  @Override
  public UnaryCallable<
          PatchDeployments.PausePatchDeploymentRequest, PatchDeployments.PatchDeployment>
      pausePatchDeploymentCallable() {
    return pausePatchDeploymentCallable;
  }

  @Override
  public UnaryCallable<
          PatchDeployments.ResumePatchDeploymentRequest, PatchDeployments.PatchDeployment>
      resumePatchDeploymentCallable() {
    return resumePatchDeploymentCallable;
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
