package com.voxium;
import net.fabricmc.api.ClientModInitializer;
public class VoxiumClient implements ClientModInitializer {
    @Override
    public void onInitializeClient() {
        System.out.println("Voxium - FPS Boost Loaded!");
    }
}
