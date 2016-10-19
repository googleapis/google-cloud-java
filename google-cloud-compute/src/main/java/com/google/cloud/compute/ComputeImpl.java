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

import static com.google.cloud.RetryHelper.runWithRetries;
import static com.google.common.base.Preconditions.checkArgument;

import com.google.cloud.BaseService;
import com.google.cloud.Page;
import com.google.cloud.PageImpl;
import com.google.cloud.PageImpl.NextPageFetcher;
import com.google.cloud.RetryHelper;
import com.google.cloud.compute.AttachedDisk.PersistentDiskConfiguration;
import com.google.cloud.compute.NetworkInterface.AccessConfig;
import com.google.cloud.compute.spi.ComputeRpc;
import com.google.common.base.Function;
import com.google.common.collect.ImmutableList;
import com.google.common.collect.Iterables;
import com.google.common.collect.Maps;

import java.util.Map;
import java.util.concurrent.Callable;

final class ComputeImpl extends BaseService<ComputeOptions> implements Compute {

  private static class GlobalOperationPageFetcher implements NextPageFetcher<Operation> {

    private static final long serialVersionUID = -2488912172182315364L;
    private final Map<ComputeRpc.Option, ?> requestOptions;
    private final ComputeOptions serviceOptions;

    GlobalOperationPageFetcher(ComputeOptions serviceOptions, String cursor,
        Map<ComputeRpc.Option, ?> optionMap) {
      this.requestOptions =
          PageImpl.nextRequestOptions(ComputeRpc.Option.PAGE_TOKEN, cursor, optionMap);
      this.serviceOptions = serviceOptions;
    }

    @Override
    public Page<Operation> nextPage() {
      return listGlobalOperations(serviceOptions, requestOptions);
    }
  }

  private static class DiskTypePageFetcher implements NextPageFetcher<DiskType> {

    private static final long serialVersionUID = -5253916264932522976L;
    private final Map<ComputeRpc.Option, ?> requestOptions;
    private final ComputeOptions serviceOptions;
    private final String zone;

    DiskTypePageFetcher(String zone, ComputeOptions serviceOptions, String cursor,
        Map<ComputeRpc.Option, ?> optionMap) {
      this.requestOptions =
          PageImpl.nextRequestOptions(ComputeRpc.Option.PAGE_TOKEN, cursor, optionMap);
      this.serviceOptions = serviceOptions;
      this.zone = zone;
    }

    @Override
    public Page<DiskType> nextPage() {
      return listDiskTypes(zone, serviceOptions, requestOptions);
    }
  }

  private static class AggregatedDiskTypePageFetcher implements NextPageFetcher<DiskType> {

    private static final long serialVersionUID = -1664743503750307996L;
    private final Map<ComputeRpc.Option, ?> requestOptions;
    private final ComputeOptions serviceOptions;

    AggregatedDiskTypePageFetcher(ComputeOptions serviceOptions, String cursor,
        Map<ComputeRpc.Option, ?> optionMap) {
      this.requestOptions =
          PageImpl.nextRequestOptions(ComputeRpc.Option.PAGE_TOKEN, cursor, optionMap);
      this.serviceOptions = serviceOptions;
    }

    @Override
    public Page<DiskType> nextPage() {
      return listDiskTypes(serviceOptions, requestOptions);
    }
  }

  private static class MachineTypePageFetcher implements NextPageFetcher<MachineType> {

    private static final long serialVersionUID = -5048133000517001933L;
    private final Map<ComputeRpc.Option, ?> requestOptions;
    private final ComputeOptions serviceOptions;
    private final String zone;

    MachineTypePageFetcher(String zone, ComputeOptions serviceOptions, String cursor,
        Map<ComputeRpc.Option, ?> optionMap) {
      this.requestOptions =
          PageImpl.nextRequestOptions(ComputeRpc.Option.PAGE_TOKEN, cursor, optionMap);
      this.serviceOptions = serviceOptions;
      this.zone = zone;
    }

    @Override
    public Page<MachineType> nextPage() {
      return listMachineTypes(zone, serviceOptions, requestOptions);
    }
  }

  private static class AggregatedMachineTypePageFetcher implements NextPageFetcher<MachineType> {

    private static final long serialVersionUID = 2919227789802660026L;
    private final Map<ComputeRpc.Option, ?> requestOptions;
    private final ComputeOptions serviceOptions;

    AggregatedMachineTypePageFetcher(ComputeOptions serviceOptions, String cursor,
        Map<ComputeRpc.Option, ?> optionMap) {
      this.requestOptions =
          PageImpl.nextRequestOptions(ComputeRpc.Option.PAGE_TOKEN, cursor, optionMap);
      this.serviceOptions = serviceOptions;
    }

    @Override
    public Page<MachineType> nextPage() {
      return listMachineTypes(serviceOptions, requestOptions);
    }
  }

  private static class RegionPageFetcher implements NextPageFetcher<Region> {

    private static final long serialVersionUID = 4180147045485258863L;
    private final Map<ComputeRpc.Option, ?> requestOptions;
    private final ComputeOptions serviceOptions;

    RegionPageFetcher(ComputeOptions serviceOptions, String cursor,
        Map<ComputeRpc.Option, ?> optionMap) {
      this.requestOptions =
          PageImpl.nextRequestOptions(ComputeRpc.Option.PAGE_TOKEN, cursor, optionMap);
      this.serviceOptions = serviceOptions;
    }

    @Override
    public Page<Region> nextPage() {
      return listRegions(serviceOptions, requestOptions);
    }
  }

  private static class ZonePageFetcher implements NextPageFetcher<Zone> {

    private static final long serialVersionUID = -3946202621600687597L;
    private final Map<ComputeRpc.Option, ?> requestOptions;
    private final ComputeOptions serviceOptions;

    ZonePageFetcher(ComputeOptions serviceOptions, String cursor,
        Map<ComputeRpc.Option, ?> optionMap) {
      this.requestOptions =
          PageImpl.nextRequestOptions(ComputeRpc.Option.PAGE_TOKEN, cursor, optionMap);
      this.serviceOptions = serviceOptions;
    }

    @Override
    public Page<Zone> nextPage() {
      return listZones(serviceOptions, requestOptions);
    }
  }

  private static class RegionOperationPageFetcher implements NextPageFetcher<Operation> {

    private static final long serialVersionUID = 4111705358926164078L;
    private final Map<ComputeRpc.Option, ?> requestOptions;
    private final ComputeOptions serviceOptions;
    private final String region;

    RegionOperationPageFetcher(String region, ComputeOptions serviceOptions, String cursor,
        Map<ComputeRpc.Option, ?> optionMap) {
      this.requestOptions =
          PageImpl.nextRequestOptions(ComputeRpc.Option.PAGE_TOKEN, cursor, optionMap);
      this.serviceOptions = serviceOptions;
      this.region = region;
    }

    @Override
    public Page<Operation> nextPage() {
      return listRegionOperations(region, serviceOptions, requestOptions);
    }
  }

  private static class ZoneOperationPageFetcher implements NextPageFetcher<Operation> {

    private static final long serialVersionUID = -9012504536518197793L;
    private final Map<ComputeRpc.Option, ?> requestOptions;
    private final ComputeOptions serviceOptions;
    private final String zone;

    ZoneOperationPageFetcher(String zone, ComputeOptions serviceOptions, String cursor,
        Map<ComputeRpc.Option, ?> optionMap) {
      this.requestOptions =
          PageImpl.nextRequestOptions(ComputeRpc.Option.PAGE_TOKEN, cursor, optionMap);
      this.serviceOptions = serviceOptions;
      this.zone = zone;
    }

    @Override
    public Page<Operation> nextPage() {
      return listZoneOperations(zone, serviceOptions, requestOptions);
    }
  }

  private static class GlobalAddressPageFetcher implements NextPageFetcher<Address> {

    private static final long serialVersionUID = -3832055341507574454L;
    private final Map<ComputeRpc.Option, ?> requestOptions;
    private final ComputeOptions serviceOptions;

    GlobalAddressPageFetcher(ComputeOptions serviceOptions, String cursor,
        Map<ComputeRpc.Option, ?> optionMap) {
      this.requestOptions =
          PageImpl.nextRequestOptions(ComputeRpc.Option.PAGE_TOKEN, cursor, optionMap);
      this.serviceOptions = serviceOptions;
    }

    @Override
    public Page<Address> nextPage() {
      return listGlobalAddresses(serviceOptions, requestOptions);
    }
  }

  private static class RegionAddressPageFetcher implements NextPageFetcher<Address> {

    private static final long serialVersionUID = 7080596594494397027L;
    private final Map<ComputeRpc.Option, ?> requestOptions;
    private final ComputeOptions serviceOptions;
    private final String region;

    RegionAddressPageFetcher(String region, ComputeOptions serviceOptions, String cursor,
        Map<ComputeRpc.Option, ?> optionMap) {
      this.requestOptions =
          PageImpl.nextRequestOptions(ComputeRpc.Option.PAGE_TOKEN, cursor, optionMap);
      this.serviceOptions = serviceOptions;
      this.region = region;
    }

    @Override
    public Page<Address> nextPage() {
      return listRegionAddresses(region, serviceOptions, requestOptions);
    }
  }

  private static class AggregatedAddressPageFetcher implements NextPageFetcher<Address> {

    private static final long serialVersionUID = -5798942282919494950L;
    private final Map<ComputeRpc.Option, ?> requestOptions;
    private final ComputeOptions serviceOptions;

    AggregatedAddressPageFetcher(ComputeOptions serviceOptions, String cursor,
        Map<ComputeRpc.Option, ?> optionMap) {
      this.requestOptions =
          PageImpl.nextRequestOptions(ComputeRpc.Option.PAGE_TOKEN, cursor, optionMap);
      this.serviceOptions = serviceOptions;
    }

    @Override
    public Page<Address> nextPage() {
      return listAddresses(serviceOptions, requestOptions);
    }
  }

  private static class SnapshotPageFetcher implements NextPageFetcher<Snapshot> {

    private static final long serialVersionUID = 6205774609802216986L;
    private final Map<ComputeRpc.Option, ?> requestOptions;
    private final ComputeOptions serviceOptions;

    SnapshotPageFetcher(ComputeOptions serviceOptions, String cursor,
        Map<ComputeRpc.Option, ?> optionMap) {
      this.requestOptions =
          PageImpl.nextRequestOptions(ComputeRpc.Option.PAGE_TOKEN, cursor, optionMap);
      this.serviceOptions = serviceOptions;
    }

    @Override
    public Page<Snapshot> nextPage() {
      return listSnapshots(serviceOptions, requestOptions);
    }
  }

  private static class ImagePageFetcher implements NextPageFetcher<Image> {

    private static final long serialVersionUID = 6403679803137922023L;
    private final Map<ComputeRpc.Option, ?> requestOptions;
    private final ComputeOptions serviceOptions;
    private final String project;

