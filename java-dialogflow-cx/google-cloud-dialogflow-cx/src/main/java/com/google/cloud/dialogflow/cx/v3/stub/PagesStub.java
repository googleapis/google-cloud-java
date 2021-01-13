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

package com.google.cloud.dialogflow.cx.v3.stub;

import static com.google.cloud.dialogflow.cx.v3.PagesClient.ListPagesPagedResponse;

import com.google.api.gax.core.BackgroundResource;
import com.google.api.gax.rpc.UnaryCallable;
import com.google.cloud.dialogflow.cx.v3.CreatePageRequest;
import com.google.cloud.dialogflow.cx.v3.DeletePageRequest;
import com.google.cloud.dialogflow.cx.v3.GetPageRequest;
import com.google.cloud.dialogflow.cx.v3.ListPagesRequest;
import com.google.cloud.dialogflow.cx.v3.ListPagesResponse;
import com.google.cloud.dialogflow.cx.v3.Page;
import com.google.cloud.dialogflow.cx.v3.UpdatePageRequest;
import com.google.protobuf.Empty;
import javax.annotation.Generated;

// AUTO-GENERATED DOCUMENTATION AND CLASS.
/**
 * Base stub class for the Pages service API.
 *
 * <p>This class is for advanced usage and reflects the underlying API directly.
 */
@Generated("by gapic-generator-java")
public abstract class PagesStub implements BackgroundResource {

  public UnaryCallable<ListPagesRequest, ListPagesPagedResponse> listPagesPagedCallable() {
    throw new UnsupportedOperationException("Not implemented: listPagesPagedCallable()");
  }

  public UnaryCallable<ListPagesRequest, ListPagesResponse> listPagesCallable() {
    throw new UnsupportedOperationException("Not implemented: listPagesCallable()");
  }

  public UnaryCallable<GetPageRequest, Page> getPageCallable() {
    throw new UnsupportedOperationException("Not implemented: getPageCallable()");
  }

  public UnaryCallable<CreatePageRequest, Page> createPageCallable() {
    throw new UnsupportedOperationException("Not implemented: createPageCallable()");
  }

  public UnaryCallable<UpdatePageRequest, Page> updatePageCallable() {
    throw new UnsupportedOperationException("Not implemented: updatePageCallable()");
  }

  public UnaryCallable<DeletePageRequest, Empty> deletePageCallable() {
    throw new UnsupportedOperationException("Not implemented: deletePageCallable()");
  }

  @Override
  public abstract void close();
}
