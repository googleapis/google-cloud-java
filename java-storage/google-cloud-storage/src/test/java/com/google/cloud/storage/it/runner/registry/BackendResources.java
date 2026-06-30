/*
 * Copyright 2022 Google LLC
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

package com.google.cloud.storage.it.runner.registry;

import static com.google.cloud.storage.it.runner.registry.RegistryApplicabilityPredicate.backendIs;
import static com.google.cloud.storage.it.runner.registry.RegistryApplicabilityPredicate.bucketTypeIs;
import static com.google.cloud.storage.it.runner.registry.RegistryApplicabilityPredicate.isDefaultBucket;
import static com.google.cloud.storage.it.runner.registry.RegistryApplicabilityPredicate.transportAndBackendAre;

import com.google.api.gax.core.NoCredentialsProvider;
import com.google.api.gax.grpc.InstantiatingGrpcChannelProvider;
import com.google.cloud.NoCredentials;
import com.google.cloud.storage.BucketInfo;
import com.google.cloud.storage.BucketInfo.CustomPlacementConfig;
import com.google.cloud.storage.BucketInfo.HierarchicalNamespace;
import com.google.cloud.storage.BucketInfo.IamConfiguration;
import com.google.cloud.storage.GrpcStorageOptions;
import com.google.cloud.storage.HttpStorageOptions;
import com.google.cloud.storage.Storage;
import com.google.cloud.storage.StorageClass;
import com.google.cloud.storage.StorageOptions;
import com.google.cloud.storage.TransportCompatibility.Transport;
import com.google.cloud.storage.it.GrpcPlainRequestLoggingInterceptor;
import com.google.cloud.storage.it.runner.annotations.Backend;
import com.google.cloud.storage.it.runner.annotations.BucketType;
import com.google.common.base.MoreObjects;
import com.google.common.collect.ImmutableList;
import com.google.storage.control.v2.StorageControlClient;
import com.google.storage.control.v2.StorageControlSettings;
import com.google.storage.control.v2.stub.StorageControlStubSettings;
import io.grpc.ManagedChannelBuilder;
import java.io.IOException;
import java.net.URI;
import java.util.Locale;
import java.util.UUID;

/** The set of resources which are defined for a single backend. */
final class BackendResources implements ManagedLifecycle {

  private final Backend backend;
  private final ProtectedBucketNames protectedBucketNames;

  private final ImmutableList<RegistryEntry<?>> registryEntries;

  private BackendResources(
      Backend backend,
      ProtectedBucketNames protectedBucketNames,
      ImmutableList<RegistryEntry<?>> registryEntries) {
    this.backend = backend;
    this.protectedBucketNames = protectedBucketNames;
    this.registryEntries = registryEntries;
  }

  public ImmutableList<RegistryEntry<?>> getRegistryEntries() {
    return registryEntries;
  }

  @Override
  public Object get() {
    return this;
  }

  @Override
  public void start() {}

  @Override
  public void stop() {
    protectedBucketNames.stop();
  }

  @Override
  public String toString() {
    return MoreObjects.toStringHelper(this).add("backend", backend).toString();
  }