    ImagePageFetcher(String project, ComputeOptions serviceOptions, String cursor,
        Map<ComputeRpc.Option, ?> optionMap) {
      this.requestOptions =
          PageImpl.nextRequestOptions(ComputeRpc.Option.PAGE_TOKEN, cursor, optionMap);
      this.serviceOptions = serviceOptions;
      this.project = project;
    }

    @Override
    public Page<Image> nextPage() {
      return listImages(project, serviceOptions, requestOptions);
    }
  }

  private static class DiskPageFetcher implements NextPageFetcher<Disk> {

    private static final long serialVersionUID = 4146589787872718476L;
    private final Map<ComputeRpc.Option, ?> requestOptions;
    private final ComputeOptions serviceOptions;
    private final String zone;

    DiskPageFetcher(String zone, ComputeOptions serviceOptions, String cursor,
        Map<ComputeRpc.Option, ?> optionMap) {
      this.requestOptions =
          PageImpl.nextRequestOptions(ComputeRpc.Option.PAGE_TOKEN, cursor, optionMap);
      this.serviceOptions = serviceOptions;
      this.zone = zone;
    }

    @Override
    public Page<Disk> nextPage() {
      return listDisks(zone, serviceOptions, requestOptions);
    }
  }

  private static class AggregatedDiskPageFetcher implements NextPageFetcher<Disk> {

    private static final long serialVersionUID = -5240045334115926206L;
    private final Map<ComputeRpc.Option, ?> requestOptions;
    private final ComputeOptions serviceOptions;

    AggregatedDiskPageFetcher(ComputeOptions serviceOptions, String cursor,
        Map<ComputeRpc.Option, ?> optionMap) {
      this.requestOptions =
          PageImpl.nextRequestOptions(ComputeRpc.Option.PAGE_TOKEN, cursor, optionMap);
      this.serviceOptions = serviceOptions;
    }

    @Override
    public Page<Disk> nextPage() {
      return listDisks(serviceOptions, requestOptions);
    }
  }

  private static class SubnetworkPageFetcher implements NextPageFetcher<Subnetwork> {

    private static final long serialVersionUID = 3674038457884412651L;
    private final Map<ComputeRpc.Option, ?> requestOptions;
    private final ComputeOptions serviceOptions;
    private final String region;

    SubnetworkPageFetcher(String region, ComputeOptions serviceOptions, String cursor,
        Map<ComputeRpc.Option, ?> optionMap) {
      this.requestOptions =
          PageImpl.nextRequestOptions(ComputeRpc.Option.PAGE_TOKEN, cursor, optionMap);
      this.serviceOptions = serviceOptions;
      this.region = region;
    }

    @Override
    public Page<Subnetwork> nextPage() {
      return listSubnetworks(region, serviceOptions, requestOptions);
    }
  }

  private static class AggregatedSubnetworkPageFetcher implements NextPageFetcher<Subnetwork> {

    private static final long serialVersionUID = 771343548833894551L;
    private final Map<ComputeRpc.Option, ?> requestOptions;
    private final ComputeOptions serviceOptions;

    AggregatedSubnetworkPageFetcher(ComputeOptions serviceOptions, String cursor,
        Map<ComputeRpc.Option, ?> optionMap) {
      this.requestOptions =
          PageImpl.nextRequestOptions(ComputeRpc.Option.PAGE_TOKEN, cursor, optionMap);
      this.serviceOptions = serviceOptions;
    }

    @Override
    public Page<Subnetwork> nextPage() {
      return listSubnetworks(serviceOptions, requestOptions);
    }
  }

  private static class NetworkPageFetcher implements NextPageFetcher<Network> {

    private static final long serialVersionUID = 5580210850353114531L;
    private final Map<ComputeRpc.Option, ?> requestOptions;
    private final ComputeOptions serviceOptions;

    NetworkPageFetcher(ComputeOptions serviceOptions, String cursor,
        Map<ComputeRpc.Option, ?> optionMap) {
      this.requestOptions =
          PageImpl.nextRequestOptions(ComputeRpc.Option.PAGE_TOKEN, cursor, optionMap);
      this.serviceOptions = serviceOptions;
    }

    @Override
    public Page<Network> nextPage() {
      return listNetworks(serviceOptions, requestOptions);
    }
  }

  private static class InstancePageFetcher implements NextPageFetcher<Instance> {

    private static final long serialVersionUID = 7563769742657453865L;
    private final Map<ComputeRpc.Option, ?> requestOptions;
    private final ComputeOptions serviceOptions;
    private final String zone;

    InstancePageFetcher(String zone, ComputeOptions serviceOptions, String cursor,
        Map<ComputeRpc.Option, ?> optionMap) {
      this.requestOptions =
          PageImpl.nextRequestOptions(ComputeRpc.Option.PAGE_TOKEN, cursor, optionMap);
      this.serviceOptions = serviceOptions;
      this.zone = zone;
    }

    @Override
    public Page<Instance> nextPage() {
      return listInstances(zone, serviceOptions, requestOptions);
    }
  }

  private static class AggregatedInstancePageFetcher implements NextPageFetcher<Instance> {

    private static final long serialVersionUID = 1863059389783095681L;
    private final Map<ComputeRpc.Option, ?> requestOptions;
    private final ComputeOptions serviceOptions;

    AggregatedInstancePageFetcher(ComputeOptions serviceOptions, String cursor,
        Map<ComputeRpc.Option, ?> optionMap) {
      this.requestOptions =
          PageImpl.nextRequestOptions(ComputeRpc.Option.PAGE_TOKEN, cursor, optionMap);
      this.serviceOptions = serviceOptions;
    }

    @Override
    public Page<Instance> nextPage() {
      return listInstances(serviceOptions, requestOptions);
    }
  }

  private final ComputeRpc computeRpc;

  ComputeImpl(ComputeOptions options) {
    super(options);
    computeRpc = options.rpc();
  }

  @Override
  public DiskType getDiskType(final DiskTypeId diskTypeId, DiskTypeOption... options) {
    final Map<ComputeRpc.Option, ?> optionsMap = optionMap(options);
    try {
      com.google.api.services.compute.model.DiskType answer =
          runWithRetries(new Callable<com.google.api.services.compute.model.DiskType>() {
            @Override
            public com.google.api.services.compute.model.DiskType call() {
              return computeRpc.getDiskType(diskTypeId.getZone(), diskTypeId.getType(), optionsMap);
            }
          }, options().retryParams(), EXCEPTION_HANDLER, options().clock());
      return answer == null ? null : DiskType.fromPb(answer);
    } catch (RetryHelper.RetryHelperException e) {
      throw ComputeException.translateAndThrow(e);
    }
  }

  @Override
  public DiskType getDiskType(String zone, String diskType, DiskTypeOption... options) {
    return getDiskType(DiskTypeId.of(zone, diskType), options);
  }

  @Override
  public Page<DiskType> listDiskTypes(String zone, DiskTypeListOption... options) {
    return listDiskTypes(zone, options(), optionMap(options));
  }

  private static Page<DiskType> listDiskTypes(final String zone,
      final ComputeOptions serviceOptions, final Map<ComputeRpc.Option, ?> optionsMap) {
    try {
      ComputeRpc.Tuple<String, Iterable<com.google.api.services.compute.model.DiskType>> result =
          runWithRetries(new Callable<ComputeRpc.Tuple<String,
              Iterable<com.google.api.services.compute.model.DiskType>>>() {
            @Override
            public ComputeRpc.Tuple<String,
                Iterable<com.google.api.services.compute.model.DiskType>> call() {
              return serviceOptions.rpc().listDiskTypes(zone, optionsMap);
            }
          }, serviceOptions.retryParams(), EXCEPTION_HANDLER, serviceOptions.clock());
      String cursor = result.x();
      Iterable<DiskType> diskTypes = Iterables.transform(
          result.y() == null ? ImmutableList.<com.google.api.services.compute.model.DiskType>of()
              : result.y(),
          new Function<com.google.api.services.compute.model.DiskType, DiskType>() {
            @Override
            public DiskType apply(com.google.api.services.compute.model.DiskType diskType) {
              return DiskType.fromPb(diskType);
            }
          });
      return new PageImpl<>(new DiskTypePageFetcher(zone, serviceOptions, cursor, optionsMap),
          cursor, diskTypes);
    } catch (RetryHelper.RetryHelperException e) {
      throw ComputeException.translateAndThrow(e);
    }
  }

  @Override
  public Page<DiskType> listDiskTypes(DiskTypeAggregatedListOption... options) {
    return listDiskTypes(options(), optionMap(options));
  }

  private static Page<DiskType> listDiskTypes(final ComputeOptions serviceOptions,
      final Map<ComputeRpc.Option, ?> optionsMap) {
    try {
      ComputeRpc.Tuple<String, Iterable<com.google.api.services.compute.model.DiskType>> result =
          runWithRetries(new Callable<ComputeRpc.Tuple<String,
              Iterable<com.google.api.services.compute.model.DiskType>>>() {
            @Override
            public ComputeRpc.Tuple<String,
                Iterable<com.google.api.services.compute.model.DiskType>> call() {
              return serviceOptions.rpc().listDiskTypes(optionsMap);
            }
          }, serviceOptions.retryParams(), EXCEPTION_HANDLER, serviceOptions.clock());
      String cursor = result.x();
      Iterable<DiskType> diskTypes = Iterables.transform(result.y(),
          new Function<com.google.api.services.compute.model.DiskType, DiskType>() {
            @Override
            public DiskType apply(com.google.api.services.compute.model.DiskType diskType) {
              return DiskType.fromPb(diskType);
            }
          });
      return new PageImpl<>(new AggregatedDiskTypePageFetcher(serviceOptions, cursor, optionsMap),
          cursor, diskTypes);
    } catch (RetryHelper.RetryHelperException e) {
      throw ComputeException.translateAndThrow(e);
    }
  }

  @Override
  public MachineType getMachineType(final MachineTypeId machineType, MachineTypeOption... options) {
    final Map<ComputeRpc.Option, ?> optionsMap = optionMap(options);
    try {
      com.google.api.services.compute.model.MachineType answer =
          runWithRetries(new Callable<com.google.api.services.compute.model.MachineType>() {
            @Override
            public com.google.api.services.compute.model.MachineType call() {
              return computeRpc.getMachineType(machineType.getZone(), machineType.getType(),
                  optionsMap);
            }
          }, options().retryParams(), EXCEPTION_HANDLER, options().clock());
      return answer == null ? null : MachineType.fromPb(answer);
    } catch (RetryHelper.RetryHelperException e) {
      throw ComputeException.translateAndThrow(e);
    }
  }

  @Override
  public MachineType getMachineType(String zone, String machineType, MachineTypeOption... options) {
    return getMachineType(MachineTypeId.of(zone, machineType), options);
  }

