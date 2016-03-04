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

package com.google.gcloud.spi;

import static com.google.gcloud.spi.ComputeRpc.Option.FIELDS;
import static com.google.gcloud.spi.ComputeRpc.Option.FILTER;
import static com.google.gcloud.spi.ComputeRpc.Option.MAX_RESULTS;
import static com.google.gcloud.spi.ComputeRpc.Option.PAGE_TOKEN;
import static java.net.HttpURLConnection.HTTP_NOT_FOUND;

import com.google.api.client.http.HttpRequestInitializer;
import com.google.api.client.http.HttpTransport;
import com.google.api.client.json.jackson.JacksonFactory;
import com.google.api.services.compute.Compute;
import com.google.api.services.compute.model.DiskType;
import com.google.api.services.compute.model.DiskTypeAggregatedList;
import com.google.api.services.compute.model.DiskTypeList;
import com.google.api.services.compute.model.DiskTypesScopedList;
import com.google.api.services.compute.model.License;
import com.google.api.services.compute.model.MachineType;
import com.google.api.services.compute.model.MachineTypeAggregatedList;
import com.google.api.services.compute.model.MachineTypeList;
import com.google.api.services.compute.model.MachineTypesScopedList;
import com.google.api.services.compute.model.Region;
import com.google.api.services.compute.model.RegionList;
import com.google.api.services.compute.model.Zone;
import com.google.api.services.compute.model.ZoneList;
import com.google.common.collect.ImmutableList;
import com.google.gcloud.compute.ComputeException;
import com.google.gcloud.compute.ComputeOptions;

import java.io.IOException;
import java.util.Map;

public class DefaultComputeRpc implements ComputeRpc {

  private final ComputeOptions options;
  private final Compute compute;

  public DefaultComputeRpc(ComputeOptions options) {
    HttpTransport transport = options.httpTransportFactory().create();
    HttpRequestInitializer initializer = options.httpRequestInitializer();
    this.options = options;
    compute = new Compute.Builder(transport, new JacksonFactory(), initializer)
        .setRootUrl(options.host())
        .setApplicationName(options.applicationName())
        .build();
  }

  private static ComputeException translate(IOException exception) {
    return new ComputeException(exception);
  }

  @Override
  public DiskType getDiskType(String zone, String diskType, Map<Option, ?> options) {
    try {
      return compute.diskTypes()
          .get(this.options.projectId(), zone, diskType)
          .setFields(FIELDS.getString(options))
          .execute();
    } catch (IOException ex) {
      return nullForNotFound(ex);
    }
  }

  @Override
  public Tuple<String, Iterable<DiskType>> listDiskTypes(String zone, Map<Option, ?> options) {
    try {
      DiskTypeList diskTypesList = compute.diskTypes()
          .list(this.options.projectId(), zone)
          .setFilter(FILTER.getString(options))
          .setMaxResults(MAX_RESULTS.getLong(options))
          .setPageToken(PAGE_TOKEN.getString(options))
          .setFields(FIELDS.getString(options))
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
          .aggregatedList(this.options.projectId())
          .setFilter(FILTER.getString(options))
          .setMaxResults(MAX_RESULTS.getLong(options))
          .setPageToken(PAGE_TOKEN.getString(options))
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
          .get(this.options.projectId(), zone, machineType)
          .setFields(FIELDS.getString(options))
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
          .list(this.options.projectId(), zone)
          .setFilter(FILTER.getString(options))
          .setMaxResults(MAX_RESULTS.getLong(options))
          .setPageToken(PAGE_TOKEN.getString(options))
          .setFields(FIELDS.getString(options))
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
          .aggregatedList(this.options.projectId())
          .setFilter(FILTER.getString(options))
          .setMaxResults(MAX_RESULTS.getLong(options))
          .setPageToken(PAGE_TOKEN.getString(options))
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
          .get(this.options.projectId(), region)
          .setFields(FIELDS.getString(options))
          .execute();
    } catch (IOException ex) {
      return nullForNotFound(ex);
    }
  }

  @Override
  public Tuple<String, Iterable<Region>> listRegions(Map<Option, ?> options) {
    try {
      RegionList regionsList = compute.regions()
          .list(this.options.projectId())
          .setFilter(FILTER.getString(options))
          .setMaxResults(MAX_RESULTS.getLong(options))
          .setPageToken(PAGE_TOKEN.getString(options))
          .setFields(FIELDS.getString(options))
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
          .get(this.options.projectId(), zone)
          .setFields(FIELDS.getString(options))
          .execute();
    } catch (IOException ex) {
      return nullForNotFound(ex);
    }
  }

  @Override
  public Tuple<String, Iterable<Zone>> listZones(Map<Option, ?> options) {
    try {
      ZoneList zonesList = compute.zones()
          .list(this.options.projectId())
          .setFilter(FILTER.getString(options))
          .setMaxResults(MAX_RESULTS.getLong(options))
          .setPageToken(PAGE_TOKEN.getString(options))
          .setFields(FIELDS.getString(options))
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
          .setFields(FIELDS.getString(options))
          .execute();
    } catch (IOException ex) {
      return nullForNotFound(ex);
    }
  }

  /**
   * This method returns {@code null} if the error code of {@code exception} was 404, re-throws the
   * exception otherwise.
   *
   * @throws ComputeException if the error code of {@code exception} was not 404.
   */
  private static <T> T nullForNotFound(IOException exception) {
    ComputeException serviceException = translate(exception);
    if (serviceException.code() == HTTP_NOT_FOUND) {
      return (T) null;
    }
    throw serviceException;
  }
}
