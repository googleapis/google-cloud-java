/*
 * Copyright 2016 Google LLC
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

package com.google.cloud.compute.deprecated;

import static com.google.common.base.Preconditions.checkNotNull;

import com.google.api.services.compute.model.AttachedDiskInitializeParams;
import com.google.common.base.Function;
import com.google.common.base.MoreObjects;
import com.google.common.collect.Lists;
import java.io.Serializable;
import java.util.List;
import java.util.Objects;

/**
 * A disk attached to a Google Compute Engine instance. To create a new disk to attach when an image
 * is being created use {@link CreateDiskConfiguration}. To attach an existing persistent disk use
 * {@link PersistentDiskConfiguration}. To attach a scratch disk use {@link
 * ScratchDiskConfiguration}.
 */
public class AttachedDisk implements Serializable {

  static final Function<com.google.api.services.compute.model.AttachedDisk, AttachedDisk>
      FROM_PB_FUNCTION =
          new Function<com.google.api.services.compute.model.AttachedDisk, AttachedDisk>() {
            @Override
            public AttachedDisk apply(com.google.api.services.compute.model.AttachedDisk pb) {
              return AttachedDisk.fromPb(pb);
            }
          };
  static final Function<AttachedDisk, com.google.api.services.compute.model.AttachedDisk>
      TO_PB_FUNCTION =
          new Function<AttachedDisk, com.google.api.services.compute.model.AttachedDisk>() {
            @Override
            public com.google.api.services.compute.model.AttachedDisk apply(
                AttachedDisk attachedDisk) {
              return attachedDisk.toPb();
            }
          };
  private static final long serialVersionUID = 2969789134157943798L;

  private final String deviceName;
  private final Integer index;
  private final AttachedDiskConfiguration configuration;
  private final List<LicenseId> licenses;

  /**
   * Base class for {@code AttachedDisk} configuration. Use {@link PersistentDiskConfiguration} to
   * attach an existing persistent disk. Use {@link CreateDiskConfiguration} to create a boot
   * persistent disk to attach to the instance. Use {@link ScratchDiskConfiguration} to attach a
   * scratch disk.
   */
  public abstract static class AttachedDiskConfiguration implements Serializable {

    private static final long serialVersionUID = 8813134841283115565L;

    private final Type type;
    private final InterfaceType interfaceType;
    private final Boolean boot;
    private final Boolean autoDelete;

    /** Specifies the type of the attached disk. */
    public enum Type {
      /**
       * A persistent disk attached to a VM instance. Such an attached disk must already exist or
       * can be created along with the instance by using {@link CreateDiskConfiguration}. A
       * persistent disk can be attached to other VM instances.
       */
      PERSISTENT,

      /**
       * A scratch disk is created with the VM instance it is attached to. Scratch disks are only
       * available to their VM instance.
       */
      SCRATCH
    }

    /**
     * Specifies the disk interface to use for attaching this disk, which is either {@code SCSI} or
     * {@code NVME}. Persistent disks must always use {@code SCSI}. Scratch SSDs can use either
     * {@code NVME} or {@code SCSI}.
     */
    public enum InterfaceType {
      SCSI,
      NVME
    }

    AttachedDiskConfiguration(
        Type type, InterfaceType interfaceType, Boolean boot, Boolean autoDelete) {
      this.type = checkNotNull(type);
      this.interfaceType = interfaceType;
      this.boot = boot;
      this.autoDelete = autoDelete;
    }

    /** Returns the type of the attached disk. */
    public Type getType() {
      return type;
    }

    /**
     * Returns the interface to use to attach the disk. If not specified, {@link InterfaceType#SCSI}
     * is used.
     */
    public InterfaceType getInterfaceType() {
      return interfaceType;
    }

    /**
     * Returns whether to use the attached disk as a boot disk. If {@code true} the virtual machine
     * will use the first partition of the disk for its root filesystem. If not specified, the disk
     * is not used as a boot disk.
     */
    public Boolean boot() {
      return boot;
    }

