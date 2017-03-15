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

package com.google.cloud.compute.spi;

import static java.net.HttpURLConnection.HTTP_NOT_FOUND;

import com.google.api.client.http.HttpRequestInitializer;
import com.google.api.client.http.HttpTransport;
import com.google.api.client.json.jackson.JacksonFactory;
import com.google.api.services.compute.Compute;
import com.google.api.services.compute.model.AccessConfig;
import com.google.api.services.compute.model.Address;
import com.google.api.services.compute.model.AddressAggregatedList;
import com.google.api.services.compute.model.AddressList;
import com.google.api.services.compute.model.AddressesScopedList;
import com.google.api.services.compute.model.AttachedDisk;
import com.google.api.services.compute.model.DeprecationStatus;
import com.google.api.services.compute.model.Disk;
import com.google.api.services.compute.model.DiskAggregatedList;
import com.google.api.services.compute.model.DiskList;
import com.google.api.services.compute.model.DiskType;
import com.google.api.services.compute.model.DiskTypeAggregatedList;
import com.google.api.services.compute.model.DiskTypeList;
import com.google.api.services.compute.model.DiskTypesScopedList;
import com.google.api.services.compute.model.DisksResizeRequest;
import com.google.api.services.compute.model.DisksScopedList;
import com.google.api.services.compute.model.Image;
import com.google.api.services.compute.model.ImageList;
import com.google.api.services.compute.model.Instance;
import com.google.api.services.compute.model.InstanceAggregatedList;
import com.google.api.services.compute.model.InstanceList;
import com.google.api.services.compute.model.InstancesScopedList;
import com.google.api.services.compute.model.InstancesSetMachineTypeRequest;
import com.google.api.services.compute.model.License;
import com.google.api.services.compute.model.MachineType;
import com.google.api.services.compute.model.MachineTypeAggregatedList;
import com.google.api.services.compute.model.MachineTypeList;
import com.google.api.services.compute.model.MachineTypesScopedList;
import com.google.api.services.compute.model.Metadata;
import com.google.api.services.compute.model.Network;
import com.google.api.services.compute.model.NetworkList;
import com.google.api.services.compute.model.Operation;
import com.google.api.services.compute.model.OperationList;
import com.google.api.services.compute.model.Region;
import com.google.api.services.compute.model.RegionList;
import com.google.api.services.compute.model.Scheduling;
import com.google.api.services.compute.model.SerialPortOutput;
import com.google.api.services.compute.model.Snapshot;
import com.google.api.services.compute.model.SnapshotList;
import com.google.api.services.compute.model.Subnetwork;
import com.google.api.services.compute.model.SubnetworkAggregatedList;
import com.google.api.services.compute.model.SubnetworkList;
import com.google.api.services.compute.model.SubnetworksScopedList;
import com.google.api.services.compute.model.Tags;
import com.google.api.services.compute.model.Zone;
import com.google.api.services.compute.model.ZoneList;
import com.google.cloud.HttpTransportOptions;
import com.google.cloud.compute.ComputeException;
import com.google.cloud.compute.ComputeOptions;
import com.google.common.collect.ImmutableList;
import java.io.IOException;
import java.util.Map;

public class DefaultComputeRpc implements ComputeRpc {

  private final ComputeOptions options;
  private final Compute compute;

  public DefaultComputeRpc(ComputeOptions options) {
    HttpTransportOptions transportOptions = (HttpTransportOptions) options.getTransportOptions();
    HttpTransport transport = transportOptions.getHttpTransportFactory().create();
    HttpRequestInitializer initializer = transportOptions.getHttpRequestInitializer(options);
    this.options = options;
    compute = new Compute.Builder(transport, new JacksonFactory(), initializer)
        .setRootUrl(options.getHost())
        .setApplicationName(options.getApplicationName())
        .build();
  }

  private static ComputeException translate(IOException exception) {
    return new ComputeException(exception);
  }

  @Override
  public DiskType getDiskType(String zone, String diskType, Map<Option, ?> options) {
    try {
      return compute.diskTypes()
          .get(this.options.getProjectId(), zone, diskType)
          .setFields(Option.FIELDS.getString(options))
          .execute();
    } catch (IOException ex) {
      return nullForNotFound(ex);
    }
  }

  @Override
  public Tuple<String, Iterable<DiskType>> listDiskTypes(String zone, Map<Option, ?> options) {
    try {
      DiskTypeList diskTypesList = compute.diskTypes()
          .list(this.options.getProjectId(), zone)
          .setFilter(Option.FILTER.getString(options))
          .setMaxResults(Option.MAX_RESULTS.getLong(options))
          .setPageToken(Option.PAGE_TOKEN.getString(options))
          .setFields(Option.FIELDS.getString(options))
          .execute();
      Iterable<DiskType> diskTypes = diskTypesList.getItems();
      return Tuple.of(diskTypesList.getNextPageToken(), diskTypes);
    } catch (IOException ex) {
      throw translate(ex);
    }
  }

