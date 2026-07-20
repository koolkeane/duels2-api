# Duels2 API

Public API for the [Duels2](https://builtbybit.com/) plugin — events and a read-only
facade so addons and third-party plugins can hook into duels.

> This artifact ships **only interfaces, events and enums**. At runtime the classes are
> provided by the Duels2 plugin, so depend on it with `provided` scope.

## Add the dependency

**Maven**
```xml
<repositories>
  <repository>
    <id>jitpack.io</id>
    <url>https://jitpack.io</url>
  </repository>
</repositories>

<dependencies>
  <dependency>
    <groupId>com.github.skydrekdev</groupId>
    <artifactId>duels2-api</artifactId>
    <version>1.0.2</version>
    <scope>provided</scope>
  </dependency>
</dependencies>
```

**Gradle**
```groovy
repositories { maven { url 'https://jitpack.io' } }
dependencies { compileOnly 'com.github.skydrekdev:duels2-api:1.0.2' }
```

## Get the API

```java
Duels2Api api = Bukkit.getServicesManager().load(Duels2Api.class);
```

`Duels2Api` exposes: `getArena`, `getArenas`, `isInDuel`, `getArenaOf`, `getPlugin`,
`registerListener`.

## Events

Listen to these like any Bukkit event:

| Event | Fired when | Key data |
| --- | --- | --- |
| `DuelStartEvent` | A duel begins (players teleported, kit given) | `arena`, `challenger`, `receiver`, `kitType` |
| `DuelEndEvent` | The outcome is decided | `arena`, `winner?`, `loser?`, `reason` |
| `ArenaFreedEvent` | Arena is empty and available again (post grace) | `arena` |

Example:
```java
@EventHandler
public void onArenaFreed(ArenaFreedEvent event) {
    ArenaView arena = event.getArena();
    // e.g. regenerate the arena region (arena.getWorld(), getCorner1(), getCorner2())
}
```

`DuelEndReason`: `WIN`, `DRAW`, `FORCED`, `DISCONNECT`.

## Versioning

`Duels2Api.API_VERSION` tracks the API surface; it is bumped on breaking changes.
Keep the dependency version aligned with the Duels2 build you target.

## License

Provided for building addons that integrate with Duels2.
