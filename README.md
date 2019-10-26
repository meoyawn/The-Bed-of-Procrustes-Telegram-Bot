The Bed of Procrustes Telegram Bot
==================================

https://teleg.run/the_bed_of_procrustes_bot

## Build

```sh
echo 'BOT_TOKEN=foo` > gradle.properties
./gradlew shadowJar
```

## Deploy

Upload and run `build/libs/procrustes-1.0-all.jar`

### Heroku

You'll need to force add gitignored secrets file

```sh
git add -f gradle.properties
``` 
