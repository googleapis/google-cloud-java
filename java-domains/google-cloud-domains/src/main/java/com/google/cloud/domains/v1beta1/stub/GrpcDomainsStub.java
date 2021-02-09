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

package com.google.cloud.domains.v1beta1.stub;

import static com.google.cloud.domains.v1beta1.DomainsClient.ListRegistrationsPagedResponse;

import com.google.api.core.BetaApi;
import com.google.api.gax.core.BackgroundResource;
import com.google.api.gax.core.BackgroundResourceAggregation;
import com.google.api.gax.grpc.GrpcCallSettings;
import com.google.api.gax.grpc.GrpcStubCallableFactory;
import com.google.api.gax.rpc.ClientContext;
import com.google.api.gax.rpc.OperationCallable;
import com.google.api.gax.rpc.RequestParamsExtractor;
import com.google.api.gax.rpc.UnaryCallable;
import com.google.cloud.domains.v1beta1.AuthorizationCode;
import com.google.cloud.domains.v1beta1.ConfigureContactSettingsRequest;
import com.google.cloud.domains.v1beta1.ConfigureDnsSettingsRequest;
import com.google.cloud.domains.v1beta1.ConfigureManagementSettingsRequest;
import com.google.cloud.domains.v1beta1.DeleteRegistrationRequest;
import com.google.cloud.domains.v1beta1.ExportRegistrationRequest;
import com.google.cloud.domains.v1beta1.GetRegistrationRequest;
import com.google.cloud.domains.v1beta1.ListRegistrationsRequest;
import com.google.cloud.domains.v1beta1.ListRegistrationsResponse;
import com.google.cloud.domains.v1beta1.OperationMetadata;
import com.google.cloud.domains.v1beta1.RegisterDomainRequest;
import com.google.cloud.domains.v1beta1.Registration;
import com.google.cloud.domains.v1beta1.ResetAuthorizationCodeRequest;
import com.google.cloud.domains.v1beta1.RetrieveAuthorizationCodeRequest;
import com.google.cloud.domains.v1beta1.RetrieveRegisterParametersRequest;
import com.google.cloud.domains.v1beta1.RetrieveRegisterParametersResponse;
import com.google.cloud.domains.v1beta1.SearchDomainsRequest;
import com.google.cloud.domains.v1beta1.SearchDomainsResponse;
import com.google.cloud.domains.v1beta1.UpdateRegistrationRequest;
import com.google.common.collect.ImmutableMap;
import com.google.longrunning.Operation;
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
 * gRPC stub implementation for the Domains service API.
 *
 * <p>This class is for advanced usage and reflects the underlying API directly.
 */
@BetaApi
@Generated("by gapic-generator-java")
public class GrpcDomainsStub extends DomainsStub {
  private static final MethodDescriptor<SearchDomainsRequest, SearchDomainsResponse>
      searchDomainsMethodDescriptor =
          MethodDescriptor.<SearchDomainsRequest, SearchDomainsResponse>newBuilder()
              .setType(MethodDescriptor.MethodType.UNARY)
              .setFullMethodName("google.cloud.domains.v1beta1.Domains/SearchDomains")
              .setRequestMarshaller(
                  ProtoUtils.marshaller(SearchDomainsRequest.getDefaultInstance()))
              .setResponseMarshaller(
                  ProtoUtils.marshaller(SearchDomainsResponse.getDefaultInstance()))
              .build();

  private static final MethodDescriptor<
          RetrieveRegisterParametersRequest, RetrieveRegisterParametersResponse>
      retrieveRegisterParametersMethodDescriptor =
          MethodDescriptor
              .<RetrieveRegisterParametersRequest, RetrieveRegisterParametersResponse>newBuilder()
              .setType(MethodDescriptor.MethodType.UNARY)
              .setFullMethodName("google.cloud.domains.v1beta1.Domains/RetrieveRegisterParameters")
              .setRequestMarshaller(
                  ProtoUtils.marshaller(RetrieveRegisterParametersRequest.getDefaultInstance()))
              .setResponseMarshaller(
                  ProtoUtils.marshaller(RetrieveRegisterParametersResponse.getDefaultInstance()))
              .build();

