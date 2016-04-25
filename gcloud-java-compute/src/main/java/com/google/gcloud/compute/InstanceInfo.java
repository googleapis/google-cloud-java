/*
 * Copyright 2016 Google Inc. All Rights Reserved.
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

package com.google.gcloud.compute;

import static com.google.common.base.Preconditions.checkNotNull;

import com.google.api.services.compute.model.Instance;
import com.google.common.base.Function;
import com.google.common.base.MoreObjects;
import com.google.common.collect.ImmutableList;
import com.google.common.collect.ImmutableMap;
import com.google.common.collect.Lists;
import com.google.common.collect.Maps;

import org.joda.time.format.DateTimeFormatter;
import org.joda.time.format.ISODateTimeFormat;

import java.io.Serializable;
import java.math.BigInteger;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.Objects;

/**
 * A Google Compute Engine VM Instance. An instance is a virtual machine (VM) hosted on Google's
 * infrastructure. Instances can run Linux and Windows Server images provided by Google, or any
 * customized versions of these images. You can also build and run images of other operating
 * systems. Google Compute Engine also lets you choose the machine properties of your instances,
 * such as the number of virtual CPUs and the amount of memory
 *
 * <p>By default, each Compute Engine instance has a small root persistent disk that contains the
 * operating system. When your applications require additional storage space, you can add one or
 * more additional disks to your instance.
 *
 * <p>Instances communicate with other instances in the same network through a local area network.
 * Instances communicate with the rest of the world through the Internet. A network lives in a
 * project and is isolated from other networks in the project. A project can have up to five
 * different networks.
 *
 * @see <a href="https://cloud.google.com/compute/docs/instances/">Virtual Machine Instances</a>
 */
public class InstanceInfo implements Serializable {

  static final Function<Instance, InstanceInfo> FROM_PB_FUNCTION =
      new Function<Instance, InstanceInfo>() {
        @Override
        public InstanceInfo apply(Instance pb) {
          return InstanceInfo.fromPb(pb);
        }
      };
  static final Function<InstanceInfo, Instance> TO_PB_FUNCTION =
      new Function<InstanceInfo, Instance>() {
        @Override
        public Instance apply(InstanceInfo instance) {
          return instance.toPb();
        }
      };

  private static final long serialVersionUID = -6601223112628977168L;
  private static final DateTimeFormatter TIMESTAMP_FORMATTER = ISODateTimeFormat.dateTime();

  private final String id;
  private final InstanceId instanceId;
  private final Long creationTimestamp;
  private final String description;
  private final Status status;
  private final String statusMessage;
  private final Tags tags;
  private final MachineTypeId machineType;
  private final Boolean canIpForward;
  private final List<NetworkInterface> networkInterfaces;
  private final List<AttachedDisk> attachedDisks;
  private final Metadata metadata;
  private final List<ServiceAccount> serviceAccounts;
  private final SchedulingOptions schedulingOptions;
  private final String cpuPlatform;

  /**
   * The status of the instance.
   */
  public enum Status {
    /**
     * Indicates that resources are being reserved for the instance. The instance isn't running yet.
     */
    PROVISIONING,

    /**
     * Indicates that resources have been acquired and the instance is being prepared for launch.
     */
    STAGING,

    /**
     * Indicates that the instance is booting up or running. You should be able to {@code ssh} into
     * the instance soon, though not immediately, after it enters this state.
     */
    RUNNING,

    /**
     * Indicates that the instance is being stopped either due to a failure, or the instance being
     * shut down. This is a temporary status and the instance will move to {@code TERMINATED}.
     */
    STOPPING,

    /**
     * Indicates that the instance was shut down or encountered a failure, either through the API or
     * from inside the guest. You can choose to restart the instance or delete it.
     */
    TERMINATED
  }

  /**
   * A list of tags for a Google Compute Engine Instance; with associated fingerprint. Tags are used
   * to identify valid sources or targets for network firewalls and are specified by the client
   * during instance creation. Each tag within the list must comply with RFC1035.
   *
   * @see <a href="https://www.ietf.org/rfc/rfc1035.txt">RFC1035</a>
   */
  public static final class Tags implements Serializable {

    static final Function<com.google.api.services.compute.model.Tags, Tags> FROM_PB_FUNCTION =
        new Function<com.google.api.services.compute.model.Tags, Tags>() {
          @Override
          public Tags apply(com.google.api.services.compute.model.Tags pb) {
            return Tags.fromPb(pb);
          }
        };
    static final Function<Tags, com.google.api.services.compute.model.Tags> TO_PB_FUNCTION =
        new Function<Tags, com.google.api.services.compute.model.Tags>() {
          @Override
          public com.google.api.services.compute.model.Tags apply(Tags tags) {
            return tags.toPb();
          }
        };

    private static final long serialVersionUID = 5627093820497225322L;

    private final List<String> values;
    private final String fingerprint;

    /**
     * A builder for {@code Tags} objects.
     */
    public static final class Builder {

