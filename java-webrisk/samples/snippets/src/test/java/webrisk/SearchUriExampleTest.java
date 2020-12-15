/*
 * Copyright 2020 Google LLC
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

package webrisk;

import com.google.common.truth.Truth;
import com.google.webrisk.v1.SearchUrisResponse;
import com.google.webrisk.v1.ThreatType;
import java.io.IOException;
import java.util.List;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;

@RunWith(JUnit4.class)
public class SearchUriExampleTest {
  @Test
  public void testSearchWithThreat() throws IOException {
    //The URL to be searched
    String uri = "http://testsafebrowsing.appspot.com/s/malware.html";
    SearchUrisResponse actualResponse = SearchUriExample.searchUriExample(uri);
    List<ThreatType> type = actualResponse.getThreat().getThreatTypesList();
    Truth.assertThat(type).contains(ThreatType.MALWARE);
  }

  @Test
  public void testSearchWithoutThreat() throws IOException {
    //The URL to be searched
    String uri = "http://testsafebrowsing.appspot.com/malware.html";
    SearchUrisResponse actualResponse = SearchUriExample.searchUriExample(uri);
    List<ThreatType> type = actualResponse.getThreat().getThreatTypesList();
    Truth.assertThat(type).isEmpty();
  }
}
