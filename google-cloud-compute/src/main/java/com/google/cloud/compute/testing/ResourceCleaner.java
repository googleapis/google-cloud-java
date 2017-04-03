/*
 * Copyright 2017 Google Inc. All Rights Reserved.
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

package com.google.cloud.compute.testing;

import com.google.cloud.compute.AddressId;
import com.google.cloud.compute.Compute;
import com.google.cloud.compute.DiskId;
import com.google.cloud.compute.ImageId;
import com.google.cloud.compute.InstanceId;
import com.google.cloud.compute.NetworkId;
import com.google.cloud.compute.SnapshotId;
import com.google.cloud.compute.SubnetworkId;
import com.google.common.base.Function;
import java.util.HashMap;
import java.util.Map;
import java.util.NoSuchElementException;

public class ResourceCleaner {
  private final Compute compute;
  private final Map<Object, ManagedResource<?>> resources;

  private ResourceCleaner(Compute compute) {
    this.compute = compute;
    this.resources = new HashMap<>();
  }

  public static ResourceCleaner create(Compute compute) {
    return new ResourceCleaner(compute);
  }

  private class ManagedResource<T> {
    final T res;
    Function<T, Void> func;

    private ManagedResource(T res, Function<T, Void> func) {
      this.res = res;
      this.func = func;
    }

    public void delete() {
      func.apply(res);
    }
  }

  public void cleanUp() {
    for (Map.Entry<Object, ManagedResource<?>> r : resources.entrySet()) {
      System.out.println("Clean up compute engine resource: " + r.getKey().toString());
      r.getValue().delete();
    }
    resources.clear();
  }

  public ResourceCleaner add(AddressId addressId) {
    ManagedResource<AddressId> r =
        new ManagedResource<>(
            addressId,
            new Function<AddressId, Void>() {
              @Override
              public Void apply(AddressId addressId) {
                compute.deleteAddress(addressId);
                return null;
              }
            });
    resources.put(addressId, r);
    return this;
  }

  public ResourceCleaner add(DiskId diskId) {
    ManagedResource<DiskId> r =
        new ManagedResource<>(
            diskId,
            new Function<DiskId, Void>() {
              @Override
              public Void apply(DiskId diskId) {
                compute.deleteDisk(diskId);
                return null;
              }
            });
    resources.put(diskId, r);
    return this;
  }

  public ResourceCleaner add(SnapshotId snapshotId) {
    ManagedResource<SnapshotId> r =
        new ManagedResource<>(
            snapshotId,
            new Function<SnapshotId, Void>() {
              @Override
              public Void apply(SnapshotId snapshotId) {
                compute.deleteSnapshot(snapshotId);
                return null;
              }
            });
    resources.put(snapshotId, r);
    return this;
  }

  public ResourceCleaner add(NetworkId networkId) {
    ManagedResource<NetworkId> r =
        new ManagedResource<>(
            networkId,
            new Function<NetworkId, Void>() {
              @Override
              public Void apply(NetworkId networkId) {
                compute.deleteNetwork(networkId);
                return null;
              }
            });
    resources.put(networkId, r);
    return this;
  }

  public ResourceCleaner add(SubnetworkId subnetworkId) {
    ManagedResource<SubnetworkId> r =
        new ManagedResource<>(
            subnetworkId,
            new Function<SubnetworkId, Void>() {
              @Override
              public Void apply(SubnetworkId subnetworkId) {
                compute.deleteSubnetwork(subnetworkId);
                return null;
              }
            });
    resources.put(subnetworkId, r);
    return this;
  }

  public ResourceCleaner add(ImageId imageId) {
    ManagedResource<ImageId> r =
        new ManagedResource<>(
            imageId,
            new Function<ImageId, Void>() {
              @Override
              public Void apply(ImageId imageId) {
                compute.deleteImage(imageId);
                return null;
              }
            });
    resources.put(imageId, r);
    return this;
  }

  public ResourceCleaner add(InstanceId instanceId) {
    ManagedResource<InstanceId> r =
        new ManagedResource<>(
            instanceId,
            new Function<InstanceId, Void>() {
              @Override
              public Void apply(InstanceId instanceId) {
                compute.deleteInstance(instanceId);
                return null;
              }
            });
    resources.put(instanceId, r);
    return this;
  }

  public <T> ResourceCleaner remove(T resourceId) {
    if (!resources.containsKey(resourceId)) {
        throw new NoSuchElementException(resourceId + " has not been added to managed resources");
    }
    resources.remove(resourceId);
    return this;
  }
}
