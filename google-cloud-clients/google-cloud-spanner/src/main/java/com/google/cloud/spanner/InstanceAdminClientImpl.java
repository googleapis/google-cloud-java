/*
 * Copyright 2019 Google LLC
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

import com.google.api.core.ApiFunction;
import com.google.api.gax.grpc.ProtoOperationTransformers;
import com.google.api.gax.longrunning.OperationFuture;
import com.google.api.gax.longrunning.OperationFutureImpl;
import com.google.api.gax.longrunning.OperationSnapshot;
import com.google.api.gax.paging.Page;
import com.google.api.pathtemplate.PathTemplate;
import com.google.cloud.Policy;
import com.google.cloud.Policy.DefaultMarshaller;
import com.google.cloud.spanner.Options.ListOption;
import com.google.cloud.spanner.SpannerImpl.PageFetcher;
import com.google.cloud.spanner.spi.v1.SpannerRpc;
import com.google.cloud.spanner.spi.v1.SpannerRpc.Paginated;
import com.google.common.base.Preconditions;
import com.google.protobuf.FieldMask;
import com.google.spanner.admin.instance.v1.CreateInstanceMetadata;
import com.google.spanner.admin.instance.v1.UpdateInstanceMetadata;

/** Default implementation of {@link InstanceAdminClient} */
class InstanceAdminClientImpl implements InstanceAdminClient {
  private static final class PolicyMarshaller extends DefaultMarshaller {
    @Override
    protected Policy fromPb(com.google.iam.v1.Policy policyPb) {
      return super.fromPb(policyPb);
    }

    @Override
    protected com.google.iam.v1.Policy toPb(Policy policy) {
      return super.toPb(policy);
    }
  }

  private static final PathTemplate PROJECT_NAME_TEMPLATE =
      PathTemplate.create("projects/{project}");
  private final DatabaseAdminClient dbClient;
  private final String projectId;
  private final SpannerRpc rpc;
  private final PolicyMarshaller policyMarshaller = new PolicyMarshaller();

  InstanceAdminClientImpl(String projectId, SpannerRpc rpc, DatabaseAdminClient dbClient) {
    this.projectId = projectId;
    this.rpc = rpc;
    this.dbClient = dbClient;
  }

  @Override
  public InstanceConfig getInstanceConfig(String configId) throws SpannerException {
    String instanceConfigName = new InstanceConfigId(projectId, configId).getName();
    return InstanceConfig.fromProto(
        rpc.getInstanceConfig(instanceConfigName), InstanceAdminClientImpl.this);
  }

  @Override
  public Page<InstanceConfig> listInstanceConfigs(ListOption... options) {
    final Options listOptions = Options.fromListOptions(options);
    Preconditions.checkArgument(
        !listOptions.hasFilter(), "Filter option is not supported by listInstanceConfigs");
    final int pageSize = listOptions.hasPageSize() ? listOptions.pageSize() : 0;
    PageFetcher<InstanceConfig, com.google.spanner.admin.instance.v1.InstanceConfig> pageFetcher =
        new PageFetcher<InstanceConfig, com.google.spanner.admin.instance.v1.InstanceConfig>() {
          @Override
          public Paginated<com.google.spanner.admin.instance.v1.InstanceConfig> getNextPage(
              String nextPageToken) {
            return rpc.listInstanceConfigs(pageSize, nextPageToken);
          }

          @Override
          public InstanceConfig fromProto(
              com.google.spanner.admin.instance.v1.InstanceConfig proto) {
            return InstanceConfig.fromProto(proto, InstanceAdminClientImpl.this);
          }
        };
    if (listOptions.hasPageToken()) {
      pageFetcher.setNextPageToken(listOptions.pageToken());
    }
    return pageFetcher.getNextPage();
  }

  @Override
  public OperationFuture<Instance, CreateInstanceMetadata> createInstance(InstanceInfo instance)
      throws SpannerException {
    String projectName = PROJECT_NAME_TEMPLATE.instantiate("project", projectId);
    OperationFuture<com.google.spanner.admin.instance.v1.Instance, CreateInstanceMetadata>
        rawOperationFuture =
            rpc.createInstance(projectName, instance.getId().getInstance(), instance.toProto());

    return new OperationFutureImpl<Instance, CreateInstanceMetadata>(
        rawOperationFuture.getPollingFuture(),
        rawOperationFuture.getInitialFuture(),
        new ApiFunction<OperationSnapshot, Instance>() {
          @Override
          public Instance apply(OperationSnapshot snapshot) {
            return Instance.fromProto(
                ProtoOperationTransformers.ResponseTransformer.create(
                        com.google.spanner.admin.instance.v1.Instance.class)
                    .apply(snapshot),
                InstanceAdminClientImpl.this,
                dbClient);
          }
        },
        ProtoOperationTransformers.MetadataTransformer.create(CreateInstanceMetadata.class),
        new ApiFunction<Exception, Instance>() {
          @Override
          public Instance apply(Exception e) {
            throw SpannerExceptionFactory.newSpannerException(e);
          }
        });
  }