  @Override
  public Page<MachineType> listMachineTypes(String zone, MachineTypeListOption... options) {
    return listMachineTypes(zone, options(), optionMap(options));
  }

  private static Page<MachineType> listMachineTypes(final String zone,
      final ComputeOptions serviceOptions, final Map<ComputeRpc.Option, ?> optionsMap) {
    try {
      ComputeRpc.Tuple<String, Iterable<com.google.api.services.compute.model.MachineType>> result =
          runWithRetries(new Callable<ComputeRpc.Tuple<String,
              Iterable<com.google.api.services.compute.model.MachineType>>>() {
            @Override
            public ComputeRpc.Tuple<String,
                Iterable<com.google.api.services.compute.model.MachineType>> call() {
              return serviceOptions.rpc().listMachineTypes(zone, optionsMap);
            }
          }, serviceOptions.retryParams(), EXCEPTION_HANDLER, serviceOptions.clock());
      String cursor = result.x();
      Iterable<MachineType> machineTypes = Iterables.transform(
          result.y() == null ? ImmutableList.<com.google.api.services.compute.model.MachineType>of()
              : result.y(),
          new Function<com.google.api.services.compute.model.MachineType, MachineType>() {
            @Override
            public MachineType apply(
                com.google.api.services.compute.model.MachineType machineType) {
              return MachineType.fromPb(machineType);
            }
          });
      return new PageImpl<>(new MachineTypePageFetcher(zone, serviceOptions, cursor, optionsMap),
          cursor, machineTypes);
    } catch (RetryHelper.RetryHelperException e) {
      throw ComputeException.translateAndThrow(e);
    }
  }

  @Override
  public Page<MachineType> listMachineTypes(MachineTypeAggregatedListOption... options) {
    return listMachineTypes(options(), optionMap(options));
  }

  private static Page<MachineType> listMachineTypes(final ComputeOptions serviceOptions,
      final Map<ComputeRpc.Option, ?> optionsMap) {
    try {
      ComputeRpc.Tuple<String, Iterable<com.google.api.services.compute.model.MachineType>> result =
          runWithRetries(new Callable<ComputeRpc.Tuple<String,
              Iterable<com.google.api.services.compute.model.MachineType>>>() {
            @Override
            public ComputeRpc.Tuple<String,
                Iterable<com.google.api.services.compute.model.MachineType>> call() {
              return serviceOptions.rpc().listMachineTypes(optionsMap);
            }
          }, serviceOptions.retryParams(), EXCEPTION_HANDLER, serviceOptions.clock());
      String cursor = result.x();
      Iterable<MachineType> machineTypes = Iterables.transform(result.y(),
          new Function<com.google.api.services.compute.model.MachineType, MachineType>() {
            @Override
            public MachineType apply(
                com.google.api.services.compute.model.MachineType machineType) {
              return MachineType.fromPb(machineType);
            }
          });
      return new PageImpl<>(
          new AggregatedMachineTypePageFetcher(serviceOptions, cursor, optionsMap), cursor,
          machineTypes);
    } catch (RetryHelper.RetryHelperException e) {
      throw ComputeException.translateAndThrow(e);
    }
  }

  @Override
  public Region getRegion(final String region, RegionOption... options) {
    final Map<ComputeRpc.Option, ?> optionsMap = optionMap(options);
    try {
      com.google.api.services.compute.model.Region answer =
          runWithRetries(new Callable<com.google.api.services.compute.model.Region>() {
            @Override
            public com.google.api.services.compute.model.Region call() {
              return computeRpc.getRegion(region, optionsMap);
            }
          }, options().retryParams(), EXCEPTION_HANDLER, options().clock());
      return answer == null ? null : Region.fromPb(answer);
    } catch (RetryHelper.RetryHelperException e) {
      throw ComputeException.translateAndThrow(e);
    }
  }

  @Override
  public Page<Region> listRegions(RegionListOption... options) {
    return listRegions(options(), optionMap(options));
  }

  private static Page<Region> listRegions(final ComputeOptions serviceOptions,
      final Map<ComputeRpc.Option, ?> optionsMap) {
    try {
      ComputeRpc.Tuple<String, Iterable<com.google.api.services.compute.model.Region>> result =
          runWithRetries(new Callable<ComputeRpc.Tuple<String,
              Iterable<com.google.api.services.compute.model.Region>>>() {
            @Override
            public ComputeRpc.Tuple<String,
                Iterable<com.google.api.services.compute.model.Region>> call() {
              return serviceOptions.rpc().listRegions(optionsMap);
            }
          }, serviceOptions.retryParams(), EXCEPTION_HANDLER, serviceOptions.clock());
      String cursor = result.x();
      Iterable<Region> regions = Iterables.transform(
          result.y() == null ? ImmutableList.<com.google.api.services.compute.model.Region>of()
              : result.y(),
          new Function<com.google.api.services.compute.model.Region, Region>() {
            @Override
            public Region apply(com.google.api.services.compute.model.Region region) {
              return Region.fromPb(region);
            }
          });
      return new PageImpl<>(new RegionPageFetcher(serviceOptions, cursor, optionsMap), cursor,
          regions);
    } catch (RetryHelper.RetryHelperException e) {
      throw ComputeException.translateAndThrow(e);
    }
  }

  @Override
  public Zone getZone(final String zone, ZoneOption... options) {
    final Map<ComputeRpc.Option, ?> optionsMap = optionMap(options);
    try {
      com.google.api.services.compute.model.Zone answer =
          runWithRetries(new Callable<com.google.api.services.compute.model.Zone>() {
            @Override
            public com.google.api.services.compute.model.Zone call() {
              return computeRpc.getZone(zone, optionsMap);
            }
          }, options().retryParams(), EXCEPTION_HANDLER, options().clock());
      return answer == null ? null : Zone.fromPb(answer);
    } catch (RetryHelper.RetryHelperException e) {
      throw ComputeException.translateAndThrow(e);
    }
  }

  @Override
  public Page<Zone> listZones(ZoneListOption... options) {
    return listZones(options(), optionMap(options));
  }

  private static Page<Zone> listZones(final ComputeOptions serviceOptions,
      final Map<ComputeRpc.Option, ?> optionsMap) {
    try {
      ComputeRpc.Tuple<String, Iterable<com.google.api.services.compute.model.Zone>> result =
          runWithRetries(new Callable<ComputeRpc.Tuple<String,
              Iterable<com.google.api.services.compute.model.Zone>>>() {
            @Override
            public ComputeRpc.Tuple<String,
                Iterable<com.google.api.services.compute.model.Zone>> call() {
              return serviceOptions.rpc().listZones(optionsMap);
            }
          }, serviceOptions.retryParams(), EXCEPTION_HANDLER, serviceOptions.clock());
      String cursor = result.x();
      Iterable<Zone> zones = Iterables.transform(
          result.y() == null ? ImmutableList.<com.google.api.services.compute.model.Zone>of()
              : result.y(),
          new Function<com.google.api.services.compute.model.Zone, Zone>() {
            @Override
            public Zone apply(com.google.api.services.compute.model.Zone zone) {
              return Zone.fromPb(zone);
            }
          });
      return new PageImpl<>(new ZonePageFetcher(serviceOptions, cursor, optionsMap), cursor, zones);
    } catch (RetryHelper.RetryHelperException e) {
      throw ComputeException.translateAndThrow(e);
    }
  }

  @Override
  public License getLicense(String license, LicenseOption... options) {
    return getLicense(LicenseId.of(license), options);
  }

  @Override
  public License getLicense(LicenseId license, LicenseOption... options) {
    final LicenseId completeId = license.setProjectId(options().projectId());
    final Map<ComputeRpc.Option, ?> optionsMap = optionMap(options);
    try {
      com.google.api.services.compute.model.License answer =
          runWithRetries(new Callable<com.google.api.services.compute.model.License>() {
            @Override
            public com.google.api.services.compute.model.License call() {
              return computeRpc.getLicense(completeId.getProject(), completeId.getLicense(),
                  optionsMap);
            }
          }, options().retryParams(), EXCEPTION_HANDLER, options().clock());
      return answer == null ? null : License.fromPb(answer);
    } catch (RetryHelper.RetryHelperException e) {
      throw ComputeException.translateAndThrow(e);
    }
  }

  @Override
  public Operation getOperation(final OperationId operationId, OperationOption... options) {
    final Map<ComputeRpc.Option, ?> optionsMap = optionMap(options);
    try {
      com.google.api.services.compute.model.Operation answer =
          runWithRetries(new Callable<com.google.api.services.compute.model.Operation>() {
            @Override
            public com.google.api.services.compute.model.Operation call() {
              switch (operationId.getType()) {
                case REGION:
                  RegionOperationId regionOperationId = (RegionOperationId) operationId;
                  return computeRpc.getRegionOperation(regionOperationId.getRegion(),
                      regionOperationId.getOperation(), optionsMap);
                case ZONE:
                  ZoneOperationId zoneOperationId = (ZoneOperationId) operationId;
                  return computeRpc.getZoneOperation(zoneOperationId.getZone(),
                      zoneOperationId.getOperation(), optionsMap);
                case GLOBAL:
                  return computeRpc.getGlobalOperation(operationId.getOperation(), optionsMap);
                default:
                  throw new IllegalArgumentException("Unexpected operation identity type");
              }
            }
          }, options().retryParams(), EXCEPTION_HANDLER, options().clock());
      return answer == null ? null : Operation.fromPb(this, answer);
    } catch (RetryHelper.RetryHelperException e) {
      throw ComputeException.translateAndThrow(e);
    }
  }

  private static Function<com.google.api.services.compute.model.Operation, Operation>
      operationFromPb(final ComputeOptions serviceOptions) {
    return new Function<com.google.api.services.compute.model.Operation, Operation>() {
      @Override
      public Operation apply(com.google.api.services.compute.model.Operation operation) {
        return Operation.fromPb(serviceOptions.service(), operation);
      }
    };
  }

  @Override
  public Page<Operation> listGlobalOperations(OperationListOption... options) {
    return listGlobalOperations(options(), optionMap(options));
  }

  private static Page<Operation> listGlobalOperations(final ComputeOptions serviceOptions,
      final Map<ComputeRpc.Option, ?> optionsMap) {
    try {
      ComputeRpc.Tuple<String, Iterable<com.google.api.services.compute.model.Operation>> result =
          runWithRetries(new Callable<ComputeRpc.Tuple<String,
              Iterable<com.google.api.services.compute.model.Operation>>>() {
            @Override
            public ComputeRpc.Tuple<String,
                Iterable<com.google.api.services.compute.model.Operation>> call() {
              return serviceOptions.rpc().listGlobalOperations(optionsMap);
            }
          }, serviceOptions.retryParams(), EXCEPTION_HANDLER, serviceOptions.clock());
      String cursor = result.x();
      Iterable<Operation> operations = Iterables.transform(
          result.y() == null ? ImmutableList.<com.google.api.services.compute.model.Operation>of()
              : result.y(), operationFromPb(serviceOptions));
      return new PageImpl<>(new GlobalOperationPageFetcher(serviceOptions, cursor, optionsMap),
          cursor, operations);
    } catch (RetryHelper.RetryHelperException e) {
      throw ComputeException.translateAndThrow(e);
    }
  }

