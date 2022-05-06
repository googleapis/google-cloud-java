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

package com.google.appengine.v1.stub;

import static com.google.appengine.v1.AuthorizedCertificatesClient.ListAuthorizedCertificatesPagedResponse;

import com.google.api.gax.core.BackgroundResource;
import com.google.api.gax.rpc.UnaryCallable;
import com.google.appengine.v1.AuthorizedCertificate;
import com.google.appengine.v1.CreateAuthorizedCertificateRequest;
import com.google.appengine.v1.DeleteAuthorizedCertificateRequest;
import com.google.appengine.v1.GetAuthorizedCertificateRequest;
import com.google.appengine.v1.ListAuthorizedCertificatesRequest;
import com.google.appengine.v1.ListAuthorizedCertificatesResponse;
import com.google.appengine.v1.UpdateAuthorizedCertificateRequest;
import com.google.protobuf.Empty;
import javax.annotation.Generated;

// AUTO-GENERATED DOCUMENTATION AND CLASS.
/**
 * Base stub class for the AuthorizedCertificates service API.
 *
 * <p>This class is for advanced usage and reflects the underlying API directly.
 */
@Generated("by gapic-generator-java")
public abstract class AuthorizedCertificatesStub implements BackgroundResource {

  public UnaryCallable<ListAuthorizedCertificatesRequest, ListAuthorizedCertificatesPagedResponse>
      listAuthorizedCertificatesPagedCallable() {
    throw new UnsupportedOperationException(
        "Not implemented: listAuthorizedCertificatesPagedCallable()");
  }

  public UnaryCallable<ListAuthorizedCertificatesRequest, ListAuthorizedCertificatesResponse>
      listAuthorizedCertificatesCallable() {
    throw new UnsupportedOperationException(
        "Not implemented: listAuthorizedCertificatesCallable()");
  }

  public UnaryCallable<GetAuthorizedCertificateRequest, AuthorizedCertificate>
      getAuthorizedCertificateCallable() {
    throw new UnsupportedOperationException("Not implemented: getAuthorizedCertificateCallable()");
  }

  public UnaryCallable<CreateAuthorizedCertificateRequest, AuthorizedCertificate>
      createAuthorizedCertificateCallable() {
    throw new UnsupportedOperationException(
        "Not implemented: createAuthorizedCertificateCallable()");
  }

  public UnaryCallable<UpdateAuthorizedCertificateRequest, AuthorizedCertificate>
      updateAuthorizedCertificateCallable() {
    throw new UnsupportedOperationException(
        "Not implemented: updateAuthorizedCertificateCallable()");
  }

  public UnaryCallable<DeleteAuthorizedCertificateRequest, Empty>
      deleteAuthorizedCertificateCallable() {
    throw new UnsupportedOperationException(
        "Not implemented: deleteAuthorizedCertificateCallable()");
  }

  @Override
  public abstract void close();
}
