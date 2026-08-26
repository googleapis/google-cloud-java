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

import static com.google.ads.admanager.v1.DaiEncodingProfileServiceClient.ListDaiEncodingProfilesPagedResponse;

import com.google.ads.admanager.v1.BatchActivateDaiEncodingProfilesRequest;
import com.google.ads.admanager.v1.BatchActivateDaiEncodingProfilesResponse;
import com.google.ads.admanager.v1.BatchArchiveDaiEncodingProfilesRequest;
import com.google.ads.admanager.v1.BatchArchiveDaiEncodingProfilesResponse;
import com.google.ads.admanager.v1.BatchCreateDaiEncodingProfilesRequest;
import com.google.ads.admanager.v1.BatchCreateDaiEncodingProfilesResponse;
import com.google.ads.admanager.v1.BatchUpdateDaiEncodingProfilesRequest;
import com.google.ads.admanager.v1.BatchUpdateDaiEncodingProfilesResponse;
import com.google.ads.admanager.v1.CreateDaiEncodingProfileRequest;
import com.google.ads.admanager.v1.DaiEncodingProfile;
import com.google.ads.admanager.v1.GetDaiEncodingProfileRequest;
import com.google.ads.admanager.v1.ListDaiEncodingProfilesRequest;
import com.google.ads.admanager.v1.ListDaiEncodingProfilesResponse;
import com.google.ads.admanager.v1.UpdateDaiEncodingProfileRequest;
import com.google.api.gax.core.BackgroundResource;
import com.google.api.gax.rpc.UnaryCallable;
import javax.annotation.Generated;
import org.jspecify.annotations.NullMarked;

// AUTO-GENERATED DOCUMENTATION AND CLASS.
/**
 * Base stub class for the DaiEncodingProfileService service API.
 *
 * <p>This class is for advanced usage and reflects the underlying API directly.
 */
@NullMarked
@Generated("by gapic-generator-java")
public abstract class DaiEncodingProfileServiceStub implements BackgroundResource {

  public UnaryCallable<GetDaiEncodingProfileRequest, DaiEncodingProfile>
      getDaiEncodingProfileCallable() {
    throw new UnsupportedOperationException("Not implemented: getDaiEncodingProfileCallable()");
  }

  public UnaryCallable<ListDaiEncodingProfilesRequest, ListDaiEncodingProfilesPagedResponse>
      listDaiEncodingProfilesPagedCallable() {
    throw new UnsupportedOperationException(
        "Not implemented: listDaiEncodingProfilesPagedCallable()");
  }

  public UnaryCallable<ListDaiEncodingProfilesRequest, ListDaiEncodingProfilesResponse>
      listDaiEncodingProfilesCallable() {
    throw new UnsupportedOperationException("Not implemented: listDaiEncodingProfilesCallable()");
  }

  public UnaryCallable<CreateDaiEncodingProfileRequest, DaiEncodingProfile>
      createDaiEncodingProfileCallable() {
    throw new UnsupportedOperationException("Not implemented: createDaiEncodingProfileCallable()");
  }

  public UnaryCallable<
          BatchCreateDaiEncodingProfilesRequest, BatchCreateDaiEncodingProfilesResponse>
      batchCreateDaiEncodingProfilesCallable() {
    throw new UnsupportedOperationException(
        "Not implemented: batchCreateDaiEncodingProfilesCallable()");
  }

  public UnaryCallable<UpdateDaiEncodingProfileRequest, DaiEncodingProfile>
      updateDaiEncodingProfileCallable() {
    throw new UnsupportedOperationException("Not implemented: updateDaiEncodingProfileCallable()");
  }

  public UnaryCallable<
          BatchUpdateDaiEncodingProfilesRequest, BatchUpdateDaiEncodingProfilesResponse>
      batchUpdateDaiEncodingProfilesCallable() {
    throw new UnsupportedOperationException(
        "Not implemented: batchUpdateDaiEncodingProfilesCallable()");
  }

  public UnaryCallable<
          BatchActivateDaiEncodingProfilesRequest, BatchActivateDaiEncodingProfilesResponse>
      batchActivateDaiEncodingProfilesCallable() {
    throw new UnsupportedOperationException(
        "Not implemented: batchActivateDaiEncodingProfilesCallable()");
  }

  public UnaryCallable<
          BatchArchiveDaiEncodingProfilesRequest, BatchArchiveDaiEncodingProfilesResponse>
      batchArchiveDaiEncodingProfilesCallable() {
    throw new UnsupportedOperationException(
        "Not implemented: batchArchiveDaiEncodingProfilesCallable()");
  }

  @Override
  public abstract void close();
}
