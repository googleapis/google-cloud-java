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

package com.google.cloud.sql.v1beta4.stub;

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
import com.google.api.gax.rpc.RequestParamsBuilder;
import com.google.api.gax.rpc.UnaryCallable;
import com.google.api.pathtemplate.PathTemplate;
import com.google.cloud.sql.v1beta4.DatabaseInstance;
import com.google.cloud.sql.v1beta4.InstancesListEntraIdCertificatesResponse;
import com.google.cloud.sql.v1beta4.InstancesListResponse;
import com.google.cloud.sql.v1beta4.InstancesListServerCasResponse;
import com.google.cloud.sql.v1beta4.InstancesListServerCertificatesResponse;
import com.google.cloud.sql.v1beta4.Operation;
import com.google.cloud.sql.v1beta4.SqlInstancesAcquireSsrsLeaseRequest;
import com.google.cloud.sql.v1beta4.SqlInstancesAcquireSsrsLeaseResponse;
import com.google.cloud.sql.v1beta4.SqlInstancesAddEntraIdCertificateRequest;
import com.google.cloud.sql.v1beta4.SqlInstancesAddServerCaRequest;
import com.google.cloud.sql.v1beta4.SqlInstancesAddServerCertificateRequest;
import com.google.cloud.sql.v1beta4.SqlInstancesCloneRequest;
import com.google.cloud.sql.v1beta4.SqlInstancesCreateEphemeralCertRequest;
import com.google.cloud.sql.v1beta4.SqlInstancesDeleteRequest;
import com.google.cloud.sql.v1beta4.SqlInstancesDemoteMasterRequest;
import com.google.cloud.sql.v1beta4.SqlInstancesDemoteRequest;
import com.google.cloud.sql.v1beta4.SqlInstancesExecuteSqlRequest;
import com.google.cloud.sql.v1beta4.SqlInstancesExecuteSqlResponse;
import com.google.cloud.sql.v1beta4.SqlInstancesExportRequest;
import com.google.cloud.sql.v1beta4.SqlInstancesFailoverRequest;
import com.google.cloud.sql.v1beta4.SqlInstancesGetDiskShrinkConfigRequest;
import com.google.cloud.sql.v1beta4.SqlInstancesGetDiskShrinkConfigResponse;
import com.google.cloud.sql.v1beta4.SqlInstancesGetLatestRecoveryTimeRequest;
import com.google.cloud.sql.v1beta4.SqlInstancesGetLatestRecoveryTimeResponse;
import com.google.cloud.sql.v1beta4.SqlInstancesGetRequest;
import com.google.cloud.sql.v1beta4.SqlInstancesImportRequest;
import com.google.cloud.sql.v1beta4.SqlInstancesInsertRequest;
import com.google.cloud.sql.v1beta4.SqlInstancesListEntraIdCertificatesRequest;
import com.google.cloud.sql.v1beta4.SqlInstancesListRequest;
import com.google.cloud.sql.v1beta4.SqlInstancesListServerCasRequest;
import com.google.cloud.sql.v1beta4.SqlInstancesListServerCertificatesRequest;
import com.google.cloud.sql.v1beta4.SqlInstancesPatchRequest;
import com.google.cloud.sql.v1beta4.SqlInstancesPerformDiskShrinkRequest;
import com.google.cloud.sql.v1beta4.SqlInstancesPointInTimeRestoreRequest;
import com.google.cloud.sql.v1beta4.SqlInstancesPreCheckMajorVersionUpgradeRequest;
import com.google.cloud.sql.v1beta4.SqlInstancesPromoteReplicaRequest;
import com.google.cloud.sql.v1beta4.SqlInstancesReencryptRequest;
import com.google.cloud.sql.v1beta4.SqlInstancesReleaseSsrsLeaseRequest;
import com.google.cloud.sql.v1beta4.SqlInstancesReleaseSsrsLeaseResponse;
import com.google.cloud.sql.v1beta4.SqlInstancesRescheduleMaintenanceRequest;
import com.google.cloud.sql.v1beta4.SqlInstancesResetReplicaSizeRequest;
import com.google.cloud.sql.v1beta4.SqlInstancesResetSslConfigRequest;
import com.google.cloud.sql.v1beta4.SqlInstancesRestartRequest;
import com.google.cloud.sql.v1beta4.SqlInstancesRestoreBackupRequest;
import com.google.cloud.sql.v1beta4.SqlInstancesRotateEntraIdCertificateRequest;
import com.google.cloud.sql.v1beta4.SqlInstancesRotateServerCaRequest;
import com.google.cloud.sql.v1beta4.SqlInstancesRotateServerCertificateRequest;
import com.google.cloud.sql.v1beta4.SqlInstancesStartExternalSyncRequest;
import com.google.cloud.sql.v1beta4.SqlInstancesStartReplicaRequest;
import com.google.cloud.sql.v1beta4.SqlInstancesStopReplicaRequest;
import com.google.cloud.sql.v1beta4.SqlInstancesSwitchoverRequest;
import com.google.cloud.sql.v1beta4.SqlInstancesTruncateLogRequest;
import com.google.cloud.sql.v1beta4.SqlInstancesUpdateRequest;
import com.google.cloud.sql.v1beta4.SqlInstancesVerifyExternalSyncSettingsRequest;
import com.google.cloud.sql.v1beta4.SqlInstancesVerifyExternalSyncSettingsResponse;
import com.google.cloud.sql.v1beta4.SslCert;
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
 * REST stub implementation for the SqlInstancesService service API.
 *
 * <p>This class is for advanced usage and reflects the underlying API directly.
 */
@NullMarked
@BetaApi
@Generated("by gapic-generator-java")
public class HttpJsonSqlInstancesServiceStub extends SqlInstancesServiceStub {
  private static final TypeRegistry typeRegistry = TypeRegistry.newBuilder().build();

