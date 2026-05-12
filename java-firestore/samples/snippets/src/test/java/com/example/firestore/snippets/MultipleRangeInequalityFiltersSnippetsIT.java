/*
 * Copyright 2024 Google Inc.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package com.example.firestore.snippets;

import static com.google.common.collect.Sets.newHashSet;
import static org.junit.Assert.assertEquals;

import com.example.firestore.BaseIntegrationTest;
import com.google.api.core.ApiFuture;
import com.google.cloud.firestore.DocumentSnapshot;
import com.google.cloud.firestore.Query;
import com.google.cloud.firestore.QuerySnapshot;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;

@RunWith(JUnit4.class)
@SuppressWarnings("checkstyle:abbreviationaswordinname")
public class MultipleRangeInequalityFiltersSnippetsIT extends BaseIntegrationTest {

  private static MultipleRangeInequalityFiltersSnippets multipleRangeInequalityFiltersSnippets;

  @BeforeClass
  public static void setUpBeforeClass() throws Exception {
    multipleRangeInequalityFiltersSnippets = new MultipleRangeInequalityFiltersSnippets(db);
    multipleRangeInequalityFiltersSnippets.prepareExamples();
  }

  @Test
  public void testRangeMultipleInequalityFilter() throws Exception {
    Query query = multipleRangeInequalityFiltersSnippets.compoundMultiInequalities();

    Set<String> expected = newHashSet("BJ", "LA");
    Set<String> actual = getResultsAsSet(query);
    assertEquals(expected, actual);
  }

  private Set<String> getResultsAsSet(Query query) throws Exception {
    List<String> docIds = getResults(query);
    return new HashSet<>(docIds);
  }

  private List<String> getResults(Query query) throws Exception {
    // asynchronously retrieve query results
    ApiFuture<QuerySnapshot> future = query.get();
    // block on response
    QuerySnapshot querySnapshot = future.get();

    List<String> docIds = new ArrayList<>();
    for (DocumentSnapshot document : querySnapshot.getDocuments()) {
      docIds.add(document.getId());
    }
    return docIds;
  }

  @AfterClass
  public static void tearDown() throws Exception {
    deleteAllDocuments(db);
    multipleRangeInequalityFiltersSnippets.close();
  }
}
