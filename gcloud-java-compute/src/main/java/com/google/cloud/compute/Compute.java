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

package com.google.cloud.compute;

import static com.google.common.base.Preconditions.checkNotNull;

import com.google.cloud.FieldSelector;
import com.google.cloud.FieldSelector.Helper;
import com.google.cloud.Page;
import com.google.cloud.Service;
import com.google.cloud.compute.AttachedDisk.PersistentDiskConfiguration;
import com.google.cloud.compute.NetworkInterface.AccessConfig;
import com.google.cloud.compute.spi.ComputeRpc;
import com.google.common.base.MoreObjects;
import com.google.common.collect.ImmutableList;

import java.io.Serializable;
import java.util.List;
import java.util.Objects;

/**
 * An interface for Google Cloud Compute Engine.
 *
 * @see <a href="https://cloud.google.com/compute/docs/">Google Cloud Compute Engine</a>
 */
public interface Compute extends Service<ComputeOptions> {

  /**
   * Fields of a Compute Engine DiskType resource.
   *
   * @see <a href="https://cloud.google.com/compute/docs/reference/latest/diskTypes#resource">Disk
   *     Type Resource</a>
   */
  enum DiskTypeField implements FieldSelector {
    CREATION_TIMESTAMP("creationTimestamp"),
    DEFAULT_DISK_SIZE_GB("defaultDiskSizeGb"),
    DESCRIPTION("description"),
    ID("id"),
    NAME("name"),
    SELF_LINK("selfLink"),
    VALID_DISK_SIZE("validDiskSize"),
    ZONE("zone"),
    DEPRECATED("deprecated");

    static final List<? extends FieldSelector> REQUIRED_FIELDS = ImmutableList.of(SELF_LINK);

    private final String selector;

    DiskTypeField(String selector) {
      this.selector = selector;
    }

    @Override
    public String selector() {
      return selector;
    }
  }

  /**
   * Fields of a Compute Engine MachineType resource.
   *
   * @see <a href="https://cloud.google.com/compute/docs/reference/latest/machineTypes#resource">
   *     Machine Type Resource</a>
   */
  enum MachineTypeField implements FieldSelector {
    CREATION_TIMESTAMP("creationTimestamp"),
    DESCRIPTION("description"),
    GUEST_CPUS("guestCpus"),
    ID("id"),
    IMAGE_SPACE_GB("imageSpaceGb"),
    MAXIMUM_PERSISTENT_DISKS("maximumPersistentDisks"),
    MAXIMUM_PERSISTENT_DISKS_SIZE_GB("maximumPersistentDisksSizeGb"),
    MEMORY_MB("memoryMb"),
    NAME("name"),
    SCRATCH_DISKS("scratchDisks"),
    SELF_LINK("selfLink"),
    ZONE("zone"),
    DEPRECATED("deprecated");

    static final List<? extends FieldSelector> REQUIRED_FIELDS = ImmutableList.of(SELF_LINK);

    private final String selector;

    MachineTypeField(String selector) {
      this.selector = selector;
    }

    @Override
    public String selector() {
      return selector;
    }
  }

  /**
   * Fields of a Compute Engine Region resource.
   *
   * @see <a href="https://cloud.google.com/compute/docs/reference/latest/regions#resource">
   *     Region Resource</a>
   */
  enum RegionField implements FieldSelector {
    CREATION_TIMESTAMP("creationTimestamp"),
    DESCRIPTION("description"),
    ID("id"),
    NAME("name"),
    QUOTAS("quotas"),
    SELF_LINK("selfLink"),
    STATUS("status"),
    ZONES("zones"),
    DEPRECATED("deprecated");

    static final List<? extends FieldSelector> REQUIRED_FIELDS = ImmutableList.of(SELF_LINK);

    private final String selector;

    RegionField(String selector) {
      this.selector = selector;
    }

    @Override
    public String selector() {
      return selector;
    }
  }

  /**
   * Fields of a Compute Engine Zone resource.
   *
   * @see <a href="https://cloud.google.com/compute/docs/reference/latest/zones#resource">Zone
   *     Resource</a>
   */
  enum ZoneField implements FieldSelector {
    CREATION_TIMESTAMP("creationTimestamp"),
    DESCRIPTION("description"),
    ID("id"),
    NAME("name"),
    REGION("region"),
    SELF_LINK("selfLink"),
    STATUS("status"),
    DEPRECATED("deprecated");

    static final List<? extends FieldSelector> REQUIRED_FIELDS = ImmutableList.of(SELF_LINK);

    private final String selector;

    ZoneField(String selector) {
      this.selector = selector;
    }

    @Override
    public String selector() {
      return selector;
    }
  }

  /**
   * Fields of a Compute Engine License resource.
   *
   * @see <a href="https://cloud.google.com/compute/docs/reference/latest/licenses#resource">License
   *     Resource</a>
   */
  enum LicenseField implements FieldSelector {
    CHARGES_USE_FEE("chargesUseFee"),
    NAME("name"),
    SELF_LINK("selfLink");

    static final List<? extends FieldSelector> REQUIRED_FIELDS = ImmutableList.of(SELF_LINK);

    private final String selector;

    LicenseField(String selector) {
      this.selector = selector;
    }

    @Override
    public String selector() {
      return selector;
    }
  }

  /**
   * Fields of a Compute Engine Operation resource.
   *
   * @see <a
   *     href="https://cloud.google.com/compute/docs/reference/latest/globalOperations#resource">
   *     GlobalOperation Resource</a>
   * @see <a
   *     href="https://cloud.google.com/compute/docs/reference/latest/regionOperations#resource">
   *     RegionOperation Resource</a>
   * @see <a href="https://cloud.google.com/compute/docs/reference/latest/zoneOperations#resource">
   *     ZoneOperation Resource</a>
   */
  enum OperationField implements FieldSelector {
    CLIENT_OPERATION_ID("clientOperationId"),
    DESCRIPTION("description"),
    END_TIME("endTime"),
    ERROR("error"),
    HTTP_ERROR_MESSAGE("httpErrorMessage"),
    HTTP_ERROR_STATUS_CODE("httpErrorStatusCode"),
    ID("id"),
    INSERT_TIME("insertTime"),
    NAME("name"),
    OPERATION_TYPE("operationType"),
    PROGRESS("progress"),
    REGION("region"),
    SELF_LINK("selfLink"),
    START_TIME("startTime"),
    STATUS("status"),
    STATUS_MESSAGE("statusMessage"),
    TARGET_ID("targetId"),
    TARGET_LINK("targetLink"),
    USER("user"),
    WARNINGS("warnings"),
    ZONE("zone");

    static final List<? extends FieldSelector> REQUIRED_FIELDS = ImmutableList.of(SELF_LINK);

    private final String selector;

    OperationField(String selector) {
      this.selector = selector;
    }

    @Override
    public String selector() {
      return selector;
    }
  }

  /**
   * Fields of a Compute Engine Address resource.
   *
   * @see <a href="https://cloud.google.com/compute/docs/reference/latest/addresses#resource">Region
   *     Address Resource</a>
   * @see <a href="https://cloud.google.com/compute/docs/reference/latest/globalAddresses#resource">
   *     Global Address Resource</a>
   */
  enum AddressField implements FieldSelector {
    ADDRESS("address"),
    CREATION_TIMESTAMP("creationTimestamp"),
    DESCRIPTION("description"),
    ID("id"),
    NAME("name"),
    REGION("region"),
    SELF_LINK("selfLink"),
    STATUS("status"),
    USERS("users");

    static final List<? extends FieldSelector> REQUIRED_FIELDS = ImmutableList.of(SELF_LINK);

    private final String selector;

    AddressField(String selector) {
      this.selector = selector;
    }

    @Override
    public String selector() {
      return selector;
    }
  }

  /**
   * Fields of a Compute Engine Disk resource.
   *
   * @see <a href="https://cloud.google.com/compute/docs/reference/latest/disks#resource">Disk
   *     Resource</a>
   */
  enum DiskField implements FieldSelector {
    CREATION_TIMESTAMP("creationTimestamp"),
    DESCRIPTION("description"),
    ID("id"),
    LAST_ATTACH_TIMESTAMP("lastAttachTimestamp"),
    LAST_DETACH_TIMESTAMP("lastDetachTimestamp"),
    LICENSES("licenses"),
    NAME("name"),
    OPTIONS("options"),
    SELF_LINK("selfLink"),
    SIZE_GB("sizeGb"),
    SOURCE_IMAGE("sourceImage"),
    SOURCE_IMAGE_ID("sourceImageId"),
    SOURCE_SNAPSHOT("sourceSnapshot"),
    SOURCE_SNAPSHOT_ID("sourceSnapshotId"),
    STATUS("status"),
    TYPE("type"),
    USERS("users"),
    ZONE("zone");

    static final List<? extends FieldSelector> REQUIRED_FIELDS =
        ImmutableList.of(SELF_LINK, TYPE, SOURCE_IMAGE, SOURCE_SNAPSHOT);

    private final String selector;

    DiskField(String selector) {
      this.selector = selector;
    }

    @Override
    public String selector() {
      return selector;
    }
  }

  /**
   * Fields of a Compute Engine Snapshot resource.
   *
   * @see <a href="https://cloud.google.com/compute/docs/reference/latest/snapshots#resource">
   *     Snapshot Resource</a>
   */
  enum SnapshotField implements FieldSelector {
    CREATION_TIMESTAMP("creationTimestamp"),
    DESCRIPTION("description"),
    DISK_SIZE_GB("diskSizeGb"),
    ID("id"),
    LICENSES("licenses"),
    NAME("name"),
    SELF_LINK("selfLink"),
    SOURCE_DISK("sourceDisk"),
    SOURCE_DISK_ID("sourceDiskId"),
    STATUS("status"),
    STORAGE_BYTES("storageBytes"),
    STORAGE_BYTES_STATUS("storageBytesStatus");

    static final List<? extends FieldSelector> REQUIRED_FIELDS = ImmutableList.of(SELF_LINK);

    private final String selector;

    SnapshotField(String selector) {
      this.selector = selector;
    }

    @Override
    public String selector() {
      return selector;
    }
  }

  /**
   * Fields of a Compute Engine Image resource.
   *
   * @see <a href="https://cloud.google.com/compute/docs/reference/latest/images#resource">Image
   *     Resource</a>
   */
  enum ImageField implements FieldSelector {
    ARCHIVE_SIZE_BYTES("archiveSizeBytes"),
    CREATION_TIMESTAMP("creationTimestamp"),
    DEPRECATED("deprecated"),
    DESCRIPTION("description"),
    DISK_SIZE_GB("diskSizeGb"),
    ID("id"),
    LICENSES("licenses"),
    NAME("name"),
    RAW_DISK("rawDisk"),
    SELF_LINK("selfLink"),
    SOURCE_DISK("sourceDisk"),
    SOURCE_DISK_ID("sourceDiskId"),
    SOURCE_TYPE("sourceType");

