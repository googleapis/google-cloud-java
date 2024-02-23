/*
 * Copyright 2024 Google LLC
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

package com.google.devtools.artifactregistry.v1.stub;

import static com.google.devtools.artifactregistry.v1.ArtifactRegistryClient.ListDockerImagesPagedResponse;
import static com.google.devtools.artifactregistry.v1.ArtifactRegistryClient.ListFilesPagedResponse;
import static com.google.devtools.artifactregistry.v1.ArtifactRegistryClient.ListLocationsPagedResponse;
import static com.google.devtools.artifactregistry.v1.ArtifactRegistryClient.ListMavenArtifactsPagedResponse;
import static com.google.devtools.artifactregistry.v1.ArtifactRegistryClient.ListNpmPackagesPagedResponse;
import static com.google.devtools.artifactregistry.v1.ArtifactRegistryClient.ListPackagesPagedResponse;
import static com.google.devtools.artifactregistry.v1.ArtifactRegistryClient.ListPythonPackagesPagedResponse;
import static com.google.devtools.artifactregistry.v1.ArtifactRegistryClient.ListRepositoriesPagedResponse;
import static com.google.devtools.artifactregistry.v1.ArtifactRegistryClient.ListTagsPagedResponse;
import static com.google.devtools.artifactregistry.v1.ArtifactRegistryClient.ListVersionsPagedResponse;

import com.google.api.gax.core.BackgroundResource;
import com.google.api.gax.core.BackgroundResourceAggregation;
import com.google.api.gax.grpc.GrpcCallSettings;
import com.google.api.gax.grpc.GrpcStubCallableFactory;
import com.google.api.gax.rpc.ClientContext;
import com.google.api.gax.rpc.OperationCallable;
import com.google.api.gax.rpc.RequestParamsBuilder;
import com.google.api.gax.rpc.UnaryCallable;
import com.google.cloud.location.GetLocationRequest;
import com.google.cloud.location.ListLocationsRequest;
import com.google.cloud.location.ListLocationsResponse;
import com.google.cloud.location.Location;
import com.google.devtools.artifactregistry.v1.BatchDeleteVersionsMetadata;
import com.google.devtools.artifactregistry.v1.BatchDeleteVersionsRequest;
import com.google.devtools.artifactregistry.v1.CreateRepositoryRequest;
import com.google.devtools.artifactregistry.v1.CreateTagRequest;
import com.google.devtools.artifactregistry.v1.DeletePackageRequest;
import com.google.devtools.artifactregistry.v1.DeleteRepositoryRequest;
import com.google.devtools.artifactregistry.v1.DeleteTagRequest;
import com.google.devtools.artifactregistry.v1.DeleteVersionRequest;
import com.google.devtools.artifactregistry.v1.DockerImage;
import com.google.devtools.artifactregistry.v1.File;
import com.google.devtools.artifactregistry.v1.GetDockerImageRequest;
import com.google.devtools.artifactregistry.v1.GetFileRequest;
import com.google.devtools.artifactregistry.v1.GetMavenArtifactRequest;
import com.google.devtools.artifactregistry.v1.GetNpmPackageRequest;
import com.google.devtools.artifactregistry.v1.GetPackageRequest;
import com.google.devtools.artifactregistry.v1.GetProjectSettingsRequest;
import com.google.devtools.artifactregistry.v1.GetPythonPackageRequest;
import com.google.devtools.artifactregistry.v1.GetRepositoryRequest;
import com.google.devtools.artifactregistry.v1.GetTagRequest;
import com.google.devtools.artifactregistry.v1.GetVPCSCConfigRequest;
import com.google.devtools.artifactregistry.v1.GetVersionRequest;
import com.google.devtools.artifactregistry.v1.ImportAptArtifactsMetadata;
import com.google.devtools.artifactregistry.v1.ImportAptArtifactsRequest;
import com.google.devtools.artifactregistry.v1.ImportAptArtifactsResponse;
import com.google.devtools.artifactregistry.v1.ImportYumArtifactsMetadata;
import com.google.devtools.artifactregistry.v1.ImportYumArtifactsRequest;
import com.google.devtools.artifactregistry.v1.ImportYumArtifactsResponse;
import com.google.devtools.artifactregistry.v1.ListDockerImagesRequest;
import com.google.devtools.artifactregistry.v1.ListDockerImagesResponse;
import com.google.devtools.artifactregistry.v1.ListFilesRequest;
import com.google.devtools.artifactregistry.v1.ListFilesResponse;
import com.google.devtools.artifactregistry.v1.ListMavenArtifactsRequest;
import com.google.devtools.artifactregistry.v1.ListMavenArtifactsResponse;
import com.google.devtools.artifactregistry.v1.ListNpmPackagesRequest;
import com.google.devtools.artifactregistry.v1.ListNpmPackagesResponse;
import com.google.devtools.artifactregistry.v1.ListPackagesRequest;
import com.google.devtools.artifactregistry.v1.ListPackagesResponse;
import com.google.devtools.artifactregistry.v1.ListPythonPackagesRequest;
import com.google.devtools.artifactregistry.v1.ListPythonPackagesResponse;
import com.google.devtools.artifactregistry.v1.ListRepositoriesRequest;
import com.google.devtools.artifactregistry.v1.ListRepositoriesResponse;
import com.google.devtools.artifactregistry.v1.ListTagsRequest;
import com.google.devtools.artifactregistry.v1.ListTagsResponse;
import com.google.devtools.artifactregistry.v1.ListVersionsRequest;
import com.google.devtools.artifactregistry.v1.ListVersionsResponse;
import com.google.devtools.artifactregistry.v1.MavenArtifact;
import com.google.devtools.artifactregistry.v1.NpmPackage;
import com.google.devtools.artifactregistry.v1.OperationMetadata;
import com.google.devtools.artifactregistry.v1.Package;
import com.google.devtools.artifactregistry.v1.ProjectSettings;
import com.google.devtools.artifactregistry.v1.PythonPackage;
import com.google.devtools.artifactregistry.v1.Repository;
import com.google.devtools.artifactregistry.v1.Tag;
import com.google.devtools.artifactregistry.v1.UpdateProjectSettingsRequest;
import com.google.devtools.artifactregistry.v1.UpdateRepositoryRequest;
import com.google.devtools.artifactregistry.v1.UpdateTagRequest;
import com.google.devtools.artifactregistry.v1.UpdateVPCSCConfigRequest;
import com.google.devtools.artifactregistry.v1.VPCSCConfig;
import com.google.devtools.artifactregistry.v1.Version;
import com.google.iam.v1.GetIamPolicyRequest;
import com.google.iam.v1.Policy;
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

// AUTO-GENERATED DOCUMENTATION AND CLASS.
/**
 * gRPC stub implementation for the ArtifactRegistry service API.
 *
 * <p>This class is for advanced usage and reflects the underlying API directly.
 */
