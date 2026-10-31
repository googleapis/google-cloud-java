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

import com.google.api.gax.core.BackgroundResource;
import com.google.api.gax.core.BackgroundResourceAggregation;
import com.google.api.gax.grpc.GrpcCallSettings;
import com.google.api.gax.grpc.GrpcStubCallableFactory;
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
import com.google.iam.v1.GetIamPolicyRequest;
import com.google.iam.v1.SetIamPolicyRequest;
import com.google.iam.v1.TestIamPermissionsRequest;
import com.google.iam.v1.TestIamPermissionsResponse;
import com.google.longrunning.Operation;
import com.google.longrunning.stub.GrpcOperationsStub;
import com.google.protobuf.Empty;
import io.grpc.MethodDescriptor;
import io.grpc.protobuf.ProtoUtils;
import java.io.IOException;
import java.util.concurrent.TimeUnit;
import javax.annotation.Generated;
import org.jspecify.annotations.NullMarked;

// AUTO-GENERATED DOCUMENTATION AND CLASS.
/**
 * gRPC stub implementation for the DesignCenter service API.
 *
 * <p>This class is for advanced usage and reflects the underlying API directly.
 */
@NullMarked
@Generated("by gapic-generator-java")
public class GrpcDesignCenterStub extends DesignCenterStub {
  private static final MethodDescriptor<GetSpaceRequest, Space> getSpaceMethodDescriptor =
      MethodDescriptor.<GetSpaceRequest, Space>newBuilder()
          .setType(MethodDescriptor.MethodType.UNARY)
          .setFullMethodName("google.cloud.designcenter.v1.DesignCenter/GetSpace")
          .setRequestMarshaller(ProtoUtils.marshaller(GetSpaceRequest.getDefaultInstance()))
          .setResponseMarshaller(ProtoUtils.marshaller(Space.getDefaultInstance()))
          .setSampledToLocalTracing(true)
          .build();

  private static final MethodDescriptor<ListSpacesRequest, ListSpacesResponse>
      listSpacesMethodDescriptor =
          MethodDescriptor.<ListSpacesRequest, ListSpacesResponse>newBuilder()
              .setType(MethodDescriptor.MethodType.UNARY)
              .setFullMethodName("google.cloud.designcenter.v1.DesignCenter/ListSpaces")
              .setRequestMarshaller(ProtoUtils.marshaller(ListSpacesRequest.getDefaultInstance()))
              .setResponseMarshaller(ProtoUtils.marshaller(ListSpacesResponse.getDefaultInstance()))
              .setSampledToLocalTracing(true)
              .build();

  private static final MethodDescriptor<CreateSpaceRequest, Space> createSpaceMethodDescriptor =
      MethodDescriptor.<CreateSpaceRequest, Space>newBuilder()
          .setType(MethodDescriptor.MethodType.UNARY)
          .setFullMethodName("google.cloud.designcenter.v1.DesignCenter/CreateSpace")
          .setRequestMarshaller(ProtoUtils.marshaller(CreateSpaceRequest.getDefaultInstance()))
          .setResponseMarshaller(ProtoUtils.marshaller(Space.getDefaultInstance()))
          .setSampledToLocalTracing(true)
          .build();

  private static final MethodDescriptor<UpdateSpaceRequest, Space> updateSpaceMethodDescriptor =
      MethodDescriptor.<UpdateSpaceRequest, Space>newBuilder()
          .setType(MethodDescriptor.MethodType.UNARY)
          .setFullMethodName("google.cloud.designcenter.v1.DesignCenter/UpdateSpace")
          .setRequestMarshaller(ProtoUtils.marshaller(UpdateSpaceRequest.getDefaultInstance()))
          .setResponseMarshaller(ProtoUtils.marshaller(Space.getDefaultInstance()))
          .setSampledToLocalTracing(true)
          .build();

  private static final MethodDescriptor<DeleteSpaceRequest, Empty> deleteSpaceMethodDescriptor =
      MethodDescriptor.<DeleteSpaceRequest, Empty>newBuilder()
          .setType(MethodDescriptor.MethodType.UNARY)
          .setFullMethodName("google.cloud.designcenter.v1.DesignCenter/DeleteSpace")
          .setRequestMarshaller(ProtoUtils.marshaller(DeleteSpaceRequest.getDefaultInstance()))
          .setResponseMarshaller(ProtoUtils.marshaller(Empty.getDefaultInstance()))
          .setSampledToLocalTracing(true)
          .build();

  private static final MethodDescriptor<GetApplicationTemplateRequest, ApplicationTemplate>
      getApplicationTemplateMethodDescriptor =
          MethodDescriptor.<GetApplicationTemplateRequest, ApplicationTemplate>newBuilder()
              .setType(MethodDescriptor.MethodType.UNARY)
              .setFullMethodName("google.cloud.designcenter.v1.DesignCenter/GetApplicationTemplate")
              .setRequestMarshaller(
                  ProtoUtils.marshaller(GetApplicationTemplateRequest.getDefaultInstance()))
              .setResponseMarshaller(
                  ProtoUtils.marshaller(ApplicationTemplate.getDefaultInstance()))
              .setSampledToLocalTracing(true)
              .build();