  @Override
  public Tuple<String, Iterable<DiskType>> listDiskTypes(Map<Option, ?> options) {
    try {
      DiskTypeAggregatedList aggregatedList = compute.diskTypes()
          .aggregatedList(this.options.getProjectId())
          .setFilter(Option.FILTER.getString(options))
          .setMaxResults(Option.MAX_RESULTS.getLong(options))
          .setPageToken(Option.PAGE_TOKEN.getString(options))
          // todo(mziccard): uncomment or remove once #711 is closed
          // .setFields(FIELDS.getString(options))
          .execute();
      ImmutableList.Builder<DiskType> builder = ImmutableList.builder();
      Map<String, DiskTypesScopedList> scopedList = aggregatedList.getItems();
      if (scopedList != null) {
        for (DiskTypesScopedList diskTypesScopedList : scopedList.values()) {
          if (diskTypesScopedList.getDiskTypes() != null) {
            builder.addAll(diskTypesScopedList.getDiskTypes());
          }
        }
      }
      return Tuple.<String, Iterable<DiskType>>of(aggregatedList.getNextPageToken(),
          builder.build());
    } catch (IOException ex) {
      throw translate(ex);
    }
  }

  @Override
  public MachineType getMachineType(String zone, String machineType, Map<Option, ?> options) {
    try {
      return compute.machineTypes()
          .get(this.options.getProjectId(), zone, machineType)
          .setFields(Option.FIELDS.getString(options))
          .execute();
    } catch (IOException ex) {
      return nullForNotFound(ex);
    }
  }

  @Override
  public Tuple<String, Iterable<MachineType>> listMachineTypes(String zone,
      Map<Option, ?> options) {
    try {
      MachineTypeList machineTypesList = compute.machineTypes()
          .list(this.options.getProjectId(), zone)
          .setFilter(Option.FILTER.getString(options))
          .setMaxResults(Option.MAX_RESULTS.getLong(options))
          .setPageToken(Option.PAGE_TOKEN.getString(options))
          .setFields(Option.FIELDS.getString(options))
          .execute();
      Iterable<MachineType> machineTypes = machineTypesList.getItems();
      return Tuple.of(machineTypesList.getNextPageToken(), machineTypes);
    } catch (IOException ex) {
      throw translate(ex);
    }
  }

  @Override
  public Tuple<String, Iterable<MachineType>> listMachineTypes(Map<Option, ?> options) {
    try {
      MachineTypeAggregatedList aggregatedList = compute.machineTypes()
          .aggregatedList(this.options.getProjectId())
          .setFilter(Option.FILTER.getString(options))
          .setMaxResults(Option.MAX_RESULTS.getLong(options))
          .setPageToken(Option.PAGE_TOKEN.getString(options))
          // todo(mziccard): uncomment or remove once #711 is closed
          // .setFields(FIELDS.getString(options))
          .execute();
      ImmutableList.Builder<MachineType> builder = ImmutableList.builder();
      Map<String, MachineTypesScopedList> scopedList = aggregatedList.getItems();
      if (scopedList != null) {
        for (MachineTypesScopedList machineTypesScopedList : scopedList.values()) {
          if (machineTypesScopedList.getMachineTypes() != null) {
            builder.addAll(machineTypesScopedList.getMachineTypes());
          }
        }
      }
      return Tuple.<String, Iterable<MachineType>>of(aggregatedList.getNextPageToken(),
          builder.build());
    } catch (IOException ex) {
      throw translate(ex);
    }
  }

  @Override
  public Region getRegion(String region, Map<Option, ?> options) {
    try {
      return compute.regions()
          .get(this.options.getProjectId(), region)
          .setFields(Option.FIELDS.getString(options))
          .execute();
    } catch (IOException ex) {
      return nullForNotFound(ex);
    }
  }

  @Override
  public Tuple<String, Iterable<Region>> listRegions(Map<Option, ?> options) {
    try {
      RegionList regionsList = compute.regions()
          .list(this.options.getProjectId())
          .setFilter(Option.FILTER.getString(options))
          .setMaxResults(Option.MAX_RESULTS.getLong(options))
          .setPageToken(Option.PAGE_TOKEN.getString(options))
          .setFields(Option.FIELDS.getString(options))
          .execute();
      Iterable<Region> regions = regionsList.getItems();
      return Tuple.of(regionsList.getNextPageToken(), regions);
    } catch (IOException ex) {
      throw translate(ex);
    }
  }

  @Override
  public Zone getZone(String zone, Map<Option, ?> options) {
    try {
      return compute.zones()
          .get(this.options.getProjectId(), zone)
          .setFields(Option.FIELDS.getString(options))
          .execute();
    } catch (IOException ex) {
      return nullForNotFound(ex);
    }
  }

