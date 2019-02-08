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
package com.google.cloud.compute.v1;

import com.google.api.core.BetaApi;
import com.google.api.gax.httpjson.ApiMessage;
import com.google.gson.annotations.SerializedName;
import java.util.LinkedList;
import java.util.List;
import java.util.Objects;
import javax.annotation.Generated;
import javax.annotation.Nullable;

@Generated("by GAPIC")
@BetaApi
/** An instance-attached disk resource. */
public final class AttachedDisk implements ApiMessage {
  private final Boolean autoDelete;
  private final Boolean boot;
  private final String deviceName;
  private final CustomerEncryptionKey diskEncryptionKey;
  private final List<GuestOsFeature> guestOsFeatures;
  private final Integer index;
  private final AttachedDiskInitializeParams initializeParams;

  @SerializedName("interface")
  private final String interface2;

  private final String kind;
  private final List<String> licenses;
  private final String mode;
  private final String source;
  private final String type;

  private AttachedDisk() {
    this.autoDelete = null;
    this.boot = null;
    this.deviceName = null;
    this.diskEncryptionKey = null;
    this.guestOsFeatures = null;
    this.index = null;
    this.initializeParams = null;
    this.interface2 = null;
    this.kind = null;
    this.licenses = null;
    this.mode = null;
    this.source = null;
    this.type = null;
  }

  private AttachedDisk(
      Boolean autoDelete,
      Boolean boot,
      String deviceName,
      CustomerEncryptionKey diskEncryptionKey,
      List<GuestOsFeature> guestOsFeatures,
      Integer index,
      AttachedDiskInitializeParams initializeParams,
      String interface2,
      String kind,
      List<String> licenses,
      String mode,
      String source,
      String type) {
    this.autoDelete = autoDelete;
    this.boot = boot;
    this.deviceName = deviceName;
    this.diskEncryptionKey = diskEncryptionKey;
    this.guestOsFeatures = guestOsFeatures;
    this.index = index;
    this.initializeParams = initializeParams;
    this.interface2 = interface2;
    this.kind = kind;
    this.licenses = licenses;
    this.mode = mode;
    this.source = source;
    this.type = type;
  }

  @Override
  public Object getFieldValue(String fieldName) {
    if ("autoDelete".equals(fieldName)) {
      return autoDelete;
    }
    if ("boot".equals(fieldName)) {
      return boot;
    }
    if ("deviceName".equals(fieldName)) {
      return deviceName;
    }
    if ("diskEncryptionKey".equals(fieldName)) {
      return diskEncryptionKey;
    }
    if ("guestOsFeatures".equals(fieldName)) {
      return guestOsFeatures;
    }
    if ("index".equals(fieldName)) {
      return index;
    }
    if ("initializeParams".equals(fieldName)) {
      return initializeParams;
    }
    if ("interface2".equals(fieldName)) {
      return interface2;
    }
    if ("kind".equals(fieldName)) {
      return kind;
    }
    if ("licenses".equals(fieldName)) {
      return licenses;
    }
    if ("mode".equals(fieldName)) {
      return mode;
    }
    if ("source".equals(fieldName)) {
      return source;
    }
    if ("type".equals(fieldName)) {
      return type;
    }
    return null;
  }

  @Nullable
  @Override
  public ApiMessage getApiMessageRequestBody() {
    return null;
  }

  @Nullable
  @Override
  public List<String> getFieldMask() {
    return null;
  }

  /**
   * Specifies whether the disk will be auto-deleted when the instance is deleted (but not when the
   * disk is detached from the instance).
   */
  public Boolean getAutoDelete() {
    return autoDelete;
  }

  /**
   * Indicates that this is a boot disk. The virtual machine will use the first partition of the
   * disk for its root filesystem.
   */
  public Boolean getBoot() {
    return boot;
  }

