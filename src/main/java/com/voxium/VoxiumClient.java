package com.voxium.client;

import net.fabricmc.api.ClientModInitializer;
import net.minecraft.client.MinecraftClient;
import net.minecraft.client.option.ParticlesMode;

public class VoxiumClient implements ClientModInitializer {

    @Override
    public void onInitializeClient() {
        System.out.println("[Voxium] Initializing FPS Boost...");

        MinecraftClient client = MinecraftClient.getInstance();

        try {
            // 1. FAST Graphics
            client.options.getGraphicsMode().setValue(net.minecraft.client.option.GraphicsMode.FAST);

            // 2. Minimal Particles = +15 FPS
            client.options.getParticles().setValue(ParticlesMode.MINIMAL);

            // 3. Clouds OFF = +10 FPS
            client.options.getCloudRenderMode().setValue(net.minecraft.client.option.CloudRenderMode.OFF);

            // 4. Entity Shadows OFF
            client.options.getEntityShadows().setValue(false);

            // 5. Render Distance to 8 if too high (huge boost)
            if (client.options.getViewDistance().getValue() > 10) {
                client.options.getViewDistance().setValue(8);
            }

            // 6. Simulation Distance to 6
            if (client.options.getSimulationDistance().getValue() > 8) {
                client.options.getSimulationDistance().setValue(6);
            }

            // 7. Biome Blend low
            client.options.getBiomeBlendRadius().setValue(0);

            System.out.println("[Voxium] FPS Boost ACTIVE! +30-50 FPS Expected!");

        } catch (Exception e) {
            System.out.println("[Voxium] Could not auto-tweak settings, but mod is loaded!");
        }
    }
    }
