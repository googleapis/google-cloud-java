// Copyright 2026 Google LLC
//
// Licensed under the Apache License, Version 2.0 (the "License");
// you may not use this file except in compliance with the License.
// You may obtain a copy of the License at
//
//      http://www.apache.org/licenses/LICENSE-2.0
//
// Unless required by applicable law or agreed to in writing, software
// distributed under the License is distributed on an "AS IS" BASIS,
// WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
// See the License for the specific language governing permissions and
// limitations under the License.

package main

import (
	"flag"
	"fmt"
	"os"
	"os/exec"
	"strings"
)

func main() {
	showcaseVersion := flag.String("version", "", "The showcase version from pom.xml (e.g. 0.39.0)")
	showcaseCommit := flag.String("commit", "", "The showcase commit from librarian.yaml (e.g. 328bec...)")
	flag.Parse()

	if *showcaseVersion == "" || *showcaseCommit == "" {
		fmt.Fprintf(os.Stderr, "Error: Both -version and -commit flags must be provided\n")
		os.Exit(1)
	}

	tagName := "v" + *showcaseVersion
	remoteUrl := "https://github.com/googleapis/gapic-showcase.git"

	fmt.Printf("Showcase version: %s\n", *showcaseVersion)
	fmt.Printf("Showcase commit: %s\n", *showcaseCommit)

	// Query the remote gapic-showcase repository for the commit hash of the tag v{version}.
	gitCommand := exec.Command("git", "ls-remote", remoteUrl, "refs/tags/"+tagName)
	outputBytes, err := gitCommand.Output()
	if err != nil {
		fmt.Fprintf(os.Stderr, "Error running git ls-remote: %v\n", err)
		os.Exit(1)
	}

	var expectedCommit string
	for _, line := range strings.Split(strings.TrimSpace(string(outputBytes)), "\n") {
		fields := strings.Fields(line)
		if len(fields) < 2 {
			continue
		}
		if fields[1] == "refs/tags/"+tagName+"^{}" {
			expectedCommit = fields[0]
			break
		}
		if fields[1] == "refs/tags/"+tagName {
			expectedCommit = fields[0]
		}
	}

	if expectedCommit == "" {
		fmt.Fprintf(os.Stderr, "Error: Tag %s not found on remote %s\n", tagName, remoteUrl)
		os.Exit(1)
	}
	fmt.Printf("Expected commit for tag %s: %s\n", tagName, expectedCommit)

	if *showcaseCommit != expectedCommit {
		fmt.Fprintf(os.Stderr, "Mismatch: librarian.yaml has commit %q, but tag %q is at commit %q\n", *showcaseCommit, tagName, expectedCommit)
		os.Exit(2)
	}

	fmt.Println("Showcase version and commit are in sync!")
}
