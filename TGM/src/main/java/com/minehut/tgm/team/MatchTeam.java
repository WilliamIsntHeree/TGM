package com.minehut.tgm.team;

import com.minehut.tgm.map.SpawnPoint;
import com.minehut.tgm.user.PlayerContext;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import org.bukkit.ChatColor;
import org.bukkit.entity.Player;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by luke on 4/28/17.
 */
@AllArgsConstructor
public class MatchTeam {
    @Getter private String id;
    @Getter @Setter private String alias;
    @Getter private ChatColor color;
    @Getter private boolean spectator;
    @Getter private int max;
    @Getter private int min;
    @Getter final private List<PlayerContext> members = new ArrayList<>();

    //filled onload
    @Getter
    final private List<SpawnPoint> spawnPoints = new ArrayList<>();

    public void addPlayer(PlayerContext playerContext) {
        members.add(playerContext);
    }

    public void removePlayer(PlayerContext playerContext) {
        members.remove(playerContext);
    }

    public boolean containsPlayer(Player player) {
        for (PlayerContext playerContext : members) {
            if (playerContext.getPlayer() == player) {
                return true;
            }
        }
        return false;
    }

    public void addSpawnPoint(SpawnPoint spawnPoint) {
        this.spawnPoints.add(spawnPoint);
    }
}
