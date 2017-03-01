/*
 * Copyright 2017 Google Inc. All Rights Reserved.
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

import static com.google.common.base.Preconditions.checkState;

import com.google.cloud.WaitForOption;
import com.google.cloud.spanner.testing.RemoteSpannerHelper;
import com.google.common.collect.Iterators;
import com.google.spanner.admin.instance.v1.CreateInstanceMetadata;
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

  /**
   * Names a property that, if set, identifies an existing Cloud Spanner instance to use for tests.
   */
  public static final String TEST_INSTANCE_PROPERTY = "spanner.testenv.instance";

  private static final Logger logger = Logger.getLogger(IntegrationTestEnv.class.getName());

  private TestEnvConfig config;
  private InstanceAdminClient instanceAdminClient;
  private boolean isOwnedInstance;
  private RemoteSpannerHelper testHelper;

  public RemoteSpannerHelper getTestHelper() {
    checkInitialized();
    return testHelper;
  }

  @SuppressWarnings("unchecked")
  protected void initializeConfig()
      throws ClassNotFoundException, InstantiationException, IllegalAccessException {
    String configClassName = System.getProperty(TEST_ENV_CONFIG_CLASS_NAME, null);
    if (configClassName == null) {
      throw new NullPointerException("Property " + TEST_ENV_CONFIG_CLASS_NAME + " needs to be set");
    }
    Class<? extends TestEnvConfig> configClass;
    configClass = (Class<? extends TestEnvConfig>) Class.forName(configClassName);
    config = configClass.newInstance();
  }

  @Override
  protected void before() throws Throwable {
    this.initializeConfig();
    this.config.setUp();

    SpannerOptions options = config.spannerOptions();
    String instanceProperty = System.getProperty(TEST_INSTANCE_PROPERTY, "");
    InstanceId instanceId = null;
    if (!instanceProperty.isEmpty()) {
      instanceId = InstanceId.of(instanceProperty);
      isOwnedInstance = false;
      logger.log(Level.INFO, "Using existing test instance: {0}", instanceId);
    } else {
      instanceId =
          InstanceId.of(config.spannerOptions().getProjectId(), "test-instance");
      isOwnedInstance = true;
    }
    testHelper = RemoteSpannerHelper.create(options, instanceId);
    instanceAdminClient = testHelper.getClient().getInstanceAdminClient();
    logger.log(Level.FINE, "Test env endpoint is {0}", options.getHost());
    if (isOwnedInstance) {
      initializeInstance(instanceId);
    }
  }

  @Override
  protected void after() {
    cleanUpInstance();
    this.config.tearDown();
  }

  private void initializeInstance(InstanceId instanceId) {
    InstanceConfig instanceConfig =
        Iterators.get(instanceAdminClient.listInstanceConfigs().iterateAll(), 0, null);
    checkState(instanceConfig != null, "No instance configs found");

    InstanceConfigId configId = instanceConfig.getId();
    logger.log(Level.FINE, "Creating instance using config {0}", configId);
    InstanceInfo instance =
        InstanceInfo.newBuilder(instanceId)
            .setNodeCount(1)
            .setDisplayName("Test instance")
            .setInstanceConfigId(configId)
            .build();
    Operation<Instance, CreateInstanceMetadata> op = instanceAdminClient.createInstance(instance);
    op = op.waitFor(WaitForOption.checkEvery(500, TimeUnit.MILLISECONDS));
    Instance createdInstance = op.getResult();
    logger.log(Level.INFO, "Created test instance: {0}", createdInstance.getId());
  }

  private void cleanUpInstance() {
    if (isOwnedInstance) {
      // Delete the instance, which implicitly drops all databases in it.
      try {
        logger.log(Level.FINE, "Deleting test instance {0}", testHelper.getInstanceId());
        instanceAdminClient.deleteInstance(testHelper.getInstanceId().getInstance());
        logger.log(Level.INFO, "Deleted test instance {0}", testHelper.getInstanceId());
      } catch (SpannerException e) {
        logger.log(Level.SEVERE, "Failed to delete test instance " + testHelper.getInstanceId(), e);
      }
    } else {
      testHelper.cleanUp();
    }
  }

  private void checkInitialized() {
    checkState(testHelper != null, "Setup has not completed successfully");
  }
}
