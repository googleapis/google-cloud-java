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

package com.google.cloud.dlp.v2.stub;

import static com.google.cloud.dlp.v2.DlpServiceClient.ListDeidentifyTemplatesPagedResponse;
import static com.google.cloud.dlp.v2.DlpServiceClient.ListDlpJobsPagedResponse;
import static com.google.cloud.dlp.v2.DlpServiceClient.ListInspectTemplatesPagedResponse;
import static com.google.cloud.dlp.v2.DlpServiceClient.ListJobTriggersPagedResponse;
import static com.google.cloud.dlp.v2.DlpServiceClient.ListStoredInfoTypesPagedResponse;

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
import com.google.privacy.dlp.v2.ActivateJobTriggerRequest;
import com.google.privacy.dlp.v2.CancelDlpJobRequest;
import com.google.privacy.dlp.v2.CreateDeidentifyTemplateRequest;
import com.google.privacy.dlp.v2.CreateDlpJobRequest;
import com.google.privacy.dlp.v2.CreateInspectTemplateRequest;
import com.google.privacy.dlp.v2.CreateJobTriggerRequest;
import com.google.privacy.dlp.v2.CreateStoredInfoTypeRequest;
import com.google.privacy.dlp.v2.DeidentifyContentRequest;
import com.google.privacy.dlp.v2.DeidentifyContentResponse;
import com.google.privacy.dlp.v2.DeidentifyTemplate;
import com.google.privacy.dlp.v2.DeleteDeidentifyTemplateRequest;
import com.google.privacy.dlp.v2.DeleteDlpJobRequest;
import com.google.privacy.dlp.v2.DeleteInspectTemplateRequest;
import com.google.privacy.dlp.v2.DeleteJobTriggerRequest;
import com.google.privacy.dlp.v2.DeleteStoredInfoTypeRequest;
import com.google.privacy.dlp.v2.DlpJob;
import com.google.privacy.dlp.v2.FinishDlpJobRequest;
import com.google.privacy.dlp.v2.GetDeidentifyTemplateRequest;
import com.google.privacy.dlp.v2.GetDlpJobRequest;
import com.google.privacy.dlp.v2.GetInspectTemplateRequest;
import com.google.privacy.dlp.v2.GetJobTriggerRequest;
import com.google.privacy.dlp.v2.GetStoredInfoTypeRequest;
import com.google.privacy.dlp.v2.HybridInspectDlpJobRequest;
import com.google.privacy.dlp.v2.HybridInspectJobTriggerRequest;
import com.google.privacy.dlp.v2.HybridInspectResponse;
import com.google.privacy.dlp.v2.InspectContentRequest;
import com.google.privacy.dlp.v2.InspectContentResponse;
import com.google.privacy.dlp.v2.InspectTemplate;
import com.google.privacy.dlp.v2.JobTrigger;
import com.google.privacy.dlp.v2.ListDeidentifyTemplatesRequest;
import com.google.privacy.dlp.v2.ListDeidentifyTemplatesResponse;
import com.google.privacy.dlp.v2.ListDlpJobsRequest;
import com.google.privacy.dlp.v2.ListDlpJobsResponse;
import com.google.privacy.dlp.v2.ListInfoTypesRequest;
import com.google.privacy.dlp.v2.ListInfoTypesResponse;
import com.google.privacy.dlp.v2.ListInspectTemplatesRequest;
import com.google.privacy.dlp.v2.ListInspectTemplatesResponse;
import com.google.privacy.dlp.v2.ListJobTriggersRequest;
import com.google.privacy.dlp.v2.ListJobTriggersResponse;
import com.google.privacy.dlp.v2.ListStoredInfoTypesRequest;
import com.google.privacy.dlp.v2.ListStoredInfoTypesResponse;
import com.google.privacy.dlp.v2.RedactImageRequest;
import com.google.privacy.dlp.v2.RedactImageResponse;
import com.google.privacy.dlp.v2.ReidentifyContentRequest;
import com.google.privacy.dlp.v2.ReidentifyContentResponse;
import com.google.privacy.dlp.v2.StoredInfoType;
import com.google.privacy.dlp.v2.UpdateDeidentifyTemplateRequest;
import com.google.privacy.dlp.v2.UpdateInspectTemplateRequest;
import com.google.privacy.dlp.v2.UpdateJobTriggerRequest;
import com.google.privacy.dlp.v2.UpdateStoredInfoTypeRequest;
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
 * REST stub implementation for the DlpService service API.
 *
 * <p>This class is for advanced usage and reflects the underlying API directly.
 */
@Generated("by gapic-generator-java")
@BetaApi
public class HttpJsonDlpServiceStub extends DlpServiceStub {
  private static final TypeRegistry typeRegistry = TypeRegistry.newBuilder().build();

  private static final ApiMethodDescriptor<InspectContentRequest, InspectContentResponse>
      inspectContentMethodDescriptor =
          ApiMethodDescriptor.<InspectContentRequest, InspectContentResponse>newBuilder()
              .setFullMethodName("google.privacy.dlp.v2.DlpService/InspectContent")
              .setHttpMethod("POST")
              .setType(ApiMethodDescriptor.MethodType.UNARY)
              .setRequestFormatter(
                  ProtoMessageRequestFormatter.<InspectContentRequest>newBuilder()
                      .setPath(
                          "/v2/{parent=projects/*}/content:inspect",
                          request -> {
                            Map<String, String> fields = new HashMap<>();
                            ProtoRestSerializer<InspectContentRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putPathParam(fields, "parent", request.getParent());
                            return fields;
                          })
                      .setAdditionalPaths("/v2/{parent=projects/*/locations/*}/content:inspect")
                      .setQueryParamsExtractor(
                          request -> {
                            Map<String, List<String>> fields = new HashMap<>();
                            ProtoRestSerializer<InspectContentRequest> serializer =
                                ProtoRestSerializer.create();
                            return fields;
                          })
                      .setRequestBodyExtractor(
                          request ->
                              ProtoRestSerializer.create()
                                  .toBody("*", request.toBuilder().clearParent().build(), false))
                      .build())
              .setResponseParser(
                  ProtoMessageResponseParser.<InspectContentResponse>newBuilder()
                      .setDefaultInstance(InspectContentResponse.getDefaultInstance())
                      .setDefaultTypeRegistry(typeRegistry)
                      .build())
              .build();

  private static final ApiMethodDescriptor<RedactImageRequest, RedactImageResponse>
      redactImageMethodDescriptor =
          ApiMethodDescriptor.<RedactImageRequest, RedactImageResponse>newBuilder()
              .setFullMethodName("google.privacy.dlp.v2.DlpService/RedactImage")
              .setHttpMethod("POST")
              .setType(ApiMethodDescriptor.MethodType.UNARY)
              .setRequestFormatter(
                  ProtoMessageRequestFormatter.<RedactImageRequest>newBuilder()
                      .setPath(
                          "/v2/{parent=projects/*}/image:redact",
                          request -> {
                            Map<String, String> fields = new HashMap<>();
                            ProtoRestSerializer<RedactImageRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putPathParam(fields, "parent", request.getParent());
                            return fields;
                          })
                      .setAdditionalPaths("/v2/{parent=projects/*/locations/*}/image:redact")
                      .setQueryParamsExtractor(
                          request -> {
                            Map<String, List<String>> fields = new HashMap<>();
                            ProtoRestSerializer<RedactImageRequest> serializer =
                                ProtoRestSerializer.create();
                            return fields;
                          })
                      .setRequestBodyExtractor(
                          request ->
                              ProtoRestSerializer.create()
                                  .toBody("*", request.toBuilder().clearParent().build(), false))
                      .build())
              .setResponseParser(
                  ProtoMessageResponseParser.<RedactImageResponse>newBuilder()
                      .setDefaultInstance(RedactImageResponse.getDefaultInstance())
                      .setDefaultTypeRegistry(typeRegistry)
                      .build())
              .build();

  private static final ApiMethodDescriptor<DeidentifyContentRequest, DeidentifyContentResponse>
      deidentifyContentMethodDescriptor =
          ApiMethodDescriptor.<DeidentifyContentRequest, DeidentifyContentResponse>newBuilder()
              .setFullMethodName("google.privacy.dlp.v2.DlpService/DeidentifyContent")
              .setHttpMethod("POST")
              .setType(ApiMethodDescriptor.MethodType.UNARY)
              .setRequestFormatter(
                  ProtoMessageRequestFormatter.<DeidentifyContentRequest>newBuilder()
                      .setPath(
                          "/v2/{parent=projects/*}/content:deidentify",
                          request -> {
                            Map<String, String> fields = new HashMap<>();
                            ProtoRestSerializer<DeidentifyContentRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putPathParam(fields, "parent", request.getParent());
                            return fields;
                          })
                      .setAdditionalPaths("/v2/{parent=projects/*/locations/*}/content:deidentify")
                      .setQueryParamsExtractor(
                          request -> {
                            Map<String, List<String>> fields = new HashMap<>();
                            ProtoRestSerializer<DeidentifyContentRequest> serializer =
                                ProtoRestSerializer.create();
                            return fields;
                          })
                      .setRequestBodyExtractor(
                          request ->
                              ProtoRestSerializer.create()
                                  .toBody("*", request.toBuilder().clearParent().build(), false))
                      .build())
              .setResponseParser(
                  ProtoMessageResponseParser.<DeidentifyContentResponse>newBuilder()
                      .setDefaultInstance(DeidentifyContentResponse.getDefaultInstance())
                      .setDefaultTypeRegistry(typeRegistry)
                      .build())
              .build();

  private static final ApiMethodDescriptor<ReidentifyContentRequest, ReidentifyContentResponse>
      reidentifyContentMethodDescriptor =
          ApiMethodDescriptor.<ReidentifyContentRequest, ReidentifyContentResponse>newBuilder()
              .setFullMethodName("google.privacy.dlp.v2.DlpService/ReidentifyContent")
              .setHttpMethod("POST")
              .setType(ApiMethodDescriptor.MethodType.UNARY)
              .setRequestFormatter(
                  ProtoMessageRequestFormatter.<ReidentifyContentRequest>newBuilder()
                      .setPath(
                          "/v2/{parent=projects/*}/content:reidentify",
                          request -> {
                            Map<String, String> fields = new HashMap<>();
                            ProtoRestSerializer<ReidentifyContentRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putPathParam(fields, "parent", request.getParent());
                            return fields;
                          })
                      .setAdditionalPaths("/v2/{parent=projects/*/locations/*}/content:reidentify")
                      .setQueryParamsExtractor(
                          request -> {
                            Map<String, List<String>> fields = new HashMap<>();
                            ProtoRestSerializer<ReidentifyContentRequest> serializer =
                                ProtoRestSerializer.create();
                            return fields;
                          })
                      .setRequestBodyExtractor(
                          request ->
                              ProtoRestSerializer.create()
                                  .toBody("*", request.toBuilder().clearParent().build(), false))
                      .build())
              .setResponseParser(
                  ProtoMessageResponseParser.<ReidentifyContentResponse>newBuilder()
                      .setDefaultInstance(ReidentifyContentResponse.getDefaultInstance())
                      .setDefaultTypeRegistry(typeRegistry)
                      .build())
              .build();

  private static final ApiMethodDescriptor<ListInfoTypesRequest, ListInfoTypesResponse>
      listInfoTypesMethodDescriptor =
          ApiMethodDescriptor.<ListInfoTypesRequest, ListInfoTypesResponse>newBuilder()
              .setFullMethodName("google.privacy.dlp.v2.DlpService/ListInfoTypes")
              .setHttpMethod("GET")
              .setType(ApiMethodDescriptor.MethodType.UNARY)
              .setRequestFormatter(
                  ProtoMessageRequestFormatter.<ListInfoTypesRequest>newBuilder()
                      .setPath(
                          "/v2/infoTypes",
                          request -> {
                            Map<String, String> fields = new HashMap<>();
                            ProtoRestSerializer<ListInfoTypesRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putPathParam(fields, "parent", request.getParent());
                            return fields;
                          })
                      .setAdditionalPaths("/v2/{parent=locations/*}/infoTypes")
                      .setQueryParamsExtractor(
                          request -> {
                            Map<String, List<String>> fields = new HashMap<>();
                            ProtoRestSerializer<ListInfoTypesRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putQueryParam(fields, "filter", request.getFilter());
                            serializer.putQueryParam(
                                fields, "languageCode", request.getLanguageCode());
                            serializer.putQueryParam(fields, "locationId", request.getLocationId());
                            return fields;
                          })
                      .setRequestBodyExtractor(request -> null)
                      .build())
              .setResponseParser(
                  ProtoMessageResponseParser.<ListInfoTypesResponse>newBuilder()
                      .setDefaultInstance(ListInfoTypesResponse.getDefaultInstance())
                      .setDefaultTypeRegistry(typeRegistry)
                      .build())
              .build();