  private static final MethodDescriptor<RegisterDomainRequest, Operation>
      registerDomainMethodDescriptor =
          MethodDescriptor.<RegisterDomainRequest, Operation>newBuilder()
              .setType(MethodDescriptor.MethodType.UNARY)
              .setFullMethodName("google.cloud.domains.v1beta1.Domains/RegisterDomain")
              .setRequestMarshaller(
                  ProtoUtils.marshaller(RegisterDomainRequest.getDefaultInstance()))
              .setResponseMarshaller(ProtoUtils.marshaller(Operation.getDefaultInstance()))
              .build();

  private static final MethodDescriptor<ListRegistrationsRequest, ListRegistrationsResponse>
      listRegistrationsMethodDescriptor =
          MethodDescriptor.<ListRegistrationsRequest, ListRegistrationsResponse>newBuilder()
              .setType(MethodDescriptor.MethodType.UNARY)
              .setFullMethodName("google.cloud.domains.v1beta1.Domains/ListRegistrations")
              .setRequestMarshaller(
                  ProtoUtils.marshaller(ListRegistrationsRequest.getDefaultInstance()))
              .setResponseMarshaller(
                  ProtoUtils.marshaller(ListRegistrationsResponse.getDefaultInstance()))
              .build();

  private static final MethodDescriptor<GetRegistrationRequest, Registration>
      getRegistrationMethodDescriptor =
          MethodDescriptor.<GetRegistrationRequest, Registration>newBuilder()
              .setType(MethodDescriptor.MethodType.UNARY)
              .setFullMethodName("google.cloud.domains.v1beta1.Domains/GetRegistration")
              .setRequestMarshaller(
                  ProtoUtils.marshaller(GetRegistrationRequest.getDefaultInstance()))
              .setResponseMarshaller(ProtoUtils.marshaller(Registration.getDefaultInstance()))
              .build();

  private static final MethodDescriptor<UpdateRegistrationRequest, Operation>
      updateRegistrationMethodDescriptor =
          MethodDescriptor.<UpdateRegistrationRequest, Operation>newBuilder()
              .setType(MethodDescriptor.MethodType.UNARY)
              .setFullMethodName("google.cloud.domains.v1beta1.Domains/UpdateRegistration")
              .setRequestMarshaller(
                  ProtoUtils.marshaller(UpdateRegistrationRequest.getDefaultInstance()))
              .setResponseMarshaller(ProtoUtils.marshaller(Operation.getDefaultInstance()))
              .build();

  private static final MethodDescriptor<ConfigureManagementSettingsRequest, Operation>
      configureManagementSettingsMethodDescriptor =
          MethodDescriptor.<ConfigureManagementSettingsRequest, Operation>newBuilder()
              .setType(MethodDescriptor.MethodType.UNARY)
              .setFullMethodName("google.cloud.domains.v1beta1.Domains/ConfigureManagementSettings")
              .setRequestMarshaller(
                  ProtoUtils.marshaller(ConfigureManagementSettingsRequest.getDefaultInstance()))
              .setResponseMarshaller(ProtoUtils.marshaller(Operation.getDefaultInstance()))
              .build();

  private static final MethodDescriptor<ConfigureDnsSettingsRequest, Operation>
      configureDnsSettingsMethodDescriptor =
          MethodDescriptor.<ConfigureDnsSettingsRequest, Operation>newBuilder()
              .setType(MethodDescriptor.MethodType.UNARY)
              .setFullMethodName("google.cloud.domains.v1beta1.Domains/ConfigureDnsSettings")
              .setRequestMarshaller(
                  ProtoUtils.marshaller(ConfigureDnsSettingsRequest.getDefaultInstance()))
              .setResponseMarshaller(ProtoUtils.marshaller(Operation.getDefaultInstance()))
              .build();

  private static final MethodDescriptor<ConfigureContactSettingsRequest, Operation>
      configureContactSettingsMethodDescriptor =
          MethodDescriptor.<ConfigureContactSettingsRequest, Operation>newBuilder()
              .setType(MethodDescriptor.MethodType.UNARY)
              .setFullMethodName("google.cloud.domains.v1beta1.Domains/ConfigureContactSettings")
              .setRequestMarshaller(
                  ProtoUtils.marshaller(ConfigureContactSettingsRequest.getDefaultInstance()))
              .setResponseMarshaller(ProtoUtils.marshaller(Operation.getDefaultInstance()))
              .build();