  @Override
  public Page<Operation> listRegionOperations(String region, OperationListOption... options) {
    return listRegionOperations(region, options(), optionMap(options));
  }

  private static Page<Operation> listRegionOperations(final String region,
      final ComputeOptions serviceOptions, final Map<ComputeRpc.Option, ?> optionsMap) {
    try {
      ComputeRpc.Tuple<String, Iterable<com.google.api.services.compute.model.Operation>> result =
          runWithRetries(new Callable<ComputeRpc.Tuple<String,
              Iterable<com.google.api.services.compute.model.Operation>>>() {
            @Override
            public ComputeRpc.Tuple<String,
                Iterable<com.google.api.services.compute.model.Operation>> call() {
              return serviceOptions.rpc().listRegionOperations(region, optionsMap);
            }
          }, serviceOptions.retryParams(), EXCEPTION_HANDLER, serviceOptions.clock());
      String cursor = result.x();
      Iterable<Operation> operations = Iterables.transform(
          result.y() == null ? ImmutableList.<com.google.api.services.compute.model.Operation>of()
              : result.y(), operationFromPb(serviceOptions));
      return new PageImpl<>(new RegionOperationPageFetcher(region, serviceOptions, cursor,
          optionsMap), cursor, operations);
    } catch (RetryHelper.RetryHelperException e) {
      throw ComputeException.translateAndThrow(e);
    }
  }

  @Override
  public Page<Operation> listZoneOperations(String zone, OperationListOption... options) {
    return listZoneOperations(zone, options(), optionMap(options));
  }

  private static Page<Operation> listZoneOperations(final String zone,
      final ComputeOptions serviceOptions, final Map<ComputeRpc.Option, ?> optionsMap) {
    try {
      ComputeRpc.Tuple<String, Iterable<com.google.api.services.compute.model.Operation>> result =
          runWithRetries(new Callable<ComputeRpc.Tuple<String,
              Iterable<com.google.api.services.compute.model.Operation>>>() {
            @Override
            public ComputeRpc.Tuple<String,
                Iterable<com.google.api.services.compute.model.Operation>> call() {
              return serviceOptions.rpc().listZoneOperations(zone, optionsMap);
            }
          }, serviceOptions.retryParams(), EXCEPTION_HANDLER, serviceOptions.clock());
      String cursor = result.x();
      Iterable<Operation> operations = Iterables.transform(
          result.y() == null ? ImmutableList.<com.google.api.services.compute.model.Operation>of()
              : result.y(), operationFromPb(serviceOptions));
      return new PageImpl<>(new ZoneOperationPageFetcher(zone, serviceOptions, cursor, optionsMap),
          cursor, operations);
    } catch (RetryHelper.RetryHelperException e) {
      throw ComputeException.translateAndThrow(e);
    }
  }

  @Override
  public boolean deleteOperation(final OperationId operation) {
    try {
      return runWithRetries(new Callable<Boolean>() {
        @Override
        public Boolean call() {
          switch (operation.getType()) {
            case REGION:
              RegionOperationId regionOperationId = (RegionOperationId) operation;
              return computeRpc.deleteRegionOperation(regionOperationId.getRegion(),
                  regionOperationId.getOperation());
            case ZONE:
              ZoneOperationId zoneOperationId = (ZoneOperationId) operation;
              return computeRpc.deleteZoneOperation(zoneOperationId.getZone(),
                  zoneOperationId.getOperation());
            case GLOBAL:
              return computeRpc.deleteGlobalOperation(operation.getOperation());
            default:
              throw new IllegalArgumentException("Unexpected operation identity type");
          }
        }
      }, options().retryParams(), EXCEPTION_HANDLER, options().clock());
    } catch (RetryHelper.RetryHelperException e) {
      throw ComputeException.translateAndThrow(e);
    }
  }

  @Override
  public Address getAddress(final AddressId addressId, AddressOption... options) {
    final Map<ComputeRpc.Option, ?> optionsMap = optionMap(options);
    try {
      com.google.api.services.compute.model.Address answer =
          runWithRetries(new Callable<com.google.api.services.compute.model.Address>() {
            @Override
            public com.google.api.services.compute.model.Address call() {
              switch (addressId.getType()) {
                case REGION:
                  RegionAddressId regionAddressId = (RegionAddressId) addressId;
                  return computeRpc.getRegionAddress(regionAddressId.getRegion(),
                      regionAddressId.getAddress(), optionsMap);
                case GLOBAL:
                  return computeRpc.getGlobalAddress(addressId.getAddress(), optionsMap);
                default:
                  throw new IllegalArgumentException("Unexpected address identity type");
              }
            }
          }, options().retryParams(), EXCEPTION_HANDLER, options().clock());
      return answer == null ? null : Address.fromPb(this, answer);
    } catch (RetryHelper.RetryHelperException e) {
      throw ComputeException.translateAndThrow(e);
    }
  }

  @Override
  public Operation create(final AddressInfo address, OperationOption... options) {
    final com.google.api.services.compute.model.Address addressPb =
        address.setProjectId(options().projectId()).toPb();
    final Map<ComputeRpc.Option, ?> optionsMap = optionMap(options);
    try {
      return Operation.fromPb(this,
          runWithRetries(new Callable<com.google.api.services.compute.model.Operation>() {
            @Override
            public com.google.api.services.compute.model.Operation call() {
              switch (address.getAddressId().getType()) {
                case REGION:
                  RegionAddressId regionAddressId = address.getAddressId();
                  return computeRpc.createRegionAddress(regionAddressId.getRegion(), addressPb,
                      optionsMap);
                case GLOBAL:
                  return computeRpc.createGlobalAddress(addressPb, optionsMap);
                default:
                  throw new IllegalArgumentException("Unexpected address identity type");
              }
            }
          }, options().retryParams(), EXCEPTION_HANDLER, options().clock()));
    } catch (RetryHelper.RetryHelperException e) {
      throw ComputeException.translateAndThrow(e);
    }
  }

  private static Function<com.google.api.services.compute.model.Address, Address> addressFromPb(
      final ComputeOptions serviceOptions) {
    return new Function<com.google.api.services.compute.model.Address, Address>() {
      @Override
      public Address apply(com.google.api.services.compute.model.Address address) {
        return Address.fromPb(serviceOptions.service(), address);
      }
    };
  }

  @Override
  public Page<Address> listGlobalAddresses(AddressListOption... options) {
    return listGlobalAddresses(options(), optionMap(options));
  }

  private static Page<Address> listGlobalAddresses(final ComputeOptions serviceOptions,
      final Map<ComputeRpc.Option, ?> optionsMap) {
    try {
      ComputeRpc.Tuple<String, Iterable<com.google.api.services.compute.model.Address>> result =
          runWithRetries(new Callable<ComputeRpc.Tuple<String,
              Iterable<com.google.api.services.compute.model.Address>>>() {
            @Override
            public ComputeRpc.Tuple<String,
                Iterable<com.google.api.services.compute.model.Address>> call() {
              return serviceOptions.rpc().listGlobalAddresses(optionsMap);
            }
          }, serviceOptions.retryParams(), EXCEPTION_HANDLER, serviceOptions.clock());
      String cursor = result.x();
      Iterable<Address> operations = Iterables.transform(
          result.y() == null ? ImmutableList.<com.google.api.services.compute.model.Address>of()
              : result.y(), addressFromPb(serviceOptions));
      return new PageImpl<>(new GlobalAddressPageFetcher(serviceOptions, cursor, optionsMap),
          cursor, operations);
    } catch (RetryHelper.RetryHelperException e) {
      throw ComputeException.translateAndThrow(e);
    }
  }

  @Override
  public Page<Address> listRegionAddresses(String region, AddressListOption... options) {
    return listRegionAddresses(region, options(), optionMap(options));
  }

  private static Page<Address> listRegionAddresses(final String region,
      final ComputeOptions serviceOptions, final Map<ComputeRpc.Option, ?> optionsMap) {
    try {
      ComputeRpc.Tuple<String, Iterable<com.google.api.services.compute.model.Address>> result =
          runWithRetries(new Callable<ComputeRpc.Tuple<String,
              Iterable<com.google.api.services.compute.model.Address>>>() {
            @Override
            public ComputeRpc.Tuple<String,
                Iterable<com.google.api.services.compute.model.Address>> call() {
              return serviceOptions.rpc().listRegionAddresses(region, optionsMap);
            }
          }, serviceOptions.retryParams(), EXCEPTION_HANDLER, serviceOptions.clock());
      String cursor = result.x();
      Iterable<Address> operations = Iterables.transform(
          result.y() == null ? ImmutableList.<com.google.api.services.compute.model.Address>of()
              : result.y(), addressFromPb(serviceOptions));
      return new PageImpl<>(new RegionAddressPageFetcher(region, serviceOptions, cursor,
          optionsMap), cursor, operations);
    } catch (RetryHelper.RetryHelperException e) {
      throw ComputeException.translateAndThrow(e);
    }
  }

  @Override
  public Page<Address> listAddresses(AddressAggregatedListOption... options) {
    return listAddresses(options(), optionMap(options));
  }

  private static Page<Address> listAddresses(final ComputeOptions serviceOptions,
      final Map<ComputeRpc.Option, ?> optionsMap) {
    try {
      ComputeRpc.Tuple<String, Iterable<com.google.api.services.compute.model.Address>> result =
          runWithRetries(new Callable<ComputeRpc.Tuple<String,
              Iterable<com.google.api.services.compute.model.Address>>>() {
            @Override
            public ComputeRpc.Tuple<String,
                Iterable<com.google.api.services.compute.model.Address>> call() {
              return serviceOptions.rpc().listAddresses(optionsMap);
            }
          }, serviceOptions.retryParams(), EXCEPTION_HANDLER, serviceOptions.clock());
      String cursor = result.x();
      Iterable<Address> operations = Iterables.transform(
          result.y() == null ? ImmutableList.<com.google.api.services.compute.model.Address>of()
              : result.y(),
          new Function<com.google.api.services.compute.model.Address, Address>() {
            @Override
            public Address apply(com.google.api.services.compute.model.Address address) {
              return Address.fromPb(serviceOptions.service(), address);
            }
          });
      return new PageImpl<>(new AggregatedAddressPageFetcher(serviceOptions, cursor, optionsMap),
          cursor, operations);
    } catch (RetryHelper.RetryHelperException e) {
      throw ComputeException.translateAndThrow(e);
    }
  }

