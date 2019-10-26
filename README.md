The Bed of Procrustes Telegram Bot
==================================

https://teleg.run/the_bed_of_procrustes_bot

## Build

```sh
echo 'BOT_TOKEN=foo` > gradle.properties
./gradlew shadowJar
```

## Deploy

Just upload `build/libs/procrustes-1.0.jar`

### Heroku

You'll need to force add gitignored secrets file

```sh
git add -f gradle.properties
``` 
