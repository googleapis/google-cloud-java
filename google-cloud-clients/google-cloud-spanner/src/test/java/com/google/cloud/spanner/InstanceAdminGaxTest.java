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

package com.google.cloud.spanner;

import static org.junit.Assert.fail;

import com.google.api.core.ApiFunction;
import com.google.api.gax.grpc.testing.LocalChannelProvider;
import com.google.api.gax.longrunning.OperationFuture;
import com.google.api.gax.paging.Page;
import com.google.api.gax.retrying.RetrySettings;
import com.google.api.gax.rpc.UnaryCallSettings;
import com.google.api.gax.rpc.UnaryCallSettings.Builder;
import com.google.cloud.NoCredentials;
import com.google.cloud.spanner.admin.instance.v1.MockInstanceAdminImpl;
import com.google.common.base.Throwables;
import com.google.common.collect.Lists;
import com.google.protobuf.AbstractMessage;
import com.google.protobuf.Any;
import com.google.protobuf.Empty;
import com.google.spanner.admin.instance.v1.CreateInstanceMetadata;
import com.google.spanner.admin.instance.v1.InstanceConfig;
import com.google.spanner.admin.instance.v1.InstanceConfigName;
import com.google.spanner.admin.instance.v1.InstanceName;
import com.google.spanner.admin.instance.v1.ListInstanceConfigsRequest;
import com.google.spanner.admin.instance.v1.ListInstanceConfigsResponse;
import com.google.spanner.admin.instance.v1.ListInstancesRequest;
import com.google.spanner.admin.instance.v1.ListInstancesResponse;
import com.google.spanner.admin.instance.v1.ProjectName;
import com.google.spanner.admin.instance.v1.UpdateInstanceMetadata;
import io.grpc.Server;
import io.grpc.StatusRuntimeException;
import io.grpc.inprocess.InProcessServerBuilder;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.List;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ScheduledThreadPoolExecutor;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Assert;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.junit.runners.Parameterized.Parameter;
import org.junit.runners.Parameterized.Parameters;
import org.threeten.bp.Duration;

@RunWith(Parameterized.class)
public class InstanceAdminGaxTest {
  public static class DelayedStatusRuntimeException extends RuntimeException {
    private final long millis;
    private boolean hasWaited = false;

    public DelayedStatusRuntimeException(StatusRuntimeException cause, long millis) {
      super(cause);
      this.millis = millis;
    }

    @Override
    public synchronized Throwable getCause() {
      if (!hasWaited) {
        try {
          Thread.sleep(millis);
          hasWaited = true;
        } catch (InterruptedException e) {
          Thread.currentThread().interrupt();
        }
      }
      return super.getCause();
    }
  }

  private static final String PROJECT = "PROJECT";
  private static final StatusRuntimeException UNAVAILABLE =
      io.grpc.Status.UNAVAILABLE.withDescription("Retryable test exception.").asRuntimeException();
  private static final StatusRuntimeException FAILED_PRECONDITION =
      io.grpc.Status.FAILED_PRECONDITION
          .withDescription("Non-retryable test exception.")
          .asRuntimeException();

  private static Exception createDelayedInternal() {
    return new DelayedStatusRuntimeException(
        io.grpc.Status.INTERNAL.withDescription("Delayed test exception.").asRuntimeException(),
        500L);
  }

  public static enum ExceptionType {
    RETRYABLE {
      @Override
      public Exception getException() {
        return UNAVAILABLE;
      }

      @Override
      public ErrorCode getExpectedErrorCodeWithGax() {
        return null;
      }

      @Override
      public ErrorCode getExpectedErrorCodeWithoutGax() {
        return ErrorCode.UNAVAILABLE;
      }

      @Override
      public boolean isRetryable() {
        return true;
      }
    },
    NON_RETRYABLE {
      @Override
      public Exception getException() {
        return FAILED_PRECONDITION;
      }

      @Override
      public ErrorCode getExpectedErrorCodeWithGax() {
        return ErrorCode.FAILED_PRECONDITION;
      }

      @Override
      public ErrorCode getExpectedErrorCodeWithoutGax() {
        return ErrorCode.FAILED_PRECONDITION;
      }

      @Override
      public boolean isRetryable() {
        return false;
      }
    },
    DELAYED {
      @Override
      public Exception getException() {
        return createDelayedInternal();
      }

      @Override
      public ErrorCode getExpectedErrorCodeWithGax() {
        return ErrorCode.DEADLINE_EXCEEDED;
      }

      @Override
      public ErrorCode getExpectedErrorCodeWithoutGax() {
        return ErrorCode.INTERNAL;
      }

      @Override
      public boolean isRetryable() {
        return true;
      }
    };

