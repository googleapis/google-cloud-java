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

package com.google.ads.admanager.v1.stub;

import static com.google.ads.admanager.v1.ContactServiceClient.ListContactsPagedResponse;

import com.google.ads.admanager.v1.Contact;
import com.google.ads.admanager.v1.GetContactRequest;
import com.google.ads.admanager.v1.ListContactsRequest;
import com.google.ads.admanager.v1.ListContactsResponse;
import com.google.api.gax.core.BackgroundResource;
import com.google.api.gax.rpc.UnaryCallable;
import javax.annotation.Generated;

// AUTO-GENERATED DOCUMENTATION AND CLASS.
/**
 * Base stub class for the ContactService service API.
 *
 * <p>This class is for advanced usage and reflects the underlying API directly.
 */
@Generated("by gapic-generator-java")
public abstract class ContactServiceStub implements BackgroundResource {

  public UnaryCallable<GetContactRequest, Contact> getContactCallable() {
    throw new UnsupportedOperationException("Not implemented: getContactCallable()");
  }

  public UnaryCallable<ListContactsRequest, ListContactsPagedResponse> listContactsPagedCallable() {
    throw new UnsupportedOperationException("Not implemented: listContactsPagedCallable()");
  }

  public UnaryCallable<ListContactsRequest, ListContactsResponse> listContactsCallable() {
    throw new UnsupportedOperationException("Not implemented: listContactsCallable()");
  }

  @Override
  public abstract void close();
}