  @Override
  public Operation deleteAddress(final AddressId addressId, OperationOption... options) {
    final Map<ComputeRpc.Option, ?> optionsMap = optionMap(options);
    try {
      com.google.api.services.compute.model.Operation answer =
          runWithRetries(new Callable<com.google.api.services.compute.model.Operation>() {
            @Override
            public com.google.api.services.compute.model.Operation call() {
              switch (addressId.getType()) {
                case REGION:
                  RegionAddressId regionAddressId = (RegionAddressId) addressId;
                  return computeRpc.deleteRegionAddress(regionAddressId.getRegion(),
                      regionAddressId.getAddress(), optionsMap);
                case GLOBAL:
                  return computeRpc.deleteGlobalAddress(addressId.getAddress(), optionsMap);
                default:
                  throw new IllegalArgumentException("Unexpected address identity type");
              }
            }
          }, options().retryParams(), EXCEPTION_HANDLER, options().clock());
      return answer == null ? null : Operation.fromPb(this, answer);
    } catch (RetryHelper.RetryHelperException e) {
      throw ComputeException.translateAndThrow(e);
    }
  }

  @Override
  public Operation create(SnapshotInfo snapshot, OperationOption... options) {
    final SnapshotInfo completeSnapshot = snapshot.setProjectId(options().projectId());
    final Map<ComputeRpc.Option, ?> optionsMap = optionMap(options);
    try {
      com.google.api.services.compute.model.Operation answer =
          runWithRetries(new Callable<com.google.api.services.compute.model.Operation>() {
            @Override
            public com.google.api.services.compute.model.Operation call() {
              return computeRpc.createSnapshot(completeSnapshot.getSourceDisk().getZone(),
                  completeSnapshot.getSourceDisk().getDisk(),
                  completeSnapshot.getSnapshotId().getSnapshot(), completeSnapshot.getDescription(),
                  optionsMap);
            }
          }, options().retryParams(), EXCEPTION_HANDLER, options().clock());
      return answer == null ? null : Operation.fromPb(this, answer);
    } catch (RetryHelper.RetryHelperException e) {
      throw ComputeException.translateAndThrow(e);
    }
  }

  @Override
  public Snapshot getSnapshot(final String snapshot, SnapshotOption... options) {
    final Map<ComputeRpc.Option, ?> optionsMap = optionMap(options);
    try {
      com.google.api.services.compute.model.Snapshot answer =
          runWithRetries(new Callable<com.google.api.services.compute.model.Snapshot>() {
            @Override
            public com.google.api.services.compute.model.Snapshot call() {
              return computeRpc.getSnapshot(snapshot, optionsMap);
            }
          }, options().retryParams(), EXCEPTION_HANDLER, options().clock());
      return answer == null ? null : Snapshot.fromPb(this, answer);
    } catch (RetryHelper.RetryHelperException e) {
      throw ComputeException.translateAndThrow(e);
    }
  }

  @Override
  public Page<Snapshot> listSnapshots(SnapshotListOption... options) {
    return listSnapshots(options(), optionMap(options));
  }

  private static Page<Snapshot> listSnapshots(final ComputeOptions serviceOptions,
      final Map<ComputeRpc.Option, ?> optionsMap) {
    try {
      ComputeRpc.Tuple<String, Iterable<com.google.api.services.compute.model.Snapshot>> result =
          runWithRetries(new Callable<ComputeRpc.Tuple<String,
              Iterable<com.google.api.services.compute.model.Snapshot>>>() {
            @Override
            public ComputeRpc.Tuple<String,
                Iterable<com.google.api.services.compute.model.Snapshot>> call() {
              return serviceOptions.rpc().listSnapshots(optionsMap);
            }
          }, serviceOptions.retryParams(), EXCEPTION_HANDLER, serviceOptions.clock());
      String cursor = result.x();
      Iterable<Snapshot> snapshots = Iterables.transform(
          result.y() == null ? ImmutableList.<com.google.api.services.compute.model.Snapshot>of()
              : result.y(),
          new Function<com.google.api.services.compute.model.Snapshot, Snapshot>() {
            @Override
            public Snapshot apply(com.google.api.services.compute.model.Snapshot snapshot) {
              return Snapshot.fromPb(serviceOptions.service(), snapshot);
            }
          });
      return new PageImpl<>(new SnapshotPageFetcher(serviceOptions, cursor, optionsMap), cursor,
          snapshots);
    } catch (RetryHelper.RetryHelperException e) {
      throw ComputeException.translateAndThrow(e);
    }
  }

  @Override
  public Operation deleteSnapshot(SnapshotId snapshot, OperationOption... options) {
    return deleteSnapshot(snapshot.getSnapshot(), options);
  }

  @Override
  public Operation deleteSnapshot(final String snapshot, OperationOption... options) {
    final Map<ComputeRpc.Option, ?> optionsMap = optionMap(options);
    try {
      com.google.api.services.compute.model.Operation answer =
          runWithRetries(new Callable<com.google.api.services.compute.model.Operation>() {
            @Override
            public com.google.api.services.compute.model.Operation call() {
              return computeRpc.deleteSnapshot(snapshot, optionsMap);
            }
          }, options().retryParams(), EXCEPTION_HANDLER, options().clock());
      return answer == null ? null : Operation.fromPb(this, answer);
    } catch (RetryHelper.RetryHelperException e) {
      throw ComputeException.translateAndThrow(e);
    }
  }

  @Override
  public Operation create(ImageInfo image, OperationOption... options) {
    final ImageInfo completeImage = image.setProjectId(options().projectId());
    final Map<ComputeRpc.Option, ?> optionsMap = optionMap(options);
    try {
      com.google.api.services.compute.model.Operation answer =
          runWithRetries(new Callable<com.google.api.services.compute.model.Operation>() {
            @Override
            public com.google.api.services.compute.model.Operation call() {
              return computeRpc.createImage(completeImage.toPb(), optionsMap);
            }
          }, options().retryParams(), EXCEPTION_HANDLER, options().clock());
      return answer == null ? null : Operation.fromPb(this, answer);
    } catch (RetryHelper.RetryHelperException e) {
      throw ComputeException.translateAndThrow(e);
    }
  }

  @Override
  public Image getImage(ImageId imageId, ImageOption... options) {
    final ImageId completeImageId = imageId.setProjectId(options().projectId());
    final Map<ComputeRpc.Option, ?> optionsMap = optionMap(options);
    try {
      com.google.api.services.compute.model.Image answer =
          runWithRetries(new Callable<com.google.api.services.compute.model.Image>() {
            @Override
            public com.google.api.services.compute.model.Image call() {
              return computeRpc.getImage(completeImageId.getProject(), completeImageId.getImage(),
                  optionsMap);
            }
          }, options().retryParams(), EXCEPTION_HANDLER, options().clock());
      return answer == null ? null : Image.fromPb(this, answer);
    } catch (RetryHelper.RetryHelperException e) {
      throw ComputeException.translateAndThrow(e);
    }
  }

  @Override
  public Page<Image> listImages(String project, ImageListOption... options) {
    return listImages(project, options(), optionMap(options));
  }

  @Override
  public Page<Image> listImages(ImageListOption... options) {
    return listImages(options().projectId(), options(), optionMap(options));
  }

  private static Page<Image> listImages(final String project, final ComputeOptions serviceOptions,
      final Map<ComputeRpc.Option, ?> optionsMap) {
    try {
      ComputeRpc.Tuple<String, Iterable<com.google.api.services.compute.model.Image>> result =
          runWithRetries(new Callable<ComputeRpc.Tuple<String,
              Iterable<com.google.api.services.compute.model.Image>>>() {
            @Override
            public ComputeRpc.Tuple<String,
                Iterable<com.google.api.services.compute.model.Image>> call() {
              return serviceOptions.rpc().listImages(project, optionsMap);
            }
          }, serviceOptions.retryParams(), EXCEPTION_HANDLER, serviceOptions.clock());
      String cursor = result.x();
      Iterable<Image> images = Iterables.transform(
          result.y() == null ? ImmutableList.<com.google.api.services.compute.model.Image>of()
              : result.y(),
          new Function<com.google.api.services.compute.model.Image, Image>() {
            @Override
            public Image apply(com.google.api.services.compute.model.Image image) {
              return Image.fromPb(serviceOptions.service(), image);
            }
          });
      return new PageImpl<>(new ImagePageFetcher(project, serviceOptions, cursor, optionsMap),
          cursor, images);
    } catch (RetryHelper.RetryHelperException e) {
      throw ComputeException.translateAndThrow(e);
    }
  }

  @Override
  public Operation deleteImage(ImageId image, OperationOption... options) {
    final ImageId completeId = image.setProjectId(options().projectId());
    final Map<ComputeRpc.Option, ?> optionsMap = optionMap(options);
    try {
      com.google.api.services.compute.model.Operation answer =
          runWithRetries(new Callable<com.google.api.services.compute.model.Operation>() {
            @Override
            public com.google.api.services.compute.model.Operation call() {
              return computeRpc.deleteImage(completeId.getProject(), completeId.getImage(),
                  optionsMap);
            }
          }, options().retryParams(), EXCEPTION_HANDLER, options().clock());
      return answer == null ? null : Operation.fromPb(this, answer);
    } catch (RetryHelper.RetryHelperException e) {
      throw ComputeException.translateAndThrow(e);
    }
  }

  @Override
  public Operation deprecate(ImageId image,
      final DeprecationStatus<ImageId> deprecationStatus, OperationOption... options) {
    final ImageId completeId = image.setProjectId(options().projectId());
    final Map<ComputeRpc.Option, ?> optionsMap = optionMap(options);
    try {
      com.google.api.services.compute.model.Operation answer =
          runWithRetries(new Callable<com.google.api.services.compute.model.Operation>() {
            @Override
            public com.google.api.services.compute.model.Operation call() {
              return computeRpc.deprecateImage(completeId.getProject(), completeId.getImage(),
                  deprecationStatus.toPb(), optionsMap);
            }
          }, options().retryParams(), EXCEPTION_HANDLER, options().clock());
      return answer == null ? null : Operation.fromPb(this, answer);
    } catch (RetryHelper.RetryHelperException e) {
      throw ComputeException.translateAndThrow(e);
    }
  }

  @Override
  public Disk getDisk(final DiskId diskId, DiskOption... options) {
    final Map<ComputeRpc.Option, ?> optionsMap = optionMap(options);
    try {
      com.google.api.services.compute.model.Disk answer =
          runWithRetries(new Callable<com.google.api.services.compute.model.Disk>() {
            @Override
            public com.google.api.services.compute.model.Disk call() {
              return computeRpc.getDisk(diskId.getZone(), diskId.getDisk(), optionsMap);
            }
          }, options().retryParams(), EXCEPTION_HANDLER, options().clock());
      return answer == null ? null : Disk.fromPb(this, answer);
    } catch (RetryHelper.RetryHelperException e) {
      throw ComputeException.translateAndThrow(e);
    }
  }

