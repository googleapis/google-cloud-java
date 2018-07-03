package com.google.cloud.bigtable.admin.v2.models;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import com.google.api.core.BetaApi;
import com.google.api.core.InternalApi;
import com.google.bigtable.admin.v2.AppProfile.RoutingPolicyCase;
import com.google.bigtable.admin.v2.AppProfileName;
import com.google.bigtable.admin.v2.ClusterName;
import com.google.bigtable.admin.v2.CreateInstanceRequest;
import com.google.bigtable.admin.v2.Instance.State;
import com.google.bigtable.admin.v2.Instance.Type;
import com.google.bigtable.admin.v2.InstanceName;
import com.google.bigtable.admin.v2.ProjectName;
import com.google.bigtable.admin.v2.StorageType;
import com.google.cloud.Role;
import com.google.common.base.MoreObjects;
import com.google.common.base.Preconditions;
import com.google.iam.v1.Binding;
import com.google.protobuf.ByteString;
import com.google.protobuf.FieldMask;

@BetaApi
public final class InstanceAdminRequests {

  public static CreateInstance createInstance(
      ProjectName projectName, Instance instance, Cluster cluster) {
    return new CreateInstance(projectName, instance, cluster);
  }

  public static Instance convertToInstance(com.google.bigtable.admin.v2.Instance protoInstance) {
    return new Instance(protoInstance);
  }

  public static Cluster convertToCluster(com.google.bigtable.admin.v2.Cluster protoCluster) {
    return new Cluster(protoCluster);
  }

  public static AppProfile convertToAppProfile(com.google.bigtable.admin.v2.AppProfile appProfile) {
    return new AppProfile(appProfile);
  }

  public static Policy convertToPolicy(com.google.iam.v1.Policy policy) {
    return new Policy(policy);
  }

  /** */
  public static final class CreateInstance {
    private final CreateInstanceRequest.Builder createInstanceRequest =
        CreateInstanceRequest.newBuilder();

    private CreateInstance(ProjectName projectName, Instance instance, Cluster cluster) {
      Preconditions.checkNotNull(projectName);
      Preconditions.checkNotNull(instance);
      Preconditions.checkNotNull(cluster);

      createInstanceRequest
          .setParent(projectName.toString())
          .setInstanceId(instance.getid())
          .setInstance(instance.toProto())
          .putClusters(cluster.getId(), cluster.toProto());
    }

    public CreateInstance addCluster(Cluster cluster) {
      createInstanceRequest.putClusters(cluster.getId(), cluster.toProto());
      return this;
    }

    public CreateInstanceRequest toProto() {
      return createInstanceRequest.build();
    }
  }

  public static final class Instance {
    private final String id;
    private com.google.bigtable.admin.v2.Instance.Builder protoInstance =
        com.google.bigtable.admin.v2.Instance.newBuilder();

    public static Instance ofNewDevInstance(String instanceId, String displayName) {
      return new Instance(instanceId, displayName, Type.DEVELOPMENT);
    }

    public static Instance ofNewProdInstance(String instanceId, String displayName) {
      return new Instance(instanceId, displayName, Type.PRODUCTION);
    }

    public static UpdateInstance ofUpdateInstance(Instance instance) {
      return new UpdateInstance(instance);
    }

    private Instance(String instanceId, String displayName, Type instanceType) {
      this.id = instanceId;
      protoInstance.setDisplayName(displayName).setType(instanceType);
    }

    private Instance(com.google.bigtable.admin.v2.Instance instance) {
      this.protoInstance = instance.toBuilder();
      id = getName().getInstance();
    }

    public String getid() {
      return id;
    }

    public InstanceName getName() {
      return InstanceName.parse(protoInstance.getName());
    }

    public String getDisplayName() {
      return protoInstance.getDisplayName();
    }

    public State getState() {
      return protoInstance.getState();
    }

    public Type getType() {
      return protoInstance.getType();
    }

    public Map<String, String> getLabelsMap() {
      return protoInstance.getLabelsMap();
    }

    public Instance addLabel(String key, String value) {
      // TODO: add an regex check. Error from is hard to decipher
      protoInstance.putLabels(key, value);
      return this;
    }

    @InternalApi
    public com.google.bigtable.admin.v2.Instance toProto() {
      return protoInstance.build();
    }

    @Override
    public String toString() {
      return MoreObjects.toStringHelper(this)
          .add("name", getName())
          .add("displayName", getDisplayName())
          .add("state", getState())
          .add("type", getType())
          .add("labels", getLabelsMap())
          .toString();
    }
  }