    /**
     * Returns whether the disk should auto-delete when the instance to which it's attached is
     * deleted. If not specified, the disk is not deleted automatically.
     */
    public Boolean autoDelete() {
      return autoDelete;
    }

    MoreObjects.ToStringHelper toStringHelper() {
      return MoreObjects.toStringHelper(this)
          .add("type", type)
          .add("interfaceType", interfaceType)
          .add("boot", boot)
          .add("autoDelete", autoDelete);
    }

    @Override
    public String toString() {
      return toStringHelper().toString();
    }

    final int baseHashCode() {
      return Objects.hash(type, interfaceType);
    }

    final boolean baseEquals(AttachedDiskConfiguration diskConfiguration) {
      return Objects.equals(toPb(), diskConfiguration.toPb());
    }

    abstract AttachedDiskConfiguration setProjectId(String projectId);

    com.google.api.services.compute.model.AttachedDisk toPb() {
      com.google.api.services.compute.model.AttachedDisk attachedDiskPb =
          new com.google.api.services.compute.model.AttachedDisk();
      attachedDiskPb.setType(type.name());
      if (interfaceType != null) {
        attachedDiskPb.setInterface(interfaceType.name());
      }
      attachedDiskPb.setBoot(boot);
      attachedDiskPb.setAutoDelete(autoDelete);
      return attachedDiskPb;
    }

    @SuppressWarnings("unchecked")
    static <T extends AttachedDiskConfiguration> T fromPb(
        com.google.api.services.compute.model.AttachedDisk diskPb) {
      switch (Type.valueOf(diskPb.getType())) {
        case PERSISTENT:
          if (diskPb.getSource() == null) {
            return (T) CreateDiskConfiguration.fromPb(diskPb);
          } else {
            return (T) PersistentDiskConfiguration.fromPb(diskPb);
          }
        case SCRATCH:
          return (T) ScratchDiskConfiguration.fromPb(diskPb);
        default:
          // should be unreachable
          throw new IllegalArgumentException("Unrecognized attached disk type");
      }
    }
  }

  /** An attached disk configuration for existing persistent disks. */
  public static final class PersistentDiskConfiguration extends AttachedDiskConfiguration {

    private static final long serialVersionUID = 6367613188140104726L;

    private final DiskId sourceDisk;
    private final Mode mode;

    /** Specifies the mode in which to attach the disk. */
    public enum Mode {
      /** The instance can both read and write to the disk. */
      READ_WRITE,

      /** The instance is only allowed to read the disk. */
      READ_ONLY
    }

    /** A builder for {@code PersistentDiskConfiguration} objects. */
    public static final class Builder {

      private DiskId sourceDisk;
      private Mode mode;
      private Boolean boot;
      private Boolean autoDelete;

      private Builder(DiskId sourceDisk) {
        this.sourceDisk = checkNotNull(sourceDisk);
      }

      private Builder(PersistentDiskConfiguration configuration) {
        sourceDisk = configuration.sourceDisk;
        mode = configuration.mode;
        boot = configuration.boot();
        autoDelete = configuration.autoDelete();
      }

      /** Sets the identity of the persistent disk to be attached. */
      public Builder setSourceDisk(DiskId sourceDisk) {
        this.sourceDisk = checkNotNull(sourceDisk);
        return this;
      }

      /**
       * Sets the mode in which to attach this disk. If not specified, the disk is attached in
       * {@link Mode#READ_WRITE} mode.
       */
      public Builder setMode(Mode mode) {
        this.mode = mode;
        return this;
      }

      /**
       * Sets whether to use the attached disk as a boot disk. If {@code true} the virtual machine
       * instance will use the first partition of the disk for its root filesystem. If not
       * specified, the isk is not used as a boot disk.
       */
      public Builder setBoot(boolean boot) {
        this.boot = boot;
        return this;
      }

      /**
       * Sets whether the disk should auto-delete when the instance to which it's attached is
       * deleted. If not specified, the disk is not deleted automatically.
       */
      public Builder setAutoDelete(boolean autoDelete) {
        this.autoDelete = autoDelete;
        return this;
      }