  @Override
  public Tuple<String, Iterable<Zone>> listZones(Map<Option, ?> options) {
    try {
      ZoneList zonesList = compute.zones()
          .list(this.options.getProjectId())
          .setFilter(Option.FILTER.getString(options))
          .setMaxResults(Option.MAX_RESULTS.getLong(options))
          .setPageToken(Option.PAGE_TOKEN.getString(options))
          .setFields(Option.FIELDS.getString(options))
          .execute();
      Iterable<Zone> zones = zonesList.getItems();
      return Tuple.of(zonesList.getNextPageToken(), zones);
    } catch (IOException ex) {
      throw translate(ex);
    }
  }

  @Override
  public License getLicense(String project, String license, Map<Option, ?> options) {
    try {
      return compute.licenses()
          .get(project, license)
          .setFields(Option.FIELDS.getString(options))
          .execute();
    } catch (IOException ex) {
      return nullForNotFound(ex);
    }
  }

  @Override
  public Operation getGlobalOperation(String operation, Map<Option, ?> options) {
    try {
      return compute.globalOperations()
          .get(this.options.getProjectId(), operation)
          .setFields(Option.FIELDS.getString(options))
          .execute();
    } catch (IOException ex) {
      return nullForNotFound(ex);
    }
  }

  @Override
  public Tuple<String, Iterable<Operation>> listGlobalOperations(Map<Option, ?> options) {
    try {
      OperationList operationsList = compute.globalOperations()
          .list(this.options.getProjectId())
          .setFilter(Option.FILTER.getString(options))
          .setMaxResults(Option.MAX_RESULTS.getLong(options))
          .setPageToken(Option.PAGE_TOKEN.getString(options))
          .setFields(Option.FIELDS.getString(options))
          .execute();
      Iterable<Operation> operations = operationsList.getItems();
      return Tuple.of(operationsList.getNextPageToken(), operations);
    } catch (IOException ex) {
      throw translate(ex);
    }
  }

  @Override
  public boolean deleteGlobalOperation(String operation) {
    try {
      compute.globalOperations().delete(this.options.getProjectId(), operation).execute();
      return true;
    } catch (IOException ex) {
      return falseForNotFound(ex);
    }
  }

  @Override
  public Operation getRegionOperation(String region, String operation, Map<Option, ?> options) {
    try {
      return compute.regionOperations()
          .get(this.options.getProjectId(), region, operation)
          .setFields(Option.FIELDS.getString(options))
          .execute();
    } catch (IOException ex) {
      return nullForNotFound(ex);
    }
  }

  @Override
  public Tuple<String, Iterable<Operation>> listRegionOperations(String region,
      Map<Option, ?> options) {
    try {
      OperationList operationsList = compute.regionOperations()
          .list(this.options.getProjectId(), region)
          .setFilter(Option.FILTER.getString(options))
          .setMaxResults(Option.MAX_RESULTS.getLong(options))
          .setPageToken(Option.PAGE_TOKEN.getString(options))
          .setFields(Option.FIELDS.getString(options))
          .execute();
      Iterable<Operation> operations = operationsList.getItems();
      return Tuple.of(operationsList.getNextPageToken(), operations);
    } catch (IOException ex) {
      throw translate(ex);
    }
  }

  @Override
  public boolean deleteRegionOperation(String region, String operation) {
    try {
      compute.regionOperations().delete(this.options.getProjectId(), region, operation).execute();
      return true;
    } catch (IOException ex) {
      return falseForNotFound(ex);
    }
  }

  @Override
  public Operation getZoneOperation(String zone, String operation, Map<Option, ?> options) {
    try {
      return compute.zoneOperations()
          .get(this.options.getProjectId(), zone, operation)
          .setFields(Option.FIELDS.getString(options))
          .execute();
    } catch (IOException ex) {
      return nullForNotFound(ex);
    }
  }

  @Override
  public Tuple<String, Iterable<Operation>> listZoneOperations(String zone,
      Map<Option, ?> options) {
    try {
      OperationList operationsList = compute.zoneOperations()
          .list(this.options.getProjectId(), zone)
          .setFilter(Option.FILTER.getString(options))
          .setMaxResults(Option.MAX_RESULTS.getLong(options))
          .setPageToken(Option.PAGE_TOKEN.getString(options))
          .setFields(Option.FIELDS.getString(options))
          .execute();
      Iterable<Operation> operations = operationsList.getItems();
      return Tuple.of(operationsList.getNextPageToken(), operations);
    } catch (IOException ex) {
      throw translate(ex);
    }
  }

  @Override
  public boolean deleteZoneOperation(String zone, String operation) {
    try {
      compute.zoneOperations().delete(this.options.getProjectId(), zone, operation).execute();
      return true;
    } catch (IOException ex) {
      return falseForNotFound(ex);
    }
  }

  @Override
  public Address getGlobalAddress(String address, Map<Option, ?> options) {
    try {
      return compute.globalAddresses()
          .get(this.options.getProjectId(), address)
          .setFields(Option.FIELDS.getString(options))
          .execute();
    } catch (IOException ex) {
      return nullForNotFound(ex);
    }
  }

