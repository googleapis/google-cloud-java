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

package com.google.cloud.essentialcontacts.v1.stub;

import static com.google.cloud.essentialcontacts.v1.EssentialContactsServiceClient.ComputeContactsPagedResponse;
import static com.google.cloud.essentialcontacts.v1.EssentialContactsServiceClient.ListContactsPagedResponse;

import com.google.api.gax.core.BackgroundResource;
import com.google.api.gax.rpc.UnaryCallable;
import com.google.cloud.essentialcontacts.v1.ComputeContactsRequest;
import com.google.cloud.essentialcontacts.v1.ComputeContactsResponse;
import com.google.cloud.essentialcontacts.v1.Contact;
import com.google.cloud.essentialcontacts.v1.CreateContactRequest;
import com.google.cloud.essentialcontacts.v1.DeleteContactRequest;
import com.google.cloud.essentialcontacts.v1.GetContactRequest;
import com.google.cloud.essentialcontacts.v1.ListContactsRequest;
import com.google.cloud.essentialcontacts.v1.ListContactsResponse;
import com.google.cloud.essentialcontacts.v1.SendTestMessageRequest;
import com.google.cloud.essentialcontacts.v1.UpdateContactRequest;
import com.google.protobuf.Empty;
import javax.annotation.Generated;

// AUTO-GENERATED DOCUMENTATION AND CLASS.
/**
 * Base stub class for the EssentialContactsService service API.
 *
 * <p>This class is for advanced usage and reflects the underlying API directly.
 */
@Generated("by gapic-generator-java")
public abstract class EssentialContactsServiceStub implements BackgroundResource {

  public UnaryCallable<CreateContactRequest, Contact> createContactCallable() {
    throw new UnsupportedOperationException("Not implemented: createContactCallable()");
  }

  public UnaryCallable<UpdateContactRequest, Contact> updateContactCallable() {
    throw new UnsupportedOperationException("Not implemented: updateContactCallable()");
  }

  public UnaryCallable<ListContactsRequest, ListContactsPagedResponse> listContactsPagedCallable() {
    throw new UnsupportedOperationException("Not implemented: listContactsPagedCallable()");
  }

  public UnaryCallable<ListContactsRequest, ListContactsResponse> listContactsCallable() {
    throw new UnsupportedOperationException("Not implemented: listContactsCallable()");
  }

  public UnaryCallable<GetContactRequest, Contact> getContactCallable() {
    throw new UnsupportedOperationException("Not implemented: getContactCallable()");
  }

  public UnaryCallable<DeleteContactRequest, Empty> deleteContactCallable() {
    throw new UnsupportedOperationException("Not implemented: deleteContactCallable()");
  }

  public UnaryCallable<ComputeContactsRequest, ComputeContactsPagedResponse>
      computeContactsPagedCallable() {
    throw new UnsupportedOperationException("Not implemented: computeContactsPagedCallable()");
  }

  public UnaryCallable<ComputeContactsRequest, ComputeContactsResponse> computeContactsCallable() {
    throw new UnsupportedOperationException("Not implemented: computeContactsCallable()");
  }

  public UnaryCallable<SendTestMessageRequest, Empty> sendTestMessageCallable() {
    throw new UnsupportedOperationException("Not implemented: sendTestMessageCallable()");
  }

  @Override
  public abstract void close();
}
