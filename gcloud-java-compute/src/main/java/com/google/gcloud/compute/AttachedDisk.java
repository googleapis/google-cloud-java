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

import com.google.api.services.compute.model.AttachedDiskInitializeParams;
import com.google.common.base.Function;
import com.google.common.base.MoreObjects;
import com.google.common.collect.Lists;

import java.io.Serializable;
import java.util.List;
import java.util.Objects;

/**
 * A base class for disks attached to a Google Compute Engine instance. To create a new disk to
 * attach when an image is created use {@link CreateAttachedDisk}. To attach an existing persistent
 * disk use {@link PersistentAttachedDisk}. To attach a scratch disk use
 * {@link ScratchAttachedDisk}.
 */
public abstract class AttachedDisk implements Serializable {

  static final Function<com.google.api.services.compute.model.AttachedDisk, AttachedDisk>
      FROM_PB_FUNCTION =
      new Function<com.google.api.services.compute.model.AttachedDisk, AttachedDisk>() {
        @Override
        public AttachedDisk apply(
            com.google.api.services.compute.model.AttachedDisk pb) {
          return AttachedDisk.fromPb(pb);
        }
      };
  static final Function<AttachedDisk, com.google.api.services.compute.model.AttachedDisk>
      TO_PB_FUNCTION =
      new Function<AttachedDisk,
          com.google.api.services.compute.model.AttachedDisk>() {
        @Override
        public com.google.api.services.compute.model.AttachedDisk apply(
            AttachedDisk attachedDisk) {
          return attachedDisk.toPb();
        }
      };
  private static final long serialVersionUID = 2969789134157943798L;

  private final String deviceName;
  private final Integer index;
  private final List<LicenseId> licenses;
  private final Type type;
  private final InterfaceType interfaceType;
  private final Boolean boot;
  private final Boolean autoDelete;
  private final Mode mode;

  /**
   * Specifies the type of the attached disk.
   */
  public enum Type {
    /**
     * A persistent disk attached to a VM instance. Such an attached disk must already exist or
     * can be created along with the instance by using {@link CreateAttachedDisk}. A persistent disk
     * an be attached to other VM instances.
     */
    PERSISTENT,

    /**
     * A scratch disk is created with the VM instance it is attached to. Scratch disks are only
     * available to their VM instance.
     */
    SCRATCH
  }

  /**
   * Specifies the disk interface to use for attaching this disk, which is either {@code SCSI}
   * or {@code NVME}. Persistent disks must always use {@code SCSI}. Scratch SSDs can use either
   * {@code NVME} or {@code SCSI}.
   */
  public enum InterfaceType {
    SCSI,
    NVME
  }

  /**
   * Specifies the mode in which to attach the disk.
   */
  public enum Mode {
    /**
     * The instance can both read and write to the disk.
     */
    READ_WRITE,

    /**
     * The instance is only allowed to read the disk.
     */
    READ_ONLY
  }

  /**
   * Base builder for attached disks.
   *
   * @param <T> the attached disk type
   * @param <B> the attached disk builder
   */
  public abstract static class Builder<T extends AttachedDisk, B extends AttachedDisk.Builder<T, B>> {

    private String deviceName;
    private Integer index;
    private List<LicenseId> licenses;
    private Type type;
    private InterfaceType interfaceType; // move to scratch?
    private Boolean boot; // move to persistent and create disk?
    private Boolean autoDelete; // move to persistent and create disk?
    private Mode mode;

    Builder(Type type) {
      this.type = type;
    }

    Builder(com.google.api.services.compute.model.AttachedDisk diskPb) {
      deviceName = diskPb.getDeviceName();
      index = diskPb.getIndex();
      type = Type.valueOf(diskPb.getType());
      if (diskPb.getLicenses() != null) {
        licenses = Lists.transform(diskPb.getLicenses(), LicenseId.FROM_URL_FUNCTION);
      }
      if (diskPb.getInterface() != null) {
        interfaceType = InterfaceType.valueOf(diskPb.getInterface());
      }
      if (diskPb.getMode() != null) {
        mode = Mode.valueOf(diskPb.getMode());
      }
      boot = diskPb.getBoot();
      autoDelete = diskPb.getAutoDelete();
    }