    public abstract Exception getException();

    public abstract ErrorCode getExpectedErrorCodeWithGax();

    public abstract ErrorCode getExpectedErrorCodeWithoutGax();

    public abstract boolean isRetryable();
  }

  private static MockInstanceAdminImpl mockInstanceAdmin;
  private static Server server;
  private static Spanner spanner;
  private static InstanceAdminClient client;
  private static LocalChannelProvider channelProvider;

  @Parameter(0)
  public int exceptionAtCall;

  @Parameter(1)
  public ExceptionType exceptionType;

  @Parameters(name = "exception at call = {0}, exception type = {1}")
  public static Collection<Object[]> data() {
    List<Object[]> params = new ArrayList<>();
    for (int exceptionAtCall : new int[] {0, 1}) {
      for (ExceptionType exceptionType : ExceptionType.values()) {
        params.add(new Object[] {exceptionAtCall, exceptionType});
      }
    }
    return params;
  }

  @Rule public ExpectedException expectedException = ExpectedException.none();

  @BeforeClass
  public static void startStaticServer() throws IOException {
    mockInstanceAdmin = new MockInstanceAdminImpl();
    String uniqueName = InProcessServerBuilder.generateName();
    server =
        InProcessServerBuilder.forName(uniqueName)
            // We need to use a real executor for timeouts to occur.
            .scheduledExecutorService(new ScheduledThreadPoolExecutor(1))
            .addService(mockInstanceAdmin)
            .build()
            .start();
    channelProvider = LocalChannelProvider.create(uniqueName);
  }

  @AfterClass
  public static void stopServer() {
    server.shutdown();
  }

  @Before
  public void setUp() throws Exception {
    mockInstanceAdmin.reset();
    final RetrySettings retrySettings =
        RetrySettings.newBuilder()
            .setInitialRpcTimeout(Duration.ofMillis(200L))
            .setMaxRpcTimeout(Duration.ofMillis(1000L))
            .setMaxAttempts(3)
            .setTotalTimeout(Duration.ofMillis(5000L))
            .build();
    SpannerOptions.Builder builder =
        SpannerOptions.newBuilder()
            .setProjectId(PROJECT)
            .setChannelProvider(channelProvider)
            .setCredentials(NoCredentials.getInstance());
    builder
        .getInstanceAdminStubSettingsBuilder()
        .applyToAllUnaryMethods(
            new ApiFunction<UnaryCallSettings.Builder<?, ?>, Void>() {
              @Override
              public Void apply(Builder<?, ?> input) {
                input.setRetrySettings(retrySettings);
                return null;
              }
            });
    if (!builder
        .getInstanceAdminStubSettingsBuilder()
        .createInstanceOperationSettings()
        .getInitialCallSettings()
        .getRetryableCodes()
        .isEmpty()) {
      builder
          .getInstanceAdminStubSettingsBuilder()
          .createInstanceOperationSettings()
          .setInitialCallSettings(
              builder
                  .getInstanceAdminStubSettingsBuilder()
                  .createInstanceOperationSettings()
                  .getInitialCallSettings()
                  .toBuilder()
                  .setRetrySettings(retrySettings)
                  .build());
    }
    if (!builder
        .getInstanceAdminStubSettingsBuilder()
        .updateInstanceOperationSettings()
        .getInitialCallSettings()
        .getRetryableCodes()
        .isEmpty()) {
      builder
          .getInstanceAdminStubSettingsBuilder()
          .updateInstanceOperationSettings()
          .setInitialCallSettings(
              builder
                  .getInstanceAdminStubSettingsBuilder()
                  .updateInstanceOperationSettings()
                  .getInitialCallSettings()
                  .toBuilder()
                  .setRetrySettings(retrySettings)
                  .build());
    }
    spanner = builder.build().getService();
    client = spanner.getInstanceAdminClient();
  }