    static final List<? extends FieldSelector> REQUIRED_FIELDS =
        ImmutableList.of(SELF_LINK, SOURCE_DISK, RAW_DISK);

    private final String selector;

    ImageField(String selector) {
      this.selector = selector;
    }

    @Override
    public String selector() {
      return selector;
    }
  }

  /**
   * Fields of a Compute Engine Subnetwork resource.
   *
   * @see <a href="https://cloud.google.com/compute/docs/reference/latest/subnetworks#resource">
   *     Subnetwork Resource</a>
   */
  enum SubnetworkField implements FieldSelector {
    CREATION_TIMESTAMP("creationTimestamp"),
    DESCRIPTION("description"),
    GATEWAY_ADDRESS("gatewayAddress"),
    ID("id"),
    IP_CIDR_RANGE("ipCidrRange"),
    NAME("name"),
    NETWORK("network"),
    REGION("region"),
    SELF_LINK("selfLink");

    static final List<? extends FieldSelector> REQUIRED_FIELDS = ImmutableList.of(SELF_LINK);

    private final String selector;

    SubnetworkField(String selector) {
      this.selector = selector;
    }

    @Override
    public String selector() {
      return selector;
    }
  }

  /**
   * Fields of a Compute Engine Network resource.
   *
   * @see <a href="https://cloud.google.com/compute/docs/reference/latest/networks#resource">
   *     Network Resource</a>
   */
  enum NetworkField implements FieldSelector {
    IPV4_RANGE("IPv4Range"),
    AUTO_CREATE_SUBNETWORKS("autoCreateSubnetworks"),
    CREATION_TIMESTAMP("creationTimestamp"),
    DESCRIPTION("description"),
    GATEWAY_IPV4("gatewayIPv4"),
    ID("id"),
    NAME("name"),
    SELF_LINK("selfLink"),
    SUBNETWORKS("subnetworks");

    static final List<? extends FieldSelector> REQUIRED_FIELDS =
        ImmutableList.of(SELF_LINK, IPV4_RANGE, AUTO_CREATE_SUBNETWORKS);

    private final String selector;

    NetworkField(String selector) {
      this.selector = selector;
    }

    @Override
    public String selector() {
      return selector;
    }
  }

  /**
   * Fields of a Compute Engine Instance resource.
   *
   * @see <a href="https://cloud.google.com/compute/docs/reference/latest/instances#resource">
   *     Network Resource</a>
   */
  enum InstanceField implements FieldSelector {
    CAN_IP_FORWARD("canIpForward"),
    CPU_PLATFORM("cpuPlatform"),
    CREATION_TIMESTAMP("creationTimestamp"),
    DESCRIPTION("description"),
    DISKS("disks"),
    ID("id"),
    MACHINE_TYPE("machineType"),
    METADATA("metadata"),
    NAME("name"),
    NETWORK_INTERFACES("networkInterfaces"),
    SCHEDULING("scheduling"),
    SELF_LINK("selfLink"),
    SERVICE_ACCOUNTS("serviceAccounts"),
    STATUS("status"),
    STATUS_MESSAGE("statusMessage"),
    TAGS("tags"),
    ZONE("zone");

    static final List<? extends FieldSelector> REQUIRED_FIELDS = ImmutableList.of(SELF_LINK);

    private final String selector;

    InstanceField(String selector) {
      this.selector = selector;
    }

    @Override
    public String selector() {
      return selector;
    }
  }

  /**
   * Base class for list filters.
   */
  abstract class ListFilter implements Serializable {

    private static final long serialVersionUID = -238638392811165127L;

    private final String field;
    private final ComparisonOperator operator;
    private final Object value;

    enum ComparisonOperator {
      /**
       * Defines an equals filter.
       */
      EQ,

      /**
       * Defines a not-equals filter.
       */
      NE
    }

    ListFilter(String field, ComparisonOperator operator, Object value) {
      this.field = field;
      this.operator = operator;
      this.value = value;
    }

    @Override
    public int hashCode() {
      return Objects.hash(field, operator, value);
    }

    @Override
    public boolean equals(Object obj) {
      return obj instanceof ListFilter && toPb().equals(((ListFilter) obj).toPb());
    }

    @Override
    public String toString() {
      return MoreObjects.toStringHelper(this)
          .add("field", field)
          .add("operator", operator)
          .add("value", value)
          .toString();
    }

    String toPb() {
      return field + ' ' + operator.name().toLowerCase() + ' ' + value.toString();
    }
  }

  /**
   * Class for filtering disk type lists.
   */
  class DiskTypeFilter extends ListFilter {

    private static final long serialVersionUID = 4847837203592234453L;

    private DiskTypeFilter(DiskTypeField field, ComparisonOperator operator, Object value) {
      super(field.selector(), operator, value);
    }

    /**
     * Returns an equals filter for the given field and string value. For string fields,
     * {@code value} is interpreted as a regular expression using RE2 syntax. {@code value} must
     * match the entire field.
     *
     * @see <a href="https://github.com/google/re2/wiki/Syntax">RE2</a>
     */
    public static DiskTypeFilter equals(DiskTypeField field, String value) {
      return new DiskTypeFilter(checkNotNull(field), ComparisonOperator.EQ, checkNotNull(value));
    }

    /**
     * Returns a not-equals filter for the given field and string value. For string fields,
     * {@code value} is interpreted as a regular expression using RE2 syntax. {@code value} must
     * match the entire field.
     *
     * @see <a href="https://github.com/google/re2/wiki/Syntax">RE2</a>
     */
    public static DiskTypeFilter notEquals(DiskTypeField field, String value) {
      return new DiskTypeFilter(checkNotNull(field), ComparisonOperator.NE, checkNotNull(value));
    }

    /**
     * Returns an equals filter for the given field and long value.
     */
    public static DiskTypeFilter equals(DiskTypeField field, long value) {
      return new DiskTypeFilter(checkNotNull(field), ComparisonOperator.EQ, value);
    }

    /**
     * Returns a not-equals filter for the given field and long value.
     */
    public static DiskTypeFilter notEquals(DiskTypeField field, long value) {
      return new DiskTypeFilter(checkNotNull(field), ComparisonOperator.NE, value);
    }
  }

  /**
   * Class for filtering machine type lists.
   */
  class MachineTypeFilter extends ListFilter {

    private static final long serialVersionUID = 7346062041571853235L;

    private MachineTypeFilter(MachineTypeField field, ComparisonOperator operator, Object value) {
      super(field.selector(), operator, value);
    }

    /**
     * Returns an equals filter for the given field and string value. For string fields,
     * {@code value} is interpreted as a regular expression using RE2 syntax. {@code value} must
     * match the entire field.
     *
     * @see <a href="https://github.com/google/re2/wiki/Syntax">RE2</a>
     */
    public static MachineTypeFilter equals(MachineTypeField field, String value) {
      return new MachineTypeFilter(checkNotNull(field), ComparisonOperator.EQ, checkNotNull(value));
    }

    /**
     * Returns a not-equals filter for the given field and string value. For string fields,
     * {@code value} is interpreted as a regular expression using RE2 syntax. {@code value} must
     * match the entire field.
     *
     * @see <a href="https://github.com/google/re2/wiki/Syntax">RE2</a>
     */
    public static MachineTypeFilter notEquals(MachineTypeField field, String value) {
      return new MachineTypeFilter(checkNotNull(field), ComparisonOperator.NE, checkNotNull(value));
    }

    /**
     * Returns an equals filter for the given field and long value.
     */
    public static MachineTypeFilter equals(MachineTypeField field, long value) {
      return new MachineTypeFilter(checkNotNull(field), ComparisonOperator.EQ, value);
    }

    /**
     * Returns a not-equals filter for the given field and long value.
     */
    public static MachineTypeFilter notEquals(MachineTypeField field, long value) {
      return new MachineTypeFilter(checkNotNull(field), ComparisonOperator.NE, value);
    }
  }

  /**
   * Class for filtering region lists.
   */
  class RegionFilter extends ListFilter {

    private static final long serialVersionUID = 4464892812442567172L;

    private RegionFilter(RegionField field, ComparisonOperator operator, Object value) {
      super(field.selector(), operator, value);
    }

    /**
     * Returns an equals filter for the given field and string value. For string fields,
     * {@code value} is interpreted as a regular expression using RE2 syntax. {@code value} must
     * match the entire field.
     *
     * @see <a href="https://github.com/google/re2/wiki/Syntax">RE2</a>
     */
    public static RegionFilter equals(RegionField field, String value) {
      return new RegionFilter(checkNotNull(field), ComparisonOperator.EQ, value);
    }

    /**
     * Returns a not-equals filter for the given field and string value. For string fields,
     * {@code value} is interpreted as a regular expression using RE2 syntax. {@code value} must
     * match the entire field.
     *
     * @see <a href="https://github.com/google/re2/wiki/Syntax">RE2</a>
     */
    public static RegionFilter notEquals(RegionField field, String value) {
      return new RegionFilter(checkNotNull(field), ComparisonOperator.NE, checkNotNull(value));
    }
  }

  /**
   * Class for filtering zone lists.
   */
  class ZoneFilter extends ListFilter {

    private static final long serialVersionUID = -3927428278548808737L;

    private ZoneFilter(ZoneField field, ComparisonOperator operator, Object value) {
      super(field.selector(), operator, value);
    }

    /**
     * Returns an equals filter for the given field and string value. For string fields,
     * {@code value} is interpreted as a regular expression using RE2 syntax. {@code value} must
     * match the entire field.
     *
     * @see <a href="https://github.com/google/re2/wiki/Syntax">RE2</a>
     */
    public static ZoneFilter equals(ZoneField field, String value) {
      return new ZoneFilter(checkNotNull(field), ComparisonOperator.EQ, checkNotNull(value));
    }

    /**
     * Returns a not-equals filter for the given field and string value. For string fields,
     * {@code value} is interpreted as a regular expression using RE2 syntax. {@code value} must
     * match the entire field.
     *
     * @see <a href="https://github.com/google/re2/wiki/Syntax">RE2</a>
     */
    public static ZoneFilter notEquals(ZoneField field, String value) {
      return new ZoneFilter(checkNotNull(field), ComparisonOperator.NE, checkNotNull(value));
    }
  }

  /**
   * Class for filtering operation lists.
   */
  class OperationFilter extends ListFilter {

    private static final long serialVersionUID = -3202249202748346427L;

    private OperationFilter(OperationField field, ComparisonOperator operator, Object value) {
      super(field.selector(), operator, value);
    }

    /**
     * Returns an equals filter for the given field and string value. For string fields,
     * {@code value} is interpreted as a regular expression using RE2 syntax. {@code value} must
     * match the entire field.
     *
     * @see <a href="https://github.com/google/re2/wiki/Syntax">RE2</a>
     */
    public static OperationFilter equals(OperationField field, String value) {
      return new OperationFilter(checkNotNull(field), ComparisonOperator.EQ, checkNotNull(value));
    }

