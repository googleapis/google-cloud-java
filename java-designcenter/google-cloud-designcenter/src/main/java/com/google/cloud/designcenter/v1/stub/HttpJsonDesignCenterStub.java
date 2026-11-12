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

package com.google.cloud.designcenter.v1.stub;

import static com.google.cloud.designcenter.v1.DesignCenterClient.FetchFrameworksPagedResponse;
import static com.google.cloud.designcenter.v1.DesignCenterClient.ListApplicationTemplateRevisionsPagedResponse;
import static com.google.cloud.designcenter.v1.DesignCenterClient.ListApplicationTemplateSystemRevisionsPagedResponse;
import static com.google.cloud.designcenter.v1.DesignCenterClient.ListApplicationTemplatesPagedResponse;
import static com.google.cloud.designcenter.v1.DesignCenterClient.ListApplicationsPagedResponse;
import static com.google.cloud.designcenter.v1.DesignCenterClient.ListCatalogTemplateRevisionsPagedResponse;
import static com.google.cloud.designcenter.v1.DesignCenterClient.ListCatalogTemplatesPagedResponse;
import static com.google.cloud.designcenter.v1.DesignCenterClient.ListCatalogsPagedResponse;
import static com.google.cloud.designcenter.v1.DesignCenterClient.ListComponentsPagedResponse;
import static com.google.cloud.designcenter.v1.DesignCenterClient.ListConnectionsPagedResponse;
import static com.google.cloud.designcenter.v1.DesignCenterClient.ListLocationsPagedResponse;
import static com.google.cloud.designcenter.v1.DesignCenterClient.ListPoliciesPagedResponse;
import static com.google.cloud.designcenter.v1.DesignCenterClient.ListSharedTemplateRevisionsPagedResponse;
import static com.google.cloud.designcenter.v1.DesignCenterClient.ListSharedTemplatesPagedResponse;
import static com.google.cloud.designcenter.v1.DesignCenterClient.ListSharesPagedResponse;
import static com.google.cloud.designcenter.v1.DesignCenterClient.ListSpacesPagedResponse;

import com.google.api.HttpRule;
import com.google.api.core.InternalApi;
import com.google.api.gax.core.BackgroundResource;
import com.google.api.gax.core.BackgroundResourceAggregation;
import com.google.api.gax.httpjson.ApiMethodDescriptor;
import com.google.api.gax.httpjson.HttpJsonCallSettings;
import com.google.api.gax.httpjson.HttpJsonOperationSnapshot;
import com.google.api.gax.httpjson.HttpJsonStubCallableFactory;
import com.google.api.gax.httpjson.ProtoMessageRequestFormatter;
import com.google.api.gax.httpjson.ProtoMessageResponseParser;
import com.google.api.gax.httpjson.ProtoRestSerializer;
import com.google.api.gax.httpjson.longrunning.stub.HttpJsonOperationsStub;
import com.google.api.gax.rpc.ClientContext;
import com.google.api.gax.rpc.OperationCallable;
import com.google.api.gax.rpc.RequestParamsBuilder;
import com.google.api.gax.rpc.UnaryCallable;
import com.google.cloud.designcenter.v1.Application;
import com.google.cloud.designcenter.v1.ApplicationTemplate;
import com.google.cloud.designcenter.v1.ApplicationTemplateRevision;
import com.google.cloud.designcenter.v1.ApplicationTemplateSystemRevision;
import com.google.cloud.designcenter.v1.Catalog;
import com.google.cloud.designcenter.v1.CatalogTemplate;
import com.google.cloud.designcenter.v1.CatalogTemplateRevision;
import com.google.cloud.designcenter.v1.CommitApplicationTemplateRequest;
import com.google.cloud.designcenter.v1.Component;
import com.google.cloud.designcenter.v1.Connection;
import com.google.cloud.designcenter.v1.CreateApplicationRequest;
import com.google.cloud.designcenter.v1.CreateApplicationTemplateRequest;
import com.google.cloud.designcenter.v1.CreateCatalogRequest;
import com.google.cloud.designcenter.v1.CreateCatalogTemplateRequest;
import com.google.cloud.designcenter.v1.CreateCatalogTemplateRevisionRequest;
import com.google.cloud.designcenter.v1.CreateComponentRequest;
import com.google.cloud.designcenter.v1.CreateConnectionRequest;
import com.google.cloud.designcenter.v1.CreatePolicyRequest;
import com.google.cloud.designcenter.v1.CreateShareRequest;
import com.google.cloud.designcenter.v1.CreateSpaceRequest;
import com.google.cloud.designcenter.v1.DeleteApplicationRequest;
import com.google.cloud.designcenter.v1.DeleteApplicationTemplateRequest;
import com.google.cloud.designcenter.v1.DeleteApplicationTemplateRevisionRequest;
import com.google.cloud.designcenter.v1.DeleteCatalogRequest;
import com.google.cloud.designcenter.v1.DeleteCatalogTemplateRequest;
import com.google.cloud.designcenter.v1.DeleteCatalogTemplateRevisionRequest;
import com.google.cloud.designcenter.v1.DeleteComponentRequest;
import com.google.cloud.designcenter.v1.DeleteConnectionRequest;
import com.google.cloud.designcenter.v1.DeletePolicyRequest;
import com.google.cloud.designcenter.v1.DeleteShareRequest;
import com.google.cloud.designcenter.v1.DeleteSpaceRequest;
import com.google.cloud.designcenter.v1.DeployApplicationRequest;
import com.google.cloud.designcenter.v1.DeployApplicationResponse;
import com.google.cloud.designcenter.v1.ExportApplicationIaCRequest;
import com.google.cloud.designcenter.v1.ExportApplicationIaCResponse;
import com.google.cloud.designcenter.v1.ExportApplicationTemplateIaCRequest;
import com.google.cloud.designcenter.v1.ExportApplicationTemplateIaCResponse;
import com.google.cloud.designcenter.v1.ExportApplicationTemplateRevisionIaCRequest;
import com.google.cloud.designcenter.v1.ExportApplicationTemplateRevisionIaCResponse;
import com.google.cloud.designcenter.v1.FetchApplicationAssessmentReportRequest;
import com.google.cloud.designcenter.v1.FetchApplicationAssessmentReportResponse;
import com.google.cloud.designcenter.v1.FetchFrameworksRequest;
import com.google.cloud.designcenter.v1.FetchFrameworksResponse;
import com.google.cloud.designcenter.v1.GenerateApplicationAssessmentReportRequest;
import com.google.cloud.designcenter.v1.GenerateApplicationAssessmentReportResponse;
import com.google.cloud.designcenter.v1.GenerateApplicationIaCRequest;
import com.google.cloud.designcenter.v1.GenerateApplicationIaCResponse;
import com.google.cloud.designcenter.v1.GenerateApplicationTemplateAssessmentReportRequest;
import com.google.cloud.designcenter.v1.GenerateApplicationTemplateAssessmentReportResponse;
import com.google.cloud.designcenter.v1.GenerateApplicationTemplateIaCRequest;
import com.google.cloud.designcenter.v1.GenerateApplicationTemplateIaCResponse;
import com.google.cloud.designcenter.v1.GenerateApplicationTemplateRevisionIaCRequest;
import com.google.cloud.designcenter.v1.GenerateApplicationTemplateRevisionIaCResponse;
import com.google.cloud.designcenter.v1.GenerateAssessmentReportRequest;
import com.google.cloud.designcenter.v1.GenerateAssessmentReportResponse;
import com.google.cloud.designcenter.v1.GenerateTerraformPlanAssessmentReportRequest;
import com.google.cloud.designcenter.v1.GenerateTerraformPlanAssessmentReportResponse;
import com.google.cloud.designcenter.v1.GetApplicationRequest;
import com.google.cloud.designcenter.v1.GetApplicationTemplateRequest;
import com.google.cloud.designcenter.v1.GetApplicationTemplateRevisionRequest;
import com.google.cloud.designcenter.v1.GetApplicationTemplateSystemRevisionRequest;
import com.google.cloud.designcenter.v1.GetCatalogRequest;
import com.google.cloud.designcenter.v1.GetCatalogTemplateRequest;
import com.google.cloud.designcenter.v1.GetCatalogTemplateRevisionRequest;
import com.google.cloud.designcenter.v1.GetComponentRequest;
import com.google.cloud.designcenter.v1.GetConnectionRequest;
import com.google.cloud.designcenter.v1.GetPolicyRequest;
import com.google.cloud.designcenter.v1.GetShareRequest;
import com.google.cloud.designcenter.v1.GetSharedTemplateRequest;
import com.google.cloud.designcenter.v1.GetSharedTemplateRevisionRequest;
import com.google.cloud.designcenter.v1.GetSpaceRequest;
import com.google.cloud.designcenter.v1.ImportApplicationIaCRequest;
import com.google.cloud.designcenter.v1.ImportApplicationIaCResponse;
import com.google.cloud.designcenter.v1.ImportApplicationTemplateIaCRequest;
import com.google.cloud.designcenter.v1.ImportApplicationTemplateIaCResponse;
import com.google.cloud.designcenter.v1.ImportApplicationTemplateRequest;
import com.google.cloud.designcenter.v1.IngestApplicationTemplateIaCRequest;
import com.google.cloud.designcenter.v1.IngestApplicationTemplateIaCResponse;
import com.google.cloud.designcenter.v1.ListApplicationTemplateRevisionsRequest;
import com.google.cloud.designcenter.v1.ListApplicationTemplateRevisionsResponse;
import com.google.cloud.designcenter.v1.ListApplicationTemplateSystemRevisionsRequest;
import com.google.cloud.designcenter.v1.ListApplicationTemplateSystemRevisionsResponse;
import com.google.cloud.designcenter.v1.ListApplicationTemplatesRequest;
import com.google.cloud.designcenter.v1.ListApplicationTemplatesResponse;
import com.google.cloud.designcenter.v1.ListApplicationsRequest;
import com.google.cloud.designcenter.v1.ListApplicationsResponse;
import com.google.cloud.designcenter.v1.ListCatalogTemplateRevisionsRequest;
import com.google.cloud.designcenter.v1.ListCatalogTemplateRevisionsResponse;
import com.google.cloud.designcenter.v1.ListCatalogTemplatesRequest;
import com.google.cloud.designcenter.v1.ListCatalogTemplatesResponse;
import com.google.cloud.designcenter.v1.ListCatalogsRequest;
import com.google.cloud.designcenter.v1.ListCatalogsResponse;
import com.google.cloud.designcenter.v1.ListComponentsRequest;
import com.google.cloud.designcenter.v1.ListComponentsResponse;
import com.google.cloud.designcenter.v1.ListConnectionsRequest;
import com.google.cloud.designcenter.v1.ListConnectionsResponse;
import com.google.cloud.designcenter.v1.ListPoliciesRequest;
import com.google.cloud.designcenter.v1.ListPoliciesResponse;
import com.google.cloud.designcenter.v1.ListSharedTemplateRevisionsRequest;
import com.google.cloud.designcenter.v1.ListSharedTemplateRevisionsResponse;
import com.google.cloud.designcenter.v1.ListSharedTemplatesRequest;
import com.google.cloud.designcenter.v1.ListSharedTemplatesResponse;
import com.google.cloud.designcenter.v1.ListSharesRequest;
import com.google.cloud.designcenter.v1.ListSharesResponse;
import com.google.cloud.designcenter.v1.ListSpacesRequest;
import com.google.cloud.designcenter.v1.ListSpacesResponse;
import com.google.cloud.designcenter.v1.OperationMetadata;
import com.google.cloud.designcenter.v1.Policy;
import com.google.cloud.designcenter.v1.PreviewApplicationRequest;
import com.google.cloud.designcenter.v1.PreviewApplicationResponse;
import com.google.cloud.designcenter.v1.RecommendIAMRolesRequest;
import com.google.cloud.designcenter.v1.RecommendIAMRolesResponse;
import com.google.cloud.designcenter.v1.RegisterAppHubApplicationResourcesRequest;
import com.google.cloud.designcenter.v1.RegisterAppHubApplicationResourcesResponse;
import com.google.cloud.designcenter.v1.Share;
import com.google.cloud.designcenter.v1.SharedTemplate;
import com.google.cloud.designcenter.v1.SharedTemplateRevision;
import com.google.cloud.designcenter.v1.SnapshotApplicationTemplateRequest;
import com.google.cloud.designcenter.v1.SnapshotApplicationTemplateResponse;
import com.google.cloud.designcenter.v1.Space;
import com.google.cloud.designcenter.v1.SyncShareRequest;
import com.google.cloud.designcenter.v1.UpdateApplicationRequest;
import com.google.cloud.designcenter.v1.UpdateApplicationTemplateRequest;
import com.google.cloud.designcenter.v1.UpdateCatalogRequest;
import com.google.cloud.designcenter.v1.UpdateCatalogTemplateRequest;
import com.google.cloud.designcenter.v1.UpdateComponentRequest;
import com.google.cloud.designcenter.v1.UpdateConnectionRequest;
import com.google.cloud.designcenter.v1.UpdatePolicyRequest;
import com.google.cloud.designcenter.v1.UpdateSpaceRequest;
import com.google.cloud.location.GetLocationRequest;
import com.google.cloud.location.ListLocationsRequest;
import com.google.cloud.location.ListLocationsResponse;
import com.google.cloud.location.Location;
import com.google.common.collect.ImmutableMap;
import com.google.iam.v1.GetIamPolicyRequest;
import com.google.iam.v1.SetIamPolicyRequest;
import com.google.iam.v1.TestIamPermissionsRequest;
import com.google.iam.v1.TestIamPermissionsResponse;
import com.google.longrunning.Operation;
import com.google.protobuf.Empty;
import com.google.protobuf.TypeRegistry;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.TimeUnit;
import javax.annotation.Generated;
import org.jspecify.annotations.NullMarked;

// AUTO-GENERATED DOCUMENTATION AND CLASS.
/**
 * REST stub implementation for the DesignCenter service API.
 *
 * <p>This class is for advanced usage and reflects the underlying API directly.
 */
@NullMarked
@Generated("by gapic-generator-java")
public class HttpJsonDesignCenterStub extends DesignCenterStub {
  private static final TypeRegistry typeRegistry =
      TypeRegistry.newBuilder()
          .add(GenerateApplicationTemplateAssessmentReportResponse.getDescriptor())
          .add(GenerateApplicationAssessmentReportResponse.getDescriptor())
          .add(ExportApplicationTemplateIaCResponse.getDescriptor())
          .add(OperationMetadata.getDescriptor())
          .add(RecommendIAMRolesResponse.getDescriptor())
          .add(ExportApplicationTemplateRevisionIaCResponse.getDescriptor())
          .add(ExportApplicationIaCResponse.getDescriptor())
          .add(CatalogTemplateRevision.getDescriptor())
          .add(IngestApplicationTemplateIaCResponse.getDescriptor())
          .add(Empty.getDescriptor())
          .add(GenerateAssessmentReportResponse.getDescriptor())
          .add(SnapshotApplicationTemplateResponse.getDescriptor())
          .add(DeployApplicationResponse.getDescriptor())
          .add(PreviewApplicationResponse.getDescriptor())
          .add(Share.getDescriptor())
          .add(RegisterAppHubApplicationResourcesResponse.getDescriptor())
          .add(GenerateTerraformPlanAssessmentReportResponse.getDescriptor())
          .build();

  private static final ApiMethodDescriptor<GetSpaceRequest, Space> getSpaceMethodDescriptor =
      ApiMethodDescriptor.<GetSpaceRequest, Space>newBuilder()
          .setFullMethodName("google.cloud.designcenter.v1.DesignCenter/GetSpace")
          .setHttpMethod("GET")
          .setType(ApiMethodDescriptor.MethodType.UNARY)
          .setRequestFormatter(
              ProtoMessageRequestFormatter.<GetSpaceRequest>newBuilder()
                  .setPath(
                      "/v1/{name=projects/*/locations/*/spaces/*}",
                      request -> {
                        Map<String, String> fields = new HashMap<>();
                        ProtoRestSerializer<GetSpaceRequest> serializer =
                            ProtoRestSerializer.create();
                        serializer.putPathParam(fields, "name", request.getName());
                        return fields;
                      })
                  .setQueryParamsExtractor(
                      request -> {
                        Map<String, List<String>> fields = new HashMap<>();
                        ProtoRestSerializer<GetSpaceRequest> serializer =
                            ProtoRestSerializer.create();
                        serializer.putQueryParam(fields, "$alt", "json;enum-encoding=int");
                        return fields;
                      })
                  .setRequestBodyExtractor(request -> null)
                  .build())
          .setResponseParser(
              ProtoMessageResponseParser.<Space>newBuilder()
                  .setDefaultInstance(Space.getDefaultInstance())
                  .setDefaultTypeRegistry(typeRegistry)
                  .build())
          .build();

  private static final ApiMethodDescriptor<ListSpacesRequest, ListSpacesResponse>
      listSpacesMethodDescriptor =
          ApiMethodDescriptor.<ListSpacesRequest, ListSpacesResponse>newBuilder()
              .setFullMethodName("google.cloud.designcenter.v1.DesignCenter/ListSpaces")
              .setHttpMethod("GET")
              .setType(ApiMethodDescriptor.MethodType.UNARY)
              .setRequestFormatter(
                  ProtoMessageRequestFormatter.<ListSpacesRequest>newBuilder()
                      .setPath(
                          "/v1/{parent=projects/*/locations/*}/spaces",
                          request -> {
                            Map<String, String> fields = new HashMap<>();
                            ProtoRestSerializer<ListSpacesRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putPathParam(fields, "parent", request.getParent());
                            return fields;
                          })
                      .setQueryParamsExtractor(
                          request -> {
                            Map<String, List<String>> fields = new HashMap<>();
                            ProtoRestSerializer<ListSpacesRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putQueryParam(fields, "filter", request.getFilter());
                            serializer.putQueryParam(fields, "orderBy", request.getOrderBy());
                            serializer.putQueryParam(fields, "pageSize", request.getPageSize());
                            serializer.putQueryParam(fields, "pageToken", request.getPageToken());
                            serializer.putQueryParam(fields, "$alt", "json;enum-encoding=int");
                            return fields;
                          })
                      .setRequestBodyExtractor(request -> null)
                      .build())
              .setResponseParser(
                  ProtoMessageResponseParser.<ListSpacesResponse>newBuilder()
                      .setDefaultInstance(ListSpacesResponse.getDefaultInstance())
                      .setDefaultTypeRegistry(typeRegistry)
                      .build())
              .build();

  private static final ApiMethodDescriptor<CreateSpaceRequest, Space> createSpaceMethodDescriptor =
      ApiMethodDescriptor.<CreateSpaceRequest, Space>newBuilder()
          .setFullMethodName("google.cloud.designcenter.v1.DesignCenter/CreateSpace")
          .setHttpMethod("POST")
          .setType(ApiMethodDescriptor.MethodType.UNARY)
          .setRequestFormatter(
              ProtoMessageRequestFormatter.<CreateSpaceRequest>newBuilder()
                  .setPath(
                      "/v1/{parent=projects/*/locations/*}/spaces",
                      request -> {
                        Map<String, String> fields = new HashMap<>();
                        ProtoRestSerializer<CreateSpaceRequest> serializer =
                            ProtoRestSerializer.create();
                        serializer.putPathParam(fields, "parent", request.getParent());
                        return fields;
                      })
                  .setQueryParamsExtractor(
                      request -> {
                        Map<String, List<String>> fields = new HashMap<>();
                        ProtoRestSerializer<CreateSpaceRequest> serializer =
                            ProtoRestSerializer.create();
                        serializer.putQueryParam(fields, "spaceId", request.getSpaceId());
                        serializer.putQueryParam(fields, "$alt", "json;enum-encoding=int");
                        return fields;
                      })
                  .setRequestBodyExtractor(
                      request ->
                          ProtoRestSerializer.create().toBody("space", request.getSpace(), true))
                  .build())
          .setResponseParser(
              ProtoMessageResponseParser.<Space>newBuilder()
                  .setDefaultInstance(Space.getDefaultInstance())
                  .setDefaultTypeRegistry(typeRegistry)
                  .build())
          .build();

  private static final ApiMethodDescriptor<UpdateSpaceRequest, Space> updateSpaceMethodDescriptor =
      ApiMethodDescriptor.<UpdateSpaceRequest, Space>newBuilder()
          .setFullMethodName("google.cloud.designcenter.v1.DesignCenter/UpdateSpace")
          .setHttpMethod("PATCH")
          .setType(ApiMethodDescriptor.MethodType.UNARY)
          .setRequestFormatter(
              ProtoMessageRequestFormatter.<UpdateSpaceRequest>newBuilder()
                  .setPath(
                      "/v1/{space.name=projects/*/locations/*/spaces/*}",
                      request -> {
                        Map<String, String> fields = new HashMap<>();
                        ProtoRestSerializer<UpdateSpaceRequest> serializer =
                            ProtoRestSerializer.create();
                        serializer.putPathParam(fields, "space.name", request.getSpace().getName());
                        return fields;
                      })
                  .setQueryParamsExtractor(
                      request -> {
                        Map<String, List<String>> fields = new HashMap<>();
                        ProtoRestSerializer<UpdateSpaceRequest> serializer =
                            ProtoRestSerializer.create();
                        serializer.putQueryParam(fields, "updateMask", request.getUpdateMask());
                        serializer.putQueryParam(fields, "$alt", "json;enum-encoding=int");
                        return fields;
                      })
                  .setRequestBodyExtractor(
                      request ->
                          ProtoRestSerializer.create().toBody("space", request.getSpace(), true))
                  .build())
          .setResponseParser(
              ProtoMessageResponseParser.<Space>newBuilder()
                  .setDefaultInstance(Space.getDefaultInstance())
                  .setDefaultTypeRegistry(typeRegistry)
                  .build())
          .build();

