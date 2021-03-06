/**
 * This file is part of No Bad Tasers - API, licensed under the MIT License.
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
package com.tealcubegames.minecraft.spigot.nobadtasers.api;

import com.tealcubegames.minecraft.spigot.nobadtasers.common.*;
import org.bukkit.inventory.ItemStack;

import java.util.HashMap;
import java.util.Map;

public abstract class AbstractNBTCompound extends NBTBase<Map<String, NBTBase>> {

    protected AbstractNBTCompound() {
        super(Type.COMPOUND, new HashMap<>());
    }

    public NBTBase get(String key) {
        return value.get(key);
    }

    public boolean contains(String key) {
        return value.containsKey(key);
    }

    public void set(String key, NBTBase tag) {
        value.put(key, tag);
    }

    public NBTByte getByte(String key) {
        NBTBase tag = value.get(key);

        if((tag == null) || !(tag instanceof NBTByte)) {
            return null;
        }

        return ((NBTByte) tag);
    }

    public boolean isByte(String key) {
        return (value.get(key) instanceof NBTByte);
    }

    public void setByte(String key, byte value) {
        set(key, new NBTByte(value));
    }

    public NBTByteArray getByteArray(String key) {
        NBTBase tag = value.get(key);

        if((tag == null) || !(tag instanceof NBTByteArray)) {
            return null;
        }

        return ((NBTByteArray) tag);
    }

    public boolean isByteArray(String key) {
        return (value.get(key) instanceof NBTByteArray);
    }

    public void setByteArray(String key, byte[] value) {
        set(key, new NBTByteArray(value));
    }

    public NBTShort getShort(String key) {
        NBTBase tag = value.get(key);

        if((tag == null) || !(tag instanceof NBTShort)) {
            return null;
        }

        return ((NBTShort) tag);
    }

    public boolean isShort(String key) {
        return (value.get(key) instanceof NBTShort);
    }

    public void setShort(String key, short value) {
        set(key, new NBTShort(value));
    }

    public NBTInteger getInteger(String key) {
        NBTBase tag = value.get(key);

        if((tag == null) || !(tag instanceof NBTInteger)) {
            return null;
        }

        return ((NBTInteger) tag);
    }

    public boolean isInteger(String key) {
        return (value.get(key) instanceof NBTInteger);
    }

    public void setInteger(String key, int value) {
        set(key, new NBTInteger(value));
    }

    public NBTIntegerArray getIntegerArray(String key) {
        NBTBase tag = value.get(key);

        if((tag == null) || !(tag instanceof NBTIntegerArray)) {
            return null;
        }

        return ((NBTIntegerArray) tag);
    }

    public boolean isIntegerArray(String key) {
        return (value.get(key) instanceof NBTIntegerArray);
    }

    public void setIntegerArray(String key, int[] value) {
        set(key, new NBTIntegerArray(value));
    }

    public NBTLong getLong(String key) {
        NBTBase tag = value.get(key);

        if((tag == null) || !(tag instanceof NBTLong)) {
            return null;
        }

        return ((NBTLong) tag);
    }

    public boolean isLong(String key) {
        return (value.get(key) instanceof NBTLong);
    }

    public void setLong(String key, long value) {
        set(key, new NBTLong(value));
    }

    public NBTFloat getFloat(String key) {
        NBTBase tag = value.get(key);

        if((tag == null) || !(tag instanceof NBTFloat)) {
            return null;
        }

        return ((NBTFloat) tag);
    }

    public boolean isFloat(String key) {
        return (value.get(key) instanceof NBTFloat);
    }

    public void setFloat(String key, float value) {
        set(key, new NBTFloat(value));
    }

    public NBTDouble getDouble(String key) {
        NBTBase tag = value.get(key);

        if((tag == null) || !(tag instanceof NBTDouble)) {
            return null;
        }

        return ((NBTDouble) tag);
    }

    public boolean isDouble(String key) {
        return (value.get(key) instanceof NBTDouble);
    }

    public void setDouble(String key, double value) {
        set(key, new NBTDouble(value));
    }

    public NBTString getString(String key) {
        NBTBase tag = value.get(key);

        if((tag == null) || !(tag instanceof NBTString)) {
            return null;
        }

        return ((NBTString) tag);
    }

    public boolean isString(String key) {
        return (value.get(key) instanceof NBTString);
    }

    public void setString(String key, String value) {
        set(key, new NBTString(value));
    }

    public abstract ItemStack write(ItemStack stack);

    public abstract AbstractNBTCompound read(ItemStack stack);

}