  @Override
  public Operation createGlobalAddress(Address address, Map<Option, ?> options) {
    try {
      return compute.globalAddresses()
          .insert(this.options.getProjectId(), address)
          .setFields(Option.FIELDS.getString(options))
          .execute();
    } catch (IOException ex) {
      throw translate(ex);
    }
  }

  @Override
  public Tuple<String, Iterable<Address>> listGlobalAddresses(Map<Option, ?> options) {
    try {
      AddressList addressList = compute.globalAddresses()
          .list(this.options.getProjectId())
          .setFilter(Option.FILTER.getString(options))
          .setMaxResults(Option.MAX_RESULTS.getLong(options))
          .setPageToken(Option.PAGE_TOKEN.getString(options))
          .setFields(Option.FIELDS.getString(options))
          .execute();
      Iterable<Address> operations = addressList.getItems();
      return Tuple.of(addressList.getNextPageToken(), operations);
    } catch (IOException ex) {
      throw translate(ex);
    }
  }

  @Override
  public Operation deleteGlobalAddress(String address, Map<Option, ?> options) {
    try {
      return compute.globalAddresses()
          .delete(this.options.getProjectId(), address)
          .setFields(Option.FIELDS.getString(options))
          .execute();
    } catch (IOException ex) {
      return nullForNotFound(ex);
    }
  }

  @Override
  public Address getRegionAddress(String region, String address, Map<Option, ?> options) {
    try {
      return compute.addresses()
          .get(this.options.getProjectId(), region, address)
          .setFields(Option.FIELDS.getString(options))
          .execute();
    } catch (IOException ex) {
      return nullForNotFound(ex);
    }
  }

  @Override
  public Operation createRegionAddress(String region, Address address, Map<Option, ?> options) {
    try {
      return compute.addresses()
          .insert(this.options.getProjectId(), region, address)
          .setFields(Option.FIELDS.getString(options))
          .execute();
    } catch (IOException ex) {
      throw translate(ex);
    }
  }

  @Override
  public Tuple<String, Iterable<Address>> listRegionAddresses(String region,
      Map<Option, ?> options) {
    try {
      AddressList addressList = compute.addresses()
          .list(this.options.getProjectId(), region)
          .setFilter(Option.FILTER.getString(options))
          .setMaxResults(Option.MAX_RESULTS.getLong(options))
          .setPageToken(Option.PAGE_TOKEN.getString(options))
          .setFields(Option.FIELDS.getString(options))
          .execute();
      Iterable<Address> operations = addressList.getItems();
      return Tuple.of(addressList.getNextPageToken(), operations);
    } catch (IOException ex) {
      throw translate(ex);
    }
  }

  @Override
  public Tuple<String, Iterable<Address>> listAddresses(Map<Option, ?> options) {
    try {
      AddressAggregatedList aggregatedList = compute.addresses()
          .aggregatedList(this.options.getProjectId())
          .setFilter(Option.FILTER.getString(options))
          .setMaxResults(Option.MAX_RESULTS.getLong(options))
          .setPageToken(Option.PAGE_TOKEN.getString(options))
          // todo(mziccard): uncomment or remove once #711 is closed
          // .setFields(FIELDS.getString(options))
          .execute();
      ImmutableList.Builder<Address> builder = ImmutableList.builder();
      Map<String, AddressesScopedList> scopedList = aggregatedList.getItems();
      if (scopedList != null) {
        for (AddressesScopedList addressesScopedList : scopedList.values()) {
          if (addressesScopedList.getAddresses() != null) {
            builder.addAll(addressesScopedList.getAddresses());
          }
        }
      }
      return Tuple.<String, Iterable<Address>>of(aggregatedList.getNextPageToken(),
          builder.build());
    } catch (IOException ex) {
      throw translate(ex);
    }
  }

  @Override
  public Operation deleteRegionAddress(String region, String address, Map<Option, ?> options) {
    try {
      return compute.addresses()
          .delete(this.options.getProjectId(), region, address)
          .setFields(Option.FIELDS.getString(options))
          .execute();
    } catch (IOException ex) {
      return nullForNotFound(ex);
    }
  }

  @Override
  public Operation createSnapshot(String zone, String disk, String snapshot, String description,
      Map<Option, ?> options) {
    Snapshot snapshotObject = new Snapshot().setName(snapshot).setDescription(description);
    try {
      return compute.disks()
          .createSnapshot(this.options.getProjectId(), zone, disk, snapshotObject)
          .setFields(Option.FIELDS.getString(options))
          .execute();
    } catch (IOException ex) {
      throw translate(ex);
    }
  }

  @Override
  public Snapshot getSnapshot(String snapshot, Map<Option, ?> options) {
    try {
      return compute.snapshots()
          .get(this.options.getProjectId(), snapshot)
          .setFields(Option.FIELDS.getString(options))
          .execute();
    } catch (IOException ex) {
      return nullForNotFound(ex);
    }
  }