    Builder(AttachedDisk attachedDisk) {
      this.deviceName = attachedDisk.deviceName;
      this.index = attachedDisk.index;
      this.licenses = attachedDisk.licenses;
      this.type = attachedDisk.type;
      this.interfaceType = attachedDisk.interfaceType;
      this.boot = attachedDisk.boot;
      this.autoDelete = attachedDisk.autoDelete;
      this.mode = attachedDisk.mode;
    }

    @SuppressWarnings("unchecked")
    protected B self() {
      return (B) this;
    }

    /**
     * Sets the unique device name of your choice that is reflected into the
     * {@code /dev/disk/by-id/google-*} tree of a Linux operating system running within the
     * instance. This name can be used to reference the device for mounting, resizing, and so on,
     * from within the instance. If not specified, the service chooses a default device name to
     * apply to this disk, in the form {@code persistent-disks-x}, where x is a number assigned by
     * Google Compute Engine.
     */
    public B deviceName(String deviceName) {
      this.deviceName = deviceName;
      return self();
    }

    /**
     * Sets a zero-based index to this disk, where 0 is reserved for the boot disk. For example,
     * if you have many disks attached to an instance, each disk would have an unique index number.
     * If not specified, the service will choose an appropriate value.
     */
    public B index(Integer index) {
      this.index = index;
      return self();
    }

    B licenses(List<LicenseId> licenses) {
      this.licenses = licenses;
      return self();
    }

    B type(Type type) {
      this.type = type;
      return self();
    }

    B interfaceType(InterfaceType interfaceType) {
      this.interfaceType = interfaceType;
      return self();
    }

    B boot(Boolean boot) {
      this.boot = boot;
      return self();
    }

    B autoDelete(Boolean autoDelete) {
      this.autoDelete = autoDelete;
      return self();
    }

    B mode(Mode mode) {
      this.mode = mode;
      return self();
    }

    /**
     * Creates an object.
     */
    public abstract T build();
  }

  /**
   * A class for attached disks created from existing persistent disks. Persistent disks are always
   * attached using the {@link InterfaceType#SCSI}.
   */
  public static final class PersistentAttachedDisk extends AttachedDisk {

    private static final long serialVersionUID = 6367613188140104726L;

    private final DiskId sourceDisk;

    /**
     * A builder for {@code PersistentAttachedDisk} objects.
     */
    public static final class Builder extends AttachedDisk.Builder<PersistentAttachedDisk,
        Builder> {

      private DiskId sourceDisk;

      private Builder(PersistentAttachedDisk attachedDisk) {
        super(attachedDisk);
        this.sourceDisk = attachedDisk.sourceDisk;
      }

      private Builder(DiskId sourceDisk) {
        super(Type.PERSISTENT);
        this.sourceDisk = checkNotNull(sourceDisk);
      }

      private Builder(com.google.api.services.compute.model.AttachedDisk diskPb) {
        super(diskPb);
        this.sourceDisk = DiskId.fromUrl(diskPb.getSource());
      }

      /**
       * Sets the identity of the persistent disk to be attached.
       */
      public Builder sourceDisk(DiskId sourceDisk) {
        this.sourceDisk = checkNotNull(sourceDisk);
        return this;
      }

      /**
       * Sets the mode in which to attach this disk. If not specified, the disk is attached in
       * {@link Mode#READ_WRITE} mode.
       */
      @Override
      public Builder mode(Mode mode) {
        super.mode(mode);
        return this;
      }

      /**
       * Sets whether to use the attached disk as a boot disk. If {@code true} the virtual machine
       * will use the first partition of the disk for its root filesystem. If not specified, the
       * disk is not bootable.
       */
      public Builder boot(boolean boot) {
        super.boot(boot);
        return this;
      }

      /**
       * Sets whether the disk should auto-delete when the instance to which it's attached is
       * deleted. If not specified, the disk is not deleted automatically.
       */
      public Builder autoDelete(boolean autoDelete) {
        super.autoDelete(autoDelete);
        return this;
      }

      /**
       * Creates a {@code PersistentAttachedDisk} object.
       */
      public PersistentAttachedDisk build() {
        return new PersistentAttachedDisk(this);
      }
    }

