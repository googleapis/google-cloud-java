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
import sun.reflect.generics.reflectiveObjects.NotImplementedException;

public class ManagedResourceCleaner {
  private final Compute compute;
  private final Map<Object, ManagedResource<?>> resources;

  private ManagedResourceCleaner(Compute compute) {
    this.compute = compute;
    this.resources = new HashMap<>();
  }

  public static ManagedResourceCleaner create(Compute compute) {
    return new ManagedResourceCleaner(compute);
  }

  private class ManagedResource<T> {
    final T res;
    Function<T, Void> func;

    private ManagedResource(T res) {
      this.res = res;

      @SuppressWarnings("unchecked")
      Function<T, Void> localFunc = (Function<T, Void>) getDeleteMethod(res);

      this.func = localFunc;
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

  public ManagedResourceCleaner add(AddressId addressId) {
    ManagedResource<AddressId> r = new ManagedResource<>(addressId);
    resources.put(addressId, r);
    return this;
  }

  public ManagedResourceCleaner remove(AddressId addressId) {
    resources.remove(addressId);
    return this;
  }

  public ManagedResourceCleaner add(DiskId diskId) {
    ManagedResource<DiskId> r = new ManagedResource<>(diskId);
    resources.put(diskId, r);
    return this;
  }

  public ManagedResourceCleaner remove(DiskId diskId) {
    resources.remove(diskId);
    return this;
  }

  public ManagedResourceCleaner add(SnapshotId snapshotId) {
    ManagedResource<SnapshotId> r = new ManagedResource<>(snapshotId);
    resources.put(snapshotId, r);
    return this;
  }

  public ManagedResourceCleaner remove(SnapshotId snapshotId) {
    resources.remove(snapshotId);
    return this;
  }

  public ManagedResourceCleaner add(NetworkId networkId) {
    ManagedResource<NetworkId> r = new ManagedResource<>(networkId);
    resources.put(networkId, r);
    return this;
  }

  public ManagedResourceCleaner remove(NetworkId networkId) {
    resources.remove(networkId);
    return this;
  }

  public ManagedResourceCleaner add(SubnetworkId subnetworkId) {
    ManagedResource<SubnetworkId> r = new ManagedResource<>(subnetworkId);
    resources.put(subnetworkId, r);
    return this;
  }

  public ManagedResourceCleaner remove(SubnetworkId subnetworkId) {
    resources.remove(subnetworkId);
    return this;
  }

  public ManagedResourceCleaner add(ImageId imageId) {
    ManagedResource<ImageId> r = new ManagedResource<>(imageId);
    resources.put(imageId, r);
    return this;
  }

  public ManagedResourceCleaner remove(ImageId imageId) {
    resources.remove(imageId);
    return this;
  }

  public ManagedResourceCleaner add(InstanceId instanceId) {
    ManagedResource<InstanceId> r = new ManagedResource<>(instanceId);
    resources.put(instanceId, r);
    return this;
  }

  public ManagedResourceCleaner remove(InstanceId instanceId) {
    resources.remove(instanceId);
    return this;
  }

  private <T> Function<?, Void> getDeleteMethod(T res) {

    if (res instanceof AddressId) {
      return new Function<AddressId, Void>() {
        @Override
        public Void apply(AddressId addressId) {
          compute.deleteAddress(addressId);
          return null;
        }
      };
    } else if (res instanceof DiskId) {
      return new Function<DiskId, Void>() {
        @Override
        public Void apply(DiskId diskId) {
          compute.deleteDisk(diskId);
          return null;
        }
      };
    } else if (res instanceof SnapshotId) {
      return new Function<SnapshotId, Void>() {
        @Override
        public Void apply(SnapshotId snapshotId) {
          compute.deleteSnapshot(snapshotId);
          return null;
        }
      };
    } else if (res instanceof NetworkId) {
      return new Function<NetworkId, Void>() {
        @Override
        public Void apply(NetworkId networkId) {
          compute.deleteNetwork(networkId);
          return null;
        }
      };
    } else if (res instanceof SubnetworkId) {
      return new Function<SubnetworkId, Void>() {
        @Override
        public Void apply(SubnetworkId subnetworkId) {
          compute.deleteSubnetwork(subnetworkId);
          return null;
        }
      };
    } else if (res instanceof ImageId) {
      return new Function<ImageId, Void>() {
        @Override
        public Void apply(ImageId imageId) {
          compute.deleteImage(imageId);
          return null;
        }
      };
    } else if (res instanceof InstanceId) {
      return new Function<InstanceId, Void>() {
        @Override
        public Void apply(InstanceId instanceId) {
          compute.deleteInstance(instanceId);
          return null;
        }
      };
    } else {
      throw new NotImplementedException();
    }
  }
}