  @Override
  public Tuple<String, Iterable<Snapshot>> listSnapshots(Map<Option, ?> options) {
    try {
      SnapshotList snapshotList = compute.snapshots()
          .list(this.options.getProjectId())
          .setFilter(Option.FILTER.getString(options))
          .setMaxResults(Option.MAX_RESULTS.getLong(options))
          .setPageToken(Option.PAGE_TOKEN.getString(options))
          .setFields(Option.FIELDS.getString(options))
          .execute();
      Iterable<Snapshot> snapshots = snapshotList.getItems();
      return Tuple.of(snapshotList.getNextPageToken(), snapshots);
    } catch (IOException ex) {
      throw translate(ex);
    }
  }

  @Override
  public Operation deleteSnapshot(String snapshot, Map<Option, ?> options) {
    try {
      return compute.snapshots()
          .delete(this.options.getProjectId(), snapshot)
          .setFields(Option.FIELDS.getString(options))
          .execute();
    } catch (IOException ex) {
      return nullForNotFound(ex);
    }
  }

  @Override
  public Operation createImage(Image image, Map<Option, ?> options) {
    try {
      return compute.images()
          .insert(this.options.getProjectId(), image)
          .setFields(Option.FIELDS.getString(options))
          .execute();
    } catch (IOException ex) {
      throw translate(ex);
    }
  }

  @Override
  public Image getImage(String project, String image, Map<Option, ?> options) {
    try {
      return compute.images()
          .get(project, image)
          .setFields(Option.FIELDS.getString(options))
          .execute();
    } catch (IOException ex) {
      return nullForNotFound(ex);
    }
  }

  @Override
  public Tuple<String, Iterable<Image>> listImages(String project, Map<Option, ?> options) {
    try {
      ImageList imageList = compute.images()
          .list(project)
          .setFilter(Option.FILTER.getString(options))
          .setMaxResults(Option.MAX_RESULTS.getLong(options))
          .setPageToken(Option.PAGE_TOKEN.getString(options))
          .setFields(Option.FIELDS.getString(options))
          .execute();
      Iterable<Image> images = imageList.getItems();
      return Tuple.of(imageList.getNextPageToken(), images);
    } catch (IOException ex) {
      throw translate(ex);
    }
  }

  @Override
  public Operation deleteImage(String project, String image, Map<Option, ?> options) {
    try {
      return compute.images()
          .delete(project, image)
          .setFields(Option.FIELDS.getString(options))
          .execute();
    } catch (IOException ex) {
      return nullForNotFound(ex);
    }
  }

  @Override
  public Operation deprecateImage(String project, String image, DeprecationStatus deprecationStatus,
      Map<Option, ?> options) {
    try {
      return compute.images()
          .deprecate(project, image, deprecationStatus)
          .setFields(Option.FIELDS.getString(options))
          .execute();
    } catch (IOException ex) {
      return nullForNotFound(ex);
    }
  }

  @Override
  public Disk getDisk(String zone, String disk, Map<Option, ?> options) {
    try {
      return compute.disks()
          .get(this.options.getProjectId(), zone, disk)
          .setFields(Option.FIELDS.getString(options))
          .execute();
    } catch (IOException ex) {
      return nullForNotFound(ex);
    }
  }

  @Override
  public Operation createDisk(String zone, Disk disk, Map<Option, ?> options) {
    try {
      return compute.disks()
          .insert(this.options.getProjectId(), zone, disk)
          .setFields(Option.FIELDS.getString(options))
          .execute();
    } catch (IOException ex) {
      throw translate(ex);
    }
  }

  @Override
  public Tuple<String, Iterable<Disk>> listDisks(String zone, Map<Option, ?> options) {
    try {
      DiskList diskList = compute.disks()
          .list(this.options.getProjectId(), zone)
          .setFilter(Option.FILTER.getString(options))
          .setMaxResults(Option.MAX_RESULTS.getLong(options))
          .setPageToken(Option.PAGE_TOKEN.getString(options))
          .setFields(Option.FIELDS.getString(options))
          .execute();
      Iterable<Disk> disks = diskList.getItems();
      return Tuple.of(diskList.getNextPageToken(), disks);
    } catch (IOException ex) {
      throw translate(ex);
    }
  }

  @Override
  public Tuple<String, Iterable<Disk>> listDisks(Map<Option, ?> options) {
    try {
      DiskAggregatedList aggregatedList = compute.disks()
          .aggregatedList(this.options.getProjectId())
          .setFilter(Option.FILTER.getString(options))
          .setMaxResults(Option.MAX_RESULTS.getLong(options))
          .setPageToken(Option.PAGE_TOKEN.getString(options))
          // todo(mziccard): uncomment or remove once #711 is closed
          // .setFields(FIELDS.getString(options))
          .execute();
      ImmutableList.Builder<Disk> builder = ImmutableList.builder();
      Map<String, DisksScopedList> scopedList = aggregatedList.getItems();
      if (scopedList != null) {
        for (DisksScopedList disksScopedList : scopedList.values()) {
          if (disksScopedList.getDisks() != null) {
            builder.addAll(disksScopedList.getDisks());
          }
        }
      }
      return Tuple.<String, Iterable<Disk>>of(aggregatedList.getNextPageToken(),
          builder.build());
    } catch (IOException ex) {
      throw translate(ex);
    }
  }