      private List<String> values;
      private String fingerprint;

      private Builder() {
        values = Lists.newArrayList();
      }

      private Builder(Tags tags) {
        this.values = tags.values != null ? Lists.newArrayList(tags.values)
            : Lists.<String>newArrayList();
        this.fingerprint = tags.fingerprint;
      }

      /**
       * Sets a list of tags to apply to an instance. Tags are used to identify valid sources or
       * targets for network firewalls. Each tag within the list must comply with RFC1035.
       *
       * @see <a href="https://www.ietf.org/rfc/rfc1035.txt">RFC1035</a>
       */
      public Builder values(Iterable<String> values) {
        this.values = Lists.newArrayList(values);
        return this;
      }

      /**
       * Sets a list of tags to apply to an instance. Tags are used to identify valid sources or
       * targets for network firewalls. Each tag within the list must comply with RFC1035.
       *
       * @see <a href="https://www.ietf.org/rfc/rfc1035.txt">RFC1035</a>
       */
      public Builder values(String... values) {
        this.values = Lists.newArrayList(Arrays.asList(checkNotNull(values)));
        return this;
      }

      /**
       * Adds a tag to the list of tags. Tags are used to identify valid sources or targets for
       * network firewalls. The tag must comply with RFC1035.
       *
       * @see <a href="https://www.ietf.org/rfc/rfc1035.txt">RFC1035</a>
       */
      public Builder add(String tag) {
        this.values.add(tag);
        return this;
      }

      /**
       * Sets the fingerprint for the tags. This value is needed to update instance's tags.
       */
      public Builder fingerprint(String fingerprint) {
        this.fingerprint = fingerprint;
        return this;
      }

      /**
       * Creates a {@code Tags} object.
       */
      public Tags build() {
        return new Tags(this);
      }
    }

    private Tags(Builder builder) {
      this.values = ImmutableList.copyOf(builder.values);
      this.fingerprint = builder.fingerprint;
    }

    /**
     * Returns a list of tags to apply to an instance. Tags are used to identify valid sources or
     * targets for network firewalls. Each tag within the list must comply with RFC1035.
     *
     * @see <a href="https://www.ietf.org/rfc/rfc1035.txt">RFC1035</a>
     */
    public List<String> values() {
      return values;
    }

    /**
     * Returns the fingerprint for the tags. This value is needed to update instance's tags.
     */
    public String fingerprint() {
      return fingerprint;
    }

    /**
     * Returns a builder for the current instance tags.
     */
    public Builder toBuilder() {
      return new Builder(this);
    }

    @Override
    public String toString() {
      return MoreObjects.toStringHelper(this)
          .add("values", values)
          .add("fingerprint", fingerprint)
          .toString();
    }

    @Override
    public int hashCode() {
      return Objects.hash(values, fingerprint);
    }

    @Override
    public boolean equals(Object obj) {
      return obj == this || obj instanceof Tags && Objects.equals(toPb(), ((Tags) obj).toPb());
    }

    com.google.api.services.compute.model.Tags toPb() {
      com.google.api.services.compute.model.Tags tagsPb =
          new com.google.api.services.compute.model.Tags();
      tagsPb.setFingerprint(fingerprint);
      tagsPb.setItems(values);
      return tagsPb;
    }

    /**
     * Returns a builder for a {@code Tags} object given the tags to apply to the instance. Each tag
     * within the list must comply with RFC1035.
     *
     * @see <a href="https://www.ietf.org/rfc/rfc1035.txt">RFC1035</a>
     */
    public static Builder builder(Iterable<String> values) {
      return new Builder().values(values);
    }

    /**
     * Returns a builder for a {@code Tags} object given the tags to apply to the instance. Each tag
     * within the list must comply with RFC1035.
     *
     * @see <a href="https://www.ietf.org/rfc/rfc1035.txt">RFC1035</a>
     */
    public static Builder builder(String... values) {
      return new Builder().values(values);
    }

    /**
     * Returns a {@code Tags} object given the tags to apply to the instance. Each tag within the
     * list must comply with RFC1035.
     *
     * @see <a href="https://www.ietf.org/rfc/rfc1035.txt">RFC1035</a>
     */
    public static Tags of(Iterable<String> values) {
      return builder(values).build();
    }

    /**
     * Returns a {@code Tags} object given the tags to apply to the instance. Each tag within the
     * list must comply with RFC1035.
     *
     * @see <a href="https://www.ietf.org/rfc/rfc1035.txt">RFC1035</a>
     */
    public static Tags of(String... values) {
      return builder(values).build();
    }

    static Tags fromPb(com.google.api.services.compute.model.Tags tagsPb) {
      Builder builder =
          builder(tagsPb.getItems() != null ? tagsPb.getItems() : ImmutableList.<String>of());
      return builder.fingerprint(tagsPb.getFingerprint()).build();
    }
  }

