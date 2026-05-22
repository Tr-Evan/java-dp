# Script PowerShell pour lancer les tests Maven
# Ajuste la variable $mavenBin si nécessaire
$mavenBin = 'C:\Users\evant\Downloads\apache-maven-3.9.16\bin'

if (-Not (Test-Path $mavenBin)) {
    Write-Host "Le dossier Maven spécifié n'existe pas: $mavenBin" -ForegroundColor Red
    Write-Host "Modifie la variable `$$mavenBin` dans ce script avec le chemin correct." -ForegroundColor Yellow
    exit 1
}

$env:PATH = "$mavenBin;" + $env:PATH

if (-not $env:JAVA_HOME) {
    Write-Host "JAVA_HOME n'est pas défini. Définis JAVA_HOME vers le dossier de ton JDK puis relance." -ForegroundColor Red
    exit 1
}

mvn test
