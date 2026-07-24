/*
 * Copyright 2026 Google LLC
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      https://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package com.google.ads.admanager.v1.stub;

import static com.google.ads.admanager.v1.TargetingPresetServiceClient.ListTargetingPresetsPagedResponse;

import com.google.ads.admanager.v1.BatchCreateTargetingPresetsRequest;
import com.google.ads.admanager.v1.BatchCreateTargetingPresetsResponse;
import com.google.ads.admanager.v1.BatchDeactivateTargetingPresetsRequest;
import com.google.ads.admanager.v1.BatchDeactivateTargetingPresetsResponse;
import com.google.ads.admanager.v1.BatchUpdateTargetingPresetsRequest;
import com.google.ads.admanager.v1.BatchUpdateTargetingPresetsResponse;
import com.google.ads.admanager.v1.CreateTargetingPresetRequest;
import com.google.ads.admanager.v1.GetTargetingPresetRequest;
import com.google.ads.admanager.v1.ListTargetingPresetsRequest;
import com.google.ads.admanager.v1.ListTargetingPresetsResponse;
import com.google.ads.admanager.v1.TargetingPreset;
import com.google.ads.admanager.v1.UpdateTargetingPresetRequest;
import com.google.api.gax.core.BackgroundResource;
import com.google.api.gax.rpc.UnaryCallable;
import javax.annotation.Generated;
import org.jspecify.annotations.NullMarked;

// AUTO-GENERATED DOCUMENTATION AND CLASS.
/**
 * Base stub class for the TargetingPresetService service API.
 *
 * <p>This class is for advanced usage and reflects the underlying API directly.
 */
@NullMarked
@Generated("by gapic-generator-java")
public abstract class TargetingPresetServiceStub implements BackgroundResource {

  public UnaryCallable<GetTargetingPresetRequest, TargetingPreset> getTargetingPresetCallable() {
    throw new UnsupportedOperationException("Not implemented: getTargetingPresetCallable()");
  }

  public UnaryCallable<ListTargetingPresetsRequest, ListTargetingPresetsPagedResponse>
      listTargetingPresetsPagedCallable() {
    throw new UnsupportedOperationException("Not implemented: listTargetingPresetsPagedCallable()");
  }

  public UnaryCallable<ListTargetingPresetsRequest, ListTargetingPresetsResponse>
      listTargetingPresetsCallable() {
    throw new UnsupportedOperationException("Not implemented: listTargetingPresetsCallable()");
  }

  public UnaryCallable<CreateTargetingPresetRequest, TargetingPreset>
      createTargetingPresetCallable() {
    throw new UnsupportedOperationException("Not implemented: createTargetingPresetCallable()");
  }

  public UnaryCallable<BatchCreateTargetingPresetsRequest, BatchCreateTargetingPresetsResponse>
      batchCreateTargetingPresetsCallable() {
    throw new UnsupportedOperationException(
        "Not implemented: batchCreateTargetingPresetsCallable()");
  }

  public UnaryCallable<UpdateTargetingPresetRequest, TargetingPreset>
      updateTargetingPresetCallable() {
    throw new UnsupportedOperationException("Not implemented: updateTargetingPresetCallable()");
  }

  public UnaryCallable<BatchUpdateTargetingPresetsRequest, BatchUpdateTargetingPresetsResponse>
      batchUpdateTargetingPresetsCallable() {
    throw new UnsupportedOperationException(
        "Not implemented: batchUpdateTargetingPresetsCallable()");
  }

  public UnaryCallable<
          BatchDeactivateTargetingPresetsRequest, BatchDeactivateTargetingPresetsResponse>
      batchDeactivateTargetingPresetsCallable() {
    throw new UnsupportedOperationException(
        "Not implemented: batchDeactivateTargetingPresetsCallable()");
  }

  @Override
  public abstract void close();
}
