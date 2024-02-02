/*
 * Copyright 2023 Google LLC
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

package com.google.apps.meet.v2.stub;

import com.google.api.gax.core.BackgroundResource;
import com.google.api.gax.rpc.UnaryCallable;
import com.google.apps.meet.v2.CreateSpaceRequest;
import com.google.apps.meet.v2.EndActiveConferenceRequest;
import com.google.apps.meet.v2.GetSpaceRequest;
import com.google.apps.meet.v2.Space;
import com.google.apps.meet.v2.UpdateSpaceRequest;
import com.google.protobuf.Empty;
import javax.annotation.Generated;

// AUTO-GENERATED DOCUMENTATION AND CLASS.
/**
 * Base stub class for the SpacesService service API.
 *
 * <p>This class is for advanced usage and reflects the underlying API directly.
 */
@Generated("by gapic-generator-java")
public abstract class SpacesServiceStub implements BackgroundResource {

  public UnaryCallable<CreateSpaceRequest, Space> createSpaceCallable() {
    throw new UnsupportedOperationException("Not implemented: createSpaceCallable()");
  }

  public UnaryCallable<GetSpaceRequest, Space> getSpaceCallable() {
    throw new UnsupportedOperationException("Not implemented: getSpaceCallable()");
  }

  public UnaryCallable<UpdateSpaceRequest, Space> updateSpaceCallable() {
    throw new UnsupportedOperationException("Not implemented: updateSpaceCallable()");
  }

  public UnaryCallable<EndActiveConferenceRequest, Empty> endActiveConferenceCallable() {
    throw new UnsupportedOperationException("Not implemented: endActiveConferenceCallable()");
  }

  @Override
  public abstract void close();
}
