// Copyright 2024 Google LLC
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

// Package main implements check_existing_release_versions, a high-concurrency tool
// that verifies Maven release artifacts are not already published to Maven Central
// before merging Release Please pull requests.
//
// Why this exists:
// The original Bash implementation (`generation/check_existing_release_versions.sh`)
// executed `curl` sequentially across hundreds of POM files in the monorepo, taking 1-3 minutes.
// Additionally, it required `xmllint` to parse POM coordinates, which caused CI timeouts
// when installing `libxml2-utils` on Ubuntu runners.
//
// Design decisions:
//  1. Concurrent Worker Pool: Scans ~100+ POMs in parallel using 20 worker goroutines and HTTP
//     keep-alive connection pooling, completing in ~2-3 seconds.
//  2. HTTP HEAD Requests: Uses HTTP HEAD instead of GET so Maven Central returns only HTTP status
//     headers without downloading multi-megabyte POM files or payloads.
//  3. Deterministic Ordered Output: Worker results are collected by task index and printed in
//     consistent alphanumeric order matching directory traversal, ensuring reproducible CI logs.
package main

import (
	"encoding/xml"
	"fmt"
	"io"
	"net/http"
	"os"
	"path/filepath"
	"sort"
	"strings"
	"sync"
	"sync/atomic"
	"time"
)

// defaultMavenSite is the Google Cloud Storage Maven Central mirror used for fast artifact checks.
const defaultMavenSite = "https://maven-central.storage-download.googleapis.com/maven2"

// PomProject represents the minimal Maven coordinates (<groupId>, <artifactId>, <version>)
// parsed from a pom.xml file.
type PomProject struct {
	XMLName    xml.Name `xml:"project"`
	GroupID    string   `xml:"groupId"`
	ArtifactID string   `xml:"artifactId"`
	Version    string   `xml:"version"`
}

// shouldSkipPom implements the filtering rules matching the original bash check script.
// It skips sample directories, showcase modules, coverage reports, test proxies, and other
// non-releasable artifacts.
func shouldSkipPom(path string) bool {
	norm := filepath.ToSlash(path)
	if strings.Contains(norm, "samples") ||
		strings.Contains(norm, "showcase") ||
		strings.Contains(norm, "coverage-report") ||
		strings.HasSuffix(norm, "sdk-platform-java/pom.xml") ||
		strings.Contains(norm, "java-vertexai") ||
		strings.Contains(norm, "storage-shared-benchmarking") ||
		strings.Contains(norm, "java-bigtable/test-proxy") {
		return true
	}
	// Exclude the aggregator java-shared-config/pom.xml but NOT child modules (e.g. java-shared-config/java-shared-config/pom.xml)
	if norm == "java-shared-config/pom.xml" || norm == "./java-shared-config/pom.xml" {
		return true
	}
	return false
}

// parsePomCoordinates reads a pom.xml file and extracts top-level GroupID, ArtifactID, and Version.
func parsePomCoordinates(path string) (*PomProject, error) {
	data, err := os.ReadFile(path)
	if err != nil {
		return nil, fmt.Errorf("reading %s: %w", path, err)
	}
	var proj PomProject
	if err := xml.Unmarshal(data, &proj); err != nil {
		return nil, fmt.Errorf("unmarshaling XML from %s: %w", path, err)
	}
	proj.GroupID = strings.TrimSpace(proj.GroupID)
	proj.ArtifactID = strings.TrimSpace(proj.ArtifactID)
	proj.Version = strings.TrimSpace(proj.Version)
	return &proj, nil
}

// PomCheckTask represents a single POM file check to be processed by a worker goroutine.
type PomCheckTask struct {
	Index   int
	PomFile string
	Project *PomProject
}

// PomCheckResult captures the output string and error status of a completed POM check.
type PomCheckResult struct {
	Index   int
	Output  string
	IsError bool
}

// findPomFiles walks the monorepo up to depth 3 to find releasable pom.xml files.
func findPomFiles(rootDir string) ([]string, error) {
	var pomFiles []string
	err := filepath.Walk(rootDir, func(path string, info os.FileInfo, err error) error {
		if err != nil {
			return err
		}
		rel, err := filepath.Rel(rootDir, path)
		if err != nil {
			return err
		}
		if info.IsDir() {
			if rel != "." {
				depth := len(strings.Split(filepath.ToSlash(rel), "/"))
				if depth > 3 {
					return filepath.SkipDir
				}
			}
			return nil
		}
		if info.Name() == "pom.xml" {
			relPath := "./" + filepath.ToSlash(rel)
			depth := len(strings.Split(filepath.ToSlash(rel), "/"))
			if depth <= 3 && !shouldSkipPom(relPath) {
				pomFiles = append(pomFiles, relPath)
			}
		}
		return nil
	})
	if err != nil {
		return nil, err
	}
	sort.Strings(pomFiles)
	return pomFiles, nil
}