    PersistentAttachedDisk(Builder builder) {
      super(builder);
      this.sourceDisk = builder.sourceDisk;
    }

    /**
     * Returns the identity of the persistent disk to be attached.
     */
    public DiskId sourceDisk() {
      return sourceDisk;
    }

    /**
     * Returns a builder for the current attached disk.
     */
    public Builder toBuilder() {
      return new Builder(this);
    }

    @Override
    MoreObjects.ToStringHelper toStringHelper() {
      return super.toStringHelper().add("sourceDisk", sourceDisk);
    }

    @Override
    public int hashCode() {
      return Objects.hash(baseHashCode(), sourceDisk);
    }

    @Override
    public boolean equals(Object obj) {
      return obj == this
          || obj != null
          && obj.getClass().equals(PersistentAttachedDisk.class)
          && baseEquals((PersistentAttachedDisk) obj);
    }

    @Override
    PersistentAttachedDisk setProjectId(String projectId) {
      if (sourceDisk.project() != null) {
        return this;
      }
      return toBuilder().sourceDisk(sourceDisk.setProjectId(projectId)).build();
    }

    @Override
    com.google.api.services.compute.model.AttachedDisk toPb() {
      com.google.api.services.compute.model.AttachedDisk attachedDiskPb = super.toPb();
      attachedDiskPb.setSource(sourceDisk.selfLink());
      return attachedDiskPb;
    }

    /**
     * Returns a builder for a {@code PersistentAttachedDisk} object given the identity of the
     * persistent disk to attach.
     */
    public static Builder builder(DiskId sourceDisk) {
      return new Builder(sourceDisk);
    }

    /**
     * Returns a {@code PersistentAttachedDisk} object given the identity of the persistent disk to
     * attach.
     */
    public static PersistentAttachedDisk of(DiskId sourceDisk) {
      return builder(sourceDisk).build();
    }

    @SuppressWarnings("unchecked")
    static PersistentAttachedDisk fromPb(
        com.google.api.services.compute.model.AttachedDisk diskPb) {
      return new Builder(diskPb).build();
    }
  }

  /**
   * A class for creating a boot persistent disk to attach to an instance. The attached disk is
   * created  along with the instance. Created persistent disks are always attached using the
   * {@link InterfaceType#SCSI} and in {@link Mode#READ_WRITE} mode.
   */
  public static final class CreateAttachedDisk extends AttachedDisk {

    private static final long serialVersionUID = 961995522284348824L;

    private final String diskName;
    private final DiskTypeId diskType;
    private final Long diskSizeGb;
    private final ImageId sourceImage;

    /**
     * A builder for {@code CreateAttachedDisk} objects.
     */
    public static final class Builder extends AttachedDisk.Builder<CreateAttachedDisk, Builder> {

      private String diskName;
      private DiskTypeId diskType;
      private Long diskSizeGb;
      private ImageId sourceImage;

      private Builder(ImageId sourceImage) {
        super(Type.PERSISTENT);
        boot(true);
        this.sourceImage = checkNotNull(sourceImage);
      }

      private Builder(CreateAttachedDisk attachedDisk) {
        super(attachedDisk);
        this.diskName = attachedDisk.diskName;
        this.diskType = attachedDisk.diskType;
        this.diskSizeGb = attachedDisk.diskSizeGb;
        this.sourceImage = attachedDisk.sourceImage;
      }

      private Builder(com.google.api.services.compute.model.AttachedDisk diskPb) {
        super(diskPb);
        AttachedDiskInitializeParams initializeParamsPb = diskPb.getInitializeParams();
        sourceImage = ImageId.fromUrl(initializeParamsPb.getSourceImage());
        if (initializeParamsPb.getDiskType() != null) {
          diskType = DiskTypeId.fromUrl(initializeParamsPb.getDiskType());
        }
        diskName = initializeParamsPb.getDiskName();
        diskSizeGb = initializeParamsPb.getDiskSizeGb();
        if (initializeParamsPb.getDiskType() != null) {
          diskType = DiskTypeId.fromUrl(initializeParamsPb.getDiskType());
        }
      }

