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

import com.google.cloud.MonitoredResource;
import com.google.common.collect.ImmutableMap;
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
    expect(getterMock.getAttribute("project/project-id")).andReturn(MOCKED_PROJECT_ID).once();
    expect(getterMock.getAttribute("")).andReturn(MOCKED_NON_EMPTY).once();
    MonitoredResourceUtil.setEnvironmentGetter(getterMock);
  }

  @After
  public void teardown() {
    verify(getterMock);
  }

  @Test
  public void testResourceTypeGlobal() {
    final ImmutableMap<String, String> expectedLabels =
        ImmutableMap.of("project_id", MonitoredResourceUtilTest.MOCKED_PROJECT_ID);

    // setup
    expect(getterMock.getAttribute(anyString())).andReturn(null).anyTimes();
    expect(getterMock.getEnv(anyString())).andReturn(null).anyTimes();
    replay(getterMock);
    // exercise
    MonitoredResource response = MonitoredResourceUtil.getResource("", "");
    // verify
    assertEquals("global", response.getType());
    assertEquals(expectedLabels, response.getLabels());
  }

  @Test
  public void testGetResourceWithParameters() {
    final String myProjectId = "my-project-id";
    final String myResourceType = "my-resource-type";
    final ImmutableMap<String, String> expectedLabels = ImmutableMap.of("project_id", myProjectId);

    // setup
    replay(getterMock);
    // exercise
    MonitoredResource response = MonitoredResourceUtil.getResource(myProjectId, myResourceType);
    // The above doesn't query metadata... So just to satisfy the verify stage, query it:
    getterMock.getAttribute("project/project-id");
    getterMock.getAttribute("");
    // verify
    assertEquals("my-resource-type", response.getType());
    assertEquals(expectedLabels, response.getLabels());
  }

  @Test
  public void testResourceTypeGCEInstance() {
    final String mockedInstanceId = "1234567890abcdefg";
    final ImmutableMap<String, String> expectedLabels =
        ImmutableMap.of(
            "project_id",
            MonitoredResourceUtilTest.MOCKED_PROJECT_ID,
            "instance_id",
            mockedInstanceId,
            "zone",
            MOCKED_ZONE);

    // setup
    expect(getterMock.getAttribute("instance/id")).andReturn(mockedInstanceId).anyTimes();
    expect(getterMock.getAttribute("instance/preempted")).andReturn(MOCKED_NON_EMPTY).once();
    expect(getterMock.getAttribute("instance/cpu-platform")).andReturn(MOCKED_NON_EMPTY).once();
    expect(getterMock.getAttribute("instance/zone")).andReturn(MOCKED_QUALIFIED_ZONE).once();
    expect(getterMock.getAttribute(anyString())).andReturn(null).anyTimes();
    expect(getterMock.getEnv(anyString())).andReturn(null).anyTimes();
    replay(getterMock);
    // exercise
    MonitoredResource response = MonitoredResourceUtil.getResource("", "");
    // verify
    assertEquals("gce_instance", response.getType());
    assertEquals(expectedLabels, response.getLabels());
  }

  /**
   * Attention: This test can be flaky if the path <code>
   * /var/run/secrets/kubernetes.io/serviceaccount/namespace</code> exists and the file at this path
   * contains a value other than the mocked constant
   */
  @Test
  public void testResourceTypeK8sContainer() {
    final String mockedClusterName = "mocked-cluster-1";
    final String mockedNamespaceName = "default";
    final String mockedPodName = "mocked-pod";
    final String mockedContainerName = "mocked-container";
    final ImmutableMap<String, String> expectedLabels =
        ImmutableMap.<String, String>builder()
            .put("project_id", MonitoredResourceUtilTest.MOCKED_PROJECT_ID)
            .put("cluster_name", mockedClusterName)
            .put("location", MOCKED_ZONE)
            .put("namespace_name", mockedNamespaceName)
            .put("pod_name", mockedPodName)
            .put("container_name", mockedContainerName)
            .buildOrThrow();

    // setup
    expect(getterMock.getAttribute("instance/attributes/cluster-name"))
        .andReturn(mockedClusterName)
        .times(2);
    expect(getterMock.getAttribute("instance/zone")).andReturn(MOCKED_QUALIFIED_ZONE).once();
    expect(getterMock.getAttribute(anyString())).andReturn(null).anyTimes();
    expect(getterMock.getEnv("HOSTNAME")).andReturn(mockedPodName).anyTimes();
    expect(getterMock.getEnv("NAMESPACE_NAME")).andReturn(mockedNamespaceName).anyTimes();
    expect(getterMock.getEnv("CONTAINER_NAME")).andReturn(mockedContainerName).anyTimes();
    expect(getterMock.getEnv(anyString())).andReturn(null).anyTimes();
    replay(getterMock);
    // exercise
    MonitoredResource response = MonitoredResourceUtil.getResource("", "");
    // verify
    assertEquals("k8s_container", response.getType());
    assertEquals(expectedLabels, response.getLabels());
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
    final String mockedModuleId = "mocked-module-id";
    final String mockedVersionId = "mocked-version-id";
    final ImmutableMap<String, String> expectedLabels =
        ImmutableMap.of(
            "project_id",
            MonitoredResourceUtilTest.MOCKED_PROJECT_ID,
            "module_id",
            mockedModuleId,
            "version_id",
            mockedVersionId,
            "env",
            "standard",
            "zone",
            MOCKED_ZONE);

    // setup
    setupCommonGAEMocks(mockedModuleId, mockedVersionId);
    expect(getterMock.getAttribute(anyString())).andReturn(null).anyTimes();
    replay(getterMock);
    // exercise
    MonitoredResource response = MonitoredResourceUtil.getResource("", "");
    // verify
    assertEquals("gae_app", response.getType());
    assertEquals(expectedLabels, response.getLabels());
  }

  @Test
  public void testResourceTypeGAEFlexibleEnvironment() {
    final String mockedModuleId = "mocked-module-id";
    final String mockedVersionId = "mocked-version-id";
    final ImmutableMap<String, String> expectedLabels =
        ImmutableMap.of(
            "project_id",
            MonitoredResourceUtilTest.MOCKED_PROJECT_ID,
            "module_id",
            mockedModuleId,
            "version_id",
            mockedVersionId,
            "env",
            "flex",
            "zone",
            MOCKED_ZONE);

    // setup
    setupCommonGAEMocks(mockedModuleId, mockedVersionId);
    expect(getterMock.getAttribute("instance/attributes/startup-script"))
        .andReturn("/var/lib/flex/startup_script.sh")
        .once();
    replay(getterMock);
    // exercise
    MonitoredResource response = MonitoredResourceUtil.getResource("", "");
    // verify
    assertEquals("gae_app", response.getType());
    assertEquals(expectedLabels, response.getLabels());
  }

  @Test
  public void testResourceTypeCloudFunction() {
    final String mockedFunctionName = "mocked-function-name";
    final ImmutableMap<String, String> expectedLabels =
        ImmutableMap.of(
            "project_id",
            MonitoredResourceUtilTest.MOCKED_PROJECT_ID,
            "function_name",
            mockedFunctionName,
            "region",
            MOCKED_REGION);

    // setup
    expect(getterMock.getAttribute("instance/region")).andReturn(MOCKED_QUALIFIED_REGION).once();
    expect(getterMock.getAttribute(anyString())).andReturn(null).anyTimes();
    expect(getterMock.getEnv("FUNCTION_SIGNATURE_TYPE")).andReturn(MOCKED_NON_EMPTY).once();
    expect(getterMock.getEnv("FUNCTION_TARGET")).andReturn(MOCKED_NON_EMPTY).once();
    expect(getterMock.getEnv("K_SERVICE")).andReturn(mockedFunctionName).anyTimes();
    expect(getterMock.getEnv("K_REVISION")).andReturn(mockedFunctionName + ".1").anyTimes();
    expect(getterMock.getEnv("K_CONFIGURATION"))
        .andReturn(mockedFunctionName + "-config")
        .anyTimes();
    expect(getterMock.getEnv(anyString())).andReturn(null).anyTimes();
    replay(getterMock);
    // exercise
    MonitoredResource response = MonitoredResourceUtil.getResource("", "");
    // verify
    assertEquals("cloud_function", response.getType());
    assertEquals(expectedLabels, response.getLabels());
  }

  @Test
  public void testResourceTypeCloudRun() {
    final String mockedRevisionName = "mocked-revision-name";
    final String mockedServiceName = "mocked-service-name";
    final String mockedConfigurationName = "mocked-config-name";
    final ImmutableMap<String, String> expectedLabels =
        ImmutableMap.of(
            "project_id",
            MonitoredResourceUtilTest.MOCKED_PROJECT_ID,
            "revision_name",
            mockedRevisionName,
            "configuration_name",
            mockedConfigurationName,
            "service_name",
            mockedServiceName,
            "location",
            MOCKED_REGION);

    // setup
    expect(getterMock.getAttribute("instance/region")).andReturn(MOCKED_QUALIFIED_REGION).once();
    expect(getterMock.getAttribute(anyString())).andReturn(null).anyTimes();
    expect(getterMock.getEnv("K_CONFIGURATION")).andReturn(mockedConfigurationName).times(2);
    expect(getterMock.getEnv("K_REVISION")).andReturn(mockedRevisionName).times(2);
    expect(getterMock.getEnv("K_SERVICE")).andReturn(mockedServiceName).anyTimes();
    expect(getterMock.getEnv(anyString())).andReturn(null).anyTimes();
    replay(getterMock);
    // exercise
    MonitoredResource response = MonitoredResourceUtil.getResource("", "");
    // verify
    assertEquals("cloud_run_revision", response.getType());
    assertEquals(expectedLabels, response.getLabels());
  }

  @Test
  public void testResourceTypeCloudRunJob() {
    final String mockedJobName = "mocked-job-name";
    final ImmutableMap<String, String> expectedLabels =
        ImmutableMap.of(
            "project_id",
            MonitoredResourceUtilTest.MOCKED_PROJECT_ID,
            "job_name",
            mockedJobName,
            "location",
            MOCKED_REGION);

    // setup
    expect(getterMock.getAttribute("instance/region")).andReturn(MOCKED_QUALIFIED_REGION).once();
    expect(getterMock.getAttribute(anyString())).andReturn(null).anyTimes();
    expect(getterMock.getEnv("CLOUD_RUN_JOB")).andReturn(mockedJobName).times(2);
    expect(getterMock.getEnv("CLOUD_RUN_EXECUTION")).andReturn(mockedJobName + "_1").times(1);
    expect(getterMock.getEnv("CLOUD_RUN_TASK_INDEX")).andReturn("0").times(1);
    expect(getterMock.getEnv("CLOUD_RUN_TASK_ATTEMPT")).andReturn("0").times(1);
    expect(getterMock.getEnv(anyString())).andReturn(null).anyTimes();
    replay(getterMock);
    // exercise
    MonitoredResource response = MonitoredResourceUtil.getResource("", "");
    // verify
    assertEquals("cloud_run_job", response.getType());
    assertEquals(expectedLabels, response.getLabels());
  }
}
