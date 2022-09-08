/*
 * Copyright 2022 Google LLC
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

package com.google.devtools.cloudprofiler.v2.stub;

import com.google.api.gax.core.BackgroundResource;
import com.google.api.gax.rpc.UnaryCallable;
import com.google.devtools.cloudprofiler.v2.CreateOfflineProfileRequest;
import com.google.devtools.cloudprofiler.v2.CreateProfileRequest;
import com.google.devtools.cloudprofiler.v2.Profile;
import com.google.devtools.cloudprofiler.v2.UpdateProfileRequest;
import javax.annotation.Generated;

// AUTO-GENERATED DOCUMENTATION AND CLASS.
/**
 * Base stub class for the ProfilerService service API.
 *
 * <p>This class is for advanced usage and reflects the underlying API directly.
 */
@Generated("by gapic-generator-java")
public abstract class ProfilerServiceStub implements BackgroundResource {

  public UnaryCallable<CreateProfileRequest, Profile> createProfileCallable() {
    throw new UnsupportedOperationException("Not implemented: createProfileCallable()");
  }

  public UnaryCallable<CreateOfflineProfileRequest, Profile> createOfflineProfileCallable() {
    throw new UnsupportedOperationException("Not implemented: createOfflineProfileCallable()");
  }

  public UnaryCallable<UpdateProfileRequest, Profile> updateProfileCallable() {
    throw new UnsupportedOperationException("Not implemented: updateProfileCallable()");
  }

  @Override
  public abstract void close();
}