  /**
   * Specifies a unique device name of your choice that is reflected into the
   * /dev/disk/by-id/google-&#42; tree of a Linux operating system running within the instance. This
   * name can be used to reference the device for mounting, resizing, and so on, from within the
   * instance.
   *
   * <p>If not specified, the server chooses a default device name to apply to this disk, in the
   * form persistent-disk-x, where x is a number assigned by Google Compute Engine. This field is
   * only applicable for persistent disks.
   */
  public String getDeviceName() {
    return deviceName;
  }

  /**
   * Encrypts or decrypts a disk using a customer-supplied encryption key.
   *
   * <p>If you are creating a new disk, this field encrypts the new disk using an encryption key
   * that you provide. If you are attaching an existing disk that is already encrypted, this field
   * decrypts the disk using the customer-supplied encryption key.
   *
   * <p>If you encrypt a disk using a customer-supplied key, you must provide the same key again
   * when you attempt to use this resource at a later time. For example, you must provide the key
   * when you create a snapshot or an image from the disk or when you attach the disk to a virtual
   * machine instance.
   *
   * <p>If you do not provide an encryption key, then the disk will be encrypted using an
   * automatically generated key and you do not need to provide a key to use the disk later.
   *
   * <p>Instance templates do not store customer-supplied encryption keys, so you cannot use your
   * own keys to encrypt disks in a managed instance group.
   */
  public CustomerEncryptionKey getDiskEncryptionKey() {
    return diskEncryptionKey;
  }

  /**
   * A list of features to enable on the guest operating system. Applicable only for bootable
   * images. Read Enabling guest operating system features to see a list of available options.
   */
  public List<GuestOsFeature> getGuestOsFeaturesList() {
    return guestOsFeatures;
  }

  /**
   * [Output Only] A zero-based index to this disk, where 0 is reserved for the boot disk. If you
   * have many disks attached to an instance, each disk would have a unique index number.
   */
  public Integer getIndex() {
    return index;
  }

  /**
   * [Input Only] Specifies the parameters for a new disk that will be created alongside the new
   * instance. Use initialization parameters to create boot disks or local SSDs attached to the new
   * instance.
   *
   * <p>This property is mutually exclusive with the source property; you can only define one or the
   * other, but not both.
   */
  public AttachedDiskInitializeParams getInitializeParams() {
    return initializeParams;
  }

  /**
   * Specifies the disk interface to use for attaching this disk, which is either SCSI or NVME. The
   * default is SCSI. Persistent disks must always use SCSI and the request will fail if you attempt
   * to attach a persistent disk in any other format than SCSI. Local SSDs can use either NVME or
   * SCSI. For performance characteristics of SCSI over NVMe, see Local SSD performance.
   */
  public String getInterface() {
    return interface2;
  }

  /** [Output Only] Type of the resource. Always compute#attachedDisk for attached disks. */
  public String getKind() {
    return kind;
  }

  /** [Output Only] Any valid publicly visible licenses. */
  public List<String> getLicensesList() {
    return licenses;
  }

  /**
   * The mode in which to attach this disk, either READ_WRITE or READ_ONLY. If not specified, the
   * default is to attach the disk in READ_WRITE mode.
   */
  public String getMode() {
    return mode;
  }

  /**
   * Specifies a valid partial or full URL to an existing Persistent Disk resource. When creating a
   * new instance, one of initializeParams.sourceImage or disks.source is required except for local
   * SSD.
   *
   * <p>If desired, you can also attach existing non-root persistent disks using this property. This
   * field is only applicable for persistent disks.
   *
   * <p>Note that for InstanceTemplate, specify the disk name, not the URL for the disk.
   */
  public String getSource() {
    return source;
  }

  /**
   * Specifies the type of the disk, either SCRATCH or PERSISTENT. If not specified, the default is
   * PERSISTENT.
   */
  public String getType() {
    return type;
  }

  public static Builder newBuilder() {
    return DEFAULT_INSTANCE.toBuilder();
  }

  public static Builder newBuilder(AttachedDisk prototype) {
    return DEFAULT_INSTANCE.toBuilder().mergeFrom(prototype);
  }