  @SuppressWarnings("SwitchStatementWithTooFewBranches")
  static BackendResources of(
      Backend backend,
      TestRunScopedInstance<OtelSdkShim> otelSdk,
      TestRunScopedInstance<Zone.ZoneShim> zone) {
    ProtectedBucketNames protectedBucketNames = new ProtectedBucketNames();
    TestRunScopedInstance<StorageInstance> storageJson =
        TestRunScopedInstance.of(
            "fixture/STORAGE/[JSON][" + backend.name() + "]",
            () -> {
              HttpStorageOptions.Builder optionsBuilder;
              switch (backend) {
                case TEST_BENCH:
                  optionsBuilder =
                      StorageOptions.http()
                          .setCredentials(NoCredentials.getInstance())
                          .setHost(Registry.getInstance().testBench().getBaseUri())
                          .setProjectId("test-project-id");
                  break;
                default: // PROD, java8 doesn't have exhaustive checking for enum switch
                  // Register the exporters with OpenTelemetry
                  optionsBuilder = StorageOptions.http().setOpenTelemetry(otelSdk.get().get());
                  break;
              }
              HttpStorageOptions built = optionsBuilder.build();
              return new StorageInstance(built, protectedBucketNames);
            });
    TestRunScopedInstance<StorageInstance> storageGrpc =
        TestRunScopedInstance.of(
            "fixture/STORAGE/[GRPC][" + backend.name() + "]",
            () -> {
              GrpcStorageOptions.Builder optionsBuilder;
              switch (backend) {
                case TEST_BENCH:
                  optionsBuilder =
                      StorageOptions.grpc()
                          .setGrpcInterceptorProvider(
                              GrpcPlainRequestLoggingInterceptor.getInterceptorProvider())
                          .setCredentials(NoCredentials.getInstance())
                          .setHost(Registry.getInstance().testBench().getGRPCBaseUri())
                          .setAttemptDirectPath(false)
                          .setProjectId("test-project-id");
                  break;
                default: // PROD, java8 doesn't have exhaustive checking for enum switch
                  // Register the exporters with OpenTelemetry
                  optionsBuilder = StorageOptions.grpc().setOpenTelemetry(otelSdk.get().get());
                  break;
              }
              GrpcStorageOptions built =
                  optionsBuilder
                      .setGrpcInterceptorProvider(
                          GrpcPlainRequestLoggingInterceptor.getInterceptorProvider())
                      .setEnableGrpcClientMetrics(false)
                      .build();
              return new StorageInstance(built, protectedBucketNames);
            });
    TestRunScopedInstance<StorageControlInstance> ctrl =
        TestRunScopedInstance.of(
            "fixture/STORAGE_CONTROL/[" + backend.name() + "]",
            () -> {
              StorageControlSettings.Builder builder;
              switch (backend) {
                case TEST_BENCH:
                  String baseUri = Registry.getInstance().testBench().getGRPCBaseUri();
                  URI uri = URI.create(baseUri);
                  String endpoint = String.format(Locale.US, "%s:%d", uri.getHost(), uri.getPort());
                  InstantiatingGrpcChannelProvider.Builder b =
                      StorageControlStubSettings.defaultGrpcTransportProviderBuilder()
                          .setInterceptorProvider(
                              GrpcPlainRequestLoggingInterceptor.getInterceptorProvider())
                          .setEndpoint(endpoint);
                  if (uri.getScheme().equals("http")) {
                    b.setChannelConfigurator(ManagedChannelBuilder::usePlaintext);
                  }
                  InstantiatingGrpcChannelProvider instantiatingGrpcChannelProvider = b.build();
                  builder =
                      StorageControlSettings.newBuilder()
                          .setCredentialsProvider(NoCredentialsProvider.create())
                          .setEndpoint(endpoint)
                          .setTransportChannelProvider(instantiatingGrpcChannelProvider);
                  break;
                default: // PROD, java8 doesn't have exhaustive checking for enum switch
                  builder =
                      StorageControlSettings.newBuilder()
                          .setTransportChannelProvider(
                              StorageControlStubSettings.defaultGrpcTransportProviderBuilder()
                                  .setInterceptorProvider(
                                      GrpcPlainRequestLoggingInterceptor.getInterceptorProvider())
                                  .build());
                  break;
              }

              try {
                StorageControlSettings settings = builder.build();
                return new StorageControlInstance(settings);
              } catch (IOException e) {
                throw new RuntimeException(e);
              }
            });
    TestRunScopedInstance<BucketInfoShim> bucket =
        TestRunScopedInstance.of(
            "fixture/BUCKET/[" + backend.name() + "]",
            () -> {
              String bucketName =
                  String.format(Locale.US, "java-storage-grpc-%s", UUID.randomUUID());
              protectedBucketNames.add(bucketName);
              return new BucketInfoShim(
                  BucketInfo.newBuilder(bucketName)
                      .setLocation(zone.get().get().getRegion())
                      .build(),
                  storageJson.get().getStorage(),
                  ctrl.get().getCtrl());
            });
    TestRunScopedInstance<BucketInfoShim> bucketRp =
        TestRunScopedInstance.of(
            "fixture/BUCKET/[" + backend.name() + "]/REQUESTER_PAYS",
            () -> {
              String bucketName =
                  String.format(Locale.US, "java-storage-grpc-rp-%s", UUID.randomUUID());
              protectedBucketNames.add(bucketName);
              return new BucketInfoShim(
                  BucketInfo.newBuilder(bucketName)
                      .setLocation(zone.get().get().getRegion())
                      .setRequesterPays(true)
                      .build(),
                  storageJson.get().getStorage(),
                  ctrl.get().getCtrl());
            });
    TestRunScopedInstance<BucketInfoShim> bucketVersioned =
        TestRunScopedInstance.of(
            "fixture/BUCKET/[" + backend.name() + "]/VERSIONED",
            () -> {
              String bucketName =
                  String.format(Locale.US, "java-storage-grpc-v-%s", UUID.randomUUID());
              protectedBucketNames.add(bucketName);
              return new BucketInfoShim(
                  BucketInfo.newBuilder(bucketName)
                      .setLocation(zone.get().get().getRegion())
                      .setVersioningEnabled(true)
                      .build(),
                  storageJson.get().getStorage(),
                  ctrl.get().getCtrl());
            });
    TestRunScopedInstance<BucketInfoShim> bucketHns =
        TestRunScopedInstance.of(
            "fixture/BUCKET/[" + backend.name() + "]/HNS",
            () -> {
              String bucketName =
                  String.format(Locale.US, "java-storage-grpc-hns-%s", UUID.randomUUID());
              protectedBucketNames.add(bucketName);
              return new BucketInfoShim(
                  BucketInfo.newBuilder(bucketName)
                      .setLocation(zone.get().get().getRegion())
                      .setHierarchicalNamespace(
                          HierarchicalNamespace.newBuilder().setEnabled(true).build())
                      .setIamConfiguration(
                          IamConfiguration.newBuilder()
                              .setIsUniformBucketLevelAccessEnabled(true)
                              .build())
                      .build(),
                  storageJson.get().getStorage(),
                  ctrl.get().getCtrl());
            });
    TestRunScopedInstance<BucketInfoShim> bucketRapid =
        TestRunScopedInstance.of(
            "fixture/BUCKET/[" + backend.name() + "]/RAPID",
            () -> {
              String bucketName =
                  String.format(Locale.US, "java-storage-grpc-rapid-%s", UUID.randomUUID());
              protectedBucketNames.add(bucketName);
              return new BucketInfoShim(
                  BucketInfo.newBuilder(bucketName)
                      .setLocation(zone.get().get().getRegion())
                      .setCustomPlacementConfig(
                          CustomPlacementConfig.newBuilder()
                              .setDataLocations(ImmutableList.of(zone.get().get().getZone()))
                              .build())
                      .setStorageClass(StorageClass.valueOf("RAPID"))
                      .setHierarchicalNamespace(
                          HierarchicalNamespace.newBuilder().setEnabled(true).build())
                      .setIamConfiguration(
                          IamConfiguration.newBuilder()
                              .setIsUniformBucketLevelAccessEnabled(true)
                              .build())
                      .build(),
                  storageJson.get().getStorage(),
                  ctrl.get().getCtrl());
            });
    TestRunScopedInstance<ObjectsFixture> objectsFixture =
        TestRunScopedInstance.of(
            "fixture/OBJECTS/[" + backend.name() + "]",
            () -> new ObjectsFixture(storageJson.get().getStorage(), bucket.get().getBucketInfo()));
    TestRunScopedInstance<ObjectsFixture> objectsFixtureRp =
        TestRunScopedInstance.of(
            "fixture/OBJECTS/[" + backend.name() + "]/REQUESTER_PAYS",
            () ->
                new ObjectsFixture(storageJson.get().getStorage(), bucketRp.get().getBucketInfo()));
    TestRunScopedInstance<ObjectsFixture> objectsFixtureHns =
        TestRunScopedInstance.of(
            "fixture/OBJECTS/[" + backend.name() + "]/HNS",
            () ->
                new ObjectsFixture(
                    storageJson.get().getStorage(), bucketHns.get().getBucketInfo()));
    TestRunScopedInstance<KmsFixture> kmsFixture =
        TestRunScopedInstance.of(
            "fixture/KMS/[" + backend.name() + "]",
            () -> KmsFixture.of(storageJson.get().getStorage(), zone.get().get()));

    return new BackendResources(
        backend,
        protectedBucketNames,
        ImmutableList.of(
            RegistryEntry.of(
                40, Storage.class, storageJson, transportAndBackendAre(Transport.HTTP, backend)),
            RegistryEntry.of(
                50, Storage.class, storageGrpc, transportAndBackendAre(Transport.GRPC, backend)),
            RegistryEntry.of(55, StorageControlClient.class, ctrl, backendIs(backend)),
            RegistryEntry.of(
                60,
                BucketInfo.class,
                bucketRp,
                backendIs(backend).and(bucketTypeIs(BucketType.REQUESTER_PAYS))),
            RegistryEntry.of(
                61,
                BucketInfo.class,
                bucketHns,
                backendIs(backend).and(bucketTypeIs(BucketType.HNS))),
            RegistryEntry.of(
                62,
                BucketInfo.class,
                bucketVersioned,
                backendIs(backend).and(bucketTypeIs(BucketType.VERSIONED))),
            RegistryEntry.of(
                63,
                BucketInfo.class,
                bucketRapid,
                backendIs(backend).and(bucketTypeIs(BucketType.RAPID))),
            RegistryEntry.of(
                70, BucketInfo.class, bucket, backendIs(backend).and(isDefaultBucket())),
            RegistryEntry.of(
                80,
                ObjectsFixture.class,
                objectsFixture,
                backendIs(backend).and(isDefaultBucket())),
            RegistryEntry.of(
                90,
                ObjectsFixture.class,
                objectsFixtureRp,
                backendIs(backend).and(bucketTypeIs(BucketType.REQUESTER_PAYS))),
            RegistryEntry.of(
                91,
                ObjectsFixture.class,
                objectsFixtureHns,
                backendIs(backend).and(bucketTypeIs(BucketType.HNS))),
            RegistryEntry.of(100, KmsFixture.class, kmsFixture, backendIs(backend))));
  }
}
