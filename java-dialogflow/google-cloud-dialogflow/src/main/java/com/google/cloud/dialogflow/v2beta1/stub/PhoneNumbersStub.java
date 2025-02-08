/*
 * Copyright 2025 Google LLC
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

package com.google.cloud.dialogflow.v2beta1.stub;

import static com.google.cloud.dialogflow.v2beta1.PhoneNumbersClient.ListLocationsPagedResponse;
import static com.google.cloud.dialogflow.v2beta1.PhoneNumbersClient.ListPhoneNumbersPagedResponse;

import com.google.api.core.BetaApi;
import com.google.api.gax.core.BackgroundResource;
import com.google.api.gax.rpc.UnaryCallable;
import com.google.cloud.dialogflow.v2beta1.DeletePhoneNumberRequest;
import com.google.cloud.dialogflow.v2beta1.ListPhoneNumbersRequest;
import com.google.cloud.dialogflow.v2beta1.ListPhoneNumbersResponse;
import com.google.cloud.dialogflow.v2beta1.PhoneNumber;
import com.google.cloud.dialogflow.v2beta1.UndeletePhoneNumberRequest;
import com.google.cloud.dialogflow.v2beta1.UpdatePhoneNumberRequest;
import com.google.cloud.location.GetLocationRequest;
import com.google.cloud.location.ListLocationsRequest;
import com.google.cloud.location.ListLocationsResponse;
import com.google.cloud.location.Location;
import javax.annotation.Generated;

// AUTO-GENERATED DOCUMENTATION AND CLASS.
/**
 * Base stub class for the PhoneNumbers service API.
 *
 * <p>This class is for advanced usage and reflects the underlying API directly.
 */
@BetaApi
@Generated("by gapic-generator-java")
public abstract class PhoneNumbersStub implements BackgroundResource {

  public UnaryCallable<ListPhoneNumbersRequest, ListPhoneNumbersPagedResponse>
      listPhoneNumbersPagedCallable() {
    throw new UnsupportedOperationException("Not implemented: listPhoneNumbersPagedCallable()");
  }

  public UnaryCallable<ListPhoneNumbersRequest, ListPhoneNumbersResponse>
      listPhoneNumbersCallable() {
    throw new UnsupportedOperationException("Not implemented: listPhoneNumbersCallable()");
  }

  public UnaryCallable<UpdatePhoneNumberRequest, PhoneNumber> updatePhoneNumberCallable() {
    throw new UnsupportedOperationException("Not implemented: updatePhoneNumberCallable()");
  }

  public UnaryCallable<DeletePhoneNumberRequest, PhoneNumber> deletePhoneNumberCallable() {
    throw new UnsupportedOperationException("Not implemented: deletePhoneNumberCallable()");
  }

  public UnaryCallable<UndeletePhoneNumberRequest, PhoneNumber> undeletePhoneNumberCallable() {
    throw new UnsupportedOperationException("Not implemented: undeletePhoneNumberCallable()");
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
