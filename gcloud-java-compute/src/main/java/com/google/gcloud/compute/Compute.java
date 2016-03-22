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

import com.google.common.base.Joiner;
import com.google.common.base.MoreObjects;
import com.google.common.collect.Sets;
import com.google.gcloud.Page;
import com.google.gcloud.Service;
import com.google.gcloud.spi.ComputeRpc;

import java.io.Serializable;
import java.util.Objects;
import java.util.Set;

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
  enum DiskTypeField {
    CREATION_TIMESTAMP("creationTimestamp"),
    DEFAULT_DISK_SIZE_GB("defaultDiskSizeGb"),
    DESCRIPTION("description"),
    ID("id"),
    NAME("name"),
    SELF_LINK("selfLink"),
    VALID_DISK_SIZE("validDiskSize"),
    ZONE("zone"),
    DEPRECATED("deprecated");

    private final String selector;

    DiskTypeField(String selector) {
      this.selector = selector;
    }

    public String selector() {
      return selector;
    }

    static String selector(DiskTypeField... fields) {
      Set<String> fieldStrings = Sets.newHashSetWithExpectedSize(fields.length + 1);
      fieldStrings.add(SELF_LINK.selector());
      for (DiskTypeField field : fields) {
        fieldStrings.add(field.selector());
      }
      return Joiner.on(',').join(fieldStrings);
    }
  }

  /**
   * Fields of a Compute Engine MachineType resource.
   *
   * @see <a href="https://cloud.google.com/compute/docs/reference/latest/machineTypes#resource">
   *     Machine Type Resource</a>
   */
  enum MachineTypeField {
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

    private final String selector;

    MachineTypeField(String selector) {
      this.selector = selector;
    }

    public String selector() {
      return selector;
    }

    static String selector(MachineTypeField... fields) {
      Set<String> fieldStrings = Sets.newHashSetWithExpectedSize(fields.length + 1);
      fieldStrings.add(SELF_LINK.selector());
      for (MachineTypeField field : fields) {
        fieldStrings.add(field.selector());
      }
      return Joiner.on(',').join(fieldStrings);
    }
  }

  /**
   * Fields of a Compute Engine Region resource.
   *
   * @see <a href="https://cloud.google.com/compute/docs/reference/latest/regions#resource">
   *     Region Resource</a>
   */
  enum RegionField {
    CREATION_TIMESTAMP("creationTimestamp"),
    DESCRIPTION("description"),
    ID("id"),
    NAME("name"),
    QUOTAS("quotas"),
    SELF_LINK("selfLink"),
    STATUS("status"),
    ZONES("zones"),
    DEPRECATED("deprecated");

    private final String selector;

    RegionField(String selector) {
      this.selector = selector;
    }

    public String selector() {
      return selector;
    }

    static String selector(RegionField... fields) {
      Set<String> fieldStrings = Sets.newHashSetWithExpectedSize(fields.length + 1);
      fieldStrings.add(SELF_LINK.selector());
      for (RegionField field : fields) {
        fieldStrings.add(field.selector());
      }
      return Joiner.on(',').join(fieldStrings);
    }
  }

  /**
   * Fields of a Compute Engine Zone resource.
   *
   * @see <a href="https://cloud.google.com/compute/docs/reference/latest/zones#resource">Zone
   *     Resource</a>
   */
  enum ZoneField {
    CREATION_TIMESTAMP("creationTimestamp"),
    DESCRIPTION("description"),
    ID("id"),
    MAINTENANCE_WINDOWS("maintenanceWindows"),
    NAME("name"),
    REGION("region"),
    SELF_LINK("selfLink"),
    STATUS("status"),
    DEPRECATED("deprecated");

    private final String selector;

    ZoneField(String selector) {
      this.selector = selector;
    }

    public String selector() {
      return selector;
    }

    static String selector(ZoneField... fields) {
      Set<String> fieldStrings = Sets.newHashSetWithExpectedSize(fields.length + 1);
      fieldStrings.add(SELF_LINK.selector());
      for (ZoneField field : fields) {
        fieldStrings.add(field.selector());
      }
      return Joiner.on(',').join(fieldStrings);
    }
  }

  /**
   * Fields of a Compute Engine License resource.
   *
   * @see <a href="https://cloud.google.com/compute/docs/reference/latest/licenses#resource">License
   *     Resource</a>
   */
  enum LicenseField {
    CHARGES_USE_FEE("chargesUseFee"),
    NAME("name"),
    SELF_LINK("selfLink");

    private final String selector;

    LicenseField(String selector) {
      this.selector = selector;
    }

    public String selector() {
      return selector;
    }

    static String selector(LicenseField... fields) {
      Set<String> fieldStrings = Sets.newHashSetWithExpectedSize(fields.length + 1);
      fieldStrings.add(SELF_LINK.selector());
      for (LicenseField field : fields) {
        fieldStrings.add(field.selector());
      }
      return Joiner.on(',').join(fieldStrings);
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
  enum OperationField {
    CLIENT_OPERATION_ID("clientOperationId"),
    CREATION_TIMESTAMP("creationTimestamp"),
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

    private final String selector;

    OperationField(String selector) {
      this.selector = selector;
    }

    public String selector() {
      return selector;
    }

    static String selector(OperationField... fields) {
      Set<String> fieldStrings = Sets.newHashSetWithExpectedSize(fields.length + 1);
      fieldStrings.add(SELF_LINK.selector());
      for (OperationField field : fields) {
        fieldStrings.add(field.selector());
      }
      return Joiner.on(',').join(fieldStrings);
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
  enum AddressField {
    ADDRESS("address"),
    CREATION_TIMESTAMP("creationTimestamp"),
    DESCRIPTION("description"),
    ID("id"),
    NAME("name"),
    REGION("region"),
    SELF_LINK("selfLink"),
    STATUS("status"),
    USERS("users");

    private final String selector;

    AddressField(String selector) {
      this.selector = selector;
    }

    public String selector() {
      return selector;
    }

    static String selector(AddressField... fields) {
      Set<String> fieldStrings = Sets.newHashSetWithExpectedSize(fields.length + 1);
      fieldStrings.add(SELF_LINK.selector());
      for (AddressField field : fields) {
        fieldStrings.add(field.selector());
      }
      return Joiner.on(',').join(fieldStrings);
    }
  }

  /**
   * Fields of a Compute Engine Disk resource.
   *
   * @see <a href="https://cloud.google.com/compute/docs/reference/latest/disks#resource">Disk
   *     Resource</a>
   */
  enum DiskField {
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

    private final String selector;

    DiskField(String selector) {
      this.selector = selector;
    }

    public String selector() {
      return selector;
    }

    static String selector(DiskField... fields) {
      Set<String> fieldStrings = Sets.newHashSetWithExpectedSize(fields.length + 4);
      fieldStrings.add(SELF_LINK.selector());
      fieldStrings.add(TYPE.selector());
      fieldStrings.add(SOURCE_IMAGE.selector());
      fieldStrings.add(SOURCE_SNAPSHOT.selector());
      for (DiskField field : fields) {
        fieldStrings.add(field.selector());
      }
      return Joiner.on(',').join(fieldStrings);
    }
  }

  /**
   * Fields of a Compute Engine Snapshot resource.
   *
   * @see <a href="https://cloud.google.com/compute/docs/reference/latest/snapshots#resource">
   *     Snapshot Resource</a>
   */
  enum SnapshotField {
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

    private final String selector;

    SnapshotField(String selector) {
      this.selector = selector;
    }

    public String selector() {
      return selector;
    }

    static String selector(SnapshotField... fields) {
      Set<String> fieldStrings = Sets.newHashSetWithExpectedSize(fields.length + 1);
      fieldStrings.add(SELF_LINK.selector());
      for (SnapshotField field : fields) {
        fieldStrings.add(field.selector());
      }
      return Joiner.on(',').join(fieldStrings);
    }
  }

  /**
   * Fields of a Compute Engine Image resource.
   *
   * @see <a href="https://cloud.google.com/compute/docs/reference/latest/images#resource">Image
   *     Resource</a>
   */
  enum ImageField {
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

    private final String selector;

    ImageField(String selector) {
      this.selector = selector;
    }

    public String selector() {
      return selector;
    }

    static String selector(ImageField... fields) {
      Set<String> fieldStrings = Sets.newHashSetWithExpectedSize(fields.length + 3);
      fieldStrings.add(SELF_LINK.selector());
      fieldStrings.add(SOURCE_DISK.selector());
      fieldStrings.add(RAW_DISK.selector());
      for (ImageField field : fields) {
        fieldStrings.add(field.selector());
      }
      return Joiner.on(',').join(fieldStrings);
    }
  }

  /**
   * Fields of a Compute Engine Subnetwork resource.
   *
   * @see <a href="https://cloud.google.com/compute/docs/reference/latest/subnetworks#resource">
   *     Subnetwork Resource</a>
   */
  enum SubnetworkField {
    CREATION_TIMESTAMP("creationTimestamp"),
    DESCRIPTION("description"),
    GATEWAY_ADDRESS("gatewayAddress"),
    ID("id"),
    IP_CIDR_RANGE("ipCidrRange"),
    NAME("name"),
    NETWORK("network"),
    REGION("region"),
    SELF_LINK("selfLink");

    private final String selector;

    SubnetworkField(String selector) {
      this.selector = selector;
    }

    public String selector() {
      return selector;
    }

    static String selector(SubnetworkField... fields) {
      Set<String> fieldStrings = Sets.newHashSetWithExpectedSize(fields.length + 1);
      fieldStrings.add(SELF_LINK.selector());
      for (SubnetworkField field : fields) {
        fieldStrings.add(field.selector());
      }
      return Joiner.on(',').join(fieldStrings);
    }
  }

  /**
   * Fields of a Compute Engine Network resource.
   *
   * @see <a href="https://cloud.google.com/compute/docs/reference/latest/networks#resource">
   *     Network Resource</a>
   */
  enum NetworkField {
    IPV4_RANGE("IPv4Range"),
    AUTO_CREATE_SUBNETWORKS("autoCreateSubnetworks"),
    CREATION_TIMESTAMP("creationTimestamp"),
    DESCRIPTION("description"),
    GATEWAY_IPV4("gatewayIPv4"),
    ID("id"),
    NAME("name"),
    SELF_LINK("selfLink"),
    SUBNETWORKS("subnetworks");

    private final String selector;

    NetworkField(String selector) {
      this.selector = selector;
    }

    public String selector() {
      return selector;
    }

    static String selector(NetworkField... fields) {
      Set<String> fieldStrings = Sets.newHashSetWithExpectedSize(fields.length + 3);
      fieldStrings.add(SELF_LINK.selector());
      fieldStrings.add(IPV4_RANGE.selector());
      fieldStrings.add(AUTO_CREATE_SUBNETWORKS.selector());
      for (NetworkField field : fields) {
        fieldStrings.add(field.selector());
      }
      return Joiner.on(',').join(fieldStrings);
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

    DiskTypeFilter(DiskTypeField field, ComparisonOperator operator, Object value) {
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

    MachineTypeFilter(MachineTypeField field, ComparisonOperator operator, Object value) {
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

    RegionFilter(RegionField field, ComparisonOperator operator, Object value) {
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

    ZoneFilter(ZoneField field, ComparisonOperator operator, Object value) {
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

    OperationFilter(OperationField field, ComparisonOperator operator, Object value) {
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

    AddressFilter(AddressField field, ComparisonOperator operator, Object value) {
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
      return new DiskTypeOption(ComputeRpc.Option.FIELDS, DiskTypeField.selector(fields));
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
      StringBuilder builder = new StringBuilder();
      builder.append("items(").append(DiskTypeField.selector(fields)).append("),nextPageToken");
      return new DiskTypeListOption(ComputeRpc.Option.FIELDS, builder.toString());
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
      return new MachineTypeOption(ComputeRpc.Option.FIELDS, MachineTypeField.selector(fields));
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
      StringBuilder builder = new StringBuilder();
      builder.append("items(").append(MachineTypeField.selector(fields)).append("),nextPageToken");
      return new MachineTypeListOption(ComputeRpc.Option.FIELDS, builder.toString());
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
      return new RegionOption(ComputeRpc.Option.FIELDS, RegionField.selector(fields));
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
      StringBuilder builder = new StringBuilder();
      builder.append("items(").append(RegionField.selector(fields)).append("),nextPageToken");
      return new RegionListOption(ComputeRpc.Option.FIELDS, builder.toString());
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
      return new ZoneOption(ComputeRpc.Option.FIELDS, ZoneField.selector(fields));
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
      StringBuilder builder = new StringBuilder();
      builder.append("items(").append(ZoneField.selector(fields)).append("),nextPageToken");
      return new ZoneListOption(ComputeRpc.Option.FIELDS, builder.toString());
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
      return new LicenseOption(ComputeRpc.Option.FIELDS, LicenseField.selector(fields));
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
      return new OperationOption(ComputeRpc.Option.FIELDS, OperationField.selector(fields));
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
      StringBuilder builder = new StringBuilder();
      builder.append("items(").append(OperationField.selector(fields)).append("),nextPageToken");
      return new OperationListOption(ComputeRpc.Option.FIELDS, builder.toString());
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
      return new AddressOption(ComputeRpc.Option.FIELDS, AddressField.selector(fields));
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
      StringBuilder builder = new StringBuilder();
      builder.append("items(").append(AddressField.selector(fields)).append("),nextPageToken");
      return new AddressListOption(ComputeRpc.Option.FIELDS, builder.toString());
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
   * Lists all disk types.
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
   * Lists all machine types.
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
  Operation get(OperationId operationId, OperationOption... options);

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
  boolean delete(OperationId operation);

  /**
   * Returns the requested address or {@code null} if not found.
   *
   * @throws ComputeException upon failure
   */
  Address get(AddressId addressId, AddressOption... options);

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
   * Lists all addresses.
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
  Operation delete(AddressId addressId, OperationOption... options);
}
