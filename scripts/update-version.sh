#!/usr/bin/env bash
#
# Updates GroupDocs.Redaction version in Examples/pom.xml.
#
# Usage:
#   ./scripts/update-version.sh 26.10
#   ./scripts/update-version.sh          # prints current version

set -euo pipefail

REPO_ROOT="$(cd "$(dirname "$0")/.." && pwd)"

POMS=(
  Examples/pom.xml
)

extract_pom_version() {
  grep -m1 '<version>[0-9]\+\.[0-9]\+</version>' "$1" | sed 's/.*<version>\([0-9]\+\.[0-9]\+\)<\/version>.*/\1/'
}

print_current_version() {
  echo "Current versions:"
  echo ""
  echo "  pom.xml:"
  for pom in "${POMS[@]}"; do
    ver=$(extract_pom_version "${REPO_ROOT}/${pom}" || echo "?")
    printf "    %-55s %s\n" "${pom}" "${ver}"
  done
}

update_version() {
  local VERSION="$1"

  echo "Updating all versions to ${VERSION}..."
  echo ""

  # Maven pom.xml — replace first <version>XX.YY</version> (the project version).
  # The groupdocs-redaction dependency uses ${project.version} so it follows automatically.
  for pom in "${POMS[@]}"; do
    sed -i "0,/<version>[0-9]\+\.[0-9]\+<\/version>/s/<version>[0-9]\+\.[0-9]\+<\/version>/<version>${VERSION}<\/version>/" "${REPO_ROOT}/${pom}"
    echo "  ${pom}"
  done

  echo ""
  echo "Done. Verify with: $0"
}

if [[ $# -eq 0 ]]; then
  print_current_version
elif [[ $# -eq 1 ]]; then
  if ! [[ "$1" =~ ^[0-9]+\.[0-9]+$ ]]; then
    echo "Error: version must match pattern XX.YY (e.g. 25.12)" >&2
    exit 1
  fi
  update_version "$1"
else
  echo "Usage: $0 [version]" >&2
  echo "  No arguments  — print current versions" >&2
  echo "  version        — update all versions (e.g. $0 26.1)" >&2
  exit 1
fi