  @Override
  public Operation deleteDisk(String zone, String disk, Map<Option, ?> options) {
    try {
      return compute.disks()
          .delete(this.options.getProjectId(), zone, disk)
          .setFields(Option.FIELDS.getString(options))
          .execute();
    } catch (IOException ex) {
      return nullForNotFound(ex);
    }
  }

  @Override
  public Operation resizeDisk(String zone, String disk, long sizeGb, Map<Option, ?> options) {
    try {
      DisksResizeRequest resizeRequest = new DisksResizeRequest().setSizeGb(sizeGb);
      return compute.disks().resize(this.options.getProjectId(), zone, disk, resizeRequest)
          .setFields(Option.FIELDS.getString(options))
          .execute();
    } catch (IOException ex) {
      return nullForNotFound(ex);
    }
  }

  public Operation createSubnetwork(String region, Subnetwork subnetwork, Map<Option, ?> options) {
    try {
      return compute.subnetworks()
          .insert(this.options.getProjectId(), region, subnetwork)
          .setFields(Option.FIELDS.getString(options))
          .execute();
    } catch (IOException ex) {
      throw translate(ex);
    }
  }

  @Override
  public Subnetwork getSubnetwork(String region, String subnetwork, Map<Option, ?> options) {
    try {
      return compute.subnetworks()
          .get(this.options.getProjectId(), region, subnetwork)
          .setFields(Option.FIELDS.getString(options))
          .execute();
    } catch (IOException ex) {
      return nullForNotFound(ex);
    }
  }

  @Override
  public Tuple<String, Iterable<Subnetwork>> listSubnetworks(String region,
      Map<Option, ?> options) {
    try {
      SubnetworkList subnetworkList = compute.subnetworks()
          .list(this.options.getProjectId(), region)
          .setFilter(Option.FILTER.getString(options))
          .setMaxResults(Option.MAX_RESULTS.getLong(options))
          .setPageToken(Option.PAGE_TOKEN.getString(options))
          .setFields(Option.FIELDS.getString(options))
          .execute();
      Iterable<Subnetwork> subnetworks = subnetworkList.getItems();
      return Tuple.of(subnetworkList.getNextPageToken(), subnetworks);
    } catch (IOException ex) {
      throw translate(ex);
    }
  }

  @Override
  public Tuple<String, Iterable<Subnetwork>> listSubnetworks(Map<Option, ?> options) {
    try {
      SubnetworkAggregatedList aggregatedList = compute.subnetworks()
          .aggregatedList(this.options.getProjectId())
          .setFilter(Option.FILTER.getString(options))
          .setMaxResults(Option.MAX_RESULTS.getLong(options))
          .setPageToken(Option.PAGE_TOKEN.getString(options))
          // todo(mziccard): uncomment or remove once #711 is closed
          // .setFields(FIELDS.getString(options))
          .execute();
      ImmutableList.Builder<Subnetwork> builder = ImmutableList.builder();
      Map<String, SubnetworksScopedList> scopedList = aggregatedList.getItems();
      if (scopedList != null) {
        for (SubnetworksScopedList subnetworksScopedList : scopedList.values()) {
          if (subnetworksScopedList.getSubnetworks() != null) {
            builder.addAll(subnetworksScopedList.getSubnetworks());
          }
        }
      }
      return Tuple.<String, Iterable<Subnetwork>>of(aggregatedList.getNextPageToken(),
          builder.build());
    } catch (IOException ex) {
      throw translate(ex);
    }
  }

  @Override
  public Operation deleteSubnetwork(String region, String subnetwork, Map<Option, ?> options) {
    try {
      return compute.subnetworks()
          .delete(this.options.getProjectId(), region, subnetwork)
          .setFields(Option.FIELDS.getString(options))
          .execute();
    } catch (IOException ex) {
      return nullForNotFound(ex);
    }
  }

  @Override
  public Operation createNetwork(Network network, Map<Option, ?> options) {
    try {
      return compute.networks()
          .insert(this.options.getProjectId(), network)
          .setFields(Option.FIELDS.getString(options))
          .execute();
    } catch (IOException ex) {
      throw translate(ex);
    }
  }

  @Override
  public Network getNetwork(String network, Map<Option, ?> options) {
    try {
      return compute.networks()
          .get(this.options.getProjectId(), network)
          .setFields(Option.FIELDS.getString(options))
          .execute();
    } catch (IOException ex) {
      return nullForNotFound(ex);
    }
  }

