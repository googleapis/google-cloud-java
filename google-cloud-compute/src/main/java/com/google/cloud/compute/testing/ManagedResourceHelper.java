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

import com.google.cloud.compute.Address;
import com.google.cloud.compute.AddressId;
import com.google.cloud.compute.Compute;
import com.google.cloud.compute.Disk;
import com.google.cloud.compute.DiskId;
import com.google.cloud.compute.Image;
import com.google.cloud.compute.Instance;
import com.google.cloud.compute.Network;
import com.google.cloud.compute.NetworkId;
import com.google.cloud.compute.Operation;
import com.google.cloud.compute.Snapshot;
import com.google.cloud.compute.SnapshotId;
import com.google.cloud.compute.Subnetwork;
import com.google.cloud.compute.SubnetworkId;
import com.google.common.base.Function;
import java.util.ArrayList;
import java.util.List;

public class ManagedResourceHelper {
  private final Compute compute;
  private final List<ManagedResource<?>> resources;

  private ManagedResourceHelper(Compute compute) {
    this.compute = compute;
    this.resources = new ArrayList<>();
  }

  public static ManagedResourceHelper create(Compute compute) {
    return new ManagedResourceHelper(compute);
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

  public <T> ManagedResourceHelper addManagedResource(T res) {
    ManagedResource<T> r = new ManagedResource<>(res);
    resources.add(r);
    return this;
  }

  public void cleanUpResources() {
    for (ManagedResource<?> r : resources) {
      r.delete();
      //TODO (neowu): add logging if a resource has not been deleted in test fixture
    }
    resources.clear();
  }

  private <T> Function<?, Void> getDeleteMethod(T res) {
    if (res instanceof Address) {
      return new Function<Address, Void>() {
        @Override
        public Void apply(Address address) {
          try {
            Operation operation = address.delete();
            operation.waitFor();
          } catch (Exception e) {

          } finally {
            return null;
          }
        }
      };
    } else if (res instanceof AddressId) {
      return new Function<AddressId, Void>() {
        @Override
        public Void apply(AddressId addressId) {
          compute.deleteAddress(addressId);
          return null;
        }
      };
    } else if (res instanceof Disk) {
      return new Function<Disk, Void>() {
        @Override
        public Void apply(Disk d) {
          try {
            Operation operation = d.delete();
            operation.waitFor();
          } catch (Exception e) {

          } finally {
            return null;
          }
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
    } else if (res instanceof Snapshot) {
      return new Function<Snapshot, Void>() {
        @Override
        public Void apply(Snapshot s) {
          try {
            Operation operation = s.delete();
            operation.waitFor();
          } catch (Exception e) {

          } finally {
            return null;
          }
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
    } else if (res instanceof Network) {
      return new Function<Network, Void>() {
        @Override
        public Void apply(Network n) {
          try {
            Operation operation = n.delete();
            operation.waitFor();
          } catch (Exception e) {

          } finally {
            return null;
          }
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
    } else if (res instanceof Subnetwork) {
      return new Function<Subnetwork, Void>() {
        @Override
        public Void apply(Subnetwork s) {
          try {
            Operation operation = s.delete();
            operation.waitFor();
          } catch (Exception e) {

          } finally {
            return null;
          }
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
    } else if (res instanceof Image) {
      return new Function<Image, Void>() {
        @Override
        public Void apply(Image i) {
          try {
            Operation operation = i.delete();
            operation.waitFor();
          } catch (Exception e) {

          } finally {
            return null;
          }
        }
      };
    } else if (res instanceof Instance) {
      return new Function<Instance, Void>() {
        @Override
        public Void apply(Instance i) {
          try {
            Operation operation = i.delete();
            operation.waitFor();
          } catch (Exception e) {

          } finally {
            return null;
          }
        }
      };
    } else {
      return new Function<T, Void>() {
        @Override
        public Void apply(T res) {
          return null;
        }
      };
    }
  }
}