    /**
     * Returns a not-equals filter for the given field and string value. For string fields,
     * {@code value} is interpreted as a regular expression using RE2 syntax. {@code value} must
     * match the entire field.
     *
     * @see <a href="https://github.com/google/re2/wiki/Syntax">RE2</a>
     */
    public static OperationFilter notEquals(OperationField field, String value) {
      return new OperationFilter(checkNotNull(field), ComparisonOperator.NE, checkNotNull(value));
    }

    /**
     * Returns an equals filter for the given field and long value.
     */
    public static OperationFilter equals(OperationField field, long value) {
      return new OperationFilter(checkNotNull(field), ComparisonOperator.EQ, value);
    }

    /**
     * Returns a not-equals filter for the given field and long value.
     */
    public static OperationFilter notEquals(OperationField field, long value) {
      return new OperationFilter(checkNotNull(field), ComparisonOperator.NE, value);
    }
  }

  /**
   * Class for filtering address lists.
   */
  class AddressFilter extends ListFilter {

    private static final long serialVersionUID = -227481644259653765L;

    private AddressFilter(AddressField field, ComparisonOperator operator, Object value) {
      super(field.selector(), operator, value);
    }

    /**
     * Returns an equals filter for the given field and string value. For string fields,
     * {@code value} is interpreted as a regular expression using RE2 syntax. {@code value} must
     * match the entire field.
     *
     * @see <a href="https://github.com/google/re2/wiki/Syntax">RE2</a>
     */
    public static AddressFilter equals(AddressField field, String value) {
      return new AddressFilter(checkNotNull(field), ComparisonOperator.EQ, checkNotNull(value));
    }

    /**
     * Returns a not-equals filter for the given field and string value. For string fields,
     * {@code value} is interpreted as a regular expression using RE2 syntax. {@code value} must
     * match the entire field.
     *
     * @see <a href="https://github.com/google/re2/wiki/Syntax">RE2</a>
     */
    public static AddressFilter notEquals(AddressField field, String value) {
      return new AddressFilter(checkNotNull(field), ComparisonOperator.NE, checkNotNull(value));
    }
  }

  /**
   * Class for filtering snapshot lists.
   */
  class SnapshotFilter extends ListFilter {

    private static final long serialVersionUID = 8757711630092406747L;

    private SnapshotFilter(SnapshotField field, ComparisonOperator operator, Object value) {
      super(field.selector(), operator, value);
    }

    /**
     * Returns an equals filter for the given field and string value. For string fields,
     * {@code value} is interpreted as a regular expression using RE2 syntax. {@code value} must
     * match the entire field.
     *
     * @see <a href="https://github.com/google/re2/wiki/Syntax">RE2</a>
     */
    public static SnapshotFilter equals(SnapshotField field, String value) {
      return new SnapshotFilter(checkNotNull(field), ComparisonOperator.EQ, checkNotNull(value));
    }

    /**
     * Returns a not-equals filter for the given field and string value. For string fields,
     * {@code value} is interpreted as a regular expression using RE2 syntax. {@code value} must
     * match the entire field.
     *
     * @see <a href="https://github.com/google/re2/wiki/Syntax">RE2</a>
     */
    public static SnapshotFilter notEquals(SnapshotField field, String value) {
      return new SnapshotFilter(checkNotNull(field), ComparisonOperator.NE, checkNotNull(value));
    }

    /**
     * Returns an equals filter for the given field and long value.
     */
    public static SnapshotFilter equals(SnapshotField field, long value) {
      return new SnapshotFilter(checkNotNull(field), ComparisonOperator.EQ, value);
    }

    /**
     * Returns a not-equals filter for the given field and long value.
     */
    public static SnapshotFilter notEquals(SnapshotField field, long value) {
      return new SnapshotFilter(checkNotNull(field), ComparisonOperator.NE, value);
    }
  }

  /**
   * Class for filtering image lists.
   */
  class ImageFilter extends ListFilter {

    private static final long serialVersionUID = -3601427417234098397L;

    private ImageFilter(ImageField field, ComparisonOperator operator, Object value) {
      super(field.selector(), operator, value);
    }

    /**
     * Returns an equals filter for the given field and string value. For string fields,
     * {@code value} is interpreted as a regular expression using RE2 syntax. {@code value} must
     * match the entire field.
     *
     * @see <a href="https://github.com/google/re2/wiki/Syntax">RE2</a>
     */
    public static ImageFilter equals(ImageField field, String value) {
      return new ImageFilter(checkNotNull(field), ComparisonOperator.EQ, checkNotNull(value));
    }

    /**
     * Returns a not-equals filter for the given field and string value. For string fields,
     * {@code value} is interpreted as a regular expression using RE2 syntax. {@code value} must
     * match the entire field.
     *
     * @see <a href="https://github.com/google/re2/wiki/Syntax">RE2</a>
     */
    public static ImageFilter notEquals(ImageField field, String value) {
      return new ImageFilter(checkNotNull(field), ComparisonOperator.NE, checkNotNull(value));
    }

    /**
     * Returns an equals filter for the given field and long value.
     */
    public static ImageFilter equals(ImageField field, long value) {
      return new ImageFilter(checkNotNull(field), ComparisonOperator.EQ, value);
    }

    /**
     * Returns a not-equals filter for the given field and long value.
     */
    public static ImageFilter notEquals(ImageField field, long value) {
      return new ImageFilter(checkNotNull(field), ComparisonOperator.NE, value);
    }
  }

  /**
   * Class for filtering disk lists.
   */
  class DiskFilter extends ListFilter {

    private static final long serialVersionUID = 5856790665396877913L;

    private DiskFilter(DiskField field, ComparisonOperator operator, Object value) {
      super(field.selector(), operator, value);
    }

    /**
     * Returns an equals filter for the given field and string value. For string fields,
     * {@code value} is interpreted as a regular expression using RE2 syntax. {@code value} must
     * match the entire field.
     *
     * @see <a href="https://github.com/google/re2/wiki/Syntax">RE2</a>
     */
    public static DiskFilter equals(DiskField field, String value) {
      return new DiskFilter(checkNotNull(field), ComparisonOperator.EQ, checkNotNull(value));
    }

    /**
     * Returns a not-equals filter for the given field and string value. For string fields,
     * {@code value} is interpreted as a regular expression using RE2 syntax. {@code value} must
     * match the entire field.
     *
     * @see <a href="https://github.com/google/re2/wiki/Syntax">RE2</a>
     */
    public static DiskFilter notEquals(DiskField field, String value) {
      return new DiskFilter(checkNotNull(field), ComparisonOperator.NE, checkNotNull(value));
    }

    /**
     * Returns an equals filter for the given field and long value.
     */
    public static DiskFilter equals(DiskField field, long value) {
      return new DiskFilter(checkNotNull(field), ComparisonOperator.EQ, value);
    }

    /**
     * Returns a not-equals filter for the given field and long value.
     */
    public static DiskFilter notEquals(DiskField field, long value) {
      return new DiskFilter(checkNotNull(field), ComparisonOperator.NE, value);
    }
  }

  /**
   * Class for filtering subnetwork lists.
   */
  class SubnetworkFilter extends ListFilter {

    private static final long serialVersionUID = 979448583739105481L;

    private SubnetworkFilter(SubnetworkField field, ComparisonOperator operator, Object value) {
      super(field.selector(), operator, value);
    }

    /**
     * Returns an equals filter for the given field and string value. For string fields,
     * {@code value} is interpreted as a regular expression using RE2 syntax. {@code value} must
     * match the entire field.
     *
     * @see <a href="https://github.com/google/re2/wiki/Syntax">RE2</a>
     */
    public static SubnetworkFilter equals(SubnetworkField field, String value) {
      return new SubnetworkFilter(checkNotNull(field), ComparisonOperator.EQ, checkNotNull(value));
    }

    /**
     * Returns a not-equals filter for the given field and string value. For string fields,
     * {@code value} is interpreted as a regular expression using RE2 syntax. {@code value} must
     * match the entire field.
     *
     * @see <a href="https://github.com/google/re2/wiki/Syntax">RE2</a>
     */
    public static SubnetworkFilter notEquals(SubnetworkField field, String value) {
      return new SubnetworkFilter(checkNotNull(field), ComparisonOperator.NE, checkNotNull(value));
    }
  }

  /**
   * Class for filtering network lists.
   */
  class NetworkFilter extends ListFilter {

    private static final long serialVersionUID = 7921406498804130930L;

    private NetworkFilter(NetworkField field, ComparisonOperator operator, Object value) {
      super(field.selector(), operator, value);
    }

    /**
     * Returns an equals filter for the given field and string value. For string fields,
     * {@code value} is interpreted as a regular expression using RE2 syntax. {@code value} must
     * match the entire field.
     *
     * @see <a href="https://github.com/google/re2/wiki/Syntax">RE2</a>
     */
    public static NetworkFilter equals(NetworkField field, String value) {
      return new NetworkFilter(checkNotNull(field), ComparisonOperator.EQ, checkNotNull(value));
    }

    /**
     * Returns a not-equals filter for the given field and string value. For string fields,
     * {@code value} is interpreted as a regular expression using RE2 syntax. {@code value} must
     * match the entire field.
     *
     * @see <a href="https://github.com/google/re2/wiki/Syntax">RE2</a>
     */
    public static NetworkFilter notEquals(NetworkField field, String value) {
      return new NetworkFilter(checkNotNull(field), ComparisonOperator.NE, checkNotNull(value));
    }

    /**
     * Returns a equals filter for the given field and boolean value.
     */
    public static NetworkFilter equals(NetworkField field, boolean value) {
      return new NetworkFilter(checkNotNull(field), ComparisonOperator.EQ, value);
    }

    /**
     * Returns a not-equals filter for the given field and boolean value.
     */
    public static NetworkFilter notEquals(NetworkField field, boolean value) {
      return new NetworkFilter(checkNotNull(field), ComparisonOperator.NE, value);
    }
  }

  /**
   * Class for filtering instance lists.
   */
  class InstanceFilter extends ListFilter {

    private static final long serialVersionUID = 679008888882025686L;

    private InstanceFilter(InstanceField field, ComparisonOperator operator, Object value) {
      super(field.selector(), operator, value);
    }

    /**
     * Returns an equals filter for the given field and string value. For string fields,
     * {@code value} is interpreted as a regular expression using RE2 syntax. {@code value} must
     * match the entire field.
     *
     * @see <a href="https://github.com/google/re2/wiki/Syntax">RE2</a>
     */
    public static InstanceFilter equals(InstanceField field, String value) {
      return new InstanceFilter(checkNotNull(field), ComparisonOperator.EQ, checkNotNull(value));
    }

