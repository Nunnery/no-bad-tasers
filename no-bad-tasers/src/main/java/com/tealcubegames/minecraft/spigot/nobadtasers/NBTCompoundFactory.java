package com.tealcubegames.minecraft.spigot.nobadtasers;

import com.tealcubegames.minecraft.spigot.nobadtasers.api.AbstractNBTCompound;
import org.bukkit.Bukkit;

public final class NBTCompoundFactory {

    private static final String SERVER_VERSION = Bukkit.getServer().getClass().getPackage().getName().split("\\.")[3];

    private NBTCompoundFactory() {
        // do nothing
    }

    public AbstractNBTCompound getNBTCompound() {
        switch (SERVER_VERSION) {
            case "v1_10_R1":
                return new com.tealcubegames.minecraft.spigot.nobadtasers.v1_10_R1.NBTCompoundImpl();
            default:
                throw new UnsupportedOperationException("No-Bad-Tasers does not support version " + SERVER_VERSION);
        }
    }

}
