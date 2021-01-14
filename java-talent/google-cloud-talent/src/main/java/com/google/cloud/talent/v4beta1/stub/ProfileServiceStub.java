/*
 * Copyright 2020 Google LLC
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

package com.google.cloud.talent.v4beta1.stub;

import static com.google.cloud.talent.v4beta1.ProfileServiceClient.ListProfilesPagedResponse;
import static com.google.cloud.talent.v4beta1.ProfileServiceClient.SearchProfilesPagedResponse;

import com.google.api.core.BetaApi;
import com.google.api.gax.core.BackgroundResource;
import com.google.api.gax.rpc.UnaryCallable;
import com.google.cloud.talent.v4beta1.CreateProfileRequest;
import com.google.cloud.talent.v4beta1.DeleteProfileRequest;
import com.google.cloud.talent.v4beta1.GetProfileRequest;
import com.google.cloud.talent.v4beta1.ListProfilesRequest;
import com.google.cloud.talent.v4beta1.ListProfilesResponse;
import com.google.cloud.talent.v4beta1.Profile;
import com.google.cloud.talent.v4beta1.SearchProfilesRequest;
import com.google.cloud.talent.v4beta1.SearchProfilesResponse;
import com.google.cloud.talent.v4beta1.UpdateProfileRequest;
import com.google.protobuf.Empty;
import javax.annotation.Generated;

// AUTO-GENERATED DOCUMENTATION AND CLASS.
/**
 * Base stub class for the ProfileService service API.
 *
 * <p>This class is for advanced usage and reflects the underlying API directly.
 */
@BetaApi
@Generated("by gapic-generator-java")
public abstract class ProfileServiceStub implements BackgroundResource {

  public UnaryCallable<ListProfilesRequest, ListProfilesPagedResponse> listProfilesPagedCallable() {
    throw new UnsupportedOperationException("Not implemented: listProfilesPagedCallable()");
  }

  public UnaryCallable<ListProfilesRequest, ListProfilesResponse> listProfilesCallable() {
    throw new UnsupportedOperationException("Not implemented: listProfilesCallable()");
  }

  public UnaryCallable<CreateProfileRequest, Profile> createProfileCallable() {
    throw new UnsupportedOperationException("Not implemented: createProfileCallable()");
  }

  public UnaryCallable<GetProfileRequest, Profile> getProfileCallable() {
    throw new UnsupportedOperationException("Not implemented: getProfileCallable()");
  }

  public UnaryCallable<UpdateProfileRequest, Profile> updateProfileCallable() {
    throw new UnsupportedOperationException("Not implemented: updateProfileCallable()");
  }

  public UnaryCallable<DeleteProfileRequest, Empty> deleteProfileCallable() {
    throw new UnsupportedOperationException("Not implemented: deleteProfileCallable()");
  }

  public UnaryCallable<SearchProfilesRequest, SearchProfilesPagedResponse>
      searchProfilesPagedCallable() {
    throw new UnsupportedOperationException("Not implemented: searchProfilesPagedCallable()");
  }

  public UnaryCallable<SearchProfilesRequest, SearchProfilesResponse> searchProfilesCallable() {
    throw new UnsupportedOperationException("Not implemented: searchProfilesCallable()");
  }

  @Override
  public abstract void close();
}