  /**
   * Metadata for Google Compute Engine Instance as ket/value pairs. This includes custom metadata
   * and predefined keys.
   *
   * @see <a href="https://cloud.google.com/compute/docs/metadata">Metadata</a>
   */
  public static final class Metadata implements Serializable {

    static final Function<com.google.api.services.compute.model.Metadata, Metadata>
        FROM_PB_FUNCTION =
        new Function<com.google.api.services.compute.model.Metadata, Metadata>() {
          @Override
          public Metadata apply(com.google.api.services.compute.model.Metadata pb) {
            return Metadata.fromPb(pb);
          }
        };
    static final Function<Metadata, com.google.api.services.compute.model.Metadata> TO_PB_FUNCTION =
        new Function<Metadata, com.google.api.services.compute.model.Metadata>() {
          @Override
          public com.google.api.services.compute.model.Metadata apply(Metadata metadata) {
            return metadata.toPb();
          }
        };

    private static final long serialVersionUID = -945038809838910107L;

    private final Map<String, String> values;
    private final String fingerprint;

    /**
     * A builder for {@code Metadata} objects.
     */
    public static final class Builder {

      private Map<String, String> values;
      private String fingerprint;

      Builder() {
        values = Maps.newHashMap();
      }

      Builder(Metadata metadata) {
        this.values = metadata.values != null ? Maps.newHashMap(metadata.values)
            : Maps.<String, String>newHashMap();
        this.fingerprint = metadata.fingerprint;
      }

      /**
       * Sets the metadata for the instance as key/value pairs. The total size of all keys and
       * values must be less than 512 KB. Keys must conform to the following regexp:
       * {@code [a-zA-Z0-9-_]+}, and be less than 128 bytes in length. This is reflected as part of
       * a URL in the metadata server. Additionally, to avoid ambiguity, keys must not conflict with
       * any other metadata keys for the project. Values must be less than or equal to 32768 bytes.
       */
      public Builder values(Map<String, String> values) {
        this.values = Maps.newHashMap(checkNotNull(values));
        return this;
      }

      /**
       * Adds a key/value pair to the instance metadata. The total size of all keys and values must
       * be less than 512 KB. Keys must conform to the following regexp: {@code [a-zA-Z0-9-_]+}, and
       * be less than 128 bytes in length. This is reflected as part of a URL in the metadata
       * server. Additionally, to avoid ambiguity, keys must not conflict with any other metadata
       * keys for the project. Values must be less than or equal to 32768 bytes.
       */
      public Builder add(String key, String value) {
        this.values.put(key, value);
        return this;
      }

      /**
       * Sets the fingerprint for the metadata. This value can be used to update instance's
       * metadata.
       */
      public Builder fingerprint(String fingerprint) {
        this.fingerprint = fingerprint;
        return this;
      }

      /**
       * Creates a {@code Metadata} object.
       */
      public Metadata build() {
        return new Metadata(this);
      }
    }

    private Metadata(Builder builder) {
      this.values = ImmutableMap.copyOf(builder.values);
      this.fingerprint = builder.fingerprint;
    }

    /**
     * Returns instance's metadata as key/value pairs.
     */
    public Map<String, String> values() {
      return values;
    }

    /**
     * Returns the fingerprint for the metadata. This value can be used to update instance's
     * metadata.
     */
    public String fingerprint() {
      return fingerprint;
    }

    /**
     * Returns a builder for the current instance metadata.
     */
    public Builder toBuilder() {
      return new Builder(this);
    }

    @Override
    public String toString() {
      return MoreObjects.toStringHelper(this)
          .add("values", values)
          .add("fingerprint", fingerprint)
          .toString();
    }

    @Override
    public int hashCode() {
      return Objects.hash(values, fingerprint);
    }

    @Override
    public boolean equals(Object obj) {
      return obj == this
          || obj instanceof Metadata
          && Objects.equals(toPb(), ((Metadata) obj).toPb());
    }

    com.google.api.services.compute.model.Metadata toPb() {
      com.google.api.services.compute.model.Metadata metadataPb =
          new com.google.api.services.compute.model.Metadata();
      metadataPb.setFingerprint(fingerprint);
      List<com.google.api.services.compute.model.Metadata.Items> itemsPb =
          Lists.newArrayListWithCapacity(values.size());
      for (Map.Entry<String, String> entry : values.entrySet()) {
        itemsPb.add(new com.google.api.services.compute.model.Metadata.Items()
            .setKey(entry.getKey()).setValue(entry.getValue()));
      }
      metadataPb.setItems(itemsPb);
      metadataPb.setFingerprint(fingerprint);
      return metadataPb;
    }

    /**
     * Returns a builder for a {@code Metadata} object.
     */
    public static Builder builder() {
      return new Builder();
    }

