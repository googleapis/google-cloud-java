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

import com.google.common.base.Joiner;
import com.google.common.collect.Sets;
import com.google.gcloud.Page;
import com.google.gcloud.Service;
import com.google.gcloud.spi.ComputeRpc;

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
    ZONE("zone");

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
    GUEST_CPUS("cpus"),
    ID("id"),
    IMAGE_SPACE_GB("imageSpaceGb"),
    MAXIMUM_PERSISTENT_DISKS("maximumPersistentDisks"),
    MAXIMUM_PERSISTENT_DISKS_SIZE_GB("maximumPersistentDisksSizeGb"),
    MEMORY_MB("memoryMb"),
    NAME("name"),
    SCRATCH_DISKS("scratchDisks"),
    DISK_GB("diskGb"),
    SELF_LINK("selfLink"),
    ZONE("zone");

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
    ZONES("zones");

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
    STATUS("status");

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
   * Class for specifying disk type get options.
   */
  class DiskTypeOption extends Option {

    private static final long serialVersionUID = 7349162455602991554L;

    private DiskTypeOption(ComputeRpc.Option option, Object value) {
      super(option, value);
    }

    /**
     * Returns an option to specify the disk type's fields to be returned by the RPC call. If this
     * option is not provided all disk type's fields are returned. {@code DiskTypeOption.fields} can
     * be used to specify only the fields of interest. {@link DiskType#diskTypeId()} is always
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
     * Returns an option to specify the maximum number of disk types to be returned.
     */
    public static DiskTypeListOption maxResults(long maxResults) {
      return new DiskTypeListOption(ComputeRpc.Option.MAX_RESULTS, maxResults);
    }

    /**
     * Returns an option to specify the page token from which to start listing disk types.
     */
    public static DiskTypeListOption startPageToken(String pageToken) {
      return new DiskTypeListOption(ComputeRpc.Option.PAGE_TOKEN, pageToken);
    }

    /**
     * Returns an option to specify the disk type's fields to be returned by the RPC call. If this
     * option is not provided all disk type's fields are returned. {@code DiskTypeListOption.fields}
     * can be used to specify only the fields of interest. {@link DiskType#diskTypeId()} is always
     * returned, even if not specified.
     */
    public static DiskTypeListOption fields(DiskTypeField... fields) {
      StringBuilder builder = new StringBuilder();
      builder.append("items(").append(DiskTypeField.selector(fields)).append("),nextPageToken");
      return new DiskTypeListOption(ComputeRpc.Option.FIELDS, builder.toString());
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
     * this option is not provided all machine type's fields are returned.
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
     * Returns an option to specify the maximum number of machine types to be returned.
     */
    public static MachineTypeListOption maxResults(long maxResults) {
      return new MachineTypeListOption(ComputeRpc.Option.MAX_RESULTS, maxResults);
    }

    /**
     * Returns an option to specify the page token from which to start listing machine types.
     */
    public static MachineTypeListOption startPageToken(String pageToken) {
      return new MachineTypeListOption(ComputeRpc.Option.PAGE_TOKEN, pageToken);
    }

    /**
     * Returns an option to specify the machine type's fields to be returned by the RPC call. If
     * this option is not provided all machine type's fields are returned.
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
   * Class for specifying region get options.
   */
  class RegionOption extends Option {

    private static final long serialVersionUID = 2025084807788610826L;

    private RegionOption(ComputeRpc.Option option, Object value) {
      super(option, value);
    }

    /**
     * Returns an option to specify the region's fields to be returned by the RPC call. If this
     * option is not provided all region's fields are returned. {@code RegionOption.fields} can be
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
     * Returns an option to specify the maximum number of regions to be returned.
     */
    public static RegionListOption maxResults(long maxResults) {
      return new RegionListOption(ComputeRpc.Option.MAX_RESULTS, maxResults);
    }

    /**
     * Returns an option to specify the page token from which to start listing regions.
     */
    public static RegionListOption startPageToken(String pageToken) {
      return new RegionListOption(ComputeRpc.Option.PAGE_TOKEN, pageToken);
    }

    /**
     * Returns an option to specify the region's fields to be returned by the RPC call. If this
     * option is not provided all region's fields are returned. {@code RegionListOption.fields} can
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
     * is not provided all zone's fields are returned. {@code ZoneOption.fields} can be used to
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
     * Returns an option to specify the maximum number of zones to be returned.
     */
    public static ZoneListOption maxResults(long maxResults) {
      return new ZoneListOption(ComputeRpc.Option.MAX_RESULTS, maxResults);
    }

    /**
     * Returns an option to specify the page token from which to start listing zones.
     */
    public static ZoneListOption startPageToken(String pageToken) {
      return new ZoneListOption(ComputeRpc.Option.PAGE_TOKEN, pageToken);
    }

    /**
     * Returns an option to specify the zone's fields to be returned by the RPC call. If this option
     * is not provided all zone's fields are returned. {@code ZoneListOption.fields} can be used to
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
     * option is not provided all license's fields are returned. {@code LicenseOption.fields} can be
     * used to specify only the fields of interest. {@link License#licenseId()} is always returned,
     * even if not specified.
     */
    public static LicenseOption fields(LicenseField... fields) {
      return new LicenseOption(ComputeRpc.Option.FIELDS, LicenseField.selector(fields));
    }
  }

  /**
   * Returns the requested disk type or {@code null} if not found.
   *
   * @throws ComputeException upon failure
   */
  DiskType getDiskType(DiskTypeId diskTypeId, DiskTypeOption... options) throws ComputeException;

  /**
   * Returns the requested disk type or {@code null} if not found.
   *
   * @throws ComputeException upon failure
   */
  DiskType getDiskType(String zone, String diskType, DiskTypeOption... options)
      throws ComputeException;

  /**
   * Lists the disk types in the provided zone available to the current project.
   *
   * @throws ComputeException upon failure
   */
  Page<DiskType> listDiskTypes(String zone, DiskTypeListOption... options) throws ComputeException;

  /**
   * Lists all disk types available to the current project.
   *
   * @throws ComputeException upon failure
   */
  Page<DiskType> listDiskTypes(DiskTypeListOption... options) throws ComputeException;

  /**
   * Returns the requested machine type or {@code null} if not found.
   *
   * @throws ComputeException upon failure
   */
  MachineType getMachineType(MachineTypeId machineTypeId, MachineTypeOption... options)
      throws ComputeException;

  /**
   * Returns the requested machine type or {@code null} if not found.
   *
   * @throws ComputeException upon failure
   */
  MachineType getMachineType(String zone, String machineType, MachineTypeOption... options)
      throws ComputeException;

  /**
   * Lists the machine types in the provided zone available to the current project.
   *
   * @throws ComputeException upon failure
   */
  Page<MachineType> listMachineTypes(String zone, MachineTypeListOption... options)
      throws ComputeException;

  /**
   * Lists all machine types available to the current project.
   *
   * @throws ComputeException upon failure
   */
  Page<MachineType> listMachineTypes(MachineTypeListOption... options) throws ComputeException;

  /**
   * Returns the requested region or {@code null} if not found.
   *
   * @throws ComputeException upon failure
   */
  Region getRegion(String region, RegionOption... options) throws ComputeException;

  /**
   * Lists the regions available to the current project.
   *
   * @throws ComputeException upon failure
   */
  Page<Region> listRegions(RegionListOption... options) throws ComputeException;

  /**
   * Returns the requested zone or {@code null} if not found.
   *
   * @throws ComputeException upon failure
   */
  Zone getZone(String zone, ZoneOption... options) throws ComputeException;

  /**
   * Lists the zones available to the current project.
   *
   * @throws ComputeException upon failure
   */
  Page<Zone> listZones(ZoneListOption... options) throws ComputeException;

  /**
   * Returns the requested license or {@code null} if not found.
   *
   * @throws ComputeException upon failure
   */
  License getLicense(String license, LicenseOption... options) throws ComputeException;

  /**
   * Returns the requested license or {@code null} if not found.
   *
   * @throws ComputeException upon failure
   */
  License getLicense(LicenseId license, LicenseOption... options) throws ComputeException;
}
