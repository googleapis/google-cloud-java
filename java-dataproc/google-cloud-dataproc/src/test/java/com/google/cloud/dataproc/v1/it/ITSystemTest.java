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
package com.google.cloud.dataproc.v1.it;

import static org.junit.Assert.assertEquals;

import com.google.cloud.ServiceOptions;
import com.google.cloud.dataproc.v1.Cluster;
import com.google.cloud.dataproc.v1.ClusterConfig;
import com.google.cloud.dataproc.v1.ClusterControllerClient;
import com.google.cloud.dataproc.v1.ClusterControllerSettings;
import com.google.cloud.dataproc.v1.CreateClusterRequest;
import com.google.cloud.dataproc.v1.RegionName;
import com.google.cloud.dataproc.v1.WorkflowTemplate;
import com.google.cloud.dataproc.v1.WorkflowTemplateName;
import com.google.cloud.dataproc.v1.WorkflowTemplateServiceClient;
import com.google.common.collect.Lists;
import java.util.Iterator;
import java.util.List;
import java.util.UUID;
import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;

public class ITSystemTest {
  private static ClusterControllerClient clusterClient;
  private static WorkflowTemplateServiceClient workflowClient;

  private static final String PROJECT_ID = ServiceOptions.getDefaultProjectId();
  private static final String REGION = "global";
  private static final String ID = UUID.randomUUID().toString();
  private static final int VERSION = 1;
  private static final String CLUSTER_NAME =
      "test-cluster-" + UUID.randomUUID().toString().substring(0, 8);
  private static final String CLUSTER_REGION = "us-central1";
  private static final ClusterControllerSettings.Builder CLUSTER_CONTROLLER_SETTINGS =
      ClusterControllerSettings.newBuilder().setEndpoint("us-central1-dataproc.googleapis.com:443");
  private static final ClusterConfig CLUSTER_CONFIG = ClusterConfig.newBuilder().build();
  private static final Cluster CLUSTER =
      Cluster.newBuilder()
          .setProjectId(PROJECT_ID)
          .setClusterName(CLUSTER_NAME)
          .setClusterUuid(ID)
          .setConfig(CLUSTER_CONFIG)
          .build();
  private static final CreateClusterRequest CREATE_CLUSTER_REQUEST =
      CreateClusterRequest.newBuilder()
          .setProjectId(PROJECT_ID)
          .setRegion(CLUSTER_REGION)
          .setCluster(CLUSTER)
          .build();
  private static final WorkflowTemplateName WORKFLOW_TEMPLATE_NAME =
      WorkflowTemplateName.of(PROJECT_ID, REGION, ID);
  private static final RegionName PARENT = RegionName.of(PROJECT_ID, REGION);
  private static final WorkflowTemplate WORKFLOW_TEMPLATE =
      WorkflowTemplate.newBuilder()
          .setId(ID)
          .setName(WORKFLOW_TEMPLATE_NAME.toString())
          .setVersion(VERSION)
          .build();

  @BeforeClass
  public static void beforeClass() throws Exception {
    /** create cluster */
    clusterClient = ClusterControllerClient.create(CLUSTER_CONTROLLER_SETTINGS.build());
    clusterClient.createClusterAsync(CREATE_CLUSTER_REQUEST).get();

    /** create workflow */
    workflowClient = WorkflowTemplateServiceClient.create();
    workflowClient.createWorkflowTemplate(PARENT, WORKFLOW_TEMPLATE);
  }

  @AfterClass
  public static void afterClass() {
    /** delete cluster */
    clusterClient.deleteClusterAsync(PROJECT_ID, CLUSTER_REGION, CLUSTER_NAME);
    clusterClient.close();

    /** delete workflow */
    workflowClient.deleteWorkflowTemplate(WORKFLOW_TEMPLATE_NAME);
    workflowClient.close();
  }

  @Test
  public void getClusterTest() {
    Cluster cluster = clusterClient.getCluster(PROJECT_ID, CLUSTER_REGION, CLUSTER_NAME);
    assertEquals(PROJECT_ID, cluster.getProjectId());
    assertEquals(CLUSTER_NAME, cluster.getClusterName());
  }

  @Test
  public void listClustersTest() {
    ClusterControllerClient.ListClustersPagedResponse pagedListResponse =
        clusterClient.listClusters(PROJECT_ID, CLUSTER_REGION);
    List<Cluster> resources = Lists.newArrayList(pagedListResponse.iterateAll());
    int count = 0, cluster = 0;
    while (cluster < resources.size()) {
      count++;
      cluster++;
    }
    assertEquals(count, resources.size());
  }

  @Test
  public void getWorkflowTemplateTest() {
    WorkflowTemplate response = workflowClient.getWorkflowTemplate(WORKFLOW_TEMPLATE_NAME);
    assertEquals(ID, response.getId());
    assertEquals(WORKFLOW_TEMPLATE_NAME.toString(), response.getName());
    assertEquals(VERSION, response.getVersion());
  }

  @Test
  public void listWorkflowTemplateTest() {
    WorkflowTemplateServiceClient.ListWorkflowTemplatesPagedResponse response =
        workflowClient.listWorkflowTemplates(PARENT);
    Iterator<WorkflowTemplate> templateIterator = response.iterateAll().iterator();
    int count = 0;
    while (templateIterator.hasNext()) {
      templateIterator.next();
      count++;
    }
    assertEquals(1, count);
  }
}