      /**
       * Sets the name to be assigned to the disk. If not specified, the disk is given the
       * instance's name.
       */
      public Builder diskName(String diskName) {
        this.diskName = diskName;
        return this;
      }

      /**
       * Sets the identity of the disk type. If not specified, {@code pd-standard} is used.
       */
      public Builder diskType(DiskTypeId diskType) {
        this.diskType = diskType;
        return this;
      }

      /**
       * Sets the size of the persistent disk, in GB.
       */
      public Builder diskSizeGb(Long diskSizeGb) {
        this.diskSizeGb = diskSizeGb;
        return this;
      }

      /**
       * Sets the identity of the source image used to create the disk.
       */
      public Builder sourceImage(ImageId sourceImage) {
        this.sourceImage = checkNotNull(sourceImage);
        return this;
      }

      /**
       * Sets whether the disk should auto-delete when the instance to which it's attached is
       * deleted. If not specified, the disk is not deleted automatically.
       */
      @Override
      public Builder autoDelete(Boolean autoDelete) {
        super.autoDelete(autoDelete);
        return this;
      }

      /**
       * Creates a {@code CreateAttachedDisk} object.
       */
      public CreateAttachedDisk build() {
        return new CreateAttachedDisk(this);
      }
    }

    CreateAttachedDisk(Builder builder) {
      super(builder);
      this.diskName = builder.diskName;
      this.diskType = builder.diskType;
      this.diskSizeGb = builder.diskSizeGb;
      this.sourceImage = builder.sourceImage;
    }

    /**
     * Returns the name to be assigned to the disk. If not specified, the disk is given the
     * instance's name.
     */
    public String diskName() {
      return diskName;
    }

    /**
     * Returns the identity of the disk type. If not specified, {@code pd-standard} is used.
     */
    public DiskTypeId diskType() {
      return diskType;
    }

    /**
     * Returns the size of the persistent disk, in GB.
     */
    public Long diskSizeGb() {
      return diskSizeGb;
    }

    /**
     * Returns the identity of the source image used to create the disk.
     */
    public ImageId sourceImage() {
      return sourceImage;
    }

    /**
     * Returns a builder for the current attached disk.
     */
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
          && obj.getClass().equals(CreateAttachedDisk.class)
          && baseEquals((CreateAttachedDisk) obj);
    }

    @Override
    CreateAttachedDisk setProjectId(String projectId) {
      Builder builder = toBuilder();
      if (builder.diskType != null) {
        builder.diskType(diskType.setProjectId(projectId));
      }
      if (builder.sourceImage != null) {
        builder.sourceImage(sourceImage.setProjectId(projectId));
      }
      return builder.build();
    }

    @Override
    com.google.api.services.compute.model.AttachedDisk toPb() {
      AttachedDiskInitializeParams initializeParamsPb = new AttachedDiskInitializeParams();
      initializeParamsPb.setDiskName(diskName);
      initializeParamsPb.setDiskSizeGb(diskSizeGb);
      initializeParamsPb.setSourceImage(sourceImage.selfLink());
      if (diskType != null) {
        initializeParamsPb.setDiskType(diskType.selfLink());
      }
      com.google.api.services.compute.model.AttachedDisk attachedDiskPb = super.toPb();
      attachedDiskPb.setInitializeParams(initializeParamsPb);
      return attachedDiskPb;
    }

    /**
     * Returns a builder for a {@code CreateAttachedDisk} object given the source image that will be
     * used to create the disk.
     */
    public static Builder builder(ImageId sourceImage) {
      return new Builder(sourceImage);
    }

    /**
     * Returns a {@code CreateAttachedDisk} object given the source image that will be used to
     * create the disk.
     */
    public static CreateAttachedDisk of(ImageId sourceImage) {
      return builder(sourceImage).build();
    }