  @Override
  public Operation create(final DiskInfo disk, OperationOption... options) {
    final com.google.api.services.compute.model.Disk diskPb =
        disk.setProjectId(options().projectId()).toPb();
    final Map<ComputeRpc.Option, ?> optionsMap = optionMap(options);
    try {
      return Operation.fromPb(this,
          runWithRetries(new Callable<com.google.api.services.compute.model.Operation>() {
            @Override
            public com.google.api.services.compute.model.Operation call() {
              return computeRpc.createDisk(disk.getDiskId().getZone(), diskPb, optionsMap);
            }
          }, options().retryParams(), EXCEPTION_HANDLER, options().clock()));
    } catch (RetryHelper.RetryHelperException e) {
      throw ComputeException.translateAndThrow(e);
    }
  }

  private static Function<com.google.api.services.compute.model.Disk, Disk> diskFromPb(
      final ComputeOptions serviceOptions) {
    return new Function<com.google.api.services.compute.model.Disk, Disk>() {
      @Override
      public Disk apply(com.google.api.services.compute.model.Disk disk) {
        return Disk.fromPb(serviceOptions.service(), disk);
      }
    };
  }

  @Override
  public Page<Disk> listDisks(String zone, DiskListOption... options) {
    return listDisks(zone, options(), optionMap(options));
  }

  private static Page<Disk> listDisks(final String zone, final ComputeOptions serviceOptions,
      final Map<ComputeRpc.Option, ?> optionsMap) {
    try {
      ComputeRpc.Tuple<String, Iterable<com.google.api.services.compute.model.Disk>> result =
          runWithRetries(new Callable<ComputeRpc.Tuple<String,
              Iterable<com.google.api.services.compute.model.Disk>>>() {
            @Override
            public ComputeRpc.Tuple<String,
                Iterable<com.google.api.services.compute.model.Disk>> call() {
              return serviceOptions.rpc().listDisks(zone, optionsMap);
            }
          }, serviceOptions.retryParams(), EXCEPTION_HANDLER, serviceOptions.clock());
      String cursor = result.x();
      Iterable<Disk> disks = Iterables.transform(
          result.y() == null ? ImmutableList.<com.google.api.services.compute.model.Disk>of()
              : result.y(), diskFromPb(serviceOptions));
      return new PageImpl<>(new DiskPageFetcher(zone, serviceOptions, cursor, optionsMap),
          cursor, disks);
    } catch (RetryHelper.RetryHelperException e) {
      throw ComputeException.translateAndThrow(e);
    }
  }

  @Override
  public Page<Disk> listDisks(DiskAggregatedListOption... options) {
    return listDisks(options(), optionMap(options));
  }

  private static Page<Disk> listDisks(final ComputeOptions serviceOptions,
      final Map<ComputeRpc.Option, ?> optionsMap) {
    try {
      ComputeRpc.Tuple<String, Iterable<com.google.api.services.compute.model.Disk>> result =
          runWithRetries(new Callable<ComputeRpc.Tuple<String,
              Iterable<com.google.api.services.compute.model.Disk>>>() {
            @Override
            public ComputeRpc.Tuple<String,
                Iterable<com.google.api.services.compute.model.Disk>> call() {
              return serviceOptions.rpc().listDisks(optionsMap);
            }
          }, serviceOptions.retryParams(), EXCEPTION_HANDLER, serviceOptions.clock());
      String cursor = result.x();
      Iterable<Disk> disks = Iterables.transform(
          result.y() == null ? ImmutableList.<com.google.api.services.compute.model.Disk>of()
              : result.y(), diskFromPb(serviceOptions));
      return new PageImpl<>(new AggregatedDiskPageFetcher(serviceOptions, cursor, optionsMap),
          cursor, disks);
    } catch (RetryHelper.RetryHelperException e) {
      throw ComputeException.translateAndThrow(e);
    }
  }

  @Override
  public Operation deleteDisk(final DiskId disk, OperationOption... options) {
    final Map<ComputeRpc.Option, ?> optionsMap = optionMap(options);
    try {
      com.google.api.services.compute.model.Operation answer =
          runWithRetries(new Callable<com.google.api.services.compute.model.Operation>() {
            @Override
            public com.google.api.services.compute.model.Operation call() {
              return computeRpc.deleteDisk(disk.getZone(), disk.getDisk(), optionsMap);
            }
          }, options().retryParams(), EXCEPTION_HANDLER, options().clock());
      return answer == null ? null : Operation.fromPb(this, answer);
    } catch (RetryHelper.RetryHelperException e) {
      throw ComputeException.translateAndThrow(e);
    }
  }

  @Override
  public Operation resize(final DiskId disk, final long sizeGb, OperationOption... options) {
    final Map<ComputeRpc.Option, ?> optionsMap = optionMap(options);
    try {
      com.google.api.services.compute.model.Operation answer =
          runWithRetries(new Callable<com.google.api.services.compute.model.Operation>() {
            @Override
            public com.google.api.services.compute.model.Operation call() {
              return computeRpc.resizeDisk(disk.getZone(), disk.getDisk(), sizeGb, optionsMap);
            }
          }, options().retryParams(), EXCEPTION_HANDLER, options().clock());
      return answer == null ? null : Operation.fromPb(this, answer);
    } catch (RetryHelper.RetryHelperException e) {
      throw ComputeException.translateAndThrow(e);
    }
  }

  public Operation create(SubnetworkInfo subnetwork, OperationOption... options) {
    final SubnetworkInfo completeSubnetwork = subnetwork.setProjectId(options().projectId());
    final Map<ComputeRpc.Option, ?> optionsMap = optionMap(options);
    try {
      com.google.api.services.compute.model.Operation answer =
          runWithRetries(new Callable<com.google.api.services.compute.model.Operation>() {
            @Override
            public com.google.api.services.compute.model.Operation call() {
              return computeRpc.createSubnetwork(completeSubnetwork.getSubnetworkId().getRegion(),
                  completeSubnetwork.toPb(), optionsMap);
            }
          }, options().retryParams(), EXCEPTION_HANDLER, options().clock());
      return answer == null ? null : Operation.fromPb(this, answer);
    } catch (RetryHelper.RetryHelperException e) {
      throw ComputeException.translateAndThrow(e);
    }
  }

  @Override
  public Subnetwork getSubnetwork(final SubnetworkId subnetworkId, SubnetworkOption... options) {
    final Map<ComputeRpc.Option, ?> optionsMap = optionMap(options);
    try {
      com.google.api.services.compute.model.Subnetwork answer =
          runWithRetries(new Callable<com.google.api.services.compute.model.Subnetwork>() {
            @Override
            public com.google.api.services.compute.model.Subnetwork call() {
              return computeRpc.getSubnetwork(subnetworkId.getRegion(),
                  subnetworkId.getSubnetwork(), optionsMap);
            }
          }, options().retryParams(), EXCEPTION_HANDLER, options().clock());
      return answer == null ? null : Subnetwork.fromPb(this, answer);
    } catch (RetryHelper.RetryHelperException e) {
      throw ComputeException.translateAndThrow(e);
    }
  }

  private static Function<com.google.api.services.compute.model.Subnetwork, Subnetwork>
      subnetworkFromPb(final ComputeOptions serviceOptions) {
    return new Function<com.google.api.services.compute.model.Subnetwork, Subnetwork>() {
      @Override
      public Subnetwork apply(com.google.api.services.compute.model.Subnetwork subnetwork) {
        return Subnetwork.fromPb(serviceOptions.service(), subnetwork);
      }
    };
  }

  @Override
  public Page<Subnetwork> listSubnetworks(String region, SubnetworkListOption... options) {
    return listSubnetworks(region, options(), optionMap(options));
  }

  private static Page<Subnetwork> listSubnetworks(final String region,
      final ComputeOptions serviceOptions, final Map<ComputeRpc.Option, ?> optionsMap) {
    try {
      ComputeRpc.Tuple<String, Iterable<com.google.api.services.compute.model.Subnetwork>> result =
          runWithRetries(new Callable<ComputeRpc.Tuple<String,
              Iterable<com.google.api.services.compute.model.Subnetwork>>>() {
            @Override
            public ComputeRpc.Tuple<String,
                Iterable<com.google.api.services.compute.model.Subnetwork>> call() {
              return serviceOptions.rpc().listSubnetworks(region, optionsMap);
            }
          }, serviceOptions.retryParams(), EXCEPTION_HANDLER, serviceOptions.clock());
      String cursor = result.x();
      Iterable<Subnetwork> subnetworks = Iterables.transform(
          result.y() == null ? ImmutableList.<com.google.api.services.compute.model.Subnetwork>of()
              : result.y(), subnetworkFromPb(serviceOptions));
      return new PageImpl<>(new SubnetworkPageFetcher(region, serviceOptions, cursor, optionsMap),
          cursor, subnetworks);
    } catch (RetryHelper.RetryHelperException e) {
      throw ComputeException.translateAndThrow(e);
    }
  }

  @Override
  public Page<Subnetwork> listSubnetworks(SubnetworkAggregatedListOption... options) {
    return listSubnetworks(options(), optionMap(options));
  }

  private static Page<Subnetwork> listSubnetworks(final ComputeOptions serviceOptions,
      final Map<ComputeRpc.Option, ?> optionsMap) {
    try {
      ComputeRpc.Tuple<String, Iterable<com.google.api.services.compute.model.Subnetwork>> result =
          runWithRetries(new Callable<ComputeRpc.Tuple<String,
              Iterable<com.google.api.services.compute.model.Subnetwork>>>() {
            @Override
            public ComputeRpc.Tuple<String,
                Iterable<com.google.api.services.compute.model.Subnetwork>> call() {
              return serviceOptions.rpc().listSubnetworks(optionsMap);
            }
          }, serviceOptions.retryParams(), EXCEPTION_HANDLER, serviceOptions.clock());
      String cursor = result.x();
      Iterable<Subnetwork> subnetworks = Iterables.transform(
          result.y() == null ? ImmutableList.<com.google.api.services.compute.model.Subnetwork>of()
              : result.y(), subnetworkFromPb(serviceOptions));
      return new PageImpl<>(new AggregatedSubnetworkPageFetcher(serviceOptions, cursor, optionsMap),
          cursor, subnetworks);
    } catch (RetryHelper.RetryHelperException e) {
      throw ComputeException.translateAndThrow(e);
    }
  }

