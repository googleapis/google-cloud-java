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

import com.google.api.core.ApiFunction;
import com.google.api.gax.grpc.testing.LocalChannelProvider;
import com.google.api.gax.longrunning.OperationFuture;
import com.google.api.gax.paging.Page;
import com.google.api.gax.retrying.RetrySettings;
import com.google.api.gax.rpc.StatusCode;
import com.google.api.gax.rpc.UnaryCallSettings;
import com.google.api.gax.rpc.UnaryCallSettings.Builder;
import com.google.cloud.NoCredentials;
import com.google.cloud.spanner.admin.database.v1.MockDatabaseAdminImpl;
import com.google.common.base.Throwables;
import com.google.common.collect.ImmutableSet;
import com.google.common.collect.Lists;
import com.google.protobuf.AbstractMessage;
import com.google.protobuf.Any;
import com.google.protobuf.Empty;
import com.google.spanner.admin.database.v1.CreateDatabaseMetadata;
import com.google.spanner.admin.database.v1.DatabaseName;
import com.google.spanner.admin.database.v1.ListDatabasesRequest;
import com.google.spanner.admin.database.v1.ListDatabasesResponse;
import com.google.spanner.admin.database.v1.UpdateDatabaseDdlMetadata;
import com.google.spanner.admin.instance.v1.InstanceName;
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
public class DatabaseAdminGaxTest {
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
  private static final String INSTANCE = "INSTANCE";
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

  private static MockDatabaseAdminImpl mockDatabaseAdmin;
  private static Server server;
  private static Spanner spanner;
  private static DatabaseAdminClient client;
  private static LocalChannelProvider channelProvider;

  @Parameter(0)
  public boolean enableGaxRetries;

  @Parameter(1)
  public int exceptionAtCall;

  @Parameter(2)
  public ExceptionType exceptionType;

  @Parameters(name = "enable GAX retries = {0}, exception at call = {1}, exception type = {2}")
  public static Collection<Object[]> data() {
    List<Object[]> params = new ArrayList<>();
    for (boolean enableRetries : new boolean[] {true, false}) {
      for (int exceptionAtCall : new int[] {0, 1}) {
        for (ExceptionType exceptionType : ExceptionType.values()) {
          params.add(new Object[] {enableRetries, exceptionAtCall, exceptionType});
        }
      }
    }
    return params;
  }

  @Rule public ExpectedException expectedException = ExpectedException.none();

  @BeforeClass
  public static void startStaticServer() throws IOException {
    mockDatabaseAdmin = new MockDatabaseAdminImpl();
    String uniqueName = InProcessServerBuilder.generateName();
    server =
        InProcessServerBuilder.forName(uniqueName)
            // We need to use a real executor for timeouts to occur.
            .scheduledExecutorService(new ScheduledThreadPoolExecutor(1))
            .addService(mockDatabaseAdmin)
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
    mockDatabaseAdmin.reset();
    final RetrySettings retrySettings =
        RetrySettings.newBuilder()
            .setInitialRpcTimeout(Duration.ofMillis(200L))
            .setMaxRpcTimeout(Duration.ofMillis(200L))
            .setMaxAttempts(3)
            .setTotalTimeout(Duration.ofMillis(500L))
            .build();
    SpannerOptions.Builder builder =
        SpannerOptions.newBuilder()
            .setProjectId(PROJECT)
            .setChannelProvider(channelProvider)
            .setCredentials(NoCredentials.getInstance());
    builder
        .getDatabaseAdminStubSettingsBuilder()
        .applyToAllUnaryMethods(
            new ApiFunction<UnaryCallSettings.Builder<?, ?>, Void>() {
              @Override
              public Void apply(Builder<?, ?> input) {
                input.setRetrySettings(retrySettings);
                return null;
              }
            });
    builder
        .getDatabaseAdminStubSettingsBuilder()
        .createDatabaseOperationSettings()
        .setInitialCallSettings(
            builder
                .getDatabaseAdminStubSettingsBuilder()
                .createDatabaseOperationSettings()
                .getInitialCallSettings()
                .toBuilder()
                .setRetrySettings(retrySettings)
                .build());
    builder
        .getDatabaseAdminStubSettingsBuilder()
        .updateDatabaseDdlOperationSettings()
        .setInitialCallSettings(
            builder
                .getDatabaseAdminStubSettingsBuilder()
                .updateDatabaseDdlOperationSettings()
                .getInitialCallSettings()
                .toBuilder()
                .setRetrySettings(retrySettings)
                .build());
    if (!enableGaxRetries) {
      // Disable retries by removing all retryable codes.
      builder
          .getDatabaseAdminStubSettingsBuilder()
          .applyToAllUnaryMethods(
              new ApiFunction<UnaryCallSettings.Builder<?, ?>, Void>() {
                @Override
                public Void apply(Builder<?, ?> input) {
                  input.setRetryableCodes(ImmutableSet.<StatusCode.Code>of());
                  return null;
                }
              });
      builder
          .getDatabaseAdminStubSettingsBuilder()
          .createDatabaseOperationSettings()
          .setInitialCallSettings(
              builder
                  .getDatabaseAdminStubSettingsBuilder()
                  .createDatabaseOperationSettings()
                  .getInitialCallSettings()
                  .toBuilder()
                  .setRetrySettings(retrySettings)
                  .setRetryableCodes(ImmutableSet.<StatusCode.Code>of())
                  .build());
      builder
          .getDatabaseAdminStubSettingsBuilder()
          .updateDatabaseDdlOperationSettings()
          .setInitialCallSettings(
              builder
                  .getDatabaseAdminStubSettingsBuilder()
                  .updateDatabaseDdlOperationSettings()
                  .getInitialCallSettings()
                  .toBuilder()
                  .setRetrySettings(retrySettings)
                  .setRetryableCodes(ImmutableSet.<StatusCode.Code>of())
                  .build());
    }
    spanner = builder.build().getService();
    client = spanner.getDatabaseAdminClient();
  }