      /** Creates a {@code PersistentDiskConfiguration} object. */
      public PersistentDiskConfiguration build() {
        return new PersistentDiskConfiguration(this);
      }
    }

    private PersistentDiskConfiguration(Builder builder) {
      super(Type.PERSISTENT, null, builder.boot, builder.autoDelete);
      this.sourceDisk = builder.sourceDisk;
      this.mode = builder.mode;
    }

    /** Returns the identity of the persistent disk to be attached. */
    public DiskId getSourceDisk() {
      return sourceDisk;
    }

    /**
     * Returns the mode in which to attach this disk. If not specified, the disk is attached in
     * {@link Mode#READ_WRITE} mode.
     */
    public Mode getMode() {
      return mode;
    }

    /** Returns a builder for the current configuration. */
    public Builder toBuilder() {
      return new Builder(this);
    }

    @Override
    MoreObjects.ToStringHelper toStringHelper() {
      return super.toStringHelper().add("sourceDisk", sourceDisk).add("mode", mode);
    }

    @Override
    public int hashCode() {
      return Objects.hash(baseHashCode(), sourceDisk, mode);
    }

    @Override
    public boolean equals(Object obj) {
      return obj == this
          || obj != null
              && obj.getClass().equals(PersistentDiskConfiguration.class)
              && baseEquals((PersistentDiskConfiguration) obj);
    }

    @Override
    PersistentDiskConfiguration setProjectId(String projectId) {
      if (sourceDisk.getProject() != null) {
        return this;
      }
      return toBuilder().setSourceDisk(sourceDisk.setProjectId(projectId)).build();
    }

    @Override
    com.google.api.services.compute.model.AttachedDisk toPb() {
      com.google.api.services.compute.model.AttachedDisk attachedDiskPb = super.toPb();
      attachedDiskPb.setSource(sourceDisk.getSelfLink());
      attachedDiskPb.setMode(mode != null ? mode.toString() : null);
      return attachedDiskPb;
    }

    /**
     * Returns a builder for a {@code PersistentDiskConfiguration} object given the identity of the
     * persistent disk to attach.
     */
    public static Builder newBuilder(DiskId sourceDisk) {
      return new Builder(sourceDisk);
    }

    /**
     * Returns a {@code PersistentDiskConfiguration} object given the identity of the persistent
     * disk to attach.
     */
    public static PersistentDiskConfiguration of(DiskId sourceDisk) {
      return newBuilder(sourceDisk).build();
    }

    @SuppressWarnings("unchecked")
    static PersistentDiskConfiguration fromPb(
        com.google.api.services.compute.model.AttachedDisk diskPb) {
      Builder builder = new Builder(DiskId.fromUrl(diskPb.getSource()));
      if (diskPb.getMode() != null) {
        builder.setMode(Mode.valueOf(diskPb.getMode()));
      }
      if (diskPb.getBoot() != null) {
        builder.setBoot(diskPb.getBoot());
      }
      if (diskPb.getAutoDelete() != null) {
        builder.setAutoDelete(diskPb.getAutoDelete());
      }
      return builder.build();
    }
  }

  /**
   * An attached disk configuration for bootable persistent disks that must be created with the
   * instance they are attached to. Attached disks that use this configuration can only be attached
   * to an instance upon creation. A {@code CreateDiskConfiguration} object is never returned by the
   * service: after the instance is created the corresponding attached disk will be returned with a
   * {@link PersistentDiskConfiguration}.
   */
  public static final class CreateDiskConfiguration extends AttachedDiskConfiguration {

    private static final long serialVersionUID = 961995522284348824L;

    private final String diskName;
    private final DiskTypeId diskType;
    private final Long diskSizeGb;
    private final ImageId sourceImage;

    /** A builder for {@code CreateDiskConfiguration} objects. */
    public static final class Builder {

      private String diskName;
      private DiskTypeId diskType;
      private Long diskSizeGb;
      private ImageId sourceImage;
      private Boolean autoDelete;

