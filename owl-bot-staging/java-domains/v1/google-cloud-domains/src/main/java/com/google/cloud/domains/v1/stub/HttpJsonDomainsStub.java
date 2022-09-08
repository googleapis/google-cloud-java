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

package com.google.cloud.domains.v1.stub;

import static com.google.cloud.domains.v1.DomainsClient.ListRegistrationsPagedResponse;

import com.google.api.core.BetaApi;
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
import com.google.api.gax.longrunning.OperationSnapshot;
import com.google.api.gax.rpc.ClientContext;
import com.google.api.gax.rpc.OperationCallable;
import com.google.api.gax.rpc.UnaryCallable;
import com.google.cloud.domains.v1.AuthorizationCode;
import com.google.cloud.domains.v1.ConfigureContactSettingsRequest;
import com.google.cloud.domains.v1.ConfigureDnsSettingsRequest;
import com.google.cloud.domains.v1.ConfigureManagementSettingsRequest;
import com.google.cloud.domains.v1.DeleteRegistrationRequest;
import com.google.cloud.domains.v1.ExportRegistrationRequest;
import com.google.cloud.domains.v1.GetRegistrationRequest;
import com.google.cloud.domains.v1.ListRegistrationsRequest;
import com.google.cloud.domains.v1.ListRegistrationsResponse;
import com.google.cloud.domains.v1.OperationMetadata;
import com.google.cloud.domains.v1.RegisterDomainRequest;
import com.google.cloud.domains.v1.Registration;
import com.google.cloud.domains.v1.ResetAuthorizationCodeRequest;
import com.google.cloud.domains.v1.RetrieveAuthorizationCodeRequest;
import com.google.cloud.domains.v1.RetrieveRegisterParametersRequest;
import com.google.cloud.domains.v1.RetrieveRegisterParametersResponse;
import com.google.cloud.domains.v1.RetrieveTransferParametersRequest;
import com.google.cloud.domains.v1.RetrieveTransferParametersResponse;
import com.google.cloud.domains.v1.SearchDomainsRequest;
import com.google.cloud.domains.v1.SearchDomainsResponse;
import com.google.cloud.domains.v1.TransferDomainRequest;
import com.google.cloud.domains.v1.UpdateRegistrationRequest;
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

// AUTO-GENERATED DOCUMENTATION AND CLASS.
/**
 * REST stub implementation for the Domains service API.
 *
 * <p>This class is for advanced usage and reflects the underlying API directly.
 */
@Generated("by gapic-generator-java")
@BetaApi
public class HttpJsonDomainsStub extends DomainsStub {
  private static final TypeRegistry typeRegistry =
      TypeRegistry.newBuilder()
          .add(OperationMetadata.getDescriptor())
          .add(Empty.getDescriptor())
          .add(Registration.getDescriptor())
          .build();

  private static final ApiMethodDescriptor<SearchDomainsRequest, SearchDomainsResponse>
      searchDomainsMethodDescriptor =
          ApiMethodDescriptor.<SearchDomainsRequest, SearchDomainsResponse>newBuilder()
              .setFullMethodName("google.cloud.domains.v1.Domains/SearchDomains")
              .setHttpMethod("GET")
              .setType(ApiMethodDescriptor.MethodType.UNARY)
              .setRequestFormatter(
                  ProtoMessageRequestFormatter.<SearchDomainsRequest>newBuilder()
                      .setPath(
                          "/v1/{location=projects/*/locations/*}/registrations:searchDomains",
                          request -> {
                            Map<String, String> fields = new HashMap<>();
                            ProtoRestSerializer<SearchDomainsRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putPathParam(fields, "location", request.getLocation());
                            return fields;
                          })
                      .setQueryParamsExtractor(
                          request -> {
                            Map<String, List<String>> fields = new HashMap<>();
                            ProtoRestSerializer<SearchDomainsRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putQueryParam(fields, "query", request.getQuery());
                            return fields;
                          })
                      .setRequestBodyExtractor(request -> null)
                      .build())
              .setResponseParser(
                  ProtoMessageResponseParser.<SearchDomainsResponse>newBuilder()
                      .setDefaultInstance(SearchDomainsResponse.getDefaultInstance())
                      .setDefaultTypeRegistry(typeRegistry)
                      .build())
              .build();

  private static final ApiMethodDescriptor<
          RetrieveRegisterParametersRequest, RetrieveRegisterParametersResponse>
      retrieveRegisterParametersMethodDescriptor =
          ApiMethodDescriptor
              .<RetrieveRegisterParametersRequest, RetrieveRegisterParametersResponse>newBuilder()
              .setFullMethodName("google.cloud.domains.v1.Domains/RetrieveRegisterParameters")
              .setHttpMethod("GET")
              .setType(ApiMethodDescriptor.MethodType.UNARY)
              .setRequestFormatter(
                  ProtoMessageRequestFormatter.<RetrieveRegisterParametersRequest>newBuilder()
                      .setPath(
                          "/v1/{location=projects/*/locations/*}/registrations:retrieveRegisterParameters",
                          request -> {
                            Map<String, String> fields = new HashMap<>();
                            ProtoRestSerializer<RetrieveRegisterParametersRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putPathParam(fields, "location", request.getLocation());
                            return fields;
                          })
                      .setQueryParamsExtractor(
                          request -> {
                            Map<String, List<String>> fields = new HashMap<>();
                            ProtoRestSerializer<RetrieveRegisterParametersRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putQueryParam(fields, "domainName", request.getDomainName());
                            return fields;
                          })
                      .setRequestBodyExtractor(request -> null)
                      .build())
              .setResponseParser(
                  ProtoMessageResponseParser.<RetrieveRegisterParametersResponse>newBuilder()
                      .setDefaultInstance(RetrieveRegisterParametersResponse.getDefaultInstance())
                      .setDefaultTypeRegistry(typeRegistry)
                      .build())
              .build();