    /**
     * Returns a {@code Metadata} object given the the metadata as a map. The total size of all keys
     * and values must be less than 512 KB. Keys must conform to the following regexp:
     * {@code [a-zA-Z0-9-_]+}, and be less than 128 bytes in length. This is reflected as part of a
     * URL in the metadata server. Additionally, to avoid ambiguity, keys must not conflict with any
     * other metadata keys for the project. Values must be less than or equal to 32768 bytes.
     */
    public static Metadata of(Map<String, String> values) {
      return builder().values(values).build();
    }

    static Metadata fromPb(com.google.api.services.compute.model.Metadata metadataPb) {
      Builder builder = builder();
      if (metadataPb.getItems() != null) {
        Map<String, String> metadataValues =
            Maps.newHashMapWithExpectedSize(metadataPb.getItems().size());
        for (com.google.api.services.compute.model.Metadata.Items item : metadataPb.getItems()) {
          metadataValues.put(item.getKey(), item.getValue());
        }
        builder.values(metadataValues);
      }
      return builder.fingerprint(metadataPb.getFingerprint()).build();
    }
  }

  /**
   * A service account, with its specified scopes, authorized for this instance.
   *
   * @see <a href="https://cloud.google.com/compute/docs/authentication">Authenticating from Google
   *     Compute Engine</a>
   */
  public static final class ServiceAccount implements Serializable {

    static final Function<com.google.api.services.compute.model.ServiceAccount, ServiceAccount>
        FROM_PB_FUNCTION =
        new Function<com.google.api.services.compute.model.ServiceAccount, ServiceAccount>() {
          @Override
          public ServiceAccount apply(com.google.api.services.compute.model.ServiceAccount pb) {
            return ServiceAccount.fromPb(pb);
          }
        };
    static final Function<ServiceAccount, com.google.api.services.compute.model.ServiceAccount>
        TO_PB_FUNCTION =
        new Function<ServiceAccount, com.google.api.services.compute.model.ServiceAccount>() {
          @Override
          public com.google.api.services.compute.model.ServiceAccount apply(
              ServiceAccount metadata) {
            return metadata.toPb();
          }
        };

    private static final long serialVersionUID = 4199610694227857331L;

    private final String email;
    private final List<String> scopes;

    private ServiceAccount(String email, List<String> scopes) {
      this.email = email;
      this.scopes = ImmutableList.copyOf(scopes);
    }

    /**
     * Returns the email address of the service account.
     */
    public String email() {
      return email;
    }

    /**
     * Returns the list of scopes to be made available for this service account.
     */
    public List<String> scopes() {
      return scopes;
    }

    @Override
    public String toString() {
      return MoreObjects.toStringHelper(this)
          .add("email", email)
          .add("scopes", scopes)
          .toString();
    }

    @Override
    public int hashCode() {
      return Objects.hash(email, scopes);
    }

    @Override
    public boolean equals(Object obj) {
      return obj == this
          || obj instanceof ServiceAccount
          && Objects.equals(toPb(), ((ServiceAccount) obj).toPb());
    }

    com.google.api.services.compute.model.ServiceAccount toPb() {
      com.google.api.services.compute.model.ServiceAccount serviceAccountPb =
          new com.google.api.services.compute.model.ServiceAccount();
      serviceAccountPb.setEmail(email);
      serviceAccountPb.setScopes(scopes);
      return serviceAccountPb;
    }

    /**
     * Returns a {@code ServiceAccount} object for the provided email and scopes.
     */
    public static ServiceAccount of(String email, List<String> scopes) {
      return new ServiceAccount(email, scopes);
    }

    /**
     * Returns a {@code ServiceAccount} object for the provided email and scopes.
     */
    public static ServiceAccount of(String email, String... scopes) {
      return of(email, Arrays.asList(scopes));
    }

    static ServiceAccount fromPb(com.google.api.services.compute.model.ServiceAccount accountPb) {
      return new ServiceAccount(accountPb.getEmail(), accountPb.getScopes());
    }
  }

  /**
   * A Google Compute Engine instance scheduling options. When there are system events that might
   * cause your instances to be disrupted, Google Compute Engine automatically manages the
   * scheduling decisions for your instances. Use {@code SchedulingOptions.preemptible()} to create
   * a preemptible instance. Use {@code SchedulingOptions.standard()} to configure scheduling
   * options for a standard instance.
   *
   * @see <a href="https://cloud.google.com/compute/docs/instances/setting-instance-scheduling-options">
   *     Setting Instance Scheduling Options</a>
   */
  public static final class SchedulingOptions implements Serializable {

    private static final long serialVersionUID = 4199610694227857331L;

    private final boolean automaticRestart;
    private final Maintenance maintenance;
    private final boolean isPreemptible;

    /**
     * Defines the maintenance behavior for this instance.
     */
    public enum Maintenance {
      /**
       * The default behavior for standard instances.
       */
      MIGRATE,

      /**
       * The default and only possible behavior for preemptible instances.
       */
      TERMINATE
    }

    private SchedulingOptions(Boolean automaticRestart, Maintenance maintenance,
        Boolean isPreemptible) {
      this.automaticRestart = automaticRestart;
      this.maintenance = maintenance;
      this.isPreemptible = isPreemptible;
    }