      private Builder(ImageId sourceImage) {
        this.sourceImage = checkNotNull(sourceImage);
      }

      private Builder(CreateDiskConfiguration configuration) {
        this.diskName = configuration.diskName;
        this.diskType = configuration.diskType;
        this.diskSizeGb = configuration.diskSizeGb;
        this.sourceImage = configuration.sourceImage;
        this.autoDelete = configuration.autoDelete();
      }

      /**
       * Sets the name to be assigned to the disk. If not specified, the disk is given the
       * instance's name.
       */
      public Builder setDiskName(String diskName) {
        this.diskName = diskName;
        return this;
      }

      /** Sets the identity of the disk type. If not specified, {@code pd-standard} is used. */
      public Builder setDiskType(DiskTypeId diskType) {
        this.diskType = diskType;
        return this;
      }

      /**
       * Sets the size of the persistent disk, in GB. If not set the disk will have the size of the
       * source image. This value can be larger than the image's size. If the provided size is
       * smaller than the image's size, then instance creation will fail.
       */
      public Builder setDiskSizeGb(Long diskSizeGb) {
        this.diskSizeGb = diskSizeGb;
        return this;
      }

      /** Sets the identity of the source image used to create the disk. */
      public Builder setSourceImage(ImageId sourceImage) {
        this.sourceImage = checkNotNull(sourceImage);
        return this;
      }

      /**
       * Sets whether the disk should auto-delete when the instance to which it's attached is
       * deleted. If not specified, the disk is not deleted automatically.
       */
      public Builder setAutoDelete(Boolean autoDelete) {
        this.autoDelete = autoDelete;
        return this;
      }

      /** Creates a {@code CreateDiskConfiguration} object. */
      public CreateDiskConfiguration build() {
        return new CreateDiskConfiguration(this);
      }
    }

    private CreateDiskConfiguration(Builder builder) {
      super(Type.PERSISTENT, null, true, builder.autoDelete);
      this.diskName = builder.diskName;
      this.diskType = builder.diskType;
      this.diskSizeGb = builder.diskSizeGb;
      this.sourceImage = builder.sourceImage;
    }

    /**
     * Returns the name to be assigned to the disk. If not specified, the disk is given the
     * instance's name.
     */
    public String getDiskName() {
      return diskName;
    }

    /** Returns the identity of the disk type. If not specified, {@code pd-standard} is used. */
    public DiskTypeId getDiskType() {
      return diskType;
    }

    /**
     * Returns the size of the persistent disk, in GB. If not set the disk will have the size of the
     * source image. This value can be larger than the image's size. If the provided size is smaller
     * than the image's size then instance creation will fail.
     */
    public Long getDiskSizeGb() {
      return diskSizeGb;
    }

    /** Returns the identity of the source image used to create the disk. */
    public ImageId getSourceImage() {
      return sourceImage;
    }

    /** Returns a builder for the current configuration. */
    public Builder toBuilder() {
      return new Builder(this);
    }

    @Override
    MoreObjects.ToStringHelper toStringHelper() {
      return super.toStringHelper()
          .add("diskName", diskName)
          .add("diskType", diskType)
          .add("diskSizeGb", diskSizeGb)
          .add("sourceImage", sourceImage);
    }

    @Override
    public int hashCode() {
      return Objects.hash(baseHashCode(), diskName, diskType, diskSizeGb, sourceImage);
    }

    @Override
    public boolean equals(Object obj) {
      return obj == this
          || obj != null
              && obj.getClass().equals(CreateDiskConfiguration.class)
              && baseEquals((CreateDiskConfiguration) obj);
    }

    @Override
    CreateDiskConfiguration setProjectId(String projectId) {
      Builder builder = toBuilder();
      if (builder.diskType != null) {
        builder.setDiskType(diskType.setProjectId(projectId));
      }
      if (builder.sourceImage != null) {
        builder.setSourceImage(sourceImage.setProjectId(projectId));
      }
      return builder.build();
    }