  private static final MethodDescriptor<ExportRegistrationRequest, Operation>
      exportRegistrationMethodDescriptor =
          MethodDescriptor.<ExportRegistrationRequest, Operation>newBuilder()
              .setType(MethodDescriptor.MethodType.UNARY)
              .setFullMethodName("google.cloud.domains.v1beta1.Domains/ExportRegistration")
              .setRequestMarshaller(
                  ProtoUtils.marshaller(ExportRegistrationRequest.getDefaultInstance()))
              .setResponseMarshaller(ProtoUtils.marshaller(Operation.getDefaultInstance()))
              .build();

  private static final MethodDescriptor<DeleteRegistrationRequest, Operation>
      deleteRegistrationMethodDescriptor =
          MethodDescriptor.<DeleteRegistrationRequest, Operation>newBuilder()
              .setType(MethodDescriptor.MethodType.UNARY)
              .setFullMethodName("google.cloud.domains.v1beta1.Domains/DeleteRegistration")
              .setRequestMarshaller(
                  ProtoUtils.marshaller(DeleteRegistrationRequest.getDefaultInstance()))
              .setResponseMarshaller(ProtoUtils.marshaller(Operation.getDefaultInstance()))
              .build();

  private static final MethodDescriptor<RetrieveAuthorizationCodeRequest, AuthorizationCode>
      retrieveAuthorizationCodeMethodDescriptor =
          MethodDescriptor.<RetrieveAuthorizationCodeRequest, AuthorizationCode>newBuilder()
              .setType(MethodDescriptor.MethodType.UNARY)
              .setFullMethodName("google.cloud.domains.v1beta1.Domains/RetrieveAuthorizationCode")
              .setRequestMarshaller(
                  ProtoUtils.marshaller(RetrieveAuthorizationCodeRequest.getDefaultInstance()))
              .setResponseMarshaller(ProtoUtils.marshaller(AuthorizationCode.getDefaultInstance()))
              .build();

  private static final MethodDescriptor<ResetAuthorizationCodeRequest, AuthorizationCode>
      resetAuthorizationCodeMethodDescriptor =
          MethodDescriptor.<ResetAuthorizationCodeRequest, AuthorizationCode>newBuilder()
              .setType(MethodDescriptor.MethodType.UNARY)
              .setFullMethodName("google.cloud.domains.v1beta1.Domains/ResetAuthorizationCode")
              .setRequestMarshaller(
                  ProtoUtils.marshaller(ResetAuthorizationCodeRequest.getDefaultInstance()))
              .setResponseMarshaller(ProtoUtils.marshaller(AuthorizationCode.getDefaultInstance()))
              .build();

  private final UnaryCallable<SearchDomainsRequest, SearchDomainsResponse> searchDomainsCallable;
  private final UnaryCallable<RetrieveRegisterParametersRequest, RetrieveRegisterParametersResponse>
      retrieveRegisterParametersCallable;
  private final UnaryCallable<RegisterDomainRequest, Operation> registerDomainCallable;
  private final OperationCallable<RegisterDomainRequest, Registration, OperationMetadata>
      registerDomainOperationCallable;
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
  private final GrpcOperationsStub operationsStub;
  private final GrpcStubCallableFactory callableFactory;

  public static final GrpcDomainsStub create(DomainsStubSettings settings) throws IOException {
    return new GrpcDomainsStub(settings, ClientContext.create(settings));
  }

  public static final GrpcDomainsStub create(ClientContext clientContext) throws IOException {
    return new GrpcDomainsStub(DomainsStubSettings.newBuilder().build(), clientContext);
  }

  public static final GrpcDomainsStub create(
      ClientContext clientContext, GrpcStubCallableFactory callableFactory) throws IOException {
    return new GrpcDomainsStub(
        DomainsStubSettings.newBuilder().build(), clientContext, callableFactory);
  }

  /**
   * Constructs an instance of GrpcDomainsStub, using the given settings. This is protected so that
   * it is easy to make a subclass, but otherwise, the static factory methods should be preferred.
   */
  protected GrpcDomainsStub(DomainsStubSettings settings, ClientContext clientContext)
      throws IOException {
    this(settings, clientContext, new GrpcDomainsCallableFactory());
  }