  private static final ApiMethodDescriptor<RegisterDomainRequest, Operation>
      registerDomainMethodDescriptor =
          ApiMethodDescriptor.<RegisterDomainRequest, Operation>newBuilder()
              .setFullMethodName("google.cloud.domains.v1.Domains/RegisterDomain")
              .setHttpMethod("POST")
              .setType(ApiMethodDescriptor.MethodType.UNARY)
              .setRequestFormatter(
                  ProtoMessageRequestFormatter.<RegisterDomainRequest>newBuilder()
                      .setPath(
                          "/v1/{parent=projects/*/locations/*}/registrations:register",
                          request -> {
                            Map<String, String> fields = new HashMap<>();
                            ProtoRestSerializer<RegisterDomainRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putPathParam(fields, "parent", request.getParent());
                            return fields;
                          })
                      .setQueryParamsExtractor(
                          request -> {
                            Map<String, List<String>> fields = new HashMap<>();
                            ProtoRestSerializer<RegisterDomainRequest> serializer =
                                ProtoRestSerializer.create();
                            return fields;
                          })
                      .setRequestBodyExtractor(
                          request ->
                              ProtoRestSerializer.create()
                                  .toBody("*", request.toBuilder().clearParent().build(), false))
                      .build())
              .setResponseParser(
                  ProtoMessageResponseParser.<Operation>newBuilder()
                      .setDefaultInstance(Operation.getDefaultInstance())
                      .setDefaultTypeRegistry(typeRegistry)
                      .build())
              .setOperationSnapshotFactory(
                  (RegisterDomainRequest request, Operation response) ->
                      HttpJsonOperationSnapshot.create(response))
              .build();

  private static final ApiMethodDescriptor<
          RetrieveTransferParametersRequest, RetrieveTransferParametersResponse>
      retrieveTransferParametersMethodDescriptor =
          ApiMethodDescriptor
              .<RetrieveTransferParametersRequest, RetrieveTransferParametersResponse>newBuilder()
              .setFullMethodName("google.cloud.domains.v1.Domains/RetrieveTransferParameters")
              .setHttpMethod("GET")
              .setType(ApiMethodDescriptor.MethodType.UNARY)
              .setRequestFormatter(
                  ProtoMessageRequestFormatter.<RetrieveTransferParametersRequest>newBuilder()
                      .setPath(
                          "/v1/{location=projects/*/locations/*}/registrations:retrieveTransferParameters",
                          request -> {
                            Map<String, String> fields = new HashMap<>();
                            ProtoRestSerializer<RetrieveTransferParametersRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putPathParam(fields, "location", request.getLocation());
                            return fields;
                          })
                      .setQueryParamsExtractor(
                          request -> {
                            Map<String, List<String>> fields = new HashMap<>();
                            ProtoRestSerializer<RetrieveTransferParametersRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putQueryParam(fields, "domainName", request.getDomainName());
                            return fields;
                          })
                      .setRequestBodyExtractor(request -> null)
                      .build())
              .setResponseParser(
                  ProtoMessageResponseParser.<RetrieveTransferParametersResponse>newBuilder()
                      .setDefaultInstance(RetrieveTransferParametersResponse.getDefaultInstance())
                      .setDefaultTypeRegistry(typeRegistry)
                      .build())
              .build();

  private static final ApiMethodDescriptor<TransferDomainRequest, Operation>
      transferDomainMethodDescriptor =
          ApiMethodDescriptor.<TransferDomainRequest, Operation>newBuilder()
              .setFullMethodName("google.cloud.domains.v1.Domains/TransferDomain")
              .setHttpMethod("POST")
              .setType(ApiMethodDescriptor.MethodType.UNARY)
              .setRequestFormatter(
                  ProtoMessageRequestFormatter.<TransferDomainRequest>newBuilder()
                      .setPath(
                          "/v1/{parent=projects/*/locations/*}/registrations:transfer",
                          request -> {
                            Map<String, String> fields = new HashMap<>();
                            ProtoRestSerializer<TransferDomainRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putPathParam(fields, "parent", request.getParent());
                            return fields;
                          })
                      .setQueryParamsExtractor(
                          request -> {
                            Map<String, List<String>> fields = new HashMap<>();
                            ProtoRestSerializer<TransferDomainRequest> serializer =
                                ProtoRestSerializer.create();
                            return fields;
                          })
                      .setRequestBodyExtractor(
                          request ->
                              ProtoRestSerializer.create()
                                  .toBody("*", request.toBuilder().clearParent().build(), false))
                      .build())
              .setResponseParser(
                  ProtoMessageResponseParser.<Operation>newBuilder()
                      .setDefaultInstance(Operation.getDefaultInstance())
                      .setDefaultTypeRegistry(typeRegistry)
                      .build())
              .setOperationSnapshotFactory(
                  (TransferDomainRequest request, Operation response) ->
                      HttpJsonOperationSnapshot.create(response))
              .build();

  private static final ApiMethodDescriptor<ListRegistrationsRequest, ListRegistrationsResponse>
      listRegistrationsMethodDescriptor =
          ApiMethodDescriptor.<ListRegistrationsRequest, ListRegistrationsResponse>newBuilder()
              .setFullMethodName("google.cloud.domains.v1.Domains/ListRegistrations")
              .setHttpMethod("GET")
              .setType(ApiMethodDescriptor.MethodType.UNARY)
              .setRequestFormatter(
                  ProtoMessageRequestFormatter.<ListRegistrationsRequest>newBuilder()
                      .setPath(
                          "/v1/{parent=projects/*/locations/*}/registrations",
                          request -> {
                            Map<String, String> fields = new HashMap<>();
                            ProtoRestSerializer<ListRegistrationsRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putPathParam(fields, "parent", request.getParent());
                            return fields;
                          })
                      .setQueryParamsExtractor(
                          request -> {
                            Map<String, List<String>> fields = new HashMap<>();
                            ProtoRestSerializer<ListRegistrationsRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putQueryParam(fields, "filter", request.getFilter());
                            serializer.putQueryParam(fields, "pageSize", request.getPageSize());
                            serializer.putQueryParam(fields, "pageToken", request.getPageToken());
                            return fields;
                          })
                      .setRequestBodyExtractor(request -> null)
                      .build())
              .setResponseParser(
                  ProtoMessageResponseParser.<ListRegistrationsResponse>newBuilder()
                      .setDefaultInstance(ListRegistrationsResponse.getDefaultInstance())
                      .setDefaultTypeRegistry(typeRegistry)
                      .build())
              .build();

