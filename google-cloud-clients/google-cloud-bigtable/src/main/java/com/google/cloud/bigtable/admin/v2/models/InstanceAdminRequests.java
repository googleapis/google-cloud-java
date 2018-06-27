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
import com.google.bigtable.admin.v2.CreateAppProfileRequest;
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

  public static CreateAppProfile createAppProfile(
      InstanceName instanceName, AppProfile appProfile, boolean ignoreWarnings) {
    return new CreateAppProfile(instanceName, appProfile, ignoreWarnings);
  }

  public static Instance convertToInstance(com.google.bigtable.admin.v2.Instance protoInstance) {
    return new Instance(protoInstance);
  }

  public static Cluster convertToCluster(com.google.bigtable.admin.v2.Cluster protoCluster) {
    return new Cluster(protoCluster);
  }

  public static Cluster convertToFailedCluster(String location) {
    return new Cluster(location);
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
    private final String DISPLAY_NAME_FIELDMASK = "display_name";
    private final String TYPE_FIELDMASK = "type";
    private final String LABELS_FIELDMASK = "labels";

    private final String id;
    private final List<String> replacefields = new ArrayList<>();
    private com.google.bigtable.admin.v2.Instance.Builder protoInstance =
        com.google.bigtable.admin.v2.Instance.newBuilder();

    public static Instance of(String instanceId, String displayName, Type instanceType) {
      return new Instance(instanceId, displayName, instanceType);
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

    public Instance updateDisplayName(String updatedDisplayName) {
      replacefields.add(DISPLAY_NAME_FIELDMASK);
      protoInstance.setDisplayName(updatedDisplayName);
      return this;
    }

    public Instance upgradeType() {
      Preconditions.checkArgument(
          Type.DEVELOPMENT.equals(protoInstance.getType()), "PRODUCTION type cannot be upgraded");
      replacefields.add(TYPE_FIELDMASK);
      protoInstance.setType(Type.PRODUCTION);
      return this;
    }

    public Instance updateLabels(Map<String, String> updatedLabels) {
      replacefields.add(LABELS_FIELDMASK);
      protoInstance.putAllLabels(updatedLabels);
      return this;
    }

    @InternalApi
    public com.google.bigtable.admin.v2.Instance toProto() {
      return protoInstance.build();
    }

    @InternalApi
    public com.google.bigtable.admin.v2.Instance toUpdateProto() {
      return protoInstance.clone().clearState().build();
    }

    @InternalApi
    public FieldMask getPartialUpdateFieldMask() {
      return FieldMask.newBuilder().addAllPaths(replacefields).build();
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

  public static final class Cluster {
    public static Cluster ofProd(
        String clusterId, Location location, StorageType defaultStorage, int serverNodes) {
      return new Cluster(clusterId, location, defaultStorage, serverNodes);
    }

    public static Cluster ofDev(String clusterId, Location location, StorageType defaultStorage) {
      return new Cluster(clusterId, location, defaultStorage, 0);
    }

    private final String id;
    private com.google.bigtable.admin.v2.Cluster.Builder protoCluster =
        com.google.bigtable.admin.v2.Cluster.newBuilder();

    private Cluster(
        String clusterId, Location location, StorageType defaultStorage, int serverNodes) {
      protoCluster
          .setLocation(location.toString())
          .setServeNodes(serverNodes)
          .setDefaultStorageType(defaultStorage);
      this.id = clusterId;
    }

    private Cluster(String location) {
      protoCluster.setLocation(location);
      id = "failedlocation";
    }

    private Cluster(com.google.bigtable.admin.v2.Cluster cluster) {
      protoCluster = cluster.toBuilder();
      id = getName().getCluster();
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

    public Cluster updateNumNodes(int serverNodes) {
      protoCluster.setServeNodes(serverNodes);
      return this;
    }

    @InternalApi
    public com.google.bigtable.admin.v2.Cluster toProto() {
      return protoCluster.build();
    }

    @InternalApi
    public com.google.bigtable.admin.v2.Cluster toUpdateProto() {
      return protoCluster.clone().clearState().clearDefaultStorageType().build();
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

  public static final class CreateAppProfile {
    private final CreateAppProfileRequest.Builder createAppProfRequest =
        CreateAppProfileRequest.newBuilder();

    private CreateAppProfile(
        InstanceName instanceName, AppProfile appProfile, boolean ignoreWarnings) {
      createAppProfRequest
          .setParent(instanceName.toString())
          .setAppProfileId(appProfile.getId())
          .setAppProfile(appProfile.toProto())
          .setIgnoreWarnings(ignoreWarnings);
    }

    public CreateAppProfileRequest toProto() {
      return createAppProfRequest.build();
    }
  }

  public static final class AppProfile {
    private static final String DESCRIPTION_FIELDMASK = "description";
    private static final String MULTI_CLUSTER_FIELDMASK = "multi_cluster_routing_use_any";
    private static final String SINGLE_CLUSTER__FIELDMASK = "single_cluster_routing";

    private final String id;
    private final List<String> replacefields = new ArrayList<>();
    private com.google.bigtable.admin.v2.AppProfile.Builder protoProfile =
        com.google.bigtable.admin.v2.AppProfile.newBuilder();

    public static AppProfile of(String profileId, RoutingPolicy routingPolicy) {
      return new AppProfile(profileId, routingPolicy);
    }

    private AppProfile(String profileId, RoutingPolicy routingPolicy) {
      Preconditions.checkNotNull(routingPolicy);
      id = profileId;
      setRoutingPolicy(routingPolicy);
    }

    private AppProfile(com.google.bigtable.admin.v2.AppProfile appProfile) {
      protoProfile = appProfile.toBuilder();
      id = getName().getAppProfile();
    }

    private void setRoutingPolicy(RoutingPolicy routingPolicy) {
      if (RoutingPolicyCase.MULTI_CLUSTER_ROUTING_USE_ANY.equals(routingPolicy.name())) {
        protoProfile.setMultiClusterRoutingUseAny(
            com.google.bigtable.admin.v2.AppProfile.MultiClusterRoutingUseAny.newBuilder().build());
        protoProfile.clearSingleClusterRouting();
        replacefields.add(MULTI_CLUSTER_FIELDMASK);
      }

      if (RoutingPolicyCase.SINGLE_CLUSTER_ROUTING.equals(routingPolicy.name())) {
        protoProfile.setSingleClusterRouting(
            com.google.bigtable.admin.v2.AppProfile.SingleClusterRouting.newBuilder()
                .setClusterId(((SingleClusterRouting) routingPolicy).clusterId)
                .setAllowTransactionalWrites(
                    ((SingleClusterRouting) routingPolicy).allowTransactionalWrites));
        protoProfile.clearMultiClusterRoutingUseAny();
        replacefields.add(SINGLE_CLUSTER__FIELDMASK);
      }
    }

    public String getId() {
      return id;
    }

    public AppProfile setDescription(String description) {
      protoProfile.setDescription(description);
      return this;
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
      if (RoutingPolicyCase.MULTI_CLUSTER_ROUTING_USE_ANY.equals(
          protoProfile.getRoutingPolicyCase().name())) {
        return new MultiClusterRoutingUseAny();
      }

      if (RoutingPolicyCase.SINGLE_CLUSTER_ROUTING.equals(
          protoProfile.getRoutingPolicyCase().name())) {
        return new SingleClusterRouting(protoProfile.getSingleClusterRouting());
      }

      return new RoutingPolicyNotSet();
    }

    public AppProfile updateDescription(String updatedDescription) {
      replacefields.add(DESCRIPTION_FIELDMASK);
      protoProfile.setDescription(updatedDescription);
      return this;
    }

    public AppProfile updateRoutingPolicy(RoutingPolicy routingPolicy) {
      setRoutingPolicy(routingPolicy);
      return this;
    }

    @InternalApi
    public com.google.bigtable.admin.v2.AppProfile toProto() {
      return protoProfile.build();
    }

    @InternalApi
    public com.google.bigtable.admin.v2.AppProfile toUpdateProto() {
      return protoProfile.clone().build();
    }

    @InternalApi
    public FieldMask getPartialUpdateFieldMask() {
      return FieldMask.newBuilder().addAllPaths(replacefields).build();
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
      public static MultiClusterRoutingUseAny of() {
        return new MultiClusterRoutingUseAny();
      }

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

      public static SingleClusterRouting of(String clusterId, boolean allowTransactionalWrites) {
        return new SingleClusterRouting(clusterId, allowTransactionalWrites);
      }

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
    public static Location of(ProjectName projectName, String zone) {
      return new Location(projectName, zone);
    }

    private final String location;

    private Location(ProjectName projectName, String zone) {
      Preconditions.checkNotNull(projectName);
      Preconditions.checkNotNull(zone);

      location =
          new StringBuilder(projectName.toString()).append("/locations/").append(zone).toString();
    }

    @Override
    public String toString() {
      return location;
    }
  }
}
