/*
 * Copyright 2019 Google LLC
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     https://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package com.google.cloud.bigtable.data.v2;

import static com.google.common.truth.Truth.assertThat;

import com.google.api.core.ApiClock;
import com.google.api.gax.core.CredentialsProvider;
import com.google.api.gax.core.ExecutorProvider;
import com.google.api.gax.rpc.TransportChannelProvider;
import com.google.api.gax.rpc.WatchdogProvider;
import com.google.bigtable.v2.BigtableGrpc;
import com.google.bigtable.v2.MutateRowRequest;
import com.google.bigtable.v2.MutateRowResponse;
import com.google.cloud.bigtable.data.v2.internal.NameUtil;
import com.google.cloud.bigtable.data.v2.models.RowMutation;
import com.google.common.base.Preconditions;
import io.grpc.stub.StreamObserver;
import java.io.IOException;
import java.lang.reflect.Method;
import org.junit.After;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;
import org.mockito.Mockito;
import org.mockito.invocation.InvocationOnMock;
import org.mockito.junit.MockitoJUnit;
import org.mockito.junit.MockitoRule;
import org.mockito.stubbing.Answer;

@RunWith(JUnit4.class)
public class BigtableDataClientFactoryTest {
  @Rule public MockitoRule mockitoRule = MockitoJUnit.rule();

  private static final String DEFAULT_PROJECT_ID = "fake-project";
  private static final String DEFAULT_INSTANCE_ID = "fake-instance";
  private static final String DEFAULT_APP_PROFILE_ID = "fake-app-profile";

  private FakeServiceHelper serviceHelper;
  private FakeBigtableService service;

  private TransportChannelProvider transportChannelProvider;
  private CredentialsProvider credentialsProvider;
  private ExecutorProvider executorProvider;
  private WatchdogProvider watchdogProvider;
  private ApiClock apiClock;
  private BigtableDataSettings defaultSettings;

  @Before
  public void setUp() throws IOException {
    service = new FakeBigtableService();

    serviceHelper = new FakeServiceHelper(service);
    serviceHelper.start();

    BigtableDataSettings.Builder builder =
        BigtableDataSettings.newBuilderForEmulator(serviceHelper.getPort())
            .setProjectId(DEFAULT_PROJECT_ID)
            .setInstanceId(DEFAULT_INSTANCE_ID)
            .setAppProfileId(DEFAULT_APP_PROFILE_ID);

    transportChannelProvider =
        Mockito.mock(
            TransportChannelProvider.class,
            new BuilderAnswer<>(
                TransportChannelProvider.class,
                builder.stubSettings().getTransportChannelProvider()));

    credentialsProvider =
        Mockito.mock(
            CredentialsProvider.class,
            new BuilderAnswer<>(
                CredentialsProvider.class, builder.stubSettings().getCredentialsProvider()));

    executorProvider =
        Mockito.mock(
            ExecutorProvider.class,
            new BuilderAnswer<>(
                ExecutorProvider.class, builder.stubSettings().getExecutorProvider()));

    watchdogProvider =
        Mockito.mock(
            WatchdogProvider.class,
            new BuilderAnswer<>(
                WatchdogProvider.class, builder.stubSettings().getStreamWatchdogProvider()));

    apiClock = builder.stubSettings().getClock();

    builder
        .stubSettings()
        .setTransportChannelProvider(transportChannelProvider)
        .setCredentialsProvider(credentialsProvider)
        .setExecutorProvider(executorProvider)
        .setStreamWatchdogProvider(watchdogProvider)
        .setClock(apiClock);

    defaultSettings = builder.build();
  }

  @After
  public void tearDown() {
    serviceHelper.shutdown();
  }

  @Test
  public void testNewClientsShareTransportChannel() throws Exception {

    // Create 3 lightweight clients

    try (BigtableDataClientFactory factory = BigtableDataClientFactory.create(defaultSettings);
        BigtableDataClient ignored1 = factory.createForInstance("project1", "instance1");
        BigtableDataClient ignored2 = factory.createForInstance("project2", "instance2");
        BigtableDataClient ignored3 = factory.createForInstance("project3", "instance3")) {

      // Make sure that only 1 instance is created by each provider
      Mockito.verify(transportChannelProvider, Mockito.times(1)).getTransportChannel();
      Mockito.verify(credentialsProvider, Mockito.times(1)).getCredentials();
      Mockito.verify(executorProvider, Mockito.times(1)).getExecutor();
      Mockito.verify(watchdogProvider, Mockito.times(1)).getWatchdog();
    }
  }

  @Test
  public void testCreateDefaultKeepsSettings() throws Exception {
    try (BigtableDataClientFactory factory = BigtableDataClientFactory.create(defaultSettings);
        BigtableDataClient client = factory.createDefault()) {

      client.mutateRow(RowMutation.create("some-table", "some-key").deleteRow());
    }

    assertThat(service.lastRequest.getTableName())
        .isEqualTo(NameUtil.formatTableName(DEFAULT_PROJECT_ID, DEFAULT_INSTANCE_ID, "some-table"));
    assertThat(service.lastRequest.getAppProfileId()).isEqualTo(DEFAULT_APP_PROFILE_ID);
  }

  @Test
  public void testCreateForAppProfileHasCorrectSettings() throws Exception {
    try (BigtableDataClientFactory factory = BigtableDataClientFactory.create(defaultSettings);
        BigtableDataClient client = factory.createForAppProfile("other-app-profile")) {

      client.mutateRow(RowMutation.create("some-table", "some-key").deleteRow());
    }

    assertThat(service.lastRequest.getTableName())
        .isEqualTo(NameUtil.formatTableName(DEFAULT_PROJECT_ID, DEFAULT_INSTANCE_ID, "some-table"));
    assertThat(service.lastRequest.getAppProfileId()).isEqualTo("other-app-profile");
  }

  @Test
  public void testCreateForInstanceHasCorrectSettings() throws Exception {

    try (BigtableDataClientFactory factory = BigtableDataClientFactory.create(defaultSettings);
        BigtableDataClient client = factory.createForInstance("other-project", "other-instance")) {

      client.mutateRow(RowMutation.create("some-table", "some-key").deleteRow());
    }

    assertThat(service.lastRequest.getTableName())
        .isEqualTo(NameUtil.formatTableName("other-project", "other-instance", "some-table"));
    // app profile should be reset to default
    assertThat(service.lastRequest.getAppProfileId()).isEmpty();
  }

  @Test
  public void testCreateForInstanceWithAppProfileHasCorrectSettings() throws Exception {
    try (BigtableDataClientFactory factory = BigtableDataClientFactory.create(defaultSettings);
        BigtableDataClient client =
            factory.createForInstance("other-project", "other-instance", "other-app-profile")) {

      client.mutateRow(RowMutation.create("some-table", "some-key").deleteRow());
    }

    assertThat(service.lastRequest.getTableName())
        .isEqualTo(NameUtil.formatTableName("other-project", "other-instance", "some-table"));
    // app profile should be reset to default
    assertThat(service.lastRequest.getAppProfileId()).isEqualTo("other-app-profile");
  }

  private static class FakeBigtableService extends BigtableGrpc.BigtableImplBase {
    volatile MutateRowRequest lastRequest;

    @Override
    public void mutateRow(
        MutateRowRequest request, StreamObserver<MutateRowResponse> responseObserver) {
      lastRequest = request;
      responseObserver.onNext(MutateRowResponse.getDefaultInstance());
      responseObserver.onCompleted();
    }
  }

  private static class BuilderAnswer<T> implements Answer {
    private final Class<T> targetClass;
    private T targetInstance;

    private BuilderAnswer(Class<T> targetClass, T targetInstance) {
      this.targetClass = targetClass;
      this.targetInstance = targetInstance;
    }

    @Override
    public Object answer(InvocationOnMock invocation) throws Throwable {
      Method method = invocation.getMethod();
      Object r = invocation.getMethod().invoke(targetInstance, invocation.getArguments());

      if (method.getName().startsWith("with")
          && targetClass.isAssignableFrom(method.getReturnType())) {
        this.targetInstance = castToTarget(r);
        r = invocation.getMock();
      }
      return r;
    }

    @SuppressWarnings("unchecked")
    private T castToTarget(Object o) {
      Preconditions.checkArgument(
          targetClass.isAssignableFrom(targetClass), "Expected instance of " + targetClass);
      return (T) o;
    }
  }
}