  private static final ApiMethodDescriptor<GetRegistrationRequest, Registration>
      getRegistrationMethodDescriptor =
          ApiMethodDescriptor.<GetRegistrationRequest, Registration>newBuilder()
              .setFullMethodName("google.cloud.domains.v1.Domains/GetRegistration")
              .setHttpMethod("GET")
              .setType(ApiMethodDescriptor.MethodType.UNARY)
              .setRequestFormatter(
                  ProtoMessageRequestFormatter.<GetRegistrationRequest>newBuilder()
                      .setPath(
                          "/v1/{name=projects/*/locations/*/registrations/*}",
                          request -> {
                            Map<String, String> fields = new HashMap<>();
                            ProtoRestSerializer<GetRegistrationRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putPathParam(fields, "name", request.getName());
                            return fields;
                          })
                      .setQueryParamsExtractor(
                          request -> {
                            Map<String, List<String>> fields = new HashMap<>();
                            ProtoRestSerializer<GetRegistrationRequest> serializer =
                                ProtoRestSerializer.create();
                            return fields;
                          })
                      .setRequestBodyExtractor(request -> null)
                      .build())
              .setResponseParser(
                  ProtoMessageResponseParser.<Registration>newBuilder()
                      .setDefaultInstance(Registration.getDefaultInstance())
                      .setDefaultTypeRegistry(typeRegistry)
                      .build())
              .build();

  private static final ApiMethodDescriptor<UpdateRegistrationRequest, Operation>
      updateRegistrationMethodDescriptor =
          ApiMethodDescriptor.<UpdateRegistrationRequest, Operation>newBuilder()
              .setFullMethodName("google.cloud.domains.v1.Domains/UpdateRegistration")
              .setHttpMethod("PATCH")
              .setType(ApiMethodDescriptor.MethodType.UNARY)
              .setRequestFormatter(
                  ProtoMessageRequestFormatter.<UpdateRegistrationRequest>newBuilder()
                      .setPath(
                          "/v1/{registration.name=projects/*/locations/*/registrations/*}",
                          request -> {
                            Map<String, String> fields = new HashMap<>();
                            ProtoRestSerializer<UpdateRegistrationRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putPathParam(
                                fields, "registration.name", request.getRegistration().getName());
                            return fields;
                          })
                      .setQueryParamsExtractor(
                          request -> {
                            Map<String, List<String>> fields = new HashMap<>();
                            ProtoRestSerializer<UpdateRegistrationRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putQueryParam(fields, "updateMask", request.getUpdateMask());
                            return fields;
                          })
                      .setRequestBodyExtractor(
                          request ->
                              ProtoRestSerializer.create()
                                  .toBody("registration", request.getRegistration(), false))
                      .build())
              .setResponseParser(
                  ProtoMessageResponseParser.<Operation>newBuilder()
                      .setDefaultInstance(Operation.getDefaultInstance())
                      .setDefaultTypeRegistry(typeRegistry)
                      .build())
              .setOperationSnapshotFactory(
                  (UpdateRegistrationRequest request, Operation response) ->
                      HttpJsonOperationSnapshot.create(response))
              .build();

  private static final ApiMethodDescriptor<ConfigureManagementSettingsRequest, Operation>
      configureManagementSettingsMethodDescriptor =
          ApiMethodDescriptor.<ConfigureManagementSettingsRequest, Operation>newBuilder()
              .setFullMethodName("google.cloud.domains.v1.Domains/ConfigureManagementSettings")
              .setHttpMethod("POST")
              .setType(ApiMethodDescriptor.MethodType.UNARY)
              .setRequestFormatter(
                  ProtoMessageRequestFormatter.<ConfigureManagementSettingsRequest>newBuilder()
                      .setPath(
                          "/v1/{registration=projects/*/locations/*/registrations/*}:configureManagementSettings",
                          request -> {
                            Map<String, String> fields = new HashMap<>();
                            ProtoRestSerializer<ConfigureManagementSettingsRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putPathParam(
                                fields, "registration", request.getRegistration());
                            return fields;
                          })
                      .setQueryParamsExtractor(
                          request -> {
                            Map<String, List<String>> fields = new HashMap<>();
                            ProtoRestSerializer<ConfigureManagementSettingsRequest> serializer =
                                ProtoRestSerializer.create();
                            return fields;
                          })
                      .setRequestBodyExtractor(
                          request ->
                              ProtoRestSerializer.create()
                                  .toBody(
                                      "*", request.toBuilder().clearRegistration().build(), false))
                      .build())
              .setResponseParser(
                  ProtoMessageResponseParser.<Operation>newBuilder()
                      .setDefaultInstance(Operation.getDefaultInstance())
                      .setDefaultTypeRegistry(typeRegistry)
                      .build())
              .setOperationSnapshotFactory(
                  (ConfigureManagementSettingsRequest request, Operation response) ->
                      HttpJsonOperationSnapshot.create(response))
              .build();

