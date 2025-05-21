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

package com.google.cloud.support.v2beta.stub;

import static com.google.cloud.support.v2beta.CommentServiceClient.ListCommentsPagedResponse;

import com.google.api.core.BetaApi;
import com.google.api.gax.core.BackgroundResource;
import com.google.api.gax.rpc.UnaryCallable;
import com.google.cloud.support.v2beta.Comment;
import com.google.cloud.support.v2beta.CreateCommentRequest;
import com.google.cloud.support.v2beta.ListCommentsRequest;
import com.google.cloud.support.v2beta.ListCommentsResponse;
import javax.annotation.Generated;

// AUTO-GENERATED DOCUMENTATION AND CLASS.
/**
 * Base stub class for the CommentService service API.
 *
 * <p>This class is for advanced usage and reflects the underlying API directly.
 */
@BetaApi
@Generated("by gapic-generator-java")
public abstract class CommentServiceStub implements BackgroundResource {

  public UnaryCallable<ListCommentsRequest, ListCommentsPagedResponse> listCommentsPagedCallable() {
    throw new UnsupportedOperationException("Not implemented: listCommentsPagedCallable()");
  }

  public UnaryCallable<ListCommentsRequest, ListCommentsResponse> listCommentsCallable() {
    throw new UnsupportedOperationException("Not implemented: listCommentsCallable()");
  }

  public UnaryCallable<CreateCommentRequest, Comment> createCommentCallable() {
    throw new UnsupportedOperationException("Not implemented: createCommentCallable()");
  }

  @Override
  public abstract void close();
}