  private static final MethodDescriptor<
          ListApplicationTemplatesRequest, ListApplicationTemplatesResponse>
      listApplicationTemplatesMethodDescriptor =
          MethodDescriptor
              .<ListApplicationTemplatesRequest, ListApplicationTemplatesResponse>newBuilder()
              .setType(MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(
                  "google.cloud.designcenter.v1.DesignCenter/ListApplicationTemplates")
              .setRequestMarshaller(
                  ProtoUtils.marshaller(ListApplicationTemplatesRequest.getDefaultInstance()))
              .setResponseMarshaller(
                  ProtoUtils.marshaller(ListApplicationTemplatesResponse.getDefaultInstance()))
              .setSampledToLocalTracing(true)
              .build();

  private static final MethodDescriptor<CreateApplicationTemplateRequest, ApplicationTemplate>
      createApplicationTemplateMethodDescriptor =
          MethodDescriptor.<CreateApplicationTemplateRequest, ApplicationTemplate>newBuilder()
              .setType(MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(
                  "google.cloud.designcenter.v1.DesignCenter/CreateApplicationTemplate")
              .setRequestMarshaller(
                  ProtoUtils.marshaller(CreateApplicationTemplateRequest.getDefaultInstance()))
              .setResponseMarshaller(
                  ProtoUtils.marshaller(ApplicationTemplate.getDefaultInstance()))
              .setSampledToLocalTracing(true)
              .build();

  private static final MethodDescriptor<UpdateApplicationTemplateRequest, ApplicationTemplate>
      updateApplicationTemplateMethodDescriptor =
          MethodDescriptor.<UpdateApplicationTemplateRequest, ApplicationTemplate>newBuilder()
              .setType(MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(
                  "google.cloud.designcenter.v1.DesignCenter/UpdateApplicationTemplate")
              .setRequestMarshaller(
                  ProtoUtils.marshaller(UpdateApplicationTemplateRequest.getDefaultInstance()))
              .setResponseMarshaller(
                  ProtoUtils.marshaller(ApplicationTemplate.getDefaultInstance()))
              .setSampledToLocalTracing(true)
              .build();

  private static final MethodDescriptor<ImportApplicationTemplateRequest, ApplicationTemplate>
      importApplicationTemplateMethodDescriptor =
          MethodDescriptor.<ImportApplicationTemplateRequest, ApplicationTemplate>newBuilder()
              .setType(MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(
                  "google.cloud.designcenter.v1.DesignCenter/ImportApplicationTemplate")
              .setRequestMarshaller(
                  ProtoUtils.marshaller(ImportApplicationTemplateRequest.getDefaultInstance()))
              .setResponseMarshaller(
                  ProtoUtils.marshaller(ApplicationTemplate.getDefaultInstance()))
              .setSampledToLocalTracing(true)
              .build();

  private static final MethodDescriptor<DeleteApplicationTemplateRequest, Empty>
      deleteApplicationTemplateMethodDescriptor =
          MethodDescriptor.<DeleteApplicationTemplateRequest, Empty>newBuilder()
              .setType(MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(
                  "google.cloud.designcenter.v1.DesignCenter/DeleteApplicationTemplate")
              .setRequestMarshaller(
                  ProtoUtils.marshaller(DeleteApplicationTemplateRequest.getDefaultInstance()))
              .setResponseMarshaller(ProtoUtils.marshaller(Empty.getDefaultInstance()))
              .setSampledToLocalTracing(true)
              .build();

  private static final MethodDescriptor<
          CommitApplicationTemplateRequest, ApplicationTemplateRevision>
      commitApplicationTemplateMethodDescriptor =
          MethodDescriptor
              .<CommitApplicationTemplateRequest, ApplicationTemplateRevision>newBuilder()
              .setType(MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(
                  "google.cloud.designcenter.v1.DesignCenter/CommitApplicationTemplate")
              .setRequestMarshaller(
                  ProtoUtils.marshaller(CommitApplicationTemplateRequest.getDefaultInstance()))
              .setResponseMarshaller(
                  ProtoUtils.marshaller(ApplicationTemplateRevision.getDefaultInstance()))
              .setSampledToLocalTracing(true)
              .build();

  private static final MethodDescriptor<SnapshotApplicationTemplateRequest, Operation>
      snapshotApplicationTemplateMethodDescriptor =
          MethodDescriptor.<SnapshotApplicationTemplateRequest, Operation>newBuilder()
              .setType(MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(
                  "google.cloud.designcenter.v1.DesignCenter/SnapshotApplicationTemplate")
              .setRequestMarshaller(
                  ProtoUtils.marshaller(SnapshotApplicationTemplateRequest.getDefaultInstance()))
              .setResponseMarshaller(ProtoUtils.marshaller(Operation.getDefaultInstance()))
              .setSampledToLocalTracing(true)
              .build();

  private static final MethodDescriptor<
          GenerateApplicationTemplateIaCRequest, GenerateApplicationTemplateIaCResponse>
      generateApplicationTemplateIaCMethodDescriptor =
          MethodDescriptor
              .<GenerateApplicationTemplateIaCRequest, GenerateApplicationTemplateIaCResponse>
                  newBuilder()
              .setType(MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(
                  "google.cloud.designcenter.v1.DesignCenter/GenerateApplicationTemplateIaC")
              .setRequestMarshaller(
                  ProtoUtils.marshaller(GenerateApplicationTemplateIaCRequest.getDefaultInstance()))
              .setResponseMarshaller(
                  ProtoUtils.marshaller(
                      GenerateApplicationTemplateIaCResponse.getDefaultInstance()))
              .setSampledToLocalTracing(true)
              .build();

  private static final MethodDescriptor<ExportApplicationTemplateIaCRequest, Operation>
      exportApplicationTemplateIaCMethodDescriptor =
          MethodDescriptor.<ExportApplicationTemplateIaCRequest, Operation>newBuilder()
              .setType(MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(
                  "google.cloud.designcenter.v1.DesignCenter/ExportApplicationTemplateIaC")
              .setRequestMarshaller(
                  ProtoUtils.marshaller(ExportApplicationTemplateIaCRequest.getDefaultInstance()))
              .setResponseMarshaller(ProtoUtils.marshaller(Operation.getDefaultInstance()))
              .setSampledToLocalTracing(true)
              .build();

  private static final MethodDescriptor<
          GenerateApplicationTemplateRevisionIaCRequest,
          GenerateApplicationTemplateRevisionIaCResponse>
      generateApplicationTemplateRevisionIaCMethodDescriptor =
          MethodDescriptor
              .<GenerateApplicationTemplateRevisionIaCRequest,
                  GenerateApplicationTemplateRevisionIaCResponse>
                  newBuilder()
              .setType(MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(
                  "google.cloud.designcenter.v1.DesignCenter/GenerateApplicationTemplateRevisionIaC")
              .setRequestMarshaller(
                  ProtoUtils.marshaller(
                      GenerateApplicationTemplateRevisionIaCRequest.getDefaultInstance()))
              .setResponseMarshaller(
                  ProtoUtils.marshaller(
                      GenerateApplicationTemplateRevisionIaCResponse.getDefaultInstance()))
              .setSampledToLocalTracing(true)
              .build();

  private static final MethodDescriptor<ExportApplicationTemplateRevisionIaCRequest, Operation>
      exportApplicationTemplateRevisionIaCMethodDescriptor =
          MethodDescriptor.<ExportApplicationTemplateRevisionIaCRequest, Operation>newBuilder()
              .setType(MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(
                  "google.cloud.designcenter.v1.DesignCenter/ExportApplicationTemplateRevisionIaC")
              .setRequestMarshaller(
                  ProtoUtils.marshaller(
                      ExportApplicationTemplateRevisionIaCRequest.getDefaultInstance()))
              .setResponseMarshaller(ProtoUtils.marshaller(Operation.getDefaultInstance()))
              .setSampledToLocalTracing(true)
              .build();

  private static final MethodDescriptor<GetComponentRequest, Component>
      getComponentMethodDescriptor =
          MethodDescriptor.<GetComponentRequest, Component>newBuilder()
              .setType(MethodDescriptor.MethodType.UNARY)
              .setFullMethodName("google.cloud.designcenter.v1.DesignCenter/GetComponent")
              .setRequestMarshaller(ProtoUtils.marshaller(GetComponentRequest.getDefaultInstance()))
              .setResponseMarshaller(ProtoUtils.marshaller(Component.getDefaultInstance()))
              .setSampledToLocalTracing(true)
              .build();

  private static final MethodDescriptor<ListComponentsRequest, ListComponentsResponse>
      listComponentsMethodDescriptor =
          MethodDescriptor.<ListComponentsRequest, ListComponentsResponse>newBuilder()
              .setType(MethodDescriptor.MethodType.UNARY)
              .setFullMethodName("google.cloud.designcenter.v1.DesignCenter/ListComponents")
              .setRequestMarshaller(
                  ProtoUtils.marshaller(ListComponentsRequest.getDefaultInstance()))
              .setResponseMarshaller(
                  ProtoUtils.marshaller(ListComponentsResponse.getDefaultInstance()))
              .setSampledToLocalTracing(true)
              .build();

  private static final MethodDescriptor<CreateComponentRequest, Component>
      createComponentMethodDescriptor =
          MethodDescriptor.<CreateComponentRequest, Component>newBuilder()
              .setType(MethodDescriptor.MethodType.UNARY)
              .setFullMethodName("google.cloud.designcenter.v1.DesignCenter/CreateComponent")
              .setRequestMarshaller(
                  ProtoUtils.marshaller(CreateComponentRequest.getDefaultInstance()))
              .setResponseMarshaller(ProtoUtils.marshaller(Component.getDefaultInstance()))
              .setSampledToLocalTracing(true)
              .build();

  private static final MethodDescriptor<UpdateComponentRequest, Component>
      updateComponentMethodDescriptor =
          MethodDescriptor.<UpdateComponentRequest, Component>newBuilder()
              .setType(MethodDescriptor.MethodType.UNARY)
              .setFullMethodName("google.cloud.designcenter.v1.DesignCenter/UpdateComponent")
              .setRequestMarshaller(
                  ProtoUtils.marshaller(UpdateComponentRequest.getDefaultInstance()))
              .setResponseMarshaller(ProtoUtils.marshaller(Component.getDefaultInstance()))
              .setSampledToLocalTracing(true)
              .build();

  private static final MethodDescriptor<DeleteComponentRequest, Empty>
      deleteComponentMethodDescriptor =
          MethodDescriptor.<DeleteComponentRequest, Empty>newBuilder()
              .setType(MethodDescriptor.MethodType.UNARY)
              .setFullMethodName("google.cloud.designcenter.v1.DesignCenter/DeleteComponent")
              .setRequestMarshaller(
                  ProtoUtils.marshaller(DeleteComponentRequest.getDefaultInstance()))
              .setResponseMarshaller(ProtoUtils.marshaller(Empty.getDefaultInstance()))
              .setSampledToLocalTracing(true)
              .build();

  private static final MethodDescriptor<GetConnectionRequest, Connection>
      getConnectionMethodDescriptor =
          MethodDescriptor.<GetConnectionRequest, Connection>newBuilder()
              .setType(MethodDescriptor.MethodType.UNARY)
              .setFullMethodName("google.cloud.designcenter.v1.DesignCenter/GetConnection")
              .setRequestMarshaller(
                  ProtoUtils.marshaller(GetConnectionRequest.getDefaultInstance()))
              .setResponseMarshaller(ProtoUtils.marshaller(Connection.getDefaultInstance()))
              .setSampledToLocalTracing(true)
              .build();

  private static final MethodDescriptor<ListConnectionsRequest, ListConnectionsResponse>
      listConnectionsMethodDescriptor =
          MethodDescriptor.<ListConnectionsRequest, ListConnectionsResponse>newBuilder()
              .setType(MethodDescriptor.MethodType.UNARY)
              .setFullMethodName("google.cloud.designcenter.v1.DesignCenter/ListConnections")
              .setRequestMarshaller(
                  ProtoUtils.marshaller(ListConnectionsRequest.getDefaultInstance()))
              .setResponseMarshaller(
                  ProtoUtils.marshaller(ListConnectionsResponse.getDefaultInstance()))
              .setSampledToLocalTracing(true)
              .build();

  private static final MethodDescriptor<CreateConnectionRequest, Connection>
      createConnectionMethodDescriptor =
          MethodDescriptor.<CreateConnectionRequest, Connection>newBuilder()
              .setType(MethodDescriptor.MethodType.UNARY)
              .setFullMethodName("google.cloud.designcenter.v1.DesignCenter/CreateConnection")
              .setRequestMarshaller(
                  ProtoUtils.marshaller(CreateConnectionRequest.getDefaultInstance()))
              .setResponseMarshaller(ProtoUtils.marshaller(Connection.getDefaultInstance()))
              .setSampledToLocalTracing(true)
              .build();

  private static final MethodDescriptor<UpdateConnectionRequest, Connection>
      updateConnectionMethodDescriptor =
          MethodDescriptor.<UpdateConnectionRequest, Connection>newBuilder()
              .setType(MethodDescriptor.MethodType.UNARY)
              .setFullMethodName("google.cloud.designcenter.v1.DesignCenter/UpdateConnection")
              .setRequestMarshaller(
                  ProtoUtils.marshaller(UpdateConnectionRequest.getDefaultInstance()))
              .setResponseMarshaller(ProtoUtils.marshaller(Connection.getDefaultInstance()))
              .setSampledToLocalTracing(true)
              .build();

  private static final MethodDescriptor<DeleteConnectionRequest, Empty>
      deleteConnectionMethodDescriptor =
          MethodDescriptor.<DeleteConnectionRequest, Empty>newBuilder()
              .setType(MethodDescriptor.MethodType.UNARY)
              .setFullMethodName("google.cloud.designcenter.v1.DesignCenter/DeleteConnection")
              .setRequestMarshaller(
                  ProtoUtils.marshaller(DeleteConnectionRequest.getDefaultInstance()))
              .setResponseMarshaller(ProtoUtils.marshaller(Empty.getDefaultInstance()))
              .setSampledToLocalTracing(true)
              .build();

  private static final MethodDescriptor<
          GetApplicationTemplateRevisionRequest, ApplicationTemplateRevision>
      getApplicationTemplateRevisionMethodDescriptor =
          MethodDescriptor
              .<GetApplicationTemplateRevisionRequest, ApplicationTemplateRevision>newBuilder()
              .setType(MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(
                  "google.cloud.designcenter.v1.DesignCenter/GetApplicationTemplateRevision")
              .setRequestMarshaller(
                  ProtoUtils.marshaller(GetApplicationTemplateRevisionRequest.getDefaultInstance()))
              .setResponseMarshaller(
                  ProtoUtils.marshaller(ApplicationTemplateRevision.getDefaultInstance()))
              .setSampledToLocalTracing(true)
              .build();

  private static final MethodDescriptor<
          ListApplicationTemplateRevisionsRequest, ListApplicationTemplateRevisionsResponse>
      listApplicationTemplateRevisionsMethodDescriptor =
          MethodDescriptor
              .<ListApplicationTemplateRevisionsRequest, ListApplicationTemplateRevisionsResponse>
                  newBuilder()
              .setType(MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(
                  "google.cloud.designcenter.v1.DesignCenter/ListApplicationTemplateRevisions")
              .setRequestMarshaller(
                  ProtoUtils.marshaller(
                      ListApplicationTemplateRevisionsRequest.getDefaultInstance()))
              .setResponseMarshaller(
                  ProtoUtils.marshaller(
                      ListApplicationTemplateRevisionsResponse.getDefaultInstance()))
              .setSampledToLocalTracing(true)
              .build();

  private static final MethodDescriptor<DeleteApplicationTemplateRevisionRequest, Empty>
      deleteApplicationTemplateRevisionMethodDescriptor =
          MethodDescriptor.<DeleteApplicationTemplateRevisionRequest, Empty>newBuilder()
              .setType(MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(
                  "google.cloud.designcenter.v1.DesignCenter/DeleteApplicationTemplateRevision")
              .setRequestMarshaller(
                  ProtoUtils.marshaller(
                      DeleteApplicationTemplateRevisionRequest.getDefaultInstance()))
              .setResponseMarshaller(ProtoUtils.marshaller(Empty.getDefaultInstance()))
              .setSampledToLocalTracing(true)
              .build();

  private static final MethodDescriptor<GetCatalogRequest, Catalog> getCatalogMethodDescriptor =
      MethodDescriptor.<GetCatalogRequest, Catalog>newBuilder()
          .setType(MethodDescriptor.MethodType.UNARY)
          .setFullMethodName("google.cloud.designcenter.v1.DesignCenter/GetCatalog")
          .setRequestMarshaller(ProtoUtils.marshaller(GetCatalogRequest.getDefaultInstance()))
          .setResponseMarshaller(ProtoUtils.marshaller(Catalog.getDefaultInstance()))
          .setSampledToLocalTracing(true)
          .build();

  private static final MethodDescriptor<ListCatalogsRequest, ListCatalogsResponse>
      listCatalogsMethodDescriptor =
          MethodDescriptor.<ListCatalogsRequest, ListCatalogsResponse>newBuilder()
              .setType(MethodDescriptor.MethodType.UNARY)
              .setFullMethodName("google.cloud.designcenter.v1.DesignCenter/ListCatalogs")
              .setRequestMarshaller(ProtoUtils.marshaller(ListCatalogsRequest.getDefaultInstance()))
              .setResponseMarshaller(
                  ProtoUtils.marshaller(ListCatalogsResponse.getDefaultInstance()))
              .setSampledToLocalTracing(true)
              .build();

  private static final MethodDescriptor<CreateCatalogRequest, Catalog>
      createCatalogMethodDescriptor =
          MethodDescriptor.<CreateCatalogRequest, Catalog>newBuilder()
              .setType(MethodDescriptor.MethodType.UNARY)
              .setFullMethodName("google.cloud.designcenter.v1.DesignCenter/CreateCatalog")
              .setRequestMarshaller(
                  ProtoUtils.marshaller(CreateCatalogRequest.getDefaultInstance()))
              .setResponseMarshaller(ProtoUtils.marshaller(Catalog.getDefaultInstance()))
              .setSampledToLocalTracing(true)
              .build();

  private static final MethodDescriptor<UpdateCatalogRequest, Catalog>
      updateCatalogMethodDescriptor =
          MethodDescriptor.<UpdateCatalogRequest, Catalog>newBuilder()
              .setType(MethodDescriptor.MethodType.UNARY)
              .setFullMethodName("google.cloud.designcenter.v1.DesignCenter/UpdateCatalog")
              .setRequestMarshaller(
                  ProtoUtils.marshaller(UpdateCatalogRequest.getDefaultInstance()))
              .setResponseMarshaller(ProtoUtils.marshaller(Catalog.getDefaultInstance()))
              .setSampledToLocalTracing(true)
              .build();

  private static final MethodDescriptor<DeleteCatalogRequest, Operation>
      deleteCatalogMethodDescriptor =
          MethodDescriptor.<DeleteCatalogRequest, Operation>newBuilder()
              .setType(MethodDescriptor.MethodType.UNARY)
              .setFullMethodName("google.cloud.designcenter.v1.DesignCenter/DeleteCatalog")
              .setRequestMarshaller(
                  ProtoUtils.marshaller(DeleteCatalogRequest.getDefaultInstance()))
              .setResponseMarshaller(ProtoUtils.marshaller(Operation.getDefaultInstance()))
              .setSampledToLocalTracing(true)
              .build();

  private static final MethodDescriptor<CreateCatalogTemplateRequest, CatalogTemplate>
      createCatalogTemplateMethodDescriptor =
          MethodDescriptor.<CreateCatalogTemplateRequest, CatalogTemplate>newBuilder()
              .setType(MethodDescriptor.MethodType.UNARY)
              .setFullMethodName("google.cloud.designcenter.v1.DesignCenter/CreateCatalogTemplate")
              .setRequestMarshaller(
                  ProtoUtils.marshaller(CreateCatalogTemplateRequest.getDefaultInstance()))
              .setResponseMarshaller(ProtoUtils.marshaller(CatalogTemplate.getDefaultInstance()))
              .setSampledToLocalTracing(true)
              .build();

  private static final MethodDescriptor<GetCatalogTemplateRequest, CatalogTemplate>
      getCatalogTemplateMethodDescriptor =
          MethodDescriptor.<GetCatalogTemplateRequest, CatalogTemplate>newBuilder()
              .setType(MethodDescriptor.MethodType.UNARY)
              .setFullMethodName("google.cloud.designcenter.v1.DesignCenter/GetCatalogTemplate")
              .setRequestMarshaller(
                  ProtoUtils.marshaller(GetCatalogTemplateRequest.getDefaultInstance()))
              .setResponseMarshaller(ProtoUtils.marshaller(CatalogTemplate.getDefaultInstance()))
              .setSampledToLocalTracing(true)
              .build();

  private static final MethodDescriptor<ListCatalogTemplatesRequest, ListCatalogTemplatesResponse>
      listCatalogTemplatesMethodDescriptor =
          MethodDescriptor.<ListCatalogTemplatesRequest, ListCatalogTemplatesResponse>newBuilder()
              .setType(MethodDescriptor.MethodType.UNARY)
              .setFullMethodName("google.cloud.designcenter.v1.DesignCenter/ListCatalogTemplates")
              .setRequestMarshaller(
                  ProtoUtils.marshaller(ListCatalogTemplatesRequest.getDefaultInstance()))
              .setResponseMarshaller(
                  ProtoUtils.marshaller(ListCatalogTemplatesResponse.getDefaultInstance()))
              .setSampledToLocalTracing(true)
              .build();

  private static final MethodDescriptor<UpdateCatalogTemplateRequest, CatalogTemplate>
      updateCatalogTemplateMethodDescriptor =
          MethodDescriptor.<UpdateCatalogTemplateRequest, CatalogTemplate>newBuilder()
              .setType(MethodDescriptor.MethodType.UNARY)
              .setFullMethodName("google.cloud.designcenter.v1.DesignCenter/UpdateCatalogTemplate")
              .setRequestMarshaller(
                  ProtoUtils.marshaller(UpdateCatalogTemplateRequest.getDefaultInstance()))
              .setResponseMarshaller(ProtoUtils.marshaller(CatalogTemplate.getDefaultInstance()))
              .setSampledToLocalTracing(true)
              .build();

  private static final MethodDescriptor<DeleteCatalogTemplateRequest, Operation>
      deleteCatalogTemplateMethodDescriptor =
          MethodDescriptor.<DeleteCatalogTemplateRequest, Operation>newBuilder()
              .setType(MethodDescriptor.MethodType.UNARY)
              .setFullMethodName("google.cloud.designcenter.v1.DesignCenter/DeleteCatalogTemplate")
              .setRequestMarshaller(
                  ProtoUtils.marshaller(DeleteCatalogTemplateRequest.getDefaultInstance()))
              .setResponseMarshaller(ProtoUtils.marshaller(Operation.getDefaultInstance()))
              .setSampledToLocalTracing(true)
              .build();

  private static final MethodDescriptor<CreateShareRequest, Operation> createShareMethodDescriptor =
      MethodDescriptor.<CreateShareRequest, Operation>newBuilder()
          .setType(MethodDescriptor.MethodType.UNARY)
          .setFullMethodName("google.cloud.designcenter.v1.DesignCenter/CreateShare")
          .setRequestMarshaller(ProtoUtils.marshaller(CreateShareRequest.getDefaultInstance()))
          .setResponseMarshaller(ProtoUtils.marshaller(Operation.getDefaultInstance()))
          .setSampledToLocalTracing(true)
          .build();

  private static final MethodDescriptor<ListSharesRequest, ListSharesResponse>
      listSharesMethodDescriptor =
          MethodDescriptor.<ListSharesRequest, ListSharesResponse>newBuilder()
              .setType(MethodDescriptor.MethodType.UNARY)
              .setFullMethodName("google.cloud.designcenter.v1.DesignCenter/ListShares")
              .setRequestMarshaller(ProtoUtils.marshaller(ListSharesRequest.getDefaultInstance()))
              .setResponseMarshaller(ProtoUtils.marshaller(ListSharesResponse.getDefaultInstance()))
              .setSampledToLocalTracing(true)
              .build();

  private static final MethodDescriptor<GetShareRequest, Share> getShareMethodDescriptor =
      MethodDescriptor.<GetShareRequest, Share>newBuilder()
          .setType(MethodDescriptor.MethodType.UNARY)
          .setFullMethodName("google.cloud.designcenter.v1.DesignCenter/GetShare")
          .setRequestMarshaller(ProtoUtils.marshaller(GetShareRequest.getDefaultInstance()))
          .setResponseMarshaller(ProtoUtils.marshaller(Share.getDefaultInstance()))
          .setSampledToLocalTracing(true)
          .build();

  private static final MethodDescriptor<DeleteShareRequest, Operation> deleteShareMethodDescriptor =
      MethodDescriptor.<DeleteShareRequest, Operation>newBuilder()
          .setType(MethodDescriptor.MethodType.UNARY)
          .setFullMethodName("google.cloud.designcenter.v1.DesignCenter/DeleteShare")
          .setRequestMarshaller(ProtoUtils.marshaller(DeleteShareRequest.getDefaultInstance()))
          .setResponseMarshaller(ProtoUtils.marshaller(Operation.getDefaultInstance()))
          .setSampledToLocalTracing(true)
          .build();

  private static final MethodDescriptor<SyncShareRequest, Operation> syncShareMethodDescriptor =
      MethodDescriptor.<SyncShareRequest, Operation>newBuilder()
          .setType(MethodDescriptor.MethodType.UNARY)
          .setFullMethodName("google.cloud.designcenter.v1.DesignCenter/SyncShare")
          .setRequestMarshaller(ProtoUtils.marshaller(SyncShareRequest.getDefaultInstance()))
          .setResponseMarshaller(ProtoUtils.marshaller(Operation.getDefaultInstance()))
          .setSampledToLocalTracing(true)
          .build();

  private static final MethodDescriptor<GetSharedTemplateRequest, SharedTemplate>
      getSharedTemplateMethodDescriptor =
          MethodDescriptor.<GetSharedTemplateRequest, SharedTemplate>newBuilder()
              .setType(MethodDescriptor.MethodType.UNARY)
              .setFullMethodName("google.cloud.designcenter.v1.DesignCenter/GetSharedTemplate")
              .setRequestMarshaller(
                  ProtoUtils.marshaller(GetSharedTemplateRequest.getDefaultInstance()))
              .setResponseMarshaller(ProtoUtils.marshaller(SharedTemplate.getDefaultInstance()))
              .setSampledToLocalTracing(true)
              .build();

  private static final MethodDescriptor<ListSharedTemplatesRequest, ListSharedTemplatesResponse>
      listSharedTemplatesMethodDescriptor =
          MethodDescriptor.<ListSharedTemplatesRequest, ListSharedTemplatesResponse>newBuilder()
              .setType(MethodDescriptor.MethodType.UNARY)
              .setFullMethodName("google.cloud.designcenter.v1.DesignCenter/ListSharedTemplates")
              .setRequestMarshaller(
                  ProtoUtils.marshaller(ListSharedTemplatesRequest.getDefaultInstance()))
              .setResponseMarshaller(
                  ProtoUtils.marshaller(ListSharedTemplatesResponse.getDefaultInstance()))
              .setSampledToLocalTracing(true)
              .build();

  private static final MethodDescriptor<GetSharedTemplateRevisionRequest, SharedTemplateRevision>
      getSharedTemplateRevisionMethodDescriptor =
          MethodDescriptor.<GetSharedTemplateRevisionRequest, SharedTemplateRevision>newBuilder()
              .setType(MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(
                  "google.cloud.designcenter.v1.DesignCenter/GetSharedTemplateRevision")
              .setRequestMarshaller(
                  ProtoUtils.marshaller(GetSharedTemplateRevisionRequest.getDefaultInstance()))
              .setResponseMarshaller(
                  ProtoUtils.marshaller(SharedTemplateRevision.getDefaultInstance()))
              .setSampledToLocalTracing(true)
              .build();

  private static final MethodDescriptor<
          ListSharedTemplateRevisionsRequest, ListSharedTemplateRevisionsResponse>
      listSharedTemplateRevisionsMethodDescriptor =
          MethodDescriptor
              .<ListSharedTemplateRevisionsRequest, ListSharedTemplateRevisionsResponse>newBuilder()
              .setType(MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(
                  "google.cloud.designcenter.v1.DesignCenter/ListSharedTemplateRevisions")
              .setRequestMarshaller(
                  ProtoUtils.marshaller(ListSharedTemplateRevisionsRequest.getDefaultInstance()))
              .setResponseMarshaller(
                  ProtoUtils.marshaller(ListSharedTemplateRevisionsResponse.getDefaultInstance()))
              .setSampledToLocalTracing(true)
              .build();

  private static final MethodDescriptor<CreateCatalogTemplateRevisionRequest, Operation>
      createCatalogTemplateRevisionMethodDescriptor =
          MethodDescriptor.<CreateCatalogTemplateRevisionRequest, Operation>newBuilder()
              .setType(MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(
                  "google.cloud.designcenter.v1.DesignCenter/CreateCatalogTemplateRevision")
              .setRequestMarshaller(
                  ProtoUtils.marshaller(CreateCatalogTemplateRevisionRequest.getDefaultInstance()))
              .setResponseMarshaller(ProtoUtils.marshaller(Operation.getDefaultInstance()))
              .setSampledToLocalTracing(true)
              .build();

  private static final MethodDescriptor<GetCatalogTemplateRevisionRequest, CatalogTemplateRevision>
      getCatalogTemplateRevisionMethodDescriptor =
          MethodDescriptor.<GetCatalogTemplateRevisionRequest, CatalogTemplateRevision>newBuilder()
              .setType(MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(
                  "google.cloud.designcenter.v1.DesignCenter/GetCatalogTemplateRevision")
              .setRequestMarshaller(
                  ProtoUtils.marshaller(GetCatalogTemplateRevisionRequest.getDefaultInstance()))
              .setResponseMarshaller(
                  ProtoUtils.marshaller(CatalogTemplateRevision.getDefaultInstance()))
              .setSampledToLocalTracing(true)
              .build();

  private static final MethodDescriptor<
          ListCatalogTemplateRevisionsRequest, ListCatalogTemplateRevisionsResponse>
      listCatalogTemplateRevisionsMethodDescriptor =
          MethodDescriptor
              .<ListCatalogTemplateRevisionsRequest, ListCatalogTemplateRevisionsResponse>
                  newBuilder()
              .setType(MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(
                  "google.cloud.designcenter.v1.DesignCenter/ListCatalogTemplateRevisions")
              .setRequestMarshaller(
                  ProtoUtils.marshaller(ListCatalogTemplateRevisionsRequest.getDefaultInstance()))
              .setResponseMarshaller(
                  ProtoUtils.marshaller(ListCatalogTemplateRevisionsResponse.getDefaultInstance()))
              .setSampledToLocalTracing(true)
              .build();

  private static final MethodDescriptor<DeleteCatalogTemplateRevisionRequest, Operation>
      deleteCatalogTemplateRevisionMethodDescriptor =
          MethodDescriptor.<DeleteCatalogTemplateRevisionRequest, Operation>newBuilder()
              .setType(MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(
                  "google.cloud.designcenter.v1.DesignCenter/DeleteCatalogTemplateRevision")
              .setRequestMarshaller(
                  ProtoUtils.marshaller(DeleteCatalogTemplateRevisionRequest.getDefaultInstance()))
              .setResponseMarshaller(ProtoUtils.marshaller(Operation.getDefaultInstance()))
              .setSampledToLocalTracing(true)
              .build();

  private static final MethodDescriptor<CreateApplicationRequest, Application>
      createApplicationMethodDescriptor =
          MethodDescriptor.<CreateApplicationRequest, Application>newBuilder()
              .setType(MethodDescriptor.MethodType.UNARY)
              .setFullMethodName("google.cloud.designcenter.v1.DesignCenter/CreateApplication")
              .setRequestMarshaller(
                  ProtoUtils.marshaller(CreateApplicationRequest.getDefaultInstance()))
              .setResponseMarshaller(ProtoUtils.marshaller(Application.getDefaultInstance()))
              .setSampledToLocalTracing(true)
              .build();

  private static final MethodDescriptor<GetApplicationRequest, Application>
      getApplicationMethodDescriptor =
          MethodDescriptor.<GetApplicationRequest, Application>newBuilder()
              .setType(MethodDescriptor.MethodType.UNARY)
              .setFullMethodName("google.cloud.designcenter.v1.DesignCenter/GetApplication")
              .setRequestMarshaller(
                  ProtoUtils.marshaller(GetApplicationRequest.getDefaultInstance()))
              .setResponseMarshaller(ProtoUtils.marshaller(Application.getDefaultInstance()))
              .setSampledToLocalTracing(true)
              .build();

  private static final MethodDescriptor<ListApplicationsRequest, ListApplicationsResponse>
      listApplicationsMethodDescriptor =
          MethodDescriptor.<ListApplicationsRequest, ListApplicationsResponse>newBuilder()
              .setType(MethodDescriptor.MethodType.UNARY)
              .setFullMethodName("google.cloud.designcenter.v1.DesignCenter/ListApplications")
              .setRequestMarshaller(
                  ProtoUtils.marshaller(ListApplicationsRequest.getDefaultInstance()))
              .setResponseMarshaller(
                  ProtoUtils.marshaller(ListApplicationsResponse.getDefaultInstance()))
              .setSampledToLocalTracing(true)
              .build();

  private static final MethodDescriptor<UpdateApplicationRequest, Application>
      updateApplicationMethodDescriptor =
          MethodDescriptor.<UpdateApplicationRequest, Application>newBuilder()
              .setType(MethodDescriptor.MethodType.UNARY)
              .setFullMethodName("google.cloud.designcenter.v1.DesignCenter/UpdateApplication")
              .setRequestMarshaller(
                  ProtoUtils.marshaller(UpdateApplicationRequest.getDefaultInstance()))
              .setResponseMarshaller(ProtoUtils.marshaller(Application.getDefaultInstance()))
              .setSampledToLocalTracing(true)
              .build();

  private static final MethodDescriptor<DeleteApplicationRequest, Operation>
      deleteApplicationMethodDescriptor =
          MethodDescriptor.<DeleteApplicationRequest, Operation>newBuilder()
              .setType(MethodDescriptor.MethodType.UNARY)
              .setFullMethodName("google.cloud.designcenter.v1.DesignCenter/DeleteApplication")
              .setRequestMarshaller(
                  ProtoUtils.marshaller(DeleteApplicationRequest.getDefaultInstance()))
              .setResponseMarshaller(ProtoUtils.marshaller(Operation.getDefaultInstance()))
              .setSampledToLocalTracing(true)
              .build();

  private static final MethodDescriptor<DeployApplicationRequest, Operation>
      deployApplicationMethodDescriptor =
          MethodDescriptor.<DeployApplicationRequest, Operation>newBuilder()
              .setType(MethodDescriptor.MethodType.UNARY)
              .setFullMethodName("google.cloud.designcenter.v1.DesignCenter/DeployApplication")
              .setRequestMarshaller(
                  ProtoUtils.marshaller(DeployApplicationRequest.getDefaultInstance()))
              .setResponseMarshaller(ProtoUtils.marshaller(Operation.getDefaultInstance()))
              .setSampledToLocalTracing(true)
              .build();

  private static final MethodDescriptor<PreviewApplicationRequest, Operation>
      previewApplicationMethodDescriptor =
          MethodDescriptor.<PreviewApplicationRequest, Operation>newBuilder()
              .setType(MethodDescriptor.MethodType.UNARY)
              .setFullMethodName("google.cloud.designcenter.v1.DesignCenter/PreviewApplication")
              .setRequestMarshaller(
                  ProtoUtils.marshaller(PreviewApplicationRequest.getDefaultInstance()))
              .setResponseMarshaller(ProtoUtils.marshaller(Operation.getDefaultInstance()))
              .setSampledToLocalTracing(true)
              .build();

  private static final MethodDescriptor<
          FetchApplicationAssessmentReportRequest, FetchApplicationAssessmentReportResponse>
      fetchApplicationAssessmentReportMethodDescriptor =
          MethodDescriptor
              .<FetchApplicationAssessmentReportRequest, FetchApplicationAssessmentReportResponse>
                  newBuilder()
              .setType(MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(
                  "google.cloud.designcenter.v1.DesignCenter/FetchApplicationAssessmentReport")
              .setRequestMarshaller(
                  ProtoUtils.marshaller(
                      FetchApplicationAssessmentReportRequest.getDefaultInstance()))
              .setResponseMarshaller(
                  ProtoUtils.marshaller(
                      FetchApplicationAssessmentReportResponse.getDefaultInstance()))
              .setSampledToLocalTracing(true)
              .build();

  private static final MethodDescriptor<GenerateApplicationAssessmentReportRequest, Operation>
      generateApplicationAssessmentReportMethodDescriptor =
          MethodDescriptor.<GenerateApplicationAssessmentReportRequest, Operation>newBuilder()
              .setType(MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(
                  "google.cloud.designcenter.v1.DesignCenter/GenerateApplicationAssessmentReport")
              .setRequestMarshaller(
                  ProtoUtils.marshaller(
                      GenerateApplicationAssessmentReportRequest.getDefaultInstance()))
              .setResponseMarshaller(ProtoUtils.marshaller(Operation.getDefaultInstance()))
              .setSampledToLocalTracing(true)
              .build();

  private static final MethodDescriptor<
          GenerateApplicationTemplateAssessmentReportRequest, Operation>
      generateApplicationTemplateAssessmentReportMethodDescriptor =
          MethodDescriptor
              .<GenerateApplicationTemplateAssessmentReportRequest, Operation>newBuilder()
              .setType(MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(
                  "google.cloud.designcenter.v1.DesignCenter/GenerateApplicationTemplateAssessmentReport")
              .setRequestMarshaller(
                  ProtoUtils.marshaller(
                      GenerateApplicationTemplateAssessmentReportRequest.getDefaultInstance()))
              .setResponseMarshaller(ProtoUtils.marshaller(Operation.getDefaultInstance()))
              .setSampledToLocalTracing(true)
              .build();

  private static final MethodDescriptor<GenerateAssessmentReportRequest, Operation>
      generateAssessmentReportMethodDescriptor =
          MethodDescriptor.<GenerateAssessmentReportRequest, Operation>newBuilder()
              .setType(MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(
                  "google.cloud.designcenter.v1.DesignCenter/GenerateAssessmentReport")
              .setRequestMarshaller(
                  ProtoUtils.marshaller(GenerateAssessmentReportRequest.getDefaultInstance()))
              .setResponseMarshaller(ProtoUtils.marshaller(Operation.getDefaultInstance()))
              .setSampledToLocalTracing(true)
              .build();

  private static final MethodDescriptor<GenerateTerraformPlanAssessmentReportRequest, Operation>
      generateTerraformPlanAssessmentReportMethodDescriptor =
          MethodDescriptor.<GenerateTerraformPlanAssessmentReportRequest, Operation>newBuilder()
              .setType(MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(
                  "google.cloud.designcenter.v1.DesignCenter/GenerateTerraformPlanAssessmentReport")
              .setRequestMarshaller(
                  ProtoUtils.marshaller(
                      GenerateTerraformPlanAssessmentReportRequest.getDefaultInstance()))
              .setResponseMarshaller(ProtoUtils.marshaller(Operation.getDefaultInstance()))
              .setSampledToLocalTracing(true)
              .build();

  private static final MethodDescriptor<GetPolicyRequest, Policy> getPolicyMethodDescriptor =
      MethodDescriptor.<GetPolicyRequest, Policy>newBuilder()
          .setType(MethodDescriptor.MethodType.UNARY)
          .setFullMethodName("google.cloud.designcenter.v1.DesignCenter/GetPolicy")
          .setRequestMarshaller(ProtoUtils.marshaller(GetPolicyRequest.getDefaultInstance()))
          .setResponseMarshaller(ProtoUtils.marshaller(Policy.getDefaultInstance()))
          .setSampledToLocalTracing(true)
          .build();

  private static final MethodDescriptor<ListPoliciesRequest, ListPoliciesResponse>
      listPoliciesMethodDescriptor =
          MethodDescriptor.<ListPoliciesRequest, ListPoliciesResponse>newBuilder()
              .setType(MethodDescriptor.MethodType.UNARY)
              .setFullMethodName("google.cloud.designcenter.v1.DesignCenter/ListPolicies")
              .setRequestMarshaller(ProtoUtils.marshaller(ListPoliciesRequest.getDefaultInstance()))
              .setResponseMarshaller(
                  ProtoUtils.marshaller(ListPoliciesResponse.getDefaultInstance()))
              .setSampledToLocalTracing(true)
              .build();

  private static final MethodDescriptor<CreatePolicyRequest, Policy> createPolicyMethodDescriptor =
      MethodDescriptor.<CreatePolicyRequest, Policy>newBuilder()
          .setType(MethodDescriptor.MethodType.UNARY)
          .setFullMethodName("google.cloud.designcenter.v1.DesignCenter/CreatePolicy")
          .setRequestMarshaller(ProtoUtils.marshaller(CreatePolicyRequest.getDefaultInstance()))
          .setResponseMarshaller(ProtoUtils.marshaller(Policy.getDefaultInstance()))
          .setSampledToLocalTracing(true)
          .build();

  private static final MethodDescriptor<UpdatePolicyRequest, Policy> updatePolicyMethodDescriptor =
      MethodDescriptor.<UpdatePolicyRequest, Policy>newBuilder()
          .setType(MethodDescriptor.MethodType.UNARY)
          .setFullMethodName("google.cloud.designcenter.v1.DesignCenter/UpdatePolicy")
          .setRequestMarshaller(ProtoUtils.marshaller(UpdatePolicyRequest.getDefaultInstance()))
          .setResponseMarshaller(ProtoUtils.marshaller(Policy.getDefaultInstance()))
          .setSampledToLocalTracing(true)
          .build();

  private static final MethodDescriptor<DeletePolicyRequest, Empty> deletePolicyMethodDescriptor =
      MethodDescriptor.<DeletePolicyRequest, Empty>newBuilder()
          .setType(MethodDescriptor.MethodType.UNARY)
          .setFullMethodName("google.cloud.designcenter.v1.DesignCenter/DeletePolicy")
          .setRequestMarshaller(ProtoUtils.marshaller(DeletePolicyRequest.getDefaultInstance()))
          .setResponseMarshaller(ProtoUtils.marshaller(Empty.getDefaultInstance()))
          .setSampledToLocalTracing(true)
          .build();

  private static final MethodDescriptor<FetchFrameworksRequest, FetchFrameworksResponse>
      fetchFrameworksMethodDescriptor =
          MethodDescriptor.<FetchFrameworksRequest, FetchFrameworksResponse>newBuilder()
              .setType(MethodDescriptor.MethodType.UNARY)
              .setFullMethodName("google.cloud.designcenter.v1.DesignCenter/FetchFrameworks")
              .setRequestMarshaller(
                  ProtoUtils.marshaller(FetchFrameworksRequest.getDefaultInstance()))
              .setResponseMarshaller(
                  ProtoUtils.marshaller(FetchFrameworksResponse.getDefaultInstance()))
              .setSampledToLocalTracing(true)
              .build();

  private static final MethodDescriptor<
          GenerateApplicationIaCRequest, GenerateApplicationIaCResponse>
      generateApplicationIaCMethodDescriptor =
          MethodDescriptor
              .<GenerateApplicationIaCRequest, GenerateApplicationIaCResponse>newBuilder()
              .setType(MethodDescriptor.MethodType.UNARY)
              .setFullMethodName("google.cloud.designcenter.v1.DesignCenter/GenerateApplicationIaC")
              .setRequestMarshaller(
                  ProtoUtils.marshaller(GenerateApplicationIaCRequest.getDefaultInstance()))
              .setResponseMarshaller(
                  ProtoUtils.marshaller(GenerateApplicationIaCResponse.getDefaultInstance()))
              .setSampledToLocalTracing(true)
              .build();

  private static final MethodDescriptor<ExportApplicationIaCRequest, Operation>
      exportApplicationIaCMethodDescriptor =
          MethodDescriptor.<ExportApplicationIaCRequest, Operation>newBuilder()
              .setType(MethodDescriptor.MethodType.UNARY)
              .setFullMethodName("google.cloud.designcenter.v1.DesignCenter/ExportApplicationIaC")
              .setRequestMarshaller(
                  ProtoUtils.marshaller(ExportApplicationIaCRequest.getDefaultInstance()))
              .setResponseMarshaller(ProtoUtils.marshaller(Operation.getDefaultInstance()))
              .setSampledToLocalTracing(true)
              .build();

  private static final MethodDescriptor<
          ImportApplicationTemplateIaCRequest, ImportApplicationTemplateIaCResponse>
      importApplicationTemplateIaCMethodDescriptor =
          MethodDescriptor
              .<ImportApplicationTemplateIaCRequest, ImportApplicationTemplateIaCResponse>
                  newBuilder()
              .setType(MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(
                  "google.cloud.designcenter.v1.DesignCenter/ImportApplicationTemplateIaC")
              .setRequestMarshaller(
                  ProtoUtils.marshaller(ImportApplicationTemplateIaCRequest.getDefaultInstance()))
              .setResponseMarshaller(
                  ProtoUtils.marshaller(ImportApplicationTemplateIaCResponse.getDefaultInstance()))
              .setSampledToLocalTracing(true)
              .build();

  private static final MethodDescriptor<IngestApplicationTemplateIaCRequest, Operation>
      ingestApplicationTemplateIaCMethodDescriptor =
          MethodDescriptor.<IngestApplicationTemplateIaCRequest, Operation>newBuilder()
              .setType(MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(
                  "google.cloud.designcenter.v1.DesignCenter/IngestApplicationTemplateIaC")
              .setRequestMarshaller(
                  ProtoUtils.marshaller(IngestApplicationTemplateIaCRequest.getDefaultInstance()))
              .setResponseMarshaller(ProtoUtils.marshaller(Operation.getDefaultInstance()))
              .setSampledToLocalTracing(true)
              .build();

  private static final MethodDescriptor<ImportApplicationIaCRequest, ImportApplicationIaCResponse>
      importApplicationIaCMethodDescriptor =
          MethodDescriptor.<ImportApplicationIaCRequest, ImportApplicationIaCResponse>newBuilder()
              .setType(MethodDescriptor.MethodType.UNARY)
              .setFullMethodName("google.cloud.designcenter.v1.DesignCenter/ImportApplicationIaC")
              .setRequestMarshaller(
                  ProtoUtils.marshaller(ImportApplicationIaCRequest.getDefaultInstance()))
              .setResponseMarshaller(
                  ProtoUtils.marshaller(ImportApplicationIaCResponse.getDefaultInstance()))
              .setSampledToLocalTracing(true)
              .build();

  private static final MethodDescriptor<RegisterAppHubApplicationResourcesRequest, Operation>
      registerAppHubApplicationResourcesMethodDescriptor =
          MethodDescriptor.<RegisterAppHubApplicationResourcesRequest, Operation>newBuilder()
              .setType(MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(
                  "google.cloud.designcenter.v1.DesignCenter/RegisterAppHubApplicationResources")
              .setRequestMarshaller(
                  ProtoUtils.marshaller(
                      RegisterAppHubApplicationResourcesRequest.getDefaultInstance()))
              .setResponseMarshaller(ProtoUtils.marshaller(Operation.getDefaultInstance()))
              .setSampledToLocalTracing(true)
              .build();

  private static final MethodDescriptor<
          ListApplicationTemplateSystemRevisionsRequest,
          ListApplicationTemplateSystemRevisionsResponse>
      listApplicationTemplateSystemRevisionsMethodDescriptor =
          MethodDescriptor
              .<ListApplicationTemplateSystemRevisionsRequest,
                  ListApplicationTemplateSystemRevisionsResponse>
                  newBuilder()
              .setType(MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(
                  "google.cloud.designcenter.v1.DesignCenter/ListApplicationTemplateSystemRevisions")
              .setRequestMarshaller(
                  ProtoUtils.marshaller(
                      ListApplicationTemplateSystemRevisionsRequest.getDefaultInstance()))
              .setResponseMarshaller(
                  ProtoUtils.marshaller(
                      ListApplicationTemplateSystemRevisionsResponse.getDefaultInstance()))
              .setSampledToLocalTracing(true)
              .build();

  private static final MethodDescriptor<
          GetApplicationTemplateSystemRevisionRequest, ApplicationTemplateSystemRevision>
      getApplicationTemplateSystemRevisionMethodDescriptor =
          MethodDescriptor
              .<GetApplicationTemplateSystemRevisionRequest, ApplicationTemplateSystemRevision>
                  newBuilder()
              .setType(MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(
                  "google.cloud.designcenter.v1.DesignCenter/GetApplicationTemplateSystemRevision")
              .setRequestMarshaller(
                  ProtoUtils.marshaller(
                      GetApplicationTemplateSystemRevisionRequest.getDefaultInstance()))
              .setResponseMarshaller(
                  ProtoUtils.marshaller(ApplicationTemplateSystemRevision.getDefaultInstance()))
              .setSampledToLocalTracing(true)
              .build();

  private static final MethodDescriptor<RecommendIAMRolesRequest, Operation>
      recommendIAMRolesMethodDescriptor =
          MethodDescriptor.<RecommendIAMRolesRequest, Operation>newBuilder()
              .setType(MethodDescriptor.MethodType.UNARY)
              .setFullMethodName("google.cloud.designcenter.v1.DesignCenter/RecommendIAMRoles")
              .setRequestMarshaller(
                  ProtoUtils.marshaller(RecommendIAMRolesRequest.getDefaultInstance()))
              .setResponseMarshaller(ProtoUtils.marshaller(Operation.getDefaultInstance()))
              .setSampledToLocalTracing(true)
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
              .setSampledToLocalTracing(true)
              .build();

  private static final MethodDescriptor<GetLocationRequest, Location> getLocationMethodDescriptor =
      MethodDescriptor.<GetLocationRequest, Location>newBuilder()
          .setType(MethodDescriptor.MethodType.UNARY)
          .setFullMethodName("google.cloud.location.Locations/GetLocation")
          .setRequestMarshaller(ProtoUtils.marshaller(GetLocationRequest.getDefaultInstance()))
          .setResponseMarshaller(ProtoUtils.marshaller(Location.getDefaultInstance()))
          .setSampledToLocalTracing(true)
          .build();

  private static final MethodDescriptor<SetIamPolicyRequest, com.google.iam.v1.Policy>
      setIamPolicyMethodDescriptor =
          MethodDescriptor.<SetIamPolicyRequest, com.google.iam.v1.Policy>newBuilder()
              .setType(MethodDescriptor.MethodType.UNARY)
              .setFullMethodName("google.iam.v1.IAMPolicy/SetIamPolicy")
              .setRequestMarshaller(ProtoUtils.marshaller(SetIamPolicyRequest.getDefaultInstance()))
              .setResponseMarshaller(
                  ProtoUtils.marshaller(com.google.iam.v1.Policy.getDefaultInstance()))
              .setSampledToLocalTracing(true)
              .build();

  private static final MethodDescriptor<GetIamPolicyRequest, com.google.iam.v1.Policy>
      getIamPolicyMethodDescriptor =
          MethodDescriptor.<GetIamPolicyRequest, com.google.iam.v1.Policy>newBuilder()
              .setType(MethodDescriptor.MethodType.UNARY)
              .setFullMethodName("google.iam.v1.IAMPolicy/GetIamPolicy")
              .setRequestMarshaller(ProtoUtils.marshaller(GetIamPolicyRequest.getDefaultInstance()))
              .setResponseMarshaller(
                  ProtoUtils.marshaller(com.google.iam.v1.Policy.getDefaultInstance()))
              .setSampledToLocalTracing(true)
              .build();

  private static final MethodDescriptor<TestIamPermissionsRequest, TestIamPermissionsResponse>
      testIamPermissionsMethodDescriptor =
          MethodDescriptor.<TestIamPermissionsRequest, TestIamPermissionsResponse>newBuilder()
              .setType(MethodDescriptor.MethodType.UNARY)
              .setFullMethodName("google.iam.v1.IAMPolicy/TestIamPermissions")
              .setRequestMarshaller(
                  ProtoUtils.marshaller(TestIamPermissionsRequest.getDefaultInstance()))
              .setResponseMarshaller(
                  ProtoUtils.marshaller(TestIamPermissionsResponse.getDefaultInstance()))
              .setSampledToLocalTracing(true)
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
  private final GrpcOperationsStub operationsStub;
  private final GrpcStubCallableFactory callableFactory;

  public static final GrpcDesignCenterStub create(DesignCenterStubSettings settings)
      throws IOException {
    return new GrpcDesignCenterStub(settings, ClientContext.create(settings));
  }

  public static final GrpcDesignCenterStub create(ClientContext clientContext) throws IOException {
    return new GrpcDesignCenterStub(DesignCenterStubSettings.newBuilder().build(), clientContext);
  }

  public static final GrpcDesignCenterStub create(
      ClientContext clientContext, GrpcStubCallableFactory callableFactory) throws IOException {
    return new GrpcDesignCenterStub(
        DesignCenterStubSettings.newBuilder().build(), clientContext, callableFactory);
  }

  /**
   * Constructs an instance of GrpcDesignCenterStub, using the given settings. This is protected so
   * that it is easy to make a subclass, but otherwise, the static factory methods should be
   * preferred.
   */
  protected GrpcDesignCenterStub(DesignCenterStubSettings settings, ClientContext clientContext)
      throws IOException {
    this(settings, clientContext, new GrpcDesignCenterCallableFactory());
  }

  /**
   * Constructs an instance of GrpcDesignCenterStub, using the given settings. This is protected so
   * that it is easy to make a subclass, but otherwise, the static factory methods should be
   * preferred.
   */
  protected GrpcDesignCenterStub(
      DesignCenterStubSettings settings,
      ClientContext clientContext,
      GrpcStubCallableFactory callableFactory)
      throws IOException {
    this.callableFactory = callableFactory;
    this.operationsStub = GrpcOperationsStub.create(clientContext, callableFactory);

    GrpcCallSettings<GetSpaceRequest, Space> getSpaceTransportSettings =
        GrpcCallSettings.<GetSpaceRequest, Space>newBuilder()
            .setMethodDescriptor(getSpaceMethodDescriptor)
            .setParamsExtractor(
                request -> {
                  RequestParamsBuilder builder = RequestParamsBuilder.create();
                  builder.add("name", String.valueOf(request.getName()));
                  return builder.build();
                })
            .setResourceNameExtractor(request -> request.getName())
            .build();
    GrpcCallSettings<ListSpacesRequest, ListSpacesResponse> listSpacesTransportSettings =
        GrpcCallSettings.<ListSpacesRequest, ListSpacesResponse>newBuilder()
            .setMethodDescriptor(listSpacesMethodDescriptor)
            .setParamsExtractor(
                request -> {
                  RequestParamsBuilder builder = RequestParamsBuilder.create();
                  builder.add("parent", String.valueOf(request.getParent()));
                  return builder.build();
                })
            .setResourceNameExtractor(request -> request.getParent())
            .build();
    GrpcCallSettings<CreateSpaceRequest, Space> createSpaceTransportSettings =
        GrpcCallSettings.<CreateSpaceRequest, Space>newBuilder()
            .setMethodDescriptor(createSpaceMethodDescriptor)
            .setParamsExtractor(
                request -> {
                  RequestParamsBuilder builder = RequestParamsBuilder.create();
                  builder.add("parent", String.valueOf(request.getParent()));
                  return builder.build();
                })
            .setResourceNameExtractor(request -> request.getParent())
            .build();
    GrpcCallSettings<UpdateSpaceRequest, Space> updateSpaceTransportSettings =
        GrpcCallSettings.<UpdateSpaceRequest, Space>newBuilder()
            .setMethodDescriptor(updateSpaceMethodDescriptor)
            .setParamsExtractor(
                request -> {
                  RequestParamsBuilder builder = RequestParamsBuilder.create();
                  builder.add("space.name", String.valueOf(request.getSpace().getName()));
                  return builder.build();
                })
            .build();
    GrpcCallSettings<DeleteSpaceRequest, Empty> deleteSpaceTransportSettings =
        GrpcCallSettings.<DeleteSpaceRequest, Empty>newBuilder()
            .setMethodDescriptor(deleteSpaceMethodDescriptor)
            .setParamsExtractor(
                request -> {
                  RequestParamsBuilder builder = RequestParamsBuilder.create();
                  builder.add("name", String.valueOf(request.getName()));
                  return builder.build();
                })
            .setResourceNameExtractor(request -> request.getName())
            .build();
    GrpcCallSettings<GetApplicationTemplateRequest, ApplicationTemplate>
        getApplicationTemplateTransportSettings =
            GrpcCallSettings.<GetApplicationTemplateRequest, ApplicationTemplate>newBuilder()
                .setMethodDescriptor(getApplicationTemplateMethodDescriptor)
                .setParamsExtractor(
                    request -> {
                      RequestParamsBuilder builder = RequestParamsBuilder.create();
                      builder.add("name", String.valueOf(request.getName()));
                      return builder.build();
                    })
                .setResourceNameExtractor(request -> request.getName())
                .build();
    GrpcCallSettings<ListApplicationTemplatesRequest, ListApplicationTemplatesResponse>
        listApplicationTemplatesTransportSettings =
            GrpcCallSettings
                .<ListApplicationTemplatesRequest, ListApplicationTemplatesResponse>newBuilder()
                .setMethodDescriptor(listApplicationTemplatesMethodDescriptor)
                .setParamsExtractor(
                    request -> {
                      RequestParamsBuilder builder = RequestParamsBuilder.create();
                      builder.add("parent", String.valueOf(request.getParent()));
                      return builder.build();
                    })
                .setResourceNameExtractor(request -> request.getParent())
                .build();
    GrpcCallSettings<CreateApplicationTemplateRequest, ApplicationTemplate>
        createApplicationTemplateTransportSettings =
            GrpcCallSettings.<CreateApplicationTemplateRequest, ApplicationTemplate>newBuilder()
                .setMethodDescriptor(createApplicationTemplateMethodDescriptor)
                .setParamsExtractor(
                    request -> {
                      RequestParamsBuilder builder = RequestParamsBuilder.create();
                      builder.add("parent", String.valueOf(request.getParent()));
                      return builder.build();
                    })
                .setResourceNameExtractor(request -> request.getParent())
                .build();
    GrpcCallSettings<UpdateApplicationTemplateRequest, ApplicationTemplate>
        updateApplicationTemplateTransportSettings =
            GrpcCallSettings.<UpdateApplicationTemplateRequest, ApplicationTemplate>newBuilder()
                .setMethodDescriptor(updateApplicationTemplateMethodDescriptor)
                .setParamsExtractor(
                    request -> {
                      RequestParamsBuilder builder = RequestParamsBuilder.create();
                      builder.add(
                          "application_template.name",
                          String.valueOf(request.getApplicationTemplate().getName()));
                      return builder.build();
                    })
                .build();
    GrpcCallSettings<ImportApplicationTemplateRequest, ApplicationTemplate>
        importApplicationTemplateTransportSettings =
            GrpcCallSettings.<ImportApplicationTemplateRequest, ApplicationTemplate>newBuilder()
                .setMethodDescriptor(importApplicationTemplateMethodDescriptor)
                .setParamsExtractor(
                    request -> {
                      RequestParamsBuilder builder = RequestParamsBuilder.create();
                      builder.add("name", String.valueOf(request.getName()));
                      return builder.build();
                    })
                .setResourceNameExtractor(request -> request.getApplicationTemplateRevisionUri())
                .build();
    GrpcCallSettings<DeleteApplicationTemplateRequest, Empty>
        deleteApplicationTemplateTransportSettings =
            GrpcCallSettings.<DeleteApplicationTemplateRequest, Empty>newBuilder()
                .setMethodDescriptor(deleteApplicationTemplateMethodDescriptor)
                .setParamsExtractor(
                    request -> {
                      RequestParamsBuilder builder = RequestParamsBuilder.create();
                      builder.add("name", String.valueOf(request.getName()));
                      return builder.build();
                    })
                .setResourceNameExtractor(request -> request.getName())
                .build();
    GrpcCallSettings<CommitApplicationTemplateRequest, ApplicationTemplateRevision>
        commitApplicationTemplateTransportSettings =
            GrpcCallSettings
                .<CommitApplicationTemplateRequest, ApplicationTemplateRevision>newBuilder()
                .setMethodDescriptor(commitApplicationTemplateMethodDescriptor)
                .setParamsExtractor(
                    request -> {
                      RequestParamsBuilder builder = RequestParamsBuilder.create();
                      builder.add("name", String.valueOf(request.getName()));
                      return builder.build();
                    })
                .setResourceNameExtractor(request -> request.getName())
                .build();
    GrpcCallSettings<SnapshotApplicationTemplateRequest, Operation>
        snapshotApplicationTemplateTransportSettings =
            GrpcCallSettings.<SnapshotApplicationTemplateRequest, Operation>newBuilder()
                .setMethodDescriptor(snapshotApplicationTemplateMethodDescriptor)
                .setParamsExtractor(
                    request -> {
                      RequestParamsBuilder builder = RequestParamsBuilder.create();
                      builder.add("name", String.valueOf(request.getName()));
                      return builder.build();
                    })
                .setResourceNameExtractor(request -> request.getName())
                .build();
    GrpcCallSettings<GenerateApplicationTemplateIaCRequest, GenerateApplicationTemplateIaCResponse>
        generateApplicationTemplateIaCTransportSettings =
            GrpcCallSettings
                .<GenerateApplicationTemplateIaCRequest, GenerateApplicationTemplateIaCResponse>
                    newBuilder()
                .setMethodDescriptor(generateApplicationTemplateIaCMethodDescriptor)
                .setParamsExtractor(
                    request -> {
                      RequestParamsBuilder builder = RequestParamsBuilder.create();
                      builder.add("name", String.valueOf(request.getName()));
                      return builder.build();
                    })
                .setResourceNameExtractor(request -> request.getName())
                .build();
    GrpcCallSettings<ExportApplicationTemplateIaCRequest, Operation>
        exportApplicationTemplateIaCTransportSettings =
            GrpcCallSettings.<ExportApplicationTemplateIaCRequest, Operation>newBuilder()
                .setMethodDescriptor(exportApplicationTemplateIaCMethodDescriptor)
                .setParamsExtractor(
                    request -> {
                      RequestParamsBuilder builder = RequestParamsBuilder.create();
                      builder.add("name", String.valueOf(request.getName()));
                      return builder.build();
                    })
                .setResourceNameExtractor(request -> request.getName())
                .build();
    GrpcCallSettings<
            GenerateApplicationTemplateRevisionIaCRequest,
            GenerateApplicationTemplateRevisionIaCResponse>
        generateApplicationTemplateRevisionIaCTransportSettings =
            GrpcCallSettings
                .<GenerateApplicationTemplateRevisionIaCRequest,
                    GenerateApplicationTemplateRevisionIaCResponse>
                    newBuilder()
                .setMethodDescriptor(generateApplicationTemplateRevisionIaCMethodDescriptor)
                .setParamsExtractor(
                    request -> {
                      RequestParamsBuilder builder = RequestParamsBuilder.create();
                      builder.add("name", String.valueOf(request.getName()));
                      return builder.build();
                    })
                .setResourceNameExtractor(request -> request.getName())
                .build();
    GrpcCallSettings<ExportApplicationTemplateRevisionIaCRequest, Operation>
        exportApplicationTemplateRevisionIaCTransportSettings =
            GrpcCallSettings.<ExportApplicationTemplateRevisionIaCRequest, Operation>newBuilder()
                .setMethodDescriptor(exportApplicationTemplateRevisionIaCMethodDescriptor)
                .setParamsExtractor(
                    request -> {
                      RequestParamsBuilder builder = RequestParamsBuilder.create();
                      builder.add("name", String.valueOf(request.getName()));
                      return builder.build();
                    })
                .setResourceNameExtractor(request -> request.getName())
                .build();
    GrpcCallSettings<GetComponentRequest, Component> getComponentTransportSettings =
        GrpcCallSettings.<GetComponentRequest, Component>newBuilder()
            .setMethodDescriptor(getComponentMethodDescriptor)
            .setParamsExtractor(
                request -> {
                  RequestParamsBuilder builder = RequestParamsBuilder.create();
                  builder.add("name", String.valueOf(request.getName()));
                  return builder.build();
                })
            .setResourceNameExtractor(request -> request.getName())
            .build();
    GrpcCallSettings<ListComponentsRequest, ListComponentsResponse>
        listComponentsTransportSettings =
            GrpcCallSettings.<ListComponentsRequest, ListComponentsResponse>newBuilder()
                .setMethodDescriptor(listComponentsMethodDescriptor)
                .setParamsExtractor(
                    request -> {
                      RequestParamsBuilder builder = RequestParamsBuilder.create();
                      builder.add("parent", String.valueOf(request.getParent()));
                      return builder.build();
                    })
                .setResourceNameExtractor(request -> request.getParent())
                .build();
    GrpcCallSettings<CreateComponentRequest, Component> createComponentTransportSettings =
        GrpcCallSettings.<CreateComponentRequest, Component>newBuilder()
            .setMethodDescriptor(createComponentMethodDescriptor)
            .setParamsExtractor(
                request -> {
                  RequestParamsBuilder builder = RequestParamsBuilder.create();
                  builder.add("parent", String.valueOf(request.getParent()));
                  return builder.build();
                })
            .setResourceNameExtractor(request -> request.getParent())
            .build();
    GrpcCallSettings<UpdateComponentRequest, Component> updateComponentTransportSettings =
        GrpcCallSettings.<UpdateComponentRequest, Component>newBuilder()
            .setMethodDescriptor(updateComponentMethodDescriptor)
            .setParamsExtractor(
                request -> {
                  RequestParamsBuilder builder = RequestParamsBuilder.create();
                  builder.add("component.name", String.valueOf(request.getComponent().getName()));
                  return builder.build();
                })
            .build();
    GrpcCallSettings<DeleteComponentRequest, Empty> deleteComponentTransportSettings =
        GrpcCallSettings.<DeleteComponentRequest, Empty>newBuilder()
            .setMethodDescriptor(deleteComponentMethodDescriptor)
            .setParamsExtractor(
                request -> {
                  RequestParamsBuilder builder = RequestParamsBuilder.create();
                  builder.add("name", String.valueOf(request.getName()));
                  return builder.build();
                })
            .setResourceNameExtractor(request -> request.getName())
            .build();
    GrpcCallSettings<GetConnectionRequest, Connection> getConnectionTransportSettings =
        GrpcCallSettings.<GetConnectionRequest, Connection>newBuilder()
            .setMethodDescriptor(getConnectionMethodDescriptor)
            .setParamsExtractor(
                request -> {
                  RequestParamsBuilder builder = RequestParamsBuilder.create();
                  builder.add("name", String.valueOf(request.getName()));
                  return builder.build();
                })
            .setResourceNameExtractor(request -> request.getName())
            .build();
    GrpcCallSettings<ListConnectionsRequest, ListConnectionsResponse>
        listConnectionsTransportSettings =
            GrpcCallSettings.<ListConnectionsRequest, ListConnectionsResponse>newBuilder()
                .setMethodDescriptor(listConnectionsMethodDescriptor)
                .setParamsExtractor(
                    request -> {
                      RequestParamsBuilder builder = RequestParamsBuilder.create();
                      builder.add("parent", String.valueOf(request.getParent()));
                      return builder.build();
                    })
                .setResourceNameExtractor(request -> request.getParent())
                .build();
    GrpcCallSettings<CreateConnectionRequest, Connection> createConnectionTransportSettings =
        GrpcCallSettings.<CreateConnectionRequest, Connection>newBuilder()
            .setMethodDescriptor(createConnectionMethodDescriptor)
            .setParamsExtractor(
                request -> {
                  RequestParamsBuilder builder = RequestParamsBuilder.create();
                  builder.add("parent", String.valueOf(request.getParent()));
                  return builder.build();
                })
            .setResourceNameExtractor(request -> request.getParent())
            .build();
    GrpcCallSettings<UpdateConnectionRequest, Connection> updateConnectionTransportSettings =
        GrpcCallSettings.<UpdateConnectionRequest, Connection>newBuilder()
            .setMethodDescriptor(updateConnectionMethodDescriptor)
            .setParamsExtractor(
                request -> {
                  RequestParamsBuilder builder = RequestParamsBuilder.create();
                  builder.add("connection.name", String.valueOf(request.getConnection().getName()));
                  return builder.build();
                })
            .build();
    GrpcCallSettings<DeleteConnectionRequest, Empty> deleteConnectionTransportSettings =
        GrpcCallSettings.<DeleteConnectionRequest, Empty>newBuilder()
            .setMethodDescriptor(deleteConnectionMethodDescriptor)
            .setParamsExtractor(
                request -> {
                  RequestParamsBuilder builder = RequestParamsBuilder.create();
                  builder.add("name", String.valueOf(request.getName()));
                  return builder.build();
                })
            .setResourceNameExtractor(request -> request.getName())
            .build();
    GrpcCallSettings<GetApplicationTemplateRevisionRequest, ApplicationTemplateRevision>
        getApplicationTemplateRevisionTransportSettings =
            GrpcCallSettings
                .<GetApplicationTemplateRevisionRequest, ApplicationTemplateRevision>newBuilder()
                .setMethodDescriptor(getApplicationTemplateRevisionMethodDescriptor)
                .setParamsExtractor(
                    request -> {
                      RequestParamsBuilder builder = RequestParamsBuilder.create();
                      builder.add("name", String.valueOf(request.getName()));
                      return builder.build();
                    })
                .setResourceNameExtractor(request -> request.getName())
                .build();
    GrpcCallSettings<
            ListApplicationTemplateRevisionsRequest, ListApplicationTemplateRevisionsResponse>
        listApplicationTemplateRevisionsTransportSettings =
            GrpcCallSettings
                .<ListApplicationTemplateRevisionsRequest, ListApplicationTemplateRevisionsResponse>
                    newBuilder()
                .setMethodDescriptor(listApplicationTemplateRevisionsMethodDescriptor)
                .setParamsExtractor(
                    request -> {
                      RequestParamsBuilder builder = RequestParamsBuilder.create();
                      builder.add("parent", String.valueOf(request.getParent()));
                      return builder.build();
                    })
                .setResourceNameExtractor(request -> request.getParent())
                .build();
    GrpcCallSettings<DeleteApplicationTemplateRevisionRequest, Empty>
        deleteApplicationTemplateRevisionTransportSettings =
            GrpcCallSettings.<DeleteApplicationTemplateRevisionRequest, Empty>newBuilder()
                .setMethodDescriptor(deleteApplicationTemplateRevisionMethodDescriptor)
                .setParamsExtractor(
                    request -> {
                      RequestParamsBuilder builder = RequestParamsBuilder.create();
                      builder.add("name", String.valueOf(request.getName()));
                      return builder.build();
                    })
                .setResourceNameExtractor(request -> request.getName())
                .build();
    GrpcCallSettings<GetCatalogRequest, Catalog> getCatalogTransportSettings =
        GrpcCallSettings.<GetCatalogRequest, Catalog>newBuilder()
            .setMethodDescriptor(getCatalogMethodDescriptor)
            .setParamsExtractor(
                request -> {
                  RequestParamsBuilder builder = RequestParamsBuilder.create();
                  builder.add("name", String.valueOf(request.getName()));
                  return builder.build();
                })
            .setResourceNameExtractor(request -> request.getName())
            .build();
    GrpcCallSettings<ListCatalogsRequest, ListCatalogsResponse> listCatalogsTransportSettings =
        GrpcCallSettings.<ListCatalogsRequest, ListCatalogsResponse>newBuilder()
            .setMethodDescriptor(listCatalogsMethodDescriptor)
            .setParamsExtractor(
                request -> {
                  RequestParamsBuilder builder = RequestParamsBuilder.create();
                  builder.add("parent", String.valueOf(request.getParent()));
                  return builder.build();
                })
            .setResourceNameExtractor(request -> request.getParent())
            .build();
    GrpcCallSettings<CreateCatalogRequest, Catalog> createCatalogTransportSettings =
        GrpcCallSettings.<CreateCatalogRequest, Catalog>newBuilder()
            .setMethodDescriptor(createCatalogMethodDescriptor)
            .setParamsExtractor(
                request -> {
                  RequestParamsBuilder builder = RequestParamsBuilder.create();
                  builder.add("parent", String.valueOf(request.getParent()));
                  return builder.build();
                })
            .setResourceNameExtractor(request -> request.getParent())
            .build();
    GrpcCallSettings<UpdateCatalogRequest, Catalog> updateCatalogTransportSettings =
        GrpcCallSettings.<UpdateCatalogRequest, Catalog>newBuilder()
            .setMethodDescriptor(updateCatalogMethodDescriptor)
            .setParamsExtractor(
                request -> {
                  RequestParamsBuilder builder = RequestParamsBuilder.create();
                  builder.add("catalog.name", String.valueOf(request.getCatalog().getName()));
                  return builder.build();
                })
            .build();
    GrpcCallSettings<DeleteCatalogRequest, Operation> deleteCatalogTransportSettings =
        GrpcCallSettings.<DeleteCatalogRequest, Operation>newBuilder()
            .setMethodDescriptor(deleteCatalogMethodDescriptor)
            .setParamsExtractor(
                request -> {
                  RequestParamsBuilder builder = RequestParamsBuilder.create();
                  builder.add("name", String.valueOf(request.getName()));
                  return builder.build();
                })
            .setResourceNameExtractor(request -> request.getName())
            .build();
    GrpcCallSettings<CreateCatalogTemplateRequest, CatalogTemplate>
        createCatalogTemplateTransportSettings =
            GrpcCallSettings.<CreateCatalogTemplateRequest, CatalogTemplate>newBuilder()
                .setMethodDescriptor(createCatalogTemplateMethodDescriptor)
                .setParamsExtractor(
                    request -> {
                      RequestParamsBuilder builder = RequestParamsBuilder.create();
                      builder.add("parent", String.valueOf(request.getParent()));
                      return builder.build();
                    })
                .setResourceNameExtractor(request -> request.getParent())
                .build();
    GrpcCallSettings<GetCatalogTemplateRequest, CatalogTemplate>
        getCatalogTemplateTransportSettings =
            GrpcCallSettings.<GetCatalogTemplateRequest, CatalogTemplate>newBuilder()
                .setMethodDescriptor(getCatalogTemplateMethodDescriptor)
                .setParamsExtractor(
                    request -> {
                      RequestParamsBuilder builder = RequestParamsBuilder.create();
                      builder.add("name", String.valueOf(request.getName()));
                      return builder.build();
                    })
                .setResourceNameExtractor(request -> request.getName())
                .build();
    GrpcCallSettings<ListCatalogTemplatesRequest, ListCatalogTemplatesResponse>
        listCatalogTemplatesTransportSettings =
            GrpcCallSettings.<ListCatalogTemplatesRequest, ListCatalogTemplatesResponse>newBuilder()
                .setMethodDescriptor(listCatalogTemplatesMethodDescriptor)
                .setParamsExtractor(
                    request -> {
                      RequestParamsBuilder builder = RequestParamsBuilder.create();
                      builder.add("parent", String.valueOf(request.getParent()));
                      return builder.build();
                    })
                .setResourceNameExtractor(request -> request.getParent())
                .build();
    GrpcCallSettings<UpdateCatalogTemplateRequest, CatalogTemplate>
        updateCatalogTemplateTransportSettings =
            GrpcCallSettings.<UpdateCatalogTemplateRequest, CatalogTemplate>newBuilder()
                .setMethodDescriptor(updateCatalogTemplateMethodDescriptor)
                .setParamsExtractor(
                    request -> {
                      RequestParamsBuilder builder = RequestParamsBuilder.create();
                      builder.add(
                          "catalog_template.name",
                          String.valueOf(request.getCatalogTemplate().getName()));
                      return builder.build();
                    })
                .build();
    GrpcCallSettings<DeleteCatalogTemplateRequest, Operation>
        deleteCatalogTemplateTransportSettings =
            GrpcCallSettings.<DeleteCatalogTemplateRequest, Operation>newBuilder()
                .setMethodDescriptor(deleteCatalogTemplateMethodDescriptor)
                .setParamsExtractor(
                    request -> {
                      RequestParamsBuilder builder = RequestParamsBuilder.create();
                      builder.add("name", String.valueOf(request.getName()));
                      return builder.build();
                    })
                .setResourceNameExtractor(request -> request.getName())
                .build();
    GrpcCallSettings<CreateShareRequest, Operation> createShareTransportSettings =
        GrpcCallSettings.<CreateShareRequest, Operation>newBuilder()
            .setMethodDescriptor(createShareMethodDescriptor)
            .setParamsExtractor(
                request -> {
                  RequestParamsBuilder builder = RequestParamsBuilder.create();
                  builder.add("parent", String.valueOf(request.getParent()));
                  return builder.build();
                })
            .setResourceNameExtractor(request -> request.getParent())
            .build();
    GrpcCallSettings<ListSharesRequest, ListSharesResponse> listSharesTransportSettings =
        GrpcCallSettings.<ListSharesRequest, ListSharesResponse>newBuilder()
            .setMethodDescriptor(listSharesMethodDescriptor)
            .setParamsExtractor(
                request -> {
                  RequestParamsBuilder builder = RequestParamsBuilder.create();
                  builder.add("parent", String.valueOf(request.getParent()));
                  return builder.build();
                })
            .setResourceNameExtractor(request -> request.getParent())
            .build();
    GrpcCallSettings<GetShareRequest, Share> getShareTransportSettings =
        GrpcCallSettings.<GetShareRequest, Share>newBuilder()
            .setMethodDescriptor(getShareMethodDescriptor)
            .setParamsExtractor(
                request -> {
                  RequestParamsBuilder builder = RequestParamsBuilder.create();
                  builder.add("name", String.valueOf(request.getName()));
                  return builder.build();
                })
            .setResourceNameExtractor(request -> request.getName())
            .build();
    GrpcCallSettings<DeleteShareRequest, Operation> deleteShareTransportSettings =
        GrpcCallSettings.<DeleteShareRequest, Operation>newBuilder()
            .setMethodDescriptor(deleteShareMethodDescriptor)
            .setParamsExtractor(
                request -> {
                  RequestParamsBuilder builder = RequestParamsBuilder.create();
                  builder.add("name", String.valueOf(request.getName()));
                  return builder.build();
                })
            .setResourceNameExtractor(request -> request.getName())
            .build();
    GrpcCallSettings<SyncShareRequest, Operation> syncShareTransportSettings =
        GrpcCallSettings.<SyncShareRequest, Operation>newBuilder()
            .setMethodDescriptor(syncShareMethodDescriptor)
            .setParamsExtractor(
                request -> {
                  RequestParamsBuilder builder = RequestParamsBuilder.create();
                  builder.add("name", String.valueOf(request.getName()));
                  return builder.build();
                })
            .setResourceNameExtractor(request -> request.getName())
            .build();
    GrpcCallSettings<GetSharedTemplateRequest, SharedTemplate> getSharedTemplateTransportSettings =
        GrpcCallSettings.<GetSharedTemplateRequest, SharedTemplate>newBuilder()
            .setMethodDescriptor(getSharedTemplateMethodDescriptor)
            .setParamsExtractor(
                request -> {
                  RequestParamsBuilder builder = RequestParamsBuilder.create();
                  builder.add("name", String.valueOf(request.getName()));
                  return builder.build();
                })
            .setResourceNameExtractor(request -> request.getName())
            .build();
    GrpcCallSettings<ListSharedTemplatesRequest, ListSharedTemplatesResponse>
        listSharedTemplatesTransportSettings =
            GrpcCallSettings.<ListSharedTemplatesRequest, ListSharedTemplatesResponse>newBuilder()
                .setMethodDescriptor(listSharedTemplatesMethodDescriptor)
                .setParamsExtractor(
                    request -> {
                      RequestParamsBuilder builder = RequestParamsBuilder.create();
                      builder.add("parent", String.valueOf(request.getParent()));
                      return builder.build();
                    })
                .setResourceNameExtractor(request -> request.getParent())
                .build();
    GrpcCallSettings<GetSharedTemplateRevisionRequest, SharedTemplateRevision>
        getSharedTemplateRevisionTransportSettings =
            GrpcCallSettings.<GetSharedTemplateRevisionRequest, SharedTemplateRevision>newBuilder()
                .setMethodDescriptor(getSharedTemplateRevisionMethodDescriptor)
                .setParamsExtractor(
                    request -> {
                      RequestParamsBuilder builder = RequestParamsBuilder.create();
                      builder.add("name", String.valueOf(request.getName()));
                      return builder.build();
                    })
                .setResourceNameExtractor(request -> request.getName())
                .build();
    GrpcCallSettings<ListSharedTemplateRevisionsRequest, ListSharedTemplateRevisionsResponse>
        listSharedTemplateRevisionsTransportSettings =
            GrpcCallSettings
                .<ListSharedTemplateRevisionsRequest, ListSharedTemplateRevisionsResponse>
                    newBuilder()
                .setMethodDescriptor(listSharedTemplateRevisionsMethodDescriptor)
                .setParamsExtractor(
                    request -> {
                      RequestParamsBuilder builder = RequestParamsBuilder.create();
                      builder.add("parent", String.valueOf(request.getParent()));
                      return builder.build();
                    })
                .setResourceNameExtractor(request -> request.getParent())
                .build();
    GrpcCallSettings<CreateCatalogTemplateRevisionRequest, Operation>
        createCatalogTemplateRevisionTransportSettings =
            GrpcCallSettings.<CreateCatalogTemplateRevisionRequest, Operation>newBuilder()
                .setMethodDescriptor(createCatalogTemplateRevisionMethodDescriptor)
                .setParamsExtractor(
                    request -> {
                      RequestParamsBuilder builder = RequestParamsBuilder.create();
                      builder.add("parent", String.valueOf(request.getParent()));
                      return builder.build();
                    })
                .setResourceNameExtractor(request -> request.getParent())
                .build();
    GrpcCallSettings<GetCatalogTemplateRevisionRequest, CatalogTemplateRevision>
        getCatalogTemplateRevisionTransportSettings =
            GrpcCallSettings
                .<GetCatalogTemplateRevisionRequest, CatalogTemplateRevision>newBuilder()
                .setMethodDescriptor(getCatalogTemplateRevisionMethodDescriptor)
                .setParamsExtractor(
                    request -> {
                      RequestParamsBuilder builder = RequestParamsBuilder.create();
                      builder.add("name", String.valueOf(request.getName()));
                      return builder.build();
                    })
                .setResourceNameExtractor(request -> request.getName())
                .build();
    GrpcCallSettings<ListCatalogTemplateRevisionsRequest, ListCatalogTemplateRevisionsResponse>
        listCatalogTemplateRevisionsTransportSettings =
            GrpcCallSettings
                .<ListCatalogTemplateRevisionsRequest, ListCatalogTemplateRevisionsResponse>
                    newBuilder()
                .setMethodDescriptor(listCatalogTemplateRevisionsMethodDescriptor)
                .setParamsExtractor(
                    request -> {
                      RequestParamsBuilder builder = RequestParamsBuilder.create();
                      builder.add("parent", String.valueOf(request.getParent()));
                      return builder.build();
                    })
                .setResourceNameExtractor(request -> request.getParent())
                .build();
    GrpcCallSettings<DeleteCatalogTemplateRevisionRequest, Operation>
        deleteCatalogTemplateRevisionTransportSettings =
            GrpcCallSettings.<DeleteCatalogTemplateRevisionRequest, Operation>newBuilder()
                .setMethodDescriptor(deleteCatalogTemplateRevisionMethodDescriptor)
                .setParamsExtractor(
                    request -> {
                      RequestParamsBuilder builder = RequestParamsBuilder.create();
                      builder.add("name", String.valueOf(request.getName()));
                      return builder.build();
                    })
                .setResourceNameExtractor(request -> request.getName())
                .build();
    GrpcCallSettings<CreateApplicationRequest, Application> createApplicationTransportSettings =
        GrpcCallSettings.<CreateApplicationRequest, Application>newBuilder()
            .setMethodDescriptor(createApplicationMethodDescriptor)
            .setParamsExtractor(
                request -> {
                  RequestParamsBuilder builder = RequestParamsBuilder.create();
                  builder.add("parent", String.valueOf(request.getParent()));
                  return builder.build();
                })
            .setResourceNameExtractor(request -> request.getParent())
            .build();
    GrpcCallSettings<GetApplicationRequest, Application> getApplicationTransportSettings =
        GrpcCallSettings.<GetApplicationRequest, Application>newBuilder()
            .setMethodDescriptor(getApplicationMethodDescriptor)
            .setParamsExtractor(
                request -> {
                  RequestParamsBuilder builder = RequestParamsBuilder.create();
                  builder.add("name", String.valueOf(request.getName()));
                  return builder.build();
                })
            .setResourceNameExtractor(request -> request.getName())
            .build();
    GrpcCallSettings<ListApplicationsRequest, ListApplicationsResponse>
        listApplicationsTransportSettings =
            GrpcCallSettings.<ListApplicationsRequest, ListApplicationsResponse>newBuilder()
                .setMethodDescriptor(listApplicationsMethodDescriptor)
                .setParamsExtractor(
                    request -> {
                      RequestParamsBuilder builder = RequestParamsBuilder.create();
                      builder.add("parent", String.valueOf(request.getParent()));
                      return builder.build();
                    })
                .setResourceNameExtractor(request -> request.getParent())
                .build();
    GrpcCallSettings<UpdateApplicationRequest, Application> updateApplicationTransportSettings =
        GrpcCallSettings.<UpdateApplicationRequest, Application>newBuilder()
            .setMethodDescriptor(updateApplicationMethodDescriptor)
            .setParamsExtractor(
                request -> {
                  RequestParamsBuilder builder = RequestParamsBuilder.create();
                  builder.add(
                      "application.name", String.valueOf(request.getApplication().getName()));
                  return builder.build();
                })
            .build();
    GrpcCallSettings<DeleteApplicationRequest, Operation> deleteApplicationTransportSettings =
        GrpcCallSettings.<DeleteApplicationRequest, Operation>newBuilder()
            .setMethodDescriptor(deleteApplicationMethodDescriptor)
            .setParamsExtractor(
                request -> {
                  RequestParamsBuilder builder = RequestParamsBuilder.create();
                  builder.add("name", String.valueOf(request.getName()));
                  return builder.build();
                })
            .setResourceNameExtractor(request -> request.getName())
            .build();
    GrpcCallSettings<DeployApplicationRequest, Operation> deployApplicationTransportSettings =
        GrpcCallSettings.<DeployApplicationRequest, Operation>newBuilder()
            .setMethodDescriptor(deployApplicationMethodDescriptor)
            .setParamsExtractor(
                request -> {
                  RequestParamsBuilder builder = RequestParamsBuilder.create();
                  builder.add("name", String.valueOf(request.getName()));
                  return builder.build();
                })
            .setResourceNameExtractor(request -> request.getName())
            .build();
    GrpcCallSettings<PreviewApplicationRequest, Operation> previewApplicationTransportSettings =
        GrpcCallSettings.<PreviewApplicationRequest, Operation>newBuilder()
            .setMethodDescriptor(previewApplicationMethodDescriptor)
            .setParamsExtractor(
                request -> {
                  RequestParamsBuilder builder = RequestParamsBuilder.create();
                  builder.add("name", String.valueOf(request.getName()));
                  return builder.build();
                })
            .setResourceNameExtractor(request -> request.getName())
            .build();
    GrpcCallSettings<
            FetchApplicationAssessmentReportRequest, FetchApplicationAssessmentReportResponse>
        fetchApplicationAssessmentReportTransportSettings =
            GrpcCallSettings
                .<FetchApplicationAssessmentReportRequest, FetchApplicationAssessmentReportResponse>
                    newBuilder()
                .setMethodDescriptor(fetchApplicationAssessmentReportMethodDescriptor)
                .setParamsExtractor(
                    request -> {
                      RequestParamsBuilder builder = RequestParamsBuilder.create();
                      builder.add("name", String.valueOf(request.getName()));
                      return builder.build();
                    })
                .setResourceNameExtractor(request -> request.getName())
                .build();
    GrpcCallSettings<GenerateApplicationAssessmentReportRequest, Operation>
        generateApplicationAssessmentReportTransportSettings =
            GrpcCallSettings.<GenerateApplicationAssessmentReportRequest, Operation>newBuilder()
                .setMethodDescriptor(generateApplicationAssessmentReportMethodDescriptor)
                .setParamsExtractor(
                    request -> {
                      RequestParamsBuilder builder = RequestParamsBuilder.create();
                      builder.add("name", String.valueOf(request.getName()));
                      return builder.build();
                    })
                .setResourceNameExtractor(request -> request.getName())
                .build();
    GrpcCallSettings<GenerateApplicationTemplateAssessmentReportRequest, Operation>
        generateApplicationTemplateAssessmentReportTransportSettings =
            GrpcCallSettings
                .<GenerateApplicationTemplateAssessmentReportRequest, Operation>newBuilder()
                .setMethodDescriptor(generateApplicationTemplateAssessmentReportMethodDescriptor)
                .setParamsExtractor(
                    request -> {
                      RequestParamsBuilder builder = RequestParamsBuilder.create();
                      builder.add("name", String.valueOf(request.getName()));
                      return builder.build();
                    })
                .setResourceNameExtractor(request -> request.getName())
                .build();
    GrpcCallSettings<GenerateAssessmentReportRequest, Operation>
        generateAssessmentReportTransportSettings =
            GrpcCallSettings.<GenerateAssessmentReportRequest, Operation>newBuilder()
                .setMethodDescriptor(generateAssessmentReportMethodDescriptor)
                .setParamsExtractor(
                    request -> {
                      RequestParamsBuilder builder = RequestParamsBuilder.create();
                      builder.add("space_name", String.valueOf(request.getSpaceName()));
                      return builder.build();
                    })
                .setResourceNameExtractor(request -> request.getSpaceName())
                .build();
    GrpcCallSettings<GenerateTerraformPlanAssessmentReportRequest, Operation>
        generateTerraformPlanAssessmentReportTransportSettings =
            GrpcCallSettings.<GenerateTerraformPlanAssessmentReportRequest, Operation>newBuilder()
                .setMethodDescriptor(generateTerraformPlanAssessmentReportMethodDescriptor)
                .setParamsExtractor(
                    request -> {
                      RequestParamsBuilder builder = RequestParamsBuilder.create();
                      builder.add("name", String.valueOf(request.getName()));
                      return builder.build();
                    })
                .setResourceNameExtractor(request -> request.getName())
                .build();
    GrpcCallSettings<GetPolicyRequest, Policy> getPolicyTransportSettings =
        GrpcCallSettings.<GetPolicyRequest, Policy>newBuilder()
            .setMethodDescriptor(getPolicyMethodDescriptor)
            .setParamsExtractor(
                request -> {
                  RequestParamsBuilder builder = RequestParamsBuilder.create();
                  builder.add("name", String.valueOf(request.getName()));
                  return builder.build();
                })
            .setResourceNameExtractor(request -> request.getName())
            .build();
    GrpcCallSettings<ListPoliciesRequest, ListPoliciesResponse> listPoliciesTransportSettings =
        GrpcCallSettings.<ListPoliciesRequest, ListPoliciesResponse>newBuilder()
            .setMethodDescriptor(listPoliciesMethodDescriptor)
            .setParamsExtractor(
                request -> {
                  RequestParamsBuilder builder = RequestParamsBuilder.create();
                  builder.add("parent", String.valueOf(request.getParent()));
                  return builder.build();
                })
            .setResourceNameExtractor(request -> request.getParent())
            .build();
    GrpcCallSettings<CreatePolicyRequest, Policy> createPolicyTransportSettings =
        GrpcCallSettings.<CreatePolicyRequest, Policy>newBuilder()
            .setMethodDescriptor(createPolicyMethodDescriptor)
            .setParamsExtractor(
                request -> {
                  RequestParamsBuilder builder = RequestParamsBuilder.create();
                  builder.add("parent", String.valueOf(request.getParent()));
                  return builder.build();
                })
            .setResourceNameExtractor(request -> request.getParent())
            .build();
    GrpcCallSettings<UpdatePolicyRequest, Policy> updatePolicyTransportSettings =
        GrpcCallSettings.<UpdatePolicyRequest, Policy>newBuilder()
            .setMethodDescriptor(updatePolicyMethodDescriptor)
            .setParamsExtractor(
                request -> {
                  RequestParamsBuilder builder = RequestParamsBuilder.create();
                  builder.add("policy.name", String.valueOf(request.getPolicy().getName()));
                  return builder.build();
                })
            .build();
    GrpcCallSettings<DeletePolicyRequest, Empty> deletePolicyTransportSettings =
        GrpcCallSettings.<DeletePolicyRequest, Empty>newBuilder()
            .setMethodDescriptor(deletePolicyMethodDescriptor)
            .setParamsExtractor(
                request -> {
                  RequestParamsBuilder builder = RequestParamsBuilder.create();
                  builder.add("name", String.valueOf(request.getName()));
                  return builder.build();
                })
            .setResourceNameExtractor(request -> request.getName())
            .build();
    GrpcCallSettings<FetchFrameworksRequest, FetchFrameworksResponse>
        fetchFrameworksTransportSettings =
            GrpcCallSettings.<FetchFrameworksRequest, FetchFrameworksResponse>newBuilder()
                .setMethodDescriptor(fetchFrameworksMethodDescriptor)
                .setParamsExtractor(
                    request -> {
                      RequestParamsBuilder builder = RequestParamsBuilder.create();
                      builder.add("parent", String.valueOf(request.getParent()));
                      return builder.build();
                    })
                .build();
    GrpcCallSettings<GenerateApplicationIaCRequest, GenerateApplicationIaCResponse>
        generateApplicationIaCTransportSettings =
            GrpcCallSettings
                .<GenerateApplicationIaCRequest, GenerateApplicationIaCResponse>newBuilder()
                .setMethodDescriptor(generateApplicationIaCMethodDescriptor)
                .setParamsExtractor(
                    request -> {
                      RequestParamsBuilder builder = RequestParamsBuilder.create();
                      builder.add("name", String.valueOf(request.getName()));
                      return builder.build();
                    })
                .setResourceNameExtractor(request -> request.getName())
                .build();
    GrpcCallSettings<ExportApplicationIaCRequest, Operation> exportApplicationIaCTransportSettings =
        GrpcCallSettings.<ExportApplicationIaCRequest, Operation>newBuilder()
            .setMethodDescriptor(exportApplicationIaCMethodDescriptor)
            .setParamsExtractor(
                request -> {
                  RequestParamsBuilder builder = RequestParamsBuilder.create();
                  builder.add("name", String.valueOf(request.getName()));
                  return builder.build();
                })
            .setResourceNameExtractor(request -> request.getName())
            .build();
    GrpcCallSettings<ImportApplicationTemplateIaCRequest, ImportApplicationTemplateIaCResponse>
        importApplicationTemplateIaCTransportSettings =
            GrpcCallSettings
                .<ImportApplicationTemplateIaCRequest, ImportApplicationTemplateIaCResponse>
                    newBuilder()
                .setMethodDescriptor(importApplicationTemplateIaCMethodDescriptor)
                .setParamsExtractor(
                    request -> {
                      RequestParamsBuilder builder = RequestParamsBuilder.create();
                      builder.add("name", String.valueOf(request.getName()));
                      return builder.build();
                    })
                .setResourceNameExtractor(request -> request.getName())
                .build();
    GrpcCallSettings<IngestApplicationTemplateIaCRequest, Operation>
        ingestApplicationTemplateIaCTransportSettings =
            GrpcCallSettings.<IngestApplicationTemplateIaCRequest, Operation>newBuilder()
                .setMethodDescriptor(ingestApplicationTemplateIaCMethodDescriptor)
                .setParamsExtractor(
                    request -> {
                      RequestParamsBuilder builder = RequestParamsBuilder.create();
                      builder.add("name", String.valueOf(request.getName()));
                      return builder.build();
                    })
                .setResourceNameExtractor(request -> request.getName())
                .build();
    GrpcCallSettings<ImportApplicationIaCRequest, ImportApplicationIaCResponse>
        importApplicationIaCTransportSettings =
            GrpcCallSettings.<ImportApplicationIaCRequest, ImportApplicationIaCResponse>newBuilder()
                .setMethodDescriptor(importApplicationIaCMethodDescriptor)
                .setParamsExtractor(
                    request -> {
                      RequestParamsBuilder builder = RequestParamsBuilder.create();
                      builder.add("name", String.valueOf(request.getName()));
                      return builder.build();
                    })
                .setResourceNameExtractor(request -> request.getName())
                .build();
    GrpcCallSettings<RegisterAppHubApplicationResourcesRequest, Operation>
        registerAppHubApplicationResourcesTransportSettings =
            GrpcCallSettings.<RegisterAppHubApplicationResourcesRequest, Operation>newBuilder()
                .setMethodDescriptor(registerAppHubApplicationResourcesMethodDescriptor)
                .setParamsExtractor(
                    request -> {
                      RequestParamsBuilder builder = RequestParamsBuilder.create();
                      builder.add("parent", String.valueOf(request.getParent()));
                      return builder.build();
                    })
                .setResourceNameExtractor(request -> request.getParent())
                .build();
    GrpcCallSettings<
            ListApplicationTemplateSystemRevisionsRequest,
            ListApplicationTemplateSystemRevisionsResponse>
        listApplicationTemplateSystemRevisionsTransportSettings =
            GrpcCallSettings
                .<ListApplicationTemplateSystemRevisionsRequest,
                    ListApplicationTemplateSystemRevisionsResponse>
                    newBuilder()
                .setMethodDescriptor(listApplicationTemplateSystemRevisionsMethodDescriptor)
                .setParamsExtractor(
                    request -> {
                      RequestParamsBuilder builder = RequestParamsBuilder.create();
                      builder.add("parent", String.valueOf(request.getParent()));
                      return builder.build();
                    })
                .setResourceNameExtractor(request -> request.getParent())
                .build();
    GrpcCallSettings<GetApplicationTemplateSystemRevisionRequest, ApplicationTemplateSystemRevision>
        getApplicationTemplateSystemRevisionTransportSettings =
            GrpcCallSettings
                .<GetApplicationTemplateSystemRevisionRequest, ApplicationTemplateSystemRevision>
                    newBuilder()
                .setMethodDescriptor(getApplicationTemplateSystemRevisionMethodDescriptor)
                .setParamsExtractor(
                    request -> {
                      RequestParamsBuilder builder = RequestParamsBuilder.create();
                      builder.add("name", String.valueOf(request.getName()));
                      return builder.build();
                    })
                .setResourceNameExtractor(request -> request.getName())
                .build();
    GrpcCallSettings<RecommendIAMRolesRequest, Operation> recommendIAMRolesTransportSettings =
        GrpcCallSettings.<RecommendIAMRolesRequest, Operation>newBuilder()
            .setMethodDescriptor(recommendIAMRolesMethodDescriptor)
            .setParamsExtractor(
                request -> {
                  RequestParamsBuilder builder = RequestParamsBuilder.create();
                  builder.add("name", String.valueOf(request.getName()));
                  return builder.build();
                })
            .setResourceNameExtractor(request -> request.getName())
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
    GrpcCallSettings<SetIamPolicyRequest, com.google.iam.v1.Policy> setIamPolicyTransportSettings =
        GrpcCallSettings.<SetIamPolicyRequest, com.google.iam.v1.Policy>newBuilder()
            .setMethodDescriptor(setIamPolicyMethodDescriptor)
            .setParamsExtractor(
                request -> {
                  RequestParamsBuilder builder = RequestParamsBuilder.create();
                  builder.add("resource", String.valueOf(request.getResource()));
                  return builder.build();
                })
            .setResourceNameExtractor(request -> request.getResource())
            .build();
    GrpcCallSettings<GetIamPolicyRequest, com.google.iam.v1.Policy> getIamPolicyTransportSettings =
        GrpcCallSettings.<GetIamPolicyRequest, com.google.iam.v1.Policy>newBuilder()
            .setMethodDescriptor(getIamPolicyMethodDescriptor)
            .setParamsExtractor(
                request -> {
                  RequestParamsBuilder builder = RequestParamsBuilder.create();
                  builder.add("resource", String.valueOf(request.getResource()));
                  return builder.build();
                })
            .setResourceNameExtractor(request -> request.getResource())
            .build();
    GrpcCallSettings<TestIamPermissionsRequest, TestIamPermissionsResponse>
        testIamPermissionsTransportSettings =
            GrpcCallSettings.<TestIamPermissionsRequest, TestIamPermissionsResponse>newBuilder()
                .setMethodDescriptor(testIamPermissionsMethodDescriptor)
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
            operationsStub);
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
            operationsStub);
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
            operationsStub);
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
            operationsStub);
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
            operationsStub);
    this.createShareCallable =
        callableFactory.createUnaryCallable(
            createShareTransportSettings, settings.createShareSettings(), clientContext);
    this.createShareOperationCallable =
        callableFactory.createOperationCallable(
            createShareTransportSettings,
            settings.createShareOperationSettings(),
            clientContext,
            operationsStub);
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
            operationsStub);
    this.syncShareCallable =
        callableFactory.createUnaryCallable(
            syncShareTransportSettings, settings.syncShareSettings(), clientContext);
    this.syncShareOperationCallable =
        callableFactory.createOperationCallable(
            syncShareTransportSettings,
            settings.syncShareOperationSettings(),
            clientContext,
            operationsStub);
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
            operationsStub);
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
            operationsStub);
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
            operationsStub);
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
            operationsStub);
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
            operationsStub);
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
            operationsStub);
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
            operationsStub);
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
            operationsStub);
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
            operationsStub);
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
            operationsStub);
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
            operationsStub);
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
            operationsStub);
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
            operationsStub);
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

  public GrpcOperationsStub getOperationsStub() {
    return operationsStub;
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
