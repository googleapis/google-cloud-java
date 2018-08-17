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

import com.google.api.gax.paging.Page;
import com.google.cloud.spanner.Options.ListOption;
import com.google.spanner.admin.instance.v1.CreateInstanceMetadata;
import com.google.spanner.admin.instance.v1.UpdateInstanceMetadata;

/** Client to do admin operations on Cloud Spanner Instance and Instance Configs. */
public interface InstanceAdminClient {

  /** Gets an instance config. */
  /* <!--SNIPPET instance_admin_client_get_instance_config-->
   * <pre>{@code
   * final String configId = my_config_id;
   * InstanceConfig instanceConfig = instanceAdminClient.getInstanceConfig(configId);
   * }</pre>
   * <!--SNIPPET instance_admin_client_get_instance_config-->
   */
  InstanceConfig getInstanceConfig(String configId) throws SpannerException;

  /** Lists the supported instance configs for current project. */
  /* <!--SNIPPET instance_admin_client_list_configs-->
   * <pre>{@code
   * List<InstanceConfig> configs =
   *     Lists.newArrayList(instanceAdminClient.listInstanceConfigs(Options.pageSize(1)).iterateAll());
   * }</pre>
   * <!--SNIPPET instance_admin_client_list_configs-->
   */
  Page<InstanceConfig> listInstanceConfigs(ListOption... options) throws SpannerException;

  /**
   * Creates an instance and begins preparing it to begin serving. The returned {@code Operation}
   * can be used to track the progress of preparing the new instance. The instance name is assigned
   * by the caller. If the named instance already exists, a SpannerException is thrown. Immediately
   * upon completion of this request:
   *
   * <ul>
   *   <li> The instance is readable via the API, with all requested attributes but no allocated
   *       resources.
   *   <li> Its state is {@code CREATING}.
   * </ul>
   *
   * Until completion of the returned operation:
   *
   * <ul>
   *   <li> Cancelling the operation renders the instance immediately unreadable via the API.
   *   <li> The instance can be deleted.
   *   <li> All other attempts to modify the instance are rejected.
   * </ul>
   *
   * Upon completion of the returned operation:
   *
   * <ul>
   *   <li> Billing for all successfully-allocated resources begins (some types may have lower than
   *       the requested levels).
   *   <li> Databases can be created in the instance.
   *   <li> The instance's allocated resource levels are readable via the
   * </ul>
   *
   * <!--SNIPPET instance_admin_client_create_instance-->
   * <pre>{@code
   * final String instanceId = my_instance_id;
   * final String configId = my_config_id;
   * final String clientProject = my_client_project;
   *
   * Operation<Instance, CreateInstanceMetadata> op =
   *     instanceAdminClient.createInstance(InstanceInfo
   *         .newBuilder(InstanceId.of(clientProject, instanceId))
   *         .setInstanceConfigId(InstanceConfigId.of(clientProject, configId))
   *         .setDisplayName(instanceId)
   *         .setNodeCount(1)
   *         .build());
   * op.waitFor();
   * }</pre>
   * <!--SNIPPET instance_admin_client_create_instance-->
   */
  Operation<Instance, CreateInstanceMetadata> createInstance(InstanceInfo instance)
      throws SpannerException;

  /** Gets an instance. */
  /* <!--SNIPPET instance_admin_client_get_instance-->
   * <pre>{@code
   * final String instanceId = my_instance_id;
   * Instance ins = instanceAdminClient.getInstance(instanceId);
   * }</pre>
   * <!--SNIPPET instance_admin_client_get_instance-->
   */
  Instance getInstance(String instanceId) throws SpannerException;

  /**
   * Lists the instances.
   *
   * @param options Options to control the instances returned. It also supports {@link
   *     Options#filter(String)} option. The fields eligible for filtering are:
   *     <ul>
   *       <li> name
   *       <li> display_name
   *       <li> labels.key where key is the name of a label
   *     </ul>
   *
   * <!--SNIPPET instance_admin_client_list_instances-->
   * <pre>{@code
   * List<Instance> instances =
   *     Lists.newArrayList(
   *         instanceAdminClient.listInstances(Options.pageSize(1)).iterateAll());
   * }</pre>
   * <!--SNIPPET instance_admin_client_list_instances-->
   */
  Page<Instance> listInstances(ListOption... options) throws SpannerException;

  /** Deletes an instance. */
  /* <!--SNIPPET instance_admin_client_delete_instance-->
   * <pre>{@code
   * final String instanceId = my_instance_id;
   * instanceAdminClient.deleteInstance(instanceId);
   * }</pre>
   * <!--SNIPPET instance_admin_client_delete_instance-->
   */
  void deleteInstance(String instanceId) throws SpannerException;

  /**
   * Updates an instance, and begins allocating or releasing resources as requested. The returned
   * {@code Operation} can be used to track the progress of updating the instance. If the named
   * instance does not exist, throws SpannerException.
   *
   * <p>Immediately upon completion of this request:
   *
   * <ul>
   *   <li> For resource types for which a decrease in the instance's allocation has been requested,
   *       billing is based on the newly-requested level.
   * </ul>
   *
   * Until completion of the returned operation:
   *
   * <ul>
   *   <li> Cancelling the operation sets its metadata's
   *       [cancel_time][UpdateInstanceMetadata.cancel_time], and begins restoring resources to
   *       their pre-request values. The operation is guaranteed to succeed at undoing all resource
   *       changes, after which point it terminates with a `CANCELLED` status.
   *   <li> All other attempts to modify the instance are rejected.
   *   <li> Reading the instance via the API continues to give the pre-request resource levels.
   * </ul>
   *
   * Upon completion of the returned operation:
   *
   * <ul>
   *   <li> Billing begins for all successfully-allocated resources (some types may have lower than
   *       the requested levels).
   *   <li> All newly-reserved resources are available for serving the instance's tables.
   *   <li> The instance's new resource levels are readable via the API.
   * </ul>
   *
   * <!--SNIPPET instance_admin_client_update_instance-->
   * <pre>{@code
   * Instance instance = my_instance;
   * final String clientProject = my_client_project;
   * final String instanceId = my_instance_id;
   *
   * final String newDisplayName = my_display_name;
   *
   * InstanceInfo toUpdate =
   *     InstanceInfo.newBuilder(InstanceId.of(clientProject, instanceId))
   *         .setDisplayName(newDisplayName)
   *         .setNodeCount(instance.getNodeCount() + 1)
   *         .build();
   * // Only update display name
   * Operation<Instance, UpdateInstanceMetadata> op =
   *     instanceAdminClient.updateInstance(toUpdate, InstanceInfo.InstanceField.DISPLAY_NAME);
   * op.waitFor().getResult();
   * }</pre>
   * <!--SNIPPET instance_admin_client_update_instance-->
   */
  Operation<Instance, UpdateInstanceMetadata> updateInstance(
      InstanceInfo instance, InstanceInfo.InstanceField... fieldsToUpdate);

  /** Returns a builder for {@code Instance} object with the given id. */
  Instance.Builder newInstanceBuilder(InstanceId id);
}