@Generated("by gapic-generator-java")
public class GrpcArtifactRegistryStub extends ArtifactRegistryStub {
  private static final MethodDescriptor<ListDockerImagesRequest, ListDockerImagesResponse>
      listDockerImagesMethodDescriptor =
          MethodDescriptor.<ListDockerImagesRequest, ListDockerImagesResponse>newBuilder()
              .setType(MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(
                  "google.devtools.artifactregistry.v1.ArtifactRegistry/ListDockerImages")
              .setRequestMarshaller(
                  ProtoUtils.marshaller(ListDockerImagesRequest.getDefaultInstance()))
              .setResponseMarshaller(
                  ProtoUtils.marshaller(ListDockerImagesResponse.getDefaultInstance()))
              .build();

  private static final MethodDescriptor<GetDockerImageRequest, DockerImage>
      getDockerImageMethodDescriptor =
          MethodDescriptor.<GetDockerImageRequest, DockerImage>newBuilder()
              .setType(MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(
                  "google.devtools.artifactregistry.v1.ArtifactRegistry/GetDockerImage")
              .setRequestMarshaller(
                  ProtoUtils.marshaller(GetDockerImageRequest.getDefaultInstance()))
              .setResponseMarshaller(ProtoUtils.marshaller(DockerImage.getDefaultInstance()))
              .build();

  private static final MethodDescriptor<ListMavenArtifactsRequest, ListMavenArtifactsResponse>
      listMavenArtifactsMethodDescriptor =
          MethodDescriptor.<ListMavenArtifactsRequest, ListMavenArtifactsResponse>newBuilder()
              .setType(MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(
                  "google.devtools.artifactregistry.v1.ArtifactRegistry/ListMavenArtifacts")
              .setRequestMarshaller(
                  ProtoUtils.marshaller(ListMavenArtifactsRequest.getDefaultInstance()))
              .setResponseMarshaller(
                  ProtoUtils.marshaller(ListMavenArtifactsResponse.getDefaultInstance()))
              .build();

  private static final MethodDescriptor<GetMavenArtifactRequest, MavenArtifact>
      getMavenArtifactMethodDescriptor =
          MethodDescriptor.<GetMavenArtifactRequest, MavenArtifact>newBuilder()
              .setType(MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(
                  "google.devtools.artifactregistry.v1.ArtifactRegistry/GetMavenArtifact")
              .setRequestMarshaller(
                  ProtoUtils.marshaller(GetMavenArtifactRequest.getDefaultInstance()))
              .setResponseMarshaller(ProtoUtils.marshaller(MavenArtifact.getDefaultInstance()))
              .build();

  private static final MethodDescriptor<ListNpmPackagesRequest, ListNpmPackagesResponse>
      listNpmPackagesMethodDescriptor =
          MethodDescriptor.<ListNpmPackagesRequest, ListNpmPackagesResponse>newBuilder()
              .setType(MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(
                  "google.devtools.artifactregistry.v1.ArtifactRegistry/ListNpmPackages")
              .setRequestMarshaller(
                  ProtoUtils.marshaller(ListNpmPackagesRequest.getDefaultInstance()))
              .setResponseMarshaller(
                  ProtoUtils.marshaller(ListNpmPackagesResponse.getDefaultInstance()))
              .build();

  private static final MethodDescriptor<GetNpmPackageRequest, NpmPackage>
      getNpmPackageMethodDescriptor =
          MethodDescriptor.<GetNpmPackageRequest, NpmPackage>newBuilder()
              .setType(MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(
                  "google.devtools.artifactregistry.v1.ArtifactRegistry/GetNpmPackage")
              .setRequestMarshaller(
                  ProtoUtils.marshaller(GetNpmPackageRequest.getDefaultInstance()))
              .setResponseMarshaller(ProtoUtils.marshaller(NpmPackage.getDefaultInstance()))
              .build();

  private static final MethodDescriptor<ListPythonPackagesRequest, ListPythonPackagesResponse>
      listPythonPackagesMethodDescriptor =
          MethodDescriptor.<ListPythonPackagesRequest, ListPythonPackagesResponse>newBuilder()
              .setType(MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(
                  "google.devtools.artifactregistry.v1.ArtifactRegistry/ListPythonPackages")
              .setRequestMarshaller(
                  ProtoUtils.marshaller(ListPythonPackagesRequest.getDefaultInstance()))
              .setResponseMarshaller(
                  ProtoUtils.marshaller(ListPythonPackagesResponse.getDefaultInstance()))
              .build();

  private static final MethodDescriptor<GetPythonPackageRequest, PythonPackage>
      getPythonPackageMethodDescriptor =
          MethodDescriptor.<GetPythonPackageRequest, PythonPackage>newBuilder()
              .setType(MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(
                  "google.devtools.artifactregistry.v1.ArtifactRegistry/GetPythonPackage")
              .setRequestMarshaller(
                  ProtoUtils.marshaller(GetPythonPackageRequest.getDefaultInstance()))
              .setResponseMarshaller(ProtoUtils.marshaller(PythonPackage.getDefaultInstance()))
              .build();

  private static final MethodDescriptor<ImportAptArtifactsRequest, Operation>
      importAptArtifactsMethodDescriptor =
          MethodDescriptor.<ImportAptArtifactsRequest, Operation>newBuilder()
              .setType(MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(
                  "google.devtools.artifactregistry.v1.ArtifactRegistry/ImportAptArtifacts")
              .setRequestMarshaller(
                  ProtoUtils.marshaller(ImportAptArtifactsRequest.getDefaultInstance()))
              .setResponseMarshaller(ProtoUtils.marshaller(Operation.getDefaultInstance()))
              .build();

  private static final MethodDescriptor<ImportYumArtifactsRequest, Operation>
      importYumArtifactsMethodDescriptor =
          MethodDescriptor.<ImportYumArtifactsRequest, Operation>newBuilder()
              .setType(MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(
                  "google.devtools.artifactregistry.v1.ArtifactRegistry/ImportYumArtifacts")
              .setRequestMarshaller(
                  ProtoUtils.marshaller(ImportYumArtifactsRequest.getDefaultInstance()))
              .setResponseMarshaller(ProtoUtils.marshaller(Operation.getDefaultInstance()))
              .build();

  private static final MethodDescriptor<ListRepositoriesRequest, ListRepositoriesResponse>
      listRepositoriesMethodDescriptor =
          MethodDescriptor.<ListRepositoriesRequest, ListRepositoriesResponse>newBuilder()
              .setType(MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(
                  "google.devtools.artifactregistry.v1.ArtifactRegistry/ListRepositories")
              .setRequestMarshaller(
                  ProtoUtils.marshaller(ListRepositoriesRequest.getDefaultInstance()))
              .setResponseMarshaller(
                  ProtoUtils.marshaller(ListRepositoriesResponse.getDefaultInstance()))
              .build();

  private static final MethodDescriptor<GetRepositoryRequest, Repository>
      getRepositoryMethodDescriptor =
          MethodDescriptor.<GetRepositoryRequest, Repository>newBuilder()
              .setType(MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(
                  "google.devtools.artifactregistry.v1.ArtifactRegistry/GetRepository")
              .setRequestMarshaller(
                  ProtoUtils.marshaller(GetRepositoryRequest.getDefaultInstance()))
              .setResponseMarshaller(ProtoUtils.marshaller(Repository.getDefaultInstance()))
              .build();

  private static final MethodDescriptor<CreateRepositoryRequest, Operation>
      createRepositoryMethodDescriptor =
          MethodDescriptor.<CreateRepositoryRequest, Operation>newBuilder()
              .setType(MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(
                  "google.devtools.artifactregistry.v1.ArtifactRegistry/CreateRepository")
              .setRequestMarshaller(
                  ProtoUtils.marshaller(CreateRepositoryRequest.getDefaultInstance()))
              .setResponseMarshaller(ProtoUtils.marshaller(Operation.getDefaultInstance()))
              .build();

  private static final MethodDescriptor<UpdateRepositoryRequest, Repository>
      updateRepositoryMethodDescriptor =
          MethodDescriptor.<UpdateRepositoryRequest, Repository>newBuilder()
              .setType(MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(
                  "google.devtools.artifactregistry.v1.ArtifactRegistry/UpdateRepository")
              .setRequestMarshaller(
                  ProtoUtils.marshaller(UpdateRepositoryRequest.getDefaultInstance()))
              .setResponseMarshaller(ProtoUtils.marshaller(Repository.getDefaultInstance()))
              .build();

  private static final MethodDescriptor<DeleteRepositoryRequest, Operation>
      deleteRepositoryMethodDescriptor =
          MethodDescriptor.<DeleteRepositoryRequest, Operation>newBuilder()
              .setType(MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(
                  "google.devtools.artifactregistry.v1.ArtifactRegistry/DeleteRepository")
              .setRequestMarshaller(
                  ProtoUtils.marshaller(DeleteRepositoryRequest.getDefaultInstance()))
              .setResponseMarshaller(ProtoUtils.marshaller(Operation.getDefaultInstance()))
              .build();

  private static final MethodDescriptor<ListPackagesRequest, ListPackagesResponse>
      listPackagesMethodDescriptor =
          MethodDescriptor.<ListPackagesRequest, ListPackagesResponse>newBuilder()
              .setType(MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(
                  "google.devtools.artifactregistry.v1.ArtifactRegistry/ListPackages")
              .setRequestMarshaller(ProtoUtils.marshaller(ListPackagesRequest.getDefaultInstance()))
              .setResponseMarshaller(
                  ProtoUtils.marshaller(ListPackagesResponse.getDefaultInstance()))
              .build();

  private static final MethodDescriptor<GetPackageRequest, Package> getPackageMethodDescriptor =
      MethodDescriptor.<GetPackageRequest, Package>newBuilder()
          .setType(MethodDescriptor.MethodType.UNARY)
          .setFullMethodName("google.devtools.artifactregistry.v1.ArtifactRegistry/GetPackage")
          .setRequestMarshaller(ProtoUtils.marshaller(GetPackageRequest.getDefaultInstance()))
          .setResponseMarshaller(ProtoUtils.marshaller(Package.getDefaultInstance()))
          .build();

  private static final MethodDescriptor<DeletePackageRequest, Operation>
      deletePackageMethodDescriptor =
          MethodDescriptor.<DeletePackageRequest, Operation>newBuilder()
              .setType(MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(
                  "google.devtools.artifactregistry.v1.ArtifactRegistry/DeletePackage")
              .setRequestMarshaller(
                  ProtoUtils.marshaller(DeletePackageRequest.getDefaultInstance()))
              .setResponseMarshaller(ProtoUtils.marshaller(Operation.getDefaultInstance()))
              .build();

  private static final MethodDescriptor<ListVersionsRequest, ListVersionsResponse>
      listVersionsMethodDescriptor =
          MethodDescriptor.<ListVersionsRequest, ListVersionsResponse>newBuilder()
              .setType(MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(
                  "google.devtools.artifactregistry.v1.ArtifactRegistry/ListVersions")
              .setRequestMarshaller(ProtoUtils.marshaller(ListVersionsRequest.getDefaultInstance()))
              .setResponseMarshaller(
                  ProtoUtils.marshaller(ListVersionsResponse.getDefaultInstance()))
              .build();

  private static final MethodDescriptor<GetVersionRequest, Version> getVersionMethodDescriptor =
      MethodDescriptor.<GetVersionRequest, Version>newBuilder()
          .setType(MethodDescriptor.MethodType.UNARY)
          .setFullMethodName("google.devtools.artifactregistry.v1.ArtifactRegistry/GetVersion")
          .setRequestMarshaller(ProtoUtils.marshaller(GetVersionRequest.getDefaultInstance()))
          .setResponseMarshaller(ProtoUtils.marshaller(Version.getDefaultInstance()))
          .build();

  private static final MethodDescriptor<DeleteVersionRequest, Operation>
      deleteVersionMethodDescriptor =
          MethodDescriptor.<DeleteVersionRequest, Operation>newBuilder()
              .setType(MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(
                  "google.devtools.artifactregistry.v1.ArtifactRegistry/DeleteVersion")
              .setRequestMarshaller(
                  ProtoUtils.marshaller(DeleteVersionRequest.getDefaultInstance()))
              .setResponseMarshaller(ProtoUtils.marshaller(Operation.getDefaultInstance()))
              .build();

  private static final MethodDescriptor<BatchDeleteVersionsRequest, Operation>
      batchDeleteVersionsMethodDescriptor =
          MethodDescriptor.<BatchDeleteVersionsRequest, Operation>newBuilder()
              .setType(MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(
                  "google.devtools.artifactregistry.v1.ArtifactRegistry/BatchDeleteVersions")
              .setRequestMarshaller(
                  ProtoUtils.marshaller(BatchDeleteVersionsRequest.getDefaultInstance()))
              .setResponseMarshaller(ProtoUtils.marshaller(Operation.getDefaultInstance()))
              .build();

  private static final MethodDescriptor<ListFilesRequest, ListFilesResponse>
      listFilesMethodDescriptor =
          MethodDescriptor.<ListFilesRequest, ListFilesResponse>newBuilder()
              .setType(MethodDescriptor.MethodType.UNARY)
              .setFullMethodName("google.devtools.artifactregistry.v1.ArtifactRegistry/ListFiles")
              .setRequestMarshaller(ProtoUtils.marshaller(ListFilesRequest.getDefaultInstance()))
              .setResponseMarshaller(ProtoUtils.marshaller(ListFilesResponse.getDefaultInstance()))
              .build();

  private static final MethodDescriptor<GetFileRequest, File> getFileMethodDescriptor =
      MethodDescriptor.<GetFileRequest, File>newBuilder()
          .setType(MethodDescriptor.MethodType.UNARY)
          .setFullMethodName("google.devtools.artifactregistry.v1.ArtifactRegistry/GetFile")
          .setRequestMarshaller(ProtoUtils.marshaller(GetFileRequest.getDefaultInstance()))
          .setResponseMarshaller(ProtoUtils.marshaller(File.getDefaultInstance()))
          .build();

  private static final MethodDescriptor<ListTagsRequest, ListTagsResponse>
      listTagsMethodDescriptor =
          MethodDescriptor.<ListTagsRequest, ListTagsResponse>newBuilder()
              .setType(MethodDescriptor.MethodType.UNARY)
              .setFullMethodName("google.devtools.artifactregistry.v1.ArtifactRegistry/ListTags")
              .setRequestMarshaller(ProtoUtils.marshaller(ListTagsRequest.getDefaultInstance()))
              .setResponseMarshaller(ProtoUtils.marshaller(ListTagsResponse.getDefaultInstance()))
              .build();

  private static final MethodDescriptor<GetTagRequest, Tag> getTagMethodDescriptor =
      MethodDescriptor.<GetTagRequest, Tag>newBuilder()
          .setType(MethodDescriptor.MethodType.UNARY)
          .setFullMethodName("google.devtools.artifactregistry.v1.ArtifactRegistry/GetTag")
          .setRequestMarshaller(ProtoUtils.marshaller(GetTagRequest.getDefaultInstance()))
          .setResponseMarshaller(ProtoUtils.marshaller(Tag.getDefaultInstance()))
          .build();

  private static final MethodDescriptor<CreateTagRequest, Tag> createTagMethodDescriptor =
      MethodDescriptor.<CreateTagRequest, Tag>newBuilder()
          .setType(MethodDescriptor.MethodType.UNARY)
          .setFullMethodName("google.devtools.artifactregistry.v1.ArtifactRegistry/CreateTag")
          .setRequestMarshaller(ProtoUtils.marshaller(CreateTagRequest.getDefaultInstance()))
          .setResponseMarshaller(ProtoUtils.marshaller(Tag.getDefaultInstance()))
          .build();

  private static final MethodDescriptor<UpdateTagRequest, Tag> updateTagMethodDescriptor =
      MethodDescriptor.<UpdateTagRequest, Tag>newBuilder()
          .setType(MethodDescriptor.MethodType.UNARY)
          .setFullMethodName("google.devtools.artifactregistry.v1.ArtifactRegistry/UpdateTag")
          .setRequestMarshaller(ProtoUtils.marshaller(UpdateTagRequest.getDefaultInstance()))
          .setResponseMarshaller(ProtoUtils.marshaller(Tag.getDefaultInstance()))
          .build();

  private static final MethodDescriptor<DeleteTagRequest, Empty> deleteTagMethodDescriptor =
      MethodDescriptor.<DeleteTagRequest, Empty>newBuilder()
          .setType(MethodDescriptor.MethodType.UNARY)
          .setFullMethodName("google.devtools.artifactregistry.v1.ArtifactRegistry/DeleteTag")
          .setRequestMarshaller(ProtoUtils.marshaller(DeleteTagRequest.getDefaultInstance()))
          .setResponseMarshaller(ProtoUtils.marshaller(Empty.getDefaultInstance()))
          .build();

  private static final MethodDescriptor<SetIamPolicyRequest, Policy> setIamPolicyMethodDescriptor =
      MethodDescriptor.<SetIamPolicyRequest, Policy>newBuilder()
          .setType(MethodDescriptor.MethodType.UNARY)
          .setFullMethodName("google.devtools.artifactregistry.v1.ArtifactRegistry/SetIamPolicy")
          .setRequestMarshaller(ProtoUtils.marshaller(SetIamPolicyRequest.getDefaultInstance()))
          .setResponseMarshaller(ProtoUtils.marshaller(Policy.getDefaultInstance()))
          .build();

  private static final MethodDescriptor<GetIamPolicyRequest, Policy> getIamPolicyMethodDescriptor =
      MethodDescriptor.<GetIamPolicyRequest, Policy>newBuilder()
          .setType(MethodDescriptor.MethodType.UNARY)
          .setFullMethodName("google.devtools.artifactregistry.v1.ArtifactRegistry/GetIamPolicy")
          .setRequestMarshaller(ProtoUtils.marshaller(GetIamPolicyRequest.getDefaultInstance()))
          .setResponseMarshaller(ProtoUtils.marshaller(Policy.getDefaultInstance()))
          .build();

  private static final MethodDescriptor<TestIamPermissionsRequest, TestIamPermissionsResponse>
      testIamPermissionsMethodDescriptor =
          MethodDescriptor.<TestIamPermissionsRequest, TestIamPermissionsResponse>newBuilder()
              .setType(MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(
                  "google.devtools.artifactregistry.v1.ArtifactRegistry/TestIamPermissions")
              .setRequestMarshaller(
                  ProtoUtils.marshaller(TestIamPermissionsRequest.getDefaultInstance()))
              .setResponseMarshaller(
                  ProtoUtils.marshaller(TestIamPermissionsResponse.getDefaultInstance()))
              .build();

  private static final MethodDescriptor<GetProjectSettingsRequest, ProjectSettings>
      getProjectSettingsMethodDescriptor =
          MethodDescriptor.<GetProjectSettingsRequest, ProjectSettings>newBuilder()
              .setType(MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(
                  "google.devtools.artifactregistry.v1.ArtifactRegistry/GetProjectSettings")
              .setRequestMarshaller(
                  ProtoUtils.marshaller(GetProjectSettingsRequest.getDefaultInstance()))
              .setResponseMarshaller(ProtoUtils.marshaller(ProjectSettings.getDefaultInstance()))
              .build();

  private static final MethodDescriptor<UpdateProjectSettingsRequest, ProjectSettings>
      updateProjectSettingsMethodDescriptor =
          MethodDescriptor.<UpdateProjectSettingsRequest, ProjectSettings>newBuilder()
              .setType(MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(
                  "google.devtools.artifactregistry.v1.ArtifactRegistry/UpdateProjectSettings")
              .setRequestMarshaller(
                  ProtoUtils.marshaller(UpdateProjectSettingsRequest.getDefaultInstance()))
              .setResponseMarshaller(ProtoUtils.marshaller(ProjectSettings.getDefaultInstance()))
              .build();

  private static final MethodDescriptor<GetVPCSCConfigRequest, VPCSCConfig>
      getVPCSCConfigMethodDescriptor =
          MethodDescriptor.<GetVPCSCConfigRequest, VPCSCConfig>newBuilder()
              .setType(MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(
                  "google.devtools.artifactregistry.v1.ArtifactRegistry/GetVPCSCConfig")
              .setRequestMarshaller(
                  ProtoUtils.marshaller(GetVPCSCConfigRequest.getDefaultInstance()))
              .setResponseMarshaller(ProtoUtils.marshaller(VPCSCConfig.getDefaultInstance()))
              .build();

  private static final MethodDescriptor<UpdateVPCSCConfigRequest, VPCSCConfig>
      updateVPCSCConfigMethodDescriptor =
          MethodDescriptor.<UpdateVPCSCConfigRequest, VPCSCConfig>newBuilder()
              .setType(MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(
                  "google.devtools.artifactregistry.v1.ArtifactRegistry/UpdateVPCSCConfig")
              .setRequestMarshaller(
                  ProtoUtils.marshaller(UpdateVPCSCConfigRequest.getDefaultInstance()))
              .setResponseMarshaller(ProtoUtils.marshaller(VPCSCConfig.getDefaultInstance()))
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

  private final UnaryCallable<ListDockerImagesRequest, ListDockerImagesResponse>
      listDockerImagesCallable;
  private final UnaryCallable<ListDockerImagesRequest, ListDockerImagesPagedResponse>
      listDockerImagesPagedCallable;
  private final UnaryCallable<GetDockerImageRequest, DockerImage> getDockerImageCallable;
  private final UnaryCallable<ListMavenArtifactsRequest, ListMavenArtifactsResponse>
      listMavenArtifactsCallable;
  private final UnaryCallable<ListMavenArtifactsRequest, ListMavenArtifactsPagedResponse>
      listMavenArtifactsPagedCallable;
  private final UnaryCallable<GetMavenArtifactRequest, MavenArtifact> getMavenArtifactCallable;
  private final UnaryCallable<ListNpmPackagesRequest, ListNpmPackagesResponse>
      listNpmPackagesCallable;
  private final UnaryCallable<ListNpmPackagesRequest, ListNpmPackagesPagedResponse>
      listNpmPackagesPagedCallable;
  private final UnaryCallable<GetNpmPackageRequest, NpmPackage> getNpmPackageCallable;
  private final UnaryCallable<ListPythonPackagesRequest, ListPythonPackagesResponse>
      listPythonPackagesCallable;
  private final UnaryCallable<ListPythonPackagesRequest, ListPythonPackagesPagedResponse>
      listPythonPackagesPagedCallable;
  private final UnaryCallable<GetPythonPackageRequest, PythonPackage> getPythonPackageCallable;
  private final UnaryCallable<ImportAptArtifactsRequest, Operation> importAptArtifactsCallable;
  private final OperationCallable<
          ImportAptArtifactsRequest, ImportAptArtifactsResponse, ImportAptArtifactsMetadata>
      importAptArtifactsOperationCallable;
  private final UnaryCallable<ImportYumArtifactsRequest, Operation> importYumArtifactsCallable;
  private final OperationCallable<
          ImportYumArtifactsRequest, ImportYumArtifactsResponse, ImportYumArtifactsMetadata>
      importYumArtifactsOperationCallable;
  private final UnaryCallable<ListRepositoriesRequest, ListRepositoriesResponse>
      listRepositoriesCallable;
  private final UnaryCallable<ListRepositoriesRequest, ListRepositoriesPagedResponse>
      listRepositoriesPagedCallable;
  private final UnaryCallable<GetRepositoryRequest, Repository> getRepositoryCallable;
  private final UnaryCallable<CreateRepositoryRequest, Operation> createRepositoryCallable;
  private final OperationCallable<CreateRepositoryRequest, Repository, OperationMetadata>
      createRepositoryOperationCallable;
  private final UnaryCallable<UpdateRepositoryRequest, Repository> updateRepositoryCallable;
  private final UnaryCallable<DeleteRepositoryRequest, Operation> deleteRepositoryCallable;
  private final OperationCallable<DeleteRepositoryRequest, Empty, OperationMetadata>
      deleteRepositoryOperationCallable;
  private final UnaryCallable<ListPackagesRequest, ListPackagesResponse> listPackagesCallable;
  private final UnaryCallable<ListPackagesRequest, ListPackagesPagedResponse>
      listPackagesPagedCallable;
  private final UnaryCallable<GetPackageRequest, Package> getPackageCallable;
  private final UnaryCallable<DeletePackageRequest, Operation> deletePackageCallable;
  private final OperationCallable<DeletePackageRequest, Empty, OperationMetadata>
      deletePackageOperationCallable;
  private final UnaryCallable<ListVersionsRequest, ListVersionsResponse> listVersionsCallable;
  private final UnaryCallable<ListVersionsRequest, ListVersionsPagedResponse>
      listVersionsPagedCallable;
  private final UnaryCallable<GetVersionRequest, Version> getVersionCallable;
  private final UnaryCallable<DeleteVersionRequest, Operation> deleteVersionCallable;
  private final OperationCallable<DeleteVersionRequest, Empty, OperationMetadata>
      deleteVersionOperationCallable;
  private final UnaryCallable<BatchDeleteVersionsRequest, Operation> batchDeleteVersionsCallable;
  private final OperationCallable<BatchDeleteVersionsRequest, Empty, BatchDeleteVersionsMetadata>
      batchDeleteVersionsOperationCallable;
  private final UnaryCallable<ListFilesRequest, ListFilesResponse> listFilesCallable;
  private final UnaryCallable<ListFilesRequest, ListFilesPagedResponse> listFilesPagedCallable;
  private final UnaryCallable<GetFileRequest, File> getFileCallable;
  private final UnaryCallable<ListTagsRequest, ListTagsResponse> listTagsCallable;
  private final UnaryCallable<ListTagsRequest, ListTagsPagedResponse> listTagsPagedCallable;
  private final UnaryCallable<GetTagRequest, Tag> getTagCallable;
  private final UnaryCallable<CreateTagRequest, Tag> createTagCallable;
  private final UnaryCallable<UpdateTagRequest, Tag> updateTagCallable;
  private final UnaryCallable<DeleteTagRequest, Empty> deleteTagCallable;
  private final UnaryCallable<SetIamPolicyRequest, Policy> setIamPolicyCallable;
  private final UnaryCallable<GetIamPolicyRequest, Policy> getIamPolicyCallable;
  private final UnaryCallable<TestIamPermissionsRequest, TestIamPermissionsResponse>
      testIamPermissionsCallable;
  private final UnaryCallable<GetProjectSettingsRequest, ProjectSettings>
      getProjectSettingsCallable;
  private final UnaryCallable<UpdateProjectSettingsRequest, ProjectSettings>
      updateProjectSettingsCallable;
  private final UnaryCallable<GetVPCSCConfigRequest, VPCSCConfig> getVPCSCConfigCallable;
  private final UnaryCallable<UpdateVPCSCConfigRequest, VPCSCConfig> updateVPCSCConfigCallable;
  private final UnaryCallable<ListLocationsRequest, ListLocationsResponse> listLocationsCallable;
  private final UnaryCallable<ListLocationsRequest, ListLocationsPagedResponse>
      listLocationsPagedCallable;
  private final UnaryCallable<GetLocationRequest, Location> getLocationCallable;

  private final BackgroundResource backgroundResources;
  private final GrpcOperationsStub operationsStub;
  private final GrpcStubCallableFactory callableFactory;

  public static final GrpcArtifactRegistryStub create(ArtifactRegistryStubSettings settings)
      throws IOException {
    return new GrpcArtifactRegistryStub(settings, ClientContext.create(settings));
  }

  public static final GrpcArtifactRegistryStub create(ClientContext clientContext)
      throws IOException {
    return new GrpcArtifactRegistryStub(
        ArtifactRegistryStubSettings.newBuilder().build(), clientContext);
  }

  public static final GrpcArtifactRegistryStub create(
      ClientContext clientContext, GrpcStubCallableFactory callableFactory) throws IOException {
    return new GrpcArtifactRegistryStub(
        ArtifactRegistryStubSettings.newBuilder().build(), clientContext, callableFactory);
  }

  /**
   * Constructs an instance of GrpcArtifactRegistryStub, using the given settings. This is protected
   * so that it is easy to make a subclass, but otherwise, the static factory methods should be
   * preferred.
   */
  protected GrpcArtifactRegistryStub(
      ArtifactRegistryStubSettings settings, ClientContext clientContext) throws IOException {
    this(settings, clientContext, new GrpcArtifactRegistryCallableFactory());
  }

  /**
   * Constructs an instance of GrpcArtifactRegistryStub, using the given settings. This is protected
   * so that it is easy to make a subclass, but otherwise, the static factory methods should be
   * preferred.
   */
  protected GrpcArtifactRegistryStub(
      ArtifactRegistryStubSettings settings,
      ClientContext clientContext,
      GrpcStubCallableFactory callableFactory)
      throws IOException {
    this.callableFactory = callableFactory;
    this.operationsStub = GrpcOperationsStub.create(clientContext, callableFactory);

    GrpcCallSettings<ListDockerImagesRequest, ListDockerImagesResponse>
        listDockerImagesTransportSettings =
            GrpcCallSettings.<ListDockerImagesRequest, ListDockerImagesResponse>newBuilder()
                .setMethodDescriptor(listDockerImagesMethodDescriptor)
                .setParamsExtractor(
                    request -> {
                      RequestParamsBuilder builder = RequestParamsBuilder.create();
                      builder.add("parent", String.valueOf(request.getParent()));
                      return builder.build();
                    })
                .build();
    GrpcCallSettings<GetDockerImageRequest, DockerImage> getDockerImageTransportSettings =
        GrpcCallSettings.<GetDockerImageRequest, DockerImage>newBuilder()
            .setMethodDescriptor(getDockerImageMethodDescriptor)
            .setParamsExtractor(
                request -> {
                  RequestParamsBuilder builder = RequestParamsBuilder.create();
                  builder.add("name", String.valueOf(request.getName()));
                  return builder.build();
                })
            .build();
    GrpcCallSettings<ListMavenArtifactsRequest, ListMavenArtifactsResponse>
        listMavenArtifactsTransportSettings =
            GrpcCallSettings.<ListMavenArtifactsRequest, ListMavenArtifactsResponse>newBuilder()
                .setMethodDescriptor(listMavenArtifactsMethodDescriptor)
                .setParamsExtractor(
                    request -> {
                      RequestParamsBuilder builder = RequestParamsBuilder.create();
                      builder.add("parent", String.valueOf(request.getParent()));
                      return builder.build();
                    })
                .build();
    GrpcCallSettings<GetMavenArtifactRequest, MavenArtifact> getMavenArtifactTransportSettings =
        GrpcCallSettings.<GetMavenArtifactRequest, MavenArtifact>newBuilder()
            .setMethodDescriptor(getMavenArtifactMethodDescriptor)
            .setParamsExtractor(
                request -> {
                  RequestParamsBuilder builder = RequestParamsBuilder.create();
                  builder.add("name", String.valueOf(request.getName()));
                  return builder.build();
                })
            .build();
    GrpcCallSettings<ListNpmPackagesRequest, ListNpmPackagesResponse>
        listNpmPackagesTransportSettings =
            GrpcCallSettings.<ListNpmPackagesRequest, ListNpmPackagesResponse>newBuilder()
                .setMethodDescriptor(listNpmPackagesMethodDescriptor)
                .setParamsExtractor(
                    request -> {
                      RequestParamsBuilder builder = RequestParamsBuilder.create();
                      builder.add("parent", String.valueOf(request.getParent()));
                      return builder.build();
                    })
                .build();
    GrpcCallSettings<GetNpmPackageRequest, NpmPackage> getNpmPackageTransportSettings =
        GrpcCallSettings.<GetNpmPackageRequest, NpmPackage>newBuilder()
            .setMethodDescriptor(getNpmPackageMethodDescriptor)
            .setParamsExtractor(
                request -> {
                  RequestParamsBuilder builder = RequestParamsBuilder.create();
                  builder.add("name", String.valueOf(request.getName()));
                  return builder.build();
                })
            .build();
    GrpcCallSettings<ListPythonPackagesRequest, ListPythonPackagesResponse>
        listPythonPackagesTransportSettings =
            GrpcCallSettings.<ListPythonPackagesRequest, ListPythonPackagesResponse>newBuilder()
                .setMethodDescriptor(listPythonPackagesMethodDescriptor)
                .setParamsExtractor(
                    request -> {
                      RequestParamsBuilder builder = RequestParamsBuilder.create();
                      builder.add("parent", String.valueOf(request.getParent()));
                      return builder.build();
                    })
                .build();
    GrpcCallSettings<GetPythonPackageRequest, PythonPackage> getPythonPackageTransportSettings =
        GrpcCallSettings.<GetPythonPackageRequest, PythonPackage>newBuilder()
            .setMethodDescriptor(getPythonPackageMethodDescriptor)
            .setParamsExtractor(
                request -> {
                  RequestParamsBuilder builder = RequestParamsBuilder.create();
                  builder.add("name", String.valueOf(request.getName()));
                  return builder.build();
                })
            .build();
    GrpcCallSettings<ImportAptArtifactsRequest, Operation> importAptArtifactsTransportSettings =
        GrpcCallSettings.<ImportAptArtifactsRequest, Operation>newBuilder()
            .setMethodDescriptor(importAptArtifactsMethodDescriptor)
            .setParamsExtractor(
                request -> {
                  RequestParamsBuilder builder = RequestParamsBuilder.create();
                  builder.add("parent", String.valueOf(request.getParent()));
                  return builder.build();
                })
            .build();
    GrpcCallSettings<ImportYumArtifactsRequest, Operation> importYumArtifactsTransportSettings =
        GrpcCallSettings.<ImportYumArtifactsRequest, Operation>newBuilder()
            .setMethodDescriptor(importYumArtifactsMethodDescriptor)
            .setParamsExtractor(
                request -> {
                  RequestParamsBuilder builder = RequestParamsBuilder.create();
                  builder.add("parent", String.valueOf(request.getParent()));
                  return builder.build();
                })
            .build();
    GrpcCallSettings<ListRepositoriesRequest, ListRepositoriesResponse>
        listRepositoriesTransportSettings =
            GrpcCallSettings.<ListRepositoriesRequest, ListRepositoriesResponse>newBuilder()
                .setMethodDescriptor(listRepositoriesMethodDescriptor)
                .setParamsExtractor(
                    request -> {
                      RequestParamsBuilder builder = RequestParamsBuilder.create();
                      builder.add("parent", String.valueOf(request.getParent()));
                      return builder.build();
                    })
                .build();
    GrpcCallSettings<GetRepositoryRequest, Repository> getRepositoryTransportSettings =
        GrpcCallSettings.<GetRepositoryRequest, Repository>newBuilder()
            .setMethodDescriptor(getRepositoryMethodDescriptor)
            .setParamsExtractor(
                request -> {
                  RequestParamsBuilder builder = RequestParamsBuilder.create();
                  builder.add("name", String.valueOf(request.getName()));
                  return builder.build();
                })
            .build();
    GrpcCallSettings<CreateRepositoryRequest, Operation> createRepositoryTransportSettings =
        GrpcCallSettings.<CreateRepositoryRequest, Operation>newBuilder()
            .setMethodDescriptor(createRepositoryMethodDescriptor)
            .setParamsExtractor(
                request -> {
                  RequestParamsBuilder builder = RequestParamsBuilder.create();
                  builder.add("parent", String.valueOf(request.getParent()));
                  return builder.build();
                })
            .build();
    GrpcCallSettings<UpdateRepositoryRequest, Repository> updateRepositoryTransportSettings =
        GrpcCallSettings.<UpdateRepositoryRequest, Repository>newBuilder()
            .setMethodDescriptor(updateRepositoryMethodDescriptor)
            .setParamsExtractor(
                request -> {
                  RequestParamsBuilder builder = RequestParamsBuilder.create();
                  builder.add("repository.name", String.valueOf(request.getRepository().getName()));
                  return builder.build();
                })
            .build();
    GrpcCallSettings<DeleteRepositoryRequest, Operation> deleteRepositoryTransportSettings =
        GrpcCallSettings.<DeleteRepositoryRequest, Operation>newBuilder()
            .setMethodDescriptor(deleteRepositoryMethodDescriptor)
            .setParamsExtractor(
                request -> {
                  RequestParamsBuilder builder = RequestParamsBuilder.create();
                  builder.add("name", String.valueOf(request.getName()));
                  return builder.build();
                })
            .build();
    GrpcCallSettings<ListPackagesRequest, ListPackagesResponse> listPackagesTransportSettings =
        GrpcCallSettings.<ListPackagesRequest, ListPackagesResponse>newBuilder()
            .setMethodDescriptor(listPackagesMethodDescriptor)
            .setParamsExtractor(
                request -> {
                  RequestParamsBuilder builder = RequestParamsBuilder.create();
                  builder.add("parent", String.valueOf(request.getParent()));
                  return builder.build();
                })
            .build();
    GrpcCallSettings<GetPackageRequest, Package> getPackageTransportSettings =
        GrpcCallSettings.<GetPackageRequest, Package>newBuilder()
            .setMethodDescriptor(getPackageMethodDescriptor)
            .setParamsExtractor(
                request -> {
                  RequestParamsBuilder builder = RequestParamsBuilder.create();
                  builder.add("name", String.valueOf(request.getName()));
                  return builder.build();
                })
            .build();
    GrpcCallSettings<DeletePackageRequest, Operation> deletePackageTransportSettings =
        GrpcCallSettings.<DeletePackageRequest, Operation>newBuilder()
            .setMethodDescriptor(deletePackageMethodDescriptor)
            .setParamsExtractor(
                request -> {
                  RequestParamsBuilder builder = RequestParamsBuilder.create();
                  builder.add("name", String.valueOf(request.getName()));
                  return builder.build();
                })
            .build();
    GrpcCallSettings<ListVersionsRequest, ListVersionsResponse> listVersionsTransportSettings =
        GrpcCallSettings.<ListVersionsRequest, ListVersionsResponse>newBuilder()
            .setMethodDescriptor(listVersionsMethodDescriptor)
            .setParamsExtractor(
                request -> {
                  RequestParamsBuilder builder = RequestParamsBuilder.create();
                  builder.add("parent", String.valueOf(request.getParent()));
                  return builder.build();
                })
            .build();
    GrpcCallSettings<GetVersionRequest, Version> getVersionTransportSettings =
        GrpcCallSettings.<GetVersionRequest, Version>newBuilder()
            .setMethodDescriptor(getVersionMethodDescriptor)
            .setParamsExtractor(
                request -> {
                  RequestParamsBuilder builder = RequestParamsBuilder.create();
                  builder.add("name", String.valueOf(request.getName()));
                  return builder.build();
                })
            .build();
    GrpcCallSettings<DeleteVersionRequest, Operation> deleteVersionTransportSettings =
        GrpcCallSettings.<DeleteVersionRequest, Operation>newBuilder()
            .setMethodDescriptor(deleteVersionMethodDescriptor)
            .setParamsExtractor(
                request -> {
                  RequestParamsBuilder builder = RequestParamsBuilder.create();
                  builder.add("name", String.valueOf(request.getName()));
                  return builder.build();
                })
            .build();
    GrpcCallSettings<BatchDeleteVersionsRequest, Operation> batchDeleteVersionsTransportSettings =
        GrpcCallSettings.<BatchDeleteVersionsRequest, Operation>newBuilder()
            .setMethodDescriptor(batchDeleteVersionsMethodDescriptor)
            .setParamsExtractor(
                request -> {
                  RequestParamsBuilder builder = RequestParamsBuilder.create();
                  builder.add("parent", String.valueOf(request.getParent()));
                  return builder.build();
                })
            .build();
    GrpcCallSettings<ListFilesRequest, ListFilesResponse> listFilesTransportSettings =
        GrpcCallSettings.<ListFilesRequest, ListFilesResponse>newBuilder()
            .setMethodDescriptor(listFilesMethodDescriptor)
            .setParamsExtractor(
                request -> {
                  RequestParamsBuilder builder = RequestParamsBuilder.create();
                  builder.add("parent", String.valueOf(request.getParent()));
                  return builder.build();
                })
            .build();
    GrpcCallSettings<GetFileRequest, File> getFileTransportSettings =
        GrpcCallSettings.<GetFileRequest, File>newBuilder()
            .setMethodDescriptor(getFileMethodDescriptor)
            .setParamsExtractor(
                request -> {
                  RequestParamsBuilder builder = RequestParamsBuilder.create();
                  builder.add("name", String.valueOf(request.getName()));
                  return builder.build();
                })
            .build();
    GrpcCallSettings<ListTagsRequest, ListTagsResponse> listTagsTransportSettings =
        GrpcCallSettings.<ListTagsRequest, ListTagsResponse>newBuilder()
            .setMethodDescriptor(listTagsMethodDescriptor)
            .setParamsExtractor(
                request -> {
                  RequestParamsBuilder builder = RequestParamsBuilder.create();
                  builder.add("parent", String.valueOf(request.getParent()));
                  return builder.build();
                })
            .build();
    GrpcCallSettings<GetTagRequest, Tag> getTagTransportSettings =
        GrpcCallSettings.<GetTagRequest, Tag>newBuilder()
            .setMethodDescriptor(getTagMethodDescriptor)
            .setParamsExtractor(
                request -> {
                  RequestParamsBuilder builder = RequestParamsBuilder.create();
                  builder.add("name", String.valueOf(request.getName()));
                  return builder.build();
                })
            .build();
    GrpcCallSettings<CreateTagRequest, Tag> createTagTransportSettings =
        GrpcCallSettings.<CreateTagRequest, Tag>newBuilder()
            .setMethodDescriptor(createTagMethodDescriptor)
            .setParamsExtractor(
                request -> {
                  RequestParamsBuilder builder = RequestParamsBuilder.create();
                  builder.add("parent", String.valueOf(request.getParent()));
                  return builder.build();
                })
            .build();
    GrpcCallSettings<UpdateTagRequest, Tag> updateTagTransportSettings =
        GrpcCallSettings.<UpdateTagRequest, Tag>newBuilder()
            .setMethodDescriptor(updateTagMethodDescriptor)
            .setParamsExtractor(
                request -> {
                  RequestParamsBuilder builder = RequestParamsBuilder.create();
                  builder.add("tag.name", String.valueOf(request.getTag().getName()));
                  return builder.build();
                })
            .build();
    GrpcCallSettings<DeleteTagRequest, Empty> deleteTagTransportSettings =
        GrpcCallSettings.<DeleteTagRequest, Empty>newBuilder()
            .setMethodDescriptor(deleteTagMethodDescriptor)
            .setParamsExtractor(
                request -> {
                  RequestParamsBuilder builder = RequestParamsBuilder.create();
                  builder.add("name", String.valueOf(request.getName()));
                  return builder.build();
                })
            .build();
    GrpcCallSettings<SetIamPolicyRequest, Policy> setIamPolicyTransportSettings =
        GrpcCallSettings.<SetIamPolicyRequest, Policy>newBuilder()
            .setMethodDescriptor(setIamPolicyMethodDescriptor)
            .setParamsExtractor(
                request -> {
                  RequestParamsBuilder builder = RequestParamsBuilder.create();
                  builder.add("resource", String.valueOf(request.getResource()));
                  return builder.build();
                })
            .build();
    GrpcCallSettings<GetIamPolicyRequest, Policy> getIamPolicyTransportSettings =
        GrpcCallSettings.<GetIamPolicyRequest, Policy>newBuilder()
            .setMethodDescriptor(getIamPolicyMethodDescriptor)
            .setParamsExtractor(
                request -> {
                  RequestParamsBuilder builder = RequestParamsBuilder.create();
                  builder.add("resource", String.valueOf(request.getResource()));
                  return builder.build();
                })
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
                .build();
    GrpcCallSettings<GetProjectSettingsRequest, ProjectSettings>
        getProjectSettingsTransportSettings =
            GrpcCallSettings.<GetProjectSettingsRequest, ProjectSettings>newBuilder()
                .setMethodDescriptor(getProjectSettingsMethodDescriptor)
                .setParamsExtractor(
                    request -> {
                      RequestParamsBuilder builder = RequestParamsBuilder.create();
                      builder.add("name", String.valueOf(request.getName()));
                      return builder.build();
                    })
                .build();
    GrpcCallSettings<UpdateProjectSettingsRequest, ProjectSettings>
        updateProjectSettingsTransportSettings =
            GrpcCallSettings.<UpdateProjectSettingsRequest, ProjectSettings>newBuilder()
                .setMethodDescriptor(updateProjectSettingsMethodDescriptor)
                .setParamsExtractor(
                    request -> {
                      RequestParamsBuilder builder = RequestParamsBuilder.create();
                      builder.add(
                          "project_settings.name",
                          String.valueOf(request.getProjectSettings().getName()));
                      return builder.build();
                    })
                .build();
    GrpcCallSettings<GetVPCSCConfigRequest, VPCSCConfig> getVPCSCConfigTransportSettings =
        GrpcCallSettings.<GetVPCSCConfigRequest, VPCSCConfig>newBuilder()
            .setMethodDescriptor(getVPCSCConfigMethodDescriptor)
            .setParamsExtractor(
                request -> {
                  RequestParamsBuilder builder = RequestParamsBuilder.create();
                  builder.add("name", String.valueOf(request.getName()));
                  return builder.build();
                })
            .build();
    GrpcCallSettings<UpdateVPCSCConfigRequest, VPCSCConfig> updateVPCSCConfigTransportSettings =
        GrpcCallSettings.<UpdateVPCSCConfigRequest, VPCSCConfig>newBuilder()
            .setMethodDescriptor(updateVPCSCConfigMethodDescriptor)
            .setParamsExtractor(
                request -> {
                  RequestParamsBuilder builder = RequestParamsBuilder.create();
                  builder.add(
                      "vpcsc_config.name", String.valueOf(request.getVpcscConfig().getName()));
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

    this.listDockerImagesCallable =
        callableFactory.createUnaryCallable(
            listDockerImagesTransportSettings, settings.listDockerImagesSettings(), clientContext);
    this.listDockerImagesPagedCallable =
        callableFactory.createPagedCallable(
            listDockerImagesTransportSettings, settings.listDockerImagesSettings(), clientContext);
    this.getDockerImageCallable =
        callableFactory.createUnaryCallable(
            getDockerImageTransportSettings, settings.getDockerImageSettings(), clientContext);
    this.listMavenArtifactsCallable =
        callableFactory.createUnaryCallable(
            listMavenArtifactsTransportSettings,
            settings.listMavenArtifactsSettings(),
            clientContext);
    this.listMavenArtifactsPagedCallable =
        callableFactory.createPagedCallable(
            listMavenArtifactsTransportSettings,
            settings.listMavenArtifactsSettings(),
            clientContext);
    this.getMavenArtifactCallable =
        callableFactory.createUnaryCallable(
            getMavenArtifactTransportSettings, settings.getMavenArtifactSettings(), clientContext);
    this.listNpmPackagesCallable =
        callableFactory.createUnaryCallable(
            listNpmPackagesTransportSettings, settings.listNpmPackagesSettings(), clientContext);
    this.listNpmPackagesPagedCallable =
        callableFactory.createPagedCallable(
            listNpmPackagesTransportSettings, settings.listNpmPackagesSettings(), clientContext);
    this.getNpmPackageCallable =
        callableFactory.createUnaryCallable(
            getNpmPackageTransportSettings, settings.getNpmPackageSettings(), clientContext);
    this.listPythonPackagesCallable =
        callableFactory.createUnaryCallable(
            listPythonPackagesTransportSettings,
            settings.listPythonPackagesSettings(),
            clientContext);
    this.listPythonPackagesPagedCallable =
        callableFactory.createPagedCallable(
            listPythonPackagesTransportSettings,
            settings.listPythonPackagesSettings(),
            clientContext);
    this.getPythonPackageCallable =
        callableFactory.createUnaryCallable(
            getPythonPackageTransportSettings, settings.getPythonPackageSettings(), clientContext);
    this.importAptArtifactsCallable =
        callableFactory.createUnaryCallable(
            importAptArtifactsTransportSettings,
            settings.importAptArtifactsSettings(),
            clientContext);
    this.importAptArtifactsOperationCallable =
        callableFactory.createOperationCallable(
            importAptArtifactsTransportSettings,
            settings.importAptArtifactsOperationSettings(),
            clientContext,
            operationsStub);
    this.importYumArtifactsCallable =
        callableFactory.createUnaryCallable(
            importYumArtifactsTransportSettings,
            settings.importYumArtifactsSettings(),
            clientContext);
    this.importYumArtifactsOperationCallable =
        callableFactory.createOperationCallable(
            importYumArtifactsTransportSettings,
            settings.importYumArtifactsOperationSettings(),
            clientContext,
            operationsStub);
    this.listRepositoriesCallable =
        callableFactory.createUnaryCallable(
            listRepositoriesTransportSettings, settings.listRepositoriesSettings(), clientContext);
    this.listRepositoriesPagedCallable =
        callableFactory.createPagedCallable(
            listRepositoriesTransportSettings, settings.listRepositoriesSettings(), clientContext);
    this.getRepositoryCallable =
        callableFactory.createUnaryCallable(
            getRepositoryTransportSettings, settings.getRepositorySettings(), clientContext);
    this.createRepositoryCallable =
        callableFactory.createUnaryCallable(
            createRepositoryTransportSettings, settings.createRepositorySettings(), clientContext);
    this.createRepositoryOperationCallable =
        callableFactory.createOperationCallable(
            createRepositoryTransportSettings,
            settings.createRepositoryOperationSettings(),
            clientContext,
            operationsStub);
    this.updateRepositoryCallable =
        callableFactory.createUnaryCallable(
            updateRepositoryTransportSettings, settings.updateRepositorySettings(), clientContext);
    this.deleteRepositoryCallable =
        callableFactory.createUnaryCallable(
            deleteRepositoryTransportSettings, settings.deleteRepositorySettings(), clientContext);
    this.deleteRepositoryOperationCallable =
        callableFactory.createOperationCallable(
            deleteRepositoryTransportSettings,
            settings.deleteRepositoryOperationSettings(),
            clientContext,
            operationsStub);
    this.listPackagesCallable =
        callableFactory.createUnaryCallable(
            listPackagesTransportSettings, settings.listPackagesSettings(), clientContext);
    this.listPackagesPagedCallable =
        callableFactory.createPagedCallable(
            listPackagesTransportSettings, settings.listPackagesSettings(), clientContext);
    this.getPackageCallable =
        callableFactory.createUnaryCallable(
            getPackageTransportSettings, settings.getPackageSettings(), clientContext);
    this.deletePackageCallable =
        callableFactory.createUnaryCallable(
            deletePackageTransportSettings, settings.deletePackageSettings(), clientContext);
    this.deletePackageOperationCallable =
        callableFactory.createOperationCallable(
            deletePackageTransportSettings,
            settings.deletePackageOperationSettings(),
            clientContext,
            operationsStub);
    this.listVersionsCallable =
        callableFactory.createUnaryCallable(
            listVersionsTransportSettings, settings.listVersionsSettings(), clientContext);
    this.listVersionsPagedCallable =
        callableFactory.createPagedCallable(
            listVersionsTransportSettings, settings.listVersionsSettings(), clientContext);
    this.getVersionCallable =
        callableFactory.createUnaryCallable(
            getVersionTransportSettings, settings.getVersionSettings(), clientContext);
    this.deleteVersionCallable =
        callableFactory.createUnaryCallable(
            deleteVersionTransportSettings, settings.deleteVersionSettings(), clientContext);
    this.deleteVersionOperationCallable =
        callableFactory.createOperationCallable(
            deleteVersionTransportSettings,
            settings.deleteVersionOperationSettings(),
            clientContext,
            operationsStub);
    this.batchDeleteVersionsCallable =
        callableFactory.createUnaryCallable(
            batchDeleteVersionsTransportSettings,
            settings.batchDeleteVersionsSettings(),
            clientContext);
    this.batchDeleteVersionsOperationCallable =
        callableFactory.createOperationCallable(
            batchDeleteVersionsTransportSettings,
            settings.batchDeleteVersionsOperationSettings(),
            clientContext,
            operationsStub);
    this.listFilesCallable =
        callableFactory.createUnaryCallable(
            listFilesTransportSettings, settings.listFilesSettings(), clientContext);
    this.listFilesPagedCallable =
        callableFactory.createPagedCallable(
            listFilesTransportSettings, settings.listFilesSettings(), clientContext);
    this.getFileCallable =
        callableFactory.createUnaryCallable(
            getFileTransportSettings, settings.getFileSettings(), clientContext);
    this.listTagsCallable =
        callableFactory.createUnaryCallable(
            listTagsTransportSettings, settings.listTagsSettings(), clientContext);
    this.listTagsPagedCallable =
        callableFactory.createPagedCallable(
            listTagsTransportSettings, settings.listTagsSettings(), clientContext);
    this.getTagCallable =
        callableFactory.createUnaryCallable(
            getTagTransportSettings, settings.getTagSettings(), clientContext);
    this.createTagCallable =
        callableFactory.createUnaryCallable(
            createTagTransportSettings, settings.createTagSettings(), clientContext);
    this.updateTagCallable =
        callableFactory.createUnaryCallable(
            updateTagTransportSettings, settings.updateTagSettings(), clientContext);
    this.deleteTagCallable =
        callableFactory.createUnaryCallable(
            deleteTagTransportSettings, settings.deleteTagSettings(), clientContext);
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
    this.getProjectSettingsCallable =
        callableFactory.createUnaryCallable(
            getProjectSettingsTransportSettings,
            settings.getProjectSettingsSettings(),
            clientContext);
    this.updateProjectSettingsCallable =
        callableFactory.createUnaryCallable(
            updateProjectSettingsTransportSettings,
            settings.updateProjectSettingsSettings(),
            clientContext);
    this.getVPCSCConfigCallable =
        callableFactory.createUnaryCallable(
            getVPCSCConfigTransportSettings, settings.getVPCSCConfigSettings(), clientContext);
    this.updateVPCSCConfigCallable =
        callableFactory.createUnaryCallable(
            updateVPCSCConfigTransportSettings,
            settings.updateVPCSCConfigSettings(),
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
  public UnaryCallable<ListDockerImagesRequest, ListDockerImagesResponse>
      listDockerImagesCallable() {
    return listDockerImagesCallable;
  }

  @Override
  public UnaryCallable<ListDockerImagesRequest, ListDockerImagesPagedResponse>
      listDockerImagesPagedCallable() {
    return listDockerImagesPagedCallable;
  }

  @Override
  public UnaryCallable<GetDockerImageRequest, DockerImage> getDockerImageCallable() {
    return getDockerImageCallable;
  }

  @Override
  public UnaryCallable<ListMavenArtifactsRequest, ListMavenArtifactsResponse>
      listMavenArtifactsCallable() {
    return listMavenArtifactsCallable;
  }

  @Override
  public UnaryCallable<ListMavenArtifactsRequest, ListMavenArtifactsPagedResponse>
      listMavenArtifactsPagedCallable() {
    return listMavenArtifactsPagedCallable;
  }

  @Override
  public UnaryCallable<GetMavenArtifactRequest, MavenArtifact> getMavenArtifactCallable() {
    return getMavenArtifactCallable;
  }

  @Override
  public UnaryCallable<ListNpmPackagesRequest, ListNpmPackagesResponse> listNpmPackagesCallable() {
    return listNpmPackagesCallable;
  }

  @Override
  public UnaryCallable<ListNpmPackagesRequest, ListNpmPackagesPagedResponse>
      listNpmPackagesPagedCallable() {
    return listNpmPackagesPagedCallable;
  }

  @Override
  public UnaryCallable<GetNpmPackageRequest, NpmPackage> getNpmPackageCallable() {
    return getNpmPackageCallable;
  }

  @Override
  public UnaryCallable<ListPythonPackagesRequest, ListPythonPackagesResponse>
      listPythonPackagesCallable() {
    return listPythonPackagesCallable;
  }

  @Override
  public UnaryCallable<ListPythonPackagesRequest, ListPythonPackagesPagedResponse>
      listPythonPackagesPagedCallable() {
    return listPythonPackagesPagedCallable;
  }

  @Override
  public UnaryCallable<GetPythonPackageRequest, PythonPackage> getPythonPackageCallable() {
    return getPythonPackageCallable;
  }

  @Override
  public UnaryCallable<ImportAptArtifactsRequest, Operation> importAptArtifactsCallable() {
    return importAptArtifactsCallable;
  }

  @Override
  public OperationCallable<
          ImportAptArtifactsRequest, ImportAptArtifactsResponse, ImportAptArtifactsMetadata>
      importAptArtifactsOperationCallable() {
    return importAptArtifactsOperationCallable;
  }

  @Override
  public UnaryCallable<ImportYumArtifactsRequest, Operation> importYumArtifactsCallable() {
    return importYumArtifactsCallable;
  }

  @Override
  public OperationCallable<
          ImportYumArtifactsRequest, ImportYumArtifactsResponse, ImportYumArtifactsMetadata>
      importYumArtifactsOperationCallable() {
    return importYumArtifactsOperationCallable;
  }

  @Override
  public UnaryCallable<ListRepositoriesRequest, ListRepositoriesResponse>
      listRepositoriesCallable() {
    return listRepositoriesCallable;
  }

  @Override
  public UnaryCallable<ListRepositoriesRequest, ListRepositoriesPagedResponse>
      listRepositoriesPagedCallable() {
    return listRepositoriesPagedCallable;
  }

  @Override
  public UnaryCallable<GetRepositoryRequest, Repository> getRepositoryCallable() {
    return getRepositoryCallable;
  }

  @Override
  public UnaryCallable<CreateRepositoryRequest, Operation> createRepositoryCallable() {
    return createRepositoryCallable;
  }

  @Override
  public OperationCallable<CreateRepositoryRequest, Repository, OperationMetadata>
      createRepositoryOperationCallable() {
    return createRepositoryOperationCallable;
  }

  @Override
  public UnaryCallable<UpdateRepositoryRequest, Repository> updateRepositoryCallable() {
    return updateRepositoryCallable;
  }

  @Override
  public UnaryCallable<DeleteRepositoryRequest, Operation> deleteRepositoryCallable() {
    return deleteRepositoryCallable;
  }

  @Override
  public OperationCallable<DeleteRepositoryRequest, Empty, OperationMetadata>
      deleteRepositoryOperationCallable() {
    return deleteRepositoryOperationCallable;
  }

  @Override
  public UnaryCallable<ListPackagesRequest, ListPackagesResponse> listPackagesCallable() {
    return listPackagesCallable;
  }

  @Override
  public UnaryCallable<ListPackagesRequest, ListPackagesPagedResponse> listPackagesPagedCallable() {
    return listPackagesPagedCallable;
  }

  @Override
  public UnaryCallable<GetPackageRequest, Package> getPackageCallable() {
    return getPackageCallable;
  }

  @Override
  public UnaryCallable<DeletePackageRequest, Operation> deletePackageCallable() {
    return deletePackageCallable;
  }

  @Override
  public OperationCallable<DeletePackageRequest, Empty, OperationMetadata>
      deletePackageOperationCallable() {
    return deletePackageOperationCallable;
  }

  @Override
  public UnaryCallable<ListVersionsRequest, ListVersionsResponse> listVersionsCallable() {
    return listVersionsCallable;
  }

  @Override
  public UnaryCallable<ListVersionsRequest, ListVersionsPagedResponse> listVersionsPagedCallable() {
    return listVersionsPagedCallable;
  }

  @Override
  public UnaryCallable<GetVersionRequest, Version> getVersionCallable() {
    return getVersionCallable;
  }

  @Override
  public UnaryCallable<DeleteVersionRequest, Operation> deleteVersionCallable() {
    return deleteVersionCallable;
  }

  @Override
  public OperationCallable<DeleteVersionRequest, Empty, OperationMetadata>
      deleteVersionOperationCallable() {
    return deleteVersionOperationCallable;
  }

  @Override
  public UnaryCallable<BatchDeleteVersionsRequest, Operation> batchDeleteVersionsCallable() {
    return batchDeleteVersionsCallable;
  }

  @Override
  public OperationCallable<BatchDeleteVersionsRequest, Empty, BatchDeleteVersionsMetadata>
      batchDeleteVersionsOperationCallable() {
    return batchDeleteVersionsOperationCallable;
  }

  @Override
  public UnaryCallable<ListFilesRequest, ListFilesResponse> listFilesCallable() {
    return listFilesCallable;
  }

  @Override
  public UnaryCallable<ListFilesRequest, ListFilesPagedResponse> listFilesPagedCallable() {
    return listFilesPagedCallable;
  }

  @Override
  public UnaryCallable<GetFileRequest, File> getFileCallable() {
    return getFileCallable;
  }

  @Override
  public UnaryCallable<ListTagsRequest, ListTagsResponse> listTagsCallable() {
    return listTagsCallable;
  }

  @Override
  public UnaryCallable<ListTagsRequest, ListTagsPagedResponse> listTagsPagedCallable() {
    return listTagsPagedCallable;
  }

  @Override
  public UnaryCallable<GetTagRequest, Tag> getTagCallable() {
    return getTagCallable;
  }

  @Override
  public UnaryCallable<CreateTagRequest, Tag> createTagCallable() {
    return createTagCallable;
  }

  @Override
  public UnaryCallable<UpdateTagRequest, Tag> updateTagCallable() {
    return updateTagCallable;
  }

  @Override
  public UnaryCallable<DeleteTagRequest, Empty> deleteTagCallable() {
    return deleteTagCallable;
  }

  @Override
  public UnaryCallable<SetIamPolicyRequest, Policy> setIamPolicyCallable() {
    return setIamPolicyCallable;
  }

  @Override
  public UnaryCallable<GetIamPolicyRequest, Policy> getIamPolicyCallable() {
    return getIamPolicyCallable;
  }

  @Override
  public UnaryCallable<TestIamPermissionsRequest, TestIamPermissionsResponse>
      testIamPermissionsCallable() {
    return testIamPermissionsCallable;
  }

  @Override
  public UnaryCallable<GetProjectSettingsRequest, ProjectSettings> getProjectSettingsCallable() {
    return getProjectSettingsCallable;
  }

  @Override
  public UnaryCallable<UpdateProjectSettingsRequest, ProjectSettings>
      updateProjectSettingsCallable() {
    return updateProjectSettingsCallable;
  }

  @Override
  public UnaryCallable<GetVPCSCConfigRequest, VPCSCConfig> getVPCSCConfigCallable() {
    return getVPCSCConfigCallable;
  }

  @Override
  public UnaryCallable<UpdateVPCSCConfigRequest, VPCSCConfig> updateVPCSCConfigCallable() {
    return updateVPCSCConfigCallable;
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