  public Builder toBuilder() {
    return this == DEFAULT_INSTANCE ? new Builder() : new Builder().mergeFrom(this);
  }

  public static AttachedDisk getDefaultInstance() {
    return DEFAULT_INSTANCE;
  }

  private static final AttachedDisk DEFAULT_INSTANCE;

  static {
    DEFAULT_INSTANCE = new AttachedDisk();
  }

  public static class Builder {
    private Boolean autoDelete;
    private Boolean boot;
    private String deviceName;
    private CustomerEncryptionKey diskEncryptionKey;
    private List<GuestOsFeature> guestOsFeatures;
    private Integer index;
    private AttachedDiskInitializeParams initializeParams;
    private String interface2;
    private String kind;
    private List<String> licenses;
    private String mode;
    private String source;
    private String type;

    Builder() {}

    public Builder mergeFrom(AttachedDisk other) {
      if (other == AttachedDisk.getDefaultInstance()) return this;
      if (other.getAutoDelete() != null) {
        this.autoDelete = other.autoDelete;
      }
      if (other.getBoot() != null) {
        this.boot = other.boot;
      }
      if (other.getDeviceName() != null) {
        this.deviceName = other.deviceName;
      }
      if (other.getDiskEncryptionKey() != null) {
        this.diskEncryptionKey = other.diskEncryptionKey;
      }
      if (other.getGuestOsFeaturesList() != null) {
        this.guestOsFeatures = other.guestOsFeatures;
      }
      if (other.getIndex() != null) {
        this.index = other.index;
      }
      if (other.getInitializeParams() != null) {
        this.initializeParams = other.initializeParams;
      }
      if (other.getInterface() != null) {
        this.interface2 = other.interface2;
      }
      if (other.getKind() != null) {
        this.kind = other.kind;
      }
      if (other.getLicensesList() != null) {
        this.licenses = other.licenses;
      }
      if (other.getMode() != null) {
        this.mode = other.mode;
      }
      if (other.getSource() != null) {
        this.source = other.source;
      }
      if (other.getType() != null) {
        this.type = other.type;
      }
      return this;
    }

    Builder(AttachedDisk source) {
      this.autoDelete = source.autoDelete;
      this.boot = source.boot;
      this.deviceName = source.deviceName;
      this.diskEncryptionKey = source.diskEncryptionKey;
      this.guestOsFeatures = source.guestOsFeatures;
      this.index = source.index;
      this.initializeParams = source.initializeParams;
      this.interface2 = source.interface2;
      this.kind = source.kind;
      this.licenses = source.licenses;
      this.mode = source.mode;
      this.source = source.source;
      this.type = source.type;
    }

    /**
     * Specifies whether the disk will be auto-deleted when the instance is deleted (but not when
     * the disk is detached from the instance).
     */
    public Boolean getAutoDelete() {
      return autoDelete;
    }

    /**
     * Specifies whether the disk will be auto-deleted when the instance is deleted (but not when
     * the disk is detached from the instance).
     */
    public Builder setAutoDelete(Boolean autoDelete) {
      this.autoDelete = autoDelete;
      return this;
    }

    /**
     * Indicates that this is a boot disk. The virtual machine will use the first partition of the
     * disk for its root filesystem.
     */
    public Boolean getBoot() {
      return boot;
    }

    /**
     * Indicates that this is a boot disk. The virtual machine will use the first partition of the
     * disk for its root filesystem.
     */
    public Builder setBoot(Boolean boot) {
      this.boot = boot;
      return this;
    }

    /**
     * Specifies a unique device name of your choice that is reflected into the
     * /dev/disk/by-id/google-&#42; tree of a Linux operating system running within the instance.
     * This name can be used to reference the device for mounting, resizing, and so on, from within
     * the instance.
     *
     * <p>If not specified, the server chooses a default device name to apply to this disk, in the
     * form persistent-disk-x, where x is a number assigned by Google Compute Engine. This field is
     * only applicable for persistent disks.
     */
    public String getDeviceName() {
      return deviceName;
    }