  public static final class UpdateInstance {
    private final String DISPLAY_NAME_FIELDMASK = "display_name";
    private final String TYPE_FIELDMASK = "type";
    private final String LABELS_FIELDMASK = "labels";

    private final List<String> replacefields = new ArrayList<>();
    private com.google.bigtable.admin.v2.Instance.Builder protoUpdateInstance =
        com.google.bigtable.admin.v2.Instance.newBuilder();

    private UpdateInstance(Instance instance) {
      protoUpdateInstance = instance.toProto().toBuilder().clone();
    }

    public UpdateInstance updateDisplayName(String updatedDisplayName) {
      replacefields.add(DISPLAY_NAME_FIELDMASK);
      protoUpdateInstance.setDisplayName(updatedDisplayName);
      return this;
    }

    public UpdateInstance upgradeType() {
      Preconditions.checkArgument(
          Type.DEVELOPMENT.equals(protoUpdateInstance.getType()),
          "PRODUCTION type cannot be upgraded");
      replacefields.add(TYPE_FIELDMASK);
      protoUpdateInstance.setType(Type.PRODUCTION);
      return this;
    }

    public UpdateInstance updateLabels(Map<String, String> updatedLabels) {
      replacefields.add(LABELS_FIELDMASK);
      protoUpdateInstance.putAllLabels(updatedLabels);
      return this;
    }

    @InternalApi
    public com.google.bigtable.admin.v2.Instance toProto() {
      return protoUpdateInstance.clearState().build();
    }

    @InternalApi
    public FieldMask getPartialUpdateFieldMask() {
      return FieldMask.newBuilder().addAllPaths(replacefields).build();
    }
  }

  public static final class Cluster {
    public static Cluster ofNewDevCluster(String clusterId, Location location) {
      return new Cluster(clusterId, location, 0);
    }

    public static Cluster ofNewProdCluster(String clusterId, Location location, int serverNodes) {
      return new Cluster(clusterId, location, serverNodes);
    }

    public static UpdateCluster ofUpdateCluster(Cluster cluster) {
      return new UpdateCluster(cluster);
    }

    private final String id;
    private com.google.bigtable.admin.v2.Cluster.Builder protoCluster =
        com.google.bigtable.admin.v2.Cluster.newBuilder();

    private Cluster(String clusterId, Location location, int serverNodes) {
      protoCluster.setLocation(location.toString()).setServeNodes(serverNodes);
      this.id = clusterId;
    }

    private Cluster(com.google.bigtable.admin.v2.Cluster cluster) {
      protoCluster = cluster.toBuilder();
      id = getName().getCluster();
    }

    public Cluster setDefaultStorage(StorageType defaultStorage) {
      protoCluster.setDefaultStorageType(defaultStorage);
      return this;
    }

    public String getId() {
      return id;
    }

    public ClusterName getName() {
      return ClusterName.parse(protoCluster.getName());
    }

    public String getLocation() {
      return protoCluster.getLocation();
    }

    public com.google.bigtable.admin.v2.Cluster.State getState() {
      return protoCluster.getState();
    }

    public int getServerNodes() {
      return protoCluster.getServeNodes();
    }

    public StorageType getDefaultStorageType() {
      return protoCluster.getDefaultStorageType();
    }

    @InternalApi
    public com.google.bigtable.admin.v2.Cluster toProto() {
      // TODO: defaultStorage is currently optional, should we make this required?
      return protoCluster.build();
    }

    @Override
    public String toString() {
      return MoreObjects.toStringHelper(this)
          .add("name", getName())
          .add("location", getLocation())
          .add("state", getState())
          .add("serverNodes", getServerNodes())
          .add("defaultStorageType", getDefaultStorageType())
          .toString();
    }
  }

  public static final class UpdateCluster {
    private com.google.bigtable.admin.v2.Cluster.Builder protoUpdateCluster =
        com.google.bigtable.admin.v2.Cluster.newBuilder();

    private UpdateCluster(Cluster cluster) {
      protoUpdateCluster = cluster.toProto().toBuilder().clone();
    }

    public UpdateCluster updateNumNodes(int serverNodes) {
      protoUpdateCluster.setServeNodes(serverNodes);
      return this;
    }

    @InternalApi
    public com.google.bigtable.admin.v2.Cluster toProto() {
      return protoUpdateCluster.clearState().clearDefaultStorageType().build();
    }
  }

  public static final class AppProfile {
    private final String id;
    private com.google.bigtable.admin.v2.AppProfile.Builder protoProfile =
        com.google.bigtable.admin.v2.AppProfile.newBuilder();