// runChecks validates a list of POM files concurrently against Maven Central using an HTTP client pool.
// Returns (hasError, fullOutputString).
func runChecks(pomFiles []string, mavenSite string, client *http.Client) (bool, string) {
	var tasks []PomCheckTask
	for i, pomFile := range pomFiles {
		proj, err := parsePomCoordinates(pomFile)
		if err != nil {
			return true, fmt.Sprintf("Couldn't parse pom file %s: %v\n", pomFile, err)
		}
		if proj.ArtifactID == "" {
			return true, fmt.Sprintf("Couldn't parse artifact_id in the pom file: %s\n", pomFile)
		}
		tasks = append(tasks, PomCheckTask{
			Index:   i,
			PomFile: pomFile,
			Project: proj,
		})
	}

	numWorkers := 20
	if len(tasks) < numWorkers {
		numWorkers = len(tasks)
	}
	if numWorkers == 0 {
		return false, ""
	}

	taskCh := make(chan PomCheckTask, len(tasks))
	resultCh := make(chan PomCheckResult, len(tasks))

	var wg sync.WaitGroup
	var hasError atomic.Bool

	for w := 0; w < numWorkers; w++ {
		wg.Add(1)
		go func() {
			defer wg.Done()
			for task := range taskCh {
				proj := task.Project
				// If groupId or version is empty, the POM inherits coordinates from its parent.
				// In Maven, such child POMs are released as part of the parent package.
				if proj.GroupID == "" || proj.Version == "" {
					out := fmt.Sprintf("Checking %s:%s:%s:Skipping file without explicit coordinates (likely inherits): %s\n",
						proj.GroupID, proj.ArtifactID, proj.Version, task.PomFile)
					resultCh <- PomCheckResult{Index: task.Index, Output: out, IsError: false}
					continue
				}

				var sb strings.Builder
				sb.WriteString(fmt.Sprintf("Checking %s:%s:%s:", proj.GroupID, proj.ArtifactID, proj.Version))
				isErr := false

				// Check for unexpected SNAPSHOT versions on release branches
				if strings.Contains(proj.Version, "SNAPSHOT") && proj.ArtifactID != "google-cloud-java" {
					sb.WriteString(" Release Please pull request contains SNAPSHOT version. Please investigate.\n")
					isErr = true
				}

				// Build Maven Central repository URL for the POM artifact:
				// https://repo/group/path/artifactId/version/artifactId-version.pom
				groupIDDir := strings.ReplaceAll(proj.GroupID, ".", "/")
				url := fmt.Sprintf("%s/%s/%s/%s/%s-%s.pom", mavenSite, groupIDDir, proj.ArtifactID, proj.Version, proj.ArtifactID, proj.Version)

				req, err := http.NewRequest(http.MethodHead, url, nil)
				if err != nil {
					sb.WriteString(fmt.Sprintf(" Error building request for %s: %v\n", url, err))
					resultCh <- PomCheckResult{Index: task.Index, Output: sb.String(), IsError: true}
					continue
				}

				resp, err := client.Do(req)
				if err != nil {
					sb.WriteString(fmt.Sprintf(" Error checking %s: %v\n", url, err))
					resultCh <- PomCheckResult{Index: task.Index, Output: sb.String(), IsError: true}
					continue
				}
				io.Copy(io.Discard, resp.Body)
				resp.Body.Close()

				// If HTTP 200 is returned, the artifact is already published on Maven Central.
				// For Release Please PRs, this is an error because releasing will fail with duplicate artifact errors.
				if resp.StatusCode == http.StatusOK {
					sb.WriteString(fmt.Sprintf(" The version already exists at %s. Please investigate.\n", url))
					isErr = true
				} else {
					sb.WriteString(fmt.Sprintf(" The version does not exists (status_code %d for %s). Good.\n", resp.StatusCode, url))
				}

				resultCh <- PomCheckResult{Index: task.Index, Output: sb.String(), IsError: isErr}
			}
		}()
	}

	for _, t := range tasks {
		taskCh <- t
	}
	close(taskCh)

	go func() {
		wg.Wait()
		close(resultCh)
	}()

	// Collect results and restore original file order for deterministic logging
	results := make([]PomCheckResult, len(tasks))
	for res := range resultCh {
		results[res.Index] = res
		if res.IsError {
			hasError.Store(true)
		}
	}

	var allOutput strings.Builder
	for _, res := range results {
		allOutput.WriteString(res.Output)
	}

	return hasError.Load(), allOutput.String()
}

func main() {
	mavenSite := os.Getenv("MAVEN_SITE")
	if mavenSite == "" {
		mavenSite = defaultMavenSite
	}

	client := &http.Client{
		Transport: &http.Transport{
			MaxIdleConns:        100,
			MaxIdleConnsPerHost: 100,
			IdleConnTimeout:     90 * time.Second,
		},
		Timeout: 10 * time.Second,
	}

	pomFiles, err := findPomFiles(".")
	if err != nil {
		fmt.Fprintf(os.Stderr, "Error finding pom files: %v\n", err)
		os.Exit(1)
	}

	hasError, output := runChecks(pomFiles, mavenSite, client)
	fmt.Print(output)

	if hasError {
		os.Exit(1)
	}
}