    @Override
    com.google.api.services.compute.model.AttachedDisk toPb() {
      AttachedDiskInitializeParams initializeParamsPb = new AttachedDiskInitializeParams();
      initializeParamsPb.setDiskName(diskName);
      initializeParamsPb.setDiskSizeGb(diskSizeGb);
      initializeParamsPb.setSourceImage(sourceImage.getSelfLink());
      if (diskType != null) {
        initializeParamsPb.setDiskType(diskType.getSelfLink());
      }
      com.google.api.services.compute.model.AttachedDisk attachedDiskPb = super.toPb();
      attachedDiskPb.setInitializeParams(initializeParamsPb);
      return attachedDiskPb;
    }

    /**
     * Returns a builder for a {@code CreateDiskConfiguration} object given the source image that
     * will be used to create the disk.
     */
    public static Builder newBuilder(ImageId sourceImage) {
      return new Builder(sourceImage);
    }

    /**
     * Returns a {@code CreateDiskConfiguration} object given the source image that will be used to
     * create the disk.
     */
    public static CreateDiskConfiguration of(ImageId sourceImage) {
      return newBuilder(sourceImage).build();
    }

    @SuppressWarnings("unchecked")
    static CreateDiskConfiguration fromPb(
        com.google.api.services.compute.model.AttachedDisk diskPb) {
      AttachedDiskInitializeParams initializeParamsPb = diskPb.getInitializeParams();
      Builder builder = newBuilder(ImageId.fromUrl(initializeParamsPb.getSourceImage()));
      if (initializeParamsPb.getDiskType() != null) {
        builder.setDiskType(DiskTypeId.fromUrl(initializeParamsPb.getDiskType()));
      }
      builder.setDiskName(initializeParamsPb.getDiskName());
      builder.setDiskSizeGb(initializeParamsPb.getDiskSizeGb());
      builder.setAutoDelete(diskPb.getAutoDelete());
      if (initializeParamsPb.getDiskType() != null) {
        builder.setDiskType(DiskTypeId.fromUrl(initializeParamsPb.getDiskType()));
      }
      return builder.build();
    }
  }

  /**
   * An attached disk configuration for scratch disks. Attached disks that use this configuration
   * can only be attached to an instance upon creation.
   */
  public static final class ScratchDiskConfiguration extends AttachedDiskConfiguration {

    private static final long serialVersionUID = -8445453507234691254L;

    private final DiskTypeId diskType;

    /** A builder for {@code ScratchDiskConfiguration} objects. */
    public static final class Builder {

      private DiskTypeId diskType;
      private InterfaceType interfaceType;

      private Builder() {}

      private Builder(ScratchDiskConfiguration configuration) {
        this.diskType = configuration.diskType;
        this.interfaceType = configuration.getInterfaceType();
      }

      /** Sets the identity of the disk type for the scratch disk to attach. */
      public Builder setDiskType(DiskTypeId diskType) {
        this.diskType = diskType;
        return this;
      }

      /** Sets the interface type. If not specified, {@code SCSI} is used. */
      public Builder setInterfaceType(InterfaceType interfaceType) {
        this.interfaceType = interfaceType;
        return this;
      }

      /** Creates a {@code ScratchDiskConfiguration} object. */
      public ScratchDiskConfiguration build() {
        return new ScratchDiskConfiguration(this);
      }
    }

    private ScratchDiskConfiguration(Builder builder) {
      super(Type.SCRATCH, builder.interfaceType, false, true);
      this.diskType = builder.diskType;
    }

    /** Returns the identity of the disk type for the scratch disk to attach. */
    public DiskTypeId getDiskType() {
      return diskType;
    }

    /** Returns a builder for the current configuration. */
    public Builder toBuilder() {
      return new Builder(this);
    }

    @Override
    MoreObjects.ToStringHelper toStringHelper() {
      return super.toStringHelper().add("diskType", diskType);
    }

    @Override
    public int hashCode() {
      return Objects.hash(baseHashCode());
    }