  @Override
  public Tuple<String, Iterable<Network>> listNetworks(Map<Option, ?> options) {
    try {
      NetworkList networkList = compute.networks()
          .list(this.options.getProjectId())
          .setFilter(Option.FILTER.getString(options))
          .setMaxResults(Option.MAX_RESULTS.getLong(options))
          .setPageToken(Option.PAGE_TOKEN.getString(options))
          .setFields(Option.FIELDS.getString(options))
          .execute();
      Iterable<Network> networks = networkList.getItems();
      return Tuple.of(networkList.getNextPageToken(), networks);
    } catch (IOException ex) {
      throw translate(ex);
    }
  }

  @Override
  public Operation deleteNetwork(String network, Map<Option, ?> options) {
    try {
      return compute.networks()
          .delete(this.options.getProjectId(), network)
          .setFields(Option.FIELDS.getString(options))
          .execute();
    } catch (IOException ex) {
      return nullForNotFound(ex);
    }
  }

  @Override
  public Operation createInstance(String zone, Instance instance, Map<Option, ?> options) {
    try {
      return compute.instances()
          .insert(this.options.getProjectId(), zone, instance)
          .setFields(Option.FIELDS.getString(options))
          .execute();
    } catch (IOException ex) {
      throw translate(ex);
    }
  }

  @Override
  public Instance getInstance(String zone, String instance, Map<Option, ?> options) {
    try {
      return compute.instances()
          .get(this.options.getProjectId(), zone, instance)
          .setFields(Option.FIELDS.getString(options))
          .execute();
    } catch (IOException ex) {
      return nullForNotFound(ex);
    }
  }

  @Override
  public Tuple<String, Iterable<Instance>> listInstances(String zone, Map<Option, ?> options) {
    try {
      InstanceList instanceList = compute.instances()
          .list(this.options.getProjectId(), zone)
          .setFilter(Option.FILTER.getString(options))
          .setMaxResults(Option.MAX_RESULTS.getLong(options))
          .setPageToken(Option.PAGE_TOKEN.getString(options))
          .setFields(Option.FIELDS.getString(options))
          .execute();
      Iterable<Instance> instances = instanceList.getItems();
      return Tuple.of(instanceList.getNextPageToken(), instances);
    } catch (IOException ex) {
      throw translate(ex);
    }
  }

  @Override
  public Tuple<String, Iterable<Instance>> listInstances(Map<Option, ?> options) {
    try {
      InstanceAggregatedList aggregatedList = compute.instances()
          .aggregatedList(this.options.getProjectId())
          .setFilter(Option.FILTER.getString(options))
          .setMaxResults(Option.MAX_RESULTS.getLong(options))
          .setPageToken(Option.PAGE_TOKEN.getString(options))
          // todo(mziccard): uncomment or remove once #711 is closed
          // .setFields(FIELDS.getString(options))
          .execute();
      ImmutableList.Builder<Instance> builder = ImmutableList.builder();
      Map<String, InstancesScopedList> scopedList = aggregatedList.getItems();
      if (scopedList != null) {
        for (InstancesScopedList instancesScopedList : scopedList.values()) {
          if (instancesScopedList.getInstances() != null) {
            builder.addAll(instancesScopedList.getInstances());
          }
        }
      }
      return Tuple.<String, Iterable<Instance>>of(aggregatedList.getNextPageToken(),
          builder.build());
    } catch (IOException ex) {
      throw translate(ex);
    }
  }

  @Override
  public Operation deleteInstance(String zone, String instance, Map<Option, ?> options) {
    try {
      return compute.instances()
          .delete(this.options.getProjectId(), zone, instance)
          .setFields(Option.FIELDS.getString(options))
          .execute();
    } catch (IOException ex) {
      return nullForNotFound(ex);
    }
  }

  @Override
  public Operation addAccessConfig(String zone, String instance, String networkInterface,
      AccessConfig accessConfig, Map<Option, ?> options) {
    try {
      return compute.instances()
          .addAccessConfig(
              this.options.getProjectId(), zone, instance, networkInterface, accessConfig)
          .setFields(Option.FIELDS.getString(options))
          .execute();
    } catch (IOException ex) {
      throw translate(ex);
    }
  }

  @Override
  public Operation attachDisk(String zone, String instance, AttachedDisk attachedDisk,
      Map<Option, ?> options) {
    try {
      return compute.instances()
          .attachDisk(this.options.getProjectId(), zone, instance, attachedDisk)
          .setFields(Option.FIELDS.getString(options))
          .execute();
    } catch (IOException ex) {
      throw translate(ex);
    }
  }

  @Override
  public Operation deleteAccessConfig(String zone, String instance, String networkInterface,
      String accessConfig, Map<Option, ?> options) {
    try {
      return compute.instances()
          .deleteAccessConfig(this.options.getProjectId(), zone, instance, accessConfig,
              networkInterface)
          .setFields(Option.FIELDS.getString(options))
          .execute();
    } catch (IOException ex) {
      return nullForNotFound(ex);
    }
  }