    /**
     * Returns a not-equals filter for the given field and string value. For string fields,
     * {@code value} is interpreted as a regular expression using RE2 syntax. {@code value} must
     * match the entire field.
     *
     * @see <a href="https://github.com/google/re2/wiki/Syntax">RE2</a>
     */
    public static InstanceFilter notEquals(InstanceField field, String value) {
      return new InstanceFilter(checkNotNull(field), ComparisonOperator.NE, checkNotNull(value));
    }

    /**
     * Returns a equals filter for the given field and boolean value.
     */
    public static InstanceFilter equals(InstanceField field, boolean value) {
      return new InstanceFilter(checkNotNull(field), ComparisonOperator.EQ, value);
    }

    /**
     * Returns a not-equals filter for the given field and boolean value.
     */
    public static InstanceFilter notEquals(InstanceField field, boolean value) {
      return new InstanceFilter(checkNotNull(field), ComparisonOperator.EQ, value);
    }
  }

  /**
   * Class for specifying disk type get options.
   */
  class DiskTypeOption extends Option {

    private static final long serialVersionUID = 7349162455602991554L;

    private DiskTypeOption(ComputeRpc.Option option, Object value) {
      super(option, value);
    }

    /**
     * Returns an option to specify the disk type's fields to be returned by the RPC call. If this
     * option is not provided, all disk type's fields are returned. {@code DiskTypeOption.fields}
     * can be used to specify only the fields of interest. {@link DiskType#diskTypeId()} is always
     * returned, even if not specified.
     */
    public static DiskTypeOption fields(DiskTypeField... fields) {
      return new DiskTypeOption(ComputeRpc.Option.FIELDS,
          Helper.selector(DiskTypeField.REQUIRED_FIELDS, fields));
    }
  }

  /**
   * Class for specifying disk type list options.
   */
  class DiskTypeListOption extends Option {

    private static final long serialVersionUID = 9051194230847610951L;

    private DiskTypeListOption(ComputeRpc.Option option, Object value) {
      super(option, value);
    }

    /**
     * Returns an option to specify a filter on the disk types being listed.
     */
    public static DiskTypeListOption filter(DiskTypeFilter filter) {
      return new DiskTypeListOption(ComputeRpc.Option.FILTER, filter.toPb());
    }

    /**
     * Returns an option to specify the maximum number of disk types returned per page.
     * {@code pageSize} must be between 0 and 500 (inclusive). If not specified 500 is used.
     */
    public static DiskTypeListOption pageSize(long pageSize) {
      return new DiskTypeListOption(ComputeRpc.Option.MAX_RESULTS, pageSize);
    }

    /**
     * Returns an option to specify the page token from which to start listing disk types.
     */
    public static DiskTypeListOption pageToken(String pageToken) {
      return new DiskTypeListOption(ComputeRpc.Option.PAGE_TOKEN, pageToken);
    }

    /**
     * Returns an option to specify the disk type's fields to be returned by the RPC call. If this
     * option is not provided, all disk type's fields are returned.
     * {@code DiskTypeListOption.fields} can be used to specify only the fields of interest.
     * {@link DiskType#diskTypeId()} is always returned, even if not specified.
     */
    public static DiskTypeListOption fields(DiskTypeField... fields) {
      return new DiskTypeListOption(ComputeRpc.Option.FIELDS,
          Helper.listSelector("items", DiskTypeField.REQUIRED_FIELDS, fields));
    }
  }

  /**
   * Class for specifying disk type aggregated list options.
   */
  class DiskTypeAggregatedListOption extends Option {

    private static final long serialVersionUID = 7611137483018305170L;

    private DiskTypeAggregatedListOption(ComputeRpc.Option option, Object value) {
      super(option, value);
    }

    /**
     * Returns an option to specify a filter on the disk types being listed.
     */
    public static DiskTypeAggregatedListOption filter(DiskTypeFilter filter) {
      return new DiskTypeAggregatedListOption(ComputeRpc.Option.FILTER, filter.toPb());
    }

    /**
     * Returns an option to specify the maximum number of disk types returned per page.
     * {@code pageSize} must be between 0 and 500 (inclusive). If not specified 500 is used.
     */
    public static DiskTypeAggregatedListOption pageSize(long pageSize) {
      return new DiskTypeAggregatedListOption(ComputeRpc.Option.MAX_RESULTS, pageSize);
    }

    /**
     * Returns an option to specify the page token from which to start listing disk types.
     */
    public static DiskTypeAggregatedListOption pageToken(String pageToken) {
      return new DiskTypeAggregatedListOption(ComputeRpc.Option.PAGE_TOKEN, pageToken);
    }
  }

  /**
   * Class for specifying machine type get options.
   */
  class MachineTypeOption extends Option {

    private static final long serialVersionUID = 7349162455602991554L;

    private MachineTypeOption(ComputeRpc.Option option, Object value) {
      super(option, value);
    }

    /**
     * Returns an option to specify the machine type's fields to be returned by the RPC call. If
     * this option is not provided, all machine type's fields are returned.
     * {@code MachineTypeOption.fields} can be used to specify only the fields of interest.
     * {@link MachineType#machineTypeId()} is always returned, even if not specified.
     */
    public static MachineTypeOption fields(MachineTypeField... fields) {
      return new MachineTypeOption(ComputeRpc.Option.FIELDS,
          Helper.selector(MachineTypeField.REQUIRED_FIELDS, fields));
    }
  }

  /**
   * Class for specifying machine type list options.
   */
  class MachineTypeListOption extends Option {

    private static final long serialVersionUID = -2974553049419897902L;

    private MachineTypeListOption(ComputeRpc.Option option, Object value) {
      super(option, value);
    }

    /**
     * Returns an option to specify a filter on the machine types being listed.
     */
    public static MachineTypeListOption filter(MachineTypeFilter filter) {
      return new MachineTypeListOption(ComputeRpc.Option.FILTER, filter.toPb());
    }

    /**
     * Returns an option to specify the maximum number of machine types returned per page.
     * {@code pageSize} must be between 0 and 500 (inclusive). If not specified 500 is used.
     */
    public static MachineTypeListOption pageSize(long pageSize) {
      return new MachineTypeListOption(ComputeRpc.Option.MAX_RESULTS, pageSize);
    }

    /**
     * Returns an option to specify the page token from which to start listing machine types.
     */
    public static MachineTypeListOption pageToken(String pageToken) {
      return new MachineTypeListOption(ComputeRpc.Option.PAGE_TOKEN, pageToken);
    }

    /**
     * Returns an option to specify the machine type's fields to be returned by the RPC call. If
     * this option is not provided, all machine type's fields are returned.
     * {@code MachineTypeListOption.fields} can be used to specify only the fields of interest.
     * {@link MachineType#machineTypeId()} is always returned, even if not specified.
     */
    public static MachineTypeListOption fields(MachineTypeField... fields) {
      return new MachineTypeListOption(ComputeRpc.Option.FIELDS,
          Helper.listSelector("items", MachineTypeField.REQUIRED_FIELDS, fields));
    }
  }

  /**
   * Class for specifying machine type aggregated list options.
   */
  class MachineTypeAggregatedListOption extends Option {

    private static final long serialVersionUID = 8492257475500296057L;

    private MachineTypeAggregatedListOption(ComputeRpc.Option option, Object value) {
      super(option, value);
    }

    /**
     * Returns an option to specify a filter on the machine types being listed.
     */
    public static MachineTypeAggregatedListOption filter(MachineTypeFilter filter) {
      return new MachineTypeAggregatedListOption(ComputeRpc.Option.FILTER, filter.toPb());
    }

    /**
     * Returns an option to specify the maximum number of machine types returned per page.
     * {@code pageSize} must be between 0 and 500 (inclusive). If not specified 500 is used.
     */
    public static MachineTypeAggregatedListOption pageSize(long pageSize) {
      return new MachineTypeAggregatedListOption(ComputeRpc.Option.MAX_RESULTS, pageSize);
    }

    /**
     * Returns an option to specify the page token from which to start listing machine types.
     */
    public static MachineTypeAggregatedListOption pageToken(String pageToken) {
      return new MachineTypeAggregatedListOption(ComputeRpc.Option.PAGE_TOKEN, pageToken);
    }
  }

  /**
   * Class for specifying region get options.
   */
  class RegionOption extends Option {

    private static final long serialVersionUID = 2025084807788610826L;

    private RegionOption(ComputeRpc.Option option, Object value) {
      super(option, value);
    }

    /**
     * Returns an option to specify the region's fields to be returned by the RPC call. If this
     * option is not provided, all region's fields are returned. {@code RegionOption.fields} can be
     * used to specify only the fields of interest. {@link Region#regionId()} is always
     * returned, even if not specified.
     */
    public static RegionOption fields(RegionField... fields) {
      return new RegionOption(ComputeRpc.Option.FIELDS,
          Helper.selector(RegionField.REQUIRED_FIELDS, fields));
    }
  }

  /**
   * Class for specifying region list options.
   */
  class RegionListOption extends Option {

    private static final long serialVersionUID = 3348089279267170211L;

    private RegionListOption(ComputeRpc.Option option, Object value) {
      super(option, value);
    }

    /**
     * Returns an option to specify a filter on the regions being listed.
     */
    public static RegionListOption filter(RegionFilter filter) {
      return new RegionListOption(ComputeRpc.Option.FILTER, filter.toPb());
    }

    /**
     * Returns an option to specify the maximum number of regions returned per page.
     * {@code pageSize} must be between 0 and 500 (inclusive). If not specified 500 is used.
     */
    public static RegionListOption pageSize(long pageSize) {
      return new RegionListOption(ComputeRpc.Option.MAX_RESULTS, pageSize);
    }

    /**
     * Returns an option to specify the page token from which to start listing regions.
     */
    public static RegionListOption pageToken(String pageToken) {
      return new RegionListOption(ComputeRpc.Option.PAGE_TOKEN, pageToken);
    }

    /**
     * Returns an option to specify the region's fields to be returned by the RPC call. If this
     * option is not provided, all region's fields are returned. {@code RegionListOption.fields} can
     * be used to specify only the fields of interest. {@link Region#regionId()} is always
     * returned, even if not specified.
     */
    public static RegionListOption fields(RegionField... fields) {
      return new RegionListOption(ComputeRpc.Option.FIELDS,
          Helper.listSelector("items", RegionField.REQUIRED_FIELDS, fields));
    }
  }

  /**
   * Class for specifying zone get options.
   */
  class ZoneOption extends Option {

    private static final long serialVersionUID = -2968652076389846258L;

    private ZoneOption(ComputeRpc.Option option, Object value) {
      super(option, value);
    }

    /**
     * Returns an option to specify the zone's fields to be returned by the RPC call. If this option
     * is not provided, all zone's fields are returned. {@code ZoneOption.fields} can be used to
     * specify only the fields of interest. {@link Zone#zoneId()} is always returned, even if
     * not specified.
     */
    public static ZoneOption fields(ZoneField... fields) {
      return new ZoneOption(ComputeRpc.Option.FIELDS,
          Helper.selector(ZoneField.REQUIRED_FIELDS, fields));
    }
  }

