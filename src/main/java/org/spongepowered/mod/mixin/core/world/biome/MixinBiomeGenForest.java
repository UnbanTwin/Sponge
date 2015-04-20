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
package org.spongepowered.mod.mixin.core.world.biome;

import net.minecraft.block.BlockDoublePlant;
import net.minecraft.world.biome.BiomeGenForest;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.mod.world.gen.populators.DoublePlantPopulator;
import org.spongepowered.mod.world.gen.populators.RoofedForestPopulator;

@Mixin(BiomeGenForest.class)
public abstract class MixinBiomeGenForest extends MixinBiomeGenBase {

    @Shadow private int field_150632_aF;

    @Override
    protected void buildPopulators() {
        if (this.field_150632_aF == 3) {
            this.populators.add(new RoofedForestPopulator());
        }
        int base = -3;
        if (this.field_150632_aF == 1) {
            base = -1;
        }
        this.populators.add(new DoublePlantPopulator(base, 5, 5, BlockDoublePlant.EnumPlantType.SYRINGA, BlockDoublePlant.EnumPlantType.ROSE,
                BlockDoublePlant.EnumPlantType.PAEONIA));
        super.buildPopulators();
    }
}