    @Override
    public boolean equals(Object obj) {
      return obj == this
          || obj != null
              && obj.getClass().equals(ScratchDiskConfiguration.class)
              && baseEquals((ScratchDiskConfiguration) obj);
    }

    @Override
    ScratchDiskConfiguration setProjectId(String projectId) {
      if (diskType.getProject() != null) {
        return this;
      }
      return toBuilder().setDiskType(diskType.setProjectId(projectId)).build();
    }

    @Override
    com.google.api.services.compute.model.AttachedDisk toPb() {
      com.google.api.services.compute.model.AttachedDisk attachedDiskPb = super.toPb();
      if (diskType != null) {
        AttachedDiskInitializeParams initializeParamsPb = new AttachedDiskInitializeParams();
        initializeParamsPb.setDiskType(diskType.getSelfLink());
        attachedDiskPb.setInitializeParams(initializeParamsPb);
      }
      return attachedDiskPb;
    }

    /**
     * Returns a builder for {@code ScratchDiskConfiguration} objects given the disk type identity.
     */
    public static Builder newBuilder(DiskTypeId diskType) {
      return new Builder().setDiskType(diskType);
    }

    /**
     * Returns a {@code ScratchDiskConfiguration} object given the disk type identity. The disk will
     * be attached via the default interface ({@link InterfaceType#SCSI}).
     */
    public static ScratchDiskConfiguration of(DiskTypeId diskType) {
      return newBuilder(diskType).build();
    }

    @SuppressWarnings("unchecked")
    static ScratchDiskConfiguration fromPb(
        com.google.api.services.compute.model.AttachedDisk diskPb) {
      Builder builder = new Builder();
      if (diskPb.getInterface() != null) {
        builder.setInterfaceType(InterfaceType.valueOf(diskPb.getInterface()));
      }
      if (diskPb.getInitializeParams() != null
          && diskPb.getInitializeParams().getDiskType() != null) {
        builder.setDiskType(DiskTypeId.fromUrl(diskPb.getInitializeParams().getDiskType()));
      }
      return builder.build();
    }
  }

  /** A builder for {@code AttachedDisk} objects. */
  public static final class Builder {

    private String deviceName;
    private Integer index;
    private AttachedDiskConfiguration configuration;
    private List<LicenseId> licenses;

    Builder(AttachedDiskConfiguration configuration) {
      this.configuration = checkNotNull(configuration);
    }

    Builder(AttachedDisk attachedDisk) {
      this.deviceName = attachedDisk.deviceName;
      this.index = attachedDisk.index;
      this.configuration = attachedDisk.configuration;
      this.licenses = attachedDisk.licenses;
    }

    /**
     * Sets the unique device name of your choice that is reflected into the {@code
     * /dev/disk/by-id/google-*} tree of a Linux operating system running within the instance. This
     * name can be used to reference the device for mounting, resizing, and so on, from within the
     * instance. If not specified, the service chooses a default device name to apply to this disk,
     * in the form {@code persistent-disks-x}, where x is a number assigned by Google Compute
     * Engine.
     */
    public Builder setDeviceName(String deviceName) {
      this.deviceName = deviceName;
      return this;
    }

    /**
     * Sets a zero-based index to this disk, where 0 is reserved for the boot disk. For example, if
     * you have many disks attached to an instance, each disk would have an unique index number. If
     * not specified, the service will choose an appropriate value.
     */
    public Builder setIndex(Integer index) {
      this.index = index;
      return this;
    }

    /**
     * Sets the attached disk configuration. Use {@link ScratchDiskConfiguration} to attach a
     * scratch disk to the instance. Use {@link PersistentDiskConfiguration} to attach a persistent
     * disk to the instance. Use {@link CreateDiskConfiguration} to create and attach a new
     * persistent disk.
     */
    public Builder setConfiguration(AttachedDiskConfiguration configuration) {
      this.configuration = checkNotNull(configuration);
      return this;
    }

    Builder setLicenses(List<LicenseId> licenses) {
      this.licenses = licenses;
      return this;
    }