    public static AppProfile ofNewAppProfile(String profileId) {
      return new AppProfile(profileId);
    }

    public static UpdateAppProfile ofUpdateAppProfile(AppProfile appProfile) {
      return new UpdateAppProfile(appProfile);
    }

    private AppProfile(String profileId) {
      id = profileId;
    }

    private AppProfile(com.google.bigtable.admin.v2.AppProfile appProfile) {
      protoProfile = appProfile.toBuilder();
      id = getName().getAppProfile();
    }

    public AppProfile setDescription(String description) {
      protoProfile.setDescription(description);
      return this;
    }

    public AppProfile routeToAny() {
      protoProfile.setMultiClusterRoutingUseAny(
          com.google.bigtable.admin.v2.AppProfile.MultiClusterRoutingUseAny.newBuilder().build());
      protoProfile.clearSingleClusterRouting();
      return this;
    }

    public AppProfile routeToCluster(String clusterId, boolean ignoreWarnings) {
      protoProfile.setSingleClusterRouting(
          com.google.bigtable.admin.v2.AppProfile.SingleClusterRouting.newBuilder()
              .setClusterId(clusterId)
              .setAllowTransactionalWrites(ignoreWarnings));
      protoProfile.clearMultiClusterRoutingUseAny();
      return this;
    }

    public String getId() {
      return id;
    }

    public AppProfileName getName() {
      return AppProfileName.parse(protoProfile.getName());
    }

    public String getEtag() {
      return protoProfile.getEtag();
    }

    public String getDescription() {
      return protoProfile.getDescription();
    }

    public RoutingPolicy getRoutingPolicy() {
      if (RoutingPolicyCase.MULTI_CLUSTER_ROUTING_USE_ANY
          .name()
          .equals(protoProfile.getRoutingPolicyCase().name())) {
        return new MultiClusterRoutingUseAny();
      }

      if (RoutingPolicyCase.SINGLE_CLUSTER_ROUTING
          .name()
          .equals(protoProfile.getRoutingPolicyCase().name())) {
        return new SingleClusterRouting(protoProfile.getSingleClusterRouting());
      }

      return new RoutingPolicyNotSet();
    }

    @InternalApi
    public com.google.bigtable.admin.v2.AppProfile toProto() {
      // TODO: should we default this to any instead?
      Preconditions.checkState(
          protoProfile.hasMultiClusterRoutingUseAny() || protoProfile.hasSingleClusterRouting(),
          "Must specify a routing option");
      return protoProfile.build();
    }

    @Override
    public String toString() {
      return MoreObjects.toStringHelper(this)
          .add("name", getName())
          .add("etag", getEtag())
          .add("description", getDescription())
          .add("routingPolicy", getRoutingPolicy())
          .toString();
    }

    public static class UpdateAppProfile {
      private static final String DESCRIPTION_FIELDMASK = "description";
      private static final String MULTI_CLUSTER_FIELDMASK = "multi_cluster_routing_use_any";
      private static final String SINGLE_CLUSTER__FIELDMASK = "single_cluster_routing";

      private final List<String> replacefields = new ArrayList<>();
      private com.google.bigtable.admin.v2.AppProfile.Builder protoUpdateProfile =
          com.google.bigtable.admin.v2.AppProfile.newBuilder();

      private UpdateAppProfile(AppProfile appProfile) {
        Preconditions.checkNotNull(appProfile);
        protoUpdateProfile = appProfile.toProto().toBuilder().clone();
      }

      public UpdateAppProfile updateDescription(String updatedDescription) {
        replacefields.add(DESCRIPTION_FIELDMASK);
        protoUpdateProfile.setDescription(updatedDescription);
        return this;
      }

      public UpdateAppProfile updateRouteToAny() {
        protoUpdateProfile.setMultiClusterRoutingUseAny(
            com.google.bigtable.admin.v2.AppProfile.MultiClusterRoutingUseAny.newBuilder().build());
        protoUpdateProfile.clearSingleClusterRouting();
        replacefields.add(MULTI_CLUSTER_FIELDMASK);
        return this;
      }

      public UpdateAppProfile updateRouteToCluster(String clusterId, boolean ignoreWarnings) {
        protoUpdateProfile.setSingleClusterRouting(
            com.google.bigtable.admin.v2.AppProfile.SingleClusterRouting.newBuilder()
                .setClusterId(clusterId)
                .setAllowTransactionalWrites(ignoreWarnings));
        protoUpdateProfile.clearMultiClusterRoutingUseAny();
        replacefields.add(SINGLE_CLUSTER__FIELDMASK);
        return this;
      }