    @SuppressWarnings("unchecked")
    static CreateAttachedDisk fromPb(com.google.api.services.compute.model.AttachedDisk diskPb) {
      return new Builder(diskPb).build();
    }
  }

  /**
   * A class to attach a scratch disk to an instance. The attached scratch disk is a non-bootable
   * {@link Mode#READ_WRITE} disk that will be auto deleted with the instance to which it's
   * attached.
   */
  public static final class ScratchAttachedDisk extends AttachedDisk {

    private static final long serialVersionUID = -8445453507234691254L;

    private final DiskTypeId diskType;

    /**
     * A builder for {@code ScratchDiskConfiguration} objects.
     */
    public static final class Builder extends AttachedDisk.Builder<ScratchAttachedDisk, Builder > {

      private DiskTypeId diskType;

      private Builder(DiskTypeId diskType) {
        super(Type.SCRATCH);
        boot(false);
        autoDelete(true);
        this.diskType = diskType;
      }

      private Builder(ScratchAttachedDisk attachedDisk) {
        super(attachedDisk);
        this.diskType = attachedDisk.diskType;
      }

      private Builder(com.google.api.services.compute.model.AttachedDisk diskPb) {
        super(diskPb);
        AttachedDiskInitializeParams initializeParamsPb = diskPb.getInitializeParams();
        if (initializeParamsPb != null && initializeParamsPb.getDiskType() != null) {
          diskType = DiskTypeId.fromUrl(initializeParamsPb.getDiskType());
        }
      }

      /**
       * Sets the identity of the disk type.
       */
      public Builder diskType(DiskTypeId diskType) {
        this.diskType = checkNotNull(diskType);
        return this;
      }

      /**
       * Sets the interface type. If not specified, {@code SCSI} is used.
       */
      @Override
      public Builder interfaceType(InterfaceType interfaceType) {
        super.interfaceType(interfaceType);
        return this;
      }

      /**
       * Creates a {@code ScratchAttachedDisk} object.
       */
      public ScratchAttachedDisk build() {
        return new ScratchAttachedDisk(this);
      }
    }

    ScratchAttachedDisk(Builder builder) {
      super(builder);
      this.diskType = builder.diskType;
    }

    /**
     * Returns the identity of the disk type for the scratch disk to attach.
     */
    public DiskTypeId diskType() {
      return diskType;
    }

    /**
     * Returns a builder for the current attached disk.
     */
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
          && obj.getClass().equals(ScratchAttachedDisk.class)
          && baseEquals((ScratchAttachedDisk) obj);
    }

    @Override
    ScratchAttachedDisk setProjectId(String projectId) {
      if (diskType == null || diskType.project() != null) {
        return this;
      }
      return toBuilder().diskType(diskType.setProjectId(projectId)).build();
    }

    @Override
    com.google.api.services.compute.model.AttachedDisk toPb() {
      com.google.api.services.compute.model.AttachedDisk attachedDiskPb = super.toPb();
      AttachedDiskInitializeParams initializeParamsPb = new AttachedDiskInitializeParams();
      if (diskType() != null) {
        initializeParamsPb.setDiskType(diskType.selfLink());
      }
      attachedDiskPb.setInitializeParams(initializeParamsPb);
      return attachedDiskPb;
    }

    /**
     * Returns a builder for {@code ScratchAttachedDisk} objects given the disk type identity.
     */
    public static Builder builder(DiskTypeId diskType) {
      return new Builder(diskType);
    }

    /**
     * Returns a {@code ScratchAttachedDisk} object given the disk type identity. The disk will
     * be attached via the default interface ({@link InterfaceType#SCSI}).
     */
    public static ScratchAttachedDisk of(DiskTypeId diskType) {
      return builder(diskType).build();
    }

    @SuppressWarnings("unchecked")
    static ScratchAttachedDisk fromPb(com.google.api.services.compute.model.AttachedDisk diskPb) {
      return new Builder(diskPb).build();
    }
  }

  @SuppressWarnings("unchecked")
  private AttachedDisk(Builder builder) {
    this.deviceName = builder.deviceName;
    this.index = builder.index;
    this.licenses = (List<LicenseId>) builder.licenses;
    this.type = builder.type;
    this.interfaceType = builder.interfaceType;
    this.boot = builder.boot;
    this.autoDelete = builder.autoDelete;
    this.mode = builder.mode;
  }

  /**
   * Returns the unique device name of your choice that is reflected into the
   * {@code /dev/disk/by-id/google-*} tree of a Linux operating system running within the
   * instance. This name can be used to reference the device for mounting, resizing, and so on,
   * from within the instance. If not specified, the service chooses a default device name to
   * apply to this disk, in the form {@code persistent-disks-x}, where x is a number assigned by
   * Google Compute Engine.
   */
  public String deviceName() {
    return deviceName;
  }

  /**
   * Returns a zero-based index to this disk, where 0 is reserved for the boot disk.
   */
  public Integer index() {
    return index;
  }

  /**
   * Returns a list of publicly accessible licenses.
   */
  public List<LicenseId> licenses() {
    return licenses;
  }

  /**
   * Returns the type of the attached disk.
   */
  public Type type() {
    return type;
  }

  /**
   * Returns the interface to use to attach the disk. If not specified, {@link InterfaceType#SCSI}
   * is used.
   */
  public InterfaceType interfaceType() {
    return interfaceType;
  }

  /**
   * Returns whether to use the attached disk as a boot disk. If {@code true} the virtual machine
   * will use the first partition of the disk for its root filesystem. If not specified, the
   * disk is not bootable.
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

  /**
   * Returns the mode in which to attach this disk. If not specified, the disk is attached in
   * {@link Mode#READ_WRITE} mode.
   */
  public Mode mode() {
    return mode;
  }

  /**
   * Returns a builder for the current attached disk.
   */
  public abstract Builder toBuilder();

  MoreObjects.ToStringHelper toStringHelper() {
    return MoreObjects.toStringHelper(this)
        .add("deviceName", deviceName)
        .add("index", index)
        .add("licenses", licenses)
        .add("type", type)
        .add("interfaceType", interfaceType)
        .add("boot", boot)
        .add("autoDelete", autoDelete)
        .add("mode", mode);
  }

  @Override
  public String toString() {
    return toStringHelper().toString();
  }

  final int baseHashCode() {
    return Objects.hash(deviceName, index, licenses, type, interfaceType, boot, autoDelete, mode);
  }

  final boolean baseEquals(AttachedDisk diskConfiguration) {
    return Objects.equals(toPb(), diskConfiguration.toPb());
  }

  abstract AttachedDisk setProjectId(String projectId);

  com.google.api.services.compute.model.AttachedDisk toPb() {
    com.google.api.services.compute.model.AttachedDisk attachedDiskPb =
        new com.google.api.services.compute.model.AttachedDisk();
    attachedDiskPb.setDeviceName(deviceName);
    attachedDiskPb.setIndex(index);
    if (licenses != null) {
      attachedDiskPb.setLicenses(Lists.transform(licenses, LicenseId.TO_URL_FUNCTION));
    }
    attachedDiskPb.setType(type.toString());
    if (interfaceType != null) {
      attachedDiskPb.setInterface(interfaceType.toString());
    }
    attachedDiskPb.setBoot(boot);
    attachedDiskPb.setAutoDelete(autoDelete);
    if (mode != null) {
      attachedDiskPb.setMode(mode.toString());
    }
    return attachedDiskPb;
  }

  @SuppressWarnings("unchecked")
  static <T extends AttachedDisk> T fromPb(
      com.google.api.services.compute.model.AttachedDisk diskPb) {
    switch (Type.valueOf(diskPb.getType())) {
      case PERSISTENT:
        if (diskPb.getSource() == null) {
          return (T) CreateAttachedDisk.fromPb(diskPb);
        } else {
          return (T) PersistentAttachedDisk.fromPb(diskPb);
        }
      case SCRATCH:
        return (T) ScratchAttachedDisk.fromPb(diskPb);
      default:
        // should be unreachable
        throw new IllegalArgumentException("Unrecognized attached disk type");
    }
  }
}