    /**
     * Returns whether the instance should be automatically restarted if it is terminated by Compute
     * Engine (not terminated by a user).
     */
    public Boolean automaticRestart() {
      return automaticRestart;
    }

    /**
     * Returns the maintenance behavior for the instance.
     */
    public Maintenance maintenance() {
      return maintenance;
    }

    /**
     * Returns {@code true} if the instance is preemptible, {@code false} otherwhise.
     *
     * @see <a href="https://cloud.google.com/compute/docs/instances/preemptible">Preemptible
     *     Instance</a>
     */
    public boolean isPreemptible() {
      return isPreemptible;
    }

    @Override
    public String toString() {
      return MoreObjects.toStringHelper(this)
          .add("automaticRestart", automaticRestart)
          .add("maintenance", maintenance)
          .add("isPreemptible", isPreemptible)
          .toString();
    }

    @Override
    public int hashCode() {
      return Objects.hash(automaticRestart, maintenance, isPreemptible);
    }

    @Override
    public boolean equals(Object obj) {
      return obj == this
          || obj instanceof SchedulingOptions
          && Objects.equals(toPb(), ((SchedulingOptions) obj).toPb());
    }

    com.google.api.services.compute.model.Scheduling toPb() {
      com.google.api.services.compute.model.Scheduling schedulingPb =
          new com.google.api.services.compute.model.Scheduling();
      schedulingPb.setAutomaticRestart(automaticRestart);
      schedulingPb.setPreemptible(isPreemptible);
      if (maintenance != null) {
        schedulingPb.setOnHostMaintenance(maintenance.name());
      }
      return schedulingPb;
    }

    /**
     * Returns a {@code SchedulingOptions} object for a preemptible instance.
     *
     * @see <a href="https://cloud.google.com/compute/docs/instances/preemptible">Preemptible
     *     Instance</a>
     */
    public static SchedulingOptions preemptible() {
      return new SchedulingOptions(false, Maintenance.TERMINATE, true);
    }

    /**
     * Returns a {@code SchedulingOptions} object for a standard instance.
     *
     * @param automaticRestart specifies whether the instance should be automatically restarted if
     *     it is terminated by Compute Engine (not terminated by a user)
     * @param maintenance defines the maintenance behavior for the instance
     */
    public static SchedulingOptions standard(boolean automaticRestart, Maintenance maintenance) {
      return new SchedulingOptions(automaticRestart, maintenance, false);
    }

    static SchedulingOptions fromPb(com.google.api.services.compute.model.Scheduling schedPb) {
      Maintenance maintenance = null;
      if (schedPb.getOnHostMaintenance() != null) {
        maintenance = Maintenance.valueOf(schedPb.getOnHostMaintenance());
      }
      return new SchedulingOptions(schedPb.getAutomaticRestart(), maintenance,
          schedPb.getPreemptible());
    }
  }

  /**
   * A builder for {@code InstanceInfo} objects.
   */
  public abstract static class Builder {

    abstract Builder id(String id);

    /**
     * Sets the identity of the virtual machine instance.
     */
    public abstract Builder instanceId(InstanceId instanceId);

    abstract Builder creationTimestamp(Long creationTimestamp);

    /**
     * Sets an optional description of this Google Compute Engine instance.
     */
    public abstract Builder description(String description);

    abstract Builder status(Status status);

    abstract Builder statusMessage(String statusMessage);

    /**
     * Sets the tags to apply to this instance. Tags are used to identify valid sources or targets
     * for network firewalls.
     */
    public abstract Builder tags(Tags tags);

    /**
     * Sets the machine type identity.
     */
    public abstract Builder machineType(MachineTypeId machineType);

    /**
     * Sets whether to allow this instance to send and receive packets with non-matching destination
     * or source IPs. This is required if you plan to use this instance to forward routes.
     *
     * @see <a href="https://cloud.google.com/compute/docs/networking#canipforward">Enabling IP
     *     Forwarding</a>
     */
    public abstract Builder canIpForward(Boolean canIpForward);

    /**
     * Sets a list of network interfaces. This specifies how this instance is configured to interact
     * with other network services, such as connecting to the internet. At the moment, instances
     * only support one network interface.
     */
    public abstract Builder networkInterfaces(List<NetworkInterface> networkInterfaces);

    /**
     * Sets a list of network interfaces. This specifies how this instance is configured to interact
     * with other network services, such as connecting to the internet. At the moment, instances
     * only support one network interface.
     */
    public abstract Builder networkInterfaces(NetworkInterface... networkInterfaces);

    /**
     * Sets a list of disks to attach to the instance. One boot disk must be provided (i.e. an
     * attached disk such that {@link AttachedDisk.AttachedDiskConfiguration#boot()} returns
     * {@code true}).
     */
    public abstract Builder attachedDisks(List<AttachedDisk> attachedDisks);

