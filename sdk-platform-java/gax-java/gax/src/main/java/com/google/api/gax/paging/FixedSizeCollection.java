/*
 * Copyright 2016 Google LLC
 *
 * Redistribution and use in source and binary forms, with or without
 * modification, are permitted provided that the following conditions are
 * met:
 *
 *     * Redistributions of source code must retain the above copyright
 * notice, this list of conditions and the following disclaimer.
 *     * Redistributions in binary form must reproduce the above
 * copyright notice, this list of conditions and the following disclaimer
 * in the documentation and/or other materials provided with the
 * distribution.
 *     * Neither the name of Google LLC nor the names of its
 * contributors may be used to endorse or promote products derived from
 * this software without specific prior written permission.
 *
 * THIS SOFTWARE IS PROVIDED BY THE COPYRIGHT HOLDERS AND CONTRIBUTORS
 * "AS IS" AND ANY EXPRESS OR IMPLIED WARRANTIES, INCLUDING, BUT NOT
 * LIMITED TO, THE IMPLIED WARRANTIES OF MERCHANTABILITY AND FITNESS FOR
 * A PARTICULAR PURPOSE ARE DISCLAIMED. IN NO EVENT SHALL THE COPYRIGHT
 * OWNER OR CONTRIBUTORS BE LIABLE FOR ANY DIRECT, INDIRECT, INCIDENTAL,
 * SPECIAL, EXEMPLARY, OR CONSEQUENTIAL DAMAGES (INCLUDING, BUT NOT
 * LIMITED TO, PROCUREMENT OF SUBSTITUTE GOODS OR SERVICES; LOSS OF USE,
 * DATA, OR PROFITS; OR BUSINESS INTERRUPTION) HOWEVER CAUSED AND ON ANY
 * THEORY OF LIABILITY, WHETHER IN CONTRACT, STRICT LIABILITY, OR TORT
 * (INCLUDING NEGLIGENCE OR OTHERWISE) ARISING IN ANY WAY OUT OF THE USE
 * OF THIS SOFTWARE, EVEN IF ADVISED OF THE POSSIBILITY OF SUCH DAMAGE.
 */
package com.google.api.gax.paging;

/**
 * A FixedSizeCollection object wraps multiple API list method responses into a single collection
 * with a fixed number of elements.
 *
 * <p>Callers can iterate over the FixedSizeCollection object to get all elements in the collection.
 * The number of elements is guaranteed to be equal to the value of the collectionSize parameter
 * passed to expandPage(), unless the API has no more elements to return. The FixedSizeCollection
 * object also provides methods to retrieve additional FixedSizeCollections using the page token.
 */
public interface FixedSizeCollection<ResourceT> {

  /**
   * Returns the number of elements in the collection. This will be equal to the collectionSize
   * parameter used at construction unless there are no elements remaining to be retrieved.
   */
  int getCollectionSize();

  /** Returns true if there are more elements that can be retrieved from the API. */
  boolean hasNextCollection();

  /**
   * Returns a page token that can be passed into the API list method to retrieve additional
   * elements.
   */
  String getNextPageToken();

  /** Retrieves the next FixedSizeCollection using one or more API calls. */
  FixedSizeCollection<ResourceT> getNextCollection();

  /** Returns an iterable over the elements in this FixedSizeCollection. */
  Iterable<ResourceT> getValues();
}