    /**
     * Specifies a unique device name of your choice that is reflected into the
     * /dev/disk/by-id/google-&#42; tree of a Linux operating system running within the instance.
     * This name can be used to reference the device for mounting, resizing, and so on, from within
     * the instance.
     *
     * <p>If not specified, the server chooses a default device name to apply to this disk, in the
     * form persistent-disk-x, where x is a number assigned by Google Compute Engine. This field is
     * only applicable for persistent disks.
     */
    public Builder setDeviceName(String deviceName) {
      this.deviceName = deviceName;
      return this;
    }

    /**
     * Encrypts or decrypts a disk using a customer-supplied encryption key.
     *
     * <p>If you are creating a new disk, this field encrypts the new disk using an encryption key
     * that you provide. If you are attaching an existing disk that is already encrypted, this field
     * decrypts the disk using the customer-supplied encryption key.
     *
     * <p>If you encrypt a disk using a customer-supplied key, you must provide the same key again
     * when you attempt to use this resource at a later time. For example, you must provide the key
     * when you create a snapshot or an image from the disk or when you attach the disk to a virtual
     * machine instance.
     *
     * <p>If you do not provide an encryption key, then the disk will be encrypted using an
     * automatically generated key and you do not need to provide a key to use the disk later.
     *
     * <p>Instance templates do not store customer-supplied encryption keys, so you cannot use your
     * own keys to encrypt disks in a managed instance group.
     */
    public CustomerEncryptionKey getDiskEncryptionKey() {
      return diskEncryptionKey;
    }

    /**
     * Encrypts or decrypts a disk using a customer-supplied encryption key.
     *
     * <p>If you are creating a new disk, this field encrypts the new disk using an encryption key
     * that you provide. If you are attaching an existing disk that is already encrypted, this field
     * decrypts the disk using the customer-supplied encryption key.
     *
     * <p>If you encrypt a disk using a customer-supplied key, you must provide the same key again
     * when you attempt to use this resource at a later time. For example, you must provide the key
     * when you create a snapshot or an image from the disk or when you attach the disk to a virtual
     * machine instance.
     *
     * <p>If you do not provide an encryption key, then the disk will be encrypted using an
     * automatically generated key and you do not need to provide a key to use the disk later.
     *
     * <p>Instance templates do not store customer-supplied encryption keys, so you cannot use your
     * own keys to encrypt disks in a managed instance group.
     */
    public Builder setDiskEncryptionKey(CustomerEncryptionKey diskEncryptionKey) {
      this.diskEncryptionKey = diskEncryptionKey;
      return this;
    }

    /**
     * A list of features to enable on the guest operating system. Applicable only for bootable
     * images. Read Enabling guest operating system features to see a list of available options.
     */
    public List<GuestOsFeature> getGuestOsFeaturesList() {
      return guestOsFeatures;
    }

    /**
     * A list of features to enable on the guest operating system. Applicable only for bootable
     * images. Read Enabling guest operating system features to see a list of available options.
     */
    public Builder addAllGuestOsFeatures(List<GuestOsFeature> guestOsFeatures) {
      if (this.guestOsFeatures == null) {
        this.guestOsFeatures = new LinkedList<>();
      }
      this.guestOsFeatures.addAll(guestOsFeatures);
      return this;
    }

    /**
     * A list of features to enable on the guest operating system. Applicable only for bootable
     * images. Read Enabling guest operating system features to see a list of available options.
     */
    public Builder addGuestOsFeatures(GuestOsFeature guestOsFeatures) {
      if (this.guestOsFeatures == null) {
        this.guestOsFeatures = new LinkedList<>();
      }
      this.guestOsFeatures.add(guestOsFeatures);
      return this;
    }

    /**
     * [Output Only] A zero-based index to this disk, where 0 is reserved for the boot disk. If you
     * have many disks attached to an instance, each disk would have a unique index number.
     */
    public Integer getIndex() {
      return index;
    }

