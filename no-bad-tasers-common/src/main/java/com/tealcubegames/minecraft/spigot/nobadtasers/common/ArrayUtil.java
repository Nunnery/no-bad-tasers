package com.tealcubegames.minecraft.spigot.nobadtasers.common;

/*
 * MIT License
 *
 * Copyright (c) 2016
 *
 * Permission is hereby granted, free of charge, to any person obtaining a copy
 * of this software and associated documentation files (the "Software"), to deal
 * in the Software without restriction, including without limitation the rights
 * to use, copy, modify, merge, publish, distribute, sublicense, and/or sell
 * copies of the Software, and to permit persons to whom the Software is
 * furnished to do so, subject to the following conditions:
 *
 * The above copyright notice and this permission notice shall be included in all
 * copies or substantial portions of the Software.
 *
 * THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
 * IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,
 * FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE
 * AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
 * LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
 * OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN THE
 * SOFTWARE.
 */

public class ArrayUtil {
    private ArrayUtil() {
    }

    public static int[] asPrimitiveIntegerArray(Integer[] integers) {
        int[] primitives = new int[integers.length];

        for (int index = 0; index < integers.length; index++) {
            primitives[index] = integers[index];
        }

        return primitives;
    }

    public static Integer[] asWrapperIntegerArray(int[] integers) {
        Integer[] wrappers = new Integer[integers.length];

        for (int index = 0; index < integers.length; index++) {
            wrappers[index] = integers[index];
        }

        return wrappers;
    }

    public static byte[] asPrimitiveByteArray(Byte[] bytes) {
        byte[] primitives = new byte[bytes.length];

        for (int index = 0; index < bytes.length; index++) {
            primitives[index] = bytes[index];
        }

        return primitives;
    }

    public static Byte[] asWrapperByteArray(byte[] bytes) {
        Byte[] wrappers = new Byte[bytes.length];

        for (int index = 0; index < bytes.length; index++) {
            wrappers[index] = bytes[index];
        }

        return wrappers;
    }
}