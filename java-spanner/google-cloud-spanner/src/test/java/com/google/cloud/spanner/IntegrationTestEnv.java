/*
 * Copyright 2017 Google LLC
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

package com.google.cloud.spanner;

import static com.google.cloud.spanner.testing.ExperimentalHostHelper.isExperimentalHost;
import static com.google.common.base.Preconditions.checkState;
import static org.junit.Assume.assumeFalse;

import com.google.api.client.util.ExponentialBackOff;
import com.google.api.gax.longrunning.OperationFuture;
import com.google.cloud.Timestamp;
import com.google.cloud.opentelemetry.trace.TraceConfiguration;
import com.google.cloud.opentelemetry.trace.TraceExporter;
import com.google.cloud.spanner.DatabaseInfo.DatabaseField;
import com.google.cloud.spanner.testing.EmulatorSpannerHelper;
import com.google.cloud.spanner.testing.RemoteSpannerHelper;
import com.google.common.collect.Iterators;
import com.google.spanner.admin.instance.v1.CreateInstanceMetadata;
import io.opentelemetry.api.trace.propagation.W3CTraceContextPropagator;
import io.opentelemetry.context.propagation.ContextPropagators;
import io.opentelemetry.sdk.OpenTelemetrySdk;
import io.opentelemetry.sdk.resources.Resource;
import io.opentelemetry.sdk.trace.SdkTracerProvider;
import io.opentelemetry.sdk.trace.export.BatchSpanProcessor;
import io.opentelemetry.sdk.trace.export.SpanExporter;
import io.opentelemetry.sdk.trace.samplers.Sampler;
import java.util.Collection;
import java.util.Collections;
import java.util.Objects;
import java.util.Random;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ThreadLocalRandom;
import java.util.concurrent.TimeUnit;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.junit.rules.ExternalResource;

/**
 * JUnit 4 test rule that provides access to a Cloud Spanner instance to use for tests, and allows
 * uniquely named (per {@code IntegrationTestEnv} instance) test databases to be created within that
 * instance. An existing instance can be used by naming it in the {@link #TEST_INSTANCE_PROPERTY}
 * property; if the property is not set, an instance will be created and destroyed by the rule.
 *
 * <p>This class is normally used as a {@code @ClassRule}.
 */
public class IntegrationTestEnv extends ExternalResource {

  /** Names a property that provides the class name of the {@link TestEnvConfig} to use. */
  public static final String TEST_ENV_CONFIG_CLASS_NAME = "spanner.testenv.config.class";

  public static final String CONFIG_CLASS = System.getProperty(TEST_ENV_CONFIG_CLASS_NAME, null);

  /**
   * Names a property that, if set, identifies an existing Cloud Spanner instance to use for tests.
   */
  public static final String TEST_INSTANCE_PROPERTY = "spanner.testenv.instance";

  public static final String MAX_CREATE_INSTANCE_ATTEMPTS =
      "spanner.testenv.max_create_instance_attempts";

  private static final Logger logger = Logger.getLogger(IntegrationTestEnv.class.getName());

  private TestEnvConfig config;
  private InstanceAdminClient instanceAdminClient;
  private DatabaseAdminClient databaseAdminClient;
  private boolean isOwnedInstance;
  private final boolean alwaysCreateNewInstance;
  private RemoteSpannerHelper testHelper;

  private Collection<TestEnvOptions> testEnvOptions = Collections.emptyList();

  public enum TestEnvOptions {
    USE_END_TO_END_TRACING;
    // TODO : Move alwaysCreateNewInstance to TestEnvOptions
  }

  public IntegrationTestEnv() {
    this(false);
  }

  public IntegrationTestEnv(Collection<TestEnvOptions> testEnvOptions) {
    this(false);
    this.testEnvOptions = testEnvOptions;
  }

  public IntegrationTestEnv(final boolean alwaysCreateNewInstance) {
    this.alwaysCreateNewInstance = alwaysCreateNewInstance;
  }

  public RemoteSpannerHelper getTestHelper() {
    checkInitialized();
    return testHelper;
  }

  @SuppressWarnings("unchecked")
  protected void initializeConfig()
      throws ClassNotFoundException, InstantiationException, IllegalAccessException {
    if (CONFIG_CLASS == null) {
      throw new NullPointerException("Property " + TEST_ENV_CONFIG_CLASS_NAME + " needs to be set");
    }
    Class<? extends TestEnvConfig> configClass;
    if (EmulatorSpannerHelper.isUsingEmulator()) {
      // Make sure that we use an owned instance on the emulator.
      System.setProperty(TEST_INSTANCE_PROPERTY, "");
    }
    configClass = (Class<? extends TestEnvConfig>) Class.forName(CONFIG_CLASS);
    config = configClass.newInstance();
  }

  boolean isCloudDevel() {
    return Objects.equals(
        System.getProperty("spanner.gce.config.server_url"),
        "https://staging-wrenchworks.sandbox.googleapis.com");
  }