    /** Creates an {@code AttachedDisk} object. */
    public AttachedDisk build() {
      return new AttachedDisk(this);
    }
  }

  private AttachedDisk(Builder builder) {
    this.deviceName = builder.deviceName;
    this.index = builder.index;
    this.configuration = builder.configuration;
    this.licenses = builder.licenses;
  }

  /**
   * Returns the unique device name of your choice that is reflected into the {@code
   * /dev/disk/by-id/google-*} tree of a Linux operating system running within the instance. This
   * name can be used to reference the device for mounting, resizing, and so on, from within the
   * instance. If not specified, the service chooses a default device name to apply to this disk, in
   * the form {@code persistent-disks-x}, where x is a number assigned by Google Compute Engine.
   */
  public String getDeviceName() {
    return deviceName;
  }

  /** Returns a zero-based index to this disk, where 0 is reserved for the boot disk. */
  public Integer getIndex() {
    return index;
  }

  /**
   * Returns the attached disk configuration. Returns {@link ScratchDiskConfiguration} to attach a
   * scratch disk to the instance. Returns {@link PersistentDiskConfiguration} to attach a
   * persistent disk to the instance. Returns {@link CreateDiskConfiguration} to create and attach a
   * new persistent disk.
   */
  @SuppressWarnings("unchecked")
  public <T extends AttachedDiskConfiguration> T getConfiguration() {
    return (T) configuration;
  }

  /** Returns a list of publicly accessible licenses for the attached disk. */
  public List<LicenseId> getLicenses() {
    return licenses;
  }

  /** Returns a builder for the current attached disk. */
  public Builder toBuilder() {
    return new Builder(this);
  }

  @Override
  public String toString() {
    return MoreObjects.toStringHelper(this)
        .add("deviceName", deviceName)
        .add("index", index)
        .add("configuration", configuration)
        .add("licenses", licenses)
        .toString();
  }

  @Override
  public final int hashCode() {
    return Objects.hash(deviceName, index, configuration, licenses);
  }

  @Override
  public final boolean equals(Object obj) {
    return obj == this
        || obj != null
            && obj.getClass().equals(AttachedDisk.class)
            && Objects.equals(toPb(), ((AttachedDisk) obj).toPb());
  }

  AttachedDisk setProjectId(String projectId) {
    return toBuilder().setConfiguration(configuration.setProjectId(projectId)).build();
  }

  com.google.api.services.compute.model.AttachedDisk toPb() {
    com.google.api.services.compute.model.AttachedDisk attachedDiskPb = configuration.toPb();
    attachedDiskPb.setDeviceName(deviceName);
    attachedDiskPb.setIndex(index);
    if (licenses != null) {
      attachedDiskPb.setLicenses(Lists.transform(licenses, LicenseId.TO_URL_FUNCTION));
    }
    return attachedDiskPb;
  }

  /** Returns a builder for an {@code AttachedDisk} object given its configuration. */
  public static Builder newBuilder(AttachedDiskConfiguration configuration) {
    return new Builder(configuration);
  }

  /** Returns an {@code AttachedDisk} object given its configuration. */
  public static AttachedDisk of(AttachedDiskConfiguration configuration) {
    return newBuilder(configuration).build();
  }

  /** Returns an {@code AttachedDisk} object given the device name and its configuration. */
  public static AttachedDisk of(String deviceName, AttachedDiskConfiguration configuration) {
    return newBuilder(configuration).setDeviceName(deviceName).build();
  }

  static AttachedDisk fromPb(com.google.api.services.compute.model.AttachedDisk diskPb) {
    AttachedDiskConfiguration configuration = AttachedDiskConfiguration.fromPb(diskPb);
    Builder builder = newBuilder(configuration);
    builder.setDeviceName(diskPb.getDeviceName());
    builder.setIndex(diskPb.getIndex());
    if (diskPb.getLicenses() != null) {
      builder.setLicenses(Lists.transform(diskPb.getLicenses(), LicenseId.FROM_URL_FUNCTION));
    }
    return builder.build();
  }
}
