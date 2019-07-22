/*
 * Copyright 2019 Google LLC
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

package com.example.speech;

import org.apache.commons.cli.CommandLine;
import org.apache.commons.cli.CommandLineParser;
import org.apache.commons.cli.DefaultParser;
import org.apache.commons.cli.Option;
import org.apache.commons.cli.Options;
import org.apache.commons.cli.ParseException;

public class InfiniteStreamRecognizeOptions {
  String langCode = "en-US";  //by default english US

  /** Construct an InfiniteStreamRecognizeOptions class from command line flags. */
  public static InfiniteStreamRecognizeOptions fromFlags(String[] args) {
    Options options = new Options();
    options.addOption(
            Option.builder()
                    .type(String.class)
                    .longOpt("lang_code")
                    .hasArg()
                    .desc("Language code")
                    .build());

    CommandLineParser parser = new DefaultParser();
    CommandLine commandLine;
    try {
      commandLine = parser.parse(options, args);
      InfiniteStreamRecognizeOptions res = new InfiniteStreamRecognizeOptions();

      if (commandLine.hasOption("lang_code")) {
        res.langCode = commandLine.getOptionValue("lang_code");
      }
      return res;
    } catch (ParseException e) {
      System.err.println(e.getMessage());
      return null;
    }
  }

}
