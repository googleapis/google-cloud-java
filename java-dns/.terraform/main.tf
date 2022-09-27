terraform {
  required_providers {
    google = {
      source = "hashicorp/google"
    }
  }
}

resource "google_project_service" "dns_api" {
  service            = "dns.googleapis.com"
  disable_on_destroy = false
}