  @After
  public void tearDown() throws Exception {
    spanner.close();
  }

  private Exception setupException() {
    if (exceptionType.isRetryable()) {
      if (!enableGaxRetries) {
        expectedException.expect(
            SpannerMatchers.isSpannerException(exceptionType.getExpectedErrorCodeWithoutGax()));
      }
    } else {
      expectedException.expect(
          SpannerMatchers.isSpannerException(exceptionType.getExpectedErrorCodeWithGax()));
    }
    return exceptionType.getException();
  }

  @Test
  public void listDatabasesTest() {
    Exception exception = setupException();
    String nextPageToken = "token%d";
    List<com.google.spanner.admin.database.v1.Database> databases = new ArrayList<>(2);
    for (int i = 0; i < 2; i++) {
      databases.add(
          com.google.spanner.admin.database.v1.Database.newBuilder()
              .setName(
                  String.format("projects/%s/instances/%s/databases/test%d", PROJECT, INSTANCE, i))
              .build());
    }
    if (exceptionAtCall == 0) {
      mockDatabaseAdmin.addException(exception);
    }
    for (int i = 0; i < 2; i++) {
      ListDatabasesResponse.Builder builder =
          ListDatabasesResponse.newBuilder().addAllDatabases(Arrays.asList(databases.get(i)));
      if (i < (databases.size() - 1)) {
        builder.setNextPageToken(String.format(nextPageToken, i));
      }
      if (exceptionAtCall == (i + 1)) {
        mockDatabaseAdmin.addException(exception);
      }
      mockDatabaseAdmin.addResponse(builder.build());
    }

    InstanceName parent = InstanceName.of(PROJECT, INSTANCE);
    Page<Database> pagedListResponse = client.listDatabases(INSTANCE);

    List<Database> resources = Lists.newArrayList(pagedListResponse.iterateAll());
    Assert.assertEquals(2, resources.size());

    List<AbstractMessage> actualRequests = mockDatabaseAdmin.getRequests();
    Assert.assertEquals(2, actualRequests.size());
    ListDatabasesRequest actualRequest = (ListDatabasesRequest) actualRequests.get(0);

    Assert.assertEquals(parent, InstanceName.parse(actualRequest.getParent()));
  }