  private static final ApiMethodDescriptor<ConfigureDnsSettingsRequest, Operation>
      configureDnsSettingsMethodDescriptor =
          ApiMethodDescriptor.<ConfigureDnsSettingsRequest, Operation>newBuilder()
              .setFullMethodName("google.cloud.domains.v1.Domains/ConfigureDnsSettings")
              .setHttpMethod("POST")
              .setType(ApiMethodDescriptor.MethodType.UNARY)
              .setRequestFormatter(
                  ProtoMessageRequestFormatter.<ConfigureDnsSettingsRequest>newBuilder()
                      .setPath(
                          "/v1/{registration=projects/*/locations/*/registrations/*}:configureDnsSettings",
                          request -> {
                            Map<String, String> fields = new HashMap<>();
                            ProtoRestSerializer<ConfigureDnsSettingsRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putPathParam(
                                fields, "registration", request.getRegistration());
                            return fields;
                          })
                      .setQueryParamsExtractor(
                          request -> {
                            Map<String, List<String>> fields = new HashMap<>();
                            ProtoRestSerializer<ConfigureDnsSettingsRequest> serializer =
                                ProtoRestSerializer.create();
                            return fields;
                          })
                      .setRequestBodyExtractor(
                          request ->
                              ProtoRestSerializer.create()
                                  .toBody(
                                      "*", request.toBuilder().clearRegistration().build(), false))
                      .build())
              .setResponseParser(
                  ProtoMessageResponseParser.<Operation>newBuilder()
                      .setDefaultInstance(Operation.getDefaultInstance())
                      .setDefaultTypeRegistry(typeRegistry)
                      .build())
              .setOperationSnapshotFactory(
                  (ConfigureDnsSettingsRequest request, Operation response) ->
                      HttpJsonOperationSnapshot.create(response))
              .build();

  private static final ApiMethodDescriptor<ConfigureContactSettingsRequest, Operation>
      configureContactSettingsMethodDescriptor =
          ApiMethodDescriptor.<ConfigureContactSettingsRequest, Operation>newBuilder()
              .setFullMethodName("google.cloud.domains.v1.Domains/ConfigureContactSettings")
              .setHttpMethod("POST")
              .setType(ApiMethodDescriptor.MethodType.UNARY)
              .setRequestFormatter(
                  ProtoMessageRequestFormatter.<ConfigureContactSettingsRequest>newBuilder()
                      .setPath(
                          "/v1/{registration=projects/*/locations/*/registrations/*}:configureContactSettings",
                          request -> {
                            Map<String, String> fields = new HashMap<>();
                            ProtoRestSerializer<ConfigureContactSettingsRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putPathParam(
                                fields, "registration", request.getRegistration());
                            return fields;
                          })
                      .setQueryParamsExtractor(
                          request -> {
                            Map<String, List<String>> fields = new HashMap<>();
                            ProtoRestSerializer<ConfigureContactSettingsRequest> serializer =
                                ProtoRestSerializer.create();
                            return fields;
                          })
                      .setRequestBodyExtractor(
                          request ->
                              ProtoRestSerializer.create()
                                  .toBody(
                                      "*", request.toBuilder().clearRegistration().build(), false))
                      .build())
              .setResponseParser(
                  ProtoMessageResponseParser.<Operation>newBuilder()
                      .setDefaultInstance(Operation.getDefaultInstance())
                      .setDefaultTypeRegistry(typeRegistry)
                      .build())
              .setOperationSnapshotFactory(
                  (ConfigureContactSettingsRequest request, Operation response) ->
                      HttpJsonOperationSnapshot.create(response))
              .build();

  private static final ApiMethodDescriptor<ExportRegistrationRequest, Operation>
      exportRegistrationMethodDescriptor =
          ApiMethodDescriptor.<ExportRegistrationRequest, Operation>newBuilder()
              .setFullMethodName("google.cloud.domains.v1.Domains/ExportRegistration")
              .setHttpMethod("POST")
              .setType(ApiMethodDescriptor.MethodType.UNARY)
              .setRequestFormatter(
                  ProtoMessageRequestFormatter.<ExportRegistrationRequest>newBuilder()
                      .setPath(
                          "/v1/{name=projects/*/locations/*/registrations/*}:export",
                          request -> {
                            Map<String, String> fields = new HashMap<>();
                            ProtoRestSerializer<ExportRegistrationRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putPathParam(fields, "name", request.getName());
                            return fields;
                          })
                      .setQueryParamsExtractor(
                          request -> {
                            Map<String, List<String>> fields = new HashMap<>();
                            ProtoRestSerializer<ExportRegistrationRequest> serializer =
                                ProtoRestSerializer.create();
                            return fields;
                          })
                      .setRequestBodyExtractor(
                          request ->
                              ProtoRestSerializer.create()
                                  .toBody("*", request.toBuilder().clearName().build(), false))
                      .build())
              .setResponseParser(
                  ProtoMessageResponseParser.<Operation>newBuilder()
                      .setDefaultInstance(Operation.getDefaultInstance())
                      .setDefaultTypeRegistry(typeRegistry)
                      .build())
              .setOperationSnapshotFactory(
                  (ExportRegistrationRequest request, Operation response) ->
                      HttpJsonOperationSnapshot.create(response))
              .build();