  @Override
  protected void before() throws Throwable {
    this.initializeConfig();
    assumeFalse(alwaysCreateNewInstance && isCloudDevel());
    assumeFalse(
        "Creating instances is not supported in experimental host",
        alwaysCreateNewInstance && isExperimentalHost());

    this.config.setUp();
    SpannerOptions options = config.spannerOptions();
    if (testEnvOptions.stream()
        .anyMatch(testEnvOption -> TestEnvOptions.USE_END_TO_END_TRACING.equals(testEnvOption))) {
      // OpenTelemetry set up for enabling End to End tracing for all integration test env.
      // The gRPC stub and connections are created during test env set up using SpannerOptions and
      // are reused for executing statements.
      options = spannerOptionsWithEndToEndTracing(options);
    }
    String instanceProperty = System.getProperty(TEST_INSTANCE_PROPERTY, "");
    InstanceId instanceId;
    if (!instanceProperty.isEmpty() && !alwaysCreateNewInstance) {
      instanceId = InstanceId.of(instanceProperty);
      isOwnedInstance = false;
      logger.log(Level.INFO, "Using existing test instance: {0}", instanceId);
    } else {
      instanceId =
          InstanceId.of(
              config.spannerOptions().getProjectId(),
              String.format("test-instance-%08d", new Random().nextInt(100000000)));
      isOwnedInstance = true;
    }
    testHelper = createTestHelper(options, instanceId);
    instanceAdminClient = testHelper.getClient().getInstanceAdminClient();
    databaseAdminClient = testHelper.getClient().getDatabaseAdminClient();
    logger.log(Level.FINE, "Test env endpoint is {0}", options.getHost());
    if (isOwnedInstance) {
      initializeInstance(instanceId);
    } else {
      cleanUpOldDatabases(instanceId);
    }
  }

  public SpannerOptions spannerOptionsWithEndToEndTracing(SpannerOptions options) {
    assumeFalse("This test requires credentials", EmulatorSpannerHelper.isUsingEmulator());

    TraceConfiguration.Builder traceConfigurationBuilder = TraceConfiguration.builder();
    if (options.getCredentials() != null) {
      traceConfigurationBuilder.setCredentials(options.getCredentials());
    }
    SpanExporter traceExporter =
        TraceExporter.createWithConfiguration(
            traceConfigurationBuilder.setProjectId(options.getProjectId()).build());

    String serviceName = "java-spanner-integration-tests-" + ThreadLocalRandom.current().nextInt();
    SdkTracerProvider sdkTracerProvider =
        SdkTracerProvider.builder()
            // Always sample in this test to ensure we know what we get.
            .setSampler(Sampler.alwaysOn())
            .setResource(Resource.builder().put("service.name", serviceName).build())
            .addSpanProcessor(BatchSpanProcessor.builder(traceExporter).build())
            .build();
    OpenTelemetrySdk openTelemetry =
        OpenTelemetrySdk.builder()
            .setTracerProvider(sdkTracerProvider)
            .setPropagators(ContextPropagators.create(W3CTraceContextPropagator.getInstance()))
            .build();
    SpannerOptions.enableOpenTelemetryTraces();
    return options.toBuilder()
        .setOpenTelemetry(openTelemetry)
        .setEnableEndToEndTracing(true)
        .build();
  }

  RemoteSpannerHelper createTestHelper(SpannerOptions options, InstanceId instanceId)
      throws Throwable {
    return RemoteSpannerHelper.create(options, instanceId);
  }

  @Override
  protected void after() {
    cleanUpInstance();
    this.config.tearDown();
  }

  private void initializeInstance(InstanceId instanceId) throws Exception {
    InstanceConfig instanceConfig;
    try {
      instanceConfig = instanceAdminClient.getInstanceConfig("regional-us-east4");
    } catch (Throwable ignore) {
      instanceConfig =
          Iterators.get(instanceAdminClient.listInstanceConfigs().iterateAll().iterator(), 0, null);
    }
    checkState(instanceConfig != null, "No instance configs found");

    InstanceConfigId configId = instanceConfig.getId();
    logger.log(Level.FINE, "Creating instance using config {0}", configId);
    InstanceInfo instance =
        InstanceInfo.newBuilder(instanceId)
            .setNodeCount(1)
            .setDisplayName("Test instance")
            .setEdition(com.google.spanner.admin.instance.v1.Instance.Edition.ENTERPRISE_PLUS)
            .setInstanceConfigId(configId)
            .build();
    OperationFuture<Instance, CreateInstanceMetadata> op =
        instanceAdminClient.createInstance(instance);
    Instance createdInstance;
    int maxAttempts = 25;
    try {
      maxAttempts =
          Integer.parseInt(
              System.getProperty(MAX_CREATE_INSTANCE_ATTEMPTS, String.valueOf(maxAttempts)));
    } catch (NumberFormatException ignore) {
      // Ignore and fall back to the default.
    }
    ExponentialBackOff backOff =
        new ExponentialBackOff.Builder()
            .setInitialIntervalMillis(5_000)
            .setMaxIntervalMillis(500_000)
            .setMultiplier(2.0)
            .build();
    int attempts = 0;
    while (true) {
      try {
        createdInstance = op.get();
      } catch (Exception e) {
        SpannerException spannerException =
            (e instanceof ExecutionException && e.getCause() != null)
                ? SpannerExceptionFactory.asSpannerException(e.getCause())
                : SpannerExceptionFactory.asSpannerException(e);
        if (attempts < maxAttempts && isRetryableResourceExhaustedException(spannerException)) {
          attempts++;
          if (spannerException.getRetryDelayInMillis() > 0L) {
            //noinspection BusyWait
            Thread.sleep(spannerException.getRetryDelayInMillis());
          } else {
            // The Math.max(...) prevents Backoff#STOP (=-1) to be used as the sleep value.
            //noinspection BusyWait
            Thread.sleep(Math.max(backOff.getMaxIntervalMillis(), backOff.nextBackOffMillis()));
          }
          continue;
        }
        throw SpannerExceptionFactory.newSpannerException(
            spannerException.getErrorCode(),
            String.format(
                "Could not create test instance and giving up after %d attempts: %s",
                attempts, e.getMessage()),
            e);
      }
      logger.log(Level.INFO, "Created test instance: {0}", createdInstance.getId());
      break;
    }
  }