  /**
   * Class for specifying zone list options.
   */
  class ZoneListOption extends Option {

    private static final long serialVersionUID = -4721971371200905764L;

    private ZoneListOption(ComputeRpc.Option option, Object value) {
      super(option, value);
    }

    /**
     * Returns an option to specify a filter on the zones being listed.
     */
    public static ZoneListOption filter(ZoneFilter filter) {
      return new ZoneListOption(ComputeRpc.Option.FILTER, filter.toPb());
    }

    /**
     * Returns an option to specify the maximum number of zones returned per page.
     * {@code pageSize} must be between 0 and 500 (inclusive). If not specified 500 is used.
     */
    public static ZoneListOption pageSize(long pageSize) {
      return new ZoneListOption(ComputeRpc.Option.MAX_RESULTS, pageSize);
    }

    /**
     * Returns an option to specify the page token from which to start listing zones.
     */
    public static ZoneListOption pageToken(String pageToken) {
      return new ZoneListOption(ComputeRpc.Option.PAGE_TOKEN, pageToken);
    }

    /**
     * Returns an option to specify the zone's fields to be returned by the RPC call. If this option
     * is not provided, all zone's fields are returned. {@code ZoneListOption.fields} can be used to
     * specify only the fields of interest. {@link Zone#zoneId()} is always returned, even if
     * not specified.
     */
    public static ZoneListOption fields(ZoneField... fields) {
      return new ZoneListOption(ComputeRpc.Option.FIELDS,
          Helper.listSelector("items", ZoneField.REQUIRED_FIELDS, fields));
    }
  }

  /**
   * Class for specifying license get options.
   */
  class LicenseOption extends Option {

    private static final long serialVersionUID = -2968652076389846258L;

    private LicenseOption(ComputeRpc.Option option, Object value) {
      super(option, value);
    }

    /**
     * Returns an option to specify the license's fields to be returned by the RPC call. If this
     * option is not provided, all license's fields are returned. {@code LicenseOption.fields} can
     * be used to specify only the fields of interest. {@link License#licenseId()} is always
     * returned, even if not specified.
     */
    public static LicenseOption fields(LicenseField... fields) {
      return new LicenseOption(ComputeRpc.Option.FIELDS,
          Helper.selector(LicenseField.REQUIRED_FIELDS, fields));
    }
  }

  /**
   * Class for specifying operation get options.
   */
  class OperationOption extends Option {

    private static final long serialVersionUID = -4572636917684779912L;

    private OperationOption(ComputeRpc.Option option, Object value) {
      super(option, value);
    }

    /**
     * Returns an option to specify the operation's fields to be returned by the RPC call. If this
     * option is not provided, all operation's fields are returned. {@code OperationOption.fields}
     * can be used to specify only the fields of interest. {@link Operation#operationId()} is
     * always returned, even if not specified.
     */
    public static OperationOption fields(OperationField... fields) {
      return new OperationOption(ComputeRpc.Option.FIELDS,
          Helper.selector(OperationField.REQUIRED_FIELDS, fields));
    }
  }

  /**
   * Class for specifying operation list options.
   */
  class OperationListOption extends Option {

    private static final long serialVersionUID = -1509532420587265823L;

    private OperationListOption(ComputeRpc.Option option, Object value) {
      super(option, value);
    }

    /**
     * Returns an option to specify a filter on the operations being listed.
     */
    public static OperationListOption filter(OperationFilter filter) {
      return new OperationListOption(ComputeRpc.Option.FILTER, filter.toPb());
    }

    /**
     * Returns an option to specify the maximum number of operations returned per page.
     * {@code pageSize} must be between 0 and 500 (inclusive). If not specified 500 is used.
     */
    public static OperationListOption pageSize(long pageSize) {
      return new OperationListOption(ComputeRpc.Option.MAX_RESULTS, pageSize);
    }

    /**
     * Returns an option to specify the page token from which to start listing operations.
     */
    public static OperationListOption pageToken(String pageToken) {
      return new OperationListOption(ComputeRpc.Option.PAGE_TOKEN, pageToken);
    }

    /**
     * Returns an option to specify the operation's fields to be returned by the RPC call. If this
     * option is not provided, all operation's fields are returned.
     * {@code OperationListOption.fields} can be used to specify only the fields of interest.
     * {@link Operation#operationId()} is always returned, even if not specified.
     */
    public static OperationListOption fields(OperationField... fields) {
      return new OperationListOption(ComputeRpc.Option.FIELDS,
          Helper.listSelector("items", OperationField.REQUIRED_FIELDS, fields));
    }
  }

  /**
   * Class for specifying address get options.
   */
  class AddressOption extends Option {

    private static final long serialVersionUID = -5755491818692494389L;

    private AddressOption(ComputeRpc.Option option, Object value) {
      super(option, value);
    }

    /**
     * Returns an option to specify the address' fields to be returned by the RPC call. If this
     * option is not provided, all address' fields are returned. {@code AddressOption.fields} can be
     * used to specify only the fields of interest. {@link Address#addressId()} is always
     * returned, even if not specified.
     */
    public static AddressOption fields(AddressField... fields) {
      return new AddressOption(ComputeRpc.Option.FIELDS,
          Helper.selector(AddressField.REQUIRED_FIELDS, fields));
    }
  }

  /**
   * Class for specifying address list options.
   */
  class AddressListOption extends Option {

    private static final long serialVersionUID = -4281322966374929346L;

    private AddressListOption(ComputeRpc.Option option, Object value) {
      super(option, value);
    }

    /**
     * Returns an option to specify a filter on the addresses being listed.
     */
    public static AddressListOption filter(AddressFilter filter) {
      return new AddressListOption(ComputeRpc.Option.FILTER, filter.toPb());
    }

    /**
     * Returns an option to specify the maximum number of addresses returned per page.
     * {@code pageSize} must be between 0 and 500 (inclusive). If not specified 500 is used.
     */
    public static AddressListOption pageSize(long pageSize) {
      return new AddressListOption(ComputeRpc.Option.MAX_RESULTS, pageSize);
    }

    /**
     * Returns an option to specify the page token from which to start listing addresses.
     */
    public static AddressListOption pageToken(String pageToken) {
      return new AddressListOption(ComputeRpc.Option.PAGE_TOKEN, pageToken);
    }

    /**
     * Returns an option to specify the address' fields to be returned by the RPC call. If this
     * option is not provided, all address' fields are returned. {@code AddressListOption.fields}
     * can be used to specify only the fields of interest. {@link Address#addressId()} is always
     * returned, even if not specified.
     */
    public static AddressListOption fields(AddressField... fields) {
      return new AddressListOption(ComputeRpc.Option.FIELDS,
          Helper.listSelector("items", AddressField.REQUIRED_FIELDS, fields));
    }
  }

  /**
   * Class for specifying address aggregated list options.
   */
  class AddressAggregatedListOption extends Option {

    private static final long serialVersionUID = -95538941541279561L;

    private AddressAggregatedListOption(ComputeRpc.Option option, Object value) {
      super(option, value);
    }

    /**
     * Returns an option to specify a filter on the addresses being listed.
     */
    public static AddressAggregatedListOption filter(AddressFilter filter) {
      return new AddressAggregatedListOption(ComputeRpc.Option.FILTER, filter.toPb());
    }

    /**
     * Returns an option to specify the maximum number of addresses returned per page.
     * {@code pageSize} must be between 0 and 500 (inclusive). If not specified 500 is used.
     */
    public static AddressAggregatedListOption pageSize(long pageSize) {
      return new AddressAggregatedListOption(ComputeRpc.Option.MAX_RESULTS, pageSize);
    }

    /**
     * Returns an option to specify the page token from which to start listing addresses.
     */
    public static AddressAggregatedListOption pageToken(String pageToken) {
      return new AddressAggregatedListOption(ComputeRpc.Option.PAGE_TOKEN, pageToken);
    }
  }

  /**
   * Class for specifying snapshot get options.
   */
  class SnapshotOption extends Option {

    private static final long serialVersionUID = -3505179459035500945L;

    private SnapshotOption(ComputeRpc.Option option, Object value) {
      super(option, value);
    }

    /**
     * Returns an option to specify the snapshot's fields to be returned by the RPC call. If this
     * option is not provided, all the snapshot's fields are returned. {@code SnapshotOption.fields}
     * can be used to specify only the fields of interest. {@link Snapshot#snapshotId()} is always
     * returned, even if not specified.
     */
    public static SnapshotOption fields(SnapshotField... fields) {
      return new SnapshotOption(ComputeRpc.Option.FIELDS,
          Helper.selector(SnapshotField.REQUIRED_FIELDS, fields));
    }
  }

  /**
   * Class for specifying snapshot list options.
   */
  class SnapshotListOption extends Option {

    private static final long serialVersionUID = 8278588147660831257L;

    private SnapshotListOption(ComputeRpc.Option option, Object value) {
      super(option, value);
    }

    /**
     * Returns an option to specify a filter on the snapshots being listed.
     */
    public static SnapshotListOption filter(SnapshotFilter filter) {
      return new SnapshotListOption(ComputeRpc.Option.FILTER, filter.toPb());
    }

    /**
     * Returns an option to specify the maximum number of snapshots returned per page.
     * {@code pageSize} must be between 0 and 500 (inclusive). If not specified 500 is used.
     */
    public static SnapshotListOption pageSize(long pageSize) {
      return new SnapshotListOption(ComputeRpc.Option.MAX_RESULTS, pageSize);
    }

    /**
     * Returns an option to specify the page token from which to start listing snapshots.
     */
    public static SnapshotListOption pageToken(String pageToken) {
      return new SnapshotListOption(ComputeRpc.Option.PAGE_TOKEN, pageToken);
    }

    /**
     * Returns an option to specify the snapshot's fields to be returned by the RPC call. If this
     * option is not provided, all the snapshot's fields are returned.
     * {@code SnapshotListOption.fields} can be used to specify only the fields of interest.
     * {@link Snapshot#snapshotId()} is always returned, even if not specified.
     */
    public static SnapshotListOption fields(SnapshotField... fields) {
      return new SnapshotListOption(ComputeRpc.Option.FIELDS,
          Helper.listSelector("items", SnapshotField.REQUIRED_FIELDS, fields));
    }
  }

  /**
   * Class for specifying image get options.
   */
  class ImageOption extends Option {

    private static final long serialVersionUID = -7622190783089299272L;

    private ImageOption(ComputeRpc.Option option, Object value) {
      super(option, value);
    }

