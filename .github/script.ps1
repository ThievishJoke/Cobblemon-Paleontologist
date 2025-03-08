# Define the API endpoint and Discord webhook URL
$apiUrl = "https://api.modrinth.com/v2/project/tbBs6vYE/version"
$discordWebhookUrl = $env:WEBHOOKURL

# Path to the version ID file
$versionFilePath = ".\.github\version_id.txt"

$headers = @{
    "User-Agent" = "ThievishJoke/Cobblemon-Paleontologist (GitHub Actions)"
}

# Fetch the JSON response as raw text using Invoke-WebRequest
$responseRaw = Invoke-WebRequest -Uri $apiUrl -Method Get -Headers $headers -UseBasicParsing | Select-Object -ExpandProperty Content


# Extract the first instance of "version_id" using a regular expression
if ($responseRaw -match '"id"\s*:\s*"([^"]+)"') {
    $version_id = $matches[1].Trim()
} else {
    Write-Output "No id found in response."
    exit
}

# Parse the first "url" under "files" after parsing JSON
$response = $responseRaw | ConvertFrom-Json

# Check if the version ID has changed
if (Test-Path $versionFilePath) {
    $previous_version_id = (Get-Content -Path $versionFilePath -Raw).Trim()
} else {
    $previous_version_id = ""
}

# If the version ID has changed, update the file and send a Discord notification
if ($version_id -ne $previous_version_id) {
    # Update the version ID file
    Set-Content -Path $versionFilePath -Value $version_id

    $url = "https://modrinth.com/datapack/cobblemon-paleontology/version/$version_id"

    # Construct the Discord message payload
    $payload = @{
        content = "<@&1292982363294269566>`n`nA new version has released!`n[Download it here!]($url)"
    } | ConvertTo-Json

    # Send the payload to the Discord webhook
    Invoke-RestMethod -Uri $discordWebhookUrl -Method Post -ContentType "application/json" -Body $payload

    Write-Output "Notification sent to Discord. Version ID updated."

} else {
    Write-Output "Version ID has not changed. No notification sent."
}