  static boolean isRetryableResourceExhaustedException(SpannerException exception) {
    if (exception.getErrorCode() != ErrorCode.RESOURCE_EXHAUSTED) {
      return false;
    }
    return exception
            .getMessage()
            .contains(
                "Quota exceeded for quota metric 'Instance create requests' and limit 'Instance"
                    + " create requests per minute'")
        || exception.getMessage().matches(".*cannot add \\d+ nodes in region.*");
  }

  private void cleanUpOldDatabases(InstanceId instanceId) {
    long OLD_DB_THRESHOLD_SECS = TimeUnit.SECONDS.convert(2L, TimeUnit.HOURS);
    Timestamp currentTimestamp = Timestamp.now();
    int numDropped = 0;
    String TEST_DB_REGEX = "(testdb_(.*)_(.*))|(mysample-(.*))";

    logger.log(Level.INFO, "Dropping old test databases from {0}", instanceId.getName());
    while (true) {
      try {
        for (Database db :
            databaseAdminClient.listDatabases(instanceId.getInstance()).iterateAll()) {
          try {
            long timeDiff = currentTimestamp.getSeconds() - db.getCreateTime().getSeconds();
            // Delete all databases which are more than OLD_DB_THRESHOLD_SECS seconds old.
            if ((db.getId().getDatabase().matches(TEST_DB_REGEX))
                && (timeDiff > OLD_DB_THRESHOLD_SECS)) {
              logger.log(Level.INFO, "Dropping test database {0}", db.getId());
              if (db.isDropProtectionEnabled()) {
                Database updatedDatabase =
                    databaseAdminClient
                        .newDatabaseBuilder(db.getId())
                        .disableDropProtection()
                        .build();
                databaseAdminClient
                    .updateDatabase(updatedDatabase, DatabaseField.DROP_PROTECTION)
                    .get();
              }
              db.drop();
              ++numDropped;
            }
          } catch (SpannerException | ExecutionException | InterruptedException e) {
            logger.log(Level.SEVERE, "Failed to drop test database " + db.getId(), e);
          }
        }
        break;
      } catch (SpannerException exception) {
        if (exception.getErrorCode() != ErrorCode.RESOURCE_EXHAUSTED) {
          throw exception;
        }
        // Wait a little and try again.
        try {
          Thread.sleep(10_000);
        } catch (InterruptedException interruptedException) {
          throw SpannerExceptionFactory.propagateInterrupt(interruptedException);
        }
      }
    }
    logger.log(Level.INFO, "Dropped {0} test database(s)", numDropped);
  }

  private void cleanUpInstance() {
    try {
      if (isOwnedInstance) {
        // Delete the instance, which implicitly drops all databases in it.
        try {
          if (!EmulatorSpannerHelper.isUsingEmulator() && !isExperimentalHost()) {
            // Backups must be explicitly deleted before the instance may be deleted.
            logger.log(
                Level.FINE, "Deleting backups on test instance {0}", testHelper.getInstanceId());
            for (Backup backup :
                testHelper
                    .getClient()
                    .getDatabaseAdminClient()
                    .listBackups(testHelper.getInstanceId().getInstance())
                    .iterateAll()) {
              logger.log(Level.FINE, "Deleting backup {0}", backup.getId());
              backup.delete();
            }
          }
          logger.log(Level.FINE, "Deleting test instance {0}", testHelper.getInstanceId());
          instanceAdminClient.deleteInstance(testHelper.getInstanceId().getInstance());
          logger.log(Level.INFO, "Deleted test instance {0}", testHelper.getInstanceId());
        } catch (SpannerException e) {
          logger.log(
              Level.SEVERE, "Failed to delete test instance " + testHelper.getInstanceId(), e);
        }
      } else {
        testHelper.cleanUp();
      }
    } finally {
      testHelper.getClient().close();
    }
  }

  void checkInitialized() {
    checkState(testHelper != null, "Setup has not completed successfully");
  }
}
