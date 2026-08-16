/*
 * Copyright 2026 Google LLC.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

/**
 * Toggles the visibility of source class list below the button.
 * @param button clicked button element
 */
function toggleSourceClassListVisibility(button) {
    const classList = button.parentElement.nextElementSibling;
    const currentVisibility = classList.style.display !== "none";
    const nextVisibility = !currentVisibility;
    classList.style.display = nextVisibility ? "" : "none";
    button.innerText = nextVisibility ? "▼" : "▶";
}

function compareVersions(v1, v2) {
    // create arrays of version numbers
    var mavenVersion1;
    if (v1.indexOf("-") >= 0) {
        mavenVersion1 = v1.substring(0, v1.indexOf("-")).split(".");
    } else {
        mavenVersion1 = v1.split(".");
    }
    var mavenVersion2;
    if (v2.indexOf("-") >= 0) {
        mavenVersion2 = v2.substring(0, v2.indexOf("-")).split(".");
    } else {
        mavenVersion2 = v2.split(".");
    }
    for (let i = 0; i < mavenVersion1.length && i < mavenVersion2.length; i++) {
        if (isNaN(mavenVersion1[i]) || isNaN(mavenVersion2[i])) {
            return v1.toString().localeCompare(v2);
        }
        if (Number(mavenVersion1[i]) != Number(mavenVersion2[i])) {
            return Number(mavenVersion1[i]) - Number(mavenVersion2[i]);
        }
    }
    return v1.toString().localeCompare(v2);
}

const getCellValue = (tr, idx) => tr.children[idx].innerText || tr.children[idx].textContent;

// comparator for sorting
const comparer = (columnHeader, idx, asc) => (a, b) => {
    return (function (v1, v2) {
        return compareVersions(v1, v2);
    })
    (getCellValue(asc ? a : b, idx), getCellValue(asc ? b : a, idx));
};

document.querySelectorAll('th').forEach(th => th.addEventListener('click', (() => {
    const table = th.closest('table');
    document.querySelectorAll('th').forEach(otherTh => {
        if (otherTh != th) {
            // Remove all special characters
            otherTh.innerText = otherTh.innerText.replace(/[^\x00-\x7F]/g, "");
        } else {
            if (otherTh.innerText.indexOf('\u25BC') > -1) {
                otherTh.innerText = otherTh.innerText.split(" ")[0] + " \u25B2";
            } else {
                otherTh.innerText = otherTh.innerText.split(" ")[0] + " \u25BC";
            }
        }
    });
    Array.from(table.querySelectorAll('tr:nth-child(n+2)'))
        .sort(comparer(th.innerText, Array.from(th.parentNode.children).indexOf(th),
            this.asc = !this.asc))
        .forEach(tr => table.appendChild(tr));
})));

function colsContainAllInput(cols, input) {
    for (let i = 0; i < input.length; i++) {
        if (input[i].length == 0) {
            continue;
        }
        // by this point, our input is already split for us
        // search for column keys (shortened or full name)
        let found = false;
        let checkSpecificColumn = input[i].indexOf(":") > -1;
        let col = checkSpecificColumn ? input[i].split(":")[0] : "";
        let currInput = checkSpecificColumn ? input[i].split(":")[1] : input[i];
        /* Enough specific conditions that it's simpler to hard-code */
        if (checkSpecificColumn) {
            var name;
            if (col.indexOf("google-cloud-bom") > -1 || col.indexOf("gcb") > -1) {
                name = cols[0].textContent || cols[0].innerText;
            } else if (col.indexOf("artifact") > -1 || col === "a") {
                name = cols[1].textContent || cols[1].innerText;
            } else if (col.indexOf("artifact-version") > -1 || col.indexOf("av") > -1) {
                name = cols[2].textContent || cols[2].innerText;
            } else if (col.indexOf("google-cloud-shared-dependencies") > -1 || col.indexOf("gcsd")
                > -1) {
                name = cols[cols.length - 1].textContent || cols[cols.length - 1].innerText;
            }
            // Make sure name has a non-empty value that matches a column name
            found = name && name !== "" && name.toLowerCase().indexOf(currInput) > -1;
        } else {
            check_all_cols:
                for (let j = 0; j < cols.length; j++) {
                    let name = cols[j].textContent || cols[j].innerText;
                    if (name.toLowerCase().indexOf(currInput) > -1) {
                        found = true;
                        break check_all_cols;
                    }
                }
        }
        if (!found) {
            return false;
        }
    }
    return true;
}

function filterFunction() {
    const input = document.getElementById("filterBar").value.toLowerCase();
    const table = document.getElementById("libraryVersions");
    const rows = table.getElementsByTagName("tr")
    // if our input is empty, we should not filter anything
    if (input === "") {
        for (let i = 1; i < rows.length; i++) {
            rows[i].style.display = "";
        }
        return;
    }
    // split the searchbar input by commas if present, or spaces otherwise
    const splitInput = input.indexOf(",") > -1 ? input.replace(/ /g, '').split(",") : input.split(
        " ");
    for (let i = 1; i < rows.length; i++) {
        const cols = rows[i].getElementsByTagName("td");
        let isDisplay = colsContainAllInput(cols, splitInput);
        // remove a column's display if it does not match search bar input
        rows[i].style.display = isDisplay ? "" : "none";
    }
}

/**
 * ------------------------------------------
 *
 * +-------------------------------------+
 * | Unit Tests for sorting code based   |
 * | on Maven VersionComparator.         |
 * |                                     |
 * | Dashboard will still be created if  |
 * | the unit tests do not pass, but the |
 * | console will log errors.            |
 * +------------------------------------ |
 *
 * ------------------------------------------
 */
function testCompareVersions() {
    console.assert(compareVersions("1.2.3", "1.3.3") < 0);
    console.assert(compareVersions("1.59.0", "1.100.1") < 0);
    console.assert(compareVersions("1.0.0-alpha", "1.0.0-beta") < 0);

    console.assert(compareVersions("1.0.0", "1.0.0") === 0);

    console.assert(compareVersions("1.22.3", "1.21.3") > 0);
    console.assert(compareVersions("1.22.3", "1.2.3") > 0);
    console.assert(compareVersions("1.20.3", "1.19.4") > 0);
    console.assert(compareVersions("22.99.33", "21.99.33") > 0);
    console.assert(compareVersions("200.99.33", "22.99.33") > 0);
}

testCompareVersions();