  @Override
  public Operation deleteSubnetwork(final SubnetworkId subnetwork, OperationOption... options) {
    final Map<ComputeRpc.Option, ?> optionsMap = optionMap(options);
    try {
      com.google.api.services.compute.model.Operation answer =
          runWithRetries(new Callable<com.google.api.services.compute.model.Operation>() {
            @Override
            public com.google.api.services.compute.model.Operation call() {
              return computeRpc.deleteSubnetwork(subnetwork.getRegion(), subnetwork.getSubnetwork(),
                  optionsMap);
            }
          }, options().retryParams(), EXCEPTION_HANDLER, options().clock());
      return answer == null ? null : Operation.fromPb(this, answer);
    } catch (RetryHelper.RetryHelperException e) {
      throw ComputeException.translateAndThrow(e);
    }
  }

  @Override
  public Operation create(NetworkInfo network, OperationOption... options) {
    final NetworkInfo completeNetwork = network.setProjectId(options().projectId());
    final Map<ComputeRpc.Option, ?> optionsMap = optionMap(options);
    try {
      com.google.api.services.compute.model.Operation answer =
          runWithRetries(new Callable<com.google.api.services.compute.model.Operation>() {
            @Override
            public com.google.api.services.compute.model.Operation call() {
              return computeRpc.createNetwork(completeNetwork.toPb(), optionsMap);
            }
          }, options().retryParams(), EXCEPTION_HANDLER, options().clock());
      return answer == null ? null : Operation.fromPb(this, answer);
    } catch (RetryHelper.RetryHelperException e) {
      throw ComputeException.translateAndThrow(e);
    }
  }

  @Override
  public Network getNetwork(final String network, NetworkOption... options) {
    final Map<ComputeRpc.Option, ?> optionsMap = optionMap(options);
    try {
      com.google.api.services.compute.model.Network answer =
          runWithRetries(new Callable<com.google.api.services.compute.model.Network>() {
            @Override
            public com.google.api.services.compute.model.Network call() {
              return computeRpc.getNetwork(network, optionsMap);
            }
          }, options().retryParams(), EXCEPTION_HANDLER, options().clock());
      return answer == null ? null : Network.fromPb(this, answer);
    } catch (RetryHelper.RetryHelperException e) {
      throw ComputeException.translateAndThrow(e);
    }
  }

  @Override
  public Page<Network> listNetworks(NetworkListOption... options) {
    return listNetworks(options(), optionMap(options));
  }

  private static Page<Network> listNetworks(final ComputeOptions serviceOptions,
      final Map<ComputeRpc.Option, ?> optionsMap) {
    try {
      ComputeRpc.Tuple<String, Iterable<com.google.api.services.compute.model.Network>> result =
          runWithRetries(new Callable<ComputeRpc.Tuple<String,
              Iterable<com.google.api.services.compute.model.Network>>>() {
            @Override
            public ComputeRpc.Tuple<String,
                Iterable<com.google.api.services.compute.model.Network>> call() {
              return serviceOptions.rpc().listNetworks(optionsMap);
            }
          }, serviceOptions.retryParams(), EXCEPTION_HANDLER, serviceOptions.clock());
      String cursor = result.x();
      Iterable<Network> networks = Iterables.transform(
          result.y() == null ? ImmutableList.<com.google.api.services.compute.model.Network>of()
              : result.y(),
          new Function<com.google.api.services.compute.model.Network, Network>() {
            @Override
            public Network apply(com.google.api.services.compute.model.Network network) {
              return Network.fromPb(serviceOptions.service(), network);
            }
          });
      return new PageImpl<>(new NetworkPageFetcher(serviceOptions, cursor, optionsMap),
          cursor, networks);
    } catch (RetryHelper.RetryHelperException e) {
      throw ComputeException.translateAndThrow(e);
    }
  }

  @Override
  public Operation deleteNetwork(final NetworkId network, OperationOption... options) {
    final Map<ComputeRpc.Option, ?> optionsMap = optionMap(options);
    try {
      com.google.api.services.compute.model.Operation answer =
          runWithRetries(new Callable<com.google.api.services.compute.model.Operation>() {
            @Override
            public com.google.api.services.compute.model.Operation call() {
              return computeRpc.deleteNetwork(network.getNetwork(), optionsMap);
            }
          }, options().retryParams(), EXCEPTION_HANDLER, options().clock());
      return answer == null ? null : Operation.fromPb(this, answer);
    } catch (RetryHelper.RetryHelperException e) {
      throw ComputeException.translateAndThrow(e);
    }
  }

  @Override
  public Operation deleteNetwork(String network, OperationOption... options) {
    return deleteNetwork(NetworkId.of(network));
  }

  @Override
  public Operation create(InstanceInfo instance, OperationOption... options) {
    final InstanceInfo completeInstance = instance.setProjectId(options().projectId());
    final Map<ComputeRpc.Option, ?> optionsMap = optionMap(options);
    try {
      com.google.api.services.compute.model.Operation answer =
          runWithRetries(new Callable<com.google.api.services.compute.model.Operation>() {
            @Override
            public com.google.api.services.compute.model.Operation call() {
              return computeRpc.createInstance(completeInstance.getInstanceId().getZone(),
                  completeInstance.toPb(), optionsMap);
            }
          }, options().retryParams(), EXCEPTION_HANDLER, options().clock());
      return answer == null ? null : Operation.fromPb(this, answer);
    } catch (RetryHelper.RetryHelperException e) {
      throw ComputeException.translateAndThrow(e);
    }
  }

  @Override
  public Instance getInstance(final InstanceId instance, InstanceOption... options) {
    final Map<ComputeRpc.Option, ?> optionsMap = optionMap(options);
    try {
      com.google.api.services.compute.model.Instance answer =
          runWithRetries(new Callable<com.google.api.services.compute.model.Instance>() {
            @Override
            public com.google.api.services.compute.model.Instance call() {
              return computeRpc.getInstance(instance.getZone(), instance.getInstance(), optionsMap);
            }
          }, options().retryParams(), EXCEPTION_HANDLER, options().clock());
      return answer == null ? null : Instance.fromPb(this, answer);
    } catch (RetryHelper.RetryHelperException e) {
      throw ComputeException.translateAndThrow(e);
    }
  }

  private static Function<com.google.api.services.compute.model.Instance, Instance>
      instanceFromPb(final ComputeOptions serviceOptions) {
    return new Function<com.google.api.services.compute.model.Instance, Instance>() {
      @Override
      public Instance apply(com.google.api.services.compute.model.Instance instance) {
        return Instance.fromPb(serviceOptions.service(), instance);
      }
    };
  }

  @Override
  public Page<Instance> listInstances(String zone, InstanceListOption... options) {
    return listInstances(zone, options(), optionMap(options));
  }

  private static Page<Instance> listInstances(final String zone,
      final ComputeOptions serviceOptions, final Map<ComputeRpc.Option, ?> optionsMap) {
    try {
      ComputeRpc.Tuple<String, Iterable<com.google.api.services.compute.model.Instance>> result =
          runWithRetries(new Callable<ComputeRpc.Tuple<String,
              Iterable<com.google.api.services.compute.model.Instance>>>() {
            @Override
            public ComputeRpc.Tuple<String,
                Iterable<com.google.api.services.compute.model.Instance>> call() {
              return serviceOptions.rpc().listInstances(zone, optionsMap);
            }
          }, serviceOptions.retryParams(), EXCEPTION_HANDLER, serviceOptions.clock());
      String cursor = result.x();
      Iterable<Instance> instances = Iterables.transform(
          result.y() == null ? ImmutableList.<com.google.api.services.compute.model.Instance>of()
              : result.y(), instanceFromPb(serviceOptions));
      return new PageImpl<>(new InstancePageFetcher(zone, serviceOptions, cursor, optionsMap),
          cursor, instances);
    } catch (RetryHelper.RetryHelperException e) {
      throw ComputeException.translateAndThrow(e);
    }
  }

  @Override
  public Page<Instance> listInstances(InstanceAggregatedListOption... options) {
    return listInstances(options(), optionMap(options));
  }

  private static Page<Instance> listInstances(final ComputeOptions serviceOptions,
      final Map<ComputeRpc.Option, ?> optionsMap) {
    try {
      ComputeRpc.Tuple<String, Iterable<com.google.api.services.compute.model.Instance>> result =
          runWithRetries(new Callable<ComputeRpc.Tuple<String,
              Iterable<com.google.api.services.compute.model.Instance>>>() {
            @Override
            public ComputeRpc.Tuple<String,
                Iterable<com.google.api.services.compute.model.Instance>> call() {
              return serviceOptions.rpc().listInstances(optionsMap);
            }
          }, serviceOptions.retryParams(), EXCEPTION_HANDLER, serviceOptions.clock());
      String cursor = result.x();
      Iterable<Instance> instances = Iterables.transform(
          result.y() == null ? ImmutableList.<com.google.api.services.compute.model.Instance>of()
              : result.y(), instanceFromPb(serviceOptions));
      return new PageImpl<>(new AggregatedInstancePageFetcher(serviceOptions, cursor, optionsMap),
          cursor, instances);
    } catch (RetryHelper.RetryHelperException e) {
      throw ComputeException.translateAndThrow(e);
    }
  }

  @Override
  public Operation deleteInstance(final InstanceId instance, OperationOption... options) {
    final Map<ComputeRpc.Option, ?> optionsMap = optionMap(options);
    try {
      com.google.api.services.compute.model.Operation answer =
          runWithRetries(new Callable<com.google.api.services.compute.model.Operation>() {
            @Override
            public com.google.api.services.compute.model.Operation call() {
              return computeRpc.deleteInstance(instance.getZone(), instance.getInstance(),
                  optionsMap);
            }
          }, options().retryParams(), EXCEPTION_HANDLER, options().clock());
      return answer == null ? null : Operation.fromPb(this, answer);
    } catch (RetryHelper.RetryHelperException e) {
      throw ComputeException.translateAndThrow(e);
    }
  }

  @Override
  public Operation addAccessConfig(final InstanceId instance, final String networkInterface,
      final AccessConfig accessConfig, OperationOption... options) {
    final Map<ComputeRpc.Option, ?> optionsMap = optionMap(options);
    try {
      com.google.api.services.compute.model.Operation answer =
          runWithRetries(new Callable<com.google.api.services.compute.model.Operation>() {
            @Override
            public com.google.api.services.compute.model.Operation call() {
              return computeRpc.addAccessConfig(instance.getZone(), instance.getInstance(),
                  networkInterface, accessConfig.toPb(), optionsMap);
            }
          }, options().retryParams(), EXCEPTION_HANDLER, options().clock());
      return answer == null ? null : Operation.fromPb(this, answer);
    } catch (RetryHelper.RetryHelperException e) {
      throw ComputeException.translateAndThrow(e);
    }
  }