    /**
     * Returns an option to specify the image's fields to be returned by the RPC call. If this
     * option is not provided, all image's fields are returned. {@code ImageOption.fields} can be
     * used to specify only the fields of interest. {@link Image#imageId()} and
     * {@link Image#configuration()} are always returned, even if not specified.
     */
    public static ImageOption fields(ImageField... fields) {
      return new ImageOption(ComputeRpc.Option.FIELDS,
          Helper.selector(ImageField.REQUIRED_FIELDS, fields));
    }
  }

  /**
   * Class for specifying image list options.
   */
  class ImageListOption extends Option {

    private static final long serialVersionUID = -4927977224287915654L;

    private ImageListOption(ComputeRpc.Option option, Object value) {
      super(option, value);
    }

    /**
     * Returns an option to specify a filter on the images being listed.
     */
    public static ImageListOption filter(ImageFilter filter) {
      return new ImageListOption(ComputeRpc.Option.FILTER, filter.toPb());
    }

    /**
     * Returns an option to specify the maximum number of images returned per page. {@code pageSize}
     * must be between 0 and 500 (inclusive). If not specified 500 is used.
     */
    public static ImageListOption pageSize(long pageSize) {
      return new ImageListOption(ComputeRpc.Option.MAX_RESULTS, pageSize);
    }

    /**
     * Returns an option to specify the page token from which to start listing images.
     */
    public static ImageListOption pageToken(String pageToken) {
      return new ImageListOption(ComputeRpc.Option.PAGE_TOKEN, pageToken);
    }

    /**
     * Returns an option to specify the image's fields to be returned by the RPC call. If this
     * option is not provided, all image's fields are returned. {@code ImageListOption.fields} can
     * be used to specify only the fields of interest. {@link Image#imageId()} and
     * {@link Image#configuration()} are always returned, even if not specified.
     */
    public static ImageListOption fields(ImageField... fields) {
      return new ImageListOption(ComputeRpc.Option.FIELDS,
          Helper.listSelector("items", ImageField.REQUIRED_FIELDS, fields));
    }
  }

  /**
   * Class for specifying disk get options.
   */
  class DiskOption extends Option {

    private static final long serialVersionUID = -4354796876226661667L;

    private DiskOption(ComputeRpc.Option option, Object value) {
      super(option, value);
    }

    /**
     * Returns an option to specify the disk's fields to be returned by the RPC call. If this option
     * is not provided, all disk's fields are returned. {@code DiskOption.fields} can be used to
     * specify only the fields of interest. {@link Disk#diskId()},
     * {@link DiskConfiguration#diskType()} and either
     * {@link SnapshotDiskConfiguration#sourceSnapshot()} or
     * {@link ImageDiskConfiguration#sourceImage()} are always returned, even if not specified.
     */
    public static DiskOption fields(DiskField... fields) {
      return new DiskOption(ComputeRpc.Option.FIELDS,
          Helper.selector(DiskField.REQUIRED_FIELDS, fields));
    }
  }

  /**
   * Class for specifying disk list options.
   */
  class DiskListOption extends Option {

    private static final long serialVersionUID = -5148497888688645905L;

    private DiskListOption(ComputeRpc.Option option, Object value) {
      super(option, value);
    }

    /**
     * Returns an option to specify a filter on the disks being listed.
     */
    public static DiskListOption filter(DiskFilter filter) {
      return new DiskListOption(ComputeRpc.Option.FILTER, filter.toPb());
    }

    /**
     * Returns an option to specify the maximum number of disks returned per page. {@code pageSize}
     * must be between 0 and 500 (inclusive). If not specified 500 is used.
     */
    public static DiskListOption pageSize(long pageSize) {
      return new DiskListOption(ComputeRpc.Option.MAX_RESULTS, pageSize);
    }

    /**
     * Returns an option to specify the page token from which to start listing disks.
     */
    public static DiskListOption pageToken(String pageToken) {
      return new DiskListOption(ComputeRpc.Option.PAGE_TOKEN, pageToken);
    }

    /**
     * Returns an option to specify the disk's fields to be returned by the RPC call. If this option
     * is not provided, all disk's fields are returned. {@code DiskListOption.fields} can be used to
     * specify only the fields of interest. {@link Disk#diskId()},
     * {@link DiskConfiguration#diskType()} and either
     * {@link SnapshotDiskConfiguration#sourceSnapshot()} or
     * {@link ImageDiskConfiguration#sourceImage()} are always returned, even if not specified.
     */
    public static DiskListOption fields(DiskField... fields) {
      return new DiskListOption(ComputeRpc.Option.FIELDS,
          Helper.listSelector("items", DiskField.REQUIRED_FIELDS, fields));
    }
  }

  /**
   * Class for specifying disk aggregated list options.
   */
  class DiskAggregatedListOption extends Option {

    private static final long serialVersionUID = 1163784797870242766L;

    private DiskAggregatedListOption(ComputeRpc.Option option, Object value) {
      super(option, value);
    }

    /**
     * Returns an option to specify a filter on the disks being listed.
     */
    public static DiskAggregatedListOption filter(DiskFilter filter) {
      return new DiskAggregatedListOption(ComputeRpc.Option.FILTER, filter.toPb());
    }

    /**
     * Returns an option to specify the maximum number of disks returned per page. {@code pageSize}
     * must be between 0 and 500 (inclusive). If not specified 500 is used.
     */
    public static DiskAggregatedListOption pageSize(long pageSize) {
      return new DiskAggregatedListOption(ComputeRpc.Option.MAX_RESULTS, pageSize);
    }

    /**
     * Returns an option to specify the page token from which to start listing disks.
     */
    public static DiskAggregatedListOption pageToken(String pageToken) {
      return new DiskAggregatedListOption(ComputeRpc.Option.PAGE_TOKEN, pageToken);
    }
  }

  /**
   * Class for specifying subnetwork get options.
   */
  class SubnetworkOption extends Option {

    private static final long serialVersionUID = 1994416967962074717L;

    private SubnetworkOption(ComputeRpc.Option option, Object value) {
      super(option, value);
    }

    /**
     * Returns an option to specify the subnetwork's fields to be returned by the RPC call. If this
     * option is not provided, all subnetwork's fields are returned. {@code SubnetworkOption.fields}
     * can be used to specify only the fields of interest. {@link Subnetwork#subnetworkId()} is
     * always returned, even if not specified.
     */
    public static SubnetworkOption fields(SubnetworkField... fields) {
      return new SubnetworkOption(ComputeRpc.Option.FIELDS,
          Helper.selector(SubnetworkField.REQUIRED_FIELDS, fields));
    }
  }

  /**
   * Class for specifying subnetwork list options.
   */
  class SubnetworkListOption extends Option {

    private static final long serialVersionUID = -2978666213373829606L;

    private SubnetworkListOption(ComputeRpc.Option option, Object value) {
      super(option, value);
    }

    /**
     * Returns an option to specify a filter on the subnetworks being listed.
     */
    public static SubnetworkListOption filter(SubnetworkFilter filter) {
      return new SubnetworkListOption(ComputeRpc.Option.FILTER, filter.toPb());
    }

    /**
     * Returns an option to specify the maximum number of subnetworks returned per page.
     * {@code pageSize} must be between 0 and 500 (inclusive). If not specified 500 is used.
     */
    public static SubnetworkListOption pageSize(long pageSize) {
      return new SubnetworkListOption(ComputeRpc.Option.MAX_RESULTS, pageSize);
    }

    /**
     * Returns an option to specify the page token from which to start listing subnetworks.
     */
    public static SubnetworkListOption pageToken(String pageToken) {
      return new SubnetworkListOption(ComputeRpc.Option.PAGE_TOKEN, pageToken);
    }

    /**
     * Returns an option to specify the subnetwork's fields to be returned by the RPC call. If this
     * option is not provided, all subnetwork's fields are returned.
     * {@code SubnetworListkOption.fields} can be used to specify only the fields of interest.
     * {@link Subnetwork#subnetworkId()} is always returned, even if not specified.
     */
    public static SubnetworkListOption fields(SubnetworkField... fields) {
      return new SubnetworkListOption(ComputeRpc.Option.FIELDS,
          Helper.listSelector("items", SubnetworkField.REQUIRED_FIELDS, fields));
    }
  }

  /**
   * Class for specifying subnetwork aggregated list options.
   */
  class SubnetworkAggregatedListOption extends Option {

    private static final long serialVersionUID = -4033514850525545027L;

    private SubnetworkAggregatedListOption(ComputeRpc.Option option, Object value) {
      super(option, value);
    }

    /**
     * Returns an option to specify a filter on the subnetworks being listed.
     */
    public static SubnetworkAggregatedListOption filter(SubnetworkFilter filter) {
      return new SubnetworkAggregatedListOption(ComputeRpc.Option.FILTER, filter.toPb());
    }

    /**
     * Returns an option to specify the maximum number of subnetworks returned per page.
     * {@code pageSize} must be between 0 and 500 (inclusive). If not specified 500 is used.
     */
    public static SubnetworkAggregatedListOption pageSize(long pageSize) {
      return new SubnetworkAggregatedListOption(ComputeRpc.Option.MAX_RESULTS, pageSize);
    }

    /**
     * Returns an option to specify the page token from which to start listing subnetworks.
     */
    public static SubnetworkAggregatedListOption pageToken(String pageToken) {
      return new SubnetworkAggregatedListOption(ComputeRpc.Option.PAGE_TOKEN, pageToken);
    }
  }

  /**
   * Class for specifying network get options.
   */
  class NetworkOption extends Option {

    private static final long serialVersionUID = 5346750551643875754L;

    private NetworkOption(ComputeRpc.Option option, Object value) {
      super(option, value);
    }

    /**
     * Returns an option to specify the network's fields to be returned by the RPC call. If this
     * option is not provided, all network's fields are returned. {@code NetworkOption.fields}
     * can be used to specify only the fields of interest. {@link Network#networkId()} and
     * {@link Network#configuration()} are always returned, even if not specified.
     */
    public static NetworkOption fields(NetworkField... fields) {
      return new NetworkOption(ComputeRpc.Option.FIELDS,
          Helper.selector(NetworkField.REQUIRED_FIELDS, fields));
    }
  }

  /**
   * Class for specifying network list options.
   */
  class NetworkListOption extends Option {

    private static final long serialVersionUID = -4291731916527773896L;

    private NetworkListOption(ComputeRpc.Option option, Object value) {
      super(option, value);
    }

    /**
     * Returns an option to specify a filter on the networks being listed.
     */
    public static NetworkListOption filter(NetworkFilter filter) {
      return new NetworkListOption(ComputeRpc.Option.FILTER, filter.toPb());
    }

    /**
     * Returns an option to specify the maximum number of networks returned per page.
     * {@code pageSize} must be between 0 and 500 (inclusive). If not specified 500 is used.
     */
    public static NetworkListOption pageSize(long pageSize) {
      return new NetworkListOption(ComputeRpc.Option.MAX_RESULTS, pageSize);
    }

