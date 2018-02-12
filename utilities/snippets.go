// Copyright 2018 Google LLC
//
// Licensed under the Apache License, Version 2.0 (the "License");
// you may not use this file except in compliance with the License.
// You may obtain a copy of the License at
//
//       http://www.apache.org/licenses/LICENSE-2.0
//
// Unless required by applicable law or agreed to in writing, software
// distributed under the License is distributed on an "AS IS" BASIS,
// WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
// See the License for the specific language governing permissions and
// limitations under the License.

package main

import (
	"bytes"
	"flag"
	"fmt"
	"io/ioutil"
	"log"
	"os"
	"path/filepath"
	"runtime/pprof"
	"strings"
)

func init() {
	log.SetFlags(0)
	log.SetPrefix("snippet: ")
}

func main() {
	cpuprof := flag.String("cpuprofile", "", "write CPU profile to this file")
	flag.Parse()

	if cp := *cpuprof; cp != "" {
		f, err := os.Create(cp)
		if err != nil {
			log.Fatal(err)
		}
		defer f.Close()

		pprof.StartCPUProfile(f)
		defer pprof.StopCPUProfile()
	}

	files := map[string]string{}
	walkFn := func(path string, info os.FileInfo, err error) error {
		if err != nil {
			return err
		}
		if !info.Mode().IsRegular() || filepath.Ext(path) != ".java" {
			return nil
		}
		b, err := ioutil.ReadFile(path)
		if err != nil {
			return err
		}
		files[path] = string(b)
		return nil
	}
	for _, dir := range flag.Args() {
		if err := filepath.Walk(dir, walkFn); err != nil {
			log.Fatal(err)
		}
	}

	snip := map[string]string{}
	for file, txt := range files {
		if err := getSnip(file, txt, snip); err != nil {
			log.Fatal(err)
		}
	}

	rd := rewriteData{
		rewrite: map[string]string{},
		used:    map[string]bool{},
	}
	for file, txt := range files {
		if err := writeSnip(file, txt, snip, rd); err != nil {
			log.Fatal(err)
		}
	}

	for file, txt := range rd.rewrite {
		if err := ioutil.WriteFile(file, []byte(txt), 0644); err != nil {
			log.Fatal(err)
		}
	}

	for key := range snip {
		if !rd.used[key] {
			log.Printf("unused snippet: %q", key)
		}
	}
}

func getSnip(file, txt string, snip map[string]string) error {
	const snipPrefix = "// SNIPPET "

	ftxt := txt
	for {
		if p := strings.Index(txt, snipPrefix); p >= 0 {
			txt = txt[p:]
		} else {
			return nil
		}

		var key string
		if p := strings.IndexByte(txt, '\n'); p >= 0 {
			key = txt[:p]
			txt = txt[p:]
		} else {
			key = txt
			txt = ""
		}

		if p := strings.Index(txt, key); p >= 0 {
			// "// SNIPPET foo" -> "<!--SNIPPET foo-->"
			key = fmt.Sprintf("<!--%s-->", strings.TrimSpace(key[3:]))

			if _, exist := snip[key]; exist {
				return fmt.Errorf("%s:%d snippet %q has already been defined", file, lineNum(ftxt, txt), key)
			}

			snip[key] = strings.Trim(txt[:p], "\n\r")
			txt = txt[p+len(snipPrefix):]
		} else {
			return fmt.Errorf("%s:%d snippet %q not closed", file, lineNum(ftxt, txt), key)
		}
	}
}

type rewriteData struct {
	rewrite map[string]string
	used    map[string]bool
}

func writeSnip(file, txt string, snip map[string]string, rd rewriteData) error {
	const snipPrefix = "<!--SNIPPET "

	ftxt := txt
	var buf bytes.Buffer
	for {
		if p := strings.Index(txt, snipPrefix); p >= 0 {
			buf.WriteString(txt[:p])
			txt = txt[p:]
		} else if buf.Len() == 0 {
			return nil
		} else {
			buf.WriteString(txt)
			rd.rewrite[file] = buf.String()
			return nil
		}

		var key string
		if p := strings.Index(txt, "-->"); p >= 0 {
			key = txt[:p+3]
			txt = txt[p+3:]
		}

		rep, ok := snip[key]
		if ok {
			rd.used[key] = true
		} else {
			return fmt.Errorf("%s:%d snippet %q undefined", file, lineNum(ftxt, txt), key)
		}

		if p := strings.Index(txt, key); p >= 0 {
			buf.WriteString(key)
			buf.WriteString("\n* <pre>{@code\n *")
			buf.WriteString(strings.Replace(rep, "\n", "\n*", -1))
			buf.WriteString("\n* }</pre>\n")
			buf.WriteString(key)
			txt = txt[p+len(key):]
		} else {
			return fmt.Errorf("%s:%d snippet %q not closed", file, lineNum(ftxt, txt), key)
		}
	}
}

// Give strings s and suf where suf is a suffix of s, lineNum reports
// the line number on which suf starts.
func lineNum(s, suf string) int {
	pre := s[:len(s)-len(suf)]
	return strings.Count(pre, "\n") + 1
}
