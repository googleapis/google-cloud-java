/*
 * Copyright 2020 Google LLC
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
package com.google.cloud.compute.v1.stub;

import static com.google.cloud.compute.v1.PacketMirroringClient.AggregatedListPacketMirroringsPagedResponse;
import static com.google.cloud.compute.v1.PacketMirroringClient.ListPacketMirroringsPagedResponse;

import com.google.api.core.BetaApi;
import com.google.api.gax.core.BackgroundResource;
import com.google.api.gax.rpc.UnaryCallable;
import com.google.cloud.compute.v1.AggregatedListPacketMirroringsHttpRequest;
import com.google.cloud.compute.v1.DeletePacketMirroringHttpRequest;
import com.google.cloud.compute.v1.GetPacketMirroringHttpRequest;
import com.google.cloud.compute.v1.InsertPacketMirroringHttpRequest;
import com.google.cloud.compute.v1.ListPacketMirroringsHttpRequest;
import com.google.cloud.compute.v1.Operation;
import com.google.cloud.compute.v1.PacketMirroring;
import com.google.cloud.compute.v1.PacketMirroringAggregatedList;
import com.google.cloud.compute.v1.PacketMirroringList;
import com.google.cloud.compute.v1.PatchPacketMirroringHttpRequest;
import com.google.cloud.compute.v1.TestIamPermissionsPacketMirroringHttpRequest;
import com.google.cloud.compute.v1.TestPermissionsResponse;
import javax.annotation.Generated;

// AUTO-GENERATED DOCUMENTATION AND CLASS
/**
 * Base stub class for compute.
 *
 * <p>This class is for advanced usage and reflects the underlying API directly.
 */
@Generated("by gapic-generator")
@BetaApi("A restructuring of stub classes is planned, so this may break in the future")
public abstract class PacketMirroringStub implements BackgroundResource {

  @BetaApi
  public UnaryCallable<
          AggregatedListPacketMirroringsHttpRequest, AggregatedListPacketMirroringsPagedResponse>
      aggregatedListPacketMirroringsPagedCallable() {
    throw new UnsupportedOperationException(
        "Not implemented: aggregatedListPacketMirroringsPagedCallable()");
  }

  @BetaApi
  public UnaryCallable<AggregatedListPacketMirroringsHttpRequest, PacketMirroringAggregatedList>
      aggregatedListPacketMirroringsCallable() {
    throw new UnsupportedOperationException(
        "Not implemented: aggregatedListPacketMirroringsCallable()");
  }

  @BetaApi
  public UnaryCallable<DeletePacketMirroringHttpRequest, Operation>
      deletePacketMirroringCallable() {
    throw new UnsupportedOperationException("Not implemented: deletePacketMirroringCallable()");
  }

  @BetaApi
  public UnaryCallable<GetPacketMirroringHttpRequest, PacketMirroring>
      getPacketMirroringCallable() {
    throw new UnsupportedOperationException("Not implemented: getPacketMirroringCallable()");
  }

  @BetaApi
  public UnaryCallable<InsertPacketMirroringHttpRequest, Operation>
      insertPacketMirroringCallable() {
    throw new UnsupportedOperationException("Not implemented: insertPacketMirroringCallable()");
  }

  @BetaApi
  public UnaryCallable<ListPacketMirroringsHttpRequest, ListPacketMirroringsPagedResponse>
      listPacketMirroringsPagedCallable() {
    throw new UnsupportedOperationException("Not implemented: listPacketMirroringsPagedCallable()");
  }

  @BetaApi
  public UnaryCallable<ListPacketMirroringsHttpRequest, PacketMirroringList>
      listPacketMirroringsCallable() {
    throw new UnsupportedOperationException("Not implemented: listPacketMirroringsCallable()");
  }

  @BetaApi
  public UnaryCallable<PatchPacketMirroringHttpRequest, Operation> patchPacketMirroringCallable() {
    throw new UnsupportedOperationException("Not implemented: patchPacketMirroringCallable()");
  }

  @BetaApi
  public UnaryCallable<TestIamPermissionsPacketMirroringHttpRequest, TestPermissionsResponse>
      testIamPermissionsPacketMirroringCallable() {
    throw new UnsupportedOperationException(
        "Not implemented: testIamPermissionsPacketMirroringCallable()");
  }

  @Override
  public abstract void close();
}