  @After
  public void tearDown() throws Exception {
    spanner.close();
  }

  private Exception setupException() {
    if (!exceptionType.isRetryable()) {
      expectedException.expect(
          SpannerMatchers.isSpannerException(exceptionType.getExpectedErrorCodeWithGax()));
    }
    return exceptionType.getException();
  }

  @Test
  public void listInstanceConfigsTest() {
    Exception exception = setupException();
    String nextPageToken = "token%d";
    List<InstanceConfig> configs = new ArrayList<>(2);
    for (int i = 0; i < 2; i++) {
      configs.add(
          InstanceConfig.newBuilder()
              .setDisplayName(String.format("TEST%d", i))
              .setName(String.format("projects/%s/instanceConfigs/test%d", PROJECT, i))
              .build());
    }
    if (exceptionAtCall == 0) {
      mockInstanceAdmin.addException(exception);
    }
    for (int i = 0; i < 2; i++) {
      ListInstanceConfigsResponse.Builder builder =
          ListInstanceConfigsResponse.newBuilder()
              .addAllInstanceConfigs(Arrays.asList(configs.get(i)));
      if (i < (configs.size() - 1)) {
        builder.setNextPageToken(String.format(nextPageToken, i));
      }
      if (exceptionAtCall == (i + 1)) {
        mockInstanceAdmin.addException(exception);
      }
      mockInstanceAdmin.addResponse(builder.build());
    }
    ProjectName parent = ProjectName.of(PROJECT);
    Page<com.google.cloud.spanner.InstanceConfig> pagedListResponse = client.listInstanceConfigs();
    List<com.google.cloud.spanner.InstanceConfig> resources =
        Lists.newArrayList(pagedListResponse.iterateAll());
    Assert.assertEquals(2, resources.size());

    List<AbstractMessage> actualRequests = mockInstanceAdmin.getRequests();
    Assert.assertEquals(2, actualRequests.size());
    ListInstanceConfigsRequest actualRequest = (ListInstanceConfigsRequest) actualRequests.get(0);

    Assert.assertEquals(parent, ProjectName.parse(actualRequest.getParent()));
  }

  @Test
  public void getInstanceConfigTest() {
    Exception exception = setupException();
    for (int i = 0; i < 2; i++) {
      InstanceConfigName name2 = InstanceConfigName.of(PROJECT, "INSTANCE_CONFIG");
      String displayName = "displayName1615086568";
      InstanceConfig expectedResponse =
          InstanceConfig.newBuilder().setName(name2.toString()).setDisplayName(displayName).build();
      if (exceptionAtCall == 0) {
        mockInstanceAdmin.addException(exception);
      }
      mockInstanceAdmin.addResponse(expectedResponse);
      if (exceptionAtCall == 1) {
        mockInstanceAdmin.addException(exception);
      }

      InstanceConfigName name = InstanceConfigName.of(PROJECT, "INSTANCE_CONFIG");
      com.google.cloud.spanner.InstanceConfig actualResponse =
          client.getInstanceConfig(name.toString());

      Assert.assertEquals(displayName, actualResponse.getDisplayName());
      List<AbstractMessage> actualRequests = mockInstanceAdmin.getRequests();
      Assert.assertEquals(i + 1, actualRequests.size());
    }
  }