  private static final ApiMethodDescriptor<DeleteSpaceRequest, Empty> deleteSpaceMethodDescriptor =
      ApiMethodDescriptor.<DeleteSpaceRequest, Empty>newBuilder()
          .setFullMethodName("google.cloud.designcenter.v1.DesignCenter/DeleteSpace")
          .setHttpMethod("DELETE")
          .setType(ApiMethodDescriptor.MethodType.UNARY)
          .setRequestFormatter(
              ProtoMessageRequestFormatter.<DeleteSpaceRequest>newBuilder()
                  .setPath(
                      "/v1/{name=projects/*/locations/*/spaces/*}",
                      request -> {
                        Map<String, String> fields = new HashMap<>();
                        ProtoRestSerializer<DeleteSpaceRequest> serializer =
                            ProtoRestSerializer.create();
                        serializer.putPathParam(fields, "name", request.getName());
                        return fields;
                      })
                  .setQueryParamsExtractor(
                      request -> {
                        Map<String, List<String>> fields = new HashMap<>();
                        ProtoRestSerializer<DeleteSpaceRequest> serializer =
                            ProtoRestSerializer.create();
                        serializer.putQueryParam(fields, "force", request.getForce());
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

  private static final ApiMethodDescriptor<GetApplicationTemplateRequest, ApplicationTemplate>
      getApplicationTemplateMethodDescriptor =
          ApiMethodDescriptor.<GetApplicationTemplateRequest, ApplicationTemplate>newBuilder()
              .setFullMethodName("google.cloud.designcenter.v1.DesignCenter/GetApplicationTemplate")
              .setHttpMethod("GET")
              .setType(ApiMethodDescriptor.MethodType.UNARY)
              .setRequestFormatter(
                  ProtoMessageRequestFormatter.<GetApplicationTemplateRequest>newBuilder()
                      .setPath(
                          "/v1/{name=projects/*/locations/*/spaces/*/applicationTemplates/*}",
                          request -> {
                            Map<String, String> fields = new HashMap<>();
                            ProtoRestSerializer<GetApplicationTemplateRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putPathParam(fields, "name", request.getName());
                            return fields;
                          })
                      .setQueryParamsExtractor(
                          request -> {
                            Map<String, List<String>> fields = new HashMap<>();
                            ProtoRestSerializer<GetApplicationTemplateRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putQueryParam(fields, "$alt", "json;enum-encoding=int");
                            return fields;
                          })
                      .setRequestBodyExtractor(request -> null)
                      .build())
              .setResponseParser(
                  ProtoMessageResponseParser.<ApplicationTemplate>newBuilder()
                      .setDefaultInstance(ApplicationTemplate.getDefaultInstance())
                      .setDefaultTypeRegistry(typeRegistry)
                      .build())
              .build();

  private static final ApiMethodDescriptor<
          ListApplicationTemplatesRequest, ListApplicationTemplatesResponse>
      listApplicationTemplatesMethodDescriptor =
          ApiMethodDescriptor
              .<ListApplicationTemplatesRequest, ListApplicationTemplatesResponse>newBuilder()
              .setFullMethodName(
                  "google.cloud.designcenter.v1.DesignCenter/ListApplicationTemplates")
              .setHttpMethod("GET")
              .setType(ApiMethodDescriptor.MethodType.UNARY)
              .setRequestFormatter(
                  ProtoMessageRequestFormatter.<ListApplicationTemplatesRequest>newBuilder()
                      .setPath(
                          "/v1/{parent=projects/*/locations/*/spaces/*}/applicationTemplates",
                          request -> {
                            Map<String, String> fields = new HashMap<>();
                            ProtoRestSerializer<ListApplicationTemplatesRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putPathParam(fields, "parent", request.getParent());
                            return fields;
                          })
                      .setQueryParamsExtractor(
                          request -> {
                            Map<String, List<String>> fields = new HashMap<>();
                            ProtoRestSerializer<ListApplicationTemplatesRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putQueryParam(fields, "filter", request.getFilter());
                            serializer.putQueryParam(fields, "orderBy", request.getOrderBy());
                            serializer.putQueryParam(fields, "pageSize", request.getPageSize());
                            serializer.putQueryParam(fields, "pageToken", request.getPageToken());
                            serializer.putQueryParam(fields, "$alt", "json;enum-encoding=int");
                            return fields;
                          })
                      .setRequestBodyExtractor(request -> null)
                      .build())
              .setResponseParser(
                  ProtoMessageResponseParser.<ListApplicationTemplatesResponse>newBuilder()
                      .setDefaultInstance(ListApplicationTemplatesResponse.getDefaultInstance())
                      .setDefaultTypeRegistry(typeRegistry)
                      .build())
              .build();

  private static final ApiMethodDescriptor<CreateApplicationTemplateRequest, ApplicationTemplate>
      createApplicationTemplateMethodDescriptor =
          ApiMethodDescriptor.<CreateApplicationTemplateRequest, ApplicationTemplate>newBuilder()
              .setFullMethodName(
                  "google.cloud.designcenter.v1.DesignCenter/CreateApplicationTemplate")
              .setHttpMethod("POST")
              .setType(ApiMethodDescriptor.MethodType.UNARY)
              .setRequestFormatter(
                  ProtoMessageRequestFormatter.<CreateApplicationTemplateRequest>newBuilder()
                      .setPath(
                          "/v1/{parent=projects/*/locations/*/spaces/*}/applicationTemplates",
                          request -> {
                            Map<String, String> fields = new HashMap<>();
                            ProtoRestSerializer<CreateApplicationTemplateRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putPathParam(fields, "parent", request.getParent());
                            return fields;
                          })
                      .setQueryParamsExtractor(
                          request -> {
                            Map<String, List<String>> fields = new HashMap<>();
                            ProtoRestSerializer<CreateApplicationTemplateRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putQueryParam(
                                fields,
                                "applicationTemplateId",
                                request.getApplicationTemplateId());
                            serializer.putQueryParam(fields, "$alt", "json;enum-encoding=int");
                            return fields;
                          })
                      .setRequestBodyExtractor(
                          request ->
                              ProtoRestSerializer.create()
                                  .toBody(
                                      "applicationTemplate",
                                      request.getApplicationTemplate(),
                                      true))
                      .build())
              .setResponseParser(
                  ProtoMessageResponseParser.<ApplicationTemplate>newBuilder()
                      .setDefaultInstance(ApplicationTemplate.getDefaultInstance())
                      .setDefaultTypeRegistry(typeRegistry)
                      .build())
              .build();

  private static final ApiMethodDescriptor<UpdateApplicationTemplateRequest, ApplicationTemplate>
      updateApplicationTemplateMethodDescriptor =
          ApiMethodDescriptor.<UpdateApplicationTemplateRequest, ApplicationTemplate>newBuilder()
              .setFullMethodName(
                  "google.cloud.designcenter.v1.DesignCenter/UpdateApplicationTemplate")
              .setHttpMethod("PATCH")
              .setType(ApiMethodDescriptor.MethodType.UNARY)
              .setRequestFormatter(
                  ProtoMessageRequestFormatter.<UpdateApplicationTemplateRequest>newBuilder()
                      .setPath(
                          "/v1/{applicationTemplate.name=projects/*/locations/*/spaces/*/applicationTemplates/*}",
                          request -> {
                            Map<String, String> fields = new HashMap<>();
                            ProtoRestSerializer<UpdateApplicationTemplateRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putPathParam(
                                fields,
                                "applicationTemplate.name",
                                request.getApplicationTemplate().getName());
                            return fields;
                          })
                      .setQueryParamsExtractor(
                          request -> {
                            Map<String, List<String>> fields = new HashMap<>();
                            ProtoRestSerializer<UpdateApplicationTemplateRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putQueryParam(fields, "updateMask", request.getUpdateMask());
                            serializer.putQueryParam(fields, "$alt", "json;enum-encoding=int");
                            return fields;
                          })
                      .setRequestBodyExtractor(
                          request ->
                              ProtoRestSerializer.create()
                                  .toBody(
                                      "applicationTemplate",
                                      request.getApplicationTemplate(),
                                      true))
                      .build())
              .setResponseParser(
                  ProtoMessageResponseParser.<ApplicationTemplate>newBuilder()
                      .setDefaultInstance(ApplicationTemplate.getDefaultInstance())
                      .setDefaultTypeRegistry(typeRegistry)
                      .build())
              .build();

  private static final ApiMethodDescriptor<ImportApplicationTemplateRequest, ApplicationTemplate>
      importApplicationTemplateMethodDescriptor =
          ApiMethodDescriptor.<ImportApplicationTemplateRequest, ApplicationTemplate>newBuilder()
              .setFullMethodName(
                  "google.cloud.designcenter.v1.DesignCenter/ImportApplicationTemplate")
              .setHttpMethod("POST")
              .setType(ApiMethodDescriptor.MethodType.UNARY)
              .setRequestFormatter(
                  ProtoMessageRequestFormatter.<ImportApplicationTemplateRequest>newBuilder()
                      .setPath(
                          "/v1/{name=projects/*/locations/*/spaces/*/applicationTemplates/*}:import",
                          request -> {
                            Map<String, String> fields = new HashMap<>();
                            ProtoRestSerializer<ImportApplicationTemplateRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putPathParam(fields, "name", request.getName());
                            return fields;
                          })
                      .setQueryParamsExtractor(
                          request -> {
                            Map<String, List<String>> fields = new HashMap<>();
                            ProtoRestSerializer<ImportApplicationTemplateRequest> serializer =
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
                  ProtoMessageResponseParser.<ApplicationTemplate>newBuilder()
                      .setDefaultInstance(ApplicationTemplate.getDefaultInstance())
                      .setDefaultTypeRegistry(typeRegistry)
                      .build())
              .build();

  private static final ApiMethodDescriptor<DeleteApplicationTemplateRequest, Empty>
      deleteApplicationTemplateMethodDescriptor =
          ApiMethodDescriptor.<DeleteApplicationTemplateRequest, Empty>newBuilder()
              .setFullMethodName(
                  "google.cloud.designcenter.v1.DesignCenter/DeleteApplicationTemplate")
              .setHttpMethod("DELETE")
              .setType(ApiMethodDescriptor.MethodType.UNARY)
              .setRequestFormatter(
                  ProtoMessageRequestFormatter.<DeleteApplicationTemplateRequest>newBuilder()
                      .setPath(
                          "/v1/{name=projects/*/locations/*/spaces/*/applicationTemplates/*}",
                          request -> {
                            Map<String, String> fields = new HashMap<>();
                            ProtoRestSerializer<DeleteApplicationTemplateRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putPathParam(fields, "name", request.getName());
                            return fields;
                          })
                      .setQueryParamsExtractor(
                          request -> {
                            Map<String, List<String>> fields = new HashMap<>();
                            ProtoRestSerializer<DeleteApplicationTemplateRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putQueryParam(fields, "force", request.getForce());
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
          CommitApplicationTemplateRequest, ApplicationTemplateRevision>
      commitApplicationTemplateMethodDescriptor =
          ApiMethodDescriptor
              .<CommitApplicationTemplateRequest, ApplicationTemplateRevision>newBuilder()
              .setFullMethodName(
                  "google.cloud.designcenter.v1.DesignCenter/CommitApplicationTemplate")
              .setHttpMethod("POST")
              .setType(ApiMethodDescriptor.MethodType.UNARY)
              .setRequestFormatter(
                  ProtoMessageRequestFormatter.<CommitApplicationTemplateRequest>newBuilder()
                      .setPath(
                          "/v1/{name=projects/*/locations/*/spaces/*/applicationTemplates/*}:commit",
                          request -> {
                            Map<String, String> fields = new HashMap<>();
                            ProtoRestSerializer<CommitApplicationTemplateRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putPathParam(fields, "name", request.getName());
                            return fields;
                          })
                      .setQueryParamsExtractor(
                          request -> {
                            Map<String, List<String>> fields = new HashMap<>();
                            ProtoRestSerializer<CommitApplicationTemplateRequest> serializer =
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
                  ProtoMessageResponseParser.<ApplicationTemplateRevision>newBuilder()
                      .setDefaultInstance(ApplicationTemplateRevision.getDefaultInstance())
                      .setDefaultTypeRegistry(typeRegistry)
                      .build())
              .build();

  private static final ApiMethodDescriptor<SnapshotApplicationTemplateRequest, Operation>
      snapshotApplicationTemplateMethodDescriptor =
          ApiMethodDescriptor.<SnapshotApplicationTemplateRequest, Operation>newBuilder()
              .setFullMethodName(
                  "google.cloud.designcenter.v1.DesignCenter/SnapshotApplicationTemplate")
              .setHttpMethod("POST")
              .setType(ApiMethodDescriptor.MethodType.UNARY)
              .setRequestFormatter(
                  ProtoMessageRequestFormatter.<SnapshotApplicationTemplateRequest>newBuilder()
                      .setPath(
                          "/v1/{name=projects/*/locations/*/spaces/*/applicationTemplates/*}:snapshot",
                          request -> {
                            Map<String, String> fields = new HashMap<>();
                            ProtoRestSerializer<SnapshotApplicationTemplateRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putPathParam(fields, "name", request.getName());
                            return fields;
                          })
                      .setQueryParamsExtractor(
                          request -> {
                            Map<String, List<String>> fields = new HashMap<>();
                            ProtoRestSerializer<SnapshotApplicationTemplateRequest> serializer =
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
                  ProtoMessageResponseParser.<Operation>newBuilder()
                      .setDefaultInstance(Operation.getDefaultInstance())
                      .setDefaultTypeRegistry(typeRegistry)
                      .build())
              .setOperationSnapshotFactory(
                  (SnapshotApplicationTemplateRequest request, Operation response) ->
                      HttpJsonOperationSnapshot.create(response))
              .build();

  private static final ApiMethodDescriptor<
          GenerateApplicationTemplateIaCRequest, GenerateApplicationTemplateIaCResponse>
      generateApplicationTemplateIaCMethodDescriptor =
          ApiMethodDescriptor
              .<GenerateApplicationTemplateIaCRequest, GenerateApplicationTemplateIaCResponse>
                  newBuilder()
              .setFullMethodName(
                  "google.cloud.designcenter.v1.DesignCenter/GenerateApplicationTemplateIaC")
              .setHttpMethod("POST")
              .setType(ApiMethodDescriptor.MethodType.UNARY)
              .setRequestFormatter(
                  ProtoMessageRequestFormatter.<GenerateApplicationTemplateIaCRequest>newBuilder()
                      .setPath(
                          "/v1/{name=projects/*/locations/*/spaces/*/applicationTemplates/*}:generate",
                          request -> {
                            Map<String, String> fields = new HashMap<>();
                            ProtoRestSerializer<GenerateApplicationTemplateIaCRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putPathParam(fields, "name", request.getName());
                            return fields;
                          })
                      .setQueryParamsExtractor(
                          request -> {
                            Map<String, List<String>> fields = new HashMap<>();
                            ProtoRestSerializer<GenerateApplicationTemplateIaCRequest> serializer =
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
                  ProtoMessageResponseParser.<GenerateApplicationTemplateIaCResponse>newBuilder()
                      .setDefaultInstance(
                          GenerateApplicationTemplateIaCResponse.getDefaultInstance())
                      .setDefaultTypeRegistry(typeRegistry)
                      .build())
              .build();

  private static final ApiMethodDescriptor<ExportApplicationTemplateIaCRequest, Operation>
      exportApplicationTemplateIaCMethodDescriptor =
          ApiMethodDescriptor.<ExportApplicationTemplateIaCRequest, Operation>newBuilder()
              .setFullMethodName(
                  "google.cloud.designcenter.v1.DesignCenter/ExportApplicationTemplateIaC")
              .setHttpMethod("POST")
              .setType(ApiMethodDescriptor.MethodType.UNARY)
              .setRequestFormatter(
                  ProtoMessageRequestFormatter.<ExportApplicationTemplateIaCRequest>newBuilder()
                      .setPath(
                          "/v1/{name=projects/*/locations/*/spaces/*/applicationTemplates/*}:export",
                          request -> {
                            Map<String, String> fields = new HashMap<>();
                            ProtoRestSerializer<ExportApplicationTemplateIaCRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putPathParam(fields, "name", request.getName());
                            return fields;
                          })
                      .setQueryParamsExtractor(
                          request -> {
                            Map<String, List<String>> fields = new HashMap<>();
                            ProtoRestSerializer<ExportApplicationTemplateIaCRequest> serializer =
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
                  ProtoMessageResponseParser.<Operation>newBuilder()
                      .setDefaultInstance(Operation.getDefaultInstance())
                      .setDefaultTypeRegistry(typeRegistry)
                      .build())
              .setOperationSnapshotFactory(
                  (ExportApplicationTemplateIaCRequest request, Operation response) ->
                      HttpJsonOperationSnapshot.create(response))
              .build();

  private static final ApiMethodDescriptor<
          GenerateApplicationTemplateRevisionIaCRequest,
          GenerateApplicationTemplateRevisionIaCResponse>
      generateApplicationTemplateRevisionIaCMethodDescriptor =
          ApiMethodDescriptor
              .<GenerateApplicationTemplateRevisionIaCRequest,
                  GenerateApplicationTemplateRevisionIaCResponse>
                  newBuilder()
              .setFullMethodName(
                  "google.cloud.designcenter.v1.DesignCenter/GenerateApplicationTemplateRevisionIaC")
              .setHttpMethod("POST")
              .setType(ApiMethodDescriptor.MethodType.UNARY)
              .setRequestFormatter(
                  ProtoMessageRequestFormatter
                      .<GenerateApplicationTemplateRevisionIaCRequest>newBuilder()
                      .setPath(
                          "/v1/{name=projects/*/locations/*/spaces/*/applicationTemplates/*/revisions/*}:generate",
                          request -> {
                            Map<String, String> fields = new HashMap<>();
                            ProtoRestSerializer<GenerateApplicationTemplateRevisionIaCRequest>
                                serializer = ProtoRestSerializer.create();
                            serializer.putPathParam(fields, "name", request.getName());
                            return fields;
                          })
                      .setQueryParamsExtractor(
                          request -> {
                            Map<String, List<String>> fields = new HashMap<>();
                            ProtoRestSerializer<GenerateApplicationTemplateRevisionIaCRequest>
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
                  ProtoMessageResponseParser
                      .<GenerateApplicationTemplateRevisionIaCResponse>newBuilder()
                      .setDefaultInstance(
                          GenerateApplicationTemplateRevisionIaCResponse.getDefaultInstance())
                      .setDefaultTypeRegistry(typeRegistry)
                      .build())
              .build();

  private static final ApiMethodDescriptor<ExportApplicationTemplateRevisionIaCRequest, Operation>
      exportApplicationTemplateRevisionIaCMethodDescriptor =
          ApiMethodDescriptor.<ExportApplicationTemplateRevisionIaCRequest, Operation>newBuilder()
              .setFullMethodName(
                  "google.cloud.designcenter.v1.DesignCenter/ExportApplicationTemplateRevisionIaC")
              .setHttpMethod("POST")
              .setType(ApiMethodDescriptor.MethodType.UNARY)
              .setRequestFormatter(
                  ProtoMessageRequestFormatter
                      .<ExportApplicationTemplateRevisionIaCRequest>newBuilder()
                      .setPath(
                          "/v1/{name=projects/*/locations/*/spaces/*/applicationTemplates/*/revisions/*}:export",
                          request -> {
                            Map<String, String> fields = new HashMap<>();
                            ProtoRestSerializer<ExportApplicationTemplateRevisionIaCRequest>
                                serializer = ProtoRestSerializer.create();
                            serializer.putPathParam(fields, "name", request.getName());
                            return fields;
                          })
                      .setQueryParamsExtractor(
                          request -> {
                            Map<String, List<String>> fields = new HashMap<>();
                            ProtoRestSerializer<ExportApplicationTemplateRevisionIaCRequest>
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
                  ProtoMessageResponseParser.<Operation>newBuilder()
                      .setDefaultInstance(Operation.getDefaultInstance())
                      .setDefaultTypeRegistry(typeRegistry)
                      .build())
              .setOperationSnapshotFactory(
                  (ExportApplicationTemplateRevisionIaCRequest request, Operation response) ->
                      HttpJsonOperationSnapshot.create(response))
              .build();

  private static final ApiMethodDescriptor<GetComponentRequest, Component>
      getComponentMethodDescriptor =
          ApiMethodDescriptor.<GetComponentRequest, Component>newBuilder()
              .setFullMethodName("google.cloud.designcenter.v1.DesignCenter/GetComponent")
              .setHttpMethod("GET")
              .setType(ApiMethodDescriptor.MethodType.UNARY)
              .setRequestFormatter(
                  ProtoMessageRequestFormatter.<GetComponentRequest>newBuilder()
                      .setPath(
                          "/v1/{name=projects/*/locations/*/spaces/*/applicationTemplates/*/components/*}",
                          request -> {
                            Map<String, String> fields = new HashMap<>();
                            ProtoRestSerializer<GetComponentRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putPathParam(fields, "name", request.getName());
                            return fields;
                          })
                      .setQueryParamsExtractor(
                          request -> {
                            Map<String, List<String>> fields = new HashMap<>();
                            ProtoRestSerializer<GetComponentRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putQueryParam(fields, "$alt", "json;enum-encoding=int");
                            return fields;
                          })
                      .setRequestBodyExtractor(request -> null)
                      .build())
              .setResponseParser(
                  ProtoMessageResponseParser.<Component>newBuilder()
                      .setDefaultInstance(Component.getDefaultInstance())
                      .setDefaultTypeRegistry(typeRegistry)
                      .build())
              .build();

  private static final ApiMethodDescriptor<ListComponentsRequest, ListComponentsResponse>
      listComponentsMethodDescriptor =
          ApiMethodDescriptor.<ListComponentsRequest, ListComponentsResponse>newBuilder()
              .setFullMethodName("google.cloud.designcenter.v1.DesignCenter/ListComponents")
              .setHttpMethod("GET")
              .setType(ApiMethodDescriptor.MethodType.UNARY)
              .setRequestFormatter(
                  ProtoMessageRequestFormatter.<ListComponentsRequest>newBuilder()
                      .setPath(
                          "/v1/{parent=projects/*/locations/*/spaces/*/applicationTemplates/*}/components",
                          request -> {
                            Map<String, String> fields = new HashMap<>();
                            ProtoRestSerializer<ListComponentsRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putPathParam(fields, "parent", request.getParent());
                            return fields;
                          })
                      .setQueryParamsExtractor(
                          request -> {
                            Map<String, List<String>> fields = new HashMap<>();
                            ProtoRestSerializer<ListComponentsRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putQueryParam(fields, "filter", request.getFilter());
                            serializer.putQueryParam(fields, "orderBy", request.getOrderBy());
                            serializer.putQueryParam(fields, "pageSize", request.getPageSize());
                            serializer.putQueryParam(fields, "pageToken", request.getPageToken());
                            serializer.putQueryParam(fields, "$alt", "json;enum-encoding=int");
                            return fields;
                          })
                      .setRequestBodyExtractor(request -> null)
                      .build())
              .setResponseParser(
                  ProtoMessageResponseParser.<ListComponentsResponse>newBuilder()
                      .setDefaultInstance(ListComponentsResponse.getDefaultInstance())
                      .setDefaultTypeRegistry(typeRegistry)
                      .build())
              .build();

  private static final ApiMethodDescriptor<CreateComponentRequest, Component>
      createComponentMethodDescriptor =
          ApiMethodDescriptor.<CreateComponentRequest, Component>newBuilder()
              .setFullMethodName("google.cloud.designcenter.v1.DesignCenter/CreateComponent")
              .setHttpMethod("POST")
              .setType(ApiMethodDescriptor.MethodType.UNARY)
              .setRequestFormatter(
                  ProtoMessageRequestFormatter.<CreateComponentRequest>newBuilder()
                      .setPath(
                          "/v1/{parent=projects/*/locations/*/spaces/*/applicationTemplates/*}/components",
                          request -> {
                            Map<String, String> fields = new HashMap<>();
                            ProtoRestSerializer<CreateComponentRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putPathParam(fields, "parent", request.getParent());
                            return fields;
                          })
                      .setQueryParamsExtractor(
                          request -> {
                            Map<String, List<String>> fields = new HashMap<>();
                            ProtoRestSerializer<CreateComponentRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putQueryParam(
                                fields, "componentId", request.getComponentId());
                            serializer.putQueryParam(fields, "$alt", "json;enum-encoding=int");
                            return fields;
                          })
                      .setRequestBodyExtractor(
                          request ->
                              ProtoRestSerializer.create()
                                  .toBody("component", request.getComponent(), true))
                      .build())
              .setResponseParser(
                  ProtoMessageResponseParser.<Component>newBuilder()
                      .setDefaultInstance(Component.getDefaultInstance())
                      .setDefaultTypeRegistry(typeRegistry)
                      .build())
              .build();

  private static final ApiMethodDescriptor<UpdateComponentRequest, Component>
      updateComponentMethodDescriptor =
          ApiMethodDescriptor.<UpdateComponentRequest, Component>newBuilder()
              .setFullMethodName("google.cloud.designcenter.v1.DesignCenter/UpdateComponent")
              .setHttpMethod("PATCH")
              .setType(ApiMethodDescriptor.MethodType.UNARY)
              .setRequestFormatter(
                  ProtoMessageRequestFormatter.<UpdateComponentRequest>newBuilder()
                      .setPath(
                          "/v1/{component.name=projects/*/locations/*/spaces/*/applicationTemplates/*/components/*}",
                          request -> {
                            Map<String, String> fields = new HashMap<>();
                            ProtoRestSerializer<UpdateComponentRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putPathParam(
                                fields, "component.name", request.getComponent().getName());
                            return fields;
                          })
                      .setQueryParamsExtractor(
                          request -> {
                            Map<String, List<String>> fields = new HashMap<>();
                            ProtoRestSerializer<UpdateComponentRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putQueryParam(fields, "updateMask", request.getUpdateMask());
                            serializer.putQueryParam(fields, "$alt", "json;enum-encoding=int");
                            return fields;
                          })
                      .setRequestBodyExtractor(
                          request ->
                              ProtoRestSerializer.create()
                                  .toBody("component", request.getComponent(), true))
                      .build())
              .setResponseParser(
                  ProtoMessageResponseParser.<Component>newBuilder()
                      .setDefaultInstance(Component.getDefaultInstance())
                      .setDefaultTypeRegistry(typeRegistry)
                      .build())
              .build();

  private static final ApiMethodDescriptor<DeleteComponentRequest, Empty>
      deleteComponentMethodDescriptor =
          ApiMethodDescriptor.<DeleteComponentRequest, Empty>newBuilder()
              .setFullMethodName("google.cloud.designcenter.v1.DesignCenter/DeleteComponent")
              .setHttpMethod("DELETE")
              .setType(ApiMethodDescriptor.MethodType.UNARY)
              .setRequestFormatter(
                  ProtoMessageRequestFormatter.<DeleteComponentRequest>newBuilder()
                      .setPath(
                          "/v1/{name=projects/*/locations/*/spaces/*/applicationTemplates/*/components/*}",
                          request -> {
                            Map<String, String> fields = new HashMap<>();
                            ProtoRestSerializer<DeleteComponentRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putPathParam(fields, "name", request.getName());
                            return fields;
                          })
                      .setQueryParamsExtractor(
                          request -> {
                            Map<String, List<String>> fields = new HashMap<>();
                            ProtoRestSerializer<DeleteComponentRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putQueryParam(fields, "force", request.getForce());
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

  private static final ApiMethodDescriptor<GetConnectionRequest, Connection>
      getConnectionMethodDescriptor =
          ApiMethodDescriptor.<GetConnectionRequest, Connection>newBuilder()
              .setFullMethodName("google.cloud.designcenter.v1.DesignCenter/GetConnection")
              .setHttpMethod("GET")
              .setType(ApiMethodDescriptor.MethodType.UNARY)
              .setRequestFormatter(
                  ProtoMessageRequestFormatter.<GetConnectionRequest>newBuilder()
                      .setPath(
                          "/v1/{name=projects/*/locations/*/spaces/*/applicationTemplates/*/components/*/connections/*}",
                          request -> {
                            Map<String, String> fields = new HashMap<>();
                            ProtoRestSerializer<GetConnectionRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putPathParam(fields, "name", request.getName());
                            return fields;
                          })
                      .setQueryParamsExtractor(
                          request -> {
                            Map<String, List<String>> fields = new HashMap<>();
                            ProtoRestSerializer<GetConnectionRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putQueryParam(fields, "$alt", "json;enum-encoding=int");
                            return fields;
                          })
                      .setRequestBodyExtractor(request -> null)
                      .build())
              .setResponseParser(
                  ProtoMessageResponseParser.<Connection>newBuilder()
                      .setDefaultInstance(Connection.getDefaultInstance())
                      .setDefaultTypeRegistry(typeRegistry)
                      .build())
              .build();

  private static final ApiMethodDescriptor<ListConnectionsRequest, ListConnectionsResponse>
      listConnectionsMethodDescriptor =
          ApiMethodDescriptor.<ListConnectionsRequest, ListConnectionsResponse>newBuilder()
              .setFullMethodName("google.cloud.designcenter.v1.DesignCenter/ListConnections")
              .setHttpMethod("GET")
              .setType(ApiMethodDescriptor.MethodType.UNARY)
              .setRequestFormatter(
                  ProtoMessageRequestFormatter.<ListConnectionsRequest>newBuilder()
                      .setPath(
                          "/v1/{parent=projects/*/locations/*/spaces/*/applicationTemplates/*/components/*}/connections",
                          request -> {
                            Map<String, String> fields = new HashMap<>();
                            ProtoRestSerializer<ListConnectionsRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putPathParam(fields, "parent", request.getParent());
                            return fields;
                          })
                      .setQueryParamsExtractor(
                          request -> {
                            Map<String, List<String>> fields = new HashMap<>();
                            ProtoRestSerializer<ListConnectionsRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putQueryParam(fields, "filter", request.getFilter());
                            serializer.putQueryParam(fields, "orderBy", request.getOrderBy());
                            serializer.putQueryParam(fields, "pageSize", request.getPageSize());
                            serializer.putQueryParam(fields, "pageToken", request.getPageToken());
                            serializer.putQueryParam(fields, "$alt", "json;enum-encoding=int");
                            return fields;
                          })
                      .setRequestBodyExtractor(request -> null)
                      .build())
              .setResponseParser(
                  ProtoMessageResponseParser.<ListConnectionsResponse>newBuilder()
                      .setDefaultInstance(ListConnectionsResponse.getDefaultInstance())
                      .setDefaultTypeRegistry(typeRegistry)
                      .build())
              .build();

  private static final ApiMethodDescriptor<CreateConnectionRequest, Connection>
      createConnectionMethodDescriptor =
          ApiMethodDescriptor.<CreateConnectionRequest, Connection>newBuilder()
              .setFullMethodName("google.cloud.designcenter.v1.DesignCenter/CreateConnection")
              .setHttpMethod("POST")
              .setType(ApiMethodDescriptor.MethodType.UNARY)
              .setRequestFormatter(
                  ProtoMessageRequestFormatter.<CreateConnectionRequest>newBuilder()
                      .setPath(
                          "/v1/{parent=projects/*/locations/*/spaces/*/applicationTemplates/*/components/*}/connections",
                          request -> {
                            Map<String, String> fields = new HashMap<>();
                            ProtoRestSerializer<CreateConnectionRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putPathParam(fields, "parent", request.getParent());
                            return fields;
                          })
                      .setQueryParamsExtractor(
                          request -> {
                            Map<String, List<String>> fields = new HashMap<>();
                            ProtoRestSerializer<CreateConnectionRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putQueryParam(
                                fields, "connectionId", request.getConnectionId());
                            serializer.putQueryParam(fields, "$alt", "json;enum-encoding=int");
                            return fields;
                          })
                      .setRequestBodyExtractor(
                          request ->
                              ProtoRestSerializer.create()
                                  .toBody("connection", request.getConnection(), true))
                      .build())
              .setResponseParser(
                  ProtoMessageResponseParser.<Connection>newBuilder()
                      .setDefaultInstance(Connection.getDefaultInstance())
                      .setDefaultTypeRegistry(typeRegistry)
                      .build())
              .build();

  private static final ApiMethodDescriptor<UpdateConnectionRequest, Connection>
      updateConnectionMethodDescriptor =
          ApiMethodDescriptor.<UpdateConnectionRequest, Connection>newBuilder()
              .setFullMethodName("google.cloud.designcenter.v1.DesignCenter/UpdateConnection")
              .setHttpMethod("PATCH")
              .setType(ApiMethodDescriptor.MethodType.UNARY)
              .setRequestFormatter(
                  ProtoMessageRequestFormatter.<UpdateConnectionRequest>newBuilder()
                      .setPath(
                          "/v1/{connection.name=projects/*/locations/*/spaces/*/applicationTemplates/*/components/*/connections/*}",
                          request -> {
                            Map<String, String> fields = new HashMap<>();
                            ProtoRestSerializer<UpdateConnectionRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putPathParam(
                                fields, "connection.name", request.getConnection().getName());
                            return fields;
                          })
                      .setQueryParamsExtractor(
                          request -> {
                            Map<String, List<String>> fields = new HashMap<>();
                            ProtoRestSerializer<UpdateConnectionRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putQueryParam(fields, "updateMask", request.getUpdateMask());
                            serializer.putQueryParam(fields, "$alt", "json;enum-encoding=int");
                            return fields;
                          })
                      .setRequestBodyExtractor(
                          request ->
                              ProtoRestSerializer.create()
                                  .toBody("connection", request.getConnection(), true))
                      .build())
              .setResponseParser(
                  ProtoMessageResponseParser.<Connection>newBuilder()
                      .setDefaultInstance(Connection.getDefaultInstance())
                      .setDefaultTypeRegistry(typeRegistry)
                      .build())
              .build();

  private static final ApiMethodDescriptor<DeleteConnectionRequest, Empty>
      deleteConnectionMethodDescriptor =
          ApiMethodDescriptor.<DeleteConnectionRequest, Empty>newBuilder()
              .setFullMethodName("google.cloud.designcenter.v1.DesignCenter/DeleteConnection")
              .setHttpMethod("DELETE")
              .setType(ApiMethodDescriptor.MethodType.UNARY)
              .setRequestFormatter(
                  ProtoMessageRequestFormatter.<DeleteConnectionRequest>newBuilder()
                      .setPath(
                          "/v1/{name=projects/*/locations/*/spaces/*/applicationTemplates/*/components/*/connections/*}",
                          request -> {
                            Map<String, String> fields = new HashMap<>();
                            ProtoRestSerializer<DeleteConnectionRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putPathParam(fields, "name", request.getName());
                            return fields;
                          })
                      .setQueryParamsExtractor(
                          request -> {
                            Map<String, List<String>> fields = new HashMap<>();
                            ProtoRestSerializer<DeleteConnectionRequest> serializer =
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
          GetApplicationTemplateRevisionRequest, ApplicationTemplateRevision>
      getApplicationTemplateRevisionMethodDescriptor =
          ApiMethodDescriptor
              .<GetApplicationTemplateRevisionRequest, ApplicationTemplateRevision>newBuilder()
              .setFullMethodName(
                  "google.cloud.designcenter.v1.DesignCenter/GetApplicationTemplateRevision")
              .setHttpMethod("GET")
              .setType(ApiMethodDescriptor.MethodType.UNARY)
              .setRequestFormatter(
                  ProtoMessageRequestFormatter.<GetApplicationTemplateRevisionRequest>newBuilder()
                      .setPath(
                          "/v1/{name=projects/*/locations/*/spaces/*/applicationTemplates/*/revisions/*}",
                          request -> {
                            Map<String, String> fields = new HashMap<>();
                            ProtoRestSerializer<GetApplicationTemplateRevisionRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putPathParam(fields, "name", request.getName());
                            return fields;
                          })
                      .setQueryParamsExtractor(
                          request -> {
                            Map<String, List<String>> fields = new HashMap<>();
                            ProtoRestSerializer<GetApplicationTemplateRevisionRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putQueryParam(fields, "$alt", "json;enum-encoding=int");
                            return fields;
                          })
                      .setRequestBodyExtractor(request -> null)
                      .build())
              .setResponseParser(
                  ProtoMessageResponseParser.<ApplicationTemplateRevision>newBuilder()
                      .setDefaultInstance(ApplicationTemplateRevision.getDefaultInstance())
                      .setDefaultTypeRegistry(typeRegistry)
                      .build())
              .build();

  private static final ApiMethodDescriptor<
          ListApplicationTemplateRevisionsRequest, ListApplicationTemplateRevisionsResponse>
      listApplicationTemplateRevisionsMethodDescriptor =
          ApiMethodDescriptor
              .<ListApplicationTemplateRevisionsRequest, ListApplicationTemplateRevisionsResponse>
                  newBuilder()
              .setFullMethodName(
                  "google.cloud.designcenter.v1.DesignCenter/ListApplicationTemplateRevisions")
              .setHttpMethod("GET")
              .setType(ApiMethodDescriptor.MethodType.UNARY)
              .setRequestFormatter(
                  ProtoMessageRequestFormatter.<ListApplicationTemplateRevisionsRequest>newBuilder()
                      .setPath(
                          "/v1/{parent=projects/*/locations/*/spaces/*/applicationTemplates/*}/revisions",
                          request -> {
                            Map<String, String> fields = new HashMap<>();
                            ProtoRestSerializer<ListApplicationTemplateRevisionsRequest>
                                serializer = ProtoRestSerializer.create();
                            serializer.putPathParam(fields, "parent", request.getParent());
                            return fields;
                          })
                      .setQueryParamsExtractor(
                          request -> {
                            Map<String, List<String>> fields = new HashMap<>();
                            ProtoRestSerializer<ListApplicationTemplateRevisionsRequest>
                                serializer = ProtoRestSerializer.create();
                            serializer.putQueryParam(fields, "filter", request.getFilter());
                            serializer.putQueryParam(fields, "orderBy", request.getOrderBy());
                            serializer.putQueryParam(fields, "pageSize", request.getPageSize());
                            serializer.putQueryParam(fields, "pageToken", request.getPageToken());
                            serializer.putQueryParam(fields, "$alt", "json;enum-encoding=int");
                            return fields;
                          })
                      .setRequestBodyExtractor(request -> null)
                      .build())
              .setResponseParser(
                  ProtoMessageResponseParser.<ListApplicationTemplateRevisionsResponse>newBuilder()
                      .setDefaultInstance(
                          ListApplicationTemplateRevisionsResponse.getDefaultInstance())
                      .setDefaultTypeRegistry(typeRegistry)
                      .build())
              .build();

  private static final ApiMethodDescriptor<DeleteApplicationTemplateRevisionRequest, Empty>
      deleteApplicationTemplateRevisionMethodDescriptor =
          ApiMethodDescriptor.<DeleteApplicationTemplateRevisionRequest, Empty>newBuilder()
              .setFullMethodName(
                  "google.cloud.designcenter.v1.DesignCenter/DeleteApplicationTemplateRevision")
              .setHttpMethod("DELETE")
              .setType(ApiMethodDescriptor.MethodType.UNARY)
              .setRequestFormatter(
                  ProtoMessageRequestFormatter
                      .<DeleteApplicationTemplateRevisionRequest>newBuilder()
                      .setPath(
                          "/v1/{name=projects/*/locations/*/spaces/*/applicationTemplates/*/revisions/*}",
                          request -> {
                            Map<String, String> fields = new HashMap<>();
                            ProtoRestSerializer<DeleteApplicationTemplateRevisionRequest>
                                serializer = ProtoRestSerializer.create();
                            serializer.putPathParam(fields, "name", request.getName());
                            return fields;
                          })
                      .setQueryParamsExtractor(
                          request -> {
                            Map<String, List<String>> fields = new HashMap<>();
                            ProtoRestSerializer<DeleteApplicationTemplateRevisionRequest>
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

  private static final ApiMethodDescriptor<GetCatalogRequest, Catalog> getCatalogMethodDescriptor =
      ApiMethodDescriptor.<GetCatalogRequest, Catalog>newBuilder()
          .setFullMethodName("google.cloud.designcenter.v1.DesignCenter/GetCatalog")
          .setHttpMethod("GET")
          .setType(ApiMethodDescriptor.MethodType.UNARY)
          .setRequestFormatter(
              ProtoMessageRequestFormatter.<GetCatalogRequest>newBuilder()
                  .setPath(
                      "/v1/{name=projects/*/locations/*/spaces/*/catalogs/*}",
                      request -> {
                        Map<String, String> fields = new HashMap<>();
                        ProtoRestSerializer<GetCatalogRequest> serializer =
                            ProtoRestSerializer.create();
                        serializer.putPathParam(fields, "name", request.getName());
                        return fields;
                      })
                  .setQueryParamsExtractor(
                      request -> {
                        Map<String, List<String>> fields = new HashMap<>();
                        ProtoRestSerializer<GetCatalogRequest> serializer =
                            ProtoRestSerializer.create();
                        serializer.putQueryParam(fields, "$alt", "json;enum-encoding=int");
                        return fields;
                      })
                  .setRequestBodyExtractor(request -> null)
                  .build())
          .setResponseParser(
              ProtoMessageResponseParser.<Catalog>newBuilder()
                  .setDefaultInstance(Catalog.getDefaultInstance())
                  .setDefaultTypeRegistry(typeRegistry)
                  .build())
          .build();

  private static final ApiMethodDescriptor<ListCatalogsRequest, ListCatalogsResponse>
      listCatalogsMethodDescriptor =
          ApiMethodDescriptor.<ListCatalogsRequest, ListCatalogsResponse>newBuilder()
              .setFullMethodName("google.cloud.designcenter.v1.DesignCenter/ListCatalogs")
              .setHttpMethod("GET")
              .setType(ApiMethodDescriptor.MethodType.UNARY)
              .setRequestFormatter(
                  ProtoMessageRequestFormatter.<ListCatalogsRequest>newBuilder()
                      .setPath(
                          "/v1/{parent=projects/*/locations/*/spaces/*}/catalogs",
                          request -> {
                            Map<String, String> fields = new HashMap<>();
                            ProtoRestSerializer<ListCatalogsRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putPathParam(fields, "parent", request.getParent());
                            return fields;
                          })
                      .setQueryParamsExtractor(
                          request -> {
                            Map<String, List<String>> fields = new HashMap<>();
                            ProtoRestSerializer<ListCatalogsRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putQueryParam(fields, "filter", request.getFilter());
                            serializer.putQueryParam(fields, "orderBy", request.getOrderBy());
                            serializer.putQueryParam(fields, "pageSize", request.getPageSize());
                            serializer.putQueryParam(fields, "pageToken", request.getPageToken());
                            serializer.putQueryParam(fields, "$alt", "json;enum-encoding=int");
                            return fields;
                          })
                      .setRequestBodyExtractor(request -> null)
                      .build())
              .setResponseParser(
                  ProtoMessageResponseParser.<ListCatalogsResponse>newBuilder()
                      .setDefaultInstance(ListCatalogsResponse.getDefaultInstance())
                      .setDefaultTypeRegistry(typeRegistry)
                      .build())
              .build();

  private static final ApiMethodDescriptor<CreateCatalogRequest, Catalog>
      createCatalogMethodDescriptor =
          ApiMethodDescriptor.<CreateCatalogRequest, Catalog>newBuilder()
              .setFullMethodName("google.cloud.designcenter.v1.DesignCenter/CreateCatalog")
              .setHttpMethod("POST")
              .setType(ApiMethodDescriptor.MethodType.UNARY)
              .setRequestFormatter(
                  ProtoMessageRequestFormatter.<CreateCatalogRequest>newBuilder()
                      .setPath(
                          "/v1/{parent=projects/*/locations/*/spaces/*}/catalogs",
                          request -> {
                            Map<String, String> fields = new HashMap<>();
                            ProtoRestSerializer<CreateCatalogRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putPathParam(fields, "parent", request.getParent());
                            return fields;
                          })
                      .setQueryParamsExtractor(
                          request -> {
                            Map<String, List<String>> fields = new HashMap<>();
                            ProtoRestSerializer<CreateCatalogRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putQueryParam(fields, "catalogId", request.getCatalogId());
                            serializer.putQueryParam(fields, "$alt", "json;enum-encoding=int");
                            return fields;
                          })
                      .setRequestBodyExtractor(
                          request ->
                              ProtoRestSerializer.create()
                                  .toBody("catalog", request.getCatalog(), true))
                      .build())
              .setResponseParser(
                  ProtoMessageResponseParser.<Catalog>newBuilder()
                      .setDefaultInstance(Catalog.getDefaultInstance())
                      .setDefaultTypeRegistry(typeRegistry)
                      .build())
              .build();

  private static final ApiMethodDescriptor<UpdateCatalogRequest, Catalog>
      updateCatalogMethodDescriptor =
          ApiMethodDescriptor.<UpdateCatalogRequest, Catalog>newBuilder()
              .setFullMethodName("google.cloud.designcenter.v1.DesignCenter/UpdateCatalog")
              .setHttpMethod("PATCH")
              .setType(ApiMethodDescriptor.MethodType.UNARY)
              .setRequestFormatter(
                  ProtoMessageRequestFormatter.<UpdateCatalogRequest>newBuilder()
                      .setPath(
                          "/v1/{catalog.name=projects/*/locations/*/spaces/*/catalogs/*}",
                          request -> {
                            Map<String, String> fields = new HashMap<>();
                            ProtoRestSerializer<UpdateCatalogRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putPathParam(
                                fields, "catalog.name", request.getCatalog().getName());
                            return fields;
                          })
                      .setQueryParamsExtractor(
                          request -> {
                            Map<String, List<String>> fields = new HashMap<>();
                            ProtoRestSerializer<UpdateCatalogRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putQueryParam(fields, "updateMask", request.getUpdateMask());
                            serializer.putQueryParam(fields, "$alt", "json;enum-encoding=int");
                            return fields;
                          })
                      .setRequestBodyExtractor(
                          request ->
                              ProtoRestSerializer.create()
                                  .toBody("catalog", request.getCatalog(), true))
                      .build())
              .setResponseParser(
                  ProtoMessageResponseParser.<Catalog>newBuilder()
                      .setDefaultInstance(Catalog.getDefaultInstance())
                      .setDefaultTypeRegistry(typeRegistry)
                      .build())
              .build();

  private static final ApiMethodDescriptor<DeleteCatalogRequest, Operation>
      deleteCatalogMethodDescriptor =
          ApiMethodDescriptor.<DeleteCatalogRequest, Operation>newBuilder()
              .setFullMethodName("google.cloud.designcenter.v1.DesignCenter/DeleteCatalog")
              .setHttpMethod("DELETE")
              .setType(ApiMethodDescriptor.MethodType.UNARY)
              .setRequestFormatter(
                  ProtoMessageRequestFormatter.<DeleteCatalogRequest>newBuilder()
                      .setPath(
                          "/v1/{name=projects/*/locations/*/spaces/*/catalogs/*}",
                          request -> {
                            Map<String, String> fields = new HashMap<>();
                            ProtoRestSerializer<DeleteCatalogRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putPathParam(fields, "name", request.getName());
                            return fields;
                          })
                      .setQueryParamsExtractor(
                          request -> {
                            Map<String, List<String>> fields = new HashMap<>();
                            ProtoRestSerializer<DeleteCatalogRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putQueryParam(fields, "force", request.getForce());
                            serializer.putQueryParam(fields, "$alt", "json;enum-encoding=int");
                            return fields;
                          })
                      .setRequestBodyExtractor(request -> null)
                      .build())
              .setResponseParser(
                  ProtoMessageResponseParser.<Operation>newBuilder()
                      .setDefaultInstance(Operation.getDefaultInstance())
                      .setDefaultTypeRegistry(typeRegistry)
                      .build())
              .setOperationSnapshotFactory(
                  (DeleteCatalogRequest request, Operation response) ->
                      HttpJsonOperationSnapshot.create(response))
              .build();

  private static final ApiMethodDescriptor<CreateCatalogTemplateRequest, CatalogTemplate>
      createCatalogTemplateMethodDescriptor =
          ApiMethodDescriptor.<CreateCatalogTemplateRequest, CatalogTemplate>newBuilder()
              .setFullMethodName("google.cloud.designcenter.v1.DesignCenter/CreateCatalogTemplate")
              .setHttpMethod("POST")
              .setType(ApiMethodDescriptor.MethodType.UNARY)
              .setRequestFormatter(
                  ProtoMessageRequestFormatter.<CreateCatalogTemplateRequest>newBuilder()
                      .setPath(
                          "/v1/{parent=projects/*/locations/*/spaces/*/catalogs/*}/templates",
                          request -> {
                            Map<String, String> fields = new HashMap<>();
                            ProtoRestSerializer<CreateCatalogTemplateRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putPathParam(fields, "parent", request.getParent());
                            return fields;
                          })
                      .setQueryParamsExtractor(
                          request -> {
                            Map<String, List<String>> fields = new HashMap<>();
                            ProtoRestSerializer<CreateCatalogTemplateRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putQueryParam(
                                fields, "catalogTemplateId", request.getCatalogTemplateId());
                            serializer.putQueryParam(fields, "$alt", "json;enum-encoding=int");
                            return fields;
                          })
                      .setRequestBodyExtractor(
                          request ->
                              ProtoRestSerializer.create()
                                  .toBody("catalogTemplate", request.getCatalogTemplate(), true))
                      .build())
              .setResponseParser(
                  ProtoMessageResponseParser.<CatalogTemplate>newBuilder()
                      .setDefaultInstance(CatalogTemplate.getDefaultInstance())
                      .setDefaultTypeRegistry(typeRegistry)
                      .build())
              .build();

  private static final ApiMethodDescriptor<GetCatalogTemplateRequest, CatalogTemplate>
      getCatalogTemplateMethodDescriptor =
          ApiMethodDescriptor.<GetCatalogTemplateRequest, CatalogTemplate>newBuilder()
              .setFullMethodName("google.cloud.designcenter.v1.DesignCenter/GetCatalogTemplate")
              .setHttpMethod("GET")
              .setType(ApiMethodDescriptor.MethodType.UNARY)
              .setRequestFormatter(
                  ProtoMessageRequestFormatter.<GetCatalogTemplateRequest>newBuilder()
                      .setPath(
                          "/v1/{name=projects/*/locations/*/spaces/*/catalogs/*/templates/*}",
                          request -> {
                            Map<String, String> fields = new HashMap<>();
                            ProtoRestSerializer<GetCatalogTemplateRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putPathParam(fields, "name", request.getName());
                            return fields;
                          })
                      .setQueryParamsExtractor(
                          request -> {
                            Map<String, List<String>> fields = new HashMap<>();
                            ProtoRestSerializer<GetCatalogTemplateRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putQueryParam(fields, "$alt", "json;enum-encoding=int");
                            return fields;
                          })
                      .setRequestBodyExtractor(request -> null)
                      .build())
              .setResponseParser(
                  ProtoMessageResponseParser.<CatalogTemplate>newBuilder()
                      .setDefaultInstance(CatalogTemplate.getDefaultInstance())
                      .setDefaultTypeRegistry(typeRegistry)
                      .build())
              .build();

  private static final ApiMethodDescriptor<
          ListCatalogTemplatesRequest, ListCatalogTemplatesResponse>
      listCatalogTemplatesMethodDescriptor =
          ApiMethodDescriptor
              .<ListCatalogTemplatesRequest, ListCatalogTemplatesResponse>newBuilder()
              .setFullMethodName("google.cloud.designcenter.v1.DesignCenter/ListCatalogTemplates")
              .setHttpMethod("GET")
              .setType(ApiMethodDescriptor.MethodType.UNARY)
              .setRequestFormatter(
                  ProtoMessageRequestFormatter.<ListCatalogTemplatesRequest>newBuilder()
                      .setPath(
                          "/v1/{parent=projects/*/locations/*/spaces/*/catalogs/*}/templates",
                          request -> {
                            Map<String, String> fields = new HashMap<>();
                            ProtoRestSerializer<ListCatalogTemplatesRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putPathParam(fields, "parent", request.getParent());
                            return fields;
                          })
                      .setQueryParamsExtractor(
                          request -> {
                            Map<String, List<String>> fields = new HashMap<>();
                            ProtoRestSerializer<ListCatalogTemplatesRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putQueryParam(fields, "filter", request.getFilter());
                            serializer.putQueryParam(fields, "orderBy", request.getOrderBy());
                            serializer.putQueryParam(fields, "pageSize", request.getPageSize());
                            serializer.putQueryParam(fields, "pageToken", request.getPageToken());
                            serializer.putQueryParam(fields, "$alt", "json;enum-encoding=int");
                            return fields;
                          })
                      .setRequestBodyExtractor(request -> null)
                      .build())
              .setResponseParser(
                  ProtoMessageResponseParser.<ListCatalogTemplatesResponse>newBuilder()
                      .setDefaultInstance(ListCatalogTemplatesResponse.getDefaultInstance())
                      .setDefaultTypeRegistry(typeRegistry)
                      .build())
              .build();

  private static final ApiMethodDescriptor<UpdateCatalogTemplateRequest, CatalogTemplate>
      updateCatalogTemplateMethodDescriptor =
          ApiMethodDescriptor.<UpdateCatalogTemplateRequest, CatalogTemplate>newBuilder()
              .setFullMethodName("google.cloud.designcenter.v1.DesignCenter/UpdateCatalogTemplate")
              .setHttpMethod("PATCH")
              .setType(ApiMethodDescriptor.MethodType.UNARY)
              .setRequestFormatter(
                  ProtoMessageRequestFormatter.<UpdateCatalogTemplateRequest>newBuilder()
                      .setPath(
                          "/v1/{catalogTemplate.name=projects/*/locations/*/spaces/*/catalogs/*/templates/*}",
                          request -> {
                            Map<String, String> fields = new HashMap<>();
                            ProtoRestSerializer<UpdateCatalogTemplateRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putPathParam(
                                fields,
                                "catalogTemplate.name",
                                request.getCatalogTemplate().getName());
                            return fields;
                          })
                      .setQueryParamsExtractor(
                          request -> {
                            Map<String, List<String>> fields = new HashMap<>();
                            ProtoRestSerializer<UpdateCatalogTemplateRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putQueryParam(fields, "updateMask", request.getUpdateMask());
                            serializer.putQueryParam(fields, "$alt", "json;enum-encoding=int");
                            return fields;
                          })
                      .setRequestBodyExtractor(
                          request ->
                              ProtoRestSerializer.create()
                                  .toBody("catalogTemplate", request.getCatalogTemplate(), true))
                      .build())
              .setResponseParser(
                  ProtoMessageResponseParser.<CatalogTemplate>newBuilder()
                      .setDefaultInstance(CatalogTemplate.getDefaultInstance())
                      .setDefaultTypeRegistry(typeRegistry)
                      .build())
              .build();

  private static final ApiMethodDescriptor<DeleteCatalogTemplateRequest, Operation>
      deleteCatalogTemplateMethodDescriptor =
          ApiMethodDescriptor.<DeleteCatalogTemplateRequest, Operation>newBuilder()
              .setFullMethodName("google.cloud.designcenter.v1.DesignCenter/DeleteCatalogTemplate")
              .setHttpMethod("DELETE")
              .setType(ApiMethodDescriptor.MethodType.UNARY)
              .setRequestFormatter(
                  ProtoMessageRequestFormatter.<DeleteCatalogTemplateRequest>newBuilder()
                      .setPath(
                          "/v1/{name=projects/*/locations/*/spaces/*/catalogs/*/templates/*}",
                          request -> {
                            Map<String, String> fields = new HashMap<>();
                            ProtoRestSerializer<DeleteCatalogTemplateRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putPathParam(fields, "name", request.getName());
                            return fields;
                          })
                      .setQueryParamsExtractor(
                          request -> {
                            Map<String, List<String>> fields = new HashMap<>();
                            ProtoRestSerializer<DeleteCatalogTemplateRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putQueryParam(fields, "force", request.getForce());
                            serializer.putQueryParam(fields, "$alt", "json;enum-encoding=int");
                            return fields;
                          })
                      .setRequestBodyExtractor(request -> null)
                      .build())
              .setResponseParser(
                  ProtoMessageResponseParser.<Operation>newBuilder()
                      .setDefaultInstance(Operation.getDefaultInstance())
                      .setDefaultTypeRegistry(typeRegistry)
                      .build())
              .setOperationSnapshotFactory(
                  (DeleteCatalogTemplateRequest request, Operation response) ->
                      HttpJsonOperationSnapshot.create(response))
              .build();

  private static final ApiMethodDescriptor<CreateShareRequest, Operation>
      createShareMethodDescriptor =
          ApiMethodDescriptor.<CreateShareRequest, Operation>newBuilder()
              .setFullMethodName("google.cloud.designcenter.v1.DesignCenter/CreateShare")
              .setHttpMethod("POST")
              .setType(ApiMethodDescriptor.MethodType.UNARY)
              .setRequestFormatter(
                  ProtoMessageRequestFormatter.<CreateShareRequest>newBuilder()
                      .setPath(
                          "/v1/{parent=projects/*/locations/*/spaces/*/catalogs/*}/shares",
                          request -> {
                            Map<String, String> fields = new HashMap<>();
                            ProtoRestSerializer<CreateShareRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putPathParam(fields, "parent", request.getParent());
                            return fields;
                          })
                      .setQueryParamsExtractor(
                          request -> {
                            Map<String, List<String>> fields = new HashMap<>();
                            ProtoRestSerializer<CreateShareRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putQueryParam(fields, "shareId", request.getShareId());
                            serializer.putQueryParam(fields, "$alt", "json;enum-encoding=int");
                            return fields;
                          })
                      .setRequestBodyExtractor(
                          request ->
                              ProtoRestSerializer.create()
                                  .toBody("share", request.getShare(), true))
                      .build())
              .setResponseParser(
                  ProtoMessageResponseParser.<Operation>newBuilder()
                      .setDefaultInstance(Operation.getDefaultInstance())
                      .setDefaultTypeRegistry(typeRegistry)
                      .build())
              .setOperationSnapshotFactory(
                  (CreateShareRequest request, Operation response) ->
                      HttpJsonOperationSnapshot.create(response))
              .build();

  private static final ApiMethodDescriptor<ListSharesRequest, ListSharesResponse>
      listSharesMethodDescriptor =
          ApiMethodDescriptor.<ListSharesRequest, ListSharesResponse>newBuilder()
              .setFullMethodName("google.cloud.designcenter.v1.DesignCenter/ListShares")
              .setHttpMethod("GET")
              .setType(ApiMethodDescriptor.MethodType.UNARY)
              .setRequestFormatter(
                  ProtoMessageRequestFormatter.<ListSharesRequest>newBuilder()
                      .setPath(
                          "/v1/{parent=projects/*/locations/*/spaces/*/catalogs/*}/shares",
                          request -> {
                            Map<String, String> fields = new HashMap<>();
                            ProtoRestSerializer<ListSharesRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putPathParam(fields, "parent", request.getParent());
                            return fields;
                          })
                      .setQueryParamsExtractor(
                          request -> {
                            Map<String, List<String>> fields = new HashMap<>();
                            ProtoRestSerializer<ListSharesRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putQueryParam(fields, "orderBy", request.getOrderBy());
                            serializer.putQueryParam(fields, "pageSize", request.getPageSize());
                            serializer.putQueryParam(fields, "pageToken", request.getPageToken());
                            serializer.putQueryParam(fields, "$alt", "json;enum-encoding=int");
                            return fields;
                          })
                      .setRequestBodyExtractor(request -> null)
                      .build())
              .setResponseParser(
                  ProtoMessageResponseParser.<ListSharesResponse>newBuilder()
                      .setDefaultInstance(ListSharesResponse.getDefaultInstance())
                      .setDefaultTypeRegistry(typeRegistry)
                      .build())
              .build();

  private static final ApiMethodDescriptor<GetShareRequest, Share> getShareMethodDescriptor =
      ApiMethodDescriptor.<GetShareRequest, Share>newBuilder()
          .setFullMethodName("google.cloud.designcenter.v1.DesignCenter/GetShare")
          .setHttpMethod("GET")
          .setType(ApiMethodDescriptor.MethodType.UNARY)
          .setRequestFormatter(
              ProtoMessageRequestFormatter.<GetShareRequest>newBuilder()
                  .setPath(
                      "/v1/{name=projects/*/locations/*/spaces/*/catalogs/*/shares/*}",
                      request -> {
                        Map<String, String> fields = new HashMap<>();
                        ProtoRestSerializer<GetShareRequest> serializer =
                            ProtoRestSerializer.create();
                        serializer.putPathParam(fields, "name", request.getName());
                        return fields;
                      })
                  .setQueryParamsExtractor(
                      request -> {
                        Map<String, List<String>> fields = new HashMap<>();
                        ProtoRestSerializer<GetShareRequest> serializer =
                            ProtoRestSerializer.create();
                        serializer.putQueryParam(fields, "$alt", "json;enum-encoding=int");
                        return fields;
                      })
                  .setRequestBodyExtractor(request -> null)
                  .build())
          .setResponseParser(
              ProtoMessageResponseParser.<Share>newBuilder()
                  .setDefaultInstance(Share.getDefaultInstance())
                  .setDefaultTypeRegistry(typeRegistry)
                  .build())
          .build();

  private static final ApiMethodDescriptor<DeleteShareRequest, Operation>
      deleteShareMethodDescriptor =
          ApiMethodDescriptor.<DeleteShareRequest, Operation>newBuilder()
              .setFullMethodName("google.cloud.designcenter.v1.DesignCenter/DeleteShare")
              .setHttpMethod("DELETE")
              .setType(ApiMethodDescriptor.MethodType.UNARY)
              .setRequestFormatter(
                  ProtoMessageRequestFormatter.<DeleteShareRequest>newBuilder()
                      .setPath(
                          "/v1/{name=projects/*/locations/*/spaces/*/catalogs/*/shares/*}",
                          request -> {
                            Map<String, String> fields = new HashMap<>();
                            ProtoRestSerializer<DeleteShareRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putPathParam(fields, "name", request.getName());
                            return fields;
                          })
                      .setQueryParamsExtractor(
                          request -> {
                            Map<String, List<String>> fields = new HashMap<>();
                            ProtoRestSerializer<DeleteShareRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putQueryParam(fields, "$alt", "json;enum-encoding=int");
                            return fields;
                          })
                      .setRequestBodyExtractor(request -> null)
                      .build())
              .setResponseParser(
                  ProtoMessageResponseParser.<Operation>newBuilder()
                      .setDefaultInstance(Operation.getDefaultInstance())
                      .setDefaultTypeRegistry(typeRegistry)
                      .build())
              .setOperationSnapshotFactory(
                  (DeleteShareRequest request, Operation response) ->
                      HttpJsonOperationSnapshot.create(response))
              .build();

  private static final ApiMethodDescriptor<SyncShareRequest, Operation> syncShareMethodDescriptor =
      ApiMethodDescriptor.<SyncShareRequest, Operation>newBuilder()
          .setFullMethodName("google.cloud.designcenter.v1.DesignCenter/SyncShare")
          .setHttpMethod("POST")
          .setType(ApiMethodDescriptor.MethodType.UNARY)
          .setRequestFormatter(
              ProtoMessageRequestFormatter.<SyncShareRequest>newBuilder()
                  .setPath(
                      "/v1/{name=projects/*/locations/*/spaces/*/catalogs/*/shares/*}:sync",
                      request -> {
                        Map<String, String> fields = new HashMap<>();
                        ProtoRestSerializer<SyncShareRequest> serializer =
                            ProtoRestSerializer.create();
                        serializer.putPathParam(fields, "name", request.getName());
                        return fields;
                      })
                  .setQueryParamsExtractor(
                      request -> {
                        Map<String, List<String>> fields = new HashMap<>();
                        ProtoRestSerializer<SyncShareRequest> serializer =
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
              ProtoMessageResponseParser.<Operation>newBuilder()
                  .setDefaultInstance(Operation.getDefaultInstance())
                  .setDefaultTypeRegistry(typeRegistry)
                  .build())
          .setOperationSnapshotFactory(
              (SyncShareRequest request, Operation response) ->
                  HttpJsonOperationSnapshot.create(response))
          .build();

  private static final ApiMethodDescriptor<GetSharedTemplateRequest, SharedTemplate>
      getSharedTemplateMethodDescriptor =
          ApiMethodDescriptor.<GetSharedTemplateRequest, SharedTemplate>newBuilder()
              .setFullMethodName("google.cloud.designcenter.v1.DesignCenter/GetSharedTemplate")
              .setHttpMethod("GET")
              .setType(ApiMethodDescriptor.MethodType.UNARY)
              .setRequestFormatter(
                  ProtoMessageRequestFormatter.<GetSharedTemplateRequest>newBuilder()
                      .setPath(
                          "/v1/{name=projects/*/locations/*/spaces/*/sharedTemplates/*}",
                          request -> {
                            Map<String, String> fields = new HashMap<>();
                            ProtoRestSerializer<GetSharedTemplateRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putPathParam(fields, "name", request.getName());
                            return fields;
                          })
                      .setQueryParamsExtractor(
                          request -> {
                            Map<String, List<String>> fields = new HashMap<>();
                            ProtoRestSerializer<GetSharedTemplateRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putQueryParam(fields, "$alt", "json;enum-encoding=int");
                            return fields;
                          })
                      .setRequestBodyExtractor(request -> null)
                      .build())
              .setResponseParser(
                  ProtoMessageResponseParser.<SharedTemplate>newBuilder()
                      .setDefaultInstance(SharedTemplate.getDefaultInstance())
                      .setDefaultTypeRegistry(typeRegistry)
                      .build())
              .build();

  private static final ApiMethodDescriptor<ListSharedTemplatesRequest, ListSharedTemplatesResponse>
      listSharedTemplatesMethodDescriptor =
          ApiMethodDescriptor.<ListSharedTemplatesRequest, ListSharedTemplatesResponse>newBuilder()
              .setFullMethodName("google.cloud.designcenter.v1.DesignCenter/ListSharedTemplates")
              .setHttpMethod("GET")
              .setType(ApiMethodDescriptor.MethodType.UNARY)
              .setRequestFormatter(
                  ProtoMessageRequestFormatter.<ListSharedTemplatesRequest>newBuilder()
                      .setPath(
                          "/v1/{parent=projects/*/locations/*/spaces/*}/sharedTemplates",
                          request -> {
                            Map<String, String> fields = new HashMap<>();
                            ProtoRestSerializer<ListSharedTemplatesRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putPathParam(fields, "parent", request.getParent());
                            return fields;
                          })
                      .setQueryParamsExtractor(
                          request -> {
                            Map<String, List<String>> fields = new HashMap<>();
                            ProtoRestSerializer<ListSharedTemplatesRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putQueryParam(fields, "filter", request.getFilter());
                            serializer.putQueryParam(fields, "orderBy", request.getOrderBy());
                            serializer.putQueryParam(fields, "pageSize", request.getPageSize());
                            serializer.putQueryParam(fields, "pageToken", request.getPageToken());
                            serializer.putQueryParam(fields, "$alt", "json;enum-encoding=int");
                            return fields;
                          })
                      .setRequestBodyExtractor(request -> null)
                      .build())
              .setResponseParser(
                  ProtoMessageResponseParser.<ListSharedTemplatesResponse>newBuilder()
                      .setDefaultInstance(ListSharedTemplatesResponse.getDefaultInstance())
                      .setDefaultTypeRegistry(typeRegistry)
                      .build())
              .build();

  private static final ApiMethodDescriptor<GetSharedTemplateRevisionRequest, SharedTemplateRevision>
      getSharedTemplateRevisionMethodDescriptor =
          ApiMethodDescriptor.<GetSharedTemplateRevisionRequest, SharedTemplateRevision>newBuilder()
              .setFullMethodName(
                  "google.cloud.designcenter.v1.DesignCenter/GetSharedTemplateRevision")
              .setHttpMethod("GET")
              .setType(ApiMethodDescriptor.MethodType.UNARY)
              .setRequestFormatter(
                  ProtoMessageRequestFormatter.<GetSharedTemplateRevisionRequest>newBuilder()
                      .setPath(
                          "/v1/{name=projects/*/locations/*/spaces/*/sharedTemplates/*/revisions/*}",
                          request -> {
                            Map<String, String> fields = new HashMap<>();
                            ProtoRestSerializer<GetSharedTemplateRevisionRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putPathParam(fields, "name", request.getName());
                            return fields;
                          })
                      .setQueryParamsExtractor(
                          request -> {
                            Map<String, List<String>> fields = new HashMap<>();
                            ProtoRestSerializer<GetSharedTemplateRevisionRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putQueryParam(fields, "$alt", "json;enum-encoding=int");
                            return fields;
                          })
                      .setRequestBodyExtractor(request -> null)
                      .build())
              .setResponseParser(
                  ProtoMessageResponseParser.<SharedTemplateRevision>newBuilder()
                      .setDefaultInstance(SharedTemplateRevision.getDefaultInstance())
                      .setDefaultTypeRegistry(typeRegistry)
                      .build())
              .build();

  private static final ApiMethodDescriptor<
          ListSharedTemplateRevisionsRequest, ListSharedTemplateRevisionsResponse>
      listSharedTemplateRevisionsMethodDescriptor =
          ApiMethodDescriptor
              .<ListSharedTemplateRevisionsRequest, ListSharedTemplateRevisionsResponse>newBuilder()
              .setFullMethodName(
                  "google.cloud.designcenter.v1.DesignCenter/ListSharedTemplateRevisions")
              .setHttpMethod("GET")
              .setType(ApiMethodDescriptor.MethodType.UNARY)
              .setRequestFormatter(
                  ProtoMessageRequestFormatter.<ListSharedTemplateRevisionsRequest>newBuilder()
                      .setPath(
                          "/v1/{parent=projects/*/locations/*/spaces/*/sharedTemplates/*}/revisions",
                          request -> {
                            Map<String, String> fields = new HashMap<>();
                            ProtoRestSerializer<ListSharedTemplateRevisionsRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putPathParam(fields, "parent", request.getParent());
                            return fields;
                          })
                      .setQueryParamsExtractor(
                          request -> {
                            Map<String, List<String>> fields = new HashMap<>();
                            ProtoRestSerializer<ListSharedTemplateRevisionsRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putQueryParam(fields, "filter", request.getFilter());
                            serializer.putQueryParam(fields, "orderBy", request.getOrderBy());
                            serializer.putQueryParam(fields, "pageSize", request.getPageSize());
                            serializer.putQueryParam(fields, "pageToken", request.getPageToken());
                            serializer.putQueryParam(fields, "$alt", "json;enum-encoding=int");
                            return fields;
                          })
                      .setRequestBodyExtractor(request -> null)
                      .build())
              .setResponseParser(
                  ProtoMessageResponseParser.<ListSharedTemplateRevisionsResponse>newBuilder()
                      .setDefaultInstance(ListSharedTemplateRevisionsResponse.getDefaultInstance())
                      .setDefaultTypeRegistry(typeRegistry)
                      .build())
              .build();

  private static final ApiMethodDescriptor<CreateCatalogTemplateRevisionRequest, Operation>
      createCatalogTemplateRevisionMethodDescriptor =
          ApiMethodDescriptor.<CreateCatalogTemplateRevisionRequest, Operation>newBuilder()
              .setFullMethodName(
                  "google.cloud.designcenter.v1.DesignCenter/CreateCatalogTemplateRevision")
              .setHttpMethod("POST")
              .setType(ApiMethodDescriptor.MethodType.UNARY)
              .setRequestFormatter(
                  ProtoMessageRequestFormatter.<CreateCatalogTemplateRevisionRequest>newBuilder()
                      .setPath(
                          "/v1/{parent=projects/*/locations/*/spaces/*/catalogs/*/templates/*}/revisions",
                          request -> {
                            Map<String, String> fields = new HashMap<>();
                            ProtoRestSerializer<CreateCatalogTemplateRevisionRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putPathParam(fields, "parent", request.getParent());
                            return fields;
                          })
                      .setQueryParamsExtractor(
                          request -> {
                            Map<String, List<String>> fields = new HashMap<>();
                            ProtoRestSerializer<CreateCatalogTemplateRevisionRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putQueryParam(
                                fields,
                                "catalogTemplateRevisionId",
                                request.getCatalogTemplateRevisionId());
                            serializer.putQueryParam(fields, "$alt", "json;enum-encoding=int");
                            return fields;
                          })
                      .setRequestBodyExtractor(
                          request ->
                              ProtoRestSerializer.create()
                                  .toBody(
                                      "catalogTemplateRevision",
                                      request.getCatalogTemplateRevision(),
                                      true))
                      .build())
              .setResponseParser(
                  ProtoMessageResponseParser.<Operation>newBuilder()
                      .setDefaultInstance(Operation.getDefaultInstance())
                      .setDefaultTypeRegistry(typeRegistry)
                      .build())
              .setOperationSnapshotFactory(
                  (CreateCatalogTemplateRevisionRequest request, Operation response) ->
                      HttpJsonOperationSnapshot.create(response))
              .build();

  private static final ApiMethodDescriptor<
          GetCatalogTemplateRevisionRequest, CatalogTemplateRevision>
      getCatalogTemplateRevisionMethodDescriptor =
          ApiMethodDescriptor
              .<GetCatalogTemplateRevisionRequest, CatalogTemplateRevision>newBuilder()
              .setFullMethodName(
                  "google.cloud.designcenter.v1.DesignCenter/GetCatalogTemplateRevision")
              .setHttpMethod("GET")
              .setType(ApiMethodDescriptor.MethodType.UNARY)
              .setRequestFormatter(
                  ProtoMessageRequestFormatter.<GetCatalogTemplateRevisionRequest>newBuilder()
                      .setPath(
                          "/v1/{name=projects/*/locations/*/spaces/*/catalogs/*/templates/*/revisions/*}",
                          request -> {
                            Map<String, String> fields = new HashMap<>();
                            ProtoRestSerializer<GetCatalogTemplateRevisionRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putPathParam(fields, "name", request.getName());
                            return fields;
                          })
                      .setQueryParamsExtractor(
                          request -> {
                            Map<String, List<String>> fields = new HashMap<>();
                            ProtoRestSerializer<GetCatalogTemplateRevisionRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putQueryParam(fields, "$alt", "json;enum-encoding=int");
                            return fields;
                          })
                      .setRequestBodyExtractor(request -> null)
                      .build())
              .setResponseParser(
                  ProtoMessageResponseParser.<CatalogTemplateRevision>newBuilder()
                      .setDefaultInstance(CatalogTemplateRevision.getDefaultInstance())
                      .setDefaultTypeRegistry(typeRegistry)
                      .build())
              .build();

  private static final ApiMethodDescriptor<
          ListCatalogTemplateRevisionsRequest, ListCatalogTemplateRevisionsResponse>
      listCatalogTemplateRevisionsMethodDescriptor =
          ApiMethodDescriptor
              .<ListCatalogTemplateRevisionsRequest, ListCatalogTemplateRevisionsResponse>
                  newBuilder()
              .setFullMethodName(
                  "google.cloud.designcenter.v1.DesignCenter/ListCatalogTemplateRevisions")
              .setHttpMethod("GET")
              .setType(ApiMethodDescriptor.MethodType.UNARY)
              .setRequestFormatter(
                  ProtoMessageRequestFormatter.<ListCatalogTemplateRevisionsRequest>newBuilder()
                      .setPath(
                          "/v1/{parent=projects/*/locations/*/spaces/*/catalogs/*/templates/*}/revisions",
                          request -> {
                            Map<String, String> fields = new HashMap<>();
                            ProtoRestSerializer<ListCatalogTemplateRevisionsRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putPathParam(fields, "parent", request.getParent());
                            return fields;
                          })
                      .setQueryParamsExtractor(
                          request -> {
                            Map<String, List<String>> fields = new HashMap<>();
                            ProtoRestSerializer<ListCatalogTemplateRevisionsRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putQueryParam(fields, "filter", request.getFilter());
                            serializer.putQueryParam(fields, "orderBy", request.getOrderBy());
                            serializer.putQueryParam(fields, "pageSize", request.getPageSize());
                            serializer.putQueryParam(fields, "pageToken", request.getPageToken());
                            serializer.putQueryParam(fields, "$alt", "json;enum-encoding=int");
                            return fields;
                          })
                      .setRequestBodyExtractor(request -> null)
                      .build())
              .setResponseParser(
                  ProtoMessageResponseParser.<ListCatalogTemplateRevisionsResponse>newBuilder()
                      .setDefaultInstance(ListCatalogTemplateRevisionsResponse.getDefaultInstance())
                      .setDefaultTypeRegistry(typeRegistry)
                      .build())
              .build();

  private static final ApiMethodDescriptor<DeleteCatalogTemplateRevisionRequest, Operation>
      deleteCatalogTemplateRevisionMethodDescriptor =
          ApiMethodDescriptor.<DeleteCatalogTemplateRevisionRequest, Operation>newBuilder()
              .setFullMethodName(
                  "google.cloud.designcenter.v1.DesignCenter/DeleteCatalogTemplateRevision")
              .setHttpMethod("DELETE")
              .setType(ApiMethodDescriptor.MethodType.UNARY)
              .setRequestFormatter(
                  ProtoMessageRequestFormatter.<DeleteCatalogTemplateRevisionRequest>newBuilder()
                      .setPath(
                          "/v1/{name=projects/*/locations/*/spaces/*/catalogs/*/templates/*/revisions/*}",
                          request -> {
                            Map<String, String> fields = new HashMap<>();
                            ProtoRestSerializer<DeleteCatalogTemplateRevisionRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putPathParam(fields, "name", request.getName());
                            return fields;
                          })
                      .setQueryParamsExtractor(
                          request -> {
                            Map<String, List<String>> fields = new HashMap<>();
                            ProtoRestSerializer<DeleteCatalogTemplateRevisionRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putQueryParam(fields, "$alt", "json;enum-encoding=int");
                            return fields;
                          })
                      .setRequestBodyExtractor(request -> null)
                      .build())
              .setResponseParser(
                  ProtoMessageResponseParser.<Operation>newBuilder()
                      .setDefaultInstance(Operation.getDefaultInstance())
                      .setDefaultTypeRegistry(typeRegistry)
                      .build())
              .setOperationSnapshotFactory(
                  (DeleteCatalogTemplateRevisionRequest request, Operation response) ->
                      HttpJsonOperationSnapshot.create(response))
              .build();

  private static final ApiMethodDescriptor<CreateApplicationRequest, Application>
      createApplicationMethodDescriptor =
          ApiMethodDescriptor.<CreateApplicationRequest, Application>newBuilder()
              .setFullMethodName("google.cloud.designcenter.v1.DesignCenter/CreateApplication")
              .setHttpMethod("POST")
              .setType(ApiMethodDescriptor.MethodType.UNARY)
              .setRequestFormatter(
                  ProtoMessageRequestFormatter.<CreateApplicationRequest>newBuilder()
                      .setPath(
                          "/v1/{parent=projects/*/locations/*/spaces/*}/applications",
                          request -> {
                            Map<String, String> fields = new HashMap<>();
                            ProtoRestSerializer<CreateApplicationRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putPathParam(fields, "parent", request.getParent());
                            return fields;
                          })
                      .setQueryParamsExtractor(
                          request -> {
                            Map<String, List<String>> fields = new HashMap<>();
                            ProtoRestSerializer<CreateApplicationRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putQueryParam(
                                fields, "applicationId", request.getApplicationId());
                            serializer.putQueryParam(fields, "$alt", "json;enum-encoding=int");
                            return fields;
                          })
                      .setRequestBodyExtractor(
                          request ->
                              ProtoRestSerializer.create()
                                  .toBody("application", request.getApplication(), true))
                      .build())
              .setResponseParser(
                  ProtoMessageResponseParser.<Application>newBuilder()
                      .setDefaultInstance(Application.getDefaultInstance())
                      .setDefaultTypeRegistry(typeRegistry)
                      .build())
              .build();

  private static final ApiMethodDescriptor<GetApplicationRequest, Application>
      getApplicationMethodDescriptor =
          ApiMethodDescriptor.<GetApplicationRequest, Application>newBuilder()
              .setFullMethodName("google.cloud.designcenter.v1.DesignCenter/GetApplication")
              .setHttpMethod("GET")
              .setType(ApiMethodDescriptor.MethodType.UNARY)
              .setRequestFormatter(
                  ProtoMessageRequestFormatter.<GetApplicationRequest>newBuilder()
                      .setPath(
                          "/v1/{name=projects/*/locations/*/spaces/*/applications/*}",
                          request -> {
                            Map<String, String> fields = new HashMap<>();
                            ProtoRestSerializer<GetApplicationRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putPathParam(fields, "name", request.getName());
                            return fields;
                          })
                      .setQueryParamsExtractor(
                          request -> {
                            Map<String, List<String>> fields = new HashMap<>();
                            ProtoRestSerializer<GetApplicationRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putQueryParam(fields, "$alt", "json;enum-encoding=int");
                            return fields;
                          })
                      .setRequestBodyExtractor(request -> null)
                      .build())
              .setResponseParser(
                  ProtoMessageResponseParser.<Application>newBuilder()
                      .setDefaultInstance(Application.getDefaultInstance())
                      .setDefaultTypeRegistry(typeRegistry)
                      .build())
              .build();

  private static final ApiMethodDescriptor<ListApplicationsRequest, ListApplicationsResponse>
      listApplicationsMethodDescriptor =
          ApiMethodDescriptor.<ListApplicationsRequest, ListApplicationsResponse>newBuilder()
              .setFullMethodName("google.cloud.designcenter.v1.DesignCenter/ListApplications")
              .setHttpMethod("GET")
              .setType(ApiMethodDescriptor.MethodType.UNARY)
              .setRequestFormatter(
                  ProtoMessageRequestFormatter.<ListApplicationsRequest>newBuilder()
                      .setPath(
                          "/v1/{parent=projects/*/locations/*/spaces/*}/applications",
                          request -> {
                            Map<String, String> fields = new HashMap<>();
                            ProtoRestSerializer<ListApplicationsRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putPathParam(fields, "parent", request.getParent());
                            return fields;
                          })
                      .setQueryParamsExtractor(
                          request -> {
                            Map<String, List<String>> fields = new HashMap<>();
                            ProtoRestSerializer<ListApplicationsRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putQueryParam(fields, "filter", request.getFilter());
                            serializer.putQueryParam(fields, "orderBy", request.getOrderBy());
                            serializer.putQueryParam(fields, "pageSize", request.getPageSize());
                            serializer.putQueryParam(fields, "pageToken", request.getPageToken());
                            serializer.putQueryParam(fields, "$alt", "json;enum-encoding=int");
                            return fields;
                          })
                      .setRequestBodyExtractor(request -> null)
                      .build())
              .setResponseParser(
                  ProtoMessageResponseParser.<ListApplicationsResponse>newBuilder()
                      .setDefaultInstance(ListApplicationsResponse.getDefaultInstance())
                      .setDefaultTypeRegistry(typeRegistry)
                      .build())
              .build();

  private static final ApiMethodDescriptor<UpdateApplicationRequest, Application>
      updateApplicationMethodDescriptor =
          ApiMethodDescriptor.<UpdateApplicationRequest, Application>newBuilder()
              .setFullMethodName("google.cloud.designcenter.v1.DesignCenter/UpdateApplication")
              .setHttpMethod("PATCH")
              .setType(ApiMethodDescriptor.MethodType.UNARY)
              .setRequestFormatter(
                  ProtoMessageRequestFormatter.<UpdateApplicationRequest>newBuilder()
                      .setPath(
                          "/v1/{application.name=projects/*/locations/*/spaces/*/applications/*}",
                          request -> {
                            Map<String, String> fields = new HashMap<>();
                            ProtoRestSerializer<UpdateApplicationRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putPathParam(
                                fields, "application.name", request.getApplication().getName());
                            return fields;
                          })
                      .setQueryParamsExtractor(
                          request -> {
                            Map<String, List<String>> fields = new HashMap<>();
                            ProtoRestSerializer<UpdateApplicationRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putQueryParam(fields, "updateMask", request.getUpdateMask());
                            serializer.putQueryParam(fields, "$alt", "json;enum-encoding=int");
                            return fields;
                          })
                      .setRequestBodyExtractor(
                          request ->
                              ProtoRestSerializer.create()
                                  .toBody("application", request.getApplication(), true))
                      .build())
              .setResponseParser(
                  ProtoMessageResponseParser.<Application>newBuilder()
                      .setDefaultInstance(Application.getDefaultInstance())
                      .setDefaultTypeRegistry(typeRegistry)
                      .build())
              .build();

  private static final ApiMethodDescriptor<DeleteApplicationRequest, Operation>
      deleteApplicationMethodDescriptor =
          ApiMethodDescriptor.<DeleteApplicationRequest, Operation>newBuilder()
              .setFullMethodName("google.cloud.designcenter.v1.DesignCenter/DeleteApplication")
              .setHttpMethod("DELETE")
              .setType(ApiMethodDescriptor.MethodType.UNARY)
              .setRequestFormatter(
                  ProtoMessageRequestFormatter.<DeleteApplicationRequest>newBuilder()
                      .setPath(
                          "/v1/{name=projects/*/locations/*/spaces/*/applications/*}",
                          request -> {
                            Map<String, String> fields = new HashMap<>();
                            ProtoRestSerializer<DeleteApplicationRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putPathParam(fields, "name", request.getName());
                            return fields;
                          })
                      .setQueryParamsExtractor(
                          request -> {
                            Map<String, List<String>> fields = new HashMap<>();
                            ProtoRestSerializer<DeleteApplicationRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putQueryParam(fields, "force", request.getForce());
                            serializer.putQueryParam(fields, "$alt", "json;enum-encoding=int");
                            return fields;
                          })
                      .setRequestBodyExtractor(request -> null)
                      .build())
              .setResponseParser(
                  ProtoMessageResponseParser.<Operation>newBuilder()
                      .setDefaultInstance(Operation.getDefaultInstance())
                      .setDefaultTypeRegistry(typeRegistry)
                      .build())
              .setOperationSnapshotFactory(
                  (DeleteApplicationRequest request, Operation response) ->
                      HttpJsonOperationSnapshot.create(response))
              .build();

  private static final ApiMethodDescriptor<DeployApplicationRequest, Operation>
      deployApplicationMethodDescriptor =
          ApiMethodDescriptor.<DeployApplicationRequest, Operation>newBuilder()
              .setFullMethodName("google.cloud.designcenter.v1.DesignCenter/DeployApplication")
              .setHttpMethod("POST")
              .setType(ApiMethodDescriptor.MethodType.UNARY)
              .setRequestFormatter(
                  ProtoMessageRequestFormatter.<DeployApplicationRequest>newBuilder()
                      .setPath(
                          "/v1/{name=projects/*/locations/*/spaces/*/applications/*}:deploy",
                          request -> {
                            Map<String, String> fields = new HashMap<>();
                            ProtoRestSerializer<DeployApplicationRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putPathParam(fields, "name", request.getName());
                            return fields;
                          })
                      .setQueryParamsExtractor(
                          request -> {
                            Map<String, List<String>> fields = new HashMap<>();
                            ProtoRestSerializer<DeployApplicationRequest> serializer =
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
                  ProtoMessageResponseParser.<Operation>newBuilder()
                      .setDefaultInstance(Operation.getDefaultInstance())
                      .setDefaultTypeRegistry(typeRegistry)
                      .build())
              .setOperationSnapshotFactory(
                  (DeployApplicationRequest request, Operation response) ->
                      HttpJsonOperationSnapshot.create(response))
              .build();

  private static final ApiMethodDescriptor<PreviewApplicationRequest, Operation>
      previewApplicationMethodDescriptor =
          ApiMethodDescriptor.<PreviewApplicationRequest, Operation>newBuilder()
              .setFullMethodName("google.cloud.designcenter.v1.DesignCenter/PreviewApplication")
              .setHttpMethod("POST")
              .setType(ApiMethodDescriptor.MethodType.UNARY)
              .setRequestFormatter(
                  ProtoMessageRequestFormatter.<PreviewApplicationRequest>newBuilder()
                      .setPath(
                          "/v1/{name=projects/*/locations/*/spaces/*/applications/*}:preview",
                          request -> {
                            Map<String, String> fields = new HashMap<>();
                            ProtoRestSerializer<PreviewApplicationRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putPathParam(fields, "name", request.getName());
                            return fields;
                          })
                      .setQueryParamsExtractor(
                          request -> {
                            Map<String, List<String>> fields = new HashMap<>();
                            ProtoRestSerializer<PreviewApplicationRequest> serializer =
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
                  ProtoMessageResponseParser.<Operation>newBuilder()
                      .setDefaultInstance(Operation.getDefaultInstance())
                      .setDefaultTypeRegistry(typeRegistry)
                      .build())
              .setOperationSnapshotFactory(
                  (PreviewApplicationRequest request, Operation response) ->
                      HttpJsonOperationSnapshot.create(response))
              .build();

  private static final ApiMethodDescriptor<
          FetchApplicationAssessmentReportRequest, FetchApplicationAssessmentReportResponse>
      fetchApplicationAssessmentReportMethodDescriptor =
          ApiMethodDescriptor
              .<FetchApplicationAssessmentReportRequest, FetchApplicationAssessmentReportResponse>
                  newBuilder()
              .setFullMethodName(
                  "google.cloud.designcenter.v1.DesignCenter/FetchApplicationAssessmentReport")
              .setHttpMethod("GET")
              .setType(ApiMethodDescriptor.MethodType.UNARY)
              .setRequestFormatter(
                  ProtoMessageRequestFormatter.<FetchApplicationAssessmentReportRequest>newBuilder()
                      .setPath(
                          "/v1/{name=projects/*/locations/*/spaces/*/applications/*}:fetchAssessmentReport",
                          request -> {
                            Map<String, String> fields = new HashMap<>();
                            ProtoRestSerializer<FetchApplicationAssessmentReportRequest>
                                serializer = ProtoRestSerializer.create();
                            serializer.putPathParam(fields, "name", request.getName());
                            return fields;
                          })
                      .setQueryParamsExtractor(
                          request -> {
                            Map<String, List<String>> fields = new HashMap<>();
                            ProtoRestSerializer<FetchApplicationAssessmentReportRequest>
                                serializer = ProtoRestSerializer.create();
                            serializer.putQueryParam(fields, "$alt", "json;enum-encoding=int");
                            return fields;
                          })
                      .setRequestBodyExtractor(request -> null)
                      .build())
              .setResponseParser(
                  ProtoMessageResponseParser.<FetchApplicationAssessmentReportResponse>newBuilder()
                      .setDefaultInstance(
                          FetchApplicationAssessmentReportResponse.getDefaultInstance())
                      .setDefaultTypeRegistry(typeRegistry)
                      .build())
              .build();

  private static final ApiMethodDescriptor<GenerateApplicationAssessmentReportRequest, Operation>
      generateApplicationAssessmentReportMethodDescriptor =
          ApiMethodDescriptor.<GenerateApplicationAssessmentReportRequest, Operation>newBuilder()
              .setFullMethodName(
                  "google.cloud.designcenter.v1.DesignCenter/GenerateApplicationAssessmentReport")
              .setHttpMethod("POST")
              .setType(ApiMethodDescriptor.MethodType.UNARY)
              .setRequestFormatter(
                  ProtoMessageRequestFormatter
                      .<GenerateApplicationAssessmentReportRequest>newBuilder()
                      .setPath(
                          "/v1/{name=projects/*/locations/*/spaces/*/applications/*}:generateAssessmentReport",
                          request -> {
                            Map<String, String> fields = new HashMap<>();
                            ProtoRestSerializer<GenerateApplicationAssessmentReportRequest>
                                serializer = ProtoRestSerializer.create();
                            serializer.putPathParam(fields, "name", request.getName());
                            return fields;
                          })
                      .setQueryParamsExtractor(
                          request -> {
                            Map<String, List<String>> fields = new HashMap<>();
                            ProtoRestSerializer<GenerateApplicationAssessmentReportRequest>
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
                  ProtoMessageResponseParser.<Operation>newBuilder()
                      .setDefaultInstance(Operation.getDefaultInstance())
                      .setDefaultTypeRegistry(typeRegistry)
                      .build())
              .setOperationSnapshotFactory(
                  (GenerateApplicationAssessmentReportRequest request, Operation response) ->
                      HttpJsonOperationSnapshot.create(response))
              .build();

  private static final ApiMethodDescriptor<
          GenerateApplicationTemplateAssessmentReportRequest, Operation>
      generateApplicationTemplateAssessmentReportMethodDescriptor =
          ApiMethodDescriptor
              .<GenerateApplicationTemplateAssessmentReportRequest, Operation>newBuilder()
              .setFullMethodName(
                  "google.cloud.designcenter.v1.DesignCenter/GenerateApplicationTemplateAssessmentReport")
              .setHttpMethod("POST")
              .setType(ApiMethodDescriptor.MethodType.UNARY)
              .setRequestFormatter(
                  ProtoMessageRequestFormatter
                      .<GenerateApplicationTemplateAssessmentReportRequest>newBuilder()
                      .setPath(
                          "/v1/{name=projects/*/locations/*/spaces/*/applicationTemplates/*}:generateAssessmentReport",
                          request -> {
                            Map<String, String> fields = new HashMap<>();
                            ProtoRestSerializer<GenerateApplicationTemplateAssessmentReportRequest>
                                serializer = ProtoRestSerializer.create();
                            serializer.putPathParam(fields, "name", request.getName());
                            return fields;
                          })
                      .setQueryParamsExtractor(
                          request -> {
                            Map<String, List<String>> fields = new HashMap<>();
                            ProtoRestSerializer<GenerateApplicationTemplateAssessmentReportRequest>
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
                  ProtoMessageResponseParser.<Operation>newBuilder()
                      .setDefaultInstance(Operation.getDefaultInstance())
                      .setDefaultTypeRegistry(typeRegistry)
                      .build())
              .setOperationSnapshotFactory(
                  (GenerateApplicationTemplateAssessmentReportRequest request,
                      Operation response) -> HttpJsonOperationSnapshot.create(response))
              .build();

  private static final ApiMethodDescriptor<GenerateAssessmentReportRequest, Operation>
      generateAssessmentReportMethodDescriptor =
          ApiMethodDescriptor.<GenerateAssessmentReportRequest, Operation>newBuilder()
              .setFullMethodName(
                  "google.cloud.designcenter.v1.DesignCenter/GenerateAssessmentReport")
              .setHttpMethod("POST")
              .setType(ApiMethodDescriptor.MethodType.UNARY)
              .setRequestFormatter(
                  ProtoMessageRequestFormatter.<GenerateAssessmentReportRequest>newBuilder()
                      .setPath(
                          "/v1/{spaceName=projects/*/locations/*/spaces/*}:generateAssessmentReport",
                          request -> {
                            Map<String, String> fields = new HashMap<>();
                            ProtoRestSerializer<GenerateAssessmentReportRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putPathParam(fields, "spaceName", request.getSpaceName());
                            return fields;
                          })
                      .setQueryParamsExtractor(
                          request -> {
                            Map<String, List<String>> fields = new HashMap<>();
                            ProtoRestSerializer<GenerateAssessmentReportRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putQueryParam(fields, "$alt", "json;enum-encoding=int");
                            return fields;
                          })
                      .setRequestBodyExtractor(
                          request ->
                              ProtoRestSerializer.create()
                                  .toBody("*", request.toBuilder().clearSpaceName().build(), true))
                      .build())
              .setResponseParser(
                  ProtoMessageResponseParser.<Operation>newBuilder()
                      .setDefaultInstance(Operation.getDefaultInstance())
                      .setDefaultTypeRegistry(typeRegistry)
                      .build())
              .setOperationSnapshotFactory(
                  (GenerateAssessmentReportRequest request, Operation response) ->
                      HttpJsonOperationSnapshot.create(response))
              .build();

  private static final ApiMethodDescriptor<GenerateTerraformPlanAssessmentReportRequest, Operation>
      generateTerraformPlanAssessmentReportMethodDescriptor =
          ApiMethodDescriptor.<GenerateTerraformPlanAssessmentReportRequest, Operation>newBuilder()
              .setFullMethodName(
                  "google.cloud.designcenter.v1.DesignCenter/GenerateTerraformPlanAssessmentReport")
              .setHttpMethod("POST")
              .setType(ApiMethodDescriptor.MethodType.UNARY)
              .setRequestFormatter(
                  ProtoMessageRequestFormatter
                      .<GenerateTerraformPlanAssessmentReportRequest>newBuilder()
                      .setPath(
                          "/v1/{name=projects/*/locations/*/spaces/*}:generateTerraformPlanAssessmentReport",
                          request -> {
                            Map<String, String> fields = new HashMap<>();
                            ProtoRestSerializer<GenerateTerraformPlanAssessmentReportRequest>
                                serializer = ProtoRestSerializer.create();
                            serializer.putPathParam(fields, "name", request.getName());
                            return fields;
                          })
                      .setQueryParamsExtractor(
                          request -> {
                            Map<String, List<String>> fields = new HashMap<>();
                            ProtoRestSerializer<GenerateTerraformPlanAssessmentReportRequest>
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
                  ProtoMessageResponseParser.<Operation>newBuilder()
                      .setDefaultInstance(Operation.getDefaultInstance())
                      .setDefaultTypeRegistry(typeRegistry)
                      .build())
              .setOperationSnapshotFactory(
                  (GenerateTerraformPlanAssessmentReportRequest request, Operation response) ->
                      HttpJsonOperationSnapshot.create(response))
              .build();

  private static final ApiMethodDescriptor<GetPolicyRequest, Policy> getPolicyMethodDescriptor =
      ApiMethodDescriptor.<GetPolicyRequest, Policy>newBuilder()
          .setFullMethodName("google.cloud.designcenter.v1.DesignCenter/GetPolicy")
          .setHttpMethod("GET")
          .setType(ApiMethodDescriptor.MethodType.UNARY)
          .setRequestFormatter(
              ProtoMessageRequestFormatter.<GetPolicyRequest>newBuilder()
                  .setPath(
                      "/v1/{name=projects/*/locations/*/spaces/*/applicationTemplates/*/policies/*}",
                      request -> {
                        Map<String, String> fields = new HashMap<>();
                        ProtoRestSerializer<GetPolicyRequest> serializer =
                            ProtoRestSerializer.create();
                        serializer.putPathParam(fields, "name", request.getName());
                        return fields;
                      })
                  .setQueryParamsExtractor(
                      request -> {
                        Map<String, List<String>> fields = new HashMap<>();
                        ProtoRestSerializer<GetPolicyRequest> serializer =
                            ProtoRestSerializer.create();
                        serializer.putQueryParam(fields, "$alt", "json;enum-encoding=int");
                        return fields;
                      })
                  .setRequestBodyExtractor(request -> null)
                  .build())
          .setResponseParser(
              ProtoMessageResponseParser.<Policy>newBuilder()
                  .setDefaultInstance(Policy.getDefaultInstance())
                  .setDefaultTypeRegistry(typeRegistry)
                  .build())
          .build();

  private static final ApiMethodDescriptor<ListPoliciesRequest, ListPoliciesResponse>
      listPoliciesMethodDescriptor =
          ApiMethodDescriptor.<ListPoliciesRequest, ListPoliciesResponse>newBuilder()
              .setFullMethodName("google.cloud.designcenter.v1.DesignCenter/ListPolicies")
              .setHttpMethod("GET")
              .setType(ApiMethodDescriptor.MethodType.UNARY)
              .setRequestFormatter(
                  ProtoMessageRequestFormatter.<ListPoliciesRequest>newBuilder()
                      .setPath(
                          "/v1/{parent=projects/*/locations/*/spaces/*/applicationTemplates/*}/policies",
                          request -> {
                            Map<String, String> fields = new HashMap<>();
                            ProtoRestSerializer<ListPoliciesRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putPathParam(fields, "parent", request.getParent());
                            return fields;
                          })
                      .setQueryParamsExtractor(
                          request -> {
                            Map<String, List<String>> fields = new HashMap<>();
                            ProtoRestSerializer<ListPoliciesRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putQueryParam(fields, "filter", request.getFilter());
                            serializer.putQueryParam(fields, "orderBy", request.getOrderBy());
                            serializer.putQueryParam(fields, "pageSize", request.getPageSize());
                            serializer.putQueryParam(fields, "pageToken", request.getPageToken());
                            serializer.putQueryParam(fields, "$alt", "json;enum-encoding=int");
                            return fields;
                          })
                      .setRequestBodyExtractor(request -> null)
                      .build())
              .setResponseParser(
                  ProtoMessageResponseParser.<ListPoliciesResponse>newBuilder()
                      .setDefaultInstance(ListPoliciesResponse.getDefaultInstance())
                      .setDefaultTypeRegistry(typeRegistry)
                      .build())
              .build();

  private static final ApiMethodDescriptor<CreatePolicyRequest, Policy>
      createPolicyMethodDescriptor =
          ApiMethodDescriptor.<CreatePolicyRequest, Policy>newBuilder()
              .setFullMethodName("google.cloud.designcenter.v1.DesignCenter/CreatePolicy")
              .setHttpMethod("POST")
              .setType(ApiMethodDescriptor.MethodType.UNARY)
              .setRequestFormatter(
                  ProtoMessageRequestFormatter.<CreatePolicyRequest>newBuilder()
                      .setPath(
                          "/v1/{parent=projects/*/locations/*/spaces/*/applicationTemplates/*}/policies",
                          request -> {
                            Map<String, String> fields = new HashMap<>();
                            ProtoRestSerializer<CreatePolicyRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putPathParam(fields, "parent", request.getParent());
                            return fields;
                          })
                      .setQueryParamsExtractor(
                          request -> {
                            Map<String, List<String>> fields = new HashMap<>();
                            ProtoRestSerializer<CreatePolicyRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putQueryParam(fields, "policyId", request.getPolicyId());
                            serializer.putQueryParam(fields, "$alt", "json;enum-encoding=int");
                            return fields;
                          })
                      .setRequestBodyExtractor(
                          request ->
                              ProtoRestSerializer.create()
                                  .toBody("policy", request.getPolicy(), true))
                      .build())
              .setResponseParser(
                  ProtoMessageResponseParser.<Policy>newBuilder()
                      .setDefaultInstance(Policy.getDefaultInstance())
                      .setDefaultTypeRegistry(typeRegistry)
                      .build())
              .build();

  private static final ApiMethodDescriptor<UpdatePolicyRequest, Policy>
      updatePolicyMethodDescriptor =
          ApiMethodDescriptor.<UpdatePolicyRequest, Policy>newBuilder()
              .setFullMethodName("google.cloud.designcenter.v1.DesignCenter/UpdatePolicy")
              .setHttpMethod("PATCH")
              .setType(ApiMethodDescriptor.MethodType.UNARY)
              .setRequestFormatter(
                  ProtoMessageRequestFormatter.<UpdatePolicyRequest>newBuilder()
                      .setPath(
                          "/v1/{policy.name=projects/*/locations/*/spaces/*/applicationTemplates/*/policies/*}",
                          request -> {
                            Map<String, String> fields = new HashMap<>();
                            ProtoRestSerializer<UpdatePolicyRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putPathParam(
                                fields, "policy.name", request.getPolicy().getName());
                            return fields;
                          })
                      .setQueryParamsExtractor(
                          request -> {
                            Map<String, List<String>> fields = new HashMap<>();
                            ProtoRestSerializer<UpdatePolicyRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putQueryParam(fields, "updateMask", request.getUpdateMask());
                            serializer.putQueryParam(fields, "$alt", "json;enum-encoding=int");
                            return fields;
                          })
                      .setRequestBodyExtractor(
                          request ->
                              ProtoRestSerializer.create()
                                  .toBody("policy", request.getPolicy(), true))
                      .build())
              .setResponseParser(
                  ProtoMessageResponseParser.<Policy>newBuilder()
                      .setDefaultInstance(Policy.getDefaultInstance())
                      .setDefaultTypeRegistry(typeRegistry)
                      .build())
              .build();

  private static final ApiMethodDescriptor<DeletePolicyRequest, Empty>
      deletePolicyMethodDescriptor =
          ApiMethodDescriptor.<DeletePolicyRequest, Empty>newBuilder()
              .setFullMethodName("google.cloud.designcenter.v1.DesignCenter/DeletePolicy")
              .setHttpMethod("DELETE")
              .setType(ApiMethodDescriptor.MethodType.UNARY)
              .setRequestFormatter(
                  ProtoMessageRequestFormatter.<DeletePolicyRequest>newBuilder()
                      .setPath(
                          "/v1/{name=projects/*/locations/*/spaces/*/applicationTemplates/*/policies/*}",
                          request -> {
                            Map<String, String> fields = new HashMap<>();
                            ProtoRestSerializer<DeletePolicyRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putPathParam(fields, "name", request.getName());
                            return fields;
                          })
                      .setQueryParamsExtractor(
                          request -> {
                            Map<String, List<String>> fields = new HashMap<>();
                            ProtoRestSerializer<DeletePolicyRequest> serializer =
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

  private static final ApiMethodDescriptor<FetchFrameworksRequest, FetchFrameworksResponse>
      fetchFrameworksMethodDescriptor =
          ApiMethodDescriptor.<FetchFrameworksRequest, FetchFrameworksResponse>newBuilder()
              .setFullMethodName("google.cloud.designcenter.v1.DesignCenter/FetchFrameworks")
              .setHttpMethod("GET")
              .setType(ApiMethodDescriptor.MethodType.UNARY)
              .setRequestFormatter(
                  ProtoMessageRequestFormatter.<FetchFrameworksRequest>newBuilder()
                      .setPath(
                          "/v1/{parent=projects/*/locations/*}:fetchFrameworks",
                          request -> {
                            Map<String, String> fields = new HashMap<>();
                            ProtoRestSerializer<FetchFrameworksRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putPathParam(fields, "parent", request.getParent());
                            return fields;
                          })
                      .setQueryParamsExtractor(
                          request -> {
                            Map<String, List<String>> fields = new HashMap<>();
                            ProtoRestSerializer<FetchFrameworksRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putQueryParam(fields, "filter", request.getFilter());
                            serializer.putQueryParam(fields, "pageSize", request.getPageSize());
                            serializer.putQueryParam(fields, "pageToken", request.getPageToken());
                            serializer.putQueryParam(fields, "projects", request.getProjectsList());
                            serializer.putQueryParam(fields, "$alt", "json;enum-encoding=int");
                            return fields;
                          })
                      .setRequestBodyExtractor(request -> null)
                      .build())
              .setResponseParser(
                  ProtoMessageResponseParser.<FetchFrameworksResponse>newBuilder()
                      .setDefaultInstance(FetchFrameworksResponse.getDefaultInstance())
                      .setDefaultTypeRegistry(typeRegistry)
                      .build())
              .build();

  private static final ApiMethodDescriptor<
          GenerateApplicationIaCRequest, GenerateApplicationIaCResponse>
      generateApplicationIaCMethodDescriptor =
          ApiMethodDescriptor
              .<GenerateApplicationIaCRequest, GenerateApplicationIaCResponse>newBuilder()
              .setFullMethodName("google.cloud.designcenter.v1.DesignCenter/GenerateApplicationIaC")
              .setHttpMethod("POST")
              .setType(ApiMethodDescriptor.MethodType.UNARY)
              .setRequestFormatter(
                  ProtoMessageRequestFormatter.<GenerateApplicationIaCRequest>newBuilder()
                      .setPath(
                          "/v1/{name=projects/*/locations/*/spaces/*/applications/*}:generate",
                          request -> {
                            Map<String, String> fields = new HashMap<>();
                            ProtoRestSerializer<GenerateApplicationIaCRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putPathParam(fields, "name", request.getName());
                            return fields;
                          })
                      .setQueryParamsExtractor(
                          request -> {
                            Map<String, List<String>> fields = new HashMap<>();
                            ProtoRestSerializer<GenerateApplicationIaCRequest> serializer =
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
                  ProtoMessageResponseParser.<GenerateApplicationIaCResponse>newBuilder()
                      .setDefaultInstance(GenerateApplicationIaCResponse.getDefaultInstance())
                      .setDefaultTypeRegistry(typeRegistry)
                      .build())
              .build();

  private static final ApiMethodDescriptor<ExportApplicationIaCRequest, Operation>
      exportApplicationIaCMethodDescriptor =
          ApiMethodDescriptor.<ExportApplicationIaCRequest, Operation>newBuilder()
              .setFullMethodName("google.cloud.designcenter.v1.DesignCenter/ExportApplicationIaC")
              .setHttpMethod("POST")
              .setType(ApiMethodDescriptor.MethodType.UNARY)
              .setRequestFormatter(
                  ProtoMessageRequestFormatter.<ExportApplicationIaCRequest>newBuilder()
                      .setPath(
                          "/v1/{name=projects/*/locations/*/spaces/*/applications/*}:export",
                          request -> {
                            Map<String, String> fields = new HashMap<>();
                            ProtoRestSerializer<ExportApplicationIaCRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putPathParam(fields, "name", request.getName());
                            return fields;
                          })
                      .setQueryParamsExtractor(
                          request -> {
                            Map<String, List<String>> fields = new HashMap<>();
                            ProtoRestSerializer<ExportApplicationIaCRequest> serializer =
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
                  ProtoMessageResponseParser.<Operation>newBuilder()
                      .setDefaultInstance(Operation.getDefaultInstance())
                      .setDefaultTypeRegistry(typeRegistry)
                      .build())
              .setOperationSnapshotFactory(
                  (ExportApplicationIaCRequest request, Operation response) ->
                      HttpJsonOperationSnapshot.create(response))
              .build();

  private static final ApiMethodDescriptor<
          ImportApplicationTemplateIaCRequest, ImportApplicationTemplateIaCResponse>
      importApplicationTemplateIaCMethodDescriptor =
          ApiMethodDescriptor
              .<ImportApplicationTemplateIaCRequest, ImportApplicationTemplateIaCResponse>
                  newBuilder()
              .setFullMethodName(
                  "google.cloud.designcenter.v1.DesignCenter/ImportApplicationTemplateIaC")
              .setHttpMethod("POST")
              .setType(ApiMethodDescriptor.MethodType.UNARY)
              .setRequestFormatter(
                  ProtoMessageRequestFormatter.<ImportApplicationTemplateIaCRequest>newBuilder()
                      .setPath(
                          "/v1/{name=projects/*/locations/*/spaces/*/applicationTemplates/*}:importIaC",
                          request -> {
                            Map<String, String> fields = new HashMap<>();
                            ProtoRestSerializer<ImportApplicationTemplateIaCRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putPathParam(fields, "name", request.getName());
                            return fields;
                          })
                      .setQueryParamsExtractor(
                          request -> {
                            Map<String, List<String>> fields = new HashMap<>();
                            ProtoRestSerializer<ImportApplicationTemplateIaCRequest> serializer =
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
                  ProtoMessageResponseParser.<ImportApplicationTemplateIaCResponse>newBuilder()
                      .setDefaultInstance(ImportApplicationTemplateIaCResponse.getDefaultInstance())
                      .setDefaultTypeRegistry(typeRegistry)
                      .build())
              .build();

  private static final ApiMethodDescriptor<IngestApplicationTemplateIaCRequest, Operation>
      ingestApplicationTemplateIaCMethodDescriptor =
          ApiMethodDescriptor.<IngestApplicationTemplateIaCRequest, Operation>newBuilder()
              .setFullMethodName(
                  "google.cloud.designcenter.v1.DesignCenter/IngestApplicationTemplateIaC")
              .setHttpMethod("POST")
              .setType(ApiMethodDescriptor.MethodType.UNARY)
              .setRequestFormatter(
                  ProtoMessageRequestFormatter.<IngestApplicationTemplateIaCRequest>newBuilder()
                      .setPath(
                          "/v1/{name=projects/*/locations/*/spaces/*/applicationTemplates/*}:ingestIaC",
                          request -> {
                            Map<String, String> fields = new HashMap<>();
                            ProtoRestSerializer<IngestApplicationTemplateIaCRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putPathParam(fields, "name", request.getName());
                            return fields;
                          })
                      .setQueryParamsExtractor(
                          request -> {
                            Map<String, List<String>> fields = new HashMap<>();
                            ProtoRestSerializer<IngestApplicationTemplateIaCRequest> serializer =
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
                  ProtoMessageResponseParser.<Operation>newBuilder()
                      .setDefaultInstance(Operation.getDefaultInstance())
                      .setDefaultTypeRegistry(typeRegistry)
                      .build())
              .setOperationSnapshotFactory(
                  (IngestApplicationTemplateIaCRequest request, Operation response) ->
                      HttpJsonOperationSnapshot.create(response))
              .build();

  private static final ApiMethodDescriptor<
          ImportApplicationIaCRequest, ImportApplicationIaCResponse>
      importApplicationIaCMethodDescriptor =
          ApiMethodDescriptor
              .<ImportApplicationIaCRequest, ImportApplicationIaCResponse>newBuilder()
              .setFullMethodName("google.cloud.designcenter.v1.DesignCenter/ImportApplicationIaC")
              .setHttpMethod("POST")
              .setType(ApiMethodDescriptor.MethodType.UNARY)
              .setRequestFormatter(
                  ProtoMessageRequestFormatter.<ImportApplicationIaCRequest>newBuilder()
                      .setPath(
                          "/v1/{name=projects/*/locations/*/spaces/*/applications/*}:importIaC",
                          request -> {
                            Map<String, String> fields = new HashMap<>();
                            ProtoRestSerializer<ImportApplicationIaCRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putPathParam(fields, "name", request.getName());
                            return fields;
                          })
                      .setQueryParamsExtractor(
                          request -> {
                            Map<String, List<String>> fields = new HashMap<>();
                            ProtoRestSerializer<ImportApplicationIaCRequest> serializer =
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
                  ProtoMessageResponseParser.<ImportApplicationIaCResponse>newBuilder()
                      .setDefaultInstance(ImportApplicationIaCResponse.getDefaultInstance())
                      .setDefaultTypeRegistry(typeRegistry)
                      .build())
              .build();

  private static final ApiMethodDescriptor<RegisterAppHubApplicationResourcesRequest, Operation>
      registerAppHubApplicationResourcesMethodDescriptor =
          ApiMethodDescriptor.<RegisterAppHubApplicationResourcesRequest, Operation>newBuilder()
              .setFullMethodName(
                  "google.cloud.designcenter.v1.DesignCenter/RegisterAppHubApplicationResources")
              .setHttpMethod("POST")
              .setType(ApiMethodDescriptor.MethodType.UNARY)
              .setRequestFormatter(
                  ProtoMessageRequestFormatter
                      .<RegisterAppHubApplicationResourcesRequest>newBuilder()
                      .setPath(
                          "/v1/{parent=projects/*/locations/*}/spaces:registerAppHubApplicationResources",
                          request -> {
                            Map<String, String> fields = new HashMap<>();
                            ProtoRestSerializer<RegisterAppHubApplicationResourcesRequest>
                                serializer = ProtoRestSerializer.create();
                            serializer.putPathParam(fields, "parent", request.getParent());
                            return fields;
                          })
                      .setQueryParamsExtractor(
                          request -> {
                            Map<String, List<String>> fields = new HashMap<>();
                            ProtoRestSerializer<RegisterAppHubApplicationResourcesRequest>
                                serializer = ProtoRestSerializer.create();
                            serializer.putQueryParam(fields, "$alt", "json;enum-encoding=int");
                            return fields;
                          })
                      .setRequestBodyExtractor(
                          request ->
                              ProtoRestSerializer.create()
                                  .toBody("*", request.toBuilder().clearParent().build(), true))
                      .build())
              .setResponseParser(
                  ProtoMessageResponseParser.<Operation>newBuilder()
                      .setDefaultInstance(Operation.getDefaultInstance())
                      .setDefaultTypeRegistry(typeRegistry)
                      .build())
              .setOperationSnapshotFactory(
                  (RegisterAppHubApplicationResourcesRequest request, Operation response) ->
                      HttpJsonOperationSnapshot.create(response))
              .build();

  private static final ApiMethodDescriptor<
          ListApplicationTemplateSystemRevisionsRequest,
          ListApplicationTemplateSystemRevisionsResponse>
      listApplicationTemplateSystemRevisionsMethodDescriptor =
          ApiMethodDescriptor
              .<ListApplicationTemplateSystemRevisionsRequest,
                  ListApplicationTemplateSystemRevisionsResponse>
                  newBuilder()
              .setFullMethodName(
                  "google.cloud.designcenter.v1.DesignCenter/ListApplicationTemplateSystemRevisions")
              .setHttpMethod("GET")
              .setType(ApiMethodDescriptor.MethodType.UNARY)
              .setRequestFormatter(
                  ProtoMessageRequestFormatter
                      .<ListApplicationTemplateSystemRevisionsRequest>newBuilder()
                      .setPath(
                          "/v1/{parent=projects/*/locations/*/spaces/*/applicationTemplates/*}/systemRevisions",
                          request -> {
                            Map<String, String> fields = new HashMap<>();
                            ProtoRestSerializer<ListApplicationTemplateSystemRevisionsRequest>
                                serializer = ProtoRestSerializer.create();
                            serializer.putPathParam(fields, "parent", request.getParent());
                            return fields;
                          })
                      .setQueryParamsExtractor(
                          request -> {
                            Map<String, List<String>> fields = new HashMap<>();
                            ProtoRestSerializer<ListApplicationTemplateSystemRevisionsRequest>
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
                      .<ListApplicationTemplateSystemRevisionsResponse>newBuilder()
                      .setDefaultInstance(
                          ListApplicationTemplateSystemRevisionsResponse.getDefaultInstance())
                      .setDefaultTypeRegistry(typeRegistry)
                      .build())
              .build();

  private static final ApiMethodDescriptor<
          GetApplicationTemplateSystemRevisionRequest, ApplicationTemplateSystemRevision>
      getApplicationTemplateSystemRevisionMethodDescriptor =
          ApiMethodDescriptor
              .<GetApplicationTemplateSystemRevisionRequest, ApplicationTemplateSystemRevision>
                  newBuilder()
              .setFullMethodName(
                  "google.cloud.designcenter.v1.DesignCenter/GetApplicationTemplateSystemRevision")
              .setHttpMethod("GET")
              .setType(ApiMethodDescriptor.MethodType.UNARY)
              .setRequestFormatter(
                  ProtoMessageRequestFormatter
                      .<GetApplicationTemplateSystemRevisionRequest>newBuilder()
                      .setPath(
                          "/v1/{name=projects/*/locations/*/spaces/*/applicationTemplates/*/systemRevisions/*}",
                          request -> {
                            Map<String, String> fields = new HashMap<>();
                            ProtoRestSerializer<GetApplicationTemplateSystemRevisionRequest>
                                serializer = ProtoRestSerializer.create();
                            serializer.putPathParam(fields, "name", request.getName());
                            return fields;
                          })
                      .setQueryParamsExtractor(
                          request -> {
                            Map<String, List<String>> fields = new HashMap<>();
                            ProtoRestSerializer<GetApplicationTemplateSystemRevisionRequest>
                                serializer = ProtoRestSerializer.create();
                            serializer.putQueryParam(fields, "$alt", "json;enum-encoding=int");
                            return fields;
                          })
                      .setRequestBodyExtractor(request -> null)
                      .build())
              .setResponseParser(
                  ProtoMessageResponseParser.<ApplicationTemplateSystemRevision>newBuilder()
                      .setDefaultInstance(ApplicationTemplateSystemRevision.getDefaultInstance())
                      .setDefaultTypeRegistry(typeRegistry)
                      .build())
              .build();

  private static final ApiMethodDescriptor<RecommendIAMRolesRequest, Operation>
      recommendIAMRolesMethodDescriptor =
          ApiMethodDescriptor.<RecommendIAMRolesRequest, Operation>newBuilder()
              .setFullMethodName("google.cloud.designcenter.v1.DesignCenter/RecommendIAMRoles")
              .setHttpMethod("POST")
              .setType(ApiMethodDescriptor.MethodType.UNARY)
              .setRequestFormatter(
                  ProtoMessageRequestFormatter.<RecommendIAMRolesRequest>newBuilder()
                      .setPath(
                          "/v1/{name=projects/*/locations/*/spaces/*/applications/*}:recommendIAMRoles",
                          request -> {
                            Map<String, String> fields = new HashMap<>();
                            ProtoRestSerializer<RecommendIAMRolesRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putPathParam(fields, "name", request.getName());
                            return fields;
                          })
                      .setQueryParamsExtractor(
                          request -> {
                            Map<String, List<String>> fields = new HashMap<>();
                            ProtoRestSerializer<RecommendIAMRolesRequest> serializer =
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
                  ProtoMessageResponseParser.<Operation>newBuilder()
                      .setDefaultInstance(Operation.getDefaultInstance())
                      .setDefaultTypeRegistry(typeRegistry)
                      .build())
              .setOperationSnapshotFactory(
                  (RecommendIAMRolesRequest request, Operation response) ->
                      HttpJsonOperationSnapshot.create(response))
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

  private static final ApiMethodDescriptor<SetIamPolicyRequest, com.google.iam.v1.Policy>
      setIamPolicyMethodDescriptor =
          ApiMethodDescriptor.<SetIamPolicyRequest, com.google.iam.v1.Policy>newBuilder()
              .setFullMethodName("google.iam.v1.IAMPolicy/SetIamPolicy")
              .setHttpMethod("POST")
              .setType(ApiMethodDescriptor.MethodType.UNARY)
              .setRequestFormatter(
                  ProtoMessageRequestFormatter.<SetIamPolicyRequest>newBuilder()
                      .setPath(
                          "/v1/{resource=projects/*/locations/*/spaces/*}:setIamPolicy",
                          request -> {
                            Map<String, String> fields = new HashMap<>();
                            ProtoRestSerializer<SetIamPolicyRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putPathParam(fields, "resource", request.getResource());
                            return fields;
                          })
                      .setQueryParamsExtractor(
                          request -> {
                            Map<String, List<String>> fields = new HashMap<>();
                            ProtoRestSerializer<SetIamPolicyRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putQueryParam(fields, "$alt", "json;enum-encoding=int");
                            return fields;
                          })
                      .setRequestBodyExtractor(
                          request ->
                              ProtoRestSerializer.create()
                                  .toBody("*", request.toBuilder().clearResource().build(), true))
                      .build())
              .setResponseParser(
                  ProtoMessageResponseParser.<com.google.iam.v1.Policy>newBuilder()
                      .setDefaultInstance(com.google.iam.v1.Policy.getDefaultInstance())
                      .setDefaultTypeRegistry(typeRegistry)
                      .build())
              .build();

  private static final ApiMethodDescriptor<GetIamPolicyRequest, com.google.iam.v1.Policy>
      getIamPolicyMethodDescriptor =
          ApiMethodDescriptor.<GetIamPolicyRequest, com.google.iam.v1.Policy>newBuilder()
              .setFullMethodName("google.iam.v1.IAMPolicy/GetIamPolicy")
              .setHttpMethod("GET")
              .setType(ApiMethodDescriptor.MethodType.UNARY)
              .setRequestFormatter(
                  ProtoMessageRequestFormatter.<GetIamPolicyRequest>newBuilder()
                      .setPath(
                          "/v1/{resource=projects/*/locations/*/spaces/*}:getIamPolicy",
                          request -> {
                            Map<String, String> fields = new HashMap<>();
                            ProtoRestSerializer<GetIamPolicyRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putPathParam(fields, "resource", request.getResource());
                            return fields;
                          })
                      .setQueryParamsExtractor(
                          request -> {
                            Map<String, List<String>> fields = new HashMap<>();
                            ProtoRestSerializer<GetIamPolicyRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putQueryParam(fields, "$alt", "json;enum-encoding=int");
                            return fields;
                          })
                      .setRequestBodyExtractor(request -> null)
                      .build())
              .setResponseParser(
                  ProtoMessageResponseParser.<com.google.iam.v1.Policy>newBuilder()
                      .setDefaultInstance(com.google.iam.v1.Policy.getDefaultInstance())
                      .setDefaultTypeRegistry(typeRegistry)
                      .build())
              .build();

  private static final ApiMethodDescriptor<TestIamPermissionsRequest, TestIamPermissionsResponse>
      testIamPermissionsMethodDescriptor =
          ApiMethodDescriptor.<TestIamPermissionsRequest, TestIamPermissionsResponse>newBuilder()
              .setFullMethodName("google.iam.v1.IAMPolicy/TestIamPermissions")
              .setHttpMethod("POST")
              .setType(ApiMethodDescriptor.MethodType.UNARY)
              .setRequestFormatter(
                  ProtoMessageRequestFormatter.<TestIamPermissionsRequest>newBuilder()
                      .setPath(
                          "/v1/{resource=projects/*/locations/*/spaces/*}:testIamPermissions",
                          request -> {
                            Map<String, String> fields = new HashMap<>();
                            ProtoRestSerializer<TestIamPermissionsRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putPathParam(fields, "resource", request.getResource());
                            return fields;
                          })
                      .setQueryParamsExtractor(
                          request -> {
                            Map<String, List<String>> fields = new HashMap<>();
                            ProtoRestSerializer<TestIamPermissionsRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putQueryParam(fields, "$alt", "json;enum-encoding=int");
                            return fields;
                          })
                      .setRequestBodyExtractor(
                          request ->
                              ProtoRestSerializer.create()
                                  .toBody("*", request.toBuilder().clearResource().build(), true))
                      .build())
              .setResponseParser(
                  ProtoMessageResponseParser.<TestIamPermissionsResponse>newBuilder()
                      .setDefaultInstance(TestIamPermissionsResponse.getDefaultInstance())
                      .setDefaultTypeRegistry(typeRegistry)
                      .build())
              .build();

  private final UnaryCallable<GetSpaceRequest, Space> getSpaceCallable;
  private final UnaryCallable<ListSpacesRequest, ListSpacesResponse> listSpacesCallable;
  private final UnaryCallable<ListSpacesRequest, ListSpacesPagedResponse> listSpacesPagedCallable;
  private final UnaryCallable<CreateSpaceRequest, Space> createSpaceCallable;
  private final UnaryCallable<UpdateSpaceRequest, Space> updateSpaceCallable;
  private final UnaryCallable<DeleteSpaceRequest, Empty> deleteSpaceCallable;
  private final UnaryCallable<GetApplicationTemplateRequest, ApplicationTemplate>
      getApplicationTemplateCallable;
  private final UnaryCallable<ListApplicationTemplatesRequest, ListApplicationTemplatesResponse>
      listApplicationTemplatesCallable;
  private final UnaryCallable<
          ListApplicationTemplatesRequest, ListApplicationTemplatesPagedResponse>
      listApplicationTemplatesPagedCallable;
  private final UnaryCallable<CreateApplicationTemplateRequest, ApplicationTemplate>
      createApplicationTemplateCallable;
  private final UnaryCallable<UpdateApplicationTemplateRequest, ApplicationTemplate>
      updateApplicationTemplateCallable;
  private final UnaryCallable<ImportApplicationTemplateRequest, ApplicationTemplate>
      importApplicationTemplateCallable;
  private final UnaryCallable<DeleteApplicationTemplateRequest, Empty>
      deleteApplicationTemplateCallable;
  private final UnaryCallable<CommitApplicationTemplateRequest, ApplicationTemplateRevision>
      commitApplicationTemplateCallable;
  private final UnaryCallable<SnapshotApplicationTemplateRequest, Operation>
      snapshotApplicationTemplateCallable;
  private final OperationCallable<
          SnapshotApplicationTemplateRequest,
          SnapshotApplicationTemplateResponse,
          OperationMetadata>
      snapshotApplicationTemplateOperationCallable;
  private final UnaryCallable<
          GenerateApplicationTemplateIaCRequest, GenerateApplicationTemplateIaCResponse>
      generateApplicationTemplateIaCCallable;
  private final UnaryCallable<ExportApplicationTemplateIaCRequest, Operation>
      exportApplicationTemplateIaCCallable;
  private final OperationCallable<
          ExportApplicationTemplateIaCRequest,
          ExportApplicationTemplateIaCResponse,
          OperationMetadata>
      exportApplicationTemplateIaCOperationCallable;
  private final UnaryCallable<
          GenerateApplicationTemplateRevisionIaCRequest,
          GenerateApplicationTemplateRevisionIaCResponse>
      generateApplicationTemplateRevisionIaCCallable;
  private final UnaryCallable<ExportApplicationTemplateRevisionIaCRequest, Operation>
      exportApplicationTemplateRevisionIaCCallable;
  private final OperationCallable<
          ExportApplicationTemplateRevisionIaCRequest,
          ExportApplicationTemplateRevisionIaCResponse,
          OperationMetadata>
      exportApplicationTemplateRevisionIaCOperationCallable;
  private final UnaryCallable<GetComponentRequest, Component> getComponentCallable;
  private final UnaryCallable<ListComponentsRequest, ListComponentsResponse> listComponentsCallable;
  private final UnaryCallable<ListComponentsRequest, ListComponentsPagedResponse>
      listComponentsPagedCallable;
  private final UnaryCallable<CreateComponentRequest, Component> createComponentCallable;
  private final UnaryCallable<UpdateComponentRequest, Component> updateComponentCallable;
  private final UnaryCallable<DeleteComponentRequest, Empty> deleteComponentCallable;
  private final UnaryCallable<GetConnectionRequest, Connection> getConnectionCallable;
  private final UnaryCallable<ListConnectionsRequest, ListConnectionsResponse>
      listConnectionsCallable;
  private final UnaryCallable<ListConnectionsRequest, ListConnectionsPagedResponse>
      listConnectionsPagedCallable;
  private final UnaryCallable<CreateConnectionRequest, Connection> createConnectionCallable;
  private final UnaryCallable<UpdateConnectionRequest, Connection> updateConnectionCallable;
  private final UnaryCallable<DeleteConnectionRequest, Empty> deleteConnectionCallable;
  private final UnaryCallable<GetApplicationTemplateRevisionRequest, ApplicationTemplateRevision>
      getApplicationTemplateRevisionCallable;
  private final UnaryCallable<
          ListApplicationTemplateRevisionsRequest, ListApplicationTemplateRevisionsResponse>
      listApplicationTemplateRevisionsCallable;
  private final UnaryCallable<
          ListApplicationTemplateRevisionsRequest, ListApplicationTemplateRevisionsPagedResponse>
      listApplicationTemplateRevisionsPagedCallable;
  private final UnaryCallable<DeleteApplicationTemplateRevisionRequest, Empty>
      deleteApplicationTemplateRevisionCallable;
  private final UnaryCallable<GetCatalogRequest, Catalog> getCatalogCallable;
  private final UnaryCallable<ListCatalogsRequest, ListCatalogsResponse> listCatalogsCallable;
  private final UnaryCallable<ListCatalogsRequest, ListCatalogsPagedResponse>
      listCatalogsPagedCallable;
  private final UnaryCallable<CreateCatalogRequest, Catalog> createCatalogCallable;
  private final UnaryCallable<UpdateCatalogRequest, Catalog> updateCatalogCallable;
  private final UnaryCallable<DeleteCatalogRequest, Operation> deleteCatalogCallable;
  private final OperationCallable<DeleteCatalogRequest, Empty, OperationMetadata>
      deleteCatalogOperationCallable;
  private final UnaryCallable<CreateCatalogTemplateRequest, CatalogTemplate>
      createCatalogTemplateCallable;
  private final UnaryCallable<GetCatalogTemplateRequest, CatalogTemplate>
      getCatalogTemplateCallable;
  private final UnaryCallable<ListCatalogTemplatesRequest, ListCatalogTemplatesResponse>
      listCatalogTemplatesCallable;
  private final UnaryCallable<ListCatalogTemplatesRequest, ListCatalogTemplatesPagedResponse>
      listCatalogTemplatesPagedCallable;
  private final UnaryCallable<UpdateCatalogTemplateRequest, CatalogTemplate>
      updateCatalogTemplateCallable;
  private final UnaryCallable<DeleteCatalogTemplateRequest, Operation>
      deleteCatalogTemplateCallable;
  private final OperationCallable<DeleteCatalogTemplateRequest, Empty, OperationMetadata>
      deleteCatalogTemplateOperationCallable;
  private final UnaryCallable<CreateShareRequest, Operation> createShareCallable;
  private final OperationCallable<CreateShareRequest, Share, OperationMetadata>
      createShareOperationCallable;
  private final UnaryCallable<ListSharesRequest, ListSharesResponse> listSharesCallable;
  private final UnaryCallable<ListSharesRequest, ListSharesPagedResponse> listSharesPagedCallable;
  private final UnaryCallable<GetShareRequest, Share> getShareCallable;
  private final UnaryCallable<DeleteShareRequest, Operation> deleteShareCallable;
  private final OperationCallable<DeleteShareRequest, Empty, OperationMetadata>
      deleteShareOperationCallable;
  private final UnaryCallable<SyncShareRequest, Operation> syncShareCallable;
  private final OperationCallable<SyncShareRequest, Share, OperationMetadata>
      syncShareOperationCallable;
  private final UnaryCallable<GetSharedTemplateRequest, SharedTemplate> getSharedTemplateCallable;
  private final UnaryCallable<ListSharedTemplatesRequest, ListSharedTemplatesResponse>
      listSharedTemplatesCallable;
  private final UnaryCallable<ListSharedTemplatesRequest, ListSharedTemplatesPagedResponse>
      listSharedTemplatesPagedCallable;
  private final UnaryCallable<GetSharedTemplateRevisionRequest, SharedTemplateRevision>
      getSharedTemplateRevisionCallable;
  private final UnaryCallable<
          ListSharedTemplateRevisionsRequest, ListSharedTemplateRevisionsResponse>
      listSharedTemplateRevisionsCallable;
  private final UnaryCallable<
          ListSharedTemplateRevisionsRequest, ListSharedTemplateRevisionsPagedResponse>
      listSharedTemplateRevisionsPagedCallable;
  private final UnaryCallable<CreateCatalogTemplateRevisionRequest, Operation>
      createCatalogTemplateRevisionCallable;
  private final OperationCallable<
          CreateCatalogTemplateRevisionRequest, CatalogTemplateRevision, OperationMetadata>
      createCatalogTemplateRevisionOperationCallable;
  private final UnaryCallable<GetCatalogTemplateRevisionRequest, CatalogTemplateRevision>
      getCatalogTemplateRevisionCallable;
  private final UnaryCallable<
          ListCatalogTemplateRevisionsRequest, ListCatalogTemplateRevisionsResponse>
      listCatalogTemplateRevisionsCallable;
  private final UnaryCallable<
          ListCatalogTemplateRevisionsRequest, ListCatalogTemplateRevisionsPagedResponse>
      listCatalogTemplateRevisionsPagedCallable;
  private final UnaryCallable<DeleteCatalogTemplateRevisionRequest, Operation>
      deleteCatalogTemplateRevisionCallable;
  private final OperationCallable<DeleteCatalogTemplateRevisionRequest, Empty, OperationMetadata>
      deleteCatalogTemplateRevisionOperationCallable;
  private final UnaryCallable<CreateApplicationRequest, Application> createApplicationCallable;
  private final UnaryCallable<GetApplicationRequest, Application> getApplicationCallable;
  private final UnaryCallable<ListApplicationsRequest, ListApplicationsResponse>
      listApplicationsCallable;
  private final UnaryCallable<ListApplicationsRequest, ListApplicationsPagedResponse>
      listApplicationsPagedCallable;
  private final UnaryCallable<UpdateApplicationRequest, Application> updateApplicationCallable;
  private final UnaryCallable<DeleteApplicationRequest, Operation> deleteApplicationCallable;
  private final OperationCallable<DeleteApplicationRequest, Empty, OperationMetadata>
      deleteApplicationOperationCallable;
  private final UnaryCallable<DeployApplicationRequest, Operation> deployApplicationCallable;
  private final OperationCallable<
          DeployApplicationRequest, DeployApplicationResponse, OperationMetadata>
      deployApplicationOperationCallable;
  private final UnaryCallable<PreviewApplicationRequest, Operation> previewApplicationCallable;
  private final OperationCallable<
          PreviewApplicationRequest, PreviewApplicationResponse, OperationMetadata>
      previewApplicationOperationCallable;
  private final UnaryCallable<
          FetchApplicationAssessmentReportRequest, FetchApplicationAssessmentReportResponse>
      fetchApplicationAssessmentReportCallable;
  private final UnaryCallable<GenerateApplicationAssessmentReportRequest, Operation>
      generateApplicationAssessmentReportCallable;
  private final OperationCallable<
          GenerateApplicationAssessmentReportRequest,
          GenerateApplicationAssessmentReportResponse,
          OperationMetadata>
      generateApplicationAssessmentReportOperationCallable;
  private final UnaryCallable<GenerateApplicationTemplateAssessmentReportRequest, Operation>
      generateApplicationTemplateAssessmentReportCallable;
  private final OperationCallable<
          GenerateApplicationTemplateAssessmentReportRequest,
          GenerateApplicationTemplateAssessmentReportResponse,
          OperationMetadata>
      generateApplicationTemplateAssessmentReportOperationCallable;
  private final UnaryCallable<GenerateAssessmentReportRequest, Operation>
      generateAssessmentReportCallable;
  private final OperationCallable<
          GenerateAssessmentReportRequest, GenerateAssessmentReportResponse, OperationMetadata>
      generateAssessmentReportOperationCallable;
  private final UnaryCallable<GenerateTerraformPlanAssessmentReportRequest, Operation>
      generateTerraformPlanAssessmentReportCallable;
  private final OperationCallable<
          GenerateTerraformPlanAssessmentReportRequest,
          GenerateTerraformPlanAssessmentReportResponse,
          OperationMetadata>
      generateTerraformPlanAssessmentReportOperationCallable;
  private final UnaryCallable<GetPolicyRequest, Policy> getPolicyCallable;
  private final UnaryCallable<ListPoliciesRequest, ListPoliciesResponse> listPoliciesCallable;
  private final UnaryCallable<ListPoliciesRequest, ListPoliciesPagedResponse>
      listPoliciesPagedCallable;
  private final UnaryCallable<CreatePolicyRequest, Policy> createPolicyCallable;
  private final UnaryCallable<UpdatePolicyRequest, Policy> updatePolicyCallable;
  private final UnaryCallable<DeletePolicyRequest, Empty> deletePolicyCallable;
  private final UnaryCallable<FetchFrameworksRequest, FetchFrameworksResponse>
      fetchFrameworksCallable;
  private final UnaryCallable<FetchFrameworksRequest, FetchFrameworksPagedResponse>
      fetchFrameworksPagedCallable;
  private final UnaryCallable<GenerateApplicationIaCRequest, GenerateApplicationIaCResponse>
      generateApplicationIaCCallable;
  private final UnaryCallable<ExportApplicationIaCRequest, Operation> exportApplicationIaCCallable;
  private final OperationCallable<
          ExportApplicationIaCRequest, ExportApplicationIaCResponse, OperationMetadata>
      exportApplicationIaCOperationCallable;
  private final UnaryCallable<
          ImportApplicationTemplateIaCRequest, ImportApplicationTemplateIaCResponse>
      importApplicationTemplateIaCCallable;
  private final UnaryCallable<IngestApplicationTemplateIaCRequest, Operation>
      ingestApplicationTemplateIaCCallable;
  private final OperationCallable<
          IngestApplicationTemplateIaCRequest,
          IngestApplicationTemplateIaCResponse,
          OperationMetadata>
      ingestApplicationTemplateIaCOperationCallable;
  private final UnaryCallable<ImportApplicationIaCRequest, ImportApplicationIaCResponse>
      importApplicationIaCCallable;
  private final UnaryCallable<RegisterAppHubApplicationResourcesRequest, Operation>
      registerAppHubApplicationResourcesCallable;
  private final OperationCallable<
          RegisterAppHubApplicationResourcesRequest,
          RegisterAppHubApplicationResourcesResponse,
          OperationMetadata>
      registerAppHubApplicationResourcesOperationCallable;
  private final UnaryCallable<
          ListApplicationTemplateSystemRevisionsRequest,
          ListApplicationTemplateSystemRevisionsResponse>
      listApplicationTemplateSystemRevisionsCallable;
  private final UnaryCallable<
          ListApplicationTemplateSystemRevisionsRequest,
          ListApplicationTemplateSystemRevisionsPagedResponse>
      listApplicationTemplateSystemRevisionsPagedCallable;
  private final UnaryCallable<
          GetApplicationTemplateSystemRevisionRequest, ApplicationTemplateSystemRevision>
      getApplicationTemplateSystemRevisionCallable;
  private final UnaryCallable<RecommendIAMRolesRequest, Operation> recommendIAMRolesCallable;
  private final OperationCallable<
          RecommendIAMRolesRequest, RecommendIAMRolesResponse, OperationMetadata>
      recommendIAMRolesOperationCallable;
  private final UnaryCallable<ListLocationsRequest, ListLocationsResponse> listLocationsCallable;
  private final UnaryCallable<ListLocationsRequest, ListLocationsPagedResponse>
      listLocationsPagedCallable;
  private final UnaryCallable<GetLocationRequest, Location> getLocationCallable;
  private final UnaryCallable<SetIamPolicyRequest, com.google.iam.v1.Policy> setIamPolicyCallable;
  private final UnaryCallable<GetIamPolicyRequest, com.google.iam.v1.Policy> getIamPolicyCallable;
  private final UnaryCallable<TestIamPermissionsRequest, TestIamPermissionsResponse>
      testIamPermissionsCallable;

  private final BackgroundResource backgroundResources;
  private final HttpJsonOperationsStub httpJsonOperationsStub;
  private final HttpJsonStubCallableFactory callableFactory;

  public static final HttpJsonDesignCenterStub create(DesignCenterStubSettings settings)
      throws IOException {
    return new HttpJsonDesignCenterStub(settings, ClientContext.create(settings));
  }

  public static final HttpJsonDesignCenterStub create(ClientContext clientContext)
      throws IOException {
    return new HttpJsonDesignCenterStub(
        DesignCenterStubSettings.newHttpJsonBuilder().build(), clientContext);
  }

  public static final HttpJsonDesignCenterStub create(
      ClientContext clientContext, HttpJsonStubCallableFactory callableFactory) throws IOException {
    return new HttpJsonDesignCenterStub(
        DesignCenterStubSettings.newHttpJsonBuilder().build(), clientContext, callableFactory);
  }

  /**
   * Constructs an instance of HttpJsonDesignCenterStub, using the given settings. This is protected
   * so that it is easy to make a subclass, but otherwise, the static factory methods should be
   * preferred.
   */
  protected HttpJsonDesignCenterStub(DesignCenterStubSettings settings, ClientContext clientContext)
      throws IOException {
    this(settings, clientContext, new HttpJsonDesignCenterCallableFactory());
  }

  /**
   * Constructs an instance of HttpJsonDesignCenterStub, using the given settings. This is protected
   * so that it is easy to make a subclass, but otherwise, the static factory methods should be
   * preferred.
   */
  protected HttpJsonDesignCenterStub(
      DesignCenterStubSettings settings,
      ClientContext clientContext,
      HttpJsonStubCallableFactory callableFactory)
      throws IOException {
    this.callableFactory = callableFactory;
    this.httpJsonOperationsStub =
        HttpJsonOperationsStub.create(
            clientContext,
            callableFactory,
            typeRegistry,
            ImmutableMap.<String, HttpRule>builder()
                .put(
                    "google.longrunning.Operations.CancelOperation",
                    HttpRule.newBuilder()
                        .setPost("/v1/{name=projects/*/locations/*/operations/*}:cancel")
                        .build())
                .put(
                    "google.longrunning.Operations.DeleteOperation",
                    HttpRule.newBuilder()
                        .setDelete("/v1/{name=projects/*/locations/*/operations/*}")
                        .build())
                .put(
                    "google.longrunning.Operations.GetOperation",
                    HttpRule.newBuilder()
                        .setGet("/v1/{name=projects/*/locations/*/operations/*}")
                        .build())
                .put(
                    "google.longrunning.Operations.ListOperations",
                    HttpRule.newBuilder()
                        .setGet("/v1/{name=projects/*/locations/*}/operations")
                        .build())
                .build());

    HttpJsonCallSettings<GetSpaceRequest, Space> getSpaceTransportSettings =
        HttpJsonCallSettings.<GetSpaceRequest, Space>newBuilder()
            .setMethodDescriptor(getSpaceMethodDescriptor)
            .setTypeRegistry(typeRegistry)
            .setParamsExtractor(
                request -> {
                  RequestParamsBuilder builder = RequestParamsBuilder.create();
                  builder.add("name", String.valueOf(request.getName()));
                  return builder.build();
                })
            .setResourceNameExtractor(request -> request.getName())
            .build();
    HttpJsonCallSettings<ListSpacesRequest, ListSpacesResponse> listSpacesTransportSettings =
        HttpJsonCallSettings.<ListSpacesRequest, ListSpacesResponse>newBuilder()
            .setMethodDescriptor(listSpacesMethodDescriptor)
            .setTypeRegistry(typeRegistry)
            .setParamsExtractor(
                request -> {
                  RequestParamsBuilder builder = RequestParamsBuilder.create();
                  builder.add("parent", String.valueOf(request.getParent()));
                  return builder.build();
                })
            .setResourceNameExtractor(request -> request.getParent())
            .build();
    HttpJsonCallSettings<CreateSpaceRequest, Space> createSpaceTransportSettings =
        HttpJsonCallSettings.<CreateSpaceRequest, Space>newBuilder()
            .setMethodDescriptor(createSpaceMethodDescriptor)
            .setTypeRegistry(typeRegistry)
            .setParamsExtractor(
                request -> {
                  RequestParamsBuilder builder = RequestParamsBuilder.create();
                  builder.add("parent", String.valueOf(request.getParent()));
                  return builder.build();
                })
            .setResourceNameExtractor(request -> request.getParent())
            .build();
    HttpJsonCallSettings<UpdateSpaceRequest, Space> updateSpaceTransportSettings =
        HttpJsonCallSettings.<UpdateSpaceRequest, Space>newBuilder()
            .setMethodDescriptor(updateSpaceMethodDescriptor)
            .setTypeRegistry(typeRegistry)
            .setParamsExtractor(
                request -> {
                  RequestParamsBuilder builder = RequestParamsBuilder.create();
                  builder.add("space.name", String.valueOf(request.getSpace().getName()));
                  return builder.build();
                })
            .build();
    HttpJsonCallSettings<DeleteSpaceRequest, Empty> deleteSpaceTransportSettings =
        HttpJsonCallSettings.<DeleteSpaceRequest, Empty>newBuilder()
            .setMethodDescriptor(deleteSpaceMethodDescriptor)
            .setTypeRegistry(typeRegistry)
            .setParamsExtractor(
                request -> {
                  RequestParamsBuilder builder = RequestParamsBuilder.create();
                  builder.add("name", String.valueOf(request.getName()));
                  return builder.build();
                })
            .setResourceNameExtractor(request -> request.getName())
            .build();
    HttpJsonCallSettings<GetApplicationTemplateRequest, ApplicationTemplate>
        getApplicationTemplateTransportSettings =
            HttpJsonCallSettings.<GetApplicationTemplateRequest, ApplicationTemplate>newBuilder()
                .setMethodDescriptor(getApplicationTemplateMethodDescriptor)
                .setTypeRegistry(typeRegistry)
                .setParamsExtractor(
                    request -> {
                      RequestParamsBuilder builder = RequestParamsBuilder.create();
                      builder.add("name", String.valueOf(request.getName()));
                      return builder.build();
                    })
                .setResourceNameExtractor(request -> request.getName())
                .build();
    HttpJsonCallSettings<ListApplicationTemplatesRequest, ListApplicationTemplatesResponse>
        listApplicationTemplatesTransportSettings =
            HttpJsonCallSettings
                .<ListApplicationTemplatesRequest, ListApplicationTemplatesResponse>newBuilder()
                .setMethodDescriptor(listApplicationTemplatesMethodDescriptor)
                .setTypeRegistry(typeRegistry)
                .setParamsExtractor(
                    request -> {
                      RequestParamsBuilder builder = RequestParamsBuilder.create();
                      builder.add("parent", String.valueOf(request.getParent()));
                      return builder.build();
                    })
                .setResourceNameExtractor(request -> request.getParent())
                .build();
    HttpJsonCallSettings<CreateApplicationTemplateRequest, ApplicationTemplate>
        createApplicationTemplateTransportSettings =
            HttpJsonCallSettings.<CreateApplicationTemplateRequest, ApplicationTemplate>newBuilder()
                .setMethodDescriptor(createApplicationTemplateMethodDescriptor)
                .setTypeRegistry(typeRegistry)
                .setParamsExtractor(
                    request -> {
                      RequestParamsBuilder builder = RequestParamsBuilder.create();
                      builder.add("parent", String.valueOf(request.getParent()));
                      return builder.build();
                    })
                .setResourceNameExtractor(request -> request.getParent())
                .build();
    HttpJsonCallSettings<UpdateApplicationTemplateRequest, ApplicationTemplate>
        updateApplicationTemplateTransportSettings =
            HttpJsonCallSettings.<UpdateApplicationTemplateRequest, ApplicationTemplate>newBuilder()
                .setMethodDescriptor(updateApplicationTemplateMethodDescriptor)
                .setTypeRegistry(typeRegistry)
                .setParamsExtractor(
                    request -> {
                      RequestParamsBuilder builder = RequestParamsBuilder.create();
                      builder.add(
                          "application_template.name",
                          String.valueOf(request.getApplicationTemplate().getName()));
                      return builder.build();
                    })
                .build();
    HttpJsonCallSettings<ImportApplicationTemplateRequest, ApplicationTemplate>
        importApplicationTemplateTransportSettings =
            HttpJsonCallSettings.<ImportApplicationTemplateRequest, ApplicationTemplate>newBuilder()
                .setMethodDescriptor(importApplicationTemplateMethodDescriptor)
                .setTypeRegistry(typeRegistry)
                .setParamsExtractor(
                    request -> {
                      RequestParamsBuilder builder = RequestParamsBuilder.create();
                      builder.add("name", String.valueOf(request.getName()));
                      return builder.build();
                    })
                .setResourceNameExtractor(request -> request.getApplicationTemplateRevisionUri())
                .build();
    HttpJsonCallSettings<DeleteApplicationTemplateRequest, Empty>
        deleteApplicationTemplateTransportSettings =
            HttpJsonCallSettings.<DeleteApplicationTemplateRequest, Empty>newBuilder()
                .setMethodDescriptor(deleteApplicationTemplateMethodDescriptor)
                .setTypeRegistry(typeRegistry)
                .setParamsExtractor(
                    request -> {
                      RequestParamsBuilder builder = RequestParamsBuilder.create();
                      builder.add("name", String.valueOf(request.getName()));
                      return builder.build();
                    })
                .setResourceNameExtractor(request -> request.getName())
                .build();
    HttpJsonCallSettings<CommitApplicationTemplateRequest, ApplicationTemplateRevision>
        commitApplicationTemplateTransportSettings =
            HttpJsonCallSettings
                .<CommitApplicationTemplateRequest, ApplicationTemplateRevision>newBuilder()
                .setMethodDescriptor(commitApplicationTemplateMethodDescriptor)
                .setTypeRegistry(typeRegistry)
                .setParamsExtractor(
                    request -> {
                      RequestParamsBuilder builder = RequestParamsBuilder.create();
                      builder.add("name", String.valueOf(request.getName()));
                      return builder.build();
                    })
                .setResourceNameExtractor(request -> request.getName())
                .build();
    HttpJsonCallSettings<SnapshotApplicationTemplateRequest, Operation>
        snapshotApplicationTemplateTransportSettings =
            HttpJsonCallSettings.<SnapshotApplicationTemplateRequest, Operation>newBuilder()
                .setMethodDescriptor(snapshotApplicationTemplateMethodDescriptor)
                .setTypeRegistry(typeRegistry)
                .setParamsExtractor(
                    request -> {
                      RequestParamsBuilder builder = RequestParamsBuilder.create();
                      builder.add("name", String.valueOf(request.getName()));
                      return builder.build();
                    })
                .setResourceNameExtractor(request -> request.getName())
                .build();
    HttpJsonCallSettings<
            GenerateApplicationTemplateIaCRequest, GenerateApplicationTemplateIaCResponse>
        generateApplicationTemplateIaCTransportSettings =
            HttpJsonCallSettings
                .<GenerateApplicationTemplateIaCRequest, GenerateApplicationTemplateIaCResponse>
                    newBuilder()
                .setMethodDescriptor(generateApplicationTemplateIaCMethodDescriptor)
                .setTypeRegistry(typeRegistry)
                .setParamsExtractor(
                    request -> {
                      RequestParamsBuilder builder = RequestParamsBuilder.create();
                      builder.add("name", String.valueOf(request.getName()));
                      return builder.build();
                    })
                .setResourceNameExtractor(request -> request.getName())
                .build();
    HttpJsonCallSettings<ExportApplicationTemplateIaCRequest, Operation>
        exportApplicationTemplateIaCTransportSettings =
            HttpJsonCallSettings.<ExportApplicationTemplateIaCRequest, Operation>newBuilder()
                .setMethodDescriptor(exportApplicationTemplateIaCMethodDescriptor)
                .setTypeRegistry(typeRegistry)
                .setParamsExtractor(
                    request -> {
                      RequestParamsBuilder builder = RequestParamsBuilder.create();
                      builder.add("name", String.valueOf(request.getName()));
                      return builder.build();
                    })
                .setResourceNameExtractor(request -> request.getName())
                .build();
    HttpJsonCallSettings<
            GenerateApplicationTemplateRevisionIaCRequest,
            GenerateApplicationTemplateRevisionIaCResponse>
        generateApplicationTemplateRevisionIaCTransportSettings =
            HttpJsonCallSettings
                .<GenerateApplicationTemplateRevisionIaCRequest,
                    GenerateApplicationTemplateRevisionIaCResponse>
                    newBuilder()
                .setMethodDescriptor(generateApplicationTemplateRevisionIaCMethodDescriptor)
                .setTypeRegistry(typeRegistry)
                .setParamsExtractor(
                    request -> {
                      RequestParamsBuilder builder = RequestParamsBuilder.create();
                      builder.add("name", String.valueOf(request.getName()));
                      return builder.build();
                    })
                .setResourceNameExtractor(request -> request.getName())
                .build();
    HttpJsonCallSettings<ExportApplicationTemplateRevisionIaCRequest, Operation>
        exportApplicationTemplateRevisionIaCTransportSettings =
            HttpJsonCallSettings
                .<ExportApplicationTemplateRevisionIaCRequest, Operation>newBuilder()
                .setMethodDescriptor(exportApplicationTemplateRevisionIaCMethodDescriptor)
                .setTypeRegistry(typeRegistry)
                .setParamsExtractor(
                    request -> {
                      RequestParamsBuilder builder = RequestParamsBuilder.create();
                      builder.add("name", String.valueOf(request.getName()));
                      return builder.build();
                    })
                .setResourceNameExtractor(request -> request.getName())
                .build();
    HttpJsonCallSettings<GetComponentRequest, Component> getComponentTransportSettings =
        HttpJsonCallSettings.<GetComponentRequest, Component>newBuilder()
            .setMethodDescriptor(getComponentMethodDescriptor)
            .setTypeRegistry(typeRegistry)
            .setParamsExtractor(
                request -> {
                  RequestParamsBuilder builder = RequestParamsBuilder.create();
                  builder.add("name", String.valueOf(request.getName()));
                  return builder.build();
                })
            .setResourceNameExtractor(request -> request.getName())
            .build();
    HttpJsonCallSettings<ListComponentsRequest, ListComponentsResponse>
        listComponentsTransportSettings =
            HttpJsonCallSettings.<ListComponentsRequest, ListComponentsResponse>newBuilder()
                .setMethodDescriptor(listComponentsMethodDescriptor)
                .setTypeRegistry(typeRegistry)
                .setParamsExtractor(
                    request -> {
                      RequestParamsBuilder builder = RequestParamsBuilder.create();
                      builder.add("parent", String.valueOf(request.getParent()));
                      return builder.build();
                    })
                .setResourceNameExtractor(request -> request.getParent())
                .build();
    HttpJsonCallSettings<CreateComponentRequest, Component> createComponentTransportSettings =
        HttpJsonCallSettings.<CreateComponentRequest, Component>newBuilder()
            .setMethodDescriptor(createComponentMethodDescriptor)
            .setTypeRegistry(typeRegistry)
            .setParamsExtractor(
                request -> {
                  RequestParamsBuilder builder = RequestParamsBuilder.create();
                  builder.add("parent", String.valueOf(request.getParent()));
                  return builder.build();
                })
            .setResourceNameExtractor(request -> request.getParent())
            .build();
    HttpJsonCallSettings<UpdateComponentRequest, Component> updateComponentTransportSettings =
        HttpJsonCallSettings.<UpdateComponentRequest, Component>newBuilder()
            .setMethodDescriptor(updateComponentMethodDescriptor)
            .setTypeRegistry(typeRegistry)
            .setParamsExtractor(
                request -> {
                  RequestParamsBuilder builder = RequestParamsBuilder.create();
                  builder.add("component.name", String.valueOf(request.getComponent().getName()));
                  return builder.build();
                })
            .build();
    HttpJsonCallSettings<DeleteComponentRequest, Empty> deleteComponentTransportSettings =
        HttpJsonCallSettings.<DeleteComponentRequest, Empty>newBuilder()
            .setMethodDescriptor(deleteComponentMethodDescriptor)
            .setTypeRegistry(typeRegistry)
            .setParamsExtractor(
                request -> {
                  RequestParamsBuilder builder = RequestParamsBuilder.create();
                  builder.add("name", String.valueOf(request.getName()));
                  return builder.build();
                })
            .setResourceNameExtractor(request -> request.getName())
            .build();
    HttpJsonCallSettings<GetConnectionRequest, Connection> getConnectionTransportSettings =
        HttpJsonCallSettings.<GetConnectionRequest, Connection>newBuilder()
            .setMethodDescriptor(getConnectionMethodDescriptor)
            .setTypeRegistry(typeRegistry)
            .setParamsExtractor(
                request -> {
                  RequestParamsBuilder builder = RequestParamsBuilder.create();
                  builder.add("name", String.valueOf(request.getName()));
                  return builder.build();
                })
            .setResourceNameExtractor(request -> request.getName())
            .build();
    HttpJsonCallSettings<ListConnectionsRequest, ListConnectionsResponse>
        listConnectionsTransportSettings =
            HttpJsonCallSettings.<ListConnectionsRequest, ListConnectionsResponse>newBuilder()
                .setMethodDescriptor(listConnectionsMethodDescriptor)
                .setTypeRegistry(typeRegistry)
                .setParamsExtractor(
                    request -> {
                      RequestParamsBuilder builder = RequestParamsBuilder.create();
                      builder.add("parent", String.valueOf(request.getParent()));
                      return builder.build();
                    })
                .setResourceNameExtractor(request -> request.getParent())
                .build();
    HttpJsonCallSettings<CreateConnectionRequest, Connection> createConnectionTransportSettings =
        HttpJsonCallSettings.<CreateConnectionRequest, Connection>newBuilder()
            .setMethodDescriptor(createConnectionMethodDescriptor)
            .setTypeRegistry(typeRegistry)
            .setParamsExtractor(
                request -> {
                  RequestParamsBuilder builder = RequestParamsBuilder.create();
                  builder.add("parent", String.valueOf(request.getParent()));
                  return builder.build();
                })
            .setResourceNameExtractor(request -> request.getParent())
            .build();
    HttpJsonCallSettings<UpdateConnectionRequest, Connection> updateConnectionTransportSettings =
        HttpJsonCallSettings.<UpdateConnectionRequest, Connection>newBuilder()
            .setMethodDescriptor(updateConnectionMethodDescriptor)
            .setTypeRegistry(typeRegistry)
            .setParamsExtractor(
                request -> {
                  RequestParamsBuilder builder = RequestParamsBuilder.create();
                  builder.add("connection.name", String.valueOf(request.getConnection().getName()));
                  return builder.build();
                })
            .build();
    HttpJsonCallSettings<DeleteConnectionRequest, Empty> deleteConnectionTransportSettings =
        HttpJsonCallSettings.<DeleteConnectionRequest, Empty>newBuilder()
            .setMethodDescriptor(deleteConnectionMethodDescriptor)
            .setTypeRegistry(typeRegistry)
            .setParamsExtractor(
                request -> {
                  RequestParamsBuilder builder = RequestParamsBuilder.create();
                  builder.add("name", String.valueOf(request.getName()));
                  return builder.build();
                })
            .setResourceNameExtractor(request -> request.getName())
            .build();
    HttpJsonCallSettings<GetApplicationTemplateRevisionRequest, ApplicationTemplateRevision>
        getApplicationTemplateRevisionTransportSettings =
            HttpJsonCallSettings
                .<GetApplicationTemplateRevisionRequest, ApplicationTemplateRevision>newBuilder()
                .setMethodDescriptor(getApplicationTemplateRevisionMethodDescriptor)
                .setTypeRegistry(typeRegistry)
                .setParamsExtractor(
                    request -> {
                      RequestParamsBuilder builder = RequestParamsBuilder.create();
                      builder.add("name", String.valueOf(request.getName()));
                      return builder.build();
                    })
                .setResourceNameExtractor(request -> request.getName())
                .build();
    HttpJsonCallSettings<
            ListApplicationTemplateRevisionsRequest, ListApplicationTemplateRevisionsResponse>
        listApplicationTemplateRevisionsTransportSettings =
            HttpJsonCallSettings
                .<ListApplicationTemplateRevisionsRequest, ListApplicationTemplateRevisionsResponse>
                    newBuilder()
                .setMethodDescriptor(listApplicationTemplateRevisionsMethodDescriptor)
                .setTypeRegistry(typeRegistry)
                .setParamsExtractor(
                    request -> {
                      RequestParamsBuilder builder = RequestParamsBuilder.create();
                      builder.add("parent", String.valueOf(request.getParent()));
                      return builder.build();
                    })
                .setResourceNameExtractor(request -> request.getParent())
                .build();
    HttpJsonCallSettings<DeleteApplicationTemplateRevisionRequest, Empty>
        deleteApplicationTemplateRevisionTransportSettings =
            HttpJsonCallSettings.<DeleteApplicationTemplateRevisionRequest, Empty>newBuilder()
                .setMethodDescriptor(deleteApplicationTemplateRevisionMethodDescriptor)
                .setTypeRegistry(typeRegistry)
                .setParamsExtractor(
                    request -> {
                      RequestParamsBuilder builder = RequestParamsBuilder.create();
                      builder.add("name", String.valueOf(request.getName()));
                      return builder.build();
                    })
                .setResourceNameExtractor(request -> request.getName())
                .build();
    HttpJsonCallSettings<GetCatalogRequest, Catalog> getCatalogTransportSettings =
        HttpJsonCallSettings.<GetCatalogRequest, Catalog>newBuilder()
            .setMethodDescriptor(getCatalogMethodDescriptor)
            .setTypeRegistry(typeRegistry)
            .setParamsExtractor(
                request -> {
                  RequestParamsBuilder builder = RequestParamsBuilder.create();
                  builder.add("name", String.valueOf(request.getName()));
                  return builder.build();
                })
            .setResourceNameExtractor(request -> request.getName())
            .build();
    HttpJsonCallSettings<ListCatalogsRequest, ListCatalogsResponse> listCatalogsTransportSettings =
        HttpJsonCallSettings.<ListCatalogsRequest, ListCatalogsResponse>newBuilder()
            .setMethodDescriptor(listCatalogsMethodDescriptor)
            .setTypeRegistry(typeRegistry)
            .setParamsExtractor(
                request -> {
                  RequestParamsBuilder builder = RequestParamsBuilder.create();
                  builder.add("parent", String.valueOf(request.getParent()));
                  return builder.build();
                })
            .setResourceNameExtractor(request -> request.getParent())
            .build();
    HttpJsonCallSettings<CreateCatalogRequest, Catalog> createCatalogTransportSettings =
        HttpJsonCallSettings.<CreateCatalogRequest, Catalog>newBuilder()
            .setMethodDescriptor(createCatalogMethodDescriptor)
            .setTypeRegistry(typeRegistry)
            .setParamsExtractor(
                request -> {
                  RequestParamsBuilder builder = RequestParamsBuilder.create();
                  builder.add("parent", String.valueOf(request.getParent()));
                  return builder.build();
                })
            .setResourceNameExtractor(request -> request.getParent())
            .build();
    HttpJsonCallSettings<UpdateCatalogRequest, Catalog> updateCatalogTransportSettings =
        HttpJsonCallSettings.<UpdateCatalogRequest, Catalog>newBuilder()
            .setMethodDescriptor(updateCatalogMethodDescriptor)
            .setTypeRegistry(typeRegistry)
            .setParamsExtractor(
                request -> {
                  RequestParamsBuilder builder = RequestParamsBuilder.create();
                  builder.add("catalog.name", String.valueOf(request.getCatalog().getName()));
                  return builder.build();
                })
            .build();
    HttpJsonCallSettings<DeleteCatalogRequest, Operation> deleteCatalogTransportSettings =
        HttpJsonCallSettings.<DeleteCatalogRequest, Operation>newBuilder()
            .setMethodDescriptor(deleteCatalogMethodDescriptor)
            .setTypeRegistry(typeRegistry)
            .setParamsExtractor(
                request -> {
                  RequestParamsBuilder builder = RequestParamsBuilder.create();
                  builder.add("name", String.valueOf(request.getName()));
                  return builder.build();
                })
            .setResourceNameExtractor(request -> request.getName())
            .build();
    HttpJsonCallSettings<CreateCatalogTemplateRequest, CatalogTemplate>
        createCatalogTemplateTransportSettings =
            HttpJsonCallSettings.<CreateCatalogTemplateRequest, CatalogTemplate>newBuilder()
                .setMethodDescriptor(createCatalogTemplateMethodDescriptor)
                .setTypeRegistry(typeRegistry)
                .setParamsExtractor(
                    request -> {
                      RequestParamsBuilder builder = RequestParamsBuilder.create();
                      builder.add("parent", String.valueOf(request.getParent()));
                      return builder.build();
                    })
                .setResourceNameExtractor(request -> request.getParent())
                .build();
    HttpJsonCallSettings<GetCatalogTemplateRequest, CatalogTemplate>
        getCatalogTemplateTransportSettings =
            HttpJsonCallSettings.<GetCatalogTemplateRequest, CatalogTemplate>newBuilder()
                .setMethodDescriptor(getCatalogTemplateMethodDescriptor)
                .setTypeRegistry(typeRegistry)
                .setParamsExtractor(
                    request -> {
                      RequestParamsBuilder builder = RequestParamsBuilder.create();
                      builder.add("name", String.valueOf(request.getName()));
                      return builder.build();
                    })
                .setResourceNameExtractor(request -> request.getName())
                .build();
    HttpJsonCallSettings<ListCatalogTemplatesRequest, ListCatalogTemplatesResponse>
        listCatalogTemplatesTransportSettings =
            HttpJsonCallSettings
                .<ListCatalogTemplatesRequest, ListCatalogTemplatesResponse>newBuilder()
                .setMethodDescriptor(listCatalogTemplatesMethodDescriptor)
                .setTypeRegistry(typeRegistry)
                .setParamsExtractor(
                    request -> {
                      RequestParamsBuilder builder = RequestParamsBuilder.create();
                      builder.add("parent", String.valueOf(request.getParent()));
                      return builder.build();
                    })
                .setResourceNameExtractor(request -> request.getParent())
                .build();
    HttpJsonCallSettings<UpdateCatalogTemplateRequest, CatalogTemplate>
        updateCatalogTemplateTransportSettings =
            HttpJsonCallSettings.<UpdateCatalogTemplateRequest, CatalogTemplate>newBuilder()
                .setMethodDescriptor(updateCatalogTemplateMethodDescriptor)
                .setTypeRegistry(typeRegistry)
                .setParamsExtractor(
                    request -> {
                      RequestParamsBuilder builder = RequestParamsBuilder.create();
                      builder.add(
                          "catalog_template.name",
                          String.valueOf(request.getCatalogTemplate().getName()));
                      return builder.build();
                    })
                .build();
    HttpJsonCallSettings<DeleteCatalogTemplateRequest, Operation>
        deleteCatalogTemplateTransportSettings =
            HttpJsonCallSettings.<DeleteCatalogTemplateRequest, Operation>newBuilder()
                .setMethodDescriptor(deleteCatalogTemplateMethodDescriptor)
                .setTypeRegistry(typeRegistry)
                .setParamsExtractor(
                    request -> {
                      RequestParamsBuilder builder = RequestParamsBuilder.create();
                      builder.add("name", String.valueOf(request.getName()));
                      return builder.build();
                    })
                .setResourceNameExtractor(request -> request.getName())
                .build();
    HttpJsonCallSettings<CreateShareRequest, Operation> createShareTransportSettings =
        HttpJsonCallSettings.<CreateShareRequest, Operation>newBuilder()
            .setMethodDescriptor(createShareMethodDescriptor)
            .setTypeRegistry(typeRegistry)
            .setParamsExtractor(
                request -> {
                  RequestParamsBuilder builder = RequestParamsBuilder.create();
                  builder.add("parent", String.valueOf(request.getParent()));
                  return builder.build();
                })
            .setResourceNameExtractor(request -> request.getParent())
            .build();
    HttpJsonCallSettings<ListSharesRequest, ListSharesResponse> listSharesTransportSettings =
        HttpJsonCallSettings.<ListSharesRequest, ListSharesResponse>newBuilder()
            .setMethodDescriptor(listSharesMethodDescriptor)
            .setTypeRegistry(typeRegistry)
            .setParamsExtractor(
                request -> {
                  RequestParamsBuilder builder = RequestParamsBuilder.create();
                  builder.add("parent", String.valueOf(request.getParent()));
                  return builder.build();
                })
            .setResourceNameExtractor(request -> request.getParent())
            .build();
    HttpJsonCallSettings<GetShareRequest, Share> getShareTransportSettings =
        HttpJsonCallSettings.<GetShareRequest, Share>newBuilder()
            .setMethodDescriptor(getShareMethodDescriptor)
            .setTypeRegistry(typeRegistry)
            .setParamsExtractor(
                request -> {
                  RequestParamsBuilder builder = RequestParamsBuilder.create();
                  builder.add("name", String.valueOf(request.getName()));
                  return builder.build();
                })
            .setResourceNameExtractor(request -> request.getName())
            .build();
    HttpJsonCallSettings<DeleteShareRequest, Operation> deleteShareTransportSettings =
        HttpJsonCallSettings.<DeleteShareRequest, Operation>newBuilder()
            .setMethodDescriptor(deleteShareMethodDescriptor)
            .setTypeRegistry(typeRegistry)
            .setParamsExtractor(
                request -> {
                  RequestParamsBuilder builder = RequestParamsBuilder.create();
                  builder.add("name", String.valueOf(request.getName()));
                  return builder.build();
                })
            .setResourceNameExtractor(request -> request.getName())
            .build();
    HttpJsonCallSettings<SyncShareRequest, Operation> syncShareTransportSettings =
        HttpJsonCallSettings.<SyncShareRequest, Operation>newBuilder()
            .setMethodDescriptor(syncShareMethodDescriptor)
            .setTypeRegistry(typeRegistry)
            .setParamsExtractor(
                request -> {
                  RequestParamsBuilder builder = RequestParamsBuilder.create();
                  builder.add("name", String.valueOf(request.getName()));
                  return builder.build();
                })
            .setResourceNameExtractor(request -> request.getName())
            .build();
    HttpJsonCallSettings<GetSharedTemplateRequest, SharedTemplate>
        getSharedTemplateTransportSettings =
            HttpJsonCallSettings.<GetSharedTemplateRequest, SharedTemplate>newBuilder()
                .setMethodDescriptor(getSharedTemplateMethodDescriptor)
                .setTypeRegistry(typeRegistry)
                .setParamsExtractor(
                    request -> {
                      RequestParamsBuilder builder = RequestParamsBuilder.create();
                      builder.add("name", String.valueOf(request.getName()));
                      return builder.build();
                    })
                .setResourceNameExtractor(request -> request.getName())
                .build();
    HttpJsonCallSettings<ListSharedTemplatesRequest, ListSharedTemplatesResponse>
        listSharedTemplatesTransportSettings =
            HttpJsonCallSettings
                .<ListSharedTemplatesRequest, ListSharedTemplatesResponse>newBuilder()
                .setMethodDescriptor(listSharedTemplatesMethodDescriptor)
                .setTypeRegistry(typeRegistry)
                .setParamsExtractor(
                    request -> {
                      RequestParamsBuilder builder = RequestParamsBuilder.create();
                      builder.add("parent", String.valueOf(request.getParent()));
                      return builder.build();
                    })
                .setResourceNameExtractor(request -> request.getParent())
                .build();
    HttpJsonCallSettings<GetSharedTemplateRevisionRequest, SharedTemplateRevision>
        getSharedTemplateRevisionTransportSettings =
            HttpJsonCallSettings
                .<GetSharedTemplateRevisionRequest, SharedTemplateRevision>newBuilder()
                .setMethodDescriptor(getSharedTemplateRevisionMethodDescriptor)
                .setTypeRegistry(typeRegistry)
                .setParamsExtractor(
                    request -> {
                      RequestParamsBuilder builder = RequestParamsBuilder.create();
                      builder.add("name", String.valueOf(request.getName()));
                      return builder.build();
                    })
                .setResourceNameExtractor(request -> request.getName())
                .build();
    HttpJsonCallSettings<ListSharedTemplateRevisionsRequest, ListSharedTemplateRevisionsResponse>
        listSharedTemplateRevisionsTransportSettings =
            HttpJsonCallSettings
                .<ListSharedTemplateRevisionsRequest, ListSharedTemplateRevisionsResponse>
                    newBuilder()
                .setMethodDescriptor(listSharedTemplateRevisionsMethodDescriptor)
                .setTypeRegistry(typeRegistry)
                .setParamsExtractor(
                    request -> {
                      RequestParamsBuilder builder = RequestParamsBuilder.create();
                      builder.add("parent", String.valueOf(request.getParent()));
                      return builder.build();
                    })
                .setResourceNameExtractor(request -> request.getParent())
                .build();
    HttpJsonCallSettings<CreateCatalogTemplateRevisionRequest, Operation>
        createCatalogTemplateRevisionTransportSettings =
            HttpJsonCallSettings.<CreateCatalogTemplateRevisionRequest, Operation>newBuilder()
                .setMethodDescriptor(createCatalogTemplateRevisionMethodDescriptor)
                .setTypeRegistry(typeRegistry)
                .setParamsExtractor(
                    request -> {
                      RequestParamsBuilder builder = RequestParamsBuilder.create();
                      builder.add("parent", String.valueOf(request.getParent()));
                      return builder.build();
                    })
                .setResourceNameExtractor(request -> request.getParent())
                .build();
    HttpJsonCallSettings<GetCatalogTemplateRevisionRequest, CatalogTemplateRevision>
        getCatalogTemplateRevisionTransportSettings =
            HttpJsonCallSettings
                .<GetCatalogTemplateRevisionRequest, CatalogTemplateRevision>newBuilder()
                .setMethodDescriptor(getCatalogTemplateRevisionMethodDescriptor)
                .setTypeRegistry(typeRegistry)
                .setParamsExtractor(
                    request -> {
                      RequestParamsBuilder builder = RequestParamsBuilder.create();
                      builder.add("name", String.valueOf(request.getName()));
                      return builder.build();
                    })
                .setResourceNameExtractor(request -> request.getName())
                .build();
    HttpJsonCallSettings<ListCatalogTemplateRevisionsRequest, ListCatalogTemplateRevisionsResponse>
        listCatalogTemplateRevisionsTransportSettings =
            HttpJsonCallSettings
                .<ListCatalogTemplateRevisionsRequest, ListCatalogTemplateRevisionsResponse>
                    newBuilder()
                .setMethodDescriptor(listCatalogTemplateRevisionsMethodDescriptor)
                .setTypeRegistry(typeRegistry)
                .setParamsExtractor(
                    request -> {
                      RequestParamsBuilder builder = RequestParamsBuilder.create();
                      builder.add("parent", String.valueOf(request.getParent()));
                      return builder.build();
                    })
                .setResourceNameExtractor(request -> request.getParent())
                .build();
    HttpJsonCallSettings<DeleteCatalogTemplateRevisionRequest, Operation>
        deleteCatalogTemplateRevisionTransportSettings =
            HttpJsonCallSettings.<DeleteCatalogTemplateRevisionRequest, Operation>newBuilder()
                .setMethodDescriptor(deleteCatalogTemplateRevisionMethodDescriptor)
                .setTypeRegistry(typeRegistry)
                .setParamsExtractor(
                    request -> {
                      RequestParamsBuilder builder = RequestParamsBuilder.create();
                      builder.add("name", String.valueOf(request.getName()));
                      return builder.build();
                    })
                .setResourceNameExtractor(request -> request.getName())
                .build();
    HttpJsonCallSettings<CreateApplicationRequest, Application> createApplicationTransportSettings =
        HttpJsonCallSettings.<CreateApplicationRequest, Application>newBuilder()
            .setMethodDescriptor(createApplicationMethodDescriptor)
            .setTypeRegistry(typeRegistry)
            .setParamsExtractor(
                request -> {
                  RequestParamsBuilder builder = RequestParamsBuilder.create();
                  builder.add("parent", String.valueOf(request.getParent()));
                  return builder.build();
                })
            .setResourceNameExtractor(request -> request.getParent())
            .build();
    HttpJsonCallSettings<GetApplicationRequest, Application> getApplicationTransportSettings =
        HttpJsonCallSettings.<GetApplicationRequest, Application>newBuilder()
            .setMethodDescriptor(getApplicationMethodDescriptor)
            .setTypeRegistry(typeRegistry)
            .setParamsExtractor(
                request -> {
                  RequestParamsBuilder builder = RequestParamsBuilder.create();
                  builder.add("name", String.valueOf(request.getName()));
                  return builder.build();
                })
            .setResourceNameExtractor(request -> request.getName())
            .build();
    HttpJsonCallSettings<ListApplicationsRequest, ListApplicationsResponse>
        listApplicationsTransportSettings =
            HttpJsonCallSettings.<ListApplicationsRequest, ListApplicationsResponse>newBuilder()
                .setMethodDescriptor(listApplicationsMethodDescriptor)
                .setTypeRegistry(typeRegistry)
                .setParamsExtractor(
                    request -> {
                      RequestParamsBuilder builder = RequestParamsBuilder.create();
                      builder.add("parent", String.valueOf(request.getParent()));
                      return builder.build();
                    })
                .setResourceNameExtractor(request -> request.getParent())
                .build();
    HttpJsonCallSettings<UpdateApplicationRequest, Application> updateApplicationTransportSettings =
        HttpJsonCallSettings.<UpdateApplicationRequest, Application>newBuilder()
            .setMethodDescriptor(updateApplicationMethodDescriptor)
            .setTypeRegistry(typeRegistry)
            .setParamsExtractor(
                request -> {
                  RequestParamsBuilder builder = RequestParamsBuilder.create();
                  builder.add(
                      "application.name", String.valueOf(request.getApplication().getName()));
                  return builder.build();
                })
            .build();
    HttpJsonCallSettings<DeleteApplicationRequest, Operation> deleteApplicationTransportSettings =
        HttpJsonCallSettings.<DeleteApplicationRequest, Operation>newBuilder()
            .setMethodDescriptor(deleteApplicationMethodDescriptor)
            .setTypeRegistry(typeRegistry)
            .setParamsExtractor(
                request -> {
                  RequestParamsBuilder builder = RequestParamsBuilder.create();
                  builder.add("name", String.valueOf(request.getName()));
                  return builder.build();
                })
            .setResourceNameExtractor(request -> request.getName())
            .build();
    HttpJsonCallSettings<DeployApplicationRequest, Operation> deployApplicationTransportSettings =
        HttpJsonCallSettings.<DeployApplicationRequest, Operation>newBuilder()
            .setMethodDescriptor(deployApplicationMethodDescriptor)
            .setTypeRegistry(typeRegistry)
            .setParamsExtractor(
                request -> {
                  RequestParamsBuilder builder = RequestParamsBuilder.create();
                  builder.add("name", String.valueOf(request.getName()));
                  return builder.build();
                })
            .setResourceNameExtractor(request -> request.getName())
            .build();
    HttpJsonCallSettings<PreviewApplicationRequest, Operation> previewApplicationTransportSettings =
        HttpJsonCallSettings.<PreviewApplicationRequest, Operation>newBuilder()
            .setMethodDescriptor(previewApplicationMethodDescriptor)
            .setTypeRegistry(typeRegistry)
            .setParamsExtractor(
                request -> {
                  RequestParamsBuilder builder = RequestParamsBuilder.create();
                  builder.add("name", String.valueOf(request.getName()));
                  return builder.build();
                })
            .setResourceNameExtractor(request -> request.getName())
            .build();
    HttpJsonCallSettings<
            FetchApplicationAssessmentReportRequest, FetchApplicationAssessmentReportResponse>
        fetchApplicationAssessmentReportTransportSettings =
            HttpJsonCallSettings
                .<FetchApplicationAssessmentReportRequest, FetchApplicationAssessmentReportResponse>
                    newBuilder()
                .setMethodDescriptor(fetchApplicationAssessmentReportMethodDescriptor)
                .setTypeRegistry(typeRegistry)
                .setParamsExtractor(
                    request -> {
                      RequestParamsBuilder builder = RequestParamsBuilder.create();
                      builder.add("name", String.valueOf(request.getName()));
                      return builder.build();
                    })
                .setResourceNameExtractor(request -> request.getName())
                .build();
    HttpJsonCallSettings<GenerateApplicationAssessmentReportRequest, Operation>
        generateApplicationAssessmentReportTransportSettings =
            HttpJsonCallSettings.<GenerateApplicationAssessmentReportRequest, Operation>newBuilder()
                .setMethodDescriptor(generateApplicationAssessmentReportMethodDescriptor)
                .setTypeRegistry(typeRegistry)
                .setParamsExtractor(
                    request -> {
                      RequestParamsBuilder builder = RequestParamsBuilder.create();
                      builder.add("name", String.valueOf(request.getName()));
                      return builder.build();
                    })
                .setResourceNameExtractor(request -> request.getName())
                .build();
    HttpJsonCallSettings<GenerateApplicationTemplateAssessmentReportRequest, Operation>
        generateApplicationTemplateAssessmentReportTransportSettings =
            HttpJsonCallSettings
                .<GenerateApplicationTemplateAssessmentReportRequest, Operation>newBuilder()
                .setMethodDescriptor(generateApplicationTemplateAssessmentReportMethodDescriptor)
                .setTypeRegistry(typeRegistry)
                .setParamsExtractor(
                    request -> {
                      RequestParamsBuilder builder = RequestParamsBuilder.create();
                      builder.add("name", String.valueOf(request.getName()));
                      return builder.build();
                    })
                .setResourceNameExtractor(request -> request.getName())
                .build();
    HttpJsonCallSettings<GenerateAssessmentReportRequest, Operation>
        generateAssessmentReportTransportSettings =
            HttpJsonCallSettings.<GenerateAssessmentReportRequest, Operation>newBuilder()
                .setMethodDescriptor(generateAssessmentReportMethodDescriptor)
                .setTypeRegistry(typeRegistry)
                .setParamsExtractor(
                    request -> {
                      RequestParamsBuilder builder = RequestParamsBuilder.create();
                      builder.add("space_name", String.valueOf(request.getSpaceName()));
                      return builder.build();
                    })
                .setResourceNameExtractor(request -> request.getSpaceName())
                .build();
    HttpJsonCallSettings<GenerateTerraformPlanAssessmentReportRequest, Operation>
        generateTerraformPlanAssessmentReportTransportSettings =
            HttpJsonCallSettings
                .<GenerateTerraformPlanAssessmentReportRequest, Operation>newBuilder()
                .setMethodDescriptor(generateTerraformPlanAssessmentReportMethodDescriptor)
                .setTypeRegistry(typeRegistry)
                .setParamsExtractor(
                    request -> {
                      RequestParamsBuilder builder = RequestParamsBuilder.create();
                      builder.add("name", String.valueOf(request.getName()));
                      return builder.build();
                    })
                .setResourceNameExtractor(request -> request.getName())
                .build();
    HttpJsonCallSettings<GetPolicyRequest, Policy> getPolicyTransportSettings =
        HttpJsonCallSettings.<GetPolicyRequest, Policy>newBuilder()
            .setMethodDescriptor(getPolicyMethodDescriptor)
            .setTypeRegistry(typeRegistry)
            .setParamsExtractor(
                request -> {
                  RequestParamsBuilder builder = RequestParamsBuilder.create();
                  builder.add("name", String.valueOf(request.getName()));
                  return builder.build();
                })
            .setResourceNameExtractor(request -> request.getName())
            .build();
    HttpJsonCallSettings<ListPoliciesRequest, ListPoliciesResponse> listPoliciesTransportSettings =
        HttpJsonCallSettings.<ListPoliciesRequest, ListPoliciesResponse>newBuilder()
            .setMethodDescriptor(listPoliciesMethodDescriptor)
            .setTypeRegistry(typeRegistry)
            .setParamsExtractor(
                request -> {
                  RequestParamsBuilder builder = RequestParamsBuilder.create();
                  builder.add("parent", String.valueOf(request.getParent()));
                  return builder.build();
                })
            .setResourceNameExtractor(request -> request.getParent())
            .build();
    HttpJsonCallSettings<CreatePolicyRequest, Policy> createPolicyTransportSettings =
        HttpJsonCallSettings.<CreatePolicyRequest, Policy>newBuilder()
            .setMethodDescriptor(createPolicyMethodDescriptor)
            .setTypeRegistry(typeRegistry)
            .setParamsExtractor(
                request -> {
                  RequestParamsBuilder builder = RequestParamsBuilder.create();
                  builder.add("parent", String.valueOf(request.getParent()));
                  return builder.build();
                })
            .setResourceNameExtractor(request -> request.getParent())
            .build();
    HttpJsonCallSettings<UpdatePolicyRequest, Policy> updatePolicyTransportSettings =
        HttpJsonCallSettings.<UpdatePolicyRequest, Policy>newBuilder()
            .setMethodDescriptor(updatePolicyMethodDescriptor)
            .setTypeRegistry(typeRegistry)
            .setParamsExtractor(
                request -> {
                  RequestParamsBuilder builder = RequestParamsBuilder.create();
                  builder.add("policy.name", String.valueOf(request.getPolicy().getName()));
                  return builder.build();
                })
            .build();
    HttpJsonCallSettings<DeletePolicyRequest, Empty> deletePolicyTransportSettings =
        HttpJsonCallSettings.<DeletePolicyRequest, Empty>newBuilder()
            .setMethodDescriptor(deletePolicyMethodDescriptor)
            .setTypeRegistry(typeRegistry)
            .setParamsExtractor(
                request -> {
                  RequestParamsBuilder builder = RequestParamsBuilder.create();
                  builder.add("name", String.valueOf(request.getName()));
                  return builder.build();
                })
            .setResourceNameExtractor(request -> request.getName())
            .build();
    HttpJsonCallSettings<FetchFrameworksRequest, FetchFrameworksResponse>
        fetchFrameworksTransportSettings =
            HttpJsonCallSettings.<FetchFrameworksRequest, FetchFrameworksResponse>newBuilder()
                .setMethodDescriptor(fetchFrameworksMethodDescriptor)
                .setTypeRegistry(typeRegistry)
                .setParamsExtractor(
                    request -> {
                      RequestParamsBuilder builder = RequestParamsBuilder.create();
                      builder.add("parent", String.valueOf(request.getParent()));
                      return builder.build();
                    })
                .build();
    HttpJsonCallSettings<GenerateApplicationIaCRequest, GenerateApplicationIaCResponse>
        generateApplicationIaCTransportSettings =
            HttpJsonCallSettings
                .<GenerateApplicationIaCRequest, GenerateApplicationIaCResponse>newBuilder()
                .setMethodDescriptor(generateApplicationIaCMethodDescriptor)
                .setTypeRegistry(typeRegistry)
                .setParamsExtractor(
                    request -> {
                      RequestParamsBuilder builder = RequestParamsBuilder.create();
                      builder.add("name", String.valueOf(request.getName()));
                      return builder.build();
                    })
                .setResourceNameExtractor(request -> request.getName())
                .build();
    HttpJsonCallSettings<ExportApplicationIaCRequest, Operation>
        exportApplicationIaCTransportSettings =
            HttpJsonCallSettings.<ExportApplicationIaCRequest, Operation>newBuilder()
                .setMethodDescriptor(exportApplicationIaCMethodDescriptor)
                .setTypeRegistry(typeRegistry)
                .setParamsExtractor(
                    request -> {
                      RequestParamsBuilder builder = RequestParamsBuilder.create();
                      builder.add("name", String.valueOf(request.getName()));
                      return builder.build();
                    })
                .setResourceNameExtractor(request -> request.getName())
                .build();
    HttpJsonCallSettings<ImportApplicationTemplateIaCRequest, ImportApplicationTemplateIaCResponse>
        importApplicationTemplateIaCTransportSettings =
            HttpJsonCallSettings
                .<ImportApplicationTemplateIaCRequest, ImportApplicationTemplateIaCResponse>
                    newBuilder()
                .setMethodDescriptor(importApplicationTemplateIaCMethodDescriptor)
                .setTypeRegistry(typeRegistry)
                .setParamsExtractor(
                    request -> {
                      RequestParamsBuilder builder = RequestParamsBuilder.create();
                      builder.add("name", String.valueOf(request.getName()));
                      return builder.build();
                    })
                .setResourceNameExtractor(request -> request.getName())
                .build();
    HttpJsonCallSettings<IngestApplicationTemplateIaCRequest, Operation>
        ingestApplicationTemplateIaCTransportSettings =
            HttpJsonCallSettings.<IngestApplicationTemplateIaCRequest, Operation>newBuilder()
                .setMethodDescriptor(ingestApplicationTemplateIaCMethodDescriptor)
                .setTypeRegistry(typeRegistry)
                .setParamsExtractor(
                    request -> {
                      RequestParamsBuilder builder = RequestParamsBuilder.create();
                      builder.add("name", String.valueOf(request.getName()));
                      return builder.build();
                    })
                .setResourceNameExtractor(request -> request.getName())
                .build();
    HttpJsonCallSettings<ImportApplicationIaCRequest, ImportApplicationIaCResponse>
        importApplicationIaCTransportSettings =
            HttpJsonCallSettings
                .<ImportApplicationIaCRequest, ImportApplicationIaCResponse>newBuilder()
                .setMethodDescriptor(importApplicationIaCMethodDescriptor)
                .setTypeRegistry(typeRegistry)
                .setParamsExtractor(
                    request -> {
                      RequestParamsBuilder builder = RequestParamsBuilder.create();
                      builder.add("name", String.valueOf(request.getName()));
                      return builder.build();
                    })
                .setResourceNameExtractor(request -> request.getName())
                .build();
    HttpJsonCallSettings<RegisterAppHubApplicationResourcesRequest, Operation>
        registerAppHubApplicationResourcesTransportSettings =
            HttpJsonCallSettings.<RegisterAppHubApplicationResourcesRequest, Operation>newBuilder()
                .setMethodDescriptor(registerAppHubApplicationResourcesMethodDescriptor)
                .setTypeRegistry(typeRegistry)
                .setParamsExtractor(
                    request -> {
                      RequestParamsBuilder builder = RequestParamsBuilder.create();
                      builder.add("parent", String.valueOf(request.getParent()));
                      return builder.build();
                    })
                .setResourceNameExtractor(request -> request.getParent())
                .build();
    HttpJsonCallSettings<
            ListApplicationTemplateSystemRevisionsRequest,
            ListApplicationTemplateSystemRevisionsResponse>
        listApplicationTemplateSystemRevisionsTransportSettings =
            HttpJsonCallSettings
                .<ListApplicationTemplateSystemRevisionsRequest,
                    ListApplicationTemplateSystemRevisionsResponse>
                    newBuilder()
                .setMethodDescriptor(listApplicationTemplateSystemRevisionsMethodDescriptor)
                .setTypeRegistry(typeRegistry)
                .setParamsExtractor(
                    request -> {
                      RequestParamsBuilder builder = RequestParamsBuilder.create();
                      builder.add("parent", String.valueOf(request.getParent()));
                      return builder.build();
                    })
                .setResourceNameExtractor(request -> request.getParent())
                .build();
    HttpJsonCallSettings<
            GetApplicationTemplateSystemRevisionRequest, ApplicationTemplateSystemRevision>
        getApplicationTemplateSystemRevisionTransportSettings =
            HttpJsonCallSettings
                .<GetApplicationTemplateSystemRevisionRequest, ApplicationTemplateSystemRevision>
                    newBuilder()
                .setMethodDescriptor(getApplicationTemplateSystemRevisionMethodDescriptor)
                .setTypeRegistry(typeRegistry)
                .setParamsExtractor(
                    request -> {
                      RequestParamsBuilder builder = RequestParamsBuilder.create();
                      builder.add("name", String.valueOf(request.getName()));
                      return builder.build();
                    })
                .setResourceNameExtractor(request -> request.getName())
                .build();
    HttpJsonCallSettings<RecommendIAMRolesRequest, Operation> recommendIAMRolesTransportSettings =
        HttpJsonCallSettings.<RecommendIAMRolesRequest, Operation>newBuilder()
            .setMethodDescriptor(recommendIAMRolesMethodDescriptor)
            .setTypeRegistry(typeRegistry)
            .setParamsExtractor(
                request -> {
                  RequestParamsBuilder builder = RequestParamsBuilder.create();
                  builder.add("name", String.valueOf(request.getName()));
                  return builder.build();
                })
            .setResourceNameExtractor(request -> request.getName())
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
    HttpJsonCallSettings<SetIamPolicyRequest, com.google.iam.v1.Policy>
        setIamPolicyTransportSettings =
            HttpJsonCallSettings.<SetIamPolicyRequest, com.google.iam.v1.Policy>newBuilder()
                .setMethodDescriptor(setIamPolicyMethodDescriptor)
                .setTypeRegistry(typeRegistry)
                .setParamsExtractor(
                    request -> {
                      RequestParamsBuilder builder = RequestParamsBuilder.create();
                      builder.add("resource", String.valueOf(request.getResource()));
                      return builder.build();
                    })
                .setResourceNameExtractor(request -> request.getResource())
                .build();
    HttpJsonCallSettings<GetIamPolicyRequest, com.google.iam.v1.Policy>
        getIamPolicyTransportSettings =
            HttpJsonCallSettings.<GetIamPolicyRequest, com.google.iam.v1.Policy>newBuilder()
                .setMethodDescriptor(getIamPolicyMethodDescriptor)
                .setTypeRegistry(typeRegistry)
                .setParamsExtractor(
                    request -> {
                      RequestParamsBuilder builder = RequestParamsBuilder.create();
                      builder.add("resource", String.valueOf(request.getResource()));
                      return builder.build();
                    })
                .setResourceNameExtractor(request -> request.getResource())
                .build();
    HttpJsonCallSettings<TestIamPermissionsRequest, TestIamPermissionsResponse>
        testIamPermissionsTransportSettings =
            HttpJsonCallSettings.<TestIamPermissionsRequest, TestIamPermissionsResponse>newBuilder()
                .setMethodDescriptor(testIamPermissionsMethodDescriptor)
                .setTypeRegistry(typeRegistry)
                .setParamsExtractor(
                    request -> {
                      RequestParamsBuilder builder = RequestParamsBuilder.create();
                      builder.add("resource", String.valueOf(request.getResource()));
                      return builder.build();
                    })
                .setResourceNameExtractor(request -> request.getResource())
                .build();

    this.getSpaceCallable =
        callableFactory.createUnaryCallable(
            getSpaceTransportSettings, settings.getSpaceSettings(), clientContext);
    this.listSpacesCallable =
        callableFactory.createUnaryCallable(
            listSpacesTransportSettings, settings.listSpacesSettings(), clientContext);
    this.listSpacesPagedCallable =
        callableFactory.createPagedCallable(
            listSpacesTransportSettings, settings.listSpacesSettings(), clientContext);
    this.createSpaceCallable =
        callableFactory.createUnaryCallable(
            createSpaceTransportSettings, settings.createSpaceSettings(), clientContext);
    this.updateSpaceCallable =
        callableFactory.createUnaryCallable(
            updateSpaceTransportSettings, settings.updateSpaceSettings(), clientContext);
    this.deleteSpaceCallable =
        callableFactory.createUnaryCallable(
            deleteSpaceTransportSettings, settings.deleteSpaceSettings(), clientContext);
    this.getApplicationTemplateCallable =
        callableFactory.createUnaryCallable(
            getApplicationTemplateTransportSettings,
            settings.getApplicationTemplateSettings(),
            clientContext);
    this.listApplicationTemplatesCallable =
        callableFactory.createUnaryCallable(
            listApplicationTemplatesTransportSettings,
            settings.listApplicationTemplatesSettings(),
            clientContext);
    this.listApplicationTemplatesPagedCallable =
        callableFactory.createPagedCallable(
            listApplicationTemplatesTransportSettings,
            settings.listApplicationTemplatesSettings(),
            clientContext);
    this.createApplicationTemplateCallable =
        callableFactory.createUnaryCallable(
            createApplicationTemplateTransportSettings,
            settings.createApplicationTemplateSettings(),
            clientContext);
    this.updateApplicationTemplateCallable =
        callableFactory.createUnaryCallable(
            updateApplicationTemplateTransportSettings,
            settings.updateApplicationTemplateSettings(),
            clientContext);
    this.importApplicationTemplateCallable =
        callableFactory.createUnaryCallable(
            importApplicationTemplateTransportSettings,
            settings.importApplicationTemplateSettings(),
            clientContext);
    this.deleteApplicationTemplateCallable =
        callableFactory.createUnaryCallable(
            deleteApplicationTemplateTransportSettings,
            settings.deleteApplicationTemplateSettings(),
            clientContext);
    this.commitApplicationTemplateCallable =
        callableFactory.createUnaryCallable(
            commitApplicationTemplateTransportSettings,
            settings.commitApplicationTemplateSettings(),
            clientContext);
    this.snapshotApplicationTemplateCallable =
        callableFactory.createUnaryCallable(
            snapshotApplicationTemplateTransportSettings,
            settings.snapshotApplicationTemplateSettings(),
            clientContext);
    this.snapshotApplicationTemplateOperationCallable =
        callableFactory.createOperationCallable(
            snapshotApplicationTemplateTransportSettings,
            settings.snapshotApplicationTemplateOperationSettings(),
            clientContext,
            httpJsonOperationsStub);
    this.generateApplicationTemplateIaCCallable =
        callableFactory.createUnaryCallable(
            generateApplicationTemplateIaCTransportSettings,
            settings.generateApplicationTemplateIaCSettings(),
            clientContext);
    this.exportApplicationTemplateIaCCallable =
        callableFactory.createUnaryCallable(
            exportApplicationTemplateIaCTransportSettings,
            settings.exportApplicationTemplateIaCSettings(),
            clientContext);
    this.exportApplicationTemplateIaCOperationCallable =
        callableFactory.createOperationCallable(
            exportApplicationTemplateIaCTransportSettings,
            settings.exportApplicationTemplateIaCOperationSettings(),
            clientContext,
            httpJsonOperationsStub);
    this.generateApplicationTemplateRevisionIaCCallable =
        callableFactory.createUnaryCallable(
            generateApplicationTemplateRevisionIaCTransportSettings,
            settings.generateApplicationTemplateRevisionIaCSettings(),
            clientContext);
    this.exportApplicationTemplateRevisionIaCCallable =
        callableFactory.createUnaryCallable(
            exportApplicationTemplateRevisionIaCTransportSettings,
            settings.exportApplicationTemplateRevisionIaCSettings(),
            clientContext);
    this.exportApplicationTemplateRevisionIaCOperationCallable =
        callableFactory.createOperationCallable(
            exportApplicationTemplateRevisionIaCTransportSettings,
            settings.exportApplicationTemplateRevisionIaCOperationSettings(),
            clientContext,
            httpJsonOperationsStub);
    this.getComponentCallable =
        callableFactory.createUnaryCallable(
            getComponentTransportSettings, settings.getComponentSettings(), clientContext);
    this.listComponentsCallable =
        callableFactory.createUnaryCallable(
            listComponentsTransportSettings, settings.listComponentsSettings(), clientContext);
    this.listComponentsPagedCallable =
        callableFactory.createPagedCallable(
            listComponentsTransportSettings, settings.listComponentsSettings(), clientContext);
    this.createComponentCallable =
        callableFactory.createUnaryCallable(
            createComponentTransportSettings, settings.createComponentSettings(), clientContext);
    this.updateComponentCallable =
        callableFactory.createUnaryCallable(
            updateComponentTransportSettings, settings.updateComponentSettings(), clientContext);
    this.deleteComponentCallable =
        callableFactory.createUnaryCallable(
            deleteComponentTransportSettings, settings.deleteComponentSettings(), clientContext);
    this.getConnectionCallable =
        callableFactory.createUnaryCallable(
            getConnectionTransportSettings, settings.getConnectionSettings(), clientContext);
    this.listConnectionsCallable =
        callableFactory.createUnaryCallable(
            listConnectionsTransportSettings, settings.listConnectionsSettings(), clientContext);
    this.listConnectionsPagedCallable =
        callableFactory.createPagedCallable(
            listConnectionsTransportSettings, settings.listConnectionsSettings(), clientContext);
    this.createConnectionCallable =
        callableFactory.createUnaryCallable(
            createConnectionTransportSettings, settings.createConnectionSettings(), clientContext);
    this.updateConnectionCallable =
        callableFactory.createUnaryCallable(
            updateConnectionTransportSettings, settings.updateConnectionSettings(), clientContext);
    this.deleteConnectionCallable =
        callableFactory.createUnaryCallable(
            deleteConnectionTransportSettings, settings.deleteConnectionSettings(), clientContext);
    this.getApplicationTemplateRevisionCallable =
        callableFactory.createUnaryCallable(
            getApplicationTemplateRevisionTransportSettings,
            settings.getApplicationTemplateRevisionSettings(),
            clientContext);
    this.listApplicationTemplateRevisionsCallable =
        callableFactory.createUnaryCallable(
            listApplicationTemplateRevisionsTransportSettings,
            settings.listApplicationTemplateRevisionsSettings(),
            clientContext);
    this.listApplicationTemplateRevisionsPagedCallable =
        callableFactory.createPagedCallable(
            listApplicationTemplateRevisionsTransportSettings,
            settings.listApplicationTemplateRevisionsSettings(),
            clientContext);
    this.deleteApplicationTemplateRevisionCallable =
        callableFactory.createUnaryCallable(
            deleteApplicationTemplateRevisionTransportSettings,
            settings.deleteApplicationTemplateRevisionSettings(),
            clientContext);
    this.getCatalogCallable =
        callableFactory.createUnaryCallable(
            getCatalogTransportSettings, settings.getCatalogSettings(), clientContext);
    this.listCatalogsCallable =
        callableFactory.createUnaryCallable(
            listCatalogsTransportSettings, settings.listCatalogsSettings(), clientContext);
    this.listCatalogsPagedCallable =
        callableFactory.createPagedCallable(
            listCatalogsTransportSettings, settings.listCatalogsSettings(), clientContext);
    this.createCatalogCallable =
        callableFactory.createUnaryCallable(
            createCatalogTransportSettings, settings.createCatalogSettings(), clientContext);
    this.updateCatalogCallable =
        callableFactory.createUnaryCallable(
            updateCatalogTransportSettings, settings.updateCatalogSettings(), clientContext);
    this.deleteCatalogCallable =
        callableFactory.createUnaryCallable(
            deleteCatalogTransportSettings, settings.deleteCatalogSettings(), clientContext);
    this.deleteCatalogOperationCallable =
        callableFactory.createOperationCallable(
            deleteCatalogTransportSettings,
            settings.deleteCatalogOperationSettings(),
            clientContext,
            httpJsonOperationsStub);
    this.createCatalogTemplateCallable =
        callableFactory.createUnaryCallable(
            createCatalogTemplateTransportSettings,
            settings.createCatalogTemplateSettings(),
            clientContext);
    this.getCatalogTemplateCallable =
        callableFactory.createUnaryCallable(
            getCatalogTemplateTransportSettings,
            settings.getCatalogTemplateSettings(),
            clientContext);
    this.listCatalogTemplatesCallable =
        callableFactory.createUnaryCallable(
            listCatalogTemplatesTransportSettings,
            settings.listCatalogTemplatesSettings(),
            clientContext);
    this.listCatalogTemplatesPagedCallable =
        callableFactory.createPagedCallable(
            listCatalogTemplatesTransportSettings,
            settings.listCatalogTemplatesSettings(),
            clientContext);
    this.updateCatalogTemplateCallable =
        callableFactory.createUnaryCallable(
            updateCatalogTemplateTransportSettings,
            settings.updateCatalogTemplateSettings(),
            clientContext);
    this.deleteCatalogTemplateCallable =
        callableFactory.createUnaryCallable(
            deleteCatalogTemplateTransportSettings,
            settings.deleteCatalogTemplateSettings(),
            clientContext);
    this.deleteCatalogTemplateOperationCallable =
        callableFactory.createOperationCallable(
            deleteCatalogTemplateTransportSettings,
            settings.deleteCatalogTemplateOperationSettings(),
            clientContext,
            httpJsonOperationsStub);
    this.createShareCallable =
        callableFactory.createUnaryCallable(
            createShareTransportSettings, settings.createShareSettings(), clientContext);
    this.createShareOperationCallable =
        callableFactory.createOperationCallable(
            createShareTransportSettings,
            settings.createShareOperationSettings(),
            clientContext,
            httpJsonOperationsStub);
    this.listSharesCallable =
        callableFactory.createUnaryCallable(
            listSharesTransportSettings, settings.listSharesSettings(), clientContext);
    this.listSharesPagedCallable =
        callableFactory.createPagedCallable(
            listSharesTransportSettings, settings.listSharesSettings(), clientContext);
    this.getShareCallable =
        callableFactory.createUnaryCallable(
            getShareTransportSettings, settings.getShareSettings(), clientContext);
    this.deleteShareCallable =
        callableFactory.createUnaryCallable(
            deleteShareTransportSettings, settings.deleteShareSettings(), clientContext);
    this.deleteShareOperationCallable =
        callableFactory.createOperationCallable(
            deleteShareTransportSettings,
            settings.deleteShareOperationSettings(),
            clientContext,
            httpJsonOperationsStub);
    this.syncShareCallable =
        callableFactory.createUnaryCallable(
            syncShareTransportSettings, settings.syncShareSettings(), clientContext);
    this.syncShareOperationCallable =
        callableFactory.createOperationCallable(
            syncShareTransportSettings,
            settings.syncShareOperationSettings(),
            clientContext,
            httpJsonOperationsStub);
    this.getSharedTemplateCallable =
        callableFactory.createUnaryCallable(
            getSharedTemplateTransportSettings,
            settings.getSharedTemplateSettings(),
            clientContext);
    this.listSharedTemplatesCallable =
        callableFactory.createUnaryCallable(
            listSharedTemplatesTransportSettings,
            settings.listSharedTemplatesSettings(),
            clientContext);
    this.listSharedTemplatesPagedCallable =
        callableFactory.createPagedCallable(
            listSharedTemplatesTransportSettings,
            settings.listSharedTemplatesSettings(),
            clientContext);
    this.getSharedTemplateRevisionCallable =
        callableFactory.createUnaryCallable(
            getSharedTemplateRevisionTransportSettings,
            settings.getSharedTemplateRevisionSettings(),
            clientContext);
    this.listSharedTemplateRevisionsCallable =
        callableFactory.createUnaryCallable(
            listSharedTemplateRevisionsTransportSettings,
            settings.listSharedTemplateRevisionsSettings(),
            clientContext);
    this.listSharedTemplateRevisionsPagedCallable =
        callableFactory.createPagedCallable(
            listSharedTemplateRevisionsTransportSettings,
            settings.listSharedTemplateRevisionsSettings(),
            clientContext);
    this.createCatalogTemplateRevisionCallable =
        callableFactory.createUnaryCallable(
            createCatalogTemplateRevisionTransportSettings,
            settings.createCatalogTemplateRevisionSettings(),
            clientContext);
    this.createCatalogTemplateRevisionOperationCallable =
        callableFactory.createOperationCallable(
            createCatalogTemplateRevisionTransportSettings,
            settings.createCatalogTemplateRevisionOperationSettings(),
            clientContext,
            httpJsonOperationsStub);
    this.getCatalogTemplateRevisionCallable =
        callableFactory.createUnaryCallable(
            getCatalogTemplateRevisionTransportSettings,
            settings.getCatalogTemplateRevisionSettings(),
            clientContext);
    this.listCatalogTemplateRevisionsCallable =
        callableFactory.createUnaryCallable(
            listCatalogTemplateRevisionsTransportSettings,
            settings.listCatalogTemplateRevisionsSettings(),
            clientContext);
    this.listCatalogTemplateRevisionsPagedCallable =
        callableFactory.createPagedCallable(
            listCatalogTemplateRevisionsTransportSettings,
            settings.listCatalogTemplateRevisionsSettings(),
            clientContext);
    this.deleteCatalogTemplateRevisionCallable =
        callableFactory.createUnaryCallable(
            deleteCatalogTemplateRevisionTransportSettings,
            settings.deleteCatalogTemplateRevisionSettings(),
            clientContext);
    this.deleteCatalogTemplateRevisionOperationCallable =
        callableFactory.createOperationCallable(
            deleteCatalogTemplateRevisionTransportSettings,
            settings.deleteCatalogTemplateRevisionOperationSettings(),
            clientContext,
            httpJsonOperationsStub);
    this.createApplicationCallable =
        callableFactory.createUnaryCallable(
            createApplicationTransportSettings,
            settings.createApplicationSettings(),
            clientContext);
    this.getApplicationCallable =
        callableFactory.createUnaryCallable(
            getApplicationTransportSettings, settings.getApplicationSettings(), clientContext);
    this.listApplicationsCallable =
        callableFactory.createUnaryCallable(
            listApplicationsTransportSettings, settings.listApplicationsSettings(), clientContext);
    this.listApplicationsPagedCallable =
        callableFactory.createPagedCallable(
            listApplicationsTransportSettings, settings.listApplicationsSettings(), clientContext);
    this.updateApplicationCallable =
        callableFactory.createUnaryCallable(
            updateApplicationTransportSettings,
            settings.updateApplicationSettings(),
            clientContext);
    this.deleteApplicationCallable =
        callableFactory.createUnaryCallable(
            deleteApplicationTransportSettings,
            settings.deleteApplicationSettings(),
            clientContext);
    this.deleteApplicationOperationCallable =
        callableFactory.createOperationCallable(
            deleteApplicationTransportSettings,
            settings.deleteApplicationOperationSettings(),
            clientContext,
            httpJsonOperationsStub);
    this.deployApplicationCallable =
        callableFactory.createUnaryCallable(
            deployApplicationTransportSettings,
            settings.deployApplicationSettings(),
            clientContext);
    this.deployApplicationOperationCallable =
        callableFactory.createOperationCallable(
            deployApplicationTransportSettings,
            settings.deployApplicationOperationSettings(),
            clientContext,
            httpJsonOperationsStub);
    this.previewApplicationCallable =
        callableFactory.createUnaryCallable(
            previewApplicationTransportSettings,
            settings.previewApplicationSettings(),
            clientContext);
    this.previewApplicationOperationCallable =
        callableFactory.createOperationCallable(
            previewApplicationTransportSettings,
            settings.previewApplicationOperationSettings(),
            clientContext,
            httpJsonOperationsStub);
    this.fetchApplicationAssessmentReportCallable =
        callableFactory.createUnaryCallable(
            fetchApplicationAssessmentReportTransportSettings,
            settings.fetchApplicationAssessmentReportSettings(),
            clientContext);
    this.generateApplicationAssessmentReportCallable =
        callableFactory.createUnaryCallable(
            generateApplicationAssessmentReportTransportSettings,
            settings.generateApplicationAssessmentReportSettings(),
            clientContext);
    this.generateApplicationAssessmentReportOperationCallable =
        callableFactory.createOperationCallable(
            generateApplicationAssessmentReportTransportSettings,
            settings.generateApplicationAssessmentReportOperationSettings(),
            clientContext,
            httpJsonOperationsStub);
    this.generateApplicationTemplateAssessmentReportCallable =
        callableFactory.createUnaryCallable(
            generateApplicationTemplateAssessmentReportTransportSettings,
            settings.generateApplicationTemplateAssessmentReportSettings(),
            clientContext);
    this.generateApplicationTemplateAssessmentReportOperationCallable =
        callableFactory.createOperationCallable(
            generateApplicationTemplateAssessmentReportTransportSettings,
            settings.generateApplicationTemplateAssessmentReportOperationSettings(),
            clientContext,
            httpJsonOperationsStub);
    this.generateAssessmentReportCallable =
        callableFactory.createUnaryCallable(
            generateAssessmentReportTransportSettings,
            settings.generateAssessmentReportSettings(),
            clientContext);
    this.generateAssessmentReportOperationCallable =
        callableFactory.createOperationCallable(
            generateAssessmentReportTransportSettings,
            settings.generateAssessmentReportOperationSettings(),
            clientContext,
            httpJsonOperationsStub);
    this.generateTerraformPlanAssessmentReportCallable =
        callableFactory.createUnaryCallable(
            generateTerraformPlanAssessmentReportTransportSettings,
            settings.generateTerraformPlanAssessmentReportSettings(),
            clientContext);
    this.generateTerraformPlanAssessmentReportOperationCallable =
        callableFactory.createOperationCallable(
            generateTerraformPlanAssessmentReportTransportSettings,
            settings.generateTerraformPlanAssessmentReportOperationSettings(),
            clientContext,
            httpJsonOperationsStub);
    this.getPolicyCallable =
        callableFactory.createUnaryCallable(
            getPolicyTransportSettings, settings.getPolicySettings(), clientContext);
    this.listPoliciesCallable =
        callableFactory.createUnaryCallable(
            listPoliciesTransportSettings, settings.listPoliciesSettings(), clientContext);
    this.listPoliciesPagedCallable =
        callableFactory.createPagedCallable(
            listPoliciesTransportSettings, settings.listPoliciesSettings(), clientContext);
    this.createPolicyCallable =
        callableFactory.createUnaryCallable(
            createPolicyTransportSettings, settings.createPolicySettings(), clientContext);
    this.updatePolicyCallable =
        callableFactory.createUnaryCallable(
            updatePolicyTransportSettings, settings.updatePolicySettings(), clientContext);
    this.deletePolicyCallable =
        callableFactory.createUnaryCallable(
            deletePolicyTransportSettings, settings.deletePolicySettings(), clientContext);
    this.fetchFrameworksCallable =
        callableFactory.createUnaryCallable(
            fetchFrameworksTransportSettings, settings.fetchFrameworksSettings(), clientContext);
    this.fetchFrameworksPagedCallable =
        callableFactory.createPagedCallable(
            fetchFrameworksTransportSettings, settings.fetchFrameworksSettings(), clientContext);
    this.generateApplicationIaCCallable =
        callableFactory.createUnaryCallable(
            generateApplicationIaCTransportSettings,
            settings.generateApplicationIaCSettings(),
            clientContext);
    this.exportApplicationIaCCallable =
        callableFactory.createUnaryCallable(
            exportApplicationIaCTransportSettings,
            settings.exportApplicationIaCSettings(),
            clientContext);
    this.exportApplicationIaCOperationCallable =
        callableFactory.createOperationCallable(
            exportApplicationIaCTransportSettings,
            settings.exportApplicationIaCOperationSettings(),
            clientContext,
            httpJsonOperationsStub);
    this.importApplicationTemplateIaCCallable =
        callableFactory.createUnaryCallable(
            importApplicationTemplateIaCTransportSettings,
            settings.importApplicationTemplateIaCSettings(),
            clientContext);
    this.ingestApplicationTemplateIaCCallable =
        callableFactory.createUnaryCallable(
            ingestApplicationTemplateIaCTransportSettings,
            settings.ingestApplicationTemplateIaCSettings(),
            clientContext);
    this.ingestApplicationTemplateIaCOperationCallable =
        callableFactory.createOperationCallable(
            ingestApplicationTemplateIaCTransportSettings,
            settings.ingestApplicationTemplateIaCOperationSettings(),
            clientContext,
            httpJsonOperationsStub);
    this.importApplicationIaCCallable =
        callableFactory.createUnaryCallable(
            importApplicationIaCTransportSettings,
            settings.importApplicationIaCSettings(),
            clientContext);
    this.registerAppHubApplicationResourcesCallable =
        callableFactory.createUnaryCallable(
            registerAppHubApplicationResourcesTransportSettings,
            settings.registerAppHubApplicationResourcesSettings(),
            clientContext);
    this.registerAppHubApplicationResourcesOperationCallable =
        callableFactory.createOperationCallable(
            registerAppHubApplicationResourcesTransportSettings,
            settings.registerAppHubApplicationResourcesOperationSettings(),
            clientContext,
            httpJsonOperationsStub);
    this.listApplicationTemplateSystemRevisionsCallable =
        callableFactory.createUnaryCallable(
            listApplicationTemplateSystemRevisionsTransportSettings,
            settings.listApplicationTemplateSystemRevisionsSettings(),
            clientContext);
    this.listApplicationTemplateSystemRevisionsPagedCallable =
        callableFactory.createPagedCallable(
            listApplicationTemplateSystemRevisionsTransportSettings,
            settings.listApplicationTemplateSystemRevisionsSettings(),
            clientContext);
    this.getApplicationTemplateSystemRevisionCallable =
        callableFactory.createUnaryCallable(
            getApplicationTemplateSystemRevisionTransportSettings,
            settings.getApplicationTemplateSystemRevisionSettings(),
            clientContext);
    this.recommendIAMRolesCallable =
        callableFactory.createUnaryCallable(
            recommendIAMRolesTransportSettings,
            settings.recommendIAMRolesSettings(),
            clientContext);
    this.recommendIAMRolesOperationCallable =
        callableFactory.createOperationCallable(
            recommendIAMRolesTransportSettings,
            settings.recommendIAMRolesOperationSettings(),
            clientContext,
            httpJsonOperationsStub);
    this.listLocationsCallable =
        callableFactory.createUnaryCallable(
            listLocationsTransportSettings, settings.listLocationsSettings(), clientContext);
    this.listLocationsPagedCallable =
        callableFactory.createPagedCallable(
            listLocationsTransportSettings, settings.listLocationsSettings(), clientContext);
    this.getLocationCallable =
        callableFactory.createUnaryCallable(
            getLocationTransportSettings, settings.getLocationSettings(), clientContext);
    this.setIamPolicyCallable =
        callableFactory.createUnaryCallable(
            setIamPolicyTransportSettings, settings.setIamPolicySettings(), clientContext);
    this.getIamPolicyCallable =
        callableFactory.createUnaryCallable(
            getIamPolicyTransportSettings, settings.getIamPolicySettings(), clientContext);
    this.testIamPermissionsCallable =
        callableFactory.createUnaryCallable(
            testIamPermissionsTransportSettings,
            settings.testIamPermissionsSettings(),
            clientContext);

    this.backgroundResources =
        new BackgroundResourceAggregation(clientContext.getBackgroundResources());
  }

  @InternalApi
  public static List<ApiMethodDescriptor> getMethodDescriptors() {
    List<ApiMethodDescriptor> methodDescriptors = new ArrayList<>();
    methodDescriptors.add(getSpaceMethodDescriptor);
    methodDescriptors.add(listSpacesMethodDescriptor);
    methodDescriptors.add(createSpaceMethodDescriptor);
    methodDescriptors.add(updateSpaceMethodDescriptor);
    methodDescriptors.add(deleteSpaceMethodDescriptor);
    methodDescriptors.add(getApplicationTemplateMethodDescriptor);
    methodDescriptors.add(listApplicationTemplatesMethodDescriptor);
    methodDescriptors.add(createApplicationTemplateMethodDescriptor);
    methodDescriptors.add(updateApplicationTemplateMethodDescriptor);
    methodDescriptors.add(importApplicationTemplateMethodDescriptor);
    methodDescriptors.add(deleteApplicationTemplateMethodDescriptor);
    methodDescriptors.add(commitApplicationTemplateMethodDescriptor);
    methodDescriptors.add(snapshotApplicationTemplateMethodDescriptor);
    methodDescriptors.add(generateApplicationTemplateIaCMethodDescriptor);
    methodDescriptors.add(exportApplicationTemplateIaCMethodDescriptor);
    methodDescriptors.add(generateApplicationTemplateRevisionIaCMethodDescriptor);
    methodDescriptors.add(exportApplicationTemplateRevisionIaCMethodDescriptor);
    methodDescriptors.add(getComponentMethodDescriptor);
    methodDescriptors.add(listComponentsMethodDescriptor);
    methodDescriptors.add(createComponentMethodDescriptor);
    methodDescriptors.add(updateComponentMethodDescriptor);
    methodDescriptors.add(deleteComponentMethodDescriptor);
    methodDescriptors.add(getConnectionMethodDescriptor);
    methodDescriptors.add(listConnectionsMethodDescriptor);
    methodDescriptors.add(createConnectionMethodDescriptor);
    methodDescriptors.add(updateConnectionMethodDescriptor);
    methodDescriptors.add(deleteConnectionMethodDescriptor);
    methodDescriptors.add(getApplicationTemplateRevisionMethodDescriptor);
    methodDescriptors.add(listApplicationTemplateRevisionsMethodDescriptor);
    methodDescriptors.add(deleteApplicationTemplateRevisionMethodDescriptor);
    methodDescriptors.add(getCatalogMethodDescriptor);
    methodDescriptors.add(listCatalogsMethodDescriptor);
    methodDescriptors.add(createCatalogMethodDescriptor);
    methodDescriptors.add(updateCatalogMethodDescriptor);
    methodDescriptors.add(deleteCatalogMethodDescriptor);
    methodDescriptors.add(createCatalogTemplateMethodDescriptor);
    methodDescriptors.add(getCatalogTemplateMethodDescriptor);
    methodDescriptors.add(listCatalogTemplatesMethodDescriptor);
    methodDescriptors.add(updateCatalogTemplateMethodDescriptor);
    methodDescriptors.add(deleteCatalogTemplateMethodDescriptor);
    methodDescriptors.add(createShareMethodDescriptor);
    methodDescriptors.add(listSharesMethodDescriptor);
    methodDescriptors.add(getShareMethodDescriptor);
    methodDescriptors.add(deleteShareMethodDescriptor);
    methodDescriptors.add(syncShareMethodDescriptor);
    methodDescriptors.add(getSharedTemplateMethodDescriptor);
    methodDescriptors.add(listSharedTemplatesMethodDescriptor);
    methodDescriptors.add(getSharedTemplateRevisionMethodDescriptor);
    methodDescriptors.add(listSharedTemplateRevisionsMethodDescriptor);
    methodDescriptors.add(createCatalogTemplateRevisionMethodDescriptor);
    methodDescriptors.add(getCatalogTemplateRevisionMethodDescriptor);
    methodDescriptors.add(listCatalogTemplateRevisionsMethodDescriptor);
    methodDescriptors.add(deleteCatalogTemplateRevisionMethodDescriptor);
    methodDescriptors.add(createApplicationMethodDescriptor);
    methodDescriptors.add(getApplicationMethodDescriptor);
    methodDescriptors.add(listApplicationsMethodDescriptor);
    methodDescriptors.add(updateApplicationMethodDescriptor);
    methodDescriptors.add(deleteApplicationMethodDescriptor);
    methodDescriptors.add(deployApplicationMethodDescriptor);
    methodDescriptors.add(previewApplicationMethodDescriptor);
    methodDescriptors.add(fetchApplicationAssessmentReportMethodDescriptor);
    methodDescriptors.add(generateApplicationAssessmentReportMethodDescriptor);
    methodDescriptors.add(generateApplicationTemplateAssessmentReportMethodDescriptor);
    methodDescriptors.add(generateAssessmentReportMethodDescriptor);
    methodDescriptors.add(generateTerraformPlanAssessmentReportMethodDescriptor);
    methodDescriptors.add(getPolicyMethodDescriptor);
    methodDescriptors.add(listPoliciesMethodDescriptor);
    methodDescriptors.add(createPolicyMethodDescriptor);
    methodDescriptors.add(updatePolicyMethodDescriptor);
    methodDescriptors.add(deletePolicyMethodDescriptor);
    methodDescriptors.add(fetchFrameworksMethodDescriptor);
    methodDescriptors.add(generateApplicationIaCMethodDescriptor);
    methodDescriptors.add(exportApplicationIaCMethodDescriptor);
    methodDescriptors.add(importApplicationTemplateIaCMethodDescriptor);
    methodDescriptors.add(ingestApplicationTemplateIaCMethodDescriptor);
    methodDescriptors.add(importApplicationIaCMethodDescriptor);
    methodDescriptors.add(registerAppHubApplicationResourcesMethodDescriptor);
    methodDescriptors.add(listApplicationTemplateSystemRevisionsMethodDescriptor);
    methodDescriptors.add(getApplicationTemplateSystemRevisionMethodDescriptor);
    methodDescriptors.add(recommendIAMRolesMethodDescriptor);
    methodDescriptors.add(listLocationsMethodDescriptor);
    methodDescriptors.add(getLocationMethodDescriptor);
    methodDescriptors.add(setIamPolicyMethodDescriptor);
    methodDescriptors.add(getIamPolicyMethodDescriptor);
    methodDescriptors.add(testIamPermissionsMethodDescriptor);
    return methodDescriptors;
  }

  public HttpJsonOperationsStub getHttpJsonOperationsStub() {
    return httpJsonOperationsStub;
  }

  @Override
  public UnaryCallable<GetSpaceRequest, Space> getSpaceCallable() {
    return getSpaceCallable;
  }

  @Override
  public UnaryCallable<ListSpacesRequest, ListSpacesResponse> listSpacesCallable() {
    return listSpacesCallable;
  }

  @Override
  public UnaryCallable<ListSpacesRequest, ListSpacesPagedResponse> listSpacesPagedCallable() {
    return listSpacesPagedCallable;
  }

  @Override
  public UnaryCallable<CreateSpaceRequest, Space> createSpaceCallable() {
    return createSpaceCallable;
  }

  @Override
  public UnaryCallable<UpdateSpaceRequest, Space> updateSpaceCallable() {
    return updateSpaceCallable;
  }

  @Override
  public UnaryCallable<DeleteSpaceRequest, Empty> deleteSpaceCallable() {
    return deleteSpaceCallable;
  }

  @Override
  public UnaryCallable<GetApplicationTemplateRequest, ApplicationTemplate>
      getApplicationTemplateCallable() {
    return getApplicationTemplateCallable;
  }

  @Override
  public UnaryCallable<ListApplicationTemplatesRequest, ListApplicationTemplatesResponse>
      listApplicationTemplatesCallable() {
    return listApplicationTemplatesCallable;
  }

  @Override
  public UnaryCallable<ListApplicationTemplatesRequest, ListApplicationTemplatesPagedResponse>
      listApplicationTemplatesPagedCallable() {
    return listApplicationTemplatesPagedCallable;
  }

  @Override
  public UnaryCallable<CreateApplicationTemplateRequest, ApplicationTemplate>
      createApplicationTemplateCallable() {
    return createApplicationTemplateCallable;
  }

  @Override
  public UnaryCallable<UpdateApplicationTemplateRequest, ApplicationTemplate>
      updateApplicationTemplateCallable() {
    return updateApplicationTemplateCallable;
  }

  @Override
  public UnaryCallable<ImportApplicationTemplateRequest, ApplicationTemplate>
      importApplicationTemplateCallable() {
    return importApplicationTemplateCallable;
  }

  @Override
  public UnaryCallable<DeleteApplicationTemplateRequest, Empty>
      deleteApplicationTemplateCallable() {
    return deleteApplicationTemplateCallable;
  }

  @Override
  public UnaryCallable<CommitApplicationTemplateRequest, ApplicationTemplateRevision>
      commitApplicationTemplateCallable() {
    return commitApplicationTemplateCallable;
  }

  @Override
  public UnaryCallable<SnapshotApplicationTemplateRequest, Operation>
      snapshotApplicationTemplateCallable() {
    return snapshotApplicationTemplateCallable;
  }

  @Override
  public OperationCallable<
          SnapshotApplicationTemplateRequest,
          SnapshotApplicationTemplateResponse,
          OperationMetadata>
      snapshotApplicationTemplateOperationCallable() {
    return snapshotApplicationTemplateOperationCallable;
  }

  @Override
  public UnaryCallable<
          GenerateApplicationTemplateIaCRequest, GenerateApplicationTemplateIaCResponse>
      generateApplicationTemplateIaCCallable() {
    return generateApplicationTemplateIaCCallable;
  }

  @Override
  public UnaryCallable<ExportApplicationTemplateIaCRequest, Operation>
      exportApplicationTemplateIaCCallable() {
    return exportApplicationTemplateIaCCallable;
  }

  @Override
  public OperationCallable<
          ExportApplicationTemplateIaCRequest,
          ExportApplicationTemplateIaCResponse,
          OperationMetadata>
      exportApplicationTemplateIaCOperationCallable() {
    return exportApplicationTemplateIaCOperationCallable;
  }

  @Override
  public UnaryCallable<
          GenerateApplicationTemplateRevisionIaCRequest,
          GenerateApplicationTemplateRevisionIaCResponse>
      generateApplicationTemplateRevisionIaCCallable() {
    return generateApplicationTemplateRevisionIaCCallable;
  }

  @Override
  public UnaryCallable<ExportApplicationTemplateRevisionIaCRequest, Operation>
      exportApplicationTemplateRevisionIaCCallable() {
    return exportApplicationTemplateRevisionIaCCallable;
  }

  @Override
  public OperationCallable<
          ExportApplicationTemplateRevisionIaCRequest,
          ExportApplicationTemplateRevisionIaCResponse,
          OperationMetadata>
      exportApplicationTemplateRevisionIaCOperationCallable() {
    return exportApplicationTemplateRevisionIaCOperationCallable;
  }

  @Override
  public UnaryCallable<GetComponentRequest, Component> getComponentCallable() {
    return getComponentCallable;
  }

  @Override
  public UnaryCallable<ListComponentsRequest, ListComponentsResponse> listComponentsCallable() {
    return listComponentsCallable;
  }

  @Override
  public UnaryCallable<ListComponentsRequest, ListComponentsPagedResponse>
      listComponentsPagedCallable() {
    return listComponentsPagedCallable;
  }

  @Override
  public UnaryCallable<CreateComponentRequest, Component> createComponentCallable() {
    return createComponentCallable;
  }

  @Override
  public UnaryCallable<UpdateComponentRequest, Component> updateComponentCallable() {
    return updateComponentCallable;
  }

  @Override
  public UnaryCallable<DeleteComponentRequest, Empty> deleteComponentCallable() {
    return deleteComponentCallable;
  }

  @Override
  public UnaryCallable<GetConnectionRequest, Connection> getConnectionCallable() {
    return getConnectionCallable;
  }

  @Override
  public UnaryCallable<ListConnectionsRequest, ListConnectionsResponse> listConnectionsCallable() {
    return listConnectionsCallable;
  }

  @Override
  public UnaryCallable<ListConnectionsRequest, ListConnectionsPagedResponse>
      listConnectionsPagedCallable() {
    return listConnectionsPagedCallable;
  }

  @Override
  public UnaryCallable<CreateConnectionRequest, Connection> createConnectionCallable() {
    return createConnectionCallable;
  }

  @Override
  public UnaryCallable<UpdateConnectionRequest, Connection> updateConnectionCallable() {
    return updateConnectionCallable;
  }

  @Override
  public UnaryCallable<DeleteConnectionRequest, Empty> deleteConnectionCallable() {
    return deleteConnectionCallable;
  }

  @Override
  public UnaryCallable<GetApplicationTemplateRevisionRequest, ApplicationTemplateRevision>
      getApplicationTemplateRevisionCallable() {
    return getApplicationTemplateRevisionCallable;
  }

  @Override
  public UnaryCallable<
          ListApplicationTemplateRevisionsRequest, ListApplicationTemplateRevisionsResponse>
      listApplicationTemplateRevisionsCallable() {
    return listApplicationTemplateRevisionsCallable;
  }

  @Override
  public UnaryCallable<
          ListApplicationTemplateRevisionsRequest, ListApplicationTemplateRevisionsPagedResponse>
      listApplicationTemplateRevisionsPagedCallable() {
    return listApplicationTemplateRevisionsPagedCallable;
  }

  @Override
  public UnaryCallable<DeleteApplicationTemplateRevisionRequest, Empty>
      deleteApplicationTemplateRevisionCallable() {
    return deleteApplicationTemplateRevisionCallable;
  }

  @Override
  public UnaryCallable<GetCatalogRequest, Catalog> getCatalogCallable() {
    return getCatalogCallable;
  }

  @Override
  public UnaryCallable<ListCatalogsRequest, ListCatalogsResponse> listCatalogsCallable() {
    return listCatalogsCallable;
  }

  @Override
  public UnaryCallable<ListCatalogsRequest, ListCatalogsPagedResponse> listCatalogsPagedCallable() {
    return listCatalogsPagedCallable;
  }

  @Override
  public UnaryCallable<CreateCatalogRequest, Catalog> createCatalogCallable() {
    return createCatalogCallable;
  }

  @Override
  public UnaryCallable<UpdateCatalogRequest, Catalog> updateCatalogCallable() {
    return updateCatalogCallable;
  }

  @Override
  public UnaryCallable<DeleteCatalogRequest, Operation> deleteCatalogCallable() {
    return deleteCatalogCallable;
  }

  @Override
  public OperationCallable<DeleteCatalogRequest, Empty, OperationMetadata>
      deleteCatalogOperationCallable() {
    return deleteCatalogOperationCallable;
  }

  @Override
  public UnaryCallable<CreateCatalogTemplateRequest, CatalogTemplate>
      createCatalogTemplateCallable() {
    return createCatalogTemplateCallable;
  }

  @Override
  public UnaryCallable<GetCatalogTemplateRequest, CatalogTemplate> getCatalogTemplateCallable() {
    return getCatalogTemplateCallable;
  }

  @Override
  public UnaryCallable<ListCatalogTemplatesRequest, ListCatalogTemplatesResponse>
      listCatalogTemplatesCallable() {
    return listCatalogTemplatesCallable;
  }

  @Override
  public UnaryCallable<ListCatalogTemplatesRequest, ListCatalogTemplatesPagedResponse>
      listCatalogTemplatesPagedCallable() {
    return listCatalogTemplatesPagedCallable;
  }

  @Override
  public UnaryCallable<UpdateCatalogTemplateRequest, CatalogTemplate>
      updateCatalogTemplateCallable() {
    return updateCatalogTemplateCallable;
  }

  @Override
  public UnaryCallable<DeleteCatalogTemplateRequest, Operation> deleteCatalogTemplateCallable() {
    return deleteCatalogTemplateCallable;
  }

  @Override
  public OperationCallable<DeleteCatalogTemplateRequest, Empty, OperationMetadata>
      deleteCatalogTemplateOperationCallable() {
    return deleteCatalogTemplateOperationCallable;
  }

  @Override
  public UnaryCallable<CreateShareRequest, Operation> createShareCallable() {
    return createShareCallable;
  }

  @Override
  public OperationCallable<CreateShareRequest, Share, OperationMetadata>
      createShareOperationCallable() {
    return createShareOperationCallable;
  }

  @Override
  public UnaryCallable<ListSharesRequest, ListSharesResponse> listSharesCallable() {
    return listSharesCallable;
  }

  @Override
  public UnaryCallable<ListSharesRequest, ListSharesPagedResponse> listSharesPagedCallable() {
    return listSharesPagedCallable;
  }

  @Override
  public UnaryCallable<GetShareRequest, Share> getShareCallable() {
    return getShareCallable;
  }

  @Override
  public UnaryCallable<DeleteShareRequest, Operation> deleteShareCallable() {
    return deleteShareCallable;
  }

  @Override
  public OperationCallable<DeleteShareRequest, Empty, OperationMetadata>
      deleteShareOperationCallable() {
    return deleteShareOperationCallable;
  }

  @Override
  public UnaryCallable<SyncShareRequest, Operation> syncShareCallable() {
    return syncShareCallable;
  }

  @Override
  public OperationCallable<SyncShareRequest, Share, OperationMetadata>
      syncShareOperationCallable() {
    return syncShareOperationCallable;
  }

  @Override
  public UnaryCallable<GetSharedTemplateRequest, SharedTemplate> getSharedTemplateCallable() {
    return getSharedTemplateCallable;
  }

  @Override
  public UnaryCallable<ListSharedTemplatesRequest, ListSharedTemplatesResponse>
      listSharedTemplatesCallable() {
    return listSharedTemplatesCallable;
  }

  @Override
  public UnaryCallable<ListSharedTemplatesRequest, ListSharedTemplatesPagedResponse>
      listSharedTemplatesPagedCallable() {
    return listSharedTemplatesPagedCallable;
  }

  @Override
  public UnaryCallable<GetSharedTemplateRevisionRequest, SharedTemplateRevision>
      getSharedTemplateRevisionCallable() {
    return getSharedTemplateRevisionCallable;
  }

  @Override
  public UnaryCallable<ListSharedTemplateRevisionsRequest, ListSharedTemplateRevisionsResponse>
      listSharedTemplateRevisionsCallable() {
    return listSharedTemplateRevisionsCallable;
  }

  @Override
  public UnaryCallable<ListSharedTemplateRevisionsRequest, ListSharedTemplateRevisionsPagedResponse>
      listSharedTemplateRevisionsPagedCallable() {
    return listSharedTemplateRevisionsPagedCallable;
  }

  @Override
  public UnaryCallable<CreateCatalogTemplateRevisionRequest, Operation>
      createCatalogTemplateRevisionCallable() {
    return createCatalogTemplateRevisionCallable;
  }

  @Override
  public OperationCallable<
          CreateCatalogTemplateRevisionRequest, CatalogTemplateRevision, OperationMetadata>
      createCatalogTemplateRevisionOperationCallable() {
    return createCatalogTemplateRevisionOperationCallable;
  }

  @Override
  public UnaryCallable<GetCatalogTemplateRevisionRequest, CatalogTemplateRevision>
      getCatalogTemplateRevisionCallable() {
    return getCatalogTemplateRevisionCallable;
  }

  @Override
  public UnaryCallable<ListCatalogTemplateRevisionsRequest, ListCatalogTemplateRevisionsResponse>
      listCatalogTemplateRevisionsCallable() {
    return listCatalogTemplateRevisionsCallable;
  }

  @Override
  public UnaryCallable<
          ListCatalogTemplateRevisionsRequest, ListCatalogTemplateRevisionsPagedResponse>
      listCatalogTemplateRevisionsPagedCallable() {
    return listCatalogTemplateRevisionsPagedCallable;
  }

  @Override
  public UnaryCallable<DeleteCatalogTemplateRevisionRequest, Operation>
      deleteCatalogTemplateRevisionCallable() {
    return deleteCatalogTemplateRevisionCallable;
  }

  @Override
  public OperationCallable<DeleteCatalogTemplateRevisionRequest, Empty, OperationMetadata>
      deleteCatalogTemplateRevisionOperationCallable() {
    return deleteCatalogTemplateRevisionOperationCallable;
  }

  @Override
  public UnaryCallable<CreateApplicationRequest, Application> createApplicationCallable() {
    return createApplicationCallable;
  }

  @Override
  public UnaryCallable<GetApplicationRequest, Application> getApplicationCallable() {
    return getApplicationCallable;
  }

  @Override
  public UnaryCallable<ListApplicationsRequest, ListApplicationsResponse>
      listApplicationsCallable() {
    return listApplicationsCallable;
  }

  @Override
  public UnaryCallable<ListApplicationsRequest, ListApplicationsPagedResponse>
      listApplicationsPagedCallable() {
    return listApplicationsPagedCallable;
  }

  @Override
  public UnaryCallable<UpdateApplicationRequest, Application> updateApplicationCallable() {
    return updateApplicationCallable;
  }

  @Override
  public UnaryCallable<DeleteApplicationRequest, Operation> deleteApplicationCallable() {
    return deleteApplicationCallable;
  }

  @Override
  public OperationCallable<DeleteApplicationRequest, Empty, OperationMetadata>
      deleteApplicationOperationCallable() {
    return deleteApplicationOperationCallable;
  }

  @Override
  public UnaryCallable<DeployApplicationRequest, Operation> deployApplicationCallable() {
    return deployApplicationCallable;
  }

  @Override
  public OperationCallable<DeployApplicationRequest, DeployApplicationResponse, OperationMetadata>
      deployApplicationOperationCallable() {
    return deployApplicationOperationCallable;
  }

  @Override
  public UnaryCallable<PreviewApplicationRequest, Operation> previewApplicationCallable() {
    return previewApplicationCallable;
  }

  @Override
  public OperationCallable<PreviewApplicationRequest, PreviewApplicationResponse, OperationMetadata>
      previewApplicationOperationCallable() {
    return previewApplicationOperationCallable;
  }

  @Override
  public UnaryCallable<
          FetchApplicationAssessmentReportRequest, FetchApplicationAssessmentReportResponse>
      fetchApplicationAssessmentReportCallable() {
    return fetchApplicationAssessmentReportCallable;
  }

  @Override
  public UnaryCallable<GenerateApplicationAssessmentReportRequest, Operation>
      generateApplicationAssessmentReportCallable() {
    return generateApplicationAssessmentReportCallable;
  }

  @Override
  public OperationCallable<
          GenerateApplicationAssessmentReportRequest,
          GenerateApplicationAssessmentReportResponse,
          OperationMetadata>
      generateApplicationAssessmentReportOperationCallable() {
    return generateApplicationAssessmentReportOperationCallable;
  }

  @Override
  public UnaryCallable<GenerateApplicationTemplateAssessmentReportRequest, Operation>
      generateApplicationTemplateAssessmentReportCallable() {
    return generateApplicationTemplateAssessmentReportCallable;
  }

  @Override
  public OperationCallable<
          GenerateApplicationTemplateAssessmentReportRequest,
          GenerateApplicationTemplateAssessmentReportResponse,
          OperationMetadata>
      generateApplicationTemplateAssessmentReportOperationCallable() {
    return generateApplicationTemplateAssessmentReportOperationCallable;
  }

  @Override
  public UnaryCallable<GenerateAssessmentReportRequest, Operation>
      generateAssessmentReportCallable() {
    return generateAssessmentReportCallable;
  }

  @Override
  public OperationCallable<
          GenerateAssessmentReportRequest, GenerateAssessmentReportResponse, OperationMetadata>
      generateAssessmentReportOperationCallable() {
    return generateAssessmentReportOperationCallable;
  }

  @Override
  public UnaryCallable<GenerateTerraformPlanAssessmentReportRequest, Operation>
      generateTerraformPlanAssessmentReportCallable() {
    return generateTerraformPlanAssessmentReportCallable;
  }

  @Override
  public OperationCallable<
          GenerateTerraformPlanAssessmentReportRequest,
          GenerateTerraformPlanAssessmentReportResponse,
          OperationMetadata>
      generateTerraformPlanAssessmentReportOperationCallable() {
    return generateTerraformPlanAssessmentReportOperationCallable;
  }

  @Override
  public UnaryCallable<GetPolicyRequest, Policy> getPolicyCallable() {
    return getPolicyCallable;
  }

  @Override
  public UnaryCallable<ListPoliciesRequest, ListPoliciesResponse> listPoliciesCallable() {
    return listPoliciesCallable;
  }

  @Override
  public UnaryCallable<ListPoliciesRequest, ListPoliciesPagedResponse> listPoliciesPagedCallable() {
    return listPoliciesPagedCallable;
  }

  @Override
  public UnaryCallable<CreatePolicyRequest, Policy> createPolicyCallable() {
    return createPolicyCallable;
  }

  @Override
  public UnaryCallable<UpdatePolicyRequest, Policy> updatePolicyCallable() {
    return updatePolicyCallable;
  }

  @Override
  public UnaryCallable<DeletePolicyRequest, Empty> deletePolicyCallable() {
    return deletePolicyCallable;
  }

  @Override
  public UnaryCallable<FetchFrameworksRequest, FetchFrameworksResponse> fetchFrameworksCallable() {
    return fetchFrameworksCallable;
  }

  @Override
  public UnaryCallable<FetchFrameworksRequest, FetchFrameworksPagedResponse>
      fetchFrameworksPagedCallable() {
    return fetchFrameworksPagedCallable;
  }

  @Override
  public UnaryCallable<GenerateApplicationIaCRequest, GenerateApplicationIaCResponse>
      generateApplicationIaCCallable() {
    return generateApplicationIaCCallable;
  }

  @Override
  public UnaryCallable<ExportApplicationIaCRequest, Operation> exportApplicationIaCCallable() {
    return exportApplicationIaCCallable;
  }

  @Override
  public OperationCallable<
          ExportApplicationIaCRequest, ExportApplicationIaCResponse, OperationMetadata>
      exportApplicationIaCOperationCallable() {
    return exportApplicationIaCOperationCallable;
  }

  @Override
  public UnaryCallable<ImportApplicationTemplateIaCRequest, ImportApplicationTemplateIaCResponse>
      importApplicationTemplateIaCCallable() {
    return importApplicationTemplateIaCCallable;
  }

  @Override
  public UnaryCallable<IngestApplicationTemplateIaCRequest, Operation>
      ingestApplicationTemplateIaCCallable() {
    return ingestApplicationTemplateIaCCallable;
  }

  @Override
  public OperationCallable<
          IngestApplicationTemplateIaCRequest,
          IngestApplicationTemplateIaCResponse,
          OperationMetadata>
      ingestApplicationTemplateIaCOperationCallable() {
    return ingestApplicationTemplateIaCOperationCallable;
  }

  @Override
  public UnaryCallable<ImportApplicationIaCRequest, ImportApplicationIaCResponse>
      importApplicationIaCCallable() {
    return importApplicationIaCCallable;
  }

  @Override
  public UnaryCallable<RegisterAppHubApplicationResourcesRequest, Operation>
      registerAppHubApplicationResourcesCallable() {
    return registerAppHubApplicationResourcesCallable;
  }

  @Override
  public OperationCallable<
          RegisterAppHubApplicationResourcesRequest,
          RegisterAppHubApplicationResourcesResponse,
          OperationMetadata>
      registerAppHubApplicationResourcesOperationCallable() {
    return registerAppHubApplicationResourcesOperationCallable;
  }

  @Override
  public UnaryCallable<
          ListApplicationTemplateSystemRevisionsRequest,
          ListApplicationTemplateSystemRevisionsResponse>
      listApplicationTemplateSystemRevisionsCallable() {
    return listApplicationTemplateSystemRevisionsCallable;
  }

  @Override
  public UnaryCallable<
          ListApplicationTemplateSystemRevisionsRequest,
          ListApplicationTemplateSystemRevisionsPagedResponse>
      listApplicationTemplateSystemRevisionsPagedCallable() {
    return listApplicationTemplateSystemRevisionsPagedCallable;
  }

  @Override
  public UnaryCallable<
          GetApplicationTemplateSystemRevisionRequest, ApplicationTemplateSystemRevision>
      getApplicationTemplateSystemRevisionCallable() {
    return getApplicationTemplateSystemRevisionCallable;
  }

  @Override
  public UnaryCallable<RecommendIAMRolesRequest, Operation> recommendIAMRolesCallable() {
    return recommendIAMRolesCallable;
  }

  @Override
  public OperationCallable<RecommendIAMRolesRequest, RecommendIAMRolesResponse, OperationMetadata>
      recommendIAMRolesOperationCallable() {
    return recommendIAMRolesOperationCallable;
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
  public UnaryCallable<SetIamPolicyRequest, com.google.iam.v1.Policy> setIamPolicyCallable() {
    return setIamPolicyCallable;
  }

  @Override
  public UnaryCallable<GetIamPolicyRequest, com.google.iam.v1.Policy> getIamPolicyCallable() {
    return getIamPolicyCallable;
  }

  @Override
  public UnaryCallable<TestIamPermissionsRequest, TestIamPermissionsResponse>
      testIamPermissionsCallable() {
    return testIamPermissionsCallable;
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
