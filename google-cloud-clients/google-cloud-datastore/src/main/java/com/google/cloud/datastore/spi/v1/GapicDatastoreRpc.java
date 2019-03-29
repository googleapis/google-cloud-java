/*
 * Copyright 2019 Google LLC
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *       http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package com.google.cloud.datastore.spi.v1;

import static com.google.cloud.datastore.DatastoreExceptionFactory.newDatastoreException;

import com.google.api.core.ApiFunction;
import com.google.api.core.ApiFuture;
import com.google.api.core.ApiFutures;
import com.google.api.gax.core.BackgroundResource;
import com.google.api.gax.core.GaxProperties;
import com.google.api.gax.grpc.GaxGrpcProperties;
import com.google.api.gax.grpc.GrpcCallContext;
import com.google.api.gax.grpc.GrpcTransportChannel;
import com.google.api.gax.rpc.ApiClientHeaderProvider;
import com.google.api.gax.rpc.ApiException;
import com.google.api.gax.rpc.ClientContext;
import com.google.api.gax.rpc.HeaderProvider;
import com.google.api.gax.rpc.StatusCode;
import com.google.api.gax.rpc.StatusCode.Code;
import com.google.api.gax.rpc.TransportChannel;
import com.google.api.gax.rpc.UnaryCallSettings;
import com.google.api.gax.rpc.UnaryCallSettings.Builder;
import com.google.api.pathtemplate.PathTemplate;
import com.google.cloud.NoCredentials;
import com.google.cloud.ServiceOptions;
import com.google.cloud.datastore.DatastoreException;
import com.google.cloud.datastore.DatastoreExceptionFactory;
import com.google.cloud.datastore.DatastoreOptions;
import com.google.cloud.datastore.v1.DatastoreSettings;
import com.google.cloud.datastore.v1.stub.DatastoreStub;
import com.google.cloud.datastore.v1.stub.DatastoreStubSettings;
import com.google.cloud.datastore.v1.stub.GrpcDatastoreStub;
import com.google.cloud.grpc.GrpcTransportOptions;
import com.google.cloud.grpc.GrpcTransportOptions.ExecutorFactory;
import com.google.common.collect.ImmutableSet;
import com.google.datastore.v1.AllocateIdsRequest;
import com.google.datastore.v1.AllocateIdsResponse;
import com.google.datastore.v1.BeginTransactionRequest;
import com.google.datastore.v1.BeginTransactionResponse;
import com.google.datastore.v1.CommitRequest;
import com.google.datastore.v1.CommitResponse;
import com.google.datastore.v1.LookupRequest;
import com.google.datastore.v1.LookupResponse;
import com.google.datastore.v1.RollbackRequest;
import com.google.datastore.v1.RollbackResponse;
import com.google.datastore.v1.RunQueryRequest;
import com.google.datastore.v1.RunQueryResponse;
import io.grpc.CallOptions;
import io.grpc.Context;
import io.grpc.ManagedChannel;
import io.grpc.ManagedChannelBuilder;
import java.util.Collections;
import java.util.EnumSet;
import java.util.Set;
import java.util.concurrent.CancellationException;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Future;
import java.util.concurrent.ScheduledExecutorService;
import org.threeten.bp.Duration;

public class GapicDatastoreRpc implements DatastoreRpc {

  private static final int DEFAULT_TIMEOUT_SECONDS = 30 * 60;
  private static final int DEFAULT_PERIOD_SECONDS = 10;
  private static final PathTemplate PROJECT_NAME_TEMPLATE =
      PathTemplate.create("projects/{project}");
  private static final String PROPERTY_TIMEOUT_SECONDS =
      "com.google.cloud.datastore.watchdogTimeoutSeconds";
  private static final String PROPERTY_PERIOD_SECONDS =
      "com.google.cloud.datastore.watchdogPeriodSeconds";
  private final Duration waitTimeout =
      systemProperty(PROPERTY_TIMEOUT_SECONDS, DEFAULT_TIMEOUT_SECONDS);
  private final Duration idleTimeout =
      systemProperty(PROPERTY_TIMEOUT_SECONDS, DEFAULT_TIMEOUT_SECONDS);
  private final Duration checkInterval =
      systemProperty(PROPERTY_PERIOD_SECONDS, DEFAULT_PERIOD_SECONDS);

  private final String projectId;
  private final String projectName;
  private final DatastoreMetadataProvider metadataProvider;
  private final DatastoreStub datastoreStub;

  private final ScheduledExecutorService executor;
  private final ClientContext clientContext;
  private final ExecutorFactory<ScheduledExecutorService> executorFactory;

  public static GapicDatastoreRpc create(DatastoreOptions options) {
    return new GapicDatastoreRpc(options);
  }

  public GapicDatastoreRpc(final DatastoreOptions options) {
    this.projectId = options.getProjectId();
    this.projectName = PROJECT_NAME_TEMPLATE.instantiate("project", this.projectId);


    GrpcTransportOptions transportOptions = (GrpcTransportOptions) options.getTransportOptions();
    executorFactory = transportOptions.getExecutorFactory();
    executor = executorFactory.get();
    ApiClientHeaderProvider.Builder internalHeaderProviderBuilder =
        ApiClientHeaderProvider.newBuilder();
    ApiClientHeaderProvider internalHeaderProvider =
        internalHeaderProviderBuilder
            .setClientLibToken(
                ServiceOptions.getGoogApiClientLibName(),
                GaxProperties.getLibraryVersion(options.getClass()))
            .setTransportToken(
                GaxGrpcProperties.getGrpcTokenName(), GaxGrpcProperties.getGrpcVersion())
            .build();
    HeaderProvider mergedHeaderProvider = options.getMergedHeaderProvider(internalHeaderProvider);

    this.metadataProvider =
        DatastoreMetadataProvider.create(
            mergedHeaderProvider.getHeaders(),
            internalHeaderProviderBuilder.getResourceHeaderKey());
    try{
      if (options.getHost().contains("localhost")
          || NoCredentials.getInstance().equals(options.getCredentials())) {
        ManagedChannel managedChannel =
            ManagedChannelBuilder.forTarget(options.getHost())
                .usePlaintext(true)
                .executor(executor)
                .build();
        TransportChannel transportChannel = GrpcTransportChannel.create(managedChannel);

        clientContext =
            ClientContext.newBuilder()
                .setCredentials(options.getCredentials())
                .setExecutor(executor)
                .setTransportChannel(transportChannel)
                .setDefaultCallContext(GrpcCallContext.of(managedChannel, CallOptions.DEFAULT))
                .setBackgroundResources(
                    Collections.<BackgroundResource>singletonList(transportChannel))
                .build();
        ApiFunction<UnaryCallSettings.Builder<?, ?>, Void> retrySettingsSetter =
            new ApiFunction<Builder<?, ?>, Void>() {
              @Override
              public Void apply(UnaryCallSettings.Builder<?, ?> builder) {
                builder.setRetrySettings(options.getRetrySettings());
                return null;
              }
            };
        DatastoreStubSettings.Builder datastoreBuilder =
            DatastoreStubSettings.newBuilder(clientContext)
                .applyToAllUnaryMethods(retrySettingsSetter);

        this.datastoreStub = GrpcDatastoreStub
            .create(datastoreBuilder
                .setTransportChannelProvider(GrpcTransportOptions.setUpChannelProvider(
                    DatastoreSettings.defaultGrpcTransportProviderBuilder(), options))
                .setCredentialsProvider(GrpcTransportOptions.setUpCredentialsProvider(options))
                .build());
      } else {
        ManagedChannel managedChannel =
            ManagedChannelBuilder.forTarget(options.getHost()).build();
        TransportChannel transportChannel = GrpcTransportChannel.create(managedChannel);
        clientContext =
            ClientContext.newBuilder()
                .setCredentials(options.getCredentials())
                .setTransportChannel(transportChannel)
                .setDefaultCallContext(GrpcCallContext.of(managedChannel, CallOptions.DEFAULT))
                .setBackgroundResources(
                    Collections.<BackgroundResource>singletonList(transportChannel))
                .build();
        this.datastoreStub =
            GrpcDatastoreStub.create(
                DatastoreStubSettings.newBuilder(clientContext)
                    .setTransportChannelProvider(GrpcTransportOptions.setUpChannelProvider(
                        DatastoreSettings.defaultGrpcTransportProviderBuilder(), options))
                    .setCredentialsProvider(GrpcTransportOptions.setUpCredentialsProvider(options))
                    .applyToAllUnaryMethods(
                        new ApiFunction<UnaryCallSettings.Builder<?, ?>, Void>() {
                          @Override
                          public Void apply(UnaryCallSettings.Builder<?, ?> builder) {
                            builder.setRetryableCodes(ImmutableSet.<StatusCode.Code>of());
                            return null;
                          }
                        })
                    .build());

      }
    } catch (Exception e) {
      throw newDatastoreException(e);
    }
  }

  @Override
  public AllocateIdsResponse allocateIds(AllocateIdsRequest request) {
    GrpcCallContext context = newCallContext(projectName);
    return get(datastoreStub.allocateIdsCallable().futureCall(request, context));
  }

  @Override
  public BeginTransactionResponse beginTransaction(BeginTransactionRequest request)
      throws DatastoreException {
    GrpcCallContext context = newCallContext(projectName);
    return get(datastoreStub.beginTransactionCallable().futureCall(request, context));
  }

  @Override
  public CommitResponse commit(CommitRequest request) {
    GrpcCallContext context = newCallContext(projectName);
    return get(datastoreStub.commitCallable().futureCall(request, context));
  }

  @Override
  public LookupResponse lookup(LookupRequest request) {
    GrpcCallContext context = newCallContext(projectName);
    return get(datastoreStub.lookupCallable().futureCall(request, context));
  }

  @Override
  public RollbackResponse rollback(RollbackRequest request) {
    GrpcCallContext context = newCallContext(projectName);
    return get(datastoreStub.rollbackCallable().futureCall(request, context));
  }

  @Override
  public RunQueryResponse runQuery(RunQueryRequest request) {
    GrpcCallContext context = newCallContext(projectName);
    return get(datastoreStub.runQueryCallable().futureCall(request, context));
  }

  // This class is needed solely to get access to protected method setInternalHeaderProvider()
  private static class DatastoreSettingsBuilder extends DatastoreSettings.Builder {

    private DatastoreSettingsBuilder(DatastoreSettings settings) {
      super(settings);
    }

    @Override
    protected DatastoreSettings.Builder setInternalHeaderProvider(
        HeaderProvider internalHeaderProvider) {
      return super.setInternalHeaderProvider(internalHeaderProvider);
    }
  }

  private GrpcCallContext newCallContext(String resource) {
    GrpcCallContext context = GrpcCallContext.createDefault();
    context = context.withExtraHeaders(metadataProvider.newExtraHeaders(resource, projectName));
    return context.withStreamWaitTimeout(waitTimeout).withStreamIdleTimeout(idleTimeout);
  }

  private static Duration systemProperty(String name, int defaultValue) {
    String stringValue = System.getProperty(name, "");
    return Duration.ofSeconds(stringValue.isEmpty() ? defaultValue : Integer.parseInt(stringValue));
  }

  /**
   * Gets the result of an async RPC call, handling any exceptions encountered.
   */
  private static <T> T get(final Future<T> future) throws DatastoreException {
    final Context context = Context.current();
    try {
      return future.get();
    } catch (InterruptedException e) {
      future.cancel(true);
      throw DatastoreExceptionFactory.propagateInterrupt(e);
    } catch (ExecutionException | CancellationException e) {
      throw newDatastoreException(context, e);
    }
  }

  private static <V> ApiFuture<V> translate(
      ApiFuture<V> from, final boolean idempotent, StatusCode.Code... returnNullOn) {
    final Set<Code> returnNullOnSet;
    if (returnNullOn.length > 0) {
      returnNullOnSet = EnumSet.of(returnNullOn[0], returnNullOn);
    } else {
      returnNullOnSet = Collections.emptySet();
    }
    return ApiFutures.catching(
        from,
        ApiException.class,
        new ApiFunction<ApiException, V>() {
          @Override
          public V apply(ApiException exception) {
            if (returnNullOnSet.contains(exception.getStatusCode().getCode())) {
              return null;
            }
            throw newDatastoreException(exception);
          }
        });
  }


}