    /**
     * Returns an option to specify the page token from which to start listing networks.
     */
    public static NetworkListOption pageToken(String pageToken) {
      return new NetworkListOption(ComputeRpc.Option.PAGE_TOKEN, pageToken);
    }

    /**
     * Returns an option to specify the network's fields to be returned by the RPC call. If this
     * option is not provided, all network's fields are returned. {@code NetworkListOption.fields}
     * can be used to specify only the fields of interest. {@link Network#networkId()} and
     * {@link Network#configuration()} are always returned, even if not specified.
     */
    public static NetworkListOption fields(NetworkField... fields) {
      return new NetworkListOption(ComputeRpc.Option.FIELDS,
          Helper.listSelector("items", NetworkField.REQUIRED_FIELDS, fields));
    }
  }

  /**
   * Class for specifying instance get options.
   */
  class InstanceOption extends Option {

    private static final long serialVersionUID = -5277658025892081493L;

    private InstanceOption(ComputeRpc.Option option, Object value) {
      super(option, value);
    }

    /**
     * Returns an option to specify the instance's fields to be returned by the RPC call. If this
     * option is not provided, all instance's fields are returned. {@code InstanceOption.fields}
     * can be used to specify only the fields of interest. {@link Instance#instanceId()} is always
     * returned, even if not specified.
     */
    public static InstanceOption fields(InstanceField... fields) {
      return new InstanceOption(ComputeRpc.Option.FIELDS,
          Helper.selector(InstanceField.REQUIRED_FIELDS, fields));
    }
  }

  /**
   * Class for specifying instance list options.
   */
  class InstanceListOption extends Option {

    private static final long serialVersionUID = -1096684312959047430L;

    private InstanceListOption(ComputeRpc.Option option, Object value) {
      super(option, value);
    }

    /**
     * Returns an option to specify a filter on the instances being listed.
     */
    public static InstanceListOption filter(InstanceFilter filter) {
      return new InstanceListOption(ComputeRpc.Option.FILTER, filter.toPb());
    }

    /**
     * Returns an option to specify the maximum number of instances returned per page.
     * {@code pageSize} must be between 0 and 500 (inclusive). If not specified 500 is used.
     */
    public static InstanceListOption pageSize(long pageSize) {
      return new InstanceListOption(ComputeRpc.Option.MAX_RESULTS, pageSize);
    }

    /**
     * Returns an option to specify the page token from which to start listing instances.
     */
    public static InstanceListOption pageToken(String pageToken) {
      return new InstanceListOption(ComputeRpc.Option.PAGE_TOKEN, pageToken);
    }

    /**
     * Returns an option to specify the instance's fields to be returned by the RPC call. If this
     * option is not provided, all instance's fields are returned. {@code InstanceListOption.fields}
     * can be used to specify only the fields of interest. {@link Instance#instanceId()} is always
     * returned, even if not specified.
     */
    public static InstanceListOption fields(InstanceField... fields) {
      return new InstanceListOption(ComputeRpc.Option.FIELDS,
          Helper.listSelector("items", InstanceField.REQUIRED_FIELDS, fields));
    }
  }

  /**
   * Class for specifying instance aggregated list options.
   */
  class InstanceAggregatedListOption extends Option {

    private static final long serialVersionUID = -2020005298975967713L;

    private InstanceAggregatedListOption(ComputeRpc.Option option, Object value) {
      super(option, value);
    }

    /**
     * Returns an option to specify a filter on the instances being listed.
     */
    public static InstanceAggregatedListOption filter(InstanceFilter filter) {
      return new InstanceAggregatedListOption(ComputeRpc.Option.FILTER, filter.toPb());
    }

    /**
     * Returns an option to specify the maximum number of instances returned per page.
     * {@code pageSize} must be between 0 and 500 (inclusive). If not specified 500 is used.
     */
    public static InstanceAggregatedListOption pageSize(long pageSize) {
      return new InstanceAggregatedListOption(ComputeRpc.Option.MAX_RESULTS, pageSize);
    }

    /**
     * Returns an option to specify the page token from which to start listing instances.
     */
    public static InstanceAggregatedListOption pageToken(String pageToken) {
      return new InstanceAggregatedListOption(ComputeRpc.Option.PAGE_TOKEN, pageToken);
    }
  }

  /**
   * Returns the requested disk type or {@code null} if not found.
   *
   * @throws ComputeException upon failure
   */
  DiskType getDiskType(DiskTypeId diskTypeId, DiskTypeOption... options);

  /**
   * Returns the requested disk type or {@code null} if not found.
   *
   * @throws ComputeException upon failure
   */
  DiskType getDiskType(String zone, String diskType, DiskTypeOption... options);

  /**
   * Lists the disk types in the provided zone.
   *
   * @throws ComputeException upon failure
   */
  Page<DiskType> listDiskTypes(String zone, DiskTypeListOption... options);

  /**
   * Lists the disk types in all zones.
   *
   * @throws ComputeException upon failure
   */
  Page<DiskType> listDiskTypes(DiskTypeAggregatedListOption... options);

  /**
   * Returns the requested machine type or {@code null} if not found.
   *
   * @throws ComputeException upon failure
   */
  MachineType getMachineType(MachineTypeId machineTypeId, MachineTypeOption... options);

  /**
   * Returns the requested machine type or {@code null} if not found.
   *
   * @throws ComputeException upon failure
   */
  MachineType getMachineType(String zone, String machineType, MachineTypeOption... options);

  /**
   * Lists the machine types in the provided zone.
   *
   * @throws ComputeException upon failure
   */
  Page<MachineType> listMachineTypes(String zone, MachineTypeListOption... options);

  /**
   * Lists the machine types in all zones.
   *
   * @throws ComputeException upon failure
   */
  Page<MachineType> listMachineTypes(MachineTypeAggregatedListOption... options);

  /**
   * Returns the requested region or {@code null} if not found.
   *
   * @throws ComputeException upon failure
   */
  Region getRegion(String region, RegionOption... options);

  /**
   * Lists the regions.
   *
   * @throws ComputeException upon failure
   */
  Page<Region> listRegions(RegionListOption... options);

  /**
   * Returns the requested zone or {@code null} if not found.
   *
   * @throws ComputeException upon failure
   */
  Zone getZone(String zone, ZoneOption... options);

  /**
   * Lists the zones.
   *
   * @throws ComputeException upon failure
   */
  Page<Zone> listZones(ZoneListOption... options);

  /**
   * Returns the requested license or {@code null} if not found.
   *
   * @throws ComputeException upon failure
   */
  License getLicense(String license, LicenseOption... options);

  /**
   * Returns the requested license or {@code null} if not found.
   *
   * @throws ComputeException upon failure
   */
  License getLicense(LicenseId license, LicenseOption... options);

  /**
   * Returns the requested operation or {@code null} if not found.
   *
   * @throws ComputeException upon failure
   */
  Operation getOperation(OperationId operationId, OperationOption... options);

  /**
   * Lists the global operations.
   *
   * @throws ComputeException upon failure
   */
  Page<Operation> listGlobalOperations(OperationListOption... options);

  /**
   * Lists the operations for the provided region. These are operations that create/modify/delete
   * resources that live in a region (e.g. subnetworks).
   *
   * @throws ComputeException upon failure
   */
  Page<Operation> listRegionOperations(String region, OperationListOption... options);

  /**
   * Lists the operations for the provided zone. These are operations that create/modify/delete
   * resources that live in a zone (e.g. instances).
   *
   * @throws ComputeException upon failure
   */
  Page<Operation> listZoneOperations(String zone, OperationListOption... options);

  /**
   * Deletes the requested operation. Delete is only possible for operations that have completed
   * their execution. Any attempt to delete a running operation will fail.
   *
   * @return {@code true} if operation was deleted, {@code false} if it was not found
   * @throws ComputeException upon failure
   */
  boolean deleteOperation(OperationId operation);

  /**
   * Returns the requested address or {@code null} if not found.
   *
   * @throws ComputeException upon failure
   */
  Address getAddress(AddressId addressId, AddressOption... options);

  /**
   * Creates a new address.
   *
   * @return an operation for address' creation
   * @throws ComputeException upon failure
   */
  Operation create(AddressInfo address, OperationOption... options);

  /**
   * Lists the global addresses.
   *
   * @throws ComputeException upon failure
   */
  Page<Address> listGlobalAddresses(AddressListOption... options);

  /**
   * Lists the region addresses for the provided region.
   *
   * @throws ComputeException upon failure
   */
  Page<Address> listRegionAddresses(String region, AddressListOption... options);

  /**
   * Lists both global and region addresses.
   *
   * @throws ComputeException upon failure
   */
  Page<Address> listAddresses(AddressAggregatedListOption... options);

  /**
   * Deletes the requested address.
   *
   * @return an operation if the request was issued correctly, {@code null} if the address was not
   *     found
   * @throws ComputeException upon failure
   */
  Operation deleteAddress(AddressId addressId, OperationOption... options);

  /**
   * Creates a new snapshot.
   *
   * @return a zone operation for snapshot creation
   * @throws ComputeException upon failure
   */
  Operation create(SnapshotInfo snapshot, OperationOption... options);

  /**
   * Returns the requested snapshot or {@code null} if not found.
   *
   * @throws ComputeException upon failure
   */
  Snapshot getSnapshot(String snapshot, SnapshotOption... options);

  /**
   * Lists snapshots.
   *
   * @throws ComputeException upon failure
   */
  Page<Snapshot> listSnapshots(SnapshotListOption... options);

  /**
   * Deletes the requested snapshot. Keep in mind that deleting a single snapshot might not
   * necessarily delete all the data for that snapshot. If any data for the snapshot that is marked
   * for deletion is needed for subsequent snapshots, the data will be moved to the next snapshot.
   *
   * @return a global operation if the request was issued correctly, {@code null} if the snapshot
   *     was not found
   * @throws ComputeException upon failure
   * @see <a href="https://cloud.google.com/compute/docs/disks/persistent-disks#deleting_snapshot">
   *     Deleting a snapshot</a>
   */
  Operation deleteSnapshot(SnapshotId snapshot, OperationOption... options);

  /**
   * Deletes the requested snapshot. Keep in mind that deleting a single snapshot might not
   * necessarily delete all the data for that snapshot. If any data on the snapshot that is marked
   * for deletion is needed for subsequent snapshots, the data will be moved to the next snapshot.
   *
   * @return a global operation if the request was issued correctly, {@code null} if the snapshot
   *     was not found
   * @throws ComputeException upon failure
   * @see <a href="https://cloud.google.com/compute/docs/disks/persistent-disks#deleting_snapshot">
   *     Deleting a snapshot</a>
   */
  Operation deleteSnapshot(String snapshot, OperationOption... options);

  /**
   * Creates a new image.
   *
   * @return a global operation for image's creation
   * @throws ComputeException upon failure
   */
  Operation create(ImageInfo image, OperationOption... options);