  private static final ApiMethodDescriptor<CreateInspectTemplateRequest, InspectTemplate>
      createInspectTemplateMethodDescriptor =
          ApiMethodDescriptor.<CreateInspectTemplateRequest, InspectTemplate>newBuilder()
              .setFullMethodName("google.privacy.dlp.v2.DlpService/CreateInspectTemplate")
              .setHttpMethod("POST")
              .setType(ApiMethodDescriptor.MethodType.UNARY)
              .setRequestFormatter(
                  ProtoMessageRequestFormatter.<CreateInspectTemplateRequest>newBuilder()
                      .setPath(
                          "/v2/{parent=organizations/*}/inspectTemplates",
                          request -> {
                            Map<String, String> fields = new HashMap<>();
                            ProtoRestSerializer<CreateInspectTemplateRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putPathParam(fields, "parent", request.getParent());
                            return fields;
                          })
                      .setAdditionalPaths(
                          "/v2/{parent=organizations/*/locations/*}/inspectTemplates",
                          "/v2/{parent=projects/*}/inspectTemplates",
                          "/v2/{parent=projects/*/locations/*}/inspectTemplates")
                      .setQueryParamsExtractor(
                          request -> {
                            Map<String, List<String>> fields = new HashMap<>();
                            ProtoRestSerializer<CreateInspectTemplateRequest> serializer =
                                ProtoRestSerializer.create();
                            return fields;
                          })
                      .setRequestBodyExtractor(
                          request ->
                              ProtoRestSerializer.create()
                                  .toBody("*", request.toBuilder().clearParent().build(), false))
                      .build())
              .setResponseParser(
                  ProtoMessageResponseParser.<InspectTemplate>newBuilder()
                      .setDefaultInstance(InspectTemplate.getDefaultInstance())
                      .setDefaultTypeRegistry(typeRegistry)
                      .build())
              .build();

  private static final ApiMethodDescriptor<UpdateInspectTemplateRequest, InspectTemplate>
      updateInspectTemplateMethodDescriptor =
          ApiMethodDescriptor.<UpdateInspectTemplateRequest, InspectTemplate>newBuilder()
              .setFullMethodName("google.privacy.dlp.v2.DlpService/UpdateInspectTemplate")
              .setHttpMethod("PATCH")
              .setType(ApiMethodDescriptor.MethodType.UNARY)
              .setRequestFormatter(
                  ProtoMessageRequestFormatter.<UpdateInspectTemplateRequest>newBuilder()
                      .setPath(
                          "/v2/{name=organizations/*/inspectTemplates/*}",
                          request -> {
                            Map<String, String> fields = new HashMap<>();
                            ProtoRestSerializer<UpdateInspectTemplateRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putPathParam(fields, "name", request.getName());
                            return fields;
                          })
                      .setAdditionalPaths(
                          "/v2/{name=organizations/*/locations/*/inspectTemplates/*}",
                          "/v2/{name=projects/*/inspectTemplates/*}",
                          "/v2/{name=projects/*/locations/*/inspectTemplates/*}")
                      .setQueryParamsExtractor(
                          request -> {
                            Map<String, List<String>> fields = new HashMap<>();
                            ProtoRestSerializer<UpdateInspectTemplateRequest> serializer =
                                ProtoRestSerializer.create();
                            return fields;
                          })
                      .setRequestBodyExtractor(
                          request ->
                              ProtoRestSerializer.create()
                                  .toBody("*", request.toBuilder().clearName().build(), false))
                      .build())
              .setResponseParser(
                  ProtoMessageResponseParser.<InspectTemplate>newBuilder()
                      .setDefaultInstance(InspectTemplate.getDefaultInstance())
                      .setDefaultTypeRegistry(typeRegistry)
                      .build())
              .build();

  private static final ApiMethodDescriptor<GetInspectTemplateRequest, InspectTemplate>
      getInspectTemplateMethodDescriptor =
          ApiMethodDescriptor.<GetInspectTemplateRequest, InspectTemplate>newBuilder()
              .setFullMethodName("google.privacy.dlp.v2.DlpService/GetInspectTemplate")
              .setHttpMethod("GET")
              .setType(ApiMethodDescriptor.MethodType.UNARY)
              .setRequestFormatter(
                  ProtoMessageRequestFormatter.<GetInspectTemplateRequest>newBuilder()
                      .setPath(
                          "/v2/{name=organizations/*/inspectTemplates/*}",
                          request -> {
                            Map<String, String> fields = new HashMap<>();
                            ProtoRestSerializer<GetInspectTemplateRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putPathParam(fields, "name", request.getName());
                            return fields;
                          })
                      .setAdditionalPaths(
                          "/v2/{name=organizations/*/locations/*/inspectTemplates/*}",
                          "/v2/{name=projects/*/inspectTemplates/*}",
                          "/v2/{name=projects/*/locations/*/inspectTemplates/*}")
                      .setQueryParamsExtractor(
                          request -> {
                            Map<String, List<String>> fields = new HashMap<>();
                            ProtoRestSerializer<GetInspectTemplateRequest> serializer =
                                ProtoRestSerializer.create();
                            return fields;
                          })
                      .setRequestBodyExtractor(request -> null)
                      .build())
              .setResponseParser(
                  ProtoMessageResponseParser.<InspectTemplate>newBuilder()
                      .setDefaultInstance(InspectTemplate.getDefaultInstance())
                      .setDefaultTypeRegistry(typeRegistry)
                      .build())
              .build();

  private static final ApiMethodDescriptor<
          ListInspectTemplatesRequest, ListInspectTemplatesResponse>
      listInspectTemplatesMethodDescriptor =
          ApiMethodDescriptor
              .<ListInspectTemplatesRequest, ListInspectTemplatesResponse>newBuilder()
              .setFullMethodName("google.privacy.dlp.v2.DlpService/ListInspectTemplates")
              .setHttpMethod("GET")
              .setType(ApiMethodDescriptor.MethodType.UNARY)
              .setRequestFormatter(
                  ProtoMessageRequestFormatter.<ListInspectTemplatesRequest>newBuilder()
                      .setPath(
                          "/v2/{parent=organizations/*}/inspectTemplates",
                          request -> {
                            Map<String, String> fields = new HashMap<>();
                            ProtoRestSerializer<ListInspectTemplatesRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putPathParam(fields, "parent", request.getParent());
                            return fields;
                          })
                      .setAdditionalPaths(
                          "/v2/{parent=organizations/*/locations/*}/inspectTemplates",
                          "/v2/{parent=projects/*}/inspectTemplates",
                          "/v2/{parent=projects/*/locations/*}/inspectTemplates")
                      .setQueryParamsExtractor(
                          request -> {
                            Map<String, List<String>> fields = new HashMap<>();
                            ProtoRestSerializer<ListInspectTemplatesRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putQueryParam(fields, "locationId", request.getLocationId());
                            serializer.putQueryParam(fields, "orderBy", request.getOrderBy());
                            serializer.putQueryParam(fields, "pageSize", request.getPageSize());
                            serializer.putQueryParam(fields, "pageToken", request.getPageToken());
                            return fields;
                          })
                      .setRequestBodyExtractor(request -> null)
                      .build())
              .setResponseParser(
                  ProtoMessageResponseParser.<ListInspectTemplatesResponse>newBuilder()
                      .setDefaultInstance(ListInspectTemplatesResponse.getDefaultInstance())
                      .setDefaultTypeRegistry(typeRegistry)
                      .build())
              .build();

