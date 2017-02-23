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

package org.slf4j.impl;

import com.google.cloud.logging.Severity;
import java.io.File;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.slf4j.impl.config.ConfigLoader;

public class ConfigLoaderTest {

  private static final String cloudLoggingConfigProperty = "CLOUD_LOGGING_CONFIG";
  private String cloudLoggingConfigOldValue;

  @Before
  public void startUp() {
    ClassLoader classLoader = getClass().getClassLoader();
    cloudLoggingConfigOldValue = System.getProperty(cloudLoggingConfigProperty);
    File file = new File(classLoader.getResource("google-cloud-logging.yaml").getFile());
    System.setProperty(cloudLoggingConfigProperty, file.getAbsolutePath());
  }

  @Test
  public void configurationHasDefaults() {
    ConfigLoader configLoader = new ConfigLoader(null);
    Assert.assertEquals(configLoader.getFileName("test"), "default");
    Assert.assertEquals(configLoader.getResource("test"), "global");
    Assert.assertEquals(configLoader.getSeverity("test"), Severity.DEFAULT);
    Assert.assertEquals(configLoader.getDestination(), "default");
  }

  @Test
  public void configurationLoadsTheRightConfig() {
    ConfigLoader configLoader = new ConfigLoader(System.getProperty(cloudLoggingConfigProperty));
    Assert.assertEquals(configLoader.getFileName("com.example.app"), "app.log");
    Assert.assertEquals(configLoader.getResource("com.example.app"), "global");
    Assert.assertEquals(configLoader.getSeverity("com.example.app"), Severity.DEBUG);
    Assert.assertEquals(configLoader.isEnabled("com.example.app"), true);
    Assert.assertEquals(configLoader.isEnabled("default"), false);
    Assert.assertEquals(configLoader.getDestination(), "fluentd");
  }

  @Test
  public void configurationLoadsPackageConfigAsFallback() {
    ConfigLoader configLoader = new ConfigLoader(System.getProperty(cloudLoggingConfigProperty));
    Assert.assertEquals(configLoader.getFileName("com.example.app.new"), "app.log");
    Assert.assertEquals(configLoader.getResource("com.example.app.new"), "global");
    Assert.assertEquals(configLoader.getSeverity("com.example.app.new"), Severity.DEBUG);
    Assert.assertEquals(configLoader.isEnabled("com.example.app.new"), true);
  }

  @After
  public void tearDown() {
    if (cloudLoggingConfigOldValue == null) {
      System.clearProperty(cloudLoggingConfigProperty);
    } else {
      System.setProperty(cloudLoggingConfigProperty, cloudLoggingConfigOldValue);
    }
  }
}