  @Test
  public void listInstancesTest() {
    Exception exception = setupException();
    String nextPageToken = "token%d";
    List<com.google.spanner.admin.instance.v1.Instance> instances = new ArrayList<>(2);
    for (int i = 0; i < 2; i++) {
      instances.add(
          com.google.spanner.admin.instance.v1.Instance.newBuilder()
              .setDisplayName(String.format("TEST%d", i))
              .setName(String.format("projects/%s/instances/test%d", PROJECT, i))
              .setConfig(String.format("projects/%s/instanceConfigs/test%d", PROJECT, i))
              .build());
    }
    if (exceptionAtCall == 0) {
      mockInstanceAdmin.addException(exception);
    }
    for (int i = 0; i < 2; i++) {
      ListInstancesResponse.Builder builder =
          ListInstancesResponse.newBuilder().addAllInstances(Arrays.asList(instances.get(i)));
      if (i < (instances.size() - 1)) {
        builder.setNextPageToken(String.format(nextPageToken, i));
      }
      if (exceptionAtCall == (i + 1)) {
        mockInstanceAdmin.addException(exception);
      }
      mockInstanceAdmin.addResponse(builder.build());
    }

    ProjectName parent = ProjectName.of(PROJECT);
    Page<Instance> pagedListResponse = client.listInstances();

    List<Instance> resources = Lists.newArrayList(pagedListResponse.iterateAll());
    Assert.assertEquals(2, resources.size());

    List<AbstractMessage> actualRequests = mockInstanceAdmin.getRequests();
    Assert.assertEquals(2, actualRequests.size());
    ListInstancesRequest actualRequest = (ListInstancesRequest) actualRequests.get(0);

    Assert.assertEquals(parent, ProjectName.parse(actualRequest.getParent()));
  }

  @Test
  public void getInstanceTest() {
    Exception exception = setupException();
    InstanceName name2 = InstanceName.of(PROJECT, "INSTANCE");
    String displayName = "displayName1615086568";
    InstanceConfigName config = InstanceConfigName.of(PROJECT, "INSTANCE_CONFIG");
    com.google.spanner.admin.instance.v1.Instance expectedResponse =
        com.google.spanner.admin.instance.v1.Instance.newBuilder()
            .setName(name2.toString())
            .setConfig(config.toString())
            .setDisplayName(displayName)
            .setNodeCount(3)
            .build();
    if (exceptionAtCall == 0) {
      mockInstanceAdmin.addException(exception);
    }
    mockInstanceAdmin.addResponse(expectedResponse);
    if (exceptionAtCall == 1) {
      mockInstanceAdmin.addException(exception);
    }
    mockInstanceAdmin.addResponse(expectedResponse);

    InstanceName name = InstanceName.of(PROJECT, "INSTANCE");
    for (int i = 0; i < 2; i++) {
      Instance actualResponse = client.getInstance(name.toString());
      Assert.assertEquals(displayName, actualResponse.getDisplayName());
    }

    List<AbstractMessage> actualRequests = mockInstanceAdmin.getRequests();
    Assert.assertEquals(2, actualRequests.size());
  }

  @Test
  public void createInstanceTest() throws Exception {
    Exception exception = setupException();
    InstanceName name = InstanceName.of(PROJECT, "INSTANCE");
    InstanceConfigName config = InstanceConfigName.of(PROJECT, "INSTANCE_CONFIG");
    String displayName = "displayName1615086568";
    int nodeCount = 1539922066;
    com.google.spanner.admin.instance.v1.Instance expectedResponse =
        com.google.spanner.admin.instance.v1.Instance.newBuilder()
            .setName(name.toString())
            .setConfig(config.toString())
            .setDisplayName(displayName)
            .setNodeCount(nodeCount)
            .build();
    com.google.longrunning.Operation resultOperation =
        com.google.longrunning.Operation.newBuilder()
            .setName("createInstanceTest")
            .setDone(true)
            .setResponse(Any.pack(expectedResponse))
            .build();
    if (exceptionAtCall == 0) {
      mockInstanceAdmin.addException(exception);
    }
    mockInstanceAdmin.addResponse(resultOperation);
    if (exceptionAtCall == 1) {
      mockInstanceAdmin.addException(exception);
    }
    mockInstanceAdmin.addResponse(resultOperation);

    boolean methodIsIdempotent =
        !spanner
            .getOptions()
            .getInstanceAdminStubSettings()
            .createInstanceOperationSettings()
            .getInitialCallSettings()
            .getRetryableCodes()
            .isEmpty();
    for (int i = 0; i < 2; i++) {
      OperationFuture<Instance, CreateInstanceMetadata> actualResponse =
          client.createInstance(
              InstanceInfo.newBuilder(InstanceId.of(PROJECT, "INSTANCE"))
                  .setDisplayName(displayName)
                  .setNodeCount(nodeCount)
                  .build());
      try {
        Instance returnedInstance = actualResponse.get();
        if (!methodIsIdempotent && i == exceptionAtCall) {
          fail("missing expected exception");
        }
        Assert.assertEquals(displayName, returnedInstance.getDisplayName());
      } catch (ExecutionException e) {
        if (!exceptionType.isRetryable() || methodIsIdempotent || i != exceptionAtCall) {
          Throwables.throwIfUnchecked(e.getCause());
          throw e;
        }
      }
    }
    List<AbstractMessage> actualRequests = mockInstanceAdmin.getRequests();
    if (methodIsIdempotent) {
      Assert.assertEquals(2, actualRequests.size());
    } else {
      Assert.assertEquals(1, actualRequests.size());
    }
  }