  private static final ApiMethodDescriptor<DeleteRegistrationRequest, Operation>
      deleteRegistrationMethodDescriptor =
          ApiMethodDescriptor.<DeleteRegistrationRequest, Operation>newBuilder()
              .setFullMethodName("google.cloud.domains.v1.Domains/DeleteRegistration")
              .setHttpMethod("DELETE")
              .setType(ApiMethodDescriptor.MethodType.UNARY)
              .setRequestFormatter(
                  ProtoMessageRequestFormatter.<DeleteRegistrationRequest>newBuilder()
                      .setPath(
                          "/v1/{name=projects/*/locations/*/registrations/*}",
                          request -> {
                            Map<String, String> fields = new HashMap<>();
                            ProtoRestSerializer<DeleteRegistrationRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putPathParam(fields, "name", request.getName());
                            return fields;
                          })
                      .setQueryParamsExtractor(
                          request -> {
                            Map<String, List<String>> fields = new HashMap<>();
                            ProtoRestSerializer<DeleteRegistrationRequest> serializer =
                                ProtoRestSerializer.create();
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
                  (DeleteRegistrationRequest request, Operation response) ->
                      HttpJsonOperationSnapshot.create(response))
              .build();

  private static final ApiMethodDescriptor<RetrieveAuthorizationCodeRequest, AuthorizationCode>
      retrieveAuthorizationCodeMethodDescriptor =
          ApiMethodDescriptor.<RetrieveAuthorizationCodeRequest, AuthorizationCode>newBuilder()
              .setFullMethodName("google.cloud.domains.v1.Domains/RetrieveAuthorizationCode")
              .setHttpMethod("GET")
              .setType(ApiMethodDescriptor.MethodType.UNARY)
              .setRequestFormatter(
                  ProtoMessageRequestFormatter.<RetrieveAuthorizationCodeRequest>newBuilder()
                      .setPath(
                          "/v1/{registration=projects/*/locations/*/registrations/*}:retrieveAuthorizationCode",
                          request -> {
                            Map<String, String> fields = new HashMap<>();
                            ProtoRestSerializer<RetrieveAuthorizationCodeRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putPathParam(
                                fields, "registration", request.getRegistration());
                            return fields;
                          })
                      .setQueryParamsExtractor(
                          request -> {
                            Map<String, List<String>> fields = new HashMap<>();
                            ProtoRestSerializer<RetrieveAuthorizationCodeRequest> serializer =
                                ProtoRestSerializer.create();
                            return fields;
                          })
                      .setRequestBodyExtractor(request -> null)
                      .build())
              .setResponseParser(
                  ProtoMessageResponseParser.<AuthorizationCode>newBuilder()
                      .setDefaultInstance(AuthorizationCode.getDefaultInstance())
                      .setDefaultTypeRegistry(typeRegistry)
                      .build())
              .build();

  private static final ApiMethodDescriptor<ResetAuthorizationCodeRequest, AuthorizationCode>
      resetAuthorizationCodeMethodDescriptor =
          ApiMethodDescriptor.<ResetAuthorizationCodeRequest, AuthorizationCode>newBuilder()
              .setFullMethodName("google.cloud.domains.v1.Domains/ResetAuthorizationCode")
              .setHttpMethod("POST")
              .setType(ApiMethodDescriptor.MethodType.UNARY)
              .setRequestFormatter(
                  ProtoMessageRequestFormatter.<ResetAuthorizationCodeRequest>newBuilder()
                      .setPath(
                          "/v1/{registration=projects/*/locations/*/registrations/*}:resetAuthorizationCode",
                          request -> {
                            Map<String, String> fields = new HashMap<>();
                            ProtoRestSerializer<ResetAuthorizationCodeRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putPathParam(
                                fields, "registration", request.getRegistration());
                            return fields;
                          })
                      .setQueryParamsExtractor(
                          request -> {
                            Map<String, List<String>> fields = new HashMap<>();
                            ProtoRestSerializer<ResetAuthorizationCodeRequest> serializer =
                                ProtoRestSerializer.create();
                            return fields;
                          })
                      .setRequestBodyExtractor(
                          request ->
                              ProtoRestSerializer.create()
                                  .toBody(
                                      "*", request.toBuilder().clearRegistration().build(), false))
                      .build())
              .setResponseParser(
                  ProtoMessageResponseParser.<AuthorizationCode>newBuilder()
                      .setDefaultInstance(AuthorizationCode.getDefaultInstance())
                      .setDefaultTypeRegistry(typeRegistry)
                      .build())
              .build();

  private final UnaryCallable<SearchDomainsRequest, SearchDomainsResponse> searchDomainsCallable;
  private final UnaryCallable<RetrieveRegisterParametersRequest, RetrieveRegisterParametersResponse>
      retrieveRegisterParametersCallable;
  private final UnaryCallable<RegisterDomainRequest, Operation> registerDomainCallable;
  private final OperationCallable<RegisterDomainRequest, Registration, OperationMetadata>
      registerDomainOperationCallable;
  private final UnaryCallable<RetrieveTransferParametersRequest, RetrieveTransferParametersResponse>
      retrieveTransferParametersCallable;
  private final UnaryCallable<TransferDomainRequest, Operation> transferDomainCallable;
  private final OperationCallable<TransferDomainRequest, Registration, OperationMetadata>
      transferDomainOperationCallable;
  private final UnaryCallable<ListRegistrationsRequest, ListRegistrationsResponse>
      listRegistrationsCallable;
  private final UnaryCallable<ListRegistrationsRequest, ListRegistrationsPagedResponse>
      listRegistrationsPagedCallable;
  private final UnaryCallable<GetRegistrationRequest, Registration> getRegistrationCallable;
  private final UnaryCallable<UpdateRegistrationRequest, Operation> updateRegistrationCallable;
  private final OperationCallable<UpdateRegistrationRequest, Registration, OperationMetadata>
      updateRegistrationOperationCallable;
  private final UnaryCallable<ConfigureManagementSettingsRequest, Operation>
      configureManagementSettingsCallable;
  private final OperationCallable<
          ConfigureManagementSettingsRequest, Registration, OperationMetadata>
      configureManagementSettingsOperationCallable;
  private final UnaryCallable<ConfigureDnsSettingsRequest, Operation> configureDnsSettingsCallable;
  private final OperationCallable<ConfigureDnsSettingsRequest, Registration, OperationMetadata>
      configureDnsSettingsOperationCallable;
  private final UnaryCallable<ConfigureContactSettingsRequest, Operation>
      configureContactSettingsCallable;
  private final OperationCallable<ConfigureContactSettingsRequest, Registration, OperationMetadata>
      configureContactSettingsOperationCallable;
  private final UnaryCallable<ExportRegistrationRequest, Operation> exportRegistrationCallable;
  private final OperationCallable<ExportRegistrationRequest, Registration, OperationMetadata>
      exportRegistrationOperationCallable;
  private final UnaryCallable<DeleteRegistrationRequest, Operation> deleteRegistrationCallable;
  private final OperationCallable<DeleteRegistrationRequest, Empty, OperationMetadata>
      deleteRegistrationOperationCallable;
  private final UnaryCallable<RetrieveAuthorizationCodeRequest, AuthorizationCode>
      retrieveAuthorizationCodeCallable;
  private final UnaryCallable<ResetAuthorizationCodeRequest, AuthorizationCode>
      resetAuthorizationCodeCallable;

  private final BackgroundResource backgroundResources;
  private final HttpJsonOperationsStub httpJsonOperationsStub;
  private final HttpJsonStubCallableFactory callableFactory;

  public static final HttpJsonDomainsStub create(DomainsStubSettings settings) throws IOException {
    return new HttpJsonDomainsStub(settings, ClientContext.create(settings));
  }

  public static final HttpJsonDomainsStub create(ClientContext clientContext) throws IOException {
    return new HttpJsonDomainsStub(DomainsStubSettings.newHttpJsonBuilder().build(), clientContext);
  }

  public static final HttpJsonDomainsStub create(
      ClientContext clientContext, HttpJsonStubCallableFactory callableFactory) throws IOException {
    return new HttpJsonDomainsStub(
        DomainsStubSettings.newHttpJsonBuilder().build(), clientContext, callableFactory);
  }

  /**
   * Constructs an instance of HttpJsonDomainsStub, using the given settings. This is protected so
   * that it is easy to make a subclass, but otherwise, the static factory methods should be
   * preferred.
   */
  protected HttpJsonDomainsStub(DomainsStubSettings settings, ClientContext clientContext)
      throws IOException {
    this(settings, clientContext, new HttpJsonDomainsCallableFactory());
  }

  /**
   * Constructs an instance of HttpJsonDomainsStub, using the given settings. This is protected so
   * that it is easy to make a subclass, but otherwise, the static factory methods should be
   * preferred.
   */
  protected HttpJsonDomainsStub(
      DomainsStubSettings settings,
      ClientContext clientContext,
      HttpJsonStubCallableFactory callableFactory)
      throws IOException {
    this.callableFactory = callableFactory;
    this.httpJsonOperationsStub =
        HttpJsonOperationsStub.create(clientContext, callableFactory, typeRegistry);

    HttpJsonCallSettings<SearchDomainsRequest, SearchDomainsResponse>
        searchDomainsTransportSettings =
            HttpJsonCallSettings.<SearchDomainsRequest, SearchDomainsResponse>newBuilder()
                .setMethodDescriptor(searchDomainsMethodDescriptor)
                .setTypeRegistry(typeRegistry)
                .build();
    HttpJsonCallSettings<RetrieveRegisterParametersRequest, RetrieveRegisterParametersResponse>
        retrieveRegisterParametersTransportSettings =
            HttpJsonCallSettings
                .<RetrieveRegisterParametersRequest, RetrieveRegisterParametersResponse>newBuilder()
                .setMethodDescriptor(retrieveRegisterParametersMethodDescriptor)
                .setTypeRegistry(typeRegistry)
                .build();
    HttpJsonCallSettings<RegisterDomainRequest, Operation> registerDomainTransportSettings =
        HttpJsonCallSettings.<RegisterDomainRequest, Operation>newBuilder()
            .setMethodDescriptor(registerDomainMethodDescriptor)
            .setTypeRegistry(typeRegistry)
            .build();
    HttpJsonCallSettings<RetrieveTransferParametersRequest, RetrieveTransferParametersResponse>
        retrieveTransferParametersTransportSettings =
            HttpJsonCallSettings
                .<RetrieveTransferParametersRequest, RetrieveTransferParametersResponse>newBuilder()
                .setMethodDescriptor(retrieveTransferParametersMethodDescriptor)
                .setTypeRegistry(typeRegistry)
                .build();
    HttpJsonCallSettings<TransferDomainRequest, Operation> transferDomainTransportSettings =
        HttpJsonCallSettings.<TransferDomainRequest, Operation>newBuilder()
            .setMethodDescriptor(transferDomainMethodDescriptor)
            .setTypeRegistry(typeRegistry)
            .build();
    HttpJsonCallSettings<ListRegistrationsRequest, ListRegistrationsResponse>
        listRegistrationsTransportSettings =
            HttpJsonCallSettings.<ListRegistrationsRequest, ListRegistrationsResponse>newBuilder()
                .setMethodDescriptor(listRegistrationsMethodDescriptor)
                .setTypeRegistry(typeRegistry)
                .build();
    HttpJsonCallSettings<GetRegistrationRequest, Registration> getRegistrationTransportSettings =
        HttpJsonCallSettings.<GetRegistrationRequest, Registration>newBuilder()
            .setMethodDescriptor(getRegistrationMethodDescriptor)
            .setTypeRegistry(typeRegistry)
            .build();
    HttpJsonCallSettings<UpdateRegistrationRequest, Operation> updateRegistrationTransportSettings =
        HttpJsonCallSettings.<UpdateRegistrationRequest, Operation>newBuilder()
            .setMethodDescriptor(updateRegistrationMethodDescriptor)
            .setTypeRegistry(typeRegistry)
            .build();
    HttpJsonCallSettings<ConfigureManagementSettingsRequest, Operation>
        configureManagementSettingsTransportSettings =
            HttpJsonCallSettings.<ConfigureManagementSettingsRequest, Operation>newBuilder()
                .setMethodDescriptor(configureManagementSettingsMethodDescriptor)
                .setTypeRegistry(typeRegistry)
                .build();
    HttpJsonCallSettings<ConfigureDnsSettingsRequest, Operation>
        configureDnsSettingsTransportSettings =
            HttpJsonCallSettings.<ConfigureDnsSettingsRequest, Operation>newBuilder()
                .setMethodDescriptor(configureDnsSettingsMethodDescriptor)
                .setTypeRegistry(typeRegistry)
                .build();
    HttpJsonCallSettings<ConfigureContactSettingsRequest, Operation>
        configureContactSettingsTransportSettings =
            HttpJsonCallSettings.<ConfigureContactSettingsRequest, Operation>newBuilder()
                .setMethodDescriptor(configureContactSettingsMethodDescriptor)
                .setTypeRegistry(typeRegistry)
                .build();
    HttpJsonCallSettings<ExportRegistrationRequest, Operation> exportRegistrationTransportSettings =
        HttpJsonCallSettings.<ExportRegistrationRequest, Operation>newBuilder()
            .setMethodDescriptor(exportRegistrationMethodDescriptor)
            .setTypeRegistry(typeRegistry)
            .build();
    HttpJsonCallSettings<DeleteRegistrationRequest, Operation> deleteRegistrationTransportSettings =
        HttpJsonCallSettings.<DeleteRegistrationRequest, Operation>newBuilder()
            .setMethodDescriptor(deleteRegistrationMethodDescriptor)
            .setTypeRegistry(typeRegistry)
            .build();
    HttpJsonCallSettings<RetrieveAuthorizationCodeRequest, AuthorizationCode>
        retrieveAuthorizationCodeTransportSettings =
            HttpJsonCallSettings.<RetrieveAuthorizationCodeRequest, AuthorizationCode>newBuilder()
                .setMethodDescriptor(retrieveAuthorizationCodeMethodDescriptor)
                .setTypeRegistry(typeRegistry)
                .build();
    HttpJsonCallSettings<ResetAuthorizationCodeRequest, AuthorizationCode>
        resetAuthorizationCodeTransportSettings =
            HttpJsonCallSettings.<ResetAuthorizationCodeRequest, AuthorizationCode>newBuilder()
                .setMethodDescriptor(resetAuthorizationCodeMethodDescriptor)
                .setTypeRegistry(typeRegistry)
                .build();

    this.searchDomainsCallable =
        callableFactory.createUnaryCallable(
            searchDomainsTransportSettings, settings.searchDomainsSettings(), clientContext);
    this.retrieveRegisterParametersCallable =
        callableFactory.createUnaryCallable(
            retrieveRegisterParametersTransportSettings,
            settings.retrieveRegisterParametersSettings(),
            clientContext);
    this.registerDomainCallable =
        callableFactory.createUnaryCallable(
            registerDomainTransportSettings, settings.registerDomainSettings(), clientContext);
    this.registerDomainOperationCallable =
        callableFactory.createOperationCallable(
            registerDomainTransportSettings,
            settings.registerDomainOperationSettings(),
            clientContext,
            httpJsonOperationsStub);
    this.retrieveTransferParametersCallable =
        callableFactory.createUnaryCallable(
            retrieveTransferParametersTransportSettings,
            settings.retrieveTransferParametersSettings(),
            clientContext);
    this.transferDomainCallable =
        callableFactory.createUnaryCallable(
            transferDomainTransportSettings, settings.transferDomainSettings(), clientContext);
    this.transferDomainOperationCallable =
        callableFactory.createOperationCallable(
            transferDomainTransportSettings,
            settings.transferDomainOperationSettings(),
            clientContext,
            httpJsonOperationsStub);
    this.listRegistrationsCallable =
        callableFactory.createUnaryCallable(
            listRegistrationsTransportSettings,
            settings.listRegistrationsSettings(),
            clientContext);
    this.listRegistrationsPagedCallable =
        callableFactory.createPagedCallable(
            listRegistrationsTransportSettings,
            settings.listRegistrationsSettings(),
            clientContext);
    this.getRegistrationCallable =
        callableFactory.createUnaryCallable(
            getRegistrationTransportSettings, settings.getRegistrationSettings(), clientContext);
    this.updateRegistrationCallable =
        callableFactory.createUnaryCallable(
            updateRegistrationTransportSettings,
            settings.updateRegistrationSettings(),
            clientContext);
    this.updateRegistrationOperationCallable =
        callableFactory.createOperationCallable(
            updateRegistrationTransportSettings,
            settings.updateRegistrationOperationSettings(),
            clientContext,
            httpJsonOperationsStub);
    this.configureManagementSettingsCallable =
        callableFactory.createUnaryCallable(
            configureManagementSettingsTransportSettings,
            settings.configureManagementSettingsSettings(),
            clientContext);
    this.configureManagementSettingsOperationCallable =
        callableFactory.createOperationCallable(
            configureManagementSettingsTransportSettings,
            settings.configureManagementSettingsOperationSettings(),
            clientContext,
            httpJsonOperationsStub);
    this.configureDnsSettingsCallable =
        callableFactory.createUnaryCallable(
            configureDnsSettingsTransportSettings,
            settings.configureDnsSettingsSettings(),
            clientContext);
    this.configureDnsSettingsOperationCallable =
        callableFactory.createOperationCallable(
            configureDnsSettingsTransportSettings,
            settings.configureDnsSettingsOperationSettings(),
            clientContext,
            httpJsonOperationsStub);
    this.configureContactSettingsCallable =
        callableFactory.createUnaryCallable(
            configureContactSettingsTransportSettings,
            settings.configureContactSettingsSettings(),
            clientContext);
    this.configureContactSettingsOperationCallable =
        callableFactory.createOperationCallable(
            configureContactSettingsTransportSettings,
            settings.configureContactSettingsOperationSettings(),
            clientContext,
            httpJsonOperationsStub);
    this.exportRegistrationCallable =
        callableFactory.createUnaryCallable(
            exportRegistrationTransportSettings,
            settings.exportRegistrationSettings(),
            clientContext);
    this.exportRegistrationOperationCallable =
        callableFactory.createOperationCallable(
            exportRegistrationTransportSettings,
            settings.exportRegistrationOperationSettings(),
            clientContext,
            httpJsonOperationsStub);
    this.deleteRegistrationCallable =
        callableFactory.createUnaryCallable(
            deleteRegistrationTransportSettings,
            settings.deleteRegistrationSettings(),
            clientContext);
    this.deleteRegistrationOperationCallable =
        callableFactory.createOperationCallable(
            deleteRegistrationTransportSettings,
            settings.deleteRegistrationOperationSettings(),
            clientContext,
            httpJsonOperationsStub);
    this.retrieveAuthorizationCodeCallable =
        callableFactory.createUnaryCallable(
            retrieveAuthorizationCodeTransportSettings,
            settings.retrieveAuthorizationCodeSettings(),
            clientContext);
    this.resetAuthorizationCodeCallable =
        callableFactory.createUnaryCallable(
            resetAuthorizationCodeTransportSettings,
            settings.resetAuthorizationCodeSettings(),
            clientContext);

    this.backgroundResources =
        new BackgroundResourceAggregation(clientContext.getBackgroundResources());
  }

  @InternalApi
  public static List<ApiMethodDescriptor> getMethodDescriptors() {
    List<ApiMethodDescriptor> methodDescriptors = new ArrayList<>();
    methodDescriptors.add(searchDomainsMethodDescriptor);
    methodDescriptors.add(retrieveRegisterParametersMethodDescriptor);
    methodDescriptors.add(registerDomainMethodDescriptor);
    methodDescriptors.add(retrieveTransferParametersMethodDescriptor);
    methodDescriptors.add(transferDomainMethodDescriptor);
    methodDescriptors.add(listRegistrationsMethodDescriptor);
    methodDescriptors.add(getRegistrationMethodDescriptor);
    methodDescriptors.add(updateRegistrationMethodDescriptor);
    methodDescriptors.add(configureManagementSettingsMethodDescriptor);
    methodDescriptors.add(configureDnsSettingsMethodDescriptor);
    methodDescriptors.add(configureContactSettingsMethodDescriptor);
    methodDescriptors.add(exportRegistrationMethodDescriptor);
    methodDescriptors.add(deleteRegistrationMethodDescriptor);
    methodDescriptors.add(retrieveAuthorizationCodeMethodDescriptor);
    methodDescriptors.add(resetAuthorizationCodeMethodDescriptor);
    return methodDescriptors;
  }

  public HttpJsonOperationsStub getHttpJsonOperationsStub() {
    return httpJsonOperationsStub;
  }

  @Override
  public UnaryCallable<SearchDomainsRequest, SearchDomainsResponse> searchDomainsCallable() {
    return searchDomainsCallable;
  }

  @Override
  public UnaryCallable<RetrieveRegisterParametersRequest, RetrieveRegisterParametersResponse>
      retrieveRegisterParametersCallable() {
    return retrieveRegisterParametersCallable;
  }

  @Override
  public UnaryCallable<RegisterDomainRequest, Operation> registerDomainCallable() {
    return registerDomainCallable;
  }

  @Override
  public OperationCallable<RegisterDomainRequest, Registration, OperationMetadata>
      registerDomainOperationCallable() {
    return registerDomainOperationCallable;
  }

  @Override
  public UnaryCallable<RetrieveTransferParametersRequest, RetrieveTransferParametersResponse>
      retrieveTransferParametersCallable() {
    return retrieveTransferParametersCallable;
  }

  @Override
  public UnaryCallable<TransferDomainRequest, Operation> transferDomainCallable() {
    return transferDomainCallable;
  }

  @Override
  public OperationCallable<TransferDomainRequest, Registration, OperationMetadata>
      transferDomainOperationCallable() {
    return transferDomainOperationCallable;
  }

  @Override
  public UnaryCallable<ListRegistrationsRequest, ListRegistrationsResponse>
      listRegistrationsCallable() {
    return listRegistrationsCallable;
  }

  @Override
  public UnaryCallable<ListRegistrationsRequest, ListRegistrationsPagedResponse>
      listRegistrationsPagedCallable() {
    return listRegistrationsPagedCallable;
  }

  @Override
  public UnaryCallable<GetRegistrationRequest, Registration> getRegistrationCallable() {
    return getRegistrationCallable;
  }

  @Override
  public UnaryCallable<UpdateRegistrationRequest, Operation> updateRegistrationCallable() {
    return updateRegistrationCallable;
  }

  @Override
  public OperationCallable<UpdateRegistrationRequest, Registration, OperationMetadata>
      updateRegistrationOperationCallable() {
    return updateRegistrationOperationCallable;
  }

  @Override
  public UnaryCallable<ConfigureManagementSettingsRequest, Operation>
      configureManagementSettingsCallable() {
    return configureManagementSettingsCallable;
  }

  @Override
  public OperationCallable<ConfigureManagementSettingsRequest, Registration, OperationMetadata>
      configureManagementSettingsOperationCallable() {
    return configureManagementSettingsOperationCallable;
  }

  @Override
  public UnaryCallable<ConfigureDnsSettingsRequest, Operation> configureDnsSettingsCallable() {
    return configureDnsSettingsCallable;
  }

  @Override
  public OperationCallable<ConfigureDnsSettingsRequest, Registration, OperationMetadata>
      configureDnsSettingsOperationCallable() {
    return configureDnsSettingsOperationCallable;
  }

  @Override
  public UnaryCallable<ConfigureContactSettingsRequest, Operation>
      configureContactSettingsCallable() {
    return configureContactSettingsCallable;
  }

  @Override
  public OperationCallable<ConfigureContactSettingsRequest, Registration, OperationMetadata>
      configureContactSettingsOperationCallable() {
    return configureContactSettingsOperationCallable;
  }

  @Override
  public UnaryCallable<ExportRegistrationRequest, Operation> exportRegistrationCallable() {
    return exportRegistrationCallable;
  }

  @Override
  public OperationCallable<ExportRegistrationRequest, Registration, OperationMetadata>
      exportRegistrationOperationCallable() {
    return exportRegistrationOperationCallable;
  }

  @Override
  public UnaryCallable<DeleteRegistrationRequest, Operation> deleteRegistrationCallable() {
    return deleteRegistrationCallable;
  }

  @Override
  public OperationCallable<DeleteRegistrationRequest, Empty, OperationMetadata>
      deleteRegistrationOperationCallable() {
    return deleteRegistrationOperationCallable;
  }

  @Override
  public UnaryCallable<RetrieveAuthorizationCodeRequest, AuthorizationCode>
      retrieveAuthorizationCodeCallable() {
    return retrieveAuthorizationCodeCallable;
  }

  @Override
  public UnaryCallable<ResetAuthorizationCodeRequest, AuthorizationCode>
      resetAuthorizationCodeCallable() {
    return resetAuthorizationCodeCallable;
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
