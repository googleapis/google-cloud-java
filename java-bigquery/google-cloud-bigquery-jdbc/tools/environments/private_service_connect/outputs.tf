output "psc_endpoint" {
  value       = "https://bigquery-${var.env_name}.p.googleapis.com"
  description = "The expected Private Service Connect endpoint for BigQuery."
}

output "psc_ip_address" {
  value       = google_compute_global_address.psc_ip.address
  description = "The internal IP address reserved for Private Service Connect."
}

output "vm_connect" {
  value = "ssh kirl_google_com@nic0.${google_compute_instance.vm.name}.${google_compute_instance.vm.zone}.c.${var.project_id}.internal.gcpnode.com"
}