/*
 * This file is part of Sponge, licensed under the MIT License (MIT).
 *
 * Copyright (c) SpongePowered.org <http://www.spongepowered.org>
 * Copyright (c) contributors
 *
 * Permission is hereby granted, free of charge, to any person obtaining a copy
 * of this software and associated documentation files (the "Software"), to deal
 * in the Software without restriction, including without limitation the rights
 * to use, copy, modify, merge, publish, distribute, sublicense, and/or sell
 * copies of the Software, and to permit persons to whom the Software is
 * furnished to do so, subject to the following conditions:
 *
 * The above copyright notice and this permission notice shall be included in
 * all copies or substantial portions of the Software.
 *
 * THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
 * IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,
 * FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE
 * AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
 * LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
 * OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN
 * THE SOFTWARE.
 */
package org.spongepowered.mod.world.gen.populators;

import net.minecraft.util.BlockPos;
import net.minecraft.world.World;
import net.minecraft.world.gen.feature.WorldGenDesertWells;
import net.minecraft.world.gen.feature.WorldGenerator;
import org.spongepowered.api.world.Chunk;
import org.spongepowered.api.world.gen.populators.DesertWell;

import java.util.Random;

public class DesertWellPopulator extends SpongePopulator implements DesertWell {

    private WorldGenerator gen;
    private int chance;

    public DesertWellPopulator(int chance) {
        this.gen = new WorldGenDesertWells();
        this.chance = chance;
    }

    @Override
    public void populate(World currentWorld, Chunk chunk, Random randomGenerator, BlockPos pos) {
        if (randomGenerator.nextInt(this.chance) == 0) {
            int i = randomGenerator.nextInt(16) + 8;
            int j = randomGenerator.nextInt(16) + 8;
            BlockPos blockpos1 = currentWorld.getHeight(pos.add(i, 0, j)).up();
            this.gen.generate(currentWorld, randomGenerator, blockpos1);
        }
    }

    @Override
    public int getSpawnChance() {
        return this.chance;
    }

    @Override
    public void setSpawnChance(int chance) {
        this.chance = chance;
    }

}