  /**
   * Returns the requested image or {@code null} if not found.
   *
   * @throws ComputeException upon failure
   */
  Image getImage(ImageId imageId, ImageOption... options);

  /**
   * Lists images in the provided project that are available to the current user. This method can be
   * used to list publicly-available images by providing the respective image project. Examples of
   * image projects are: {@code centos-cloud}, {@code coreos-cloud}, {@code debian-cloud},
   * {@code opensuse-cloud}, {@code rhel-cloud}, {@code suse-cloud}, {@code ubuntu-os-cloud} and
   * {@code windows-cloud}. Attempting to delete or deprecate a publicly-available image will fail.
   *
   * @throws ComputeException upon failure
   * @see <a href="https://cloud.google.com/compute/docs/operating-systems/">Operating Systems</a>
   */
  Page<Image> listImages(String project, ImageListOption... options);

  /**
   * Lists images in the current project.
   *
   * @throws ComputeException upon failure
   */
  Page<Image> listImages(ImageListOption... options);

  /**
   * Deletes the requested image.
   *
   * @return a global operation if the delete request was issued correctly, {@code null} if the
   *     image was not found
   * @throws ComputeException upon failure or if {@code image} is a publicly-available image
   */
  Operation deleteImage(ImageId image, OperationOption... options);

  /**
   * Deprecates the requested image.
   *
   * @return a global operation if the deprecation request was issued correctly, {@code null} if the
   *     image was not found
   * @throws ComputeException upon failure or if {@code image} is a publicly-available image
   */
  Operation deprecate(ImageId image, DeprecationStatus<ImageId> deprecationStatus,
      OperationOption... options);

  /**
   * Returns the requested disk or {@code null} if not found.
   *
   * @throws ComputeException upon failure
   */
  Disk getDisk(DiskId diskId, DiskOption... options);

  /**
   * Creates a new disk.
   *
   * @return a zone operation for disk's creation
   * @throws ComputeException upon failure
   */
  Operation create(DiskInfo disk, OperationOption... options);

  /**
   * Lists disks for the provided zone.
   *
   * @throws ComputeException upon failure
   */
  Page<Disk> listDisks(String zone, DiskListOption... options);

  /**
   * Lists disks for all zones.
   *
   * @throws ComputeException upon failure
   */
  Page<Disk> listDisks(DiskAggregatedListOption... options);

  /**
   * Deletes the requested disk.
   *
   * @return a zone operation if the request was issued correctly, {@code null} if the disk was not
   *     found
   * @throws ComputeException upon failure
   */
  Operation deleteDisk(DiskId disk, OperationOption... options);

  /**
   * Resizes the disk to the requested size. The new size must be larger than the previous one.
   *
   * @return a zone operation if the request was issued correctly, {@code null} if the disk was not
   *     found
   * @throws ComputeException upon failure or if the new disk size is smaller than the previous one
   */
  Operation resize(DiskId disk, long sizeGb, OperationOption... options);

  /*
   * Creates a new subnetwork.
   *
   * @return a region operation for subnetwork's creation
   * @throws ComputeException upon failure
   */
  Operation create(SubnetworkInfo subnetwork, OperationOption... options);

  /**
   * Returns the requested subnetwork or {@code null} if not found.
   *
   * @throws ComputeException upon failure
   */
  Subnetwork getSubnetwork(SubnetworkId subnetworkId, SubnetworkOption... options);

  /**
   * Lists subnetworks for the provided region.
   *
   * @throws ComputeException upon failure
   */
  Page<Subnetwork> listSubnetworks(String region, SubnetworkListOption... options);

  /**
   * Lists subnetworks for all regions.
   *
   * @throws ComputeException upon failure
   */
  Page<Subnetwork> listSubnetworks(SubnetworkAggregatedListOption... options);

  /**
   * Deletes the requested subnetwork. Any attempt to delete an automatically created subnetwork
   * will fail.
   *
   * @return a region operation if the delete request was issued correctly, {@code null} if the
   *     subnetwork was not found
   * @throws ComputeException upon failure
   */
  Operation deleteSubnetwork(SubnetworkId subnetwork, OperationOption... options);

  /**
   * Creates a new network.
   *
   * @return a global operation for network's creation
   * @throws ComputeException upon failure
   */
  Operation create(NetworkInfo network, OperationOption... options);

  /**
   * Returns the requested network or {@code null} if not found.
   *
   * @throws ComputeException upon failure
   */
  Network getNetwork(String network, NetworkOption... options);

  /**
   * Lists networks.
   *
   * @throws ComputeException upon failure
   */
  Page<Network> listNetworks(NetworkListOption... options);

  /**
   * Deletes the requested network.
   *
   * @return a global operation if the delete request was issued correctly, {@code null} if the
   *     network was not found
   * @throws ComputeException upon failure
   */
  Operation deleteNetwork(String network, OperationOption... options);

  /**
   * Deletes the requested network.
   *
   * @return a global operation if the delete request was issued correctly, {@code null} if the
   *     network was not found
   * @throws ComputeException upon failure
   */
  Operation deleteNetwork(NetworkId network, OperationOption... options);

  /**
   * Creates a new instance.
   *
   * @return a zone operation for instance's creation
   * @throws ComputeException upon failure
   */
  Operation create(InstanceInfo instance, OperationOption... options);

  /**
   * Returns the requested instance or {@code null} if not found.
   *
   * @throws ComputeException upon failure
   */
  Instance getInstance(InstanceId instance, InstanceOption... options);

  /**
   * Lists instances for the provided zone.
   *
   * @throws ComputeException upon failure
   */
  Page<Instance> listInstances(String zone, InstanceListOption... options);

  /**
   * Lists instances for all zones.
   *
   * @throws ComputeException upon failure
   */
  Page<Instance> listInstances(InstanceAggregatedListOption... options);

  /**
   * Deletes the requested instance.
   *
   * @return a zone operation if the delete request was issued correctly, {@code null} if the
   *     instance was not found
   * @throws ComputeException upon failure
   */
  Operation deleteInstance(InstanceId instance, OperationOption... options);

  /**
   * Adds an access configuration to an instance's network interface.
   *
   * @return a zone operation if the add request was issued correctly, {@code null} if the instance
   *     was not found
   * @throws ComputeException upon failure
   */
  Operation addAccessConfig(InstanceId instance, String networkInterface, AccessConfig accessConfig,
      OperationOption... options);

  /**
   * Attaches a persistent disk to an instance given its configuration.
   *
   * @return a zone operation if the attach request was issued correctly, {@code null} if the
   *     instance was not found
   * @throws ComputeException upon failure
   */
  Operation attachDisk(InstanceId instance, PersistentDiskConfiguration configuration,
      OperationOption... options);

  /**
   * Attaches a persistent disk to an instance given the device name and its configuration.
   *
   * @return a zone operation if the attach request was issued correctly, {@code null} if the
   *     instance was not found
   * @throws ComputeException upon failure
   */
  Operation attachDisk(InstanceId instance, String deviceName,
      PersistentDiskConfiguration configuration, OperationOption... options);

  /**
   * Attaches a persistent disk to an instance given the device name, its configuration and the
   * device index.
   *
   * @return a zone operation if the attach request was issued correctly, {@code null} if the
   *     instance was not found
   * @throws ComputeException upon failure
   */
  Operation attachDisk(InstanceId instance, String deviceName,
      PersistentDiskConfiguration configuration, int index, OperationOption... options);

  /**
   * Deletes an access configuration from an instance's network interface.
   *
   * @return a zone operation if the delete request was issued correctly, {@code null} if the
   *     instance was not found
   * @throws ComputeException upon failure
   */
  Operation deleteAccessConfig(InstanceId instance, String networkInterface, String accessConfig,
      OperationOption... options);

  /**
   * Detaches a disk from an instance.
   *
   * @return a zone operation if the detach request was issued correctly, {@code null} if the
   *     instance was not found
   * @throws ComputeException upon failure
   */
  Operation detachDisk(InstanceId instance, String deviceName, OperationOption... options);

  /**
   * Returns the serial port output for the provided instance and port number. {@code port} must be
   * between 1 and 4 (inclusive).
   *
   * @return the serial port output or {@code null} if the instance was not found
   * @throws ComputeException upon failure
   */
  String getSerialPortOutput(InstanceId instance, int port);

  /**
   * Returns the default serial port output for the provided instance. Default serial port
   * corresponds to port number 1.
   *
   * @return the serial port output or {@code null} if the instance was not found
   * @throws ComputeException upon failure
   */
  String getSerialPortOutput(InstanceId instance);

  /**
   * Resets the provided instance.
   *
   * @return a zone operation if the reset request was issued correctly, {@code null} if the
   *     instance was not found
   * @throws ComputeException upon failure
   */
  Operation reset(InstanceId instance, OperationOption... options);

  /**
   * Sets the auto-delete flag for a disk attached to the provided instance.
   *
   * @return a zone operation if the flag setting request was issued correctly, {@code null} if the
   *     instance was not found
   * @throws ComputeException upon failure
   */
  Operation setDiskAutoDelete(InstanceId instance, String deviceName, boolean autoDelete,
      OperationOption... options);

  /**
   * Sets the machine type for the provided instance. Instance must be in
   * {@link InstanceInfo.Status#TERMINATED} state to be able to set its machine type.
   *
   * @return a zone operation if the set request was issued correctly, {@code null} if the instance
   *     was not found
   * @throws ComputeException upon failure
   */
  Operation setMachineType(InstanceId instance, MachineTypeId machineType,
      OperationOption... options);

  /**
   * Sets the metadata for the provided instance.
   *
   * @return a zone operation if the set request was issued correctly, {@code null} if the instance
   *     was not found
   * @throws ComputeException upon failure
   */
  Operation setMetadata(InstanceId instance, Metadata metadata, OperationOption... options);

  /**
   * Sets the scheduling options for the provided instance.
   *
   * @return a zone operation if the set request was issued correctly, {@code null} if the instance
   *     was not found
   * @throws ComputeException upon failure
   */
  Operation setSchedulingOptions(InstanceId instance, SchedulingOptions scheduling,
      OperationOption... options);

  /**
   * Sets the tags for the provided instance.
   *
   * @return a zone operation if the set request was issued correctly, {@code null} if the instance
   *     was not found
   * @throws ComputeException upon failure
   */
  Operation setTags(InstanceId instance, Tags tags, OperationOption... options);

  /**
   * Starts the provided instance.
   *
   * @return a zone operation if the start request was issued correctly, {@code null} if the
   *     instance was not found
   * @throws ComputeException upon failure
   */
  Operation start(InstanceId instance, OperationOption... options);

  /**
   * Stops the provided instance.
   *
   * @return a zone operation if the stop request was issued correctly, {@code null} if the instance
   *     was not found
   * @throws ComputeException upon failure
   */
  Operation stop(InstanceId instance, OperationOption... options);
}