  @Test
  public void getDatabaseTest() {
    Exception exception = setupException();
    DatabaseName name2 = DatabaseName.of(PROJECT, INSTANCE, "DATABASE");
    com.google.spanner.admin.database.v1.Database expectedResponse =
        com.google.spanner.admin.database.v1.Database.newBuilder()
            .setName(name2.toString())
            .build();
    if (exceptionAtCall == 0) {
      mockDatabaseAdmin.addException(exception);
    }
    mockDatabaseAdmin.addResponse(expectedResponse);
    if (exceptionAtCall == 1) {
      mockDatabaseAdmin.addException(exception);
    }
    mockDatabaseAdmin.addResponse(expectedResponse);

    for (int i = 0; i < 2; i++) {
      Database actualResponse = client.getDatabase(INSTANCE, "DATABASE");
      Assert.assertEquals(name2.toString(), actualResponse.getId().getName());
    }

    List<AbstractMessage> actualRequests = mockDatabaseAdmin.getRequests();
    Assert.assertEquals(2, actualRequests.size());
  }

  @Test
  public void createDatabaseTest() throws Exception {
    Exception exception = setupException();
    DatabaseName name = DatabaseName.of(PROJECT, INSTANCE, "DATABASE");
    com.google.spanner.admin.database.v1.Database expectedResponse =
        com.google.spanner.admin.database.v1.Database.newBuilder().setName(name.toString()).build();
    com.google.longrunning.Operation resultOperation =
        com.google.longrunning.Operation.newBuilder()
            .setName("createDatabaseTest")
            .setDone(true)
            .setResponse(Any.pack(expectedResponse))
            .build();
    if (exceptionAtCall == 0) {
      mockDatabaseAdmin.addException(exception);
    }
    mockDatabaseAdmin.addResponse(resultOperation);
    if (exceptionAtCall == 1) {
      mockDatabaseAdmin.addException(exception);
    }
    mockDatabaseAdmin.addResponse(resultOperation);

    for (int i = 0; i < 2; i++) {
      OperationFuture<Database, CreateDatabaseMetadata> actualResponse =
          client.createDatabase(INSTANCE, "DATABASE", Arrays.<String>asList());
      try {
        Database returnedInstance = actualResponse.get();
        Assert.assertEquals(name.toString(), returnedInstance.getId().getName());
      } catch (ExecutionException e) {
        Throwables.throwIfUnchecked(e.getCause());
        throw e;
      }
    }
    List<AbstractMessage> actualRequests = mockDatabaseAdmin.getRequests();
    Assert.assertEquals(2, actualRequests.size());
  }

  @Test
  public void updateDatabaseDdlTest() throws Exception {
    Exception exception = setupException();
    com.google.longrunning.Operation resultOperation =
        com.google.longrunning.Operation.newBuilder()
            .setName("updateDatabaseDdlTest")
            .setDone(true)
            .setResponse(Any.pack(Empty.getDefaultInstance()))
            .build();
    if (exceptionAtCall == 0) {
      mockDatabaseAdmin.addException(exception);
    }
    mockDatabaseAdmin.addResponse(resultOperation);
    if (exceptionAtCall == 1) {
      mockDatabaseAdmin.addException(exception);
    }
    mockDatabaseAdmin.addResponse(resultOperation);

    for (int i = 0; i < 2; i++) {
      OperationFuture<Void, UpdateDatabaseDdlMetadata> actualResponse =
          client.updateDatabaseDdl(
              INSTANCE, "DATABASE", Arrays.asList("CREATE TABLE FOO"), "updateDatabaseDdlTest");
      try {
        actualResponse.get();
      } catch (ExecutionException e) {
        Throwables.throwIfUnchecked(e.getCause());
        throw e;
      }
    }

    List<AbstractMessage> actualRequests = mockDatabaseAdmin.getRequests();
    Assert.assertEquals(2, actualRequests.size());
  }

  @Test
  public void deleteInstanceTest() {
    Exception exception = setupException();
    Empty expectedResponse = Empty.newBuilder().build();
    if (exceptionAtCall == 0) {
      mockDatabaseAdmin.addException(exception);
    }
    mockDatabaseAdmin.addResponse(expectedResponse);
    if (exceptionAtCall == 1) {
      mockDatabaseAdmin.addException(exception);
    }
    mockDatabaseAdmin.addResponse(expectedResponse);
    for (int i = 0; i < 2; i++) {
      client.dropDatabase(INSTANCE, "DATABASE");
    }

    List<AbstractMessage> actualRequests = mockDatabaseAdmin.getRequests();
    Assert.assertEquals(2, actualRequests.size());
  }
}
