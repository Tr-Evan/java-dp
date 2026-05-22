#!/usr/bin/env bash
# Script pour lancer les tests Maven (Unix/macOS)
MAVEN_BIN="/path/to/apache-maven-3.9.16/bin"

if [ ! -d "$MAVEN_BIN" ]; then
  echo "Le dossier Maven spécifié n'existe pas: $MAVEN_BIN" >&2
  echo "Edite ce script et définis MAVEN_BIN correctement." >&2
  exit 1
fi

export PATH="$MAVEN_BIN:$PATH"

if [ -z "$JAVA_HOME" ]; then
  echo "JAVA_HOME n'est pas défini. Définis JAVA_HOME et relance." >&2
  exit 1
fi

mvn test