      @InternalApi
      public com.google.bigtable.admin.v2.AppProfile toProto() {
        return protoUpdateProfile.build();
      }

      @InternalApi
      public FieldMask getPartialUpdateFieldMask() {
        return FieldMask.newBuilder().addAllPaths(replacefields).build();
      }
    }

    public interface RoutingPolicy {
      RoutingPolicyCase name();
    }

    public static class RoutingPolicyNotSet implements RoutingPolicy {
      private RoutingPolicyNotSet() {}

      @Override
      public RoutingPolicyCase name() {
        return RoutingPolicyCase.ROUTINGPOLICY_NOT_SET;
      }

      @Override
      public String toString() {
        return MoreObjects.toStringHelper(this).add("name", name()).toString();
      }
    }

    public static class MultiClusterRoutingUseAny implements RoutingPolicy {
      private MultiClusterRoutingUseAny() {}

      @Override
      public RoutingPolicyCase name() {
        return RoutingPolicyCase.MULTI_CLUSTER_ROUTING_USE_ANY;
      }

      @Override
      public String toString() {
        return MoreObjects.toStringHelper(this).add("name", name()).toString();
      }
    }

    public static class SingleClusterRouting implements RoutingPolicy {
      private final String clusterId;
      private final boolean allowTransactionalWrites;

      private SingleClusterRouting(String clusterId, boolean allowTransactionalWrites) {
        this.clusterId = clusterId;
        this.allowTransactionalWrites = allowTransactionalWrites;
      }

      private SingleClusterRouting(
          com.google.bigtable.admin.v2.AppProfile.SingleClusterRouting routing) {
        this.clusterId = routing.getClusterId();
        this.allowTransactionalWrites = routing.getAllowTransactionalWrites();
      }

      public String getClusterId() {
        return clusterId;
      }

      public boolean isAllowTransactionalWrites() {
        return allowTransactionalWrites;
      }

      @Override
      public RoutingPolicyCase name() {
        return RoutingPolicyCase.SINGLE_CLUSTER_ROUTING;
      }

      @Override
      public String toString() {
        return MoreObjects.toStringHelper(this)
            .add("name", name())
            .add("clusterId", getClusterId())
            .add("allowTransactionalWrites", isAllowTransactionalWrites())
            .toString();
      }
    }
  }

  public static final class Policy {
    private com.google.iam.v1.Policy.Builder protoPolicy = com.google.iam.v1.Policy.newBuilder();

    public static Policy of(int version, Role role, List<String> members) {
      return new Policy(version, role, members);
    }

    private Policy(int version, Role role, List<String> members) {
      Preconditions.checkNotNull(role);
      Preconditions.checkNotNull(members);

      protoPolicy.setVersion(version);
      addRole(role, members);
    }

    private Policy(com.google.iam.v1.Policy policy) {
      protoPolicy = policy.toBuilder();
    }

    public Policy addRole(Role role, List<String> members) {
      Preconditions.checkNotNull(role);
      Preconditions.checkNotNull(members);

      protoPolicy.addBindings(
          com.google.iam.v1.Binding.newBuilder().setRole(role.toString()).addAllMembers(members));
      return this;
    }

    public int getVersion() {
      return protoPolicy.getVersion();
    }

    public ByteString getEtag() {
      return protoPolicy.getEtag();
    }

    public Map<Role, List<String>> getBindingsMap() {
      Map<Role, List<String>> bindings = new HashMap<>();

      for (Binding binding : protoPolicy.getBindingsList()) {
        bindings.put(Role.of(binding.getRole()), binding.getMembersList());
      }
      return bindings;
    }

    @InternalApi
    public com.google.iam.v1.Policy toProto() {
      return protoPolicy.build();
    }

    @Override
    public String toString() {
      return MoreObjects.toStringHelper(this)
          .add("version", getVersion())
          .add("etag", getEtag())
          .add("bindingsMap", getBindingsMap())
          .toString();
    }
  }

  public static final class Location {
    public static Location of(String project, String zone) {
      return new Location(project, zone);
    }

    private final String location;

    private Location(String project, String zone) {
      Preconditions.checkNotNull(project);
      Preconditions.checkNotNull(zone);

      location =
          new StringBuilder(ProjectName.of(project).toString())
              .append("/locations/")
              .append(zone)
              .toString();
    }

    @Override
    public String toString() {
      return location;
    }
  }
}