  private Operation attachDisk(final InstanceId instance, AttachedDisk diskToAttach,
      OperationOption... options) {
    final AttachedDisk completeDisk = diskToAttach.setProjectId(options().projectId());
    final Map<ComputeRpc.Option, ?> optionsMap = optionMap(options);
    try {
      com.google.api.services.compute.model.Operation answer =
          runWithRetries(new Callable<com.google.api.services.compute.model.Operation>() {
            @Override
            public com.google.api.services.compute.model.Operation call() {
              return computeRpc.attachDisk(instance.getZone(), instance.getInstance(),
                  completeDisk.toPb(), optionsMap);
            }
          }, options().retryParams(), EXCEPTION_HANDLER, options().clock());
      return answer == null ? null : Operation.fromPb(this, answer);
    } catch (RetryHelper.RetryHelperException e) {
      throw ComputeException.translateAndThrow(e);
    }
  }

  @Override
  public Operation attachDisk(InstanceId instance, PersistentDiskConfiguration configuration,
      OperationOption... options) {
    return attachDisk(instance, AttachedDisk.of(configuration), options);
  }

  @Override
  public Operation attachDisk(InstanceId instance, String deviceName,
      PersistentDiskConfiguration configuration, OperationOption... options) {
    return attachDisk(instance, AttachedDisk.of(deviceName, configuration), options);
  }

  @Override
  public Operation attachDisk(InstanceId instance, String deviceName,
      PersistentDiskConfiguration configuration, int index, OperationOption... options) {
    AttachedDisk attachedDisk = AttachedDisk.newBuilder(configuration)
        .setDeviceName(deviceName)
        .setIndex(index)
        .build();
    return attachDisk(instance, attachedDisk, options);
  }

  @Override
  public Operation deleteAccessConfig(final InstanceId instance, final String networkInterface,
      final String accessConfig, OperationOption... options) {
    final Map<ComputeRpc.Option, ?> optionsMap = optionMap(options);
    try {
      com.google.api.services.compute.model.Operation answer =
          runWithRetries(new Callable<com.google.api.services.compute.model.Operation>() {
            @Override
            public com.google.api.services.compute.model.Operation call() {
              return computeRpc.deleteAccessConfig(instance.getZone(), instance.getInstance(),
                  networkInterface, accessConfig, optionsMap);
            }
          }, options().retryParams(), EXCEPTION_HANDLER, options().clock());
      return answer == null ? null : Operation.fromPb(this, answer);
    } catch (RetryHelper.RetryHelperException e) {
      throw ComputeException.translateAndThrow(e);
    }
  }

  @Override
  public Operation detachDisk(final InstanceId instance, final String deviceName,
      OperationOption... options) {
    final Map<ComputeRpc.Option, ?> optionsMap = optionMap(options);
    try {
      com.google.api.services.compute.model.Operation answer =
          runWithRetries(new Callable<com.google.api.services.compute.model.Operation>() {
            @Override
            public com.google.api.services.compute.model.Operation call() {
              return computeRpc.detachDisk(instance.getZone(), instance.getInstance(), deviceName,
                  optionsMap);
            }
          }, options().retryParams(), EXCEPTION_HANDLER, options().clock());
      return answer == null ? null : Operation.fromPb(this, answer);
    } catch (RetryHelper.RetryHelperException e) {
      throw ComputeException.translateAndThrow(e);
    }
  }

  @Override
  public String getSerialPortOutput(final InstanceId instance, final int port) {
    try {
      return runWithRetries(new Callable<String>() {
        @Override
        public String call() {
          return computeRpc.getSerialPortOutput(instance.getZone(), instance.getInstance(), port,
              optionMap());
        }
      }, options().retryParams(), EXCEPTION_HANDLER, options().clock());
    } catch (RetryHelper.RetryHelperException e) {
      throw ComputeException.translateAndThrow(e);
    }
  }

  @Override
  public String getSerialPortOutput(final InstanceId instance) {
    try {
      return runWithRetries(new Callable<String>() {
        @Override
        public String call() {
          return computeRpc.getSerialPortOutput(instance.getZone(), instance.getInstance(), null,
              optionMap());
        }
      }, options().retryParams(), EXCEPTION_HANDLER, options().clock());
    } catch (RetryHelper.RetryHelperException e) {
      throw ComputeException.translateAndThrow(e);
    }
  }

  @Override
  public Operation reset(final InstanceId instance, OperationOption... options) {
    final Map<ComputeRpc.Option, ?> optionsMap = optionMap(options);
    try {
      com.google.api.services.compute.model.Operation answer =
          runWithRetries(new Callable<com.google.api.services.compute.model.Operation>() {
            @Override
            public com.google.api.services.compute.model.Operation call() {
              return computeRpc.reset(instance.getZone(), instance.getInstance(), optionsMap);
            }
          }, options().retryParams(), EXCEPTION_HANDLER, options().clock());
      return answer == null ? null : Operation.fromPb(this, answer);
    } catch (RetryHelper.RetryHelperException e) {
      throw ComputeException.translateAndThrow(e);
    }
  }

  @Override
  public Operation setDiskAutoDelete(final InstanceId instance, final String deviceName,
      final boolean autoDelete, OperationOption... options) {
    final Map<ComputeRpc.Option, ?> optionsMap = optionMap(options);
    try {
      com.google.api.services.compute.model.Operation answer =
          runWithRetries(new Callable<com.google.api.services.compute.model.Operation>() {
            @Override
            public com.google.api.services.compute.model.Operation call() {
              return computeRpc.setDiskAutoDelete(instance.getZone(), instance.getInstance(),
                  deviceName, autoDelete, optionsMap);
            }
          }, options().retryParams(), EXCEPTION_HANDLER, options().clock());
      return answer == null ? null : Operation.fromPb(this, answer);
    } catch (RetryHelper.RetryHelperException e) {
      throw ComputeException.translateAndThrow(e);
    }
  }

  @Override
  public Operation setMachineType(final InstanceId instance, final MachineTypeId machineType,
      OperationOption... options) {
    final String machineTypeUrl = machineType.setProjectId(options().projectId()).getSelfLink();
    final Map<ComputeRpc.Option, ?> optionsMap = optionMap(options);
    try {
      com.google.api.services.compute.model.Operation answer =
          runWithRetries(new Callable<com.google.api.services.compute.model.Operation>() {
            @Override
            public com.google.api.services.compute.model.Operation call() {
              return computeRpc.setMachineType(instance.getZone(), instance.getInstance(),
                  machineTypeUrl, optionsMap);
            }
          }, options().retryParams(), EXCEPTION_HANDLER, options().clock());
      return answer == null ? null : Operation.fromPb(this, answer);
    } catch (RetryHelper.RetryHelperException e) {
      throw ComputeException.translateAndThrow(e);
    }
  }

  @Override
  public Operation setMetadata(final InstanceId instance, final Metadata metadata,
      OperationOption... options) {
    final Map<ComputeRpc.Option, ?> optionsMap = optionMap(options);
    try {
      com.google.api.services.compute.model.Operation answer =
          runWithRetries(new Callable<com.google.api.services.compute.model.Operation>() {
            @Override
            public com.google.api.services.compute.model.Operation call() {
              return computeRpc.setMetadata(instance.getZone(), instance.getInstance(),
                  metadata.toPb(), optionsMap);
            }
          }, options().retryParams(), EXCEPTION_HANDLER, options().clock());
      return answer == null ? null : Operation.fromPb(this, answer);
    } catch (RetryHelper.RetryHelperException e) {
      throw ComputeException.translateAndThrow(e);
    }
  }

  @Override
  public Operation setSchedulingOptions(final InstanceId instance,
      final SchedulingOptions schedulingOptions, OperationOption... options) {
    final Map<ComputeRpc.Option, ?> optionsMap = optionMap(options);
    try {
      com.google.api.services.compute.model.Operation answer =
          runWithRetries(new Callable<com.google.api.services.compute.model.Operation>() {
            @Override
            public com.google.api.services.compute.model.Operation call() {
              return computeRpc.setScheduling(instance.getZone(), instance.getInstance(),
                  schedulingOptions.toPb(), optionsMap);
            }
          }, options().retryParams(), EXCEPTION_HANDLER, options().clock());
      return answer == null ? null : Operation.fromPb(this, answer);
    } catch (RetryHelper.RetryHelperException e) {
      throw ComputeException.translateAndThrow(e);
    }
  }

  @Override
  public Operation setTags(final InstanceId instance, final Tags tags, OperationOption... options) {
    final Map<ComputeRpc.Option, ?> optionsMap = optionMap(options);
    try {
      com.google.api.services.compute.model.Operation answer =
          runWithRetries(new Callable<com.google.api.services.compute.model.Operation>() {
            @Override
            public com.google.api.services.compute.model.Operation call() {
              return computeRpc.setTags(instance.getZone(), instance.getInstance(), tags.toPb(),
                  optionsMap);
            }
          }, options().retryParams(), EXCEPTION_HANDLER, options().clock());
      return answer == null ? null : Operation.fromPb(this, answer);
    } catch (RetryHelper.RetryHelperException e) {
      throw ComputeException.translateAndThrow(e);
    }
  }

  @Override
  public Operation start(final InstanceId instance, OperationOption... options) {
    final Map<ComputeRpc.Option, ?> optionsMap = optionMap(options);
    try {
      com.google.api.services.compute.model.Operation answer =
          runWithRetries(new Callable<com.google.api.services.compute.model.Operation>() {
            @Override
            public com.google.api.services.compute.model.Operation call() {
              return computeRpc.start(instance.getZone(), instance.getInstance(), optionsMap);
            }
          }, options().retryParams(), EXCEPTION_HANDLER, options().clock());
      return answer == null ? null : Operation.fromPb(this, answer);
    } catch (RetryHelper.RetryHelperException e) {
      throw ComputeException.translateAndThrow(e);
    }
  }

  @Override
  public Operation stop(final InstanceId instance, OperationOption... options) {
    final Map<ComputeRpc.Option, ?> optionsMap = optionMap(options);
    try {
      com.google.api.services.compute.model.Operation answer =
          runWithRetries(new Callable<com.google.api.services.compute.model.Operation>() {
            @Override
            public com.google.api.services.compute.model.Operation call() {
              return computeRpc.stop(instance.getZone(), instance.getInstance(), optionsMap);
            }
          }, options().retryParams(), EXCEPTION_HANDLER, options().clock());
      return answer == null ? null : Operation.fromPb(this, answer);
    } catch (RetryHelper.RetryHelperException e) {
      throw ComputeException.translateAndThrow(e);
    }
  }

  private Map<ComputeRpc.Option, ?> optionMap(Option... options) {
    Map<ComputeRpc.Option, Object> optionMap = Maps.newEnumMap(ComputeRpc.Option.class);
    for (Option option : options) {
      Object prev = optionMap.put(option.getRpcOption(), option.getValue());
      checkArgument(prev == null, "Duplicate option %s", option);
    }
    return optionMap;
  }
}
