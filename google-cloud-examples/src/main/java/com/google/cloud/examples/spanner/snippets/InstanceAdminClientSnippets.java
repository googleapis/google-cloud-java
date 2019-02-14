/*
 * Copyright 2018 Google LLC
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

/*
 * EDITING INSTRUCTIONS
 * This file is referenced in spanner/InstanceAdminClient's javadoc. Any change
 * to this file should be reflected in spanner/InstanceAdminClient's javadoc.
 */

package com.google.cloud.examples.spanner.snippets;

import com.google.api.gax.longrunning.OperationFuture;
import com.google.cloud.spanner.Instance;
import com.google.cloud.spanner.InstanceAdminClient;
import com.google.cloud.spanner.InstanceConfig;
import com.google.cloud.spanner.InstanceConfigId;
import com.google.cloud.spanner.InstanceId;
import com.google.cloud.spanner.InstanceInfo;
import com.google.cloud.spanner.Options;
import com.google.cloud.spanner.SpannerException;
import com.google.cloud.spanner.SpannerExceptionFactory;
import com.google.common.collect.Lists;
import com.google.spanner.admin.instance.v1.CreateInstanceMetadata;
import com.google.spanner.admin.instance.v1.UpdateInstanceMetadata;
import java.util.List;
import java.util.concurrent.ExecutionException;

/** This class contains snippets for {@link InstanceAdminClient} interface. */
public class InstanceAdminClientSnippets {

  private final InstanceAdminClient instanceAdminClient;

  public InstanceAdminClientSnippets(InstanceAdminClient instanceAdminClient) {
    this.instanceAdminClient = instanceAdminClient;
  }

  /** Example to get instance config. */
  public InstanceConfig getInstanceConfig(final String my_config_id) {
    // [START instance_admin_client_get_instance_config]
    final String configId = my_config_id;
    InstanceConfig instanceConfig = instanceAdminClient.getInstanceConfig(configId);
    // [END instance_admin_client_get_instance_config]
    return instanceConfig;
  }

  /** Example to list instance configs. */
  public List<InstanceConfig> listInstanceConfigs() {
    // [START instance_admin_client_list_configs]
    List<InstanceConfig> configs =
        Lists.newArrayList(
            instanceAdminClient.listInstanceConfigs(Options.pageSize(1)).iterateAll());
    // [END instance_admin_client_list_configs]
    return configs;
  }

  /** Example to create an instance. */
  public void createInstance(
      final String my_instance_id, final String my_config_id, final String my_client_project) {
    // [START instance_admin_client_create_instance]
    final String instanceId = my_instance_id;
    final String configId = my_config_id;
    final String clientProject = my_client_project;

    OperationFuture<Instance, CreateInstanceMetadata> op =
        instanceAdminClient.createInstance(
            InstanceInfo.newBuilder(InstanceId.of(clientProject, instanceId))
                .setInstanceConfigId(InstanceConfigId.of(clientProject, configId))
                .setDisplayName(instanceId)
                .setNodeCount(1)
                .build());
    try {
      op.get();
    } catch (ExecutionException e) {
      throw (SpannerException) e.getCause();
    } catch (InterruptedException e) {
      throw SpannerExceptionFactory.propagateInterrupt(e);
    }
    // [END instance_admin_client_create_instance]
  }

  /** Example to get an instance. */
  public Instance getInstance(final String my_instance_id) {
    // [START instance_admin_client_get_instance]
    final String instanceId = my_instance_id;
    Instance ins = instanceAdminClient.getInstance(instanceId);
    // [END instance_admin_client_get_instance]
    return ins;
  }

  /** Example to list instances. */
  public List<Instance> listInstances() {
    // [START instance_admin_client_list_instances]
    List<Instance> instances =
        Lists.newArrayList(instanceAdminClient.listInstances(Options.pageSize(1)).iterateAll());
    // [END instance_admin_client_list_instances]
    return instances;
  }

  /** Example to delete an instance. */
  public void deleteInstance(final String my_instance_id) {
    // [START instance_admin_client_delete_instance]
    final String instanceId = my_instance_id;
    instanceAdminClient.deleteInstance(instanceId);
    // [END instance_admin_client_delete_instance]
  }

  /** Example to update an instance. */
  public void updateInstance(
      Instance my_instance,
      final String my_client_project,
      final String my_instance_id,
      final String my_display_name) {
    // [START instance_admin_client_update_instance]
    Instance instance = my_instance;
    final String clientProject = my_client_project;
    final String instanceId = my_instance_id;

    final String newDisplayName = my_display_name;

    InstanceInfo toUpdate =
        InstanceInfo.newBuilder(InstanceId.of(clientProject, instanceId))
            .setDisplayName(newDisplayName)
            .setNodeCount(instance.getNodeCount() + 1)
            .build();
    // Only update display name
    OperationFuture<Instance, UpdateInstanceMetadata> op =
        instanceAdminClient.updateInstance(toUpdate, InstanceInfo.InstanceField.DISPLAY_NAME);
    try {
      op.get();
    } catch (ExecutionException e) {
      throw (SpannerException) e.getCause();
    } catch (InterruptedException e) {
      throw SpannerExceptionFactory.propagateInterrupt(e);
    }
    // [END instance_admin_client_update_instance]
  }
}