    /**
     * [Output Only] A zero-based index to this disk, where 0 is reserved for the boot disk. If you
     * have many disks attached to an instance, each disk would have a unique index number.
     */
    public Builder setIndex(Integer index) {
      this.index = index;
      return this;
    }

    /**
     * [Input Only] Specifies the parameters for a new disk that will be created alongside the new
     * instance. Use initialization parameters to create boot disks or local SSDs attached to the
     * new instance.
     *
     * <p>This property is mutually exclusive with the source property; you can only define one or
     * the other, but not both.
     */
    public AttachedDiskInitializeParams getInitializeParams() {
      return initializeParams;
    }

    /**
     * [Input Only] Specifies the parameters for a new disk that will be created alongside the new
     * instance. Use initialization parameters to create boot disks or local SSDs attached to the
     * new instance.
     *
     * <p>This property is mutually exclusive with the source property; you can only define one or
     * the other, but not both.
     */
    public Builder setInitializeParams(AttachedDiskInitializeParams initializeParams) {
      this.initializeParams = initializeParams;
      return this;
    }

    /**
     * Specifies the disk interface to use for attaching this disk, which is either SCSI or NVME.
     * The default is SCSI. Persistent disks must always use SCSI and the request will fail if you
     * attempt to attach a persistent disk in any other format than SCSI. Local SSDs can use either
     * NVME or SCSI. For performance characteristics of SCSI over NVMe, see Local SSD performance.
     */
    public String getInterface() {
      return interface2;
    }

    /**
     * Specifies the disk interface to use for attaching this disk, which is either SCSI or NVME.
     * The default is SCSI. Persistent disks must always use SCSI and the request will fail if you
     * attempt to attach a persistent disk in any other format than SCSI. Local SSDs can use either
     * NVME or SCSI. For performance characteristics of SCSI over NVMe, see Local SSD performance.
     */
    public Builder setInterface(String interface2) {
      this.interface2 = interface2;
      return this;
    }

    /** [Output Only] Type of the resource. Always compute#attachedDisk for attached disks. */
    public String getKind() {
      return kind;
    }

    /** [Output Only] Type of the resource. Always compute#attachedDisk for attached disks. */
    public Builder setKind(String kind) {
      this.kind = kind;
      return this;
    }

    /** [Output Only] Any valid publicly visible licenses. */
    public List<String> getLicensesList() {
      return licenses;
    }

    /** [Output Only] Any valid publicly visible licenses. */
    public Builder addAllLicenses(List<String> licenses) {
      if (this.licenses == null) {
        this.licenses = new LinkedList<>();
      }
      this.licenses.addAll(licenses);
      return this;
    }

    /** [Output Only] Any valid publicly visible licenses. */
    public Builder addLicenses(String licenses) {
      if (this.licenses == null) {
        this.licenses = new LinkedList<>();
      }
      this.licenses.add(licenses);
      return this;
    }

    /**
     * The mode in which to attach this disk, either READ_WRITE or READ_ONLY. If not specified, the
     * default is to attach the disk in READ_WRITE mode.
     */
    public String getMode() {
      return mode;
    }

    /**
     * The mode in which to attach this disk, either READ_WRITE or READ_ONLY. If not specified, the
     * default is to attach the disk in READ_WRITE mode.
     */
    public Builder setMode(String mode) {
      this.mode = mode;
      return this;
    }

    /**
     * Specifies a valid partial or full URL to an existing Persistent Disk resource. When creating
     * a new instance, one of initializeParams.sourceImage or disks.source is required except for
     * local SSD.
     *
     * <p>If desired, you can also attach existing non-root persistent disks using this property.
     * This field is only applicable for persistent disks.
     *
     * <p>Note that for InstanceTemplate, specify the disk name, not the URL for the disk.
     */
    public String getSource() {
      return source;
    }