  @Override
  public Instance getInstance(String instanceId) throws SpannerException {
    String instanceName = new InstanceId(projectId, instanceId).getName();
    return Instance.fromProto(
        rpc.getInstance(instanceName), InstanceAdminClientImpl.this, dbClient);
  }

  @Override
  public Page<Instance> listInstances(ListOption... options) throws SpannerException {
    final Options listOptions = Options.fromListOptions(options);
    final int pageSize = listOptions.hasPageSize() ? listOptions.pageSize() : 0;
    final String filter = listOptions.filter();
    PageFetcher<Instance, com.google.spanner.admin.instance.v1.Instance> pageFetcher =
        new PageFetcher<Instance, com.google.spanner.admin.instance.v1.Instance>() {
          @Override
          public Paginated<com.google.spanner.admin.instance.v1.Instance> getNextPage(
              String nextPageToken) {
            return rpc.listInstances(pageSize, nextPageToken, filter);
          }

          @Override
          public Instance fromProto(com.google.spanner.admin.instance.v1.Instance proto) {
            return Instance.fromProto(proto, InstanceAdminClientImpl.this, dbClient);
          }
        };
    if (listOptions.hasPageToken()) {
      pageFetcher.setNextPageToken(listOptions.pageToken());
    }
    return pageFetcher.getNextPage();
  }

  @Override
  public void deleteInstance(final String instanceId) throws SpannerException {
    rpc.deleteInstance(new InstanceId(projectId, instanceId).getName());
  }

  @Override
  public OperationFuture<Instance, UpdateInstanceMetadata> updateInstance(
      InstanceInfo instance, InstanceInfo.InstanceField... fieldsToUpdate) {
    FieldMask fieldMask =
        fieldsToUpdate.length == 0
            ? InstanceInfo.InstanceField.toFieldMask(InstanceInfo.InstanceField.values())
            : InstanceInfo.InstanceField.toFieldMask(fieldsToUpdate);

    OperationFuture<com.google.spanner.admin.instance.v1.Instance, UpdateInstanceMetadata>
        rawOperationFuture = rpc.updateInstance(instance.toProto(), fieldMask);
    return new OperationFutureImpl<Instance, UpdateInstanceMetadata>(
        rawOperationFuture.getPollingFuture(),
        rawOperationFuture.getInitialFuture(),
        new ApiFunction<OperationSnapshot, Instance>() {
          @Override
          public Instance apply(OperationSnapshot snapshot) {
            return Instance.fromProto(
                ProtoOperationTransformers.ResponseTransformer.create(
                        com.google.spanner.admin.instance.v1.Instance.class)
                    .apply(snapshot),
                InstanceAdminClientImpl.this,
                dbClient);
          }
        },
        ProtoOperationTransformers.MetadataTransformer.create(UpdateInstanceMetadata.class),
        new ApiFunction<Exception, Instance>() {
          @Override
          public Instance apply(Exception e) {
            throw SpannerExceptionFactory.newSpannerException(e);
          }
        });
  }

  @Override
  public Policy getInstanceIAMPolicy(String instanceId) {
    String instanceName = InstanceId.of(projectId, instanceId).getName();
    return policyMarshaller.fromPb(rpc.getInstanceAdminIAMPolicy(instanceName));
  }

  @Override
  public Policy setInstanceIAMPolicy(String instanceId, Policy policy) {
    Preconditions.checkNotNull(policy);
    String instanceName = InstanceId.of(projectId, instanceId).getName();
    return policyMarshaller.fromPb(
        rpc.setInstanceAdminIAMPolicy(instanceName, policyMarshaller.toPb(policy)));
  }

  @Override
  public Iterable<String> testInstanceIAMPermissions(
      String instanceId, Iterable<String> permissions) {
    Preconditions.checkNotNull(permissions);
    String instanceName = InstanceId.of(projectId, instanceId).getName();
    return rpc.testInstanceAdminIAMPermissions(instanceName, permissions).getPermissionsList();
  }

  @Override
  public Instance.Builder newInstanceBuilder(InstanceId id) {
    return new Instance.Builder(this, dbClient, id);
  }
}
