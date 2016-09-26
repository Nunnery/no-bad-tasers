/**
 * This file is part of No Bad Tasers - v1.10_R1, licensed under the MIT License.
 *
 * Copyright (C) 2016 Teal Cube Games
 *
 * Permission is hereby granted, free of charge,
 * to any person obtaining a copy of this software and associated documentation files (the "Software"),
 * to deal in the Software without restriction, including without limitation the rights to use,
 * copy, modify, merge, publish, distribute, sublicense, and/or sell copies of the Software,
 * and to permit persons to whom the Software is furnished to do so, subject to the following conditions:
 *
 * The above copyright notice and this permission notice shall be included in all copies or
 * substantial portions of the Software.
 *
 * THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR IMPLIED,
 * INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,
 * FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE AUTHORS
 * OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER LIABILITY,
 * WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM, OUT OF OR IN
 * CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN THE SOFTWARE.
 */
package com.tealcubegames.minecraft.spigot.nobadtasers.v1_10_R1;

import com.tealcubegames.minecraft.spigot.nobadtasers.api.AbstractNBTCompound;
import com.tealcubegames.minecraft.spigot.nobadtasers.common.*;
import com.tealcubegames.minecraft.spigot.nobadtasers.common.NBTBase;
import net.minecraft.server.v1_10_R1.*;
import org.bukkit.craftbukkit.v1_10_R1.inventory.CraftItemStack;
import org.bukkit.inventory.ItemStack;

import java.util.Map;

public class NBTCompoundImpl extends AbstractNBTCompound {

    @Override
    public ItemStack write(ItemStack stack) {
        net.minecraft.server.v1_10_R1.ItemStack stackCopy = CraftItemStack.asNMSCopy(stack);
        stackCopy.setTag(constructCompound(value));
        return CraftItemStack.asBukkitCopy(stackCopy);
    }

    @Override
    public AbstractNBTCompound read(ItemStack stack) {
        NBTTagCompound compound = CraftItemStack.asNMSCopy(stack).getTag();
        if (compound == null) {
            return this;
        }
        return read(compound);
    }

    private AbstractNBTCompound read(NBTTagCompound compound) {
        compound.c().forEach(key -> {
            net.minecraft.server.v1_10_R1.NBTBase value = compound.get(key);

            if (value instanceof NBTTagCompound) {
                super.value.put(key, new NBTCompoundImpl().read((NBTTagCompound) value));
            } else if (value instanceof NBTTagByte) {
                super.value.put(key, new NBTByte(((NBTTagByte) value).g()));
            } else if (value instanceof NBTTagByteArray) {
                super.value.put(key, new NBTByteArray(((NBTTagByteArray) value).c()));
            } else if (value instanceof NBTTagShort) {
                super.value.put(key, new NBTShort(((NBTTagShort) value).f()));
            } else if (value instanceof NBTTagInt) {
                super.value.put(key, new NBTInteger(((NBTTagInt) value).e()));
            } else if (value instanceof NBTTagIntArray) {
                super.value.put(key, new NBTIntegerArray(((NBTTagIntArray) value).d()));
            } else if (value instanceof NBTTagLong) {
                super.value.put(key, new NBTLong(((NBTTagLong) value).d()));
            } else if (value instanceof NBTTagFloat) {
                super.value.put(key, new NBTFloat(((NBTTagFloat) value).i()));
            } else if (value instanceof NBTTagDouble) {
                super.value.put(key, new NBTDouble(((NBTTagDouble) value).h()));
            } else if (value instanceof NBTTagString) {
                super.value.put(key, new NBTString(((NBTTagString) value).c_()));
            } else if (value instanceof NBTTagList) {
                /* TODO: Implement the List NBT */
            }
        });
        return this;
    }

    private NBTTagCompound constructCompound(Map<String, NBTBase> mapping) {
        NBTTagCompound tag = new NBTTagCompound();

        mapping.forEach((key, value) -> {
            if(value instanceof AbstractNBTCompound) {
                tag.set(key, constructCompound(((AbstractNBTCompound) value).getValue()));
            } else if(value instanceof NBTByte) {
                tag.set(key, new NBTTagByte(((NBTByte) value).getValue()));
            } else if(value instanceof NBTByteArray) {
                tag.set(key, new NBTTagByteArray(((NBTByteArray) value).getPrimitiveBytes()));
            } else if(value instanceof NBTShort) {
                tag.set(key, new NBTTagShort(((NBTShort) value).getValue()));
            } else if(value instanceof NBTInteger) {
                tag.set(key, new NBTTagInt(((NBTInteger) value).getValue()));
            } else if(value instanceof NBTIntegerArray) {
                tag.set(key, new NBTTagIntArray(((NBTIntegerArray) value).getPrimitiveIntegers()));
            } else if(value instanceof NBTLong) {
                tag.set(key, new NBTTagLong(((NBTLong) value).getValue()));
            } else if(value instanceof NBTFloat) {
                tag.set(key, new NBTTagFloat(((NBTFloat) value).getValue()));
            } else if(value instanceof NBTDouble) {
                tag.set(key, new NBTTagDouble(((NBTDouble) value).getValue()));
            } else if(value instanceof NBTString) {
                tag.set(key, new NBTTagString(((NBTString) value).getValue()));
            }

            /* TODO: Implement the List NBT */
        });

        return tag;
    }

}