    /**
     * Sets a list of disks to attach to the instance. One boot disk must be provided.
     */
    public abstract Builder attachedDisks(AttachedDisk... attachedDisks);

    /**
     * Sets the instance metadata.
     */
    public abstract Builder metadata(Metadata metadata);

    /**
     * Sets a list of service accounts, with their specified scopes, authorized for this instance.
     * Service accounts generate access tokens that can be accessed through the metadata server and
     * used to authenticate applications on the instance.
     *
     * @see <a href="https://cloud.google.com/compute/docs/authentication">Authenticating from
     *     Google Compute Engine</a>
     */
    public abstract Builder serviceAccounts(List<ServiceAccount> serviceAccounts);

    /**
     * Sets the scheduling options for the instance.
     */
    public abstract Builder schedulingOptions(SchedulingOptions schedulingOptions);

    abstract Builder cpuPlatform(String cpuPlatform);

    /**
     * Creates an {@code InstanceInfo} object.
     */
    public abstract InstanceInfo build();
  }

  public static final class BuilderImpl extends Builder {

    private String id;
    private InstanceId instanceId;
    private Long creationTimestamp;
    private String description;
    private Status status;
    private String statusMessage;
    private Tags tags;
    private MachineTypeId machineType;
    private Boolean canIpForward;
    private List<NetworkInterface> networkInterfaces;
    private List<AttachedDisk> attachedDisks;
    private Metadata metadata;
    private List<ServiceAccount> serviceAccounts;
    private SchedulingOptions schedulingOptions;
    private String cpuPlatform;

    BuilderImpl(InstanceId instanceId) {
      this.instanceId = checkNotNull(instanceId);
    }

    BuilderImpl(InstanceInfo instance) {
      this.id = instance.id;
      this.instanceId = instance.instanceId;
      this.creationTimestamp = instance.creationTimestamp;
      this.description = instance.description;
      this.status = instance.status;
      this.statusMessage = instance.statusMessage;
      this.tags = instance.tags;
      this.machineType = instance.machineType;
      this.canIpForward = instance.canIpForward;
      this.networkInterfaces = instance.networkInterfaces;
      this.attachedDisks = instance.attachedDisks;
      this.metadata = instance.metadata;
      this.serviceAccounts = instance.serviceAccounts;
      this.schedulingOptions = instance.schedulingOptions;
      this.cpuPlatform = instance.cpuPlatform;
    }

    BuilderImpl(Instance instancePb) {
      if (instancePb.getId() != null) {
        this.id = instancePb.getId().toString();
      }
      this.instanceId = InstanceId.fromUrl(instancePb.getSelfLink());
      if (instancePb.getCreationTimestamp() != null) {
        this.creationTimestamp = TIMESTAMP_FORMATTER.parseMillis(instancePb.getCreationTimestamp());
      }
      this.description = instancePb.getDescription();
      if (instancePb.getStatus() != null) {
        this.status = Status.valueOf(instancePb.getStatus());
      }
      this.statusMessage = instancePb.getStatusMessage();
      if (instancePb.getTags() != null) {
        this.tags = Tags.fromPb(instancePb.getTags());
      }
      if (instancePb.getMachineType() != null) {
        this.machineType = MachineTypeId.fromUrl(instancePb.getMachineType());
      }
      this.canIpForward = instancePb.getCanIpForward();
      if (instancePb.getNetworkInterfaces() != null) {
        this.networkInterfaces =
            Lists.transform(instancePb.getNetworkInterfaces(), NetworkInterface.FROM_PB_FUNCTION);
      }
      if (instancePb.getDisks() != null) {
        this.attachedDisks = Lists.transform(instancePb.getDisks(), AttachedDisk.FROM_PB_FUNCTION);
      }
      if (instancePb.getMetadata() != null) {
        this.metadata = Metadata.fromPb(instancePb.getMetadata());
      }
      if (instancePb.getServiceAccounts() != null) {
        this.serviceAccounts =
            Lists.transform(instancePb.getServiceAccounts(), ServiceAccount.FROM_PB_FUNCTION);
      }
      if (instancePb.getScheduling() != null) {
        this.schedulingOptions = SchedulingOptions.fromPb(instancePb.getScheduling());
      }
      this.cpuPlatform = instancePb.getCpuPlatform();
    }

    @Override
    Builder id(String id) {
      this.id = id;
      return this;
    }

    @Override
    public Builder instanceId(InstanceId instanceId) {
      this.instanceId = checkNotNull(instanceId);
      return this;
    }

    @Override
    Builder creationTimestamp(Long creationTimestamp) {
      this.creationTimestamp = creationTimestamp;
      return this;
    }

    @Override
    public Builder description(String description) {
      this.description = description;
      return this;
    }

    @Override
    Builder status(Status status) {
      this.status = status;
      return this;
    }

    @Override
    Builder statusMessage(String statusMessage) {
      this.statusMessage = statusMessage;
      return this;
    }