  @Test
  public void updateInstanceTest() throws Exception {
    Exception exception = setupException();
    InstanceName name = InstanceName.of(PROJECT, "INSTANCE");
    InstanceConfigName config = InstanceConfigName.of(PROJECT, "INSTANCE_CONFIG");
    String displayName = "displayName1615086568";
    int nodeCount = 1539922066;
    com.google.spanner.admin.instance.v1.Instance expectedResponse =
        com.google.spanner.admin.instance.v1.Instance.newBuilder()
            .setName(name.toString())
            .setConfig(config.toString())
            .setDisplayName(displayName)
            .setNodeCount(nodeCount)
            .build();
    com.google.longrunning.Operation resultOperation =
        com.google.longrunning.Operation.newBuilder()
            .setName("updateInstanceTest")
            .setDone(true)
            .setResponse(Any.pack(expectedResponse))
            .build();
    if (exceptionAtCall == 0) {
      mockInstanceAdmin.addException(exception);
    }
    mockInstanceAdmin.addResponse(resultOperation);
    if (exceptionAtCall == 1) {
      mockInstanceAdmin.addException(exception);
    }
    mockInstanceAdmin.addResponse(resultOperation);

    boolean methodIsIdempotent =
        !spanner
            .getOptions()
            .getInstanceAdminStubSettings()
            .updateInstanceOperationSettings()
            .getInitialCallSettings()
            .getRetryableCodes()
            .isEmpty();
    for (int i = 0; i < 2; i++) {
      OperationFuture<Instance, UpdateInstanceMetadata> actualResponse =
          client.updateInstance(
              InstanceInfo.newBuilder(InstanceId.of(PROJECT, "INSTANCE"))
                  .setDisplayName(displayName)
                  .setNodeCount(nodeCount)
                  .build());
      try {
        Instance returnedInstance = actualResponse.get();
        if (!methodIsIdempotent && i == exceptionAtCall) {
          fail("missing expected exception");
        }
        Assert.assertEquals(displayName, returnedInstance.getDisplayName());
      } catch (ExecutionException e) {
        if (!exceptionType.isRetryable() || methodIsIdempotent || i != exceptionAtCall) {
          Throwables.throwIfUnchecked(e.getCause());
          throw e;
        }
      }
    }
    List<AbstractMessage> actualRequests = mockInstanceAdmin.getRequests();
    if (methodIsIdempotent) {
      Assert.assertEquals(2, actualRequests.size());
    } else {
      Assert.assertEquals(1, actualRequests.size());
    }
  }

  @Test
  public void deleteInstanceTest() {
    Exception exception = setupException();
    Empty expectedResponse = Empty.newBuilder().build();
    if (exceptionAtCall == 0) {
      mockInstanceAdmin.addException(exception);
    }
    mockInstanceAdmin.addResponse(expectedResponse);
    if (exceptionAtCall == 1) {
      mockInstanceAdmin.addException(exception);
    }
    mockInstanceAdmin.addResponse(expectedResponse);
    for (int i = 0; i < 2; i++) {
      client.deleteInstance("INSTANCE");
    }

    List<AbstractMessage> actualRequests = mockInstanceAdmin.getRequests();
    Assert.assertEquals(2, actualRequests.size());
  }
}
