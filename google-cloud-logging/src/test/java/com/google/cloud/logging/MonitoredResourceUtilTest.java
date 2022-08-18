/*
 * Copyright 2021 Google LLC
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

package com.google.cloud.logging;

import static org.easymock.EasyMock.anyString;
import static org.easymock.EasyMock.createMock;
import static org.easymock.EasyMock.expect;
import static org.easymock.EasyMock.replay;
import static org.easymock.EasyMock.verify;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import com.google.cloud.MonitoredResource;
import com.google.common.collect.ImmutableMap;
import java.util.Map;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;

@RunWith(JUnit4.class)
public class MonitoredResourceUtilTest {
  private static final String MOCKED_PROJECT_ID = "mocked-project-id";
  private static final String MOCKED_ZONE = "mocked-zone-id";
  private static final String MOCKED_QUALIFIED_ZONE =
      "projects/" + MOCKED_PROJECT_ID + "/zones/" + MOCKED_ZONE;
  private static final String MOCKED_REGION = "mocked-region-id";
  private static final String MOCKED_QUALIFIED_REGION =
      "projects/" + MOCKED_PROJECT_ID + "/regions/" + MOCKED_REGION;
  private static final String MOCKED_NON_EMPTY = "project/";

  private ResourceTypeEnvironmentGetter getterMock;

  @Before
  public void setup() {
    getterMock = createMock(ResourceTypeEnvironmentGetter.class);
    expect(getterMock.getAttribute("project/project-id")).andReturn(MOCKED_PROJECT_ID);
    expect(getterMock.getAttribute("")).andReturn(MOCKED_NON_EMPTY).once();
    MonitoredResourceUtil.setEnvironmentGetter(getterMock);
  }

  @After
  public void teardown() {
    verify(getterMock);
  }

  @Test
  public void testResourceTypeGlobal() {
    final Map<String, String> ExpectedLabels =
        ImmutableMap.of("project_id", MonitoredResourceUtilTest.MOCKED_PROJECT_ID);

    // setup
    expect(getterMock.getAttribute(anyString())).andReturn(null).anyTimes();
    expect(getterMock.getEnv(anyString())).andReturn(null).anyTimes();
    replay(getterMock);
    // exercise
    MonitoredResource response = MonitoredResourceUtil.getResource("", "");
    // verify
    assertEquals(response.getType(), "global");
    assertTrue(response.getLabels().equals(ExpectedLabels));
  }

  public void testGetResourceWithParameters() {
    final String MyProjectId = "my-project-id";
    final String MyResourceType = "my-resource-type";
    final Map<String, String> ExpectedLabels = ImmutableMap.of("project_id", MyProjectId);

    // setup
    replay(getterMock);
    // exercise
    MonitoredResource response = MonitoredResourceUtil.getResource(MyProjectId, MyResourceType);
    // verify
    assertEquals(response.getType(), "global");
    assertTrue(response.getLabels().equals(ExpectedLabels));
  }

  @Test
  public void testResourceTypeGCEInstance() {
    final String MockedInstanceId = "1234567890abcdefg";
    final Map<String, String> ExpectedLabels =
        ImmutableMap.of(
            "project_id",
            MonitoredResourceUtilTest.MOCKED_PROJECT_ID,
            "instance_id",
            MockedInstanceId,
            "zone",
            MOCKED_ZONE);

    // setup
    expect(getterMock.getAttribute("instance/id")).andReturn(MockedInstanceId).anyTimes();
    expect(getterMock.getAttribute("instance/preempted")).andReturn(MOCKED_NON_EMPTY).once();
    expect(getterMock.getAttribute("instance/cpu-platform")).andReturn(MOCKED_NON_EMPTY).once();
    expect(getterMock.getAttribute("instance/zone")).andReturn(MOCKED_QUALIFIED_ZONE).once();
    expect(getterMock.getAttribute(anyString())).andReturn(null).anyTimes();
    expect(getterMock.getEnv(anyString())).andReturn(null).anyTimes();
    replay(getterMock);
    // exercise
    MonitoredResource response = MonitoredResourceUtil.getResource("", "");
    // verify
    assertEquals(response.getType(), "gce_instance");
    assertTrue(response.getLabels().equals(ExpectedLabels));
  }

  /**
   * Attention: This test can be flaky if the path <code>
   * /var/run/secrets/kubernetes.io/serviceaccount/namespace</code> exists and the file at this path
   * contains a value other than the mocked constant
   */
  @Test
  public void testResourceTypeK8sContainer() {
    final String MockedClusterName = "mocked-cluster-1";
    final String MockedNamespaceName = "default";
    final String MockedPodName = "mocked-pod";
    final String MockedContainerName = "mocked-container";
    final Map<String, String> ExpectedLabels =
        ImmutableMap.<String, String>builder()
            .put("project_id", MonitoredResourceUtilTest.MOCKED_PROJECT_ID)
            .put("cluster_name", MockedClusterName)
            .put("location", MOCKED_ZONE)
            .put("namespace_name", MockedNamespaceName)
            .put("pod_name", MockedPodName)
            .put("container_name", MockedContainerName)
            .build();

    // setup
    expect(getterMock.getAttribute("instance/attributes/cluster-name"))
        .andReturn(MockedClusterName)
        .times(2);
    expect(getterMock.getAttribute("instance/zone")).andReturn(MOCKED_QUALIFIED_ZONE).once();
    expect(getterMock.getAttribute(anyString())).andReturn(null).anyTimes();
    expect(getterMock.getEnv("HOSTNAME")).andReturn(MockedPodName).anyTimes();
    expect(getterMock.getEnv("NAMESPACE_NAME")).andReturn(MockedNamespaceName).anyTimes();
    expect(getterMock.getEnv("CONTAINER_NAME")).andReturn(MockedContainerName).anyTimes();
    expect(getterMock.getEnv(anyString())).andReturn(null).anyTimes();
    replay(getterMock);
    // exercise
    MonitoredResource response = MonitoredResourceUtil.getResource("", "");
    // verify
    assertEquals(response.getType(), "k8s_container");
    assertTrue(response.getLabels().equals(ExpectedLabels));
  }

  private void setupCommonGAEMocks(String mockedModuleId, String mockedVersionId) {
    expect(getterMock.getAttribute("instance/zone")).andReturn(MOCKED_QUALIFIED_ZONE).once();
    expect(getterMock.getEnv("GAE_INSTANCE")).andReturn(MOCKED_NON_EMPTY).once();
    expect(getterMock.getEnv("GAE_SERVICE")).andReturn(mockedModuleId).times(2);
    expect(getterMock.getEnv("GAE_VERSION")).andReturn(mockedVersionId).times(2);
    expect(getterMock.getEnv(anyString())).andReturn(null).anyTimes();
  }

  @Test
  public void testResourceTypeGAEStandardEnvironment() {
    final String MockedModuleId = "mocked-module-id";
    final String MockedVersionId = "mocked-version-id";
    final Map<String, String> ExpectedLabels =
        ImmutableMap.of(
            "project_id",
            MonitoredResourceUtilTest.MOCKED_PROJECT_ID,
            "module_id",
            MockedModuleId,
            "version_id",
            MockedVersionId,
            "env",
            "standard",
            "zone",
            MOCKED_ZONE);

    // setup
    setupCommonGAEMocks(MockedModuleId, MockedVersionId);
    expect(getterMock.getAttribute(anyString())).andReturn(null).anyTimes();
    replay(getterMock);
    // exercise
    MonitoredResource response = MonitoredResourceUtil.getResource("", "");
    // verify
    assertEquals(response.getType(), "gae_app");
    assertTrue(response.getLabels().equals(ExpectedLabels));
  }

  @Test
  public void testResourceTypeGAEFlexibleEnvironment() {
    final String MockedModuleId = "mocked-module-id";
    final String MockedVersionId = "mocked-version-id";
    final Map<String, String> ExpectedLabels =
        ImmutableMap.of(
            "project_id",
            MonitoredResourceUtilTest.MOCKED_PROJECT_ID,
            "module_id",
            MockedModuleId,
            "version_id",
            MockedVersionId,
            "env",
            "flex",
            "zone",
            MOCKED_ZONE);

    // setup
    setupCommonGAEMocks(MockedModuleId, MockedVersionId);
    expect(getterMock.getAttribute("instance/attributes/startup-script"))
        .andReturn("/var/lib/flex/startup_script.sh")
        .once();
    replay(getterMock);
    // exercise
    MonitoredResource response = MonitoredResourceUtil.getResource("", "");
    // verify
    assertEquals(response.getType(), "gae_app");
    assertTrue(response.getLabels().equals(ExpectedLabels));
  }

  @Test
  public void testResourceTypeCloudFunction() {
    final String MockedFunctionName = "mocked-function-name";
    final Map<String, String> ExpectedLabels =
        ImmutableMap.of(
            "project_id",
            MonitoredResourceUtilTest.MOCKED_PROJECT_ID,
            "function_name",
            MockedFunctionName,
            "region",
            MOCKED_REGION);

    // setup
    expect(getterMock.getAttribute("instance/region")).andReturn(MOCKED_QUALIFIED_REGION).once();
    expect(getterMock.getAttribute(anyString())).andReturn(null).anyTimes();
    expect(getterMock.getEnv("FUNCTION_SIGNATURE_TYPE")).andReturn(MOCKED_NON_EMPTY).once();
    expect(getterMock.getEnv("FUNCTION_TARGET")).andReturn(MOCKED_NON_EMPTY).once();
    expect(getterMock.getEnv("K_SERVICE")).andReturn(MockedFunctionName).anyTimes();
    expect(getterMock.getEnv(anyString())).andReturn(null).anyTimes();
    replay(getterMock);
    // exercise
    MonitoredResource response = MonitoredResourceUtil.getResource("", "");
    // verify
    assertEquals(response.getType(), "cloud_function");
    assertTrue(response.getLabels().equals(ExpectedLabels));
  }

  @Test
  public void testResourceTypeCloudRun() {
    final String MockedRevisionName = "mocked-revision-name";
    final String MockedServiceName = "mocked-service-name";
    final String MockedConfigurationName = "mocked-config-name";
    final Map<String, String> ExpectedLabels =
        ImmutableMap.of(
            "project_id",
            MonitoredResourceUtilTest.MOCKED_PROJECT_ID,
            "revision_name",
            MockedRevisionName,
            "configuration_name",
            MockedConfigurationName,
            "service_name",
            MockedServiceName,
            "location",
            MOCKED_REGION);

    // setup
    expect(getterMock.getAttribute("instance/region")).andReturn(MOCKED_QUALIFIED_REGION).once();
    expect(getterMock.getAttribute(anyString())).andReturn(null).anyTimes();
    expect(getterMock.getEnv("K_CONFIGURATION")).andReturn(MockedConfigurationName).times(2);
    expect(getterMock.getEnv("K_REVISION")).andReturn(MockedRevisionName).times(2);
    expect(getterMock.getEnv("K_SERVICE")).andReturn(MockedServiceName).anyTimes();
    expect(getterMock.getEnv(anyString())).andReturn(null).anyTimes();
    replay(getterMock);
    // exercise
    MonitoredResource response = MonitoredResourceUtil.getResource("", "");
    // verify
    assertEquals(response.getType(), "cloud_run_revision");
    assertTrue(response.getLabels().equals(ExpectedLabels));
  }
}