  private static final ApiMethodDescriptor<SqlInstancesAddServerCaRequest, Operation>
      addServerCaMethodDescriptor =
          ApiMethodDescriptor.<SqlInstancesAddServerCaRequest, Operation>newBuilder()
              .setFullMethodName("google.cloud.sql.v1beta4.SqlInstancesService/AddServerCa")
              .setHttpMethod("POST")
              .setType(ApiMethodDescriptor.MethodType.UNARY)
              .setRequestFormatter(
                  ProtoMessageRequestFormatter.<SqlInstancesAddServerCaRequest>newBuilder()
                      .setPath(
                          "/sql/v1beta4/projects/{project}/instances/{instance}/addServerCa",
                          request -> {
                            Map<String, String> fields = new HashMap<>();
                            ProtoRestSerializer<SqlInstancesAddServerCaRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putPathParam(fields, "instance", request.getInstance());
                            serializer.putPathParam(fields, "project", request.getProject());
                            return fields;
                          })
                      .setQueryParamsExtractor(
                          request -> {
                            Map<String, List<String>> fields = new HashMap<>();
                            ProtoRestSerializer<SqlInstancesAddServerCaRequest> serializer =
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
              .build();

  private static final ApiMethodDescriptor<SqlInstancesAddServerCertificateRequest, Operation>
      addServerCertificateMethodDescriptor =
          ApiMethodDescriptor.<SqlInstancesAddServerCertificateRequest, Operation>newBuilder()
              .setFullMethodName(
                  "google.cloud.sql.v1beta4.SqlInstancesService/AddServerCertificate")
              .setHttpMethod("POST")
              .setType(ApiMethodDescriptor.MethodType.UNARY)
              .setRequestFormatter(
                  ProtoMessageRequestFormatter.<SqlInstancesAddServerCertificateRequest>newBuilder()
                      .setPath(
                          "/sql/v1beta4/projects/{project}/instances/{instance}/addServerCertificate",
                          request -> {
                            Map<String, String> fields = new HashMap<>();
                            ProtoRestSerializer<SqlInstancesAddServerCertificateRequest>
                                serializer = ProtoRestSerializer.create();
                            serializer.putPathParam(fields, "instance", request.getInstance());
                            serializer.putPathParam(fields, "project", request.getProject());
                            return fields;
                          })
                      .setQueryParamsExtractor(
                          request -> {
                            Map<String, List<String>> fields = new HashMap<>();
                            ProtoRestSerializer<SqlInstancesAddServerCertificateRequest>
                                serializer = ProtoRestSerializer.create();
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
              .build();

  private static final ApiMethodDescriptor<SqlInstancesAddEntraIdCertificateRequest, Operation>
      addEntraIdCertificateMethodDescriptor =
          ApiMethodDescriptor.<SqlInstancesAddEntraIdCertificateRequest, Operation>newBuilder()
              .setFullMethodName(
                  "google.cloud.sql.v1beta4.SqlInstancesService/AddEntraIdCertificate")
              .setHttpMethod("POST")
              .setType(ApiMethodDescriptor.MethodType.UNARY)
              .setRequestFormatter(
                  ProtoMessageRequestFormatter
                      .<SqlInstancesAddEntraIdCertificateRequest>newBuilder()
                      .setPath(
                          "/sql/v1beta4/projects/{project}/instances/{instance}/addEntraIdCertificate",
                          request -> {
                            Map<String, String> fields = new HashMap<>();
                            ProtoRestSerializer<SqlInstancesAddEntraIdCertificateRequest>
                                serializer = ProtoRestSerializer.create();
                            serializer.putPathParam(fields, "instance", request.getInstance());
                            serializer.putPathParam(fields, "project", request.getProject());
                            return fields;
                          })
                      .setQueryParamsExtractor(
                          request -> {
                            Map<String, List<String>> fields = new HashMap<>();
                            ProtoRestSerializer<SqlInstancesAddEntraIdCertificateRequest>
                                serializer = ProtoRestSerializer.create();
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
              .build();

  private static final ApiMethodDescriptor<SqlInstancesCloneRequest, Operation>
      cloneMethodDescriptor =
          ApiMethodDescriptor.<SqlInstancesCloneRequest, Operation>newBuilder()
              .setFullMethodName("google.cloud.sql.v1beta4.SqlInstancesService/Clone")
              .setHttpMethod("POST")
              .setType(ApiMethodDescriptor.MethodType.UNARY)
              .setRequestFormatter(
                  ProtoMessageRequestFormatter.<SqlInstancesCloneRequest>newBuilder()
                      .setPath(
                          "/sql/v1beta4/projects/{project}/instances/{instance}/clone",
                          request -> {
                            Map<String, String> fields = new HashMap<>();
                            ProtoRestSerializer<SqlInstancesCloneRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putPathParam(fields, "instance", request.getInstance());
                            serializer.putPathParam(fields, "project", request.getProject());
                            return fields;
                          })
                      .setQueryParamsExtractor(
                          request -> {
                            Map<String, List<String>> fields = new HashMap<>();
                            ProtoRestSerializer<SqlInstancesCloneRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putQueryParam(fields, "$alt", "json;enum-encoding=int");
                            return fields;
                          })
                      .setRequestBodyExtractor(
                          request ->
                              ProtoRestSerializer.create().toBody("body", request.getBody(), true))
                      .build())
              .setResponseParser(
                  ProtoMessageResponseParser.<Operation>newBuilder()
                      .setDefaultInstance(Operation.getDefaultInstance())
                      .setDefaultTypeRegistry(typeRegistry)
                      .build())
              .build();

  private static final ApiMethodDescriptor<SqlInstancesDeleteRequest, Operation>
      deleteMethodDescriptor =
          ApiMethodDescriptor.<SqlInstancesDeleteRequest, Operation>newBuilder()
              .setFullMethodName("google.cloud.sql.v1beta4.SqlInstancesService/Delete")
              .setHttpMethod("DELETE")
              .setType(ApiMethodDescriptor.MethodType.UNARY)
              .setRequestFormatter(
                  ProtoMessageRequestFormatter.<SqlInstancesDeleteRequest>newBuilder()
                      .setPath(
                          "/sql/v1beta4/projects/{project}/instances/{instance}",
                          request -> {
                            Map<String, String> fields = new HashMap<>();
                            ProtoRestSerializer<SqlInstancesDeleteRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putPathParam(fields, "instance", request.getInstance());
                            serializer.putPathParam(fields, "project", request.getProject());
                            return fields;
                          })
                      .setQueryParamsExtractor(
                          request -> {
                            Map<String, List<String>> fields = new HashMap<>();
                            ProtoRestSerializer<SqlInstancesDeleteRequest> serializer =
                                ProtoRestSerializer.create();
                            if (request.hasEnableFinalBackup()) {
                              serializer.putQueryParam(
                                  fields, "enableFinalBackup", request.getEnableFinalBackup());
                            }
                            serializer.putQueryParam(
                                fields,
                                "finalBackupDescription",
                                request.getFinalBackupDescription());
                            serializer.putQueryParam(
                                fields,
                                "finalBackupExpiryTime",
                                request.getFinalBackupExpiryTime());
                            serializer.putQueryParam(
                                fields, "finalBackupTtlDays", request.getFinalBackupTtlDays());
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
              .build();

  private static final ApiMethodDescriptor<SqlInstancesDemoteMasterRequest, Operation>
      demoteMasterMethodDescriptor =
          ApiMethodDescriptor.<SqlInstancesDemoteMasterRequest, Operation>newBuilder()
              .setFullMethodName("google.cloud.sql.v1beta4.SqlInstancesService/DemoteMaster")
              .setHttpMethod("POST")
              .setType(ApiMethodDescriptor.MethodType.UNARY)
              .setRequestFormatter(
                  ProtoMessageRequestFormatter.<SqlInstancesDemoteMasterRequest>newBuilder()
                      .setPath(
                          "/sql/v1beta4/projects/{project}/instances/{instance}/demoteMaster",
                          request -> {
                            Map<String, String> fields = new HashMap<>();
                            ProtoRestSerializer<SqlInstancesDemoteMasterRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putPathParam(fields, "instance", request.getInstance());
                            serializer.putPathParam(fields, "project", request.getProject());
                            return fields;
                          })
                      .setQueryParamsExtractor(
                          request -> {
                            Map<String, List<String>> fields = new HashMap<>();
                            ProtoRestSerializer<SqlInstancesDemoteMasterRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putQueryParam(fields, "$alt", "json;enum-encoding=int");
                            return fields;
                          })
                      .setRequestBodyExtractor(
                          request ->
                              ProtoRestSerializer.create().toBody("body", request.getBody(), true))
                      .build())
              .setResponseParser(
                  ProtoMessageResponseParser.<Operation>newBuilder()
                      .setDefaultInstance(Operation.getDefaultInstance())
                      .setDefaultTypeRegistry(typeRegistry)
                      .build())
              .build();

  private static final ApiMethodDescriptor<SqlInstancesDemoteRequest, Operation>
      demoteMethodDescriptor =
          ApiMethodDescriptor.<SqlInstancesDemoteRequest, Operation>newBuilder()
              .setFullMethodName("google.cloud.sql.v1beta4.SqlInstancesService/Demote")
              .setHttpMethod("POST")
              .setType(ApiMethodDescriptor.MethodType.UNARY)
              .setRequestFormatter(
                  ProtoMessageRequestFormatter.<SqlInstancesDemoteRequest>newBuilder()
                      .setPath(
                          "/sql/v1beta4/projects/{project}/instances/{instance}/demote",
                          request -> {
                            Map<String, String> fields = new HashMap<>();
                            ProtoRestSerializer<SqlInstancesDemoteRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putPathParam(fields, "instance", request.getInstance());
                            serializer.putPathParam(fields, "project", request.getProject());
                            return fields;
                          })
                      .setQueryParamsExtractor(
                          request -> {
                            Map<String, List<String>> fields = new HashMap<>();
                            ProtoRestSerializer<SqlInstancesDemoteRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putQueryParam(fields, "$alt", "json;enum-encoding=int");
                            return fields;
                          })
                      .setRequestBodyExtractor(
                          request ->
                              ProtoRestSerializer.create().toBody("body", request.getBody(), true))
                      .build())
              .setResponseParser(
                  ProtoMessageResponseParser.<Operation>newBuilder()
                      .setDefaultInstance(Operation.getDefaultInstance())
                      .setDefaultTypeRegistry(typeRegistry)
                      .build())
              .build();

  private static final ApiMethodDescriptor<SqlInstancesExportRequest, Operation>
      exportMethodDescriptor =
          ApiMethodDescriptor.<SqlInstancesExportRequest, Operation>newBuilder()
              .setFullMethodName("google.cloud.sql.v1beta4.SqlInstancesService/Export")
              .setHttpMethod("POST")
              .setType(ApiMethodDescriptor.MethodType.UNARY)
              .setRequestFormatter(
                  ProtoMessageRequestFormatter.<SqlInstancesExportRequest>newBuilder()
                      .setPath(
                          "/sql/v1beta4/projects/{project}/instances/{instance}/export",
                          request -> {
                            Map<String, String> fields = new HashMap<>();
                            ProtoRestSerializer<SqlInstancesExportRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putPathParam(fields, "instance", request.getInstance());
                            serializer.putPathParam(fields, "project", request.getProject());
                            return fields;
                          })
                      .setQueryParamsExtractor(
                          request -> {
                            Map<String, List<String>> fields = new HashMap<>();
                            ProtoRestSerializer<SqlInstancesExportRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putQueryParam(fields, "$alt", "json;enum-encoding=int");
                            return fields;
                          })
                      .setRequestBodyExtractor(
                          request ->
                              ProtoRestSerializer.create().toBody("body", request.getBody(), true))
                      .build())
              .setResponseParser(
                  ProtoMessageResponseParser.<Operation>newBuilder()
                      .setDefaultInstance(Operation.getDefaultInstance())
                      .setDefaultTypeRegistry(typeRegistry)
                      .build())
              .build();

  private static final ApiMethodDescriptor<SqlInstancesFailoverRequest, Operation>
      failoverMethodDescriptor =
          ApiMethodDescriptor.<SqlInstancesFailoverRequest, Operation>newBuilder()
              .setFullMethodName("google.cloud.sql.v1beta4.SqlInstancesService/Failover")
              .setHttpMethod("POST")
              .setType(ApiMethodDescriptor.MethodType.UNARY)
              .setRequestFormatter(
                  ProtoMessageRequestFormatter.<SqlInstancesFailoverRequest>newBuilder()
                      .setPath(
                          "/sql/v1beta4/projects/{project}/instances/{instance}/failover",
                          request -> {
                            Map<String, String> fields = new HashMap<>();
                            ProtoRestSerializer<SqlInstancesFailoverRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putPathParam(fields, "instance", request.getInstance());
                            serializer.putPathParam(fields, "project", request.getProject());
                            return fields;
                          })
                      .setQueryParamsExtractor(
                          request -> {
                            Map<String, List<String>> fields = new HashMap<>();
                            ProtoRestSerializer<SqlInstancesFailoverRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putQueryParam(fields, "$alt", "json;enum-encoding=int");
                            return fields;
                          })
                      .setRequestBodyExtractor(
                          request ->
                              ProtoRestSerializer.create().toBody("body", request.getBody(), true))
                      .build())
              .setResponseParser(
                  ProtoMessageResponseParser.<Operation>newBuilder()
                      .setDefaultInstance(Operation.getDefaultInstance())
                      .setDefaultTypeRegistry(typeRegistry)
                      .build())
              .build();

  private static final ApiMethodDescriptor<SqlInstancesReencryptRequest, Operation>
      reencryptMethodDescriptor =
          ApiMethodDescriptor.<SqlInstancesReencryptRequest, Operation>newBuilder()
              .setFullMethodName("google.cloud.sql.v1beta4.SqlInstancesService/Reencrypt")
              .setHttpMethod("POST")
              .setType(ApiMethodDescriptor.MethodType.UNARY)
              .setRequestFormatter(
                  ProtoMessageRequestFormatter.<SqlInstancesReencryptRequest>newBuilder()
                      .setPath(
                          "/sql/v1beta4/projects/{project}/instances/{instance}/reencrypt",
                          request -> {
                            Map<String, String> fields = new HashMap<>();
                            ProtoRestSerializer<SqlInstancesReencryptRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putPathParam(fields, "instance", request.getInstance());
                            serializer.putPathParam(fields, "project", request.getProject());
                            return fields;
                          })
                      .setQueryParamsExtractor(
                          request -> {
                            Map<String, List<String>> fields = new HashMap<>();
                            ProtoRestSerializer<SqlInstancesReencryptRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putQueryParam(fields, "$alt", "json;enum-encoding=int");
                            return fields;
                          })
                      .setRequestBodyExtractor(
                          request ->
                              ProtoRestSerializer.create().toBody("body", request.getBody(), true))
                      .build())
              .setResponseParser(
                  ProtoMessageResponseParser.<Operation>newBuilder()
                      .setDefaultInstance(Operation.getDefaultInstance())
                      .setDefaultTypeRegistry(typeRegistry)
                      .build())
              .build();

  private static final ApiMethodDescriptor<SqlInstancesGetRequest, DatabaseInstance>
      getMethodDescriptor =
          ApiMethodDescriptor.<SqlInstancesGetRequest, DatabaseInstance>newBuilder()
              .setFullMethodName("google.cloud.sql.v1beta4.SqlInstancesService/Get")
              .setHttpMethod("GET")
              .setType(ApiMethodDescriptor.MethodType.UNARY)
              .setRequestFormatter(
                  ProtoMessageRequestFormatter.<SqlInstancesGetRequest>newBuilder()
                      .setPath(
                          "/sql/v1beta4/projects/{project}/instances/{instance}",
                          request -> {
                            Map<String, String> fields = new HashMap<>();
                            ProtoRestSerializer<SqlInstancesGetRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putPathParam(fields, "instance", request.getInstance());
                            serializer.putPathParam(fields, "project", request.getProject());
                            return fields;
                          })
                      .setQueryParamsExtractor(
                          request -> {
                            Map<String, List<String>> fields = new HashMap<>();
                            ProtoRestSerializer<SqlInstancesGetRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putQueryParam(fields, "$alt", "json;enum-encoding=int");
                            return fields;
                          })
                      .setRequestBodyExtractor(request -> null)
                      .build())
              .setResponseParser(
                  ProtoMessageResponseParser.<DatabaseInstance>newBuilder()
                      .setDefaultInstance(DatabaseInstance.getDefaultInstance())
                      .setDefaultTypeRegistry(typeRegistry)
                      .build())
              .build();

  private static final ApiMethodDescriptor<SqlInstancesImportRequest, Operation>
      import_MethodDescriptor =
          ApiMethodDescriptor.<SqlInstancesImportRequest, Operation>newBuilder()
              .setFullMethodName("google.cloud.sql.v1beta4.SqlInstancesService/Import")
              .setHttpMethod("POST")
              .setType(ApiMethodDescriptor.MethodType.UNARY)
              .setRequestFormatter(
                  ProtoMessageRequestFormatter.<SqlInstancesImportRequest>newBuilder()
                      .setPath(
                          "/sql/v1beta4/projects/{project}/instances/{instance}/import",
                          request -> {
                            Map<String, String> fields = new HashMap<>();
                            ProtoRestSerializer<SqlInstancesImportRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putPathParam(fields, "instance", request.getInstance());
                            serializer.putPathParam(fields, "project", request.getProject());
                            return fields;
                          })
                      .setQueryParamsExtractor(
                          request -> {
                            Map<String, List<String>> fields = new HashMap<>();
                            ProtoRestSerializer<SqlInstancesImportRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putQueryParam(fields, "$alt", "json;enum-encoding=int");
                            return fields;
                          })
                      .setRequestBodyExtractor(
                          request ->
                              ProtoRestSerializer.create().toBody("body", request.getBody(), true))
                      .build())
              .setResponseParser(
                  ProtoMessageResponseParser.<Operation>newBuilder()
                      .setDefaultInstance(Operation.getDefaultInstance())
                      .setDefaultTypeRegistry(typeRegistry)
                      .build())
              .build();

  private static final ApiMethodDescriptor<SqlInstancesInsertRequest, Operation>
      insertMethodDescriptor =
          ApiMethodDescriptor.<SqlInstancesInsertRequest, Operation>newBuilder()
              .setFullMethodName("google.cloud.sql.v1beta4.SqlInstancesService/Insert")
              .setHttpMethod("POST")
              .setType(ApiMethodDescriptor.MethodType.UNARY)
              .setRequestFormatter(
                  ProtoMessageRequestFormatter.<SqlInstancesInsertRequest>newBuilder()
                      .setPath(
                          "/sql/v1beta4/projects/{project}/instances",
                          request -> {
                            Map<String, String> fields = new HashMap<>();
                            ProtoRestSerializer<SqlInstancesInsertRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putPathParam(fields, "project", request.getProject());
                            return fields;
                          })
                      .setQueryParamsExtractor(
                          request -> {
                            Map<String, List<String>> fields = new HashMap<>();
                            ProtoRestSerializer<SqlInstancesInsertRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putQueryParam(fields, "$alt", "json;enum-encoding=int");
                            return fields;
                          })
                      .setRequestBodyExtractor(
                          request ->
                              ProtoRestSerializer.create().toBody("body", request.getBody(), true))
                      .build())
              .setResponseParser(
                  ProtoMessageResponseParser.<Operation>newBuilder()
                      .setDefaultInstance(Operation.getDefaultInstance())
                      .setDefaultTypeRegistry(typeRegistry)
                      .build())
              .build();

  private static final ApiMethodDescriptor<SqlInstancesListRequest, InstancesListResponse>
      listMethodDescriptor =
          ApiMethodDescriptor.<SqlInstancesListRequest, InstancesListResponse>newBuilder()
              .setFullMethodName("google.cloud.sql.v1beta4.SqlInstancesService/List")
              .setHttpMethod("GET")
              .setType(ApiMethodDescriptor.MethodType.UNARY)
              .setRequestFormatter(
                  ProtoMessageRequestFormatter.<SqlInstancesListRequest>newBuilder()
                      .setPath(
                          "/sql/v1beta4/projects/{project}/instances",
                          request -> {
                            Map<String, String> fields = new HashMap<>();
                            ProtoRestSerializer<SqlInstancesListRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putPathParam(fields, "project", request.getProject());
                            return fields;
                          })
                      .setQueryParamsExtractor(
                          request -> {
                            Map<String, List<String>> fields = new HashMap<>();
                            ProtoRestSerializer<SqlInstancesListRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putQueryParam(fields, "filter", request.getFilter());
                            serializer.putQueryParam(fields, "maxResults", request.getMaxResults());
                            serializer.putQueryParam(fields, "pageToken", request.getPageToken());
                            serializer.putQueryParam(fields, "$alt", "json;enum-encoding=int");
                            return fields;
                          })
                      .setRequestBodyExtractor(request -> null)
                      .build())
              .setResponseParser(
                  ProtoMessageResponseParser.<InstancesListResponse>newBuilder()
                      .setDefaultInstance(InstancesListResponse.getDefaultInstance())
                      .setDefaultTypeRegistry(typeRegistry)
                      .build())
              .build();

  private static final ApiMethodDescriptor<
          SqlInstancesListServerCasRequest, InstancesListServerCasResponse>
      listServerCasMethodDescriptor =
          ApiMethodDescriptor
              .<SqlInstancesListServerCasRequest, InstancesListServerCasResponse>newBuilder()
              .setFullMethodName("google.cloud.sql.v1beta4.SqlInstancesService/ListServerCas")
              .setHttpMethod("GET")
              .setType(ApiMethodDescriptor.MethodType.UNARY)
              .setRequestFormatter(
                  ProtoMessageRequestFormatter.<SqlInstancesListServerCasRequest>newBuilder()
                      .setPath(
                          "/sql/v1beta4/projects/{project}/instances/{instance}/listServerCas",
                          request -> {
                            Map<String, String> fields = new HashMap<>();
                            ProtoRestSerializer<SqlInstancesListServerCasRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putPathParam(fields, "instance", request.getInstance());
                            serializer.putPathParam(fields, "project", request.getProject());
                            return fields;
                          })
                      .setQueryParamsExtractor(
                          request -> {
                            Map<String, List<String>> fields = new HashMap<>();
                            ProtoRestSerializer<SqlInstancesListServerCasRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putQueryParam(fields, "$alt", "json;enum-encoding=int");
                            return fields;
                          })
                      .setRequestBodyExtractor(request -> null)
                      .build())
              .setResponseParser(
                  ProtoMessageResponseParser.<InstancesListServerCasResponse>newBuilder()
                      .setDefaultInstance(InstancesListServerCasResponse.getDefaultInstance())
                      .setDefaultTypeRegistry(typeRegistry)
                      .build())
              .build();

  private static final ApiMethodDescriptor<
          SqlInstancesListServerCertificatesRequest, InstancesListServerCertificatesResponse>
      listServerCertificatesMethodDescriptor =
          ApiMethodDescriptor
              .<SqlInstancesListServerCertificatesRequest, InstancesListServerCertificatesResponse>
                  newBuilder()
              .setFullMethodName(
                  "google.cloud.sql.v1beta4.SqlInstancesService/ListServerCertificates")
              .setHttpMethod("GET")
              .setType(ApiMethodDescriptor.MethodType.UNARY)
              .setRequestFormatter(
                  ProtoMessageRequestFormatter
                      .<SqlInstancesListServerCertificatesRequest>newBuilder()
                      .setPath(
                          "/sql/v1beta4/projects/{project}/instances/{instance}/listServerCertificates",
                          request -> {
                            Map<String, String> fields = new HashMap<>();
                            ProtoRestSerializer<SqlInstancesListServerCertificatesRequest>
                                serializer = ProtoRestSerializer.create();
                            serializer.putPathParam(fields, "instance", request.getInstance());
                            serializer.putPathParam(fields, "project", request.getProject());
                            return fields;
                          })
                      .setQueryParamsExtractor(
                          request -> {
                            Map<String, List<String>> fields = new HashMap<>();
                            ProtoRestSerializer<SqlInstancesListServerCertificatesRequest>
                                serializer = ProtoRestSerializer.create();
                            serializer.putQueryParam(fields, "$alt", "json;enum-encoding=int");
                            return fields;
                          })
                      .setRequestBodyExtractor(request -> null)
                      .build())
              .setResponseParser(
                  ProtoMessageResponseParser.<InstancesListServerCertificatesResponse>newBuilder()
                      .setDefaultInstance(
                          InstancesListServerCertificatesResponse.getDefaultInstance())
                      .setDefaultTypeRegistry(typeRegistry)
                      .build())
              .build();

  private static final ApiMethodDescriptor<
          SqlInstancesListEntraIdCertificatesRequest, InstancesListEntraIdCertificatesResponse>
      listEntraIdCertificatesMethodDescriptor =
          ApiMethodDescriptor
              .<SqlInstancesListEntraIdCertificatesRequest,
                  InstancesListEntraIdCertificatesResponse>
                  newBuilder()
              .setFullMethodName(
                  "google.cloud.sql.v1beta4.SqlInstancesService/ListEntraIdCertificates")
              .setHttpMethod("GET")
              .setType(ApiMethodDescriptor.MethodType.UNARY)
              .setRequestFormatter(
                  ProtoMessageRequestFormatter
                      .<SqlInstancesListEntraIdCertificatesRequest>newBuilder()
                      .setPath(
                          "/sql/v1beta4/projects/{project}/instances/{instance}/listEntraIdCertificates",
                          request -> {
                            Map<String, String> fields = new HashMap<>();
                            ProtoRestSerializer<SqlInstancesListEntraIdCertificatesRequest>
                                serializer = ProtoRestSerializer.create();
                            serializer.putPathParam(fields, "instance", request.getInstance());
                            serializer.putPathParam(fields, "project", request.getProject());
                            return fields;
                          })
                      .setQueryParamsExtractor(
                          request -> {
                            Map<String, List<String>> fields = new HashMap<>();
                            ProtoRestSerializer<SqlInstancesListEntraIdCertificatesRequest>
                                serializer = ProtoRestSerializer.create();
                            serializer.putQueryParam(fields, "$alt", "json;enum-encoding=int");
                            return fields;
                          })
                      .setRequestBodyExtractor(request -> null)
                      .build())
              .setResponseParser(
                  ProtoMessageResponseParser.<InstancesListEntraIdCertificatesResponse>newBuilder()
                      .setDefaultInstance(
                          InstancesListEntraIdCertificatesResponse.getDefaultInstance())
                      .setDefaultTypeRegistry(typeRegistry)
                      .build())
              .build();

  private static final ApiMethodDescriptor<SqlInstancesPatchRequest, Operation>
      patchMethodDescriptor =
          ApiMethodDescriptor.<SqlInstancesPatchRequest, Operation>newBuilder()
              .setFullMethodName("google.cloud.sql.v1beta4.SqlInstancesService/Patch")
              .setHttpMethod("PATCH")
              .setType(ApiMethodDescriptor.MethodType.UNARY)
              .setRequestFormatter(
                  ProtoMessageRequestFormatter.<SqlInstancesPatchRequest>newBuilder()
                      .setPath(
                          "/sql/v1beta4/projects/{project}/instances/{instance}",
                          request -> {
                            Map<String, String> fields = new HashMap<>();
                            ProtoRestSerializer<SqlInstancesPatchRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putPathParam(fields, "instance", request.getInstance());
                            serializer.putPathParam(fields, "project", request.getProject());
                            return fields;
                          })
                      .setQueryParamsExtractor(
                          request -> {
                            Map<String, List<String>> fields = new HashMap<>();
                            ProtoRestSerializer<SqlInstancesPatchRequest> serializer =
                                ProtoRestSerializer.create();
                            if (request.hasReconcilePscNetworking()) {
                              serializer.putQueryParam(
                                  fields,
                                  "reconcilePscNetworking",
                                  request.getReconcilePscNetworking());
                            }
                            if (request.hasReconcilePscNetworkingForce()) {
                              serializer.putQueryParam(
                                  fields,
                                  "reconcilePscNetworkingForce",
                                  request.getReconcilePscNetworkingForce());
                            }
                            serializer.putQueryParam(fields, "$alt", "json;enum-encoding=int");
                            return fields;
                          })
                      .setRequestBodyExtractor(
                          request ->
                              ProtoRestSerializer.create().toBody("body", request.getBody(), true))
                      .build())
              .setResponseParser(
                  ProtoMessageResponseParser.<Operation>newBuilder()
                      .setDefaultInstance(Operation.getDefaultInstance())
                      .setDefaultTypeRegistry(typeRegistry)
                      .build())
              .build();

  private static final ApiMethodDescriptor<SqlInstancesPromoteReplicaRequest, Operation>
      promoteReplicaMethodDescriptor =
          ApiMethodDescriptor.<SqlInstancesPromoteReplicaRequest, Operation>newBuilder()
              .setFullMethodName("google.cloud.sql.v1beta4.SqlInstancesService/PromoteReplica")
              .setHttpMethod("POST")
              .setType(ApiMethodDescriptor.MethodType.UNARY)
              .setRequestFormatter(
                  ProtoMessageRequestFormatter.<SqlInstancesPromoteReplicaRequest>newBuilder()
                      .setPath(
                          "/sql/v1beta4/projects/{project}/instances/{instance}/promoteReplica",
                          request -> {
                            Map<String, String> fields = new HashMap<>();
                            ProtoRestSerializer<SqlInstancesPromoteReplicaRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putPathParam(fields, "instance", request.getInstance());
                            serializer.putPathParam(fields, "project", request.getProject());
                            return fields;
                          })
                      .setQueryParamsExtractor(
                          request -> {
                            Map<String, List<String>> fields = new HashMap<>();
                            ProtoRestSerializer<SqlInstancesPromoteReplicaRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putQueryParam(fields, "failover", request.getFailover());
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
              .build();

  private static final ApiMethodDescriptor<SqlInstancesSwitchoverRequest, Operation>
      switchoverMethodDescriptor =
          ApiMethodDescriptor.<SqlInstancesSwitchoverRequest, Operation>newBuilder()
              .setFullMethodName("google.cloud.sql.v1beta4.SqlInstancesService/Switchover")
              .setHttpMethod("POST")
              .setType(ApiMethodDescriptor.MethodType.UNARY)
              .setRequestFormatter(
                  ProtoMessageRequestFormatter.<SqlInstancesSwitchoverRequest>newBuilder()
                      .setPath(
                          "/sql/v1beta4/projects/{project}/instances/{instance}/switchover",
                          request -> {
                            Map<String, String> fields = new HashMap<>();
                            ProtoRestSerializer<SqlInstancesSwitchoverRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putPathParam(fields, "instance", request.getInstance());
                            serializer.putPathParam(fields, "project", request.getProject());
                            return fields;
                          })
                      .setQueryParamsExtractor(
                          request -> {
                            Map<String, List<String>> fields = new HashMap<>();
                            ProtoRestSerializer<SqlInstancesSwitchoverRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putQueryParam(fields, "dbTimeout", request.getDbTimeout());
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
              .build();

  private static final ApiMethodDescriptor<SqlInstancesResetSslConfigRequest, Operation>
      resetSslConfigMethodDescriptor =
          ApiMethodDescriptor.<SqlInstancesResetSslConfigRequest, Operation>newBuilder()
              .setFullMethodName("google.cloud.sql.v1beta4.SqlInstancesService/ResetSslConfig")
              .setHttpMethod("POST")
              .setType(ApiMethodDescriptor.MethodType.UNARY)
              .setRequestFormatter(
                  ProtoMessageRequestFormatter.<SqlInstancesResetSslConfigRequest>newBuilder()
                      .setPath(
                          "/sql/v1beta4/projects/{project}/instances/{instance}/resetSslConfig",
                          request -> {
                            Map<String, String> fields = new HashMap<>();
                            ProtoRestSerializer<SqlInstancesResetSslConfigRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putPathParam(fields, "instance", request.getInstance());
                            serializer.putPathParam(fields, "project", request.getProject());
                            return fields;
                          })
                      .setQueryParamsExtractor(
                          request -> {
                            Map<String, List<String>> fields = new HashMap<>();
                            ProtoRestSerializer<SqlInstancesResetSslConfigRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putQueryParam(fields, "mode", request.getModeValue());
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
              .build();

  private static final ApiMethodDescriptor<SqlInstancesRestartRequest, Operation>
      restartMethodDescriptor =
          ApiMethodDescriptor.<SqlInstancesRestartRequest, Operation>newBuilder()
              .setFullMethodName("google.cloud.sql.v1beta4.SqlInstancesService/Restart")
              .setHttpMethod("POST")
              .setType(ApiMethodDescriptor.MethodType.UNARY)
              .setRequestFormatter(
                  ProtoMessageRequestFormatter.<SqlInstancesRestartRequest>newBuilder()
                      .setPath(
                          "/sql/v1beta4/projects/{project}/instances/{instance}/restart",
                          request -> {
                            Map<String, String> fields = new HashMap<>();
                            ProtoRestSerializer<SqlInstancesRestartRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putPathParam(fields, "instance", request.getInstance());
                            serializer.putPathParam(fields, "project", request.getProject());
                            return fields;
                          })
                      .setQueryParamsExtractor(
                          request -> {
                            Map<String, List<String>> fields = new HashMap<>();
                            ProtoRestSerializer<SqlInstancesRestartRequest> serializer =
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
              .build();

  private static final ApiMethodDescriptor<SqlInstancesRestoreBackupRequest, Operation>
      restoreBackupMethodDescriptor =
          ApiMethodDescriptor.<SqlInstancesRestoreBackupRequest, Operation>newBuilder()
              .setFullMethodName("google.cloud.sql.v1beta4.SqlInstancesService/RestoreBackup")
              .setHttpMethod("POST")
              .setType(ApiMethodDescriptor.MethodType.UNARY)
              .setRequestFormatter(
                  ProtoMessageRequestFormatter.<SqlInstancesRestoreBackupRequest>newBuilder()
                      .setPath(
                          "/sql/v1beta4/projects/{project}/instances/{instance}/restoreBackup",
                          request -> {
                            Map<String, String> fields = new HashMap<>();
                            ProtoRestSerializer<SqlInstancesRestoreBackupRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putPathParam(fields, "instance", request.getInstance());
                            serializer.putPathParam(fields, "project", request.getProject());
                            return fields;
                          })
                      .setQueryParamsExtractor(
                          request -> {
                            Map<String, List<String>> fields = new HashMap<>();
                            ProtoRestSerializer<SqlInstancesRestoreBackupRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putQueryParam(fields, "$alt", "json;enum-encoding=int");
                            return fields;
                          })
                      .setRequestBodyExtractor(
                          request ->
                              ProtoRestSerializer.create().toBody("body", request.getBody(), true))
                      .build())
              .setResponseParser(
                  ProtoMessageResponseParser.<Operation>newBuilder()
                      .setDefaultInstance(Operation.getDefaultInstance())
                      .setDefaultTypeRegistry(typeRegistry)
                      .build())
              .build();

  private static final ApiMethodDescriptor<SqlInstancesRotateServerCaRequest, Operation>
      rotateServerCaMethodDescriptor =
          ApiMethodDescriptor.<SqlInstancesRotateServerCaRequest, Operation>newBuilder()
              .setFullMethodName("google.cloud.sql.v1beta4.SqlInstancesService/RotateServerCa")
              .setHttpMethod("POST")
              .setType(ApiMethodDescriptor.MethodType.UNARY)
              .setRequestFormatter(
                  ProtoMessageRequestFormatter.<SqlInstancesRotateServerCaRequest>newBuilder()
                      .setPath(
                          "/sql/v1beta4/projects/{project}/instances/{instance}/rotateServerCa",
                          request -> {
                            Map<String, String> fields = new HashMap<>();
                            ProtoRestSerializer<SqlInstancesRotateServerCaRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putPathParam(fields, "instance", request.getInstance());
                            serializer.putPathParam(fields, "project", request.getProject());
                            return fields;
                          })
                      .setQueryParamsExtractor(
                          request -> {
                            Map<String, List<String>> fields = new HashMap<>();
                            ProtoRestSerializer<SqlInstancesRotateServerCaRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putQueryParam(fields, "$alt", "json;enum-encoding=int");
                            return fields;
                          })
                      .setRequestBodyExtractor(
                          request ->
                              ProtoRestSerializer.create().toBody("body", request.getBody(), true))
                      .build())
              .setResponseParser(
                  ProtoMessageResponseParser.<Operation>newBuilder()
                      .setDefaultInstance(Operation.getDefaultInstance())
                      .setDefaultTypeRegistry(typeRegistry)
                      .build())
              .build();

  private static final ApiMethodDescriptor<SqlInstancesRotateServerCertificateRequest, Operation>
      rotateServerCertificateMethodDescriptor =
          ApiMethodDescriptor.<SqlInstancesRotateServerCertificateRequest, Operation>newBuilder()
              .setFullMethodName(
                  "google.cloud.sql.v1beta4.SqlInstancesService/RotateServerCertificate")
              .setHttpMethod("POST")
              .setType(ApiMethodDescriptor.MethodType.UNARY)
              .setRequestFormatter(
                  ProtoMessageRequestFormatter
                      .<SqlInstancesRotateServerCertificateRequest>newBuilder()
                      .setPath(
                          "/sql/v1beta4/projects/{project}/instances/{instance}/rotateServerCertificate",
                          request -> {
                            Map<String, String> fields = new HashMap<>();
                            ProtoRestSerializer<SqlInstancesRotateServerCertificateRequest>
                                serializer = ProtoRestSerializer.create();
                            serializer.putPathParam(fields, "instance", request.getInstance());
                            serializer.putPathParam(fields, "project", request.getProject());
                            return fields;
                          })
                      .setQueryParamsExtractor(
                          request -> {
                            Map<String, List<String>> fields = new HashMap<>();
                            ProtoRestSerializer<SqlInstancesRotateServerCertificateRequest>
                                serializer = ProtoRestSerializer.create();
                            serializer.putQueryParam(fields, "$alt", "json;enum-encoding=int");
                            return fields;
                          })
                      .setRequestBodyExtractor(
                          request ->
                              ProtoRestSerializer.create().toBody("body", request.getBody(), true))
                      .build())
              .setResponseParser(
                  ProtoMessageResponseParser.<Operation>newBuilder()
                      .setDefaultInstance(Operation.getDefaultInstance())
                      .setDefaultTypeRegistry(typeRegistry)
                      .build())
              .build();

  private static final ApiMethodDescriptor<SqlInstancesRotateEntraIdCertificateRequest, Operation>
      rotateEntraIdCertificateMethodDescriptor =
          ApiMethodDescriptor.<SqlInstancesRotateEntraIdCertificateRequest, Operation>newBuilder()
              .setFullMethodName(
                  "google.cloud.sql.v1beta4.SqlInstancesService/RotateEntraIdCertificate")
              .setHttpMethod("POST")
              .setType(ApiMethodDescriptor.MethodType.UNARY)
              .setRequestFormatter(
                  ProtoMessageRequestFormatter
                      .<SqlInstancesRotateEntraIdCertificateRequest>newBuilder()
                      .setPath(
                          "/sql/v1beta4/projects/{project}/instances/{instance}/rotateEntraIdCertificate",
                          request -> {
                            Map<String, String> fields = new HashMap<>();
                            ProtoRestSerializer<SqlInstancesRotateEntraIdCertificateRequest>
                                serializer = ProtoRestSerializer.create();
                            serializer.putPathParam(fields, "instance", request.getInstance());
                            serializer.putPathParam(fields, "project", request.getProject());
                            return fields;
                          })
                      .setQueryParamsExtractor(
                          request -> {
                            Map<String, List<String>> fields = new HashMap<>();
                            ProtoRestSerializer<SqlInstancesRotateEntraIdCertificateRequest>
                                serializer = ProtoRestSerializer.create();
                            serializer.putQueryParam(fields, "$alt", "json;enum-encoding=int");
                            return fields;
                          })
                      .setRequestBodyExtractor(
                          request ->
                              ProtoRestSerializer.create().toBody("body", request.getBody(), true))
                      .build())
              .setResponseParser(
                  ProtoMessageResponseParser.<Operation>newBuilder()
                      .setDefaultInstance(Operation.getDefaultInstance())
                      .setDefaultTypeRegistry(typeRegistry)
                      .build())
              .build();

  private static final ApiMethodDescriptor<SqlInstancesStartReplicaRequest, Operation>
      startReplicaMethodDescriptor =
          ApiMethodDescriptor.<SqlInstancesStartReplicaRequest, Operation>newBuilder()
              .setFullMethodName("google.cloud.sql.v1beta4.SqlInstancesService/StartReplica")
              .setHttpMethod("POST")
              .setType(ApiMethodDescriptor.MethodType.UNARY)
              .setRequestFormatter(
                  ProtoMessageRequestFormatter.<SqlInstancesStartReplicaRequest>newBuilder()
                      .setPath(
                          "/sql/v1beta4/projects/{project}/instances/{instance}/startReplica",
                          request -> {
                            Map<String, String> fields = new HashMap<>();
                            ProtoRestSerializer<SqlInstancesStartReplicaRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putPathParam(fields, "instance", request.getInstance());
                            serializer.putPathParam(fields, "project", request.getProject());
                            return fields;
                          })
                      .setQueryParamsExtractor(
                          request -> {
                            Map<String, List<String>> fields = new HashMap<>();
                            ProtoRestSerializer<SqlInstancesStartReplicaRequest> serializer =
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
              .build();

  private static final ApiMethodDescriptor<SqlInstancesStopReplicaRequest, Operation>
      stopReplicaMethodDescriptor =
          ApiMethodDescriptor.<SqlInstancesStopReplicaRequest, Operation>newBuilder()
              .setFullMethodName("google.cloud.sql.v1beta4.SqlInstancesService/StopReplica")
              .setHttpMethod("POST")
              .setType(ApiMethodDescriptor.MethodType.UNARY)
              .setRequestFormatter(
                  ProtoMessageRequestFormatter.<SqlInstancesStopReplicaRequest>newBuilder()
                      .setPath(
                          "/sql/v1beta4/projects/{project}/instances/{instance}/stopReplica",
                          request -> {
                            Map<String, String> fields = new HashMap<>();
                            ProtoRestSerializer<SqlInstancesStopReplicaRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putPathParam(fields, "instance", request.getInstance());
                            serializer.putPathParam(fields, "project", request.getProject());
                            return fields;
                          })
                      .setQueryParamsExtractor(
                          request -> {
                            Map<String, List<String>> fields = new HashMap<>();
                            ProtoRestSerializer<SqlInstancesStopReplicaRequest> serializer =
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
              .build();

  private static final ApiMethodDescriptor<SqlInstancesTruncateLogRequest, Operation>
      truncateLogMethodDescriptor =
          ApiMethodDescriptor.<SqlInstancesTruncateLogRequest, Operation>newBuilder()
              .setFullMethodName("google.cloud.sql.v1beta4.SqlInstancesService/TruncateLog")
              .setHttpMethod("POST")
              .setType(ApiMethodDescriptor.MethodType.UNARY)
              .setRequestFormatter(
                  ProtoMessageRequestFormatter.<SqlInstancesTruncateLogRequest>newBuilder()
                      .setPath(
                          "/sql/v1beta4/projects/{project}/instances/{instance}/truncateLog",
                          request -> {
                            Map<String, String> fields = new HashMap<>();
                            ProtoRestSerializer<SqlInstancesTruncateLogRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putPathParam(fields, "instance", request.getInstance());
                            serializer.putPathParam(fields, "project", request.getProject());
                            return fields;
                          })
                      .setQueryParamsExtractor(
                          request -> {
                            Map<String, List<String>> fields = new HashMap<>();
                            ProtoRestSerializer<SqlInstancesTruncateLogRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putQueryParam(fields, "$alt", "json;enum-encoding=int");
                            return fields;
                          })
                      .setRequestBodyExtractor(
                          request ->
                              ProtoRestSerializer.create().toBody("body", request.getBody(), true))
                      .build())
              .setResponseParser(
                  ProtoMessageResponseParser.<Operation>newBuilder()
                      .setDefaultInstance(Operation.getDefaultInstance())
                      .setDefaultTypeRegistry(typeRegistry)
                      .build())
              .build();

  private static final ApiMethodDescriptor<SqlInstancesUpdateRequest, Operation>
      updateMethodDescriptor =
          ApiMethodDescriptor.<SqlInstancesUpdateRequest, Operation>newBuilder()
              .setFullMethodName("google.cloud.sql.v1beta4.SqlInstancesService/Update")
              .setHttpMethod("PUT")
              .setType(ApiMethodDescriptor.MethodType.UNARY)
              .setRequestFormatter(
                  ProtoMessageRequestFormatter.<SqlInstancesUpdateRequest>newBuilder()
                      .setPath(
                          "/sql/v1beta4/projects/{project}/instances/{instance}",
                          request -> {
                            Map<String, String> fields = new HashMap<>();
                            ProtoRestSerializer<SqlInstancesUpdateRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putPathParam(fields, "instance", request.getInstance());
                            serializer.putPathParam(fields, "project", request.getProject());
                            return fields;
                          })
                      .setQueryParamsExtractor(
                          request -> {
                            Map<String, List<String>> fields = new HashMap<>();
                            ProtoRestSerializer<SqlInstancesUpdateRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putQueryParam(fields, "$alt", "json;enum-encoding=int");
                            return fields;
                          })
                      .setRequestBodyExtractor(
                          request ->
                              ProtoRestSerializer.create().toBody("body", request.getBody(), true))
                      .build())
              .setResponseParser(
                  ProtoMessageResponseParser.<Operation>newBuilder()
                      .setDefaultInstance(Operation.getDefaultInstance())
                      .setDefaultTypeRegistry(typeRegistry)
                      .build())
              .build();

  private static final ApiMethodDescriptor<SqlInstancesCreateEphemeralCertRequest, SslCert>
      createEphemeralMethodDescriptor =
          ApiMethodDescriptor.<SqlInstancesCreateEphemeralCertRequest, SslCert>newBuilder()
              .setFullMethodName("google.cloud.sql.v1beta4.SqlInstancesService/CreateEphemeral")
              .setHttpMethod("POST")
              .setType(ApiMethodDescriptor.MethodType.UNARY)
              .setRequestFormatter(
                  ProtoMessageRequestFormatter.<SqlInstancesCreateEphemeralCertRequest>newBuilder()
                      .setPath(
                          "/sql/v1beta4/projects/{project}/instances/{instance}/createEphemeral",
                          request -> {
                            Map<String, String> fields = new HashMap<>();
                            ProtoRestSerializer<SqlInstancesCreateEphemeralCertRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putPathParam(fields, "instance", request.getInstance());
                            serializer.putPathParam(fields, "project", request.getProject());
                            return fields;
                          })
                      .setQueryParamsExtractor(
                          request -> {
                            Map<String, List<String>> fields = new HashMap<>();
                            ProtoRestSerializer<SqlInstancesCreateEphemeralCertRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putQueryParam(fields, "$alt", "json;enum-encoding=int");
                            return fields;
                          })
                      .setRequestBodyExtractor(
                          request ->
                              ProtoRestSerializer.create().toBody("body", request.getBody(), true))
                      .build())
              .setResponseParser(
                  ProtoMessageResponseParser.<SslCert>newBuilder()
                      .setDefaultInstance(SslCert.getDefaultInstance())
                      .setDefaultTypeRegistry(typeRegistry)
                      .build())
              .build();

  private static final ApiMethodDescriptor<SqlInstancesRescheduleMaintenanceRequest, Operation>
      rescheduleMaintenanceMethodDescriptor =
          ApiMethodDescriptor.<SqlInstancesRescheduleMaintenanceRequest, Operation>newBuilder()
              .setFullMethodName(
                  "google.cloud.sql.v1beta4.SqlInstancesService/RescheduleMaintenance")
              .setHttpMethod("POST")
              .setType(ApiMethodDescriptor.MethodType.UNARY)
              .setRequestFormatter(
                  ProtoMessageRequestFormatter
                      .<SqlInstancesRescheduleMaintenanceRequest>newBuilder()
                      .setPath(
                          "/sql/v1beta4/projects/{project}/instances/{instance}/rescheduleMaintenance",
                          request -> {
                            Map<String, String> fields = new HashMap<>();
                            ProtoRestSerializer<SqlInstancesRescheduleMaintenanceRequest>
                                serializer = ProtoRestSerializer.create();
                            serializer.putPathParam(fields, "instance", request.getInstance());
                            serializer.putPathParam(fields, "project", request.getProject());
                            return fields;
                          })
                      .setQueryParamsExtractor(
                          request -> {
                            Map<String, List<String>> fields = new HashMap<>();
                            ProtoRestSerializer<SqlInstancesRescheduleMaintenanceRequest>
                                serializer = ProtoRestSerializer.create();
                            serializer.putQueryParam(fields, "$alt", "json;enum-encoding=int");
                            return fields;
                          })
                      .setRequestBodyExtractor(
                          request ->
                              ProtoRestSerializer.create().toBody("body", request.getBody(), true))
                      .build())
              .setResponseParser(
                  ProtoMessageResponseParser.<Operation>newBuilder()
                      .setDefaultInstance(Operation.getDefaultInstance())
                      .setDefaultTypeRegistry(typeRegistry)
                      .build())
              .build();

  private static final ApiMethodDescriptor<
          SqlInstancesVerifyExternalSyncSettingsRequest,
          SqlInstancesVerifyExternalSyncSettingsResponse>
      verifyExternalSyncSettingsMethodDescriptor =
          ApiMethodDescriptor
              .<SqlInstancesVerifyExternalSyncSettingsRequest,
                  SqlInstancesVerifyExternalSyncSettingsResponse>
                  newBuilder()
              .setFullMethodName(
                  "google.cloud.sql.v1beta4.SqlInstancesService/VerifyExternalSyncSettings")
              .setHttpMethod("POST")
              .setType(ApiMethodDescriptor.MethodType.UNARY)
              .setRequestFormatter(
                  ProtoMessageRequestFormatter
                      .<SqlInstancesVerifyExternalSyncSettingsRequest>newBuilder()
                      .setPath(
                          "/sql/v1beta4/projects/{project}/instances/{instance}/verifyExternalSyncSettings",
                          request -> {
                            Map<String, String> fields = new HashMap<>();
                            ProtoRestSerializer<SqlInstancesVerifyExternalSyncSettingsRequest>
                                serializer = ProtoRestSerializer.create();
                            serializer.putPathParam(fields, "instance", request.getInstance());
                            serializer.putPathParam(fields, "project", request.getProject());
                            return fields;
                          })
                      .setQueryParamsExtractor(
                          request -> {
                            Map<String, List<String>> fields = new HashMap<>();
                            ProtoRestSerializer<SqlInstancesVerifyExternalSyncSettingsRequest>
                                serializer = ProtoRestSerializer.create();
                            serializer.putQueryParam(fields, "$alt", "json;enum-encoding=int");
                            return fields;
                          })
                      .setRequestBodyExtractor(
                          request ->
                              ProtoRestSerializer.create()
                                  .toBody(
                                      "*",
                                      request.toBuilder().clearInstance().clearProject().build(),
                                      true))
                      .build())
              .setResponseParser(
                  ProtoMessageResponseParser
                      .<SqlInstancesVerifyExternalSyncSettingsResponse>newBuilder()
                      .setDefaultInstance(
                          SqlInstancesVerifyExternalSyncSettingsResponse.getDefaultInstance())
                      .setDefaultTypeRegistry(typeRegistry)
                      .build())
              .build();

  private static final ApiMethodDescriptor<SqlInstancesStartExternalSyncRequest, Operation>
      startExternalSyncMethodDescriptor =
          ApiMethodDescriptor.<SqlInstancesStartExternalSyncRequest, Operation>newBuilder()
              .setFullMethodName("google.cloud.sql.v1beta4.SqlInstancesService/StartExternalSync")
              .setHttpMethod("POST")
              .setType(ApiMethodDescriptor.MethodType.UNARY)
              .setRequestFormatter(
                  ProtoMessageRequestFormatter.<SqlInstancesStartExternalSyncRequest>newBuilder()
                      .setPath(
                          "/sql/v1beta4/projects/{project}/instances/{instance}/startExternalSync",
                          request -> {
                            Map<String, String> fields = new HashMap<>();
                            ProtoRestSerializer<SqlInstancesStartExternalSyncRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putPathParam(fields, "instance", request.getInstance());
                            serializer.putPathParam(fields, "project", request.getProject());
                            return fields;
                          })
                      .setQueryParamsExtractor(
                          request -> {
                            Map<String, List<String>> fields = new HashMap<>();
                            ProtoRestSerializer<SqlInstancesStartExternalSyncRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putQueryParam(fields, "$alt", "json;enum-encoding=int");
                            return fields;
                          })
                      .setRequestBodyExtractor(
                          request ->
                              ProtoRestSerializer.create()
                                  .toBody(
                                      "*",
                                      request.toBuilder().clearInstance().clearProject().build(),
                                      true))
                      .build())
              .setResponseParser(
                  ProtoMessageResponseParser.<Operation>newBuilder()
                      .setDefaultInstance(Operation.getDefaultInstance())
                      .setDefaultTypeRegistry(typeRegistry)
                      .build())
              .build();

  private static final ApiMethodDescriptor<SqlInstancesPerformDiskShrinkRequest, Operation>
      performDiskShrinkMethodDescriptor =
          ApiMethodDescriptor.<SqlInstancesPerformDiskShrinkRequest, Operation>newBuilder()
              .setFullMethodName("google.cloud.sql.v1beta4.SqlInstancesService/PerformDiskShrink")
              .setHttpMethod("POST")
              .setType(ApiMethodDescriptor.MethodType.UNARY)
              .setRequestFormatter(
                  ProtoMessageRequestFormatter.<SqlInstancesPerformDiskShrinkRequest>newBuilder()
                      .setPath(
                          "/sql/v1beta4/projects/{project}/instances/{instance}/performDiskShrink",
                          request -> {
                            Map<String, String> fields = new HashMap<>();
                            ProtoRestSerializer<SqlInstancesPerformDiskShrinkRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putPathParam(fields, "instance", request.getInstance());
                            serializer.putPathParam(fields, "project", request.getProject());
                            return fields;
                          })
                      .setQueryParamsExtractor(
                          request -> {
                            Map<String, List<String>> fields = new HashMap<>();
                            ProtoRestSerializer<SqlInstancesPerformDiskShrinkRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putQueryParam(fields, "$alt", "json;enum-encoding=int");
                            return fields;
                          })
                      .setRequestBodyExtractor(
                          request ->
                              ProtoRestSerializer.create().toBody("body", request.getBody(), true))
                      .build())
              .setResponseParser(
                  ProtoMessageResponseParser.<Operation>newBuilder()
                      .setDefaultInstance(Operation.getDefaultInstance())
                      .setDefaultTypeRegistry(typeRegistry)
                      .build())
              .build();

  private static final ApiMethodDescriptor<
          SqlInstancesGetDiskShrinkConfigRequest, SqlInstancesGetDiskShrinkConfigResponse>
      getDiskShrinkConfigMethodDescriptor =
          ApiMethodDescriptor
              .<SqlInstancesGetDiskShrinkConfigRequest, SqlInstancesGetDiskShrinkConfigResponse>
                  newBuilder()
              .setFullMethodName("google.cloud.sql.v1beta4.SqlInstancesService/GetDiskShrinkConfig")
              .setHttpMethod("GET")
              .setType(ApiMethodDescriptor.MethodType.UNARY)
              .setRequestFormatter(
                  ProtoMessageRequestFormatter.<SqlInstancesGetDiskShrinkConfigRequest>newBuilder()
                      .setPath(
                          "/sql/v1beta4/projects/{project}/instances/{instance}/getDiskShrinkConfig",
                          request -> {
                            Map<String, String> fields = new HashMap<>();
                            ProtoRestSerializer<SqlInstancesGetDiskShrinkConfigRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putPathParam(fields, "instance", request.getInstance());
                            serializer.putPathParam(fields, "project", request.getProject());
                            return fields;
                          })
                      .setQueryParamsExtractor(
                          request -> {
                            Map<String, List<String>> fields = new HashMap<>();
                            ProtoRestSerializer<SqlInstancesGetDiskShrinkConfigRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putQueryParam(fields, "$alt", "json;enum-encoding=int");
                            return fields;
                          })
                      .setRequestBodyExtractor(request -> null)
                      .build())
              .setResponseParser(
                  ProtoMessageResponseParser.<SqlInstancesGetDiskShrinkConfigResponse>newBuilder()
                      .setDefaultInstance(
                          SqlInstancesGetDiskShrinkConfigResponse.getDefaultInstance())
                      .setDefaultTypeRegistry(typeRegistry)
                      .build())
              .build();

  private static final ApiMethodDescriptor<SqlInstancesResetReplicaSizeRequest, Operation>
      resetReplicaSizeMethodDescriptor =
          ApiMethodDescriptor.<SqlInstancesResetReplicaSizeRequest, Operation>newBuilder()
              .setFullMethodName("google.cloud.sql.v1beta4.SqlInstancesService/ResetReplicaSize")
              .setHttpMethod("POST")
              .setType(ApiMethodDescriptor.MethodType.UNARY)
              .setRequestFormatter(
                  ProtoMessageRequestFormatter.<SqlInstancesResetReplicaSizeRequest>newBuilder()
                      .setPath(
                          "/sql/v1beta4/projects/{project}/instances/{instance}/resetReplicaSize",
                          request -> {
                            Map<String, String> fields = new HashMap<>();
                            ProtoRestSerializer<SqlInstancesResetReplicaSizeRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putPathParam(fields, "instance", request.getInstance());
                            serializer.putPathParam(fields, "project", request.getProject());
                            return fields;
                          })
                      .setQueryParamsExtractor(
                          request -> {
                            Map<String, List<String>> fields = new HashMap<>();
                            ProtoRestSerializer<SqlInstancesResetReplicaSizeRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putQueryParam(fields, "$alt", "json;enum-encoding=int");
                            return fields;
                          })
                      .setRequestBodyExtractor(
                          request ->
                              ProtoRestSerializer.create()
                                  .toBody(
                                      "*",
                                      request.toBuilder().clearInstance().clearProject().build(),
                                      true))
                      .build())
              .setResponseParser(
                  ProtoMessageResponseParser.<Operation>newBuilder()
                      .setDefaultInstance(Operation.getDefaultInstance())
                      .setDefaultTypeRegistry(typeRegistry)
                      .build())
              .build();

  private static final ApiMethodDescriptor<
          SqlInstancesGetLatestRecoveryTimeRequest, SqlInstancesGetLatestRecoveryTimeResponse>
      getLatestRecoveryTimeMethodDescriptor =
          ApiMethodDescriptor
              .<SqlInstancesGetLatestRecoveryTimeRequest, SqlInstancesGetLatestRecoveryTimeResponse>
                  newBuilder()
              .setFullMethodName(
                  "google.cloud.sql.v1beta4.SqlInstancesService/GetLatestRecoveryTime")
              .setHttpMethod("GET")
              .setType(ApiMethodDescriptor.MethodType.UNARY)
              .setRequestFormatter(
                  ProtoMessageRequestFormatter
                      .<SqlInstancesGetLatestRecoveryTimeRequest>newBuilder()
                      .setPath(
                          "/sql/v1beta4/projects/{project}/instances/{instance}/getLatestRecoveryTime",
                          request -> {
                            Map<String, String> fields = new HashMap<>();
                            ProtoRestSerializer<SqlInstancesGetLatestRecoveryTimeRequest>
                                serializer = ProtoRestSerializer.create();
                            serializer.putPathParam(fields, "instance", request.getInstance());
                            serializer.putPathParam(fields, "project", request.getProject());
                            return fields;
                          })
                      .setQueryParamsExtractor(
                          request -> {
                            Map<String, List<String>> fields = new HashMap<>();
                            ProtoRestSerializer<SqlInstancesGetLatestRecoveryTimeRequest>
                                serializer = ProtoRestSerializer.create();
                            if (request.hasSourceInstanceDeletionTime()) {
                              serializer.putQueryParam(
                                  fields,
                                  "sourceInstanceDeletionTime",
                                  request.getSourceInstanceDeletionTime());
                            }
                            serializer.putQueryParam(fields, "$alt", "json;enum-encoding=int");
                            return fields;
                          })
                      .setRequestBodyExtractor(request -> null)
                      .build())
              .setResponseParser(
                  ProtoMessageResponseParser.<SqlInstancesGetLatestRecoveryTimeResponse>newBuilder()
                      .setDefaultInstance(
                          SqlInstancesGetLatestRecoveryTimeResponse.getDefaultInstance())
                      .setDefaultTypeRegistry(typeRegistry)
                      .build())
              .build();

  private static final ApiMethodDescriptor<
          SqlInstancesExecuteSqlRequest, SqlInstancesExecuteSqlResponse>
      executeSqlMethodDescriptor =
          ApiMethodDescriptor
              .<SqlInstancesExecuteSqlRequest, SqlInstancesExecuteSqlResponse>newBuilder()
              .setFullMethodName("google.cloud.sql.v1beta4.SqlInstancesService/ExecuteSql")
              .setHttpMethod("POST")
              .setType(ApiMethodDescriptor.MethodType.UNARY)
              .setRequestFormatter(
                  ProtoMessageRequestFormatter.<SqlInstancesExecuteSqlRequest>newBuilder()
                      .setPath(
                          "/sql/v1beta4/projects/{project}/instances/{instance}/executeSql",
                          request -> {
                            Map<String, String> fields = new HashMap<>();
                            ProtoRestSerializer<SqlInstancesExecuteSqlRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putPathParam(fields, "instance", request.getInstance());
                            serializer.putPathParam(fields, "project", request.getProject());
                            return fields;
                          })
                      .setQueryParamsExtractor(
                          request -> {
                            Map<String, List<String>> fields = new HashMap<>();
                            ProtoRestSerializer<SqlInstancesExecuteSqlRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putQueryParam(fields, "$alt", "json;enum-encoding=int");
                            return fields;
                          })
                      .setRequestBodyExtractor(
                          request ->
                              ProtoRestSerializer.create().toBody("body", request.getBody(), true))
                      .build())
              .setResponseParser(
                  ProtoMessageResponseParser.<SqlInstancesExecuteSqlResponse>newBuilder()
                      .setDefaultInstance(SqlInstancesExecuteSqlResponse.getDefaultInstance())
                      .setDefaultTypeRegistry(typeRegistry)
                      .build())
              .build();

  private static final ApiMethodDescriptor<
          SqlInstancesAcquireSsrsLeaseRequest, SqlInstancesAcquireSsrsLeaseResponse>
      acquireSsrsLeaseMethodDescriptor =
          ApiMethodDescriptor
              .<SqlInstancesAcquireSsrsLeaseRequest, SqlInstancesAcquireSsrsLeaseResponse>
                  newBuilder()
              .setFullMethodName("google.cloud.sql.v1beta4.SqlInstancesService/AcquireSsrsLease")
              .setHttpMethod("POST")
              .setType(ApiMethodDescriptor.MethodType.UNARY)
              .setRequestFormatter(
                  ProtoMessageRequestFormatter.<SqlInstancesAcquireSsrsLeaseRequest>newBuilder()
                      .setPath(
                          "/sql/v1beta4/projects/{project}/instances/{instance}/acquireSsrsLease",
                          request -> {
                            Map<String, String> fields = new HashMap<>();
                            ProtoRestSerializer<SqlInstancesAcquireSsrsLeaseRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putPathParam(fields, "instance", request.getInstance());
                            serializer.putPathParam(fields, "project", request.getProject());
                            return fields;
                          })
                      .setQueryParamsExtractor(
                          request -> {
                            Map<String, List<String>> fields = new HashMap<>();
                            ProtoRestSerializer<SqlInstancesAcquireSsrsLeaseRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putQueryParam(fields, "$alt", "json;enum-encoding=int");
                            return fields;
                          })
                      .setRequestBodyExtractor(
                          request ->
                              ProtoRestSerializer.create().toBody("body", request.getBody(), true))
                      .build())
              .setResponseParser(
                  ProtoMessageResponseParser.<SqlInstancesAcquireSsrsLeaseResponse>newBuilder()
                      .setDefaultInstance(SqlInstancesAcquireSsrsLeaseResponse.getDefaultInstance())
                      .setDefaultTypeRegistry(typeRegistry)
                      .build())
              .build();

  private static final ApiMethodDescriptor<
          SqlInstancesReleaseSsrsLeaseRequest, SqlInstancesReleaseSsrsLeaseResponse>
      releaseSsrsLeaseMethodDescriptor =
          ApiMethodDescriptor
              .<SqlInstancesReleaseSsrsLeaseRequest, SqlInstancesReleaseSsrsLeaseResponse>
                  newBuilder()
              .setFullMethodName("google.cloud.sql.v1beta4.SqlInstancesService/ReleaseSsrsLease")
              .setHttpMethod("POST")
              .setType(ApiMethodDescriptor.MethodType.UNARY)
              .setRequestFormatter(
                  ProtoMessageRequestFormatter.<SqlInstancesReleaseSsrsLeaseRequest>newBuilder()
                      .setPath(
                          "/sql/v1beta4/projects/{project}/instances/{instance}/releaseSsrsLease",
                          request -> {
                            Map<String, String> fields = new HashMap<>();
                            ProtoRestSerializer<SqlInstancesReleaseSsrsLeaseRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putPathParam(fields, "instance", request.getInstance());
                            serializer.putPathParam(fields, "project", request.getProject());
                            return fields;
                          })
                      .setQueryParamsExtractor(
                          request -> {
                            Map<String, List<String>> fields = new HashMap<>();
                            ProtoRestSerializer<SqlInstancesReleaseSsrsLeaseRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putQueryParam(fields, "$alt", "json;enum-encoding=int");
                            return fields;
                          })
                      .setRequestBodyExtractor(request -> null)
                      .build())
              .setResponseParser(
                  ProtoMessageResponseParser.<SqlInstancesReleaseSsrsLeaseResponse>newBuilder()
                      .setDefaultInstance(SqlInstancesReleaseSsrsLeaseResponse.getDefaultInstance())
                      .setDefaultTypeRegistry(typeRegistry)
                      .build())
              .build();

  private static final ApiMethodDescriptor<
          SqlInstancesPreCheckMajorVersionUpgradeRequest, Operation>
      preCheckMajorVersionUpgradeMethodDescriptor =
          ApiMethodDescriptor
              .<SqlInstancesPreCheckMajorVersionUpgradeRequest, Operation>newBuilder()
              .setFullMethodName(
                  "google.cloud.sql.v1beta4.SqlInstancesService/PreCheckMajorVersionUpgrade")
              .setHttpMethod("POST")
              .setType(ApiMethodDescriptor.MethodType.UNARY)
              .setRequestFormatter(
                  ProtoMessageRequestFormatter
                      .<SqlInstancesPreCheckMajorVersionUpgradeRequest>newBuilder()
                      .setPath(
                          "/sql/v1beta4/projects/{project}/instances/{instance}/preCheckMajorVersionUpgrade",
                          request -> {
                            Map<String, String> fields = new HashMap<>();
                            ProtoRestSerializer<SqlInstancesPreCheckMajorVersionUpgradeRequest>
                                serializer = ProtoRestSerializer.create();
                            serializer.putPathParam(fields, "instance", request.getInstance());
                            serializer.putPathParam(fields, "project", request.getProject());
                            return fields;
                          })
                      .setQueryParamsExtractor(
                          request -> {
                            Map<String, List<String>> fields = new HashMap<>();
                            ProtoRestSerializer<SqlInstancesPreCheckMajorVersionUpgradeRequest>
                                serializer = ProtoRestSerializer.create();
                            serializer.putQueryParam(fields, "$alt", "json;enum-encoding=int");
                            return fields;
                          })
                      .setRequestBodyExtractor(
                          request ->
                              ProtoRestSerializer.create().toBody("body", request.getBody(), true))
                      .build())
              .setResponseParser(
                  ProtoMessageResponseParser.<Operation>newBuilder()
                      .setDefaultInstance(Operation.getDefaultInstance())
                      .setDefaultTypeRegistry(typeRegistry)
                      .build())
              .build();

  private static final ApiMethodDescriptor<SqlInstancesPointInTimeRestoreRequest, Operation>
      pointInTimeRestoreMethodDescriptor =
          ApiMethodDescriptor.<SqlInstancesPointInTimeRestoreRequest, Operation>newBuilder()
              .setFullMethodName("google.cloud.sql.v1beta4.SqlInstancesService/PointInTimeRestore")
              .setHttpMethod("POST")
              .setType(ApiMethodDescriptor.MethodType.UNARY)
              .setRequestFormatter(
                  ProtoMessageRequestFormatter.<SqlInstancesPointInTimeRestoreRequest>newBuilder()
                      .setPath(
                          "/sql/v1beta4/{parent=projects/*}:pointInTimeRestore",
                          request -> {
                            Map<String, String> fields = new HashMap<>();
                            ProtoRestSerializer<SqlInstancesPointInTimeRestoreRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putPathParam(fields, "parent", request.getParent());
                            return fields;
                          })
                      .setQueryParamsExtractor(
                          request -> {
                            Map<String, List<String>> fields = new HashMap<>();
                            ProtoRestSerializer<SqlInstancesPointInTimeRestoreRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putQueryParam(fields, "$alt", "json;enum-encoding=int");
                            return fields;
                          })
                      .setRequestBodyExtractor(
                          request ->
                              ProtoRestSerializer.create()
                                  .toBody("context", request.getContext(), true))
                      .build())
              .setResponseParser(
                  ProtoMessageResponseParser.<Operation>newBuilder()
                      .setDefaultInstance(Operation.getDefaultInstance())
                      .setDefaultTypeRegistry(typeRegistry)
                      .build())
              .build();

  private final UnaryCallable<SqlInstancesAddServerCaRequest, Operation> addServerCaCallable;
  private final UnaryCallable<SqlInstancesAddServerCertificateRequest, Operation>
      addServerCertificateCallable;
  private final UnaryCallable<SqlInstancesAddEntraIdCertificateRequest, Operation>
      addEntraIdCertificateCallable;
  private final UnaryCallable<SqlInstancesCloneRequest, Operation> cloneCallable;
  private final UnaryCallable<SqlInstancesDeleteRequest, Operation> deleteCallable;
  private final UnaryCallable<SqlInstancesDemoteMasterRequest, Operation> demoteMasterCallable;
  private final UnaryCallable<SqlInstancesDemoteRequest, Operation> demoteCallable;
  private final UnaryCallable<SqlInstancesExportRequest, Operation> exportCallable;
  private final UnaryCallable<SqlInstancesFailoverRequest, Operation> failoverCallable;
  private final UnaryCallable<SqlInstancesReencryptRequest, Operation> reencryptCallable;
  private final UnaryCallable<SqlInstancesGetRequest, DatabaseInstance> getCallable;
  private final UnaryCallable<SqlInstancesImportRequest, Operation> import_Callable;
  private final UnaryCallable<SqlInstancesInsertRequest, Operation> insertCallable;
  private final UnaryCallable<SqlInstancesListRequest, InstancesListResponse> listCallable;
  private final UnaryCallable<SqlInstancesListServerCasRequest, InstancesListServerCasResponse>
      listServerCasCallable;
  private final UnaryCallable<
          SqlInstancesListServerCertificatesRequest, InstancesListServerCertificatesResponse>
      listServerCertificatesCallable;
  private final UnaryCallable<
          SqlInstancesListEntraIdCertificatesRequest, InstancesListEntraIdCertificatesResponse>
      listEntraIdCertificatesCallable;
  private final UnaryCallable<SqlInstancesPatchRequest, Operation> patchCallable;
  private final UnaryCallable<SqlInstancesPromoteReplicaRequest, Operation> promoteReplicaCallable;
  private final UnaryCallable<SqlInstancesSwitchoverRequest, Operation> switchoverCallable;
  private final UnaryCallable<SqlInstancesResetSslConfigRequest, Operation> resetSslConfigCallable;
  private final UnaryCallable<SqlInstancesRestartRequest, Operation> restartCallable;
  private final UnaryCallable<SqlInstancesRestoreBackupRequest, Operation> restoreBackupCallable;
  private final UnaryCallable<SqlInstancesRotateServerCaRequest, Operation> rotateServerCaCallable;
  private final UnaryCallable<SqlInstancesRotateServerCertificateRequest, Operation>
      rotateServerCertificateCallable;
  private final UnaryCallable<SqlInstancesRotateEntraIdCertificateRequest, Operation>
      rotateEntraIdCertificateCallable;
  private final UnaryCallable<SqlInstancesStartReplicaRequest, Operation> startReplicaCallable;
  private final UnaryCallable<SqlInstancesStopReplicaRequest, Operation> stopReplicaCallable;
  private final UnaryCallable<SqlInstancesTruncateLogRequest, Operation> truncateLogCallable;
  private final UnaryCallable<SqlInstancesUpdateRequest, Operation> updateCallable;
  private final UnaryCallable<SqlInstancesCreateEphemeralCertRequest, SslCert>
      createEphemeralCallable;
  private final UnaryCallable<SqlInstancesRescheduleMaintenanceRequest, Operation>
      rescheduleMaintenanceCallable;
  private final UnaryCallable<
          SqlInstancesVerifyExternalSyncSettingsRequest,
          SqlInstancesVerifyExternalSyncSettingsResponse>
      verifyExternalSyncSettingsCallable;
  private final UnaryCallable<SqlInstancesStartExternalSyncRequest, Operation>
      startExternalSyncCallable;
  private final UnaryCallable<SqlInstancesPerformDiskShrinkRequest, Operation>
      performDiskShrinkCallable;
  private final UnaryCallable<
          SqlInstancesGetDiskShrinkConfigRequest, SqlInstancesGetDiskShrinkConfigResponse>
      getDiskShrinkConfigCallable;
  private final UnaryCallable<SqlInstancesResetReplicaSizeRequest, Operation>
      resetReplicaSizeCallable;
  private final UnaryCallable<
          SqlInstancesGetLatestRecoveryTimeRequest, SqlInstancesGetLatestRecoveryTimeResponse>
      getLatestRecoveryTimeCallable;
  private final UnaryCallable<SqlInstancesExecuteSqlRequest, SqlInstancesExecuteSqlResponse>
      executeSqlCallable;
  private final UnaryCallable<
          SqlInstancesAcquireSsrsLeaseRequest, SqlInstancesAcquireSsrsLeaseResponse>
      acquireSsrsLeaseCallable;
  private final UnaryCallable<
          SqlInstancesReleaseSsrsLeaseRequest, SqlInstancesReleaseSsrsLeaseResponse>
      releaseSsrsLeaseCallable;
  private final UnaryCallable<SqlInstancesPreCheckMajorVersionUpgradeRequest, Operation>
      preCheckMajorVersionUpgradeCallable;
  private final UnaryCallable<SqlInstancesPointInTimeRestoreRequest, Operation>
      pointInTimeRestoreCallable;

  private final BackgroundResource backgroundResources;
  private final HttpJsonStubCallableFactory callableFactory;

  private static final PathTemplate ADD_SERVER_CA_RESOURCE_NAME_TEMPLATE =
      PathTemplate.create("projects/{project}/instances/{instance}");
  private static final PathTemplate ADD_SERVER_CERTIFICATE_RESOURCE_NAME_TEMPLATE =
      PathTemplate.create("projects/{project}/instances/{instance}");
  private static final PathTemplate ADD_ENTRA_ID_CERTIFICATE_RESOURCE_NAME_TEMPLATE =
      PathTemplate.create("projects/{project}/instances/{instance}");
  private static final PathTemplate CLONE_RESOURCE_NAME_TEMPLATE =
      PathTemplate.create("projects/{project}/instances/{instance}");
  private static final PathTemplate DELETE_RESOURCE_NAME_TEMPLATE =
      PathTemplate.create("projects/{project}/instances/{instance}");
  private static final PathTemplate DEMOTE_MASTER_RESOURCE_NAME_TEMPLATE =
      PathTemplate.create("projects/{project}/instances/{instance}");
  private static final PathTemplate DEMOTE_RESOURCE_NAME_TEMPLATE =
      PathTemplate.create("projects/{project}/instances/{instance}");
  private static final PathTemplate EXPORT_RESOURCE_NAME_TEMPLATE =
      PathTemplate.create("projects/{project}/instances/{instance}");
  private static final PathTemplate FAILOVER_RESOURCE_NAME_TEMPLATE =
      PathTemplate.create("projects/{project}/instances/{instance}");
  private static final PathTemplate REENCRYPT_RESOURCE_NAME_TEMPLATE =
      PathTemplate.create("projects/{project}/instances/{instance}");
  private static final PathTemplate GET_RESOURCE_NAME_TEMPLATE =
      PathTemplate.create("projects/{project}/instances/{instance}");
  private static final PathTemplate IMPORT_RESOURCE_NAME_TEMPLATE =
      PathTemplate.create("projects/{project}/instances/{instance}");
  private static final PathTemplate INSERT_RESOURCE_NAME_TEMPLATE =
      PathTemplate.create("projects/{project}");
  private static final PathTemplate LIST_RESOURCE_NAME_TEMPLATE =
      PathTemplate.create("projects/{project}");
  private static final PathTemplate LIST_SERVER_CAS_RESOURCE_NAME_TEMPLATE =
      PathTemplate.create("projects/{project}/instances/{instance}");
  private static final PathTemplate LIST_SERVER_CERTIFICATES_RESOURCE_NAME_TEMPLATE =
      PathTemplate.create("projects/{project}/instances/{instance}");
  private static final PathTemplate LIST_ENTRA_ID_CERTIFICATES_RESOURCE_NAME_TEMPLATE =
      PathTemplate.create("projects/{project}/instances/{instance}");
  private static final PathTemplate PATCH_RESOURCE_NAME_TEMPLATE =
      PathTemplate.create("projects/{project}/instances/{instance}");
  private static final PathTemplate PROMOTE_REPLICA_RESOURCE_NAME_TEMPLATE =
      PathTemplate.create("projects/{project}/instances/{instance}");
  private static final PathTemplate SWITCHOVER_RESOURCE_NAME_TEMPLATE =
      PathTemplate.create("projects/{project}/instances/{instance}");
  private static final PathTemplate RESET_SSL_CONFIG_RESOURCE_NAME_TEMPLATE =
      PathTemplate.create("projects/{project}/instances/{instance}");
  private static final PathTemplate RESTART_RESOURCE_NAME_TEMPLATE =
      PathTemplate.create("projects/{project}/instances/{instance}");
  private static final PathTemplate RESTORE_BACKUP_RESOURCE_NAME_TEMPLATE =
      PathTemplate.create("projects/{project}/instances/{instance}");
  private static final PathTemplate ROTATE_SERVER_CA_RESOURCE_NAME_TEMPLATE =
      PathTemplate.create("projects/{project}/instances/{instance}");
  private static final PathTemplate ROTATE_SERVER_CERTIFICATE_RESOURCE_NAME_TEMPLATE =
      PathTemplate.create("projects/{project}/instances/{instance}");
  private static final PathTemplate ROTATE_ENTRA_ID_CERTIFICATE_RESOURCE_NAME_TEMPLATE =
      PathTemplate.create("projects/{project}/instances/{instance}");
  private static final PathTemplate START_REPLICA_RESOURCE_NAME_TEMPLATE =
      PathTemplate.create("projects/{project}/instances/{instance}");
  private static final PathTemplate STOP_REPLICA_RESOURCE_NAME_TEMPLATE =
      PathTemplate.create("projects/{project}/instances/{instance}");
  private static final PathTemplate TRUNCATE_LOG_RESOURCE_NAME_TEMPLATE =
      PathTemplate.create("projects/{project}/instances/{instance}");
  private static final PathTemplate UPDATE_RESOURCE_NAME_TEMPLATE =
      PathTemplate.create("projects/{project}/instances/{instance}");
  private static final PathTemplate CREATE_EPHEMERAL_RESOURCE_NAME_TEMPLATE =
      PathTemplate.create("projects/{project}/instances/{instance}");
  private static final PathTemplate RESCHEDULE_MAINTENANCE_RESOURCE_NAME_TEMPLATE =
      PathTemplate.create("projects/{project}/instances/{instance}");
  private static final PathTemplate VERIFY_EXTERNAL_SYNC_SETTINGS_RESOURCE_NAME_TEMPLATE =
      PathTemplate.create("projects/{project}/instances/{instance}");
  private static final PathTemplate START_EXTERNAL_SYNC_RESOURCE_NAME_TEMPLATE =
      PathTemplate.create("projects/{project}/instances/{instance}");
  private static final PathTemplate PERFORM_DISK_SHRINK_RESOURCE_NAME_TEMPLATE =
      PathTemplate.create("projects/{project}/instances/{instance}");
  private static final PathTemplate GET_DISK_SHRINK_CONFIG_RESOURCE_NAME_TEMPLATE =
      PathTemplate.create("projects/{project}/instances/{instance}");
  private static final PathTemplate RESET_REPLICA_SIZE_RESOURCE_NAME_TEMPLATE =
      PathTemplate.create("projects/{project}/instances/{instance}");
  private static final PathTemplate GET_LATEST_RECOVERY_TIME_RESOURCE_NAME_TEMPLATE =
      PathTemplate.create("projects/{project}/instances/{instance}");
  private static final PathTemplate EXECUTE_SQL_RESOURCE_NAME_TEMPLATE =
      PathTemplate.create("projects/{project}/instances/{instance}");
  private static final PathTemplate ACQUIRE_SSRS_LEASE_RESOURCE_NAME_TEMPLATE =
      PathTemplate.create("projects/{project}/instances/{instance}");
  private static final PathTemplate RELEASE_SSRS_LEASE_RESOURCE_NAME_TEMPLATE =
      PathTemplate.create("projects/{project}/instances/{instance}");
  private static final PathTemplate PRE_CHECK_MAJOR_VERSION_UPGRADE_RESOURCE_NAME_TEMPLATE =
      PathTemplate.create("projects/{project}/instances/{instance}");
  private static final PathTemplate POINT_IN_TIME_RESTORE_RESOURCE_NAME_TEMPLATE =
      PathTemplate.create("{parent=projects/*}");

  public static final HttpJsonSqlInstancesServiceStub create(
      SqlInstancesServiceStubSettings settings) throws IOException {
    return new HttpJsonSqlInstancesServiceStub(settings, ClientContext.create(settings));
  }

  public static final HttpJsonSqlInstancesServiceStub create(ClientContext clientContext)
      throws IOException {
    return new HttpJsonSqlInstancesServiceStub(
        SqlInstancesServiceStubSettings.newHttpJsonBuilder().build(), clientContext);
  }

  public static final HttpJsonSqlInstancesServiceStub create(
      ClientContext clientContext, HttpJsonStubCallableFactory callableFactory) throws IOException {
    return new HttpJsonSqlInstancesServiceStub(
        SqlInstancesServiceStubSettings.newHttpJsonBuilder().build(),
        clientContext,
        callableFactory);
  }

  /**
   * Constructs an instance of HttpJsonSqlInstancesServiceStub, using the given settings. This is
   * protected so that it is easy to make a subclass, but otherwise, the static factory methods
   * should be preferred.
   */
  protected HttpJsonSqlInstancesServiceStub(
      SqlInstancesServiceStubSettings settings, ClientContext clientContext) throws IOException {
    this(settings, clientContext, new HttpJsonSqlInstancesServiceCallableFactory());
  }

  /**
   * Constructs an instance of HttpJsonSqlInstancesServiceStub, using the given settings. This is
   * protected so that it is easy to make a subclass, but otherwise, the static factory methods
   * should be preferred.
   */
  protected HttpJsonSqlInstancesServiceStub(
      SqlInstancesServiceStubSettings settings,
      ClientContext clientContext,
      HttpJsonStubCallableFactory callableFactory)
      throws IOException {
    this.callableFactory = callableFactory;

    HttpJsonCallSettings<SqlInstancesAddServerCaRequest, Operation> addServerCaTransportSettings =
        HttpJsonCallSettings.<SqlInstancesAddServerCaRequest, Operation>newBuilder()
            .setMethodDescriptor(addServerCaMethodDescriptor)
            .setTypeRegistry(typeRegistry)
            .setParamsExtractor(
                request -> {
                  RequestParamsBuilder builder = RequestParamsBuilder.create();
                  builder.add("instance", String.valueOf(request.getInstance()));
                  builder.add("project", String.valueOf(request.getProject()));
                  return builder.build();
                })
            .setResourceNameExtractor(
                request -> {
                  Map<String, String> resourceNameSegments = new HashMap<String, String>();
                  resourceNameSegments.put("instance", String.valueOf(request.getInstance()));
                  resourceNameSegments.put("project", String.valueOf(request.getProject()));
                  return ADD_SERVER_CA_RESOURCE_NAME_TEMPLATE.instantiate(resourceNameSegments);
                })
            .build();
    HttpJsonCallSettings<SqlInstancesAddServerCertificateRequest, Operation>
        addServerCertificateTransportSettings =
            HttpJsonCallSettings.<SqlInstancesAddServerCertificateRequest, Operation>newBuilder()
                .setMethodDescriptor(addServerCertificateMethodDescriptor)
                .setTypeRegistry(typeRegistry)
                .setParamsExtractor(
                    request -> {
                      RequestParamsBuilder builder = RequestParamsBuilder.create();
                      builder.add("instance", String.valueOf(request.getInstance()));
                      builder.add("project", String.valueOf(request.getProject()));
                      return builder.build();
                    })
                .setResourceNameExtractor(
                    request -> {
                      Map<String, String> resourceNameSegments = new HashMap<String, String>();
                      resourceNameSegments.put("instance", String.valueOf(request.getInstance()));
                      resourceNameSegments.put("project", String.valueOf(request.getProject()));
                      return ADD_SERVER_CERTIFICATE_RESOURCE_NAME_TEMPLATE.instantiate(
                          resourceNameSegments);
                    })
                .build();
    HttpJsonCallSettings<SqlInstancesAddEntraIdCertificateRequest, Operation>
        addEntraIdCertificateTransportSettings =
            HttpJsonCallSettings.<SqlInstancesAddEntraIdCertificateRequest, Operation>newBuilder()
                .setMethodDescriptor(addEntraIdCertificateMethodDescriptor)
                .setTypeRegistry(typeRegistry)
                .setParamsExtractor(
                    request -> {
                      RequestParamsBuilder builder = RequestParamsBuilder.create();
                      builder.add("instance", String.valueOf(request.getInstance()));
                      builder.add("project", String.valueOf(request.getProject()));
                      return builder.build();
                    })
                .setResourceNameExtractor(
                    request -> {
                      Map<String, String> resourceNameSegments = new HashMap<String, String>();
                      resourceNameSegments.put("instance", String.valueOf(request.getInstance()));
                      resourceNameSegments.put("project", String.valueOf(request.getProject()));
                      return ADD_ENTRA_ID_CERTIFICATE_RESOURCE_NAME_TEMPLATE.instantiate(
                          resourceNameSegments);
                    })
                .build();
    HttpJsonCallSettings<SqlInstancesCloneRequest, Operation> cloneTransportSettings =
        HttpJsonCallSettings.<SqlInstancesCloneRequest, Operation>newBuilder()
            .setMethodDescriptor(cloneMethodDescriptor)
            .setTypeRegistry(typeRegistry)
            .setParamsExtractor(
                request -> {
                  RequestParamsBuilder builder = RequestParamsBuilder.create();
                  builder.add("instance", String.valueOf(request.getInstance()));
                  builder.add("project", String.valueOf(request.getProject()));
                  return builder.build();
                })
            .setResourceNameExtractor(
                request -> {
                  Map<String, String> resourceNameSegments = new HashMap<String, String>();
                  resourceNameSegments.put("instance", String.valueOf(request.getInstance()));
                  resourceNameSegments.put("project", String.valueOf(request.getProject()));
                  return CLONE_RESOURCE_NAME_TEMPLATE.instantiate(resourceNameSegments);
                })
            .build();
    HttpJsonCallSettings<SqlInstancesDeleteRequest, Operation> deleteTransportSettings =
        HttpJsonCallSettings.<SqlInstancesDeleteRequest, Operation>newBuilder()
            .setMethodDescriptor(deleteMethodDescriptor)
            .setTypeRegistry(typeRegistry)
            .setParamsExtractor(
                request -> {
                  RequestParamsBuilder builder = RequestParamsBuilder.create();
                  builder.add("instance", String.valueOf(request.getInstance()));
                  builder.add("project", String.valueOf(request.getProject()));
                  return builder.build();
                })
            .setResourceNameExtractor(
                request -> {
                  Map<String, String> resourceNameSegments = new HashMap<String, String>();
                  resourceNameSegments.put("instance", String.valueOf(request.getInstance()));
                  resourceNameSegments.put("project", String.valueOf(request.getProject()));
                  return DELETE_RESOURCE_NAME_TEMPLATE.instantiate(resourceNameSegments);
                })
            .build();
    HttpJsonCallSettings<SqlInstancesDemoteMasterRequest, Operation> demoteMasterTransportSettings =
        HttpJsonCallSettings.<SqlInstancesDemoteMasterRequest, Operation>newBuilder()
            .setMethodDescriptor(demoteMasterMethodDescriptor)
            .setTypeRegistry(typeRegistry)
            .setParamsExtractor(
                request -> {
                  RequestParamsBuilder builder = RequestParamsBuilder.create();
                  builder.add("instance", String.valueOf(request.getInstance()));
                  builder.add("project", String.valueOf(request.getProject()));
                  return builder.build();
                })
            .setResourceNameExtractor(
                request -> {
                  Map<String, String> resourceNameSegments = new HashMap<String, String>();
                  resourceNameSegments.put("instance", String.valueOf(request.getInstance()));
                  resourceNameSegments.put("project", String.valueOf(request.getProject()));
                  return DEMOTE_MASTER_RESOURCE_NAME_TEMPLATE.instantiate(resourceNameSegments);
                })
            .build();
    HttpJsonCallSettings<SqlInstancesDemoteRequest, Operation> demoteTransportSettings =
        HttpJsonCallSettings.<SqlInstancesDemoteRequest, Operation>newBuilder()
            .setMethodDescriptor(demoteMethodDescriptor)
            .setTypeRegistry(typeRegistry)
            .setParamsExtractor(
                request -> {
                  RequestParamsBuilder builder = RequestParamsBuilder.create();
                  builder.add("instance", String.valueOf(request.getInstance()));
                  builder.add("project", String.valueOf(request.getProject()));
                  return builder.build();
                })
            .setResourceNameExtractor(
                request -> {
                  Map<String, String> resourceNameSegments = new HashMap<String, String>();
                  resourceNameSegments.put("instance", String.valueOf(request.getInstance()));
                  resourceNameSegments.put("project", String.valueOf(request.getProject()));
                  return DEMOTE_RESOURCE_NAME_TEMPLATE.instantiate(resourceNameSegments);
                })
            .build();
    HttpJsonCallSettings<SqlInstancesExportRequest, Operation> exportTransportSettings =
        HttpJsonCallSettings.<SqlInstancesExportRequest, Operation>newBuilder()
            .setMethodDescriptor(exportMethodDescriptor)
            .setTypeRegistry(typeRegistry)
            .setParamsExtractor(
                request -> {
                  RequestParamsBuilder builder = RequestParamsBuilder.create();
                  builder.add("instance", String.valueOf(request.getInstance()));
                  builder.add("project", String.valueOf(request.getProject()));
                  return builder.build();
                })
            .setResourceNameExtractor(
                request -> {
                  Map<String, String> resourceNameSegments = new HashMap<String, String>();
                  resourceNameSegments.put("instance", String.valueOf(request.getInstance()));
                  resourceNameSegments.put("project", String.valueOf(request.getProject()));
                  return EXPORT_RESOURCE_NAME_TEMPLATE.instantiate(resourceNameSegments);
                })
            .build();
    HttpJsonCallSettings<SqlInstancesFailoverRequest, Operation> failoverTransportSettings =
        HttpJsonCallSettings.<SqlInstancesFailoverRequest, Operation>newBuilder()
            .setMethodDescriptor(failoverMethodDescriptor)
            .setTypeRegistry(typeRegistry)
            .setParamsExtractor(
                request -> {
                  RequestParamsBuilder builder = RequestParamsBuilder.create();
                  builder.add("instance", String.valueOf(request.getInstance()));
                  builder.add("project", String.valueOf(request.getProject()));
                  return builder.build();
                })
            .setResourceNameExtractor(
                request -> {
                  Map<String, String> resourceNameSegments = new HashMap<String, String>();
                  resourceNameSegments.put("instance", String.valueOf(request.getInstance()));
                  resourceNameSegments.put("project", String.valueOf(request.getProject()));
                  return FAILOVER_RESOURCE_NAME_TEMPLATE.instantiate(resourceNameSegments);
                })
            .build();
    HttpJsonCallSettings<SqlInstancesReencryptRequest, Operation> reencryptTransportSettings =
        HttpJsonCallSettings.<SqlInstancesReencryptRequest, Operation>newBuilder()
            .setMethodDescriptor(reencryptMethodDescriptor)
            .setTypeRegistry(typeRegistry)
            .setParamsExtractor(
                request -> {
                  RequestParamsBuilder builder = RequestParamsBuilder.create();
                  builder.add("instance", String.valueOf(request.getInstance()));
                  builder.add("project", String.valueOf(request.getProject()));
                  return builder.build();
                })
            .setResourceNameExtractor(
                request -> {
                  Map<String, String> resourceNameSegments = new HashMap<String, String>();
                  resourceNameSegments.put("instance", String.valueOf(request.getInstance()));
                  resourceNameSegments.put("project", String.valueOf(request.getProject()));
                  return REENCRYPT_RESOURCE_NAME_TEMPLATE.instantiate(resourceNameSegments);
                })
            .build();
    HttpJsonCallSettings<SqlInstancesGetRequest, DatabaseInstance> getTransportSettings =
        HttpJsonCallSettings.<SqlInstancesGetRequest, DatabaseInstance>newBuilder()
            .setMethodDescriptor(getMethodDescriptor)
            .setTypeRegistry(typeRegistry)
            .setParamsExtractor(
                request -> {
                  RequestParamsBuilder builder = RequestParamsBuilder.create();
                  builder.add("instance", String.valueOf(request.getInstance()));
                  builder.add("project", String.valueOf(request.getProject()));
                  return builder.build();
                })
            .setResourceNameExtractor(
                request -> {
                  Map<String, String> resourceNameSegments = new HashMap<String, String>();
                  resourceNameSegments.put("instance", String.valueOf(request.getInstance()));
                  resourceNameSegments.put("project", String.valueOf(request.getProject()));
                  return GET_RESOURCE_NAME_TEMPLATE.instantiate(resourceNameSegments);
                })
            .build();
    HttpJsonCallSettings<SqlInstancesImportRequest, Operation> import_TransportSettings =
        HttpJsonCallSettings.<SqlInstancesImportRequest, Operation>newBuilder()
            .setMethodDescriptor(import_MethodDescriptor)
            .setTypeRegistry(typeRegistry)
            .setParamsExtractor(
                request -> {
                  RequestParamsBuilder builder = RequestParamsBuilder.create();
                  builder.add("instance", String.valueOf(request.getInstance()));
                  builder.add("project", String.valueOf(request.getProject()));
                  return builder.build();
                })
            .setResourceNameExtractor(
                request -> {
                  Map<String, String> resourceNameSegments = new HashMap<String, String>();
                  resourceNameSegments.put("instance", String.valueOf(request.getInstance()));
                  resourceNameSegments.put("project", String.valueOf(request.getProject()));
                  return IMPORT_RESOURCE_NAME_TEMPLATE.instantiate(resourceNameSegments);
                })
            .build();
    HttpJsonCallSettings<SqlInstancesInsertRequest, Operation> insertTransportSettings =
        HttpJsonCallSettings.<SqlInstancesInsertRequest, Operation>newBuilder()
            .setMethodDescriptor(insertMethodDescriptor)
            .setTypeRegistry(typeRegistry)
            .setParamsExtractor(
                request -> {
                  RequestParamsBuilder builder = RequestParamsBuilder.create();
                  builder.add("project", String.valueOf(request.getProject()));
                  return builder.build();
                })
            .setResourceNameExtractor(
                request -> {
                  Map<String, String> resourceNameSegments = new HashMap<String, String>();
                  resourceNameSegments.put("project", String.valueOf(request.getProject()));
                  return INSERT_RESOURCE_NAME_TEMPLATE.instantiate(resourceNameSegments);
                })
            .build();
    HttpJsonCallSettings<SqlInstancesListRequest, InstancesListResponse> listTransportSettings =
        HttpJsonCallSettings.<SqlInstancesListRequest, InstancesListResponse>newBuilder()
            .setMethodDescriptor(listMethodDescriptor)
            .setTypeRegistry(typeRegistry)
            .setParamsExtractor(
                request -> {
                  RequestParamsBuilder builder = RequestParamsBuilder.create();
                  builder.add("project", String.valueOf(request.getProject()));
                  return builder.build();
                })
            .setResourceNameExtractor(
                request -> {
                  Map<String, String> resourceNameSegments = new HashMap<String, String>();
                  resourceNameSegments.put("project", String.valueOf(request.getProject()));
                  return LIST_RESOURCE_NAME_TEMPLATE.instantiate(resourceNameSegments);
                })
            .build();
    HttpJsonCallSettings<SqlInstancesListServerCasRequest, InstancesListServerCasResponse>
        listServerCasTransportSettings =
            HttpJsonCallSettings
                .<SqlInstancesListServerCasRequest, InstancesListServerCasResponse>newBuilder()
                .setMethodDescriptor(listServerCasMethodDescriptor)
                .setTypeRegistry(typeRegistry)
                .setParamsExtractor(
                    request -> {
                      RequestParamsBuilder builder = RequestParamsBuilder.create();
                      builder.add("instance", String.valueOf(request.getInstance()));
                      builder.add("project", String.valueOf(request.getProject()));
                      return builder.build();
                    })
                .setResourceNameExtractor(
                    request -> {
                      Map<String, String> resourceNameSegments = new HashMap<String, String>();
                      resourceNameSegments.put("instance", String.valueOf(request.getInstance()));
                      resourceNameSegments.put("project", String.valueOf(request.getProject()));
                      return LIST_SERVER_CAS_RESOURCE_NAME_TEMPLATE.instantiate(
                          resourceNameSegments);
                    })
                .build();
    HttpJsonCallSettings<
            SqlInstancesListServerCertificatesRequest, InstancesListServerCertificatesResponse>
        listServerCertificatesTransportSettings =
            HttpJsonCallSettings
                .<SqlInstancesListServerCertificatesRequest,
                    InstancesListServerCertificatesResponse>
                    newBuilder()
                .setMethodDescriptor(listServerCertificatesMethodDescriptor)
                .setTypeRegistry(typeRegistry)
                .setParamsExtractor(
                    request -> {
                      RequestParamsBuilder builder = RequestParamsBuilder.create();
                      builder.add("instance", String.valueOf(request.getInstance()));
                      builder.add("project", String.valueOf(request.getProject()));
                      return builder.build();
                    })
                .setResourceNameExtractor(
                    request -> {
                      Map<String, String> resourceNameSegments = new HashMap<String, String>();
                      resourceNameSegments.put("instance", String.valueOf(request.getInstance()));
                      resourceNameSegments.put("project", String.valueOf(request.getProject()));
                      return LIST_SERVER_CERTIFICATES_RESOURCE_NAME_TEMPLATE.instantiate(
                          resourceNameSegments);
                    })
                .build();
    HttpJsonCallSettings<
            SqlInstancesListEntraIdCertificatesRequest, InstancesListEntraIdCertificatesResponse>
        listEntraIdCertificatesTransportSettings =
            HttpJsonCallSettings
                .<SqlInstancesListEntraIdCertificatesRequest,
                    InstancesListEntraIdCertificatesResponse>
                    newBuilder()
                .setMethodDescriptor(listEntraIdCertificatesMethodDescriptor)
                .setTypeRegistry(typeRegistry)
                .setParamsExtractor(
                    request -> {
                      RequestParamsBuilder builder = RequestParamsBuilder.create();
                      builder.add("instance", String.valueOf(request.getInstance()));
                      builder.add("project", String.valueOf(request.getProject()));
                      return builder.build();
                    })
                .setResourceNameExtractor(
                    request -> {
                      Map<String, String> resourceNameSegments = new HashMap<String, String>();
                      resourceNameSegments.put("instance", String.valueOf(request.getInstance()));
                      resourceNameSegments.put("project", String.valueOf(request.getProject()));
                      return LIST_ENTRA_ID_CERTIFICATES_RESOURCE_NAME_TEMPLATE.instantiate(
                          resourceNameSegments);
                    })
                .build();
    HttpJsonCallSettings<SqlInstancesPatchRequest, Operation> patchTransportSettings =
        HttpJsonCallSettings.<SqlInstancesPatchRequest, Operation>newBuilder()
            .setMethodDescriptor(patchMethodDescriptor)
            .setTypeRegistry(typeRegistry)
            .setParamsExtractor(
                request -> {
                  RequestParamsBuilder builder = RequestParamsBuilder.create();
                  builder.add("instance", String.valueOf(request.getInstance()));
                  builder.add("project", String.valueOf(request.getProject()));
                  return builder.build();
                })
            .setResourceNameExtractor(
                request -> {
                  Map<String, String> resourceNameSegments = new HashMap<String, String>();
                  resourceNameSegments.put("instance", String.valueOf(request.getInstance()));
                  resourceNameSegments.put("project", String.valueOf(request.getProject()));
                  return PATCH_RESOURCE_NAME_TEMPLATE.instantiate(resourceNameSegments);
                })
            .build();
    HttpJsonCallSettings<SqlInstancesPromoteReplicaRequest, Operation>
        promoteReplicaTransportSettings =
            HttpJsonCallSettings.<SqlInstancesPromoteReplicaRequest, Operation>newBuilder()
                .setMethodDescriptor(promoteReplicaMethodDescriptor)
                .setTypeRegistry(typeRegistry)
                .setParamsExtractor(
                    request -> {
                      RequestParamsBuilder builder = RequestParamsBuilder.create();
                      builder.add("instance", String.valueOf(request.getInstance()));
                      builder.add("project", String.valueOf(request.getProject()));
                      return builder.build();
                    })
                .setResourceNameExtractor(
                    request -> {
                      Map<String, String> resourceNameSegments = new HashMap<String, String>();
                      resourceNameSegments.put("instance", String.valueOf(request.getInstance()));
                      resourceNameSegments.put("project", String.valueOf(request.getProject()));
                      return PROMOTE_REPLICA_RESOURCE_NAME_TEMPLATE.instantiate(
                          resourceNameSegments);
                    })
                .build();
    HttpJsonCallSettings<SqlInstancesSwitchoverRequest, Operation> switchoverTransportSettings =
        HttpJsonCallSettings.<SqlInstancesSwitchoverRequest, Operation>newBuilder()
            .setMethodDescriptor(switchoverMethodDescriptor)
            .setTypeRegistry(typeRegistry)
            .setParamsExtractor(
                request -> {
                  RequestParamsBuilder builder = RequestParamsBuilder.create();
                  builder.add("instance", String.valueOf(request.getInstance()));
                  builder.add("project", String.valueOf(request.getProject()));
                  return builder.build();
                })
            .setResourceNameExtractor(
                request -> {
                  Map<String, String> resourceNameSegments = new HashMap<String, String>();
                  resourceNameSegments.put("instance", String.valueOf(request.getInstance()));
                  resourceNameSegments.put("project", String.valueOf(request.getProject()));
                  return SWITCHOVER_RESOURCE_NAME_TEMPLATE.instantiate(resourceNameSegments);
                })
            .build();
    HttpJsonCallSettings<SqlInstancesResetSslConfigRequest, Operation>
        resetSslConfigTransportSettings =
            HttpJsonCallSettings.<SqlInstancesResetSslConfigRequest, Operation>newBuilder()
                .setMethodDescriptor(resetSslConfigMethodDescriptor)
                .setTypeRegistry(typeRegistry)
                .setParamsExtractor(
                    request -> {
                      RequestParamsBuilder builder = RequestParamsBuilder.create();
                      builder.add("instance", String.valueOf(request.getInstance()));
                      builder.add("project", String.valueOf(request.getProject()));
                      return builder.build();
                    })
                .setResourceNameExtractor(
                    request -> {
                      Map<String, String> resourceNameSegments = new HashMap<String, String>();
                      resourceNameSegments.put("instance", String.valueOf(request.getInstance()));
                      resourceNameSegments.put("project", String.valueOf(request.getProject()));
                      return RESET_SSL_CONFIG_RESOURCE_NAME_TEMPLATE.instantiate(
                          resourceNameSegments);
                    })
                .build();
    HttpJsonCallSettings<SqlInstancesRestartRequest, Operation> restartTransportSettings =
        HttpJsonCallSettings.<SqlInstancesRestartRequest, Operation>newBuilder()
            .setMethodDescriptor(restartMethodDescriptor)
            .setTypeRegistry(typeRegistry)
            .setParamsExtractor(
                request -> {
                  RequestParamsBuilder builder = RequestParamsBuilder.create();
                  builder.add("instance", String.valueOf(request.getInstance()));
                  builder.add("project", String.valueOf(request.getProject()));
                  return builder.build();
                })
            .setResourceNameExtractor(
                request -> {
                  Map<String, String> resourceNameSegments = new HashMap<String, String>();
                  resourceNameSegments.put("instance", String.valueOf(request.getInstance()));
                  resourceNameSegments.put("project", String.valueOf(request.getProject()));
                  return RESTART_RESOURCE_NAME_TEMPLATE.instantiate(resourceNameSegments);
                })
            .build();
    HttpJsonCallSettings<SqlInstancesRestoreBackupRequest, Operation>
        restoreBackupTransportSettings =
            HttpJsonCallSettings.<SqlInstancesRestoreBackupRequest, Operation>newBuilder()
                .setMethodDescriptor(restoreBackupMethodDescriptor)
                .setTypeRegistry(typeRegistry)
                .setParamsExtractor(
                    request -> {
                      RequestParamsBuilder builder = RequestParamsBuilder.create();
                      builder.add("instance", String.valueOf(request.getInstance()));
                      builder.add("project", String.valueOf(request.getProject()));
                      return builder.build();
                    })
                .setResourceNameExtractor(
                    request -> {
                      Map<String, String> resourceNameSegments = new HashMap<String, String>();
                      resourceNameSegments.put("instance", String.valueOf(request.getInstance()));
                      resourceNameSegments.put("project", String.valueOf(request.getProject()));
                      return RESTORE_BACKUP_RESOURCE_NAME_TEMPLATE.instantiate(
                          resourceNameSegments);
                    })
                .build();
    HttpJsonCallSettings<SqlInstancesRotateServerCaRequest, Operation>
        rotateServerCaTransportSettings =
            HttpJsonCallSettings.<SqlInstancesRotateServerCaRequest, Operation>newBuilder()
                .setMethodDescriptor(rotateServerCaMethodDescriptor)
                .setTypeRegistry(typeRegistry)
                .setParamsExtractor(
                    request -> {
                      RequestParamsBuilder builder = RequestParamsBuilder.create();
                      builder.add("instance", String.valueOf(request.getInstance()));
                      builder.add("project", String.valueOf(request.getProject()));
                      return builder.build();
                    })
                .setResourceNameExtractor(
                    request -> {
                      Map<String, String> resourceNameSegments = new HashMap<String, String>();
                      resourceNameSegments.put("instance", String.valueOf(request.getInstance()));
                      resourceNameSegments.put("project", String.valueOf(request.getProject()));
                      return ROTATE_SERVER_CA_RESOURCE_NAME_TEMPLATE.instantiate(
                          resourceNameSegments);
                    })
                .build();
    HttpJsonCallSettings<SqlInstancesRotateServerCertificateRequest, Operation>
        rotateServerCertificateTransportSettings =
            HttpJsonCallSettings.<SqlInstancesRotateServerCertificateRequest, Operation>newBuilder()
                .setMethodDescriptor(rotateServerCertificateMethodDescriptor)
                .setTypeRegistry(typeRegistry)
                .setParamsExtractor(
                    request -> {
                      RequestParamsBuilder builder = RequestParamsBuilder.create();
                      builder.add("instance", String.valueOf(request.getInstance()));
                      builder.add("project", String.valueOf(request.getProject()));
                      return builder.build();
                    })
                .setResourceNameExtractor(
                    request -> {
                      Map<String, String> resourceNameSegments = new HashMap<String, String>();
                      resourceNameSegments.put("instance", String.valueOf(request.getInstance()));
                      resourceNameSegments.put("project", String.valueOf(request.getProject()));
                      return ROTATE_SERVER_CERTIFICATE_RESOURCE_NAME_TEMPLATE.instantiate(
                          resourceNameSegments);
                    })
                .build();
    HttpJsonCallSettings<SqlInstancesRotateEntraIdCertificateRequest, Operation>
        rotateEntraIdCertificateTransportSettings =
            HttpJsonCallSettings
                .<SqlInstancesRotateEntraIdCertificateRequest, Operation>newBuilder()
                .setMethodDescriptor(rotateEntraIdCertificateMethodDescriptor)
                .setTypeRegistry(typeRegistry)
                .setParamsExtractor(
                    request -> {
                      RequestParamsBuilder builder = RequestParamsBuilder.create();
                      builder.add("instance", String.valueOf(request.getInstance()));
                      builder.add("project", String.valueOf(request.getProject()));
                      return builder.build();
                    })
                .setResourceNameExtractor(
                    request -> {
                      Map<String, String> resourceNameSegments = new HashMap<String, String>();
                      resourceNameSegments.put("instance", String.valueOf(request.getInstance()));
                      resourceNameSegments.put("project", String.valueOf(request.getProject()));
                      return ROTATE_ENTRA_ID_CERTIFICATE_RESOURCE_NAME_TEMPLATE.instantiate(
                          resourceNameSegments);
                    })
                .build();
    HttpJsonCallSettings<SqlInstancesStartReplicaRequest, Operation> startReplicaTransportSettings =
        HttpJsonCallSettings.<SqlInstancesStartReplicaRequest, Operation>newBuilder()
            .setMethodDescriptor(startReplicaMethodDescriptor)
            .setTypeRegistry(typeRegistry)
            .setParamsExtractor(
                request -> {
                  RequestParamsBuilder builder = RequestParamsBuilder.create();
                  builder.add("instance", String.valueOf(request.getInstance()));
                  builder.add("project", String.valueOf(request.getProject()));
                  return builder.build();
                })
            .setResourceNameExtractor(
                request -> {
                  Map<String, String> resourceNameSegments = new HashMap<String, String>();
                  resourceNameSegments.put("instance", String.valueOf(request.getInstance()));
                  resourceNameSegments.put("project", String.valueOf(request.getProject()));
                  return START_REPLICA_RESOURCE_NAME_TEMPLATE.instantiate(resourceNameSegments);
                })
            .build();
    HttpJsonCallSettings<SqlInstancesStopReplicaRequest, Operation> stopReplicaTransportSettings =
        HttpJsonCallSettings.<SqlInstancesStopReplicaRequest, Operation>newBuilder()
            .setMethodDescriptor(stopReplicaMethodDescriptor)
            .setTypeRegistry(typeRegistry)
            .setParamsExtractor(
                request -> {
                  RequestParamsBuilder builder = RequestParamsBuilder.create();
                  builder.add("instance", String.valueOf(request.getInstance()));
                  builder.add("project", String.valueOf(request.getProject()));
                  return builder.build();
                })
            .setResourceNameExtractor(
                request -> {
                  Map<String, String> resourceNameSegments = new HashMap<String, String>();
                  resourceNameSegments.put("instance", String.valueOf(request.getInstance()));
                  resourceNameSegments.put("project", String.valueOf(request.getProject()));
                  return STOP_REPLICA_RESOURCE_NAME_TEMPLATE.instantiate(resourceNameSegments);
                })
            .build();
    HttpJsonCallSettings<SqlInstancesTruncateLogRequest, Operation> truncateLogTransportSettings =
        HttpJsonCallSettings.<SqlInstancesTruncateLogRequest, Operation>newBuilder()
            .setMethodDescriptor(truncateLogMethodDescriptor)
            .setTypeRegistry(typeRegistry)
            .setParamsExtractor(
                request -> {
                  RequestParamsBuilder builder = RequestParamsBuilder.create();
                  builder.add("instance", String.valueOf(request.getInstance()));
                  builder.add("project", String.valueOf(request.getProject()));
                  return builder.build();
                })
            .setResourceNameExtractor(
                request -> {
                  Map<String, String> resourceNameSegments = new HashMap<String, String>();
                  resourceNameSegments.put("instance", String.valueOf(request.getInstance()));
                  resourceNameSegments.put("project", String.valueOf(request.getProject()));
                  return TRUNCATE_LOG_RESOURCE_NAME_TEMPLATE.instantiate(resourceNameSegments);
                })
            .build();
    HttpJsonCallSettings<SqlInstancesUpdateRequest, Operation> updateTransportSettings =
        HttpJsonCallSettings.<SqlInstancesUpdateRequest, Operation>newBuilder()
            .setMethodDescriptor(updateMethodDescriptor)
            .setTypeRegistry(typeRegistry)
            .setParamsExtractor(
                request -> {
                  RequestParamsBuilder builder = RequestParamsBuilder.create();
                  builder.add("instance", String.valueOf(request.getInstance()));
                  builder.add("project", String.valueOf(request.getProject()));
                  return builder.build();
                })
            .setResourceNameExtractor(
                request -> {
                  Map<String, String> resourceNameSegments = new HashMap<String, String>();
                  resourceNameSegments.put("instance", String.valueOf(request.getInstance()));
                  resourceNameSegments.put("project", String.valueOf(request.getProject()));
                  return UPDATE_RESOURCE_NAME_TEMPLATE.instantiate(resourceNameSegments);
                })
            .build();
    HttpJsonCallSettings<SqlInstancesCreateEphemeralCertRequest, SslCert>
        createEphemeralTransportSettings =
            HttpJsonCallSettings.<SqlInstancesCreateEphemeralCertRequest, SslCert>newBuilder()
                .setMethodDescriptor(createEphemeralMethodDescriptor)
                .setTypeRegistry(typeRegistry)
                .setParamsExtractor(
                    request -> {
                      RequestParamsBuilder builder = RequestParamsBuilder.create();
                      builder.add("instance", String.valueOf(request.getInstance()));
                      builder.add("project", String.valueOf(request.getProject()));
                      return builder.build();
                    })
                .setResourceNameExtractor(
                    request -> {
                      Map<String, String> resourceNameSegments = new HashMap<String, String>();
                      resourceNameSegments.put("instance", String.valueOf(request.getInstance()));
                      resourceNameSegments.put("project", String.valueOf(request.getProject()));
                      return CREATE_EPHEMERAL_RESOURCE_NAME_TEMPLATE.instantiate(
                          resourceNameSegments);
                    })
                .build();
    HttpJsonCallSettings<SqlInstancesRescheduleMaintenanceRequest, Operation>
        rescheduleMaintenanceTransportSettings =
            HttpJsonCallSettings.<SqlInstancesRescheduleMaintenanceRequest, Operation>newBuilder()
                .setMethodDescriptor(rescheduleMaintenanceMethodDescriptor)
                .setTypeRegistry(typeRegistry)
                .setParamsExtractor(
                    request -> {
                      RequestParamsBuilder builder = RequestParamsBuilder.create();
                      builder.add("instance", String.valueOf(request.getInstance()));
                      builder.add("project", String.valueOf(request.getProject()));
                      return builder.build();
                    })
                .setResourceNameExtractor(
                    request -> {
                      Map<String, String> resourceNameSegments = new HashMap<String, String>();
                      resourceNameSegments.put("instance", String.valueOf(request.getInstance()));
                      resourceNameSegments.put("project", String.valueOf(request.getProject()));
                      return RESCHEDULE_MAINTENANCE_RESOURCE_NAME_TEMPLATE.instantiate(
                          resourceNameSegments);
                    })
                .build();
    HttpJsonCallSettings<
            SqlInstancesVerifyExternalSyncSettingsRequest,
            SqlInstancesVerifyExternalSyncSettingsResponse>
        verifyExternalSyncSettingsTransportSettings =
            HttpJsonCallSettings
                .<SqlInstancesVerifyExternalSyncSettingsRequest,
                    SqlInstancesVerifyExternalSyncSettingsResponse>
                    newBuilder()
                .setMethodDescriptor(verifyExternalSyncSettingsMethodDescriptor)
                .setTypeRegistry(typeRegistry)
                .setParamsExtractor(
                    request -> {
                      RequestParamsBuilder builder = RequestParamsBuilder.create();
                      builder.add("instance", String.valueOf(request.getInstance()));
                      builder.add("project", String.valueOf(request.getProject()));
                      return builder.build();
                    })
                .setResourceNameExtractor(
                    request -> {
                      Map<String, String> resourceNameSegments = new HashMap<String, String>();
                      resourceNameSegments.put("instance", String.valueOf(request.getInstance()));
                      resourceNameSegments.put("project", String.valueOf(request.getProject()));
                      return VERIFY_EXTERNAL_SYNC_SETTINGS_RESOURCE_NAME_TEMPLATE.instantiate(
                          resourceNameSegments);
                    })
                .build();
    HttpJsonCallSettings<SqlInstancesStartExternalSyncRequest, Operation>
        startExternalSyncTransportSettings =
            HttpJsonCallSettings.<SqlInstancesStartExternalSyncRequest, Operation>newBuilder()
                .setMethodDescriptor(startExternalSyncMethodDescriptor)
                .setTypeRegistry(typeRegistry)
                .setParamsExtractor(
                    request -> {
                      RequestParamsBuilder builder = RequestParamsBuilder.create();
                      builder.add("instance", String.valueOf(request.getInstance()));
                      builder.add("project", String.valueOf(request.getProject()));
                      return builder.build();
                    })
                .setResourceNameExtractor(
                    request -> {
                      Map<String, String> resourceNameSegments = new HashMap<String, String>();
                      resourceNameSegments.put("instance", String.valueOf(request.getInstance()));
                      resourceNameSegments.put("project", String.valueOf(request.getProject()));
                      return START_EXTERNAL_SYNC_RESOURCE_NAME_TEMPLATE.instantiate(
                          resourceNameSegments);
                    })
                .build();
    HttpJsonCallSettings<SqlInstancesPerformDiskShrinkRequest, Operation>
        performDiskShrinkTransportSettings =
            HttpJsonCallSettings.<SqlInstancesPerformDiskShrinkRequest, Operation>newBuilder()
                .setMethodDescriptor(performDiskShrinkMethodDescriptor)
                .setTypeRegistry(typeRegistry)
                .setParamsExtractor(
                    request -> {
                      RequestParamsBuilder builder = RequestParamsBuilder.create();
                      builder.add("instance", String.valueOf(request.getInstance()));
                      builder.add("project", String.valueOf(request.getProject()));
                      return builder.build();
                    })
                .setResourceNameExtractor(
                    request -> {
                      Map<String, String> resourceNameSegments = new HashMap<String, String>();
                      resourceNameSegments.put("instance", String.valueOf(request.getInstance()));
                      resourceNameSegments.put("project", String.valueOf(request.getProject()));
                      return PERFORM_DISK_SHRINK_RESOURCE_NAME_TEMPLATE.instantiate(
                          resourceNameSegments);
                    })
                .build();
    HttpJsonCallSettings<
            SqlInstancesGetDiskShrinkConfigRequest, SqlInstancesGetDiskShrinkConfigResponse>
        getDiskShrinkConfigTransportSettings =
            HttpJsonCallSettings
                .<SqlInstancesGetDiskShrinkConfigRequest, SqlInstancesGetDiskShrinkConfigResponse>
                    newBuilder()
                .setMethodDescriptor(getDiskShrinkConfigMethodDescriptor)
                .setTypeRegistry(typeRegistry)
                .setParamsExtractor(
                    request -> {
                      RequestParamsBuilder builder = RequestParamsBuilder.create();
                      builder.add("instance", String.valueOf(request.getInstance()));
                      builder.add("project", String.valueOf(request.getProject()));
                      return builder.build();
                    })
                .setResourceNameExtractor(
                    request -> {
                      Map<String, String> resourceNameSegments = new HashMap<String, String>();
                      resourceNameSegments.put("instance", String.valueOf(request.getInstance()));
                      resourceNameSegments.put("project", String.valueOf(request.getProject()));
                      return GET_DISK_SHRINK_CONFIG_RESOURCE_NAME_TEMPLATE.instantiate(
                          resourceNameSegments);
                    })
                .build();
    HttpJsonCallSettings<SqlInstancesResetReplicaSizeRequest, Operation>
        resetReplicaSizeTransportSettings =
            HttpJsonCallSettings.<SqlInstancesResetReplicaSizeRequest, Operation>newBuilder()
                .setMethodDescriptor(resetReplicaSizeMethodDescriptor)
                .setTypeRegistry(typeRegistry)
                .setParamsExtractor(
                    request -> {
                      RequestParamsBuilder builder = RequestParamsBuilder.create();
                      builder.add("instance", String.valueOf(request.getInstance()));
                      builder.add("project", String.valueOf(request.getProject()));
                      return builder.build();
                    })
                .setResourceNameExtractor(
                    request -> {
                      Map<String, String> resourceNameSegments = new HashMap<String, String>();
                      resourceNameSegments.put("instance", String.valueOf(request.getInstance()));
                      resourceNameSegments.put("project", String.valueOf(request.getProject()));
                      return RESET_REPLICA_SIZE_RESOURCE_NAME_TEMPLATE.instantiate(
                          resourceNameSegments);
                    })
                .build();
    HttpJsonCallSettings<
            SqlInstancesGetLatestRecoveryTimeRequest, SqlInstancesGetLatestRecoveryTimeResponse>
        getLatestRecoveryTimeTransportSettings =
            HttpJsonCallSettings
                .<SqlInstancesGetLatestRecoveryTimeRequest,
                    SqlInstancesGetLatestRecoveryTimeResponse>
                    newBuilder()
                .setMethodDescriptor(getLatestRecoveryTimeMethodDescriptor)
                .setTypeRegistry(typeRegistry)
                .setParamsExtractor(
                    request -> {
                      RequestParamsBuilder builder = RequestParamsBuilder.create();
                      builder.add("instance", String.valueOf(request.getInstance()));
                      builder.add("project", String.valueOf(request.getProject()));
                      return builder.build();
                    })
                .setResourceNameExtractor(
                    request -> {
                      Map<String, String> resourceNameSegments = new HashMap<String, String>();
                      resourceNameSegments.put("instance", String.valueOf(request.getInstance()));
                      resourceNameSegments.put("project", String.valueOf(request.getProject()));
                      return GET_LATEST_RECOVERY_TIME_RESOURCE_NAME_TEMPLATE.instantiate(
                          resourceNameSegments);
                    })
                .build();
    HttpJsonCallSettings<SqlInstancesExecuteSqlRequest, SqlInstancesExecuteSqlResponse>
        executeSqlTransportSettings =
            HttpJsonCallSettings
                .<SqlInstancesExecuteSqlRequest, SqlInstancesExecuteSqlResponse>newBuilder()
                .setMethodDescriptor(executeSqlMethodDescriptor)
                .setTypeRegistry(typeRegistry)
                .setParamsExtractor(
                    request -> {
                      RequestParamsBuilder builder = RequestParamsBuilder.create();
                      builder.add("instance", String.valueOf(request.getInstance()));
                      builder.add("project", String.valueOf(request.getProject()));
                      return builder.build();
                    })
                .setResourceNameExtractor(
                    request -> {
                      Map<String, String> resourceNameSegments = new HashMap<String, String>();
                      resourceNameSegments.put("instance", String.valueOf(request.getInstance()));
                      resourceNameSegments.put("project", String.valueOf(request.getProject()));
                      return EXECUTE_SQL_RESOURCE_NAME_TEMPLATE.instantiate(resourceNameSegments);
                    })
                .build();
    HttpJsonCallSettings<SqlInstancesAcquireSsrsLeaseRequest, SqlInstancesAcquireSsrsLeaseResponse>
        acquireSsrsLeaseTransportSettings =
            HttpJsonCallSettings
                .<SqlInstancesAcquireSsrsLeaseRequest, SqlInstancesAcquireSsrsLeaseResponse>
                    newBuilder()
                .setMethodDescriptor(acquireSsrsLeaseMethodDescriptor)
                .setTypeRegistry(typeRegistry)
                .setParamsExtractor(
                    request -> {
                      RequestParamsBuilder builder = RequestParamsBuilder.create();
                      builder.add("instance", String.valueOf(request.getInstance()));
                      builder.add("project", String.valueOf(request.getProject()));
                      return builder.build();
                    })
                .setResourceNameExtractor(
                    request -> {
                      Map<String, String> resourceNameSegments = new HashMap<String, String>();
                      resourceNameSegments.put("instance", String.valueOf(request.getInstance()));
                      resourceNameSegments.put("project", String.valueOf(request.getProject()));
                      return ACQUIRE_SSRS_LEASE_RESOURCE_NAME_TEMPLATE.instantiate(
                          resourceNameSegments);
                    })
                .build();
    HttpJsonCallSettings<SqlInstancesReleaseSsrsLeaseRequest, SqlInstancesReleaseSsrsLeaseResponse>
        releaseSsrsLeaseTransportSettings =
            HttpJsonCallSettings
                .<SqlInstancesReleaseSsrsLeaseRequest, SqlInstancesReleaseSsrsLeaseResponse>
                    newBuilder()
                .setMethodDescriptor(releaseSsrsLeaseMethodDescriptor)
                .setTypeRegistry(typeRegistry)
                .setParamsExtractor(
                    request -> {
                      RequestParamsBuilder builder = RequestParamsBuilder.create();
                      builder.add("instance", String.valueOf(request.getInstance()));
                      builder.add("project", String.valueOf(request.getProject()));
                      return builder.build();
                    })
                .setResourceNameExtractor(
                    request -> {
                      Map<String, String> resourceNameSegments = new HashMap<String, String>();
                      resourceNameSegments.put("instance", String.valueOf(request.getInstance()));
                      resourceNameSegments.put("project", String.valueOf(request.getProject()));
                      return RELEASE_SSRS_LEASE_RESOURCE_NAME_TEMPLATE.instantiate(
                          resourceNameSegments);
                    })
                .build();
    HttpJsonCallSettings<SqlInstancesPreCheckMajorVersionUpgradeRequest, Operation>
        preCheckMajorVersionUpgradeTransportSettings =
            HttpJsonCallSettings
                .<SqlInstancesPreCheckMajorVersionUpgradeRequest, Operation>newBuilder()
                .setMethodDescriptor(preCheckMajorVersionUpgradeMethodDescriptor)
                .setTypeRegistry(typeRegistry)
                .setParamsExtractor(
                    request -> {
                      RequestParamsBuilder builder = RequestParamsBuilder.create();
                      builder.add("instance", String.valueOf(request.getInstance()));
                      builder.add("project", String.valueOf(request.getProject()));
                      return builder.build();
                    })
                .setResourceNameExtractor(
                    request -> {
                      Map<String, String> resourceNameSegments = new HashMap<String, String>();
                      resourceNameSegments.put("instance", String.valueOf(request.getInstance()));
                      resourceNameSegments.put("project", String.valueOf(request.getProject()));
                      return PRE_CHECK_MAJOR_VERSION_UPGRADE_RESOURCE_NAME_TEMPLATE.instantiate(
                          resourceNameSegments);
                    })
                .build();
    HttpJsonCallSettings<SqlInstancesPointInTimeRestoreRequest, Operation>
        pointInTimeRestoreTransportSettings =
            HttpJsonCallSettings.<SqlInstancesPointInTimeRestoreRequest, Operation>newBuilder()
                .setMethodDescriptor(pointInTimeRestoreMethodDescriptor)
                .setTypeRegistry(typeRegistry)
                .setParamsExtractor(
                    request -> {
                      RequestParamsBuilder builder = RequestParamsBuilder.create();
                      builder.add("parent", String.valueOf(request.getParent()));
                      return builder.build();
                    })
                .setResourceNameExtractor(
                    request -> {
                      Map<String, String> resourceNameSegments = new HashMap<String, String>();
                      resourceNameSegments.put("parent", String.valueOf(request.getParent()));
                      return POINT_IN_TIME_RESTORE_RESOURCE_NAME_TEMPLATE.instantiate(
                          resourceNameSegments);
                    })
                .build();

    this.addServerCaCallable =
        callableFactory.createUnaryCallable(
            addServerCaTransportSettings, settings.addServerCaSettings(), clientContext);
    this.addServerCertificateCallable =
        callableFactory.createUnaryCallable(
            addServerCertificateTransportSettings,
            settings.addServerCertificateSettings(),
            clientContext);
    this.addEntraIdCertificateCallable =
        callableFactory.createUnaryCallable(
            addEntraIdCertificateTransportSettings,
            settings.addEntraIdCertificateSettings(),
            clientContext);
    this.cloneCallable =
        callableFactory.createUnaryCallable(
            cloneTransportSettings, settings.cloneSettings(), clientContext);
    this.deleteCallable =
        callableFactory.createUnaryCallable(
            deleteTransportSettings, settings.deleteSettings(), clientContext);
    this.demoteMasterCallable =
        callableFactory.createUnaryCallable(
            demoteMasterTransportSettings, settings.demoteMasterSettings(), clientContext);
    this.demoteCallable =
        callableFactory.createUnaryCallable(
            demoteTransportSettings, settings.demoteSettings(), clientContext);
    this.exportCallable =
        callableFactory.createUnaryCallable(
            exportTransportSettings, settings.exportSettings(), clientContext);
    this.failoverCallable =
        callableFactory.createUnaryCallable(
            failoverTransportSettings, settings.failoverSettings(), clientContext);
    this.reencryptCallable =
        callableFactory.createUnaryCallable(
            reencryptTransportSettings, settings.reencryptSettings(), clientContext);
    this.getCallable =
        callableFactory.createUnaryCallable(
            getTransportSettings, settings.getSettings(), clientContext);
    this.import_Callable =
        callableFactory.createUnaryCallable(
            import_TransportSettings, settings.import_Settings(), clientContext);
    this.insertCallable =
        callableFactory.createUnaryCallable(
            insertTransportSettings, settings.insertSettings(), clientContext);
    this.listCallable =
        callableFactory.createUnaryCallable(
            listTransportSettings, settings.listSettings(), clientContext);
    this.listServerCasCallable =
        callableFactory.createUnaryCallable(
            listServerCasTransportSettings, settings.listServerCasSettings(), clientContext);
    this.listServerCertificatesCallable =
        callableFactory.createUnaryCallable(
            listServerCertificatesTransportSettings,
            settings.listServerCertificatesSettings(),
            clientContext);
    this.listEntraIdCertificatesCallable =
        callableFactory.createUnaryCallable(
            listEntraIdCertificatesTransportSettings,
            settings.listEntraIdCertificatesSettings(),
            clientContext);
    this.patchCallable =
        callableFactory.createUnaryCallable(
            patchTransportSettings, settings.patchSettings(), clientContext);
    this.promoteReplicaCallable =
        callableFactory.createUnaryCallable(
            promoteReplicaTransportSettings, settings.promoteReplicaSettings(), clientContext);
    this.switchoverCallable =
        callableFactory.createUnaryCallable(
            switchoverTransportSettings, settings.switchoverSettings(), clientContext);
    this.resetSslConfigCallable =
        callableFactory.createUnaryCallable(
            resetSslConfigTransportSettings, settings.resetSslConfigSettings(), clientContext);
    this.restartCallable =
        callableFactory.createUnaryCallable(
            restartTransportSettings, settings.restartSettings(), clientContext);
    this.restoreBackupCallable =
        callableFactory.createUnaryCallable(
            restoreBackupTransportSettings, settings.restoreBackupSettings(), clientContext);
    this.rotateServerCaCallable =
        callableFactory.createUnaryCallable(
            rotateServerCaTransportSettings, settings.rotateServerCaSettings(), clientContext);
    this.rotateServerCertificateCallable =
        callableFactory.createUnaryCallable(
            rotateServerCertificateTransportSettings,
            settings.rotateServerCertificateSettings(),
            clientContext);
    this.rotateEntraIdCertificateCallable =
        callableFactory.createUnaryCallable(
            rotateEntraIdCertificateTransportSettings,
            settings.rotateEntraIdCertificateSettings(),
            clientContext);
    this.startReplicaCallable =
        callableFactory.createUnaryCallable(
            startReplicaTransportSettings, settings.startReplicaSettings(), clientContext);
    this.stopReplicaCallable =
        callableFactory.createUnaryCallable(
            stopReplicaTransportSettings, settings.stopReplicaSettings(), clientContext);
    this.truncateLogCallable =
        callableFactory.createUnaryCallable(
            truncateLogTransportSettings, settings.truncateLogSettings(), clientContext);
    this.updateCallable =
        callableFactory.createUnaryCallable(
            updateTransportSettings, settings.updateSettings(), clientContext);
    this.createEphemeralCallable =
        callableFactory.createUnaryCallable(
            createEphemeralTransportSettings, settings.createEphemeralSettings(), clientContext);
    this.rescheduleMaintenanceCallable =
        callableFactory.createUnaryCallable(
            rescheduleMaintenanceTransportSettings,
            settings.rescheduleMaintenanceSettings(),
            clientContext);
    this.verifyExternalSyncSettingsCallable =
        callableFactory.createUnaryCallable(
            verifyExternalSyncSettingsTransportSettings,
            settings.verifyExternalSyncSettingsSettings(),
            clientContext);
    this.startExternalSyncCallable =
        callableFactory.createUnaryCallable(
            startExternalSyncTransportSettings,
            settings.startExternalSyncSettings(),
            clientContext);
    this.performDiskShrinkCallable =
        callableFactory.createUnaryCallable(
            performDiskShrinkTransportSettings,
            settings.performDiskShrinkSettings(),
            clientContext);
    this.getDiskShrinkConfigCallable =
        callableFactory.createUnaryCallable(
            getDiskShrinkConfigTransportSettings,
            settings.getDiskShrinkConfigSettings(),
            clientContext);
    this.resetReplicaSizeCallable =
        callableFactory.createUnaryCallable(
            resetReplicaSizeTransportSettings, settings.resetReplicaSizeSettings(), clientContext);
    this.getLatestRecoveryTimeCallable =
        callableFactory.createUnaryCallable(
            getLatestRecoveryTimeTransportSettings,
            settings.getLatestRecoveryTimeSettings(),
            clientContext);
    this.executeSqlCallable =
        callableFactory.createUnaryCallable(
            executeSqlTransportSettings, settings.executeSqlSettings(), clientContext);
    this.acquireSsrsLeaseCallable =
        callableFactory.createUnaryCallable(
            acquireSsrsLeaseTransportSettings, settings.acquireSsrsLeaseSettings(), clientContext);
    this.releaseSsrsLeaseCallable =
        callableFactory.createUnaryCallable(
            releaseSsrsLeaseTransportSettings, settings.releaseSsrsLeaseSettings(), clientContext);
    this.preCheckMajorVersionUpgradeCallable =
        callableFactory.createUnaryCallable(
            preCheckMajorVersionUpgradeTransportSettings,
            settings.preCheckMajorVersionUpgradeSettings(),
            clientContext);
    this.pointInTimeRestoreCallable =
        callableFactory.createUnaryCallable(
            pointInTimeRestoreTransportSettings,
            settings.pointInTimeRestoreSettings(),
            clientContext);

    this.backgroundResources =
        new BackgroundResourceAggregation(clientContext.getBackgroundResources());
  }

  @InternalApi
  public static List<ApiMethodDescriptor> getMethodDescriptors() {
    List<ApiMethodDescriptor> methodDescriptors = new ArrayList<>();
    methodDescriptors.add(addServerCaMethodDescriptor);
    methodDescriptors.add(addServerCertificateMethodDescriptor);
    methodDescriptors.add(addEntraIdCertificateMethodDescriptor);
    methodDescriptors.add(cloneMethodDescriptor);
    methodDescriptors.add(deleteMethodDescriptor);
    methodDescriptors.add(demoteMasterMethodDescriptor);
    methodDescriptors.add(demoteMethodDescriptor);
    methodDescriptors.add(exportMethodDescriptor);
    methodDescriptors.add(failoverMethodDescriptor);
    methodDescriptors.add(reencryptMethodDescriptor);
    methodDescriptors.add(getMethodDescriptor);
    methodDescriptors.add(import_MethodDescriptor);
    methodDescriptors.add(insertMethodDescriptor);
    methodDescriptors.add(listMethodDescriptor);
    methodDescriptors.add(listServerCasMethodDescriptor);
    methodDescriptors.add(listServerCertificatesMethodDescriptor);
    methodDescriptors.add(listEntraIdCertificatesMethodDescriptor);
    methodDescriptors.add(patchMethodDescriptor);
    methodDescriptors.add(promoteReplicaMethodDescriptor);
    methodDescriptors.add(switchoverMethodDescriptor);
    methodDescriptors.add(resetSslConfigMethodDescriptor);
    methodDescriptors.add(restartMethodDescriptor);
    methodDescriptors.add(restoreBackupMethodDescriptor);
    methodDescriptors.add(rotateServerCaMethodDescriptor);
    methodDescriptors.add(rotateServerCertificateMethodDescriptor);
    methodDescriptors.add(rotateEntraIdCertificateMethodDescriptor);
    methodDescriptors.add(startReplicaMethodDescriptor);
    methodDescriptors.add(stopReplicaMethodDescriptor);
    methodDescriptors.add(truncateLogMethodDescriptor);
    methodDescriptors.add(updateMethodDescriptor);
    methodDescriptors.add(createEphemeralMethodDescriptor);
    methodDescriptors.add(rescheduleMaintenanceMethodDescriptor);
    methodDescriptors.add(verifyExternalSyncSettingsMethodDescriptor);
    methodDescriptors.add(startExternalSyncMethodDescriptor);
    methodDescriptors.add(performDiskShrinkMethodDescriptor);
    methodDescriptors.add(getDiskShrinkConfigMethodDescriptor);
    methodDescriptors.add(resetReplicaSizeMethodDescriptor);
    methodDescriptors.add(getLatestRecoveryTimeMethodDescriptor);
    methodDescriptors.add(executeSqlMethodDescriptor);
    methodDescriptors.add(acquireSsrsLeaseMethodDescriptor);
    methodDescriptors.add(releaseSsrsLeaseMethodDescriptor);
    methodDescriptors.add(preCheckMajorVersionUpgradeMethodDescriptor);
    methodDescriptors.add(pointInTimeRestoreMethodDescriptor);
    return methodDescriptors;
  }

  @Override
  public UnaryCallable<SqlInstancesAddServerCaRequest, Operation> addServerCaCallable() {
    return addServerCaCallable;
  }

  @Override
  public UnaryCallable<SqlInstancesAddServerCertificateRequest, Operation>
      addServerCertificateCallable() {
    return addServerCertificateCallable;
  }

  @Override
  public UnaryCallable<SqlInstancesAddEntraIdCertificateRequest, Operation>
      addEntraIdCertificateCallable() {
    return addEntraIdCertificateCallable;
  }

  @Override
  public UnaryCallable<SqlInstancesCloneRequest, Operation> cloneCallable() {
    return cloneCallable;
  }

  @Override
  public UnaryCallable<SqlInstancesDeleteRequest, Operation> deleteCallable() {
    return deleteCallable;
  }

  @Override
  public UnaryCallable<SqlInstancesDemoteMasterRequest, Operation> demoteMasterCallable() {
    return demoteMasterCallable;
  }

  @Override
  public UnaryCallable<SqlInstancesDemoteRequest, Operation> demoteCallable() {
    return demoteCallable;
  }

  @Override
  public UnaryCallable<SqlInstancesExportRequest, Operation> exportCallable() {
    return exportCallable;
  }

  @Override
  public UnaryCallable<SqlInstancesFailoverRequest, Operation> failoverCallable() {
    return failoverCallable;
  }

  @Override
  public UnaryCallable<SqlInstancesReencryptRequest, Operation> reencryptCallable() {
    return reencryptCallable;
  }

  @Override
  public UnaryCallable<SqlInstancesGetRequest, DatabaseInstance> getCallable() {
    return getCallable;
  }

  @Override
  public UnaryCallable<SqlInstancesImportRequest, Operation> import_Callable() {
    return import_Callable;
  }

  @Override
  public UnaryCallable<SqlInstancesInsertRequest, Operation> insertCallable() {
    return insertCallable;
  }

  @Override
  public UnaryCallable<SqlInstancesListRequest, InstancesListResponse> listCallable() {
    return listCallable;
  }

  @Override
  public UnaryCallable<SqlInstancesListServerCasRequest, InstancesListServerCasResponse>
      listServerCasCallable() {
    return listServerCasCallable;
  }

  @Override
  public UnaryCallable<
          SqlInstancesListServerCertificatesRequest, InstancesListServerCertificatesResponse>
      listServerCertificatesCallable() {
    return listServerCertificatesCallable;
  }

  @Override
  public UnaryCallable<
          SqlInstancesListEntraIdCertificatesRequest, InstancesListEntraIdCertificatesResponse>
      listEntraIdCertificatesCallable() {
    return listEntraIdCertificatesCallable;
  }

  @Override
  public UnaryCallable<SqlInstancesPatchRequest, Operation> patchCallable() {
    return patchCallable;
  }

  @Override
  public UnaryCallable<SqlInstancesPromoteReplicaRequest, Operation> promoteReplicaCallable() {
    return promoteReplicaCallable;
  }

  @Override
  public UnaryCallable<SqlInstancesSwitchoverRequest, Operation> switchoverCallable() {
    return switchoverCallable;
  }

  @Override
  public UnaryCallable<SqlInstancesResetSslConfigRequest, Operation> resetSslConfigCallable() {
    return resetSslConfigCallable;
  }

  @Override
  public UnaryCallable<SqlInstancesRestartRequest, Operation> restartCallable() {
    return restartCallable;
  }

  @Override
  public UnaryCallable<SqlInstancesRestoreBackupRequest, Operation> restoreBackupCallable() {
    return restoreBackupCallable;
  }

  @Override
  public UnaryCallable<SqlInstancesRotateServerCaRequest, Operation> rotateServerCaCallable() {
    return rotateServerCaCallable;
  }

  @Override
  public UnaryCallable<SqlInstancesRotateServerCertificateRequest, Operation>
      rotateServerCertificateCallable() {
    return rotateServerCertificateCallable;
  }

  @Override
  public UnaryCallable<SqlInstancesRotateEntraIdCertificateRequest, Operation>
      rotateEntraIdCertificateCallable() {
    return rotateEntraIdCertificateCallable;
  }

  @Override
  public UnaryCallable<SqlInstancesStartReplicaRequest, Operation> startReplicaCallable() {
    return startReplicaCallable;
  }

  @Override
  public UnaryCallable<SqlInstancesStopReplicaRequest, Operation> stopReplicaCallable() {
    return stopReplicaCallable;
  }

  @Override
  public UnaryCallable<SqlInstancesTruncateLogRequest, Operation> truncateLogCallable() {
    return truncateLogCallable;
  }

  @Override
  public UnaryCallable<SqlInstancesUpdateRequest, Operation> updateCallable() {
    return updateCallable;
  }

  @Override
  public UnaryCallable<SqlInstancesCreateEphemeralCertRequest, SslCert> createEphemeralCallable() {
    return createEphemeralCallable;
  }

  @Override
  public UnaryCallable<SqlInstancesRescheduleMaintenanceRequest, Operation>
      rescheduleMaintenanceCallable() {
    return rescheduleMaintenanceCallable;
  }

  @Override
  public UnaryCallable<
          SqlInstancesVerifyExternalSyncSettingsRequest,
          SqlInstancesVerifyExternalSyncSettingsResponse>
      verifyExternalSyncSettingsCallable() {
    return verifyExternalSyncSettingsCallable;
  }

  @Override
  public UnaryCallable<SqlInstancesStartExternalSyncRequest, Operation>
      startExternalSyncCallable() {
    return startExternalSyncCallable;
  }

  @Override
  public UnaryCallable<SqlInstancesPerformDiskShrinkRequest, Operation>
      performDiskShrinkCallable() {
    return performDiskShrinkCallable;
  }

  @Override
  public UnaryCallable<
          SqlInstancesGetDiskShrinkConfigRequest, SqlInstancesGetDiskShrinkConfigResponse>
      getDiskShrinkConfigCallable() {
    return getDiskShrinkConfigCallable;
  }

  @Override
  public UnaryCallable<SqlInstancesResetReplicaSizeRequest, Operation> resetReplicaSizeCallable() {
    return resetReplicaSizeCallable;
  }

  @Override
  public UnaryCallable<
          SqlInstancesGetLatestRecoveryTimeRequest, SqlInstancesGetLatestRecoveryTimeResponse>
      getLatestRecoveryTimeCallable() {
    return getLatestRecoveryTimeCallable;
  }

  @Override
  public UnaryCallable<SqlInstancesExecuteSqlRequest, SqlInstancesExecuteSqlResponse>
      executeSqlCallable() {
    return executeSqlCallable;
  }

  @Override
  public UnaryCallable<SqlInstancesAcquireSsrsLeaseRequest, SqlInstancesAcquireSsrsLeaseResponse>
      acquireSsrsLeaseCallable() {
    return acquireSsrsLeaseCallable;
  }

  @Override
  public UnaryCallable<SqlInstancesReleaseSsrsLeaseRequest, SqlInstancesReleaseSsrsLeaseResponse>
      releaseSsrsLeaseCallable() {
    return releaseSsrsLeaseCallable;
  }

  @Override
  public UnaryCallable<SqlInstancesPreCheckMajorVersionUpgradeRequest, Operation>
      preCheckMajorVersionUpgradeCallable() {
    return preCheckMajorVersionUpgradeCallable;
  }

  @Override
  public UnaryCallable<SqlInstancesPointInTimeRestoreRequest, Operation>
      pointInTimeRestoreCallable() {
    return pointInTimeRestoreCallable;
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
