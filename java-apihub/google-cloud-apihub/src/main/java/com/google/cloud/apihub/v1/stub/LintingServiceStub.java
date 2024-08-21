/*
 * Copyright 2024 Google LLC
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

package com.google.cloud.apihub.v1.stub;

import static com.google.cloud.apihub.v1.LintingServiceClient.ListLocationsPagedResponse;

import com.google.api.gax.core.BackgroundResource;
import com.google.api.gax.rpc.UnaryCallable;
import com.google.cloud.apihub.v1.GetStyleGuideContentsRequest;
import com.google.cloud.apihub.v1.GetStyleGuideRequest;
import com.google.cloud.apihub.v1.LintSpecRequest;
import com.google.cloud.apihub.v1.StyleGuide;
import com.google.cloud.apihub.v1.StyleGuideContents;
import com.google.cloud.apihub.v1.UpdateStyleGuideRequest;
import com.google.cloud.location.GetLocationRequest;
import com.google.cloud.location.ListLocationsRequest;
import com.google.cloud.location.ListLocationsResponse;
import com.google.cloud.location.Location;
import com.google.protobuf.Empty;
import javax.annotation.Generated;

// AUTO-GENERATED DOCUMENTATION AND CLASS.
/**
 * Base stub class for the LintingService service API.
 *
 * <p>This class is for advanced usage and reflects the underlying API directly.
 */
@Generated("by gapic-generator-java")
public abstract class LintingServiceStub implements BackgroundResource {

  public UnaryCallable<GetStyleGuideRequest, StyleGuide> getStyleGuideCallable() {
    throw new UnsupportedOperationException("Not implemented: getStyleGuideCallable()");
  }

  public UnaryCallable<UpdateStyleGuideRequest, StyleGuide> updateStyleGuideCallable() {
    throw new UnsupportedOperationException("Not implemented: updateStyleGuideCallable()");
  }

  public UnaryCallable<GetStyleGuideContentsRequest, StyleGuideContents>
      getStyleGuideContentsCallable() {
    throw new UnsupportedOperationException("Not implemented: getStyleGuideContentsCallable()");
  }

  public UnaryCallable<LintSpecRequest, Empty> lintSpecCallable() {
    throw new UnsupportedOperationException("Not implemented: lintSpecCallable()");
  }

  public UnaryCallable<ListLocationsRequest, ListLocationsPagedResponse>
      listLocationsPagedCallable() {
    throw new UnsupportedOperationException("Not implemented: listLocationsPagedCallable()");
  }

  public UnaryCallable<ListLocationsRequest, ListLocationsResponse> listLocationsCallable() {
    throw new UnsupportedOperationException("Not implemented: listLocationsCallable()");
  }

  public UnaryCallable<GetLocationRequest, Location> getLocationCallable() {
    throw new UnsupportedOperationException("Not implemented: getLocationCallable()");
  }

  @Override
  public abstract void close();
}