    @Override
    public Builder tags(Tags tags) {
      this.tags = tags;
      return this;
    }

    @Override
    public Builder machineType(MachineTypeId machineType) {
      this.machineType = checkNotNull(machineType);
      return this;
    }

    @Override
    public Builder canIpForward(Boolean canIpForward) {
      this.canIpForward = canIpForward;
      return this;
    }

    @Override
    public Builder networkInterfaces(List<NetworkInterface> networkInterfaces) {
      this.networkInterfaces = ImmutableList.copyOf(checkNotNull(networkInterfaces));
      return this;
    }

    @Override
    public Builder networkInterfaces(NetworkInterface... networkInterfaces) {
      this.networkInterfaces = Arrays.asList(networkInterfaces);
      return this;
    }

    @Override
    public Builder attachedDisks(List<AttachedDisk> attachedDisks) {
      this.attachedDisks = ImmutableList.copyOf(checkNotNull(attachedDisks));
      return this;
    }

    @Override
    public Builder attachedDisks(AttachedDisk... attachedDisks) {
      this.attachedDisks = Arrays.asList(attachedDisks);
      return this;
    }

    @Override
    public Builder metadata(Metadata metadata) {
      this.metadata = metadata;
      return this;
    }

    @Override
    public Builder serviceAccounts(List<ServiceAccount> serviceAccounts) {
      this.serviceAccounts = ImmutableList.copyOf(checkNotNull(serviceAccounts));
      return this;
    }

    @Override
    public Builder schedulingOptions(SchedulingOptions schedulingOptions) {
      this.schedulingOptions = schedulingOptions;
      return this;
    }

    @Override
    Builder cpuPlatform(String cpuPlatform) {
      this.cpuPlatform = cpuPlatform;
      return this;
    }

    @Override
    public InstanceInfo build() {
      checkNotNull(attachedDisks);
      checkNotNull(networkInterfaces);
      return new InstanceInfo(this);
    }
  }

  InstanceInfo(BuilderImpl builder) {
    this.id = builder.id;
    this.instanceId = builder.instanceId;
    this.creationTimestamp = builder.creationTimestamp;
    this.description = builder.description;
    this.status = builder.status;
    this.statusMessage = builder.statusMessage;
    this.tags = builder.tags;
    this.machineType = builder.machineType;
    this.canIpForward = builder.canIpForward;
    this.networkInterfaces = builder.networkInterfaces;
    this.attachedDisks = builder.attachedDisks;
    this.metadata = builder.metadata;
    this.serviceAccounts = builder.serviceAccounts;
    this.schedulingOptions = builder.schedulingOptions;
    this.cpuPlatform = builder.cpuPlatform;
  }

  /**
   * Returns the unique identifier for the instance; defined by the service.
   */
  public String id() {
    return id;
  }

  /**
   * Returns the instance identity.
   */
  public InstanceId instanceId() {
    return instanceId;
  }

  /**
   * Returns the creation timestamp in milliseconds since epoch.
   */
  public Long creationTimestamp() {
    return creationTimestamp;
  }

  /**
   * Returns a textual description of the instance.
   */
  public String description() {
    return description;
  }

  /**
   * Returns the status of the instance.
   */
  public Status status() {
    return status;
  }

  /**
   * Returns an optional, human-readable explanation of the status.
   */
  public String statusMessage() {
    return statusMessage;
  }

  /**
   * Returns the tags of this instance. Tags are used to identify valid sources or targets for
   * network firewalls.
   */
  public Tags tags() {
    return tags;
  }

  /**
   * Returns the machine type identity.
   */
  public MachineTypeId machineType() {
    return machineType;
  }

  /**
   * Returns whether to allow this instance to send and receive packets with non-matching
   * destination or source IPs. This is required if you plan to use this instance to forward routes.
   *
   * @see <a href="https://cloud.google.com/compute/docs/networking#canipforward">Enabling IP
   *     Forwarding</a>
   */
  public Boolean canIpForward() {
    return canIpForward;
  }

  /**
   * Returns a list of network interfaces. This specifies how this instance is configured to
   * interact with other network services, such as connecting to the internet.
   */
  public List<NetworkInterface> networkInterfaces() {
    return networkInterfaces;
  }

  /**
   * Returns a list of disks attached to the instance.
   */
  public List<AttachedDisk> attachedDisks() {
    return attachedDisks;
  }

  /**
   * Returns the instance metadata.
   */
  public Metadata metadata() {
    return metadata;
  }

  /**
   * Returns a list of service accounts, with their specified scopes, authorized for this instance.
   * Service accounts generate access tokens that can be accessed through the metadata server and
   * used to authenticate applications on the instance.
   *
   * @see <a href="https://cloud.google.com/compute/docs/authentication">Authenticating from
   *     Google Compute Engine</a>
   */
  public List<ServiceAccount> serviceAccounts() {
    return serviceAccounts;
  }