  /**
   * Constructs an instance of GrpcDomainsStub, using the given settings. This is protected so that
   * it is easy to make a subclass, but otherwise, the static factory methods should be preferred.
   */
  protected GrpcDomainsStub(
      DomainsStubSettings settings,
      ClientContext clientContext,
      GrpcStubCallableFactory callableFactory)
      throws IOException {
    this.callableFactory = callableFactory;
    this.operationsStub = GrpcOperationsStub.create(clientContext, callableFactory);

    GrpcCallSettings<SearchDomainsRequest, SearchDomainsResponse> searchDomainsTransportSettings =
        GrpcCallSettings.<SearchDomainsRequest, SearchDomainsResponse>newBuilder()
            .setMethodDescriptor(searchDomainsMethodDescriptor)
            .setParamsExtractor(
                new RequestParamsExtractor<SearchDomainsRequest>() {
                  @Override
                  public Map<String, String> extract(SearchDomainsRequest request) {
                    ImmutableMap.Builder<String, String> params = ImmutableMap.builder();
                    params.put("location", String.valueOf(request.getLocation()));
                    return params.build();
                  }
                })
            .build();
    GrpcCallSettings<RetrieveRegisterParametersRequest, RetrieveRegisterParametersResponse>
        retrieveRegisterParametersTransportSettings =
            GrpcCallSettings
                .<RetrieveRegisterParametersRequest, RetrieveRegisterParametersResponse>newBuilder()
                .setMethodDescriptor(retrieveRegisterParametersMethodDescriptor)
                .setParamsExtractor(
                    new RequestParamsExtractor<RetrieveRegisterParametersRequest>() {
                      @Override
                      public Map<String, String> extract(
                          RetrieveRegisterParametersRequest request) {
                        ImmutableMap.Builder<String, String> params = ImmutableMap.builder();
                        params.put("location", String.valueOf(request.getLocation()));
                        return params.build();
                      }
                    })
                .build();
    GrpcCallSettings<RegisterDomainRequest, Operation> registerDomainTransportSettings =
        GrpcCallSettings.<RegisterDomainRequest, Operation>newBuilder()
            .setMethodDescriptor(registerDomainMethodDescriptor)
            .setParamsExtractor(
                new RequestParamsExtractor<RegisterDomainRequest>() {
                  @Override
                  public Map<String, String> extract(RegisterDomainRequest request) {
                    ImmutableMap.Builder<String, String> params = ImmutableMap.builder();
                    params.put("parent", String.valueOf(request.getParent()));
                    return params.build();
                  }
                })
            .build();
    GrpcCallSettings<ListRegistrationsRequest, ListRegistrationsResponse>
        listRegistrationsTransportSettings =
            GrpcCallSettings.<ListRegistrationsRequest, ListRegistrationsResponse>newBuilder()
                .setMethodDescriptor(listRegistrationsMethodDescriptor)
                .setParamsExtractor(
                    new RequestParamsExtractor<ListRegistrationsRequest>() {
                      @Override
                      public Map<String, String> extract(ListRegistrationsRequest request) {
                        ImmutableMap.Builder<String, String> params = ImmutableMap.builder();
                        params.put("parent", String.valueOf(request.getParent()));
                        return params.build();
                      }
                    })
                .build();
    GrpcCallSettings<GetRegistrationRequest, Registration> getRegistrationTransportSettings =
        GrpcCallSettings.<GetRegistrationRequest, Registration>newBuilder()
            .setMethodDescriptor(getRegistrationMethodDescriptor)
            .setParamsExtractor(
                new RequestParamsExtractor<GetRegistrationRequest>() {
                  @Override
                  public Map<String, String> extract(GetRegistrationRequest request) {
                    ImmutableMap.Builder<String, String> params = ImmutableMap.builder();
                    params.put("name", String.valueOf(request.getName()));
                    return params.build();
                  }
                })
            .build();
    GrpcCallSettings<UpdateRegistrationRequest, Operation> updateRegistrationTransportSettings =
        GrpcCallSettings.<UpdateRegistrationRequest, Operation>newBuilder()
            .setMethodDescriptor(updateRegistrationMethodDescriptor)
            .setParamsExtractor(
                new RequestParamsExtractor<UpdateRegistrationRequest>() {
                  @Override
                  public Map<String, String> extract(UpdateRegistrationRequest request) {
                    ImmutableMap.Builder<String, String> params = ImmutableMap.builder();
                    params.put(
                        "registration.name", String.valueOf(request.getRegistration().getName()));
                    return params.build();
                  }
                })
            .build();
    GrpcCallSettings<ConfigureManagementSettingsRequest, Operation>
        configureManagementSettingsTransportSettings =
            GrpcCallSettings.<ConfigureManagementSettingsRequest, Operation>newBuilder()
                .setMethodDescriptor(configureManagementSettingsMethodDescriptor)
                .setParamsExtractor(
                    new RequestParamsExtractor<ConfigureManagementSettingsRequest>() {
                      @Override
                      public Map<String, String> extract(
                          ConfigureManagementSettingsRequest request) {
                        ImmutableMap.Builder<String, String> params = ImmutableMap.builder();
                        params.put("registration", String.valueOf(request.getRegistration()));
                        return params.build();
                      }
                    })
                .build();
    GrpcCallSettings<ConfigureDnsSettingsRequest, Operation> configureDnsSettingsTransportSettings =
        GrpcCallSettings.<ConfigureDnsSettingsRequest, Operation>newBuilder()
            .setMethodDescriptor(configureDnsSettingsMethodDescriptor)
            .setParamsExtractor(
                new RequestParamsExtractor<ConfigureDnsSettingsRequest>() {
                  @Override
                  public Map<String, String> extract(ConfigureDnsSettingsRequest request) {
                    ImmutableMap.Builder<String, String> params = ImmutableMap.builder();
                    params.put("registration", String.valueOf(request.getRegistration()));
                    return params.build();
                  }
                })
            .build();
    GrpcCallSettings<ConfigureContactSettingsRequest, Operation>
        configureContactSettingsTransportSettings =
            GrpcCallSettings.<ConfigureContactSettingsRequest, Operation>newBuilder()
                .setMethodDescriptor(configureContactSettingsMethodDescriptor)
                .setParamsExtractor(
                    new RequestParamsExtractor<ConfigureContactSettingsRequest>() {
                      @Override
                      public Map<String, String> extract(ConfigureContactSettingsRequest request) {
                        ImmutableMap.Builder<String, String> params = ImmutableMap.builder();
                        params.put("registration", String.valueOf(request.getRegistration()));
                        return params.build();
                      }
                    })
                .build();
    GrpcCallSettings<ExportRegistrationRequest, Operation> exportRegistrationTransportSettings =
        GrpcCallSettings.<ExportRegistrationRequest, Operation>newBuilder()
            .setMethodDescriptor(exportRegistrationMethodDescriptor)
            .setParamsExtractor(
                new RequestParamsExtractor<ExportRegistrationRequest>() {
                  @Override
                  public Map<String, String> extract(ExportRegistrationRequest request) {
                    ImmutableMap.Builder<String, String> params = ImmutableMap.builder();
                    params.put("name", String.valueOf(request.getName()));
                    return params.build();
                  }
                })
            .build();
    GrpcCallSettings<DeleteRegistrationRequest, Operation> deleteRegistrationTransportSettings =
        GrpcCallSettings.<DeleteRegistrationRequest, Operation>newBuilder()
            .setMethodDescriptor(deleteRegistrationMethodDescriptor)
            .setParamsExtractor(
                new RequestParamsExtractor<DeleteRegistrationRequest>() {
                  @Override
                  public Map<String, String> extract(DeleteRegistrationRequest request) {
                    ImmutableMap.Builder<String, String> params = ImmutableMap.builder();
                    params.put("name", String.valueOf(request.getName()));
                    return params.build();
                  }
                })
            .build();
    GrpcCallSettings<RetrieveAuthorizationCodeRequest, AuthorizationCode>
        retrieveAuthorizationCodeTransportSettings =
            GrpcCallSettings.<RetrieveAuthorizationCodeRequest, AuthorizationCode>newBuilder()
                .setMethodDescriptor(retrieveAuthorizationCodeMethodDescriptor)
                .setParamsExtractor(
                    new RequestParamsExtractor<RetrieveAuthorizationCodeRequest>() {
                      @Override
                      public Map<String, String> extract(RetrieveAuthorizationCodeRequest request) {
                        ImmutableMap.Builder<String, String> params = ImmutableMap.builder();
                        params.put("registration", String.valueOf(request.getRegistration()));
                        return params.build();
                      }
                    })
                .build();
    GrpcCallSettings<ResetAuthorizationCodeRequest, AuthorizationCode>
        resetAuthorizationCodeTransportSettings =
            GrpcCallSettings.<ResetAuthorizationCodeRequest, AuthorizationCode>newBuilder()
                .setMethodDescriptor(resetAuthorizationCodeMethodDescriptor)
                .setParamsExtractor(
                    new RequestParamsExtractor<ResetAuthorizationCodeRequest>() {
                      @Override
                      public Map<String, String> extract(ResetAuthorizationCodeRequest request) {
                        ImmutableMap.Builder<String, String> params = ImmutableMap.builder();
                        params.put("registration", String.valueOf(request.getRegistration()));
                        return params.build();
                      }
                    })
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
            operationsStub);
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
            operationsStub);
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
            operationsStub);
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
            operationsStub);
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
            operationsStub);
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
            operationsStub);
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
            operationsStub);
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

  public GrpcOperationsStub getOperationsStub() {
    return operationsStub;
  }

  public UnaryCallable<SearchDomainsRequest, SearchDomainsResponse> searchDomainsCallable() {
    return searchDomainsCallable;
  }

  public UnaryCallable<RetrieveRegisterParametersRequest, RetrieveRegisterParametersResponse>
      retrieveRegisterParametersCallable() {
    return retrieveRegisterParametersCallable;
  }

  public UnaryCallable<RegisterDomainRequest, Operation> registerDomainCallable() {
    return registerDomainCallable;
  }

  public OperationCallable<RegisterDomainRequest, Registration, OperationMetadata>
      registerDomainOperationCallable() {
    return registerDomainOperationCallable;
  }

  public UnaryCallable<ListRegistrationsRequest, ListRegistrationsResponse>
      listRegistrationsCallable() {
    return listRegistrationsCallable;
  }

  public UnaryCallable<ListRegistrationsRequest, ListRegistrationsPagedResponse>
      listRegistrationsPagedCallable() {
    return listRegistrationsPagedCallable;
  }

  public UnaryCallable<GetRegistrationRequest, Registration> getRegistrationCallable() {
    return getRegistrationCallable;
  }

  public UnaryCallable<UpdateRegistrationRequest, Operation> updateRegistrationCallable() {
    return updateRegistrationCallable;
  }

  public OperationCallable<UpdateRegistrationRequest, Registration, OperationMetadata>
      updateRegistrationOperationCallable() {
    return updateRegistrationOperationCallable;
  }

  public UnaryCallable<ConfigureManagementSettingsRequest, Operation>
      configureManagementSettingsCallable() {
    return configureManagementSettingsCallable;
  }

  public OperationCallable<ConfigureManagementSettingsRequest, Registration, OperationMetadata>
      configureManagementSettingsOperationCallable() {
    return configureManagementSettingsOperationCallable;
  }

  public UnaryCallable<ConfigureDnsSettingsRequest, Operation> configureDnsSettingsCallable() {
    return configureDnsSettingsCallable;
  }

  public OperationCallable<ConfigureDnsSettingsRequest, Registration, OperationMetadata>
      configureDnsSettingsOperationCallable() {
    return configureDnsSettingsOperationCallable;
  }

  public UnaryCallable<ConfigureContactSettingsRequest, Operation>
      configureContactSettingsCallable() {
    return configureContactSettingsCallable;
  }

  public OperationCallable<ConfigureContactSettingsRequest, Registration, OperationMetadata>
      configureContactSettingsOperationCallable() {
    return configureContactSettingsOperationCallable;
  }

  public UnaryCallable<ExportRegistrationRequest, Operation> exportRegistrationCallable() {
    return exportRegistrationCallable;
  }

  public OperationCallable<ExportRegistrationRequest, Registration, OperationMetadata>
      exportRegistrationOperationCallable() {
    return exportRegistrationOperationCallable;
  }

  public UnaryCallable<DeleteRegistrationRequest, Operation> deleteRegistrationCallable() {
    return deleteRegistrationCallable;
  }

  public OperationCallable<DeleteRegistrationRequest, Empty, OperationMetadata>
      deleteRegistrationOperationCallable() {
    return deleteRegistrationOperationCallable;
  }

  public UnaryCallable<RetrieveAuthorizationCodeRequest, AuthorizationCode>
      retrieveAuthorizationCodeCallable() {
    return retrieveAuthorizationCodeCallable;
  }

  public UnaryCallable<ResetAuthorizationCodeRequest, AuthorizationCode>
      resetAuthorizationCodeCallable() {
    return resetAuthorizationCodeCallable;
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