    /**
     * Specifies a valid partial or full URL to an existing Persistent Disk resource. When creating
     * a new instance, one of initializeParams.sourceImage or disks.source is required except for
     * local SSD.
     *
     * <p>If desired, you can also attach existing non-root persistent disks using this property.
     * This field is only applicable for persistent disks.
     *
     * <p>Note that for InstanceTemplate, specify the disk name, not the URL for the disk.
     */
    public Builder setSource(String source) {
      this.source = source;
      return this;
    }

    /**
     * Specifies the type of the disk, either SCRATCH or PERSISTENT. If not specified, the default
     * is PERSISTENT.
     */
    public String getType() {
      return type;
    }

    /**
     * Specifies the type of the disk, either SCRATCH or PERSISTENT. If not specified, the default
     * is PERSISTENT.
     */
    public Builder setType(String type) {
      this.type = type;
      return this;
    }

    public AttachedDisk build() {

      return new AttachedDisk(
          autoDelete,
          boot,
          deviceName,
          diskEncryptionKey,
          guestOsFeatures,
          index,
          initializeParams,
          interface2,
          kind,
          licenses,
          mode,
          source,
          type);
    }

    public Builder clone() {
      Builder newBuilder = new Builder();
      newBuilder.setAutoDelete(this.autoDelete);
      newBuilder.setBoot(this.boot);
      newBuilder.setDeviceName(this.deviceName);
      newBuilder.setDiskEncryptionKey(this.diskEncryptionKey);
      newBuilder.addAllGuestOsFeatures(this.guestOsFeatures);
      newBuilder.setIndex(this.index);
      newBuilder.setInitializeParams(this.initializeParams);
      newBuilder.setInterface(this.interface2);
      newBuilder.setKind(this.kind);
      newBuilder.addAllLicenses(this.licenses);
      newBuilder.setMode(this.mode);
      newBuilder.setSource(this.source);
      newBuilder.setType(this.type);
      return newBuilder;
    }
  }

  @Override
  public String toString() {
    return "AttachedDisk{"
        + "autoDelete="
        + autoDelete
        + ", "
        + "boot="
        + boot
        + ", "
        + "deviceName="
        + deviceName
        + ", "
        + "diskEncryptionKey="
        + diskEncryptionKey
        + ", "
        + "guestOsFeatures="
        + guestOsFeatures
        + ", "
        + "index="
        + index
        + ", "
        + "initializeParams="
        + initializeParams
        + ", "
        + "interface2="
        + interface2
        + ", "
        + "kind="
        + kind
        + ", "
        + "licenses="
        + licenses
        + ", "
        + "mode="
        + mode
        + ", "
        + "source="
        + source
        + ", "
        + "type="
        + type
        + "}";
  }

  @Override
  public boolean equals(Object o) {
    if (o == this) {
      return true;
    }
    if (o instanceof AttachedDisk) {
      AttachedDisk that = (AttachedDisk) o;
      return Objects.equals(this.autoDelete, that.getAutoDelete())
          && Objects.equals(this.boot, that.getBoot())
          && Objects.equals(this.deviceName, that.getDeviceName())
          && Objects.equals(this.diskEncryptionKey, that.getDiskEncryptionKey())
          && Objects.equals(this.guestOsFeatures, that.getGuestOsFeaturesList())
          && Objects.equals(this.index, that.getIndex())
          && Objects.equals(this.initializeParams, that.getInitializeParams())
          && Objects.equals(this.interface2, that.getInterface())
          && Objects.equals(this.kind, that.getKind())
          && Objects.equals(this.licenses, that.getLicensesList())
          && Objects.equals(this.mode, that.getMode())
          && Objects.equals(this.source, that.getSource())
          && Objects.equals(this.type, that.getType());
    }
    return false;
  }

  @Override
  public int hashCode() {
    return Objects.hash(
        autoDelete,
        boot,
        deviceName,
        diskEncryptionKey,
        guestOsFeatures,
        index,
        initializeParams,
        interface2,
        kind,
        licenses,
        mode,
        source,
        type);
  }
}