  /**
   * Returns the scheduling options for the instance.
   */
  public SchedulingOptions schedulingOptions() {
    return schedulingOptions;
  }

  /**
   * Returns the CPU platform used by this instance.
   */
  public String cpuPlatform() {
    return cpuPlatform;
  }

  /**
   * Returns a builder for the current instance.
   */
  public Builder toBuilder() {
    return new BuilderImpl(this);
  }

  @Override
  public String toString() {
    return MoreObjects.toStringHelper(this)
        .add("id", id)
        .add("instanceId", instanceId)
        .add("creationTimestamp", creationTimestamp)
        .add("description", description)
        .add("status", status)
        .add("statusMessage", statusMessage)
        .add("tags", tags)
        .add("machineType", machineType)
        .add("canIpForward", canIpForward)
        .add("networkInterfaces", networkInterfaces)
        .add("attachedDisks", attachedDisks)
        .add("metadata", metadata)
        .add("serviceAccounts", serviceAccounts)
        .add("schedulingOptions", schedulingOptions)
        .add("cpuPlatform", cpuPlatform)
        .toString();
  }

  @Override
  public int hashCode() {
    return Objects.hash(id, instanceId, creationTimestamp, description, status, statusMessage, tags,
        machineType, canIpForward, networkInterfaces, attachedDisks, metadata, serviceAccounts,
        schedulingOptions, cpuPlatform);
  }

  @Override
  public boolean equals(Object obj) {
    return obj instanceof InstanceInfo
        && Objects.equals(toPb(), ((InstanceInfo) obj).toPb());
  }

  InstanceInfo setProjectId(final String projectId) {
    Builder builder = toBuilder();
    builder.networkInterfaces(Lists.transform(networkInterfaces,
        new Function<NetworkInterface, NetworkInterface>() {
          @Override
          public NetworkInterface apply(NetworkInterface networkInterface) {
            return networkInterface.setProjectId(projectId);
          }
        }));
    builder.attachedDisks(Lists.transform(attachedDisks,
        new Function<AttachedDisk, AttachedDisk>() {
          @Override
          public AttachedDisk apply(AttachedDisk attachedDisk) {
            return attachedDisk.setProjectId(projectId);
          }
        }));
    return builder.instanceId(instanceId.setProjectId(projectId))
        .machineType(machineType.setProjectId(projectId))
        .build();
  }

  Instance toPb() {
    Instance instancePb = new Instance();
    if (id != null) {
      instancePb.setId(new BigInteger(id));
    }
    if (creationTimestamp != null) {
      instancePb.setCreationTimestamp(TIMESTAMP_FORMATTER.print(creationTimestamp));
    }
    instancePb.setName(instanceId.instance());
    instancePb.setDescription(description);
    instancePb.setSelfLink(instanceId.selfLink());
    instancePb.setZone(instanceId.zoneId().selfLink());
    if (status != null) {
      instancePb.setStatus(status.name());
    }
    instancePb.setStatusMessage(statusMessage);
    if (tags != null) {
      instancePb.setTags(tags.toPb());
    }
    if (machineType != null) {
      instancePb.setMachineType(machineType.selfLink());
    }
    instancePb.setCanIpForward(canIpForward);
    if (networkInterfaces != null) {
      instancePb.setNetworkInterfaces(
          Lists.transform(networkInterfaces, NetworkInterface.TO_PB_FUNCTION));
    }
    if (attachedDisks != null) {
      instancePb.setDisks(Lists.transform(attachedDisks, AttachedDisk.TO_PB_FUNCTION));
    }
    if (metadata != null) {
      instancePb.setMetadata(metadata.toPb());
    }
    if (serviceAccounts != null) {
      instancePb.setServiceAccounts(
          Lists.transform(serviceAccounts, ServiceAccount.TO_PB_FUNCTION));
    }
    if (schedulingOptions != null) {
      instancePb.setScheduling(schedulingOptions.toPb());
    }
    instancePb.setCpuPlatform(cpuPlatform);
    return instancePb;
  }

  /**
   * Returns a builder for an {@code InstanceInfo} object given the instance identity and the
   * machine type.
   */
  public static Builder builder(InstanceId instanceId, MachineTypeId machineType) {
    return new BuilderImpl(instanceId).machineType(machineType);
  }

  /**
   * Returns an {@code InstanceInfo} object given the instance identity, the machine type, a disk
   * to attach to the instance and a network interface. {@code disk} must be a boot disk (i.e.
   * {@link AttachedDisk.AttachedDiskConfiguration#boot()} returns {@code true}).
   */
  public static InstanceInfo of(InstanceId instanceId, MachineTypeId machineType, AttachedDisk disk,
      NetworkInterface networkInterface) {
    return builder(instanceId, machineType)
        .attachedDisks(ImmutableList.of(disk))
        .networkInterfaces(ImmutableList.of(networkInterface))
        .build();
  }

  static InstanceInfo fromPb(Instance instancePb) {
    return new BuilderImpl(instancePb).build();
  }
}