  @Override
  public Operation detachDisk(String zone, String instance, String deviceName,
      Map<Option, ?> options) {
    try {
      return compute.instances()
          .detachDisk(this.options.getProjectId(), zone, instance, deviceName)
          .setFields(Option.FIELDS.getString(options))
          .execute();
    } catch (IOException ex) {
      return nullForNotFound(ex);
    }
  }

  @Override
  public String getSerialPortOutput(String zone, String instance, Integer port,
      Map<Option, ?> options) {
    try {
      SerialPortOutput portOutput = compute.instances()
          .getSerialPortOutput(this.options.getProjectId(), zone, instance)
          .setPort(port)
          .setFields(Option.FIELDS.getString(options))
          .execute();
      return portOutput != null ? portOutput.getContents() : null;
    } catch (IOException ex) {
      return nullForNotFound(ex);
    }
  }

  @Override
  public Operation reset(String zone, String instance, Map<Option, ?> options) {
    try {
      return compute.instances()
          .reset(this.options.getProjectId(), zone, instance)
          .setFields(Option.FIELDS.getString(options))
          .execute();
    } catch (IOException ex) {
      return nullForNotFound(ex);
    }
  }

  @Override
  public Operation setDiskAutoDelete(String zone, String instance, String deviceName,
      boolean autoDelete, Map<Option, ?> options) {
    try {
      return compute.instances()
          .setDiskAutoDelete(this.options.getProjectId(), zone, instance, autoDelete, deviceName)
          .setFields(Option.FIELDS.getString(options))
          .execute();
    } catch (IOException ex) {
      return nullForNotFound(ex);
    }
  }

  @Override
  public Operation setMachineType(String zone, String instance, String machineTypeUrl,
      Map<Option, ?> options) {
    try {
      InstancesSetMachineTypeRequest request =
          new InstancesSetMachineTypeRequest().setMachineType(machineTypeUrl);
      return compute.instances()
          .setMachineType(this.options.getProjectId(), zone, instance, request)
          .setFields(Option.FIELDS.getString(options))
          .execute();
    } catch (IOException ex) {
      return nullForNotFound(ex);
    }
  }

  @Override
  public Operation setMetadata(String zone, String instance, Metadata metadata,
      Map<Option, ?> options) {
    try {
      return compute.instances()
          .setMetadata(this.options.getProjectId(), zone, instance, metadata)
          .setFields(Option.FIELDS.getString(options))
          .execute();
    } catch (IOException ex) {
      return nullForNotFound(ex);
    }
  }

  @Override
  public Operation setScheduling(String zone, String instance, Scheduling scheduling,
      Map<Option, ?> options) {
    try {
      return compute.instances()
          .setScheduling(this.options.getProjectId(), zone, instance, scheduling)
          .setFields(Option.FIELDS.getString(options))
          .execute();
    } catch (IOException ex) {
      return nullForNotFound(ex);
    }
  }

  @Override
  public Operation setTags(String zone, String instance, Tags tags, Map<Option, ?> options) {
    try {
      return compute.instances()
          .setTags(this.options.getProjectId(), zone, instance, tags)
          .setFields(Option.FIELDS.getString(options))
          .execute();
    } catch (IOException ex) {
      return nullForNotFound(ex);
    }
  }

  @Override
  public Operation start(String zone, String instance, Map<Option, ?> options) {
    try {
      return compute.instances()
          .start(this.options.getProjectId(), zone, instance)
          .setFields(Option.FIELDS.getString(options))
          .execute();
    } catch (IOException ex) {
      return nullForNotFound(ex);
    }
  }

  @Override
  public Operation stop(String zone, String instance, Map<Option, ?> options) {
    try {
      return compute.instances()
          .stop(this.options.getProjectId(), zone, instance)
          .setFields(Option.FIELDS.getString(options))
          .execute();
    } catch (IOException ex) {
      return nullForNotFound(ex);
    }
  }

  /**
   * This method returns {@code null} if the error code of {@code exception} was 404, re-throws the
   * exception otherwise.
   *
   * @throws ComputeException if the error code of {@code exception} was not 404
   */
  private static <T> T nullForNotFound(IOException exception) {
    ComputeException serviceException = translate(exception);
    if (serviceException.getCode() == HTTP_NOT_FOUND) {
      return null;
    }
    throw serviceException;
  }

  /**
   * This method returns {@code false} if the error code of {@code exception} was 404, re-throws the
   * exception otherwise.
   *
   * @throws ComputeException if the error code of {@code exception} was not 404
   */
  private static boolean falseForNotFound(IOException exception) {
    ComputeException serviceException = translate(exception);
    if (serviceException.getCode() == HTTP_NOT_FOUND) {
      return false;
    }
    throw serviceException;
  }
}