  private static final ApiMethodDescriptor<DeleteInspectTemplateRequest, Empty>
      deleteInspectTemplateMethodDescriptor =
          ApiMethodDescriptor.<DeleteInspectTemplateRequest, Empty>newBuilder()
              .setFullMethodName("google.privacy.dlp.v2.DlpService/DeleteInspectTemplate")
              .setHttpMethod("DELETE")
              .setType(ApiMethodDescriptor.MethodType.UNARY)
              .setRequestFormatter(
                  ProtoMessageRequestFormatter.<DeleteInspectTemplateRequest>newBuilder()
                      .setPath(
                          "/v2/{name=organizations/*/inspectTemplates/*}",
                          request -> {
                            Map<String, String> fields = new HashMap<>();
                            ProtoRestSerializer<DeleteInspectTemplateRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putPathParam(fields, "name", request.getName());
                            return fields;
                          })
                      .setAdditionalPaths(
                          "/v2/{name=organizations/*/locations/*/inspectTemplates/*}",
                          "/v2/{name=projects/*/inspectTemplates/*}",
                          "/v2/{name=projects/*/locations/*/inspectTemplates/*}")
                      .setQueryParamsExtractor(
                          request -> {
                            Map<String, List<String>> fields = new HashMap<>();
                            ProtoRestSerializer<DeleteInspectTemplateRequest> serializer =
                                ProtoRestSerializer.create();
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

  private static final ApiMethodDescriptor<CreateDeidentifyTemplateRequest, DeidentifyTemplate>
      createDeidentifyTemplateMethodDescriptor =
          ApiMethodDescriptor.<CreateDeidentifyTemplateRequest, DeidentifyTemplate>newBuilder()
              .setFullMethodName("google.privacy.dlp.v2.DlpService/CreateDeidentifyTemplate")
              .setHttpMethod("POST")
              .setType(ApiMethodDescriptor.MethodType.UNARY)
              .setRequestFormatter(
                  ProtoMessageRequestFormatter.<CreateDeidentifyTemplateRequest>newBuilder()
                      .setPath(
                          "/v2/{parent=organizations/*}/deidentifyTemplates",
                          request -> {
                            Map<String, String> fields = new HashMap<>();
                            ProtoRestSerializer<CreateDeidentifyTemplateRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putPathParam(fields, "parent", request.getParent());
                            return fields;
                          })
                      .setAdditionalPaths(
                          "/v2/{parent=organizations/*/locations/*}/deidentifyTemplates",
                          "/v2/{parent=projects/*}/deidentifyTemplates",
                          "/v2/{parent=projects/*/locations/*}/deidentifyTemplates")
                      .setQueryParamsExtractor(
                          request -> {
                            Map<String, List<String>> fields = new HashMap<>();
                            ProtoRestSerializer<CreateDeidentifyTemplateRequest> serializer =
                                ProtoRestSerializer.create();
                            return fields;
                          })
                      .setRequestBodyExtractor(
                          request ->
                              ProtoRestSerializer.create()
                                  .toBody("*", request.toBuilder().clearParent().build(), false))
                      .build())
              .setResponseParser(
                  ProtoMessageResponseParser.<DeidentifyTemplate>newBuilder()
                      .setDefaultInstance(DeidentifyTemplate.getDefaultInstance())
                      .setDefaultTypeRegistry(typeRegistry)
                      .build())
              .build();

  private static final ApiMethodDescriptor<UpdateDeidentifyTemplateRequest, DeidentifyTemplate>
      updateDeidentifyTemplateMethodDescriptor =
          ApiMethodDescriptor.<UpdateDeidentifyTemplateRequest, DeidentifyTemplate>newBuilder()
              .setFullMethodName("google.privacy.dlp.v2.DlpService/UpdateDeidentifyTemplate")
              .setHttpMethod("PATCH")
              .setType(ApiMethodDescriptor.MethodType.UNARY)
              .setRequestFormatter(
                  ProtoMessageRequestFormatter.<UpdateDeidentifyTemplateRequest>newBuilder()
                      .setPath(
                          "/v2/{name=organizations/*/deidentifyTemplates/*}",
                          request -> {
                            Map<String, String> fields = new HashMap<>();
                            ProtoRestSerializer<UpdateDeidentifyTemplateRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putPathParam(fields, "name", request.getName());
                            return fields;
                          })
                      .setAdditionalPaths(
                          "/v2/{name=organizations/*/locations/*/deidentifyTemplates/*}",
                          "/v2/{name=projects/*/deidentifyTemplates/*}",
                          "/v2/{name=projects/*/locations/*/deidentifyTemplates/*}")
                      .setQueryParamsExtractor(
                          request -> {
                            Map<String, List<String>> fields = new HashMap<>();
                            ProtoRestSerializer<UpdateDeidentifyTemplateRequest> serializer =
                                ProtoRestSerializer.create();
                            return fields;
                          })
                      .setRequestBodyExtractor(
                          request ->
                              ProtoRestSerializer.create()
                                  .toBody("*", request.toBuilder().clearName().build(), false))
                      .build())
              .setResponseParser(
                  ProtoMessageResponseParser.<DeidentifyTemplate>newBuilder()
                      .setDefaultInstance(DeidentifyTemplate.getDefaultInstance())
                      .setDefaultTypeRegistry(typeRegistry)
                      .build())
              .build();

  private static final ApiMethodDescriptor<GetDeidentifyTemplateRequest, DeidentifyTemplate>
      getDeidentifyTemplateMethodDescriptor =
          ApiMethodDescriptor.<GetDeidentifyTemplateRequest, DeidentifyTemplate>newBuilder()
              .setFullMethodName("google.privacy.dlp.v2.DlpService/GetDeidentifyTemplate")
              .setHttpMethod("GET")
              .setType(ApiMethodDescriptor.MethodType.UNARY)
              .setRequestFormatter(
                  ProtoMessageRequestFormatter.<GetDeidentifyTemplateRequest>newBuilder()
                      .setPath(
                          "/v2/{name=organizations/*/deidentifyTemplates/*}",
                          request -> {
                            Map<String, String> fields = new HashMap<>();
                            ProtoRestSerializer<GetDeidentifyTemplateRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putPathParam(fields, "name", request.getName());
                            return fields;
                          })
                      .setAdditionalPaths(
                          "/v2/{name=organizations/*/locations/*/deidentifyTemplates/*}",
                          "/v2/{name=projects/*/deidentifyTemplates/*}",
                          "/v2/{name=projects/*/locations/*/deidentifyTemplates/*}")
                      .setQueryParamsExtractor(
                          request -> {
                            Map<String, List<String>> fields = new HashMap<>();
                            ProtoRestSerializer<GetDeidentifyTemplateRequest> serializer =
                                ProtoRestSerializer.create();
                            return fields;
                          })
                      .setRequestBodyExtractor(request -> null)
                      .build())
              .setResponseParser(
                  ProtoMessageResponseParser.<DeidentifyTemplate>newBuilder()
                      .setDefaultInstance(DeidentifyTemplate.getDefaultInstance())
                      .setDefaultTypeRegistry(typeRegistry)
                      .build())
              .build();

  private static final ApiMethodDescriptor<
          ListDeidentifyTemplatesRequest, ListDeidentifyTemplatesResponse>
      listDeidentifyTemplatesMethodDescriptor =
          ApiMethodDescriptor
              .<ListDeidentifyTemplatesRequest, ListDeidentifyTemplatesResponse>newBuilder()
              .setFullMethodName("google.privacy.dlp.v2.DlpService/ListDeidentifyTemplates")
              .setHttpMethod("GET")
              .setType(ApiMethodDescriptor.MethodType.UNARY)
              .setRequestFormatter(
                  ProtoMessageRequestFormatter.<ListDeidentifyTemplatesRequest>newBuilder()
                      .setPath(
                          "/v2/{parent=organizations/*}/deidentifyTemplates",
                          request -> {
                            Map<String, String> fields = new HashMap<>();
                            ProtoRestSerializer<ListDeidentifyTemplatesRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putPathParam(fields, "parent", request.getParent());
                            return fields;
                          })
                      .setAdditionalPaths(
                          "/v2/{parent=organizations/*/locations/*}/deidentifyTemplates",
                          "/v2/{parent=projects/*}/deidentifyTemplates",
                          "/v2/{parent=projects/*/locations/*}/deidentifyTemplates")
                      .setQueryParamsExtractor(
                          request -> {
                            Map<String, List<String>> fields = new HashMap<>();
                            ProtoRestSerializer<ListDeidentifyTemplatesRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putQueryParam(fields, "locationId", request.getLocationId());
                            serializer.putQueryParam(fields, "orderBy", request.getOrderBy());
                            serializer.putQueryParam(fields, "pageSize", request.getPageSize());
                            serializer.putQueryParam(fields, "pageToken", request.getPageToken());
                            return fields;
                          })
                      .setRequestBodyExtractor(request -> null)
                      .build())
              .setResponseParser(
                  ProtoMessageResponseParser.<ListDeidentifyTemplatesResponse>newBuilder()
                      .setDefaultInstance(ListDeidentifyTemplatesResponse.getDefaultInstance())
                      .setDefaultTypeRegistry(typeRegistry)
                      .build())
              .build();

  private static final ApiMethodDescriptor<DeleteDeidentifyTemplateRequest, Empty>
      deleteDeidentifyTemplateMethodDescriptor =
          ApiMethodDescriptor.<DeleteDeidentifyTemplateRequest, Empty>newBuilder()
              .setFullMethodName("google.privacy.dlp.v2.DlpService/DeleteDeidentifyTemplate")
              .setHttpMethod("DELETE")
              .setType(ApiMethodDescriptor.MethodType.UNARY)
              .setRequestFormatter(
                  ProtoMessageRequestFormatter.<DeleteDeidentifyTemplateRequest>newBuilder()
                      .setPath(
                          "/v2/{name=organizations/*/deidentifyTemplates/*}",
                          request -> {
                            Map<String, String> fields = new HashMap<>();
                            ProtoRestSerializer<DeleteDeidentifyTemplateRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putPathParam(fields, "name", request.getName());
                            return fields;
                          })
                      .setAdditionalPaths(
                          "/v2/{name=organizations/*/locations/*/deidentifyTemplates/*}",
                          "/v2/{name=projects/*/deidentifyTemplates/*}",
                          "/v2/{name=projects/*/locations/*/deidentifyTemplates/*}")
                      .setQueryParamsExtractor(
                          request -> {
                            Map<String, List<String>> fields = new HashMap<>();
                            ProtoRestSerializer<DeleteDeidentifyTemplateRequest> serializer =
                                ProtoRestSerializer.create();
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

  private static final ApiMethodDescriptor<CreateJobTriggerRequest, JobTrigger>
      createJobTriggerMethodDescriptor =
          ApiMethodDescriptor.<CreateJobTriggerRequest, JobTrigger>newBuilder()
              .setFullMethodName("google.privacy.dlp.v2.DlpService/CreateJobTrigger")
              .setHttpMethod("POST")
              .setType(ApiMethodDescriptor.MethodType.UNARY)
              .setRequestFormatter(
                  ProtoMessageRequestFormatter.<CreateJobTriggerRequest>newBuilder()
                      .setPath(
                          "/v2/{parent=projects/*}/jobTriggers",
                          request -> {
                            Map<String, String> fields = new HashMap<>();
                            ProtoRestSerializer<CreateJobTriggerRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putPathParam(fields, "parent", request.getParent());
                            return fields;
                          })
                      .setAdditionalPaths(
                          "/v2/{parent=projects/*/locations/*}/jobTriggers",
                          "/v2/{parent=organizations/*/locations/*}/jobTriggers")
                      .setQueryParamsExtractor(
                          request -> {
                            Map<String, List<String>> fields = new HashMap<>();
                            ProtoRestSerializer<CreateJobTriggerRequest> serializer =
                                ProtoRestSerializer.create();
                            return fields;
                          })
                      .setRequestBodyExtractor(
                          request ->
                              ProtoRestSerializer.create()
                                  .toBody("*", request.toBuilder().clearParent().build(), false))
                      .build())
              .setResponseParser(
                  ProtoMessageResponseParser.<JobTrigger>newBuilder()
                      .setDefaultInstance(JobTrigger.getDefaultInstance())
                      .setDefaultTypeRegistry(typeRegistry)
                      .build())
              .build();

  private static final ApiMethodDescriptor<UpdateJobTriggerRequest, JobTrigger>
      updateJobTriggerMethodDescriptor =
          ApiMethodDescriptor.<UpdateJobTriggerRequest, JobTrigger>newBuilder()
              .setFullMethodName("google.privacy.dlp.v2.DlpService/UpdateJobTrigger")
              .setHttpMethod("PATCH")
              .setType(ApiMethodDescriptor.MethodType.UNARY)
              .setRequestFormatter(
                  ProtoMessageRequestFormatter.<UpdateJobTriggerRequest>newBuilder()
                      .setPath(
                          "/v2/{name=projects/*/jobTriggers/*}",
                          request -> {
                            Map<String, String> fields = new HashMap<>();
                            ProtoRestSerializer<UpdateJobTriggerRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putPathParam(fields, "name", request.getName());
                            return fields;
                          })
                      .setAdditionalPaths(
                          "/v2/{name=projects/*/locations/*/jobTriggers/*}",
                          "/v2/{name=organizations/*/locations/*/jobTriggers/*}")
                      .setQueryParamsExtractor(
                          request -> {
                            Map<String, List<String>> fields = new HashMap<>();
                            ProtoRestSerializer<UpdateJobTriggerRequest> serializer =
                                ProtoRestSerializer.create();
                            return fields;
                          })
                      .setRequestBodyExtractor(
                          request ->
                              ProtoRestSerializer.create()
                                  .toBody("*", request.toBuilder().clearName().build(), false))
                      .build())
              .setResponseParser(
                  ProtoMessageResponseParser.<JobTrigger>newBuilder()
                      .setDefaultInstance(JobTrigger.getDefaultInstance())
                      .setDefaultTypeRegistry(typeRegistry)
                      .build())
              .build();

  private static final ApiMethodDescriptor<HybridInspectJobTriggerRequest, HybridInspectResponse>
      hybridInspectJobTriggerMethodDescriptor =
          ApiMethodDescriptor.<HybridInspectJobTriggerRequest, HybridInspectResponse>newBuilder()
              .setFullMethodName("google.privacy.dlp.v2.DlpService/HybridInspectJobTrigger")
              .setHttpMethod("POST")
              .setType(ApiMethodDescriptor.MethodType.UNARY)
              .setRequestFormatter(
                  ProtoMessageRequestFormatter.<HybridInspectJobTriggerRequest>newBuilder()
                      .setPath(
                          "/v2/{name=projects/*/locations/*/jobTriggers/*}:hybridInspect",
                          request -> {
                            Map<String, String> fields = new HashMap<>();
                            ProtoRestSerializer<HybridInspectJobTriggerRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putPathParam(fields, "name", request.getName());
                            return fields;
                          })
                      .setQueryParamsExtractor(
                          request -> {
                            Map<String, List<String>> fields = new HashMap<>();
                            ProtoRestSerializer<HybridInspectJobTriggerRequest> serializer =
                                ProtoRestSerializer.create();
                            return fields;
                          })
                      .setRequestBodyExtractor(
                          request ->
                              ProtoRestSerializer.create()
                                  .toBody("*", request.toBuilder().clearName().build(), false))
                      .build())
              .setResponseParser(
                  ProtoMessageResponseParser.<HybridInspectResponse>newBuilder()
                      .setDefaultInstance(HybridInspectResponse.getDefaultInstance())
                      .setDefaultTypeRegistry(typeRegistry)
                      .build())
              .build();

  private static final ApiMethodDescriptor<GetJobTriggerRequest, JobTrigger>
      getJobTriggerMethodDescriptor =
          ApiMethodDescriptor.<GetJobTriggerRequest, JobTrigger>newBuilder()
              .setFullMethodName("google.privacy.dlp.v2.DlpService/GetJobTrigger")
              .setHttpMethod("GET")
              .setType(ApiMethodDescriptor.MethodType.UNARY)
              .setRequestFormatter(
                  ProtoMessageRequestFormatter.<GetJobTriggerRequest>newBuilder()
                      .setPath(
                          "/v2/{name=projects/*/jobTriggers/*}",
                          request -> {
                            Map<String, String> fields = new HashMap<>();
                            ProtoRestSerializer<GetJobTriggerRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putPathParam(fields, "name", request.getName());
                            return fields;
                          })
                      .setAdditionalPaths(
                          "/v2/{name=projects/*/locations/*/jobTriggers/*}",
                          "/v2/{name=organizations/*/locations/*/jobTriggers/*}")
                      .setQueryParamsExtractor(
                          request -> {
                            Map<String, List<String>> fields = new HashMap<>();
                            ProtoRestSerializer<GetJobTriggerRequest> serializer =
                                ProtoRestSerializer.create();
                            return fields;
                          })
                      .setRequestBodyExtractor(request -> null)
                      .build())
              .setResponseParser(
                  ProtoMessageResponseParser.<JobTrigger>newBuilder()
                      .setDefaultInstance(JobTrigger.getDefaultInstance())
                      .setDefaultTypeRegistry(typeRegistry)
                      .build())
              .build();

  private static final ApiMethodDescriptor<ListJobTriggersRequest, ListJobTriggersResponse>
      listJobTriggersMethodDescriptor =
          ApiMethodDescriptor.<ListJobTriggersRequest, ListJobTriggersResponse>newBuilder()
              .setFullMethodName("google.privacy.dlp.v2.DlpService/ListJobTriggers")
              .setHttpMethod("GET")
              .setType(ApiMethodDescriptor.MethodType.UNARY)
              .setRequestFormatter(
                  ProtoMessageRequestFormatter.<ListJobTriggersRequest>newBuilder()
                      .setPath(
                          "/v2/{parent=projects/*}/jobTriggers",
                          request -> {
                            Map<String, String> fields = new HashMap<>();
                            ProtoRestSerializer<ListJobTriggersRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putPathParam(fields, "parent", request.getParent());
                            return fields;
                          })
                      .setAdditionalPaths(
                          "/v2/{parent=projects/*/locations/*}/jobTriggers",
                          "/v2/{parent=organizations/*/locations/*}/jobTriggers")
                      .setQueryParamsExtractor(
                          request -> {
                            Map<String, List<String>> fields = new HashMap<>();
                            ProtoRestSerializer<ListJobTriggersRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putQueryParam(fields, "filter", request.getFilter());
                            serializer.putQueryParam(fields, "locationId", request.getLocationId());
                            serializer.putQueryParam(fields, "orderBy", request.getOrderBy());
                            serializer.putQueryParam(fields, "pageSize", request.getPageSize());
                            serializer.putQueryParam(fields, "pageToken", request.getPageToken());
                            serializer.putQueryParam(fields, "type", request.getTypeValue());
                            return fields;
                          })
                      .setRequestBodyExtractor(request -> null)
                      .build())
              .setResponseParser(
                  ProtoMessageResponseParser.<ListJobTriggersResponse>newBuilder()
                      .setDefaultInstance(ListJobTriggersResponse.getDefaultInstance())
                      .setDefaultTypeRegistry(typeRegistry)
                      .build())
              .build();

  private static final ApiMethodDescriptor<DeleteJobTriggerRequest, Empty>
      deleteJobTriggerMethodDescriptor =
          ApiMethodDescriptor.<DeleteJobTriggerRequest, Empty>newBuilder()
              .setFullMethodName("google.privacy.dlp.v2.DlpService/DeleteJobTrigger")
              .setHttpMethod("DELETE")
              .setType(ApiMethodDescriptor.MethodType.UNARY)
              .setRequestFormatter(
                  ProtoMessageRequestFormatter.<DeleteJobTriggerRequest>newBuilder()
                      .setPath(
                          "/v2/{name=projects/*/jobTriggers/*}",
                          request -> {
                            Map<String, String> fields = new HashMap<>();
                            ProtoRestSerializer<DeleteJobTriggerRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putPathParam(fields, "name", request.getName());
                            return fields;
                          })
                      .setAdditionalPaths(
                          "/v2/{name=projects/*/locations/*/jobTriggers/*}",
                          "/v2/{name=organizations/*/locations/*/jobTriggers/*}")
                      .setQueryParamsExtractor(
                          request -> {
                            Map<String, List<String>> fields = new HashMap<>();
                            ProtoRestSerializer<DeleteJobTriggerRequest> serializer =
                                ProtoRestSerializer.create();
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

  private static final ApiMethodDescriptor<ActivateJobTriggerRequest, DlpJob>
      activateJobTriggerMethodDescriptor =
          ApiMethodDescriptor.<ActivateJobTriggerRequest, DlpJob>newBuilder()
              .setFullMethodName("google.privacy.dlp.v2.DlpService/ActivateJobTrigger")
              .setHttpMethod("POST")
              .setType(ApiMethodDescriptor.MethodType.UNARY)
              .setRequestFormatter(
                  ProtoMessageRequestFormatter.<ActivateJobTriggerRequest>newBuilder()
                      .setPath(
                          "/v2/{name=projects/*/jobTriggers/*}:activate",
                          request -> {
                            Map<String, String> fields = new HashMap<>();
                            ProtoRestSerializer<ActivateJobTriggerRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putPathParam(fields, "name", request.getName());
                            return fields;
                          })
                      .setAdditionalPaths(
                          "/v2/{name=projects/*/locations/*/jobTriggers/*}:activate")
                      .setQueryParamsExtractor(
                          request -> {
                            Map<String, List<String>> fields = new HashMap<>();
                            ProtoRestSerializer<ActivateJobTriggerRequest> serializer =
                                ProtoRestSerializer.create();
                            return fields;
                          })
                      .setRequestBodyExtractor(
                          request ->
                              ProtoRestSerializer.create()
                                  .toBody("*", request.toBuilder().clearName().build(), false))
                      .build())
              .setResponseParser(
                  ProtoMessageResponseParser.<DlpJob>newBuilder()
                      .setDefaultInstance(DlpJob.getDefaultInstance())
                      .setDefaultTypeRegistry(typeRegistry)
                      .build())
              .build();

  private static final ApiMethodDescriptor<CreateDlpJobRequest, DlpJob>
      createDlpJobMethodDescriptor =
          ApiMethodDescriptor.<CreateDlpJobRequest, DlpJob>newBuilder()
              .setFullMethodName("google.privacy.dlp.v2.DlpService/CreateDlpJob")
              .setHttpMethod("POST")
              .setType(ApiMethodDescriptor.MethodType.UNARY)
              .setRequestFormatter(
                  ProtoMessageRequestFormatter.<CreateDlpJobRequest>newBuilder()
                      .setPath(
                          "/v2/{parent=projects/*}/dlpJobs",
                          request -> {
                            Map<String, String> fields = new HashMap<>();
                            ProtoRestSerializer<CreateDlpJobRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putPathParam(fields, "parent", request.getParent());
                            return fields;
                          })
                      .setAdditionalPaths("/v2/{parent=projects/*/locations/*}/dlpJobs")
                      .setQueryParamsExtractor(
                          request -> {
                            Map<String, List<String>> fields = new HashMap<>();
                            ProtoRestSerializer<CreateDlpJobRequest> serializer =
                                ProtoRestSerializer.create();
                            return fields;
                          })
                      .setRequestBodyExtractor(
                          request ->
                              ProtoRestSerializer.create()
                                  .toBody("*", request.toBuilder().clearParent().build(), false))
                      .build())
              .setResponseParser(
                  ProtoMessageResponseParser.<DlpJob>newBuilder()
                      .setDefaultInstance(DlpJob.getDefaultInstance())
                      .setDefaultTypeRegistry(typeRegistry)
                      .build())
              .build();

  private static final ApiMethodDescriptor<ListDlpJobsRequest, ListDlpJobsResponse>
      listDlpJobsMethodDescriptor =
          ApiMethodDescriptor.<ListDlpJobsRequest, ListDlpJobsResponse>newBuilder()
              .setFullMethodName("google.privacy.dlp.v2.DlpService/ListDlpJobs")
              .setHttpMethod("GET")
              .setType(ApiMethodDescriptor.MethodType.UNARY)
              .setRequestFormatter(
                  ProtoMessageRequestFormatter.<ListDlpJobsRequest>newBuilder()
                      .setPath(
                          "/v2/{parent=projects/*}/dlpJobs",
                          request -> {
                            Map<String, String> fields = new HashMap<>();
                            ProtoRestSerializer<ListDlpJobsRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putPathParam(fields, "parent", request.getParent());
                            return fields;
                          })
                      .setAdditionalPaths(
                          "/v2/{parent=projects/*/locations/*}/dlpJobs",
                          "/v2/{parent=organizations/*/locations/*}/dlpJobs")
                      .setQueryParamsExtractor(
                          request -> {
                            Map<String, List<String>> fields = new HashMap<>();
                            ProtoRestSerializer<ListDlpJobsRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putQueryParam(fields, "filter", request.getFilter());
                            serializer.putQueryParam(fields, "locationId", request.getLocationId());
                            serializer.putQueryParam(fields, "orderBy", request.getOrderBy());
                            serializer.putQueryParam(fields, "pageSize", request.getPageSize());
                            serializer.putQueryParam(fields, "pageToken", request.getPageToken());
                            serializer.putQueryParam(fields, "type", request.getTypeValue());
                            return fields;
                          })
                      .setRequestBodyExtractor(request -> null)
                      .build())
              .setResponseParser(
                  ProtoMessageResponseParser.<ListDlpJobsResponse>newBuilder()
                      .setDefaultInstance(ListDlpJobsResponse.getDefaultInstance())
                      .setDefaultTypeRegistry(typeRegistry)
                      .build())
              .build();

  private static final ApiMethodDescriptor<GetDlpJobRequest, DlpJob> getDlpJobMethodDescriptor =
      ApiMethodDescriptor.<GetDlpJobRequest, DlpJob>newBuilder()
          .setFullMethodName("google.privacy.dlp.v2.DlpService/GetDlpJob")
          .setHttpMethod("GET")
          .setType(ApiMethodDescriptor.MethodType.UNARY)
          .setRequestFormatter(
              ProtoMessageRequestFormatter.<GetDlpJobRequest>newBuilder()
                  .setPath(
                      "/v2/{name=projects/*/dlpJobs/*}",
                      request -> {
                        Map<String, String> fields = new HashMap<>();
                        ProtoRestSerializer<GetDlpJobRequest> serializer =
                            ProtoRestSerializer.create();
                        serializer.putPathParam(fields, "name", request.getName());
                        return fields;
                      })
                  .setAdditionalPaths("/v2/{name=projects/*/locations/*/dlpJobs/*}")
                  .setQueryParamsExtractor(
                      request -> {
                        Map<String, List<String>> fields = new HashMap<>();
                        ProtoRestSerializer<GetDlpJobRequest> serializer =
                            ProtoRestSerializer.create();
                        return fields;
                      })
                  .setRequestBodyExtractor(request -> null)
                  .build())
          .setResponseParser(
              ProtoMessageResponseParser.<DlpJob>newBuilder()
                  .setDefaultInstance(DlpJob.getDefaultInstance())
                  .setDefaultTypeRegistry(typeRegistry)
                  .build())
          .build();

  private static final ApiMethodDescriptor<DeleteDlpJobRequest, Empty>
      deleteDlpJobMethodDescriptor =
          ApiMethodDescriptor.<DeleteDlpJobRequest, Empty>newBuilder()
              .setFullMethodName("google.privacy.dlp.v2.DlpService/DeleteDlpJob")
              .setHttpMethod("DELETE")
              .setType(ApiMethodDescriptor.MethodType.UNARY)
              .setRequestFormatter(
                  ProtoMessageRequestFormatter.<DeleteDlpJobRequest>newBuilder()
                      .setPath(
                          "/v2/{name=projects/*/dlpJobs/*}",
                          request -> {
                            Map<String, String> fields = new HashMap<>();
                            ProtoRestSerializer<DeleteDlpJobRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putPathParam(fields, "name", request.getName());
                            return fields;
                          })
                      .setAdditionalPaths("/v2/{name=projects/*/locations/*/dlpJobs/*}")
                      .setQueryParamsExtractor(
                          request -> {
                            Map<String, List<String>> fields = new HashMap<>();
                            ProtoRestSerializer<DeleteDlpJobRequest> serializer =
                                ProtoRestSerializer.create();
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

  private static final ApiMethodDescriptor<CancelDlpJobRequest, Empty>
      cancelDlpJobMethodDescriptor =
          ApiMethodDescriptor.<CancelDlpJobRequest, Empty>newBuilder()
              .setFullMethodName("google.privacy.dlp.v2.DlpService/CancelDlpJob")
              .setHttpMethod("POST")
              .setType(ApiMethodDescriptor.MethodType.UNARY)
              .setRequestFormatter(
                  ProtoMessageRequestFormatter.<CancelDlpJobRequest>newBuilder()
                      .setPath(
                          "/v2/{name=projects/*/dlpJobs/*}:cancel",
                          request -> {
                            Map<String, String> fields = new HashMap<>();
                            ProtoRestSerializer<CancelDlpJobRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putPathParam(fields, "name", request.getName());
                            return fields;
                          })
                      .setAdditionalPaths("/v2/{name=projects/*/locations/*/dlpJobs/*}:cancel")
                      .setQueryParamsExtractor(
                          request -> {
                            Map<String, List<String>> fields = new HashMap<>();
                            ProtoRestSerializer<CancelDlpJobRequest> serializer =
                                ProtoRestSerializer.create();
                            return fields;
                          })
                      .setRequestBodyExtractor(
                          request ->
                              ProtoRestSerializer.create()
                                  .toBody("*", request.toBuilder().clearName().build(), false))
                      .build())
              .setResponseParser(
                  ProtoMessageResponseParser.<Empty>newBuilder()
                      .setDefaultInstance(Empty.getDefaultInstance())
                      .setDefaultTypeRegistry(typeRegistry)
                      .build())
              .build();

  private static final ApiMethodDescriptor<CreateStoredInfoTypeRequest, StoredInfoType>
      createStoredInfoTypeMethodDescriptor =
          ApiMethodDescriptor.<CreateStoredInfoTypeRequest, StoredInfoType>newBuilder()
              .setFullMethodName("google.privacy.dlp.v2.DlpService/CreateStoredInfoType")
              .setHttpMethod("POST")
              .setType(ApiMethodDescriptor.MethodType.UNARY)
              .setRequestFormatter(
                  ProtoMessageRequestFormatter.<CreateStoredInfoTypeRequest>newBuilder()
                      .setPath(
                          "/v2/{parent=organizations/*}/storedInfoTypes",
                          request -> {
                            Map<String, String> fields = new HashMap<>();
                            ProtoRestSerializer<CreateStoredInfoTypeRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putPathParam(fields, "parent", request.getParent());
                            return fields;
                          })
                      .setAdditionalPaths(
                          "/v2/{parent=organizations/*/locations/*}/storedInfoTypes",
                          "/v2/{parent=projects/*}/storedInfoTypes",
                          "/v2/{parent=projects/*/locations/*}/storedInfoTypes")
                      .setQueryParamsExtractor(
                          request -> {
                            Map<String, List<String>> fields = new HashMap<>();
                            ProtoRestSerializer<CreateStoredInfoTypeRequest> serializer =
                                ProtoRestSerializer.create();
                            return fields;
                          })
                      .setRequestBodyExtractor(
                          request ->
                              ProtoRestSerializer.create()
                                  .toBody("*", request.toBuilder().clearParent().build(), false))
                      .build())
              .setResponseParser(
                  ProtoMessageResponseParser.<StoredInfoType>newBuilder()
                      .setDefaultInstance(StoredInfoType.getDefaultInstance())
                      .setDefaultTypeRegistry(typeRegistry)
                      .build())
              .build();

  private static final ApiMethodDescriptor<UpdateStoredInfoTypeRequest, StoredInfoType>
      updateStoredInfoTypeMethodDescriptor =
          ApiMethodDescriptor.<UpdateStoredInfoTypeRequest, StoredInfoType>newBuilder()
              .setFullMethodName("google.privacy.dlp.v2.DlpService/UpdateStoredInfoType")
              .setHttpMethod("PATCH")
              .setType(ApiMethodDescriptor.MethodType.UNARY)
              .setRequestFormatter(
                  ProtoMessageRequestFormatter.<UpdateStoredInfoTypeRequest>newBuilder()
                      .setPath(
                          "/v2/{name=organizations/*/storedInfoTypes/*}",
                          request -> {
                            Map<String, String> fields = new HashMap<>();
                            ProtoRestSerializer<UpdateStoredInfoTypeRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putPathParam(fields, "name", request.getName());
                            return fields;
                          })
                      .setAdditionalPaths(
                          "/v2/{name=organizations/*/locations/*/storedInfoTypes/*}",
                          "/v2/{name=projects/*/storedInfoTypes/*}",
                          "/v2/{name=projects/*/locations/*/storedInfoTypes/*}")
                      .setQueryParamsExtractor(
                          request -> {
                            Map<String, List<String>> fields = new HashMap<>();
                            ProtoRestSerializer<UpdateStoredInfoTypeRequest> serializer =
                                ProtoRestSerializer.create();
                            return fields;
                          })
                      .setRequestBodyExtractor(
                          request ->
                              ProtoRestSerializer.create()
                                  .toBody("*", request.toBuilder().clearName().build(), false))
                      .build())
              .setResponseParser(
                  ProtoMessageResponseParser.<StoredInfoType>newBuilder()
                      .setDefaultInstance(StoredInfoType.getDefaultInstance())
                      .setDefaultTypeRegistry(typeRegistry)
                      .build())
              .build();

  private static final ApiMethodDescriptor<GetStoredInfoTypeRequest, StoredInfoType>
      getStoredInfoTypeMethodDescriptor =
          ApiMethodDescriptor.<GetStoredInfoTypeRequest, StoredInfoType>newBuilder()
              .setFullMethodName("google.privacy.dlp.v2.DlpService/GetStoredInfoType")
              .setHttpMethod("GET")
              .setType(ApiMethodDescriptor.MethodType.UNARY)
              .setRequestFormatter(
                  ProtoMessageRequestFormatter.<GetStoredInfoTypeRequest>newBuilder()
                      .setPath(
                          "/v2/{name=organizations/*/storedInfoTypes/*}",
                          request -> {
                            Map<String, String> fields = new HashMap<>();
                            ProtoRestSerializer<GetStoredInfoTypeRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putPathParam(fields, "name", request.getName());
                            return fields;
                          })
                      .setAdditionalPaths(
                          "/v2/{name=organizations/*/locations/*/storedInfoTypes/*}",
                          "/v2/{name=projects/*/storedInfoTypes/*}",
                          "/v2/{name=projects/*/locations/*/storedInfoTypes/*}")
                      .setQueryParamsExtractor(
                          request -> {
                            Map<String, List<String>> fields = new HashMap<>();
                            ProtoRestSerializer<GetStoredInfoTypeRequest> serializer =
                                ProtoRestSerializer.create();
                            return fields;
                          })
                      .setRequestBodyExtractor(request -> null)
                      .build())
              .setResponseParser(
                  ProtoMessageResponseParser.<StoredInfoType>newBuilder()
                      .setDefaultInstance(StoredInfoType.getDefaultInstance())
                      .setDefaultTypeRegistry(typeRegistry)
                      .build())
              .build();

  private static final ApiMethodDescriptor<ListStoredInfoTypesRequest, ListStoredInfoTypesResponse>
      listStoredInfoTypesMethodDescriptor =
          ApiMethodDescriptor.<ListStoredInfoTypesRequest, ListStoredInfoTypesResponse>newBuilder()
              .setFullMethodName("google.privacy.dlp.v2.DlpService/ListStoredInfoTypes")
              .setHttpMethod("GET")
              .setType(ApiMethodDescriptor.MethodType.UNARY)
              .setRequestFormatter(
                  ProtoMessageRequestFormatter.<ListStoredInfoTypesRequest>newBuilder()
                      .setPath(
                          "/v2/{parent=organizations/*}/storedInfoTypes",
                          request -> {
                            Map<String, String> fields = new HashMap<>();
                            ProtoRestSerializer<ListStoredInfoTypesRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putPathParam(fields, "parent", request.getParent());
                            return fields;
                          })
                      .setAdditionalPaths(
                          "/v2/{parent=organizations/*/locations/*}/storedInfoTypes",
                          "/v2/{parent=projects/*}/storedInfoTypes",
                          "/v2/{parent=projects/*/locations/*}/storedInfoTypes")
                      .setQueryParamsExtractor(
                          request -> {
                            Map<String, List<String>> fields = new HashMap<>();
                            ProtoRestSerializer<ListStoredInfoTypesRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putQueryParam(fields, "locationId", request.getLocationId());
                            serializer.putQueryParam(fields, "orderBy", request.getOrderBy());
                            serializer.putQueryParam(fields, "pageSize", request.getPageSize());
                            serializer.putQueryParam(fields, "pageToken", request.getPageToken());
                            return fields;
                          })
                      .setRequestBodyExtractor(request -> null)
                      .build())
              .setResponseParser(
                  ProtoMessageResponseParser.<ListStoredInfoTypesResponse>newBuilder()
                      .setDefaultInstance(ListStoredInfoTypesResponse.getDefaultInstance())
                      .setDefaultTypeRegistry(typeRegistry)
                      .build())
              .build();

  private static final ApiMethodDescriptor<DeleteStoredInfoTypeRequest, Empty>
      deleteStoredInfoTypeMethodDescriptor =
          ApiMethodDescriptor.<DeleteStoredInfoTypeRequest, Empty>newBuilder()
              .setFullMethodName("google.privacy.dlp.v2.DlpService/DeleteStoredInfoType")
              .setHttpMethod("DELETE")
              .setType(ApiMethodDescriptor.MethodType.UNARY)
              .setRequestFormatter(
                  ProtoMessageRequestFormatter.<DeleteStoredInfoTypeRequest>newBuilder()
                      .setPath(
                          "/v2/{name=organizations/*/storedInfoTypes/*}",
                          request -> {
                            Map<String, String> fields = new HashMap<>();
                            ProtoRestSerializer<DeleteStoredInfoTypeRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putPathParam(fields, "name", request.getName());
                            return fields;
                          })
                      .setAdditionalPaths(
                          "/v2/{name=organizations/*/locations/*/storedInfoTypes/*}",
                          "/v2/{name=projects/*/storedInfoTypes/*}",
                          "/v2/{name=projects/*/locations/*/storedInfoTypes/*}")
                      .setQueryParamsExtractor(
                          request -> {
                            Map<String, List<String>> fields = new HashMap<>();
                            ProtoRestSerializer<DeleteStoredInfoTypeRequest> serializer =
                                ProtoRestSerializer.create();
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

  private static final ApiMethodDescriptor<HybridInspectDlpJobRequest, HybridInspectResponse>
      hybridInspectDlpJobMethodDescriptor =
          ApiMethodDescriptor.<HybridInspectDlpJobRequest, HybridInspectResponse>newBuilder()
              .setFullMethodName("google.privacy.dlp.v2.DlpService/HybridInspectDlpJob")
              .setHttpMethod("POST")
              .setType(ApiMethodDescriptor.MethodType.UNARY)
              .setRequestFormatter(
                  ProtoMessageRequestFormatter.<HybridInspectDlpJobRequest>newBuilder()
                      .setPath(
                          "/v2/{name=projects/*/locations/*/dlpJobs/*}:hybridInspect",
                          request -> {
                            Map<String, String> fields = new HashMap<>();
                            ProtoRestSerializer<HybridInspectDlpJobRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putPathParam(fields, "name", request.getName());
                            return fields;
                          })
                      .setQueryParamsExtractor(
                          request -> {
                            Map<String, List<String>> fields = new HashMap<>();
                            ProtoRestSerializer<HybridInspectDlpJobRequest> serializer =
                                ProtoRestSerializer.create();
                            return fields;
                          })
                      .setRequestBodyExtractor(
                          request ->
                              ProtoRestSerializer.create()
                                  .toBody("*", request.toBuilder().clearName().build(), false))
                      .build())
              .setResponseParser(
                  ProtoMessageResponseParser.<HybridInspectResponse>newBuilder()
                      .setDefaultInstance(HybridInspectResponse.getDefaultInstance())
                      .setDefaultTypeRegistry(typeRegistry)
                      .build())
              .build();

  private static final ApiMethodDescriptor<FinishDlpJobRequest, Empty>
      finishDlpJobMethodDescriptor =
          ApiMethodDescriptor.<FinishDlpJobRequest, Empty>newBuilder()
              .setFullMethodName("google.privacy.dlp.v2.DlpService/FinishDlpJob")
              .setHttpMethod("POST")
              .setType(ApiMethodDescriptor.MethodType.UNARY)
              .setRequestFormatter(
                  ProtoMessageRequestFormatter.<FinishDlpJobRequest>newBuilder()
                      .setPath(
                          "/v2/{name=projects/*/locations/*/dlpJobs/*}:finish",
                          request -> {
                            Map<String, String> fields = new HashMap<>();
                            ProtoRestSerializer<FinishDlpJobRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putPathParam(fields, "name", request.getName());
                            return fields;
                          })
                      .setQueryParamsExtractor(
                          request -> {
                            Map<String, List<String>> fields = new HashMap<>();
                            ProtoRestSerializer<FinishDlpJobRequest> serializer =
                                ProtoRestSerializer.create();
                            return fields;
                          })
                      .setRequestBodyExtractor(
                          request ->
                              ProtoRestSerializer.create()
                                  .toBody("*", request.toBuilder().clearName().build(), false))
                      .build())
              .setResponseParser(
                  ProtoMessageResponseParser.<Empty>newBuilder()
                      .setDefaultInstance(Empty.getDefaultInstance())
                      .setDefaultTypeRegistry(typeRegistry)
                      .build())
              .build();

  private final UnaryCallable<InspectContentRequest, InspectContentResponse> inspectContentCallable;
  private final UnaryCallable<RedactImageRequest, RedactImageResponse> redactImageCallable;
  private final UnaryCallable<DeidentifyContentRequest, DeidentifyContentResponse>
      deidentifyContentCallable;
  private final UnaryCallable<ReidentifyContentRequest, ReidentifyContentResponse>
      reidentifyContentCallable;
  private final UnaryCallable<ListInfoTypesRequest, ListInfoTypesResponse> listInfoTypesCallable;
  private final UnaryCallable<CreateInspectTemplateRequest, InspectTemplate>
      createInspectTemplateCallable;
  private final UnaryCallable<UpdateInspectTemplateRequest, InspectTemplate>
      updateInspectTemplateCallable;
  private final UnaryCallable<GetInspectTemplateRequest, InspectTemplate>
      getInspectTemplateCallable;
  private final UnaryCallable<ListInspectTemplatesRequest, ListInspectTemplatesResponse>
      listInspectTemplatesCallable;
  private final UnaryCallable<ListInspectTemplatesRequest, ListInspectTemplatesPagedResponse>
      listInspectTemplatesPagedCallable;
  private final UnaryCallable<DeleteInspectTemplateRequest, Empty> deleteInspectTemplateCallable;
  private final UnaryCallable<CreateDeidentifyTemplateRequest, DeidentifyTemplate>
      createDeidentifyTemplateCallable;
  private final UnaryCallable<UpdateDeidentifyTemplateRequest, DeidentifyTemplate>
      updateDeidentifyTemplateCallable;
  private final UnaryCallable<GetDeidentifyTemplateRequest, DeidentifyTemplate>
      getDeidentifyTemplateCallable;
  private final UnaryCallable<ListDeidentifyTemplatesRequest, ListDeidentifyTemplatesResponse>
      listDeidentifyTemplatesCallable;
  private final UnaryCallable<ListDeidentifyTemplatesRequest, ListDeidentifyTemplatesPagedResponse>
      listDeidentifyTemplatesPagedCallable;
  private final UnaryCallable<DeleteDeidentifyTemplateRequest, Empty>
      deleteDeidentifyTemplateCallable;
  private final UnaryCallable<CreateJobTriggerRequest, JobTrigger> createJobTriggerCallable;
  private final UnaryCallable<UpdateJobTriggerRequest, JobTrigger> updateJobTriggerCallable;
  private final UnaryCallable<HybridInspectJobTriggerRequest, HybridInspectResponse>
      hybridInspectJobTriggerCallable;
  private final UnaryCallable<GetJobTriggerRequest, JobTrigger> getJobTriggerCallable;
  private final UnaryCallable<ListJobTriggersRequest, ListJobTriggersResponse>
      listJobTriggersCallable;
  private final UnaryCallable<ListJobTriggersRequest, ListJobTriggersPagedResponse>
      listJobTriggersPagedCallable;
  private final UnaryCallable<DeleteJobTriggerRequest, Empty> deleteJobTriggerCallable;
  private final UnaryCallable<ActivateJobTriggerRequest, DlpJob> activateJobTriggerCallable;
  private final UnaryCallable<CreateDlpJobRequest, DlpJob> createDlpJobCallable;
  private final UnaryCallable<ListDlpJobsRequest, ListDlpJobsResponse> listDlpJobsCallable;
  private final UnaryCallable<ListDlpJobsRequest, ListDlpJobsPagedResponse>
      listDlpJobsPagedCallable;
  private final UnaryCallable<GetDlpJobRequest, DlpJob> getDlpJobCallable;
  private final UnaryCallable<DeleteDlpJobRequest, Empty> deleteDlpJobCallable;
  private final UnaryCallable<CancelDlpJobRequest, Empty> cancelDlpJobCallable;
  private final UnaryCallable<CreateStoredInfoTypeRequest, StoredInfoType>
      createStoredInfoTypeCallable;
  private final UnaryCallable<UpdateStoredInfoTypeRequest, StoredInfoType>
      updateStoredInfoTypeCallable;
  private final UnaryCallable<GetStoredInfoTypeRequest, StoredInfoType> getStoredInfoTypeCallable;
  private final UnaryCallable<ListStoredInfoTypesRequest, ListStoredInfoTypesResponse>
      listStoredInfoTypesCallable;
  private final UnaryCallable<ListStoredInfoTypesRequest, ListStoredInfoTypesPagedResponse>
      listStoredInfoTypesPagedCallable;
  private final UnaryCallable<DeleteStoredInfoTypeRequest, Empty> deleteStoredInfoTypeCallable;
  private final UnaryCallable<HybridInspectDlpJobRequest, HybridInspectResponse>
      hybridInspectDlpJobCallable;
  private final UnaryCallable<FinishDlpJobRequest, Empty> finishDlpJobCallable;

  private final BackgroundResource backgroundResources;
  private final HttpJsonStubCallableFactory callableFactory;

  public static final HttpJsonDlpServiceStub create(DlpServiceStubSettings settings)
      throws IOException {
    return new HttpJsonDlpServiceStub(settings, ClientContext.create(settings));
  }

  public static final HttpJsonDlpServiceStub create(ClientContext clientContext)
      throws IOException {
    return new HttpJsonDlpServiceStub(
        DlpServiceStubSettings.newHttpJsonBuilder().build(), clientContext);
  }

  public static final HttpJsonDlpServiceStub create(
      ClientContext clientContext, HttpJsonStubCallableFactory callableFactory) throws IOException {
    return new HttpJsonDlpServiceStub(
        DlpServiceStubSettings.newHttpJsonBuilder().build(), clientContext, callableFactory);
  }

  /**
   * Constructs an instance of HttpJsonDlpServiceStub, using the given settings. This is protected
   * so that it is easy to make a subclass, but otherwise, the static factory methods should be
   * preferred.
   */
  protected HttpJsonDlpServiceStub(DlpServiceStubSettings settings, ClientContext clientContext)
      throws IOException {
    this(settings, clientContext, new HttpJsonDlpServiceCallableFactory());
  }

  /**
   * Constructs an instance of HttpJsonDlpServiceStub, using the given settings. This is protected
   * so that it is easy to make a subclass, but otherwise, the static factory methods should be
   * preferred.
   */
  protected HttpJsonDlpServiceStub(
      DlpServiceStubSettings settings,
      ClientContext clientContext,
      HttpJsonStubCallableFactory callableFactory)
      throws IOException {
    this.callableFactory = callableFactory;

    HttpJsonCallSettings<InspectContentRequest, InspectContentResponse>
        inspectContentTransportSettings =
            HttpJsonCallSettings.<InspectContentRequest, InspectContentResponse>newBuilder()
                .setMethodDescriptor(inspectContentMethodDescriptor)
                .setTypeRegistry(typeRegistry)
                .build();
    HttpJsonCallSettings<RedactImageRequest, RedactImageResponse> redactImageTransportSettings =
        HttpJsonCallSettings.<RedactImageRequest, RedactImageResponse>newBuilder()
            .setMethodDescriptor(redactImageMethodDescriptor)
            .setTypeRegistry(typeRegistry)
            .build();
    HttpJsonCallSettings<DeidentifyContentRequest, DeidentifyContentResponse>
        deidentifyContentTransportSettings =
            HttpJsonCallSettings.<DeidentifyContentRequest, DeidentifyContentResponse>newBuilder()
                .setMethodDescriptor(deidentifyContentMethodDescriptor)
                .setTypeRegistry(typeRegistry)
                .build();
    HttpJsonCallSettings<ReidentifyContentRequest, ReidentifyContentResponse>
        reidentifyContentTransportSettings =
            HttpJsonCallSettings.<ReidentifyContentRequest, ReidentifyContentResponse>newBuilder()
                .setMethodDescriptor(reidentifyContentMethodDescriptor)
                .setTypeRegistry(typeRegistry)
                .build();
    HttpJsonCallSettings<ListInfoTypesRequest, ListInfoTypesResponse>
        listInfoTypesTransportSettings =
            HttpJsonCallSettings.<ListInfoTypesRequest, ListInfoTypesResponse>newBuilder()
                .setMethodDescriptor(listInfoTypesMethodDescriptor)
                .setTypeRegistry(typeRegistry)
                .build();
    HttpJsonCallSettings<CreateInspectTemplateRequest, InspectTemplate>
        createInspectTemplateTransportSettings =
            HttpJsonCallSettings.<CreateInspectTemplateRequest, InspectTemplate>newBuilder()
                .setMethodDescriptor(createInspectTemplateMethodDescriptor)
                .setTypeRegistry(typeRegistry)
                .build();
    HttpJsonCallSettings<UpdateInspectTemplateRequest, InspectTemplate>
        updateInspectTemplateTransportSettings =
            HttpJsonCallSettings.<UpdateInspectTemplateRequest, InspectTemplate>newBuilder()
                .setMethodDescriptor(updateInspectTemplateMethodDescriptor)
                .setTypeRegistry(typeRegistry)
                .build();
    HttpJsonCallSettings<GetInspectTemplateRequest, InspectTemplate>
        getInspectTemplateTransportSettings =
            HttpJsonCallSettings.<GetInspectTemplateRequest, InspectTemplate>newBuilder()
                .setMethodDescriptor(getInspectTemplateMethodDescriptor)
                .setTypeRegistry(typeRegistry)
                .build();
    HttpJsonCallSettings<ListInspectTemplatesRequest, ListInspectTemplatesResponse>
        listInspectTemplatesTransportSettings =
            HttpJsonCallSettings
                .<ListInspectTemplatesRequest, ListInspectTemplatesResponse>newBuilder()
                .setMethodDescriptor(listInspectTemplatesMethodDescriptor)
                .setTypeRegistry(typeRegistry)
                .build();
    HttpJsonCallSettings<DeleteInspectTemplateRequest, Empty>
        deleteInspectTemplateTransportSettings =
            HttpJsonCallSettings.<DeleteInspectTemplateRequest, Empty>newBuilder()
                .setMethodDescriptor(deleteInspectTemplateMethodDescriptor)
                .setTypeRegistry(typeRegistry)
                .build();
    HttpJsonCallSettings<CreateDeidentifyTemplateRequest, DeidentifyTemplate>
        createDeidentifyTemplateTransportSettings =
            HttpJsonCallSettings.<CreateDeidentifyTemplateRequest, DeidentifyTemplate>newBuilder()
                .setMethodDescriptor(createDeidentifyTemplateMethodDescriptor)
                .setTypeRegistry(typeRegistry)
                .build();
    HttpJsonCallSettings<UpdateDeidentifyTemplateRequest, DeidentifyTemplate>
        updateDeidentifyTemplateTransportSettings =
            HttpJsonCallSettings.<UpdateDeidentifyTemplateRequest, DeidentifyTemplate>newBuilder()
                .setMethodDescriptor(updateDeidentifyTemplateMethodDescriptor)
                .setTypeRegistry(typeRegistry)
                .build();
    HttpJsonCallSettings<GetDeidentifyTemplateRequest, DeidentifyTemplate>
        getDeidentifyTemplateTransportSettings =
            HttpJsonCallSettings.<GetDeidentifyTemplateRequest, DeidentifyTemplate>newBuilder()
                .setMethodDescriptor(getDeidentifyTemplateMethodDescriptor)
                .setTypeRegistry(typeRegistry)
                .build();
    HttpJsonCallSettings<ListDeidentifyTemplatesRequest, ListDeidentifyTemplatesResponse>
        listDeidentifyTemplatesTransportSettings =
            HttpJsonCallSettings
                .<ListDeidentifyTemplatesRequest, ListDeidentifyTemplatesResponse>newBuilder()
                .setMethodDescriptor(listDeidentifyTemplatesMethodDescriptor)
                .setTypeRegistry(typeRegistry)
                .build();
    HttpJsonCallSettings<DeleteDeidentifyTemplateRequest, Empty>
        deleteDeidentifyTemplateTransportSettings =
            HttpJsonCallSettings.<DeleteDeidentifyTemplateRequest, Empty>newBuilder()
                .setMethodDescriptor(deleteDeidentifyTemplateMethodDescriptor)
                .setTypeRegistry(typeRegistry)
                .build();
    HttpJsonCallSettings<CreateJobTriggerRequest, JobTrigger> createJobTriggerTransportSettings =
        HttpJsonCallSettings.<CreateJobTriggerRequest, JobTrigger>newBuilder()
            .setMethodDescriptor(createJobTriggerMethodDescriptor)
            .setTypeRegistry(typeRegistry)
            .build();
    HttpJsonCallSettings<UpdateJobTriggerRequest, JobTrigger> updateJobTriggerTransportSettings =
        HttpJsonCallSettings.<UpdateJobTriggerRequest, JobTrigger>newBuilder()
            .setMethodDescriptor(updateJobTriggerMethodDescriptor)
            .setTypeRegistry(typeRegistry)
            .build();
    HttpJsonCallSettings<HybridInspectJobTriggerRequest, HybridInspectResponse>
        hybridInspectJobTriggerTransportSettings =
            HttpJsonCallSettings.<HybridInspectJobTriggerRequest, HybridInspectResponse>newBuilder()
                .setMethodDescriptor(hybridInspectJobTriggerMethodDescriptor)
                .setTypeRegistry(typeRegistry)
                .build();
    HttpJsonCallSettings<GetJobTriggerRequest, JobTrigger> getJobTriggerTransportSettings =
        HttpJsonCallSettings.<GetJobTriggerRequest, JobTrigger>newBuilder()
            .setMethodDescriptor(getJobTriggerMethodDescriptor)
            .setTypeRegistry(typeRegistry)
            .build();
    HttpJsonCallSettings<ListJobTriggersRequest, ListJobTriggersResponse>
        listJobTriggersTransportSettings =
            HttpJsonCallSettings.<ListJobTriggersRequest, ListJobTriggersResponse>newBuilder()
                .setMethodDescriptor(listJobTriggersMethodDescriptor)
                .setTypeRegistry(typeRegistry)
                .build();
    HttpJsonCallSettings<DeleteJobTriggerRequest, Empty> deleteJobTriggerTransportSettings =
        HttpJsonCallSettings.<DeleteJobTriggerRequest, Empty>newBuilder()
            .setMethodDescriptor(deleteJobTriggerMethodDescriptor)
            .setTypeRegistry(typeRegistry)
            .build();
    HttpJsonCallSettings<ActivateJobTriggerRequest, DlpJob> activateJobTriggerTransportSettings =
        HttpJsonCallSettings.<ActivateJobTriggerRequest, DlpJob>newBuilder()
            .setMethodDescriptor(activateJobTriggerMethodDescriptor)
            .setTypeRegistry(typeRegistry)
            .build();
    HttpJsonCallSettings<CreateDlpJobRequest, DlpJob> createDlpJobTransportSettings =
        HttpJsonCallSettings.<CreateDlpJobRequest, DlpJob>newBuilder()
            .setMethodDescriptor(createDlpJobMethodDescriptor)
            .setTypeRegistry(typeRegistry)
            .build();
    HttpJsonCallSettings<ListDlpJobsRequest, ListDlpJobsResponse> listDlpJobsTransportSettings =
        HttpJsonCallSettings.<ListDlpJobsRequest, ListDlpJobsResponse>newBuilder()
            .setMethodDescriptor(listDlpJobsMethodDescriptor)
            .setTypeRegistry(typeRegistry)
            .build();
    HttpJsonCallSettings<GetDlpJobRequest, DlpJob> getDlpJobTransportSettings =
        HttpJsonCallSettings.<GetDlpJobRequest, DlpJob>newBuilder()
            .setMethodDescriptor(getDlpJobMethodDescriptor)
            .setTypeRegistry(typeRegistry)
            .build();
    HttpJsonCallSettings<DeleteDlpJobRequest, Empty> deleteDlpJobTransportSettings =
        HttpJsonCallSettings.<DeleteDlpJobRequest, Empty>newBuilder()
            .setMethodDescriptor(deleteDlpJobMethodDescriptor)
            .setTypeRegistry(typeRegistry)
            .build();
    HttpJsonCallSettings<CancelDlpJobRequest, Empty> cancelDlpJobTransportSettings =
        HttpJsonCallSettings.<CancelDlpJobRequest, Empty>newBuilder()
            .setMethodDescriptor(cancelDlpJobMethodDescriptor)
            .setTypeRegistry(typeRegistry)
            .build();
    HttpJsonCallSettings<CreateStoredInfoTypeRequest, StoredInfoType>
        createStoredInfoTypeTransportSettings =
            HttpJsonCallSettings.<CreateStoredInfoTypeRequest, StoredInfoType>newBuilder()
                .setMethodDescriptor(createStoredInfoTypeMethodDescriptor)
                .setTypeRegistry(typeRegistry)
                .build();
    HttpJsonCallSettings<UpdateStoredInfoTypeRequest, StoredInfoType>
        updateStoredInfoTypeTransportSettings =
            HttpJsonCallSettings.<UpdateStoredInfoTypeRequest, StoredInfoType>newBuilder()
                .setMethodDescriptor(updateStoredInfoTypeMethodDescriptor)
                .setTypeRegistry(typeRegistry)
                .build();
    HttpJsonCallSettings<GetStoredInfoTypeRequest, StoredInfoType>
        getStoredInfoTypeTransportSettings =
            HttpJsonCallSettings.<GetStoredInfoTypeRequest, StoredInfoType>newBuilder()
                .setMethodDescriptor(getStoredInfoTypeMethodDescriptor)
                .setTypeRegistry(typeRegistry)
                .build();
    HttpJsonCallSettings<ListStoredInfoTypesRequest, ListStoredInfoTypesResponse>
        listStoredInfoTypesTransportSettings =
            HttpJsonCallSettings
                .<ListStoredInfoTypesRequest, ListStoredInfoTypesResponse>newBuilder()
                .setMethodDescriptor(listStoredInfoTypesMethodDescriptor)
                .setTypeRegistry(typeRegistry)
                .build();
    HttpJsonCallSettings<DeleteStoredInfoTypeRequest, Empty> deleteStoredInfoTypeTransportSettings =
        HttpJsonCallSettings.<DeleteStoredInfoTypeRequest, Empty>newBuilder()
            .setMethodDescriptor(deleteStoredInfoTypeMethodDescriptor)
            .setTypeRegistry(typeRegistry)
            .build();
    HttpJsonCallSettings<HybridInspectDlpJobRequest, HybridInspectResponse>
        hybridInspectDlpJobTransportSettings =
            HttpJsonCallSettings.<HybridInspectDlpJobRequest, HybridInspectResponse>newBuilder()
                .setMethodDescriptor(hybridInspectDlpJobMethodDescriptor)
                .setTypeRegistry(typeRegistry)
                .build();
    HttpJsonCallSettings<FinishDlpJobRequest, Empty> finishDlpJobTransportSettings =
        HttpJsonCallSettings.<FinishDlpJobRequest, Empty>newBuilder()
            .setMethodDescriptor(finishDlpJobMethodDescriptor)
            .setTypeRegistry(typeRegistry)
            .build();

    this.inspectContentCallable =
        callableFactory.createUnaryCallable(
            inspectContentTransportSettings, settings.inspectContentSettings(), clientContext);
    this.redactImageCallable =
        callableFactory.createUnaryCallable(
            redactImageTransportSettings, settings.redactImageSettings(), clientContext);
    this.deidentifyContentCallable =
        callableFactory.createUnaryCallable(
            deidentifyContentTransportSettings,
            settings.deidentifyContentSettings(),
            clientContext);
    this.reidentifyContentCallable =
        callableFactory.createUnaryCallable(
            reidentifyContentTransportSettings,
            settings.reidentifyContentSettings(),
            clientContext);
    this.listInfoTypesCallable =
        callableFactory.createUnaryCallable(
            listInfoTypesTransportSettings, settings.listInfoTypesSettings(), clientContext);
    this.createInspectTemplateCallable =
        callableFactory.createUnaryCallable(
            createInspectTemplateTransportSettings,
            settings.createInspectTemplateSettings(),
            clientContext);
    this.updateInspectTemplateCallable =
        callableFactory.createUnaryCallable(
            updateInspectTemplateTransportSettings,
            settings.updateInspectTemplateSettings(),
            clientContext);
    this.getInspectTemplateCallable =
        callableFactory.createUnaryCallable(
            getInspectTemplateTransportSettings,
            settings.getInspectTemplateSettings(),
            clientContext);
    this.listInspectTemplatesCallable =
        callableFactory.createUnaryCallable(
            listInspectTemplatesTransportSettings,
            settings.listInspectTemplatesSettings(),
            clientContext);
    this.listInspectTemplatesPagedCallable =
        callableFactory.createPagedCallable(
            listInspectTemplatesTransportSettings,
            settings.listInspectTemplatesSettings(),
            clientContext);
    this.deleteInspectTemplateCallable =
        callableFactory.createUnaryCallable(
            deleteInspectTemplateTransportSettings,
            settings.deleteInspectTemplateSettings(),
            clientContext);
    this.createDeidentifyTemplateCallable =
        callableFactory.createUnaryCallable(
            createDeidentifyTemplateTransportSettings,
            settings.createDeidentifyTemplateSettings(),
            clientContext);
    this.updateDeidentifyTemplateCallable =
        callableFactory.createUnaryCallable(
            updateDeidentifyTemplateTransportSettings,
            settings.updateDeidentifyTemplateSettings(),
            clientContext);
    this.getDeidentifyTemplateCallable =
        callableFactory.createUnaryCallable(
            getDeidentifyTemplateTransportSettings,
            settings.getDeidentifyTemplateSettings(),
            clientContext);
    this.listDeidentifyTemplatesCallable =
        callableFactory.createUnaryCallable(
            listDeidentifyTemplatesTransportSettings,
            settings.listDeidentifyTemplatesSettings(),
            clientContext);
    this.listDeidentifyTemplatesPagedCallable =
        callableFactory.createPagedCallable(
            listDeidentifyTemplatesTransportSettings,
            settings.listDeidentifyTemplatesSettings(),
            clientContext);
    this.deleteDeidentifyTemplateCallable =
        callableFactory.createUnaryCallable(
            deleteDeidentifyTemplateTransportSettings,
            settings.deleteDeidentifyTemplateSettings(),
            clientContext);
    this.createJobTriggerCallable =
        callableFactory.createUnaryCallable(
            createJobTriggerTransportSettings, settings.createJobTriggerSettings(), clientContext);
    this.updateJobTriggerCallable =
        callableFactory.createUnaryCallable(
            updateJobTriggerTransportSettings, settings.updateJobTriggerSettings(), clientContext);
    this.hybridInspectJobTriggerCallable =
        callableFactory.createUnaryCallable(
            hybridInspectJobTriggerTransportSettings,
            settings.hybridInspectJobTriggerSettings(),
            clientContext);
    this.getJobTriggerCallable =
        callableFactory.createUnaryCallable(
            getJobTriggerTransportSettings, settings.getJobTriggerSettings(), clientContext);
    this.listJobTriggersCallable =
        callableFactory.createUnaryCallable(
            listJobTriggersTransportSettings, settings.listJobTriggersSettings(), clientContext);
    this.listJobTriggersPagedCallable =
        callableFactory.createPagedCallable(
            listJobTriggersTransportSettings, settings.listJobTriggersSettings(), clientContext);
    this.deleteJobTriggerCallable =
        callableFactory.createUnaryCallable(
            deleteJobTriggerTransportSettings, settings.deleteJobTriggerSettings(), clientContext);
    this.activateJobTriggerCallable =
        callableFactory.createUnaryCallable(
            activateJobTriggerTransportSettings,
            settings.activateJobTriggerSettings(),
            clientContext);
    this.createDlpJobCallable =
        callableFactory.createUnaryCallable(
            createDlpJobTransportSettings, settings.createDlpJobSettings(), clientContext);
    this.listDlpJobsCallable =
        callableFactory.createUnaryCallable(
            listDlpJobsTransportSettings, settings.listDlpJobsSettings(), clientContext);
    this.listDlpJobsPagedCallable =
        callableFactory.createPagedCallable(
            listDlpJobsTransportSettings, settings.listDlpJobsSettings(), clientContext);
    this.getDlpJobCallable =
        callableFactory.createUnaryCallable(
            getDlpJobTransportSettings, settings.getDlpJobSettings(), clientContext);
    this.deleteDlpJobCallable =
        callableFactory.createUnaryCallable(
            deleteDlpJobTransportSettings, settings.deleteDlpJobSettings(), clientContext);
    this.cancelDlpJobCallable =
        callableFactory.createUnaryCallable(
            cancelDlpJobTransportSettings, settings.cancelDlpJobSettings(), clientContext);
    this.createStoredInfoTypeCallable =
        callableFactory.createUnaryCallable(
            createStoredInfoTypeTransportSettings,
            settings.createStoredInfoTypeSettings(),
            clientContext);
    this.updateStoredInfoTypeCallable =
        callableFactory.createUnaryCallable(
            updateStoredInfoTypeTransportSettings,
            settings.updateStoredInfoTypeSettings(),
            clientContext);
    this.getStoredInfoTypeCallable =
        callableFactory.createUnaryCallable(
            getStoredInfoTypeTransportSettings,
            settings.getStoredInfoTypeSettings(),
            clientContext);
    this.listStoredInfoTypesCallable =
        callableFactory.createUnaryCallable(
            listStoredInfoTypesTransportSettings,
            settings.listStoredInfoTypesSettings(),
            clientContext);
    this.listStoredInfoTypesPagedCallable =
        callableFactory.createPagedCallable(
            listStoredInfoTypesTransportSettings,
            settings.listStoredInfoTypesSettings(),
            clientContext);
    this.deleteStoredInfoTypeCallable =
        callableFactory.createUnaryCallable(
            deleteStoredInfoTypeTransportSettings,
            settings.deleteStoredInfoTypeSettings(),
            clientContext);
    this.hybridInspectDlpJobCallable =
        callableFactory.createUnaryCallable(
            hybridInspectDlpJobTransportSettings,
            settings.hybridInspectDlpJobSettings(),
            clientContext);
    this.finishDlpJobCallable =
        callableFactory.createUnaryCallable(
            finishDlpJobTransportSettings, settings.finishDlpJobSettings(), clientContext);

    this.backgroundResources =
        new BackgroundResourceAggregation(clientContext.getBackgroundResources());
  }

  @InternalApi
  public static List<ApiMethodDescriptor> getMethodDescriptors() {
    List<ApiMethodDescriptor> methodDescriptors = new ArrayList<>();
    methodDescriptors.add(inspectContentMethodDescriptor);
    methodDescriptors.add(redactImageMethodDescriptor);
    methodDescriptors.add(deidentifyContentMethodDescriptor);
    methodDescriptors.add(reidentifyContentMethodDescriptor);
    methodDescriptors.add(listInfoTypesMethodDescriptor);
    methodDescriptors.add(createInspectTemplateMethodDescriptor);
    methodDescriptors.add(updateInspectTemplateMethodDescriptor);
    methodDescriptors.add(getInspectTemplateMethodDescriptor);
    methodDescriptors.add(listInspectTemplatesMethodDescriptor);
    methodDescriptors.add(deleteInspectTemplateMethodDescriptor);
    methodDescriptors.add(createDeidentifyTemplateMethodDescriptor);
    methodDescriptors.add(updateDeidentifyTemplateMethodDescriptor);
    methodDescriptors.add(getDeidentifyTemplateMethodDescriptor);
    methodDescriptors.add(listDeidentifyTemplatesMethodDescriptor);
    methodDescriptors.add(deleteDeidentifyTemplateMethodDescriptor);
    methodDescriptors.add(createJobTriggerMethodDescriptor);
    methodDescriptors.add(updateJobTriggerMethodDescriptor);
    methodDescriptors.add(hybridInspectJobTriggerMethodDescriptor);
    methodDescriptors.add(getJobTriggerMethodDescriptor);
    methodDescriptors.add(listJobTriggersMethodDescriptor);
    methodDescriptors.add(deleteJobTriggerMethodDescriptor);
    methodDescriptors.add(activateJobTriggerMethodDescriptor);
    methodDescriptors.add(createDlpJobMethodDescriptor);
    methodDescriptors.add(listDlpJobsMethodDescriptor);
    methodDescriptors.add(getDlpJobMethodDescriptor);
    methodDescriptors.add(deleteDlpJobMethodDescriptor);
    methodDescriptors.add(cancelDlpJobMethodDescriptor);
    methodDescriptors.add(createStoredInfoTypeMethodDescriptor);
    methodDescriptors.add(updateStoredInfoTypeMethodDescriptor);
    methodDescriptors.add(getStoredInfoTypeMethodDescriptor);
    methodDescriptors.add(listStoredInfoTypesMethodDescriptor);
    methodDescriptors.add(deleteStoredInfoTypeMethodDescriptor);
    methodDescriptors.add(hybridInspectDlpJobMethodDescriptor);
    methodDescriptors.add(finishDlpJobMethodDescriptor);
    return methodDescriptors;
  }

  @Override
  public UnaryCallable<InspectContentRequest, InspectContentResponse> inspectContentCallable() {
    return inspectContentCallable;
  }

  @Override
  public UnaryCallable<RedactImageRequest, RedactImageResponse> redactImageCallable() {
    return redactImageCallable;
  }

  @Override
  public UnaryCallable<DeidentifyContentRequest, DeidentifyContentResponse>
      deidentifyContentCallable() {
    return deidentifyContentCallable;
  }

  @Override
  public UnaryCallable<ReidentifyContentRequest, ReidentifyContentResponse>
      reidentifyContentCallable() {
    return reidentifyContentCallable;
  }

  @Override
  public UnaryCallable<ListInfoTypesRequest, ListInfoTypesResponse> listInfoTypesCallable() {
    return listInfoTypesCallable;
  }

  @Override
  public UnaryCallable<CreateInspectTemplateRequest, InspectTemplate>
      createInspectTemplateCallable() {
    return createInspectTemplateCallable;
  }

  @Override
  public UnaryCallable<UpdateInspectTemplateRequest, InspectTemplate>
      updateInspectTemplateCallable() {
    return updateInspectTemplateCallable;
  }

  @Override
  public UnaryCallable<GetInspectTemplateRequest, InspectTemplate> getInspectTemplateCallable() {
    return getInspectTemplateCallable;
  }

  @Override
  public UnaryCallable<ListInspectTemplatesRequest, ListInspectTemplatesResponse>
      listInspectTemplatesCallable() {
    return listInspectTemplatesCallable;
  }

  @Override
  public UnaryCallable<ListInspectTemplatesRequest, ListInspectTemplatesPagedResponse>
      listInspectTemplatesPagedCallable() {
    return listInspectTemplatesPagedCallable;
  }

  @Override
  public UnaryCallable<DeleteInspectTemplateRequest, Empty> deleteInspectTemplateCallable() {
    return deleteInspectTemplateCallable;
  }

  @Override
  public UnaryCallable<CreateDeidentifyTemplateRequest, DeidentifyTemplate>
      createDeidentifyTemplateCallable() {
    return createDeidentifyTemplateCallable;
  }

  @Override
  public UnaryCallable<UpdateDeidentifyTemplateRequest, DeidentifyTemplate>
      updateDeidentifyTemplateCallable() {
    return updateDeidentifyTemplateCallable;
  }

  @Override
  public UnaryCallable<GetDeidentifyTemplateRequest, DeidentifyTemplate>
      getDeidentifyTemplateCallable() {
    return getDeidentifyTemplateCallable;
  }

  @Override
  public UnaryCallable<ListDeidentifyTemplatesRequest, ListDeidentifyTemplatesResponse>
      listDeidentifyTemplatesCallable() {
    return listDeidentifyTemplatesCallable;
  }

  @Override
  public UnaryCallable<ListDeidentifyTemplatesRequest, ListDeidentifyTemplatesPagedResponse>
      listDeidentifyTemplatesPagedCallable() {
    return listDeidentifyTemplatesPagedCallable;
  }

  @Override
  public UnaryCallable<DeleteDeidentifyTemplateRequest, Empty> deleteDeidentifyTemplateCallable() {
    return deleteDeidentifyTemplateCallable;
  }

  @Override
  public UnaryCallable<CreateJobTriggerRequest, JobTrigger> createJobTriggerCallable() {
    return createJobTriggerCallable;
  }

  @Override
  public UnaryCallable<UpdateJobTriggerRequest, JobTrigger> updateJobTriggerCallable() {
    return updateJobTriggerCallable;
  }

  @Override
  public UnaryCallable<HybridInspectJobTriggerRequest, HybridInspectResponse>
      hybridInspectJobTriggerCallable() {
    return hybridInspectJobTriggerCallable;
  }

  @Override
  public UnaryCallable<GetJobTriggerRequest, JobTrigger> getJobTriggerCallable() {
    return getJobTriggerCallable;
  }

  @Override
  public UnaryCallable<ListJobTriggersRequest, ListJobTriggersResponse> listJobTriggersCallable() {
    return listJobTriggersCallable;
  }

  @Override
  public UnaryCallable<ListJobTriggersRequest, ListJobTriggersPagedResponse>
      listJobTriggersPagedCallable() {
    return listJobTriggersPagedCallable;
  }

  @Override
  public UnaryCallable<DeleteJobTriggerRequest, Empty> deleteJobTriggerCallable() {
    return deleteJobTriggerCallable;
  }

  @Override
  public UnaryCallable<ActivateJobTriggerRequest, DlpJob> activateJobTriggerCallable() {
    return activateJobTriggerCallable;
  }

  @Override
  public UnaryCallable<CreateDlpJobRequest, DlpJob> createDlpJobCallable() {
    return createDlpJobCallable;
  }

  @Override
  public UnaryCallable<ListDlpJobsRequest, ListDlpJobsResponse> listDlpJobsCallable() {
    return listDlpJobsCallable;
  }

  @Override
  public UnaryCallable<ListDlpJobsRequest, ListDlpJobsPagedResponse> listDlpJobsPagedCallable() {
    return listDlpJobsPagedCallable;
  }

  @Override
  public UnaryCallable<GetDlpJobRequest, DlpJob> getDlpJobCallable() {
    return getDlpJobCallable;
  }

  @Override
  public UnaryCallable<DeleteDlpJobRequest, Empty> deleteDlpJobCallable() {
    return deleteDlpJobCallable;
  }

  @Override
  public UnaryCallable<CancelDlpJobRequest, Empty> cancelDlpJobCallable() {
    return cancelDlpJobCallable;
  }

  @Override
  public UnaryCallable<CreateStoredInfoTypeRequest, StoredInfoType> createStoredInfoTypeCallable() {
    return createStoredInfoTypeCallable;
  }

  @Override
  public UnaryCallable<UpdateStoredInfoTypeRequest, StoredInfoType> updateStoredInfoTypeCallable() {
    return updateStoredInfoTypeCallable;
  }

  @Override
  public UnaryCallable<GetStoredInfoTypeRequest, StoredInfoType> getStoredInfoTypeCallable() {
    return getStoredInfoTypeCallable;
  }

  @Override
  public UnaryCallable<ListStoredInfoTypesRequest, ListStoredInfoTypesResponse>
      listStoredInfoTypesCallable() {
    return listStoredInfoTypesCallable;
  }

  @Override
  public UnaryCallable<ListStoredInfoTypesRequest, ListStoredInfoTypesPagedResponse>
      listStoredInfoTypesPagedCallable() {
    return listStoredInfoTypesPagedCallable;
  }

  @Override
  public UnaryCallable<DeleteStoredInfoTypeRequest, Empty> deleteStoredInfoTypeCallable() {
    return deleteStoredInfoTypeCallable;
  }

  @Override
  public UnaryCallable<HybridInspectDlpJobRequest, HybridInspectResponse>
      hybridInspectDlpJobCallable() {
    return hybridInspectDlpJobCallable;
  }

  @Override
  public UnaryCallable<FinishDlpJobRequest, Empty> finishDlpJobCallable() {
    return finishDlpJobCallable;
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
